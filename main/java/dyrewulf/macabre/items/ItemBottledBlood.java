package dyrewulf.macabre.items;

import net.minecraft.item.Item;
import dyrewulf.macabre.help.Reference;

public class ItemBottledBlood extends Item
{
	public ItemBottledBlood()
	{
		super();
		setMaxStackSize(64);
		setUnlocalizedName("bottledBlood");
		setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));

	}
}
