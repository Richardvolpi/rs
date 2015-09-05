// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 

import java.awt.*;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigInteger;

public class Applet_Sub1_Sub1 extends Applet_Sub1
{

    public Applet_Sub1_Sub1()
    {
        aString616 = "uk1.runescape.com";
        anInt617 = 43594;
        aString618 = "";
        aString619 = "";
        aByteArray621 = new byte[5000];
        aLongArray625 = new long[200];
        anIntArray626 = new int[200];
        aLongArray628 = new long[50];
        anIntArray639 = new int[100];
    }

    protected final void method21(String s, String s1, boolean flag)
    {
        int k = Class1.anInt144;
        if(anInt636 > 0)
        {
            method36("Please wait...", "Connecting to server");
            try
            {
                Thread.sleep(2000L);
            }
            catch(Exception _ex) { }
            method36("Sorry! The server is currently full.", "Please try again later");
            return;
        }
        try
        {
            aString618 = s;
            s = Class15.method360(s, 20);
            aString619 = s1;
            s1 = Class15.method360(s1, 20);
            if(s.trim().length() == 0)
            {
                method36("You must enter both a username", "and a password - Please try again");
                return;
            }
            if(flag)
                method24("Connection lost! Please wait...", "Attempting to re-establish");
            else
                method36("Please wait...", "Connecting to server");
            aClass14_Sub1_620 = new Class14_Sub1(method19(aString616, anInt617), this);
            aClass14_Sub1_620.anInt526 = anInt615;
            long l = Class15.method362(s);
            aClass14_Sub1_620.method331(32);
            aClass14_Sub1_620.method348((int)(l >> 16 & 31L));
            aClass14_Sub1_620.method344();
            long l1 = aClass14_Sub1_620.method333();
            aLong635 = l1;
            if(l1 == 0L)
            {
                method36("Login server offline.", "Please try again in a few mins");
                return;
            }
            System.out.println("Verb: Session id: " + l1);
            int i = 0;
            try
            {
                if(method7())
                {
                    String s2 = getParameter("limit30");
                    if(s2.equals("1"))
                        i = 1;
                }
            }
            catch(Exception _ex) { }
            int ai[] = new int[4];
            ai[0] = (int)(Math.random() * 99999999D);
            ai[1] = (int)(Math.random() * 99999999D);
            ai[2] = (int)(l1 >> 32);
            ai[3] = (int)l1;
            Class13 class13 = new Class13(new byte[500]);
            class13.anInt521 = 0;
            class13.method319(10);
            class13.method320(ai[0]);
            class13.method320(ai[1]);
            class13.method320(ai[2]);
            class13.method320(ai[3]);
            class13.method320(method44());
            class13.method321(s);
            class13.method321(s1);
            class13.method327(aBigInteger633, aBigInteger634);
            aClass14_Sub1_620.method331(0);
            if(flag)
                aClass14_Sub1_620.method348(1);
            else
                aClass14_Sub1_620.method348(0);
            aClass14_Sub1_620.method343(anInt614);
            aClass14_Sub1_620.method348(i);
            aClass14_Sub1_620.method336(class13.aByteArray520, 0, class13.anInt521);
            aClass14_Sub1_620.method344();
            aClass14_Sub1_620.method328(ai);
            int j = aClass14_Sub1_620.method338();
            System.out.println("login response:" + j);
            if(j == 25)
            {
                anInt637 = 1;
                anInt622 = 0;
                method38();
                return;
            }
            if(j == 0)
            {
                anInt637 = 0;
                anInt622 = 0;
                method38();
                return;
            }
            if(j == 1)
            {
                anInt622 = 0;
                method37();
                return;
            }
            if(flag)
            {
                s = "";
                s1 = "";
                method39();
                return;
            }
            if(j == -1)
            {
                method36("Error unable to login.", "Server timed out");
                return;
            }
            if(j == 3)
            {
                method36("Invalid username or password.", "Try again, or create a new account");
                return;
            }
            if(j == 4)
            {
                method36("That username is already logged in.", "Wait 60 seconds then retry");
                return;
            }
            if(j == 5)
            {
                method36("The client has been updated.", "Please reload this page");
                return;
            }
            if(j == 6)
            {
                method36("You may only use 1 character at once.", "Your ip-address is already in use");
                return;
            }
            if(j == 7)
            {
                method36("Login attempts exceeded!", "Please try again in 5 minutes");
                return;
            }
            if(j == 8)
            {
                method36("Error unable to login.", "Server rejected session");
                return;
            }
            if(j == 9)
            {
                method36("Error unable to login.", "Loginserver rejected session");
                return;
            }
            if(j == 10)
            {
                method36("That username is already in use.", "Wait 60 seconds then retry");
                return;
            }
            if(j == 11)
            {
                method36("Account temporarily disabled.", "Check your message inbox for details");
                return;
            }
            if(j == 12)
            {
                method36("Account permanently disabled.", "Check your message inbox for details");
                return;
            }
            if(j == 14)
            {
                method36("Sorry! This world is currently full.", "Please try a different world");
                anInt636 = 1500;
                return;
            }
            if(j == 15)
            {
                method36("You need a members account", "to login to this world");
                return;
            }
            if(j == 16)
            {
                method36("Error - no reply from loginserver.", "Please try again");
                return;
            }
            if(j == 17)
            {
                method36("Error - failed to decode profile.", "Contact customer support");
                return;
            }
            if(j == 20)
            {
                method36("Error - loginserver mismatch", "Please try a different world");
                return;
            } else
            {
                method36("Error unable to login.", "Unrecognised response code");
                return;
            }
        }
        catch(Exception exception)
        {
            System.out.println(String.valueOf(exception));
        }
        if(anInt622 > 0)
        {
            try
            {
                Thread.sleep(5000L);
            }
            catch(Exception _ex) { }
            anInt622--;
            method21(aString618, aString619, flag);
        }
        if(flag)
        {
            aString618 = "";
            aString619 = "";
            method39();
        } else
        {
            method36("Sorry! Unable to connect.", "Check internet settings or try another world");
        }
    }

