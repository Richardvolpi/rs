import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * A command-line interface RSCD file 
 * compressor and decompressor.
 */

public class DefCompressor
{
	private final static String INPUT = ".\\input\\";
	private final static String OUTPUT = ".\\output\\";
	
    public static void main(String args[]) throws Exception
    {
    	System.out.println("RSCD File Compression Tool v1.0");
    	System.out.println("-------------------------------");
    	System.out.println();
    	
        if(args[0].equals("compress"))
        	if(args[1].equals("all"))
        		processAll(true);
        	else
            	compressFile(new File(args[1]));
        else
        if(args[0].equals("decompress"))
        	if(args[1].equals("all"))
        		processAll(false);
        	else
            	decompressFile(new File(args[1]));
    }
    
    public static void processAll(boolean type)
    {
    	System.out.println((type ? "Compress" : "Decompress") + " all.");
    	System.out.println((type ? "-------------" : "---------------"));
    	System.out.println();
    	
    	File inputDir = new File(INPUT);
        String[] files = inputDir.list();
        
        for(int i = 0; i < files.length; i++)
        {
        	try
        	{
	        	if(type)
	        	{
	        		//if(files[i].endsWith(".xml"))
	        			compressFile(files[i]);
	        	} else
	        	{
	        		if(files[i].endsWith(".rscd"))
	        			decompressFile(files[i]);
	        	}
        	} catch(Exception e)
        	{
        		System.err.println("[e] " + (type ? "Compression" : "Decompression") + " error: " + e);
        		System.out.println();
        	}		
        }
    }
    
    public static void compressFile(String s) throws Exception { compressFile(new File(s)); }
    public static void decompressFile(String s) throws Exception { decompressFile(new File(s)); }

    public static void compressFile(File orig) throws IOException
    {
    	File file = new File(INPUT + orig.toString());
    	File target = new File(OUTPUT + orig.toString().replaceAll(".xml", ".xml.gz"));
    	
    	System.out.println("    Compressing \"" + file.getName() + "\" into \"" + target + "\"");
        long l = file.length();
        
        FileInputStream fileinputstream = new FileInputStream(file);
        GZIPOutputStream gzipoutputstream = new GZIPOutputStream(new FileOutputStream(target));
        
        byte abyte0[] = new byte[1024];
        int i;
        
        while((i = fileinputstream.read(abyte0)) != -1) 
            gzipoutputstream.write(abyte0, 0, i);

        fileinputstream.close();
        gzipoutputstream.close();
        
        long l1 = target.length();
        System.out.println("    Initial size: " + l + "; Compressed size: " + l1 + ".");
        System.out.println("    Done.");
        System.out.println();
    }

    public static void decompressFile(File orig) throws IOException
    {
    	File file = new File(INPUT + orig.toString());
        File target = new File(OUTPUT + orig.toString().replaceAll(".xml.gz", ".xml"));
        
        System.out.println("    Decompressing \"" + file.getName() + "\" into \"" + target + "\"");

        long l = file.length();
        
        GZIPInputStream gzipinputstream = new GZIPInputStream(new FileInputStream(file));
        FileOutputStream fileoutputstream = new FileOutputStream(target);
        
        byte abyte0[] = new byte[1024];
        int i;
        
        while((i = gzipinputstream.read(abyte0)) != -1) 
            fileoutputstream.write(abyte0, 0, i);

        fileoutputstream.close();
        gzipinputstream.close();
        
        long l1 = target.length();
        System.out.println("    Initial size: " + l + "; Decompressed size: " + l1 + ".");
        System.out.println("    Done.");
        System.out.println();
    }
}