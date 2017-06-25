package darkshadow44.compatibility.common;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import javax.imageio.ImageIO;

import darkshadow44.compatibility.version.v1_2_5.sandbox.Core;
import helper.IOHelper;

public class TextureHelper {

	HashMap<String, Boolean> loadedImages;

	public TextureHelper() {
		loadedImages = new HashMap<String, Boolean>();
	}

	public String GetTextureSplitName(String texturePath, int x, int y) {
		return texturePath.replace('/', '_').replace('.', '_') + "_" + y / 16 + "_" + x / 16 + "_.png";
	}

	public void LoadImage(String texturePath) {
		if (!texturePath.startsWith("/"))
			texturePath = "/" + texturePath;
		if (loadedImages.containsKey(texturePath))
			return;

		try {
			InputStream resource = Core.classLoader.getResourceAsStream(texturePath);
			byte[] data = new byte[resource.available()];
			resource.read(data, 0, data.length);

			loadedImages.put(texturePath, true);

			BufferedImage img = ImageIO.read(new DataInputStream(new ByteArrayInputStream(data)));

			int idx = 0;
			for (int x = 0; x < img.getWidth(); x += 16)
				for (int y = 0; y < img.getHeight(); y += 16) {
					ByteArrayOutputStream output = new ByteArrayOutputStream();
					DataOutputStream outputstream = new DataOutputStream(output);
					ImageIO.write(img.getSubimage(x, y, 16, 16), "png", output);

					outputstream.flush();
					byte[] dataSplit = output.toByteArray();

					Core.classLoader.addResource(GetTextureSplitName(texturePath, x, y), dataSplit);
				}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
