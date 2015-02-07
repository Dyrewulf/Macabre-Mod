package dyrewulf.macabre.blocks;

import java.util.Random;

import net.minecraft.block.BlockGravel;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import dyrewulf.macabre.help.Reference;

public class BlockBonePile extends BlockGravel
{	
	public BlockBonePile(Material ground)
	{
		super();
		setBlockName("bonePile");
		setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabMisc);
		setResistance(0.75F);
		setHardness(0.75F);
		
  	}
	
	@Override
    public Item getItemDropped(int metadata, Random random, int fortune) {
        return Items.bone;
    }
	
	@Override
	public int quantityDropped(Random p_149745_1_)
    {
        return 2 + (int)(Math.random()*4); 

    }
}
