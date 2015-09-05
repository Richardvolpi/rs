// Decompiled by DJ v3.6.6.79 Copyright 2004 Atanas Neshkov  Date: 10/26/2004 8:16:57 PM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   mudclient.java

import java.applet.Applet;
import java.awt.*;
import java.io.IOException;
import java.io.PrintStream;
import java.net.*;

public final class mudclient extends Applet_Sub1_Sub1
{
    /* member class not found */
    class script {}

    /* member class not found */
    class chatSpam {}


    public mudclient()
    {
        autofighter = false;
        Playerleft = true;
        autologin = false;
        chatSpammer = false;
        int i = Class1.anInt144;
        foodID = 373;
        adk = 3000;
        prayerid = 1;
        prayerdot = 1;
        styleCnt = 1;
        MacroTime = 150;
        choseWorld = 51;
        foodName = "Lobster";
        prayername = "Burst";
        aBooleanArray662 = new boolean[1500];
        anIntArray664 = new int[8];
        anIntArray665 = new int[8];
        aBoolean666 = false;
        aBoolean668 = false;
        aBoolean669 = false;
        aBoolean673 = false;
        aBoolean674 = false;
        aBoolean675 = true;
        showInfo = true;
        anInt676 = 512;
        anInt677 = 334;
        anInt678 = 9;
        aBooleanArray679 = new boolean[50];
        aBoolean680 = false;
        aString681 = "";
        aString682 = "";
        anInt683 = 550;
        anIntArray686 = new int[99];
        anIntArray687 = new int[50];
        anIntArray688 = new int[50];
        anIntArray689 = new int[50];
        anIntArray692 = new int[14];
        anIntArray693 = new int[14];
        anInt707 = 30;
        anIntArray709 = new int[35];
        anIntArray710 = new int[35];
        anIntArray711 = new int[35];
        anIntArray712 = new int[18];
        aBooleanArray716 = new boolean[50];
        aBoolean717 = false;
        aBoolean718 = false;
        aBoolean719 = false;
        aBoolean720 = false;
        aBoolean721 = false;
        anIntArray722 = new int[50];
        anIntArray723 = new int[50];
        aBoolean727 = false;
        anIntArray728 = new int[18];
        anInt729 = 128;
        anIntArray730 = new int[50];
        aString734 = "";
        aString735 = "";
        anIntArray736 = new int[256];
        anIntArray737 = new int[256];
        anIntArray738 = new int[256];
        anIntArray740 = new int[500];
        anIntArray741 = new int[500];
        aBoolean745 = false;
        anIntArray747 = new int[500];
        anIntArray748 = new int[500];
        aBoolean757 = false;
        anIntArray758 = new int[50];
        anIntArray759 = new int[50];
        anIntArray760 = new int[1500];
        anIntArray761 = new int[1500];
        anIntArray762 = new int[1500];
        anIntArray763 = new int[1500];
        anInt764 = -1;
        aString765 = "";
        aBoolean767 = false;
        aClass2Array768 = new Class2[500];
        aStringArray769 = new String[250];
        anIntArray770 = new int[5000];
        anIntArray771 = new int[5000];
        anIntArray772 = new int[5000];
        anIntArray773 = new int[5000];
        aStringArray774 = new String[5];
        aClass5Array781 = new Class5[500];
        anInt785 = -1;
        anIntArray787 = new int[8];
        anIntArray788 = new int[8];
        aBoolean789 = false;
        aString794 = "";
        anIntArray797 = new int[5];
        aBoolean801 = false;
        aBoolean802 = false;
        anIntArray803 = new int[250];
        anIntArray804 = new int[250];
        anIntArray805 = new int[250];
        anInt809 = -1;
        aBoolean810 = false;
        anInt811 = -1;
        aClass5Array814 = new Class5[1500];
        anIntArray815 = new int[500];
        anIntArray816 = new int[256];
        anIntArray817 = new int[256];
        aStringArray821 = new String[50];
        aClass2Array822 = new Class2[500];
        aString824 = "";
        anIntArray825 = new int[18];
        aBooleanArray831 = new boolean[500];
        anInt834 = -1;
        anInt835 = -2;
        anIntArray837 = new int[14];
        anIntArray838 = new int[14];
        aString848 = "";
        aBoolean849 = false;
        aBoolean852 = false;
        aBoolean853 = false;
        aBoolean854 = false;
        aBoolean856 = false;
        aString861 = "";
        aString862 = "";
        aBoolean870 = false;
        anInt872 = 1;
        anInt873 = 2;
        anInt874 = 2;
        anInt875 = 8;
        anInt876 = 14;
        anInt878 = 1;
        aBoolean879 = false;
        aBoolean880 = true;
        anIntArray881 = new int[50];
        anIntArray882 = new int[250];
        anIntArray887 = new int[14];
        anIntArray888 = new int[14];
        aBoolean890 = false;
        aClass2Array891 = new Class2[4000];
        anInt896 = 2;
        anInt897 = 40;
        anInt903 = -1;
        anInt904 = -2;
        aBoolean908 = false;
        anIntArray911 = new int[8];
        anIntArray912 = new int[8];
        aStringArray913 = new String[5];
        aBoolean914 = false;
        anInt916 = 48;
        aBoolean917 = false;
        anInt919 = -1;
        anInt920 = -1;
        anInt921 = -1;
        aBoolean922 = false;
        aClass2Array923 = new Class2[500];
        anIntArray934 = new int[50];
        anIntArray935 = new int[5];
        anIntArray937 = new int[250];
        anIntArray938 = new int[250];
        anInt940 = 1;
        aBoolean944 = false;
        aBoolean945 = false;
        anInt946 = 128;
        anIntArray955 = new int[256];
        anIntArray956 = new int[256];
        aClass2Array957 = new Class2[5000];
        anIntArray960 = new int[8];
        anIntArray961 = new int[8];
        anIntArray962 = new int[8000];
        anIntArray963 = new int[8000];
        anIntArray965 = new int[50];
        anIntArray966 = new int[50];
        anIntArray967 = new int[50];
        anIntArray968 = new int[50];
        anIntArray970 = new int[14];
        anIntArray971 = new int[14];
        anIntArray972 = new int[50];
        anInt974 = 2;
        aClass2_975 = new Class2();
        anInt978 = -1;
        aBoolean979 = true;
        anIntArray981 = new int[8192];
        anIntArray982 = new int[8192];
        aClass2Array983 = new Class2[500];
        anIntArray984 = new int[250];
        aStringArray985 = new String[250];
        aBoolean992 = false;
        aClass5Array994 = new Class5[1000];
        anInt995 = 0xbc614e;
        System.out.println("Rune-V - Next Generation in Cheating");
    }

    public final Image createImage(int i, int j)
    {
        if(Applet_Sub1.aFrame_Sub1_7 != null)
            return Applet_Sub1.aFrame_Sub1_7.createImage(i, j);
        if(Class8.anApplet370 != null)
            return Class8.anApplet370.createImage(i, j);
        else
            return super.createImage(i, j);
    }

    public final URL getCodeBase()
    {
        return new URL("http://" + super.aString616 + "/client2/");
        Exception exception;
        exception;
        return null;
    }

    public final URL getDocumentBase()
    {
        return new URL("http://www.runescape.com");
        Exception exception;
        exception;
        return null;
    }

    public final Graphics getGraphics()
    {
        if(Applet_Sub1.aFrame_Sub1_7 != null)
            return Applet_Sub1.aFrame_Sub1_7.getGraphics();
        if(Class8.anApplet370 != null)
            return Class8.anApplet370.getGraphics();
        else
            return super.getGraphics();
    }

    public final String getParameter(String s)
    {
        if(Class8.anApplet370 != null)
            return Class8.anApplet370.getParameter(s);
        else
            return super.getParameter(s);
    }

    protected final void method1()
    {
        String s;
        if(aBoolean979)
            s = getDocumentBase().getHost().toLowerCase();
        int i = 0;
        for(int j = 0; j < 99; j++)
        {
            int l = j + 1;
            int j1 = (int)((double)l + 300D * Math.pow(2D, (double)l / 7D));
            i += j1;
            anIntArray686[j] = i & 0xffffffc;
        }

        try
        {
            String s1 = getParameter("referid");
            anInt731 = 0;
        }
        catch(Exception exception) { }
        try
        {
            String s2 = getParameter("member");
            boolean flag = false;
            if(flag)
                aBoolean914 = true;
        }
        catch(Exception exception1) { }
        if(aBoolean979)
            super.anInt617 = 43594;
        super.anInt11 = 0;
        Applet_Sub1_Sub1.anInt615 = 1000;
        Applet_Sub1_Sub1.anInt614 = Class18.anInt573;
        try
        {
            String s3 = getParameter("poff");
            int i1 = 0;
            super.anInt617 += i1;
            System.out.println("Offset: " + i1);
        }
        catch(Exception exception2) { }
        method73();
        if(aBoolean922)
            return;
        anInt948 = 2000;
        anInt949 = anInt948 + 100;
        anInt950 = anInt949 + 50;
        anInt954 = anInt950 + 1000;
        anInt951 = anInt954 + 10;
        anInt952 = anInt951 + 50;
        anInt953 = anInt952 + 10;
        aGraphics857 = getGraphics();
        method8(50);
        aClass6_Sub1_724 = new Class6_Sub1(anInt676, anInt677 + 12, 4000, this);
        aClass6_Sub1_724.aMudclient641 = this;
        aClass6_Sub1_724.method209(0, 0, anInt676, anInt677 + 12);
        Class4.aBoolean220 = false;
        Class4.anInt221 = anInt949;
        aClass4_798 = new Class4(aClass6_Sub1_724, 5);
        int k = ((Class6) (aClass6_Sub1_724)).anInt311 - 199;
        byte byte0 = 36;
        anInt799 = aClass4_798.method163(k, byte0 + 24, 196, 90, 1, 500, true);
        aClass4_925 = new Class4(aClass6_Sub1_724, 5);
        anInt926 = aClass4_925.method163(k, byte0 + 40, 196, 126, 1, 500, true);
        aClass4_826 = new Class4(aClass6_Sub1_724, 5);
        anInt827 = aClass4_826.method163(k, byte0 + 24, 196, 251, 1, 500, true);
        method121();
        if(aBoolean922)
            return;
        method86();
        if(aBoolean922)
            return;
        aClass10_739 = new Class10(aClass6_Sub1_724, 15000, 15000, 1000);
        aClass10_739.method281(anInt676 / 2, anInt677 / 2, anInt676 / 2, anInt677 / 2, anInt676, anInt678);
        aClass10_739.anInt390 = 0x1869f;
        aClass10_739.anInt391 = 0x1869f;
        aClass10_739.anInt392 = 1;
        aClass10_739.anInt393 = 0x1869f;
        aClass10_739.method309(-50, -10, -50);
        aClass19_883 = new Class19(aClass10_739, aClass6_Sub1_724);
        aClass19_883.anInt589 = anInt948;
        method113();
        if(aBoolean922)
            return;
        method64();
        if(aBoolean922)
            return;
        method95();
        if(aBoolean922)
            return;
        if(aBoolean914)
            method102();
        if(aBoolean922)
        {
            return;
        } else
        {
            method15(100, "");
            method94();
            method52();
            method59();
            method50();
            method5();
            method77();
            return;
        }
    }

    public boolean incomb()
    {
        return aClass2_975.anInt153 == 8 || aClass2_975.anInt153 == 9;
    }

    public int getnpcindex(int i)
    {
        for(int j = 0; j < anInt905; j++)
            if(aClass2Array768[j].anInt151 == i && aClass2Array768[j].anInt153 != 8 && aClass2Array768[j].anInt153 != 9)
                return j;

        return -1;
    }

    public void attacknpc(int i)
    {
        anIntArray882[0] = 715;
        anIntArray937[0] = aClass2Array768[i].anInt149;
        anIntArray938[0] = aClass2Array768[i].anInt150;
        anIntArray803[0] = aClass2Array768[i].anInt147;
        method93(0);
    }

    public void useitem(int i)
    {
        for(int j = 0; j < anIntArray709.length; j++)
            if(anIntArray709[j] == i)
            {
                super.aClass14_Sub1_620.method331(219);
                super.aClass14_Sub1_620.method343(j);
                super.aClass14_Sub1_620.method346();
                return;
            }

    }

    public void prayeron(int i)
    {
        super.aClass14_Sub1_620.method331(17);
        super.aClass14_Sub1_620.method348(i);
        super.aClass14_Sub1_620.method346();
        aBooleanArray679[i] = true;
        method97("prayeron");
    }

    public void prayeroff(int i)
    {
        super.aClass14_Sub1_620.method331(164);
        super.aClass14_Sub1_620.method348(i);
        super.aClass14_Sub1_620.method346();
        aBooleanArray679[i] = false;
        method97("prayeroff");
    }

    public void sendMessage(String s)
    {
        int i = Class17.method400(s);
        method34(Class17.aByteArray569, i);
        s = Class17.method399(Class17.aByteArray569, 0, i);
        s = Class16.method374(s);
        aClass2_975.anInt161 = 150;
        aClass2_975.aString160 = s;
        method118(aClass2_975.aString146 + ": " + s, 2);
    }

    protected final void method10(int i)
    {
        if(i == 1004 && anInt683 > 400)
            anInt683 -= 30;
        if(i == 1005 && anInt683 < 2000)
            anInt683 += 30;
        if(i == 1019)
            useitem(foodID);
        if(i == 1018)
        {
            prayeron(prayerid);
            prayeron(prayerdot);
            method118("@blu@Rune-V: @gre@Prayer Combo @gre@ On", 3);
        }
        if(i == 1017)
        {
            prayeroff(prayerid);
            prayeroff(prayerdot);
            method118("@blu@Rune-V: @red@Prayer Combo Off", 3);
        }
        if(i == 1015)
        {
            autofighter = !autofighter;
            if(autofighter)
            {
                npcid = npcnum;
                smacro = new script();
                method42("@blu@Rune-V: @gre@Autofighter started");
                method42("@whi@NPC ID set to: @cya@" + npcnum);
                method42("@whi@Delay set to: @cya@" + MacroTime);
            } else
            {
                method42("@blu@Rune-V: @red@Autofighter stopped");
            }
        }
        if(i == 1003)
            if(MacroTime != 50)
            {
                MacroTime -= 50;
                method118("@blu@Rune-V: @cya@AutoFighter Delay: @gre@" + MacroTime, 3);
            } else
            {
                method118("@blu@Rune-V: @red@Delay Can't Go Under 5" + MacroTime, 3);
            }
        if(i == 1002)
            if(MacroTime != 5000)
            {
                MacroTime += 50;
                method118("@blu@Rune-V: @cya@AutoFighter Delay: @gre@" + MacroTime, 3);
            } else
            {
                method118("@blu@Rune-V: @red@Delay no more than 5000" + MacroTime, 3);
            }
        if(i == 1014)
        {
            autologin = !autologin;
            if(autologin)
                method118("@blu@Rune-V: @gre@Autologin enabled for @gre@ @red@" + aString734 + " @gre@", 3);
            else
                method118("@blu@Rune-V: @red@Autologin disabled", 3);
        }
        if(i == 1016)
        {
            styleCnt++;
            if(styleCnt > 3)
                styleCnt = 1;
            anInt750 = styleCnt;
            super.aClass14_Sub1_620.method331(119);
            super.aClass14_Sub1_620.method348(anInt750);
            super.aClass14_Sub1_620.method346();
            if(anInt750 == 0)
                method118("@blu@Rune-V: @cya@Setting fight mode to @GRE@Controlled.", 3);
            if(anInt750 == 1)
                method118("@blu@Rune-V: @cya@Setting fight mode to @GRE@Aggressive.", 3);
            if(anInt750 == 2)
                method118("@blu@Rune-V: @cya@Setting fight mode to @GRE@Accurate.", 3);
            if(anInt750 == 3)
                method118("@blu@Rune-V: @cya@Setting fight mode to @GRE@Defensive.", 3);
        }
        if(i == 1013)
            if(!chatSpammer)
            {
                method118("@blu@Rune-V: @gre@ /spam Message to spam to activate", 3);
            } else
            {
                method118("@blu@Rune-V: @red@Stopping..", 3);
                chatSpammer = false;
            }
        if(anInt947 == 0)
        {
            if(anInt690 == 0)
                aClass4_858.method141(i);
            if(anInt690 == 1)
                aClass4_667.method141(i);
            if(anInt690 == 2)
                aClass4_751.method141(i);
        }
        if(anInt947 == 1)
        {
            if(aBoolean992)
            {
                aClass4_830.method141(i);
                return;
            }
            if(anInt931 == 0 && anInt986 == 0 && !aBoolean870)
                aClass4_775.method141(i);
        }
    }

    private final void SwitchTo(int i)
    {
        if(i == 51)
        {
            sName = "51";
            super.aString616 = "uk1.runescape.com";
            super.anInt617 = 43594;
        } else
        if(i == 53)
        {
            sName = "53";
            super.aString616 = "ul3.runescape.com";
            super.anInt617 = 43594;
        } else
        if(i == 55)
        {
            sName = "55";
            super.aString616 = "cet3b.runescape.com";
            super.anInt617 = 43594;
        }
    }

    private final void LogOut()
    {
        method22();
    }

    private final void LogIn()
    {
        method21(aString734, aString735, false);
    }

    private final void method100()
    {
        int i = Class1.anInt144;
        byte byte0 = 22;
        byte byte1 = 36;
        aClass6_Sub1_724.method216(byte0, byte1, 468, 16, 192);
        int j = 0x989898;
        aClass6_Sub1_724.method214(byte0, byte1 + 16, 468, 246, j, 160);
        aClass6_Sub1_724.method255("Please confirm your duel with @yel@" + Class15.method363(aLong907), byte0 + 234, byte1 + 12, 1, 0xffffff);
        aClass6_Sub1_724.method255("Your stake:", byte0 + 117, byte1 + 30, 1, 0xffff00);
        for(int k = 0; k < anInt663; k++)
        {
            String s = Class1.aStringArray109[anIntArray664[k]];
            if(Class1.anIntArray55[anIntArray664[k]] == 0)
                s = s + " x " + method48(anIntArray665[k]);
            aClass6_Sub1_724.method255(s, byte0 + 117, byte1 + 42 + k * 12, 1, 0xffffff);
        }

        if(anInt663 == 0)
            aClass6_Sub1_724.method255("Nothing!", byte0 + 117, byte1 + 42, 1, 0xffffff);
        aClass6_Sub1_724.method255("Your opponent's stake:", byte0 + 351, byte1 + 30, 1, 0xffff00);
        for(int l = 0; l < anInt786; l++)
        {
            String s1 = Class1.aStringArray109[anIntArray787[l]];
            if(Class1.anIntArray55[anIntArray787[l]] == 0)
                s1 = s1 + " x " + method48(anIntArray788[l]);
            aClass6_Sub1_724.method255(s1, byte0 + 351, byte1 + 42 + l * 12, 1, 0xffffff);
        }

        if(anInt786 == 0)
            aClass6_Sub1_724.method255("Nothing!", byte0 + 351, byte1 + 42, 1, 0xffffff);
        if(anInt988 == 0)
            aClass6_Sub1_724.method255("You can retreat from this duel", byte0 + 234, byte1 + 180, 1, 65280);
        else
            aClass6_Sub1_724.method255("No retreat is possible!", byte0 + 234, byte1 + 180, 1, 0xff0000);
        if(anInt989 == 0)
            aClass6_Sub1_724.method255("Magic may be used", byte0 + 234, byte1 + 192, 1, 65280);
        else
            aClass6_Sub1_724.method255("Magic cannot be used", byte0 + 234, byte1 + 192, 1, 0xff0000);
        if(anInt990 == 0)
            aClass6_Sub1_724.method255("Prayer may be used", byte0 + 234, byte1 + 204, 1, 65280);
        else
            aClass6_Sub1_724.method255("Prayer cannot be used", byte0 + 234, byte1 + 204, 1, 0xff0000);
        if(anInt991 == 0)
            aClass6_Sub1_724.method255("Weapons may be used", byte0 + 234, byte1 + 216, 1, 65280);
        else
            aClass6_Sub1_724.method255("Weapons cannot be used", byte0 + 234, byte1 + 216, 1, 0xff0000);
        aClass6_Sub1_724.method255("If you are sure click 'Accept' to begin the duel", byte0 + 234, byte1 + 230, 1, 0xffffff);
        if(!aBoolean802)
        {
            aClass6_Sub1_724.method231((byte0 + 118) - 35, byte1 + 238, anInt948 + 25);
            aClass6_Sub1_724.method231((byte0 + 352) - 35, byte1 + 238, anInt948 + 26);
        } else
        {
            aClass6_Sub1_724.method255("Waiting for other player...", byte0 + 234, byte1 + 250, 1, 0xffff00);
        }
        if(anInt813 == 1)
        {
            if(super.anInt33 < byte0 || super.anInt34 < byte1 || super.anInt33 > byte0 + 468 || super.anInt34 > byte1 + 262)
            {
                aBoolean801 = false;
                super.aClass14_Sub1_620.method331(178);
                super.aClass14_Sub1_620.method346();
            }
            if(super.anInt33 >= (byte0 + 118) - 35 && super.anInt33 <= byte0 + 118 + 70 && super.anInt34 >= byte1 + 238 && super.anInt34 <= byte1 + 238 + 21)
            {
                aBoolean802 = true;
                super.aClass14_Sub1_620.method331(24);
                super.aClass14_Sub1_620.method346();
            }
            if(super.anInt33 >= (byte0 + 352) - 35 && super.anInt33 <= byte0 + 353 + 70 && super.anInt34 >= byte1 + 238 && super.anInt34 <= byte1 + 238 + 21)
            {
                aBoolean801 = false;
                super.aClass14_Sub1_620.method331(82);
                super.aClass14_Sub1_620.method346();
            }
            anInt813 = 0;
        }
    }

    private final void method101()
    {
        int i = Class1.anInt144;
        for(int j = 0; j < anInt820; j++)
        {
            int i1 = aClass6_Sub1_724.method261(1);
            int l1 = anIntArray965[j];
            int k2 = anIntArray966[j];
            int j3 = anIntArray967[j];
            int l3 = anIntArray968[j];
            for(boolean flag = true; flag;)
            {
                flag = false;
                int k4 = 0;
                while(k4 < j) 
                {
                    if(k2 + l3 > anIntArray966[k4] - i1 && k2 - i1 < anIntArray966[k4] + anIntArray968[k4] && l1 - j3 < anIntArray965[k4] + anIntArray967[k4] && l1 + j3 > anIntArray965[k4] - anIntArray967[k4] && anIntArray966[k4] - i1 - l3 < k2)
                    {
                        k2 = anIntArray966[k4] - i1 - l3;
                        flag = true;
                    }
                    k4++;
                }
            }

            anIntArray966[j] = k2;
            aClass6_Sub1_724.method256(aStringArray821[j], l1, k2, 1, 0xffff00, 300);
        }

        for(int k = 0; k < anInt958; k++)
        {
            int j1 = anIntArray758[k];
            int i2 = anIntArray759[k];
            int l2 = anIntArray722[k];
            int k3 = anIntArray723[k];
            int i4 = (39 * l2) / 100;
            int j4 = (27 * l2) / 100;
            int l4 = i2 - j4;
            aClass6_Sub1_724.method234(j1 - i4 / 2, l4, i4, j4, anInt948 + 9, 85);
            int i5 = (36 * l2) / 100;
            int j5 = (24 * l2) / 100;
            aClass6_Sub1_724.method247(j1 - i5 / 2, (l4 + j4 / 2) - j5 / 2, i5, j5, Class1.anIntArray53[k3] + anInt950, Class1.anIntArray58[k3], 0, 0, false);
        }

        for(int l = 0; l < anInt766; l++)
        {
            int k1 = anIntArray687[l];
            int j2 = anIntArray688[l];
            int i3 = anIntArray689[l];
            aClass6_Sub1_724.method214(k1 - 15, j2 - 3, i3, 5, 65280, 192);
            aClass6_Sub1_724.method214((k1 - 15) + i3, j2 - 3, 30 - i3, 5, 0xff0000, 192);
        }

    }

    private final void method102()
    {
        try
        {
            aByteArray987 = method18("sounds" + Class18.anInt580 + ".mem", "", 90);
            anInputStream_Sub1_901 = new InputStream_Sub1();
            return;
        }
        catch(Throwable throwable)
        {
            System.out.println("Unable to init sounds:" + throwable);
        }
    }

    private final void method103(boolean flag)
    {
        int i = Class1.anInt144;
        int j = ((Class6) (aClass6_Sub1_724)).anInt311 - 199;
        char c = '\234';
        char c1 = '\230';
        aClass6_Sub1_724.method231(j - 49, 3, anInt948 + 2);
        j += 40;
        aClass6_Sub1_724.method216(j, 36, c, c1, 0);
        aClass6_Sub1_724.method209(j, 36, j + c, 36 + c1);
        int k = 192 + anInt860;
        int l = anInt729 + anInt859 & 0xff;
        int i1 = ((aClass2_975.anInt149 - 6040) * 3 * k) / 2048;
        int j1 = ((aClass2_975.anInt150 - 6040) * 3 * k) / 2048;
        int k1 = Class10.anIntArray394[1024 - l * 4 & 0x3ff];
        int l1 = Class10.anIntArray394[(1024 - l * 4 & 0x3ff) + 1024];
        int i2 = j1 * k1 + i1 * l1 >> 18;
        j1 = j1 * l1 - i1 * k1 >> 18;
        i1 = i2;
        aClass6_Sub1_724.method243((j + c / 2) - i1, 36 + c1 / 2 + j1, anInt948 - 1, l + 64 & 0xff, k);
        for(int j2 = 0; j2 < anInt796; j2++)
        {
            int k3 = (((anIntArray760[j2] * anInt946 + 64) - aClass2_975.anInt149) * 3 * k) / 2048;
            int i4 = (((anIntArray761[j2] * anInt946 + 64) - aClass2_975.anInt150) * 3 * k) / 2048;
            int i5 = i4 * k1 + k3 * l1 >> 18;
            i4 = i4 * l1 - k3 * k1 >> 18;
            k3 = i5;
            method74(j + c / 2 + k3, (36 + c1 / 2) - i4, 65535);
        }

        for(int k2 = 0; k2 < anInt823; k2++)
        {
            int l3 = (((anIntArray770[k2] * anInt946 + 64) - aClass2_975.anInt149) * 3 * k) / 2048;
            int j4 = (((anIntArray771[k2] * anInt946 + 64) - aClass2_975.anInt150) * 3 * k) / 2048;
            int j5 = j4 * k1 + l3 * l1 >> 18;
            j4 = j4 * l1 - l3 * k1 >> 18;
            l3 = j5;
            method74(j + c / 2 + l3, (36 + c1 / 2) - j4, 0xff0000);
        }

        for(int l2 = 0; l2 < anInt905; l2++)
        {
            Class2 class2 = aClass2Array768[l2];
            int k4 = ((class2.anInt149 - aClass2_975.anInt149) * 3 * k) / 2048;
            int k5 = ((class2.anInt150 - aClass2_975.anInt150) * 3 * k) / 2048;
            int j6 = k5 * k1 + k4 * l1 >> 18;
            k5 = k5 * l1 - k4 * k1 >> 18;
            k4 = j6;
            method74(j + c / 2 + k4, (36 + c1 / 2) - k5, 0xffff00);
        }

        for(int i3 = 0; i3 < anInt742; i3++)
        {
            Class2 class2_1 = aClass2Array983[i3];
            int l4 = ((class2_1.anInt149 - aClass2_975.anInt149) * 3 * k) / 2048;
            int l5 = ((class2_1.anInt150 - aClass2_975.anInt150) * 3 * k) / 2048;
            int k6 = l5 * k1 + l4 * l1 >> 18;
            l5 = l5 * l1 - l4 * k1 >> 18;
            l4 = k6;
            int i7 = 0xffffff;
            int k7 = 0;
            do
            {
                if(k7 >= super.anInt624)
                    break;
                if(class2_1.aLong145 == super.aLongArray625[k7] && super.anIntArray626[k7] == 99)
                {
                    i7 = 65280;
                    break;
                }
                k7++;
            } while(true);
            method74(j + c / 2 + l4, (36 + c1 / 2) - l5, i7);
        }

        aClass6_Sub1_724.method213(j + c / 2, 36 + c1 / 2, 2, 0x5301f, 50);
        aClass6_Sub1_724.method243(j + 19, 55, anInt948 + 24, anInt729 + 128 & 0xff, 128);
        aClass6_Sub1_724.method209(0, 0, anInt676, anInt677 + 12);
        if(!flag)
            return;
        j = super.anInt33 - (((Class6) (aClass6_Sub1_724)).anInt311 - 199);
        int j3 = super.anInt34 - 36;
        if(j >= 40 && j3 >= 0 && j < 196 && j3 < 152)
        {
            char c2 = '\234';
            char c3 = '\230';
            int i6 = 192 + anInt860;
            int l6 = anInt729 + anInt859 & 0xff;
            int j7 = ((Class6) (aClass6_Sub1_724)).anInt311 - 199;
            j7 += 40;
            int l7 = ((super.anInt33 - (j7 + c2 / 2)) * 16384) / (3 * i6);
            int i8 = ((super.anInt34 - (36 + c3 / 2)) * 16384) / (3 * i6);
            int j8 = Class10.anIntArray394[1024 - l6 * 4 & 0x3ff];
            int k8 = Class10.anIntArray394[(1024 - l6 * 4 & 0x3ff) + 1024];
            int l8 = i8 * j8 + l7 * k8 >> 15;
            i8 = i8 * k8 - l7 * j8 >> 15;
            l7 = l8;
            l7 += aClass2_975.anInt149;
            i8 = aClass2_975.anInt150 - i8;
            if(anInt813 == 1)
                method99(anInt976, anInt977, l7 / 128, i8 / 128, false);
            anInt813 = 0;
        }
    }

    private final boolean method104(int i, int j)
    {
        if(i == 31 && (method79(197) || method79(615) || method79(682)))
            return true;
        if(i == 32 && (method79(102) || method79(616) || method79(683)))
            return true;
        if(i == 33 && (method79(101) || method79(617) || method79(684)))
            return true;
        if(i == 34 && (method79(103) || method79(618) || method79(685)))
            return true;
        else
            return method58(i) >= j;
    }

    private final void method105(int i, int j, int k, int l)
    {
        int i1;
        int j1;
        if(k == 0 || k == 4)
        {
            i1 = Class1.anIntArray63[l];
            j1 = Class1.anIntArray64[l];
        } else
        {
            j1 = Class1.anIntArray63[l];
            i1 = Class1.anIntArray64[l];
        }
        if(Class1.anIntArray65[l] == 2 || Class1.anIntArray65[l] == 3)
        {
            if(k == 0)
            {
                i--;
                i1++;
            }
            if(k == 2)
                j1++;
            if(k == 4)
                i1++;
            if(k == 6)
            {
                j--;
                j1++;
            }
            method83(anInt976, anInt977, i, j, (i + i1) - 1, (j + j1) - 1, false, true);
            return;
        } else
        {
            method83(anInt976, anInt977, i, j, (i + i1) - 1, (j + j1) - 1, true, true);
            return;
        }
    }

    private final Class5 method106(int i, int j, int k, int l, int i1)
    {
        int j1 = i;
        int k1 = j;
        int l1 = i;
        int i2 = j;
        int j2 = Class1.anIntArray79[l];
        int k2 = Class1.anIntArray80[l];
        int l2 = Class1.anIntArray78[l];
        Class5 class5 = new Class5(4, 1);
        if(k == 0)
            l1 = i + 1;
        if(k == 1)
            i2 = j + 1;
        if(k == 2)
        {
            j1 = i + 1;
            i2 = j + 1;
        }
        if(k == 3)
        {
            l1 = i + 1;
            i2 = j + 1;
        }
        j1 *= anInt946;
        k1 *= anInt946;
        l1 *= anInt946;
        i2 *= anInt946;
        int i3 = class5.method180(j1, -aClass19_883.method421(j1, k1), k1);
        int j3 = class5.method180(j1, -aClass19_883.method421(j1, k1) - l2, k1);
        int k3 = class5.method180(l1, -aClass19_883.method421(l1, i2) - l2, i2);
        int l3 = class5.method180(l1, -aClass19_883.method421(l1, i2), i2);
        int ai[] = {
            i3, j3, k3, l3
        };
        class5.method182(4, ai, j2, k2);
        class5.method185(false, 60, 24, -50, -10, -50);
        if(i >= 0 && j >= 0 && i < 96 && j < 96)
            aClass10_739.method269(class5);
        class5.anInt257 = i1 + 10000;
        return class5;
    }

    private final Class2 method107(int i, int j, int k, int l, int i1)
    {
        int j1 = Class1.anInt144;
        if(aClass2Array957[i] == null)
        {
            aClass2Array957[i] = new Class2();
            aClass2Array957[i].anInt147 = i;
        }
        Class2 class2 = aClass2Array957[i];
        boolean flag = false;
        int k1 = 0;
        do
        {
            if(k1 >= anInt906)
                break;
            if(aClass2Array822[k1].anInt147 == i)
            {
                flag = true;
                break;
            }
            k1++;
        } while(true);
        if(flag)
        {
            class2.anInt151 = i1;
            class2.anInt154 = l;
            int l1 = class2.anInt156;
            if(j != class2.anIntArray157[l1] || k != class2.anIntArray158[l1])
            {
                class2.anInt156 = l1 = (l1 + 1) % 10;
                class2.anIntArray157[l1] = j;
                class2.anIntArray158[l1] = k;
            }
        } else
        {
            class2.anInt147 = i;
            class2.anInt155 = 0;
            class2.anInt156 = 0;
            class2.anIntArray157[0] = class2.anInt149 = j;
            class2.anIntArray158[0] = class2.anInt150 = k;
            class2.anInt151 = i1;
            class2.anInt154 = class2.anInt153 = l;
            class2.anInt152 = 0;
        }
        aClass2Array768[anInt905++] = class2;
        return class2;
    }

    private final void method108()
    {
        int i = Class1.anInt144;
        if(anInt993 != 0)
        {
            aClass6_Sub1_724.method221();
            aClass6_Sub1_724.method255("Sending You Back To Lumby", anInt676 / 2, anInt677 / 2, 7, 0xff0000);
            method69();
            aClass6_Sub1_724.method211(aGraphics857, 0, 0);
            return;
        }
        if(aBoolean992)
        {
            method61();
            return;
        }
        if(aBoolean870)
        {
            aClass6_Sub1_724.method221();
            if(Math.random() < 0.14999999999999999D)
                aClass6_Sub1_724.method255("ZZZ", (int)(Math.random() * 80D), (int)(Math.random() * 334D), 5, (int)(Math.random() * 16777215D));
            if(Math.random() < 0.14999999999999999D)
                aClass6_Sub1_724.method255("ZZZ", 512 - (int)(Math.random() * 80D), (int)(Math.random() * 334D), 5, (int)(Math.random() * 16777215D));
            aClass6_Sub1_724.method216(anInt676 / 2 - 100, 160, 200, 40, 0);
            aClass6_Sub1_724.method255("You are sleeping", anInt676 / 2, 50, 7, 0xffff00);
            aClass6_Sub1_724.method255("Fatigue: " + (anInt893 * 100) / 750 + "%", anInt676 / 2, 90, 7, 0xffff00);
            aClass6_Sub1_724.method255("When you want to wake up just use your", anInt676 / 2, 140, 5, 0xffffff);
            aClass6_Sub1_724.method255("keyboard to type the word in the box below", anInt676 / 2, 160, 5, 0xffffff);
            aClass6_Sub1_724.method255(super.aString40 + "*", anInt676 / 2, 180, 5, 65535);
            if(aString846 == null)
                aClass6_Sub1_724.method231(anInt676 / 2 - 127, 230, anInt952 + 1);
            else
                aClass6_Sub1_724.method255(aString846, anInt676 / 2, 260, 5, 0xff0000);
            aClass6_Sub1_724.method217(anInt676 / 2 - 128, 229, 257, 42, 0xffffff);
            method69();
            aClass6_Sub1_724.method255("If you can't read the word", anInt676 / 2, 290, 1, 0xffffff);
            aClass6_Sub1_724.method255("@yel@click here@whi@ to get a different one", anInt676 / 2, 305, 1, 0xffffff);
            aClass6_Sub1_724.method211(aGraphics857, 0, 0);
            return;
        }
        if(!aClass19_883.aBoolean609)
            return;
        for(int j = 0; j < 64; j++)
        {
            aClass10_739.method270(aClass19_883.aClass5ArrayArray603[anInt809][j]);
            if(anInt809 == 0)
            {
                aClass10_739.method270(aClass19_883.aClass5ArrayArray605[1][j]);
                aClass10_739.method270(aClass19_883.aClass5ArrayArray603[1][j]);
                aClass10_739.method270(aClass19_883.aClass5ArrayArray605[2][j]);
                aClass10_739.method270(aClass19_883.aClass5ArrayArray603[2][j]);
            }
            aBoolean789 = true;
            if(anInt809 != 0 || (aClass19_883.anIntArrayArray608[aClass2_975.anInt149 / 128][aClass2_975.anInt150 / 128] & 0x80) != 0)
                continue;
            aClass10_739.method269(aClass19_883.aClass5ArrayArray603[anInt809][j]);
            if(anInt809 == 0)
            {
                aClass10_739.method269(aClass19_883.aClass5ArrayArray605[1][j]);
                aClass10_739.method269(aClass19_883.aClass5ArrayArray603[1][j]);
                aClass10_739.method269(aClass19_883.aClass5ArrayArray605[2][j]);
                aClass10_739.method269(aClass19_883.aClass5ArrayArray603[2][j]);
            }
            aBoolean789 = false;
        }

        if(anInt839 != anInt919)
        {
            anInt919 = anInt839;
            for(int k = 0; k < anInt796; k++)
            {
                if(anIntArray762[k] == 97)
                    method89(k, "firea" + (anInt839 + 1));
                if(anIntArray762[k] == 274)
                    method89(k, "fireplacea" + (anInt839 + 1));
                if(anIntArray762[k] == 1031)
                    method89(k, "lightning" + (anInt839 + 1));
                if(anIntArray762[k] == 1036)
                    method89(k, "firespell" + (anInt839 + 1));
                if(anIntArray762[k] == 1147)
                    method89(k, "spellcharge" + (anInt839 + 1));
            }

        }
        if(anInt840 != anInt920)
        {
            anInt920 = anInt840;
            for(int l = 0; l < anInt796; l++)
            {
                if(anIntArray762[l] == 51)
                    method89(l, "torcha" + (anInt840 + 1));
                if(anIntArray762[l] == 143)
                    method89(l, "skulltorcha" + (anInt840 + 1));
            }

        }
        if(anInt841 != anInt921)
        {
            anInt921 = anInt841;
            for(int i1 = 0; i1 < anInt796; i1++)
                if(anIntArray762[i1] == 1142)
                    method89(i1, "clawspell" + (anInt841 + 1));

        }
        aClass10_739.method273(anInt744);
        anInt744 = 0;
        for(int j1 = 0; j1 < anInt742; j1++)
        {
            Class2 class2 = aClass2Array983[j1];
            if(class2.anInt171 == 255)
                continue;
            int i6 = class2.anInt149;
            int i7 = class2.anInt150;
            int i8 = -aClass19_883.method421(i6, i7);
            int l8 = aClass10_739.method274(5000 + j1, i6, i8, i7, 145, 220, j1 + 10000);
            anInt744++;
            if(class2 == aClass2_975)
                aClass10_739.method275(l8);
            if(class2.anInt153 == 8)
                aClass10_739.method276(l8, -30);
            if(class2.anInt153 == 9)
                aClass10_739.method276(l8, 30);
        }

        for(int k1 = 0; k1 < anInt742; k1++)
        {
            Class2 class2_1 = aClass2Array983[k1];
            if(class2_1.anInt176 <= 0)
                continue;
            Class2 class2_3 = null;
            if(class2_1.anInt175 != -1)
                class2_3 = aClass2Array957[class2_1.anInt175];
            else
            if(class2_1.anInt174 != -1)
                class2_3 = aClass2Array891[class2_1.anInt174];
            if(class2_3 != null)
            {
                int j7 = class2_1.anInt149;
                int j8 = class2_1.anInt150;
                int i9 = -aClass19_883.method421(j7, j8) - 110;
                int k9 = class2_3.anInt149;
                int l9 = class2_3.anInt150;
                int i10 = -aClass19_883.method421(k9, l9) - Class1.anIntArray103[class2_3.anInt151] / 2;
                int j10 = (j7 * class2_1.anInt176 + k9 * (anInt897 - class2_1.anInt176)) / anInt897;
                int k10 = (i9 * class2_1.anInt176 + i10 * (anInt897 - class2_1.anInt176)) / anInt897;
                int l10 = (j8 * class2_1.anInt176 + l9 * (anInt897 - class2_1.anInt176)) / anInt897;
                aClass10_739.method274(anInt951 + class2_1.anInt173, j10, k10, l10, 32, 32, 0);
                anInt744++;
            }
        }

        for(int l1 = 0; l1 < anInt905; l1++)
        {
            Class2 class2_2 = aClass2Array768[l1];
            int j6 = class2_2.anInt149;
            int k7 = class2_2.anInt150;
            int k8 = -aClass19_883.method421(j6, k7);
            int j9 = aClass10_739.method274(20000 + l1, j6, k8, k7, Class1.anIntArray102[class2_2.anInt151], Class1.anIntArray103[class2_2.anInt151], l1 + 30000);
            anInt744++;
            if(class2_2.anInt153 == 8)
                aClass10_739.method276(j9, -30);
            if(class2_2.anInt153 == 9)
                aClass10_739.method276(j9, 30);
        }

        for(int i2 = 0; i2 < anInt823; i2++)
        {
            int j4 = anIntArray770[i2] * anInt946 + 64;
            int k6 = anIntArray771[i2] * anInt946 + 64;
            aClass10_739.method274(40000 + anIntArray772[i2], j4, -aClass19_883.method421(j4, k6) - anIntArray773[i2], k6, 96, 64, i2 + 20000);
            anInt744++;
        }

        for(int j2 = 0; j2 < anInt833; j2++)
        {
            int k4 = anIntArray881[j2] * anInt946 + 64;
            int l6 = anIntArray934[j2] * anInt946 + 64;
            int l7 = anIntArray730[j2];
            if(l7 == 0)
            {
                aClass10_739.method274(50000 + j2, k4, -aClass19_883.method421(k4, l6), l6, 128, 256, j2 + 50000);
                anInt744++;
            }
            if(l7 == 1)
            {
                aClass10_739.method274(50000 + j2, k4, -aClass19_883.method421(k4, l6), l6, 128, 64, j2 + 50000);
                anInt744++;
            }
        }

        aClass6_Sub1_724.aBoolean335 = false;
        aClass6_Sub1_724.method212();
        aClass6_Sub1_724.aBoolean335 = super.aBoolean39;
        if(anInt809 == 3)
        {
            int k2 = 40 + (int)(Math.random() * 3D);
            int l4 = 40 + (int)(Math.random() * 7D);
            aClass10_739.method310(k2, l4, -50, -10, -50);
        }
        anInt958 = 0;
        anInt820 = 0;
        anInt766 = 0;
        if(aBoolean757)
        {
            if(aBoolean675 && !aBoolean789)
            {
                int l2 = anInt940;
                method78();
                if(anInt940 != l2)
                {
                    anInt714 = aClass2_975.anInt149;
                    anInt715 = aClass2_975.anInt150;
                }
            }
            aClass10_739.anInt390 = 3000;
            aClass10_739.anInt391 = 3000;
            aClass10_739.anInt392 = 1;
            aClass10_739.anInt393 = 2800;
            anInt729 = anInt940 * 32;
            int i3 = anInt714 + anInt895;
            int i5 = anInt715 + anInt973;
            aClass10_739.method298(i3, -aClass19_883.method421(i3, i5), i5, 912, anInt729 * 4, 0, 2000);
        } else
        {
            if(aBoolean675 && !aBoolean789)
                method78();
            if(!super.aBoolean39)
            {
                aClass10_739.anInt390 = 0x1869f;
                aClass10_739.anInt391 = 0x1869f;
                aClass10_739.anInt392 = 1;
                aClass10_739.anInt393 = 0x1869f;
            } else
            {
                aClass10_739.anInt390 = 0x1869f;
                aClass10_739.anInt391 = 0x1869f;
                aClass10_739.anInt392 = 1;
                aClass10_739.anInt393 = 0x1869f;
            }
            int j3 = anInt714 + anInt895;
            int j5 = anInt715 + anInt973;
            aClass10_739.method298(j3, -aClass19_883.method421(j3, j5), j5, 912, anInt729 * 4, 0, anInt683 * 2);
        }
        aClass10_739.method286();
        method101();
        if(anInt670 > 0)
            aClass6_Sub1_724.method231(anInt671 - 8, anInt672 - 8, anInt948 + 14 + (24 - anInt670) / 6);
        if(anInt670 < 0)
            aClass6_Sub1_724.method231(anInt671 - 8, anInt672 - 8, anInt948 + 18 + (24 + anInt670) / 6);
        if(anInt749 != 0)
        {
            int k3 = anInt749 / 50;
            int k5 = k3 / 60;
            k3 %= 60;
            if(k3 < 10)
                aClass6_Sub1_724.method255("System update in: " + k5 + ":0" + k3, 256, anInt677 - 7, 1, 0xffff00);
            else
                aClass6_Sub1_724.method255("System update in: " + k5 + ":" + k3, 256, anInt677 - 7, 1, 0xffff00);
        }
        if(showInfo)
        {
            aClass6_Sub1_724.method257("@ora@Rune-V", 20, 90, 1, 0);
            aClass6_Sub1_724.method257("@whi@Att: @whi@" + anIntArray728[0] + "@whi@/@whi@" + anIntArray825[3], 20, 100, 1, 0);
            aClass6_Sub1_724.method257("@gre@Def: @whi@" + anIntArray728[1] + "@whi@/@whi@" + anIntArray825[3], 20, 110, 1, 0);
            aClass6_Sub1_724.method257("@red@Str: @whi@" + anIntArray728[2] + "@whi@/@whi@" + anIntArray825[2], 20, 120, 1, 0);
            aClass6_Sub1_724.method257("@cya@Hp: @whi@" + anIntArray728[3] + "@whi@/@whi@" + anIntArray825[3], 20, 130, 1, 0);
            aClass6_Sub1_724.method257("@dre@Pray: @whi@" + anIntArray728[5] + "@whi@/@whi@" + anIntArray825[5], 20, 140, 1, 0);
        }
        if(!aBoolean717)
        {
            int l3 = 2203 - (anInt977 + anInt807 + anInt784);
            if(anInt976 + anInt806 + anInt783 >= 2640)
                l3 = -50;
            if(l3 > 0)
            {
                int l5 = 1 + l3 / 6;
                aClass6_Sub1_724.method231(453, anInt677 - 56, anInt948 + 13);
                aClass6_Sub1_724.method255("@gre@Wilderness", 465, anInt677 - 20, 1, 0xffff00);
                aClass6_Sub1_724.method255("Level: " + l5, 465, anInt677 - 7, 1, 0xffff00);
                if(anInt725 == 0)
                    anInt725 = 2;
            }
            if(anInt725 == 0 && l3 > -10 && l3 <= 0)
                anInt725 = 1;
        }
        if(anInt780 == 0)
        {
            for(int i4 = 0; i4 < 5; i4++)
                if(anIntArray935[i4] > 0)
                {
                    String s = aStringArray774[i4];
                    aClass6_Sub1_724.method257(s, 7, anInt677 - 18 - i4 * 12, 1, 0xffff00);
                }

        }
        aClass4_775.method172(anInt776);
        aClass4_775.method172(anInt778);
        aClass4_775.method172(anInt779);
        if(anInt780 == 1)
            aClass4_775.method171(anInt776);
        else
        if(anInt780 == 2)
            aClass4_775.method171(anInt778);
        else
        if(anInt780 == 3)
            aClass4_775.method171(anInt779);
        Class4.anInt225 = 2;
        aClass4_775.method142();
        Class4.anInt225 = 0;
        aClass6_Sub1_724.method233(((Class6) (aClass6_Sub1_724)).anInt311 - 3 - 197, 3, anInt948, 128);
        method65();
        aClass6_Sub1_724.aBoolean338 = false;
        method69();
        aClass6_Sub1_724.method211(aGraphics857, 0, 0);
    }

    final void method109(int i, int j, int k, int l, int i1, int j1, int k1)
    {
        int l1 = anIntArray730[i1];
        int i2 = anIntArray972[i1];
        if(l1 == 0)
        {
            int j2 = 255 + i2 * 5 * 256;
            aClass6_Sub1_724.method213(i + k / 2, j + l / 2, 20 + i2 * 2, j2, 255 - i2 * 5);
        }
        if(l1 == 1)
        {
            int k2 = 0xff0000 + i2 * 5 * 256;
            aClass6_Sub1_724.method213(i + k / 2, j + l / 2, 10 + i2, k2, 255 - i2 * 5);
        }
    }

    protected final void method11(int i, int j, int k)
    {
        int l = Class1.anInt144;
        anIntArray981[anInt980] = j;
        anIntArray982[anInt980] = k;
        anInt980 = anInt980 + 1 & 0x1fff;
label0:
        for(int i1 = 10; i1 < 4000; i1++)
        {
            int j1 = anInt980 - i1 & 0x1fff;
            if(anIntArray981[j1] != j || anIntArray982[j1] != k)
                continue;
            boolean flag = false;
            int k1 = 1;
            do
            {
                if(k1 >= i1)
                    continue label0;
                int l1 = anInt980 - k1 & 0x1fff;
                int i2 = j1 - k1 & 0x1fff;
                if(anIntArray981[i2] != j || anIntArray982[i2] != k)
                    flag = true;
                if(anIntArray981[l1] != anIntArray981[i2] || anIntArray982[l1] != anIntArray982[i2])
                    continue label0;
                if(k1 == i1 - 1 && flag && anInt869 == 0 && anInt746 == 0)
                {
                    method71();
                    return;
                }
                k1++;
            } while(true);
        }

    }

    private final void method110()
    {
        int i = Class1.anInt144;
        if(anInt813 != 0)
        {
            int j = 0;
            do
            {
                if(j >= anInt756)
                    break;
                int l = anInt752 + 2;
                int j1 = anInt753 + 27 + j * 15;
                if(super.anInt33 > l - 2 && super.anInt34 > j1 - 12 && super.anInt34 < j1 + 4 && super.anInt33 < (l - 3) + anInt754)
                {
                    method93(anIntArray984[j]);
                    break;
                }
                j++;
            } while(true);
            anInt813 = 0;
            aBoolean854 = false;
            return;
        }
        if(super.anInt33 < anInt752 - 10 || super.anInt34 < anInt753 - 10 || super.anInt33 > anInt752 + anInt754 + 10 || super.anInt34 > anInt753 + anInt755 + 10)
        {
            aBoolean854 = false;
            return;
        }
        aClass6_Sub1_724.method214(anInt752, anInt753, anInt754, anInt755, 0xd0d0d0, 160);
        aClass6_Sub1_724.method257("Choose option", anInt752 + 2, anInt753 + 12, 1, 65535);
        for(int k = 0; k < anInt756; k++)
        {
            int i1 = anInt752 + 2;
            int k1 = anInt753 + 27 + k * 15;
            int l1 = 0xffffff;
            if(super.anInt33 > i1 - 2 && super.anInt34 > k1 - 12 && super.anInt34 < k1 + 4 && super.anInt33 < (i1 - 3) + anInt754)
                l1 = 0xffff00;
            aClass6_Sub1_724.method257(aStringArray985[anIntArray984[k]] + " " + aStringArray769[anIntArray984[k]], i1, k1, 1, l1);
        }

    }

    private final void method111(int i, int j, int k)
    {
        if(k == 0)
        {
            method83(anInt976, anInt977, i, j - 1, i, j, false, true);
            return;
        }
        if(k == 1)
        {
            method83(anInt976, anInt977, i - 1, j, i, j, false, true);
            return;
        } else
        {
            method83(anInt976, anInt977, i, j, i, j, true, true);
            return;
        }
    }

    private final boolean method112(int i)
    {
        int j = aClass2_975.anInt149 / 128;
        int k = aClass2_975.anInt150 / 128;
        for(int l = 2; l >= 1; l--)
        {
            if(i == 1 && ((aClass19_883.anIntArrayArray608[j][k - l] & 0x80) == 128 || (aClass19_883.anIntArrayArray608[j - l][k] & 0x80) == 128 || (aClass19_883.anIntArrayArray608[j - l][k - l] & 0x80) == 128))
                return false;
            if(i == 3 && ((aClass19_883.anIntArrayArray608[j][k + l] & 0x80) == 128 || (aClass19_883.anIntArrayArray608[j - l][k] & 0x80) == 128 || (aClass19_883.anIntArrayArray608[j - l][k + l] & 0x80) == 128))
                return false;
            if(i == 5 && ((aClass19_883.anIntArrayArray608[j][k + l] & 0x80) == 128 || (aClass19_883.anIntArrayArray608[j + l][k] & 0x80) == 128 || (aClass19_883.anIntArrayArray608[j + l][k + l] & 0x80) == 128))
                return false;
            if(i == 7 && ((aClass19_883.anIntArrayArray608[j][k - l] & 0x80) == 128 || (aClass19_883.anIntArrayArray608[j + l][k] & 0x80) == 128 || (aClass19_883.anIntArrayArray608[j + l][k - l] & 0x80) == 128))
                return false;
            if(i == 0 && (aClass19_883.anIntArrayArray608[j][k - l] & 0x80) == 128)
                return false;
            if(i == 2 && (aClass19_883.anIntArrayArray608[j - l][k] & 0x80) == 128)
                return false;
            if(i == 4 && (aClass19_883.anIntArrayArray608[j][k + l] & 0x80) == 128)
                return false;
            if(i == 6 && (aClass19_883.anIntArrayArray608[j + l][k] & 0x80) == 128)
                return false;
        }

        return true;
    }

    private final void method113()
    {
        int i = Class1.anInt144;
        byte abyte0[] = method18("textures" + Class18.anInt578 + ".jag", "", 50);
        if(abyte0 == null)
        {
            aBoolean922 = true;
            return;
        }
        byte abyte1[] = Class15.method366("index.dat", 0, abyte0);
        aClass10_739.method303(Class1.anInt61, 7, 11);
        for(int j = 0; j < Class1.anInt61; j++)
        {
            String s = Class1.aStringArray67[j];
            byte abyte2[] = Class15.method366(s + ".dat", 0, abyte0);
            aClass6_Sub1_724.method225(anInt952, abyte2, abyte1, 1);
            aClass6_Sub1_724.method216(0, 0, 128, 128, 0xff00ff);
            aClass6_Sub1_724.method231(0, 0, anInt952);
            int k = ((Class6) (aClass6_Sub1_724)).anIntArray328[anInt952];
            String s1 = Class1.aStringArray68[j];
            if(s1 != null && s1.length() > 0)
            {
                byte abyte3[] = Class15.method366(s1 + ".dat", 0, abyte0);
                aClass6_Sub1_724.method225(anInt952, abyte3, abyte1, 1);
                aClass6_Sub1_724.method231(0, 0, anInt952);
            }
            aClass6_Sub1_724.method230(anInt953 + j, 0, 0, k, k);
            int l = k * k;
            for(int i1 = 0; i1 < l; i1++)
                if(((Class6) (aClass6_Sub1_724)).anIntArrayArray321[anInt953 + j][i1] == 65280)
                    ((Class6) (aClass6_Sub1_724)).anIntArrayArray321[anInt953 + j][i1] = 0xff00ff;

            aClass6_Sub1_724.method227(anInt953 + j);
            aClass10_739.method304(j, ((Class6) (aClass6_Sub1_724)).aByteArrayArray322[anInt953 + j], ((Class6) (aClass6_Sub1_724)).anIntArrayArray323[anInt953 + j], k / 64 - 1);
        }

    }

    private final void method114()
    {
        if(anInt915 == 0 && super.anInt33 >= ((Class6) (aClass6_Sub1_724)).anInt311 - 35 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (aClass6_Sub1_724)).anInt311 - 3 && super.anInt34 < 35)
            anInt915 = 1;
        if(anInt915 == 0 && super.anInt33 >= ((Class6) (aClass6_Sub1_724)).anInt311 - 35 - 33 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (aClass6_Sub1_724)).anInt311 - 3 - 33 && super.anInt34 < 35)
        {
            anInt915 = 2;
            anInt859 = (int)(Math.random() * 13D) - 6;
            anInt860 = (int)(Math.random() * 23D) - 11;
        }
        if(anInt915 == 0 && super.anInt33 >= ((Class6) (aClass6_Sub1_724)).anInt311 - 35 - 66 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (aClass6_Sub1_724)).anInt311 - 3 - 66 && super.anInt34 < 35)
            anInt915 = 3;
        if(anInt915 == 0 && super.anInt33 >= ((Class6) (aClass6_Sub1_724)).anInt311 - 35 - 99 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (aClass6_Sub1_724)).anInt311 - 3 - 99 && super.anInt34 < 35)
            anInt915 = 4;
        if(anInt915 == 0 && super.anInt33 >= ((Class6) (aClass6_Sub1_724)).anInt311 - 35 - 132 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (aClass6_Sub1_724)).anInt311 - 3 - 132 && super.anInt34 < 35)
            anInt915 = 5;
        if(anInt915 == 0 && super.anInt33 >= ((Class6) (aClass6_Sub1_724)).anInt311 - 35 - 165 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (aClass6_Sub1_724)).anInt311 - 3 - 165 && super.anInt34 < 35)
            anInt915 = 6;
        if(anInt915 != 0 && super.anInt33 >= ((Class6) (aClass6_Sub1_724)).anInt311 - 35 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (aClass6_Sub1_724)).anInt311 - 3 && super.anInt34 < 26)
            anInt915 = 1;
        if(anInt915 != 0 && anInt915 != 2 && super.anInt33 >= ((Class6) (aClass6_Sub1_724)).anInt311 - 35 - 33 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (aClass6_Sub1_724)).anInt311 - 3 - 33 && super.anInt34 < 26)
        {
            anInt915 = 2;
            anInt859 = (int)(Math.random() * 13D) - 6;
            anInt860 = (int)(Math.random() * 23D) - 11;
        }
        if(anInt915 != 0 && super.anInt33 >= ((Class6) (aClass6_Sub1_724)).anInt311 - 35 - 66 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (aClass6_Sub1_724)).anInt311 - 3 - 66 && super.anInt34 < 26)
            anInt915 = 3;
        if(anInt915 != 0 && super.anInt33 >= ((Class6) (aClass6_Sub1_724)).anInt311 - 35 - 99 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (aClass6_Sub1_724)).anInt311 - 3 - 99 && super.anInt34 < 26)
            anInt915 = 4;
        if(anInt915 != 0 && super.anInt33 >= ((Class6) (aClass6_Sub1_724)).anInt311 - 35 - 132 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (aClass6_Sub1_724)).anInt311 - 3 - 132 && super.anInt34 < 26)
            anInt915 = 5;
        if(anInt915 != 0 && super.anInt33 >= ((Class6) (aClass6_Sub1_724)).anInt311 - 35 - 165 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (aClass6_Sub1_724)).anInt311 - 3 - 165 && super.anInt34 < 26)
            anInt915 = 6;
        if(anInt915 == 1 && (super.anInt33 < ((Class6) (aClass6_Sub1_724)).anInt311 - 248 || super.anInt34 > 36 + (anInt707 / 5) * 34))
            anInt915 = 0;
        if(anInt915 == 3 && (super.anInt33 < ((Class6) (aClass6_Sub1_724)).anInt311 - 199 || super.anInt34 > 316))
            anInt915 = 0;
        if((anInt915 == 2 || anInt915 == 4 || anInt915 == 5) && (super.anInt33 < ((Class6) (aClass6_Sub1_724)).anInt311 - 199 || super.anInt34 > 240))
            anInt915 = 0;
        if(anInt915 == 6 && (super.anInt33 < ((Class6) (aClass6_Sub1_724)).anInt311 - 199 || super.anInt34 > 311))
            anInt915 = 0;
    }

    private final void method115(boolean flag)
    {
        int i = Class1.anInt144;
        int j = ((Class6) (aClass6_Sub1_724)).anInt311 - 199;
        int k = 36;
        aClass6_Sub1_724.method231(j - 49, 3, anInt948 + 3);
        char c = '\304';
        char c1 = '\u0113';
        int l;
        int i1 = l = Class6.method223(160, 160, 160);
        if(anInt828 == 0)
            i1 = Class6.method223(220, 220, 220);
        else
            l = Class6.method223(220, 220, 220);
        aClass6_Sub1_724.method214(j, k, c / 2, 24, i1, 128);
        aClass6_Sub1_724.method214(j + c / 2, k, c / 2, 24, l, 128);
        aClass6_Sub1_724.method214(j, k + 24, c, c1 - 24, Class6.method223(220, 220, 220), 128);
        aClass6_Sub1_724.method218(j, k + 24, c, 0);
        aClass6_Sub1_724.method219(j + c / 2, k, 24, 0);
        aClass6_Sub1_724.method255("Stats", j + c / 4, k + 16, 4, 0);
        aClass6_Sub1_724.method255("Quests", j + c / 4 + c / 2, k + 16, 4, 0);
        if(anInt828 == 0)
        {
            int j1 = 72;
            int l1 = -1;
            aClass6_Sub1_724.method257("Skills", j + 5, j1, 3, 0xffff00);
            j1 += 13;
            for(int i2 = 0; i2 < 9; i2++)
            {
                int i3 = 0xffffff;
                if(super.anInt33 > j + 3 && super.anInt34 >= j1 - 11 && super.anInt34 < j1 + 2 && super.anInt33 < j + 90)
                {
                    i3 = 0xff0000;
                    l1 = i2;
                }
                aClass6_Sub1_724.method257(aStringArray713[i2] + ":@yel@" + anIntArray728[i2] + "/" + anIntArray825[i2], j + 5, j1, 1, i3);
                i3 = 0xffffff;
                if(super.anInt33 >= j + 90 && super.anInt34 >= j1 - 13 - 11 && super.anInt34 < (j1 - 13) + 2 && super.anInt33 < j + 196)
                {
                    i3 = 0xff0000;
                    l1 = i2 + 9;
                }
                aClass6_Sub1_724.method257(aStringArray713[i2 + 9] + ":@yel@" + anIntArray728[i2 + 9] + "/" + anIntArray825[i2 + 9], (j + c / 2) - 5, j1 - 13, 1, i3);
                j1 += 13;
            }

            aClass6_Sub1_724.method257("Quest Points:@yel@" + anInt996, (j + c / 2) - 5, j1 - 13, 1, 0xffffff);
            j1 += 12;
            aClass6_Sub1_724.method257("Fatigue: @yel@" + (anInt892 * 100) / 750 + "%", j + 5, j1 - 13, 1, 0xffffff);
            j1 += 8;
            aClass6_Sub1_724.method257("Equipment Status", j + 5, j1, 3, 0xffff00);
            j1 += 12;
            for(int j2 = 0; j2 < 3; j2++)
            {
                aClass6_Sub1_724.method257(aStringArray932[j2] + ":@yel@" + anIntArray797[j2], j + 5, j1, 1, 0xffffff);
                if(j2 < 2)
                    aClass6_Sub1_724.method257(aStringArray932[j2 + 3] + ":@yel@" + anIntArray797[j2 + 3], j + c / 2 + 25, j1, 1, 0xffffff);
                j1 += 13;
            }

            j1 += 6;
            aClass6_Sub1_724.method218(j, j1 - 15, c, 0);
            if(l1 != -1)
            {
                aClass6_Sub1_724.method257(aStringArray795[l1] + " skill", j + 5, j1, 1, 0xffff00);
                j1 += 12;
                int k2 = anIntArray686[0];
                for(int j3 = 0; j3 < 98; j3++)
                    if(anIntArray712[l1] >= anIntArray686[j3])
                        k2 = anIntArray686[j3 + 1];

                aClass6_Sub1_724.method257("Total xp: " + anIntArray712[l1] / 4, j + 5, j1, 1, 0xffffff);
                j1 += 12;
                aClass6_Sub1_724.method257("Next level at: " + k2 / 4, j + 5, j1, 1, 0xffffff);
            } else
            {
                aClass6_Sub1_724.method257("Overall levels", j + 5, j1, 1, 0xffff00);
                j1 += 12;
                int l2 = 0;
                for(int k3 = 0; k3 < 18; k3++)
                    l2 += anIntArray825[k3];

                aClass6_Sub1_724.method257("Skill total: " + l2, j + 5, j1, 1, 0xffffff);
                j1 += 12;
                aClass6_Sub1_724.method257("Combat level: " + aClass2_975.anInt168, j + 5, j1, 1, 0xffffff);
                j1 += 12;
            }
        }
        if(anInt828 == 1)
        {
            aClass4_826.method165(anInt827);
            aClass4_826.method167(anInt827, 0, "@whi@Quest-list (green=completed)");
            for(int k1 = 0; k1 < 50; k1++)
                aClass4_826.method167(anInt827, k1 + 1, (aBooleanArray716[k1] ? "@gre@" : "@red@") + aStringArray930[k1]);

            aClass4_826.method142();
        }
        if(!flag)
            return;
        j = super.anInt33 - (((Class6) (aClass6_Sub1_724)).anInt311 - 199);
        k = super.anInt34 - 36;
        if(j >= 0 && k >= 0 && j < c && k < c1)
        {
            if(anInt828 == 1)
                aClass4_826.method139(j + (((Class6) (aClass6_Sub1_724)).anInt311 - 199), k + 36, super.anInt36, super.anInt35);
            if(k <= 24 && anInt813 == 1)
            {
                if(j < 98)
                {
                    anInt828 = 0;
                    return;
                }
                if(j > 98)
                    anInt828 = 1;
            }
        }
    }

    private final void method116()
    {
        int i = Class1.anInt144;
        anInt863 = 0;
        int j = 135;
        for(int k = 0; k < 12; k++)
        {
            if(super.anInt33 > 66 && super.anInt33 < 446 && super.anInt34 >= j - 12 && super.anInt34 < j + 3)
                anInt863 = k + 1;
            j += 14;
        }

        if(anInt813 != 0 && anInt863 != 0)
        {
            anInt813 = 0;
            anInt986 = 2;
            super.aString40 = "";
            super.aString41 = "";
            return;
        }
        j += 15;
        if(anInt813 != 0)
        {
            anInt813 = 0;
            if(super.anInt33 < 56 || super.anInt34 < 35 || super.anInt33 > 456 || super.anInt34 > 325)
            {
                anInt986 = 0;
                return;
            }
            if(super.anInt33 > 66 && super.anInt33 < 446 && super.anInt34 >= j - 15 && super.anInt34 < j + 5)
            {
                anInt986 = 0;
                return;
            }
        }
        aClass6_Sub1_724.method216(56, 35, 400, 290, 0);
        aClass6_Sub1_724.method217(56, 35, 400, 290, 0xffffff);
        j = 50;
        aClass6_Sub1_724.method255("This form is for reporting players who are breaking our rules", 256, j, 1, 0xffffff);
        j += 15;
        aClass6_Sub1_724.method255("Using it sends a snapshot of the last 60 secs of activity to us", 256, j, 1, 0xffffff);
        j += 15;
        aClass6_Sub1_724.method255("If you misuse this form, you will be banned.", 256, j, 1, 0xff8000);
        j += 15;
        j += 10;
        aClass6_Sub1_724.method255("First indicate which of our 12 rules is being broken. For a detailed", 256, j, 1, 0xffff00);
        j += 15;
        aClass6_Sub1_724.method255("explanation of each rule please read the manual on our website.", 256, j, 1, 0xffff00);
        j += 15;
        int l;
        if(anInt863 == 1)
        {
            aClass6_Sub1_724.method217(66, j - 12, 380, 15, 0xffffff);
            l = 0xff8000;
        } else
        {
            l = 0xffffff;
        }
        aClass6_Sub1_724.method255("1: Offensive language", 256, j, 1, l);
        j += 14;
        if(anInt863 == 2)
        {
            aClass6_Sub1_724.method217(66, j - 12, 380, 15, 0xffffff);
            l = 0xff8000;
        } else
        {
            l = 0xffffff;
        }
        aClass6_Sub1_724.method255("2: Item scamming", 256, j, 1, l);
        j += 14;
        if(anInt863 == 3)
        {
            aClass6_Sub1_724.method217(66, j - 12, 380, 15, 0xffffff);
            l = 0xff8000;
        } else
        {
            l = 0xffffff;
        }
        aClass6_Sub1_724.method255("3: Password scamming", 256, j, 1, l);
        j += 14;
        if(anInt863 == 4)
        {
            aClass6_Sub1_724.method217(66, j - 12, 380, 15, 0xffffff);
            l = 0xff8000;
        } else
        {
            l = 0xffffff;
        }
        aClass6_Sub1_724.method255("4: Bug abuse", 256, j, 1, l);
        j += 14;
        if(anInt863 == 5)
        {
            aClass6_Sub1_724.method217(66, j - 12, 380, 15, 0xffffff);
            l = 0xff8000;
        } else
        {
            l = 0xffffff;
        }
        aClass6_Sub1_724.method255("5: Jagex Staff impersonation", 256, j, 1, l);
        j += 14;
        if(anInt863 == 6)
        {
            aClass6_Sub1_724.method217(66, j - 12, 380, 15, 0xffffff);
            l = 0xff8000;
        } else
        {
            l = 0xffffff;
        }
        aClass6_Sub1_724.method255("6: Account sharing/trading", 256, j, 1, l);
        j += 14;
        if(anInt863 == 7)
        {
            aClass6_Sub1_724.method217(66, j - 12, 380, 15, 0xffffff);
            l = 0xff8000;
        } else
        {
            l = 0xffffff;
        }
        aClass6_Sub1_724.method255("7: Macroing", 256, j, 1, l);
        j += 14;
        if(anInt863 == 8)
        {
            aClass6_Sub1_724.method217(66, j - 12, 380, 15, 0xffffff);
            l = 0xff8000;
        } else
        {
            l = 0xffffff;
        }
        aClass6_Sub1_724.method255("8: Mutiple logging in", 256, j, 1, l);
        j += 14;
        if(anInt863 == 9)
        {
            aClass6_Sub1_724.method217(66, j - 12, 380, 15, 0xffffff);
            l = 0xff8000;
        } else
        {
            l = 0xffffff;
        }
        aClass6_Sub1_724.method255("9: Encouraging others to break rules", 256, j, 1, l);
        j += 14;
        if(anInt863 == 10)
        {
            aClass6_Sub1_724.method217(66, j - 12, 380, 15, 0xffffff);
            l = 0xff8000;
        } else
        {
            l = 0xffffff;
        }
        aClass6_Sub1_724.method255("10: Misuse of customer support", 256, j, 1, l);
        j += 14;
        if(anInt863 == 11)
        {
            aClass6_Sub1_724.method217(66, j - 12, 380, 15, 0xffffff);
            l = 0xff8000;
        } else
        {
            l = 0xffffff;
        }
        aClass6_Sub1_724.method255("11: Advertising / website", 256, j, 1, l);
        j += 14;
        if(anInt863 == 12)
        {
            aClass6_Sub1_724.method217(66, j - 12, 380, 15, 0xffffff);
            l = 0xff8000;
        } else
        {
            l = 0xffffff;
        }
        aClass6_Sub1_724.method255("12: Real world item trading", 256, j, 1, l);
        j += 14;
        j += 15;
        l = 0xffffff;
        if(super.anInt33 > 196 && super.anInt33 < 316 && super.anInt34 > j - 15 && super.anInt34 < j + 5)
            l = 0xffff00;
        aClass6_Sub1_724.method255("Click here to cancel", 256, j, 1, l);
    }

    private final void method117()
    {
        int i = Class1.anInt144;
        if(anInt813 != 0)
        {
            anInt813 = 0;
            int j = super.anInt33 - 52;
            int k = super.anInt34 - 44;
            if(j >= 0 && k >= 12 && j < 408 && k < 246)
            {
                int l = 0;
                for(int j1 = 0; j1 < 5; j1++)
                {
                    for(int i2 = 0; i2 < 8; i2++)
                    {
                        int i3 = 7 + i2 * 49;
                        int i4 = 28 + j1 * 34;
                        if(j > i3 && j < i3 + 49 && k > i4 && k < i4 + 34 && anIntArray736[l] != -1)
                        {
                            anInt903 = l;
                            anInt904 = anIntArray736[l];
                        }
                        l++;
                    }

                }

                if(anInt903 >= 0)
                {
                    int k1 = anIntArray736[anInt903];
                    if(k1 != -1)
                    {
                        if(anIntArray737[anInt903] > 0 && j > 298 && k >= 204 && j < 408 && k <= 215)
                        {
                            int j2 = anInt900 + anIntArray738[anInt903];
                            if(j2 < 10)
                                j2 = 10;
                            int j3 = (j2 * Class1.anIntArray54[k1]) / 100;
                            super.aClass14_Sub1_620.method331(157);
                            super.aClass14_Sub1_620.method343(anIntArray736[anInt903]);
                            super.aClass14_Sub1_620.method332(j3);
                            super.aClass14_Sub1_620.method346();
                        }
                        if(method58(k1) > 0 && j > 2 && k >= 229 && j < 112 && k <= 240)
                        {
                            int k2 = anInt899 + anIntArray738[anInt903];
                            if(k2 < 10)
                                k2 = 10;
                            int k3 = (k2 * Class1.anIntArray54[k1]) / 100;
                            super.aClass14_Sub1_620.method331(211);
                            super.aClass14_Sub1_620.method343(anIntArray736[anInt903]);
                            super.aClass14_Sub1_620.method332(k3);
                            super.aClass14_Sub1_620.method346();
                        }
                    }
                }
            } else
            {
                super.aClass14_Sub1_620.method331(56);
                super.aClass14_Sub1_620.method346();
                aBoolean727 = false;
                return;
            }
        }
        byte byte0 = 52;
        byte byte1 = 44;
        aClass6_Sub1_724.method216(byte0, byte1, 408, 12, 192);
        int i1 = 0x989898;
        aClass6_Sub1_724.method214(byte0, byte1 + 12, 408, 17, i1, 160);
        aClass6_Sub1_724.method214(byte0, byte1 + 29, 8, 170, i1, 160);
        aClass6_Sub1_724.method214(byte0 + 399, byte1 + 29, 9, 170, i1, 160);
        aClass6_Sub1_724.method214(byte0, byte1 + 199, 408, 47, i1, 160);
        aClass6_Sub1_724.method257("Buying and selling items", byte0 + 1, byte1 + 10, 1, 0xffffff);
        int l1 = 0xffffff;
        if(super.anInt33 > byte0 + 320 && super.anInt34 >= byte1 && super.anInt33 < byte0 + 408 && super.anInt34 < byte1 + 12)
            l1 = 0xff0000;
        aClass6_Sub1_724.method254("Close window", byte0 + 406, byte1 + 10, 1, l1);
        aClass6_Sub1_724.method257("Shops stock in green", byte0 + 2, byte1 + 24, 1, 65280);
        aClass6_Sub1_724.method257("Number you own in blue", byte0 + 135, byte1 + 24, 1, 65535);
        aClass6_Sub1_724.method257("Your money: " + method58(10) + "gp", byte0 + 280, byte1 + 24, 1, 0xffff00);
        int l2 = 0xd0d0d0;
        int l3 = 0;
        for(int j4 = 0; j4 < 5; j4++)
        {
            for(int l4 = 0; l4 < 8; l4++)
            {
                int k5 = byte0 + 7 + l4 * 49;
                int j6 = byte1 + 28 + j4 * 34;
                if(anInt903 == l3)
                    aClass6_Sub1_724.method214(k5, j6, 49, 34, 0xff0000, 160);
                else
                    aClass6_Sub1_724.method214(k5, j6, 49, 34, l2, 160);
                aClass6_Sub1_724.method217(k5, j6, 50, 35, 0);
                if(anIntArray736[l3] != -1)
                {
                    aClass6_Sub1_724.method247(k5, j6, 48, 32, anInt950 + Class1.anIntArray53[anIntArray736[l3]], Class1.anIntArray58[anIntArray736[l3]], 0, 0, false);
                    aClass6_Sub1_724.method257(String.valueOf(anIntArray737[l3]), k5 + 1, j6 + 10, 1, 65280);
                    aClass6_Sub1_724.method254(String.valueOf(method58(anIntArray736[l3])), k5 + 47, j6 + 10, 1, 65535);
                }
                l3++;
            }

        }

        aClass6_Sub1_724.method218(byte0 + 5, byte1 + 222, 398, 0);
        if(anInt903 == -1)
        {
            aClass6_Sub1_724.method255("Select an object to buy or sell", byte0 + 204, byte1 + 214, 3, 0xffff00);
            return;
        }
        int k4 = anIntArray736[anInt903];
        if(k4 != -1)
        {
            if(anIntArray737[anInt903] > 0)
            {
                int i5 = anInt900 + anIntArray738[anInt903];
                if(i5 < 10)
                    i5 = 10;
                int l5 = (i5 * Class1.anIntArray54[k4]) / 100;
                aClass6_Sub1_724.method257("Buy a new " + Class1.aStringArray109[k4] + " for " + l5 + "gp", byte0 + 2, byte1 + 214, 1, 0xffff00);
                int k6 = 0xffffff;
                if(super.anInt33 > byte0 + 298 && super.anInt34 >= byte1 + 204 && super.anInt33 < byte0 + 408 && super.anInt34 <= byte1 + 215)
                    k6 = 0xff0000;
                aClass6_Sub1_724.method254("Click here to buy", byte0 + 405, byte1 + 214, 3, k6);
            } else
            {
                aClass6_Sub1_724.method255("This item is not currently available to buy", byte0 + 204, byte1 + 214, 3, 0xffff00);
            }
            if(method58(k4) > 0)
            {
                int j5 = anInt899 + anIntArray738[anInt903];
                if(j5 < 10)
                    j5 = 10;
                int i6 = (j5 * Class1.anIntArray54[k4]) / 100;
                aClass6_Sub1_724.method254("Sell your " + Class1.aStringArray109[k4] + " for " + i6 + "gp", byte0 + 405, byte1 + 239, 1, 0xffff00);
                int l6 = 0xffffff;
                if(super.anInt33 > byte0 + 2 && super.anInt34 >= byte1 + 229 && super.anInt33 < byte0 + 112 && super.anInt34 <= byte1 + 240)
                    l6 = 0xff0000;
                aClass6_Sub1_724.method257("Click here to sell", byte0 + 2, byte1 + 239, 3, l6);
                return;
            }
            aClass6_Sub1_724.method255("You do not have any of this item to sell", byte0 + 204, byte1 + 239, 3, 0xffff00);
        }
    }

    private final void method118(String s, int i)
    {
        int j = Class1.anInt144;
        if(i == 2 || i == 4 || i == 6)
        {
            for(; s.length() > 5 && s.charAt(0) == '@' && s.charAt(4) == '@'; s = s.substring(5));
            int k = s.indexOf(":");
            if(k != -1)
            {
                String s1 = s.substring(0, k);
                long l1 = Class15.method362(s1);
                for(int i1 = 0; i1 < super.anInt627; i1++)
                    if(super.aLongArray628[i1] == l1)
                        return;

            }
        }
        if(i == 2)
            s = "@yel@" + s;
        if(i == 3 || i == 4)
            s = "@whi@" + s;
        if(i == 6)
            s = "@cya@" + s;
        if(anInt780 != 0)
        {
            if(i == 4 || i == 3)
                anInt790 = 200;
            if(i == 2 && anInt780 != 1)
                anInt791 = 200;
            if(i == 5 && anInt780 != 2)
                anInt792 = 200;
            if(i == 6 && anInt780 != 3)
                anInt793 = 200;
            if(i == 3 && anInt780 != 0)
                anInt780 = 0;
            if(i == 6 && anInt780 != 3 && anInt780 != 0)
                anInt780 = 0;
        }
        for(int l = 4; l > 0; l--)
        {
            aStringArray774[l] = aStringArray774[l - 1];
            anIntArray935[l] = anIntArray935[l - 1];
        }

        aStringArray774[0] = s;
        anIntArray935[0] = 300;
        if(i == 2)
            if(aClass4_775.anIntArray187[anInt776] == aClass4_775.anIntArray188[anInt776] - 4)
                aClass4_775.method168(anInt776, s, true);
            else
                aClass4_775.method168(anInt776, s, false);
        if(i == 5)
            if(aClass4_775.anIntArray187[anInt778] == aClass4_775.anIntArray188[anInt778] - 4)
                aClass4_775.method168(anInt778, s, true);
            else
                aClass4_775.method168(anInt778, s, false);
        if(i == 6)
        {
            if(aClass4_775.anIntArray187[anInt779] == aClass4_775.anIntArray188[anInt779] - 4)
            {
                aClass4_775.method168(anInt779, s, true);
                return;
            }
            aClass4_775.method168(anInt779, s, false);
        }
    }

    final void method119(int i, int j, int k, int l, int i1, int j1, int k1)
    {
        int l1 = Class1.anIntArray53[i1] + anInt950;
        int i2 = Class1.anIntArray58[i1];
        aClass6_Sub1_724.method247(i, j, k, l, l1, i2, 0, 0, false);
    }

    private final void method120()
    {
        int i = Class1.anInt144;
        aClass4_830.method139(super.anInt33, super.anInt34, super.anInt36, super.anInt35);
        if(aClass4_830.method140(anInt694))
            do
                anInt871 = ((anInt871 - 1) + Class1.anInt123) % Class1.anInt123;
            while((Class1.anIntArray84[anInt871] & 3) != 1 || (Class1.anIntArray84[anInt871] & 4 * anInt878) == 0);
        if(aClass4_830.method140(anInt695))
            do
                anInt871 = (anInt871 + 1) % Class1.anInt123;
            while((Class1.anIntArray84[anInt871] & 3) != 1 || (Class1.anIntArray84[anInt871] & 4 * anInt878) == 0);
        if(aClass4_830.method140(anInt696))
            anInt874 = ((anInt874 - 1) + anIntArray885.length) % anIntArray885.length;
        if(aClass4_830.method140(anInt697))
            anInt874 = (anInt874 + 1) % anIntArray885.length;
        if(aClass4_830.method140(anInt698) || aClass4_830.method140(anInt699))
        {
            for(anInt878 = 3 - anInt878; (Class1.anIntArray84[anInt871] & 3) != 1 || (Class1.anIntArray84[anInt871] & 4 * anInt878) == 0; anInt871 = (anInt871 + 1) % Class1.anInt123);
            for(; (Class1.anIntArray84[anInt872] & 3) != 2 || (Class1.anIntArray84[anInt872] & 4 * anInt878) == 0; anInt872 = (anInt872 + 1) % Class1.anInt123);
        }
        if(aClass4_830.method140(anInt700))
            anInt875 = ((anInt875 - 1) + anIntArray832.length) % anIntArray832.length;
        if(aClass4_830.method140(anInt701))
            anInt875 = (anInt875 + 1) % anIntArray832.length;
        if(aClass4_830.method140(anInt702))
            anInt877 = ((anInt877 - 1) + anIntArray829.length) % anIntArray829.length;
        if(aClass4_830.method140(anInt703))
            anInt877 = (anInt877 + 1) % anIntArray829.length;
        if(aClass4_830.method140(anInt704))
            anInt876 = ((anInt876 - 1) + anIntArray832.length) % anIntArray832.length;
        if(aClass4_830.method140(anInt705))
            anInt876 = (anInt876 + 1) % anIntArray832.length;
        if(aClass4_830.method140(anInt706))
        {
            super.aClass14_Sub1_620.method331(16);
            super.aClass14_Sub1_620.method348(anInt878);
            super.aClass14_Sub1_620.method348(anInt871);
            super.aClass14_Sub1_620.method348(anInt872);
            super.aClass14_Sub1_620.method348(anInt873);
            super.aClass14_Sub1_620.method348(anInt874);
            super.aClass14_Sub1_620.method348(anInt875);
            super.aClass14_Sub1_620.method348(anInt876);
            super.aClass14_Sub1_620.method348(anInt877);
            super.aClass14_Sub1_620.method346();
            aClass6_Sub1_724.method212();
            aBoolean992 = false;
        }
    }

    private final void method121()
    {
        int i = Class1.anInt144;
        byte abyte0[] = method18("media" + Class18.anInt576 + ".jag", "", 20);
        if(abyte0 == null)
        {
            aBoolean922 = true;
            return;
        }
        byte abyte1[] = Class15.method366("index.dat", 0, abyte0);
        aClass6_Sub1_724.method225(anInt948, Class15.method366("inv1.dat", 0, abyte0), abyte1, 1);
        aClass6_Sub1_724.method225(anInt948 + 1, Class15.method366("inv2.dat", 0, abyte0), abyte1, 6);
        aClass6_Sub1_724.method225(anInt948 + 9, Class15.method366("bubble.dat", 0, abyte0), abyte1, 1);
        aClass6_Sub1_724.method225(anInt948 + 10, Class15.method366("runescape.dat", 0, abyte0), abyte1, 1);
        aClass6_Sub1_724.method225(anInt948 + 11, Class15.method366("splat.dat", 0, abyte0), abyte1, 3);
        aClass6_Sub1_724.method225(anInt948 + 14, Class15.method366("icon.dat", 0, abyte0), abyte1, 8);
        aClass6_Sub1_724.method225(anInt948 + 22, Class15.method366("hbar.dat", 0, abyte0), abyte1, 1);
        aClass6_Sub1_724.method225(anInt948 + 23, Class15.method366("hbar2.dat", 0, abyte0), abyte1, 1);
        aClass6_Sub1_724.method225(anInt948 + 24, Class15.method366("compass.dat", 0, abyte0), abyte1, 1);
        aClass6_Sub1_724.method225(anInt948 + 25, Class15.method366("buttons.dat", 0, abyte0), abyte1, 2);
        aClass6_Sub1_724.method225(anInt949, Class15.method366("scrollbar.dat", 0, abyte0), abyte1, 2);
        aClass6_Sub1_724.method225(anInt949 + 2, Class15.method366("corners.dat", 0, abyte0), abyte1, 4);
        aClass6_Sub1_724.method225(anInt949 + 6, Class15.method366("arrows.dat", 0, abyte0), abyte1, 2);
        aClass6_Sub1_724.method225(anInt951, Class15.method366("projectile.dat", 0, abyte0), abyte1, Class1.anInt108);
        int j = Class1.anInt76;
        for(int k = 1; j > 0; k++)
        {
            int k1 = j;
            j -= 30;
            if(k1 > 30)
                k1 = 30;
            aClass6_Sub1_724.method225(anInt950 + (k - 1) * 30, Class15.method366("objects" + k + ".dat", 0, abyte0), abyte1, k1);
        }

        aClass6_Sub1_724.method228(anInt948);
        aClass6_Sub1_724.method228(anInt948 + 9);
        for(int l = 11; l <= 26; l++)
            aClass6_Sub1_724.method228(anInt948 + l);

        for(int i1 = 0; i1 < Class1.anInt108; i1++)
            aClass6_Sub1_724.method228(anInt951 + i1);

        for(int j1 = 0; j1 < Class1.anInt76; j1++)
            aClass6_Sub1_724.method228(anInt950 + j1);

    }

    protected final byte[] method18(String s, String s1, int i)
    {
        if(!aBoolean979)
            s = "Data/" + s;
        byte abyte0[] = Class8.method265(s);
        if(abyte0 != null)
        {
            int j = ((abyte0[0] & 0xff) << 16) + ((abyte0[1] & 0xff) << 8) + (abyte0[2] & 0xff);
            int k = ((abyte0[3] & 0xff) << 16) + ((abyte0[4] & 0xff) << 8) + (abyte0[5] & 0xff);
            byte abyte1[] = new byte[abyte0.length - 6];
            for(int l = 0; l < abyte0.length - 6; l++)
                abyte1[l] = abyte0[l + 6];

            method15(i, "Unpacking " + s1);
            if(k != j)
            {
                byte abyte2[] = new byte[j];
                Class3.method130(abyte2, j, abyte1, k, 0);
                return abyte2;
            } else
            {
                return abyte1;
            }
        } else
        {
            return super.method18(s, s1, i);
        }
    }

    protected final Socket method19(String s, int i)
        throws IOException
    {
        if(Class8.anApplet370 != null)
        {
            Socket socket = Class8.method266(i);
            if(socket == null)
                throw new IOException();
            else
                return socket;
        }
        Socket socket1;
        if(method7())
            socket1 = new Socket(InetAddress.getByName(getCodeBase().getHost()), i);
        else
            socket1 = new Socket(InetAddress.getByName(s), i);
        socket1.setSoTimeout(30000);
        socket1.setTcpNoDelay(true);
        return socket1;
    }

    protected final void method2()
    {
        if(aBoolean666)
            return;
        if(aBoolean890)
            return;
        if(aBoolean922)
            return;
        try
        {
            anInt918++;
            if(anInt947 == 0)
            {
                super.anInt12 = 0;
                method57();
            }
            if(anInt947 == 1)
            {
                super.anInt12++;
                method82();
            }
            super.anInt36 = 0;
            super.anInt38 = 0;
            anInt902++;
            if(anInt902 > 500)
            {
                anInt902 = 0;
                int i = (int)(Math.random() * 4D);
                if((i & 1) == 1)
                    anInt895 += anInt896;
                if((i & 2) == 2)
                    anInt973 += anInt974;
            }
            if(anInt895 < -50)
                anInt896 = 2;
            if(anInt895 > 50)
                anInt896 = -2;
            if(anInt973 < -50)
                anInt974 = 2;
            if(anInt973 > 50)
                anInt974 = -2;
            if(anInt790 > 0)
                anInt790--;
            if(anInt791 > 0)
                anInt791--;
            if(anInt792 > 0)
                anInt792--;
            if(anInt793 > 0)
            {
                anInt793--;
                return;
            }
        }
        catch(OutOfMemoryError outofmemoryerror)
        {
            method85();
            aBoolean890 = true;
        }
    }

    protected final void method20(Runnable runnable)
    {
        if(Class8.anApplet370 != null)
        {
            Class8.method267(runnable);
            return;
        } else
        {
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            thread.start();
            return;
        }
    }

    protected final void method23()
    {
        anInt749 = 0;
        if(anInt746 != 0)
        {
            method39();
            return;
        } else
        {
            super.method23();
            return;
        }
    }

    protected final void method36(String s, String s1)
    {
        if(anInt690 == 1)
            aClass4_667.method169(anInt732, s + " " + s1);
        if(anInt690 == 2)
            aClass4_751.method169(anInt864, s + " " + s1);
        aString862 = s1;
        method70();
        method9();
    }

    protected final void method38()
    {
        int i = Class1.anInt144;
        anInt749 = 0;
        anInt750 = 0;
        anInt746 = 0;
        anInt690 = 0;
        anInt947 = 1;
        method66();
        aClass6_Sub1_724.method212();
        aClass6_Sub1_724.method211(aGraphics857, 0, 0);
        for(int j = 0; j < anInt796; j++)
        {
            aClass10_739.method270(aClass5Array814[j]);
            aClass19_883.method434(anIntArray760[j], anIntArray761[j], anIntArray762[j]);
        }

        for(int k = 0; k < anInt855; k++)
        {
            aClass10_739.method270(aClass5Array781[k]);
            aClass19_883.method427(anIntArray747[k], anIntArray748[k], anIntArray740[k], anIntArray741[k]);
        }

        anInt796 = 0;
        anInt855 = 0;
        anInt823 = 0;
        anInt742 = 0;
        for(int l = 0; l < 4000; l++)
            aClass2Array891[l] = null;

        for(int i1 = 0; i1 < 500; i1++)
            aClass2Array983[i1] = null;

        anInt905 = 0;
        for(int j1 = 0; j1 < 5000; j1++)
            aClass2Array957[j1] = null;

        for(int k1 = 0; k1 < 500; k1++)
            aClass2Array768[k1] = null;

        for(int l1 = 0; l1 < 50; l1++)
            aBooleanArray679[l1] = false;

        anInt813 = 0;
        super.anInt36 = 0;
        super.anInt35 = 0;
        aBoolean727 = false;
        aBoolean879 = false;
        aBoolean870 = false;
        super.anInt624 = 0;
    }

    protected final void method39()
    {
        anInt749 = 0;
        anInt690 = 0;
        anInt947 = 0;
        anInt746 = 0;
    }

    protected final void method4()
    {
        if(aBoolean922)
        {
            Graphics g = getGraphics();
            g.setColor(Color.black);
            g.fillRect(0, 0, 512, 356);
            g.setFont(new Font("Helvetica", 1, 16));
            g.setColor(Color.yellow);
            int i = 35;
            g.drawString("Sorry, an error has occured whilst loading RuneScape", 30, i);
            i += 50;
            g.setColor(Color.white);
            g.drawString("To fix this try the following (in order):", 30, i);
            i += 50;
            g.setColor(Color.white);
            g.setFont(new Font("Helvetica", 1, 12));
            g.drawString("1: Try closing ALL open web-browser windows, and reloading", 30, i);
            i += 30;
            g.drawString("2: Try clearing your web-browsers cache from tools->internet options", 30, i);
            i += 30;
            g.drawString("3: Try using a different game-world", 30, i);
            i += 30;
            g.drawString("4: Try rebooting your computer", 30, i);
            i += 30;
            g.drawString("5: Try selecting a different version of Java from the play-game menu", 30, i);
            method8(1);
            return;
        }
        if(aBoolean666)
        {
            Graphics g1 = getGraphics();
            g1.setColor(Color.black);
            g1.fillRect(0, 0, 512, 356);
            g1.setFont(new Font("Helvetica", 1, 20));
            g1.setColor(Color.white);
            g1.drawString("Error - unable to load game!", 50, 50);
            g1.drawString("To play RuneScape make sure you play from", 50, 100);
            g1.drawString("http://www.runescape.com", 50, 150);
            method8(1);
            return;
        }
        if(aBoolean890)
        {
            Graphics g2 = getGraphics();
            g2.setColor(Color.black);
            g2.fillRect(0, 0, 512, 356);
            g2.setFont(new Font("Helvetica", 1, 20));
            g2.setColor(Color.white);
            g2.drawString("Error - out of memory!", 50, 50);
            g2.drawString("Close ALL unnecessary programs", 50, 100);
            g2.drawString("and windows before loading the game", 50, 150);
            g2.drawString("RuneScape needs about 48meg of spare RAM", 50, 200);
            method8(1);
            return;
        }
        try
        {
            if(anInt947 == 0)
            {
                aClass6_Sub1_724.aBoolean338 = false;
                method70();
            }
            if(anInt947 == 1)
            {
                aClass6_Sub1_724.aBoolean338 = true;
                method108();
                return;
            }
        }
        catch(OutOfMemoryError outofmemoryerror)
        {
            method85();
            aBoolean890 = true;
        }
    }

    protected final void method40()
    {
        anInt746 = 0;
        method118("@cya@Sorry, you can't logout at the moment", 3);
    }

    protected final void method41(int i, int j, byte abyte0[])
    {
        int k = Class1.anInt144;
        if(i == 18)
        {
            anInt743 = anInt742;
            for(int l = 0; l < anInt743; l++)
                aClass2Array923[l] = aClass2Array983[l];

            int i1 = 8;
            anInt976 = Class15.method359(abyte0, i1, 11);
            i1 += 11;
            anInt977 = Class15.method359(abyte0, i1, 13);
            i1 += 13;
            int i5 = Class15.method359(abyte0, i1, 4);
            i1 += 4;
            boolean flag1 = method98(anInt976, anInt977);
            anInt976 -= anInt783;
            anInt977 -= anInt784;
            int j13 = anInt976 * anInt946 + 64;
            int k16 = anInt977 * anInt946 + 64;
            if(flag1)
            {
                aClass2_975.anInt156 = 0;
                aClass2_975.anInt155 = 0;
                aClass2_975.anInt149 = aClass2_975.anIntArray157[0] = j13;
                aClass2_975.anInt150 = aClass2_975.anIntArray158[0] = k16;
            }
            anInt742 = 0;
            aClass2_975 = method76(anInt978, j13, k16, i5);
            int j19 = Class15.method359(abyte0, i1, 8);
            i1 += 8;
            for(int l22 = 0; l22 < j19; l22++)
            {
                Class2 class2_3 = aClass2Array923[l22 + 1];
                int l31 = Class15.method359(abyte0, i1, 1);
                i1++;
                if(l31 != 0)
                {
                    int k33 = Class15.method359(abyte0, i1, 1);
                    i1++;
                    if(k33 == 0)
                    {
                        int l34 = Class15.method359(abyte0, i1, 3);
                        i1 += 3;
                        int l35 = class2_3.anInt156;
                        int j36 = class2_3.anIntArray157[l35];
                        int l36 = class2_3.anIntArray158[l35];
                        if(l34 == 2 || l34 == 1 || l34 == 3)
                            j36 += anInt946;
                        if(l34 == 6 || l34 == 5 || l34 == 7)
                            j36 -= anInt946;
                        if(l34 == 4 || l34 == 3 || l34 == 5)
                            l36 += anInt946;
                        if(l34 == 0 || l34 == 1 || l34 == 7)
                            l36 -= anInt946;
                        class2_3.anInt154 = l34;
                        class2_3.anInt156 = l35 = (l35 + 1) % 10;
                        class2_3.anIntArray157[l35] = j36;
                        class2_3.anIntArray158[l35] = l36;
                    } else
                    {
                        int i35 = Class15.method359(abyte0, i1, 4);
                        if((i35 & 0xc) == 12)
                        {
                            i1 += 2;
                            continue;
                        }
                        class2_3.anInt154 = Class15.method359(abyte0, i1, 4);
                        i1 += 4;
                    }
                }
                aClass2Array983[anInt742++] = class2_3;
            }

            int i23 = 0;
            do
            {
                if(i1 + 24 >= j * 8)
                    break;
                int j28 = Class15.method359(abyte0, i1, 11);
                i1 += 11;
                int i32 = Class15.method359(abyte0, i1, 5);
                i1 += 5;
                if(i32 > 15)
                    i32 -= 32;
                int l33 = Class15.method359(abyte0, i1, 5);
                i1 += 5;
                if(l33 > 15)
                    l33 -= 32;
                int j35 = Class15.method359(abyte0, i1, 4);
                i1 += 4;
                int i36 = Class15.method359(abyte0, i1, 1);
                i1++;
                int k36 = (anInt976 + i32) * anInt946 + 64;
                int i37 = (anInt977 + l33) * anInt946 + 64;
                method76(j28, k36, i37, j35);
                if(i36 == 0)
                    anIntArray815[i23++] = j28;
            } while(true);
            if(i23 > 0)
            {
                super.aClass14_Sub1_620.method331(118);
                super.aClass14_Sub1_620.method343(i23);
                for(int k28 = 0; k28 < i23; k28++)
                {
                    Class2 class2_4 = aClass2Array891[anIntArray815[k28]];
                    super.aClass14_Sub1_620.method343(class2_4.anInt147);
                    super.aClass14_Sub1_620.method343(class2_4.anInt148);
                }

                super.aClass14_Sub1_620.method346();
                i23 = 0;
            }
            return;
        }
        if(i == 181)
        {
            for(int j1 = 1; j1 < j;)
                if(Class15.method353(abyte0[j1]) == 255)
                {
                    int j5 = 0;
                    int k9 = anInt976 + abyte0[j1 + 1] >> 3;
                    int k13 = anInt977 + abyte0[j1 + 2] >> 3;
                    j1 += 3;
                    for(int l16 = 0; l16 < anInt823; l16++)
                    {
                        int k19 = (anIntArray770[l16] >> 3) - k9;
                        int j23 = (anIntArray771[l16] >> 3) - k13;
                        if(k19 == 0 && j23 == 0)
                            continue;
                        if(l16 != j5)
                        {
                            anIntArray770[j5] = anIntArray770[l16];
                            anIntArray771[j5] = anIntArray771[l16];
                            anIntArray772[j5] = anIntArray772[l16];
                            anIntArray773[j5] = anIntArray773[l16];
                        }
                        j5++;
                    }

                    anInt823 = j5;
                } else
                {
                    int k5 = Class15.method354(abyte0, j1);
                    j1 += 2;
                    int l9 = anInt976 + abyte0[j1++];
                    int l13 = anInt977 + abyte0[j1++];
                    if((k5 & 0x8000) == 0)
                    {
                        anIntArray770[anInt823] = l9;
                        anIntArray771[anInt823] = l13;
                        anIntArray772[anInt823] = k5;
                        anIntArray773[anInt823] = 0;
                        int i17 = 0;
                        do
                        {
                            if(i17 >= anInt796)
                                break;
                            if(anIntArray760[i17] == l9 && anIntArray761[i17] == l13)
                            {
                                anIntArray773[anInt823] = Class1.anIntArray66[anIntArray762[i17]];
                                break;
                            }
                            i17++;
                        } while(true);
                        anInt823++;
                    } else
                    {
                        k5 &= 0x7fff;
                        int j17 = 0;
                        for(int l19 = 0; l19 < anInt823; l19++)
                            if(anIntArray770[l19] != l9 || anIntArray771[l19] != l13 || anIntArray772[l19] != k5)
                            {
                                if(l19 != j17)
                                {
                                    anIntArray770[j17] = anIntArray770[l19];
                                    anIntArray771[j17] = anIntArray771[l19];
                                    anIntArray772[j17] = anIntArray772[l19];
                                    anIntArray773[j17] = anIntArray773[l19];
                                }
                                j17++;
                            } else
                            {
                                k5 = -123;
                            }

                        anInt823 = j17;
                    }
                }

            return;
        }
        if(i == 238)
        {
            int k1 = 1;
            do
            {
                if(k1 >= j)
                    break;
                if(Class15.method353(abyte0[k1]) == 255)
                {
                    int l5 = 0;
                    int i10 = anInt976 + abyte0[k1 + 1] >> 3;
                    int i14 = anInt977 + abyte0[k1 + 2] >> 3;
                    k1 += 3;
                    for(int k17 = 0; k17 < anInt796; k17++)
                    {
                        int i20 = (anIntArray760[k17] >> 3) - i10;
                        int k23 = (anIntArray761[k17] >> 3) - i14;
                        if(i20 != 0 || k23 != 0)
                        {
                            if(k17 != l5)
                            {
                                aClass5Array814[l5] = aClass5Array814[k17];
                                aClass5Array814[l5].anInt257 = l5;
                                anIntArray760[l5] = anIntArray760[k17];
                                anIntArray761[l5] = anIntArray761[k17];
                                anIntArray762[l5] = anIntArray762[k17];
                                anIntArray763[l5] = anIntArray763[k17];
                            }
                            l5++;
                        } else
                        {
                            aClass10_739.method270(aClass5Array814[k17]);
                            aClass19_883.method434(anIntArray760[k17], anIntArray761[k17], anIntArray762[k17]);
                        }
                    }

                    anInt796 = l5;
                } else
                {
                    int i6 = Class15.method354(abyte0, k1);
                    k1 += 2;
                    int j10 = anInt976 + abyte0[k1++];
                    int j14 = anInt977 + abyte0[k1++];
                    int l17 = 0;
                    for(int j20 = 0; j20 < anInt796; j20++)
                        if(anIntArray760[j20] != j10 || anIntArray761[j20] != j14)
                        {
                            if(j20 != l17)
                            {
                                aClass5Array814[l17] = aClass5Array814[j20];
                                aClass5Array814[l17].anInt257 = l17;
                                anIntArray760[l17] = anIntArray760[j20];
                                anIntArray761[l17] = anIntArray761[j20];
                                anIntArray762[l17] = anIntArray762[j20];
                                anIntArray763[l17] = anIntArray763[j20];
                            }
                            l17++;
                        } else
                        {
                            aClass10_739.method270(aClass5Array814[j20]);
                            aClass19_883.method434(anIntArray760[j20], anIntArray761[j20], anIntArray762[j20]);
                        }

                    anInt796 = l17;
                    if(i6 != 60000)
                    {
                        int k20 = aClass19_883.method402(j10, j14);
                        int l23;
                        int l28;
                        if(k20 == 0 || k20 == 4)
                        {
                            l23 = Class1.anIntArray63[i6];
                            l28 = Class1.anIntArray64[i6];
                        } else
                        {
                            l28 = Class1.anIntArray63[i6];
                            l23 = Class1.anIntArray64[i6];
                        }
                        int j32 = ((j10 + j10 + l23) * anInt946) / 2;
                        int i34 = ((j14 + j14 + l28) * anInt946) / 2;
                        int k35 = Class1.anIntArray62[i6];
                        Class5 class5_1 = aClass5Array994[k35].method204();
                        aClass10_739.method269(class5_1);
                        class5_1.anInt257 = anInt796;
                        class5_1.method189(0, k20 * 32, 0);
                        class5_1.method191(j32, -aClass19_883.method421(j32, i34), i34);
                        class5_1.method185(true, 48, 48, -50, -10, -50);
                        aClass19_883.method407(j10, j14, i6);
                        if(i6 == 74)
                            class5_1.method191(0, -480, 0);
                        anIntArray760[anInt796] = j10;
                        anIntArray761[anInt796] = j14;
                        anIntArray762[anInt796] = i6;
                        anIntArray763[anInt796] = k20;
                        aClass5Array814[anInt796++] = class5_1;
                    }
                }
            } while(true);
            return;
        }
        if(i == 171)
        {
            int l1 = 1;
            anInt708 = abyte0[l1++] & 0xff;
            for(int j6 = 0; j6 < anInt708; j6++)
            {
                int k10 = Class15.method354(abyte0, l1);
                l1 += 2;
                anIntArray709[j6] = k10 & 0x7fff;
                anIntArray711[j6] = k10 / 32768;
                if(Class1.anIntArray55[k10 & 0x7fff] == 0)
                {
                    anIntArray710[j6] = Class15.method358(abyte0, l1);
                    if(anIntArray710[j6] >= 128)
                        l1 += 4;
                    else
                        l1++;
                } else
                {
                    anIntArray710[j6] = 1;
                }
            }

            return;
        }
        if(i == 139)
        {
            int i2 = Class15.method354(abyte0, 1);
            int k6 = 3;
            for(int l10 = 0; l10 < i2; l10++)
            {
                int k14 = Class15.method354(abyte0, k6);
                k6 += 2;
                Class2 class2_1 = aClass2Array891[k14];
                byte byte2 = abyte0[k6];
                k6++;
                if(byte2 == 0)
                {
                    int i24 = Class15.method354(abyte0, k6);
                    k6 += 2;
                    if(class2_1 != null)
                    {
                        class2_1.anInt163 = 150;
                        class2_1.anInt162 = i24;
                    }
                    continue;
                }
                if(byte2 == 1)
                {
                    byte byte3 = abyte0[k6];
                    k6++;
                    if(class2_1 != null)
                    {
                        String s2 = Class16.method374(Class17.method399(abyte0, k6, byte3));
                        boolean flag3 = false;
                        for(int j34 = 0; j34 < super.anInt627; j34++)
                            if(super.aLongArray628[j34] == class2_1.aLong145)
                                flag3 = true;

                        if(!flag3)
                        {
                            class2_1.anInt161 = 150;
                            class2_1.aString160 = s2;
                            method118(class2_1.aString146 + ": " + class2_1.aString160, 2);
                        }
                    }
                    k6 += byte3;
                    continue;
                }
                if(byte2 == 2)
                {
                    int j24 = Class15.method353(abyte0[k6]);
                    k6++;
                    int i29 = Class15.method353(abyte0[k6]);
                    k6++;
                    int k32 = Class15.method353(abyte0[k6]);
                    k6++;
                    if(class2_1 == null)
                        continue;
                    class2_1.anInt164 = j24;
                    class2_1.anInt165 = i29;
                    class2_1.anInt166 = k32;
                    class2_1.anInt167 = 200;
                    if(class2_1 == aClass2_975)
                    {
                        anIntArray728[3] = i29;
                        anIntArray825[3] = k32;
                        aBoolean908 = false;
                        aBoolean745 = false;
                    }
                    continue;
                }
                if(byte2 == 3)
                {
                    int k24 = Class15.method354(abyte0, k6);
                    k6 += 2;
                    int j29 = Class15.method354(abyte0, k6);
                    k6 += 2;
                    if(class2_1 != null)
                    {
                        class2_1.anInt173 = k24;
                        class2_1.anInt175 = j29;
                        class2_1.anInt174 = -1;
                        class2_1.anInt176 = anInt897;
                    }
                    continue;
                }
                if(byte2 == 4)
                {
                    int l24 = Class15.method354(abyte0, k6);
                    k6 += 2;
                    int k29 = Class15.method354(abyte0, k6);
                    k6 += 2;
                    if(class2_1 != null)
                    {
                        class2_1.anInt173 = l24;
                        class2_1.anInt174 = k29;
                        class2_1.anInt175 = -1;
                        class2_1.anInt176 = anInt897;
                    }
                    continue;
                }
                if(byte2 == 5)
                {
                    if(class2_1 != null)
                    {
                        class2_1.anInt148 = Class15.method354(abyte0, k6);
                        k6 += 2;
                        class2_1.aLong145 = Class15.method356(abyte0, k6);
                        k6 += 8;
                        class2_1.aString146 = Class15.method363(class2_1.aLong145);
                        int i25 = Class15.method353(abyte0[k6]);
                        k6++;
                        for(int l29 = 0; l29 < i25; l29++)
                        {
                            class2_1.anIntArray159[l29] = Class15.method353(abyte0[k6]);
                            k6++;
                        }

                        for(int i30 = i25; i30 < 12; i30++)
                            class2_1.anIntArray159[i30] = 0;

                        class2_1.anInt169 = abyte0[k6++] & 0xff;
                        class2_1.anInt170 = abyte0[k6++] & 0xff;
                        class2_1.anInt171 = abyte0[k6++] & 0xff;
                        class2_1.anInt172 = abyte0[k6++] & 0xff;
                        class2_1.anInt168 = abyte0[k6++] & 0xff;
                        class2_1.anInt179 = abyte0[k6++] & 0xff;
                    } else
                    {
                        k6 += 14;
                        int j25 = Class15.method353(abyte0[k6]);
                        k6 += j25 + 1;
                    }
                    continue;
                }
                if(byte2 != 6)
                    continue;
                byte byte4 = abyte0[k6];
                k6++;
                if(class2_1 != null)
                {
                    String s3 = Class17.method399(abyte0, k6, byte4);
                    class2_1.anInt161 = 150;
                    class2_1.aString160 = s3;
                    if(class2_1 == aClass2_975)
                        method118(class2_1.aString146 + ": " + class2_1.aString160, 5);
                }
                k6 += byte4;
            }

            return;
        }
        if(i == 29)
        {
            int j2 = 1;
            do
            {
                if(j2 >= j)
                    break;
                if(Class15.method353(abyte0[j2]) == 255)
                {
                    int l6 = 0;
                    int i11 = anInt976 + abyte0[j2 + 1] >> 3;
                    int l14 = anInt977 + abyte0[j2 + 2] >> 3;
                    j2 += 3;
                    for(int i18 = 0; i18 < anInt855; i18++)
                    {
                        int l20 = (anIntArray747[i18] >> 3) - i11;
                        int k25 = (anIntArray748[i18] >> 3) - l14;
                        if(l20 != 0 || k25 != 0)
                        {
                            if(i18 != l6)
                            {
                                aClass5Array781[l6] = aClass5Array781[i18];
                                aClass5Array781[l6].anInt257 = l6 + 10000;
                                anIntArray747[l6] = anIntArray747[i18];
                                anIntArray748[l6] = anIntArray748[i18];
                                anIntArray740[l6] = anIntArray740[i18];
                                anIntArray741[l6] = anIntArray741[i18];
                            }
                            l6++;
                        } else
                        {
                            aClass10_739.method270(aClass5Array781[i18]);
                            aClass19_883.method427(anIntArray747[i18], anIntArray748[i18], anIntArray740[i18], anIntArray741[i18]);
                        }
                    }

                    anInt855 = l6;
                } else
                {
                    int i7 = Class15.method354(abyte0, j2);
                    j2 += 2;
                    int j11 = anInt976 + abyte0[j2++];
                    int i15 = anInt977 + abyte0[j2++];
                    byte byte1 = abyte0[j2++];
                    int i21 = 0;
                    for(int l25 = 0; l25 < anInt855; l25++)
                        if(anIntArray747[l25] != j11 || anIntArray748[l25] != i15 || anIntArray740[l25] != byte1)
                        {
                            if(l25 != i21)
                            {
                                aClass5Array781[i21] = aClass5Array781[l25];
                                aClass5Array781[i21].anInt257 = i21 + 10000;
                                anIntArray747[i21] = anIntArray747[l25];
                                anIntArray748[i21] = anIntArray748[l25];
                                anIntArray740[i21] = anIntArray740[l25];
                                anIntArray741[i21] = anIntArray741[l25];
                            }
                            i21++;
                        } else
                        {
                            aClass10_739.method270(aClass5Array781[l25]);
                            aClass19_883.method427(anIntArray747[l25], anIntArray748[l25], anIntArray740[l25], anIntArray741[l25]);
                        }

                    anInt855 = i21;
                    if(i7 != 65535)
                    {
                        aClass19_883.method415(j11, i15, byte1, i7);
                        Class5 class5 = method106(j11, i15, byte1, i7, anInt855);
                        aClass5Array781[anInt855] = class5;
                        anIntArray747[anInt855] = j11;
                        anIntArray748[anInt855] = i15;
                        anIntArray741[anInt855] = i7;
                        anIntArray740[anInt855++] = byte1;
                    }
                }
            } while(true);
            return;
        }
        if(i == 152)
        {
            anInt906 = anInt905;
            anInt905 = 0;
            for(int k2 = 0; k2 < anInt906; k2++)
                aClass2Array822[k2] = aClass2Array768[k2];

            int l2 = 8;
            int j7 = Class15.method359(abyte0, l2, 8);
            l2 += 8;
            for(int k11 = 0; k11 < j7; k11++)
            {
                Class2 class2 = aClass2Array822[k11];
                int j18 = Class15.method359(abyte0, l2, 1);
                l2++;
                if(j18 != 0)
                {
                    int j21 = Class15.method359(abyte0, l2, 1);
                    l2++;
                    if(j21 == 0)
                    {
                        int i26 = Class15.method359(abyte0, l2, 3);
                        l2 += 3;
                        int j30 = class2.anInt156;
                        int l32 = class2.anIntArray157[j30];
                        int k34 = class2.anIntArray158[j30];
                        if(i26 == 2 || i26 == 1 || i26 == 3)
                            l32 += anInt946;
                        if(i26 == 6 || i26 == 5 || i26 == 7)
                            l32 -= anInt946;
                        if(i26 == 4 || i26 == 3 || i26 == 5)
                            k34 += anInt946;
                        if(i26 == 0 || i26 == 1 || i26 == 7)
                            k34 -= anInt946;
                        class2.anInt154 = i26;
                        class2.anInt156 = j30 = (j30 + 1) % 10;
                        class2.anIntArray157[j30] = l32;
                        class2.anIntArray158[j30] = k34;
                    } else
                    {
                        int j26 = Class15.method359(abyte0, l2, 4);
                        if((j26 & 0xc) == 12)
                        {
                            l2 += 2;
                            continue;
                        }
                        class2.anInt154 = Class15.method359(abyte0, l2, 4);
                        l2 += 4;
                    }
                }
                aClass2Array768[anInt905++] = class2;
            }

            while(l2 + 34 < j * 8) 
            {
                int l11 = Class15.method359(abyte0, l2, 12);
                l2 += 12;
                int j15 = Class15.method359(abyte0, l2, 5);
                l2 += 5;
                if(j15 > 15)
                    j15 -= 32;
                int k18 = Class15.method359(abyte0, l2, 5);
                l2 += 5;
                if(k18 > 15)
                    k18 -= 32;
                int k21 = Class15.method359(abyte0, l2, 4);
                l2 += 4;
                int k26 = (anInt976 + j15) * anInt946 + 64;
                int k30 = (anInt977 + k18) * anInt946 + 64;
                int i33 = Class15.method359(abyte0, l2, 10);
                l2 += 10;
                if(i33 >= Class1.anInt122)
                    i33 = 24;
                method107(l11, k26, k30, k21, i33);
            }
            return;
        }
        if(i == 159)
        {
            int i3 = Class15.method354(abyte0, 1);
            int k7 = 3;
            for(int i12 = 0; i12 < i3; i12++)
            {
                int k15 = Class15.method354(abyte0, k7);
                k7 += 2;
                Class2 class2_2 = aClass2Array957[k15];
                int l21 = Class15.method353(abyte0[k7]);
                k7++;
                if(l21 == 1)
                {
                    int l26 = Class15.method354(abyte0, k7);
                    k7 += 2;
                    byte byte5 = abyte0[k7];
                    k7++;
                    if(class2_2 != null)
                    {
                        String s4 = Class17.method399(abyte0, k7, byte5);
                        class2_2.anInt161 = 150;
                        class2_2.aString160 = s4;
                        if(l26 == aClass2_975.anInt147)
                            method118("@yel@" + Class1.aStringArray127[class2_2.anInt151] + ": " + class2_2.aString160, 5);
                    }
                    k7 += byte5;
                    continue;
                }
                if(l21 != 2)
                    continue;
                int i27 = Class15.method353(abyte0[k7]);
                k7++;
                int l30 = Class15.method353(abyte0[k7]);
                k7++;
                int j33 = Class15.method353(abyte0[k7]);
                k7++;
                if(class2_2 != null)
                {
                    class2_2.anInt164 = i27;
                    class2_2.anInt165 = l30;
                    class2_2.anInt166 = j33;
                    class2_2.anInt167 = 200;
                }
            }

            return;
        }
        if(i == 55)
        {
            aBoolean852 = true;
            int j3 = Class15.method353(abyte0[1]);
            anInt929 = j3;
            int l7 = 2;
            for(int j12 = 0; j12 < j3; j12++)
            {
                int l15 = Class15.method353(abyte0[l7]);
                l7++;
                aStringArray913[j12] = new String(abyte0, l7, l15);
                l7 += l15;
            }

            return;
        }
        if(i == 93)
        {
            aBoolean852 = false;
            return;
        }
        if(i == 167)
        {
            aBoolean717 = true;
            anInt978 = Class15.method354(abyte0, 1);
            anInt806 = Class15.method354(abyte0, 3);
            anInt807 = Class15.method354(abyte0, 5);
            anInt785 = Class15.method354(abyte0, 7);
            anInt808 = Class15.method354(abyte0, 9);
            anInt807 -= anInt785 * anInt808;
            return;
        }
        if(i == 205)
        {
            int k3 = 1;
            for(int i8 = 0; i8 < 18; i8++)
                anIntArray728[i8] = Class15.method353(abyte0[k3++]);

            for(int j8 = 0; j8 < 18; j8++)
                anIntArray825[j8] = Class15.method353(abyte0[k3++]);

            for(int k8 = 0; k8 < 18; k8++)
            {
                anIntArray712[k8] = Class15.method355(abyte0, k3);
                k3 += 4;
            }

            anInt996 = Class15.method353(abyte0[k3++]);
            return;
        }
        if(i == 79)
        {
            for(int l3 = 0; l3 < 5; l3++)
                anIntArray797[l3] = Class15.method353(abyte0[1 + l3]);

            return;
        }
        if(i == 72)
        {
            anInt993 = 250;
            return;
        }
        if(i == 246)
        {
            int i4 = (j - 1) / 4;
            for(int l8 = 0; l8 < i4; l8++)
            {
                int k12 = anInt976 + Class15.method357(abyte0, 1 + l8 * 4) >> 3;
                int i16 = anInt977 + Class15.method357(abyte0, 3 + l8 * 4) >> 3;
                int l18 = 0;
                for(int i22 = 0; i22 < anInt823; i22++)
                {
                    int j27 = (anIntArray770[i22] >> 3) - k12;
                    int i31 = (anIntArray771[i22] >> 3) - i16;
                    if(j27 == 0 && i31 == 0)
                        continue;
                    if(i22 != l18)
                    {
                        anIntArray770[l18] = anIntArray770[i22];
                        anIntArray771[l18] = anIntArray771[i22];
                        anIntArray772[l18] = anIntArray772[i22];
                        anIntArray773[l18] = anIntArray773[i22];
                    }
                    l18++;
                }

                anInt823 = l18;
                l18 = 0;
                for(int j22 = 0; j22 < anInt796; j22++)
                {
                    int k27 = (anIntArray760[j22] >> 3) - k12;
                    int j31 = (anIntArray761[j22] >> 3) - i16;
                    if(k27 != 0 || j31 != 0)
                    {
                        if(j22 != l18)
                        {
                            aClass5Array814[l18] = aClass5Array814[j22];
                            aClass5Array814[l18].anInt257 = l18;
                            anIntArray760[l18] = anIntArray760[j22];
                            anIntArray761[l18] = anIntArray761[j22];
                            anIntArray762[l18] = anIntArray762[j22];
                            anIntArray763[l18] = anIntArray763[j22];
                        }
                        l18++;
                    } else
                    {
                        aClass10_739.method270(aClass5Array814[j22]);
                        aClass19_883.method434(anIntArray760[j22], anIntArray761[j22], anIntArray762[j22]);
                    }
                }

                anInt796 = l18;
                l18 = 0;
                for(int k22 = 0; k22 < anInt855; k22++)
                {
                    int l27 = (anIntArray747[k22] >> 3) - k12;
                    int k31 = (anIntArray748[k22] >> 3) - i16;
                    if(l27 != 0 || k31 != 0)
                    {
                        if(k22 != l18)
                        {
                            aClass5Array781[l18] = aClass5Array781[k22];
                            aClass5Array781[l18].anInt257 = l18 + 10000;
                            anIntArray747[l18] = anIntArray747[k22];
                            anIntArray748[l18] = anIntArray748[k22];
                            anIntArray740[l18] = anIntArray740[k22];
                            anIntArray741[l18] = anIntArray741[k22];
                        }
                        l18++;
                    } else
                    {
                        aClass10_739.method270(aClass5Array781[k22]);
                        aClass19_883.method427(anIntArray747[k22], anIntArray748[k22], anIntArray740[k22], anIntArray741[k22]);
                    }
                }

                anInt855 = l18;
            }

            return;
        }
        if(i == 237)
        {
            aBoolean992 = true;
            return;
        }
        if(i == 240)
        {
            int j4 = Class15.method354(abyte0, 1);
            if(aClass2Array891[j4] != null)
                aString682 = aClass2Array891[j4].aString146;
            aBoolean856 = true;
            aBoolean944 = false;
            aBoolean945 = false;
            anInt969 = 0;
            anInt886 = 0;
            return;
        }
        if(i == 3)
        {
            aBoolean856 = false;
            aBoolean673 = false;
            return;
        }
        if(i == 245)
        {
            anInt886 = abyte0[1] & 0xff;
            int k4 = 2;
            for(int i9 = 0; i9 < anInt886; i9++)
            {
                anIntArray887[i9] = Class15.method354(abyte0, k4);
                k4 += 2;
                anIntArray888[i9] = Class15.method355(abyte0, k4);
                k4 += 4;
            }

            aBoolean944 = false;
            aBoolean945 = false;
            return;
        }
        if(i != 207)
            break MISSING_BLOCK_LABEL_5704;
        byte byte0 = abyte0[1];
        if(byte0 == 1)
        {
            aBoolean944 = true;
            return;
        }
        int l4;
        String s;
        int j9;
        boolean flag;
        int l12;
        int j16;
        int i19;
        boolean flag2;
        int i28;
        try
        {
            aBoolean944 = false;
            return;
        }
        catch(RuntimeException runtimeexception)
        {
            if(anInt933 < 3)
            {
                super.aClass14_Sub1_620.method331(46);
                super.aClass14_Sub1_620.method347(runtimeexception.toString());
                super.aClass14_Sub1_620.method346();
                super.aClass14_Sub1_620.method331(46);
                super.aClass14_Sub1_620.method347("p-type:" + i + " p-size:" + j);
                super.aClass14_Sub1_620.method346();
                super.aClass14_Sub1_620.method331(46);
                super.aClass14_Sub1_620.method347("rx:" + anInt976 + " ry:" + anInt977 + " num3l:" + anInt796);
                super.aClass14_Sub1_620.method346();
                String s1 = "";
                for(int i13 = 0; i13 < 80 && i13 < j; i13++)
                    s1 = s1 + abyte0[i13] + " ";

                super.aClass14_Sub1_620.method331(46);
                super.aClass14_Sub1_620.method347(s1);
                super.aClass14_Sub1_620.method346();
                anInt933++;
            }
        }
        break MISSING_BLOCK_LABEL_8297;
        if(i == 153)
        {
            aBoolean727 = true;
            l4 = 1;
            j9 = abyte0[l4++] & 0xff;
            l12 = abyte0[l4++];
            anInt899 = abyte0[l4++] & 0xff;
            anInt900 = abyte0[l4++] & 0xff;
            for(j16 = 0; j16 < 40; j16++)
                anIntArray736[j16] = -1;

            for(j16 = 0; j16 < j9; j16++)
            {
                anIntArray736[j16] = Class15.method354(abyte0, l4);
                l4 += 2;
                anIntArray737[j16] = Class15.method354(abyte0, l4);
                l4 += 2;
                anIntArray738[j16] = abyte0[l4++];
            }

            if(l12 == 1)
            {
                j16 = 39;
                for(i19 = 0; i19 < anInt708 && j16 >= j9; i19++)
                {
                    flag2 = false;
                    i28 = 0;
                    do
                    {
                        if(i28 >= 40)
                            break;
                        if(anIntArray736[i28] == anIntArray709[i19])
                        {
                            flag2 = true;
                            break;
                        }
                        i28++;
                    } while(true);
                    if(anIntArray709[i19] == 10)
                        flag2 = true;
                    if(!flag2)
                    {
                        anIntArray736[j16] = anIntArray709[i19] & 0x7fff;
                        anIntArray737[j16] = 0;
                        anIntArray738[j16] = 0;
                        j16--;
                    }
                }

            }
            if(anInt903 >= 0 && anInt903 < 40 && anIntArray736[anInt903] != anInt904)
            {
                anInt903 = -1;
                anInt904 = -2;
            }
            return;
        }
        if(i == 243)
        {
            aBoolean727 = false;
            return;
        }
        if(i != 118)
            break MISSING_BLOCK_LABEL_6083;
        l4 = abyte0[1];
        if(l4 == 1)
        {
            aBoolean945 = true;
            return;
        }
        aBoolean945 = false;
        return;
        if(i == 105)
        {
            aBoolean675 = Class15.method353(abyte0[1]) == 1;
            aBoolean767 = Class15.method353(abyte0[2]) == 1;
            aBoolean853 = Class15.method353(abyte0[3]) == 1;
            return;
        }
        if(i == 140)
        {
            for(l4 = 0; l4 < j - 1; l4++)
            {
                flag = abyte0[l4 + 1] == 1;
                if(!aBooleanArray679[l4] && flag)
                    method97("prayeron");
                if(aBooleanArray679[l4] && !flag)
                    method97("prayeroff");
                aBooleanArray679[l4] = flag;
            }

            return;
        }
        if(i == 164)
        {
            for(l4 = 0; l4 < 50; l4++)
                aBooleanArray716[l4] = abyte0[l4 + 1] == 1;

            return;
        }
        if(i == 120)
        {
            aBoolean879 = true;
            l4 = 1;
            anInt936 = abyte0[l4++] & 0xff;
            anInt916 = abyte0[l4++] & 0xff;
            for(flag = false; flag < anInt936; flag++)
            {
                anIntArray816[flag] = Class15.method354(abyte0, l4);
                l4 += 2;
                anIntArray817[flag] = Class15.method358(abyte0, l4);
                if(anIntArray817[flag] >= 128)
                    l4 += 4;
                else
                    l4++;
            }

            method72();
            return;
        }
        if(i == 226)
        {
            aBoolean879 = false;
            return;
        }
        if(i == 108)
        {
            l4 = abyte0[1] & 0xff;
            anIntArray712[l4] = Class15.method355(abyte0, 2);
            return;
        }
        if(i == 23)
        {
            l4 = Class15.method354(abyte0, 1);
            if(aClass2Array891[l4] != null)
                aString824 = aClass2Array891[l4].aString146;
            aBoolean917 = true;
            anInt910 = 0;
            anInt959 = 0;
            aBoolean668 = false;
            aBoolean669 = false;
            aBoolean718 = false;
            aBoolean719 = false;
            aBoolean720 = false;
            aBoolean721 = false;
            return;
        }
        if(i == 10)
        {
            aBoolean917 = false;
            aBoolean801 = false;
            return;
        }
        if(i == 13)
        {
            aBoolean673 = true;
            aBoolean674 = false;
            aBoolean856 = false;
            l4 = 1;
            aLong847 = Class15.method356(abyte0, l4);
            l4 += 8;
            anInt691 = abyte0[l4++] & 0xff;
            for(flag = false; flag < anInt691; flag++)
            {
                anIntArray692[flag] = Class15.method354(abyte0, l4);
                l4 += 2;
                anIntArray693[flag] = Class15.method355(abyte0, l4);
                l4 += 4;
            }

            anInt836 = abyte0[l4++] & 0xff;
            for(flag = false; flag < anInt836; flag++)
            {
                anIntArray837[flag] = Class15.method354(abyte0, l4);
                l4 += 2;
                anIntArray838[flag] = Class15.method355(abyte0, l4);
                l4 += 4;
            }

            return;
        }
        if(i == 75)
        {
            anInt959 = abyte0[1] & 0xff;
            l4 = 2;
            for(flag = false; flag < anInt959; flag++)
            {
                anIntArray960[flag] = Class15.method354(abyte0, l4);
                l4 += 2;
                anIntArray961[flag] = Class15.method355(abyte0, l4);
                l4 += 4;
            }

            aBoolean668 = false;
            aBoolean669 = false;
            return;
        }
        if(i == 119)
        {
            if(abyte0[1] == 1)
                aBoolean718 = true;
            else
                aBoolean718 = false;
            if(abyte0[2] == 1)
                aBoolean719 = true;
            else
                aBoolean719 = false;
            if(abyte0[3] == 1)
                aBoolean720 = true;
            else
                aBoolean720 = false;
            if(abyte0[4] == 1)
                aBoolean721 = true;
            else
                aBoolean721 = false;
            aBoolean668 = false;
            aBoolean669 = false;
            return;
        }
        if(i == 172)
        {
            l4 = 1;
            flag = abyte0[l4++] & 0xff;
            l12 = Class15.method354(abyte0, l4);
            l4 += 2;
            j16 = Class15.method358(abyte0, l4);
            if(j16 >= 128)
                l4 += 4;
            else
                l4++;
            if(j16 == 0)
            {
                anInt936--;
                for(i19 = ((flag) ? 1 : 0); i19 < anInt936; i19++)
                {
                    anIntArray816[i19] = anIntArray816[i19 + 1];
                    anIntArray817[i19] = anIntArray817[i19 + 1];
                }

            } else
            {
                anIntArray816[flag] = l12;
                anIntArray817[flag] = j16;
                if(flag >= anInt936)
                    anInt936 = flag + 1;
            }
            method72();
            return;
        }
        if(i == 242)
        {
            l4 = 1;
            flag = true;
            l12 = abyte0[l4++] & 0xff;
            j16 = Class15.method354(abyte0, l4);
            l4 += 2;
            if(Class1.anIntArray55[j16 & 0x7fff] == 0)
            {
                flag = Class15.method358(abyte0, l4);
                if(flag >= 128)
                    l4 += 4;
                else
                    l4++;
            }
            anIntArray709[l12] = j16 & 0x7fff;
            anIntArray711[l12] = j16 / 32768;
            anIntArray710[l12] = ((flag) ? 1 : 0);
            if(l12 >= anInt708)
                anInt708 = l12 + 1;
            return;
        }
        if(i == 104)
        {
            l4 = abyte0[1] & 0xff;
            anInt708--;
            for(flag = l4; flag < anInt708; flag++)
            {
                anIntArray709[flag] = anIntArray709[flag + 1];
                anIntArray710[flag] = anIntArray710[flag + 1];
                anIntArray711[flag] = anIntArray711[flag + 1];
            }

            return;
        }
        if(i == 99)
        {
            l4 = 1;
            flag = abyte0[l4++] & 0xff;
            anIntArray728[flag] = Class15.method353(abyte0[l4++]);
            anIntArray825[flag] = Class15.method353(abyte0[l4++]);
            anIntArray712[flag] = Class15.method355(abyte0, l4);
            l4 += 4;
            return;
        }
        if(i != 210)
            break MISSING_BLOCK_LABEL_7381;
        l4 = abyte0[1];
        if(l4 == 1)
        {
            aBoolean668 = true;
            return;
        }
        aBoolean668 = false;
        return;
        if(i != 235)
            break MISSING_BLOCK_LABEL_7411;
        l4 = abyte0[1];
        if(l4 == 1)
        {
            aBoolean669 = true;
            return;
        }
        aBoolean669 = false;
        return;
        if(i == 255)
        {
            aBoolean801 = true;
            aBoolean802 = false;
            aBoolean917 = false;
            l4 = 1;
            aLong907 = Class15.method356(abyte0, l4);
            l4 += 8;
            anInt786 = abyte0[l4++] & 0xff;
            for(flag = false; flag < anInt786; flag++)
            {
                anIntArray787[flag] = Class15.method354(abyte0, l4);
                l4 += 2;
                anIntArray788[flag] = Class15.method355(abyte0, l4);
                l4 += 4;
            }

            anInt663 = abyte0[l4++] & 0xff;
            for(flag = false; flag < anInt663; flag++)
            {
                anIntArray664[flag] = Class15.method354(abyte0, l4);
                l4 += 2;
                anIntArray665[flag] = Class15.method355(abyte0, l4);
                l4 += 4;
            }

            anInt988 = abyte0[l4++] & 0xff;
            anInt989 = abyte0[l4++] & 0xff;
            anInt990 = abyte0[l4++] & 0xff;
            anInt991 = abyte0[l4++] & 0xff;
            return;
        }
        if(i == 250)
        {
            s = new String(abyte0, 1, j - 1);
            method97(s);
            return;
        }
        if(i == 252)
        {
            if(anInt833 < 50)
            {
                s = abyte0[1] & 0xff;
                flag = abyte0[2] + anInt976;
                l12 = abyte0[3] + anInt977;
                anIntArray730[anInt833] = s;
                anIntArray972[anInt833] = 0;
                anIntArray881[anInt833] = ((flag) ? 1 : 0);
                anIntArray934[anInt833] = l12;
                anInt833++;
            }
            return;
        }
        if(i == 176)
        {
            if(!aBoolean849)
            {
                anInt782 = Class15.method355(abyte0, 1);
                anInt898 = Class15.method354(abyte0, 5);
                anInt685 = abyte0[7] & 0xff;
                anInt924 = Class15.method354(abyte0, 8);
                aBoolean908 = true;
                aBoolean849 = true;
                aString894 = null;
            }
            return;
        }
        if(i == 146)
        {
            aString681 = new String(abyte0, 1, j - 1);
            aBoolean745 = true;
            aBoolean680 = false;
            return;
        }
        if(i == 138)
        {
            aString681 = new String(abyte0, 1, j - 1);
            aBoolean745 = true;
            aBoolean680 = true;
            return;
        }
        if(i == 84)
        {
            anInt892 = Class15.method354(abyte0, 1);
            return;
        }
        if(i == 51)
        {
            if(!aBoolean870)
                anInt893 = anInt892;
            aBoolean870 = true;
            super.aString40 = "";
            super.aString41 = "";
            aClass6_Sub1_724.method226(anInt952 + 1, abyte0);
            aString846 = null;
            return;
        }
        if(i == 21)
        {
            anInt893 = Class15.method354(abyte0, 1);
            return;
        }
        if(i == 125)
        {
            aBoolean870 = false;
            return;
        }
        if(i == 127)
        {
            aString846 = "Incorrect - Please wait...";
            return;
        }
        if(i == 113)
        {
            anInt749 = Class15.method354(abyte0, 1) * 32;
            return;
        }
    }

    protected final void method42(String s)
    {
        if(s.startsWith("@bor@"))
        {
            method118(s, 4);
            return;
        }
        if(s.startsWith("@que@"))
        {
            method118("@whi@" + s, 5);
            return;
        }
        if(s.startsWith("@pri@"))
        {
            method118(s, 6);
            return;
        } else
        {
            method118(s, 3);
            return;
        }
    }

    protected final int method44()
    {
        return Class8.anInt371;
    }

    public static final void main(String args[])
    {
        mudclient mudclient1 = new mudclient();
        mudclient1.aBoolean979 = false;
        if(args.length > 0 && args[0].equals("members"))
            mudclient1.aBoolean914 = true;
        if(args.length > 1)
            mudclient1.aString616 = args[1];
        if(args.length > 2)
            mudclient1.anInt617 = Integer.parseInt(args[2]);
        mudclient1.method6(mudclient1.anInt676, mudclient1.anInt677 + 11, "Rune-V", false);
        mudclient1.anInt32 = 10;
    }

    private final void method46()
    {
        int i = Class1.anInt144;
        if(anInt813 != 0)
        {
            int j = 0;
            do
            {
                if(j >= anInt929)
                    break;
                if(super.anInt33 < aClass6_Sub1_724.method263(aStringArray913[j], 1) && super.anInt34 > j * 12 && super.anInt34 < 12 + j * 12)
                {
                    super.aClass14_Sub1_620.method331(203);
                    super.aClass14_Sub1_620.method348(j);
                    super.aClass14_Sub1_620.method346();
                    break;
                }
                j++;
            } while(true);
            anInt813 = 0;
            aBoolean852 = false;
            return;
        }
        for(int k = 0; k < anInt929; k++)
        {
            int l = 65535;
            if(super.anInt33 < aClass6_Sub1_724.method263(aStringArray913[k], 1) && super.anInt34 > k * 12 && super.anInt34 < 12 + k * 12)
                l = 0xff0000;
            aClass6_Sub1_724.method257(aStringArray913[k], 6, 12 + k * 12, 1, l);
        }

    }

    private final void method47()
    {
        if(super.aString41.length() > 0)
        {
            String s = super.aString41.trim();
            super.aString40 = "";
            super.aString41 = "";
            if(s.length() > 0)
            {
                long l = Class15.method362(s);
                super.aClass14_Sub1_620.method331(180);
                super.aClass14_Sub1_620.method342(l);
                super.aClass14_Sub1_620.method348(anInt863);
                super.aClass14_Sub1_620.method348(aBoolean810 ? 1 : 0);
                super.aClass14_Sub1_620.method346();
            }
            anInt986 = 0;
            return;
        }
        aClass6_Sub1_724.method216(56, 130, 400, 100, 0);
        aClass6_Sub1_724.method217(56, 130, 400, 100, 0xffffff);
        int i = 160;
        aClass6_Sub1_724.method255("Now type the name of the offending player, and press enter", 256, i, 1, 0xffff00);
        i += 18;
        aClass6_Sub1_724.method255("Name: " + super.aString40 + "*", 256, i, 4, 0xffffff);
        if(super.anInt637 > 0)
        {
            i = 207;
            if(aBoolean810)
                aClass6_Sub1_724.method255("Moderator option: Mute player for 48 hours: <ON>", 256, i, 1, 0xff8000);
            else
                aClass6_Sub1_724.method255("Moderator option: Mute player for 48 hours: <OFF>", 256, i, 1, 0xffffff);
            if(super.anInt33 > 106 && super.anInt33 < 406 && super.anInt34 > i - 13 && super.anInt34 < i + 2 && anInt813 == 1)
            {
                anInt813 = 0;
                aBoolean810 = !aBoolean810;
            }
        }
        i = 222;
        int j = 0xffffff;
        if(super.anInt33 > 196 && super.anInt33 < 316 && super.anInt34 > i - 13 && super.anInt34 < i + 2)
        {
            j = 0xffff00;
            if(anInt813 == 1)
            {
                anInt813 = 0;
                anInt986 = 0;
            }
        }
        aClass6_Sub1_724.method255("Click here to cancel", 256, i, 1, j);
        if(anInt813 == 1 && (super.anInt33 < 56 || super.anInt33 > 456 || super.anInt34 < 130 || super.anInt34 > 230))
        {
            anInt813 = 0;
            anInt986 = 0;
        }
    }

    private static final String method48(int i)
    {
        int j = Class1.anInt144;
        String s = String.valueOf(i);
        for(int k = s.length() - 3; k > 0; k -= 3)
            s = s.substring(0, k) + "," + s.substring(k);

        if(s.length() > 8)
            s = "@gre@" + s.substring(0, s.length() - 8) + " million @whi@(" + s + ")";
        else
        if(s.length() > 4)
            s = "@cya@" + s.substring(0, s.length() - 4) + "K @whi@(" + s + ")";
        return s;
    }

    private final void method49()
    {
        char c = '\u0190';
        char c1 = 'd';
        if(aBoolean680)
        {
            c1 = '\u01C2';
            c1 = '\u012C';
        }
        aClass6_Sub1_724.method216(256 - c / 2, 167 - c1 / 2, c, c1, 0);
        aClass6_Sub1_724.method217(256 - c / 2, 167 - c1 / 2, c, c1, 0xffffff);
        aClass6_Sub1_724.method256(aString681, 256, (167 - c1 / 2) + 20, 1, 0xffffff, c - 40);
        int i = 157 + c1 / 2;
        int j = 0xffffff;
        if(super.anInt34 > i - 12 && super.anInt34 <= i && super.anInt33 > 106 && super.anInt33 < 406)
            j = 0xff0000;
        aClass6_Sub1_724.method255("Click here to close window", 256, i, 1, j);
        if(anInt813 == 1)
        {
            if(j == 0xff0000)
                aBoolean745 = false;
            if((super.anInt33 < 256 - c / 2 || super.anInt33 > 256 + c / 2) && (super.anInt34 < 167 - c1 / 2 || super.anInt34 > 167 + c1 / 2))
                aBoolean745 = false;
        }
        anInt813 = 0;
    }

    private final void method50()
    {
        anInt947 = 0;
        anInt690 = 0;
        aString734 = "";
        aString735 = "";
        aString861 = "Please enter a username:";
        aString862 = "*" + aString734 + "*";
        anInt742 = 0;
        anInt905 = 0;
    }

    private final void method51()
    {
        int i = Class1.anInt144;
        if(anInt813 != 0 && anInt819 == 0)
            anInt819 = 1;
        if(anInt819 > 0)
        {
            int j = super.anInt33 - 22;
            int k = super.anInt34 - 36;
            if(j >= 0 && k >= 0 && j < 468 && k < 262)
            {
                if(j > 216 && k > 30 && j < 462 && k < 235)
                {
                    int l = (j - 217) / 49 + ((k - 31) / 34) * 5;
                    if(l >= 0 && l < anInt708)
                    {
                        boolean flag = false;
                        int i2 = 0;
                        int k4 = anIntArray709[l];
label0:
                        for(int l5 = 0; l5 < anInt969; l5++)
                        {
                            if(anIntArray970[l5] != k4)
                                continue;
                            if(Class1.anIntArray55[k4] == 0)
                            {
                                int i7 = 0;
                                do
                                {
                                    if(i7 >= anInt819)
                                        continue label0;
                                    if(anIntArray971[l5] < anIntArray710[l])
                                        anIntArray971[l5]++;
                                    flag = true;
                                    i7++;
                                } while(true);
                            }
                            i2++;
                        }

                        if(method58(k4) <= i2)
                            flag = true;
                        if(Class1.anIntArray59[k4] == 1)
                        {
                            method118("This object cannot be traded with other players", 3);
                            flag = true;
                        }
                        if(!flag && anInt969 < 12)
                        {
                            anIntArray970[anInt969] = k4;
                            anIntArray971[anInt969] = 1;
                            anInt969++;
                            flag = true;
                        }
                        if(flag)
                        {
                            super.aClass14_Sub1_620.method331(116);
                            super.aClass14_Sub1_620.method348(anInt969);
                            for(int i6 = 0; i6 < anInt969; i6++)
                            {
                                super.aClass14_Sub1_620.method343(anIntArray970[i6]);
                                super.aClass14_Sub1_620.method332(anIntArray971[i6]);
                            }

                            super.aClass14_Sub1_620.method346();
                            aBoolean944 = false;
                            aBoolean945 = false;
                        }
                    }
                }
                if(j > 8 && k > 30 && j < 205 && k < 133)
                {
                    int i1 = (j - 9) / 49 + ((k - 31) / 34) * 4;
                    if(i1 >= 0 && i1 < anInt969)
                    {
                        int k1 = anIntArray970[i1];
                        int j2 = 0;
                        do
                        {
                            if(j2 >= anInt819)
                                break;
                            if(Class1.anIntArray55[k1] == 0 && anIntArray971[i1] > 1)
                            {
                                anIntArray971[i1]--;
                            } else
                            {
                                anInt969--;
                                anInt818 = 0;
                                for(int l4 = i1; l4 < anInt969; l4++)
                                {
                                    anIntArray970[l4] = anIntArray970[l4 + 1];
                                    anIntArray971[l4] = anIntArray971[l4 + 1];
                                }

                                break;
                            }
                            j2++;
                        } while(true);
                        super.aClass14_Sub1_620.method331(116);
                        super.aClass14_Sub1_620.method348(anInt969);
                        for(int k2 = 0; k2 < anInt969; k2++)
                        {
                            super.aClass14_Sub1_620.method343(anIntArray970[k2]);
                            super.aClass14_Sub1_620.method332(anIntArray971[k2]);
                        }

                        super.aClass14_Sub1_620.method346();
                        aBoolean944 = false;
                        aBoolean945 = false;
                    }
                }
                if(j >= 217 && k >= 238 && j <= 286 && k <= 259)
                {
                    aBoolean945 = true;
                    super.aClass14_Sub1_620.method331(38);
                    super.aClass14_Sub1_620.method346();
                }
                if(j >= 394 && k >= 238 && j < 463 && k < 259)
                {
                    aBoolean856 = false;
                    super.aClass14_Sub1_620.method331(178);
                    super.aClass14_Sub1_620.method346();
                }
            } else
            if(anInt813 != 0)
            {
                aBoolean856 = false;
                super.aClass14_Sub1_620.method331(178);
                super.aClass14_Sub1_620.method346();
            }
            anInt813 = 0;
            anInt819 = 0;
        }
        if(!aBoolean856)
            return;
        byte byte0 = 22;
        byte byte1 = 36;
        aClass6_Sub1_724.method216(byte0, byte1, 468, 12, 192);
        int j1 = 0x989898;
        aClass6_Sub1_724.method214(byte0, byte1 + 12, 468, 18, j1, 160);
        aClass6_Sub1_724.method214(byte0, byte1 + 30, 8, 248, j1, 160);
        aClass6_Sub1_724.method214(byte0 + 205, byte1 + 30, 11, 248, j1, 160);
        aClass6_Sub1_724.method214(byte0 + 462, byte1 + 30, 6, 248, j1, 160);
        aClass6_Sub1_724.method214(byte0 + 8, byte1 + 133, 197, 22, j1, 160);
        aClass6_Sub1_724.method214(byte0 + 8, byte1 + 258, 197, 20, j1, 160);
        aClass6_Sub1_724.method214(byte0 + 216, byte1 + 235, 246, 43, j1, 160);
        int l1 = 0xd0d0d0;
        aClass6_Sub1_724.method214(byte0 + 8, byte1 + 30, 197, 103, l1, 160);
        aClass6_Sub1_724.method214(byte0 + 8, byte1 + 155, 197, 103, l1, 160);
        aClass6_Sub1_724.method214(byte0 + 216, byte1 + 30, 246, 205, l1, 160);
        for(int l2 = 0; l2 < 4; l2++)
            aClass6_Sub1_724.method218(byte0 + 8, byte1 + 30 + l2 * 34, 197, 0);

        for(int i3 = 0; i3 < 4; i3++)
            aClass6_Sub1_724.method218(byte0 + 8, byte1 + 155 + i3 * 34, 197, 0);

        for(int j3 = 0; j3 < 7; j3++)
            aClass6_Sub1_724.method218(byte0 + 216, byte1 + 30 + j3 * 34, 246, 0);

        for(int k3 = 0; k3 < 6; k3++)
        {
            if(k3 < 5)
                aClass6_Sub1_724.method219(byte0 + 8 + k3 * 49, byte1 + 30, 103, 0);
            if(k3 < 5)
                aClass6_Sub1_724.method219(byte0 + 8 + k3 * 49, byte1 + 155, 103, 0);
            aClass6_Sub1_724.method219(byte0 + 216 + k3 * 49, byte1 + 30, 205, 0);
        }

        aClass6_Sub1_724.method257("Trading with: " + aString682, byte0 + 1, byte1 + 10, 1, 0xffffff);
        aClass6_Sub1_724.method257("Your Offer", byte0 + 9, byte1 + 27, 4, 0xffffff);
        aClass6_Sub1_724.method257("Opponent's Offer", byte0 + 9, byte1 + 152, 4, 0xffffff);
        aClass6_Sub1_724.method257("Your Inventory", byte0 + 216, byte1 + 27, 4, 0xffffff);
        if(!aBoolean945)
            aClass6_Sub1_724.method231(byte0 + 217, byte1 + 238, anInt948 + 25);
        aClass6_Sub1_724.method231(byte0 + 394, byte1 + 238, anInt948 + 26);
        if(aBoolean944)
        {
            aClass6_Sub1_724.method255("Other player", byte0 + 341, byte1 + 246, 1, 0xffffff);
            aClass6_Sub1_724.method255("has accepted", byte0 + 341, byte1 + 256, 1, 0xffffff);
        }
        if(aBoolean945)
        {
            aClass6_Sub1_724.method255("Waiting for", byte0 + 217 + 35, byte1 + 246, 1, 0xffffff);
            aClass6_Sub1_724.method255("other player", byte0 + 217 + 35, byte1 + 256, 1, 0xffffff);
        }
        for(int l3 = 0; l3 < anInt708; l3++)
        {
            int i5 = 217 + byte0 + (l3 % 5) * 49;
            int j6 = 31 + byte1 + (l3 / 5) * 34;
            aClass6_Sub1_724.method247(i5, j6, 48, 32, anInt950 + Class1.anIntArray53[anIntArray709[l3]], Class1.anIntArray58[anIntArray709[l3]], 0, 0, false);
            if(Class1.anIntArray55[anIntArray709[l3]] == 0)
                aClass6_Sub1_724.method257(String.valueOf(anIntArray710[l3]), i5 + 1, j6 + 10, 1, 0xffff00);
        }

        for(int i4 = 0; i4 < anInt969; i4++)
        {
            int j5 = 9 + byte0 + (i4 % 4) * 49;
            int k6 = 31 + byte1 + (i4 / 4) * 34;
            aClass6_Sub1_724.method247(j5, k6, 48, 32, anInt950 + Class1.anIntArray53[anIntArray970[i4]], Class1.anIntArray58[anIntArray970[i4]], 0, 0, false);
            if(Class1.anIntArray55[anIntArray970[i4]] == 0)
                aClass6_Sub1_724.method257(String.valueOf(anIntArray971[i4]), j5 + 1, k6 + 10, 1, 0xffff00);
            if(super.anInt33 > j5 && super.anInt33 < j5 + 48 && super.anInt34 > k6 && super.anInt34 < k6 + 32)
                aClass6_Sub1_724.method257(Class1.aStringArray109[anIntArray970[i4]] + ": @whi@" + Class1.aStringArray110[anIntArray970[i4]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }

        for(int j4 = 0; j4 < anInt886; j4++)
        {
            int k5 = 9 + byte0 + (j4 % 4) * 49;
            int l6 = 156 + byte1 + (j4 / 4) * 34;
            aClass6_Sub1_724.method247(k5, l6, 48, 32, anInt950 + Class1.anIntArray53[anIntArray887[j4]], Class1.anIntArray58[anIntArray887[j4]], 0, 0, false);
            if(Class1.anIntArray55[anIntArray887[j4]] == 0)
                aClass6_Sub1_724.method257(String.valueOf(anIntArray888[j4]), k5 + 1, l6 + 10, 1, 0xffff00);
            if(super.anInt33 > k5 && super.anInt33 < k5 + 48 && super.anInt34 > l6 && super.anInt34 < l6 + 32)
                aClass6_Sub1_724.method257(Class1.aStringArray109[anIntArray887[j4]] + ": @whi@" + Class1.aStringArray110[anIntArray887[j4]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }

    }

    private final void method52()
    {
        int i = Class1.anInt144;
        aClass4_858 = new Class4(aClass6_Sub1_724, 50);
        int j = 40;
        if(!aBoolean914)
        {
            aClass4_858.method156(256, 180 + j, "@blu@Rune-V 1.5", 7, true);
            aClass4_858.method156(256, 220 + j, "@whi@Whos Laughing now Reines?", 2, true);
            aClass4_858.method157(256, 250 + j, 220, 40);
            aClass4_858.method156(256, 250 + j, "Enter The Vortex", 5, false);
            aClass4_858.method156(256, 285 + j, "@whi@www.runecheatincforums.tk ", 2, true);
            anInt851 = aClass4_858.method164(256, 250 + j, 220, 40);
        } else
        {
            aClass4_858.method156(256, 200 + j, "Welcome to Rune-V", 4, true);
            aClass4_858.method156(256, 215 + j, "", 4, true);
            aClass4_858.method157(256, 250 + j, 200, 35);
            aClass4_858.method156(256, 250 + j, "Click here to begin Your Destiny", 5, false);
            anInt851 = aClass4_858.method164(256, 250 + j, 200, 35);
        }
        aClass4_667 = new Class4(aClass6_Sub1_724, 50);
        j = 230;
        if(anInt731 == 0)
        {
            aClass4_667.method156(256, j + 8, "To create an account please go back to the", 4, true);
            j += 20;
            aClass4_667.method156(256, j + 8, "www.runescape.com front page, and choose 'create account'", 4, true);
        } else
        if(anInt731 == 1)
        {
            aClass4_667.method156(256, j + 8, "To create an account please click on the", 4, true);
            j += 20;
            aClass4_667.method156(256, j + 8, "'create account' link below the game window", 4, true);
        } else
        {
            aClass4_667.method156(256, j + 8, "To create an account please go back to the", 4, true);
            j += 20;
            aClass4_667.method156(256, j + 8, "runescape front webpage and choose 'create account'", 4, true);
        }
        j += 30;
        aClass4_667.method157(256, j + 17, 150, 34);
        aClass4_667.method156(256, j + 17, "Ok", 5, false);
        anInt733 = aClass4_667.method164(256, j + 17, 150, 34);
        aClass4_751 = new Class4(aClass6_Sub1_724, 50);
        j = 230;
        anInt864 = aClass4_751.method156(256, j - 10, "User,Pass, and Auth Please", 4, true);
        j += 28;
        aClass4_751.method157(115, j, 200, 40);
        aClass4_751.method156(115, j - 10, "User:", 4, false);
        anInt865 = aClass4_751.method162(115, j + 10, 150, 30, 4, 18, false, false);
        j += 40;
        aClass4_751.method157(115, j, 200, 40);
        aClass4_751.method156(115, j - 10, "Pass:", 4, false);
        anInt866 = aClass4_751.method162(115, j + 10, 150, 30, 4, 18, true, false);
        j -= 35;
        aClass4_751.method157(410, j, 120, 25);
        aClass4_751.method156(410, j, "Login", 4, false);
        anInt867 = aClass4_751.method164(410, j, 120, 25);
        j += 35;
        aClass4_751.method157(350, 315, 120, 40);
        aClass4_751.method156(350, 305, "@bla@World:", 4, true);
        serv = aClass4_751.method162(350, j + 25, 390, 30, 4, 12, false, true);
        j += 30;
    }

    private final void method53(boolean flag)
    {
        int i = Class1.anInt144;
        int j = ((Class6) (aClass6_Sub1_724)).anInt311 - 199;
        int k = 36;
        aClass6_Sub1_724.method231(j - 49, 3, anInt948 + 4);
        char c = '\304';
        char c1 = '\266';
        int l;
        int i1 = l = Class6.method223(160, 160, 160);
        if(anInt800 == 0)
            i1 = Class6.method223(220, 220, 220);
        else
            l = Class6.method223(220, 220, 220);
        aClass6_Sub1_724.method214(j, k, c / 2, 24, i1, 128);
        aClass6_Sub1_724.method214(j + c / 2, k, c / 2, 24, l, 128);
        aClass6_Sub1_724.method214(j, k + 24, c, 90, Class6.method223(220, 220, 220), 128);
        aClass6_Sub1_724.method214(j, k + 24 + 90, c, c1 - 90 - 24, Class6.method223(160, 160, 160), 128);
        aClass6_Sub1_724.method218(j, k + 24, c, 0);
        aClass6_Sub1_724.method219(j + c / 2, k, 24, 0);
        aClass6_Sub1_724.method218(j, k + 113, c, 0);
        aClass6_Sub1_724.method255("Magic", j + c / 4, k + 16, 4, 0);
        aClass6_Sub1_724.method255("Prayers", j + c / 4 + c / 2, k + 16, 4, 0);
        if(anInt800 == 0)
        {
            aClass4_798.method165(anInt799);
            int j1 = 0;
            for(int j2 = 0; j2 < Class1.anInt120; j2++)
            {
                String s = "@yel@";
                int j4 = 0;
                do
                {
                    if(j4 >= Class1.anIntArray97[j2])
                        break;
                    int i5 = Class1.anIntArrayArray99[j2][j4];
                    if(!method104(i5, Class1.anIntArrayArray100[j2][j4]))
                    {
                        s = "@whi@";
                        break;
                    }
                    j4++;
                } while(true);
                j4 = anIntArray728[6];
                if(Class1.anIntArray96[j2] > j4)
                    s = "@bla@";
                aClass4_798.method167(anInt799, j1++, s + "Level " + Class1.anIntArray96[j2] + ": " + Class1.aStringArray118[j2]);
            }

            aClass4_798.method142();
            int k2 = aClass4_798.method174(anInt799);
            if(k2 != -1)
            {
                aClass6_Sub1_724.method257("Level " + Class1.anIntArray96[k2] + ": " + Class1.aStringArray118[k2], j + 2, k + 124, 1, 0xffff00);
                aClass6_Sub1_724.method257(Class1.aStringArray119[k2], j + 2, k + 136, 0, 0xffffff);
                for(int l3 = 0; l3 < Class1.anIntArray97[k2]; l3++)
                {
                    int k4 = Class1.anIntArrayArray99[k2][l3];
                    aClass6_Sub1_724.method231(j + 2 + l3 * 44, k + 150, anInt950 + Class1.anIntArray53[k4]);
                    int j5 = method58(k4);
                    int k5 = Class1.anIntArrayArray100[k2][l3];
                    String s2 = "@red@";
                    if(method104(k4, k5))
                        s2 = "@gre@";
                    aClass6_Sub1_724.method257(s2 + j5 + "/" + k5, j + 2 + l3 * 44, k + 150, 1, 0xffffff);
                }

            } else
            {
                aClass6_Sub1_724.method257("Point at a spell for a description", j + 2, k + 124, 1, 0);
            }
        }
        if(anInt800 == 1)
        {
            aClass4_798.method165(anInt799);
            int k1 = 0;
            for(int l2 = 0; l2 < Class1.anInt95; l2++)
            {
                String s1 = "@whi@";
                if(Class1.anIntArray88[l2] > anIntArray825[5])
                    s1 = "@bla@";
                if(aBooleanArray679[l2])
                    s1 = "@gre@";
                aClass4_798.method167(anInt799, k1++, s1 + "Level " + Class1.anIntArray88[l2] + ": " + Class1.aStringArray137[l2]);
            }

            aClass4_798.method142();
            int i3 = aClass4_798.method174(anInt799);
            if(i3 != -1)
            {
                aClass6_Sub1_724.method255("Level " + Class1.anIntArray88[i3] + ": " + Class1.aStringArray137[i3], j + c / 2, k + 130, 1, 0xffff00);
                aClass6_Sub1_724.method255(Class1.aStringArray138[i3], j + c / 2, k + 145, 0, 0xffffff);
                aClass6_Sub1_724.method255("Drain rate: " + Class1.anIntArray89[i3], j + c / 2, k + 160, 1, 0);
            } else
            {
                aClass6_Sub1_724.method257("Point at a prayer for a description", j + 2, k + 124, 1, 0);
            }
        }
        if(!flag)
            return;
        j = super.anInt33 - (((Class6) (aClass6_Sub1_724)).anInt311 - 199);
        k = super.anInt34 - 36;
        if(j >= 0 && k >= 0 && j < 196 && k < 182)
        {
            aClass4_798.method139(j + (((Class6) (aClass6_Sub1_724)).anInt311 - 199), k + 36, super.anInt36, super.anInt35);
            if(k <= 24 && anInt813 == 1)
                if(j < 98 && anInt800 == 1)
                {
                    anInt800 = 0;
                    aClass4_798.method166(anInt799);
                } else
                if(j > 98 && anInt800 == 0)
                {
                    anInt800 = 1;
                    aClass4_798.method166(anInt799);
                }
            if(anInt813 == 1 && anInt800 == 0)
            {
                int l1 = aClass4_798.method174(anInt799);
                if(l1 != -1)
                {
                    int j3 = anIntArray728[6];
                    if(Class1.anIntArray96[l1] > j3)
                    {
                        method118("Your magic ability is not high enough for this spell", 3);
                    } else
                    {
                        int i4 = 0;
                        do
                        {
                            if(i4 >= Class1.anIntArray97[l1])
                                break;
                            int l4 = Class1.anIntArrayArray99[l1][i4];
                            if(!method104(l4, Class1.anIntArrayArray100[l1][i4]))
                            {
                                method118("You don't have all the reagents you need for this spell", 3);
                                i4 = -1;
                                break;
                            }
                            i4++;
                        } while(true);
                        if(i4 == Class1.anIntArray97[l1])
                        {
                            anInt811 = l1;
                            anInt764 = -1;
                        }
                    }
                }
            }
            if(anInt813 == 1 && anInt800 == 1)
            {
                int i2 = aClass4_798.method174(anInt799);
                if(i2 != -1)
                {
                    int k3 = anIntArray825[5];
                    if(Class1.anIntArray88[i2] > k3)
                        method118("Your prayer ability is not high enough for this prayer", 3);
                    else
                    if(anIntArray728[5] == 0)
                        method118("You have run out of prayer points. Return to a church to recharge", 3);
                    else
                    if(aBooleanArray679[i2])
                    {
                        super.aClass14_Sub1_620.method331(164);
                        super.aClass14_Sub1_620.method348(i2);
                        super.aClass14_Sub1_620.method346();
                        aBooleanArray679[i2] = false;
                        method97("prayeroff");
                    } else
                    {
                        super.aClass14_Sub1_620.method331(17);
                        super.aClass14_Sub1_620.method348(i2);
                        super.aClass14_Sub1_620.method346();
                        aBooleanArray679[i2] = true;
                        method97("prayeron");
                    }
                }
            }
            anInt813 = 0;
        }
    }

    private final String method54(int i)
    {
        if(Class8.anApplet370 != null)
            return Class8.method268(Class15.method361(i));
        else
            return Class15.method361(i);
    }

    private final void method55(int i, int j, int k, int l, boolean flag)
    {
        if(method84(i, j, k, l, k, l, false, flag))
        {
            return;
        } else
        {
            method83(i, j, k, l, k, l, true, flag);
            return;
        }
    }

    private final void method56(boolean flag)
    {
        int i = Class1.anInt144;
        int j = ((Class6) (aClass6_Sub1_724)).anInt311 - 248;
        aClass6_Sub1_724.method231(j, 3, anInt948 + 1);
        for(int k = 0; k < anInt707; k++)
        {
            int k1 = j + (k % 5) * 49;
            int i2 = 36 + (k / 5) * 34;
            if(k < anInt708 && anIntArray711[k] == 1)
                aClass6_Sub1_724.method214(k1, i2, 49, 34, 0x5301f, 50);
            else
                aClass6_Sub1_724.method214(k1, i2, 49, 34, Class6.method223(181, 181, 181), 128);
            if(k >= anInt708)
                continue;
            aClass6_Sub1_724.method247(k1, i2, 48, 32, anInt950 + Class1.anIntArray53[anIntArray709[k]], Class1.anIntArray58[anIntArray709[k]], 0, 0, false);
            if(Class1.anIntArray55[anIntArray709[k]] == 0)
                aClass6_Sub1_724.method257(String.valueOf(anIntArray710[k]), k1 + 1, i2 + 10, 1, 0xffff00);
        }

        for(int l = 1; l <= 4; l++)
            aClass6_Sub1_724.method219(j + l * 49, 36, (anInt707 / 5) * 34, 0);

        for(int i1 = 1; i1 <= anInt707 / 5 - 1; i1++)
            aClass6_Sub1_724.method218(j, 36 + i1 * 34, 245, 0);

        if(!flag)
            return;
        j = super.anInt33 - (((Class6) (aClass6_Sub1_724)).anInt311 - 248);
        int j1 = super.anInt34 - 36;
        if(j >= 0 && j1 >= 0 && j < 248 && j1 < (anInt707 / 5) * 34)
        {
            int l1 = j / 49 + (j1 / 34) * 5;
            if(l1 < anInt708)
            {
                int j2 = anIntArray709[l1];
                if(anInt811 >= 0)
                {
                    if(Class1.anIntArray98[anInt811] == 3)
                    {
                        aStringArray985[anInt756] = "Cast " + Class1.aStringArray118[anInt811] + " on";
                        aStringArray769[anInt756] = "@lre@" + Class1.aStringArray109[j2];
                        anIntArray882[anInt756] = 600;
                        anIntArray803[anInt756] = l1;
                        anIntArray804[anInt756] = anInt811;
                        anInt756++;
                        return;
                    }
                } else
                {
                    if(anInt764 >= 0)
                    {
                        aStringArray985[anInt756] = "Use " + aString765 + " with";
                        aStringArray769[anInt756] = "@lre@" + Class1.aStringArray109[j2];
                        anIntArray882[anInt756] = 610;
                        anIntArray803[anInt756] = l1;
                        anIntArray804[anInt756] = anInt764;
                        anInt756++;
                        return;
                    }
                    if(anIntArray711[l1] == 1)
                    {
                        aStringArray985[anInt756] = "Remove";
                        aStringArray769[anInt756] = "@lre@" + Class1.aStringArray109[j2];
                        anIntArray882[anInt756] = 620;
                        anIntArray803[anInt756] = l1;
                        anInt756++;
                    } else
                    if(Class1.anIntArray57[j2] != 0)
                    {
                        if((Class1.anIntArray57[j2] & 0x18) != 0)
                            aStringArray985[anInt756] = "Wield";
                        else
                            aStringArray985[anInt756] = "Wear";
                        aStringArray769[anInt756] = "@lre@" + Class1.aStringArray109[j2];
                        anIntArray882[anInt756] = 630;
                        anIntArray803[anInt756] = l1;
                        anInt756++;
                    }
                    if(!Class1.aStringArray111[j2].equals(""))
                    {
                        aStringArray985[anInt756] = Class1.aStringArray111[j2];
                        aStringArray769[anInt756] = "@lre@" + Class1.aStringArray109[j2];
                        anIntArray882[anInt756] = 640;
                        anIntArray803[anInt756] = l1;
                        anInt756++;
                    }
                    aStringArray985[anInt756] = "Use";
                    aStringArray769[anInt756] = "@lre@" + Class1.aStringArray109[j2];
                    anIntArray882[anInt756] = 650;
                    anIntArray803[anInt756] = l1;
                    anInt756++;
                    aStringArray985[anInt756] = "Drop";
                    aStringArray769[anInt756] = "@lre@" + Class1.aStringArray109[j2];
                    anIntArray882[anInt756] = 660;
                    anIntArray803[anInt756] = l1;
                    anInt756++;
                    aStringArray985[anInt756] = "Examine";
                    aStringArray769[anInt756] = "@lre@" + Class1.aStringArray109[j2];
                    anIntArray882[anInt756] = 3600;
                    anIntArray803[anInt756] = j2;
                    anInt756++;
                }
            }
        }
    }

    private final void method57()
    {
        if(super.anInt636 > 0)
            super.anInt636--;
        if(anInt690 == 0)
        {
            aClass4_858.method139(super.anInt33, super.anInt34, super.anInt36, super.anInt35);
            if(aClass4_858.method140(anInt850))
                anInt690 = 1;
            if(aClass4_858.method140(anInt851))
            {
                anInt690 = 2;
                aClass4_751.method169(anInt864, "Please enter your username and password");
                aClass4_751.method169(anInt865, "");
                aClass4_751.method169(anInt866, "");
                aClass4_751.method173(anInt865);
                return;
            }
        } else
        if(anInt690 == 2)
        {
            aClass4_751.method139(super.anInt33, super.anInt34, super.anInt36, super.anInt35);
            if(aClass4_751.method140(anInt868))
                anInt690 = 0;
            if(aClass4_751.method140(anInt865))
                aClass4_751.method173(anInt866);
            if(aClass4_751.method140(anInt866))
                aClass4_751.method173(anInt866);
            if(aClass4_751.method140(anInt866) || aClass4_751.method140(anInt867))
            {
                aString734 = aClass4_751.method170(anInt865);
                aString735 = aClass4_751.method170(anInt866);
                server = aClass4_751.method170(serv);
                if(server.equals("51") || server.equals("52") || server.equals("53") || server.equals("54") || server.equals("55") || server.equals("56"))
                {
                    changeworld(Integer.parseInt(server));
                    method21(aString734, aString735, false);
                } else
                {
                    method36("Invalid server!", "Choose between 51, 52, 53, 54, 55 and 56!");
                }
            }
        }
    }

    public void changeworld(int i)
    {
        if(i == 51)
        {
            super.aString616 = "uk1.runescape.com";
            super.anInt617 = 43594;
        } else
        if(i == 52)
        {
            super.aString616 = "uk1.runescape.com";
            super.anInt617 = 43595;
        } else
        if(i == 53)
        {
            super.aString616 = "ul3.runescape.com";
            super.anInt617 = 43594;
        } else
        if(i == 54)
        {
            super.aString616 = "ul3.runescape.com";
            super.anInt617 = 43595;
        } else
        if(i == 55)
        {
            super.aString616 = "cet3b.runescape.com";
            super.anInt617 = 43594;
        } else
        if(i == 56)
        {
            super.aString616 = "cet3b.runescape.com";
            super.anInt617 = 43595;
        }
    }

    private final int method58(int i)
    {
        int j = Class1.anInt144;
        int k = 0;
        for(int l = 0; l < anInt708; l++)
        {
            if(anIntArray709[l] != i)
                continue;
            if(Class1.anIntArray55[i] == 1)
                k++;
            else
                k += anIntArray710[l];
        }

        return k;
    }

    private final void method59()
    {
        aClass4_830 = new Class4(aClass6_Sub1_724, 100);
        aClass4_830.method156(256, 10, "Please design Your Character", 4, true);
        int i = 140;
        int j = 34;
        i += 116;
        j -= 10;
        aClass4_830.method156(i - 55, j + 110, "Front", 3, true);
        aClass4_830.method156(i, j + 110, "Side", 3, true);
        aClass4_830.method156(i + 55, j + 110, "Back", 3, true);
        byte byte0 = 54;
        j += 145;
        aClass4_830.method158(i - byte0, j, 53, 41);
        aClass4_830.method156(i - byte0, j - 8, "Head", 1, true);
        aClass4_830.method156(i - byte0, j + 8, "Type", 1, true);
        aClass4_830.method159(i - byte0 - 40, j, Class4.anInt221 + 7);
        anInt694 = aClass4_830.method164(i - byte0 - 40, j, 20, 20);
        aClass4_830.method159((i - byte0) + 40, j, Class4.anInt221 + 6);
        anInt695 = aClass4_830.method164((i - byte0) + 40, j, 20, 20);
        aClass4_830.method158(i + byte0, j, 53, 41);
        aClass4_830.method156(i + byte0, j - 8, "Hair", 1, true);
        aClass4_830.method156(i + byte0, j + 8, "Color", 1, true);
        aClass4_830.method159((i + byte0) - 40, j, Class4.anInt221 + 7);
        anInt696 = aClass4_830.method164((i + byte0) - 40, j, 20, 20);
        aClass4_830.method159(i + byte0 + 40, j, Class4.anInt221 + 6);
        anInt697 = aClass4_830.method164(i + byte0 + 40, j, 20, 20);
        j += 50;
        aClass4_830.method158(i - byte0, j, 53, 41);
        aClass4_830.method156(i - byte0, j, "Gender", 1, true);
        aClass4_830.method159(i - byte0 - 40, j, Class4.anInt221 + 7);
        anInt698 = aClass4_830.method164(i - byte0 - 40, j, 20, 20);
        aClass4_830.method159((i - byte0) + 40, j, Class4.anInt221 + 6);
        anInt699 = aClass4_830.method164((i - byte0) + 40, j, 20, 20);
        aClass4_830.method158(i + byte0, j, 53, 41);
        aClass4_830.method156(i + byte0, j - 8, "Top", 1, true);
        aClass4_830.method156(i + byte0, j + 8, "Color", 1, true);
        aClass4_830.method159((i + byte0) - 40, j, Class4.anInt221 + 7);
        anInt700 = aClass4_830.method164((i + byte0) - 40, j, 20, 20);
        aClass4_830.method159(i + byte0 + 40, j, Class4.anInt221 + 6);
        anInt701 = aClass4_830.method164(i + byte0 + 40, j, 20, 20);
        j += 50;
        aClass4_830.method158(i - byte0, j, 53, 41);
        aClass4_830.method156(i - byte0, j - 8, "Skin", 1, true);
        aClass4_830.method156(i - byte0, j + 8, "Color", 1, true);
        aClass4_830.method159(i - byte0 - 40, j, Class4.anInt221 + 7);
        anInt702 = aClass4_830.method164(i - byte0 - 40, j, 20, 20);
        aClass4_830.method159((i - byte0) + 40, j, Class4.anInt221 + 6);
        anInt703 = aClass4_830.method164((i - byte0) + 40, j, 20, 20);
        aClass4_830.method158(i + byte0, j, 53, 41);
        aClass4_830.method156(i + byte0, j - 8, "Bottom", 1, true);
        aClass4_830.method156(i + byte0, j + 8, "Color", 1, true);
        aClass4_830.method159((i + byte0) - 40, j, Class4.anInt221 + 7);
        anInt704 = aClass4_830.method164((i + byte0) - 40, j, 20, 20);
        aClass4_830.method159(i + byte0 + 40, j, Class4.anInt221 + 6);
        anInt705 = aClass4_830.method164(i + byte0 + 40, j, 20, 20);
        j += 82;
        j -= 35;
        aClass4_830.method157(i, j, 200, 30);
        aClass4_830.method156(i, j, "Accept", 4, false);
        anInt706 = aClass4_830.method164(i, j, 200, 30);
    }

    private final void method60(boolean flag)
    {
        int i = Class1.anInt144;
        int j = ((Class6) (aClass6_Sub1_724)).anInt311 - 199;
        int k = 36;
        aClass6_Sub1_724.method231(j - 49, 3, anInt948 + 6);
        char c = '\304';
        aClass6_Sub1_724.method214(j, 36, c, 65, Class6.method223(181, 181, 181), 160);
        aClass6_Sub1_724.method214(j, 101, c, 65, Class6.method223(181, 181, 181), 160);
        aClass6_Sub1_724.method214(j, 166, c, 95, Class6.method223(181, 181, 181), 160);
        aClass6_Sub1_724.method214(j, 261, c, 40, Class6.method223(181, 181, 181), 160);
        int l = j + 3;
        int i1 = k + 15;
        aClass6_Sub1_724.method257("    @blu@Rune-V", l, 60, 5, 0);
        i1 += 15;
        if(aBoolean675)
            aClass6_Sub1_724.method257("Camera angle mode - @red@1.0", l, 126, 1, 0xffffff);
        else
            aClass6_Sub1_724.method257("Camera angle mode - @gre@2.0", l, 126, 1, 0xffffff);
        i1 += 15;
        if(aBoolean767)
            aClass6_Sub1_724.method257("Mouse buttons - @red@Mac", l, 141, 1, 0xffffff);
        else
            aClass6_Sub1_724.method257("Mouse buttons - @gre@Windows", l, 141, 1, 0xffffff);
        i1 += 15;
        if(Playerleft)
            aClass6_Sub1_724.method257("Player One-Click - @gre@On", l, 156, 1, 0xffffff);
        else
            aClass6_Sub1_724.method257("Player One-Click - @red@Off", l, 156, 1, 0xffffff);
        i1 += 15;
        if(foodType == 0)
        {
            aClass6_Sub1_724.method257("Food Type: @gre@Lobster", l, 171, 1, 0xffffff);
            foodName = "Lobster";
            foodID = 373;
        } else
        if(foodType == 1)
        {
            aClass6_Sub1_724.method257("Food Type: @gre@Trout", l, 171, 1, 0xffffff);
            foodName = "Trout";
            foodID = 359;
        } else
        if(foodType == 2)
        {
            aClass6_Sub1_724.method257("Food Type: @gre@Swordfish", l, 171, 1, 0xffffff);
            foodName = "Swordfish";
            foodID = 370;
        }
        i1 += 15;
        if(showInfo)
            aClass6_Sub1_724.method257("Info Menu - @gre@On", l, 186, 1, 0xffffff);
        else
            aClass6_Sub1_724.method257("Info Menu - @red@Off", l, 186, 1, 0xffffff);
        if(prayercomb == 0)
        {
            aClass6_Sub1_724.method257("Prayer Combo: @gre@Burst", l, 201, 1, 0xffffff);
            prayername = "Burst";
            prayerid = 1;
            prayerdot = 1;
        } else
        if(prayercomb == 1)
        {
            aClass6_Sub1_724.method257("Prayer Combo: @gre@Superhuman", l, 201, 1, 0xffffff);
            prayername = "Superhuman";
            prayerid = 4;
            prayerdot = 4;
        } else
        if(prayercomb == 2)
        {
            aClass6_Sub1_724.method257("Prayer Combo: @gre@Ultimate", l, 201, 1, 0xffffff);
            prayername = "Ultimate";
            prayerid = 10;
            prayerdot = 10;
        } else
        if(prayercomb == 3)
        {
            aClass6_Sub1_724.method257("Prayer Combo: @gre@Utlimate, Improved", l, 201, 1, 0xffffff);
            prayername = "Utlimate + Improved";
            prayerid = 10;
            prayerdot = 5;
        } else
        if(prayercomb == 4)
        {
            aClass6_Sub1_724.method257("Prayer Combo: @gre@Utlimate, Incredible", l, 201, 1, 0xffffff);
            prayername = "Utlimate + Incredible";
            prayerid = 10;
            prayerdot = 11;
        }
        i1 += 15;
        i1 += 5;
        if(super.anInt629 == 0)
            aClass6_Sub1_724.method257("Block public messages: @red@<off>", j + 3, 81, 1, 0xffffff);
        else
            aClass6_Sub1_724.method257("Block public messages: @gre@<on>", j + 3, 81, 1, 0xffffff);
        i1 += 15;
        if(super.anInt630 == 0)
            aClass6_Sub1_724.method257("Block private messages: @red@<off>", j + 3, 96, 1, 0xffffff);
        else
            aClass6_Sub1_724.method257("Block private messages: @gre@<on>", j + 3, 96, 1, 0xffffff);
        i1 += 15;
        if(super.anInt631 == 0)
            aClass6_Sub1_724.method257("Block trade requests: @red@<off>", j + 3, 111, 1, 0xffffff);
        else
            aClass6_Sub1_724.method257("Block trade requests: @gre@<on>", j + 3, 111, 1, 0xffffff);
        i1 += 15;
        int j1 = 0xffffff;
        if(super.anInt33 > l && super.anInt33 < l + c && super.anInt34 > 258 && super.anInt34 < 272)
            j1 = 0xffff00;
        aClass6_Sub1_724.method257("Click here to logout", j + 3, 265, 1, j1);
        if(!flag)
            return;
        j = super.anInt33 - (((Class6) (aClass6_Sub1_724)).anInt311 - 199);
        k = super.anInt34 - 36;
        if(j >= 0 && k >= 0 && j < 251 && k < 265)
        {
            int k1 = ((Class6) (aClass6_Sub1_724)).anInt311 - 199;
            byte byte0 = 36;
            char c1 = '\304';
            int l1 = k1 + 3;
            int i2 = byte0 + 30;
            if(super.anInt33 > l1 && super.anInt33 < l1 + c1 && super.anInt34 > 116 && super.anInt34 < 130 && anInt813 == 1)
            {
                aBoolean675 = !aBoolean675;
                super.aClass14_Sub1_620.method331(66);
                super.aClass14_Sub1_620.method348(0);
                super.aClass14_Sub1_620.method348(aBoolean675 ? 1 : 0);
                super.aClass14_Sub1_620.method346();
            }
            i2 += 15;
            if(super.anInt33 > l1 && super.anInt33 < l1 + c1 && super.anInt34 > 131 && super.anInt34 < 145 && anInt813 == 1)
            {
                aBoolean767 = !aBoolean767;
                super.aClass14_Sub1_620.method331(66);
                super.aClass14_Sub1_620.method348(2);
                super.aClass14_Sub1_620.method348(aBoolean767 ? 1 : 0);
                super.aClass14_Sub1_620.method346();
            }
            i2 += 15;
            if(super.anInt33 > l1 && super.anInt33 < l1 + c1 && super.anInt34 > 146 && super.anInt34 < 160 && anInt813 == 1)
                Playerleft = !Playerleft;
            i2 += 15;
            if(super.anInt33 > l1 && super.anInt33 < l1 + c1 && super.anInt34 > 161 && super.anInt34 < 175 && anInt813 == 1)
                if(foodType == 4)
                    foodType = 0;
                else
                    foodType++;
            i2 += 15;
            if(super.anInt33 > l1 && super.anInt33 < l1 + c1 && super.anInt34 > 176 && super.anInt34 < 190 && anInt813 == 1)
                showInfo = !showInfo;
            i2 += 15;
            if(super.anInt33 > l1 && super.anInt33 < l1 + c1 && super.anInt34 > 191 && super.anInt34 < 205 && anInt813 == 1)
                if(prayercomb == 4)
                    prayercomb = 0;
                else
                    prayercomb++;
            i2 += 15;
            i2 += 15;
            i2 += 15;
            i2 += 15;
            i2 += 15;
            boolean flag1 = false;
            i2 += 35;
            if(super.anInt33 > l1 && super.anInt33 < l1 + c1 && super.anInt34 > 71 && super.anInt34 < 85 && anInt813 == 1)
            {
                super.anInt629 = 1 - super.anInt629;
                flag1 = true;
            }
            i2 += 15;
            if(super.anInt33 > l1 && super.anInt33 < l1 + c1 && super.anInt34 > 86 && super.anInt34 < 100 && anInt813 == 1)
            {
                super.anInt630 = 1 - super.anInt630;
                flag1 = true;
            }
            i2 += 15;
            if(super.anInt33 > l1 && super.anInt33 < l1 + c1 && super.anInt34 > 101 && super.anInt34 < 115 && anInt813 == 1)
            {
                super.anInt631 = 1 - super.anInt631;
                flag1 = true;
            }
            i2 += 15;
            if(aBoolean914 && super.anInt33 > l1 && super.anInt33 < l1 + c1 && super.anInt34 > 239 && super.anInt34 < 255 && anInt813 == 1)
            {
                super.anInt632 = 1 - super.anInt632;
                flag1 = true;
            }
            i2 += 15;
            if(flag1)
                method28(super.anInt629, super.anInt630, super.anInt631, super.anInt632);
            i2 += 20;
            if(super.anInt33 > l1 && super.anInt33 < l1 + c1 && super.anInt34 > 259 && super.anInt34 < 275 && anInt813 == 1)
                method71();
            anInt813 = 0;
        }
    }

    private final void method61()
    {
        aClass6_Sub1_724.aBoolean335 = false;
        aClass6_Sub1_724.method212();
        aClass4_830.method142();
        int i = 140;
        int j = 50;
        i += 116;
        j -= 25;
        aClass6_Sub1_724.method235(i - 32 - 55, j, 64, 102, Class1.anIntArray87[anInt873], anIntArray832[anInt876]);
        aClass6_Sub1_724.method247(i - 32 - 55, j, 64, 102, Class1.anIntArray87[anInt872], anIntArray832[anInt875], anIntArray829[anInt877], 0, false);
        aClass6_Sub1_724.method247(i - 32 - 55, j, 64, 102, Class1.anIntArray87[anInt871], anIntArray885[anInt874], anIntArray829[anInt877], 0, false);
        aClass6_Sub1_724.method235(i - 32, j, 64, 102, Class1.anIntArray87[anInt873] + 6, anIntArray832[anInt876]);
        aClass6_Sub1_724.method247(i - 32, j, 64, 102, Class1.anIntArray87[anInt872] + 6, anIntArray832[anInt875], anIntArray829[anInt877], 0, false);
        aClass6_Sub1_724.method247(i - 32, j, 64, 102, Class1.anIntArray87[anInt871] + 6, anIntArray885[anInt874], anIntArray829[anInt877], 0, false);
        aClass6_Sub1_724.method235((i - 32) + 55, j, 64, 102, Class1.anIntArray87[anInt873] + 12, anIntArray832[anInt876]);
        aClass6_Sub1_724.method247((i - 32) + 55, j, 64, 102, Class1.anIntArray87[anInt872] + 12, anIntArray832[anInt875], anIntArray829[anInt877], 0, false);
        aClass6_Sub1_724.method247((i - 32) + 55, j, 64, 102, Class1.anIntArray87[anInt871] + 12, anIntArray885[anInt874], anIntArray829[anInt877], 0, false);
        aClass6_Sub1_724.method231(0, anInt677, anInt948 + 22);
        aClass6_Sub1_724.method211(aGraphics857, 0, 0);
    }

    private final void method62()
    {
        int i = Class1.anInt144;
        int j = 2203 - (anInt977 + anInt807 + anInt784);
        if(anInt976 + anInt806 + anInt783 >= 2640)
            j = -50;
        int k = -1;
        for(int l = 0; l < anInt796; l++)
            aBooleanArray662[l] = false;

        for(int i1 = 0; i1 < anInt855; i1++)
            aBooleanArray831[i1] = false;

        int j1 = aClass10_739.method278();
        Class5 aclass5[] = aClass10_739.method280();
        int ai[] = aClass10_739.method279();
        for(int k1 = 0; k1 < j1 && anInt756 <= 200; k1++)
        {
            int i2 = ai[k1];
            Class5 class5 = aclass5[k1];
            if(class5.anIntArray258[i2] > 65535 && (class5.anIntArray258[i2] < 0x30d40 || class5.anIntArray258[i2] > 0x493e0))
                continue;
            if(class5 == aClass10_739.aClass5_433)
            {
                int j2 = class5.anIntArray258[i2] % 10000;
                int i3 = class5.anIntArray258[i2] / 10000;
                if(i3 == 1)
                {
                    String s = "";
                    int l3 = 0;
                    if(aClass2_975.anInt168 > 0 && aClass2Array983[j2].anInt168 > 0)
                        l3 = aClass2_975.anInt168 - aClass2Array983[j2].anInt168;
                    if(l3 < 0)
                        s = "@or1@";
                    if(l3 < -3)
                        s = "@or2@";
                    if(l3 < -6)
                        s = "@or3@";
                    if(l3 < -9)
                        s = "@red@";
                    if(l3 > 0)
                        s = "@gr1@";
                    if(l3 > 3)
                        s = "@gr2@";
                    if(l3 > 6)
                        s = "@gr3@";
                    if(l3 > 9)
                        s = "@gre@";
                    s = " " + s + "(level-" + aClass2Array983[j2].anInt168 + ")";
                    if(anInt811 >= 0)
                    {
                        if(Class1.anIntArray98[anInt811] == 1 || Class1.anIntArray98[anInt811] == 2)
                        {
                            aStringArray985[anInt756] = "Cast " + Class1.aStringArray118[anInt811] + " on";
                            aStringArray769[anInt756] = "@whi@" + aClass2Array983[j2].aString146 + s;
                            anIntArray882[anInt756] = 800;
                            anIntArray937[anInt756] = aClass2Array983[j2].anInt149;
                            anIntArray938[anInt756] = aClass2Array983[j2].anInt150;
                            anIntArray803[anInt756] = aClass2Array983[j2].anInt147;
                            anIntArray804[anInt756] = anInt811;
                            anInt756++;
                        }
                        continue;
                    }
                    if(anInt764 >= 0)
                    {
                        aStringArray985[anInt756] = "Use " + aString765 + " with";
                        aStringArray769[anInt756] = "@whi@" + aClass2Array983[j2].aString146 + s;
                        anIntArray882[anInt756] = 810;
                        anIntArray937[anInt756] = aClass2Array983[j2].anInt149;
                        anIntArray938[anInt756] = aClass2Array983[j2].anInt150;
                        anIntArray803[anInt756] = aClass2Array983[j2].anInt147;
                        anIntArray804[anInt756] = anInt764;
                        anInt756++;
                        continue;
                    }
                    if(j > 0 && (aClass2Array983[j2].anInt150 - 64) / anInt946 + anInt807 + anInt784 < 2203)
                    {
                        aStringArray985[anInt756] = "Attack";
                        aStringArray769[anInt756] = "@whi@" + aClass2Array983[j2].aString146 + s;
                        if(Playerleft)
                            anIntArray882[anInt756] = 805;
                        else
                        if(l3 >= 0 && l3 < 5)
                            anIntArray882[anInt756] = 805;
                        else
                            anIntArray882[anInt756] = 2805;
                        anIntArray937[anInt756] = aClass2Array983[j2].anInt149;
                        anIntArray938[anInt756] = aClass2Array983[j2].anInt150;
                        anIntArray803[anInt756] = aClass2Array983[j2].anInt147;
                        anInt756++;
                    } else
                    if(aBoolean914)
                    {
                        aStringArray985[anInt756] = "Stake with";
                        aStringArray769[anInt756] = "@whi@" + aClass2Array983[j2].aString146 + s;
                        anIntArray937[anInt756] = aClass2Array983[j2].anInt149;
                        anIntArray938[anInt756] = aClass2Array983[j2].anInt150;
                        anIntArray882[anInt756] = 2806;
                        anIntArray803[anInt756] = aClass2Array983[j2].anInt147;
                        anInt756++;
                    }
                    aStringArray985[anInt756] = "Exchange With";
                    aStringArray769[anInt756] = "@whi@" + aClass2Array983[j2].aString146 + s;
                    anIntArray882[anInt756] = 2810;
                    anIntArray803[anInt756] = aClass2Array983[j2].anInt147;
                    anInt756++;
                    aStringArray985[anInt756] = "Harass";
                    aStringArray769[anInt756] = "@whi@" + aClass2Array983[j2].aString146 + s;
                    anIntArray882[anInt756] = 2820;
                    anIntArray803[anInt756] = aClass2Array983[j2].anInt147;
                    anInt756++;
                    continue;
                }
                if(i3 == 2)
                {
                    if(anInt811 >= 0)
                    {
                        if(Class1.anIntArray98[anInt811] == 3)
                        {
                            aStringArray985[anInt756] = "Cast " + Class1.aStringArray118[anInt811] + " on";
                            aStringArray769[anInt756] = "@lre@" + Class1.aStringArray109[anIntArray772[j2]];
                            anIntArray882[anInt756] = 200;
                            anIntArray937[anInt756] = anIntArray770[j2];
                            anIntArray938[anInt756] = anIntArray771[j2];
                            anIntArray803[anInt756] = anIntArray772[j2];
                            anIntArray804[anInt756] = anInt811;
                            anInt756++;
                        }
                        continue;
                    }
                    if(anInt764 >= 0)
                    {
                        aStringArray985[anInt756] = "Use " + aString765 + " with";
                        aStringArray769[anInt756] = "@lre@" + Class1.aStringArray109[anIntArray772[j2]];
                        anIntArray882[anInt756] = 210;
                        anIntArray937[anInt756] = anIntArray770[j2];
                        anIntArray938[anInt756] = anIntArray771[j2];
                        anIntArray803[anInt756] = anIntArray772[j2];
                        anIntArray804[anInt756] = anInt764;
                        anInt756++;
                    } else
                    {
                        aStringArray985[anInt756] = "Take";
                        aStringArray769[anInt756] = "@lre@" + Class1.aStringArray109[anIntArray772[j2]];
                        anIntArray882[anInt756] = 220;
                        anIntArray937[anInt756] = anIntArray770[j2];
                        anIntArray938[anInt756] = anIntArray771[j2];
                        anIntArray803[anInt756] = anIntArray772[j2];
                        anInt756++;
                        aStringArray985[anInt756] = "Examine";
                        aStringArray769[anInt756] = "@lre@" + Class1.aStringArray109[anIntArray772[j2]];
                        anIntArray882[anInt756] = 3200;
                        anIntArray803[anInt756] = anIntArray772[j2];
                        anInt756++;
                    }
                    continue;
                }
                if(i3 != 3)
                    continue;
                String s1 = "";
                int i4 = -1;
                int j4 = aClass2Array768[j2].anInt151;
                if(Class1.anIntArray116[j4] > 0)
                {
                    int k4 = (Class1.anIntArray112[j4] + Class1.anIntArray115[j4] + Class1.anIntArray113[j4] + Class1.anIntArray114[j4]) / 4;
                    int l4 = (anIntArray825[0] + anIntArray825[1] + anIntArray825[2] + anIntArray825[3] + 27) / 4;
                    i4 = l4 - k4;
                    s1 = "@yel@";
                    if(i4 < 0)
                        s1 = "@or1@";
                    if(i4 < -3)
                        s1 = "@or2@";
                    if(i4 < -6)
                        s1 = "@or3@";
                    if(i4 < -9)
                        s1 = "@red@";
                    if(i4 > 0)
                        s1 = "@gr1@";
                    if(i4 > 3)
                        s1 = "@gr2@";
                    if(i4 > 6)
                        s1 = "@gr3@";
                    if(i4 > 9)
                        s1 = "@gre@";
                    s1 = " " + s1 + "(level-" + k4 + ")";
                }
                if(anInt811 >= 0)
                {
                    if(Class1.anIntArray98[anInt811] == 2)
                    {
                        aStringArray985[anInt756] = "Cast " + Class1.aStringArray118[anInt811] + " on";
                        aStringArray769[anInt756] = "@yel@" + Class1.aStringArray127[aClass2Array768[j2].anInt151];
                        anIntArray882[anInt756] = 700;
                        anIntArray937[anInt756] = aClass2Array768[j2].anInt149;
                        anIntArray938[anInt756] = aClass2Array768[j2].anInt150;
                        anIntArray803[anInt756] = aClass2Array768[j2].anInt147;
                        anIntArray804[anInt756] = anInt811;
                        anInt756++;
                    }
                    continue;
                }
                if(anInt764 >= 0)
                {
                    aStringArray985[anInt756] = "Use " + aString765 + " with";
                    aStringArray769[anInt756] = "@yel@" + Class1.aStringArray127[aClass2Array768[j2].anInt151];
                    anIntArray882[anInt756] = 710;
                    anIntArray937[anInt756] = aClass2Array768[j2].anInt149;
                    anIntArray938[anInt756] = aClass2Array768[j2].anInt150;
                    anIntArray803[anInt756] = aClass2Array768[j2].anInt147;
                    anIntArray804[anInt756] = anInt764;
                    anInt756++;
                    continue;
                }
                if(Class1.anIntArray116[j4] > 0)
                {
                    aStringArray985[anInt756] = "Attack";
                    aStringArray769[anInt756] = "@yel@" + Class1.aStringArray127[aClass2Array768[j2].anInt151] + s1;
                    if(i4 >= 0)
                        anIntArray882[anInt756] = 715;
                    else
                        anIntArray882[anInt756] = 2715;
                    anIntArray937[anInt756] = aClass2Array768[j2].anInt149;
                    anIntArray938[anInt756] = aClass2Array768[j2].anInt150;
                    anIntArray803[anInt756] = aClass2Array768[j2].anInt147;
                    anInt756++;
                }
                aStringArray985[anInt756] = "Talk-to";
                aStringArray769[anInt756] = "@yel@" + Class1.aStringArray127[aClass2Array768[j2].anInt151];
                anIntArray882[anInt756] = 720;
                anIntArray937[anInt756] = aClass2Array768[j2].anInt149;
                anIntArray938[anInt756] = aClass2Array768[j2].anInt150;
                anIntArray803[anInt756] = aClass2Array768[j2].anInt147;
                anInt756++;
                if(!Class1.aStringArray129[j4].equals(""))
                {
                    aStringArray985[anInt756] = Class1.aStringArray129[j4];
                    aStringArray769[anInt756] = "@yel@" + Class1.aStringArray127[aClass2Array768[j2].anInt151];
                    anIntArray882[anInt756] = 725;
                    anIntArray937[anInt756] = aClass2Array768[j2].anInt149;
                    anIntArray938[anInt756] = aClass2Array768[j2].anInt150;
                    anIntArray803[anInt756] = aClass2Array768[j2].anInt147;
                    anInt756++;
                }
                aStringArray985[anInt756] = "Examine";
                aStringArray769[anInt756] = "@yel@" + Class1.aStringArray127[aClass2Array768[j2].anInt151];
                anIntArray882[anInt756] = 3700;
                anIntArray803[anInt756] = aClass2Array768[j2].anInt151;
                anInt756++;
                continue;
            }
            if(class5 != null && class5.anInt257 >= 10000)
            {
                int k2 = class5.anInt257 - 10000;
                int j3 = anIntArray741[k2];
                if(aBooleanArray831[k2])
                    continue;
                if(anInt811 >= 0)
                {
                    if(Class1.anIntArray98[anInt811] == 4)
                    {
                        aStringArray985[anInt756] = "Cast " + Class1.aStringArray118[anInt811] + " on";
                        aStringArray769[anInt756] = "@cya@" + Class1.aStringArray70[j3];
                        anIntArray882[anInt756] = 300;
                        anIntArray937[anInt756] = anIntArray747[k2];
                        anIntArray938[anInt756] = anIntArray748[k2];
                        anIntArray803[anInt756] = anIntArray740[k2];
                        anIntArray804[anInt756] = anInt811;
                        anInt756++;
                    }
                } else
                if(anInt764 >= 0)
                {
                    aStringArray985[anInt756] = "Use " + aString765 + " with";
                    aStringArray769[anInt756] = "@cya@" + Class1.aStringArray70[j3];
                    anIntArray882[anInt756] = 310;
                    anIntArray937[anInt756] = anIntArray747[k2];
                    anIntArray938[anInt756] = anIntArray748[k2];
                    anIntArray803[anInt756] = anIntArray740[k2];
                    anIntArray804[anInt756] = anInt764;
                    anInt756++;
                } else
                {
                    if(!Class1.aStringArray72[j3].equalsIgnoreCase("WalkTo"))
                    {
                        aStringArray985[anInt756] = Class1.aStringArray72[j3];
                        aStringArray769[anInt756] = "@cya@" + Class1.aStringArray70[j3];
                        anIntArray882[anInt756] = 320;
                        anIntArray937[anInt756] = anIntArray747[k2];
                        anIntArray938[anInt756] = anIntArray748[k2];
                        anIntArray803[anInt756] = anIntArray740[k2];
                        anInt756++;
                    }
                    if(!Class1.aStringArray73[j3].equalsIgnoreCase("Examine"))
                    {
                        aStringArray985[anInt756] = Class1.aStringArray73[j3];
                        aStringArray769[anInt756] = "@cya@" + Class1.aStringArray70[j3];
                        anIntArray882[anInt756] = 2300;
                        anIntArray937[anInt756] = anIntArray747[k2];
                        anIntArray938[anInt756] = anIntArray748[k2];
                        anIntArray803[anInt756] = anIntArray740[k2];
                        anInt756++;
                    }
                    aStringArray985[anInt756] = "Examine";
                    aStringArray769[anInt756] = "@cya@" + Class1.aStringArray70[j3];
                    anIntArray882[anInt756] = 3300;
                    anIntArray803[anInt756] = j3;
                    anInt756++;
                }
                aBooleanArray831[k2] = true;
                continue;
            }
            if(class5 != null && class5.anInt257 >= 0)
            {
                int l2 = class5.anInt257;
                int k3 = anIntArray762[l2];
                if(aBooleanArray662[l2])
                    continue;
                if(anInt811 >= 0)
                {
                    if(Class1.anIntArray98[anInt811] == 5)
                    {
                        aStringArray985[anInt756] = "Cast " + Class1.aStringArray118[anInt811] + " on";
                        aStringArray769[anInt756] = "@cya@" + Class1.aStringArray91[k3];
                        anIntArray882[anInt756] = 400;
                        anIntArray937[anInt756] = anIntArray760[l2];
                        anIntArray938[anInt756] = anIntArray761[l2];
                        anIntArray803[anInt756] = anIntArray763[l2];
                        anIntArray804[anInt756] = anIntArray762[l2];
                        anIntArray805[anInt756] = anInt811;
                        anInt756++;
                    }
                } else
                if(anInt764 >= 0)
                {
                    aStringArray985[anInt756] = "Use " + aString765 + " with";
                    aStringArray769[anInt756] = "@cya@" + Class1.aStringArray91[k3];
                    anIntArray882[anInt756] = 410;
                    anIntArray937[anInt756] = anIntArray760[l2];
                    anIntArray938[anInt756] = anIntArray761[l2];
                    anIntArray803[anInt756] = anIntArray763[l2];
                    anIntArray804[anInt756] = anIntArray762[l2];
                    anIntArray805[anInt756] = anInt764;
                    anInt756++;
                } else
                {
                    if(!Class1.aStringArray93[k3].equalsIgnoreCase("WalkTo"))
                    {
                        aStringArray985[anInt756] = Class1.aStringArray93[k3];
                        aStringArray769[anInt756] = "@cya@" + Class1.aStringArray91[k3];
                        anIntArray882[anInt756] = 420;
                        anIntArray937[anInt756] = anIntArray760[l2];
                        anIntArray938[anInt756] = anIntArray761[l2];
                        anIntArray803[anInt756] = anIntArray763[l2];
                        anIntArray804[anInt756] = anIntArray762[l2];
                        anInt756++;
                    }
                    if(!Class1.aStringArray94[k3].equalsIgnoreCase("Examine"))
                    {
                        aStringArray985[anInt756] = Class1.aStringArray94[k3];
                        aStringArray769[anInt756] = "@cya@" + Class1.aStringArray91[k3];
                        anIntArray882[anInt756] = 2400;
                        anIntArray937[anInt756] = anIntArray760[l2];
                        anIntArray938[anInt756] = anIntArray761[l2];
                        anIntArray803[anInt756] = anIntArray763[l2];
                        anIntArray804[anInt756] = anIntArray762[l2];
                        anInt756++;
                    }
                    aStringArray985[anInt756] = "Examine";
                    aStringArray769[anInt756] = "@cya@" + Class1.aStringArray91[k3];
                    anIntArray882[anInt756] = 3400;
                    anIntArray803[anInt756] = k3;
                    anInt756++;
                }
                aBooleanArray662[l2] = true;
                continue;
            }
            if(i2 >= 0)
                i2 = class5.anIntArray258[i2] - 0x30d40;
            if(i2 >= 0)
                k = i2;
        }

        if(anInt811 >= 0 && Class1.anIntArray98[anInt811] <= 1)
        {
            aStringArray985[anInt756] = "Cast " + Class1.aStringArray118[anInt811] + " on self";
            aStringArray769[anInt756] = "";
            anIntArray882[anInt756] = 1000;
            anIntArray803[anInt756] = anInt811;
            anInt756++;
        }
        if(k != -1)
        {
            int l1 = k;
            if(anInt811 >= 0)
            {
                if(Class1.anIntArray98[anInt811] == 6)
                {
                    aStringArray985[anInt756] = "Cast " + Class1.aStringArray118[anInt811] + " on ground";
                    aStringArray769[anInt756] = "";
                    anIntArray882[anInt756] = 900;
                    anIntArray937[anInt756] = aClass19_883.anIntArray602[l1];
                    anIntArray938[anInt756] = aClass19_883.anIntArray587[l1];
                    anIntArray803[anInt756] = anInt811;
                    anInt756++;
                    return;
                }
            } else
            if(anInt764 < 0)
            {
                aStringArray985[anInt756] = "Walk here";
                aStringArray769[anInt756] = "";
                anIntArray882[anInt756] = 920;
                anIntArray937[anInt756] = aClass19_883.anIntArray602[l1];
                anIntArray938[anInt756] = aClass19_883.anIntArray587[l1];
                anInt756++;
            }
        }
    }

    private final void method64()
    {
        int i = Class1.anInt144;
        Class1.method124("torcha2");
        Class1.method124("torcha3");
        Class1.method124("torcha4");
        Class1.method124("skulltorcha2");
        Class1.method124("skulltorcha3");
        Class1.method124("skulltorcha4");
        Class1.method124("firea2");
        Class1.method124("firea3");
        Class1.method124("fireplacea2");
        Class1.method124("fireplacea3");
        Class1.method124("firespell2");
        Class1.method124("firespell3");
        Class1.method124("lightning2");
        Class1.method124("lightning3");
        Class1.method124("clawspell2");
        Class1.method124("clawspell3");
        Class1.method124("clawspell4");
        Class1.method124("clawspell5");
        Class1.method124("spellcharge2");
        Class1.method124("spellcharge3");
        if(method7())
        {
            byte abyte0[] = method18("models" + Class18.anInt577 + ".jag", "", 60);
            if(abyte0 == null)
            {
                aBoolean922 = true;
                return;
            }
            for(int k = 0; k < Class1.anInt74; k++)
            {
                int l = Class15.method364(Class1.aStringArray126[k] + ".ob3", abyte0);
                if(l != 0)
                    aClass5Array994[k] = new Class5(abyte0, l, true);
                else
                    aClass5Array994[k] = new Class5(1, 1);
                if(Class1.aStringArray126[k].equals("giantcrystal"))
                    aClass5Array994[k].aBoolean256 = true;
            }

            return;
        }
        method15(70, "Starting Rune-V");
        for(int j = 0; j < Class1.anInt74; j++)
        {
            aClass5Array994[j] = new Class5("../gamedata/models/" + Class1.aStringArray126[j] + ".ob2");
            if(Class1.aStringArray126[j].equals("giantcrystal"))
                aClass5Array994[j].aBoolean256 = true;
        }

    }

    private final void method65()
    {
        int i = Class1.anInt144;
        if(anInt746 != 0)
            method88();
        else
        if(aBoolean745)
            method49();
        else
        if(aBoolean879 && anInt869 == 0)
            method81();
        else
        if(aBoolean727 && anInt869 == 0)
            method117();
        else
        if(aBoolean673)
            method92();
        else
        if(aBoolean856)
            method51();
        else
        if(aBoolean801)
            method100();
        else
        if(aBoolean917)
            method87();
        else
        if(anInt986 == 1)
            method116();
        else
        if(anInt986 == 2)
            method47();
        else
        if(anInt931 != 0)
        {
            method75();
        } else
        {
            if(aBoolean852)
                method46();
            if(aClass2_975.anInt153 == 8 || aClass2_975.anInt153 == 9)
                method90();
            method114();
            boolean flag = !aBoolean852 && !aBoolean854;
            if(flag)
                anInt756 = 0;
            if(anInt915 == 0 && flag)
                method62();
            if(anInt915 == 1)
                method56(flag);
            if(anInt915 == 2)
                method103(flag);
            if(anInt915 == 3)
                method115(flag);
            if(anInt915 == 4)
                method53(flag);
            if(anInt915 == 5)
                method80(flag);
            if(anInt915 == 6)
                method60(flag);
            if(!aBoolean854 && !aBoolean852)
                method91();
            if(aBoolean854 && !aBoolean852)
                method110();
        }
        anInt813 = 0;
    }

    private final void method66()
    {
        super.aString42 = "";
        super.aString43 = "";
    }

    final void method68(int i, int j, int k, int l, int i1, int j1, int k1)
    {
        int l1 = Class1.anInt144;
        Class2 class2 = aClass2Array768[i1];
        int i2 = class2.anInt153 + (anInt729 + 16) / 32 & 7;
        boolean flag = false;
        int j2 = i2;
        if(j2 == 5)
        {
            j2 = 3;
            flag = true;
        } else
        if(j2 == 6)
        {
            j2 = 2;
            flag = true;
        } else
        if(j2 == 7)
        {
            j2 = 1;
            flag = true;
        }
        int k2 = j2 * 3 + anIntArray726[(class2.anInt152 / Class1.anIntArray105[class2.anInt151]) % 4];
        if(class2.anInt153 == 8)
        {
            j2 = 5;
            i2 = 2;
            flag = false;
            i -= (Class1.anIntArray107[class2.anInt151] * k1) / 100;
            k2 = j2 * 3 + anIntArray939[(anInt918 / (Class1.anIntArray106[class2.anInt151] - 1)) % 8];
        } else
        if(class2.anInt153 == 9)
        {
            j2 = 5;
            i2 = 2;
            flag = true;
            i += (Class1.anIntArray107[class2.anInt151] * k1) / 100;
            k2 = j2 * 3 + anIntArray909[(anInt918 / Class1.anIntArray106[class2.anInt151]) % 8];
        }
        for(int l2 = 0; l2 < 12; l2++)
        {
            int k3 = anIntArrayArray684[i2][l2];
            int i4 = Class1.anIntArrayArray90[class2.anInt151][k3];
            if(i4 < 0)
                continue;
            int j4 = 0;
            int k4 = 0;
            int l4 = k2;
            if(flag && j2 >= 1 && j2 <= 3 && Class1.anIntArray86[i4] == 1)
                l4 += 15;
            if(j2 == 5 && Class1.anIntArray85[i4] != 1)
                continue;
            int i5 = l4 + Class1.anIntArray87[i4];
            j4 = (j4 * k) / ((Class6) (aClass6_Sub1_724)).anIntArray328[i5];
            k4 = (k4 * l) / ((Class6) (aClass6_Sub1_724)).anIntArray329[i5];
            int j5 = (k * ((Class6) (aClass6_Sub1_724)).anIntArray328[i5]) / ((Class6) (aClass6_Sub1_724)).anIntArray328[Class1.anIntArray87[i4]];
            j4 -= (j5 - k) / 2;
            int k5 = Class1.anIntArray83[i4];
            int l5 = 0;
            if(k5 == 1)
            {
                k5 = Class1.anIntArray130[class2.anInt151];
                l5 = Class1.anIntArray133[class2.anInt151];
            } else
            if(k5 == 2)
            {
                k5 = Class1.anIntArray131[class2.anInt151];
                l5 = Class1.anIntArray133[class2.anInt151];
            } else
            if(k5 == 3)
            {
                k5 = Class1.anIntArray132[class2.anInt151];
                l5 = Class1.anIntArray133[class2.anInt151];
            }
            aClass6_Sub1_724.method247(i + j4, j + k4, j5, l, i5, k5, l5, j1, flag);
        }

        if(class2.anInt161 > 0)
        {
            anIntArray967[anInt820] = aClass6_Sub1_724.method263(class2.aString160, 1) / 2;
            if(anIntArray967[anInt820] > 150)
                anIntArray967[anInt820] = 150;
            anIntArray968[anInt820] = (aClass6_Sub1_724.method263(class2.aString160, 1) / 300) * aClass6_Sub1_724.method261(1);
            anIntArray965[anInt820] = i + k / 2;
            anIntArray966[anInt820] = j;
            aStringArray821[anInt820++] = class2.aString160;
        }
        if(class2.anInt153 == 8 || class2.anInt153 == 9 || class2.anInt167 != 0)
        {
            if(class2.anInt167 > 0)
            {
                int i3 = i;
                if(class2.anInt153 == 8)
                    i3 -= (20 * k1) / 100;
                else
                if(class2.anInt153 == 9)
                    i3 += (20 * k1) / 100;
                int l3 = (class2.anInt165 * 30) / class2.anInt166;
                anIntArray687[anInt766] = i3 + k / 2;
                anIntArray688[anInt766] = j;
                anIntArray689[anInt766++] = l3;
            }
            if(class2.anInt167 > 150)
            {
                int j3 = i;
                if(class2.anInt153 == 8)
                    j3 -= (10 * k1) / 100;
                else
                if(class2.anInt153 == 9)
                    j3 += (10 * k1) / 100;
                aClass6_Sub1_724.method231((j3 + k / 2) - 12, (j + l / 2) - 12, anInt948 + 12);
                aClass6_Sub1_724.method255(String.valueOf(class2.anInt164), (j3 + k / 2) - 1, j + l / 2 + 5, 3, 0xffffff);
            }
        }
    }

    private final void method69()
    {
        aClass6_Sub1_724.method231(0, anInt677 - 4, anInt948 + 23);
        int i = Class6.method223(200, 200, 255);
        if(anInt780 == 0)
            i = Class6.method223(255, 200, 50);
        if(anInt790 % 30 > 15)
            i = Class6.method223(255, 50, 50);
        aClass6_Sub1_724.method255("All messages", 54, anInt677 + 6, 0, i);
        i = Class6.method223(200, 200, 255);
        if(anInt780 == 1)
            i = Class6.method223(255, 200, 50);
        if(anInt791 % 30 > 15)
            i = Class6.method223(255, 50, 50);
        aClass6_Sub1_724.method255("Chat history", 155, anInt677 + 6, 0, i);
        i = Class6.method223(200, 200, 255);
        if(anInt780 == 2)
            i = Class6.method223(255, 200, 50);
        if(anInt792 % 30 > 15)
            i = Class6.method223(255, 50, 50);
        aClass6_Sub1_724.method255("Quest history", 255, anInt677 + 6, 0, i);
        i = Class6.method223(200, 200, 255);
        if(anInt780 == 3)
            i = Class6.method223(255, 200, 50);
        if(anInt793 % 30 > 15)
            i = Class6.method223(255, 50, 50);
        aClass6_Sub1_724.method255("Private history", 355, anInt677 + 6, 0, i);
        aClass6_Sub1_724.method255("Report abuse", 457, anInt677 + 6, 0, 0xffffff);
    }

    private final void method70()
    {
        int i = Class1.anInt144;
        aBoolean849 = false;
        aClass6_Sub1_724.aBoolean335 = false;
        aClass6_Sub1_724.method212();
        if(anInt690 == 0 || anInt690 == 1 || anInt690 == 2 || anInt690 == 3)
        {
            int j = (anInt918 * 2) % 3072;
            if(j < 1024)
            {
                aClass6_Sub1_724.method231(0, 10, anInt954);
                if(j > 768)
                    aClass6_Sub1_724.method233(0, 10, anInt954 + 1, j - 768);
            } else
            if(j < 2048)
            {
                aClass6_Sub1_724.method231(0, 10, anInt954 + 1);
                if(j > 1792)
                    aClass6_Sub1_724.method233(0, 10, anInt948 + 10, j - 1792);
            } else
            {
                aClass6_Sub1_724.method231(0, 10, anInt948 + 10);
                if(j > 2816)
                    aClass6_Sub1_724.method233(0, 10, anInt954, j - 2816);
            }
        }
        if(anInt690 == 0)
            aClass4_858.method142();
        if(anInt690 == 1)
            aClass4_667.method142();
        if(anInt690 == 2)
            aClass4_751.method142();
        aClass6_Sub1_724.method231(0, anInt677, anInt948 + 22);
        aClass6_Sub1_724.method211(aGraphics857, 0, 0);
    }

    private final void method71()
    {
        if(anInt947 == 0)
            return;
        if(anInt869 > 450)
        {
            method118("@cya@You can't logout during combat!", 3);
            return;
        }
        if(anInt869 > 0)
        {
            method118("@cya@You can't logout for 10 seconds after combat", 3);
            return;
        } else
        {
            super.aClass14_Sub1_620.method331(168);
            super.aClass14_Sub1_620.method346();
            anInt746 = 1000;
            return;
        }
    }

    private final void method72()
    {
        int i = Class1.anInt144;
        anInt889 = anInt936;
        for(int j = 0; j < anInt936; j++)
        {
            anIntArray955[j] = anIntArray816[j];
            anIntArray956[j] = anIntArray817[j];
        }

        for(int k = 0; k < anInt708 && anInt889 < anInt916; k++)
        {
            int l = anIntArray709[k];
            boolean flag = false;
            int i1 = 0;
            do
            {
                if(i1 >= anInt889)
                    break;
                if(anIntArray955[i1] == l)
                {
                    flag = true;
                    break;
                }
                i1++;
            } while(true);
            if(!flag)
            {
                anIntArray955[anInt889] = l;
                anIntArray956[anInt889] = 0;
                anInt889++;
            }
        }

    }

    private final void method73()
    {
        byte abyte0[] = method18("config" + Class18.anInt574 + ".jag", "", 10);
        if(abyte0 == null)
        {
            aBoolean922 = true;
            return;
        }
        Class1.method129(abyte0, aBoolean914);
        byte abyte1[] = method18("filter" + Class18.anInt581 + ".jag", "", 15);
        if(abyte1 == null)
        {
            aBoolean922 = true;
            return;
        } else
        {
            byte abyte2[] = Class15.method366("fragmentsenc.txt", 0, abyte1);
            byte abyte3[] = Class15.method366("badenc.txt", 0, abyte1);
            byte abyte4[] = Class15.method366("hostenc.txt", 0, abyte1);
            byte abyte5[] = Class15.method366("tldlist.txt", 0, abyte1);
            Class16.method368(new Class13(abyte2), new Class13(abyte3), new Class13(abyte4), new Class13(abyte5));
            return;
        }
    }

    private final void method74(int i, int j, int k)
    {
        aClass6_Sub1_724.method220(i, j, k);
        aClass6_Sub1_724.method220(i - 1, j, k);
        aClass6_Sub1_724.method220(i + 1, j, k);
        aClass6_Sub1_724.method220(i, j - 1, k);
        aClass6_Sub1_724.method220(i, j + 1, k);
    }

    private final void method75()
    {
        if(anInt813 != 0)
        {
            anInt813 = 0;
            if(anInt931 == 1 && (super.anInt33 < 106 || super.anInt34 < 145 || super.anInt33 > 406 || super.anInt34 > 215))
            {
                anInt931 = 0;
                return;
            }
            if(anInt931 == 2 && (super.anInt33 < 6 || super.anInt34 < 145 || super.anInt33 > 506 || super.anInt34 > 215))
            {
                anInt931 = 0;
                return;
            }
            if(anInt931 == 3 && (super.anInt33 < 106 || super.anInt34 < 145 || super.anInt33 > 406 || super.anInt34 > 215))
            {
                anInt931 = 0;
                return;
            }
            if(super.anInt33 > 236 && super.anInt33 < 276 && super.anInt34 > 193 && super.anInt34 < 213)
            {
                anInt931 = 0;
                return;
            }
        }
        int i = 145;
        if(anInt931 == 1)
        {
            aClass6_Sub1_724.method216(106, i, 300, 70, 0);
            aClass6_Sub1_724.method217(106, i, 300, 70, 0xffffff);
            i += 20;
            aClass6_Sub1_724.method255("Enter name to add to friends list", 256, i, 4, 0xffffff);
            i += 20;
            aClass6_Sub1_724.method255(super.aString40 + "*", 256, i, 4, 0xffffff);
            if(super.aString41.length() > 0)
            {
                String s = super.aString41.trim();
                super.aString40 = "";
                super.aString41 = "";
                anInt931 = 0;
                if(s.length() > 0 && Class15.method362(s) != aClass2_975.aLong145)
                    method31(s);
            }
        }
        if(anInt931 == 2)
        {
            aClass6_Sub1_724.method216(6, i, 500, 70, 0);
            aClass6_Sub1_724.method217(6, i, 500, 70, 0xffffff);
            i += 20;
            aClass6_Sub1_724.method255("Enter message to send to " + Class15.method363(aLong928), 256, i, 4, 0xffffff);
            i += 20;
            aClass6_Sub1_724.method255(super.aString42 + "*", 256, i, 4, 0xffffff);
            if(super.aString43.length() > 0)
            {
                String s1 = super.aString43;
                super.aString42 = "";
                super.aString43 = "";
                anInt931 = 0;
                int k = Class17.method400(s1);
                method33(aLong928, Class17.aByteArray569, k);
                s1 = Class17.method399(Class17.aByteArray569, 0, k);
                s1 = Class16.method374(s1);
                method42("@pri@You tell " + Class15.method363(aLong928) + ": " + s1);
            }
        }
        if(anInt931 == 3)
        {
            aClass6_Sub1_724.method216(106, i, 300, 70, 0);
            aClass6_Sub1_724.method217(106, i, 300, 70, 0xffffff);
            i += 20;
            aClass6_Sub1_724.method255("Enter name to add to ignore list", 256, i, 4, 0xffffff);
            i += 20;
            aClass6_Sub1_724.method255(super.aString40 + "*", 256, i, 4, 0xffffff);
            if(super.aString41.length() > 0)
            {
                String s2 = super.aString41.trim();
                super.aString40 = "";
                super.aString41 = "";
                anInt931 = 0;
                if(s2.length() > 0 && Class15.method362(s2) != aClass2_975.aLong145)
                    method29(s2);
            }
        }
        int j = 0xffffff;
        if(super.anInt33 > 236 && super.anInt33 < 276 && super.anInt34 > 193 && super.anInt34 < 213)
            j = 0xffff00;
        aClass6_Sub1_724.method255("Cancel", 256, 208, 1, j);
    }

    private final Class2 method76(int i, int j, int k, int l)
    {
        int i1 = Class1.anInt144;
        if(aClass2Array891[i] == null)
        {
            aClass2Array891[i] = new Class2();
            aClass2Array891[i].anInt147 = i;
            aClass2Array891[i].anInt148 = 0;
        }
        Class2 class2 = aClass2Array891[i];
        boolean flag = false;
        int j1 = 0;
        do
        {
            if(j1 >= anInt743)
                break;
            if(aClass2Array923[j1].anInt147 == i)
            {
                flag = true;
                break;
            }
            j1++;
        } while(true);
        if(flag)
        {
            class2.anInt154 = l;
            int k1 = class2.anInt156;
            if(j != class2.anIntArray157[k1] || k != class2.anIntArray158[k1])
            {
                class2.anInt156 = k1 = (k1 + 1) % 10;
                class2.anIntArray157[k1] = j;
                class2.anIntArray158[k1] = k;
            }
        } else
        {
            class2.anInt147 = i;
            class2.anInt155 = 0;
            class2.anInt156 = 0;
            class2.anIntArray157[0] = class2.anInt149 = j;
            class2.anIntArray158[0] = class2.anInt150 = k;
            class2.anInt154 = class2.anInt153 = l;
            class2.anInt152 = 0;
        }
        aClass2Array983[anInt742++] = class2;
        return class2;
    }

    private final void method77()
    {
        int i = Class1.anInt144;
        int j = 0;
        byte byte0 = 50;
        byte byte1 = 50;
        aClass19_883.method416(byte0 * 48 + 23, byte1 * 48 + 23, j);
        aClass19_883.method425(aClass5Array994);
        char c = '\u2600';
        char c1 = '\u1900';
        char c2 = '\u044C';
        char c3 = '\u0378';
        aClass10_739.anInt390 = 4100;
        aClass10_739.anInt391 = 4100;
        aClass10_739.anInt392 = 1;
        aClass10_739.anInt393 = 4000;
        aClass10_739.method298(c, -aClass19_883.method421(c, c1), c1, 912, c3, 0, c2 * 2);
        aClass10_739.method286();
        aClass6_Sub1_724.method221();
        aClass6_Sub1_724.method221();
        aClass6_Sub1_724.method216(0, 0, 512, 6, 0);
        for(int k = 6; k >= 1; k--)
            aClass6_Sub1_724.method222(0, k, 0, k, 512, 8);

        aClass6_Sub1_724.method216(0, 194, 512, 20, 0);
        for(int l = 6; l >= 1; l--)
            aClass6_Sub1_724.method222(0, l, 0, 194 - l, 512, 8);

        aClass6_Sub1_724.method231(15, 15, anInt948 + 10);
        aClass6_Sub1_724.method230(anInt954, 0, 0, 512, 200);
        aClass6_Sub1_724.method227(anInt954);
        c = '\u2400';
        c1 = '\u2400';
        c2 = '\u044C';
        c3 = '\u0378';
        aClass10_739.anInt390 = 4100;
        aClass10_739.anInt391 = 4100;
        aClass10_739.anInt392 = 1;
        aClass10_739.anInt393 = 4000;
        aClass10_739.method298(c, -aClass19_883.method421(c, c1), c1, 912, c3, 0, c2 * 2);
        aClass10_739.method286();
        aClass6_Sub1_724.method221();
        aClass6_Sub1_724.method221();
        aClass6_Sub1_724.method216(0, 0, 512, 6, 0);
        for(int i1 = 6; i1 >= 1; i1--)
            aClass6_Sub1_724.method222(0, i1, 0, i1, 512, 8);

        aClass6_Sub1_724.method216(0, 194, 512, 20, 0);
        for(int j1 = 6; j1 >= 1; j1--)
            aClass6_Sub1_724.method222(0, j1, 0, 194 - j1, 512, 8);

        aClass6_Sub1_724.method231(15, 15, anInt948 + 10);
        aClass6_Sub1_724.method230(anInt954 + 1, 0, 0, 512, 200);
        aClass6_Sub1_724.method227(anInt954 + 1);
        for(int k1 = 0; k1 < 64; k1++)
        {
            aClass10_739.method270(aClass19_883.aClass5ArrayArray603[0][k1]);
            aClass10_739.method270(aClass19_883.aClass5ArrayArray605[1][k1]);
            aClass10_739.method270(aClass19_883.aClass5ArrayArray603[1][k1]);
            aClass10_739.method270(aClass19_883.aClass5ArrayArray605[2][k1]);
            aClass10_739.method270(aClass19_883.aClass5ArrayArray603[2][k1]);
        }

        c = '\u2B80';
        c1 = '\u2880';
        c2 = '\u01F4';
        c3 = '\u0178';
        aClass10_739.anInt390 = 4100;
        aClass10_739.anInt391 = 4100;
        aClass10_739.anInt392 = 1;
        aClass10_739.anInt393 = 4000;
        aClass10_739.method298(c, -aClass19_883.method421(c, c1), c1, 912, c3, 0, c2 * 2);
        aClass10_739.method286();
        aClass6_Sub1_724.method221();
        aClass6_Sub1_724.method221();
        aClass6_Sub1_724.method216(0, 0, 512, 6, 0);
        for(int l1 = 6; l1 >= 1; l1--)
            aClass6_Sub1_724.method222(0, l1, 0, l1, 512, 8);

        aClass6_Sub1_724.method216(0, 194, 512, 20, 0);
        for(int i2 = 6; i2 >= 1; i2--)
            aClass6_Sub1_724.method222(0, i2, 0, 194, 512, 8);

        aClass6_Sub1_724.method231(15, 15, anInt948 + 10);
        aClass6_Sub1_724.method230(anInt948 + 10, 0, 0, 512, 200);
        aClass6_Sub1_724.method227(anInt948 + 10);
    }

    private final void method78()
    {
        int i = Class1.anInt144;
        if((anInt940 & 1) == 1 && method112(anInt940))
            return;
        if((anInt940 & 1) == 0 && method112(anInt940))
        {
            if(method112(anInt940 + 1 & 7))
            {
                anInt940 = anInt940 + 1 & 7;
                return;
            }
            if(method112(anInt940 + 7 & 7))
                anInt940 = anInt940 + 7 & 7;
            return;
        }
        int ai[] = {
            1, -1, 2, -2, 3, -3, 4
        };
        int j = 0;
        do
        {
            if(j >= 7)
                break;
            if(method112(anInt940 + ai[j] + 8 & 7))
            {
                anInt940 = anInt940 + ai[j] + 8 & 7;
                break;
            }
            j++;
        } while(true);
        if((anInt940 & 1) == 0 && method112(anInt940))
        {
            if(method112(anInt940 + 1 & 7))
            {
                anInt940 = anInt940 + 1 & 7;
                return;
            }
            if(method112(anInt940 + 7 & 7))
                anInt940 = anInt940 + 7 & 7;
            return;
        } else
        {
            return;
        }
    }

    private final boolean method79(int i)
    {
        for(int j = 0; j < anInt708; j++)
            if(anIntArray709[j] == i && anIntArray711[j] == 1)
                return true;

        return false;
    }

    private final void method80(boolean flag)
    {
        int i = Class1.anInt144;
        int j = ((Class6) (aClass6_Sub1_724)).anInt311 - 199;
        int k = 36;
        aClass6_Sub1_724.method231(j - 49, 3, anInt948 + 5);
        char c = '\304';
        char c1 = '\266';
        int l;
        int i1 = l = Class6.method223(160, 160, 160);
        if(anInt927 == 0)
            i1 = Class6.method223(220, 220, 220);
        else
            l = Class6.method223(220, 220, 220);
        aClass6_Sub1_724.method214(j, k, c / 2, 24, i1, 128);
        aClass6_Sub1_724.method214(j + c / 2, k, c / 2, 24, l, 128);
        aClass6_Sub1_724.method214(j, k + 24, c, c1 - 24, Class6.method223(220, 220, 220), 128);
        aClass6_Sub1_724.method218(j, k + 24, c, 0);
        aClass6_Sub1_724.method219(j + c / 2, k, 24, 0);
        aClass6_Sub1_724.method218(j, (k + c1) - 16, c, 0);
        aClass6_Sub1_724.method255("IPeeps", j + c / 4, k + 16, 4, 0);
        aClass6_Sub1_724.method255("IHaters", j + c / 4 + c / 2, k + 16, 4, 0);
        aClass4_925.method165(anInt926);
        if(anInt927 == 0)
        {
            for(int j1 = 0; j1 < super.anInt624; j1++)
            {
                String s;
                if(super.anIntArray626[j1] == 99)
                    s = "@gre@";
                else
                if(super.anIntArray626[j1] > 0)
                    s = "@yel@";
                else
                    s = "@red@";
                aClass4_925.method167(anInt926, j1, s + Class15.method363(super.aLongArray625[j1]) + "~439~@whi@Remove         WWWWWWWWWW");
            }

        }
        if(anInt927 == 1)
        {
            for(int k1 = 0; k1 < super.anInt627; k1++)
                aClass4_925.method167(anInt926, k1, "@yel@" + Class15.method363(super.aLongArray628[k1]) + "~439~@whi@Remove         WWWWWWWWWW");

        }
        aClass4_925.method142();
        if(anInt927 == 0)
        {
            int l1 = aClass4_925.method174(anInt926);
            if(l1 >= 0 && super.anInt33 < 489)
            {
                if(super.anInt33 > 429)
                    aClass6_Sub1_724.method255("Click to remove " + Class15.method363(super.aLongArray625[l1]), j + c / 2, k + 35, 1, 0xffffff);
                else
                if(super.anIntArray626[l1] == 99)
                    aClass6_Sub1_724.method255("Click to message " + Class15.method363(super.aLongArray625[l1]), j + c / 2, k + 35, 1, 0xffffff);
                else
                if(super.anIntArray626[l1] > 0)
                    aClass6_Sub1_724.method255(Class15.method363(super.aLongArray625[l1]) + " is on world " + super.anIntArray626[l1], j + c / 2, k + 35, 1, 0xffffff);
                else
                    aClass6_Sub1_724.method255(Class15.method363(super.aLongArray625[l1]) + " is offline", j + c / 2, k + 35, 1, 0xffffff);
            } else
            {
                aClass6_Sub1_724.method255("Click a name to pm", j + c / 2, k + 35, 1, 0xffffff);
            }
            int l2;
            if(super.anInt33 > j && super.anInt33 < j + c && super.anInt34 > (k + c1) - 16 && super.anInt34 < k + c1)
                l2 = 0xffff00;
            else
                l2 = 0xffffff;
            aClass6_Sub1_724.method255("Click here to add a friend", j + c / 2, (k + c1) - 3, 1, l2);
        }
        if(anInt927 == 1)
        {
            int i2 = aClass4_925.method174(anInt926);
            if(i2 >= 0 && super.anInt33 < 489 && super.anInt33 > 429)
            {
                if(super.anInt33 > 429)
                    aClass6_Sub1_724.method255("Click to remove " + Class15.method363(super.aLongArray628[i2]), j + c / 2, k + 35, 1, 0xffffff);
            } else
            {
                aClass6_Sub1_724.method255("Blocking messages from:", j + c / 2, k + 35, 1, 0xffffff);
            }
            int i3;
            if(super.anInt33 > j && super.anInt33 < j + c && super.anInt34 > (k + c1) - 16 && super.anInt34 < k + c1)
                i3 = 0xffff00;
            else
                i3 = 0xffffff;
            aClass6_Sub1_724.method255("Click here to add a name", j + c / 2, (k + c1) - 3, 1, i3);
        }
        if(!flag)
            return;
        j = super.anInt33 - (((Class6) (aClass6_Sub1_724)).anInt311 - 199);
        k = super.anInt34 - 36;
        if(j >= 0 && k >= 0 && j < 196 && k < 182)
        {
            aClass4_925.method139(j + (((Class6) (aClass6_Sub1_724)).anInt311 - 199), k + 36, super.anInt36, super.anInt35);
            if(k <= 24 && anInt813 == 1)
                if(j < 98 && anInt927 == 1)
                {
                    anInt927 = 0;
                    aClass4_925.method166(anInt926);
                } else
                if(j > 98 && anInt927 == 0)
                {
                    anInt927 = 1;
                    aClass4_925.method166(anInt926);
                }
            if(anInt813 == 1 && anInt927 == 0)
            {
                int j2 = aClass4_925.method174(anInt926);
                if(j2 >= 0 && super.anInt33 < 489)
                    if(super.anInt33 > 429)
                        method32(super.aLongArray625[j2]);
                    else
                    if(super.anIntArray626[j2] != 0)
                    {
                        anInt931 = 2;
                        aLong928 = super.aLongArray625[j2];
                        super.aString42 = "";
                        super.aString43 = "";
                    }
            }
            if(anInt813 == 1 && anInt927 == 1)
            {
                int k2 = aClass4_925.method174(anInt926);
                if(k2 >= 0 && super.anInt33 < 489 && super.anInt33 > 429)
                    method30(super.aLongArray628[k2]);
            }
            if(k > 166 && anInt813 == 1 && anInt927 == 0)
            {
                anInt931 = 1;
                super.aString40 = "";
                super.aString41 = "";
            }
            if(k > 166 && anInt813 == 1 && anInt927 == 1)
            {
                anInt931 = 3;
                super.aString40 = "";
                super.aString41 = "";
            }
            anInt813 = 0;
        }
    }

    private final void method81()
    {
        int i = Class1.anInt144;
        char c = '\u0198';
        char c1 = '\u014E';
        if(anInt812 > 0 && anInt889 <= 48)
            anInt812 = 0;
        if(anInt812 > 1 && anInt889 <= 96)
            anInt812 = 1;
        if(anInt812 > 2 && anInt889 <= 144)
            anInt812 = 2;
        if(anInt834 >= anInt889 || anInt834 < 0)
            anInt834 = -1;
        if(anInt834 != -1 && anIntArray955[anInt834] != anInt835)
        {
            anInt834 = -1;
            anInt835 = -2;
        }
        if(anInt813 != 0)
        {
            anInt813 = 0;
            int j = super.anInt33 - (256 - c / 2);
            int l = super.anInt34 - (170 - c1 / 2);
            if(j >= 0 && l >= 12 && j < 408 && l < 280)
            {
                int j1 = anInt812 * 48;
                for(int l1 = 0; l1 < 6; l1++)
                {
                    for(int k2 = 0; k2 < 8; k2++)
                    {
                        int i4 = 7 + k2 * 49;
                        int k4 = 28 + l1 * 34;
                        if(j > i4 && j < i4 + 49 && l > k4 && l < k4 + 34 && j1 < anInt889 && anIntArray955[j1] != -1)
                        {
                            anInt835 = anIntArray955[j1];
                            anInt834 = j1;
                        }
                        j1++;
                    }

                }

                j = 256 - c / 2;
                l = 170 - c1 / 2;
                int i2;
                if(anInt834 < 0)
                    i2 = -1;
                else
                    i2 = anIntArray955[anInt834];
                if(i2 != -1)
                {
                    int l2 = anIntArray956[anInt834];
                    if(Class1.anIntArray55[i2] == 1 && l2 > 1)
                        l2 = 1;
                    if(l2 >= 1 && super.anInt33 >= j + 220 && super.anInt34 >= l + 238 && super.anInt33 < j + 250 && super.anInt34 <= l + 249)
                    {
                        super.aClass14_Sub1_620.method331(83);
                        super.aClass14_Sub1_620.method343(i2);
                        super.aClass14_Sub1_620.method343(1);
                        super.aClass14_Sub1_620.method346();
                    }
                    if(l2 >= 5 && super.anInt33 >= j + 250 && super.anInt34 >= l + 238 && super.anInt33 < j + 280 && super.anInt34 <= l + 249)
                    {
                        super.aClass14_Sub1_620.method331(83);
                        super.aClass14_Sub1_620.method343(i2);
                        super.aClass14_Sub1_620.method343(5);
                        super.aClass14_Sub1_620.method346();
                    }
                    if(l2 >= 25 && super.anInt33 >= j + 280 && super.anInt34 >= l + 238 && super.anInt33 < j + 305 && super.anInt34 <= l + 249)
                    {
                        super.aClass14_Sub1_620.method331(83);
                        super.aClass14_Sub1_620.method343(i2);
                        super.aClass14_Sub1_620.method343(25);
                        super.aClass14_Sub1_620.method346();
                    }
                    if(l2 >= 100 && super.anInt33 >= j + 305 && super.anInt34 >= l + 238 && super.anInt33 < j + 335 && super.anInt34 <= l + 249)
                    {
                        super.aClass14_Sub1_620.method331(83);
                        super.aClass14_Sub1_620.method343(i2);
                        super.aClass14_Sub1_620.method343(100);
                        super.aClass14_Sub1_620.method346();
                    }
                    if(l2 >= 500 && super.anInt33 >= j + 335 && super.anInt34 >= l + 238 && super.anInt33 < j + 368 && super.anInt34 <= l + 249)
                    {
                        super.aClass14_Sub1_620.method331(83);
                        super.aClass14_Sub1_620.method343(i2);
                        super.aClass14_Sub1_620.method343(500);
                        super.aClass14_Sub1_620.method346();
                    }
                    if(l2 >= 2500 && super.anInt33 >= j + 370 && super.anInt34 >= l + 238 && super.anInt33 < j + 400 && super.anInt34 <= l + 249)
                    {
                        super.aClass14_Sub1_620.method331(83);
                        super.aClass14_Sub1_620.method343(i2);
                        super.aClass14_Sub1_620.method343(2500);
                        super.aClass14_Sub1_620.method346();
                    }
                    if(method58(i2) >= 1 && super.anInt33 >= j + 220 && super.anInt34 >= l + 263 && super.anInt33 < j + 250 && super.anInt34 <= l + 274)
                    {
                        super.aClass14_Sub1_620.method331(145);
                        super.aClass14_Sub1_620.method343(i2);
                        super.aClass14_Sub1_620.method343(1);
                        super.aClass14_Sub1_620.method346();
                    }
                    if(method58(i2) >= 5 && super.anInt33 >= j + 250 && super.anInt34 >= l + 263 && super.anInt33 < j + 280 && super.anInt34 <= l + 274)
                    {
                        super.aClass14_Sub1_620.method331(145);
                        super.aClass14_Sub1_620.method343(i2);
                        super.aClass14_Sub1_620.method343(5);
                        super.aClass14_Sub1_620.method346();
                    }
                    if(method58(i2) >= 25 && super.anInt33 >= j + 280 && super.anInt34 >= l + 263 && super.anInt33 < j + 305 && super.anInt34 <= l + 274)
                    {
                        super.aClass14_Sub1_620.method331(145);
                        super.aClass14_Sub1_620.method343(i2);
                        super.aClass14_Sub1_620.method343(25);
                        super.aClass14_Sub1_620.method346();
                    }
                    if(method58(i2) >= 100 && super.anInt33 >= j + 305 && super.anInt34 >= l + 263 && super.anInt33 < j + 335 && super.anInt34 <= l + 274)
                    {
                        super.aClass14_Sub1_620.method331(145);
                        super.aClass14_Sub1_620.method343(i2);
                        super.aClass14_Sub1_620.method343(100);
                        super.aClass14_Sub1_620.method346();
                    }
                    if(method58(i2) >= 500 && super.anInt33 >= j + 335 && super.anInt34 >= l + 263 && super.anInt33 < j + 368 && super.anInt34 <= l + 274)
                    {
                        super.aClass14_Sub1_620.method331(145);
                        super.aClass14_Sub1_620.method343(i2);
                        super.aClass14_Sub1_620.method343(500);
                        super.aClass14_Sub1_620.method346();
                    }
                    if(method58(i2) >= 2500 && super.anInt33 >= j + 370 && super.anInt34 >= l + 263 && super.anInt33 < j + 400 && super.anInt34 <= l + 274)
                    {
                        super.aClass14_Sub1_620.method331(145);
                        super.aClass14_Sub1_620.method343(i2);
                        super.aClass14_Sub1_620.method343(2500);
                        super.aClass14_Sub1_620.method346();
                    }
                }
            } else
            if(anInt889 > 48 && j >= 50 && j <= 115 && l <= 12)
                anInt812 = 0;
            else
            if(anInt889 > 48 && j >= 115 && j <= 180 && l <= 12)
                anInt812 = 1;
            else
            if(anInt889 > 96 && j >= 180 && j <= 245 && l <= 12)
                anInt812 = 2;
            else
            if(anInt889 > 144 && j >= 245 && j <= 310 && l <= 12)
            {
                anInt812 = 3;
            } else
            {
                super.aClass14_Sub1_620.method331(50);
                super.aClass14_Sub1_620.method346();
                aBoolean879 = false;
                return;
            }
        }
        int k = 256 - c / 2;
        int i1 = 170 - c1 / 2;
        aClass6_Sub1_724.method216(k, i1, 408, 12, 192);
        int k1 = 0x989898;
        aClass6_Sub1_724.method214(k, i1 + 12, 408, 17, k1, 160);
        aClass6_Sub1_724.method214(k, i1 + 29, 8, 204, k1, 160);
        aClass6_Sub1_724.method214(k + 399, i1 + 29, 9, 204, k1, 160);
        aClass6_Sub1_724.method214(k, i1 + 233, 408, 47, k1, 160);
        aClass6_Sub1_724.method257("Bank", k + 1, i1 + 10, 1, 0xffffff);
        int j2 = 50;
        if(anInt889 > 48)
        {
            int i3 = 0xffffff;
            if(anInt812 == 0)
                i3 = 0xff0000;
            else
            if(super.anInt33 > k + j2 && super.anInt34 >= i1 && super.anInt33 < k + j2 + 65 && super.anInt34 < i1 + 12)
                i3 = 0xffff00;
            aClass6_Sub1_724.method257("<page 1>", k + j2, i1 + 10, 1, i3);
            j2 += 65;
            i3 = 0xffffff;
            if(anInt812 == 1)
                i3 = 0xff0000;
            else
            if(super.anInt33 > k + j2 && super.anInt34 >= i1 && super.anInt33 < k + j2 + 65 && super.anInt34 < i1 + 12)
                i3 = 0xffff00;
            aClass6_Sub1_724.method257("<page 2>", k + j2, i1 + 10, 1, i3);
            j2 += 65;
        }
        if(anInt889 > 96)
        {
            int j3 = 0xffffff;
            if(anInt812 == 2)
                j3 = 0xff0000;
            else
            if(super.anInt33 > k + j2 && super.anInt34 >= i1 && super.anInt33 < k + j2 + 65 && super.anInt34 < i1 + 12)
                j3 = 0xffff00;
            aClass6_Sub1_724.method257("<page 3>", k + j2, i1 + 10, 1, j3);
            j2 += 65;
        }
        if(anInt889 > 144)
        {
            int k3 = 0xffffff;
            if(anInt812 == 3)
                k3 = 0xff0000;
            else
            if(super.anInt33 > k + j2 && super.anInt34 >= i1 && super.anInt33 < k + j2 + 65 && super.anInt34 < i1 + 12)
                k3 = 0xffff00;
            aClass6_Sub1_724.method257("<page 4>", k + j2, i1 + 10, 1, k3);
            j2 += 65;
        }
        int l3 = 0xffffff;
        if(super.anInt33 > k + 320 && super.anInt34 >= i1 && super.anInt33 < k + 408 && super.anInt34 < i1 + 12)
            l3 = 0xff0000;
        aClass6_Sub1_724.method254("Close window", k + 406, i1 + 10, 1, l3);
        aClass6_Sub1_724.method257("Number in bank in green", k + 7, i1 + 24, 1, 65280);
        aClass6_Sub1_724.method257("Number held in blue", k + 289, i1 + 24, 1, 65535);
        int j4 = 0xd0d0d0;
        int l4 = anInt812 * 48;
        for(int i5 = 0; i5 < 6; i5++)
        {
            for(int k5 = 0; k5 < 8; k5++)
            {
                int i6 = k + 7 + k5 * 49;
                int l6 = i1 + 28 + i5 * 34;
                if(anInt834 == l4)
                    aClass6_Sub1_724.method214(i6, l6, 49, 34, 0xff0000, 160);
                else
                    aClass6_Sub1_724.method214(i6, l6, 49, 34, j4, 160);
                aClass6_Sub1_724.method217(i6, l6, 50, 35, 0);
                if(l4 < anInt889 && anIntArray955[l4] != -1)
                {
                    aClass6_Sub1_724.method247(i6, l6, 48, 32, anInt950 + Class1.anIntArray53[anIntArray955[l4]], Class1.anIntArray58[anIntArray955[l4]], 0, 0, false);
                    aClass6_Sub1_724.method257(String.valueOf(anIntArray956[l4]), i6 + 1, l6 + 10, 1, 65280);
                    aClass6_Sub1_724.method254(String.valueOf(method58(anIntArray955[l4])), i6 + 47, l6 + 29, 1, 65535);
                }
                l4++;
            }

        }

        aClass6_Sub1_724.method218(k + 5, i1 + 256, 398, 0);
        if(anInt834 == -1)
        {
            aClass6_Sub1_724.method255("Select an object to withdraw or deposit", k + 204, i1 + 248, 3, 0xffff00);
            return;
        }
        int j5;
        if(anInt834 < 0)
            j5 = -1;
        else
            j5 = anIntArray955[anInt834];
        if(j5 != -1)
        {
            int l5 = anIntArray956[anInt834];
            if(Class1.anIntArray55[j5] == 1 && l5 > 1)
                l5 = 1;
            if(l5 > 0)
            {
                aClass6_Sub1_724.method257("Withdraw " + Class1.aStringArray109[j5], k + 2, i1 + 248, 1, 0xffffff);
                int j6 = 0xffffff;
                if(super.anInt33 >= k + 220 && super.anInt34 >= i1 + 238 && super.anInt33 < k + 250 && super.anInt34 <= i1 + 249)
                    j6 = 0xff0000;
                aClass6_Sub1_724.method257("One", k + 222, i1 + 248, 1, j6);
                if(l5 >= 5)
                {
                    int i7 = 0xffffff;
                    if(super.anInt33 >= k + 250 && super.anInt34 >= i1 + 238 && super.anInt33 < k + 280 && super.anInt34 <= i1 + 249)
                        i7 = 0xff0000;
                    aClass6_Sub1_724.method257("Five", k + 252, i1 + 248, 1, i7);
                }
                if(l5 >= 25)
                {
                    int j7 = 0xffffff;
                    if(super.anInt33 >= k + 280 && super.anInt34 >= i1 + 238 && super.anInt33 < k + 305 && super.anInt34 <= i1 + 249)
                        j7 = 0xff0000;
                    aClass6_Sub1_724.method257("25", k + 282, i1 + 248, 1, j7);
                }
                if(l5 >= 100)
                {
                    int k7 = 0xffffff;
                    if(super.anInt33 >= k + 305 && super.anInt34 >= i1 + 238 && super.anInt33 < k + 335 && super.anInt34 <= i1 + 249)
                        k7 = 0xff0000;
                    aClass6_Sub1_724.method257("100", k + 307, i1 + 248, 1, k7);
                }
                if(l5 >= 500)
                {
                    int l7 = 0xffffff;
                    if(super.anInt33 >= k + 335 && super.anInt34 >= i1 + 238 && super.anInt33 < k + 368 && super.anInt34 <= i1 + 249)
                        l7 = 0xff0000;
                    aClass6_Sub1_724.method257("500", k + 337, i1 + 248, 1, l7);
                }
                if(l5 >= 2500)
                {
                    int i8 = 0xffffff;
                    if(super.anInt33 >= k + 370 && super.anInt34 >= i1 + 238 && super.anInt33 < k + 400 && super.anInt34 <= i1 + 249)
                        i8 = 0xff0000;
                    aClass6_Sub1_724.method257("2500", k + 370, i1 + 248, 1, i8);
                }
            }
            if(method58(j5) > 0)
            {
                aClass6_Sub1_724.method257("Deposit " + Class1.aStringArray109[j5], k + 2, i1 + 273, 1, 0xffffff);
                int k6 = 0xffffff;
                if(super.anInt33 >= k + 220 && super.anInt34 >= i1 + 263 && super.anInt33 < k + 250 && super.anInt34 <= i1 + 274)
                    k6 = 0xff0000;
                aClass6_Sub1_724.method257("One", k + 222, i1 + 273, 1, k6);
                if(method58(j5) >= 5)
                {
                    int j8 = 0xffffff;
                    if(super.anInt33 >= k + 250 && super.anInt34 >= i1 + 263 && super.anInt33 < k + 280 && super.anInt34 <= i1 + 274)
                        j8 = 0xff0000;
                    aClass6_Sub1_724.method257("Five", k + 252, i1 + 273, 1, j8);
                }
                if(method58(j5) >= 25)
                {
                    int k8 = 0xffffff;
                    if(super.anInt33 >= k + 280 && super.anInt34 >= i1 + 263 && super.anInt33 < k + 305 && super.anInt34 <= i1 + 274)
                        k8 = 0xff0000;
                    aClass6_Sub1_724.method257("25", k + 282, i1 + 273, 1, k8);
                }
                if(method58(j5) >= 100)
                {
                    int l8 = 0xffffff;
                    if(super.anInt33 >= k + 305 && super.anInt34 >= i1 + 263 && super.anInt33 < k + 335 && super.anInt34 <= i1 + 274)
                        l8 = 0xff0000;
                    aClass6_Sub1_724.method257("100", k + 307, i1 + 273, 1, l8);
                }
                if(method58(j5) >= 500)
                {
                    int i9 = 0xffffff;
                    if(super.anInt33 >= k + 335 && super.anInt34 >= i1 + 263 && super.anInt33 < k + 368 && super.anInt34 <= i1 + 274)
                        i9 = 0xff0000;
                    aClass6_Sub1_724.method257("500", k + 337, i1 + 273, 1, i9);
                }
                if(method58(j5) >= 2500)
                {
                    int j9 = 0xffffff;
                    if(super.anInt33 >= k + 370 && super.anInt34 >= i1 + 263 && super.anInt33 < k + 400 && super.anInt34 <= i1 + 274)
                        j9 = 0xff0000;
                    aClass6_Sub1_724.method257("2500", k + 370, i1 + 273, 1, j9);
                }
            }
        }
    }

    private final void method82()
    {
        int i = Class1.anInt144;
        if(anInt749 > 1)
            anInt749--;
        method25();
        if(anInt746 > 0)
            anInt746--;
        if(super.anInt12 > 4500 && anInt869 == 0 && anInt746 == 0)
        {
            super.anInt12 -= 500;
            method71();
            return;
        }
        if(aClass2_975.anInt153 == 8 || aClass2_975.anInt153 == 9)
            anInt869 = 500;
        if(anInt869 > 0)
            anInt869--;
        if(aBoolean992)
        {
            method120();
            return;
        }
        for(int j = 0; j < anInt742; j++)
        {
            Class2 class2 = aClass2Array983[j];
            int j4 = (class2.anInt156 + 1) % 10;
            if(class2.anInt155 != j4)
            {
                int l5 = -1;
                int j6 = class2.anInt155;
                int l6;
                if(j6 < j4)
                    l6 = j4 - j6;
                else
                    l6 = (10 + j4) - j6;
                int j7 = 4;
                if(l6 > 2)
                    j7 = (l6 - 1) * 4;
                if(class2.anIntArray157[j6] - class2.anInt149 > anInt946 * 3 || class2.anIntArray158[j6] - class2.anInt150 > anInt946 * 3 || class2.anIntArray157[j6] - class2.anInt149 < -anInt946 * 3 || class2.anIntArray158[j6] - class2.anInt150 < -anInt946 * 3 || l6 > 8)
                {
                    class2.anInt149 = class2.anIntArray157[j6];
                    class2.anInt150 = class2.anIntArray158[j6];
                } else
                {
                    if(class2.anInt149 < class2.anIntArray157[j6])
                    {
                        class2.anInt149 += j7;
                        class2.anInt152++;
                        l5 = 2;
                    } else
                    if(class2.anInt149 > class2.anIntArray157[j6])
                    {
                        class2.anInt149 -= j7;
                        class2.anInt152++;
                        l5 = 6;
                    }
                    if(class2.anInt149 - class2.anIntArray157[j6] < j7 && class2.anInt149 - class2.anIntArray157[j6] > -j7)
                        class2.anInt149 = class2.anIntArray157[j6];
                    if(class2.anInt150 < class2.anIntArray158[j6])
                    {
                        class2.anInt150 += j7;
                        class2.anInt152++;
                        if(l5 == -1)
                            l5 = 4;
                        else
                        if(l5 == 2)
                            l5 = 3;
                        else
                            l5 = 5;
                    } else
                    if(class2.anInt150 > class2.anIntArray158[j6])
                    {
                        class2.anInt150 -= j7;
                        class2.anInt152++;
                        if(l5 == -1)
                            l5 = 0;
                        else
                        if(l5 == 2)
                            l5 = 1;
                        else
                            l5 = 7;
                    }
                    if(class2.anInt150 - class2.anIntArray158[j6] < j7 && class2.anInt150 - class2.anIntArray158[j6] > -j7)
                        class2.anInt150 = class2.anIntArray158[j6];
                }
                if(l5 != -1)
                    class2.anInt153 = l5;
                if(class2.anInt149 == class2.anIntArray157[j6] && class2.anInt150 == class2.anIntArray158[j6])
                    class2.anInt155 = (j6 + 1) % 10;
            } else
            {
                class2.anInt153 = class2.anInt154;
            }
            if(class2.anInt161 > 0)
                class2.anInt161--;
            if(class2.anInt163 > 0)
                class2.anInt163--;
            if(class2.anInt167 > 0)
                class2.anInt167--;
            if(anInt993 <= 0)
                continue;
            anInt993--;
            if(anInt993 == 0)
                method118("You have been granted another life. Be more careful this time!", 3);
            if(anInt993 == 0)
                method118("You retain your skills. Your objects land where you died", 3);
        }

        for(int k = 0; k < anInt905; k++)
        {
            Class2 class2_1 = aClass2Array768[k];
            int k4 = (class2_1.anInt156 + 1) % 10;
            if(class2_1.anInt155 != k4)
            {
                int i6 = -1;
                int k6 = class2_1.anInt155;
                int i7;
                if(k6 < k4)
                    i7 = k4 - k6;
                else
                    i7 = (10 + k4) - k6;
                int k7 = 4;
                if(i7 > 2)
                    k7 = (i7 - 1) * 4;
                if(class2_1.anIntArray157[k6] - class2_1.anInt149 > anInt946 * 3 || class2_1.anIntArray158[k6] - class2_1.anInt150 > anInt946 * 3 || class2_1.anIntArray157[k6] - class2_1.anInt149 < -anInt946 * 3 || class2_1.anIntArray158[k6] - class2_1.anInt150 < -anInt946 * 3 || i7 > 8)
                {
                    class2_1.anInt149 = class2_1.anIntArray157[k6];
                    class2_1.anInt150 = class2_1.anIntArray158[k6];
                } else
                {
                    if(class2_1.anInt149 < class2_1.anIntArray157[k6])
                    {
                        class2_1.anInt149 += k7;
                        class2_1.anInt152++;
                        i6 = 2;
                    } else
                    if(class2_1.anInt149 > class2_1.anIntArray157[k6])
                    {
                        class2_1.anInt149 -= k7;
                        class2_1.anInt152++;
                        i6 = 6;
                    }
                    if(class2_1.anInt149 - class2_1.anIntArray157[k6] < k7 && class2_1.anInt149 - class2_1.anIntArray157[k6] > -k7)
                        class2_1.anInt149 = class2_1.anIntArray157[k6];
                    if(class2_1.anInt150 < class2_1.anIntArray158[k6])
                    {
                        class2_1.anInt150 += k7;
                        class2_1.anInt152++;
                        if(i6 == -1)
                            i6 = 4;
                        else
                        if(i6 == 2)
                            i6 = 3;
                        else
                            i6 = 5;
                    } else
                    if(class2_1.anInt150 > class2_1.anIntArray158[k6])
                    {
                        class2_1.anInt150 -= k7;
                        class2_1.anInt152++;
                        if(i6 == -1)
                            i6 = 0;
                        else
                        if(i6 == 2)
                            i6 = 1;
                        else
                            i6 = 7;
                    }
                    if(class2_1.anInt150 - class2_1.anIntArray158[k6] < k7 && class2_1.anInt150 - class2_1.anIntArray158[k6] > -k7)
                        class2_1.anInt150 = class2_1.anIntArray158[k6];
                }
                if(i6 != -1)
                    class2_1.anInt153 = i6;
                if(class2_1.anInt149 == class2_1.anIntArray157[k6] && class2_1.anInt150 == class2_1.anIntArray158[k6])
                    class2_1.anInt155 = (k6 + 1) % 10;
            } else
            {
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

        if(anInt915 != 2)
        {
            if(Class6.anInt346 > 0)
                anInt884++;
            if(Class6.anInt347 > 0)
                anInt884 = 0;
            Class6.anInt346 = 0;
            Class6.anInt347 = 0;
        }
        for(int l = 0; l < anInt742; l++)
        {
            Class2 class2_2 = aClass2Array983[l];
            if(class2_2.anInt176 > 0)
                class2_2.anInt176--;
        }

        if(aBoolean757)
        {
            if(anInt714 - aClass2_975.anInt149 < -500 || anInt714 - aClass2_975.anInt149 > 500 || anInt715 - aClass2_975.anInt150 < -500 || anInt715 - aClass2_975.anInt150 > 500)
            {
                anInt714 = aClass2_975.anInt149;
                anInt715 = aClass2_975.anInt150;
            }
        } else
        {
            if(anInt714 - aClass2_975.anInt149 < -500 || anInt714 - aClass2_975.anInt149 > 500 || anInt715 - aClass2_975.anInt150 < -500 || anInt715 - aClass2_975.anInt150 > 500)
            {
                anInt714 = aClass2_975.anInt149;
                anInt715 = aClass2_975.anInt150;
            }
            if(anInt714 != aClass2_975.anInt149)
                anInt714 += (aClass2_975.anInt149 - anInt714) / (16 + (anInt683 - 500) / 15);
            if(anInt715 != aClass2_975.anInt150)
                anInt715 += (aClass2_975.anInt150 - anInt715) / (16 + (anInt683 - 500) / 15);
            if(aBoolean675)
            {
                int i1 = anInt940 * 32;
                int k2 = i1 - anInt729;
                byte byte0 = 1;
                if(k2 != 0)
                {
                    anInt941++;
                    if(k2 > 128)
                    {
                        byte0 = -1;
                        k2 = 256 - k2;
                    } else
                    if(k2 > 0)
                        byte0 = 1;
                    else
                    if(k2 < -128)
                    {
                        byte0 = 1;
                        k2 = 256 + k2;
                    } else
                    if(k2 < 0)
                    {
                        byte0 = -1;
                        k2 = -k2;
                    }
                    anInt729 += ((anInt941 * k2 + 255) / 256) * byte0;
                    anInt729 &= 0xff;
                } else
                {
                    anInt941 = 0;
                }
            }
        }
        if(anInt884 > 20)
        {
            aBoolean880 = false;
            anInt884 = 0;
        }
        if(aBoolean870)
        {
            if(super.aString41.length() > 0)
                if(super.aString41.equalsIgnoreCase("::lostcon") && !aBoolean979)
                    super.aClass14_Sub1_620.method329();
                else
                if(super.aString41.equalsIgnoreCase("::closecon") && !aBoolean979)
                {
                    method22();
                } else
                {
                    super.aClass14_Sub1_620.method331(60);
                    super.aClass14_Sub1_620.method347(super.aString41);
                    if(!aBoolean880)
                    {
                        super.aClass14_Sub1_620.method348(0);
                        aBoolean880 = true;
                    }
                    super.aClass14_Sub1_620.method346();
                    super.aString40 = "";
                    super.aString41 = "";
                    aString846 = "Please wait...";
                }
            if(super.anInt36 == 1 && super.anInt34 > 275 && super.anInt34 < 310 && super.anInt33 > 56 && super.anInt33 < 456)
            {
                super.aClass14_Sub1_620.method331(60);
                super.aClass14_Sub1_620.method347("-null-");
                if(!aBoolean880)
                {
                    super.aClass14_Sub1_620.method348(0);
                    aBoolean880 = true;
                }
                super.aClass14_Sub1_620.method346();
                super.aString40 = "";
                super.aString41 = "";
                aString846 = "Please wait...";
            }
            super.anInt36 = 0;
            return;
        }
        if(super.anInt34 > anInt677 - 4)
        {
            if(super.anInt33 > 15 && super.anInt33 < 96 && super.anInt36 == 1)
                anInt780 = 0;
            if(super.anInt33 > 110 && super.anInt33 < 194 && super.anInt36 == 1)
            {
                anInt780 = 1;
                aClass4_775.anIntArray187[anInt776] = 0xf423f;
            }
            if(super.anInt33 > 215 && super.anInt33 < 295 && super.anInt36 == 1)
            {
                anInt780 = 2;
                aClass4_775.anIntArray187[anInt778] = 0xf423f;
            }
            if(super.anInt33 > 315 && super.anInt33 < 395 && super.anInt36 == 1)
            {
                anInt780 = 3;
                aClass4_775.anIntArray187[anInt779] = 0xf423f;
            }
            if(super.anInt33 > 417 && super.anInt33 < 497 && super.anInt36 == 1)
            {
                anInt986 = 1;
                anInt863 = 0;
                super.aString40 = "";
                super.aString41 = "";
            }
            super.anInt36 = 0;
            super.anInt35 = 0;
        }
        aClass4_775.method139(super.anInt33, super.anInt34, super.anInt36, super.anInt35);
        if(anInt780 > 0 && super.anInt33 >= 494 && super.anInt34 >= anInt677 - 66)
            super.anInt36 = 0;
        if(aClass4_775.method140(anInt777))
        {
            String s = aClass4_775.method170(anInt777);
            aClass4_775.method169(anInt777, "");
            if(s.startsWith("::"))
            {
                if(s.equalsIgnoreCase("::closecon") && !aBoolean979)
                    super.aClass14_Sub1_620.method329();
                else
                if(s.equalsIgnoreCase("::logout") && !aBoolean979)
                    method22();
                else
                if(s.equalsIgnoreCase("::lostcon") && !aBoolean979)
                    method23();
                else
                    method35(s.substring(2));
            } else
            if(s.startsWith("/") && s.startsWith("/rate"))
            {
                int l2 = s.indexOf('(');
                int l4 = s.indexOf(')');
                if(l2 != -1 && l4 != -1)
                {
                    adk = Integer.parseInt(s.substring(l2 + 1, l4));
                    method118("@blu@Rune-V: @whi@Chatspammer rate set to @red@" + s.substring(l2 + 1, l4) + " @whi@/Spam *message* to start", 3);
                }
            }
            if(s.startsWith("/"))
            {
                if(s.startsWith("/npcid"))
                {
                    int i3 = s.indexOf('(');
                    int i5 = s.indexOf(')');
                    if(i3 != -1 && i5 != -1)
                    {
                        npcnum = Integer.parseInt(s.substring(i3 + 1, i5));
                        method118("@blu@Rune-V: @whi@Autofighter NPC set to @red@" + s.substring(i3 + 1, i5) + " @whi@Press F8 to start Autofighter", 3);
                    }
                }
                if(s.startsWith("/"))
                {
                    if(s.startsWith("/arate"))
                    {
                        int j3 = s.indexOf('(');
                        int j5 = s.indexOf(')');
                        if(j3 != -1 && j5 != -1)
                        {
                            MacroTime = Integer.parseInt(s.substring(j3 + 1, j5));
                            method118("@blu@Rune-V: @whi@Autofighter delay set to @red@" + s.substring(j3 + 1, j5) + " @whi@Press F8 to start Autofighter", 3);
                        }
                    }
                    if(s.startsWith("/") && s.startsWith("/spam"))
                    {
                        spamMessage = s.substring(6);
                        chatSpammer = true;
                        spamThread = new chatSpam();
                    }
                }
            } else
            {
                int k3 = Class17.method400(s);
                method34(Class17.aByteArray569, k3);
                s = Class17.method399(Class17.aByteArray569, 0, k3);
                s = Class16.method374(s);
                aClass2_975.anInt161 = 150;
                aClass2_975.aString160 = s;
                method118(aClass2_975.aString146 + ": " + s, 2);
            }
        }
        if(anInt780 == 0)
        {
            for(int j1 = 0; j1 < 5; j1++)
                if(anIntArray935[j1] > 0)
                    anIntArray935[j1]--;

        }
        if(anInt993 != 0)
            super.anInt36 = 0;
        if(aBoolean856 || aBoolean917)
        {
            if(super.anInt35 != 0)
                anInt818++;
            else
                anInt818 = 0;
            if(anInt818 > 600)
                anInt819 += 5000;
            else
            if(anInt818 > 450)
                anInt819 += 500;
            else
            if(anInt818 > 300)
                anInt819 += 50;
            else
            if(anInt818 > 150)
                anInt819 += 5;
            else
            if(anInt818 > 50)
                anInt819++;
            else
            if(anInt818 > 20 && (anInt818 & 5) == 0)
                anInt819++;
        } else
        {
            anInt818 = 0;
            anInt819 = 0;
        }
        if(super.anInt36 == 1)
            anInt813 = 1;
        else
        if(super.anInt36 == 2)
            anInt813 = 2;
        aClass10_739.method277(super.anInt33, super.anInt34);
        super.anInt36 = 0;
        if(aBoolean675)
        {
            if(anInt941 == 0 || aBoolean757)
            {
                if(super.aBoolean26)
                {
                    anInt940 = anInt940 + 1 & 7;
                    super.aBoolean26 = false;
                    if(!aBoolean789)
                    {
                        if((anInt940 & 1) == 0)
                            anInt940 = anInt940 + 1 & 7;
                        for(int k1 = 0; k1 < 8 && !method112(anInt940); k1++)
                            anInt940 = anInt940 + 1 & 7;

                    }
                }
                if(super.aBoolean27)
                {
                    anInt940 = anInt940 + 7 & 7;
                    super.aBoolean27 = false;
                    if(!aBoolean789)
                    {
                        if((anInt940 & 1) == 0)
                            anInt940 = anInt940 + 7 & 7;
                        for(int l1 = 0; l1 < 8 && !method112(anInt940); l1++)
                            anInt940 = anInt940 + 7 & 7;

                    }
                }
            }
        } else
        if(super.aBoolean26)
            anInt729 = anInt729 + 2 & 0xff;
        else
        if(super.aBoolean27)
            anInt729 = anInt729 - 2 & 0xff;
        if(anInt670 > 0)
            anInt670--;
        else
        if(anInt670 < 0)
            anInt670++;
        aClass10_739.method307(17);
        anInt964++;
        if(anInt964 > 5)
        {
            anInt964 = 0;
            anInt839 = (anInt839 + 1) % 3;
            anInt840 = (anInt840 + 1) % 4;
            anInt841 = (anInt841 + 1) % 5;
        }
        for(int i2 = 0; i2 < anInt796; i2++)
        {
            int l3 = anIntArray760[i2];
            int k5 = anIntArray761[i2];
            if(l3 >= 0 && k5 >= 0 && l3 < 96 && k5 < 96 && anIntArray762[i2] == 74)
                aClass5Array814[i2].method189(1, 0, 0);
        }

        for(int j2 = 0; j2 < anInt833; j2++)
        {
            anIntArray972[j2]++;
            if(anIntArray972[j2] <= 50)
                continue;
            anInt833--;
            for(int i4 = j2; i4 < anInt833; i4++)
            {
                anIntArray881[i4] = anIntArray881[i4 + 1];
                anIntArray934[i4] = anIntArray934[i4 + 1];
                anIntArray972[i4] = anIntArray972[i4 + 1];
                anIntArray730[i4] = anIntArray730[i4 + 1];
            }

        }

    }

    private final boolean method83(int i, int j, int k, int l, int i1, int j1, boolean flag, 
            boolean flag1)
    {
        int k1 = Class1.anInt144;
        int l1 = aClass19_883.method411(i, j, k, l, i1, j1, anIntArray962, anIntArray963, flag);
        if(l1 == -1)
            if(flag1)
            {
                l1 = 1;
                anIntArray962[0] = k;
                anIntArray963[0] = l;
            } else
            {
                return false;
            }
        l1--;
        i = anIntArray962[l1];
        j = anIntArray963[l1];
        l1--;
        if(flag1)
            super.aClass14_Sub1_620.method331(230);
        else
            super.aClass14_Sub1_620.method331(21);
        super.aClass14_Sub1_620.method343(i + anInt783);
        super.aClass14_Sub1_620.method343(j + anInt784);
        if(flag1 && l1 == -1 && (i + anInt783) % 5 == 0)
            l1 = 0;
        for(int i2 = l1; i2 >= 0 && i2 > l1 - 25; i2--)
        {
            super.aClass14_Sub1_620.method348(anIntArray962[i2] - i);
            super.aClass14_Sub1_620.method348(anIntArray963[i2] - j);
        }

        super.aClass14_Sub1_620.method346();
        anInt670 = -24;
        anInt671 = super.anInt33;
        anInt672 = super.anInt34;
        return true;
    }

    private final boolean method84(int i, int j, int k, int l, int i1, int j1, boolean flag, 
            boolean flag1)
    {
        int k1 = Class1.anInt144;
        int l1 = aClass19_883.method411(i, j, k, l, i1, j1, anIntArray962, anIntArray963, flag);
        if(l1 == -1)
            return false;
        l1--;
        i = anIntArray962[l1];
        j = anIntArray963[l1];
        l1--;
        if(flag1)
            super.aClass14_Sub1_620.method331(230);
        else
            super.aClass14_Sub1_620.method331(21);
        super.aClass14_Sub1_620.method343(i + anInt783);
        super.aClass14_Sub1_620.method343(j + anInt784);
        if(flag1 && l1 == -1 && (i + anInt783) % 5 == 0)
            l1 = 0;
        for(int i2 = l1; i2 >= 0 && i2 > l1 - 25; i2--)
        {
            super.aClass14_Sub1_620.method348(anIntArray962[i2] - i);
            super.aClass14_Sub1_620.method348(anIntArray963[i2] - j);
        }

        super.aClass14_Sub1_620.method346();
        anInt670 = -24;
        anInt671 = super.anInt33;
        anInt672 = super.anInt34;
        return true;
    }

    private final void method85()
    {
        try
        {
            if(aClass6_Sub1_724 != null)
            {
                aClass6_Sub1_724.method224();
                aClass6_Sub1_724.anIntArray317 = null;
                aClass6_Sub1_724 = null;
            }
            if(aClass10_739 != null)
            {
                aClass10_739.method271();
                aClass10_739 = null;
            }
            aClass5Array994 = null;
            aClass5Array814 = null;
            aClass5Array781 = null;
            aClass2Array891 = null;
            aClass2Array983 = null;
            aClass2Array957 = null;
            aClass2Array768 = null;
            aClass2_975 = null;
            if(aClass19_883 != null)
            {
                aClass19_883.aClass5Array600 = null;
                aClass19_883.aClass5ArrayArray605 = (Class5[][])null;
                aClass19_883.aClass5ArrayArray603 = (Class5[][])null;
                aClass19_883.aClass5_586 = null;
                aClass19_883 = null;
            }
            System.gc();
            return;
        }
        catch(Exception exception)
        {
            return;
        }
    }

    private final void method86()
    {
        int i = Class1.anInt144;
        byte abyte0[] = null;
        byte abyte1[] = null;
        abyte0 = method18("entity" + Class18.anInt579 + ".jag", "", 30);
        if(abyte0 == null)
        {
            aBoolean922 = true;
            return;
        }
        abyte1 = Class15.method366("index.dat", 0, abyte0);
        byte abyte2[] = null;
        byte abyte3[] = null;
        if(aBoolean914)
        {
            abyte2 = method18("entity" + Class18.anInt579 + ".mem", "member graphics", 45);
            if(abyte2 == null)
            {
                aBoolean922 = true;
                return;
            }
            abyte3 = Class15.method366("index.dat", 0, abyte2);
        }
        int j = 0;
        anInt942 = 0;
        anInt943 = anInt942;
label0:
        for(int k = 0; k < Class1.anInt123; k++)
        {
            String s = Class1.aStringArray77[k];
            for(int l = 0; l < k; l++)
                if(Class1.aStringArray77[l].equalsIgnoreCase(s))
                {
                    Class1.anIntArray87[k] = Class1.anIntArray87[l];
                    continue label0;
                }

            byte abyte4[] = Class15.method366(s + ".dat", 0, abyte0);
            byte abyte5[] = abyte1;
            if(abyte4 == null && aBoolean914)
            {
                abyte4 = Class15.method366(s + ".dat", 0, abyte2);
                abyte5 = abyte3;
            }
            if(abyte4 != null)
            {
                aClass6_Sub1_724.method225(anInt943, abyte4, abyte5, 15);
                j += 15;
                if(Class1.anIntArray85[k] == 1)
                {
                    byte abyte6[] = Class15.method366(s + "a.dat", 0, abyte0);
                    byte abyte8[] = abyte1;
                    if(abyte6 == null && aBoolean914)
                    {
                        abyte6 = Class15.method366(s + "a.dat", 0, abyte2);
                        abyte8 = abyte3;
                    }
                    aClass6_Sub1_724.method225(anInt943 + 15, abyte6, abyte8, 3);
                    j += 3;
                }
                if(Class1.anIntArray86[k] == 1)
                {
                    byte abyte7[] = Class15.method366(s + "f.dat", 0, abyte0);
                    byte abyte9[] = abyte1;
                    if(abyte7 == null && aBoolean914)
                    {
                        abyte7 = Class15.method366(s + "f.dat", 0, abyte2);
                        abyte9 = abyte3;
                    }
                    aClass6_Sub1_724.method225(anInt943 + 18, abyte7, abyte9, 9);
                    j += 9;
                }
                if(Class1.anIntArray84[k] != 0)
                {
                    for(int i1 = anInt943; i1 < anInt943 + 27; i1++)
                        aClass6_Sub1_724.method228(i1);

                }
            }
            Class1.anIntArray87[k] = anInt943;
            anInt943 += 27;
        }

    }

    private final void method87()
    {
        int i = Class1.anInt144;
        if(anInt813 != 0 && anInt819 == 0)
            anInt819 = 1;
        if(anInt819 > 0)
        {
            int j = super.anInt33 - 22;
            int k = super.anInt34 - 36;
            if(j >= 0 && k >= 0 && j < 468 && k < 262)
            {
                if(j > 216 && k > 30 && j < 462 && k < 235)
                {
                    int l = (j - 217) / 49 + ((k - 31) / 34) * 5;
                    if(l >= 0 && l < anInt708)
                    {
                        boolean flag1 = false;
                        int i2 = 0;
                        int k4 = anIntArray709[l];
label0:
                        for(int l5 = 0; l5 < anInt910; l5++)
                        {
                            if(anIntArray911[l5] != k4)
                                continue;
                            if(Class1.anIntArray55[k4] == 0)
                            {
                                int i7 = 0;
                                do
                                {
                                    if(i7 >= anInt819)
                                        continue label0;
                                    if(anIntArray912[l5] < anIntArray710[l])
                                        anIntArray912[l5]++;
                                    flag1 = true;
                                    i7++;
                                } while(true);
                            }
                            i2++;
                        }

                        if(method58(k4) <= i2)
                            flag1 = true;
                        if(Class1.anIntArray59[k4] == 1)
                        {
                            method118("This object cannot be added to a duel offer", 3);
                            flag1 = true;
                        }
                        if(!flag1 && anInt910 < 8)
                        {
                            anIntArray911[anInt910] = k4;
                            anIntArray912[anInt910] = 1;
                            anInt910++;
                            flag1 = true;
                        }
                        if(flag1)
                        {
                            super.aClass14_Sub1_620.method331(154);
                            super.aClass14_Sub1_620.method348(anInt910);
                            for(int i6 = 0; i6 < anInt910; i6++)
                            {
                                super.aClass14_Sub1_620.method343(anIntArray911[i6]);
                                super.aClass14_Sub1_620.method332(anIntArray912[i6]);
                            }

                            super.aClass14_Sub1_620.method346();
                            aBoolean668 = false;
                            aBoolean669 = false;
                        }
                    }
                }
                if(j > 8 && k > 30 && j < 205 && k < 129)
                {
                    int i1 = (j - 9) / 49 + ((k - 31) / 34) * 4;
                    if(i1 >= 0 && i1 < anInt910)
                    {
                        int k1 = anIntArray911[i1];
                        int j2 = 0;
                        do
                        {
                            if(j2 >= anInt819)
                                break;
                            if(Class1.anIntArray55[k1] == 0 && anIntArray912[i1] > 1)
                            {
                                anIntArray912[i1]--;
                            } else
                            {
                                anInt910--;
                                anInt818 = 0;
                                for(int l4 = i1; l4 < anInt910; l4++)
                                {
                                    anIntArray911[l4] = anIntArray911[l4 + 1];
                                    anIntArray912[l4] = anIntArray912[l4 + 1];
                                }

                                break;
                            }
                            j2++;
                        } while(true);
                        super.aClass14_Sub1_620.method331(154);
                        super.aClass14_Sub1_620.method348(anInt910);
                        for(int k2 = 0; k2 < anInt910; k2++)
                        {
                            super.aClass14_Sub1_620.method343(anIntArray911[k2]);
                            super.aClass14_Sub1_620.method332(anIntArray912[k2]);
                        }

                        super.aClass14_Sub1_620.method346();
                        aBoolean668 = false;
                        aBoolean669 = false;
                    }
                }
                boolean flag = false;
                if(j >= 93 && k >= 221 && j <= 104 && k <= 232)
                {
                    aBoolean718 = !aBoolean718;
                    flag = true;
                }
                if(j >= 93 && k >= 240 && j <= 104 && k <= 251)
                {
                    aBoolean719 = !aBoolean719;
                    flag = true;
                }
                if(j >= 191 && k >= 221 && j <= 202 && k <= 232)
                {
                    aBoolean720 = !aBoolean720;
                    flag = true;
                }
                if(j >= 191 && k >= 240 && j <= 202 && k <= 251)
                {
                    aBoolean721 = !aBoolean721;
                    flag = true;
                }
                if(flag)
                {
                    super.aClass14_Sub1_620.method331(10);
                    super.aClass14_Sub1_620.method348(aBoolean718 ? 1 : 0);
                    super.aClass14_Sub1_620.method348(aBoolean719 ? 1 : 0);
                    super.aClass14_Sub1_620.method348(aBoolean720 ? 1 : 0);
                    super.aClass14_Sub1_620.method348(aBoolean721 ? 1 : 0);
                    super.aClass14_Sub1_620.method346();
                    aBoolean668 = false;
                    aBoolean669 = false;
                }
                if(j >= 217 && k >= 238 && j <= 286 && k <= 259)
                {
                    aBoolean669 = true;
                    super.aClass14_Sub1_620.method331(245);
                    super.aClass14_Sub1_620.method346();
                }
                if(j >= 394 && k >= 238 && j < 463 && k < 259)
                {
                    aBoolean917 = false;
                    super.aClass14_Sub1_620.method331(82);
                    super.aClass14_Sub1_620.method346();
                }
            } else
            if(anInt813 != 0)
            {
                aBoolean917 = false;
                super.aClass14_Sub1_620.method331(82);
                super.aClass14_Sub1_620.method346();
            }
            anInt813 = 0;
            anInt819 = 0;
        }
        if(!aBoolean917)
            return;
        byte byte0 = 22;
        byte byte1 = 36;
        aClass6_Sub1_724.method216(byte0, byte1, 468, 12, 0xc90b1d);
        int j1 = 0x989898;
        aClass6_Sub1_724.method214(byte0, byte1 + 12, 468, 18, j1, 160);
        aClass6_Sub1_724.method214(byte0, byte1 + 30, 8, 248, j1, 160);
        aClass6_Sub1_724.method214(byte0 + 205, byte1 + 30, 11, 248, j1, 160);
        aClass6_Sub1_724.method214(byte0 + 462, byte1 + 30, 6, 248, j1, 160);
        aClass6_Sub1_724.method214(byte0 + 8, byte1 + 99, 197, 24, j1, 160);
        aClass6_Sub1_724.method214(byte0 + 8, byte1 + 192, 197, 23, j1, 160);
        aClass6_Sub1_724.method214(byte0 + 8, byte1 + 258, 197, 20, j1, 160);
        aClass6_Sub1_724.method214(byte0 + 216, byte1 + 235, 246, 43, j1, 160);
        int l1 = 0xd0d0d0;
        aClass6_Sub1_724.method214(byte0 + 8, byte1 + 30, 197, 69, l1, 160);
        aClass6_Sub1_724.method214(byte0 + 8, byte1 + 123, 197, 69, l1, 160);
        aClass6_Sub1_724.method214(byte0 + 8, byte1 + 215, 197, 43, l1, 160);
        aClass6_Sub1_724.method214(byte0 + 216, byte1 + 30, 246, 205, l1, 160);
        for(int l2 = 0; l2 < 3; l2++)
            aClass6_Sub1_724.method218(byte0 + 8, byte1 + 30 + l2 * 34, 197, 0);

        for(int i3 = 0; i3 < 3; i3++)
            aClass6_Sub1_724.method218(byte0 + 8, byte1 + 123 + i3 * 34, 197, 0);

        for(int j3 = 0; j3 < 7; j3++)
            aClass6_Sub1_724.method218(byte0 + 216, byte1 + 30 + j3 * 34, 246, 0);

        for(int k3 = 0; k3 < 6; k3++)
        {
            if(k3 < 5)
                aClass6_Sub1_724.method219(byte0 + 8 + k3 * 49, byte1 + 30, 69, 0);
            if(k3 < 5)
                aClass6_Sub1_724.method219(byte0 + 8 + k3 * 49, byte1 + 123, 69, 0);
            aClass6_Sub1_724.method219(byte0 + 216 + k3 * 49, byte1 + 30, 205, 0);
        }

        aClass6_Sub1_724.method218(byte0 + 8, byte1 + 215, 197, 0);
        aClass6_Sub1_724.method218(byte0 + 8, byte1 + 257, 197, 0);
        aClass6_Sub1_724.method219(byte0 + 8, byte1 + 215, 43, 0);
        aClass6_Sub1_724.method219(byte0 + 204, byte1 + 215, 43, 0);
        aClass6_Sub1_724.method257("Preparing to duel with: " + aString824, byte0 + 1, byte1 + 10, 1, 0xffffff);
        aClass6_Sub1_724.method257("Your Stake", byte0 + 9, byte1 + 27, 4, 0xffffff);
        aClass6_Sub1_724.method257("Opponent's Stake", byte0 + 9, byte1 + 120, 4, 0xffffff);
        aClass6_Sub1_724.method257("Duel Options", byte0 + 9, byte1 + 212, 4, 0xffffff);
        aClass6_Sub1_724.method257("Your Inventory", byte0 + 216, byte1 + 27, 4, 0xffffff);
        aClass6_Sub1_724.method257("No retreating", byte0 + 8 + 1, byte1 + 215 + 16, 3, 0xffff00);
        aClass6_Sub1_724.method257("No magic", byte0 + 8 + 1, byte1 + 215 + 35, 3, 0xffff00);
        aClass6_Sub1_724.method257("No prayer", byte0 + 8 + 102, byte1 + 215 + 16, 3, 0xffff00);
        aClass6_Sub1_724.method257("No weapons", byte0 + 8 + 102, byte1 + 215 + 35, 3, 0xffff00);
        aClass6_Sub1_724.method217(byte0 + 93, byte1 + 215 + 6, 11, 11, 0xffff00);
        if(aBoolean718)
            aClass6_Sub1_724.method216(byte0 + 95, byte1 + 215 + 8, 7, 7, 0xffff00);
        aClass6_Sub1_724.method217(byte0 + 93, byte1 + 215 + 25, 11, 11, 0xffff00);
        if(aBoolean719)
            aClass6_Sub1_724.method216(byte0 + 95, byte1 + 215 + 27, 7, 7, 0xffff00);
        aClass6_Sub1_724.method217(byte0 + 191, byte1 + 215 + 6, 11, 11, 0xffff00);
        if(aBoolean720)
            aClass6_Sub1_724.method216(byte0 + 193, byte1 + 215 + 8, 7, 7, 0xffff00);
        aClass6_Sub1_724.method217(byte0 + 191, byte1 + 215 + 25, 11, 11, 0xffff00);
        if(aBoolean721)
            aClass6_Sub1_724.method216(byte0 + 193, byte1 + 215 + 27, 7, 7, 0xffff00);
        if(!aBoolean669)
            aClass6_Sub1_724.method231(byte0 + 217, byte1 + 238, anInt948 + 25);
        aClass6_Sub1_724.method231(byte0 + 394, byte1 + 238, anInt948 + 26);
        if(aBoolean668)
        {
            aClass6_Sub1_724.method255("Other player", byte0 + 341, byte1 + 246, 1, 0xffffff);
            aClass6_Sub1_724.method255("has accepted", byte0 + 341, byte1 + 256, 1, 0xffffff);
        }
        if(aBoolean669)
        {
            aClass6_Sub1_724.method255("Waiting for", byte0 + 217 + 35, byte1 + 246, 1, 0xffffff);
            aClass6_Sub1_724.method255("other player", byte0 + 217 + 35, byte1 + 256, 1, 0xffffff);
        }
        for(int l3 = 0; l3 < anInt708; l3++)
        {
            int i5 = 217 + byte0 + (l3 % 5) * 49;
            int j6 = 31 + byte1 + (l3 / 5) * 34;
            aClass6_Sub1_724.method247(i5, j6, 48, 32, anInt950 + Class1.anIntArray53[anIntArray709[l3]], Class1.anIntArray58[anIntArray709[l3]], 0, 0, false);
            if(Class1.anIntArray55[anIntArray709[l3]] == 0)
                aClass6_Sub1_724.method257(String.valueOf(anIntArray710[l3]), i5 + 1, j6 + 10, 1, 0xffff00);
        }

        for(int i4 = 0; i4 < anInt910; i4++)
        {
            int j5 = 9 + byte0 + (i4 % 4) * 49;
            int k6 = 31 + byte1 + (i4 / 4) * 34;
            aClass6_Sub1_724.method247(j5, k6, 48, 32, anInt950 + Class1.anIntArray53[anIntArray911[i4]], Class1.anIntArray58[anIntArray911[i4]], 0, 0, false);
            if(Class1.anIntArray55[anIntArray911[i4]] == 0)
                aClass6_Sub1_724.method257(String.valueOf(anIntArray912[i4]), j5 + 1, k6 + 10, 1, 0xffff00);
            if(super.anInt33 > j5 && super.anInt33 < j5 + 48 && super.anInt34 > k6 && super.anInt34 < k6 + 32)
                aClass6_Sub1_724.method257(Class1.aStringArray109[anIntArray911[i4]] + ": @whi@" + Class1.aStringArray110[anIntArray911[i4]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }

        for(int j4 = 0; j4 < anInt959; j4++)
        {
            int k5 = 9 + byte0 + (j4 % 4) * 49;
            int l6 = 124 + byte1 + (j4 / 4) * 34;
            aClass6_Sub1_724.method247(k5, l6, 48, 32, anInt950 + Class1.anIntArray53[anIntArray960[j4]], Class1.anIntArray58[anIntArray960[j4]], 0, 0, false);
            if(Class1.anIntArray55[anIntArray960[j4]] == 0)
                aClass6_Sub1_724.method257(String.valueOf(anIntArray961[j4]), k5 + 1, l6 + 10, 1, 0xffff00);
            if(super.anInt33 > k5 && super.anInt33 < k5 + 48 && super.anInt34 > l6 && super.anInt34 < l6 + 32)
                aClass6_Sub1_724.method257(Class1.aStringArray109[anIntArray960[j4]] + ": @whi@" + Class1.aStringArray110[anIntArray960[j4]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }

    }

    private final void method88()
    {
        aClass6_Sub1_724.method216(126, 137, 260, 60, 0);
        aClass6_Sub1_724.method217(126, 137, 260, 60, 0xffffff);
        aClass6_Sub1_724.method255("Logging out...", 256, 173, 5, 0xffffff);
    }

    private final void method89(int i, String s)
    {
        int j = anIntArray760[i];
        int k = anIntArray761[i];
        int l = j - aClass2_975.anInt149 / 128;
        int i1 = k - aClass2_975.anInt150 / 128;
        byte byte0 = 7;
        if(j >= 0 && k >= 0 && j < 96 && k < 96 && l > -byte0 && l < byte0 && i1 > -byte0 && i1 < byte0)
        {
            aClass10_739.method270(aClass5Array814[i]);
            int j1 = Class1.method124(s);
            Class5 class5 = aClass5Array994[j1].method204();
            aClass10_739.method269(class5);
            class5.method185(true, 48, 48, -50, -10, -50);
            class5.method206(aClass5Array814[i]);
            class5.anInt257 = i;
            aClass5Array814[i] = class5;
        }
    }

    private final void method90()
    {
        int i = Class1.anInt144;
        byte byte0 = 7;
        byte byte1 = 15;
        char c = '\257';
        if(anInt813 != 0)
        {
            int j = 0;
            do
            {
                if(j >= 5)
                    break;
                if(j > 0 && super.anInt33 > byte0 && super.anInt33 < byte0 + c && super.anInt34 > byte1 + j * 20 && super.anInt34 < byte1 + j * 20 + 20)
                {
                    anInt750 = j - 1;
                    anInt813 = 0;
                    super.aClass14_Sub1_620.method331(119);
                    super.aClass14_Sub1_620.method348(anInt750);
                    super.aClass14_Sub1_620.method346();
                    styleCnt = anInt750;
                    break;
                }
                j++;
            } while(true);
        }
        for(int k = 0; k < 5; k++)
        {
            if(k == anInt750 + 1)
                aClass6_Sub1_724.method214(byte0, byte1 + k * 20, c, 20, Class6.method223(255, 0, 0), 128);
            else
                aClass6_Sub1_724.method214(byte0, byte1 + k * 20, c, 20, Class6.method223(190, 190, 190), 128);
            aClass6_Sub1_724.method218(byte0, byte1 + k * 20, c, 0);
            aClass6_Sub1_724.method218(byte0, byte1 + k * 20 + 20, c, 0);
        }

        aClass6_Sub1_724.method255("Rune-V Combat", byte0 + c / 2, byte1 + 16, 3, 0xffffff);
        aClass6_Sub1_724.method255("Controlled", byte0 + c / 2, byte1 + 36, 3, 0);
        aClass6_Sub1_724.method255("Strength", byte0 + c / 2, byte1 + 56, 3, 0);
        aClass6_Sub1_724.method255("Attack", byte0 + c / 2, byte1 + 76, 3, 0);
        aClass6_Sub1_724.method255("Defense", byte0 + c / 2, byte1 + 96, 3, 0);
    }

    private final void method91()
    {
        int i = Class1.anInt144;
        if(anInt811 >= 0 || anInt764 >= 0)
        {
            aStringArray985[anInt756] = "Cancel";
            aStringArray769[anInt756] = "";
            anIntArray882[anInt756] = 4000;
            anInt756++;
        }
        for(int j = 0; j < anInt756; j++)
            anIntArray984[j] = j;

        boolean flag = false;
        while(!flag) 
        {
            flag = true;
            int l = 0;
            while(l < anInt756 - 1) 
            {
                int j1 = anIntArray984[l];
                int l1 = anIntArray984[l + 1];
                if(anIntArray882[j1] > anIntArray882[l1])
                {
                    anIntArray984[l] = l1;
                    anIntArray984[l + 1] = j1;
                    flag = false;
                }
                l++;
            }
        }
        if(anInt756 > 20)
            anInt756 = 20;
        if(anInt756 > 0)
        {
            int k = -1;
            int i1 = 0;
            do
            {
                if(i1 >= anInt756)
                    break;
                if(aStringArray769[anIntArray984[i1]] != null && aStringArray769[anIntArray984[i1]].length() > 0)
                {
                    k = i1;
                    break;
                }
                i1++;
            } while(true);
            String s = null;
            if((anInt764 >= 0 || anInt811 >= 0) && anInt756 == 1)
                s = "Choose a target";
            else
            if((anInt764 >= 0 || anInt811 >= 0) && anInt756 > 1)
                s = "@whi@" + aStringArray985[anIntArray984[0]] + " " + aStringArray769[anIntArray984[0]];
            else
            if(k != -1)
                s = aStringArray769[anIntArray984[k]] + ": @whi@" + aStringArray985[anIntArray984[0]];
            if(anInt756 == 2 && s != null)
                s = s + "@whi@ / 1 more option";
            if(anInt756 > 2 && s != null)
                s = s + "@whi@ / " + (anInt756 - 1) + " more options";
            if(s != null)
                aClass6_Sub1_724.method257(s, 6, 14, 1, 0xffff00);
            if(!aBoolean767 && anInt813 == 1 || aBoolean767 && anInt813 == 1 && anInt756 == 1)
            {
                method93(anIntArray984[0]);
                anInt813 = 0;
                return;
            }
            if(!aBoolean767 && anInt813 == 2 || aBoolean767 && anInt813 == 1)
            {
                anInt755 = (anInt756 + 1) * 15;
                anInt754 = aClass6_Sub1_724.method263("Choose option", 1) + 5;
                for(int k1 = 0; k1 < anInt756; k1++)
                {
                    int i2 = aClass6_Sub1_724.method263(aStringArray985[k1] + " " + aStringArray769[k1], 1) + 5;
                    if(i2 > anInt754)
                        anInt754 = i2;
                }

                anInt752 = super.anInt33 - anInt754 / 2;
                anInt753 = super.anInt34 - 7;
                aBoolean854 = true;
                if(anInt752 < 0)
                    anInt752 = 0;
                if(anInt753 < 0)
                    anInt753 = 0;
                if(anInt752 + anInt754 > 510)
                    anInt752 = 510 - anInt754;
                if(anInt753 + anInt755 > 315)
                    anInt753 = 315 - anInt755;
                anInt813 = 0;
            }
        }
    }

    private final void method92()
    {
        int i = Class1.anInt144;
        byte byte0 = 22;
        byte byte1 = 36;
        aClass6_Sub1_724.method216(byte0, byte1, 468, 16, 192);
        int j = 0x989898;
        aClass6_Sub1_724.method214(byte0, byte1 + 16, 468, 246, j, 160);
        aClass6_Sub1_724.method255("Please confirm your trade with @yel@" + Class15.method363(aLong847), byte0 + 234, byte1 + 12, 1, 0xffffff);
        aClass6_Sub1_724.method255("You are about to give:", byte0 + 117, byte1 + 30, 1, 0xffff00);
        for(int k = 0; k < anInt836; k++)
        {
            String s = Class1.aStringArray109[anIntArray837[k]];
            if(Class1.anIntArray55[anIntArray837[k]] == 0)
                s = s + " x " + method48(anIntArray838[k]);
            aClass6_Sub1_724.method255(s, byte0 + 117, byte1 + 42 + k * 12, 1, 0xffffff);
        }

        if(anInt836 == 0)
            aClass6_Sub1_724.method255("Nothing!", byte0 + 117, byte1 + 42, 1, 0xffffff);
        aClass6_Sub1_724.method255("In return you will receive:", byte0 + 351, byte1 + 30, 1, 0xffff00);
        for(int l = 0; l < anInt691; l++)
        {
            String s1 = Class1.aStringArray109[anIntArray692[l]];
            if(Class1.anIntArray55[anIntArray692[l]] == 0)
                s1 = s1 + " x " + method48(anIntArray693[l]);
            aClass6_Sub1_724.method255(s1, byte0 + 351, byte1 + 42 + l * 12, 1, 0xffffff);
        }

        if(anInt691 == 0)
            aClass6_Sub1_724.method255("Nothing!", byte0 + 351, byte1 + 42, 1, 0xffffff);
        aClass6_Sub1_724.method255("Are you sure you want to do this?", byte0 + 234, byte1 + 200, 4, 65535);
        aClass6_Sub1_724.method255("There is NO WAY to reverse a trade if you change your mind.", byte0 + 234, byte1 + 215, 1, 0xffffff);
        aClass6_Sub1_724.method255("Remember that not all players are trustworthy", byte0 + 234, byte1 + 230, 1, 0xffffff);
        if(!aBoolean674)
        {
            aClass6_Sub1_724.method231((byte0 + 118) - 35, byte1 + 238, anInt948 + 25);
            aClass6_Sub1_724.method231((byte0 + 352) - 35, byte1 + 238, anInt948 + 26);
        } else
        {
            aClass6_Sub1_724.method255("Waiting for other player...", byte0 + 234, byte1 + 250, 1, 0xffff00);
        }
        if(anInt813 == 1)
        {
            if(super.anInt33 < byte0 || super.anInt34 < byte1 || super.anInt33 > byte0 + 468 || super.anInt34 > byte1 + 262)
            {
                aBoolean673 = false;
                super.aClass14_Sub1_620.method331(178);
                super.aClass14_Sub1_620.method346();
            }
            if(super.anInt33 >= (byte0 + 118) - 35 && super.anInt33 <= byte0 + 118 + 70 && super.anInt34 >= byte1 + 238 && super.anInt34 <= byte1 + 238 + 21)
            {
                aBoolean674 = true;
                super.aClass14_Sub1_620.method331(65);
                super.aClass14_Sub1_620.method346();
            }
            if(super.anInt33 >= (byte0 + 352) - 35 && super.anInt33 <= byte0 + 353 + 70 && super.anInt34 >= byte1 + 238 && super.anInt34 <= byte1 + 238 + 21)
            {
                aBoolean673 = false;
                super.aClass14_Sub1_620.method331(178);
                super.aClass14_Sub1_620.method346();
            }
            anInt813 = 0;
        }
    }

    private final void method93(int i)
    {
        int j = anIntArray937[i];
        int k = anIntArray938[i];
        int l = anIntArray803[i];
        int i1 = anIntArray804[i];
        int j1 = anIntArray805[i];
        int k1 = anIntArray882[i];
        if(k1 == 200)
        {
            method55(anInt976, anInt977, j, k, true);
            super.aClass14_Sub1_620.method331(31);
            super.aClass14_Sub1_620.method343(j + anInt783);
            super.aClass14_Sub1_620.method343(k + anInt784);
            super.aClass14_Sub1_620.method343(l);
            super.aClass14_Sub1_620.method343(i1);
            super.aClass14_Sub1_620.method346();
            anInt811 = -1;
        }
        if(k1 == 210)
        {
            method55(anInt976, anInt977, j, k, true);
            super.aClass14_Sub1_620.method331(70);
            super.aClass14_Sub1_620.method343(j + anInt783);
            super.aClass14_Sub1_620.method343(k + anInt784);
            super.aClass14_Sub1_620.method343(l);
            super.aClass14_Sub1_620.method343(i1);
            super.aClass14_Sub1_620.method346();
            anInt764 = -1;
        }
        if(k1 == 220)
        {
            method55(anInt976, anInt977, j, k, true);
            super.aClass14_Sub1_620.method331(104);
            super.aClass14_Sub1_620.method343(j + anInt783);
            super.aClass14_Sub1_620.method343(k + anInt784);
            super.aClass14_Sub1_620.method343(l);
            super.aClass14_Sub1_620.method343(i1);
            super.aClass14_Sub1_620.method346();
        }
        if(k1 == 3200)
            method118(Class1.aStringArray110[l], 3);
        if(k1 == 300)
        {
            method111(j, k, l);
            super.aClass14_Sub1_620.method331(48);
            super.aClass14_Sub1_620.method343(j + anInt783);
            super.aClass14_Sub1_620.method343(k + anInt784);
            super.aClass14_Sub1_620.method348(l);
            super.aClass14_Sub1_620.method343(i1);
            super.aClass14_Sub1_620.method346();
            anInt811 = -1;
        }
        if(k1 == 310)
        {
            method111(j, k, l);
            super.aClass14_Sub1_620.method331(167);
            super.aClass14_Sub1_620.method343(j + anInt783);
            super.aClass14_Sub1_620.method343(k + anInt784);
            super.aClass14_Sub1_620.method348(l);
            super.aClass14_Sub1_620.method343(i1);
            super.aClass14_Sub1_620.method346();
            anInt764 = -1;
        }
        if(k1 == 320)
        {
            method111(j, k, l);
            super.aClass14_Sub1_620.method331(114);
            super.aClass14_Sub1_620.method343(j + anInt783);
            super.aClass14_Sub1_620.method343(k + anInt784);
            super.aClass14_Sub1_620.method348(l);
            super.aClass14_Sub1_620.method346();
        }
        if(k1 == 2300)
        {
            method111(j, k, l);
            super.aClass14_Sub1_620.method331(163);
            super.aClass14_Sub1_620.method343(j + anInt783);
            super.aClass14_Sub1_620.method343(k + anInt784);
            super.aClass14_Sub1_620.method348(l);
            super.aClass14_Sub1_620.method346();
        }
        if(k1 == 3300)
            method118(Class1.aStringArray71[l], 3);
        if(k1 == 400)
        {
            method105(j, k, l, i1);
            super.aClass14_Sub1_620.method331(14);
            super.aClass14_Sub1_620.method343(j + anInt783);
            super.aClass14_Sub1_620.method343(k + anInt784);
            super.aClass14_Sub1_620.method343(j1);
            super.aClass14_Sub1_620.method346();
            anInt811 = -1;
        }
        if(k1 == 410)
        {
            method105(j, k, l, i1);
            super.aClass14_Sub1_620.method331(153);
            super.aClass14_Sub1_620.method343(j + anInt783);
            super.aClass14_Sub1_620.method343(k + anInt784);
            super.aClass14_Sub1_620.method343(j1);
            super.aClass14_Sub1_620.method346();
            anInt764 = -1;
        }
        if(k1 == 420)
        {
            method105(j, k, l, i1);
            super.aClass14_Sub1_620.method331(90);
            super.aClass14_Sub1_620.method343(j + anInt783);
            super.aClass14_Sub1_620.method343(k + anInt784);
            super.aClass14_Sub1_620.method346();
        }
        if(k1 == 2400)
        {
            method105(j, k, l, i1);
            super.aClass14_Sub1_620.method331(227);
            super.aClass14_Sub1_620.method343(j + anInt783);
            super.aClass14_Sub1_620.method343(k + anInt784);
            super.aClass14_Sub1_620.method346();
        }
        if(k1 == 3400)
            method118(Class1.aStringArray92[l], 3);
        if(k1 == 600)
        {
            super.aClass14_Sub1_620.method331(159);
            super.aClass14_Sub1_620.method343(l);
            super.aClass14_Sub1_620.method343(i1);
            super.aClass14_Sub1_620.method346();
            anInt811 = -1;
        }
        if(k1 == 610)
        {
            super.aClass14_Sub1_620.method331(172);
            super.aClass14_Sub1_620.method343(l);
            super.aClass14_Sub1_620.method343(i1);
            super.aClass14_Sub1_620.method346();
            anInt764 = -1;
        }
        if(k1 == 620)
        {
            super.aClass14_Sub1_620.method331(170);
            super.aClass14_Sub1_620.method343(l);
            super.aClass14_Sub1_620.method346();
        }
        if(k1 == 630)
        {
            super.aClass14_Sub1_620.method331(12);
            super.aClass14_Sub1_620.method343(l);
            super.aClass14_Sub1_620.method346();
        }
        if(k1 == 640)
        {
            super.aClass14_Sub1_620.method331(219);
            super.aClass14_Sub1_620.method343(l);
            super.aClass14_Sub1_620.method346();
        }
        if(k1 == 650)
        {
            anInt764 = l;
            anInt915 = 0;
            aString765 = Class1.aStringArray109[anIntArray709[anInt764]];
        }
        if(k1 == 660)
        {
            super.aClass14_Sub1_620.method331(196);
            super.aClass14_Sub1_620.method343(l);
            super.aClass14_Sub1_620.method346();
            anInt764 = -1;
            anInt915 = 0;
            method118("Dropping " + Class1.aStringArray109[anIntArray709[l]], 4);
        }
        if(k1 == 3600)
            method118(Class1.aStringArray110[l], 3);
        if(k1 == 700)
        {
            int l1 = (j - 64) / anInt946;
            int l3 = (k - 64) / anInt946;
            method99(anInt976, anInt977, l1, l3, true);
            super.aClass14_Sub1_620.method331(49);
            super.aClass14_Sub1_620.method343(l);
            super.aClass14_Sub1_620.method343(i1);
            super.aClass14_Sub1_620.method346();
            anInt811 = -1;
        }
        if(k1 == 710)
        {
            int i2 = (j - 64) / anInt946;
            int i4 = (k - 64) / anInt946;
            method99(anInt976, anInt977, i2, i4, true);
            super.aClass14_Sub1_620.method331(160);
            super.aClass14_Sub1_620.method343(l);
            super.aClass14_Sub1_620.method343(i1);
            super.aClass14_Sub1_620.method346();
            anInt764 = -1;
        }
        if(k1 == 720)
        {
            int j2 = (j - 64) / anInt946;
            int j4 = (k - 64) / anInt946;
            method99(anInt976, anInt977, j2, j4, true);
            super.aClass14_Sub1_620.method331(7);
            super.aClass14_Sub1_620.method343(l);
            super.aClass14_Sub1_620.method346();
        }
        if(k1 == 725)
        {
            int k2 = (j - 64) / anInt946;
            int k4 = (k - 64) / anInt946;
            method99(anInt976, anInt977, k2, k4, true);
            super.aClass14_Sub1_620.method331(151);
            super.aClass14_Sub1_620.method343(l);
            super.aClass14_Sub1_620.method346();
        }
        if(k1 == 715 || k1 == 2715)
        {
            int l2 = (j - 64) / anInt946;
            int l4 = (k - 64) / anInt946;
            method99(anInt976, anInt977, l2, l4, true);
            super.aClass14_Sub1_620.method331(47);
            super.aClass14_Sub1_620.method343(l);
            super.aClass14_Sub1_620.method346();
        }
        if(k1 == 3700)
            method118(Class1.aStringArray128[l], 3);
        if(k1 == 800)
        {
            int i3 = (j - 64) / anInt946;
            int i5 = (k - 64) / anInt946;
            method99(anInt976, anInt977, i3, i5, true);
            super.aClass14_Sub1_620.method331(169);
            super.aClass14_Sub1_620.method343(l);
            super.aClass14_Sub1_620.method343(i1);
            super.aClass14_Sub1_620.method346();
            anInt811 = -1;
        }
        if(k1 == 810)
        {
            int j3 = (j - 64) / anInt946;
            int j5 = (k - 64) / anInt946;
            method99(anInt976, anInt977, j3, j5, true);
            super.aClass14_Sub1_620.method331(177);
            super.aClass14_Sub1_620.method343(l);
            super.aClass14_Sub1_620.method343(i1);
            super.aClass14_Sub1_620.method346();
            anInt764 = -1;
        }
        if(k1 == 805 || k1 == 2805)
        {
            int k3 = (j - 64) / anInt946;
            int k5 = (k - 64) / anInt946;
            method99(anInt976, anInt977, k3, k5, true);
            super.aClass14_Sub1_620.method331(210);
            super.aClass14_Sub1_620.method343(l);
            super.aClass14_Sub1_620.method346();
        }
        if(k1 == 2806)
        {
            super.aClass14_Sub1_620.method331(89);
            super.aClass14_Sub1_620.method343(l);
            super.aClass14_Sub1_620.method346();
        }
        if(k1 == 2810)
        {
            super.aClass14_Sub1_620.method331(250);
            super.aClass14_Sub1_620.method343(l);
            super.aClass14_Sub1_620.method346();
        }
        if(k1 == 2820)
        {
            super.aClass14_Sub1_620.method331(36);
            super.aClass14_Sub1_620.method343(l);
            super.aClass14_Sub1_620.method346();
        }
        if(k1 == 900)
        {
            method99(anInt976, anInt977, j, k, true);
            super.aClass14_Sub1_620.method331(220);
            super.aClass14_Sub1_620.method343(j + anInt783);
            super.aClass14_Sub1_620.method343(k + anInt784);
            super.aClass14_Sub1_620.method343(l);
            super.aClass14_Sub1_620.method346();
            anInt811 = -1;
        }
        if(k1 == 920)
        {
            method99(anInt976, anInt977, j, k, false);
            if(anInt670 == -24)
                anInt670 = 24;
        }
        if(k1 == 1000)
        {
            super.aClass14_Sub1_620.method331(156);
            super.aClass14_Sub1_620.method343(l);
            super.aClass14_Sub1_620.method346();
            anInt811 = -1;
        }
        if(k1 == 4000)
        {
            anInt764 = -1;
            anInt811 = -1;
        }
    }

    private final void method94()
    {
        aClass4_775 = new Class4(aClass6_Sub1_724, 10);
        anInt776 = aClass4_775.method160(5, 269, 502, 56, 1, 20, true);
        anInt777 = aClass4_775.method161(7, 324, 498, 14, 1, 80, false, true);
        anInt778 = aClass4_775.method160(5, 269, 502, 56, 1, 20, true);
        anInt779 = aClass4_775.method160(5, 269, 502, 56, 1, 20, true);
        aClass4_775.method173(anInt777);
    }

    private final void method95()
    {
        aClass19_883.aByteArray593 = method18("maps" + Class18.anInt575 + ".jag", "", 70);
        if(aBoolean914)
            aClass19_883.aByteArray612 = method18("maps" + Class18.anInt575 + ".mem", "members map", 75);
        aClass19_883.aByteArray592 = method18("land" + Class18.anInt575 + ".jag", "", 80);
        if(aBoolean914)
            aClass19_883.aByteArray611 = method18("land" + Class18.anInt575 + ".mem", "members landscape", 85);
    }

    final void method96(int i, int j, int k, int l, int i1, int j1, int k1)
    {
        int l1 = Class1.anInt144;
        Class2 class2 = aClass2Array983[i1];
        if(class2.anInt171 == 255)
            return;
        int i2 = class2.anInt153 + (anInt729 + 16) / 32 & 7;
        boolean flag = false;
        int j2 = i2;
        if(j2 == 5)
        {
            j2 = 3;
            flag = true;
        } else
        if(j2 == 6)
        {
            j2 = 2;
            flag = true;
        } else
        if(j2 == 7)
        {
            j2 = 1;
            flag = true;
        }
        int k2 = j2 * 3 + anIntArray726[(class2.anInt152 / 6) % 4];
        if(class2.anInt153 == 8)
        {
            j2 = 5;
            i2 = 2;
            flag = false;
            i -= (5 * k1) / 100;
            k2 = j2 * 3 + anIntArray939[(anInt918 / 5) % 8];
        } else
        if(class2.anInt153 == 9)
        {
            j2 = 5;
            i2 = 2;
            flag = true;
            i += (5 * k1) / 100;
            k2 = j2 * 3 + anIntArray909[(anInt918 / 6) % 8];
        }
        for(int l2 = 0; l2 < 12; l2++)
        {
            int l3 = anIntArrayArray684[i2][l2];
            int k4 = class2.anIntArray159[l3] - 1;
            if(k4 < 0)
                continue;
            int i5 = 0;
            int j5 = 0;
            int k5 = k2;
            if(flag && j2 >= 1 && j2 <= 3)
                if(Class1.anIntArray86[k4] == 1)
                    k5 += 15;
                else
                if(l3 == 4 && j2 == 1)
                {
                    i5 = -22;
                    j5 = -3;
                    k5 = j2 * 3 + anIntArray726[(2 + class2.anInt152 / 6) % 4];
                } else
                if(l3 == 4 && j2 == 2)
                {
                    i5 = 0;
                    j5 = -8;
                    k5 = j2 * 3 + anIntArray726[(2 + class2.anInt152 / 6) % 4];
                } else
                if(l3 == 4 && j2 == 3)
                {
                    i5 = 26;
                    j5 = -5;
                    k5 = j2 * 3 + anIntArray726[(2 + class2.anInt152 / 6) % 4];
                } else
                if(l3 == 3 && j2 == 1)
                {
                    i5 = 22;
                    j5 = 3;
                    k5 = j2 * 3 + anIntArray726[(2 + class2.anInt152 / 6) % 4];
                } else
                if(l3 == 3 && j2 == 2)
                {
                    i5 = 0;
                    j5 = 8;
                    k5 = j2 * 3 + anIntArray726[(2 + class2.anInt152 / 6) % 4];
                } else
                if(l3 == 3 && j2 == 3)
                {
                    i5 = -26;
                    j5 = 5;
                    k5 = j2 * 3 + anIntArray726[(2 + class2.anInt152 / 6) % 4];
                }
            if(j2 == 5 && Class1.anIntArray85[k4] != 1)
                continue;
            int l5 = k5 + Class1.anIntArray87[k4];
            i5 = (i5 * k) / ((Class6) (aClass6_Sub1_724)).anIntArray328[l5];
            j5 = (j5 * l) / ((Class6) (aClass6_Sub1_724)).anIntArray329[l5];
            int i6 = (k * ((Class6) (aClass6_Sub1_724)).anIntArray328[l5]) / ((Class6) (aClass6_Sub1_724)).anIntArray328[Class1.anIntArray87[k4]];
            i5 -= (i6 - k) / 2;
            int j6 = Class1.anIntArray83[k4];
            int k6 = anIntArray829[class2.anInt172];
            if(j6 == 1)
                j6 = anIntArray885[class2.anInt169];
            else
            if(j6 == 2)
                j6 = anIntArray832[class2.anInt170];
            else
            if(j6 == 3)
                j6 = anIntArray832[class2.anInt171];
            aClass6_Sub1_724.method247(i + i5, j + j5, i6, l, l5, j6, k6, j1, flag);
        }

        if(class2.anInt161 > 0)
        {
            anIntArray967[anInt820] = aClass6_Sub1_724.method263(class2.aString160, 1) / 2;
            if(anIntArray967[anInt820] > 150)
                anIntArray967[anInt820] = 150;
            anIntArray968[anInt820] = (aClass6_Sub1_724.method263(class2.aString160, 1) / 300) * aClass6_Sub1_724.method261(1);
            anIntArray965[anInt820] = i + k / 2;
            anIntArray966[anInt820] = j;
            aStringArray821[anInt820++] = class2.aString160;
        }
        if(class2.anInt163 > 0)
        {
            anIntArray758[anInt958] = i + k / 2;
            anIntArray759[anInt958] = j;
            anIntArray722[anInt958] = k1;
            anIntArray723[anInt958++] = class2.anInt162;
        }
        if(class2.anInt153 == 8 || class2.anInt153 == 9 || class2.anInt167 != 0)
        {
            if(class2.anInt167 > 0)
            {
                int i3 = i;
                if(class2.anInt153 == 8)
                    i3 -= (20 * k1) / 100;
                else
                if(class2.anInt153 == 9)
                    i3 += (20 * k1) / 100;
                int i4 = (class2.anInt165 * 30) / class2.anInt166;
                anIntArray687[anInt766] = i3 + k / 2;
                anIntArray688[anInt766] = j;
                anIntArray689[anInt766++] = i4;
            }
            if(class2.anInt167 > 150)
            {
                int j3 = i;
                if(class2.anInt153 == 8)
                    j3 -= (10 * k1) / 100;
                else
                if(class2.anInt153 == 9)
                    j3 += (10 * k1) / 100;
                aClass6_Sub1_724.method231((j3 + k / 2) - 12, (j + l / 2) - 12, anInt948 + 11);
                aClass6_Sub1_724.method255(String.valueOf(class2.anInt164), (j3 + k / 2) - 1, j + l / 2 + 5, 3, 0xffffff);
            }
        }
        if(class2.anInt179 == 1 && class2.anInt163 == 0)
        {
            int k3 = j1 + i + k / 2;
            if(class2.anInt153 == 8)
                k3 -= (20 * k1) / 100;
            else
            if(class2.anInt153 == 9)
                k3 += (20 * k1) / 100;
            int j4 = (16 * k1) / 100;
            int l4 = (16 * k1) / 100;
            aClass6_Sub1_724.method232(k3 - j4 / 2, j - l4 / 2 - (10 * k1) / 100, j4, l4, anInt948 + 13);
        }
    }

    private final void method97(String s)
    {
        if(anInputStream_Sub1_901 == null)
            return;
        if(aBoolean853)
        {
            return;
        } else
        {
            anInputStream_Sub1_901.method123(aByteArray987, Class15.method364(s + ".pcm", aByteArray987), Class15.method365(s + ".pcm", aByteArray987));
            return;
        }
    }

    private final boolean method98(int i, int j)
    {
        int k = Class1.anInt144;
        if(anInt993 != 0)
        {
            aClass19_883.aBoolean609 = false;
            return false;
        }
        aBoolean717 = false;
        i += anInt806;
        j += anInt807;
        if(anInt809 == anInt785 && i > anInt842 && i < anInt844 && j > anInt843 && j < anInt845)
        {
            aClass19_883.aBoolean609 = true;
            return false;
        }
        aClass6_Sub1_724.method255("Loading... Please wait", 256, 192, 1, 0xffffff);
        method69();
        aClass6_Sub1_724.method211(aGraphics857, 0, 0);
        int l = anInt783;
        int i1 = anInt784;
        int j1 = (i + 24) / 48;
        int k1 = (j + 24) / 48;
        anInt809 = anInt785;
        anInt783 = j1 * 48 - 48;
        anInt784 = k1 * 48 - 48;
        anInt842 = j1 * 48 - 32;
        anInt843 = k1 * 48 - 32;
        anInt844 = j1 * 48 + 32;
        anInt845 = k1 * 48 + 32;
        aClass19_883.method416(i, j, anInt809);
        anInt783 -= anInt806;
        anInt784 -= anInt807;
        int l1 = anInt783 - l;
        int i2 = anInt784 - i1;
        for(int j2 = 0; j2 < anInt796;)
        {
            anIntArray760[j2] -= l1;
            anIntArray761[j2] -= i2;
            int k3 = anIntArray760[j2];
            int i4 = anIntArray761[j2];
            int i5 = anIntArray762[j2];
            Class5 class5 = aClass5Array814[j2];
            try
            {
                int l5 = anIntArray763[j2];
                int i6;
                int j6;
                if(l5 == 0 || l5 == 4)
                {
                    i6 = Class1.anIntArray63[i5];
                    j6 = Class1.anIntArray64[i5];
                } else
                {
                    j6 = Class1.anIntArray63[i5];
                    i6 = Class1.anIntArray64[i5];
                }
                int k6 = ((k3 + k3 + i6) * anInt946) / 2;
                int l6 = ((i4 + i4 + j6) * anInt946) / 2;
                if(k3 < 0 || i4 < 0 || k3 >= 96 || i4 >= 96)
                    continue;
                aClass10_739.method269(class5);
                class5.method192(k6, -aClass19_883.method421(k6, l6), l6);
                aClass19_883.method407(k3, i4, i5);
                if(i5 == 74)
                    class5.method191(0, -480, 0);
                continue;
            }
            catch(RuntimeException runtimeexception)
            {
                System.out.println("Loc Error: " + runtimeexception.getMessage());
                System.out.println("i:" + j2 + " obj:" + class5);
                runtimeexception.printStackTrace();
                j2++;
            }
        }

        for(int k2 = 0; k2 < anInt855;)
        {
            anIntArray747[k2] -= l1;
            anIntArray748[k2] -= i2;
            int l3 = anIntArray747[k2];
            int j4 = anIntArray748[k2];
            int j5 = anIntArray741[k2];
            int k5 = anIntArray740[k2];
            try
            {
                aClass19_883.method415(l3, j4, k5, j5);
                Class5 class5_1 = method106(l3, j4, k5, j5, k2);
                aClass5Array781[k2] = class5_1;
                continue;
            }
            catch(RuntimeException runtimeexception1)
            {
                System.out.println("Bound Error: " + runtimeexception1.getMessage());
                runtimeexception1.printStackTrace();
                k2++;
            }
        }

        for(int l2 = 0; l2 < anInt823; l2++)
        {
            anIntArray770[l2] -= l1;
            anIntArray771[l2] -= i2;
        }

        for(int i3 = 0; i3 < anInt742; i3++)
        {
            Class2 class2 = aClass2Array983[i3];
            class2.anInt149 -= l1 * anInt946;
            class2.anInt150 -= i2 * anInt946;
            for(int k4 = 0; k4 <= class2.anInt156; k4++)
            {
                class2.anIntArray157[k4] -= l1 * anInt946;
                class2.anIntArray158[k4] -= i2 * anInt946;
            }

        }

        for(int j3 = 0; j3 < anInt905; j3++)
        {
            Class2 class2_1 = aClass2Array768[j3];
            class2_1.anInt149 -= l1 * anInt946;
            class2_1.anInt150 -= i2 * anInt946;
            for(int l4 = 0; l4 <= class2_1.anInt156; l4++)
            {
                class2_1.anIntArray157[l4] -= l1 * anInt946;
                class2_1.anIntArray158[l4] -= i2 * anInt946;
            }

        }

        aClass19_883.aBoolean609 = true;
        return true;
    }

    private final void method99(int i, int j, int k, int l, boolean flag)
    {
        method83(i, j, k, l, k, l, false, flag);
    }

    public int serv;
    public String server;
    public script smacro;
    public boolean autofighter;
    public int npcid;
    public int npcnum;
    boolean Playerleft;
    public boolean autologin;
    public boolean chatSpammer;
    public String spamMessage;
    public chatSpam spamThread;
    private boolean aBoolean666;
    private boolean aBoolean668;
    private boolean aBoolean669;
    private boolean aBoolean673;
    private boolean aBoolean674;
    private boolean aBoolean675;
    private boolean aBoolean680;
    private boolean aBoolean717;
    private boolean aBoolean718;
    private boolean aBoolean719;
    private boolean aBoolean720;
    private boolean aBoolean721;
    private boolean aBoolean727;
    private boolean aBoolean745;
    private boolean aBoolean757;
    private boolean aBoolean767;
    private boolean aBoolean789;
    private boolean aBoolean801;
    private boolean aBoolean802;
    private boolean aBoolean810;
    private boolean aBoolean849;
    private boolean aBoolean852;
    private boolean aBoolean853;
    private boolean aBoolean854;
    private boolean aBoolean856;
    private boolean aBoolean870;
    private boolean aBoolean879;
    private boolean aBoolean880;
    private boolean aBoolean890;
    private boolean aBoolean908;
    private boolean aBoolean914;
    private boolean aBoolean917;
    private boolean aBoolean922;
    private boolean aBoolean944;
    private boolean aBoolean945;
    private boolean aBoolean979;
    private boolean aBoolean992;
    private boolean aBooleanArray662[];
    private boolean aBooleanArray679[];
    private boolean aBooleanArray716[];
    private boolean aBooleanArray831[];
    private byte aByteArray987[];
    private Class10 aClass10_739;
    private Class19 aClass19_883;
    private Class2 aClass2Array768[];
    private Class2 aClass2Array822[];
    private Class2 aClass2Array891[];
    private Class2 aClass2Array923[];
    private Class2 aClass2Array957[];
    private Class2 aClass2Array983[];
    private Class2 aClass2_975;
    private Class4 aClass4_667;
    private Class4 aClass4_751;
    private Class4 aClass4_775;
    private Class4 aClass4_798;
    private Class4 aClass4_826;
    private Class4 aClass4_830;
    private Class4 aClass4_858;
    private Class4 aClass4_925;
    private Class5 aClass5Array781[];
    private Class5 aClass5Array814[];
    private Class5 aClass5Array994[];
    private Class6_Sub1 aClass6_Sub1_724;
    private Graphics aGraphics857;
    private long aLong847;
    private long aLong907;
    long aLong928;
    private String aString681;
    private String aString682;
    private String aString734;
    private String aString735;
    String aString765;
    private String aString794;
    private String aString824;
    private String aString846;
    private String aString848;
    private String aString861;
    private String aString862;
    private String aString894;
    private final String aStringArray713[] = {
        "Attack", "Defense", "Strength", "Hits", "Ranged", "Prayer", "Magic", "Cooking", "Woodcut", "Fletching", 
        "Fishing", "Firemaking", "Crafting", "Smithing", "Mining", "Herblaw", "Agility", "Thieving"
    };
    private String aStringArray769[];
    private String aStringArray774[];
    private final String aStringArray795[] = {
        "Attack", "Defense", "Strength", "Hits", "Ranged", "Prayer", "Magic", "Cooking", "Woodcutting", "Fletching", 
        "Fishing", "Firemaking", "Crafting", "Smithing", "Mining", "Herblaw", "Agility", "Thieving"
    };
    String aStringArray821[];
    private String aStringArray913[];
    private final String aStringArray930[] = {
        "Black knight's fortress", "Cook's assistant", "Demon slayer", "Doric's quest", "The restless ghost", "Goblin diplomacy", "Ernest the chicken", "Imp catcher", "Pirate's treasure", "Prince Ali rescue", 
        "Romeo & Juliet", "Sheep shearer", "Shield of Arrav", "The knight's sword", "Vampire slayer", "Witch's potion", "Dragon slayer", "Witch's house (members)", "Lost city (members)", "Hero's quest (members)", 
        "Druidic ritual (members)", "Merlin's crystal (members)", "Scorpion catcher (members)", "Family crest (members)", "Tribal totem (members)", "Fishing contest (members)", "Monk's friend (members)", "Temple of Ikov (members)", "Clock tower (members)", "The Holy Grail (members)", 
        "Fight Arena (members)", "Tree Gnome Village (members)", "The Hazeel Cult (members)", "Sheep Herder (members)", "Plague City (members)", "Sea Slug (members)", "Waterfall quest (members)", "Biohazard (members)", "Jungle potion (members)", "Grand tree (members)", 
        "Shilo village (members)", "Underground pass (members)", "Observatory quest (members)", "Tourist trap (members)", "Watchtower (members)", "Dwarf Cannon (members)", "Murder Mystery (members)", "Digsite (members)", "Gertrude's Cat (members)", "Legend's Quest (members)"
    };
    private final String aStringArray932[] = {
        "Armour", "WeaponAim", "WeaponPower", "Magic", "Prayer"
    };
    private String aStringArray985[];
    private final String aStringArray997[] = {
        "Where were you born?", "What was your first teachers name?", "What is your fathers middle name?", "Who was your first best friend?", "What is your favourite vacation spot?", "What is your mothers middle name?", "What was your first pets name?", "What was the name of your first school?", "What is your mothers maiden name?", "Who was your first boyfriend/girlfriend?", 
        "What was the first computer game you purchased?", "Who is your favourite actor/actress?", "Who is your favourite author?", "Who is your favourite musician?", "Who is your favourite cartoon character?", "What is your favourite book?", "What is your favourite food?", "What is your favourite movie?"
    };
    String foodName;
    String prayername;
    String sName;
    int MacroTime;
    int styleCnt;
    int foodType;
    int prayercomb;
    int choseWorld;
    int delay;
    int npc;
    int foodID;
    int adk;
    int prayerid;
    int prayerdot;
    int speed;
    boolean showInfo;
    private InputStream_Sub1 anInputStream_Sub1_901;
    private final int anInt650 = 250;
    private final int anInt651 = 5;
    private final int anInt652 = 50;
    private final int anInt653 = 18;
    private final int anInt654 = 500;
    private final int anInt655 = 1500;
    private final int anInt656 = 5000;
    private final int anInt657 = 5000;
    private final int anInt658 = 500;
    private final int anInt659 = 4000;
    private final int anInt660 = 500;
    private final int anInt661 = 8000;
    private int anInt663;
    private int anInt670;
    int anInt671;
    int anInt672;
    private int anInt676;
    private int anInt677;
    private int anInt678;
    private int anInt683;
    private int anInt685;
    private int anInt690;
    private int anInt691;
    private int anInt694;
    private int anInt695;
    private int anInt696;
    private int anInt697;
    private int anInt698;
    private int anInt699;
    private int anInt700;
    private int anInt701;
    private int anInt702;
    private int anInt703;
    private int anInt704;
    private int anInt705;
    private int anInt706;
    private int anInt707;
    private int anInt708;
    private int anInt714;
    private int anInt715;
    private int anInt725;
    private int anInt729;
    private int anInt731;
    private int anInt732;
    private int anInt733;
    private int anInt742;
    private int anInt743;
    private int anInt744;
    private int anInt746;
    private int anInt749;
    private int anInt750;
    private int anInt752;
    private int anInt753;
    private int anInt754;
    private int anInt755;
    private int anInt756;
    private int anInt764;
    private int anInt766;
    int anInt776;
    int anInt777;
    int anInt778;
    int anInt779;
    int anInt780;
    private int anInt782;
    private int anInt783;
    private int anInt784;
    private int anInt785;
    private int anInt786;
    private int anInt790;
    private int anInt791;
    private int anInt792;
    private int anInt793;
    private int anInt796;
    int anInt799;
    int anInt800;
    private int anInt806;
    private int anInt807;
    private int anInt808;
    private int anInt809;
    private int anInt811;
    private int anInt812;
    private int anInt813;
    private int anInt818;
    private int anInt819;
    private int anInt820;
    private int anInt823;
    int anInt827;
    int anInt828;
    private int anInt833;
    private int anInt834;
    private int anInt835;
    private int anInt836;
    private int anInt839;
    private int anInt840;
    private int anInt841;
    private int anInt842;
    private int anInt843;
    private int anInt844;
    private int anInt845;
    private int anInt850;
    private int anInt851;
    private int anInt855;
    private int anInt859;
    private int anInt860;
    private int anInt863;
    private int anInt864;
    private int anInt865;
    private int anInt866;
    private int anInt867;
    private int anInt868;
    private int anInt869;
    private int anInt871;
    private int anInt872;
    private int anInt873;
    private int anInt874;
    private int anInt875;
    private int anInt876;
    private int anInt877;
    private int anInt878;
    private int anInt884;
    private int anInt886;
    private int anInt889;
    private int anInt892;
    private int anInt893;
    private int anInt895;
    private int anInt896;
    private int anInt897;
    private int anInt898;
    private int anInt899;
    private int anInt900;
    private int anInt902;
    private int anInt903;
    private int anInt904;
    private int anInt905;
    private int anInt906;
    private int anInt910;
    private int anInt915;
    private int anInt916;
    private int anInt918;
    private int anInt919;
    private int anInt920;
    private int anInt921;
    private int anInt924;
    int anInt926;
    int anInt927;
    private int anInt929;
    private int anInt931;
    private int anInt933;
    private int anInt936;
    private int anInt940;
    private int anInt941;
    private int anInt942;
    private int anInt943;
    private int anInt946;
    private int anInt947;
    private int anInt948;
    private int anInt949;
    private int anInt950;
    private int anInt951;
    private int anInt952;
    private int anInt953;
    private int anInt954;
    private int anInt958;
    private int anInt959;
    private int anInt964;
    private int anInt969;
    private int anInt973;
    private int anInt974;
    int anInt976;
    int anInt977;
    int anInt978;
    private int anInt980;
    private int anInt986;
    private int anInt988;
    private int anInt989;
    private int anInt990;
    private int anInt991;
    private int anInt993;
    private int anInt995;
    private int anInt996;
    private int anIntArray664[];
    private int anIntArray665[];
    private int anIntArray686[];
    private int anIntArray687[];
    private int anIntArray688[];
    private int anIntArray689[];
    private int anIntArray692[];
    private int anIntArray693[];
    private int anIntArray709[];
    private int anIntArray710[];
    private int anIntArray711[];
    private int anIntArray712[];
    private int anIntArray722[];
    private int anIntArray723[];
    private int anIntArray726[] = {
        0, 1, 2, 1
    };
    private int anIntArray728[];
    private int anIntArray730[];
    private int anIntArray736[];
    private int anIntArray737[];
    private int anIntArray738[];
    private int anIntArray740[];
    private int anIntArray741[];
    private int anIntArray747[];
    private int anIntArray748[];
    private int anIntArray758[];
    private int anIntArray759[];
    private int anIntArray760[];
    private int anIntArray761[];
    private int anIntArray762[];
    private int anIntArray763[];
    private int anIntArray770[];
    private int anIntArray771[];
    private int anIntArray772[];
    private int anIntArray773[];
    private int anIntArray787[];
    private int anIntArray788[];
    private int anIntArray797[];
    private int anIntArray803[];
    private int anIntArray804[];
    private int anIntArray805[];
    private int anIntArray815[];
    private int anIntArray816[];
    private int anIntArray817[];
    private int anIntArray825[];
    private final int anIntArray829[] = {
        0xecded0, 0xccb366, 0xb38c40, 0x997326, 0x906020
    };
    private final int anIntArray832[] = {
        0xff0000, 0xff8000, 0xffe000, 0xa0e000, 57344, 32768, 41088, 45311, 33023, 12528, 
        0xe000e0, 0x303030, 0x604000, 0x805000, 0xffffff
    };
    private int anIntArray837[];
    private int anIntArray838[];
    private int anIntArray881[];
    private int anIntArray882[];
    private final int anIntArray885[] = {
        0xffc030, 0xffa040, 0x805030, 0x604020, 0x303030, 0xff6020, 0xff4000, 0xffffff, 65280, 65535
    };
    private int anIntArray887[];
    private int anIntArray888[];
    private int anIntArray909[] = {
        0, 0, 0, 0, 0, 1, 2, 1
    };
    private int anIntArray911[];
    private int anIntArray912[];
    private int anIntArray934[];
    private int anIntArray935[];
    private int anIntArray937[];
    private int anIntArray938[];
    private int anIntArray939[] = {
        0, 1, 2, 1, 0, 0, 0, 0
    };
    private int anIntArray955[];
    private int anIntArray956[];
    private int anIntArray960[];
    private int anIntArray961[];
    private int anIntArray962[];
    private int anIntArray963[];
    private int anIntArray965[];
    private int anIntArray966[];
    private int anIntArray967[];
    private int anIntArray968[];
    private int anIntArray970[];
    private int anIntArray971[];
    private int anIntArray972[];
    int anIntArray981[];
    int anIntArray982[];
    private int anIntArray984[];
    private int anIntArrayArray684[][] = {
        {
            11, 2, 9, 7, 1, 6, 10, 0, 5, 8, 
            3, 4
        }, {
            11, 2, 9, 7, 1, 6, 10, 0, 5, 8, 
            3, 4
        }, {
            11, 3, 2, 9, 7, 1, 6, 10, 0, 5, 
            8, 4
        }, {
            3, 4, 2, 9, 7, 1, 6, 10, 8, 11, 
            0, 5
        }, {
            3, 4, 2, 9, 7, 1, 6, 10, 8, 11, 
            0, 5
        }, {
            4, 3, 2, 9, 7, 1, 6, 10, 8, 11, 
            0, 5
        }, {
            11, 4, 2, 9, 7, 1, 6, 10, 0, 5, 
            8, 3
        }, {
            11, 2, 9, 7, 1, 6, 10, 0, 5, 8, 
            4, 3
        }
    };
}