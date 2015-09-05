import java.util.*;
import java.lang.reflect.Method;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Button;
import java.awt.GridLayout;

public abstract class Methods
	implements ActionListener
{
	protected mudclient rs;
	public Methods(mudclient rs)
	{
		this.rs = rs;
	}

	public void Main(String args[])
	{
	}

	public void OnServerMessage(String msg)
	{
	}

	public void OnChatMessage(String sender, String msg)
	{
	}

	public void OnKeyPress(long keycode)
	{
	}

	public void OnPrivateMessage(String sender, String msg)
	{
	}

	public boolean Running()
	{
		return rs.Running;
	}

	private void walkTo(int x, int y)
	{
		rs.fbk(rs.djd(), rs.dje(), x - rs.dni(), y - rs.dnj(), false);
	}

	private void t()
	{
		rs.needs = true;
		while(!rs.can) Wait(1);
	}

	private void f()
	{
		rs.needs = false;
	}
/* Constants */
public int[] Bankers = new int[] {
		95, 224, 268, 540, 617
	};

	public int[] Bones = new int[] {
		20, 413, 604, 814
	};

	public String[] Spells = new String[] {
		"Wind strike", "Confuse", "Water strike", "Enchant lvl-1 amulet", "Earth strike",
		"Weaken", "Fire strike", "Bones to bananas", "Wind bolt", "Curse",
		"Low level alchemy", "Water bolt", "Varrock teleport", "Enchant lvl-2 amulet", "Earth bolt",
		"Lumbridge teleport", "Telekinetic grab", "Fire bolt", "Falador teleport", "Crumble undead",
		"Wind blast","Superheat item", "Camelot teleport", "Water blast", "Enchant lvl-3 amulet",
		"Iban blast", "Ardougne teleport", "Earth blast", "High level alchemy", "Charge water orb",
		"Enchant lvl-4 amulet", "Watchtower teleport", "Fire blast", "Claws of Guthix", "Saradomin strike",
		"Flames of Zamorak", "Charge earth Orb", "Wind wave", "Charge Fire Orb", "Water wave",
		"Charge air Orb", "Vulnerability", "Enchant lvl-5 amulet", "Earth wave", "Enfeeble",
		"Fire wave", "Stun", "Charge"
	};
	public void Wait(long ms)
	{
		try
		{
			Thread.sleep(ms);
		}
		catch(Exception e)
		{
		}
	}

	public void End()
	{
		rs.Running = false;
		rs.scriptThread.stop();
	}
/* Trade Functions */
public boolean IsOffered(int id, int amount)
	{
		for(int i = 0; i < rs.dfd; i++)
			if(rs.dfe[i] == id && rs.dff[i] >= amount)
				return true;
		return false;
	}

	public boolean InTradeScreen1()
	{
		return rs.dge;
	}

	public boolean InTradeScreen2()
	{
		return rs.edl;
	}

	public void AcceptTrade1()
	{
		t();
		try {
			rs.dfh = true;
			rs.aag.hcn(55);
			rs.aag.hdl();
		} catch(Exception e) {}
		f();
	}

	public void AcceptTrade2()
	{
		t();
		try {
			rs.edm = true;
			rs.aag.hcn(104);
			rs.aag.hdl();
		} catch(Exception e) {}
		f();
	}

	public void DeclineTrade()
	{
		t();
		try {
			rs.ecl = false;
			rs.dge = false;
			rs.edl = false;
			rs.aag.hcn(230);
			rs.aag.hdl();
		} catch(Exception e) {}
		f();
	}

	public boolean MyTrade1Accepted()
	{
		return rs.dfh;
	}

	public boolean MyTrade2Accepted()
	{
		return rs.edm;
	}

	public boolean OpponentTradeAccpeted()
	{
		return rs.dfg;
	}

	public void AddToOffer(int id, int amount)
	{
		t();
		try {
			rs.AddToOffer(id, amount);
		} catch(Exception e) {}
		f();
	}

	/* Server Functions */
	public boolean ChangeWorld(int i)
	{
		return rs.changeServer(i);
	}

	public int GetWorld()
	{
		return Integer.parseInt(rs.Server);
	}

	public boolean LoggedIn()
	{
		return rs.loggedIn();
	}

	public void LogOut()
	{
		rs.logOut();
	}

	public void AutoLogin(boolean on)
	{
		rs.autoLogin = on;
	}

	public boolean IsAutoLogin()
	{
		return rs.autoLogin;
	}

	public void Login(String username, String password)
	{
		rs.abn(username, password, false);
	}

	public void HopServer()
	{
		if(LoggedIn())
		{
			while(LoggedIn())
			{
				LogOut();
				Wait(2000);
			}
			rs.HopServer(GetWorld() + 1 > 6 ? 1 : GetWorld() + 1);
		}
	}

	/* Npc Functions */
	public int CountNpcs()
	{
		return rs.countNpcs();
	}

	public int[] GetNpcById(int id)
	{
		int min[] = {-1,-1,-1};
		int mint = Integer.MAX_VALUE;
		for(int j = 0; j < CountNpcs(); j++)
		{
			if(rs.npcType(j) == id && !rs.npcInCombat(j))
			{
				int NpcX = rs.npcX(j);
				int NpcY = rs.npcY(j);
				int temp = Math.abs(NpcX - rs.getX()) + Math.abs(NpcY - rs.getY());
				if(temp < mint)
				{
					min[0] = j;
					min[1] = NpcX;
					min[2] = NpcY;
					mint = temp;
				}
			}
		}
		return min;
	}

	public int[] GetNpcById(int ids[])
	{
		int min[] = {-1,-1,-1};
		int mint = Integer.MAX_VALUE;
		for(int j = 0; j < CountNpcs(); j++)
		{
			if(rs.inArray(ids, rs.npcType(j)) && !rs.npcInCombat(j))
			{
				int NpcX = rs.npcX(j);
				int NpcY = rs.npcY(j);
				int temp = Math.abs(NpcX - rs.getX()) + Math.abs(NpcY - rs.getY());
				if(temp < mint)
				{
					min[0] = j;
					min[1] = NpcX;
					min[2] = NpcY;
					mint = temp;
				}
			}
		}
		return min;
	}

	public int[] GetAllNpcById(int id)
	{
		int min[] = {-1,-1,-1};
		int mint = Integer.MAX_VALUE;
		for(int j = 0; j < CountNpcs(); j++)
		{
			if(rs.npcType(j) == id)
			{
				int NpcX = rs.npcX(j);
				int NpcY = rs.npcY(j);
				int temp = Math.abs(NpcX - rs.getX()) + Math.abs(NpcY - rs.getY());
				if(temp < mint)
				{
					min[0] = j;
					min[1] = NpcX;
					min[2] = NpcY;
					mint = temp;
				}
			}
		}
		return min;
	}

	public int[] GetAllNpcById(int ids[])
	{
		int min[] = {-1,-1,-1};
		int mint = Integer.MAX_VALUE;
		for(int j = 0; j < CountNpcs(); j++)
		{
			if(rs.inArray(ids, rs.npcType(j)))
			{
				int NpcX = rs.npcX(j);
				int NpcY = rs.npcY(j);
				int temp = Math.abs(NpcX - rs.getX()) + Math.abs(NpcY - rs.getY());
				if(temp < mint)
				{
					min[0] = j;
					min[1] = NpcX;
					min[2] = NpcY;
					mint = temp;
				}
			}
		}
		return min;
	}

	public boolean NpcAttackable(int id)
	{
		return rs.npcAttackable(id);
	}

	public boolean NpcInCombat(int index)
	{
		return rs.npcInCombat(index);
	}

	public boolean NpcHealthBarShowing(int index)
	{
		return rs.npcHpBarShowing(index);
	}

	public String NpcName(int id)
	{
		return rs.npcName(id);
	}

	public String NpcDesc(int id)
	{
		return rs.npcDesc(id);
	}
	/*
	public int NpcMaxHits(int id)
	{

	}
	*/
	public int NpcCombat(int id)
	{
		return rs.npcCombat(id);
	}

	public void AttackNpc(int index)
	{
		t();
		try
		{
			walkTo(rs.npcX(index), rs.npcY(index));
			rs.aag.hcn(190);
			rs.aag.hdj(rs.npcId(index));
			rs.aag.hdl();
		}
		catch(Exception e)
		{
		}
		f();
	}

	public void TalkToNpc(int index)
	{
		t();
		try
		{
			walkTo(rs.npcX(index), rs.npcY(index));
			rs.aag.hcn(153);
			rs.aag.hdj(rs.npcId(index));
			rs.aag.hdl();
		}
		catch(Exception e)
		{
		}
		f();
	}

	public void ThieveNpc(int index)
	{
		t();
		try
		{
			walkTo(rs.npcX(index), rs.npcY(index));
			rs.aag.hcn(202);
			rs.aag.hdj(rs.npcId(index));
			rs.aag.hdl();
		}
		catch(Exception e)
		{
		}
		f();
	}

	public int NpcId(int index)
	{
		return rs.npcType(index);
	}

	public int NpcX(int index)
	{
		return rs.npcX(index);
	}

	public int NpcY(int index)
	{
		return rs.npcY(index);
	}

	public void UseOnNpc(int pos, int index)
	{
		t();
		try
		{
			walkTo(rs.npcX(index), rs.npcY(index));
			rs.aag.hcn(135);
			rs.aag.hdj(rs.npcId(index));
			rs.aag.hdj(pos);
			rs.aag.hdl();
		}
		catch(Exception e)
		{
		}
		f();
	}

	/* Communication functions */

	public void Speak(String s)
	{
		t();
		rs.speak(s);
		f();
	}

	public void SendPm(String to, String message)
	{
		t();
		rs.sendPm(to,message);
		f();
	}

	public void AddToFriends(String player)
	{
		t();
		rs.addToFriends(player);
		f();
	}

	public void AddToIgnore(String player)
	{
		t();
		rs.addToIgnore(player);
		f();
	}

	public String[] GetFriendList()
	{
		return rs.getFriendsList();
	}

	public String[] GetIgnoreList()
	{
		return rs.getIgnoreList();
	}

	public void RemoveFromFriends(String player)
	{
		t();
		rs.RemoveFromFriends(player);
		f();
	}

	public void RemoveFromIgnore(String player)
	{
		t();
		rs.RemoveFromIgnore(player);
		f();
	}

	public boolean IsOnFriendsList(String player)
	{
		return rs.isOnFriendsList(player);
	}

	public boolean IsOnIgnoreList(String player)
	{
		return rs.isOnIgnoreList(player);
	}

	/* Npc Interaction Functions */

	public boolean QuestMenu()
	{
		return rs.questMenu();
	}

	public int CountQuestMenu()
	{
		if(QuestMenu())
		{
			return rs.countQuestMenu();
		}
		return -1;
	}

	public String GetQuestOption(int i)
	{
		if(QuestMenu())
		{
			return rs.getQuestOption(i);
		}
		return "-1";
	}

	public void Answer(int i)
	{
		t();
		try
		{
			if(QuestMenu())
			{
				rs.aag.hcn(116);
				rs.aag.hdb(i);
				rs.aag.hdl();
				rs.dck = false;
			}
		}
		catch(Exception e)
		{
		}
		f();
	}

	/* Banking and shopping */

	public void Withdraw(int id, int amount)
	{
		t();
		try
		{
			if(InBank())
			{
				rs.aag.hcn(22);
				rs.aag.hdj(id);
				rs.aag.hdj(amount);
				rs.aag.hdh(0x12345678);
				rs.aag.hdl();
			}
		}
		catch(Exception e)
		{
		}
		f();
	}

	public void Deposit(int id, int amount)
	{
		t();
		try
		{
			if(InBank())
			{
				rs.aag.hcn(23);
				rs.aag.hdj(id);
				rs.aag.hdj(amount);
				rs.aag.hdh(0x87654321);
				rs.aag.hdl();
			}
		}
		catch(Exception e)
		{
		}
		f();
	}

	public boolean ItemInBank(int id)
	{
		if(InBank())
		{
			return rs.itemInBank(id);
		}
		else
		{
			return false;
		}
	}

	public int CountInBank(int id)
	{
		if(InBank())
		{
			return rs.countBank(id);
		}
		else
		{
			return -1;
		}
	}

	public boolean InBank()
	{
		return rs.inBank();
	}

	public void CloseBank()
	{
		t();
		try
		{
			if(InBank())
			{
				rs.aag.hcn(212);
				rs.aag.hdl();
				rs.dmb = false;
			}
		}
		catch(Exception e)
		{
		}
		f();
	}

	public boolean InShop()
	{
		return rs.inShop();
	}

	public void CloseShop()
	{
		t();
		try
		{
			if(InShop())
			{
				rs.aag.hcn(166);
				rs.aag.hdl();
				rs.dmk = false;
			}
		}
		catch(Exception e)
		{
		}
		f();
	}

	public int FindShopSlot(int type)
	{
		for(int i = 0; i < 39; i++)
		{
			if(rs.efa[i] == type)
			{
				return i;
			}
		}
		return -1;
	}

	public int ShopBuyPrice(int type)
	{
		if(InShop())
		{
			try
			{
				int i = FindShopSlot(type);
				int mod = rs.dmd + rs.efc[i];
				if(mod < 10)
				{
					mod = 10;
				}
				return (mod * e.aif[type]) / 100;
			}
			catch(Exception e)
			{
			}
		}
		return -1;
	}

	public void BuyShopItem(int id)
	{
		t();
		if(InShop())
		{
			//int idx = FindShopSlot(id);
			int price = ShopBuyPrice(id);
			if(price != -1)
			{
				rs.aag.hcn(236);
				rs.aag.hdj(id);
				rs.aag.hdh(price);
				rs.aag.hdl();
			}
		}
		f();
	}

	public int ShopSellPrice(int type)
	{
		if(InShop())
		{
			try
			{
				int i = FindShopSlot(type);
				int mod = rs.dmc + rs.efc[i];
				if(mod < 10)
				{
					mod = 10;
				}
				return (mod * e.aif[type]) / 100;
			}
			catch(Exception e)
			{
			}
		}
		return -1;
	}

	public void SellShopItem(int id)
	{
		t();
		if(InShop())
		{
			int x = ShopSellPrice(id);
			if(x != -1)
			{
				rs.aag.hcn(221);
				rs.aag.hdj(id);
				rs.aag.hdh(x);
				rs.aag.hdl();
			}
		}
		f();
	}

	public int CountShop(int id)
	{
		if(FindShopSlot(id) != -1)
			return rs.efb[FindShopSlot(id)];
		return -1;
	}

	/* Status Functions */

	public int GetPid()
	{
		return rs.getPid();
	}

	public boolean Sleeping()
	{
		return rs.sleeping();
	}

	public void SetMode(int i)
	{
		t();
		rs.setMode(i);
		f();
	}

	public int GetMode()
	{
		return rs.getMode();
	}

	public int GetFatigue()
	{
		return rs.getFatigue();
	}

	public long GetExp(int i)
	{
		return rs.getExp(i);
	}

	public String GetLvlName(int i)
	{
		return rs.getLvlName(i);
	}

	public int GetCurLvl(int i)
	{
		return rs.getCurLvl(i);
	}

	public int GetMaxLvl(int i)
	{
		return rs.getMaxLvl(i);
	}

	public int GetCombatLvl()
	{
		return rs.getCombatLvl();
	}

	public int GetX()
	{
		return rs.getX();
	}

	public int GetY()
	{
		return rs.getY();
	}

	public boolean InCombat()
	{
		return rs.inCombat();
	}

	public boolean HealthBarShowing()
	{
		return rs.healthBarShowing();
	}

	public int HitsPercent()
	{
		return (GetCurLvl(3) * 100) / GetMaxLvl(3);
	}

	public boolean IsPrayerOn(int i)
	{
		return rs.isPrayerOn(i);
	}

	public void PrayerOn(int i)
	{
		t();
		rs.prayerOn(i);
		f();
	}

	public void PrayerOff(int i)
	{
		t();
		rs.prayerOff(i);
		f();
	}

	public int PrayerLvl(int i)
	{
		return rs.prayerLvl(i);
	}

	public boolean QuestDone(int i)
	{
		return rs.questDone(i);
	}

	public boolean IsWalking()
	{
		return rs.isWalking();
	}

	/* Inventory Functions */

	public int CountInv()
	{
		return rs.countInv();
	}

	public void UseItemWithItem(int pos1, int pos2)
	{
		try
		{
			rs.aag.hcn(91);
			rs.aag.hdj(pos1);
			rs.aag.hdj(pos2);
			rs.aag.hdl();
		}
		catch(Exception e)
		{
		}
	}

	public int CountInv(int id)
	{
		return rs.countInv(id);
	}

	public int CountInv(int[] id)
	{
		return rs.countInv(id);
	}

	public boolean InInv(int id)
	{
		return rs.inInv(id);
	}

	public int GetItemPos(int id)
	{
		return rs.getItemPos(id);
	}

	public void UseItem(int pos)
	{
		t();
		if(pos >= 0 && pos < CountInv())
		{
			rs.aag.hcn(90);
			rs.aag.hdj(pos);
			rs.aag.hdl();
		}
		f();
	}

	public void DropItem(int pos)
	{
		t();
		if(pos >= 0 && pos < CountInv())
		{
			rs.aag.hcn(246);
			rs.aag.hdj(pos);
			rs.aag.hdl();
		}
		f();
	}

	public boolean IsWearable(int id)
	{
		return rs.isWearable(id);
	}

	public boolean WearingItem(int pos)
	{
		return rs.wearingItem(pos);
	}

	public void WearItem(int pos)
	{
		t();
		if(pos >= 0 && pos < CountInv())
		{
			rs.aag.hcn(169); //here
			rs.aag.hdj(pos);
			rs.aag.hdl();
		}
		f();
	}

	public void RemoveItem(int pos)
	{
		t();
		if(pos >= 0 && pos < CountInv())
		{
			rs.aag.hcn(170);
			rs.aag.hdj(pos);
			rs.aag.hdl();
		}
		f();
	}

	public boolean CanEat(int id)
	{
		return rs.canEat(id);
	}

	public int InvItemId(int pos)
	{
		return rs.invItemId(pos);
	}

	/* Movement functions */

	public void WalkTo(int x, int y)
	{
		t();
		try
		{
			walkTo(x, y);
			rs.emb();
		}
		catch(Exception e)
		{
		}
		f();
	}

	public void WalkToWait(int x, int y)
	{
		while(GetX() != x && GetY() != y)
		{
			WalkTo(x, y);
			Wait(1200);
		}
	}

	public void ForceWalkTo(int x, int y)
	{
		t();
		try
		{
			walkTo(x, y);
			rs.aag.hcn(247);
			rs.aag.hdj(x);
			rs.aag.hdj(y);
			rs.aag.hdl();
		}
		catch(Exception e)
		{
		}
		f();
	}

	public void ForceWalkToWait(int x, int y)
	{
		while(GetX() != x && GetY() != y)
		{
			ForceWalkTo(x, y);
			Wait(1200);
		}
	}

	public boolean IsReachable(int x, int y)
	{
		t();
		boolean b = rs.isReachable(x,y);
		f();
		return b;
	}

	/* Wall Object Functions */


	public void UseOnWallObject(int pos, int x, int y)
	{
		t();
		try
		{
			rs.eml(x - rs.dni(), y - rs.dnj(), rs.ecn(GetWallObjectByXY(x,y)));
			rs.aag.hcn(161);
			rs.aag.hdj(x);
			rs.aag.hdj(y);
			rs.aag.hdb(rs.ecn(GetWallObjectByXY(x,y)));
			rs.aag.hdj(pos);
            rs.aag.hdl();
		}
		catch(Exception e)
		{
		}
		f();
	}

	public int CountWallObjects()
	{
		return rs.countWallObjects();
	}

	public int[] GetWallObjectById(int id)
	{
		int min[] = {-1,-1,-1};
		int mint = Integer.MAX_VALUE;
		for(int j = 0; j < CountWallObjects(); j++)
			if(rs.wallObjectType(j) == id)
			{
				int WallObjectX = rs.wallObjectX(j);
				int WallObjectY = rs.wallObjectY(j);
				int temp = Math.abs(WallObjectX - GetX()) + Math.abs(WallObjectY - GetY());
				if(temp < mint)
				{
					min[0] = j;
					min[1] = WallObjectX;
					min[2] = WallObjectY;
					mint = temp;
				}
			}
		return min;
	}

	private int GetWallObjectByXY(int x, int y)
		{
			for(int j = 0; j < CountWallObjects(); j++)
				if(rs.wallObjectX(j) == x && rs.wallObjectY(j) == y)
					return j;
			return -1;
	}

	public int[] GetWallObjectById(int[] id)
	{
		int min[] = {-1,-1,-1};
		int mint = Integer.MAX_VALUE;
		for(int j = 0; j < CountWallObjects(); j++)
			if(rs.inArray(id, rs.wallObjectType(j)))
			{
				int WallObjectX = rs.wallObjectX(j);
				int WallObjectY = rs.wallObjectY(j);
				int temp = Math.abs(WallObjectX - GetX()) + Math.abs(WallObjectY - GetY());
				if(temp < mint)
				{
					min[0] = rs.wallObjectType(j);
					min[1] = WallObjectX;
					min[2] = WallObjectY;
					mint = temp;
				}
			}
		return min;
	}

	public int GetWallObjectByCoords(int x, int y)
	{
		for(int j = 0; j < CountWallObjects(); j++)
			if(rs.wallObjectX(j) == x && rs.wallObjectY(j) == y)
				return j;
		return -1;
	}

	public int GetIdWallObject(int x, int y)
	{
		for(int j = 0; j < CountWallObjects(); j++)
			if(rs.wallObjectX(j) == x && rs.wallObjectY(j) == y)
				return rs.wallObjectType(j);
		return -1;
	}

	public void AtWallObject(int x, int y)
	{
		t();
		try
		{
			rs.eml(x - rs.dni(), y - rs.dnj(),GetWallObjectByCoords(x,y));
			rs.aag.hcn(14);
			rs.aag.hdj(x);
			rs.aag.hdj(y);
			rs.aag.hdb(0);
			rs.aag.hdl();
			
		}
		catch(Exception e)
		{
		}
		f();
	}
		public void OpenDoor(int x, int y, int dir)
	{
		t();
		try
		{
			rs.eml(x - rs.dni(), y - rs.dnj(),GetWallObjectByCoords(x,y));
			rs.aag.hcn(14);
			rs.aag.hdj(x);
			rs.aag.hdj(y);
			rs.aag.hdb(dir);
			rs.aag.hdl();
			
		}
		catch(Exception e)
		{
		}
		f();
	}
public void CloseDoor(int x, int y, int dir)
	{
		t();
		try
		{
			rs.eml(x - rs.dni(), y - rs.dnj(),GetWallObjectByCoords(x,y));
			rs.aag.hcn(127);
			rs.aag.hdj(x);
			rs.aag.hdj(y);
			rs.aag.hdb(dir);
			rs.aag.hdl();
			
		}
		catch(Exception e)
		{
		}
		f();
	}

public void wallObjectCmd1(int i) {
 try {
             t(); 
             	        rs.dga[rs.ejf] = 320;
                                rs.dfl[rs.ejf] = rs.dhg[i];
                                rs.dfm[rs.ejf] = rs.dhh[i];
                                rs.djk[rs.ejf] = rs.ecn[i];
	                   rs.emg(rs.ejf++);
             
     } catch(Exception e) {  }    

}
	public void AtWallObject2(int x, int y)
	{
		t();
		try
		{
			rs.fah(x - rs.dni(), y - rs.dnj(), rs.elb(GetObjectIndex(x,y)), rs.ela(GetWallObjectByCoords(x,y)));
			rs.aag.hcn(127);
			rs.aag.hdj(x);
			rs.aag.hdj(y);
			rs.aag.hdb(GetWallObjectByCoords(x,y));
			rs.aag.hdl();
		}
		catch(Exception e)
		{
		}
		f();
	}

	public int WallObjectX(int index)
	{
		return rs.wallObjectX(index);
	}

	public int WallObjectY(int index)
	{
		return rs.wallObjectY(index);
	}

	public int WallObjectId(int index)
	{
		return rs.wallObjectType(index);
	}

	public String WallObjectName(int id)
	{
		return rs.wallObjectName(id);
	}

	public String WallObjectDesc(int id)
	{
		return rs.wallObjectDesc(id);
	}

	/* Item Functions */

	public void UseItemOnGItem(int pos, int x, int y, int id)
	{
		t();
		try
		{
			rs.fan(rs.djd(), rs.dje(), x - rs.dni(), y - rs.dnj(), true);
			rs.aag.hcn(53); //here
			rs.aag.hdj(x);
			rs.aag.hdj(y);
			rs.aag.hdj(id);
			rs.aag.hdj(pos);
			rs.aag.hdl();
		}
		catch(Exception e)
		{
		}
		f();
	}

	public int CountItems()
	{
		return rs.countItems();
	}

	public String ItemName(int id)
	{
		return rs.itemName(id);
	}

	public String ItemDesc(int id)
	{
		return rs.itemDesc(id);
	}

	public int[] GetItemById(int id)
	{
		int min[] = {-1,-1,-1};
		int mint = Integer.MAX_VALUE;
		for(int j = 0; j < CountItems(); j++)
			if(rs.getItemType(j) == id)
			{
				int ItemX = rs.getItemX(j);
				int ItemY = rs.getItemY(j);
				int temp = Math.abs(ItemX - GetX()) + Math.abs(ItemY - GetY());
				if(temp < mint)
				{
					min[0] = rs.getItemType(j);
					min[1] = ItemX;
					min[2] = ItemY;
					mint = temp;
				}
			}
		return min;
	}

	public int GetItemByCoords(int x, int y)
	{
		for(int j = 0; j < CountItems(); j++)
			if(rs.getItemX(j) == x && rs.getItemY(j) == y)
				return j;
		return -1;
	}

	public int[] GetItemById(int[] ids)
	{
		int min[] = {-1,-1,-1};
		int mint = Integer.MAX_VALUE;
		for(int j = 0; j < CountItems(); j++)
			if(rs.inArray(ids,rs.getItemType(j)))
			{
				int ItemX = rs.getItemX(j);
				int ItemY = rs.getItemY(j);
				int temp = Math.abs(ItemX - GetX()) + Math.abs(ItemY - GetY());
				if(temp < mint)
				{
					min[0] = rs.getItemType(j);
					min[1] = ItemX;
					min[2] = ItemY;
					mint = temp;
				}
			}
		return min;
	}

	public void PickupItem(int x, int y)
	{
		t();
		try
		{
			walkTo(x, y);
			rs.aag.hcn(247);
			rs.aag.hdj(x);
			rs.aag.hdj(y);
			rs.aag.hdj(rs.getItemType(GetItemByCoords(x,y)));
			rs.aag.hdl();
		}
		catch(Exception e)
		{
		}
		f();
	}

	public void PickupItem(int x, int y, int id)
	{
		t();
		try
		{
			walkTo(x, y);
			rs.aag.hcn(247);
			rs.aag.hdj(x);
			rs.aag.hdj(y);
			rs.aag.hdj(id);
			rs.aag.hdl();
		}
		catch(Exception e)
		{
		}
		f();
	}

	public void PickupItemById(int id)
	{
		int[] inf = GetItemById(id);
		if(inf[0] != -1)
		{
			t();
			try
			{
				walkTo(inf[1], inf[2]);
				rs.aag.hcn(247);
				rs.aag.hdj(inf[1]);
				rs.aag.hdj(inf[2]);
				rs.aag.hdj(id);
				rs.aag.hdl();
			}
			catch(Exception e)
			{
			}
			f();
		}
	}

	public void PickupItemById(int[] ids)
	{
		int[] inf = GetItemById(ids);
		if(inf[0] != -1)
		{
			t();
			try
			{
				walkTo(inf[1], inf[2]);
				rs.aag.hcn(247);
				rs.aag.hdj(inf[1]);
				rs.aag.hdj(inf[2]);
				rs.aag.hdj(rs.getItemType(inf[0]));
				rs.aag.hdl();
			}
			catch(Exception e)
			{
			}
			f();
		}
	}

	public int ItemX(int index)
	{
		return rs.getItemX(index);
	}

	public int ItemY(int index)
	{
		return rs.getItemY(index);
	}

	public int ItemId(int index)
	{
		return rs.getItemType(index);
	}

	/* Object Functions */

	public void UseOnObject(int pos, int x, int y)
	{
		t();
		try
		{
		if(GetObjectIndex(x,y) != -1)
			{

		rs.fah(x - rs.dni(), y - rs.dnj(), rs.elb(GetObjectIndex(x,y)), rs.ela(GetObjectIndex(x,y)));
			rs.aag.hcn(115);
			rs.aag.hdj(x);
			rs.aag.hdj(y);
			rs.aag.hdj(pos);
			rs.aag.hdl();
		}
		}
		catch(Exception e)
		{
		}
		f();
	}

	public int CountObjects()
	{
		return rs.countObjects();
	}

	public int[] GetObjectById(int id)
	{
		int min[] = {-1,-1,-1};
		int mint = Integer.MAX_VALUE;
		for(int j = 0; j < CountObjects(); j++)
			if(rs.getObjectType(j) == id)
			{
				int ObjectX = rs.getObjectX(j);
				int ObjectY = rs.getObjectY(j);
				int temp = Math.abs(ObjectX - GetX()) + Math.abs(ObjectY - GetY());
				if(temp < mint) {
					min[0] = rs.getObjectType(j);
					min[1] = ObjectX;
					min[2] = ObjectY;
					mint = temp;
				}
			}
		return min;
	}

	public int GetObjectIndex(int x, int y)
	{
		for(int i = 0; i < CountObjects(); i++)
			if(ObjectX(i) == x && ObjectY(i) == y)
				return i;
		return -1;
	}

	public int[] GetObjectById(int[] ids)
	{
		int min[] = {-1,-1,-1};
		int mint = Integer.MAX_VALUE;
		for(int j = 0; j < CountObjects(); j++)
			if(rs.inArray(ids, rs.getObjectType(j)))
			{
				int ObjectX = rs.getObjectX(j);
				int ObjectY = rs.getObjectY(j);
				int temp = Math.abs(ObjectX - GetX()) + Math.abs(ObjectY - GetY());
				if(temp < mint) {
					min[0] = rs.getObjectType(j);
					min[1] = ObjectX;
					min[2] = ObjectY;
					mint = temp;
				}
			}
		return min;
	}

	public void AtObject(int x, int y)
	{
		t();
		try
		{
			if(GetObjectIndex(x,y) != -1)
			{
				rs.fah(x - rs.dni(), y - rs.dnj(), rs.elb(GetObjectIndex(x,y)), rs.ela(GetObjectIndex(x,y)));
				rs.aag.hcn(136);
				rs.aag.hdj(x);
				rs.aag.hdj(y);
				rs.aag.hdl();
			}
		}
		catch(Exception e)
		{
		}
		f();
	}
	


	public void AtObject2(int x, int y)
	{
		t();
		try
		{
		if(GetObjectIndex(x,y) != -1)
			{
			rs.fah(x - rs.dni(), y - rs.dnj(), rs.elb(GetObjectIndex(x,y)), rs.ela(GetObjectIndex(x,y)));
			rs.aag.hcn(79);
			rs.aag.hdj(x);
			rs.aag.hdj(y);
			rs.aag.hdl();
			}
		}
		catch(Exception e)
		{
		}
		f();
	}

	public int GetIdObject(int x, int y)
	{
		for(int j = 0; j < CountObjects(); j++)
			if(rs.getObjectX(j) == x && rs.getObjectY(j) == y)
				return rs.getObjectType(j);
		return -1;
	}

	public int ObjectX(int index)
	{
		return rs.getObjectX(index);
	}

	public int ObjectY(int index)
	{
		return rs.getObjectY(index);
	}

	public int ObjectId(int index)
	{
		return rs.getObjectType(index);
	}

	public String ObjectName(int id)
	{
		return rs.getObjectName(id);
	}

	public String ObjectDesc(int id)
	{
		return rs.getObjectName(id);
	}

	public boolean IsObjectAt(int id, int x, int y)
	{
		if(GetIdObject(x, y) == id)
			return true;
		return false;
	}

	public boolean IsObjectAt(int[] ids, int x, int y)
	{
		if(rs.inArray(ids, GetIdObject(x,y)))
			return true;
		return false;
	}

	/* Setup Functions */
public int[] StrArrayToIntArray(String[] s)
	{
		int i[] = new int[s.length];
		for(int i1 = 0; i1 < s.length; i1++)
			i[i1] = Integer.parseInt(s[i1]);
		return i;
	}

	public String[] IntArrayToStrArray(int[] i)
	{
		String s[] = new String[i.length];
		for(int i1 = 0; i1 < s.length; i1++)
			s[i1] = Integer.toString(i[i1]);
		return s;
	}
	public void IncreaseZoom(int i)
	{
		rs.increaseZoom(i);
	}

	public void DecreaseZoom(int i)
	{
		rs.decreaseZoom(i);
	}

	public void SetZoom(int i)
	{
		rs.setZoom(i);
	}

	public void SetFog(boolean on)
	{
		rs.fog = on;
	}

	public String GetInput(String message)
	{
		return javax.swing.JOptionPane.showInputDialog(message);
	}

	private int inputValue = -1;
	private String[] optionLookup = new String[0];
	public int GetOption(String question, String[] options)
	{
		optionLookup = options;
		inputValue = -1;
		JFrame frame = new JFrame(question);
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(options.length,1));
		for(int i = 0; i < options.length; i++)
		{
			Button b = new Button(options[i]);
			b.addActionListener(this);
			p.add(b);
		}
		frame.resize(300,300);
		frame.setResizable(false);
		frame.add(new JScrollPane(p));
		frame.setVisible(true);
		while(inputValue == -1)
			Wait(10);
		frame.dispose();
		return inputValue;
	}

	public void actionPerformed(ActionEvent e)
	{
		if(InArray(optionLookup, e.getActionCommand()))
			for(int i = 0; i < optionLookup.length; i++)
				if(optionLookup[i].equals(e.getActionCommand()))
					inputValue = i;
	}

	public String GetRsName()
	{
		return rs.getRsName();
	}

	public int DistanceTo(int x, int y)
	{
		return Math.abs(x - GetX()) + Math.abs(y - GetY());
	}

	public int DistanceTo(int x1, int y1, int x2, int y2)
	{
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}

	public void UnlockMode()
	{
		rs.unlockMode();
	}

	public void LockMode(int i)
	{
		if(i >= 0 && i < 4)
		{
			rs.lockMode(i);
		}
	}

	public void Die(String s)
	{
		System.out.println(s);
		System.exit(0);
	}

	public void Die()
	{
		System.exit(0);
	}

	public void Display(String s)
	{
		rs.display(s);
	}

	public void Display(int i)
	{
		rs.display(String.valueOf(i));
	}

	private Random r = new Random();

	public int Rand(int from, int to)
	{
		return from + r.nextInt(to);
	}

	public long GetMillis()
	{
		return System.currentTimeMillis();
	}

	public String IntToStr(int i)
	{
		return String.valueOf(i);
	}

	public String LongToStr(long l)
	{
		return String.valueOf(l);
	}

	public int StrToInt(String s)
	{
		try
		{
			return Integer.parseInt(s);
		}
		catch(Exception e)
		{
			return -1;
		}
	}

	public boolean IsInStr(String string, String findme)
	{
		if(string.indexOf(findme) != -1)
			return true;
		return false;
	}

	public boolean InArray(int[] iarray, int i)
	{
		for(int x = 0; x < iarray.length; x++)
			if(iarray[x] == i)
				return true;
		return false;
	}

	public boolean InArray(String[] sarray, String s)
	{
		for(int i = 0; i < sarray.length; i++)
			if(sarray[i].equalsIgnoreCase(s))
				return true;
		return false;
	}

	public int GetAverage(int[] values)
	{
		int val = 0;
		for(int i = 0; i < values.length; i++)
			val += values[i];
		return val / values.length;
	}

	public void SaveScreenShot(String s)
	{
		try
		{
			rs.screenShot(s);
		}
		catch(Exception e)
		{
		}
	}

	public String GetAuthName()
	{
		return rs.authName;
	}

	/* Casting Functions */

	public void CastOnNpc(int spell, int index)
	{
		t();
		if(index != -1 && spell >= 0 && spell <= 47)
		{
			try
			{
				rs.aag.hcn(50);
				rs.aag.hdj(rs.npcId(index));
				rs.aag.hdj(spell);
				rs.aag.hdl();
			}
			catch(Exception e)
			{
			}
		}
		f();
	}

	public void CastOnItem(int spell, int pos)
	{
		t();
		try
		{
			rs.aag.hcn(4); //here
			rs.aag.hdj(pos);
			rs.aag.hdj(spell);
			rs.aag.hdl();
		}
		catch(Exception e)
		{
		}
		f();
	}

	public void CastOnGItem(int spell, int id, int x, int y)
	{
		t();
		try
		{
			rs.fan(rs.djd(), rs.dje(), x - rs.dni(), y - rs.dnj(), true);
			rs.aag.hcn(249);
			rs.aag.hdj(x);
			rs.aag.hdj(y);
			rs.aag.hdj(id);
			rs.aag.hdj(spell);
			rs.aag.hdl();
		}
		catch(Exception e)
		{
		}
		f();
	}

	public void CastOnSelf(int spell)
	{
		t();
		try
		{
			rs.aag.hcn(137);
			rs.aag.hdj(spell);
			rs.aag.hdl();
		}
		catch(Exception e)
		{
		}
		f();
	}

	/* Player Functions */
