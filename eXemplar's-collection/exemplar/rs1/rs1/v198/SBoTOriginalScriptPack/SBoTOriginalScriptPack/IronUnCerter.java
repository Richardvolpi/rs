public class IronUnCerter extends Script
{
    public IronUnCerter(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"uncertiron"};
    }
    public void start(String command, String parameter[])
    {
      DisplayMessage("@ran@=@ran@=@ran@=@ran@=@ran@= @whi@Iron Uncerter Activated! @ran@=@ran@=@ran@=@ran@=@ran@=",3);
      DisplayMessage("@ran@=@ran@=@ran@=@ran@=@ran@= @whi@Created by SaladFork! @ran@=@ran@=@ran@=@ran@=@ran@=",3);
      while (Running())
      {
         Walk(220,632);
         Walk(225,632);
         Walk(228,631);
         while (QuestMenu() == false)
         {
            int GilesID = GetNearestNPC(225);
            TalkToNPC(GilesID);
            Wait(1000);
         }
         Answer(0);
         Wait(1000);
         while (QuestMenu() == false)
            Wait(1);
         Answer(0);
         Wait(1000);
         while (QuestMenu() == false)
            Wait(1);
         Answer(4);
         Wait(1000);
         Walk(228,631);
         Walk(225,632);
         Walk(220,632);
         Walk(219,634);
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
      }
      DisplayMessage("@red@STOPPED", 3);
    }
}