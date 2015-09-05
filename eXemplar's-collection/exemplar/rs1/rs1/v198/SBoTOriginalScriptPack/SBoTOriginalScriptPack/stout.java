public class stout extends Script
{
    public stout(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"stout"};
    }
    public void start(String command, String parameter[])
    {
   DisplayMessage("@whi@Jake: @gre@Buying Stoutsz", 3);
   while (Running())
      {   
        while(InvCount() < 30)
           {       
              while(QuestMenu() == false)
                         {
                                long T = System.currentTimeMillis();
                                int stoutlady = GetNearestNPC(142);
                                TalkToNPC(stoutlady);
                                while (System.currentTimeMillis() - T <= 6000 && QuestMenu() == false)
                                   Wait(1);
                         }
                 Answer(2);
                 Wait(750);
              }
      Walk(323,547);
      while(DoorAt(324,547,0) == 2)
      {
         OpenDoor(324,547,1);
         Wait(1500);
      }
      Walk(324,547);
      while(ObjectAt(327,552) == 64)
      {
         AtObject(327,552);
         Wait(1500);
      }
      Walk(328,552);

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
      while(InvCount(269) > 0)
      {
         Deposit(269, 1);
         Wait(50);
      }   
      CloseBank();
      Walk(328,552);
      while(ObjectAt(327,552) == 64)
      {
         AtObject(327,552);
         Wait(1500);
      }
      Walk(324,547);
      while(DoorAt(324,547,0) == 2)
      {
         OpenDoor(324,547,1);
         Wait(1500);
      }
      Walk(323,547);

}
DisplayMessage("@whi@Jake: @red@Stout Buyer Stopped!", 3);
}
} 