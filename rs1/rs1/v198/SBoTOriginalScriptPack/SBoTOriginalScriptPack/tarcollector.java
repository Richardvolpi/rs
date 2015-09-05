public class tarcollector extends Script
{
    public tarcollector(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"gettar"};
     }
     
       public void start(String command, String parameter[])
    {
       DisplayMessage("@dre@=@whi@=@dre@= @lre@Like omg! swamptar collector! - By @ran@Fert @dre@=@whi@=@dre@=", 3);

     
      while (Running())
   {
     int i[] = GetNearestItem(783);
      TakeItem(i[0], i[1], 783);
        Wait(100);






   }
   
 
   
   
   
 

 
DisplayMessage("@dre@=@whi@=@dre@= @whi@Like omg! swamptar collector!@red@STOPPED @dre@=@whi@=@dre@=", 3);
    }
}
