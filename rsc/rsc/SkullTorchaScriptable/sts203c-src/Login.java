import java.awt.*;
import java.io.IOException;
import java.math.BigInteger;


@SuppressWarnings("serial")
public class Login extends a {

    protected void setAutoLogin(boolean on) {}

    protected final void loginRS(String arg0, String arg1, boolean arg2) {
        if (abi > 0) {
            SetLoginMessage("Please wait " + arg0 + "...", "Connecting...");
            try {
                Thread.sleep(2000L);
            } catch (Exception _ex) {}
            SetLoginMessage("Sorry! The server is currently full.", "Please try again later");
            return;
        }
        try {
            User = arg0;
            arg0 = t.fna(arg0, 20);
            Pass = arg1;
            arg1 = t.fna(arg1, 20);
            if (arg0.trim().length() == 0) {
                SetLoginMessage("You must enter both a username", "and a password - Please try again");
                return;
            }
            if (arg2) {
                MessageBox("Connection lost! Please wait...", "Attempting to re-establish");
            } else {
                SetLoginMessage("Please wait...", "Connecting to server");
            }
            if (Connection != null) {
                Connection.baj();
            }
            Connection = new Connect(NewSocket(IP, Port), this);
            Connection.ham = aab;
            long l = t.PlayerNameToLong(arg0);

            Connection.SendID(0);
            Connection.SendVar((int) (l >> 16 & 31L));
            Connection.hdm();
            long l1 = Connection.hcn();

            if (l1 == 0L) {
                SetLoginMessage("Login server offline.", "Please try again in a few mins");
                return;
            }
            System.out.print("Session id " + l1 + "...");
            int ai[] = new int[4];

            ai[0] = (int) (Math.random() * 99999999D);
            ai[1] = (int) (Math.random() * 99999999D);
            ai[2] = (int) (l1 >> 32);
            ai[3] = (int) l1;
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
            Connection.SendID(1);
            Connection.SendVar(arg2 ? 1 : 0);
            Connection.SendInt(mudclient.mudVersion);
            Connection.SendVar(0);
            Connection.hdf(q1.daj, 0, q1.dak);
            Connection.hdm();
            Connection.hcm(ai);
            int j = Connection.bak();

            System.out.println("Login response " + j);
            if (j == 25) {
                abj = 1;
                aai = 0;
                adc();
            } else if (j == 0) {
                abj = 0;
                aai = 0;
                adc();
            } else if (j == 1) {
                aai = 0;
                adb();
            } else if (arg2) {
                arg0 = "";
                arg1 = "";
                add();
            } else if (j == -1) {
                SetLoginMessage("Error unable to login.", "Server timed out");
            } else if (j == 3) {
                SetLoginMessage("Invalid username or password.", "Try again, or create a new account");
                setAutoLogin(false);
            } else if (j == 4) {
                SetLoginMessage("That username is already logged in.", "Wait 60 seconds then retry");
            } else if (j == 5) {
                SetLoginMessage("The client has been updated.", "Please reload this page");
                setAutoLogin(false);
            } else if (j == 6) {
                SetLoginMessage("You may only use 1 character at once.", "Your ip-address is already in use");
            } else if (j == 7) {
                SetLoginMessage("Login attempts exceeded!", "Please try again in 5 minutes");
            } else if (j == 8) {
                SetLoginMessage("Error unable to login.", "Server rejected session");
            } else if (j == 9) {
                SetLoginMessage("Error unable to login.", "Loginserver rejected session");
            } else if (j == 10) {
                SetLoginMessage("That username is already in use.", "Wait 60 seconds then retry");
            } else if (j == 11) {
                SetLoginMessage("Account temporarily disabled.", "Check your message inbox for details");
                setAutoLogin(false);
            } else if (j == 12) {
                SetLoginMessage("Account permanently disabled.", "Check your message inbox for details");
                setAutoLogin(false);
            } else if (j == 14) {
                SetLoginMessage("Sorry! This world is currently full.", "Please try a different world");
                abi = 1500;
            } else if (j == 15) {
                SetLoginMessage("You need a members account", "to login to this world");
                setAutoLogin(false);
            } else if (j == 16) {
                SetLoginMessage("Error - no reply from loginserver.", "Please try again");
            } else if (j == 17) {
                SetLoginMessage("Error - failed to decode profile.", "Contact customer support");
            } else if (j == 20) {
                SetLoginMessage("Error - loginserver mismatch", "Please try a different world");
            } else {
                SetLoginMessage("Error unable to login.", "Unrecognised response code");
            }
            return;
        } catch (Exception exception) {
            System.out.println(String.valueOf(exception));
            exception.printStackTrace();
        }
        if (aai > 0) {
            try {
                Thread.sleep(5000L);
            } catch (Exception _ex) {}
            aai--;
            loginRS(User, Pass, arg2);
        }
        if (arg2) {
            User = "";
            Pass = "";
            add();
        } else {
            SetLoginMessage("Sorry! Unable to connect.", "Check internet settings or try another world");
        }
    }

