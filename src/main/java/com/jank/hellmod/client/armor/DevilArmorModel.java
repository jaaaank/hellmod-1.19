package com.jank.hellmod.client.armor;

import com.jank.hellmod.EnhancedHell;
import core.custom.item.DevilArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DevilArmorModel extends AnimatedGeoModel<DevilArmorItem> {
    @Override
    public ResourceLocation getModelResource(DevilArmorItem object) {
        return new ResourceLocation(EnhancedHell.MODID, "geo/devil_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DevilArmorItem object) {
        return new ResourceLocation(EnhancedHell.MODID, "textures/models/armor/devil_armor.json");
    }

    @Override
    public ResourceLocation getAnimationResource(DevilArmorItem animatable) {
        return new ResourceLocation(EnhancedHell.MODID, "animations/armor_animation.json");
    }
}
