public class Cabbager extends Script {
    public Cabbager(mudclient rs) {
        super(rs);
    }
    public String[] getCommands() {
        return new String[]{"cabbager"};
    }
    public void ShowUsage() {
        DisplayMessage2("@gre@SBoT: @whi@Cabbage Banker Usage: @blu@/run cabbager <1/2/3/4/5>",3);
        DisplayMessage2("@gre@SBoT: @whi@Where 1 = draynor-far, 2 = draynor-close, 3 = draynor-closest",3);
        DisplayMessage2("@gre@SBoT: @whi@Where 4 = falador-far, 5 = falador-close",3);
        DisplayMessage2("@gre@SBoT: @whi@Cabbage Seller Usage: @blu@/run cabbager 6",3);
        return;
    }
    public void start(String command, String parameter[]) {
        DisplayMessage2("@gre@SBoT: @whi@Cabbage Seller - @ran@By eXemplar",3);
        if (parameter == null) {
            ShowUsage();
        } else {
            if (Integer.parseInt(parameter[0]) > 6 || Integer.parseInt(parameter[0]) < 0)
                ShowUsage();
            else {
                if (Integer.parseInt(parameter[0]) == 6) {
                    while(Running() == true) {
                        DisplayMessage2("@gre@SBoT: @whi@Beginning cabbage banker in sell mode",3);
                        DisplayMessage2("@gre@SBoT: @whi@Withdrawing cabbages...",3);
                        WithdrawCabbages();
                        DisplayMessage2("@gre@SBoT: @whi@Going to store...",3);
                        StoreWalk(1);
                        DisplayMessage2("@gre@SBoT: @whi@Selling cabbages",3);
                        SellCabbages();
                        DisplayMessage2("@gre@SBoT: @whi@Going to bank...",3);
                        StoreWalk(2);
                    }
                } else {
                    switch(Integer.parseInt(parameter[0])) {
                        case 1:
                            DisplayMessage2("@gre@SBoT: @whi@Beginning cabbage banker at @red@draynor bank - far",3);
                            break;
                        case 2:
                            DisplayMessage2("@gre@SBoT: @whi@Beginning cabbage banker at @red@draynor bank - close",3);
                            break;
                        case 3:
                            DisplayMessage2("@gre@SBoT: @whi@Beginning cabbage banker at @red@draynor bank - closest",3);
                            break;
                        case 4:
                            DisplayMessage2("@gre@SBoT: @whi@Beginning cabbage banker at @red@falador bank - far",3);
                            break;
                        case 5:
                            DisplayMessage2("@gre@SBoT: @whi@Beginning cabbage banker at @red@falador bank - close",3);
                            break;
                    }
                    while (Running() == true) {
                        DisplayMessage2("@gre@SBoT: @whi@Beginning banking...",3);
                        DoBank(18,1);
                        DisplayMessage2("@gre@SBoT: @whi@Walking to cabbages...",3);
                        WalkTo(Integer.parseInt(parameter[0]),1,100);
                        DisplayMessage2("@gre@SBoT: @whi@Picking up cabbages...",3);
                        PickCabbages();
                        DisplayMessage2("@gre@SBoT: @whi@Walking to bank...",3);
                        WalkFrom(Integer.parseInt(parameter[0]),1,100);
                    }
                }
            }
        }
        return;
    }
    public void SellCabbages() {
        while (QuestMenu() == false) {
            TalkToNPC(GetNearestNPC(105));
            Wait(1000);
        }
        long T = System.currentTimeMillis();
        while (System.currentTimeMillis() - T <= 6000 && QuestMenu() == false)
            Wait(100);
        while (QuestMenu() == true) {
            Answer(0);
        }
        T = System.currentTimeMillis();
        while (System.currentTimeMillis() - T <= 6000 && Shop() == false)
        {Wait(1);}
        while (Running() == true && Shop() == true) {
            while(InvCount(18) > 0) {
                Sell(18);
                Wait(100);
            }
            CloseShop();
        }
    }
    public void StoreWalk(int place) {
        if (place == 1) {
            OpenBankDoor(327,552);
            WalkRan(326,543,1,100);
            WalkRan(318,539,1,100);
            Walk(316,533);
            while(Running() == true && ObjectAt(317, 533) ==2) {
                OpenDoor(317, 533, 1);
                Wait(100);
            }
            WalkRan(319,534,1,100);
        } else {
            while(Running() == true && ObjectAt(317, 533) ==2) {
                OpenDoor(317, 533, 1);
                Wait(100);
            }
            Walk(316,533);
            WalkRan(318,539,1,100);
            WalkRan(326,543,1,100);
            OpenBankDoor(327,552);
        }
    }
    public void WithdrawCabbages() {
        while (Bank() == false && Running() == true) {
            while (QuestMenu() == false && Running() == true) {
                int BankerID = GetNearestNPC(95);
                TalkToNPC(BankerID);
                long Time = System.currentTimeMillis();
                while (System.currentTimeMillis() - Time <= 2000 && QuestMenu() == false && Running() == true)
                    Wait(100);
            }
            Answer(0);
            long Time = System.currentTimeMillis();
            while (System.currentTimeMillis() - Time <= 5000 && Bank() == false && Running() == true)
                Wait(100);
        }
        while (Bank() == true && Running() == true) {
            while(InvCount() < 30) {
                Withdraw(18,1);
                Wait(100);
            }
            CloseBank();
        }
        return;
    }
    public void DisplayMessage2(String str, int i) {
        if (Running() == true)
            DisplayMessage(str,i);
        return;
    }
    public void WalkRan(int x, int y, int diff, int endwait) {
        if (Running() == true) {
            Walk(Rand(x - diff,x + diff),Rand(y - diff,y + diff));
            Wait(Rand(endwait,500));
        }
        return;
    }
    public void DoBank(int id,int count) {
        while (Bank() == false && Running() == true) {
            while (QuestMenu() == false && Running() == true) {
                int BankerID = GetNearestNPC(95);
                TalkToNPC(BankerID);
                long Time = System.currentTimeMillis();
                while (System.currentTimeMillis() - Time <= 2000 && QuestMenu() == false && Running() == true)
                    Wait(100);
            }
            Answer(0);
            long Time = System.currentTimeMillis();
            while (System.currentTimeMillis() - Time <= 5000 && Bank() == false && Running() == true)
                Wait(100);
        }
        while (Bank() == true && Running() == true) {
            while(InvCount(id) > 0) {
                Deposit(id,count);
                Wait(100);
            }
            CloseBank();
        }
        return;
    }
    public void OpenBankDoor(int x,int y) {
        if (Running() == true) {
            Walk(x,y);
            while (ObjectAt(x,y) == 64 && Running() == true) {
                AtObject(x,y);
                Wait(1000);
                DisplayMessage2("@gre@SBoT: @whi@Opening bank door",3);
            }
            Walk(x,y);
        }
        return;
    }
    public void WalkTo(int place, int diff, int endwait) {
        if (place == 1) {
            WalkRan(212,627,diff,endwait);
            WalkRan(213,620,diff,endwait);
            WalkRan(210,613,diff,endwait);
            WalkRan(208,607,diff,endwait);
            WalkRan(199,607,diff,endwait);
            WalkRan(191,603,diff,endwait);
            WalkRan(182,604,diff,endwait);
            WalkRan(176,607,diff,endwait);
            WalkRan(171,609,diff,endwait);
            WalkRan(166,611,diff,endwait);
            WalkRan(161,613,diff,endwait);
            WalkRan(155,614,diff,endwait);
            WalkRan(151,614,diff,endwait);
            WalkRan(145,616,diff,endwait);
            WalkRan(139,616,diff,endwait);
            WalkRan(138,612,diff,endwait);
        }
        if (place == 2) {
            WalkRan(215,632,diff,endwait);
            WalkRan(213,627,diff,endwait);
            WalkRan(212,617,diff,endwait);
            WalkRan(210,608,diff,endwait);
            WalkRan(209,598,diff,endwait);
            WalkRan(210,589,diff,endwait);
            WalkRan(213,579,diff,endwait);
            WalkRan(211,569,diff,endwait);
            WalkRan(214,566,diff,endwait);
            WalkRan(221,565,diff,endwait);
            WalkRan(226,558,diff,endwait);
            WalkRan(228,549,diff,endwait);
        }
        if (place == 3) {
            WalkRan(224,631,diff,endwait);
            WalkRan(228,627,diff,endwait);
            WalkRan(231,619,diff,endwait);
            WalkRan(237,613,diff,endwait);
            WalkRan(245,609,diff,endwait);
            WalkRan(252,610,diff,endwait);
            WalkRan(255,608,diff,endwait);
        }
        if (place == 4) {
            WalkRan(288,572,diff,endwait);
            WalkRan(289,577,diff,endwait);
            WalkRan(290,582,diff,endwait);
            WalkRan(285,586,diff,endwait);
            WalkRan(283,591,diff,endwait);
            WalkRan(281,595,diff,endwait);
            WalkRan(279,604,diff,endwait);
            WalkRan(274,608,diff,endwait);
            WalkRan(267,608,diff,endwait);
            WalkRan(257,608,diff,endwait);
            WalkRan(255,605,diff,endwait);
            WalkRan(255,602,diff,endwait);
        }
        if (place == 5) {
            WalkRan(290,581,diff,endwait);
            WalkRan(296,590,diff,endwait);
            WalkRan(301,600,diff,endwait);
            WalkRan(306,610,diff,endwait);
            WalkRan(314,616,diff,endwait);
            WalkRan(323,623,diff,endwait);
        }
        Wait(1000);
        return;
    }
    public void WalkFrom(int place, int diff, int endwait) {
        if (place == 1) {
            WalkRan(138,611,diff,endwait);
            WalkRan(139,616,diff,endwait);
            WalkRan(145,616,diff,endwait);
            WalkRan(151,614,diff,endwait);
            WalkRan(155,614,diff,endwait);
            WalkRan(161,613,diff,endwait);
            WalkRan(166,611,diff,endwait);
            WalkRan(171,609,diff,endwait);
            WalkRan(176,607,diff,endwait);
            WalkRan(182,604,diff,endwait);
            WalkRan(191,603,diff,endwait);
            WalkRan(199,607,diff,endwait);
            WalkRan(208,607,diff,endwait);
            WalkRan(210,613,diff,endwait);
            WalkRan(213,620,diff,endwait);
            WalkRan(212,627,diff,endwait);
            OpenBankDoor(220,633);
        }
        if (place == 2) {
            WalkRan(228,549,diff,endwait);
            WalkRan(226,558,diff,endwait);
            WalkRan(221,565,diff,endwait);
            WalkRan(214,566,diff,endwait);
            WalkRan(211,569,diff,endwait);
            WalkRan(213,579,diff,endwait);
            WalkRan(210,589,diff,endwait);
            WalkRan(209,598,diff,endwait);
            WalkRan(210,608,diff,endwait);
            WalkRan(212,617,diff,endwait);
            WalkRan(213,627,diff,endwait);
            WalkRan(215,632,diff,endwait);
            OpenBankDoor(220,633);
        }
        if (place == 3) {
            WalkRan(255,608,diff,endwait);
            WalkRan(252,610,diff,endwait);
            WalkRan(245,609,diff,endwait);
            WalkRan(237,613,diff,endwait);
            WalkRan(231,619,diff,endwait);
            WalkRan(228,627,diff,endwait);
            WalkRan(224,631,diff,endwait);
            OpenBankDoor(220,633);
        }
        if (place == 4) {
            WalkRan(255,602,diff,endwait);
            WalkRan(255,605,diff,endwait);
            WalkRan(257,608,diff,endwait);
            WalkRan(267,608,diff,endwait);
            WalkRan(274,608,diff,endwait);
            WalkRan(279,604,diff,endwait);
            WalkRan(283,591,diff,endwait);
            WalkRan(285,586,diff,endwait);
            WalkRan(290,582,diff,endwait);
            WalkRan(289,577,diff,endwait);
            WalkRan(288,572,diff,endwait);
            OpenBankDoor(287,571);
        }
        if (place == 5) {
            WalkRan(323,623,diff,endwait);
            WalkRan(314,616,diff,endwait);
            WalkRan(306,610,diff,endwait);
            WalkRan(301,600,diff,endwait);
            WalkRan(296,590,diff,endwait);
            WalkRan(290,581,diff,endwait);
            OpenBankDoor(287,571);
        }
        return;
    }
    public void PickCabbages() {
        while (Running() == true && InvCount(18) < 30) {
            if (GetNearestItem(18) != null) {
                int ItemPos[] = GetNearestItem(18);
                TakeItem(ItemPos[0], ItemPos[1],18);
                Wait(1500);
            }
        }
        return;
    }
}