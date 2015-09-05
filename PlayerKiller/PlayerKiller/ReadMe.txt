PlayerKiller v1.2 created by Ruckus

Typing Commands:
    /hop(server) - hops to specified server
    /deposit(itemid,amount) - Deposits item id in increments of amount.
    /withdraw(itemid,amount) - Withdraws item id in increments of amount.
    /eatat(hp) - changes auto eat at hp to what ever.
    /eatdelay(ms) - changes eat delay to ms (milliseconds)
    /getpid(pid) - logs in and out untill your pid is less than what ever.
    /stop - stops logging for pid, or antilogout
    /setprayers(prayid1,prarerid2) - resets prayers, can be any  number of ids, as long as
seperated by commas
    /walkedge - starts walker from lumby to edge, /stop or f12 to stop.

IRC Commands:
  NOTE: If you have the option "Constant IRC" enabled in IRC options menu, 
  you do not need to use the #/ just use the /, The NORMAL /hop etc Commands WILL NOT WORK!
    #/join #channel - Joins #channel
    #/join #channel chanel key - Joins #channel with the channel key supplied
    #/part #channel - Parts #channel
    #/part #channel reason - Parts #channel with reason
    #/nick newNick - Changes your nick to new nick
    #/mode #channel mode changes - changes the mode on #chanel with the changes ( #/mode #reinet +v Ruckus
    #/mode Nick Mode Changes - changes the mode of the user with changes, (#/mode Ruckus +q)
    #/kick #channel name - Kicks  Name on # channel, must be joined in channel and opped
    #/kick #channel name reason - kicks Name on #channel with reason, must be joined in channel and opped
    #/msg #channel MSG - sends a message to #channel 
    #/msg Nick MSG - sends a message to Nick (same as pm) 
    #/view #channel - Sets the visible channel you wish to receive messages to #channel
    # message - Sends message to current visible channel
KeyPress Commands:
    UpArrow - Puts last said message up
    DownArrow - delets message you are currently typing
    F12 - Stops logging for pid and antilogout, (same as typing /stop)
    F11 - Takes screen shot

Profiles:
    Tired of having to set all of your settings every time you login? NO PROBLEM :P you can
    use multiple profiles for each character etc. First if you wish to use a profile, you 
    must edit the main Setttings.ini to say "UseProfiles=yes". Then open the Profiles folder
    and edit or create the .ini file to be exactly like the other one which is there already.
    Each value should either be a number, on/off or username and pass to login with.
    If you fucked it up, here is the base of what it should contain:
Login Info:
RsUser=RsName
RsPass=RsPass
Server=4
AutoLogin=off
ShowInfo=Off
ChatFilter=off
Skin=0
MapStyle=0

AutoEat Info:
IsAutoEat=off
EatAt=70
PicOnKill=off

AutoPrayer Info:
IsAutoPray=off
Prayers=10,11,12

    Valid skins are 0 - 4, and valid map styles are 0 - 4. Prayers can be unlimited, as long as
    they are seperated by commas.

--Modes--
AutoEat:
    Type /eatat(hp), This will set what hp to eat at. Then go to PlayerKiller options and 
    turn autoeat on. It will now eat ANY food in your inventory if your not incombat and
    your current hp is less than what you set your hp at.

GetPid:
    When you type /getpid(id), you will begin to login and out untill your player id is less
    than ID. Once you have a decent pid, antiLogout mode will automatically enable. Press F12
    to stop antilogout mode or logging for pid.

AntiLogout:
    In the playerkiller options menu you can active AntiLogout. It will attempt to keep you  
    from logging out by walking every few minutes. This mode will also automatically enable
    after you receive good pid when using the getpid mode.

--Map Explanations--
Normal Map: (Profile style 0)
    Map like normal RS, all colors are same.

PlayerID: (Profile style 1)
    Npcs are Pink, Items are Grey, Map which shows people as either green or red. Green being 
    they have lower pid, red higher 
    pid. 

PlayerID-Attackable only: (Profile style 2)
    Npcs are Pink, Items are Grey, Map which shows ATTACKABLE characters only people as either 
    green or red. Green being they have lower pid, red higher pid.

Combat: (Profile style 3)
    Npcs are Pink, Items are Grey, Players are green to red depending on combat lvl.

Combat-Attackable only: (Profile style 4)
    Npcs are Pink, Items are Grey, Shows ATTACKABLE Players are green to red depending on 
    combat lvl.
    
General IRC information:
    Some of you may wonder how you identify your nick. To do this type: #/msg nickserv identify <PASSWORD>
    Now you may wish to know how to switch inbetween channels, To do this go to the IRC menu,
    and click on the "Visible Channel:" Channel portion and it will change what the visible
    channel is, in otherwords, it changes what channel you can view messages from.
    Constant IRC is a mode inwhich you dont have to type #/option, you just type /command and it
    will check it against the IRC commands. OTHER BOT COMMANDS WILL NOT WORK WHILE THIS IS ENABLED!
    A list of channels you are in is listed in the IRC menu.