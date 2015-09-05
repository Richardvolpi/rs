public class Deathpicker extends Script 
{ 
    public Deathpicker(mudclient rs) 
    { 
        super(rs); 
    } 
    public String[] getCommands() 
    { 
        return new String[]{"getdeaths"}; 
     } 
      
       public void start(String command, String parameter[]) 
    { 
       DisplayMessage("@dre@=@whi@=@dre@= @lre@Death Rune Picker Script Started - By @ran@Fert @dre@=@whi@=@dre@=", 3); 

      
      while (Running()) 
   {
     int i[] = GetNearestItem(38); 
      TakeItem(i[0], i[1], 38); 
        Wait(100);






   }
   
  
   
   
   
  

  
DisplayMessage("@dre@=@whi@=@dre@= @whi@Death @dre@Rune Picker Script @red@STOPPED @dre@=@whi@=@dre@=", 3); 
    } 
}

