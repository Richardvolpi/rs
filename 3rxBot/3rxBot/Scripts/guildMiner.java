public class guildMiner extends Methods
{

     public guildMiner(mudclient rs)
     {
          super(rs);
     }

	 public long timer = 0;

     public void Main(String[] args)
     {
		  int[] rockIds = new int[2];
		  rockIds[0] = 110;
		  rockIds[1] = (GetCurLvl(14) >= 50 ? 107 : 110);
          while(Running())
          {
               while(GetY() > 3000 && CountInv() < 30)
               {
				   int[] rock = GetObjectById(rockIds);
				   if(rock[0] != -1 /* && IsReachable(rock[1], rock[2])*/)
				   {
					   AtObject(rock[1], rock[2]);
					   timer = System.currentTimeMillis();
					   while(System.currentTimeMillis() - timer < 500)
					   {
						   Wait(10);
					   }
				   }
			   }
			   if(GetY() > 2000)
				   walkToBank();
			   while(getBankingItem() != -1)
			       bank();
			   walkFromBank();
			   Wait(5000);
          }
     }

	 public String lastServerMessage = "";

     public void OnServerMessage(String message)
     {
          message = message.toLowerCase();
          lastServerMessage = message;
          //System.out.println(message);
          if(message.startsWith("@gam@you swing"))
          {
          		timer = System.currentTimeMillis() + 1800;
		  }
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

     public void walkToBank()
     {
		 int[] ladder = GetObjectById(5);
		 while(GetY() > 2000)
		 {
			 AtObject(ladder[1], ladder[2]);
			 timer = GetMillis();
			 while(GetMillis() - timer < 500 && GetY() > 2000)
			 {
				 Wait(10);
			 }
		 }
		 WalkToWait(274,563);
		 if(!IsReachable(274,572))
		 {
			 int[] door = GetWallObjectById(2);
			 while(!IsReachable(274,572))
			 {
				 AtObject(door[1], door[2]);
				 int iWait = 0;
				 while(!IsReachable(274,572))
				 {
					 Wait(50);
					 iWait += 50;
					 if(iWait >= 500)
					 	break;
				 }
			 }
		 }
		 //WalkToWait(287, 562);
		 WalkToWait(287, 571);
		 if(!IsReachable(286,571))
		 {
			 int[] door = GetObjectById(64);
			 while(!IsReachable(286,571))
			 {
				 AtObject(door[1], door[2]);
				 int iWait = 0;
				 while(!IsReachable(286,571))
				 {
					 Wait(50);
					 iWait += 50;
					 if(iWait >= 500)
					 	break;
				 }
			 }
		 }
		 WalkTo(284,571);
		 Wait(600);
	 }

	 public void walkFromBank()
	 {
		 WalkToWait(286,571);
		 if(!IsReachable(287,571))
		 {
		 	 int[] door = GetObjectById(64);
		 	 while(!IsReachable(287,571))
		 	 {
		 		 AtObject(door[1], door[2]);
		 		 int iWait = 0;
		 		 while(!IsReachable(287,571))
		 		 {
		 			 Wait(50);
		 			 iWait += 50;
		 			 if(iWait >= 500)
		 			 	break;
		 		 }
		 	 }
		 }
		 WalkToWait(274,562);
		 if(!IsReachable(274,563))
		 {
			 int[] door = GetWallObjectById(2);
			 while(!IsReachable(274,562))
			 {
				 AtObject(door[1], door[2]);
				 int iWait = 0;
				 while(!IsReachable(274,562))
				 {
					 Wait(50);
					 iWait += 50;
					 if(iWait >= 500)
					 	break;
				 }
			 }
		 }
		 WalkToWait(274,565);
		 while(GetY() < 2000)
		 {
			 int[] ladder = GetObjectById(223);
			 AtObject(ladder[1], ladder[2]);
			 timer = GetMillis();
			 while(GetMillis() - timer < 500 && GetY() < 2000)
			 {
				 Wait(10);
			 }
		 }
	 }

	 public int getBankingItem()
	 {
		 for(int i = 0; i < CountInv(); i++)
		 {
			 if(InvItemId(i) != 1263 && InvItemId(i) != 1262)
			 	return InvItemId(i);
		 }
		 return -1;
	 }

	 public void bank()
	 {
		 while(!QuestMenu())
		 {
			 int banker = GetNpcById(95)[0];
			 if(banker != -1)
			 {
				 while(!QuestMenu())
				 {
				 	TalkToNpc(banker);
				 	timer = GetMillis();
				 	while(GetMillis() - timer < Rand(3000,4000) && !QuestMenu())
				 	{
						Wait(10);
					}
				}
			 }
			 timer = GetMillis();
			 while(!QuestMenu())
			 {
				 Wait(10);
				 if(GetMillis() - timer >= 2000)
				 	break;
			 }
		 }
		 Answer(0);
		 timer = GetMillis();
		 while(!InBank())
		 {
			 Wait(100);
			 if(GetMillis() - timer >= 5000)
			 	break;
		 }
		 while(InBank())
		 {
			 if(getBankingItem() != -1)
				 Deposit(getBankingItem(), 1);
			 else
			 	CloseBank();
			 Wait(120);
		 }
	 }
}
// 3rxbot is an 3rxnet(3rxnet.org) product, Created by Ben Barkay aka OMFG