    protected final void aca() {
        if (Connection != null) {
            try {
                Connection.SendID(2);
                Connection.hdm();
            } catch (IOException _ex) {}
        }
        User = "";
        Pass = "";
        add();
    }

    protected void Reconnect() {
        System.out.println("Lost connection");
        aai = 10;
        loginRS(User, Pass, true);
    }

    protected final void MessageBox(String s1, String s2) {
        Graphics g = getGraphics();
        Font font = new Font("Helvetica", 1, 15);
        char c = '\u0200';
        char c1 = '\u0158';

        g.setColor(Color.black);
        g.fillRect(c / 2 - 140, c1 / 2 - 25, 280, 50);
        g.setColor(Color.white);
        g.drawRect(c / 2 - 140, c1 / 2 - 25, 280, 50);
        WriteString(g, s1, font, c / 2, c1 / 2 - 10);
        WriteString(g, s2, font, c / 2, c1 / 2 + 10);
    }

    protected final void acd() {
        long l = System.currentTimeMillis();

        if (Connection.hda()) {
            aaj = l;
        }
        if (l - aaj > 5000L) {
            aaj = l;
            Connection.SendID(3);
            Connection.End();
        }
        try {
            Connection.hdd(20);
        } catch (IOException _ex) {
            Reconnect();
            return;
        }
        int i = Connection.hdi(aah);

        if (i > 0) {
            ace(aah[0] & 0xff, i);
        }
    }

    private final void ace(int arg0, int arg1) // Server input
    {
        arg0 = mudclient.fixID(Connection.hdc(arg0), false);
        if (arg0 == 0) {
            String s1 = new String(aah, 1, arg1 - 1);

            DisplayStr(s1);
        }
        if (arg0 == 1) {
            aca();
        }
        if (arg0 == 2) {
            ade();
            return;
        }
        if (arg0 == 3) {
            FriendCount = t.fmh(aah[1]);
            for (int i = 0; i < FriendCount; i++) {
                FriendList[i] = t.fmk(aah, 2 + i * 9);
                FriendServer[i] = t.fmh(aah[10 + i * 9]);
            }
            SortFriendList();
            return;
        }
        if (arg0 == 4) {
            long l = t.fmk(aah, 1);
            int k = aah[9] & 0xff;

            for (int j1 = 0; j1 < FriendCount; j1++) {
                if (FriendList[j1] == l) {
                    if (FriendServer[j1] == 0 && k != 0) {
                        DisplayStr("@pri@" + t.PlayerLongToName(l) + " has logged in");
                    }
                    if (FriendServer[j1] != 0 && k == 0) {
                        DisplayStr("@pri@" + t.PlayerLongToName(l) + " has logged out");
                    }
                    FriendServer[j1] = k;
                    arg1 = 0;
                    SortFriendList();
                    return;
                }
            }
            FriendList[FriendCount] = l;
            FriendServer[FriendCount] = k;
            FriendCount++;
            SortFriendList();
            return;
        }
        if (arg0 == 5) {
            IgnoreCount = t.fmh(aah[1]);
            for (int j = 0; j < IgnoreCount; j++) {
                IgnoreList[j] = t.fmk(aah, 2 + j * 8);
            }
            return;
        }
        if (arg0 == 6) {
            abb = aah[1];
            abc = aah[2];
            abd = aah[3];
            abe = aah[4];
            return;
        }
        if (arg0 == 7) {
            long l1 = t.fmk(aah, 1);
            int i1 = t.fmj(aah, 9);

            for (int k1 = 0; k1 < 100; k1++) {
                if (abl[k1] == i1) {
                    return;
                }
            }
            abl[abm] = i1;
            abm = (abm + 1) % 100;
            String s2 = u.fgd(v.cej(aah, 13, arg1 - 13));

            DisplayStr("@pri@" + t.PlayerLongToName(l1) + ": tells you " + s2);
            OnPrivateMessage(t.PlayerLongToName(l1), mudclient.trimColours(s2));
            return;
        } else {
            adf(arg0, arg1, aah);
        }
    }

