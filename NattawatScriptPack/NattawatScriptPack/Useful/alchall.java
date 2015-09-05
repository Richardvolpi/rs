/* 
 * ANYTHING Alchemy (Low/High) by Nattawat
 * Will low/high alch anything, bank money, then take more items
 * Works with ANY BANKER in RuneScape, this include normal Banker, Al Kharid's Banker, Fairy Banker, Gnome Banker, and Jungle Banker.
 * /start alchall
 */

public class alchall extends Methods
{
    public alchall(mudclient mc){super(mc);}
    private int ItemID = -1;
    private String[] op1 = {"Low Level Alchemy","High Level Alchemy"};
    private String[] op2 = {"Steel Plate Mail Body","Mithril Plate Mail Body","Adamantite Plate Mail Body","Rune Short Sword","Medium Rune Helmet","Other..."};
    private int a = -1;
    private int b = -1;
    private int spell = -1;
    private int[] banker = {95,224,268,540,617};
    
    public void MainBody(String Args[])
    {
        a = GetOption("Which spell would you like to alch?",op1);
        if(a == 0)
        {
            spell = 10;
        }
        if(a == 1)
        {
            spell = 28;
        }
        b = GetOption("Which item would you like to alch?",op2);
        if(b == 0)
        {
            ItemID = 118;
        }
        if(b == 1)
        {
            ItemID = 119;
        }
        if(b == 2)
        {
            ItemID = 120;
        }
        if(b == 3)
        {
            ItemID = 397;
        }
        if(b == 4)
        {
            ItemID = 399;
        }
        if(b == 5)
        {            
            ItemID = StrToInt(GetInput("What is the ID of the item you would like to alch"));
        }
        AutoLogin(true);
        Display("@cya@Anything Alcher -- @gre@Nattawat @red@<3");
        while(Running())
        {
            if(CountInv(ItemID) > 0 && Running())
            {
                alch();
            }
            banking();
        }
    }

    public void banking()
    {
        while (CountInv() < 30 && Running())
        {
            Display("@whi@Banking...");
            while(!QuestMenu() && Running())
            {
                int[] Npc = GetNpcById(banker);
                if(Npc[0] != -1)
                TalkToNpc(Npc[0]);
                Wait(1500);
            }
            while(QuestMenu() && Running())
            {
                Answer(0);
                Wait(8000);
            }
            while(!InBank() && CountInv() < 30 && Running())
                banking();
            while(InBank() && CountInv() < 30 && Running())
            {
                 while(CountInv(40) < 30 && InBank() && Running())
                 {
                      if(!ItemInBank(40))
                         End("You are low on nature runes, SCRIPT STOPPED!");
                      Withdraw(40,25);
                      Wait(1500);
                 }
                 while(CountInv(10) >= 2500 && InBank() && Running())
                 {
                      Deposit(10,2500);
                      Wait(Rand(200,500));
                 }
                 while(CountInv() < 30 && InBank() && Running())
                 {
                      Withdraw(ItemID,1);
                      Wait(Rand(200,500));
                 }
                 while(CountInv() < 30 && !InBank() && Running())
                 {
                      banking();
                 }
               CloseBank();
           }
        }
        alch();
    }

    public void alch()
    {
        Display("@whi@Alching...");
        if(!InInv(197) && Running()) {End("You don't have Staff of Fire, SCRIPT STOPPED!");}
        while(CountInv(ItemID) > 0 && InInv(197) && Running())
        {
            if(!SleepIfAt(90)) {End("You don't have sleeping bag, SCRIPT STOPPED!");}
            CastOnItem(spell,GetItemPos(ItemID));
            Wait(2000);
        }
        banking();
    }

    public void OnChatMessage(String sender, String message)
    {
        if((sender.substring(0,4).equalsIgnoreCase("mod ") || sender.equalsIgnoreCase("andrew") || sender.equalsIgnoreCase("paul")))
        {
            Wait(Rand(4000,7000));
            Speak("Wow, you are really " + sender + "?!?");
            Wait(Rand(5000,6000));
            Speak("let me take a screenshot woopies!!");
            Wait(Rand(5000,6000));
            Speak("brb 1 sec, i gotta paste it in paint :)");
            Wait(Rand(5000,6000));
            LogOut();
            Die();
        }
    }
    
    public void OnPrivateMessage(String sender, String message)
    {
        if((sender.substring(0,4).equalsIgnoreCase("mod ") || sender.equalsIgnoreCase("andrew") || sender.equalsIgnoreCase("paul")))
        {
            AddToFriends(sender);
            Wait(Rand(5000,8000));
            SendPM(sender, "Hey " + sender + " what do you need? :P");
            Wait(Rand(5000,6000));
            SendPM(sender, "hold on, my dad is coming, ill be dead if he caught me playing");
            Wait(Rand(5000,6000));
            LogOut();
            Die();
        }
    }
    
    public void OnServerMessage(String message)
    {
    }
}