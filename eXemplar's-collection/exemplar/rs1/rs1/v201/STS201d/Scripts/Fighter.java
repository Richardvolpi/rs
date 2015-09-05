/* 
 * STS Autofighter script, features: lobster eating, logs out at half hp. Walkback radius
 * is optional. Locks fightmode to try and avoid unwanted exp.
 */

public class Fighter extends Methods
{
    public Fighter(mudclient mc){super(mc);}
    private String Modes[] = {"Controlled","Aggressive","Accurate","Defensive"};
    private int Start[] = new int[2];
    private boolean Eating;
 
    public void Body(String Args[])
    {
        AutoLogin(true);
        int Monster = Integer.parseInt(Args[0]);
        int FightMode = Integer.parseInt(Args[1]);
        int Limit = Integer.parseInt(Args[2]);
        long Checked = GetMillis();
        Start[0] = GetX();
        Start[1] = GetY();
        Eating = CountInv(373) > 0;
        Display("Autofighter by Reines: We will be training on " + NpcName(Monster) + ", " + (Eating? "eating lobsters(" + CountInv(373) + ")" : "without food."));
        Display("FightMode is locked on " + Modes[FightMode] + " and Walkback is " + (Limit > 0 ? "set to " + IntToStr(Limit) + " squares." : "turned off."));
        LockMode(FightMode);
        while(Running() && HitsPercent() > 50)
        {
            if(Limit > 0 && DistanceTo(Start[0],Start[1]) > Limit && GetMillis() - Checked > 5000 && Running() && !InCombat())
            {
                WalkToWait(Start[0],Start[1]);
                Checked = GetMillis();
            }
            if(GetFatigue() > 90 && Running())
            {
                while(!Sleeping() && Running())
                {
                    if(CountInv(1263) < 1)
                    {
                        Display("Script stopped, no sleeping bag");
                        End();
                    }
                    UseItem(GetItemPos(1263));
                    Wait(2500);
                }
                while(Sleeping() && Running())
                    Wait(100);
            }
            if((GetMaxLvl(3) - GetCurLvl(3)) > 12 && Running() && CountInv(373) > 0)
            {
                UseItem(GetItemPos(373));
                Wait(2000);
            }
            if(!InCombat() & GetFatigue() <= 90 & Running())
            {
                int[] Npc = GetNpcById(Monster);
                if(Npc[0] != -1)
                {
                    AttackNpc(Npc[0]);
                    Wait(Rand(500,700));
                }
                else
                    Wait(10);
            }
        }
        End();
    } 
}