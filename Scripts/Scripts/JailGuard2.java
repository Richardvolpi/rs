public class JailGuard2 extends Script
{

    public JailGuard2(mudclient mudclient)
    {
        super(mudclient);
    }

    public String[] getCommands()
    {
        return (new String[] {
            "jguard"
        });
    }

    public void start(String s, String as[])
    {
        int i = Integer.parseInt(as[0]);
        int j = 1200;
        CheckFighters(true);
        DisplayMessage("@cya@SBoT: @red@JailGuard killing script by Hulkkii", 3);
        do
        {
            if(!Running())
                break;
            if(GetFightMode() != i)
            {
                SetFightMode(i);
                DisplayMessage("@gre@SBoT: @whi@FightMode Changed To " + GetFightMode(), 3);
            }
            if(!InCombat())
            {
                if(GetX() < 170 && !Sleeping())
                {
                    DisplayMessage("@dre@back to jail!!", 3);
                    Wait(5000);
                    Walk(126, 645);
                    Walk(135, 636);
                    Walk(140, 636);
                    Walk(155, 639);
                    Walk(161, 639);
                    Walk(167, 639);
                    Walk(174, 634);
                    Walk(180, 631);
                    Walk(187, 633);
                    Walk(195, 633);
                    Wait(5000);
                    PrayerOn(10);
                }
                if(GetX() > 209 && !Sleeping())
                {
                    DisplayMessage("@dre@back to jail!!", 3);
                    Wait(500);
                    Walk(208, 631);
                    Walk(204, 632);
                    Walk(196, 633);
                    Wait(5000);
                } else
                if(Fatigue() > 97 && !Sleeping())
                {
                    DisplayMessage("@gre@SBoT: @whi@Sleeping", 3);
                    Use(FindInv(1263));
                    Wait(10000);
                } else
                if(!Sleeping())
                {
                    int k = GetNearestNPC(127);
                    if(k != -1)
                    {
                        long l = System.currentTimeMillis();
                        AttackNPC(k);
                        while(System.currentTimeMillis() - l <= (long)j && !InCombat() && Running())
                            Wait(1);
                    } else
                    {
                        Wait(1);
                    }
                }
            } else
            {
                while(InCombat() && Running())
                    Wait(1);
            }
        } while(true);
        DisplayMessage("@red@STOPPED", 3);
    }
}