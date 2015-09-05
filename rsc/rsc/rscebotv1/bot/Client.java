package bot;

import pack1.*;
import pack2.*;
import pack3.*;
import pack4.*;
import pack5.pack6.pack7.*;
import pack8.*;
import pack9.*;
import pack10.*;
import pack11.*;
import pack12.*;

import java.awt.image.*;
import javax.imageio.*;
import java.nio.*;
import java.lang.reflect.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.awt.*;

public class Client extends mudclient {
	
	public boolean showGraphics = true;
	
	public static Hashtable<String, Methods> scripts = new Hashtable<String, Methods>();
	public Methods methods = null;
	public Thread thread = null;
	public boolean running = false;
	
	public int[] trees = {70, 88, 183, 184, 208, 237, 245, 306, 307, 308, 309, 310, 314, 387, 390, 391, 394, 395, 407, 462, 463, 482};
	public boolean hideTrees = false;
	
	public Methods OCR = null;
	public Thread OCRThread = null;
	
	public boolean loading = false;
	
	public int loginButton[] = new int[4];
	public boolean showOptionMenu = false;
	public boolean showInputMenu = false;
	public boolean showYesNoMenu = false;
	public String menuOptions[];
	public String menuTitle = "";
	public int menuOption = -1;
	public int menuStart = 0;
	
	public static void main(String args[]) {
        Applet_Sub1_Sub1.anInt761 = 4;
        final Client mc = new Client(512, 334);
		Applet_Sub1_Sub1.mc = mc;
		if(args.length >= 1)
			Applet_Sub1_Sub1.aString763 = args[0];
		else
			Applet_Sub1_Sub1.aString763 = "72.20.32.58";
		if(args.length >= 2)
			Applet_Sub1_Sub1.anInt785 = Integer.parseInt(args[1]);
		else
			Applet_Sub1_Sub1.anInt785 = 47223;
		System.out.println(Applet_Sub1_Sub1.aString763 + ":" + Applet_Sub1_Sub1.anInt785);
        mc.aBoolean1060 = false;
        mc.method12(aBufferedImage1266);
        mc.method11(anInt1291, anInt1292 + 11, aString1294, false);
		loadScripts(mc);
		mc.OCRThread = new Thread(new Runnable() {
			public void run() {
				mc.OCR.main(new String[]{""});
			}
		});
		mc.OCRThread.start();
		mc.OCRThread.setPriority(mc.OCRThread.MIN_PRIORITY);
	}
	
	public void drawYesNoMenu() {
        if (anInt1175 != 0 && (super.anInt31 < 56 || super.anInt31 > 456 || super.anInt32 < 130 || super.anInt32 > 230)) {
            anInt1175 = 0;
			menuOption = -1;
            showYesNoMenu = false;
			return;
        }
		if(anInt1175 != 0 && super.anInt31 > 164 && super.anInt31 < 246 && super.anInt32 > 182 && super.anInt32 < 212) {
			anInt1175 = 0;
			menuOption = 1;
			showYesNoMenu = false;
			return;
		}
		if(anInt1175 != 0 && super.anInt31 > 264 && super.anInt31 < 346 && super.anInt32 > 182 && super.anInt32 < 212) {
			anInt1175 = 0;
			menuOption = 0;
			showYesNoMenu = false;
			return;
		}
        aClass26_Sub1_1195.method428(56, 130, 400, 100, 0);
        aClass26_Sub1_1195.method429(56, 130, 400, 100, 0xffffff);
        method79(menuTitle, 256, 160, 5, 0xffffff);
		int col = 0xffffff;
		if(super.anInt31 > 164 && super.anInt31 < 246 && super.anInt32 > 182 && super.anInt32 < 212)
			col = 0xffff00;
        method79("Yes", 206, 202, 4, col);
		aClass26_Sub1_1195.method429(164, 182, 82, 30, col);
		col = 0xffffff;
		if(super.anInt31 > 264 && super.anInt31 < 346 && super.anInt32 > 182 && super.anInt32 < 212)
			col = 0xffff00;
        method79("No", 306, 202, 4, col);
		aClass26_Sub1_1195.method429(264, 182, 82, 30, col);
	}
	
	public void drawOptionMenu() {
		int selectedOption = -1;
		int yPos = 65;
		for(int j = 0; j < menuOptions.length; j++) {
			if(super.anInt31 > 256 - 190 && super.anInt31 < 256 + 190 && super.anInt32 >= yPos - 12 && super.anInt32 < yPos + 3)
				selectedOption = j + menuStart;
			yPos += 14;
		}

		if(anInt1175 != 0 && selectedOption != -1) {
			anInt1175 = 0;
			menuOption = selectedOption;
			showOptionMenu = false;
			return;
		}
		if(anInt1175 != 0) {
			anInt1175 = 0;
			if(super.anInt31 < 56 || super.anInt32 < 22 || super.anInt31 > 455 || super.anInt32 > 311) {
				showOptionMenu = false;
				stopMacro();
				return;
			}
			if(super.anInt31 > 66 && super.anInt31 < 446 && super.anInt32 >= 289 && super.anInt32 < 309) {
				showOptionMenu = false;
				stopMacro();
				return;
			}
			if(menuStart + 17 < menuOptions.length && super.anInt31 > 58 && super.anInt31 < 128
					&& super.anInt32 > yPos - 15 && super.anInt32 < yPos + 5)
				menuStart ++;
			if(menuStart > 0 && super.anInt31 > 430 && super.anInt31 < 480
					&& super.anInt32 > yPos - 15 && super.anInt32 < yPos + 5)
				menuStart ++;
		}
		aClass26_Sub1_1195.method428(56, 22, 400, 290, 0);
		aClass26_Sub1_1195.method429(56, 22, 400, 290, 0xffffff);
		yPos = 50;
		method79(menuTitle, 256, yPos, 5, 0xffffff);
		yPos += 15;
		for(int i1 = menuStart; i1 < menuOptions.length; i1++) {
			method79(menuOptions[i1], 256, yPos, 1, selectedOption == i1 ? 0xffff00 : 0xffffff);
			if(selectedOption == i1)
				aClass26_Sub1_1195.method429(66, yPos - 12, 380, 15, 0xffffff);
			yPos += 14;
		}
		int col = 0xffffff;
		yPos = 304;
		if(super.anInt31 > 256 - 15 && super.anInt31 < 256 + 15 && super.anInt32 > yPos - 15 && super.anInt32 < yPos + 5)
			col = 0xffff00;
		method79("Cancel", 256, yPos, 1, col);
	}
	
	public void drawInputMenu() {
		
	}
	
	@Override
    public void method121(String s, int i, int j)
    {
		System.out.println(i + "," + j + " - " + s);
        String s1 = "";
        if(i == 2 || i == 4 || i == 6 || i == 7)
        {
            for(; s.length() > 5 && s.charAt(0) == '@' && s.charAt(4) == '@'; s = s.substring(5));
            if(s.length() > 5 && s.charAt(0) == '#' && s.charAt(4) == '#')
            {
                String s2 = s.substring(0, 5);
                s = (new StringBuilder()).append(s2).append(Class1.method225(s.substring(5))).toString();
            } else
            {
                s = Class1.method225(s);
            }
        }
        String s3 = "@yel@";
        switch(j)
        {
        case 1: // '\001'
            s = (new StringBuilder()).append("#adm#").append(s).toString();
            break;

        case 2: // '\002'
            s = (new StringBuilder()).append("#mod#").append(s).toString();
            s3 = "@whi@";
            break;

        case 3: // '\003'
            s = (new StringBuilder()).append("#dev#").append(s).toString();
            s3 = "@red@";
            break;

        case 6: // '\006'
            s = (new StringBuilder()).append("#pmd#").append(s).toString();
            s3 = "@gre@";
            break;

        case 5: // '\005'
            s = (new StringBuilder()).append("#cmd#").append(s).toString();
            s3 = "@blu@";
            break;

        case 7: // '\007'
            s3 = "@or2@";
            break;
        }
        switch(i)
        {
        case 6: // '\006'
            s = (new StringBuilder()).append("@cya@").append(Class1.method225(s)).toString();
            break;

        case 5: // '\005'
            s = (new StringBuilder()).append("@whi@").append(s).toString();
            break;

        case 7: // '\007'
            String s4 = "";
            int l = 0;
            int i1 = 0;
            do
            {
                if(i1 >= s.length())
                    break;
                if(s.charAt(i1) != ':')
                {
                    s4 = (new StringBuilder()).append(s4).append(s.charAt(i1)).toString();
                } else
                {
                    s4 = (new StringBuilder()).append(s4).append(s.charAt(i1)).toString();
                    break;
                }
                l++;
                i1++;
            } while(true);
            s4 = s4.replaceAll("_", " ");
            s = (new StringBuilder()).append("@yel@").append(s4).append("@whi@").append(s.substring(l + 1, s.length())).toString();
            break;

        case 2: // '\002'
            String s5 = "";
            int j1 = 0;
            int k1 = 0;
            do
            {
                if(k1 >= s.length())
                    break;
                if(s.charAt(k1) != ':')
                {
                    s5 = (new StringBuilder()).append(s5).append(s.charAt(k1)).toString();
                } else
                {
                    s5 = (new StringBuilder()).append(s5).append(s.charAt(k1)).toString();
                    break;
                }
                j1++;
                k1++;
            } while(true);
            s5 = s5.replaceAll("_", " ");
            s = (new StringBuilder()).append(s3).append(s5).append("@yel@").append(s.substring(j1 + 1, s.length())).toString();
            break;

        case 3: // '\003'
        case 4: // '\004'
        default:
            s = (new StringBuilder()).append("@whi@").append(s).toString();
            break;
        }
        if(i == 3)
            s = (new StringBuilder()).append("@whi@").append(s).toString();
        if(anInt1092 != 0)
        {
            if(i == 4 || i == 3)
                anInt1223 = 200;
            if(i == 2 && anInt1092 != 1)
                anInt1224 = 200;
            if((i == 5 || i == 7) && anInt1092 != 2)
                anInt1225 = 200;
            if(i == 6 && anInt1092 != 3)
                anInt1226 = 200;
            if(i == 3 && anInt1092 != 0)
                anInt1092 = 0;
            if(i == 6 && anInt1092 != 3 && anInt1092 != 0)
                anInt1092 = 0;
        }
        for(int k = 4; k > 0; k--)
        {
            aStringArray1234[k] = aStringArray1234[k - 1];
            anIntArray1146[k] = anIntArray1146[k - 1];
        }

        aStringArray1234[0] = s;
        anIntArray1146[0] = 300;
        if(i == 2)
            if(aClass30_1087.anIntArray258[anInt1088] == aClass30_1087.anIntArray259[anInt1088] - 4)
                aClass30_1087.method501(anInt1088, s, true);
            else
                aClass30_1087.method501(anInt1088, s, false);
        if(i == 5 || i == 7)
            if(aClass30_1087.anIntArray258[anInt1090] == aClass30_1087.anIntArray259[anInt1090] - 4)
                aClass30_1087.method501(anInt1090, s, true);
            else
                aClass30_1087.method501(anInt1090, s, false);
        if(i == 6)
        {
            if(aClass30_1087.anIntArray258[anInt1091] == aClass30_1087.anIntArray259[anInt1091] - 4)
            {
                aClass30_1087.method501(anInt1091, s, true);
                return;
            }
            aClass30_1087.method501(anInt1091, (new StringBuilder()).append("@whi@").append(s).toString(), false);
        }
    }
	
    public void method137()
    {
        aClass30_1082 = new Class30(aClass26_Sub1_1195, 50);
        int i = 40;
        aClass30_1082.method489(anInt1246 / 2, anInt1247 / 2 + i, "Welcome to RSCEmulation!", 4, true);
        aClass30_1082.method489(anInt1246 / 2, anInt1247 / 2 + i + 30, "http://www.RSCEmulation.net", 4, true);
        aClass30_1082.method490(anInt1246 / 2, anInt1247 / 2 + i + 60, 200, 35);
        aClass30_1082.method489(anInt1246 / 2, anInt1247 / 2 + i + 60, "Login", 5, false);
        anInt963 = aClass30_1082.method497(anInt1246 / 2, anInt1247 / 2 + i + 60, 200, 35);
        aClass30_1079 = new Class30(aClass26_Sub1_1195, 50);
        i = 50;
        anInt1102 = aClass30_1079.method489(anInt1246 / 2, (anInt1247 / 2 + i) - 10, "", 4, true);
        i += 28;
        aClass30_1079.method490(anInt1246 / 2 - 125, anInt1247 / 2 + i, 200, 40);
        aClass30_1079.method489(anInt1246 / 2 - 125, (anInt1247 / 2 + i) - 10, "Username:", 4, false);
        anInt1103 = aClass30_1079.method495(anInt1246 / 2 - 125, anInt1247 / 2 + i + 10, 200, 40, 4, 12, false, false);
        i += 47;
        aClass30_1079.method490(anInt1246 / 2 - 125, anInt1247 / 2 + i, 200, 40);
        aClass30_1079.method489(anInt1246 / 2 - 125, (anInt1247 / 2 + i) - 10, "Password:", 4, false);
        anInt1104 = aClass30_1079.method495(anInt1246 / 2 - 125, anInt1247 / 2 + i + 10, 200, 40, 4, 20, true, false);
        i -= 55;
        aClass30_1079.method490(anInt1246 / 2 + 120, anInt1247 / 2 + i, 120, 25);
        aClass30_1079.method489(anInt1246 / 2 + 120, anInt1247 / 2 + i, "Login", 4, false);
        anInt1105 = aClass30_1079.method497(anInt1246 / 2 + 120, anInt1247 / 2 + i, 120, 25);
        i += 30;
        aClass30_1079.method490(anInt1246 / 2 + 120, anInt1247 / 2 + i, 120, 25);
        aClass30_1079.method489(anInt1246 / 2 + 120, anInt1247 / 2 + i, "Cancel", 4, false);
        anInt1106 = aClass30_1079.method497(anInt1246 / 2 + 120, anInt1247 / 2 + i, 120, 25);
        i += 30;
        aClass30_1079.method506(anInt1103);
    }
	
    public void method8()
    {
        String s = new String(aByteArray1238);
        anInt1228 = Integer.valueOf(s).intValue();
        int i = 0;
        for(int j = 0; j < 99; j++)
        {
            int l = j + 1;
            int i1 = (int)((double)l + 300D * Math.pow(2D, (double)l / 7D));
            i += i1;
            anIntArray1198[j] = (i & 0xffffffc) / 4;
        }

        super.anInt14 = 0;
        Applet_Sub1_Sub1.anInt762 = 1000;
        method64();
        if(aBoolean1197)
            return;
        aGraphics1206 = getGraphics();
        method13(50);
        aClass26_Sub1_1195 = new Class26_Sub1(anInt1246, anInt1247 + 12, 4000, this);
        aClass26_Sub1_1195.aMudclient837 = this;
        aClass26_Sub1_1195.method421(0, 0, anInt1246, anInt1247 + 12);
        Class30.aBoolean287 = false;
        aClass30_1018 = new Class30(aClass26_Sub1_1195, 5);
        int k = ((Class26) (aClass26_Sub1_1195)).anInt169 - 199;
        anInt1019 = aClass30_1018.method496(k, 60, 196, 90, 1, 500, true);
        aClass30_1249 = new Class30(aClass26_Sub1_1195, 5);
        anInt1250 = aClass30_1249.method496(k, 76, 196, 126, 1, 500, true);
        aClass30_1020 = new Class30(aClass26_Sub1_1195, 5);
        anInt1021 = aClass30_1020.method496(k, 60, 196, 263, 1, 500, true);
        method102();
        if(aBoolean1197)
            return;
        method103();
        if(aBoolean1197)
            return;
        aClass42_1199 = new Class42(aClass26_Sub1_1195, 15000, 15000, 10000);
        aClass42_1199.method597(anInt1246 / 2, anInt1247 / 2, anInt1246 / 2, anInt1247 / 2, anInt1246, anInt1248);
        aClass42_1199.anInt459 = 2400;
        aClass42_1199.anInt460 = 2400;
        aClass42_1199.anInt461 = 1;
        aClass42_1199.anInt462 = 2300;
        aClass42_1199.method626(-50, -10, -50);
        aClass17_1170 = new Class17(aClass42_1199, aClass26_Sub1_1195);
        method104();
        if(aBoolean1197)
            return;
        method65();
        if(aBoolean1197)
            return;
        method114();
        if(aBoolean1197)
        {
            return;
        } else
        {
            method21(100, "Starting game...");
            aBoolean1301 = true;
            aClass26_Sub1_1195.method418();
            method110();
            method137();
            method118();
            return;
        }
    }
	
	public void debug(String s){if(debug)System.out.println(s);}
	public boolean debug = false;
	
