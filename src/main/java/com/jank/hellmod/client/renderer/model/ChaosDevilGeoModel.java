package com.jank.hellmod.client.renderer.model;

import com.jank.hellmod.EnhancedHell;
import com.jank.hellmod.common.entity.ChaosDevil;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class ChaosDevilGeoModel extends AnimatedGeoModel<ChaosDevil> {

	@Override
	public ResourceLocation getModelResource(ChaosDevil object) {
		return new ResourceLocation(EnhancedHell.MODID, "geo/chaos_devil.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ChaosDevil object) {
		return new ResourceLocation(EnhancedHell.MODID, "textures/entities/chaos_devil.png");
	}

	@Override
	public ResourceLocation getAnimationResource(ChaosDevil object) {
		return new ResourceLocation(EnhancedHell.MODID, "animations/chaos_devil.animation.json");
	}

	@Override
	public void setLivingAnimations(ChaosDevil entity, Integer uniqueID, AnimationEvent customPredicate) {
		super.setLivingAnimations(entity, uniqueID, customPredicate);
		IBone head = this.getAnimationProcessor().getBone("head");

		LivingEntity entityIn = (LivingEntity) entity;
		EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
		head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
		head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
	}
}