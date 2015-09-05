public class SlaveFight extends Script 
{ 
	public SlaveFight(mudclient rs)
	{ 
	        super(rs); 
	} 
	
	public String T = "nothing";
	
	public void TalkBack(String Text)
	{ 
	if (Running()) 
	{ 
	
	if (T.equalsIgnoreCase("Hi")) 
	   { 
	   Say("Hey"); ResetLastChatMessage();} 
	if (T.equalsIgnoreCase("sup")) 
	   {Say("nm"); ResetLastChatMessage();} 
	if (T.equalsIgnoreCase("autoing") ) 
	   {Say("most noobs say that"); ResetLastChatMessage();} 
	if (T.equalsIgnoreCase("go away") ) 
	   {Say("kiss my ass");ResetLastChatMessage();}    
	if (T.equalsIgnoreCase("autoer") ) 
	   {Say("wdf are u that stupid?");ResetLastChatMessage();} 
	if (T.equalsIgnoreCase("fhk you") ) 
	   {Say("don't mind if i do..");ResetLastChatMessage();} 
	if (T.equalsIgnoreCase("yo") ) 
	   {Say("supp yoo"); ResetLastChatMessage();} 
	if (T.equalsIgnoreCase("cool") ) 
	   {Say("awesome");ResetLastChatMessage();} 
	if (T.equalsIgnoreCase("leave") ) 
	   {Say("leaves are cool");ResetLastChatMessage();} 
	if (T.equalsIgnoreCase("omg") ) 
	   {Say("dont cry");  ResetLastChatMessage();} 
	if (T.equalsIgnoreCase("dam") ) 
	   {Say("your house burnt down? Too bad for you");ResetLastChatMessage();} 
	if (T.equalsIgnoreCase("ur a noob") ) 
	   {Say("nice to hear that from u");ResetLastChatMessage();} 
	if (T.equalsIgnoreCase("lmao") ) 
	   {Say("hohohoho");ResetLastChatMessage();} 
	if (T.equalsIgnoreCase("lol autoer") ) 
	   {Say("lol noob");ResetLastChatMessage();}  
	if (T.equalsIgnoreCase("lol!") ) 
	   {Say("hohohoho");ResetLastChatMessage();} 
	if (T.equalsIgnoreCase("lol") ) 
	   {Say("haha..not funny..");ResetLastChatMessage();} 
	if (T.equalsIgnoreCase("hello") ) 
	   {Say("im not a phone dont say that to me!");ResetLastChatMessage();} 
	if (T.equalsIgnoreCase("bot") ) 
	   {Say("wow..go die...");ResetLastChatMessage();} 
	if (T.equalsIgnoreCase("report him") ) 
	   {Say("w00t ur a newb");ResetLastChatMessage();} 
	if (T.equalsIgnoreCase("reported") ) 
	   {Say("i reported u too");ResetLastChatMessage();} 
	if (T.equalsIgnoreCase("noob") ) 
	   {Say("It's allright, we all go through that phase..");ResetLastChatMessage();} 
	if (T.equalsIgnoreCase("sup autoer") ) 
	   {Say("the roof");ResetLastChatMessage();} 
	if (T.equalsIgnoreCase("plz") ) 
	   {Say("plz die ok thanks ");ResetLastChatMessage();} 
	if (T.equalsIgnoreCase("??") ) 
	   {Say("wah?");ResetLastChatMessage();} 
	if (T.equalsIgnoreCase("lolol") ) 
	   {Say("how amusing");ResetLastChatMessage();} 
	if (T.equalsIgnoreCase("shutup") ) 
	   {Say("how about no");ResetLastChatMessage();} 
	if (T.equalsIgnoreCase("sdfu") ) 
	   {Say("fhk off");ResetLastChatMessage();} 
	if (T.equalsIgnoreCase("report you for autoing") ) 
	   {Say("w00t ur a newb");ResetLastChatMessage();} 
	if (T.equalsIgnoreCase("no") ) 
	   {Say("yes");ResetLastChatMessage();} 
	if (T.equalsIgnoreCase("rofl") ) 
	   {Say("sdfu");ResetLastChatMessage();}   
	if (T.equalsIgnoreCase("z dum") ) 
	   {Say("yo");ResetLastChatMessage();} 
	if (T.equalsIgnoreCase("z dumb") ) 
	   {Say("watup");ResetLastChatMessage();}
	if (T.equalsIgnoreCase("dumbname") ) 
	   {Say("wutup nigguh!!");ResetLastChatMessage();}
	if (T.equalsIgnoreCase("z dumbname z") ) 
	   {Say("yes mam");ResetLastChatMessage();}
	if (T.equalsIgnoreCase("still autoing?") ) 
	   {Say("i never was u dam jew");ResetLastChatMessage();}
	if (T.equalsIgnoreCase("hey z dumb") ) 
	   {Say("hiyo");ResetLastChatMessage();}
	if (T.equalsIgnoreCase("sup z") ) 
	   {Say("sup");ResetLastChatMessage();}
	if (T.equalsIgnoreCase("hey dumb") ) 
	   {Say("hiiiiiiiiii");ResetLastChatMessage();}
	if (T.equalsIgnoreCase("k") ) 
	   {Say("die");ResetLastChatMessage();}
	if (T.equalsIgnoreCase("str?") ) 
	   {Say("89 im going for 94");ResetLastChatMessage();}
	if (T.equalsIgnoreCase("str") ) 
	   {Say("89 im going for 94");ResetLastChatMessage();}
	if (T.equalsIgnoreCase("stats?") ) 
	   {Say("sorry, confidential");ResetLastChatMessage();}
	if (T.equalsIgnoreCase("stats") ) 
	   {Say("it doesnt matter!1");ResetLastChatMessage();}
	if (T.equalsIgnoreCase("u auto?") ) 
	   {Say("no i dont auto!");ResetLastChatMessage();}
	if (T.equalsIgnoreCase("u auto") ) 
	   {Say("no i dont auto!");ResetLastChatMessage();}
	if (T.equalsIgnoreCase("?") ) 
	   {Say("??????????????????");ResetLastChatMessage();}
	if (T.equalsIgnoreCase("lol noob") ) 
	   {Say("shut up and go die ");ResetLastChatMessage();}
	if (T.equalsIgnoreCase("do it") ) 
	   {Say("u want me to make you some sandwiches");ResetLastChatMessage();}
	if (T.equalsIgnoreCase("fhk u") ) 
	   {Say("go dieeeeeeeeeee");ResetLastChatMessage();}
	if (T.equalsIgnoreCase("nice auto") ) 
	   {Say("nice face ur mom gave u");ResetLastChatMessage();}
	if (T.equalsIgnoreCase("ranged?") ) 
	   {Say("over 70");ResetLastChatMessage();}
	if (T.equalsIgnoreCase("hey autoer") ) 
	   {Say("hey noob ");ResetLastChatMessage();}
	if (T.equalsIgnoreCase("range lvl?") ) 
	   {Say("over 70");ResetLastChatMessage();}
	if (T.equalsIgnoreCase("range lvl") ) 
	   {Say("over 70");ResetLastChatMessage();}
	if (T.equalsIgnoreCase("range?") ) 
	   {Say("over 70");ResetLastChatMessage();}
	if (T.equalsIgnoreCase("how many arrows do you have") ) 
	   {Say("79837459347953409753479375");ResetLastChatMessage();}
	if (T.equalsIgnoreCase("autotalker") ) 
	   {Say("auto sdfuer");ResetLastChatMessage();}
	if (T.equalsIgnoreCase("are you autoing?") ) 
	   {Say("yes i am not u idiot");ResetLastChatMessage();}
	if (T.equalsIgnoreCase("look") ) 
	   {Say("at ur face u jewish iraqi terroristic naolaaolzaoli");ResetLastChatMessage();}
	if (T.equalsIgnoreCase("help") ) 
	   {Say("i hope you die ok");ResetLastChatMessage();}
	if (T.equalsIgnoreCase("die") ) 
	   {Say("go lose 500 lbs u fatass");ResetLastChatMessage();}
	 ResetLastChatMessage(); 
	} 
	} 
	    
	public String[] getCommands() 
	{ 
	        return new String[]{"slave"}; 
	}  
	   
	public void start(String command, String parameter[])
	{
	        DisplayMessage("@gr2@|SboT|:@whi@:UnderGround Passage Slave Ranger[@gr2@ON@whi@]",3); 
		while (Running()) 
	      	{ 
			if (LastChatMessage() != null) { T= LastChatMessage(); TalkBack(T); ResetLastChatMessage();} 
	 
	         	int NW[] = new int[] {637, 636};
	         	int SE[] = new int[] {638, 639};
	         	int SW[] = new int[] {640, 634};
	         	int NE[] = new int[] {634, 635};
	         	
	           	                if (GetFightMode() != 1) 
	                { 
	                DisplayMessage("@or2@|SBoT|:@whi@FightMode Set to 1 [Strength]", 3); 
	                }
	                if(!InCombat() && Running() == true)
	                   	           {
		     	 	int SlaveNE = GetNearestNPC(NE);
				if (!CanReach(744,3458) && SlaveNE != -1)
				{
				Walk(744,3460);
				OpenDoor(744,3460,0);
				Wait(750);
				{
					SetFightMode(1);
					AttackNPC(635);
					Wait(700);
				}
				{
					SetFightMode(1);
					AttackNPC(634);
					Wait(700);
				}

				OpenDoor(744,3460,0);
				Wait(750);
				{
				int SlaveSE = GetNearestNPC(SE);
				if (!CanReach(744,3466) && SlaveSE != -1)
				{
				Walk(744,3465);
				OpenDoor(744,3465,0);
				Wait(750);
				{
					SetFightMode(1);
					AttackNPC(638);
					Wait(700);
				}
				{
					SetFightMode(1);
					AttackNPC(639);
					Wait(700);
				}
				OpenDoor(744,3465,0);
				Wait(750);
				}
				int SlaveNW = GetNearestNPC(NW);
				if (!CanReach(749,3458) && SlaveNW != -1)
				{
				Walk(750,3460);
				OpenDoor(750,3460,0);
				Wait(750);
				{
					SetFightMode(1);
					AttackNPC(637);
					Wait(700);
				}
				{
					SetFightMode(1);
					AttackNPC(636);
					Wait(700);
				}
				OpenDoor(750,3460,0);
				Wait(750);
				}
				int SlaveSW = GetNearestNPC(SW);
				if (!CanReach(750,3466) && SlaveSW != -1)
				{
				Walk(750,3465);
				OpenDoor(750,3465,0);
				Wait(750);
				{
					SetFightMode(1);
					AttackNPC(640);
					Wait(700);
				}
				{
					SetFightMode(1);
					AttackNPC(634);
					Wait(700);
				}
				OpenDoor(750,3465,0);
				Wait(750);
				}
				}
				}


		     }
			else Wait(1);
			if (Fatigue() >= 100 && Running() == true) 
	        	{ 
	             		while (Sleeping() == false && Running() == true) 
	              		{ 
	                  		Use(FindInv(1263)); 
	                  		Wait(2500);			
	              		} 
	              		while (Sleeping() == true && Running() == true) 
	              		{ 
	               	 		Wait(100);
	
				}
			}
		}      
	}
}


