public class drunkenwizard extends Script
{
   public drunkenwizard(mudclient rs)
   {
      super(rs);
   }
   public String[] getCommands()
   {
      return new String[]{"drunkwiz"};
   }
   public void start(String command, String parameter[])
   {
   int FMode = Integer.parseInt(parameter[0]);
         int FTime = 1200;
         CheckFighters(true);
      DisplayMessage("suicide dark wizards - by @gre@Drunkenmuzz" + GetFightMode(),3);
      while (Running() == true && GetCurrentStat(2) < 60)
      {
   if (GetFightMode() != FMode)
            {
               SetFightMode(FMode);
               DisplayMessage("@whi@FightMode Changed To " + GetFightMode(),  3);
            }

   if (InCombat() == false)
   {
   if (GetY() > 645 && Sleeping() == false)
   {
   DisplayMessage("@gre@Walking to Dark Wizards", 3);
   Wait(2000);
   Walk(126,644);
   Walk(134,637);
   Walk(134,629);
   Walk(134,623);
   Walk(124,625);
   Walk(113,625);
   Walk(110,614);
   Walk(113,601);
   Walk(107,588);
   Walk(96,579);
   Walk(102,572);
   Walk(115,567);
   Walk(116,557);
   Wait(2000);
   }

   if (Fatigue() > 95 && Sleeping() == false)
   {
   Use(FindInv(1263));
   Wait(8000);
   }else {
   if (Sleeping() == false)
   {
      int ID = GetNearestNPC(57);
      if (ID != -1)
   {
   long T = System.currentTimeMillis();
   AttackNPC(ID);
   while (System.currentTimeMillis() - T <= FTime && InCombat() == false && Running() == true)
   Wait(1);
   } else
   Wait(1);
   }
   }
   }
   while (InCombat() == true && Running() == true)
   Wait(1);
}

      }
   
} 