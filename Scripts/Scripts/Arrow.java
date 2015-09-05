public class Arrow extends Script 
{ 
    public Arrow(mudclient rs) 
    { 
        super(rs); 
    } 
    public String[] getCommands() 
    { 
        return new String[]{"pickarrow"}; 
     } 
      
       public void start(String command, String parameter[]) 
    { 
       DisplayMessage("@dre@=@whi@=@dre@= @lre@Arrow Picker Script Started - By @ran@Fert @dre@=@whi@=@dre@=", 3); 

      
      while (Running()) 
   {
     int i[] = GetNearestItem(11); 
      TakeItem(i[0], i[1], 11); 
        Wait(400);






   }
   
  
   
   
   
  

  
DisplayMessage("@dre@=@whi@=@dre@= @whi@Arrow @dre@ Picker Script @red@STOPPED @dre@=@whi@=@dre@=", 3); 
    } 
}


