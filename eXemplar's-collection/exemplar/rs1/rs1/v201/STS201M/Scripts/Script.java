import java.util.*;
import java.io.*;
import java.awt.*;

public class Script extends Methods
{
    public Script(mudclient mc)
    {
        super(mc);
        mud = mc;
    }
    protected mudclient mud;
    public Hashtable macros = new Hashtable();
    public boolean SBoTRunning = false;
    public Script macro = null;
    private Thread SBoT = null;
    
    private boolean CheckFighters = false;
    private String LastChatterName = new String();
    private int LastChatterIndex = -1;
    private String LastChatMessage = new String();
    private String LastServerMessage = new String();
    
    public String[] getCommands(){return new String[0];}
    public void start(String command, String parameters[]){System.out.println("STARTINGPLZ");}
    public void NPCMessage(String message){}
    public void ChatMessage(String message){}
    public void ServerMessage(String message){}
    
    public final void CheckFighters(boolean check){Loading();CheckFighters = check;}
    public final int LastChatter(){ return LastChatterIndex;}
    public final String LastChatterName(){Loading(); return LastChatterName;}
    public final int BankCount(int item){return CountInBank(item);}
    public final int NPCX(int index){return NpcX(index);}
    public final int NPCY(int index){return NpcY(index);}
    public final boolean IsAccepted(){return OpponentTradeAccepted();}
    public final int GetUnbusyBanker(){Loading();int[] bank = GetNpcByIdNotTalk(BANKERS);return bank[0];}
    public final int GetUnbusyBanker2(){Loading();int[] bank = GetNpcByIdNotTalk(BANKERS);return bank[0];}
    public final void Quit(){Die();}
    public final int Distance(int x, int y){Loading();return DistanceTo(x,y);}
    public final int TradeStatus(){Loading();if(InTradeScreen2())return 1;if(InTradeScreen1())return 2;return 0;}
    public final void AcceptTrade(){AcceptTrade1();}
    public final void TradeArray(int item, int amount){AddToOffer(item,amount);}
    public final void TradeArray(int[] item, int[] amount){OfferItems(item,amount);}
    public final void UpdateTrade(){Display("Deprecated command: void UpdateTrade()");}
    public final void ResetTrade(){Display("Deprecated command: void ResetTrade()");}
    public final boolean CanReach(int x, int y){return IsReachable(x,y);}
    public final void Beep(){Toolkit.getDefaultToolkit().beep();}
    public final void DisplayMessage(String message, int type){Display(message);}
    public final void SetFightMode(int style){SetMode(style);}
    public final int GetFightMode(){return GetMode();}
    public final void Println(String message){System.out.println(message);}
    public final void Print(String message){System.out.print(message);}
    public final void SexyPrint(String s){for(int i = 0; i < s.length() - 1; i++){Print(s.substring(i, i + 1));Wait(1);}Println(s.substring(s.length() - 1));}
    public final void ForceWalk(int x, int y){ForceWalkToWait(x,y);}
    public final void ForceWalkNoWait(int x, int y){ForceWalkTo(x,y);}
    public final void AtObject(int coords[]){AtObject(coords[0],coords[1]);}
    public final void AtObject2(int coords[]){AtObject2(coords[0],coords[1]);}
    public final void Walk(int x, int y){WalkToWait(x,y);}
    public final void Walk(int x, int y, int step){WalkToWait(x,y);}
    public final void WalkNoWait(int x, int y){WalkTo(x,y);}
    public final long TickCount(){return GetMillis();}
    public final void WalkEmpty(int x1, int y1, int x2, int y2){int x = GetAverage(new int[]{x1,x2});int y = GetAverage(new int[]{y1,y2});ForceWalkToWait(x,y);}
    public final int PlayerAt(int x, int y){Display("Deprecated command: int PlayerAt(int x, int y)"); return -1;}
    public final boolean Obstructed(int x, int y){ return !IsReachable(x,y);}
    public final void WalkEmptyNoWait(int x1, int y1, int x2, int y2){int x = GetAverage(new int[]{x1,x2});int y = GetAverage(new int[]{y1,y2});ForceWalkTo(x,y);}
    public final void Say(String message){Speak(message);}
    public final boolean EmptyTile(int x, int y){for(int c = 0;c < CountPlayers();c++)if(PlayerX(c) == x && PlayerY(c) == y)return false;return true;}
    public final void MagicPlayer(int player, int spell){Display("Deprecated command: void MagicPlayer(int player, int spell)");}
    public final void UseOnPlayer(int player, int slot){Display("Deprecated command: void UseOnPlayer(int player, int slot)");}
    public final void AttackPlayer(int player){Display("Deprecated command: void AttackPlayer(int player)");}
    public final void DuelPlayer(int player){Display("Deprecated command: void DuelPlayer(int player)");}
    public final void FollowPlayer(int player){Display("Deprecated command: void FollowPlayer(int player)");}
    public final void MagicItem(int x, int y, int item, int spell){CastOnGItem(spell, item, x, y);}
    public final void UseOnItem(int x, int y, int type, int item){UseItemOnGItem(type, x, y, item);}
    public final boolean TakeItem(int x, int y, int type){PickupItem(x, y, type); return true;}
    public final void MagicNPC(int id, int spell){CastOnNpc(spell, id);}
    public final void UseOnNPC(int id, int item){UseOnNpc(item,id);}
    public final void TalkToNPC(int id){TalkToNpc(id);}
    public final void AttackNPC(int id){AttackNpc(id);}
    public final void ThieveNPC(int id){ThieveNpc(id);}
    public final void MagicDoor(int x, int y, int dir, int spell){CastOnWallObject(spell, x, y);}
    public final void UseOnDoor(int x, int y, int dir, int item){UseOnWallObject(item, x, y);}
    public final void OpenDoor(int x, int y, int dir){AtWallObject(x,y);}
    public final void CloseDoor(int x, int y, int dir){AtWallObject2(x,y);}
    public final void MagicObject(int x, int y, int spell){CastOnObject(spell, x, y);}
    public final void Magic(int spell){if(IsCastableOnSelf(spell))CastOnSelf(spell);else if(IsCastableOnGround(spell))CastOnGround(spell);}
    public final void MagicInventory(int slot, int spell){CastOnItem(spell, slot);}
    public final void UseWithInventory(int slot1, int slot2){UseItemWithItem(slot1, slot2);}
    public final void Remove(int slot){RemoveItem(slot);}
    public final void Wield(int slot){WearItem(slot);}
    public final void Use(int slot){UseItem(slot);}
    public final void Drop(int slot){DropItem(slot);}
    public final int InvCount(int type){return CountInv(type);}
    public final int InvCount(){return CountInv();}
    public final void Buy(int item){BuyShopItem(item);}
    public final void Sell(int item){SellShopItem(item);}
    public final boolean Bank(){return InBank();}
    public final boolean Shop(){return InShop();}
    public final int DoorAt(int x, int y, int dir){return GetIdWallObject(x, y);}
    public final boolean ItemAt(int x, int y, int type){for(int c = 0;c < CountItems();c++)if(ItemX(c) == x && ItemY(c) == y)return true;return false;}
    public final int ObjectAt(int x, int y){for(int c = 0;c < CountObjects();c++)if(ObjectX(c) == x && ObjectY(c) == y)return ObjectId(c);return -1;}
    public final int PlayerByName(String name){return GetPlayerByName(name)[0];}
    public final int GetExperience(int statno){return (int)GetExp(statno);}
    public final int GetCurrentStat(int statno){return GetCurLvl(statno);}
    public final int GetStat(int statno){return GetMaxLvl(statno);}
    public final int PlayerHP(int id){Display("Deprecated command: int PlayerHP(int id)"); return -1;}
    public final boolean PlayerInCombat(int id){Display("Deprecated command: boolean PlayerInCombat(int id)"); return false;}
    public final int PlayerDestX(int id){Display("Deprecated command: int PlayerDestX(int id)"); return -1;}
    public final int PlayerDestY(int id){Display("Deprecated command: int PlayerDestY(int id)"); return -1;}
    public final String LastChatMessage(){Loading(); return LastChatMessage;}
    public final void ResetLastChatMessage(){Loading(); LastChatMessage = new String();}
    public final String LastNPCMessage(){Display("NPC Messages are now shown in Chat Messages!"); return new String();}
    public final void ResetLastNPCMessage(){Display("NPC Messages are now shown in Chat Messages!");}
    public final String LastServerMessage(){Loading(); return LastServerMessage;}
    public final void ResetLastServerMessage(){Loading(); LastServerMessage = new String();}
    public final void WaitForServerMessage(int timeout){String s = LastServerMessage();long T = GetMillis();while(LastServerMessage().equals(s) && GetMillis() - T <= timeout)Wait(100);}
    public final boolean InLastServerMessage(String st){return IsInStr(LastServerMessage(),st);}
    public final int FindInv(int type){return GetItemPos(type);}
    public final void SleepWord(){Display("Deprecated command: void SleepWord()");}
    public final int Fatigue(){return GetFatigue();}
    public final void WaitForLoad(){Loading();}
    public final boolean Prayer(int prayer){return IsPrayerOn(prayer);}
    public final int ShopCount(int item){return CountShop(item);}
    public final void SetWorld(int world){ChangeWorld(world);}
    public final int LastPlayerAttacked(){Display("Deprecated command: int LastPlayerAttacked()"); return -1;}
    public final void ResetLastPlayerAttacked(){Display("Deprecated command: void ResetLastPlayerAttacked()");}
    public final void OpenUnbusyBank(){while(!Bank()){int ID = GetUnbusyBanker();TalkToNPC(ID);long T = TickCount();ResetLastServerMessage();while(TickCount() - T < 6000 && !QuestMenu() && !InLastServerMessage("busy") && Running())Wait(100);if(QuestMenu()){Answer(0);T = TickCount();while(TickCount() - T < 6000 && !Bank() && Running())Wait(100);}}}
    public final void OpenBank(){while(!Bank()){int ID = GetNearestNPC(BANKERS);TalkToNPC(ID);long T = TickCount();ResetLastServerMessage();while(TickCount() - T < 6000 && !QuestMenu() && !InLastServerMessage("busy"))Wait(100);if(QuestMenu()){Println("Answering banker!");Answer(0);T = TickCount();while(TickCount() - T < 6000 && !Bank() && Running())Wait(100);}}}
    public final boolean InStr(String str, String locate){return IsInStr(str,locate);}
    public final String GetAnswer(int pos){return GetQuestOption(pos);}
    public final int GetDistance(int x1, int y1, int x2, int y2){return DistanceTo(x1,y1,x2,y2);}
    public final int GetHP(){return GetCurLvl(3);}
    public final int GetMaxHP(){return GetMaxLvl(3);}
    public final int GetHPPercent(){return HitsPercent();}
    public final int Inv(int slot){return InvItemId(slot);}
    public final String GetItemCommand(int type){Display("Deprecated command: String GetItemCommand(int type)"); return new String();}
    public final String GetItemDesc(int type){ return ItemDesc(type);}
    public final String GetItemName(int type){return ItemName(type);}
    public final String Username(){return GetRsName();}
    public final int GetPrayerLevel(int prayer){ return PrayerLvl(prayer);}
    public final int GetPrayerDrain(int prayer){Display("Deprecated command: int GetPrayerDrain(int prayer)"); return -1;}
    public final String GetNPCCommand(int type){Display("Deprecated command: String GetNPCCommand(int type)"); return new String();}
    public final String GetNPCDesc(int type){ return NpcDesc(type);}
    public final int GetNPCLevel(int type){return NpcCombat(type);}
    public final int GetNPCType(int id){Display("Deprecated command: int GetNPCType(int id)"); return -1;}
    public final int GetNPCMaxHP(int type){return NpcMaxHits(type);}
    public final String GetNPCName(int type){return NpcName(type);}
    public final int GetAnswerCount(){return CountQuestMenu();}
    public final int GetItemCount(){return CountItems();}
    public final int GetNPCCount(){return CountNpcs();}
    public final int GetPlayerCount(){return CountPlayers();}
    public final int GetObjectCount(){return CountObjects();}
    public final String GetObjectCommand1(int type){Display("Deprecated command: String GetObjectCommand1(int type)"); return new String();}
    public final String GetObjectCommand2(int type){Display("Deprecated command: String GetObjectCommand2(int type)"); return new String();}
    public final String GetObjectDesc(int type){return ObjectDesc(type);}
    public final String GetObjectName(int type){return ObjectName(type);}
    public final boolean InArea(int x1, int y1, int x2, int y2){Loading();int x = GetX();int y = GetY();return x >= x1 && x <= x2 && y >= y1 && y <= y2;}
    public final boolean Wearable(int type){return IsItemWearable(type);}
    public final boolean IsWorn(int slot){return WearingItem(slot);}
    public final boolean IsNPCAttackable(int type){return NpcAttackable(type);}
    public final void WalkPath(int pathx[], int pathy[]){Loading();if(pathx.length != pathy.length){Display("### WalkPath - COORDINATES NOT THE SAME LENGTH");return;}int startPoint = 0;int startDistance = 8000;for(int i = 0; i < pathx.length; i++)if(startDistance == 8000)startDistance = Distance(pathx[i],pathy[i]);else if(Distance(pathx[i],pathy[i]) < startDistance){startPoint = i;startDistance = Distance(pathx[i],pathy[i]);}for(int i = startPoint; i < pathx.length; i++)Walk(pathx[i],pathy[i],Rand(8000,12000));}
    public final void WalkPath(int pathx[], int pathy[], int ticks){Loading();if(pathx.length != pathy.length){Display("### WalkPath - COORDINATES NOT THE SAME LENGTH");return;}int startPoint = 0;int startDistance = 8000;for(int i = 0; i < pathx.length; i++)if(startDistance == 8000)startDistance = Distance(pathx[i],pathy[i]);else if(Distance(pathx[i],pathy[i]) < startDistance){startPoint = i;startDistance = Distance(pathx[i],pathy[i]);}for(int i = startPoint; i < pathx.length; i++)Walk(pathx[i],pathy[i],ticks);}
    public final void WalkPathReverse(int pathx[], int pathy[]){Loading();if(pathx.length != pathy.length){Display("### WalkPath - COORDINATES NOT THE SAME LENGTH");return;}int startPoint = 0;int startDistance = 8000;for(int i = 0; i < pathx.length; i++)if(startDistance == 8000)startDistance = Distance(pathx[pathx.length-1-i],pathy[pathx.length-1-i]);else if(Distance(pathx[pathx.length-1-i],pathy[pathx.length-1-i]) < startDistance){startPoint = i;startDistance = Distance(pathx[pathx.length-1-i],pathy[pathx.length-1-i]);}for(int i = startPoint; i < pathx.length; i++)Walk(pathx[pathx.length-1-i],pathy[pathx.length-1-i],Rand(8000,12000));}
    public final void WalkPathReverse(int pathx[], int pathy[], int ticks){Loading();if(pathx.length != pathy.length){Display("### WalkPath - COORDINATES NOT THE SAME LENGTH");return;}int startPoint = 0;int startDistance = 8000;for(int i = 0; i < pathx.length; i++)if(startDistance == 8000)startDistance = Distance(pathx[pathx.length-1-i],pathy[pathx.length-1-i]);else if(Distance(pathx[pathx.length-1-i],pathy[pathx.length-1-i]) < startDistance){startPoint = i;startDistance = Distance(pathx[pathx.length-1-i],pathy[pathx.length-1-i]);}for(int i = startPoint; i < pathx.length; i++)Walk(pathx[pathx.length-1-i],pathy[pathx.length-1-i],ticks);}
    public final boolean CoordsAt(int pos[]){Loading();return GetX() == pos[0] && GetY() == pos[1];}
    public final boolean CoordsAt(int x, int y){Loading();return GetX() == x && GetY() == y;}
    public final boolean AutoLogin(){return IsAutoLogin();}
    public final void EnableAutoLogin(){AutoLogin(true);}
    public final void DisableAutoLogin(){AutoLogin(false);}
    public final String Version(){return new String("SBoT Hax Script for STS");}
    public final boolean NPCExists(int id){Loading(); return GetNpcById(id)[0] > -1;}
    public final boolean NPCInCombat(int id){Loading(); return NpcInCombat(GetNpcById(id)[0]);}
    public final int InvCountByName(String name){int i = InvByName(name);if(i < 0)return -1;i = InvItemId(i);if(i < 0)return -1;return CountInv(i);}
    public final int InvByName(String name){for(int x = 0;x < CountInv();x++)if(ItemName(InvItemId(x)).equalsIgnoreCase(name))return x;return -1;}
    public final boolean IsStackable(int id){return ItemStackable(id);}
    public final int GetRandomNPC(int id){Loading(); return 0;}
    public final int GetRandomNPC(int id[]){Loading(); return 0;}
    public final int[] GetNearestObject(int type){Loading();int[] t = GetObjectById(type);return new int[]{t[1],t[2]};}
    public final int[] GetNearestObject(int type[]){Loading();int[] t = GetObjectById(type);return new int[]{t[1],t[2]};}
    public final int[] GetNearestObject(int type, int x1, int y1, int x2, int y2){int min[] = {-1,-1};int mint = Integer.MAX_VALUE;for(int j = 0; j < CountObjects(); j++){int ItmX = ObjectX(j);int ItmY = ObjectY(j);if(ObjectId(j) == type && ItmX >= x1 && ItmX <= x2 && ItmY >= y1 && ItmY <= y2){int temp = DistanceTo(ItmX,ItmY);if(temp < mint){min[0] = ItmX;min[1] = ItmY;mint = temp;}}}return min;}
    public final int[] GetNearestObject(int type[], int x1, int y1, int x2, int y2){int min[] = {-1,-1};int mint = Integer.MAX_VALUE;for(int j = 0; j < CountObjects(); j++){int ItmX = ObjectX(j);int ItmY = ObjectY(j);if(InArray(type,ObjectId(j)) && ItmX >= x1 && ItmX <= x2 && ItmY >= y1 && ItmY <= y2){int temp = DistanceTo(ItmX,ItmY);if(temp < mint){min[0] = ItmX;min[1] = ItmY;mint = temp;}}}return min;}
    public final int GetNearestNPC(int type){Loading();return (CheckFighters? GetNpcById(type) : GetAllNpcById(type))[0];}
    public final int GetNearestNPC(int type[]){Loading();return (CheckFighters? GetNpcById(type) : GetAllNpcById(type))[0];}
    public final int[] GetNearestNPC(int type, int x1, int y1, int x2, int y2){int min[] = {-1,-1};int mint = Integer.MAX_VALUE;for(int j = 0; j < CountObjects(); j++){int ItmX = ObjectX(j);int ItmY = ObjectY(j);if((ObjectId(j) == type && ItmX >= x1 && ItmX <= x2 && ItmY >= y1 && ItmY <= y2) && (!NpcInCombat(j) || !CheckFighters)){int temp = DistanceTo(ItmX,ItmY);if(temp < mint){min[0] = ItmX;min[1] = ItmY;mint = temp;}}}return min;}
    public final int[] GetNearestNPC(int type[], int x1, int y1, int x2, int y2){int min[] = {-1,-1};int mint = Integer.MAX_VALUE;for(int j = 0; j < CountObjects(); j++){int ItmX = ObjectX(j);int ItmY = ObjectY(j);if((InArray(type,ObjectId(j)) && ItmX >= x1 && ItmX <= x2 && ItmY >= y1 && ItmY <= y2) && (!NpcInCombat(j) || !CheckFighters)){int temp = DistanceTo(ItmX,ItmY);if(temp < mint){min[0] = ItmX;min[1] = ItmY;mint = temp;}}}return min;}
    public final int[] GetNearestItem(int type){Loading();int[] t = GetItemById(type);return new int[]{t[1],t[2]};}
    public final int[] GetNearestItem(int type[]){Loading();int[] t = GetItemById(type);return new int[]{t[1],t[2]};}
    public final void Logout() {LogOut();}

