// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Applet_Sub1_Sub1.java

package pack5.pack6.pack7;

import java.awt.*;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigInteger;
import pack1.Class13;
import pack10.Class2;

// Referenced classes of package pack5.pack6.pack7:
//            Applet_Sub1, Class33_Sub1, Class22, Class35

public abstract class Applet_Sub1_Sub1 extends Applet_Sub1
{

    public void method26(String s, String s1, boolean flag)
    {
		System.out.println("logging in");
        if(anInt784 > 0)
        {
            method39("Connecting to server...", "");
            try
            {
                Thread.sleep(2000L);
            }
            catch(Exception exception) { }
            method39("RSCEmulation is currently full. Please try again later.", "");
            return;
        }
        aString765 = s;
        s = Class35.method567(s, 20);
        aString766 = s1;
        s1 = Class35.method567(s1, 20);
        if(s.trim().length() == 0)
        {
            method39("Both username and password are required.", "");
            return;
        }
        long l1;
        if(flag)
            method28("Connection lost!", "Attempting to re-establish...");
        else
            method39("Connecting to server...", "");
        aClass33_Sub1_767 = new Class33_Sub1(method24(aString763, anInt785), this);
        aClass33_Sub1_767.anInt411 = anInt762;
        long l = Class35.method568(s);
        aClass33_Sub1_767.method558(2);
        aClass33_Sub1_767.method542((int)(l >> 16 & 31L));
        aClass33_Sub1_767.method556(new String(aByteArray764));
        aClass33_Sub1_767.method551();
        l1 = aClass33_Sub1_767.method552();
        if(l1 == 0L)
        {
            method39("Login server offline.", "Please try again soon.");
            return;
        }
        try
        {
            System.out.print("Session ID: " + l1);
            int ai[] = new int[4];
            ai[0] = (int)(Math.random() * 99999999D);
            ai[1] = (int)(Math.random() * 99999999D);
            ai[2] = (int)(l1 >> 32);
            ai[3] = (int)l1;
            Class22 class22 = new Class22(new byte[500]);
            class22.anInt161 = 0;
            class22.method401(ai[0]);
            class22.method401(ai[1]);
            class22.method401(ai[2]);
            class22.method401(ai[3]);
            class22.method401(anInt786);
            class22.method402(s);
            class22.method402(s1);
            class22.method405(aBigInteger782, aBigInteger783);
            aClass33_Sub1_767.method558(75);
            if(flag)
                aClass33_Sub1_767.method542(1);
            else
                aClass33_Sub1_767.method542(0);
            aClass33_Sub1_767.method546(anInt761);
            aClass33_Sub1_767.method554(class22.aByteArray160, 0, class22.anInt161);
            aClass33_Sub1_767.method551();
            int i = aClass33_Sub1_767.method559();
            System.out.println(" - Login Response: " + i);
            if(i == 99)
            {
                anInt769 = 0;
                method40();
            } else
            if(i == 0)
            {
                anInt769 = 0;
                method40();
            } else
            if(i == 1)
                anInt769 = 0;
            else
            if(flag)
                method41();
            else
            if(i == -1)
                method39("Unable to contact server.", "Please try again soon.");
            else
            if(i == 2)
                method39("Invalid username or password.", "Try again or create a new character.");
            else
            if(i == 3)
                method39("Character already logged in.", "Please try again soon.");
            else
            if(i == 4)
                method39("The client has been updated.", "Please reload the client to auto-update.");
            else
            if(i == 5)
                method39("Error unable to login.", "Server rejected session");
            else
            if(i == 6)
                method39("Character banned.", "Please post a topic in Offence Appeal");
            else
            if(i == 7)
                method39("Failed to decode character.", "Please post a topic in Support");
            else
            if(i == 8)
                method39("IP in use.", "You may only login one character at a time.");
            else
            if(i == 9)
                method39("Character already logged in.", "Please try again soon.");
            else
            if(i == 10)
                method39("RSCEmulation is currently full. Please try again later.", "");
            else
            if(i == 11)
                method39("Character banned.", "Please post a topic in Offence Appeal");
            else
            if(i == 12)
                method39("IP banned.", "Please post a topic in Offence Appeal");
            else
            if(i == 13)
                method39("Client dimensions are too large.", "Please subscribe if you want a larger client.");
            else
                method39("Error unable to login.", "Unrecognised response code.");
        }
        catch(Exception exception1)
        {
            method39("Unable to establish a connection with the server.", "");
        }
        return;
    }

