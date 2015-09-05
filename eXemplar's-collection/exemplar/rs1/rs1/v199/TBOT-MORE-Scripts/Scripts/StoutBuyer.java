
public class StoutBuyer extends Script
{
   public StoutBuyer(mudclient rs)
   {
       super(rs);
   }
   public String[] getCommands()
   {
       return new String[]{"buystout"};
   }
   
       public void Mode()
  {
     new Thread
     (
        new Runnable()
        {
           public void run()
           {
              while (running())
              {
               if (fightMode() != 1)
      setFightMode(1);
              }


           }







     }).start();
  }
   public void start(String command, String parameter[])
   {
     println("### Stout Buyer");
     Mode();
     while (running())
     {
        
           while (!bank() && running())
  {
   while (!questMenu() && running())
   {
    int banker = -1;
    for (int i = 0; i < npcCount(); i++)
     if (npcType(i) == 95)
      banker = i;
    if (banker != -1)
    {
     while(!canReachNpc(banker))
     {
      tryToFree();
      wait(random(2500,4000));
     }
     println("Talking to banker " + banker);
     resetLastQuestMessage();
     talkToNpc(banker);
     long t = tickCount();
     while (tickCount() - t < random(6000,8000) && !inLastQuestMessage("busy") &&!questMenu())
      wait(1);
    }
   }
   while (!bank() && running())
   {
    println("Answering banker...");
    answerQuestMenu(0);
    long t = tickCount();
    while (tickCount() - t < random(6000,8000) && !bank())
     wait(1);
   }
  }
  while (invCount(269) > 0 && bank() && running())
  {
   deposit(269);
   wait(random(80,150));
  }
  println("### Stouts in Bank: " + bankCount(269));
  wait(random(600,1200));
  closeBank();
  

        walk(325,547);
        walk(319,547);
        while (invCount() < 29)
        {
        
        int l1 = invCount(269);
        long l2 = tickCount();
            while (!questMenu() && running())
   {
    int bar = -1;
    for (int i = 0; i < npcCount(); i++)
     if (npcType(i) == 142)
      bar = i;
    if (bar != -1)
    {
     while(!canReachNpc(bar))
     {
      tryToFree();
      wait(random(2500,4000));
     }
     println("Talking to bar " + bar);
     resetLastQuestMessage();
     talkToNpc(bar);
     long t = tickCount();
     while (tickCount() - t < random(10000,12000) && !inLastQuestMessage("busy") &&!questMenu())
      wait(1);
    }
   }

           answerQuestMenu(2);
           while (tickCount() - l2 < random(12000,14000) && l1 == invCount(269))
      wait(1);
        }
        walk(329,553);
     }
     println("### Stout Buyer - Stopped");
   }
}
