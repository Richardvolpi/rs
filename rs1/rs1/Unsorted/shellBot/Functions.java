import java.util.*;
import java.text.*;
import java.io.*;

public class Functions {

    private static final Random r = new Random();
    private static final BufferedReader keysIn = new BufferedReader(new InputStreamReader(System.in)); 
    private static final SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
    private static final String[] statName = {"Attack", "Defence", "Strength", "Hits", "Ranged", "Prayer", "Magic", "Cooking", "Woodcut", "Fletching", "Fishing", "Firemaking", "Crafting", "Smithing", "Mining", "Herblaw", "Agility", "Thieving"};
    public Shell sh;

    /** Methods **/
    public final boolean SleepIfAt(int Fatigue){if(GetFatigue() >= Fatigue) {while(InCombat())Wait(100);while(!Sleeping()) {if(!InInv(1263))return false;UseItem(GetItemPos(1263)); Wait(3000); } while(Sleeping()) Wait(100); }return true;}
    
    /** Server Functions **/
    public final boolean ChangeWorld(int i) {if(i < 85 || i > 90) return false;sh.server = i;return true;}
    public final int GetWorld() {return sh.server;}
    public final boolean MembersWorld() {return sh.server % 2 == 0;}
    public final boolean LoggedIn() {return sh.loggedIn;}
    public final void LogOut() {sh.Connection.sendID(ID.LOGOUT);sh.Connection.endPacket();Display("Logging out...");}
    public final void HopServer(boolean skip) {int myWorld = GetWorld() + (skip ? 2 : 1);if(myWorld > 90) myWorld -= 6;ChangeWorld(myWorld);sh.autoLogin = false;Wait(2000);while(LoggedIn()) {LogOut();Wait(Rand(2000,3000));}sh.autoLogin = true;while(!LoggedIn())Wait(3000);Wait(Rand(4000,6000));}
    
    /** Npc Functions **/
    public final int CountNpcs() {Load(); return sh.npcCount;}
    public final int[] GetNpcById(int id) {return GetNpcById(new int[]{id});}
    public final int[] GetNpcById(int[] id) {Load();int minReturn[] = {-1,-1,-1};int minDist = Integer.MAX_VALUE;for(int c = 0; c < sh.npcCount; c++)if(InArray(id,sh.npc[c].ID) && !NpcInCombat(c)) {int ItmX = ((sh.npc[c].xCoord - 64) / 128) + sh.tileX;int ItmY = ((sh.npc[c].yCoord - 64) / 128) + sh.tileY;int tempDist = DistanceTo(ItmX,ItmY);if(tempDist < minDist) {minReturn[0] = c;minReturn[1] = ItmX;minReturn[2] = ItmY;minDist = tempDist;}}return minReturn;}
    public final int[] GetAllNpcById(int id) {return GetAllNpcById(new int[]{id});}
    public final int[] GetAllNpcById(int[] id) {Load();int minReturn[] = {-1,-1,-1};int minDist = Integer.MAX_VALUE;for(int c = 0; c < sh.npcCount; c++)if(InArray(id,sh.npc[c].ID)) {int ItmX = ((sh.npc[c].xCoord - 64) / 128) + sh.tileX;int ItmY = ((sh.npc[c].yCoord - 64) / 128) + sh.tileY;int tempDist = DistanceTo(ItmX,ItmY);if(tempDist < minDist) {minReturn[0] = c;minReturn[1] = ItmX;minReturn[2] = ItmY;minDist = tempDist;}}return minReturn;}
    public final int[] GetNpcByIdNotTalk(int id) {return GetNpcByIdNotTalk(new int[]{id});}
    public final int[] GetNpcByIdNotTalk(int[] id) {Load();int minReturn[] = {-1,-1,-1};int minDist = Integer.MAX_VALUE;for(int c = 0; c < sh.npcCount; c++)if(InArray(id,sh.npc[c].ID) && !IsNpcTalking(c)) {int ItmX = ((sh.npc[c].xCoord - 64) / 128) + sh.tileX;int ItmY = ((sh.npc[c].yCoord - 64) / 128) + sh.tileY;int tempDist = DistanceTo(ItmX,ItmY);if(tempDist < minDist) {minReturn[0] = c;minReturn[1] = ItmX;minReturn[2] = ItmY;minDist = tempDist;}}return minReturn;}
    public final static boolean NpcAttackable(int id) {return Ident.NpcAttackableVar[id] > 0;}
    public final boolean NpcInCombat(int index) {Load(); return sh.npc[index].Dir == 8 || sh.npc[index].Dir == 9;}
    public final boolean NpcHealthBarShowing(int index) {Load(); return sh.npc[index].combatVar > 0; }
    public final static String NpcName(int id) {return Ident.NpcName[id];}
    public final static String NpcDesc(int id) {return Ident.NpcDescription[id];}
    public final static int NpcMaxHits(int id) {return Ident.NpcHitsLevel[id];}
    public final static int NpcCombat(int id) {return (Ident.NpcAttackLevel[id] + Ident.NpcDefenceLevel[id] + Ident.NpcStrengthLevel[id] + Ident.NpcHitsLevel[id]) / 4;}
    public final void AttackNpc(int index) {if(index < 0 || index > sh.npcCount){Debug("Invalid 'npcIndex'");return;}Load();sh.moveTo(sh.locX, sh.locY, (sh.npc[index].xCoord - 64) / 128, (sh.npc[index].yCoord - 64) / 128, (sh.npc[index].xCoord - 64) / 128, (sh.npc[index].yCoord - 64) / 128, false, true);sh.Connection.sendID(ID.ATTACKNPC);sh.Connection.sendInt(sh.npc[index].pID);sh.Connection.endPacket();}
    public final void TalkToNpc(int index) {if(index < 0 || index > sh.npcCount){Debug("Invalid 'npcIndex'");return;}Load();sh.moveTo(sh.locX, sh.locY, (sh.npc[index].xCoord - 64) / 128, (sh.npc[index].yCoord - 64) / 128, (sh.npc[index].xCoord - 64) / 128, (sh.npc[index].yCoord - 64) / 128, false, true);sh.Connection.sendID(ID.TALKTONPC);sh.Connection.sendInt(sh.npc[index].pID);sh.Connection.endPacket();}
    public final void ThieveNpc(int index) {if(index < 0 || index > sh.npcCount){Debug("Invalid 'npcIndex'");return;}Load();sh.moveTo(sh.locX, sh.locY, (sh.npc[index].xCoord - 64) / 128, (sh.npc[index].yCoord - 64) / 128, (sh.npc[index].xCoord - 64) / 128, (sh.npc[index].yCoord - 64) / 128, false, true);sh.Connection.sendID(ID.THIEVENPC);sh.Connection.sendInt(sh.npc[index].pID);sh.Connection.endPacket();}
    public final int NpcId(int index) {Load(); if(index < 0 || index > sh.npcCount){Debug("Invalid 'npcIndex'");return -1;}return sh.npc[index].ID;}
    public final int NpcX(int index) {Load(); if(index < 0 || index > sh.npcCount){Debug("Invalid 'npcIndex'");return -1;}return ((sh.npc[index].xCoord - 64) / 128) + sh.tileX;}
    public final int NpcY(int index) {Load(); if(index < 0 || index > sh.npcCount){Debug("Invalid 'npcIndex'");return -1;}return ((sh.npc[index].yCoord - 64) / 128) + sh.tileY;}
    public final void UseOnNpc(int pos, int index){if(pos < 0 || pos > 29 || index < 0 || index > sh.npcCount) {Debug("Invalid 'pos' or 'npcIndex'");return;}sh.moveTo(sh.locX, sh.locY, (sh.npc[index].xCoord - 64) / 128, (sh.npc[index].yCoord - 64) / 128, (sh.npc[index].xCoord - 64) / 128, (sh.npc[index].yCoord - 64) / 128, false, true);sh.Connection.sendID(ID.USEONNPC);sh.Connection.sendInt(sh.npc[index].pID);sh.Connection.sendInt(pos);sh.Connection.endPacket();}
    
