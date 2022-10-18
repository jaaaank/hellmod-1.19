package core.init;

import com.jank.hellmod.EnhancedHell;

import com.jank.hellmod.common.entity.BloodDevil;
import com.jank.hellmod.common.entity.ChaosDevil;
import com.jank.hellmod.common.entity.Reaper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
public class EntityInit {

	public static final DeferredRegister<EntityType<?>> ENTITIES =
			DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, EnhancedHell.MODID);
	
	public static final RegistryObject<EntityType<Reaper>> REAPER = ENTITIES.register("reaper",
					() -> EntityType.Builder.of(Reaper::new, MobCategory.MONSTER).fireImmune().sized(0.85f, 2.0f)
				.canSpawnFarFromPlayer()
				.build(new ResourceLocation(EnhancedHell.MODID, "reaper").toString()));
	
	public static final RegistryObject<EntityType<BloodDevil>> BLOOD_DEVIL = ENTITIES.register("blood_devil",
			() -> EntityType.Builder.of(BloodDevil::new, MobCategory.MONSTER).fireImmune().sized(1.0f, 1.0f)
				.canSpawnFarFromPlayer()
				.build(new ResourceLocation(EnhancedHell.MODID, "blood_devil").toString()));
	
	public static final RegistryObject<EntityType<ChaosDevil>> CHAOS_DEVIL = ENTITIES.register("chaos_devil",
			() -> EntityType.Builder.of(ChaosDevil::new, MobCategory.MONSTER).fireImmune().sized(0.95f, 2.95f)
				.canSpawnFarFromPlayer()
				.build(new ResourceLocation(EnhancedHell.MODID, "chaos_devil").toString()));

	public static void register(IEventBus eventBus) {
		ENTITIES.register(eventBus);
	}

}

