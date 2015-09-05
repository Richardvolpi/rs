public class CakeThiever2 extends Script 
{ 
    public CakeThiever2(mudclient rs) 
    { 
        super(rs); 
    } 
    public String[] getCommands() 
    { 
        return new String[]{"cs"}; 
    } 
    public void start(String command, String parameter[]) 
    { 
      if (parameter.length != 1) 
      { 
         DisplayMessage("@ora@Sbot: Wrong!!!.  @red@It is /RUN CAKESTEALER [MODE]", 3); 
      } else { 
         int FightMode = Integer.parseInt(parameter[0]); 
         int FightTime = 750; 
         CheckFighters(true); 
         DisplayMessage("@ran@CakeStealer is on", 3); 
         DisplayMessage("@red@Edit By Jia", 3); 
         while (Running() == true && GetCurrentStat(3) > 5) 
         {      
            if (GetFightMode() != FightMode) 
            { 
               SetFightMode(FightMode); 
               DisplayMessage("@blu@Fighting-Mode Changed To " + GetFightMode(),  3); 
            } 
              
         while (Running() == true) 
      {        
         Walk(549,612,500); 
         Walk(546,605,500); 
         Walk(544,602,500); 
         Walk(543,600,100); 
         TakeItem(543,600,1); 
         Wait(2000); 
         while (InvCount() < 30 && Running() == true) 
         {      
            
            int CakeStallCoords[] = GetNearestObject(322); 
            if (CakeStallCoords[0] > -1 & Running() == true) 
               AtObject2(CakeStallCoords[0],CakeStallCoords[1]); 
            Wait(1000); 
         }    

         Walk(545,603,500); 
         Walk(546,607,500); 
         Walk(549,612,500); 
         Walk(551,612,500); 
          
         int BankerID = GetNearestNPC(95); 
         while (QuestMenu() == false) 
         {    
            TalkToNPC(BankerID); 
            Wait(1000); 
         } 
            Answer(0); 
         while (Bank() == false)          
             Wait(1);      
         while (InvCount(330) > 0 && Running() == true) 
         {    
             Deposit(330,1); 
             Wait(100); 
         }    
         CloseBank(); 
                
         }    
      }          
             }  
      DisplayMessage("@red@STOPPED!", 3); 
    } 
}