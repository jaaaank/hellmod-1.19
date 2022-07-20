package com.jank.hellmod.common.entity;

import java.util.Random;
import java.util.UUID;
import java.util.function.Predicate;

import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.SitWhenOrderedToGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NonTameRandomTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class Bunker extends TamableAnimal implements NeutralMob, IAnimatable {
	private static final EntityDataAccessor<Boolean> DATA_INTERESTED_ID = SynchedEntityData.defineId(Bunker.class,
			EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Integer> DATA_COLLAR_COLOR = SynchedEntityData.defineId(Wolf.class,
			EntityDataSerializers.INT);

	private static final EntityDataAccessor<Integer> DATA_REMAINING_ANGER_TIME = SynchedEntityData
			.defineId(Bunker.class, EntityDataSerializers.INT);
	public static final Predicate<LivingEntity> PREY_SELECTOR = (p_30437_) -> {
		EntityType<?> entitytype = p_30437_.getType();
		return entitytype == EntityType.SHEEP || entitytype == EntityType.RABBIT || entitytype == EntityType.FOX;
	};
	private float interestedAngle;
	private float interestedAngleO;
	private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(20, 39);
	@Nullable
	private UUID persistentAngerTarget;

	private AnimationFactory factory = new AnimationFactory(this);
	
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_INTERESTED_ID, false);
		this.entityData.define(DATA_COLLAR_COLOR, DyeColor.RED.getId());

		this.entityData.define(DATA_REMAINING_ANGER_TIME, 0);
	}

	public static AttributeSupplier setAttributes() {
		return Mob.createMobAttributes()
				.add(Attributes.MAX_HEALTH, 1000.0D)
				.add(Attributes.ATTACK_DAMAGE, 300.0D)
				.add(Attributes.ATTACK_SPEED, 2.0f)
				.add(Attributes.MOVEMENT_SPEED, 0.55D).build();
	}

	public Bunker(EntityType<? extends Bunker> entityType, Level level) {
		super((EntityType<? extends Bunker>) entityType, level);
		this.maxUpStep = 1.0F;
		this.xpReward = 10;
		this.makeBoundingBox();
		this.noCulling = false;
		this.setTame(false);
		this.setPathfindingMalus(BlockPathTypes.POWDER_SNOW, -1.0F);
		this.setPathfindingMalus(BlockPathTypes.DANGER_POWDER_SNOW, -1.0F);

	}

	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
		this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, 0.4F));
		this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true));
		this.goalSelector.addGoal(6, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
		this.goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
		this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)).setAlertOthers());
		this.targetSelector.addGoal(4,
				new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, this::isAngryAt));
		this.targetSelector.addGoal(5, new NonTameRandomTargetGoal<>(this, Animal.class, false, PREY_SELECTOR));
		this.targetSelector.addGoal(6,
				new NonTameRandomTargetGoal<>(this, Turtle.class, false, Turtle.BABY_ON_LAND_SELECTOR));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, AbstractSkeleton.class, false));
		this.targetSelector.addGoal(8, new ResetUniversalAngerTargetGoal<>(this, true));

	}

	public void tick() {
		super.tick();
		if (this.isAlive()) {
			this.interestedAngleO = this.interestedAngle;
			if (this.isInterested()) {
				this.interestedAngle += (1.0F - this.interestedAngle) * 0.4F;
			} else {
				this.interestedAngle += (0.0F - this.interestedAngle) * 0.4F;
			}
		}
	}


	public boolean doHurtTarget(Entity p_30372_) {
		boolean flag = p_30372_.hurt(DamageSource.mobAttack(this),
				(float) ((int) this.getAttributeValue(Attributes.ATTACK_DAMAGE)));
		if (flag) {
			this.doEnchantDamageEffects(this, p_30372_);
		}

		return flag;
	}

	public boolean isInterested() {
		return this.entityData.get(DATA_INTERESTED_ID);
	}

	public InteractionResult mobInteract(Player p_30412_, InteractionHand p_30413_) {
		ItemStack itemstack = p_30412_.getItemInHand(p_30413_);
		Item item = itemstack.getItem();
		if (this.level.isClientSide) {
			boolean flag = this.isOwnedBy(p_30412_) || this.isTame()
					|| itemstack.is(Items.BONE) && !this.isTame() && !this.isAngry();
			return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
		} else {
			if (this.isTame()) {
				if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
					if (!p_30412_.getAbilities().instabuild) {
						itemstack.shrink(1);
					}

					this.heal((float) item.getFoodProperties().getNutrition());
					this.gameEvent(GameEvent.ENTITY_INTERACT);
					return InteractionResult.SUCCESS;
				}

				if (!(item instanceof DyeItem)) {
					InteractionResult interactionresult = super.mobInteract(p_30412_, p_30413_);
					if ((!interactionresult.consumesAction() || this.isBaby()) && this.isOwnedBy(p_30412_)) {
						this.setOrderedToSit(!this.isOrderedToSit());
						this.jumping = false;
						this.navigation.stop();
						this.setTarget((LivingEntity) null);
						return InteractionResult.SUCCESS;
					}

					return interactionresult;
				}

				DyeColor dyecolor = ((DyeItem) item).getDyeColor();
				if (dyecolor != this.getCollarColor()) {
					this.setCollarColor(dyecolor);
					if (!p_30412_.getAbilities().instabuild) {
						itemstack.shrink(1);
					}

					return InteractionResult.SUCCESS;
				}
			} else if (itemstack.is(Items.BONE) && !this.isAngry()) {
				if (!p_30412_.getAbilities().instabuild) {
					itemstack.shrink(1);
				}

				if (this.random.nextInt(3) == 0
						&& !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, p_30412_)) {
					this.tame(p_30412_);
					this.navigation.stop();
					this.setTarget((LivingEntity) null);
					this.setOrderedToSit(true);
					this.level.broadcastEntityEvent(this, (byte) 7);
				} else {
					this.level.broadcastEntityEvent(this, (byte) 6);
				}
				return InteractionResult.SUCCESS;
			}
			return super.mobInteract(p_30412_, p_30413_);
		}
	}

	protected float getStandingEyeHeight(Pose p_30409_, EntityDimensions p_30410_) {
		return p_30410_.height * 0.8F;
	}

	public static boolean canSpawn(EntityType<Bunker> entity, LevelAccessor levelAccess, MobSpawnType spawnType,
			BlockPos pos, Random random) {
		return checkAnimalSpawnRules(entity, levelAccess, spawnType, pos, RandomSource.create())
				&& levelAccess instanceof final Level level;
	}

	public int getMaxHeadXRot() {
		return this.isInSittingPose() ? 20 : super.getMaxHeadXRot();
	}

	public boolean isFood(ItemStack p_30440_) {
		Item item = p_30440_.getItem();
		return item.isEdible() && item.getFoodProperties().isMeat();
	}

	public void die(DamageSource p_30384_) {
		super.die(p_30384_);
	}

	public boolean hurt(DamageSource p_30386_, float p_30387_) {
		if (this.isInvulnerableTo(p_30386_)) {
			return false;
		} else {
			Entity entity = p_30386_.getEntity();
			if (!this.level.isClientSide) {
				this.setOrderedToSit(false);
			}

			if (entity != null && !(entity instanceof Player) && !(entity instanceof AbstractArrow)) {
				p_30387_ = (p_30387_ + 1.0F) / 2.0F;
			}
			return super.hurt(p_30386_, p_30387_);
		}
	}

	public float getHeadRollAngle(float p_30449_) {
		return Mth.lerp(p_30449_, this.interestedAngleO, this.interestedAngle) * 0.15F * (float) Math.PI;
	}

	public boolean canMate(Animal p_30392_) {
		return false;
	}

	public boolean wantsToAttack(LivingEntity p_30389_, LivingEntity p_30390_) {
		if (!(p_30389_ instanceof Creeper) && !(p_30389_ instanceof Ghast)) {
			if (p_30389_ instanceof Bunker) {
				Bunker bunker = (Bunker) p_30389_;
				return !bunker.isTame() || bunker.getOwner() != p_30390_;
			} else if (p_30389_ instanceof Player && p_30390_ instanceof Player
					&& !((Player) p_30390_).canHarmPlayer((Player) p_30389_)) {
				return false;
			} else if (p_30389_ instanceof AbstractHorse && ((AbstractHorse) p_30389_).isTamed()) {
				return false;
			} else {
				return !(p_30389_ instanceof TamableAnimal) || !((TamableAnimal) p_30389_).isTame();
			}
		} else {
			return false;
		}
	}

	private <P extends IAnimatable> PlayState predicate(AnimationEvent<P> event) {
		if (!(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F)) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("bunker_walk", true));
		} else {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("bunker_idle", true));
		}
		return PlayState.CONTINUE;
	}

	protected void playStepSound(BlockPos p_30415_, BlockState p_30416_) {
		this.playSound(SoundEvents.WOLF_STEP, 0.15F, 1.0F);
	}

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController(this, "controller",
				0, this::predicate));
	}

	public void addAdditionalSaveData(CompoundTag p_30418_) {
		super.addAdditionalSaveData(p_30418_);
		p_30418_.putByte("CollarColor", (byte) this.getCollarColor().getId());
		this.addPersistentAngerSaveData(p_30418_);
	}

	   public void readAdditionalSaveData(CompoundTag p_30402_) {
	      super.readAdditionalSaveData(p_30402_);
	      if (p_30402_.contains("CollarColor", 99)) {
	         this.setCollarColor(DyeColor.byId(p_30402_.getInt("CollarColor")));
	      }

	      this.readPersistentAngerSaveData(this.level, p_30402_);
	   }

	public DyeColor getCollarColor() {
		return DyeColor.byId(this.entityData.get(DATA_COLLAR_COLOR));
	}

	public void setCollarColor(DyeColor p_30398_) {
		this.entityData.set(DATA_COLLAR_COLOR, p_30398_.getId());
	}


	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}

	protected SoundEvent getAmbientSound() {
		return SoundEvents.WOLF_AMBIENT;
	}

	protected SoundEvent getHurtSound(DamageSource p_30424_) {
		return SoundEvents.WOLF_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.WOLF_DEATH;
	}

	protected float getSoundVolume() {
		return 0.4F;
	}

	public void aiStep() {
		super.aiStep();
		if (!this.level.isClientSide) {
			this.updatePersistentAnger((ServerLevel) this.level, true);
		}
	}

	public int getRemainingPersistentAngerTime() {
		return this.entityData.get(DATA_REMAINING_ANGER_TIME);
	}

	public void setRemainingPersistentAngerTime(int p_30404_) {
		this.entityData.set(DATA_REMAINING_ANGER_TIME, p_30404_);
	}

	public void startPersistentAngerTimer() {
		this.setRemainingPersistentAngerTime(PERSISTENT_ANGER_TIME.sample(this.random));
	}

	@Nullable
	public UUID getPersistentAngerTarget() {
		return this.persistentAngerTarget;
	}

	public void setPersistentAngerTarget(@Nullable UUID p_30400_) {
		this.persistentAngerTarget = p_30400_;
	}

	public boolean canBeLeashed(Player p_30396_) {
		return !this.isAngry() && super.canBeLeashed(p_30396_);
	}

	public Vec3 getLeashOffset() {
		return new Vec3(0.0D, (double) (0.6F * this.getEyeHeight()), (double) (this.getBbWidth() * 0.4F));
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
		return null;
	}

}
