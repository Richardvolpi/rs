public class CookSharks extends Script 

{ 
  public CookSharks(mudclient rs) 
  { 
      super(rs); 

  } 
  public String[] getCommands() 
  { 
      return new String[]{"cooksharks"}; 

  } 
  public void start(String command, String parameter[]) 

  { 

    DisplayMessage("@gre@SBoT: @cya@S@blu@h@cya@a@blu@r@cya@k @blu@C@cya@o@blu@o@cya@k@blu@e@cya@r", 3); 
    while (Running()) 

    { 
       while (ObjectAt(439,497) == 64) 
       { 
       AtObject(439,497); 
       Wait(100); 
       } 
       Walk(426,485); 
       while(DoorAt(427,485,1) == 2) 
    { 
       OpenDoor(427,481,1); 
       Wait(100); 
    } 
       int Owen = GetNearestNPC(299); 
       TalkToNPC (Owen); 
       while (QuestMenu() == false) 
       { 
          Wait(100); 
       } 
       Answer(0); 
       while (QuestMenu() == false) 
       { 
          Wait(100); 
       } 
       Answer(1); 
       Wait(100); 
       while (QuestMenu() == false) 
       { 
          Wait(100); 
       } 
       Answer(4); Wait(1000); 
       while(DoorAt(427,485,1) == 2) 
    { 
       OpenDoor(427,481,1); 
       Wait(100); 
    } 
       Walk(435,486); 
       while(DoorAt(435,486,0) == 2) 
    { 
       OpenDoor(435,486,0); 
       Wait(100); 
    } 
       Walk(432,482); 
       while (InvCount(545) > 0 && Fatigue() != 100) 
       { 
          UseOnObject(432,480,FindInv(545)); 
          Wait(500); 
       } 
          if (Fatigue() == 100 && Running() == true) 
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
     if (InvCount(547) > 0) 
     { 
        Drop(FindInv(547)); 
        Wait(300); 
     } 
      while(DoorAt(435,486,0) == 2) 
    { 
       OpenDoor(435,486,0); 
       Wait(100); 
    } 
     Walk(439,497); 
     while (ObjectAt(439,497) == 64) 
       { 
       AtObject(439,497); 
       Wait(100); 
       } 
      Walk(439,494); 
      int Banker = GetNearestNPC(95); 
      TalkToNPC(Banker); 
      while (QuestMenu() == false) 
      {Wait(100);} 
      Answer(0); 
      while (Bank() == false) 
      {Wait(100);} 
      while (InvCount(546) > 0) 
      { 
         Deposit(546,1); 
         Wait(200); 
       } 
       CloseBank(); 
 } 

    DisplayMessage("@red@STOPPED", 3); 
  } 
} 