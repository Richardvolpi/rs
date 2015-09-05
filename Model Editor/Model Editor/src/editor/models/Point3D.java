package editor.models;

public class Point3D
{

    private double x;
    private double y;
    private double z;

    public Point3D(double d, double e, double f)
    {
        this.x = d;
        this.y = e;
        this.z = f;
    }

    public double getX()
    {
        return x;
    }

    public void setX(double x)
    {
        this.x = x;
    }

    public double getY()
    {
        return y;
    }

    public void setY(double y)
    {
        this.y = y;
    }

    public double getZ()
    {
        return z;
    }

    public void setZ(double z)
    {
        this.z = z;
    }

    public void normalize()
    {
        double m = (double)Math.sqrt(x * x + y * y + z * z);
        x /= m;
        y /= m;
        z /= m;
    }
}
