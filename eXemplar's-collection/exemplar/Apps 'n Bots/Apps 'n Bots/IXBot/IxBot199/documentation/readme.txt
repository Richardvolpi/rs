***************************************** IxBot Final 196 *****************************************


********************** Complete reference of all scripts internal to this bot **********************
Note:
* All scripts are intelligent enough to figure out what to do next, provided you are near enough
  to the location this script is made for.
* Most scripts don't even need parameters, since those are smart enough to guess what you want it
  to do by checking your inventory.
* Some scripts require you to keep bones in your inventory (:O)
  This is for the moverequest event handler to walk back to your original
  spot by dropping and picking up those bones. The reason is that we cannot walk
  to a spot (or its hard to do so) if there's already someone on that tile.
  Good example is the jail ranger, where we are required to stand on a certain tile.
* EVERY script is completely fail safe, for example it will open all doors in it's way.
  All scripts are designed to run 24/7 without any user interaction.


##startMy		 iron mining at south fally mine (weird name, but my first script :)
##alc			 high alching script - must be in alkharid bank
##sh			 smelting by using superheat item - must be in alkharid bank
##nat			 nature rune thieving - in the house with two nature chests close to each other
##cake			 yea right, simple cake thieving
##thiev			 paladin/warrior thieving with auto cake eat (scripted AI!)
##rang			 ranging in jail (elite ;P)
##cham			 ranging at chickens in champions guild
##mag			 automaging on black knight in jail - type ##magXX where XX is spellIndex
##pick			 autopickup - nice for drop parties:P
##chick			 autofighting at chicken without burying bones
##chickpray		 autofighting at chicken with burying bones
##cow			 autofighting at cows without buriing bones (if you want give your guy an axe and a tinder box :-)
##beef			 cook raw beef at cows in lumby without fighting
##lumb			 autofighting at cows/chickens without burying bones (scripted AI!, if you want give your guy an axe and a tinder box :-)
##ghost			 ghost fighting in melzars maze (advanced!) <-- broken :(
##rat			 rat fighting in melzars maze (advanced!) <-- broken, but now exists as an external script
##maze			 multi autofighter in melzars maze (elite - scripted AI) <-- broken :(
##monk			 autofighter in monks guild (unfinished!)
##shop			 autobuying arrows <-- not very usefull except when running the commandline version
##mshop			 autobuying runes <-- not very usefull except when running the commandline version
##newGd			 get coal from mining guild (this one does NOT need a sleeping bag - only keep a pick in you inventory!)
##lumby			 lumby swamp mining <-- broken (pre-sleeping bag version)
##varrock		 ??? never finished script
##fs			 net fishing in draynor
##bait			 bait fishing in draynor
##fly			 lure fishing in barbarian village
##flyfish		 lure fishing in barbarian village with banking in varrock
##kara			 fishing on karamja isle (either lob or tuna/swordie, depending on whether there is cage or harpoon in inventory) <-- there's a newer version as external script
##cook			 cooking in draynor (from and to certs) (either lob or swordie certs * must have sleepingbag, tinderbox and runeaxe, raw and cooked certs in inventory)
##ck			 cooking bot in alkharid
##cert			 certing in draynor (certs the type of cert currently in inventory)
##uncert		 uncerting in draynor (uncerts any type of certs currently in inventory)
##smelt			 bar smelting in al kharid (smelts the type of ore/bar currently in inventory <-- smart enough to figure out what to do itself)
##craft			 crafting in al kharid
##smith			 iron/steel bar smithing (to plate) <-- broken
##soft			 make softclay in fallador old bank
##bowl			 bowl crafting (barbvillage - start anywhere between barbvillage and varrock)
##silver		 mining silver in crafting guild (anywhere between crafting guild and fally)
##gold			 mining gold in crafting guild (dito)
##silvergold		 mining silver and gold in crafting guild (dito)
##stop			 stop scriptProcessing
##con			 set combat style to controlled
##att			 set combat style to attack
##str			 set combat style to strength
##def			 set combat style to defence
##l			 logOut Request!
##move			 simulate move request
##dispdialog		 display current dialogItems
##dispWalk		 display walk command (the x,y coordinates of destination)
##dispMsg		 to display messages like "You manage to obtain some ore"
##dispNPC		 display all NPCs in cache
##NPC			 display first NPC structure
##dispObj		 display all near objects in cache
##hi			 display spawning info about runite rox (very useful at times when rocks weren't colored yet ;P)
##dispWall		 display all near wallObjects in cache
##dispPlayers		 display all near players
##snd			 plays any specified sounds (not very usefull since those suck anyways...)
##autoLogin		 enable/disable ixbot autologin
##rsync			 AR related: checks if scripts matches and, if not, uploads the script in ar_script.txt to the connected autorune - usefull if you're connecting to remote AR's :P