    /** Player Functions **/
    public final int[] GetPlayerByName(String name) {Load();for(int c = 0; c < sh.playerCount; c++) {if(sh.player[c].name.equalsIgnoreCase(name))return new int[]{c,((sh.player[c].xCoord - 64) / 128) + sh.tileX,((sh.player[c].yCoord - 64) / 128) + sh.tileY};}return new int[]{-1,-1,-1};}
    public final int CountPlayers() {Load(); return sh.playerCount;}
    public final int PlayerX(int index) {Load(); if(index < 0 || index > sh.playerCount){Debug("Invalid 'playerIndex'");return -1;} return ((sh.player[index].xCoord - 64) / 128) + sh.tileX;}
    public final int PlayerY(int index) {Load(); if(index < 0 || index > sh.playerCount){Debug("Invalid 'playerIndex'");return -1;} return ((sh.player[index].yCoord - 64) / 128) + sh.tileY;}
    public final String PlayerName(int index) {Load(); if(index < 0 || index > sh.playerCount){Debug("Invalid 'playerIndex'");return null;} return sh.player[index].name;}
    public final void TradePlayer(int index) {if(index < 0 || index > sh.playerCount) {Debug("Invalid 'playerIndex'");return;}Load();sh.Connection.sendID(ID.TRADEPLAYER);sh.Connection.sendInt(sh.player[index].pID);sh.Connection.endPacket();}
    public final boolean InTradeScreen1() {Load(); return sh.tradeScreen1;}
    public final boolean InTradeScreen2() {Load(); return sh.tradeScreen2;}
    public final void AcceptTrade1() {Load();sh.myTradeAccepted1 = true;sh.Connection.sendID(ID.ACCEPTTRADE1);sh.Connection.endPacket();}
    public final void AcceptTrade2() {Load();sh.myTradeAccepted2 = true;sh.Connection.sendID(ID.ACCEPTTRADE2);sh.Connection.endPacket();}
    public final boolean MyTrade1Accepted() {Load(); return sh.myTradeAccepted1;}
    public final boolean MyTrade2Accepted() {Load(); return sh.myTradeAccepted2;}
    public final boolean OpponentTradeAccepted() {Load(); return sh.opponentTradeAccepted;}
    public final void DeclineTrade() {Load();sh.tradeScreen1 = sh.tradeScreen2 = false;sh.Connection.sendID(ID.DECLINETRADE);sh.Connection.endPacket();}
    public final void OfferItems(int items[], int amount[]) {notUsed("OfferItems(int[] items, int[] amount) - To lazy to add, coming soon");}
    public final void AddToOffer(int item, int amount) {notUsed("AddToOffer(int item, int amount) - To lazy to add, coming soon");}
    public final int[] GetOpponentTradeItems() {Load();if(!InTradeScreen1() && !InTradeScreen2()) return new int[0];int tradeCount = sh.opponentTradeIndex;int[] array = new int[tradeCount];for(int c = 0;c < tradeCount;c++)array[c] = sh.opponentTradeItemID[c];return array;}
    public final int[] GetOpponentTradeAmounts() {Load();if(!InTradeScreen1() && !InTradeScreen2()) return new int[0];int tradeCount = sh.opponentTradeIndex;int[] array = new int[tradeCount];for(int c = 0;c < tradeCount;c++)array[c] = sh.opponentTradeItemAmount[c];return array;}
    public final boolean IsOffered(int id, int amount) {notUsed("IsOffered(int id, int amount) - To lazy to add, coming soon");return false;}
    public final String GetTradeOpponentName() {Load(); return sh.tradeOpponentName;}
    
