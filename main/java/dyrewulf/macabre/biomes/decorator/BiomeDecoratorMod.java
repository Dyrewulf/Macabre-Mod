package dyrewulf.macabre.biomes.decorator;

import java.util.Random;

import dyrewulf.macabre.world.gen.WorldGenMacabreTrees;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class BiomeDecoratorMod extends BiomeDecorator
{
	/** The world the BiomeDecorator is currently decorating */
	public static World currentWorld;
	/** The Biome Decorator's random number generator. */
	public static Random randomGenerator;
	/** The X-coordinate of the chunk currently being decorated */
	public static int chunk_X;
	/** The Z-coordinate of the chunk currently being decorated */
	public static int chunk_Z;
	/** True if decorator should generate surface lava & water */
	public static boolean generateLakes;
	/** How meny trees per chunk, set in each biome class **/
	public static int howMenyTrees;

	/** Dimension Trees **/
	public static WorldGenMacabreTrees smallTree;
	
	@SuppressWarnings("unused")
	private static final String __OBFID = "CL_00000164";

	public BiomeDecoratorMod() {
		coalGen = new WorldGenMinable(Blocks.coal_ore, 16, Blocks.stone);
		ironGen = new WorldGenMinable(Blocks.iron_ore, 8, Blocks.stone);
		goldGen = new WorldGenMinable(Blocks.gold_ore, 8, Blocks.stone);
		redstoneGen = new WorldGenMinable(Blocks.redstone_ore, 7, Blocks.stone);
		diamondGen = new WorldGenMinable(Blocks.diamond_ore, 7, Blocks.stone);
		lapisGen = new WorldGenMinable(Blocks.lapis_ore, 6, Blocks.stone);

		// TREES
		smallTree = new WorldGenMacabreTrees(true);

		// generates lakes and lava lakes in dimension.
		generateLakes = true;
	}

	public void decorateChunk(World world, Random random, BiomeGenBase biomeGenBase, int chunkX, int chunkZ) {
		if (currentWorld != null) {
			throw new RuntimeException("Already decorating!!");
		} else {
			currentWorld = world;
			randomGenerator = random;
			chunk_X = chunkX;
			chunk_Z = chunkZ;
			genDecorationsForBiome(biomeGenBase);
			currentWorld = null;
			randomGenerator = null;
		}
	}

	/**
	 * Decorate's biome.
	 * 
	 * @param biome
	 */
	protected void genDecorationsForBiome(BiomeGenBase biome) {
		BiomeDecoratorHelper.decorateBiome(biome);
	}
}