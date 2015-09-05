/** STSHell 2.0 Source **/
/*
 * STSHell 2.0 by Reines. Please view the README file for release information.
 * <3 Br0ken for the inspiration to start this project.
 */

import java.math.BigInteger;
import java.net.*;
import java.util.*;
import java.io.*;

public class Shell {

    private static final String VERSION = "20";

    private static BigInteger bigInt1 = new BigInteger("58778699976184461502525193738213253649000149147835990136706041084440742975821");
    private static BigInteger bigInt2 = new BigInteger("7162900525229798032761816791230527296329313291232324290237849263501208207972894053929065636522363163621000728841182238772712427862772219676577293600221789");
    public static int shellUserCount = 0;
    public static boolean DEBUG = false;
    private static String authName;
    private static boolean authed = false;
    public Connect Connection;
    private Map map;
    public boolean load = false;
    public String user;
    private String pass;
    public int server;
    public boolean loggedIn = false;
    private long pingTime;
    private Thread myThread;
    private Thread myMacro;
    public Methods macro;
    public int invCount = 0;
    public int[] invItemID = new int[30];
    public int[] invItemCount = new int[30];
    public boolean[] invItemWearing = new boolean[30];
    public boolean questMenu = false;
    public int questMenuCount = 0;
    public String[] questMenuOptions = new String[5];
    public int[] statCurLevel = new int[18];
    public int[] statMaxLevel = new int[18];
    public long[] statTotalExp = new long[18];
    private int[] armourStats = new int[5];
    private int questPoints = 0;
    public boolean[] questComplete = new boolean[50];
    public boolean[] prayOn = new boolean[14];
    public int fightMode = 0;
    public npcObject my = new npcObject();
    private int myNewID = -1;
    public int friendCount = 0;
    public String[] friendList = new String[200];
    public int[] friendServer = new int[200];
    public int fatigue = 0;
    private int sleepFatigue = 0;
    public boolean sleeping = false;
    public boolean sentWord = false;
    private static long fileMod = 0;
    private long lastChecked = 0;
    private static File slFile = new File("slword.txt");
    public String tradeOpponentName;
    public boolean tradeScreen1 = false;
    public boolean tradeScreen2 = false;
    public boolean opponentTradeAccepted = false;
    public boolean myTradeAccepted1 = false;
    public boolean myTradeAccepted2 = false;
    private int myTradeIndex = 0;
    public int opponentTradeIndex = 0;
    private int myTradeCount = 0;
    private int opponentTradeCount = 0;
    private int[] myTradeItemID = new int[12];
    private int[] myTradeItemAmount = new int[12];
    public int[] opponentTradeItemID = new int[12];
    public int[] opponentTradeItemAmount = new int[12];
    private String duelOpponentName;
    private boolean duelScreen1 = false;
    private boolean duelScreen2 = false;
    private boolean opponentDuelAccepted = false;
    private boolean myDuelAccepted1 = false;
    private boolean myDuelAccepted2 = false;
    private int myDuelIndex = 0;
    private int opponentDuelIndex = 0;
    private int myDuelCount = 0;
    private int opponentDuelCount = 0;
    private int[] myDuelItemID = new int[12];
    private int[] myDuelItemAmount = new int[12];
    private int[] opponentDuelItemID = new int[12];
    private int[] opponentDuelItemAmount = new int[12];
    private boolean DuelnoRetreat = false;
    private boolean DuelnoMagic = false;
    private boolean DuelnoPrayer = false;
    private boolean DuelnoWeapons = false;
    public boolean inShop = false;
    public boolean inBank = false;
    public int bankCount = 0;
    public int[] bankItemID = new int[256];
    public int[] bankItemCount = new int[256];
    private int shopCount = 0;
    public int[] shopItemID = new int[40];
    public int[] shopItemCount = new int[40];
    public int[] shopItemPrice = new int[40];
    public int shopBuyVar = 0;
    public int shopSellVar = 0;
    public int objectCount = 0;
    public int[] objectX = new int[1500];
    public int[] objectY = new int[1500];
    public int[] objectID = new int[1500];
    public int[] objectDir = new int[1500];
    public int wallObjectCount = 0;
    public int[] wallObjectX = new int[500];
    public int[] wallObjectY = new int[500];
    public int[] wallObjectID = new int[500];
    public int[] wallObjectDir = new int[500];
    public int itemCount = 0;
    public int[] itemX = new int[5000];
    public int[] itemY = new int[5000];
    public int[] itemID = new int[5000];
    public int playerCount = 0;
    public npcObject[] player = new npcObject[5000];
    public int npcCount = 0;
    public npcObject[] npc = new npcObject[5000];
    public int locX = 0;
    public int locY = 0;
    public int tileX = 0;
    public int tileY = 0;
    private int lowerX;
    private int upperX;
    private int lowerY;
    private int upperY;
    public int tileXoff = 0;
    public int tileYoff = 0;
    private int toLoad = 0;
    private int loadedTile = 0;
    private long[] timers = new long[10];
    public boolean autoLogin = true;

    public final static String getAuth() {
        return authName;
    }

    public static void debug(String toDebug) {
        if(DEBUG)
            System.out.println("deBug: " + toDebug);
    }

    public void print(String toShow) {
        System.out.println(user + ": " + toShow);
    }

    private String[] readLines(File toRead, int lineCount) {
        try {
            String[] readLines = new String[lineCount];
            BufferedReader input = new BufferedReader(new FileReader(toRead));
            for(int c = 0;c < lineCount;c++)
                readLines[c] = input.readLine().trim();
            input.close();
            return readLines;
        } catch(Exception e) {
            return null;
        }
    }

    public static int distanceTo(int x1, int y1, int x2, int y2) {
        double tX = Math.pow((double)Math.abs(x1 - x2),2);
        double tY = Math.pow((double)Math.abs(y1 - y2),2);
        return (int)Math.sqrt(tX + tY);
    }

    private final void resetTimers() {
        for(int c = 0;c < 10;c++)
            timers[c] = 0;
    }

    private Shell(String user, String pass, int server, String script) {
        shellUserCount++;
        final Shell sh = this;
        sh.user = user.toLowerCase().trim();
        sh.pass = pass.toLowerCase().trim();
        sh.server = server;
        loggedIn = false;
        if(server < 1 || server > 4) {
            System.out.println(user + ": Invalid server - " + server);
            stopShell(sh);
            return;
        }
        map = new Map();
        map.loadTile(50 * 48 + 23, 50 * 48 + 23, 0);
        macro = startScript(script);
        macro.initVars();
        myMacro = new Thread(new Runnable(){public void run() {
            waitForLogin(sh);
            sleep(2000);
            macro.runScript();
            stopShell(sh);
        }});
        myMacro.start();
        myThread = new Thread(new Runnable(){public void run() {
            int wait = 1;
            int iterator = 0;
            int extra = 256;
            for(int c = 0; c < 10; c++)
                timers[c] = System.currentTimeMillis();
            byte[] gotBytes = new byte[5000];
            for(int loop = 0;true;loop &= 0xff) {
                int oldExtra = extra;
                int oldWait = wait;
                extra = 300;
                wait = 1;
                long millis = System.currentTimeMillis();
                if(timers[iterator] == 0L) {
                    extra = oldExtra;
                    wait = oldWait;
                } else if(millis > timers[iterator]) {
                    extra = (int)((long)(2560 * 20) / (millis - timers[iterator]));
                }
                if(extra < 25)
                    extra = 25;
                if(extra > 256) {
                    extra = 256;
                    wait = (int)((long)20 - (millis - timers[iterator]) / 10L);
                    if(wait < 10)
                        wait = 10;
                }
                try {
                    sleep(wait);
                } catch(Exception e) {}
                timers[iterator] = millis;
                iterator = (iterator + 1) % 10;
                if(millis > 1) {
                    for(int c = 0; c < 10; c++)
                        if(timers[c] != 0L)
                            timers[c] += millis;
                }
                for(int inc = 0;loop < 256;) {
                    if(!loggedIn && autoLogin) {
                        loggedIn = Login();
                        if(loggedIn)
                            onLogin();
                    }
                    long l = System.currentTimeMillis();
                    if(Connection.hda())
                        pingTime = l;
                    if(l - pingTime > 5000L) {
                        pingTime = l;
                        Connection.sendID(ID.PING);
                        Connection.endPacket();
                    }
                    try {
                        Connection.hdd(20);
                    } catch(Exception e) {
                        print("Lost connection");
                        loggedIn = Login();
                        if(loggedIn)
                            onLogin();
                    }
                    int value = Connection.hdi(gotBytes);
                    if(value > 0) {
                        int id = update201to203.fixIncomingID(Connection.hdc(gotBytes[0] & 0xff));
                        try {
                            doIDcheck(id,value,gotBytes);
                        } catch(Exception e) {}
                    }
                    sleep(50);
                    if(sleeping && System.currentTimeMillis() - lastChecked > 5000 && !sentWord) {
                        if(sleepFatigue < 5 && fileMod < slFile.lastModified()) {
                            String sleepWord = readLines(slFile,1)[0];
                            print("Sleeping: " + sleepWord);
                            Connection.sendID(ID.SLEEP);
                            Connection.SendString(sleepWord);
                            Connection.endPacket();
                            sentWord = true;
                        }
                        lastChecked = System.currentTimeMillis();
                    }
                    if(loggedIn) {
                        if(fightMode != macro.lockedMode) {
                            fightMode = macro.lockedMode;
                            Connection.sendID(ID.SETMODE);
                            Connection.SendVar(macro.lockedMode);
                            Connection.endPacket();
                        }
                        doPlay();
                    }
                    loop += extra;
                    if(++inc > 1000) {
                        loop = 0;
                        break;
                    }
                }
            }
        }});
        myThread.start();
    }

    private final void reportUser(String playerName, int forWhat) {
        Connection.sendID(ID.REPORTPLAYER);//121
        Connection.sendLong(Convert.PlayerNameToLong(playerName));
        Connection.SendVar(forWhat);
        Connection.SendVar(0);
        Connection.endPacket();
    }

    public static void sleep(int toWait) {
        try {
            Thread.sleep(toWait);
        } catch(Exception e) {}
    }

