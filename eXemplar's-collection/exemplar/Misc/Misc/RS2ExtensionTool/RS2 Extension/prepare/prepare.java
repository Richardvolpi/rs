import java.io.*;
public class prepare
{
	public static void main(String[] args)
	{
		String[] filenames = new File(args[0]).list();
		File[] files = new File(args[0]).listFiles();
		System.out.println("Definalizing: "+args[0]+" "+args[1]);
		for(int n=0; n<filenames.length; n++)
			if(filenames[n].endsWith("."+args[1]))
			{
				System.out.println(filenames[n]);
				try
				{
					FileInputStream fistream = new FileInputStream(files[n]);
					DataInputStream in = new DataInputStream(fistream);
					File newfile = new File(args[0]+filenames[n]+"a");
					FileOutputStream fostream = new FileOutputStream(newfile);
					PrintStream out = new PrintStream(fostream);
					int b = 0;
					int c = 0;
					while(in.available() != 0)
					{
						String line = in.readLine();
						int a;
						while((a = line.indexOf("final ")) != -1)
						{
							b++;
							String line1 = line.substring(0,a);
							line = line1 + line.substring(a+6,line.length());
						}
						while((a = line.indexOf("private ")) != -1)
						{
							c++;
							String line1 = line.substring(0,a);
							line = line1 + "public " + line.substring(a+8,line.length());
						}
						out.println(line);
					}
					fistream.close();
					fostream.close();
					files[n].delete();
					newfile.renameTo(new File(args[0]+filenames[n]));
				} catch(IOException e) { System.out.println("Error"); }
			}
	}
}