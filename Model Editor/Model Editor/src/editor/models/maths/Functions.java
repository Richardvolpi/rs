package editor.models.maths;

import editor.models.Face;
import editor.models.Model;
import editor.models.Point3D;
import editor.models.Vertex;

public class Functions
{

    public Functions()
    {
    }

    public static double[][] getPlaneVars(Model model, Face f)
    {
    	double vars[][] = new double[3][3];
        for(int i = 0; i < 3; i++)
        {
            vars[0][i] = model.getVert(f.getPoints()[i]).getAlignedPoint().getX();
            vars[1][i] = model.getVert(f.getPoints()[i]).getAlignedPoint().getY();
            vars[2][i] = model.getVert(f.getPoints()[i]).getAlignedPoint().getZ();
        }

        return vars;
    }

    public static boolean isBackface(Model model, Face f)
    {
        double vars[][] = getPlaneVars(model, f);
        double x1 = vars[0][0];
        double x2 = vars[0][1];
        double x3 = vars[0][2];
        double y1 = vars[1][0];
        double y2 = vars[1][1];
        double y3 = vars[1][2];
        double z1 = vars[2][0];
        double z2 = vars[2][1];
        double z3 = vars[2][2];
        double x = -x1 * (y2 * z3 - y3 * z2) - x2 * (y3 * z1 - y1 * z3) - x3 * (y1 * z2 - y2 * z1);
        return x < 0.0F;
    }

    public static int getLightIntensity(Model model, Face f, int ambient)
    {
        double vars[][] = getPlaneVars(model, f);
        double x1 = vars[0][0];
        double x2 = vars[0][1];
        double x3 = vars[0][2];
        double y1 = vars[1][0];
        double y2 = vars[1][1];
        double y3 = vars[1][2];
        double z1 = vars[2][0];
        double z2 = vars[2][1];
        double z3 = vars[2][2];
        Point3D planeNormal = crossProduct(new Point3D(x2 - x1, y2 - y1, z2 - z1), new Point3D(x3 - x1, y3 - y1, z3 - z1));
        planeNormal.normalize();
        Vertex lightSource = new Vertex(0.0F, 0.0F, 0.0F);
        Matrix lightMatrix = new Matrix();
        Transform.translate(lightMatrix, 100F, 100F, 100F);
        Transform.rotate(lightMatrix, 0.0F, 96F, 128F);
        lightSource.setWorldPoint(lightMatrix.multiplyVector(lightSource.getLocalPoint()));
        int MAX_LIGHT = 10;
        int light = (int)(10F * dotProduct(planeNormal, lightSource.getWorldPoint()) + (double)ambient);
        if(light > 10)
        {
            light = 10;
        }
        if(light < 0)
        {
            light = 0;
        }
        light = -light + 10;
        return light;
    }

    public static double dotProduct(Point3D v1, Point3D v2)
    {
        return v1.getX() * v2.getX() + v1.getY() * v2.getY() + v1.getZ() * v2.getZ();
    }

    public static Point3D crossProduct(Point3D v1, Point3D v2)
    {
        return new Point3D(v1.getY() * v2.getZ() - v1.getZ() * v2.getY(), v1.getZ() * v2.getX() - v1.getX() * v2.getZ(), v1.getX() * v2.getY() - v1.getY() * v2.getX());
    }

    public static Point3D subtractVerts(Point3D v1, Point3D v2)
    {
        return new Point3D(v1.getX() - v2.getX(), v1.getY() - v2.getY(), v1.getZ() - v2.getZ());
    }
}
