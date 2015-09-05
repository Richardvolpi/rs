import java.util.*; 
import java.io.*; 

public class UberFighter extends Script 
{ 
        int i = 0; 
        int k = 0; 
        int l = 0; 
        int i1= 0; 
        int u = 0; 
        int d = 0; 
        int w = 0; 
        int d1 = 0; 
        int d2 = 0; 
        int v = 0; 
        int a1 = 0; 
        int a2 = 0;    
   int b = 0; 
   int b1 = 0; 
   int b2 = 0; 
   int b3 = 0; 
   int b4 = 0; 
   int b5 = 0; 
   int b6 = 0; 
   int b7 = 0; 
   int b8 = 0; 
   int b9 = 0; 
   int b10 = 0; 
   int f1 = 0; 
   int f2 = 0; 
   int f3 = 0; 
   int f4 = 0; 
   int f5 = 0; 
   int f6 = 0; 
   int f7 = 0; 
   int f8 = 0; 
   int f9 = 0; 
   int f10 = 0;    
    public UberFighter(mudclient mudclient) 
    { 
        super(mudclient); 
        Time = 0L; 
    } 

    public String[] getCommands() 
    { 
        return (new String[] { 
            "uberfight" 
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
            p.load(new FileInputStream("uberSETUP1.ini")); 
            i = Integer.parseInt(p.getProperty("FightMode")); 
            k = Integer.parseInt(p.getProperty("NPCID")); 
            u = Integer.parseInt(p.getProperty("NPCID2")); 
            l = Integer.parseInt(p.getProperty("WalkBackRadius")); 
            i1 = Integer.parseInt(p.getProperty("FoodID")); 
            w = Integer.parseInt(p.getProperty("Door1Direction")); 
            d1 = Integer.parseInt(p.getProperty("Door1X")); 
            d2 = Integer.parseInt(p.getProperty("Door1Y")); 
            v = Integer.parseInt(p.getProperty("Door2Direction")); 
            a1 = Integer.parseInt(p.getProperty("Door2X")); 
            a2 = Integer.parseInt(p.getProperty("Door2Y")); 
       b = Integer.parseInt(p.getProperty("Bank?")); 
       b1 = Integer.parseInt(p.getProperty("Walk1x")); 
       f1 = Integer.parseInt(p.getProperty("Walk1y")); 
       b2 = Integer.parseInt(p.getProperty("Walk2x")); 
       f2 = Integer.parseInt(p.getProperty("Walk2y")); 
       b3 = Integer.parseInt(p.getProperty("Walk3x")); 
       f3 = Integer.parseInt(p.getProperty("Walk3y")); 
       b4 = Integer.parseInt(p.getProperty("Walk4x")); 
       f4 = Integer.parseInt(p.getProperty("Walk4y")); 
       b5 = Integer.parseInt(p.getProperty("Walk5x")); 
       f5 = Integer.parseInt(p.getProperty("Walk5y")); 
       b6 = Integer.parseInt(p.getProperty("Walk6x")); 
       f6 = Integer.parseInt(p.getProperty("Walk6y")); 
       b7 = Integer.parseInt(p.getProperty("Walk7x")); 
       f7 = Integer.parseInt(p.getProperty("Walk7y")); 
       b8 = Integer.parseInt(p.getProperty("Walk8x")); 
       f8 = Integer.parseInt(p.getProperty("Walk8y")); 
       b9 = Integer.parseInt(p.getProperty("Walk9x")); 
       f9 = Integer.parseInt(p.getProperty("Walk9y")); 
       b10 = Integer.parseInt(p.getProperty("Walk10x")); 
       f10 = Integer.parseInt(p.getProperty("Walk10y")); 
   } 
        catch (Exception e) { 
            System.out.println(e); 
        } 
        } 
        if(d == 2) 
        { 
        try { 
            Properties p = new Properties(); 
            p.load(new FileInputStream("uberSETUP2.ini")); 
            i = Integer.parseInt(p.getProperty("FightMode")); 
            k = Integer.parseInt(p.getProperty("NPCID")); 
            u = Integer.parseInt(p.getProperty("NPCID2")); 
            l = Integer.parseInt(p.getProperty("WalkBackRadius")); 
            i1 = Integer.parseInt(p.getProperty("FoodID")); 
            w = Integer.parseInt(p.getProperty("Door1Direction")); 
            d1 = Integer.parseInt(p.getProperty("Door1X")); 
            d2 = Integer.parseInt(p.getProperty("Door1Y")); 
            v = Integer.parseInt(p.getProperty("Door2Direction")); 
            a1 = Integer.parseInt(p.getProperty("Door2X")); 
            a2 = Integer.parseInt(p.getProperty("Door2Y")); 
       b = Integer.parseInt(p.getProperty("Bank?")); 
       b1 = Integer.parseInt(p.getProperty("Walk1x")); 
       f1 = Integer.parseInt(p.getProperty("Walk1y")); 
       b2 = Integer.parseInt(p.getProperty("Walk2x")); 
       f2 = Integer.parseInt(p.getProperty("Walk2y")); 
       b3 = Integer.parseInt(p.getProperty("Walk3x")); 
       f3 = Integer.parseInt(p.getProperty("Walk3y")); 
       b4 = Integer.parseInt(p.getProperty("Walk4x")); 
       f4 = Integer.parseInt(p.getProperty("Walk4y")); 
       b5 = Integer.parseInt(p.getProperty("Walk5x")); 
       f5 = Integer.parseInt(p.getProperty("Walk5y")); 
       b6 = Integer.parseInt(p.getProperty("Walk6x")); 
       f6 = Integer.parseInt(p.getProperty("Walk6y")); 
       b7 = Integer.parseInt(p.getProperty("Walk7x")); 
       f7 = Integer.parseInt(p.getProperty("Walk7y")); 
       b8 = Integer.parseInt(p.getProperty("Walk8x")); 
       f8 = Integer.parseInt(p.getProperty("Walk8y")); 
       b9 = Integer.parseInt(p.getProperty("Walk9x")); 
       f9 = Integer.parseInt(p.getProperty("Walk9y")); 
       b10 = Integer.parseInt(p.getProperty("Walk10x")); 
       f10 = Integer.parseInt(p.getProperty("Walk10y")); 
        } 
        catch (Exception e) { 
            System.out.println(e); 
        } 
        } 
        if(d == 3) 
        { 
        try { 
            Properties p = new Properties(); 
            p.load(new FileInputStream("uberSETUP3.ini")); 
            i = Integer.parseInt(p.getProperty("FightMode")); 
            k = Integer.parseInt(p.getProperty("NPCID")); 
            u = Integer.parseInt(p.getProperty("NPCID2")); 
            l = Integer.parseInt(p.getProperty("WalkBackRadius")); 
            i1 = Integer.parseInt(p.getProperty("FoodID")); 
            w = Integer.parseInt(p.getProperty("Door1Direction")); 
            d1 = Integer.parseInt(p.getProperty("Door1X")); 
            d2 = Integer.parseInt(p.getProperty("Door1Y")); 
            v = Integer.parseInt(p.getProperty("Door2Direction")); 
            a1 = Integer.parseInt(p.getProperty("Door2X")); 
            a2 = Integer.parseInt(p.getProperty("Door2Y")); 
       b = Integer.parseInt(p.getProperty("Bank?")); 
       b1 = Integer.parseInt(p.getProperty("Walk1x")); 
       f1 = Integer.parseInt(p.getProperty("Walk1y")); 
       b2 = Integer.parseInt(p.getProperty("Walk2x")); 
       f2 = Integer.parseInt(p.getProperty("Walk2y")); 
       b3 = Integer.parseInt(p.getProperty("Walk3x")); 
       f3 = Integer.parseInt(p.getProperty("Walk3y")); 
       b4 = Integer.parseInt(p.getProperty("Walk4x")); 
       f4 = Integer.parseInt(p.getProperty("Walk4y")); 
       b5 = Integer.parseInt(p.getProperty("Walk5x")); 
       f5 = Integer.parseInt(p.getProperty("Walk5y")); 
       b6 = Integer.parseInt(p.getProperty("Walk6x")); 
       f6 = Integer.parseInt(p.getProperty("Walk6y")); 
       b7 = Integer.parseInt(p.getProperty("Walk7x")); 
       f7 = Integer.parseInt(p.getProperty("Walk7y")); 
       b8 = Integer.parseInt(p.getProperty("Walk8x")); 
       f8 = Integer.parseInt(p.getProperty("Walk8y")); 
       b9 = Integer.parseInt(p.getProperty("Walk9x")); 
       f9 = Integer.parseInt(p.getProperty("Walk9y")); 
       b10 = Integer.parseInt(p.getProperty("Walk10x")); 
       f10 = Integer.parseInt(p.getProperty("Walk10y")); 
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
        DisplayMessage("@dre@// @whi@uberFighter - Attacks @ora@all @whi@monsters within a certain radius.", 3); 
        if(d == 1) 
        SexyPrint("// Loaded uberSETUP1.ini..."); 
        if(d == 2) 
        SexyPrint("// Loaded uberSETUP2.ini..."); 
        if(d == 3) 
        SexyPrint("// Loaded uberSETUP3.ini..."); 
        SexyPrint("// NPC1 Set: " + k + ". NPC2 Set: " + u + ". FMode Set: " + s1 + ". Walkback Radius: " + l + "."); 
        if(i != 0) 
        SexyPrint("// Food set: " + s2 + ". Quantity: " + FindInv(i1) + ""); 
        else 
        SexyPrint("// No Food mode chosen! Script will not eat."); 
   if(b == 1) 
   SexyPrint("// Script will bank when 0 food"); 
   else 
   SexyPrint("// Script is on no bank mode."); 
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
       if(FindInv(i1) <= -1 && Running() && b == 1) 
      { 
            Println("// No food remaining. WALKING TO BANK!"); 
            DisplayMessage("@dre@// @ora@Walking to @red@(@yel@" + j1 + "@red@,@yel@" + k1 + "@red@)", 3); 
            Walk(j1, k1); 
            Wait(765); 

            DisplayMessage("@dre@// @ora@Walking to @red@(@yel@" + b1 + "@red@,@yel@" + f1 + "@red@)", 3); 
            Walk(b1, f1); 
            Wait(765); 

            DisplayMessage("@dre@// @ora@Walking to @red@(@yel@" + b2 + "@red@,@yel@" + f2 + "@red@)", 3); 
            Walk(b2, f2); 
            Wait(765); 

            DisplayMessage("@dre@// @ora@Walking to @red@(@yel@" + b3 + "@red@,@yel@" + f3 + "@red@)", 3); 
            Walk(b3, f3); 
            Wait(765); 

            DisplayMessage("@dre@// @ora@Walking to @red@(@yel@" + b4 + "@red@,@yel@" + f4 + "@red@)", 3); 
            Walk(b4, f4); 
            Wait(765); 

            DisplayMessage("@dre@// @ora@Walking to @red@(@yel@" + b5 + "@red@,@yel@" + f5 + "@red@)", 3); 
            Walk(b5, f5); 
            Wait(765); 
         if(b6 != 0 && f6 != 0) 
         { 
            DisplayMessage("@dre@// @ora@Walking to @red@(@yel@" + b6 + "@red@,@yel@" + f6 + "@red@)", 3); 
            Walk(b6, f6); 
            Wait(765); 
         } 
         if(b7 != 0 && f7 != 0) 
         { 
            DisplayMessage("@dre@// @ora@Walking to @red@(@yel@" + b7 + "@red@,@yel@" + f7 + "@red@)", 3); 
            Walk(b7, f7); 
            Wait(765); 
         } 
         if(b8 != 0 && f8 != 0) 
         { 
            DisplayMessage("@dre@// @ora@Walking to @red@(@yel@" + b8 + "@red@,@yel@" + f8 + "@red@)", 3); 
            Walk(b8, f8); 
            Wait(765); 
         } 
         if(b9 != 0 && f9 != 0) 
         { 
            DisplayMessage("@dre@// @ora@Walking to @red@(@yel@" + b9 + "@red@,@yel@" + f9 + "@red@)", 3); 
            Walk(b9, f9); 
            Wait(765); 
         } 
         if(b10 != 0 && f10 != 0) 
         { 
            DisplayMessage("@dre@// @ora@Walking to @red@(@yel@" + b10 + "@red@,@yel@" + f10 + "@red@)", 3); 
            Walk(b10, f10); 
            Wait(765); 
         }    
            DisplayMessage("@dre@// @gr1@You have reached the bank! Getting ubusy banker...", 3); 


         while (QuestMenu() == false) 
           { 
                 int BankerID = GetNearestNPC(95); 
                 TalkToNPC(BankerID); 
                 Wait(1010); 
           } 
                 Answer(0); 
                 while (Bank() == false) 
                    {Wait(1000);} 
                 while (InvCount() < 30) 
           { 
                    Withdraw(i1, 1); 
                Wait(250); 
           } 
           CloseBank(); 
            Println("// Food Obtained. Walking back to training spot."); 
         if(b10 != 0 && f10 != 0) 
         { 
            DisplayMessage("@dre@// @ora@Walking to @red@(@yel@" + b10 + "@red@,@yel@" + f10 + "@red@)", 3); 
            Walk(b10, f10); 
            Wait(765); 
         } 
         if(b9 != 0 && f9 != 0) 
         { 
            DisplayMessage("@dre@// @ora@Walking to @red@(@yel@" + b9 + "@red@,@yel@" + f9 + "@red@)", 3); 
            Walk(b9, f9); 
            Wait(765); 
         } 
         if(b8 != 0 && f8 != 0) 
         { 
            DisplayMessage("@dre@// @ora@Walking to @red@(@yel@" + b8 + "@red@,@yel@" + f8 + "@red@)", 3); 
            Walk(b8, f8); 
            Wait(765); 
         } 
         if(b7 != 0 && f7 != 0) 
         { 
            DisplayMessage("@dre@// @ora@Walking to @red@(@yel@" + b7 + "@red@,@yel@" + f7 + "@red@)", 3); 
            Walk(b7, f7); 
            Wait(765); 
         } 
         if(b6 != 0 && f6 != 0) 
         { 
            DisplayMessage("@dre@// @ora@Walking to @red@(@yel@" + b6 + "@red@,@yel@" + f6 + "@red@)", 3); 
            Walk(b6, f6); 
            Wait(765); 
         } 

            DisplayMessage("@dre@// @ora@Walking to @red@(@yel@" + b5 + "@red@,@yel@" + f5 + "@red@)", 3); 
            Walk(b5, f5); 
            Wait(765); 

            DisplayMessage("@dre@// @ora@Walking to @red@(@yel@" + b4 + "@red@,@yel@" + f4 + "@red@)", 3); 
            Walk(b4, f4); 
            Wait(765); 

            DisplayMessage("@dre@// @ora@Walking to @red@(@yel@" + b3 + "@red@,@yel@" + f3 + "@red@)", 3); 
            Walk(b3, f3); 
            Wait(765); 

            DisplayMessage("@dre@// @ora@Walking to @red@(@yel@" + b2 + "@red@,@yel@" + f2 + "@red@)", 3); 
            Walk(b2, f2); 
            Wait(765); 

            DisplayMessage("@dre@// @ora@Walking to @red@(@yel@" + b1 + "@red@,@yel@" + f1 + "@red@)", 3); 
            Walk(b1, f1); 
            Wait(765); 

            DisplayMessage("@dre@// @ora@Walking to @red@(@yel@" + b1 + "@red@,@yel@" + f1 + "@red@)", 3); 
            Walk(j1, k1); 
            Wait(765); 
      } 
            if(!InCombat()) 
            { 
                if(Fatigue() > 97 && !Sleeping()) 
                { 
                    DisplayMessage("@dre@// @whi@Sleeping", 3); 
                    Use(FindInv(1263)); 
         SexyPrint("//////////////////////////////////////////////////////"); 
         SexyPrint("///// P  R  O  G  R  E  S  S     R  E  P  O  R  T ////"); 
         SexyPrint("//////////////////////////////////////////////////////"); 
         SexyPrint("// Over-all EXP Gained so far: " + ((GetExperience(0) - l1) + (GetExperience(1) - i2) + (GetExperience(2) - j2)) / 1000 + "k"); 
         if((GetExperience(0) - l1) + (GetExperience(1) - i2) + (GetExperience(2) - j2) > 0) 
         SexyPrint("// Average EXP per Hour Gained so far: " + ((long)((GetExperience(0) - l1) + (GetExperience(1) - i2) + (GetExperience(2) - j2)) / ((long)(int)(TickCount() / 60000L) - Time / 60L)) * 60L + ""); 
         else 
         SexyPrint("// No experience Gained. EXP per hour = ZERO!"); 
         SexyPrint("//////////////////////////////////////////////////////"); 
                    Wait(5000); 
                } else 
                if(!Sleeping()) 
                { 
                                   int ai[] = { 
                                            k, u 
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
                    if(!CanReach(k3, l3)) 
                    { 
                                for(; DoorAt(d1, d2, w) == 2; Wait(1000)) 
                                        OpenDoor(d1, d2, w); 

                                for(; DoorAt(a1, a2, v) == 2; Wait(1000)) 
                                        OpenDoor(a1, a2, v); 
                    }    
                } 
            } else 
            { 
                while(InCombat() && Running()) 
                Wait(1); 
            }    
        } while(true); 
        DisplayMessage("@dre@// @ora@UberFighter - @red@STOPPED.", 3); 
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


Code: 
////////////////////////////////////////////////////////////// 
//               U  B  E  R      F I G H T E R              // 
////////////////////////////////////////////////////////////// 
// ~ Settings File ONE ~                // 
////////////////////////////////////////////////////////////// 
// SAVE THIS FILE IN THE MAIN SBOT FOLER, AS uberSETUP1.ini // 
// ALL CREDITS FOR THE .INI FILE GO TO GHOST_ID! THANKS!!!! // 
// FOR ALL SETTINGS: PUT 0 TO IGNORE THE COMMAND            // 
////////////////////////////////////////////////////////////// 

FightMode=1 
NPCID=407 
NPCID2=0 
WalkBackRadius=23 
FoodID=373 
// Door1 Commands 
Door1Direction=0 
Door1X=649 
Door1Y=632 
// Door2 Commands 
Door2Direction=0 
Door2X=0 
Door2Y=0 
// ~ Banking! ~ 
// Answer 1 for banking, 0 for no banking. 
Bank?=1 
// Walking to bank co-ords! 
// you MUST fill in the first 5 co ords at least. leave the ones you dont use as 0 
Walk1x=640 
Walk1y=641 

Walk2x=626 
Walk2y=638 

Walk3x=614 
Walk3y=636 

Walk4x=587 
Walk4y=632 

Walk5x=576 
Walk5y=626 

Walk6x=562 
Walk6y=620 

Walk7x=549 
Walk7y=619 

Walk8x=551 
Walk8y=613 

Walk9x=0 
Walk9y=0 

Walk10x=0 
Walk10y=0 

////////////////////////////////////////////////////////////// 
// FightMode > 0 for Controlled                             //    
//           > 1 for Strength                               // 
//           > 2 for Attack                                 // 
//           > 3 for Defence                                // 
////////////////////////////////////////////////////////////// 
// NPC > Set the ID for the NPC you want to fight       //                              
////////////////////////////////////////////////////////////// 
// NPC2 > Set the ID for 2nd  NPC you want              // 
//      > to fight. -1 for no npc.                       // 
////////////////////////////////////////////////////////////// 
// WalkBack Radius > How far away from your x/y you want to // 
//         > fight NPC's                            // 
////////////////////////////////////////////////////////////// 
// Food ID > The id of the food you want to eat.            // 
//      > Set 0 to not eat.                              // 
////////////////////////////////////////////////////////////// 
