public class Feathers extends Script
{
    public Feathers(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"feathers"};
     }
     
       public void start(String command, String parameter[])
    {
       DisplayMessage("@cya@Andrew: tells you Hello", 3);

      while (Running())
   {
         int i[] = GetNearestItem(381);
   TakeItem(i[0], i[1], 381);
   Wait(200);

}
DisplayMessage("@gre@STOPPED", 3);
    }
}