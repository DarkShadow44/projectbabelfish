package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.command;

import net.minecraft.command.CommandException;

public class Compat_CommandException extends CommandException {

	private static final long serialVersionUID = 5980103792219293459L;

	public Compat_CommandException(String p1, Object[] p2) {
		super(p1, p2);
	}

}
