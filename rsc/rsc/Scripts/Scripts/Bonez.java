public class Bonez extends Script
{
    public Bonez(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"bonez"};
     }
       public void start(String command, String parameter[])    
      {
      while (Running())  
   {
     Use(FindInv(20));
     Wait(200);
   } 
   if (Fatigue() > 95 && Sleeping() == false)
               {
                  Use(FindInv(1263));
                  Wait(5000);
               }
    }
}