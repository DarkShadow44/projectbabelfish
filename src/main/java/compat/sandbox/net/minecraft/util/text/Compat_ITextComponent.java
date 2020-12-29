package compat.sandbox.net.minecraft.util.text;

import net.minecraft.util.text.ITextComponent;

public interface Compat_ITextComponent {
	public static Compat_ITextComponent getFake(ITextComponent real) {
		if (real instanceof Wrapper2_ITextComponent) {
			return ((Wrapper2_ITextComponent) real).getFake();
		}
		return new Wrapper_ITextComponent(real);
	}

	public static ITextComponent getReal(Compat_ITextComponent fake) {
		if (fake instanceof Wrapper_ITextComponent) {
			return ((Wrapper_ITextComponent) fake).getReal();
		}
		return new Wrapper2_ITextComponent(fake);
	}
}
