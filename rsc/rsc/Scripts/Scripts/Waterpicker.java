public class Waterpicker extends Script 
{ 
    public Waterpicker(mudclient rs) 
    { 
        super(rs); 
    } 
    public String[] getCommands() 
    { 
        return new String[]{"getwaters"}; 
     } 
      
       public void start(String command, String parameter[]) 
    { 
       DisplayMessage("@dre@=@whi@=@dre@= @lre@Water Rune PIcker Script Started - By @ran@Fert @dre@=@whi@=@dre@=", 3); 

      
      while (Running()) 
   {
     int i[] = GetNearestItem(32); 
      TakeItem(i[0], i[1], 32); 
        Wait(100);






   }
   
  
   
   
   
  

  
DisplayMessage("@dre@=@whi@=@dre@= @dre@Water Rune Picker Script @red@STOPPED @dre@=@whi@=@dre@=", 3); 
    } 
}

