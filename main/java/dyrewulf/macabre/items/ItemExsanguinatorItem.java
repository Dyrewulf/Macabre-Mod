package dyrewulf.macabre.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import dyrewulf.macabre.Macabre;
import dyrewulf.macabre.help.Reference;

public class ItemExsanguinatorItem extends ItemSword 
{
	public ItemExsanguinatorItem()
	{
		super(Macabre.boneToolMat);
		setUnlocalizedName("exsanguinatorItem");
		setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
	}
	
	@Override
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack) {
	      return Items.bone == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
	   }
	
	@Override
	public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
    {
        MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(p_77659_2_, p_77659_3_, true);

        if (movingobjectposition == null)
        {
            return p_77659_1_;
        }
        else
        {
            if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
            {
                int i = movingobjectposition.blockX;
                int j = movingobjectposition.blockY;
                int k = movingobjectposition.blockZ;

                if (!p_77659_2_.canMineBlock(p_77659_3_, i, j, k))
                {
                    return p_77659_1_;
                }

                if (!p_77659_3_.canPlayerEdit(i, j, k, movingobjectposition.sideHit, p_77659_1_))
                {
                    return p_77659_1_;
                }

                if ((p_77659_2_.getBlock(i, j, k) == Macabre.sanguineFluidBlock) && p_77659_3_.inventory.hasItem(Items.glass_bottle))
                {
                	p_77659_3_.inventory.consumeInventoryItem(Items.glass_bottle);

                    if (p_77659_1_.stackSize <= 0)
                    {
                    	return new ItemStack(Macabre.bottledBlood);
                    }

                    if (!p_77659_3_.inventory.addItemStackToInventory(new ItemStack(Macabre.bottledBlood)))
                    {
                    	p_77659_3_.dropPlayerItemWithRandomChoice(new ItemStack(Macabre.bottledBlood, 1, 0), false);
                    }
                }
            }

            return p_77659_1_;
        }
  
	}

		
}
