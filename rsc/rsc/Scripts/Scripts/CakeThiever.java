public class CakeThiever extends Script
{
    public CakeThiever(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"thievecakes"};
    }
    public void start(String command, String parameter[])
    {
      DisplayMessage("@ran@=@ran@=@ran@=@ran@=@ran@= @whi@Cake Thiever & Banker Activated! @ran@=@ran@=@ran@=@ran@=@ran@=",3);
      DisplayMessage("@ran@=@ran@=@ran@=@ran@=@ran@= @whi@Created by SaladFork! Edit by XxChanxX @ran@=@ran@=@ran@=@ran@=@ran@=",3);
      SetFightMode(3);
      while (Running())
      {
         Walk(549,612);
         Walk(546,607);
         Walk(545,603);
    Walk(545,601);
    ForceWalk(543,600);
    ForceWalk(543,599);
         TakeItem(543,599,0);
         while (InvCount() < 30 && Running() == true)
         {
            if (Fatigue()>=95&&Running()==true)
            {
               while (Sleeping()==false&&Running()==true)
               {
                  Use(FindInv(1263));
                  Wait(2500);
               }
               while (Sleeping()==true&&Running()==true)
                  Wait(1000);
            }
            int CakeStallCoords[] = GetNearestObject(322);
            if (CakeStallCoords[0] > -1 & Running() == true)
               AtObject2(544,599);
            Wait(1);
         }
         Walk(545,603);
         Walk(546,607);
         Walk(549,612);
         Walk(551,612);   
         int BankerID = GetNearestNPC(95);
         while (QuestMenu() == false)
         {
            TalkToNPC(BankerID);
            Wait(1000);
         }
         Answer(0);
         while (Bank() == false)
            Wait(1);
         while (InvCount(330) > 0 && Running() == true)
         {
            Deposit(330,1);
            Wait(100);
         }
         CloseBank();
      }
      DisplayMessage("@red@STOPPED", 3);
    }
}