public class FFlaxSpin extends Script
{
   public FFlaxSpin(mudclient rs)
   {
       super(rs);
   }
   public String[] getCommands()
   {
       return new String[]{"flaxxy"};
   }
 public int FlaxBank = 0;
 public int level = 0;
   

public void ServerMessage(String message)
  {
if(message.equals("@gre@You just advanced 1 crafting level!"))
      {
          level++;
      }

}



public void start(String command, String parameter[])
   {
      DisplayMessage("@gre@A @cya@Ownage @blu@Spinner @red@bye @ran@{{zym}oti} <3", 3);
      while(Running())
      {
     while(InvCount(676) >= 1 || InvCount(675) <= 28  && Running())
      {
       OpenBank();
                 
                      while (InvCount(676) >= 1)
     {
                      Deposit(676,1);
                      Wait(50);
     }
                      while (InvCount(675) <= 29)
     {
                      Withdraw(675,1);
                      Wait(50);
     }
                      FlaxBank = BankCount(675);
                      CloseBank();
                 


Println("Amount of flax in bank = " +FlaxBank);
Println("Levels Gained: " +level);






            Walk(286,571);
                 if(DoorAt(287,571,0) == 2)
        {
                  OpenDoor(287,571,0);
          Wait(Rand(100,500));
        }
         
           Walk(288,572);
           Walk(290,574);
           Walk(292,576);
           Walk(296,576);
           Walk(297,576);
                   if(DoorAt(297,577,0) == 2)
        {
                    OpenDoor(297,577,0);
           Wait(Rand(100,500)); 
        }
           Walk(296,579);
                   while (InvCount(675) > 0)
        {
                   UseOnObject(295,579,(FindInv(675)));
           Wait(700);
                   if (Fatigue() > 90 && Running())
        {
                    while (!Sleeping() && Running())
        {
                 
                    DisplayMessage("@blu@nap time! <3 zym", 3);
                     Use(FindInv(1263));
                     Wait(6754);
             
         }
                      while (Sleeping() && Running())
         {
          Wait(Rand(100,500));
         }
         }
         }
                    if(InvCount(676) == 30)
        {
           Walk(297,577);
                    if(DoorAt(297,577,0) == 2)
        {
                    OpenDoor(297,577,0);
         Wait(Rand(100,500));
        }
          Walk(294,575);
          Walk(292,574);
          Walk(288,572);
          Walk(287,572);
                    if(DoorAt(287,571,0) == 2)
        {
                    OpenDoor(287,571,0);
          Wait(Rand(100,500));

        }
           Walk(283,569);
        }
     }
  }
  DisplayMessage("@ran@ terminda <3",3);
   }
}