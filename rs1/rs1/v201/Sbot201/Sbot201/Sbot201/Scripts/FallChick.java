public class FallChick extends Script 
{ 
   public FallChick(mudclient rs) 
   { 
      super(rs); 
   } 
   public String[] getCommands() 
   { 
      return new String[]{"startnow"}; 
   } 
   public void start(String command, String parameter[]) 
   { 
      int FightMode = Integer.parseInt(parameter[0]); 
      
      String FightName = ""; 

        switch(FightMode) 
        { 
            case 1: 
            FightName = "STRENGHT"; 
            break; 

            case 2: 
            FightName = "ATTACK"; 
            break; 

            case 3: 
            FightName = "DEFENCE"; 
            break; 
        } 
        
      DisplayMessage("",3); 

     while (Running()) 
      { 
         if(GetFightMode() != FightMode) 
            { 
                SetFightMode(FightMode); 
                DisplayMessage("@GRE@INFO: @WHI@Fightmode has been set to: @LRE@"+FightName,3); 
            } 
          
         if (InCombat() == false) 
         { 
          while (GetX() >= 274 || GetX() <= 270) 
            { 
               DisplayMessage("@red@Back To chicken field", 3); 
               while (ObjectAt(274,603) == 60 && Running() == true); 
               { 
                  AtObject(274,603); 
                  Wait(1000); 
               } 
               Walk(272,603); 
            } 
             
if (GetNearestNPC(3) == -1) { 
Wait(25); 
int Feather[] = GetNearestItem(381); 
if (Feather[0] < 274 && Feather[1] < 608 && Feather[0] > 268 && Feather[1] > 599) { TakeItem(Feather[0],Feather[1],381); } 
Wait(25); }

            if (Fatigue() > 97 && Sleeping() == false) 
               { 
                  DisplayMessage("@gre@SBoT: @whi@Sleeping", 3); 
                  Use(FindInv(1263)); 
                  Wait(1000); 
               } 
               
           if (Sleeping() == false && Running() == true) 
              { 

                  int ChickenID = GetNearestNPC(3); 

                       if(ChickenID != -1) 
                       { 
                           AttackNPC(ChickenID); 
                           Wait(100); 
                       } 
              } 
         } 

      
         { 
          while(InCombat() == true && Running() == true) 
                { 
                    Wait(1); 
                } 
         } 
      } 
      DisplayMessage("@red@terminada", 3); 
   } 
} 
