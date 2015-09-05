public class AutoFight extends Script
{
    public AutoFight(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"fight"};
    }
    public void start(String command, String parameter[])
    {
      if (parameter.length != 2)
      {
         DisplayMessage("@gre@SBoT: @whi@Invalid number of parameters. /RUN FIGHT [STYLE] [NPC TYPE]", 3);
      } else {
         int FightMode = Integer.parseInt(parameter[0]);
         int FightTime = 750;
         int FightType = Integer.parseInt(parameter[1]);
         CheckFighters(true);
         DisplayMessage("@gre@SBoT: @whi@AutoFighter - RichyT", 3);
         while (Running() == true && GetCurrentStat(3) > 5)
         {
            if (GetFightMode() != FightMode)
            {
               SetFightMode(FightMode);
               DisplayMessage("@gre@SBoT: @whi@FightMode Changed To " + GetFightMode(),  3);
            }
            if (InCombat() == false)
            {
               if (Fatigue() > 97 && Sleeping() == false)
               {
                  DisplayMessage("@gre@SBoT: @whi@Sleeping", 3);
                  Use(FindInv(1263));
                  Wait(5000);
               } else {
                  if (Sleeping() == false)
                  {
                     int ID = GetNearestNPC(FightType);
                     if (ID != -1)
                     {
                        long T = System.currentTimeMillis();
                        AttackNPC(ID);
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
      DisplayMessage("@gre@SBoT: @whi@AutoFighter - @red@STOPPED", 3);
    }
}