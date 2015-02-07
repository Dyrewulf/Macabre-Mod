package dyrewulf.macabre.fluids;

import net.minecraftforge.fluids.Fluid;

public class FluidSanguine extends Fluid 
{
	public FluidSanguine()
	{
		super("sanguine");
		setUnlocalizedName("sanguine");
		setViscosity(2000);
		setDensity(900);
	}

}
