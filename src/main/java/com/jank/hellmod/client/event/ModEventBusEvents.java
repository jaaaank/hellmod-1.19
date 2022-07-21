package com.jank.hellmod.client.event;
import com.jank.hellmod.EnhancedHell;
import com.jank.hellmod.client.armor.DevilArmorRenderer;
import com.jank.hellmod.common.entity.BloodDevil;
import com.jank.hellmod.common.entity.Bunker;
import com.jank.hellmod.common.entity.ChaosDevil;
import com.jank.hellmod.common.entity.Reaper;
import core.custom.item.DevilArmorItem;
import core.init.EntityInit;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = EnhancedHell.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(EntityInit.BLOOD_DEVIL.get(), BloodDevil.setAttributes());
        event.put(EntityInit.BUNKER.get(), Bunker.setAttributes());
        event.put(EntityInit.CHAOS_DEVIL.get(), ChaosDevil.setAttributes());
        event.put(EntityInit.REAPER.get(), Reaper.setAttributes());
    }

}