    public void method27()
    {
        method41();
    }

    public void method28(String s, String s1)
    {
        Graphics g = getGraphics();
        Font font = new Font("Helvetica", 1, 15);
        char c = '\u0200';
        char c1 = '\u0158';
        g.setColor(Color.black);
        g.fillRect(anInt786 / 2 - 140, anInt787 / 2 - 25, 280, 50);
        g.setColor(Color.white);
        g.drawRect(anInt786 / 2 - 140, anInt787 / 2 - 25, 280, 50);
        method22(g, s, font, anInt786 / 2, anInt787 / 2 - 10);
        method22(g, s1, font, anInt786 / 2, anInt787 / 2 + 10);
    }

    public void method29() {
        long l = System.currentTimeMillis();
        if(aClass33_Sub1_767.method545())
            aLong770 = l;
        if(l - aLong770 > 5000L) {
            aLong770 = l;
            aClass33_Sub1_767.method558(5);
            aClass33_Sub1_767.method541();
        }
        try {
            aClass33_Sub1_767.method555(20);
        }
        catch(Exception exception) {
            System.out.println("Connection lost");
            method27();
            return;
        }
        int i = aClass33_Sub1_767.method548(aByteArray768);
        if(i > 0)
            method30(aByteArray768[0] & 0xff, i);
    }

    public void method30(int i, int j)
    {
        if(i == 48)
        {
            String s = new String(aByteArray768, 1, j - 1);
			if(mc.showGraphics == false)
				if(s.toLowerCase().contains(mc.aClass31_1156.aString294.toLowerCase()))
					System.out.println(" SERVER> " + s);
            method44(s);
        }
        if(i == 136)
        {
            method42();
            return;
        }
        if(i == 249)
        {
            anInt772 = Class35.method560(aByteArray768[1]);
            for(int k = 0; k < anInt772; k++)
            {
                aLongArray773[k] = Class35.method563(aByteArray768, 2 + k * 9);
                anIntArray774[k] = Class35.method560(aByteArray768[10 + k * 9]);
            }

            method31();
            return;
        }
        if(i == 25)
        {
            long l = Class35.method563(aByteArray768, 1);
            int j1 = aByteArray768[9] & 0xff;
            for(int k1 = 0; k1 < anInt772; k1++)
                if(aLongArray773[k1] == l)
                {
                    if(anIntArray774[k1] == 0 && j1 != 0)
                        method44("@pri@@cya@" + Class35.method569(l) + " has logged in");
                    if(anIntArray774[k1] != 0 && j1 == 0)
                        method44("@pri@@cya@" + Class35.method569(l) + " has logged out");
                    anIntArray774[k1] = j1;
                    j = 0;
                    method31();
                    return;
                }

            aLongArray773[anInt772] = l;
            anIntArray774[anInt772] = j1;
            anInt772++;
            method31();
            return;
        }
        if(i == 2)
        {
            anInt775 = Class35.method560(aByteArray768[1]);
            for(int i1 = 0; i1 < anInt775; i1++)
                aLongArray776[i1] = Class35.method563(aByteArray768, 2 + i1 * 8);

            return;
        }
        if(i == 158)
        {
            aBoolean777 = (aByteArray768[1] & 1) != 0;
            aBoolean779 = (aByteArray768[1] & 2) != 0;
            aBoolean780 = (aByteArray768[1] & 4) != 0;
            aBoolean781 = (aByteArray768[1] & 8) != 0;
            aBoolean778 = (aByteArray768[1] & 0x10) != 0;
            return;
        }
        else
        {
            method43(i, j, aByteArray768);
            return;
        }
    }

    public void method31() {
		boolean flag = true;
		while(flag) {
			flag = false;
			for(int i = 0; i < anInt772 - 1; i++)
				if(anIntArray774[i] < anIntArray774[i + 1]) {
                    int j = anIntArray774[i];
                    anIntArray774[i] = anIntArray774[i + 1];
                    anIntArray774[i + 1] = j;
                    long l = aLongArray773[i];
                    aLongArray773[i] = aLongArray773[i + 1];
                    aLongArray773[i + 1] = l;
                    flag = true;
				}
		}
    }

