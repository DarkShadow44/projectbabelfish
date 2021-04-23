package compat.sandbox.net.minecraftforge.common.config;

import net.minecraftforge.common.config.ConfigCategory;

public interface CompatI_ConfigCategory {
	public ConfigCategory get();

	public String getQualifiedNameSuper();

	public void setCommentSuper(String comment);
}
