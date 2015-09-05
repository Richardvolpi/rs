public class CraftingFlax extends Script
{
    public CraftingFlax(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"craftflax"};
    }
    public void start(String command, String parameter[])
    {
       DisplayMessage("@cya@Flax Spinner by [-BigH140-]", 3);
       while(Running())
       {
               while(InvCount(675) < 30 || InvCount(676) > 0 && Running())
               {
                  int BankerID = GetNearestNPC(95);
                  while (QuestMenu() == false)
                  {
                     TalkToNPC(BankerID);
                        Wait(1000);
                  }
         Answer(0);
                  while (Bank() == false)
                  {
                       Wait(100);
                    }
                  while (InvCount(676) > 0 && Running() == true)
                  {
                     Deposit(676,1);
                     Wait(100);
                  }
                  while (InvCount(675) < 30 && Running() == true)
                  {
                     Withdraw(675,1);
                     Wait(100);
                  }
                  CloseBank();
                  Walk(286,572);
         if(DoorAt(287,571,0) == 2)
         {
            OpenDoor(287,571,0);
            Wait(100);
         }
         Walk(290,575);
         Walk(297,576);
         if(DoorAt(297,577,0) == 2)
         {
            OpenDoor(297,577,0);
            Wait(100);
         }
         Walk(296,579);
         while (InvCount(675) > 0 && Running())
         {
            UseOnObject(295,579,(FindInv(675)));
            Wait(700);
            if (Fatigue() >= 97 && Running())
            {
               while (!Sleeping() && Running())
               {
                  AtObject(298,579);
                  Wait(2000);
               }
               while (Sleeping() && Running())
               {
                  Wait(100);
               }
            }
         }
         if (InvCount(676) >= 30 && Running())
         {
            Walk(297,577);
            if(DoorAt(297,577,0) == 2)
            {
               OpenDoor(297,577,0);
               Wait(100);
            }
            Walk(291,575);
            Walk(287,572);
            if(DoorAt(287,571,0) == 2)
            {
               OpenDoor(287,571,0);
               Wait(100);
            }
            Walk(283,570);
         }
      }
   }
   DisplayMessage("@whi@SBoT - @red@Script Stopped",3);
    }
}