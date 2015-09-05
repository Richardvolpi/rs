public class BuyMindRunes extends Script
{

    public BuyMindRunes(mudclient mudclient)
    {
        super(mudclient);
    }

    public String[] getCommands()
    {
        return (new String[] {
            "buyminders"
        });
    }

    public void start(String s, String as[])
    {
        DisplayMessage("@red@@@blu@@@red@@@ran@ @red@J@blu@E@red@Z@blu@U@red@Z @blu@@@red@@@blu@@ - @whi@ Port Sarmin Air Rune Buyer Activated", 3);
        DisplayMessage("@blu@Now Dont Worry About A Thing And Go Masturbate", 3);
        for(; Running(); BuyRunes())
        {
            SetWorld(29);
            Logout();
            Wait(1000);
            for(; !LoggedIn(); Wait(1));
            BuyRunes();
            SetWorld(30);
            Logout();
            Wait(1000);
            for(; !LoggedIn(); Wait(1));
            BuyRunes();
            SetWorld(31);
            Logout();
            Wait(1000);
            for(; !LoggedIn(); Wait(1));
            BuyRunes();
            SetWorld(32);
            Logout();
            Wait(1000);
            for(; !LoggedIn(); Wait(1));
            BuyRunes();

            SetWorld(33);
            Logout();
            Wait(1000);
            for(; !LoggedIn(); Wait(1));
            BuyRunes();
            SetWorld(34);
            Logout();
            Wait(1000);
            for(; !LoggedIn(); Wait(1));
            
        }

        DisplayMessage("@red@Mind Rune Buyer STOPPED", 3);
    }

    public void BuyRunes()
    {
        for(; !QuestMenu(); Wait(1500))
        {
            int i = GetNearestNPC(54);
            TalkToNPC(i);
        }

        for(long l = System.currentTimeMillis(); System.currentTimeMillis() - l <= 6000L && !QuestMenu(); Wait(1));
        for(; QuestMenu(); Answer(0));
        for(long l1 = System.currentTimeMillis(); System.currentTimeMillis() - l1 <= 6000L && !Shop(); Wait(1));
        for(; Shop(); CloseShop())
                for(; ShopCount(33) > 0 && Shop(); Wait(50))
                Buy(33);
        for(; Shop(); CloseShop())
                for(; ShopCount(35) > 0 && Shop(); Wait(50))
                Buy(35);


    }
}