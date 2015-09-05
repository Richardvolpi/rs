
public class JeebBronze extends Script

{
   public JeebBronze(mudclient rs)
   {
      super(rs);
   }
   public String[] getCommands()
   {
      return new String[]{"smeltone"};
   }
   public long StartS = (long)((int)(System.currentTimeMillis() / 1000));
   public int BronzeBars = 0;
   public int Trips = 0;
   public int LVL = 0;
   public void ServerMessage(String message)
   {
       if(message.equals("@gam@You retrieve a bar of bronze"))
       {
           BronzeBars++;
       }
       if(message.equals("@gre@You just advanced 1 smithing level!"))
       {
           LVL++;
       }
       
}
       public void start(String command, String parameter[])

    {
        DisplayMessage("@ran@B@ran@ronze @ran@S@ran@melter @ran@B@ran@y @ran@J@ran@eeb",3);
        while (Running() == true)
        {
       
         OpenBank();
     
       
    while (Bank() == true && Running() == true)
        {
            while(InvCount(169) > 0)
            {
                Deposit(169,1);
                Wait(1000);
            }

            while(InvCount(202) < 14)
            {
                Withdraw(202,1);
                Wait(1000);
            }
   
            while(InvCount(202) > 14)
            {
                Deposit(202,1);   
                Wait(1000);
            }

            while(InvCount(150) < 14)
            {
                Withdraw(150,1);
                Wait(1000);
            }
            while(InvCount(150) > 14)
            {
                Withdraw(150,1);
                Wait(1000);
            }
            CloseBank();
           
        while(ObjectAt(327,552) == 64)
          {
             AtObject2(327,552);
              Wait(1000);
          }
        }
       
        Walk(327,553);
        Walk(324,553);
        Walk(321,552);
        Walk(318,552);
        Walk(314,549);
        Walk(313,545);
        Walk(311,545);
        Wait(1000);
       
         while(DoorAt(309, 543, 0) == 2)
          {         
              OpenDoor(309, 543, 0);
              Wait(1000);
          }
       
        while (Running() == true && InvCount(202) < 14)
        {
           
            UseOnObject(310, 546, FindInv(202));
            Wait(2400);

            if(Fatigue() > 97 && Running() == true)
            {
                while (Sleeping() == false)
                {
                    Use(FindInv(1263));
                    Wait(3000);
                }

                while (Sleeping() == true)
                {
                    Wait(200);
                }
            }
        }
       

        Walk(315,550);
        Walk(321,551);
        Walk(327,552);
        Walk(329,553);
        Wait(1000);
        Trips++;
       
        while(ObjectAt(327,552) == 64)
          {
             AtObject(327,552);
              Wait(1000);
          }
          float Minutes = (float)((((float)System.currentTimeMillis() / 1000) - (float)StartS) / 60);
          Println("====================Progress Report====================");
          Println("Levels Gained: " +LVL);
          Println("Exp Gained: " +BronzeBars*6.5);
          Println("Number of Trips: " +Trips);
          Println("Minutes Running: " +Minutes);
          Println("Bronze Bars Made: " +BronzeBars);
          Println("====================End of Progress Report=============");

        }
        DisplayMessage("@red@STOPPED", 3);
    }
}