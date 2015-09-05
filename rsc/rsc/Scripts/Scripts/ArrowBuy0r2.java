public class ArrowBuy0r2 extends Script
{
   public ArrowBuy0r2(mudclient rs)
   {
       super(rs);
   }
   public String[] getCommands()
   {
       return new String[]{"buy0r2"};
    }
     
      public void start(String command, String parameter[])
   {
      DisplayMessage("ArrowBuy0r - pun@ran@K@whi@rocke@ran@R", 3);

     while (Running())
     {  
     while (LoggedIn() == false);
     {Wait(1500);}  
     BuyArrows();
     }
   }
   
   public void BuyArrows()
   {
   while (QuestMenu() == false) {
   int lowe = GetNearestNPC(58);
     TalkToNPC(lowe);
       Wait(1000);
         }
                 long T = System.currentTimeMillis();
     while (System.currentTimeMillis() - T <= 6000 && QuestMenu() == false)
              Wait(1);
     while (QuestMenu() == true) {
                 Answer(0);
                 }
                T = System.currentTimeMillis();
                while (System.currentTimeMillis() - T <= 6000 && Shop() == false)
              {Wait(1);}
     while (Shop() == true )
     {
      while(ShopCount(11) > 0 && Shop() == true) {
     Buy(11);
     Wait(125);
       }
   }
   
   }
   }