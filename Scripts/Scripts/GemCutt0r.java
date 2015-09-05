public class GemCutt0r extends Script
{
   public GemCutt0r(mudclient rs)
   {
       super(rs);
   }
   public String[] getCommands()
   {
       return new String[]{"cutt0r"};
   }
   public void start(String command)
   {  
        DisplayMessage("@gre@SBoT: @whi@GemCutt0r - pun@ran@K@whi@rocke@ran@R", 3);
        while (Running())
        {
              if (Fatigue() > 97 && !Sleeping())
              {
                 System.out.println("Sleeping");
                 Use(FindInv(1263));
                 Wait(1000);
              } else {
              if (!Sleeping())
              {
              while(FindInv(167) > 0) {
       while(Running() == true && FindInv(157) > 0)
       {  
       UseWithInventory(FindInv(167), FindInv(157));
       Wait(1000);
       }
       while(Running() == true && FindInv(158) > 0)
       {  
       UseWithInventory(FindInv(167), FindInv(158));
       Wait(1000);
       }  
       while(Running() == true && FindInv(159) > 0)
       {  
       UseWithInventory(FindInv(167), FindInv(159));
       Wait(1000);
       }
       while(Running() == true && FindInv(160) > 0)
       {  
       UseWithInventory(FindInv(167), FindInv(160));
       Wait(1000);
       }                                    
         }      
              }
             }
     }
     DisplayMessage("@gre@SBoT: @whi@GemCutt0r - @red@STOPPED @whi@(pun@ran@K@whi@rocke@ran@R@whi@)", 3);
   }
} 