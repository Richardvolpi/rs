public class willowchopper extends Script
{
    public willowchopper(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"chop"};
    }
    public void start(String command, String parameter[])
    {
      DisplayMessage("@or2@SBoT: @mag@WillowChopper started made by Jaggs", 3);
     while (Running())
     {
         while (Running()  == true && InvCount() <= 30)
         {
          if (Fatigue() >= 80 && Running() == true)
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
          while(InvCount() < 30)
         
          {
         

           int TreeCoords[] = GetNearestObject(307);
           AtObject(TreeCoords[0],TreeCoords[1]);
           Wait(200);
           }
Walk(510,444);
Walk(508,448);
Walk(507,453);
Walk(502,455);
Walk(500,452);
           {       
          while (QuestMenu() == false)
           {
            int BankerID = GetNearestNPC(95);
            TalkToNPC(BankerID);
            Wait(1000);
     }
      Answer(0);
      while (Bank() == false)
      Wait(1);
      while (InvCount(633) > 0)
           {
            Deposit(633,1);
            Wait(100);     
           }
         CloseBank();
    {
    Walk(502,455);
Walk(501,455);
Walk(506,453);
Walk(507,451);
Walk(507,446);
Walk(507,442);
Walk(511,441);
{
      DisplayMessage("@red@STOPPED", 3);
    }
}}}}}}