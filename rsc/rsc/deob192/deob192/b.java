// Decompiled by DJ v3.7.7.81 Copyright 2004 Atanas Neshkov  Date: 09/04/2005 1:47:25 AM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 

import java.awt.*;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigInteger;

public class b extends a
{

    protected final void cbi(String arg0, String arg1, boolean arg2)
    {
        if(dlf > 0)
        {
            ccj("Please wait...", "Connecting to server");
            try
            {
                Thread.sleep(2000L);
            }
            catch(Exception _ex) { }
            ccj("Sorry! The server is currently full.", "Please try again later");
            return;
        }
        try
        {
            dkb = arg0;
            arg0 = t.ane(arg0, 20);
            dkc = arg1;
            arg1 = t.ane(arg1, 20);
            if(arg0.trim().length() == 0)
            {
                ccj("You must enter both a username", "and a password - Please try again");
                return;
            }
            if(arg2)
                cbl("Connection lost! Please wait...", "Attempting to re-establish");
            else
                ccj("Please wait...", "Connecting to server");
            dkd = new s(akb(djn, dka), this);
            dkd.bja = djm;
            long l = dkd.bha();
            dle = l;
            if(l == 0L)
            {
                ccj("Login server offline.", "Please try again in a few mins");
                return;
            }
            System.out.println("Verb: Session id: " + l);
            int i = 0;
            try
            {
                if(ahn())
                {
                    String s1 = getParameter("limit30");
                    if(s1.equals("1"))
                        i = 1;
                }
            }
            catch(Exception _ex) { }
            int ai[] = new int[4];
            ai[0] = (int)(Math.random() * 99999999D);
            ai[1] = (int)(Math.random() * 99999999D);
            ai[2] = (int)(l >> 32);
            ai[3] = (int)l;
            q q1 = new q(new byte[500]);
            q1.aee = 0;
            q1.adk(10);
            q1.adl(ai[0]);
            q1.adl(ai[1]);
            q1.adl(ai[2]);
            q1.adl(ai[3]);
            q1.adl(cdd());
            q1.adm(arg0);
            q1.adm(arg1);
            q1.aee(dlc, dld);
            dkd.bgl(0);
            if(arg2)
                dkd.bfj(1);
            else
                dkd.bfj(0);
            dkd.bfn(djl);
            dkd.bfj(i);
            dkd.bgn(q1.aed, 0, q1.aee);
            dkd.bgf();
            dkd.bfh(ai);
            int j = dkd.bfl();
            System.out.println("login response:" + j);
            if(j == 25)
            {
                dlg = 1;
                dkf = 0;
                ccl();
                return;
            }
            if(j == 0)
            {
                dlg = 0;
                dkf = 0;
                ccl();
                return;
            }
            if(j == 1)
            {
                dkf = 0;
                cck();
                return;
            }
            if(arg2)
            {
                arg0 = "";
                arg1 = "";
                ccm();
                return;
            }
            if(j == -1)
            {
                ccj("Error unable to login.", "Server timed out");
                return;
            }
            if(j == 3)
            {
                ccj("Invalid username or password.", "Try again, or create a new account");
                return;
            }
            if(j == 4)
            {
                ccj("That username is already logged in.", "Wait 60 seconds then retry");
                return;
            }
            if(j == 5)
            {
                ccj("The client has been updated.", "Please reload this page");
                return;
            }
            if(j == 6)
            {
                ccj("You may only use 1 character at once.", "Your ip-address is already in use");
                return;
            }
            if(j == 7)
            {
                ccj("Login attempts exceeded!", "Please try again in 5 minutes");
                return;
            }
            if(j == 8)
            {
                ccj("Error unable to login.", "Server rejected session");
                return;
            }
            if(j == 9)
            {
                ccj("Error unable to login.", "Loginserver rejected session");
                return;
            }
            if(j == 10)
            {
                ccj("That username is already in use.", "Wait 60 seconds then retry");
                return;
            }
            if(j == 11)
            {
                ccj("Account temporarily disabled.", "Check your message inbox for details");
                return;
            }
            if(j == 12)
            {
                ccj("Account permanently disabled.", "Check your message inbox for details");
                return;
            }
            if(j == 14)
            {
                ccj("Sorry! This world is currently full.", "Please try a different world");
                dlf = 1500;
                return;
            }
            if(j == 15)
            {
                ccj("You need a members account", "to login to this world");
                return;
            }
            if(j == 16)
            {
                ccj("Error - no reply from loginserver.", "Please try again");
                return;
            }
            if(j == 17)
            {
                ccj("Error - failed to decode profile.", "Contact customer support");
                return;
            } else
            {
                ccj("Error unable to login.", "Unrecognised response code");
                return;
            }
        }
        catch(Exception exception)
        {
            System.out.println(String.valueOf(exception));
        }
        if(dkf > 0)
        {
            try
            {
                Thread.sleep(5000L);
            }
            catch(Exception _ex) { }
            dkf--;
            cbi(dkb, dkc, arg2);
        }
        if(arg2)
        {
            dkb = "";
            dkc = "";
            ccm();
        } else
        {
            ccj("Sorry! Unable to connect.", "Check internet settings or try another world");
        }
    }

