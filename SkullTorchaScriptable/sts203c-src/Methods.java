import java.util.Random;
import java.io.*;

public abstract class Methods {
    protected mudclient rs;
    private Random r = new Random();
    private Thread ModScanThread = null;
    
    public Methods(mudclient rs) {
        this.rs = rs;
    }

    public void MainBody(String Args[]) {}

    public void OnChatMessage(String sender, String message) {}

    public void OnPrivateMessage(String sender, String message) {}

    public void OnServerMessage(String message) {}

    public void run() {}

    public void KeyPressed(int key) {}

    public void OnInput(String input) {}

    public Stats ToShow() {
        return null;
    }

    public void Debug(String Command) {}

    public void OnIRCChatMessage(String channel, String senderName, String senderIdent, String senderHost, String message) {}

    public void OnIRCPrivateMessage(String senderName, String senderIdent, String senderHost, String message) {}

    public void OnIRCAction(String channel, String senderName, String senderIdent, String senderHost, String message) {}
    
    /** IRC **/
    public final boolean UsingIRC() {
        return rs.isAlive();
    }

    public final void IrcSendAction(String recipient, String message) {
        rs.ircSendAction(recipient, message);
    }

    public final void IrcSendMessage(String recipient, String message) {
        rs.ircSendMessage(recipient, message);
    }
    ;
    public final String GetVisibleChannel() {
        return rs.currentChannel();
    }

    public final String[] GetChanList() {
        return rs.getChanList();
    }

    public final boolean InChannel(String channel) {
        return rs.getChannelIndex(channel) > -1;
    }

    public final String GetNick() {
        return rs.getNick();
    }

    public final void JoinChannel(String channel) {
        if (channel.startsWith("#") && rs.getChannelIndex(channel) < 0) {
            rs.sendRaw("JOIN " + channel);
        }
    }

    public final void PartChannel(String channel) {
        if (channel.startsWith("#") && rs.getChannelIndex(channel) > -1) {
            rs.sendRaw("PART " + channel);
            rs.removeChannel(channel);
        }
    }
    
    /** Constants **/
    public final int[] BANKERS = { 95, 224, 268, 485, 540, 617};
    public final int[] BONES = { 20, 413, 604, 814};
    public final String[] SPELLS = {
        "Wind strike", "Confuse", "Water strike", "Enchant lvl-1 amulet", "Earth strike",
        "Weaken", "Fire strike", "Bones to bananas", "Wind bolt", "Curse", "Low level alchemy", "Water bolt",
        "Varrock teleport", "Enchant lvl-2 amulet", "Earth bolt", "Lumbridge teleport", "Telekinetic grab", "Fire bolt",
        "Falador teleport", "Crumble undead", "Wind blast", "Superheat item", "Camelot teleport", "Water blast",
        "Enchant lvl-3 amulet", "Iban blast", "Ardougne teleport", "Earth blast", "High level alchemy",
        "Charge Water Orb", "Enchant lvl-4 amulet", "Watchtower teleport", "Fire blast", "Claws of Guthix",
        "Saradomin strike", "Flames of Zamorak", "Charge earth Orb", "Wind wave", "Charge Fire Orb", "Water wave",
        "Charge air Orb", "Vulnerability", "Enchant lvl-5 amulet", "Earth wave", "Enfeeble", "Fire wave", "Stun",
        "Charge"};
    
    /** Methods **/
    public final boolean SleepIfAt(int Fatigue) {
        if (GetFatigue() >= Fatigue && Running()) {
            while (InCombat() && Running()) {
                Wait(100);
            }
            while (!Sleeping() && Running()) {
                if (!InInv(1263)) {
                    return false;
                }
                UseItem(GetItemPos(1263));
                Wait(3000);
            }
            while (Sleeping() && Running()) {
                Wait(100);
            }
        }
        return true;
    }

    public final void StartScanForMods() {
        if (ModScanThread != null) {
            Display("ModScan already running");
        }
        ModScanThread = new Thread(new Runnable() {
            public void run() {
                Display("Starting to scan for mods, if any are detected the bot will be shut down.");
                while (Running()) {
                    try {
                        for (int x = 0; x < CountPlayers(); x++) {
                            String Who = PlayerName(x).toLowerCase();

                            if (Who.startsWith("mod ") || Who.equals("andrew") || Who.equals("paul")) {
                                Display("---- " + Who.toUpperCase() + " was detected in AREA at " + Time() + " ----");
                                Die();
                            }
                            Wait(500);
                        }
                    } catch (Exception e) {}
                }
                StopScanForMods();
            }
        });
        ModScanThread.start();
    }

