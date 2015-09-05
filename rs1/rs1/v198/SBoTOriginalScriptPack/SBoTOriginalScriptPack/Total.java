public class Total extends Script
{
    public Total(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"total"};
    }
    public void start(String command, String parameter[])
    {
      while (Running())
      {
      int totalexp = 0;
      int skilltotal = 0;
      for(int count = 0;count < 18;count++){
        totalexp += GetExperience(count);
        skilltotal += GetStat(count);
      }
      int combat = (((GetStat(0) + GetStat(1) + GetStat(2) + GetStat(3)) * 2) + GetStat(5) + GetStat(6) ) / 8;
      for(int i=0;i<25;i++)
         System.out.println();
      System.out.println("-----------------------");
      System.out.println("--------Total XP-------");
      System.out.println("---------by Jake-------");
      System.out.println("-----------------------");
      System.out.println("Total Experiance: " + totalexp);
      System.out.println("Skill Total: " + skilltotal);
      System.out.println("Combat: " + combat);
      System.out.println(" ");
      System.out.println("Attack: " + GetStat(0));
      System.out.println("Defense: " + GetStat(1));
      System.out.println("Strength: " + GetStat(2));
      System.out.println("Hitpoints: " + GetStat(3));
      System.out.println("Range: " + GetStat(4));
      System.out.println("Prayer: " + GetStat(5));
      System.out.println("Magic: " + GetStat(6));
      System.out.println("Cooking: " + GetStat(7));
      System.out.println("Woodcut: " + GetStat(8));
      System.out.println("Fletching: " + GetStat(9));
      System.out.println("Fishing: " + GetStat(10));
      System.out.println("Firemaking : " + GetStat(11));
      System.out.println("Crafting: " + GetStat(12));
      System.out.println("Smithing: " + GetStat(13));
      System.out.println("Mining: " + GetStat(14));
      System.out.println("Herblaw: " + GetStat(15));
      System.out.println("Agility: " + GetStat(16));
      System.out.println("Thieving: " + GetStat(17));
       while(Running())
       {
        Wait(1000);
       }
      }

    }
}