public class Nats extends Script 
{ 
    public Nats(mudclient rs) 
    { 
        super(rs); 
    } 
    public String[] getCommands() 
    { 
        return new String[]{"Tomfluff"}; 
     } 
      
       public void start(String command, String parameter[]) 
    { 
   int Wait; 
   Wait = Integer.parseInt(parameter[0]); 
       DisplayMessage("@ran@Nature @ran@Thiever @ran@by @ran@Tomfluff", 3); 

      
      while (Running()) 
   {if (Fatigue() >= 95 && Running() == true) 
   { 
      while (Sleeping() == false && Running() == true) 
      { 
         Use(FindInv(1263)); 
         Wait(2500); 
      } 
      while (Sleeping() == true && Running() == true) 
         Wait(500); 
         }    
  
      AtObject2(582,1527); 
      Wait(Wait); 
   }    
    
  

  
DisplayMessage("I love You "+System.getProperty("user.name")+"", 3); 
    } 
}