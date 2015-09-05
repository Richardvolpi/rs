public class EdgeFlyFisher extends Script

{
    public EdgeFlyFisher(mudclient rs)
    {
        super(rs);
     
    }
    public String[] getCommands()
    {
        return new String[]{"flyfish"};
     
    }
    public void start(String command, String parameter[])
       {
      DisplayMessage("@ran@.@ran@:@ran@{ @whi@Edge Fly Fisher + Banking @ran@}@ran@:@ran@:@ran@.", 3);
      DisplayMessage("@ran@.@ran@:@ran@{ @whi@Created By LatOr @ran@}@ran@:@ran@:@ran@.", 3);

      while (Running())
      {
          {
         while (Running()  == true && InvCount() < 30)
         {
            if (Fatigue() >= 95 && Running() == true)
            {
               while (Sleeping() == false)
               {
                  Use(FindInv(1263));
               Wait(2500);
               }
               while (Sleeping() == true)
               {
                  Wait(100);
               }
            }
           
               AtObject(208,501);
               Wait(1000);
         }           
                 
      Walk(212,500);
      Walk(215,497);
      Walk(216,485);
      Walk(217,480);
      Walk(221,471);
      Walk(224,468);
      Walk(224,460);
      Walk(221,455);
      Walk(221,449);
      Walk(225,444);
      Walk(226,440);

      while(GetY() < 1000 && Running() == true)
         {
             AtObject(226,439);
             Wait(1000);
         }

        while (Fatigue() < 96 && Running()  == true && InvCount(356) > 0)
         {
            UseOnObject(222,1385,FindInv(356));
            Wait(2600);

                if (Fatigue() >= 96 && Running() == true)
                {
                    while (Sleeping() == false)
                    {
                        Use(FindInv(1263));
                        Wait(2500);
                    }
   
                    while (Sleeping() == true)
                    {
                        Wait(100);
                    }
                }
         }


         while (Fatigue() < 96 && Running()  == true && InvCount(358) > 0)
         {
            UseOnObject(222,1385,FindInv(358));
            Wait(2600);

                if (Fatigue() >= 96 && Running() == true)
                {
                    while (Sleeping() == false)
                    {
                        Use(FindInv(1263));
                        Wait(2500);
                    }
   
                    while (Sleeping() == true)
                    {
                        Wait(100);
                    }
                }
           }


         while(GetY() > 1000 && Running() == true)
         {
             AtObject(226,1383);
             Wait(1000);
         }
         Walk(225,443);
         Walk(221,445);
         Walk(216,447);
         Walk(218,449);
         

     
   
       while (QuestMenu() == false)
  {
        int BankerID = GetNearestNPC(95);
        TalkToNPC(BankerID);
        Wait(1000);
  }
        Answer(0);
        while (Bank() == false)
           Wait(2000);
        while (InvCount(359) > 1)
  {
           Deposit(359,1);
           Wait(100);
      }
      while (InvCount(357) > 1)
      {
         Deposit(357,1);
         Wait(100);
  }
        CloseBank();

   
   Walk(219,447);
   Walk(221,451);
   Walk(221,456);
   Walk(222,470);
   Walk(222,472);
   Walk(221,470);
   Walk(219,475);
   Walk(218,479);
   Walk(216,484);
   Walk(215,490);
   Walk(214,496);
   Walk(211,499);
         
   
      }}
     
      DisplayMessage("@whi@EdgeFlyFisher: @red@STOPPED", 3);
    }
}
