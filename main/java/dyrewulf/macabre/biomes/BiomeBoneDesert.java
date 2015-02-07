package dyrewulf.macabre.biomes;

import dyrewulf.macabre.Macabre;

public class BiomeBoneDesert extends MacabreBiomes
{
	public BiomeBoneDesert(int id) {
		super(id);
		setBiomeName("boneDesert");
		this.topBlock = Macabre.bonePile;
	    this.fillerBlock = Macabre.greySand;
	    this.theBiomeDecorator.treesPerChunk = -999;
	    this.theBiomeDecorator.deadBushPerChunk = 2;
	    this.theBiomeDecorator.reedsPerChunk = 50;
	    this.theBiomeDecorator.cactiPerChunk = 5;
	    this.spawnableCreatureList.clear();
	}

}