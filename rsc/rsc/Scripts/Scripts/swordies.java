public class swordies extends Script 
{ 
    public swordies(mudclient rs) 
    { 
        super(rs); 

    } 
    public String[] getCommands() 
    { 
        return new String[]{"swordie"}; 

    } 
    public long StartTime = System.currentTimeMillis(); 
    public int Trips = 0; 
    public int TunaCount = 0; 
    public int SwordfishCount = 0; 
    public int SleepCount = 0;  
    public int LVL = 0; 
    public int EXP = 0; 
    public int BankDoor = 0; 
    public int AnvilDoor = 0; 
    public boolean Sleep = false; 
    public void ServerMessage(String message) 
    { 
         if(message.indexOf("You are too tired") > 0) 
            Sleep = true; 
         if (message.startsWith("@gam@You catch a tuna")) 
    { 
       TunaCount++; 
            EXP += 80; 
    } 
         if (message.startsWith("@gam@You catch a swordfish")) 
    { 
       SwordfishCount++; 
            EXP += 100; 
    } 
         if(message.equals("@gre@You just advanced 1 fishing level!")) 
         { 
             LVL++; 
         } 
    } 
    public void KeyPressed(int id) 
    { 
       if (id == 1012) 
       { 
         long TotalTime = System.currentTimeMillis() - StartTime; 
         long MinsWorked = TotalTime / 60000L; 
         for(int i=0;i<25;i++) 
           System.out.println(); 
         DisplayMessage("@gre@Working for "+ MinsWorked + " minutes",3); 
         DisplayMessage("@gre@Gained "+EXP +" fishing experience",3); 
         Println("------------------------"); 
         Println("Status Report: Catherby Swordfisher"); 
         Println("------------------------"); 
         Println("Working for "+ MinsWorked + " minutes"); 
         Println("Fished a total of "+ TunaCount + " tuna"); 
         Println("Fished a total of "+ SwordfishCount + " swordfish"); 
         Println("Gained "+ EXP +" fishing experience"); 
         Println("Slept "+ SleepCount +" times"); 
         Println("Opened Bank Door "+ BankDoor +" times"); 
         id = 0; 
       } 
    } 
    public void start(String command, String parameter[]) 
    { 
    DisplayMessage("@gre@Jake: @whi@Catherby Swordfisher", 3); 
    while (Running()) 
    { 
    Trips++; 
       while (Running() && InvCount() < 30) 
       { 
            if(Sleep && Running()) 
            { 
                while (!Sleeping()) 
                { 
                    Use(FindInv(1263)); 
                    Wait(3000); 
                } 
                while (Sleeping()) 
                { 
                    Wait(200); 
                } 
          SleepCount++; 
          Sleep = false; 
            } 
       while(InvCount(366) > 0) 
       {    
         Drop(FindInv(366)); 
         Wait(1000); 
       } 
       AtObject(409,504); 
       Wait(500); 
         } 
    if(Running()) 
    { 
    Walk(409,503); 
    Walk(418,498); 
    Walk(440,497); 
    while(ObjectAt(439,497) == 64) 
      { 
      AtObject(439,497); 
      Wait(1000); 
      BankDoor++; 
         } 
    Walk(440,495); 
    while (!QuestMenu() && Running()) 
        { 
            int BankerID = GetNearestNPC(95); 
            TalkToNPC(BankerID); 
            Wait(2000); 
        } 
        Answer(0); 
        while (!Bank() && Running()) 
        { 
            Wait(50); 
        } 
        while (Bank() && Running()) 
        { 
            while(InvCount(369) > 0) 
            { 
                Deposit(369,1); 
                Wait(50); 
            } 
      CloseBank(); 
        } 
        Walk(440,496); 
   while(ObjectAt(439,497) == 64) 
   { 
     AtObject(439,497); 
     Wait(1000); 
     BankDoor++; 
        } 
   Walk(418,498); 
      } 
     } 
     DisplayMessage("@gre@Jake: @red@Stopped Catherby Swordfisher", 3); 
         long TotalTime = System.currentTimeMillis() - StartTime; 
         long MinsWorked = TotalTime / 60000L; 
         for(int i=0;i<25;i++) 
           System.out.println(); 
         DisplayMessage("@gre@Working for "+ MinsWorked + " minutes",3); 
         DisplayMessage("@gre@Gained "+EXP +" fishing experience",3); 
         Println("------------------------"); 
         Println("Status Report: Catherby Swordfisher"); 
         Println("------------------------"); 
         Println("Working for "+ MinsWorked + " minutes"); 
         Println("Fished a total of "+ TunaCount + " tuna"); 
         Println("Fished a total of "+ SwordfishCount + " swordfish"); 
         Println("Gained "+ EXP +" fishing experience"); 
         Println("Slept "+ SleepCount +" times"); 
         Println("Opened Bank Door "+ BankDoor +" times"); 
   } 
} 