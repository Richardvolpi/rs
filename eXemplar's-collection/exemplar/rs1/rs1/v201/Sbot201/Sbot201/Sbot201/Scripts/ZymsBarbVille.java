public class ZymsBarbVille extends Script
{
    public ZymsBarbVille(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"coals"};
    }
public int CoalBank = 0; 
public int BankTrips = 0; 
public int LVL = 0; 

public void ServerMessage(String message) 
   { 
if(message.equals("@gre@You just advanced 1 mining level!")) 
       { 
           LVL++; 
       } 

if (message.equals("@gam@You just found a sapphire!")) 
      { 
         System.out.println("+++++++++++Sapphire mined+++++++++++"); 
      } 
      if (message.equals("@gam@You just found an emerald!")) 
      { 
         System.out.println("+++++++++++Emerald mined+++++++++++"); 
      } 
      if (message.equals("@gam@You just found a ruby!")) 
      { 
         System.out.println("+++++++++++ruby mined+++++++++++"); 
      } 
      if (message.equals("@gam@You just found a diamond!")) 
      { 
         System.out.println("+++++++++++diamond mined+++++++++++"); 
      } 
    

}  

 public void start(String command, String parameter[])
 
    {
      DisplayMessage("@cya@ coal@red@ miner@gre@ made by@ran@ zym",3);
      while (Running())
      {
         while (Running()  == true && InvCount() < 30)
         {
            if (Fatigue() >= 90 && Running() == true)
            {
               while (Sleeping() == false)
               {
                  Use(FindInv(1263));
               Wait(1000);
               }
               while (Sleeping() == true)
               {
                  Wait(200);
               }
            }
            int Coalcoords[] = GetNearestObject(110);
            if (Coalcoords[0] > -1 && Running() == true)
            AtObject(Coalcoords[0],Coalcoords[1]);
            Wait(500);
         }
   Walk(224,501);
Walk(222,494);
Walk(220,490);
Walk(220,482);
Walk(218,478);
Walk(221,471);
Walk(225,469);
Walk(224,465);
Walk(224,459);
Walk(221,457);
Walk(220,452);
Walk(219,452);
Walk(219,452);
Walk(219,452);
Walk(220,452);
Walk(218,449);
Wait(100);
        OpenBank();
        while (InvCount(155) > 0)
         {
            Deposit(155,1);
            Wait(50);
         }
         while (InvCount(157) > 0)
         {
            Deposit(157,1);
            Wait(100);
         }
         while (InvCount(158) > 0)
         {
            Deposit(158,1);
            Wait(100);
         }
         while (InvCount(159) > 0)
         {
            Deposit(159,1);
            Wait(100);
         }
         while (InvCount(160) > 0)
         {
            Deposit(160,1);
            Wait(100);
         }
         CoalBank = BankCount(155); 
         CloseBank();
        
BankTrips++; 

Println("/./././././././.Trip " +BankTrips+"/./././././././"); 
Println("Coal Banked: " +CoalBank); 
Println("Levels Gained: " +LVL);


Walk(220,447);
Walk(222,449);
Walk(222,451);
Walk(222,453);
Walk(222,455);
Walk(223,457);
Walk(224,458);
Walk(224,460);
Walk(224,464);
Walk(224,465);
Walk(224,467);
Walk(224,468);
Walk(222,470);
Walk(221,472);
Walk(220,475);
Walk(220,476);
Walk(219,480);
Walk(218,483);
Walk(219,485);
Walk(219,488);
Walk(219,491);
Walk(219,494);
Walk(219,497);
Walk(221,498);
Walk(223,501);
Walk(225,503);
Walk(226,505);
Wait(100);
      }
      DisplayMessage("@red@STOPPED", 3);
    }
}

