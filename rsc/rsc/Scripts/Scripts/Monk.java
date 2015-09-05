public class Monk extends Script 
{ 
public Monk(mudclient rs) 
{ 
super(rs); 

} 
 public String[] getCommands() 
{ 
 return new String[]{"fightmonk"}; 

} 
public void start(String command, String parameter[]) 

{ 

DisplayMessage("@gre@SBoT: @whi@Monkfighter by Pharry", 3); 


while (Running()) 
 if (InCombat() == false) 
 { 
  
 if (Fatigue() > 97 && Sleeping() == false) 
 { 
 DisplayMessage("@gre@SBoT: @whi@Sleeping", 3); 
 Use(FindInv(1263)); 
 Wait(5000); 
 } else { 

      while (DoorAt(260,1406,0) != 1 && GetX() > 258) 

      { 
         DisplayMessage("@gre@SBoT: @whi@Omg a noob tried to trap me, - counteraction", 3); 
         OpenDoor(260,1406,0); 
         Wait(1000); 
      } 
 while (DoorAt(259,1403,1) != 1 && GetX() > 259) 

      { 
         DisplayMessage("@gre@SBoT: @whi@Omg a noob tried to trap me, - counteraction", 3); 
         OpenDoor(259,1403,1); 
         Wait(1000); 
      } 
 while (DoorAt(253,1403,1) != 1 && GetY() < 1405 && GetX() < 259) 

      { 
         DisplayMessage("@gre@SBoT: @whi@Omg a noob tried to trap me, - counteraction", 3); 
         OpenDoor(253,1403,1); 
         Wait(1000); 
      } 
 while (DoorAt(251,1405,0) != 1 && GetY() < 1408 && GetX() < 253) 

      { 
         DisplayMessage("@gre@SBoT: @whi@Omg a noob tried to trap me, - counteraction", 3); 
         OpenDoor(251,1405,0); 
         Wait(1000); 
      } 
while (DoorAt(251,1408,0) != 1 && GetY() < 1408 && GetX() < 253) 

      { 
         DisplayMessage("@gre@SBoT: @whi@Omg a noob tried to trap me - counteraction", 3); 
         OpenDoor(251,1408,0); 
         Wait(1000); 
      } 
        }  
 if (Sleeping() == false) 
 { SetFightMode(1); 
 int MonkID = GetNearestNPC(93); 

 AttackNPC(MonkID); 
 Wait(1000); 
 } else { 
 Wait(1); 
        } 
 } 


{ 

} 
} 
{ 
DisplayMessage("@red@Stopped", 3); 
} 
}