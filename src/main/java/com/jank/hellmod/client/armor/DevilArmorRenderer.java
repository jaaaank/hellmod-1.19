package com.jank.hellmod.client.armor;

import core.custom.item.DevilArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class DevilArmorRenderer extends GeoArmorRenderer<DevilArmorItem> {
    public DevilArmorRenderer() {
        super(new DevilArmorModel());

        this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorRightArm";
        this.leftArmBone = "armorLeftArm";
        this.rightLegBone = "armorRightLeg";
        this.leftLegBone = "armorLeftLeg";
        this.rightBootBone = "armorRightBoot";
        this.leftBootBone = "armorLeftBoot";
    }
}
