/*
 * This file is free software; you can redistribute it and/or modify
 * it under the following terms:
 *     - All redistributions *MUST* include full and valid source files
 *     - Some credit is given to me (BobDole81) and those listed in the readme
 */

import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseWheelEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import javax.imageio.ImageIO;

/**
 * BobbyBot PK v202
 * Date: 29/10/2005
 * Originally rewritten as an extension bot, was modified to run off a
 * deobfuscated version of the mudclient.  All bot features and a all
 * of the modifications made to this client are done in this file by
 * overriding methods of the mudclient and other superclasses.  
 *
 * Features:
 *     - Fog of War toggle, On-screen Info
 *     - Camera zoom, map zoom, and camera rotate
 *     - PKing minimap
 *     - Prayer Combo
 *     - Lefties toggle
 *     - Server hop
 *
 *
 * Below information is REFERENCE for me.  Bytecode modifications were not
 * used in this version of the bot
 *     Bytecode Changes:
 *       - All classes run through a bytecode de-publicizer and de-finalizer
 *       - "../release/" to "./Data/" for path to Jagex libraries
 *       - method13() and method14() for Bot startup image
 *       - Removed auto-logout and auto-zoom in
 */
public final class Bot extends mudclient {
    public static final String BOT_NAME = "BobbyBot PK";
    public static final String BOT_VERSION = "202";
    public static final String BOT_AUTHOR = "BobDole81";
    private final String outputPrefix = "@gr1@" + BOT_NAME +": @whi@";

    private boolean fogOfWar = true;
    private boolean prayerCombo = false;
    private boolean showInfo = true;
    private boolean[] keyPress = new boolean[6];
    private boolean[] prayerComboList = new boolean[14];
    private int currentServer = 1;
    private int fightMode = 1;
    private int leftySelect = 2;
    private int mapZoom = 0;
    private int removeFriend;
    private int selectedServer = 1;
    private int xRotate = 912;
    private String addFriend;
    private String parsedPassword;
    private String parsedUsername;


    public static final void main(String[] args) {
        Bot bot = new Bot();
        bot.aBoolean774 = false;
        bot.aBoolean867 = true;        // Load Members
        bot.method6(bot.anInt985, bot.anInt986 + 11, BOT_NAME +" v"+ BOT_VERSION, false);
        bot.aBoolean8 = true;          // Load 3D Objects
        bot.anInt32 = 10;
    }


    /*
     * Applet method overloading
     */

    public final URL getCodeBase() {
        try {
            return new URL("http://uk1.runescape.com/");
        } catch(MalformedURLException e) {
            return null;
        }
    }

    public final URL getDocumentBase() {
        try {
            return new URL("http://www.runescape.com/");
        } catch(MalformedURLException e) {
            return null;
        }
    }

    public final String getParameter(String parameterKey) {
        if(parameterKey.equals("referid"))
            return Integer.toString(0);
        if(parameterKey.equals("member"))
            return Integer.toString(1);
        if(parameterKey.equals("poff"))
            return Integer.toString(1);
        if(parameterKey.equals("limit30"))
            return Integer.toString(0);
        return null;
    }

    public void mouseWheelMoved(MouseWheelEvent e) {
        // Rubbish for the moment...I'll get it working later
        int notchesMoved = e.getWheelRotation();
        if(notchesMoved < 0 && anInt913 >= 365)
            anInt913 -= 15;
        else if(notchesMoved > 0 && anInt913 <= 5000)
            anInt913 += 15;
    }


    /*
     * Bot addition method overloading
     */

    public final void method53() {
        super.method53();

        // The unidentified and identified equivilents for each of the game herbs.
        int unidentifiedHerbIds[] = {165, 435, 436, 437, 438, 439, 440, 441, 442, 443, 815, 817, 819, 821, 823, 933};
        int identifiedHerbIds[] = {444, 445, 446, 447, 448, 449, 450, 451, 452, 453, 816, 818, 820, 822, 824, 934};

        /*
         * Checks whether the given item id is an unidentified herb; if so,
         * return a string containing the identified name.
         */
        for(int i = 0; i < unidentifiedHerbIds.length; i++)
            Class1.aStringArray112[unidentifiedHerbIds[i]] += " ("+ Class1.aStringArray112[identifiedHerbIds[i]] +")";

    }

    public final byte[] method18(String arg0, String arg1, int arg2) {
        File dataFolder = new File("./Data/"),
             dataFile = new File("./Data/", arg0);
        if(!dataFolder.exists())
            dataFolder.mkdir();
        if(!dataFile.exists())
            downloadFile("http://uk1.runescape.com/client2/" + arg0, dataFile);

        if(Class8.method264(arg0) == null)
            loadData(arg0, dataFile);

        return super.method18(arg0, arg1, arg2);
    }

    public final void method21(String s, String s1, boolean flag) {
        int worldNumber = -1;
        try {
            worldNumber = Integer.parseInt(s.substring(s.length() - 1));
            s = s.substring(0, s.length() - 1);
            if(worldNumber < 1 || worldNumber > 6)
                throw new Exception();
        } catch(Exception e) {
            method36("Invalid World Number.", "Please refer to readme.");
            return;
        }

        updateServer(worldNumber);
        fightMode = 1;

        parsedUsername = s;
        parsedPassword = s1;

        super.method21(s, s1, flag);
    }

    public final void method120(boolean flag) {
        int wildernessLevel = 2203 - (anInt890 + anInt720 + anInt750);
        if(anInt889 + anInt719 + anInt749 >= 2640)
            wildernessLevel = -50;

        int l = ((Class6) (aClass6_Sub1_935)).anInt311 - 199;
        char c1 = '\234';
        char c3 = '\230';
        aClass6_Sub1_935.method230(l - 49, 3, anInt778 + 2);
        l += 40;
        aClass6_Sub1_935.method215(l, 36, c1, c3, 0);
        aClass6_Sub1_935.method208(l, 36, l + c1, 36 + c3);
        int j1 = 192 + mapZoom;
        int l1 = anInt809 + anInt995 & 0xff;
        int j2 = ((aClass2_888.anInt149 - 6040) * 3 * j1) / 2048;
        int l3 = ((aClass2_888.anInt150 - 6040) * 3 * j1) / 2048;
        int j5 = Class10.anIntArray394[1024 - l1 * 4 & 0x3ff];
        int l5 = Class10.anIntArray394[(1024 - l1 * 4 & 0x3ff) + 1024];
        int j6 = l3 * j5 + j2 * l5 >> 18;
        l3 = l3 * l5 - j2 * j5 >> 18;
        j2 = j6;
        aClass6_Sub1_935.method242((l + c1 / 2) - j2, 36 + c3 / 2 + l3, anInt778 - 1, l1 + 64 & 0xff, j1);
        for(int i = 0; i < anInt981; i++) {
            int minimapObjectXDistance = (((anIntArray882[i] * anInt729 + 64) - aClass2_888.anInt149) * 3 * j1) / 2048;
            int minimapObjectYDistance = (((anIntArray883[i] * anInt729 + 64) - aClass2_888.anInt150) * 3 * j1) / 2048;
            int minimapObjectXDistanceHold = minimapObjectYDistance * j5 + minimapObjectXDistance * l5 >> 18;
            minimapObjectYDistance = minimapObjectYDistance * l5 - minimapObjectXDistance * j5 >> 18;
            minimapObjectXDistance = minimapObjectXDistanceHold;
            method118(l + c1 / 2 + minimapObjectXDistance, (36 + c3 / 2) - minimapObjectYDistance, 65535);
        }

        for(int i = 0; i < anInt895; i++) {
            int l2 = (((anIntArray966[i] * anInt729 + 64) - aClass2_888.anInt149) * 3 * j1) / 2048;
            int j4 = (((anIntArray967[i] * anInt729 + 64) - aClass2_888.anInt150) * 3 * j1) / 2048;
            int l6 = j4 * j5 + l2 * l5 >> 18;
            j4 = j4 * l5 - l2 * j5 >> 18;
            l2 = l6;
            int groundItemDotColor = 0xff0000;
            if(wildernessLevel > 0)
                groundItemDotColor = 0xca6fff;
            method118(l + c1 / 2 + l2, (36 + c3 / 2) - j4, groundItemDotColor);
        }

        for(int i = 0; i < anInt717; i++) {
            Class2 minimapNpcObject = aClass2Array705[i];
            int minimapNpcXDistance = ((minimapNpcObject.anInt149 - aClass2_888.anInt149) * 3 * j1) / 2048;
            int minimapNpcYDistance = ((minimapNpcObject.anInt150 - aClass2_888.anInt150) * 3 * j1) / 2048;
            int tempMinimapNpcXDistanceHold = minimapNpcYDistance * j5 + minimapNpcXDistance * l5 >> 18;
            minimapNpcYDistance = minimapNpcYDistance * l5 - minimapNpcXDistance * j5 >> 18;
            minimapNpcXDistance = tempMinimapNpcXDistanceHold;
            int npcDotColor = 0xffff00;
            if(wildernessLevel > 0)
                npcDotColor = 0xfc00ff;
            method118(l + c1 / 2 + minimapNpcXDistance, (36 + c3 / 2) - minimapNpcYDistance, npcDotColor);
        }

        for(int i = 0; i < anInt689; i++) {
            Class2 minimapPlayerObject = aClass2Array904[i];
            int minimapPlayerXDistance = ((minimapPlayerObject.anInt149 - aClass2_888.anInt149) * 3 * j1) / 2048;
            int minimapPlayerYDistance = ((minimapPlayerObject.anInt150 - aClass2_888.anInt150) * 3 * j1) / 2048;
            int minimapPlayerXDistanceHold = minimapPlayerYDistance * j5 + minimapPlayerXDistance * l5 >> 18;

            minimapPlayerYDistance = minimapPlayerYDistance * l5 - minimapPlayerXDistance * j5 >> 18;
            minimapPlayerXDistance = minimapPlayerXDistanceHold;

            boolean canDraw = true;
            int playerDotColor = 0xffffff;
            int wilderenessDifference = 1 + wildernessLevel / 6;
            if(wildernessLevel > 0) {
                int levelDifferenceUp = aClass2_888.anInt168 + wilderenessDifference;
                int levelDifferenceDown = aClass2_888.anInt168 - wilderenessDifference;
                if(minimapPlayerObject.anInt168 <= levelDifferenceUp && minimapPlayerObject.anInt168 >= levelDifferenceDown) {
                    canDraw = true;
                    int playerLevelDifference = aClass2_888.anInt168 - minimapPlayerObject.anInt168;
                    if(playerLevelDifference == 0)
                        playerDotColor = 0xffffff;
                    if(playerLevelDifference > 0)
                        playerDotColor = 0xe1ff90;
                    if(playerLevelDifference > 3)
                        playerDotColor = 0xbaff00;
                    if(playerLevelDifference > 6)
                        playerDotColor = 0x6cff00;
                    if(playerLevelDifference > 10)
                        playerDotColor = 65280;
                    if(playerLevelDifference < 0)
                        playerDotColor = 0xfff36d;
                    if(playerLevelDifference < -3)
                        playerDotColor = 0xffb400;
                    if(playerLevelDifference < -6)
                        playerDotColor = 0xff7e00;
                    if(playerLevelDifference < -9)
                        playerDotColor = 0xff0000;
                } else
                    canDraw = false;
            }
            for(int j9 = 0; j9 < super.anInt624; j9++) {
                if(minimapPlayerObject.aLong145 != super.aLongArray625[j9] || super.anIntArray626[j9] != 99)
                    continue;
                playerDotColor = 65280;
                break;
            }

            if(canDraw || wildernessLevel < 1)
                method118(l + c1 / 2 + minimapPlayerXDistance, (36 + c3 / 2) - minimapPlayerYDistance, playerDotColor);
        }

        aClass6_Sub1_935.method212(l + c1 / 2, 36 + c3 / 2, 2, 0xffffff, 255);
        aClass6_Sub1_935.method242(l + 19, 55, anInt778 + 24, anInt809 + 128 & 0xff, 128);
        aClass6_Sub1_935.method208(0, 0, anInt985, anInt986 + 12);
        if(!flag)
            return;
        l = super.anInt33 - (((Class6) (aClass6_Sub1_935)).anInt311 - 199);
        int l8 = super.anInt34 - 36;
        if(l >= 40 && l8 >= 0 && l < 196 && l8 < 152) {
            char c2 = '\234';
            char c4 = '\230';
            int k1 = 192 + mapZoom;
            int i2 = anInt809 + anInt995 & 0xff;
            int i1 = ((Class6) (aClass6_Sub1_935)).anInt311 - 199;
            i1 += 40;
            int k3 = ((super.anInt33 - (i1 + c2 / 2)) * 16384) / (3 * k1);
            int i5 = ((super.anInt34 - (36 + c4 / 2)) * 16384) / (3 * k1);
            int k5 = Class10.anIntArray394[1024 - i2 * 4 & 0x3ff];
            int i6 = Class10.anIntArray394[(1024 - i2 * 4 & 0x3ff) + 1024];
            int k7 = i5 * k5 + k3 * i6 >> 15;
            i5 = i5 * i6 - k3 * k5 >> 15;
            k3 = k7;
            k3 += aClass2_888.anInt149;
            i5 = aClass2_888.anInt150 - i5;
            if(anInt912 == 1)
                method112(anInt889, anInt890, k3 / 128, i5 / 128, false);
            anInt912 = 0;
        }
    }

