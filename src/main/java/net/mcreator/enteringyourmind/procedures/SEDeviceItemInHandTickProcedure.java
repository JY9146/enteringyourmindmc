package net.mcreator.enteringyourmind.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.enteringyourmind.init.EnteringyourmindModItems;

public class SEDeviceItemInHandTickProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getDamageValue() < 1) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(EnteringyourmindModItems.ELEMENT_GUN.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
	}
}
