public class Cooker extends Script
{
   
    public Cooker(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
       return new String[]{"cooker"};
   }
   
   public void start(String command, String parameter[])
   {
         
   while(Running() == true)
   {

       while(Bank() == false &&  InvCount(349) < 29)
{
           while(!QuestMenu())
           {
               int BankerID = GetNearestNPC(95);
           TalkToNPC(BankerID);
           Wait(1000);
           }
          while(QuestMenu() == true)
{
Wait(200);           
Answer(0);
           Wait(10000);
        }
}

           while(InvCount(350) > 0 && Bank() == true)
           {
               Deposit(350,1);
               Wait(300);
           }
           while (InvCount(353) > 0 && Bank() == true)
           {
               Deposit(353,1);
               Wait(300);
           }



           while (InvCount() < 29 && Bank() == true)
           {
               Withdraw(349,1);
               Wait(300);
           }
  Wait(100);
       CloseBank();


       Wait(1000);
       Walk(218,446);
       Wait(50);
       Walk(225,445);
       Wait(50);



       if(DoorAt(225,444,0) == 2)
       {
           OpenDoor(225,444,0);
           Wait(200);
       }

       Walk(225,441);


       while(GetY() < 1000 && Running() == true)
       {
           AtObject(226,439);
           Wait(1000);
       }

       Wait(2000);
while(GetY() > 1000 && InvCount(358) > 0)
{
       if(InvCount(358) > 0 && Running() == true && GetY() > 1000 && Fatigue() <= 96 && Sleeping() == false)
       {
           UseOnObject(222,1385,FindInv(358));
           Wait(2000);
}



              else if (Fatigue() > 96 && Running() == true)
               {
                   while (Sleeping() == false)
                   {
                       Use(FindInv(1263));
                       Wait(2500);
                   }
 
                   while (Sleeping() == true)
                   {
                       Wait(100);
                   }
               }
}
       Wait(1000);



       while(GetY() > 1000 && Running() == true && InvCount(358) == 0)
       {
           AtObject(226,1383);
           Wait(1000);
       }

 
       if(DoorAt(225,444,0) == 2)
       {
           OpenDoor(225,444,0);
           Wait(100);
       }


       Walk(225,445);
       Wait(50);
       Walk(217,446);
       Wait(50);
       Walk(217,449);
       
       
   }
   }
}