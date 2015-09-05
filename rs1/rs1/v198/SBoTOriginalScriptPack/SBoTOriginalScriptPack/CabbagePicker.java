public class CabbagePicker extends Script
{
    public CabbagePicker(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"cabbage"};
    }
    public void start(String command, String parameter[])

    {
        DisplayMessage("@gre@SBoT: @whi@Cabbage Pickup Falador - @ran@Vegunks",3);
        while (Running() == true)
        {
       
        //Banking

         while (Bank() == false && Running() == true)
         {
            while (QuestMenu() == false && Running() == true)
            {
               int BankerID = GetNearestNPC(95);
               TalkToNPC(BankerID);
               long Time = System.currentTimeMillis();
               while (System.currentTimeMillis() - Time <= 2000 && QuestMenu() == false && Running() == true)
                  Wait(1);
            }
            Answer(0);
            long Time = System.currentTimeMillis();
            while (System.currentTimeMillis() - Time <= 5000 && Bank() == false && Running() == true)
               Wait(1);
         }
        while (Bank() == true && Running() == true)
        {
            while(InvCount(18) > 0)
            {
                Deposit(18,1);
                Wait(100);
            }
            CloseBank();
       
        }
   Walk(287,571);
   Wait(100);
         while (ObjectAt(287,571) == 64 && Running() == true)
         {
            System.out.println("Opened Bank door");
            AtObject(287,571);
            Wait(1000);
         }
         if (Running() == true)
            Walk(287,571);
         Wait(100);
        //Walking To Cabbage Field
   Walk(288,572);
   Wait(100);
   Walk(289,577);
   Wait(100);
   Walk(290,582);
   Wait(100);
   Walk(285,586);
   Wait(100);
   Walk(283,591);
   Wait(100);
   Walk(281,595);
   Wait(100);
   Walk(279,604);
   Wait(100);
   Walk(274,608);
   Wait(100);
   Walk(267,608);
   Wait(100);
   Walk(257,608);
   Wait(100);
   Walk(255,605);
   Wait(100);
   Walk(255,602);
   Wait(1000);


        //Picking Up of the Cabbage
   while (Running() == true && InvCount(18) < 30)
                     
         if (GetNearestItem(18) != null)
         {
            int ItemPos[] = GetNearestItem(18);

            TakeItem(ItemPos[0], ItemPos[1],18);
            Wait(1500);
         }
        //Walk to Bank
   Walk(255,602);
   Wait(100);
   Walk(255,605);
   Wait(100);
   Walk(257,608);
   Wait(100);
   Walk(267,608);
   Wait(100);
   Walk(274,608);
   Wait(100);
   Walk(279,604);
   Wait(100);
   Walk(283,591);
   Wait(100);
   Walk(285,586);
   Wait(100);
   Walk(290,582);
   Wait(100);
   Walk(289,577);
   Wait(100);
   Walk(288,572);
   Wait(100);
   Walk(287,571);
   Wait(1000);
         while (ObjectAt(287,571) == 64 && Running() == true)
         {
            System.out.println("Opened Bank door");
            AtObject(287,571);
            Wait(1000);
         }
         if (Running() == true)
            Walk(287,571);
         Wait(100);
    }
}
}