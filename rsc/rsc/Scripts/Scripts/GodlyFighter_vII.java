import java.util.*;
import java.io.*;

public class GodlyFighter_vII extends Script
{
        int i = 0;
        int k = 0;
        int npc3 = 0;
        int npc4 = 0;
        int l = 0;
        int i1= 0;
        int u = 0;
        int d = 0;    
    public GodlyFighter_vII(mudclient mudclient)
    {
        super(mudclient);
        Time = 0L;
    }

    public String[] getCommands()
    {
        return (new String[] {
            "godfight"
        });
    }

    public static void main(String args[]) {
    }

    public void start(String s, String as[])
    {
        int d = Integer.parseInt(as[0]);
        if(d == 1)
        {
        try {
            Properties p = new Properties();
            p.load(new FileInputStream("godconfig1.ini"));
            i = Integer.parseInt(p.getProperty("FightMode"));
            k = Integer.parseInt(p.getProperty("NPCID"));
            npc3 = Integer.parseInt(p.getProperty("NPCID3"));
            npc4 = Integer.parseInt(p.getProperty("NPCID4"));
            u = Integer.parseInt(p.getProperty("NPCID2"));
            l = Integer.parseInt(p.getProperty("WalkBackRadius"));
            i1 = Integer.parseInt(p.getProperty("FoodID"));
        }
        catch (Exception e) {
            System.out.println(e);
        }
        }
        if(d == 2)
        {
        try {
            Properties p = new Properties();
            p.load(new FileInputStream("godconfig2.ini"));
            i = Integer.parseInt(p.getProperty("FightMode"));
            k = Integer.parseInt(p.getProperty("NPCID"));
            npc3 = Integer.parseInt(p.getProperty("NPCID3"));
            npc4 = Integer.parseInt(p.getProperty("NPCID4"));
            u = Integer.parseInt(p.getProperty("NPCID2"));
            l = Integer.parseInt(p.getProperty("WalkBackRadius"));
            i1 = Integer.parseInt(p.getProperty("FoodID"));
        }
        catch (Exception e) {
            System.out.println(e);
        }
        }
        if(d == 3)
        {
        try {
            Properties p = new Properties();
            p.load(new FileInputStream("godconfig3.ini"));
            i = Integer.parseInt(p.getProperty("FightMode"));
            k = Integer.parseInt(p.getProperty("NPCID"));
            npc3 = Integer.parseInt(p.getProperty("NPCID3"));
            npc4 = Integer.parseInt(p.getProperty("NPCID4"));
            u = Integer.parseInt(p.getProperty("NPCID2"));
            l = Integer.parseInt(p.getProperty("WalkBackRadius"));
            i1 = Integer.parseInt(p.getProperty("FoodID"));
        }
        catch (Exception e) {
            System.out.println(e);
        }
        }
        Time = (int)(TickCount() / 1000L);
        int j = 777;
        byte byte0 = 7;
        int j1 = GetX();
        int k1 = GetY();
        int l1 = GetExperience(0);
        int i2 = GetExperience(1);
        int j2 = GetExperience(2);
        int k2 = GetStat(0);
        int l2 = GetStat(1);
        int i3 = GetStat(2);
        String s1;
        switch(i)
        {
            case 0: // '\0'
            s1 = "Controlled";
            break;

            case 1: // '\001'
            s1 = "Aggressive";
            break;

            case 2: // '\002'
            s1 = "Accurate";
            break;

            case 3: // '\003'
            s1 = "Defensive";
            break;

            default:
            s1 = "Incorrect";
            break;
        }
        String s2;
        switch(i1)
        {
            case 373:
            s2 = "Lobster";
            byte0 = 12;
            break;

            case 546:
            s2 = "Shark";
            byte0 = 20;
            break;

            case 359:
            s2 = "Trout";
            byte0 = 7;
            break;

            case 357:
            s2 = "Salmon";
            byte0 = 8;
            break;

            case 330:
            s2 = "Cake";
            byte0 = 4;
            break;

            default:
            s2 = "" + i1;
            break;
        }
        CheckFighters(true);
        DisplayMessage("@dre@// @whi@GodlyFighter - Attacks @ora@all @whi@monsters within a certain radius. @cya@4@gr1@N@gr2@P@gr3@C @or1@ b@or2@y@or3@: @ran@hYpnOtiQ", 3);
        if(d == 1)
        SexyPrint("// Loaded godconfig1.ini...");
        if(d == 2)
        SexyPrint("// Loaded godconfig2.ini...");
        if(d == 3)
        SexyPrint("// Loaded godconfig3.ini...");
        SexyPrint("// NPC1 Set: " + k + ". NPC2 Set: " + u + ". FMode Set: " + s1 + ". Walkback Radius: " + l + ".");
        if(i != 0)
        SexyPrint("// Food set: " + s2 + ". Quantity: " + FindInv(i1) + "");
        else
        SexyPrint("// No Food mode chosen! Script will not eat.");
        SexyPrint("// Attacking within (" + (j1 - l) + ", " + (k1 - l) + ")-(" + (j1 + l) + ", " + (k1 + l) + "). Walkback Point set to " + j1 + "," + k1 + "");
        SexyPrint("//////////////////////////////////////////////////////");
        SexyPrint("///// P  R  O  G  R  E  S  S     R  E  P  O  R  T ////");
        SexyPrint("//////////////////////////////////////////////////////");
        SexyPrint("// Initial Attack Experience: " + l1 + ". Level: " + k2 + " ");
        SexyPrint("// Initial Defence Experience: " + i2 + ". Level: " + l2 + " ");
        SexyPrint("// Initial Strength Experience: " + j2 + ". Level: " + i3 + " ");
        SexyPrint("//////////////////////////////////////////////////////");
        do
        {
            if(!Running() || GetCurrentStat(3) <= 6 || !Running())
            break;
            if(GetFightMode() != i) {
                SetFightMode(i);
                DisplayMessage("@dre@// @whi@FMODE set as @yel@" + s1 + "", 3);
            }
            if(GetStat(3) - GetCurrentStat(3) >= byte0 && i1 != 0 && FindInv(i1) > 0)
            {
                SexyPrint("// Hits: " + GetHP() + ". Eating a " + s2 + "");
                Use(FindInv(i1));
                Wait(456);
            }
            if(!InCombat())
            {
                if(Fatigue() > 97 && !Sleeping())
                {
                    DisplayMessage("@dre@// @whi@Sleeping", 3);
                    Use(FindInv(1263));
                    Wait(5000);
                } else
                if(!Sleeping())
                {
                                   int ai[] = {
                                            k, u, npc3, npc4
                                           };
                    int u1 = GetNearestNPC(ai);
                    int k3 = NPCX(u1);
                    int l3 = NPCY(u1);
                    if(u1 != -1 && k3 >= j1 - l && k3 <= j1 + l && l3 >= k1 - l && l3 <= k1 + l)
                    {
                        long l4 = System.currentTimeMillis();
                        AttackNPC(u1);
                        while(System.currentTimeMillis() - l4 <= (long)j && !InCombat() && Running())
                        Wait(1);
                    } else 
                    if(GetX() != j1 || GetY() != k1)
                    {
                        ForceWalkNoWait(j1, k1);
                        Wait(666);
                    } else
                    {
                        Wait(1);
                    }    
                }
            } else
            {
                while(InCombat() && Running())
                Wait(1);
            }
        } while(true);
        DisplayMessage("@dre@// @ora@GodlyFighter - @red@STOPPED.", 3);
        SexyPrint("//////////////////////////////////////////////////////");
        SexyPrint("//// S   C   R   I   P   T      E   N   D   E   D ////");
        SexyPrint("//////////////////////////////////////////////////////");
        SexyPrint("// Attack Experience Gained: " + (GetExperience(0) - l1) / 1000 + "k. Levels Gained: " + (GetStat(0) - k2) + " ");
        SexyPrint("// Defence Experience Gained: " + (GetExperience(1) - i2) / 1000 + "k. Levels Gained: " + (GetStat(1) - l2) + " ");
        SexyPrint("// Strength Experience Gained: " + (GetExperience(2) - j2) / 1000 + "k. Levels Gained: " + (GetStat(2) - i3) + " ");
        SexyPrint("// Over-all EXP Gained: " + ((GetExperience(0) - l1) + (GetExperience(1) - i2) + (GetExperience(2) - j2)) / 1000 + "k");
        if((long)(int)(TickCount() / 1000L) - Time < 500L)
        SexyPrint("// Seconds passed: " + ((long)(int)(TickCount() / 1000L) - Time) + "");
        else
        if((long)(int)(TickCount() / 60000L) - Time / 60L < 60L)
        SexyPrint("// Mins passed: " + ((long)(int)(TickCount() / 60000L) - Time / 60L) + "");
        if((GetExperience(0) - l1) + (GetExperience(1) - i2) + (GetExperience(2) - j2) > 0)
        SexyPrint("// Average EXP per Hour Gained: " + ((long)((GetExperience(0) - l1) + (GetExperience(1) - i2) + (GetExperience(2) - j2)) / ((long)(int)(TickCount() / 60000L) - Time / 60L)) * 60L + "");
        else
        SexyPrint("// No experience Gained. EXP per hour = ZERO!");
        SexyPrint("//////////////////////////////////////////////////////");
    }

    public long Time;
}