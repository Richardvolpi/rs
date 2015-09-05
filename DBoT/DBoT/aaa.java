// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
import java.awt.*;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigInteger;
public class aaa extends fjb
{
    protected final void aca(String s, String s1, boolean flag)
    {
        boolean flag1 = false;
        if(abj > 0)
        {
            adb("Please wait...", "Connecting to server");
            try
            {
                Thread.sleep(2000L);
            }
            catch(Exception _ex) { }
            adb("Sorry! The server is currently full.", "Please try again later");
            return;
        }
        try
        {
            aaf = s;
            s = fnf.gae(s, 20);
            aag = s1;
            s1 = fnf.gae(s1, 20);
            if(s.trim().length() == 0)
            {
                adb("You must enter both a username", "and a password - Please try again");
                return;
            }
            if(flag)
                acd("Connection lost! Please wait...", "Attempting to re-establish");
            else
                adb("Please wait...", "Connecting to server");
            packets = new bae(fbb(aad, aae), this);
            packets.hcj = aac;
            long l = packets.hfe();
            abi = l;
            if(l == 0L)
            {
                adb("Login server offline.", "Please try again in a few mins");
                return;
            }
            System.out.println("Verb: Session id: " + l);
            int i = 0;
            try
            {
                if(fmf())
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
            ai[2] = (int)(l >> 32);
            ai[3] = (int)l;
            dbh dbh1 = new dbh(new byte[500]);
            dbh1.dbj = 0;
            dbh1.dbm(10);
            dbh1.dbn(ai[0]);
            dbh1.dbn(ai[1]);
            dbh1.dbn(ai[2]);
            dbh1.dbn(ai[3]);
            dbh1.dbn(adj());
            dbh1.dca(s);
            dbh1.dca(s1);
            dbh1.dcg(abg, abh);
            packets.id(0);
            if(flag)
                packets.var(1);
            else
                packets.var(0);
            packets.cmd(aab);
            packets.var(i);
            packets.hfd(dbh1.dbi, 0, dbh1.dbj);
            packets.hfb();
            packets.hej(ai);
            int j = packets.bba();
            System.out.println("login response:" + j);
            if(j == 25)
            {
                abk = 1;
                aaj = 0;
                add();
                return;
            }
            if(j == 0)
            {
                abk = 0;
                aaj = 0;
                add();
                return;
            }
            if(j == 1)
            {
                aaj = 0;
                adc();
                return;
            }
            if(flag)
            {
                s = "";
                s1 = "";
                ade();
                return;
            }
            if(j == -1)
            {
                adb("Error unable to login.", "Server timed out");
                return;
            }
            if(j == 3)
            {
                adb("Invalid username or password.", "Try again, or create a new account");
                return;
            }
            if(j == 4)
            {
                adb("That username is already logged in.", "Wait 60 seconds then retry");
                return;
            }
            if(j == 5)
            {
                adb("The client has been updated.", "Please reload this page");
                return;
            }
            if(j == 6)
            {
                adb("You may only use 1 character at once.", "Your ip-address is already in use");
                return;
            }
            if(j == 7)
            {
                adb("Login attempts exdrawboxtextded!", "Please try again in 5 minutes");
                return;
            }
            if(j == 8)
            {
                adb("Error unable to login.", "Server rejected session");
                return;
            }
            if(j == 9)
            {
                adb("Error unable to login.", "Loginserver rejected session");
                return;
            }
            if(j == 10)
            {
                adb("That username is already in use.", "Wait 60 seconds then retry");
                return;
            }
            if(j == 11)
            {
                adb("Account temporarily disabled.", "Check your message inbox for details");
                return;
            }
            if(j == 12)
            {
                adb("Account permanently disabled.", "Check your message inbox for details");
                return;
            }
            if(j == 14)
            {
                adb("Sorry! This world is currently full.", "Please try a different world");
                abj = 1500;
                return;
            }
            if(j == 15)
            {
                adb("You need a members account", "to login to this world");
                return;
            }
            if(j == 16)
            {
                adb("Error - no reply from loginserver.", "Please try again");
                return;
            }
            if(j == 17)
            {
                adb("Error - failed to decode profile.", "Contact customer support");
                return;
            } else
            {
                adb("Error unable to login.", "Unrecognised response code");
                return;
            }
        }
        catch(Exception exception)
        {
            System.out.println(String.valueOf(exception));
        }
        if(aaj > 0)
        {
            try
            {
                Thread.sleep(5000L);
            }
            catch(Exception _ex) { }
            aaj--;
            aca(aaf, aag, flag);
        }
        if(flag)
        {
            aaf = "";
            aag = "";
            ade();
        } else
        {
            adb("Sorry! Unable to connect.", "Check internet settings or try another world");
        }
    }
    protected final void acb()
    {
        if(packets != null)
            try
            {
                packets.id(103);
                packets.hfb();
            }
            catch(IOException _ex) { }
        aaf = "";
        aag = "";
        ade();
    }
    protected void acc()
    {
        System.out.println("Lost connection");
        aaj = 10;
        aca(aaf, aag, true);
    }
    protected final void acd(String s, String s1)
    {
        Graphics g = getGraphics();
        Font font = new Font("Helvetica", 1, 15);
        char c = '\u0200';
        char c1 = '\u0158';
        g.setColor(Color.black);
        g.fillRect(116, 147, 280, 50);
        g.setColor(Color.white);
        g.drawRect(116, 147, 280, 50);
        fmm(g, s, font, 256, 162);
        fmm(g, s1, font, 256, 182);
    }
    protected final void ace()
    {
        long l = System.currentTimeMillis();
        if(packets.hfh())
            aak = l;
        if(l - aak > 5000L)
        {
            aak = l;
            packets.id(10);
            packets.send();
        }
        try
        {
            packets.hfg(20);
        }
        catch(IOException _ex)
        {
            acc();
            return;
        }
        if(!adi())
            return;
        int i = packets.hek(aai);
        if(i > 0)
            acf(aai[0] & 0xff, i);
    }
    private final void acf(int i, int j)
    {
        boolean flag = false;
        i = packets.hfk(i);
        if(i == 155)
        {
            String s = new String(aai, 1, j - 1);
            servermessage(s);
        }
        if(i == 112)
            acb();
        if(i == 48)
        {
            adf();
            return;
        }
        if(i == 69)
        {
            aal = fnf.fnl(aai[1]);
            for(int k = 0; k < aal; k++)
            {
                aam[k] = fnf.gaa(aai, 2 + k * 9);
                aan[k] = fnf.fnl(aai[10 + k * 9]);
            }
            acg();
            return;
        }
        if(i == 252)
        {
            long l = fnf.gaa(aai, 1);
            int j1 = aai[9] & 0xff;
            for(int i2 = 0; i2 < aal; i2++)
                if(aam[i2] == l)
                {
                    if(aan[i2] == 0 && j1 != 0)
                        servermessage("@pri@" + fnf.gah(l) + " has logged in");
                    if(aan[i2] != 0 && j1 == 0)
                        servermessage("@pri@" + fnf.gah(l) + " has logged out");
                    aan[i2] = j1;
                    j = 0;
                    acg();
                    return;
                }
            aam[aal] = l;
            aan[aal] = j1;
            aal++;
            servermessage("@pri@" + fnf.gah(l) + " has been added to your friends list");
            acg();
            return;
        }
        if(i == 76)
        {
            aba = fnf.fnl(aai[1]);
            for(int i1 = 0; i1 < aba; i1++)
                abb[i1] = fnf.gaa(aai, 2 + i1 * 8);
            return;
        }
        if(i == 134)
        {
            blockchat = aai[1];
            blockprivate = aai[2];
            blocktrade = aai[3];
            blockduel = aai[4];
            return;
        }
        if(i == 110)
        {
            long l1 = fnf.gaa(aai, 1);
            int k1 = fnf.fnn(aai, 9);
            for(int j2 = 0; j2 < 100; j2++)
                if(abm[j2] == k1)
                    return;
            abm[abn] = k1;
            abn = (abn + 1) % 100;
            String s1 = ffn.fhe(cen.cfd(aai, 13, j - 13));
            servermessage("@pri@" + fnf.gah(l1) + ": tells you " + s1);
            return;
        } else
        {
            process(i, j, aai);
            return;
        }
    }
    private final void acg()
    {
        boolean flag1 = false;
        boolean flag = true;
        while(flag) 
        {
            flag = false;
            for(int i = 0; i < aal - 1; i++)
                if(aan[i] < aan[i + 1])
                {
                    int j = aan[i];
                    aan[i] = aan[i + 1];
                    aan[i + 1] = j;
                    long l = aam[i];
                    aam[i] = aam[i + 1];
                    aam[i + 1] = l;
                    flag = true;
                }
        }
    }
    protected final void ach(int i, int j, int k, int l)
    {
        packets.id(219);
        packets.var(i);
        packets.var(j);
        packets.var(k);
        packets.var(l);
        packets.send();
    }
    protected final void aci(String s)
    {
        long l = fnf.gag(s);
        packets.id(200);
        packets.hff(l);
        packets.send();
        for(int i = 0; i < aba; i++)
            if(abb[i] == l)
                return;
        if(aba >= 50)
        {
            return;
        } else
        {
            abb[aba++] = l;
            return;
        }
    }
    protected final void acj(long l)
    {
        boolean flag = false;
        packets.id(68);
        packets.hff(l);
        packets.send();
        for(int i = 0; i < aba; i++)
            if(abb[i] == l)
            {
                aba--;
                for(int j = i; j < aba; j++)
                    abb[j] = abb[j + 1];
                return;
            }
    }
    protected final void ack(String s)
    {
        packets.id(63);
        packets.hff(fnf.gag(s));
        packets.send();
        long l = fnf.gag(s);
        for(int i = 0; i < aal; i++)
            if(aam[i] == l)
                return;
        if(aal >= 100)
        {
            return;
        } else
        {
            aam[aal] = l;
            aan[aal] = 0;
            aal++;
            return;
        }
    }
    protected final void acl(long l)
    {
        boolean flag = false;
        packets.id(174);
        packets.hff(l);
        packets.send();
        for(int i = 0; i < aal; i++)
        {
            if(aam[i] != l)
                continue;
            aal--;
            for(int j = i; j < aal; j++)
            {
                aam[j] = aam[j + 1];
                aan[j] = aan[j + 1];
            }
            break;
        }
        servermessage("@pri@" + fnf.gah(l) + " has been removed from your friends list");
    }
    protected final void acm(long l, byte abyte0[], int i)
    {
        packets.id(128);
        packets.hff(l);
        packets.hfd(abyte0, 0, i);
        packets.send();
    }
    protected final void acn(byte abyte0[], int i)
    {
        packets.id(123);
        packets.hfd(abyte0, 0, i);
        packets.send();
    }
    protected final void ada(String s)
    {
        packets.id(45);
        packets.hen(s);
        packets.send();
    }
    protected void adb(String s, String s1)
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
    protected void adf()
    {
    }
    protected void process(int i, int j, byte abyte0[])
    {
    }
    protected void servermessage(String s)
    {
    }
    protected boolean adi()
    {
        return true;
    }
    protected int adj()
    {
        return 0;
    }
    public aaa()
    {
        aad = "127.0.0.1";
        aae = 43594;
        aaf = "";
        aag = "";
        aai = new byte[5000];
        aam = new long[100];
        aan = new int[100];
        abb = new long[50];
        abm = new int[100];
    }
    public static int aab = 1;
    public static int aac;
    public String aad;
    public int aae;
    String aaf;
    String aag;
    public bae packets;
    byte aai[];
    int aaj;
    long aak;
    public int aal;
    public long aam[];
    public int aan[];
    public int aba;
    public long abb[];
    public int blockchat;
    public int blockprivate;
    public int blocktrade;
    public int blockduel;
    private static BigInteger abg = new BigInteger("58778699976184461502525193738213253649000149147835990136706041084440742975821");
    private static BigInteger abh = new BigInteger("7162900525229798032761816791230527296329313291232324290237849263501208207972894053929065636522363163621000728841182238772712427862772219676577293600221789");
    public long abi;
    public int abj;
    public int abk;
    private final int abl = 100;
    private int abm[];
    private int abn;
}