    /** Communication Functions **/
    public final void Speak(String message) {Load();Debug("Sending Chat message");int messageVar = Convert.cek(message);sh.Connection.sendID(ID.SPEAK);sh.Connection.sendBytes(Convert.ceg, 0, messageVar);sh.Connection.endPacket();}
    public final void SendPM(String sendTo, String message) {Load();if(!IsOnFriendList(sendTo)) {Debug("Cannot send PM to player no on friend list");return;}Debug("Sending PM to '" + sendTo + "'.");int messageVar = Convert.cek(message);sh.Connection.sendID(ID.SENDPM);sh.Connection.sendLong(Convert.PlayerNameToLong(sendTo));sh.Connection.sendBytes(Convert.ceg, 0, messageVar);sh.Connection.endPacket();Display("You tell " + sendTo + ": " + message);}
    public final void AddToFriends(String player) {Load();if(IsOnFriendList(player)){Debug("Friend already added");return;}sh.Connection.sendID(ID.ADDFRIEND);sh.Connection.sendLong(Convert.PlayerNameToLong(player));sh.Connection.endPacket();if(sh.friendCount < sh.friendList.length){sh.friendList[sh.friendCount] = player;sh.friendServer[sh.friendCount] = 0;sh.friendCount++;}}
    public final String[] GetFriendList() {try{String[] Friends = new String[sh.friendCount];for(int c = 0;c < Friends.length;c++){Load();Friends[c] = sh.friendList[c];}return Friends;}catch(Exception e){return new String[0];}}
    public final void RemoveFromFriends(String player) {sh.Connection.sendID(ID.REMOVEFRIEND);sh.Connection.sendLong(Convert.PlayerNameToLong(player));sh.Connection.endPacket();for(int c = 0; c < sh.friendCount; c++){if(!sh.friendList[c].equalsIgnoreCase(player))continue;sh.friendCount--;for(int c1 = c; c1 < sh.friendCount; c1++){sh.friendList[c1] = sh.friendList[c1 + 1];sh.friendServer[c1] = sh.friendServer[c1 + 1];}break;}}
    public final boolean IsOnFriendList(String player) {Load();for(int c = 0;c < sh.friendCount;c++)if(sh.friendList[c].equalsIgnoreCase(player))return true;return false;}

    /** Spell Functions **/
    public final static String SpellName(int spell) {return Ident.SpellName[spell];}
    public final static boolean IsCastableOnNpc(int spell) {return Ident.SpellStatus[spell] == 2;}
    public final void CastOnNpc(int spell, int index) {Load();sh.moveTo(sh.locX, sh.locY, NpcX(index) - sh.tileX, NpcY(index) - sh.tileY, NpcX(index) - sh.tileX, NpcY(index) - sh.tileY, true, false);sh.Connection.sendID(ID.CASTONNPC);sh.Connection.sendInt(sh.npc[index].pID);sh.Connection.sendInt(spell);sh.Connection.endPacket();}
    public final static boolean IsCastableOnItem(int spell) {return Ident.SpellStatus[spell] == 3;}
    public final void CastOnItem(int spell, int pos) {Load();sh.Connection.sendID(ID.CASTONITEM);sh.Connection.sendInt(pos);sh.Connection.sendInt(spell);sh.Connection.endPacket();}
    public final static boolean IsCastableOnGItem(int spell) {return Ident.SpellStatus[spell] == 3;}
    public final void CastOnGItem(int spell, int id, int x, int y) {Load();sh.forceTo(sh.locX, sh.locY, x - sh.tileX, y - sh.tileY, true);sh.Connection.sendID(ID.CASTONGITEM);sh.Connection.sendInt(x);sh.Connection.sendInt(y);sh.Connection.sendInt(id);sh.Connection.sendInt(spell);sh.Connection.endPacket();}
    public final static boolean IsCastableOnSelf(int spell) {return Ident.SpellStatus[spell] < 2;}
    public final void CastOnSelf(int spell) {Load();sh.Connection.sendID(ID.CASTONSELF);sh.Connection.sendInt(spell);sh.Connection.endPacket();}
    public final static boolean IsCastableOnGround(int spell) {return Ident.SpellStatus[spell] == 6;}
    public final void CastOnGround(int spell) {Load();sh.moveTo(sh.locX, sh.locY, sh.locX, sh.locY, sh.locX, sh.locY, true, false);sh.Connection.sendID(ID.CASTONGROUND);sh.Connection.sendInt(GetX());sh.Connection.sendInt(GetY());sh.Connection.sendInt(spell);sh.Connection.endPacket();}
    public final static boolean IsCastableOnWallObject(int spell) {return Ident.SpellStatus[spell] == 4;}
    public final void CastOnWallObject(int spell, int x, int y) {Load();int i = sh.getWallObjectIndex(x,y);if(i < 0) {Debug("Invalid 'wallIndex'");return;}sh.moveToWall(sh.wallObjectX[i], sh.wallObjectY[i], sh.wallObjectDir[i]);sh.Connection.sendID(ID.CASTONWALL);sh.Connection.sendInt(sh.wallObjectX[i] + sh.tileX);sh.Connection.sendInt(sh.wallObjectY[i] + sh.tileY);sh.Connection.SendVar(sh.wallObjectDir[i]);sh.Connection.sendInt(spell);sh.Connection.endPacket();}
    public final static boolean IsCastableOnObject(int spell) {return Ident.SpellStatus[spell] == 5;}
    public final void CastOnObject(int spell, int x, int y) {Load();int i = sh.getObjectIndex(x,y);if(i < 0){Debug("Invalid 'objectIndex'");return;}sh.moveNextTo(sh.objectX[i], sh.objectY[i], sh.objectDir[i], sh.objectID[i]);sh.Connection.sendID(ID.CASTONOBJECT);sh.Connection.sendInt(sh.objectX[i] + sh.tileX);sh.Connection.sendInt(sh.objectY[i] + sh.tileY);sh.Connection.sendInt(spell);sh.Connection.endPacket();}
    public final boolean HasRunesForSpell(int spell) {Load();for(int c = 0; c < Ident.SpellRuneCount[spell]; c++)if(!HasRunes(Ident.SpellRuneID[spell][c], Ident.SpellRuneAmount[spell][c]))return false;return true;}
    public final boolean HasRunes(int RuneID, int AmountNeeded){if(RuneID == 31 && (WearingItem(197) || WearingItem(615) || WearingItem(682)))return true;if(RuneID == 32 && (WearingItem(102) || WearingItem(616) || WearingItem(683)))return true;if(RuneID == 33 && (WearingItem(101) || WearingItem(617) || WearingItem(684)))return true;if(RuneID == 34 && (WearingItem(103) || WearingItem(618) || WearingItem(685)))return true;return CountInv(RuneID) >= AmountNeeded;}
    
