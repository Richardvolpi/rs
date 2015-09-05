public class Guard extends Script
{
    public Guard(mudclient rs)
    {
       super(rs);
    }
   public String[] getCommands()
    {
       return new String[]{"guard"};
    }
   public void start(String command, String parameter[])
    {    
    AutoLogin(true);
    int npc = StringToInteger(parameter[0]); 
    int mode =  StringToInteger(parameter[1]); 
    long StartXp = GetStatXp(2);
    while (Running())
   {
    while (!InCombat() && Running())
    {   
    if(GetCurrentStat(3) < 30 && !InCombat() && Running())
       {
       UseItem(FindSlot(546));
       Wait(1000);
       }     
    if (GetFightMode() != mode)
       SetFightMode(mode);
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
                    PrintLine("You have gained: " + (GetStatXp(2) - StartXp) + " xp"); 
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