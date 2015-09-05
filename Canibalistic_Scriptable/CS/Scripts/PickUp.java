public class PickUp extends Script
{
 public PickUp(mudclient rs)
   {
       super(rs);
   }
   public String[] getCommands()
   {
       return new String[]{"pick"};
   }
   public void start(String command, String parameter[])
   {     
   int Item = Integer.parseInt(parameter[0]);
   Display("@gre@Pick up script by - @red@Canibal",3);
   while(Running())
     {
     if(!Sleeping() && Fatigue() > 95)
     	  {
     	  UseItem(FindSlot(1263));
     	  Wait(3000);
     while(Sleeping()) { Wait(10); }     	  
     	  }  
     	  else
     	  {
     	  int[] i = GetNearestItem(Item);
     	  if(i[0] != -1 && GetDistance(i[1],i[2]) < 10)
     	 	{
     	 	PickUpItemAt(i[1],i[2]);
     	 	Wait(500);
     		}  
     		else Wait(1);   
     	  }
      }
      Display("Script Stopped!",3);
     }
}
   