    /** Npc Interaction Functions **/
    public final boolean QuestMenu() {Load(); return sh.questMenu;}
    public final int CountQuestMenu() {Load(); if(!sh.questMenu) return -1;return sh.questMenuCount;}
    public final String GetQuestOption(int i) {Load(); if(i < 0 || i > sh.questMenuCount || !sh.questMenu) {Debug("Invalid 'questIndex'");return null;}return sh.questMenuOptions[i];}
    public final void Answer(int toChoose) {Load();if(!sh.questMenu) {Debug("There is no questMenu open to answer");return;}Debug("Answering Quest menu with choice #" + toChoose + ".");sh.Connection.sendID(ID.ANSWER);sh.Connection.SendVar(toChoose);sh.Connection.endPacket();sh.questMenu = false;}
    public final boolean IsNpcTalking(int index) {Load(); if(index < 0 || index > sh.npcCount){Debug("Invalid 'npcIndex'");return false;} return sh.npc[index].talkVar > 0;}
    
    /** Bank & Shop Functions **/
    public final void Withdraw(int id, int amount) {Load();if(!InBank()) {Debug("Not in bank");return;}if(amount > 30000)amount = 30000;sh.Connection.sendID(ID.WITHDRAW);sh.Connection.sendInt(id);sh.Connection.sendInt(amount);sh.Connection.sendInt1(0x12345678);sh.Connection.endPacket();}
    public final void Deposit(int id, int amount) {Load();if(!InBank()) {Debug("Not in bank");return;}if(amount > 30000)amount = 30000;sh.Connection.sendID(ID.DEPOSIT);sh.Connection.sendInt(id);sh.Connection.sendInt(amount);sh.Connection.sendInt1(0x87654321);sh.Connection.endPacket();}
    public final boolean ItemInBank(int id) {Load(); if(!InBank()) {Debug("Not in bank");return false;}for(int c = 0; c < sh.bankCount; c++) if(sh.bankItemID[c] == id) return true; return false;}
    public final int CountInBank(int id) {Load(); if(!InBank()) {Debug("Not in bank");return -1;}for(int c = 0; c < sh.bankCount; c++) if(sh.bankItemID[c] == id) return sh.bankItemCount[c]; return 0;}
    public final boolean InBank() {Load(); return sh.inBank;}
    public final void CloseBank() {Load();sh.Connection.sendID(ID.CLOSEBANK);sh.Connection.endPacket();sh.inBank = false;}
    public final boolean InShop() {Load(); return sh.inShop;}
    public final void CloseShop() {Load();sh.Connection.sendID(ID.CLOSESHOP);sh.Connection.endPacket();sh.inShop = false;}
    public final void BuyShopItem(int id) {Load();sh.Connection.sendID(ID.BUYITEM);sh.Connection.sendInt(id);sh.Connection.sendInt1(ShopBuyPrice(id));sh.Connection.endPacket();}
    public final void SellShopItem(int id) {Load();sh.Connection.sendID(ID.SELLITEM);sh.Connection.sendInt(id);sh.Connection.sendInt1(ShopSellPrice(id));sh.Connection.endPacket();}
    public final int ShopBuyPrice(int id) {Load();int i = sh.findShopItem(id);int val = sh.shopBuyVar + sh.shopItemPrice[i];if(val < 10)val = 10;return (val * Ident.ItemValue[sh.shopItemID[i]]) / 100;}
    public final int ShopSellPrice(int id) {Load();int i = sh.findShopItem(id);int val = sh.shopSellVar + sh.shopItemPrice[i];if(val < 10)val = 10;return (val * Ident.ItemValue[sh.shopItemID[i]]) / 100;}
    public final int CountShop(int id) {Load();int i = sh.findShopItem(id);if(i == -1)return 0;return sh.shopItemCount[i];}
    
