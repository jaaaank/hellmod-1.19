package core.init;

import com.jank.hellmod.EnhancedHell;
import core.custom.item.BaseArmorMaterial;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public final class ArmorMaterialInit {
	public static final ArmorMaterial IRIDIUM = new BaseArmorMaterial(20, new int [] {390, 500, 550, 450},
			new int [] {3, 6, 8, 3}, .0125f, 1.0f, EnhancedHell.MODID + ":iridium",
			SoundEvents.ARMOR_EQUIP_GENERIC, () -> Ingredient.of(ItemInit.IRIDIUM_INGOT.get()));
	
	public static final ArmorMaterial OBSIDIAN = new BaseArmorMaterial(0, new int [] {30, 70, 60, 50}, 
			new int [] {2, 6, 6, 3}, .25f, 1.0f, EnhancedHell.MODID + ":obsidian",
			SoundEvents.ARMOR_EQUIP_GENERIC, () -> Ingredient.of(Items.BARRIER));

	public static final ArmorMaterial DRESS = new BaseArmorMaterial(5, new int [] {55, 80, 75, 65}, 
			new int [] {1, 2, 2, 1}, 0.0f, 0.0f, EnhancedHell.MODID + ":dress", 
			SoundEvents.ARMOR_EQUIP_GENERIC, () -> Ingredient.of(Items.STRING));

	public static final ArmorMaterial DEVIL = new BaseArmorMaterial(20, new int [] {410, 560, 590, 450},
			new int [] {3, 6, 7, 3}, .0125f, 1.0f, EnhancedHell.MODID + ":devil",
			SoundEvents.ARMOR_EQUIP_GENERIC, () -> Ingredient.of(ItemInit.CRYSTALLIZED_DEVIL_BLOOD_BLOCK_ITEM.get()));

	private ArmorMaterialInit() {		
	}
}
