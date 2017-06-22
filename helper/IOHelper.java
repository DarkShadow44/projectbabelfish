package helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.google.common.io.Files;

public class IOHelper {
	public static void WriteBytesToFile(String path, byte[] data) {
		try {
			Files.write(data, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