    /** Status Functions **/
    public final boolean Sleeping() {Load(); return sh.sleeping;}
    public final void SetMode(int fightMode) {if(fightMode < 0 || fightMode > 3) { Debug("Invalid fightMode chosen"); return; } sh.macro.lockedMode = fightMode; Debug("Locked fightMode to " + fightMode);}
    public final int GetMode() {Load(); return sh.fightMode;}
    public final int GetFatigue() {Load(); return sh.fatigue;}
    public final long GetExp(int i) {if(i < 0 || i > 17) {Debug("Invalid 'statIndex'");return -1;}Load(); return sh.statTotalExp[i];}
    public final String GetLvlName(int i) {if(i < 0 || i > 17) {Debug("Invalid 'statIndex'");return null;}return statName[i];}
    public final int GetCurLvl(int i) {if(i < 0 || i > 17) {Debug("Invalid 'statIndex'");return -1;}Load(); return sh.statCurLevel[i];}
    public final int GetMaxLvl(int i) {if(i < 0 || i > 17) {Debug("Invalid 'statIndex'");return -1;}Load(); return sh.statMaxLevel[i];}
    public final int GetCombatLvl() {Load(); return sh.my.combat;}
    public final int GetX() {Load();return sh.locX + sh.tileX;}
    public final int GetY() {Load();return sh.locY + sh.tileY;}
    public final boolean InCombat() {Load(); return sh.my.Dir == 8 || sh.my.Dir == 9;}
    public final boolean HealthBarShowing() {Load(); return sh.my.combatVar > 0; }
    public final int HitsPercent() {Load(); double d = (double)GetCurLvl(3) / (double)GetMaxLvl(3); return (int)(d * 100);}
    public final boolean IsPrayerOn(int i) {if(i < 0 || i > 14) {Debug("Invalid 'prayIndex'");return false;}Load(); return sh.prayOn[i];}
    public final void PrayerOn(int i) {Load();sh.Connection.sendID(ID.PRAYON);sh.Connection.SendVar(i);sh.Connection.endPacket();sh.prayOn[i] = true;}
    public final void PrayerOff(int i) {Load();sh.Connection.sendID(ID.PRAYOFF);sh.Connection.SendVar(i);sh.Connection.endPacket();sh.prayOn[i] = false;}
    public final static int PrayerLvl(int i) {return Ident.PrayerLevel[i];}
    public final boolean QuestDone(int i) {if(i < 0 || i > 49) {Debug("Invalid 'questIndex'");return false;}Load(); return sh.questComplete[i];}
    public final boolean IsWalking() {Load(); return (sh.my.pathIndex + 1) % 10 != sh.my.NewpathIndex;}
    public final boolean InWild() {Load(); return WildLvl() < 1;}
    public final int WildLvl() {Load();int lvl = 2203 - (sh.locY + sh.tileYoff + sh.tileY);if(sh.locX + sh.tileXoff + sh.tileX >= 2640)lvl = -50;if(lvl < 1)return 0;return 1 + lvl / 6;}
    
    /** Inventory Functions **/
    public final int CountInv() {Load(); return sh.invCount;}
    public final int CountInv(int id) {Load();int total = 0;for(int c = 0; c < sh.invCount; c++)if(sh.invItemID[c] == id)if(Ident.ItemStackableVar[id] == 1)total++;else total += sh.invItemCount[c];return total;}
    public final int CountInv(int[] id) {int total = 0;for(int c = 0;c < id.length;c++)total += CountInv(id[c]);return total;}
    public final boolean InInv(int id) {Load(); for(int c = 0; c < sh.invCount;c++) if(sh.invItemID[c] == id) return true; return false;}
    public final int GetItemPos(int id) {Load(); for(int c = 0;c < sh.invCount;c++)if(sh.invItemID[c] == id)return c;return -1;}
    public final void UseItem(int itemPos) {Load();if(itemPos < 0 || itemPos >= sh.invCount) {Debug("Invalid item position");return;}sh.Connection.sendID(ID.USEITEM);sh.Connection.sendInt(itemPos);sh.Connection.endPacket();}
    public final void UseItemWithItem(int pos1, int pos2) {Load();if(pos1 < 0 || pos2 < 0 || pos1 >= sh.invCount || pos2 >= sh.invCount) {Debug("Invalid item position");return;}sh.Connection.sendID(ID.USEITEMWITEM);sh.Connection.sendInt(pos1);sh.Connection.sendInt(pos2);sh.Connection.endPacket();}
    public final void DropItem(int pos) {if(pos < 0 || pos > sh.invCount) {Debug("Invalid 'itemIndex'");return;}Load();sh.Connection.sendID(ID.DROP);sh.Connection.sendInt(pos);sh.Connection.endPacket();}
    public final static boolean IsItemWearable(int id) {return Ident.ItemWearableVar[id] != 0;}
    public final boolean WearingItem(int pos) {if(pos < 0 || pos > sh.invCount){Debug("Invalid 'itemIndex'");return false;}Load(); return sh.invItemWearing[pos];}
    public final void WearItem(int pos) {if(pos < 0 || pos > sh.invCount) {Debug("Invalid 'itemIndex'");return;}Load();sh.Connection.sendID(ID.WEAR);sh.Connection.sendInt(pos);sh.Connection.endPacket();}
    public final void RemoveItem(int pos) {if(pos < 0 || pos > sh.invCount) {Debug("Invalid 'itemIndex'");return;}Load();sh.Connection.sendID(ID.REMOVE);sh.Connection.sendInt(pos);sh.Connection.endPacket();}
    public final static boolean CanEat(int id) {return Ident.ItemAction[id].equalsIgnoreCase("eat");}
    public final void UseItemOnGItem(int pos, int x, int y, int id) {if(pos < 0 || pos > sh.invCount) {Debug("Invalid 'itemIndex'");return;}Load();int i = sh.getItemIndex(x,y);if(i < 0){Debug("No item found at (" + x + "," + y + ")");return;}sh.forceTo(sh.locX, sh.locY, sh.itemX[i], sh.itemY[i], true);sh.Connection.sendID(ID.USEITEMGITEM);sh.Connection.sendInt(sh.itemX[i] + sh.tileX);sh.Connection.sendInt(sh.itemY[i] + sh.tileY);sh.Connection.sendInt(id);sh.Connection.sendInt(pos);sh.Connection.endPacket();}
    public final int InvItemId(int pos) {Load();if(pos < 0 || pos > sh.invCount){Debug("Invalid 'invIndex'");return -1;} return sh.invItemID[pos];}
    