    protected final void method22()
    {
        if(aClass14_Sub1_620 != null)
            try
            {
                aClass14_Sub1_620.method331(190);
                aClass14_Sub1_620.method344();
            }
            catch(IOException _ex) { }
        aString618 = "";
        aString619 = "";
        method39();
    }

    protected void method23()
    {
        System.out.println("Lost connection");
        anInt622 = 10;
        method21(aString618, aString619, true);
    }

    protected final void method24(String s, String s1)
    {
        Graphics g = getGraphics();
        Font font = new Font("Helvetica", 1, 15);
        char c = '\u0200';
        char c1 = '\u0158';
        g.setColor(Color.black);
        g.fillRect(c / 2 - 140, c1 / 2 - 25, 280, 50);
        g.setColor(Color.white);
        g.drawRect(c / 2 - 140, c1 / 2 - 25, 280, 50);
        method16(g, s, font, c / 2, c1 / 2 - 10);
        method16(g, s1, font, c / 2, c1 / 2 + 10);
    }

    protected final void method25()
    {
        long l = System.currentTimeMillis();
        if(aClass14_Sub1_620.method335())
            aLong623 = l;
        if(l - aLong623 > 5000L)
        {
            aLong623 = l;
            aClass14_Sub1_620.method331(76);
            aClass14_Sub1_620.method346();
        }
        try
        {
            aClass14_Sub1_620.method341(20);
        }
        catch(IOException _ex)
        {
            method23();
            return;
        }
        if(!method43())
            return;
        int i = aClass14_Sub1_620.method334(aByteArray621);
        if(i > 0)
            method26(aByteArray621[0] & 0xff, i);
    }

