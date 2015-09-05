public class Kg extends Script 
{ 
   public Kg(mudclient rs) 
   { 
      super(rs); 
   } 
   public String[] getCommands() 
   { 
      return new String[]{"kg"}; 
   } 
   public void start(String command, String parameter[]) 
   { 
      DisplayMessage("@or2@Sbot:@whi@|Khazard|@dre@fighta|@red@By@or3@Mp|", 3); 
      while (Running()) 
      { 
         if (GetFightMode() != 1) 
         { 
            SetFightMode(1); 
         } 
         if (Fatigue() >= 97) { 
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
         if (GetCurrentStat(3) < 60) 
         { 
            if (InvCount(373) == 0) 
            { 
               Say("@yel@Brb guys im outta food"); 
               Walk(634,642);  
               Walk(614,633);
               Walk(607,643);
               Walk(592,630);
               Walk(582,626);
               Walk(577,624);
               Walk(561,619); 
               Walk(551,612); 
               while (QuestMenu() == false) 
               { 
                  int banker = GetNearestNPC(95); 
                  TalkToNPC(banker); 
                  Wait(2000); 
               } 
               Answer(0); 
               while (Bank() == false) 
               { 
                  Wait(1000); 
               } 
               while (InvCount() < 30) 
               { 
                  Withdraw(373,1); 
                  Wait(1000); 
               } 
               CloseBank(); 
               Say("@yel@Yet another 25 lobs i wasted.."); 
               Walk(561,619); 
               Walk(577,624); 
               Walk(582,626);
	       Walk(592,630);
               Walk(607,643);
               Walk(614,633);
               Walk(634,642); 
               Walk(650,639);
            } 
            while (GetCurrentStat(3) < 60) 
            { 
               Use(FindInv(373)); 
               Wait(2500); 
            } 
         } 
         if (InCombat() == false) 
         { 
            int warrior = GetNearestNPC(407); 
            AttackNPC(warrior); 
            Wait(600); 
         } 
         if (InCombat() == true) 
         { 
            Wait(10); 
         } 
         if (GetFightMode() != 1) 
         { 
            SetFightMode(1); 
         } 
      } 
      Say("@ran@im leaving cya guys"); 
   } 
} 