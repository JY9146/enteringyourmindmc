package net.mcreator.enteringyourmind.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.registries.Registries;

import net.mcreator.enteringyourmind.entity.InvisMagicEntity;
import net.mcreator.enteringyourmind.EnteringyourmindMod;

import java.util.List;
import java.util.Comparator;

public class DamageDealerP1Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double particleRadius = 0;
		double particleAmount = 0;
		double RandomNum = 0;
		entity.getPersistentData().putDouble("tagName", (entity.getPersistentData().getDouble("tagName") + 1));
		int horizontalRadiusSphere = (int) 5 - 1;
		int verticalRadiusSphere = (int) 3 - 1;
		int yIterationsSphere = verticalRadiusSphere;
		for (int yi = -yIterationsSphere; yi <= yIterationsSphere; yi++) {
			for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
				for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
					double distanceSq = (xi * xi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere) + (yi * yi) / (double) (verticalRadiusSphere * verticalRadiusSphere)
							+ (zi * zi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere);
					if (distanceSq <= 1.0) {
						{
							final Vec3 _center = new Vec3(x + xi, y + yi, z + zi);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (!(entityiterator instanceof Player) && !(entityiterator instanceof InvisMagicEntity)) {
									entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC)), (float) 2.5);
									if (entity.getPersistentData().getDouble("tagName") > 40) {
										RandomNum = Mth.nextInt(RandomSource.create(), 1, 15);
										if (RandomNum == 1) {
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.BAD_OMEN, 20, 1));
										} else if (RandomNum == 2) {
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 20, 1));
										} else if (RandomNum == 3) {
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 20, 1));
										} else if (RandomNum == 4) {
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 20, 1));
										} else if (RandomNum == 5) {
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 20, 1));
										} else if (RandomNum == 6) {
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.HARM, 20, 1));
										} else if (RandomNum == 7) {
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 20, 1));
										} else if (RandomNum == 8) {
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 20, 1));
										} else if (RandomNum == 9) {
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 20, 1));
										} else if (RandomNum == 10) {
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 20, 1));
										} else if (RandomNum == 11) {
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 20, 1));
										} else if (RandomNum == 12) {
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 1));
										} else if (RandomNum == 13) {
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.UNLUCK, 20, 1));
										} else if (RandomNum == 14) {
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 20, 1));
										} else {
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 20, 1));
										}
										entity.getPersistentData().putDouble("tagName", 0);
									}
									if (Math.random() < 0.5) {
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
