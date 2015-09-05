~~~~~~~~~~~~~~~~~~~~ Runebot evolution 193 (AR Edit) ~~~~~~~~~~~~~~~~~~~~~~~~~
~~~~~~~~~~~~~~~~~~~~~     brought to you by evo     ~~~~~~~~~~~~~~~~~~~~~~~~~~

Update: 05-08-2004
	I finally got it working with msjava. I was able to track it down to a
	bug in their BigInteger implementation which made crash the whole vm
	(buffer overflow possibly...way to go mickeysoft ;P).
	What do we learn from this? Yea guys, ms is shit!

	Another thing is, that you now can tell RB+AR which port to communicate
	through by editing port.txt (either of them reads from that file).
	Use this to your advantage by launching several instances of RB+AR on
	the same machine. (Use CTRL-F3 to turn graphics off in order to make
	your machine lag much less).

Update: 05-10-2004
	Made it work with mudclient194.


To run it, simply click ms_?2p.bat or sun_?2p.bat, depending on whether you're
using mickeysoft's or sun's virtual machine implementation.

You no longer need to run setup, its done in the client! You no longer need to
be afraid of keylogged exes.
Note: Knowing this gay windows, I assume it's still possible to make keylogged
      "batch files" (.bat) by just renaming .exe files to .bat, so if you want
      to make absolutely sure, check 'em with notepad.
      Oh and turn of this stupid file extension hiding, so you can notice files like
      "mypic.jpg.exe" (Yea ms, we love you!)




RB features:

 * Fast server switching
	To be done in AutoRune. Do NOT append servernumber after your username!

 * World zooming
	UP/DOWN: Zoom in/out (dont turn in to far or weird things happed and the client crashes)
	F2: Turn fog of war on/off

 * Get rid of annoying chat filter
	F3: Turn chat filter on/off

 * Fixed map orientation (Note: Andrews little trap was removed:P)
	F4: player's facing exactly in northern direction

 * Autosleep
	Automatically clicks on sleeping bag when player is too tired, or a certain fatigue level
	is reached (too be adjusted via F11 and F12)
	Now longer need to grab the image off the screen, its now written into HC.BMP and
	the word is read from slword.txt.

 * AutoFight
	Attack a NPC of your choice and press F10 to keep on attacking this type of NPC.
	CombatStyle will be automatically set after relogin (e.g. when disconnects), so
	your 99 1 99 pure wont get messed up :P
 * AutoThieving
	Attack a NPC of your choice and press F8 to start thieve it.

	New: You can now speed up (or slow down for those who like that) attacking by use of CTRL-HOME/END

 * Pker's Ownage Map
	Go to wildy and find out yourself ;P

 * Autocatching
	F5: catchMode on (press follow to select player)
	F6: catchMode off
	Note: you need to tweak the timer settings which may differ depending on your connection.
		PGUP/PGDN: eatDelay
		HOME/END: walkDelay
		CTRL-PGUP/CTRL-PGDN: followDelay
	It's best to play with these values to find optimal settings

Note: If you try to sell it or distribute keylogged versions, I will kick thy arse!
      It's totally free of charge and public.
      Let's see if jagex really cares, and how long it takes em...

Happy Cheating :)
 -evo-
