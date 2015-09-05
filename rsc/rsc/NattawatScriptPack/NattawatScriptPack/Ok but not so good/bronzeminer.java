/* 
 * Bronze Miner and Banker by Nattawat
 * Can mine both copper or tin, depends on what you want!
 * Mine Coppers: /start bronzeminer(copper)
 * Mine Tins: /start bronzeminer(tin) 
 * Banks everything -- Copper/Tin ores and gems
 * If you are screw while banking, it will talk to banker again, so it would be flawless!
 * Starts infront of Copper or Tin rocks south of falador, other place WILL NOT WORK!
 */

public class bronzeminer extends Methods
{
    public bronzeminer(mudclient mc){super(mc);}
    public int RockID = 0;

    public void MainBody(String Args[])
    {
        AutoLogin(true);
        Display("@ran@B@ran@r@ran@o@ran@n@ran@z@ran@e @ran@M@ran@i@ran@n@ran@e@ran@r @ran@a@ran@n@ran@d@ran@ B@ran@a@ran@n@ran@k@ran@e@ran@r @gre@--- Nattawat");
        if(Args.length != 1)
           {
          Display("@whi@To run: type /start bronzeminer(copper/tin)");
      Wait(200);
    }
     else
        {
         if(Args[0].equalsIgnoreCase("copper"))
            RockID = 100;
         if(Args[0].equalsIgnoreCase("tin"))
            RockID = 104;
    }
    while(Running())
        {
     mine();
     Wait(500);
     walktobank();
     Wait(500);
     banking();
     Wait(500);
     walktomine();
     Wait(500);
        }
    }
    public void mine()
    {
    Display("@whi@Mining ores...");
    while (CountInv() < 30)
    {
        if(GetFatigue() >= 95 && Running())
        {
                while(!Sleeping() && Running()) 
                { 
                 UseItem(GetItemPos(1263)); 
                 Wait(2500); 
                } 
                 while(Sleeping() && Running()) 
        {
                 Wait(500); 
        }
            }
            int Rock[] = GetObjectById(RockID);
            if(Rock[0] != -1)
            {
                AtObject(Rock[1],Rock[2]);
                Wait(1000);
            }
    }
    }
    public void walktobank()
    {
    Display("@whi@Going to bank...");
        while(GetX() != 312 && GetY() != 628) WalkToWait(312,628);
        while(GetX() != 311 && GetY() != 619) WalkToWait(311,619);
        while(GetX() != 309 && GetY() != 613) WalkToWait(309,613);
        while(GetX() != 307 && GetY() != 605) WalkToWait(307,605);
        while(GetX() != 303 && GetY() != 598) WalkToWait(303,598);
        while(GetX() != 298 && GetY() != 589) WalkToWait(298,589);
        while(GetX() != 292 && GetY() != 582) WalkToWait(292,582);
        while(GetX() != 290 && GetY() != 573) WalkToWait(290,573);
        while(GetX() != 287 && GetY() != 572) WalkToWait(287,572);
        Wait(1000);
    }
    public void banking()
    {
    Display("@whi@Banking...");
    while(!QuestMenu() && Running())
    {
          int[] Npc = GetNpcById(95);
          if(Npc[0] != -1)
          TalkToNpc(Npc[0]);
          Wait(1000);
    }
    while(QuestMenu() && Running())
    {
    Answer(0);
    Wait(5000);
    }
    while (!InBank() && CountInv(150) > 0 && CountInv(202) > 0)
       banking();
    while (InBank())
    {
       while (CountInv(150) > 0 && InBank())
       {
        Deposit(150,1);
        Wait(Rand(200,500));
       }
       while (CountInv(202) > 0 && InBank())
       {
        Deposit(202,1);
        Wait(Rand(200,500));
       }
       while (CountInv(157) > 0 && InBank())
       {
        Deposit(157,1);
        Wait(Rand(200,500));
       }
       while (CountInv(158) > 0 && InBank())
       {
        Deposit(158,1);
        Wait(Rand(200,500));
       }
       while (CountInv(159) > 0 && InBank())
       {
        Deposit(159,1);
        Wait(Rand(200,500));
       }
       while (CountInv(160) > 0 && InBank())
       {
        Deposit(160,1);
        Wait(Rand(200,500));
       }
       while (CountInv(150) > 0 && CountInv(202) > 0 && !InBank())
       {
       banking();
       }
    CloseBank();
    }
    }
    public void walktomine()
    {
    Display("@whi@Walking to mine again...");
        while(GetX() != 287 && GetY() != 572) WalkToWait(287,572);
        while(GetX() != 290 && GetY() != 573) WalkToWait(290,573);
        while(GetX() != 292 && GetY() != 582) WalkToWait(292,582);
        while(GetX() != 298 && GetY() != 589) WalkToWait(298,589);
        while(GetX() != 303 && GetY() != 598) WalkToWait(303,598);
        while(GetX() != 307 && GetY() != 605) WalkToWait(307,605);
        while(GetX() != 309 && GetY() != 613) WalkToWait(309,613);
        while(GetX() != 311 && GetY() != 619) WalkToWait(311,619);
        while(GetX() != 312 && GetY() != 638) WalkToWait(312,638);
        while(GetX() != 316 && GetY() != 637) WalkToWait(316,637);
        Wait(1000);
    }
    public void OnChatMessage(String sender, String message)
    {
        if((sender.substring(4).equalsIgnoreCase("mod ") || sender.equalsIgnoreCase("andrew") || sender.equalsIgnoreCase("paul")) && Running())
        {
            Display("A mod was detected!");
            Wait(Rand(2000,5000));
            Speak("Ooh, hey! " + sender + " nice to see you here :P");
        Wait(Rand(3000,6000));
        Speak("Well sorry I have to go now, see you later " + sender + ".");
            Wait(Rand(2000,5000));
            LogOut();
            End();
        }
    }
    
    public void OnPrivateMessage(String sender, String message)
    {
        if((sender.substring(4).equalsIgnoreCase("mod ") || sender.equalsIgnoreCase("andrew") || sender.equalsIgnoreCase("paul")) && Running())
        {
            Display("A mod was detected!");
            LogOut();
            End();
        }
    }
    
    public void OnServerMessage(String message)
    {
    }
}