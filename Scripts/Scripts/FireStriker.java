public class FireStriker extends Script 
{ 
    public FireStriker(mudclient rs) 
    { 
        super(rs); 
    } 
    public String[] getCommands() 
    { 
        return new String[]{"firestrike"}; 
    } 
    public void start(String command, String parameter[]) 
    { 
      DisplayMessage("@ran@=@ran@=@ran@=@ran@=@ran@= @whi@Fire Striker Activated! @ran@=@ran@=@ran@=@ran@=@ran@=",3); 
      DisplayMessage("@ran@=@ran@=@ran@=@ran@=@ran@= @whi@Created by SaladFork! Made into Firestrike by Vegunks! @ran@=@ran@=@ran@=@ran@=@ran@=",3); 
      int NPCID = Integer.parseInt(parameter[0]); 
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
               { 
                  Wait(100); 
               } 
            } 
            if (Running()) 
            { 
               MagicNPC(GetNearestNPC(62),3); 
               Wait(2000); 
            } 
      } 
      DisplayMessage("@red@STOPPED", 3); 
    } 
}