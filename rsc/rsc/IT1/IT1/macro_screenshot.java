/*
 * macro_screenshot.java
 *
 * Created on October 29, 2003, 4:15 PM
 */

/**
 *
 * @author  harperart
 */
public class macro_screenshot extends Macro
{
    
    /** Creates a new instance of macro_screenshot */
    public macro_screenshot(mudclient_Debug rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"screen"};
    }
    public void start(String command)
    {
        try
        {
            java.io.File f;
            int i = 0;
            while(i < Integer.MAX_VALUE)
            {
                f = new java.io.File("rs_screen"+i+".png");
                if(!f.exists())
                {
                   java.lang.reflect.Field imageProducerField = a.a.g.class.getDeclaredField("h");
                    imageProducerField.setAccessible(true);
                    java.awt.image.ImageConsumer imageConsumer = (java.awt.image.ImageConsumer)imageProducerField.get(rs.bO);
                    com.keypoint.PngEncoder encoder = new com.keypoint.PngEncoder(rs.bO.j,false,0,9);
                   java.io.FileOutputStream fos = new java.io.FileOutputStream(f);
                   fos.write(encoder.pngEncode());
                   imageProducerField.set(rs.bO,imageConsumer);
                   rs.displayMessage("screen shot saved as:"+f);
                   break;
                }
                i++;
            }
        }
        catch(Exception e)
        {
            rs.displayMessage("error writing file(see command window)");
            e.printStackTrace();
        }
    }
}
