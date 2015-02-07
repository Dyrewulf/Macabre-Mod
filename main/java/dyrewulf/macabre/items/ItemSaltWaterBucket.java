package dyrewulf.macabre.items;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;
import dyrewulf.macabre.help.Reference;

public class ItemSaltWaterBucket extends ItemBucket {

	public ItemSaltWaterBucket(Block block) {
		super(block);
		setUnlocalizedName("saltWaterBucket");
		setContainerItem(Items.bucket);
		setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));	}

}
