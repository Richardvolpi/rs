public class Thiever extends Script
{
public void GetCakes()
{
while(GetX() != 544 && GetY() != 601){
Walk(544,601);
Wait(400);
}
while(CountInv() < 30 && Running())
{
if (GetFightMode() != 1)
       SetFightMode(1);
   if(!InCombat() & Fatigue() <= 90 & Running())
            {
                int[] Stall = GetNearestObject(322);
                if(Stall[0] != -1)
                {
                AtObject2(Stall[1],Stall[2]);
                Wait(100);
                }
                else Wait(10);                    
            }
            while(InCombat() && Running())
            {
                Walk(GetX(),GetY());
                Wait(500);
            }            
            if(Fatigue() > 90 && Running()) 
            { 
                while(!Sleeping() && Running()) 
                {
                    if(CountInv(1263) == 0)
                    {
                        Display("Script stopped, no sleeping bag",3);
                        AutoLogin(false);
                        Logout();
                    }
                    UseItem(FindSlot(1263)); 
                    Wait(3000); 
                } 
                while(Sleeping() && Running()) 
                    Wait(100); 
            }
      }
}
public Thiever(mudclient rs)
   {
       super(rs);
   }
   public String[] getCommands()
   {
       return new String[]{"thieve"};
   }
   public void start(String command, String parameter[])
   {     
   int Start[] = new int[2];
   Start[0] = GetX();
   Start[1] = GetY();
   int NPC = StringToInteger(parameter[0]);
   int Mode = StringToInteger(parameter[1]);
   int WalkLimit = StringToInteger(parameter[2]);
   AutoLogin(true);
   Display("@red@CS: @yel@Fighter Started!",3);
   Display("@red@Attacking ID: @yel@" + NPC,3);
   Display("@red@Using fightmode: @yel@" + Mode,3);
   Display("@red@Walking Back if walked more then @yel@" + WalkLimit + " @red@ squares away",3); 
   while (Running())
   {
    while (!InCombat() && Running())
    {  
    if((GetStat(3) - GetCurrentStat(3)) > 4 && Running())
            {
                if(CountInv(335) > 0)
                {
                UseItem(FindSlot(335));
                Wait(500);
                }
                else if(CountInv(333) > 0)
                {
                UseItem(FindSlot(333));
                Wait(500);
                }
                else if(CountInv(330) > 0)
                {
                UseItem(FindSlot(330));
                Wait(500); 
                }   
                else
                GetCakes();
    }            
    
    if(Fatigue() > 95 && Running()) 
     { 
                while(!Sleeping() && Running()) 
                {
                    if(CountInv(1263) == 0)
                    {
                        Display("No sleeping bag, script stopped",3);
                        AutoLogin(false);
                        Logout();
                    }
                    UseItem(FindSlot(1263)); 
                    Wait(3000); 
                } 
                while(Sleeping() && Running()) 
                    Wait(100); 
     }    
     if (GetFightMode() != Mode)
       SetFightMode(Mode);
       int[] ID = GetNearestNpc(NPC); 
         if(ID[0] != -1 && !InCombat() && !Sleeping() && Running()) 
            {
                TheiveNpc(ID[0]);
                Wait(500);              
            }
            else if(GetX() != Start[0] && GetY() != Start[1])
            {
            Walk(Start[0],Start[1]);
            Wait(400);
            }
            else
            Wait(1);            
            while(InCombat() && Running())
            {            
               Walk(GetX(),GetY());
               Wait(500);
            }
            while(Running() && GetDistance(Start[0],Start[1]) >= WalkLimit && !InCombat())
            {
                Walk(Start[0],Start[1]);
                Wait(300);
            }    
          }        
        } 
        Display("@red@CS: @yel@Theiver Stopped!",3);       
    }  
} 
            