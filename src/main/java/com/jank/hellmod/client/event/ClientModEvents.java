package com.jank.hellmod.client.event;

import com.jank.hellmod.EnhancedHell;
import com.jank.hellmod.client.armor.DevilArmorRenderer;
import com.jank.hellmod.client.renderer.BloodDevilGeoRenderer;
import com.jank.hellmod.client.renderer.BunkerGeoRenderer;
import com.jank.hellmod.client.renderer.ChaosDevilGeoRenderer;
import com.jank.hellmod.client.renderer.ReaperGeoRenderer;
import core.custom.item.DevilArmorItem;
import core.init.EntityInit;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

@Mod.EventBusSubscriber(modid = EnhancedHell.MODID, bus = Bus.MOD, value = Dist.CLIENT)
public final class ClientModEvents {
	@SubscribeEvent
	public static void registerArmorRenderers(final EntityRenderersEvent.AddLayers event) {
		GeoArmorRenderer.registerArmorRenderer(DevilArmorItem.class, new DevilArmorRenderer());
	}
	
	@SubscribeEvent
	public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
	}
	
	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(EntityInit.BLOOD_DEVIL.get(), BloodDevilGeoRenderer::new);
		event.registerEntityRenderer(EntityInit.REAPER.get(), ReaperGeoRenderer::new);
		event.registerEntityRenderer(EntityInit.CHAOS_DEVIL.get(), ChaosDevilGeoRenderer::new);
		event.registerEntityRenderer(EntityInit.BUNKER.get(), BunkerGeoRenderer::new);


	}
	
}
