public class Pots extends Script
{
    public Pots(mudclient rs)
    {
        super(rs);
    }

   public String[] getCommands()
    {
        return new String[]{"pots"};
    }

   public void ServerMessage(String message)
    {

    }

    public void start(String command, String parameter[])
    {
        DisplayMessage("@gre@INFO: @whi@Strength Pot Maker Started!",3);
       while(Running() == true)
      {
         if(ObjectAt(150,507) == 64)
         {
             DisplayMessage("@gre@INFO: @whi@Opening door!",3);
             AtObject(150,507);
             Wait(1000);
         }

          Walk(149,511);
         Walk(149,520);
         Walk(143,522);
         Wait(3000);

          while(Running() == true && DoorAt(143, 522, 0) == 2)
          {
              DisplayMessage("@gre@INFO: @whi@Opening door!",3);
              OpenDoor(143, 522, 0);
              Wait(1000);
          }

          while(Running() == true && InvCount(220) > 0 && InvCount(219) > 0)
          {
              int ApothecaryID = GetNearestNPC(33);

             if(ApothecaryID != -1)
               {
               TalkToNPC(ApothecaryID);
               
               Wait(2000);

               while(Running() == true && QuestMenu() == true)
                  {
                     
                     
                     Wait(1000);
                     Answer(0);

               }
                 
                 
              }

            

            while(Running() == true && QuestMenu() == true)
              {
                 
                 
                 Wait(1000);
                 Answer(0);
              }
             
             

            
          }

          Walk(143,522);
          Walk(149,520);
          Walk(150,507);
         
          if(ObjectAt(150,507) == 64)
         {
             DisplayMessage("@gre@INFO: @whi@Opening door!",3);
              AtObject(150,507);
              Wait(1000);
          }
          
         while(Running() == true && Bank() == false)
         
         {
          
          int BankersID = GetNearestNPC(95);

             if(BankersID != -1)
               {
               TalkToNPC(BankersID);
               
               Wait(500);

               

               while(Running() == true && QuestMenu() == true)
                  {
                     
                  Wait(2000);
                  Answer(0);
                    
                  }
                 
            }
         }

            
            if(Running() == true && Bank() == true)
            {
                    Deposit(221, 5);
                    Wait(100);
                    Deposit(221, 5);
                    Wait(100);
                    Deposit(221, 1);
                    Wait(100);
                    Deposit(221, 1);
                    Wait(100);
                    Deposit(221, 1);
                    Wait(100);
               Deposit(221, 1);
               
               Wait(1000);
               
               Withdraw(219, 1);
               Wait(100);
                   Withdraw(219, 1);
                   Wait(100);
                    Withdraw(219, 1);
                    Wait(100);
                    Withdraw(219, 1);
                    Wait(100);
                    Withdraw(219, 1);
                    Wait(100);
                    Withdraw(219, 1);
                    Wait(100);
                    Withdraw(219, 1);
               Wait(100);
                   Withdraw(219, 1);
                   Wait(100);
                    Withdraw(219, 1);
                    Wait(100);
                    Withdraw(219, 1);
                    Wait(100);
                    Withdraw(219, 1);
                    Wait(100);
                    Withdraw(219, 1);
                    Wait(100);
                    Withdraw(219, 1);
                    Wait(100);
                    Withdraw(219, 1);
                   
                    Wait(1000);
                   
                    Withdraw(220, 1);
                    Wait(100);
                    Withdraw(220, 1);
                    Wait(100);
                    Withdraw(220, 1);
                    Wait(100);
                    Withdraw(220, 1);
                    Wait(100);
                    Withdraw(220, 1);
                    Wait(100);
                    Withdraw(220, 1);
                    Wait(100);
                    Withdraw(220, 1);
                    Wait(100);
                    Withdraw(220, 1);
                    Wait(100);
                    Withdraw(220, 1);
                    Wait(100);
                    Withdraw(220, 1);
                    Wait(100);
                    Withdraw(220, 1);
                    Wait(100);
                    Withdraw(220, 1);
                    Wait(100);
                    Withdraw(220, 1);
                    Wait(100);
                    Withdraw(220, 1);

                   
            }
                   
                    Wait(1000);
                   
                    CloseBank();
                   
                    Walk(150,504);
                   
                   

            }
            DisplayMessage("@gre@INFO: @whi@Strength Pot Maker Stopped",3);
   }
} 