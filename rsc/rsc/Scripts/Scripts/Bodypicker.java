public class Bodypicker extends Script 
{ 
    public Bodypicker(mudclient rs) 
    { 
        super(rs); 
    } 
    public String[] getCommands() 
    { 
        return new String[]{"getbodys"}; 
     } 
      
       public void start(String command, String parameter[]) 
    { 
       DisplayMessage("@dre@=@whi@=@dre@= @lre@Body Rune Picker Script Started - By @ran@Fert @dre@=@whi@=@dre@=", 3); 

      
      while (Running()) 
   {
     int i[] = GetNearestItem(36); 
      TakeItem(i[0], i[1], 36); 
        Wait(100);






   }
   
  
   
   
   
  

  
DisplayMessage("@dre@=@whi@=@dre@= @whi@Body @dre@Rune Picker Script @red@STOPPED @dre@=@whi@=@dre@=", 3); 
    } 
}

