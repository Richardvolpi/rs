public class EquipBuyer extends Script
{
public EquipBuyer(mudclient rs)
{
super(rs);
}
public String[] getCommands()
{
return new String[]{"buystuff"};
}
public void start(String command, String parameter[])
{
int bought = 0;
if (parameter.length != 1)
{
DisplayMessage("@gre@Bruncle: @whi@Invalid number of parameters. /RUN buystuff [buymode (1 for vials, 2 for eyes)]", 3);
} else {
int buymode = Integer.parseInt(parameter[0]);
if (buymode == 1) 
DisplayMessage("@gre@Bruncle: @whi@Buying vials..", 3);
if (buymode == 2)
DisplayMessage("@gre@Bruncle: @whi@Buying eyes..", 3);
while (Running())
{    
   while (QuestMenu() == false && Running())
        {
      int jatix = GetNearestNPC(230);
      TalkToNPC(jatix);
      Wait(1000);
   }
   if (QuestMenu())
   {
      Wait(3000);
      Answer(0);
   }
   while (!Shop()) Wait(1);
   while (Shop() == true && Running() && InvCount() != 30)
   {

      if (buymode == 1 && Running() && InvCount() < 30 && Shop())
      {
         while (ShopCount(465) > 0 && Running() && InvCount() < 30)
         {
            Buy(465);
            Wait(200);
            bought++;
         }
      }
         if (buymode == 2 && Running() && InvCount() < 30 )
      {
         while (ShopCount(270) > 0 && Running() && InvCount() < 30)
         {
            Buy(270);
            Wait(200);
            bought++;
         }
      }
   }
   CloseShop();
   if (InvCount() == 30 && Running())
   {   
      Walk(363,488);
      Walk(356,487);
      Walk(342,488);
      Wait(2000);
      while (GetX() == 342 && Running())
      {
         AtObject(341,487);
         Wait(2000);
      }
      Walk(319,500);
      Walk(317,506);
      Walk(315,525);
      Walk(314,538);
      if (buymode == 1 && Running())
      {
         while (InvCount(465) > 0 && Running())
         {
            UseOnObject(313,539,FindInv(465));
            Wait(200);
         }
      }
      Walk(329,552);
      while (QuestMenu() == false && Running())
           {
           int Banker = GetNearestNPC(95);
           TalkToNPC(Banker);
           Wait(100);
           }
           Wait(3000);
           Answer(0);
          while (! Bank() && Running()) Wait(100);
          while (Bank() && Running())
          {
             if (buymode == 1 && Running() && Bank())
             {   
                while (InvCount(464) > 0 && Running() && Bank())
                {
                   Deposit(464,1);
                   Wait(200);
                }
                CloseBank();
             }
             if (buymode == 2 && Running() && Bank())
             {   
                while (InvCount(270) > 0 && Running() && Bank())
                {
                   Deposit(270,1);
                   Wait(200);
                }
                CloseBank();
             }
          }
          Walk(314,538);
      Walk(314,538);
      Walk(315,525);
      Walk(317,506);
      Walk(319,500);   
      Walk(332,499);
      Walk(341,488);
      Wait(3000);
      while (GetX() == 341 && Running())
      {
         AtObject(341,487);
         Wait(2000);
      }
      Walk(343,487);
      Walk(363,488);
      Walk(364,493);
      Walk(369,506);
      }
}
DisplayMessage("@gre@SBoT: @whi@Parameters - @red@STOPPED", 3);
if (buymode == 1)
System.out.println("You have bought and filled " + bought + " vials");
if (buymode == 2)
System.out.println("You have bought " + bought + " eyes");

}
}
}
