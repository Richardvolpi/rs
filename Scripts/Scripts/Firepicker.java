public class Firepicker extends Script 
{ 
    public Firepicker(mudclient rs) 
    { 
        super(rs); 
    } 
    public String[] getCommands() 
    { 
        return new String[]{"getfires"}; 
     } 
      
       public void start(String command, String parameter[]) 
    { 
       DisplayMessage("@dre@=@whi@=@dre@= @lre@Fire Rune PIcker Script Started - By @ran@Fert @dre@=@whi@=@dre@=", 3); 

      
      while (Running()) 
   {
     int i[] = GetNearestItem(31); 
      TakeItem(i[0], i[1], 31); 
        Wait(100);






   }
   
  
   
   
   
  

  
DisplayMessage("@dre@=@whi@=@dre@= @dre@Fire Rune Picker Script @red@STOPPED @dre@=@whi@=@dre@=", 3); 
    } 
}

