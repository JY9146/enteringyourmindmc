package net.mcreator.enteringyourmind.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.enteringyourmind.entity.InvisEarthEntity;
import net.mcreator.enteringyourmind.EnteringyourmindMod;

import java.util.List;
import java.util.Comparator;

public class DamageDealerP4Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double particleRadius = 0;
		double particleAmount = 0;
		BlockState BlockAir = Blocks.AIR.defaultBlockState();
		int horizontalRadiusSphere = (int) 3 - 1;
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
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (!(entityiterator instanceof Player) && !(entityiterator instanceof InvisEarthEntity)) {
									entityiterator.hurt(
											new DamageSource(
													world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("enteringyourmind:touched_too_much_grass")))),
											(float) 3.5);
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
