
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.enteringyourmind.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.enteringyourmind.item.TitaniumiteItem;
import net.mcreator.enteringyourmind.item.TitaniumItemmItem;
import net.mcreator.enteringyourmind.item.SEDeviceItem;
import net.mcreator.enteringyourmind.item.MetalRodItem;
import net.mcreator.enteringyourmind.item.ElementGunWaterItem;
import net.mcreator.enteringyourmind.item.ElementGunItem;
import net.mcreator.enteringyourmind.item.ElementGunFireItem;
import net.mcreator.enteringyourmind.item.ElementGunEarthItem;
import net.mcreator.enteringyourmind.item.ElementGunAirItem;
import net.mcreator.enteringyourmind.EnteringyourmindMod;

public class EnteringyourmindModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, EnteringyourmindMod.MODID);
	public static final RegistryObject<Item> DREAMLAND_BLOCK = block(EnteringyourmindModBlocks.DREAMLAND_BLOCK);
	public static final RegistryObject<Item> SE_DEVICE = REGISTRY.register("se_device", () -> new SEDeviceItem());
	public static final RegistryObject<Item> METAL_ROD = REGISTRY.register("metal_rod", () -> new MetalRodItem());
	public static final RegistryObject<Item> TITANIUMITE = REGISTRY.register("titaniumite", () -> new TitaniumiteItem());
	public static final RegistryObject<Item> TITANIUM = block(EnteringyourmindModBlocks.TITANIUM);
	public static final RegistryObject<Item> TITANIUM_ITEMM = REGISTRY.register("titanium_itemm", () -> new TitaniumItemmItem());
	public static final RegistryObject<Item> ELEMENT_GUN = REGISTRY.register("element_gun", () -> new ElementGunItem());
	public static final RegistryObject<Item> ELEMENT_GUN_FIRE = REGISTRY.register("element_gun_fire", () -> new ElementGunFireItem());
	public static final RegistryObject<Item> ELEMENT_GUN_WATER = REGISTRY.register("element_gun_water", () -> new ElementGunWaterItem());
	public static final RegistryObject<Item> ELEMENT_GUN_EARTH = REGISTRY.register("element_gun_earth", () -> new ElementGunEarthItem());
	public static final RegistryObject<Item> ELEMENT_GUN_AIR = REGISTRY.register("element_gun_air", () -> new ElementGunAirItem());

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
