public class FightZam extends Script
{


   public FightZam(mudclient rs)
   {
   super(rs);
   }
   public String[] getCommands()
   {
   return new String[]{"fightzam"};
   }
   public void start(String command, String parameter[])
   {
   if (parameter.length != 3)
   {
   
      DisplayMessage("@red@I-pod: @whi@Invalid number of parameters. /RUN fightzam [STYLE]@[FOOD]", 3);
     } else {
   int FM = Integer.parseInt(parameter[0]);
   int FY = (Rand(350,750));
   int FT = Integer.parseInt(parameter[1]);
   int Food = Integer.parseInt(parameter[2]);
   CheckFighters(true);
   DisplayMessage("@red@I-pod: @whi@Bo0m lets go get us some Zamorak Azz", 3);
   while (Running() == true && GetCurrentStat(3) > 10)
                  {
   if (GetFightMode() != FM)
                  {
   SetFightMode(FM);
   DisplayMessage("@red@I-pod: @whi@FightMode Changed To " + GetFightMode(), 3);
                           }
   if (InCombat() == false)
   {
   if (Fatigue() > 97 && Sleeping() == false)
   {
   DisplayMessage("@red@I-pod: @whi@Sleeping ZzZz", 3);
   Use(FindInv(1263));
   Wait(5000);
   }
   else {
    while (InCombat() == false && Sleeping() == false && GetCurrentStat(3) < 40)
         { 
    Use(FindInv(Food));
         Wait(2000);                 
         }
       if (Sleeping() == false)
{
   long T = System.currentTimeMillis();
   int Zam[] = new int[] {139, 140};
   int Npc = GetNearestNPC(Zam);
   TalkToNPC(Npc);

  while (System.currentTimeMillis() - T <= FT && InCombat() == false && Running() == true)
  Wait(1);
  } else
  Wait(1);
     }
  }
 else {
   while (InCombat() == true && Running() == true)
   Wait(1);
       }
               }
                    }
                           DisplayMessage("@red@STOPPED", 3);
                }
      } 