    public void drawStaffMenu()	
    {
        anInt1309 = 0;
        int i = anInt1292 / 2 - 55;
        for(int j = 0; j < 10; j++)
        {
            if(super.anInt31 > anInt1291 / 2 - 160 && super.anInt31 < anInt1291 / 2 + 160 && super.anInt32 >= i - 12 && super.anInt32 < i + 3/* && (aClass31_1156.anInt292 == 5 && j + 1 < 7 || aClass31_1156.anInt292 == 6 && j + 1 < 10 || aClass31_1156.anInt292 == 1 || aClass31_1156.anInt292 == 2 || aClass31_1156.anInt292 == 3)*/)
                anInt1309 = j + 1;
            i += 15;
        }

        if(anInt1175 != 0 && anInt1309 != 0)
        {
            anInt1175 = 0;
            super.aString38 = "";
            super.aString39 = "";
            switch(anInt1309)
            {
            case 1: // '\001'
                aString1307 = "Enter the reason for the action taken: ";
                aString1308 = "Reason: ";
                break;

            case 2: // '\002'
                aString1307 = "Enter the reason for the action taken: ";
                aString1308 = "Reason: ";
                break;

            case 3: // '\003'
                aString1307 = "Enter the time interval: ";
                aString1308 = "Minutes: ";
                break;

            case 4: // '\004'
                aString1307 = "Enter the reason for the action taken: ";
                aString1308 = "Reason: ";
                break;

            case 5: // '\005'
                aString1307 = "Enter the reason for the action taken: ";
                aString1308 = "Reason: ";
                break;

            case 6: // '\006'
                aString1307 = "Enter the time interval: ";
                aString1308 = "Minutes: ";
                break;

            case 7: // '\007'
                aString1307 = "Enter the reason for the action taken: ";
                aString1308 = "Reason: ";
                break;

            case 8: // '\b'
                aString1307 = "Enter the reason for the action taken: ";
                aString1308 = "Reason: ";
                break;

            case 9: // '\t'
                aString1307 = "Enter the time interval: ";
                aString1308 = "Minutes: ";
                break;

            case 10: // '\n'
                aString1307 = "Enter the reason for the action taken: ";
                aString1308 = "Reason: ";
                break;
            }
            aBoolean1302 = !aBoolean1302;
            aBoolean1305 = true;
            return;
        }
        i += 15;
        if(anInt1175 != 0)
        {
            anInt1175 = 0;
            if(method45(anInt1291 / 2 - 160, anInt1291 / 2 + 160, anInt1292 / 2 + 90, anInt1292 / 2 + 100))
            {
                aBoolean1302 = !aBoolean1302;
                return;
            }
            if(!method45(anInt1291 / 2 - 160, anInt1291 / 2 + 160, anInt1292 / 2 - 100, anInt1292 / 2 + 100))
            {
                aBoolean1302 = !aBoolean1302;
                return;
            }
        }
        aClass26_Sub1_1195.method428(anInt1291 / 2 - 160, anInt1292 / 2 - 100, 320, 205, 0);
        aClass26_Sub1_1195.method429(anInt1291 / 2 - 160, anInt1292 / 2 - 100, 320, 205, 0xffffff);
        i = -55;
        method79((new StringBuilder()).append("Staff Menu logged in as: ").append(aClass31_1156.aString294).toString(), anInt1291 / 2, anInt1292 / 2 - 85, 4, 0xffffff);
        method79("Warning - ALL staff transactions are logged", anInt1291 / 2, anInt1292 / 2 - 70, 3, 0xff0000);
        int k = 1;
        String as[] = Class4.aStringArray70;
        int l = as.length;
        for(int i1 = 0; i1 < l; i1++)
        {
            String s = as[i1];
            if(anInt1309 == k)
            {
                aClass26_Sub1_1195.method429(anInt1291 / 2 - 100, (anInt1292 / 2 + i) - 12, 200, 15, 0xffffff);
                method79((new StringBuilder()).append(s).append(aString1303).toString(), anInt1291 / 2, anInt1292 / 2 + i, 2, 0xff8000);
            } else
            {
                method79((new StringBuilder()).append(s).append(aString1303).toString(), anInt1291 / 2, anInt1292 / 2 + i, 2, 0xffffff);
            }
            k++;
            i += 15;
        }

        if(method45(anInt1291 / 2 - 160, anInt1291 / 2 + 160, (anInt1292 / 2 + i) - 12, anInt1292 / 2 + i + 3))
        {
            aClass26_Sub1_1195.method429(anInt1291 / 2 - 100, (anInt1292 / 2 + i) - 12, 200, 15, 0xffffff);
            method79("Close Window", anInt1291 / 2, anInt1292 / 2 + i, 2, 0xff8000);
        } else
        {
            method79("Close Window", anInt1291 / 2, anInt1292 / 2 + i, 2, 0xffffff);
        }
    }
	
    public void doStaffAction()
    {
        if(super.aString39.length() > 0)
        {
            String s = super.aString39.trim();
            super.aString38 = "";
            super.aString39 = "";
            if(s.length() > 0)
                if(aString1308.equals("Reason: "))
                {
                    aBoolean1305 = !aBoolean1305;
                    aString1306 = s;
                    System.out.println((new StringBuilder()).append("IDX: ").append(anInt1310).toString());
					System.out.println("anInt1304=" + anInt1304);
					System.out.println("anInt1310=" + anInt1310);
					System.out.println("aString1306=" + aString1306);
                    switch(anInt1309)
                    {
                    case 1: // '\001'
                        /*super.aClass33_Sub1_767.method558(77);
                        super.aClass33_Sub1_767.method542(0);
                        super.aClass33_Sub1_767.method546(anInt1310);
                        super.aClass33_Sub1_767.method556(aString1306);
                        super.aClass33_Sub1_767.method541();*/
                        break;

                    case 2: // '\002'
                        /*super.aClass33_Sub1_767.method558(77);
                        super.aClass33_Sub1_767.method542(1);
                        super.aClass33_Sub1_767.method546(anInt1310);
                        super.aClass33_Sub1_767.method556(aString1306);
                        super.aClass33_Sub1_767.method541();*/
                        break;

                    case 3: // '\003'
                        /*super.aClass33_Sub1_767.method558(77);
                        super.aClass33_Sub1_767.method542(2);
                        super.aClass33_Sub1_767.method546(anInt1310);
                        super.aClass33_Sub1_767.method544(anInt1304);
                        super.aClass33_Sub1_767.method556(aString1306);
                        super.aClass33_Sub1_767.method541();*/
                        break;

                    case 4: // '\004'
                        /*super.aClass33_Sub1_767.method558(77);
                        super.aClass33_Sub1_767.method542(3);
                        super.aClass33_Sub1_767.method546(anInt1310);
                        super.aClass33_Sub1_767.method556(aString1306);
                        super.aClass33_Sub1_767.method541();*/
                        break;

                    case 5: // '\005'
                        /*super.aClass33_Sub1_767.method558(77);
                        super.aClass33_Sub1_767.method542(4);
                        super.aClass33_Sub1_767.method546(anInt1310);
                        super.aClass33_Sub1_767.method556(aString1306);
                        super.aClass33_Sub1_767.method541();*/
                        break;

                    case 6: // '\006'
                        /*super.aClass33_Sub1_767.method558(77);
                        super.aClass33_Sub1_767.method542(5);
                        super.aClass33_Sub1_767.method546(anInt1310);
                        super.aClass33_Sub1_767.method544(anInt1304);
                        super.aClass33_Sub1_767.method556(aString1306);
                        super.aClass33_Sub1_767.method541();*/
                        break;

                    case 7: // '\007'
                        /*super.aClass33_Sub1_767.method558(77);
                        super.aClass33_Sub1_767.method542(6);
                        super.aClass33_Sub1_767.method546(anInt1310);
                        super.aClass33_Sub1_767.method556(aString1306);
                        super.aClass33_Sub1_767.method541();*/
                        break;

                    case 8: // '\b'
                        /*super.aClass33_Sub1_767.method558(77);
                        super.aClass33_Sub1_767.method542(7);
                        super.aClass33_Sub1_767.method546(anInt1310);
                        super.aClass33_Sub1_767.method556(aString1306);
                        super.aClass33_Sub1_767.method541();*/
                        break;

                    case 9: // '\t'
                        /*super.aClass33_Sub1_767.method558(77);
                        super.aClass33_Sub1_767.method542(8);
                        super.aClass33_Sub1_767.method546(anInt1310);
                        super.aClass33_Sub1_767.method544(anInt1304);
                        super.aClass33_Sub1_767.method556(aString1306);
                        super.aClass33_Sub1_767.method541();*/
                        break;

                    case 10: // '\n'
                        /*super.aClass33_Sub1_767.method558(77);
                        super.aClass33_Sub1_767.method542(9);
                        super.aClass33_Sub1_767.method546(anInt1310);
                        super.aClass33_Sub1_767.method556(aString1306);
                        super.aClass33_Sub1_767.method541();*/
                        break;
                    }
                    aString1303 = "";
                    anInt1304 = -1;
                    aString1306 = "";
                } else
                if(aString1308.equals("Minutes: "))
                {
                    try
                    {
                        anInt1304 = Integer.parseInt(s);
                        aString1307 = "";
                        aString1308 = "";
                        aString1307 = "Enter the reason for the action taken: ";
                        aString1308 = "Reason: ";
                        return;
                    }
                    catch(Exception exception)
                    {
                        method120("@red@Invalid time - please re-enter");
                    }
                    return;
                }
            aString1307 = "";
            aString1308 = "";
            return;
        }
        aClass26_Sub1_1195.method428(anInt1291 / 2 - 200, anInt1292 / 2 - 50, 400, 100, 0);
        aClass26_Sub1_1195.method429(anInt1291 / 2 - 200, anInt1292 / 2 - 50, 400, 100, 0xffffff);
        int i = anInt1292 / 2 - 30;
        method79(aString1307, anInt1291 / 2, i, 1, 0xffff00);
        i += 18;
        method79((new StringBuilder()).append(aString1308).append(super.aString38).append("*").toString(), anInt1291 / 2, i, 4, 0xffffff);
        i = anInt1292 / 2 + 38;
        int j = 0xffffff;
        if(super.anInt31 > anInt1291 / 2 - 200 && super.anInt31 < anInt1291 / 2 + 200 && super.anInt32 > i - 13 && super.anInt32 < i + 2)
        {
            j = 0xffff00;
            if(anInt1175 == 1)
            {
                anInt1175 = 0;
                aBoolean1305 = !aBoolean1305;
            }
        }
        method79("Cancel", anInt1291 / 2, i, 1, j);
        if(anInt1175 == 1 && (super.anInt31 < anInt1291 / 2 - 200 || super.anInt31 > anInt1291 / 2 + 200 || super.anInt32 < anInt1292 / 2 - 50 || super.anInt32 > anInt1292 / 2 + 50))
        {
            anInt1175 = 0;
            aBoolean1305 = !aBoolean1305;
        }
    }
	
    public void drawInventoryMenu(boolean flag)
    {
        int i = ((Class26) (aClass26_Sub1_1195)).anInt169 - 248;
        aClass26_Sub1_1195.method438(i, 3, 2001);
        for(int j = 0; j < anInt1160; j++)
        {
            int j1 = i + (j % 5) * 49;
            int l1 = 36 + (j / 5) * 34;
            if(j < anInt979 && anIntArray982[j] == 1)
                method76(j1, l1, 49, 34, 0xff0000, 128);
            else
                method76(j1, l1, 49, 34, Class26.method434(181, 181, 181), 128);
            if(j >= anInt979)
                continue;
            aClass26_Sub1_1195.method452(j1, l1, 48, 32, 2150 + Class3.method236(anIntArray980[j]).method302(), Class3.method236(anIntArray980[j]).method306(), 0, 0, false);
            if(Class3.method236(anIntArray980[j]).method304())
                method80(method69(String.valueOf(anIntArray981[j])), j1 + 1, l1 + 10, 1, 0xffff00);
        }

        for(int k = 1; k <= 4; k++)
            method78(i + k * 49, 36, (anInt1160 / 5) * 34, 0);

        for(int l = 1; l <= anInt1160 / 5 - 1; l++)
            method77(i, 36 + l * 34, 245, 0);

        if(!flag)
            return;
        i = super.anInt31 - (((Class26) (aClass26_Sub1_1195)).anInt169 - 248);
        int i1 = super.anInt32 - 36;
        if(i >= 0 && i1 >= 0 && i < 248 && i1 < (anInt1160 / 5) * 34)
        {
            int k1 = i / 49 + (i1 / 34) * 5;
            if(k1 < anInt979)
            {
                int i2 = anIntArray980[k1];
                Class9_Sub2 class9_sub2 = Class3.method236(i2);
                if(anInt1180 >= 0)
                {
                    if(Class3.method241(anInt1180).method333() == 3)
                    {
                        aStringArray966[anInt1049] = (new StringBuilder()).append("Cast ").append(Class3.method241(anInt1180).method292()).append(" on").toString();
                        aStringArray1109[anInt1049] = (new StringBuilder()).append("@lre@").append(class9_sub2.method292()).toString();
                        anIntArray1054[anInt1049] = 600;
                        anIntArray1117[anInt1049] = k1;
                        anIntArray1118[anInt1049] = anInt1180;
                        anInt1049++;
                        return;
                    }
                } else
                {
                    if(anInt1043 >= 0)
                    {
                        aStringArray966[anInt1049] = (new StringBuilder()).append("Use ").append(aString1044).append(" with").toString();
                        aStringArray1109[anInt1049] = (new StringBuilder()).append("@lre@").append(class9_sub2.method292()).toString();
                        anIntArray1054[anInt1049] = 610;
                        anIntArray1117[anInt1049] = k1;
                        anIntArray1118[anInt1049] = anInt1043;
                        anInt1049++;
                        return;
                    }
                    if(anIntArray982[k1] == 1)
                    {
                        aStringArray966[anInt1049] = "Remove";
                        aStringArray1109[anInt1049] = (new StringBuilder()).append("@lre@").append(class9_sub2.method292()).toString();
                        anIntArray1054[anInt1049] = 620;
                        anIntArray1117[anInt1049] = k1;
                        anInt1049++;
                    } else
                    if(Class3.method236(i2).method305())
                    {
                        aStringArray966[anInt1049] = "Wear";
                        aStringArray1109[anInt1049] = (new StringBuilder()).append("@lre@").append(class9_sub2.method292()).toString();
                        anIntArray1054[anInt1049] = 630;
                        anIntArray1117[anInt1049] = k1;
                        anInt1049++;
                    }
                    if(!class9_sub2.method301().equals(""))
                    {
                        aStringArray966[anInt1049] = class9_sub2.method301();
                        aStringArray1109[anInt1049] = (new StringBuilder()).append("@lre@").append(class9_sub2.method292()).toString();
                        anIntArray1054[anInt1049] = 640;
                        anIntArray1117[anInt1049] = k1;
                        anInt1049++;
                    }
                    aStringArray966[anInt1049] = "Use";
                    aStringArray1109[anInt1049] = (new StringBuilder()).append("@lre@").append(class9_sub2.method292()).toString();
                    anIntArray1054[anInt1049] = 650;
                    anIntArray1117[anInt1049] = k1;
                    anInt1049++;
                    aStringArray966[anInt1049] = "Drop";
                    aStringArray1109[anInt1049] = (new StringBuilder()).append("@lre@").append(class9_sub2.method292()).toString();
                    anIntArray1054[anInt1049] = 660;
                    anIntArray1117[anInt1049] = k1;
                    anInt1049++;
                    aStringArray966[anInt1049] = "Examine";
                    aStringArray1109[anInt1049] = "@lre@" + class9_sub2.method292() + " @or1@(" + i2 + ")";
                    anIntArray1054[anInt1049] = 3600;
                    anIntArray1117[anInt1049] = i2;
                    anInt1049++;
                }
            }
        }
    }
	
