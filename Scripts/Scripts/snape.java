public class snape extends Script
{
    public snape(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"snape"};
    }
    public void start(String command, String parameter[])
    {
      DisplayMessage("@blu@Snape",3);
      while (Running())
      {
   Walk(287,572);
   Walk(291,581);
   Walk(295,591);
   Walk(304,598);
   Walk(312,602);
   Walk(322,607);
   Walk(331,611);
   Walk(334,615);
   Walk(344,621);
   Walk(351,620);
   Walk(359,615);
   while(InvCount() < 30)
      {

            TakeItem(358, 615, 469);
            Wait(500);
         }
   Walk(359,615);
   Walk(351,620);
   Walk(344,621);
   Walk(334,615);
   Walk(331,611);
   Walk(322,607);
   Walk(312,602);
   Walk(304,598);
   Walk(295,591);
   Walk(291,581);
   Walk(287,572);
      while (QuestMenu() == false)
           {
                  long T = System.currentTimeMillis();
                  int BankerID = GetNearestNPC(95);
                  TalkToNPC(BankerID);
                  while (System.currentTimeMillis() - T <= 6000 && QuestMenu() == false)
                        Wait(1);
           }
           Answer(0);
      Wait(2000);
      while(InvCount(469) > 0)
      {
         Deposit(469, 1);
         Wait(500);
      }
      }
      DisplayMessage("@blu@Stopped",3);
    }
}