    private final void method26(int i, int j)
    {
        int k2 = Class1.anInt144;
        i = aClass14_Sub1_620.method340(i);
        if(i == 202)
        {
            String s = new String(aByteArray621, 1, j - 1);
            method42(s);
        }
        if(i == 178)
            method22();
        if(i == 11)
        {
            method40();
            return;
        }
        if(i == 174)
        {
            anInt624 = Class15.method353(aByteArray621[1]);
            for(int k = 0; k < anInt624; k++)
            {
                aLongArray625[k] = Class15.method356(aByteArray621, 2 + k * 9);
                anIntArray626[k] = Class15.method353(aByteArray621[10 + k * 9]);
            }

            method27();
            return;
        }
        if(i == 101)
        {
            long l = Class15.method356(aByteArray621, 1);
            int j1 = aByteArray621[9] & 0xff;
            for(int i2 = 0; i2 < anInt624; i2++)
                if(aLongArray625[i2] == l)
                {
                    if(anIntArray626[i2] == 0 && j1 != 0)
                        method42("@pri@" + Class15.method363(l) + " has logged in");
                    if(anIntArray626[i2] != 0 && j1 == 0)
                        method42("@pri@" + Class15.method363(l) + " has logged out");
                    anIntArray626[i2] = j1;
                    j = 0;
                    method27();
                    return;
                }

            aLongArray625[anInt624] = l;
            anIntArray626[anInt624] = j1;
            anInt624++;
            method27();
            return;
        }
        if(i == 144)
        {
            anInt627 = Class15.method353(aByteArray621[1]);
            for(int i1 = 0; i1 < anInt627; i1++)
                aLongArray628[i1] = Class15.method356(aByteArray621, 2 + i1 * 8);

            return;
        }
        if(i == 148)
        {
            anInt629 = aByteArray621[1];
            anInt630 = aByteArray621[2];
            anInt631 = aByteArray621[3];
            anInt632 = aByteArray621[4];
            return;
        }
        if(i == 193)
        {
            long l1 = Class15.method356(aByteArray621, 1);
            int k1 = Class15.method355(aByteArray621, 9);
            for(int j2 = 0; j2 < 100; j2++)
                if(anIntArray639[j2] == k1)
                    return;

            anIntArray639[anInt640] = k1;
            anInt640 = (anInt640 + 1) % 100;
            String s1 = Class16.method374(Class17.method399(aByteArray621, 13, j - 13));
            method42("@pri@" + Class15.method363(l1) + ": tells you " + s1);
            return;
        } else
        {
            method41(i, j, aByteArray621);
            return;
        }
    }

    private final void method27()
    {
        int k = Class1.anInt144;
        boolean flag = true;
        while(flag) 
        {
            flag = false;
            for(int i = 0; i < anInt624 - 1; i++)
                if(anIntArray626[i] < anIntArray626[i + 1])
                {
                    int j = anIntArray626[i];
                    anIntArray626[i] = anIntArray626[i + 1];
                    anIntArray626[i + 1] = j;
                    long l = aLongArray625[i];
                    aLongArray625[i] = aLongArray625[i + 1];
                    aLongArray625[i + 1] = l;
                    flag = true;
                }

        }
    }

    protected final void method28(int i, int j, int k, int l)
    {
        aClass14_Sub1_620.method331(191);
        aClass14_Sub1_620.method348(i);
        aClass14_Sub1_620.method348(j);
        aClass14_Sub1_620.method348(k);
        aClass14_Sub1_620.method348(l);
        aClass14_Sub1_620.method346();
    }

    protected final void method29(String s)
    {
        long l = Class15.method362(s);
        aClass14_Sub1_620.method331(241);
        aClass14_Sub1_620.method342(l);
        aClass14_Sub1_620.method346();
        for(int i = 0; i < anInt627; i++)
            if(aLongArray628[i] == l)
                return;

        if(anInt627 >= 50)
        {
            return;
        } else
        {
            aLongArray628[anInt627++] = l;
            return;
        }
    }

