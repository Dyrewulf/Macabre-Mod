package dyrewulf.macabre.proxy;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import dyrewulf.macabre.Macabre;
import dyrewulf.macabre.renderer.ItemRenderBoneStack;
import dyrewulf.macabre.renderer.RenderBoneStack;
import dyrewulf.macabre.tileentity.TileEntityBoneStack;

public class ClientProxy extends CommonProxy 
{
	
	@Override
	public void registerRenderThings()
	{
		//BoneStack
		TileEntitySpecialRenderer render = new RenderBoneStack();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBoneStack.class, render);	
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Macabre.boneStack), new ItemRenderBoneStack(render, new TileEntityBoneStack()));
	}
}
