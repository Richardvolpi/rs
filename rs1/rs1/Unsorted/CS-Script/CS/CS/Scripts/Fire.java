public class Fire extends Script
{
    public Fire(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"fire"};
    }
   int TotalStartXP = 0;
   int StartLevel = 0;
   int BagCount = 0;
   long StartTime = 0;
    public void start(String command, String parameter[])
    {
      StartSleeper();
      TotalStartXP = GetStatXp(11);
      StartLevel = GetStat(11);
      StartTime = (long)((int)(GetMillies() / 1000));
      PrintLine("##### Start Firemaking Experience: " + TotalStartXP + " (" + StartLevel + ")");
      while (Running())
      {
         if (!Sleeping() && Fatigue() < 80)
         {
            PrintLine("#### Fire Making - RichyT");
            PrintLine("### " + ((long)((int)(GetMillies() / 1000)) - StartTime) + " seconds have passed");
            PrintLine("### Experience Gained So Far: " + (GetStatXp(11) - TotalStartXP));
            PrintLine("### Levels Gained So Far: " + (GetStat(11) - StartLevel));
            PrintLine("### Number of times used the sleeping bag so far: " + BagCount);

            PrintLine("## Cutting Trees...");
            Tree();

            long T = GetMillies();
            while (GetMillies() - T < 500 && GetGroundItemAt(GetX(),GetY()) != 14)
               Wait(1);

            PrintLine("## Lighting Fire...");
            Fire();
         }

         Wait(1);
      }
      PrintLine("#### Script Ended ####");
    }
   public void Fire()
   {
      int TreeTypes[] = {0,1};
      int[] TreeCoords = GetNearestObject(TreeTypes);
      if (TreeCoords[0] != -1)
      {
         while (GetObjectAt(GetX(), GetY()) == -1 && Running() && !Sleeping() && GetGroundItemAt(GetX(),GetY()) == 14 && Fatigue() < 80)
         {
            PrintLine("# Lighting Fire");
            int[] log = GetNearestItem(14);
            UseItemWithGroundItem(FindSlot(166),log[0]);
            long T = GetMillies();
            while (GetObjectAt(GetX(), GetY()) == -1 && Running() && GetMillies() - T < Rand(2500,3000) && !Sleeping() && GetGroundItemAt(GetX(),GetY()) == 14 && Fatigue() < 80)
               Wait(10);
         }
      }
   }
   public void Tree()
   {
      int TreeTypes[] = {0,1};
      int[] TreeCoords = GetNearestObject(TreeTypes);
      if (TreeCoords[0] != -1)
      {
         while (GetObjectAt(TreeCoords[1], TreeCoords[2]) < 2 && Running() && !Sleeping() && Fatigue() < 80)
         {
            PrintLine("# Cutting Tree");
            AtObject(TreeCoords[1], TreeCoords[2]);
            long T = GetMillies();
            while (GetObjectAt(TreeCoords[1], TreeCoords[2]) < 2 && Running() && GetMillies() - T < Rand(2500,3000) && !Sleeping() && Fatigue() < 80)
               Wait(10);
         }
      }
   }
   public void StartSleeper()
   {
      new Thread
      (
         new Runnable()
         {
            public void run()
            {
               while (Running())
               {
                  if (Fatigue() >= 80 && !Sleeping())
                  {
                     PrintLine("Fatigue is " + Fatigue() + ", using sleeping bag");
                     UseItem(FindSlot(1263));
                     BagCount++;
                     Wait(5000);
                  }
                  Wait(250);
               }
            }      
      }).start();
   }
} 