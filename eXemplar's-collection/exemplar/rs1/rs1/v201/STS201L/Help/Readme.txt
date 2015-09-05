------------------- SkulltorchaScriptable -------------------

---- Getting started: ----

Start by simply extracting the rar file, using WinRar. This can be found on reinet.co.uk downloads page if required. Before running the bot make sure you have Sun Java 1.5 installed - it can be found at www.java.com, if you have an earlier version it will probably have errors, if you don't have Sun Java at all it won't run.

---- Commands: ----

/start scriptname(param1,param2,etc) - starts the selected script using any required paramaters
/stop - stops the current script
/reload - reloads the settings file and loads in any new scripts
/hop(serv) - changes to the given server
/offer(item,amount) - adds 'amount' of 'item' to a trade if your in trade screen
/withdraw(item,amount) - withdraws 'amount' of 'item' if your in the bank screen
/deposit(item,amount) - deposits 'amount' of 'item' if your in the bank screen
/macros - shows the list of built in macros
/reset - resets the exp counter to 0
F6 - Toggle ForceWalk on/off (ForceWalk allows you to walk to a square even with a player in it)
F7 - Toggle building roofes on/off.
F8 - Shows the list of built in macros
F9 - Saves a screenshot of the screen
F10 - Toggles autologin (some scripts turn this on anyway)
F11 - Toggles gfx on/off

For a full list of the Scriptable commands see CommandList.txt

---- Auths: ----

Your Auth details are put into the settings.ini file, It uses your reinet.co.uk forum username and password (If your username has a space in it, it may work fine - if it doesn't, replace all spaces with %20 and it will work. Authnames and Authpasswords ARE case sensitive. Auths are free for now.

---- IRC: ----

A new addition in STS201H was the use of IRC. It may well still be buggy, and currently is fairly limited in use - it was just an experiment. If you start a chat message on STS with # and have IRC enabled it will send it to the IRC channel you are in, instead of RS. The current IRC commands are as follow.

#/nick(new nick) - changes your nickname on IRC
#/identify(password) - identify to the nickserver using your password
#/quit - quits IRC
#/join(channel) - leaves the channel your currently in and joins 'channel'
#/userlist - displays a list of all current users in your channel
#/mode(mode) - allows you to set a mode on the channel or a user

---- Data: ----

A data folder is now required as access the file store was causing the jvm security manager to mess up for a small amount of people, if you don't have the required files it will automatically download them though so this is nothing to worry about.

---- Common Errors: ----

"'java' is not recognized as an internal or external command,
operable program or batch file.
Press any key to continue . . ."

This is a common problem people seem to have, but it simply relates back to not bothering to read. As i have stated, Sun Java is required to run STS - This error means you don't have it.

"'javac' is not recognized as an internal or external command,
operable program or batch file.
Press any key to continue . . ."

Very similar to the first error, this one may occur when you try and compile a script. It means you are missing JDK 5.0 (which can be downloaded from http://java.sun.com), tutorials on how to set this up can be found on reinet forums.

"Exception in thread "main" java.lang.NoClassDefFoundError: mudclient
Press any key to continue . . ."

This is another of the common errors people seem to meet. Basically it means that Java cannot find the file you have told it to run (eg. STS) - this could be for 2 reasons. Either you haven't extracted the bot into a folder, or you have messed around with STS.jar.

-------------------------------------------------------------

Reines (reines@gmail.com) - http://reinet.co.uk