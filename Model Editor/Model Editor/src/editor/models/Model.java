package editor.models;

import java.util.Vector;

public class Model
{

    private Vector vertices;
    private Vector faces;
    private float xRot;
    private float yRot;
    private float zRot;
    private float xScale;
    private float yScale;
    private float zScale;
    private float xTranslate;
    private float yTranslate;
    private float zTranslate;
    private int numTextures = 0;

    public Model(Vector<Vertex> vertices, Vector<Face> faces)
    {
        this.vertices = new Vector();
        this.faces = new Vector();
        this.faces = faces;
        this.vertices = vertices;
        xRot = yRot = zRot = 0.0F;
        xScale = yScale = zScale = 1.0F;
        xTranslate = yTranslate = zTranslate = 0.0F;
    }
    
    public Model(Vector<Vertex> vertices, Vector<Face> faces, Vector<Vertex> vertices1, Vector<Face> faces1)
    {
        this.vertices = new Vector();
        this.faces = new Vector();
        this.faces = faces;
        this.vertices = vertices;
        xRot = yRot = zRot = 0.0F;
        xScale = yScale = zScale = 1.0F;
        xTranslate = yTranslate = zTranslate = 0.0F;
    }

    public Model()
    {
        vertices = new Vector();
        faces = new Vector();
        faces = new Vector();
        vertices = new Vector();
        xRot = yRot = zRot = 0.0F;
        xScale = yScale = zScale = 1.0F;
        xTranslate = yTranslate = zTranslate = 0.0F;
    }

    public boolean addFace(Face face)
    {
        return faces.add(face);
    }

    public Face getFace(int i)
    {
        return (Face)faces.get(i);
    }

    public Face removeFace(int i)
    {
        return (Face)faces.remove(i);
    }

    public Vector getFaces()
    {
        return faces;
    }

    public boolean addVert(Vertex vertex)
    {
        return vertices.add(vertex);
    }

    public Vertex removeVert(int i)
    {
        return (Vertex)vertices.remove(i);
    }

	public Vertex getVert(int i) {
		return (Vertex) vertices.get(i);
	}

    public Vector getVertices()
    {
        return vertices;
    }

    public void setVertices(Vector vertices)
    {
        this.vertices = vertices;
    }

    public void setFaces(Vector faces)
    {
        this.faces = faces;
    }

    public float getXRot()
    {
        return xRot;
    }

    public void setXRot(float xRot)
    {
        if(xRot > 360F)
        {
            xRot -= 360F;
        } else
        if(xRot < -360F)
        {
            xRot += 360F;
        }
        this.xRot = xRot;
    }

    public float getYRot()
    {
        return yRot;
    }

    public void setYRot(float yRot)
    {
        if(yRot > 360F)
        {
            yRot -= 360F;
        } else
        if(yRot < -360F)
        {
            yRot += 360F;
        }
        this.yRot = yRot;
    }

    public float getZRot()
    {
        return zRot;
    }

    public void setZRot(float zRot)
    {
        if(zRot > 360F)
        {
            zRot -= 360F;
        } else
        if(zRot < -360F)
        {
            zRot += 360F;
        }
        this.zRot = zRot;
    }

    public float getXScale()
    {
        return xScale;
    }

    public void setXScale(float xScale)
    {
        this.xScale = xScale;
    }

    public float getYScale()
    {
        return yScale;
    }

    public void setYScale(float yScale)
    {
        this.yScale = yScale;
    }

    public float getZScale()
    {
        return zScale;
    }

    public void setZScale(float zScale)
    {
        this.zScale = zScale;
    }

    public void setScale(float scale)
    {
        setXScale(scale);
        setYScale(scale);
        setZScale(scale);
    }

    public float getXTranslate()
    {
        return xTranslate;
    }

    public void setXTranslate(float xTranslate)
    {
        this.xTranslate = xTranslate;
    }

    public float getYTranslate()
    {
        return yTranslate;
    }

    public void setYTranslate(float yTranslate)
    {
        this.yTranslate = yTranslate;
    }

    public float getZTranslate()
    {
        return zTranslate;
    }

    public void setZTranslate(float zTranslate)
    {
        this.zTranslate = zTranslate;
    }

	public void setNumTextures(int numTextures) {
		this.numTextures = numTextures;
	}

	public int getNumTextures() {
		return numTextures;
	}
}
