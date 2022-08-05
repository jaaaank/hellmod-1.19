package core.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HalfTransparentBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;



//fuck this shit i have no idea what half of it means
//i just copied over the honey block shit and changed some of it i have no fucking clue what half of it does
//i tried to make it do particles when you slide down it but for some reason it only fucking spawned the honey particles

//update after trying to make it transparent like honey blocks: fuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthisfuckthis

public class CoagulatedBloodBlock extends HalfTransparentBlock {
	
	   private static final double SLIDE_STARTS_WHEN_VERTICAL_SPEED_IS_AT_LEAST = 0.13D;
	   private static final double MIN_FALL_SPEED_TO_BE_CONSIDERED_SLIDING = 0.08D;
	   private static final double THROTTLE_SLIDE_SPEED_TO = 0.05D;
	   protected static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 15.0D, 15.0D);

	   public CoagulatedBloodBlock(Properties p_53985_) {
	      super(p_53985_);

	   }
	   private static boolean doesEntityDoHoneyBlockSlideEffects(Entity p_54013_) {
	      return p_54013_ instanceof LivingEntity || p_54013_ instanceof AbstractMinecart || p_54013_ instanceof PrimedTnt || p_54013_ instanceof Boat;
	   }

	   public VoxelShape getCollisionShape(BlockState p_54015_, BlockGetter p_54016_, BlockPos p_54017_, CollisionContext p_54018_) {
	      return SHAPE;
	   }

	   public void fallOn(Level p_153372_, BlockState p_153373_, BlockPos p_153374_, Entity p_153375_, float p_153376_) {
	      p_153375_.playSound(SoundEvents.HONEY_BLOCK_SLIDE, 1.0F, 1.0F);

	      if (p_153375_.causeFallDamage(p_153376_, 0.2F, DamageSource.FALL)) {
	         p_153375_.playSound(this.soundType.getFallSound(), this.soundType.getVolume() * 0.5F, this.soundType.getPitch() * 0.75F);
	      }

	   }

	   public void entityInside(BlockState p_54003_, Level p_54004_, BlockPos p_54005_, Entity p_54006_) {
	      if (this.isSlidingDown(p_54005_, p_54006_)) {
	         this.doSlideMovement(p_54006_);
	         this.maybeDoSlideEffects(p_54004_, p_54006_);
	      }
	   }

	   private boolean isSlidingDown(BlockPos p_54008_, Entity p_54009_) {
	      if (p_54009_.isOnGround()) {
	         return false;
	      } else if (p_54009_.getY() > (double)p_54008_.getY() + 0.9375D - 1.0E-7D) {
	         return false;
	      } else if (p_54009_.getDeltaMovement().y >= -0.08D) {
	         return false;
	      } else {
	         double d0 = Math.abs((double)p_54008_.getX() + 0.5D - p_54009_.getX());
	         double d1 = Math.abs((double)p_54008_.getZ() + 0.5D - p_54009_.getZ());
	         double d2 = 0.4375D + (double)(p_54009_.getBbWidth() / 2.0F);
	         return d0 + 1.0E-7D > d2 || d1 + 1.0E-7D > d2;
	      }
	   }


	   private void doSlideMovement(Entity p_54020_) {
	      Vec3 vec3 = p_54020_.getDeltaMovement();
	      if (vec3.y < -0.13D) {
	         double d0 = -0.05D / vec3.y;
	         p_54020_.setDeltaMovement(new Vec3(vec3.x * d0, -0.05D, vec3.z * d0));
	      } else {
	         p_54020_.setDeltaMovement(new Vec3(vec3.x, -0.05D, vec3.z));
	      }

	      p_54020_.resetFallDistance();
	   }

	   private void maybeDoSlideEffects(Level p_53995_, Entity p_53996_) {
	      if (doesEntityDoHoneyBlockSlideEffects(p_53996_)) {
	         if (p_53995_.random.nextInt(5) == 0) {
	            p_53996_.playSound(SoundEvents.HONEY_BLOCK_SLIDE, 1.0F, 1.0F);
	            
	         }
	      }
	   }
	}