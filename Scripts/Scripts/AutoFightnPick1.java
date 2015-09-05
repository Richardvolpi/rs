public class AutoFightnPick1 extends Script
{
   public AutoFightnPick1(mudclient rs)
   {
       super(rs);
   }
   public String[] getCommands()
   {
       return new String[]{"fight1item"};
   }
   public void start(String command, String parameter[])
   {
     if (parameter.length != 3)
     {
        DisplayMessage(" @whi@ Bruncle:Bad syntax fool: it's /RUN FIGHT StYLe @ NpC @ ItEm iD @ ItEm iD 2 ", 3);
     } else {
        int FightMode = Integer.parseInt(parameter[0]);
        int FightTime = 700;
        int FightType = Integer.parseInt(parameter[1]);
        int ItemId =  Integer.parseInt(parameter[2]);
        int ItemId2 =  Integer.parseInt(parameter[3]);
        CheckFighters(true);
        DisplayMessage("@gre@SBoT: @whi@AutoFighter - RichyT", 3);
        while (Running() == true && GetCurrentStat(3) > 5)
        {
           if (GetFightMode() != FightMode)
           {
              SetFightMode(FightMode);
              DisplayMessage("@gre@SBoT: @whi@FightMode Changed To " + GetFightMode(),  3);
           }
           if (InCombat() == false)
           {
              if (Fatigue() > 97 && Sleeping() == false)
              {
                 DisplayMessage("@gre@SBoT: @whi@Sleeping", 3);
                 Use(FindInv(1263));
                 Wait(5000);
              } else {
                 if (Sleeping() == false)
                 {
                    int ID = GetNearestNPC(FightType);
                    if (ID != -1)
                    {
                       long T = System.currentTimeMillis();
                       AttackNPC(ID);
                       while (System.currentTimeMillis() - T <= FightTime && InCombat() == false && Running() == true)
                          Wait(1);
                     } else {
                     while (Sleeping() == false && InCombat() == false && ID == -1)
                     {
                       ID = GetNearestNPC(FightType);
                     while (ID == -1)
                       {
                         ID = GetNearestNPC(FightType);
                       int Item [] = GetNearestItem(ItemId);
                           if(Item != null)
                              {
                              TakeItem(Item[0], Item[1], ItemId);
                               Wait(150);
                              } 
                       ID = GetNearestNPC(FightType);
                       int Item2 [] = GetNearestItem(ItemId2);
                           if(Item2 != null)
                              {
                              TakeItem(Item2[0], Item2[1], ItemId2);
                               Wait(150);
                              } 
                        }
                       }

                        }
                  }
              }
           
           }
        }
     }
     DisplayMessage("@gre@SBoT: @whi@AutoFighter - @red@STOPPED", 3);
   }
} 