    public void MainBody(String Args[])
    {
        ShowMessage("@gre@SBoT Emulator script for STS, by Reines. @whi@Alot of player related commands are not supported, as STS doesn't support ACing etc. @or3@Important: @or1@UseOnObject(int x, int y, int item) @whi@in SBoT scripts must change to @or1@UseOnObject(int item, int x, int y)@whi@!");
        macros.clear();
        File f = new File(System.getProperty("user.dir") + "/SBoT/");
        if(!f.exists())
           f.mkdir();
        String[] files = f.list();
        for(int i = 0; i < files.length;i++) // Lets rip this from SBoT as its the easiest way to make sure we emulate it as closely as possible
        {
            try
            {
                if(files[i].endsWith(".class") && files[i].indexOf('$') == -1)
                {
                    Class clazz = Class.forName(files[i].substring(0,files[i].length()-".class".length()));
                    Script macro = (Script)clazz.getConstructor(new Class[]{mudclient.class}).newInstance(new Object[]{mud});
                    String[] commands = macro.getCommands();
                    System.out.println("Script found: " + files[i]);
                    for(int j = 0; j < commands.length;j++)
                    {
                        commands[j] = commands[j].toLowerCase();
                        System.out.println(" - Command: " + commands[j]);
                        macros.put(commands[j], macro);
                    }
                }
            }
            catch(Exception e){e.toString();}
        }
        while(Running())
            Wait(1000);
    }