    private Methods startScript(String scriptName) {
        try {
            Methods tempScript = (Methods)Class.forName(scriptName).newInstance();
            tempScript.sh = this;
            print("Loaded script '" + scriptName + "'");
            return tempScript;
        }
        catch(Exception e) {
            print("Cannot find script '" + scriptName + "'");
            stopShell(this);
            return new Methods();
        }
    }

    public boolean isReachable(int xTo, int yTo) {
        return map.countWayPoints(locX, locY, xTo - tileX, yTo - tileY, xTo - tileX, yTo - tileY, new int[8000], new int[8000], false) != -1;
    }

    public int getItemIndex(int x, int y) {
        for(int c = 0;c < itemCount;c++)
            if(itemX[c] + tileX == x && itemY[c] + tileY == y)
                return c;
        return -1;
    }

    public int getWallObjectIndex(int x, int y) {
        for(int c = 0;c < wallObjectCount;c++)
            if(wallObjectX[c] + tileX == x && wallObjectY[c] + tileY == y)
                return c;
        return -1;
    }

    public int getObjectIndex(int x, int y) {
        for(int c = 0;c < objectCount;c++)
            if(objectX[c] + tileX == x && objectY[c] + tileY == y)
                return c;
        return -1;
    }

    public void forceTo(int xTo, int yTo, int arg2, int arg3, boolean flag) {
        if(!moveTo2(xTo, yTo, arg2, arg3, arg2, arg3, false, flag))
            moveTo(xTo, yTo, arg2, arg3, arg2, arg3, true, flag);
    }

    public void moveNextTo(int objectX, int objectY, int type, int objectID) {
        int extraX;
        int extraY;
        if(type == 0 || type == 4) {
            extraX = Ident.all[objectID];
            extraY = Ident.alm[objectID];
        } else {
            extraY = Ident.all[objectID];
            extraX = Ident.alm[objectID];
        }
        if(Ident.aln[objectID] == 2 || Ident.aln[objectID] == 3) {
            if(type == 0) {
                objectX--;
                extraX++;
            }
            if(type == 2)
                extraY++;
            if(type == 4)
                extraX++;
            if(type == 6) {
                objectY--;
                extraY++;
            }
            moveTo(locX, locY, objectX, objectY, (objectX + extraX) - 1, (objectY + extraY) - 1, false, true);
        }
        else
            moveTo(locX, locY, objectX, objectY, (objectX + extraX) - 1, (objectY + extraY) - 1, true, true);
    }
    
    public void moveToWall(int xTo, int yTo, int Dir) {
        if(Dir == 0)
            moveTo(locX, locY, xTo, yTo - 1, xTo, yTo, false, true);
        else if(Dir == 1)
            moveTo(locX, locY, xTo - 1, yTo, xTo, yTo, false, true);
        else
            moveTo(locX, locY, xTo, yTo, xTo, yTo, true, true);
    }

    public int findShopItem(int itemID) {
        for(int i = 0; i < 40; i++)
            if(shopItemID[i] == itemID)
                return i;
        return -1;
    }

    private final boolean moveTo2(int LocalX, int LocalY, int xTo, int yTo, int arg4, int arg5, boolean arg6, boolean force) // walking?
    {
        int[] xPath = new int[8000];
        int[] yPath = new int[8000];
        int wayCount = map.countWayPoints(LocalX, LocalY, xTo, yTo, arg4, arg5, xPath, yPath, arg6); // reachable value
        if(wayCount == -1)
            return false;
        wayCount--;
        LocalX = xPath[wayCount];
        LocalY = yPath[wayCount];
        wayCount--;
        Connection.sendID(force ? ID.MOVE1 : ID.MOVE2);
        Connection.sendInt(LocalX + tileX);
        Connection.sendInt(LocalY + tileY);
        if(force && wayCount == -1 && (LocalX + tileX) % 5 == 0)
            wayCount = 0;
        for(int c = wayCount; c >= 0 && c > wayCount - 25; c--) {
            Connection.SendVar(xPath[c] - LocalX);
            Connection.SendVar(yPath[c] - LocalY);
        }
        Connection.endPacket();
        return true;
    }

    public boolean moveTo(int localX, int localY, int xTo, int yTo, int arg4, int arg5, boolean arg6,  boolean force) {
        int[] xPath = new int[8000];
        int[] yPath = new int[8000];
        int wayCount = map.countWayPoints(localX, localY, xTo, yTo, arg4, arg5, xPath, yPath, arg6);
        if(wayCount == -1) {
            if(force) {
                wayCount = 1;
                xPath[0] = xTo;
                yPath[0] = yTo;
            }
            else
                return false;
        }
        wayCount--;
        localX = xPath[wayCount];
        localY = yPath[wayCount];
        wayCount--;
        Connection.sendID(force ? ID.MOVE1 : ID.MOVE2);
        Connection.sendInt(localX + tileX);
        Connection.sendInt(localY + tileY);
        if(force && wayCount == -1 && (localX + tileX) % 5 == 0)
            wayCount = 0;
        for(int c = wayCount; c >= 0 && c > wayCount - 25; c--) {
            Connection.SendVar(xPath[c] - localX);
            Connection.SendVar(yPath[c] - localY);
        }
        Connection.endPacket();
        return true;
    }

    private void doPlay() {
        for(int c = 0; c < playerCount; c++) {
            npcObject thPlayer = player[c];
            int pathIndex = (thPlayer.pathIndex + c) % 10;
            if(thPlayer.NewpathIndex != pathIndex) {
                int newDir = -1;
                int OldpathIndex = thPlayer.NewpathIndex;
                int pathDiff;
                if(OldpathIndex < pathIndex)
                    pathDiff = pathIndex - OldpathIndex;
                else
                    pathDiff = (10 + pathIndex) - OldpathIndex;
                int pathAdd = 4;
                if(pathDiff > 2)
                    pathAdd = (pathDiff - 1) * 4;
                if(thPlayer.xCoordPath[OldpathIndex] - thPlayer.xCoord > 128 * 3 || thPlayer.yCoordPath[OldpathIndex] - thPlayer.yCoord > 128 * 3 || thPlayer.xCoordPath[OldpathIndex] - thPlayer.xCoord < -128 * 3 || thPlayer.yCoordPath[OldpathIndex] - thPlayer.yCoord < -128 * 3 || pathDiff > 8) {
                    thPlayer.xCoord = thPlayer.xCoordPath[OldpathIndex];
                    thPlayer.yCoord = thPlayer.yCoordPath[OldpathIndex];
                } else {
                    if(thPlayer.xCoord < thPlayer.xCoordPath[OldpathIndex]) {
                        thPlayer.xCoord += pathAdd;
                        newDir = 2;
                    } else if(thPlayer.xCoord > thPlayer.xCoordPath[OldpathIndex]) {
                        thPlayer.xCoord -= pathAdd;
                        newDir = 6;
                    }
                    if(thPlayer.xCoord - thPlayer.xCoordPath[OldpathIndex] < pathAdd && thPlayer.xCoord - thPlayer.xCoordPath[OldpathIndex] > -pathAdd)
                        thPlayer.xCoord = thPlayer.xCoordPath[OldpathIndex];
                    if(thPlayer.yCoord < thPlayer.yCoordPath[OldpathIndex]) {
                        thPlayer.yCoord += pathAdd;
                        if(newDir == -1)
                            newDir = 4;
                        else if(newDir == 2)
                            newDir = 3;
                        else
                            newDir = 5;
                    } else if(thPlayer.yCoord > thPlayer.yCoordPath[OldpathIndex]) {
                        thPlayer.yCoord -= pathAdd;
                        if(newDir == -1)
                            newDir = 0;
                        else if(newDir == 2)
                            newDir = 1;
                        else
                            newDir = 7;
                    }
                    if(thPlayer.yCoord - thPlayer.yCoordPath[OldpathIndex] < pathAdd && thPlayer.yCoord - thPlayer.yCoordPath[OldpathIndex] > -pathAdd)
                        thPlayer.yCoord = thPlayer.yCoordPath[OldpathIndex];
                }
                if(newDir != -1)
                    thPlayer.Dir = newDir;
                if(thPlayer.xCoord == thPlayer.xCoordPath[OldpathIndex] && thPlayer.yCoord == thPlayer.yCoordPath[OldpathIndex])
                    thPlayer.NewpathIndex = (OldpathIndex + 1) % 10;
            }
            else
                thPlayer.Dir = thPlayer.newDir;
            if(thPlayer.talkVar > 0)
                thPlayer.talkVar--;
            if(thPlayer.combatVar > 0)
                thPlayer.combatVar--;
        }
        for(int c = 0; c < npcCount; c++) {
            npcObject thNpc = npc[c];
            int pathIndex = (thNpc.pathIndex + 1) % 10;
            if(thNpc.NewpathIndex != pathIndex) {
                int newDir = -1;
                int OldpathIndex = thNpc.NewpathIndex;
                int pathDiff;
                if(OldpathIndex < pathIndex)
                    pathDiff = pathIndex - OldpathIndex;
                else
                    pathDiff = (10 + pathIndex) - OldpathIndex;
                int pathAdd = 4;
                if(pathDiff > 2)
                    pathAdd = (pathDiff - 1) * 4;
                if(thNpc.xCoordPath[OldpathIndex] - thNpc.xCoord > 128 * 3 || thNpc.yCoordPath[OldpathIndex] - thNpc.yCoord > 128 * 3 || thNpc.xCoordPath[OldpathIndex] - thNpc.xCoord < -128 * 3 || thNpc.yCoordPath[OldpathIndex] - thNpc.yCoord < -128 * 3 || pathDiff > 8) {
                    thNpc.xCoord = thNpc.xCoordPath[OldpathIndex];
                    thNpc.yCoord = thNpc.yCoordPath[OldpathIndex];
                } else {
                    if(thNpc.xCoord < thNpc.xCoordPath[OldpathIndex]) {
                        thNpc.xCoord += pathAdd;
                        newDir = 2;
                    } else if(thNpc.xCoord > thNpc.xCoordPath[OldpathIndex]) {
                        thNpc.xCoord -= pathAdd;
                        newDir = 6;
                    }
                    if(thNpc.xCoord - thNpc.xCoordPath[OldpathIndex] < pathAdd && thNpc.xCoord - thNpc.xCoordPath[OldpathIndex] > -pathAdd)
                        thNpc.xCoord = thNpc.xCoordPath[OldpathIndex];
                    if(thNpc.yCoord < thNpc.yCoordPath[OldpathIndex]) {
                        thNpc.yCoord += pathAdd;
                        if(newDir == -1)
                            newDir = 4;
                        else if(newDir == 2)
                            newDir = 3;
                        else
                            newDir = 5;
                    } else if(thNpc.yCoord > thNpc.yCoordPath[OldpathIndex]) {
                        thNpc.yCoord -= pathAdd;
                        if(newDir == -1)
                            newDir = 0;
                        else if(newDir == 2)
                            newDir = 1;
                        else
                            newDir = 7;
                    }
                    if(thNpc.yCoord - thNpc.yCoordPath[OldpathIndex] < pathAdd && thNpc.yCoord - thNpc.yCoordPath[OldpathIndex] > -pathAdd)
                        thNpc.yCoord = thNpc.yCoordPath[OldpathIndex];
                }
                if(newDir != -1)
                    thNpc.Dir = newDir;
                if(thNpc.xCoord == thNpc.xCoordPath[OldpathIndex] && thNpc.yCoord == thNpc.yCoordPath[OldpathIndex])
                    thNpc.NewpathIndex = (OldpathIndex + 1) % 10;
            }
            else
                thNpc.Dir = thNpc.newDir;
            if(thNpc.talkVar > 0)
                thNpc.talkVar--;
            if(thNpc.combatVar > 0)
                thNpc.combatVar--;
        }
    }