public void TradePlayer(int id)
	{
		t();
		int[] pinfo = GetPlayerById(id);
		if(pinfo[0] != -1)
		{
			try {
				rs.aag.hcn(142);
				rs.aag.hdj(id);
				rs.aag.hdl();
			}
			catch(Exception e) {}
		}
		f();
	}
	public int[] GetPlayerByName(String name)
	{
		int[] ret = {-1,-1,-1};
		for(int i = 0; i < rs.dgm; i++)
		{
			if(rs.playerName(i).equalsIgnoreCase(name))
			{
				ret[0] = rs.deh[i].gmf;
				ret[1] = rs.playerX(i);
				ret[2] = rs.playerY(i);
				return ret;
			}
		}
		return ret;
	}




	public int LastAttackedPlayer()
	{
		return rs.lastPlayerAttacked;
	}

	public int[] GetPlayerById(int id)
	{
		return rs.getPlayerById(id);
	}

	public int PlayerX(int index)
	{
		return rs.playerX(index);
	}

	public int PlayerY(int index)
	{
		return rs.playerY(index);
	}

	public int PlayerDestX(int index)
	{
		return rs.playerDestX(index);
	}

	public int PlayerDestY(int index)
	{
		return rs.playerDestY(index);
	}

	public String PlayerName(int index)
	{
		return rs.playerName(index);
	}

	public int PlayerCombatLvl(int index)
	{
		return rs.playerCombatLvl(index);
	}

	public void AttackPlayer(int id)
	{
		t();
		int[] pinfo = GetPlayerById(id);
		if(pinfo[0] != -1)
		{
			try
			{
				walkTo(pinfo[1], pinfo[2]);
				rs.aag.hcn(171);
				rs.aag.hdj(id);
				rs.aag.hdl();
			}
			catch(Exception e)
			{
			}
		}
		f();
	}

	public void CastOnPlayer(int spell, int id)
	{
		t();
		try
		{
			rs.aag.hcn(229);
			rs.aag.hdj(id);
			rs.aag.hdj(spell);
			rs.aag.hdl();
		}
		catch(Exception e)
		{
		}
		f();
	}

	public boolean PlayerInCombat(int index)
	{
		return rs.playerInCombat(index);
	}

	public boolean PlayerIsWalking(int index)
	{
		return rs.isPlayerWalking(index);
	}

	public boolean PlayerHpBarShowing(int index)
	{
		return rs.playerHpBarShowing(index);
	}
}