public class ironhead2 extends Methods
{
     public ironhead2(mudclient mudclient)
     {
          super(mudclient);
     }

     public void MainBody(String Args[])
     {
	AutoLogin(true);
          Display("@gr2@West Varrock Iron Arrow Heads Smither v.2 **FLAWLESS** -- Nattawat");
          while(Running() && CountInv(1263) > 0)
          {
	   gotosmith();
	   Wait(500);
	   smithing();
	   Wait(500);
	   gotobank();
	   Wait(500);
	   banking();
	   Wait(500);
          }
     }

     public void gotosmith()
     {
      while(GetX() != 147 && GetY() != 512) WalkToWait(147,512);
      Wait(300);
     }

     public void smithing()
     {
        while(GetFatigue() > 90 && !Sleeping() && Running())
          {
            UseItem(GetItemPos(1263));
            Wait(2000);
          }
        while(Sleeping())
          {
            Wait(100);
          }
        while(CountInv(170) > 0)
          {
            UseOnObject(GetItemPos(170), 148, 513);
            Wait(2000);
             if(QuestMenu())
               {
                Answer(2);
                Wait(1000);
                Answer(0);
               }
            Wait(1000);
          }
     }

     public void gotobank()
     {
      while(GetX() != 150 && GetY() != 503) WalkToWait(150,503);
      Wait(300);
     }

     public void banking()
     {
     while(!QuestMenu() && Running())
     {
          int[] Npc = GetNpcById(95);
          if(Npc[0] != -1)
          TalkToNpc(Npc[0]);
          Wait(1500);
     }
    while(QuestMenu() && Running())
    {
    Answer(0);
    Wait(8000);
    }
    while (!InBank() && CountInv(670) > 24)
       banking();
    while (InBank() && CountInv(670) > 24)
    {
       while (CountInv(670) > 24 && InBank())
       {
        Deposit(670,25);
        Wait(Rand(711,1024));
       }
       while (CountInv() < 30 && InBank())
       {
        Withdraw(170,1);
        Wait(Rand(150,300));
       }
       while (CountInv() < 30 && !InBank())
       {
       banking();
       }
    CloseBank();
    }
    }

}