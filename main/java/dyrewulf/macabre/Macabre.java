package dyrewulf.macabre;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import dyrewulf.macabre.armor.ArmorBoneArmor;
import dyrewulf.macabre.armor.ArmorBoneInlayed;
import dyrewulf.macabre.biomes.MacabreBiomes;
import dyrewulf.macabre.blocks.BlockBoneCarpet;
import dyrewulf.macabre.blocks.BlockBonePile;
import dyrewulf.macabre.blocks.BlockBoneStack;
import dyrewulf.macabre.blocks.BlockGreySand;
import dyrewulf.macabre.blocks.BlockLivingFleshBlock;
import dyrewulf.macabre.blocks.BlockRottenFleshBlock;
import dyrewulf.macabre.blocks.BlockSaltWaterBlock;
import dyrewulf.macabre.blocks.BlockSanguineFluidBlock;
import dyrewulf.macabre.enchantments.EnchantmentExsanguinate;
import dyrewulf.macabre.enchantments.EnchantmentSoulForge;
import dyrewulf.macabre.fluids.FluidSaltWater;
import dyrewulf.macabre.fluids.FluidSanguine;
import dyrewulf.macabre.handlers.BucketHandler;
import dyrewulf.macabre.handlers.MacabreEventHandler;
import dyrewulf.macabre.help.Reference;
import dyrewulf.macabre.help.RegisterHelper;
import dyrewulf.macabre.items.ItemBoneArmorSegment;
import dyrewulf.macabre.items.ItemBoneIronSword;
import dyrewulf.macabre.items.ItemBoneSword;
import dyrewulf.macabre.items.ItemBottledBlood;
import dyrewulf.macabre.items.ItemExsanguinatorItem;
import dyrewulf.macabre.items.ItemSaltWaterBucket;
import dyrewulf.macabre.proxy.CommonProxy;
import dyrewulf.macabre.world.MacabreWorldType;
import dyrewulf.macabre.world.WorldProviderMacabre;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class Macabre 
{
	public static Block bonePile;
	public static Block boneStack;
	public static Block greySand;
	public static ToolMaterial boneToolMat = EnumHelper.addToolMaterial("boneMat", 0, 45, 5.0F, 1.5F, 22);
	public static ArmorMaterial boneArmorMat = EnumHelper.addArmorMaterial("boneArmorMat", 10, new int[]{2, 4, 3, 1}, 25);
	public static ItemSword boneSword;
	public static ItemSword boneIronSword;
	public static Item boneArmorSegment;
	public static Item boneHelmet;
	public static Item boneChestplate;
	public static Item boneLeggings;
	public static Item boneBoots;
	public static ItemSword exsanguinatorItem;
	public static final Enchantment exsanguinate = new EnchantmentExsanguinate(Reference.ENCHANTMENTEXSANGUINATE, 5);
	public static final Enchantment soulForge = new EnchantmentSoulForge(Reference.ENCHANTMENTSOULFORGE, 15);
	MacabreEventHandler handler = new MacabreEventHandler();
	public static Item bottledBlood;
	public static Fluid sanguine;
	public static Block sanguineFluidBlock;
	public ArmorMaterial boneInlayed = EnumHelper.addArmorMaterial("boneInlayed", 15, new int[]{2, 6, 5, 2}, 20);
	public static Item boneInlayedHelmet;
	public static Item boneInlayedChestplate;
	public static Item boneInlayedLeggings;
	public static Item boneInlayedBoots;
	public static BlockBoneCarpet boneCarpet;
	public static Fluid saltWater;
	public static Block saltWaterBlock;
	public static Item saltWaterBucket;
	public static Block.SoundType boneSound = new BoneSoundType("mob.skeleton.step", 0.5F, 1.0F);
	public static IWorldGenerator sanguineGenerator;
	public static Block rottenFleshBlock;
	public static Block livingFleshBlock;

	@SidedProxy(clientSide = "dyrewulf.macabre.proxy.ClientProxy", serverSide = "dyrewulf.macabre.proxy.CommonProxy")
	public static CommonProxy dyreProxy;


	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
// start misc.
		sanguine = new FluidSanguine();
		FluidRegistry.registerFluid(sanguine);
		
		saltWater = new FluidSaltWater("saltWater");
		FluidRegistry.registerFluid(saltWater);
				
// start blocks
		regBlocks();
		
// start items
		regItems();
		
// start armor
		regArmor();
				
// start events
		MinecraftForge.EVENT_BUS.register(handler);
		
// start recipes
		regRecipes();
		

	}
	
	private void regBlocks() {
		bonePile = new BlockBonePile(Material.ground).setStepSound(boneSound);
		RegisterHelper.RegisterBlock(bonePile);
		
		boneStack = new BlockBoneStack(Material.ground).setStepSound(boneSound);
		RegisterHelper.RegisterBlock(boneStack);
		
		greySand = new BlockGreySand(Material.sand);
		RegisterHelper.RegisterBlock(greySand);
		
		sanguineFluidBlock = new BlockSanguineFluidBlock(sanguine, Material.water);
		RegisterHelper.RegisterBlock(sanguineFluidBlock);
		
		boneCarpet = new BlockBoneCarpet(Material.carpet);
		RegisterHelper.RegisterBlock(boneCarpet);
		
		saltWaterBlock = new BlockSaltWaterBlock(saltWater, Material.water);
		RegisterHelper.RegisterBlock(saltWaterBlock);
		
		rottenFleshBlock = new BlockRottenFleshBlock(Material.cloth);
		RegisterHelper.RegisterBlock(rottenFleshBlock);
		
		livingFleshBlock = new BlockLivingFleshBlock(Material.cloth);
		RegisterHelper.RegisterBlock(livingFleshBlock);
	}
	
	private void regArmor() {
		boneHelmet = new ArmorBoneArmor(boneArmorMat, 0, "boneHelmet");
		boneChestplate = new ArmorBoneArmor(boneArmorMat, 1, "boneChestplate");
		boneLeggings = new ArmorBoneArmor(boneArmorMat, 2, "boneLeggings");
		boneBoots = new ArmorBoneArmor(boneArmorMat, 3, "boneBoots");
		RegisterHelper.RegisterItem(boneHelmet);
		RegisterHelper.RegisterItem(boneChestplate);
		RegisterHelper.RegisterItem(boneLeggings);
		RegisterHelper.RegisterItem(boneBoots);
		
		boneInlayedHelmet = new ArmorBoneInlayed(boneInlayed, 0, "boneInlayedHelmet");
		boneInlayedChestplate = new ArmorBoneInlayed(boneInlayed, 1, "boneInlayedChestplate");
		boneInlayedLeggings = new ArmorBoneInlayed(boneInlayed, 2, "boneInlayedLeggings");
		boneInlayedBoots = new ArmorBoneInlayed(boneInlayed, 3, "boneInlayedBoots");
		RegisterHelper.RegisterItem(boneInlayedHelmet);
		RegisterHelper.RegisterItem(boneInlayedChestplate);
		RegisterHelper.RegisterItem(boneInlayedLeggings);
		RegisterHelper.RegisterItem(boneInlayedBoots);
	}

	private void regItems() {
		boneSword = new ItemBoneSword();
		RegisterHelper.RegisterItem(boneSword);
		
		boneIronSword = new ItemBoneIronSword();
		RegisterHelper.RegisterItem(boneIronSword);
		
		boneArmorSegment = new ItemBoneArmorSegment();
		RegisterHelper.RegisterItem(boneArmorSegment);
		
		exsanguinatorItem = new ItemExsanguinatorItem();
		RegisterHelper.RegisterItem(exsanguinatorItem);
		
		bottledBlood = new ItemBottledBlood();
		RegisterHelper.RegisterItem(bottledBlood);
		
		saltWaterBucket = new ItemSaltWaterBucket(saltWaterBlock);
		RegisterHelper.RegisterItem(saltWaterBucket);
		FluidContainerRegistry.registerFluidContainer(saltWater, new ItemStack(saltWaterBucket), new ItemStack(Items.bucket));
		BucketHandler.INSTANCE.buckets.put(saltWaterBlock, saltWaterBucket);
		MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
	}

	private void regRecipes() {
		GameRegistry.addRecipe(new ItemStack(boneStack, 1), new Object[]
				{
				"AA",
				"AA",
				"AA", 'A', Items.bone
				});
		
		GameRegistry.addRecipe(new ItemStack(Blocks.torch, 2), new Object[]
				{
				"A",
				"B", 'A', Items.coal, 'B', Items.bone
				});
		
		GameRegistry.addRecipe(new ItemStack(bonePile, 1), new Object[]
				{
				"AAA",
				"AAA",
				"AAA", 'A', Items.bone
				});
		
		GameRegistry.addShapelessRecipe(new ItemStack(Items.bone, 6), new Object[]
				{
				boneStack
				});
		
		GameRegistry.addShapelessRecipe(new ItemStack(Items.bone, 9), new Object[]
				{
				bonePile
				});
		
		GameRegistry.addRecipe(new ItemStack(boneSword, 1), new Object[]
				{
				"A",
				"A",
				"A", 'A', Items.bone
				});
		GameRegistry.addRecipe(new ItemStack(boneIronSword, 1), new Object[]
				{
				" AB",
				"AB ",
				" B ", 'A', Items.iron_ingot, 'B', Items.bone
				});
		
		GameRegistry.addRecipe(new ItemStack(boneArmorSegment, 1), new Object[]
				{
				"ABA",
				"ABA", 'A', Items.bone, 'B', Items.string
				});
		
		GameRegistry.addRecipe(new ItemStack(boneHelmet, 1), new Object[]
				{
				"AAA",
				"A A", 'A', boneArmorSegment
				});
		
		GameRegistry.addRecipe(new ItemStack(boneChestplate, 1), new Object[]
				{
				"A A",
				"AAA",
				"AAA", 'A', boneArmorSegment
				});
		
		GameRegistry.addRecipe(new ItemStack(boneLeggings, 1), new Object[]
				{
				"AAA",
				"A A",
				"A A", 'A', boneArmorSegment
				});
		
		GameRegistry.addRecipe(new ItemStack(boneBoots, 1), new Object[]
				{
				"A A",
				"A A", 'A', boneArmorSegment
				});
		
		GameRegistry.addRecipe(new ItemStack(exsanguinatorItem, 1), new Object[]
				{
				"A",
				"B",
				"A", 'A', Items.bone, 'B', Items.glass_bottle
				});
		
		GameRegistry.addRecipe(new ItemStack(boneCarpet, 1), new Object[]
				{
				"AAA", 'A', Items.bone
				}
				);
		
		GameRegistry.addShapelessRecipe(new ItemStack(boneInlayedHelmet), new Object[]
				{
				Items.iron_helmet, Items.bone, Items.bone, Items.bone, Items.bone
				});
		
		GameRegistry.addShapelessRecipe(new ItemStack(boneInlayedChestplate), new Object[]
				{
				Items.iron_chestplate, Items.bone, Items.bone, Items.bone, Items.bone, Items.bone, Items.bone
				});
		
		GameRegistry.addShapelessRecipe(new ItemStack(boneInlayedLeggings), new Object[]
				{
				Items.iron_leggings, Items.bone, Items.bone, Items.bone, Items.bone, Items.bone, Items.bone
				});
		
		GameRegistry.addShapelessRecipe(new ItemStack(boneInlayedBoots), new Object[]
				{
				Items.iron_boots, Items.bone, Items.bone, Items.bone, Items.bone
				});
		
		GameRegistry.addRecipe(new ItemStack(rottenFleshBlock, 1), new Object[]
				{
				"AAA",
				"ABA",
				"AAA", 'A', Items.rotten_flesh, 'B', boneStack
				});
		
		GameRegistry.addRecipe(new ItemStack(livingFleshBlock, 1), new Object[]
				{
				"AAA",
				"ABA",
				"AAA", 'A', Items.rotten_flesh, 'B', bottledBlood
				});
		
		}


	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		dyreProxy.registerRenderThings();		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		MacabreBiomes.registerWithBiomeDictionary();
		DimensionManager.registerProviderType(Reference.MACABREDIMID, WorldProviderMacabre.class, true);
		DimensionManager.registerDimension(Reference.MACABREDIMID, Reference.MACABREDIMID);
		MacabreWorldType.addCustomWorldTypes();
	}
}
