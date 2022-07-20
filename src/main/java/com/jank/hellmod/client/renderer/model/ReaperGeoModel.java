package com.jank.hellmod.client.renderer.model;

import com.jank.hellmod.EnhancedHell;
import com.jank.hellmod.common.entity.Reaper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class ReaperGeoModel extends AnimatedGeoModel<Reaper> {

	@Override
	public ResourceLocation getModelResource(Reaper object) {
		return new ResourceLocation(EnhancedHell.MODID, "geo/reaper.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(Reaper object) {
		return new ResourceLocation(EnhancedHell.MODID, "textures/entities/reaper.png");
	}

	@Override
	public ResourceLocation getAnimationResource(Reaper object) {
		return new ResourceLocation(EnhancedHell.MODID, "animations/reaper.animation.json");
	}

	@Override
	public void setLivingAnimations(Reaper entity, Integer uniqueID, AnimationEvent customPredicate) {
		super.setLivingAnimations(entity, uniqueID, customPredicate);
		IBone head = this.getAnimationProcessor().getBone("head");

		LivingEntity entityIn = (LivingEntity) entity;
		EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
		head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
		head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
	}
}