package com.rscd.sprite;

import java.awt.image.*;
import java.awt.*;

public class SpriteHandler implements ImageProducer, ImageObserver {
	public int WIDTH;
	public int HEIGHT;
	protected int[] imagePixelArray;
	
	private Image image;
	private ImageConsumer imageConsumer;
	private ColorModel colorModel;
	
	public SpriteHandler(Component component, int width, int height) {
		image = component.createImage(this);
		this.WIDTH = width;
		this.HEIGHT = height;
		colorModel = new DirectColorModel(32, 0xff0000, 65280, 255);
		reset();
	}
	
	public int getPixel(int i) {
		return imagePixelArray[i];
	}
	
	public int[] getPixels() {
		return imagePixelArray;
	}
	
	public void reset() {
		imagePixelArray = new int[WIDTH * HEIGHT];
		for(int c = 0;c < imagePixelArray.length;c++) {
			imagePixelArray[c] = 0;
		}
	}
	
	private synchronized void completePixels() {
		if (imageConsumer == null) {
			return;
		}
		imageConsumer.setPixels(0, 0, WIDTH, HEIGHT, colorModel, imagePixelArray, 0, WIDTH);
		imageConsumer.imageComplete(2);
	}
	
	public void drawImage(Graphics g, int x, int y) {
		completePixels();
		g.drawImage(image, x, y, this);
	}
	
	public synchronized void addConsumer(ImageConsumer imageconsumer) {
		imageConsumer = imageconsumer;
		imageconsumer.setDimensions(WIDTH, HEIGHT);
		imageconsumer.setProperties(null);
		imageconsumer.setColorModel(colorModel);
		imageconsumer.setHints(14);
	}
	
	public synchronized boolean isConsumer(ImageConsumer imageconsumer) {
		return imageConsumer == imageconsumer;
	}
	
	public synchronized void removeConsumer(ImageConsumer imageconsumer) {
		if (imageConsumer == imageconsumer)
			imageConsumer = null;
	}
	
	public void startProduction(ImageConsumer imageconsumer) {
		addConsumer(imageconsumer);
	}
	
	public void requestTopDownLeftRightResend(ImageConsumer imageconsumer) {
		System.out.println("TDLR");
	}
	
	public boolean imageUpdate(Image image, int i, int j, int k, int l, int i1) {
		return true;
	}
	
}