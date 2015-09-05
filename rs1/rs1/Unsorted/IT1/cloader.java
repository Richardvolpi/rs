import java.io.DataInputStream;
import java.io.FilterInputStream;
import java.util.Hashtable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class cloader extends ClassLoader
{

            private Hashtable cache;
            ZipFile zip;
            Class link;

            public cloader()
            {
/*   8*/        cache = new Hashtable();
            }

            public final synchronized Class loadClass(String name, boolean resolve)
                throws ClassNotFoundException
            {
/*  17*/        Class result = (Class)cache.get(name);
/*  18*/        if(result != null)
/*  18*/            return result;
/*  20*/        try
                {
/*  20*/            result = super.findSystemClass(name);
/*  20*/            return result;
                }
/*  21*/        catch(ClassNotFoundException e) { }
/*  23*/        if(name.equals("link"))
/*  23*/            return link;
/*  26*/        try
                {
/*  26*/            ZipEntry ze = zip.getEntry(name.replace('.', '/') + ".class");
/*  26*/            int len = (int)ze.getSize();
/*  27*/            DataInputStream di = new DataInputStream(zip.getInputStream(ze));
/*  28*/            byte buf[] = new byte[len];
/*  28*/            di.readFully(buf);
/*  28*/            di.close();
/*  29*/            result = defineClass(buf, 0, buf.length);
/*  30*/            if(resolve)
/*  30*/                resolveClass(result);
/*  31*/            cache.put(name, result);
                }
/*  33*/        catch(Exception e) { }
/*  34*/        return result;
            }
}