public class WaterStriker extends Script
{
    public boolean WaterStriking = true;
    public int exp = 0;
    public WaterStriker(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"waterstrike"};
    }
    public void start(String command, String parameter[])
    {
      DisplayMessage("@ran@=@ran@=@ran@=@ran@=@ran@= @whi@Zombie Target Water Striker Activated! @ran@=@ran@=@ran@=@ran@=@ran@=",3);
      DisplayMessage("@ran@=@ran@=@ran@=@ran@=@ran@= @whi@Created by SaladFork! @ran@=@ran@=@ran@=@ran@=@ran@=",3);
      while (Running())
      {
         while (InvCount(35) >= 1 && InvCount(32) >= 1 && Running() == true)
         {
            if (Fatigue() >= 95 && Running() == true)
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
            if (Running())
            {
               MagicNPC(GetNearestNPC(516),2);
               Wait(2000);
            }
         }
         while (InvCount(35) >= 1 && InvCount(32) < 1 && Running() == true)
         {
            WaterStriking = false;
            if (Fatigue() >= 95 && Running() == true)
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
            if (Running())
            {
               MagicNPC(GetNearestNPC(516),0);
               Wait(2000);
            }
         }
      }
      DisplayMessage("@red@STOPPED", 3);
    }
}