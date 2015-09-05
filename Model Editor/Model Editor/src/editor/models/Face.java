package editor.models;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Face {

	private int points[];
	private Color faceColor;
	private int image = -1;
	public Face(Color c, int points[]) {
		this.points = points;
		faceColor = c;
	}
	
	public Face(int image, int points[]) {
		this.points = points;
		this.image = image;
	}
	
	public Face(int[] points) {
		this.points = points;
		faceColor = Color.RED;
	}

	public int getImage() {
		return image;
	}

	public int[] getPoints() {
		return points;
	}

	public Color getFaceColor() {
		return faceColor;
	}

	public void setFaceColor(Color faceColor) {
		this.faceColor = faceColor;
	}
}
