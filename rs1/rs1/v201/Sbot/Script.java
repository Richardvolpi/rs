import java.awt.*;

public abstract class Script
{
    protected mudclient rs;

    public Script(mudclient rs)
    {
        this.rs = rs;
    }
    public void start(String command, String parameters[])
    {
		System.out.println("STARTINGPLZ");
    }
    public String[] getCommands()
    {
        return new String[0];
    }
    public void init()
    {
    }
	public void ServerMessage(String message)
	{
	}
	public void ChatMessage(String message)
	{
	}
	public void NPCMessage(String message)
	{
	}
	public void TradeRequest(int PlayerID)
	{
	}
	public void Accepted()
	{
	}
	public void TradeOver()
	{
	}
	public void KeyPressed(int key)
	{
	}
	public void KeyReleased(int key)
	{
	}

	public int LastChatter()
	{
		WaitForLoad();
		return rs.lastChatter;
	}
	public String LastChatterName()
	{
		WaitForLoad();
		return rs.lastChatterName;
	}
	public int BankCount(int item)
	{
		if (!Running())
			return -1;
		WaitForLoad();
		return rs.BankCount(item);
	}
	public int StrToInt(String st)
	{
		return Integer.parseInt(st);
	}
	public String IntToStr(int num)
	{
		return String.valueOf(num);
	}
	public int NPCX(int id)
	{
		try
		{
			WaitForLoad();
			return rs.NPCX(id);
		}
		catch (Exception e) {}
		return 0;
	}
	public int NPCY(int id)
	{
		try
		{
			WaitForLoad();
			return rs.NPCY(id);
		}
		catch (Exception e) {}
		return 0;
	}
	public boolean IsAccepted()
	{
		WaitForLoad();
		return rs.Accepted();
	}
	public int GetUnbusyBanker()
	{
		WaitForLoad();
		return rs.GetUnbusyBanker();
	}

	public int GetUnbusyBanker2()
	{
		WaitForLoad();
		return rs.GetUnbusyBanker();
	}

	public void Quit()
	{
		System.exit(1);
	}

	public int Distance(int x, int y)
	{
		WaitForLoad();
		return rs.Distance(x,y);
	}

	public int TradeStatus()
	{
		WaitForLoad();
		return rs.TradeStatus();
	}
	public void AcceptTrade()
	{
		WaitForLoad();
		rs.packets.id(94);
		rs.packets.send();
	}
	public void AcceptTrade2()
	{
		WaitForLoad();
		rs.packets.id(102);
		rs.packets.send();
	}
	public void DeclineTrade()
	{
		WaitForLoad();
		rs.packets.id(27);
		rs.packets.send();
		rs.tradeSecond = false;
	}
	
	public void TradeArray(int item, int amount)
	{
		WaitForLoad();
		ResetTrade();
		rs.tradeTotal = 1;
		rs.tradeType[0] = item;
		rs.tradeCount[0] = amount;
	}

	public void TradeArray(int item[], int amount[])
	{
		if (item.length != amount.length)
		{
			System.out.println("DIFFERENT NUMBER OF TRADE ITEMS AND AMOUNTS");
			return;
		}
		WaitForLoad();
		ResetTrade();
		rs.tradeTotal = item.length;
		rs.tradeType = item;
		rs.tradeCount = amount;
	}

	public void UpdateTrade()
	{
		rs.packets.id(144);
		rs.packets.var(rs.tradeTotal);
		for(int i3 = 0; i3 < rs.tradeTotal; i3++)
		{
			rs.packets.cmd(rs.tradeType[i3]);
			rs.packets.hfb(rs.tradeCount[i3]);
		}
		rs.packets.send();
	}

	public void ResetTrade()
	{
		WaitForLoad();
		for (int i = 0; i < 12; i++)
		{
			rs.tradeType[i] = 0;
			rs.tradeCount[i] = 0;
		}
		rs.tradeTotal = 0;
	}

