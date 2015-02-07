package dyrewulf.macabre.fluids;

import net.minecraftforge.fluids.Fluid;

public class FluidSaltWater extends Fluid {

	public FluidSaltWater(String fluidName) {
		super(fluidName);
		setUnlocalizedName("saltWater");
		setViscosity(1100);
		setDensity(1030);
	}

}
