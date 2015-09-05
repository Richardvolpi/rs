public class SimpleFight extends Script 
{ 
   public SimpleFight(mudclient rs) 
   { 
      super(rs); 
   } 
   public String[] getCommands() 
   { 
      return new String[]{"attack"}; 
   } 

   public int FightMode = -1; 
   public int MobID = -1; 
   public int StartX = GetX(); 
   public int StartY = GetY(); 

   public void start(String command, String parameter[]) 
   { 
      FightMode = Integer.parseInt(parameter[0]); 
      MobID = Integer.parseInt(parameter[1]); 
      StartX = GetX(); 
      StartY = GetY(); 
      CheckFighters(true); 
      DisplayMessage("@gr2@fAcelEss@whi@: Simple Fighter",3); 
      PrintInfo(); 
      while (Running()) 
      { 
         while (!InCombat()) 
         { 
            if (GetFightMode() != FightMode) 
            { 
               SetFightMode(FightMode); 
               DisplayMessage("@gr2@fAcelEss@whi@: Fightmode changed to "+FightMode,3); 
            } 
            if (!InCombat() && GetNearestNPC(MobID) == -1) 
               { 
                  Walk(StartX,StartY); 
                  Wait(50); 
               } 
            if (Fatigue() > 97 && !Sleeping()) 
            { 
               DisplayMessage("@gr2@fAcelEss@whi@: Sleeping...",3); 
               Use(FindInv(1263)); 
               Wait(5000); 
            } 
            if (!Sleeping()) 
            { 
               int FightTime = (Rand(750,1500)); 
               int Enemy = GetNearestNPC(MobID); 
               if (Enemy != -1) 
               { 
                  long T = System.currentTimeMillis(); 
                  AttackNPC(Enemy); 
                  while (System.currentTimeMillis() - T <= FightTime && !InCombat() && Running()) 
                     Wait(1); 
               } 
               else 
               { 
                  Wait(1); 
               } 
            } 
         } 
         while (InCombat()) 
         { 
            if (GetFightMode() != FightMode) 
            { 
               SetFightMode(FightMode); 
               DisplayMessage("@gr2@fAcelEss@whi@: Fightmode changed to "+FightMode,3); 
            } 
            Wait(250); 
         } 
      } 
      
      DisplayMessage("@gr2@fAcelEss@whi@: Simple Fighter @red@STOPPED", 3); 
   } 

   public void PrintInfo() 
   { 
      System.out.println("+----------------------------------------+"); 
      System.out.println("|  _                                     |"); 
      System.out.println("|_|_  __   __   ___  |    ___    __   __ |"); 
      System.out.println("| |  (__( (___ (__/_ |_, (__/_ __)  __)  |"); 
      System.out.println("|                                        |"); 
      System.out.println("|- - - -     P R E S E N T S     - - - - |"); 
      System.out.println("|                                        |"); 
      System.out.println("|-----------Simple.Fighter.v1------------|"); 
      System.out.println("|I N F O R M A T I O N :                 |"); 
      System.out.println("+----------------------------------------+"); 
      System.out.println(" Fightmode: " +FightMode); 
      System.out.println(" Fighting ID: "+MobID); 
      System.out.println(" Walkback X Co-ordinate: "+StartX); 
      System.out.println(" Walkback Y Co-ordinate: "+StartY); 
      System.out.println("+----------------------------------------+"); 
   } 

} 