	public boolean CanReach(int x, int y)
	{
		WaitForLoad();
		return rs.CanReach(x,y);
	}
	public void Beep()
	{
		Toolkit.getDefaultToolkit().beep();
	}
	public void Wait(int ticks)
	{
		try
		{
			Thread.sleep(ticks);
		}
		catch (InterruptedException e) { e.toString(); }
	}
	public void DisplayMessage(String message, int type)
	{
		WaitForLoad();
		rs.DisplayMessage(message,type);
	}
	public void SetFightMode(int style)
	{
		WaitForLoad();
		rs.SetFightMode(style);
	}
	public int GetFightMode()
	{
		WaitForLoad();
		return rs.fightmode;
	}
	public void Println(String message)
	{
		System.out.println(message);
	}
	public void Print(String message)
	{
		System.out.print(message);
	}
	public void SexyPrint(String message)
	{
		for (int i = 0; i < message.length() - 1; i++)
		{
			System.out.print(message.substring(i,i+1));
			Wait(1);
		}
		System.out.println(message.substring(message.length()-1));
	}
	public void ForceWalk(int x, int y)
	{
		WaitForLoad();
		while (rs.GetX() != x && rs.GetY() != y)
		{
			WaitForLoad();
			rs.ForceWalk(x,y);
			long T = TickCount();
			while (rs.GetX() != x && rs.GetY() != y && TickCount() - T < 2500)
				Wait(1);
		}		
	}
	public void ForceWalkNoWait(int x, int y)
	{
		WaitForLoad();
		rs.ForceWalk(x,y);
	}
	public void AtObject(int x, int y)
	{
		WaitForLoad();
		if (rs.mobarray(x,y) != -1)
		{
			rs.AtObject(x,y);
		} else {
			rs.DisplayMessage("@red@ERROR: @whi@No object found at: @yel@" + x + ", " + y, 3);
		}
	}
	public void AtObject(int coords[])
	{
		WaitForLoad();
		if (rs.mobarray(coords[0],coords[1]) != -1)
		{
			rs.AtObject(coords[0],coords[1]);
		} else {
			rs.DisplayMessage("@red@ERROR: @whi@No object found at: @yel@" + coords[0] + ", " + coords[1], 3);
		}
	}
	public void AtObject2(int x, int y)
	{
		WaitForLoad();
		if (rs.mobarray(x,y) != -1)
		{
			rs.AtObject2(x,y);
		} else {
			rs.DisplayMessage("@red@ERROR: @whi@No object found at: @yel@" + x + ", " + y, 3);
		}
	}
	public void AtObject2(int coords[])
	{
		WaitForLoad();
		if (rs.mobarray(coords[0],coords[1]) != -1)
		{
			rs.AtObject2(coords[0],coords[1]);
		} else {
			rs.DisplayMessage("@red@ERROR: @whi@No object found at: @yel@" + coords[0] + ", " + coords[1], 3);
		}
	}
	public void Walk(int x, int y)
	{
		WaitForLoad();
		while (rs.GetX() != x && rs.GetY() != y)
		{
			WaitForLoad();
			rs.Walk(x,y);
			long T = TickCount();
			while (TickCount() - T < Rand(2500,3500) && rs.GetX() != x && rs.GetY() != y)
				Wait(1);
		}
	}
	public void Walk(int x, int y, int step)
	{
		WaitForLoad();
		while (rs.GetX() != x && rs.GetY() != y)
		{
			WaitForLoad();
			rs.Walk(x,y);
			long T = TickCount();
			while (TickCount() - T < step && rs.GetX() != x && rs.GetY() != y)
				Wait(1);
		}
	}
	public void WalkNoWait(int x, int y)
	{
		WaitForLoad();
		rs.Walk(x,y);
	
	}
	public long TickCount()
	{
		return System.currentTimeMillis();
	}
	public void WalkEmpty(int x1, int y1, int x2, int y2)
	{
		WaitForLoad();
		boolean FoundEmpty = false;
		for (int horizontal = x1; horizontal <= x2; horizontal++)
		{
			for (int vertical = y1; vertical <= y2; vertical++)
			{
				if (rs.EmptyTile(horizontal, vertical) == true)
				{
					FoundEmpty = true;
				}
			}
		}
		if (FoundEmpty == true)
		{
			boolean GoneTo = false;
			while (GoneTo == false)
			{
				WaitForLoad();
				int TempX = Rand(x1, x2);
				int TempY = Rand(y1, y2);
				if (rs.EmptyTile(TempX, TempY) == true)
				{
					Walk(TempX, TempY);
					GoneTo = true;
				}
			}
		} else {
			System.out.println("Warning: No Empty Tiles Found");
			Walk(Rand(x1, x2), Rand(y1, y2));
		}
	}
	public int PlayerAt(int x, int y)
	{
		return rs.PlayerAt(x,y);
	}
	public boolean Obstructed(int x, int y)
	{
		if (ObjectAt(x,y) != -1)
			return true;
		if (PlayerAt(x,y) != -1)
			return true;
		if (!CanReach(x,y))
			return true;
		return false;
	}
	public void WalkEmptyNoWait(int x1, int y1, int x2, int y2)
	{
		WaitForLoad();
		boolean FoundEmpty = false;
		for (int horizontal = x1; horizontal <= x2; horizontal++)
		{
			for (int vertical = y1; vertical <= y2; vertical++)
			{
				if (rs.EmptyTile(horizontal, vertical) == true)
				{
					FoundEmpty = true;
				}
			}
		}
		if (FoundEmpty == true)
		{
			boolean GoneTo = false;
			while (GoneTo == false)
			{
				WaitForLoad();
				int TempX = Rand(x1, x2);
				int TempY = Rand(y1, y2);
				if (rs.EmptyTile(TempX, TempY) == true)
				{
					rs.Walk(TempX, TempY);
					GoneTo = true;
				}
			}
		} else {
			System.out.println("Warning: No Empty Tiles Found");
			rs.Walk(Rand(x1, x2), Rand(y1, y2));
		}
	}
	public int GetX()
	{
		WaitForLoad();
		return rs.GetX();
	}
	public int GetY()
	{
		WaitForLoad();
		return rs.GetY();
	}
	public int Rand(int lower, int higher)
	{
		WaitForLoad();
		return rs.Rand(lower, higher);
	}
	public void Say(String message)
	{
		WaitForLoad();
		rs.Say(message);
	}
	public boolean EmptyTile(int x, int y)
	{
		WaitForLoad();
		return rs.EmptyTile(x, y);
	}
	public void MagicPlayer(int player, int spell)
	{
		WaitForLoad();
		rs.MagicPlayer(player, spell);
	}
	public void UseOnPlayer(int player, int slot)
	{
		WaitForLoad();
		rs.UseOnPlayer(player, slot);
	}
	public void AttackPlayer(int player)
	{
		WaitForLoad();
		rs.AttackPlayer(player);
	}
	public void DuelPlayer(int player)
	{
		WaitForLoad();
		rs.DuelPlayer(player);
	}
	public void TradePlayer(int player)
	{
		WaitForLoad();
		rs.TradePlayer(player);
	}
	public void FollowPlayer(int player)
	{
		WaitForLoad();
		rs.FollowPlayer(player);
	}
	public void MagicItem(int x, int y, int item, int spell)
	{
		WaitForLoad();
		rs.MagicItem(x, y, item, spell);
	}
	public void UseOnItem(int x, int y, int type, int item)
	{
		WaitForLoad();
		rs.UseOnItem(x, y, type, item);
	}
	public boolean TakeItem(int x, int y, int type)
	{
		WaitForLoad();
		return rs.TakeItem(x, y, type);
	}
	public void MagicNPC(int id, int spell)
	{
		WaitForLoad();
		rs.MagicNPC(id, spell);
	}
	public void UseOnNPC(int id, int item)
	{
		WaitForLoad();
		rs.UseOnNPC(id, item);
	}
	public void TalkToNPC(int id)
	{
		WaitForLoad();
		rs.TalkToNPC(id);
	}
	public void AttackNPC(int id)
	{
		WaitForLoad();
		rs.AttackNPC(id);
	}
	public void ThieveNPC(int id)
	{
		WaitForLoad();
		rs.ThieveNPC(id);
	}
	public void MagicDoor(int x, int y, int dir, int spell)
	{
		WaitForLoad();
		rs.MagicDoor(x, y, dir, spell);
	}
	public void UseOnDoor(int x, int y, int dir, int item)
	{
		WaitForLoad();
		rs.UseOnDoor(x, y, dir, item);
	}
	public void OpenDoor(int x, int y, int dir)
	{
		WaitForLoad();
		rs.OpenDoor(x, y, dir);
	}
	public void CloseDoor(int x, int y, int dir)
	{
		WaitForLoad();
		rs.CloseDoor(x, y, dir);
	}
	public void MagicObject(int x, int y, int spell)
	{
		WaitForLoad();
		rs.MagicObject(x, y, spell);
	}
	public void UseOnObject(int x, int y, int item)
	{
		WaitForLoad();
		rs.UseOnObject(x, y, item);
	}
	public void Magic(int spell)
	{
		WaitForLoad();
		rs.Magic(spell);
	}
	public boolean QuestMenu()
	{
		WaitForLoad();
		return rs.QuestMenu;
	}
	public void Answer(int answer)
	{
		WaitForLoad();
		rs.Answer(answer);
	}
	public void MagicInventory(int slot, int spell)
	{
		WaitForLoad();
		rs.MagicInventory(slot, spell);
	}
	public void UseWithInventory(int slot1, int slot2)
	{
		WaitForLoad();
		rs.UseWithInventory(slot1, slot2);
	}
	public void Remove(int slot)
	{
		WaitForLoad();
		rs.Remove(slot);
	}
	public void Wield(int slot)
	{
		WaitForLoad();
		rs.Wield(slot);
	}
	public void Use(int slot)
	{
		WaitForLoad();
		rs.Use(slot);
	}
	public void Drop(int slot)
	{
		WaitForLoad();
		rs.Drop(slot);
	}
	public void Deposit(int type, int amount)
	{
		WaitForLoad();
		rs.Deposit(type, amount);
	}
	public void Withdraw(int type, int amount)
	{
		WaitForLoad();
		rs.Withdraw(type, amount);
	}
	public int InvCount(int type)
	{
		WaitForLoad();
		return rs.InvCount(type);
	}
	public int InvCount()
	{
		WaitForLoad();
		return rs.InvCount;
	}
	public void Logout()
	{
		WaitForLoad();
		rs.Logout();
	}
	public int[] GetNearestObject(int type)
	{
		WaitForLoad();
		int type2[] = new int[] { type };
		return new int[]{ rs.GetNearestObject(type2, true, 0, 0, 9999, 9999), rs.GetNearestObject(type2, false, 0, 0, 9999, 9999) };
	}
	public int[] GetNearestObject(int type[])
	{
		WaitForLoad();
		return new int[]{ rs.GetNearestObject(type, true, 0, 0, 9999, 9999), rs.GetNearestObject(type, false, 0, 0, 9999, 9999) };
	}
	public int[] GetNearestObject(int type, int x1, int y1, int x2, int y2)
	{
		WaitForLoad();
		int type2[] = new int[] { type };
		return new int[]{ rs.GetNearestObject(type2, true, x1, y1, x2, y2), rs.GetNearestObject(type2, false, x1, y1, x2, y2) };
	}
	public int[] GetNearestObject(int type[], int x1, int y1, int x2, int y2)
	{
		WaitForLoad();
		return new int[]{ rs.GetNearestObject(type, true, x1, y1, x2, y2), rs.GetNearestObject(type, false, x1, y1, x2, y2) };
	}
	public int GetNearestNPC(int type)
	{
		WaitForLoad();
		int type2[] = new int[]{ type };
		return rs.GetNearestNPC(type2, 0, 0, 9999, 9999);
	}
	public int GetNearestNPC(int type[])
	{
		WaitForLoad();
		return rs.GetNearestNPC(type, 0, 0, 9999, 9999);
	}
	public int GetNearestNPC(int type, int x1, int y1, int x2, int y2)
	{
		WaitForLoad();
		int type2[] = new int[]{ type };
		return rs.GetNearestNPC(type2, x1, y2, x2, y2);
	}
	public int GetNearestNPC(int type[], int x1, int y1, int x2, int y2)
	{
		WaitForLoad();
		return rs.GetNearestNPC(type, x2, y1, x2, y2);
	}
	public int[] GetNearestItem(int type)
	{
		WaitForLoad();
		int type2[] = new int[]{ type };
		return new int[]{ rs.GetNearestItem(type2, true), rs.GetNearestItem(type2, false), rs.GetNearestItemType(type2)};
	}
	public int[] GetNearestItem(int type[])
	{
		WaitForLoad();
		return new int[]{ rs.GetNearestItem(type, true), rs.GetNearestItem(type, false), rs.GetNearestItemType(type) };
	}
	public void CloseShop()
	{
		WaitForLoad();
		rs.CloseShop();
	}
	public void CloseBank()
	{
		WaitForLoad();
		rs.CloseBank();
	}
	public void Buy(int item)
	{
		WaitForLoad();
		rs.Buy(item);
	}
	public void Sell(int item)
	{
		WaitForLoad();
		rs.Sell(item);
	}
	public boolean Bank()
	{
		WaitForLoad();
		return rs.bank;
	}
	public boolean Shop()
	{
		WaitForLoad();
		return rs.shop;
	}
	public int DoorAt(int x, int y, int dir)
	{
		WaitForLoad();
		return rs.DoorAt(x, y, dir);
	}
	public boolean ItemAt(int x, int y, int type)
	{
		WaitForLoad();
		return rs.ItemAt(x, y, type);
	}
	public int ObjectAt(int x, int y)
	{
		WaitForLoad();
		return rs.ObjectAt(x, y);
	}
	public int PlayerByName(String name)
	{
		WaitForLoad();
		return rs.PlayerByName(name);
	}
	public int GetExperience(int statno)
	{
		WaitForLoad();
		return rs.anIntArray712[statno] / 4;
	}
	public int GetCurrentStat(int statno)
	{
		WaitForLoad();
		return rs.GetCurrentStat(statno);
	}
	public int GetStat(int statno)
	{
		WaitForLoad();
		return rs.GetStat(statno);
	}
	public int PlayerHP(int id)
	{
		WaitForLoad();
		return rs.PlayerHP(id);
	}
	public boolean InCombat()
	{
		WaitForLoad();
		return rs.InCombat();
	}
	public boolean PlayerInCombat(int id)
	{
		WaitForLoad();
		return rs.PlayerInCombat(id);
	}
	public int PlayerX(int id)
	{
		WaitForLoad();
		return rs.PlayerX(id);
	}
	public int PlayerY(int id)
	{
		WaitForLoad();
		return rs.PlayerY(id);
	}
	public int PlayerDestX(int id)
	{
		WaitForLoad();
		return rs.PlayerDestX(id);
	}
	public int PlayerDestY(int id)
	{
		WaitForLoad();
		return rs.PlayerDestY(id);
	}
	public String LastChatMessage()
	{
		WaitForLoad();
		return rs.lastchatmessage;
	}
	public void ResetLastChatMessage()
	{
		WaitForLoad();
		rs.lastchatmessage = "";
	}
	public String LastNPCMessage()
	{
		WaitForLoad();
		return rs.lastnpcmessage;
	}
	public void ResetLastNPCMessage()
	{
		WaitForLoad();
		rs.lastnpcmessage = "";
	}
	public String LastServerMessage()
	{
		WaitForLoad();
		return rs.lastservermessage;
	}
	public void ResetLastServerMessage()
	{
		WaitForLoad();
		rs.lastservermessage = "";
	}
	public void WaitForServerMessage(int timeout)
	{
		rs.gotnewmessage = false;
		rs.waitingforserver = true;
		long T = System.currentTimeMillis();
		while (rs.gotnewmessage == false && System.currentTimeMillis() - T <= timeout)
		{
			Wait(10);
		}
	}
	public boolean InLastServerMessage(String st)
	{
		if (rs.lastservermessage.indexOf(st) >= 0)
		{
			return true;
		}
		return false;
	}
	public int FindInv(int type)
	{
		WaitForLoad();
		return rs.FindInv(type);
	}
	public boolean Running()
	{
		WaitForLoad();
		return rs.Running;
	}
	public void CheckFighters(boolean check)
	{
		WaitForLoad();
		rs.CheckFighters = check;
	}
	public void SleepWord()
	{
		WaitForLoad();
		rs.SleepWord();
	}
	public boolean Sleeping()
	{
		WaitForLoad();
		return rs.sleeping;
	}
	public int Fatigue()
	{
		WaitForLoad();
		return (rs.fatigue * 100) / 750;
	}
	public boolean Loading()
	{
		try
		{
			if(rs.enb != 0)
			{
				rs.efh.gjj = false;
				return true;
			}
			int i = rs.smallx;
			int j = rs.smally;
			rs.dih = false;
			i += rs.dha;
			j += rs.dhb;
			if(rs.dhd == rs.egl && i > rs.dic && i < rs.die && j > rs.did && j < rs.dif)
			{
				rs.efh.gjj = true;
				return true;
			}
			return false;
		}
		catch (Exception e)
		{
			System.out.println("ERROR IN THE LOADING THINGY");
			e.printStackTrace();
			return true;
		}
	}
	public void WaitForLoad()
	{
		while (Loading())
			Wait(100);
	}
	public void PrayerOn(int prayer)
	{
		WaitForLoad();
		rs.PrayerOn(prayer);
	}
	public void PrayerOff(int prayer)
	{
		WaitForLoad();
		rs.PrayerOff(prayer);
	}
	public boolean Prayer(int prayer)
	{
		WaitForLoad();
		return rs.Prayer(prayer);
	}
	public int ShopCount(int item)
	{
		WaitForLoad();
		return rs.ShopCount(item);
	}
	public void SetWorld(int world)
	{
		ServerList.setWorld(world);
		rs.gameIP = ServerList.getWorld();
		rs.gamePort = ServerList.getPort();
	}
	public int LastPlayerAttacked()
	{
		return rs.lastplayerattacked;
	}
	public void ResetLastPlayerAttacked()
	{
		rs.lastplayerattacked = -1;
	}
	public void Login(String username, String password)
	{
		rs.login(username, password, false);
	}
	public boolean LoggedIn()
	{
		if (rs.ehc == 1)
			return true;
		else
			return false;
	}
	public void OpenUnbusyBank()
	{
		long T;
		while (!Bank())
		{
			int ID = GetUnbusyBanker();
			TalkToNPC(ID);
			T = TickCount();
			ResetLastServerMessage();
			while (TickCount() - T < 6000 && !QuestMenu() && !InLastServerMessage("busy") && Running())
				Wait(1);
			if (QuestMenu())
			{
				Answer(0);
				T = TickCount();
				while (TickCount() - T < 6000 && !Bank() && Running())
					Wait(1);
			}
		}
	}
	public void OpenBank()
	{
		long T;
		int BANKERS[] = new int[] { 95, 224, 268, 485, 540, 617 };
		while (!Bank())
		{
			int ID = GetNearestNPC(BANKERS);
			TalkToNPC(ID);
			T = TickCount();
			ResetLastServerMessage();
			while (TickCount() - T < 6000 && !QuestMenu() && !InLastServerMessage("busy") && Running())
				Wait(1);
			if (QuestMenu())
			{
				Println("Answering banker!");
				Answer(0);
				T = TickCount();
				while (TickCount() - T < 6000 && !Bank() && Running())
					Wait(1);
			}
		}
	}
	public boolean InStr(String str, String locate)
	{
		if (str.indexOf(locate) >= 0)
			return true;
		return false;
	}
	public String GetAnswer(int pos)
	{
		WaitForLoad();
		return rs.GetAnswer(pos);
	}
	public int GetDistance(int x1, int y1, int x2, int y2)
	{
		WaitForLoad();
		return rs.GetDistance(x1, y1, x2, y2);
	}
	public int GetHP()
	{
		WaitForLoad();
		return GetCurrentStat(3);
	}
	public int GetMaxHP()
	{
		WaitForLoad();
		return GetStat(3);
	}
	public int GetHPPercent()
	{
		WaitForLoad();
		return (GetHP() / GetMaxHP()) * 100;
	}
	public int Inv(int slot)
	{
		WaitForLoad();
		return rs.inv[slot];
	}
	public String GetItemCommand(int type)
	{
		WaitForLoad();
		return rs.GetItemCommand(type);
	}
	public String GetItemDesc(int type)
	{
		WaitForLoad();
		return rs.GetItemDesc(type);
	}
	public String GetItemName(int type)
	{
		WaitForLoad();
		return rs.GetItemName(type);
	}
	public String Username()
	{
		WaitForLoad();
		return rs.loginname;
	}
	public int GetPrayerLevel(int prayer)
	{
		WaitForLoad();
		return rs.GetPrayerLevel(prayer);
	}
	public int GetPrayerDrain(int prayer)
	{
		WaitForLoad();
		return rs.GetPrayerDrain(prayer);
	}
	public String GetNPCCommand(int type)
	{
		WaitForLoad();
		return rs.GetNPCCommand(type);
	}
	public String GetNPCDesc(int type)
	{
		WaitForLoad();
		return rs.GetNPCDesc(type);
	}
	public int GetNPCLevel(int type)
	{
		try
		{
			WaitForLoad();
			return rs.GetNPCLevel(type);
		}
		catch (Exception e) {}
		return 0;
	}
	public int GetNPCType(int id)
	{
		return rs.GetNPCType(id);
	}
	public int GetNPCMaxHP(int type)
	{
		WaitForLoad();
		return rs.GetNPCMaxHP(type);
	}
	public String GetNPCName(int type)
	{
		try
		{
			WaitForLoad();
			return rs.GetNPCName(type);
		}
		catch (Exception e) {}
		return "-EXCEPTION-";
	}
	public int GetAnswerCount()
	{
		WaitForLoad();
		return rs.GetAnswerCount();
	}
	public int GetItemCount()
	{
		WaitForLoad();
		return rs.itemCount;
	}
	public int GetNPCCount()
	{
		WaitForLoad();
		return rs.npcCount;
	}
	public int GetPlayerCount()
	{
		WaitForLoad();
		return rs.playerCount;
	}
	public int GetObjectCount()
	{
		WaitForLoad();
		return rs.mobCount;
	}
	public String GetObjectCommand1(int type)
	{
		WaitForLoad();
		return rs.GetObjectCommand1(type);
	}
	public String GetObjectCommand2(int type)
	{
		WaitForLoad();
		return rs.GetObjectCommand2(type);
	}
	public String GetObjectDesc(int type)
	{
		WaitForLoad();
		return rs.GetObjectDesc(type);
	}
	public String GetObjectName(int type)
	{
		WaitForLoad();
		return rs.GetObjectName(type);
	}
	public boolean InArea(int x1, int y1, int x2, int y2)
	{
		WaitForLoad();
		int x = GetX();
		int y = GetY();
		if (x >= x1 && x <= x2 && y >= y1 && y <= y2)
			return true;
		return false;
	}
	public boolean Wearable(int type)
	{
		WaitForLoad();
		return rs.Wearable(type);
	}
	public boolean IsWorn(int slot)
	{
		WaitForLoad();
		return rs.IsWorn(slot);
	}
	public boolean IsNPCAttackable(int type)
	{
		WaitForLoad();
		return rs.IsNPCAttackable(type);
	}
	public void WalkPath(int pathx[], int pathy[])
	{
		WaitForLoad();
		if (pathx.length != pathy.length)
		{
			Println("### WalkPath - COORDINATES NOT THE SAME LENGTH");
			return;
		}
		int startPoint = 0;
		int startDistance = 8000;
		for (int i = 0; i < pathx.length; i++)
			if (startDistance == 8000)
				startDistance = Distance(pathx[i],pathy[i]);
			else if (Distance(pathx[i],pathy[i]) < startDistance)
			{
				startPoint = i;
				startDistance = Distance(pathx[i],pathy[i]);
			}
		for (int i = startPoint; i < pathx.length; i++)
			Walk(pathx[i],pathy[i],Rand(8000,12000));
	}
	public void WalkPath(int pathx[], int pathy[], int ticks)
	{
		WaitForLoad();
		if (pathx.length != pathy.length)
		{
			Println("### WalkPath - COORDINATES NOT THE SAME LENGTH");
			return;
		}
		int startPoint = 0;
		int startDistance = 8000;
		for (int i = 0; i < pathx.length; i++)
			if (startDistance == 8000)
				startDistance = Distance(pathx[i],pathy[i]);
			else if (Distance(pathx[i],pathy[i]) < startDistance)
			{
				startPoint = i;
				startDistance = Distance(pathx[i],pathy[i]);
			}
		for (int i = startPoint; i < pathx.length; i++)
			Walk(pathx[i],pathy[i],ticks);
	}
	public void WalkPathReverse(int pathx[], int pathy[])
	{
		WaitForLoad();
		if (pathx.length != pathy.length)
		{
			Println("### WalkPath - COORDINATES NOT THE SAME LENGTH");
			return;
		}
		int startPoint = 0;
		int startDistance = 8000;
		for (int i = 0; i < pathx.length; i++)
			if (startDistance == 8000)
				startDistance = Distance(pathx[pathx.length-1-i],pathy[pathx.length-1-i]);
			else if (Distance(pathx[pathx.length-1-i],pathy[pathx.length-1-i]) < startDistance)
			{
				startPoint = i;
				startDistance = Distance(pathx[pathx.length-1-i],pathy[pathx.length-1-i]);
			}
		for (int i = startPoint; i < pathx.length; i++)
			Walk(pathx[pathx.length-1-i],pathy[pathx.length-1-i],Rand(8000,12000));
	}
	public void WalkPathReverse(int pathx[], int pathy[], int ticks)
	{
		WaitForLoad();
		if (pathx.length != pathy.length)
		{
			Println("### WalkPath - COORDINATES NOT THE SAME LENGTH");
			return;
		}
		int startPoint = 0;
		int startDistance = 8000;
		for (int i = 0; i < pathx.length; i++)
			if (startDistance == 8000)
				startDistance = Distance(pathx[pathx.length-1-i],pathy[pathx.length-1-i]);
			else if (Distance(pathx[pathx.length-1-i],pathy[pathx.length-1-i]) < startDistance)
			{
				startPoint = i;
				startDistance = Distance(pathx[pathx.length-1-i],pathy[pathx.length-1-i]);
			}
		for (int i = startPoint; i < pathx.length; i++)
			Walk(pathx[pathx.length-1-i],pathy[pathx.length-1-i],ticks);
	}
	public boolean CoordsAt(int pos[])
	{
		WaitForLoad();
		if (GetX() == pos[0] && GetY() == pos[1])
			return true;
		return false;
	}
	public boolean CoordsAt(int x, int y)
	{
		WaitForLoad();
		if (GetX() == x && GetY() == y)
			return true;
		return false;
	}
	public boolean IsWalking()
	{
		WaitForLoad();
		return ((rs.myplayer.anInt156 + 1) % 10 != rs.myplayer.anInt155);
	}
	public void EndScript()
	{
		rs.Running = false;
	}
	public boolean AutoLogin()
	{
		return rs.autologin;
	}
	public void EnableAutoLogin()
	{
		rs.autologin = true;
	}
	public void DisableAutoLogin()
	{
		rs.autologin = false;
	}
	public String Version()
	{
		return rs.VERSION;
	}
	public boolean NPCExists(int id)
	{
		return rs.NPCExists(id);
	}
	public boolean NPCInCombat(int id)
	{
		return rs.NPCInCombat(id);
	}
	public int InvCountByName(String name)
	{
		return rs.InvCountByName(name);
	}
	public int InvByName(String name)
	{
		return rs.InvByName(name);
	}
	public boolean IsStackable(int id)
	{
		return rs.IsStackable(id);
	}
	public int GetRandomNPC(int id)
	{
		return rs.GetRandomNPC(id);
	}
	public int GetRandomNPC(int id[])
	{
		return rs.GetRandomNPC(id);
	}
}