package dyrewulf.macabre.blocks;

import net.minecraft.block.BlockCarpet;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dyrewulf.macabre.Macabre;

public class BlockBoneCarpet extends BlockCarpet
{
	public BlockBoneCarpet(Material carpet)
	{
		super();
		setBlockName("boneCarpet");
		
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return Macabre.bonePile.getIcon(p_149691_1_, p_149691_2_);
    }

}
