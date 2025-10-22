package net.mcreator.enteringyourmind.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.enteringyourmind.network.EnteringyourmindModVariables;

public class SubconsciousPlayerLeavesDimensionProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		{
			Entity _ent = entity;
			_ent.teleportTo(((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).XCoord),
					((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Ycoord),
					((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).ZCoord));
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport(((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).XCoord),
						((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Ycoord),
						((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).ZCoord), _ent.getYRot(), _ent.getXRot());
		}
		if (Math.ceil(world.dayTime() / 24000) == 0) {
			if (world instanceof ServerLevel _level)
				_level.setDayTime(24000);
			{
				ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
				if (_ist.hurt(1, RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
		} else if (Math.ceil(world.dayTime() / 24000) == 1) {
			if (world instanceof ServerLevel _level)
				_level.setDayTime(48000);
			{
				ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
				if (_ist.hurt(1, RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
		} else if (Math.ceil(world.dayTime() / 24000) == 2) {
			if (world instanceof ServerLevel _level)
				_level.setDayTime(72000);
			{
				ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
				if (_ist.hurt(1, RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
		} else if (Math.ceil(world.dayTime() / 24000) == 3) {
			if (world instanceof ServerLevel _level)
				_level.setDayTime(96000);
			{
				ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
				if (_ist.hurt(1, RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
		} else if (Math.ceil(world.dayTime() / 24000) == 4) {
			if (world instanceof ServerLevel _level)
				_level.setDayTime(120000);
			{
				ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
				if (_ist.hurt(1, RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
		} else if (Math.ceil(world.dayTime() / 24000) == 5) {
			if (world instanceof ServerLevel _level)
				_level.setDayTime(144000);
			{
				ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
				if (_ist.hurt(1, RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
		} else if (Math.ceil(world.dayTime() / 24000) == 6) {
			if (world instanceof ServerLevel _level)
				_level.setDayTime(168000);
			{
				ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
				if (_ist.hurt(1, RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
		}
		if (entity instanceof Player _player)
			_player.getInventory().clearContent();
		{
			final int _slotid = 0;
			final ItemStack _setstack = ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack0).copy();
			_setstack.setCount(((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack0).getCount());
			entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot)
					_modHandlerEntSetSlot.setStackInSlot(_slotid, _setstack);
			});
		}
		{
			final int _slotid = 1;
			final ItemStack _setstack = ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack1).copy();
			_setstack.setCount(((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack1).getCount());
			entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot)
					_modHandlerEntSetSlot.setStackInSlot(_slotid, _setstack);
			});
		}
		{
			final int _slotid = 2;
			final ItemStack _setstack = ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack2).copy();
			_setstack.setCount(((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack2).getCount());
			entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot)
					_modHandlerEntSetSlot.setStackInSlot(_slotid, _setstack);
			});
		}
		{
			final int _slotid = 3;
			final ItemStack _setstack = ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack3).copy();
			_setstack.setCount(((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack3).getCount());
			entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot)
					_modHandlerEntSetSlot.setStackInSlot(_slotid, _setstack);
			});
		}
		{
			final int _slotid = 4;
			final ItemStack _setstack = ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack4).copy();
			_setstack.setCount(((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack4).getCount());
			entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot)
					_modHandlerEntSetSlot.setStackInSlot(_slotid, _setstack);
			});
		}
		{
			final int _slotid = 5;
			final ItemStack _setstack = ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack5).copy();
			_setstack.setCount(((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack5).getCount());
			entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot)
					_modHandlerEntSetSlot.setStackInSlot(_slotid, _setstack);
			});
		}
		{
			final int _slotid = 6;
			final ItemStack _setstack = ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack6).copy();
			_setstack.setCount(((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack6).getCount());
			entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot)
					_modHandlerEntSetSlot.setStackInSlot(_slotid, _setstack);
			});
		}
		{
			final int _slotid = 7;
			final ItemStack _setstack = ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack7).copy();
			_setstack.setCount(((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack7).getCount());
			entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot)
					_modHandlerEntSetSlot.setStackInSlot(_slotid, _setstack);
			});
		}
		{
			final int _slotid = 8;
			final ItemStack _setstack = ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack8).copy();
			_setstack.setCount(((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack8).getCount());
			entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot)
					_modHandlerEntSetSlot.setStackInSlot(_slotid, _setstack);
			});
		}
		{
			final int _slotid = 9;
			final ItemStack _setstack = ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack9).copy();
			_setstack.setCount(((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack9).getCount());
			entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot)
					_modHandlerEntSetSlot.setStackInSlot(_slotid, _setstack);
			});
		}
		{
			final int _slotid = 10;
			final ItemStack _setstack = ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack10).copy();
			_setstack.setCount(((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack10).getCount());
			entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot)
					_modHandlerEntSetSlot.setStackInSlot(_slotid, _setstack);
			});
		}
		{
			final int _slotid = 11;
			final ItemStack _setstack = ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack11).copy();
			_setstack.setCount(((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack11).getCount());
			entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot)
					_modHandlerEntSetSlot.setStackInSlot(_slotid, _setstack);
			});
		}
		{
			final int _slotid = 12;
			final ItemStack _setstack = ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack12).copy();
			_setstack.setCount(((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack12).getCount());
			entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot)
					_modHandlerEntSetSlot.setStackInSlot(_slotid, _setstack);
			});
		}
		{
			final int _slotid = 13;
			final ItemStack _setstack = ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack13).copy();
			_setstack.setCount(((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack13).getCount());
			entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot)
					_modHandlerEntSetSlot.setStackInSlot(_slotid, _setstack);
			});
		}
		{
			final int _slotid = 14;
			final ItemStack _setstack = ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack14).copy();
			_setstack.setCount(((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack14).getCount());
			entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot)
					_modHandlerEntSetSlot.setStackInSlot(_slotid, _setstack);
			});
		}
		{
			final int _slotid = 15;
			final ItemStack _setstack = ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack15).copy();
			_setstack.setCount(((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack15).getCount());
			entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot)
					_modHandlerEntSetSlot.setStackInSlot(_slotid, _setstack);
			});
		}
		{
			final int _slotid = 16;
			final ItemStack _setstack = ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack16).copy();
			_setstack.setCount(((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack16).getCount());
			entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot)
					_modHandlerEntSetSlot.setStackInSlot(_slotid, _setstack);
			});
		}
		{
			final int _slotid = 17;
			final ItemStack _setstack = ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack17).copy();
			_setstack.setCount(((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack17).getCount());
			entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot)
					_modHandlerEntSetSlot.setStackInSlot(_slotid, _setstack);
			});
		}
		{
			final int _slotid = 18;
			final ItemStack _setstack = ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack18).copy();
			_setstack.setCount(((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack18).getCount());
			entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot)
					_modHandlerEntSetSlot.setStackInSlot(_slotid, _setstack);
			});
		}
		{
			final int _slotid = 19;
			final ItemStack _setstack = ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack19).copy();
			_setstack.setCount(((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack19).getCount());
			entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot)
					_modHandlerEntSetSlot.setStackInSlot(_slotid, _setstack);
			});
		}
		{
			final int _slotid = 20;
			final ItemStack _setstack = ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack20).copy();
			_setstack.setCount(((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack20).getCount());
			entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot)
					_modHandlerEntSetSlot.setStackInSlot(_slotid, _setstack);
			});
		}
		{
			final int _slotid = 21;
			final ItemStack _setstack = ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack21).copy();
			_setstack.setCount(((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack21).getCount());
			entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot)
					_modHandlerEntSetSlot.setStackInSlot(_slotid, _setstack);
			});
		}
		{
			final int _slotid = 22;
			final ItemStack _setstack = ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack22).copy();
			_setstack.setCount(((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack22).getCount());
			entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot)
					_modHandlerEntSetSlot.setStackInSlot(_slotid, _setstack);
			});
		}
		{
			final int _slotid = 23;
			final ItemStack _setstack = ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack23).copy();
			_setstack.setCount(((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack23).getCount());
			entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot)
					_modHandlerEntSetSlot.setStackInSlot(_slotid, _setstack);
			});
		}
		{
			final int _slotid = 24;
			final ItemStack _setstack = ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack24).copy();
			_setstack.setCount(((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack24).getCount());
			entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot)
					_modHandlerEntSetSlot.setStackInSlot(_slotid, _setstack);
			});
		}
		{
			final int _slotid = 25;
			final ItemStack _setstack = ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack25).copy();
			_setstack.setCount(((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack25).getCount());
			entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot)
					_modHandlerEntSetSlot.setStackInSlot(_slotid, _setstack);
			});
		}
		{
			final int _slotid = 26;
			final ItemStack _setstack = ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack26).copy();
			_setstack.setCount(((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack26).getCount());
			entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot)
					_modHandlerEntSetSlot.setStackInSlot(_slotid, _setstack);
			});
		}
		{
			final int _slotid = 27;
			final ItemStack _setstack = ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack27).copy();
			_setstack.setCount(((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack27).getCount());
			entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot)
					_modHandlerEntSetSlot.setStackInSlot(_slotid, _setstack);
			});
		}
		{
			final int _slotid = 28;
			final ItemStack _setstack = ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack28).copy();
			_setstack.setCount(((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack28).getCount());
			entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot)
					_modHandlerEntSetSlot.setStackInSlot(_slotid, _setstack);
			});
		}
		{
			final int _slotid = 29;
			final ItemStack _setstack = ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack29).copy();
			_setstack.setCount(((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack29).getCount());
			entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot)
					_modHandlerEntSetSlot.setStackInSlot(_slotid, _setstack);
			});
		}
		{
			final int _slotid = 30;
			final ItemStack _setstack = ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack30).copy();
			_setstack.setCount(((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack30).getCount());
			entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot)
					_modHandlerEntSetSlot.setStackInSlot(_slotid, _setstack);
			});
		}
		{
			final int _slotid = 31;
			final ItemStack _setstack = ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack31).copy();
			_setstack.setCount(((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack31).getCount());
			entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot)
					_modHandlerEntSetSlot.setStackInSlot(_slotid, _setstack);
			});
		}
		{
			final int _slotid = 32;
			final ItemStack _setstack = ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack32).copy();
			_setstack.setCount(((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack32).getCount());
			entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot)
					_modHandlerEntSetSlot.setStackInSlot(_slotid, _setstack);
			});
		}
		{
			final int _slotid = 33;
			final ItemStack _setstack = ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack33).copy();
			_setstack.setCount(((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack33).getCount());
			entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot)
					_modHandlerEntSetSlot.setStackInSlot(_slotid, _setstack);
			});
		}
		{
			final int _slotid = 34;
			final ItemStack _setstack = ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack34).copy();
			_setstack.setCount(((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack34).getCount());
			entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot)
					_modHandlerEntSetSlot.setStackInSlot(_slotid, _setstack);
			});
		}
		{
			final int _slotid = 35;
			final ItemStack _setstack = ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack35).copy();
			_setstack.setCount(((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack35).getCount());
			entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot)
					_modHandlerEntSetSlot.setStackInSlot(_slotid, _setstack);
			});
		}
		if (entity instanceof LivingEntity _entity) {
			ItemStack _setstack = ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack36).copy();
			_setstack.setCount(((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack36).getCount());
			_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
			if (_entity instanceof Player _player)
				_player.getInventory().setChanged();
		}
		{
			Entity _entity = entity;
			if (_entity instanceof Player _player) {
				_player.getInventory().armor.set(0, ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack37));
				_player.getInventory().setChanged();
			} else if (_entity instanceof LivingEntity _living) {
				_living.setItemSlot(EquipmentSlot.FEET, ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack37));
			}
		}
		{
			Entity _entity = entity;
			if (_entity instanceof Player _player) {
				_player.getInventory().armor.set(1, ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack38));
				_player.getInventory().setChanged();
			} else if (_entity instanceof LivingEntity _living) {
				_living.setItemSlot(EquipmentSlot.LEGS, ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack38));
			}
		}
		{
			Entity _entity = entity;
			if (_entity instanceof Player _player) {
				_player.getInventory().armor.set(2, ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack39));
				_player.getInventory().setChanged();
			} else if (_entity instanceof LivingEntity _living) {
				_living.setItemSlot(EquipmentSlot.CHEST, ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack39));
			}
		}
		{
			Entity _entity = entity;
			if (_entity instanceof Player _player) {
				_player.getInventory().armor.set(3, ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack40));
				_player.getInventory().setChanged();
			} else if (_entity instanceof LivingEntity _living) {
				_living.setItemSlot(EquipmentSlot.HEAD, ((entity.getCapability(EnteringyourmindModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EnteringyourmindModVariables.PlayerVariables())).Itemstack40));
			}
		}
	}
}
