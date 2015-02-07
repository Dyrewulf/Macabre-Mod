package dyrewulf.macabre.blocks;

import java.util.Random;

import dyrewulf.macabre.help.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class BlockLivingFleshBlock extends Block
{

	public BlockLivingFleshBlock(Material material) {
		super(material);
		setBlockName("livingFleshBlock");
		setCreativeTab(CreativeTabs.tabMisc);
		setResistance(0.75F);
		setHardness(0.75F);
		setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
	}
	
	@Override
    public Item getItemDropped(int metadata, Random random, int fortune) {
        return Items.rotten_flesh;
    }
	
	@Override
	public int quantityDropped(Random p_149745_1_)
    {
        return 2 + (int)(Math.random()*4); 

    }

}
