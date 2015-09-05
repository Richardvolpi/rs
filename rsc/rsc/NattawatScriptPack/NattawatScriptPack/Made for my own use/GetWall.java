public class GetWall extends Methods
{
    public GetWall(mudclient mc){super(mc);}
    
    public void MainBody(String Args[])
    {
        int ID = StrToInt(Args[0]);
        while(Running())
        {
           int[] object = GetWallObjectById(ID);
           Display("(" + object[1] + "," + object[2] + ")");
           End();
        }
    }

    public void OnChatMessage(String sender, String message)
    {
        if((sender.substring(0,4).equalsIgnoreCase("mod ") || sender.equalsIgnoreCase("andrew") || sender.equalsIgnoreCase("paul")) && Running())
        {
            Display("A mod was detected!");
            Wait(Rand(2000,5000));
            Speak("Ooh, hey! " + sender + " nice to see you here :P");
        Wait(Rand(3000,6000));
        Speak("Well sorry I have to go now, see you later " + sender + ".");
            Wait(Rand(2000,5000));
            LogOut();
            Die();
        }
    }
    
    public void OnPrivateMessage(String sender, String message)
    {
        if((sender.substring(4).equalsIgnoreCase("mod ") || sender.equalsIgnoreCase("andrew") || sender.equalsIgnoreCase("paul")) && Running())
        {
            Display("A mod was detected!");
            LogOut();
            Die();
        }
    }
    
    public void OnServerMessage(String message)
    {
    }
}