    /** Movement Functions **/
    public final void WalkTo(int tX, int tY) {Load();if(!sh.moveTo(sh.locX, sh.locY, tX - sh.tileX, tY - sh.tileY, tX - sh.tileX, tY - sh.tileY, false, false))Debug("(" + tX + "," + tY + ") is not reachable");}
    public final void WalkToWait(int tX, int tY) {do {Load();if(!sh.moveTo(sh.locX, sh.locY, tX - sh.tileX, tY - sh.tileY, tX - sh.tileX, tY - sh.tileY, false, false)) {Debug("(" + tX + "," + tY + ") is not reachable");return;}Wait(Rand(2000,3000));}while(DistanceTo(tX,tY) > 1);}
    public final void ForceWalkTo(int x,int y) {Load();if(!IsReachable(x,y)){Debug("(" + x + "," + y + ") is not reachable");}sh.forceTo(sh.locX, sh.locY, x - sh.tileX, y - sh.tileY, true);sh.Connection.sendID(ID.PICKUP);sh.Connection.sendInt(x);sh.Connection.sendInt(y);sh.Connection.sendInt(0);sh.Connection.sendInt(1289);sh.Connection.endPacket();}
    public final void ForceWalkToWait(int x, int y) {do{ForceWalkTo(x,y);Wait(Rand(2000,3000));}while(DistanceTo(x,y) > 1);}
    public final boolean IsReachable(int tX, int tY) {Load();return sh.isReachable(tX,tY);}
    
    /** Wall Object Functions **/
    public final int CountWallObjects() {Load(); return sh.wallObjectCount;}
    public final int[] GetWallObjectById(int id) {return GetWallObjectById(new int[]{id});}
    public final int[] GetWallObjectById(int[] id) {Load();int minReturn[] = {-1,-1,-1};int minDist = Integer.MAX_VALUE;for(int c = 0; c < sh.wallObjectCount; c++)if(InArray(id,sh.wallObjectID[c])) {int ItmX = sh.wallObjectX[c] + sh.tileX;int ItmY = sh.wallObjectY[c] + sh.tileY;int tempDist = DistanceTo(ItmX,ItmY);if(tempDist < minDist) {minReturn[0] = sh.wallObjectID[c];minReturn[1] = ItmX;minReturn[2] = ItmY;minDist = tempDist;}}return minReturn;}
    public final void AtWallObject(int x,int y) {Load();int i = sh.getWallObjectIndex(x,y);if(i < 0) {Debug("No wall object found at (" + x + "," + y + ")");return;}sh.moveToWall(sh.wallObjectX[i], sh.wallObjectY[i], sh.wallObjectDir[i]);sh.Connection.sendID(ID.ATWALL1);sh.Connection.sendInt(sh.wallObjectX[i] + sh.tileX);sh.Connection.sendInt(sh.wallObjectY[i] + sh.tileY);sh.Connection.SendVar(sh.wallObjectDir[i]);sh.Connection.endPacket();}
    public final void AtWallObject2(int x,int y) {Load();int i = sh.getWallObjectIndex(x,y);if(i < 0) {Debug("No wall object found at (" + x + "," + y + ")");return;}sh.moveToWall(sh.wallObjectX[i], sh.wallObjectY[i], sh.wallObjectDir[i]);sh.Connection.sendID(ID.ATWALL2);sh.Connection.sendInt(sh.wallObjectX[i] + sh.tileX);sh.Connection.sendInt(sh.wallObjectY[i] + sh.tileY);sh.Connection.SendVar(sh.wallObjectDir[i]);sh.Connection.endPacket();}
    public final int GetIdWallObject(int x, int y) {Load();for(int c = 0;c < CountWallObjects();c++)if(WallObjectX(c) == x && WallObjectY(c) == y)return WallObjectId(c);return -1;}
    public final void UseOnWallObject(int pos, int x, int y) {Load();int i = sh.getWallObjectIndex(x,y);if(i < 0) {Debug("No wall object found at (" + x + "," + y + ")");return;}sh.moveToWall(sh.wallObjectX[i], sh.wallObjectY[i], sh.wallObjectDir[i]);sh.Connection.sendID(ID.USEONWALL);sh.Connection.sendInt(sh.wallObjectX[i] + sh.tileX);sh.Connection.sendInt(sh.wallObjectY[i] + sh.tileY);sh.Connection.SendVar(sh.wallObjectDir[i]);sh.Connection.sendInt(pos);sh.Connection.endPacket();}
    public final int WallObjectX(int index){if(index < 0 || index > sh.wallObjectCount) {Debug("Invalid 'wallIndex'");return -1;}Load(); return sh.wallObjectX[index] + sh.tileX;}
    public final int WallObjectY(int index){if(index < 0 || index > sh.wallObjectCount) {Debug("Invalid 'wallIndex'");return -1;}Load(); return sh.wallObjectY[index] + sh.tileY;}
    public final int WallObjectId(int index){if(index < 0 || index > sh.wallObjectCount) {Debug("Invalid 'wallIndex'");return -1;}Load(); return sh.wallObjectID[index];}
    public final static String WallObjectName(int id) {return Ident.WallObjectName[id];}
    public final static String WallObjectDesc(int id) {return Ident.WallObjectDescription[id];}
    
