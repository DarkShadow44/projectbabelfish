package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.nbt;

public class CompatReal_NBTTagList extends NBTTagList implements CompatI_NBTTagList {
	@SuppressWarnings("unused")
	private Compat_NBTTagList thisFake;

	public CompatReal_NBTTagList(Compat_NBTTagList thisFake) {
		super();
		this.thisFake = thisFake;
	}

	@Override
	public NBTTagList get() {
		return this;
	}
}
