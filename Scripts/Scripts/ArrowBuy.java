public class ArrowBuy extends Script
{
   public ArrowBuy (mudclient rs)
   {
      super(rs);
   }
   public String[] getCommands()
   {
      return new String[]{"buyboth", "buyarrows", "buybolts"}; 
   }
   public void start(String command, String parameter[])
   {

        int IN_HOUSE = 0;
        int ARROWS = 0;
        int BOLTS = 0;
        String WHAT = null;

        if (command.equalsIgnoreCase("buyboth")) 
        {
            ARROWS = 1;
            BOLTS = 1;
            WHAT = "Buying Both Arrows & Bolts";
        }       

        if (command.equalsIgnoreCase("buyarrows")) 
        {
            ARROWS = 1;
            WHAT = "Buying Only Arrows";   
        }

        if (command.equalsIgnoreCase("buybolts")) 
        {
            BOLTS = 1;
            WHAT = "Buying Only Bolts";
        }

      DisplayMessage("@cya@MR_L337 tells you: " + WHAT, 3);
      while (Running())
      {

      if (GetX() >= 113 && GetX() <= 116 && GetY() >= 511 && GetY() <= 516)

      {

           if (IN_HOUSE != 1)
           {
           IN_HOUSE = 1;
           }

      }

      else if (IN_HOUSE != 0)

      {
      IN_HOUSE = 0;
      }


      if (LoggedIn())

      {

         if (InvCount(10) > 10)

         {

            if (IN_HOUSE == 1)

            {

                while (!Shop())
               
                {
 
                     while (!QuestMenu())
                     {

                          TalkToNPC(GetNearestNPC(58));
                          long Time = System.currentTimeMillis();
                          while (System.currentTimeMillis() - Time <= 2000 && !QuestMenu())
                          Wait(1);
                     }

                     Answer(0);
                     long Time = System.currentTimeMillis();
                     while (System.currentTimeMillis() - Time <= 5000 && !Shop())
                     Wait(1);

                }

                if (Shop())

                {

                     if (ARROWS == 1)

                     {
                     Buy(11);
                     Wait(100);

                     }

                     if (BOLTS == 1)

                     {
                     Buy(190);
                     Wait(100);
                     }

                }

            }

            else

            {

                  if (DoorAt(115, 511, 0) == 2)

                  {
                  OpenDoor(115, 511, 0);
                  Wait(2500);
                  }

                  else

                  {
                  ForceWalkNoWait(114,513);
                  Wait(1000);
                  }


            }



         }

         else

         {
         System.out.println("Ran Out Of Money, Quitting...");
         Quit();
         }

      }
     


      }
   }
}