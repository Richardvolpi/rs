public class bloods extends Script 
{ 
    public bloods(mudclient rs) 
    { 
        super(rs) ; 
    } 
    public String[] getCommands() 
    { 
        return new String[]{"bloods"}; 
    } 
    public void start(String command, String parameter[]) 
    {      
      DisplayMessage("@gre@Kenni's,@red@Blood Rune Thiever With Autoeat :D :o",3); 
      while (Running() == true) 
      { 
   while(InvCount(330) > 0 || InvCount(333) > 0 || InvCount(335) > 0) 
   { 
      SetFightMode(1); 
      while(ObjectAt(614, 3401) == 337 && !InCombat()) 
      { 
         AtObject2(614,3401); 
         Wait(500); 
      } 
      while(ObjectAt(614, 3399) == 337 && !InCombat()) 
      { 
         AtObject2(614,3399); 
         Wait(500); 
      } 
      while(InCombat()) 
      { 
         Wait(500); 
      } 
      if (GetStat(3) - GetCurrentStat(3) >= 12) { 
         while(InvCount(335) > 0 && GetStat(3) - GetCurrentStat(3) >= 8) 
         { 
            Use(FindInv(335)); 
            Wait(500); 
            Println("Eating slice of cake.... HP now at: " + GetCurrentStat(3) + "."); 
            Println("You Have: " + InvCount(335) + " Cake Slices Left."); 
         } 
         while(InvCount(333) > 0 && GetStat(3) - GetCurrentStat(3) >= 8) 
         { 
            Use(FindInv(333)); 
            Wait(500); 
            Println("Eating Portion of cake... HP now at: " + GetCurrentStat(3) + "."); 
            Println("You Have: " + InvCount(333) + " Cake Portions Left."); 
         } 
         while(InvCount(330) > 0 && GetStat(3) - GetCurrentStat(3) >= 8) 
         { 
            Use(FindInv(330)); 
            Wait(500); 
            Println("Eating Cake... Hp now at: " + GetCurrentStat(3) + "."); 
            Println("You have: " + InvCount(330) + " Cakes Left."); 
         } 
         while(InvCount(335) == 0 && InvCount(333) == 0 && InvCount(330) == 0 && InvCount(373) > 0 && GetStat(3) - GetCurrentStat(3) >= 8) 
         { 
            Use(FindInv(373)); 
            Wait(500); 
            Println("Eating Lobster... HP now at: " + GetCurrentStat(3) + "."); 
            Println("You Have: " + InvCount(373) + " Lobsters Left."); 
         } 
      } 
       
      if (Fatigue() >= 90 && Running() == true) 
               { 
                     while (Sleeping() == false && Running() == true) 
                     { 
                        Use(FindInv(1263)); 
                        Wait(2500); 
            Println("Sleeping..."); 
                     } 
                     while (Sleeping() == true && Running() == true) 
                     { 
                         Wait(1000); 
                     } 
         Println("Sleeping Complete... Fighting Again.."); 
               } 
   } 
   Walk(616,3391); 
   while(GetY() >= 3000) 
   { 
      AtObject(618,3383); 
      Wait(500); 
   } 
   Walk(617,555); 
   while(GetY() <= 555) 
   { 
      OpenDoor(617, 556, 0); 
      Wait(1500); 
   } 
   Walk(613,561); 
   Walk(609,567); 
   Walk(610,572); 
   Walk(611,578); 
   Walk(611,584); 
   Walk(611,590); 
   Walk(607,595); 
   Walk(600,597); 
   Walk(594,603); 
   Walk(588,603); 
   Walk(583,604); 
   Walk(578,605); 
   Walk(572,605); 
   Walk(564,605); 
   Walk(559,606); 
   Walk(554,607); 
   Walk(549,606); 
   Walk(544,602);  
   while(InvCount() < 30) 
   { 
      AtObject2(544,599); 
      Wait(750); 
      if (Fatigue() >= 90 && Running() == true) 
               { 
                     while (Sleeping() == false && Running() == true) 
                     { 
                        Use(FindInv(1263)); 
                        Wait(3000); 
            Println("Sleeping..."); 
                     } 
                     while (Sleeping() == true && Running() == true) 
                     { 
                         Wait(750); 
                     } 
         Println("Sleeping Complete... Fighting Again.."); 
               } 
   } 
   Walk(551,604); 
   Walk(556,607); 
   Walk(559,606); 
   Walk(565,606); 
   Walk(573,605); 
   Walk(580,605); 
   Walk(586,604); 
   Walk(593,603); 
   Walk(596,602); 
   Walk(599,599); 
   Walk(603,595); 
   Walk(609,594); 
   Walk(611,587); 
   Walk(611,582); 
   Walk(611,573); 
   Walk(609,569); 
   Walk(612,562); 
   Walk(617,556); 
   while(GetY() >= 556) 
   { 
      CloseDoor(617, 556, 0); 
      Wait(2000); 
   } 
   Walk(618,552); 
   AtObject(618,551); 
   Walk(615,3394); 
    
      } 
      DisplayMessage("@gre@Kenni's,@red@Blood Rune Thiever With Autoeat :D Stopped.", 3); 
    } 
}