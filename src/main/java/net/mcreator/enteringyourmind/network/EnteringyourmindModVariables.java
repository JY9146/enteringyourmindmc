package net.mcreator.enteringyourmind.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.behavior.Swim;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.mcreator.enteringyourmind.EnteringyourmindMod;

import java.util.function.Supplier;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EnteringyourmindModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		EnteringyourmindMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new, SavedDataSyncMessage::handler);
		EnteringyourmindMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				for (Entity entityiterator : new ArrayList<>(event.getEntity().level().players())) {
					((PlayerVariables) entityiterator.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
				}
			}
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				for (Entity entityiterator : new ArrayList<>(event.getEntity().level().players())) {
					((PlayerVariables) entityiterator.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
				}
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				for (Entity entityiterator : new ArrayList<>(event.getEntity().level().players())) {
					((PlayerVariables) entityiterator.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
				}
			}
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.Itemstack0 = original.Itemstack0;
			clone.Itemstack1 = original.Itemstack1;
			clone.Itemstack10 = original.Itemstack10;
			clone.Itemstack11 = original.Itemstack11;
			clone.Itemstack12 = original.Itemstack12;
			clone.Itemstack13 = original.Itemstack13;
			clone.Itemstack14 = original.Itemstack14;
			clone.Itemstack15 = original.Itemstack15;
			clone.Itemstack16 = original.Itemstack16;
			clone.Itemstack17 = original.Itemstack17;
			clone.Itemstack18 = original.Itemstack18;
			clone.Itemstack19 = original.Itemstack19;
			clone.Itemstack2 = original.Itemstack2;
			clone.Itemstack20 = original.Itemstack20;
			clone.Itemstack21 = original.Itemstack21;
			clone.Itemstack22 = original.Itemstack22;
			clone.Itemstack23 = original.Itemstack23;
			clone.Itemstack24 = original.Itemstack24;
			clone.Itemstack25 = original.Itemstack25;
			clone.Itemstack26 = original.Itemstack26;
			clone.Itemstack27 = original.Itemstack27;
			clone.Itemstack28 = original.Itemstack28;
			clone.Itemstack29 = original.Itemstack29;
			clone.Itemstack3 = original.Itemstack3;
			clone.Itemstack30 = original.Itemstack30;
			clone.Itemstack31 = original.Itemstack31;
			clone.Itemstack32 = original.Itemstack32;
			clone.Itemstack33 = original.Itemstack33;
			clone.Itemstack34 = original.Itemstack34;
			clone.Itemstack35 = original.Itemstack35;
			clone.Itemstack36 = original.Itemstack36;
			clone.Itemstack37 = original.Itemstack37;
			clone.Itemstack38 = original.Itemstack38;
			clone.Itemstack39 = original.Itemstack39;
			clone.Itemstack4 = original.Itemstack4;
			clone.Itemstack40 = original.Itemstack40;
			clone.Itemstack5 = original.Itemstack5;
			clone.Itemstack6 = original.Itemstack6;
			clone.Itemstack7 = original.Itemstack7;
			clone.Itemstack8 = original.Itemstack8;
			clone.Itemstack9 = original.Itemstack9;
			clone.Num = original.Num;
			clone.Swim = original.Swim;
			clone.XCoord = original.XCoord;
			clone.Ycoord = original.Ycoord;
			clone.ZCoord = original.ZCoord;
			if (!event.isWasDeath()) {
			}
			if (!event.getEntity().level().isClientSide()) {
				for (Entity entityiterator : new ArrayList<>(event.getEntity().level().players())) {
					((PlayerVariables) entityiterator.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
				}
			}
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData mapdata = MapVariables.get(event.getEntity().level());
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (mapdata != null)
					EnteringyourmindMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					EnteringyourmindMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (worlddata != null)
					EnteringyourmindMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "enteringyourmind_worldvars";
		public boolean Damage = false;
		public boolean Damage2 = false;
		public boolean Damage3 = false;
		public boolean Damage4 = false;
		public double ShootXCoord = 0;
		public double ShootYCoord = 0;
		public double ShootZCoord = 0;

		public static WorldVariables load(CompoundTag tag) {
			WorldVariables data = new WorldVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			Damage = nbt.getBoolean("Damage");
			Damage2 = nbt.getBoolean("Damage2");
			Damage3 = nbt.getBoolean("Damage3");
			Damage4 = nbt.getBoolean("Damage4");
			ShootXCoord = nbt.getDouble("ShootXCoord");
			ShootYCoord = nbt.getDouble("ShootYCoord");
			ShootZCoord = nbt.getDouble("ShootZCoord");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putBoolean("Damage", Damage);
			nbt.putBoolean("Damage2", Damage2);
			nbt.putBoolean("Damage3", Damage3);
			nbt.putBoolean("Damage4", Damage4);
			nbt.putDouble("ShootXCoord", ShootXCoord);
			nbt.putDouble("ShootYCoord", ShootYCoord);
			nbt.putDouble("ShootZCoord", ShootZCoord);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level level && !level.isClientSide())
				EnteringyourmindMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(e -> WorldVariables.load(e), WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "enteringyourmind_mapvars";

		public static MapVariables load(CompoundTag tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			if (nbt == null) {
				nbt = save(new CompoundTag());
			}
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				EnteringyourmindMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(e -> MapVariables.load(e), MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class SavedDataSyncMessage {
		private final int type;
		private SavedData data;

		public SavedDataSyncMessage(FriendlyByteBuf buffer) {
			this.type = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			if (nbt != null) {
				this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
				if (this.data instanceof MapVariables mapVariables)
					mapVariables.read(nbt);
				else if (this.data instanceof WorldVariables worldVariables)
					worldVariables.read(nbt);
			}
		}

		public SavedDataSyncMessage(int type, SavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeInt(message.type);
			if (message.data != null)
				buffer.writeNbt(message.data.save(new CompoundTag()));
		}

		public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer() && message.data != null) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("enteringyourmind", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public ItemStack Itemstack0 = ItemStack.EMPTY;
		public ItemStack Itemstack1 = ItemStack.EMPTY;
		public ItemStack Itemstack10 = ItemStack.EMPTY;
		public ItemStack Itemstack11 = ItemStack.EMPTY;
		public ItemStack Itemstack12 = ItemStack.EMPTY;
		public ItemStack Itemstack13 = ItemStack.EMPTY;
		public ItemStack Itemstack14 = ItemStack.EMPTY;
		public ItemStack Itemstack15 = ItemStack.EMPTY;
		public ItemStack Itemstack16 = ItemStack.EMPTY;
		public ItemStack Itemstack17 = ItemStack.EMPTY;
		public ItemStack Itemstack18 = ItemStack.EMPTY;
		public ItemStack Itemstack19 = ItemStack.EMPTY;
		public ItemStack Itemstack2 = ItemStack.EMPTY;
		public ItemStack Itemstack20 = ItemStack.EMPTY;
		public ItemStack Itemstack21 = ItemStack.EMPTY;
		public ItemStack Itemstack22 = ItemStack.EMPTY;
		public ItemStack Itemstack23 = ItemStack.EMPTY;
		public ItemStack Itemstack24 = ItemStack.EMPTY;
		public ItemStack Itemstack25 = ItemStack.EMPTY;
		public ItemStack Itemstack26 = ItemStack.EMPTY;
		public ItemStack Itemstack27 = ItemStack.EMPTY;
		public ItemStack Itemstack28 = ItemStack.EMPTY;
		public ItemStack Itemstack29 = ItemStack.EMPTY;
		public ItemStack Itemstack3 = ItemStack.EMPTY;
		public ItemStack Itemstack30 = ItemStack.EMPTY;
		public ItemStack Itemstack31 = ItemStack.EMPTY;
		public ItemStack Itemstack32 = ItemStack.EMPTY;
		public ItemStack Itemstack33 = ItemStack.EMPTY;
		public ItemStack Itemstack34 = ItemStack.EMPTY;
		public ItemStack Itemstack35 = ItemStack.EMPTY;
		public ItemStack Itemstack36 = ItemStack.EMPTY;
		public ItemStack Itemstack37 = ItemStack.EMPTY;
		public ItemStack Itemstack38 = ItemStack.EMPTY;
		public ItemStack Itemstack39 = ItemStack.EMPTY;
		public ItemStack Itemstack4 = ItemStack.EMPTY;
		public ItemStack Itemstack40 = ItemStack.EMPTY;
		public ItemStack Itemstack5 = ItemStack.EMPTY;
		public ItemStack Itemstack6 = ItemStack.EMPTY;
		public ItemStack Itemstack7 = ItemStack.EMPTY;
		public ItemStack Itemstack8 = ItemStack.EMPTY;
		public ItemStack Itemstack9 = ItemStack.EMPTY;
		public double Num = 0;
		public boolean Swim = false;
		public double XCoord = 0;
		public double Ycoord = 0;
		public double ZCoord = 0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				EnteringyourmindMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(entity.level()::dimension), new PlayerVariablesSyncMessage(this, entity.getId()));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.put("Itemstack0", Itemstack0.save(new CompoundTag()));
			nbt.put("Itemstack1", Itemstack1.save(new CompoundTag()));
			nbt.put("Itemstack10", Itemstack10.save(new CompoundTag()));
			nbt.put("Itemstack11", Itemstack11.save(new CompoundTag()));
			nbt.put("Itemstack12", Itemstack12.save(new CompoundTag()));
			nbt.put("Itemstack13", Itemstack13.save(new CompoundTag()));
			nbt.put("Itemstack14", Itemstack14.save(new CompoundTag()));
			nbt.put("Itemstack15", Itemstack15.save(new CompoundTag()));
			nbt.put("Itemstack16", Itemstack16.save(new CompoundTag()));
			nbt.put("Itemstack17", Itemstack17.save(new CompoundTag()));
			nbt.put("Itemstack18", Itemstack18.save(new CompoundTag()));
			nbt.put("Itemstack19", Itemstack19.save(new CompoundTag()));
			nbt.put("Itemstack2", Itemstack2.save(new CompoundTag()));
			nbt.put("Itemstack20", Itemstack20.save(new CompoundTag()));
			nbt.put("Itemstack21", Itemstack21.save(new CompoundTag()));
			nbt.put("Itemstack22", Itemstack22.save(new CompoundTag()));
			nbt.put("Itemstack23", Itemstack23.save(new CompoundTag()));
			nbt.put("Itemstack24", Itemstack24.save(new CompoundTag()));
			nbt.put("Itemstack25", Itemstack25.save(new CompoundTag()));
			nbt.put("Itemstack26", Itemstack26.save(new CompoundTag()));
			nbt.put("Itemstack27", Itemstack27.save(new CompoundTag()));
			nbt.put("Itemstack28", Itemstack28.save(new CompoundTag()));
			nbt.put("Itemstack29", Itemstack29.save(new CompoundTag()));
			nbt.put("Itemstack3", Itemstack3.save(new CompoundTag()));
			nbt.put("Itemstack30", Itemstack30.save(new CompoundTag()));
			nbt.put("Itemstack31", Itemstack31.save(new CompoundTag()));
			nbt.put("Itemstack32", Itemstack32.save(new CompoundTag()));
			nbt.put("Itemstack33", Itemstack33.save(new CompoundTag()));
			nbt.put("Itemstack34", Itemstack34.save(new CompoundTag()));
			nbt.put("Itemstack35", Itemstack35.save(new CompoundTag()));
			nbt.put("Itemstack36", Itemstack36.save(new CompoundTag()));
			nbt.put("Itemstack37", Itemstack37.save(new CompoundTag()));
			nbt.put("Itemstack38", Itemstack38.save(new CompoundTag()));
			nbt.put("Itemstack39", Itemstack39.save(new CompoundTag()));
			nbt.put("Itemstack4", Itemstack4.save(new CompoundTag()));
			nbt.put("Itemstack40", Itemstack40.save(new CompoundTag()));
			nbt.put("Itemstack5", Itemstack5.save(new CompoundTag()));
			nbt.put("Itemstack6", Itemstack6.save(new CompoundTag()));
			nbt.put("Itemstack7", Itemstack7.save(new CompoundTag()));
			nbt.put("Itemstack8", Itemstack8.save(new CompoundTag()));
			nbt.put("Itemstack9", Itemstack9.save(new CompoundTag()));
			nbt.putDouble("Num", Num);
			nbt.putBoolean("Swim", Swim);
			nbt.putDouble("XCoord", XCoord);
			nbt.putDouble("Ycoord", Ycoord);
			nbt.putDouble("ZCoord", ZCoord);
			return nbt;
		}

		public void readNBT(Tag tag) {
			if (tag == null) {
				tag = writeNBT();
			}
			CompoundTag nbt = (CompoundTag) tag;
			if (nbt == null) {
				nbt = (CompoundTag) writeNBT();
			}
			Itemstack0 = ItemStack.of(nbt.getCompound("Itemstack0"));
			Itemstack1 = ItemStack.of(nbt.getCompound("Itemstack1"));
			Itemstack10 = ItemStack.of(nbt.getCompound("Itemstack10"));
			Itemstack11 = ItemStack.of(nbt.getCompound("Itemstack11"));
			Itemstack12 = ItemStack.of(nbt.getCompound("Itemstack12"));
			Itemstack13 = ItemStack.of(nbt.getCompound("Itemstack13"));
			Itemstack14 = ItemStack.of(nbt.getCompound("Itemstack14"));
			Itemstack15 = ItemStack.of(nbt.getCompound("Itemstack15"));
			Itemstack16 = ItemStack.of(nbt.getCompound("Itemstack16"));
			Itemstack17 = ItemStack.of(nbt.getCompound("Itemstack17"));
			Itemstack18 = ItemStack.of(nbt.getCompound("Itemstack18"));
			Itemstack19 = ItemStack.of(nbt.getCompound("Itemstack19"));
			Itemstack2 = ItemStack.of(nbt.getCompound("Itemstack2"));
			Itemstack20 = ItemStack.of(nbt.getCompound("Itemstack20"));
			Itemstack21 = ItemStack.of(nbt.getCompound("Itemstack21"));
			Itemstack22 = ItemStack.of(nbt.getCompound("Itemstack22"));
			Itemstack23 = ItemStack.of(nbt.getCompound("Itemstack23"));
			Itemstack24 = ItemStack.of(nbt.getCompound("Itemstack24"));
			Itemstack25 = ItemStack.of(nbt.getCompound("Itemstack25"));
			Itemstack26 = ItemStack.of(nbt.getCompound("Itemstack26"));
			Itemstack27 = ItemStack.of(nbt.getCompound("Itemstack27"));
			Itemstack28 = ItemStack.of(nbt.getCompound("Itemstack28"));
			Itemstack29 = ItemStack.of(nbt.getCompound("Itemstack29"));
			Itemstack3 = ItemStack.of(nbt.getCompound("Itemstack3"));
			Itemstack30 = ItemStack.of(nbt.getCompound("Itemstack30"));
			Itemstack31 = ItemStack.of(nbt.getCompound("Itemstack31"));
			Itemstack32 = ItemStack.of(nbt.getCompound("Itemstack32"));
			Itemstack33 = ItemStack.of(nbt.getCompound("Itemstack33"));
			Itemstack34 = ItemStack.of(nbt.getCompound("Itemstack34"));
			Itemstack35 = ItemStack.of(nbt.getCompound("Itemstack35"));
			Itemstack36 = ItemStack.of(nbt.getCompound("Itemstack36"));
			Itemstack37 = ItemStack.of(nbt.getCompound("Itemstack37"));
			Itemstack38 = ItemStack.of(nbt.getCompound("Itemstack38"));
			Itemstack39 = ItemStack.of(nbt.getCompound("Itemstack39"));
			Itemstack4 = ItemStack.of(nbt.getCompound("Itemstack4"));
			Itemstack40 = ItemStack.of(nbt.getCompound("Itemstack40"));
			Itemstack5 = ItemStack.of(nbt.getCompound("Itemstack5"));
			Itemstack6 = ItemStack.of(nbt.getCompound("Itemstack6"));
			Itemstack7 = ItemStack.of(nbt.getCompound("Itemstack7"));
			Itemstack8 = ItemStack.of(nbt.getCompound("Itemstack8"));
			Itemstack9 = ItemStack.of(nbt.getCompound("Itemstack9"));
			Num = nbt.getDouble("Num");
			Swim = nbt.getBoolean("Swim");
			XCoord = nbt.getDouble("XCoord");
			Ycoord = nbt.getDouble("Ycoord");
			ZCoord = nbt.getDouble("ZCoord");
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		EnteringyourmindMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	public static class PlayerVariablesSyncMessage {
		private final int target;
		private final PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
			this.target = buffer.readInt();
		}

		public PlayerVariablesSyncMessage(PlayerVariables data, int entityid) {
			this.data = data;
			this.target = entityid;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
			buffer.writeInt(message.target);
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.level().getEntity(message.target).getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.Itemstack0 = message.data.Itemstack0;
					variables.Itemstack1 = message.data.Itemstack1;
					variables.Itemstack10 = message.data.Itemstack10;
					variables.Itemstack11 = message.data.Itemstack11;
					variables.Itemstack12 = message.data.Itemstack12;
					variables.Itemstack13 = message.data.Itemstack13;
					variables.Itemstack14 = message.data.Itemstack14;
					variables.Itemstack15 = message.data.Itemstack15;
					variables.Itemstack16 = message.data.Itemstack16;
					variables.Itemstack17 = message.data.Itemstack17;
					variables.Itemstack18 = message.data.Itemstack18;
					variables.Itemstack19 = message.data.Itemstack19;
					variables.Itemstack2 = message.data.Itemstack2;
					variables.Itemstack20 = message.data.Itemstack20;
					variables.Itemstack21 = message.data.Itemstack21;
					variables.Itemstack22 = message.data.Itemstack22;
					variables.Itemstack23 = message.data.Itemstack23;
					variables.Itemstack24 = message.data.Itemstack24;
					variables.Itemstack25 = message.data.Itemstack25;
					variables.Itemstack26 = message.data.Itemstack26;
					variables.Itemstack27 = message.data.Itemstack27;
					variables.Itemstack28 = message.data.Itemstack28;
					variables.Itemstack29 = message.data.Itemstack29;
					variables.Itemstack3 = message.data.Itemstack3;
					variables.Itemstack30 = message.data.Itemstack30;
					variables.Itemstack31 = message.data.Itemstack31;
					variables.Itemstack32 = message.data.Itemstack32;
					variables.Itemstack33 = message.data.Itemstack33;
					variables.Itemstack34 = message.data.Itemstack34;
					variables.Itemstack35 = message.data.Itemstack35;
					variables.Itemstack36 = message.data.Itemstack36;
					variables.Itemstack37 = message.data.Itemstack37;
					variables.Itemstack38 = message.data.Itemstack38;
					variables.Itemstack39 = message.data.Itemstack39;
					variables.Itemstack4 = message.data.Itemstack4;
					variables.Itemstack40 = message.data.Itemstack40;
					variables.Itemstack5 = message.data.Itemstack5;
					variables.Itemstack6 = message.data.Itemstack6;
					variables.Itemstack7 = message.data.Itemstack7;
					variables.Itemstack8 = message.data.Itemstack8;
					variables.Itemstack9 = message.data.Itemstack9;
					variables.Num = message.data.Num;
					variables.Swim = message.data.Swim;
					variables.XCoord = message.data.XCoord;
					variables.Ycoord = message.data.Ycoord;
					variables.ZCoord = message.data.ZCoord;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
