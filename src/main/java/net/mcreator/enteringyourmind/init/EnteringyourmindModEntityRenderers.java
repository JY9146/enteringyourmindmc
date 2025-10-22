
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.enteringyourmind.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.enteringyourmind.client.renderer.InvisWaterRenderer;
import net.mcreator.enteringyourmind.client.renderer.InvisMagicRenderer;
import net.mcreator.enteringyourmind.client.renderer.InvisFireRenderer;
import net.mcreator.enteringyourmind.client.renderer.InvisEarthRenderer;
import net.mcreator.enteringyourmind.client.renderer.InvisAirRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EnteringyourmindModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(EnteringyourmindModEntities.INVIS_MAGIC.get(), InvisMagicRenderer::new);
		event.registerEntityRenderer(EnteringyourmindModEntities.INVIS_FIRE.get(), InvisFireRenderer::new);
		event.registerEntityRenderer(EnteringyourmindModEntities.INVIS_WATER.get(), InvisWaterRenderer::new);
		event.registerEntityRenderer(EnteringyourmindModEntities.INVIS_EARTH.get(), InvisEarthRenderer::new);
		event.registerEntityRenderer(EnteringyourmindModEntities.INVIS_AIR.get(), InvisAirRenderer::new);
	}
}
