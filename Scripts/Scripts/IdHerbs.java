public class IdHerbs extends Script
{
public IdHerbs(mudclient rs)
{
super(rs);
}
public String[] getCommands()
{
return new String[]{"idherbs"};
}
public void start(String command, String parameter[])
{
if (parameter.length != 2)
{
DisplayMessage("@gre@SBoT: @whi@Invalid number of parameters. /RUN idmeup [herbid]", 3);
} else {
int herbunid = Integer.parseInt(parameter[0]); 
int herbid = Integer.parseInt(parameter[1]); 
CheckFighters(true);
DisplayMessage("@gre@SBoT: @whi@Parameters..", 3);
while (Running() == true && GetCurrentStat(3) > 5)
{
       while (Fatigue() < 98 && Running() && InvCount(herbunid) != 0)
       {
          Use(FindInv(herbunid));
          Wait(200);
       }
       if (Fatigue() >= 95 && Running() == true)
   {
      while (Sleeping() == false && Running() == true)
     {
         Use(FindInv(1263));
         Wait(2500);
      }
      while (Sleeping() == true && Running() == true)
         Wait(100);
         }   
       if (InvCount(herbunid) == 0)
       {
          while (QuestMenu() == false && Running())
        {
           int Banker = GetNearestNPC(95);
           TalkToNPC(Banker);
           Wait(1000);
        }
        Wait(3000);
        Answer(0);
       while (! Bank() && Running())
       Wait(100);
       while (Bank() && Running())
       {
       while (InvCount(herbid) > 0 && Running())
       {
          Deposit(herbid,1);
          Wait(200);
       }
       while (InvCount(herbunid) < 29 && Running())
       {
          Withdraw(herbunid,1);
          Wait(200);
       }
       CloseBank();
       }
       }
}
DisplayMessage("@gre@SBoT: @whi@Parameters - @red@STOPPED", 3);
}
}
}
