public class FeatherBuyer extends Script 
{ 
    public FeatherBuyer(mudclient rs) 
    { 
        super(rs); 
    } 
    public String[] getCommands() 
    { 
        return new String[]{"buyfeathers"}; 
     } 
      
       public void start(String command, String parameter[]) 
    { 
       DisplayMessage("@red@Feather Buyer", 3); 

      while (Running()) 
            {    
SetWorld(51); 
      Logout(); 
   Wait(1000); 
while (!LoggedIn()) 
   Wait(1); 
       BuyFeathers(); 
SetWorld(53); 
      Logout(); 
   Wait(1000); 
while (!LoggedIn()) 
   Wait(1); 
       BuyFeathers(); 
SetWorld(55); 
      Logout(); 
   Wait(1000); 
while (!LoggedIn()) 
   Wait(1); 
       BuyFeathers(); 
        } 
    
        
   DisplayMessage("@red@Feather Buyer STOPPED", 3); 
    } 
    
    public void BuyFeathers() 
    { 
    while (QuestMenu() == false) 
                  { 
                    int Gerrant = GetNearestNPC(167); 
                     TalkToNPC(Gerrant); 
                     Wait(1500); 
                  } 
                  long T = System.currentTimeMillis(); 
      while (System.currentTimeMillis() - T <= 6000 && QuestMenu() == false) 
               Wait(1); 
      while (QuestMenu() == true) 
                  { 
                  Answer(0); 
                  } 
                 T = System.currentTimeMillis(); 
                 while (System.currentTimeMillis() - T <= 6000 && Shop() == false) 
               {Wait(1);} 
      while (Shop() == true ) 
      { 
       while(ShopCount(381) > 0 && Shop() == true) 
                       { 
      Buy(381); 
      Wait(50); 
        } 
      while(ShopCount(381) > 0 && Shop() == true) 
                       { 
      Buy(381); 
      Wait(50); 
        } 
   CloseShop();    
    } 
    
    } 
    }