public class WoodCut extends Script
{
    public WoodCut(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"cut"};
    }
    public void start(String command, String parameter[])
    {
      while (Running())
      {
         DisplayMessage("Welcome to XRoaders Woodcutting Script",3);
         if (Fatigue() >= 97 && Running() == true)
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
               int TreeTypes[] = new int [] { 0,1 };
               int TreeCoords[] = GetNearestObject(TreeTypes);
               if (TreeCoords[0] != -1 && TreeCoords[1] != -1)
               {
                     while (ObjectAt(TreeCoords[0],TreeCoords[1]) != 4)
                     {
                           AtObject(TreeCoords[0],TreeCoords[1]);
                           Wait(3000);
                     }
         }
         if(InvCount(166)!=0 && Running() == true)
         {
            while(InvCount(14) != 0)
            {
            Drop(FindInv(14));
            Wait(1000);
            }
            while(ObjectAt(GetX(),GetY())!=97 && Running() == true)
            {
               UseOnItem(GetX(),GetY(),14,FindInv(166));
               Wait(1000);
            }
         }
         else if((InvCount(13)!=0) && (Running() == true))
         {
            UseWithInventory(FindInv(14),FindInv(13));
            Wait(500);
            if((InvCount(381)!=0) && (Running() == true))
            {
               UseWithInventory(FindInv(280),FindInv(381));
               Wait(500);
               if((InvCount(669)!=0) && (Running() == true))
               {
                  UseWithInventory(FindInv(637),FindInv(669));
                  Wait(500);
               }
            }
         }
      }
      DisplayMessage("@blu@Thanks for using WoodCut.",3);
      DisplayMessage("@blu@Any bugs/suggestions contact XRoader on IRC.",3);
    }
} 