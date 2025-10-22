package net.mcreator.enteringyourmind.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.enteringyourmind.network.EnteringyourmindModVariables;

public class SwimOnKeyPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player) {
			if ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Num == 0) {
				{
					boolean _setval = true;
					entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Swim = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 1;
					entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Num = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Num == 1) {
				{
					boolean _setval = false;
					entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Swim = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 0;
					entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Num = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