    public final void method81() {
        int i = 2203 - (anInt890 + anInt720 + anInt750);
        if(anInt889 + anInt719 + anInt749 >= 2640)
            i = -50;
        int j = -1;
        for(int k = 0; k < anInt981; k++)
            aBooleanArray837[k] = false;

        for(int l = 0; l < anInt959; l++)
            aBooleanArray980[l] = false;

        int i1 = aClass10_939.method277();
        Class5 aclass5[] = aClass10_939.method279();
        int ai[] = aClass10_939.method278();
        for(int j1 = 0; j1 < i1; j1++) {
            if(anInt763 > 200)
                break;
            int k1 = ai[j1];
            Class5 class5 = aclass5[j1];
            if(class5.anIntArray258[k1] <= 65535 || class5.anIntArray258[k1] >= 0x30d40 && class5.anIntArray258[k1] <= 0x493e0)
                if(class5 == aClass10_939.aClass5_433) {
                    int i2 = class5.anIntArray258[k1] % 10000;
                    int l2 = class5.anIntArray258[k1] / 10000;
                    if(l2 == 1) {
                        String s = "";
                        int k3 = 0;
                        if(aClass2_888.anInt168 > 0 && aClass2Array904[i2].anInt168 > 0)
                            k3 = aClass2_888.anInt168 - aClass2Array904[i2].anInt168;
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
                        s = " " + s + "(level-" + aClass2Array904[i2].anInt168 + ")"+ (aClass2_888.anInt147 <= aClass2Array904[i2].anInt147 ? "@gre@" : "@red@")+ "  ("+ aClass2Array904[i2].anInt147 +")";
                        if(anInt919 >= 0) {
                            if(Class1.anIntArray63[anInt919] == 1 || Class1.anIntArray63[anInt919] == 2) {
                                aStringArray676[anInt763] = "Cast " + Class1.aStringArray110[anInt919] + " on";
                                aStringArray833[anInt763] = "@whi@" + aClass2Array904[i2].aString146 + s;
                                anIntArray768[anInt763] = 800;
                                anIntArray886[anInt763] = aClass2Array904[i2].anInt149;
                                anIntArray887[anInt763] = aClass2Array904[i2].anInt150;
                                anIntArray844[anInt763] = aClass2Array904[i2].anInt147;
                                anIntArray845[anInt763] = anInt919;
                                anInt763++;
                            }
                        } else
                        if(anInt757 >= 0) {
                            aStringArray676[anInt763] = "Use " + aString758 + " with";
                            aStringArray833[anInt763] = "@whi@" + aClass2Array904[i2].aString146 + s;
                            anIntArray768[anInt763] = 810;
                            anIntArray886[anInt763] = aClass2Array904[i2].anInt149;
                            anIntArray887[anInt763] = aClass2Array904[i2].anInt150;
                            anIntArray844[anInt763] = aClass2Array904[i2].anInt147;
                            anIntArray845[anInt763] = anInt757;
                            anInt763++;
                        } else {
                            boolean isFriend = false;
                            for(int friendId = 0; friendId < super.anInt624; friendId++) {
                                if(Class15.method362(super.aLongArray625[friendId]).equals(aClass2Array904[i2].aString146)) {
                                    isFriend = true;
                                    removeFriend = friendId;
                                    break;
                                }
                            }

                            if(i > 0 && (aClass2Array904[i2].anInt150 - 64) / anInt729 + anInt720 + anInt750 < 2203) {
/*                              Do we want disabled attack for friends?
                                if(isFriend) {
                                    anIntArray846[anInt763] = 0;
                                    menuActionId[anInt763] = 2805;
                                } else
                                    anIntArray846[anInt763] = 1;
*/

                                aStringArray676[anInt763] = "Attack";
                                aStringArray833[anInt763] = "@whi@" + aClass2Array904[i2].aString146 + s + (aClass2_888.anInt147 <= aClass2Array904[i2].anInt147 ? "@gre@" : "@red@")+ "  ("+ aClass2Array904[i2].anInt147 +")";
                                int wildernessLevel = 2203 - (anInt890 + anInt720 + anInt750);

                                if(anInt889 + anInt719 + anInt749 >= 2640)
                                    wildernessLevel = -50;
                                wildernessLevel = 1 + wildernessLevel / 6;

                                if((leftySelect == 2 || leftySelect == 3) && (aClass2Array904[i2].anInt168 <= (aClass2_888.anInt168 + wildernessLevel) && aClass2Array904[i2].anInt168 >= (aClass2_888.anInt168 - wildernessLevel)))
                                    anIntArray768[anInt763] = 805;
                                else if(k3 >= 0 && k3 < 5)
                                    anIntArray768[anInt763] = 805;
                                else
                                    anIntArray768[anInt763] = 2805;
                                anIntArray886[anInt763] = aClass2Array904[i2].anInt149;
                                anIntArray887[anInt763] = aClass2Array904[i2].anInt150;
                                anIntArray844[anInt763] = aClass2Array904[i2].anInt147;
                                anInt763++;
                            } else
                            if(aBoolean867) {
                                aStringArray676[anInt763] = "Duel with";
                                aStringArray833[anInt763] = "@whi@" + aClass2Array904[i2].aString146 + s;
                                anIntArray886[anInt763] = aClass2Array904[i2].anInt149;
                                anIntArray887[anInt763] = aClass2Array904[i2].anInt150;
                                anIntArray768[anInt763] = 2806;
                                anIntArray844[anInt763] = aClass2Array904[i2].anInt147;
                                anInt763++;
                            }
                            if(isFriend) {
                                aStringArray676[anInt763] = "Remove Friend";
                                aStringArray833[anInt763] = "@whi@" + aClass2Array904[i2].aString146 + s;
                                anIntArray768[anInt763] = 2812;
                                anIntArray844[anInt763] = aClass2Array904[i2].anInt147;
                            } else {
                                aStringArray676[anInt763] = "Add Friend";
                                aStringArray833[anInt763] = "@whi@" + aClass2Array904[i2].aString146 + s;
                                anIntArray768[anInt763] = 2811;
                                anIntArray844[anInt763] = aClass2Array904[i2].anInt147;
                                addFriend = aClass2Array904[i2].aString146;
                            }
                            anInt763++;
                            aStringArray676[anInt763] = "Trade with";
                            aStringArray833[anInt763] = "@whi@" + aClass2Array904[i2].aString146 + s;
                            anIntArray768[anInt763] = 2810;
                            anIntArray844[anInt763] = aClass2Array904[i2].anInt147;
                            anInt763++;
                            aStringArray676[anInt763] = "Follow";
                            aStringArray833[anInt763] = "@whi@" + aClass2Array904[i2].aString146 + s;
                            anIntArray768[anInt763] = 2820;
                            anIntArray844[anInt763] = aClass2Array904[i2].anInt147;
                            anInt763++;
                        }
                    } else
                    if(l2 == 2) {
                        if(anInt919 >= 0) {
                            if(Class1.anIntArray63[anInt919] == 3) {
                                aStringArray676[anInt763] = "Cast " + Class1.aStringArray110[anInt919] + " on";
                                aStringArray833[anInt763] = "@lre@" + Class1.aStringArray112[anIntArray968[i2]];
                                anIntArray768[anInt763] = 200;
                                anIntArray886[anInt763] = anIntArray966[i2];
                                anIntArray887[anInt763] = anIntArray967[i2];
                                anIntArray844[anInt763] = anIntArray968[i2];
                                anIntArray845[anInt763] = anInt919;
                                anInt763++;
                            }
                        } else
                        if(anInt757 >= 0) {
                            aStringArray676[anInt763] = "Use " + aString758 + " with";
                            aStringArray833[anInt763] = "@lre@" + Class1.aStringArray112[anIntArray968[i2]];
                            anIntArray768[anInt763] = 210;
                            anIntArray886[anInt763] = anIntArray966[i2];
                            anIntArray887[anInt763] = anIntArray967[i2];
                            anIntArray844[anInt763] = anIntArray968[i2];
                            anIntArray845[anInt763] = anInt757;
                            anInt763++;
                        } else {
                            aStringArray676[anInt763] = "Take";
                            aStringArray833[anInt763] = "@lre@" + Class1.aStringArray112[anIntArray968[i2]];
                            anIntArray768[anInt763] = 220;
                            anIntArray886[anInt763] = anIntArray966[i2];
                            anIntArray887[anInt763] = anIntArray967[i2];
                            anIntArray844[anInt763] = anIntArray968[i2];
                            anInt763++;
                            aStringArray676[anInt763] = "Examine";
                            aStringArray833[anInt763] = "@lre@" + Class1.aStringArray112[anIntArray968[i2]];
                            anIntArray768[anInt763] = 3200;
                            anIntArray844[anInt763] = anIntArray968[i2];
                            anInt763++;
                        }
                    } else
                    if(l2 == 3) {
                        String s1 = "";
                        int l3 = -1;
                        int i4 = aClass2Array705[i2].anInt151;
                        if(Class1.anIntArray130[i4] > 0) {
                            int j4 = (Class1.anIntArray126[i4] + Class1.anIntArray129[i4] + Class1.anIntArray127[i4] + Class1.anIntArray128[i4]) / 4;
                            int k4 = (anIntArray838[0] + anIntArray838[1] + anIntArray838[2] + anIntArray838[3] + 27) / 4;
                            l3 = k4 - j4;
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
                            s1 = " " + s1 + "(level-" + j4 + ")";
                        }
                        if(anInt919 >= 0) {
                            if(Class1.anIntArray63[anInt919] == 2) {
                                aStringArray676[anInt763] = "Cast " + Class1.aStringArray110[anInt919] + " on";
                                aStringArray833[anInt763] = "@yel@" + Class1.aStringArray123[aClass2Array705[i2].anInt151];
                                anIntArray768[anInt763] = 700;
                                anIntArray886[anInt763] = aClass2Array705[i2].anInt149;
                                anIntArray887[anInt763] = aClass2Array705[i2].anInt150;
                                anIntArray844[anInt763] = aClass2Array705[i2].anInt147;
                                anIntArray845[anInt763] = anInt919;
                                anInt763++;
                            }
                        } else
                        if(anInt757 >= 0) {
                            aStringArray676[anInt763] = "Use " + aString758 + " with";
                            aStringArray833[anInt763] = "@yel@" + Class1.aStringArray123[aClass2Array705[i2].anInt151];
                            anIntArray768[anInt763] = 710;
                            anIntArray886[anInt763] = aClass2Array705[i2].anInt149;
                            anIntArray887[anInt763] = aClass2Array705[i2].anInt150;
                            anIntArray844[anInt763] = aClass2Array705[i2].anInt147;
                            anIntArray845[anInt763] = anInt757;
                            anInt763++;
                        } else {
                            if(Class1.anIntArray130[i4] > 0) {
                                aStringArray676[anInt763] = "Attack";
                                aStringArray833[anInt763] = "@yel@" + Class1.aStringArray123[aClass2Array705[i2].anInt151] + s1;
                                if(leftySelect == 1 || leftySelect == 3)
                                    anIntArray768[anInt763] = 715;
                                else if(l3 >= 0)
                                    anIntArray768[anInt763] = 715;
                                else
                                    anIntArray768[anInt763] = 2715;
                                anIntArray886[anInt763] = aClass2Array705[i2].anInt149;
                                anIntArray887[anInt763] = aClass2Array705[i2].anInt150;
                                anIntArray844[anInt763] = aClass2Array705[i2].anInt147;
                                anInt763++;
                            }
                            aStringArray676[anInt763] = "Talk-to";
                            aStringArray833[anInt763] = "@yel@" + Class1.aStringArray123[aClass2Array705[i2].anInt151];
                            anIntArray768[anInt763] = 720;
                            anIntArray886[anInt763] = aClass2Array705[i2].anInt149;
                            anIntArray887[anInt763] = aClass2Array705[i2].anInt150;
                            anIntArray844[anInt763] = aClass2Array705[i2].anInt147;
                            anInt763++;
                            if(!Class1.aStringArray125[i4].equals("")) {
                                aStringArray676[anInt763] = Class1.aStringArray125[i4];
                                aStringArray833[anInt763] = "@yel@" + Class1.aStringArray123[aClass2Array705[i2].anInt151];
                                anIntArray768[anInt763] = 725;
                                anIntArray886[anInt763] = aClass2Array705[i2].anInt149;
                                anIntArray887[anInt763] = aClass2Array705[i2].anInt150;
                                anIntArray844[anInt763] = aClass2Array705[i2].anInt147;
                                anInt763++;
                            }
                            aStringArray676[anInt763] = "Examine";
                            aStringArray833[anInt763] = "@yel@" + Class1.aStringArray123[aClass2Array705[i2].anInt151];
                            anIntArray768[anInt763] = 3700;
                            anIntArray844[anInt763] = aClass2Array705[i2].anInt151;
                            anInt763++;
                        }
                    }
                } else
                if(class5 != null && class5.anInt257 >= 10000) {
                    int j2 = class5.anInt257 - 10000;
                    int i3 = anIntArray961[j2];
                    if(!aBooleanArray980[j2]) {
                        if(anInt919 >= 0) {
                            if(Class1.anIntArray63[anInt919] == 4) {
                                aStringArray676[anInt763] = "Cast " + Class1.aStringArray110[anInt919] + " on";
                                aStringArray833[anInt763] = "@cya@" + Class1.aStringArray99[i3];
                                anIntArray768[anInt763] = 300;
                                anIntArray886[anInt763] = anIntArray947[j2];
                                anIntArray887[anInt763] = anIntArray948[j2];
                                anIntArray844[anInt763] = anIntArray960[j2];
                                anIntArray845[anInt763] = anInt919;
                                anInt763++;
                            }
                        } else
                        if(anInt757 >= 0) {
                            aStringArray676[anInt763] = "Use " + aString758 + " with";
                            aStringArray833[anInt763] = "@cya@" + Class1.aStringArray99[i3];
                            anIntArray768[anInt763] = 310;
                            anIntArray886[anInt763] = anIntArray947[j2];
                            anIntArray887[anInt763] = anIntArray948[j2];
                            anIntArray844[anInt763] = anIntArray960[j2];
                            anIntArray845[anInt763] = anInt757;
                            anInt763++;
                        } else {
                            if(!Class1.aStringArray101[i3].equalsIgnoreCase("WalkTo")) {
                                aStringArray676[anInt763] = Class1.aStringArray101[i3];
                                aStringArray833[anInt763] = "@cya@" + Class1.aStringArray99[i3];
                                anIntArray768[anInt763] = 320;
                                anIntArray886[anInt763] = anIntArray947[j2];
                                anIntArray887[anInt763] = anIntArray948[j2];
                                anIntArray844[anInt763] = anIntArray960[j2];
                                anInt763++;
                            }
                            if(!Class1.aStringArray102[i3].equalsIgnoreCase("Examine")) {
                                aStringArray676[anInt763] = Class1.aStringArray102[i3];
                                aStringArray833[anInt763] = "@cya@" + Class1.aStringArray99[i3];
                                anIntArray768[anInt763] = 2300;
                                anIntArray886[anInt763] = anIntArray947[j2];
                                anIntArray887[anInt763] = anIntArray948[j2];
                                anIntArray844[anInt763] = anIntArray960[j2];
                                anInt763++;
                            }
                            aStringArray676[anInt763] = "Examine";
                            aStringArray833[anInt763] = "@cya@" + Class1.aStringArray99[i3];
                            anIntArray768[anInt763] = 3300;
                            anIntArray844[anInt763] = i3;
                            anInt763++;
                        }
                        aBooleanArray980[j2] = true;
                    }
                } else
                if(class5 != null && class5.anInt257 >= 0) {
                    int k2 = class5.anInt257;
                    int j3 = anIntArray884[k2];
                    if(!aBooleanArray837[k2]) {
                        if(anInt919 >= 0) {
                            if(Class1.anIntArray63[anInt919] == 5) {
                                aStringArray676[anInt763] = "Cast " + Class1.aStringArray110[anInt919] + " on";
                                aStringArray833[anInt763] = "@cya@" + Class1.aStringArray79[j3];
                                anIntArray768[anInt763] = 400;
                                anIntArray886[anInt763] = anIntArray882[k2];
                                anIntArray887[anInt763] = anIntArray883[k2];
                                anIntArray844[anInt763] = anIntArray885[k2];
                                anIntArray845[anInt763] = anIntArray884[k2];
                                anIntArray846[anInt763] = anInt919;
                                anInt763++;
                            }
                        } else
                        if(anInt757 >= 0) {
                            aStringArray676[anInt763] = "Use " + aString758 + " with";
                            aStringArray833[anInt763] = "@cya@" + Class1.aStringArray79[j3];
                            anIntArray768[anInt763] = 410;
                            anIntArray886[anInt763] = anIntArray882[k2];
                            anIntArray887[anInt763] = anIntArray883[k2];
                            anIntArray844[anInt763] = anIntArray885[k2];
                            anIntArray845[anInt763] = anIntArray884[k2];
                            anIntArray846[anInt763] = anInt757;
                            anInt763++;
                        } else {
                            if(!Class1.aStringArray81[j3].equalsIgnoreCase("WalkTo")) {
                                aStringArray676[anInt763] = Class1.aStringArray81[j3];
                                aStringArray833[anInt763] = "@cya@" + Class1.aStringArray79[j3];
                                anIntArray768[anInt763] = 420;
                                anIntArray886[anInt763] = anIntArray882[k2];
                                anIntArray887[anInt763] = anIntArray883[k2];
                                anIntArray844[anInt763] = anIntArray885[k2];
                                anIntArray845[anInt763] = anIntArray884[k2];
                                anInt763++;
                            }
                            if(!Class1.aStringArray82[j3].equalsIgnoreCase("Examine")) {
                                aStringArray676[anInt763] = Class1.aStringArray82[j3];
                                aStringArray833[anInt763] = "@cya@" + Class1.aStringArray79[j3];
                                anIntArray768[anInt763] = 2400;
                                anIntArray886[anInt763] = anIntArray882[k2];
                                anIntArray887[anInt763] = anIntArray883[k2];
                                anIntArray844[anInt763] = anIntArray885[k2];
                                anIntArray845[anInt763] = anIntArray884[k2];
                                anInt763++;
                            }
                            aStringArray676[anInt763] = "Examine";
                            aStringArray833[anInt763] = "@cya@" + Class1.aStringArray79[j3];
                            anIntArray768[anInt763] = 3400;
                            anIntArray844[anInt763] = j3;
                            anInt763++;
                        }
                        aBooleanArray837[k2] = true;
                    }
                } else {
                    if(k1 >= 0)
                        k1 = class5.anIntArray258[k1] - 0x30d40;
                    if(k1 >= 0)
                        j = k1;
                }
        }

        if(anInt919 >= 0 && Class1.anIntArray63[anInt919] <= 1) {
            aStringArray676[anInt763] = "Cast " + Class1.aStringArray110[anInt919] + " on self";
            aStringArray833[anInt763] = "";
            anIntArray768[anInt763] = 1000;
            anIntArray844[anInt763] = anInt919;
            anInt763++;
        }
        if(j != -1) {
            int l1 = j;
            if(anInt919 >= 0) {
                if(Class1.anIntArray63[anInt919] == 6) {
                    aStringArray676[anInt763] = "Cast " + Class1.aStringArray110[anInt919] + " on ground";
                    aStringArray833[anInt763] = "";
                    anIntArray768[anInt763] = 900;
                    anIntArray886[anInt763] = aClass19_903.anIntArray586[l1];
                    anIntArray887[anInt763] = aClass19_903.anIntArray605[l1];
                    anIntArray844[anInt763] = anInt919;
                    anInt763++;
                    return;
                }
            } else
            if(anInt757 < 0) {
                aStringArray676[anInt763] = "Walk here";
                aStringArray833[anInt763] = "";
                anIntArray768[anInt763] = 920;
                anIntArray886[anInt763] = aClass19_903.anIntArray586[l1];
                anIntArray887[anInt763] = aClass19_903.anIntArray605[l1];
                anInt763++;
            }
        }
    }

