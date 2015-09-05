public class DummyTrainer extends Script
{
   public DummyTrainer(mudclient rs)
   {
       super(rs); 
   }
   public String[] getCommands()
   {
       return new String[]{"dummytrainer"};
   }
   

   public boolean BagHit = false;
   public boolean Stout = false;
   public boolean Sleep = false;
   
   public void serverMessage(String message)
   {
       if(message.indexOf("you can learn") > 0)
       Stout = true;
       if(message.indexOf("You hit the") > 0)
       BagHit = true;
       if (message.equals("@gre@You are too tired to gain experience, get some rest!"))
       Sleep = true;
       if(message.indexOf("too tired") > 0)
       Sleep = true;
   }
   
   public void Sleep()
   {
       if(!sleeping())
   {
       println("Sleeping");
     wait(random(2000,3000));
     useByType(1263);
     wait(random(3000,4000));
   }
   while(sleeping())
       wait(random(400,700));
       Sleep = false;
   

   }
   
   public void Stout()
   {
       if(invCount(269) > 0)
       {
           int StoutCount = invCount(269);
           long t = tickCount();
           useByType(269);
           while(StoutCount == invCount(269) && tickCount() - t < random(4000,5000))
           wait(random(50,100));
           Stout = false;
           wait(3000);
       }
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
                       {
  setFightMode(1);
  println("### FightMode Set to 1");
                       }
                   }
               }
           }
       ).start();
  }

   public void start(String command, String parameter[])
   {
   Mode();
   long StartTime = System.currentTimeMillis();
   int StartExp = experience(0);
   println("### Dummy Trainer - Kingokings");
 while (running())
 {
 //Attack Dummies
 
 while(running() && invCount(269) > 0)
 {
     BagHit = false;
       int bag = -1;
       int exp = experience(0);
       bag = findObject(106,504);
       if(bag != -1)
       {
           if(!atObject(bag))
           {
               println("error hitting bag?");
           }
           long t = tickCount();
           while(tickCount() - t < random(5000,7000) && !BagHit && !Stout && !Sleep)
           wait(random(150,250));
       }
       if(Stout)
       Stout();
       if(Sleep)
       Sleep();
   }
 
 //Walk To Bank
 

  while(!canReach(104,506))
  {
      openDoor(findDoor(104,506));
      println("Opening Door");
      wait(random(800,1000));
      walk(104,507);
      wait(random(800,1000));
  }
  
      while(myPlayerY() < 506)
   {
   walkNoWait(104,507);
   wait(random(900,1100));
   }
  
 
 //Bank
 
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
                wait(random(2515,4003));
             }
             println("Talking to banker " + banker);
             resetLastQuestMessage();
             talkToNpc(banker);
             long t = tickCount();
             while (tickCount() - t < random(6022,8011) && !inLastQuestMessage("busy") &&!questMenu())
            wait(1);
          }
       }
       while (!bank() && running())
       {
          println("Answering banker...");
          answerQuestMenu(0);
          long t = tickCount();
          while (tickCount() - t < random(6022,8011) && !bank())
          wait(1);
       }
 }

 
 while (invCount(620) > 0 && bank() && running())
 {
     deposit(620);
   wait(random(81,122));
 }
 while (invCount() != 30 && bank() && running() && bankCount(269) != 0)
 {
     withdraw(269);
   wait(random(81,122));
 }
 
 long TotalTime = System.currentTimeMillis() - StartTime;
   long Minutes = TotalTime / 60000L;
   if(Minutes < 1)
   Minutes = 1;
   int ExpGained = experience(0) - StartExp;
 println("### Progress Report");
 println("Time Elasped: " + Minutes + " Minutes");
 println("Exp Gained: " + ExpGained + " exp");
 println("Exp per Hour: " + ((ExpGained / Minutes) * 60) + "Exp/Hr");
 println("Stouts Left in Bank: " + bankCount(269));

 wait(random(600,1200));
 closeBank();
 
 //Walk Back
 
 walk(104,507);
 
  while(!canReach(104,505))
   {
       openDoor(findDoor(104,506));
       println("Opening Door");
       wait(random(800,1000));
       walk(104,504);
       wait(random(800,1000));
   }
   
   while(myPlayerY() > 505)
   {
   walkNoWait(104,505);
   wait(random(900,1100));
   }

 }
 endScript();
   }
}