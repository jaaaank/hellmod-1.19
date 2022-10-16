package com.jank.hellmod;

import com.jank.hellmod.client.renderer.BloodDevilGeoRenderer;
import com.jank.hellmod.client.renderer.ChaosDevilGeoRenderer;
import com.jank.hellmod.client.renderer.ReaperGeoRenderer;
import com.mojang.logging.LogUtils;
import core.init.BlockInit;
import core.init.EntityInit;
import core.init.ItemInit;
import core.init.SoundInit;
import core.world.biomemods.ModBiomeModifiers;
import core.world.feature.ModPlacedFeatures;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;


@Mod(EnhancedHell.MODID)
public class EnhancedHell {
    public static final String MODID = "hellmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public EnhancedHell() {
        GeckoLib.initialize();
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        var bus = FMLJavaModLoadingContext.get().getModEventBus();
        SoundInit.SOUNDS.register(bus);
        BlockInit.BLOCKS.register(bus);
        ItemInit.ITEMS.register(bus);
        EntityInit.ENTITIES.register(bus);
        ModBiomeModifiers.register(bus);
        ModPlacedFeatures.register(bus);
        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() ->{
            SpawnPlacements.register(EntityInit.BLOOD_DEVIL.get(),
                    SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.WORLD_SURFACE,
                    Monster::checkMonsterSpawnRules);

            SpawnPlacements.register(EntityInit.CHAOS_DEVIL.get(),
                    SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.WORLD_SURFACE,
                    Monster::checkMonsterSpawnRules);

            SpawnPlacements.register(EntityInit.REAPER.get(),
                    SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.WORLD_SURFACE,
                    Monster::checkMonsterSpawnRules);

        });
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(EntityInit.BLOOD_DEVIL.get(), BloodDevilGeoRenderer::new);
            EntityRenderers.register(EntityInit.CHAOS_DEVIL.get(), ChaosDevilGeoRenderer::new);
            EntityRenderers.register(EntityInit.REAPER.get(), ReaperGeoRenderer::new);
        }
    }
}
