public class UberThiever extends Script
{
    public int thieved = 0;
    public UberThiever(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"thieving"};
    }
     public void ServerMessage(String message)
   {
      if (message.equals("@gam@You pick the warrior's pocket"))
         thieved++;
      if (message.equals("@whi@You pick the warrior's pocket"))
         thieved++;
   }   
       public void start(String command, String parameter[])
    {
    if (parameter.length != 1)
   {
   DisplayMessage("@gre@Bruncle: @whi@Invalid number of parameters. /RUN thievewarrior [STYLE]", 3);
   } else {
   int FightMode = Integer.parseInt(parameter[0]);
       DisplayMessage("@red@Warrior Thiever started", 3);
       int startlvl = GetStat(17);
       int slept = 0;
      while (Running())
     {
        if (ObjectAt(77,688) == 64)
   {
      AtObject(77,688);
   }
   if (ObjectAt(71,694) == 64)
   {
      AtObject(71,694);
   }
   if (ObjectAt(67,688) == 64)
   {
      AtObject(67,688);
   }
    if (Fatigue() >= 95 && Running() == true)
   {
      while (Sleeping() == false && Running() == true)
      {
         Use(FindInv(1263));
         Wait(2500);
      }
      while (Sleeping() == true && Running() == true)
         Wait(100);
         if (!Sleeping()) slept ++;
         }
   if(!InCombat())
   {
      int npc = GetNearestNPC(86);
      ThieveNPC(npc);
      SetFightMode(FightMode);
      Wait(700);
          }
   while(InCombat() && Running())
   {   
   SetFightMode(FightMode);
   WalkNoWait(GetX(),GetY() - 2);
   Wait(700);
   }
   if (!InCombat()) Wait(3000);
   }
   DisplayMessage("@red@UberThieve STOPPED", 3);
   int level = GetStat(17) - startlvl;
   System.out.println("You have thieved " + thieved + " warriors");
   System.out.println("You have gained " + level + " thieving levels");
   System.out.println("You have thieved " + thieved*18 + " gp");
   System.out.println("You have slept " + slept + " times");
   }
    }
}