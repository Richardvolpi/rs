/*
 *      AClassLoader.java
 */
 
package org.apello.util;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;

public class AClassLoader extends ClassLoader {
    public AClassLoader(String cp){
        super(AClassLoader.class.getClassLoader());
        classPath = !cp.endsWith(File.separatorChar + "") ? cp += File.separatorChar : cp;
    }
    
    private String classPath;
    
    // the class path where this loader will look for .class files
    public String getClassPath(){
        return classPath;
    }

    // try to find the class by className, not case sensitive
    public Class findClass(String className) throws ClassNotFoundException{
        File cp = new File(classPath);
        if(!cp.isDirectory())
            throw new ClassNotFoundException("Invalid Class Path: " + classPath);
        
        if(!cp.canRead())
            throw new ClassNotFoundException("No read access to class path: " + classPath);
            
        String[] files = cp.list();
        if(files == null)
            throw new ClassNotFoundException("Failed to read classpath: " + classPath);
        
        for(int i = 0; i < files.length; i++){
            if(files[i].equalsIgnoreCase(className + ".class"))
                return loadClass(files[i].substring(0, className.length()), new File(classPath + files[i]));
        }
        throw new ClassNotFoundException("Class Was Not Found In Class Path");
    }
    
    // Loads class from disk
    public Class loadClass(String className, File f) throws ClassNotFoundException {
        byte classBytes[];
        Class result = null;
        try{
            classBytes = loadClassData(f);
        }catch(Exception e){
            throw new ClassNotFoundException(e.getMessage());
        }
        result = defineClass(className, classBytes, 0, classBytes.length, null);
        return result;
    }
 
    //load class byte[] data  from disk
    private byte[] loadClassData(File f) throws IOException{
        int size = (int)f.length();
        byte buff[] = new byte[size];
        FileInputStream fis = new FileInputStream(f);
        DataInputStream dis = new DataInputStream(fis);
        dis.readFully(buff);
        dis.close();
        return buff;
    }
}