    public void method32(String s)
    {
        long l = Class35.method568(s);
        aClass33_Sub1_767.method558(46);
        aClass33_Sub1_767.method543(l);
        aClass33_Sub1_767.method541();
        for(int i = 0; i < anInt775; i++)
            if(aLongArray776[i] == l)
                return;

        if(anInt775 >= aLongArray776.length - 1)
        {
            return;
        } else
        {
            aLongArray776[anInt775++] = l;
            return;
        }
    }

    public void method33(long l)
    {
        aClass33_Sub1_767.method558(47);
        aClass33_Sub1_767.method543(l);
        aClass33_Sub1_767.method541();
        for(int i = 0; i < anInt775; i++)
            if(aLongArray776[i] == l)
            {
                anInt775--;
                for(int j = i; j < anInt775; j++)
                    aLongArray776[j] = aLongArray776[j + 1];

                return;
            }

    }

    public void method34(String s)
    {
        aClass33_Sub1_767.method558(44);
        aClass33_Sub1_767.method543(Class35.method568(s));
        aClass33_Sub1_767.method541();
        long l = Class35.method568(s);
        for(int i = 0; i < anInt772; i++)
            if(aLongArray773[i] == l)
                return;

        if(anInt772 >= aLongArray773.length - 1)
        {
            return;
        } else
        {
            aLongArray773[anInt772] = l;
            anIntArray774[anInt772] = 0;
            anInt772++;
            return;
        }
    }

    public void method35(long l)
    {
        aClass33_Sub1_767.method558(45);
        aClass33_Sub1_767.method543(l);
        aClass33_Sub1_767.method541();
		for(int i = 0; i < anInt772; i++) {
			if(aLongArray773[i] != l)
				continue;
			anInt772 --;
			for(int j = i; j < anInt772; j++) {
				aLongArray773[j] = aLongArray773[j + 1];
				anIntArray774[j] = anIntArray774[j + 1];
			}
			break;
		}
        method44("@pri@@cya@" + Class35.method569(l) + " has been removed from your friends list");
    }

    public void method36(long l, byte abyte0[], int i)
    {
        aClass33_Sub1_767.method558(48);
        aClass33_Sub1_767.method543(l);
        aClass33_Sub1_767.method554(abyte0, 0, i);
        aClass33_Sub1_767.method541();
    }

    public void method37(byte abyte0[], int i)
    {
        aClass33_Sub1_767.method558(9);
        aClass33_Sub1_767.method554(abyte0, 0, i);
        aClass33_Sub1_767.method541();
    }

    public void method38(String s)
    {
        aClass33_Sub1_767.method558(12);
        aClass33_Sub1_767.method556(s);
        aClass33_Sub1_767.method541();
    }

    public abstract void method39(String s, String s1);

    public abstract void method40();

    public abstract void method41();

    public abstract void method42();

    public abstract void method43(int i, int j, byte abyte0[]);

    public abstract void method44(String s);

    public Applet_Sub1_Sub1()
    {
        aString765 = "";
        aString766 = "";
        aByteArray768 = new byte[10000];
        aLongArray773 = new long[400];
        anIntArray774 = new int[400];
        aLongArray776 = new long[200];
    }

    public static int anInt761 = 60;
    public static int anInt762;
    public static String aString763;
    public byte aByteArray764[] = {
        82, 83, 67, 69
    };
    public String aString765;
    public String aString766;
    public Class33_Sub1 aClass33_Sub1_767;
    public byte aByteArray768[];
    public int anInt769;
    public long aLong770;
    public long aLong771;
    public int anInt772;
    public long aLongArray773[];
    public int anIntArray774[];
    public int anInt775;
    public long aLongArray776[];
    public boolean aBoolean777;
    public boolean aBoolean778;
    public boolean aBoolean779;
    public boolean aBoolean780;
    public boolean aBoolean781;
    public static BigInteger aBigInteger782 = new BigInteger("1370158896620336158431733257575682136836100155721926632321599369132092701295540721504104229217666225601026879393318399391095704223500673696914052239029335");
    public static BigInteger aBigInteger783 = new BigInteger("1549611057746979844352781944553705273443228154042066840514290174539588436243191882510185738846985723357723362764835928526260868977814405651690121789896823");
    public int anInt784;
    public static int anInt785;
    public static int anInt786;
    public static int anInt787;
	
	public static bot.Client mc;
}
