public class certshark extends Script

{

    public certshark(mudclient rs)
    {
        super(rs);
       
    }
   


    public String[] getCommands()
    {
        return new String[]{"certshark"};

    }
   
   
   
    public boolean check = false;
    public boolean Reply1 = false;
    public boolean Reply2 = false;
    public boolean Reply3 = false;
    public boolean Reply4 = false;
    public boolean Reply5 = false;
    public boolean ExchangeLoop = false;

    public void ServerMessage(String message)
    {
    if(message.indexOf("what sort of ") > 0)
    Reply1 = true;
    if(message.indexOf("How many") > 0)
    Reply2 = true;
    if(message.indexOf("You exchange") > 0)
    Reply3 = true;
    }
    public void NPCMessage(String message)
    {
    if(message.indexOf("Good day, how may") > 0)
    Reply4 = true;
    if(message.indexOf("Welcome to my") > 0)
    Reply5 = true;
     
    }
     
    public void start(String command, String parameter[])
    {
   
        int Answer1 = 0;
        int Answer2 = 0;
        int Answer3 = 0;
        int BankItem = 0;
        int CerterID = 0;
        int CertID = 0;
        int WD = 0;
        String Type = "null";


if (command.equalsIgnoreCase("certshark"))  {
            Answer1 = 1;
            Answer2 = 2;
            Answer3 = 4;
            BankItem = 546;
            CerterID = 1217;
            CertID = 630;
            WD = 0;
            Type = "Shark";
            check = true;
        }


       
   DisplayMessage("@red@Certing Shark", 3);
   DisplayMessage("@mag@This was a bitch to make :'( ", 3);
   DisplayMessage("@cya@I'm Makin Waffles! :) ", 3);

     
    while(Running() && check)
    {

        if(WD == 0)
        {
          while(!Bank() && Running()) {

            while(Running() && !Reply4)
            {
                long l1 = System.currentTimeMillis();
                int bankerID = GetNearestNPC(95);
                TalkToNPC(bankerID);
                while(System.currentTimeMillis() - l1 <= 400L && !Reply4)
                Wait(1);
            }
            long l2 = System.currentTimeMillis();
            while(System.currentTimeMillis() - l2 <= 4000L && !QuestMenu())
                Wait(1);
            Answer(0);
            Reply4 = false;
            long l3 = System.currentTimeMillis();
            while(!Bank() && System.currentTimeMillis() - l3 <= 5000)
            Wait(1);

          }
        }

         if(WD == 0)
         {

            while(InvCount(CertID) > 0 && Running() && Bank())
            {
                Deposit(CertID,1);
                Wait(100);
            }
           
            while(InvCount() < 30 && Running() && Bank())
            {

                Withdraw(BankItem,1);
                Wait(100);
            }



            CloseBank();
         
 
    WalkNoWait(426,485);
    Wait(500);
    ExchangeLoop = true;

    while(WD == 0 && InvCount() == 30 && Running() && ExchangeLoop)
    {
            while(Running() && !Reply5)
            {
                  long l1 = System.currentTimeMillis();
                  
                  TalkToNPC(CerterID);
                  while(System.currentTimeMillis() - l1 <= 400L)
                  Wait(1);
            }
            long l2 = System.currentTimeMillis();
            while(!QuestMenu() && Running() && System.currentTimeMillis() - l2 <= 3000L)
            Wait(1);
            Reply5 = false;
            Wait(500);
            Answer(Answer1);
            long TO = System.currentTimeMillis();
            Wait(10);

            while(!Reply1 && System.currentTimeMillis() - TO <= 4000L)
            Wait(10);
            if(Reply1)
            {

                Answer(Answer2);
                Reply1 = false;
            }

            while(!Reply2 && System.currentTimeMillis() - TO <= 4000L)
            Wait(10);
            if(Reply2)
            {

                Answer(Answer3);
                Reply2 = false;
            }

            while(!Reply3 && System.currentTimeMillis() - TO <= 4000L)
            Wait(10);
            if(Reply3)
            {

                Reply3 = false;
                ExchangeLoop = false;
            }
            Wait(500);


    }
       
    while(WD == 1 && InvCount(BankItem) == 0 && Running() && ExchangeLoop)
    {
            while(Running() && !Reply5)
            {
                  long l1 = System.currentTimeMillis();
                  
                  TalkToNPC(CerterID);
                  while(System.currentTimeMillis() - l1 <= 400L)
                  Wait(1);
            }
            long l2 = System.currentTimeMillis();
            while(!QuestMenu() && Running() && System.currentTimeMillis() - l2 <= 3000L)
            Wait(1);
            Reply5 = false;
            Answer(Answer1);
            long TO = System.currentTimeMillis();
            Wait(10);

            while(!Reply1 && System.currentTimeMillis() - TO <= 4000L)
            Wait(10);
            if(Reply1)
            {

                Answer(Answer2);
                Reply1 = false;
            }

            while(!Reply2 && System.currentTimeMillis() - TO <= 4000L)
            Wait(10);
            if(Reply2)
            {

                Answer(Answer3);
                Reply2 = false;
            }

            while(!Reply3 && System.currentTimeMillis() - TO <=  4000L)
            Wait(10);
            if(Reply3)
            {

                Reply3 = false;
                ExchangeLoop = false;
            }


            Wait(500);


    }


   

        

    
    WalkNoWait(439,496);
    Wait(500);
    }



        if(WD == 1)
        {
          while(!Bank() && Running()) {

            while(Running() && !Reply4)
            {
                long l1 = System.currentTimeMillis();
                int bankerID = GetNearestNPC(95);
                TalkToNPC(bankerID);
                while(System.currentTimeMillis() - l1 <= 400L && !Reply4)
                Wait(1);
            }
            long l2 = System.currentTimeMillis();
            while(System.currentTimeMillis() - l2 <= 4000L && !QuestMenu())
                Wait(1);
            Answer(0);
            Reply4 = false;
            long l3 = System.currentTimeMillis();
            while(!Bank() && System.currentTimeMillis() - l3 <= 5000)
            Wait(1);

          }
        }


         if(WD == 1)
         {
            while(InvCount(BankItem) > 0 && Running() && Bank())
            {
                Deposit(BankItem,1);
                Wait(100);
            }
         }


         
         
    }

    DisplayMessage("@red@STOPPED", 3);
    }


} 