    public final void method70(int i) {
        int j = anIntArray886[i];
        int k = anIntArray887[i];
        int l = anIntArray844[i];
        int i1 = anIntArray845[i];
        int j1 = anIntArray846[i];
        int k1 = anIntArray768[i];
        if(k1 == 2811) {
            method31(addFriend);
            method42("@pri@" + addFriend + " has been adeed to your friends list");
        }
        if(k1 == 2812)
            method32(super.aLongArray625[removeFriend]);

        super.method70(i);
    }

    public final void method85(boolean flag) {
        int i = super.anInt33 - (((Class6) (aClass6_Sub1_935)).anInt311 - 199);
        int j = super.anInt34 - 36;
        if(i >= 0 && j >= 0 && i < 196 && j < 182) {
            if(anInt912 == 2 && anInt735 == 1) {
                int selectedPrayer = aClass4_733.method173(anInt734);
                if(selectedPrayer != -1) {
                    if(Class1.anIntArray137[selectedPrayer] > anIntArray838[5])
                        method97(outputPrefix +"Prayer level ("+ anIntArray838[5] +") not high enough for "+ Class1.aStringArray96[selectedPrayer] +" ("+ Class1.anIntArray137[selectedPrayer] +")!", 10);
                    else if(prayerComboList[selectedPrayer] == true) {
                         prayerComboList[selectedPrayer] = false;
                         method97(outputPrefix + Class1.aStringArray96[selectedPrayer] +" ("+ Class1.anIntArray137[selectedPrayer] +") removed from prayer combo.", 10);
                    } else {
                         prayerComboList[selectedPrayer] = true;
                         method97(outputPrefix + Class1.aStringArray96[selectedPrayer] +" ("+ Class1.anIntArray137[selectedPrayer] +") added to prayer combo.", 10);
                    } 
                }
            }
        }

        super.method85(flag);
    }

