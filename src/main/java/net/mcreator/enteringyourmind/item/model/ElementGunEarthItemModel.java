package net.mcreator.enteringyourmind.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.enteringyourmind.item.ElementGunEarthItem;

public class ElementGunEarthItemModel extends GeoModel<ElementGunEarthItem> {
	@Override
	public ResourceLocation getAnimationResource(ElementGunEarthItem animatable) {
		return new ResourceLocation("enteringyourmind", "animations/elementgunearth.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ElementGunEarthItem animatable) {
		return new ResourceLocation("enteringyourmind", "geo/elementgunearth.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ElementGunEarthItem animatable) {
		return new ResourceLocation("enteringyourmind", "textures/item/elementgunearthmode.png");
	}
}
