package com.rscd.sprite.util;

import java.awt.*;
import java.awt.image.*;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ImageLoader {
	
	public static BufferedImage loadImage(File file) throws IOException {
		Image image = Toolkit.getDefaultToolkit().getImage(file.getAbsolutePath());
		return toBufferedImage(image);
	}
	
	public static void saveImage(BufferedImage image, String format, File file) throws IOException {
		ImageIO.write(image, format, file);
	}

	public static BufferedImage toBufferedImage(Image image) {
		image = new ImageIcon(image).getImage();
		BufferedImage buffImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
		
		Graphics g = buffImage.createGraphics();
		g.drawImage(image, 0, 0, null);
		g.dispose();
		
		return buffImage;
	}
}