package net.projectbabelfish;

import java.util.List;

import net.projectbabelfish.ap.TestAnnotation;

@TestAnnotation
public interface ITest {
	public int testMethod(int x, List<String> strings);
	public int tes2tMethod(int x, List<String> strings);
}
