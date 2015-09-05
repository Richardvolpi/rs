
public class FishingGuild extends Script 
{
   public FishingGuild(mudclient rs)
   {
       super(rs); 
   }
   public String[] getCommands()
   {
       return new String[]{"guildlobs"}; 
   }
   public void start(String command, String parameter[])
   {
 println("### Fishing Guild Lobsters - RichyT");
 while (running())
 {
  while(invCount() < 30 && running())
  {
   while(!sleeping() && invCount() < 30 && !inLastServerMessage("tired") && running())
   {
    int pos = findObject(589,501);
    if(pos != -1)
     atObject(pos);
    wait(random(1000,2500));
   }
   if(!sleeping() && inLastServerMessage("tired") && running())
   {
    resetLastServerMessage();
    println("sleeping");
    wait(random(3000,4000));
    useByName("Sleeping Bag");
    wait(random(3000,4000));
   }
  }
  walk(592,502);
  walk(597,502);
  walk(601,506);
  while(!coordsAt(603,504) && running())
  {
   while(!canReach(603,504) && running())
   {
    println("trying to free... " + tryToFree());
    wait(random(3000,4000));
   }
   walkNoWait(603,504);
   wait(random(2000,3000));
  }
  while(!questMenu() && running())
  {
   try
   {
    int orven = -1;
    for(int i = 0; i < npcCount(); i++)
     if(npcType(i) == 369)
      orven = i;
    if(orven == -1)
     println("no orven?!");
    else {
     talkToNpc(orven);
     resetLastServerMessage();
     long t = tickCount();
     while(tickCount() - t < random(4000,6000) && !inLastServerMessage("busy") && running())
      wait(1);
    }
    wait(1);
   }
   catch (Exception e) { println("exception finding npc!"); wait(1); }
  }
  if(questMenu() && running())
  {
   println("answering orven... " + answerQuestMenu("I have some fish to trade in"));
   long t = tickCount();
   while(tickCount() - t < random(4000,6000) && !questMenu() && running())
    wait(1);
   if(questMenu() && running())
   {
    println("answering fish type... " + answerQuestMenu("Raw Lobster"));
    t = tickCount();
    while(tickCount() - t < random(4000,6000) && !questMenu() && running())
     wait(1);
    if(questMenu() && running())
    {
     println("answering fish count... " + answerQuestMenu("Twentyfive"));
     wait(random(2000,3000));
    }
   }
  }
  while(!coordsAt(601,506) && running())
  {
   while(!canReach(601,506) && running())
   {
    println("trying to free... " + tryToFree());
    wait(random(3000,4000));
   }
   walkNoWait(601,506);
   wait(random(2000,3000));
  } 
  walk(597,502);
  walk(592,502);
 }
 endScript();
   }
public boolean coordsAt(int x, int y) { waitForShit(); if(myPlayerX() == x && myPlayerY() == y) return true; return false; }
}
