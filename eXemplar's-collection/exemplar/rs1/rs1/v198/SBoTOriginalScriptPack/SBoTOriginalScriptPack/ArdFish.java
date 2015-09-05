public class ArdFish extends Script
{
   public ArdFish(mudclient rs)
   {
      super(rs);
   }
   public String[] getCommands()
   {
      return new String[]{"ardfish"};
   }
   public void start(String command, String parameter[])
   {
      DisplayMessage("@ran@A@ran@drougne @ran@F@ran@isher by @ran@J@ran@eeb", 3);
      while (Running())
      {
            if (Fatigue() >= 90 && Running() == true)
            {
               while (Sleeping() == false && Running() == true)
               {
                  Use(FindInv(1263));
                  Wait(2500);
               }
               while (Sleeping() == true && Running() == true)
               {
                  Wait(100);
               }
            }
           while(Running())
           {
           AtObject(616,543);
           Wait(1250);
           }

      }
      DisplayMessage("@red@STOPPED", 3);
   }
} 