package dyrewulf.macabre.armor;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import dyrewulf.macabre.Macabre;
import dyrewulf.macabre.help.Reference;

public class ArmorBoneArmor extends ItemArmor 
{
	public ArmorBoneArmor(ArmorMaterial material, int armortype, String name)
	{
		super(material, 0, armortype);
		setUnlocalizedName(name);
		setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabCombat);
	}
	
	@Override
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack) {
	      return Macabre.boneArmorSegment == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
	   }
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if(stack.getItem() == Macabre.boneHelmet || stack.getItem() == Macabre.boneChestplate || stack.getItem() == Macabre.boneBoots)
			{
			return Reference.MODID + ":" + "models/armor/boneArmor1.png";
			} else if(stack.getItem() == Macabre.boneLeggings)
			{
				return Reference.MODID + ":" + "models/armor/boneArmor2.png";
			} else
		return null;
	}	
}
