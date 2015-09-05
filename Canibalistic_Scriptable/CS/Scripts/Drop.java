public class Drop extends Script
{
public Drop(mudclient rs)
   {
       super(rs);
   }
   public String[] getCommands()
   {
       return new String[]{"drop"}; //Command to start the script
   }
   public void start(String command, String parameter[])
   {     
   //Gets the id the user wants to drop, by reading the first parameter which is 0
   int dropid = StringToInteger(parameter[0]);
   //Displays something before the script starts
   Display("@red@CS: @yel@Dropped script by Canibal",3);
   //Says what it is going to drop
   Display("@red@CS: @yel@Dropping all your: " + GetItemName(dropid) + "s",3);
   //Loop while running
   while(Running())
   {
        //Loop will work till the Inventory count of the drop id items is 0
   	while(CountInv(dropid) > 0)
   	{
   	        //Drops and waits
   		DropItem(FindSlot(dropid));
   		Wait(600);
   	}
   }
   //The end you can put another display here to say thats the script was stopped   
   }
}