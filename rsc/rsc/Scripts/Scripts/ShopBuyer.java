public class ShopBuyer extends Script
{
  public ShopBuyer(mudclient rs)
  {
    super(rs);
  }
 
  public String[] getCommands()
  {
    return new String[]{"mbuy","fbuy","bbuy"};
  }

  public void start(String s, String parameter[])
  {
    if(parameter.length != 1)
      DisplayMessage("@gre@SBoT: @whi@Invalid number of parameters.", 3);
    else
    {
      int soff = 2;
      int x = 51;
      if(s.equalsIgnoreCase("mbuy")) x = 52;
      else if(s.equalsIgnoreCase("bbuy")) soff = 1;
      int y = x;
      int ID = Integer.parseInt(parameter[0]);
      int[] items = {33,34};
      /* Item ID's, add to/remove from the items array as appropriate, to select what you wish to buy.
      11:Bronze Arrows
      190:Crossbow bolts
      31:Fire-Rune
      32:Water-Rune
      33:Air-Rune
      34:Earth-Rune
      35:Mind-Rune
      36:Body-Rune
      */
      DisplayMessage("@gre@SBoT: @whi@Reines ShopBuyer - @red@STARTED", 3);
      Wait(1000);
      DisplayMessage("@cya@Reines: tells you Hey " + System.getProperty("user.name") + ", don't forget to turn AutoLogin on",6);
      Wait(2000);
      while(Running())
      {
        while(!QuestMenu())
        {
          TalkToNPC(GetNearestNPC(ID));
          Wait(2000);
        }
        long Time = System.currentTimeMillis();
        while(!QuestMenu() && System.currentTimeMillis() - Time <= 10000) Wait(500);
        Answer(0);
        Time = System.currentTimeMillis();
        while(System.currentTimeMillis() - Time <= 10000 && !Shop()) Wait(500);
        if(Shop())
        {
          for(int a = 0;a < items.length;a++)
            while(ShopCount(items[a]) > 0 && Shop() && InvCount(10) > 10)
            {
              Buy(items[a]);
              Wait(100 + Rand(50,200));
            }
          CloseShop();
          Wait(2000);
        }
        if(InvCount(10) <= 10) Quit();
        if(x + soff < 57) x += soff;
        else x = y;
        SetWorld(x);
        Wait(500);
        Logout();
        while(!LoggedIn()) Wait(2000);
      }
      DisplayMessage("@gre@SBoT: @whi@Shop Buyer - @red@STOPPED", 3);
    }
  }
}