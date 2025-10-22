package net.mcreator.enteringyourmind.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.enteringyourmind.item.ElementGunWaterItem;

public class ElementGunWaterItemModel extends GeoModel<ElementGunWaterItem> {
	@Override
	public ResourceLocation getAnimationResource(ElementGunWaterItem animatable) {
		return new ResourceLocation("enteringyourmind", "animations/elementgunwater.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ElementGunWaterItem animatable) {
		return new ResourceLocation("enteringyourmind", "geo/elementgunwater.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ElementGunWaterItem animatable) {
		return new ResourceLocation("enteringyourmind", "textures/item/elementgunwatermode.png");
	}
}