	public void menuClick(int i) {
        int j = anIntArray1154[i];
        int k = anIntArray1155[i];
        int l = anIntArray1117[i];
        int i1 = anIntArray1118[i];
        int j1 = anIntArray1119[i];
        int k1 = anIntArray1054[i];
        if(k1 == 200)
        {
			debug("castOnGroundItem(" + l + ", " + (j + anInt1035) + ", " + (k + anInt1036) + ")");
            method131(anInt1157, anInt1158, j, k, true);
            super.aClass33_Sub1_767.method558(37);
            super.aClass33_Sub1_767.method546(i1);
            super.aClass33_Sub1_767.method546(j + anInt1035);
            super.aClass33_Sub1_767.method546(k + anInt1036);
            super.aClass33_Sub1_767.method546(l);
            super.aClass33_Sub1_767.method541();
            anInt1180 = -1;
        }
        if(k1 == 210)
        {
			debug("useItemOnGroundItem(" + l + ", " + (j + anInt1035) + ", " + (k + anInt1036) + ")");
            method131(anInt1157, anInt1158, j, k, true);
            super.aClass33_Sub1_767.method558(60);
            super.aClass33_Sub1_767.method546(j + anInt1035);
            super.aClass33_Sub1_767.method546(k + anInt1036);
            super.aClass33_Sub1_767.method546(l);
            super.aClass33_Sub1_767.method546(i1);
            super.aClass33_Sub1_767.method541();
            anInt1043 = -1;
        }
        if(k1 == 220)
        {
			debug("pickUp(" + l + ", " + (j + anInt1035) + ", " + (k + anInt1036) + ",)");
            method131(anInt1157, anInt1158, j, k, true);
            super.aClass33_Sub1_767.method558(11);
            super.aClass33_Sub1_767.method546(j + anInt1035);
            super.aClass33_Sub1_767.method546(k + anInt1036);
            super.aClass33_Sub1_767.method546(l);
            super.aClass33_Sub1_767.method546(i1);
            super.aClass33_Sub1_767.method541();
        }
        if(k1 == 3200)
            method121(Class3.method236(l).method293(), 3, 0);
        if(k1 == 300)
        {
			debug("castOnDoor(" + l + ", " + (j + anInt1035) + ", " + (k + anInt1036) + ")");
            method97(j, k, l);
            super.aClass33_Sub1_767.method558(255);
            super.aClass33_Sub1_767.method546(i1);
            super.aClass33_Sub1_767.method546(j + anInt1035);
            super.aClass33_Sub1_767.method546(k + anInt1036);
            super.aClass33_Sub1_767.method542(l);
            super.aClass33_Sub1_767.method541();
            anInt1180 = -1;
        }
        if(k1 == 310)
        {
			debug("useItemOnDoor(" + i1 + ", " + (j + anInt1035) + ", " + (k + anInt1036) + ")");
            method97(j, k, l);
            super.aClass33_Sub1_767.method558(63);
            super.aClass33_Sub1_767.method546(j + anInt1035);
            super.aClass33_Sub1_767.method546(k + anInt1036);
            super.aClass33_Sub1_767.method542(l);
            super.aClass33_Sub1_767.method546(i1);
            super.aClass33_Sub1_767.method541();
            anInt1043 = -1;
        }
        if(k1 == 320)
        {
			debug("useDoor(" + (j + anInt1035) + ", " + (k + anInt1036) + ", true)");
            method97(j, k, l);
            super.aClass33_Sub1_767.method558(27);
            super.aClass33_Sub1_767.method546(j + anInt1035);
            super.aClass33_Sub1_767.method546(k + anInt1036);
            super.aClass33_Sub1_767.method542(l);
            super.aClass33_Sub1_767.method541();
        }
        if(k1 == 2300)
        {
			debug("useDoor(" + (j + anInt1035) + ", " + (k + anInt1036) + ", false)");
            method97(j, k, l);
            super.aClass33_Sub1_767.method558(28);
            super.aClass33_Sub1_767.method546(j + anInt1035);
            super.aClass33_Sub1_767.method546(k + anInt1036);
            super.aClass33_Sub1_767.method542(l);
            super.aClass33_Sub1_767.method541();
        }
        if(k1 == 3300)
            method121(Class3.method245(l).method293(), 3, 0);
        if(k1 == 400)
        {
			debug("castOnObject(" + i1 + ", " + j1 + ")");
            method66(j, k, l, i1);
            super.aClass33_Sub1_767.method558(33);
            super.aClass33_Sub1_767.method546(j1);
            super.aClass33_Sub1_767.method546(i1);
            super.aClass33_Sub1_767.method541();
            anInt1180 = -1;
        }
        if(k1 == 410)
        {
			debug("useItemOnObject(" + j1 + ", " + (j + anInt1035) + ", " + (k + anInt1036) + ")");
            method66(j, k, l, i1);
            if(method150(anIntArray980[j1], i1))
            {
                super.aClass33_Sub1_767.method558(58);
                super.aClass33_Sub1_767.method546(j + anInt1035);
                super.aClass33_Sub1_767.method546(k + anInt1036);
                super.aClass33_Sub1_767.method546(j1);
                super.aClass33_Sub1_767.method541();
            }
            anInt1043 = -1;
        }
        if(k1 == 420)
        {
			debug("useObject(" + (j + anInt1035) + ", " + (k + anInt1036) + ", true)");
            method66(j, k, l, i1);
            super.aClass33_Sub1_767.method558(29);
            super.aClass33_Sub1_767.method546(j + anInt1035);
            super.aClass33_Sub1_767.method546(k + anInt1036);
            super.aClass33_Sub1_767.method541();
        }
        if(k1 == 2400)
        {
			debug("useObject(" + (j + anInt1035) + ", " + (k + anInt1036) + ", false)");
            method66(j, k, l, i1);
            super.aClass33_Sub1_767.method558(30);
            super.aClass33_Sub1_767.method546(j + anInt1035);
            super.aClass33_Sub1_767.method546(k + anInt1036);
            super.aClass33_Sub1_767.method541();
        }
        if(k1 == 3400)
            method121(Class3.method247(l).method293(), 3, 0);
        if(k1 == 600)
        {
			debug("castOnItem(" + l + ", " + i1 + ")");
            super.aClass33_Sub1_767.method558(31);
            super.aClass33_Sub1_767.method546(i1);
            super.aClass33_Sub1_767.method546(l);
            super.aClass33_Sub1_767.method541();
            anInt1180 = -1;
        }
        if(k1 == 610)
        {
			debug("useItemOnItem(" + l + ", " + i1 + ")");
            super.aClass33_Sub1_767.method558(61);
            super.aClass33_Sub1_767.method546(l);
            super.aClass33_Sub1_767.method546(i1);
            super.aClass33_Sub1_767.method541();
            anInt1043 = -1;
        }
        if(k1 == 620)
        {
			debug("removeItem(" + l + ")");
            super.aClass33_Sub1_767.method558(21);
            super.aClass33_Sub1_767.method546(l);
            super.aClass33_Sub1_767.method541();
        }
        if(k1 == 630)
        {
			debug("wearItem(" + l + ")");
            super.aClass33_Sub1_767.method558(20);
            super.aClass33_Sub1_767.method546(l);
            super.aClass33_Sub1_767.method541();
        }
        if(k1 == 640)
        {
			debug("useItem(" + l + ")");
            super.aClass33_Sub1_767.method558(55);
            super.aClass33_Sub1_767.method546(l);
            super.aClass33_Sub1_767.method541();
        }
        if(k1 == 650)
        {
            anInt1043 = l;
            anInt1011 = 0;
            aString1044 = Class3.method236(anIntArray980[anInt1043]).method292();
        }
        if(k1 == 660)
        {
			debug("dropItem(" + l + ")");
            super.aClass33_Sub1_767.method558(10);
            super.aClass33_Sub1_767.method546(l);
            super.aClass33_Sub1_767.method541();
            anInt1043 = -1;
            anInt1011 = 0;
            method121((new StringBuilder()).append("Dropping ").append(Class3.method236(anIntArray980[l]).method292()).toString(), 4, 0);
        }
        if(k1 == 3600)
            method121(Class3.method236(l).method293(), 3, 0);
        if(k1 == 700)
        {
			debug("castOnNPC(" + l + ", " + i1 + ")");
            int l1 = (j - 64) / 128;
            int j4 = (k - 64) / 128;
            method141(anInt1157, anInt1158, l1, j4, true);
            super.aClass33_Sub1_767.method558(36);
            super.aClass33_Sub1_767.method546(i1);
            super.aClass33_Sub1_767.method546(l);
            super.aClass33_Sub1_767.method541();
            anInt1180 = -1;
        }
        if(k1 == 710)
        {
			debug("useOnNPC(" + i1 + ", " + l + ")");
            int i2 = (j - 64) / 128;
            int k4 = (k - 64) / 128;
            method141(anInt1157, anInt1158, i2, k4, true);
            super.aClass33_Sub1_767.method558(62);
            super.aClass33_Sub1_767.method546(l);
            super.aClass33_Sub1_767.method546(i1);
            super.aClass33_Sub1_767.method541();
            anInt1043 = -1;
        }
        if(k1 == 720)
        {
			debug("talkToNPC(" + l + ")");
            int j2 = (j - 64) / 128;
            int l4 = (k - 64) / 128;
            method141(anInt1157, anInt1158, j2, l4, true);
            super.aClass33_Sub1_767.method558(8);
            super.aClass33_Sub1_767.method546(l);
            super.aClass33_Sub1_767.method541();
        }
        if(k1 == 725)
        {
			debug("thieveNPC(" + l + ")");
            int k2 = (j - 64) / 128;
            int i5 = (k - 64) / 128;
            method141(anInt1157, anInt1158, k2, i5, true);
            super.aClass33_Sub1_767.method558(69);
            super.aClass33_Sub1_767.method546(l);
            super.aClass33_Sub1_767.method541();
        }
        if(k1 == 715 || k1 == 2715)
        {
			debug("attackNPC(" + l + ")");
            int l2 = (j - 64) / 128;
            int j5 = (k - 64) / 128;
            int j6 = method141(anInt1157, anInt1158, l2, j5, true);
            super.aClass33_Sub1_767.method558(19);
            super.aClass33_Sub1_767.method546(l);
            super.aClass33_Sub1_767.method546(j6);
            super.aClass33_Sub1_767.method541();
        }
        if(k1 == 3700)
            method121(Class3.method235(l).method293(), 3, 0);
        if(k1 == 800)
        {
            int i3 = (j - 64) / 128;
            int k5 = (k - 64) / 128;
            byte byte0 = (byte)aRandom1298.nextInt(200);
            method141(anInt1157, anInt1158, i3, k5, true);
            super.aClass33_Sub1_767.method558(32);
            super.aClass33_Sub1_767.method546(i1);
            super.aClass33_Sub1_767.method546(l);
            super.aClass33_Sub1_767.method542(byte0);
            super.aClass33_Sub1_767.method541();
            anInt1180 = -1;
        }
        if(k1 == 810)
        {
            int j3 = (j - 64) / 128;
            int l5 = (k - 64) / 128;
            method141(anInt1157, anInt1158, j3, l5, true);
            super.aClass33_Sub1_767.method558(71);
            super.aClass33_Sub1_767.method546(l);
            super.aClass33_Sub1_767.method546(i1);
            super.aClass33_Sub1_767.method541();
            anInt1043 = -1;
        }
        if(k1 == 805 || k1 == 2805)
        {
            int k3 = (j - 64) / 128;
            int i6 = (k - 64) / 128;
            int k6 = method141(anInt1157, anInt1158, k3, i6, true);
            super.aClass33_Sub1_767.method558(18);
            super.aClass33_Sub1_767.method546(l);
            super.aClass33_Sub1_767.method546(k6);
            super.aClass33_Sub1_767.method541();
        }
        if(k1 == 2806)
        {
            super.aClass33_Sub1_767.method558(54);
            super.aClass33_Sub1_767.method546(l);
            super.aClass33_Sub1_767.method541();
        }
        if(k1 == 2810)
        {
            super.aClass33_Sub1_767.method558(43);
            super.aClass33_Sub1_767.method546(l);
            super.aClass33_Sub1_767.method541();
        }
        if(k1 == 2820)
        {
            super.aClass33_Sub1_767.method558(68);
            super.aClass33_Sub1_767.method546(l);
            super.aClass33_Sub1_767.method541();
        }
        if(k1 == 4444)
        {
            for(int l3 = 0; l3 < anInt976; l3++)
                if(aClass31Array1171[l3].anInt295 == l) {
					debug("addFriend(\"" + aClass31Array1171[l3].aString294 + "\")");
                    method34(aClass31Array1171[l3].aString294);
				}

        }
        if(k1 == 4446)
        {
            aBoolean1302 = true;
            for(int i4 = 0; i4 < anInt976; i4++)
                if(aClass31Array1171[i4].anInt295 == l)
                {
                    aString1303 = aClass31Array1171[i4].aString294;
                    anInt1310 = aClass31Array1171[i4].anInt295;
                }

        }
        if(k1 == 2821)
        {
            super.aClass33_Sub1_767.method558(69);
            super.aClass33_Sub1_767.method546(l);
            super.aClass33_Sub1_767.method541();
        }
        if(k1 == 900)
        {
			debug("castOnGround(" + l + ")");
            method141(anInt1157, anInt1158, j, k, true);
            super.aClass33_Sub1_767.method558(34);
            super.aClass33_Sub1_767.method546(l);
            super.aClass33_Sub1_767.method546(j + anInt1035);
            super.aClass33_Sub1_767.method546(k + anInt1036);
            super.aClass33_Sub1_767.method541();
            anInt1180 = -1;
        }
        if(k1 == 920)
        {
			debug("walkTo(" + (j + anInt1035) + ", " + (k + anInt1036) + ")");
            method141(anInt1157, anInt1158, j, k, false);
            if(anInt1114 == -24)
                anInt1114 = 24;
        }
        if(k1 == 1000)
        {
			debug("castOnSelf(" + l + ")");
            super.aClass33_Sub1_767.method558(34);
            super.aClass33_Sub1_767.method546(l);
            super.aClass33_Sub1_767.method541();
            anInt1180 = -1;
        }
        if(k1 == 4000)
        {
            anInt1043 = -1;
            anInt1180 = -1;
        }
	}
	
    public void drawRightClickMenu() {
        if (anInt1175 != 0) {
            for (int i = 0; i < anInt1049; i++) {
                int k = anInt1045 + 2;
                int i1 = anInt1046 + 27 + i * 15;
                if (super.anInt31 <= k - 2 || super.anInt32 <= i1 - 12 || super.anInt32 >= i1 + 4 || super.anInt31 >= (k - 3) + anInt1047)
                    continue;
                menuClick(anIntArray1186[i]);
                break;
            }

            anInt1175 = 0;
            aBoolean1211 = false;
            return;
        }
        if (super.anInt31 < anInt1045 - 10 || super.anInt32 < anInt1046 - 10 || super.anInt31 > anInt1045 + anInt1047 + 10 || super.anInt32 > anInt1046 + anInt1048 + 10) {
            aBoolean1211 = false;
            return;
        }
        aClass26_Sub1_1195.method426(anInt1045, anInt1046, anInt1047, anInt1048, 0xd0d0d0, 160);
        aClass26_Sub1_1195.method460("Choose option", anInt1045 + 2, anInt1046 + 12, 1, 65535);
        for (int j = 0; j < anInt1049; j++) {
            int l = anInt1045 + 2;
            int j1 = anInt1046 + 27 + j * 15;
            int k1 = 0xffffff;
            if (super.anInt31 > l - 2 && super.anInt32 > j1 - 12 && super.anInt32 < j1 + 4 && super.anInt31 < (l - 3) + anInt1047)
                k1 = 0xffff00;
            aClass26_Sub1_1195.method460(aStringArray966[anIntArray1186[j]] + " " + aStringArray1109[anIntArray1186[j]], l, j1, 1, k1);
        }

    }

    public void method10()
    {
        if(aBoolean1197)
        {
            Graphics g = getGraphics();
            g.setColor(Color.black);
            g.fillRect(0, 0, 512, 356);
            g.setFont(new Font("Helvetica", 1, 16));
            g.setColor(Color.yellow);
            int i = 35;
            g.drawString("Sorry, an error has occured whilst loading RSCEmatulion", 30, i);
            i += 50;
            g.setColor(Color.white);
            g.drawString("To fix this try the following (in order):", 30, i);
            i += 50;
            g.setColor(Color.white);
            g.setFont(new Font("Helvetica", 1, 12));
            g.drawString("1: Try closing ALL open web-browser windows, and reloading", 30, i);
            i += 30;
            g.drawString("2: Try clearing your web-browsers cache from tools->internet options", 30, i);
            i += 30;
            g.drawString("3: Try using a different game-world", 30, i);
            i += 30;
            g.drawString("4: Try rebooting your computer", 30, i);
            i += 30;
            g.drawString("5: Try selecting a different version of Java from the play-game menu", 30, i);
            method13(1);
            return;
        }
        if(aBoolean1009)
        {
            Graphics g1 = getGraphics();
            g1.setColor(Color.black);
            g1.fillRect(0, 0, 512, 356);
            g1.setFont(new Font("Helvetica", 1, 20));
            g1.setColor(Color.white);
            g1.drawString("Error - out of memory!", 50, 50);
            g1.drawString("Close ALL unnecessary programs", 50, 100);
            g1.drawString("and windows before loading the game", 50, 150);
            g1.drawString("RSCEmulation needs about 100mb of spare RAM", 50, 200);
            method13(1);
            return;
        }
        try
        {
            if(anInt1015 == 1)
            {
                aClass26_Sub1_1195.aBoolean184 = true;
                method93();
            } else
            {
                aClass26_Sub1_1195.aBoolean184 = false;
                method60();
            }
        }
        catch(OutOfMemoryError outofmemoryerror)
        {
            method98();
            aBoolean1009 = true;
        }
    }
	
