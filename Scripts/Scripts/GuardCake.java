
public class GuardCake extends Script
{
public int thieved = 0;
public GuardCake(mudclient rs)
{
        super(rs);
}
public String[] getCommands()
{
          return new String[]{"guardme"};     
}
public void ServerMessage(String message)
   {
      if (message.equals("@gam@You pick the guard's pocket"))
         thieved++;
   }   
public void start(String command, String parameter[]) 
{
if (parameter.length != 2)
{
DisplayMessage("@gre@Bruncle: @whi@Invalid number of parameters. /RUN guardmep [STYLE]@[Time till report]", 3);
} else {
int FightMode = Integer.parseInt(parameter[0]);
int reporttime = Integer.parseInt(parameter[1]);
int FightTime = 750;
int foodID[] = {330,333,335};
int food = 0;
long ranfor = 0;
int cakes = 0;
int slept = 0;
double xp = 0;
long time = System.currentTimeMillis();
long starttime = System.currentTimeMillis();
int startlevel = GetStat(17);
CheckFighters(true);
DisplayMessage("@gre@Bruncle: @whi@Guard Thiever @ran@Started- @whi@Bruncle", 3);
while (Running())
{
   if (System.currentTimeMillis() - time > (reporttime * 60000))
      {
      int level = GetStat(17) - startlevel;
      time = System.currentTimeMillis();
      int typed = 0;
      while (typed < 20)
      {
         System.out.print("-");
         Wait(10);
         typed ++;
      }
      Wait(5);
      System.out.println("");
      String msg[] = {"P ","R ","O ","G ","R ","E ","S ","S "," R ","E ","P ","O ","R ","T:"};
      typed = 0;
      while (typed < 14)
      {
         System.out.print(msg[typed]);
         typed ++;
         Wait(20);
      }   
      typed = 0;
      while (typed < 20)
      {
         System.out.print("-");
         Wait(10);
         typed ++;
      }
      xp = thieved * 56.5;
      ranfor = (System.currentTimeMillis() - starttime) / (60000 );
      typed = 0;
      System.out.println("");
      String msg1[] = {"Y","o","u"," ","h","a","v","e"," ","b","e","e","n"," ","a","u","t","o","i","n","g"," ","f","o","r"};
      while (typed < 25)
      {
      System.out.print(msg1[typed]);
      typed ++;
      Wait(50);
      }
      System.out.print(" " + ranfor);
      typed = 0;
      String msg2[] = {" M","i","n","u","t","e","s"};
      while (typed <= 6)
      {
      System.out.print(msg2[typed]);
      typed ++;
      Wait(50);
      }
      System.out.println("");
      String msg3[] = {"Y","o","u"," ","h","a","v","e"," ","t","h","i","e","v","e","d "};
      typed = 0;
      while (typed <= 15)
      {
      System.out.print(msg3[typed]);
      typed ++;
      Wait(50);
      }
      System.out.print(thieved);
      String msg4[] = {" G","u","a","r","d","s!"};
      typed = 0;
      while (typed <= 5)
      {
      System.out.print(msg4[typed]);
      typed ++;
      Wait(50);
      }
      System.out.println("");
      String msg5[] = {"Y","o","u"," ","h","a","v","e"," ","g","a","i","n","e","d "};
      typed = 0;
      while (typed <= 14)
      {
      System.out.print(msg5[typed]);
      typed ++;
      Wait(50);
      }
      System.out.print(xp);
      String msg6[] = {" e","x","p","e","r","i","e","n","c","e"};
      typed = 0;
      while (typed <= 9)
      {
      System.out.print(msg6[typed]);
      typed ++;
      Wait(50);
      }
      System.out.println("");
      typed = 0;
      while (typed <= 14)
      {
      System.out.print(msg5[typed]);
      typed ++;
      Wait(50);
      }
      System.out.print(level);
      String msg7[] = {" t","h","i","e","v","i","n","g"," ","l","e","v","e","l","s"};
      typed = 0;
      while (typed <= 14)
      {
      System.out.print(msg7[typed]);
      typed ++;
      Wait(50);
      }
      System.out.println("");
      String msg8[] = {"Y","o","u"," ","h","a","v","e"," ","t","h","i","e","v","e","d "};
      typed = 0;
      while (typed <= 15)
      {
      System.out.print(msg8[typed]);
      typed ++;
      Wait(50);
      }
      System.out.print(thieved*30);
      String msg9[] = {" g","p"};
      typed = 0;
      while (typed <= 1)
      {
      System.out.print(msg9[typed]);
      typed ++;
      Wait(50);
      }
      System.out.println("");
      String msg10[] = {"Y","o","u"," ","h","a","v","e"," ","s","l","e","p","t "};
      typed = 0;
      while (typed <= 13)
      {
      System.out.print(msg10[typed]);
      typed ++;
      Wait(50);
      }
      System.out.print(slept);
      String msg11[] = {" t","i","m","e","s"};
      typed = 0;
      while (typed <= 4)
      {
      System.out.print(msg11[typed]);
      typed ++;
      Wait(50);
      }
      System.out.println("");
      String msg12[] = {"Y","o","u"," ","h","a","v","e"," ","g","o","n","e"," ","f","o","r"," ","f","o","o","d "};
      typed = 0;
      while (typed <= 21)
      {
      System.out.print(msg12[typed]);
      typed ++;
      Wait(50);
      }
      System.out.print(cakes);
      typed = 0;
      while (typed <= 4)
      {
      System.out.print(msg11[typed]);
      typed ++;
      Wait(50);
      }
      typed = 0;
      while (typed < 20)
      {
         System.out.print("-");
         Wait(10);
         typed ++;
      }
      }
   if (Fatigue() >= 95 && Running() == true)
   {
         while (Sleeping() == false && Running() == true)
        {
               Use(FindInv(1263));
               Wait(2500);
         }
         while (Sleeping() == true && Running() == true)
               {Wait(100);}
         }
         if (GetCurrentStat(3) <= (GetStat(3) - 5) && Running() && !InCombat() )
            {
               if (InvCount(foodID[0]) > 0)
               {
                     food = FindInv(foodID[0]);
               }
               if (InvCount(foodID[1]) > 0)
               {
                     food = FindInv(foodID[1]);
               }
               if (InvCount(foodID[2]) > 0)
               {
                          food = FindInv(foodID[2]);
               }
               Use(food);
               Wait(2500);
            }
   if(!InCombat() && Running()&& GetCurrentStat(3) > (GetStat(3) - 5))
   {
      SetFightMode(FightMode);
      int guard = GetNearestNPC(321);
      ThieveNPC(guard);
      Wait(700);
          }
   while(InCombat() && Running())
   {   
      SetFightMode(FightMode);
      WalkNoWait(GetX(),GetY());
      Wait(2000);
   }
   if (InvCount(foodID[0]) == 0 && InvCount(foodID[1]) == 0 && InvCount(foodID[2]) == 0 && Running() && !InCombat())
   {
      Wait(2000);
      ForceWalk(543,600);
      Wait(1000);
      int items = 30 - InvCount();
      while(InvCount(foodID[0]) < items && Running() && Fatigue() < 100)
      {
         if (ObjectAt(544,599) == 322 && !InCombat())
         {
            AtObject2(544,599);
            Wait(400);
         }
         while(InCombat() && Running())
         {       
            WalkNoWait(GetX()+2,GetY());
            WalkNoWait(GetX()-2,GetY());
            WalkNoWait(GetX(),GetY()+ 2);
            WalkNoWait(GetX(),GetY()- 2);
            SetFightMode(FightMode);
         }
             
      }
               
       }
}
DisplayMessage("@gre@Bruncle: @whi@Guard Thiever - @red@STOPPED", 3);
}
}
} 