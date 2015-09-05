package org.rscdaemon.editor;

import org.rscdaemon.client.model.Sprite;

import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.nio.ByteBuffer;
import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.Enumeration;
import java.util.zip.ZipFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class SpriteEditor {
	public static final String IMG_DIR = "./img/";
	
	public static final void main(String[] args) {
		if(args.length != 1) {
			System.err.println("Invalid args");
		}
		SpriteEditor editor = new SpriteEditor(new File(args[0]));
	}
	
	public SpriteEditor(File file) {
		// Open the .rscd archive and put all Sprites into a Map
		TreeMap<Integer, Sprite> sprites = readZip(file);
		
		// Loop through all the Sprites and save a PNG version of them
		for(Entry<Integer, Sprite> entry : sprites.entrySet()) {
			try { ImageIO.write(entry.getValue().toImage(), "png", new File(IMG_DIR + entry.getKey() + ".png")); } catch(IOException ioe) { }
		}
		
		// Add in any new Sprites. This bit ideally needs some kind of GUI or something to make life easier
		sprites.put(1370, createSprite(new File("./new/1370.png"), true, 16, 4, 48, 0));
		
		// Write all of these Sprites back into the original .rscd archive
		writeZip(sprites, file);
	}
	
	public Sprite createSprite(File file, boolean requiresShift, int xShift, int yShift, int something1, int something2) {
		try {
			Sprite sprite = Sprite.fromImage(loadImage(file));
			
			sprite.setRequiresShift(requiresShift);
			sprite.setShift(xShift, yShift);
			sprite.setSomething(something1, something2);
			
			return sprite;
		}
		catch(Exception ioe) {
			System.err.println(ioe);
			return null;
		}
	}
	
	public TreeMap<Integer, Sprite> readZip(File file) {
		try {
			TreeMap<Integer, Sprite> sprites = new TreeMap<Integer, Sprite>();
			
			ZipFile zip = new ZipFile(file);
			for(Enumeration<ZipEntry> entries = (Enumeration<ZipEntry>)zip.entries();entries.hasMoreElements();) {
				ZipEntry entry = entries.nextElement();
				BufferedInputStream in = new BufferedInputStream(zip.getInputStream(entry));
				ByteBuffer buffer = streamToBuffer(in);
				in.close();
				
				Sprite sprite = Sprite.unpack(buffer);
				sprites.put(Integer.parseInt(entry.getName()), sprite);
			}
			return sprites;
		}
		catch(IOException ioe) {
			System.err.println(ioe);
			return null;
		}
	}
	
	public boolean writeZip(TreeMap<Integer, Sprite> sprites, File file) {
		try {
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(file));
			out.setLevel(9);
				
			for(Entry<Integer, Sprite> e : sprites.entrySet()) {
				String name = String.valueOf(e.getKey());
				Sprite sprite = e.getValue();
					
				out.putNextEntry(new ZipEntry(name));
				out.write(sprite.pack().array());
				out.closeEntry();
			}
			out.close();
			return true;
		}
		catch(IOException ioe) {
			System.err.println(ioe);
			return false;
		}
	}
	
	/**
	 * Returns a ByteBuffer containing everything available from the given InputStream
	 */
	public static final ByteBuffer streamToBuffer(BufferedInputStream in) throws IOException {
		byte[] buffer = new byte[in.available()];
		in.read(buffer, 0, buffer.length);
		return ByteBuffer.wrap(buffer);
	}
	
	/**
	 * Fully loads an Image into memory then converts to a BufferedImage
	 */
	public static BufferedImage loadImage(File file) throws IOException {
		Image image = new ImageIcon(Toolkit.getDefaultToolkit().getImage(file.getAbsolutePath())).getImage();
		BufferedImage buffImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
		
		Graphics g = buffImage.createGraphics();
		g.drawImage(image, 0, 0, null);
		g.dispose();
		
		return buffImage;
	}
	
}