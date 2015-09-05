public class NatPicker extends Script 
{ 
    public NatPicker(mudclient rs) 
    { 
        super(rs); 
    } 
    public String[] getCommands() 
    { 
        return new String[]{"getnats"}; 
     } 
      
       public void start(String command, String parameter[]) 
    { 
       DisplayMessage("@ran@=@ran@=@ran@= @lre@Nat Picker Started - Editted By Teh_Naablet =) @ran@=@ran@=@ran@=", 3); 

      while (Running()) 
   { 
    
         int i[] = GetNearestItem(40); 
   TakeItem(i[0], i[1], 40); 
   Wait(100); 

} 
DisplayMessage("@ran@=@ran@=@ran@= @dre@Nat Picker STOPPED @ran@=@ran@=@ran@=", 3); 
    } 
}