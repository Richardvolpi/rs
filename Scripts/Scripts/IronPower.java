public class IronPower extends Script
{
    public IronPower(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"poweriron"};
    }
    public void start(String command, String parameter[])
   //You dont need to change the line above.
    {         int MineID = Integer.parseInt(parameter[0]);
      DisplayMessage("@ran@=@ran@=@ran@=@ran@=@ran@= @whi@Iron PowerMiner Activated! @ran@=@ran@=@ran@=@ran@=@ran@=",3);
      DisplayMessage("@ran@=@ran@=@ran@=@ran@=@ran@= @whi@Created by SaladFork! Edited by Veggy! @ran@=@ran@=@ran@=@ran@=@ran@=",3);
      while (Running())
      {
         while (Running()  == true)
         {
            if (Fatigue() >= 95 && Running() == true)
            {
               while (Sleeping() == false)
               {
                  Use(FindInv(1263));
               Wait(2500);
               }
               while (Sleeping() == true)
               {
                  Wait(100);
               }
            }                        long T = System.currentTimeMillis();
            int RockCoords[] = GetNearestObject(MineID);
            if (Running() == true)
               AtObject(RockCoords[0],RockCoords[1]);

                        while (System.currentTimeMillis() - T <= 3500 && Running() == true)
                           Wait(1);
         }
}

      DisplayMessage("@red@STOPPED", 3);
    }
}