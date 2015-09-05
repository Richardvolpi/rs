public class GoblinVillage extends Script
{
    public GoblinVillage(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"goblins"};
    }
    public void start(String command, String parameter[])
    {
      if (parameter.length != 1)
      {
         DisplayMessage("@gre@SBoT: @whi@Invalid number of parameters. /RUN GOBLINS [STYLE]", 3);
      } else {
         int FightMode = Integer.parseInt(parameter[0]);
         int FightTime = (Rand(750,1500)); 
         CheckFighters(true);
         DisplayMessage("@gre@SBoT: @whi@Goblin Village AutoFighter @dre@ pWNED by fAcelEss", 3);
         while (Running() == true)
         {
            if (GetFightMode() != FightMode)
            {
               SetFightMode(FightMode);
               DisplayMessage("@gre@SBoT: @whi@FightMode Changed To " + GetFightMode(),  3);
            }
            if (InCombat() == false)
            {
          
          if (GetY() > 468 && Sleeping() == false)
          {
                DisplayMessage("@dre@Anti-Wander Activated! Moving back to the village.", 3);
      Walk(329,457);
      Walk(324,448);
      Wait(1000);
          }
          if (GetX() <= 330 && GetX() >= 327 && GetY() >= 446 && GetY() <= 449 && DoorAt(327, 447, 1) == 2)
          {
           DisplayMessage("@dre@Anti-Trap Activated! Opening door...", 3);
      OpenDoor(327, 447, 1);
      Wait(5000);
          }
          if (GetX() <= 322 && GetX() >= 316 && GetY() >= 448 && GetY() <= 454 && DoorAt(321, 450, 3) == 2)
          {
           DisplayMessage("@dre@Anti-Trap Activated! Opening door...", 3);
      OpenDoor(321, 450, 3);
      Wait(5000);
          }
          if (GetX() <= 322 && GetX() >= 319 && GetY() >= 441 && GetY() <= 444 && DoorAt(320, 445, 0) == 2)
          {
              DisplayMessage("@dre@Anti-Trap Activated! Opening door...", 3);
      OpenDoor(320, 445, 0);
      Wait(5000);
          }
          if (GetStat(3) - GetCurrentStat(3) > 12 && Sleeping() == false)
          {
                  DisplayMessage("@gre@SBoT: @whi@Eating...", 3);
        Use(FindInv(373));
        Wait(1000);
          }
               if (Fatigue() > 97 && Sleeping() == false)
               {
                  DisplayMessage("@gre@SBoT: @whi@Sleeping", 3);
                  Use(FindInv(1263));
                  Wait(5000);
               } else {
                  if (Sleeping() == false)
                  {
           int ID[] = new int[] {153, 154};
                     int Goblins = GetNearestNPC(ID);
                     if (Goblins != -1)
                     {
                        long T = System.currentTimeMillis();
                        AttackNPC(Goblins);
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
      DisplayMessage("@gre@SBoT: @whi@Goblin Village AutoFighter - @red@STOPPED", 3);
    }
}