    public final void method88(boolean arg0) {
        int l = ((Class6) (aClass6_Sub1_935)).anInt311 - 199;
        int i1 = 36;
        aClass6_Sub1_935.method230(l - 49, 3, anInt778 + 6);
        char c1 = '\304';
        aClass6_Sub1_935.method213(l, 36, c1, 65, Class6.method222(181, 181, 181), 160);
        aClass6_Sub1_935.method213(l, 101, c1, 65, Class6.method222(201, 201, 201), 160);
        aClass6_Sub1_935.method213(l, 166, c1, 95, Class6.method222(181, 181, 181), 160);
        aClass6_Sub1_935.method213(l, 261, c1, 40, Class6.method222(201, 201, 201), 160);
        int j1 = l + 3;
        int l1 = i1 + 15;
        aClass6_Sub1_935.method256("Game options - click to toggle", j1, l1, 1, 0);
        l1 += 15;
        if(aBoolean666)
            aClass6_Sub1_935.method256("Camera angle mode - @gre@Auto", j1, l1, 1, 0xffffff);
        else
            aClass6_Sub1_935.method256("Camera angle mode - @red@Manual", j1, l1, 1, 0xffffff);
        l1 += 15;
        if(aBoolean785)
            aClass6_Sub1_935.method256("Mouse buttons - @red@One", j1, l1, 1, 0xffffff);
        else
            aClass6_Sub1_935.method256("Mouse buttons - @gre@Two", j1, l1, 1, 0xffffff);
        l1 += 15;
        if(aBoolean867)
            if(aBoolean950)
                aClass6_Sub1_935.method256("Sound effects - @red@off", j1, l1, 1, 0xffffff);
            else
                aClass6_Sub1_935.method256("Sound effects - @gre@on", j1, l1, 1, 0xffffff);
        l1 += 15;
        aClass6_Sub1_935.method256("@gr1@BobbyBot Options:", j1, l1, 1, 0xffffff);
        l1 += 15;
        aClass6_Sub1_935.method256("Switch to World: @yel@"+ selectedServer +" @gr2@(Currently: @yel@"+ currentServer +"@gr2@)", j1, l1, 1, 0xffffff);
        l1 += 15;
        if(fogOfWar)
            aClass6_Sub1_935.method256("Fog of War: @gre@<on>", j1, l1, 1, 0xffffff);
        else
            aClass6_Sub1_935.method256("Fog of War: @red@<off>", j1, l1, 1, 0xffffff);
        l1 += 15;
        if(leftySelect == 0)
            aClass6_Sub1_935.method256("Lefty Select: @red@<off>", j1, l1, 1, 0xffffff);
        else if(leftySelect == 1)
            aClass6_Sub1_935.method256("Lefty Select: @gre@<NPCs Only>", j1, l1, 1, 0xffffff);
        else if(leftySelect == 2)
            aClass6_Sub1_935.method256("Lefty Select: @gre@<Players Only>", j1, l1, 1, 0xffffff);
        else if(leftySelect == 3)
            aClass6_Sub1_935.method256("Lefty Select: @gre@<NPCs and Players>", j1, l1, 1, 0xffffff);
        l1 += 15;
        l1 += 5;
        aClass6_Sub1_935.method256("Privacy settings. Will be applied to", l + 3, l1, 1, 0);
        l1 += 15;
        aClass6_Sub1_935.method256("all people not on your friends list", l + 3, l1, 1, 0);
        l1 += 15;
        if(super.anInt629 == 0)
            aClass6_Sub1_935.method256("Block chat messages: @red@<off>", l + 3, l1, 1, 0xffffff);
        else
            aClass6_Sub1_935.method256("Block chat messages: @gre@<on>", l + 3, l1, 1, 0xffffff);
        l1 += 15;
        if(super.anInt630 == 0)
            aClass6_Sub1_935.method256("Block private messages: @red@<off>", l + 3, l1, 1, 0xffffff);
        else
            aClass6_Sub1_935.method256("Block private messages: @gre@<on>", l + 3, l1, 1, 0xffffff);
        l1 += 15;
        if(super.anInt631 == 0)
            aClass6_Sub1_935.method256("Block trade requests: @red@<off>", l + 3, l1, 1, 0xffffff);
        else
            aClass6_Sub1_935.method256("Block trade requests: @gre@<on>", l + 3, l1, 1, 0xffffff);
        l1 += 15;
        if(aBoolean867)
            if(super.anInt632 == 0)
                aClass6_Sub1_935.method256("Block duel requests: @red@<off>", l + 3, l1, 1, 0xffffff);
            else
                aClass6_Sub1_935.method256("Block duel requests: @gre@<on>", l + 3, l1, 1, 0xffffff);
        l1 += 15;
        l1 += 5;
        aClass6_Sub1_935.method256("Always logout when you finish", j1, l1, 1, 0);
        l1 += 15;
        int j2 = 0xffffff;
        if(super.anInt33 > j1 && super.anInt33 < j1 + c1 && super.anInt34 > l1 - 12 && super.anInt34 < l1 + 4)
            j2 = 0xffff00;
        aClass6_Sub1_935.method256("Click here to logout", l + 3, l1, 1, j2);
        if(!arg0)
            return;
        l = super.anInt33 - (((Class6) (aClass6_Sub1_935)).anInt311 - 199);
        i1 = super.anInt34 - 36;
        if(l >= 0 && i1 >= 0 && l < 196 && i1 < 265)
        {
            int k2 = ((Class6) (aClass6_Sub1_935)).anInt311 - 199;
            byte byte0 = 36;
            char c2 = '\304';
            int k1 = k2 + 3;
            int i2 = byte0 + 30;
            if(super.anInt33 > k1 && super.anInt33 < k1 + c2 && super.anInt34 > i2 - 12 && super.anInt34 < i2 + 4 && anInt912 == 1)
            {
                aBoolean666 = !aBoolean666;
                super.aClass14_Sub1_620.method348(157);
                super.aClass14_Sub1_620.method331(0);
                super.aClass14_Sub1_620.method331(aBoolean666 ? 1 : 0);
                super.aClass14_Sub1_620.method330();
            }
            i2 += 15;
            if(super.anInt33 > k1 && super.anInt33 < k1 + c2 && super.anInt34 > i2 - 12 && super.anInt34 < i2 + 4 && anInt912 == 1)
            {
                aBoolean785 = !aBoolean785;
                super.aClass14_Sub1_620.method348(157);
                super.aClass14_Sub1_620.method331(2);
                super.aClass14_Sub1_620.method331(aBoolean785 ? 1 : 0);
                super.aClass14_Sub1_620.method330();

            }
            i2 += 15;
            if(aBoolean867 && super.anInt33 > k1 && super.anInt33 < k1 + c2 && super.anInt34 > i2 - 12 && super.anInt34 < i2 + 4 && anInt912 == 1)
            {
                aBoolean950 = !aBoolean950;
                super.aClass14_Sub1_620.method348(157);
                super.aClass14_Sub1_620.method331(3);
                super.aClass14_Sub1_620.method331(aBoolean950 ? 1 : 0);
                super.aClass14_Sub1_620.method330();
            }
            i2 += 15;
            i2 += 15;
            if(super.anInt33 > k1 && super.anInt33 < k1 + c2 && super.anInt34 > i2 - 12 && super.anInt34 < i2 + 4 && anInt912 == 1)
                toggle("switchWorld");
            i2 += 15;
            if(super.anInt33 > k1 && super.anInt33 < k1 + c2 && super.anInt34 > i2 - 12 && super.anInt34 < i2 + 4 && anInt912 == 1)
                toggle("fogOfWar");
            i2 += 15;
            if(super.anInt33 > k1 && super.anInt33 < k1 + c2 && super.anInt34 > i2 - 12 && super.anInt34 < i2 + 4 && anInt912 == 1)
                toggle("leftySelect");
            i2 += 15;
            boolean flag = false;
            i2 += 35;
            if(super.anInt33 > k1 && super.anInt33 < k1 + c2 && super.anInt34 > i2 - 12 && super.anInt34 < i2 + 4 && anInt912 == 1)
            {
                super.anInt629 = 1 - super.anInt629;
                flag = true;
            }
            i2 += 15;
            if(super.anInt33 > k1 && super.anInt33 < k1 + c2 && super.anInt34 > i2 - 12 && super.anInt34 < i2 + 4 && anInt912 == 1)
            {
                super.anInt630 = 1 - super.anInt630;
                flag = true;
            }
            i2 += 15;
            if(super.anInt33 > k1 && super.anInt33 < k1 + c2 && super.anInt34 > i2 - 12 && super.anInt34 < i2 + 4 && anInt912 == 1)
            {
                super.anInt631 = 1 - super.anInt631;
                flag = true;
            }
            i2 += 15;
            if(aBoolean867 && super.anInt33 > k1 && super.anInt33 < k1 + c2 && super.anInt34 > i2 - 12 && super.anInt34 < i2 + 4 && anInt912 == 1)
            {
                super.anInt632 = 1 - super.anInt632;
                flag = true;
            }
            i2 += 15;
            if(flag)
                method28(super.anInt629, super.anInt630, super.anInt631, super.anInt632);
            i2 += 20;
            if(super.anInt33 > k1 && super.anInt33 < k1 + c2 && super.anInt34 > i2 - 12 && super.anInt34 < i2 + 4 && anInt912 == 1)
                method65();
            anInt912 = 0;
        }
    }

    public final void method115() {
        int i = 0;
        byte byte0 = 50;
        byte byte1 = 50;
        aClass19_903.method406(byte0 * 48 + 23, byte1 * 48 + 23, i);
        aClass19_903.method433(aClass5Array777);
        char c = '\u2600';
        char c1 = '\u1900';
        char c2 = '\u044C';
        char c3 = '\u0378';
        if(fogOfWar) {
            aClass10_939.anInt390 = 4100;
            aClass10_939.anInt391 = 4100;
            aClass10_939.anInt392 = 1;
            aClass10_939.anInt393 = 4000;
        } else {
            aClass10_939.anInt390 = 0x1869f;
            aClass10_939.anInt391 = 0x1869f;
            aClass10_939.anInt392 = 1;
            aClass10_939.anInt393 = 0x1869f;
        }
        aClass10_939.method297(c, -aClass19_903.method404(c, c1), c1, xRotate, c3, 0, c2 * 2);
        aClass10_939.method285();
        aClass6_Sub1_935.method220();
        aClass6_Sub1_935.method220();
        aClass6_Sub1_935.method215(0, 0, 512, 6, 0);
        for(int j = 6; j >= 1; j--)
            aClass6_Sub1_935.method221(0, j, 0, j, 512, 8);

        aClass6_Sub1_935.method215(0, 194, 512, 20, 0);
        for(int k = 6; k >= 1; k--)
            aClass6_Sub1_935.method221(0, k, 0, 194 - k, 512, 8);

        aClass6_Sub1_935.method230(15, 15, anInt778 + 10);
        aClass6_Sub1_935.method229(anInt784, 0, 0, 512, 200);
        aClass6_Sub1_935.method226(anInt784);
        c = '\u2400';
        c1 = '\u2400';
        c2 = '\u044C';
        c3 = '\u0378';
        if(fogOfWar) {
            aClass10_939.anInt390 = 4100;
            aClass10_939.anInt391 = 4100;
            aClass10_939.anInt392 = 1;
            aClass10_939.anInt393 = 4000;
        } else {
            aClass10_939.anInt390 = 0x1869f;
            aClass10_939.anInt391 = 0x1869f;
            aClass10_939.anInt392 = 1;
            aClass10_939.anInt393 = 0x1869f;
        }
        aClass10_939.method297(c, -aClass19_903.method404(c, c1), c1, xRotate, c3, 0, c2 * 2);
        aClass10_939.method285();
        aClass6_Sub1_935.method220();
        aClass6_Sub1_935.method220();
        aClass6_Sub1_935.method215(0, 0, 512, 6, 0);
        for(int l = 6; l >= 1; l--)
            aClass6_Sub1_935.method221(0, l, 0, l, 512, 8);

        aClass6_Sub1_935.method215(0, 194, 512, 20, 0);
        for(int i1 = 6; i1 >= 1; i1--)
            aClass6_Sub1_935.method221(0, i1, 0, 194 - i1, 512, 8);

        aClass6_Sub1_935.method230(15, 15, anInt778 + 10);
        aClass6_Sub1_935.method229(anInt784 + 1, 0, 0, 512, 200);
        aClass6_Sub1_935.method226(anInt784 + 1);
        for(int j1 = 0; j1 < 64; j1++) {
            aClass10_939.method269(aClass19_903.aClass5ArrayArray608[0][j1]);
            aClass10_939.method269(aClass19_903.aClass5ArrayArray590[1][j1]);
            aClass10_939.method269(aClass19_903.aClass5ArrayArray608[1][j1]);
            aClass10_939.method269(aClass19_903.aClass5ArrayArray590[2][j1]);
            aClass10_939.method269(aClass19_903.aClass5ArrayArray608[2][j1]);
        }

        c = '\u2B80';
        c1 = '\u2880';
        c2 = '\u01F4';
        c3 = '\u0178';
        if(fogOfWar) {
            aClass10_939.anInt390 = 4100;
            aClass10_939.anInt391 = 4100;
            aClass10_939.anInt392 = 1;
            aClass10_939.anInt393 = 4000;
        } else {
            aClass10_939.anInt390 = 0x1869f;
            aClass10_939.anInt391 = 0x1869f;
            aClass10_939.anInt392 = 1;
            aClass10_939.anInt393 = 0x1869f;
        }
        aClass10_939.method297(c, -aClass19_903.method404(c, c1), c1, xRotate, c3, 0, c2 * 2);
        aClass10_939.method285();
        aClass6_Sub1_935.method220();
        aClass6_Sub1_935.method220();
        aClass6_Sub1_935.method215(0, 0, 512, 6, 0);
        for(int k1 = 6; k1 >= 1; k1--)
            aClass6_Sub1_935.method221(0, k1, 0, k1, 512, 8);

        aClass6_Sub1_935.method215(0, 194, 512, 20, 0);
        for(int l1 = 6; l1 >= 1; l1--)
            aClass6_Sub1_935.method221(0, l1, 0, 194, 512, 8);

        aClass6_Sub1_935.method230(15, 15, anInt778 + 10);
        aClass6_Sub1_935.method229(anInt778 + 10, 0, 0, 512, 200);
        aClass6_Sub1_935.method226(anInt778 + 10);
    }

    public final void method91() {
        byte byte0 = 7;
        byte byte1 = 15;
        char c = '\257';
        if(anInt912 != 0) {
            for(int i = 0; i < 5; i++) {
                if(i <= 0 || super.anInt33 <= byte0 || super.anInt33 >= byte0 + c || super.anInt34 <= byte1 + i * 20 || super.anInt34 >= byte1 + i * 20 + 20)
                    continue;
                fightMode = anInt775 = i - 1;
                anInt912 = 0;
                super.aClass14_Sub1_620.method348(41);
                super.aClass14_Sub1_620.method331(anInt775);
                super.aClass14_Sub1_620.method330();
                break;
            }

        }
        for(int j = 0; j < 5; j++) {
            if(j == anInt775 + 1)
                aClass6_Sub1_935.method213(byte0, byte1 + j * 20, c, 20, Class6.method222(255, 0, 0), 128);
            else
                aClass6_Sub1_935.method213(byte0, byte1 + j * 20, c, 20, Class6.method222(190, 190, 190), 128);
            aClass6_Sub1_935.method217(byte0, byte1 + j * 20, c, 0);
            aClass6_Sub1_935.method217(byte0, byte1 + j * 20 + 20, c, 0);
        }

        aClass6_Sub1_935.method254("Select combat style", byte0 + c / 2, byte1 + 16, 3, 0xffffff);
        aClass6_Sub1_935.method254("Controlled (+1 of each)", byte0 + c / 2, byte1 + 36, 3, 0);
        aClass6_Sub1_935.method254("Aggressive (+3 strength)", byte0 + c / 2, byte1 + 56, 3, 0);
        aClass6_Sub1_935.method254("Accurate   (+3 attack)", byte0 + c / 2, byte1 + 76, 3, 0);
        aClass6_Sub1_935.method254("Defensive  (+3 defense)", byte0 + c / 2, byte1 + 96, 3, 0);
    }