    public final boolean InTown(String Town) {
        return rs.inTown(Town);
    }

    public final String WhereIs(int x, int y) {
        return rs.whereIs(x, y);
    }
    
    /** Server Functions **/
    public final boolean ChangeWorld(int i) {
        return rs.ChangeWorld(i);
    }

    public final int GetWorld() {
        return Integer.parseInt(rs.Server);
    }

    public final boolean LoggedIn() {
        return rs.LoggedInVar == 1;
    }

    public final void LogOut() {
        if (rs.LoggedInVar == 1) {
            rs.Logout();
        }
    }

    public final void ForceLogOut() {
        rs.aca();
    }

    public final void AutoLogin(boolean on) {
        rs.AutoLogin = on;
    }

    public final boolean IsAutoLogin() {
        return rs.AutoLogin;
    }

    public final boolean MembersWorld() {
        return true;
    } // just here to stop old scripts complaining

    public final void Login(String user, String pass) {
        rs.loginRS(user, pass, false);
    }

    public final void HopServer(boolean skip) {
        HopServer();
    } // just here to stop old scripts complaining

    public final void HopServer() {
        int myWorld = GetWorld() + 1;

        if (myWorld > 4) {
            myWorld = 1;
        }
        ChangeWorld(myWorld);
        AutoLogin(false);
        Wait(2000);
        while (LoggedIn()) {
            LogOut();
            Wait(Rand(2000, 3000));
        }
        AutoLogin(true);
        while (!LoggedIn()) {
            Wait(3000);
        }
        if (IsPopup()) {
            ClosePopup();
        }
        Wait(Rand(4000, 6000));
    }
    
    /** Npc Functions **/
    public final int CountNpcs() {
        Load();
        return rs.NpcCount;
    }

    public final int[] GetNpcById(int id) {
        try {
            Load();
            return rs.GetNpcById(id);
        } catch (Exception error) {
            rs.ShowCmd(error);
            return new int[] { -1, -1, -1};
        }
    }

    public final int[] GetNpcById(int[] id) {
        try {
            Load();
            return rs.GetNpcById(id);
        } catch (Exception error) {
            rs.ShowCmd(error);
            return new int[] { -1, -1, -1};
        }
    }

    public final int[] GetAllNpcById(int id) {
        try {
            Load();
            return rs.GetAllNpcById(id);
        } catch (Exception error) {
            rs.ShowCmd(error);
            return new int[] { -1, -1, -1};
        }
    }

    public final int[] GetAllNpcById(int[] id) {
        try {
            Load();
            return rs.GetAllNpcById(id);
        } catch (Exception error) {
            rs.ShowCmd(error);
            return new int[] { -1, -1, -1};
        }
    }

    public final int[] GetNpcByIdNotTalk(int id) {
        try {
            Load();
            return rs.GetNpcByIdNotTalk(id);
        } catch (Exception error) {
            rs.ShowCmd(error);
            return new int[] { -1, -1, -1};
        }
    }

    public final int[] GetNpcByIdNotTalk(int[] id) {
        try {
            Load();
            return rs.GetNpcByIdNotTalk(id);
        } catch (Exception error) {
            rs.ShowCmd(error);
            return new int[] { -1, -1, -1};
        }
    }

    public final boolean NpcAttackable(int id) {
        return Ident.NpcAttackableVar[id] > 0;
    }

    public final boolean NpcInCombat(int index) {
        Load();
        return rs.Npc[index].Dir == 8 || rs.Npc[index].Dir == 9;
    }

    public final boolean NpcHealthBarShowing(int index) {
        Load();
        return rs.Npc[index].CombatVar > 0;
    }

    public final String NpcName(int id) {
        return Ident.NpcName[id];
    }

    public final String NpcDesc(int id) {
        return Ident.NpcDescription[id];
    }

    public final int NpcMaxHits(int id) {
        return Ident.NpcHitsLevel[id];
    }

    public final int NpcCombat(int id) {
        return (Ident.NpcAttackLevel[id] + Ident.NpcDefenceLevel[id] + Ident.NpcStrengthLevel[id]
                + Ident.NpcHitsLevel[id])
                / 4;
    }

