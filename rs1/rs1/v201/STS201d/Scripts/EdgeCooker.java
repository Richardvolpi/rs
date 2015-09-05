/* 
 * STS Edge cooker script, cooks Trout and/or Salmon, drops burnt fish.
 */

public class EdgeCooker extends Methods
{
    public EdgeCooker(mudclient mc){super(mc);}
    public long l;
    
    public void Body(String Args[])
    {
        AutoLogin(true);
        Display("Edge Cooker started!");
        while(Running())
        {
            WalkToWait(216,448);
            WalkToWait(217,446);
            WalkToWait(222,444);
            WalkToWait(225,444);
            WalkToWait(225,439);
            while(GetY() < 1000 && Running())
            {
                AtObject(226,439);
                Wait(1000);
            }
            Wait(5000);
            while((CountInv(356) > 0 || CountInv(358) > 0) && Running())
            {
                if(GetFatigue() > 90 && Running())
                {
                    while(!Sleeping() && Running())
                    {
                        UseItem(GetItemPos(1263));
                        Wait(2500);
                    }
                    while(Sleeping() && Running())
                        Wait(100);
                }
                UseOnObject(GetItemPos(CountInv(356) > 0 ? 356 : 358),222,1385);
                Wait(1000);
            }
            while(CountInv(360) > 0 && Running())
            {
                DropItem(GetItemPos(360));
                Wait(200);
            }
            WalkToWait(225,1383);
            while(GetY() > 1000 && Running())
            {
                AtObject(226,1383);
                Wait(1000);
            }
            Wait(5000);
            WalkToWait(225,445);
            WalkToWait(221,447);
            WalkToWait(216,448);
            while((CountInv(357) > 0 || CountInv(359) > 0) && Running())
            {
                l = GetMillis();
                while(!QuestMenu() && GetMillis() - l < 20000)
                {
                    int[] Npc = GetNpcById(95);
                    if(Npc[0] != -1)
                        TalkToNpc(Npc[0]);
                    Wait(1000);
                }
                Wait(2000);
                Answer(0);
                l = GetMillis();
                while(!QuestMenu() && GetMillis() - l < 10000)
                    Wait(10);
                Answer(0);
                while(InBank() && Running())
                {
                    while(CountInv(357) > 0 && Running())
                    {
                        Deposit(357,1);
                        Wait(200);
                    }
                    while(CountInv(359) > 0 && Running())
                    {
                        Deposit(359,1);
                        Wait(200);
                    }
                    Wait(500);
                    while(CountInv() < 30 && Running())
                    {
                        Withdraw((ItemInBank(356) ? 356 : 358),1);
                        Wait(200);
                    }
                    CloseBank();
                    Wait(200);
                }
            }
        }
    }
}