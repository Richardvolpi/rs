kept closing bug fixed in D1/2

new in ver D:
focr compatible hc.bmps
player hp in right click menu
minor speed improvements
script processing bug fixed
ability to hide script manager, hit the "Hide SM" button from rs window
ability to minimize slave to the systray(near the clock small buttons), in small rs you have to resize the window to see the button.

OLd:
I hate writing these but it's just one of those things...

Auth: temp2
Apass: auth2

SlavE V 198c Readme:

The rundown:
This bot was started back in mud 194, i think released publicly during 194 or maybe early 196 as a bot that used similar scripting as autorune. Seeing as i liked autorune so much during 196 i created a script manager purely in java that has i think a look and feel of autorune.

Some commands:
F2 key - graphics off
/hp - ex: "/hp all" shows users names levels and current hp
/hp hp shows just hp
/server number - server hops to the number

Suggestions:
When using a script that switchs servers often turn off graphics theres less chance of it freezing on you.

Scripts:
Included are roughly 100 or so scripts, all work all made by me, some i dont know what they do anymore :P but they work at what they do.

The features:
Script Manager: load scripts, write and run scripts in real time, trace scripts etc etc.

Client: a couple mods here, displays how much xp you've gone up, your location, whether macro is running.

Sleeping: Saves your sleepword as HC.bmp and sleeps with sleepwalker minimized. to do this add ARPATH="C:\example\slave" to your sleepwalker.ini change that to the actual directory btw

Config file:
open up slave.ini in your folder and you can save your auth and up to 3 user and passes for runescape so all you have to do is open and it auths you, then when you load rs all you have to do is pick a server with the selector then click the username in there.

Keypoints:
Sleepwindow: when enabled and you sleep it pops up with the word in a new window and you can type it in that window instead of the rs window, that way if sleepwalker is down you can know when the word needs to be typed regardless if its minimized, you can turn it on from script manager.

Chat log: logs all chat and server messages to chatlog.txt, can turn on and off from script manager

Mod Protect: It's there good luck with those pesky mods

It's late, I'm tired bleh so heres a list of commands that can be used in your scripts:
stop()
stopandlogout()
logout()
waitforcoordchange() - waits for your x and y to change
opendoorifclosed(x,y)
openbigdoorifclosed(x,y)
switchserver(servernum)
setvarsnearestitemincoords(x,y,itemid,x1,y1,x2,y2)
gotoifitemincoords(@label,x1,y1,x2,y2,itemid)
gotoifcoordsin(@label,x1,y1,x2,y2)
gotoiffighting(@label)
gotoifsleeping(@label
debugrs(text) - no quotes needed
debug(text) - no quotes needed
gotoifnpcnear(@label,npcid) - goes if npc is near regardless of reach
gotoifnpcnearifreach(@label,npcid) - goes only if npc is reachable
gotoifnpcnearbyname(@label,npcname) - goes if npc near by their name, good for liek gobvillage
gotoifnpcnearincoords(@label,npcid,x1,y1,x2,y2) -goes if npc near in that area
gotoifbagfull(@label)
gotoifinshop(@label)
gotoifininventory(@label,itemid)
gotoiflastservermessageequal(@label,message) no quotes - ex: @gam@You're too tired..
gotoiflastservermessageisnotequal(@label,message) figure it out
resetlastservermessage()
closeshop()
closebank()
gotoifitemwithindist(@label,itemid,distance)
gotoifobjectwithindist(@label,objectid,distance)
gotoifcountininventoryequal(@label,number,itemid)
gotoifcountininventorygreater(@lablel,number,itemid)
gotoifnum1abovenum2(@label,num1,num2)
gotoifnum1betweennum2andnum3(@label,num1,num2,num3)
gotoifnum1equalnum2(@label,num1,num2)
gotoifnum1belownum2(@label,num1,num2)
setvar(var,numbertosetvarto)
addvar(var,numbertoaddtovar)
subvar(var,numbertosubtractfromvar)
setvaritemcount(var)
setvarmyx(var)
setvarmyy(var)
setvarinvcountbyid(var,itemid)
setvarcurrentstat(var,stat) - stat is like attack: 72/83, stat would be 0 and would return 72
setvarmaxstat(var,stat) - stat is like attack: 72/83, stat would be 0 and would return 83
setvarsnearestitem(x var, y var, itemid)
setvarsnearestobjects(x var, y var, objectid, objectid) - ex: when mining coal rocks it will find the closest of the two types
setvarsnearestobject(x var, y var, objectid) - only finds one type of object
setvarfatigue(var)
useitembyid(itemid)
useitem(itempositionininventory)
waitnorand(numberinms) - waits in milliseconds with no random wait
wait(numberinms) - waits in milliseconds and adds a random 0-80ms extra to avoid detection
withdraw(itemid,amount) - must be in bank duh
deposit(itemid,amount) - look above
waitforbank(timeout) - waits for bank until timeout
waitforminingmessage(timeout) - waits for a message indicating mining a rock is done until timeout
waitforquestmenu(timeout) - waits for the menus for banking and shit or until timeout
waitforshop(timeout) -figure it out
waitforwakeup(timeout) - waits for you to wake up until time out, good for sleeping
prayeron(prayernum) - turns prayer on, first prayer is 0 second 1 etc
prayeroff(prayernum)
answer(number) - answers quest menus like certing, 0 is first choice, 1 is 2nd etc
dropbyid(itemid) - drops an item by its id
buyitem(itemid) - buys one
sellitem(itemid)
takeitembyname(x, y, itemname) - ex: takeitembyname(%x,%y,Lobster)
useitemwithobject(x of object, y of object, itemid of item in inventory)
useitemwithgrounditem(x of item, y of item, id of item on ground, position of item in inventory)
magenearestnpc(npcid,spell)
useitemwithitembyid(itemid1,itemid2)
useitemwithitembypos(itemposition,itemposition2)
mageitembyid(itemid,spell)
mageitem(itemposition,spell)
attacknearestnpc(npcid,opendoors) opendoors detects if you're trapped and opens small doors
attacknearestnpcincombat(npcid)
attacknearestinarea(npcid,x1,y1,x2,y2) - attacks nearest npc in that area
rangenearestnpc(npcid)
thievenearestnpc(npcid)
fightmode(mode) - 0 controlled, 1 str, 2 att, 3 def - sets regardless if in combat good for pbs who are fishing lol
talktonearestnpc(npcid)
objcmd2(x, y) - cuts trees with right click, picks flax wheat and shit
objcmd1(x, y) - left click object actions like mining fishing etc
walknowait(x,y) - walks to x and y without waiting
walkwait(x,y) - walks to x and y and waits while walking and if walking stops sends more commands till within 1 sq of destination
spawnitem(id) - fake spawns and item client side at your x and y
spawnitem(x, y, id) - fake spawns item client side at specified x and y
