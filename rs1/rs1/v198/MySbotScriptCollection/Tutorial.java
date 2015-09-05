public class Tutorial extends Script
{
   boolean IsBusy = false;
    public Tutorial(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"tutorial"};
    }
   public void ServerMessage(String message)
   {
   }
    public void start(String command, String parameter[])
    {
      WaitForNPCMessage(476,15,"Left click on");
      WaitForQuestMenu();
      Answer(0);
      WaitForNPCMessage(10,"various aspects of the game");
      while (GetX() < 222)
      {
         Walk(221,743);
         OpenDoor(222, 743, 1);
         Wait(2500);
      }
      WaitForNPCMessage(499,90,"speak to the combat instructor");
      while (GetY() > 736)
      {
         Walk(224,737);
         OpenDoor(224, 737, 0);
         Wait(2500);
      }
      WaitForNPCMessage(474, 40, "Their box will go red");
      Wield(FindInv(4));
      Wait(1000);
      Wield(FindInv(70));
      ResetLastNPCMessage();
      while (LastNPCMessage().indexOf("Now speak to the combat") < 0)
      {
         int ID = GetNearestNPC(473);
         AttackNPC(ID);
         Wait(2500);
      }
      WaitForNPCMessage(474,60,"northeast");
      while (GetX() > 219)
      {
         Walk(220,727);
         OpenDoor(220, 727, 1);
         Wait(2500);
      }
      WaitForNPCMessage(478,60,"In this case use it on the range");
      ResetLastNPCMessage();
      while (LastNPCMessage().indexOf("speak to the cooking instructor again") < 0)
      {
         UseOnObject(216, 731, FindInv(503));
         Wait(5000);
      }
      WaitForNPCMessage(478,60,"another piece of meat");
      ResetLastNPCMessage();
      while (LastNPCMessage().indexOf("speak to the cooking instructor again") < 0)
      {
         UseOnObject(216, 731, FindInv(503));
         Wait(5000);
      }
      WaitForNPCMessage(478,90,"If the number on the left");
      Wait(5000);
      WaitForNPCMessage(478,60,"proceed through the next door");
      while (GetX() > 211)
      {
         Walk(212,729);
         OpenDoor(212, 729, 1);
         Wait(2500);
      }
      WaitForNPCMessage(480,90,"the next door");
      while (GetX() > 205)
      {
         Walk(206,730);
         OpenDoor(206, 730, 1);
         Wait(2500);
      }
      Walk(201,726);
      WaitForNPCMessage(479,90,"you might catch some fish");
      while (FindInv(349) == -1)
      {
         AtObject(196,726);
         Wait(1000);
      }
      WaitForNPCMessage(479,90,"cook the shrimps");
      while (GetY() < 734)
      {
         Walk(201,733);
         OpenDoor(201, 734, 0);
         Wait(2500);
      }
      WaitForNPCMessage(482,90,"select prospect");
      Wait(2500);
      while (LastNPCMessage().indexOf("increase") < 0)
      {
         AtObject2(203,740);
         Wait(5000);
      }
      WaitForNPCMessage(482,90,"hit those rocks");
      Wait(2500);
      while (FindInv(202) == -1)
      {
         AtObject(203,740);
         Wait(5000);
      }
      WaitForNPCMessage(482,90,"speak to the bankers");
      while (GetY() < 746)
      {
         Walk(198,745);
         OpenDoor(198, 746, 0);
         Wait(2500);
      }
      WaitForNPCMessage(485,90,"Certainly");
      while (GetX() < 204)
      {
         Walk(203,752);
         OpenDoor(204, 752, 1);
         Wait(2500);
      }
      WaitForNPCMessage(489,90,"each quest once");
      WaitForQuestMenu();
      Answer(0);
      Wait(3000);
      while (GetY() < 754)
      {
         Walk(209,753);
         OpenDoor(209, 754, 0);
         Wait(2500);
      }
      WaitForNPCMessage(493,90,"very rewarding");
      WaitForQuestMenu();
      Answer(1);
      WaitForQuestMenu();
      Answer(0);
      WaitForNPCMessage(90,"next door");
      while (GetX() < 217)
      {
         Walk(216,760);
         OpenDoor(217, 760, 1);
         Wait(2500);
      }
      WaitForNPCMessage(494,90,"definitely");
      WaitForQuestMenu();
      Answer(1);
      WaitForNPCMessage(90,"checked this");
      Wait(5000);
      WaitForNPCMessage(494,90,"yellow in");
      Wait(5000);
      WaitForNPCMessage(494,90,"as a target");
      while (LastServerMessage().indexOf("Cast spell successfully") < 0)
      {
         int chicken = GetNearestNPC(3);
         MagicNPC(chicken,0);
         Wait(5000);
      }
      WaitForNPCMessage(494,90,"next door");
      while (GetX() < 222)
      {
         Walk(221,760);
         OpenDoor(222, 760, 1);
         Wait(2500);
      }
      System.out.println("TUTORIAL ISLAND SCRIPT COMPLETE, PWNT.");
      Quit();
    }
   public void WaitForNPCMessage(int time, String message)
   {
      ResetLastNPCMessage();
      while (LastNPCMessage().indexOf(message) < 0)
      {
         long T = TickCount();
         if (LastNPCMessage() != null)
            while (LastNPCMessage().indexOf(message) < 0 && TickCount() - T < (time * 1000))
               Wait(100);
         Wait(1000);
      }
   }
   public void WaitForNPCMessage(int type, int time, String message)
   {
      ResetLastNPCMessage();
      while (LastNPCMessage().indexOf(message) < 0)
      {
         ResetLastServerMessage();
         ResetLastNPCMessage();
         int id = GetNearestNPC(type);
         long T = TickCount();
         TalkToNPC(id);
         while (TickCount() - T < 8000 && LastServerMessage().indexOf("busy") < 0 && LastNPCMessage() == "")
            Wait(100);
         if (LastServerMessage().indexOf("busy") < 0)
         {
            T = TickCount();
            if (LastNPCMessage() != null)
               while (LastNPCMessage().indexOf(message) < 0 && TickCount() - T < (time * 1000))
                  Wait(100);
         }
         Wait(1000);
      }
   }
   public void WaitForQuestMenu()
   {
      while (!QuestMenu())
         Wait(100);
   }
}