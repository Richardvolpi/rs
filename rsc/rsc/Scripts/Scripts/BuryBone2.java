public class BuryBone2 extends Script
{
    public int prayerlevels = GetStat(5), bones = 0, exp = 0;
    public BuryBone2(mudclient rs)
    {
        super(rs);
    }
   
    public String[] getCommands()
    {
        return new String[]{"bonebury","bigbonebury","dragonbonebury","batbonebury"};
     }
      public void ServerMessage(String message)
   {
      if (message.equals("@gam@You bury the bones"))
      {
         System.out.println("Buried Bones.. Bones Burried " + (bones + 1));
         bones++;
    exp+=3;
      } else
      if (message.equals("@gre@You just advanced 1 prayer level!"))
      {
         Wait(1000);
         System.out.println("Prayer Level! Current Prayer Level: " + GetStat(5));
         prayerlevels++;
      }
   }
       public void start(String command, String parameter[])
    {
       DisplayMessage("@dre@=@whi@=@dre@= @lre@Bone Bury Script Started - By Fert @dre@=@whi@=@dre@=", 3);

      int Level = Integer.parseInt(parameter[0]);
      if (command.equalsIgnoreCase("bonebury"))
      {
      while (Running())
   
    {
   int i[] = GetNearestItem(20);
   TakeItem(i[0], i[1], 20);
   Wait(500);
   while(InvCount() > 1)
   {
     Use(FindInv(20));
     Wait(2000);
   }
 
   if (Fatigue() > 95 && Sleeping() == false)
               {
            DisplayMessage("@Dre@SBoT: @whi@Sleeping", 3);
                  Use(FindInv(1263));
                  Wait(5000);
               }
   
   
   if (GetStat(5) == (Level))
   {
     System.out.println(""+System.getProperty("user.name")+", You Have Reached Your Desired Prayer Level, Closing SBoT...");
     System.out.println("<3 FeRtY");
     Quit();
   }; 
   
   }
   }
   
         if (command.equalsIgnoreCase("bigbonebury"))
      {
      while (Running())
   
    {
   int i[] = GetNearestItem(413);
   TakeItem(i[0], i[1], 413);
   Wait(500);
   while(InvCount() > 1)
   {
     Use(FindInv(413));
     Wait(2000);
   }
 
   if (Fatigue() > 95 && Sleeping() == false)
               {
            DisplayMessage("@Dre@SBoT: @whi@Sleeping", 3);
                  Use(FindInv(1263));
                  Wait(5000);
               }
   
   
   if (GetStat(5) == (Level))
   {
     System.out.println(""+System.getProperty("user.name")+", You Have Reached Your Desired Prayer Level, Closing SBoT...");
     System.out.println("<3 FeRtY");
     Quit();
   }; 
   
   }
   }
   
         if (command.equalsIgnoreCase("dragonbonebury"))
      {
      while (Running())
   
    {
   int i[] = GetNearestItem(814);
   TakeItem(i[0], i[1], 814);
   Wait(500);
   while(InvCount() > 1)
   {
     Use(FindInv(814));
     Wait(2000);
   }
 
   if (Fatigue() > 95 && Sleeping() == false)
               {
            DisplayMessage("@Dre@SBoT: @whi@Sleeping", 3);
                  Use(FindInv(1263));
                  Wait(5000);
               }
   
   
   if (GetStat(5) == (Level))
   {
     System.out.println(""+System.getProperty("user.name")+", You Have Reached Your Desired Prayer Level, Closing SBoT...");
     System.out.println("<3 FeRtY");
     Quit();
   }; 
   
   }
   }
   
   if (command.equalsIgnoreCase("batbonebury"))
      {
      while (Running())
   
    {
   int i[] = GetNearestItem(604);
   TakeItem(i[0], i[1], 604);
   Wait(500);
   while(InvCount() > 1)
   {
     Use(FindInv(604));
     Wait(2000);
   }
 
   if (Fatigue() > 95 && Sleeping() == false)
               {
            DisplayMessage("@Dre@SBoT: @whi@Sleeping", 3);
                  Use(FindInv(1263));
                  Wait(5000);
               }
   
   
   if (GetStat(5) == (Level))
   {
     System.out.println(""+System.getProperty("user.name")+", You Have Reached Your Desired Prayer Level, Closing SBoT...");
     System.out.println("<3 FeRtY");
     Quit();
   }; 
   
   }
   }

DisplayMessage("@dre@=@whi@=@dre@= @dre@Bone Bury Script STOPPED @dre@=@whi@=@dre@=", 3);
    }
}