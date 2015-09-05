F1 - Stop All Macros
F2 - Autofight Toggle
F3 - Autothieve Toggle
F4 - Automage Toggle
F5 - AutoEat Toggle
F6 - Pkers Map Toggle
F7 - Walk With Keyboard Toggle
F8 - AutoLogin Toggle
F9 - Server Hop (with the .f2p, .p2p, & .both)
F10 - Show Graphics Toggle
F11 - Record Steps Toggle
F12 - Replay Recordings

RightClick Options:
AutoPick
AutoMacro
AutoCatch

.81 - .82 - .83 - .84 - .85 - .86 - switch server
.f2p - f2p servers
.p2p - p2p servers
.both - both servers
.npcid(id) - set npcid
.clearinv - drops all
.fm - toggle fightmode menu
.am id - autoduelmager
.stop - stops autoduelmager
automage id's:
0 - guthix
1 - saradomin
2 - zamorak
3 - iban
wind - windstrike
.magenpc(npcid,spellnumber) - automage npc
.magenpc - stop automage

Scripting Methods:
void debugrs(text)
boolean running()
int GetX()
int GetY()
boolean Sleeping()
int Fatigue()
int GetMaxStat(stat)
int GetCurStat(stat)
int Fightmode()
void Fightmode(mode)
int distFrom(x,y)
void WalkTo(x,y)
void Wait(wait)
int objectCount()
int objectType(id)
string objectName(id)
string getObjectCmd1(id)
string getObjectCmd2(id)
int objectX(id)
int objectY(id)
void objectCmd1(id)
void objectCmd2(id)
int wallObjectCount()
int wallObjectType(id)
string wallObjectName(id)
string getWallObjectCmd1(id)
string getWallObjectCmd2(id)
void wallObjectCmd1(id)
void wallObjectCmd2(id)
int InvCount()
int InvCount(id)
int itemAtSlot(slot)
string itemName(id)
string getItemCmd(id)
int FindInv(id)
void itemCmd(id)
void useitem(id)
void dropItem(id)
void useitemwithgrounditem(item,grounditem)
boolean isBank()
void closeBank()
int numBankItems()
int bankItemType(id)
int numBankItem(id)
int FindBankItem(id)
void deposit(item,amount)
void withdraw(item,amount)
boolean isShop()
void closeShop()
int getShopItemType(id)
int FindShopItem(id)
int numShopItem(id)
int getItemSalePrice(id)
int getItemBuyPrice(id)
void sellitem(id)
void buyitem(id)
int groundItems()
int groundItemType(id)
void takeGroundItem(id)
int npcCount()
int npcType(id)
string npcName(id)
int nearestNpc(id)
boolean npcInCombat(id)
void attackNpc(id)
void TalkNpc(id)
void answer(questmenunum)

Spell Numbers:
ID: NAME - DESCRIPTION
0: Wind strike - A strength 1 missile attack
1: Confuse - Reduces your opponents attack by 5%
2: Water strike - A strength 2 missile attack
3: Enchant lvl-1 amulet - For use on sapphire amulets
4: Earth strike - A strength 3 missile attack
5: Weaken - Reduces your opponents strength by 5%
6: Fire strike - A strength 4 missile attack
7: Bones to bananas - Changes all held bones into bananas!
8: Wind bolt - A strength 5 missile attack
9: Curse - Reduces your opponents defense by 5%
10: Low level alchemy - Converts an item into gold
11: Water bolt - A strength 6 missile attack
12: Varrock teleport - Teleports you to Varrock
13: Enchant lvl-2 amulet - For use on emerald amulets
14: Earth bolt - A strength 7 missile attack
15: Lumbridge teleport - Teleports you to Lumbridge
16: Telekinetic grab - Take an item you can see but can't reach
17: Fire bolt - A strength 8 missile attack
18: Falador teleport - Teleports you to Falador
19: Crumble undead - Hits skeleton, ghosts & zombies hard!
20: Wind blast - A strength 9 missile attack
21: Superheat item - Smelt 1 ore without a furnace
22: Camelot teleport - Teleports you to Camelot
23: Water blast - A strength 10 missile attack
24: Enchant lvl-3 amulet - For use on ruby amulets
25: Iban blast - A strength 25 missile attack!
26: Ardougne teleport - Teleports you to Ardougne
27: Earth blast - A strength 11 missile attack
28: High level alchemy - Convert an item into more gold
29: Charge Water Orb - Needs to be cast on a water obelisk
30: Enchant lvl-4 amulet - For use on diamond amulets
31: Watchtower teleport - Teleports you to the watchtower
32: Fire blast - A strength 12 missile attack
33: Claws of Guthix - Summons the power of Guthix
34: Saradomin strike - Summons the power of Saradomin
35: Flames of Zamorak  Summons the power of Zamorak
36: Charge earth Orb - Needs to be cast on an earth obelisk
37: Wind wave - A strength 13 missile attack
38: Charge Fire Orb - Needs to be cast on a fire obelisk
39: Water wave - A strength 14 missile attack
40: Charge air Orb - Needs to be cast on an air obelisk
41: Vulnerability - Reduces your opponents defense by 10%
42: Enchant lvl-5 amulet - For use on dragonstone amulets
43: Earth wave - A strength 15 missile attack
44: Enfeeble - Reduces your opponents strength by 10%
45: Fire wave - A strength 16 missile attack
46: Stun - Reduces your opponents attack by 10%
47: Charge - Increase your mage arena spells damage