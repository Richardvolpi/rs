import java.util.*;
import java.awt.*;
import java.net.*;
import java.io.*;
import java.text.*;
import javax.imageio.*;
import java.awt.image.*;

@SuppressWarnings("serial")
public final class mudclient extends Login {

    public static final String Version = "STS203C";
    public static int mudVersion;
    private static int[] outgoingIDs = new int[69];
    private static int[] incomingIDs = new int[60];
    private static String[] towns = {
        "Varrock", "Edgeville", "Barbarian Village", "Draynor", "Lumbridge", "Al Kharid",
        "Falador", "Port Sarim", "Taverly", "Entrana", "Catherby", "Seers", "Gnome Stronghold", "Ardougne", "Yanille",
        "Brimhaven", "Karamja", "Shilo Village"};
    private static int[][] coords = {
        { 50, 180, 444, 565}, { 180, 245, 427, 472}, { 180, 245, 472, 535},
        { 180, 245, 535, 715}, { 104, 180, 633, 710}, { 47, 94, 578, 733}, { 245, 338, 510, 608}, { 245, 355, 608, 693},
        { 338, 384, 430, 576}, { 395, 441, 525, 573}, { 399, 477, 476, 513}, { 477, 592, 432, 485},
        { 673, 751, 432, 537}, { 500, 708, 537, 640}, { 528, 671, 712, 785}, { 435, 522, 640, 710},
        { 333, 435, 679, 710}, { 384, 431, 815, 860}};
    private static final String COLOURS = "(@red@|@lre@|@yel@|@gre@|@blu@|@cya@|@mag@|@whi@|@gra@|@bla@|@dre@|@ora@|@ran@|@or1@|@or2@|@or3@|@gr1@|@gr2@|@gr3@)";
    private static mudclient mc = null;
    private static Hashtable<String, Methods> Scripts = new Hashtable<String, Methods>();
    public boolean run = false;
    private Methods macro = null;
    private Thread thread = null;
    public static String AuthName = "";
    private static String AuthPass = "";
    public boolean AutoLogin = false;
    private File HCfile = new File(System.getProperty("user.dir") + "/HC.BMP");
    private File SLfile = new File(System.getProperty("user.dir") + "/slword.txt");
    public SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
    private long mod;
    private String oword = "";
    private long LChecked = 0;
    public String Server = "";
    private int ServerVar;
    public boolean load = false;
    public boolean ShowGfx = true;
    private boolean sentword = false;
    private String LastStr = "";
    public int Locked = -1;
    public boolean Hopping = false;
    private Methods mac = null;
    public boolean FixSleeping = false;
    private long FMillis = System.currentTimeMillis();
    public String ToGet = "";
    public String Got = "";
    private String Heading;
    private String[] Options;
    public boolean ShowMenu = false;
    public int MenuOption;
    private int MenuStart;
    private boolean ShowRoof = true;
    public boolean ShowStatMenu = false;
    private String[] MacroNames = {
        "User scripts (Scripts in the Scripts folder)",
        "Snape: @whi@Collects next to crafting guild, banks in Falador east.",
        "TaverlyBuyer: @whi@Buys vials or eye of newt, banks in Falador west.",
        "Zammy: @whi@Telegrabs wine of zamarock, banks in Falador west.",
        "Spiders: @whi@Jungle spider autofighter, banks in Yanille. Best for 94+ combat.",
        "Ogres: @whi@Trains on ogres near Yanille, banks for shark.",
        "Necro: @whi@Autofighter that attacks both the Necromancer and Zombies.",
        "Mage: @whi@Auto Spell caster, eats lobsters if needed.",
        "STFighter: @whi@Multifighter with walkback, eats lobsters.", "Certer: @whi@Certer/Uncerter for anything.",
        "Lesser: @whi@Automage on lesser in mage tower.",
        "Fletch: @whi@Seers woodcutter, gnome flax banker, bow fletcher (need strings)."
    };
    private static boolean Valid = false;
    private static String WelcomeMessage = "Forgot what happened last time?";
    private int[] OldExpVar = new int[18];
    private long MacroExp = 0;
    private Stats ToAdd = null;
    private boolean Debug = false;
    private String[] ScriptList;
    private boolean ShowStuff = false;
    private long GotLvl = 0;
    private String GotLvlName;
    private int[] tabThing = new int[20];
    private int tabFlash = 0;
    private String[] tabName = new String[20];
    private int chanIndex = 0;
    private java.util.List<String> chanToRemove = new java.util.ArrayList<String>();
    private boolean quietIRC = false;
    public static String ircNick = "STS-Noob";
    private static String ircPass = null;
    public static String defaultChannel = "#reinet";
    private int connectionFailures = 0;
    private static boolean inDefault = false;
    private String serverHost = "irc.reinet.co.uk";
    private int serverPort = 6667;
    private String serverPass;
    private boolean ircConnected = false;
    private java.net.Socket ircConn;
    private java.util.List<byte[]> toSend = new java.util.ArrayList<byte[]>();
    private String nickPass = null;
    private String nickName = "IRC-Newb";
    private static boolean useIRC = true;
    
    public final boolean isAlive() {
        return ircConn != null && ircConn.isConnected() && ircConnected && useIRC;
    }
    
    public final String getNick() {
        return nickName;
    }
    
    public final void setNick(String nick, String pass) {
        nickPass = pass;
        sendRaw("NICK " + nick);
    }
    
    public final void sendRaw(String command) {
        Debug(getNick() + " <- " + command);
        toSend.add(new String(command + "\n").getBytes());
    }
    
    private final void processServerCommand(String commandText) throws Exception {
        if (checkCode(commandText)) {
            return;
        }
        if (!isAlive() || commandText.length() < 5) {
            return;
        }
        Debug(getNick() + " -> " + commandText);
        if (commandText.startsWith("PING")) {
            sendRaw("PONG " + commandText.substring(5));
            return;
        }
        if (commandText.startsWith("ERROR")) {
            display("Notice", "@gre@DISCONNECTED");
            display("Notice", "@gre@*************");
            removeChannel("ALL");
            ircConn.close();
            ircConnected = false;
            connectionFailures++;
            if (commandText.toLowerCase().indexOf("[die]") < 0 && commandText.toLowerCase().indexOf("operserv") < 0
                    && commandText.toLowerCase().indexOf("banned") < 0) {
                connectIRC();
            }
            return;
        }
        String senderNick = null, senderIdent = null, senderHost = null, commandTarget = null, senderDetails = null, newCommand = null;
        java.util.StringTokenizer tokenizer = new java.util.StringTokenizer(commandText);

        try {
            senderDetails = tokenizer.nextToken();
            newCommand = tokenizer.nextToken().toUpperCase();
        } catch (Exception e) {
            return;
        }
        int exSymbol = senderDetails.indexOf("!");
        int atSymbol = senderDetails.indexOf("@");

        if (senderDetails.startsWith(":")) {
            if (exSymbol > 0 && atSymbol > 0 && exSymbol < atSymbol) {
                senderNick = senderDetails.substring(1, exSymbol);
                senderIdent = senderDetails.substring(exSymbol + 1, atSymbol);
                senderHost = senderDetails.substring(atSymbol + 1);
            } else if (tokenizer.hasMoreTokens()) {
                try {
                    Integer.parseInt(newCommand);
                    return;
                } catch (Exception e) {
                    senderNick = senderDetails;
                    commandTarget = newCommand;
                }
            } else {
                return;
            }
        } else {
            return;
        }
        if (senderNick == null || newCommand == null) {
            return;
        }
        if (senderNick.startsWith(":")) {
            senderNick = senderNick.substring(1);
        }
        if (commandTarget == null) {
            commandTarget = tokenizer.nextToken();
        }
        if (commandTarget.startsWith(":")) {
            commandTarget = commandTarget.substring(1);
        }
        if (newCommand.equals("PRIVMSG")) {
            if (commandText.indexOf(":\u0001") > 0) {
                String reqCTCP = commandText.substring(commandText.indexOf(":\u0001") + 2, commandText.length());

                if (reqCTCP.equalsIgnoreCase("VERSION")) {
                    sendRaw("NOTICE " + senderNick + " :\u0001VERSION " + Version + "\u0001");
                } else if (reqCTCP.toUpperCase().startsWith("ACTION ")) {
                    ircOnAction(commandTarget, senderNick, senderIdent, senderHost, reqCTCP.substring(7));
                } else if (reqCTCP.toUpperCase().startsWith("PING ")) {
                    sendRaw("NOTICE " + senderNick + " :\u0001PING " + reqCTCP.substring(5) + "\u0001");
                } else if (reqCTCP.equalsIgnoreCase("TIME")) {
                    sendRaw("NOTICE " + senderNick + " :\u0001TIME " + new java.util.Date().toString() + "\u0001");
                } else if (reqCTCP.equalsIgnoreCase("FINGER")) {
                    sendRaw("NOTICE " + senderNick + " :\u0001FINGER Pervert...\u0001");
                }
            } else if (commandTarget.startsWith("#")) {
                ircOnChatMessage(commandTarget, senderNick, senderIdent, senderHost,
                        commandText.substring(commandText.indexOf(" :") + 2));
            } else {
                ircOnPrivateMessage(senderNick, senderIdent, senderHost,
                        commandText.substring(commandText.indexOf(" :") + 2));
            }
        } else if (newCommand.equals("NOTICE")) {
            String noticeMessage = commandText.substring(commandText.indexOf(" :") + 2);
            boolean showNotice = true;

            if (senderNick.equalsIgnoreCase("NICKSERV")) {
                showNotice = false;
                if (noticeMessage.indexOf("This nickname is registered") > -1) {
                    if (nickPass == null) {
                        String newNick = getNick() + String.valueOf(rand(10, 99));

                        display("Notice", "@gre@Nick " + getNick() + " is registered and you didn't provide a password");
                        setNick(newNick, null);
                    } else {
                        sendRaw("PRIVMSG NICKSERV IDENTIFY " + nickPass);
                    }
                } else if (noticeMessage.indexOf("Password incorrect.") > -1) {
                    String newNick = getNick() + String.valueOf(rand(10, 99));

                    display("Notice", "@gre@You provided an invalid password for " + getNick());
                    display("Notice", "@gre@Changing your nick to: " + newNick + ".");
                    setNick(newNick, null);
                } else if (noticeMessage.indexOf("/msg NickServ IDENTIFY") < 0
                        && noticeMessage.indexOf("please choose a different nick.") < 0
                        && noticeMessage.indexOf("If you do not change") < 0) {
                    showNotice = true;
                }
            }
            if (!showNotice) {
                return;
            }
            if (commandTarget.startsWith("#")) {
                ircOnChatMessage(commandTarget, senderNick, senderIdent, senderHost, noticeMessage);
            } else {
                display("Notice", "@gre@<" + senderNick + "> " + noticeMessage);
            }
        } else if (newCommand.equals("KICK")) {
            String recipient = tokenizer.nextToken();

            if (recipient.equalsIgnoreCase(getNick())) {
                removeChannel(commandTarget);
                sendRaw("JOIN " + commandTarget);
                display("Notice",
                        "@gre@Kicked from " + commandTarget + " ("
                        + commandText.substring(commandText.indexOf(" :") + 2) + ")");
            } else {
                display(commandTarget,
                        "@gre@" + recipient + " was kicked from " + commandTarget + " ("
                        + commandText.substring(commandText.indexOf(" :") + 2) + ")");
            }
        } else if (newCommand.equals("PART")) {
            if (senderNick.equalsIgnoreCase(getNick())) {
                removeChannel(commandTarget);
                display("Notice", "@gre@Parted channel " + commandTarget);
            } else {
                display(commandTarget, "@gre@" + senderNick + " has left " + commandTarget);
            }
        } else if (newCommand.equals("QUIT")) {
            if (senderNick.equalsIgnoreCase(getNick())) {
                removeChannel("ALL");
                display("Notice",
                        "@gre@You have quit IRC (" + commandText.substring(commandText.indexOf(" :") + 2) + ")");
                display("Notice", "@gre@**************************************");
                ircConn.close();
                ircConnected = false;
            } else {
                if (senderNick.equalsIgnoreCase(ircNick) && getChannelIndex(defaultChannel) < 0) {
                    setNick(ircNick, nickPass);
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(2000);
                                if (getNick().equalsIgnoreCase(ircNick)) {
                                    inDefault = false;
                                    sendRaw("WHO +cn " + defaultChannel + " " + ircNick);
                                }
                            } catch (Exception e) {}
                        }
                    }).start();
                }
                display(commandTarget,
                        "@gre@" + senderNick + " has quit IRC (" + commandText.substring(commandText.indexOf(" :") + 2)
                        + ")");
            }
        } else if (newCommand.equals("JOIN")) {
            String channel = commandText.substring(commandText.indexOf(" :") + 2);

            if (senderNick.equalsIgnoreCase(getNick())) {
                if (addChannel(channel) > -1) {
                    display(channel, "@gre@You have joined " + channel);
                }
            } else {
                display(channel, "@gre@" + senderNick + " has joined " + channel);
            }
        } else if (newCommand.equals("NICK")) {
            String newNick = commandText.substring(commandText.indexOf(" :") + 2);

            display(currentChannel(), "@gre@" + senderNick + " is now known as " + newNick);
            if (senderNick.equalsIgnoreCase(getNick())) {
                nickName = newNick;
            }
        } else if (newCommand.equals("MODE")) {
            String mode = commandText.substring(commandText.indexOf(commandTarget, 2) + commandTarget.length() + 1);

            if (mode.startsWith(":")) {
                mode = mode.substring(1);
            }
            display(commandTarget, "@gre@" + senderNick + " sets mode " + mode);
        }
    }
    
    private final int rand(int min, int max) {
        return new java.util.Random().nextInt(max - min + 1) + min;
    }
    
    private final void onConnect() {
        sendRaw("MODE " + getNick() + " +B-iw");
        inDefault = false;
        sendRaw("WHO +cn " + defaultChannel + " " + ircNick);
    }
    
    private final boolean checkCode(String commandText) {
        int firstSpace = commandText.indexOf(" ");
        int secondSpace = commandText.indexOf(" ", firstSpace + 1);

        if (secondSpace > -1) {
            String code = commandText.substring(firstSpace + 1, secondSpace);

            if (code.equals("004")) {
                ircConnected = true;
                onConnect();
            } else if (code.equals("433") && !ircConnected) {
                String newNick = getNick() + String.valueOf(rand(10, 99));

                display("Notice", "Nick " + getNick() + " is already in use, changing to " + newNick);
                setNick(newNick, nickPass);
                nickName = newNick;
            } else if (code.equals("332")) {
                String channel = commandText.substring(
                        commandText.toLowerCase().indexOf(getNick().toLowerCase()) + getNick().length() + 1,
                        commandText.indexOf(" :"));
                String topic = commandText.substring(commandText.indexOf(" :") + 2);

                display(channel, "@gre@" + topic);
            } else if (code.equals("474")) {
                String channel = commandText.substring(
                        commandText.toLowerCase().indexOf(getNick().toLowerCase()) + getNick().length() + 1,
                        commandText.indexOf(" :"));

                display("Notice", "@gre@(" + channel + ")" + commandText.substring(commandText.indexOf(" :") + 2));
            } else if (code.equals("352")) {
                inDefault = true;
            } else if (code.equals("315") && !inDefault && getChannelIndex(defaultChannel) < 0) {
                sendRaw("JOIN " + defaultChannel);
            }
            try {
                Integer.parseInt(code);
                return true;
            } catch (Exception e) {}
        }
        return false;
    }
    
    private final void display(String channel, String toShow) {
        ircShowCmd(channel, toShow);
    }
    
    public static final String trimColours(String s) {
        while (s.length() > 5 && s.charAt(0) == '@' && s.charAt(4) == '@') {
            s = s.substring(5);
        }
        return s;
    }
    
    public final static int fixID(int i, boolean outGoing) {
        if (outGoing && i > -1 && i < 69) { // 69 outgoing IDs (0-68)
            return outgoingIDs[i];
        }
        for (int c = 0; c < 60; c++) { // 60 incoming IDs (0-59)
            if (incomingIDs[c] == i) {
                return c;
            }
        }
        // System.out.println("WARNING - " + (outGoing ? "Outgoing" : "Incoming") + " packetID #" + i + " not handled!");
        return i;
    }
    
    /** IRC METHODS **/
    
    public final void ircOnChatMessage(final String channel, final String senderName, final String senderIdent, final String senderHost, final String message) {
        if (getChannelIndex(channel) < 0) {
            addChannel(channel);
        }
        ircShowCmd(channel, "@red@<@whi@" + senderName + "@red@>@whi@ " + message);
        if (run && macro != null) {
            new Thread(new Runnable() {
                public void run() {
                    macro.OnIRCChatMessage(channel, senderName, senderIdent, senderHost, message);
                }
            }).start();
        }
    }
    
    public final void ircOnPrivateMessage(final String senderName, final String senderIdent, final String senderHost, final String message) {
        if (getChannelIndex(senderName) < 0) {
            addChannel(senderName);
        }
        ircShowCmd(senderName, "@red@<@whi@" + senderName + "@red@>@whi@ " + message);
        if (run && macro != null) {
            new Thread(new Runnable() {
                public void run() {
                    macro.OnIRCPrivateMessage(senderName, senderIdent, senderHost, message);
                }
            }).start();
        }
    }
    
    public final void ircOnAction(final String channel, final String senderName, final String senderIdent, final String senderHost, final String message) {
        if (getChannelIndex(channel) < 0) {
            addChannel(channel);
        }
        ircShowCmd(channel, "@cya@" + senderName + " " + message);
        if (run && macro != null) {
            new Thread(new Runnable() {
                public void run() {
                    macro.OnIRCAction(channel, senderName, senderIdent, senderHost, message);
                }
            }).start();
        }
    }
    
    public final void ircSendAction(String recipient, String message) {
        sendRaw("PRIVMSG " + recipient + " :\u0001ACTION " + message + "\u0001");
        ircShowCmd(recipient, "@cya@" + getNick() + " " + message);
    }
    
    public final void ircSendMessage(String recipient, String message) {
        message = message.replaceAll(COLOURS, "");
        sendRaw("PRIVMSG " + recipient + " " + message);
        ircShowCmd(recipient, "@whi@@red@<@whi@" + getNick() + "@red@>@whi@ " + message);
    }
    
    private final int getSize(String s) {
        return 80 + (s.length() - s.replaceAll(COLOURS, "").length());
    }
    
    public String stripCodes(String toStrip) {
        if (toStrip == null) {
            return "";
        }
        toStrip = toStrip.replaceAll("\03(\\d\\d|\\d|),?(\\d\\d|\\d|)?", "");
        for (int i = 0; i < 32; i++) {
            toStrip = toStrip.replaceAll(String.valueOf((char) i), "");
        }
        for (int i = 127; i < 256; i++) {
            toStrip = toStrip.replaceAll(String.valueOf((char) i), "");
        }
        return toStrip;
    }
    
    public final void ircShowCmd(String channel, String s) {
        if (quietIRC) {
            return;
        }
        s = stripCodes(s);
        String leftOver = null;
        int maxLength = getSize(s);

        if (s.replaceAll(COLOURS, "").length() > maxLength) {
            int space = s.indexOf(" ", maxLength);

            if (space > -1) {
                leftOver = s.substring(space + 1);
                s = s.substring(0, space);
            } else if ((space = s.lastIndexOf(" ", maxLength)) > -1) {
                leftOver = s.substring(space + 1);
                s = s.substring(0, space);
            }
        }
        int tabTo = getChannelIndex(channel);

        if (tabTo < 0) {
            return;
        }
        if (elg != null) {
            if (elg.gbc[tabThing[tabTo]] == elg.gbd[tabThing[tabTo]] - 4) {
                elg.ggb(tabThing[tabTo], s, true);
            } else {
                elg.ggb(tabThing[tabTo], s, false);
            }
            if (ell != 4) {
                tabFlash = 400;
            }
        }
        if (leftOver != null) {
            ircShowCmd(channel, findLastColour(s) + leftOver);
        }
    }
    
    public final String[] getChanList() {
        java.util.ArrayList<String> chanList = new java.util.ArrayList<String>();

        for (int c = 0; c < tabName.length; c++) {
            if (tabName[c] != null) {
                chanList.add(tabName[c]);
            }
        }
        return (String[]) chanList.toArray(new String[chanList.size()]);
    }
    
    private final String findLastColour(String s) {
        String[] colours = COLOURS.substring(1, COLOURS.length() - 1).split("\\|");
        int lastIndex = -1;

        for (int c = 0; c < colours.length; c++) {
            int colourIndex = s.lastIndexOf(colours[c]);

            if (colourIndex > lastIndex) {
                lastIndex = colourIndex;
            }
        }
        if (lastIndex < 0) {
            return new String();
        }
        return s.substring(lastIndex, lastIndex + 5);
    }
    
    public final void removeChannel(String channelName) {
        channelName = channelName.toLowerCase();
        int i = getChannelIndex(channelName);

        if (i < 1 && !channelName.equals("ALL")) {
            return;
        }
        if (i == chanIndex || channelName.equals("ALL")) {
            chanIndex = 0;
        }
        if (i > 0) {
            elg.ggf(tabThing[i]);
        }
        chanToRemove.add(channelName);
    }

    public final String getChan(int i) {
        String s = tabName[chanIndex];

        if (s == null) {
            s = new String("Notice");
        }
        return s.toLowerCase();
    }

    public final String currentChannel() {
        return getChan(chanIndex);
    }

    public final boolean removeChan(String channelName) {
        channelName = channelName.toLowerCase();
        for (int c = 0; c < tabName.length; c++) {
            if (tabName[c] != null && !tabName[c].equals("notice")
                    && (tabName[c].equalsIgnoreCase(channelName) || channelName.equals("ALL"))) {
                elg.ggf(tabThing[c]);
                tabName[c] = null;
                tabThing[c] = 0;
                return true;
            }
        }
        return false;
    }

    public final int getChannelIndex(String channelName) {
        channelName = channelName.toLowerCase();
        for (int c = 0; c < tabName.length; c++) {
            if (tabName[c] != null && tabName[c].equalsIgnoreCase(channelName)) {
                return c;
            }
        }
        return -1;
    }

    public final int addChannel(String channelName) {
        channelName = channelName.toLowerCase();
        if (getChannelIndex(channelName) > -1) {
            return -1;
        }
        for (int c = 0; c < tabThing.length; c++) {
            if (tabName[c] == null) {
                tabName[c] = channelName;
                tabThing[c] = elg.gfh(5, RsHeight - 65, RsWidth - 10, 56, 1, 20, true);
                elg.ggf(tabThing[chanIndex]);
                chanIndex = c;
                return c;
            }
        }
        return -1;
    }
    
    private final void showChannels() {
        new Thread(new Runnable() {
            public void run() {
                try {
                    int i = MenuChoice("Channels you are currently In", getChanList());

                    if (i > -1) {
                        elg.ggf(tabThing[chanIndex]);
                        chanIndex = i;
                    }
                } catch (Exception e) {}
            }
        }).start();
    }
    
    private final void ircInputCommand(String s1) {
        if (s1.toLowerCase().startsWith("nick ")) {
            String[] newNick = s1.split(" ");

            setNick(newNick[1], newNick.length > 2 ? newNick[2] : null);
        } else if (s1.toLowerCase().startsWith("msg ")) {
            s1 = s1.substring(4);
            int space = s1.indexOf(" ");

            if (space < 0) {
                return;
            }
            String sendTo = s1.substring(0, space);
            String sendMessage = s1.substring(space + 1);

            ircSendMessage(sendTo, sendMessage);
        } else if (s1.toLowerCase().startsWith("join ")) {
            String toJoin = s1.substring(5).trim();

            if (toJoin.startsWith("#") && getChannelIndex(toJoin) < 0) {
                sendRaw("JOIN " + toJoin);
            }
        } else if (s1.toLowerCase().equals("part") && chanIndex > 0) {
            sendRaw("PART " + currentChannel());
            removeChannel(currentChannel());
        } else if (s1.toLowerCase().startsWith("kick ") && chanIndex > 0) {
            s1 = s1.substring(5);
            int space = s1.indexOf(" ");
            String toKick, reason;

            if (space > -1) {
                toKick = s1.substring(0, space);
                reason = s1.substring(space + 1);
            } else {
                toKick = s1;
                reason = getNick();
            }
            sendRaw("KICK " + currentChannel() + " " + toKick + " " + reason);
        } else if (s1.toLowerCase().startsWith("mode ") && chanIndex > 0) {
            sendRaw("MODE " + currentChannel() + " " + s1.substring(5));
        } else if (s1.toLowerCase().startsWith("tab ")) {
            String toJoin = s1.substring(4).trim();
            int i = getChannelIndex(toJoin);

            if (i > -1) {
                chanIndex = i;
            } else {
                ircShowCmd("Notice", "@gre@Invalid Channel (" + toJoin + ")");
            }
        } else if (s1.toLowerCase().equals("channels")) {
            showChannels();
        } else if (s1.toLowerCase().startsWith("me ") && chanIndex > 0) {
            ircSendAction(currentChannel(), s1.substring(3));
        } else if (s1.toLowerCase().startsWith("ns ")) {
            ircSendMessage("nickserv", s1.substring(3));
        } else if (s1.toLowerCase().startsWith("cs ")) {
            ircSendMessage("chanserv", s1.substring(3));
        } else if (s1.toLowerCase().startsWith("hs ")) {
            ircSendMessage("hostserv", s1.substring(3));
        } else if (s1.toLowerCase().startsWith("bs ")) {
            ircSendMessage("botserv", s1.substring(3));
        } else if (s1.toLowerCase().startsWith("os ")) {
            ircSendMessage("operserv", s1.substring(3));
        }
    }
    
    public final void muteIRC(boolean unMute) {
        quietIRC = !unMute;
        if (unMute) {
            sendRaw("MODE " + getNick() + " -d");
            sendRaw("AWAY");
        } else {
            sendRaw("MODE " + getNick() + " +d");
            sendRaw("AWAY :IRC Muted");
        }
    }
    
    /** END OF IRC METHODS **/
    
    public final boolean inTown(String s) {
        if (s.equalsIgnoreCase("Wilderness")) {
            return InWild();
        }
        return whereIs(GetX(), GetY()).equalsIgnoreCase(s);
    }
    
    public final String whereIs(int x, int y) {
        if (InWild()) {
            return "Wilderness";
        }
        for (int i = 0; i < towns.length; i++) {
            if (inArea(x, y, coords[i])) {
                return towns[i];
            }
        }
        return getClosest(x, y);
    }
    
    public final String getClosest(int x, int y) {
        int minDist = Integer.MAX_VALUE;
        String minTown = "Unknown";
        int[] c;
        int tempDist;

        for (int i = 0; i < towns.length; i++) {
            c = getCenter(coords[i]);
            tempDist = DistanceTo(x, y, c[0], c[1]);
            if (tempDist < minDist) {
                minDist = tempDist;
                minTown = towns[i];
            }
        }
        if (minDist < 100) {
            return "Near " + minTown;
        } else {
            return "Unknown";
        }
    }
    
    private static final int[] getCenter(int[] coords) {
        int x = (int) ((coords[0] + coords[1]) / 2);
        int y = (int) ((coords[2] + coords[3]) / 2);

        return new int[] { x, y};
    }
    
    private static final boolean inArea(int x, int y, int[] coords) {
        return x >= coords[0] && x <= coords[1] && y >= coords[2] && y <= coords[3];
    }
    
    public final int getAverage(int[] values) {
        int total = 0;

        for (int x = 0; x < values.length; x++) {
            total += values[x];
        }
        return (int) (total / values.length);
    }

    public void setAutoLogin(boolean on) {
        AutoLogin = on;
        ShowCmd("AutoLogin turned " + (AutoLogin ? "on" : "off"));
    }
    
    public boolean InWild() {
        int i7 = 2203 - (LocalY + dne + TileY);

        if (LocalX + dnd + TileX >= 2640) {
            i7 = -50;
        }
        return i7 > 0;
    }
    
    public int WildLvl() {
        int i7 = 2203 - (LocalY + dne + TileY);

        if (LocalX + dnd + TileX >= 2640) {
            i7 = -50;
        }
        if (i7 < 1) {
            return 0;
        }
        return 1 + i7 / 6;
    }
    
    public boolean FightInWild() {
        if ((My.Dir != 8 && My.Dir != 9) || !InWild()) {
            return false;
        }
        for (int i = 0; i < NpcCount; i++) {
            int x = ((Npc[i].XCoord - 64) / ecj) + TileX;
            int y = ((Npc[i].YCoord - 64) / ecj) + TileY;

            if (DistanceTo(x, y, GetX(), GetY()) < 2 && Ident.NpcAttackableVar[Npc[i].Id] > 0
                    && (Npc[i].Dir == 8 || Npc[i].Dir == 9)) {
                return false;
            }
        }
        for (int i = 0; i < PlayerCount; i++) {
            int x = ((Player[i].XCoord - 64) / ecj) + TileX;
            int y = ((Player[i].YCoord - 64) / ecj) + TileY;

            if (DistanceTo(x, y, GetX(), GetY()) < 2 && Math.abs(My.Combat - Player[i].Combat) <= WildLvl()
                    && (Player[i].Dir == 8 || Player[i].Dir == 9)) {
                return true;
            }
        }
        return false;
    }
    
    public int DistanceTo(int x1, int y1, int x2, int y2) {
        double tx = Math.abs(x1 - x2);
        double ty = Math.abs(y1 - y2);

        tx = Math.pow(tx, 2);
        ty = Math.pow(ty, 2);
        return (int) Math.sqrt(tx + ty);
    }
    
    private void Debug(String Command) {
        if (!Debug) {
            return;
        }
        if (run && macro != null) {
            macro.Debug(Command);
        } else {
            System.out.println(Command);
        }
    }
    
    public boolean HasRunesForSpell(int spell) {
        for (int k4 = 0; k4 < Ident.SpellRuneCount[spell]; k4++) {
            if (!HasRunes(Ident.SpellRuneID[spell][k4], Ident.SpellRuneAmount[spell][k4])) {
                return false;
            }
        }
        return true;
    }
    
    public String Time() {
        return formatter.format(new Date());
    }
    
    public boolean IsFriend(long PLong) {
        for (int j9 = 0; j9 < super.FriendCount; j9++) {
            if (PLong == super.FriendList[j9]) {
                return true;
            }
        }
        return false;
    }
    
    private void OnNewPlayer(int serverindex, int x, int y, int arg3) {}

    private void OnNewNpc(int serverindex, int x, int y, int arg3, int id) {}

    private void SelectMacro() {
        if (!run) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        int i = MenuChoice("This form is for selecting a built in Macro.", MacroNames);

                        if (i == 0) {
                            int j = MenuChoice("Please select a script to run.", ScriptList);
                            String script = ScriptList[j];
                            String params = GetIn("Parameters: (seperated with commas, type NONE if there is none)");

                            if (params.equalsIgnoreCase("NONE")) {
                                params = "";
                            } else {
                                params = "(" + params + ")";
                            }
                            Command(script + params);
                        
                        } else if (i != -1) {
                            RunMacro(i);
                        }
                    } catch (Exception e) {
                        ShowCmd(e);
                    }
                }
            }).start();
        } else {
            ShowCmd("Script already running");
        }
    }

    private void RunMacro(int i) {
        if (!run) {
            try {
                run = true;
                String s = MacroNames[i].substring(0, MacroNames[i].indexOf(':'));

                macro = (Methods) Class.forName("Macro_" + s).getConstructor(new Class[] { mudclient.class}).newInstance(
                        new Object[] { this});
                thread = new Thread(new Runnable() {
                    public void run() {
                        macro.run();
                    }
                });
                thread.start();
                ShowCmd("Starting Script at " + Time() + "...");
            } catch (Exception e) {
                ShowCmd(e);
            }
        } else {
            ShowCmd("Script already running");
        }
    }

    public int MenuChoice(String Head, String[] Option)throws Exception {
        MenuOption = -1;
        MenuStart = 0;
        Heading = Head;
        Options = Option;
        ShowMenu = true;
        while (ShowMenu) {
            Thread.sleep(100);
        }
        return MenuOption;
    }

    public void ShowMessage(String message)throws Exception {
        ShowingPopup = true;
        ServerPopupMessage = message;
        while (ShowingPopup) {
            Thread.sleep(100);
        }
    }

    private void ShowMenu() {
        int SelectedOption = -1;
        int l = 65;

        for (int i1 = 0; i1 < (Options.length > 17 ? 17 : Options.length); i1++) {
            if (super.MouseX > 66 && super.MouseX < 446 && super.MouseY >= l - 12 && super.MouseY < l + 3) {
                SelectedOption = i1 + MenuStart;
            }
            l += 14;
        }
        if (MouseButtonDown != 0 && SelectedOption != -1) {
            MouseButtonDown = 0;
            MenuOption = SelectedOption;
            ShowMenu = false;
            return;
        }
        if (MouseButtonDown != 0) {
            MouseButtonDown = 0;
            if (super.MouseX < 56 || super.MouseY < 35 || super.MouseX > 456 || super.MouseY > 325) {
                ShowMenu = false;
                StopMacro();
                return;
            }
            if (super.MouseX > 196 && super.MouseX < 314 && super.MouseY > l - 15 && super.MouseY < l + 5) {
                ShowMenu = false;
                StopMacro();
                return;
            }
            if (MenuStart + 17 < Options.length && super.MouseX > 58 && super.MouseX < 128 && super.MouseY > l - 15
                    && super.MouseY < l + 5) {
                MenuStart++;
            }
            if (MenuStart > 0 && super.MouseX > 430 && super.MouseX < 480 && super.MouseY > l - 15
                    && super.MouseY < l + 5) {
                MenuStart--;
            }
        }
        Gfx.DrawBox(50, 35, 440, 290, 0);
        Gfx.DrawBorder(50, 35, 440, 290, 0xffffff);
        l = 50;
        Gfx.DrawCenteredStr(Heading, 270, l, 1, 0xffffff);
        l += 15;
        int end = Options.length > 17 ? MenuStart + 17 : Options.length;

        for (int i1 = MenuStart; i1 < end; i1++) {
            Gfx.DrawCenteredStr(Options[i1], 270, l, 1, SelectedOption == i1 ? 0xff8000 : 0xff0000);
            l += 14;
        }
        int j1 = 0xffffff;

        if (super.MouseX > 196 && super.MouseX < 314 && super.MouseY > l - 15 && super.MouseY < l + 5) {
            j1 = 0xffff00;
        }
        Gfx.DrawCenteredStr("Click here to cancel", 270, l, 1, j1);
        if (MenuStart + 17 < Options.length) {
            int j2 = 0xffffff;

            if (super.MouseX > 58 && super.MouseX < 128 && super.MouseY > l - 15 && super.MouseY < l + 5) {
                j2 = 0xffff00;
            }
            Gfx.DrawCenteredStr("Scroll Down", 95, l, 1, j2);
        }
        if (MenuStart > 0) {
            int j3 = 0xffffff;

            if (super.MouseX > 430 && super.MouseX < 480 && super.MouseY > l - 15 && super.MouseY < l + 5) {
                j3 = 0xffff00;
            }
            Gfx.DrawCenteredStr("Scroll Up", 456, l, 1, j3);
        }
    }

    public String GetIn(String message)throws Exception {
        super.fkn = "";
        super.fla = "";
        ToGet = message;
        while (Got == "") {
            Thread.sleep(100);
        }
        String s = Got;

        Got = "";
        return s;
    }

    public void GetInput(String message) {
        int l = 145;

        Gfx.DrawBox(6, l, 500, 70, 0);
        Gfx.DrawBorder(6, l, 500, 70, 0xffffff);
        l += 20;
        Gfx.DrawCenteredStr(message, 256, l, 4, 0xffffff);
        l += 20;
        Gfx.DrawCenteredStr(super.fkn + "*", 256, l, 4, 0xffffff);
        int i1 = 0xffffff;

        if (super.MouseX > 236 && super.MouseX < 276 && super.MouseY > 193 && super.MouseY < 213) {
            i1 = 0xffff00;
            if (MouseButtonDown != 0) {
                MouseButtonDown = 0;
                Got = "";
                ToGet = "";
                super.fkn = "";
                super.fla = "";
                StopMacro();
            }
        }
        Gfx.DrawCenteredStr("Cancel", 256, 208, 1, i1);
        if (super.fla.length() > 0) {
            Got = super.fla.trim();
            ToGet = "";
            super.fkn = "";
            super.fla = "";
        }
    }

    public void SendPM(String to, String Message) {
        int MessageVar = v.cek(Message);
        long PlayerLong = t.PlayerNameToLong(to);

        SendPM(PlayerLong, v.ceg, MessageVar);
        Message = v.cej(v.ceg, 0, MessageVar);
        Message = u.fgd(Message);
        DisplayStr("@pri@You tell " + t.PlayerLongToName(PlayerLong) + ": " + Message);
    }

    public boolean IsReachable(int x, int y) {
        return Game.gkb(LocalX, LocalY, x - TileX, y - TileY, x - TileX, y - TileY, djk, djl, false) != -1;
    }

    public int[] GetPlayerByName(String n) {
        int[] stats = { -1, -1, -1};

        for (int a = 0; a < PlayerCount; a++) {
            if (Player[a].Name.equalsIgnoreCase(n)) {
                stats[0] = a;
                stats[1] = ((Player[a].XCoord - 64) / ecj) + TileX;
                stats[2] = ((Player[a].YCoord - 64) / ecj) + TileY;
                break;
            }
        }
        return stats;
    }

    public void TradePlayer(int i)throws Exception {
        OptionId[0] = 2810;
        dfm[0] = Player[i].ServerIndex;
        RunCommand(0);
    }
    
    public void DeclineTrade() {
        TradeScreen2 = TradeScreen1 = false;
        super.Connection.SendID(42);
        super.Connection.End();
    }

    public void AcceptTrade1() {
        MyTradeAccepted1 = true;
        super.Connection.SendID(43);
        super.Connection.End();
    }

    public void AcceptTrade2() {
        MyTradeAccepted2 = true;
        super.Connection.SendID(44);
        super.Connection.End();
    }
    
    public void Offer(int item, int amount)throws Exception {
        TradeItem[TradeIndex] = item;
        TradeAmount[TradeIndex] = amount;
        TradeIndex++;
        super.Connection.SendID(45);
        super.Connection.SendVar(TradeIndex);
        for (int i5 = 0; i5 < TradeIndex; i5++) {
            super.Connection.SendInt(TradeItem[i5]);
            super.Connection.SendDouble(TradeAmount[i5]);
        }
        super.Connection.End();
        OpponentTradeAccepted = MyTradeAccepted1 = false;
    }
    
    public void Stake(int item, int amount)throws Exception {
        dkh[dkg] = item;
        dki[dkg] = amount;
        dkg++;
        super.Connection.SendID(61);
        super.Connection.SendVar(dkg);
        for (int i5 = 0; i5 < dkg; i5++) {
            super.Connection.SendInt(dkh[i5]);
            super.Connection.SendDouble(dki[i5]);
        }
        super.Connection.End();
        dgm = dgn = false;
    }
    
    public void OfferItems(int items[], int amount[])throws Exception {
        if (items.length != amount.length || items.length > 12) {
            throw new Exception("invalid argument count");
        }
        TradeItem = items;
        TradeAmount = amount;
        TradeIndex = items.length;
        super.Connection.SendID(45);
        super.Connection.SendVar(TradeIndex);
        for (int i = 0; i < TradeIndex; i++) {
            super.Connection.SendInt(TradeItem[i]);
            super.Connection.SendDouble(TradeAmount[i]);
        }
        super.Connection.End();
        OpponentTradeAccepted = MyTradeAccepted1 = false;
    }

    private String CheckId(int l) {
        if (l == 165) {
            return " (Guam leaf)";
        } else if (l == 435) {
            return " (Marrentill)";
        } else if (l == 436) {
            return " (Tarromin)";
        } else if (l == 437) {
            return " (Harralander)";
        } else if (l == 438) {
            return " (Ranarr Weed)";
        } else if (l == 439) {
            return " (Irit Leaf)";
        } else if (l == 440) {
            return " (Avantoe)";
        } else if (l == 441) {
            return " (Kwuarm)";
        } else if (l == 442) {
            return " (Cadantine)";
        } else if (l == 443) {
            return " (Dwarf Weed)";
        } else if (l == 933) {
            return "(Torstol)";
        } else { 
            return "";
        }
    }

    public void OnChatMessage(final String sender, final String message) {
        if (macro != null) {
            new Thread(new Runnable() {
                public void run() {
                    macro.OnChatMessage(sender, message);
                }
            }).start();
        }
    }
    
    public void OnPrivateMessage(final String sender, final String message) {
        if (macro != null) {
            new Thread(new Runnable() {
                public void run() {
                    macro.OnPrivateMessage(sender, message);
                }
            }).start();
        }
    }
    
    private int GetStatIndex(String s) {
        for (int x = 0; x < StatName.length; x++) {
            if (StatName[x].equalsIgnoreCase(s)) {
                return x;
            }
        }
        return -1;
    }
    
    public boolean IsInStr(String string, String findme) {
        return string.toLowerCase().indexOf(findme.toLowerCase()) > -1;
    }
    
    public void OnServerMessage(final String message) {
        if (message.startsWith("@red@STS:@whi@")) {
            return;
        }
        if (IsInStr(message, "you just advanced")) {
            String s = message.substring(message.indexOf("advanced ") + 11);

            s = s.substring(0, s.indexOf(" "));
            int i = GetStatIndex(s);

            if (i > -1) {
                s = StatName[i] + " " + String.valueOf(StatMaximumLevel[i] + 1) + "!";
                char[] c = s.toCharArray();

                s = "";
                for (int x = 0; x < c.length; x++) {
                    s += GetColour(x) + String.valueOf(c[x]);
                }
                GotLvlName = s;
                GotLvl = System.currentTimeMillis();
            }
        }
        if (macro != null) {
            new Thread(new Runnable() {
                public void run() {
                    macro.OnServerMessage(message);
                }
            }).start();
        }
    }

    public void NewLogin() {
        if (Hopping) {
            Hopping = false;
        }
        new Thread(new Runnable() {
            public void run() {
                mac.run();
            }
        }).start();
        if (run && Locked != -1) {
            SetMode(Locked);
        }
    }

    public String ReadLine(File s) {
        try {
            BufferedReader input = new BufferedReader(new FileReader(s));
            String t = input.readLine().trim();

            input.close();
            return t;
        } catch (Exception e) {
            ShowCmd("Error reading slword.txt");
            return oword;
        }
    }

    public String Arg(String s, int pos) {
        if (pos == 1) {
            String temp = s.substring(s.indexOf("(") + 1);

            return temp.substring(0, temp.indexOf(temp.indexOf(",") > -1 ? "," : ")"));
        } else if (pos == 2) {
            String temp = s.substring(s.indexOf(",") + 1);

            return temp.substring(0, temp.indexOf(temp.indexOf(",") > -1 ? "," : ")"));
        } else if (pos >= 3) {
            String temp = s.substring(s.indexOf(",") + 1);

            for (int a = 2; a < pos; a++) {
                temp = temp.substring(temp.indexOf(",") + 1);
            }
            return temp.substring(0, temp.indexOf(temp.indexOf(",") > -1 ? "," : ")"));
        }
        return null;
    }

    public void BuyShopItem(int id)throws Exception {
        int i = ShopBuyPrice(id);

        if (FindShopItem(id) == -1 || i == -1 || !InShop) {
            throw new Exception("Canoot find that item in shop");
        }
        super.Connection.SendID(46);
        super.Connection.SendInt(id);
        super.Connection.SendDouble(i);
        super.Connection.End();
    }
    
    public void SellShopItem(int id)throws Exception {
        int i = ShopSellPrice(id);

        if (FindShopItem(id) == -1 || i == -1 || !InShop) {
            throw new Exception("Cannot find that item in shop");
        }
        super.Connection.SendID(47);
        super.Connection.SendInt(id);
        super.Connection.SendDouble(i);
        super.Connection.End();
    }

    public int FindShopItem(int item) {
        for (int i = 0; i < 40; i++) {
            if (ShopItem[i] == item) {
                return i;
            }
        }
        return -1;
    }

    public int ShopBuyPrice(int id) {
        int i = FindShopItem(id);
        int j = ShopItem[i];
        int i3 = dni + ShopPrice[i];

        if (i3 < 10) {
            i3 = 10;
        }
        return (i3 * Ident.ItemValue[j]) / 100;
    }
    
    public int ShopCount(int id) {
        int i = FindShopItem(id);

        if (i == -1) {
            return 0;
        }
        return ShopAmount[i];
    }
    
    public int ShopSellPrice(int id) {
        int i = FindShopItem(id);
        int j = ShopItem[i];
        int i3 = dnh + ShopPrice[i];

        if (i3 < 10) {
            i3 = 10;
        }
        return (i3 * Ident.ItemValue[j]) / 100;
    }

    public void CloseShop() {
        super.Connection.SendID(48);
        super.Connection.End();
        InShop = false;
    }

    public void CloseBank() {
        super.Connection.SendID(49);
        super.Connection.End();
        InBank = false;
    }

    public int GetIdWallObject(int x, int y)throws Exception {
        int i = GetIndexWallObject(x, y);

        if (i == -1) {
            throw new Exception("Cannot find wall object at given coords");
        }
        return WallObjectId[i];
    }

    public int GetIdObject(int x, int y)throws Exception {
        int i = GetIndexObject(x, y);

        if (i == -1) {
            throw new Exception("Cannot find object at given coords");
        }
        return ObjectId[i];
    }

    public int GetIndexWallObject(int x, int y) {
        for (int i = 0; i < WallObjectCount; i++) {
            if (WallObjectX[i] == (x - TileX) && WallObjectY[i] == (y - TileY)) {
                return i;
            }
        }
        return -1;
    }

    public int GetIndexObject(int x, int y) {
        for (int i = 0; i < ObjectCount; i++) {
            if (ObjectX[i] == (x - TileX) && ObjectY[i] == (y - TileY)) {
                return i;
            }
        }
        return -1;
    }

    public void UseOnObject(int slot, int x, int y)throws Exception {
        int i = GetIndexObject(x, y);

        if (i == -1) {
            throw new Exception("Cannot find object at given coords");
        }
        OptionId[0] = 410;
        OptionX[0] = ObjectX[i];
        OptionY[0] = ObjectY[i];
        dfm[0] = ecb[i];
        dfn[0] = ObjectId[i];
        dga[0] = slot;
        RunCommand(0);
    }

    public void UseOnWallObject(int slot, int x, int y)throws Exception {
        int i = GetIndexWallObject(x, y);

        if (i == -1) {
            throw new Exception("Cannot find wallobject at given coords");
        }
        OptionId[0] = 310;
        OptionX[0] = WallObjectX[i];
        OptionY[0] = WallObjectY[i];
        dfm[0] = WallObjectDir[i];
        dfn[0] = slot;
        RunCommand(0);
    }

    public boolean validWorld(int i) {
        return i > 0 && i < 5;
    }

    public void ScreenShot(File file)throws Exception {
        BufferedImage bufferedImage = new BufferedImage(RsWidth, RsHeight + 10, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bufferedImage.createGraphics();

        g2d.drawImage(Gfx.bmb, 0, 0, this);
        g2d.dispose();
        ImageIO.write(bufferedImage, "png", file);
    }
    
    public void Reply(int i)throws Exception {
        super.Connection.SendID(50);
        super.Connection.SendVar(i);
        super.Connection.End();
        QuestMenu = false;
    }
    
    public int GetWallObjectDir(int x, int y) {
        for (int a = 0; a < WallObjectCount; a++) {
            if (WallObjectX[a] == (x - TileX) && WallObjectY[a] == (y - TileY)) {
                return WallObjectDir[a];
            }
        }
        return -1;
    }
    
    public int getExpForNextLvl(int i) {
        int j3 = LevelExp[0];

        for (int l3 = 0; l3 < 98; l3++) {
            if (StatTotalExpVar[i] >= LevelExp[l3]) {
                j3 = LevelExp[l3 + 1];
            }
        }
        return j3 / 4;
    }
    
    public int[] GetWallObjectById(int[] id) {
        int min[] = { -1, -1, -1};
        int mint = Integer.MAX_VALUE;

        for (int j = 0; j < WallObjectCount; j++) {
            if (InArray(id, WallObjectId[j])) {
                int ObjX = WallObjectX[j] + TileX;
                int ObjY = WallObjectY[j] + TileY;
                int temp = DistanceTo(ObjX, ObjY, GetX(), GetY());

                if (temp < mint) {
                    min[0] = WallObjectId[j];
                    min[1] = ObjX;
                    min[2] = ObjY;
                    mint = temp;
                }
            }
        }
        return min;
    }
    
    public int[] GetWallObjectById(int id) {
        int min[] = { -1, -1, -1};
        int mint = Integer.MAX_VALUE;

        for (int j = 0; j < WallObjectCount; j++) {
            if (WallObjectId[j] == id) {
                int ObjX = WallObjectX[j] + TileX;
                int ObjY = WallObjectY[j] + TileY;
                int temp = DistanceTo(ObjX, ObjY, GetX(), GetY());

                if (temp < mint) {
                    min[0] = WallObjectId[j];
                    min[1] = ObjX;
                    min[2] = ObjY;
                    mint = temp;
                }
            }
        }
        return min;
    }
    
    public void AtWallObject(int x, int y, boolean left)throws Exception {
        int i = GetWallObjectDir(x, y);

        if (i == -1) {
            throw new Exception("Cannot find WallObject at given coords");
        }
        OptionId[0] = (left ? 320 : 2300);
        OptionX[0] = x - TileX;
        OptionY[0] = y - TileY;
        dfm[0] = i;
        RunCommand(0);
    }

    public static String replace(String target, String from, String to) {   
        int start = target.indexOf(from);

        if (start == -1) {
            return target;
        }
        int lf = from.length();
        char[] targetChars = target.toCharArray();
        StringBuffer buffer = new StringBuffer();
        int copyFrom = 0;

        while (start != -1) {
            buffer.append(targetChars, copyFrom, start - copyFrom);
            buffer.append(to);
            copyFrom = start + lf;
            start = target.indexOf(from, copyFrom);
        }
        buffer.append(targetChars, copyFrom, targetChars.length - copyFrom);
        return buffer.toString();
    }
    
    public void ForceWalkTo(int x, int y)throws Exception {
        if (!IsReachable(x, y)) {
            throw new Exception("WalkTo Coords not reachable");
        }
        OptionId[0] = 925;
        OptionX[0] = x - TileX;
        OptionY[0] = y - TileY;
        dfm[0] = 1289;
        dfn[0] = 0;
        RunCommand(0);
    }
    
    public void ForceWalkToWait(int x, int y)throws Exception {
        if (!IsReachable(x, y)) {
            throw new Exception("WalkTo Coords not reachable");
        }
        do {
            while (load || LoggedInVar == 0) {
                Thread.sleep(1000);
            }
            try {
                ForceWalkTo(x, y);
            } catch (Exception e) {}
            Thread.sleep(2000);
        } while (DistanceTo(x, y, GetX(), GetY()) > 1 && run);
    }
    
    public void WalkToWait(int x, int y)throws Exception {
        if (!IsReachable(x, y)) {
            throw new Exception("WalkTo Coords not reachable");
        }
        do {
            while (load || LoggedInVar == 0) {
                Thread.sleep(1000);
            }
            try {
                WalkTo(x, y);
            } catch (Exception e) {}
            Thread.sleep(2000);
        } while (DistanceTo(x, y, GetX(), GetY()) > 1 && run);
    }
    
    public void WalkTo(int x, int y)throws Exception {
        if (!IsReachable(x, y)) {
            throw new Exception("WalkTo Coords not reachable");
        }
        OptionId[0] = 920;
        OptionX[0] = x - TileX;
        OptionY[0] = y - TileY;
        RunCommand(0);
    }
    
    public int Rand(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public int GetItemPos(int id) {
        for (int j = 0; j < InvItemId.length; j++) {
            if (InvItemId[j] == id) {
                return j;
            }
        }
        return -1;
    }

    public boolean InArray(String sarray[], String s) {
        for (int a = 0; a < sarray.length; a++) {
            if (sarray[a].equalsIgnoreCase(s)) {
                return true;
            }
        }
        return false;
    }

    public boolean InArray(int iarray[], int i) {
        for (int a = 0; a < iarray.length; a++) {
            if (iarray[a] == i) {
                return true;
            }
        }
        return false;
    }

    public int[] GetObjectById(int[] id) {
        int min[] = { -1, -1, -1};
        int mint = Integer.MAX_VALUE;

        for (int j = 0; j < ObjectCount; j++) {
            if (InArray(id, ObjectId[j])) {
                int ObjX = ObjectX[j] + TileX;
                int ObjY = ObjectY[j] + TileY;
                int temp = DistanceTo(ObjX, ObjY, GetX(), GetY());

                if (temp < mint) {
                    min[0] = ObjectId[j];
                    min[1] = ObjX;
                    min[2] = ObjY;
                    mint = temp;
                }
            }
        }
        return min;
    }

    public int[] GetObjectById(int id) {
        int min[] = { -1, -1, -1};
        int mint = Integer.MAX_VALUE;

        for (int j = 0; j < ObjectCount; j++) {
            if (ObjectId[j] == id) {
                int ObjX = ObjectX[j] + TileX;
                int ObjY = ObjectY[j] + TileY;
                int temp = DistanceTo(ObjX, ObjY, GetX(), GetY());

                if (temp < mint) {
                    min[0] = ObjectId[j];
                    min[1] = ObjX;
                    min[2] = ObjY;
                    mint = temp;
                }
            }
        }
        return min;
    }

    public int[] GetNpcByIdNotTalk(int[] id) {
        int min[] = { -1, -1, -1};
        int mint = Integer.MAX_VALUE;

        for (int j = 0; j < NpcCount; j++) {
            if (InArray(id, Npc[j].Id) && Npc[j].Dir != 8 && Npc[j].Dir != 9 && Npc[j].TalkVar < 10) {
                int NpcX = ((Npc[j].XCoord - 64) / ecj) + TileX;
                int NpcY = ((Npc[j].YCoord - 64) / ecj) + TileY;
                int temp = DistanceTo(NpcX, NpcY, GetX(), GetY());

                if (temp < mint) {
                    min[0] = j;
                    min[1] = NpcX;
                    min[2] = NpcY;
                    mint = temp;
                }
            }
        }
        return min;
    }

    public int[] GetNpcByIdNotTalk(int id) {
        int min[] = { -1, -1, -1};
        int mint = Integer.MAX_VALUE;

        for (int j = 0; j < NpcCount; j++) {
            if (Npc[j].Id == id && Npc[j].Dir != 8 && Npc[j].Dir != 9 && Npc[j].TalkVar < 10) {
                int NpcX = ((Npc[j].XCoord - 64) / ecj) + TileX;
                int NpcY = ((Npc[j].YCoord - 64) / ecj) + TileY;
                int temp = DistanceTo(NpcX, NpcY, GetX(), GetY());

                if (temp < mint) {
                    min[0] = j;
                    min[1] = NpcX;
                    min[2] = NpcY;
                    mint = temp;
                }
            }
        }
        return min;
    }

    public int[] GetNpcById(int[] id) {
        int min[] = { -1, -1, -1};
        int mint = Integer.MAX_VALUE;

        for (int j = 0; j < NpcCount; j++) {
            if (InArray(id, Npc[j].Id) && Npc[j].Dir != 8 && Npc[j].Dir != 9) {
                int NpcX = ((Npc[j].XCoord - 64) / ecj) + TileX;
                int NpcY = ((Npc[j].YCoord - 64) / ecj) + TileY;
                int temp = DistanceTo(NpcX, NpcY, GetX(), GetY());

                if (temp < mint) {
                    min[0] = j;
                    min[1] = NpcX;
                    min[2] = NpcY;
                    mint = temp;
                }
            }
        }
        return min;
    }

    public int[] GetNpcById(int id) {
        int min[] = { -1, -1, -1};
        int mint = Integer.MAX_VALUE;

        for (int j = 0; j < NpcCount; j++) {
            if (Npc[j].Id == id && Npc[j].Dir != 8 && Npc[j].Dir != 9) {
                int NpcX = ((Npc[j].XCoord - 64) / ecj) + TileX;
                int NpcY = ((Npc[j].YCoord - 64) / ecj) + TileY;
                int temp = DistanceTo(NpcX, NpcY, GetX(), GetY());

                if (temp < mint) {
                    min[0] = j;
                    min[1] = NpcX;
                    min[2] = NpcY;
                    mint = temp;
                }
            }
        }
        return min;
    }

    public int[] GetAllNpcById(int[] id) {
        int min[] = { -1, -1, -1};
        int mint = Integer.MAX_VALUE;

        for (int j = 0; j < NpcCount; j++) {
            if (InArray(id, Npc[j].Id)) {
                int NpcX = ((Npc[j].XCoord - 64) / ecj) + TileX;
                int NpcY = ((Npc[j].YCoord - 64) / ecj) + TileY;
                int temp = DistanceTo(NpcX, NpcY, GetX(), GetY());

                if (temp < mint) {
                    min[0] = j;
                    min[1] = NpcX;
                    min[2] = NpcY;
                    mint = temp;
                }
            }
        }
        return min;
    }

    public int[] GetAllNpcById(int id) {
        int min[] = { -1, -1, -1};
        int mint = Integer.MAX_VALUE;

        for (int j = 0; j < NpcCount; j++) {
            if (Npc[j].Id == id) {
                int NpcX = ((Npc[j].XCoord - 64) / ecj) + TileX;
                int NpcY = ((Npc[j].YCoord - 64) / ecj) + TileY;
                int temp = DistanceTo(NpcX, NpcY, GetX(), GetY());

                if (temp < mint) {
                    min[0] = j;
                    min[1] = NpcX;
                    min[2] = NpcY;
                    mint = temp;
                }
            }
        }
        return min;
    }

    public void WearItem(int i, boolean on)throws Exception {
        OptionId[0] = (on ? 630 : 620);
        dfm[0] = i;
        RunCommand(0);
    }

    public void UseItem(int i, boolean left)throws Exception {
        OptionId[0] = (left ? 640 : 650);
        dfm[0] = i;
        RunCommand(0);
    }
    
    public void UseItemWithItem(int i, int l)throws Exception {
        OptionId[0] = 610;
        dfm[0] = i;
        dfn[0] = l;
        RunCommand(0);
    }
    
    public void Drop(int i)throws Exception {
        OptionId[0] = 660;
        dfm[0] = i;
        RunCommand(0);
    }
    
    public int GetItemIndex(int x, int y) {
        for (int j = 0; j < ItemCount; j++) {
            if (ItemX[j] == (x - TileX) && ItemY[j] == (y - TileY)) {
                return j;
            }
        }
        return -1;
    }
    
    public void UseItemOnGItem(int pos, int x, int y, int id)throws Exception {
        OptionId[0] = 210;
        OptionX[0] = x - TileX;
        OptionY[0] = y - TileY;
        dfm[0] = id;
        dfn[0] = pos;
        RunCommand(0);
    }
    
    public void PickUpById(int[] id)throws Exception {
        int coords[] = GetItemById(id);

        if (coords[0] == -1) {
            throw new Exception("given item not found");
        }
        PickUp(coords[1], coords[2], coords[0]);
    }
    
    public void PickUpById(int id)throws Exception {
        int coords[] = GetItemById(id);

        if (coords[0] == -1) {
            throw new Exception("given item not found");
        }
        PickUp(coords[1], coords[2], coords[0]);
    }

    public void PickUp(int x, int y, int id)throws Exception {
        OptionId[0] = 220;
        OptionX[0] = x - TileX;
        OptionY[0] = y - TileY;
        dfm[0] = id;
        RunCommand(0);
        long l = System.currentTimeMillis();
        int newAmount = InvAmount(id) + 1;

        do {
            Thread.sleep(Rand(100, 200));
        } while (InvAmount(id) < newAmount && System.currentTimeMillis() - l < 2000);
    }
    
    public void PickUp(int x, int y)throws Exception {
        int i = GetItemIndex(x, y);

        if (i == -1) {
            throw new Exception("cannot find any items at given coords");
        }
        OptionId[0] = 220;
        OptionX[0] = ItemX[i];
        OptionY[0] = ItemY[i];
        dfm[0] = ItemId[i];
        RunCommand(0);
        long l = System.currentTimeMillis();
        int newAmount = InvAmount(ItemId[i]) + 1;

        do {
            Thread.sleep(Rand(100, 200));
        } while (InvAmount(ItemId[i]) < newAmount && System.currentTimeMillis() - l < 2000);
    }

    public int[] GetItemById(int[] id) {
        int min[] = { -1, -1, -1};
        int mint = Integer.MAX_VALUE;

        for (int j = 0; j < ItemCount; j++) {
            if (InArray(id, ItemId[j])) {
                int ItmX = ItemX[j] + TileX;
                int ItmY = ItemY[j] + TileY;
                int temp = DistanceTo(ItmX, ItmY, GetX(), GetY());

                if (temp < mint) {
                    min[0] = ItemId[j];
                    min[1] = ItmX;
                    min[2] = ItmY;
                    mint = temp;
                }
            }
        }
        return min;
    }

    public int[] GetItemById(int id) {
        int min[] = { -1, -1, -1};
        int mint = Integer.MAX_VALUE;

        for (int j = 0; j < ItemCount; j++) {
            if (ItemId[j] == id) {
                int ItmX = ItemX[j] + TileX;
                int ItmY = ItemY[j] + TileY;
                int temp = DistanceTo(ItmX, ItmY, GetX(), GetY());

                if (temp < mint) {
                    min[0] = ItemId[j];
                    min[1] = ItmX;
                    min[2] = ItmY;
                    mint = temp;
                }
            }
        }
        return min;
    }

    public int GetObjectIndex(int x, int y) {
        for (int a = 0; a < ObjectCount; a++) {
            if (ObjectX[a] == (x - TileX) && ObjectY[a] == (y - TileY)) {
                return a;
            }
        }
        return -1;
    }

    public void AtObject(int x, int y, boolean left)throws Exception {
        int i = GetObjectIndex(x, y);

        if (i == -1) {
            throw new Exception("no object found at given coords");
        }
        OptionId[0] = (left ? 420 : 2400);
        OptionX[0] = ObjectX[i];
        OptionY[0] = ObjectY[i];
        dfm[0] = ecb[i];
        dfn[0] = ObjectId[i];
        RunCommand(0);
    }

    public void TalkNpc(int i)throws Exception {
        OptionId[0] = 720;
        OptionX[0] = Npc[i].XCoord;
        OptionY[0] = Npc[i].YCoord;
        dfm[0] = Npc[i].ServerIndex;
        RunCommand(0);
    }
    
    public void CastOnNpc(int spell, int index)throws Exception {
        if (Ident.SpellStatus[spell] != 2) {
            throw new Exception("spell cannot be cast on an npc");
        }
        OptionId[0] = 700;
        OptionX[0] = Npc[index].XCoord;
        OptionY[0] = Npc[index].YCoord;
        dfm[0] = Npc[index].ServerIndex;
        dfn[0] = spell;
        RunCommand(0);
    }
    
    public void CastOnItem(int spell, int pos)throws Exception {
        if (Ident.SpellStatus[spell] != 3) {
            throw new Exception("spell cannot be cast on an item");
        }
        OptionId[0] = 600;
        dfm[0] = pos;
        dfn[0] = spell;
        RunCommand(0);
    }
    
    public void CastOnGItem(int spell, int id, int x, int y)throws Exception {
        if (Ident.SpellStatus[spell] != 3) {
            throw new Exception("spell cannot be cast on items on the ground");
        }
        OptionId[0] = 200;
        OptionX[0] = x - TileX;
        OptionY[0] = y - TileY;
        dfm[0] = id;
        dfn[0] = spell;
        RunCommand(0);
    }
    
    public void CastOnSelf(int spell)throws Exception {
        if (Ident.SpellStatus[spell] > 1) {
            throw new Exception("spell cannot be cast on self");
        }
        OptionId[0] = 1000;
        dfm[0] = spell;
        RunCommand(0);
    }
    
    public void CastOnGround(int spell)throws Exception {
        if (Ident.SpellStatus[spell] != 6) {
            throw new Exception("spell cannot be cast on the ground");
        }
        OptionId[0] = 900;
        OptionX[0] = GetX() - TileX;
        OptionY[0] = GetY() - TileY;
        dfm[0] = spell;
        RunCommand(0);
    }
    
    public void CastOnObject(int spell, int x, int y)throws Exception {
        if (Ident.SpellStatus[spell] != 5) {
            throw new Exception("spell cannot be cast on an object");
        }
        int i = GetObjectIndex(x, y);

        OptionId[0] = 400;
        OptionX[0] = ObjectX[i];
        OptionY[0] = ObjectY[i];
        dfm[0] = ecb[i];
        dfn[0] = ObjectId[i];
        dga[0] = spell;
        RunCommand(0);
    }
    
    public void CastOnWallObject(int spell, int x, int y)throws Exception {
        if (Ident.SpellStatus[spell] != 4) {
            throw new Exception("spell cannot be cast on a wall object");
        }
        int i = GetWallObjectDir(x, y);

        OptionId[0] = 300;
        OptionX[0] = x - TileX;
        OptionY[0] = y - TileY;
        dfm[0] = i;
        dga[0] = spell;
        RunCommand(0);
    }
    
    public void AttackNpc(int i)throws Exception {
        OptionId[0] = 715;
        OptionX[0] = Npc[i].XCoord;
        OptionY[0] = Npc[i].YCoord;
        dfm[0] = Npc[i].ServerIndex;
        RunCommand(0);
    }

    public void UseOnNpc(int pos, int index)throws Exception {
        OptionId[0] = 710;
        OptionX[0] = Npc[index].XCoord;
        OptionY[0] = Npc[index].YCoord;
        dfm[0] = Npc[index].ServerIndex;
        dfn[0] = pos;
        RunCommand(0);
    }

    public void ThieveNpc(int i)throws Exception {
        OptionId[0] = 725;
        OptionX[0] = Npc[i].XCoord;
        OptionY[0] = Npc[i].YCoord;
        dfm[0] = Npc[i].ServerIndex;
        RunCommand(0);
    }

    public void Talk(String Message) {
        int MessageVar = v.cek(Message);

        SendChat(v.ceg, MessageVar);
        Message = v.cej(v.ceg, 0, MessageVar);
        Message = u.fgd(Message);
        My.TalkVar = 150;
        My.Message = Message;
        DisplayMessage(My.Name + ": " + Message, 2);
    }

    public void PrayerOn(int i, boolean on) {
        super.Connection.SendID(on ? 51 : 52);
        super.Connection.SendVar(i);
        super.Connection.End();
        PrayerIsOn[i] = on;
        fdb(on ? "prayeron" : "prayeroff");
    }

    public void Withdraw(int id, int amount, boolean out)throws Exception {
        if (!InBank) {
            throw new Exception("Not in the bank!");
        }
        super.Connection.SendID(out ? 53 : 54);
        super.Connection.SendInt(id);
        super.Connection.SendInt(amount);
        super.Connection.SendDouble(out ? 0x12345678 : 0x87654321);
        super.Connection.End();
    }

    public int GetX() {
        return LocalX + TileX;
    }

    public int GetY() {
        return LocalY + TileY;
    }

    public void StopMacro() {
        if (run && thread != null) {
            macro.StopScanForMods();
            AutoLogin = false;
            Locked = -1;
            FixSleeping = false;
            run = false;
            thread.stop(); // Deprecated
            ShowCmd("Stopping script...");
            macro = null;
        }
    }

    public void SetMode(int i) {
        FightMode = i;
        super.Connection.SendID(55);
        super.Connection.SendVar(FightMode);
        super.Connection.End();
    }

    public void ShowCmd(Exception s) {
        ShowCmd(String.valueOf(s));
    }

    public void ShowCmd(String s) {
        String leftOver = null;
        int maxLength = getSize(s);
        if (s.replaceAll(COLOURS, "").length() > maxLength) {
            int space = s.indexOf(" ", maxLength);

            if (space > -1) {
                leftOver = s.substring(space + 1);
                s = s.substring(0, space);
            } else if ((space = s.lastIndexOf(" ", maxLength)) > -1) {
                leftOver = s.substring(space + 1);
                s = s.substring(0, space);
            }
        }
        DisplayMessage("@red@STS:@whi@ " + s, 5);
        System.out.println(s.replaceAll(COLOURS, ""));
        if (leftOver != null) {
            ShowCmd(findLastColour(s) + leftOver);
        }
    }

    private static void Load(mudclient mc) {
        Scripts.clear();
        String[] tscriptlist = new String[1000];
        File f = new File(System.getProperty("user.dir") + "/Scripts/");
        String[] files = f.list();

        System.out.println("Script Command List loaded");
        int i = 0;

        for (int x = 0; x < files.length; x++) {
            try {
                if (files[x].endsWith(".class") && files[x].indexOf('$') < 0 && !files[x].startsWith("NewLogin")) {
                    Class c = Class.forName(files[x].substring(0, files[x].length() - 6));
                    Methods macro = (Methods) c.getConstructor(new Class[] { mudclient.class}).newInstance(
                            new Object[] { mc});
                    String t = files[x].substring(0, files[x].length() - 6).toLowerCase();

                    Scripts.put(t, macro);
                    tscriptlist[i++] = t;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        mc.ScriptList = new String[i];
        for (int a = 0; a < i; a++) {
            mc.ScriptList[a] = tscriptlist[a];
        }
    }

    public void Command(String s) {
        if (!run) {
            s = s.trim().toLowerCase();
            String command = s;
            String params[] = new String[0];

            if (s.indexOf(")") >= 0) {
                s = s.substring(0, s.indexOf(")"));
            }
            if (s.indexOf("(") >= 0) {
                command = s.substring(0, s.indexOf("("));
                params = s.substring(s.indexOf("(") + 1).split(",");
            }
            final String Parameters[] = params;
            final String Time = Time();

            macro = (Methods) Scripts.get(command);
            if (macro != null) {
                thread = new Thread(new Runnable() {
                    public void run() {
                        ShowCmd("Starting Script at " + Time + "...");
                        macro.MainBody(Parameters);
                    }
                });
                run = true;
                thread.start();
            } else {
                ShowCmd("Cannot find that command: " + command);
            }
        } else {
            ShowCmd("Script already running!");
        }
    }

    public byte[] MakePic(byte abyte0[]) {
        int i1 = 1;
        byte byte0 = 0;
        int j1;
        byte picBytes[] = new byte[10200];

        for (j1 = 0; j1 < 255;) {
            int k1 = abyte0[i1++] & 0xff;

            for (int i2 = 0; i2 < k1; i2++) {
                picBytes[j1++] = byte0;
            }
            byte0 = (byte) (255 - byte0);
        }
        for (int l1 = 1; l1 < 40; l1++) {
            for (int j2 = 0; j2 < 255;) {
                int k2 = abyte0[i1++] & 0xff;

                for (int l2 = 0; l2 < k2; l2++) {
                    picBytes[j1] = picBytes[j1 - 255];
                    j1++;
                    j2++;
                }
                if (j2 < 255) {
                    picBytes[j1] = (byte) (255 - picBytes[j1 - 255]);
                    j1++;
                    j2++;
                }
            }
        }
        return picBytes;
    }
      
    public void saveOutput(File s, byte abyte0[]) {
        try {
            FileOutputStream fileoutputstream = new FileOutputStream(s);

            fileoutputstream.write(66);
            fileoutputstream.write(77);
            int i1 = 1342;

            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            i1 = 62;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            i1 = 40;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            i1 = 256;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            i1 = 40;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            i1 = 1;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            i1 = 1;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            i1 = 0;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            i1 = 0;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            i1 = 0;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            i1 = 0;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            i1 = 0;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            i1 = 0;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            fileoutputstream.write(255);
            fileoutputstream.write(255);
            fileoutputstream.write(255);
            fileoutputstream.write(0);
            int j1 = 9945;

            for (int k1 = 0; k1 < 40; k1++) {
                for (int l1 = 0; l1 < 32; l1++) {
                    byte byte0 = 0;

                    for (int i2 = 0; i2 < 8; i2++) {
                        byte0 = (byte) (2 * byte0);
                        if (l1 != 31 || i2 != 7) {
                            if (abyte0[j1] != 0) {
                                byte0++;
                            }
                            j1++;
                        }
                    }
                    fileoutputstream.write(byte0);
                }
                j1 -= 510;
            }
            fileoutputstream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void ShowFightMenu() {
        byte byte0 = 7;
        byte byte1 = 15;
        char c1 = '\257';

        if (MouseButtonDown != 0) {
            for (int l = 0; l < 5; l++) {
                if (l <= 0 || super.MouseX <= byte0 || super.MouseX >= byte0 + c1 || super.MouseY <= byte1 + l * 20
                        || super.MouseY >= byte1 + l * 20 + 20) {
                    continue;
                }
                FightMode = l - 1;
                MouseButtonDown = 0;
                super.Connection.SendID(55);
                super.Connection.SendVar(FightMode);
                super.Connection.End();
                break;
            }
        }
        for (int i1 = 0; i1 < 5; i1++) {
            if (i1 == FightMode + 1) {
                Gfx.cam(byte0, byte1 + i1 * 20, c1, 20, j.ToHex(255, 0, 0), 128);
            } else {
                Gfx.cam(byte0, byte1 + i1 * 20, c1, 20, j.ToHex(190, 190, 190), 128);
            }
            Gfx.cbc(byte0, byte1 + i1 * 20, c1, 0);
            Gfx.cbc(byte0, byte1 + i1 * 20 + 20, c1, 0);
        }
        Gfx.DrawCenteredStr("Select combat style", byte0 + c1 / 2, byte1 + 16, 3, 0xffffff);
        Gfx.DrawCenteredStr("Controlled (+1 of each)", byte0 + c1 / 2, byte1 + 36, 3, 0);
        Gfx.DrawCenteredStr("Aggressive (+3 strength)", byte0 + c1 / 2, byte1 + 56, 3, 0);
        Gfx.DrawCenteredStr("Accurate   (+3 attack)", byte0 + c1 / 2, byte1 + 76, 3, 0);
        Gfx.DrawCenteredStr("Defensive  (+3 defense)", byte0 + c1 / 2, byte1 + 96, 3, 0);
    }

    private final void emh(int l, String s1) {
        int i1 = ObjectX[l];
        int j1 = ObjectY[l];
        int k1 = i1 - My.XCoord / 128;
        int l1 = j1 - My.YCoord / 128;
        byte byte0 = 7;

        if (i1 >= 0 && j1 >= 0 && i1 < 96 && j1 < 96 && k1 > -byte0 && k1 < byte0 && l1 > -byte0 && l1 < byte0) {
            efn.bgn(ddf[l]);
            int i2 = Ident.anj(s1);
            i j2 = dkj[i2].cnj();

            efn.bgm(j2);
            j2.cme(true, 48, 48, -50, -10, -50);
            j2.cnl(ddf[l]);
            j2.chk = l;
            ddf[l] = j2;
        }
    }

    private final void LogoutBox() {
        Gfx.DrawBox(126, 137, 260, 60, 0);
        Gfx.DrawBorder(126, 137, 260, 60, 0xffffff);
        Gfx.DrawCenteredStr("Logging out...", 256, 173, 5, 0xffffff);
    }

    private final void emj() {
        Gfx.bnc = false;
        Gfx.cak();
        if (ehl == 0 || ehl == 1 || ehl == 2 || ehl == 3) {
            int l = (dji * 2) % 3072;

            if (l < 1024) {
                Gfx.DrawPicture(0, 10, dfd);
                if (l > 768) {
                    Gfx.ccd(0, 10, dfd + 1, l - 768);
                }
            } else if (l < 2048) {
                Gfx.DrawPicture(0, 10, dfd + 1);
                if (l > 1792) {
                    Gfx.ccd(0, 10, del + 10, l - 1792);
                }
            } else {
                Gfx.DrawPicture(0, 10, del + 10);
                if (l > 2816) {
                    Gfx.ccd(0, 10, dfd, l - 2816);
                }
            }
        }
        if (ehl == 0) {
            ehm.ged();
        }
        if (ehl == 1) {
            dmc.ged();
        }
        if (ehl == 2) {
            dkf.ged();
        }
        Gfx.DrawPicture(0, RsHeight, del + 22);
        Gfx.caj(dci, 0, 0);
    }

    protected final void adf(int arg0, int arg1, byte arg2[]) { // Deal with Server Input
        try {
            if (arg0 == 8) {
                TempPlayerCount = PlayerCount;
                for (int l = 0; l < TempPlayerCount; l++) {
                    dmn[l] = Player[l];
                }
                int l7 = 8;

                LocalX = t.fmn(arg2, l7, 11);
                l7 += 11;
                LocalY = t.fmn(arg2, l7, 13);
                l7 += 13;
                int i14 = t.fmn(arg2, l7, 4);

                l7 += 4;
                boolean flag1 = LoadTile(LocalX, LocalY);

                LocalX -= TileX;
                LocalY -= TileY;
                int i23 = LocalX * ecj + 64;
                int i26 = LocalY * ecj + 64;

                if (flag1) {
                    My.PathIndex = 0;
                    My.gmn = 0;
                    My.XCoord = My.XCoordPath[0] = i23;
                    My.YCoord = My.YCoordPath[0] = i26;
                }
                PlayerCount = 0;
                My = eml(dgf, i23, i26, i14);
                int j29 = t.fmn(arg2, l7, 8);

                l7 += 8;
                for (int i34 = 0; i34 < j29; i34++) {
                    NpcObject f4 = dmn[i34 + 1];
                    int i40 = t.fmn(arg2, l7, 1);

                    l7++;
                    if (i40 != 0) {
                        int i42 = t.fmn(arg2, l7, 1);

                        l7++;
                        if (i42 == 0) {
                            int j43 = t.fmn(arg2, l7, 3);

                            l7 += 3;
                            int j44 = f4.PathIndex;
                            int i45 = f4.XCoordPath[j44];
                            int j45 = f4.YCoordPath[j44];

                            if (j43 == 2 || j43 == 1 || j43 == 3) {
                                i45 += ecj;
                            }
                            if (j43 == 6 || j43 == 5 || j43 == 7) {
                                i45 -= ecj;
                            }
                            if (j43 == 4 || j43 == 3 || j43 == 5) {
                                j45 += ecj;
                            }
                            if (j43 == 0 || j43 == 1 || j43 == 7) {
                                j45 -= ecj;
                            }
                            f4.gmm = j43;
                            f4.PathIndex = j44 = (j44 + 1) % 10;
                            f4.XCoordPath[j44] = i45;
                            f4.YCoordPath[j44] = j45;
                        } else {
                            int k43 = t.fmn(arg2, l7, 4);

                            if ((k43 & 0xc) == 12) {
                                l7 += 2;
                                continue;
                            }
                            f4.gmm = t.fmn(arg2, l7, 4);
                            l7 += 4;
                        }
                    }
                    Player[PlayerCount++] = f4;
                }
                int k37 = 0;

                while (l7 + 24 < arg1 * 8) {
                    int j40 = t.fmn(arg2, l7, 11);

                    l7 += 11;
                    int j42 = t.fmn(arg2, l7, 5);

                    l7 += 5;
                    if (j42 > 15) {
                        j42 -= 32;
                    }
                    int l43 = t.fmn(arg2, l7, 5);

                    l7 += 5;
                    if (l43 > 15) {
                        l43 -= 32;
                    }
                    int j14 = t.fmn(arg2, l7, 4);

                    l7 += 4;
                    int k44 = t.fmn(arg2, l7, 1);

                    l7++;
                    int j23 = (LocalX + j42) * ecj + 64;
                    int j26 = (LocalY + l43) * ecj + 64;

                    eml(j40, j23, j26, j14);
                    if (k44 == 0) {
                        dde[k37++] = j40;
                    }
                }
                if (k37 > 0) {
                    super.Connection.SendID(56);
                    super.Connection.SendInt(k37);
                    for (int k40 = 0; k40 < k37; k40++) {
                        NpcObject f5 = eba[dde[k40]];

                        super.Connection.SendInt(f5.ServerIndex); // PID something?
                        super.Connection.SendInt(f5.gmg);
                    }
                    super.Connection.End();
                    k37 = 0;
                }
                return;
            }
            if (arg0 == 9) {
                for (int i1 = 1; i1 < arg1;) {
                    if (t.fmh(arg2[i1]) == 255) {
                        int i8 = 0;
                        int k14 = LocalX + arg2[i1 + 1] >> 3;
                        int j19 = LocalY + arg2[i1 + 2] >> 3;

                        i1 += 3;
                        for (int k23 = 0; k23 < ItemCount; k23++) {
                            int k26 = (ItemX[k23] >> 3) - k14;
                            int k29 = (ItemY[k23] >> 3) - j19;

                            if (k26 != 0 || k29 != 0) {
                                if (k23 != i8) {
                                    ItemX[i8] = ItemX[k23];
                                    ItemY[i8] = ItemY[k23];
                                    ItemId[i8] = ItemId[k23];
                                    ekm[i8] = ekm[k23];
                                }
                                i8++;
                            }
                        }
                        ItemCount = i8;
                    } else {
                        int j8 = t.fmi(arg2, i1);

                        i1 += 2;
                        int l14 = LocalX + arg2[i1++];
                        int k19 = LocalY + arg2[i1++];

                        if ((j8 & 0x8000) == 0) {
                            ItemX[ItemCount] = l14;
                            ItemY[ItemCount] = k19;
                            ItemId[ItemCount] = j8;
                            ekm[ItemCount] = 0;
                            for (int l23 = 0; l23 < ObjectCount; l23++) {
                                if (ObjectX[l23] != l14 || ObjectY[l23] != k19) {
                                    continue;
                                }
                                ekm[ItemCount] = Ident.ama[ObjectId[l23]];
                                break;
                            }
                            ItemCount++;
                        } else {
                            j8 &= 0x7fff;
                            int i24 = 0;

                            for (int l26 = 0; l26 < ItemCount; l26++) {
                                if (ItemX[l26] != l14 || ItemY[l26] != k19 || ItemId[l26] != j8) {
                                    if (l26 != i24) {
                                        ItemX[i24] = ItemX[l26];
                                        ItemY[i24] = ItemY[l26];
                                        ItemId[i24] = ItemId[l26];
                                        ekm[i24] = ekm[l26];
                                    }
                                    i24++;
                                } else {
                                    j8 = -123;
                                }
                            }
                            ItemCount = i24;
                        }
                    }
                }
                return;
            }
            if (arg0 == 10) {
                for (int j1 = 1; j1 < arg1;) {
                    if (t.fmh(arg2[j1]) == 255) {
                        int k8 = 0;
                        int i15 = LocalX + arg2[j1 + 1] >> 3;
                        int l19 = LocalY + arg2[j1 + 2] >> 3;

                        j1 += 3;
                        for (int j24 = 0; j24 < ObjectCount; j24++) {
                            int i27 = (ObjectX[j24] >> 3) - i15;
                            int l29 = (ObjectY[j24] >> 3) - l19;

                            if (i27 != 0 || l29 != 0) {
                                if (j24 != k8) {
                                    ddf[k8] = ddf[j24];
                                    ddf[k8].chk = k8;
                                    ObjectX[k8] = ObjectX[j24];
                                    ObjectY[k8] = ObjectY[j24];
                                    ObjectId[k8] = ObjectId[j24];
                                    ecb[k8] = ecb[j24];
                                }
                                k8++;
                            } else {
                                efn.bgn(ddf[j24]);
                                Game.gkg(ObjectX[j24], ObjectY[j24], ObjectId[j24]);
                            }
                        }
                        ObjectCount = k8;
                    } else {
                        int l8 = t.fmi(arg2, j1);

                        j1 += 2;
                        int j15 = LocalX + arg2[j1++];
                        int i20 = LocalY + arg2[j1++];
                        int k24 = 0;

                        for (int j27 = 0; j27 < ObjectCount; j27++) {
                            if (ObjectX[j27] != j15 || ObjectY[j27] != i20) {
                                if (j27 != k24) {
                                    ddf[k24] = ddf[j27];
                                    ddf[k24].chk = k24;
                                    ObjectX[k24] = ObjectX[j27];
                                    ObjectY[k24] = ObjectY[j27];
                                    ObjectId[k24] = ObjectId[j27];
                                    ecb[k24] = ecb[j27];
                                }
                                k24++;
                            } else {
                                efn.bgn(ddf[j27]);
                                Game.gkg(ObjectX[j27], ObjectY[j27], ObjectId[j27]);
                            }
                        }
                        ObjectCount = k24;
                        if (l8 != 60000) {
                            int i30 = Game.gjh(j15, i20);
                            int j34;
                            int l37;

                            if (i30 == 0 || i30 == 4) {
                                j34 = Ident.all[l8];
                                l37 = Ident.alm[l8];
                            } else {
                                l37 = Ident.all[l8];
                                j34 = Ident.alm[l8];
                            }
                            int l40 = ((j15 + j15 + j34) * ecj) / 2;
                            int k42 = ((i20 + i20 + l37) * ecj) / 2;
                            int i44 = Ident.alk[l8];
                            i l44 = dkj[i44].cnj();

                            efn.bgm(l44);
                            l44.chk = ObjectCount;
                            l44.cmi(0, i30 * 32, 0);
                            l44.cmk(l40, -Game.gla(l40, k42), k42);
                            l44.cme(true, 48, 48, -50, -10, -50);
                            Game.gjj(j15, i20, l8);
                            if (l8 == 74) {
                                l44.cmk(0, -480, 0);
                            }
                            ObjectX[ObjectCount] = j15;
                            ObjectY[ObjectCount] = i20;
                            ObjectId[ObjectCount] = l8;
                            ecb[ObjectCount] = i30;
                            ddf[ObjectCount++] = l44;
                        }
                    }
                }
                return;
            }
            if (arg0 == 11) {
                int k1 = 1;

                InvCount = arg2[k1++] & 0xff;
                for (int i9 = 0; i9 < InvCount; i9++) {
                    int k15 = t.fmi(arg2, k1);

                    k1 += 2;
                    InvItemId[i9] = k15 & 0x7fff;
                    WearingVar[i9] = k15 / 32768;
                    if (Ident.ItemStackableVar[k15 & 0x7fff] == 0) {
                        InvItemCount[i9] = t.fmm(arg2, k1);
                        if (InvItemCount[i9] >= 128) {
                            k1 += 4;
                        } else {
                            k1++;
                        }
                    } else {
                        InvItemCount[i9] = 1;
                    }
                }
                return;
            }
            if (arg0 == 12) {
                int l1 = t.fmi(arg2, 1);
                int j9 = 3;

                for (int l15 = 0; l15 < l1; l15++) {
                    int j20 = t.fmi(arg2, j9);

                    j9 += 2;
                    NpcObject f1 = eba[j20];
                    byte byte6 = arg2[j9];

                    j9++;
                    if (byte6 == 0) {
                        int j30 = t.fmi(arg2, j9);

                        j9 += 2;
                        if (f1 != null) {
                            f1.gnh = 150;
                            f1.gng = j30;
                        }
                    } else if (byte6 == 1) {
                        byte byte7 = arg2[j9];

                        j9++;
                        if (f1 != null) {
                            String s3 = u.fgd(v.cej(arg2, j9, byte7));
                            boolean flag3 = false;

                            for (int i41 = 0; i41 < super.IgnoreCount; i41++) {
                                if (super.IgnoreList[i41] == f1.PlayerLong) {
                                    flag3 = true;
                                }
                            }
                            if (!flag3) {
                                f1.TalkVar = 150;
                                f1.Message = s3;
                                OnChatMessage(f1.Name, trimColours(f1.Message));
                                DisplayMessage(f1.Name + ": " + f1.Message, 2);
                            }
                        }
                        j9 += byte7;
                    } else if (byte6 == 2) {
                        int k30 = t.fmh(arg2[j9]);

                        j9++;
                        int k34 = t.fmh(arg2[j9]);

                        j9++;
                        int i38 = t.fmh(arg2[j9]);

                        j9++;
                        if (f1 != null) {
                            f1.LastHit = k30;
                            f1.CurrentHits = k34;
                            f1.MaxHits = i38;
                            f1.CombatVar = 200;
                            if (f1 == My) {
                                StatCurrentLevel[3] = k34;
                                StatMaximumLevel[3] = i38;
                                ShowingPopup = false;
                            }
                        }
                    } else if (byte6 == 3) {
                        int l30 = t.fmi(arg2, j9);

                        j9 += 2;
                        int l34 = t.fmi(arg2, j9);

                        j9 += 2;
                        if (f1 != null) {
                            f1.had = l30;
                            f1.haf = l34;
                            f1.hae = -1;
                            f1.hag = ebc;
                        }
                    } else if (byte6 == 4) {
                        int i31 = t.fmi(arg2, j9);

                        j9 += 2;
                        int i35 = t.fmi(arg2, j9);

                        j9 += 2;
                        if (f1 != null) {
                            f1.had = i31;
                            f1.hae = i35;
                            f1.haf = -1;
                            f1.hag = ebc;
                        }
                    } else if (byte6 == 5) {
                        if (f1 != null) {
                            f1.gmg = t.fmi(arg2, j9);
                            j9 += 2;
                            f1.PlayerLong = t.fmk(arg2, j9);
                            j9 += 8;
                            f1.Name = t.PlayerLongToName(f1.PlayerLong);
                            int j31 = t.fmh(arg2[j9]);

                            j9++;
                            for (int j35 = 0; j35 < j31; j35++) {
                                f1.gnd[j35] = t.fmh(arg2[j9]);
                                j9++;
                            }
                            for (int j38 = j31; j38 < 12; j38++) {
                                f1.gnd[j38] = 0;
                            }
                            f1.gnn = arg2[j9++] & 0xff;
                            f1.haa = arg2[j9++] & 0xff;
                            f1.hab = arg2[j9++] & 0xff;
                            f1.hac = arg2[j9++] & 0xff;
                            f1.Combat = arg2[j9++] & 0xff;
                            f1.haj = arg2[j9++] & 0xff;
                        } else {
                            j9 += 14;
                            int k31 = t.fmh(arg2[j9]);

                            j9 += k31 + 1;
                        }
                    } else if (byte6 == 6) {
                        byte byte8 = arg2[j9];

                        j9++;
                        if (f1 != null) {
                            String s4 = v.cej(arg2, j9, byte8);

                            f1.TalkVar = 150;
                            f1.Message = s4;
                            if (f1 == My) {
                                DisplayMessage(f1.Name + ": " + f1.Message, 5);
                            }
                        }
                        j9 += byte8;
                    }
                }
                return;
            }
            if (arg0 == 13) {
                for (int i2 = 1; i2 < arg1;) {
                    if (t.fmh(arg2[i2]) == 255) {
                        int k9 = 0;
                        int i16 = LocalX + arg2[i2 + 1] >> 3;
                        int k20 = LocalY + arg2[i2 + 2] >> 3;

                        i2 += 3;
                        for (int l24 = 0; l24 < WallObjectCount; l24++) {
                            int k27 = (WallObjectX[l24] >> 3) - i16;
                            int l31 = (WallObjectY[l24] >> 3) - k20;

                            if (k27 != 0 || l31 != 0) {
                                if (l24 != k9) {
                                    dkl[k9] = dkl[l24];
                                    dkl[k9].chk = k9 + 10000;
                                    WallObjectX[k9] = WallObjectX[l24];
                                    WallObjectY[k9] = WallObjectY[l24];
                                    WallObjectDir[k9] = WallObjectDir[l24];
                                    WallObjectId[k9] = WallObjectId[l24];
                                }
                                k9++;
                            } else {
                                efn.bgn(dkl[l24]);
                                Game.gke(WallObjectX[l24], WallObjectY[l24], WallObjectDir[l24], WallObjectId[l24]);
                            }
                        }
                        WallObjectCount = k9;
                    } else {
                        int l9 = t.fmi(arg2, i2);

                        i2 += 2;
                        int j16 = LocalX + arg2[i2++];
                        int l20 = LocalY + arg2[i2++];
                        byte byte5 = arg2[i2++];
                        int l27 = 0;

                        for (int i32 = 0; i32 < WallObjectCount; i32++) {
                            if (WallObjectX[i32] != j16 || WallObjectY[i32] != l20 || WallObjectDir[i32] != byte5) {
                                if (i32 != l27) {
                                    dkl[l27] = dkl[i32];
                                    dkl[l27].chk = l27 + 10000;
                                    WallObjectX[l27] = WallObjectX[i32];
                                    WallObjectY[l27] = WallObjectY[i32];
                                    WallObjectDir[l27] = WallObjectDir[i32];
                                    WallObjectId[l27] = WallObjectId[i32];
                                }
                                l27++;
                            } else {
                                efn.bgn(dkl[i32]);
                                Game.gke(WallObjectX[i32], WallObjectY[i32], WallObjectDir[i32], WallObjectId[i32]);
                            }
                        }
                        WallObjectCount = l27;
                        if (l9 != 65535) {
                            Game.gkj(j16, l20, byte5, l9);
                            i k35 = feg(j16, l20, byte5, l9, WallObjectCount);

                            dkl[WallObjectCount] = k35;
                            WallObjectX[WallObjectCount] = j16;
                            WallObjectY[WallObjectCount] = l20;
                            WallObjectId[WallObjectCount] = l9;
                            WallObjectDir[WallObjectCount++] = byte5;
                        }
                    }
                }
                return;
            }
            if (arg0 == 14) {
                dnk = NpcCount;
                NpcCount = 0;
                for (int j2 = 0; j2 < dnk; j2++) {
                    eii[j2] = Npc[j2];
                }
                int i10 = 8;
                int k16 = t.fmn(arg2, i10, 8);

                i10 += 8;
                for (int i21 = 0; i21 < k16; i21++) {
                    NpcObject f2 = eii[i21];
                    int i28 = t.fmn(arg2, i10, 1);

                    i10++;
                    if (i28 != 0) {
                        int j32 = t.fmn(arg2, i10, 1);

                        i10++;
                        if (j32 == 0) {
                            int l35 = t.fmn(arg2, i10, 3);

                            i10 += 3;
                            int k38 = f2.PathIndex;
                            int j41 = f2.XCoordPath[k38];
                            int l42 = f2.YCoordPath[k38];

                            if (l35 == 2 || l35 == 1 || l35 == 3) {
                                j41 += ecj;
                            }
                            if (l35 == 6 || l35 == 5 || l35 == 7) {
                                j41 -= ecj;
                            }
                            if (l35 == 4 || l35 == 3 || l35 == 5) {
                                l42 += ecj;
                            }
                            if (l35 == 0 || l35 == 1 || l35 == 7) {
                                l42 -= ecj;
                            }
                            f2.gmm = l35;
                            f2.PathIndex = k38 = (k38 + 1) % 10;
                            f2.XCoordPath[k38] = j41;
                            f2.YCoordPath[k38] = l42;
                        } else {
                            int i36 = t.fmn(arg2, i10, 4);

                            if ((i36 & 0xc) == 12) {
                                i10 += 2;
                                continue;
                            }
                            f2.gmm = t.fmn(arg2, i10, 4);
                            i10 += 4;
                        }
                    }
                    Npc[NpcCount++] = f2;
                }
                while (i10 + 34 < arg1 * 8) {
                    int i25 = t.fmn(arg2, i10, 12);

                    i10 += 12;
                    int j28 = t.fmn(arg2, i10, 5);

                    i10 += 5;
                    if (j28 > 15) {
                        j28 -= 32;
                    }
                    int k32 = t.fmn(arg2, i10, 5);

                    i10 += 5;
                    if (k32 > 15) {
                        k32 -= 32;
                    }
                    int j36 = t.fmn(arg2, i10, 4);

                    i10 += 4;
                    int l38 = (LocalX + j28) * ecj + 64;
                    int k41 = (LocalY + k32) * ecj + 64;
                    int i43 = t.fmn(arg2, i10, 10);

                    i10 += 10;
                    if (i43 >= Ident.NpcTotalCount) {
                        i43 = 24;
                    }
                    faj(i25, l38, k41, j36, i43);
                }
                return;
            }
            if (arg0 == 15) {
                int k2 = t.fmi(arg2, 1);
                int j10 = 3;

                for (int l16 = 0; l16 < k2; l16++) {
                    int j21 = t.fmi(arg2, j10);

                    j10 += 2;
                    NpcObject f3 = dgj[j21];
                    int k28 = t.fmh(arg2[j10]);

                    j10++;
                    if (k28 == 1) {
                        int l32 = t.fmi(arg2, j10);

                        j10 += 2;
                        byte byte9 = arg2[j10];

                        j10++;
                        if (f3 != null) {
                            String s5 = v.cej(arg2, j10, byte9);

                            f3.TalkVar = 150;
                            f3.Message = s5;
                            if (l32 == My.ServerIndex) {
                                OnChatMessage(Ident.NpcName[f3.Id], trimColours(f3.Message));
                                DisplayMessage("@yel@" + Ident.NpcName[f3.Id] + ": " + f3.Message, 5);
                            }
                        }
                        j10 += byte9;
                    } else if (k28 == 2) {
                        int i33 = t.fmh(arg2[j10]);

                        j10++;
                        int k36 = t.fmh(arg2[j10]);

                        j10++;
                        int i39 = t.fmh(arg2[j10]);

                        j10++;
                        if (f3 != null) {
                            f3.LastHit = i33;
                            f3.CurrentHits = k36;
                            f3.MaxHits = i39;
                            f3.CombatVar = 200;
                        }
                    }
                }
                return;
            }
            if (arg0 == 16) // show quest menu
            {
                QuestMenu = true;
                int l2 = t.fmh(arg2[1]);

                QuestMenuOptionsCount = l2;
                int k10 = 2;

                for (int i17 = 0; i17 < l2; i17++) {
                    int k21 = t.fmh(arg2[k10]);

                    k10++;
                    QuestMenuOptions[i17] = new String(arg2, k10, k21);
                    k10 += k21;
                }
                return;
            }
            if (arg0 == 17) // close quest menu
            {
                QuestMenu = false;
                return;
            }
            if (arg0 == 18) {
                dcj = true;
                dgf = t.fmi(arg2, 1);
                dnd = t.fmi(arg2, 3);
                dne = t.fmi(arg2, 5);
                din = t.fmi(arg2, 7);
                dnf = t.fmi(arg2, 9);
                dne -= din * dnf;
                return;
            }
            if (arg0 == 19) // update my stats
            {
                int i3 = 1;

                for (int l10 = 0; l10 < 18; l10++) {
                    StatCurrentLevel[l10] = t.fmh(arg2[i3++]);
                }
                for (int j17 = 0; j17 < 18; j17++) {
                    StatMaximumLevel[j17] = t.fmh(arg2[i3++]);
                }
                for (int l21 = 0; l21 < 18; l21++) {
                    StatTotalExpVar[l21] = t.fmj(arg2, i3);
                    i3 += 4;
                }
                QuestPoints = t.fmh(arg2[i3++]);
                return;
            }
            if (arg0 == 20) {
                for (int j3 = 0; j3 < 5; j3++) {
                    ebb[j3] = t.fmh(arg2[1 + j3]);
                }
                return;
            }
            if (arg0 == 21) {
                dfl = 250;
                return;
            }
            if (arg0 == 22) {
                int k3 = (arg1 - 1) / 4;

                for (int i11 = 0; i11 < k3; i11++) {
                    int k17 = LocalX + t.fml(arg2, 1 + i11 * 4) >> 3;
                    int i22 = LocalY + t.fml(arg2, 3 + i11 * 4) >> 3;
                    int j25 = 0;

                    for (int l28 = 0; l28 < ItemCount; l28++) {
                        int j33 = (ItemX[l28] >> 3) - k17;
                        int l36 = (ItemY[l28] >> 3) - i22;

                        if (j33 != 0 || l36 != 0) {
                            if (l28 != j25) {
                                ItemX[j25] = ItemX[l28];
                                ItemY[j25] = ItemY[l28];
                                ItemId[j25] = ItemId[l28];
                                ekm[j25] = ekm[l28];
                            }
                            j25++;
                        }
                    }
                    ItemCount = j25;
                    j25 = 0;
                    for (int k33 = 0; k33 < ObjectCount; k33++) {
                        int i37 = (ObjectX[k33] >> 3) - k17;
                        int j39 = (ObjectY[k33] >> 3) - i22;

                        if (i37 != 0 || j39 != 0) {
                            if (k33 != j25) {
                                ddf[j25] = ddf[k33];
                                ddf[j25].chk = j25;
                                ObjectX[j25] = ObjectX[k33];
                                ObjectY[j25] = ObjectY[k33];
                                ObjectId[j25] = ObjectId[k33];
                                ecb[j25] = ecb[k33];
                            }
                            j25++;
                        } else {
                            efn.bgn(ddf[k33]);
                            Game.gkg(ObjectX[k33], ObjectY[k33], ObjectId[k33]);
                        }
                    }
                    ObjectCount = j25;
                    j25 = 0;
                    for (int j37 = 0; j37 < WallObjectCount; j37++) {
                        int k39 = (WallObjectX[j37] >> 3) - k17;
                        int l41 = (WallObjectY[j37] >> 3) - i22;

                        if (k39 != 0 || l41 != 0) {
                            if (j37 != j25) {
                                dkl[j25] = dkl[j37];
                                dkl[j25].chk = j25 + 10000;
                                WallObjectX[j25] = WallObjectX[j37];
                                WallObjectY[j25] = WallObjectY[j37];
                                WallObjectDir[j25] = WallObjectDir[j37];
                                WallObjectId[j25] = WallObjectId[j37];
                            }
                            j25++;
                        } else {
                            efn.bgn(dkl[j37]);
                            Game.gke(WallObjectX[j37], WallObjectY[j37], WallObjectDir[j37], WallObjectId[j37]);
                        }
                    }
                    WallObjectCount = j25;
                }
                return;
            }
            if (arg0 == 23) {
                int[] stuff = { 0, 3, 5, 6, 7};

                Connection.SendID(65);
                Connection.SendVar(1);
                Connection.SendVar(stuff[Rand(0, stuff.length - 1)]);
                Connection.SendVar(1);
                Connection.SendVar(2);
                Connection.SendVar(Rand(0, 9));
                Connection.SendVar(Rand(0, 14));
                Connection.SendVar(Rand(0, 14));
                Connection.SendVar(Rand(0, 4));
                Connection.End();
                // efc = true;
                return;
            }
            if (arg0 == 24) // trade opened
            {
                int l3 = t.fmi(arg2, 1);

                if (eba[l3] != null) {
                    TradeOpponentName = eba[l3].Name;
                }
                TradeScreen1 = true;
                OpponentTradeAccepted = false;
                MyTradeAccepted1 = false;
                TradeIndex = 0;
                OpponentTradeIndex = 0;
                return;
            }
            if (arg0 == 25) // trade declined
            {
                TradeScreen1 = false;
                TradeScreen2 = false;
                return;
            }
            if (arg0 == 26) // item offered in trade?
            {
                OpponentTradeIndex = arg2[1] & 0xff;
                int i4 = 2;

                for (int j11 = 0; j11 < OpponentTradeIndex; j11++) {
                    OpponentTradeItem[j11] = t.fmi(arg2, i4);
                    i4 += 2;
                    OpponentTradeAmount[j11] = t.fmj(arg2, i4);
                    i4 += 4;
                }
                OpponentTradeAccepted = false;
                MyTradeAccepted1 = false;
                return;
            }
            if (arg0 == 27) {
                byte byte0 = arg2[1];

                OpponentTradeAccepted = (byte0 == 1);
                return;
            }
            if (arg0 == 28) {
                InShop = true;
                int j4 = 1;
                int k11 = arg2[j4++] & 0xff;
                byte byte4 = arg2[j4++];

                dnh = arg2[j4++] & 0xff;
                dni = arg2[j4++] & 0xff;
                for (int j22 = 0; j22 < 40; j22++) {
                    ShopItem[j22] = -1;
                }
                for (int k25 = 0; k25 < k11; k25++) {
                    ShopItem[k25] = t.fmi(arg2, j4);
                    j4 += 2;
                    ShopAmount[k25] = t.fmi(arg2, j4);
                    j4 += 2;
                    ShopPrice[k25] = arg2[j4++];
                }
                if (byte4 == 1) {
                    int i29 = 39;

                    for (int l33 = 0; l33 < InvCount; l33++) {
                        if (i29 < k11) {
                            break;
                        }
                        boolean flag2 = false;

                        for (int l39 = 0; l39 < 40; l39++) {
                            if (ShopItem[l39] != InvItemId[l33]) {
                                continue;
                            }
                            flag2 = true;
                            break;
                        }

                        if (InvItemId[l33] == 10) {
                            flag2 = true;
                        }
                        if (!flag2) {
                            ShopItem[i29] = InvItemId[l33] & 0x7fff;
                            ShopAmount[i29] = 0;
                            ShopPrice[i29] = 0;
                            i29--;
                        }
                    }
                }
                if (SelectedShopItem >= 0 && SelectedShopItem < 40 && ShopItem[SelectedShopItem] != SelectedShopItemId) {
                    SelectedShopItem = -1;
                    SelectedShopItemId = -2;
                }
                return;
            }
            if (arg0 == 29) // close shop
            {
                InShop = false;
                return;
            }
            if (arg0 == 30) {
                byte byte1 = arg2[1];

                MyTradeAccepted1 = (byte1 == 1);
                return;
            }
            if (arg0 == 31) {
                efb = t.fmh(arg2[1]) == 1;
                dek = t.fmh(arg2[2]) == 1;
                ejl = t.fmh(arg2[3]) == 1;
                return;
            }
            if (arg0 == 32) {
                for (int k4 = 0; k4 < arg1 - 1; k4++) {
                    boolean flag = arg2[k4 + 1] == 1;

                    if (!PrayerIsOn[k4] && flag) {
                        fdb("prayeron");
                    }
                    if (PrayerIsOn[k4] && !flag) {
                        fdb("prayeroff");
                    }
                    PrayerIsOn[k4] = flag;
                }
                return;
            }
            if (arg0 == 33) {
                for (int l4 = 0; l4 < 50; l4++) {
                    QuestComplete[l4] = arg2[l4 + 1] == 1;
                }
                return;
            }
            if (arg0 == 34) {
                InBank = true;
                int i5 = 1;

                dec = arg2[i5++] & 0xff;
                dnb = arg2[i5++] & 0xff;
                for (int l11 = 0; l11 < dec; l11++) {
                    ecf[l11] = t.fmi(arg2, i5);
                    i5 += 2;
                    ecg[l11] = t.fmm(arg2, i5);
                    if (ecg[l11] >= 128) {
                        i5 += 4;
                    } else {
                        i5++;
                    }
                }
                ene();
                return;
            }
            if (arg0 == 35) // close bank
            {
                InBank = false;
                return;
            }
            if (arg0 == 36) {
                int j5 = arg2[1] & 0xff;

                OldExpVar[j5] = StatTotalExpVar[j5];
                StatTotalExpVar[j5] = t.fmj(arg2, 2);
                if (StatTotalExpVar[j5] > OldExpVar[j5]) {
                    MacroExp += (StatTotalExpVar[j5] - OldExpVar[j5]) / 4;
                }
                return;
            }
            if (arg0 == 37) {
                int k5 = t.fmi(arg2, 1);

                if (eba[k5] != null) {
                    ekg = eba[k5].Name;
                }
                deh = true;
                dkg = 0;
                edl = 0;
                dgm = false;
                dgn = false;
                dla = false;
                dlb = false;
                dlc = false;
                dld = false;
                return;
            }
            if (arg0 == 38) {
                deh = false;
                dll = false;
                return;
            }
            if (arg0 == 39) // goto trade screen 2
            {
                TradeScreen2 = true;
                MyTradeAccepted2 = false;
                TradeScreen1 = false;
                int l5 = 1;

                ekf = t.fmk(arg2, l5);
                l5 += 8;
                eje = arg2[l5++] & 0xff;
                for (int i12 = 0; i12 < eje; i12++) {
                    ejf[i12] = t.fmi(arg2, l5);
                    l5 += 2;
                    ejg[i12] = t.fmj(arg2, l5);
                    l5 += 4;
                }
                egh = arg2[l5++] & 0xff;
                for (int l17 = 0; l17 < egh; l17++) {
                    egi[l17] = t.fmi(arg2, l5);
                    l5 += 2;
                    egj[l17] = t.fmj(arg2, l5);
                    l5 += 4;
                }
                return;
            }
            if (arg0 == 40) {
                edl = arg2[1] & 0xff;
                int i6 = 2;

                for (int j12 = 0; j12 < edl; j12++) {
                    edm[j12] = t.fmi(arg2, i6);
                    i6 += 2;
                    edn[j12] = t.fmj(arg2, i6);
                    i6 += 4;
                }
                dgm = false;
                dgn = false;
                return;
            }
            if (arg0 == 41) {
                dla = (arg2[1] == 1);
                dlb = (arg2[2] == 1);
                dlc = (arg2[3] == 1);
                dld = (arg2[4] == 1);
                dgm = false;
                dgn = false;
                return;
            }
            if (arg0 == 42) {
                int j6 = 1;
                int k12 = arg2[j6++] & 0xff;
                int i18 = t.fmi(arg2, j6);

                j6 += 2;
                int k22 = t.fmm(arg2, j6);

                if (k22 >= 128) {
                    j6 += 4;
                } else {
                    j6++;
                }
                if (k22 == 0) {
                    dec--;
                    for (int l25 = k12; l25 < dec; l25++) {
                        ecf[l25] = ecf[l25 + 1];
                        ecg[l25] = ecg[l25 + 1];
                    }
                } else {
                    ecf[k12] = i18;
                    ecg[k12] = k22;
                    if (k12 >= dec) {
                        dec = k12 + 1;
                    }
                }
                ene();
                return;
            }
            if (arg0 == 43) {
                int k6 = 1;
                int l12 = 1;
                int j18 = arg2[k6++] & 0xff;
                int l22 = t.fmi(arg2, k6);

                k6 += 2;
                if (Ident.ItemStackableVar[l22 & 0x7fff] == 0) {
                    l12 = t.fmm(arg2, k6);
                    if (l12 >= 128) {
                        k6 += 4;
                    } else {
                        k6++;
                    }
                }
                InvItemId[j18] = l22 & 0x7fff;
                WearingVar[j18] = l22 / 32768;
                InvItemCount[j18] = l12;
                if (j18 >= InvCount) {
                    InvCount = j18 + 1;
                }
                return;
            }
            if (arg0 == 44) {
                int l6 = arg2[1] & 0xff;

                InvCount--;
                for (int i13 = l6; i13 < InvCount; i13++) {
                    InvItemId[i13] = InvItemId[i13 + 1];
                    InvItemCount[i13] = InvItemCount[i13 + 1];
                    WearingVar[i13] = WearingVar[i13 + 1];
                }
                return;
            }
            if (arg0 == 45) {
                int i7 = 1;
                int j13 = arg2[i7++] & 0xff;

                StatCurrentLevel[j13] = t.fmh(arg2[i7++]);
                StatMaximumLevel[j13] = t.fmh(arg2[i7++]);
                StatTotalExpVar[j13] = t.fmj(arg2, i7);
                i7 += 4;
                return;
            }
            if (arg0 == 46) {
                byte byte2 = arg2[1];

                dgm = (byte2 == 1);
                return;
            }
            if (arg0 == 47) {
                byte byte3 = arg2[1];

                dgn = (byte3 == 1);
                return;
            }
            if (arg0 == 48) {
                dll = true;
                dlm = false;
                deh = false;
                int j7 = 1;

                eme = t.fmk(arg2, j7);
                j7 += 8;
                OpponentsStakeCount = arg2[j7++] & 0xff;
                for (int k13 = 0; k13 < OpponentsStakeCount; k13++) {
                    OpponentsStakeId[k13] = t.fmi(arg2, j7);
                    j7 += 2;
                    OpponentsStakeAmount[k13] = t.fmj(arg2, j7);
                    j7 += 4;
                }
                MyStakeCount = arg2[j7++] & 0xff;
                for (int k18 = 0; k18 < MyStakeCount; k18++) {
                    MyStakeId[k18] = t.fmi(arg2, j7);
                    j7 += 2;
                    MyStakeAmount[k18] = t.fmj(arg2, j7);
                    j7 += 4;
                }
                StakeRetreatVar = arg2[j7++] & 0xff;
                StakeMagicVar = arg2[j7++] & 0xff;
                StakePrayerVar = arg2[j7++] & 0xff;
                StakeWeaponsVar = arg2[j7++] & 0xff;
                return;
            }
            if (arg0 == 49) // play sounds
            {
                String s1 = new String(arg2, 1, arg1 - 1);

                fdb(s1);
                return;
            }
            if (arg0 == 50) {
                if (ean < 50) {
                    int k7 = arg2[1] & 0xff;
                    int l13 = arg2[2] + LocalX;
                    int l18 = arg2[3] + LocalY;

                    ekn[ean] = k7;
                    dna[ean] = 0;
                    dnc[ean] = l13;
                    dgb[ean] = l18;
                    ean++;
                }
                return;
            }
            if (arg0 == 51) {
                return;
            }
            if (arg0 == 52) {
                ServerPopupMessage = new String(arg2, 1, arg1 - 1);
                ShowingPopup = true;
                djj = false;
                return;
            }
            if (arg0 == 53) {
                ServerPopupMessage = new String(arg2, 1, arg1 - 1);
                ShowingPopup = true;
                djj = true;
                return;
            }
            if (arg0 == 54) {
                FatigueVar = t.fmi(arg2, 1);
                return;
            }
            if (arg0 == 55) // sleep
            {
                if (!Sleeping) {
                    SleepFatigueVar = FatigueVar;
                }
                Sleeping = true;
                super.fkl = "";
                super.fkm = "";
                Gfx.cbk(dfb + 1, arg2);
                SleepMessage = null;
                saveOutput(HCfile, MakePic(arg2));
                mod = SLfile.lastModified();
                oword = ReadLine(SLfile);
                sentword = false;
                LChecked = 0;
                return;
            }
            if (arg0 == 56) {
                SleepFatigueVar = t.fmi(arg2, 1);
                return;
            }
            if (arg0 == 57) {
                Sleeping = false;
                return;
            }
            if (arg0 == 58) // sleepword wrong
            {
                SleepMessage = "Incorrect - Please wait...";
                return;
            }
            if (arg0 == 59) {
                edh = t.fmi(arg2, 1) * 32;
                return;
            }
        } catch (RuntimeException runtimeexception) {
            if (dkn < 3) {
                super.Connection.SendID(57);
                super.Connection.SendString(runtimeexception.toString());
                super.Connection.End();
                super.Connection.SendID(57);
                super.Connection.SendString("p-type:" + arg0 + " p-size:" + arg1);
                super.Connection.End();
                super.Connection.SendID(57);
                super.Connection.SendString("rx:" + LocalX + " ry:" + LocalY + " num3l:" + ObjectCount);
                super.Connection.End();
                String s2 = "";

                for (int i19 = 0; i19 < 80 && i19 < arg1; i19++) {
                    s2 = s2 + arg2[i19] + " ";
                }
                super.Connection.SendID(57);
                super.Connection.SendString(s2);
                super.Connection.End();
                dkn++;
            }
        }
    }

    private final void ShowQuestMenu() {
        if (MouseButtonDown != 0) {
            for (int l = 0; l < QuestMenuOptionsCount; l++) {
                if (super.MouseX >= Gfx.cef(QuestMenuOptions[l], 1) || super.MouseY <= l * 12
                        || super.MouseY >= 12 + l * 12) {
                    continue;
                }
                super.Connection.SendID(50);
                super.Connection.SendVar(l);
                super.Connection.End();
                break;
            }
            MouseButtonDown = 0;
            QuestMenu = false;
            return;
        }
        for (int i1 = 0; i1 < QuestMenuOptionsCount; i1++) {
            int j1 = 65535;

            if (super.MouseX < Gfx.cef(QuestMenuOptions[i1], 1) && super.MouseY > i1 * 12 && super.MouseY < 12 + i1 * 12) {
                j1 = 0xff0000;
            }
            Gfx.DrawStr(QuestMenuOptions[i1], 6, 12 + i1 * 12, 1, j1);
        }

    }

    private final NpcObject eml(int serverindex, int x, int y, int arg3) // new Player
    {
        if (eba[serverindex] == null) {
            eba[serverindex] = new NpcObject();
            eba[serverindex].ServerIndex = serverindex;
            eba[serverindex].gmg = 0;
        }
        NpcObject f1 = eba[serverindex];
        boolean flag = false;

        for (int l = 0; l < TempPlayerCount; l++) {
            if (dmn[l].ServerIndex != serverindex) {
                continue;
            }
            flag = true;
            break;
        }
        if (flag) {
            f1.gmm = arg3;
            int i1 = f1.PathIndex;

            if (x != f1.XCoordPath[i1] || y != f1.YCoordPath[i1]) {
                f1.PathIndex = i1 = (i1 + 1) % 10;
                f1.XCoordPath[i1] = x;
                f1.YCoordPath[i1] = y;
            }
        } else {
            f1.ServerIndex = serverindex;
            f1.gmn = 0;
            f1.PathIndex = 0;
            f1.XCoordPath[0] = f1.XCoord = x;
            f1.YCoordPath[0] = f1.YCoord = y;
            f1.gmm = f1.Dir = arg3;
            f1.gmk = 0;
            OnNewPlayer(serverindex, x, y, arg3);
        }
        Player[PlayerCount++] = f1;
        return f1;
    }

    private void WithdrawEx(int id, int amount, boolean out) {
        try {
            Withdraw(id, amount, out);
        } catch (Exception e) {}
    }

    private final void ShowBankScreen() {
        char c1 = '\u0198';
        char c2 = '\u014E';

        if (dha > 0 && BankCount <= 48) {
            dha = 0;
        }
        if (dha > 1 && BankCount <= 96) {
            dha = 1;
        }
        if (dha > 2 && BankCount <= 144) {
            dha = 2;
        }
        if (dma >= BankCount || dma < 0) {
            dma = -1;
        }
        if (dma != -1 && edb[dma] != dmb) {
            dma = -1;
            dmb = -2;
        }
        if (MouseButtonDown != 0) {
            MouseButtonDown = 0;
            int l = super.MouseX - (256 - c1 / 2);
            int j1 = super.MouseY - (170 - c2 / 2);

            if (l >= 0 && j1 >= 12 && l < 408 && j1 < 280) {
                int l1 = dha * 48;

                for (int k2 = 0; k2 < 6; k2++) {
                    for (int i3 = 0; i3 < 8; i3++) {
                        int k7 = 7 + i3 * 49;
                        int i8 = 28 + k2 * 34;

                        if (l > k7 && l < k7 + 49 && j1 > i8 && j1 < i8 + 34 && l1 < BankCount && edb[l1] != -1) {
                            dmb = edb[l1];
                            dma = l1;
                        }
                        l1++;
                    }
                }
                l = 256 - c1 / 2;
                j1 = 170 - c2 / 2;
                int j3;

                if (dma < 0) {
                    j3 = -1;
                } else {
                    j3 = edb[dma];
                }
                if (j3 != -1) {
                    int i2 = edc[dma];

                    if (Ident.ItemStackableVar[j3] == 1 && i2 > 1) {
                        i2 = 1;
                    }
                    if (i2 >= 1 && super.MouseX >= l + 220 && super.MouseY >= j1 + 238 && super.MouseX < l + 250
                            && super.MouseY <= j1 + 249) {
                        WithdrawEx(j3, 1, true);
                    }
                    if (i2 >= 5 && super.MouseX >= l + 250 && super.MouseY >= j1 + 238 && super.MouseX < l + 280
                            && super.MouseY <= j1 + 249) {
                        WithdrawEx(j3, 5, true);
                    }
                    if (i2 >= 25 && super.MouseX >= l + 280 && super.MouseY >= j1 + 238 && super.MouseX < l + 305
                            && super.MouseY <= j1 + 249) {
                        WithdrawEx(j3, 25, true);
                    }
                    if (i2 >= 100 && super.MouseX >= l + 305 && super.MouseY >= j1 + 238 && super.MouseX < l + 335
                            && super.MouseY <= j1 + 249) {
                        WithdrawEx(j3, 100, true);
                    }
                    if (i2 >= 500 && super.MouseX >= l + 335 && super.MouseY >= j1 + 238 && super.MouseX < l + 368
                            && super.MouseY <= j1 + 249) {
                        WithdrawEx(j3, 500, true);
                    }
                    if (i2 >= 2500 && super.MouseX >= l + 370 && super.MouseY >= j1 + 238 && super.MouseX < l + 400
                            && super.MouseY <= j1 + 249) {
                        WithdrawEx(j3, 2500, true);
                    }
                    if (InvAmount(j3) >= 1 && super.MouseX >= l + 220 && super.MouseY >= j1 + 263
                            && super.MouseX < l + 250 && super.MouseY <= j1 + 274) {
                        WithdrawEx(j3, 1, false);
                    }
                    if (InvAmount(j3) >= 5 && super.MouseX >= l + 250 && super.MouseY >= j1 + 263
                            && super.MouseX < l + 280 && super.MouseY <= j1 + 274) {
                        WithdrawEx(j3, 5, false);
                    }
                    if (InvAmount(j3) >= 25 && super.MouseX >= l + 280 && super.MouseY >= j1 + 263
                            && super.MouseX < l + 305 && super.MouseY <= j1 + 274) {
                        WithdrawEx(j3, 25, false);
                    }
                    if (InvAmount(j3) >= 100 && super.MouseX >= l + 305 && super.MouseY >= j1 + 263
                            && super.MouseX < l + 335 && super.MouseY <= j1 + 274) {
                        WithdrawEx(j3, 100, false);
                    }
                    if (InvAmount(j3) >= 500 && super.MouseX >= l + 335 && super.MouseY >= j1 + 263
                            && super.MouseX < l + 368 && super.MouseY <= j1 + 274) {
                        WithdrawEx(j3, 500, false);
                    }
                    if (InvAmount(j3) >= 2500 && super.MouseX >= l + 370 && super.MouseY >= j1 + 263
                            && super.MouseX < l + 400 && super.MouseY <= j1 + 274) {
                        WithdrawEx(j3, 2500, false);
                    }
                }
            } else if (BankCount > 48 && l >= 50 && l <= 115 && j1 <= 12) {
                dha = 0;
            } else if (BankCount > 48 && l >= 115 && l <= 180 && j1 <= 12) {
                dha = 1;
            } else if (BankCount > 96 && l >= 180 && l <= 245 && j1 <= 12) {
                dha = 2;
            } else if (BankCount > 144 && l >= 245 && l <= 310 && j1 <= 12) {
                dha = 3;
            } else {
                super.Connection.SendID(49);
                super.Connection.End();
                InBank = false;
                return;
            }
        }
        int i1 = 256 - c1 / 2;
        int k1 = 170 - c2 / 2;

        Gfx.DrawBox(i1, k1, 408, 12, 192);
        int j2 = 0x989898;

        Gfx.cam(i1, k1 + 12, 408, 17, j2, 160);
        Gfx.cam(i1, k1 + 29, 8, 204, j2, 160);
        Gfx.cam(i1 + 399, k1 + 29, 9, 204, j2, 160);
        Gfx.cam(i1, k1 + 233, 408, 47, j2, 160);
        Gfx.DrawStr("Bank", i1 + 1, k1 + 10, 1, 0xffffff);
        int l2 = 50;

        if (BankCount > 48) {
            int k3 = 0xffffff;

            if (dha == 0) {
                k3 = 0xff0000;
            } else if (super.MouseX > i1 + l2 && super.MouseY >= k1 && super.MouseX < i1 + l2 + 65
                    && super.MouseY < k1 + 12) {
                k3 = 0xffff00;
            }
            Gfx.DrawStr("<page 1>", i1 + l2, k1 + 10, 1, k3);
            l2 += 65;
            k3 = 0xffffff;
            if (dha == 1) {
                k3 = 0xff0000;
            } else if (super.MouseX > i1 + l2 && super.MouseY >= k1 && super.MouseX < i1 + l2 + 65
                    && super.MouseY < k1 + 12) {
                k3 = 0xffff00;
            }
            Gfx.DrawStr("<page 2>", i1 + l2, k1 + 10, 1, k3);
            l2 += 65;
        }
        if (BankCount > 96) {
            int l3 = 0xffffff;

            if (dha == 2) {
                l3 = 0xff0000;
            } else if (super.MouseX > i1 + l2 && super.MouseY >= k1 && super.MouseX < i1 + l2 + 65
                    && super.MouseY < k1 + 12) {
                l3 = 0xffff00;
            }
            Gfx.DrawStr("<page 3>", i1 + l2, k1 + 10, 1, l3);
            l2 += 65;
        }
        if (BankCount > 144) {
            int i4 = 0xffffff;

            if (dha == 3) {
                i4 = 0xff0000;
            } else if (super.MouseX > i1 + l2 && super.MouseY >= k1 && super.MouseX < i1 + l2 + 65
                    && super.MouseY < k1 + 12) {
                i4 = 0xffff00;
            }
            Gfx.DrawStr("<page 4>", i1 + l2, k1 + 10, 1, i4);
            l2 += 65;
        }
        int j4 = 0xffffff;

        if (super.MouseX > i1 + 320 && super.MouseY >= k1 && super.MouseX < i1 + 408 && super.MouseY < k1 + 12) {
            j4 = 0xff0000;
        }
        Gfx.cdk("Close window", i1 + 406, k1 + 10, 1, j4);
        Gfx.DrawStr("Number in bank in green", i1 + 7, k1 + 24, 1, 65280);
        Gfx.DrawStr("Number held in blue", i1 + 289, k1 + 24, 1, 65535);
        int l7 = 0xd0d0d0;
        int j8 = dha * 48;

        for (int l8 = 0; l8 < 6; l8++) {
            for (int i9 = 0; i9 < 8; i9++) {
                int k9 = i1 + 7 + i9 * 49;
                int l9 = k1 + 28 + l8 * 34;

                if (dma == j8) {
                    Gfx.cam(k9, l9, 49, 34, 0xff0000, 160);
                } else {
                    Gfx.cam(k9, l9, 49, 34, l7, 160);
                }
                Gfx.DrawBorder(k9, l9, 50, 35, 0);
                if (j8 < BankCount && edb[j8] != -1) {
                    Gfx.cdd(k9, l9, 48, 32, den + Ident.PictureOffset[edb[j8]], Ident.ajk[edb[j8]], 0, 0, false);
                    Gfx.DrawStr(String.valueOf(edc[j8]), k9 + 1, l9 + 10, 1, 65280);
                    Gfx.cdk(String.valueOf(InvAmount(edb[j8])), k9 + 47, l9 + 29, 1, 65535);
                }
                j8++;
            }
        }
        Gfx.cbc(i1 + 5, k1 + 256, 398, 0);
        if (dma == -1) {
            Gfx.DrawCenteredStr("Select an object to withdraw or deposit", i1 + 204, k1 + 248, 3, 0xffff00);
            return;
        }
        int j9;

        if (dma < 0) {
            j9 = -1;
        } else {
            j9 = edb[dma];
        }
        if (j9 != -1) {
            int k8 = edc[dma];

            if (Ident.ItemStackableVar[j9] == 1 && k8 > 1) {
                k8 = 1;
            }
            if (k8 > 0) {
                Gfx.DrawStr("Withdraw " + Ident.ItemName[j9] + CheckId(j9), i1 + 2, k1 + 248, 1, 0xffffff);
                int k4 = 0xffffff;

                if (super.MouseX >= i1 + 220 && super.MouseY >= k1 + 238 && super.MouseX < i1 + 250
                        && super.MouseY <= k1 + 249) {
                    k4 = 0xff0000;
                }
                Gfx.DrawStr("One", i1 + 222, k1 + 248, 1, k4);
                if (k8 >= 5) {
                    int l4 = 0xffffff;

                    if (super.MouseX >= i1 + 250 && super.MouseY >= k1 + 238 && super.MouseX < i1 + 280
                            && super.MouseY <= k1 + 249) {
                        l4 = 0xff0000;
                    }
                    Gfx.DrawStr("Five", i1 + 252, k1 + 248, 1, l4);
                }
                if (k8 >= 25) {
                    int i5 = 0xffffff;

                    if (super.MouseX >= i1 + 280 && super.MouseY >= k1 + 238 && super.MouseX < i1 + 305
                            && super.MouseY <= k1 + 249) {
                        i5 = 0xff0000;
                    }
                    Gfx.DrawStr("25", i1 + 282, k1 + 248, 1, i5);
                }
                if (k8 >= 100) {
                    int j5 = 0xffffff;

                    if (super.MouseX >= i1 + 305 && super.MouseY >= k1 + 238 && super.MouseX < i1 + 335
                            && super.MouseY <= k1 + 249) {
                        j5 = 0xff0000;
                    }
                    Gfx.DrawStr("100", i1 + 307, k1 + 248, 1, j5);
                }
                if (k8 >= 500) {
                    int k5 = 0xffffff;

                    if (super.MouseX >= i1 + 335 && super.MouseY >= k1 + 238 && super.MouseX < i1 + 368
                            && super.MouseY <= k1 + 249) {
                        k5 = 0xff0000;
                    }
                    Gfx.DrawStr("500", i1 + 337, k1 + 248, 1, k5);
                }
                if (k8 >= 2500) {
                    int l5 = 0xffffff;

                    if (super.MouseX >= i1 + 370 && super.MouseY >= k1 + 238 && super.MouseX < i1 + 400
                            && super.MouseY <= k1 + 249) {
                        l5 = 0xff0000;
                    }
                    Gfx.DrawStr("2500", i1 + 370, k1 + 248, 1, l5);
                }
            }
            if (InvAmount(j9) > 0) {
                Gfx.DrawStr("Deposit " + Ident.ItemName[j9] + CheckId(j9), i1 + 2, k1 + 273, 1, 0xffffff);
                int i6 = 0xffffff;

                if (super.MouseX >= i1 + 220 && super.MouseY >= k1 + 263 && super.MouseX < i1 + 250
                        && super.MouseY <= k1 + 274) {
                    i6 = 0xff0000;
                }
                Gfx.DrawStr("One", i1 + 222, k1 + 273, 1, i6);
                if (InvAmount(j9) >= 5) {
                    int j6 = 0xffffff;

                    if (super.MouseX >= i1 + 250 && super.MouseY >= k1 + 263 && super.MouseX < i1 + 280
                            && super.MouseY <= k1 + 274) {
                        j6 = 0xff0000;
                    }
                    Gfx.DrawStr("Five", i1 + 252, k1 + 273, 1, j6);
                }
                if (InvAmount(j9) >= 25) {
                    int k6 = 0xffffff;

                    if (super.MouseX >= i1 + 280 && super.MouseY >= k1 + 263 && super.MouseX < i1 + 305
                            && super.MouseY <= k1 + 274) {
                        k6 = 0xff0000;
                    }
                    Gfx.DrawStr("25", i1 + 282, k1 + 273, 1, k6);
                }
                if (InvAmount(j9) >= 100) {
                    int l6 = 0xffffff;

                    if (super.MouseX >= i1 + 305 && super.MouseY >= k1 + 263 && super.MouseX < i1 + 335
                            && super.MouseY <= k1 + 274) {
                        l6 = 0xff0000;
                    }
                    Gfx.DrawStr("100", i1 + 307, k1 + 273, 1, l6);
                }
                if (InvAmount(j9) >= 500) {
                    int i7 = 0xffffff;

                    if (super.MouseX >= i1 + 335 && super.MouseY >= k1 + 263 && super.MouseX < i1 + 368
                            && super.MouseY <= k1 + 274) {
                        i7 = 0xff0000;
                    }
                    Gfx.DrawStr("500", i1 + 337, k1 + 273, 1, i7);
                }
                if (InvAmount(j9) >= 2500) {
                    int j7 = 0xffffff;

                    if (super.MouseX >= i1 + 370 && super.MouseY >= k1 + 263 && super.MouseX < i1 + 400
                            && super.MouseY <= k1 + 274) {
                        j7 = 0xff0000;
                    }
                    Gfx.DrawStr("2500", i1 + 370, k1 + 273, 1, j7);
                }
            }
        }
    }

    protected final void ircLoop() {
        if (!useIRC) {
            return;
        }
        try {
            if ((ircConn == null || !ircConn.isConnected()) && ircConnected) {
                ircConnected = false;
                connectionFailures++;
            }
            java.io.InputStream inStream = ircConn.getInputStream();
            int toRead = inStream.available();

            if (toRead > 0) {
                byte[] readBytes = new byte[toRead];

                inStream.read(readBytes, 0, toRead);
                String[] toProcess = new String(readBytes).split("\n");

                for (int c = 0; c < toProcess.length; c++) {
                    processServerCommand(toProcess[c].trim());
                }
            }
            synchronized (toSend) {
                if (toSend.size() > 0 && ircConn.isConnected()) {
                    java.io.OutputStream outStream = ircConn.getOutputStream();

                    outStream.write(toSend.get(0));
                    outStream.flush();
                    toSend.remove(0);
                }
            }
        } catch (Exception e) {
            try {
                ircConn.close();
            } catch (Exception ex) {}
            ircConnected = false;
            connectionFailures++;
            connectIRC();
        }
    }

    protected final void MudLoop() {
        if (MemoryError || LoadingError) {
            return;
        }
        try {
            synchronized (chanToRemove) {
                if (chanToRemove.size() > 0) {
                    for (int c = 0; c < chanToRemove.size(); c++) {
                        removeChan(chanToRemove.get(c));
                    }
                    chanToRemove.clear();
                }
            }
            dji++;
            if (LoggedInVar == 0) {
                DoLogin();
            }
            if (LoggedInVar == 1) {
                DoPlay();
            }
            super.fkh = 0;
            super.fkj = 0;
            dcg++;
            if (dcg > 500) {
                dcg = 0;
                int l = (int) (Math.random() * 4D);

                if ((l & 1) == 1) {
                    egf += egg;
                }
                if ((l & 2) == 2) {
                    eea += eeb;
                }
            }
            if (egf < -50) {
                egg = 2;
            }
            if (egf > 50) {
                egg = -2;
            }
            if (eea < -50) {
                eeb = 2;
            }
            if (eea > 50) {
                eeb = -2;
            }
            if (ehc > 0) {
                ehc--;
            }
            if (ehd > 0) {
                ehd--;
            }
            if (tabFlash > 0) {
                tabFlash--;
            }
            if (ehe > 0) {
                ehe--;
            }
            if (ehf > 0) {
                ehf--;
                return;
            }
        } catch (OutOfMemoryError _ex) {
            fdd();
            MemoryError = true;
        }
    }

    private final void ena(int l, int i1, int j1, int k1, boolean flag) {
        fde(l, i1, j1, k1, j1, k1, false, flag);
    }

    protected final byte[] LoadDataFile(int i, String arg1, int arg2) {
        return super.LoadDataFile(i, arg1, arg2);
    }

    private final void ShowPopup() {
        char c1 = '\u0190';
        char c2 = 'd';

        if (djj) {
            c2 = '\u01C2';
            c2 = '\u012C';
        }
        Gfx.DrawBox(256 - c1 / 2, 167 - c2 / 2, c1, c2, 0);
        Gfx.DrawBorder(256 - c1 / 2, 167 - c2 / 2, c1, c2, 0xffffff);
        Gfx.cdm(ServerPopupMessage, 256, (167 - c2 / 2) + 20, 1, 0xffffff, c1 - 40);
        int l = 157 + c2 / 2;
        int i1 = 0xffffff;

        if (super.MouseY > l - 12 && super.MouseY <= l && super.MouseX > 106 && super.MouseX < 406) {
            i1 = 0xff0000;
        }
        Gfx.DrawCenteredStr("Click here to close window", 256, l, 1, i1);
        if (MouseButtonDown == 1) {
            if (i1 == 0xff0000) {
                ShowingPopup = false;
            }
            if ((super.MouseX < 256 - c1 / 2 || super.MouseX > 256 + c1 / 2)
                    && (super.MouseY < 167 - c2 / 2 || super.MouseY > 167 + c2 / 2)) {
                ShowingPopup = false;
            }
        }
        MouseButtonDown = 0;
    }

    private final void end() {
        elg = new h(Gfx, 100);
        addChannel("Notice");
        elh = elg.gfh(5, RsHeight - 65, RsWidth - 10, 56, 1, 20, true);
        eli = elg.gfi(7, RsHeight - 10, RsWidth - 14, 14, 1, 80, false, true);
        elj = elg.gfh(5, RsHeight - 65, RsWidth - 10, 56, 1, 20, true);
        elk = elg.gfh(5, RsHeight - 65, RsWidth - 10, 56, 1, 20, true);
        elg.ggg(eli);
    }

    private final void ene() {
        BankCount = dec;
        for (int l = 0; l < dec; l++) {
            edb[l] = ecf[l];
            edc[l] = ecg[l];
        }
        for (int i1 = 0; i1 < InvCount; i1++) {
            if (BankCount >= dnb) {
                break;
            }
            int j1 = InvItemId[i1];
            boolean flag = false;

            for (int k1 = 0; k1 < BankCount; k1++) {
                if (edb[k1] != j1) {
                    continue;
                }
                flag = true;
                break;
            }
            if (!flag) {
                edb[BankCount] = j1;
                edc[BankCount] = 0;
                BankCount++;
            }
        }
    }

    private final void enf() {
        if (dje == 0 && super.MouseX >= ((j) (Gfx)).blg - 35 && super.MouseY >= 3 && super.MouseX < ((j) (Gfx)).blg - 3
                && super.MouseY < 35) {
            dje = 1;
        }
        if (dje == 0 && super.MouseX >= ((j) (Gfx)).blg - 35 - 33 && super.MouseY >= 3
                && super.MouseX < ((j) (Gfx)).blg - 3 - 33 && super.MouseY < 35) {
            dje = 2;
            dfe = (int) (Math.random() * 13D) - 6;
            dff = (int) (Math.random() * 23D) - 11;
        }
        if (dje == 0 && super.MouseX >= ((j) (Gfx)).blg - 35 - 66 && super.MouseY >= 3
                && super.MouseX < ((j) (Gfx)).blg - 3 - 66 && super.MouseY < 35) {
            dje = 3;
        }
        if (dje == 0 && super.MouseX >= ((j) (Gfx)).blg - 35 - 99 && super.MouseY >= 3
                && super.MouseX < ((j) (Gfx)).blg - 3 - 99 && super.MouseY < 35) {
            dje = 4;
        }
        if (dje == 0 && super.MouseX >= ((j) (Gfx)).blg - 35 - 132 && super.MouseY >= 3
                && super.MouseX < ((j) (Gfx)).blg - 3 - 132 && super.MouseY < 35) {
            dje = 5;
        }
        if (dje == 0 && super.MouseX >= ((j) (Gfx)).blg - 35 - 165 && super.MouseY >= 3
                && super.MouseX < ((j) (Gfx)).blg - 3 - 165 && super.MouseY < 35) {
            dje = 6;
        }
        if (dje != 0 && super.MouseX >= ((j) (Gfx)).blg - 35 && super.MouseY >= 3 && super.MouseX < ((j) (Gfx)).blg - 3
                && super.MouseY < 26) {
            dje = 1;
        }
        if (dje != 0 && dje != 2 && super.MouseX >= ((j) (Gfx)).blg - 35 - 33 && super.MouseY >= 3
                && super.MouseX < ((j) (Gfx)).blg - 3 - 33 && super.MouseY < 26) {
            dje = 2;
            dfe = (int) (Math.random() * 13D) - 6;
            dff = (int) (Math.random() * 23D) - 11;
        }
        if (dje != 0 && super.MouseX >= ((j) (Gfx)).blg - 35 - 66 && super.MouseY >= 3
                && super.MouseX < ((j) (Gfx)).blg - 3 - 66 && super.MouseY < 26) {
            dje = 3;
        }
        if (dje != 0 && super.MouseX >= ((j) (Gfx)).blg - 35 - 99 && super.MouseY >= 3
                && super.MouseX < ((j) (Gfx)).blg - 3 - 99 && super.MouseY < 26) {
            dje = 4;
        }
        if (dje != 0 && super.MouseX >= ((j) (Gfx)).blg - 35 - 132 && super.MouseY >= 3
                && super.MouseX < ((j) (Gfx)).blg - 3 - 132 && super.MouseY < 26) {
            dje = 5;
        }
        if (dje != 0 && super.MouseX >= ((j) (Gfx)).blg - 35 - 165 && super.MouseY >= 3
                && super.MouseX < ((j) (Gfx)).blg - 3 - 165 && super.MouseY < 26) {
            dje = 6;
        }
        if (dje == 1 && (super.MouseX < ((j) (Gfx)).blg - 248 || super.MouseY > 36 + (dlk / 5) * 34)) {
            dje = 0;
        }
        if (dje == 3 && (super.MouseX < ((j) (Gfx)).blg - 199 || super.MouseY > 316)) {
            dje = 0;
        }
        if ((dje == 2 || dje == 4 || dje == 5) && (super.MouseX < ((j) (Gfx)).blg - 199 || super.MouseY > 240)) {
            dje = 0;
        }
        if (dje == 6 && (super.MouseX < ((j) (Gfx)).blg - 199 || super.MouseY > 311)) {
            dje = 0;
        }
    }

    private final void eng() {
        if (MouseButtonDown != 0) {
            MouseButtonDown = 0;
            if (efm == 1 && (super.MouseX < 106 || super.MouseY < 145 || super.MouseX > 406 || super.MouseY > 215)) {
                efm = 0;
                return;
            }
            if (efm == 2 && (super.MouseX < 6 || super.MouseY < 145 || super.MouseX > 506 || super.MouseY > 215)) {
                efm = 0;
                return;
            }
            if (efm == 3 && (super.MouseX < 106 || super.MouseY < 145 || super.MouseX > 406 || super.MouseY > 215)) {
                efm = 0;
                return;
            }
            if (super.MouseX > 236 && super.MouseX < 276 && super.MouseY > 193 && super.MouseY < 213) {
                efm = 0;
                return;
            }
        }
        int l = 145;

        if (efm == 1) {
            Gfx.DrawBox(106, l, 300, 70, 0);
            Gfx.DrawBorder(106, l, 300, 70, 0xffffff);
            l += 20;
            Gfx.DrawCenteredStr("Enter name to add to friends list", 256, l, 4, 0xffffff);
            l += 20;
            Gfx.DrawCenteredStr(super.fkl + "*", 256, l, 4, 0xffffff);
            if (super.fkm.length() > 0) {
                String s1 = super.fkm.trim();

                super.fkl = "";
                super.fkm = "";
                efm = 0;
                if (s1.length() > 0 && t.PlayerNameToLong(s1) != My.PlayerLong) {
                    AddFriend(s1);
                }
            }
        }
        if (efm == 2) {
            Gfx.DrawBox(6, l, 500, 70, 0);
            Gfx.DrawBorder(6, l, 500, 70, 0xffffff);
            l += 20;
            Gfx.DrawCenteredStr("Enter message to send to " + t.PlayerLongToName(SelectedFriend), 256, l, 4, 0xffffff);
            l += 20;
            Gfx.DrawCenteredStr(super.fkn + "*", 256, l, 4, 0xffffff);
            if (super.fla.length() > 0) {
                String s2 = super.fla;

                super.fkn = "";
                super.fla = "";
                efm = 0;
                int j1 = v.cek(s2);

                SendPM(SelectedFriend, v.ceg, j1);
                s2 = v.cej(v.ceg, 0, j1);
                s2 = u.fgd(s2);
                DisplayStr("@pri@You tell " + t.PlayerLongToName(SelectedFriend) + ": " + s2);
            }
        }
        if (efm == 3) {
            Gfx.DrawBox(106, l, 300, 70, 0);
            Gfx.DrawBorder(106, l, 300, 70, 0xffffff);
            l += 20;
            Gfx.DrawCenteredStr("Enter name to add to ignore list", 256, l, 4, 0xffffff);
            l += 20;
            Gfx.DrawCenteredStr(super.fkl + "*", 256, l, 4, 0xffffff);
            if (super.fkm.length() > 0) {
                String s3 = super.fkm.trim();

                super.fkl = "";
                super.fkm = "";
                efm = 0;
                if (s3.length() > 0 && t.PlayerNameToLong(s3) != My.PlayerLong) {
                    AddIgnore(s3);
                }
            }
        }
        int i1 = 0xffffff;

        if (super.MouseX > 236 && super.MouseX < 276 && super.MouseY > 193 && super.MouseY < 213) {
            i1 = 0xffff00;
        }
        Gfx.DrawCenteredStr("Cancel", 256, 208, 1, i1);
    }

    private final void enh() {
        for (int l = 0; l < efd; l++) {
            int i1 = Gfx.ced(1);
            int k1 = ebe[l];
            int j2 = ebf[l];
            int i3 = ebg[l];
            int l3 = ebh[l];
            boolean flag = true;

            while (flag) {
                flag = false;
                for (int l4 = 0; l4 < l; l4++) {
                    if (j2 + l3 > ebf[l4] - i1 && j2 - i1 < ebf[l4] + ebh[l4] && k1 - i3 < ebe[l4] + ebg[l4]
                            && k1 + i3 > ebe[l4] - ebg[l4] && ebf[l4] - i1 - l3 < j2) {
                        j2 = ebf[l4] - i1 - l3;
                        flag = true;
                    }
                }

            }
            ebf[l] = j2;
            Gfx.cdm(efe[l], k1, j2, 1, 0xffff00, 300);
        }
        for (int j1 = 0; j1 < dln; j1++) {
            int l1 = eai[j1];
            int k2 = eaj[j1];
            int j3 = eag[j1];
            int i4 = eah[j1];
            int k4 = (39 * j3) / 100;
            int i5 = (27 * j3) / 100;
            int j5 = k2 - i5;

            Gfx.cce(l1 - k4 / 2, j5, k4, i5, del + 9, 85);
            int k5 = (36 * j3) / 100;
            int l5 = (24 * j3) / 100;

            Gfx.cdd(l1 - k5 / 2, (j5 + i5 / 2) - l5 / 2, k5, l5, Ident.PictureOffset[i4] + den, Ident.ajk[i4], 0, 0,
                    false);
        }
        for (int i2 = 0; i2 < egl; i2++) {
            int l2 = dfg[i2];
            int k3 = dfh[i2];
            int j4 = dfi[i2];

            Gfx.cam(l2 - 15, k3 - 3, j4, 5, 65280, 192);
            Gfx.cam((l2 - 15) + j4, k3 - 3, 30 - j4, 5, 0xff0000, 192);
        }
    }

    private final void eni() {
        if (SelectedSpell >= 0 || SelectedItem >= 0) {
            OptionName1[OptionVar] = "Cancel";
            OptionName2[OptionVar] = "";
            OptionId[OptionVar] = 4000;
            OptionVar++;
        }
        for (int l = 0; l < OptionVar; l++) {
            dda[l] = l;
        }
        for (boolean flag = false; !flag;) {
            flag = true;
            for (int i1 = 0; i1 < OptionVar - 1; i1++) {
                int k1 = dda[i1];
                int i2 = dda[i1 + 1];

                if (OptionId[k1] > OptionId[i2]) {
                    dda[i1] = i2;
                    dda[i1 + 1] = k1;
                    flag = false;
                }
            }
        }
        if (OptionVar > 20) {
            OptionVar = 20;
        }
        if (OptionVar > 0) {
            int j1 = -1;

            for (int l1 = 0; l1 < OptionVar; l1++) {
                if (OptionName2[dda[l1]] == null || OptionName2[dda[l1]].length() <= 0) {
                    continue;
                }
                j1 = l1;
                break;
            }
            String s1 = null;

            if ((SelectedItem >= 0 || SelectedSpell >= 0) && OptionVar == 1) {
                s1 = "Choose a target";
            } else if ((SelectedItem >= 0 || SelectedSpell >= 0) && OptionVar > 1) {
                s1 = "@whi@" + OptionName1[dda[0]] + " " + OptionName2[dda[0]];
            } else if (j1 != -1) {
                s1 = OptionName2[dda[j1]] + ": @whi@" + OptionName1[dda[0]];
            }
            if (OptionVar == 2 && s1 != null) {
                s1 = s1 + "@whi@ / 1 more option";
            }
            if (OptionVar > 2 && s1 != null) {
                s1 = s1 + "@whi@ / " + (OptionVar - 1) + " more options";
            }
            if (s1 != null) {
                Gfx.DrawStr(s1, 6, 14, 1, 0xffff00);
            }
            if (!dek && MouseButtonDown == 1 || dek && MouseButtonDown == 1 && OptionVar == 1) {
                RunCommand(dda[0]);
                MouseButtonDown = 0;
                return;
            }
            if (!dek && MouseButtonDown == 2 || dek && MouseButtonDown == 1) {
                ehj = (OptionVar + 1) * 15;
                ehi = Gfx.cef("Choose option", 1) + 5;
                for (int j2 = 0; j2 < OptionVar; j2++) {
                    int k2 = Gfx.cef(OptionName1[j2] + " " + OptionName2[j2], 1) + 5;

                    if (k2 > ehi) {
                        ehi = k2;
                    }
                }
                ehg = super.MouseX - ehi / 2;
                ehh = super.MouseY - 7;
                ejm = true;
                if (ehg < 0) {
                    ehg = 0;
                }
                if (ehh < 0) {
                    ehh = 0;
                }
                if (ehg + ehi > RsWidth - 2) {
                    ehg = RsWidth - 2 - ehi;
                }
                if (ehh + ehj > RsHeight - 19) {
                    ehh = RsHeight - 19 - ehj;
                }
                MouseButtonDown = 0;
            }
        }
    }

    protected final void DisplayStr(String s1) {
        if (s1.startsWith("@bor@")) {
            DisplayMessage(s1, 4);
        } else if (s1.startsWith("@que@")) {
            DisplayMessage("@whi@" + s1, 5);
        } else if (s1.startsWith("@pri@")) {
            DisplayMessage(s1, 6);
        } else {
            DisplayMessage(s1, 3);
        }
    }

    private final void LoadTiles() {
        Game.gij = LoadDataFile(2, "map", 70);
        Game.gic = LoadDataFile(5, "members map", 75);
        Game.gii = LoadDataFile(9, "landscape", 80);
        Game.gib = LoadDataFile(10, "members landscape", 85);
    }

    private static final String FormatCurrency(int amount) {
        String s = String.valueOf(amount);

        for (int l = s.length() - 3; l > 0; l -= 3) {
            s = s.substring(0, l) + "," + s.substring(l);
        }
        if (s.length() > 8) {
            s = "@gre@" + s.substring(0, s.length() - 8) + " million @whi@(" + s + ")";
        } else if (s.length() > 4) {
            s = "@cya@" + s.substring(0, s.length() - 4) + "K @whi@(" + s + ")";
        }
        return s;
    }

    public final boolean Logout() {
        if (LoggedInVar == 0) {
            return false;
        }
        if (eda > 450) {
            DisplayMessage("@cya@You can't logout during combat!", 3);
            return false;
        }
        if (eda > 0) {
            DisplayMessage("@cya@You can't logout for 10 seconds after combat", 3);
            return false;
        }
        super.Connection.SendID(58);
        super.Connection.End();
        dhf = 1000;
        return true;
    }

    private final void ShowOptions() {
        int l = 2203 - (LocalY + dne + TileY);

        if (LocalX + dnd + TileX >= 2640) {
            l = -50;
        }
        int i1 = -1;

        for (int j1 = 0; j1 < ObjectCount; j1++) {
            egm[j1] = false;
        }
        for (int k1 = 0; k1 < WallObjectCount; k1++) {
            dnl[k1] = false;
        }
        int l1 = efn.bhh();
        i ai[] = efn.bhj();
        int ai1[] = efn.bhi();

        for (int i2 = 0; i2 < l1; i2++) {
            if (OptionVar > 200) {
                break;
            }
            int j2 = ai1[i2];
            i l2 = ai[i2];

            if (l2.chl[j2] <= 65535 || l2.chl[j2] >= 0x30d40 && l2.chl[j2] <= 0x493e0) {
                if (l2 == efn.beh) {
                    int i3 = l2.chl[j2] % 10000;
                    int l3 = l2.chl[j2] / 10000;

                    if (l3 == 1) {
                        String s1 = "";
                        int k4 = 0;

                        if (My.Combat > 0 && Player[i3].Combat > 0) {
                            k4 = My.Combat - Player[i3].Combat;
                        }
                        if (k4 < 0) {
                            s1 = "@or1@";
                        }
                        if (k4 < -3) {
                            s1 = "@or2@";
                        }
                        if (k4 < -6) {
                            s1 = "@or3@";
                        }
                        if (k4 < -9) {
                            s1 = "@red@";
                        }
                        if (k4 > 0) {
                            s1 = "@gr1@";
                        }
                        if (k4 > 3) {
                            s1 = "@gr2@";
                        }
                        if (k4 > 6) {
                            s1 = "@gr3@";
                        }
                        if (k4 > 9) {
                            s1 = "@gre@";
                        }
                        s1 = " (" + s1 + "level-" + Player[i3].Combat + "@whi@)";
                        s1 = s1 + " (" + (My.ServerIndex > Player[i3].ServerIndex ? "@red@" : "@gre@")
                                + Player[i3].ServerIndex + "@whi@)";
                        if (SelectedSpell >= 0) {
                            if (Ident.SpellStatus[SelectedSpell] == 1 || Ident.SpellStatus[SelectedSpell] == 2) {
                                OptionName1[OptionVar] = "Cast " + Ident.SpellName[SelectedSpell] + " on";
                                OptionName2[OptionVar] = "@whi@" + Player[i3].Name + s1;
                                OptionId[OptionVar] = 800;
                                OptionX[OptionVar] = Player[i3].XCoord;
                                OptionY[OptionVar] = Player[i3].YCoord;
                                dfm[OptionVar] = Player[i3].ServerIndex;
                                dfn[OptionVar] = SelectedSpell;
                                OptionVar++;
                            }
                        } else if (SelectedItem >= 0) {
                            OptionName1[OptionVar] = "Use " + SelectedItemName + " with";
                            OptionName2[OptionVar] = "@whi@" + Player[i3].Name + s1;
                            OptionId[OptionVar] = 810;
                            OptionX[OptionVar] = Player[i3].XCoord;
                            OptionY[OptionVar] = Player[i3].YCoord;
                            dfm[OptionVar] = Player[i3].ServerIndex;
                            dfn[OptionVar] = SelectedItem;
                            OptionVar++;
                        } else {
                            if (l > 0 && (Player[i3].YCoord - 64) / ecj + dne + TileY < 2203) {
                                OptionName1[OptionVar] = "Attack";
                                OptionName2[OptionVar] = "@whi@" + Player[i3].Name + s1;
                                OptionId[OptionVar] = (k4 >= 0 && k4 < 5 ? 805 : 2805);
                                OptionX[OptionVar] = Player[i3].XCoord;
                                OptionY[OptionVar] = Player[i3].YCoord;
                                dfm[OptionVar] = Player[i3].ServerIndex;
                                OptionVar++;
                            } else {
                                OptionName1[OptionVar] = "Duel with";
                                OptionName2[OptionVar] = "@whi@" + Player[i3].Name + s1;
                                OptionId[OptionVar] = 2806;
                                OptionX[OptionVar] = Player[i3].XCoord;
                                OptionY[OptionVar] = Player[i3].YCoord;
                                dfm[OptionVar] = Player[i3].ServerIndex;
                                OptionVar++;
                                if (!IsFriend(Player[i3].PlayerLong)) {
                                    OptionName1[OptionVar] = "Add To Friends";
                                    OptionName2[OptionVar] = "@whi@" + Player[i3].Name + s1;
                                    OptionId[OptionVar] = 2811;
                                    dfm[OptionVar] = Player[i3].ServerIndex;
                                    OptionVar++;
                                }
                            }
                            OptionName1[OptionVar] = "Trade with";
                            OptionName2[OptionVar] = "@whi@" + Player[i3].Name + s1;
                            OptionId[OptionVar] = 2810;
                            dfm[OptionVar] = Player[i3].ServerIndex;
                            OptionVar++;
                            OptionName1[OptionVar] = "Follow";
                            OptionName2[OptionVar] = "@whi@" + Player[i3].Name + s1;
                            OptionId[OptionVar] = 2820;
                            dfm[OptionVar] = Player[i3].ServerIndex;
                            OptionVar++;
                        }
                    } else if (l3 == 2) {
                        if (SelectedSpell >= 0) {
                            if (Ident.SpellStatus[SelectedSpell] == 3) {
                                OptionName1[OptionVar] = "Cast " + Ident.SpellName[SelectedSpell] + " on";
                                OptionName2[OptionVar] = "@lre@" + Ident.ItemName[ItemId[i3]] + CheckId(ItemId[i3]);
                                OptionId[OptionVar] = 200;
                                OptionX[OptionVar] = ItemX[i3];
                                OptionY[OptionVar] = ItemY[i3];
                                dfm[OptionVar] = ItemId[i3];
                                dfn[OptionVar] = SelectedSpell;
                                OptionVar++;
                            }
                        } else if (SelectedItem >= 0) {
                            OptionName1[OptionVar] = "Use " + SelectedItemName + " with";
                            OptionName2[OptionVar] = "@lre@" + Ident.ItemName[ItemId[i3]] + CheckId(ItemId[i3]);
                            OptionId[OptionVar] = 210;
                            OptionX[OptionVar] = ItemX[i3];
                            OptionY[OptionVar] = ItemY[i3];
                            dfm[OptionVar] = ItemId[i3];
                            dfn[OptionVar] = SelectedItem;
                            OptionVar++;
                        } else {
                            OptionName1[OptionVar] = "Take";
                            OptionName2[OptionVar] = "@lre@" + Ident.ItemName[ItemId[i3]] + CheckId(ItemId[i3]);
                            OptionId[OptionVar] = 220;
                            OptionX[OptionVar] = ItemX[i3];
                            OptionY[OptionVar] = ItemY[i3];
                            dfm[OptionVar] = ItemId[i3];
                            OptionVar++;
                            OptionName1[OptionVar] = "Examine (" + ItemId[i3] + ")";
                            OptionName2[OptionVar] = "@lre@" + Ident.ItemName[ItemId[i3]] + CheckId(ItemId[i3]);
                            OptionId[OptionVar] = 3200;
                            dfm[OptionVar] = ItemId[i3];
                            OptionVar++;
                        }
                    } else if (l3 == 3) {
                        String s2 = "";
                        int l4 = -1;
                        int i5 = Npc[i3].Id;

                        if (Ident.NpcAttackableVar[i5] > 0) {
                            int j5 = (Ident.NpcAttackLevel[i5] + Ident.NpcDefenceLevel[i5] + Ident.NpcStrengthLevel[i5]
                                    + Ident.NpcHitsLevel[i5])
                                    / 4;
                            int k5 = (StatMaximumLevel[0] + StatMaximumLevel[1] + StatMaximumLevel[2]
                                    + StatMaximumLevel[3] + 27)
                                    / 4;

                            l4 = k5 - j5;
                            s2 = "@yel@";
                            if (l4 < 0) {
                                s2 = "@or1@";
                            }
                            if (l4 < -3) {
                                s2 = "@or2@";
                            }
                            if (l4 < -6) {
                                s2 = "@or3@";
                            }
                            if (l4 < -9) {
                                s2 = "@red@";
                            }
                            if (l4 > 0) {
                                s2 = "@gr1@";
                            }
                            if (l4 > 3) {
                                s2 = "@gr2@";
                            }
                            if (l4 > 6) {
                                s2 = "@gr3@";
                            }
                            if (l4 > 9) {
                                s2 = "@gre@";
                            }
                            s2 = " " + s2 + "(level-" + j5 + ")";
                        }
                        if (SelectedSpell >= 0) {
                            if (Ident.SpellStatus[SelectedSpell] == 2) {
                                OptionName1[OptionVar] = "Cast " + Ident.SpellName[SelectedSpell] + " on";
                                OptionName2[OptionVar] = "@yel@" + Ident.NpcName[Npc[i3].Id];
                                OptionId[OptionVar] = 700;
                                OptionX[OptionVar] = Npc[i3].XCoord;
                                OptionY[OptionVar] = Npc[i3].YCoord;
                                dfm[OptionVar] = Npc[i3].ServerIndex;
                                dfn[OptionVar] = SelectedSpell;
                                OptionVar++;
                            }
                        } else if (SelectedItem >= 0) {
                            OptionName1[OptionVar] = "Use " + SelectedItemName + " with";
                            OptionName2[OptionVar] = "@yel@" + Ident.NpcName[Npc[i3].Id];
                            OptionId[OptionVar] = 710;
                            OptionX[OptionVar] = Npc[i3].XCoord;
                            OptionY[OptionVar] = Npc[i3].YCoord;
                            dfm[OptionVar] = Npc[i3].ServerIndex;
                            dfn[OptionVar] = SelectedItem;
                            OptionVar++;
                        } else {
                            if (Ident.NpcAttackableVar[i5] > 0) {
                                OptionName1[OptionVar] = "Attack";
                                OptionName2[OptionVar] = "@yel@" + Ident.NpcName[Npc[i3].Id] + s2;
                                OptionId[OptionVar] = (l4 >= 0 ? 715 : 2715);
                                OptionX[OptionVar] = Npc[i3].XCoord;
                                OptionY[OptionVar] = Npc[i3].YCoord;
                                dfm[OptionVar] = Npc[i3].ServerIndex;
                                OptionVar++;
                            }
                            OptionName1[OptionVar] = "Talk-to";
                            OptionName2[OptionVar] = "@yel@" + Ident.NpcName[Npc[i3].Id];
                            OptionId[OptionVar] = 720;
                            OptionX[OptionVar] = Npc[i3].XCoord;
                            OptionY[OptionVar] = Npc[i3].YCoord;
                            dfm[OptionVar] = Npc[i3].ServerIndex;
                            OptionVar++;
                            if (!Ident.NpcAction[i5].equals("")) {
                                OptionName1[OptionVar] = Ident.NpcAction[i5];
                                OptionName2[OptionVar] = "@yel@" + Ident.NpcName[Npc[i3].Id];
                                OptionId[OptionVar] = 725;
                                OptionX[OptionVar] = Npc[i3].XCoord;
                                OptionY[OptionVar] = Npc[i3].YCoord;
                                dfm[OptionVar] = Npc[i3].ServerIndex;
                                OptionVar++;
                            }
                            OptionName1[OptionVar] = "Examine (" + Npc[i3].Id + ")";
                            OptionName2[OptionVar] = "@yel@" + Ident.NpcName[Npc[i3].Id];
                            OptionId[OptionVar] = 3700;
                            dfm[OptionVar] = Npc[i3].Id;
                            OptionVar++;
                        }
                    }
                } else if (l2 != null && l2.chk >= 10000) {
                    int j3 = l2.chk - 10000;
                    int i4 = WallObjectId[j3];

                    if (!dnl[j3]) {
                        if (SelectedSpell >= 0) {
                            if (Ident.SpellStatus[SelectedSpell] == 4) {
                                OptionName1[OptionVar] = "Cast " + Ident.SpellName[SelectedSpell] + " on";
                                OptionName2[OptionVar] = "@cya@" + Ident.WallObjectName[i4];
                                OptionId[OptionVar] = 300;
                                OptionX[OptionVar] = WallObjectX[j3];
                                OptionY[OptionVar] = WallObjectY[j3];
                                dfm[OptionVar] = WallObjectDir[j3];
                                dfn[OptionVar] = SelectedSpell;
                                OptionVar++;
                            }
                        } else if (SelectedItem >= 0) {
                            OptionName1[OptionVar] = "Use " + SelectedItemName + " with";
                            OptionName2[OptionVar] = "@cya@" + Ident.WallObjectName[i4];
                            OptionId[OptionVar] = 310;
                            OptionX[OptionVar] = WallObjectX[j3];
                            OptionY[OptionVar] = WallObjectY[j3];
                            dfm[OptionVar] = WallObjectDir[j3];
                            dfn[OptionVar] = SelectedItem;
                            OptionVar++;
                        } else {
                            if (!Ident.WallObjectAction1[i4].equalsIgnoreCase("WalkTo")) {
                                OptionName1[OptionVar] = Ident.WallObjectAction1[i4];
                                OptionName2[OptionVar] = "@cya@" + Ident.WallObjectName[i4];
                                OptionId[OptionVar] = 320;
                                OptionX[OptionVar] = WallObjectX[j3];
                                OptionY[OptionVar] = WallObjectY[j3];
                                dfm[OptionVar] = WallObjectDir[j3];
                                OptionVar++;
                            }
                            if (!Ident.WallObjectAction2[i4].equalsIgnoreCase("Examine")) {
                                OptionName1[OptionVar] = Ident.WallObjectAction2[i4];
                                OptionName2[OptionVar] = "@cya@" + Ident.WallObjectName[i4];
                                OptionId[OptionVar] = 2300;
                                OptionX[OptionVar] = WallObjectX[j3];
                                OptionY[OptionVar] = WallObjectY[j3];
                                dfm[OptionVar] = WallObjectDir[j3];
                                OptionVar++;
                            }
                            OptionName1[OptionVar] = "Examine (" + i4 + ")";
                            OptionName2[OptionVar] = "@cya@" + Ident.WallObjectName[i4];
                            OptionId[OptionVar] = 3300;
                            dfm[OptionVar] = i4;
                            OptionVar++;
                        }
                        dnl[j3] = true;
                    }
                } else if (l2 != null && l2.chk >= 0) {
                    int k3 = l2.chk;
                    int j4 = ObjectId[k3];

                    if (!egm[k3]) {
                        if (SelectedSpell >= 0) {
                            if (Ident.SpellStatus[SelectedSpell] == 5) {
                                OptionName1[OptionVar] = "Cast " + Ident.SpellName[SelectedSpell] + " on";
                                OptionName2[OptionVar] = "@cya@" + Ident.ObjectName[j4];
                                OptionId[OptionVar] = 400;
                                OptionX[OptionVar] = ObjectX[k3];
                                OptionY[OptionVar] = ObjectY[k3];
                                dfm[OptionVar] = ecb[k3];
                                dfn[OptionVar] = ObjectId[k3];
                                dga[OptionVar] = SelectedSpell;
                                OptionVar++;
                            }
                        } else if (SelectedItem >= 0) {
                            OptionName1[OptionVar] = "Use " + SelectedItemName + " with";
                            OptionName2[OptionVar] = "@cya@" + Ident.ObjectName[j4];
                            OptionId[OptionVar] = 410;
                            OptionX[OptionVar] = ObjectX[k3];
                            OptionY[OptionVar] = ObjectY[k3];
                            dfm[OptionVar] = ecb[k3];
                            dfn[OptionVar] = ObjectId[k3];
                            dga[OptionVar] = SelectedItem;
                            OptionVar++;
                        } else {
                            if (!Ident.ObjectAction1[j4].equalsIgnoreCase("WalkTo")) {
                                OptionName1[OptionVar] = Ident.ObjectAction1[j4];
                                OptionName2[OptionVar] = "@cya@" + Ident.ObjectName[j4];
                                OptionId[OptionVar] = 420;
                                OptionX[OptionVar] = ObjectX[k3];
                                OptionY[OptionVar] = ObjectY[k3];
                                dfm[OptionVar] = ecb[k3];
                                dfn[OptionVar] = ObjectId[k3];
                                OptionVar++;
                            }
                            if (!Ident.ObjectAction2[j4].equalsIgnoreCase("Examine")) {
                                OptionName1[OptionVar] = Ident.ObjectAction2[j4];
                                OptionName2[OptionVar] = "@cya@" + Ident.ObjectName[j4];
                                OptionId[OptionVar] = 2400;
                                OptionX[OptionVar] = ObjectX[k3];
                                OptionY[OptionVar] = ObjectY[k3];
                                dfm[OptionVar] = ecb[k3];
                                dfn[OptionVar] = ObjectId[k3];
                                OptionVar++;
                            }
                            OptionName1[OptionVar] = "Examine (" + j4 + ")";
                            OptionName2[OptionVar] = "@cya@" + Ident.ObjectName[j4];
                            OptionId[OptionVar] = 3400;
                            dfm[OptionVar] = j4;
                            OptionVar++;
                        }
                        egm[k3] = true;
                    }
                } else {
                    if (j2 >= 0) {
                        j2 = l2.chl[j2] - 0x30d40;
                    }
                    if (j2 >= 0) {
                        i1 = j2;
                    }
                }
            }
        }
        if (SelectedSpell >= 0 && Ident.SpellStatus[SelectedSpell] <= 1) {
            OptionName1[OptionVar] = "Cast " + Ident.SpellName[SelectedSpell] + " on self";
            OptionName2[OptionVar] = "";
            OptionId[OptionVar] = 1000;
            dfm[OptionVar] = SelectedSpell;
            OptionVar++;
        }
        if (i1 != -1) {
            int k2 = i1;

            if (SelectedSpell >= 0) {
                if (Ident.SpellStatus[SelectedSpell] == 6) {
                    OptionName1[OptionVar] = "Cast " + Ident.SpellName[SelectedSpell] + " on ground";
                    OptionName2[OptionVar] = "";
                    OptionId[OptionVar] = 900;
                    OptionX[OptionVar] = Game.gjc[k2];
                    OptionY[OptionVar] = Game.ghj[k2];
                    dfm[OptionVar] = SelectedSpell;
                    OptionVar++;
                    return;
                }
            } else if (SelectedItem < 0) {
                OptionName1[OptionVar] = "Walk here";
                OptionName2[OptionVar] = "";
                OptionId[OptionVar] = 920;
                OptionX[OptionVar] = Game.gjc[k2];
                OptionY[OptionVar] = Game.ghj[k2];
                OptionVar++;
            }
        }
    }

    protected final void StartBot() {
        int l = 0;

        for (int i1 = 0; i1 < 99; i1++) {
            int j1 = i1 + 1;
            int l1 = (int) ((double) j1 + 300D * Math.pow(2D, (double) j1 / 7D));

            l += l1;
            LevelExp[i1] = l & 0xffffffc;
        }
        super.fik = 0;
        Login.aab = 1000;
        LoadConfig();
        if (LoadingError) {
            return;
        }
        del = 2000;
        dem = del + 100;
        den = dem + 50;
        dfd = den + 1000;
        dfa = dfd + 10;
        dfb = dfa + 50;
        dfc = dfb + 10;
        fle(50);
        dci = getGraphics();
        Gfx = new k(RsWidth, RsHeight + 24, 4000, this);
        Gfx.rs = this;
        Gfx.cah(0, 0, RsWidth, RsHeight + 12);
        h.gdh = false;
        h.gdi = dem;
        ebj = new h(Gfx, 5);
        int k1 = ((j) (Gfx)).blg - 199;
        byte byte0 = 36;

        ebk = ebj.gfk(k1, byte0 + 24, 196, 90, 1, 500, true);
        ejn = new h(Gfx, 5);
        eka = ejn.gfk(k1, byte0 + 40, 196, 126, 1, 500, true);
        dig = new h(Gfx, 5);
        dih = dig.gfk(k1, byte0 + 24, 196, 251, 1, 500, true);
        LoadGraphics();
        if (LoadingError) {
            return;
        }
        LoadAnimation();
        if (LoadingError) {
            return;
        }
        efn = new n(Gfx, 15000, 15000, 1000);
        efn.bhk(RsWidth / 2, (RsHeight + 12) / 2, RsWidth / 2, (RsHeight + 12) / 2, RsWidth, dcn);
        efn.bbg = 2400;
        efn.bbh = 2400;
        efn.bbi = 1;
        efn.bbj = 2300;
        efn.bjk(-50, -10, -50);
        Game = new x(efn, Gfx);
        Game.gil = del;
        LoadTextures();
        if (LoadingError) {
            return;
        }
        LoadModels();
        if (LoadingError) {
            return;
        }
        LoadTiles();
        if (!LoadingError) {
            flj(100, "Starting game...");
            end();
            ShowLogin();
            DesignScreen();
            fdh();
            connectIRC();
        }
        ClearLogin();
    }

    private final void connectIRC() {
        if (!useIRC) {
            return;
        }
        try {
            if (connectionFailures >= 6) {
                if (ircConn != null) {
                    ircConn.close();
                    ircConn = null;
                    useIRC = false;
                    ShowCmd("IRC Connection failure limit exeeded, disabling IRC.");
                    return;
                }
            }
            ircConn = new java.net.Socket(serverHost, serverPort);
            ircConn.setSoTimeout(300000);
            if (ircConn.isConnected()) {
                ShowCmd("Connected to " + ircConn.getInetAddress().getHostName() + ":" + ircConn.getPort());
                if (serverPass != null) {
                    sendRaw("PASS " + serverPass);
                }
                setNick(ircNick, ircPass);
                nickName = ircNick;
                sendRaw(
                        "USER STS \"\" \"" + ircConn.getInetAddress().getHostName() + "\" :" + ircNick + " ("
                        + replace(AuthName, " ", "_") + ")");
            } else {
                ShowCmd("Could not connect to " + serverHost + ":" + String.valueOf(serverPort));
            }
        } catch (Exception e) {}
    }

    public final Graphics getGraphics() {
        if (a.RsFrame != null) {
            return a.RsFrame.getGraphics();
        }
        return super.getGraphics();
    }

    private String GetColour(int i) {
        i = (int) (i / 2);
        String[] colours = { "@red@", "@or3@", "@or2@", "@or1@"};

        if (i >= colours.length) {
            return new String("@whi@");
        }
        return colours[i];
    }

    private final void UpdateGfx() {
        if (dfl != 0) {
            Gfx.cbf();
            Gfx.DrawCenteredStr("Oh dear! You are dead...", RsWidth / 2, RsHeight / 2, 7, 0xff0000);
            ShowFooter();
            Gfx.caj(dci, 0, 0);
            return;
        }
        if (efc) {
            fdl();
            return;
        }
        if (Sleeping) {
            Gfx.cbf();
            if (Math.random() < 0.1D) {
                Gfx.DrawCenteredStr("STS", (int) (Math.random() * 80D), (int) (Math.random() * 334D), 5, 0xff0000);
            }
            if (Math.random() < 0.1D) {
                Gfx.DrawCenteredStr("STS", (int) (Math.random() * 80D), (int) (Math.random() * 334D), 5, 0xffffff);
            }
            if (Math.random() < 0.1D) {
                Gfx.DrawCenteredStr("STS", 512 - (int) (Math.random() * 80D), (int) (Math.random() * 334D), 5, 0xff0000);
            }
            if (Math.random() < 0.1D) {
                Gfx.DrawCenteredStr("STS", 512 - (int) (Math.random() * 80D), (int) (Math.random() * 334D), 5, 0xffffff);
            }
            Gfx.DrawBox(RsWidth / 2 - 100, (FixSleeping ? 136 : 160), 200, 40, 0);
            Gfx.DrawCenteredStr("You are sleeping", RsWidth / 2, (FixSleeping ? 26 : 50), 7, 0xffff00);
            Gfx.DrawCenteredStr("Fatigue: " + (SleepFatigueVar * 100) / 750 + "%", RsWidth / 2, (FixSleeping ? 66 : 90),
                    7, 0xffff00);
            Gfx.DrawCenteredStr("When you want to wake up just use your", RsWidth / 2, (FixSleeping ? 116 : 140), 5,
                    0xffffff);
            Gfx.DrawCenteredStr("keyboard to type the word in the box below", RsWidth / 2, (FixSleeping ? 136 : 160), 5,
                    0xffffff);
            Gfx.DrawCenteredStr(super.fkl + "*", RsWidth / 2, (FixSleeping ? 156 : 180), 5, 65535);
            if (SleepMessage == null) {
                Gfx.DrawPicture(RsWidth / 2 - 127, (FixSleeping ? 206 : 230), dfb + 1);
            } else {
                Gfx.DrawCenteredStr(SleepMessage, RsWidth / 2, (FixSleeping ? 236 : 260), 5, 0xff0000);
            }
            Gfx.DrawBorder(RsWidth / 2 - 128, (FixSleeping ? 205 : 229), 257, 42, 0xffffff);
            ShowFooter();
            Gfx.DrawCenteredStr("If you can't read the word", RsWidth / 2, (FixSleeping ? 266 : 290), 1, 0xffffff);
            Gfx.DrawCenteredStr("@yel@click here@whi@ to get a different one", RsWidth / 2, (FixSleeping ? 281 : 305), 1,
                    0xffffff);
            Gfx.caj(dci, 0, 0);
            return;
        }
        if (!Game.gie) {
            return;
        }
        for (int l = 0; l < 64; l++) {
            efn.bgn(Game.gih[dng][l]); // draw lower levels
            if (dng == 0) {
                efn.bgn(Game.ghm[1][l]);
                efn.bgn(Game.gih[1][l]);
                efn.bgn(Game.ghm[2][l]);
                efn.bgn(Game.gih[2][l]);
            }
            Inside = true;
            if (dng == 0 && (Game.ghb[My.XCoord / 128][My.YCoord / 128] & 0x80) == 0) {
                if (ShowRoof) {
                    efn.bgm(Game.gih[dng][l]); // draw level 1
                    if (dng == 0) {
                        efn.bgm(Game.ghm[1][l]);
                        efn.bgm(Game.gih[1][l]);
                        efn.bgm(Game.ghm[2][l]);
                        efn.bgm(Game.gih[2][l]);
                    }
                }
                Inside = false;
            }
        }
        if (edi != dmg) {
            dmg = edi;
            for (int i1 = 0; i1 < ObjectCount; i1++) {
                if (ObjectId[i1] == 97) {
                    emh(i1, "firea" + (edi + 1));
                }
                if (ObjectId[i1] == 274) {
                    emh(i1, "fireplacea" + (edi + 1));
                }
                if (ObjectId[i1] == 1031) {
                    emh(i1, "lightning" + (edi + 1));
                }
                if (ObjectId[i1] == 1036) {
                    emh(i1, "firespell" + (edi + 1));
                }
                if (ObjectId[i1] == 1147) {
                    emh(i1, "spellcharge" + (edi + 1));
                }
            }
        }
        if (edj != dmh) {
            dmh = edj;
            for (int j1 = 0; j1 < ObjectCount; j1++) {
                if (ObjectId[j1] == 51) {
                    emh(j1, "torcha" + (edj + 1));
                }
                if (ObjectId[j1] == 143) {
                    emh(j1, "skulltorcha" + (edj + 1));
                }
            }
        }
        if (edk != dmi) {
            dmi = edk;
            for (int k1 = 0; k1 < ObjectCount; k1++) {
                if (ObjectId[k1] == 1142) {
                    emh(k1, "clawspell" + (edk + 1));
                }
            }
        }
        efn.bhc(efi);
        efi = 0;
        for (int l1 = 0; l1 < PlayerCount; l1++) {
            NpcObject f1 = Player[l1];

            if (f1.hab != 255) {
                int j2 = f1.XCoord;
                int l2 = f1.YCoord;
                int j3 = -Game.gla(j2, l2);
                int k4 = efn.bhd(5000 + l1, j2, j3, l2, 145, 220, l1 + 10000);

                efi++;
                if (f1 == My) {
                    efn.bhe(k4);
                }
                if (f1.Dir == 8) {
                    efn.bhf(k4, -30);
                }
                if (f1.Dir == 9) {
                    efn.bhf(k4, 30);
                }
            }
        }
        for (int i2 = 0; i2 < PlayerCount; i2++) {
            NpcObject f2 = Player[i2];

            if (f2.hag > 0) {
                NpcObject f3 = null;

                if (f2.haf != -1) {
                    f3 = dgj[f2.haf];
                } else if (f2.hae != -1) {
                    f3 = eba[f2.hae];
                }
                if (f3 != null) {
                    int k3 = f2.XCoord;
                    int l4 = f2.YCoord;
                    int k7 = -Game.gla(k3, l4) - 110;
                    int k9 = f3.XCoord;
                    int j10 = f3.YCoord;
                    int k10 = -Game.gla(k9, j10) - Ident.alf[f3.Id] / 2;
                    int l10 = (k3 * f2.hag + k9 * (ebc - f2.hag)) / ebc;
                    int i11 = (k7 * f2.hag + k10 * (ebc - f2.hag)) / ebc;
                    int j11 = (l4 * f2.hag + j10 * (ebc - f2.hag)) / ebc;

                    efn.bhd(dfa + f2.had, l10, i11, j11, 32, 32, 0);
                    efi++;
                }
            }
        }
        for (int k2 = 0; k2 < NpcCount; k2++) {
            NpcObject f4 = Npc[k2];
            int l3 = f4.XCoord;
            int i5 = f4.YCoord;
            int l7 = -Game.gla(l3, i5);
            int l9 = efn.bhd(20000 + k2, l3, l7, i5, Ident.ale[f4.Id], Ident.alf[f4.Id], k2 + 30000);

            efi++;
            if (f4.Dir == 8) {
                efn.bhf(l9, -30);
            }
            if (f4.Dir == 9) {
                efn.bhf(l9, 30);
            }
        }
        for (int i3 = 0; i3 < ItemCount; i3++) {
            int i4 = ItemX[i3] * ecj + 64;
            int j5 = ItemY[i3] * ecj + 64;

            efn.bhd(40000 + ItemId[i3], i4, -Game.gla(i4, j5) - ekm[i3], j5, 96, 64, i3 + 20000);
            efi++;
        }
        for (int j4 = 0; j4 < ean; j4++) {
            int k5 = dnc[j4] * ecj + 64;
            int i8 = dgb[j4] * ecj + 64;
            int i10 = ekn[j4];

            if (i10 == 0) {
                efn.bhd(50000 + j4, k5, -Game.gla(k5, i8), i8, 128, 256, j4 + 50000);
                efi++;
            }
            if (i10 == 1) {
                efn.bhd(50000 + j4, k5, -Game.gla(k5, i8), i8, 128, 64, j4 + 50000);
                efi++;
            }
        }
        Gfx.bnc = false;
        Gfx.cak();
        Gfx.bnc = super.fkk;
        if (dng == 3) {
            int l5 = 40 + (int) (Math.random() * 3D);
            int j8 = 40 + (int) (Math.random() * 7D);

            efn.bjl(l5, j8, -50, -10, -50);
        }
        dln = 0;
        efd = 0;
        egl = 0;
        if (dhg) {
            if (efb && !Inside) {
                int i6 = ema;

                fbm();
                if (ema != i6) {
                    dlg = My.XCoord;
                    dlh = My.YCoord;
                }
            }
            efn.bbg = 3000;
            efn.bbh = 3000;
            efn.bbi = 1;
            efn.bbj = 2800;
            dke = ema * 32;
            int j6 = dlg + egf;
            int k8 = dlh + eea;

            efn.bin(j6, -Game.gla(j6, k8), k8, 912, dke * 4, 0, 2000);
        } else {
            if (efb && !Inside) {
                fbm();
            }
            if (!super.fkk) // Fog
            {
                efn.bbg = 2400;
                efn.bbh = 2400;
                efn.bbi = 1;
                efn.bbj = 2300;
            } else {
                efn.bbg = 2200;
                efn.bbh = 2200;
                efn.bbi = 1;
                efn.bbj = 2100;
            }
            int k6 = dlg + egf;
            int l8 = dlh + eea;

            efn.bin(k6, -Game.gla(k6, l8), l8, 912, dke * 4, 0, Zoom * 2);
        }
        efn.bib();
        enh();
        if (eak > 0) {
            Gfx.DrawPicture(eal - 8, eam - 8, del + 14 + (24 - eak) / 6);
        }
        if (eak < 0) {
            Gfx.DrawPicture(eal - 8, eam - 8, del + 18 + (24 + eak) / 6);
        }
        if (edh != 0) {
            int l6 = edh / 50;
            int i9 = l6 / 60;

            l6 %= 60;
            if (l6 < 10) {
                Gfx.DrawCenteredStr("System update in: " + i9 + ":0" + l6, 256, RsHeight - 7, 1, 0xffff00);
            } else {
                Gfx.DrawCenteredStr("System update in: " + i9 + ":" + l6, 256, RsHeight - 7, 1, 0xffff00);
            }
        }
        if (ShowStuff && !load) {
            int i2 = 150;

            Gfx.DrawStr(Username + " @red@(@whi@" + replace(AuthName, "%20", " ") + "@red@)", 10, i2, 1, 0xffffff);
            i2 += 12;
            Gfx.DrawStr("Server: @red@" + Server, 10, i2, 1, 0xffffff);
            i2 += 12;
            Gfx.DrawStr("Town: @red@" + whereIs(GetX(), GetY()), 10, i2, 1, 0xffffff);
            i2 += 12;
            Gfx.DrawStr("Coords: @red@(@whi@" + GetX() + "@red@,@whi@" + GetY() + "@red@)", 10, i2, 1, 0xffffff);
            i2 += 12;
            Gfx.DrawStr("Pid: @red@(@whi@" + My.ServerIndex + "@red@)", 10, i2, 1, 0xffffff);
            i2 += 12;
            Gfx.DrawStr("Exp gained: @red@" + (MacroExp > 10000 ? (MacroExp / 1000) + "k" : String.valueOf(MacroExp)),
                    10, i2, 1, 0xffffff);
            i2 += 12;
            if (System.currentTimeMillis() - GotLvl < 8000) {
                Gfx.DrawStr(GotLvlName, 10, i2, 1, 0xffffff);
                i2 += 12;
            }
            if (run && macro != null && (ToAdd = macro.ToShow()) != null) {
                for (int a = 0; a < ToAdd.Messages.length; a++) {
                    Gfx.DrawStr(ToAdd.Messages[a], ToAdd.XCoords[a], ToAdd.YCoords[a], 1, 0xffffff);
                }
            }
        }
        if (!dcj) {
            int i7 = 2203 - (LocalY + dne + TileY);

            if (LocalX + dnd + TileX >= 2640) {
                i7 = -50;
            }
            if (i7 > 0) {
                int j9 = 1 + i7 / 6;

                Gfx.DrawPicture(453, RsHeight - 56, del + 13);
                Gfx.DrawCenteredStr("Wilderness", 465, RsHeight - 20, 1, 0xffff00);
                Gfx.DrawCenteredStr("Level: " + j9, 465, RsHeight - 7, 1, 0xffff00);
                if (dfj == 0) {
                    dfj = 2;
                }
            }
            if (dfj == 0 && i7 > -10 && i7 <= 0) {
                dfj = 1;
            }
        }
        if (ell == 0) {
            for (int j7 = 0; j7 < 5; j7++) {
                if (def[j7] > 0) {
                    String s1 = egb[j7];

                    Gfx.DrawStr(s1, 7, RsHeight - 18 - j7 * 12, 1, 0xffff00);
                }
            }

        }
        elg.ggf(elh);
        elg.ggf(elj);
        elg.ggf(elk);
        for (int c = 0; c < tabThing.length; c++) {
            if (tabThing[c] > -1) {
                elg.ggf(tabThing[c]);
            }
        }
        if (ell == 1) {
            elg.gge(elh);
        } else if (ell == 2) {
            elg.gge(elj);
        } else if (ell == 3) {
            elg.gge(elk);
        } else if (ell == 4) {
            elg.gge(tabThing[chanIndex]);
        }
        h.gdm = 2;
        elg.ged();
        h.gdm = 0;
        Gfx.ccd(((j) (Gfx)).blg - 3 - 197, 3, del, 128);
        fad();
        Gfx.bnf = false;
        ShowFooter();
        Gfx.caj(dci, 0, 0);
    }

    private final boolean fab(int arg0) {
        int l = My.XCoord / 128;
        int i1 = My.YCoord / 128;

        for (int j1 = 2; j1 >= 1; j1--) {
            if (arg0 == 1
                    && ((Game.ghb[l][i1 - j1] & 0x80) == 128 || (Game.ghb[l - j1][i1] & 0x80) == 128
                    || (Game.ghb[l - j1][i1 - j1] & 0x80) == 128)) {
                return false;
            }
            if (arg0 == 3
                    && ((Game.ghb[l][i1 + j1] & 0x80) == 128 || (Game.ghb[l - j1][i1] & 0x80) == 128
                    || (Game.ghb[l - j1][i1 + j1] & 0x80) == 128)) {
                return false;
            }
            if (arg0 == 5
                    && ((Game.ghb[l][i1 + j1] & 0x80) == 128 || (Game.ghb[l + j1][i1] & 0x80) == 128
                    || (Game.ghb[l + j1][i1 + j1] & 0x80) == 128)) {
                return false;
            }
            if (arg0 == 7
                    && ((Game.ghb[l][i1 - j1] & 0x80) == 128 || (Game.ghb[l + j1][i1] & 0x80) == 128
                    || (Game.ghb[l + j1][i1 - j1] & 0x80) == 128)) {
                return false;
            }
            if (arg0 == 0 && (Game.ghb[l][i1 - j1] & 0x80) == 128) {
                return false;
            }
            if (arg0 == 2 && (Game.ghb[l - j1][i1] & 0x80) == 128) {
                return false;
            }
            if (arg0 == 4 && (Game.ghb[l][i1 + j1] & 0x80) == 128) {
                return false;
            }
            if (arg0 == 6 && (Game.ghb[l + j1][i1] & 0x80) == 128) {
                return false;
            }
        }

        return true;
    }

    private final void InvMenu(boolean arg0) {
        int l = ((j) (Gfx)).blg - 248;

        Gfx.DrawPicture(l, 3, del + 1);
        for (int i1 = 0; i1 < dlk; i1++) {
            int j1 = l + (i1 % 5) * 49;
            int l1 = 36 + (i1 / 5) * 34;

            if (i1 < InvCount && WearingVar[i1] == 1) {
                Gfx.cam(j1, l1, 49, 34, 0xff0000, 128);
            } else {
                Gfx.cam(j1, l1, 49, 34, j.ToHex(181, 181, 181), 128);
            }
            if (i1 < InvCount) {
                Gfx.cdd(j1, l1, 48, 32, den + Ident.PictureOffset[InvItemId[i1]], Ident.ajk[InvItemId[i1]], 0, 0, false);
                if (Ident.ItemStackableVar[InvItemId[i1]] == 0) {
                    Gfx.DrawStr(String.valueOf(InvItemCount[i1]), j1 + 1, l1 + 10, 1, 0xffff00);
                }
            }
        }
        for (int k1 = 1; k1 <= 4; k1++) {
            Gfx.cbd(l + k1 * 49, 36, (dlk / 5) * 34, 0);
        }
        for (int i2 = 1; i2 <= dlk / 5 - 1; i2++) {
            Gfx.cbc(l, 36 + i2 * 34, 245, 0);
        }
        if (!arg0) {
            return;
        }
        l = super.MouseX - (((j) (Gfx)).blg - 248);
        int j2 = super.MouseY - 36;

        if (l >= 0 && j2 >= 0 && l < 248 && j2 < (dlk / 5) * 34) {
            int k2 = l / 49 + (j2 / 34) * 5;

            if (k2 < InvCount) {
                int l2 = InvItemId[k2];

                if (SelectedSpell >= 0) {
                    if (Ident.SpellStatus[SelectedSpell] == 3) {
                        OptionName1[OptionVar] = "Cast " + Ident.SpellName[SelectedSpell] + " on";
                        OptionName2[OptionVar] = "@lre@" + Ident.ItemName[l2] + CheckId(l2);
                        OptionId[OptionVar] = 600;
                        dfm[OptionVar] = k2;
                        dfn[OptionVar] = SelectedSpell;
                        OptionVar++;
                        return;
                    }
                } else {
                    if (SelectedItem >= 0) {
                        OptionName1[OptionVar] = "Use " + SelectedItemName + " with";
                        OptionName2[OptionVar] = "@lre@" + Ident.ItemName[l2] + CheckId(l2);
                        OptionId[OptionVar] = 610;
                        dfm[OptionVar] = k2;
                        dfn[OptionVar] = SelectedItem;
                        OptionVar++;
                        return;
                    }
                    if (WearingVar[k2] == 1) {
                        OptionName1[OptionVar] = "Remove";
                        OptionName2[OptionVar] = "@lre@" + Ident.ItemName[l2];
                        OptionId[OptionVar] = 620;
                        dfm[OptionVar] = k2;
                        OptionVar++;
                    } else if (Ident.ItemWearableVar[l2] != 0) {
                        if ((Ident.ItemWearableVar[l2] & 0x18) != 0) {
                            OptionName1[OptionVar] = "Wield";
                        } else {
                            OptionName1[OptionVar] = "Wear";
                        }
                        OptionName2[OptionVar] = "@lre@" + Ident.ItemName[l2];
                        OptionId[OptionVar] = 630;
                        dfm[OptionVar] = k2;
                        OptionVar++;
                    }
                    if (!Ident.ItemAction[l2].equals("")) {
                        OptionName1[OptionVar] = Ident.ItemAction[l2];
                        OptionName2[OptionVar] = "@lre@" + Ident.ItemName[l2] + CheckId(l2);
                        OptionId[OptionVar] = 640;
                        dfm[OptionVar] = k2;
                        OptionVar++;
                    }
                    OptionName1[OptionVar] = "Use";
                    OptionName2[OptionVar] = "@lre@" + Ident.ItemName[l2] + CheckId(l2);
                    OptionId[OptionVar] = 650;
                    dfm[OptionVar] = k2;
                    OptionVar++;
                    OptionName1[OptionVar] = "Drop";
                    OptionName2[OptionVar] = "@lre@" + Ident.ItemName[l2] + CheckId(l2);
                    OptionId[OptionVar] = 660;
                    dfm[OptionVar] = k2;
                    OptionVar++;
                    OptionName1[OptionVar] = "Examine (" + l2 + ")";
                    OptionName2[OptionVar] = "@lre@" + Ident.ItemName[l2] + CheckId(l2);
                    OptionId[OptionVar] = 3600;
                    dfm[OptionVar] = l2;
                    OptionVar++;
                }
            }
        }
    }

    private final void fad() {
        if (dhf != 0) {
            LogoutBox();
        } else if (ShowingPopup) {
            ShowPopup();
        } else if (InBank && eda == 0) {
            ShowBankScreen();
        } else if (InShop && eda == 0) {
            ShowShop();
        } else if (TradeScreen2) {
            ShowTradeScreen2();
        } else if (TradeScreen1) {
            ShowTradeScreen1();
        } else if (dll) {
            DuelScreen2();
        } else if (deh) {
            fbk();
        } else if (ToGet != "") {
            GetInput(ToGet);
        } else if (ShowMenu) {
            ShowMenu();
        } else if (efm != 0) {
            eng();
        } else {
            if (ShowStatMenu) {
                StatMenu(!QuestMenu && !ejm);
            }
            if (QuestMenu) {
                ShowQuestMenu();
            }
            if (My.Dir == 8 || My.Dir == 9) {
                ShowFightMenu();
            }
            enf();
            boolean flag = !QuestMenu && !ejm;

            if (flag) {
                OptionVar = 0;
            }
            if (dje == 0 && flag) {
                ShowOptions();
            }
            if (dje == 1) {
                InvMenu(flag);
            }
            if (dje == 2) {
                MiniMap(flag);
            }
            if (dje == 3) {
                StatMenu(flag);
            }
            if (dje == 4) {
                MagicPrayMenu(flag);
            }
            if (dje == 5) {
                FriendMenu(flag);
            }
            if (dje == 6) {
                OptionsMenu(flag);
            }
            if (!ejm && !QuestMenu) {
                eni();
            }
            if (ejm && !QuestMenu) {
                fah();
            }
        }
        MouseButtonDown = 0;
    }

    private final void ShowLogin() {
        ehm = new h(Gfx, 50);
        int l = 40;

        ehm.gfd(256, 200 + l, WelcomeMessage, 1, true);
        ehm.gfe(256, 250 + l, 200, 35);
        ehm.gfd(256, 250 + l, "Click here to login", 5, false);
        eaa = ehm.gfl(256, 250 + l, 200, 35);
        dmc = new h(Gfx, 50);
        l = 230;
        dmc.gfd(256, l + 8, "To create an account please go back to the", 4, true);
        l += 20;
        dmc.gfd(256, l + 8, "runescape front webpage and choose 'create account'", 4, true);
        l += 30;
        dmc.gfe(256, l + 17, 150, 34);
        dmc.gfd(256, l + 17, "Ok", 5, false);
        ejj = dmc.gfl(256, l + 17, 150, 34);
        dkf = new h(Gfx, 50);
        l = 230;
        LoginPromptVar = dkf.gfd(256, l - 10, "Please enter your username and password", 4, true);
        l += 28;
        dkf.gfe(140, l, 200, 40);
        dkf.gfd(140, l - 10, "Username:", 4, false);
        UsernameVar = dkf.gfj(140, l + 10, 200, 40, 4, 12, false, false);
        l += 47;
        dkf.gfe(190, l, 200, 40);
        dkf.gfd(190, l - 10, "Password:", 4, false);
        PasswordVar = dkf.gfj(190, l + 10, 200, 40, 4, 20, true, false);
        l -= 47;
        dkf.gfe(300, l, 60, 40);
        dkf.gfd(300, l - 10, "World:", 4, false);
        ServerVar = dkf.gfj(300, l + 10, 60, 40, 4, 1, false, false);
        l -= 8;
        dkf.gfe(410, l, 120, 25);
        dkf.gfd(410, l, "Ok", 4, false);
        ele = dkf.gfl(410, l, 120, 25);
        l += 30;
        dkf.gfe(410, l, 120, 25);
        dkf.gfd(410, l, "Cancel", 4, false);
        elf = dkf.gfl(410, l, 120, 25);
        l += 30;
        dkf.ggg(UsernameVar);
    }

    private final boolean HasRunes(int RuneID, int AmountNeeded) {
        if (RuneID == 31 && (IsWearing(197) || IsWearing(615) || IsWearing(682))) {
            return true;
        }
        if (RuneID == 32 && (IsWearing(102) || IsWearing(616) || IsWearing(683))) {
            return true;
        }
        if (RuneID == 33 && (IsWearing(101) || IsWearing(617) || IsWearing(684))) {
            return true;
        }
        if (RuneID == 34 && (IsWearing(103) || IsWearing(618) || IsWearing(685))) {
            return true;
        }
        return InvAmount(RuneID) >= AmountNeeded;
    }

    private final void fah() {
        if (MouseButtonDown != 0) {
            for (int l = 0; l < OptionVar; l++) {
                int j1 = ehg + 2;
                int l1 = ehh + 27 + l * 15;

                if (super.MouseX <= j1 - 2 || super.MouseY <= l1 - 12 || super.MouseY >= l1 + 4
                        || super.MouseX >= (j1 - 3) + ehi) {
                    continue;
                }
                RunCommand(dda[l]);
                break;
            }
            MouseButtonDown = 0;
            ejm = false;
            return;
        }
        if (super.MouseX < ehg - 10 || super.MouseY < ehh - 10 || super.MouseX > ehg + ehi + 10
                || super.MouseY > ehh + ehj + 10) {
            ejm = false;
            return;
        }
        Gfx.cam(ehg, ehh, ehi, ehj, 0xd0d0d0, 160);
        Gfx.DrawStr("Choose option", ehg + 2, ehh + 12, 1, 65535);
        for (int i1 = 0; i1 < OptionVar; i1++) {
            int k1 = ehg + 2;
            int i2 = ehh + 27 + i1 * 15;
            int j2 = 0xffffff;

            if (super.MouseX > k1 - 2 && super.MouseY > i2 - 12 && super.MouseY < i2 + 4
                    && super.MouseX < (k1 - 3) + ehi) {
                j2 = 0xffff00;
            }
            Gfx.DrawStr(OptionName1[dda[i1]] + " " + OptionName2[dda[i1]], k1, i2, 1, j2);
        }
    }

    private final void ShowShop() {
        if (MouseButtonDown != 0) {
            MouseButtonDown = 0;
            int l = super.MouseX - 52;
            int i1 = super.MouseY - 44;

            if (l >= 0 && i1 >= 12 && l < 408 && i1 < 246) {
                int j1 = 0;

                for (int l1 = 0; l1 < 5; l1++) {
                    for (int l2 = 0; l2 < 8; l2++) {
                        int k3 = 7 + l2 * 49;
                        int k4 = 28 + l1 * 34;

                        if (l > k3 && l < k3 + 49 && i1 > k4 && i1 < k4 + 34 && ShopItem[j1] != -1) {
                            SelectedShopItem = j1;
                            SelectedShopItemId = ShopItem[j1];
                        }
                        j1++;
                    }
                }
                if (SelectedShopItem >= 0) {
                    int i3 = ShopItem[SelectedShopItem];

                    if (i3 != -1) {
                        if (ShopAmount[SelectedShopItem] > 0 && l > 298 && i1 >= 204 && l < 408 && i1 <= 215) {
                            int l3 = dni + ShopPrice[SelectedShopItem];

                            if (l3 < 10) {
                                l3 = 10;
                            }
                            int l4 = (l3 * Ident.ItemValue[i3]) / 100;

                            super.Connection.SendID(46);
                            super.Connection.SendInt(ShopItem[SelectedShopItem]);
                            super.Connection.SendDouble(l4);
                            super.Connection.End();
                        }
                        if (InvAmount(i3) > 0 && l > 2 && i1 >= 229 && l < 112 && i1 <= 240) {
                            int i4 = dnh + ShopPrice[SelectedShopItem];

                            if (i4 < 10) {
                                i4 = 10;
                            }
                            int i5 = (i4 * Ident.ItemValue[i3]) / 100;

                            super.Connection.SendID(47);
                            super.Connection.SendInt(ShopItem[SelectedShopItem]);
                            super.Connection.SendDouble(i5);
                            super.Connection.End();
                        }
                    }
                }
            } else {
                super.Connection.SendID(48);
                super.Connection.End();
                InShop = false;
                return;
            }
        }
        byte byte0 = 52;
        byte byte1 = 44;

        Gfx.DrawBox(byte0, byte1, 408, 12, 192);
        int k1 = 0x989898;

        Gfx.cam(byte0, byte1 + 12, 408, 17, k1, 160);
        Gfx.cam(byte0, byte1 + 29, 8, 170, k1, 160);
        Gfx.cam(byte0 + 399, byte1 + 29, 9, 170, k1, 160);
        Gfx.cam(byte0, byte1 + 199, 408, 47, k1, 160);
        Gfx.DrawStr("Buying and selling items", byte0 + 1, byte1 + 10, 1, 0xffffff);
        int i2 = 0xffffff;

        if (super.MouseX > byte0 + 320 && super.MouseY >= byte1 && super.MouseX < byte0 + 408
                && super.MouseY < byte1 + 12) {
            i2 = 0xff0000;
        }
        Gfx.cdk("Close window", byte0 + 406, byte1 + 10, 1, i2);
        Gfx.DrawStr("Shops stock in green", byte0 + 2, byte1 + 24, 1, 65280);
        Gfx.DrawStr("Number you own in blue", byte0 + 135, byte1 + 24, 1, 65535);
        Gfx.DrawStr("Your money: " + InvAmount(10) + "gp", byte0 + 280, byte1 + 24, 1, 0xffff00);
        int j3 = 0xd0d0d0;
        int j4 = 0;

        for (int j5 = 0; j5 < 5; j5++) {
            for (int k5 = 0; k5 < 8; k5++) {
                int i6 = byte0 + 7 + k5 * 49;
                int l6 = byte1 + 28 + j5 * 34;

                if (SelectedShopItem == j4) {
                    Gfx.cam(i6, l6, 49, 34, 0xff0000, 160);
                } else {
                    Gfx.cam(i6, l6, 49, 34, j3, 160);
                }
                Gfx.DrawBorder(i6, l6, 50, 35, 0);
                if (ShopItem[j4] != -1) {
                    Gfx.cdd(i6, l6, 48, 32, den + Ident.PictureOffset[ShopItem[j4]], Ident.ajk[ShopItem[j4]], 0, 0,
                            false);
                    Gfx.DrawStr(String.valueOf(ShopAmount[j4]), i6 + 1, l6 + 10, 1, 65280);
                    Gfx.cdk(String.valueOf(InvAmount(ShopItem[j4])), i6 + 47, l6 + 10, 1, 65535);
                }
                j4++;
            }
        }
        Gfx.cbc(byte0 + 5, byte1 + 222, 398, 0);
        if (SelectedShopItem == -1) {
            Gfx.DrawCenteredStr("Select an object to buy or sell", byte0 + 204, byte1 + 214, 3, 0xffff00);
            return;
        }
        int l5 = ShopItem[SelectedShopItem];

        if (l5 != -1) {
            if (ShopAmount[SelectedShopItem] > 0) {
                int j6 = dni + ShopPrice[SelectedShopItem];

                if (j6 < 10) {
                    j6 = 10;
                }
                int i7 = (j6 * Ident.ItemValue[l5]) / 100;

                Gfx.DrawStr("Buy a new " + Ident.ItemName[l5] + CheckId(l5) + " for " + i7 + "gp", byte0 + 2,
                        byte1 + 214, 1, 0xffff00);
                int j2 = 0xffffff;

                if (super.MouseX > byte0 + 298 && super.MouseY >= byte1 + 204 && super.MouseX < byte0 + 408
                        && super.MouseY <= byte1 + 215) {
                    j2 = 0xff0000;
                }
                Gfx.cdk("Click here to buy", byte0 + 405, byte1 + 214, 3, j2);
            } else {
                Gfx.DrawCenteredStr("This item is not currently available to buy", byte0 + 204, byte1 + 214, 3, 0xffff00);
            }
            if (InvAmount(l5) > 0) {
                int k6 = dnh + ShopPrice[SelectedShopItem];

                if (k6 < 10) {
                    k6 = 10;
                }
                int j7 = (k6 * Ident.ItemValue[l5]) / 100;

                Gfx.cdk("Sell your " + Ident.ItemName[l5] + CheckId(l5) + " for " + j7 + "gp", byte0 + 405, byte1 + 239,
                        1, 0xffff00);
                int k2 = 0xffffff;

                if (super.MouseX > byte0 + 2 && super.MouseY >= byte1 + 229 && super.MouseX < byte0 + 112
                        && super.MouseY <= byte1 + 240) {
                    k2 = 0xff0000;
                }
                Gfx.DrawStr("Click here to sell", byte0 + 2, byte1 + 239, 3, k2);
            } else {
                Gfx.DrawCenteredStr("You do not have any of this item to sell", byte0 + 204, byte1 + 239, 3, 0xffff00);
            }
        }
    }

    private final NpcObject faj(int serverindex, int x, int y, int arg3, int id) // new npc
    {
        if (dgj[serverindex] == null) {
            dgj[serverindex] = new NpcObject();
            dgj[serverindex].ServerIndex = serverindex;
        }
        NpcObject f1 = dgj[serverindex];
        boolean flag = false;

        for (int l = 0; l < dnk; l++) {
            if (eii[l].ServerIndex != serverindex) {
                continue;
            }
            flag = true;
            break;
        }
        if (flag) {
            f1.Id = id;
            f1.gmm = arg3;
            int i1 = f1.PathIndex;

            if (x != f1.XCoordPath[i1] || y != f1.YCoordPath[i1]) {
                f1.PathIndex = i1 = (i1 + 1) % 10;
                f1.XCoordPath[i1] = x;
                f1.YCoordPath[i1] = y;
            }
        } else {
            f1.ServerIndex = serverindex;
            f1.gmn = 0;
            f1.PathIndex = 0;
            f1.XCoordPath[0] = f1.XCoord = x;
            f1.YCoordPath[0] = f1.YCoord = y;
            f1.Id = id;
            f1.gmm = f1.Dir = arg3;
            f1.gmk = 0;
            OnNewNpc(serverindex, x, y, arg3, id);
        }
        Npc[NpcCount++] = f1;
        return f1;
    }

    private final void ShowTradeScreen1() {
        if (MouseButtonDown != 0 && ddd == 0) {
            ddd = 1;
        }
        if (ddd > 0) {
            int l = super.MouseX - 22;
            int i1 = super.MouseY - 36;

            if (l >= 0 && i1 >= 0 && l < 468 && i1 < 262) {
                if (l > 216 && i1 > 30 && l < 462 && i1 < 235) {
                    int j1 = (l - 217) / 49 + ((i1 - 31) / 34) * 5;

                    if (j1 >= 0 && j1 < InvCount) {
                        boolean flag = false;
                        int k2 = 0;
                        int j3 = InvItemId[j1];

                        for (int j4 = 0; j4 < TradeIndex; j4++) {
                            if (TradeItem[j4] == j3) {
                                if (Ident.ItemStackableVar[j3] == 0) {
                                    for (int l4 = 0; l4 < ddd; l4++) {
                                        if (TradeAmount[j4] < InvItemCount[j1]) {
                                            TradeAmount[j4]++;
                                        }
                                        flag = true;
                                    }
                                } else {
                                    k2++;
                                }
                            }
                        }
                        if (InvAmount(j3) <= k2) {
                            flag = true;
                        }
                        if (Ident.TradeableVar[j3] == 1) {
                            DisplayMessage("This object cannot be traded with other players", 3);
                            flag = true;
                        }
                        if (!flag && TradeIndex < 12) {
                            TradeItem[TradeIndex] = j3;
                            TradeAmount[TradeIndex] = 1;
                            TradeIndex++;
                            flag = true;
                        }
                        if (flag) {
                            super.Connection.SendID(45);
                            super.Connection.SendVar(TradeIndex);
                            for (int i5 = 0; i5 < TradeIndex; i5++) {
                                super.Connection.SendInt(TradeItem[i5]);
                                super.Connection.SendDouble(TradeAmount[i5]);
                            }
                            super.Connection.End();
                            OpponentTradeAccepted = false;
                            MyTradeAccepted1 = false;
                        }
                    }
                }
                if (l > 8 && i1 > 30 && l < 205 && i1 < 133) {
                    int k1 = (l - 9) / 49 + ((i1 - 31) / 34) * 4;

                    if (k1 >= 0 && k1 < TradeIndex) {
                        int i2 = TradeItem[k1];

                        for (int l2 = 0; l2 < ddd; l2++) {
                            if (Ident.ItemStackableVar[i2] == 0 && TradeAmount[k1] > 1) {
                                TradeAmount[k1]--;
                                continue;
                            }
                            TradeIndex--;
                            ddc = 0;
                            for (int k3 = k1; k3 < TradeIndex; k3++) {
                                TradeItem[k3] = TradeItem[k3 + 1];
                                TradeAmount[k3] = TradeAmount[k3 + 1];
                            }
                            break;
                        }
                        super.Connection.SendID(45);
                        super.Connection.SendVar(TradeIndex);
                        for (int l3 = 0; l3 < TradeIndex; l3++) {
                            super.Connection.SendInt(TradeItem[l3]);
                            super.Connection.SendDouble(TradeAmount[l3]);
                        }
                        super.Connection.End();
                        OpponentTradeAccepted = false;
                        MyTradeAccepted1 = false;
                    }
                }
                if (l >= 217 && i1 >= 238 && l <= 286 && i1 <= 259) {
                    MyTradeAccepted1 = true;
                    super.Connection.SendID(43);
                    super.Connection.End();
                }
                if (l >= 394 && i1 >= 238 && l < 463 && i1 < 259) {
                    TradeScreen1 = false;
                    super.Connection.SendID(42);
                    super.Connection.End();
                }
            } else if (MouseButtonDown != 0) {
                TradeScreen1 = false;
                super.Connection.SendID(42);
                super.Connection.End();
            }
            MouseButtonDown = 0;
            ddd = 0;
        }
        if (!TradeScreen1) {
            return;
        }
        byte byte0 = 22;
        byte byte1 = 36;

        Gfx.DrawBox(byte0, byte1, 468, 12, 192);
        int l1 = 0x989898;

        Gfx.cam(byte0, byte1 + 12, 468, 18, l1, 160);
        Gfx.cam(byte0, byte1 + 30, 8, 248, l1, 160);
        Gfx.cam(byte0 + 205, byte1 + 30, 11, 248, l1, 160);
        Gfx.cam(byte0 + 462, byte1 + 30, 6, 248, l1, 160);
        Gfx.cam(byte0 + 8, byte1 + 133, 197, 22, l1, 160);
        Gfx.cam(byte0 + 8, byte1 + 258, 197, 20, l1, 160);
        Gfx.cam(byte0 + 216, byte1 + 235, 246, 43, l1, 160);
        int j2 = 0xd0d0d0;

        Gfx.cam(byte0 + 8, byte1 + 30, 197, 103, j2, 160);
        Gfx.cam(byte0 + 8, byte1 + 155, 197, 103, j2, 160);
        Gfx.cam(byte0 + 216, byte1 + 30, 246, 205, j2, 160);
        for (int i3 = 0; i3 < 4; i3++) {
            Gfx.cbc(byte0 + 8, byte1 + 30 + i3 * 34, 197, 0);
        }
        for (int i4 = 0; i4 < 4; i4++) {
            Gfx.cbc(byte0 + 8, byte1 + 155 + i4 * 34, 197, 0);
        }
        for (int k4 = 0; k4 < 7; k4++) {
            Gfx.cbc(byte0 + 216, byte1 + 30 + k4 * 34, 246, 0);
        }
        for (int j5 = 0; j5 < 6; j5++) {
            if (j5 < 5) {
                Gfx.cbd(byte0 + 8 + j5 * 49, byte1 + 30, 103, 0);
            }
            if (j5 < 5) {
                Gfx.cbd(byte0 + 8 + j5 * 49, byte1 + 155, 103, 0);
            }
            Gfx.cbd(byte0 + 216 + j5 * 49, byte1 + 30, 205, 0);
        }
        Gfx.DrawStr("Trading with: " + TradeOpponentName, byte0 + 1, byte1 + 10, 1, 0xffffff);
        Gfx.DrawStr("Your Offer", byte0 + 9, byte1 + 27, 4, 0xffffff);
        Gfx.DrawStr("Opponent's Offer", byte0 + 9, byte1 + 152, 4, 0xffffff);
        Gfx.DrawStr("Your Inventory", byte0 + 216, byte1 + 27, 4, 0xffffff);
        if (!MyTradeAccepted1) {
            Gfx.DrawPicture(byte0 + 217, byte1 + 238, del + 25);
        }
        Gfx.DrawPicture(byte0 + 394, byte1 + 238, del + 26);
        if (OpponentTradeAccepted) {
            Gfx.DrawCenteredStr("Other player", byte0 + 341, byte1 + 246, 1, 0xffffff);
            Gfx.DrawCenteredStr("has accepted", byte0 + 341, byte1 + 256, 1, 0xffffff);
        }
        if (MyTradeAccepted1) {
            Gfx.DrawCenteredStr("Waiting for", byte0 + 217 + 35, byte1 + 246, 1, 0xffffff);
            Gfx.DrawCenteredStr("other player", byte0 + 217 + 35, byte1 + 256, 1, 0xffffff);
        }
        for (int k5 = 0; k5 < InvCount; k5++) {
            int l5 = 217 + byte0 + (k5 % 5) * 49;
            int j6 = 31 + byte1 + (k5 / 5) * 34;

            Gfx.cdd(l5, j6, 48, 32, den + Ident.PictureOffset[InvItemId[k5]], Ident.ajk[InvItemId[k5]], 0, 0, false);
            if (Ident.ItemStackableVar[InvItemId[k5]] == 0) {
                Gfx.DrawStr(String.valueOf(InvItemCount[k5]), l5 + 1, j6 + 10, 1, 0xffff00);
            }
        }
        for (int i6 = 0; i6 < TradeIndex; i6++) {
            int k6 = 9 + byte0 + (i6 % 4) * 49;
            int i7 = 31 + byte1 + (i6 / 4) * 34;

            Gfx.cdd(k6, i7, 48, 32, den + Ident.PictureOffset[TradeItem[i6]], Ident.ajk[TradeItem[i6]], 0, 0, false);
            if (Ident.ItemStackableVar[TradeItem[i6]] == 0) {
                Gfx.DrawStr(String.valueOf(TradeAmount[i6]), k6 + 1, i7 + 10, 1, 0xffff00);
            }
            if (super.MouseX > k6 && super.MouseX < k6 + 48 && super.MouseY > i7 && super.MouseY < i7 + 32) {
                Gfx.DrawStr(
                        Ident.ItemName[TradeItem[i6]] + CheckId(TradeItem[i6]) + ": @whi@"
                        + Ident.ItemDescription[TradeItem[i6]],
                        byte0 + 8,
                        byte1 + 273,
                        1,
                        0xffff00);
            }
        }
        for (int l6 = 0; l6 < OpponentTradeIndex; l6++) {
            int j7 = 9 + byte0 + (l6 % 4) * 49;
            int k7 = 156 + byte1 + (l6 / 4) * 34;

            Gfx.cdd(j7, k7, 48, 32, den + Ident.PictureOffset[OpponentTradeItem[l6]], Ident.ajk[OpponentTradeItem[l6]],
                    0, 0, false);
            if (Ident.ItemStackableVar[OpponentTradeItem[l6]] == 0) {
                Gfx.DrawStr(String.valueOf(OpponentTradeAmount[l6]), j7 + 1, k7 + 10, 1, 0xffff00);
            }
            if (super.MouseX > j7 && super.MouseX < j7 + 48 && super.MouseY > k7 && super.MouseY < k7 + 32) {
                Gfx.DrawStr(
                        Ident.ItemName[OpponentTradeItem[l6]] + CheckId(OpponentTradeItem[l6]) + ": @whi@"
                        + Ident.ItemDescription[OpponentTradeItem[l6]],
                        byte0 + 8,
                        byte1 + 273,
                        1,
                        0xffff00);
            }
        }
    }

    private final void RunCommand(int l) {
        int i1 = OptionX[l];
        int j1 = OptionY[l];
        int k1 = dfm[l];
        int l1 = dfn[l];
        int i2 = dga[l];
        int j2 = OptionId[l];

        if (j2 == 200) {
            Debug("CastOnGItem(" + l1 + ", " + k1 + ", " + (i1 + TileX) + ", " + (j1 + TileY) + ")");
            fdn(LocalX, LocalY, i1, j1, true);
            super.Connection.SendID(12);
            super.Connection.SendInt(i1 + TileX);
            super.Connection.SendInt(j1 + TileY);
            super.Connection.SendInt(k1);
            super.Connection.SendInt(l1);
            super.Connection.End();
            SelectedSpell = -1;
        }
        if (j2 == 210) {
            Debug("UseItemOnGItem(" + l1 + ", " + (i1 + TileX) + ", " + (j1 + TileY) + ", " + k1 + ")");
            fdn(LocalX, LocalY, i1, j1, true);
            super.Connection.SendID(13);
            super.Connection.SendInt(i1 + TileX);
            super.Connection.SendInt(j1 + TileY);
            super.Connection.SendInt(k1);
            super.Connection.SendInt(l1);
            super.Connection.End();
            SelectedItem = -1;
        }
        if (j2 == 220) {
            Debug("PickUp(" + (i1 + TileX) + ", " + (j1 + TileY) + ", " + k1 + ")");
            fdn(LocalX, LocalY, i1, j1, true);
            super.Connection.SendID(14);
            super.Connection.SendInt(i1 + TileX);
            super.Connection.SendInt(j1 + TileY);
            super.Connection.SendInt(k1);
            super.Connection.SendInt(l1);
            super.Connection.End();
        }
        if (j2 == 3200) { // Examine Ground Item
            DisplayMessage(Ident.ItemDescription[k1], 3);
        }
        if (j2 == 300) {
            Debug("CastOnWallObject(" + l1 + ", " + (i1 + TileX) + ", " + (j1 + TileY) + ")");
            fcd(i1, j1, k1);
            super.Connection.SendID(15);
            super.Connection.SendInt(i1 + TileX);
            super.Connection.SendInt(j1 + TileY);
            super.Connection.SendVar(k1);
            super.Connection.SendInt(l1);
            super.Connection.End();
            SelectedSpell = -1;
        }
        if (j2 == 310) {
            Debug("UseOnWallObject(" + l1 + ", " + (i1 + TileX) + ", " + (j1 + TileY) + ")");
            fcd(i1, j1, k1);
            super.Connection.SendID(16);
            super.Connection.SendInt(i1 + TileX);
            super.Connection.SendInt(j1 + TileY);
            super.Connection.SendVar(k1);
            super.Connection.SendInt(l1);
            super.Connection.End();
            SelectedItem = -1;
        }
        if (j2 == 320) {
            Debug("AtWallObject(" + (i1 + TileX) + ", " + (j1 + TileY) + ")");
            fcd(i1, j1, k1);
            super.Connection.SendID(17);
            super.Connection.SendInt(i1 + TileX);
            super.Connection.SendInt(j1 + TileY);
            super.Connection.SendVar(k1);
            super.Connection.End();
        }
        if (j2 == 2300) {
            Debug("AtWallObject2(" + (i1 + TileX) + ", " + (j1 + TileY) + ")");
            fcd(i1, j1, k1);
            super.Connection.SendID(18);
            super.Connection.SendInt(i1 + TileX);
            super.Connection.SendInt(j1 + TileY);
            super.Connection.SendVar(k1);
            super.Connection.End();
        }
        if (j2 == 3300) { // Examine wall object
            DisplayMessage(Ident.WallObjectDescription[k1], 3);
        }
        if (j2 == 400) {
            Debug("CastOnObject(" + i2 + ", " + (i1 + TileX) + ", " + (j1 + TileY) + ")");
            fba(i1, j1, k1, l1);
            super.Connection.SendID(19);
            super.Connection.SendInt(i1 + TileX);
            super.Connection.SendInt(j1 + TileY);
            super.Connection.SendInt(i2);
            super.Connection.End();
            SelectedSpell = -1;
        }
        if (j2 == 410) {
            Debug("UseOnObject(" + i2 + ", " + (i1 + TileX) + ", " + (j1 + TileY) + ")");
            fba(i1, j1, k1, l1);
            super.Connection.SendID(20);
            super.Connection.SendInt(i1 + TileX);
            super.Connection.SendInt(j1 + TileY);
            super.Connection.SendInt(i2);
            super.Connection.End();
            SelectedItem = -1;
        }
        if (j2 == 420) {
            Debug("AtObject(" + (i1 + TileX) + ", " + (j1 + TileY) + ")");
            fba(i1, j1, k1, l1);
            super.Connection.SendID(21);
            super.Connection.SendInt(i1 + TileX);
            super.Connection.SendInt(j1 + TileY);
            super.Connection.End();
        }
        if (j2 == 2400) {
            Debug("AtObject2(" + (i1 + TileX) + ", " + (j1 + TileY) + ")");
            fba(i1, j1, k1, l1);
            super.Connection.SendID(22);
            super.Connection.SendInt(i1 + TileX);
            super.Connection.SendInt(j1 + TileY);
            super.Connection.End();
        }
        if (j2 == 3400) { // Examine Object
            DisplayMessage(Ident.ObjectDescription[k1], 3);
        }
        if (j2 == 600) {
            Debug("CastOnItem(" + l1 + ", " + k1 + ")");
            super.Connection.SendID(23);
            super.Connection.SendInt(k1);
            super.Connection.SendInt(l1);
            super.Connection.End();
            SelectedSpell = -1;
        }
        if (j2 == 610) {
            Debug("UseItemWithItem(" + k1 + ", " + l1 + ")");
            super.Connection.SendID(24);
            super.Connection.SendInt(k1);
            super.Connection.SendInt(l1);
            super.Connection.End();
            SelectedItem = -1;
        }
        if (j2 == 620) {
            Debug("RemoveItem(" + k1 + ")");
            super.Connection.SendID(25);
            super.Connection.SendInt(k1);
            super.Connection.End();
        }
        if (j2 == 630) {
            Debug("WearItem(" + k1 + ")");
            super.Connection.SendID(26);
            super.Connection.SendInt(k1);
            super.Connection.End();
        }
        if (j2 == 640) {
            Debug("UseItem(" + k1 + ")");
            super.Connection.SendID(27);
            super.Connection.SendInt(k1);
            super.Connection.End();
        }
        if (j2 == 650) // Use Item
        {
            Debug("UseItem2(" + k1 + ")");
            SelectedItem = k1;
            dje = 0;
            SelectedItemName = Ident.ItemName[InvItemId[SelectedItem]];
        }
        if (j2 == 660) {
            Debug("Drop(" + k1 + ")");
            super.Connection.SendID(28);
            super.Connection.SendInt(k1);
            super.Connection.End();
            SelectedItem = -1;
            dje = 0;
            DisplayMessage("Dropping " + Ident.ItemName[InvItemId[k1]] + CheckId(InvItemId[k1]), 4);
        }
        if (j2 == 3600) { // Examine Item
            DisplayMessage(Ident.ItemDescription[k1], 3);
        }
        if (j2 == 700) {
            Debug("CastOnNpc(" + l1 + ", int index)");
            int k2 = (i1 - 64) / ecj;
            int k4 = (j1 - 64) / ecj;

            ena(LocalX, LocalY, k2, k4, true);
            super.Connection.SendID(29);
            super.Connection.SendInt(k1);
            super.Connection.SendInt(l1);
            super.Connection.End();
            SelectedSpell = -1;
        }
        if (j2 == 710) {
            Debug("UseOnNpc(" + l1 + ", int index)");
            int l2 = (i1 - 64) / ecj;
            int l4 = (j1 - 64) / ecj;

            ena(LocalX, LocalY, l2, l4, true);
            super.Connection.SendID(30);
            super.Connection.SendInt(k1);
            super.Connection.SendInt(l1);
            super.Connection.End();
            SelectedItem = -1;
        }
        if (j2 == 720) {
            Debug("TalkToNpc(int index)");
            int i3 = (i1 - 64) / ecj;
            int i5 = (j1 - 64) / ecj;

            ena(LocalX, LocalY, i3, i5, true);
            super.Connection.SendID(31);
            super.Connection.SendInt(k1);
            super.Connection.End();
        }
        if (j2 == 725) {
            Debug("ThieveNpc(int index)");
            int j3 = (i1 - 64) / ecj;
            int j5 = (j1 - 64) / ecj;

            ena(LocalX, LocalY, j3, j5, true);
            super.Connection.SendID(32);
            super.Connection.SendInt(k1);
            super.Connection.End();
        }
        if (j2 == 715 || j2 == 2715) {
            Debug("AttackNpc(int index)");
            int k3 = (i1 - 64) / ecj;
            int k5 = (j1 - 64) / ecj;

            ena(LocalX, LocalY, k3, k5, true);
            super.Connection.SendID(33);
            super.Connection.SendInt(k1);
            super.Connection.End();
        }
        if (j2 == 3700) { // Examine Npc
            DisplayMessage(Ident.NpcDescription[k1], 3);
        }
        if (j2 == 800) {
            int l3 = (i1 - 64) / ecj;
            int l5 = (j1 - 64) / ecj;

            ena(LocalX, LocalY, l3, l5, true);
            super.Connection.SendID(34);
            super.Connection.SendInt(k1);
            super.Connection.SendInt(l1);
            super.Connection.End();
            SelectedSpell = -1;
        }
        if (j2 == 810) {
            int i4 = (i1 - 64) / ecj;
            int i6 = (j1 - 64) / ecj;

            ena(LocalX, LocalY, i4, i6, true);
            super.Connection.SendID(35);
            super.Connection.SendInt(k1);
            super.Connection.SendInt(l1);
            super.Connection.End();
            SelectedItem = -1;
        }
        if (j2 == 805 || j2 == 2805) {
            int j4 = (i1 - 64) / ecj;
            int j6 = (j1 - 64) / ecj;

            ena(LocalX, LocalY, j4, j6, true);
            super.Connection.SendID(36);
            super.Connection.SendInt(k1);
            super.Connection.End();
        }
        if (j2 == 2806) {
            super.Connection.SendID(37);
            super.Connection.SendInt(k1);
            super.Connection.End();
        }
        if (j2 == 2810) {
            Debug("TradePlayer(int index)");
            super.Connection.SendID(38);
            super.Connection.SendInt(k1);
            super.Connection.End();
        }
        if (j2 == 2811) // Add to Friend list
        {
            for (int a = 0; a < PlayerCount; a++) {
                if (Player[a].ServerIndex == k1) {
                    AddFriend(Player[a].Name);
                }
            }
        }
        if (j2 == 2820) {
            super.Connection.SendID(39);
            super.Connection.SendInt(k1);
            super.Connection.End();
        }
        if (j2 == 900) {
            Debug("CastOnGround(" + k1 + ")");
            ena(LocalX, LocalY, i1, j1, true);
            super.Connection.SendID(40);
            super.Connection.SendInt(i1 + TileX);
            super.Connection.SendInt(j1 + TileY);
            super.Connection.SendInt(k1);
            super.Connection.End();
            SelectedSpell = -1;
        }
        if (j2 == 920) // Walk
        {
            Debug("WalkTo(" + (i1 + TileX) + ", " + (j1 + TileY) + ")");
            ena(LocalX, LocalY, i1, j1, false);
            if (eak == -24) {
                eak = 24;
            }
        }
        if (j2 == 925) // ForceWalk
        {
            Debug("ForceWalkTo(" + (i1 + TileX) + ", " + (j1 + TileY) + ")");
            fdn(LocalX, LocalY, i1, j1, true);
            if (eak == -24) {
                eak = 24;
            }
            super.Connection.SendID(14);
            super.Connection.SendInt(i1 + TileX);
            super.Connection.SendInt(j1 + TileY);
            super.Connection.SendInt(k1);
            super.Connection.SendInt(l1);
            super.Connection.End();
        }
        if (j2 == 1000) {
            Debug("CastOnSelf(" + k1 + ")");
            super.Connection.SendID(41);
            super.Connection.SendInt(k1);
            super.Connection.End();
            SelectedSpell = -1;
        }
        if (j2 == 4000) // Cancel
        {
            SelectedItem = -1;
            SelectedSpell = -1;
        }
    }

    final void fam(int l, int i1, int j1, int k1, int l1, int i2, int j2) {
        int k2 = ekn[l1];
        int l2 = dna[l1];

        if (k2 == 0) {
            int i3 = 255 + l2 * 5 * 256;

            Gfx.cal(l + j1 / 2, i1 + k1 / 2, 20 + l2 * 2, i3, 255 - l2 * 5);
        }
        if (k2 == 1) {
            int j3 = 0xff0000 + l2 * 5 * 256;

            Gfx.cal(l + j1 / 2, i1 + k1 / 2, 10 + l2, j3, 255 - l2 * 5);
        }
    }

    private final void DoPlay() {
        if (edh > 1) {
            edh--;
        }
        acd();
        if (dhf > 0) {
            dhf--;
        }
        if (My.Dir == 8 || My.Dir == 9) {
            eda = 500;
        }
        if (eda > 0) {
            eda--;
        }
        if (efc) {
            fcn();
            return;
        }
        for (int l = 0; l < PlayerCount; l++) {
            NpcObject f1 = Player[l];
            int j1 = (f1.PathIndex + 1) % 10;

            if (f1.gmn != j1) {
                int l1 = -1;
                int k3 = f1.gmn;
                int i5;

                if (k3 < j1) {
                    i5 = j1 - k3;
                } else {
                    i5 = (10 + j1) - k3;
                }
                int i6 = 4;

                if (i5 > 2) {
                    i6 = (i5 - 1) * 4;
                }
                if (f1.XCoordPath[k3] - f1.XCoord > ecj * 3 || f1.YCoordPath[k3] - f1.YCoord > ecj * 3
                        || f1.XCoordPath[k3] - f1.XCoord < -ecj * 3 || f1.YCoordPath[k3] - f1.YCoord < -ecj * 3
                        || i5 > 8) {
                    f1.XCoord = f1.XCoordPath[k3];
                    f1.YCoord = f1.YCoordPath[k3];
                } else {
                    if (f1.XCoord < f1.XCoordPath[k3]) {
                        f1.XCoord += i6;
                        f1.gmk++;
                        l1 = 2;
                    } else if (f1.XCoord > f1.XCoordPath[k3]) {
                        f1.XCoord -= i6;
                        f1.gmk++;
                        l1 = 6;
                    }
                    if (f1.XCoord - f1.XCoordPath[k3] < i6 && f1.XCoord - f1.XCoordPath[k3] > -i6) {
                        f1.XCoord = f1.XCoordPath[k3];
                    }
                    if (f1.YCoord < f1.YCoordPath[k3]) {
                        f1.YCoord += i6;
                        f1.gmk++;
                        if (l1 == -1) {
                            l1 = 4;
                        } else if (l1 == 2) {
                            l1 = 3;
                        } else {
                            l1 = 5;
                        }
                    } else if (f1.YCoord > f1.YCoordPath[k3]) {
                        f1.YCoord -= i6;
                        f1.gmk++;
                        if (l1 == -1) {
                            l1 = 0;
                        } else if (l1 == 2) {
                            l1 = 1;
                        } else {
                            l1 = 7;
                        }
                    }
                    if (f1.YCoord - f1.YCoordPath[k3] < i6 && f1.YCoord - f1.YCoordPath[k3] > -i6) {
                        f1.YCoord = f1.YCoordPath[k3];
                    }
                }
                if (l1 != -1) {
                    f1.Dir = l1;
                }
                if (f1.XCoord == f1.XCoordPath[k3] && f1.YCoord == f1.YCoordPath[k3]) {
                    f1.gmn = (k3 + 1) % 10;
                }
            } else {
                f1.Dir = f1.gmm;
            }
            if (f1.TalkVar > 0) {
                f1.TalkVar--;
            }
            if (f1.gnh > 0) {
                f1.gnh--;
            }
            if (f1.CombatVar > 0) {
                f1.CombatVar--;
            }
            if (dfl > 0) {
                dfl--;
                if (dfl == 0) {
                    DisplayMessage("You have been granted another life. Be more careful this time!", 3);
                }
                if (dfl == 0) {
                    DisplayMessage("You retain your skills. Your objects land where you died", 3);
                }
            }
        }
        for (int i1 = 0; i1 < NpcCount; i1++) {
            NpcObject f2 = Npc[i1];
            int i2 = (f2.PathIndex + 1) % 10;

            if (f2.gmn != i2) {
                int l3 = -1;
                int j5 = f2.gmn;
                int j6;

                if (j5 < i2) {
                    j6 = i2 - j5;
                } else {
                    j6 = (10 + i2) - j5;
                }
                int k6 = 4;

                if (j6 > 2) {
                    k6 = (j6 - 1) * 4;
                }
                if (f2.XCoordPath[j5] - f2.XCoord > ecj * 3 || f2.YCoordPath[j5] - f2.YCoord > ecj * 3
                        || f2.XCoordPath[j5] - f2.XCoord < -ecj * 3 || f2.YCoordPath[j5] - f2.YCoord < -ecj * 3
                        || j6 > 8) {
                    f2.XCoord = f2.XCoordPath[j5];
                    f2.YCoord = f2.YCoordPath[j5];
                } else {
                    if (f2.XCoord < f2.XCoordPath[j5]) {
                        f2.XCoord += k6;
                        f2.gmk++;
                        l3 = 2;
                    } else if (f2.XCoord > f2.XCoordPath[j5]) {
                        f2.XCoord -= k6;
                        f2.gmk++;
                        l3 = 6;
                    }
                    if (f2.XCoord - f2.XCoordPath[j5] < k6 && f2.XCoord - f2.XCoordPath[j5] > -k6) {
                        f2.XCoord = f2.XCoordPath[j5];
                    }
                    if (f2.YCoord < f2.YCoordPath[j5]) {
                        f2.YCoord += k6;
                        f2.gmk++;
                        if (l3 == -1) {
                            l3 = 4;
                        } else if (l3 == 2) {
                            l3 = 3;
                        } else {
                            l3 = 5;
                        }
                    } else if (f2.YCoord > f2.YCoordPath[j5]) {
                        f2.YCoord -= k6;
                        f2.gmk++;
                        if (l3 == -1) {
                            l3 = 0;
                        } else if (l3 == 2) {
                            l3 = 1;
                        } else {
                            l3 = 7;
                        }
                    }
                    if (f2.YCoord - f2.YCoordPath[j5] < k6 && f2.YCoord - f2.YCoordPath[j5] > -k6) {
                        f2.YCoord = f2.YCoordPath[j5];
                    }
                }
                if (l3 != -1) {
                    f2.Dir = l3;
                }
                if (f2.XCoord == f2.XCoordPath[j5] && f2.YCoord == f2.YCoordPath[j5]) {
                    f2.gmn = (j5 + 1) % 10;
                }
            } else {
                f2.Dir = f2.gmm;
                if (f2.Id == 43) {
                    f2.gmk++;
                }
            }
            if (f2.TalkVar > 0) {
                f2.TalkVar--;
            }
            if (f2.gnh > 0) {
                f2.gnh--;
            }
            if (f2.CombatVar > 0) {
                f2.CombatVar--;
            }
        }
        if (dje != 2) {
            if (j.bnn > 0) {
                ekh++;
            }
            if (j.caa > 0) {
                ekh = 0;
            }
            j.bnn = 0;
            j.caa = 0;
        }
        for (int k1 = 0; k1 < PlayerCount; k1++) {
            NpcObject f3 = Player[k1];

            if (f3.hag > 0) {
                f3.hag--;
            }
        }
        if (dhg) {
            if (dlg - My.XCoord < -500 || dlg - My.XCoord > 500 || dlh - My.YCoord < -500 || dlh - My.YCoord > 500) {
                dlg = My.XCoord;
                dlh = My.YCoord;
            }
        } else {
            if (dlg - My.XCoord < -500 || dlg - My.XCoord > 500 || dlh - My.YCoord < -500 || dlh - My.YCoord > 500) {
                dlg = My.XCoord;
                dlh = My.YCoord;
            }
            if (dlg != My.XCoord) {
                dlg += (My.XCoord - dlg) / (16 + (Zoom - 500) / 15);
            }
            if (dlh != My.YCoord) {
                dlh += (My.YCoord - dlh) / (16 + (Zoom - 500) / 15);
            }
            if (efb) {
                int j2 = ema * 32;
                int i4 = j2 - dke;
                byte byte0 = 1;

                if (i4 != 0) {
                    emb++;
                    if (i4 > 128) {
                        byte0 = -1;
                        i4 = 256 - i4;
                    } else if (i4 > 0) {
                        byte0 = 1;
                    } else if (i4 < -128) {
                        byte0 = 1;
                        i4 = 256 + i4;
                    } else if (i4 < 0) {
                        byte0 = -1;
                        i4 = -i4;
                    }
                    dke += ((emb * i4 + 255) / 256) * byte0;
                    dke &= 0xff;
                } else {
                    emb = 0;
                }
            }
        }
        if (ekh > 20) {
            dle = false;
            ekh = 0;
        }
        if (Sleeping) {
            if (super.fkm.length() > 0) {
                if (super.fkm.equalsIgnoreCase("::lostcon") && !dhh) {
                    super.Connection.baj();
                } else if (super.fkm.equalsIgnoreCase("::closecon") && !dhh) {
                    aca();
                } else {
                    super.Connection.SendID(59);
                    super.Connection.SendString(super.fkm);
                    if (!dle) {
                        super.Connection.SendVar(0);
                        dle = true;
                    }
                    super.Connection.End();
                    super.fkl = "";
                    super.fkm = "";
                    SleepMessage = "Please wait...";
                }
            }
            if (super.fkh == 1 && super.MouseY > 275 && super.MouseY < 310 && super.MouseX > 56 && super.MouseX < 456) {
                super.Connection.SendID(59);
                super.Connection.SendString("-null-");
                if (!dle) {
                    super.Connection.SendVar(0);
                    dle = true;
                }
                super.Connection.End();
                super.fkl = "";
                super.fkm = "";
                SleepMessage = "Please wait...";
            }
            super.fkh = 0;
            return;
        }
        if (super.MouseY > RsHeight - 4) {
            if (super.MouseX > 10 && super.MouseX < 90 && super.fkh == 1) {
                ell = 0;
            }
            if (super.MouseX > 110 && super.MouseX < 190 && super.fkh == 1) {
                ell = 1;
                elg.gbc[elh] = 0xf423f;
            }
            if (super.MouseX > 210 && super.MouseX < 290 && super.fkh == 1) {
                ell = 2;
                elg.gbc[elj] = 0xf423f;
            }
            if (super.MouseX > 310 && super.MouseX < 390 && super.fkh == 1) {
                ell = 3;
                elg.gbc[elk] = 0xf423f;
            }
            if (super.MouseX > 410 && super.MouseX < 490 && super.fkh == 1) {
                ell = 4;
                elg.gbc[tabThing[chanIndex]] = 0xf423f;
            }
            super.fkh = 0;
            super.MouseDownVar = 0;
        }
        elg.gea(super.MouseX, super.MouseY, super.fkh, super.MouseDownVar);
        if (ell > 0 && super.MouseX >= 494 && super.MouseY >= RsHeight - 66) {
            super.fkh = 0;
        }
        if (elg.geb(eli)) {
            LastStr = elg.ggd(eli);
            String s1 = LastStr.toLowerCase();

            elg.ggc(eli, "");
            if (s1.startsWith("::")) {
                s1 = s1.substring(2);
                if (s1.startsWith("closecon") && !dhh) {
                    super.Connection.baj();
                } else if (s1.startsWith("logout") && !dhh) {
                    aca();
                } else if (s1.startsWith("lostcon") && !dhh) {
                    Reconnect();
                }
            } else if (s1.startsWith("/")) {
                s1 = s1.substring(1);
                if (s1.equals("stop")) {
                    StopMacro();
                } else if (s1.equals("reload")) {
                    ShowCmd("Reloading...");
                    Load(this);
                } else if (s1.startsWith("start")) {
                    if (s1.length() < 7) {
                        ShowCmd("No script specified");
                    } else {
                        Command(s1.substring(6, s1.length()));
                    }
                } else if (s1.equals("reset")) {
                    MacroExp = 0;
                } else if (s1.startsWith("hop(") && s1.endsWith(")")) {
                    if (eda <= 0) {
                        try {
                            int a = Integer.parseInt(Arg(s1, 1));

                            if (validWorld(a)) {
                                ChangeWorld(a);
                                Server = String.valueOf(a);
                                Hopping = true;
                                Logout();
                            } else {
                                ShowCmd("Invalid Server");
                            }
                        } catch (Exception e) {
                            ShowCmd("Invalid server");
                        }
                    }
                } else if (s1.startsWith("offer(") && s1.endsWith(")")) {
                    int item = Integer.parseInt(Arg(s1, 1));
                    int ammount = Integer.parseInt(Arg(s1, 2));

                    try {
                        Offer(item, ammount);
                    } catch (Exception e) {}
                } else if (s1.startsWith("stake(") && s1.endsWith(")")) {
                    int item = Integer.parseInt(Arg(s1, 1));
                    int ammount = Integer.parseInt(Arg(s1, 2));

                    try {
                        Stake(item, ammount);
                    } catch (Exception e) {}
                } else if (s1.startsWith("deposit(") && s1.endsWith(")")) {
                    int item = Integer.parseInt(Arg(s1, 1));
                    int ammount = Integer.parseInt(Arg(s1, 2));

                    WithdrawEx(item, ammount, false);
                } else if (s1.startsWith("withdraw(") && s1.endsWith(")")) {
                    int item = Integer.parseInt(Arg(s1, 1));
                    int ammount = Integer.parseInt(Arg(s1, 2));

                    WithdrawEx(item, ammount, true);
                } else if (s1.equals("macros")) {
                    SelectMacro();
                } else if (isAlive()) {
                    ircInputCommand(LastStr.substring(1));
                }
                if (run && LoggedInVar == 1 && macro != null) {
                    macro.OnInput(s1);
                }
            } else if (ell != 4) {
                Talk(s1);
            } else if (chanIndex > 0) {
                ircSendMessage(currentChannel(), LastStr);
            }
        }
        if (ell == 0) {
            for (int k2 = 0; k2 < 5; k2++) {
                if (def[k2] > 0) {
                    def[k2]--;
                }
            }
        }
        if (dfl != 0) {
            super.fkh = 0;
        }
        if (TradeScreen1 || deh) {
            if (super.MouseDownVar != 0) {
                ddc++;
            } else {
                ddc = 0;
            }
            if (ddc > 600) {
                ddd += 5000;
            } else if (ddc > 450) {
                ddd += 500;
            } else if (ddc > 300) {
                ddd += 50;
            } else if (ddc > 150) {
                ddd += 5;
            } else if (ddc > 50) {
                ddd++;
            } else if (ddc > 20 && (ddc & 5) == 0) {
                ddd++;
            }
        } else {
            ddc = 0;
            ddd = 0;
        }
        if (super.fkh == 1) {
            MouseButtonDown = 1;
        } else if (super.fkh == 2) {
            MouseButtonDown = 2;
        }
        efn.bhg(super.MouseX, super.MouseY);
        super.fkh = 0;
        if (efb) {
            if (emb == 0 || dhg) {
                if (super.fjl) {
                    ema = ema + 1 & 7;
                    super.fjl = false;
                    if (!Inside) {
                        if ((ema & 1) == 0) {
                            ema = ema + 1 & 7;
                        }
                        for (int l2 = 0; l2 < 8; l2++) {
                            if (fab(ema)) {
                                break;
                            }
                            ema = ema + 1 & 7;
                        }
                    }
                }
                if (super.fjm) {
                    ema = ema + 7 & 7;
                    super.fjm = false;
                    if (!Inside) {
                        if ((ema & 1) == 0) {
                            ema = ema + 7 & 7;
                        }
                        for (int i3 = 0; i3 < 8; i3++) {
                            if (fab(ema)) {
                                break;
                            }
                            ema = ema + 7 & 7;
                        }
                    }
                }
            }
        } else if (super.fjl) {
            dke = dke + 2 & 0xff;
        } else if (super.fjm) {
            dke = dke - 2 & 0xff;
        }
        if (Inside && Zoom > 550) {
            Zoom -= 4;
        } else if (!Inside && Zoom < 750) {
            Zoom += 4;
        }
        if (eak > 0) {
            eak--;
        } else if (eak < 0) {
            eak++;
        }
        efn.bji(17);
        eib++;
        if (eib > 5) {
            eib = 0;
            edi = (edi + 1) % 3;
            edj = (edj + 1) % 4;
            edk = (edk + 1) % 5;
        }
        for (int j3 = 0; j3 < ObjectCount; j3++) {
            int k4 = ObjectX[j3];
            int k5 = ObjectY[j3];

            if (k4 >= 0 && k5 >= 0 && k4 < 96 && k5 < 96 && ObjectId[j3] == 74) {
                ddf[j3].cmi(1, 0, 0);
            }
        }
        for (int l4 = 0; l4 < ean; l4++) {
            dna[l4]++;
            if (dna[l4] > 50) {
                ean--;
                for (int l5 = l4; l5 < ean; l5++) {
                    dnc[l5] = dnc[l5 + 1];
                    dgb[l5] = dgb[l5 + 1];
                    dna[l5] = dna[l5 + 1];
                    ekn[l5] = ekn[l5 + 1];
                }
            }
        }
    }

    private final void fba(int arg0, int arg1, int arg2, int arg3) {
        int l;
        int i1;

        if (arg2 == 0 || arg2 == 4) {
            l = Ident.all[arg3];
            i1 = Ident.alm[arg3];
        } else {
            i1 = Ident.all[arg3];
            l = Ident.alm[arg3];
        }
        if (Ident.aln[arg3] == 2 || Ident.aln[arg3] == 3) {
            if (arg2 == 0) {
                arg0--;
                l++;
            }
            if (arg2 == 2) {
                i1++;
            }
            if (arg2 == 4) {
                l++;
            }
            if (arg2 == 6) {
                arg1--;
                i1++;
            }
            fde(LocalX, LocalY, arg0, arg1, (arg0 + l) - 1, (arg1 + i1) - 1, false, true);
        } else {
            fde(LocalX, LocalY, arg0, arg1, (arg0 + l) - 1, (arg1 + i1) - 1, true, true);
        }
    }

    private final void LoadModels() {
        Ident.anj("torcha2");
        Ident.anj("torcha3");
        Ident.anj("torcha4");
        Ident.anj("skulltorcha2");
        Ident.anj("skulltorcha3");
        Ident.anj("skulltorcha4");
        Ident.anj("firea2");
        Ident.anj("firea3");
        Ident.anj("fireplacea2");
        Ident.anj("fireplacea3");
        Ident.anj("firespell2");
        Ident.anj("firespell3");
        Ident.anj("lightning2");
        Ident.anj("lightning3");
        Ident.anj("clawspell2");
        Ident.anj("clawspell3");
        Ident.anj("clawspell4");
        Ident.anj("clawspell5");
        Ident.anj("spellcharge2");
        Ident.anj("spellcharge3");
        byte abyte0[] = LoadDataFile(12, "3d models", 60);

        for (int i1 = 0; i1 < Ident.aim; i1++) {
            int j1 = t.fne(Ident.ahl[i1] + ".ob3", abyte0);

            if (j1 != 0) {
                dkj[i1] = new i(abyte0, j1, true);
            } else {
                dkj[i1] = new i(1, 1);
            }
            if (Ident.ahl[i1].equals("giantcrystal")) {
                dkj[i1].chj = true;
            }
        }
    }

    private final void StatMenu(boolean arg0) {
        int l = ((j) (Gfx)).blg - 199;
        int i1 = 36;

        Gfx.DrawPicture(l - 49, 3, del + 3);
        char c1 = '\304';
        char c2 = '\u0113';
        int k1;
        int j1 = k1 = j.ToHex(160, 160, 160);

        if (dii == 0) {
            j1 = j.ToHex(220, 220, 220);
        } else {
            k1 = j.ToHex(220, 220, 220);
        }
        Gfx.cam(l, i1, c1 / 2, 24, j1, 128);
        Gfx.cam(l + c1 / 2, i1, c1 / 2, 24, k1, 128);
        Gfx.cam(l, i1 + 24, c1, c2 - 12, j.ToHex(220, 220, 220), 128);
        Gfx.cbc(l, i1 + 24, c1, 0);
        Gfx.cbd(l + c1 / 2, i1, 24, 0);
        Gfx.DrawCenteredStr("Stats", l + c1 / 4, i1 + 16, 4, 0);
        Gfx.DrawCenteredStr("Quests", l + c1 / 4 + c1 / 2, i1 + 16, 4, 0);
        if (dii == 0) {
            int l1 = 72;
            int j2 = -1;

            Gfx.DrawStr("Skills", l + 5, l1, 3, 0xffff00);
            l1 += 13;
            for (int k2 = 0; k2 < 9; k2++) {
                int l2 = 0xffffff;

                if (super.MouseX > l + 3 && super.MouseY >= l1 - 11 && super.MouseY < l1 + 2 && super.MouseX < l + 90) {
                    l2 = 0xff0000;
                    j2 = k2;
                }
                Gfx.DrawStr(StatName[k2] + ":@yel@" + StatCurrentLevel[k2] + "/" + StatMaximumLevel[k2], l + 5, l1, 1,
                        l2);
                l2 = 0xffffff;
                if (super.MouseX >= l + 90 && super.MouseY >= l1 - 13 - 11 && super.MouseY < (l1 - 13) + 2
                        && super.MouseX < l + 196) {
                    l2 = 0xff0000;
                    j2 = k2 + 9;
                }
                Gfx.DrawStr(StatName[k2 + 9] + ":@yel@" + StatCurrentLevel[k2 + 9] + "/" + StatMaximumLevel[k2 + 9],
                        (l + c1 / 2) - 5, l1 - 13, 1, l2);
                l1 += 13;
            }
            Gfx.DrawStr("Quest Points:@yel@" + QuestPoints, (l + c1 / 2) - 5, l1 - 13, 1, 0xffffff);
            l1 += 12;
            Gfx.DrawStr("Fatigue: @yel@" + (FatigueVar * 100) / 750 + "%", l + 5, l1 - 13, 1, 0xffffff);
            l1 += 8;
            Gfx.DrawStr("Equipment Status", l + 5, l1, 3, 0xffff00);
            l1 += 12;
            for (int i3 = 0; i3 < 3; i3++) {
                Gfx.DrawStr(ArmourStats[i3] + ":@yel@" + ebb[i3], l + 5, l1, 1, 0xffffff);
                if (i3 < 2) {
                    Gfx.DrawStr(ArmourStats[i3 + 3] + ":@yel@" + ebb[i3 + 3], l + c1 / 2 + 25, l1, 1, 0xffffff);
                }
                l1 += 13;
            }
            l1 += 6;
            Gfx.cbc(l, l1 - 15, c1, 0);
            if (j2 != -1) {
                int j3 = getExpForNextLvl(j2);

                Gfx.DrawStr(StatName[j2] + " skill", l + 5, l1, 1, 0xffff00);
                l1 += 12;
                Gfx.DrawStr("Total xp: " + StatTotalExpVar[j2] / 4, l + 5, l1, 1, 0xffffff);
                l1 += 12;
                Gfx.DrawStr("Next level at: " + j3, l + 5, l1, 1, 0xffffff);
                l1 += 12;
                long Diff = j3 - (StatTotalExpVar[j2] / 4);

                Gfx.DrawStr("Difference: " + Diff, l + 5, l1, 1, 0xffffff);
                l1 += 12;
            } else {
                Gfx.DrawStr("Overall levels", l + 5, l1, 1, 0xffff00);
                l1 += 12;
                int SkillTotal = 0;
                long ExpTotal = 0;

                for (int i4 = 0; i4 < 18; i4++) {
                    SkillTotal += StatMaximumLevel[i4];
                    ExpTotal += StatTotalExpVar[i4] / 4;
                }
                Gfx.DrawStr("Skill total: " + SkillTotal, l + 5, l1, 1, 0xffffff);
                l1 += 12;
                Gfx.DrawStr("Total exp: " + ExpTotal, l + 5, l1, 1, 0xffffff);
                l1 += 12;
                Gfx.DrawStr("Combat level: " + My.Combat, l + 5, l1, 1, 0xffffff);
                l1 += 12;
            }
        }
        if (dii == 1) {
            dig.gfm(dih);
            dig.gga(dih, 0, "@whi@Quest-list (green=completed)");
            for (int i2 = 0; i2 < 50; i2++) {
                dig.gga(dih, i2 + 1, (QuestComplete[i2] ? "@gre@" : "@red@") + QuestName[i2]);
            }
            dig.ged();
        }
        if (!arg0) {
            return;
        }
        l = super.MouseX - (((j) (Gfx)).blg - 199);
        i1 = super.MouseY - 36;
        if (l >= 0 && i1 >= 0 && l < c1 && i1 < c2) {
            if (dii == 1) {
                dig.gea(l + (((j) (Gfx)).blg - 199), i1 + 36, super.fkh, super.MouseDownVar);
            }
            if (i1 <= 24 && MouseButtonDown == 1) {
                if (l < 98) {
                    dii = 0;
                    return;
                }
                if (l > 98) {
                    dii = 1;
                }
            }
        }
    }

    private final void DesignScreen() {
        dhi = new h(Gfx, 100);
        dhi.gfd(256, 10, "Please design Your Character", 4, true);
        int l = 140;
        int i1 = 34;

        l += 116;
        i1 -= 10;
        dhi.gfd(l - 55, i1 + 110, "Front", 3, true);
        dhi.gfd(l, i1 + 110, "Side", 3, true);
        dhi.gfd(l + 55, i1 + 110, "Back", 3, true);
        byte byte0 = 54;

        i1 += 145;
        dhi.gff(l - byte0, i1, 53, 41);
        dhi.gfd(l - byte0, i1 - 8, "Head", 1, true);
        dhi.gfd(l - byte0, i1 + 8, "Type", 1, true);
        dhi.gfg(l - byte0 - 40, i1, h.gdi + 7);
        eec = dhi.gfl(l - byte0 - 40, i1, 20, 20);
        dhi.gfg((l - byte0) + 40, i1, h.gdi + 6);
        eed = dhi.gfl((l - byte0) + 40, i1, 20, 20);
        dhi.gff(l + byte0, i1, 53, 41);
        dhi.gfd(l + byte0, i1 - 8, "Hair", 1, true);
        dhi.gfd(l + byte0, i1 + 8, "Color", 1, true);
        dhi.gfg((l + byte0) - 40, i1, h.gdi + 7);
        eee = dhi.gfl((l + byte0) - 40, i1, 20, 20);
        dhi.gfg(l + byte0 + 40, i1, h.gdi + 6);
        eef = dhi.gfl(l + byte0 + 40, i1, 20, 20);
        i1 += 50;
        dhi.gff(l - byte0, i1, 53, 41);
        dhi.gfd(l - byte0, i1, "Gender", 1, true);
        dhi.gfg(l - byte0 - 40, i1, h.gdi + 7);
        eeg = dhi.gfl(l - byte0 - 40, i1, 20, 20);
        dhi.gfg((l - byte0) + 40, i1, h.gdi + 6);
        eeh = dhi.gfl((l - byte0) + 40, i1, 20, 20);
        dhi.gff(l + byte0, i1, 53, 41);
        dhi.gfd(l + byte0, i1 - 8, "Top", 1, true);
        dhi.gfd(l + byte0, i1 + 8, "Color", 1, true);
        dhi.gfg((l + byte0) - 40, i1, h.gdi + 7);
        eei = dhi.gfl((l + byte0) - 40, i1, 20, 20);
        dhi.gfg(l + byte0 + 40, i1, h.gdi + 6);
        eej = dhi.gfl(l + byte0 + 40, i1, 20, 20);
        i1 += 50;
        dhi.gff(l - byte0, i1, 53, 41);
        dhi.gfd(l - byte0, i1 - 8, "Skin", 1, true);
        dhi.gfd(l - byte0, i1 + 8, "Color", 1, true);
        dhi.gfg(l - byte0 - 40, i1, h.gdi + 7);
        eek = dhi.gfl(l - byte0 - 40, i1, 20, 20);
        dhi.gfg((l - byte0) + 40, i1, h.gdi + 6);
        eel = dhi.gfl((l - byte0) + 40, i1, 20, 20);
        dhi.gff(l + byte0, i1, 53, 41);
        dhi.gfd(l + byte0, i1 - 8, "Bottom", 1, true);
        dhi.gfd(l + byte0, i1 + 8, "Color", 1, true);
        dhi.gfg((l + byte0) - 40, i1, h.gdi + 7);
        eem = dhi.gfl((l + byte0) - 40, i1, 20, 20);
        dhi.gfg(l + byte0 + 40, i1, h.gdi + 6);
        een = dhi.gfl(l + byte0 + 40, i1, 20, 20);
        i1 += 82;
        i1 -= 35;
        dhi.gfe(l, i1, 200, 30);
        dhi.gfd(l, i1, "Accept", 4, false);
        efa = dhi.gfl(l, i1, 200, 30);
    }

    private final void OptionsMenu(boolean arg0) {
        int l = ((j) (Gfx)).blg - 199;
        int i1 = 36;

        Gfx.DrawPicture(l - 49, 3, del + 6);
        char c1 = '\304';

        Gfx.cam(l, 36, c1, 280, j.ToHex(181, 181, 181), 160);
        int j1 = l + 3;
        int l1 = i1 + 15;

        Gfx.DrawCenteredStr(WelcomeMessage, j1 + (c1 / 2), l1, 1, 0);
        l1 += 15;
        if (isAlive()) {
            Gfx.DrawStr("IRC nick: " + getNick(), j1, l1, 1, 0xffffff);
            l1 += 15;
        }
        if (isAlive()) {
            Gfx.DrawStr("Silent IRC: " + (quietIRC ? "@gre@<on>" : "@red@<off>"), j1, l1, 1, 0xffffff);
            l1 += 15;
        }
        Gfx.DrawStr("Autologin: " + (AutoLogin ? "@gre@<on>" : "@red@<off>"), j1, l1, 1, 0xffffff);
        l1 += 15;
        Gfx.DrawStr("Hide Roofs: " + (!ShowRoof ? "@gre@<on>" : "@red@<off>"), j1, l1, 1, 0xffffff);
        l1 += 15;
        Gfx.DrawStr("Show Status menu: " + (ShowStuff ? "@gre@<on>" : "@red@<off>"), j1, l1, 1, 0xffffff);
        l1 += 15;
        Gfx.DrawStr("Debug mode: " + (Debug ? "@gre@<on>" : "@red@<off>"), j1, l1, 1, 0xffffff);
        l1 += 15;
        Gfx.DrawStr("Manual camera mode: " + (!efb ? "@gre@<on>" : "@red@<off>"), j1, l1, 1, 0xffffff);
        l1 += 15;
        Gfx.DrawStr("Dual mouse: " + (!dek ? "@gre@<on>" : "@red@<off>"), j1, l1, 1, 0xffffff);
        l1 += 15;
        Gfx.DrawStr("Sound effects: " + (!ejl ? "@gre@<on>" : "@red@<off>"), j1, l1, 1, 0xffffff);
        l1 += 15;
        Gfx.DrawStr("Block chat messages: " + (super.abb != 0 ? "@gre@<on>" : "@red@<off>"), l + 3, l1, 1, 0xffffff);
        l1 += 15;
        Gfx.DrawStr("Block private messages: " + (super.abc != 0 ? "@gre@<on>" : "@red@<off>"), l + 3, l1, 1, 0xffffff);
        l1 += 15;
        Gfx.DrawStr("Block trade requests: " + (super.abd != 0 ? "@gre@<on>" : "@red@<off>"), l + 3, l1, 1, 0xffffff);
        l1 += 15;
        Gfx.DrawStr("Block duel requests: " + (super.abe != 0 ? "@gre@<on>" : "@red@<off>"), l + 3, l1, 1, 0xffffff);
        l1 += 15;
        // Gap
        l1 += 15;
        int j2;

        if (isAlive()) {
            j2 = 0xffffff;
            if (super.MouseX > j1 && super.MouseX < j1 + c1 && super.MouseY > l1 - 12 && super.MouseY < l1 + 4) {
                j2 = 0xffff00;
            }
            Gfx.DrawCenteredStr("List my IRC channels", j1 + (c1 / 2), l1, 1, j2);
            l1 += 15;
        }
        if (!run) {
            j2 = 0xffffff;
            if (super.MouseX > j1 && super.MouseX < j1 + c1 && super.MouseY > l1 - 12 && super.MouseY < l1 + 4) {
                j2 = 0xffff00;
            }
            Gfx.DrawCenteredStr("Select built in script", j1 + (c1 / 2), l1, 1, j2);
            l1 += 15;
        }
        j2 = 0xffffff;
        if (super.MouseX > j1 && super.MouseX < j1 + c1 && super.MouseY > l1 - 12 && super.MouseY < l1 + 4) {
            j2 = 0xffff00;
        }
        Gfx.DrawCenteredStr("Click here to logout", j1 + (c1 / 2), l1, 1, j2);
        if (!arg0) {
            return;
        }
        l = super.MouseX - (((j) (Gfx)).blg - 199);
        i1 = super.MouseY - 36;
        if (l >= 0 && i1 >= 0 && l < 196 && i1 < 265) {
            int k2 = ((j) (Gfx)).blg - 199;
            byte byte0 = 36;
            char c2 = '\304';
            int k1 = k2 + 3;
            int i2 = byte0 + 30;

            if (isAlive()) {
                // ircNick
                i2 += 15;
            }
            if (isAlive()) {
                if (super.MouseX > k1 && super.MouseX < k1 + c2 && super.MouseY > i2 - 12 && super.MouseY < i2 + 4
                        && MouseButtonDown == 1) {
                    muteIRC(quietIRC);
                }
                i2 += 15;
            }
            if (super.MouseX > k1 && super.MouseX < k1 + c2 && super.MouseY > i2 - 12 && super.MouseY < i2 + 4
                    && MouseButtonDown == 1) {
                AutoLogin = !AutoLogin;
            }
            i2 += 15;
            if (super.MouseX > k1 && super.MouseX < k1 + c2 && super.MouseY > i2 - 12 && super.MouseY < i2 + 4
                    && MouseButtonDown == 1) {
                ShowRoof = !ShowRoof;
            }
            i2 += 15;
            if (super.MouseX > k1 && super.MouseX < k1 + c2 && super.MouseY > i2 - 12 && super.MouseY < i2 + 4
                    && MouseButtonDown == 1) {
                ShowStuff = !ShowStuff;
            }
            i2 += 15;
            if (super.MouseX > k1 && super.MouseX < k1 + c2 && super.MouseY > i2 - 12 && super.MouseY < i2 + 4
                    && MouseButtonDown == 1) {
                Debug = !Debug;
            }
            i2 += 15;
            if (super.MouseX > k1 && super.MouseX < k1 + c2 && super.MouseY > i2 - 12 && super.MouseY < i2 + 4
                    && MouseButtonDown == 1) {
                efb = !efb;
                super.Connection.SendID(60);
                super.Connection.SendVar(0);
                super.Connection.SendVar(efb ? 1 : 0);
                super.Connection.End();
            }
            i2 += 15;
            if (super.MouseX > k1 && super.MouseX < k1 + c2 && super.MouseY > i2 - 12 && super.MouseY < i2 + 4
                    && MouseButtonDown == 1) {
                dek = !dek;
                super.Connection.SendID(60);
                super.Connection.SendVar(2);
                super.Connection.SendVar(dek ? 1 : 0);
                super.Connection.End();
            }
            i2 += 15;
            if (super.MouseX > k1 && super.MouseX < k1 + c2 && super.MouseY > i2 - 12 && super.MouseY < i2 + 4
                    && MouseButtonDown == 1) {
                ejl = !ejl;
                super.Connection.SendID(60);
                super.Connection.SendVar(3);
                super.Connection.SendVar(ejl ? 1 : 0);
                super.Connection.End();
            }
            i2 += 15;
            boolean flag = false;

            if (super.MouseX > k1 && super.MouseX < k1 + c2 && super.MouseY > i2 - 12 && super.MouseY < i2 + 4
                    && MouseButtonDown == 1) {
                super.abb = 1 - super.abb;
                flag = true;
            }
            i2 += 15;
            if (super.MouseX > k1 && super.MouseX < k1 + c2 && super.MouseY > i2 - 12 && super.MouseY < i2 + 4
                    && MouseButtonDown == 1) {
                super.abc = 1 - super.abc;
                flag = true;
            }
            i2 += 15;
            if (super.MouseX > k1 && super.MouseX < k1 + c2 && super.MouseY > i2 - 12 && super.MouseY < i2 + 4
                    && MouseButtonDown == 1) {
                super.abd = 1 - super.abd;
                flag = true;
            }
            i2 += 15;
            if (super.MouseX > k1 && super.MouseX < k1 + c2 && super.MouseY > i2 - 12 && super.MouseY < i2 + 4
                    && MouseButtonDown == 1) {
                super.abe = 1 - super.abe;
                flag = true;
            }
            i2 += 15;
            // Gap
            i2 += 15;
            if (flag) {
                acg(super.abb, super.abc, super.abd, super.abe);
            }
            if (isAlive()) {
                if (super.MouseX > k1 && super.MouseX < k1 + c2 && super.MouseY > i2 - 12 && super.MouseY < i2 + 4
                        && MouseButtonDown == 1) {
                    showChannels();
                }
                i2 += 15;
            }
            if (!run) {
                if (super.MouseX > k1 && super.MouseX < k1 + c2 && super.MouseY > i2 - 12 && super.MouseY < i2 + 4
                        && MouseButtonDown == 1) {
                    SelectMacro();
                }
                i2 += 15;
            }
            if (super.MouseX > k1 && super.MouseX < k1 + c2 && super.MouseY > i2 - 12 && super.MouseY < i2 + 4
                    && MouseButtonDown == 1) {
                Logout();
            }
            MouseButtonDown = 0;
        }
    }

    protected final void ade() {
        dhf = 0;
        DisplayMessage("@cya@Sorry, you can't logout at the moment", 3);
    }

    private final void ShowTradeScreen2() {
        byte byte0 = 22;
        byte byte1 = 36;

        Gfx.DrawBox(byte0, byte1, 468, 16, 192);
        int l = 0x989898;

        Gfx.cam(byte0, byte1 + 16, 468, 246, l, 160);
        Gfx.DrawCenteredStr("Please confirm your trade with @yel@" + t.PlayerLongToName(ekf), byte0 + 234, byte1 + 12, 1,
                0xffffff);
        Gfx.DrawCenteredStr("You are about to give:", byte0 + 117, byte1 + 30, 1, 0xffff00);
        for (int i1 = 0; i1 < egh; i1++) {
            String s1 = Ident.ItemName[egi[i1]] + CheckId(egi[i1]);

            if (Ident.ItemStackableVar[egi[i1]] == 0) {
                s1 = s1 + " x " + FormatCurrency(egj[i1]);
            }
            Gfx.DrawCenteredStr(s1, byte0 + 117, byte1 + 42 + i1 * 12, 1, 0xffffff);
        }
        if (egh == 0) {
            Gfx.DrawCenteredStr("Nothing!", byte0 + 117, byte1 + 42, 1, 0xffffff);
        }
        Gfx.DrawCenteredStr("In return you will receive:", byte0 + 351, byte1 + 30, 1, 0xffff00);
        for (int j1 = 0; j1 < eje; j1++) {
            String s2 = Ident.ItemName[ejf[j1]] + CheckId(ejf[j1]);

            if (Ident.ItemStackableVar[ejf[j1]] == 0) {
                s2 = s2 + " x " + FormatCurrency(ejg[j1]);
            }
            Gfx.DrawCenteredStr(s2, byte0 + 351, byte1 + 42 + j1 * 12, 1, 0xffffff);
        }
        if (eje == 0) {
            Gfx.DrawCenteredStr("Nothing!", byte0 + 351, byte1 + 42, 1, 0xffffff);
        }
        Gfx.DrawCenteredStr("Are you sure you want to do this?", byte0 + 234, byte1 + 200, 4, 65535);
        Gfx.DrawCenteredStr("There is NO WAY to reverse a trade if you change your mind.", byte0 + 234, byte1 + 215, 1,
                0xffffff);
        Gfx.DrawCenteredStr("Remember that not all players are trustworthy", byte0 + 234, byte1 + 230, 1, 0xffffff);
        if (!MyTradeAccepted2) {
            Gfx.DrawPicture((byte0 + 118) - 35, byte1 + 238, del + 25);
            Gfx.DrawPicture((byte0 + 352) - 35, byte1 + 238, del + 26);
        } else {
            Gfx.DrawCenteredStr("Waiting for other player...", byte0 + 234, byte1 + 250, 1, 0xffff00);
        }
        if (MouseButtonDown == 1) {
            if (super.MouseX < byte0 || super.MouseY < byte1 || super.MouseX > byte0 + 468 || super.MouseY > byte1 + 262) {
                TradeScreen2 = false;
                super.Connection.SendID(42);
                super.Connection.End();
            }
            if (super.MouseX >= (byte0 + 118) - 35 && super.MouseX <= byte0 + 118 + 70 && super.MouseY >= byte1 + 238
                    && super.MouseY <= byte1 + 238 + 21) {
                MyTradeAccepted2 = true;
                super.Connection.SendID(44);
                super.Connection.End();
            }
            if (super.MouseX >= (byte0 + 352) - 35 && super.MouseX <= byte0 + 353 + 70 && super.MouseY >= byte1 + 238
                    && super.MouseY <= byte1 + 238 + 21) {
                TradeScreen2 = false;
                super.Connection.SendID(42);
                super.Connection.End();
            }
            MouseButtonDown = 0;
        }
    }

    public final String getParameter(String s1) {
        return super.getParameter(s1);
    }

    private final void MiniMap(boolean arg0) // MiniMap
    {
        int l = ((j) (Gfx)).blg - 199;
        char c1 = '\234';
        char c3 = '\230';

        Gfx.DrawPicture(l - 49, 3, del + 2);
        l += 40;
        Gfx.DrawBox(l, 36, c1, c3, 0);
        Gfx.cah(l, 36, l + c1, 36 + c3);
        int j1 = 192 + dff;
        int l1 = dke + dfe & 0xff;
        int j2 = ((My.XCoord - 6040) * 3 * j1) / 2048;
        int l3 = ((My.YCoord - 6040) * 3 * j1) / 2048;
        int j5 = n.bbk[1024 - l1 * 4 & 0x3ff];
        int l5 = n.bbk[(1024 - l1 * 4 & 0x3ff) + 1024];
        int j6 = l3 * j5 + j2 * l5 >> 18;

        l3 = l3 * l5 - j2 * j5 >> 18;
        j2 = j6;
        Gfx.ccn((l + c1 / 2) - j2, 36 + c3 / 2 + l3, del - 1, l1 + 64 & 0xff, j1);
        for (int l7 = 0; l7 < ObjectCount; l7++) // Objects
        {
            int k2 = (((ObjectX[l7] * ecj + 64) - My.XCoord) * 3 * j1) / 2048;
            int i4 = (((ObjectY[l7] * ecj + 64) - My.YCoord) * 3 * j1) / 2048;
            int k6 = i4 * j5 + k2 * l5 >> 18;

            i4 = i4 * l5 - k2 * j5 >> 18;
            k2 = k6;
            fch(l + c1 / 2 + k2, (36 + c3 / 2) - i4, 65535);
        }
        for (int i8 = 0; i8 < ItemCount; i8++) // Items
        {
            int l2 = (((ItemX[i8] * ecj + 64) - My.XCoord) * 3 * j1) / 2048;
            int j4 = (((ItemY[i8] * ecj + 64) - My.YCoord) * 3 * j1) / 2048;
            int l6 = j4 * j5 + l2 * l5 >> 18;

            j4 = j4 * l5 - l2 * j5 >> 18;
            l2 = l6;
            fch(l + c1 / 2 + l2, (36 + c3 / 2) - j4, 0xff0000);
        }
        for (int j8 = 0; j8 < NpcCount; j8++) // Npc's
        {
            NpcObject f1 = Npc[j8];
            int i3 = ((f1.XCoord - My.XCoord) * 3 * j1) / 2048;
            int k4 = ((f1.YCoord - My.YCoord) * 3 * j1) / 2048;
            int i7 = k4 * j5 + i3 * l5 >> 18;

            k4 = k4 * l5 - i3 * j5 >> 18;
            i3 = i7;
            fch(l + c1 / 2 + i3, (36 + c3 / 2) - k4, 0xffff00);
        }
        for (int k8 = 0; k8 < PlayerCount; k8++) // Players
        {
            NpcObject f2 = Player[k8];
            int j3 = ((f2.XCoord - My.XCoord) * 3 * j1) / 2048;
            int l4 = ((f2.YCoord - My.YCoord) * 3 * j1) / 2048;
            int j7 = l4 * j5 + j3 * l5 >> 18;

            l4 = l4 * l5 - j3 * j5 >> 18;
            j3 = j7;
            int i9 = 0xffffff;

            for (int j9 = 0; j9 < super.FriendCount; j9++) {
                if (f2.PlayerLong != super.FriendList[j9] || super.FriendServer[j9] != 255) {
                    continue;
                }
                i9 = 65280;
                break;
            }
            fch(l + c1 / 2 + j3, (36 + c3 / 2) - l4, i9);
        }
        Gfx.cal(l + c1 / 2, 36 + c3 / 2, 2, 0xffffff, 255);
        Gfx.ccn(l + 19, 55, del + 24, dke + 128 & 0xff, 128);
        Gfx.cah(0, 0, RsWidth, RsHeight + 12);
        if (!arg0) {
            return;
        }
        l = super.MouseX - (((j) (Gfx)).blg - 199);
        int l8 = super.MouseY - 36;

        if (l >= 40 && l8 >= 0 && l < 196 && l8 < 152) {
            char c2 = '\234';
            char c4 = '\230';
            int k1 = 192 + dff;
            int i2 = dke + dfe & 0xff;
            int i1 = ((j) (Gfx)).blg - 199;

            i1 += 40;
            int k3 = ((super.MouseX - (i1 + c2 / 2)) * 16384) / (3 * k1);
            int i5 = ((super.MouseY - (36 + c4 / 2)) * 16384) / (3 * k1);
            int k5 = n.bbk[1024 - i2 * 4 & 0x3ff];
            int i6 = n.bbk[(1024 - i2 * 4 & 0x3ff) + 1024];
            int k7 = i5 * k5 + k3 * i6 >> 15;

            i5 = i5 * i6 - k3 * k5 >> 15;
            k3 = k7;
            k3 += My.XCoord;
            i5 = My.YCoord - i5;
            if (MouseButtonDown == 1) {
                ena(LocalX, LocalY, k3 / 128, i5 / 128, false);
                Debug("WalkTo(" + ((k3 / 128) + TileX) + ", " + ((i5 / 128) + TileY) + ")");
            }
            MouseButtonDown = 0;
        }
    }

    private final void fbk() {
        if (MouseButtonDown != 0 && ddd == 0) {
            ddd = 1;
        }
        if (ddd > 0) {
            int l = super.MouseX - 22;
            int i1 = super.MouseY - 36;

            if (l >= 0 && i1 >= 0 && l < 468 && i1 < 262) {
                if (l > 216 && i1 > 30 && l < 462 && i1 < 235) {
                    int j1 = (l - 217) / 49 + ((i1 - 31) / 34) * 5;

                    if (j1 >= 0 && j1 < InvCount) {
                        boolean flag1 = false;
                        int k2 = 0;
                        int j3 = InvItemId[j1];

                        for (int j4 = 0; j4 < dkg; j4++) {
                            if (dkh[j4] == j3) {
                                if (Ident.ItemStackableVar[j3] == 0) {
                                    for (int l4 = 0; l4 < ddd; l4++) {
                                        if (dki[j4] < InvItemCount[j1]) {
                                            dki[j4]++;
                                        }
                                        flag1 = true;
                                    }
                                } else {
                                    k2++;
                                }
                            }
                        }
                        if (InvAmount(j3) <= k2) {
                            flag1 = true;
                        }
                        if (Ident.TradeableVar[j3] == 1) {
                            DisplayMessage("This object cannot be added to a duel offer", 3);
                            flag1 = true;
                        }
                        if (!flag1 && dkg < 8) {
                            dkh[dkg] = j3;
                            dki[dkg] = 1;
                            dkg++;
                            flag1 = true;
                        }
                        if (flag1) {
                            super.Connection.SendID(61);
                            super.Connection.SendVar(dkg);
                            for (int i5 = 0; i5 < dkg; i5++) {
                                super.Connection.SendInt(dkh[i5]);
                                super.Connection.SendDouble(dki[i5]);
                            }
                            super.Connection.End();
                            dgm = false;
                            dgn = false;
                        }
                    }
                }
                if (l > 8 && i1 > 30 && l < 205 && i1 < 129) {
                    int k1 = (l - 9) / 49 + ((i1 - 31) / 34) * 4;

                    if (k1 >= 0 && k1 < dkg) {
                        int i2 = dkh[k1];

                        for (int l2 = 0; l2 < ddd; l2++) {
                            if (Ident.ItemStackableVar[i2] == 0 && dki[k1] > 1) {
                                dki[k1]--;
                                continue;
                            }
                            dkg--;
                            ddc = 0;
                            for (int k3 = k1; k3 < dkg; k3++) {
                                dkh[k3] = dkh[k3 + 1];
                                dki[k3] = dki[k3 + 1];
                            }

                            break;
                        }
                        super.Connection.SendID(61);
                        super.Connection.SendVar(dkg);
                        for (int l3 = 0; l3 < dkg; l3++) {
                            super.Connection.SendInt(dkh[l3]);
                            super.Connection.SendDouble(dki[l3]);
                        }
                        super.Connection.End();
                        dgm = false;
                        dgn = false;
                    }
                }
                boolean flag = false;

                if (l >= 93 && i1 >= 221 && l <= 104 && i1 <= 232) {
                    dla = !dla;
                    flag = true;
                }
                if (l >= 93 && i1 >= 240 && l <= 104 && i1 <= 251) {
                    dlb = !dlb;
                    flag = true;
                }
                if (l >= 191 && i1 >= 221 && l <= 202 && i1 <= 232) {
                    dlc = !dlc;
                    flag = true;
                }
                if (l >= 191 && i1 >= 240 && l <= 202 && i1 <= 251) {
                    dld = !dld;
                    flag = true;
                }
                if (flag) {
                    super.Connection.SendID(62);
                    super.Connection.SendVar(dla ? 1 : 0);
                    super.Connection.SendVar(dlb ? 1 : 0);
                    super.Connection.SendVar(dlc ? 1 : 0);
                    super.Connection.SendVar(dld ? 1 : 0);
                    super.Connection.End();
                    dgm = false;
                    dgn = false;
                }
                if (l >= 217 && i1 >= 238 && l <= 286 && i1 <= 259) {
                    dgn = true;
                    super.Connection.SendID(63);
                    super.Connection.End();
                }
                if (l >= 394 && i1 >= 238 && l < 463 && i1 < 259) {
                    deh = false;
                    super.Connection.SendID(64);
                    super.Connection.End();
                }
            } else if (MouseButtonDown != 0) {
                deh = false;
                super.Connection.SendID(64);
                super.Connection.End();
            }
            MouseButtonDown = 0;
            ddd = 0;
        }
        if (!deh) {
            return;
        }
        byte byte0 = 22;
        byte byte1 = 36;

        Gfx.DrawBox(byte0, byte1, 468, 12, 0xc90b1d);
        int l1 = 0x989898;

        Gfx.cam(byte0, byte1 + 12, 468, 18, l1, 160);
        Gfx.cam(byte0, byte1 + 30, 8, 248, l1, 160);
        Gfx.cam(byte0 + 205, byte1 + 30, 11, 248, l1, 160);
        Gfx.cam(byte0 + 462, byte1 + 30, 6, 248, l1, 160);
        Gfx.cam(byte0 + 8, byte1 + 99, 197, 24, l1, 160);
        Gfx.cam(byte0 + 8, byte1 + 192, 197, 23, l1, 160);
        Gfx.cam(byte0 + 8, byte1 + 258, 197, 20, l1, 160);
        Gfx.cam(byte0 + 216, byte1 + 235, 246, 43, l1, 160);
        int j2 = 0xd0d0d0;

        Gfx.cam(byte0 + 8, byte1 + 30, 197, 69, j2, 160);
        Gfx.cam(byte0 + 8, byte1 + 123, 197, 69, j2, 160);
        Gfx.cam(byte0 + 8, byte1 + 215, 197, 43, j2, 160);
        Gfx.cam(byte0 + 216, byte1 + 30, 246, 205, j2, 160);
        for (int i3 = 0; i3 < 3; i3++) {
            Gfx.cbc(byte0 + 8, byte1 + 30 + i3 * 34, 197, 0);
        }
        for (int i4 = 0; i4 < 3; i4++) {
            Gfx.cbc(byte0 + 8, byte1 + 123 + i4 * 34, 197, 0);
        }
        for (int k4 = 0; k4 < 7; k4++) {
            Gfx.cbc(byte0 + 216, byte1 + 30 + k4 * 34, 246, 0);
        }
        for (int j5 = 0; j5 < 6; j5++) {
            if (j5 < 5) {
                Gfx.cbd(byte0 + 8 + j5 * 49, byte1 + 30, 69, 0);
            }
            if (j5 < 5) {
                Gfx.cbd(byte0 + 8 + j5 * 49, byte1 + 123, 69, 0);
            }
            Gfx.cbd(byte0 + 216 + j5 * 49, byte1 + 30, 205, 0);
        }
        Gfx.cbc(byte0 + 8, byte1 + 215, 197, 0);
        Gfx.cbc(byte0 + 8, byte1 + 257, 197, 0);
        Gfx.cbd(byte0 + 8, byte1 + 215, 43, 0);
        Gfx.cbd(byte0 + 204, byte1 + 215, 43, 0);
        Gfx.DrawStr("Preparing to duel with: " + ekg, byte0 + 1, byte1 + 10, 1, 0xffffff);
        Gfx.DrawStr("Your Stake", byte0 + 9, byte1 + 27, 4, 0xffffff);
        Gfx.DrawStr("Opponent's Stake", byte0 + 9, byte1 + 120, 4, 0xffffff);
        Gfx.DrawStr("Duel Options", byte0 + 9, byte1 + 212, 4, 0xffffff);
        Gfx.DrawStr("Your Inventory", byte0 + 216, byte1 + 27, 4, 0xffffff);
        Gfx.DrawStr("No retreating", byte0 + 8 + 1, byte1 + 215 + 16, 3, 0xffff00);
        Gfx.DrawStr("No magic", byte0 + 8 + 1, byte1 + 215 + 35, 3, 0xffff00);
        Gfx.DrawStr("No prayer", byte0 + 8 + 102, byte1 + 215 + 16, 3, 0xffff00);
        Gfx.DrawStr("No weapons", byte0 + 8 + 102, byte1 + 215 + 35, 3, 0xffff00);
        Gfx.DrawBorder(byte0 + 93, byte1 + 215 + 6, 11, 11, 0xffff00);
        if (dla) {
            Gfx.DrawBox(byte0 + 95, byte1 + 215 + 8, 7, 7, 0xffff00);
        }
        Gfx.DrawBorder(byte0 + 93, byte1 + 215 + 25, 11, 11, 0xffff00);
        if (dlb) {
            Gfx.DrawBox(byte0 + 95, byte1 + 215 + 27, 7, 7, 0xffff00);
        }
        Gfx.DrawBorder(byte0 + 191, byte1 + 215 + 6, 11, 11, 0xffff00);
        if (dlc) {
            Gfx.DrawBox(byte0 + 193, byte1 + 215 + 8, 7, 7, 0xffff00);
        }
        Gfx.DrawBorder(byte0 + 191, byte1 + 215 + 25, 11, 11, 0xffff00);
        if (dld) {
            Gfx.DrawBox(byte0 + 193, byte1 + 215 + 27, 7, 7, 0xffff00);
        }
        if (!dgn) {
            Gfx.DrawPicture(byte0 + 217, byte1 + 238, del + 25);
        }
        Gfx.DrawPicture(byte0 + 394, byte1 + 238, del + 26);
        if (dgm) {
            Gfx.DrawCenteredStr("Other player", byte0 + 341, byte1 + 246, 1, 0xffffff);
            Gfx.DrawCenteredStr("has accepted", byte0 + 341, byte1 + 256, 1, 0xffffff);
        }
        if (dgn) {
            Gfx.DrawCenteredStr("Waiting for", byte0 + 217 + 35, byte1 + 246, 1, 0xffffff);
            Gfx.DrawCenteredStr("other player", byte0 + 217 + 35, byte1 + 256, 1, 0xffffff);
        }
        for (int k5 = 0; k5 < InvCount; k5++) {
            int l5 = 217 + byte0 + (k5 % 5) * 49;
            int j6 = 31 + byte1 + (k5 / 5) * 34;

            Gfx.cdd(l5, j6, 48, 32, den + Ident.PictureOffset[InvItemId[k5]], Ident.ajk[InvItemId[k5]], 0, 0, false);
            if (Ident.ItemStackableVar[InvItemId[k5]] == 0) {
                Gfx.DrawStr(String.valueOf(InvItemCount[k5]), l5 + 1, j6 + 10, 1, 0xffff00);
            }
        }
        for (int i6 = 0; i6 < dkg; i6++) {
            int k6 = 9 + byte0 + (i6 % 4) * 49;
            int i7 = 31 + byte1 + (i6 / 4) * 34;

            Gfx.cdd(k6, i7, 48, 32, den + Ident.PictureOffset[dkh[i6]], Ident.ajk[dkh[i6]], 0, 0, false);
            if (Ident.ItemStackableVar[dkh[i6]] == 0) {
                Gfx.DrawStr(String.valueOf(dki[i6]), k6 + 1, i7 + 10, 1, 0xffff00);
            }
            if (super.MouseX > k6 && super.MouseX < k6 + 48 && super.MouseY > i7 && super.MouseY < i7 + 32) {
                Gfx.DrawStr(Ident.ItemName[dkh[i6]] + CheckId(dkh[i6]) + ": @whi@" + Ident.ItemDescription[dkh[i6]],
                        byte0 + 8, byte1 + 273, 1, 0xffff00);
            }
        }
        for (int l6 = 0; l6 < edl; l6++) {
            int j7 = 9 + byte0 + (l6 % 4) * 49;
            int k7 = 124 + byte1 + (l6 / 4) * 34;

            Gfx.cdd(j7, k7, 48, 32, den + Ident.PictureOffset[edm[l6]], Ident.ajk[edm[l6]], 0, 0, false);
            if (Ident.ItemStackableVar[edm[l6]] == 0) {
                Gfx.DrawStr(String.valueOf(edn[l6]), j7 + 1, k7 + 10, 1, 0xffff00);
            }
            if (super.MouseX > j7 && super.MouseX < j7 + 48 && super.MouseY > k7 && super.MouseY < k7 + 32) {
                Gfx.DrawStr(Ident.ItemName[edm[l6]] + CheckId(edm[l6]) + ": @whi@" + Ident.ItemDescription[edm[l6]],
                        byte0 + 8, byte1 + 273, 1, 0xffff00);
            }
        }
    }

    private final void fbm() {
        if ((ema & 1) == 1 && fab(ema)) {
            return;
        }
        if ((ema & 1) == 0 && fab(ema)) {
            if (fab(ema + 1 & 7)) {
                ema = ema + 1 & 7;
                return;
            }
            if (fab(ema + 7 & 7)) {
                ema = ema + 7 & 7;
            }
            return;
        }
        int ai[] = { 1, -1, 2, -2, 3, -3, 4};

        for (int l = 0; l < 7; l++) {
            if (!fab(ema + ai[l] + 8 & 7)) {
                continue;
            }
            ema = ema + ai[l] + 8 & 7;
            break;
        }
        if ((ema & 1) == 0 && fab(ema)) {
            if (fab(ema + 1 & 7)) {
                ema = ema + 1 & 7;
                return;
            }
            if (fab(ema + 7 & 7)) {
                ema = ema + 7 & 7;
            }
            return;
        } else {
            return;
        }
    }

    private final void ClearLogin() {
        LoggedInVar = 0;
        ehl = 0;
        PlayerCount = 0;
        NpcCount = 0;
    }

    protected final void add() {
        edh = 0;
        ehl = 0;
        LoggedInVar = 0;
        dhf = 0;
    }

    final void fca(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
        NpcObject f1 = Npc[arg4];
        int l = f1.Dir + (dke + 16) / 32 & 7;
        boolean flag = false;
        int i1 = l;

        if (i1 == 5) {
            i1 = 3;
            flag = true;
        } else if (i1 == 6) {
            i1 = 2;
            flag = true;
        } else if (i1 == 7) {
            i1 = 1;
            flag = true;
        }
        int j1 = i1 * 3 + efl[(f1.gmk / Ident.akk[f1.Id]) % 4];

        if (f1.Dir == 8) {
            i1 = 5;
            l = 2;
            flag = false;
            arg0 -= (Ident.akm[f1.Id] * arg6) / 100;
            j1 = i1 * 3 + dei[(dji / (Ident.akl[f1.Id] - 1)) % 8];
        } else if (f1.Dir == 9) {
            i1 = 5;
            l = 2;
            flag = true;
            arg0 += (Ident.akm[f1.Id] * arg6) / 100;
            j1 = i1 * 3 + ded[(dji / Ident.akl[f1.Id]) % 8];
        }
        for (int k1 = 0; k1 < 12; k1++) {
            int l1 = ddh[l][k1];
            int k2 = Ident.aig[f1.Id][l1];

            if (k2 >= 0) {
                int i3 = 0;
                int j3 = 0;
                int k3 = j1;

                if (flag && i1 >= 1 && i1 <= 3 && Ident.anc[k2] == 1) {
                    k3 += 15;
                }
                if (i1 != 5 || Ident.anb[k2] == 1) {
                    int l3 = k3 + Ident.and[k2];

                    i3 = (i3 * arg2) / ((j) (Gfx)).bmj[l3];
                    j3 = (j3 * arg3) / ((j) (Gfx)).bmk[l3];
                    int i4 = (arg2 * ((j) (Gfx)).bmj[l3]) / ((j) (Gfx)).bmj[Ident.and[k2]];

                    i3 -= (i4 - arg2) / 2;
                    int j4 = Ident.amn[k2];
                    int k4 = 0;

                    if (j4 == 1) {
                        j4 = Ident.ain[f1.Id];
                        k4 = Ident.ajc[f1.Id];
                    } else if (j4 == 2) {
                        j4 = Ident.aja[f1.Id];
                        k4 = Ident.ajc[f1.Id];
                    } else if (j4 == 3) {
                        j4 = Ident.ajb[f1.Id];
                        k4 = Ident.ajc[f1.Id];
                    }
                    Gfx.cdd(arg0 + i3, arg1 + j3, i4, arg3, l3, j4, k4, arg5, flag);
                }
            }
        }

        if (f1.TalkVar > 0) {
            ebg[efd] = Gfx.cef(f1.Message, 1) / 2;
            if (ebg[efd] > 150) {
                ebg[efd] = 150;
            }
            ebh[efd] = (Gfx.cef(f1.Message, 1) / 300) * Gfx.ced(1);
            ebe[efd] = arg0 + arg2 / 2;
            ebf[efd] = arg1;
            efe[efd++] = f1.Message;
        }
        if (f1.Dir == 8 || f1.Dir == 9 || f1.CombatVar != 0) {
            if (f1.CombatVar > 0) {
                int i2 = arg0;

                if (f1.Dir == 8) {
                    i2 -= (20 * arg6) / 100;
                } else if (f1.Dir == 9) {
                    i2 += (20 * arg6) / 100;
                }
                int l2 = (f1.CurrentHits * 30) / f1.MaxHits;

                dfg[egl] = i2 + arg2 / 2;
                dfh[egl] = arg1;
                dfi[egl++] = l2;
            }
            if (f1.CombatVar > 150) {
                int j2 = arg0;

                if (f1.Dir == 8) {
                    j2 -= (10 * arg6) / 100;
                } else if (f1.Dir == 9) {
                    j2 += (10 * arg6) / 100;
                }
                Gfx.DrawPicture((j2 + arg2 / 2) - 12, (arg1 + arg3 / 2) - 12, del + 12);
                Gfx.DrawCenteredStr(String.valueOf(f1.LastHit), (j2 + arg2 / 2) - 1, arg1 + arg3 / 2 + 5, 3, 0xffffff);
            }
        }
    }

    private final void FriendMenu(boolean arg0) {
        int l = ((j) (Gfx)).blg - 199;
        int i1 = 36;

        Gfx.DrawPicture(l - 49, 3, del + 5);
        char c1 = '\304';
        char c2 = '\266';
        int k1;
        int j1 = k1 = j.ToHex(160, 160, 160);

        if (ekb == 0) {
            j1 = j.ToHex(220, 220, 220);
        } else {
            k1 = j.ToHex(220, 220, 220);
        }
        Gfx.cam(l, i1, c1 / 2, 24, j1, 128);
        Gfx.cam(l + c1 / 2, i1, c1 / 2, 24, k1, 128);
        Gfx.cam(l, i1 + 24, c1, c2 - 24, j.ToHex(220, 220, 220), 128);
        Gfx.cbc(l, i1 + 24, c1, 0);
        Gfx.cbd(l + c1 / 2, i1, 24, 0);
        Gfx.cbc(l, (i1 + c2) - 16, c1, 0);
        Gfx.DrawCenteredStr("Friends", l + c1 / 4, i1 + 16, 4, 0);
        Gfx.DrawCenteredStr("Ignore", l + c1 / 4 + c1 / 2, i1 + 16, 4, 0);
        ejn.gfm(eka);
        if (ekb == 0) {
            for (int l1 = 0; l1 < super.FriendCount; l1++) {
                String s1;

                if (super.FriendServer[l1] == 255) {
                    s1 = "@gre@";
                } else if (super.FriendServer[l1] > 0) {
                    s1 = "@yel@";
                } else {
                    s1 = "@red@";
                }
                ejn.gga(eka, l1, s1 + t.PlayerLongToName(super.FriendList[l1]) + "~439~@whi@Remove         WWWWWWWWWW");
            }
        }
        if (ekb == 1) {
            for (int i2 = 0; i2 < super.IgnoreCount; i2++) {
                ejn.gga(eka, i2,
                        "@yel@" + t.PlayerLongToName(super.IgnoreList[i2]) + "~439~@whi@Remove         WWWWWWWWWW");
            }
        }
        ejn.ged();
        if (ekb == 0) {
            int j2 = ejn.ggh(eka);

            if (j2 >= 0 && super.MouseX < 489) {
                if (super.MouseX > 429) {
                    Gfx.DrawCenteredStr("Click to remove " + t.PlayerLongToName(super.FriendList[j2]), l + c1 / 2,
                            i1 + 35, 1, 0xffffff);
                } else if (super.FriendServer[j2] == 255) {
                    Gfx.DrawCenteredStr("Click to message " + t.PlayerLongToName(super.FriendList[j2]), l + c1 / 2,
                            i1 + 35, 1, 0xffffff);
                } else if (super.FriendServer[j2] > 0) {
                    if (super.FriendServer[j2] < 200) {
                        Gfx.DrawCenteredStr(
                                t.PlayerLongToName(super.FriendList[j2]) + " is on world "
                                + (super.FriendServer[j2] - 9),
                                l + c1 / 2,
                                i1 + 35,
                                1,
                                0xffffff);
                    } else {
                        Gfx.DrawCenteredStr(
                                t.PlayerLongToName(super.FriendList[j2]) + " is on classic "
                                + (super.FriendServer[j2] - 219),
                                l + c1 / 2,
                                i1 + 35,
                                1,
                                0xffffff);
                    }
                } else {
                    Gfx.DrawCenteredStr(t.PlayerLongToName(super.FriendList[j2]) + " is offline", l + c1 / 2, i1 + 35, 1,
                            0xffffff);
                }
            } else {
                Gfx.DrawCenteredStr("Click a name to send a message", l + c1 / 2, i1 + 35, 1, 0xffffff);
            }
            int j3;

            if (super.MouseX > l && super.MouseX < l + c1 && super.MouseY > (i1 + c2) - 16 && super.MouseY < i1 + c2) {
                j3 = 0xffff00;
            } else {
                j3 = 0xffffff;
            }
            Gfx.DrawCenteredStr("Click here to add a friend", l + c1 / 2, (i1 + c2) - 3, 1, j3);
        }
        if (ekb == 1) {
            int k2 = ejn.ggh(eka);

            if (k2 >= 0 && super.MouseX < 489 && super.MouseX > 429) {
                if (super.MouseX > 429) {
                    Gfx.DrawCenteredStr("Click to remove " + t.PlayerLongToName(super.IgnoreList[k2]), l + c1 / 2,
                            i1 + 35, 1, 0xffffff);
                }
            } else {
                Gfx.DrawCenteredStr("Blocking messages from:", l + c1 / 2, i1 + 35, 1, 0xffffff);
            }
            int k3;

            if (super.MouseX > l && super.MouseX < l + c1 && super.MouseY > (i1 + c2) - 16 && super.MouseY < i1 + c2) {
                k3 = 0xffff00;
            } else {
                k3 = 0xffffff;
            }
            Gfx.DrawCenteredStr("Click here to add a name", l + c1 / 2, (i1 + c2) - 3, 1, k3);
        }
        if (!arg0) {
            return;
        }
        l = super.MouseX - (((j) (Gfx)).blg - 199);
        i1 = super.MouseY - 36;
        if (l >= 0 && i1 >= 0 && l < 196 && i1 < 182) {
            ejn.gea(l + (((j) (Gfx)).blg - 199), i1 + 36, super.fkh, super.MouseDownVar);
            if (i1 <= 24 && MouseButtonDown == 1) {
                if (l < 98 && ekb == 1) {
                    ekb = 0;
                    ejn.gfn(eka);
                } else if (l > 98 && ekb == 0) {
                    ekb = 1;
                    ejn.gfn(eka);
                }
            }
            if (MouseButtonDown == 1 && ekb == 0) {
                int l2 = ejn.ggh(eka);

                if (l2 >= 0 && super.MouseX < 489) {
                    if (super.MouseX > 429) {
                        RemoveFriend(super.FriendList[l2]);
                    } else if (super.FriendServer[l2] != 0) {
                        efm = 2;
                        SelectedFriend = super.FriendList[l2];
                        super.fkn = "";
                        super.fla = "";
                    }
                }
            }
            if (MouseButtonDown == 1 && ekb == 1) {
                int i3 = ejn.ggh(eka);

                if (i3 >= 0 && super.MouseX < 489 && super.MouseX > 429) {
                    RemoveIgnore(super.IgnoreList[i3]);
                }
            }
            if (i1 > 166 && MouseButtonDown == 1 && ekb == 0) {
                efm = 1;
                super.fkl = "";
                super.fkm = "";
            }
            if (i1 > 166 && MouseButtonDown == 1 && ekb == 1) {
                efm = 3;
                super.fkl = "";
                super.fkm = "";
            }
            MouseButtonDown = 0;
        }
    }

    private final void DoLogin() {
        if (super.abi > 0) {
            super.abi--;
        }
        if (AutoLogin || Hopping) {
            if (Valid) {
                loginRS(Username, Password, false);
            } else {
                dkf.ggc(LoginPromptVar, "Your auth is not valid, check command prompt.");
                System.exit(1);
            }
            return;
        }
        if (ehl == 0) {
            ehm.gea(super.MouseX, super.MouseY, super.fkh, super.MouseDownVar);
            if (ehm.geb(dnn)) {
                ehl = 1;
            }
            if (ehm.geb(eaa)) {
                ehl = 2;
                dkf.ggc(LoginPromptVar, "Please enter your username and password");
                dkf.ggc(ServerVar, Server);
                dkf.ggc(UsernameVar, Username);
                dkf.ggc(PasswordVar, Password);
                dkf.ggg(UsernameVar);
                return;
            }
        } else if (ehl == 1) {
            dmc.gea(super.MouseX, super.MouseY, super.fkh, super.MouseDownVar);
            if (dmc.geb(ejj)) {
                ehl = 0;
                return;
            }
        } else if (ehl == 2) {
            dkf.gea(super.MouseX, super.MouseY, super.fkh, super.MouseDownVar);
            if (dkf.geb(elf)) {
                ehl = 0;
            }
            if (dkf.geb(UsernameVar)) {
                dkf.ggg(PasswordVar);
            }
            if (dkf.geb(PasswordVar)) {
                dkf.ggg(ServerVar);
            }
            if (dkf.geb(ServerVar) || dkf.geb(ele)) {
                Username = dkf.ggd(UsernameVar);
                Password = dkf.ggd(PasswordVar);
                Server = dkf.ggd(ServerVar);
                if (Valid) {
                    int wr;

                    try {
                        wr = Integer.parseInt(Server);
                    } catch (Exception e) {
                        ShowCmd("Server number must be numeric!");
                        dkf.ggc(LoginPromptVar, "Server number must be numeric!");
                        return;
                    }
                    if (ChangeWorld(wr)) {
                        loginRS(Username, Password, false);
                    } else {
                        ShowCmd("Invalid Server number");
                        dkf.ggc(LoginPromptVar, "Invalid Server number");
                    }
                } else {
                    dkf.ggc(LoginPromptVar, "Your auth is not valid, check command prompt.");
                }
            }
        }
    }

    private final void fcd(int l, int i1, int j1) {
        if (j1 == 0) {
            fde(LocalX, LocalY, l, i1 - 1, l, i1, false, true);
        } else if (j1 == 1) {
            fde(LocalX, LocalY, l - 1, i1, l, i1, false, true);
        } else {
            fde(LocalX, LocalY, l, i1, l, i1, true, true);
        }
    }

    public final int InvAmount(int id) {
        int l = 0;

        for (int i1 = 0; i1 < InvCount; i1++) {
            if (InvItemId[i1] == id) {
                if (Ident.ItemStackableVar[id] == 1) {
                    l++;
                } else {
                    l += InvItemCount[i1];
                }
            }
        }
        return l;
    }

    protected final void fcf(int arg0, int arg1, int arg2) {
        dme[dmd] = arg1;
        dmf[dmd] = arg2;
        dmd = dmd + 1 & 0x1fff;
        for (int l = 10; l < 4000; l++) {
            int i1 = dmd - l & 0x1fff;

            if (dme[i1] == arg1 && dmf[i1] == arg2) {
                boolean flag = false;

                for (int j1 = 1; j1 < l; j1++) {
                    int k1 = dmd - j1 & 0x1fff;
                    int l1 = i1 - j1 & 0x1fff;

                    if (dme[l1] != arg1 || dmf[l1] != arg2) {
                        flag = true;
                    }
                    if (dme[k1] != dme[l1] || dmf[k1] != dmf[l1]) {
                        break;
                    }
                    if (j1 == l - 1 && flag && eda == 0 && dhf == 0) {
                        Logout();
                        return;
                    }
                }
            }
        }

    }

    protected final void NewThread(Runnable runnable) {
        Thread thread = new Thread(runnable);

        thread.setDaemon(true);
        thread.start();
    }

    private final void fch(int l, int i1, int j1) {
        Gfx.cbe(l, i1, j1);
        Gfx.cbe(l - 1, i1, j1);
        Gfx.cbe(l + 1, i1, j1);
        Gfx.cbe(l, i1 - 1, j1);
        Gfx.cbe(l, i1 + 1, j1);
    }

    protected final int adi() {
        return (int) (Math.random() * 99999999D);
    }

    protected final void DrawRs() {
        if (Sleeping) {
            if (!sentword && System.currentTimeMillis() - LChecked > 2000) {
                String nword = ReadLine(SLfile);

                LChecked = System.currentTimeMillis();
                if (((SleepFatigueVar * 100) / 750) == 0 && mod < SLfile.lastModified() && !oword.equals(nword)) {
                    try {
                        System.out.println("Sleeping: " + nword);
                        super.Connection.SendID(59);
                        super.Connection.SendString(nword);
                        super.Connection.End();
                        sentword = true;
                        super.fkl = super.fkm = "";
                        SleepMessage = "Please wait...";
                    } catch (Exception e) {
                        ShowCmd("Error sending sleepword");
                    }
                }
            }
        }
        if (Locked != -1 && (FightMode != Locked || System.currentTimeMillis() - FMillis > 5000)) {
            FMillis = System.currentTimeMillis();
            SetMode(Locked);
        }
        if (LoadingError) {
            Graphics g1 = getGraphics();

            g1.setColor(Color.black);
            g1.fillRect(0, 0, 512, 356);
            g1.setFont(new Font("Helvetica", 1, 16));
            g1.setColor(Color.yellow);
            int l = 35;

            g1.drawString("Sorry, an error has occured whilst loading RuneScape", 30, l);
            l += 50;
            g1.setColor(Color.white);
            g1.drawString("To fix this try the following (in order):", 30, l);
            l += 50;
            g1.setColor(Color.white);
            g1.setFont(new Font("Helvetica", 1, 12));
            g1.drawString("1: Try closing ALL open web-browser windows, and reloading", 30, l);
            l += 30;
            g1.drawString("2: Try clearing your web-browsers cache from tools->internet options", 30, l);
            l += 30;
            g1.drawString("3: Try using a different game-world", 30, l);
            l += 30;
            g1.drawString("4: Try rebooting your computer", 30, l);
            l += 30;
            g1.drawString("5: Try selecting a different version of Java from the play-game menu", 30, l);
            fle(1);
            return;
        }
        if (MemoryError) {
            Graphics g3 = getGraphics();

            g3.setColor(Color.black);
            g3.fillRect(0, 0, 512, 356);
            g3.setFont(new Font("Helvetica", 1, 20));
            g3.setColor(Color.white);
            g3.drawString("Error - out of memory!", 50, 50);
            g3.drawString("Close ALL unnecessary programs", 50, 100);
            g3.drawString("and windows before loading the game", 50, 150);
            g3.drawString("RuneScape needs about 48meg of spare RAM", 50, 200);
            fle(1);
            return;
        }
        try {
            if (LoggedInVar == 0) {
                Gfx.bnf = false;
                emj();
            }
            if (LoggedInVar == 1 && ShowGfx) {
                Gfx.bnf = true;
                UpdateGfx();
            }
        } catch (OutOfMemoryError _ex) {
            fdd();
            MemoryError = true;
        }
    }

    private final boolean IsWearing(int arg0) {
        for (int l = 0; l < InvCount; l++) {
            if (InvItemId[l] == arg0 && WearingVar[l] == 1) {
                return true;
            }
        }
        return false;
    }

    protected final void Reconnect() {
        edh = 0;
        if (dhf != 0) {
            add();
        } else {
            super.Reconnect();
        }
    }

    private final void LoadConfig() {
        byte abyte0[] = LoadDataFile(4, "Configuration", 10);

        if (abyte0 == null) {
            LoadingError = true;
            return;
        }
        Ident.baa(abyte0, true);
        byte abyte1[] = LoadDataFile(1, "Chat system", 15);

        if (abyte1 == null) {
            LoadingError = true;
        } else {
            byte abyte2[] = t.Extract("fragmentsenc.txt", 0, abyte1);
            byte abyte3[] = t.Extract("badenc.txt", 0, abyte1);
            byte abyte4[] = t.Extract("hostenc.txt", 0, abyte1);
            byte abyte5[] = t.Extract("tldlist.txt", 0, abyte1);

            u.ffl(new q(abyte2), new q(abyte3), new q(abyte4), new q(abyte5));
        }
    }

    final void fcl(int l, int i1, int j1, int k1, int l1, int i2, int j2) // drawing pictures
    {
        int k2 = Ident.PictureOffset[l1] + den;
        int l2 = Ident.ajk[l1];

        Gfx.cdd(l, i1, j1, k1, k2, l2, 0, 0, false);
    }

    private final void ShowFooter() {
        int l = j.ToHex(200, 200, 255);

        if (ell == 0) {
            l = j.ToHex(255, 200, 50);
        }
        if (ehc % 30 > 15) {
            l = j.ToHex(255, 50, 50);
        }
        Gfx.DrawCenteredStr("All messages", 50, RsHeight + 6, 0, l);
        l = j.ToHex(200, 200, 255);
        if (ell == 1) {
            l = j.ToHex(255, 200, 50);
        }
        if (ehd % 30 > 15) {
            l = j.ToHex(255, 50, 50);
        }
        Gfx.DrawCenteredStr("Chat history", 150, RsHeight + 6, 0, l);
        l = j.ToHex(200, 200, 255);
        if (ell == 2) {
            l = j.ToHex(255, 200, 50);
        }
        if (ehe % 30 > 15) {
            l = j.ToHex(255, 50, 50);
        }
        Gfx.DrawCenteredStr("Quest history", 250, RsHeight + 6, 0, l);
        l = j.ToHex(200, 200, 255);
        if (ell == 3) {
            l = j.ToHex(255, 200, 50);
        }
        if (ehf % 30 > 15) {
            l = j.ToHex(255, 50, 50);
        }
        Gfx.DrawCenteredStr("Private history", 350, RsHeight + 6, 0, l);
        l = j.ToHex(200, 200, 255);
        if (ell == 4) {
            l = j.ToHex(255, 200, 50);
        }
        if (!quietIRC && tabFlash % 30 > 15) {
            l = j.ToHex(255, 50, 50);
        }
        Gfx.DrawCenteredStr(currentChannel(), 450, RsHeight + 6, 0, l);
    }

    private final void fcn() {
        dhi.gea(super.MouseX, super.MouseY, super.fkh, super.MouseDownVar);
        if (dhi.geb(eec)) {
            do {
                dhl = ((dhl - 1) + Ident.ake) % Ident.ake;
            }
            while ((Ident.ana[dhl] & 3) != 1 || (Ident.ana[dhl] & 4 * die) == 0);
        }
        if (dhi.geb(eed)) {
            do {
                dhl = (dhl + 1) % Ident.ake;
            }
            while ((Ident.ana[dhl] & 3) != 1 || (Ident.ana[dhl] & 4 * die) == 0);
        }
        if (dhi.geb(eee)) {
            dia = ((dia - 1) + dlj.length) % dlj.length;
        }
        if (dhi.geb(eef)) {
            dia = (dia + 1) % dlj.length;
        }
        if (dhi.geb(eeg) || dhi.geb(eeh)) {
            for (die = 3 - die; (Ident.ana[dhl] & 3) != 1 || (Ident.ana[dhl] & 4 * die) == 0; dhl = (dhl + 1)
                    % Ident.ake) {
                ;
            }
            for (; (Ident.ana[dhm] & 3) != 2 || (Ident.ana[dhm] & 4 * die) == 0; dhm = (dhm + 1) % Ident.ake) {
                ;
            }
        }
        if (dhi.geb(eei)) {
            dib = ((dib - 1) + deg.length) % deg.length;
        }
        if (dhi.geb(eej)) {
            dib = (dib + 1) % deg.length;
        }
        if (dhi.geb(eek)) {
            did = ((did - 1) + ekd.length) % ekd.length;
        }
        if (dhi.geb(eel)) {
            did = (did + 1) % ekd.length;
        }
        if (dhi.geb(eem)) {
            dic = ((dic - 1) + deg.length) % deg.length;
        }
        if (dhi.geb(een)) {
            dic = (dic + 1) % deg.length;
        }
        if (dhi.geb(efa)) {
            super.Connection.SendID(65);
            super.Connection.SendVar(die);
            super.Connection.SendVar(dhl);
            super.Connection.SendVar(dhm);
            super.Connection.SendVar(dhn);
            super.Connection.SendVar(dia);
            super.Connection.SendVar(dib);
            super.Connection.SendVar(dic);
            super.Connection.SendVar(did);
            super.Connection.End();
            Gfx.cak();
            efc = false;
        }
    }

    private final void DuelScreen2() {
        byte byte0 = 22;
        byte byte1 = 36;

        Gfx.DrawBox(byte0, byte1, 468, 16, 192);
        int l = 0x989898;

        Gfx.cam(byte0, byte1 + 16, 468, 246, l, 160);
        Gfx.DrawCenteredStr("Please confirm your duel with @yel@" + t.PlayerLongToName(eme), byte0 + 234, byte1 + 12, 1,
                0xffffff);
        Gfx.DrawCenteredStr("Your stake:", byte0 + 117, byte1 + 30, 1, 0xffff00);
        for (int i1 = 0; i1 < MyStakeCount; i1++) {
            String s1 = Ident.ItemName[MyStakeId[i1]] + CheckId(MyStakeId[i1]);

            if (Ident.ItemStackableVar[MyStakeId[i1]] == 0) {
                s1 = s1 + " x " + FormatCurrency(MyStakeAmount[i1]);
            }
            Gfx.DrawCenteredStr(s1, byte0 + 117, byte1 + 42 + i1 * 12, 1, 0xffffff);
        }
        if (MyStakeCount == 0) {
            Gfx.DrawCenteredStr("Nothing!", byte0 + 117, byte1 + 42, 1, 0xffffff);
        }
        Gfx.DrawCenteredStr("Your opponent's stake:", byte0 + 351, byte1 + 30, 1, 0xffff00);
        for (int j1 = 0; j1 < OpponentsStakeCount; j1++) {
            String s2 = Ident.ItemName[OpponentsStakeId[j1]] + CheckId(OpponentsStakeId[j1]);

            if (Ident.ItemStackableVar[OpponentsStakeId[j1]] == 0) {
                s2 = s2 + " x " + FormatCurrency(OpponentsStakeAmount[j1]);
            }
            Gfx.DrawCenteredStr(s2, byte0 + 351, byte1 + 42 + j1 * 12, 1, 0xffffff);
        }
        if (OpponentsStakeCount == 0) {
            Gfx.DrawCenteredStr("Nothing!", byte0 + 351, byte1 + 42, 1, 0xffffff);
        }
        if (StakeRetreatVar == 0) {
            Gfx.DrawCenteredStr("You can retreat from this duel", byte0 + 234, byte1 + 180, 1, 65280);
        } else {
            Gfx.DrawCenteredStr("No retreat is possible!", byte0 + 234, byte1 + 180, 1, 0xff0000);
        }
        if (StakeMagicVar == 0) {
            Gfx.DrawCenteredStr("Magic may be used", byte0 + 234, byte1 + 192, 1, 65280);
        } else {
            Gfx.DrawCenteredStr("Magic cannot be used", byte0 + 234, byte1 + 192, 1, 0xff0000);
        }
        if (StakePrayerVar == 0) {
            Gfx.DrawCenteredStr("Prayer may be used", byte0 + 234, byte1 + 204, 1, 65280);
        } else {
            Gfx.DrawCenteredStr("Prayer cannot be used", byte0 + 234, byte1 + 204, 1, 0xff0000);
        }
        if (StakeWeaponsVar == 0) {
            Gfx.DrawCenteredStr("Weapons may be used", byte0 + 234, byte1 + 216, 1, 65280);
        } else {
            Gfx.DrawCenteredStr("Weapons cannot be used", byte0 + 234, byte1 + 216, 1, 0xff0000);
        }
        Gfx.DrawCenteredStr("If you are sure click 'Accept' to begin the duel", byte0 + 234, byte1 + 230, 1, 0xffffff);
        if (!dlm) {
            Gfx.DrawPicture((byte0 + 118) - 35, byte1 + 238, del + 25);
            Gfx.DrawPicture((byte0 + 352) - 35, byte1 + 238, del + 26);
        } else {
            Gfx.DrawCenteredStr("Waiting for other player...", byte0 + 234, byte1 + 250, 1, 0xffff00);
        }
        if (MouseButtonDown == 1) {
            if (super.MouseX < byte0 || super.MouseY < byte1 || super.MouseX > byte0 + 468 || super.MouseY > byte1 + 262) {
                dll = false;
                super.Connection.SendID(42);
                super.Connection.End();
            }
            if (super.MouseX >= (byte0 + 118) - 35 && super.MouseX <= byte0 + 118 + 70 && super.MouseY >= byte1 + 238
                    && super.MouseY <= byte1 + 238 + 21) {
                dlm = true;
                super.Connection.SendID(66);
                super.Connection.End();
            }
            if (super.MouseX >= (byte0 + 352) - 35 && super.MouseX <= byte0 + 353 + 70 && super.MouseY >= byte1 + 238
                    && super.MouseY <= byte1 + 238 + 21) {
                dll = false;
                super.Connection.SendID(64);
                super.Connection.End();
            }
            MouseButtonDown = 0;
        }
    }

    private final void fdb(String s1) {
        if (deb == null) {
            return;
        }
        if (ejl) {
            return;
        } else {
            deb.ggm(dnm, t.fne(s1 + ".pcm", dnm), t.fnf(s1 + ".pcm", dnm));
        }
    }

    private final void MagicPrayMenu(boolean arg0) {
        int l = ((j) (Gfx)).blg - 199;
        int i1 = 36;

        Gfx.DrawPicture(l - 49, 3, del + 4);
        char c1 = '\304';
        char c2 = '\266';
        int k1;
        int j1 = k1 = j.ToHex(160, 160, 160);

        if (ebl == 0) {
            j1 = j.ToHex(220, 220, 220);
        } else {
            k1 = j.ToHex(220, 220, 220);
        }
        Gfx.cam(l, i1, c1 / 2, 24, j1, 128);
        Gfx.cam(l + c1 / 2, i1, c1 / 2, 24, k1, 128);
        Gfx.cam(l, i1 + 24, c1, 90, j.ToHex(220, 220, 220), 128);
        Gfx.cam(l, i1 + 24 + 90, c1, c2 - 90 - 24, j.ToHex(160, 160, 160), 128);
        Gfx.cbc(l, i1 + 24, c1, 0);
        Gfx.cbd(l + c1 / 2, i1, 24, 0);
        Gfx.cbc(l, i1 + 113, c1, 0);
        Gfx.DrawCenteredStr("Magic", l + c1 / 4, i1 + 16, 4, 0);
        Gfx.DrawCenteredStr("Prayers", l + c1 / 4 + c1 / 2, i1 + 16, 4, 0);
        if (ebl == 0) {
            ebj.gfm(ebk);
            int l1 = 0;

            for (int l2 = 0; l2 < Ident.SpellTotalCount; l2++) {
                String s1 = "@yel@";

                for (int k4 = 0; k4 < Ident.SpellRuneCount[l2]; k4++) {
                    int j5 = Ident.SpellRuneID[l2][k4];

                    if (HasRunes(j5, Ident.SpellRuneAmount[l2][k4])) {
                        continue;
                    }
                    s1 = "@whi@";
                    break;
                }
                int k5 = StatCurrentLevel[6];

                if (Ident.SpellLevel[l2] > k5) {
                    s1 = "@bla@";
                }
                ebj.gga(ebk, l1++, s1 + "Level " + Ident.SpellLevel[l2] + ": " + Ident.SpellName[l2]);
            }
            ebj.ged();
            int l3 = ebj.ggh(ebk);

            if (l3 != -1) {
                Gfx.DrawStr("Level " + Ident.SpellLevel[l3] + ": " + Ident.SpellName[l3], l + 2, i1 + 124, 1, 0xffff00);
                Gfx.DrawStr(Ident.SpellDescription[l3], l + 2, i1 + 136, 0, 0xffffff);
                for (int l4 = 0; l4 < Ident.SpellRuneCount[l3]; l4++) {
                    int l5 = Ident.SpellRuneID[l3][l4];

                    Gfx.DrawPicture(l + 2 + l4 * 44, i1 + 150, den + Ident.PictureOffset[l5]);
                    int i6 = InvAmount(l5);
                    int j6 = Ident.SpellRuneAmount[l3][l4];
                    String s3 = "@red@";

                    if (HasRunes(l5, j6)) {
                        s3 = "@gre@";
                    }
                    Gfx.DrawStr(s3 + i6 + "/" + j6, l + 2 + l4 * 44, i1 + 150, 1, 0xffffff);
                }
            } else {
                Gfx.DrawStr("Point at a spell for a description", l + 2, i1 + 124, 1, 0);
            }
        }
        if (ebl == 1) {
            ebj.gfm(ebk);
            int i2 = 0;

            for (int i3 = 0; i3 < Ident.PrayerTotalCount; i3++) {
                String s2 = "@whi@";

                if (Ident.PrayerLevel[i3] > StatMaximumLevel[5]) {
                    s2 = "@bla@";
                }
                if (PrayerIsOn[i3]) {
                    s2 = "@gre@";
                }
                ebj.gga(ebk, i2++, s2 + "Level " + Ident.PrayerLevel[i3] + ": " + Ident.PrayerName[i3]);
            }
            ebj.ged();
            int i4 = ebj.ggh(ebk);

            if (i4 != -1) {
                Gfx.DrawCenteredStr("Level " + Ident.PrayerLevel[i4] + ": " + Ident.PrayerName[i4], l + c1 / 2, i1 + 130,
                        1, 0xffff00);
                Gfx.DrawCenteredStr(Ident.PrayerDescription[i4], l + c1 / 2, i1 + 145, 0, 0xffffff);
                Gfx.DrawCenteredStr("Drain rate: " + Ident.PrayerDrain[i4], l + c1 / 2, i1 + 160, 1, 0);
            } else {
                Gfx.DrawStr("Point at a prayer for a description", l + 2, i1 + 124, 1, 0);
            }
        }
        if (!arg0) {
            return;
        }
        l = super.MouseX - (((j) (Gfx)).blg - 199);
        i1 = super.MouseY - 36;
        if (l >= 0 && i1 >= 0 && l < 196 && i1 < 182) {
            ebj.gea(l + (((j) (Gfx)).blg - 199), i1 + 36, super.fkh, super.MouseDownVar);
            if (i1 <= 24 && MouseButtonDown == 1) {
                if (l < 98 && ebl == 1) {
                    ebl = 0;
                    ebj.gfn(ebk);
                } else if (l > 98 && ebl == 0) {
                    ebl = 1;
                    ebj.gfn(ebk);
                }
            }
            if (MouseButtonDown == 1 && ebl == 0) {
                int j2 = ebj.ggh(ebk);

                if (j2 != -1) {
                    int j3 = StatCurrentLevel[6];

                    if (Ident.SpellLevel[j2] > j3) {
                        DisplayMessage("Your magic ability is not high enough for this spell", 3);
                    } else {
                        int j4;

                        for (j4 = 0; j4 < Ident.SpellRuneCount[j2]; j4++) {
                            int i5 = Ident.SpellRuneID[j2][j4];

                            if (HasRunes(i5, Ident.SpellRuneAmount[j2][j4])) {
                                continue;
                            }
                            DisplayMessage("You don't have all the reagents you need for this spell", 3);
                            j4 = -1;
                            break;
                        }
                        if (j4 == Ident.SpellRuneCount[j2]) {
                            SelectedSpell = j2;
                            SelectedItem = -1;
                        }
                    }
                }
            }
            if (MouseButtonDown == 1 && ebl == 1) {
                int k2 = ebj.ggh(ebk);

                if (k2 != -1) {
                    int k3 = StatMaximumLevel[5];

                    if (Ident.PrayerLevel[k2] > k3) {
                        DisplayMessage("Your prayer ability is not high enough for this prayer", 3);
                    } else if (StatCurrentLevel[5] == 0) {
                        DisplayMessage("You have run out of prayer points. Return to a church to recharge", 3);
                    } else if (PrayerIsOn[k2]) {
                        super.Connection.SendID(52);
                        super.Connection.SendVar(k2);
                        super.Connection.End();
                        PrayerIsOn[k2] = false;
                        fdb("prayeroff");
                    } else {
                        super.Connection.SendID(51);
                        super.Connection.SendVar(k2);
                        super.Connection.End();
                        PrayerIsOn[k2] = true;
                        fdb("prayeron");
                    }
                }
            }
            MouseButtonDown = 0;
        }
    }

    private final void fdd() {
        try {
            if (Gfx != null) {
                Gfx.cbi();
                Gfx.blm = null;
                Gfx = null;
            }
            if (efn != null) {
                efn.bha();
                efn = null;
            }
            dkj = null;
            ddf = null;
            dkl = null;
            eba = null;
            Player = null;
            dgj = null;
            Npc = null;
            My = null;
            if (Game != null) {
                Game.gim = null;
                Game.ghm = null;
                Game.gih = null;
                Game.gin = null;
                Game = null;
            }
            System.gc();
            return;
        } catch (Exception e) {
            return;
        }
    }

    private final boolean fde(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, boolean arg6, boolean arg7) // walking
    {
        int l = Game.gkb(arg0, arg1, arg2, arg3, arg4, arg5, djk, djl, arg6); // reachable value

        if (l == -1) {
            if (arg7) {
                l = 1;
                djk[0] = arg2;
                djl[0] = arg3;
            } else {
                return false;
            }
        }
        l--;
        arg0 = djk[l];
        arg1 = djl[l];
        l--;
        if (arg7) {
            super.Connection.SendID(67);
        } else {
            super.Connection.SendID(68);
        }
        super.Connection.SendInt(arg0 + TileX);
        super.Connection.SendInt(arg1 + TileY);
        if (arg7 && l == -1 && (arg0 + TileX) % 5 == 0) {
            l = 0;
        }
        for (int i1 = l; i1 >= 0 && i1 > l - 25; i1--) {
            super.Connection.SendVar(djk[i1] - arg0);
            super.Connection.SendVar(djl[i1] - arg1);
        }
        super.Connection.End();
        eak = -24;
        eal = super.MouseX;
        eam = super.MouseY;
        return true;
    }

    private final boolean fdf(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, boolean arg6, boolean arg7) // walking?
    {
        int l = Game.gkb(arg0, arg1, arg2, arg3, arg4, arg5, djk, djl, arg6); // reachable value

        if (l == -1) {
            return false;
        }
        l--;
        arg0 = djk[l];
        arg1 = djl[l];
        l--;
        if (arg7) {
            super.Connection.SendID(67);
        } else {
            super.Connection.SendID(68);
        }
        super.Connection.SendInt(arg0 + TileX);
        super.Connection.SendInt(arg1 + TileY);
        if (arg7 && l == -1 && (arg0 + TileX) % 5 == 0) {
            l = 0;
        }
        for (int i1 = l; i1 >= 0 && i1 > l - 25; i1--) {
            super.Connection.SendVar(djk[i1] - arg0);
            super.Connection.SendVar(djl[i1] - arg1);
        }
        super.Connection.End();
        eak = -24;
        eal = super.MouseX;
        eam = super.MouseY;
        return true;
    }

    private final boolean LoadTile(int arg0, int arg1) {
        load = false;
        if (dfl != 0) {
            Game.gie = false;
            return false;
        }
        dcj = false;
        arg0 += dnd;
        arg1 += dne;
        if (dng == din && arg0 > ddj && arg0 < ddl && arg1 > ddk && arg1 < ddm) {
            Game.gie = true;
            return false;
        }
        load = true;
        Gfx.DrawCenteredStr("Loading... Please wait", 256, 192, 1, 0xffffff);
        ShowFooter();
        Gfx.caj(dci, 0, 0);
        int l = TileX;
        int i1 = TileY;
        int j1 = (arg0 + 24) / 48;
        int k1 = (arg1 + 24) / 48;

        dng = din;
        TileX = j1 * 48 - 48;
        TileY = k1 * 48 - 48;
        ddj = j1 * 48 - 32;
        ddk = k1 * 48 - 32;
        ddl = j1 * 48 + 32;
        ddm = k1 * 48 + 32;
        Game.gkf(arg0, arg1, dng);
        TileX -= dnd;
        TileY -= dne;
        int l1 = TileX - l;
        int i2 = TileY - i1;

        for (int j2 = 0; j2 < ObjectCount; j2++) {
            ObjectX[j2] -= l1;
            ObjectY[j2] -= i2;
            int k2 = ObjectX[j2];
            int i3 = ObjectY[j2];
            int l3 = ObjectId[j2];
            i k4 = ddf[j2];

            try {
                int j5 = ecb[j2];
                int i6;
                int l6;

                if (j5 == 0 || j5 == 4) {
                    i6 = Ident.all[l3];
                    l6 = Ident.alm[l3];
                } else {
                    l6 = Ident.all[l3];
                    i6 = Ident.alm[l3];
                }
                int i7 = ((k2 + k2 + i6) * ecj) / 2;
                int j7 = ((i3 + i3 + l6) * ecj) / 2;

                if (k2 >= 0 && i3 >= 0 && k2 < 96 && i3 < 96) {
                    efn.bgm(k4);
                    k4.cml(i7, -Game.gla(i7, j7), j7);
                    Game.gjj(k2, i3, l3);
                    if (l3 == 74) {
                        k4.cmk(0, -480, 0);
                    }
                }
            } catch (RuntimeException runtimeexception) {
                System.out.println("Loc Error: " + runtimeexception.getMessage());
                System.out.println("i:" + j2 + " obj:" + k4);
                runtimeexception.printStackTrace();
            }
        }
        for (int l2 = 0; l2 < WallObjectCount; l2++) {
            WallObjectX[l2] -= l1;
            WallObjectY[l2] -= i2;
            int j3 = WallObjectX[l2];
            int i4 = WallObjectY[l2];
            int l4 = WallObjectId[l2];
            int k5 = WallObjectDir[l2];

            try {
                Game.gkj(j3, i4, k5, l4);
                i j6 = feg(j3, i4, k5, l4, l2);

                dkl[l2] = j6;
            } catch (RuntimeException runtimeexception1) {
                System.out.println("Bound Error: " + runtimeexception1.getMessage());
                runtimeexception1.printStackTrace();
            }
        }
        for (int k3 = 0; k3 < ItemCount; k3++) {
            ItemX[k3] -= l1;
            ItemY[k3] -= i2;
        }
        for (int j4 = 0; j4 < PlayerCount; j4++) {
            NpcObject f1 = Player[j4];

            f1.XCoord -= l1 * ecj;
            f1.YCoord -= i2 * ecj;
            for (int l5 = 0; l5 <= f1.PathIndex; l5++) {
                f1.XCoordPath[l5] -= l1 * ecj;
                f1.YCoordPath[l5] -= i2 * ecj;
            }
        }
        for (int i5 = 0; i5 < NpcCount; i5++) {
            NpcObject f2 = Npc[i5];

            f2.XCoord -= l1 * ecj;
            f2.YCoord -= i2 * ecj;
            for (int k6 = 0; k6 <= f2.PathIndex; k6++) {
                f2.XCoordPath[k6] -= l1 * ecj;
                f2.YCoordPath[k6] -= i2 * ecj;
            }
        }
        Game.gie = true;
        return true;
    }

    private final void fdh() {
        int l = 0;
        byte byte0 = 50;
        byte byte1 = 50;

        Game.gkf(byte0 * 48 + 23, byte1 * 48 + 23, l);
        Game.gle(dkj);
        char c1 = '\u2600';
        char c2 = '\u1900';
        char c3 = '\u044C';
        char c4 = '\u0378';

        efn.bbg = 4100;
        efn.bbh = 4100;
        efn.bbi = 1;
        efn.bbj = 4000;
        efn.bin(c1, -Game.gla(c1, c2), c2, 912, c4, 0, c3 * 2);
        efn.bib();
        Gfx.cbf();
        Gfx.cbf();
        Gfx.DrawBox(0, 0, 512, 6, 0);
        for (int i1 = 6; i1 >= 1; i1--) {
            Gfx.cbg(0, i1, 0, i1, 512, 8);
        }
        Gfx.DrawBox(0, 194, 512, 20, 0);
        for (int j1 = 6; j1 >= 1; j1--) {
            Gfx.cbg(0, j1, 0, 194 - j1, 512, 8);
        }
        Gfx.DrawPicture(15, 15, del + 10);
        Gfx.cca(dfd, 0, 0, 512, 200);
        Gfx.cbl(dfd);
        c1 = '\u2400';
        c2 = '\u2400';
        c3 = '\u044C';
        c4 = '\u0378';
        efn.bbg = 4100;
        efn.bbh = 4100;
        efn.bbi = 1;
        efn.bbj = 4000;
        efn.bin(c1, -Game.gla(c1, c2), c2, 912, c4, 0, c3 * 2);
        efn.bib();
        Gfx.cbf();
        Gfx.cbf();
        Gfx.DrawBox(0, 0, 512, 6, 0);
        for (int k1 = 6; k1 >= 1; k1--) {
            Gfx.cbg(0, k1, 0, k1, 512, 8);
        }
        Gfx.DrawBox(0, 194, 512, 20, 0);
        for (int l1 = 6; l1 >= 1; l1--) {
            Gfx.cbg(0, l1, 0, 194 - l1, 512, 8);
        }
        Gfx.DrawPicture(15, 15, del + 10);
        Gfx.cca(dfd + 1, 0, 0, 512, 200);
        Gfx.cbl(dfd + 1);
        for (int i2 = 0; i2 < 64; i2++) {
            efn.bgn(Game.gih[0][i2]);
            efn.bgn(Game.ghm[1][i2]);
            efn.bgn(Game.gih[1][i2]);
            efn.bgn(Game.ghm[2][i2]);
            efn.bgn(Game.gih[2][i2]);
        }
        c1 = '\u2B80';
        c2 = '\u2880';
        c3 = '\u01F4';
        c4 = '\u0178';
        efn.bbg = 4100;
        efn.bbh = 4100;
        efn.bbi = 1;
        efn.bbj = 4000;
        efn.bin(c1, -Game.gla(c1, c2), c2, 912, c4, 0, c3 * 2);
        efn.bib();
        Gfx.cbf();
        Gfx.cbf();
        Gfx.DrawBox(0, 0, 512, 6, 0);
        for (int j2 = 6; j2 >= 1; j2--) {
            Gfx.cbg(0, j2, 0, j2, 512, 8);
        }
        Gfx.DrawBox(0, 194, 512, 20, 0);
        for (int k2 = 6; k2 >= 1; k2--) {
            Gfx.cbg(0, k2, 0, 194, 512, 8);
        }
        Gfx.DrawPicture(15, 15, del + 10);
        Gfx.cca(del + 10, 0, 0, 512, 200);
        Gfx.cbl(del + 10);
    }

    protected final void adc() {
        edh = 0;
        FightMode = 0;
        dhf = 0;
        ehl = 0;
        LoggedInVar = 1;
        super.fkn = "";
        super.fla = "";
        RsFrame.setTitle(Version + " by Reines ( " + Username + " )");
        Gfx.cak();
        Gfx.caj(dci, 0, 0);
        for (int l = 0; l < ObjectCount; l++) {
            efn.bgn(ddf[l]);
            Game.gkg(ObjectX[l], ObjectY[l], ObjectId[l]);
        }
        for (int i1 = 0; i1 < WallObjectCount; i1++) {
            efn.bgn(dkl[i1]);
            Game.gke(WallObjectX[i1], WallObjectY[i1], WallObjectDir[i1], WallObjectId[i1]);
        }
        ObjectCount = 0;
        WallObjectCount = 0;
        ItemCount = 0;
        PlayerCount = 0;
        NpcCount = 0;
        for (int j1 = 0; j1 < 4000; j1++) {
            eba[j1] = null;
        }
        for (int k1 = 0; k1 < 500; k1++) {
            Player[k1] = null;
        }
        for (int l1 = 0; l1 < 5000; l1++) {
            dgj[l1] = null;
        }
        for (int i2 = 0; i2 < 500; i2++) {
            Npc[i2] = null;
        }
        for (int j2 = 0; j2 < 50; j2++) {
            PrayerIsOn[j2] = false;
        }
        MouseButtonDown = 0;
        super.fkh = 0;
        super.MouseDownVar = 0;
        InShop = InBank = Sleeping = false;
        TradeScreen1 = TradeScreen2 = false;
        deh = dll = false;
        super.FriendCount = 0;
        NewLogin();
    }

    final void fdk(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
        NpcObject f1 = Player[arg4];

        if (f1.hab == 255) {
            return;
        }
        int l = f1.Dir + (dke + 16) / 32 & 7;
        boolean flag = false;
        int i1 = l;

        if (i1 == 5) {
            i1 = 3;
            flag = true;
        } else if (i1 == 6) {
            i1 = 2;
            flag = true;
        } else if (i1 == 7) {
            i1 = 1;
            flag = true;
        }
        int j1 = i1 * 3 + efl[(f1.gmk / 6) % 4];

        if (f1.Dir == 8) {
            i1 = 5;
            l = 2;
            flag = false;
            arg0 -= (5 * arg6) / 100;
            j1 = i1 * 3 + dei[(dji / 5) % 8];
        } else if (f1.Dir == 9) {
            i1 = 5;
            l = 2;
            flag = true;
            arg0 += (5 * arg6) / 100;
            j1 = i1 * 3 + ded[(dji / 6) % 8];
        }
        for (int k1 = 0; k1 < 12; k1++) {
            int l1 = ddh[l][k1];
            int l2 = f1.gnd[l1] - 1;

            if (l2 >= 0) {
                int k3 = 0;
                int i4 = 0;
                int j4 = j1;

                if (flag && i1 >= 1 && i1 <= 3) {
                    if (Ident.anc[l2] == 1) {
                        j4 += 15;
                    } else if (l1 == 4 && i1 == 1) {
                        k3 = -22;
                        i4 = -3;
                        j4 = i1 * 3 + efl[(2 + f1.gmk / 6) % 4];
                    } else if (l1 == 4 && i1 == 2) {
                        k3 = 0;
                        i4 = -8;
                        j4 = i1 * 3 + efl[(2 + f1.gmk / 6) % 4];
                    } else if (l1 == 4 && i1 == 3) {
                        k3 = 26;
                        i4 = -5;
                        j4 = i1 * 3 + efl[(2 + f1.gmk / 6) % 4];
                    } else if (l1 == 3 && i1 == 1) {
                        k3 = 22;
                        i4 = 3;
                        j4 = i1 * 3 + efl[(2 + f1.gmk / 6) % 4];
                    } else if (l1 == 3 && i1 == 2) {
                        k3 = 0;
                        i4 = 8;
                        j4 = i1 * 3 + efl[(2 + f1.gmk / 6) % 4];
                    } else if (l1 == 3 && i1 == 3) {
                        k3 = -26;
                        i4 = 5;
                        j4 = i1 * 3 + efl[(2 + f1.gmk / 6) % 4];
                    }
                }
                if (i1 != 5 || Ident.anb[l2] == 1) {
                    int k4 = j4 + Ident.and[l2];

                    k3 = (k3 * arg2) / ((j) (Gfx)).bmj[k4];
                    i4 = (i4 * arg3) / ((j) (Gfx)).bmk[k4];
                    int l4 = (arg2 * ((j) (Gfx)).bmj[k4]) / ((j) (Gfx)).bmj[Ident.and[l2]];

                    k3 -= (l4 - arg2) / 2;
                    int i5 = Ident.amn[l2];
                    int j5 = ekd[f1.hac];

                    if (i5 == 1) {
                        i5 = dlj[f1.gnn];
                    } else if (i5 == 2) {
                        i5 = deg[f1.haa];
                    } else if (i5 == 3) {
                        i5 = deg[f1.hab];
                    }
                    Gfx.cdd(arg0 + k3, arg1 + i4, l4, arg3, k4, i5, j5, arg5, flag);
                }
            }
        }
        if (f1.TalkVar > 0) {
            ebg[efd] = Gfx.cef(f1.Message, 1) / 2;
            if (ebg[efd] > 150) {
                ebg[efd] = 150;
            }
            ebh[efd] = (Gfx.cef(f1.Message, 1) / 300) * Gfx.ced(1);
            ebe[efd] = arg0 + arg2 / 2;
            ebf[efd] = arg1;
            efe[efd++] = f1.Message;
        }
        if (f1.gnh > 0) {
            eai[dln] = arg0 + arg2 / 2;
            eaj[dln] = arg1;
            eag[dln] = arg6;
            eah[dln++] = f1.gng;
        }
        if (f1.Dir == 8 || f1.Dir == 9 || f1.CombatVar != 0) {
            if (f1.CombatVar > 0) {
                int i2 = arg0;

                if (f1.Dir == 8) {
                    i2 -= (20 * arg6) / 100;
                } else if (f1.Dir == 9) {
                    i2 += (20 * arg6) / 100;
                }
                int i3 = (f1.CurrentHits * 30) / f1.MaxHits;

                dfg[egl] = i2 + arg2 / 2;
                dfh[egl] = arg1;
                dfi[egl++] = i3;
            }
            if (f1.CombatVar > 150) {
                int j2 = arg0;

                if (f1.Dir == 8) {
                    j2 -= (10 * arg6) / 100;
                } else if (f1.Dir == 9) {
                    j2 += (10 * arg6) / 100;
                }
                Gfx.DrawPicture((j2 + arg2 / 2) - 12, (arg1 + arg3 / 2) - 12, del + 11);
                Gfx.DrawCenteredStr(String.valueOf(f1.LastHit), (j2 + arg2 / 2) - 1, arg1 + arg3 / 2 + 5, 3, 0xffffff);
            }
        }
        if (f1.haj == 1 && f1.gnh == 0) {
            int k2 = arg5 + arg0 + arg2 / 2;

            if (f1.Dir == 8) {
                k2 -= (20 * arg6) / 100;
            } else if (f1.Dir == 9) {
                k2 += (20 * arg6) / 100;
            }
            int j3 = (16 * arg6) / 100;
            int l3 = (16 * arg6) / 100;

            Gfx.ccc(k2 - j3 / 2, arg1 - l3 / 2 - (10 * arg6) / 100, j3, l3, del + 13);
        }
    }

    private final void fdl() {
        Gfx.bnc = false;
        Gfx.cak();
        dhi.ged();
        int l = 256;
        int i1 = 25;

        Gfx.ccf(l - 32 - 55, i1, 64, 102, Ident.and[dhn], deg[dic]);
        Gfx.cdd(l - 32 - 55, i1, 64, 102, Ident.and[dhm], deg[dib], ekd[did], 0, false);
        Gfx.cdd(l - 32 - 55, i1, 64, 102, Ident.and[dhl], dlj[dia], ekd[did], 0, false);
        Gfx.ccf(l - 32, i1, 64, 102, Ident.and[dhn] + 6, deg[dic]);
        Gfx.cdd(l - 32, i1, 64, 102, Ident.and[dhm] + 6, deg[dib], ekd[did], 0, false);
        Gfx.cdd(l - 32, i1, 64, 102, Ident.and[dhl] + 6, dlj[dia], ekd[did], 0, false);
        Gfx.ccf((l - 32) + 55, i1, 64, 102, Ident.and[dhn] + 12, deg[dic]);
        Gfx.cdd((l - 32) + 55, i1, 64, 102, Ident.and[dhm] + 12, deg[dib], ekd[did], 0, false);
        Gfx.cdd((l - 32) + 55, i1, 64, 102, Ident.and[dhl] + 12, dlj[dia], ekd[did], 0, false);
        Gfx.DrawPicture(0, RsHeight, del + 22);
        Gfx.caj(dci, 0, 0);
    }

    private final void LoadGraphics() {
        byte abyte0[] = LoadDataFile(7, "2d graphics", 20); // media58.jag

        if (abyte0 == null) {
            LoadingError = true;
            return;
        }
        byte abyte1[] = t.Extract("index.dat", 0, abyte0);

        Gfx.cbj(del, t.Extract("inv1.dat", 0, abyte0), abyte1, 1);
        Gfx.cbj(del + 1, t.Extract("inv2.dat", 0, abyte0), abyte1, 6);
        Gfx.cbj(del + 9, t.Extract("bubble.dat", 0, abyte0), abyte1, 1);
        Gfx.cbj(del + 10, t.Extract("runescape.dat", 0, abyte0), abyte1, 1);
        Gfx.cbj(del + 11, t.Extract("splat.dat", 0, abyte0), abyte1, 3);
        Gfx.cbj(del + 14, t.Extract("icon.dat", 0, abyte0), abyte1, 8);
        Gfx.cbj(del + 22, t.Extract("hbar.dat", 0, abyte0), abyte1, 1);
        Gfx.cbj(del + 23, t.Extract("hbar2.dat", 0, abyte0), abyte1, 1);
        Gfx.cbj(del + 24, t.Extract("compass.dat", 0, abyte0), abyte1, 1);
        Gfx.cbj(del + 25, t.Extract("buttons.dat", 0, abyte0), abyte1, 2);
        Gfx.cbj(dem, t.Extract("scrollbar.dat", 0, abyte0), abyte1, 2);
        Gfx.cbj(dem + 2, t.Extract("corners.dat", 0, abyte0), abyte1, 4);
        Gfx.cbj(dem + 6, t.Extract("arrows.dat", 0, abyte0), abyte1, 2);
        Gfx.cbj(dfa, t.Extract("projectile.dat", 0, abyte0), abyte1, Ident.ahg);
        int l = Ident.aje;

        for (int i1 = 1; l > 0; i1++) {
            int j1 = l;

            l -= 30;
            if (j1 > 30) {
                j1 = 30;
            }
            Gfx.cbj(den + (i1 - 1) * 30, t.Extract("objects" + i1 + ".dat", 0, abyte0), abyte1, j1);
        }
        Gfx.cbm(del);
        Gfx.cbm(del + 9);
        for (int k1 = 11; k1 <= 26; k1++) {
            Gfx.cbm(del + k1);
        }
        for (int l1 = 0; l1 < Ident.ahg; l1++) {
            Gfx.cbm(dfa + l1);
        }
        for (int i2 = 0; i2 < Ident.aje; i2++) {
            Gfx.cbm(den + i2);
        }
    }

    private final void fdn(int l, int i1, int j1, int k1, boolean flag) {
        if (!fdf(l, i1, j1, k1, j1, k1, false, flag)) {
            fde(l, i1, j1, k1, j1, k1, true, flag);
        }
    }

    private int foundChar = -999;
    private String nameStart;
    private String strStart;

    protected final void KeyPressed(int l) {
        if ((char) l == '\u0009') { // Tab
            if (foundChar < 0) {
                if (foundChar < -1) {
                    String s = elg.ggd(eli);
                    int lastSpace = s.lastIndexOf(" ") + 1;

                    nameStart = s.substring(lastSpace);
                    strStart = s.substring(0, lastSpace);
                }
                for (foundChar = 0; foundChar < PlayerCount; foundChar++) {
                    String thisPlayer = Player[foundChar].Name;

                    if (thisPlayer.toLowerCase().startsWith(nameStart.toLowerCase())) {
                        elg.ggc(eli, strStart + thisPlayer);
                        break;
                    }
                }
            } else {
                for (foundChar++; foundChar < PlayerCount; foundChar++) {
                    String thisPlayer = Player[foundChar].Name;

                    if (thisPlayer.toLowerCase().startsWith(nameStart.toLowerCase())) {
                        elg.ggc(eli, strStart + thisPlayer);
                        break;
                    }
                }
                if (foundChar >= PlayerCount - 1) {
                    foundChar = -1;
                }
            }
        } else { // Not-Tab
            foundChar = -999;
        }
        if (l == 1004) { // Up Arrow Key
            elg.ggc(eli, LastStr);
        } else if (l == 1005) { // Down Arrow Key
            elg.ggc(eli, "");
        } else if (l == 1012) // F5
        {
            ShowStuff = !ShowStuff;
            ShowCmd("Status Menu " + (ShowStuff ? "enabled" : "disabled"));
        } else if (l == 1013) // F6
        {
            Debug = !Debug;
            ShowCmd("Debug " + (Debug ? "enabled" : "disabled"));
        } else if (l == 1014) // F7
        {
            ShowRoof = !ShowRoof;
            ShowCmd("Roofs are now " + (ShowRoof ? "normal" : "removed"));
        } else if (l == 1015) { // F8
            SelectMacro();
        } else if (l == 1016) // F9
        {
            try {
                File file = null;

                for (int x = 1; x < Integer.MAX_VALUE; x++) {
                    file = new File(System.getProperty("user.dir") + "/Screenshots/Screenshot" + x + ".png");
                    if (!file.exists()) {
                        ScreenShot(file);
                        ShowCmd("Screenshot saved as Screenshot" + x + ".png");
                        break;
                    }
                }
            } catch (Exception e) {
                ShowCmd("Error saving screenshot");
            }
        } else if (l == 1017) // F10
        {
            AutoLogin = !AutoLogin;
            ShowCmd("AutoLogin turned " + (AutoLogin ? "on" : "off"));
        } else if (l == 1018) // F11
        {
            ShowGfx = !ShowGfx;
            ShowCmd("Graphics turned " + (ShowGfx ? "on" : "off"));
        } else if (run && LoggedInVar == 1 && macro != null) {
            macro.KeyPressed(l);
        }
        if (LoggedInVar == 0) {
            if (ehl == 0) {
                ehm.gec(l);
            }
            if (ehl == 1) {
                dmc.gec(l);
            }
            if (ehl == 2) {
                dkf.gec(l);
            }
        }
        if (LoggedInVar == 1) {
            if (efc) {
                dhi.gec(l);
                return;
            }
            if (efm == 0 && !Sleeping && ToGet == "") {
                elg.gec(l);
            }
        }
    }

    private final void DisplayMessage(String arg0, int arg1) {
        if (arg1 == 2 || arg1 == 4 || arg1 == 6) {
            trimColours(arg0);
            int l = arg0.indexOf(":");

            if (l != -1) {
                String s1 = arg0.substring(0, l);
                long l1 = t.PlayerNameToLong(s1);

                for (int j1 = 0; j1 < super.IgnoreCount; j1++) {
                    if (super.IgnoreList[j1] == l1) {
                        return;
                    }
                }
            }
        }
        if (arg1 == 2) {
            arg0 = "@yel@" + arg0;
        } else if (arg1 == 3 || arg1 == 4) {
            OnServerMessage(trimColours(arg0));
            arg0 = "@whi@" + arg0;
        } else if (arg1 == 5) {
            OnServerMessage(trimColours(arg0));
        } else if (arg1 == 6) {
            arg0 = "@cya@" + arg0;
        }
        if (ell != 0) {
            if (arg1 == 4 || arg1 == 3) {
                ehc = 200;
            }
            if (arg1 == 2 && ell != 1) {
                ehd = 200;
            }
            if (arg1 == 5 && ell != 2) {
                ehe = 200;
            }
            if (arg1 == 6 && ell != 3) {
                ehf = 200;
            }
            if (arg1 == 3 && ell != 4 && ell != 0) {
                ell = 0;
            }
            if (arg1 == 6 && ell != 4 && ell != 3 && ell != 0) {
                ell = 0;
            }
        }
        for (int i1 = 4; i1 > 0; i1--) {
            egb[i1] = egb[i1 - 1];
            def[i1] = def[i1 - 1];
        }
        egb[0] = arg0;
        def[0] = 300;
        if (arg1 == 2) {
            if (elg.gbc[elh] == elg.gbd[elh] - 4) {
                elg.ggb(elh, arg0, true);
            } else {
                elg.ggb(elh, arg0, false);
            }
        }
        if (arg1 == 5) {
            if (elg.gbc[elj] == elg.gbd[elj] - 4) {
                elg.ggb(elj, arg0, true);
            } else {
                elg.ggb(elj, arg0, false);
            }
        }
        if (arg1 == 6) {
            if (elg.gbc[elk] == elg.gbd[elk] - 4) {
                elg.ggb(elk, arg0, true);
            } else {
                elg.ggb(elk, arg0, false);
            }
        }
    }

    private final void LoadAnimation() {
        byte abyte0[] = null;
        byte abyte1[] = null;

        abyte0 = LoadDataFile(11, "people and monsters", 30);
        if (abyte0 == null) {
            LoadingError = true;
            return;
        }
        abyte1 = t.Extract("index.dat", 0, abyte0);
        byte abyte2[] = null;
        byte abyte3[] = null;

        abyte2 = LoadDataFile(3, "member graphics", 45); // entity24.mem
        if (abyte2 == null) {
            LoadingError = true;
            return;
        }
        abyte3 = t.Extract("index.dat", 0, abyte2);
        int l = 0;

        eic = 0;
        eid = eic;
        label0:
        for (int i1 = 0; i1 < Ident.ake; i1++) {
            String s1 = Ident.akb[i1];

            for (int j1 = 0; j1 < i1; j1++) {
                if (!Ident.akb[j1].equalsIgnoreCase(s1)) {
                    continue;
                }
                Ident.and[i1] = Ident.and[j1];
                continue label0;
            }
            byte abyte7[] = t.Extract(s1 + ".dat", 0, abyte0);
            byte abyte4[] = abyte1;

            if (abyte7 == null) {
                abyte7 = t.Extract(s1 + ".dat", 0, abyte2);
                abyte4 = abyte3;
            }
            if (abyte7 != null) {
                Gfx.cbj(eid, abyte7, abyte4, 15);
                l += 15;
                if (Ident.anb[i1] == 1) {
                    byte abyte8[] = t.Extract(s1 + "a.dat", 0, abyte0);
                    byte abyte5[] = abyte1;

                    if (abyte8 == null) {
                        abyte8 = t.Extract(s1 + "a.dat", 0, abyte2);
                        abyte5 = abyte3;
                    }
                    Gfx.cbj(eid + 15, abyte8, abyte5, 3);
                    l += 3;
                }
                if (Ident.anc[i1] == 1) {
                    byte abyte9[] = t.Extract(s1 + "f.dat", 0, abyte0);
                    byte abyte6[] = abyte1;

                    if (abyte9 == null) {
                        abyte9 = t.Extract(s1 + "f.dat", 0, abyte2);
                        abyte6 = abyte3;
                    }
                    Gfx.cbj(eid + 18, abyte9, abyte6, 9);
                    l += 9;
                }
                if (Ident.ana[i1] != 0) {
                    for (int k1 = eid; k1 < eid + 27; k1++) {
                        Gfx.cbm(k1);
                    }
                }
            }
            Ident.and[i1] = eid;
            eid += 27;
        }
    }

    protected final void fed() {
        aca();
        fdd();
        if (deb != null) {
            deb.ggl();
        }
    }

    protected final void SetLoginMessage(String s1, String s2) {
        if (ehl == 1) {
            dmc.ggc(eji, s1 + " " + s2);
        }
        if (ehl == 2) {
            dkf.ggc(LoginPromptVar, s1 + " " + s2);
        }
        emj();
        flf();
    }

    private final void LoadTextures() {
        byte abyte0[] = LoadDataFile(6, "Textures", 50);

        if (abyte0 == null) {
            LoadingError = true;
            return;
        }
        byte abyte1[] = t.Extract("index.dat", 0, abyte0);

        efn.bje(Ident.amj, 7, 11);
        for (int l = 0; l < Ident.amj; l++) {
            String s1 = Ident.alg[l];
            byte abyte2[] = t.Extract(s1 + ".dat", 0, abyte0);

            Gfx.cbj(dfb, abyte2, abyte1, 1);
            Gfx.DrawBox(0, 0, 128, 128, 0xff00ff);
            Gfx.DrawPicture(0, 0, dfb);
            int i1 = ((j) (Gfx)).bmj[dfb];
            String s2 = Ident.alh[l];

            if (s2 != null && s2.length() > 0) {
                byte abyte3[] = t.Extract(s2 + ".dat", 0, abyte0);

                Gfx.cbj(dfb, abyte3, abyte1, 1);
                Gfx.DrawPicture(0, 0, dfb);
            }
            Gfx.cca(dfc + l, 0, 0, i1, i1);
            int j1 = i1 * i1;

            for (int k1 = 0; k1 < j1; k1++) {
                if (((j) (Gfx)).bmc[dfc + l][k1] == 65280) {
                    ((j) (Gfx)).bmc[dfc + l][k1] = 0xff00ff;
                }
            }
            Gfx.cbl(dfc + l);
            efn.bjf(l, ((j) (Gfx)).bmd[dfc + l], ((j) (Gfx)).bme[dfc + l], i1 / 64 - 1);
        }

    }

    protected final Socket NewSocket(String arg0, int arg1)throws IOException {
        Socket socket = new Socket(InetAddress.getByName(arg0), arg1);

        socket.setSoTimeout(30000);
        socket.setTcpNoDelay(true);
        return socket;
    }

    private final i feg(int l, int i1, int j1, int k1, int l1) {
        int i2 = l;
        int j2 = i1;
        int k2 = l;
        int l2 = i1;
        int i3 = Ident.akg[k1];
        int j3 = Ident.akh[k1];
        int k3 = Ident.akf[k1];
        i l3 = new i(4, 1);

        if (j1 == 0) {
            k2 = l + 1;
        }
        if (j1 == 1) {
            l2 = i1 + 1;
        }
        if (j1 == 2) {
            i2 = l + 1;
            l2 = i1 + 1;
        }
        if (j1 == 3) {
            k2 = l + 1;
            l2 = i1 + 1;
        }
        i2 *= ecj;
        j2 *= ecj;
        k2 *= ecj;
        l2 *= ecj;
        int i4 = l3.cln(i2, -Game.gla(i2, j2), j2);
        int j4 = l3.cln(i2, -Game.gla(i2, j2) - k3, j2);
        int k4 = l3.cln(k2, -Game.gla(k2, l2) - k3, l2);
        int l4 = l3.cln(k2, -Game.gla(k2, l2), l2);
        int ai[] = { i4, j4, k4, l4};

        l3.cmb(4, ai, i3, j3);
        l3.cme(false, 60, 24, -50, -10, -50);
        if (l >= 0 && i1 >= 0 && l < 96 && i1 < 96) {
            efn.bgm(l3);
        }
        l3.chk = l1 + 10000;
        return l3;
    }

    public mudclient() {
        OptionId = new int[250];
        dcj = false;
        RsWidth = 512;
        RsHeight = 334;
        dcn = 9;
        dda = new int[250];
        dde = new int[500];
        ddf = new i[1500];
        TradeOpponentName = "";
        Npc = new NpcObject[500];
        deh = false;
        dek = false;
        dfg = new int[50];
        dfh = new int[50];
        dfi = new int[50];
        QuestMenuOptions = new String[5];
        dfm = new int[250];
        dfn = new int[250];
        dga = new int[250];
        dgb = new int[50];
        My = new NpcObject();
        dgf = -1;
        MyStakeId = new int[8];
        MyStakeAmount = new int[8];
        dgj = new NpcObject[5000];
        WallObjectX = new int[500];
        WallObjectY = new int[500];
        dgm = false;
        dgn = false;
        OpponentsStakeId = new int[8];
        OpponentsStakeAmount = new int[8];
        PrayerIsOn = new boolean[50];
        dhg = false;
        dhh = true;
        Zoom = 550;
        dhm = 1;
        dhn = 2;
        dia = 2;
        dib = 8;
        dic = 14;
        die = 1;
        LevelExp = new int[99];
        din = -1;
        OptionName2 = new String[250];
        Inside = false;
        Username = "";
        Password = "";
        InShop = false;
        djj = false;
        djk = new int[8000];
        djl = new int[8000];
        ShopItem = new int[256];
        ShopAmount = new int[256];
        ShopPrice = new int[256];
        TradeItem = new int[14];
        TradeAmount = new int[14];
        dke = 128;
        dkh = new int[8];
        dki = new int[8];
        dkj = new i[1000];
        QuestComplete = new boolean[50];
        dkl = new i[500];
        dla = false;
        dlb = false;
        dlc = false;
        dld = false;
        dle = true;
        StatTotalExpVar = new int[18];
        QuestMenu = false;
        dlk = 30;
        dll = false;
        dlm = false;
        dma = -1;
        dmb = -2;
        dme = new int[8192];
        dmf = new int[8192];
        dmg = -1;
        dmh = -1;
        dmi = -1;
        SelectedShopItem = -1;
        SelectedShopItemId = -2;
        dmn = new NpcObject[500];
        dna = new int[50];
        dnb = 48;
        dnc = new int[50];
        dng = -1;
        dnl = new boolean[500];
        eag = new int[50];
        eah = new int[50];
        eai = new int[50];
        eaj = new int[50];
        eba = new NpcObject[4000];
        ebb = new int[5];
        ebc = 40;
        ebe = new int[50];
        ebf = new int[50];
        ebg = new int[50];
        ebh = new int[50];
        ObjectX = new int[1500];
        ObjectY = new int[1500];
        ObjectId = new int[1500];
        ecb = new int[1500];
        OptionName1 = new String[250];
        Sleeping = false;
        ecf = new int[256];
        ecg = new int[256];
        ecj = 128;
        OpponentTradeItem = new int[14];
        OpponentTradeAmount = new int[14];
        edb = new int[256];
        edc = new int[256];
        OpponentTradeAccepted = false;
        MyTradeAccepted1 = false;
        SelectedSpell = -1;
        edm = new int[8];
        edn = new int[8];
        eeb = 2;
        efb = true;
        efc = false;
        efe = new String[50];
        TradeScreen1 = false;
        StatMaximumLevel = new int[18];
        ShowingPopup = false;
        egb = new String[5];
        Player = new NpcObject[500];
        egg = 2;
        egi = new int[14];
        egj = new int[14];
        StatCurrentLevel = new int[18];
        egm = new boolean[1500];
        TradeScreen2 = false;
        MyTradeAccepted2 = false;
        OptionX = new int[250];
        OptionY = new int[250];
        SelectedItem = -1;
        SelectedItemName = "";
        eii = new NpcObject[500];
        WallObjectDir = new int[500];
        WallObjectId = new int[500];
        LoadingError = false;
        InvItemId = new int[35];
        InvItemCount = new int[35];
        WearingVar = new int[35];
        ejf = new int[14];
        ejg = new int[14];
        ejl = false;
        ejm = false;
        ekg = "";
        ItemX = new int[5000];
        ItemY = new int[5000];
        ItemId = new int[5000];
        ekm = new int[5000];
        ekn = new int[50];
        MemoryError = false;
        ServerPopupMessage = "";
        ema = 1;
        InBank = false;
    }
    private int dcg;
    private int OptionId[];
    private Graphics dci;
    private boolean dcj;
    public int FightMode;
    private int RsWidth;
    private int RsHeight;
    private int dcn;
    private int dda[];
    private int ddc;
    private int ddd;
    private int dde[];
    private i ddf[];
    public String TradeOpponentName;
    private int ddh[][] = {
        { 11, 2, 9, 7, 1, 6, 10, 0, 5, 8, 3, 4}, { 11, 2, 9, 7, 1, 6, 10, 0, 5, 8, 3, 4},
        { 11, 3, 2, 9, 7, 1, 6, 10, 0, 5, 8, 4}, { 3, 4, 2, 9, 7, 1, 6, 10, 8, 11, 0, 5},
        { 3, 4, 2, 9, 7, 1, 6, 10, 8, 11, 0, 5}, { 4, 3, 2, 9, 7, 1, 6, 10, 8, 11, 0, 5},
        { 11, 4, 2, 9, 7, 1, 6, 10, 0, 5, 8, 3}, { 11, 2, 9, 7, 1, 6, 10, 0, 5, 8, 4, 3}};
    public NpcObject Npc[];
    private int ddj;
    private int ddk;
    private int ddl;
    private int ddm;
    private d deb;
    private int dec;
    private int ded[] = { 0, 0, 0, 0, 0, 1, 2, 1};
    public int QuestMenuOptionsCount;
    private int def[];
    private final int deg[] = {
        0xff0000, 0xff8000, 0xffe000, 0xa0e000, 57344, 32768, 41088, 45311, 33023, 12528,
        0xe000e0, 0x303030, 0x604000, 0x805000, 0xffffff};
    private boolean deh;
    private int dei[] = { 0, 1, 2, 1, 0, 0, 0, 0};
    private boolean dek;
    private int del;
    private int dem;
    private int den;
    private int dfa;
    private int dfb;
    private int dfc;
    private int dfd;
    private int dfe;
    private int dff;
    private int dfg[];
    private int dfh[];
    private int dfi[];
    private int dfj;
    public String QuestMenuOptions[];
    private int dfl;
    private int dfm[];
    private int dfn[];
    private int dga[];
    private int dgb[];
    public NpcObject My;
    private int LocalX;
    private int LocalY;
    private int dgf;
    private int MyStakeCount;
    private int MyStakeId[];
    private int MyStakeAmount[];
    private NpcObject dgj[];
    public int WallObjectX[];
    public int WallObjectY[];
    private boolean dgm;
    private boolean dgn;
    private int dha;
    private int OpponentsStakeCount;
    private int OpponentsStakeId[];
    private int OpponentsStakeAmount[];
    public boolean PrayerIsOn[];
    private int dhf;
    private boolean dhg;
    private boolean dhh;
    private h dhi;
    private int Zoom;
    private int QuestPoints;
    private int dhl;
    private int dhm;
    private int dhn;
    private int dia;
    private int dib;
    private int dic;
    private int did;
    private int die;
    private h dig;
    private int dih;
    private int dii;
    public int LevelExp[];
    public int TileX;
    public int TileY;
    private int din;
    private String OptionName2[];
    private boolean Inside;
    public int ObjectCount;
    private int dje;
    public String Username;
    private String Password;
    public boolean InShop;
    private int dji;
    private boolean djj;
    private int djk[];
    private int djl[];
    private int ShopItem[];
    private int ShopAmount[];
    private int ShopPrice[];
    public int TradeIndex;
    private int TradeItem[];
    private int TradeAmount[];
    private int dke;
    private h dkf;
    private int dkg;
    private int dkh[];
    private int dki[];
    private i dkj[];
    public boolean QuestComplete[];
    private i dkl[];
    public int ItemCount;
    private int dkn;
    private boolean dla;
    private boolean dlb;
    private boolean dlc;
    private boolean dld;
    private boolean dle;
    public int StatTotalExpVar[];
    private int dlg;
    private int dlh;
    public boolean QuestMenu;
    private final int dlj[] = {
        0xffc030, 0xffa040, 0x805030, 0x604020, 0x303030, 0xff6020, 0xff4000, 0xffffff, 65280,
        65535};
    private int dlk;
    private boolean dll;
    private boolean dlm;
    private int dln;
    private int dma;
    private int dmb;
    private h dmc;
    private int dmd;
    private int dme[];
    private int dmf[];
    private int dmg;
    private int dmh;
    private int dmi;
    public int BankCount;
    private int SelectedShopItem;
    private int SelectedShopItemId;
    private NpcObject dmn[];
    private int dna[];
    private int dnb;
    private int dnc[];
    private int dnd;
    private int dne;
    private int dnf;
    private int dng;
    private int dnh;
    private int dni;
    public int NpcCount;
    private int dnk;
    private boolean dnl[];
    private byte dnm[];
    private int dnn;
    private int eaa;
    private int StakeRetreatVar;
    private int StakeMagicVar;
    private int StakePrayerVar;
    private int StakeWeaponsVar;
    private int eag[];
    private int eah[];
    private int eai[];
    private int eaj[];
    private int eak;
    private int eal;
    private int eam;
    private int ean;
    private NpcObject eba[];
    public int ebb[];
    private int ebc;
    private int MouseButtonDown;
    private int ebe[];
    private int ebf[];
    private int ebg[];
    private int ebh[];
    private h ebj;
    private int ebk;
    private int ebl;
    public int ObjectX[];
    public int ObjectY[];
    public int ObjectId[];
    private int ecb[];
    private String OptionName1[];
    private final String QuestName[] = {
        "Black knight's fortress", "Cook's assistant", "Demon slayer", "Doric's quest",
        "The restless ghost", "Goblin diplomacy", "Ernest the chicken", "Imp catcher", "Pirate's treasure",
        "Prince Ali rescue", "Romeo & Juliet", "Sheep shearer", "Shield of Arrav", "The knight's sword",
        "Vampire slayer", "Witch's potion", "Dragon slayer", "Witch's house", "Lost city", "Hero's quest", 
        "Druidic ritual", "Merlin's crystal", "Scorpion catcher", "Family crest", "Tribal totem", "Fishing contest",
        "Monk's friend", "Temple of Ikov", "Clock tower", "The Holy Grail", "Fight Arena", "Tree Gnome Village",
        "The Hazeel Cult", "Sheep Herder", "Plague City", "Sea Slug", "Waterfall quest", "Biohazard", "Jungle potion",
        "Grand tree", "Shilo village", "Underground pass", "Observatory quest", "Tourist trap", "Watchtower",
        "Dwarf Cannon", "Murder Mystery", "Digsite", "Gertrude's Cat", "Legend's Quest"};
    public boolean Sleeping;
    private int ecf[];
    private int ecg[];
    public final String StatName[] = {
        "Attack", "Defence", "Strength", "Hits", "Ranged", "Prayer", "Magic", "Cooking",
        "Woodcut", "Fletching", "Fishing", "Firemaking", "Crafting", "Smithing", "Mining", "Herblaw", "Agility",
        "Thieving"};
    public int ecj;
    public int LoggedInVar;
    public int OpponentTradeIndex;
    public int OpponentTradeItem[];
    public int OpponentTradeAmount[];
    public int eda;
    public int edb[];
    public int edc[];
    public boolean OpponentTradeAccepted;
    public boolean MyTradeAccepted1;
    private int SelectedSpell;
    private int edh;
    private int edi;
    private int edj;
    private int edk;
    private int edl;
    private int edm[];
    private int edn[];
    private int eea;
    private int eeb;
    private int eec;
    private int eed;
    private int eee;
    private int eef;
    private int eeg;
    private int eeh;
    private int eei;
    private int eej;
    private int eek;
    private int eel;
    private int eem;
    private int een;
    private int efa;
    private boolean efb;
    private boolean efc;
    private int efd;
    private String efe[];
    public boolean TradeScreen1;
    public int PlayerCount;
    private int TempPlayerCount;
    private int efi;
    private k Gfx;
    public int StatMaximumLevel[];
    private int efl[] = { 0, 1, 2, 1};
    private int efm;
    private static n efn;
    public boolean ShowingPopup;
    private String egb[];
    public NpcObject Player[];
    private int egf;
    private int egg;
    private int egh;
    private int egi[];
    private int egj[];
    public int StatCurrentLevel[];
    private int egl;
    private boolean egm[];
    public int WallObjectCount;
    public int FatigueVar;
    private int SleepFatigueVar;
    private int ehc;
    private int ehd;
    private int ehe;
    private int ehf;
    private int ehg;
    private int ehh;
    private int ehi;
    private int ehj;
    private int OptionVar;
    private int ehl;
    private h ehm;
    public boolean TradeScreen2;
    public boolean MyTradeAccepted2;
    private int eib;
    private int eic;
    private int eid;
    private int OptionX[];
    private int OptionY[];
    private int SelectedItem;
    private String SelectedItemName;
    private NpcObject eii[];
    private int WallObjectDir[];
    public int WallObjectId[];
    private boolean LoadingError;
    public int InvCount;
    public int InvItemId[];
    private int InvItemCount[];
    public int WearingVar[];
    private int eje;
    private int ejf[];
    private int ejg[];
    private int eji;
    private int ejj;
    private x Game;
    private boolean ejl;
    private boolean ejm;
    private h ejn;
    private int eka;
    private int ekb;
    private long SelectedFriend;
    private final int ekd[] = { 0xecded0, 0xccb366, 0xb38c40, 0x997326, 0x906020};
    private String SleepMessage;
    private long ekf;
    private String ekg;
    private int ekh;
    public int ItemX[];
    public int ItemY[];
    public int ItemId[];
    private int ekm[];
    private int ekn[];
    private int LoginPromptVar;
    private int UsernameVar;
    private int PasswordVar;
    private int ele;
    private int elf;
    private h elg;
    int elh;
    int eli;
    int elj;
    int elk;
    int ell;
    private boolean MemoryError;
    private String ServerPopupMessage;
    private int ema;
    private int emb;
    public boolean InBank;
    private final String ArmourStats[] = { "Armour", "WeaponAim", "WeaponPower", "Magic", "Prayer"};
    private long eme;

    public boolean ChangeWorld(int i) {
        if (!validWorld(i)) {
            return false;
        }
        super.Port = (((i % 2) == 0) ? 43595 : 43594);
        if (i == 1 || i == 2) {
            super.IP = "uk1.runescape.com";
        } else {
            super.IP = "ul3.runescape.com";
        }
        Server = String.valueOf(i);
        return true;
    }

    public static final void main(String args[])throws Exception {
        File file = new File(System.getProperty("user.dir") + "/Screenshots/");

        if (!file.exists()) {
            file.mkdir();
        }
        int serv = 1;
        boolean onTop = false;
        String httpProxyHost = "";
        String httpProxyPort = "";
        String socksProxyHost = "";
        String socksProxyPort = "";

        System.out.print("Loading settings...");
        try {
            Properties p = new Properties();

            p.load(new FileInputStream(new File(System.getProperty("user.dir") + "/Settings.ini")));
            // Auth settings
            AuthName = replace(p.getProperty("AuthName").trim(), " ", "%20");
            AuthPass = replace(p.getProperty("AuthPass").trim(), " ", "%20");
            serv = Integer.parseInt(p.getProperty("World"));
            onTop = p.getProperty("OnTop").trim().equalsIgnoreCase("on");
            // IRC settings
            String s = p.getProperty("UseIRC");

            useIRC = s != null && s.trim().equalsIgnoreCase("on");
            if (useIRC) {
                ircNick = replace(p.getProperty("NickName").trim(), " ", "_");
                ircPass = p.getProperty("NickPass").trim();
                if (ircNick.equals("") || ircNick.equalsIgnoreCase("AuthName")) {
                    ircNick = AuthName;
                }
                if (ircPass.equals("")) {
                    ircPass = null;
                }
            }
            // Chat filter
            u.ChatFilter = (p.getProperty("ChatFilter").trim().equalsIgnoreCase("on"));
            try {
                httpProxyHost = p.getProperty("httpProxyHost");
                httpProxyPort = p.getProperty("httpProxyPort");
                socksProxyHost = p.getProperty("socksProxyHost");
                socksProxyPort = p.getProperty("socksProxyPort");
            } catch (Exception e) {}
            if (AuthName.equals("") || AuthPass.equals("")) {
                System.out.println("Auth details not set in Settings.ini");
                System.exit(1);
            } else {
                System.out.println("Successful!");
            }
        } catch (Exception e) {
            System.out.println("settings.ini may be missing? " + e);
            System.exit(1);
        }
        if (!httpProxyHost.equals("") && !httpProxyPort.equals("")) {
            Properties sysP = System.getProperties();

            sysP.setProperty("http.proxyHost", httpProxyHost);
            sysP.setProperty("http.proxyPort", httpProxyPort);
            System.out.println("Setting httpProxy to " + httpProxyHost + ":" + httpProxyPort);
        }
        if (!socksProxyHost.equals("") && !socksProxyPort.equals("")) {
            Properties sysP = System.getProperties();

            sysP.setProperty("socksProxyHost", socksProxyHost);
            sysP.setProperty("socksProxyPort", socksProxyPort);
            System.out.println("Setting socksProxy to " + socksProxyHost + ":" + socksProxyPort);
        }
        System.out.print("Authorizing with server... ");
        URLConnection authCon;

        try {
            authCon = new URL("http://" + 69 + "." + 16 + "." + 203 + "." + 189 + "/sts/user.php?u=" + AuthName + "&p=" + AuthPass + "&v=" + Version).openConnection();
            authCon.setRequestProperty("User-Agent", "STS");
        } catch (Exception e) {
            System.out.println("Error connecting to auth server");
            outgoingIDs = null;
            incomingIDs = null;
            Valid = false;
            System.exit(1);
            return;
        }
        InetAddress authINet = InetAddress.getByName(authCon.getURL().getHost().toString());

        if (!authINet.getHostAddress().startsWith("69.16.203.18")) {
            System.out.println("Invalid auth");
            outgoingIDs = null;
            incomingIDs = null;
            Valid = false;
            System.exit(1);
            return;
        }
        try {
            BufferedReader buff = new BufferedReader(new InputStreamReader(authCon.getInputStream()));
            String temp = buff.readLine().trim();

            if (temp.equalsIgnoreCase("valid")) {
                Valid = true;
                System.out.println("Successful!");
            } else {
                System.out.println(temp);
                outgoingIDs = null;
                incomingIDs = null;
                Valid = false;
                System.exit(1);
                return;
            }
            WelcomeMessage = buff.readLine().trim();
            mudVersion = Integer.parseInt(buff.readLine().trim());
            String[] TincomingIDs = buff.readLine().trim().split(" ");

            if (TincomingIDs.length != 60) {
                System.out.println("Invalid Incoming ID array");
                System.exit(1);
                return;
            }
            for (int x = 0; x < 60; x++) {
                incomingIDs[x] = Integer.parseInt(TincomingIDs[x]);
            }
            String[] ToutgoingIDs = buff.readLine().trim().split(" ");

            if (ToutgoingIDs.length != 69) {
                System.out.println("Invalid Incoming ID array");
                System.exit(1);
                return;
            }
            for (int x = 0; x < 69; x++) {
                outgoingIDs[x] = Integer.parseInt(ToutgoingIDs[x]);
            }
        } catch (Exception e) {
            System.out.println(e);
            outgoingIDs = null;
            incomingIDs = null;
            Valid = false;
            System.exit(1);
            return;
        }
        if (AuthName.equals("';") || AuthPass.equals("';") || AuthName.equals(AuthPass)
                || AuthName.equalsIgnoreCase("regex") || authINet.isSiteLocalAddress() || authINet.isLoopbackAddress()) {
            System.out.println("Invalid Auth");
            outgoingIDs = null;
            incomingIDs = null;
            Valid = false;
            System.exit(1);
            return;
        }
        if (Valid) {
            mc = new mudclient();
            mc.LoadingLogo = Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir") + "/Data/logo.sts");
            mc.dhh = false;
            mc.CreateApplet(mc.RsWidth, mc.RsHeight + 11, mudclient.Version + " by Reines", false, onTop);
            mc.fkd = 10;
            try {
                Class c = Class.forName("NewLogin");
                Methods macro = (Methods) c.getConstructor(new Class[] { mudclient.class}).newInstance(
                        new Object[] { mc});

                mc.mac = (Methods) macro;
            } catch (Exception e) {
                mc.ShowCmd("Loading of NewLogin Script failed...Don't delete it!");
                System.exit(1);
            }
            System.out.print("Checking for Scripts... ");
            Load(mc);
            mc.Username = "";
            mc.Password = "";
            mc.ChangeWorld(serv);
        }
    }
    
}
