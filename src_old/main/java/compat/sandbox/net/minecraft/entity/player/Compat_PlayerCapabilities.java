package compat.sandbox.net.minecraft.entity.player;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.entity.player.PlayerCapabilities;

public class Compat_PlayerCapabilities {
	private CompatI_PlayerCapabilities wrapper;

	// When called from Mod
	public Compat_PlayerCapabilities() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_PlayerCapabilities.class, this));
	}

	// When called from child
	protected Compat_PlayerCapabilities(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_PlayerCapabilities(PlayerCapabilities original) {
		this.initialize(Factory.createWrapper(CompatI_PlayerCapabilities.class, original));
	}

	protected void initialize(CompatI_PlayerCapabilities wrapper) {
		this.wrapper = wrapper;
	}

	public PlayerCapabilities getReal() {
		return wrapper.get();
	}

	public boolean Compat_get_field_75098_d() {
		return wrapper.get_isCreativeMode();
	}
}
