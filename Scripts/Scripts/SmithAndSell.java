public class SmithAndSell extends Script
{
public SmithAndSell(mudclient rs)
       {
        super(rs);
       }
     
    public String[] getCommands()
       {
      return new String[]{"smithsell"};
       }
       
    public void SellToNPC (int NPCID, int Answers, int AnswerA, int AnswerB, int AnswerC, int ItemID)
       {
       while(Shop() == false && Running() == true)
          {
          while(QuestMenu() == false && Running() == true)
             {
             TalkToNPC(GetNearestNPC(NPCID));
             Wait(1000);
             }
          Answer(AnswerA);
       
          if(Answers > 1)
             {   
                while(QuestMenu() == false && Running() == true)
                Wait(250);
             Answer(AnswerB);
             }
             
          if(Answers > 2)
             {
                while(QuestMenu() == false && Running() == true)
                Wait(250);
             Answer(AnswerC);
             }

          while(Shop() == false && Running() == true)
             Wait(500);
          }
       while(InvCount(ItemID) > 0 && Running() == true)
          {
          Sell(ItemID);
          Wait(250);
          }
       CloseShop();
       }
   
    public void WalkToEastVarrockBankFromAnvils()
       {
       while(GetX() != 103 && GetY() != 512 && Running() == true)
          {
          if(GetY() < 502)
             Walk(117,501);
          if(GetY() <= 505)
             {
             Walk(117,505);
             if(ObjectAt(117,506) == 2)
                OpenDoor(117,506,0);
             Walk(117,506);
             }
          if(GetY() < 508)
             Walk(112,508);
          if(GetY() < 509)
             Walk(105,509);
          if(GetY() < 512)
             {
             Walk(103,509);
             if(ObjectAt(102,509) == 64)
                AtObject(102,509);
             Walk(103,512);
             }
          }
       }
       
    public void WalkToAnvils()
       {
       while(GetX() != 117 && GetY() != 501 && Running() == true)
          {
          if(GetY() > 510)
             {
             Walk(102,510);
             if(ObjectAt(102,509) == 64)
                AtObject(102,509);
             Walk(102,509);
             }
          if(GetY() > 507)
              Walk(106,507);
          if(GetY() > 506)
             Walk(114,506); 
          if(GetX() < 117)
             {
             Walk(117,506);
             if(ObjectAt(117,506) == 2)
                OpenDoor(117,506,0);
             Walk(117,503);
             }
          if(GetY() > 501)
             Walk(117,501);
          }
       }
   
    public void WalkToEastVarrockBank()
       {
       while(GetX() != 103 && GetY() != 512 && Running() == true)
          {
          if(GetY() < 508 || GetX() > 112)
             Walk(112,508);
          if(GetY() < 509)
             Walk(105,509);
          if(GetY() < 512)
             {
             Walk(103,509);
             if(ObjectAt(102,509) == 64)
                AtObject(102,509);
             Walk(103,512);
             }
          }
       }
 
             
          
    public void start(String command, String parameter[])
       {
       DisplayMessage("@Gre@Iron/Steel Plate Smither with selling",3);
   Wait(250);
   DisplayMessage("@Gre@By Alibvandestraat - thanks to RichyT for the bot!",3);
       Wait(250);
       DisplayMessage("@Gre@/run smithsell (iron)!",3);
   Wait(250);
   
   while(Running() == true)
      {
                  if(InvCount(170) < 25)
                   {
                   if(GetX() < 120 && GetX() > 112 && GetY() < 506 && GetY() > 497)
                   WalkToEastVarrockBankFromAnvils();
                   
                   if(GetX() >= 120 && GetX() <= 112 && GetY() >= 506 && GetY() <= 497)
                   WalkToEastVarrockBank();
                   
                   while(Bank() == false && Running() == true)
                      { 
                      while(QuestMenu() == false && Running() == true)
                         {
                         TalkToNPC(GetNearestNPC(95));
                   Wait(1000);
                   }
                Answer(0);
                
                while(Bank() == false && Running() == true)
                   Wait(500);
                }
                
             while(InvCount(170) < 25 && Running() == true && Bank() == true)
                {
                Withdraw(170,1);
                Wait(250);
                }
                CloseBank();
             }
          
          if(InvCount(170) == 25)
             WalkToAnvils();
             
             while(InvCount(170) > 0)
                {
                   if(Fatigue() >= 95)
                        {
                           while(Sleeping() == false && Running() == true)
                              {
                                 Use(FindInv(1263));
                                 Wait(2500);
                              }
                        
                           while(Sleeping() == true && Running() == true)
                                 Wait(250);
                              }else
                           
                           while(QuestMenu() == false && Running() == true)
                              {
                              UseOnObject(118,501,5);
                              Wait(1000);
                              }
                           Answer(1);
                        
                           while(QuestMenu() == false && Running() == true)
                              Wait(1000);
                           Answer(2);
                        
                           while(QuestMenu() == false && Running() == true)
                              Wait(1000);
                           Answer(1);
                           
                           Wait(2500);
                        }
                     
                     SellToNPC(48,1,1,1,1,8);
                     Wait(1000);                                                          
      }
   }
}

