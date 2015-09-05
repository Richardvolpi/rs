public class herb extends Script
{
    public herb(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"herb"};
     }
    public boolean reply;
   public void start(String command, String parameter[])
    {
   int FightTime = 1000;
   int untar[];
   int unran[];
   int unirit[];
   int unavan[];
   int unkwu[];
   int uncad[];
   int tar[];
   int ran[];
   int irit[];
   int avan[];
   int kwu[];
   int cad[];
   int law[];
   DisplayMessage("@ran@herb collector Created By G-unit", 3);
   while (Running())
      {   
      while(InvCount() < 30)
      {
         SetFightMode(2);
         untar = GetNearestItem(436);
         unran = GetNearestItem(438);
         unirit = GetNearestItem(439);
         unavan = GetNearestItem(440);
         unkwu = GetNearestItem(441);
         uncad = GetNearestItem(442);
         tar = GetNearestItem(446);
         ran = GetNearestItem(448);
         irit = GetNearestItem(449);
         avan = GetNearestItem(450);
         kwu = GetNearestItem(451);
         cad = GetNearestItem(452);
         law = GetNearestItem(42);
         if (untar[0] != -1)
         {
            TakeItem(untar[0], untar[1], 436);
            Wait(500);
         }

         if (unran[0] != -1)
         {
            TakeItem(unran[0], unran[1], 438);
            Wait(2000);
         }
         if (unirit[0] != -1)
         {
            TakeItem(unirit[0], unirit[1], 439);
            Wait(2000);
         }
         if (unavan[0] != -1)
         {
            TakeItem(unavan[0], unavan[1], 440);
            Wait(2000);
         }
         if (unkwu[0] != -1)
         {
            TakeItem(unkwu[0], unkwu[1], 441);
            Wait(2000);
         }
         if (uncad[0] != -1)
         {
            TakeItem(uncad[0], uncad[1], 442);
            Wait(2000);
         }
         
         if (tar[0] != -1)
         {
            TakeItem(untar[0], tar[1], 446);
            Wait(2000);
         }

         if (ran[0] != -1)
         {
            TakeItem(ran[0], ran[1], 448);
            Wait(2000);
         }
         if (irit[0] != -1)
         {
            TakeItem(irit[0], irit[1], 449);
            Wait(2000);
         }
         if (avan[0] != -1)
         {
            TakeItem(avan[0], avan[1], 450);
            Wait(2000);
         }
         if (kwu[0] != -1)
         {
            TakeItem(kwu[0], kwu[1], 451);
            Wait(2000);
         }
         if (cad[0] != -1)
         {
            TakeItem(cad[0], cad[1], 452);
            Wait(2000);
         }

         if (law[0] != -1)
         {
            TakeItem(law[0], law[1], 42);
            Wait(2000);
         }
         int ID = GetNearestNPC(270);
         if (ID != -1)
         {
            long T = System.currentTimeMillis();
            AttackNPC(ID);
            while (System.currentTimeMillis() - T <= 1000 && InCombat() == false && Running() == true)
            Wait(1);   
         }
         Wait(2000);
         while(InCombat())
         {
            Wait(100);
         }
      }
            OpenDoor(617, 556, 0);
            Wait(1000);
         Walk(618,562);
         Walk(611,566);
         Walk(610,574);
         Walk(612,580);
         Walk(612,588);
         Walk(610,594);
         Walk(604,594);
         Walk(597,599);
         Walk(597,603);
         Walk(590,603);
         Walk(589,602);
         Walk(588,599);
         Walk(587,592);
         Walk(587,584);
         Walk(587,575);
         Walk(583,573);   
      
      while (QuestMenu() == false)
           {
                  long T = System.currentTimeMillis();
                  int BankerID = GetNearestNPC(95);
                  TalkToNPC(BankerID);
                  while (System.currentTimeMillis() - T <= 6000 && QuestMenu() == false)
                        Wait(1);
           }
           Answer(0);
      Wait(2000);
      while(InvCount(436) > 0)
      {
         Deposit(436, 1);
         Wait(500);
      }
      while(InvCount(437) > 0)
      {
         Deposit(437, 1);
         Wait(500);
      }
      while(InvCount(438) > 0)
      {
         Deposit(438, 1);
         Wait(500);
      }
      while(InvCount(439) > 0)
      {
         Deposit(439, 1);
         Wait(500);
      }
      while(InvCount(440) > 0)
      {
         Deposit(440, 1);
         Wait(500);
      }
      while(InvCount(441) > 0)
      {
         Deposit(441, 1);
         Wait(500);
      }
      while(InvCount(442) > 0)
      {
         Deposit(442, 1);
         Wait(500);
      }
      while(InvCount(443) > 0)
      {
         Deposit(443, 1);
         Wait(500);
      }
      while(InvCount(446) > 0)
      {
         Deposit(446, 1);
         Wait(500);
      }
      while(InvCount(447) > 0)
      {
         Deposit(447, 1);
         Wait(500);
      }
      while(InvCount(448) > 0)
      {
         Deposit(448, 1);
         Wait(500);
      }
      while(InvCount(449) > 0)
      {
         Deposit(449, 1);
         Wait(500);
      }
      while(InvCount(450) > 0)
      {
         Deposit(450 , 1);
         Wait(500);
      }
      while(InvCount(451) > 0)
      {
         Deposit(451, 1);
         Wait(500);
      }
      while(InvCount(452) > 0)
      {
         Deposit(452, 1);
         Wait(500);
      }
      while(InvCount(453) > 0)
      {
         Deposit(453, 1);
         Wait(500);
      }
      while(InvCount(42) > 0)
      {
         Deposit(42, 1);
         Wait(500);
      }   
      CloseBank();

Walk(580,572);
Walk(586,570);
Walk(587,576);
Walk(587,582);
Walk(587,588);
Walk(588,594);
Walk(590,600);
Walk(597,600);
Walk(600,597);
Walk(604,594);
Walk(610,594);
Walk(611,586);
Walk(611,581);
Walk(611,574);
Walk(610,571);
Walk(609,567);
Walk(616,559);
Walk(617,556);
while(GetY() >= 556)
{
CloseDoor(617, 556, 0);
Wait(100);
}



}
      DisplayMessage("@red@herb collector STOPPED", 3);
    }
}