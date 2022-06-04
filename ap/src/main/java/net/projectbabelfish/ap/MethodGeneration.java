package net.projectbabelfish.ap;

public enum MethodGeneration {
	// Method exists as public method in MC class
	NORMAL,
	// Method doesn't exist in MC class anymore
	NONE,
	// Method exists as protected method in MC class
	ONLY_CHILD;
}
