package core.custom.item;

import java.util.function.Supplier;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class BaseToolMaterial implements Tier {
	
	private final float attackDamageBonus, speed;
	private final int enchantability, harvestLevel, durability;
	private final Supplier<Ingredient> repairMaterial;

	public BaseToolMaterial(float attackDamageBonus, int enchantability, int harvestLevel, float speed,
			int durability, Supplier<Ingredient> repairMaterial) {
		this.attackDamageBonus = attackDamageBonus;
		this.enchantability = enchantability;
		this.harvestLevel = harvestLevel;
		this.speed = speed;
		this.durability = durability;
		this.repairMaterial = repairMaterial;
		
	}
	
	
	@Override
	public int getUses() {
		// TODO Auto-generated method stub
		return this.durability;
	}

	@Override
	public float getSpeed() {
		// TODO Auto-generated method stub
		return this.speed;
	}

	@Override
	public float getAttackDamageBonus() {
		// TODO Auto-generated method stub
		return this.attackDamageBonus;
	}

	@Override
	public int getLevel() {
		// TODO Auto-generated method stub
		return this.harvestLevel;
	}

	@Override
	public int getEnchantmentValue() {
		// TODO Auto-generated method stub
		return this.enchantability;
	}

	@Override
	public Ingredient getRepairIngredient() {
		// TODO Auto-generated method stub
		return this.repairMaterial.get();
	}

}
