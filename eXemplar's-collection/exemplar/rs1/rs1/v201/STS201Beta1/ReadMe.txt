--: STS by Reines :--
----------------------
This is a quick release just to see peoples opinions, it is nowhere near finished and still has bugs.
Also it needs a good name. The idea was to make it easy to convert old SBoT198 scripts for this, because
SBoT198 had loads of amazing scripts, and finding TBoT scripts isn't that easy.

There is no need for a Data folder, STS uses the same data files as the normal RS, which are stored in your
.file_store_32.

AuthName=temp
AuthPass=temp

Or you can use your Rei-net forum name and pass, assuming your in the group Aut0er.

Any feedback is much appreciated, but don't post about things already mentioned or complain about shit, as i said, its
just a quick release to see what people think, and is no where near finished. Please leave feedback here:
http://67.111.205.85/forums/index.php?showtopic=4903

--: Command list :--

/reload - reloads the settings file and scripts, so you can edit them without completele reloading the bot.
/start <command>(<arg1>,<arg2>) - example of starting a script.
/stop - stops a script
F11 turns off Graphics.

--: Script Command List (much more to come, most are un-tested) :--
----------------------
void SetMode(int i)
int GetMode()
int GetFatigue()
long GetExp(int i)
int GetCurLvl(int i)
int GetMaxLvl(int i)
int GetCombatLvl()
int GetX()
int GetY()
boolean InCombat()
int HitsPercent()
boolean QuestMenu()
int CountQuestMenu()
void Answer(int i)
void Withdraw(int id, int amount)
void Deposit(int id, int amount)
boolean InBank()
boolean InShop()
void CloseBank()
void CloseShop()
boolean IsPrayerOn(int i)
void PrayerOn(int i)
void PrayerOff(int i)
void Speak(String s)
void TalkToNpc(int index)
void AttackNpc(int index)
void AttackPlayer(int index)
void ThieveNpc(int index)
void UseItem2(int pos)
void UseItem(int pos)
void WalkTo(int x,int y)
void WalkToWait(int x,int y)
void OpenDoor(int x,int y)
void AtObject(int x,int y)
void AtObject2(int x,int y)
void UseOnObject(int pos, int x, int y)
int CountObjects()
int CountNpc()
int[] GetNpcById(int id)
int[] GetNpcById(int[] id)
boolean NpcAttackable(int id)
String NpcName(int id)
int GetItemPos(int id)
boolean DoorAt(int x,int y)
int CountInv()
int CountInv(int i)
boolean Sleeping()
boolean ChangeWorld(int i)
int GetWorld()
boolean MembersWorld()
boolean LoggedIn()
void LogOut()
void AutoLogin(boolean on)
void ChatFilterOn(boolean on)
void End()
void Die()
void Display(String s)
void Loading()
void Output(int s)
void Output(String s)
int Rand(int low, int high)
boolean Running()
void Wait(int ms)
long GetMillis()
String Time()
void SaveScreenShot(String s)
String IntToStr(int i)
String IntToStr(long i)
int StrToInt(String s)