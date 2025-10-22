
package net.mcreator.enteringyourmind.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.enteringyourmind.entity.InvisAirEntity;

public class InvisAirRenderer extends HumanoidMobRenderer<InvisAirEntity, HumanoidModel<InvisAirEntity>> {
	public InvisAirRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<InvisAirEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(InvisAirEntity entity) {
		return new ResourceLocation("enteringyourmind:textures/entities/super-invisible.png");
	}
}