    public static boolean inArray(String[] toSearch, String toFind) {
        for(int c = 0;c < toSearch.length;c++)
            if(toSearch[c].equalsIgnoreCase(toFind))
                return true;
        return false;
    }

    public static boolean inArray(int[] toSearch, int toFind) {
        for(int c = 0;c < toSearch.length;c++)
            if(toSearch[c] == toFind)
                return true;
        return false;
    }

    private void doIDcheck(int packetID, int value, byte[] bytes)throws Exception {
        if(packetID == 168) {
            macro.OnServerMessage(new String(bytes, 1, value - 1).toLowerCase().replaceAll("@gam@",""));
        } else if(packetID == 125) {
            debug("Forced logout by server");
            try {
                Connection.sendID(ID.LOGREPLY);
                Connection.endPacket1();
            } catch(Exception e) {}
            loggedIn = false;
        } else if(packetID == 67) {
            print("Sorry, you can't logout at the moment");
        } else if(packetID == 54) {
            friendCount = Convert.extractInt(bytes[1]);
            for(int c = 0; c < friendCount; c++) {
                friendList[c] = Convert.PlayerLongToName(Convert.extractLong(bytes, 2 + c * 9));
                friendServer[c] = Convert.extractInt(bytes[10 + c * 9]);
            }
        } else if(packetID == 248) {
            String playerName = Convert.PlayerLongToName(Convert.extractLong(bytes, 1)).toLowerCase();
            int playerServer = bytes[9] & 0xff;
            for(int c = 0; c < friendCount; c++)
                if(friendList[c].equals(playerName)) {
                    if(friendServer[c] == 0 && playerServer != 0) {
                        debug(playerName + " has logged in");
                        if(playerName.startsWith("mod ") || playerName.equals("andrew") || playerName.equals("paul"))
                            onMod(playerName, 2);
                    }
                    if(friendServer[c] != 0 && playerServer == 0)
                        debug(playerName + " has logged out");
                    friendServer[c] = playerServer;
                    return;
                }
            friendList[friendCount] = playerName;
            friendServer[friendCount] = playerServer;
            friendCount++;
        } else if(packetID == 230) {
            String message = Convert.extractString(bytes, 13, value - 13).toLowerCase();
            String playerName = Convert.PlayerLongToName(Convert.extractLong(bytes, 1)).toLowerCase();
            debug("PM received from " + playerName + ": " + message);
            macro.OnPrivateMessage(playerName, message);
        } else if(packetID == 141) {
            int oldPlayerCount = playerCount;
            npcObject[] oldPlayer = new npcObject[oldPlayerCount];
            for(int c = 0; c < oldPlayerCount; c++)
                oldPlayer[c] = player[c];
            int bytePoint = 8;
            locX = Convert.extractIntBounds(bytes, bytePoint, 11);
            bytePoint += 11;
            locY = Convert.extractIntBounds(bytes, bytePoint, 13);
            bytePoint += 13;
            int type = Convert.extractIntBounds(bytes, bytePoint, 4);
            bytePoint += 4;
            boolean flag = loadTile(locX,locY);
            locX -= tileX;
            locY -= tileY;
            int tX = locX * 128 + 64;
            int tY = locY * 128 + 64;
            if(flag) {
                my.pathIndex = 0;
                my.NewpathIndex = 0;
                my.xCoord = my.xCoordPath[0] = tX;
                my.yCoord = my.yCoordPath[0] = tY;
            }
            playerCount = 0;
            my = newPlayer(myNewID, tX, tY, type, oldPlayer);
            int loops = Convert.extractIntBounds(bytes, bytePoint, 8);
            bytePoint += 8;
            for(int c = 0; c < loops; c++) {
                npcObject thPlayer = oldPlayer[c + 1];
                if(Convert.extractIntBounds(bytes, bytePoint++, 1) != 0) {
                    if(Convert.extractIntBounds(bytes, bytePoint++, 1) == 0) {
                        type = Convert.extractIntBounds(bytes, bytePoint, 3);
                        bytePoint += 3;
                        int pathIndex = thPlayer.pathIndex;
                        int xPath = thPlayer.xCoordPath[pathIndex];
                        int yPath = thPlayer.yCoordPath[pathIndex];
                        if(type == 2 || type == 1 || type == 3)
                            xPath += 128;
                        if(type == 6 || type == 5 || type == 7)
                            xPath -= 128;
                        if(type == 4 || type == 3 || type == 5)
                            yPath += 128;
                        if(type == 0 || type == 1 || type == 7)
                            yPath -= 128;
                        thPlayer.newDir = type;
                        thPlayer.pathIndex = pathIndex = (pathIndex + 1) % 10;
                        thPlayer.xCoordPath[pathIndex] = xPath;
                        thPlayer.yCoordPath[pathIndex] = yPath;
                    } else {
                        if((Convert.extractIntBounds(bytes, bytePoint, 4) & 0xc) == 12) {
                            bytePoint += 2;
                            continue;
                        }
                        thPlayer.newDir = Convert.extractIntBounds(bytes, bytePoint, 4);
                        bytePoint += 4;
                    }
                }
                player[playerCount++] = thPlayer;
            }
            int extraCount = 0;
            int[] newpID = new int[500];
            while(bytePoint + 24 < value * 8) {
                int pID = Convert.extractIntBounds(bytes, bytePoint, 11);
                bytePoint += 11;
                tX = Convert.extractIntBounds(bytes, bytePoint, 5);
                bytePoint += 5;
                if(tX > 15)
                    tX -= 32;
                tY = Convert.extractIntBounds(bytes, bytePoint, 5);
                bytePoint += 5;
                if(tY > 15)
                    tY -= 32;
                int tID = Convert.extractIntBounds(bytes, bytePoint, 4);
                bytePoint += 4;
                tX = (locX + tX) * 128 + 64;
                tY = (locY + tY) * 128 + 64;
                newPlayer(pID, tX, tY, tID, oldPlayer);
                if(Convert.extractIntBounds(bytes, bytePoint++, 1) == 0)
                    newpID[extraCount++] = pID;
            }
            if(extraCount > 0) {
                Connection.sendID(ID.PID);
                Connection.sendInt(extraCount);
                for(int c = 0; c < extraCount; c++) {
                    npcObject thPlayer = player[newpID[c]];
                    Connection.sendInt(thPlayer.pID);
                    Connection.sendInt(thPlayer.gmg);
                }
                Connection.endPacket();
                extraCount = 0;
            }
        } else if(packetID == 172) {
            debug("Adding items to Tile");
            int bytePoint = 1;
            while(bytePoint < value) {
                if(Convert.extractInt(bytes[bytePoint]) == 255) {
                    int extraCount = 0;
                    bytePoint++;
                    int itmX = locX + bytes[bytePoint++] >> 3;
                    int itmY = locY + bytes[bytePoint++] >> 3;
                    for(int c = 0; c < itemCount; c++) {
                        if((itemX[c] >> 3) - itmX != 0 || (itemY[c] >> 3) - itmY != 0) {
                            if(c != extraCount) {
                                itemX[extraCount] = itemX[c];
                                itemY[extraCount] = itemY[c];
                                itemID[extraCount] = itemID[c];
                            }
                            extraCount++;
                        }
                    }
                    itemCount = extraCount;
                } else {
                    int itmID = Convert.extractIntFrom(bytes, bytePoint);
                    bytePoint += 2;
                    int itmX = locX + bytes[bytePoint++];
                    int itmY = locY + bytes[bytePoint++];
                    if((itmID & 0x8000) == 0) {
                        itemX[itemCount] = itmX;
                        itemY[itemCount] = itmY;
                        itemID[itemCount] = itmID;
                        itemCount++;
                    } else {
                        itmID &= 0x7fff;
                        int extraCount = 0;
                        for(int c = 0; c < itemCount; c++)
                            if(itemX[c] != itmX || itemY[c] != itmY || itemID[c] != itmID) {
                                if(c != extraCount) {
                                    itemX[extraCount] = itemX[c];
                                    itemY[extraCount] = itemY[c];
                                    itemID[extraCount] = itemID[c];
                                }
                                extraCount++;
                            }
                            else
                                itmID = -123;
                        itemCount = extraCount;
                    }
                }
            }
        } else if(packetID == 158) {
            debug("Adding objects to Tile");
            int bytePoint = 1;
            while(bytePoint < value) {
                if(Convert.extractInt(bytes[bytePoint]) == 255) {
                    int extraCount = 0;
                    bytePoint++;
                    int objX = locX + bytes[bytePoint++] >> 3;
                    int objY = locY + bytes[bytePoint++] >> 3;
                    for(int c = 0; c < objectCount; c++) {
                        if((objectX[c] >> 3) - objX != 0 || (objectY[c] >> 3) - objY != 0) {
                            if(c != extraCount) {
                                objectX[extraCount] = objectX[c];
                                objectY[extraCount] = objectY[c];
                                objectID[extraCount] = objectID[c];
                                objectDir[extraCount] = objectDir[c];
                            }
                            extraCount++;
                        } else
                            map.addObject1(objectX[c], objectY[c], objectID[c]);
                    }
                    objectCount = extraCount;
                } else {
                    int objID = Convert.extractIntFrom(bytes, bytePoint);
                    bytePoint += 2;
                    int extraCount = 0;
                    int objX = locX + bytes[bytePoint++];
                    int objY = locY + bytes[bytePoint++];
                    for(int c = 0; c < objectCount; c++) {
                        if(objectX[c] != objX || objectY[c] != objY) {
                            if(c != extraCount) {
                                objectX[extraCount] = objectX[c];
                                objectY[extraCount] = objectY[c];
                                objectID[extraCount] = objectID[c];
                                objectDir[extraCount] = objectDir[c];
                            }
                            extraCount++;
                        } else
                            map.addObject1(objectX[c], objectY[c], objectID[c]);
                    }
                    objectCount = extraCount;
                    if(objID != 60000) {
                        map.addObject(objX, objY, objID);
                        objectX[objectCount] = objX;
                        objectY[objectCount] = objY;
                        objectID[objectCount] = objID;
                        objectDir[objectCount] = map.gjh(objX, objY);
                        objectCount++;
                    }
                }
            }
        } else if(packetID == 37) {
            int bytePoint = 1;
            invCount = bytes[bytePoint++] & 0xff;
            debug("Inventory updated (total of " + invCount + " items)");
            for(int c = 0; c < invCount; c++) {
                int val = Convert.extractIntFrom(bytes, bytePoint);
                bytePoint += 2;
                invItemID[c] = val & 0x7fff;
                invItemWearing[c] = (val / 32768) == 1;
                if(Ident.ItemStackableVar[val & 0x7fff] == 0) {
                    invItemCount[c] = Convert.extractIntSelect(bytes, bytePoint);
                    if(invItemCount[c] >= 128)
                        bytePoint += 4;
                    else
                        bytePoint++;
                }
                else
                    invItemCount[c] = 1;
            }
        } else if(packetID == 183) {
            int loop = Convert.extractIntFrom(bytes, 1);
            int bytePoint = 3;
            for(int c = 0; c < loop; c++) {
                int playerIndex = Convert.extractIntFrom(bytes, bytePoint);
                bytePoint += 2;
                npcObject thPlayer = player[playerIndex];
                byte doWhat = bytes[bytePoint++];
                if(doWhat == 0) {
                    bytePoint += 2;
                } else if(doWhat == 1) {
                    byte length = bytes[bytePoint++];
                    if(thPlayer != null) {
                        debug("Player talking");
                        String message = Convert.extractString(bytes, bytePoint, length);
                        thPlayer.talkVar = 150;
                        macro.OnChatMessage(thPlayer.name,message);
                    }
                    bytePoint += length;
                } else if(doWhat == 2) {
                    bytePoint++;
                    int curHits = Convert.extractInt(bytes[bytePoint++]);
                    int maxHits = Convert.extractInt(bytes[bytePoint++]);
                    if(thPlayer != null) {
                        debug("Updating player stats");
                        thPlayer.curHits = curHits;
                        thPlayer.maxHits = maxHits;
                        thPlayer.combatVar = 200;
                        if(thPlayer == my) {
                            statCurLevel[3] = curHits;
                            statMaxLevel[3] = maxHits;
                        }
                    }
                } else if(doWhat == 3 || doWhat == 4) {
                    bytePoint += 4;
                } else if(doWhat == 5) {
                    if(thPlayer != null) {
                        debug("Updating player stats and Name");
                        thPlayer.gmg = Convert.extractIntFrom(bytes, bytePoint);
                        bytePoint += 2;
                        thPlayer.name = Convert.PlayerLongToName(Convert.extractLong(bytes, bytePoint)).toLowerCase();
                        bytePoint += 8;
                        int temp = Convert.extractInt(bytes[bytePoint++]);
                        bytePoint += temp;
                        bytePoint += 4;
                        thPlayer.combat = bytes[bytePoint] & 0xff;
                        bytePoint += 2;
                    } else {
                        bytePoint += 14;
                        bytePoint += Convert.extractInt(bytes[bytePoint]) + 1;
                    }
                } else if(doWhat == 6) {
                    byte length = bytes[bytePoint++];
                    if(thPlayer != null) {
                        String message = Convert.extractString(bytes, bytePoint, length);
                        thPlayer.talkVar = 150;
                        if(thPlayer == my) {
                            debug("I am talking");
                            macro.OnChatMessage(thPlayer.name,message);
                        }
                    }
                    bytePoint += length;
                }
            }
        } else if(packetID == 29) {
            debug("Adding wallObjects to Tile");
            int bytePoint = 1;
            while(bytePoint < value) {
                if(Convert.extractInt(bytes[bytePoint]) == 255) {
                    int extraCount = 0;
                    bytePoint++;
                    int wallX = locX + bytes[bytePoint++] >> 3;
                    int wallY = locY + bytes[bytePoint++] >> 3;
                    for(int c = 0; c < wallObjectCount; c++) {
                        if((wallObjectX[c] >> 3) - wallX != 0 || (wallObjectY[c] >> 3) - wallY != 0) {
                            if(c != extraCount) {
                                wallObjectX[extraCount] = wallObjectX[c];
                                wallObjectY[extraCount] = wallObjectY[c];
                                wallObjectDir[extraCount] = wallObjectDir[c];
                                wallObjectID[extraCount] = wallObjectID[c];
                            }
                            extraCount++;
                        } else
                            map.addWallObject1(wallObjectX[c], wallObjectY[c], wallObjectDir[c], wallObjectID[c]);
                    }
                    wallObjectCount = extraCount;
                } else {
                    int wallID = Convert.extractIntFrom(bytes, bytePoint);
                    bytePoint += 2;
                    int wallX = locX + bytes[bytePoint++];
                    int wallY = locY + bytes[bytePoint++];
                    byte wallDir = bytes[bytePoint++];
                    int extraCount = 0;
                    for(int c = 0; c < wallObjectCount; c++) {
                        if(wallObjectX[c] != wallX || wallObjectY[c] != wallY || wallObjectDir[c] != wallDir) {
                            if(c != extraCount) {
                                wallObjectX[extraCount] = wallObjectX[c];
                                wallObjectY[extraCount] = wallObjectY[c];
                                wallObjectDir[extraCount] = wallObjectDir[c];
                                wallObjectID[extraCount] = wallObjectID[c];
                            }
                            extraCount++;
                        } else
                            map.addWallObject1(wallObjectX[c], wallObjectY[c], wallObjectDir[c], wallObjectID[c]);
                    }
                    wallObjectCount = extraCount;
                    if(wallID != 65535) {
                        map.addWallObject(wallX, wallY, wallDir, wallID);
                        wallObjectX[wallObjectCount] = wallX;
                        wallObjectY[wallObjectCount] = wallY;
                        wallObjectID[wallObjectCount] = wallID;
                        wallObjectDir[wallObjectCount] = wallDir;
                        wallObjectCount++;
                    }
                }
            }
        } else if(packetID == 41) {
            int oldNpcCount = npcCount;
            npcObject[] oldNpc = new npcObject[oldNpcCount];
            npcCount = 0;
            for(int c = 0; c < oldNpcCount; c++)
                oldNpc[c] = npc[c];
            int bytePoint = 8;
            int loops = Convert.extractIntBounds(bytes, bytePoint, 8);
            bytePoint += 8;
            for(int c = 0; c < loops; c++) {
                npcObject thNpc = oldNpc[c];
                if(Convert.extractIntBounds(bytes, bytePoint++, 1) != 0) {
                    if(Convert.extractIntBounds(bytes, bytePoint++, 1) == 0) {
                        int type = Convert.extractIntBounds(bytes, bytePoint, 3);
                        bytePoint += 3;
                        int pathIndex = thNpc.pathIndex;
                        int xPath = thNpc.xCoordPath[pathIndex];
                        int yPath = thNpc.yCoordPath[pathIndex];
                        if(type == 2 || type == 1 || type == 3)
                            xPath += 128;
                        if(type == 6 || type == 5 || type == 7)
                            xPath -= 128;
                        if(type == 4 || type == 3 || type == 5)
                            yPath += 128;
                        if(type == 0 || type == 1 || type == 7)
                            yPath -= 128;
                        thNpc.newDir = type;
                        thNpc.pathIndex = pathIndex = (pathIndex + 1) % 10;
                        thNpc.xCoordPath[pathIndex] = xPath;
                        thNpc.yCoordPath[pathIndex] = yPath;
                    } else {
                        if((Convert.extractIntBounds(bytes, bytePoint, 4) & 0xc) == 12) {
                            bytePoint += 2;
                            continue;
                        }
                        thNpc.newDir = Convert.extractIntBounds(bytes, bytePoint, 4);
                        bytePoint += 4;
                    }
                }
                npc[npcCount++] = thNpc;
            }
            while(bytePoint + 34 < value * 8)  {
                int pID = Convert.extractIntBounds(bytes, bytePoint, 12);
                bytePoint += 12;
                int tX = Convert.extractIntBounds(bytes, bytePoint, 5);
                bytePoint += 5;
                if(tX > 15)
                    tX -= 32;
                int tY = Convert.extractIntBounds(bytes, bytePoint, 5);
                bytePoint += 5;
                if(tY > 15)
                    tY -= 32;
                int type = Convert.extractIntBounds(bytes, bytePoint, 4);
                bytePoint += 4;
                tX = (locX + tX) * 128 + 64;
                tY = (locY + tY) * 128 + 64;
                int tID = Convert.extractIntBounds(bytes, bytePoint, 10);
                bytePoint += 10;
                if(tID >= Ident.NpcTotalCount)
                    tID = 24;
                newNpc(pID, tX, tY, type, tID, oldNpc);
            }
        } else if(packetID == 47) {
            int bytePoint = 3;
            for(int c = 0; c < Convert.extractIntFrom(bytes, 1); c++) {
                int npcIndex = Convert.extractIntFrom(bytes, bytePoint);
                bytePoint += 2;
                npcObject thNpc = npc[npcIndex];
                int doWhat = Convert.extractInt(bytes[bytePoint++]);
                if(doWhat == 1) {
                    if(Convert.extractIntFrom(bytes, bytePoint) != my.pID)
                        return;
                    debug("An npc is talking to me");
                    bytePoint += 2;
                    byte Tbyte = bytes[bytePoint++];
                    if(thNpc != null)
                        macro.OnChatMessage(Ident.NpcName[thNpc.ID],Convert.extractString(bytes, bytePoint, Tbyte));
                    bytePoint += Tbyte;
                } else if(doWhat == 2) {
                    debug("Updating npc hits");
                    bytePoint++;
                    int curHits = Convert.extractInt(bytes[bytePoint++]);
                    int maxHits = Convert.extractInt(bytes[bytePoint++]);
                    if(thNpc != null) {
                        thNpc.curHits = curHits;
                        thNpc.maxHits = maxHits;
                        thNpc.combatVar = 200;
                    }
                }
            }
        } else if(packetID == 117) {
            questMenu = true;
            questMenuCount = Convert.extractInt(bytes[1]);
            debug("questMenu opened with " + questMenuCount + " options");
            int bytePoint = 2;
            for(int c = 0; c < questMenuCount; c++) {
                int lineEnd = Convert.extractInt(bytes[bytePoint]);
                bytePoint++;
                questMenuOptions[c] = new String(bytes, bytePoint, lineEnd).toLowerCase();
                bytePoint += lineEnd;
            }
        } else if(packetID == 208) {
            debug("questMenu closed");
            questMenu = false;
        } else if(packetID == 249) {
            debug("New Tile values set");
            myNewID = Convert.extractIntFrom(bytes, 1);
            tileXoff = Convert.extractIntFrom(bytes, 3);
            tileYoff = Convert.extractIntFrom(bytes, 5);
            toLoad = Convert.extractIntFrom(bytes, 7);
            tileYoff -= toLoad * Convert.extractIntFrom(bytes, 9);
        } else if(packetID == 16) {
            debug("My skill levels & quest points updated");
            int bytePoint = 1;
            for(int c = 0; c < 18; c++)
                statCurLevel[c] = Convert.extractInt(bytes[bytePoint++]);
            for(int c = 0; c < 18; c++)
                statMaxLevel[c] = Convert.extractInt(bytes[bytePoint++]);
            for(int c = 0; c < 18; c++) {
                statTotalExp[c] = Convert.extractLongFrom(bytes, bytePoint) / 4;
                bytePoint += 4;
            }
            questPoints = Convert.extractInt(bytes[bytePoint++]);
        } else if(packetID == 33) {
            debug("Armour stats updated");
            for(int c = 0; c < 5; c++)
                armourStats[c] = Convert.extractInt(bytes[c + 1]);
        } else if(packetID == 109) {
            debug("We died");
            onDied();
        } else if(packetID == 76) {
            debug("Updating items objects and wallobjects");
            for(int i11 = 0; i11 < (value - 1) / 4; i11++) {
                int thX = locX + Convert.extractIntProc(bytes, 1 + i11 * 4) >> 3;
                int thY = locY + Convert.extractIntProc(bytes, 3 + i11 * 4) >> 3;
                int extraCount = 0;
                for(int c = 0; c < itemCount; c++) {
                    if((itemX[c] >> 3) - thX != 0 || (itemY[c] >> 3) - thY != 0) {
                        if(c != extraCount) {
                            itemX[extraCount] = itemX[c];
                            itemY[extraCount] = itemY[c];
                            itemID[extraCount] = itemID[c];
                        }
                        extraCount++;
                    }
                }
                itemCount = extraCount;
                extraCount = 0;
                for(int c = 0; c < objectCount; c++) {
                    if((objectX[c] >> 3) - thX != 0 || (objectY[c] >> 3) - thY != 0) {
                        if(c != extraCount) {
                            objectX[extraCount] = objectX[c];
                            objectY[extraCount] = objectY[c];
                            objectID[extraCount] = objectID[c];
                            objectDir[extraCount] = objectDir[c];
                        }
                        extraCount++;
                    } else
                        map.addObject1(objectX[c], objectY[c], objectID[c]);
                }
                objectCount = extraCount;
                extraCount = 0;
                for(int c = 0; c < wallObjectCount; c++) {
                    if((wallObjectX[c] >> 3) - thX != 0 || (wallObjectY[c] >> 3) - thY != 0) {
                        if(c != extraCount) {
                            wallObjectX[extraCount] = wallObjectX[c];
                            wallObjectY[extraCount] = wallObjectY[c];
                            wallObjectDir[extraCount] = wallObjectDir[c];
                            wallObjectID[extraCount] = wallObjectID[c];
                        }
                        extraCount++;
                    } else
                        map.addWallObject1(wallObjectX[c], wallObjectY[c], wallObjectDir[c], wallObjectID[c]);
                }
                wallObjectCount = extraCount;
            }
        } else if(packetID == 7) {
            print("Character still in design stage, giving random outfit");
            int[] stuff = {0,3,5,6,7};
            Connection.sendID(ID.DESIGN);
            Connection.SendVar(1);
            Connection.SendVar(stuff[Functions.Rand(0,stuff.length - 1)]);
            Connection.SendVar(1);
            Connection.SendVar(2);
            Connection.SendVar(Functions.Rand(0,9));
            Connection.SendVar(Functions.Rand(0,14));
            Connection.SendVar(Functions.Rand(0,14));
            Connection.SendVar(Functions.Rand(0,4));
            Connection.endPacket();
        } else if(packetID == 108) {
            int playerIndex = Convert.extractIntFrom(bytes, 1);
            if(player[playerIndex] != null)
                tradeOpponentName = player[playerIndex].name;
            debug("tradeScreen1 opened with " + tradeOpponentName);
            tradeScreen1 = true;
            myTradeAccepted1 = opponentTradeAccepted = false;
            myTradeIndex = opponentTradeIndex = 0;
        } else if(packetID == 113) {
            debug("tradeScreen closed");
            tradeScreen1 = tradeScreen2 = false;
        } else if(packetID == 155) {
            debug("Updating opponents trade offer");
            opponentTradeIndex = bytes[1] & 0xff;
            int bytePoint = 2;
            for(int c = 0; c < opponentTradeIndex; c++) {
                opponentTradeItemID[c] = Convert.extractIntFrom(bytes, bytePoint);
                bytePoint += 2;
                opponentTradeItemAmount[c] = Convert.extractLongFrom(bytes, bytePoint);
                bytePoint += 4;
            }
            opponentTradeAccepted = myTradeAccepted1 = false;
        } else if(packetID == 185) {
            debug("opponentTradeAccepted updated");
            opponentTradeAccepted = (bytes[1] == 1);
        } else if(packetID == 24) {
            inShop = true;
            int bytePoint = 1;
            int shopCount = bytes[bytePoint] & 0xff;
            bytePoint += 2;
            shopSellVar = bytes[bytePoint++] & 0xff;
            shopBuyVar = bytes[bytePoint++] & 0xff;
            for(int c = 0; c < 40; c++)
                shopItemID[c] = -1;
            for(int c = 0; c < shopCount; c++) {
                shopItemID[c] = Convert.extractIntFrom(bytes, bytePoint);
                bytePoint += 2;
                shopItemCount[c] = Convert.extractIntFrom(bytes, bytePoint);
                bytePoint += 2;
                shopItemPrice[c] = bytes[bytePoint++];
            }
        } else if(packetID == 42) {
            debug("Shop closed");
            inShop = false;
        } else if(packetID == 170) {
            debug("myTradeAccepted1 updated");
            myTradeAccepted1 = (bytes[1] == 1);
        } else if(packetID == 222) {
            debug("Update prayers on/off");
            for(int c = 0; c < value - 1; c++)
                prayOn[c] = (bytes[c + 1] == 1);
        } else if(packetID == 26) {
            debug("Update quests completed");
            for(int c = 0; c < 50; c++)
                questComplete[c] = (bytes[c + 1] == 1);
        } else if(packetID == 188) {
            debug("Opening bank");
            inBank = true;
            int bytePoint = 1;
            bankCount = bytes[bytePoint++] & 0xff;
            bytePoint++;
            for(int c = 0; c < bankCount; c++) {
                bankItemID[c] = Convert.extractIntFrom(bytes, bytePoint);
                bytePoint += 2;
                bankItemCount[c] = Convert.extractIntSelect(bytes, bytePoint);
                if(bankItemCount[c] >= 128)
                    bytePoint += 4;
                else
                    bytePoint++;
            }
        } else if(packetID == 130) {
            debug("Bank closed");
            inBank = false;
        } else if(packetID == 69) {
            int statIndex = bytes[1] & 0xff;
            debug("Exp for stat #" + statIndex + " updated");
            statTotalExp[statIndex] = Convert.extractLongFrom(bytes, 2) / 4;
        } else if(packetID == 240) {
            int playerIndex = Convert.extractIntFrom(bytes, 1);
            if(player[playerIndex] != null)
                duelOpponentName = player[playerIndex].name;
            debug("duelScreen1 opened with " + duelOpponentName);
            duelScreen1 = true;
            myDuelIndex = opponentDuelIndex = 0;
            myDuelAccepted1 = opponentDuelAccepted = false;
            DuelnoRetreat = DuelnoMagic = DuelnoPrayer = DuelnoWeapons = false;
        } else if(packetID == 198) {
            debug("duelScreen closed");
            duelScreen1 = duelScreen2 = false;
        } else if(packetID == 128) {
            tradeScreen2 = true;
            tradeScreen1 = myTradeAccepted2 = false;
            int bytePoint = 1;
            tradeOpponentName = Convert.PlayerLongToName(Convert.extractLong(bytes, bytePoint)).toLowerCase();
            debug("tradeScreen2 opened with " + tradeOpponentName);
            bytePoint += 8;
            myTradeCount = bytes[bytePoint++] & 0xff;
            for(int c = 0; c < myTradeCount; c++) {
                myTradeItemID[c] = Convert.extractIntFrom(bytes, bytePoint);
                bytePoint += 2;
                myTradeItemAmount[c] = Convert.extractLongFrom(bytes, bytePoint);
                bytePoint += 4;
            }
            opponentTradeCount = bytes[bytePoint++] & 0xff;
            for(int c = 0; c < opponentTradeCount; c++) {
                opponentTradeItemID[c] = Convert.extractIntFrom(bytes, bytePoint);
                bytePoint += 2;
                opponentTradeItemAmount[c] = Convert.extractLongFrom(bytes, bytePoint);
                bytePoint += 4;
            }
        } else if(packetID == 229) {
            debug("Updating opponents duel offer");
            opponentDuelCount = bytes[1] & 0xff;
            int bytePoint = 2;
            for(int c = 0; c < opponentDuelCount; c++) {
                opponentDuelItemID[c] = Convert.extractIntFrom(bytes, bytePoint);
                bytePoint += 2;
                opponentDuelItemAmount[c] = Convert.extractLongFrom(bytes, bytePoint);
                bytePoint += 4;
            }
            myDuelAccepted1 = opponentDuelAccepted = false;
        } else if(packetID == 211) {
            debug("Duel options updated");
            DuelnoRetreat = (bytes[1] == 1);
            DuelnoMagic = (bytes[2] == 1);
            DuelnoPrayer = (bytes[3] == 1);
            DuelnoWeapons = (bytes[4] == 1);
            myDuelAccepted1 = opponentDuelAccepted = false;
        } else if(packetID == 81) {
            int bytePoint = 1;
            int bankPos = bytes[bytePoint++] & 0xff;
            debug("Updating item at position " + bankPos + " in bank");
            int itemID = Convert.extractIntFrom(bytes, bytePoint);
            bytePoint += 2;
            int ammount = Convert.extractIntSelect(bytes, bytePoint);
            if(ammount >= 128)
                bytePoint += 4;
            else
                bytePoint++;
            if(ammount == 0) {
                bankCount--;
                for(int c = bankPos; c < bankCount; c++) {
                    bankItemID[c] = bankItemID[c + 1];
                    bankItemCount[c] = bankItemCount[c + 1];
                }
            } else {
                bankItemID[bankPos] = itemID;
                bankItemCount[bankPos] = ammount;
                if(bankPos >= bankCount)
                    bankCount = bankPos + 1;
            }
        } else if(packetID == 210) {
            int bytePoint = 1;
            int itemIndex = bytes[bytePoint++] & 0xff;
            debug("Updating inventory item #" + itemIndex);
            int val = Convert.extractIntFrom(bytes, bytePoint);
            bytePoint += 2;
            int thisItemCount = 1;
            if(Ident.ItemStackableVar[val & 0x7fff] == 0) {
                thisItemCount = Convert.extractIntSelect(bytes, bytePoint);
                if(thisItemCount >= 128)
                    bytePoint += 4;
                else
                    bytePoint++;
            }
            invItemID[itemIndex] = val & 0x7fff;
            invItemWearing[itemIndex] = (val / 32768 == 1);
            invItemCount[itemIndex] = thisItemCount;
            if(itemIndex>= invCount)
                invCount = itemIndex + 1;
        } else if(packetID == 44) {
            debug("Inventory item removed");
            invCount--;
            for(int c = (bytes[1] & 0xff); c < invCount; c++) {
                invItemID[c] = invItemID[c + 1];
                invItemCount[c] = invItemCount[c + 1];
                invItemWearing[c] = invItemWearing[c + 1];
            }
        } else if(packetID == 23) {
            int bytePoint = 1;
            int statIndex = bytes[bytePoint++] & 0xff;
            debug("Updating stat #" + statIndex);
            statCurLevel[statIndex] = Convert.extractInt(bytes[bytePoint++]);
            statMaxLevel[statIndex] = Convert.extractInt(bytes[bytePoint++]);
            statTotalExp[statIndex] = Convert.extractLongFrom(bytes, bytePoint) / 4;
            bytePoint += 4;
        } else if(packetID == 73) {
            debug("opponentDuelAccepted updated");
            opponentDuelAccepted = (bytes[1] == 1);
        } else if(packetID == 131) {
            debug("myDuelAccepted1 updated");
            myDuelAccepted1 = (bytes[1] == 1);
        } else if(packetID == 10) {
            duelScreen2 = true;
            myDuelAccepted2 = duelScreen1 = false;
            int bytePoint = 1;
            duelOpponentName = Convert.PlayerLongToName(Convert.extractLong(bytes, bytePoint)).toLowerCase();
            debug("duelScreen2 opened with " + duelOpponentName);
            bytePoint += 8;
            opponentDuelCount = bytes[bytePoint++] & 0xff;
            for(int c = 0; c < opponentDuelCount; c++) {
                opponentDuelItemID[c] = Convert.extractIntFrom(bytes, bytePoint);
                bytePoint += 2;
                opponentDuelItemAmount[c] = Convert.extractLongFrom(bytes, bytePoint);
                bytePoint += 4;
            }
            myDuelCount = bytes[bytePoint++] & 0xff;
            for(int c = 0; c < myDuelCount; c++) {
                myDuelItemID[c] = Convert.extractIntFrom(bytes, bytePoint);
                bytePoint += 2;
                myDuelItemAmount[c] = Convert.extractLongFrom(bytes, bytePoint);
                bytePoint += 4;
            }
            DuelnoRetreat = ((bytes[bytePoint++] & 0xff) != 0);
            DuelnoMagic = ((bytes[bytePoint++] & 0xff) != 0);
            DuelnoPrayer = ((bytes[bytePoint++] & 0xff) != 0);
            DuelnoWeapons = ((bytes[bytePoint++] & 0xff) != 0);
        } else if(packetID == 112 || packetID == 49) {
            debug("Show popup box");
            print("PopUp - " + new String(bytes, 1, value - 1));
        } else if(packetID == 60) {
            fatigue = (Convert.extractIntFrom(bytes, 1) * 100) / 750;
            debug("Fatigue updated to " + fatigue + "%");
        } else if(packetID == 15) {
            if(!sleeping)
                sleepFatigue = fatigue;
            sleeping = true;
            int i1 = 1;
            byte byte0 = 0;
            int bytePoint = 0;
            byte[] picBytes = new byte[10200];
            while(bytePoint < 255) {
                int k1 = bytes[i1++] & 0xff;
                for(int i2 = 0; i2 < k1; i2++)
                    picBytes[bytePoint++] = byte0;
                byte0 = (byte)(255 - byte0);
            }
            for(int l1 = 1; l1 < 40; l1++) {
                for(int j2 = 0; j2 < 255;) {
                    int k2 = bytes[i1++] & 0xff;
                    for(int l2 = 0; l2 < k2; l2++) {
                        picBytes[bytePoint] = picBytes[bytePoint - 255];
                        bytePoint++;
                        j2++;
                    }
                    if(j2 < 255) {
                        picBytes[bytePoint] = (byte)(255 - picBytes[bytePoint - 255]);
                        bytePoint++;
                        j2++;
                    }
                }
            }
            saveBytes("HC.bmp", picBytes);
            fileMod = slFile.lastModified();
            lastChecked = 0;
            sentWord = false;
        } else if(packetID == 174) {
            sleepFatigue = (Convert.extractIntFrom(bytes, 1) * 100) / 750;
        } else if(packetID == 206) {
            debug("Wake up");
            sleeping = false;
        } else if(packetID == 20) {
            debug("Sleepword was wrong");
        } else if(packetID == 28) {
            if((Convert.extractIntFrom(bytes, 1) * 32) != 0) {
                debug("WARNING - System update coming");
                onSystemUpdate();
            }
        }
    }

