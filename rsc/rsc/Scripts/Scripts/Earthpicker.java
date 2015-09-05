public class Earthpicker extends Script 
{ 
    public Earthpicker(mudclient rs) 
    { 
        super(rs); 
    } 
    public String[] getCommands() 
    { 
        return new String[]{"getearths"}; 
     } 
      
       public void start(String command, String parameter[]) 
    { 
       DisplayMessage("@dre@=@whi@=@dre@= @lre@Earth Rune Picker Script Started - By @ran@Fert @dre@=@whi@=@dre@=", 3); 

      
      while (Running()) 
   {
     int i[] = GetNearestItem(34); 
      TakeItem(i[0], i[1], 34); 
        Wait(100);
     
   }
   
  
   
   
   
  

  
DisplayMessage("@dre@=@whi@=@dre@= @dre@Earth Rune Picker Script @red@STOPPED @dre@=@whi@=@dre@=", 3); 
    } 
}

