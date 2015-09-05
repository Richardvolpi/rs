public class ArrowBuy0r extends Script
{
   public ArrowBuy0r(mudclient rs)
   {
       super(rs);
   }
   public String[] getCommands()
   {
       return new String[]{"buy0r"};
    }
     
      public void start(String command, String parameter[])
   {
      DisplayMessage("ArrowBuy0r", 3);

     while (Running())
     {  
     while (LoggedIn() == false);
     {Wait(1500);}  
     BuyArrows();
     SetWorld(81);
     Logout();
     while (LoggedIn() == false);
     {Wait(1500);}
     BuyArrows();
     SetWorld(83);
     Logout();
     while (LoggedIn() == false);
     {Wait(1500);}
     BuyArrows();
     SetWorld(85);
     Logout();
     while (LoggedIn() == false);
     {Wait(1500);}
     BuyArrows();
     }
   
       
  DisplayMessage("Arrow Buyer Stopped", 3);
   }
   
   public void BuyArrows()
   {
   while (QuestMenu() == false)
                 {
                   int lowe = GetNearestNPC(58);
                    TalkToNPC(lowe);
                    Wait(1000);
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
      while(ShopCount(11) > 0 && Shop() == true)
                      {
     Buy(11);
     Wait(1);
       }
      if(ShopCount(11) == 0 && Shop() == true);
{
CloseShop();
}
   }
   
   }
   }