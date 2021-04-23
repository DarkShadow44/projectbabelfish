package compat.sandbox.net.minecraftforge.common.model;

import net.minecraftforge.common.model.IModelState;

public class Wrapper_IModelState implements Compat_IModelState {

	private final IModelState original;

	public Wrapper_IModelState(IModelState original) {
		this.original = original;
	}

	public IModelState getReal() {
		return original;
	}

}
