package dyrewulf.macabre;

import net.minecraft.block.Block.SoundType;


public class BoneSoundType extends SoundType
{
	public final String boneSound;

	public BoneSoundType(String name, float volume, float freq) {
		super(name, volume, freq);
		this.boneSound = name;
	}

	@Override
	public String getBreakSound()
    {
        return this.boneSound;
    }

	@Override
    public String getStepResourcePath()
    {
        return this.boneSound;
    }

	
}
