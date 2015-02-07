package dyrewulf.macabre.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import dyrewulf.macabre.Macabre;

public class EnchantmentExsanguinate extends Enchantment
{
	public EnchantmentExsanguinate(int id, int rarity)
	{
		super(id, rarity, EnumEnchantmentType.weapon);
		setName("exsanguinate");
		
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
		return 1;
	}

	public static void drain(EntityPlayer player, Entity target) {
		
		target.attackEntityFrom(new DamageSource("bleed"), 2);
		if (player.inventory.hasItem(Items.glass_bottle))
        {
        	player.inventory.consumeInventoryItem(Items.glass_bottle);
        	if (!player.inventory.addItemStackToInventory(new ItemStack(Macabre.bottledBlood)))
            {
            	player.dropPlayerItemWithRandomChoice(new ItemStack(Macabre.bottledBlood, 1, 0), false);
            }

        }
	}
	
}
