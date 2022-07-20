package core.init;

import com.jank.hellmod.EnhancedHell;

import core.custom.CoagulatedBloodBlock;
import core.custom.RustOre;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class BlockInit {
	
	private BlockInit() {}
	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, EnhancedHell.MODID);
	
	//BASIC BLOCKS
	public static final RegistryObject<Block> CRYSTALLIZED_DEVIL_BLOOD_BLOCK = BLOCKS.register("crystallized_devil_blood_block", () ->
		new Block(BlockBehaviour.Properties.of(Material.AMETHYST, MaterialColor.COLOR_RED).sound(SoundType.CALCITE)));

	public static final RegistryObject<Block> IRIDIUM_BLOCK = BLOCKS.register("iridium_block", () ->
		new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_RED).strength(3.0f, 3.0f).sound(SoundType.METAL).requiresCorrectToolForDrops()));	
	
	
	//ORE BLOCKS
	public static final RegistryObject<RustOre> RUST_ORE = BLOCKS.register("rust_ore", () ->
		new RustOre(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_RED).strength(3.0f, 3.0f).sound(SoundType.METAL).requiresCorrectToolForDrops()));
	
	public static final RegistryObject<DropExperienceBlock> IRIDIUM_ORE = BLOCKS.register("iridium_ore", () ->
		new DropExperienceBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BLACK).strength(3.0f, 3.0f).sound(SoundType.METAL).requiresCorrectToolForDrops()));

	
	//RAW ORE BLOCKS
	public static final RegistryObject<Block> RAW_RUST_BLOCK = BLOCKS.register("raw_rust_block", () ->
		new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_RED).strength(3.0f, 3.0f).sound(SoundType.METAL).requiresCorrectToolForDrops()));

	public static final RegistryObject<Block> RAW_IRIDIUM_BLOCK = BLOCKS.register("raw_iridium_block", () ->
		new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_RED).strength(3.0f, 3.0f).sound(SoundType.METAL).requiresCorrectToolForDrops()));

	//COOL BLOCKS
	public static final RegistryObject<CoagulatedBloodBlock> COAGULATED_DEVIL_BLOOD_BLOCK = BLOCKS.register("coagulated_devil_blood_block", () ->
		new CoagulatedBloodBlock(BlockBehaviour.Properties.of(Material.CLAY, MaterialColor.COLOR_RED).speedFactor(0.4F).jumpFactor(0.5F).sound(SoundType.HONEY_BLOCK)));

}
