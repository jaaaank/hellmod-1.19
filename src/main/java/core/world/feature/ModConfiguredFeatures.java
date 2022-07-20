package core.world.feature;

import core.init.BlockInit;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RuleTest BLACKSTONE = new BlockMatchTest(Blocks.BLACKSTONE);
    public static final RuleTest POLISHED_BLACKSTONE_BRICKS = new BlockMatchTest(Blocks.POLISHED_BLACKSTONE_BRICKS);
    public static final RuleTest CRACKED_POLISHED_BLACKSTONE_BRICKS = new BlockMatchTest(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS);
    public static final RuleTest BASALT = new BlockMatchTest(Blocks.BASALT);

    public static final List<OreConfiguration.TargetBlockState> NETHER_RUST_ORE = List.of(
            OreConfiguration.target(OreFeatures.NETHERRACK, BlockInit.RUST_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> NETHER_IRIDIUM_ORE = List.of(
            OreConfiguration.target(BLACKSTONE, BlockInit.IRIDIUM_ORE.get().defaultBlockState()),
            OreConfiguration.target(CRACKED_POLISHED_BLACKSTONE_BRICKS, BlockInit.IRIDIUM_ORE.get().defaultBlockState()),
            OreConfiguration.target(POLISHED_BLACKSTONE_BRICKS, BlockInit.IRIDIUM_ORE.get().defaultBlockState()));


    public static final List<OreConfiguration.TargetBlockState> NETHER_OBSIDIAN_ORE = List.of(
            OreConfiguration.target(BLACKSTONE, Blocks.OBSIDIAN.defaultBlockState()),
            OreConfiguration.target(BASALT, Blocks.OBSIDIAN.defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> RUST_ORE = FeatureUtils.register("rust_ore",
            Feature.ORE, new OreConfiguration(NETHER_RUST_ORE, 10));
                                                                              //9 IS MAX VEIN SIZE
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> IRIDIUM_ORE = FeatureUtils.register("iridium_ore",
            Feature.ORE, new OreConfiguration(NETHER_IRIDIUM_ORE, 4));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> OBSIDIAN_ORE = FeatureUtils.register("obsidian_ore",
            Feature.ORE, new OreConfiguration(NETHER_OBSIDIAN_ORE, 20));
}
