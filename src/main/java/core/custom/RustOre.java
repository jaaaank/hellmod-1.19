package core.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class RustOre extends Block {
	 private final UniformInt xpRange;

	   public RustOre(Properties p_55140_) {
	      this(p_55140_, UniformInt.of(0, 0));
	   }

	   public RustOre(Properties p_153992_, UniformInt p_153993_) {
	      super(p_153992_);
	      this.xpRange = p_153993_;
	   }

	    public int getExpDrop(BlockState state, LevelReader world, BlockPos pos, int fortune, int silktouch)
	    {
	       return 2;
	    }
	}