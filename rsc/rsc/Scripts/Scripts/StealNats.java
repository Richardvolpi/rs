public class StealNats extends Script 
{ 
    public StealNats(mudclient rs) 
    { 
        super(rs); 
    } 
    public String[] getCommands() 
    { 
        return new String[]{"stealnats"}; 
     } 
      
       public void start(String command, String parameter[]) 
    { 
       DisplayMessage("@whi@=@bla@=@whi@= @dre@nature rune theiver - By Fert @bla@=@whi@=@bla@=", 3); 

      while (Running()) 
   { 
    
       if (Fatigue() > 97 && Sleeping() == false) 
               { 
            DisplayMessage("@ran@Tired?", 3); 
                  Use(FindInv(1263)); 
                  Wait(5000); 
               } else 
               
               { 
                  if (Sleeping() == false); 
               }             
  
         
         int i[] = GetNearestObject(340); 
   AtObject2(i[0], i[1]); 
   Wait(100); 

} 
DisplayMessage("@whi@=@bla@=@whi@= @Bla@NATURE RUNE THEIVER by fert - @red@STOPPED @whi@=@bla@=@whi@=", 3); 
    } 
}
