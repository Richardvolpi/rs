//Orginaly by joujou
//fixed few things, added cooking, and changed banking to the falador,
//Wenakko
public class karamjaf1sh3r extends Script

{
    public karamjaf1sh3r(mudclient rs)
    {
        super(rs);

    }
    public String[] getCommands()
    {
        return new String[]{"karamjaf1sh3r"};

    }

   public void Kavele(int x, int y)
   {
      while(GetX() != x && GetY() != y)
      {
         try {
         WalkNoWait(x,y);
         Wait(1000);
         } catch (Exception e) {}
      }
   }
   
   public void start(String command, String parameter[])
    {   
       while (Running())
       {
   DisplayMessage("@gre@SBoT: @whi@Karamjaf1sh3r - Wenakko", 3);
// fishing lobsters
         while (Running() && InvCount() < 30)    
         {
//      System.out.println("Kalastetaan");
            AtObject2(368,684);
                Wait(1000);
//                Wait(1000);
//      Wait(1000);
//      Wait(500);
           if (Fatigue() > 84)
         {
            while (Sleeping() == false)
            {
               Use(FindInv(1263));
               Wait(2500);
            }
            while (Sleeping() == true && Running() == true)
            {
            Wait(100);
            }

         }
          }
   if (Running() == true)
   {
//fishingin loppu
//kavellaan karamjan laiturille
   Kavele(371,694);
   Kavele(370,702);
   Kavele(364,708);
   Kavele(355,710);
   Kavele(347,711);
   Kavele(339,712);
   Kavele(331,713);
//   WalkNoWait(329,713);
//puhutaan customsille
   while(QuestMenu() == false)
   {
      int CustomsID = GetNearestNPC(163);
      long CurrentTime = System.currentTimeMillis();
      TalkToNPC(CustomsID);
      while(System.currentTimeMillis() - CurrentTime <= 5000 && QuestMenu() == false)
      {
         Wait(100);
      }
      Wait(1000);
   }
   //vastataan
   Answer(0);
        while(QuestMenu() == false)
        {
            Wait(1);
        }
   Answer(1);
   while(QuestMenu() == false)
   {
      Wait(1);
   }
   Answer(0);
   //katotaan ollaanko port sarimissa
   while (GetX() != 268 && GetY() != 651)
   {
      Wait(1);
   }
/*   ResetLastServerMessage();
   while(InLastServerMessage("The ship arrives") == false)
   {
      Wait(1);
   } */
   // kavellaan cookaamaan (cock!)
   Kavele(269,644);
   Kavele(269,635);
   Kavele(276,636);
   Wait(1000);
   //Cookataan
   while(InvCount(372) != 0)
   {
      UseOnObject(275,638,3);
      Wait(500);
   }   
   if (Fatigue() > 97 && Sleeping() == false)
               {
                  DisplayMessage("@gre@SBoT: @whi@Sleeping", 3);
                  Use(FindInv(1263));
                  Wait(5000);
   //Dropataan Poltetut
   while(InvCount(374) != 0)
   {
   Drop(FindInv(374));
   Wait(500);
   }
   //kavellaan draynoriin
   Kavele(258,639);
   Kavele(258,621);
   Kavele(243,608);
   Kavele(230,629);
   Kavele(222,632);
   Kavele(219,633);
   //kavellaan sisaan
   WalkEmpty(217, 634, 222, 637);
   //puhutaan pankkiirille
   while(QuestMenu() == false)
   {
      int ClosestBankerID = GetNearestNPC(95);
      long CurrentTime = System.currentTimeMillis();
      TalkToNPC(ClosestBankerID);
      while(System.currentTimeMillis() - CurrentTime <= 5000 && QuestMenu() == false)
      {
         Wait(1);
      }
      Wait(100);
   }
   Answer(0);
   while(Bank() == false)
   {
      Wait(1);
   }
   Wait(100);
   //laitetaan lobbyt pankkiin
   while(InvCount(373) != 0)
   {
      Deposit(373,1);
      Wait(100);
   }
   Wait(100);
   Withdraw(10,60);
   //suljetaan pankki
   CloseBank();
   //avataan pankin ovi
   while (ObjectAt(219, 633) == 64)
   {
      AtObject(219, 633);
      Wait(5000);
   }
   //kavellaan port sarimiin
   Kavele(240,620);
   Kavele(245,610);
   Kavele(259,625);
   Kavele(259,639);
   Kavele(269,650);
   while (QuestMenu() == false)
   {
//      int SeamanID = GetNearestNPC(166);
      long CurrentTime = System.currentTimeMillis();
//      TalkToNPC(SeamanID);
      AtObject(265, 645);
      while(System.currentTimeMillis() - CurrentTime <= 5000 && QuestMenu() == false)
      {
         Wait(1000);
      }
      Wait(100);
   }
   Answer(0);
   //ootetaan
   while (GetX() != 324 && GetY() != 713)
   {
      Wait(1);
   }
/*   ResetLastServerMessage();
   while(InLastServerMessage("The ship arrives") == false)
   {
      Wait(1);
   } */
   //kavellaan laiturille
   Kavele(338,713);
   Kavele(362,710);
   Kavele(370,694);   
   WalkNoWait(368, 684);
//   WalkEmpty(369, 682, 371, 687);
      }
   //runningwhile
     }      
   }
}
}