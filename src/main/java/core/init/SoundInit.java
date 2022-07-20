package core.init;

import com.jank.hellmod.EnhancedHell;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class SoundInit {
	
	public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, EnhancedHell.MODID);
	
		//BLOOD DEVIL
	public static final RegistryObject<SoundEvent> BLOOD_DEVIL_AMBIENT = SOUNDS.register("entity.blood_devil.ambient", 
			()-> new SoundEvent(new ResourceLocation(EnhancedHell.MODID, "entity.blood_devil.ambient")));

	public static final RegistryObject<SoundEvent> BLOOD_DEVIL_HURT = SOUNDS.register("entity.blood_devil.hurt", 
			()-> new SoundEvent(new ResourceLocation(EnhancedHell.MODID, "entity.blood_devil.hurt")));

	public static final RegistryObject<SoundEvent> BLOOD_DEVIL_DEATH = SOUNDS.register("entity.blood_devil.death", 
			()-> new SoundEvent(new ResourceLocation(EnhancedHell.MODID, "entity.blood_devil.death")));

		//REAPER
	public static final RegistryObject<SoundEvent> REAPER_AMBIENT = SOUNDS.register("entity.reaper.ambient", 
			()-> new SoundEvent(new ResourceLocation(EnhancedHell.MODID, "entity.reaper.ambient")));

	public static final RegistryObject<SoundEvent> REAPER_HURT = SOUNDS.register("entity.reaper.hurt", 
			()-> new SoundEvent(new ResourceLocation(EnhancedHell.MODID, "entity.reaper.hurt")));

	public static final RegistryObject<SoundEvent> REAPER_DEATH = SOUNDS.register("entity.reaper.death", 
			()-> new SoundEvent(new ResourceLocation(EnhancedHell.MODID, "entity.reaper.death")));

	public static final RegistryObject<SoundEvent> REAPER_STEP = SOUNDS.register("entity.reaper.step",
			() -> new SoundEvent(new ResourceLocation(EnhancedHell.MODID, "entity.reaper.step")));

		// CHAOS DEVIL
	public static final RegistryObject<SoundEvent> CHAOS_DEVIL_AMBIENT = SOUNDS.register("entity.chaos_devil.ambient",
			() -> new SoundEvent(new ResourceLocation(EnhancedHell.MODID, "entity.chaos_devil.ambient")));

	public static final RegistryObject<SoundEvent> CHAOS_DEVIL_HURT = SOUNDS.register("entity.chaos_devil.hurt",
			() -> new SoundEvent(new ResourceLocation(EnhancedHell.MODID, "entity.chaos_devil.hurt")));

	public static final RegistryObject<SoundEvent> CHAOS_DEVIL_DEATH = SOUNDS.register("entity.chaos_devil.death",
			() -> new SoundEvent(new ResourceLocation(EnhancedHell.MODID, "entity.chaos_devil.death")));;

	private SoundInit() {
	}

}
