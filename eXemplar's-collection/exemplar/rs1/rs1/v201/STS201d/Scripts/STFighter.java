/* 
 * STSFighter is the ST Autofighter code converted into an STS script.
 */

public class STFighter extends Methods
{
    public STFighter(mudclient mc){super(mc);}
 
    public void Body(String Args[])
    {
        int NpcID = Integer.parseInt(Args[0]);
        int FightMode = Integer.parseInt(Args[1]);
        int WalkLimit = Integer.parseInt(Args[2]);
        Display("Starting AutoFighter");
        AutoLogin(true);
        int Start[] = new int[2];
        Start[0] = GetX();
        Start[1] = GetY();
        LockMode(FightMode);
        while(Running() && HitsPercent() > 50)
        {
            int Npc[] = GetNpcById(NpcID);
            if(Npc[0] != -1 && !InCombat() && !Sleeping() && Running())
            {
                AttackNpc(Npc[0]);
                Wait(Rand(600,1000));
            }
            else
                Wait(10);
            // Check doors?
            if(GetFatigue() > 90 && Running()) 
            { 
                while(!Sleeping() && Running()) 
                {
                    if(CountInv(1263) == 0)
                    {
                        Display("Script stopped, no sleeping bag");
                        End();
                    }
                    UseItem(GetItemPos(1263)); 
                    Wait(3000); 
                } 
                while(Sleeping() && Running()) 
                    Wait(100); 
            }
            while(InCombat() && Running())
                Wait(10);
            while(WalkLimit > 0 && Running() && DistanceTo(Start[0],Start[1]) >= WalkLimit && !InCombat())
            {
                WalkToWait(Start[0],Start[1]);
                Wait(2000);
            }
            if(GetMaxLvl(3) - GetCurLvl(3) > 12 && Running() && CountInv(373) > 0 && !InCombat())
            {
                Display("Eating a lobster");
                Wait(500);
                UseItem(GetItemPos(373));
                Wait(3000);
            }
        }
        End();
    }
}