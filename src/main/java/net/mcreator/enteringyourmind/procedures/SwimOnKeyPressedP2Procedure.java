package net.mcreator.enteringyourmind.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.Entity;

import net.mcreator.enteringyourmind.network.EnteringyourmindModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SwimOnKeyPressedP2Procedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Swim) {
			entity.setPose(Pose.SWIMMING);
		}
	}
}
