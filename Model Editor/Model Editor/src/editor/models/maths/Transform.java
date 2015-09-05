package editor.models.maths;

import java.awt.Point;

import editor.models.Point3D;

public class Transform {

	public Transform() {
	}

	public static void translate(Matrix matrix, double d, double e, double f) {
		double translateMatrix[][] = { { 1.0F, 0.0F, 0.0F, 0.0F },
				{ 0.0F, 1.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 1.0F, 0.0F },
				{ d, e, f, 1.0F } };
		matrix.multiplyMatrix(translateMatrix);
	}

	public static void scale(Matrix matrix, double x, double y, double z) {
		double scaleMatrix[][] = { { x, 0.0F, 0.0F, 0.0F },
				{ 0.0F, y, 0.0F, 0.0F }, { 0.0F, 0.0F, z, 0.0F },
				{ 0.0F, 0.0F, 0.0F, 1.0F } };
		matrix.multiplyMatrix(scaleMatrix);
	}

	public static void rotateX(Matrix matrix, double rotation) {
		double xRotMatrix[][] = {
				{ 1.0F, 0.0F, 0.0F, 0.0F },
				{ 0.0F, (double) cos(rotation), (double) sin(rotation), 0.0F },
				{ 0.0F, (double) (-sin(rotation)), (double) cos(rotation), 0.0F },
				{ 0.0F, 0.0F, 0.0F, 1.0F } };
		matrix.multiplyMatrix(xRotMatrix);
	}

	public static void rotateY(Matrix matrix, double rotation) {
		double yRotMatrix[][] = {
				{ (double) cos(rotation), 0.0F, (double) (-sin(rotation)), 0.0F },
				{ 0.0F, 1.0F, 0.0F, 0.0F },
				{ (double) sin(rotation), 0.0F, (double) cos(rotation), 0.0F },
				{ 0.0F, 0.0F, 0.0F, 1.0F } };
		matrix.multiplyMatrix(yRotMatrix);
	}

	public static void rotateZ(Matrix matrix, double rotation) {
		double zRotMatrix[][] = {
				{ (double) cos(rotation), (double) sin(rotation), 0.0F, 0.0F },
				{ (double) (-sin(rotation)), (double) cos(rotation), 0.0F, 0.0F },
				{ 0.0F, 0.0F, 1.0F, 0.0F }, { 0.0F, 0.0F, 0.0F, 1.0F } };
		matrix.multiplyMatrix(zRotMatrix);
	}

	public static void rotate(Matrix matrix, double x, double y, double z) {
		rotateX(matrix, x);
		rotateY(matrix, y);
		rotateZ(matrix, z);
	}

	public static Point project(int distance, Point3D v, Point center) {
		Point screenPoint = new Point();
		if (v.getX() == 0.0F) {
			v.setX(1.0F);
		}
		screenPoint.setLocation(
				(double) (((double) distance * v.getX()) / v.getZ())
						+ center.getX(),
				(double) (((double) distance * v.getY()) / v.getZ())
						+ center.getY());
		return screenPoint;
	}

	private static double cos(double theta) {
		return StrictMath.cos(theta);
	}

	private static double sin(double theta) {
		return StrictMath.sin(theta);
	}
}
