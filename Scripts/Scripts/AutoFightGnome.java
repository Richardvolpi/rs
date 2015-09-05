// Decompiled by DJ v3.7.7.81 Copyright 2004 Atanas Neshkov  Date: 27/07/2004 10:04:18 AM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3)
// Source File Name:   AutoFightnPick1gnome.java


public class AutoFightGnome extends Script
{

   public AutoFightGnome(mudclient mudclient)
   {
       super(mudclient);
   }

   public String[] getCommands()
   {
       return (new String[] {
           "fightgnome"
       });
   }

   public void start(String s, String as[])
   {
       if(as.length != 4)
       {
           DisplayMessage(" @whi@ Bruncle:Bad syntax fool: it's /RUN fightgnome [StYLe]@[FiGhT WaIt]@[StAt]@[FiNiSh LVl] ", 3);
       } else
       {
           int FightMode = Integer.parseInt(as[0]);
           int j = Integer.parseInt(as[1]);
           int k = Integer.parseInt(as[2]);
           int l = Integer.parseInt(as[3]);
           CheckFighters(true);
           DisplayMessage("@gre@Bruncle: @whi@Gnome Slaughterer - by BrUnCLe", 3);
           do
           {
            int stop = 0;
               if(!Running() || GetCurrentStat(k) == l)
                   break;
               if(GetFightMode() != FightMode && Running())
               {
                   SetFightMode(FightMode);
                   DisplayMessage("@gre@Bruncle: @whi@FightMode Changed To " + GetFightMode(), 3);
               }
               while(InCombat())
                   Wait(1);
                   SetFightMode(FightMode);
               if(Fatigue() > 97 && !Sleeping() && Running())
               {
                   DisplayMessage("@gre@SBoT: @whi@Sleeping", 3);
                   Use(FindInv(1263));
                   Wait(5000);
                   SetFightMode(FightMode);
                   continue;
               }
               while (Sleeping()) Wait(1000);
               if(Sleeping() && GetFightMode() == FightMode && Running())
                   continue;
               int i1 = GetNearestNPC(409);
               if(i1 != -1 && GetY() > 655 && GetX() > 638)
               {
                   long l1 = System.currentTimeMillis();
                   SetFightMode(FightMode);
                   AttackNPC(i1);
                   for(; System.currentTimeMillis() - l1 <= (long)j && !InCombat() && Running(); Wait(1));
               } else
               {
                   while(!Sleeping() && !InCombat() && i1 == -1 && Running())
                   {
                    SetFightMode(FightMode);
                       i1 = GetNearestNPC(409);
                       Wait(1);
                       SetFightMode(FightMode);
                     
                   }
               }
               if(GetY() <= 655 && Running())
               {
                   DisplayMessage("@gre@Bruncle: Uh oh, wandered off...", 3);
                   Walk(654, 662);
                   SetFightMode(FightMode);
               }
                if(GetX() <= 638 && Running())
               {
                   DisplayMessage("@gre@Bruncle: Uh oh, wandered off...", 3);
                   Walk(647, 666);
                   SetFightMode(FightMode);
               }
           } while(true);
       }
       DisplayMessage("@gre@SBoT: @whi@Gnome Slaughterer - @red@STOPPED", 3);              
   }
}