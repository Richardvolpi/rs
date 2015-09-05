Bot 1.00 by RaW - now includes OCR!
-
http://autorune.org - The AutoRune Crew
http://autorune.org/forums

-

Running UF [USERFRIENDLY] Scripts: #run(scriptname)
	eg: Loading a script called "Bot"; I'd use the following command:
		#run(Bot)

Running Java Scripts: #jrun(scriptname)

Stopping a Script: #stop() |or| F2

-

Bot 1.00 supports Java scripting, below is an example:

public class test extends Macro

{
   public test(mudclient rs)
   	{
      super(rs);
   	}

   public void start()
   	{
displayMessage("Simple example");
	}
}

-

The list of commands are in the following files:

UFCommands.html
Java Commands.txt
Other Commands.txt

-

Key Press Controls:

F2 - Switch macro OFF [used in conjunction with the stop() command]
F3 - Autologin ON / OFF
F4 - Graphics ON / OFF
F5 - Player information ON / OFF
F6 - Disable logging out ON / OFF
F7 - Quick LogOut
F9 - Zoom map in
F10 - Zoom map out
Insert - Sideway zooming
Delete - Sideway zooming
Home - Sideway zooming
End - Sideway zooming
Page up - Zoom in
Page down - Zoom out

-