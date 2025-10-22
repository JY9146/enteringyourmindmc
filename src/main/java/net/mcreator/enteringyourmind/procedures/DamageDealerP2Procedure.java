package net.mcreator.enteringyourmind.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.enteringyourmind.entity.InvisEarthEntity;
import net.mcreator.enteringyourmind.EnteringyourmindMod;

import java.util.List;
import java.util.Comparator;

public class DamageDealerP2Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double particleRadius = 0;
		double particleAmount = 0;
		BlockState BlockAir = Blocks.AIR.defaultBlockState();
		int horizontalRadiusSphere = (int) 4 - 1;
		int verticalRadiusSphere = (int) 2 - 1;
		int yIterationsSphere = verticalRadiusSphere;
		for (int yi = -yIterationsSphere; yi <= yIterationsSphere; yi++) {
			for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
				for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
					double distanceSq = (xi * xi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere) + (yi * yi) / (double) (verticalRadiusSphere * verticalRadiusSphere)
							+ (zi * zi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere);
					if (distanceSq <= 1.0) {
						BlockAir = (world.getBlockState(BlockPos.containing(x + xi, y + yi, z + zi)));
						if (BlockAir.getBlock() == Blocks.AIR) {
							if (Math.random() < 0.4 && Blocks.FIRE.defaultBlockState().canSurvive(world, BlockPos.containing(x + xi, y + yi, z + zi))) {
								world.setBlock(BlockPos.containing(x + xi, y + yi, z + zi), Blocks.FIRE.defaultBlockState(), 3);
							}
						}
						{
							final Vec3 _center = new Vec3(x + xi, y + yi, z + zi);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (!(entityiterator instanceof Player) && !(entityiterator instanceof InvisEarthEntity)) {
									entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.IN_FIRE)), 1);
									entityiterator.setSecondsOnFire(15);
									if (Math.random() < 0.2) {
										entityiterator.setDeltaMovement(new Vec3(0, 0, 0));
									}
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
