public class Macro_Fletch extends Methods {
    public Macro_Fletch(mudclient mc) {
        super(mc);
    }
    private int ToCut;
    private int LogID;
    private int UnstrungBowID;
    private int StrungBowID;
    private long l;
    private boolean longbow;

    private boolean hopServ() {
        HopServer();
        return true;
    }

    public void run() {
        String s = GetInput("What do you wish to do? [cut/fletch/flax/shaft]");

        if (s.equalsIgnoreCase("Cut")) {
            s = GetInput("What will we be cutting? [Oak/Willow/Maple/Yew/Magic]");
            if (s.equalsIgnoreCase("Oak")) {
                ToCut = 306;
                LogID = 632;
            } else if (s.equalsIgnoreCase("Willow")) {
                ToCut = 307;
                LogID = 633;
            } else if (s.equalsIgnoreCase("Maple")) {
                ToCut = 308;
                LogID = 634;
            } else if (s.equalsIgnoreCase("Yew")) {
                ToCut = 309;
                LogID = 635;
            } else if (s.equalsIgnoreCase("Magic")) {
                ToCut = 310;
                LogID = 636;
            } else {
                End("Invalid tree type");
            }
            AutoLogin(true);
            Display("Starting to cut and bank " + s + " logs");
            StartScanForMods();
            while (Running()) {
                WalkToWait(501, 453);
                while (GetIdObject(500, 454) == 64) {
                    AtObject(500, 454);
                    Wait(2000);
                }
                WalkToWait(501, 455);
                if (s.equalsIgnoreCase("Oak") || s.equalsIgnoreCase("Willow")) {
                    WalkToWait(507, 451);
                    WalkToWait(512, 445);
                } else if (s.equalsIgnoreCase("Yew")) {
                    WalkToWait(509, 464);
                    WalkToWait(518, 473);
                } else if (s.equalsIgnoreCase("Magic")) {
                    WalkToWait(509, 464);
                    WalkToWait(512, 476);
                    WalkToWait(520, 490);
                }
                while (CountInv() < 30 && Running()) {
                    while (GetFatigue() > 98 && Running()) {
                        while (!Sleeping() && Running()) {
                            if (!InInv(1263)) {
                                End("No sleeping bag, stopping script");
                            }
                            UseItem(GetItemPos(1263));
                            Wait(2500);
                        }
                        while (Sleeping() && Running()) {
                            Wait(100);
                        } 
                    }
                    int[] Tree = GetObjectById(ToCut);

                    if (Tree[0] != -1) {
                        AtObject(Tree[1], Tree[2]); 
                        Wait(Rand(1500, 1600));
                    } else {
                        hopServ();
                        Wait(1000);
                        while (GetObjectById(new int[] { ToCut, 314, 4})[0] == -1) {
                            Wait(1000);
                        }
                        Wait(1000);
                    }
                }
                if (s.equalsIgnoreCase("Oak") || s.equalsIgnoreCase("Willow")) {
                    WalkToWait(512, 445);
                    WalkToWait(507, 451);
                } else if (s.equalsIgnoreCase("Yew")) {
                    WalkToWait(518, 473);
                    WalkToWait(509, 464);
                } else if (s.equalsIgnoreCase("Magic")) {
                    WalkToWait(520, 490);
                    WalkToWait(512, 476);
                    WalkToWait(509, 464);
                }
                WalkToWait(501, 455);
                while (GetIdObject(500, 454) == 64) {
                    AtObject(500, 454);
                    Wait(2000);
                }
                WalkToWait(501, 451);
                while (CountInv(LogID) > 0 && Running()) {
                    while (!QuestMenu() && Running()) {
                        l = GetMillis();
                        int Banker[] = GetNpcById(BANKERS);

                        if (Banker[0] != -1) {
                            TalkToNpc(Banker[0]);
                        }
                        while (GetMillis() - l < 8000 && !QuestMenu() && Running()) { 
                            Wait(100);
                        }
                    }
                    Answer(0);
                    l = GetMillis();
                    while (!InBank() && Running() && GetMillis() - l < 10000) {
                        Wait(2000);
                    }
                    Deposit(LogID, CountInv(LogID));
                    Wait(1000);
                    CloseBank();
                    Wait(1000);
                }
            }
            End();
        } else if (s.equalsIgnoreCase("Fletch")) {
            s = GetInput("Do you want to make long or short bows?");
            if (s.equalsIgnoreCase("long")) {
                longbow = true;
            } else if (s.equalsIgnoreCase("short")) {
                longbow = false;
            } else {
                End("Invalid type of bow.");
            }
            s = GetInput("What type of bows? [Oak/Willow/Maple/Yew/Magic]");
            if (s.equalsIgnoreCase("Oak")) {
                LogID = 632;
                UnstrungBowID = longbow ? 658 : 659;
                StrungBowID = longbow ? 648 : 649;
            } else if (s.equalsIgnoreCase("Willow")) {
                LogID = 633;
                UnstrungBowID = longbow ? 660 : 661;
                StrungBowID = longbow ? 650 : 651;
            } else if (s.equalsIgnoreCase("Maple")) {
                LogID = 634;
                UnstrungBowID = longbow ? 662 : 663;
                StrungBowID = longbow ? 652 : 653;
            } else if (s.equalsIgnoreCase("Yew")) {
                LogID = 635;
                UnstrungBowID = longbow ? 664 : 665;
                StrungBowID = longbow ? 654 : 655;
            } else if (s.equalsIgnoreCase("Magic")) {
                LogID = 636;
                UnstrungBowID = longbow ? 666 : 667;
                StrungBowID = longbow ? 656 : 657;
            } else {
                End("Invalid type of bow.");
            }
            AutoLogin(true);
            Display("Starting to fletch " + s + (longbow ? " longbows." : " shortbows"));
            while (Running()) {
                while (CountInv(StrungBowID) > 0 || ((CountInv(LogID) < 14 || CountInv(676) < 14) && CountInv() < 30)
                        || (CountInv(LogID) == 0 && CountInv(UnstrungBowID) == 0) || CountInv(676) == 0) {
                    while (!QuestMenu() && Running()) {
                        l = GetMillis();
                        int Banker[] = GetNpcById(BANKERS);

                        if (Banker[0] != -1) {
                            TalkToNpc(Banker[0]);
                        }
                        while (GetMillis() - l < 8000 && !QuestMenu() && Running()) { 
                            Wait(100);
                        }
                    }
                    Answer(0);
                    l = GetMillis();
                    while (!InBank() && Running() && GetMillis() - l < 10000) {
                        Wait(2000);
                    }
                    if (!InBank()) {
                        continue;
                    }
                    Deposit(StrungBowID, CountInv(StrungBowID));
                    int i = CountInv(UnstrungBowID);

                    if (i != 14 && i > 0) {
                        Deposit(UnstrungBowID, i > 13 ? i - 14 : i);
                    }
                    Wait(1000);
                    int ID = CountInBank(UnstrungBowID) > 13 || CountInv(UnstrungBowID) > 13 ? UnstrungBowID : LogID;

                    while (CountInv(ID) < 14 && Running() && InBank() && CountInBank(ID) > 0 && CountInv() < 30) {
                        Withdraw(ID, 1);
                        Wait(Rand(400, 500));
                    }
                    Wait(1000);
                    if (CountInv(ID) > 14 && InBank() && Running()) {
                        Deposit(ID, CountInv(ID) - 14);
                        Wait(500);
                    }
                    while (CountInv(676) < 14 && Running() && InBank() && CountInBank(676) > 0 && CountInv() < 30) {
                        Withdraw(676, 1);
                        Wait(Rand(400, 500));
                    }
                    Wait(1000);
                    if (CountInv(676) > 14 && InBank() && Running()) {
                        Deposit(676, CountInv(676) - 14);
                        Wait(500);
                    }
                    Wait(1000);
                    CloseBank();
                    Wait(1000);
                }
                while (CountInv(LogID) > 0 && Running()) {
                    if (!InInv(13)) {
                        End("You need a knife");
                    }
                    while (GetFatigue() > 98 && Running()) {
                        while (!Sleeping() && Running()) {
                            if (!InInv(1263)) {
                                End("No sleeping bag, stopping script");
                            }
                            UseItem(GetItemPos(1263));
                            Wait(2500);
                        }
                        while (Sleeping() && Running()) {
                            Wait(100);
                        } 
                    }
                    int i = GetItemPos(LogID);

                    if (i < 0) {
                        break;
                    }
                    UseItemWithItem(i, GetItemPos(13));
                    l = GetMillis();
                    while (!QuestMenu() && Running() && GetMillis() - l < 5000) {
                        Wait(100);
                    }
                    Answer(longbow ? 1 : 0);
                    Wait(1000);
                }
                while (CountInv(676) > 0 && CountInv(UnstrungBowID) > 0 && Running()) {
                    while (GetFatigue() > 98 && Running()) {
                        while (!Sleeping() && Running()) {
                            if (!InInv(1263)) {
                                End("No sleeping bag, stopping script");
                            }
                            UseItem(GetItemPos(1263));
                            Wait(2500);
                        }
                        while (Sleeping() && Running()) {
                            Wait(100);
                        } 
                    }
                    int i1 = GetItemPos(UnstrungBowID);
                    int i2 = GetItemPos(676);

                    if (i1 < 0 || i2 < 0) {
                        break;
                    }
                    UseItemWithItem(i1, i2);
                    Wait(Rand(500, 700));
                }
            }
            End();
        } else if (s.equalsIgnoreCase("Flax")) {
            if (GetMaxLvl(12) < 10) {
                End("You need at least 10 crafting to spin flax!");
            }
            Display("Starting flax banker");
            AutoLogin(true);
            while (Running()) {
                if (GetX() > 700) {
                    if (GetY() > 1000) {
                        WalkToWait(714, 1459);
                    }
                    while (GetY() > 1000) {
                        AtObject(714, 1460);
                        Wait(2000);
                    }
                    WalkToWait(704, 525);
                    WalkToWait(693, 526);
                }
                while (CountInv() < 30 && Running()) {
                    AtObject2(693, 524);
                    Wait(Rand(400, 700));
                }
                Wait(1000);
                while (GetY() < 1000) {
                    AtObject(692, 525);
                    Wait(2000);
                }
                while (CountInv(675) > 0 && Running()) {
                    while (GetFatigue() > 98 && Running()) {
                        while (!Sleeping() && Running()) {
                            if (!InInv(1263)) {
                                End("No sleeping bag, stopping script");
                            }
                            UseItem(GetItemPos(1263));
                            Wait(2500);
                        }
                        while (Sleeping() && Running()) {
                            Wait(100);
                        } 
                    }
                    int i = GetItemPos(675);

                    if (i < 0) {
                        break;
                    }
                    UseOnObject(i, 694, 1469);
                    Wait(Rand(400, 700));
                }
                Wait(1000);
                while (GetY() > 1000) {
                    AtObject(692, 1469);
                    Wait(2000);
                }
                WalkToWait(704, 525);
                WalkToWait(712, 519);
                while (GetY() < 1000) {
                    AtObject(714, 516);
                    Wait(2000);
                }
                WalkToWait(714, 1453);
                while (CountInv(676) > 0 && Running()) {
                    while (!QuestMenu() && Running()) {
                        l = GetMillis();
                        int Banker[] = GetNpcById(BANKERS);

                        if (Banker[0] != -1) {
                            TalkToNpc(Banker[0]);
                        }
                        while (GetMillis() - l < 8000 && !QuestMenu() && Running()) { 
                            Wait(100);
                        }
                    }
                    Answer(0);
                    l = GetMillis();
                    while (!InBank() && Running() && GetMillis() - l < 10000) {
                        Wait(2000);
                    }
                    if (!InBank()) {
                        continue;
                    }
                    Deposit(676, CountInv(676));
                    Wait(1000);
                    CloseBank();
                    Wait(1000);
                }
            }
            End();
        } else if (s.equalsIgnoreCase("Shaft")) {
            if (!InInv(13)) {
                End("No knife found");
            }
            int[] Tree = { 0, 1};

            AutoLogin(true);
            while (Running()) {
                while (GetFatigue() > 97 && Running()) {
                    while (!Sleeping() && Running()) {
                        if (!InInv(1263)) {
                            End("No Sleeping bag found, stopping script");
                        }
                        UseItem(GetItemPos(1263));
                        Wait(2500);
                    }
                    while (Sleeping() && Running()) {
                        Wait(100);
                    }
                }
                while (CountInv() < 30 && Running() && GetFatigue() < 98) {
                    int ToCut[] = GetObjectById(Tree);

                    if (ToCut[0] != -1) {
                        AtObject(ToCut[1], ToCut[2]);
                        Wait(Rand(1200, 1800));
                    } else {
                        Wait(100);
                    }
                }
                while (CountInv(14) > 0 && Running() && GetFatigue() < 98) {
                    int i = GetItemPos(14);

                    if (i < 0) {
                        break;
                    }
                    UseItemWithItem(GetItemPos(13), i);
                    l = GetMillis();
                    while (!QuestMenu() && Running() && GetMillis() - l < 5000) {
                        Wait(100);
                    }
                    Answer(0);
                    Wait(1000);
                }
            }
            End();
        } else {
            End("Invalid Option");
        }
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
