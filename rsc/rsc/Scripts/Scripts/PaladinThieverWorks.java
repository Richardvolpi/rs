public class PaladinThieverWorks extends Script 
{ 
    public PaladinThieverWorks(mudclient rs) 
    { 
        super(rs); 
    } 
    public String[] getCommands() 
    { 
        return new String[]{"paladinworks"}; 
    } 
    public void start(String command, String parameter[]) 
    { 
      int FightMode = Integer.parseInt(parameter[0]); 
      DisplayMessage("@ran@=@ran@=@ran@=@ran@=@ran@= @whi@Paladin Thiever Activated! @ran@=@ran@=@ran@=@ran@=@ran@=",3); 
      while (Running()) 
      { 
         while(InvCount(373) > 0 && Running()) 
         {    
            if (Fatigue()>85) 
            { 
               while(!Sleeping()) 
               { 
                  Use(FindInv(1263)); 
                  Wait(2500); 
               } 
               while(Sleeping()) 
                  Wait(100); 
                  } 
            SetFightMode(FightMode); 
            while ((GetStat(3) - GetCurrentStat(3)) > 12 && Running() && InvCount(373) > 0) 
            { 
               Use(FindInv(373)); 
               Wait(1000); 
            } 
            while(!InCombat() && Running()) 
            { 
               ThieveNPC(GetNearestNPC(323)); 
               Wait(500); 
            } 
            while(InCombat()) 
            { 
               WalkEmptyNoWait(609,1548,612,1550); 
               Wait(750); 
            } 
         } 
         if(Running()) 
         { 
            while(GetY()!=1547) 
            { 
               OpenDoor(609,1548,0); 
               Wait(500); 
            } 
            Wait(500); 
            Walk(609,1546); 
            Wait(500); 
            Walk(609,1544); 
            Wait(500); 
            AtObject(611,1545); 
            Wait(1500); 
            Walk(610,603); 
            Wait(500); 
            Walk(608,603); 
            Wait(500); 
            while(ObjectAt(607,603) == 64) 
            { 
               AtObject(607,603); 
               Wait(1000); 
            } 
            Walk(607,603); 
            Wait(500); 
            Walk(604,603); 
            Wait(500); 
            Walk(599,603); 
            Wait(500); 
            while(ObjectAt(598,603) == 57) 
            { 
               AtObject(598,603); 
               Wait(1000); 
            } 
            Walk(598,603); 
            Wait(500); 
            Walk(592,603); 
            Wait(500); 
            Walk(587,603); 
            Wait(500); 
            Walk(587,598); 
            Wait(500); 
            // Up was 2000 
            Walk(588,593); 
            Wait(500); 
            Walk(587,588); 
            Wait(500); 
            Walk(587,583); 
            Wait(500); 
            Walk(587,577); 
            Wait(500); 
            Walk(587,571); 
            Wait(500); 
            Walk(581,571); 
            Wait(500); 
            Walk(581,572); 
            Wait(500); 
         } 
         if(Running()) 
         { 
            while (!QuestMenu()) 
            { 
               TalkToNPC(GetNearestNPC(95)); 
               while(!QuestMenu()); 
                  Wait(1); 
            } 
            Answer(0); 
            while (!Bank()) 
               Wait(1); 
            while (InvCount() < 30) 
            { 
               Withdraw(373,1); 
               Wait(100); 
            } 
            CloseBank(); 
            Wait(1000); 
         } 
         if(Running()) 
         { 
            Walk(581,572); 
            Wait(500); 
            Walk(581,571); 
            Wait(500); 
            Walk(587,571); 
            Wait(500); 
            Walk(587,577); 
            Wait(500); 
            Walk(587,583); 
            Wait(500); 
            Walk(587,588); 
            Wait(500); 
            Walk(587,593); 
            Wait(500); 
            Walk(587,598); 
            Wait(500); 
            Walk(587,603); 
            Wait(500); 
            Walk(592,603); 
            Wait(500); 
            Walk(598,603); 
            Wait(500); 
            while(ObjectAt(598,603) == 57) 
            { 
               AtObject(598,603); 
               Wait(1000); 
            } 
            Walk(599,603); 
            Wait(500); 
            Walk(604,603); 
            Wait(500); 
            Walk(607,603); 
            Wait(500); 
            while(ObjectAt(607,603) == 64) 
            { 
               AtObject(607,603); 
               Wait(1000); 
            } 
            Walk(608,603); 
            Wait(500); 
            Walk(610,603); 
            Wait(500); 
         } 
         while (GetX() != 611 && GetY() != 1544 && Running()) 
         { 
            while(InCombat()) 
               Wait(1); 
            AtObject(611,601); 
            Wait(500); 
         } 
         while(GetX()!=611 && GetY()!=1544 && Running()) 
            Wait(1); 
         Wait(500); 
         Walk(609,1544); 
         Wait(500); 
         Walk(609,1547); 
         Wait(500); 
         while(GetY() != 1548 && Running()) 
         { 
            CloseDoor(609,1548,0); 
            Wait(1250); 
         } 
          } 
    } 
}
