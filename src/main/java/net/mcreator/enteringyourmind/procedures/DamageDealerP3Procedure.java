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

import net.mcreator.enteringyourmind.entity.InvisWaterEntity;
import net.mcreator.enteringyourmind.EnteringyourmindMod;

import java.util.List;
import java.util.Comparator;

public class DamageDealerP3Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double particleRadius = 0;
		double particleAmount = 0;
		BlockState BlockAir = Blocks.AIR.defaultBlockState();
		int horizontalRadiusSphere = (int) 6 - 1;
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
							if (Math.random() < 0.000005 && Blocks.WATER.defaultBlockState().canSurvive(world, BlockPos.containing(x + xi, y + yi, z + zi))) {
								world.setBlock(BlockPos.containing(x + xi, y + yi, z + zi), Blocks.WATER.defaultBlockState(), 3);
							} else if (Math.random() < 0.000005 && Blocks.POWDER_SNOW.defaultBlockState().canSurvive(world, BlockPos.containing(x + xi, y + yi, z + zi))) {
								world.setBlock(BlockPos.containing(x + xi, y + yi, z + zi), Blocks.POWDER_SNOW.defaultBlockState(), 3);
							} else if (Math.random() < 0.000005 && Blocks.ICE.defaultBlockState().canSurvive(world, BlockPos.containing(x + xi, y + yi, z + zi))) {
								world.setBlock(BlockPos.containing(x + xi, y + yi, z + zi), Blocks.ICE.defaultBlockState(), 3);
							}
						}
						{
							final Vec3 _center = new Vec3(x + xi, y + yi, z + zi);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (!(entityiterator instanceof Player) && !(entityiterator instanceof InvisWaterEntity)) {
									entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.DROWN)), 1);
									entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.FREEZE)), 1);
									entityiterator.setTicksFrozen(200);
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
