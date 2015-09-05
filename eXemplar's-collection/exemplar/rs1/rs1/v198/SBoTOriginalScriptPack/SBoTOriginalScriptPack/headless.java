public class headless extends Script
{
   public headless(mudclient rs)
   {
      super(rs);
   }
   public String[] getCommands()
   {
      return new String[]{"heada"};
   }
   public void start(String command, String parameter[])
   {
      DisplayMessage("headless arrows by pure ownage",3);
         while (Running())
   {

        if (Fatigue() < 97)
   {
   UseWithInventory(2,1);
   Wait(500);
   }

   if (Fatigue() > 97 && Sleeping() == false)
               {
                  DisplayMessage("@blu@SBoT: @red@Sleeping", 3);
                  Use(FindInv(1263));
                  Wait(9000);
          }
   }
      DisplayMessage("@red@STOPPED", 3);
   }
}