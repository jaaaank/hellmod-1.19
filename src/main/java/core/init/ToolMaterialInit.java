package core.init;

import core.custom.item.BaseToolMaterial;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class ToolMaterialInit {
	protected static final Tier DEVIL = new BaseToolMaterial(0.0f, 18, 4, 10.5f, 950, 
			() -> Ingredient.of(ItemInit.DEVIL_HEART.get()));
	
	protected static final Tier IRIDIUM = new BaseToolMaterial(0.0f, 25, 4, 9.5f, 750, 
			() -> Ingredient.of(ItemInit.IRIDIUM_INGOT.get()));
	
	private ToolMaterialInit() {
	}
}
