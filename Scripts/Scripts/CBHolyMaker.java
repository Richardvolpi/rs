//Start in west fally bank
//Make sure u ONLY have the holy symbol mold and sleeping bag in your inventory.
//Made by CanadianBacon
//Props to RichyT, and RSCN <3
public class CBHolyMaker extends Script
      {
  public CBHolyMaker(mudclient rs)
      {
     super(rs);
      }
  public String[] getCommands()
      {
     return new String[]{"holysymbols"};
      }
  public void start(String command, String parameter[])
      {
     while (Running())
      {
       while (QuestMenu() == false && Running() == true)
      {
           int BankerID = GetNearestNPC(95);
           TalkToNPC(BankerID);
           Wait(2000);
      }
       Answer(0);

           while (Bank() == false && Running() == true)
      {
               Wait(100);
      }

           while (Bank() == true && Running() == true)
      {
           while(InvCount(44) > 0)
      {
               Deposit(44,1);
               Wait(100);
      }

           while(InvCount(384) < 28)
      {
               Withdraw(384,1);
               Wait(100);
      }
               CloseBank();
      }
            AtObject(327,552);
            Wait(2000);
            Walk(321,552);
            Wait(100);
            Walk(315,550);
            Wait(100);
            Walk(312,544);
            Wait(100);
            OpenDoor(312, 544, 1); 
            Walk(311,544);
          
       DisplayMessage("@ran@CB Says: Holy Making Time",3);   
           while (InvCount(384) > 0)
      {
        UseOnObject(310,546,FindInv(384));
        Wait(3000);

   for(; !QuestMenu(); Wait(10));
        Answer(0);
        Wait(1000);
        
        if(Fatigue() > 90 && Running() == true)
      {
        while (Sleeping() == false)
      {
           Use(FindInv(1263));
           Wait(2800);
      }
        while (Sleeping() == true)
      {
           Wait(200);
      }
      }
      }
            OpenDoor(312, 544, 1);
            Walk(314,548);
           Wait(100);
           Walk(317,551);
           Wait(100);
           Walk(322,553);
           Wait(100);
           AtObject(327,552);
           Wait(1000);
           Walk(328,552);
           Wait(200);         
     }
}
}