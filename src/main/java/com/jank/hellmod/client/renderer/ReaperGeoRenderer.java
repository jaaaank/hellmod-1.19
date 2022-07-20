package com.jank.hellmod.client.renderer;

import com.jank.hellmod.EnhancedHell;
import com.jank.hellmod.client.renderer.model.ReaperGeoModel;
import com.jank.hellmod.common.entity.BloodDevil;
import com.jank.hellmod.common.entity.Reaper;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class ReaperGeoRenderer extends GeoEntityRenderer<Reaper> {
	public ReaperGeoRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new ReaperGeoModel());
		this.shadowRadius = 0.5F; // change 0.7 to the desired shadow size.
	}
	@Override
	public ResourceLocation getTextureLocation(Reaper instance){
		return new ResourceLocation(EnhancedHell.MODID, "textures/entities/reaper.png");
	}

	@Override
	public RenderType getRenderType(Reaper animatable, float partialTicks, PoseStack stack,
									MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
									ResourceLocation textureLocation) {
		stack.scale(1.0F, 1.0F, 1.0F);
		return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
	}
}