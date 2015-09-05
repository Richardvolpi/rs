import java.io.*;
public class Rs_unencoder
{
    public static void main(String[] args) throws Exception
    {
        File file = new File(".file_store_32/zko34");
        FileInputStream fis = new FileInputStream(file);
        byte[] fileBytes = new byte[(int)file.length()];
        fis.read(fileBytes);
        System.out.println(fileBytes.length);
        int i1 = ((fileBytes[0] & 0xff) << 16) + ((fileBytes[1] & 0xff) << 8) + (fileBytes[2] & 0xff);
        int j1 = ((fileBytes[3] & 0xff) << 16) + ((fileBytes[4] & 0xff) << 8) + (fileBytes[5] & 0xff);
        byte[] inputBytes = new byte[fileBytes.length-6];
        System.arraycopy(fileBytes, 6, inputBytes, 0, inputBytes.length);
        byte[] outputBytes = new byte[i1];
        a.b.a(outputBytes,i1,inputBytes, j1,0);
        FileOutputStream fos = new FileOutputStream("graphics");
        fos.write(outputBytes);
        fos.close();
    }
}
