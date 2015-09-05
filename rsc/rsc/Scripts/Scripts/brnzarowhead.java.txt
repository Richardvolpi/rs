//Edited Bronze Plate Smelter By ElusioN
//To Smith Bronze Arow Heads
//99% of the work was done By ElusioN
public class brnzarowhead extends Script

{
    public brnzarowhead(mudclient rs)
    {
        super(rs);

    }
    public String[] getCommands()
    {
        return new String[]{"smithbrnzhead"};

    }
    public void start(String command, String parameter[])

    {
    DisplayMessage("@cya@F@gr2@e@cya@r@gr2@t@cya@y@gr2@<@cya@3@gr2@: @whi@Bronze Arow Head Smither script by - @cya@F@gr2@e@cya@r@gr2@t@cya@y@gr2@<@cya@3", 3);
    while (Running() == true)
    {
    Walk(150,503);
    Wait(100);

    while (QuestMenu() == false && Running() == true)
        {
            int BankerID = GetNearestNPC(95);
            TalkToNPC(BankerID);
            Wait(2000);
        }

        Answer(0);

        while (Bank() == false && Running() == true)
        {
            Wait(50);
        }


        while (Bank() == true && Running() == true)
        {
            while(InvCount(669) > 0)
            {
                Deposit(669,5);
                Wait(100);
            }

            while(InvCount(169) < 25)
            {
                Withdraw(169,1);
                Wait(100);
            }

            CloseBank();
        }
       Walk(150,503);
            Wait(100);
            Walk(150,507);
             Wait(100);
              Walk(148,512);
       Wait(100);
            while (Running() == true && InvCount(669) < 250)
            {
         UseOnObject(148,513,5);
    Wait(1000);

    for(; !QuestMenu(); Wait(10));
         Answer(2);
         for(; !QuestMenu(); Wait(10));
         Answer(0);
         Wait(1000);
         }
         
     if(Fatigue() > 90 && Running() == true)
            {
                while (Sleeping() == false)
                {
                    Use(FindInv(1263));
                    Wait(3000);
                }

                while (Sleeping() == true)
                {
                    Wait(200);
 
         
               }
           }   
      }

DisplayMessage("@cya@F@gr2@e@cya@r@gr2@t@cya@y@gr2@<@cya@3@gr2@: @whi@Bronze Arow Head Smither script by - @cya@F@gr2@e@cya@r@gr2@t@cya@y@gr2@<@cya@3 - @red@Stopped", 3);
}
}