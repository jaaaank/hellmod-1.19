package com.jank.hellmod.common.entity;

import java.util.Random;

import com.jank.hellmod.EnhancedHell;
import core.custom.DevilType;
import core.init.ItemInit;
import core.init.SoundInit;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class Reaper extends WitherSkeleton implements IAnimatable {

	private AnimationFactory factory = new AnimationFactory(this);
	private static final ResourceLocation LOOT_TABLE = new ResourceLocation(EnhancedHell.MODID, "entities/reaper");

	public Reaper(EntityType<? extends AbstractSkeleton> entityType, Level level) {
		super((EntityType<? extends WitherSkeleton>) entityType, level);
		this.maxUpStep = 1.0F;
		this.xpReward = 10;
		this.makeBoundingBox();
		this.noCulling = true;
	}

	public static AttributeSupplier setAttributes() {
		return Monster.createMobAttributes()
				.add(Attributes.MAX_HEALTH, 22.0D)
				.add(Attributes.ATTACK_DAMAGE, 7.0D)
				.add(Attributes.ATTACK_SPEED, 1.0f)
				.add(Attributes.MOVEMENT_SPEED, 0.225D)
				.add(Attributes.FOLLOW_RANGE, 25.0D).build();
	}

	protected void populateDefaultEquipmentSlots(RandomSource p_219154_, DifficultyInstance p_219155_) {
		this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ItemInit.SCYTHE.get()));
	}
	protected void populateDefaultEquipmentEnchantments(RandomSource p_219157_, DifficultyInstance p_219158_) {
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
		this.addBehaviourGoals();
	}

	private void addBehaviourGoals() {
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, false));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, SnowGolem.class, true));
		this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, true));
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Animal.class, true));
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, BloodDevil.class, true));
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, ChaosDevil.class, true));
		// this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, ///all
		// the other devils///.class, true));

	}

	public MobType getMobType() {
		return DevilType.DEVIL;
	}



	   protected SoundEvent getAmbientSound() {
		      return SoundEvents.WITHER_SKELETON_AMBIENT;
		   }

		   protected SoundEvent getHurtSound(DamageSource p_34195_) {
		      return SoundEvents.WITHER_SKELETON_HURT;
		   }

		   protected SoundEvent getDeathSound() {
		      return SoundEvents.WITHER_SKELETON_DEATH;
		   }

		   protected SoundEvent getStepSound() {
		      return SoundEvents.WITHER_SKELETON_STEP;
		   }


	private <P extends IAnimatable> PlayState predicate(AnimationEvent<P> event) {
		if (!(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F)) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("reaper_walk", true));
		} else {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("reaper_idle", true));
		}
		return PlayState.CONTINUE;
	}

	protected float getStandingEyeHeight(Pose p_30409_, EntityDimensions p_30410_) {
		return p_30410_.height * 0.85F;
	}

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController(this, "controller",
				0, this::predicate));
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}

}
