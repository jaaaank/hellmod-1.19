package com.jank.hellmod.client.event;
import com.jank.hellmod.EnhancedHell;
import com.jank.hellmod.common.entity.BloodDevil;
import com.jank.hellmod.common.entity.ChaosDevil;
import com.jank.hellmod.common.entity.Reaper;
import core.init.EntityInit;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EnhancedHell.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(EntityInit.BLOOD_DEVIL.get(), BloodDevil.setAttributes());
        event.put(EntityInit.CHAOS_DEVIL.get(), ChaosDevil.setAttributes());
        event.put(EntityInit.REAPER.get(), Reaper.setAttributes());
    }

}
