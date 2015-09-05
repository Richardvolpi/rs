public class Buyer extends Script
{
   public Buyer(mudclient rs)
   {
      super(rs);
   }
   public String[] getCommands()
   {
      return new String[]{"buy"};
   }
   public void BuyAll()
   {
      while(!QuestMenu())
      {
         int Magicstoreowner = GetNearestNPC(514);
         TalkToNPC(Magicstoreowner);
         Wait(1000);
      }
      Answer(0);
      while(!Shop())
      {
         Wait(1);
      }
      while(ShopCount(31) > 0 && Shop())
      {
         Buy(31);
         Wait(100);
      }
      while(ShopCount(33) > 0 && Shop())
      {
         Buy(33);
         Wait(100);
      }
      while(ShopCount(35) > 0 && Shop())
      {
         Buy(35);
         Wait(100);
      }
  }
   public void start(String command, String parameter[])
   {
      DisplayMessage("@red@ RscJakes Auto-Rune-buyer.", 3);
      while (Running())
      {
      BuyAll();
      SetWorld(52);
      Logout();
      while (LoggedIn() == false);
      {Wait(1500);}
      BuyAll();
      SetWorld(54);
      Logout();
      while (LoggedIn() == false);
      {Wait(1500);}
      BuyAll();
      SetWorld(56);
      Logout();
      while (LoggedIn() == false);
      {Wait(1500);}
      BuyAll();
         
      }
   }
}