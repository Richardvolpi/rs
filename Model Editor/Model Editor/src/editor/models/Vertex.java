package editor.models;

import java.awt.Point;

public class Vertex extends Point
{

    private Point3D localPoint;
    private Point3D worldPoint;
    private Point3D alignedPoint;

    public Vertex(double d, double e, double f)
    {
        localPoint = new Point3D(d, e, f);
    }

    public Vertex(Point3D localPoint)
    {
        this.localPoint = localPoint;
    }

    public Point3D getLocalPoint()
    {
        return localPoint;
    }

    public void setLocalPoint(Point3D localPoint)
    {
        this.localPoint = localPoint;
    }

    public Point3D getWorldPoint()
    {
        return worldPoint;
    }

    public void setWorldPoint(Point3D worldPoint)
    {
        this.worldPoint = worldPoint;
    }

    public Point3D getAlignedPoint()
    {
        return alignedPoint;
    }

    public void setAlignedPoint(Point3D alignedPoint)
    {
        this.alignedPoint = alignedPoint;
    }
}
