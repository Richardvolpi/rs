//Dummy Trainer with Banker by fAcelEss
//Start near the dummies with either a full
//load of Stouts or a full load of beer
//glasses. If you have a full load of glasses
//it will go and bank them and get stouts
//instead.

public class DummyTrainerPublic extends Script

{
    public DummyTrainerPublic(mudclient rs)
    {
        super(rs);
      
    }
    public String[] getCommands()
    {
        return new String[]{"dummy"};

    }
    public void start(String command, String parameter[])

   {
      
      DisplayMessage("@gre@SBoT: @whi@Dummy Trainer @gre@- @or2@fAcelEss", 3);
      while (Running())
      {
         {
               while (Running()  == true && InvCount(269) > 0)
               {
               DisplayMessage("@or2@Attacking something that can't fight back...", 3);
               AtObject(104,500);
               Wait(2500);
               if (GetCurrentStat(0) > 7)
                     {
                        Wait(2500);
                        Walk(103,501);
                        Wait(1000);
                        Use(FindInv(269));
                        Wait(2500);
                     }
               if (Fatigue() > 97 && Running() == true)
                     {
                        while (Sleeping() == false)
                        {
                           Use(FindInv(1263));
                        Wait(2500);
                        }
                        while (Sleeping() == true && Running() == true)
                        {
                           Wait(100);
                        }
                     }
               }
         }
            {
            DisplayMessage("@or2@Banking...", 3);
            Walk(104,505);
            Walk(105,509);
            Wait(2000);

            DisplayMessage("@or2@Depositing Glasses", 3);
            while(!QuestMenu())
                     {
                           int Banker = GetNearestNPC(95);
                            TalkToNPC(Banker);
                                   Wait(1000);
                     }
                     Answer(0);
               Wait(50);
         
            while(InvCount(620) > 0)
            {
               Deposit(620,1);
               Wait(100);
            }
            CloseBank();
            Wait(1000);

            DisplayMessage("@or2@Withdrawing Stouts", 3);
            while(!QuestMenu())
                     {
                           int Banker = GetNearestNPC(95);
                            TalkToNPC(Banker);
                                   Wait(1000);
                     }
                     Answer(0);
               Wait(50);
            while (InvCount(269) < 29)
            {
               Withdraw(269,1);
               Wait(100);
            }
            CloseBank();
                 Wait(1000);
            Walk(105,504);
            Wait(1500);                     
         }
      }

      DisplayMessage("@red@STOPPED", 3);
   }
}