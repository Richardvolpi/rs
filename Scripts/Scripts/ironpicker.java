public class ironpicker extends Script
{
    public ironpicker(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"ironpicker"};
    }
    public void start(String command, String parameter[])
    {
      DisplayMessage("@ran@Iron Picker",3);
      while (Running())   
        {
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
Wait(1000);           
CloseBank();
 Walk(103,510);
         Wait(200);
         Walk(99,508);
         Wait(200);
         Walk(92,508);
         Wait(200);
         Walk(84,509);
         Wait(200);
         Walk(75,535;
         Wait(200);
         Walk(74,542);
         Wait(200);      
   while (Running()  == true && InvCount() < 30)
	{
	TakeItem(75, 544, 151);
            Wait(500);             
         }
   Walk(74,535);
   Wait(100);
   Walk(79,520);
   Wait(100);
   Walk(81,512);
   Wait(100);
   Walk(92,507);
   Wait(100);
   Walk(102,509);
   Wait(100);
   Walk(101,511);
   Wait(100);
      }
      DisplayMessage("@red@Stopped",3);
    }
}