public class boltpicker extends Script
{
   public boltpicker(mudclient rs)
   {
       super(rs);
       
   }
   public String[] getCommands()
   {
       return new String[]{"moneypicker"};
       
   }
   public void start(String command, String parameter[])
   {
     DisplayMessage("@cya@Mr.0 tells you: Money Picker actived!", 3);
     while (Running())
     {

           if (GetNearestItem(10) != null)
        {
           int ItemPos[] = GetNearestItem(10);

           TakeItem(ItemPos[0], ItemPos[1],10);
           Wait(700);
        }       
     }
       
     DisplayMessage("@gre@Made@whi@By:@red@Mr.0.. @red@STOPPED", 3);
   }
}