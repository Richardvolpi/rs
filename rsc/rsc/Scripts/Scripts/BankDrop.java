// Decompiled by DJ v3.7.7.81 Copyright 2004 Atanas Neshkov  Date: 1/2/2005 4:22:55 PM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   DropInv.java


public class BankDrop extends Script
{

    public BankDrop(mudclient mudclient)
    {
        super(mudclient);
    }

    public String[] getCommands()
    {
        return (new String[] {
            "bankdrop"
        });
    }

    public void ServerMessage(String s)
    {
    }

    public void start(String s, String as[])
   
      {   
      int i = Integer.parseInt(as[0]);
     {
        DisplayMessage("@or2@sbot:@ran@bank dropper started", 3);
        do
        {
            if(!Running())
                break;
            for(; InvCount() > 0; Wait(200))
            {
Drop(0);
Wait(25);
            }

            if(InvCount() == 0)
            {
                for(; !QuestMenu(); Wait(1000))
                {
                    int b = GetNearestNPC(95);
                    TalkToNPC(b);
                }

                Answer(0);
                for(; !Bank(); Wait(1));
                for(; InvCount(i) < 30; Wait(100))
                   Withdraw(i, 1);

                CloseBank();
                DisplayMessage("@red@STOPPED", 3);
            }
        } while(true);
    }
}
}