package net.mcreator.enteringyourmind.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.registries.Registries;

import net.mcreator.enteringyourmind.entity.InvisAirEntity;
import net.mcreator.enteringyourmind.EnteringyourmindMod;

import java.util.List;
import java.util.Comparator;

public class DamageDealerP5Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double DifX = 0;
		double DifY = 0;
		double DifZ = 0;
		double root = 0;
		entity.getPersistentData().putDouble("tagName", (entity.getPersistentData().getDouble("tagName") + 1));
		int horizontalRadiusSphere = (int) 7 - 1;
		int verticalRadiusSphere = (int) 2 - 1;
		int yIterationsSphere = verticalRadiusSphere;
		for (int yi = -yIterationsSphere; yi <= yIterationsSphere; yi++) {
			for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
				for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
					double distanceSq = (xi * xi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere) + (yi * yi) / (double) (verticalRadiusSphere * verticalRadiusSphere)
							+ (zi * zi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere);
					if (distanceSq <= 1.0) {
						{
							final Vec3 _center = new Vec3(x + xi, y + yi, z + zi);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(7 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (!(entityiterator instanceof Player) && !(entityiterator instanceof InvisAirEntity)) {
									entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.IN_WALL)), (float) 0.25);
									DifX = entity.getX() - entityiterator.getX();
									DifY = entity.getY() - entityiterator.getY();
									DifZ = entity.getZ() - entityiterator.getZ();
									root = Math.sqrt(Math.pow(DifX, 2) + Math.pow(DifY, 2) + Math.pow(DifZ, 2));
									entityiterator.setDeltaMovement(new Vec3((Math.pow(DifX / root, 1) * (-1)), (Math.pow(DifY / root, 1) * (-1)), (Math.pow(DifZ / root, 1) * (-1))));
								}
							}
						}
						EnteringyourmindMod.queueServerWork(200, () -> {
							if (!entity.level().isClientSide())
								entity.discard();
						});
					}
				}
			}
		}
	}
}
