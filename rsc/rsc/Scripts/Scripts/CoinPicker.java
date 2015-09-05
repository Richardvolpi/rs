public class CoinPicker extends Script 
{ 
    public CoinPicker(mudclient rs) 
    { 
        super(rs); 
    } 
    public String[] getCommands() 
    { 
        return new String[]{"getmoney"}; 
     } 
      
       public void start(String command, String parameter[]) 
    { 
       DisplayMessage("@ran@=@ran@=@ran@= @lre@Coin Picker Started - Editted By Teh_Naablet =) @ran@=@ran@=@ran@=", 3); 

      while (Running()) 
   { 
    
         int i[] = GetNearestItem(10); 
   TakeItem(i[0], i[1], 10); 
   Wait(100); 

} 
DisplayMessage("@ran@=@ran@=@ran@= @dre@Air Picker STOPPED @ran@=@ran@=@ran@=", 3); 
    } 
}