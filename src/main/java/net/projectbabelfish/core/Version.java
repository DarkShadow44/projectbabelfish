package net.projectbabelfish.core;

public enum Version {
	UNKNOWN("ERROR"), 
	V1_7("1.7"),
	V1_12("1.12"),
	V1_16("1.16"),
	V1_18("1.18");

	private final String string;

	public String getString() {
		return string;
	}

	private Version(String string) {
		this.string = string;
	}

	public static Version get(Object obj) {
		VersionInfo info = obj.getClass().getAnnotation(VersionInfo.class);
		return info == null ? UNKNOWN : info.value();
	}

	public RuntimeException makeException() {
		return new RuntimeException("Unimplemented for version " + name());
	}
}
