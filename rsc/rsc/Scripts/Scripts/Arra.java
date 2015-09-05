public class Arra extends Script 
{ 
   public Arra(mudclient rs) 
   { 
      super(rs); 
   } 
   public String[] getCommands() 
   { 
      return new String[]{"arra"}; 
   } 
   public void start(String command, String parameter[]) 
   { 
      DisplayMessage("Arra pickup by pure ownage",3); 
      while (Running()) 
      { 
    int ARROWS[] = GetNearestItem(11); // 
         TakeItem(ARROWS[0], ARROWS[1], 11); // 
         Wait(100); // 
      } 
      DisplayMessage("@red@STOPPED", 3); 
   } 
}