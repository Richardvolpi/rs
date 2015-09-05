public class Earth extends Script
{
   public Earth(mudclient rs)
   {
       super(rs);
   }
   public String[] getCommands()
   {
       return new String[]{"earth"};
   }
   
   public void start(String command, String parameter[])
   {
      DisplayMessage("@ran@Bruncle's Black Knight mager started", 3);
      while (Running()){
     
    while(Running() && GetFightMode() == 3 && InvCount(33) > 0 && InvCount(34) > 0 && GetNearestNPC(189) != -1){
     MagicNPC(GetNearestNPC(189), 4);
     Wait(1100);
    }
   
    if (GetFightMode() != 3)
     SetFightMode(3);
     
      }
      DisplayMessage("@dre@Stopped", 3);
   }

}