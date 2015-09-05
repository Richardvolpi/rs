/* 
 * STS Theiver script, will pickpocket the given Npc. Eats using lobsters and
 * will logout at half hp if required.
 */

public class Thieve extends Methods
{
    public Thieve(mudclient mc){super(mc);}
    
    public void Body(String Args[])
    {
        AutoLogin(true);
        long exp = GetExp(17);
        Display("Current Theiving Experience: " + IntToStr(exp));
        int mon = Integer.parseInt(Args[0]);
        int fm = Integer.parseInt(Args[1]);
        while(Running() && HitsPercent() > 50)
        {
            if(GetMode() != fm)
                SetMode(fm);
            if(!InCombat() & GetFatigue() <= 90 & Running())
            {
                int[] Npc = GetNpcById(mon);
                if(Npc[0] != -1) 
                {
                    ThieveNpc(Npc[0]);
                    Wait(Rand(600,800));
                }
            }
            while(InCombat() && Running())
            {
                WalkTo(GetX(),GetY());
                Wait(2000);
            }
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
            if((GetMaxLvl(3) - GetCurLvl(3)) > 12 && Running() && CountInv(373) > 0)
            {
                UseItem(GetItemPos(373));
                Wait(2000);
            }
        }
        Display("Script finished - you gained " + IntToStr(GetExp(17) - exp) + " theiving exp");
        End();
    }
}
