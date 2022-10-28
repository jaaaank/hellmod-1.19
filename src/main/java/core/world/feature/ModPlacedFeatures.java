package core.world.feature;

import com.jank.hellmod.EnhancedHell;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, EnhancedHell.MODID);

    public static final RegistryObject<PlacedFeature> RUST_ORE_PLACED = PLACED_FEATURES.register("rust_ore_placed",
            ()-> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?, ?>>)
                    ModConfiguredFeatures.RUST_ORE, ModOrePlacement.commonOrePlacement(40, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(0), VerticalAnchor.aboveBottom(121)))));

    public static final RegistryObject<PlacedFeature> IRIDIUM_ORE_PLACED = PLACED_FEATURES.register("iridium_ore_placed",
            ()-> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?, ?>>)
                    ModConfiguredFeatures.IRIDIUM_ORE, ModOrePlacement.commonOrePlacement(35, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(0), VerticalAnchor.aboveBottom(121)))));

    public static final RegistryObject<PlacedFeature> OBSIDIAN_ORE_PLACED = PLACED_FEATURES.register("obsidian_ore_placed",
            ()-> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?, ?>>)
                    ModConfiguredFeatures.OBSIDIAN_ORE, ModOrePlacement.commonOrePlacement(50, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(0), VerticalAnchor.aboveBottom(121)))));

    public static void register(IEventBus eventBus){
        PLACED_FEATURES.register(eventBus);
    }


}