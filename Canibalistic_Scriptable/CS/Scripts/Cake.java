public class Cake extends Script
{
public Cake(mudclient rs)
   {
       super(rs);
   }
   public String[] getCommands()
   {
       return new String[]{"cake"};
   }
   public void start(String command, String parameter[])
   {     
   AutoLogin(true);
   while(Running())
   {
   if (GetLastQuestMessage().equalsIgnoreCase("Hey thats mine"))
   {  
   Display("You were caught, waiting for the baker to go away!",3); 
   Wait(10000);
   ResetMessages();
   }
   if (GetLastServerMessage().equalsIgnoreCase("@cya@You have been standing here for 5 minutes!Please move to a new area!"))
   {
   Walk(GetX(), GetY() + 1);
   Wait(100);
   ResetMessages();
   }
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
}