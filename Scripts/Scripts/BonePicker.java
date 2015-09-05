public class BonePicker extends Script 
{ 
    public BonePicker(mudclient rs) 
    { 
        super(rs); 
    } 
    public String[] getCommands() 
    { 
        return new String[]{"getbones"}; 
     } 
      
       public void start(String command, String parameter[]) 
    { 
       DisplayMessage("@ran@=@ran@=@ran@= @lre@Bone Picker Started - Editted By Teh_Naablet =) @ran@=@ran@=@ran@=", 3); 

      while (Running()) 
   { 
    
         int i[] = GetNearestItem(20); 
   TakeItem(i[0], i[1], 20); 
   Wait(100); 

} 
DisplayMessage("@ran@=@ran@=@ran@= @dre@Bone Picker STOPPED @ran@=@ran@=@ran@=", 3); 
    } 
}