
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.enteringyourmind.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.enteringyourmind.block.TitaniumBlock;
import net.mcreator.enteringyourmind.block.DreamlandBlockBlock;
import net.mcreator.enteringyourmind.EnteringyourmindMod;

public class EnteringyourmindModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, EnteringyourmindMod.MODID);
	public static final RegistryObject<Block> DREAMLAND_BLOCK = REGISTRY.register("dreamland_block", () -> new DreamlandBlockBlock());
	public static final RegistryObject<Block> TITANIUM = REGISTRY.register("titanium", () -> new TitaniumBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