    private boolean loadTile(int tX, int tY) {
        load = false;
        tX += tileXoff;
        tY += tileYoff;
        if(loadedTile == toLoad && tX > lowerX && tX < upperX && tY > lowerY && tY < upperY)
            return false;
        load = true;
        int oldTileX = tileX;
        int oldTileY = tileY;
        int newtX = (tX + 24) / 48;
        int newtY = (tY + 24) / 48;
        loadedTile = toLoad;
        tileX = newtX * 48 - 48;
        tileY = newtY * 48 - 48;
        lowerX = newtX * 48 - 32;
        lowerY = newtY * 48 - 32;
        upperX = newtX * 48 + 32;
        upperY = newtY * 48 + 32;
        map.loadTile(tX, tY, loadedTile);
        tileX -= tileXoff;
        tileY -= tileYoff;
        int tileDiffX = tileX - oldTileX;
        int tileDiffY = tileY - oldTileY;
        for(int c = 0; c < objectCount; c++) {
            objectX[c] -= tileDiffX;
            objectY[c] -= tileDiffY;
            map.addObject(objectX[c], objectY[c], objectID[c]);
        }
        for(int c = 0; c < wallObjectCount; c++) {
            wallObjectX[c] -= tileDiffX;
            wallObjectY[c] -= tileDiffY;
            map.addWallObject(wallObjectX[c], wallObjectY[c], wallObjectDir[c], wallObjectID[c]);
        }
        for(int c = 0; c < itemCount; c++) {
            itemX[c] -= tileDiffX;
            itemY[c] -= tileDiffY;
        }
        for(int c = 0; c < playerCount; c++) {
            npcObject thPlayer = player[c];
            thPlayer.xCoord -= tileDiffX * 128;
            thPlayer.yCoord -= tileDiffY * 128;
            for(int c1 = 0; c1 <= thPlayer.pathIndex; c1++) {
                thPlayer.xCoordPath[c1] -= tileDiffX * 128;
                thPlayer.yCoordPath[c1] -= tileDiffY * 128;
            }
        }
        for(int c = 0; c < npcCount; c++) {
            npcObject thNpc = npc[c];
            thNpc.xCoord -= tileDiffX * 128;
            thNpc.yCoord -= tileDiffY * 128;
            for(int c1 = 0; c1 <= thNpc.pathIndex; c1++) {
                thNpc.xCoordPath[c1] -= tileDiffX * 128;
                thNpc.yCoordPath[c1] -= tileDiffY * 128;
            }
        }
        return true;
    }

