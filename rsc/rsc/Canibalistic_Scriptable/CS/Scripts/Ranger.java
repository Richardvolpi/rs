import java.util.Random;
public class Ranger extends Script
{
private Random r = new Random();
public int Rand(int base, int range) {
        return base + r.nextInt(range);
    }
    
 public Ranger(mudclient rs)
   {
       super(rs);
   }
   public String[] getCommands()
   {
       return new String[]{"range"};
   }
   public void start(String command, String parameter[])
   {     
   int npcs[] = {99,74,62,19,34,29};
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
       int[] ID = GetNearestNpc(npcs); 
         if(ID[0] != -1 && !InCombat() && !Sleeping() && Running() &&ID[1] <= 583 && ID[1] >= 578 && ID[2] <= 3461) // && ID[1] >= 578 && ID[2] <= 3461
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
            while(Running() && GetDistance(Start[0],Start[1]) >= 1 && !InCombat())
            {
                Walk(Start[0],Start[1]);
                Wait(300);
            }
            }        
        }        
    }  
} 