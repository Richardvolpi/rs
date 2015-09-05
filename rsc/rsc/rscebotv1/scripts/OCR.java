import bot.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.InputStream;
public class OCR extends Methods {
	public Client mc;
	public OCR(bot.Client mc){super(mc);this.mc=mc;}
	public void main(String args[]) {
		try {
			System.out.println("OCR script started");
			while(true) {
				String word = "", ocrWord = "";
				while(fatigue() == 100 && !sleeping()) {
					useItem(getItemSlot(1263));
					wait(1000);
				}
				String path = "media" + File.separator + mc.aClass31_1156.aString294 + File.separator;
				if(sleeping()) {
					ImageIO.write(mc.aBufferedImage1258, "png", new File(path + "sleepword.png"));
				}
				if(fatigue() == 100) {
					Process p = Runtime.getRuntime().exec("OCRUtils" + File.separator + "nconvert -out ppm -o " + path + "sleepword.ppm " + path + "sleepword.png");
					p.waitFor();
					p.destroy();
					p = Runtime.getRuntime().exec("OCRUtils" + File.separator + "gocr048 -i " + path + "sleepword.ppm");
					p.waitFor();
					if(p.getInputStream().available() > 0) {
					InputStream in = p.getInputStream();
						int c = 0;
						while((c = in.read()) != -1)
							word += (char) c;
						in.close();
					}
					p.destroy();
					System.out.println("File deleted: " + new File(path + "sleepword.ppm").delete());
					ocrWord = Functions.parseSleepWord(word);
					mc.aString39 = ocrWord;
					mc.sendSleepWord(mc.aString39);
					wait(1000);
				}
				wait(1000);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
