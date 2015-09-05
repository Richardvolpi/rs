package bot;

import java.io.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ColorConvertOp;
import java.awt.color.ColorSpace;

public class Functions {
	public static File getEmptyFile() throws IOException {
		File file = new File("sleepwords");
		if(!file.exists() || !file.isDirectory()) {
			file.mkdir();
		}
		String folder = file.getPath() + File.separator;
		file = null;
		for(int suffix = 0;file == null || file.exists();suffix++) {
			file = new File(folder + "screenshot" + suffix + ".png");
		}
		return file;
	}
	
	public static BufferedImage convertToGrayscale(BufferedImage source) { 
		BufferedImageOp op = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null); 
		return op.filter(source, null);
	}
	
	public static String parseSleepWord(String s) {
		String letters = "abcdefghijklmnopqrstuvwxyz ";
		String r = "";
		s = s.toLowerCase().trim();
		for(int j = 0; j < s.length(); j++) {
			boolean found = false;
			for(int i = 0; i < letters.length(); i++)
				if(s.charAt(j) == letters.charAt(i))
					found = true;
			if(found)
				r += s.charAt(j);
		}
		return r;
	}
	
	public static boolean inArray(String s, String[] arr) {
		for(String s1 : arr)
			if(s.equals(s1))
				return true;
		return false;
	}
	
	public static boolean inArray(int i, int[] arr) {
		for(int i1 : arr)
			if(i == i1)
				return true;
		return false;
	}
}