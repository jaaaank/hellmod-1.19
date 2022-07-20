package com.jank.hellmod.client.renderer.model;

import com.jank.hellmod.EnhancedHell;
import com.jank.hellmod.common.entity.BloodDevil;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class BloodDevilGeoModel extends AnimatedGeoModel<BloodDevil> {

	@Override
	public ResourceLocation getModelResource(BloodDevil object) {
		return new ResourceLocation(EnhancedHell.MODID, "geo/blood_devil.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BloodDevil object) {
		return new ResourceLocation(EnhancedHell.MODID, "textures/entities/blood_devil.png");
	}

	@Override
	public ResourceLocation getAnimationResource(BloodDevil object) {
		return new ResourceLocation(EnhancedHell.MODID, "animations/blood_devil.animation.json");
	}

	@Override
	public void setLivingAnimations(BloodDevil entity, Integer uniqueID, AnimationEvent customPredicate) {
		super.setLivingAnimations(entity, uniqueID, customPredicate);
		IBone head = this.getAnimationProcessor().getBone("head");

		LivingEntity entityIn = (LivingEntity) entity;
		EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
		head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
		head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
	}
}