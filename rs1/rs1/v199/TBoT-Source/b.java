// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

import java.awt.*;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigInteger;

public class b extends a
{

    protected final void login(String arg0, String arg1, boolean arg2)
    {
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
            connection = new s(fef(serverHost, serverPort), this);
            connection.ham = aab;
            long l = t.fnc(arg0);
            connection.newID(32);
            connection.addVar((int)(l >> 16 & 31L));
            connection.hdm();
            long l1 = connection.hcn();
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
                if(application())
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
            q1.dba((int)(Math.random() * 999999D));
            q1.dbb(arg0);
            q1.dbb(arg1);
            q1.dbh(abf, abg);
            connection.newID(0);
            if(arg2)
                connection.addVar(1);
            else
                connection.addVar(0);
            connection.addInt(aaa);
            connection.addVar(i);
            connection.hdf(q1.daj, 0, q1.dak);
            connection.hdm();
            connection.hcm(ai);
            int j = connection.bak();
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
            login(aae, aaf, arg2);
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
        if(connection != null)
            try
            {
                connection.newID(29);
                connection.hdm();
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
        login(aae, aaf, true);
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
        if(connection.hda())
            aaj = l;
        if(l - aaj > 5000L)
        {
            aaj = l;
            connection.newID(251);
            connection.complete();
        }
        try
        {
            connection.hdd(20);
        }
        catch(IOException _ex)
        {
            acb();
            return;
        }
        if(!adh())
            return;
        int i = connection.hdi(aah);
        if(i > 0)
            ace(aah[0] & 0xff, i);
    }

    private final void ace(int arg0, int arg1)
    {
        arg0 = connection.hdc(arg0);
        if(arg0 == 3)
        {
            String s1 = new String(aah, 1, arg1 - 1);
            adg(s1);
        }
        if(arg0 == 208)
            aca();
        if(arg0 == 102)
        {
            ade();
            return;
        }
        if(arg0 == 45)
        {
            friendCount = t.fmh(aah[1]);
            for(int i = 0; i < friendCount; i++)
            {
                friendID[i] = t.fmk(aah, 2 + i * 9);
                friendOnlineStatus[i] = t.fmh(aah[10 + i * 9]);
            }

            acf();
            return;
        }
        if(arg0 == 18)
        {
            long l = t.fmk(aah, 1);
            int k = aah[9] & 0xff;
            for(int j1 = 0; j1 < friendCount; j1++)
                if(friendID[j1] == l)
                {
                    if(friendOnlineStatus[j1] == 0 && k != 0)
                        adg("@pri@" + t.grabFriendName(l) + " has logged in");
                    if(friendOnlineStatus[j1] != 0 && k == 0)
                        adg("@pri@" + t.grabFriendName(l) + " has logged out");
                    friendOnlineStatus[j1] = k;
                    arg1 = 0;
                    acf();
                    return;
                }

            friendID[friendCount] = l;
            friendOnlineStatus[friendCount] = k;
            friendCount++;
            acf();
            return;
        }
        if(arg0 == 53)
        {
            aan = t.fmh(aah[1]);
            for(int j = 0; j < aan; j++)
                aba[j] = t.fmk(aah, 2 + j * 8);

            return;
        }
        if(arg0 == 72)
        {
            blockChat = aah[1];
            blockPM = aah[2];
            blockTrade = aah[3];
            blockDuel = aah[4];
            return;
        }
        if(arg0 == 249)
        {
            long l1 = t.fmk(aah, 1);
            int i1 = t.fmj(aah, 9);
            for(int k1 = 0; k1 < 100; k1++)
                if(abl[k1] == i1)
                    return;

            abl[abm] = i1;
            abm = (abm + 1) % 100;
            String s2 = u.fgd(v.cej(aah, 13, arg1 - 13));
            adg("@pri@" + t.grabFriendName(l1) + ": tells you " + s2);
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
            for(int i = 0; i < friendCount - 1; i++)
                if(friendOnlineStatus[i] < friendOnlineStatus[i + 1])
                {
                    int j = friendOnlineStatus[i];
                    friendOnlineStatus[i] = friendOnlineStatus[i + 1];
                    friendOnlineStatus[i + 1] = j;
                    long l = friendID[i];
                    friendID[i] = friendID[i + 1];
                    friendID[i + 1] = l;
                    flag = true;
                }

        }
    }

    protected final void acg(int i, int j, int k, int l)
    {
        connection.newID(22);
        connection.addVar(i);
        connection.addVar(j);
        connection.addVar(k);
        connection.addVar(l);
        connection.complete();
    }

    protected final void ach(String arg0)
    {
        long l = t.fnc(arg0);
        connection.newID(232);
        connection.hdl(l);
        connection.complete();
        for(int i = 0; i < aan; i++)
            if(aba[i] == l)
                return;

        if(aan >= 50)
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
        connection.newID(136);
        connection.hdl(arg0);
        connection.complete();
        for(int i = 0; i < aan; i++)
            if(aba[i] == arg0)
            {
                aan--;
                for(int j = i; j < aan; j++)
                    aba[j] = aba[j + 1];

                return;
            }

    }

    protected final void addFriend(String arg0)
    {
		System.out.println("kthxadd " + arg0);
        connection.newID(133);
        connection.hdl(t.fnc(arg0));
        connection.complete();
        long l = t.fnc(arg0);
        for(int i = 0; i < friendCount; i++)
            if(friendID[i] == l)
                return;

        if(friendCount >= 100)
        {
            return;
        } else
        {
            friendID[friendCount] = l;
            friendOnlineStatus[friendCount] = 0;
            friendCount++;
            return;
        }
    }

    protected final void ack(long arg0)
    {
        connection.newID(247);
        connection.hdl(arg0);
        connection.complete();
        for(int i = 0; i < friendCount; i++)
        {
            if(friendID[i] != arg0)
                continue;
            friendCount--;
            for(int j = i; j < friendCount; j++)
            {
                friendID[j] = friendID[j + 1];
                friendOnlineStatus[j] = friendOnlineStatus[j + 1];
            }

            break;
        }

        adg("@pri@" + t.grabFriendName(arg0) + " has been removed from your friends list");
    }

    protected final void acl(long l, byte abyte0[], int i)
    {
        connection.newID(198);
        connection.hdl(l);
        connection.hdf(abyte0, 0, i);
        connection.complete();
    }

    protected final void acm(byte abyte0[], int i)
    {
        connection.newID(204);
        connection.hdf(abyte0, 0, i);
        connection.complete();
    }

    protected final void acn(String s1)
    {
        connection.newID(6);
        connection.hdk(s1);
        connection.complete();
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
        serverHost = "127.0.0.1";
        serverPort = 43594;
        aae = "";
        aaf = "";
        aah = new byte[5000];
        friendID = new long[200];
        friendOnlineStatus = new int[200];
        aba = new long[50];
        abl = new int[100];
    }

    public static int aaa = 1;
    public static int aab;
    public String serverHost;
    public int serverPort;
    String aae;
    String aaf;
    public s connection;
    byte aah[];
    int aai;
    long aaj;
    public int friendCount;
    public long friendID[];
    public int friendOnlineStatus[];
    public int aan;
    public long aba[];
    public int blockChat;
    public int blockPM;
    public int blockTrade;
    public int blockDuel;
    private static BigInteger abf = new BigInteger("58778699976184461502525193738213253649000149147835990136706041084440742975821");
    private static BigInteger abg = new BigInteger("7162900525229798032761816791230527296329313291232324290237849263501208207972894053929065636522363163621000728841182238772712427862772219676577293600221789");
    public long abh;
    public int abi;
    public int abj;
    private final int abk = 100;
    private int abl[];
    private int abm;

}
