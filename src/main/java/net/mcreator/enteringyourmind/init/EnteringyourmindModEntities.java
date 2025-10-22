
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.enteringyourmind.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.enteringyourmind.entity.InvisWaterEntity;
import net.mcreator.enteringyourmind.entity.InvisMagicEntity;
import net.mcreator.enteringyourmind.entity.InvisFireEntity;
import net.mcreator.enteringyourmind.entity.InvisEarthEntity;
import net.mcreator.enteringyourmind.entity.InvisAirEntity;
import net.mcreator.enteringyourmind.EnteringyourmindMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EnteringyourmindModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, EnteringyourmindMod.MODID);
	public static final RegistryObject<EntityType<InvisMagicEntity>> INVIS_MAGIC = register("invis_magic", EntityType.Builder.<InvisMagicEntity>of(InvisMagicEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(InvisMagicEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<InvisFireEntity>> INVIS_FIRE = register("invis_fire", EntityType.Builder.<InvisFireEntity>of(InvisFireEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(InvisFireEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<InvisWaterEntity>> INVIS_WATER = register("invis_water", EntityType.Builder.<InvisWaterEntity>of(InvisWaterEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(InvisWaterEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<InvisEarthEntity>> INVIS_EARTH = register("invis_earth", EntityType.Builder.<InvisEarthEntity>of(InvisEarthEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(InvisEarthEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<InvisAirEntity>> INVIS_AIR = register("invis_air",
			EntityType.Builder.<InvisAirEntity>of(InvisAirEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(InvisAirEntity::new).fireImmune().sized(0.6f, 1.8f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			InvisMagicEntity.init();
			InvisFireEntity.init();
			InvisWaterEntity.init();
			InvisEarthEntity.init();
			InvisAirEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(INVIS_MAGIC.get(), InvisMagicEntity.createAttributes().build());
		event.put(INVIS_FIRE.get(), InvisFireEntity.createAttributes().build());
		event.put(INVIS_WATER.get(), InvisWaterEntity.createAttributes().build());
		event.put(INVIS_EARTH.get(), InvisEarthEntity.createAttributes().build());
		event.put(INVIS_AIR.get(), InvisAirEntity.createAttributes().build());
	}
}
