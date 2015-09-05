public class ChickenRanger extends Script
{
public ChickenRanger(mudclient rs)
   {
       super(rs);
   }
   public String[] getCommands()
   {
       return new String[]{"chicken"};
   }
   public void start(String command, String parameter[])
   {     
   int Start[] = new int[2];
   Start[0] = GetX();
   Start[1] = GetY();
   AutoLogin(true);
   while (Running())
   {
    while (!InCombat() && Running())
    {
     if (GetFightMode() != 1)
       SetFightMode(1);
       int[] ID = GetNearestNpc(3); 
         if(ID[0] != -1 && !InCombat() && !Sleeping() && Running()) 
            {
                AttackNpc(ID[0]);
                Wait(Rand(500,600));
            }
            else Wait(1);
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
            while(InCombat() && Running())
                Wait(10);
            while(Running() && GetDistance(Start[0],Start[1]) >= 10 && !InCombat())
            {
                Walk(Start[0],Start[1]);
                Wait(300);
            }
            }        
        }        
    }  
} 
   