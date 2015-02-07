package dyrewulf.macabre.items;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import dyrewulf.macabre.Macabre;
import dyrewulf.macabre.help.Reference;

public class ItemBoneIronSword extends ItemSword 
{
	public ItemBoneIronSword()
	{
		super(ToolMaterial.IRON);
		setUnlocalizedName("boneIronSword");
		setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));

	}
	
	@Override
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack) {
	      return (Macabre.boneArmorSegment == par2ItemStack.getItem()) || (Items.iron_ingot== par2ItemStack.getItem()) ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
	   }

}
