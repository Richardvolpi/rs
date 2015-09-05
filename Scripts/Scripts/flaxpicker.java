public class flaxpicker extends Script
{
    public flaxpicker(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"flax"};
    }
    public void start(String command, String parameter[])
    {
     DisplayMessage("@or2@sbot:@ran@flaxpicker started, made by Jaggs", 3);
     while (Running())
     {
     while (InvCount() < 30 )
     {
     int FlaxCoords[] = GetNearestObject(313);
     if (FlaxCoords[0] > -1 & Running() == true)
     AtObject2(FlaxCoords[0],FlaxCoords[1]);
     Wait(200);
     }
     if (InvCount() == 30)
     {
     Walk(494,478);
     Walk(496,476);
     Walk(497,475);
     Walk(504,467);
     Walk(501,464);
     Walk(501,457);
     Walk(502,460);
     Walk(500,453);
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
      while (InvCount(675) > 0)
           {
            Deposit(675,1);
            Wait(100);     
           }
         CloseBank();       
 
   
}
DisplayMessage("@red@STOPPED", 3);
    }
}}}