//Woodcutter and arrow shaft maker by Unknown Idiot / OhDearUrDead
//Woodcutting Script originally by RichyT <3
//Have inv set up; Sleeping bag first spot, axe second, knife third, shafts 4th, all the rest empty for wood.
//Make sure you start with at least 1 shaft.

public class Shafter_UI extends Script
{
    public boolean MustSleep = false;
    public boolean InvFullz = false;
    public Shafter_UI(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"makeshafts"};
    }
    public void ServerMessage(String message)
    {
      if (message.equals("@gam@You are too tired to cut the tree"))
         MustSleep = true;
      if (message.equals("@gre@You are too tired to gain experience, get some rest!"))
         MustSleep = true;
      if (message.equals("You wake up - feeling refreshed"))
         MustSleep = false;
      if (message.equals("@gam@Welcome to RuneScape!"))
         MustSleep = false;
    }
   
    public void start(String command, String parameter[])
    {
      DisplayMessage("@ran@-@ran@=@ran@=@ran@:@ora@Shaft Maker By Unknown Idiot started@ran@:@ran@=@ran@-", 3);
      while (Running())
      {
         int TreeTypes[] = new int [] { 0,1 };
         int TreeCoords[] = GetNearestObject(TreeTypes);
         if (TreeCoords[0] != -1 && TreeCoords[1] != -1)
         {
            while (ObjectAt(TreeCoords[0],TreeCoords[1]) != 4 && Running() && Sleeping() == false && MustSleep == false && !InvFullz)
            {
               AtObject(TreeCoords[0],TreeCoords[1]);
               Wait(666);
               if(InvCount() == 30) InvFullz = true;
            }
         }
         while(InvFullz)
         {
            UseWithInventory(2, 4);
            WaitForServerMessage(4666);
            Answer(0);
            WaitForServerMessage(4666);
            Wait(66);
            if(InvCount(14) == 0) InvFullz = false;
         }
         while (MustSleep)
         {
            Use(FindInv(1263));
            Wait(4666);
            while (Sleeping())
            Wait(666);
         }
         Wait(10);
      }
      DisplayMessage("@ran@-@ran@=@ran@=@ran@:@ora@Shaft Maker By Unknown Idiot stopped@ran@:@ran@=@ran@-", 3);
    }
} 