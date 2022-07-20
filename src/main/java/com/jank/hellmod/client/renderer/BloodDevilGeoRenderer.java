package com.jank.hellmod.client.renderer;
import com.jank.hellmod.EnhancedHell;
import com.jank.hellmod.client.renderer.model.BloodDevilGeoModel;
import com.jank.hellmod.common.entity.BloodDevil;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class BloodDevilGeoRenderer extends GeoEntityRenderer<BloodDevil> {
	public BloodDevilGeoRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new BloodDevilGeoModel());
		this.shadowRadius = 0.5F; // change 0.7 to the desired shadow size.
	}

	@Override
	public ResourceLocation getTextureLocation(BloodDevil instance){
		return new ResourceLocation(EnhancedHell.MODID, "textures/entities/blood_devil.png");
	}

	@Override
	public RenderType getRenderType(BloodDevil animatable, float partialTicks, PoseStack stack,
									MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
									ResourceLocation textureLocation) {
		stack.scale(1.0F, 1.0F, 1.0F);
		return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
	}
}