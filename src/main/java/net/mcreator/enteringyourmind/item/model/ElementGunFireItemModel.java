package net.mcreator.enteringyourmind.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.enteringyourmind.item.ElementGunFireItem;

public class ElementGunFireItemModel extends GeoModel<ElementGunFireItem> {
	@Override
	public ResourceLocation getAnimationResource(ElementGunFireItem animatable) {
		return new ResourceLocation("enteringyourmind", "animations/elementgunfire.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ElementGunFireItem animatable) {
		return new ResourceLocation("enteringyourmind", "geo/elementgunfire.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ElementGunFireItem animatable) {
		return new ResourceLocation("enteringyourmind", "textures/item/elementgunfiremode.png");
	}
}