    public final void method75() {
        if(anInt975 != 0) {
            aClass6_Sub1_935.method220();
            aClass6_Sub1_935.method254("Oh dear! You are dead...", anInt985 / 2, anInt986 / 2, 7, 0xff0000);
            method61();
            aClass6_Sub1_935.method210(aGraphics946, 0, 0);
            return;
        }
        if(aBoolean769) {
            method62();
            return;
        }
        if(aBoolean776) {
            aClass6_Sub1_935.method220();
            if(Math.random() < 0.14999999999999999D)
                aClass6_Sub1_935.method254("ZZZ", (int)(Math.random() * 80D), (int)(Math.random() * 334D), 5, (int)(Math.random() * 16777215D));
            if(Math.random() < 0.14999999999999999D)
                aClass6_Sub1_935.method254("ZZZ", 512 - (int)(Math.random() * 80D), (int)(Math.random() * 334D), 5, (int)(Math.random() * 16777215D));
            aClass6_Sub1_935.method215(anInt985 / 2 - 100, 160, 200, 40, 0);
            aClass6_Sub1_935.method254("You are sleeping", anInt985 / 2, 50, 7, 0xffff00);
            aClass6_Sub1_935.method254("Fatigue: " + (anInt979 * 100) / 750 + "%", anInt985 / 2, 90, 7, 0xffff00);
            aClass6_Sub1_935.method254("When you want to wake up just use your", anInt985 / 2, 140, 5, 0xffffff);
            aClass6_Sub1_935.method254("keyboard to type the word in the box below", anInt985 / 2, 160, 5, 0xffffff);
            aClass6_Sub1_935.method254(super.aString40 + "*", anInt985 / 2, 180, 5, 65535);
            if(aString899 == null)
                aClass6_Sub1_935.method230(anInt985 / 2 - 127, 230, anInt782 + 1);
            else
                aClass6_Sub1_935.method254(aString899, anInt985 / 2, 260, 5, 0xff0000);
            aClass6_Sub1_935.method216(anInt985 / 2 - 128, 229, 257, 42, 0xffffff);
            method61();
            aClass6_Sub1_935.method254("If you can't read the word", anInt985 / 2, 290, 1, 0xffffff);
            aClass6_Sub1_935.method254("@yel@click here@whi@ to get a different one", anInt985 / 2, 305, 1, 0xffffff);
            aClass6_Sub1_935.method210(aGraphics946, 0, 0);
            return;
        }
        if(!aClass19_903.aBoolean613)
            return;
        for(int i = 0; i < 64; i++) {
            aClass10_939.method269(aClass19_903.aClass5ArrayArray608[anInt722][i]);
            if(anInt722 == 0) {
                aClass10_939.method269(aClass19_903.aClass5ArrayArray590[1][i]);
                aClass10_939.method269(aClass19_903.aClass5ArrayArray608[1][i]);
                aClass10_939.method269(aClass19_903.aClass5ArrayArray590[2][i]);
                aClass10_939.method269(aClass19_903.aClass5ArrayArray608[2][i]);
            }
            aBoolean926 = true;
            if(anInt722 == 0 && (aClass19_903.anIntArrayArray611[aClass2_888.anInt149 / 128][aClass2_888.anInt150 / 128] & 0x80) == 0) {
                aClass10_939.method268(aClass19_903.aClass5ArrayArray608[anInt722][i]);
                if(anInt722 == 0) {
                    aClass10_939.method268(aClass19_903.aClass5ArrayArray590[1][i]);
                    aClass10_939.method268(aClass19_903.aClass5ArrayArray608[1][i]);
                    aClass10_939.method268(aClass19_903.aClass5ArrayArray590[2][i]);
                    aClass10_939.method268(aClass19_903.aClass5ArrayArray608[2][i]);
                }
                aBoolean926 = false;
            }
        }

        if(anInt896 != anInt752) {
            anInt752 = anInt896;
            for(int j = 0; j < anInt981; j++) {
                if(anIntArray884[j] == 97)
                    method98(j, "firea" + (anInt896 + 1));
                if(anIntArray884[j] == 274)
                    method98(j, "fireplacea" + (anInt896 + 1));
                if(anIntArray884[j] == 1031)
                    method98(j, "lightning" + (anInt896 + 1));
                if(anIntArray884[j] == 1036)
                    method98(j, "firespell" + (anInt896 + 1));
                if(anIntArray884[j] == 1147)
                    method98(j, "spellcharge" + (anInt896 + 1));
            }

        }
        if(anInt897 != anInt753) {
            anInt753 = anInt897;
            for(int k = 0; k < anInt981; k++) {
                if(anIntArray884[k] == 51)
                    method98(k, "torcha" + (anInt897 + 1));
                if(anIntArray884[k] == 143)
                    method98(k, "skulltorcha" + (anInt897 + 1));
            }

        }
        if(anInt898 != anInt754) {
            anInt754 = anInt898;
            for(int l = 0; l < anInt981; l++)
                if(anIntArray884[l] == 1142)
                    method98(l, "clawspell" + (anInt898 + 1));

        }
        aClass10_939.method272(anInt691);
        anInt691 = 0;
        for(int i1 = 0; i1 < anInt689; i1++) {
            Class2 class2 = aClass2Array904[i1];
            if(class2.anInt171 != 255) {
                int k1 = class2.anInt149;
                int i2 = class2.anInt150;
                int k2 = -aClass19_903.method404(k1, i2);
                int l3 = aClass10_939.method273(5000 + i1, k1, k2, i2, 145, 220, i1 + 10000);
                anInt691++;
                if(class2 == aClass2_888)
                    aClass10_939.method274(l3);
                if(class2.anInt153 == 8)
                    aClass10_939.method275(l3, -30);
                if(class2.anInt153 == 9)
                    aClass10_939.method275(l3, 30);
            }
        }

        for(int j1 = 0; j1 < anInt689; j1++) {
            Class2 class2_1 = aClass2Array904[j1];
            if(class2_1.anInt176 > 0) {
                Class2 class2_2 = null;
                if(class2_1.anInt175 != -1)
                    class2_2 = aClass2Array930[class2_1.anInt175];
                else
                if(class2_1.anInt174 != -1)
                    class2_2 = aClass2Array713[class2_1.anInt174];
                if(class2_2 != null) {
                    int l2 = class2_1.anInt149;
                    int i4 = class2_1.anInt150;
                    int l6 = -aClass19_903.method404(l2, i4) - 110;
                    int l8 = class2_2.anInt149;
                    int k9 = class2_2.anInt150;
                    int l9 = -aClass19_903.method404(l8, k9) - Class1.anIntArray60[class2_2.anInt151] / 2;
                    int i10 = (l2 * class2_1.anInt176 + l8 * (anInt953 - class2_1.anInt176)) / anInt953;
                    int j10 = (l6 * class2_1.anInt176 + l9 * (anInt953 - class2_1.anInt176)) / anInt953;
                    int k10 = (i4 * class2_1.anInt176 + k9 * (anInt953 - class2_1.anInt176)) / anInt953;
                    aClass10_939.method273(anInt781 + class2_1.anInt173, i10, j10, k10, 32, 32, 0);
                    anInt691++;
                }
            }
        }

        for(int l1 = 0; l1 < anInt717; l1++) {
            Class2 class2_3 = aClass2Array705[l1];
            int i3 = class2_3.anInt149;
            int j4 = class2_3.anInt150;
            int i7 = -aClass19_903.method404(i3, j4);
            int i9 = aClass10_939.method273(20000 + l1, i3, i7, j4, Class1.anIntArray59[class2_3.anInt151], Class1.anIntArray60[class2_3.anInt151], l1 + 30000);
            anInt691++;
            if(class2_3.anInt153 == 8)
                aClass10_939.method275(i9, -30);
            if(class2_3.anInt153 == 9)
                aClass10_939.method275(i9, 30);
        }

        for(int j2 = 0; j2 < anInt895; j2++) {
            int j3 = anIntArray966[j2] * anInt729 + 64;
            int k4 = anIntArray967[j2] * anInt729 + 64;
            aClass10_939.method273(40000 + anIntArray968[j2], j3, -aClass19_903.method404(j3, k4) - anIntArray969[j2], k4, 96, 64, j2 + 20000);
            anInt691++;
        }

        for(int k3 = 0; k3 < anInt902; k3++) {
            int l4 = anIntArray954[k3] * anInt729 + 64;
            int j7 = anIntArray767[k3] * anInt729 + 64;
            int j9 = anIntArray792[k3];
            if(j9 == 0) {
                aClass10_939.method273(50000 + k3, l4, -aClass19_903.method404(l4, j7), j7, 128, 256, k3 + 50000);
                anInt691++;
            }
            if(j9 == 1) {
                aClass10_939.method273(50000 + k3, l4, -aClass19_903.method404(l4, j7), j7, 128, 64, k3 + 50000);
                anInt691++;
            }
        }

        aClass6_Sub1_935.aBoolean335 = false;
        aClass6_Sub1_935.method211();
        aClass6_Sub1_935.aBoolean335 = super.aBoolean39;
        if(anInt722 == 3) {
            int i5 = 40 + (int)(Math.random() * 3D);
            int k7 = 40 + (int)(Math.random() * 7D);
            aClass10_939.method309(i5, k7, -50, -10, -50);
        }
        anInt709 = 0;
        anInt697 = 0;
        anInt728 = 0;
        if(aBoolean929) {
            if(aBoolean666 && !aBoolean926) {
                int j5 = anInt731;
                method51();
                if(anInt731 != j5) {
                    anInt879 = aClass2_888.anInt149;
                    anInt880 = aClass2_888.anInt150;
                }
            }
            if(fogOfWar) {
                aClass10_939.anInt390 = 3000;
                aClass10_939.anInt391 = 3000;
                aClass10_939.anInt392 = 1;
                aClass10_939.anInt393 = 2800;
            } else {
                aClass10_939.anInt390 = 0x1869f;
                aClass10_939.anInt391 = 0x1869f;
                aClass10_939.anInt392 = 1;
                aClass10_939.anInt393 = 0x1869f;
            }
            anInt809 = anInt731 * 32;
            int k5 = anInt879 + anInt736;
            int l7 = anInt880 + anInt920;
            aClass10_939.method297(k5, -aClass19_903.method404(k5, l7), l7, xRotate, anInt809 * 4, 0, 2000);
        } else {
            if(aBoolean666 && !aBoolean926)
                method51();
            if(!super.aBoolean39) {
                if(fogOfWar) {
                    aClass10_939.anInt390 = 2400;
                    aClass10_939.anInt391 = 2400;
                    aClass10_939.anInt392 = 1;
                    aClass10_939.anInt393 = 2300;
                } else {
                    aClass10_939.anInt390 = 0x1869f;
                    aClass10_939.anInt391 = 0x1869f;
                    aClass10_939.anInt392 = 1;
                    aClass10_939.anInt393 = 0x1869f;
                }
            } else {
                if(fogOfWar) {
                    aClass10_939.anInt390 = 2200;
                    aClass10_939.anInt391 = 2200;
                    aClass10_939.anInt392 = 1;
                    aClass10_939.anInt393 = 2100;
                } else {
                    aClass10_939.anInt390 = 0x1869f;
                    aClass10_939.anInt391 = 0x1869f;
                    aClass10_939.anInt392 = 1;
                    aClass10_939.anInt393 = 0x1869f;
                }
            }
            int l5 = anInt879 + anInt736;
            int i8 = anInt880 + anInt920;
            aClass10_939.method297(l5, -aClass19_903.method404(l5, i8), i8, xRotate, anInt809 * 4, 0, anInt913 * 2);
        }
        aClass10_939.method285();
        method119();
        if(anInt841 > 0)
            aClass6_Sub1_935.method230(anInt842 - 8, anInt843 - 8, anInt778 + 14 + (24 - anInt841) / 6);
        if(anInt841 < 0)
            aClass6_Sub1_935.method230(anInt842 - 8, anInt843 - 8, anInt778 + 18 + (24 + anInt841) / 6);
        if(anInt807 != 0) {
            int i6 = anInt807 / 50;
            int j8 = i6 / 60;
            i6 %= 60;
            if(i6 < 10)
                aClass6_Sub1_935.method254("System update in: " + j8 + ":0" + i6, 256, anInt986 - 7, 1, 0xffff00);
            else
                aClass6_Sub1_935.method254("System update in: " + j8 + ":" + i6, 256, anInt986 - 7, 1, 0xffff00);
        }
        if(!aBoolean917) {
            if(anInt775 != fightMode)
                setFightMode(fightMode);

            if(showInfo) {
                int i9 = 155;
                aClass6_Sub1_935.method256("@gr1@Username: @whi@" + parsedUsername, 10, i9, 1, 0xffff00);
                i9 += 12;
                aClass6_Sub1_935.method256("@gr1@Health Points: @whi@"+ anIntArray748[3] +"/"+ anIntArray838[3], 10, i9, 1, 0xffff00);
                i9 += 12;
                aClass6_Sub1_935.method256("@gr1@Prayer: @whi@"+ anIntArray748[5] +"/"+ anIntArray838[5], 10, i9, 1, 0xffff00);
                i9 += 12;
                int foodCount = 0;
                for(int i = 0; i < anInt692; i++)
                    if(Class1.aStringArray114[anIntArray693[i]].equals("Eat"))
                        foodCount++;
                aClass6_Sub1_935.method256("@gr1@Food Left: @whi@"+ foodCount, 10, i9, 1, 0xffff00);
                i9 += 24;
                aClass6_Sub1_935.method256("@gr1@"+ BOT_NAME +" "+ BOT_VERSION, 10, i9, 1, 0xffff00);

                aClass6_Sub1_935.method254("@gr1@PiD: "+ aClass2_888.anInt147, 465, anInt986 - 7, 1, 0xffff00);
            }

            int j6 = 2203 - (anInt890 + anInt720 + anInt750);
            if(anInt889 + anInt719 + anInt749 >= 2640)
                j6 = -50;
            if(j6 > 0) {
                int k8 = 1 + j6 / 6;
                aClass6_Sub1_935.method230(453, anInt986 - (showInfo ? 69 : 56), anInt778 + 13);
                aClass6_Sub1_935.method254("Wilderness", 465, anInt986 - (showInfo ? 33 : 20), 1, 0xffff00);
                aClass6_Sub1_935.method254("Level: " + k8, 465, anInt986 - (showInfo ? 20 : 7), 1, 0xffff00);
                if(anInt949 == 0)
                    anInt949 = 2;
            }
            if(anInt949 == 0 && j6 > -10 && j6 <= 0)
                anInt949 = 1;
        }
        if(anInt816 == 0) {
            for(int k6 = 0; k6 < 5; k6++)
                if(anIntArray878[k6] > 0) {
                    String s = aStringArray972[k6];
                    aClass6_Sub1_935.method256(s, 7, anInt986 - 18 - k6 * 12, 1, 0xffff00);
                }

        }
        aClass4_811.method171(anInt812);
        aClass4_811.method171(anInt814);
        aClass4_811.method171(anInt815);
        if(anInt816 == 1)
            aClass4_811.method170(anInt812);
        else
        if(anInt816 == 2)
            aClass4_811.method170(anInt814);
        else
        if(anInt816 == 3)
            aClass4_811.method170(anInt815);
        Class4.anInt225 = 2;
        aClass4_811.method141();
        Class4.anInt225 = 0;
        aClass6_Sub1_935.method232(((Class6) (aClass6_Sub1_935)).anInt311 - 3 - 197, 3, anInt778, 128);
        method111();
        aClass6_Sub1_935.aBoolean338 = false;
        method61();
        aClass6_Sub1_935.method210(aGraphics946, 0, 0);
    }

