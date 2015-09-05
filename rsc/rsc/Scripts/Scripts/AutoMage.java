public class AutoMage extends Script
{
    public AutoMage(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"mageit"};
    }
    public void start(String command, String parameter[])
    {
      if (parameter.length != 2)
      {
         DisplayMessage("@gre@SBoT: @whi@Invalid number of parameters. /RUN mage [STYLE] [NPC TYPE]", 3);
      } else {
         int Spell = Integer.parseInt(parameter[0]);
         int FightTime = 750;
         int NPC = Integer.parseInt(parameter[1]);
         CheckFighters(true);
         DisplayMessage("@gre@SBoT: @whi@AutoMage - Jake", 3);
         while (Running() == true)
         {
               if (Fatigue() > 97 && Sleeping() == false)
               {
                  DisplayMessage("@gre@SBoT: @whi@Sleeping", 3);
                  Use(FindInv(1263));
                  Wait(5000);
               } else {
                  if (Sleeping() == false)
                  {
                     int ID = GetNearestNPC(NPC);
                     if (ID != -1)
                     {
                        long T = System.currentTimeMillis();
                        MagicNPC(ID,Spell);
                        Wait(700);
                     }
               }
         }
      }
}
      DisplayMessage("@gre@SBoT: @whi@AutoMage - @red@STOPPED", 3);
    }
} 