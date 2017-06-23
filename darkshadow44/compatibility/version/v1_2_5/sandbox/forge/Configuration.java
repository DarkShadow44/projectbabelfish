package darkshadow44.compatibility.version.v1_2_5.sandbox.forge;

import java.io.File;

public class Configuration {

	public Configuration(File file) {
	}

	public Property getOrCreateBlockIdProperty(String key, int defaultId) {
		Property ret = new Property();
		ret.name = key;
		ret.value = Integer.toString(defaultId);
		return ret;
	}

	public Property getOrCreateIntProperty(String key, String category, int defaultValue) {
		Property ret = new Property();
		ret.name = key;
		ret.value = Integer.toString(defaultValue);
		return ret;
	}

	public Property getOrCreateBooleanProperty(String key, String category, boolean defaultValue) {
		Property ret = new Property();
		ret.name = key;
		ret.value = Boolean.toString(defaultValue);
		return ret;
	}

	public Property getOrCreateProperty(String key, String category, String defaultValue) {
		Property ret = new Property();
		ret.name = key;
		ret.value = defaultValue;
		return ret;
	}

	public void load() {
	}

	public void save() {
	}
}
