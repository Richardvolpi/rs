public class AutoFight2npc extends Script
{
    public AutoFight2npc(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"killmonk"};
    }
    public void start(String command, String parameter[])
    {
      if (parameter.length != 1)
      {
         DisplayMessage("@gre@Bruncle: @whi@Invalid number of parameters. /RUN killmonk [STYLE]", 3);
      } else {
         int FightMode = Integer.parseInt(parameter[0]);
         int FightTime = 750;
         int npcs[] = {139,140};
         CheckFighters(true);
         DisplayMessage("@gre@Bruncle: @whi@Monk owner by BrUnCLe", 3);
         while (Running() == true && GetCurrentStat(3) > 5)
         {
            if (GetFightMode() != FightMode)
            {
               SetFightMode(FightMode);
               DisplayMessage("@gre@Bruncle: @whi@FightMode Changed To " + GetFightMode(),  3);
            }
            if (InCombat() == false)
            {
               if (Fatigue() > 97 && Sleeping() == false)
               {
                  DisplayMessage("@gre@Bruncle: @whi@Sleeping", 3);
                  Use(FindInv(1263));
                  Wait(5000);
               } else {
                  if (Sleeping() == false)
                  {
                     int ID = GetNearestNPC(npcs);
                     if (ID != -1)
                     {
                        long T = System.currentTimeMillis();
                        TalkToNPC(ID);
                        while (System.currentTimeMillis() - T <= FightTime && InCombat() == false && Running() == true)
                           Wait(1);
                     } else
                        Wait(1);
                  }
               }
            } else {
               while (InCombat() == true && Running() == true)
                  Wait(1);
            }
         }
      }
      DisplayMessage("@gre@SBoT: @whi@Monk chatter - @red@STOPPED", 3);
    }
} 