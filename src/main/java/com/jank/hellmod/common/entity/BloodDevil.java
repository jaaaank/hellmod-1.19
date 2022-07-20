package com.jank.hellmod.common.entity;

import java.util.Random;

import com.jank.hellmod.EnhancedHell;
import core.custom.DevilType;
import core.init.SoundInit;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class BloodDevil extends Monster implements IAnimatable {

	private AnimationFactory factory = new AnimationFactory(this);
	private static final ResourceLocation LOOT_TABLE = new ResourceLocation(EnhancedHell.MODID, "entities/blood_devil");

	public BloodDevil(EntityType<? extends Monster> entityType, Level level) {
		super(entityType, level);
		this.maxUpStep = 1.0F;
		this.xpReward = 10;
		this.makeBoundingBox();
		this.noCulling = true;
	}

	public static AttributeSupplier setAttributes() {
		return Monster.createMobAttributes()
				.add(Attributes.MAX_HEALTH, 15.0D)
				.add(Attributes.ATTACK_DAMAGE, 3.0D)
				.add(Attributes.ATTACK_SPEED, 2.0f)
				.add(Attributes.MOVEMENT_SPEED, 0.55D)
				.add(Attributes.FOLLOW_RANGE, 30.0D).build();
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
		this.goalSelector.addGoal(3, new LeapAtTargetGoal(this, 0.4F));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, SnowGolem.class, true));
		this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, true));
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Animal.class, true));
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Reaper.class, true));
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, ChaosDevil.class, true));
		// this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, ///all
		// the other devils///.class, true));

	}


	protected SoundEvent getAmbientSound() {
		return SoundInit.BLOOD_DEVIL_AMBIENT.get();
	}

	public MobType getMobType() {
		return DevilType.DEVIL;
	}

	protected SoundEvent getHurtSound(DamageSource source) {
		return SoundInit.BLOOD_DEVIL_HURT.get();
	}

	protected SoundEvent getDeathSound() {
		return SoundInit.BLOOD_DEVIL_DEATH.get();
	}


	protected float getStandingEyeHeight(Pose p_30409_, EntityDimensions p_30410_) {
		return p_30410_.height * 0.8F;
	}

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		if (event.isMoving()) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("blood_devil_walk", true));
			return PlayState.CONTINUE;
		}

		event.getController().setAnimation(new AnimationBuilder().addAnimation("blood_devil_idle", true));
		return PlayState.CONTINUE;
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
