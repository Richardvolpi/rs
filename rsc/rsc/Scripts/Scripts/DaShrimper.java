public class DaShrimper extends Script
{
   public DaShrimper(mudclient rs)
   {
       super(rs);
   }
   public String[] getCommands()
   {
       return new String[]{"dashrimper"};
   }
   public void start(String command, String parameter[])
   {
  DisplayMessage("@ran@=@red@=@blu@=@cya@=@ran@= @whi@Da Shrimper -- By Zesty @ran@=@red@=@blu@=@cya@=@ran@=",3);

  while (Running())
  {
     if (Fatigue() >= 95 && Running() == true)
     {
        while (Sleeping() == false && Running() == true)
        {
           Use(FindInv(1263));
           Wait(2500);
        }
        while (Sleeping() == true && Running() == true)
           Wait(100);
     }
     int i[] = GetNearestObject(193);
           AtObject(i[0], i[1]);
      Wait(600);
  }
  DisplayMessage("@red@STOPPED", 3);
   }
}