    public final void method1() {
        if(aBoolean774) {
            String s = getDocumentBase().getHost().toLowerCase();
            if(!s.endsWith("jagex.com") && !s.endsWith("jagex.co.uk") && !s.endsWith("runescape.com") && !s.endsWith("runescape.co.uk") && !s.endsWith("runescape.net") && !s.endsWith("runescape.org") && !s.endsWith("penguin") && !s.endsWith("puffin")) {
                aBoolean988 = true;
                return;
            }
        }
        int i = 0;
        for(int j = 0; j < 99; j++) {
            int k = j + 1;
            int i1 = (int)((double)k + 300D * Math.pow(2D, (double)k / 7D));
            i += i1;
            anIntArray938[j] = i & 0xffffffc;
        }

        try {
            String s1 = getParameter("referid");
            anInt909 = Integer.parseInt(s1);
        }
        catch(Exception _ex) { }
        try {
            String s2 = getParameter("member");
            int j1 = Integer.parseInt(s2);
            if(j1 == 1)
                aBoolean867 = true;
        }
        catch(Exception _ex) { }
        if(aBoolean774)
            super.anInt617 = 43594;
        super.anInt11 = 0;
        Applet_Sub1_Sub1.anInt615 = 1000;
        Applet_Sub1_Sub1.anInt614 = Class18.anInt573;
        try {
            String s3 = getParameter("poff");
            int k1 = Integer.parseInt(s3);
            super.anInt617 += k1;
            System.out.println("Offset: " + k1);
        }
        catch(Exception _ex) { }
        method53();
        if(aBoolean937)
            return;
        anInt778 = 2000;
        anInt779 = anInt778 + 100;
        anInt780 = anInt779 + 50;
        anInt784 = anInt780 + 1000;
        anInt781 = anInt784 + 10;
        anInt782 = anInt781 + 50;
        anInt783 = anInt782 + 10;
        aGraphics946 = getGraphics();
        method8(50);
        aClass6_Sub1_935 = new Class6_Sub1(anInt985, anInt986 + 12, 4000, this);
        aClass6_Sub1_935.aMudclient641 = this;
        aClass6_Sub1_935.method208(0, 0, anInt985, anInt986 + 12);
        Class4.aBoolean220 = false;
        Class4.anInt221 = anInt779;
        aClass4_733 = new Class4(aClass6_Sub1_935, 5);
        int l = ((Class6) (aClass6_Sub1_935)).anInt311 - 199;
        byte byte0 = 36;
        anInt734 = aClass4_733.method162(l, byte0 + 24, 196, 90, 1, 500, true);
        aClass4_989 = new Class4(aClass6_Sub1_935, 5);
        anInt990 = aClass4_989.method162(l, byte0 + 40, 196, 126, 1, 500, true);
        aClass4_834 = new Class4(aClass6_Sub1_935, 5);
        anInt835 = aClass4_834.method162(l, byte0 + 24, 196, 251, 1, 500, true);
        method80();
        if(aBoolean937)
            return;
        method101();
        if(aBoolean937)
            return;
        aClass10_939 = new Class10(aClass6_Sub1_935, 15000, 15000, 1000);
        aClass10_939.method280(anInt985 / 2, anInt986 / 2, anInt985 / 2, anInt986 / 2, anInt985, anInt987);
        if(fogOfWar) {
            aClass10_939.anInt390 = 2400;
            aClass10_939.anInt391 = 2400;
            aClass10_939.anInt392 = 1;
            aClass10_939.anInt393 = 2300;
        } else {
            aClass10_939.anInt390 = 0x1869f;
            aClass10_939.anInt391 = 0x1869f;
            aClass10_939.anInt392 = 1;
            aClass10_939.anInt393 = 0x1869f;
        }
        aClass10_939.method308(-50, -10, -50);
        aClass19_903 = new Class19(aClass10_939, aClass6_Sub1_935);
        aClass19_903.anInt598 = anInt778;
        method59();
        if(aBoolean937)
            return;
        method54();
        if(aBoolean937)
            return;
        method92();
        if(aBoolean937)
            return;
        if(aBoolean867)
            method90();
        if(aBoolean937) {
            return;
        } else {
            method15(100, "Starting game...");
            method87();
            method110();
            method95();
            method73();
            method5();
            method115();
            return;
        }
    }