	public static void loadScripts(Client mc) {
		scripts.clear();
		String[] fileList = new File("scripts/").list();
		for(int i = 0; i < fileList.length; i++) {
			try {
				if(fileList[i].endsWith(".class") && !fileList[i].contains("$")) {
					Class c = Class.forName(fileList[i].substring(0, fileList[i].length() - 6));
					Methods mtd = (Methods)c.getConstructor(new Class[]{Client.class}).newInstance(new Object[]{mc});
					String command = mtd.command();//fileList[i].substring(0, fileList[i].length() - 6);
					if(command.equalsIgnoreCase("OCR")) {
						mc.OCR = mtd;
						continue;
					}
					System.out.println("- " + command.toLowerCase());
					scripts.put(command.toLowerCase(), mtd);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("Scripts loaded");
	}
	
	@Override
	public void method15(int key) {
		if(key == 1010) {
			showGraphics = !showGraphics;
			printMessage("Graphics: " + (showGraphics ? "on" : "off"));
		}
		else
			super.method15(key);
	}
	
	@Override
	public void method44(String s) {
		try {
			if(methods.onServerMessage(s) == false)
				super.method44(s);
		}
		catch(Exception e) {
			super.method44(s);
		}
	}
	
	public Client(int width, int height) {
		super(width, height);
	}
	
	public void stopMacro() {
		if(methods == null || thread == null)
			return;
		running = false;
		methods.onStop();
		thread.stop();
		thread = null;
		methods = null;
	}
	
	public int random(int min, int max) {
		try {
			return (int) (min + Math.random() * (max - min));
		}
		catch(Exception e) { return -1; }
	}
	
	public boolean handleCommand(String s) {
		int index = s.indexOf(" ");
		String cmd = s;
		String args[] = new String[0];
		if(index != -1) {
			cmd = s.substring(0, index).trim();
			args = s.substring(index + 1).trim().split(" ");
		}
		
		if(cmd.equals("look")) {
			aClass31_1156.anInt315 = random(0, 4);
			aClass31_1156.anInt316 = random(0, 4);
			aClass31_1156.anInt317 = random(0, 4);
			aClass31_1156.anInt318 = random(0, 4);
			return true;
		}
		if(cmd.equals("debug")) {
			debug = !debug;
			return true;
		}
		if(cmd.equals("reload")) {
			loadScripts(this);
			return true;
		}
		if(cmd.equals("run") && args.length > 0) {
			if(running) {
				System.out.println("Script already running");
				return true;
			}
			methods = (Methods)scripts.get(args[0]);
			final String[] args2 = args;
			if(methods != null) {
				thread = new Thread(new Runnable() {
					public void run() {
						methods.main(args2);
					}
				});
				running = true;
				thread.start();
			}
			else {
				System.out.println("Script not found");
				return true;
			}
		}
		if(cmd.equals("stop")) {
			stopMacro();
		}
		if(cmd.equals("serv")) {
			method38(s.substring(5));
		}
		if(cmd.equals("hide")) {
			if(args[0].equals("trees"))
				hideTrees = !hideTrees;
		}
		if(cmd.equals("m")) {
			if(methods != null && thread != null && s.length() > 2)
				methods.handleCommand(s.substring(2));
		}
		if(cmd.equals("list")) {
			if(args[0].equals("bank")) {
				System.out.println("Bank items:");
				System.out.println("--------------------");
				for(int i = 0; i < anInt1123; i++) {
					if(anIntArray1178[i] == 0)
						continue;
					System.out.println(anIntArray1177[i] + "\t" + Class3.method236(anIntArray1177[i]).method292() + "\tamount:" + anIntArray1178[i]);
				}
				System.out.println("--------------------");
			}
		}
		if(cmd.equals("show")) {
			if(args[0].equals("bank")) {
				aBoolean985 = !aBoolean985;
			}
		}
		if(cmd.equals("ocr")) {
			if(args.length == 0) {
				printMessage("@or2@OCR: @yel@" + (OCRThread == null ? "disabled" : "enabled"));
				return true;
			}
			if(args[0].equals("on")) {
				if(OCRThread == null)
					return true;
				OCRThread = new Thread(new Runnable() {
					public void run() {
						OCR.main(new String[]{""});
					}
				});
				OCRThread.start();
			}
			if(args[0].equals("off")) {
				if(OCRThread != null)
					return true;
				OCRThread.stop();
				OCRThread = null;
			}
		}
		
		return true;
	}
	
	public void printMessage(Object message) {
		String msg = String.valueOf(message);
		String colors[] = {"red", "lre", "yel", "gre", "blu", "cya", "mag", "whi", "bla", "dre",
			"ora", "ran", "or1", "or2", "or3", "gr1", "gr2", "gr3"};
		for(int i = 0; i < colors.length; i++)
			msg = msg.replaceAll("@" + colors[i] + "@", "");
		System.out.println(msg);
		method121(String.valueOf(message), 3, 0);
	}
	
    public void method43(int id, int length, byte abyte0[]) {
		//if(id != 145 && id != 77 && id != 61 && id != 58 && id != 62)
		//	System.out.println("packet: " + id);
		if(id == 170) {
            long l1 = Class35.method563(abyte0, 1);
            String s1 = Class2.method229(abyte0, 9, length - 9);
			if(showGraphics == false)
				System.out.println("PRIVATE> " + Class35.method569(l1) + " tells you: " + s1);
			method44("@pri@@cya@" + Class35.method569(l1) + " tells you: " + s1);
		}
		else if(id == 206) {
			super.aString38 = "";
			super.aString39 = "";
			try {
				byte abyte1[] = new byte[Array.getLength(abyte0) - 1];
				for(int l10 = 0; l10 < Array.getLength(abyte1); l10++)
					abyte1[l10] = abyte0[l10 + 1];

				BufferedImage bufferedimage = ImageIO.read(new ByteArrayInputStream(abyte1));
				int w = bufferedimage.getWidth();
				int h = bufferedimage.getHeight();
				for(int x = 0; x < w; x++)
					for(int y = 0; y < h; y++) {
						int rgb = bufferedimage.getRGB(x, y);
						if(rgb != 0xff000000 && rgb != 0xffffffff) {
							bufferedimage.setRGB(x, y, 0xff000000);
							continue;
						}
						if(rgb == 0xff000000)
							bufferedimage.setRGB(x, y, 0xffffffff);
						else if(rgb == 0xffffffff)
							bufferedimage.setRGB(x, y, 0xff000000);
					}
				aBufferedImage1258 = bufferedimage;
				aClass16_1259 = Class16.method361(aBufferedImage1258);
			}
			catch(Exception exception) {
				exception.printStackTrace();
			}
			aBoolean1289 = true;
			aString1290 = null;
		}
		else if(id == 55) {
			int i1 = Class35.method561(abyte0, 1);
			int j1 = 3;
			for(int k = 0; k < i1; k++) {
				int l = Class35.method561(abyte0, j1);
				j1 += 2;
				if(l < 0 || l > aClass31Array999.length)
					return;
				Class31 class31 = aClass31Array999[l];
				if(class31 == null)
					return;
				byte byte0 = abyte0[j1++];
				byte byte1 = abyte0[j1++];
				if(class31 != null) {
					String s = Class2.method229(abyte0, j1, byte1);
					s = Class1.method225(s);
					class31.anInt309 = 150;
					class31.aString308 = s;
					if(byte0 == 77 && class31.anInt295 == aClass31_1156.anInt295 || byte0 != 77) {
						if(byte0 == 77)
							byte0 = 7;
						if(showGraphics == false)
							if(class31.aString308.toLowerCase().contains(aClass31_1156.aString294.toLowerCase()))
								System.out.println("!! CHAT> " + class31.aString294 + ": " + class31.aString308);
							else
								System.out.println("   CHAT> " + class31.aString294 + ": " + class31.aString308);
						method121(class31.aString294 + ": " + class31.aString308, byte0, class31.anInt292);
						if(methods != null)
							methods.onChatMessage(class31.anInt292, class31.aString294, class31.aString308);
					}
				}
				j1 += byte1;
			}
		}
		else if(id == 45) {
			String str = aClass4_1300.method262(Class35.method564(abyte0, 1));
			method121(str, 3, 0);
			System.out.println("packet 45: " + str);
		}
		else if(id == 58) {
			int i = Class35.method561(abyte0, 1);
			int j = 3;
			for(int k = 0; k < i; k++) {
				int l = Class35.method561(abyte0, j);
				j += 2;
				if(l < 0 || l > aClass31Array999.length)
					return;
				Class31 class31 = aClass31Array999[l];
				if(class31 != null)
				{
					class31.anInt315 = abyte0[j++] & 0xff;
					class31.anInt316 = abyte0[j++] & 0xff;
					class31.anInt317 = abyte0[j++] & 0xff;
					class31.anInt318 = abyte0[j++] & 0xff;
					class31.anInt314 = abyte0[j++] & 0xff;
					class31.anInt326 = abyte0[j++] & 0xff;
					class31.anInt292 = abyte0[j++] & 0xff;
					/*System.out.println("anInt315=" + class31.anInt315);
					System.out.println("anInt316=" + class31.anInt316);
					System.out.println("anInt317=" + class31.anInt317);
					System.out.println("anInt318=" + class31.anInt318);
					System.out.println("anInt314=" + class31.anInt314);
					System.out.println("anInt326=" + class31.anInt326);
					System.out.println("anInt292=" + class31.anInt292);*/
				} else
				{
					return;
				}
			}
		}
		/*else if(id == 145) {
			if(!aBoolean1285)
				return;
			anInt977 = anInt976;
			for(int i = 0; i < anInt977; i++)
				aClass31Array1058[i] = aClass31Array1171[i];
			
			int j = 8;
			anInt1157 = Class35.method566(abyte0, j, 11);
			j += 11;
			anInt1158 = Class35.method566(abyte0, j, 13);
			j += 13;
			int k = Class35.method566(abyte0, j, 4);
			j += 4;
			boolean sectionLoaded = loadSection(anInt1157, anInt1158);
			anInt1157 -= anInt1035;
			anInt1158 -= anInt1036;
			int l = anInt1157 * 128 + 64;
			int i1 = anInt1158 * 128 + 64;
			if(sectionLoaded) {
				aClass31_1156.anInt304 = 0;
				aClass31_1156.anInt303 = 0;
				aClass31_1156.anInt298 = aClass31_1156.anIntArray305[0] = l;
				aClass31_1156.anInt299 = aClass31_1156.anIntArray306[0] = i1;
			}
			anInt976 = 0;
			aClass31_1156 = method73(anInt1159, l, i1, k);
			int j1 = Class35.method566(abyte0, j, 16);
			j += 16;
			for(int k1 = 0; k1 < j1; k1++)
			{
				Class31 class31 = method125(Class35.method566(abyte0, j, 16));
				j += 16;
				int l2 = Class35.method566(abyte0, j, 1);
				j++;
				if(l2 != 0)
				{
					int j3 = Class35.method566(abyte0, j, 1);
					j++;
					if(j3 == 0)
					{
						int l3 = Class35.method566(abyte0, j, 3);
						j += 3;
						int k4 = class31.anInt304;
						int i5 = class31.anIntArray305[k4];
						int k5 = class31.anIntArray306[k4];
						if(l3 == 2 || l3 == 1 || l3 == 3)
							i5 += 128;
						if(l3 == 6 || l3 == 5 || l3 == 7)
							i5 -= 128;
						if(l3 == 4 || l3 == 3 || l3 == 5)
							k5 += 128;
						if(l3 == 0 || l3 == 1 || l3 == 7)
							k5 -= 128;
						class31.anInt302 = l3;
						class31.anInt304 = k4 = (k4 + 1) % 10;
						class31.anIntArray305[k4] = i5;
						class31.anIntArray306[k4] = k5;
					} else
					{
						int i4 = Class35.method566(abyte0, j, 4);
						j += 4;
						if((i4 & 0xc) == 12)
							continue;
						class31.anInt302 = i4;
					}
				}
				aClass31Array1171[anInt976++] = class31;
			}

			int l1 = 0;
			while(j + 24 < length * 8)
			{
				int i2 = Class35.method566(abyte0, j, 16);
				j += 16;
				int i3 = Class35.method566(abyte0, j, 5);
				j += 5;
				if(i3 > 15)
					i3 -= 32;
				int k3 = Class35.method566(abyte0, j, 5);
				j += 5;
				if(k3 > 15)
					k3 -= 32;
				int j4 = Class35.method566(abyte0, j, 4);
				j += 4;
				int l4 = Class35.method566(abyte0, j, 1);
				j++;
				int j5 = (anInt1157 + i3) * 128 + 64;
				int l5 = (anInt1158 + k3) * 128 + 64;
				method73(i2, j5, l5, j4);
				if(l4 == 0)
					anIntArray1144[l1++] = i2;
			}
			if(l1 > 0)
			{
				aClass33_Sub1_767.method558(74);
				aClass33_Sub1_767.method546(l1);
				for(int j2 = 0; j2 < l1; j2++)
				{
					Class31 class31_1 = aClass31Array999[anIntArray1144[j2]];
					aClass33_Sub1_767.method546(class31_1.anInt295);
					aClass33_Sub1_767.method546(class31_1.anInt297);
				}

				aClass33_Sub1_767.method541();
				aClass33_Sub1_767.method558(14);
				aClass33_Sub1_767.method546(l1);
				for(int k2 = 0; k2 < l1; k2++)
				{
					Class31 class31_2 = aClass31Array999[anIntArray1144[k2]];
					aClass33_Sub1_767.method546(class31_2.anInt295);
					aClass33_Sub1_767.method546(class31_2.anInt296);
				}

				aClass33_Sub1_767.method541();
				l1 = 0;
			}
		}*/
		else
			super.method43(id, length, abyte0);
	}
	
    public void method148(boolean flag)
    {
        int i = ((Class26) (aClass26_Sub1_1195)).anInt169 - 199;
        char c = '\234';
        char c1 = '\230';
        aClass26_Sub1_1195.method438(i - 49, 3, 2002);
        i += 40;
        aClass26_Sub1_1195.method428(i, 36, c, c1, 0);
        aClass26_Sub1_1195.method421(i, 36, i + c, 36 + c1);
        int j = 192 + anInt1256;
        int k = anInt1085 + anInt1255 & 0xff;
        int l = ((aClass31_1156.anInt298 - 6040) * 3 * j) / 2048;
        int i1 = ((aClass31_1156.anInt299 - 6040) * 3 * j) / 2048;
        int j1 = Class42.anIntArray463[1024 - k * 4 & 0x3ff];
        int k1 = Class42.anIntArray463[(1024 - k * 4 & 0x3ff) + 1024];
        int l1 = i1 * j1 + l * k1 >> 18;
        i1 = i1 * k1 - l * j1 >> 18;
        l = l1;
        aClass26_Sub1_1195.method448((i + c / 2) - l, 36 + c1 / 2 + i1, 1999, k + 64 & 0xff, j);
        for(int i2 = 0; i2 < anInt1242; i2++)
        {
			if(hideTrees && Functions.inArray(anIntArray1152[i2], trees))
				continue;
            int j3 = (((anIntArray1150[i2] * 128 + 64) - aClass31_1156.anInt298) * 3 * j) / 2048;
            int l3 = (((anIntArray1151[i2] * 128 + 64) - aClass31_1156.anInt299) * 3 * j) / 2048;
            int l4 = l3 * j1 + j3 * k1 >> 18;
            l3 = l3 * k1 - j3 * j1 >> 18;
            j3 = l4;
            method146(i + c / 2 + j3, (36 + c1 / 2) - l3, 65535);
        }

        for(int j2 = 0; j2 < anInt1163; j2++)
        {
            int k3 = (((anIntArray1227[j2] * 128 + 64) - aClass31_1156.anInt298) * 3 * j) / 2048;
            int i4 = (((anIntArray1229[j2] * 128 + 64) - aClass31_1156.anInt299) * 3 * j) / 2048;
            int i5 = i4 * j1 + k3 * k1 >> 18;
            i4 = i4 * k1 - k3 * j1 >> 18;
            k3 = i5;
            method146(i + c / 2 + k3, (36 + c1 / 2) - i4, 0xff0000);
        }

        for(int k2 = 0; k2 < anInt1003; k2++)
        {
            Class31 class31 = aClass31Array991[k2];
            int j4 = ((class31.anInt298 - aClass31_1156.anInt298) * 3 * j) / 2048;
            int j5 = ((class31.anInt299 - aClass31_1156.anInt299) * 3 * j) / 2048;
            int i6 = j5 * j1 + j4 * k1 >> 18;
            j5 = j5 * k1 - j4 * j1 >> 18;
            j4 = i6;
            method146(i + c / 2 + j4, (36 + c1 / 2) - j5, 0xffff00);
        }

        for(int l2 = 0; l2 < anInt976; l2++)
        {
            Class31 class31_1 = aClass31Array1171[l2];
            //if(class31_1.anInt314 <= 0)
            //    continue;
            int k4 = ((class31_1.anInt298 - aClass31_1156.anInt298) * 3 * j) / 2048;
            int k5 = ((class31_1.anInt299 - aClass31_1156.anInt299) * 3 * j) / 2048;
            int j6 = k5 * j1 + k4 * k1 >> 18;
            k5 = k5 * k1 - k4 * j1 >> 18;
            k4 = j6;
            int l6 = 0xffffff;
			if(class31_1.anInt314 <= 0)
				l6 = 0xfcfcfc;
            for (int j7 = 0; j7 < super.anInt772; j7++) {
                if (class31_1.aLong293 != super.aLongArray773[j7] || super.anIntArray774[j7] != 99)
                    continue;
                l6 = 65280;
                break;
            }
            method146(i + c / 2 + k4, (36 + c1 / 2) - k5, l6);
        }

        aClass26_Sub1_1195.method425(i + c / 2, 36 + c1 / 2, 2, 0xffffff, 255);
        aClass26_Sub1_1195.method448(i + 19, 55, 2024, anInt1085 + 128 & 0xff, 128);
        aClass26_Sub1_1195.method421(0, 0, anInt1246, anInt1247 + 12);
        if(!flag)
            return;
        i = super.anInt31 - (((Class26) (aClass26_Sub1_1195)).anInt169 - 199);
        int i3 = super.anInt32 - 36;
        if(i >= 40 && i3 >= 0 && i < 196 && i3 < 152)
        {
            char c2 = '\234';
            char c3 = '\230';
            int l5 = 192 + anInt1256;
            int k6 = anInt1085 + anInt1255 & 0xff;
            int i7 = ((Class26) (aClass26_Sub1_1195)).anInt169 - 199;
            i7 += 40;
            int k7 = ((super.anInt31 - (i7 + c2 / 2)) * 16384) / (3 * l5);
            int l7 = ((super.anInt32 - (36 + c3 / 2)) * 16384) / (3 * l5);
            int i8 = Class42.anIntArray463[1024 - k6 * 4 & 0x3ff];
            int j8 = Class42.anIntArray463[(1024 - k6 * 4 & 0x3ff) + 1024];
            int k8 = l7 * i8 + k7 * j8 >> 15;
            l7 = l7 * j8 - k7 * i8 >> 15;
            k7 = k8;
            k7 += aClass31_1156.anInt298;
            l7 = aClass31_1156.anInt299 - l7;
            if(anInt1175 == 1)
                method141(anInt1157, anInt1158, k7 / 128, l7 / 128, false);
            anInt1175 = 0;
        }
    }
	
    public void method100()
    {
        int i = 2203 - (anInt1158 + anInt1006 + anInt1036);
        if(anInt1157 + anInt1005 + anInt1035 >= 2640)
            i = -50;
        int j = -1;
        for(int k = 0; k < anInt1242; k++)
            aBooleanArray1111[k] = false;

        for(int l = 0; l < anInt1220; l++)
            aBooleanArray1241[l] = false;

        int i1 = aClass42_1199.method594();
        Class32 aclass32[] = aClass42_1199.method596();
        int ai[] = aClass42_1199.method595();
        for(int j1 = 0; j1 < i1 && anInt1049 <= 200; j1++)
        {
            int l1 = ai[j1];
            Class32 class32 = aclass32[j1];
            if(class32.anIntArray359[l1] > 65535 && (class32.anIntArray359[l1] < 0x30d40 || class32.anIntArray359[l1] > 0x493e0))
                continue;
            if(class32 == aClass42_1199.aClass32_501)
            {
                int i2 = class32.anIntArray359[l1] % 10000;
                int l2 = class32.anIntArray359[l1] / 10000;
                if(l2 == 1)
                {
                    String s = "";
                    int k3 = 0;
                    if(aClass31_1156.anInt314 > 0 && aClass31Array1171[i2].anInt314 > 0)
                        k3 = aClass31_1156.anInt314 - aClass31Array1171[i2].anInt314;
                    if(k3 < 0)
                        s = "@or1@";
                    if(k3 < -3)
                        s = "@or2@";
                    if(k3 < -6)
                        s = "@or3@";
                    if(k3 < -9)
                        s = "@red@";
                    if(k3 > 0)
                        s = "@gr1@";
                    if(k3 > 3)
                        s = "@gr2@";
                    if(k3 > 6)
                        s = "@gr3@";
                    if(k3 > 9)
                        s = "@gre@";
                    s = (new StringBuilder()).append(" ").append(s).append("(level-").append(aClass31Array1171[i2].anInt314).append(")").toString();
                    if(aClass31Array1171[i2].anInt292 != 4 && aClass31Array1171[i2].anInt292 != 7)
                        s = "";
                    if(aClass31Array1171[i2].anInt314 <= 0)
                        continue;
                    if(anInt1180 >= 0)
                    {
                        if(Class3.method241(anInt1180).method333() == 1 || Class3.method241(anInt1180).method333() == 2)
                        {
                            aStringArray966[anInt1049] = (new StringBuilder()).append("Cast ").append(Class3.method241(anInt1180).method292()).append(" on").toString();
                            aStringArray1109[anInt1049] = (new StringBuilder()).append("@whi@").append(aClass31Array1171[i2].aString294).append(s).toString();
                            anIntArray1054[anInt1049] = 800;
                            anIntArray1154[anInt1049] = aClass31Array1171[i2].anInt298;
                            anIntArray1155[anInt1049] = aClass31Array1171[i2].anInt299;
                            anIntArray1117[anInt1049] = aClass31Array1171[i2].anInt295;
                            anIntArray1118[anInt1049] = anInt1180;
                            anInt1049++;
                        }
                        continue;
                    }
                    if(anInt1043 >= 0)
                    {
                        aStringArray966[anInt1049] = (new StringBuilder()).append("Use ").append(aString1044).append(" with").toString();
                        aStringArray1109[anInt1049] = (new StringBuilder()).append("@whi@").append(aClass31Array1171[i2].aString294).append(s).toString();
                        anIntArray1054[anInt1049] = 810;
                        anIntArray1154[anInt1049] = aClass31Array1171[i2].anInt298;
                        anIntArray1155[anInt1049] = aClass31Array1171[i2].anInt299;
                        anIntArray1117[anInt1049] = aClass31Array1171[i2].anInt295;
                        anIntArray1118[anInt1049] = anInt1043;
                        anInt1049++;
                        continue;
                    }
                    if(i > 0 && (aClass31Array1171[i2].anInt299 - 64) / 128 + anInt1006 + anInt1036 < 2203 || anInt1157 + anInt1035 >= 650 && anInt1157 + anInt1035 <= 700 && anInt1158 + anInt1036 >= 3475 && anInt1158 + anInt1036 <= 3500)
                    {
                        aStringArray966[anInt1049] = "Attack";
                        if(aClass31Array1171[i2].anInt292 == 1)
                            aStringArray1109[anInt1049] = (new StringBuilder()).append("#adm#@yel@").append(aClass31Array1171[i2].aString294).append("@whi@").append(s).toString();
                        else
                        if(aClass31Array1171[i2].anInt292 == 2)
                            aStringArray1109[anInt1049] = (new StringBuilder()).append("#mod#@whi@").append(aClass31Array1171[i2].aString294).append("@whi@").append(s).toString();
                        else
                        if(aClass31Array1171[i2].anInt292 == 3)
                            aStringArray1109[anInt1049] = (new StringBuilder()).append("#dev#@red@").append(aClass31Array1171[i2].aString294).append("@whi@").append(s).toString();
                        else
                        if(aClass31Array1171[i2].anInt292 == 5)
                            aStringArray1109[anInt1049] = (new StringBuilder()).append("#cmd#@blu@").append(aClass31Array1171[i2].aString294).append("@whi@").append(s).toString();
                        else
                        if(aClass31Array1171[i2].anInt292 == 6)
                            aStringArray1109[anInt1049] = (new StringBuilder()).append("#pmd#@gre@").append(aClass31Array1171[i2].aString294).append("@whi@").append(s).toString();
                        else
                            aStringArray1109[anInt1049] = (new StringBuilder()).append("@whi@").append(aClass31Array1171[i2].aString294).append(s).toString();
                        if(k3 >= 0 && k3 < 5)
                            anIntArray1054[anInt1049] = 805;
                        else
                            anIntArray1054[anInt1049] = 2805;
                        anIntArray1154[anInt1049] = aClass31Array1171[i2].anInt298;
                        anIntArray1155[anInt1049] = aClass31Array1171[i2].anInt299;
                        anIntArray1117[anInt1049] = aClass31Array1171[i2].anInt295;
                        anInt1049++;
                    } else
                    {
                        aStringArray966[anInt1049] = "Duel";
                        if(aClass31Array1171[i2].anInt292 == 1)
                            aStringArray1109[anInt1049] = (new StringBuilder()).append("#adm#@yel@").append(aClass31Array1171[i2].aString294).append("@whi@").append(s).toString();
                        else
                        if(aClass31Array1171[i2].anInt292 == 2)
                            aStringArray1109[anInt1049] = (new StringBuilder()).append("#mod#@whi@").append(aClass31Array1171[i2].aString294).append("@whi@").append(s).toString();
                        else
                        if(aClass31Array1171[i2].anInt292 == 3)
                            aStringArray1109[anInt1049] = (new StringBuilder()).append("#dev#@red@").append(aClass31Array1171[i2].aString294).append("@whi@").append(s).toString();
                        else
                        if(aClass31Array1171[i2].anInt292 == 5)
                            aStringArray1109[anInt1049] = (new StringBuilder()).append("#cmd#@blu@").append(aClass31Array1171[i2].aString294).append("@whi@").append(s).toString();
                        else
                        if(aClass31Array1171[i2].anInt292 == 6)
                            aStringArray1109[anInt1049] = (new StringBuilder()).append("#pmd#@gre@").append(aClass31Array1171[i2].aString294).append("@whi@").append(s).toString();
                        else
                            aStringArray1109[anInt1049] = (new StringBuilder()).append("@whi@").append(aClass31Array1171[i2].aString294).append(s).toString();
                        anIntArray1154[anInt1049] = aClass31Array1171[i2].anInt298;
                        anIntArray1155[anInt1049] = aClass31Array1171[i2].anInt299;
                        anIntArray1054[anInt1049] = 2806;
                        anIntArray1117[anInt1049] = aClass31Array1171[i2].anInt295;
                        anInt1049++;
                    }
                    aStringArray966[anInt1049] = "Trade";
                    if(aClass31Array1171[i2].anInt292 == 1)
                        aStringArray1109[anInt1049] = (new StringBuilder()).append("#adm#@yel@").append(aClass31Array1171[i2].aString294).append("@whi@").append(s).toString();
                    else
                    if(aClass31Array1171[i2].anInt292 == 2)
                        aStringArray1109[anInt1049] = (new StringBuilder()).append("#mod#@whi@").append(aClass31Array1171[i2].aString294).append("@whi@").append(s).toString();
                    else
                    if(aClass31Array1171[i2].anInt292 == 3)
                        aStringArray1109[anInt1049] = (new StringBuilder()).append("#dev#@red@").append(aClass31Array1171[i2].aString294).append("@whi@").append(s).toString();
                    else
                    if(aClass31Array1171[i2].anInt292 == 5)
                        aStringArray1109[anInt1049] = (new StringBuilder()).append("#cmd#@blu@").append(aClass31Array1171[i2].aString294).append("@whi@").append(s).toString();
                    else
                    if(aClass31Array1171[i2].anInt292 == 6)
                        aStringArray1109[anInt1049] = (new StringBuilder()).append("#pmd#@gre@").append(aClass31Array1171[i2].aString294).append("@whi@").append(s).toString();
                    else
                        aStringArray1109[anInt1049] = (new StringBuilder()).append("@whi@").append(aClass31Array1171[i2].aString294).append("@whi@").append(s).toString();
                    anIntArray1054[anInt1049] = 2810;
                    anIntArray1117[anInt1049] = aClass31Array1171[i2].anInt295;
                    anInt1049++;
                    aStringArray966[anInt1049] = "Follow";
                    if(aClass31Array1171[i2].anInt292 == 1)
                        aStringArray1109[anInt1049] = "#adm#@yel@" + aClass31Array1171[i2].aString294 + "@whi@" + s;
                    else
                    if(aClass31Array1171[i2].anInt292 == 2)
                        aStringArray1109[anInt1049] = (new StringBuilder()).append("#mod#@whi@").append(aClass31Array1171[i2].aString294).append("@whi@").append(s).toString();
                    else
                    if(aClass31Array1171[i2].anInt292 == 3)
                        aStringArray1109[anInt1049] = (new StringBuilder()).append("#dev#@red@").append(aClass31Array1171[i2].aString294).append("@whi@").append(s).toString();
                    else
                    if(aClass31Array1171[i2].anInt292 == 5)
                        aStringArray1109[anInt1049] = (new StringBuilder()).append("#cmd#@blu@").append(aClass31Array1171[i2].aString294).append("@whi@").append(s).toString();
                    else
                    if(aClass31Array1171[i2].anInt292 == 6)
                        aStringArray1109[anInt1049] = (new StringBuilder()).append("#pmd#@gre@").append(aClass31Array1171[i2].aString294).append("@whi@").append(s).toString();
                    else
                        aStringArray1109[anInt1049] = (new StringBuilder()).append("@whi@").append(aClass31Array1171[i2].aString294).append(s).toString();
                    anIntArray1054[anInt1049] = 2820;
                    anIntArray1117[anInt1049] = aClass31Array1171[i2].anInt295;
                    anInt1049++;
                    if(!method49(aClass31Array1171[i2].aString294))
                    {
                        aStringArray966[anInt1049] = "Add";
                        if(aClass31Array1171[i2].anInt292 == 1)
                            aStringArray1109[anInt1049] = (new StringBuilder()).append("#adm#@yel@").append(aClass31Array1171[i2].aString294).append("@whi@").append(s).toString();
                        else
                        if(aClass31Array1171[i2].anInt292 == 2)
                            aStringArray1109[anInt1049] = (new StringBuilder()).append("#mod#@whi@").append(aClass31Array1171[i2].aString294).append("@whi@").append(s).toString();
                        else
                        if(aClass31Array1171[i2].anInt292 == 3)
                            aStringArray1109[anInt1049] = (new StringBuilder()).append("#dev#@red@").append(aClass31Array1171[i2].aString294).append("@whi@").append(s).toString();
                        else
                        if(aClass31Array1171[i2].anInt292 == 5)
                            aStringArray1109[anInt1049] = (new StringBuilder()).append("#cmd#@blu@").append(aClass31Array1171[i2].aString294).append("@whi@").append(s).toString();
                        else
                        if(aClass31Array1171[i2].anInt292 == 6)
                            aStringArray1109[anInt1049] = (new StringBuilder()).append("#pmd#@gre@").append(aClass31Array1171[i2].aString294).append("@whi@").append(s).toString();
                        else
                            aStringArray1109[anInt1049] = (new StringBuilder()).append("@whi@").append(aClass31Array1171[i2].aString294).append("@whi@").append(s).toString();
                        anIntArray1054[anInt1049] = 4444;
                        anIntArray1117[anInt1049] = aClass31Array1171[i2].anInt295;
                        anInt1049++;
                    }
                    /*if(aClass31_1156.anInt292 != 1 && aClass31_1156.anInt292 != 2 && aClass31_1156.anInt292 != 3 && aClass31_1156.anInt292 != 5 && aClass31_1156.anInt292 != 6)
                        continue;*/
                    aStringArray966[anInt1049] = "Open Staff Menu With:";
                    if(aClass31Array1171[i2].anInt292 == 1)
                        aStringArray1109[anInt1049] = (new StringBuilder()).append("#adm#@yel@").append(aClass31Array1171[i2].aString294).append("@whi@").append(s).toString();
                    else
                    if(aClass31Array1171[i2].anInt292 == 2)
                        aStringArray1109[anInt1049] = (new StringBuilder()).append("#mod#@whi@").append(aClass31Array1171[i2].aString294).append("@whi@").append(s).toString();
                    else
                    if(aClass31Array1171[i2].anInt292 == 3)
                        aStringArray1109[anInt1049] = (new StringBuilder()).append("#dev#@red@").append(aClass31Array1171[i2].aString294).append("@whi@").append(s).toString();
                    else
                    if(aClass31Array1171[i2].anInt292 == 5)
                        aStringArray1109[anInt1049] = (new StringBuilder()).append("#cmd#@blu@").append(aClass31Array1171[i2].aString294).append("@whi@").append(s).toString();
                    else
                    if(aClass31Array1171[i2].anInt292 == 6)
                        aStringArray1109[anInt1049] = (new StringBuilder()).append("#pmd#@gre@").append(aClass31Array1171[i2].aString294).append("@whi@").append(s).toString();
                    else
                        aStringArray1109[anInt1049] = (new StringBuilder()).append("@whi@").append(aClass31Array1171[i2].aString294).append("@whi@").append(s).toString();
                    anIntArray1054[anInt1049] = 4446;
                    anIntArray1117[anInt1049] = aClass31Array1171[i2].anInt295;
                    anInt1049++;
                    continue;
                }
                if(l2 == 2)
                {
                    Class9_Sub2 class9_sub2 = Class3.method236(anIntArray1230[i2]);
                    if(anInt1180 >= 0)
                    {
                        if(Class3.method241(anInt1180).method333() == 3)
                        {
                            aStringArray966[anInt1049] = (new StringBuilder()).append("Cast ").append(Class3.method241(anInt1180).method292()).append(" on").toString();
                            aStringArray1109[anInt1049] = (new StringBuilder()).append("@lre@").append(class9_sub2.method292()).toString();
                            anIntArray1054[anInt1049] = 200;
                            anIntArray1154[anInt1049] = anIntArray1227[i2];
                            anIntArray1155[anInt1049] = anIntArray1229[i2];
                            anIntArray1117[anInt1049] = anIntArray1230[i2];
                            anIntArray1118[anInt1049] = anInt1180;
                            anInt1049++;
                        }
                        continue;
                    }
                    if(anInt1043 >= 0)
                    {
                        aStringArray966[anInt1049] = (new StringBuilder()).append("Use ").append(aString1044).append(" with").toString();
                        aStringArray1109[anInt1049] = (new StringBuilder()).append("@lre@").append(class9_sub2.method292()).toString();
                        anIntArray1054[anInt1049] = 210;
                        anIntArray1154[anInt1049] = anIntArray1227[i2];
                        anIntArray1155[anInt1049] = anIntArray1229[i2];
                        anIntArray1117[anInt1049] = anIntArray1230[i2];
                        anIntArray1118[anInt1049] = anInt1043;
                        anInt1049++;
                    } else
                    {
                        aStringArray966[anInt1049] = "Take";
                        aStringArray1109[anInt1049] = (new StringBuilder()).append("@lre@").append(class9_sub2.method292()).toString();
                        anIntArray1054[anInt1049] = 220;
                        anIntArray1154[anInt1049] = anIntArray1227[i2];
                        anIntArray1155[anInt1049] = anIntArray1229[i2];
                        anIntArray1117[anInt1049] = anIntArray1230[i2];
                        anInt1049++;
                        aStringArray966[anInt1049] = "Examine";
                        aStringArray1109[anInt1049] = "@lre@" + class9_sub2.method292() + " @or1@(" + anIntArray1230[i2] + ":" + (anIntArray1227[i2] + anInt1035) + "," + (anIntArray1229[i2] + anInt1036) + ")";
                        anIntArray1054[anInt1049] = 3200;
                        anIntArray1117[anInt1049] = anIntArray1230[i2];
                        anInt1049++;
                    }
                    continue;
                }
                if(l2 != 3)
                    continue;
                String s1 = "";
                int l3 = -1;
                Class9_Sub3 class9_sub3 = Class3.method235(aClass31Array991[i2].anInt310);
                if(class9_sub3.method322())
                {
                    int i4 = (class9_sub3.method319() + class9_sub3.method320() + class9_sub3.method321() + class9_sub3.method318()) / 4;
                    int j4 = (anIntArray1112[0] + anIntArray1112[1] + anIntArray1112[2] + anIntArray1112[3] + 27) / 4;
                    l3 = j4 - i4;
                    s1 = "@yel@";
                    if(l3 < 0)
                        s1 = "@or1@";
                    if(l3 < -3)
                        s1 = "@or2@";
                    if(l3 < -6)
                        s1 = "@or3@";
                    if(l3 < -9)
                        s1 = "@red@";
                    if(l3 > 0)
                        s1 = "@gr1@";
                    if(l3 > 3)
                        s1 = "@gr2@";
                    if(l3 > 6)
                        s1 = "@gr3@";
                    if(l3 > 9)
                        s1 = "@gre@";
                    s1 = (new StringBuilder()).append(" ").append(s1).append("(level-").append(i4).append(")").toString();
                }
                if(anInt1180 >= 0)
                {
                    if(Class3.method241(anInt1180).method333() == 2)
                    {
                        aStringArray966[anInt1049] = (new StringBuilder()).append("Cast ").append(Class3.method241(anInt1180).method292()).append(" on").toString();
                        aStringArray1109[anInt1049] = (new StringBuilder()).append("@yel@").append(class9_sub3.method292()).toString();
                        anIntArray1054[anInt1049] = 700;
                        anIntArray1154[anInt1049] = aClass31Array991[i2].anInt298;
                        anIntArray1155[anInt1049] = aClass31Array991[i2].anInt299;
                        anIntArray1117[anInt1049] = aClass31Array991[i2].anInt295;
                        anIntArray1118[anInt1049] = anInt1180;
                        anInt1049++;
                    }
                    continue;
                }
                if(anInt1043 >= 0)
                {
                    aStringArray966[anInt1049] = (new StringBuilder()).append("Use ").append(aString1044).append(" with").toString();
                    aStringArray1109[anInt1049] = (new StringBuilder()).append("@yel@").append(class9_sub3.method292()).toString();
                    anIntArray1054[anInt1049] = 710;
                    anIntArray1154[anInt1049] = aClass31Array991[i2].anInt298;
                    anIntArray1155[anInt1049] = aClass31Array991[i2].anInt299;
                    anIntArray1117[anInt1049] = aClass31Array991[i2].anInt295;
                    anIntArray1118[anInt1049] = anInt1043;
                    anInt1049++;
                    continue;
                }
                if(class9_sub3.method322())
                {
                    aStringArray966[anInt1049] = "Attack";
                    aStringArray1109[anInt1049] = (new StringBuilder()).append("@yel@").append(class9_sub3.method292()).append(s1).toString();
                    if(l3 >= 0)
                        anIntArray1054[anInt1049] = 715;
                    else
                        anIntArray1054[anInt1049] = 2715;
                    anIntArray1154[anInt1049] = aClass31Array991[i2].anInt298;
                    anIntArray1155[anInt1049] = aClass31Array991[i2].anInt299;
                    anIntArray1117[anInt1049] = aClass31Array991[i2].anInt295;
                    anInt1049++;
                }
                aStringArray966[anInt1049] = "Talk-to";
                aStringArray1109[anInt1049] = (new StringBuilder()).append("@yel@").append(class9_sub3.method292()).toString();
                anIntArray1054[anInt1049] = 720;
                anIntArray1154[anInt1049] = aClass31Array991[i2].anInt298;
                anIntArray1155[anInt1049] = aClass31Array991[i2].anInt299;
                anIntArray1117[anInt1049] = aClass31Array991[i2].anInt295;
                anInt1049++;
                if(!class9_sub3.method307().equals(""))
                {
                    aStringArray966[anInt1049] = class9_sub3.method307();
                    aStringArray1109[anInt1049] = (new StringBuilder()).append("@yel@").append(class9_sub3.method292()).toString();
                    anIntArray1054[anInt1049] = 725;
                    anIntArray1154[anInt1049] = aClass31Array991[i2].anInt298;
                    anIntArray1155[anInt1049] = aClass31Array991[i2].anInt299;
                    anIntArray1117[anInt1049] = aClass31Array991[i2].anInt295;
                    anInt1049++;
                }
                aStringArray966[anInt1049] = "Examine";
                aStringArray1109[anInt1049] = "@yel@" + class9_sub3.method292() + " @or1@(" + aClass31Array991[i2].anInt310 + ":" + i2 + ":" + aClass31Array991[i2].anInt295 + ":" + (((aClass31Array991[i2].anInt298 - 64) / 128) + anInt1035) + "," + (((aClass31Array991[i2].anInt299 - 64) / 128) + anInt1036) + ")";
                anIntArray1054[anInt1049] = 3700;
                anIntArray1117[anInt1049] = aClass31Array991[i2].anInt310;
                anInt1049++;
                continue;
            }
            if(class32 != null && class32.anInt358 >= 10000)
            {
                int j2 = class32.anInt358 - 10000;
                int i3 = anIntArray1222[j2];
                if(aBooleanArray1241[j2])
                    continue;
                if(anInt1180 >= 0)
                {
                    if(Class3.method241(anInt1180).method333() == 4)
                    {
                        aStringArray966[anInt1049] = (new StringBuilder()).append("Cast ").append(Class3.method241(anInt1180).method292()).append(" on").toString();
                        aStringArray1109[anInt1049] = (new StringBuilder()).append("@cya@").append(Class3.method245(i3).method292()).toString();
                        anIntArray1054[anInt1049] = 300;
                        anIntArray1154[anInt1049] = anIntArray1207[j2];
                        anIntArray1155[anInt1049] = anIntArray1208[j2];
                        anIntArray1117[anInt1049] = anIntArray1221[j2];
                        anIntArray1118[anInt1049] = anInt1180;
                        anInt1049++;
                    }
                } else
                if(anInt1043 >= 0)
                {
                    aStringArray966[anInt1049] = (new StringBuilder()).append("Use ").append(aString1044).append(" with").toString();
                    aStringArray1109[anInt1049] = (new StringBuilder()).append("@cya@").append(Class3.method245(i3).method292()).toString();
                    anIntArray1054[anInt1049] = 310;
                    anIntArray1154[anInt1049] = anIntArray1207[j2];
                    anIntArray1155[anInt1049] = anIntArray1208[j2];
                    anIntArray1117[anInt1049] = anIntArray1221[j2];
                    anIntArray1118[anInt1049] = anInt1043;
                    anInt1049++;
                } else
                {
                    if(!Class3.method245(i3).method323().equalsIgnoreCase("WalkTo"))
                    {
                        aStringArray966[anInt1049] = Class3.method245(i3).method323();
                        aStringArray1109[anInt1049] = (new StringBuilder()).append("@cya@").append(Class3.method245(i3).method292()).toString();
                        anIntArray1054[anInt1049] = 320;
                        anIntArray1154[anInt1049] = anIntArray1207[j2];
                        anIntArray1155[anInt1049] = anIntArray1208[j2];
                        anIntArray1117[anInt1049] = anIntArray1221[j2];
                        anInt1049++;
                    }
                    if(!Class3.method245(i3).method324().equalsIgnoreCase("Examine"))
                    {
                        aStringArray966[anInt1049] = Class3.method245(i3).method324();
                        aStringArray1109[anInt1049] = (new StringBuilder()).append("@cya@").append(Class3.method245(i3).method292()).toString();
                        anIntArray1054[anInt1049] = 2300;
                        anIntArray1154[anInt1049] = anIntArray1207[j2];
                        anIntArray1155[anInt1049] = anIntArray1208[j2];
                        anIntArray1117[anInt1049] = anIntArray1221[j2];
                        anInt1049++;
                    }
                    aStringArray966[anInt1049] = "Examine";
                    aStringArray1109[anInt1049] = "@cya@" + Class3.method245(i3).method292() + " @or1@(" + i3 + ":" + (anIntArray1207[j2] + anInt1035) + "," + (anIntArray1208[j2] + anInt1036) + ")";
                    anIntArray1054[anInt1049] = 3300;
                    anIntArray1117[anInt1049] = i3;
                    anInt1049++;
                }
                aBooleanArray1241[j2] = true;
                continue;
            }
            if(class32 != null && class32.anInt358 >= 0)
            {
                int k2 = class32.anInt358;
                int j3 = anIntArray1152[k2];
                if(aBooleanArray1111[k2])
                    continue;
                if(anInt1180 >= 0)
                {
                    if(Class3.method241(anInt1180).method333() == 5)
                    {
                        aStringArray966[anInt1049] = (new StringBuilder()).append("Cast ").append(Class3.method241(anInt1180).method292()).append(" on").toString();
                        aStringArray1109[anInt1049] = (new StringBuilder()).append("@cya@").append(Class3.method247(j3).method292()).toString();
                        anIntArray1054[anInt1049] = 400;
                        anIntArray1154[anInt1049] = anIntArray1150[k2];
                        anIntArray1155[anInt1049] = anIntArray1151[k2];
                        anIntArray1117[anInt1049] = anIntArray1153[k2];
                        anIntArray1118[anInt1049] = anIntArray1152[k2];
                        anIntArray1119[anInt1049] = anInt1180;
                        anInt1049++;
                    }
                } else
                if(anInt1043 >= 0)
                {
                    aStringArray966[anInt1049] = (new StringBuilder()).append("Use ").append(aString1044).append(" with").toString();
                    aStringArray1109[anInt1049] = (new StringBuilder()).append("@cya@").append(Class3.method247(j3).method292()).toString();
                    anIntArray1054[anInt1049] = 410;
                    anIntArray1154[anInt1049] = anIntArray1150[k2];
                    anIntArray1155[anInt1049] = anIntArray1151[k2];
                    anIntArray1117[anInt1049] = anIntArray1153[k2];
                    anIntArray1118[anInt1049] = anIntArray1152[k2];
                    anIntArray1119[anInt1049] = anInt1043;
                    anInt1049++;
                } else
                {
                    if(!Class3.method247(j3).method295().equalsIgnoreCase("WalkTo"))
                    {
                        aStringArray966[anInt1049] = Class3.method247(j3).method295();
                        aStringArray1109[anInt1049] = (new StringBuilder()).append("@cya@").append(Class3.method247(j3).method292()).toString();
                        anIntArray1054[anInt1049] = 420;
                        anIntArray1154[anInt1049] = anIntArray1150[k2];
                        anIntArray1155[anInt1049] = anIntArray1151[k2];
                        anIntArray1117[anInt1049] = anIntArray1153[k2];
                        anIntArray1118[anInt1049] = anIntArray1152[k2];
                        anInt1049++;
                    }
                    if(!Class3.method247(j3).method296().equalsIgnoreCase("Examine"))
                    {
                        aStringArray966[anInt1049] = Class3.method247(j3).method296();
                        aStringArray1109[anInt1049] = (new StringBuilder()).append("@cya@").append(Class3.method247(j3).method292()).toString();
                        anIntArray1054[anInt1049] = 2400;
                        anIntArray1154[anInt1049] = anIntArray1150[k2];
                        anIntArray1155[anInt1049] = anIntArray1151[k2];
                        anIntArray1117[anInt1049] = anIntArray1153[k2];
                        anIntArray1118[anInt1049] = anIntArray1152[k2];
                        anInt1049++;
                    }
                    aStringArray966[anInt1049] = "Examine";
                    aStringArray1109[anInt1049] = "@cya@" + Class3.method247(j3).method292() + " @or1@(" + j3 + ":" + (anIntArray1150[k2] + anInt1035) + "," + (anIntArray1151[k2] + anInt1036) + ")";
                    anIntArray1054[anInt1049] = 3400;
                    anIntArray1117[anInt1049] = j3;
                    anInt1049++;
                }
                aBooleanArray1111[k2] = true;
                continue;
            }
            if(l1 >= 0)
                l1 = class32.anIntArray359[l1] - 0x30d40;
            if(l1 >= 0)
                j = l1;
        }

        if(anInt1180 >= 0 && Class3.method241(anInt1180).method333() <= 1)
        {
            aStringArray966[anInt1049] = (new StringBuilder()).append("Cast ").append(Class3.method241(anInt1180).method292()).append(" on self").toString();
            aStringArray1109[anInt1049] = "";
            anIntArray1054[anInt1049] = 1000;
            anIntArray1117[anInt1049] = anInt1180;
            anInt1049++;
        }
        if(j != -1)
        {
            int k1 = j;
            if(anInt1180 >= 0)
            {
                if(Class3.method241(anInt1180).method333() == 6)
                {
                    aStringArray966[anInt1049] = (new StringBuilder()).append("Cast ").append(Class3.method241(anInt1180).method292()).append(" on ground").toString();
                    aStringArray1109[anInt1049] = "";
                    anIntArray1054[anInt1049] = 900;
                    anIntArray1154[anInt1049] = aClass17_1170.anIntArray119[k1];
                    anIntArray1155[anInt1049] = aClass17_1170.anIntArray120[k1];
                    anIntArray1117[anInt1049] = anInt1180;
                    anInt1049++;
                    return;
                }
            } else
            if(anInt1043 < 0)
            {
                aStringArray966[anInt1049] = "Walk Here";
                aStringArray1109[anInt1049] = "@or2@(" + (aClass17_1170.anIntArray119[k1] + anInt1035) + "," + (aClass17_1170.anIntArray120[k1] + anInt1036) + ")";
                anIntArray1054[anInt1049] = 920;
                anIntArray1154[anInt1049] = aClass17_1170.anIntArray119[k1];
                anIntArray1155[anInt1049] = aClass17_1170.anIntArray120[k1];
                anInt1049++;
            }
        }
    }
	
    public void method9()
    {
        if(aBoolean1009)
            return;
        if(aBoolean1197)
            return;
        try
        {
            anInt1033++;
            if(anInt1015 == 0)
            {
                super.anInt15 = 0;
                method59();
            }
            if(anInt1015 == 1)
            {
                super.anInt15++;
                method113();
            }
            super.anInt34 = 0;
            super.anInt36 = 0;
            anInt1212++;
            if(anInt1212 > 500)
            {
                anInt1212 = 0;
                int i = (int)(Math.random() * 4D);
                if((i & 1) == 1)
                    anInt1023 += anInt1024;
                if((i & 2) == 2)
                    anInt1181 += anInt1182;
            }
            if(anInt1023 < -50)
                anInt1024 = 2;
            if(anInt1023 > 50)
                anInt1024 = -2;
            if(anInt1181 < -50)
                anInt1182 = 2;
            if(anInt1181 > 50)
                anInt1182 = -2;
            if(anInt1223 > 0)
                anInt1223--;
            if(anInt1224 > 0)
                anInt1224--;
            if(anInt1225 > 0)
                anInt1225--;
            if(anInt1226 > 0)
            {
                anInt1226--;
                return;
            }
        }
        catch(OutOfMemoryError outofmemoryerror)
        {
            method98();
            aBoolean1009 = true;
        }
    }
	
    public void method138()
    {
        if(anInt1086 != 0)
            method68();
        else
        if(aBoolean1093)
            method74();
        else
        if(aBoolean1030)
            method136();
        else
        if(anInt1209 == 1)
            method85();
        else
        if(aBoolean985 && anInt949 == 0)
            method67();
        else
        if(aBoolean1200 && anInt949 == 0)
            method109();
        else
        if(aBoolean1167)
            method130();
        else
        if(aBoolean1236)
            method123();
        else
        if(aBoolean1204)
            method116();
        else
        if(aBoolean1193)
            method133();
        else
        if(anInt1025 == 1)
            method61();
        else
        if(anInt1025 == 2)
            method119();
        else
        if(anInt1059 != 0)
            method142();
        else
        if(aBoolean1302)
            drawStaffMenu();
        else
		if(showOptionMenu)
			drawOptionMenu();
		else
		if(showInputMenu)
			drawInputMenu();
		else
		if(showYesNoMenu)
			drawYesNoMenu();
		else
        if(aBoolean1305)
        {
            doStaffAction();
        } else
        {
            if(aBoolean1013)
                method96();
            if((aClass31_1156.anInt301 == 8 || aClass31_1156.anInt301 == 9 || anInt953 == 0) && anInt953 != 2)
                method115();
            method87();
            boolean flag = !aBoolean1013 && !aBoolean1211;
            if(flag)
                anInt1049 = 0;
            if(anInt1011 == 0 && flag)
                method100();
            if(anInt1011 == 1)
                drawInventoryMenu(flag);
            if(anInt1011 == 2)
                method148(flag);
            if(anInt1011 == 3)
                method81(flag);
            if(anInt1011 == 4)
                method108(flag);
            if(anInt1011 == 5)
                method106(flag);
            if(anInt1011 == 6)
                method112(flag);
            if(!aBoolean1211 && !aBoolean1013)
                method105();
            if(aBoolean1211 && !aBoolean1013)
                drawRightClickMenu();
        }
        anInt1175 = 0;
    }
	
    public void method113()
    {
        if(!aBoolean948 && System.currentTimeMillis() - aLong1269 > 5000L)
        {
            aLong1269 = System.currentTimeMillis();
            super.aClass33_Sub1_767.method558(5);
            super.aClass33_Sub1_767.method541();
            aBoolean948 = true;
        }
        if(anInt1083 >= 1)
            anInt1083--;
        if(anInt1084 >= 1)
            anInt1084--;
        method29();
        if(anInt1086 > 0)
            anInt1086--;
        if(aClass31_1156.anInt301 == 8 || aClass31_1156.anInt301 == 9)
            anInt949 = 500;
        if(anInt949 > 0)
            anInt949--;
        if(aBoolean1055)
        {
            method57();
            return;
        }
        for(int i = 0; i < anInt976; i++)
        {
            Class31 class31 = aClass31Array1171[i];
            int i3 = (class31.anInt304 + 1) % 10;
            if(class31.anInt303 != i3)
            {
                int l3 = -1;
                int j4 = class31.anInt303;
                int l4;
                if(j4 < i3)
                    l4 = i3 - j4;
                else
                    l4 = (10 + i3) - j4;
                int j5 = 4;
                if(l4 > 2)
                    j5 = (l4 - 1) * 4;
                if(class31.anIntArray305[j4] - class31.anInt298 > 384 || class31.anIntArray306[j4] - class31.anInt299 > 384 || class31.anIntArray305[j4] - class31.anInt298 < -384 || class31.anIntArray306[j4] - class31.anInt299 < -384 || l4 > 8)
                {
                    class31.anInt298 = class31.anIntArray305[j4];
                    class31.anInt299 = class31.anIntArray306[j4];
                } else
                {
                    if(class31.anInt298 < class31.anIntArray305[j4])
                    {
                        class31.anInt298 += j5;
                        class31.anInt300++;
                        l3 = 2;
                    } else
                    if(class31.anInt298 > class31.anIntArray305[j4])
                    {
                        class31.anInt298 -= j5;
                        class31.anInt300++;
                        l3 = 6;
                    }
                    if(class31.anInt298 - class31.anIntArray305[j4] < j5 && class31.anInt298 - class31.anIntArray305[j4] > -j5)
                        class31.anInt298 = class31.anIntArray305[j4];
                    if(class31.anInt299 < class31.anIntArray306[j4])
                    {
                        class31.anInt299 += j5;
                        class31.anInt300++;
                        if(l3 == -1)
                            l3 = 4;
                        else
                        if(l3 == 2)
                            l3 = 3;
                        else
                            l3 = 5;
                    } else
                    if(class31.anInt299 > class31.anIntArray306[j4])
                    {
                        class31.anInt299 -= j5;
                        class31.anInt300++;
                        if(l3 == -1)
                            l3 = 0;
                        else
                        if(l3 == 2)
                            l3 = 1;
                        else
                            l3 = 7;
                    }
                    if(class31.anInt299 - class31.anIntArray306[j4] < j5 && class31.anInt299 - class31.anIntArray306[j4] > -j5)
                        class31.anInt299 = class31.anIntArray306[j4];
                }
                if(l3 != -1)
                    class31.anInt301 = l3;
                if(class31.anInt298 == class31.anIntArray305[j4] && class31.anInt299 == class31.anIntArray306[j4])
                    class31.anInt303 = (j4 + 1) % 10;
            } else
            {
                class31.anInt301 = class31.anInt302;
            }
            if(class31.anInt309 > 0)
                class31.anInt309--;
            if(class31.anInt323 > 0)
                class31.anInt323--;
            if(class31.anInt313 > 0)
                class31.anInt313--;
            if(anInt1237 <= 0)
                continue;
            anInt1237--;
            if(anInt1237 == 0)
                method121("You have been granted another life. Be more careful this time!", 3, 0);
            if(anInt1237 == 0)
                method121("You retain your skills. Your items land where you died", 3, 0);
        }

        for(int j = 0; j < anInt1003; j++)
        {
            Class31 class31_1 = aClass31Array991[j];
            int j3 = (class31_1.anInt304 + 1) % 10;
            if(class31_1.anInt303 != j3)
            {
                int i4 = -1;
                int k4 = class31_1.anInt303;
                int i5;
                if(k4 < j3)
                    i5 = j3 - k4;
                else
                    i5 = (10 + j3) - k4;
                int k5 = 4;
                if(i5 > 2)
                    k5 = (i5 - 1) * 4;
                if(class31_1.anIntArray305[k4] - class31_1.anInt298 > 384 || class31_1.anIntArray306[k4] - class31_1.anInt299 > 384 || class31_1.anIntArray305[k4] - class31_1.anInt298 < -384 || class31_1.anIntArray306[k4] - class31_1.anInt299 < -384 || i5 > 8)
                {
                    class31_1.anInt298 = class31_1.anIntArray305[k4];
                    class31_1.anInt299 = class31_1.anIntArray306[k4];
                } else
                {
                    if(class31_1.anInt298 < class31_1.anIntArray305[k4])
                    {
                        class31_1.anInt298 += k5;
                        class31_1.anInt300++;
                        i4 = 2;
                    } else
                    if(class31_1.anInt298 > class31_1.anIntArray305[k4])
                    {
                        class31_1.anInt298 -= k5;
                        class31_1.anInt300++;
                        i4 = 6;
                    }
                    if(class31_1.anInt298 - class31_1.anIntArray305[k4] < k5 && class31_1.anInt298 - class31_1.anIntArray305[k4] > -k5)
                        class31_1.anInt298 = class31_1.anIntArray305[k4];
                    if(class31_1.anInt299 < class31_1.anIntArray306[k4])
                    {
                        class31_1.anInt299 += k5;
                        class31_1.anInt300++;
                        if(i4 == -1)
                            i4 = 4;
                        else
                        if(i4 == 2)
                            i4 = 3;
                        else
                            i4 = 5;
                    } else
                    if(class31_1.anInt299 > class31_1.anIntArray306[k4])
                    {
                        class31_1.anInt299 -= k5;
                        class31_1.anInt300++;
                        if(i4 == -1)
                            i4 = 0;
                        else
                        if(i4 == 2)
                            i4 = 1;
                        else
                            i4 = 7;
                    }
                    if(class31_1.anInt299 - class31_1.anIntArray306[k4] < k5 && class31_1.anInt299 - class31_1.anIntArray306[k4] > -k5)
                        class31_1.anInt299 = class31_1.anIntArray306[k4];
                }
                if(i4 != -1)
                    class31_1.anInt301 = i4;
                if(class31_1.anInt298 == class31_1.anIntArray305[k4] && class31_1.anInt299 == class31_1.anIntArray306[k4])
                    class31_1.anInt303 = (k4 + 1) % 10;
            } else
            {
                class31_1.anInt301 = class31_1.anInt302;
                if(class31_1.anInt310 == 43)
                    class31_1.anInt300++;
            }
            if(class31_1.anInt309 > 0)
                class31_1.anInt309--;
            if(class31_1.anInt323 > 0)
                class31_1.anInt323--;
            if(class31_1.anInt313 > 0)
                class31_1.anInt313--;
        }

        if(anInt1011 != 2)
        {
            if(Class26.anInt192 > 0)
                anInt951++;
            if(Class26.anInt193 > 0)
                anInt951 = 0;
            Class26.anInt192 = 0;
            Class26.anInt193 = 0;
        }
        for(int k = 0; k < anInt976; k++)
        {
            Class31 class31_2 = aClass31Array1171[k];
            if(class31_2.anInt325 > 0)
                class31_2.anInt325--;
        }

        if(aBoolean1190)
        {
            if(anInt1147 - aClass31_1156.anInt298 < -500 || anInt1147 - aClass31_1156.anInt298 > 500 || anInt1148 - aClass31_1156.anInt299 < -500 || anInt1148 - aClass31_1156.anInt299 > 500)
            {
                anInt1147 = aClass31_1156.anInt298;
                anInt1148 = aClass31_1156.anInt299;
            }
        } else
        {
            if(anInt1147 - aClass31_1156.anInt298 < -500 || anInt1147 - aClass31_1156.anInt298 > 500 || anInt1148 - aClass31_1156.anInt299 < -500 || anInt1148 - aClass31_1156.anInt299 > 500)
            {
                anInt1147 = aClass31_1156.anInt298;
                anInt1148 = aClass31_1156.anInt299;
            }
            if(anInt1147 != aClass31_1156.anInt298)
                anInt1147 += (aClass31_1156.anInt298 - anInt1147) / (16 + (anInt1176 - 500) / 15);
            if(anInt1148 != aClass31_1156.anInt299)
                anInt1148 += (aClass31_1156.anInt299 - anInt1148) / (16 + (anInt1176 - 500) / 15);
            if(aBoolean960)
            {
                int l = anInt1016 * 32;
                int j2 = l - anInt1085;
                byte byte0 = 1;
                if(j2 != 0)
                {
                    anInt1017++;
                    if(j2 > 128)
                    {
                        byte0 = -1;
                        j2 = 256 - j2;
                    } else
                    if(j2 > 0)
                        byte0 = 1;
                    else
                    if(j2 < -128)
                    {
                        byte0 = 1;
                        j2 = 256 + j2;
                    } else
                    if(j2 < 0)
                    {
                        byte0 = -1;
                        j2 = -j2;
                    }
                    anInt1085 += ((anInt1017 * j2 + 255) / 256) * byte0;
                    anInt1085 &= 0xff;
                } else
                {
                    anInt1017 = 0;
                }
            }
        }
        if(anInt951 > 20)
            anInt951 = 0;
        if(aBoolean1289)
        {
            aBoolean1288 = true;
            if(super.aString39.length() > 0)
            {
				sendSleepWord(super.aString39);
                super.aString38 = "";
                super.aString39 = "";
                aString1290 = "Please wait...";
            }
			//if(super.anInt34 == 1)
			//	System.out.println(super.anInt31 + "," + super.anInt32);
            if(super.anInt34 == 1 && super.anInt31 > 159 && super.anInt31 < 220 && super.anInt32 > 290 && super.anInt32 < 318)
            {
				System.out.println("Asking for a new sleepword...");
                super.aClass33_Sub1_767.method558(70);
                super.aClass33_Sub1_767.method556("");
                super.aClass33_Sub1_767.method541();
                super.aString38 = "";
                super.aString39 = "";
                aString1290 = "Please wait...";
            }
            //return;
        }
        if(super.anInt32 > anInt1247 - 4)
        {
            if(super.anInt31 > anInt1257 + 13 && super.anInt31 < anInt1257 + 98 && super.anInt34 == 1)
                anInt1092 = 0;
            if(super.anInt31 > anInt1257 * 2 + 98 && super.anInt31 < anInt1257 * 2 + 182 && super.anInt34 == 1)
            {
                anInt1092 = 1;
                aClass30_1087.anIntArray258[anInt1088] = 0xf423f;
            }
            if(super.anInt31 > anInt1257 * 3 + 183 && super.anInt31 < anInt1257 * 3 + 268 && super.anInt34 == 1)
            {
                anInt1092 = 2;
                aClass30_1087.anIntArray258[anInt1090] = 0xf423f;
            }
            if(super.anInt31 > anInt1257 * 4 + 266 && super.anInt31 < anInt1257 * 4 + 352 && super.anInt34 == 1)
            {
                anInt1092 = 3;
                aClass30_1087.anIntArray258[anInt1091] = 0xf423f;
            }
            if(super.anInt31 > anInt1257 * 5 + 342 && super.anInt31 < anInt1257 * 5 + 432 && super.anInt34 == 1)
            {
                anInt1025 = 1;
                anInt1113 = 0;
                super.aString38 = "";
                super.aString39 = "";
            }
            super.anInt34 = 0;
            super.anInt33 = 0;
        }
        aClass30_1087.method472(super.anInt31, super.anInt32, super.anInt34, super.anInt33);
        if(anInt1092 > 0 && super.anInt31 >= 494 && super.anInt32 >= anInt1247 - 66)
            super.anInt34 = 0;
        if(aClass30_1087.method473(anInt1089))
        {
            String s = aString1275 = aClass30_1087.method503(anInt1089);
            aClass30_1087.method502(anInt1089, "");
            if(aBoolean1288)
            {
                aBoolean1288 = false;
                return;
            }
            if(s.trim().startsWith("::"))
            {
                s = s.substring(2);
				handleCommand(s);
                //if(!method51(s) && !aBoolean1289 && !aBoolean1288)
                //    method38(s);
            } else
            if(!aBoolean1289 && !aBoolean1288)
            {
                Class1 _tmp = aClass1_1299;
                s = Class1.method225(s);
                byte abyte0[] = Class2.method228(s);
                method37(abyte0, abyte0.length);
                s = Class2.method229(abyte0, 0, abyte0.length);
                aClass31_1156.anInt309 = 150;
                aClass31_1156.aString308 = s;
                if(!aBoolean1293 || aClass31_1156.anInt292 == 1 || aClass31_1156.anInt292 == 2 || aClass31_1156.anInt292 == 3 || aClass31_1156.anInt292 == 6 || aClass31_1156.anInt292 == 5)
                    method121((new StringBuilder()).append(aClass31_1156.aString294).append(": ").append(s).toString(), 2, aClass31_1156.anInt292);
                else
                    method121((new StringBuilder()).append(aClass31_1156.aString294).append(": ").append(s).toString(), 2, 7);
            }
        }
        if(anInt1092 == 0)
        {
            for(int i1 = 0; i1 < 5; i1++)
                if(anIntArray1146[i1] > 0)
                    anIntArray1146[i1]--;

        }
        if(anInt1237 != 0)
            super.anInt34 = 0;
        if(aBoolean1236 || aBoolean1193)
        {
            if(super.anInt33 != 0)
                anInt1161++;
            else
                anInt1161 = 0;
            if(anInt1161 > 500)
                anInt1162 += 0x186a0;
            else
            if(anInt1161 > 350)
                anInt1162 += 10000;
            else
            if(anInt1161 > 250)
                anInt1162 += 1000;
            else
            if(anInt1161 > 150)
                anInt1162 += 100;
            else
            if(anInt1161 > 100)
                anInt1162 += 10;
            else
            if(anInt1161 > 50)
                anInt1162++;
            else
            if(anInt1161 > 20 && (anInt1161 & 5) == 0)
                anInt1162++;
        } else
        {
            anInt1161 = 0;
            anInt1162 = 0;
        }
        if(super.anInt34 == 1)
            anInt1175 = 1;
        else
        if(super.anInt34 == 2)
            anInt1175 = 2;
        aClass42_1199.method593(super.anInt31, super.anInt32);
        super.anInt34 = 0;
        if(aBoolean960)
        {
            if(anInt1017 == 0 || aBoolean1190)
            {
                if(super.aBoolean24)
                {
                    anInt1016 = anInt1016 + 1 & 7;
                    super.aBoolean24 = false;
                    if(!aBoolean1187)
                    {
                        if((anInt1016 & 1) == 0)
                            anInt1016 = anInt1016 + 1 & 7;
                        for(int j1 = 0; j1 < 8 && !method124(anInt1016); j1++)
                            anInt1016 = anInt1016 + 1 & 7;

                    }
                }
                if(super.aBoolean25)
                {
                    anInt1016 = anInt1016 + 7 & 7;
                    super.aBoolean25 = false;
                    if(!aBoolean1187)
                    {
                        if((anInt1016 & 1) == 0)
                            anInt1016 = anInt1016 + 7 & 7;
                        for(int k1 = 0; k1 < 8 && !method124(anInt1016); k1++)
                            anInt1016 = anInt1016 + 7 & 7;

                    }
                }
            }
        } else
        if(super.aBoolean24)
            anInt1085 = anInt1085 + 2 & 0xff;
        else
        if(super.aBoolean25)
            anInt1085 = anInt1085 - 2 & 0xff;
        if(aBoolean1187 && anInt1176 > 900)
            anInt1176 -= 4;
        else
        if(!aBoolean1187 && anInt1176 < 500)
            anInt1176 += 4;
        if(anInt1114 > 0)
            anInt1114--;
        else
        if(anInt1114 < 0)
            anInt1114++;
        aClass42_1199.method624(17);
        anInt1219++;
        if(anInt1219 > 5)
        {
            anInt1219 = 0;
            anInt1164 = (anInt1164 + 1) % 3;
            anInt1165 = (anInt1165 + 1) % 4;
            anInt1166 = (anInt1166 + 1) % 5;
        }
        for(int l1 = 0; l1 < anInt1242; l1++)
        {
            int k2 = anIntArray1150[l1];
            int k3 = anIntArray1151[l1];
            if(k2 >= 0 && k3 >= 0 && k2 < 96 && k3 < 96 && anIntArray1152[l1] == 74)
                aClass32Array1081[l1].method523(1, 0, 0);
        }

        for(int i2 = 0; i2 < anInt1169; i2++)
        {
            anIntArray1194[i2]++;
            if(anIntArray1194[i2] <= 50)
                continue;
            anInt1169--;
            for(int l2 = i2; l2 < anInt1169; l2++)
            {
                anIntArray1215[l2] = anIntArray1215[l2 + 1];
                anIntArray1053[l2] = anIntArray1053[l2 + 1];
                anIntArray1194[l2] = anIntArray1194[l2 + 1];
                anIntArray1068[l2] = anIntArray1068[l2 + 1];
            }

        }

    }
	
	public void sendSleepWord(String s) {
		super.aString39 = s;
		System.out.println("Sending sleepword " + super.aString39 + "...");
		super.aClass33_Sub1_767.method558(70);
		super.aClass33_Sub1_767.method556(super.aString39);
		super.aClass33_Sub1_767.method541();
	}
	
    public void method93()
    {
        anInt1265++;
        long l = System.currentTimeMillis();
        if(aBoolean1263)
        {
            aLong1262 = l;
            aBoolean1263 = false;
        }
        if(System.currentTimeMillis() - aLong1262 > 1000L)
        {
            anInt1264 = anInt1265;
            anInt1265 = 0;
            aBoolean1263 = true;
        }
        if(l - aLong1296 > 200L && aBoolean1286)
            try
            {
                aLong1296 = l;
                aLinkedList1295.add(method53());
            }
            catch(Exception exception) { }
		
		if(showGraphics == false)
			return;
		
        if(anInt1237 != 0)
        {
            aClass26_Sub1_1195.method433();
            method79("Oh dear! You are dead...", anInt1246 / 2, anInt1247 / 2, 7, 0xff0000);
            method71();
            aClass26_Sub1_1195.method423(aGraphics1206, 0, 0);
            return;
        }
        if(aBoolean1289)
        {
            /*boolean flag = true;
            aClass26_Sub1_1195.method433();
            if(Math.random() < 0.14999999999999999D)
                method79("ZZZ", 10 + aRandom1298.nextInt(anInt1246 / 2 - 85), 10 + aRandom1298.nextInt(anInt1247 - 20), 5, aRandom1298.nextInt());
            if(Math.random() < 0.14999999999999999D)
                method79("ZZZ", anInt1246 / 2 + 75 + aRandom1298.nextInt(anInt1246 / 2 - 85), 10 + aRandom1298.nextInt(anInt1247 - 20), 5, aRandom1298.nextInt());
            method79(aString39, anInt1246 / 2, 80, 7, 0xffff00);
            method79("Type in the characters you see below", anInt1246 / 2, anInt1247 / 2 - 52, 5, 0xffffff);
            method79(super.aString38 + "*", anInt1246 / 2, anInt1247 / 2 + 50, 5, 0xff0000);
            if(aString1290 != null)
            {
                method79(aString1290, anInt1246 / 2, anInt1247 / 2, 5, 0xff0000);
                flag = false;
            }
            method71();
            aClass26_Sub1_1195.method423(aGraphics1206, 0, 0);
            if(flag)
                aClass26_Sub1_1195.method437(anInt1246 / 2 - 125, anInt1247 / 2 - 40, aClass16_1259);
            return;*/
        }
        if(aBoolean1055)
        {
            method72();
            return;
        }
        if(!aClass17_1170.aBoolean122)
            return;
		
        for(int i = 0; i < 64; i++)
        {
            aClass42_1199.method585(aClass17_1170.aClass32ArrayArray134[anInt1008][i]);
            if(anInt1008 == 0)
            {
                aClass42_1199.method585(aClass17_1170.aClass32ArrayArray130[1][i]);
                aClass42_1199.method585(aClass17_1170.aClass32ArrayArray134[1][i]);
                aClass42_1199.method585(aClass17_1170.aClass32ArrayArray130[2][i]);
                aClass42_1199.method585(aClass17_1170.aClass32ArrayArray134[2][i]);
            }
            aBoolean1187 = true;
            if(anInt1008 != 0 || (aClass17_1170.anIntArrayArray121[aClass31_1156.anInt298 / 128][aClass31_1156.anInt299 / 128] & 0x80) != 0)
                continue;
            if(aBoolean1282)
            {
                aClass42_1199.method584(aClass17_1170.aClass32ArrayArray134[anInt1008][i]);
                if(anInt1008 == 0)
                {
                    aClass42_1199.method584(aClass17_1170.aClass32ArrayArray130[1][i]);
                    aClass42_1199.method584(aClass17_1170.aClass32ArrayArray134[1][i]);
                    aClass42_1199.method584(aClass17_1170.aClass32ArrayArray130[2][i]);
                    aClass42_1199.method584(aClass17_1170.aClass32ArrayArray134[2][i]);
                }
            }
            aBoolean1187 = false;
        }

        if(anInt1164 != anInt1038)
        {
            anInt1038 = anInt1164;
            for(int j = 0; j < anInt1242; j++)
            {
                if(anIntArray1152[j] == 97)
                    method122(j, (new StringBuilder()).append("firea").append(anInt1164 + 1).toString());
                if(anIntArray1152[j] == 274)
                    method122(j, (new StringBuilder()).append("fireplacea").append(anInt1164 + 1).toString());
                if(anIntArray1152[j] == 1031)
                    method122(j, (new StringBuilder()).append("lightning").append(anInt1164 + 1).toString());
                if(anIntArray1152[j] == 1036)
                    method122(j, (new StringBuilder()).append("firespell").append(anInt1164 + 1).toString());
                if(anIntArray1152[j] == 1147)
                    method122(j, (new StringBuilder()).append("spellcharge").append(anInt1164 + 1).toString());
            }

        }
        if(anInt1165 != anInt1039)
        {
            anInt1039 = anInt1165;
            for(int k = 0; k < anInt1242; k++)
            {
                if(anIntArray1152[k] == 51)
                    method122(k, (new StringBuilder()).append("torcha").append(anInt1165 + 1).toString());
                if(anIntArray1152[k] == 143)
                    method122(k, (new StringBuilder()).append("skulltorcha").append(anInt1165 + 1).toString());
            }

        }
        if(anInt1166 != anInt1040)
        {
            anInt1040 = anInt1166;
            for(int i1 = 0; i1 < anInt1242; i1++)
                if(anIntArray1152[i1] == 1142)
                    method122(i1, (new StringBuilder()).append("clawspell").append(anInt1166 + 1).toString());

        }
        aClass42_1199.method588(anInt978);
        anInt978 = 0;
        for(int j1 = 0; j1 < anInt976; j1++)
        {
            Class31 class31 = aClass31Array1171[j1];
            if(class31.anInt317 == 255)
                continue;
            int i7 = class31.anInt298;
            int i8 = class31.anInt299;
            int i9 = -aClass17_1170.method366(i7, i8);
            int l9 = aClass42_1199.method590(5000 + j1, i7, i9, i8, 145, 220, j1 + 10000);
            anInt978++;
            if(class31 == aClass31_1156)
                aClass42_1199.method591(l9);
            if(class31.anInt301 == 8)
                aClass42_1199.method592(l9, -30);
            if(class31.anInt301 == 9)
                aClass42_1199.method592(l9, 30);
        }

        for(int k1 = 0; k1 < anInt976; k1++)
        {
            Class31 class31_1 = aClass31Array1171[k1];
            if(class31_1.anInt325 <= 0)
                continue;
            Class31 class31_3 = null;
            if(class31_1.anInt321 != -1)
                class31_3 = aClass31Array1191[class31_1.anInt321];
            else
            if(class31_1.anInt320 != -1)
                class31_3 = aClass31Array999[class31_1.anInt320];
            if(class31_3 != null)
            {
                int j8 = class31_1.anInt298;
                int j9 = class31_1.anInt299;
                int i10 = -aClass17_1170.method366(j8, j9) - 110;
                int k10 = class31_3.anInt298;
                int l10 = class31_3.anInt299;
                int i11 = -aClass17_1170.method366(k10, l10) - Class3.method235(class31_3.anInt310).method314() / 2;
                int j11 = (j8 * class31_1.anInt325 + k10 * (anInt1213 - class31_1.anInt325)) / anInt1213;
                int k11 = (i10 * class31_1.anInt325 + i11 * (anInt1213 - class31_1.anInt325)) / anInt1213;
                int l11 = (j9 * class31_1.anInt325 + l10 * (anInt1213 - class31_1.anInt325)) / anInt1213;
                aClass42_1199.method590(3160 + class31_1.anInt319, j11, k11, l11, 32, 32, 0);
                anInt978++;
            }
        }

        if(aClass17_1170.aBoolean123)
        {
            super.aClass33_Sub1_767.method558(74);
            super.aClass33_Sub1_767.method554(aClass17_1170.aString124.getBytes(), 0, aClass17_1170.aString124.getBytes().length);
            super.aClass33_Sub1_767.method541();
            aClass17_1170.aBoolean123 = false;
        }
        for(int l1 = 0; l1 < anInt1003; l1++)
        {
            Class31 class31_2 = aClass31Array991[l1];
            int j7 = class31_2.anInt298;
            int k8 = class31_2.anInt299;
            int k9 = -aClass17_1170.method366(j7, k8);
            int j10 = aClass42_1199.method590(20000 + l1, j7, k9, k8, Class3.method235(class31_2.anInt310).method313(), Class3.method235(class31_2.anInt310).method314(), l1 + 30000);
            anInt978++;
            if(class31_2.anInt301 == 8)
                aClass42_1199.method592(j10, -30);
            if(class31_2.anInt301 == 9)
                aClass42_1199.method592(j10, 30);
        }

        for(int i2 = 0; i2 < anInt1163; i2++)
        {
            int l4 = anIntArray1227[i2] * 128 + 64;
            int k7 = anIntArray1229[i2] * 128 + 64;
            aClass42_1199.method590(40000 + anIntArray1230[i2], l4, -aClass17_1170.method366(l4, k7) - anIntArray1231[i2], k7, 96, 64, i2 + 20000);
            anInt978++;
        }

        for(int j2 = 0; j2 < anInt1169; j2++)
        {
            int i5 = anIntArray1215[j2] * 128 + 64;
            int l7 = anIntArray1053[j2] * 128 + 64;
            int l8 = anIntArray1068[j2];
            if(l8 == 0)
            {
                aClass42_1199.method590(50000 + j2, i5, -aClass17_1170.method366(i5, l7), l7, 128, 256, j2 + 50000);
                anInt978++;
            }
            if(l8 == 1)
            {
                aClass42_1199.method590(50000 + j2, i5, -aClass17_1170.method366(i5, l7), l7, 128, 64, j2 + 50000);
                anInt978++;
            }
        }

        aClass26_Sub1_1195.aBoolean181 = false;
        aClass26_Sub1_1195.method424();
        aClass26_Sub1_1195.aBoolean181 = super.aBoolean37;
        if(anInt1008 == 3)
        {
            int k2 = 40 + (int)(Math.random() * 3D);
            int j5 = 40 + (int)(Math.random() * 7D);
            aClass42_1199.method627(k2, j5, -50, -10, -50);
        }
        anInt995 = 0;
        anInt983 = 0;
        anInt1014 = 0;
        if(aBoolean1190)
        {
            if(aBoolean960 && !aBoolean1187)
            {
                int l2 = anInt1016;
                method62();
                if(anInt1016 != l2)
                {
                    anInt1147 = aClass31_1156.anInt298;
                    anInt1148 = aClass31_1156.anInt299;
                }
            }
            aClass42_1199.anInt459 = 3000;
            aClass42_1199.anInt460 = 3000;
            aClass42_1199.anInt461 = 1;
            aClass42_1199.anInt462 = 2800;
            anInt1085 = anInt1016 * 32;
            int i3 = anInt1147 + anInt1023;
            int k5 = anInt1148 + anInt1181;
            aClass42_1199.method614(i3, -aClass17_1170.method366(i3, k5), k5, 912, anInt1085 * 4, 0, 2000);
        } else
        {
            if(aBoolean960 && !aBoolean1187)
                method62();
            if(!super.aBoolean37)
            {
                aClass42_1199.anInt459 = 50000;
                aClass42_1199.anInt460 = 50000;
                aClass42_1199.anInt461 = 1;
                aClass42_1199.anInt462 = 50000;
            } else
            {
                aClass42_1199.anInt459 = 50000;
                aClass42_1199.anInt460 = 50000;
                aClass42_1199.anInt461 = 1;
                aClass42_1199.anInt462 = 50000;
            }
            int j3 = anInt1147 + anInt1023;
            int l5 = anInt1148 + anInt1181;
            aClass42_1199.method614(j3, -aClass17_1170.method366(j3, l5), l5, 912, anInt1085 * 4, 0, anInt1176 * 2);
        }
        aClass42_1199.method602();
        method147();
        if(anInt1114 > 0)
            aClass26_Sub1_1195.method438(anInt1115 - 8, anInt1116 - 8, 2014 + (24 - anInt1114) / 6);
        if(anInt1114 < 0)
            aClass26_Sub1_1195.method438(anInt1115 - 8, anInt1116 - 8, 2018 + (24 + anInt1114) / 6);
        if(anInt1084 != 0)
        {
            int k3 = anInt1084 / 50;
            int i6 = k3 / 60;
            k3 %= 60;
            if(k3 < 10)
            {
                if(aByte1268 == 0)
                    method79((new StringBuilder()).append("Wilderness switching to F2P in:").append(i6).append(":0").append(k3).toString(), anInt1291 / 2, anInt1247 - 7, 1, 0xffff00);
                else
                    method79((new StringBuilder()).append("Wilderness switching to P2P in:").append(i6).append(":0").append(k3).toString(), anInt1291 / 2, anInt1247 - 7, 1, 0xffff00);
            } else
            if(aByte1268 == 0)
                method79((new StringBuilder()).append("Wilderness switching to F2P in:").append(i6).append(":").append(k3).toString(), anInt1291 / 2, anInt1247 - 7, 1, 0xffff00);
            else
                method79((new StringBuilder()).append("Wilderness switching to P2P in:").append(i6).append(":").append(k3).toString(), anInt1291 / 2, anInt1247 - 7, 1, 0xffff00);
        }
        if(anInt1083 != 0)
        {
            int l3 = anInt1083 / 50;
            int j6 = l3 / 60;
            l3 %= 60;
            if(l3 < 10)
                method79((new StringBuilder()).append("Shutting down in: ").append(j6).append(":0").append(l3).toString(), anInt1291 / 2, anInt1247 - 7, 1, 0xffff00);
            else
                method79((new StringBuilder()).append("Shutting down in: ").append(j6).append(":").append(l3).toString(), anInt1291 / 2, anInt1247 - 7, 1, 0xffff00);
        }
		if(aBoolean1289) {
            aClass26_Sub1_1195.method458("Sleeping...", anInt1246 / 2, 80, 7, 0xffff00);
            aClass26_Sub1_1195.method458("if this appears for a while", anInt1246 / 2, 100, 4, 0xffff00);
            aClass26_Sub1_1195.method458("input the word manually from", anInt1246 / 2, 115, 4, 0xffff00);
            aClass26_Sub1_1195.method458("media/" + aClass31_1156.aString294 + "/sleepword.png", anInt1246 / 2, 130, 4, 0xffff00);
            aClass26_Sub1_1195.method458(aString39, anInt1246 / 2, 145, 7, 0xffff00);
			//aClass26_Sub1_1195.method437(anInt1246 / 2 - 125, anInt1247 / 2 - 40, aClass16_1259);
		}
        if(aBoolean1287) {
            int yPos = 100;
            method80("@gre@Hits: @whi@" + anIntArray1034[3] + "@gre@/@whi@" + anIntArray1112[3], 6, yPos, 1, 0xffff00);
            yPos += 12;
            String s = "@yel@";
            if(aLong1276 <= 100L)
                s = "@red@";
            if(aLong1276 < 98L)
                s = "@or3@";
            if(aLong1276 < 96L)
                s = "@or2@";
            if(aLong1276 < 94L)
                s = "@ora@";
            if(aLong1276 < 92L)
                s = "@yel@";
            if(aLong1276 < 90L)
                s = "@gr3@";
            if(aLong1276 < 88L)
                s = "@gr2@";
            if(aLong1276 < 86L)
                s = "@gre@";
            method80("@gre@Fatigue: " + s + aLong1276 + "%", 6, yPos, 1, 0xffff00);
			if(methods != null)
				methods.drawInfo(6, yPos + 12);
        }
		
		int mouseX = super.anInt31;
		int mouseY = super.anInt32;
		if(mouseX >= 0 && mouseX <= anInt1291 && mouseY >= 0 && mouseY <= anInt1292) {
			aClass26_Sub1_1195.method430(mouseX - 5, mouseY, 10, 0);
			aClass26_Sub1_1195.method431(mouseX, mouseY - 5, 10, 0);
		}
	
        if(!aBoolean1179)
        {
            int j4 = 2203 - (anInt1158 + anInt1006 + anInt1036);
            if(anInt1157 + anInt1005 + anInt1035 >= 2640)
                j4 = -50;
            if(j4 > 0)
            {
                int k6 = 1 + j4 / 6;
                aClass26_Sub1_1195.method438(anInt1246 - 58, anInt1247 - 58, 2013);
                method79("Wilderness", anInt1246 - 47, anInt1247 - 20, 1, 0xffff00);
                method79((new StringBuilder()).append("Level: ").append(k6).toString(), anInt1246 - 47, anInt1247 - 7, 1, 0xffff00);
                if(anInt1209 == 0)
                    anInt1209 = 2;
            } else
            if(anInt1157 + anInt1035 >= 650 && anInt1157 + anInt1035 <= 700 && anInt1158 + anInt1036 >= 3475 && anInt1158 + anInt1036 <= 3500)
            {
                int l6 = 1 + j4 / 6;
                l6 = 150;
                aClass26_Sub1_1195.method438(anInt1246 - 58, anInt1247 - 58, 2013);
                method79("Wilderness", anInt1246 - 47, anInt1247 - 20, 1, 0xffff00);
                method79((new StringBuilder()).append("Level: ").append(l6).toString(), anInt1246 - 47, anInt1247 - 7, 1, 0xffff00);
                if(anInt1209 == 0)
                    anInt1209 = 2;
            }
            if(anInt1209 == 0 && j4 > -10 && j4 <= 0)
                anInt1209 = 1;
        }
        method135();
        if(anInt1092 == 0)
        {
            for(int k4 = 0; k4 < 5; k4++)
                if(anIntArray1146[k4] > 0)
                {
                    String s1 = aStringArray1234[k4];
                    method80(s1, 7, anInt1247 - 18 - k4 * 12, 1, 0xffff00);
                }

        }
        aClass30_1087.method505(anInt1088);
        aClass30_1087.method505(anInt1090);
        aClass30_1087.method505(anInt1091);
        if(anInt1092 == 1)
            aClass30_1087.method504(anInt1088);
        else
        if(anInt1092 == 2)
            aClass30_1087.method504(anInt1090);
        else
        if(anInt1092 == 3)
            aClass30_1087.method504(anInt1091);
        Class30.anInt291 = 2;
        aClass30_1087.method475();
        Class30.anInt291 = 0;
        aClass26_Sub1_1195.method440(((Class26) (aClass26_Sub1_1195)).anInt169 - 3 - 197, 3, 2000, 128);
        method138();
        aClass26_Sub1_1195.aBoolean184 = false;
        method71();
        aClass26_Sub1_1195.method423(aGraphics1206, 0, 0);
    }
}