    private npcObject newNpc(int pID, int tX, int tY, int type, int tID, npcObject[] oldNpc) {
        if(npc[pID] == null) {
            npc[pID] = new npcObject();
            npc[pID].pID = pID;
        }
        npcObject thNpc = npc[pID];
        boolean flag = false;
        for(int c = 0; c < oldNpc.length; c++) {
            if(oldNpc[c].pID != pID)
                continue;
            flag = true;
            break;
        }
        if(flag) {
            thNpc.ID = tID;
            thNpc.newDir = type;
            int pathIndex = thNpc.pathIndex;
            if(tX != thNpc.xCoordPath[pathIndex] || tY != thNpc.yCoordPath[pathIndex]) {
                thNpc.pathIndex = pathIndex = (pathIndex + 1) % 10;
                thNpc.xCoordPath[pathIndex] = tX;
                thNpc.yCoordPath[pathIndex] = tY;
            }
        } else {
            debug("New npc created at (" + (((tX - 64) / 128) + tileX) + "," + (((tY - 64) / 128) + tileY) + ")");
            thNpc.pID = pID;
            thNpc.pathIndex = 0;
            thNpc.NewpathIndex = 0;
            thNpc.xCoordPath[0] = thNpc.xCoord = tX;
            thNpc.yCoordPath[0] = thNpc.yCoord = tY;
            thNpc.ID = tID;
            thNpc.newDir = thNpc.Dir = type;
        }
        npc[npcCount++] = thNpc;
        return thNpc;
    }

