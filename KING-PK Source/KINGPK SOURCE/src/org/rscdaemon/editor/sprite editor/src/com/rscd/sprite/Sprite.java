package com.rscd.sprite;

import com.rscd.sprite.util.PersistenceManager;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.*;

public class Sprite {
	private static final int TRANSPARENT = Color.BLACK.getRGB();
	
	private int[] pixels;
	private int width;
	private int height;
	
	/** WARNING: packageName, id, xShift, yShift, something1, something2 are lost when loading from img. **/
	
	private String packageName = "unknown";
	private int id = -1;
	
	private int xShift = 0;
	private int yShift = 0;
	
	private int something1 = 0;
	private int something2 = 0;
	
	public Sprite(int[] pixels, int width, int height) {
		this.pixels = pixels;
		this.width = width;
		this.height = height;
	}
	
	public void setSomething(int something1, int something2) {
		this.something1 = something1;
		this.something2 = something2;
	}
	
	public int getSomething1() {
		return something1;
	}
	
	public int getSomething2() {
		return something2;
	}
	
	public void setName(int id, String packageName) {
		this.id = id;
		this.packageName = packageName;
	}
	
	public int getID() {
		return id;
	}
	
	public String getPackageName() {
		return packageName;
	}
	
	public void setShift(int xShift, int yShift) {
		this.xShift = xShift;
		this.yShift = yShift;
	}
	
	public boolean requiresShift() {
		return xShift != 0 || yShift != 0;
	}
	
	public int getXShift() {
		return xShift;
	}
	
	public int getYShift() {
		return yShift;
	}
	
	public int[] getPixels() {
		return pixels;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	/** IO Operations **/
	
	public void serializeTo(File file) throws IOException {
		PersistenceManager.write(file, this);
	}
	
	public static Sprite deserializeFrom(File file) throws IOException, ClassNotFoundException {
		return (Sprite)PersistenceManager.load(file);
	}
	
	public BufferedImage toImage() {
      		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
      		for(int y = 0;y < height;y++) {
      			for(int x = 0;x < width;x++) {
      				img.setRGB(x, y, pixels[x + y * width]);
      			}
      		}
      		return img;
	}
	
	public static Sprite fromImage(BufferedImage img) {
      		int[] pixels = new int[img.getWidth() * img.getHeight()];
      		for(int y = 0;y < img.getHeight();y++) {
      			for(int x = 0;x < img.getWidth();x++) {
      				int rgb = img.getRGB(x, y);
      				if(rgb == TRANSPARENT) {
      					rgb = 0;
      				}
      				pixels[x + y * img.getWidth()] = rgb;
      			}
      		}
      		return new Sprite(pixels, img.getWidth(), img.getHeight());
	}
}