package dyrewulf.macabre.blocks;

import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;

public class BlockGreySand extends BlockSand
{
	public BlockGreySand(Material material)
	{
		super();
		setBlockName("greySand");
	}
	
	
	@Override
	public int colorMultiplier(IBlockAccess iblockaccess, int x, int y, int z)
	{
	return 0xAAAA88 ;
	}
}
