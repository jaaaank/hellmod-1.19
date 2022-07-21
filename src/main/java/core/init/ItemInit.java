package core.init;

import com.jank.hellmod.EnhancedHell;
import core.custom.ModArmorItem;
import core.custom.item.*;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ItemInit {
	private ItemInit() {
	}

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			EnhancedHell.MODID);

	

	// BASIC ITEMS
	public static final RegistryObject<Item> COAGULATED_DEVIL_BLOOD = ITEMS.register("coagulated_devil_blood",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS).fireResistant()
					.food(new FoodProperties.Builder().nutrition(1).saturationMod(0.5f).alwaysEat().meat().fast()
							.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.WITHER, 400, 0), 1.0f).build())));

	public static final RegistryObject<Item> REAPER_BONE = ITEMS.register("reaper_bone",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS).fireResistant()));
	public static final RegistryObject<Item> CHAOTIC_EYE = ITEMS.register("chaotic_eye",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS).fireResistant()));
	public static final RegistryObject<Item> CRYSTALLIZED_DEVIL_BLOOD = ITEMS.register("crystallized_devil_blood",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS).fireResistant()));
	public static final RegistryObject<Item> RAW_RUST = ITEMS.register("raw_rust",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS).fireResistant()));
	public static final RegistryObject<Item> RAW_IRIDIUM = ITEMS.register("raw_iridium",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS).fireResistant()));
	public static final RegistryObject<Item> IRIDIUM_INGOT = ITEMS.register("iridium_ingot",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS).fireResistant()));
	public static final RegistryObject<Item> IRIDIUM_NUGGET = ITEMS.register("iridium_nugget",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS).fireResistant()));
	public static final RegistryObject<Item> DIAMOND_SHARD = ITEMS.register("diamond_shard",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<Item> EMERALD_SHARD = ITEMS.register("emerald_shard",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<Item> LAPIS_CHUNK = ITEMS.register("lapis_chunk",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

	
	// TOOLS

			// DEVIL TOOLS
	public static final RegistryObject<AxeItem> CHAINSAW = ITEMS.register("chainsaw",
			() -> new AxeItem(ToolMaterialInit.DEVIL, 10, -3.1f,
					new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).defaultDurability(1500).fireResistant()));
	public static final RegistryObject<HoeItem> SCYTHE = ITEMS.register("scythe",
			() -> new HoeItem(ToolMaterialInit.DEVIL, 6, -2.7f,
					new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).defaultDurability(1500).fireResistant()));
	public static final RegistryObject<ShovelItem> PITCHFORK = ITEMS.register("pitchfork",
			() -> new ShovelItem(ToolMaterialInit.DEVIL, 8, -3.0f,
					new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).defaultDurability(1500).fireResistant()));
	public static final RegistryObject<PickaxeItem> DEMON_PICK = ITEMS.register("demon_pick",
			() -> new PickaxeItem(ToolMaterialInit.DEVIL, 6, -3.0f,
					new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).defaultDurability(1500).fireResistant()));
	public static final RegistryObject<SwordItem> KATANA = ITEMS.register("katana",
			() -> new SwordItem(ToolMaterialInit.DEVIL, 7, -2.0f,
					new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).defaultDurability(1500).fireResistant()));
	
	
			// IRIDIUM TOOLS
	public static final RegistryObject<AxeItem> IRIDIUM_AXE = ITEMS.register("iridium_axe",
			() -> new AxeItem(ToolMaterialInit.IRIDIUM, 8, -2.5f,
					new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).defaultDurability(1000).fireResistant()));
	public static final RegistryObject<PickaxeItem> IRIDIUM_PICKAXE = ITEMS.register("iridium_pickaxe",
			() -> new PickaxeItem(ToolMaterialInit.IRIDIUM, 4, -2.3f,
					new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).defaultDurability(1000).fireResistant()));
	public static final RegistryObject<SwordItem> IRIDIUM_SWORD = ITEMS.register("iridium_sword",
			() -> new SwordItem(ToolMaterialInit.IRIDIUM, 6, -2.2f,
					new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).defaultDurability(1000).fireResistant()));
	public static final RegistryObject<ShovelItem> IRIDIUM_SHOVEL = ITEMS.register("iridium_shovel",
			() -> new ShovelItem(ToolMaterialInit.IRIDIUM, 5, -3.0f,
					new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).defaultDurability(1000).fireResistant()));
	public static final RegistryObject<HoeItem> IRIDIUM_HOE = ITEMS.register("iridium_hoe",
			() -> new HoeItem(ToolMaterialInit.IRIDIUM, 1, -0.0f,
					new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).defaultDurability(1000).fireResistant()));

	
	// ARMOR

			// IRIDIUM ARMOR
	public static final RegistryObject<ArmorItem> IRIDIUM_HELMET = ITEMS.register("iridium_helmet",
			() -> new ModArmorItem(ArmorMaterialInit.IRIDIUM, EquipmentSlot.HEAD,
					new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
	public static final RegistryObject<ArmorItem> IRIDIUM_CHESTPLATE = ITEMS.register("iridium_chestplate",
			() -> new ArmorItem(ArmorMaterialInit.IRIDIUM, EquipmentSlot.CHEST,
					new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
	public static final RegistryObject<ArmorItem> IRIDIUM_LEGGINGS = ITEMS.register("iridium_leggings",
			() -> new ArmorItem(ArmorMaterialInit.IRIDIUM, EquipmentSlot.LEGS,
					new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
	public static final RegistryObject<ArmorItem> IRIDIUM_BOOTS = ITEMS.register("iridium_boots",
			() -> new ArmorItem(ArmorMaterialInit.IRIDIUM, EquipmentSlot.FEET,
					new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()));

	
			// DRESS CLOTHES
	public static final RegistryObject<ArmorItem> DRESS_SHIRT = ITEMS.register("dress_shirt",
			() -> new ArmorItem(ArmorMaterialInit.DRESS, EquipmentSlot.CHEST,
					new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<ArmorItem> DRESS_PANTS = ITEMS.register("dress_pants",
			() -> new ArmorItem(ArmorMaterialInit.DRESS, EquipmentSlot.LEGS,
					new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<ArmorItem> DRESS_SHOES = ITEMS.register("dress_shoes",
			() -> new ArmorItem(ArmorMaterialInit.DRESS, EquipmentSlot.FEET,
					new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

	
			// DEVIL ARMOR
	public static final RegistryObject<ArmorItem> DEVIL_HELMET = ITEMS.register("devil_helmet",
			() -> new DevilArmorItem(ArmorMaterialInit.DEVIL, EquipmentSlot.HEAD,
					new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
	public static final RegistryObject<ArmorItem> BLOOD_DEVIL_HELMET = ITEMS.register("blood_devil_helmet",
			() -> new DevilArmorItem(ArmorMaterialInit.DEVIL, EquipmentSlot.HEAD,
					new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
	public static final RegistryObject<ArmorItem> DEVIL_CHESTPLATE = ITEMS.register("devil_chestplate",
			() -> new DevilArmorItem(ArmorMaterialInit.DEVIL, EquipmentSlot.CHEST,
					new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
	public static final RegistryObject<ArmorItem> DEVIL_LEGGINGS = ITEMS.register("devil_leggings",
			() -> new DevilArmorItem(ArmorMaterialInit.DEVIL, EquipmentSlot.LEGS,
					new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
	public static final RegistryObject<ArmorItem> DEVIL_BOOTS = ITEMS.register("devil_boots",
			() -> new DevilArmorItem(ArmorMaterialInit.DEVIL, EquipmentSlot.FEET,
					new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()));

	
			// OBSIDIAN ARMOR
	public static final RegistryObject<ArmorItem> OBSIDIAN_HELMET = ITEMS.register("obsidian_helmet",
			() -> new ArmorItem(ArmorMaterialInit.OBSIDIAN, EquipmentSlot.HEAD,
					new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant().setNoRepair()));
	public static final RegistryObject<ArmorItem> OBSIDIAN_CHESTPLATE = ITEMS.register("obsidian_chestplate",
			() -> new ArmorItem(ArmorMaterialInit.OBSIDIAN, EquipmentSlot.CHEST,
					new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant().setNoRepair()));
	public static final RegistryObject<ArmorItem> OBSIDIAN_LEGGINGS = ITEMS.register("obsidian_leggings",
			() -> new ArmorItem(ArmorMaterialInit.OBSIDIAN, EquipmentSlot.LEGS,
					new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant().setNoRepair()));
	public static final RegistryObject<ArmorItem> OBSIDIAN_BOOTS = ITEMS.register("obsidian_boots",
			() -> new ArmorItem(ArmorMaterialInit.OBSIDIAN, EquipmentSlot.FEET,
					new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant().setNoRepair()));
	

	// CRAFTING ITEMS
	public static final RegistryObject<Item> SAND_PAPER = ITEMS.register("sandpaper",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<SwordItem> CHAINSAW_BLADE = ITEMS.register("chainsaw_blade",
			() -> new SwordItem(Tiers.IRON, 4, -2.4f, new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<Item> CHAINSAW_HANDLE = ITEMS.register("chainsaw_handle",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<Item> CHAINSAW_ENGINE = ITEMS.register("chainsaw_engine",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS).fireResistant()));
	public static final RegistryObject<SwordItem> SCYTHE_BLADE = ITEMS.register("scythe_blade",
			() -> new SwordItem(Tiers.IRON, 4, -2.4f, new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<Item> SCYTHE_HANDLE = ITEMS.register("scythe_handle",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS).fireResistant()));
	

	// SPAWN EGGS
	public static final RegistryObject<ForgeSpawnEggItem> BLOOD_DEVIL_SPAWN_EGG = ITEMS
			.register("blood_devil_spawn_egg", () -> new ForgeSpawnEggItem(EntityInit.BLOOD_DEVIL, 0x9E2323, 0x330208,
					new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

	public static final RegistryObject<ForgeSpawnEggItem> REAPER_SPAWN_EGG = ITEMS
			.register("reaper_spawn_egg", () -> new ForgeSpawnEggItem(EntityInit.REAPER, 0x141414, 0x0A0000,
					new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

	public static final RegistryObject<ForgeSpawnEggItem> CHAOS_DEVIL_SPAWN_EGG = ITEMS
			.register("chaos_devil_spawn_egg", () -> new ForgeSpawnEggItem(EntityInit.CHAOS_DEVIL, 0x167E86, 0x521810, 
					new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

	// FOOD ITEMS
	public static final RegistryObject<Item> DEVIL_HEART = ITEMS.register("devil_heart",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS).fireResistant()
					.food(new FoodProperties.Builder().nutrition(5).saturationMod(4.0f).alwaysEat().meat()
							.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 6000, 1), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 400, 0), .5f)
							.effect(() -> new MobEffectInstance(MobEffects.WITHER, 400, 0), .5f).build())));
	
		// LESSER APPLES
	public static final RegistryObject<Item> LESSER_DIAMOND_APPLE = ITEMS.register("lesser_diamond_apple",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).fireResistant()
					.food(new FoodProperties.Builder().nutrition(8).saturationMod(8.0f).alwaysEat()
							.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 1200, 2), 1.0f).build())));

	public static final RegistryObject<Item> LESSER_IRON_APPLE = ITEMS.register("lesser_iron_apple",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).fireResistant()
					.food(new FoodProperties.Builder().nutrition(8).saturationMod(8.0f).alwaysEat()
							.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 400, 0), 0.75f)
							.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 500, 1), 1.0f).build())));

	public static final RegistryObject<Item> LESSER_IRIDIUM_APPLE = ITEMS.register("lesser_iridium_apple",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).fireResistant()
					.food(new FoodProperties.Builder().nutrition(8).saturationMod(8.0f).alwaysEat()
							.effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1200, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 0), 1.0f).build())));

	public static final RegistryObject<Item> LESSER_EMERALD_APPLE = ITEMS.register("lesser_emerald_apple",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).fireResistant()
					.food(new FoodProperties.Builder().nutrition(8).saturationMod(8.0f).alwaysEat()
							.effect(() -> new MobEffectInstance(MobEffects.LUCK, 12000, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 1200, 0), 0.75f).build())));

	public static final RegistryObject<Item> LESSER_LAPIS_APPLE = ITEMS.register("lesser_lapis_apple",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).fireResistant()
					.food(new FoodProperties.Builder().nutrition(8).saturationMod(8.0f).alwaysEat()
							.effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 1200, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 1200, 0), 1.0f).build())));

	public static final RegistryObject<Item> LESSER_NETHERITE_APPLE = ITEMS.register("lesser_netherite_apple",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).fireResistant()
					.food(new FoodProperties.Builder().nutrition(8).saturationMod(8.0f).alwaysEat()
							.effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 400, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.CONDUIT_POWER, 400, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 400, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 400, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 400, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 400, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.GLOWING, 400, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 1, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 400, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 400, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.JUMP, 400, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.LEVITATION, 400, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.LUCK, 400, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 400, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.SATURATION, 10, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 400, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 400, 0), 1.0f).build())));

	public static final RegistryObject<Item> LESSER_DEVIL_APPLE = ITEMS.register("lesser_devil_apple",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).fireResistant()
					.food(new FoodProperties.Builder().nutrition(8).saturationMod(8.0f).alwaysEat()
							.effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1200, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 0), 1.0f).build())));

	public static final RegistryObject<Item> LESSER_GOLDEN_APPLE = ITEMS.register("lesser_golden_apple",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).fireResistant()
					.food(new FoodProperties.Builder().nutrition(8).saturationMod(8.0f).alwaysEat()
							.effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 1200, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 0), 1.0f).build())));

	public static final RegistryObject<Item> LESSER_REDSTONE_APPLE = ITEMS.register("lesser_redstone_apple",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).fireResistant()
					.food(new FoodProperties.Builder().nutrition(8).saturationMod(8.0f).alwaysEat()
							.effect(() -> new MobEffectInstance(MobEffects.GLOWING, 1200, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 600, 0), 1.0f).build())));

	
	
		// NORMAL APPLES
	public static final RegistryObject<Item> DIAMOND_APPLE = ITEMS.register("diamond_apple",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).fireResistant()
					.food(new FoodProperties.Builder().nutrition(8).saturationMod(8.0f).alwaysEat()
							.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 200, 2), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 2400, 4), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2400, 0), 1.0f).build())));

	public static final RegistryObject<Item> IRON_APPLE = ITEMS.register("iron_apple",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).fireResistant()
					.food(new FoodProperties.Builder().nutrition(8).saturationMod(8.0f).alwaysEat()
							.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 1), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 600, 1), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 600, 0), 0.5f)
							.effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 600, 0), 0.5f).build())));

	public static final RegistryObject<Item> IRIDIUM_APPLE = ITEMS.register("iridium_apple",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).fireResistant()
					.food(new FoodProperties.Builder().nutrition(8).saturationMod(8.0f).alwaysEat()
							.effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 2400, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 1), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 1200, 0), 1.0f).build())));

	public static final RegistryObject<Item> EMERALD_APPLE = ITEMS.register("emerald_apple",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).fireResistant()
					.food(new FoodProperties.Builder().nutrition(8).saturationMod(8.0f).alwaysEat()
							.effect(() -> new MobEffectInstance(MobEffects.LUCK, 120000, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 600, 0), 0.66f)
							.effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 2400, 1), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.JUMP, 600, 0), 0.75f).build())));

	public static final RegistryObject<Item> LAPIS_APPLE = ITEMS.register("lapis_apple",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).fireResistant()
					.food(new FoodProperties.Builder().nutrition(8).saturationMod(8.0f).alwaysEat()
							.effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 3600, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 600, 0), 0.75f)
							.effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 3000, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.CONDUIT_POWER, 1200, 0), 1.0f).build())));
	
	public static final RegistryObject<Item> REDSTONE_APPLE = ITEMS.register("redstone_apple",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD)
					.food(new FoodProperties.Builder().nutrition(8).saturationMod(8.0f).alwaysEat()
							.effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 4800, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 1200, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.GLOWING, 1200, 0), 0.75f).build())));

	public static final RegistryObject<Item> NETHERITE_APPLE = ITEMS.register("netherite_apple",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).fireResistant()
					.food(new FoodProperties.Builder().nutrition(8).saturationMod(8.0f).alwaysEat()
							.effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 4000, 5), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.CONDUIT_POWER, 4000, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 4000, 1), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 4000, 2), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 4000, 1), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 4000, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 4000, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.GLOWING, 4000, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 1), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 1, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 4000, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 4000, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.JUMP, 4000, 1), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.LEVITATION, 4000, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.LUCK, 4000, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 1), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 4000, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 4000, 1), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.SATURATION, 100, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 4000, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 4000, 0), 1.0f).build())));
	
	public static final RegistryObject<Item> POISON_APPLE = ITEMS.register("poison_apple",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).fireResistant()
					.food(new FoodProperties.Builder().nutrition(8).saturationMod(8.0f).alwaysEat()
							.effect(() -> new MobEffectInstance(MobEffects.POISON, 300, 2), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 300, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.HUNGER, 300, 2), .5f).build())));

	public static final RegistryObject<Item> DEVIL_APPLE = ITEMS.register("devil_apple",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).fireResistant()
					.food(new FoodProperties.Builder().nutrition(8).saturationMod(8.0f).alwaysEat()
							.effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 2400, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1500, 1), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.WITHER, 200, 0), 0.666f).build())));

	
	
		//GREATER APPLES
	public static final RegistryObject<GreaterDiamondApple> GREATER_DIAMOND_APPLE = ITEMS.register("greater_diamond_apple",
			() -> new GreaterDiamondApple(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).fireResistant()
					.food(new FoodProperties.Builder().nutrition(8).saturationMod(8.0f).alwaysEat()
							.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 300, 3), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 6000, 4), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2400, 0), 0.5f)
							.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 3600, 1), 1.0f).build())));

	public static final RegistryObject<GreaterIronApple> GREATER_IRON_APPLE = ITEMS.register("greater_iron_apple",
			() -> new GreaterIronApple(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).fireResistant()
					.food(new FoodProperties.Builder().nutrition(8).saturationMod(8.0f).alwaysEat()
							.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2400, 2), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1200, 1), 0.9f)
							.effect(() -> new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 1200, 0), 0.4f)
							.effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 1200, 0), 0.5f).build())));

	public static final RegistryObject<GreaterIridiumApple> GREATER_IRIDIUM_APPLE = ITEMS.register("greater_iridium_apple",
			() -> new GreaterIridiumApple(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).fireResistant()
					.food(new FoodProperties.Builder().nutrition(8).saturationMod(8.0f).alwaysEat()
							.effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 3600, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 1), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 3000, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3000, 2), 1.0f).build())));

	public static final RegistryObject<GreaterEmeraldApple> GREATER_EMERALD_APPLE = ITEMS.register("greater_emerald_apple",
			() -> new GreaterEmeraldApple(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).fireResistant()
					.food(new FoodProperties.Builder().nutrition(8).saturationMod(8.0f).alwaysEat()
							.effect(() -> new MobEffectInstance(MobEffects.LUCK, 360000, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 600, 0), 0.5f)
							.effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 3600, 2), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.JUMP, 1200, 1), 1.0f).build())));

	public static final RegistryObject<GreaterLapisApple> GREATER_LAPIS_APPLE = ITEMS.register("greater_lapis_apple",
			() -> new GreaterLapisApple(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).fireResistant()
					.food(new FoodProperties.Builder().nutrition(8).saturationMod(8.0f).alwaysEat()
							.effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 6000, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 1200, 0), 0.7f)
							.effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 6000, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.CONDUIT_POWER, 4800, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 6000, 0), 1.0f).build())));

	public static final RegistryObject<GreaterNetheriteApple> GREATER_NETHERITE_APPLE = ITEMS.register("greater_netherite_apple",
			() -> new GreaterNetheriteApple(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).fireResistant()
					.food(new FoodProperties.Builder().nutrition(8).saturationMod(8.0f).alwaysEat()
							.effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 60000, 9), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.CONDUIT_POWER, 60000, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60000, 1), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60000, 2), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 60000, 1), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 60000, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 60000, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.GLOWING, 60000, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 3), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 1, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 60000, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 60000, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.JUMP, 60000, 1), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.LEVITATION, 200, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.LUCK, 60000, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 6000, 1), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 60000, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 60000, 1), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.SATURATION, 100, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 60000, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 60000, 0), 1.0f).build())));

	public static final RegistryObject<GreaterDevilApple> GREATER_DEVIL_APPLE = ITEMS.register("greater_devil_apple",
			() -> new GreaterDevilApple(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).fireResistant()
					.food(new FoodProperties.Builder().nutrition(8).saturationMod(8.0f).alwaysEat()
							.effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 4800, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3000, 2), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2400, 1), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.WITHER, 400, 0), 0.666f).build())));

	public static final RegistryObject<GreaterRedstoneApple> GREATER_REDSTONE_APPLE = ITEMS.register("greater_redstone_apple",
			() -> new GreaterRedstoneApple(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).fireResistant()
					.food(new FoodProperties.Builder().nutrition(8).saturationMod(8.0f).alwaysEat()
							.effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 12000, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 3600, 1), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 3600, 0), 1.0f)
							.effect(() -> new MobEffectInstance(MobEffects.GLOWING, 13600, 0), 0.75f).build())));
	
	
	// BLOCK ITEMS
	public static final RegistryObject<BlockItem> COAGULATED_DEVIL_BLOOD_BLOCK_ITEM = ITEMS
			.register("coagulated_devil_blood_block", () -> new BlockItem(BlockInit.COAGULATED_DEVIL_BLOOD_BLOCK.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS).fireResistant()));

	public static final RegistryObject<BlockItem> CRYSTALLIZED_DEVIL_BLOOD_BLOCK_ITEM = ITEMS.register(
			"crystallized_devil_blood_block", () -> new BlockItem(BlockInit.CRYSTALLIZED_DEVIL_BLOOD_BLOCK.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS).fireResistant()));

	public static final RegistryObject<BlockItem> RUST_ORE_BLOCK_ITEM = ITEMS.register("rust_ore",
			() -> new BlockItem(BlockInit.RUST_ORE.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS).fireResistant()));

	public static final RegistryObject<BlockItem> RAW_RUST_BLOCK_ITEM = ITEMS.register("raw_rust_block",
			() -> new BlockItem(BlockInit.RAW_RUST_BLOCK.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS).fireResistant()));

	public static final RegistryObject<BlockItem> IRIDIUM_ORE_BLOCK_ITEM = ITEMS.register("iridium_ore",
			() -> new BlockItem(BlockInit.IRIDIUM_ORE.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS).fireResistant()));

	public static final RegistryObject<BlockItem> RAW_IRIDIUM_BLOCK_ITEM = ITEMS.register("raw_iridium_block",
			() -> new BlockItem(BlockInit.RAW_IRIDIUM_BLOCK.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS).fireResistant()));

	public static final RegistryObject<BlockItem> IRIDIUM_BLOCK_ITEM = ITEMS.register("iridium_block",
			() -> new BlockItem(BlockInit.IRIDIUM_BLOCK.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS).fireResistant()));

}
