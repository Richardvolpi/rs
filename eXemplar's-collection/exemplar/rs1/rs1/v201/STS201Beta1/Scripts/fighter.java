public class fighter extends Methods
{
    public fighter(mudclient mc){super(mc);}
 
    public void Body(String Args[])
    {
        AutoLogin(true);
        Display("Autofighter by Java Noob, Fixed by Reines");
        int monster = Integer.parseInt(Args[0]);
        int fmode = Integer.parseInt(Args[1]);
        while(Running())
        {
            if(GetMode() != fmode)
                SetMode(fmode);
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
            if(!InCombat() & GetFatigue() <= 90 & Running())
            {
                int[] Npc = GetNpcById(monster);
                if(Npc[0] != -1)
                {
                    AttackNpc(Npc[0]);
                    Wait(Rand(500,700));
                }
                else
                    Wait(10);
            }
        }
    } 
}