package net.mcreator.enteringyourmind.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.enteringyourmind.item.ElementGunItem;

public class ElementGunItemModel extends GeoModel<ElementGunItem> {
	@Override
	public ResourceLocation getAnimationResource(ElementGunItem animatable) {
		return new ResourceLocation("enteringyourmind", "animations/elementgun.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ElementGunItem animatable) {
		return new ResourceLocation("enteringyourmind", "geo/elementgun.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ElementGunItem animatable) {
		return new ResourceLocation("enteringyourmind", "textures/item/texture.png");
	}
}
