public class Woodcutter extends Methods
{
    public Woodcutter(mudclient mudclient){super(mudclient);}

    public void Body(String as[])
    {
        long l = GetExp(8);
        long l1 = GetMillis();
        while(Running())
        {
            int ai[] = GetObjectById(0);
            int ai1[] = GetObjectById(1);
            if(ai[0] != -1)
                AtObject(ai[0], ai[1]);
            else if(ai1[0] != -1)
                AtObject(ai1[0], ai1[1]);
            Wait(Rand(1500, 1750));
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
        }
        Display("@whi@Gained A Total Of @gre@" + (GetExp(8) - l) + "@whi@ Woodcutting Experience In @gre@" + (GetMillis() - l1) / 60000L + "@whi@ Minute(s)!");
        End();
    }
}