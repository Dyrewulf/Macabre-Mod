package dyrewulf.macabre.biomes;

import net.minecraft.init.Blocks;
import dyrewulf.macabre.Macabre;


public class BiomePlainDesert extends MacabreBiomes
{

	public BiomePlainDesert(int id) {
		super(id);
		setBiomeName("plainDesert");
		this.topBlock = Blocks.sand;
	    this.fillerBlock = Blocks.sandstone;
	    this.theBiomeDecorator.treesPerChunk = -999;
	    this.theBiomeDecorator.deadBushPerChunk = 2;
	    this.theBiomeDecorator.reedsPerChunk = 50;
	    this.theBiomeDecorator.cactiPerChunk = 5;
	    this.spawnableCreatureList.clear();
	}

}