    public void OnInput(String input)
    {
        if(input.startsWith("run"))
        {
            if(!SBoTRunning)
            {
                 // Lets rip this from SBoT as its the easiest way to make sure we emulate it as closely as possible
                String s = input.substring(4);
                System.out.println(s);
                int paramIndex = s.indexOf(" ");
                if(paramIndex == -1)
                    macro = (Script)macros.get(s);
                else
                    macro = (Script)macros.get(s.substring(0,paramIndex));
                String param = null;
                String tcmd = null;
                if(paramIndex != -1)
                {
                    param = s.substring(paramIndex + 1);
                    tcmd = s.substring(0,paramIndex);
                }
                else
                {
                    param = null;
                    tcmd = s;
                }
                String[] param1 = null;
                if(param != null)
                {
                    param1 = param.split("@");
                    for(int a = 0; a < param1.length; a++)
                    param1[a] = param1[a].trim();
                }
                final String[] params = param1;
                final String cmd = tcmd;
                if(macro == null)
                    Display("@gre@SBoT: @whi@COMMAND: " + s + " NOT FOUND");
                else
                {
                    SBoT = new Thread(new Runnable(){public void run(){macro.start(cmd,params);}});
                    SBoTRunning = true;
                    SBoT.start();
                    Display("@gre@SBoT: @whi@Press F12 to stop (always stop SBoT script before using /stop!)");
                }
            }
            else
                Display("@gre@SBoT: @whi@There is a script already running, F12 to stop it");
        }
    }

    private void EndScript()
    {
        if(SBoTRunning && SBoT != null)
        {
            SBoT.stop();
            SBoT = null;
            macro = null;
            SBoTRunning = false;
            Display("@gre@SBoT: @whi@Script stopped");
        }
        else
            Display("@gre@SBoT: @whi@No script running...");
    }

    public void KeyPressed(int key)
    {
        if(key == 1019) // F12
            EndScript();
        if(macro != null)
            macro.KeyPressed(key);
    }

    public void OnChatMessage(String sender, String message)
    {
        LastChatterName = sender;
        LastChatterIndex = GetPlayerByName(sender)[0];
        LastChatMessage = message;
        if(macro != null)
        {
            macro.ChatMessage(message);
            macro.NPCMessage(message);
        }
    }

    public void OnPrivateMessage(String sender, String message)
    {
    }

    public void OnServerMessage(String message)
    {
        LastServerMessage = message;
        if(macro != null)
            macro.ServerMessage(message);
    }
    
    public Stats ToShow()
    {
        String[] Message = {"@gre@SBoT by RichyT","Emulated by Reines"};
        int[] XCoords = {10,10};
        int[] YCoords = {126,138};
        return new Stats(Message, XCoords, YCoords);
    }
}