    private npcObject newPlayer(int pID, int tX, int tY, int type, npcObject[] oldPlayer) {
        if(player[pID] == null) {
            player[pID] = new npcObject();
            player[pID].pID = pID;
            player[pID].gmg = 0;
        }
        npcObject thPlayer = player[pID];
        boolean flag = false;
        for(int c = 0; c < oldPlayer.length; c++) {
            if(oldPlayer[c].pID != pID)
                continue;
            flag = true;
            break;
        }
        if(flag) {
            thPlayer.newDir = type;
            int pathIndex = thPlayer.pathIndex;
            if(tX != thPlayer.xCoordPath[pathIndex] || tY != thPlayer.yCoordPath[pathIndex]) {
                thPlayer.pathIndex = pathIndex = (pathIndex + 1) % 10;
                thPlayer.xCoordPath[pathIndex] = tX;
                thPlayer.yCoordPath[pathIndex] = tY;
            }
        } else {
            debug("New player created at (" + (((tX - 64) / 128) + tileX) + "," + (((tY - 64) / 128) + tileY) + ")");
            thPlayer.pID = pID;
            thPlayer.NewpathIndex = 0;
            thPlayer.pathIndex = 0;
            thPlayer.xCoordPath[0] = thPlayer.xCoord = tX;
            thPlayer.yCoordPath[0] = thPlayer.yCoord = tY;
            thPlayer.newDir = thPlayer.Dir = type;
        }
        player[playerCount++] = thPlayer;
        return thPlayer;
    }