    public final void method89() {
        if(anInt807 > 1)
            anInt807--;
        method25();
        if(anInt810 > 0)
            anInt810--;
/*      Removed to stop automatic logout
        if(super.anInt12 > 4500 && anInt675 == 0 && anInt810 == 0) {
            super.anInt12 -= 500;
            method65();
            return;
        }
*/
        if(aClass2_888.anInt153 == 8 || aClass2_888.anInt153 == 9)
            anInt675 = 500;
        if(anInt675 > 0)
            anInt675--;
        if(aBoolean769) {
            method46();
            return;
        }
        for(int i = 0; i < anInt689; i++) {
            Class2 class2 = aClass2Array904[i];
            int k = (class2.anInt156 + 1) % 10;
            if(class2.anInt155 != k) {
                int i1 = -1;
                int l2 = class2.anInt155;
                int j4;
                if(l2 < k)
                    j4 = k - l2;
                else
                    j4 = (10 + k) - l2;
                int j5 = 4;
                if(j4 > 2)
                    j5 = (j4 - 1) * 4;
                if(class2.anIntArray157[l2] - class2.anInt149 > anInt729 * 3 || class2.anIntArray158[l2] - class2.anInt150 > anInt729 * 3 || class2.anIntArray157[l2] - class2.anInt149 < -anInt729 * 3 || class2.anIntArray158[l2] - class2.anInt150 < -anInt729 * 3 || j4 > 8) {
                    class2.anInt149 = class2.anIntArray157[l2];
                    class2.anInt150 = class2.anIntArray158[l2];
                } else {
                    if(class2.anInt149 < class2.anIntArray157[l2]) {
                        class2.anInt149 += j5;
                        class2.anInt152++;
                        i1 = 2;
                    } else
                    if(class2.anInt149 > class2.anIntArray157[l2]) {
                        class2.anInt149 -= j5;
                        class2.anInt152++;
                        i1 = 6;
                    }
                    if(class2.anInt149 - class2.anIntArray157[l2] < j5 && class2.anInt149 - class2.anIntArray157[l2] > -j5)
                        class2.anInt149 = class2.anIntArray157[l2];
                    if(class2.anInt150 < class2.anIntArray158[l2]) {
                        class2.anInt150 += j5;
                        class2.anInt152++;
                        if(i1 == -1)
                            i1 = 4;
                        else
                        if(i1 == 2)
                            i1 = 3;
                        else
                            i1 = 5;
                    } else
                    if(class2.anInt150 > class2.anIntArray158[l2]) {
                        class2.anInt150 -= j5;
                        class2.anInt152++;
                        if(i1 == -1)
                            i1 = 0;
                        else
                        if(i1 == 2)
                            i1 = 1;
                        else
                            i1 = 7;
                    }
                    if(class2.anInt150 - class2.anIntArray158[l2] < j5 && class2.anInt150 - class2.anIntArray158[l2] > -j5)
                        class2.anInt150 = class2.anIntArray158[l2];
                }
                if(i1 != -1)
                    class2.anInt153 = i1;
                if(class2.anInt149 == class2.anIntArray157[l2] && class2.anInt150 == class2.anIntArray158[l2])
                    class2.anInt155 = (l2 + 1) % 10;
            } else {
                class2.anInt153 = class2.anInt154;
            }
            if(class2.anInt161 > 0)
                class2.anInt161--;
            if(class2.anInt163 > 0)
                class2.anInt163--;
            if(class2.anInt167 > 0)
                class2.anInt167--;
            if(anInt975 > 0) {
                anInt975--;
                if(anInt975 == 0)
                    method97("You have been granted another life. Be more careful this time!", 3);
                if(anInt975 == 0)
                    method97("You retain your skills. Your objects land where you died", 3);
            }
        }

        for(int j = 0; j < anInt717; j++) {
            Class2 class2_1 = aClass2Array705[j];
            int j1 = (class2_1.anInt156 + 1) % 10;
            if(class2_1.anInt155 != j1) {
                int i3 = -1;
                int k4 = class2_1.anInt155;
                int k5;
                if(k4 < j1)
                    k5 = j1 - k4;
                else
                    k5 = (10 + j1) - k4;
                int l5 = 4;
                if(k5 > 2)
                    l5 = (k5 - 1) * 4;
                if(class2_1.anIntArray157[k4] - class2_1.anInt149 > anInt729 * 3 || class2_1.anIntArray158[k4] - class2_1.anInt150 > anInt729 * 3 || class2_1.anIntArray157[k4] - class2_1.anInt149 < -anInt729 * 3 || class2_1.anIntArray158[k4] - class2_1.anInt150 < -anInt729 * 3 || k5 > 8) {
                    class2_1.anInt149 = class2_1.anIntArray157[k4];
                    class2_1.anInt150 = class2_1.anIntArray158[k4];
                } else {
                    if(class2_1.anInt149 < class2_1.anIntArray157[k4]) {
                        class2_1.anInt149 += l5;
                        class2_1.anInt152++;
                        i3 = 2;
                    } else
                    if(class2_1.anInt149 > class2_1.anIntArray157[k4]) {
                        class2_1.anInt149 -= l5;
                        class2_1.anInt152++;
                        i3 = 6;
                    }
                    if(class2_1.anInt149 - class2_1.anIntArray157[k4] < l5 && class2_1.anInt149 - class2_1.anIntArray157[k4] > -l5)
                        class2_1.anInt149 = class2_1.anIntArray157[k4];
                    if(class2_1.anInt150 < class2_1.anIntArray158[k4]) {
                        class2_1.anInt150 += l5;
                        class2_1.anInt152++;
                        if(i3 == -1)
                            i3 = 4;
                        else
                        if(i3 == 2)
                            i3 = 3;
                        else
                            i3 = 5;
                    } else
                    if(class2_1.anInt150 > class2_1.anIntArray158[k4]) {
                        class2_1.anInt150 -= l5;
                        class2_1.anInt152++;
                        if(i3 == -1)
                            i3 = 0;
                        else
                        if(i3 == 2)
                            i3 = 1;
                        else
                            i3 = 7;
                    }
                    if(class2_1.anInt150 - class2_1.anIntArray158[k4] < l5 && class2_1.anInt150 - class2_1.anIntArray158[k4] > -l5)
                        class2_1.anInt150 = class2_1.anIntArray158[k4];
                }
                if(i3 != -1)
                    class2_1.anInt153 = i3;
                if(class2_1.anInt149 == class2_1.anIntArray157[k4] && class2_1.anInt150 == class2_1.anIntArray158[k4])
                    class2_1.anInt155 = (k4 + 1) % 10;
            } else {
                class2_1.anInt153 = class2_1.anInt154;
                if(class2_1.anInt151 == 43)
                    class2_1.anInt152++;
            }
            if(class2_1.anInt161 > 0)
                class2_1.anInt161--;
            if(class2_1.anInt163 > 0)
                class2_1.anInt163--;
            if(class2_1.anInt167 > 0)
                class2_1.anInt167--;
        }

        if(anInt725 != 2) {
            if(Class6.anInt346 > 0)
                anInt668++;
            if(Class6.anInt347 > 0)
                anInt668 = 0;
            Class6.anInt346 = 0;
            Class6.anInt347 = 0;
        }
        for(int l = 0; l < anInt689; l++) {
            Class2 class2_2 = aClass2Array904[l];
            if(class2_2.anInt176 > 0)
                class2_2.anInt176--;
        }

        if(aBoolean929) {
            if(anInt879 - aClass2_888.anInt149 < -500 || anInt879 - aClass2_888.anInt149 > 500 || anInt880 - aClass2_888.anInt150 < -500 || anInt880 - aClass2_888.anInt150 > 500) {
                anInt879 = aClass2_888.anInt149;
                anInt880 = aClass2_888.anInt150;
            }
        } else {
            if(anInt879 - aClass2_888.anInt149 < -500 || anInt879 - aClass2_888.anInt149 > 500 || anInt880 - aClass2_888.anInt150 < -500 || anInt880 - aClass2_888.anInt150 > 500) {
                anInt879 = aClass2_888.anInt149;
                anInt880 = aClass2_888.anInt150;
            }
            if(anInt879 != aClass2_888.anInt149)
                anInt879 += (aClass2_888.anInt149 - anInt879) / (16 + (anInt913 - 500) / 15);
            if(anInt880 != aClass2_888.anInt150)
                anInt880 += (aClass2_888.anInt150 - anInt880) / (16 + (anInt913 - 500) / 15);
            if(aBoolean666) {
                int k1 = anInt731 * 32;
                int j3 = k1 - anInt809;
                byte byte0 = 1;
                if(j3 != 0) {
                    anInt732++;
                    if(j3 > 128) {
                        byte0 = -1;
                        j3 = 256 - j3;
                    } else
                    if(j3 > 0)
                        byte0 = 1;
                    else
                    if(j3 < -128) {
                        byte0 = 1;
                        j3 = 256 + j3;
                    } else
                    if(j3 < 0) {
                        byte0 = -1;
                        j3 = -j3;
                    }
                    anInt809 += ((anInt732 * j3 + 255) / 256) * byte0;
                    anInt809 &= 0xff;
                } else {
                    anInt732 = 0;
                }
            }
        }
        if(anInt668 > 20) {
            aBoolean914 = false;
            anInt668 = 0;
        }
        if(aBoolean776) {
            if(super.aString41.length() > 0)
                if(super.aString41.equalsIgnoreCase("::lostcon") && !aBoolean774)
                    super.aClass14_Sub1_620.method328();
                else
                if(super.aString41.equalsIgnoreCase("::closecon") && !aBoolean774) {
                    method22();
                } else {
                    super.aClass14_Sub1_620.method348(72);
                    super.aClass14_Sub1_620.method346(super.aString41);
                    if(!aBoolean914) {
                        super.aClass14_Sub1_620.method331(0);
                        aBoolean914 = true;
                    }
                    super.aClass14_Sub1_620.method330();
                    super.aString40 = "";
                    super.aString41 = "";
                    aString899 = "Please wait...";
                }
            if(super.anInt36 == 1 && super.anInt34 > 275 && super.anInt34 < 310 && super.anInt33 > 56 && super.anInt33 < 456) {
                super.aClass14_Sub1_620.method348(72);
                super.aClass14_Sub1_620.method346("-null-");
                if(!aBoolean914) {
                    super.aClass14_Sub1_620.method331(0);
                    aBoolean914 = true;
                }
                super.aClass14_Sub1_620.method330();
                super.aString40 = "";
                super.aString41 = "";
                aString899 = "Please wait...";
            }
            super.anInt36 = 0;
            return;
        }
        if(super.anInt34 > anInt986 - 4) {
            if(super.anInt33 > 15 && super.anInt33 < 96 && super.anInt36 == 1)
                anInt816 = 0;
            if(super.anInt33 > 110 && super.anInt33 < 194 && super.anInt36 == 1) {
                anInt816 = 1;
                aClass4_811.anIntArray187[anInt812] = 0xf423f;
            }
            if(super.anInt33 > 215 && super.anInt33 < 295 && super.anInt36 == 1) {
                anInt816 = 2;
                aClass4_811.anIntArray187[anInt814] = 0xf423f;
            }
            if(super.anInt33 > 315 && super.anInt33 < 395 && super.anInt36 == 1) {
                anInt816 = 3;
                aClass4_811.anIntArray187[anInt815] = 0xf423f;
            }
            if(super.anInt33 > 417 && super.anInt33 < 497 && super.anInt36 == 1) {
                anInt738 = 1;
                anInt839 = 0;
                super.aString40 = "";
                super.aString41 = "";
            }
            super.anInt36 = 0;
            super.anInt35 = 0;
        }
        aClass4_811.method138(super.anInt33, super.anInt34, super.anInt36, super.anInt35);
        if(anInt816 > 0 && super.anInt33 >= 494 && super.anInt34 >= anInt986 - 66)
            super.anInt36 = 0;
        if(aClass4_811.method139(anInt813)) {
            String s = aClass4_811.method169(anInt813);
            aClass4_811.method168(anInt813, "");
            if(s.startsWith("::")) {
                if(s.equalsIgnoreCase("::closecon") && !aBoolean774)
                    super.aClass14_Sub1_620.method328();
                else
                if(s.equalsIgnoreCase("::logout") && !aBoolean774)
                    method22();
                else
                if(s.equalsIgnoreCase("::lostcon") && !aBoolean774)
                    method23();
                else
                    method35(s.substring(2));
            } else {
                int k3 = Class17.method399(s);
                method34(Class17.aByteArray569, k3);
                s = Class17.method398(Class17.aByteArray569, 0, k3);
                s = Class16.method373(s);
                aClass2_888.anInt161 = 150;
                aClass2_888.aString160 = s;
                method97(aClass2_888.aString146 + ": " + s, 2);
            }
        }
        if(anInt816 == 0) {
            for(int l1 = 0; l1 < 5; l1++)
                if(anIntArray878[l1] > 0)
                    anIntArray878[l1]--;

        }
        if(anInt975 != 0)
            super.anInt36 = 0;
        if(aBoolean974 || aBoolean932) {
            if(super.anInt35 != 0)
                anInt893++;
            else
                anInt893 = 0;
            if(anInt893 > 600)
                anInt894 += 5000;
            else
            if(anInt893 > 450)
                anInt894 += 500;
            else
            if(anInt893 > 300)
                anInt894 += 50;
            else
            if(anInt893 > 150)
                anInt894 += 5;
            else
            if(anInt893 > 50)
                anInt894++;
            else
            if(anInt893 > 20 && (anInt893 & 5) == 0)
                anInt894++;
        } else {
            anInt893 = 0;
            anInt894 = 0;
        }
        if(super.anInt36 == 1)
            anInt912 = 1;
        else
        if(super.anInt36 == 2)
            anInt912 = 2;
        aClass10_939.method276(super.anInt33, super.anInt34);
        super.anInt36 = 0;
        if(aBoolean666) {
            if(anInt732 == 0 || aBoolean929) {
                if(super.aBoolean26) {
                    anInt731 = anInt731 + 1 & 7;
                    super.aBoolean26 = false;
                    if(!aBoolean926) {
                        if((anInt731 & 1) == 0)
                            anInt731 = anInt731 + 1 & 7;
                        for(int i2 = 0; i2 < 8; i2++) {
                            if(method100(anInt731))
                                break;
                            anInt731 = anInt731 + 1 & 7;
                        }

                    }
                }
                if(super.aBoolean27) {
                    anInt731 = anInt731 + 7 & 7;
                    super.aBoolean27 = false;
                    if(!aBoolean926) {
                        if((anInt731 & 1) == 0)
                            anInt731 = anInt731 + 7 & 7;
                        for(int j2 = 0; j2 < 8; j2++) {
                            if(method100(anInt731))
                                break;
                            anInt731 = anInt731 + 7 & 7;
                        }

                    }
                }
            }
        } else
        if(super.aBoolean26)
            anInt809 = anInt809 + 2 & 0xff;
        else
        if(super.aBoolean27)
            anInt809 = anInt809 - 2 & 0xff;
/*      Removed to stop zoom-back
        if(aBoolean926 && anInt913 > 550)
            anInt913 -= 4;
        else
        if(!aBoolean926 && anInt913 < 750)
            anInt913 += 4;
*/
        if(keyPress[0] && anInt913 >= 365)
            anInt913 -= 15;
        if(keyPress[1] && anInt913 <= 5000)
            anInt913 += 15;
        if(keyPress[2])
            xRotate -= 5;
        if(keyPress[3])
            xRotate += 5;
        if(keyPress[4] && mapZoom <= 125)
            mapZoom += 5;
        if(keyPress[5] && mapZoom >= -100)
            mapZoom -= 5;

        if(anInt841 > 0)
            anInt841--;
        else
        if(anInt841 < 0)
            anInt841++;
        aClass10_939.method306(17);
        anInt958++;
        if(anInt958 > 5) {
            anInt958 = 0;
            anInt896 = (anInt896 + 1) % 3;
            anInt897 = (anInt897 + 1) % 4;
            anInt898 = (anInt898 + 1) % 5;
        }
        for(int k2 = 0; k2 < anInt981; k2++) {
            int l3 = anIntArray882[k2];
            int l4 = anIntArray883[k2];
            if(l3 >= 0 && l4 >= 0 && l3 < 96 && l4 < 96 && anIntArray884[k2] == 74)
                aClass5Array805[k2].method188(1, 0, 0);
        }

        for(int i4 = 0; i4 < anInt902; i4++) {
            anIntArray933[i4]++;
            if(anIntArray933[i4] > 50) {
                anInt902--;
                for(int i5 = i4; i5 < anInt902; i5++) {
                    anIntArray954[i5] = anIntArray954[i5 + 1];
                    anIntArray767[i5] = anIntArray767[i5 + 1];
                    anIntArray933[i5] = anIntArray933[i5 + 1];
                    anIntArray792[i5] = anIntArray792[i5 + 1];
                }

            }
        }

    }


    public final int method44() {
/*      Removed to stop limiting a single login on a server
        return Class8.anInt371;
*/
        return (int)(Math.random() * 99999999D);
    }

    public final void method111() {
        if(anInt810 != 0)
            method57();
/*      Removed to stop Login, Members, and Wilderness windows from showing.
        else
        if(aBoolean817)
            method64();
        else
        if(aBoolean743)
            method109();
        else
        if(anInt949 == 1)
            method67();
*/
        else
        if(aBoolean699 && anInt675 == 0)
            method56();
        else
        if(aBoolean940 && anInt675 == 0)
            method86();
        else
        if(aBoolean900)
            method105();
        else
        if(aBoolean974)
            method99();
        else
        if(aBoolean944)
            method93();
        else
        if(aBoolean932)
            method108();
        else
        if(anInt738 == 1)
            method50();
        else
        if(anInt738 == 2)
            method96();
        else
        if(anInt773 != 0) {
            method113();
        } else {
            if(aBoolean727)
                method77();
            if(aClass2_888.anInt153 == 8 || aClass2_888.anInt153 == 9)
                method91();
            method69();
            boolean flag = !aBoolean727 && !aBoolean951;
            if(flag)
                anInt763 = 0;
            if(anInt725 == 0 && flag)
                method81();
            if(anInt725 == 1)
                method58(flag);
            if(anInt725 == 2)
                method120(flag);
            if(anInt725 == 3)
                method66(flag);
            if(anInt725 == 4)
                method85(flag);
            if(anInt725 == 5)
                method83(flag);
            if(anInt725 == 6)
                method88(flag);
            if(!aBoolean951 && !aBoolean727)
                method82();
            if(aBoolean951 && !aBoolean727)
                method76();
        }
        anInt912 = 0;
    }

