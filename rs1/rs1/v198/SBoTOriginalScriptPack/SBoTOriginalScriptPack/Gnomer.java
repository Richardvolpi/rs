public class Gnomer extends Script
{
    public Gnomer(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"gnomer"};
    }
    public void start(String command, String parameter[])
    {
   DisplayMessage("Started",3);
   SetFightMode(1);
        while (Running())
        {
           if (!InCombat())
           {
         if (GetY() < 656)
                        {
                           DisplayMessage("@dre@Anti-Wander Activated! Moving back to the village.", 3);
                           SetFightMode(1);
            Walk(645,666);
                                Wait(1000);
                          }
                        if (GetX() < 637)
                        {
                                DisplayMessage("@dre@Anti-Wander Activated! Moving back to the village.", 3);
                                SetFightMode(1);
                                Walk(645,666);
                                Wait(1000);
                                SetFightMode(1);
                        }
                        if (Fatigue() >= 95)
         {
            SetFightMode(1);
            Beep();
            while(!Sleeping() && Running())
               {

                    Use(FindInv(1263));
                     Wait(2500);
            SetFightMode(1);
               }
               while(Sleeping() && Running())
                  Wait(100);
               }
                        if (!Sleeping())
         {
            SetFightMode(1);
            int ID = GetNearestNPC(409);
            if (ID != -1) 
            {
               SetFightMode(1);
                    SetFightMode(1);
               AttackNPC(ID);
               SetFightMode(1);
               Wait(1000);
            if(LastServerMessage() == "I can't get close enough")
            {
               Walk(658,669);
               SetFightMode(1);
               ResetLastServerMessage();
            }
            if(LastServerMessage() == "I can't get a clear shot from here")
            {
               Walk(658,669);
               SetFightMode(1);
               ResetLastServerMessage();
            }
            }

                      }   
      }
                if(InCombat())
                 SetFightMode(1);
                 Wait(200);
                 SetFightMode(1);
   }
    }
}
      