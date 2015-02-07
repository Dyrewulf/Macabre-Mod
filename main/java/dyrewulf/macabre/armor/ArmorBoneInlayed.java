package dyrewulf.macabre.armor;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import dyrewulf.macabre.Macabre;
import dyrewulf.macabre.help.Reference;

public class ArmorBoneInlayed extends ItemArmor 
{
	public ArmorBoneInlayed(ArmorMaterial material, int armortype, String name)
	{
		super(material, 0, armortype);
		setUnlocalizedName(name);
		setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabCombat);
	}
	
	@Override
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack) {
	      return (Macabre.boneArmorSegment == par2ItemStack.getItem()) || (Items.iron_ingot== par2ItemStack.getItem()) ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
	   }
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if(stack.getItem() == Macabre.boneInlayedHelmet || stack.getItem() == Macabre.boneInlayedChestplate || stack.getItem() == Macabre.boneInlayedBoots)
			{
			return Reference.MODID + ":" + "models/armor/boneInlayed1.png";
			} else if(stack.getItem() == Macabre.boneInlayedLeggings)
			{
				return Reference.MODID + ":" + "models/armor/boneInlayed2.png";
			} else
		return null;
	}	
}
