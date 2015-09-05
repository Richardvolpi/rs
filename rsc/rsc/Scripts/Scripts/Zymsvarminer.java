public class Zymsvarminer extends Script 
{ 
   public Zymsvarminer(mudclient rs) 
   { 
       super(rs); 
   } 
   public String[] getCommands() 
   { 
       return new String[]{"iron"}; 
   } 
public int ironBank = 0; 
public int BankTrips = 0; 
public int LVL = 0; 

public void ServerMessage(String message) 
  { 
if(message.equals("@gre@You just advanced 1 mining level!")) 
      { 
          LVL++; 
      } 

if (message.equals("@gam@You just found a sapphire!")) 
     { 
        System.out.println("+++++++++++Sapphire mined+++++++++++"); 
     } 
     if (message.equals("@gam@You just found an emerald!")) 
     { 
        System.out.println("+++++++++++Emerald mined+++++++++++"); 
     } 
     if (message.equals("@gam@You just found a ruby!")) 
     { 
        System.out.println("+++++++++++ruby mined+++++++++++"); 
     } 
     if (message.equals("@gam@You just found a diamond!")) 
     { 
        System.out.println("+++++++++++diamond mined+++++++++++"); 
     } 
    

}  

public void start(String command, String parameter[]) 

   { 
     DisplayMessage("@cya@ coal@red@ miner@gre@ made by@ran@ zym",3); 
     while (Running()) 
     { 
        while (Running()  == true && InvCount() < 30) 
        { 
           if (Fatigue() >= 90 && Running() == true) 
           { 
              while (Sleeping() == false) 
              { 
                 Use(FindInv(1263)); 
              Wait(1000); 
              } 
              while (Sleeping() == true) 
              { 
                 Wait(200); 
              } 
           } 
           int ironcoords[] = GetNearestObject(102); 
           if (ironcoords[0] != 76 && ironcoords[1] != 543 && Running() == true) 
           AtObject(ironcoords[0],ironcoords[1]); 
           Wait(500); 
        } 
  Walk(69,537); 
Walk(73,530); 
Walk(80,523); 
Walk(84,516); 
Walk(91,509); 
Walk(102,509); 
Walk(103,509); 
if(DoorAt(103,510,0) == 2) 
{ 
              OpenDoor(103,510,0); 
              Wait(100); 
           } 

Walk(102,511); 
       OpenBank(); 
       while (InvCount(151) > 0) 
        { 
           Deposit(151,1); 
           Wait(50); 
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
        ironBank = BankCount(151); 
        CloseBank(); 
        
BankTrips++; 

Println("/./././././././.Trip " +BankTrips+"/./././././././"); 
Println("Coal Banked: " +ironBank); 
Println("Levels Gained: " +LVL); 


Walk(103,510); 
if(DoorAt(103,510,0) == 2) 
{ 
              OpenDoor(103,510,0); 
              Wait(100); 
           } 
Walk(89,509); 
Walk(79,518); 
Walk(75,532); 
Walk(74,541); 
Walk(75,544); 
     } 
     DisplayMessage("@red@STOPPED", 3); 
   } 
}