    /** Item Functions **/
    public final int CountItems() {Load(); return sh.itemCount;}
    public final static String ItemName(int id) {return Ident.ItemName[id];}
    public final static String ItemDesc(int id) {return Ident.ItemDescription[id];}
    public final int[] GetItemById(int id) {return GetItemById(new int[]{id});}
    public final int[] GetItemById(int[] id) {Load();int minReturn[] = {-1,-1,-1};int minDist = Integer.MAX_VALUE;for(int c = 0; c < sh.itemCount; c++)if(InArray(id,sh.itemID[c])) {int ItmX = sh.itemX[c] + sh.tileX;int ItmY = sh.itemY[c] + sh.tileY;int tempDist = DistanceTo(ItmX,ItmY);if(tempDist < minDist) {minReturn[0] = sh.itemID[c];minReturn[1] = ItmX;minReturn[2] = ItmY;minDist = tempDist;}}return minReturn;}
    public final void PickupItem(int x, int y) {for(int c = 0;c < sh.itemCount;c++)if(ItemX(c) == x && ItemY(c) == y){PickupItem(x,y,ItemId(c));return;}Debug("No item found at (" + x + "," + y + ")");}
    public final void PickupItem(int x, int y, int id) {Load();sh.forceTo(sh.locX, sh.locY, x - sh.tileX, y - sh.tileY, true);sh.Connection.sendID(ID.PICKUP);sh.Connection.sendInt(x);sh.Connection.sendInt(y);sh.Connection.sendInt(id);sh.Connection.sendInt(0);sh.Connection.endPacket();long l = System.currentTimeMillis();int newAmount = CountInv(id) + 1;while(CountInv(id) < newAmount && System.currentTimeMillis() - l < 2000)Wait(100);}
    public final void PickupItemById(int id) {PickupItemById(new int[]{id});}
    public final void PickupItemById(int[] id) {int[] ids = GetItemById(id);if(ids[0] < 0){Debug("Items not found");return;}PickupItem(ids[1],ids[2],ids[0]);}
    public final static boolean ItemStackable(int id) {return Ident.ItemStackableVar[id] != 1;}
    public final int ItemX(int index){if(index < 0 || index > sh.itemCount){Debug("Invalid 'itemIndex'");return -1;}Load(); return sh.itemX[index] + sh.tileX;}
    public final int ItemY(int index){if(index < 0 || index > sh.itemCount){Debug("Invalid 'itemIndex'");return -1;}Load(); return sh.itemY[index] + sh.tileY;}
    public final int ItemId(int index){if(index < 0 || index > sh.itemCount){Debug("Invalid 'itemIndex'");return -1;}Load(); return sh.itemID[index];}
    
    /** Object Functions **/
    public final int CountObjects() {Load(); return sh.objectCount;}
    public final int[] GetObjectById(int id) {return GetObjectById(new int[]{id});}
    public final int[] GetObjectById(int[] id) {Load();int minReturn[] = {-1,-1,-1};int minDist = Integer.MAX_VALUE;for(int c = 0; c < sh.objectCount; c++)if(sh.inArray(id,sh.objectID[c])) {int ItmX = sh.objectX[c] + sh.tileX;int ItmY = sh.objectY[c] + sh.tileY;int tempDist = DistanceTo(ItmX,ItmY);if(tempDist < minDist) {minReturn[0] = sh.objectID[c];minReturn[1] = ItmX;minReturn[2] = ItmY;minDist = tempDist;}}return minReturn;}
    public final void AtObject(int x,int y) {Load();int i = sh.getObjectIndex(x,y);if(i < 0) {Debug("No object found at (" + x + "," + y + ")");return;}sh.moveNextTo(sh.objectX[i], sh.objectY[i], sh.objectDir[i], sh.objectID[i]);sh.Connection.sendID(ID.ATOBJECT1);sh.Connection.sendInt(sh.objectX[i] + sh.tileX);sh.Connection.sendInt(sh.objectY[i] + sh.tileY);sh.Connection.endPacket();}
    public final void AtObject2(int x,int y) {Load();int i = sh.getObjectIndex(x,y);if(i < 0) {Debug("No object found at (" + x + "," + y + ")");return;}sh.moveNextTo(sh.objectX[i], sh.objectY[i], sh.objectDir[i], sh.objectID[i]);sh.Connection.sendID(ID.ATOBJECT2);sh.Connection.sendInt(sh.objectX[i] + sh.tileX);sh.Connection.sendInt(sh.objectY[i] + sh.tileY);sh.Connection.endPacket();}
    public final void UseOnObject(int pos, int x, int y) {Load();int i = sh.getObjectIndex(x,y);if(i < 0) {Debug("No object found at (" + x + "," + y + ")");return;}sh.moveNextTo(sh.objectX[i], sh.objectY[i], sh.objectDir[i], sh.objectID[i]);sh.Connection.sendID(ID.USEONOBJECT);sh.Connection.sendInt(sh.objectX[i] + sh.tileX);sh.Connection.sendInt(sh.objectY[i] + sh.tileY);sh.Connection.sendInt(pos);sh.Connection.endPacket();}
    public final int GetIdObject(int x, int y) {Load();for(int c = 0;c < CountObjects();c++)if(ObjectX(c) == x && ObjectY(c) == y)return ObjectId(c);return -1;}
    public final int ObjectX(int index){if(index < 0 || index > sh.objectCount){Debug("Invalid 'objectIndex'");return -1;}Load(); return sh.objectX[index] + sh.tileX;}
    public final int ObjectY(int index){if(index < 0 || index > sh.objectCount){Debug("Invalid 'objectIndex'");return -1;}Load(); return sh.objectY[index] + sh.tileY;}
    public final int ObjectId(int index){if(index < 0 || index > sh.objectCount){Debug("Invalid 'objectIndex'");return -1;}Load(); return sh.objectID[index];}
    public final static String ObjectName(int id) {return Ident.ObjectName[id];}
    public final static String ObjectDesc(int id) {return Ident.ObjectDescription[id];}
    public final boolean IsObjectAt(int id, int x, int y) {Load();for(int c = 0;c < CountObjects();c++)if(id == ObjectId(c) && ObjectX(c) == x && ObjectY(c) == y)return true;return false;}
    public final boolean IsObjectAt(int[] id, int x, int y){Load();for(int c = 0;c < CountObjects();c++)if(InArray(id,ObjectId(c)) && ObjectX(c) == x && ObjectY(c) == y)return true;return false;}

