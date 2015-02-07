package dyrewulf.macabre.handlers;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerPickupXpEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import dyrewulf.macabre.enchantments.EnchantmentExsanguinate;
import dyrewulf.macabre.enchantments.EnchantmentSoulForge;
import dyrewulf.macabre.help.Reference;

public class MacabreEventHandler 
{
	@SubscribeEvent
	public void sanguineDrain(AttackEntityEvent event)
	{
		if(event.entityPlayer.getHeldItem().isItemEnchanted())
		{
			NBTTagList taglist = event.entityPlayer.getHeldItem().getEnchantmentTagList();
			for(int i = 0; i < taglist.tagCount(); i++)
			{
				if(!event.target.isCreatureType(EnumCreatureType.monster , false))
				{
					if (taglist.getCompoundTagAt(i).getShort("id") == Reference.ENCHANTMENTEXSANGUINATE)
					{
						EnchantmentExsanguinate.drain(event.entityPlayer, event.target);
						break;
					}
				}
			}
		}
	}
	
	@SubscribeEvent
	public void toTheDesert(LivingDeathEvent event)
	{
		if(event.entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.entity;
			player.travelToDimension(Reference.MACABREDIMID);
			player.setSpawnChunk(null, true, Reference.MACABREDIMID);
		}
	}
	
	@SubscribeEvent
	public void soulForge(PlayerPickupXpEvent event)
	{
		NBTTagList taglist = event.entityPlayer.getHeldItem().getEnchantmentTagList();
		if(event.entityPlayer.isUsingItem())
		{
		for(int i = 0; i < taglist.tagCount(); i++)
		{
			if (taglist.getCompoundTagAt(i).getShort("id") == Reference.ENCHANTMENTSOULFORGE)
				{
					event.orb.xpValue = 0;
					EnchantmentSoulForge.forge(event.entityPlayer, event.entityPlayer.getHeldItem(), taglist.getCompoundTagAt(i).getShort("lvl"));
					break;
				}
		}
		}
	}
	
}