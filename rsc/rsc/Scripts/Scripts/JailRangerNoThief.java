public class JailRangerNoThief extends Script
{
    public boolean noarrows = false, sleep = false;
    public JailRangerNoThief(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{ "jailrangernt" };
    }
   public void ServerMessage(String message)
   {
      if (message.equals("@gre@You are too tired to gain experience, get some rest!"))
        sleep = true;
      if (message.equals("You wake up - feeling refreshed"))
        sleep = false;
      if (message.equals("@gam@Welcome to RuneScape!"))
        sleep = false;
      if (message.equals("@gam@I've run out of ammo!"))
        noarrows = true;
   }

    public void start(String command, String parameter[])
    {
   DisplayMessage("@gr2@fAcelEss: @dre@Jail Ranger",3);
   CheckFighters(false);

while(Running() && !noarrows)
{
         int Mon2 = GetNearestNPC(137);
         if (Mon2 != -1)
            {
               AttackNPC(Mon2);
               Wait(500); 
            } else   {
               int Mon3 = GetNearestNPC(192);
               if (Mon3 != -1)
                  {
                     AttackNPC(Mon3);
                     Wait(500); 
                  } else   {
                     int Mon4 = GetNearestNPC(21);
                     if (Mon4 != -1)
                        {
                          AttackNPC(Mon4);
                           Wait(500); 
                        }
                  }   
            }
      



   while (sleep && Running() == true)
               {
                     while (Sleeping() == false && Running() == true)
                     {
                        Use(FindInv(1263));
                        Wait(2500);
                     }
                     while (Sleeping() == true && Running() == true)
                     {
                        Wait(50);
                     }
            }
}

DisplayMessage("Stopped",3);
    }
}
