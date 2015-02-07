package dyrewulf.macabre.blocks;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import dyrewulf.macabre.help.Reference;
import dyrewulf.macabre.tileentity.TileEntityBoneStack;

public class BlockBoneStack extends BlockContainer {
	
	
	public BlockBoneStack(Material material)
	{
		super(material);
		setBlockName("BoneStack");
		setCreativeTab(CreativeTabs.tabMisc);
		setResistance(1.25F);
		setHardness(1.25F);
		setBlockTextureName("boneStack");
		
  	}
	
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityBoneStack();
	}
		
	@Override
	public int getRenderType()
	{
		return -1;
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	
	
	
	@Override
	public void registerBlockIcons(IIconRegister reg) 
	{
	        this.blockIcon = reg.registerIcon(Reference.MODID + ":" + getUnlocalizedName().substring(5));
	}

	
	@Override
    public Item getItemDropped(int metadata, Random random, int fortune) {
        return Items.bone;
    }
	
	@Override
	public int quantityDropped(Random p_149745_1_)
    {
        return 1 + (int)(Math.random()*4); 

    }

}
