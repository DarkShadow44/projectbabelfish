package compat.sandbox.net.minecraftforge.client.model.pipeline;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.client.renderer.Compat_VertexBuffer;
import net.minecraftforge.client.model.pipeline.VertexBufferConsumer;

public class Compat_VertexBufferConsumer {
	private CompatI_VertexBufferConsumer wrapper;

	// When called from Mod
	public Compat_VertexBufferConsumer(Compat_VertexBuffer buffer) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_VertexBufferConsumer.class, this, buffer.getReal()));
	}

	// When called from child
	protected Compat_VertexBufferConsumer(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_VertexBufferConsumer(VertexBufferConsumer original) {
		this.initialize(Factory.createWrapper(CompatI_VertexBufferConsumer.class, original));
	}

	protected void initialize(CompatI_VertexBufferConsumer wrapper) {
		this.wrapper = wrapper;
	}

	public VertexBufferConsumer getReal() {
		return wrapper.get();
	}
}