A lot more advanced scripts can be found in the scripts directory, or even new ones can be made easily.
Included is:
	* hobgoblin fighter
	* flax spinner
	* woodcutter/firemaker
	* Fletching
	* Elite auto fighter (with door opening, autopray, item pickup, auto eat, 
		autobanking can be implemented easily - provided the way to the bank is not
		too complicated, but even in those cases it's possible, but requires some more work;
		works at any training spot; parameter controlled)
	* Fishing guild shark fisher - To fish other type of fish, some minor modifications should help.



********************************** Some keyboard commands **********************************
F2: fog on/off
F3: toggle graphics on/off
F4: take screen shot and save into scrshot folder
F5: starts AR script
F6: stops AR script
F7: eat request (used in pk bot)
F8: turn on/off auto-prayer for pk mode
F9: protect items on
F10: protect items off
F11: Autocatch on (pkBot implementation in scripts folder)
F12: Autocatch off (pkBot implementation in scripts folder)




********************************** Development of own scripts **********************************
This going to be only a very short one as i hate writing documentation.
Also its not really necessary since my scripting interface is (well?) documented in Script.jpp.
So i'd advise you to use this as reference. Anyways it should help you getting started...

I'm just making some minor notes about the three most important functions every script must have:

  public abstract String[] getCommands();
  public abstract boolean start(String command, String parameters[]);
  public abstract long run(long ticks);

* getCommands returns must return an array of strings of commands this script will be started with.
  (see the example scripts how this is done).
  The scripts are then invoked by typing "##XXX" where XXX is one of the commands returned by getCommands.
  you can also add parameters seperated by spaces which a passed on to the function start.

* Fhe function start(String command, String parameters[]) is called immediately after the respective command
  was typed. Its parameters are the command itself and any optional parameters.

* The actual script processing takes place in a method called run. This method is being continuosly called.
  The return value of run() determines the amount of milliseconds it will wait before next invokation of this method.

You can stop any script processing by just typing ##stop.
For much easier script development i've added a neat feature that allows you to reload class files while the client
running. That means you dont have to restart the whole client if you made a little update in one of the scripts.
Just type "##reload" and it will reload the last active script (and ONLY this one). So if you were running the 
"##fallymine" script, and want to reload it, just type ##stop, ##reload and then start it again. In order to not 
always having to write these commands again i've implemented a "history" which allows you to browse through all 
the chat text you already typed. Just use the PGUP and PGDOWN keys to browse through it.
Oh and incase you changed one of the java files you of course have to compile it which is done by
just type "javac YourScript.java" (or "javac *.java" which compiles them all) in the console while being in the scripts
directory.

Commands that could be of help for script development:
	##move		simulate move request - you know...that 5min warning
	##dispMsg	log all server messages to console (type again to disable)
	##dispObj	display near objects (up to 3 tiles away from player position)
	##dispWall	display near wall objects (up to 3 tiles away from player position)
	##dispNPC	display all NPCs in cache
	##dispdialog	display current dialogItems
	##dispWalk	log all walk commands console (extremely usefull to figure out the coordinates to use in the scripts)

also look into all those *.txt files for a complete reference of all items/objects/etc..




That's all I can think of now.

  evo
