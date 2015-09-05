package editor.utils;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import editor.models.*;
import editor.models.maths.Functions;
import editor.models.maths.Matrix;
import editor.models.maths.Transform;

public class ModelViewer extends JPanel implements Runnable, MouseListener, MouseMotionListener,
	MouseWheelListener, ComponentListener {

	private BufferedImage backBuffer;
	private Graphics bufferGraphics;
	public Model model;
	private boolean fillPolys;
	private boolean drawFrame = true;
	private boolean drawVerts;
	private boolean drawNormal;
	private boolean isRotating;
	private boolean isPanning;
	private double lastX;
	private double lastY;
	public Camera ourCamera;
	private int ambientLight;
	Polygon octagon;
	Ellipse2D.Double ellipse;
	GeneralPath ornament;

	public ModelViewer() {
		isRotating = false;
		isPanning = true;
		setAmbientLight(100000);
		backBuffer = new BufferedImage(500, 500, 1);
		bufferGraphics = backBuffer.getGraphics();
		ourCamera = new Camera(new Point3D(0.0F, 0.0F, -50F));
		fillPolys = true;
		drawNormal = false;
		addMouseListener(this);
		addMouseWheelListener(this);
		addMouseMotionListener(this);
		addComponentListener(this);
		(new Thread(this)).start();
	}

	public void setModel(Model model, Model model1) {
		this.model = model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	private void render() {
		Matrix globalMatrix = new Matrix();

		Transform.scale(globalMatrix, model.getXScale(), model.getYScale(),
				model.getZScale());
		Transform.rotate(globalMatrix, model.getXRot(), model.getYRot(),
				model.getZRot());
		Transform.translate(globalMatrix, model.getXTranslate(),
				model.getYTranslate(), model.getZTranslate());
		Vector vertices = model.getVertices();
		Vertex v;
		for (Iterator i$ = vertices.iterator(); i$.hasNext(); v
				.setWorldPoint(globalMatrix.multiplyVector(v.getLocalPoint()))) {
			v = (Vertex) i$.next();
		}

		globalMatrix.resetMatrix();
		Transform.translate(globalMatrix, ourCamera.getX(), ourCamera.getY(),
				ourCamera.getZ());
		Transform.rotate(globalMatrix, ourCamera.getAngleX(),
				ourCamera.getAngleY(), ourCamera.getAngleZ());
		Vertex bv;
		for (Iterator i$ = vertices.iterator(); i$.hasNext(); bv
				.setLocation(Transform.project(
						200,
						bv.getAlignedPoint(),
						new Point(backBuffer.getWidth() / 2, backBuffer
								.getHeight() / 2)))) {
			bv = (Vertex) i$.next();
			bv.setAlignedPoint(globalMatrix.multiplyVector(bv.getWorldPoint()));
		}

		bufferGraphics.clearRect(0, 0, backBuffer.getWidth(),
				backBuffer.getHeight());
		Vector<?> facesV = model.getFaces();
		Face faces[] = (Face[]) facesV.toArray(new Face[facesV.size()]);

		Face arr$[] = faces;
		int len$ = arr$.length;
		for (int i$ = 0; i$ < len$; i$++) {
			Face f = arr$[i$];
			if (Functions.isBackface(model, f)) {
				continue;
			}
			int xPoints[] = new int[f.getPoints().length];
			int yPoints[] = new int[f.getPoints().length];
			for (int i = 0; i < xPoints.length; i++) {
				xPoints[i] = (int) model.getVert(f.getPoints()[i]).getX();
			}

			for (int i = 0; i < xPoints.length; i++) {
				yPoints[i] = (int) model.getVert(f.getPoints()[i]).getY();
			}
			if (fillPolys) {
				if (f.getImage() != -1) {
				} else {
					Color faceColor = new Color(f.getFaceColor().getRGB());
					int light = Functions.getLightIntensity(model, f,
							ambientLight);
					for (int i = 0; i < light; i++) {
						int red = faceColor.getRed();
						int green = faceColor.getGreen();
						int blue = faceColor.getBlue();
						int redFivePercent = faceColor.getRed() / 10 / 2;
						int greenFivePercent = faceColor.getGreen() / 10 / 2;
						int blueFivePercent = faceColor.getBlue() / 10 / 2;
						red -= redFivePercent;
						green -= greenFivePercent;
						blue -= blueFivePercent;
						faceColor = new Color(red, green, blue);
					}

					bufferGraphics.setColor(faceColor);
					bufferGraphics
							.fillPolygon(xPoints, yPoints, xPoints.length);
				}
			}
			if (drawFrame) {
				bufferGraphics.setColor(Color.BLUE);
				bufferGraphics.drawPolygon(xPoints, yPoints, xPoints.length);
			}
			if (drawVerts) {
				for (int x = 0; x < 3; x++) {
					bufferGraphics.setColor(Color.GREEN);
					bufferGraphics.fillRect(xPoints[x] - 3, yPoints[x] - 3, 6,
							6);
					bufferGraphics.drawString(String.valueOf(f.getPoints()[x]),
							xPoints[x] + 5, yPoints[x] + 5);
				}

			}
			bufferGraphics.setColor(Color.CYAN);
		}
		bufferGraphics.setColor(Color.RED);
		bufferGraphics.drawString("Faces: " + model.getFaces().size(), 10, 10);
		bufferGraphics.drawString("Vertices: " + model.getVertices().size(),
				10, 20);
		bufferGraphics
				.drawString("Textures: " + model.getNumTextures(), 10, 30);
	}

	public void paint(Graphics graphics) {
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, getWidth(), getHeight());
		if (model != null) {
			render();
			graphics.drawImage(backBuffer, 0, 0, this);
		}
	}

	public void update(Graphics graphics) {
		super.update(graphics);
	}

	public void repaint() {
		super.repaint();
	}

	public void setSize(int i, int i1) {
		backBuffer = new BufferedImage(i, i1, 1);
		bufferGraphics = backBuffer.getGraphics();
		super.setSize(i, i1);
	}

	public void run() {
		do {
			repaint();
			try {
				Thread.sleep(25L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (true);
	}

	public boolean isFillPolys() {
		return fillPolys;
	}

	public void setFillPolys(boolean fillPolyss) {
		fillPolys = fillPolyss;
	}

	public boolean isDrawFrame() {
		return drawFrame;
	}

	public void setDrawFrame(boolean drawFramee) {
		drawFrame = drawFramee;
	}

	public boolean isDrawVerts() {
		return drawVerts;
	}

	public void setDrawVerts(boolean drawVerts1) {
		drawVerts = drawVerts1;
	}

	public void mouseClicked(MouseEvent mouseevent) {
	}

	public void mousePressed(MouseEvent mouseEvent) {
		if (mouseEvent.getButton() == 1) {
			isRotating = true;
			lastX = mouseEvent.getPoint().getX();
			lastY = mouseEvent.getPoint().getY();
		}
		if (mouseEvent.getButton() == 3) {
			isPanning = true;
			lastX = mouseEvent.getPoint().getX();
			lastY = mouseEvent.getPoint().getY();
		}
	}

	public void mouseReleased(MouseEvent mouseEvent) {
		if (mouseEvent.getButton() == 1) {
			isRotating = false;
		}
		if (mouseEvent.getButton() == 3) {
			isPanning = false;
		}
	}

	public void mouseEntered(MouseEvent mouseevent) {
	}

	public void mouseExited(MouseEvent mouseevent) {
	}

	public void mouseDragged(MouseEvent mouseEvent) {
		int x = (int) mouseEvent.getPoint().getX();
		int y = (int) mouseEvent.getPoint().getY();
		if (isRotating && model != null) {
			int dx = (int) (lastX - (double) x);
			int dy = (int) ((double) y - lastY);
			double sensitivity = 2.5D;
			double speed = 200D;
			model.setXRot((float) ((double) model.getXRot() + ((double) dy * sensitivity)
					/ speed));
			model.setYRot((float) ((double) model.getYRot() + ((double) dx * sensitivity)
					/ speed));
			lastX = x;
			lastY = y;
		}
		if (isPanning && model != null) {
			int dx = (int) (lastX - (double) x);
			int dy = (int) ((double) y - lastY);
			ourCamera.setX(ourCamera.getX() + (float) dx);
			ourCamera.setY(ourCamera.getY() - (float) dy);
			lastX = x;
			lastY = y;
		}
	}

	public void mouseMoved(MouseEvent mouseEvent)

	{
	}

	public void mouseWheelMoved(MouseWheelEvent mouseWheelEvent) {
		int zoomAmount = mouseWheelEvent.getUnitsToScroll();
		if (mouseWheelEvent.isControlDown()) {
			zoomAmount *= 2;
		}
		ourCamera.setZ(ourCamera.getZ() - (float) zoomAmount);
	}

	public Camera getOurCamera() {
		return ourCamera;
	}

	public void componentResized(ComponentEvent e) {
		if (getWidth() != 0 && getHeight() != 0) {
			backBuffer = new BufferedImage(getWidth(), getHeight(), 1);
			bufferGraphics = backBuffer.getGraphics();
		}
	}

	private Image loadImage() {
		Image image;
		try {
			image = ImageIO.read(new File("4.png"));
			return image;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	int polyWidth = 100;
	int polyHeight = polyWidth;

	public void componentMoved(ComponentEvent componentevent) {
	}

	public void componentShown(ComponentEvent componentevent) {
	}

	public void componentHidden(ComponentEvent componentevent) {
	}

	public int getAmbientLight() {
		return ambientLight;
	}

	public void setAmbientLight(int ambientLight) {
		this.ambientLight = ambientLight;
	}
}
