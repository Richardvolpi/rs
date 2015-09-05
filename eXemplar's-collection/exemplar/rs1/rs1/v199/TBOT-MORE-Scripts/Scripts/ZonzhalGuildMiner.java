
/*
By: Zonzhal
Date: Nov 7, 2004, 11:24 PM
Version 0.4
A guild miner, mines only coal

Stuff to add
-door openers
-ore in bank count
-make wait times random.
*/

public class ZonzhalGuildMiner extends Script
{
   public ZonzhalGuildMiner(mudclient rs)
   {
      super(rs);
   }
   public String[] getCommands()
   {
      return new String[]{"ZGM"};
   }

////////////////////////////Main procedure///////////////////////////////

   public void start(String command, String parameter[])
   {
       println("Guild Miner ver 0.4");
       println("By: Zonzhal");
       while (running())
       {
           while (running() && invCount() < 30)
           {
//sleeping
               if(fatigue() > 92)
               {
                   println("sleeping");
                   while(!sleeping() && running())
                   {
                       useByType(1263);
                       wait(random(2000,2500));
                   }
                   while(sleeping() && running())
                   {
                       wait(50);
                   }
               }
//mining
               int nearestObject = GetNearestObject(110);
               if (nearestObject == -1)
               {
                   nearestObject = GetNearestObject(111);
               }
               if (nearestObject != -1)
               {
                   atObject(nearestObject);
                   long t = tickCount();  
                   while((objectType(nearestObject) == 110 || objectType(nearestObject) == 111) && tickCount() - t < random(2500,3000) && !inLastServerMessage("too tired") && running())
                   {
                       wait(100);
                   }
               }
               else if (myPlayerY() >= 3384)
               {
                   walk(269,3399);
               }
               else
               {
                   wait(100);
               }
           }
//walk to bank
           if (running())
           {
               while (myPlayerY() > 3000)
               {
                   atObject(findObject(274,3398));
                   wait(100);
               }
               walk(274,563);
//door open (2)
               walk(274,562);
               walk(287,572);
//door open (64)
               walkNoWait(284,571);
           }
//banking
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

       //deposits the coal
           while (invCount(155) > 0)
           {
               deposit(155,1);
               wait(100);
           }
       //deposits saphs?
           while (invCount(157) > 0)
           {
               deposit(157,1);
               wait(100);
           } 
       //deposits emeralds
           while (invCount(158) > 0)
           {
               deposit(158,1);
               wait(100);
           } 
       //deposits rubies
           while (invCount(159) > 0)
           {
               deposit(159,1);
               wait(100);
           } 
       //deposits diamonds
           while (invCount(160) > 0)
           {
               deposit(160,1);
               wait(100);
           } 

           wait(random(600,1200));
           closeBank();
//walk back to guild
           walk(286,571);
//door open (64)
           walk(287,571);
           walk(274,562);
//door open (2)
           walk(274,563);
           while (myPlayerY() < 3000)
           {
               atObject(findObject(274,566));
               wait(100);
           }
       }
       println("STOPPED");
       endScript();
   }

////////////////////////////////Methods///////////////////////////////

   public int GetNearestObject(int id)
   {
       int nearestObject = -1;
       int nearestObjectDistance = 9999;
       for(int i = 0; i < objectCount(); i++)
       {
           if(objectType(i) == 110 || objectType(i) == 111)
           {
               if(objectDistance(i) < nearestObjectDistance)
               {
                   nearestObject = i;
                   nearestObjectDistance = objectDistance(i);
               }
           }    
       }
       return nearestObject;
   }
}