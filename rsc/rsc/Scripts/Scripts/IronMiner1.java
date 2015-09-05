public class IronMiner1 extends Script
{
    public IronMiner1(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"mineiron1"};
    }
    public void start(String command, String parameter[])
   //You dont need to change the line above.
    {
      DisplayMessage("<3@ran@=@ran@=@ran@=@ran@=@ran@= @whi@Iron Miner And Banker Activated! @ran@=@ran@=@ran@=@ran@=@ran@=<3",3);
      DisplayMessage("<3@ran@=@ran@=@ran@=@ran@=@ran@= @whi@Created by Silence Xll! @ran@=@ran@=@ran@=@ran@=@ran@=<3",3);
      while (Running())
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
            int RockCoords[] = GetNearestObject(102);
            if (RockCoords[0] > 317 && Running() == true)
               AtObject(RockCoords[0],RockCoords[1]);
            Wait(100);
         }
         Walk(317,637);
         Wait(100);
         Walk(316,634);
         Wait(100);
         Walk(316,631);
         Wait(100);
         Walk(312,627);
         Wait(100);
         Walk(309,623);
         Wait(100);
         Walk(306,620);
         Wait(100);
         Walk(304,618);
         Wait(100);
         Walk(301,613);
         Wait(100);
         Walk(299,600);
         Wait(100);
         Walk(293,601);
         Wait(100);
         Walk(292,596);
         Wait(100);
         Walk(291,591);
         Wait(100);
         Walk(291,586);
         Wait(100);
         Walk(291,579);
         Wait(100);
         Walk(290,573);
         Wait(100);
         Walk(286,571);
         Wait(100);
         while (QuestMenu() == false)
         {
            int BankerID = GetNearestNPC(95);
            TalkToNPC(BankerID);
            Wait(1000);
         }
         Answer(0);
         while (Bank() == false)
            Wait(1);
         while (InvCount(151) > 0)
         {
            Deposit(151,1);
            Wait(100);
         }
         while (InvCount(157) > 0)
         {
            Deposit(157,1);
            Wait(100);
         }
         while (InvCount(158) > 0)
         {
            Deposit(158,1);
            Wait(100);
         }
         while (InvCount(159) > 0)
         {
            Deposit(159,1);
            Wait(100);
         }
         while (InvCount(160) > 0)
         {
            Deposit(160,1);
            Wait(100);
         }
         CloseBank();
         Walk(286,571);
         Wait(100);
         Walk(290,573);
         Wait(100);
         Walk(291,579);
         Wait(100);
         Walk(291,586);
         Wait(100);
         Walk(291,591);
         Wait(100);
         Walk(292,596);
         Wait(100);
         Walk(293,601);
         Wait(100);
         Walk(299,600);
         Wait(100);
         Walk(301,613);
         Wait(100);
         Walk(304,618);
         Wait(100);
         Walk(306,620);
         Wait(100);
         Walk(309,623);
         Wait(100);
         Walk(312,627);
         Wait(100);
         Walk(316,631);
         Wait(100);
         Walk(316,634);
         Wait(100);
         Walk(317,637);
         Wait(100);
      }
      DisplayMessage("@red@STOPPED", 3);
    }
}