    private final void SortFriendList() {
        boolean flag = true;

        while (flag) {
            flag = false;
            for (int i = 0; i < FriendCount - 1; i++) {
                if (FriendServer[i] != 255 && FriendServer[i + 1] == 255
                        || FriendServer[i] == 0 && FriendServer[i + 1] != 0) {
                    int j = FriendServer[i];

                    FriendServer[i] = FriendServer[i + 1];
                    FriendServer[i + 1] = j;
                    long l = FriendList[i];

                    FriendList[i] = FriendList[i + 1];
                    FriendList[i + 1] = l;
                    flag = true;
                }
            }
        }
    }

    protected final void acg(int i, int j, int k, int l) {
        Connection.SendID(4);
        Connection.SendVar(i);
        Connection.SendVar(j);
        Connection.SendVar(k);
        Connection.SendVar(l);
        Connection.End();
    }

    protected final void AddIgnore(String arg0) {
        long l = t.PlayerNameToLong(arg0);

        Connection.SendID(5);
        Connection.hdl(l);
        Connection.End();
        for (int i = 0; i < IgnoreCount; i++) {
            if (IgnoreList[i] == l) {
                return;
            }
        }
        if (IgnoreCount < IgnoreList.length) {
            IgnoreList[IgnoreCount++] = l;
        }
    }

    protected final void RemoveIgnore(long arg0) {
        Connection.SendID(6);
        Connection.hdl(arg0);
        Connection.End();
        for (int i = 0; i < IgnoreCount; i++) {
            if (IgnoreList[i] == arg0) {
                IgnoreCount--;
                for (int j = i; j < IgnoreCount; j++) {
                    IgnoreList[j] = IgnoreList[j + 1];
                }
                return;
            }
        }
    }

    protected final void AddFriend(String arg0) {
        Connection.SendID(7);
        Connection.hdl(t.PlayerNameToLong(arg0));
        Connection.End();
        long l = t.PlayerNameToLong(arg0);

        for (int i = 0; i < FriendCount; i++) {
            if (FriendList[i] == l) {
                return;
            }
        }
        if (FriendCount < FriendList.length) {
            FriendList[FriendCount] = l;
            FriendServer[FriendCount] = 0;
            FriendCount++;
        }
    }

    protected final void RemoveFriend(long arg0) {
        Connection.SendID(8);
        Connection.hdl(arg0);
        Connection.End();
        for (int i = 0; i < FriendCount; i++) {
            if (FriendList[i] != arg0) {
                continue;
            }
            FriendCount--;
            for (int j = i; j < FriendCount; j++) {
                FriendList[j] = FriendList[j + 1];
                FriendServer[j] = FriendServer[j + 1];
            }
            break;
        }
        DisplayStr("@pri@" + t.PlayerLongToName(arg0) + " has been removed from your friends list");
    }

    protected final void SendPM(long l, byte abyte0[], int i) {
        Connection.SendID(9);
        Connection.hdl(l);
        Connection.hdf(abyte0, 0, i);
        Connection.End();
    }

    protected final void SendChat(byte abyte0[], int i) {
        Connection.SendID(10);
        Connection.hdf(abyte0, 0, i);
        Connection.End();
    }

    protected final void acn(String s1) {
        Connection.SendID(11);
        Connection.SendString(s1);
        Connection.End();
    }

    protected void SetLoginMessage(String s1, String s2) {}

    protected void adb() {}

    protected void adc() {}

    protected void add() {}

    protected void ade() {}

    protected void adf(int i, int j, byte abyte0[]) {}

    protected void DisplayStr(String s1) {}

    protected void OnChatMessage(String sender, String message) {}
    
    protected void OnPrivateMessage(String sender, String message) {}

    protected int adi() {
        return 0;
    }

    public Login() {
        IP = "uk1.runescape.com";
        Port = 43594;
        User = "";
        Pass = "";
        aah = new byte[5000];
        FriendList = new long[200];
        FriendServer = new int[200];
        IgnoreList = new long[100];
        abl = new int[100];
    }
    public static int aab;
    public String IP;
    public int Port;
    String User;
    String Pass;
    public Connect Connection;
    byte aah[];
    int aai;
    long aaj;
    public int FriendCount;
    public long FriendList[];
    public int FriendServer[];
    public int IgnoreCount;
    public long IgnoreList[];
    public int abb;
    public int abc;
    public int abd;
    public int abe;
    private static BigInteger abf = new BigInteger(
            "58778699976184461502525193738213253649000149147835990136706041084440742975821");
    private static BigInteger abg = new BigInteger(
            "7162900525229798032761816791230527296329313291232324290237849263501208207972894053929065636522363163621000728841182238772712427862772219676577293600221789");
    public int abi;
    public int abj;
    private int abl[];
    private int abm;
}
