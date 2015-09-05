public class BlackKnightMager extends Methods
{

     public BlackKnightMager(mudclient rs)
     {
          super(rs);
     }

     public int xx = 0;
     public int yy = 0;

     public void Main(String[] args)
     {
          xx = GetX();
          yy = GetY();
          int spell = StrToInt(args[0]);
          while(Running())
          {
               while(doWait())
               {
				   Wait(10);
			   }
			   wTime = System.currentTimeMillis() + getTime(spell);
          }
     }

     public long wTime = 0;

     public boolean doWait()
     {
		 if(GetFatigue() > 90 && !Sleeping())
		 {
			 UseItem(GetItemPos(1263));
		 }
		 return (System.currentTimeMillis() - wTime < 0 || Sleeping());
	 }

	 public long getTime(int spellid)
	 {
		 if(GetX() == xx && GetY() == yy)
		 {
			 int[] npc = GetNpcById(189);
			 if(npc[0] != -1)
			 {
			 	CastOnNpc(spellid, npc[0]);
			 	return(2000);
			}
			return(10);
		 }
		 else
		 {
			 WalkTo(xx,yy);
			 return(Rand(200,900));
		 }
	 }

     public void OnServerMessage(String message)
     {
          //When there is a server message, This void is triggered.
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
}
// 3rxbot is an 3rxnet(3rxnet.org) product, Created by Ben Barkay aka OMFG
