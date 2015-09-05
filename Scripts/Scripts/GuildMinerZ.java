public class GuildMinerZ extends Script 
{ 
   public GuildMinerZ(mudclient rs) 
   { 
      super(rs); 
   } 
   public String[] getCommands() 
   { 
      return new String[]{"guildminer"}; 
   } 
public void MineCoal() 
{ 
     while (Running() && InvCount() < 30) 
     { 
      if (Fatigue() >= 92 && Running()) 
      { 
      while(!Sleeping() && Running()) 
      { 
           Use(FindInv(1263)); 
           Wait(2000); 
      } 
       while(Sleeping() && Running()) 
      { 
           Wait(50); 
      } 
      } 
      int FindCoal[] = GetNearestObject(110); 
      AtObject(FindCoal[0],FindCoal[1]); 
      Wait(2000); 
     } 
} 
public void BankWalk() 
{ 
    while (Running()) 
    { 
        Walk(274,3397); 
   AtObject(274,3398); 
   Walk(274,563); 
   if (ObjectAt(274, 563) == 2) 
        { 
           OpenDoor(274, 563, 0); 
           Wait(300); 
        } 
   Walk(274,562); 
        Walk(287,571); 
   if (ObjectAt(287,571) == 64) 
   { 
       AtObject(287,571); 
       Wait(300); 
   } 
   Walk(286,571); 
    } 
} 
public void BankIt() 
{ 
     while (!Bank() && Running()) 
     { 
          while (!QuestMenu() && Running()) 
          { 
              int BankerID = GetNearestNPC(95); 
                TalkToNPC(BankerID); 
              long Time = System.currentTimeMillis(); 
              while (System.currentTimeMillis() - Time <= 2000 && !QuestMenu() && Running()) 
              Wait(1); 
          } 
          Answer(0); 
          long Time = System.currentTimeMillis(); 
          while (System.currentTimeMillis() - Time <= 5000 && !Bank() && Running()) 
          Wait(1); 
     } 
     while (InvCount(155) > 0) 
     { 
          Deposit(155,1); 
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
} 
public void GuildWalk() 
{ 
    while (Running()) 
    { 
   Walk(286,571); 
   if (ObjectAt(287,571) == 64) 
   { 
       AtObject(287,571); 
       Wait(300); 
   } 
   Walk(287,571); 
   Walk(274,562); 
   if (ObjectAt(274, 563) == 2) 
        { 
           OpenDoor(274, 563, 0); 
           Wait(300); 
        } 
   Walk(274,563); 
   AtObject(274,566); 
    } 
}    
   public void start(String command, String parameter[]) 
   { 
      DisplayMessage("@bla@Guildminer",3); 
      DisplayMessage("@gre@By: Davis Zanot",3);      
      while (Running()) 
      { 
        MineCoal(); 
        BankWalk(); 
        BankIt(); 
        GuildWalk(); 

      } 
      DisplayMessage("@red@STOPPED", 3); 
   } 
}