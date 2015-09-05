public class kharid extends Script

{
    public kharid(mudclient rs)
    {
        super(rs);
       
    }

    public String[] getCommands()
    {
        return new String[]{"lobs", "trout", "salmon", "tuna", "sword", "shark"};

    }



    public boolean param = false;

    public boolean sleep = false;

     
    public void start(String command, String parameter[])

    { 
        if (parameter == null) {
        DisplayMessage("@whi@No type specified @blu@ Must use 1 for sleeping & 0 for no sleeping", 3);
      } else {

// ID's of all the fish
   
        int RawID = 0;
        int CookedID = 0;
        int BurntID = 0;
        String Type = "null";

        if (command.equalsIgnoreCase("lobs"))  {
            RawID = 372;
            CookedID = 373;
            BurntID = 374;
            Type = "Lobsters";
        }       

        if (command.equalsIgnoreCase("trout"))  {
            RawID = 358;
            CookedID = 359;
            BurntID = 360;
            Type = "Trout";
        }       

        if (command.equalsIgnoreCase("salmon"))  {
            RawID = 356;
            CookedID = 357;
            BurntID = 360;
            Type = "Salmon";
        }       

        if (command.equalsIgnoreCase("tuna"))  {
            RawID = 366;
            CookedID = 367;
            BurntID = 368;
            Type = "Tuna";
        }

        if (command.equalsIgnoreCase("sword"))  {
            RawID = 369;
            CookedID = 370;
            BurntID = 371;
            Type = "Swordfish";
        }

         if (command.equalsIgnoreCase("shark"))  {
            RawID = 545;
            CookedID = 546;
            BurntID = 547;
            Type = "Shark";
        }

 
        if(Integer.parseInt(parameter[0]) == 0)
        {
            DisplayMessage("@gre@Cooking " + Type, 3);
            DisplayMessage("@yel@New Era's anit-newb cooking device", 3);
            DisplayMessage("@cya@I'm Makin Waffles! :) ", 3);
            DisplayMessage("@red@Enjoy peaceful cooking!", 3);
            
            param = true;
            sleep = false;
        }
   
        if(Integer.parseInt(parameter[0]) == 1)
        {
            DisplayMessage("@red@Cooking " + Type, 3);
            DisplayMessage("@yel@New Era's anit-newb cooking device", 3);
            DisplayMessage("@cya@I'm Makin Waffles! :) ", 3);
            DisplayMessage("@red@Enjoy peaceful cooking!", 3);
            
            param = true;
            sleep = true;
        } 
   
        if(Integer.parseInt(parameter[0]) != 0 && Integer.parseInt(parameter[0]) != 1)
        {
            DisplayMessage("@whi@Bad Parameter - Press f9 and try again", 3);
            DisplayMessage("@whi@Must use either 1 for sleeping or 0 for no sleeping", 3);

        }
   
   

     
    while(Running() == true && param == true)
    {

//While the bank window isn't open
//talk to banker, answer, then wait

        while(Bank() == false) {
            //Talk To Banker
            while(!QuestMenu())
            {
                long l = System.currentTimeMillis();
                int bankerID = GetNearestNPC(268);
                TalkToNPC(bankerID);
                while(System.currentTimeMillis() - l <= 2000L && !QuestMenu())
                Wait(1);
            }
           
            Answer(0);
            Wait(5000);
         }

//If there are cooked or burnt items in your inventory
//deposit them

            while(InvCount(CookedID) > 0)
            {
                Deposit(CookedID,1);
                Wait(100);
            }
            while (InvCount(BurntID) > 0)
            {
                Deposit(BurntID,1);
                Wait(100);
            }

//And while your inventory is not full keep withdrawing

            while (InvCount() < 30)
            {
                Withdraw(RawID,1);
                Wait(100);
            }
   
        CloseBank();

while(ObjectAt(86,695) == 64) 
          { 
             AtObject(86,695); 
              Wait(50); 
          }





//Walk to Range
 
        Wait(50);
        Walk(85,695);
        Wait(50);
        Walk(84,683);
        Wait(50);
while(DoorAt(85, 683, 1) == 2) 
          {           
              OpenDoor(85, 683, 1); 
              Wait(50); 
          } 
Walk(86,683);
        

//Start Cooking

        while (InvCount(RawID) > 0 && Running() == true)
        {
            UseOnObject(87,685,FindInv(RawID));
            Wait(2600);

//This is the sleeping part, and here is where the
//boolean sleep is used.  This loop only occurs if
//sleep is set to true

                if (Fatigue() > 96 && Running() == true && sleep == true)
                {
                    while (Sleeping() == false)
                    {
                        Use(FindInv(1263));
                        Wait(2500);
                    }
   
                    while (Sleeping() == true)
                    {
                        Wait(100);
                    }
                }
        }

        Wait(1000);




//Walks

        Walk(85,684);
        Wait(50);
if(DoorAt(85 ,683, 1) == 2)
        {
            OpenDoor(85, 683, 1);
            Wait(50);
        }
        Walk(84,683);
        Wait(50);
        Walk(86,694);
        Wait(50);
while(ObjectAt(86,695) == 64) 
          { 
             AtObject(86,695); 
              Wait(50); 
          }



         
         
    }
    }
    DisplayMessage("@red@STOPPED", 3);
    DisplayMessage("@cya@Waffles Are Ready! :) ", 3);
    }

}