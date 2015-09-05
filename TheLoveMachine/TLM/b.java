/*
 * deobfuscatorzed by saevion
 * thanks to the apache-jarkarta group for
 * the bcel and regexp libraries
 * decompiled by JAD
 */

import java.awt.*;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigInteger;

public abstract class b extends a
{
    public abstract void updateServerInfo(); 
    protected final void abn(String arg0, String arg1, boolean arg2)
    {
        if (arg2)
            safeToRun=false;
        if (!arg2) {
            ServerList.setServer(Integer.parseInt(arg0.substring(arg0.length()-1))-1);
            arg0 = arg0.substring(0,arg0.length()-1);
        }
        updateServerInfo();
        if(abi > 0)
        {
            ada("Please wait...", "Connecting to server");
            try
            {
                Thread.sleep(2000L);
            }
            catch(Exception _ex) { }
            ada("Sorry! The server is currently full.", "Please try again later");
            return;
        }
        try
        {
            aae = arg0;
            arg0 = t.fna(arg0, 20);
            aaf = arg1;
            arg1 = t.fna(arg1, 20);
            if(arg0.trim().length() == 0)
            {
                ada("You must enter both a username", "and a password - Please try again");
                return;
            }
            if(arg2)
                acc("Connection lost! Please wait...", "Attempting to re-establish");
            else
                ada("Please wait...", "Connecting to server");
            aag = new s(fai(aac, aad), this);
            aag.ham = aab;
            long l = t.fnc(arg0);
            aag.hda(32);
            aag.hea((int)(l >> 16 & 31L));
            aag.hdl();
            long l1 = aag.hdc();
            abh = l1;
            if(l1 == 0L)
            {
                ada("Login server offline.", "Please try again in a few mins");
                return;
            }
            System.out.println("Verb: Session id: " + l1);
            int i = 0;
            try
            {
                if(fld())
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
            ai[2] = (int)(l1 >> 32);
            ai[3] = (int)l1;
            q q1 = new q(new byte[500]);
            q1.dak = 0;
            q1.dan(10);
            q1.dba(ai[0]);
            q1.dba(ai[1]);
            q1.dba(ai[2]);
            q1.dba(ai[3]);
            q1.dba(adi());
            q1.dbb(arg0);
            q1.dbb(arg1);
            q1.dbh(abf, abg);
            aag.hda(0);
            if(arg2)
                aag.hea(1);
            else
                aag.hea(0);
            aag.hdk(aaa);
            aag.hea(i);
            aag.hdf(q1.daj, 0, q1.dak);
            aag.hdl();
            aag.hcm(ai);
            int j = aag.bak();
            System.out.println("login response:" + j);
            if(j == 25)
            {
                abj = 1;
                aai = 0;
                adc();
                return;
            }
            if(j == 0)
            {
                abj = 0;
                aai = 0;
                adc();
                return;
            }
            if(j == 1)
            {
                aai = 0;
                adb();
                return;
            }
            if(arg2)
            {
                arg0 = "";
                arg1 = "";
                add();
                return;
            }
            if(j == -1)
            {
                ada("Error unable to login.", "Server timed out");
                return;
            }
            if(j == 3)
            {
                ada("Invalid username or password.", "Try again, or create a new account");
                return;
            }
            if(j == 4)
            {
                ada("That username is already logged in.", "Wait 60 seconds then retry");
                return;
            }
            if(j == 5)
            {
                ada("The client has been updated.", "Please reload this page");
                return;
            }
            if(j == 6)
            {
                ada("You may only use 1 character at once.", "Your ip-address is already in use");
                return;
            }
            if(j == 7)
            {
                ada("Login attempts exceeded!", "Please try again in 5 minutes");
                return;
            }
            if(j == 8)
            {
                ada("Error unable to login.", "Server rejected session");
                return;
            }
            if(j == 9)
            {
                ada("Error unable to login.", "Loginserver rejected session");
                return;
            }
            if(j == 10)
            {
                ada("That username is already in use.", "Wait 60 seconds then retry");
                return;
            }
            if(j == 11)
            {
                ada("Account temporarily disabled.", "Check your message inbox for details");
                return;
            }
            if(j == 12)
            {
                ada("Account permanently disabled.", "Check your message inbox for details");
                return;
            }
            if(j == 14)
            {
                ada("Sorry! This world is currently full.", "Please try a different world");
                abi = 1500;
                return;
            }
            if(j == 15)
            {
                ada("You need a members account", "to login to this world");
                return;
            }
            if(j == 16)
            {
                ada("Error - no reply from loginserver.", "Please try again");
                return;
            }
            if(j == 17)
            {
                ada("Error - failed to decode profile.", "Contact customer support");
                return;
            }
            if(j == 20)
            {
                ada("Error - loginserver mismatch", "Please try a different world");
                return;
            } else
            {
                ada("Error unable to login.", "Unrecognised response code");
                return;
            }
        }
        catch(Exception exception)
        {
            System.out.println(String.valueOf(exception));
        }
        if(aai > 0)
        {
            try
            {
                Thread.sleep(5000L);
            }
            catch(Exception _ex) { }
            aai--;
            abn(aae, aaf, arg2);
        }
        if(arg2)
        {
            aae = "";
            aaf = "";
            add();
        } else
        {
            ada("Sorry! Unable to connect.", "Check internet settings or try another world");
        }
    }

    protected final void aca()
    {
        if(aag != null)
            try
            {
                aag.hda(104);
                aag.hdl();
            }
            catch(IOException _ex) { }
        aae = "";
        aaf = "";
        add();
    }

    protected void acb()
    {
        System.out.println("Lost connection");
        aai = 10;
        abn(aae, aaf, true);
    }

    protected final void acc(String s1, String s2)
    {
        Graphics g = getGraphics();
        Font font = new Font("Helvetica", 1, 15);
        char c = '\u0200';
        char c1 = '\u0158';
        g.setColor(Color.black);
        g.fillRect(c / 2 - 140, c1 / 2 - 25, 280, 50);
        g.setColor(Color.white);
        g.drawRect(c / 2 - 140, c1 / 2 - 25, 280, 50);
        flk(g, s1, font, c / 2, c1 / 2 - 10);
        flk(g, s2, font, c / 2, c1 / 2 + 10);
    }

    protected final void acd()
    {
        long l = System.currentTimeMillis();
        if(aag.hde())
            aaj = l;
        if(l - aaj > 5000L)
        {
            aaj = l;
            aag.hda(186);
            aag.hdm();
        }
        try
        {
            aag.hdi(20);
        }
        catch(IOException _ex)
        {
            acb();
            return;
        }
        if(!adh())
            return;
        int i = aag.hdd(aah);
        if(i > 0)
            ace(aah[0] & 0xff, i);
    }
    public abstract void insertIntoMessageQue(Message m);
    private final void ace(int arg0, int arg1)
    {
        arg0 = aag.hdh(arg0);
        if(arg0 == 168)
        {
            String s1 = new String(aah, 1, arg1 - 1); 
            adg(s1);
        }
        if(arg0 == 125)
            aca();
        if(arg0 == 67)
        {
            ade();
            return;
        }
        if(arg0 == 54)
        {
            aak = t.fmh(aah[1]);
            for(int i = 0; i < aak; i++)
            {
                aal[i] = t.fmk(aah, 2 + i * 9);
                aam[i] = t.fmh(aah[10 + i * 9]);
            }

            acf();
            return;
        }
        if(arg0 == 248)
        {
            long l = t.fmk(aah, 1);
            int k = aah[9] & 0xff;
            for(int j1 = 0; j1 < aak; j1++)
                if(aal[j1] == l)
                {
                    if(aam[j1] == 0 && k != 0) {
                        String name = t.fnd(l);
                        insertIntoMessageQue(new Message(Message.PRIVATE_MESSAGE,"logged in",name));
                        adg("@pri@" + name + " has logged in");
                    }
                    if(aam[j1] != 0 && k == 0) {
                        String name = t.fnd(l);
                        insertIntoMessageQue(new Message(Message.PRIVATE_MESSAGE,"logged out",name));
                        adg("@pri@" + t.fnd(l) + " has logged out");
                    }
                    aam[j1] = k;
                    arg1 = 0;
                    acf();
                    return;
                }

            aal[aak] = l;
            aam[aak] = k;
            aak++;
            acf();
            return;
        }
        if(arg0 == 154)
        {
            aan = t.fmh(aah[1]);
            for(int j = 0; j < aan; j++)
                aba[j] = t.fmk(aah, 2 + j * 8);

            return;
        }
        if(arg0 == 137)
        {
            abb = aah[1];
            abc = aah[2];
            abd = aah[3];
            abe = aah[4];
            return;
        }
        if(arg0 == 230)
        {
            long l1 = t.fmk(aah, 1);
            int i1 = t.fmj(aah, 9);
            for(int k1 = 0; k1 < 100; k1++)
                if(abl[k1] == i1)
                    return;

            abl[abm] = i1;
            abm = (abm + 1) % 100;
            String s2 = u.fgd(v.cej(aah, 13, arg1 - 13));
            String name = t.fnd(l1);
            insertIntoMessageQue(new Message(Message.PRIVATE_MESSAGE,s2,name));
            adg("@pri@" + name + ": tells you " + s2);
            return;
        } else
        {
            adf(arg0, arg1, aah);
            return;
        }
    }

    private final void acf()
    {
        boolean flag = true;
        while(flag) 
        {
            flag = false;
            for(int i = 0; i < aak - 1; i++)
                if(aam[i] < aam[i + 1])
                {
                    int j = aam[i];
                    aam[i] = aam[i + 1];
                    aam[i + 1] = j;
                    long l = aal[i];
                    aal[i] = aal[i + 1];
                    aal[i + 1] = l;
                    flag = true;
                }

        }
    }

    protected final void acg(int i, int j, int k, int l)
    {
        aag.hda(247);
        aag.hea(i);
        aag.hea(j);
        aag.hea(k);
        aag.hea(l);
        aag.hdm();
    }

    protected final void ach(String arg0)
    {
        long l = t.fnc(arg0);
        aag.hda(254);
        aag.hdj(l);
        aag.hdm();
        for(int i = 0; i < aan; i++)
            if(aba[i] == l)
                return;

        if(aan >= 100)
        {
            return;
        } else
        {
            aba[aan++] = l;
            return;
        }
    }

    protected final void aci(long arg0)
    {
        aag.hda(244);
        aag.hdj(arg0);
        aag.hdm();
        for(int i = 0; i < aan; i++)
            if(aba[i] == arg0)
            {
                aan--;
                for(int j = i; j < aan; j++)
                    aba[j] = aba[j + 1];

                return;
            }

    }

    protected final void acj(String arg0)
    {
        aag.hda(232);
        aag.hdj(t.fnc(arg0));
        aag.hdm();
        long l = t.fnc(arg0);
        for(int i = 0; i < aak; i++)
            if(aal[i] == l)
                return;

        if(aak >= 100)
        {
            return;
        } else
        {
            aal[aak] = l;
            aam[aak] = 0;
            aak++;
            return;
        }
    }

    protected final void ack(long arg0)
    {
        aag.hda(52);
        aag.hdj(arg0);
        aag.hdm();
        for(int i = 0; i < aak; i++)
        {
            if(aal[i] != arg0)
                continue;
            aak--;
            for(int j = i; j < aak; j++)
            {
                aal[j] = aal[j + 1];
                aam[j] = aam[j + 1];
            }

            break;
        }

        adg("@pri@" + t.fnd(arg0) + " has been removed from your friends list");
    }

    protected final void acl(long l, byte abyte0[], int i)
    {
        aag.hda(59);
        aag.hdj(l);
        aag.hdf(abyte0, 0, i);
        aag.hdm();
    }

    protected final void acm(byte abyte0[], int i)
    {
        aag.hda(249);
        aag.hdf(abyte0, 0, i);
        aag.hdm();
    }

    protected final void acn(String s1)
    {
        aag.hda(32);
        aag.hdn(s1);
        aag.hdm();
    }

    protected void ada(String s1, String s2)
    {
    }

    protected void adb()
    {
    }

    protected void adc()
    {
    }

    protected void add()
    {
    }

    protected void ade()
    {
    }

    protected void adf(int i, int j, byte abyte0[])
    {
    }

    protected void adg(String s1)
    {
    }

    protected boolean adh()
    {
        return true;
    }

    protected int adi()
    {
        return 0;
    }

    public b()
    {
        aac = "127.0.0.1";
        aad = 43594;
        aae = "";
        aaf = "";
        aah = new byte[5000];
        aal = new long[200];
        aam = new int[200];
        aba = new long[50];
        abl = new int[100];
    }

    public static int aaa = 1;
    public static int aab;
    public String aac;
    public int aad;
    String aae;
    String aaf;
    public s aag;
    byte aah[];
    int aai;
    long aaj;
    public int aak;
    public long aal[];
    public int aam[];
    public int aan;
    public long aba[];
    public int abb;
    public int abc;
    public int abd;
    public int abe;
    private static BigInteger abf = new BigInteger("58778699976184461502525193738213253649000149147835990136706041084440742975821");
    private static BigInteger abg = new BigInteger("7162900525229798032761816791230527296329313291232324290237849263501208207972894053929065636522363163621000728841182238772712427862772219676577293600221789");
    public long abh;
    public int abi;
    public int abj;
    private final int abk = 100;
    private int abl[];
    private int abm;

}
