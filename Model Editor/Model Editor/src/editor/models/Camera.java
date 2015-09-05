package editor.models;

public class Camera {

	private Point3D cameraPosition;
	private double angleX;
	private double angleY;
	private double angleZ;

	public Camera(Point3D cameraPosition) {
		this.cameraPosition = cameraPosition;
		angleX = angleY = angleZ = 0.0F;
	}

	public double getX() {
		return cameraPosition.getX();
	}

	public void setX(double x) {
		cameraPosition.setX(x);
	}

	public double getY() {
		return cameraPosition.getY();
	}

	public void setY(double y) {
		cameraPosition.setY(y);
	}

	public double getZ() {
		return cameraPosition.getZ();
	}

	public void setZ(double z) {
		cameraPosition.setZ(z);
	}

	public double getAngleX() {
		return angleX;
	}

	public void setAngleX(double angleX) {
		this.angleX = angleX;
	}

	public double getAngleY() {
		return angleY;
	}

	public void setAngleY(double angleY) {
		this.angleY = angleY;
	}

	public double getAngleZ() {
		return angleZ;
	}

	public void setAngleZ(double angleZ) {
		this.angleZ = angleZ;
	}
}
