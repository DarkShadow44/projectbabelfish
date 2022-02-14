package net.projectbabelfish.ap;

enum CompatClassType {
	INTERFACE("CompatI_"),
	REAL("CompatReal_"),
	PROXY("CompatProxy_");

	private final String prefix;

	public String getPrefix() {
		return prefix;
	}

	private CompatClassType(String prefix) {
		this.prefix = prefix;
	}
}
