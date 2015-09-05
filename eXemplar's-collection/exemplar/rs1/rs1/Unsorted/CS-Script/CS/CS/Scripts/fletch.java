public class fletch extends Script
{
public fletch(mudclient rs)
   {
       super(rs);
   }
   public String[] getCommands()
   {
       return new String[]{"fletch"};
   }
   public void start(String command, String parameter[])
   {     
   AutoLogin(true);    
    while(Running())
    {     
      while(CountInv(14) > 0 && Running())
            {                
           	UseItemWithItem(FindSlot(13),FindSlot(14));
           	Wait(1000);
           	Answer(0);      
           	Wait(1000);
           	CheckSleep();               	
           }
       while(CountInv(14) == 0)
            {            	
            	while(!QuestMenu())
        	 { 
        	     int[] Npc = GetNearestNpc(95);
        	     if(Npc[0] != -1)
        	        TalkToNpc(Npc[0]);
        	        Wait(2000);
                 }
        	 Answer(0);
        	 while (!IsBankOpen()) 
         		Wait(1); 
        	 while (CountInv() < 30)
        	 { 
        	     WithdrawItem(14,1); 
        	     Wait(200); 
        	 }         	 
              }
      }
   }  
   public void CheckSleep()
   {
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
    } 
}