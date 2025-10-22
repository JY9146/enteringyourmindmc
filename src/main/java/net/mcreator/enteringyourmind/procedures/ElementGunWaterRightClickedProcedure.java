package net.mcreator.enteringyourmind.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.enteringyourmind.item.ElementGunWaterItem;
import net.mcreator.enteringyourmind.init.EnteringyourmindModParticleTypes;
import net.mcreator.enteringyourmind.init.EnteringyourmindModEntities;

import com.mojang.blaze3d.platform.InputConstants;

public class ElementGunWaterRightClickedProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double particleRadius = 0;
		double particleAmount = 0;
		if (InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), InputConstants.KEY_LSHIFT)) {
			{
				net.minecraft.world.entity.Entity _ent = entity;
				if (!(_ent instanceof net.minecraft.world.entity.player.Player _plr))
					return;
				if (_plr.level().isClientSide())
					return;
				net.minecraft.world.item.Item fromItem = net.minecraftforge.registries.ForgeRegistries.ITEMS.getValue(new net.minecraft.resources.ResourceLocation("enteringyourmind:element_gun_water"));
				net.minecraft.world.item.Item toItem = net.minecraftforge.registries.ForgeRegistries.ITEMS.getValue(new net.minecraft.resources.ResourceLocation("enteringyourmind:element_gun_earth"));
				if (fromItem == null || toItem == null)
					return;
				net.minecraft.world.entity.player.Inventory _inv = _plr.getInventory();
				boolean _changed = false;
				for (int _i = 0; _i < _inv.items.size(); _i++) {
					net.minecraft.world.item.ItemStack _slot = _inv.items.get(_i);
					if (!_slot.isEmpty() && _slot.getItem() == fromItem) {
						int _count = _slot.getCount();
						net.minecraft.world.item.ItemStack _new = new net.minecraft.world.item.ItemStack(toItem);
						if (_slot.hasTag())
							_new.setTag(_slot.getTag().copy());
						_new.setDamageValue(_slot.getDamageValue());
						_new.setCount(_count);
						_inv.items.set(_i, _new);
						_changed = true;
					}
				}
				if (_changed) {
					_inv.setChanged();
					_plr.inventoryMenu.broadcastChanges();
				}
			}
		} else {
			if (itemstack.getItem() instanceof ElementGunWaterItem)
				itemstack.getOrCreateTag().putString("geckoAnim", "animation.elementgunwater.shoot");
			for (int index0 = 0; index0 < 10; index0++) {
				particleAmount = 10;
				particleRadius = 2;
				for (int index1 = 0; index1 < (int) particleAmount; index1++) {
					world.addParticle((SimpleParticleType) (EnteringyourmindModParticleTypes.WATER11.get()), (entity.level()
							.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((3 + Mth.nextInt(RandomSource.create(), 1, 10)))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
							.getBlockPos().getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 0
									+ Mth.nextDouble(RandomSource.create(), 0, 0.5) * particleRadius),
							(entity.level().clip(
									new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((3 + Mth.nextInt(RandomSource.create(), 1, 10)))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
							(Mth.nextDouble(RandomSource.create(), 0, 0.01)), 0, 0);
					world.addParticle((SimpleParticleType) (EnteringyourmindModParticleTypes.WATER_12.get()), (entity.level()
							.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((3 + Mth.nextInt(RandomSource.create(), 1, 10)))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
							.getBlockPos().getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 0
									+ Mth.nextDouble(RandomSource.create(), 0, 0.5) * particleRadius),
							(entity.level().clip(
									new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((3 + Mth.nextInt(RandomSource.create(), 1, 10)))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
							(Mth.nextDouble(RandomSource.create(), 0, 0.01)), 0, 0);
					world.addParticle((SimpleParticleType) (EnteringyourmindModParticleTypes.WATER_13.get()), (entity.level()
							.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((3 + Mth.nextInt(RandomSource.create(), 1, 10)))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
							.getBlockPos().getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 0
									+ Mth.nextDouble(RandomSource.create(), 0, 0.5) * particleRadius),
							(entity.level().clip(
									new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((3 + Mth.nextInt(RandomSource.create(), 1, 10)))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
							(Mth.nextDouble(RandomSource.create(), 0, 0.01)), 0, 0);
					world.addParticle((SimpleParticleType) (EnteringyourmindModParticleTypes.WATER_14.get()), (entity.level()
							.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((3 + Mth.nextInt(RandomSource.create(), 1, 10)))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
							.getBlockPos().getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 0
									+ Mth.nextDouble(RandomSource.create(), 0, 0.5) * particleRadius),
							(entity.level().clip(
									new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((3 + Mth.nextInt(RandomSource.create(), 1, 10)))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
							(Mth.nextDouble(RandomSource.create(), 0, 0.01)), 0, 0);
					world.addParticle((SimpleParticleType) (EnteringyourmindModParticleTypes.WATER_15.get()), (entity.level()
							.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((3 + Mth.nextInt(RandomSource.create(), 1, 10)))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
							.getBlockPos().getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 0
									+ Mth.nextDouble(RandomSource.create(), 0, 0.5) * particleRadius),
							(entity.level().clip(
									new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((3 + Mth.nextInt(RandomSource.create(), 1, 10)))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
							(Mth.nextDouble(RandomSource.create(), 0, 0.01)), 0, 0);
					world.addParticle((SimpleParticleType) (EnteringyourmindModParticleTypes.WATER_16.get()), (entity.level()
							.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((3 + Mth.nextInt(RandomSource.create(), 1, 10)))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
							.getBlockPos().getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 0
									+ Mth.nextDouble(RandomSource.create(), 0, 0.5) * particleRadius),
							(entity.level().clip(
									new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((3 + Mth.nextInt(RandomSource.create(), 1, 10)))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
							(Mth.nextDouble(RandomSource.create(), 0, 0.01)), 0, 0);
					world.addParticle((SimpleParticleType) (EnteringyourmindModParticleTypes.WATER_17.get()), (entity.level()
							.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((3 + Mth.nextInt(RandomSource.create(), 1, 10)))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
							.getBlockPos().getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 0
									+ Mth.nextDouble(RandomSource.create(), 0, 0.5) * particleRadius),
							(entity.level().clip(
									new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((3 + Mth.nextInt(RandomSource.create(), 1, 10)))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
							(Mth.nextDouble(RandomSource.create(), 0, 0.01)), 0, 0);
					world.addParticle((SimpleParticleType) (EnteringyourmindModParticleTypes.WATER_21.get()), (entity.level()
							.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((3 + Mth.nextInt(RandomSource.create(), 1, 10)))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
							.getBlockPos().getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 0
									+ Mth.nextDouble(RandomSource.create(), 0, 0.5) * particleRadius),
							(entity.level().clip(
									new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((3 + Mth.nextInt(RandomSource.create(), 1, 10)))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
							(Mth.nextDouble(RandomSource.create(), 0, 0.01)), 0, 0);
					world.addParticle((SimpleParticleType) (EnteringyourmindModParticleTypes.WATER_22.get()), (entity.level()
							.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((3 + Mth.nextInt(RandomSource.create(), 1, 10)))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
							.getBlockPos().getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 0
									+ Mth.nextDouble(RandomSource.create(), 0, 0.5) * particleRadius),
							(entity.level().clip(
									new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((3 + Mth.nextInt(RandomSource.create(), 1, 10)))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
							(Mth.nextDouble(RandomSource.create(), 0, 0.01)), 0, 0);
					world.addParticle((SimpleParticleType) (EnteringyourmindModParticleTypes.WATER_23.get()), (entity.level()
							.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((3 + Mth.nextInt(RandomSource.create(), 1, 10)))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
							.getBlockPos().getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 0
									+ Mth.nextDouble(RandomSource.create(), 0, 0.5) * particleRadius),
							(entity.level().clip(
									new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((3 + Mth.nextInt(RandomSource.create(), 1, 10)))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
							(Mth.nextDouble(RandomSource.create(), 0, 0.01)), 0, 0);
					world.addParticle((SimpleParticleType) (EnteringyourmindModParticleTypes.WATER_24.get()), (entity.level()
							.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((3 + Mth.nextInt(RandomSource.create(), 1, 10)))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
							.getBlockPos().getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 0
									+ Mth.nextDouble(RandomSource.create(), 0, 0.5) * particleRadius),
							(entity.level().clip(
									new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((3 + Mth.nextInt(RandomSource.create(), 1, 10)))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
							(Mth.nextDouble(RandomSource.create(), 0, 0.01)), 0, 0);
					world.addParticle((SimpleParticleType) (EnteringyourmindModParticleTypes.WATER_25.get()), (entity.level()
							.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((3 + Mth.nextInt(RandomSource.create(), 1, 10)))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
							.getBlockPos().getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 0
									+ Mth.nextDouble(RandomSource.create(), 0, 0.5) * particleRadius),
							(entity.level().clip(
									new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((3 + Mth.nextInt(RandomSource.create(), 1, 10)))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
							(Mth.nextDouble(RandomSource.create(), 0, 0.01)), 0, 0);
					world.addParticle((SimpleParticleType) (EnteringyourmindModParticleTypes.WATER_26.get()), (entity.level()
							.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((3 + Mth.nextInt(RandomSource.create(), 1, 10)))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
							.getBlockPos().getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 0
									+ Mth.nextDouble(RandomSource.create(), 0, 0.5) * particleRadius),
							(entity.level().clip(
									new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((3 + Mth.nextInt(RandomSource.create(), 1, 10)))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
							(Mth.nextDouble(RandomSource.create(), 0, 0.01)), 0, 0);
					world.addParticle((SimpleParticleType) (EnteringyourmindModParticleTypes.ICE.get()), (entity.level()
							.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((3 + Mth.nextInt(RandomSource.create(), 1, 10)))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
							.getBlockPos().getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 0
									+ Mth.nextDouble(RandomSource.create(), 0, 0.5) * particleRadius),
							(entity.level().clip(
									new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((3 + Mth.nextInt(RandomSource.create(), 1, 10)))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
							(Mth.nextDouble(RandomSource.create(), 0, 0.01)), 0, 0);
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = EnteringyourmindModEntities.INVIS_WATER.get().spawn(_level, BlockPos.containing(
						entity.level()
								.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((3 + Mth.nextInt(RandomSource.create(), 1, 10)))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
										entity))
								.getBlockPos().getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius,
						entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 0
								+ Mth.nextDouble(RandomSource.create(), 0, 0.5) * particleRadius,
						entity.level().clip(
								new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((3 + Mth.nextInt(RandomSource.create(), 1, 10)))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
								.getBlockPos().getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
						MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 50);
		}
	}
}
