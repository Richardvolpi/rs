~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ReadMe~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

This is 3rxBot made by Ben. But from now on I ({{zym}oti}) and maybe IcY will be updating it.
It is opensource, that does not mean that you can rename it and use it in your own community. It is
still 3rxnets bot. Your welcome to use the source to help you and learn from, or modify and rename it for personal
use.

Basic features of it are...

-)Toggle GFX - F12
-)Toggle Autologin - F11
-)Save Screenshot - F10
-)Hop between worlds - /hop(1-4)

It shows the ids of everything and of course it is scriptable.

To run scripts you type /run scriptname (arg1,arg2,...) and to stop them type /stop.

The commandlist, list of ids, and template script can be found both on the forums at www.3rxnet.org, or in the bots
documentation. After each update, i ll simply update the official command list, template and readme posts. There will be two
topics on the forums for each bit, i ll just edit them. 

Thnx:
Ben - Its Bens bot. He made it, nice one mate. Its awesome
Zym(Me) - For updating it
IcY - Constantly bitching at me to update, and even doing bits himself
Da3rx - Just for running 3rxnet with us
Stork - Just for being with us since before the beginning of time
Helborn - Made some updates to 3rxbot which i used in the official version. 
And everyone else.

Ps, atm there is a box on the login screen called "ignore". Ignore it :P Its a work in progress.


Love Zym.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Updates
-------

31ST Dec. 2005:
Added the following commands:
~int[] Bankers - Array containing the ID's of all types of bankers
~int[] Bones - Array containing the ID's of all types of bones
~String[] Spells - Array containing the Name's of all spells
~int[] StrArrayToIntArray(String[] s) - converts a string array to an integer array
~String[] IntArrayToStrArray(int[] i) - converts an integer array to a string array 
~int[] GetPlayerByName(String name) - returns the index, x-coord and y-coord as an array
~void TradePlayer(int id) - Trades a player by id 
~void AcceptTrade1() - accepts the first trade screen
~void AcceptTrade2() - accepts the second trade screen
~void DeclineTrade() - declines the trade
~void DeclineTrade() - declines the trade
~void AddToOffer(int item, int amount) - add items into the trade window
~boolean InTradeScreen1() - returns true if in the first trade screen
~boolean InTradeScreen2() - returns true if in the second trade screen
~boolean MyTrade1Accepted() - returns true if you have accepted the first trade screen
~boolean MyTrade2Accepted() - returns true if you have accepted the second trade screen
~boolean IsOffered(int id, int amount) - returns true if opponent has offered amount and id given 

All of the above were made by Helborn. Full credit to him. I didnt make any, i simple took them from his bot, to the official
3rxbot, with his permission of course. Thanks man.

7th Jan. 2006.
Fixed the following commands:
BuyShopItem(id)
ShopSellPrice(id) 
FindShopSlot(id)
UseItemOnObject(pos,x,y) 
AtObject(x,y) 
AtObject2(x,y) 
GetPlayerByName(name)

All the commands were already there, i just fixed them. They should all work perfectly now. 
UseItemOnGItem i also created. It was in the command list, but you couldnt actually use it before. You can now.
Ive fixed the world indicator. It now displays the right world all the time :P
The friends list should also be fixed. Tells you the actual world, including classic or rs2.

Ive added the command OpenDoor(int x, int y, int dir). Dir stands for direction. Most doors are either 0 or 1, but theres
a few that are 3, and i think a few that are 2. To get the direction, just open the door using 3rxbot and it will tell you
it on the dos screen.

CloseDoor(int x, int y, int dir) works in the same way. X and Y are the x and y coords of the door, you can return them using
GetWallObjectById(id) command.












