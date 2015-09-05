//fights guards, eats lobs, and banks at east bank for more food
//start at varrock castle

public class CastleGuard extends Script
{
    public CastleGuard(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"CastleGuard0", "CastleGuard1", "CastleGuard2", "CastleGuard3"};
    }

    public void start(String command, String parameter[])
    {
   
         int FightMode = 0;
         if (command.equalsIgnoreCase("CastleGuard0"))
            FightMode = 0;
         if (command.equalsIgnoreCase("CastleGuard1"))
            FightMode = 1;
         if (command.equalsIgnoreCase("CastleGuard2"))
            FightMode = 2;
         if (command.equalsIgnoreCase("CastleGuard3"))
            FightMode = 3;
         int FightTime = 600;
         CheckFighters(true);
         DisplayMessage("@gre@SBoT: @ran@Uber 1337 Varrock castle guard fighter by Chounin", 3);
         while (Running() == true && GetCurrentStat(3) > 5)
         {
            if (GetFightMode() != FightMode)
            {
               SetFightMode(FightMode);
               DisplayMessage("@gre@SBoT: @whi@FightMode Changed To " + GetFightMode(),  3);
            }
            if (Fatigue() >= 98 && Sleeping() == false && InCombat() == false)
            {
               DisplayMessage("@gre@SBoT: @whi@Sleeping", 3);
               Use(FindInv(1263));
               Wait(5000);
            }
            while (InCombat() == false && Running() == true && Fatigue() <= 98 && Sleeping() == false)
            {   
            while (InvCount(373) != 0)
            {
               if(GetStat(3) - GetCurrentStat(3) >= 12 && InvCount(373) != 0 && InCombat() == false && Running() == true)
               {
                  Use(FindInv(373));
                  Wait(1000);
               }
           
            if(GetStat(3) - GetCurrentStat(3) <= 11 && InCombat() == false && Running() == true && Fatigue() <= 98 && Sleeping() == false)
            {
               int ID = GetNearestNPC(65);
               if (ID != -1)
               {
                 long T = System.currentTimeMillis();
                 AttackNPC(ID);
                 while (System.currentTimeMillis() - T <= FightTime && InCombat() == false && Running() == true)
                 Wait(1);
               }
            }
         }
       }

            if (InvCount(373) == 0 && Sleeping() == false && Running() == true && InCombat() == false)
            {
               DisplayMessage("@red@Shit! Out of food", 3);
               Walk(140,1399);
               while (GetY() > 1000)
               {
                  AtObject(142,1398);
                  Wait(500);
               }
               while (DoorAt(139, 456, 3) == 2 && Running() == true && Sleeping() == false && InCombat() == false)
               {
                  OpenDoor(139, 456, 3);
                  Wait(500);
               }
               Walk(136,461);
               Walk(135,471);
               Walk(132,477);
               while(ObjectAt(131,478) == 64)
               {
                  AtObject(131,478);
                  Wait(500);
               }
               Walk(124,482);
               Walk(113,483);
               Walk(110,494);
               Walk(109,504);
               Walk(102,509);
               while (ObjectAt(102,509) == 64)
               {
                  AtObject(102,509);
                  Wait(500);
               }
               Walk(102,512);
            }
            while (QuestMenu() == false)
            {
               int BankerID = GetNearestNPC(95);
               TalkToNPC(BankerID);
               Wait(1000);
            }
            Answer(0);
            while (Bank() == false)
            {
               Wait(2000);
            }
            while (InvCount() != 30)
            {
            Withdraw(373,1);
            Wait(100);
            }
            if (InvCount() == 30)
            {
               CloseBank();
               Wait(500);
            }
            Walk(102,510);
            while (ObjectAt(102,509) == 64)
            {
               AtObject(102,509);
               Wait(500);
            }
            Walk(102,509);
            Walk(109,504);
            Walk(110,494);
            Walk(113,483);
            Walk(124,482);
            while(ObjectAt(131,478) == 64)
            {
               AtObject(131,478);
               Wait(500);
            }
            Walk(132,477);
            Walk(135,471);
            Walk(136,461);
            while (DoorAt(39, 456, 3) == 2 && Running() == true && Sleeping() == false && InCombat() == false)
            {
               OpenDoor(39, 456, 3);
               Wait(500);
            }
            while (GetY() < 1000 )
            {
               AtObject(142,454);
               Wait(500);
            }
         }
      }
}