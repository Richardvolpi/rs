/*******************Canibalistic Commands************************/

public boolean Running()
public void Display(String Message, int x)
public void Wait(int ms) 
public void ChangeWorld(int server)
public void Logout()
public void AutoLogin(boolean to)
public int GetWorld()
public String GetAuthName()
public long GetMillies()
public void PrintLine(String msg)
public void Print(String msg)
public int StringToInteger(String str)
public int Rand(int from,int to)
public void Stop()

/**-------------------------This Player Methods-------------------------**/
public int GetX() 
public int GetY()
public boolean Walking() 
public boolean Sleeping()
public int Fatigue()
public int WhileSleepingFatigue()
public int Combat()
public int QuestPoints()
public int GetStat(int idx)
public int GetCurrentStat(int idx) 
public String GetStatName(int idx)
public int GetStatXp(int idx)
public int GetFightMode() 
public void SetFightMode(int idx)
public boolean MemberServer()
public String GetUsername()
public boolean LoggedIn()
public boolean InCombat()

/**-------------------------Walking and Location Methods-------------------------**/

public boolean Walk(int x, int y)
public boolean CanReach(int x, int y) 
public int WildLevel()
public boolean Wild()
public int GetDistance(int x, int y)
public void WalkTillThere(int x, int y)

/**-------------------------Object Methods-------------------------**/

public int CountObjects()
public int GetObjectType(int idx) 
public String GetObjectName(int type) 
public String GetObjectInfo(int type) 
public String GetObjectCmd1(int type)
public String GetObjectCmd2(int type) 
public int GetObjectAt(int x, int y)
public void AtObject(int x, int y) 
public void AtObject2(int x, int y)
public int[] GetNearestObject(int id)
public int[] GetNearestObject(int[] id)

/**-------------------------Wall Object Methods (including doors)-------------------------**/

public int CountWallObjects()
public int GetWallObjectType(int idx)
public String GetWallObjectName(int type) 
public String GetWallObjectInfo(int type) 
public String GetWallObjectCmd1(int type) 
public String GetWallObjectCmd2(int type) 
public int GetWallObjectAt(int x, int y) 
public void AtWallObject(int x, int y) 
public void AtWallObject2(int x, int y)
public int[] GetNearestWallObject(int id)

/**-------------------------Inventory methods-------------------------**/

public int CountInv()
public int CountInv(int idx) 
public int GetItemAtSlot(int idx)
public int FindSlot(int type) 
public String GetItemName(int type) 
public String GetItemInfo(int type) 
public String GetItemCommand(int type) 
public boolean CanWear(int type) 
public boolean CanStake(int type) 
public boolean IsFood(int type) 
public boolean IsItemWorn(int idx)
public void EquipItem(int idx)
public void UnequipItem(int idx) 
public void UseItem(int idx) 
public void DropItem(int idx)
public void UseItemWithItem(int item1position, int item2position) 
public void UseItemWithGroundItem(int itemposition, int groundItemIDX) 
public void UseItemWithObject(int itemposition, int objectIDX) 
public void UseItemWithWallObject(int itemposition, int wallObjectIDX)

/**-------------------------Bank methods-------------------------**/
 
public boolean IsBankOpen()
public void CloseBank() 
public int CountBank()
public int GetBankItemType(int idx) 
public int CountBank(int idx) 
public int FindBankSlot(int type)
public void DepositItem(int idx, int amount) 
public void WithdrawItem(int type, int amount)

/**-------------------------Shop Methods-------------------------**/

public boolean InShop() 
public void CloseShop() 
public int FindShopSlot(int type)
public int CountShop(int type)
public void SellItem(int type)
public int BuyItem(int type)

/**-------------------------Ground Item Methods-------------------------**/

public int CountGroundItems()
public int GetGroundItemType(int idx) 
public int GetGroundItemAt(int x, int y) 
public void PickUpItem(int idx) 
public void PickUpItemAt(int x, int y)
public int[] GetNearestItem(int id)
public int[] GetNearestItem(int[] id)

/**-------------------------NPC Methods-------------------------**/

public int CountNpc() 
public int GetNpcType(int idx) 
public String GetNpcName(int type) 
public String GetNpcInfo(int type)
public boolean NpcWalking(int idx)
public boolean NpcInCombat(int idx)
public boolean CanAttackNpc(int idx)
public int GetNpcCurrentHp(int idx) 
public int GetNpcMaxHp(int idx)
public void TalkToNpc(int idx)
public void TheiveNpc(int idx)
public void AttackNpc(int idx) 
public int[] GetNearestNpc(int id)
public int[] GetNearestNpc(int[] id)

/**-------------------------Prayer Methods-------------------------**/

public boolean IsPrayerOn(int type) 
public void togglePrayer(int type) 

/**-------------------------Magic Methods-------------------------**/

public void CastOnSelf(int type) 
public void CastOnItem(int type, int itemPos) 
public void CastOnGroundItem(int type, int groundItemPosition)
public void CastOnObject(int type, int objectPosition) 
public void CastOnWallObject(int type, int wallObjectPosition)
public void CastOnNpc(int type, int npcIDX)

/**-------------------------Quest Menu Methods-------------------------**/

public boolean QuestMenu() 
public void CloseQuestMenu()
public int CountQuestItems()
public String GetQuestMenuText(int idx)
public void AnswerByName(String s) 
public void Answer(int idx) 

/**-------------------------Last Message Methods-------------------------**/

public String GetLastServerMessage()
public String GetMyPlayerLastSaid()
public String GetLastChatMessage()
public String GetLastChatter()
public String GetLastPM()
public String GetLastPMer()
public void ResetMessages()