    public final void method13() {
        aGraphics22.setColor(Color.black);
        aGraphics22.fillRect(0, 0, anInt1, anInt2);
        aGraphics22.drawImage(anImage21, 81, 65, this);
        Class6.method251("h11p", 0, this);
        Class6.method251("h12b", 1, this);
        Class6.method251("h12p", 2, this);
        Class6.method251("h13b", 3, this);
        Class6.method251("h14b", 4, this);
        Class6.method251("h16b", 5, this);
        Class6.method251("h20b", 6, this);
        Class6.method251("h24b", 7, this);
        return;
    }

    public void method14(int i, String s) {
        try {
            int j = (anInt1 - 281) / 2;
            int k = (anInt2 - 148) / 2;
            aGraphics22.setColor(Color.black);
            aGraphics22.fillRect(0, 0, anInt1, anInt2);
            if(!aBoolean15)
                aGraphics22.drawImage(anImage21, 81, 65, this);
            j += 2;
            k += 90;
            anInt16 = i;
            aString17 = s;
            aGraphics22.setColor(new Color(132, 132, 132));
            if(aBoolean15)
                aGraphics22.setColor(new Color(220, 0, 0));
            aGraphics22.drawRect(j - 2, k - 2, 280, 23);
            aGraphics22.fillRect(j, k, (277 * i) / 100, 20);
            aGraphics22.setColor(new Color(198, 198, 198));
            if(aBoolean15)
                aGraphics22.setColor(new Color(255, 255, 255));
            method16(aGraphics22, s, aFont18, j + 138, k + 10);
            if(!aBoolean15) {
                method16(aGraphics22, "\2512001-2002 Andrew Gower and Jagex Ltd", aFont19, j + 138, k + 30);
                method16(aGraphics22, "Modifed & Improved by BobDole81", aFont19, j + 138, k + 44);
            } else {
                aGraphics22.setColor(new Color(132, 132, 152));
                method16(aGraphics22, "\2512001-2002 Andrew Gower and Jagex Ltd", aFont20, j + 138, anInt2 - 20);
            }
            if(aString14 != null) {
                aGraphics22.setColor(Color.white);
                method16(aGraphics22, aString14, aFont19, j + 138, k - 120);
                return;
            }
        }
        catch(Exception _ex) { }
    }


    /*
     * Other Bot Function Methods
     */

    private void toggle(String keyCommand) {
        if(keyCommand.equals("protectItems")) {
            prayerToggle(8);
        } else if(keyCommand.equals("steelSkin")) {
            prayerToggle(9);
        } else if(keyCommand.equals("ultimateStrength")) {
            prayerToggle(10);
        } else if(keyCommand.equals("incredibleReflexes")) {
            prayerToggle(11);
        } else if(keyCommand.equals("runPrayerCombo")) {
            prayerCombo = !prayerCombo;
            for(int i = 0; i < prayerComboList.length; i++)
                if(prayerComboList[i])
                    prayerToggle(i, prayerCombo);
            method97(outputPrefix +"Prayer Combo: "+ (prayerCombo ? "@gre@<on>" : "@red@<off>"), 10);
        } else if(keyCommand.equals("leftySelect")) {
            leftySelect++;
            if(leftySelect == 4)
                leftySelect = 0;

            if(leftySelect == 0 && anInt912 == 0)
                method97(outputPrefix +"Lefties @red@<off>", 10);
            else if(leftySelect == 1 && anInt912 == 0)
                method97(outputPrefix +"Lefties: @gre@<NPCs>", 10);
            else if(leftySelect == 2 && anInt912 == 0)
                method97(outputPrefix +"Lefties: @gre@<Players>", 10);
            else if(leftySelect == 3 && anInt912 == 0)
                method97(outputPrefix +"Lefties: @gre@<NPCs & Players>", 10);
        } else if(keyCommand.equals("selectWorld")) {
            selectedServer++;
            if(selectedServer == 7)
                selectedServer = 1;

            method97(outputPrefix +"Selecting World: @yel@"+ selectedServer +" @gr2@(Currently On World: @yel@"+ currentServer +"@gr2@).", 10);
        } else if(keyCommand.equals("switchWorld")) {
            method22();
            method21(parsedUsername + selectedServer, parsedPassword, false);
        } else if(keyCommand.equals("fogOfWar")) {
            fogOfWar = !fogOfWar;
            method97(outputPrefix +"Fog of War: "+ (fogOfWar ? "@gre@<on>" : "@red@<off>"), 10);
        } else if(keyCommand.equals("fightModeSwitch")) {
            fightMode++;
            if(fightMode == 4)
                fightMode = 0;

            setFightMode(fightMode);

            String[] fightModes = new String[] {"Controlled", "Aggressive", "Accurate", "Defensive"};
            method97(outputPrefix +"Fight Mode: @yel@"+ fightModes[fightMode], 10);
        } else if(keyCommand.equals("showInfo")) {
            showInfo = !showInfo;
            method97(outputPrefix +"OnScreen Info: "+ (showInfo ? "@gre@<on>" : "@red@<off>"), 10);
        }
    }

    private void setFightMode(int i) {
        fightMode = anInt775 = i;
        super.aClass14_Sub1_620.method348(41);
        super.aClass14_Sub1_620.method331(anInt775);
        super.aClass14_Sub1_620.method330();
    }

    private void prayerToggle(int prayerId) {
        prayerToggle(prayerId, !aBooleanArray710[prayerId]);
        method97(outputPrefix + Class1.aStringArray96[prayerId] +" "+ (aBooleanArray710[prayerId] ? "@gre@On": "@red@Off"), 10);
    }

    private void prayerToggle(int prayerId, boolean prayerStatus) {
        if(Class1.anIntArray137[prayerId] > anIntArray838[5]) {
            method97(outputPrefix +"Prayer level ("+ anIntArray838[5] +") not high enough for "+ Class1.aStringArray96[prayerId] +" ("+ Class1.anIntArray137[prayerId] +")!", 10);
            return;
        } else if(anIntArray748[5] == 0) {
            method97("You have run out of prayer points. Return to a church to recharge", 3);
            return;
        }

        if(!prayerStatus) {
            super.aClass14_Sub1_620.method348(248);
            super.aClass14_Sub1_620.method331(prayerId);
            super.aClass14_Sub1_620.method330();
            aBooleanArray710[prayerId] = false;
            method102("prayeroff");
        } else {
            super.aClass14_Sub1_620.method348(56);
            super.aClass14_Sub1_620.method331(prayerId);
            super.aClass14_Sub1_620.method330();
            aBooleanArray710[prayerId] = true;
            method102("prayeron");
        }
    }

    private void updateServer(int worldNumber) {
        anInt617 = (worldNumber % 2 == 0) ? 43595 : 43594;

        if(worldNumber == 1 || worldNumber == 2)
            aString616 = "uk1.runescape.com";
        else if(worldNumber == 3 || worldNumber == 4)
            aString616 = "ul3.runescape.com";
        else if(worldNumber == 5 || worldNumber == 6)
            aString616 = "nl9.runescape.com";

        currentServer = worldNumber;
    }

    private void takePic() throws IOException {
        int picNumber = -1;
    
        File picsFolder = new File(".", "/ScreenShots/");
        if(!picsFolder.isDirectory() || !picsFolder.exists())
            picsFolder.mkdir();
        String directoryFiles[] = picsFolder.list();
        for(int i = 0; i < directoryFiles.length; i++) {
            try {
                if(!directoryFiles[i].endsWith(".png") || directoryFiles[i].indexOf('$') != -1 || !directoryFiles[i].startsWith("Pic"))
                    continue;
                int selectedPicNumber = Integer.parseInt(directoryFiles[i].substring(directoryFiles[i].indexOf("Pic") + 3, directoryFiles[i].indexOf(".png")));
                if(selectedPicNumber > picNumber)
                    picNumber = selectedPicNumber;
            } catch(Exception e) {}
        }
        picNumber++;

        File picFile = new File("./Screenshots/", "Pic"+ picNumber +".png");
        BufferedImage picBufferedImage = new BufferedImage(512, 347, BufferedImage.TYPE_INT_RGB);
        Graphics picGraphics = picBufferedImage.createGraphics();
        picGraphics.drawImage(aClass6_Sub1_935.anImage320, 0, 0, this);
        picGraphics.dispose();
        ImageIO.write(picBufferedImage, "png", picFile);
        System.out.println("Screenshot written as: ./ScreenShots/Pic"+ picNumber +".png.");
    }

    private void downloadFile(String fileName, File outputName) {
        try {
            System.out.print("Downloading: "+ outputName.toString().substring(outputName.toString().lastIndexOf("\\") + 1, outputName.toString().length()) +"...");
            URL fileURL = new URL(fileName);
            if(outputName.exists())
                outputName.delete();
            outputName.createNewFile();
            byte[] byteBuffer = new byte[1024];
            int byteHolder;
            BufferedInputStream fileInputStream = new BufferedInputStream(fileURL.openStream());
            FileOutputStream fileOutputStream = new FileOutputStream(outputName);

            // My leet text animation
            Runnable textAnimation = new Runnable() {
                public final void run() {
                    while(true) {
                        try {
                            System.out.print("\\");
                            Thread.sleep(135);
                            System.out.print('\b');
                            System.out.print("|");
                            Thread.sleep(135);
                            System.out.print('\b');
                            System.out.print("/");
                            Thread.sleep(135);
                            System.out.print('\b');
                            System.out.print("-");
                            Thread.sleep(135);
                            System.out.print('\b');
                        } catch(InterruptedException e) {}
                    }
                }
            };

            Thread waiterThread = new Thread(textAnimation);
            waiterThread.start();
            while((byteHolder = fileInputStream.read(byteBuffer)) != -1)
                fileOutputStream.write(byteBuffer, 0, byteHolder);

            waiterThread.stop();
            System.out.print('\b');
            System.out.println("Download completed successfully!");
            fileInputStream.close();
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private void loadData(String libraryFileName, File libraryFile) {
        try {
            InputStream libraryStream = new FileInputStream(libraryFile);
            long byteSize = libraryFile.length();
            byte[] byteBuffer = new byte[(int)byteSize];
            int byteOffset = 0;
            int byteHolder = 0;
            while(byteOffset < byteBuffer.length && (byteHolder = libraryStream.read(byteBuffer, byteOffset, byteBuffer.length - byteOffset)) != -1)
                byteOffset += byteHolder;
            
            libraryStream.close();
            Class8.method263(libraryFileName, byteBuffer);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }


    /*
     * Keypress Methods
     */

    public synchronized boolean keyDown(Event keyEvent, int keyCode) {
        if(keyCode == Event.UP)
            keyPress[0] = true;
        if(keyCode == Event.DOWN)
            keyPress[1] = true;
        if(keyCode == Event.PGUP)
            keyPress[2] = true;
        if(keyCode == Event.PGDN)
            keyPress[3] = true;
        if(keyCode == Event.HOME)
            keyPress[4] = true;
        if(keyCode == Event.END)
            keyPress[5] = true;


        if(keyCode == Event.F2)
            toggle("fogOfWar");
        if(keyCode == Event.F3)
            toggle("showInfo");
        if(keyCode == Event.F4)
            toggle("fightModeSwitch");
        if(keyCode == Event.F5)
            toggle("");
        if(keyCode == Event.F6)
            toggle("takePic");
        if(keyCode == Event.F7)
            toggle("runPrayerCombo");
        if(keyCode == Event.F8)
            toggle("selectWorld");
        if(keyCode == Event.F9)
            toggle("protectItems");
        if(keyCode == Event.F10)
            toggle("steelSkin");
        if(keyCode == Event.F11)
            toggle("ultimateStrength");
        if(keyCode == Event.F12)
            toggle("incredibleReflexes");

        return super.keyDown(keyEvent, keyCode);
    }

    public synchronized boolean keyUp(Event keyEvent, int keyCode) {
        if(keyCode == Event.UP)
            keyPress[0] = false;
        if(keyCode == Event.DOWN)
            keyPress[1] = false;
        if(keyCode == Event.PGUP)
            keyPress[2] = false;
        if(keyCode == Event.PGDN)
            keyPress[3] = false;
        if(keyCode == Event.HOME)
            keyPress[4] = false;
        if(keyCode == Event.END)
            keyPress[5] = false;

        return super.keyUp(keyEvent, keyCode);
    }


    /**
     * No-argument class constructor
     */
    public Bot() {
        anInt735 = 1;                  // Selects the prayer menu by default.
        anImage21 = Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir") + "/Data/logo.dat");

        Arrays.fill(keyPress, false);
        Arrays.fill(prayerComboList, false);
    }
}