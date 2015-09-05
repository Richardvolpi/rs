public class key extends Script
{
   public key(mudclient rs)
   {
      super(rs);
   }
   public String[] getCommands()
   {
      return new String[]{"key"};
   }
public void KeyPressed(int id)
{
        Println("Key Pressed = " +id);
}
public void KeyReleased(int id)
{
        Println("Key Released = " +id);
}
   public void start(String command, String parameter[])
   {
      DisplayMessage("@bla@key",3);
      DisplayMessage("@gre@By: Davis Zanot",3);
      while (Running())
      {
         Wait(1000);
      }
      DisplayMessage("@red@STOPPED", 3);
   }
}