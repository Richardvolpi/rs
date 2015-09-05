public class Mager extends Script
{
    public Mager(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"cast"};
    }
    public void start(String command, String parameter[])
    {    

       System.out.println();
        System.out.println("            Ultimate Magic Script by fAcelEss");                   

      System.out.println("*---------------------------------------------------------*");
        System.out.println("            Usage: /run cast [NPCID]@[SpellID]");
        System.out.println("Spell ID List:");
        System.out.println();
       System.out.println("--Strike Spells--");
        System.out.println("0: Wind Strike"); 
       System.out.println("2: Water Strike");
       System.out.println("4: Earth Strike");
       System.out.println("6: Fire Strike");
        System.out.println();
       System.out.println("--Bolt Spells--");
       System.out.println("8: Wind Bolt");
       System.out.println("11: Water Bolt");
       System.out.println("14: Earth Bolt");
       System.out.println("17: Fire Bolt");
        System.out.println();
       System.out.println("19: Crumble Undead");
        System.out.println();
       System.out.println("--Blast Spells--");
       System.out.println("20: Wind Blast");
       System.out.println("23: Water Blast");
       System.out.println("27: Earth Blast");
       System.out.println("31: Fire Blast");
        System.out.println();
       System.out.println("--Member Spells--");
       System.out.println("25: Iban Blast");
       System.out.println("32: Claws of Guthix");
       System.out.println("33: Saradomin Strike");
       System.out.println("34: Flames of Zamorak");
       System.out.println("36: Wind Wave");
       System.out.println("38: Water Wave");
       System.out.println("42: Earth Wave");
       System.out.println("44: Fire Wave");
        System.out.println();

      int NPCID = Integer.parseInt(parameter[0]);
      int SpellID = Integer.parseInt(parameter[1]);
      CheckFighters(false);
      DisplayMessage("@gr2@fAcelEss: @dre@Ultimate Magic Script Running",3);

      while (Running() == true)
      {
            if (Fatigue() >= 98 && Running() == true)
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
               MagicNPC(GetNearestNPC(NPCID),(SpellID));
               Wait(2100);
            }
      }
      DisplayMessage("@gr2@fAcelEss: @dre@Ultimate Magic Script Stopped", 3);
    }
}