    public final void AttackNpc(int index) {
        try {
            Load();
            rs.AttackNpc(index);
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final void TalkToNpc(int index) {
        try {
            Load();
            rs.TalkNpc(index);
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final void ThieveNpc(int index) {
        try {
            Load();
            rs.ThieveNpc(index);
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final int NpcId(int index) {
        try {
            Load();
            return rs.Npc[index].Id;
        } catch (Exception error) {
            rs.ShowCmd(error);
            return -1;
        }
    }

    public final int NpcX(int index) {
        try {
            Load();
            return ((rs.Npc[index].XCoord - 64) / rs.ecj) + rs.TileX;
        } catch (Exception error) {
            rs.ShowCmd(error);
            return -1;
        }
    }

    public final int NpcY(int index) {
        try {
            Load();
            return ((rs.Npc[index].YCoord - 64) / rs.ecj) + rs.TileY;
        } catch (Exception error) {
            rs.ShowCmd(error);
            return -1;
        }
    }

    public final void UseOnNpc(int pos, int index) {
        try {
            Load();
            rs.UseOnNpc(pos, index);
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }
    
    /** Player Functions **/
    public final int[] GetPlayerByName(String name) {
        Load();
        return rs.GetPlayerByName(name);
    }

    public final int PlayerCombat(int index) {
        Load();
        return rs.Player[index].Combat;
    }

    public final boolean PlayerInCombat(int index) {
        Load();
        return rs.Player[index].Dir == 8 || rs.Player[index].Dir == 9;
    }

    public final int CountPlayers() {
        Load();
        return rs.PlayerCount;
    }

    public final int PlayerX(int index) {
        Load();
        return ((rs.Player[index].XCoord - 64) / rs.ecj) + rs.TileX;
    }

    public final int PlayerY(int index) {
        Load();
        return ((rs.Player[index].YCoord - 64) / rs.ecj) + rs.TileY;
    }

    public final String PlayerName(int index) {
        Load();
        return rs.Player[index].Name;
    }

    public final void TradePlayer(int index) {
        try {
            Load();
            rs.TradePlayer(index);
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final boolean InTradeScreen1() {
        Load();
        return rs.TradeScreen1;
    }

    public final boolean InTradeScreen2() {
        Load();
        return rs.TradeScreen2;
    }

    public final void AcceptTrade1() {
        Load();
        rs.AcceptTrade1();
    }

    public final void AcceptTrade2() {
        Load();
        rs.AcceptTrade2();
    }

    public final boolean MyTrade1Accepted() {
        Load();
        return rs.MyTradeAccepted1;
    }

    public final boolean MyTrade2Accepted() {
        Load();
        return rs.MyTradeAccepted2;
    }

    public final boolean OpponentTradeAccepted() {
        Load();
        return rs.OpponentTradeAccepted;
    }

    public final void DeclineTrade() {
        Load();
        rs.DeclineTrade();
    }

    public final void OfferItems(int items[], int amount[]) {
        try {
            rs.OfferItems(items, amount);
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final void AddToOffer(int item, int amount) {
        try {
            Load();
            rs.Offer(item, amount);
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final int[] GetOpponentTradeItems() {
        try {
            Load();
            if (!InTradeScreen1() && !InTradeScreen2()) {
                return new int[0];
            }
            int i = rs.OpponentTradeIndex;
            int[] array = new int[i];

            for (int x = 0; x < i; x++) {
                array[x] = rs.OpponentTradeItem[x];
            }
            return array;
        } catch (Exception error) {
            rs.ShowCmd(error);
            return new int[0];
        }
    }

    public final int[] GetOpponentTradeAmounts() {
        try {
            Load();
            if (!InTradeScreen1() && !InTradeScreen2()) {
                return new int[0];
            }
            int i = rs.OpponentTradeIndex;
            int[] array = new int[i];

            for (int x = 0; x < i; x++) {
                array[x] = rs.OpponentTradeAmount[x];
            }
            return array;
        } catch (Exception error) {
            rs.ShowCmd(error);
            return new int[0];
        }
    }

    public final boolean IsOffered(int id, int amount) {
        try {
            Load();
            if (!InTradeScreen1() && !InTradeScreen2()) {
                return false;
            }
            boolean flag = false;
            int[] trade = GetOpponentTradeItems();

            for (int x = 0; x < trade.length; x++) {
                if (trade[x] == id) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return false;
            }
            trade = GetOpponentTradeAmounts();
            for (int x = 0; x < trade.length; x++) {
                if (trade[x] >= amount) {
                    return true;
                }
            }
            return false;
        } catch (Exception error) {
            rs.ShowCmd(error);
            return false;
        }
    }

    public final String GetTradeOpponentName() {
        try {
            Load();
            return rs.TradeOpponentName;
        } catch (Exception error) {
            rs.ShowCmd(error);
            return new String();
        }
    }
    
    /** Communication Functions **/
    public final void Speak(String s) {
        try {
            Load();
            rs.Talk(s);
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final void SendPM(String to, String message) {
        try {
            Load();
            rs.SendPM(to, message);
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final void AddToFriends(String player) {
        try {
            Load();
            if (player.length() > 0 && t.PlayerNameToLong(player) != rs.My.PlayerLong) {
                rs.AddFriend(player);
            }
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final void AddToIgnore(String player) {
        try {
            Load();
            if (player.length() > 0 && t.PlayerNameToLong(player) != rs.My.PlayerLong) {
                rs.AddIgnore(player);
            }
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final String[] GetFriendList() {
        try {
            String[] Friends = new String[rs.FriendCount];

            for (int x = 0; x < rs.FriendCount; x++) {
                Load();
                Friends[x] = t.PlayerLongToName(rs.FriendList[x]);
            }
            return Friends;
        } catch (Exception error) {
            rs.ShowCmd(error);
            return new String[0];
        }
    }

    public final String[] GetIgnoreList() {
        try {
            String[] Ignores = new String[rs.IgnoreCount];

            for (int x = 0; x < rs.IgnoreCount; x++) {
                Load();
                Ignores[x] = t.PlayerLongToName(rs.IgnoreList[x]);
            }
            return Ignores;
        } catch (Exception error) {
            rs.ShowCmd(error);
            return new String[0];
        }
    }

    public final void RemoveFromFriends(String player) {
        try {
            Load();
            rs.RemoveFriend(t.PlayerNameToLong(player));
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final void RemoveFromIgnore(String player) {
        try {
            Load();
            rs.RemoveIgnore(t.PlayerNameToLong(player));
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final boolean IsOnFriendList(String player) {
        Load();
        for (int x = 0; x < rs.FriendCount; x++) {
            if (rs.FriendList[x] == t.PlayerNameToLong(player)) {
                return true;
            }
        }
        return false;
    }

    public final boolean IsOnIgnoreList(String player) {
        Load();
        for (int x = 0; x < rs.IgnoreCount; x++) {
            if (rs.IgnoreList[x] == t.PlayerNameToLong(player)) {
                return true;
            }
        }
        return false;
    }

    /** Spell Functions **/
    public final String SpellName(int spell) {
        Load();
        return Ident.SpellName[spell];
    }

    public final boolean IsCastableOnNpc(int spell) {
        Load();
        return Ident.SpellStatus[spell] == 2;
    }

    public final void CastOnNpc(int spell, int index) {
        try {
            Load();
            rs.CastOnNpc(spell, index);
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final boolean IsCastableOnItem(int spell) {
        Load();
        return Ident.SpellStatus[spell] == 3;
    }

    public final void CastOnItem(int spell, int pos) {
        try {
            Load();
            rs.CastOnItem(spell, pos);
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final boolean IsCastableOnGItem(int spell) {
        Load();
        return Ident.SpellStatus[spell] == 3;
    }

    public final void CastOnGItem(int spell, int id, int x, int y) {
        try {
            Load();
            rs.CastOnGItem(spell, id, x, y);
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final boolean IsCastableOnSelf(int spell) {
        Load();
        return Ident.SpellStatus[spell] < 2;
    }

    public final void CastOnSelf(int spell) {
        try {
            Load();
            rs.CastOnSelf(spell);
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final boolean IsCastableOnGround(int spell) {
        Load();
        return Ident.SpellStatus[spell] == 6;
    }

    public final void CastOnGround(int spell) {
        try {
            Load();
            rs.CastOnGround(spell);
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final boolean IsCastableOnWallObject(int spell) {
        Load();
        return Ident.SpellStatus[spell] == 4;
    }

    public final void CastOnWallObject(int spell, int x, int y) {
        try {
            Load();
            rs.CastOnWallObject(spell, x, y);
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final boolean IsCastableOnObject(int spell) {
        Load();
        return Ident.SpellStatus[spell] == 5;
    }

    public final void CastOnObject(int spell, int x, int y) {
        try {
            Load();
            rs.CastOnObject(spell, x, y);
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final boolean HasRunesForSpell(int spell) {
        Load();
        return rs.HasRunesForSpell(spell);
    }
    
    /** Npc Interaction Functions **/
    public final boolean QuestMenu() {
        try {
            Load();
            return rs.QuestMenu;
        } catch (Exception error) {
            rs.ShowCmd(error);
            return false;
        }
    }

    public final int CountQuestMenu() {
        try {
            Load();
            if (rs.QuestMenu) {
                return rs.QuestMenuOptionsCount;
            } else {
                return -1;
            }
        } catch (Exception error) {
            rs.ShowCmd(error);
            return -1;
        }
    }

    public final String GetQuestOption(int i) {
        try {
            Load();
            if (rs.QuestMenu) {
                return rs.QuestMenuOptions[i];
            } else {
                return null;
            }
        } catch (Exception error) {
            rs.ShowCmd(error);
            return null;
        }
    }

    public final void Answer(int i) {
        try {
            Load();
            rs.Reply(i);
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final boolean IsNpcTalking(int index) {
        Load();
        return rs.Npc[index].TalkVar > 0;
    }
    
    /** Bank & Shop Functions **/
    public final int BankCount() {
        return rs.BankCount;
    }

    public final int BankItemId(int index) {
        try {
            return rs.edb[index];
        } catch (Exception error) {
            rs.ShowCmd(error);
            return -1;
        }
    }

    public final void Withdraw(int id, int amount) {
        try {
            Load();
            rs.Withdraw(id, amount, true);
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final void Deposit(int id, int amount) {
        try {
            Load();
            rs.Withdraw(id, amount, false);
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final boolean ItemInBank(int id) {
        Load();
        return CountInBank(id) > 0;
    }

    public final int CountInBank(int id) {
        Load();
        if (rs.InBank) {
            for (int a = 0; a < rs.BankCount; a++) {
                if (rs.edb[a] == id) {
                    return rs.edc[a];
                }
            }
            return 0;
        } else {
            return -1;
        }
    }

    public final boolean InBank() {
        Load();
        return rs.InBank;
    }

    public final void CloseBank() {
        try {
            Load();
            rs.CloseBank();
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final boolean InShop() {
        Load();
        return rs.InShop;
    }

    public final void CloseShop() {
        try {
            Load();
            rs.CloseShop();
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final void BuyShopItem(int id) {
        try {
            Load();
            rs.BuyShopItem(id);
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final void SellShopItem(int id) {
        try {
            Load();
            rs.SellShopItem(id);
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final int ShopBuyPrice(int id) {
        Load();
        return rs.ShopBuyPrice(id);
    }

    public final int ShopSellPrice(int id) {
        Load();
        return rs.ShopSellPrice(id);
    }

    public final int CountShop(int id) {
        Load();
        return rs.ShopCount(id);
    }
    
    /** Status Functions **/
    public final int GetArmourStats(int i) {
        Load();
        return rs.ebb[i];
    }

    public final boolean CanLogOut() {
        Load();
        return rs.eda <= 0;
    }

    public final boolean Sleeping() {
        Load();
        return rs.Sleeping;
    }

    public final void SetMode(int i) {
        Load();
        rs.SetMode(i);
    }

    public final int GetMode() {
        Load();
        return rs.FightMode;
    }

    public final int GetFatigue() {
        Load();
        return (rs.FatigueVar * 100) / 750;
    }

    public final long GetExp(int i) {
        Load();
        return rs.StatTotalExpVar[i] / 4;
    }

    public final long GetExpForNextLvl(int i) {
        Load();
        return rs.getExpForNextLvl(i) - GetExp(i);
    }

    public final String GetLvlName(int i) {
        return rs.StatName[i];
    }

    public final int GetCurLvl(int i) {
        Load();
        return rs.StatCurrentLevel[i];
    }

    public final int GetMaxLvl(int i) {
        Load();
        return rs.StatMaximumLevel[i];
    }

    public final int GetCombatLvl() {
        Load();
        return rs.My.Combat;
    }

    public final int GetX() {
        Load();
        return rs.GetX();
    }

    public final int GetY() {
        Load();
        return rs.GetY();
    }

    public final boolean InCombat() {
        Load();
        return rs.My.Dir == 8 || rs.My.Dir == 9;
    }

    public final boolean HealthBarShowing() {
        Load();
        return rs.My.CombatVar > 0;
    }

    public final int HitsPercent() {
        Load();
        double d = (double) rs.StatCurrentLevel[3] / (double) rs.StatMaximumLevel[3];

        return (int) (d * 100);
    }

    public final boolean IsPrayerOn(int i) {
        Load();
        return rs.PrayerIsOn[i];
    }

    public final void PrayerOn(int i) {
        Load();
        rs.PrayerOn(i, true);
    }

    public final void PrayerOff(int i) {
        Load();
        rs.PrayerOn(i, false);
    }

    public final int PrayerLvl(int i) {
        Load();
        return Ident.PrayerLevel[i];
    }

    public final boolean QuestDone(int i) {
        Load();
        return rs.QuestComplete[i];
    }

    public final void ForceStatMenu(boolean show) {
        Load();
        rs.ShowStatMenu = show;
    }

    public final boolean IsWalking() {
        Load();
        return (rs.My.PathIndex + 1) % 10 != rs.My.gmn;
    }

    public final boolean FightingPlayerInWild() {
        Load();
        return rs.FightInWild();
    }

    public final boolean InWild() {
        Load();
        return rs.InWild();
    }

    public final int WildLvl() {
        Load();
        return rs.WildLvl();
    }
    
    /** Inventory Functions **/
    public final int CountInv() {
        Load();
        return rs.InvCount;
    }

    public final int CountInv(int id) {
        Load();
        return rs.InvAmount(id);
    }

    public final int CountInv(int[] id) {
        int Count = 0;

        for (int x = 0; x < id.length; x++) {
            Load();
            Count += CountInv(id[x]);
        }
        return Count;
    }

    public final boolean InInv(int id) {
        Load();
        for (int x = 0; x < rs.InvCount; x++) {
            if (rs.InvItemId[x] == id) {
                return true;
            }
        }
        return false;
    }

    public final int GetItemPos(int id) {
        Load();
        return rs.GetItemPos(id);
    }

    public final void UseItem(int pos) {
        try {
            Load();
            rs.UseItem(pos, true);
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final void UseItem2(int pos) {
        try {
            Load();
            rs.UseItem(pos, false);
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final void UseItemWithItem(int pos1, int pos2) {
        try {
            Load();
            rs.UseItemWithItem(pos1, pos2);
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final void DropItem(int pos) {
        try {
            Load();
            rs.Drop(pos);
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final boolean IsItemWearable(int id) {
        Load();
        return Ident.ItemWearableVar[id] != 0;
    }

    public final boolean WearingItem(int pos) {
        Load();
        return rs.WearingVar[pos] == 1;
    }

    public final void WearItem(int pos) {
        try {
            Load();
            rs.WearItem(pos, true);
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final void RemoveItem(int pos) {
        try {
            Load();
            rs.WearItem(pos, false);
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final boolean CanEat(int id) {
        Load();
        return Ident.ItemAction[id].equalsIgnoreCase("eat");
    }

    public final void UseItemOnGItem(int pos, int x, int y, int id) {
        try {
            Load();
            rs.UseItemOnGItem(pos, x, y, id);
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final int InvItemId(int pos) {
        try {
            Load();
            return rs.InvItemId[pos];
        } catch (Exception error) {
            rs.ShowCmd(error);
            return -1;
        }
    }
    
    /** Movement Functions **/
    public final void WalkTo(int x, int y) {
        try {
            Load();
            rs.WalkTo(x, y);
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final void WalkToWait(int x, int y) {
        try {
            Load();
            rs.WalkToWait(x, y);
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final void ForceWalkTo(int x, int y) {
        try {
            Load();
            rs.ForceWalkTo(x, y);
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final void ForceWalkToWait(int x, int y) {
        try {
            Load();
            rs.ForceWalkToWait(x, y);
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final boolean IsReachable(int x, int y) {
        try {
            Load();
            return rs.IsReachable(x, y);
        } catch (Exception error) {
            rs.ShowCmd(error);
            return false;
        }
    }
    
    /** Wall Object Functions **/
    public final int CountWallObjects() {
        Load();
        return rs.WallObjectCount;
    }

    public final int[] GetWallObjectById(int id) {
        Load();
        return rs.GetWallObjectById(id);
    }

    public final int[] GetWallObjectById(int[] id) {
        Load();
        return rs.GetWallObjectById(id);
    }

    public final void AtWallObject(int x, int y) {
        try {
            Load();
            rs.AtWallObject(x, y, true);
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final void AtWallObject2(int x, int y) {
        try {
            Load();
            rs.AtWallObject(x, y, false);
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final int GetIdWallObject(int x, int y) {
        try {
            Load();
            return rs.GetIdWallObject(x, y);
        } catch (Exception error) {
            rs.ShowCmd(error);
            return -1;
        }
    }

    public final void UseOnWallObject(int pos, int x, int y) {
        try {
            Load();
            rs.UseOnWallObject(pos, x, y);
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final int WallObjectX(int index) {
        try {
            Load();
            return rs.WallObjectX[index] + rs.TileX;
        } catch (Exception error) {
            rs.ShowCmd(error);
            return -1;
        }
    }

    public final int WallObjectY(int index) {
        try {
            Load();
            return rs.WallObjectY[index] + rs.TileY;
        } catch (Exception error) {
            rs.ShowCmd(error);
            return -1;
        }
    }

    public final int WallObjectId(int index) {
        try {
            Load();
            return rs.WallObjectId[index];
        } catch (Exception error) {
            rs.ShowCmd(error);
            return -1;
        }
    }

    public final String WallObjectName(int id) {
        return Ident.WallObjectName[id];
    }

    public final String WallObjectDesc(int id) {
        return Ident.WallObjectDescription[id];
    }
    
    /** Item Functions **/
    public final int CountItems() {
        Load();
        return rs.ItemCount;
    }

    public final String ItemName(int id) {
        return Ident.ItemName[id];
    }

    public final String ItemDesc(int id) {
        return Ident.ItemDescription[id];
    }

    public final int[] GetItemById(int id) {
        Load();
        return rs.GetItemById(id);
    }

    public final int[] GetItemById(int[] id) {
        Load();
        return rs.GetItemById(id);
    }

    public final void PickupItem(int x, int y) {
        try {
            Load();
            rs.PickUp(x, y);
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final void PickupItem(int x, int y, int id) {
        try {
            Load();
            rs.PickUp(x, y, id);
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final void PickupItemById(int id) {
        try {
            Load();
            rs.PickUpById(id);
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final void PickupItemById(int[] id) {
        try {
            Load();
            rs.PickUpById(id);
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final boolean ItemStackable(int id) {
        try {
            Load();
            return Ident.ItemStackableVar[id] != 1;
        } catch (Exception error) {
            rs.ShowCmd(error);
            return false;
        }
    }

    public final int ItemX(int index) {
        try {
            Load();
            return rs.ItemX[index] + rs.TileX;
        } catch (Exception error) {
            rs.ShowCmd(error);
            return -1;
        }
    }

    public final int ItemY(int index) {
        try {
            Load();
            return rs.ItemY[index] + rs.TileY;
        } catch (Exception error) {
            rs.ShowCmd(error);
            return -1;
        }
    }

    public final int ItemId(int index) {
        try {
            Load();
            return rs.ItemId[index];
        } catch (Exception error) {
            rs.ShowCmd(error);
            return -1;
        }
    }

    public final boolean IsItemAt(int x, int y, int id) {
        try {
            Load();
            for (int c = 0; c < CountItems(); c++) {
                if (ItemX(c) == x && ItemY(c) == y && ItemId(c) == id) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    
    /** Object Functions **/
    public final int CountObjects() {
        Load();
        return rs.ObjectCount;
    }

    public final int[] GetObjectById(int id) {
        Load();
        return rs.GetObjectById(id);
    }

    public final int[] GetObjectById(int[] id) {
        Load();
        return rs.GetObjectById(id);
    }

    public final void AtObject(int x, int y) {
        try {
            Load();
            rs.AtObject(x, y, true);
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final void AtObject2(int x, int y) {
        try {
            Load();
            rs.AtObject(x, y, false);
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final void UseOnObject(int pos, int x, int y) {
        try {
            Load();
            rs.UseOnObject(pos, x, y);
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final int GetIdObject(int x, int y) {
        try {
            Load();
            return rs.GetIdObject(x, y);
        } catch (Exception error) {
            rs.ShowCmd(error);
            return -1;
        }
    }

    public final int ObjectX(int index) {
        try {
            Load();
            return rs.ObjectX[index] + rs.TileX;
        } catch (Exception error) {
            rs.ShowCmd(error);
            return -1;
        }
    }

    public final int ObjectY(int index) {
        try {
            Load();
            return rs.ObjectY[index] + rs.TileY;
        } catch (Exception error) {
            rs.ShowCmd(error);
            return -1;
        }
    }

    public final int ObjectId(int index) {
        try {
            Load();
            return rs.ObjectId[index];
        } catch (Exception error) {
            rs.ShowCmd(error);
            return -1;
        }
    }

    public final String ObjectName(int id) {
        return Ident.ObjectName[id];
    }

    public final String ObjectDesc(int id) {
        return Ident.ObjectDescription[id];
    }

    public final boolean IsObjectAt(int id, int x, int y) {
        try {
            Load();
            for (int c = 0; c < CountObjects(); c++) {
                if (id == ObjectId(c) && ObjectX(c) == x && ObjectY(c) == y) {
                    return true;
                }
            }
            return false;
        } catch (Exception error) {
            rs.ShowCmd(error);
            return false;
        }
    }

    public final boolean IsObjectAt(int[] id, int x, int y) {
        try {
            Load();
            for (int c = 0; c < CountObjects(); c++) {
                if (InArray(id, ObjectId(c)) && ObjectX(c) == x && ObjectY(c) == y) {
                    return true;
                }
            }
            return false;
        } catch (Exception error) {
            rs.ShowCmd(error);
            return false;
        }
    }

    /** Setup Functions **/
    public final void SetGfx(boolean on) {
        Load();
        rs.ShowGfx = on;
    }

    public final boolean IsSpecial() {
        return true;
    }

    public final boolean IsScanningForMods() {
        return ModScanThread != null;
    }

    public final void StopScanForMods() {
        if (!IsScanningForMods()) {
            return;
        }
        ModScanThread.stop();
        ModScanThread = null;
        Display("Scanning for mods has finished");
    }

    public final boolean IsPopup() {
        Load();
        return rs.ShowingPopup;
    }

    public final void ClosePopup() {
        Load();
        rs.ShowingPopup = false;
    }

    public final void ShowMessage(String message) {
        try {
            Load();
            rs.ShowMessage(message);
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }
    ;
    public final String GetInput(String message) {
        try {
            Load();
            return rs.GetIn(message);
        } catch (Exception error) {
            rs.ShowCmd(error);
            return null;
        }
    }

    public final int GetOption(String header, String[] options) {
        try {
            Load();
            return rs.MenuChoice(header, options);
        } catch (Exception error) {
            rs.ShowCmd(error);
            return -1;
        }
    }

    public final String GetAuthName() {
        return mudclient.replace(mudclient.AuthName, "%20", " ");
    }

    public final String GetRsName() {
        return rs.Username;
    }

    public final int DistanceTo(int x, int y) {
        return rs.DistanceTo(x, y, GetX(), GetY());
    }

    public final int DistanceTo(int x1, int y1, int x2, int y2) {
        return rs.DistanceTo(x1, y1, x2, y2);
    }

    public final void UnlockMode() {
        rs.Locked = -1;
    }

    public final void LockMode(int i) {
        try {
            Load();
            if (i >= 0 && i < 4) {
                rs.Locked = i;
            } else {
                throw new Exception("invalid fightmode");
            }
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final void ChatFilterOn(boolean on) {
        u.ChatFilter = on;
    }

    public final void End(String s) {
        Display(s);
        StopScanForMods();
        rs.StopMacro();
    }

    public final void End() {
        StopScanForMods();
        rs.StopMacro();
    }

    public final void Die(String s) {
        Display(s);
        System.exit(1);
    }

    public final void Die() {
        System.exit(1);
    }

    public final void Display(String s) {
        rs.ShowCmd(s);
    }

    public final void Display(int i) {
        rs.ShowCmd(String.valueOf(i));
    }

    public final boolean Loading() {
        return rs.load || rs.LoggedInVar == 0;
    }

    public final int Rand(int low, int high) {
        return low + r.nextInt(high - low);
    }

    public final boolean Running() {
        return rs.run;
    }

    public final void Wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final long GetMillis() {
        return System.currentTimeMillis();
    }

    public final String Time() {
        return rs.Time();
    }

    public final void SaveScreenShot(String s) {
        try {
            File file = new File(System.getProperty("user.dir") + "/" + s);

            rs.ScreenShot(file);
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }

    public final String IntToStr(int i) {
        try {
            return String.valueOf(i);
        } catch (Exception error) {
            rs.ShowCmd(error);
            return null;
        }
    }

    public final String IntToStr(long i) {
        try {
            return String.valueOf(i);
        } catch (Exception error) {
            rs.ShowCmd(error);
            return null;
        }
    }

    public final int StrToInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (Exception error) {
            rs.ShowCmd(error);
            return -1;
        }
    }

    public final int[] StrToInt(String[] s) {
        try {
            int[] t = new int[s.length];

            for (int x = 0; x < s.length; x++) {
                t[x] = Integer.parseInt(s[x]);
            }
            return t;
        } catch (Exception e) {
            return new int[0];
        }
    }

    public final boolean IsInStr(String string, String findme) {
        return rs.IsInStr(string, findme);
    }

    public final boolean InArray(String sarray[], String s) {
        return rs.InArray(sarray, s);
    }

    public final boolean InArray(int iarray[], int i) {
        return rs.InArray(iarray, i);
    }

    public final String Replace(String string, String toreplace, String replacewith) {
        return mudclient.replace(string, toreplace, replacewith);
    }

    public final int GetAverage(int[] values) {
        return rs.getAverage(values);
    }

    public final boolean InArea(int x, int y, int x1, int y1, int x2, int y2) {
        return x >= x1 && x <= x2 && y >= y1 && y <= y2;
    }

    public final void PlaySound(String path) {
        Load();
        try {
            java.applet.Applet.newAudioClip(new java.net.URL("file:" + path)).play();
        } catch (Exception e) {}
    }
    ;
    
    /** Other Functions **/
    public final void FixSleeping(boolean fix) {
        rs.FixSleeping = fix;
    }

    public final void Load() {
        try {
            while (rs.load || rs.LoggedInVar == 0) {
                Wait(100);
            }
        } catch (Exception error) {
            rs.ShowCmd(error);
        }
    }
}
