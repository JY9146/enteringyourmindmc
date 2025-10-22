
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.enteringyourmind.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.enteringyourmind.client.particle.WaterP1Particle;
import net.mcreator.enteringyourmind.client.particle.Water26Particle;
import net.mcreator.enteringyourmind.client.particle.Water25Particle;
import net.mcreator.enteringyourmind.client.particle.Water24Particle;
import net.mcreator.enteringyourmind.client.particle.Water23Particle;
import net.mcreator.enteringyourmind.client.particle.Water22Particle;
import net.mcreator.enteringyourmind.client.particle.Water21Particle;
import net.mcreator.enteringyourmind.client.particle.Water17Particle;
import net.mcreator.enteringyourmind.client.particle.Water16Particle;
import net.mcreator.enteringyourmind.client.particle.Water15Particle;
import net.mcreator.enteringyourmind.client.particle.Water14Particle;
import net.mcreator.enteringyourmind.client.particle.Water13Particle;
import net.mcreator.enteringyourmind.client.particle.Water12Particle;
import net.mcreator.enteringyourmind.client.particle.SmokeParticle;
import net.mcreator.enteringyourmind.client.particle.Magic2Particle;
import net.mcreator.enteringyourmind.client.particle.Magic24Particle;
import net.mcreator.enteringyourmind.client.particle.Magic23Particle;
import net.mcreator.enteringyourmind.client.particle.Magic22Particle;
import net.mcreator.enteringyourmind.client.particle.Magic1Particle;
import net.mcreator.enteringyourmind.client.particle.Leavesp2Particle;
import net.mcreator.enteringyourmind.client.particle.Leaves4Particle;
import net.mcreator.enteringyourmind.client.particle.Leaves3Particle;
import net.mcreator.enteringyourmind.client.particle.Leaves1Particle;
import net.mcreator.enteringyourmind.client.particle.IceParticle;
import net.mcreator.enteringyourmind.client.particle.FireParticle;
import net.mcreator.enteringyourmind.client.particle.DustParticle;
import net.mcreator.enteringyourmind.client.particle.DirtParticle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EnteringyourmindModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(EnteringyourmindModParticleTypes.MAGIC_1.get(), Magic1Particle::provider);
		event.registerSpriteSet(EnteringyourmindModParticleTypes.FIRE.get(), FireParticle::provider);
		event.registerSpriteSet(EnteringyourmindModParticleTypes.DIRT.get(), DirtParticle::provider);
		event.registerSpriteSet(EnteringyourmindModParticleTypes.LEAVES_1.get(), Leaves1Particle::provider);
		event.registerSpriteSet(EnteringyourmindModParticleTypes.LEAVES2.get(), Leavesp2Particle::provider);
		event.registerSpriteSet(EnteringyourmindModParticleTypes.LEAVES_3.get(), Leaves3Particle::provider);
		event.registerSpriteSet(EnteringyourmindModParticleTypes.LEAVES_4.get(), Leaves4Particle::provider);
		event.registerSpriteSet(EnteringyourmindModParticleTypes.ICE.get(), IceParticle::provider);
		event.registerSpriteSet(EnteringyourmindModParticleTypes.DUST.get(), DustParticle::provider);
		event.registerSpriteSet(EnteringyourmindModParticleTypes.SMOKE.get(), SmokeParticle::provider);
		event.registerSpriteSet(EnteringyourmindModParticleTypes.MAGIC_2.get(), Magic2Particle::provider);
		event.registerSpriteSet(EnteringyourmindModParticleTypes.MAGIC_22.get(), Magic22Particle::provider);
		event.registerSpriteSet(EnteringyourmindModParticleTypes.MAGIC_23.get(), Magic23Particle::provider);
		event.registerSpriteSet(EnteringyourmindModParticleTypes.MAGIC_24.get(), Magic24Particle::provider);
		event.registerSpriteSet(EnteringyourmindModParticleTypes.WATER11.get(), WaterP1Particle::provider);
		event.registerSpriteSet(EnteringyourmindModParticleTypes.WATER_12.get(), Water12Particle::provider);
		event.registerSpriteSet(EnteringyourmindModParticleTypes.WATER_13.get(), Water13Particle::provider);
		event.registerSpriteSet(EnteringyourmindModParticleTypes.WATER_14.get(), Water14Particle::provider);
		event.registerSpriteSet(EnteringyourmindModParticleTypes.WATER_15.get(), Water15Particle::provider);
		event.registerSpriteSet(EnteringyourmindModParticleTypes.WATER_16.get(), Water16Particle::provider);
		event.registerSpriteSet(EnteringyourmindModParticleTypes.WATER_17.get(), Water17Particle::provider);
		event.registerSpriteSet(EnteringyourmindModParticleTypes.WATER_21.get(), Water21Particle::provider);
		event.registerSpriteSet(EnteringyourmindModParticleTypes.WATER_22.get(), Water22Particle::provider);
		event.registerSpriteSet(EnteringyourmindModParticleTypes.WATER_23.get(), Water23Particle::provider);
		event.registerSpriteSet(EnteringyourmindModParticleTypes.WATER_24.get(), Water24Particle::provider);
		event.registerSpriteSet(EnteringyourmindModParticleTypes.WATER_25.get(), Water25Particle::provider);
		event.registerSpriteSet(EnteringyourmindModParticleTypes.WATER_26.get(), Water26Particle::provider);
	}
}
