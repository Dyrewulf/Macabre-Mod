package dyrewulf.macabre.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import dyrewulf.macabre.Macabre;

public class EnchantmentSoulForge extends Enchantment
{

	public EnchantmentSoulForge(int id, int rarity)
	{
		super(id, rarity, EnumEnchantmentType.weapon);
		setName("soulForge");
	}
	
	@Override
	public int getMinEnchantability(int par1)
	{
		return 15 + (par1 - 1) * 10;
	}
	
	@Override
	public int getMaxEnchantability(int par1)
	{
		return getMinEnchantability(par1) * 3;
	}
	
	@Override
	public int getMaxLevel()
	{
		return 3;
	}

	public static void forge(EntityPlayer player, ItemStack weapon, int level)
	{
		if(weapon.isItemDamaged())
		{
			System.out.println(Macabre.soulForge.getName());

		weapon.setItemDamage(weapon.getItemDamage() - level);
		}
	}
}

