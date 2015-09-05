public class steelSmelter extends Methods
{

     public steelSmelter(mudclient rs)
     {
          super(rs);
     }

     public void Main(String[] args)
     {
          while(Running())
          {
				while(CountInv(155) != 18 || CountInv(151) != 9)
					bank();
				WalkToWait(286,571);
				if(!IsReachable(287,571))
				{
					int[] doors = GetObjectById(64);
					while(!IsReachable(287,571) && doors[0] != -1)
					{
						AtObject(doors[1], doors[2]);
						long l = System.currentTimeMillis();
						while(GetMillis() - l < 500)
						{
							Wait(10);
							if(IsReachable(287,571))
								break;
						}
					}
				}
				WalkToWait(290,558);
				WalkToWait(301,547);
				WalkToWait(305,544);
				if(!IsReachable(306,544))
				{
					int[] door = GetObjectById(2);
					while(!IsReachable(306,544) && door[0] != -1)
					{
						AtWallObject(door[1], door[2]);
						long l = System.currentTimeMillis();
						while(GetMillis() - l < 500)
						{
							Wait(10);
							if(IsReachable(306,544))
								break;
						}
					}
				}
				smelt();
				if(!IsReachable(305,544))
				{
					int[] door = GetObjectById(2);
					while(!IsReachable(305,544) && door[0] != -1)
					{
						AtWallObject(door[1], door[2]);
						long l = System.currentTimeMillis();
						while(GetMillis() - l < 500)
						{
							Wait(10);
							if(IsReachable(305,544))
								break;
						}
					}
				}
				WalkToWait(293,556);
				WalkToWait(288,571);
				WalkToWait(286,571);
				if(!IsReachable(286,571))
				{
					int[] doors = GetObjectById(64);
					while(!IsReachable(286,571) && doors[0] != -1)
					{
						AtObject(doors[1], doors[2]);
						long l = System.currentTimeMillis();
						while(GetMillis() - l < 500)
						{
							Wait(10);
							if(IsReachable(286,571))
								break;
						}
					}
				}
          }
     }

     public void OnServerMessage(String message)
     {
		 message = message.toLowerCase();
		 //System.out.println(message);
		 if(message.startsWith("@gam@you retrieve a bar of"))
		 	smelt = true;
     }

     public void OnChatMessage(String sender, String message)
     {
          //When there is a chat message, This void is triggered.
     }

     public void OnPrivateMessage(String sender, String message)
     {
          //When there is a private message, This void is triggered.
     }

     public void OnKeyPress(long keycode)
     {
          //When the user clicks on a button, This void is called.
     }

     public void bank()
     {
		 long l;
		 while(!QuestMenu())
		 {
			 int[] banker = GetNpcById(95);
			 TalkToNpc(banker[0]);
			 l = GetMillis();
			 while(GetMillis() - l < 3000)
			 {
				 Wait(10);
				 if(QuestMenu())
				 	break;
			 }
		 }
		 Answer(0);
		 l = GetMillis();
		 while(!InBank())
		 {
			 Wait(10);
			 if(GetMillis() - l >= 5000)
			 	break;
		 }
		 while(InBank())
		 {
			 while(CountInv(171) > 0 && InBank())
			 {
				 Deposit(171,1);
				 Wait(120);
			 }
			 while(CountInv(155) != 18 && InBank())
			 {
				 Withdraw(155,1);
				 int ci = CountInv();
				 l = GetMillis();
				 while(ci == CountInv() && InBank())
				 {
					 Wait(10);
					 if(GetMillis() - l >= 8000)
					 	break;
				 }
			 }
			 while(CountInv(151) != 9 && InBank())
			 {
			 	 Withdraw(151,1);
			 	 int ci = CountInv();
			 	 l = GetMillis();
			 	 while(ci == CountInv() && InBank())
			 	 {
			 		 Wait(10);
			 		 if(GetMillis() - l >= 8000)
			 		 	break;
			 	 }
			 }
			 if(CountInv(1263) < 1)
			 	Withdraw(1263,1);
			 Wait(2000);
			 CloseBank();
		 }
	 }

	 public boolean smelt;

	 public void smelt()
	 {
		 while(CountInv(155) > 0)
		 {
			 while(Sleeping())
			 	Wait(500);
			 if(GetFatigue() >= 90)
			 {
			 	UseItem(GetItemPos(1263));
			 	Wait(1000);
			 }
			 smelt = false;
			 int[] furance = GetObjectById(118);
			 UseOnObject(GetItemPos(155),furance[1],furance[2]);
			 long l = GetMillis();
			 while(!smelt)
			 {
				 Wait(10);
				 if(GetMillis() - l >= 4000 || smelt)
				 	break;
			 }
		 }
	 }
}