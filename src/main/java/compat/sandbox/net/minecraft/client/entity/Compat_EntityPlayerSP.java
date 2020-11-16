package compat.sandbox.net.minecraft.client.entity;

import com.mojang.authlib.GameProfile;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.util.Compat_CooldownTracker;
import compat.sandbox.net.minecraft.util.Compat_EnumHandSide;
import net.minecraft.client.entity.EntityPlayerSP;

public class Compat_EntityPlayerSP extends Compat_AbstractClientPlayer {
	private CompatI_EntityPlayerSP wrapper;

	// When called from Mod
	public Compat_EntityPlayerSP() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityPlayerSP.class, this));
	}

	// When called from child
	protected Compat_EntityPlayerSP(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityPlayerSP(EntityPlayerSP original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityPlayerSP.class, original));
	}

	protected void initialize(CompatI_EntityPlayerSP wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public EntityPlayerSP getReal() {
		return wrapper.get();
	}

	public GameProfile Compat_func_146103_bH() {
		return wrapper.getGameProfileSuper();
	}

	public Compat_EnumHandSide Compat_func_184591_cq() {
		return Compat_EnumHandSide.getFake(wrapper.getPrimaryHandSuper());
	}

	public Compat_CooldownTracker Compat_func_184811_cZ() {
		return new Compat_CooldownTracker(wrapper.getCooldownTrackerSuper());
	}
}
