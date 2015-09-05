/* 
 * Iron Miner and Banker by Nattawat 
 * Banks everything -- Iron ores and gems
 * If you are screw while banking, it will talk to banker again, so it would be flawless!
 * Starts infront of iron rocks south of falador, other place WILL NOT WORK!
 */

public class ironminer extends Methods
{
    public ironminer(mudclient mc){super(mc);}
    
    public void MainBody(String Args[])
    {
        AutoLogin(true);
        Display("@ran@I@ran@r@ran@o@ran@n @ran@m@ran@i@ran@n@ran@e@ran@r @ran@a@ran@n@ran@d@ran@ b@ran@a@ran@n@ran@k@ran@e@ran@r @gre@--- Nattawat");
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
    Display("@whi@Mining iron ores...");
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
            int RockCoords[] = GetObjectById(102); 
            if (RockCoords[1] > 317 && Running()) 
            AtObject(RockCoords[1],RockCoords[2]); 
            Wait(1000);
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
          Wait(1500);
    }
    while(QuestMenu() && Running())
    {
    Answer(0);
    Wait(8000);
    }
    while (!InBank() && CountInv(151) > 0)
       banking();
    while (InBank() && CountInv(151) > 0)
    {
       while (CountInv(151) > 0 && InBank())
       {
        Deposit(151,1);
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
       while (CountInv(151) > 0 && !InBank())
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
        while(GetX() != 312 && GetY() != 628) WalkToWait(312,628);
    while(GetX() != 316 && GetY() != 637) WalkToWait(316,637);
        Wait(1000);
    }
    public void OnChatMessage(String sender, String message)
    {
        if((sender.substring(0,4).equalsIgnoreCase("mod ") || sender.equalsIgnoreCase("andrew") || sender.equalsIgnoreCase("paul")) && Running())
        {
            Display("A mod was detected!");
            Wait(Rand(2000,5000));
            Speak("Ooh, hey! " + sender + " nice to see you here :P");
        Wait(Rand(3000,6000));
        Speak("Well sorry I have to go now, see you later " + sender + ".");
            Wait(Rand(2000,5000));
            LogOut();
            Die();
        }
    }
    
    public void OnPrivateMessage(String sender, String message)
    {
        if((sender.substring(4).equalsIgnoreCase("mod ") || sender.equalsIgnoreCase("andrew") || sender.equalsIgnoreCase("paul")) && Running())
        {
            Display("A mod was detected!");
            LogOut();
            Die();
        }
    }
    
    public void OnServerMessage(String message)
    {
    }
}