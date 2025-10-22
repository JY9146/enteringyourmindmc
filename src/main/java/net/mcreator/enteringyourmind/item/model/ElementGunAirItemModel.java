package net.mcreator.enteringyourmind.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.enteringyourmind.item.ElementGunAirItem;

public class ElementGunAirItemModel extends GeoModel<ElementGunAirItem> {
	@Override
	public ResourceLocation getAnimationResource(ElementGunAirItem animatable) {
		return new ResourceLocation("enteringyourmind", "animations/elementgunair.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ElementGunAirItem animatable) {
		return new ResourceLocation("enteringyourmind", "geo/elementgunair.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ElementGunAirItem animatable) {
		return new ResourceLocation("enteringyourmind", "textures/item/elementgunairmode.png");
	}
}