    protected final void cbj()
    {
        if(dkd != null)
            try
            {
                dkd.bgl(241);
                dkd.bgf();
            }
            catch(IOException _ex) { }
        dkb = "";
        dkc = "";
        ccm();
    }

    protected void cbk()
    {
        System.out.println("Lost connection");
        dkf = 10;
        cbi(dkb, dkc, true);
    }

    protected final void cbl(String arg0, String arg1)
    {
        Graphics g = ajk();
        Font font = new Font("Helvetica", 1, 15);
        char c = '\u0200';
        char c1 = '\u0158';
        g.setColor(Color.black);
        g.fillRect(c / 2 - 140, c1 / 2 - 25, 280, 50);
        g.setColor(Color.white);
        g.drawRect(c / 2 - 140, c1 / 2 - 25, 280, 50);
        ajh(g, arg0, font, c / 2, c1 / 2 - 10);
        ajh(g, arg1, font, c / 2, c1 / 2 + 10);
    }

    protected final void cbm()
    {
        long l = System.currentTimeMillis();
        if(dkd.bgd())
            dkg = l;
        if(l - dkg > 5000L)
        {
            dkg = l;
            dkd.bgl(224);
            dkd.bgm();
        }
        try
        {
            dkd.bgi(20);
        }
        catch(IOException _ex)
        {
            cbk();
            return;
        }
        if(!cdc())
            return;
        int i = dkd.bge(dke);
        if(i > 0)
            cbn(dke[0] & 0xff, i);
    }

    private final void cbn(int arg0, int arg1)
    {
        arg0 = dkd.bgk(arg0);
        if(arg0 == 236)
        {
            String s1 = new String(dke, 1, arg1 - 1);
            cdb(s1);
        }
        if(arg0 == 54)
            cbj();
        if(arg0 == 53)
        {
            ccn();
            return;
        }
        if(arg0 == 218)
        {
            dkh = t.aml(dke[1]);
            for(int i = 0; i < dkh; i++)
            {
                dki[i] = t.ana(dke, 2 + i * 9);
                dkj[i] = t.aml(dke[10 + i * 9]);
            }

            cca();
            return;
        }
        if(arg0 == 81)
        {
            long l = t.ana(dke, 1);
            int k = dke[9] & 0xff;
            for(int j1 = 0; j1 < dkh; j1++)
                if(dki[j1] == l)
                {
                    if(dkj[j1] == 0 && k != 0)
                        cdb("@pri@" + t.anh(l) + " has logged in");
                    if(dkj[j1] != 0 && k == 0)
                        cdb("@pri@" + t.anh(l) + " has logged out");
                    dkj[j1] = k;
                    arg1 = 0;
                    cca();
                    return;
                }

            dki[dkh] = l;
            dkj[dkh] = k;
            dkh++;
            cdb("@pri@" + t.anh(l) + " has been added to your friends list");
            cca();
            return;
        }
        if(arg0 == 136)
        {
            dkk = t.aml(dke[1]);
            for(int j = 0; j < dkk; j++)
                dkl[j] = t.ana(dke, 2 + j * 8);

            return;
        }
        if(arg0 == 168)
        {
            dkm = dke[1];
            dkn = dke[2];
            dla = dke[3];
            dlb = dke[4];
            return;
        }
        if(arg0 == 154)
        {
            long l1 = t.ana(dke, 1);
            int i1 = t.amn(dke, 9);
            for(int k1 = 0; k1 < 100; k1++)
                if(dli[k1] == i1)
                    return;

            dli[dlj] = i1;
            dlj = (dlj + 1) % 100;
            String s2 = u.akl(v.aeg(dke, 13, arg1 - 13));
            cdb("@pri@" + t.anh(l1) + ": tells you " + s2);
            return;
        } else
        {
            cda(arg0, arg1, dke);
            return;
        }
    }