    private static void saveBytes(String saveTo, byte[] bytes){
        debug("Saving new sleepword to " + saveTo);
        try{
            FileOutputStream fileoutputstream = new FileOutputStream(new File(saveTo));
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
            int bytePoint = 9945;
            for(int c = 0; c < 40; c++) {
                for(int l1 = 0; l1 < 32; l1++) {
                    byte Tbyte = 0;
                    for(int i2 = 0; i2 < 8; i2++) {
                        Tbyte = (byte)(2 * Tbyte);
                        if(l1 != 31 || i2 != 7) {
                            if(bytes[bytePoint] != 0)
                                Tbyte++;
                            bytePoint++;
                        }
                    }
                    fileoutputstream.write(Tbyte);
                }
                bytePoint -= 510;
            }
            fileoutputstream.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void onMod(String modName, int how) {
        String[] foundHow = {"AREA", "CHAT", "PM"};
        print(modName + " detected in " + foundHow[how]);
        stopShell(this);
    }

    private static void onSystemUpdate() {
    }

    private void onLogin() {
        for(int c = 0; c < objectCount; c++)
            map.addObject1(objectX[c], objectY[c], objectID[c]);
        for(int c = 0; c < wallObjectCount; c++)
            map.addWallObject1(wallObjectX[c], wallObjectY[c], wallObjectDir[c], wallObjectID[c]);
        debug("Resetting variables");
        fightMode = objectCount = wallObjectCount = itemCount = playerCount = npcCount = friendCount = invCount = 0;
        inShop = inBank = sleeping = tradeScreen1 = tradeScreen2 = duelScreen1 = duelScreen2 = false;
    }

    private void onDied() {
        print("Oh dear! You are dead...");
    }

    public static void stopShell(Shell sh) {
        debug("Stopping shell instance for " + sh.user);
        sh.macro.LogOut();
        System.out.println(sh.user + ": Shell instance STOPPED");
        sh.myMacro.stop();
        System.gc();
        if(--shellUserCount == 0) {
            System.out.println("All shell instances stopped, shutting down");
            System.exit(0);
        }
        sh.myThread.stop();
    }

    private static void showHelp() {
        System.out.println("Usage: Shell [-options]");
        System.out.println();
        System.out.println("where options include:");
        System.out.println(" -d show debug info");
        System.out.println(" -h print this help message then quit");
        System.out.println();
        System.exit(0);
    }

    public final static void main(String[] as) {
        if(as.length > 0) {
            if(as.length == 1) {
                char[] c = as[0].substring(1).toLowerCase().toCharArray();
                for(int i = 0;i < c.length;i++) {
                    if(c[i] == 'h')
                        showHelp();
                    else if(c[i] == 'd')
                        DEBUG = true;
                    else
                        showHelp();
                }
            } else
                showHelp();
        }
//        java.util.Properties sysP = System.getProperties();
//        sysP.setProperty("socksProxyHost", "proxy.socks");
//        sysP.setProperty("socksProxyPort", "1337");
        ID.MUDCLIENT = update201to203.getVer();
        if(!slFile.exists()) {
            try {
                slFile.createNewFile();
                debug("slword.txt was missing, creating it.");
            } catch(Exception e) {
                debug("Failed creating slword.txt");
            }
        }
        File hcFile = new File("HC.bmp");
        if(!hcFile.exists()) {
            try {
                hcFile.createNewFile();
                debug("HC.bmp was missing, creating it.");
            } catch(Exception e) {
                debug("Failed creating hc.bmp");
            }
        }
        String[] packetIDs = null;
        int VALID = Functions.Rand(97,122);
        try {
            authName = Functions.GetInput("Please enter your auth name");
            String passWord = Functions.GetInput("Thank you " + authName + ", please enter your pass");
            URLConnection con = new URL("http://127.0.0.1/shell.php?u=" + URLEncoder.encode(authName) + "&p=" + URLEncoder.encode(passWord) + "&v=" + VERSION + "&r=" + String.valueOf((char)VALID)).openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            packetIDs = in.readLine().trim().split("&");
            in.close();
        } catch(Exception e) {
            System.out.println("Failed to auth, maybe the auth server is currently down?");
            authed = false;
            System.exit(0);
            return;
        }
        if(packetIDs.length == 1 || Integer.parseInt(packetIDs[1]) != VALID) {
            System.out.println(authName + ", your auth appears to be Invalid.");
            authed = false;
            System.exit(0);
            return;
        }
        int packetIndex = 2;
        String Ver = packetIDs[0];
        if(!Ver.equals(VERSION)) {
            System.out.println("The newest version of ST-SHell is " + String.valueOf((double)(Double.parseDouble(Ver) / 10)) + ", please update!");
            authed = false;
            System.exit(0);
            return;
        } else {  
            ID.ATTACKNPC = Integer.parseInt(packetIDs[packetIndex++]);//118;
            ID.TALKTONPC = Integer.parseInt(packetIDs[packetIndex++]);//159;
            ID.THIEVENPC = Integer.parseInt(packetIDs[packetIndex++]);//89;
            ID.USEONNPC = Integer.parseInt(packetIDs[packetIndex++]);//143;
            ID.TRADEPLAYER = Integer.parseInt(packetIDs[packetIndex++]);//62;
            ID.ACCEPTTRADE1 = Integer.parseInt(packetIDs[packetIndex++]);//94;
            ID.ACCEPTTRADE2 = Integer.parseInt(packetIDs[packetIndex++]);//102;
            ID.DECLINETRADE = Integer.parseInt(packetIDs[packetIndex++]);//27;
            ID.SPEAK = Integer.parseInt(packetIDs[packetIndex++]);//249;
            ID.SENDPM = Integer.parseInt(packetIDs[packetIndex++]);//59;
            ID.LOGOUT = Integer.parseInt(packetIDs[packetIndex++]);//3;
            ID.CASTONNPC = Integer.parseInt(packetIDs[packetIndex++]);//10;
            ID.CASTONITEM = Integer.parseInt(packetIDs[packetIndex++]);//166;
            ID.CASTONGITEM = Integer.parseInt(packetIDs[packetIndex++]);//18;
            ID.CASTONSELF = Integer.parseInt(packetIDs[packetIndex++]);//44;
            ID.CASTONGROUND = Integer.parseInt(packetIDs[packetIndex++]);//201;
            ID.CASTONWALL = Integer.parseInt(packetIDs[packetIndex++]);//76;
            ID.CASTONOBJECT = Integer.parseInt(packetIDs[packetIndex++]);//237;
            ID.ANSWER = Integer.parseInt(packetIDs[packetIndex++]);//189;
            ID.WITHDRAW = Integer.parseInt(packetIDs[packetIndex++]);//131;
            ID.DEPOSIT = Integer.parseInt(packetIDs[packetIndex++]);//190;
            ID.CLOSEBANK = Integer.parseInt(packetIDs[packetIndex++]);//78;
            ID.CLOSESHOP = Integer.parseInt(packetIDs[packetIndex++]);//92;
            ID.BUYITEM = Integer.parseInt(packetIDs[packetIndex++]);//67;
            ID.SELLITEM = Integer.parseInt(packetIDs[packetIndex++]);//177;
            ID.PRAYON = Integer.parseInt(packetIDs[packetIndex++]);//202;
            ID.PRAYOFF = Integer.parseInt(packetIDs[packetIndex++]);//162;
            ID.USEITEM = Integer.parseInt(packetIDs[packetIndex++]);//24;
            ID.USEITEMWITEM = Integer.parseInt(packetIDs[packetIndex++]);//235;
            ID.DROP = Integer.parseInt(packetIDs[packetIndex++]);//123;
            ID.WEAR = Integer.parseInt(packetIDs[packetIndex++]);//199;
            ID.REMOVE = Integer.parseInt(packetIDs[packetIndex++]);//40;
            ID.USEITEMGITEM = Integer.parseInt(packetIDs[packetIndex++]);//255;
            ID.USEONWALL = Integer.parseInt(packetIDs[packetIndex++]);//71;
            ID.ATWALL1 = Integer.parseInt(packetIDs[packetIndex++]);//100;
            ID.ATWALL2 = Integer.parseInt(packetIDs[packetIndex++]);//121;
            ID.PICKUP = Integer.parseInt(packetIDs[packetIndex++]);//253;
            ID.USEONOBJECT = Integer.parseInt(packetIDs[packetIndex++]);//127;
            ID.ATOBJECT1 = Integer.parseInt(packetIDs[packetIndex++]);//38;
            ID.ATOBJECT2 = Integer.parseInt(packetIDs[packetIndex++]);//172;
            ID.ADDFRIEND = Integer.parseInt(packetIDs[packetIndex++]);//232;
            ID.REMOVEFRIEND = Integer.parseInt(packetIDs[packetIndex++]);//52;
            ID.PING = Integer.parseInt(packetIDs[packetIndex++]);//186;
            ID.SLEEP = Integer.parseInt(packetIDs[packetIndex++]);//142;
            ID.SETMODE = Integer.parseInt(packetIDs[packetIndex++]);//74;
            ID.MOVE1 = Integer.parseInt(packetIDs[packetIndex++]);//226;
            ID.MOVE2 = Integer.parseInt(packetIDs[packetIndex++]);//211;
            ID.PID = Integer.parseInt(packetIDs[packetIndex++]);//241;
            ID.LOGIN = Integer.parseInt(packetIDs[packetIndex++]);//32;
            ID.HASH = Integer.parseInt(packetIDs[packetIndex++]);//0;
            ID.LOGREPLY = Integer.parseInt(packetIDs[packetIndex++]);//104;
            ID.DESIGN = Integer.parseInt(packetIDs[packetIndex++]);//238;
            if(Integer.parseInt(packetIDs[1]) == VALID && packetIndex == 54) {
                System.out.println("Welcome to ST-SHell " + String.valueOf((double)(Double.parseDouble(Ver) / 10)) + " - irc.reinet.co.uk");
                authed = true;
            } else {
                System.out.println(authName + ", your auth appears to be Invalid.");
                authed = false;
                System.exit(0);
                return;
            }
        }
        if(!authed)
            showHelp();
        byte bytes[] = LoadDataFile("itemConfig.jag");
        if(bytes == null) {
            System.out.println("WARNING - Error loading itemConfig.jag");
            System.exit(0);
        }
        Ident.unPack(bytes);
        Map.freeMaps = LoadDataFile("maps.jag");
        Map.memberMaps = LoadDataFile("maps.mem");
        Map.freeLand = LoadDataFile("land.jag");
        Map.memberLand = LoadDataFile("land.mem");
        String[] shellProfiles = new File("ShellUsers/").list();
        if(shellProfiles == null || shellProfiles.length == 0) {
            System.out.println("WARNING - No profiles found in /ShellUsers/");
            System.exit(0);
        }
        debug("Shell Profile List loaded from Shellusers/");
        for(int c = 0; c < shellProfiles.length;c++) {
            try {
                if(shellProfiles[c].endsWith(".ini")) {
                    Properties p = new Properties();
                    p.load(new FileInputStream(new File("ShellUsers/" + shellProfiles[c])));
                    String user = shellProfiles[c].substring(0,shellProfiles[c].length() - 4);
                    String pass = p.getProperty("Password").trim();
                    int server = Integer.parseInt(p.getProperty("Server").trim());
                    String script = p.getProperty("Script").trim();
                    waitForLogin(new Shell(user,pass,server,script));
                }
            } catch(Exception e) {
                System.out.println("Error in Shell Profile for " + shellProfiles[c]);
            }
        }
    }

    private static void waitForLogin(Shell sh) {
        while(!sh.loggedIn)
            sleep(5000);
    }

    private static byte[] LoadDataFile(String fileName) {
        try {
            if(!new File("Data/" + fileName).exists() || !authed) {
                System.out.println("WARNING - '" + fileName + "' is missing!");
                System.exit(0);
                return null;
            }
            debug("Staticly loading '" + fileName + "'.");
            DataInputStream datainputstream = new DataInputStream(new FileInputStream("Data/" + fileName));
            byte[] bytes = new byte[6];
            datainputstream.readFully(bytes, 0, 6);
            int expectedLength = ((bytes[0] & 0xff) << 16) + ((bytes[1] & 0xff) << 8) + (bytes[2] & 0xff);
            int finish = ((bytes[3] & 0xff) << 16) + ((bytes[4] & 0xff) << 8) + (bytes[5] & 0xff);
            int start = 0;
            bytes = new byte[finish];
            while(start < finish) {
                int length = finish - start;
                if(length > 1000)
                    length = 1000;
                datainputstream.readFully(bytes, start, length);
                start += length;
            }
            datainputstream.close();
            if(finish != expectedLength) {
                byte[] fixBytes = new byte[expectedLength];
                g.glj(fixBytes, expectedLength, bytes, finish, 0);
                return fixBytes;
            }
            else
                return bytes;
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final static Socket newSocket(String host, int port)throws Exception {
        if(!authed)
            return new Socket(InetAddress.getByName("www.runescape.com"), 80);
        debug("Opening new socket to " + host + ":" + port);
        Socket socket = new Socket(InetAddress.getByName(host), port);
        socket.setSoTimeout(30000);
        socket.setTcpNoDelay(true);
        return socket;
    }

    public final static void newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();
    }

    private static int getPort(int server) {
        return (server % 2 == 0 ? 43595 : 43594);
    }

    private static String getHost(int server) {
        if(server == 1 || server == 2)
            return "uk1.runescape.com";
        else
            return "ul3.runescape.com";
    }

    private boolean Login() {
        try {
            String luser = Convert.fillOut(user, 20);
            String lpass = Convert.fillOut(pass, 20);
            debug("Logging " + user + " in on server " + server);
            print("Please wait... Logging in on server " + server);
            resetTimers();
            Connection = new Connect(newSocket(getHost(server), getPort(server)));
            Connection.ham = 1000;
            long l = Convert.PlayerNameToLong(luser);
            Connection.sendID(ID.LOGIN);
            Connection.SendVar((int)(l >> 16 & 31L));
            Connection.endPacket1();
            long sID = Connection.hcn();
            if(sID == 0L) {
                print("Login server offline.");
                resetTimers();
                return false;
            }
            int randHash[] = new int[4];
            randHash[0] = (int)(Math.random() * 99999999D);
            randHash[1] = (int)(Math.random() * 99999999D);
            randHash[2] = (int)(sID >> 32);
            randHash[3] = (int)sID;
            hash hs = new hash(new byte[500]);
            hs.addInt(10);
            hs.addInt2(randHash[0]);
            hs.addInt2(randHash[1]);
            hs.addInt2(randHash[2]);
            hs.addInt2(randHash[3]);
            hs.addInt2((int)(Math.random() * 99999999D));
            hs.addString(luser);
            hs.addString(lpass);
            hs.addBigInts(bigInt1, bigInt2);
            Connection.sendID(ID.HASH);
            Connection.SendVar(0);
            Connection.sendInt(ID.MUDCLIENT);
            Connection.SendVar(0);
            Connection.sendBytes(hs.hashStore, 0, hs.hashCount);
            Connection.endPacket1();
            Connection.hcm(randHash);
            int loginResponce = Connection.read();
            if(loginResponce == 0 || loginResponce == 25) {
                print("(sID: " + sID + ") Login response " + loginResponce + ": Sucessful!");
                return true;
            }
            if(loginResponce == -1)
                print("(sID: " + sID + ") Login response -1: Server timed out.");
            else if(loginResponce == 3)
                print("(sID: " + sID + ") Login response 3: Invalid username or password.");
            else if(loginResponce == 4)
                print("(sID: " + sID + ") Login response 4: That username is already logged in.");
            else if(loginResponce == 5)
                print("(sID: " + sID + ") Login response 5: The client has been updated.");
            else if(loginResponce == 6)
                print("(sID: " + sID + ") Login response 6: You may only use 1 character at once.");
            else if(loginResponce == 7)
                print("(sID: " + sID + ") Login response 7: Login attempts exceeded!");
            else if(loginResponce == 8)
                print("(sID: " + sID + ") Login response 8: Server rejected session.");
            else if(loginResponce == 9)
                print("(sID: " + sID + ") Login response 9: Loginserver rejected session.");
            else if(loginResponce == 10)
                print("(sID: " + sID + ") Login response 10: That username is already in use.");
            else if(loginResponce == 11)
                print("(sID: " + sID + ") Login response 11: Account temporarily disabled.");
            else if(loginResponce == 12)
                print("(sID: " + sID + ") Login response 12: Account permanently disabled.");
            else if(loginResponce == 14)
                print("(sID: " + sID + ") Login response 14 Sorry! This world is currently full.");
            else if(loginResponce == 15)
                print("(sID: " + sID + ") Login response 15: You need a members account");
            else if(loginResponce == 16)
                print("(sID: " + sID + ") Login response 16: Error - no reply from loginserver.");
            else if(loginResponce == 17)
                print("(sID: " + sID + ") Login response 17: Error - failed to decode profile.");
            else if(loginResponce == 20)
                print("(sID: " + sID + ") Login response 20: Error - loginserver mismatch");
            else
                print("(sID: " + sID + ") Unrecognised response code.");
            resetTimers();
            return false;
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}