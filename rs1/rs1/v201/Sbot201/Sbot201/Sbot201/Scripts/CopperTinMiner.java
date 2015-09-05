public class CopperTinMiner extends Script
{
   
    public CopperTinMiner(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"coppertinminer"};
    }
    public void start(String command, String parameter[])
    {

      
   DisplayMessage("@cya@CopperTinMiner: @or2@Copper @gre@and @or2@Tin Miner @ran@Start Near Varock East Bank! @gre@- @blu@Kimi", 3);
   while (Running())   
        {
        while (QuestMenu() == false && Running())
        {
           int Banker = GetNearestNPC(95);
           TalkToNPC(Banker);
           Wait(1000);
        } 
        Answer(0);
       while (! Bank() && Running())
       Wait(100);
       while (Bank() && Running())
       {
          while (InvCount(150) > 0)
       {
          Deposit(150,1);
          Wait(200);
       }
       while (InvCount(202) > 0)
       {
          Deposit(202,1);
          Wait(200);
       }
        while (InvCount(157) > 0)
       {
          Deposit(157,1);
          Wait(200);
       }
        while (InvCount(158) > 0)
       {
          Deposit(158,1);
          Wait(200);
       }
        while (InvCount(159) > 0)
       {
          Deposit(159,1);
          Wait(200);
       }
        while (InvCount(160) > 0)
       {
          Deposit(160,1);
          Wait(200);
       }
Wait(1000);           
CloseBank();
}
{
Walk(102,510);
Wait(50);
Walk(94,509);
Wait(50);
Walk(83,511);
Wait(50);
Walk(80,520);
Wait(50);
Walk(76,528);
Wait(50);
Walk(77,538);
Wait(50);
Walk(77,543);
Wait(50);
Walk(76,546);
Wait(100);
     
while (Running()  == true && InvCount() < 30)
             {
                                AtObject(75,546);
                                Wait(210);
                                ForceWalk(77,546);                               
                                Wait(940);
                                AtObject(78,546);
                                Wait(210);
                                ForceWalk(76,546);
                                Wait(940);

if (Fatigue() > 98)
{
         while (Sleeping() == false && Running() == true)
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
Walk(73,538);
Wait(100);
Walk(75,529);
Wait(100);
Walk(80,522);
Wait(100);
Walk(83,513);
Wait(100);
Walk(92,509);
Wait(100);
Walk(99,508);
Wait(100);
Walk(105,512);

}
DisplayMessage("@cya@CopperTinMiner: @red@Liek Omg Stopped",3);
}
}
} 