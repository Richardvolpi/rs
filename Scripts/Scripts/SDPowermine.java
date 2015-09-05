public class SDPowermine extends Script
{
    public int mininglvls = 0, miningxp = 0, totalores = 0;
    public SDPowermine(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"SDPCopper", "SDPTin", "SDPIron", "SDPCoal", "SDPMithril"};
    }
    public void ServerMessage(String message)
   {
      if (message.equals("@gam@You manage to obtain some copper ore"))
      {   
        miningxp+=17.5;
    totalores+=1;
      }
      if (message.equals("@gam@You manage to obtain some tin"))
      {   
        miningxp+=17.5;
    totalores+=1;
      }
      if (message.equals("@gam@You manage to obtain some iron ore"))
      {   
        miningxp+=35;
    totalores+=1;
      }
      if (message.equals("@gam@You manage to obtain some coal"))
      {   
        miningxp+=50;
    totalores+=1;
      }
      if (message.equals("@gam@You manage to obtain some mithril ore"))
      {   
        miningxp+=80;
    totalores+=1;
      }else
      if (message.equals("@gre@You just advanced 1 mining level!"))
      {
         Wait(1000);
         System.out.println("You got a mining level! You are now at level " + GetStat(14));
         mininglvls+=1;
      }
   }
   public void start(String command, String parameter[])
    {
   
      DisplayMessage("@ran@S@ran@D@ran@P: @whi@Started",3);
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println("N    N  OOOOOO  FFFFFF   X    X");
      System.out.println("NN   N  O    O  F         X  X");
      System.out.println("N N  N  O    O  FFFF       XX");
      System.out.println("N  N N  O    O  F          XX");
      System.out.println("N   NN  O    O  F         X  X");
      System.out.println("N    N  OOOOOO  F        X    X");
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println("-----SDP has been started-----");
      System.out.println("Current mining level is: " + GetStat(14));
      System.out.println("===============================");
     
      while (Running())
   {
           while (Fatigue() >= 95 && Running() == true && Sleeping() == false)
            { 
               Use(FindInv(1263));
               Wait(3000);
            }
    if (Sleeping() == false) {
    if (command.equalsIgnoreCase("SDPtin")) {
         int RockCoords[] = GetNearestObject(104);
            AtObject(RockCoords[0],RockCoords[1]);
            Wait(1500);
        }

    if (command.equalsIgnoreCase("SDPcopper")) {
         int RockCoords[] = GetNearestObject(101);
            AtObject(RockCoords[0],RockCoords[1]);
            Wait(1500);
        }

    if (command.equalsIgnoreCase("SDPiron")) {
         int RockCoords[] = GetNearestObject(102);
            AtObject(RockCoords[0],RockCoords[1]);
            Wait(1500);
        }

    if (command.equalsIgnoreCase("SDPcoal")) {
         int RockCoords[] = GetNearestObject(110);
            AtObject(RockCoords[0],RockCoords[1]);
            Wait(1500);
        }

    if (command.equalsIgnoreCase("SDPmithril")) {
         int RockCoords[] = GetNearestObject(107);
            AtObject(RockCoords[0],RockCoords[1]);
            Wait(1500);
        }

}   
}
      DisplayMessage("@ran@S@ran@D@ran@P@ran@: @red@Stopped", 3);
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println("     SDP is Finished it's magic     ");
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println("Mining levels advanced: " + mininglvls);
      System.out.println("Mining XP Received: " + miningxp);
      System.out.println("Total ores obtained: " + totalores);
     
    }
  } 