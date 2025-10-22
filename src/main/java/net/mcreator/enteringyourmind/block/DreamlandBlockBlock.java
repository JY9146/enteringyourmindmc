
package net.mcreator.enteringyourmind.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

public class DreamlandBlockBlock extends Block {
	public DreamlandBlockBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(1f, 10f).speedFactor(1.2f).jumpFactor(1.25f));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}
