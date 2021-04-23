package compat.sandbox.net.minecraft.util.text;

import java.util.Iterator;
import java.util.List;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;

public class Wrapper2_ITextComponent implements ITextComponent {

	private final Compat_ITextComponent original;

	public Wrapper2_ITextComponent(Compat_ITextComponent original) {
		this.original = original;
	}

	public Compat_ITextComponent getFake() {
		return original;
	}

	@Override
	public Iterator<ITextComponent> iterator() {
		throw new RuntimeException();
	}

	@Override
	public ITextComponent setStyle(Style style) {
		throw new RuntimeException();
	}

	@Override
	public Style getStyle() {
		throw new RuntimeException();
	}

	@Override
	public ITextComponent appendText(String text) {
		throw new RuntimeException();
	}

	@Override
	public ITextComponent appendSibling(ITextComponent component) {
		throw new RuntimeException();
	}

	@Override
	public String getUnformattedComponentText() {
		throw new RuntimeException();
	}

	@Override
	public String getUnformattedText() {
		throw new RuntimeException();
	}

	@Override
	public String getFormattedText() {
		throw new RuntimeException();
	}

	@Override
	public List<ITextComponent> getSiblings() {
		throw new RuntimeException();
	}

	@Override
	public ITextComponent createCopy() {
		throw new RuntimeException();
	}

}
