package compat.core;

public enum Version {
	UNKNOWN("ERROR"),
	V1_7_10("1.7.10"),
	V1_10_2("1.10.2");

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

	public void throwError() {
		throw new RuntimeException("Unimplemented for version " + name());
	}
}
