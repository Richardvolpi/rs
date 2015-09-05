public class Macro_TaverlyBuyer extends Methods {
    public Macro_TaverlyBuyer(mudclient mc) {
        super(mc);
    }
    private long l;

    public void run() {
        String s = GetInput("What do you want to buy? [vials/eyes]");
        boolean vials = s.equalsIgnoreCase("vials");

        AutoLogin(true);
        StartScanForMods();
        while (Running()) {
            if (GetX() < 342 && Running()) {
                while (GetIdObject(327, 552) == 64 && Running()) {
                    AtObject(327, 552);
                    Wait(Rand(500, 1000));
                }
                WalkToWait(326, 552);
                WalkToWait(324, 536);
                WalkToWait(323, 528);
                WalkToWait(315, 517);
                WalkToWait(319, 504);
                WalkToWait(330, 494);
                WalkToWait(341, 488);
                while (GetX() < 342 && Running()) {
                    AtObject(341, 487);
                    Wait(3000);
                }
                WalkToWait(351, 504);
                WalkToWait(364, 504);
            }
            while (CountInv() < 30 && Running()) {
                while (GetIdWallObject(371, 506) == 2 && Running()) {
                    AtWallObject(371, 506);
                    Wait(2000);
                }
                while (!QuestMenu() && Running()) {
                    l = GetMillis();
                    int ShopGuy[] = GetNpcById(230);

                    if (ShopGuy[0] != -1) {
                        TalkToNpc(ShopGuy[0]);
                    }
                    while (GetMillis() - l < 5000 && !QuestMenu() && Running()) { 
                        Wait(100);
                    }
                }
                Wait(500);
                Answer(0);
                l = GetMillis();
                while (!InShop() && Running() && GetMillis() - l < 10000) {
                    Wait(1000);
                }
                while (CountInv() < 30 && Running() && CountShop((vials ? 465 : 270)) > 0 && InShop()) {
                    if (CountInv(10) < ShopSellPrice((vials ? 465 : 270))) {
                        End("You ran out of geepeez!");
                    }
                    BuyShopItem((vials ? 465 : 270));
                    Wait(Rand(300, 400));
                }
                CloseShop();
                if (CountInv() < 30 && Running()) {
                    HopServer(true);
                }
            }
            while (GetIdWallObject(371, 506) == 2 && Running()) {
                AtWallObject(371, 506);
                Wait(2000);
            }
            WalkToWait(364, 504);
            WalkToWait(351, 504);
            WalkToWait(342, 487);
            while (GetX() > 341 && Running()) {
                AtObject(341, 487);
                Wait(3000);
            }
            WalkToWait(330, 494);
            WalkToWait(319, 504);
            WalkToWait(315, 517);
            WalkToWait(323, 528);
            WalkToWait(324, 536);
            WalkToWait(326, 545);
            while (CountInv(465) > 0 && Running()) {
                UseOnObject(GetItemPos(465), 327, 545);
                Wait(Rand(400, 800));
            }
            while (GetIdObject(327, 552) == 64 && Running()) {
                AtObject(327, 552);
                Wait(Rand(500, 1000));
            }
            WalkToWait(329, 553);
            while (!QuestMenu() && Running()) {
                l = GetMillis();
                int Banker[] = GetNpcById(95);

                if (Banker[0] != -1) {
                    TalkToNpc(Banker[0]);
                }
                while (GetMillis() - l < 5000 && !QuestMenu() && Running()) { 
                    Wait(100);
                }
            }
            Answer(0);
            l = GetMillis();
            while (!InBank() && Running() && GetMillis() - l < 10000) {
                Wait(2000);
            }
            Deposit((vials ? 464 : 270), CountInv(vials ? 464 : 270));
            Wait(Rand(300, 400));
            CloseBank();
            Wait(1000);
        }
        End();
    }
    
    public void OnChatMessage(String sender, String message) {
        sender = sender.toLowerCase();
        if (sender.startsWith("mod ") || sender.equals("andrew") || sender.equals("paul")) {
            Display("A mod was detected!");
            Wait(Rand(2000, 5000));
            Speak("Hey " + sender + " back soon, dinner :P");
            Wait(Rand(2000, 5000));
            Die();
        }
    }
    
    public void OnPrivateMessage(String sender, String message) {
        sender = sender.toLowerCase();
        if (sender.startsWith("mod ") || sender.equals("andrew") || sender.equals("paul")) {
            Display("A mod was detected!");
            Wait(Rand(2000, 5000));
            Die();
        }
    }
    
    public void OnServerMessage(String message) {}
    
}