    protected final void method30(long l)
    {
        int k = Class1.anInt144;
        aClass14_Sub1_620.method331(30);
        aClass14_Sub1_620.method342(l);
        aClass14_Sub1_620.method346();
        for(int i = 0; i < anInt627; i++)
            if(aLongArray628[i] == l)
            {
                anInt627--;
                for(int j = i; j < anInt627; j++)
                    aLongArray628[j] = aLongArray628[j + 1];

                return;
            }

    }

    protected final void method31(String s)
    {
        aClass14_Sub1_620.method331(204);
        aClass14_Sub1_620.method342(Class15.method362(s));
        aClass14_Sub1_620.method346();
        long l = Class15.method362(s);
        for(int i = 0; i < anInt624; i++)
            if(aLongArray625[i] == l)
                return;

        if(anInt624 >= 100)
        {
            return;
        } else
        {
            aLongArray625[anInt624] = l;
            anIntArray626[anInt624] = 0;
            anInt624++;
            return;
        }
    }

    protected final void method32(long l)
    {
        int k = Class1.anInt144;
        aClass14_Sub1_620.method331(179);
        aClass14_Sub1_620.method342(l);
        aClass14_Sub1_620.method346();
        for(int i = 0; i < anInt624; i++)
        {
            if(aLongArray625[i] != l)
                continue;
            anInt624--;
            for(int j = i; j < anInt624; j++)
            {
                aLongArray625[j] = aLongArray625[j + 1];
                anIntArray626[j] = anIntArray626[j + 1];
            }

            break;
        }

        method42("@pri@" + Class15.method363(l) + " has been removed from your friends list");
    }

    protected final void method33(long l, byte abyte0[], int i)
    {
        aClass14_Sub1_620.method331(225);
        aClass14_Sub1_620.method342(l);
        aClass14_Sub1_620.method336(abyte0, 0, i);
        aClass14_Sub1_620.method346();
    }

    protected final void method34(byte abyte0[], int i)
    {
        aClass14_Sub1_620.method331(40);
        aClass14_Sub1_620.method336(abyte0, 0, i);
        aClass14_Sub1_620.method346();
    }

    protected final void method35(String s)
    {
        aClass14_Sub1_620.method331(195);
        aClass14_Sub1_620.method347(s);
        aClass14_Sub1_620.method346();
    }

    protected void method36(String s, String s1)
    {
    }

    protected void method37()
    {
    }

    protected void method38()
    {
    }

    protected void method39()
    {
    }

    protected void method40()
    {
    }

    protected void method41(int i, int j, byte abyte0[])
    {
    }

    protected void method42(String s)
    {
    }

    protected boolean method43()
    {
        return true;
    }

    protected int method44()
    {
        return 0;
    }

    private static BigInteger aBigInteger633 = new BigInteger("58778699976184461502525193738213253649000149147835990136706041084440742975821");
    private static BigInteger aBigInteger634 = new BigInteger("7162900525229798032761816791230527296329313291232324290237849263501208207972894053929065636522363163621000728841182238772712427862772219676577293600221789");
    byte aByteArray621[];
    public Class14_Sub1 aClass14_Sub1_620;
    long aLong623;
    public long aLong635;
    public long aLongArray625[];
    public long aLongArray628[];
    public String aString616;
    String aString618;
    String aString619;
    public static int anInt614 = 1;
    public static int anInt615;
    public int anInt617;
    int anInt622;
    public int anInt624;
    public int anInt627;
    public int anInt629;
    public int anInt630;
    public int anInt631;
    public int anInt632;
    public int anInt636;
    public int anInt637;
    private final int anInt638 = 100;
    private int anInt640;
    public int anIntArray626[];
    private int anIntArray639[];

}