    /** Setup Functions **/
    public final void ShowMessage(String message) {Display(message);};
    public final static String GetInput(String toAsk){try{System.out.print(toAsk + ": ");return keysIn.readLine();} catch(Exception e) {return null;}}
    public final String GetAuthName() {return replace(sh.getAuth(),"%20"," ");}
    public final String GetRsName() {return sh.user;}
    public final int DistanceTo(int x, int y) {return DistanceTo(GetX(),GetY(),x,y);}
    public final int DistanceTo(int x1, int y1, int x2, int y2) {return Shell.distanceTo(x1,y1,x2,y2);}
    public final void LockMode(int fightMode) {if(fightMode < 0 || fightMode > 3) { Debug("Invalid fightMode chosen"); return; } sh.macro.lockedMode = fightMode; Debug("Locked fightMode to " + fightMode);}
    public final void End(String s) {Display(s); End();}
    public final void End() {Shell.stopShell(sh);}
    public final void Die(String s) {Display(s); Die();}
    public final void Die() {System.exit(1);}
    public final void Display(String toDisplay) {sh.print(toDisplay); }
    public final void Display(int toDisplay) {sh.print(String.valueOf(toDisplay));}
    public final static void Debug(String toDebug) {Shell.debug(toDebug);}
    public final static void Debug(int toDebug) {Shell.debug(String.valueOf(toDebug));}
    public final boolean Loading() {return sh.load || !sh.loggedIn;}
    public final static int Rand(int base, int high) {return base + r.nextInt(high - base);}
    public final static boolean Running() {return true;}
    public final static void Wait(int ms) {Shell.sleep(ms);}
    public final static long GetMillis() {return System.currentTimeMillis();}
    public final static String Time(){return formatter.format(new Date());}
    public final static String IntToStr(int i) {try{return String.valueOf(i);}catch(Exception e){return null;}}
    public final static String IntToStr(long i) {try{return String.valueOf(i);}catch(Exception e){return null;}}
    public final static int StrToInt(String s) {try{return Integer.parseInt(s);}catch(Exception e){return -1;}}
    public final static boolean IsInStr(String string, String findme) {return string.indexOf(findme) > -1;}
    public final static boolean InArray(String[] toSearch, String toFind) {return Shell.inArray(toSearch,toFind);}
    public final static boolean InArray(int[] toSearch, int toFind) {return Shell.inArray(toSearch,toFind);}
    public static String replace(String target, String from, String to){int start = target.indexOf(from);if (start == -1)return target;int lf = from.length();char [] targetChars = target.toCharArray();StringBuffer buffer = new StringBuffer();int copyFrom = 0;while(start != -1){buffer.append (targetChars, copyFrom, start-copyFrom);buffer.append (to);copyFrom = start + lf;start = target.indexOf(from, copyFrom);}buffer.append (targetChars, copyFrom, targetChars.length-copyFrom);return buffer.toString();}
    public final static int GetAverage(int[] values) {int total = 0; for(int x = 0;x < values.length;x++) total += values[x]; total = (int)(total / values.length); return total;}
    public final void Load() {while(Loading()) Wait(100);}

    /** NOT USED **/

    public final void FixSleeping(boolean fix) {notUsed("FixSleeping(boolean fix)");}
    public final void SaveScreenShot(String s) {notUsed("SaveScreenShot(String s)");}
    public final void ChatFilterOn(boolean on) {notUsed("ChatFilterOn(boolean on");}
    public final int GetOption(String header, String[] options) {notUsed("GetOption(String header, String[] options)");return -1;}
    public final void SetGfx(boolean on) {notUsed("SetGfx(boolean on)");}
    public final boolean IsSpecial() {notUsed("IsSpecial()"); return true;}
    public final boolean IsScanningForMods() {notUsed("IsScanningForMods()");return true;}
    public final void StopScanForMods() {notUsed("StopScanForMods()");}
    public final boolean IsPopup() {notUsed("IsPopup()");return false;}
    public final void ClosePopup() {notUsed("ClosePopup()");}
    public final void UnlockMode() {notUsed("UnlockMode()");}
    public final void AutoLogin(boolean on) {notUsed("AutoLogin(boolean on)");}
    public final boolean IsAutoLogin() {notUsed("IsAutoLogin()");return true;}
    public final void AddToIgnore(String player) {notUsed("AddToIgnore(String player)");}
    public final String[] GetIgnoreList() {notUsed("GetIgnoreList()");return null;}
    public final boolean IsOnIgnoreList(String player) {notUsed("IsOnIgnoreList(String player)");return false;}
    public final void RemoveFromIgnore(String player) {notUsed("RemoveFromIgnore(String player)");}
    public final void Login(String user, String pass) {notUsed("Login(String user, String pass)");}
    public final boolean FightingPlayerInWild() {notUsed("FightingPlayerInWild()"); return false;}
    public final void ForceStatMenu(boolean show) {notUsed("ForceStatMenu(boolean show)");}
    public final void StartScanForMods(){notUsed("StartScanForMods()");}
    public final void UseItem2(int pos) {notUsed("UseItem2(int pos)");}

    private final void notUsed(String command) {
        Display("This command is no longer in use: " + command);
    }
}