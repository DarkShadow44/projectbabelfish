package compat.sandbox.net.minecraft.util.text;

import net.minecraft.util.text.ITextComponent;

public class Wrapper_ITextComponent implements Compat_ITextComponent {
	private final ITextComponent original;

	public Wrapper_ITextComponent(ITextComponent original) {
		this.original = original;
	}

	public ITextComponent getReal() {
		return original;
	}
}
