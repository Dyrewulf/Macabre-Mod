package dyrewulf.macabre.items;

import net.minecraft.item.Item;
import dyrewulf.macabre.help.Reference;

public class ItemBoneArmorSegment extends Item
{
	public ItemBoneArmorSegment()
	{
		super();
		setUnlocalizedName("boneArmorSegment");
		setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));

	}

}
