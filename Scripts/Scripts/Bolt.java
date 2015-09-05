public class Bolt extends Script 
{ 
    public Bolt(mudclient rs) 
    { 
        super(rs); 
    } 
    public String[] getCommands() 
    { 
        return new String[]{"pickbolt"}; 
     } 
      
       public void start(String command, String parameter[]) 
    { 
       DisplayMessage("@dre@~@whi@~@dre@~ @lre@Bolt Picker Script Started - By @whi@Unknown @dre@~@whi@~@dre@~", 3); 

      
      while (Running()) 
   {
     int i[] = GetNearestItem(190); 
      TakeItem(i[0], i[1], 190); 
        Wait(400);






   }
   
  
   
   
   
  

  
DisplayMessage("@dre@~@whi@~@dre@~ @whi@Bolt @dre@ Picker Script @red@STOPPED @dre@~@whi@~@dre@~", 3); 
    } 
}


