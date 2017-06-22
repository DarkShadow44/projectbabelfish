package darkshadow44.compatibility.core.asm;

public class TransformConfig {

	public boolean IsException(String name) {
		if (name.startsWith("java/"))
			return true;

		if (name.startsWith("javax/"))
			return true;

		return false;
	}

	public String GetPrefix() {
		return "darkshadow44/compatibility/version/v1_2_5/sandbox/";
	}

	public String GetTransformedClassname(String name) {
		if (!IsException(name))
			name = GetPrefix() + name;
		return name;
	}
}
