/* 
 * STS Guild fisher, fishes lobsters and certs them raw.
 */

public class GuildFisher extends Methods
{
  public GuildFisher(mudclient mc){super(mc);}
  public long l;
  
  public void Body(String Args[])
  {
    AutoLogin(true);
    Display("Guild Fisher - Pntbllfrk");
    Display("Script was made while STS was in beta");
    while(Running())
    {
      while(CountInv(372) < 25)
      {
        if(GetFatigue() > 86 && Running())
        {
          while(!Sleeping() && Running())
          {
            UseItem(GetItemPos(1263));
            Wait(2500);
          }
          while(Sleeping() && Running())
            Wait(100);
        }
        AtObject(589,501);
        Wait(900);
      }
      Display("Full of lobsters Going go cert");
      WalkToWait(603,502);
      while(CountInv(372) > 0 && Running())
      {
        l = GetMillis();
        while(!QuestMenu() && GetMillis() - l < 20000)
        {
          int[] Npc = GetNpcById(369);
          if(Npc[0] != -1)
            TalkToNpc(Npc[0]);
          Wait(2000);
        }
        Wait(2000);
        Answer(1);
        l = GetMillis();
        while(!QuestMenu() && GetMillis() - l < 10000)
          Wait(10);
        Answer(1);
        l = GetMillis();
        while(!QuestMenu() && GetMillis() - l < 10000)
          Wait(10);
        Answer(4);
        Wait(3000);
        WalkToWait(590,502);
      }
    }
  }
}