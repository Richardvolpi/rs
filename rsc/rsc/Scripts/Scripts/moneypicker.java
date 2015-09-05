public class moneypicker extends Script
{
   public moneypicker(mudclient rs)
   {
       super(rs);
       
   }
   public String[] getCommands()
   {
       return new String[]{"moneypicker"};
       
   }
   public void start(String command, String parameter[])
   {
     DisplayMessage("@cya@Money Picker by Mr.0", 3);
     while (Running())
     {

           if (GetNearestItem(10) != null)
        {
           int ItemPos[] = GetNearestItem(10);

           TakeItem(ItemPos[0], ItemPos[1],10);
           Wait(500);
        }       
     }
       
     DisplayMessage("@gre@Made@whi@By:@red@Mr.0.. @red@STOPPED", 3);
   }
}