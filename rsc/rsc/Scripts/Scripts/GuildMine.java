//Guildminer RichyT
//Edited by DamnMx to bank and sleep good!
public class GuildMine extends Script
{
    public GuildMine(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"guildmine"};
    }
public void start(String command, String parameter[])
//You dont need to change the line above.
{


   
      CheckFighters(false);
      DisplayMessage("@gre@SBoT: @whi@GuildMiner - RichyT", 3);
      while (Running() == true)
      {
      
         if (GetY() < 3000)
         {
            if (InvCount(155) > 0 || InvCount(157) > 0 || InvCount(158) > 0 || InvCount(159) > 0 || InvCount(160) > 0) //IF YOU HAVE COAL OR GEMS
            {

                  while (QuestMenu() == false)
                  {
                     long T = System.currentTimeMillis();
                     int BankerID = GetNearestNPC(95);
                     TalkToNPC(BankerID);
                     while (System.currentTimeMillis() - T <= 6000 && QuestMenu() == false)
                     {
                        Wait(1);
                        }
                  }
                  
                  Answer(0);
                  
               while (InvCount(155) > 0)
               {
                  Deposit(155,1);
                  Wait(50);
               }
               while (InvCount(157) > 0)
               {
                  Deposit(157,1);
                  Wait(50);
               }
               while (InvCount(158) > 0)
               {
                  Deposit(158,1);
                  Wait(50);
               }
               while (InvCount(159) > 0)
               {
                  Deposit(159,1);
                  Wait(50);
               }
               while (InvCount(160) > 0)
               {
                  Deposit(160,1);
                  Wait(50);
               }
            }
            Wait(100);
            CloseBank();
            while (ObjectAt(287,571) == 64)
            {
               AtObject(287,571);
               Wait(5000);
            }
            Walk(287,571);
            Walk(287,563);
            Walk(274,562);
            while (DoorAt(274, 563, 0) == 2)
            {
               OpenDoor(274, 563, 0);
               Wait(1000);
            }
            Walk(274,563);
            Walk(274,565);
            while (GetY() < 3000)
            {
               AtObject(274,566);
               Wait(1000);
            }
         while (InvCount() < 30 && Running() == true)
            {
               int RockTypes[] = new int[]{ 111, 110 };
               int RockCoords[] = GetNearestObject(RockTypes);
               if (RockCoords[1] < 3384)
               {
                  WalkEmpty(268,3392,270,3394);
               }
               
                  AtObject(RockCoords[0], RockCoords[1]);
                  Wait(1400);
                  if (Fatigue() > 90)
                  {
                     while (Sleeping() == false)
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
            Walk(273,3398);
               AtObject(274,3398);
               Wait(1000);
                        
            Walk(274,562);
         }
      }
      DisplayMessage("@gre@SBoT: @whi@Guild Miner - @red@STOPPED", 3);
    }
} 