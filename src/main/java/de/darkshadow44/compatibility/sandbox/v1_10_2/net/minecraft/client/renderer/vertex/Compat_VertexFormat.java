package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.vertex;

import java.util.ArrayList;
import java.util.List;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.renderer.vertex.VertexFormatElement;
import net.minecraft.client.renderer.vertex.VertexFormatElement.EnumUsage;

public class Compat_VertexFormat {
	private CompatI_VertexFormat wrapper;

	// When called from Mod
	public Compat_VertexFormat() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_VertexFormat.class, this));
	}

	// When called from child
	protected Compat_VertexFormat(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_VertexFormat(VertexFormat original) {
		this.initialize(Factory.createWrapper(CompatI_VertexFormat.class, original));
	}

	protected void initialize(CompatI_VertexFormat wrapper) {
		this.wrapper = wrapper;
	}

	public VertexFormat getReal() {
		return wrapper.get();
	}

	// TODO: Some mods from 1.10.2. *really* doesn't like when they get
	// EnumUsage.PADDING. Strip them and hope it doesn't break anything.
	List<VertexFormatElement> getElements() {
		int count = wrapper.getElementCountSuper();

		List<VertexFormatElement> ret = new ArrayList<>();

		for (int i = 0; i < count; i++) {
			VertexFormatElement element = wrapper.getElementSuper(i);

			if (element.getUsage() != EnumUsage.PADDING) {
				ret.add(element);
			}
		}

		return ret;
	}

	public int Compat_func_177345_h() {
		return getElements().size();
	}

	public Compat_VertexFormatElement Compat_func_177348_c(int index) {
		VertexFormatElement result = getElements().get(index);

		return new Compat_VertexFormatElement(result);
	}
}
