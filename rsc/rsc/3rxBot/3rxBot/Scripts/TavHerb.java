public class TavHerb extends Methods
{
	public TavHerb(mudclient rs) { super(rs); }
	public void Main(String p[])
	{
		int PID = StrToInt(p[0]);
		GetPid(PID);
		int[] ids = {439,441,442,40,42,33};
		while(Running())
		{
			while(CountInv() < 30 && Running())
			{
				if(GetFatigue() >= 80)
				{
					while(!Sleeping())
					{
						UseItem(GetItemPos(1263));
						Wait(500);
					}
					while(Sleeping())
					{
						Wait(1000);
					}
				}
				int[] items = GetItemById(ids);
				int[] npc = GetNpcById(270);
				if(items[0] != -1 && Running())
				{
					PickupItem(items[1], items[2], items[0]);
					Wait(100);
				}
				else if(npc[0] != -1 && Running())
				{
					AttackNpc(npc[0]);
					Wait(100);
				}
				else
					Wait(100);
				while(InCombat() && Running())
					Wait(50);
			}
			WalkToo(348,3320);
			WalkToo(355,3319);
			WalkToo(366,3320);
			WalkToo(373,3322);
			WalkToo(376,3331);
			WalkToo(376,3338);
			WalkToo(377,3346);
			WalkToo(376,3350);
			while(GetY() > 1000)
			{
				AtObject(376,3352);
				Wait(1000);
			}
			Wait(2000);
			WalkToo(376,514);
			WalkToo(371,510);
			WalkToo(373,502);
			WalkToo(374,494);
			WalkToo(370,490);
			WalkToo(365,487);
			WalkToo(361,486);
			WalkToo(356,485);
			WalkToo(349,486);
			WalkToo(345,488);
			WalkToo(343,488);
			Wait(2000);
			while(GetX() > 341)
			{
				AtObject(341,487);
				Wait(5000);
			}
			Wait(2000);
			WalkToo(337,490);
			WalkToo(335,494);
			WalkToo(332,499);
			WalkToo(326,505);
			WalkToo(320,510);
			WalkToo(315,515);
			WalkToo(315,523);
			WalkToo(314,531);
			WalkToo(316,537);
			WalkToo(324,542);
			WalkToo(326,549);
			WalkToo(327,553);
			WalkToo(329,553);
			while(!InBank() && Running())
				OpenBank();
			for(int i = 0; i < ids.length; i++)
			{
				Deposit(ids[i],CountInv(ids[i]));
				Wait(2000);
			}
			CloseBank();
			WalkToo(328,553);
			WalkToo(326,552);
			WalkToo(326,544);
			WalkToo(322,539);
			WalkToo(324,531);
			WalkToo(321,523);
			WalkToo(317,521);
			WalkToo(318,513);
			WalkToo(324,505);
			WalkToo(330,500);
			WalkToo(336,494);
			WalkToo(341,488);
			Wait(2000);
			while(GetX() < 342)
			{
				AtObject(341,487);
				Wait(5000);
			}
			Wait(2000);
			WalkToo(344,492);
			WalkToo(347,496);
			WalkToo(350,499);
			WalkToo(352,506);
			WalkToo(358,511);
			WalkToo(366,519);
			WalkToo(375,526);
			WalkToo(376,521);
			while(GetY() < 1000)
			{
				AtObject(376,520);
				Wait(2500);
			}
			Wait(2000);
			WalkToo(376,3345);
			WalkToo(377,3337);
			WalkToo(376,3329);
			WalkToo(373,3324);
			WalkToo(366,3320);
			WalkToo(358,3319);
			WalkToo(351,3319);
			WalkToo(347,3320);
			}
		}
	public void OpenBank()
	{
		while(!QuestMenu() && Running())
		{
			l = GetMillis();
			int Banker[] = GetNpcById(95);
			if(Banker[0] != -1)
				TalkToNpc(Banker[0]);
			WaitForBank();
		}
		Answer(0);
		l = GetMillis();
		while(!InBank() && Running() && GetMillis() - l < 10000)
			Wait(1000);
	}
	public long l;
	public void WaitForBank()
	{
		while(GetMillis() - l < 5000 && !QuestMenu() && Running())
			Wait(1000);
	}
	int[] bankx = new int[] { };
	int[] banky = new int[] {  };
	int[] herbx = new int[] {  };
	int[] herby = new int[] {  };
	int[] ladderx = new int[] {  };
	int[] laddery = new int[] {  };
	int[] ladder2x = new int[] {  };
	int[] ladder2y = new int[] {  };
	private void longwalk(int[] xcoord, int[] ycoord)
	{
		for(int WalkToo = 0; WalkToo < xcoord.length; WalkToo++)
			WalkToWait(xcoord[WalkToo],ycoord[WalkToo]);
	}
	public void WalkToo(int x, int y)
	{
		while(GetX() != x || GetY() != y)
		{
			WalkTo(x,y);
			Wait(500);
		}
	}

	public void GetPid(int id)
	{
		AutoLogin(true);
		while(GetPid() > id)
		{
			if(LoggedIn())
			{
				Wait(2000);
				if(GetPid() > id)
					LogOut();
			}
			Wait(500);
		}
	}
}