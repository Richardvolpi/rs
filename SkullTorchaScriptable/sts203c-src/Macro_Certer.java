public class Macro_Certer extends Methods {

    public Macro_Certer(mudclient mc) {
        super(mc);
    }
    private boolean Uncert;
    private long l;
    private int i;
    private int CertID = -1;
    private int ItemID = -1;
    private int CerterNpcID = -1;
    private int CertAnswer = -1;
    private int UncertAnswer = -1;
    private String Where;
    private boolean Finished = false;
    private String[] Items = {
        "Iron Ores", "Iron Bars", "Coal Ores", "Steel Bars", "Mith Ores", "Mith Bars",
        "Gold Ores", "Gold Bars", "Silver Ores", "Silver Bars", "Raw Swordfish", "Cooked Swordfish", "Raw Lobster",
        "Cooked Lobster", "Raw Shark", "Cooked Shark", "Raw Bass", "Cooked Bass", "Willow Logs", "Maple Logs",
        "Yew Logs", "Limpwurt Roots", "Dragon Bones", "Prayer Restore", "Super Attack", "Super Strength",
        "Super Defence"};
    private int Selection = -1;

    public void run() {
        String s = GetInput("Would you like to cert or uncert?");

        if (s.equalsIgnoreCase("uncert")) {
            Uncert = true;
        } else if (s.equalsIgnoreCase("cert")) {
            Uncert = false;
        } else {
            End("Invalid choice");
        }
        Selection = GetOption("What item would you like to " + (Uncert ? "Uncert?" : "Cert?"), Items);
        switch (Selection) {
        case 0:
            CertID = 517;
            ItemID = 151;
            CerterNpcID = 225;
            CertAnswer = 0;
            UncertAnswer = 0;
            Where = "Draynor";
            break;

        case 1:
            CertID = 528;
            ItemID = 170;
            CerterNpcID = 226;
            CertAnswer = 0;
            UncertAnswer = 0;
            Where = "Draynor";
            break;

        case 2:
            CertID = 518;
            ItemID = 155;
            CerterNpcID = 225;
            CertAnswer = 1;
            UncertAnswer = 1;
            Where = "Draynor";
            break;

        case 3:
            CertID = 529;
            ItemID = 171;
            CerterNpcID = 226;
            CertAnswer = 1;
            UncertAnswer = 1;
            Where = "Draynor";
            break;

        case 4:
            CertID = 519;
            ItemID = 153;
            CerterNpcID = 225;
            CertAnswer = 2;
            UncertAnswer = 2;
            Where = "Draynor";
            break;

        case 5:
            CertID = 530;
            ItemID = 173;
            CerterNpcID = 226;
            CertAnswer = 2;
            UncertAnswer = 2;
            Where = "Draynor";
            break;

        case 6:
            CertID = 521;
            ItemID = 152;
            CerterNpcID = 225;
            CertAnswer = 3;
            UncertAnswer = 3;
            Where = "Draynor";
            break;

        case 7:
            CertID = 532;
            ItemID = 172;
            CerterNpcID = 226;
            CertAnswer = 3;
            UncertAnswer = 3;
            Where = "Draynor";
            break;

        case 8:
            CertID = 520;
            ItemID = 383;
            CerterNpcID = 225;
            CertAnswer = 4;
            UncertAnswer = 4;
            Where = "Draynor";
            break;

        case 9:
            CertID = 531;
            ItemID = 384;
            CerterNpcID = 226;
            CertAnswer = 4;
            UncertAnswer = 4;
            Where = "Draynor";
            break;

        case 10:
            CertID = 536;
            ItemID = 369;
            CerterNpcID = 227;
            CertAnswer = 3;
            UncertAnswer = 1;
            Where = "Draynor";
            break;

        case 11:
            CertID = 535;
            ItemID = 370;
            CerterNpcID = 227;
            CertAnswer = 2;
            UncertAnswer = 0;
            Where = "Draynor";
            break;

        case 12:
            CertID = 534;
            ItemID = 372;
            CerterNpcID = 227;
            CertAnswer = 1;
            UncertAnswer = 3;
            Where = "Draynor";
            break;

        case 13:
            CertID = 533;
            ItemID = 373;
            CerterNpcID = 227;
            CertAnswer = 0;
            UncertAnswer = 2;
            Where = "Draynor";
            break;

        case 14:
            CertID = 631;
            ItemID = 545;
            CerterNpcID = 299;
            CertAnswer = 3;
            UncertAnswer = 1;
            Where = "Catherby";
            break;

        case 15:
            CertID = 630;
            ItemID = 546;
            CerterNpcID = 299;
            CertAnswer = 2;
            UncertAnswer = 0;
            Where = "Catherby";
            break;

        case 16:
            CertID = 629;
            ItemID = 554;
            CerterNpcID = 299;
            CertAnswer = 1;
            UncertAnswer = 3;
            Where = "Catherby";
            break;

        case 17:
            CertID = 628;
            ItemID = 555;
            CerterNpcID = 299;
            CertAnswer = 0;
            UncertAnswer = 2;
            Where = "Catherby";
            break;

        case 18:
            CertID = 713;
            ItemID = 633;
            CerterNpcID = 341;
            CertAnswer = 2;
            UncertAnswer = 2;
            Where = "Ardougne";
            break;

        case 19:
            CertID = 712;
            ItemID = 634;
            CerterNpcID = 341;
            CertAnswer = 1;
            UncertAnswer = 1;
            Where = "Ardougne";
            break;

        case 20:
            CertID = 711;
            ItemID = 635;
            CerterNpcID = 341;
            CertAnswer = 0;
            UncertAnswer = 0;
            Where = "Ardougne";
            break;

        case 21:
            CertID = 1271;
            ItemID = 220;
            CerterNpcID = 778;
            CertAnswer = 6;
            UncertAnswer = 6;
            Where = "Yanille";
            break;

        case 22:
            CertID = 1270;
            ItemID = 814;
            CerterNpcID = 778;
            CertAnswer = 5;
            UncertAnswer = 5;
            Where = "Yanille";
            break;

        case 23:
            CertID = 1272;
            ItemID = 483;
            CerterNpcID = 778;
            CertAnswer = 0;
            UncertAnswer = 0;
            Where = "Yanille";
            break;

        case 24:
            CertID = 1273;
            ItemID = 486;
            CerterNpcID = 778;
            CertAnswer = 1;
            UncertAnswer = 1;
            Where = "Yanille";
            break;

        case 25:
            CertID = 1275;
            ItemID = 492;
            CerterNpcID = 778;
            CertAnswer = 3;
            UncertAnswer = 3;
            Where = "Yanille";
            break;

        case 26:
            CertID = 1274;
            ItemID = 495;
            CerterNpcID = 778;
            CertAnswer = 2;
            UncertAnswer = 2;
            Where = "Yanille";
            break;

        default:
            End("Invalid Selection");
        }
        AutoLogin(true);
        Display((Uncert ? "Uncerting " : "Certing ") + Items[Selection] + " at " + Where + "...");
        StartScanForMods();
        while (Running()) {
            if (Where.equals("Draynor")) {
                while (GetIdObject(219, 633) == 64) {
                    AtObject(219, 633);
                    Wait(2000);
                }
                WalkToWait(227, 631);
            } else if (Where.equals("Catherby")) {
                WalkToWait(439, 496);
                while (GetIdObject(439, 497) == 64) {
                    AtObject(439, 497);
                    Wait(2000);
                }
                WalkToWait(432, 496);
                WalkToWait(430, 486);
                WalkToWait(426, 485);
                while (GetIdWallObject(427, 485) == 2) {
                    AtWallObject(427, 485);
                    Wait(2000);
                }
                WalkToWait(427, 485);
            } else if (Where.equals("Ardougne")) {
                WalkToWait(581, 571);
                WalkToWait(587, 567);
                WalkToWait(587, 563);
                while (GetIdWallObject(586, 563) == 2) {
                    AtWallObject(586, 563);
                    Wait(2000);
                }
                WalkToWait(584, 564);
            } else if (Where.equals("Yanille")) {
                WalkToWait(585, 749);
                WalkToWait(595, 749);
                WalkToWait(603, 746);
                while (GetIdWallObject(603, 746) == 2) {
                    AtWallObject(603, 746);
                    Wait(2000);
                }
                WalkToWait(603, 745);
            } else {
                End("Error in certing location");
            }
            while ((Uncert && (CountInv(ItemID) < 25 && CountInv() < 30 && CountInv(CertID) != 0))
                    || (!Uncert && CountInv(ItemID) > 4)) {
                while (!QuestMenu() && Running()) {
                    l = GetMillis();
                    int Certer[] = GetNpcById(CerterNpcID);

                    if (Certer[0] != -1) {
                        TalkToNpc(Certer[0]);
                    }
                    while (GetMillis() - l < 5000 && !QuestMenu() && Running()) { 
                        Wait(100);
                    }
                }
                Wait(1000);
                Answer(Where.equals("Yanille") ? (Uncert ? 1 : 0) : (Uncert ? 0 : 1));
                l = GetMillis();
                while (!QuestMenu() && Running() && GetMillis() - l < 5000) {
                    Wait(100);
                }
                if ((Uncert ? UncertAnswer : CertAnswer) > 4) {
                    Answer(4);
                    l = GetMillis();
                    while (!QuestMenu() && Running() && GetMillis() - l < 5000) {
                        Wait(100);
                    }
                    Answer((Uncert ? UncertAnswer : CertAnswer) - 5);
                } else {
                    Answer(Uncert ? UncertAnswer : CertAnswer);
                }
                l = GetMillis();
                while (!QuestMenu() && Running() && GetMillis() - l < 5000) {
                    Wait(100);
                }
                if (Uncert) {
                    i = (CountInv(CertID) > 5 ? 5 : CountInv(CertID));
                } else {
                    i = (int) ((CountInv(ItemID) > 25 ? 25 : CountInv(ItemID)) / 5);
                }
                Answer(i - 1);
                l = GetMillis();
                while (((Uncert && (CountInv(ItemID) < 25 && CountInv() < 30 && CountInv(CertID) != 0))
                        || (!Uncert && CountInv(ItemID) > 4))
                                && GetMillis() - l < 3000) {
                    Wait(1000);
                }
            }
            if (Where.equals("Draynor")) {
                WalkToWait(222, 632);
                while (GetIdObject(219, 633) == 64) {
                    AtObject(219, 633);
                    Wait(2000);
                }
                WalkToWait(220, 635);
            } else if (Where.equals("Catherby")) {
                while (GetIdWallObject(427, 485) == 2) {
                    AtWallObject(427, 485);
                    Wait(2000);
                }
                WalkToWait(426, 485);
                WalkToWait(430, 486);
                WalkToWait(432, 496);
                while (GetIdObject(439, 497) == 64) {
                    AtObject(439, 497);
                    Wait(2000);
                }
                WalkToWait(439, 496);
            } else if (Where.equals("Ardougne")) {
                while (GetIdWallObject(586, 563) == 2) {
                    AtWallObject(586, 563);
                    Wait(2000);
                }
                WalkToWait(587, 567);
                WalkToWait(581, 571);
            } else if (Where.equals("Yanille")) {
                WalkToWait(603, 745);
                while (GetIdWallObject(603, 746) == 2) {
                    AtWallObject(603, 746);
                    Wait(2000);
                }
                WalkToWait(603, 746);
                WalkToWait(595, 749);
                WalkToWait(583, 749);
            } else {
                End("Error in certing location");
            }
            if (Finished && Running()) {
                End("Finished certing " + Items[Selection] + ", stopping script");
            }
            while ((Uncert && CountInv(ItemID) > 0) || (!Uncert && CountInv(ItemID) < 5)) {
                while (!QuestMenu() && Running()) {
                    l = GetMillis();
                    int Banker[] = GetNpcByIdNotTalk(BANKERS);

                    if (Banker[0] != -1) {
                        TalkToNpc(Banker[0]);
                    }
                    while (GetMillis() - l < 5000 && !QuestMenu() && Running()) { 
                        Wait(100);
                    }
                }
                Answer(0);
                l = GetMillis();
                while (!InBank() && Running() && GetMillis() - l < 5000) {
                    Wait(1000);
                }
                if (Uncert && InBank()) {
                    Deposit(ItemID, CountInv(ItemID));
                } else {
                    while (InBank() && CountInv(ItemID) < 25 && CountInBank(ItemID) > 0) {
                        Withdraw(ItemID, 1);
                        Wait(Rand(400, 500));
                        if (CountInBank(ItemID) == 0) {
                            if (CountInv(ItemID) < 5) {
                                End("Finished certing " + Items[Selection] + ", stopping script");
                            } else {
                                Finished = true;
                            }
                        }
                    }
                }
                l = GetMillis();
                while (((Uncert && CountInv(ItemID) > 0) || (!Uncert && CountInv(ItemID) < 5)) && GetMillis() - l < 3000) {
                    Wait(1000);
                }
                CloseBank();
            }
            if (Uncert && CountInv(CertID) == 0 && Running()) {
                End("Finished uncerting " + Items[Selection] + ", stopping script");
            }
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

    public void OnServerMessage(String message) {
        if (IsInStr(message, "is busy") && !IsInStr(message, "banker")) {
            Wait(1000);
            int Certer[] = GetNpcById(CerterNpcID);

            if (Certer[0] != -1) {
                TalkToNpc(Certer[0]);
            }
        } else if (IsInStr(message, "Banker is busy")) {
            Wait(1000);
            int Banker[] = GetNpcByIdNotTalk(BANKERS);

            if (Banker[0] != -1) {
                TalkToNpc(Banker[0]);
            }
        }
    }
}