    private final void cca()
    {
        boolean flag = true;
        while(flag) 
        {
            flag = false;
            for(int i = 0; i < dkh - 1; i++)
                if(dkj[i] < dkj[i + 1])
                {
                    int j = dkj[i];
                    dkj[i] = dkj[i + 1];
                    dkj[i + 1] = j;
                    long l = dki[i];
                    dki[i] = dki[i + 1];
                    dki[i + 1] = l;
                    flag = true;
                }

        }
    }

    protected final void ccb(int arg0, int arg1, int arg2, int arg3)
    {
        dkd.bgl(74);
        dkd.bfj(arg0);
        dkd.bfj(arg1);
        dkd.bfj(arg2);
        dkd.bfj(arg3);
        dkd.bgm();
    }

    protected final void ccc(String arg0)
    {
        long l = t.ang(arg0);
        dkd.bgl(51);
        dkd.bgh(l);
        dkd.bgm();
        for(int i = 0; i < dkk; i++)
            if(dkl[i] == l)
                return;

        if(dkk >= 50)
        {
            return;
        } else
        {
            dkl[dkk++] = l;
            return;
        }
    }

    protected final void ccd(long arg0)
    {
        dkd.bgl(61);
        dkd.bgh(arg0);
        dkd.bgm();
        for(int i = 0; i < dkk; i++)
            if(dkl[i] == arg0)
            {
                dkk--;
                for(int j = i; j < dkk; j++)
                    dkl[j] = dkl[j + 1];

                return;
            }

    }

    protected final void cce(String arg0)
    {
        dkd.bgl(22);
        dkd.bgh(t.ang(arg0));
        dkd.bgm();
        long l = t.ang(arg0);
        for(int i = 0; i < dkh; i++)
            if(dki[i] == l)
                return;

        if(dkh >= 100)
        {
            return;
        } else
        {
            dki[dkh] = l;
            dkj[dkh] = 0;
            dkh++;
            return;
        }
    }

    protected final void ccf(long arg0)
    {
        dkd.bgl(7);
        dkd.bgh(arg0);
        dkd.bgm();
        for(int i = 0; i < dkh; i++)
        {
            if(dki[i] != arg0)
                continue;
            dkh--;
            for(int j = i; j < dkh; j++)
            {
                dki[j] = dki[j + 1];
                dkj[j] = dkj[j + 1];
            }

            break;
        }

        cdb("@pri@" + t.anh(arg0) + " has been removed from your friends list");
    }

    protected final void ccg(long arg0, byte arg1[], int arg2)
    {
        dkd.bgl(191);
        dkd.bgh(arg0);
        dkd.bgn(arg1, 0, arg2);
        dkd.bgm();
    }

    protected final void cch(byte arg0[], int arg1)
    {
        dkd.bgl(16);
        dkd.bgn(arg0, 0, arg1);
        dkd.bgm();
    }

    protected final void cci(String arg0)
    {
        dkd.bgl(206);
        dkd.bgc(arg0);
        dkd.bgm();
    }

    protected void ccj(String s1, String s2)
    {
    }

    protected void cck()
    {
    }

    protected void ccl()
    {
    }

    protected void ccm()
    {
    }

    protected void ccn()
    {
    }

    protected void cda(int i, int j, byte abyte0[])
    {
    }

    protected void cdb(String s1)
    {
    }

    protected boolean cdc()
    {
        return true;
    }

    protected int cdd()
    {
        return 0;
    }

    public b()
    {
        djn = "127.0.0.1";
        dka = 43594;
        dkb = "";
        dkc = "";
        dke = new byte[5000];
        dki = new long[100];
        dkj = new int[100];
        dkl = new long[50];
        dli = new int[100];
    }

    public static int djl = 1;
    public static int djm;
    public String djn;
    public int dka;
    String dkb;
    String dkc;
    public s dkd;
    byte dke[];
    int dkf;
    long dkg;
    public int dkh;
    public long dki[];
    public int dkj[];
    public int dkk;
    public long dkl[];
    public int dkm;
    public int dkn;
    public int dla;
    public int dlb;
    private static BigInteger dlc = new BigInteger("58778699976184461502525193738213253649000149147835990136706041084440742975821");
    private static BigInteger dld = new BigInteger("7162900525229798032761816791230527296329313291232324290237849263501208207972894053929065636522363163621000728841182238772712427862772219676577293600221789");
    public long dle;
    public int dlf;
    public int dlg;
    private final int dlh = 100;
    private int dli[];
    private int dlj;

}