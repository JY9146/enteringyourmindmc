
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.enteringyourmind.init;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import net.mcreator.enteringyourmind.EnteringyourmindMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EnteringyourmindModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EnteringyourmindMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
			tabData.accept(EnteringyourmindModBlocks.DREAMLAND_BLOCK.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(EnteringyourmindModItems.SE_DEVICE.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {
			tabData.accept(EnteringyourmindModItems.ELEMENT_GUN.get());
			tabData.accept(EnteringyourmindModItems.ELEMENT_GUN_FIRE.get());
			tabData.accept(EnteringyourmindModItems.ELEMENT_GUN_WATER.get());
			tabData.accept(EnteringyourmindModItems.ELEMENT_GUN_EARTH.get());
			tabData.accept(EnteringyourmindModItems.ELEMENT_GUN_AIR.get());
		}
	}
}
