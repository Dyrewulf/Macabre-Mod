package dyrewulf.macabre.items;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import dyrewulf.macabre.Macabre;
import dyrewulf.macabre.help.Reference;

public class ItemBoneSword extends ItemSword 
{
	public ItemBoneSword()
	{
		super(Macabre.boneToolMat);
		setUnlocalizedName("boneSword");
		setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));

	}
	
	@Override
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack) {
	      return Items.bone == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
	   }
}