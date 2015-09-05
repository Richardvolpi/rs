package editor.models.maths;

import java.util.Arrays;

import editor.models.Point3D;

public class Matrix
{

    private double globalMatrix[][];
    public static final double IDENTITY_MATRIX[][] = {
        {
            1.0F, 0.0F, 0.0F, 0.0F
        }, {
            0.0F, 1.0F, 0.0F, 0.0F
        }, {
            0.0F, 0.0F, 1.0F, 0.0F
        }, {
            0.0F, 0.0F, 0.0F, 1.0F
        }
    };

    public Matrix()
    {
        globalMatrix = new double[4][4];
        setMatrix(IDENTITY_MATRIX);
    }

    public void setMatrix(double source[][])
    {
        for(int x = 0; x < 4; x++)
        {
            System.arraycopy(source[x], 0, globalMatrix[x], 0, 4);
        }

    }

    public void multiplyMatrix(double matrix[][])
    {
        double newMatrix[][] = new double[4][4];
        for(int x = 0; x < 4; x++)
        {
            for(int y = 0; y < 4; y++)
            {
                newMatrix[x][y] = matrix[x][0] * globalMatrix[0][y] + matrix[x][1] * globalMatrix[1][y] + matrix[x][2] * globalMatrix[2][y] + matrix[x][3] * globalMatrix[3][y];
            }

        }

        setMatrix(newMatrix);
    }

    public Point3D multiplyVector(Point3D point)
    {
        Point3D newPoint = new Point3D(0.0F, 0.0F, 0.0F);
        newPoint.setX(point.getX() * globalMatrix[0][0] + point.getY() * globalMatrix[1][0] + point.getZ() * globalMatrix[2][0] + globalMatrix[3][0]);
        newPoint.setY(point.getX() * globalMatrix[0][1] + point.getY() * globalMatrix[1][1] + point.getZ() * globalMatrix[2][1] + globalMatrix[3][1]);
        newPoint.setZ(point.getX() * globalMatrix[0][2] + point.getY() * globalMatrix[1][2] + point.getZ() * globalMatrix[2][2] + globalMatrix[3][2]);
        return newPoint;
    }

    public String toString()
    {
        return (new StringBuilder()).append("Matrix [").append(Arrays.toString(globalMatrix[0])).append(", ").append(Arrays.toString(globalMatrix[1])).append(", ").append(Arrays.toString(globalMatrix[2])).append(Arrays.toString(globalMatrix[3])).append("]").toString();
    }

    public void resetMatrix()
    {
        setMatrix(IDENTITY_MATRIX);
    }

}
