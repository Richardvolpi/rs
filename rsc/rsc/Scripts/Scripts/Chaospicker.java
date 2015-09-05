public class Chaospicker extends Script 
{ 
    public Chaospicker(mudclient rs) 
    { 
        super(rs); 
    } 
    public String[] getCommands() 
    { 
        return new String[]{"getchaos"}; 
     } 
      
       public void start(String command, String parameter[]) 
    { 
       DisplayMessage("@dre@=@whi@=@dre@= @lre@Chaos Rune Picker Script Started - By @ran@Fert @dre@=@whi@=@dre@=", 3); 

      
      while (Running()) 
   {
     int i[] = GetNearestItem(41); 
      TakeItem(i[0], i[1], 41); 
        Wait(100);






   }
   
  
   
   
   
  

  
DisplayMessage("@dre@=@whi@=@dre@= @whi@Chaos @dre@Rune Picker Script @red@STOPPED @dre@=@whi@=@dre@=", 3); 
    } 
}

