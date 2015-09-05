public class druid extends Script
{
    public druid(mudclient rs)
    {
       super(rs);
    }
   public String[] getCommands()
    {
       return new String[]{"druid"};
    }
   public void start(String command, String parameter[])
    {     
    AutoLogin(true);
    long Time = GetMillies();
    int npc = StringToInteger(parameter[0]); 
    long Strength = GetStatXp(2);         
    while (Running())
   {
    while (!InCombat() && Running())
    {       
     if(GetCurrentStat(3) < 30 && !InCombat() && Running())
       {
       UseItem(FindSlot(546));
       Wait(1000);
       }      
     if(GetY() > 484)
     { 
     if(GetWallObjectAt(378,493) == 2 && GetY() > 491 && GetX() > 373)
        {
        AtWallObject(378,493);
        Wait(1000);
        }
     if(GetWallObjectAt(377,488) == 2 && GetY() > 485 && GetY() < 490 && GetX() > 373)
        {
        AtWallObject(377,488);
        Wait(1000);
        }
     if(GetWallObjectAt(371,495) == 2 && GetY() > 492 && GetY() < 499 && GetX() < 372)
        {
        AtWallObject(371,495);
        Wait(1000);
        }      
     if(GetWallObjectAt(361,499) == 2 && GetX() < 363 && GetY() > 497)
        {
        AtWallObject(361,499);
        Wait(1000);
        } 
     }  
     if (GetFightMode() != 1)
       SetFightMode(1);
       int[] ID = GetNearestNpc(npc); 
       if(ID[0] != -1)
       {
                AttackNpc(ID[0]);
                Wait(Rand(300,500));
       }        
       else Wait(1);       
       if(Fatigue() > 95 && Running()) 
            { 
                while(!Sleeping() && Running()) 
                {
                    if(CountInv(1263) == 0)
                    {
                        Display("No sleeping bag, script stopped",3);
                        Stop();
                    }
                    UseItem(FindSlot(1263)); 
                    PrintLine("You have gained: " + (GetStatXp(2) - Strength) + " xp"); 
                    Wait(3000); 
                } 
                while(Sleeping() && Running()) 
                    Wait(100); 
            }       
       while(InCombat() && Running()) 
            Wait(1);             
              
        }        
        }        
        Stop();
    }   
    

}