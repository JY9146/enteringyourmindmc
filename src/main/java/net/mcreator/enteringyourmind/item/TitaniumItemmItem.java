
package net.mcreator.enteringyourmind.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class TitaniumItemmItem extends Item {
	public TitaniumItemmItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
