public class Pker extends Script 
{ 
   public Pker(mudclient rs) 
   { 
      super(rs); 
   } 
   public String[] getCommands() 
   { 
      return new String[]{"pk"}; 
   } 
   public void start(String command, String parameter[]) 
   { 
      DisplayMessage("Pking started-@dre@ 0wnD by TRIGUN",3); 
      while (Running()) 
      { 
          while (Running() == true && InCombat() == false) 
          {    
              if (Running() == true && InCombat() == false) 
              { 
                  SetFightMode(1); 
                  PrayerOff(8); 
                  PrayerOff(10); 
              } 
              while (GetStat(3) - GetCurrentStat(3) > 5 && InvCount(373) > 0) 
              { 
                 Use(FindInv(373)); 
                 Wait(850); 
              } 
              if (InvCount(373) > 2) 
              { 
                  Wait(50); 
              } else { 
                  DisplayMessage("@gre@Running Out Of Lobs!!!",3); 
                  Wait(1000); 
                     } 
              Wait(3000); 
          } 
          while (Running() == true && InCombat() == true) 
          { 
              if (Running() == true && InCombat() == true) 
              { 
                  SetFightMode(1); 
                  PrayerOn(8); 
                  PrayerOn(10); 
                  Wait(1000); 
              } 
          }              
      } 
      DisplayMessage("@red@Pker- @dre@Stopped", 3); 
   } 
} 