public class EdgevilleCooker extends Script

{
    public EdgevilleCooker(mudclient rs)
    {
        super(rs);
       
    }

    public String[] getCommands()
    {
        return new String[]{"cooklobsters", "cooktrout", "cooksalmon", "cooktuna", "cookswordfish"};

    }

//The following sets the booleans used later as false

    public boolean param = false;

    public boolean sleep = false;

     
    public void start(String command, String parameter[])

    { 
        if (parameter == null) {
        DisplayMessage("@gre@SBoT: @whi@No type specified", 3);
      } else {

//The following sets up all the IDs to be used later in the script
//This way I don't have to make multiple scripts to do the exact thing
   
        int RawID = 0;
        int CookedID = 0;
        int BurntID = 0;
        String Type = "null";

        if (command.equalsIgnoreCase("cooklobsters"))  {
            RawID = 372;
            CookedID = 373;
            BurntID = 374;
            Type = "Lobsters";
        }       

        if (command.equalsIgnoreCase("cooktrout"))  {
            RawID = 358;
            CookedID = 359;
            BurntID = 360;
            Type = "Trout";
        }       

        if (command.equalsIgnoreCase("cooksalmon"))  {
            RawID = 356;
            CookedID = 357;
            BurntID = 360;
            Type = "Salmon";
        }       

        if (command.equalsIgnoreCase("cooktuna"))  {
            RawID = 366;
            CookedID = 367;
            BurntID = 368;
            Type = "Lobsters";
        }

        if (command.equalsIgnoreCase("cookswordfish"))  {
            RawID = 369;
            CookedID = 370;
            BurntID = 371;
            Type = "Swordfish";
        }

//The following bascially says if 0 is returned as parameter
//it sets the boolean sleep to false
//If 1 is returned as parameter it is set to true.
//This is used later in sleeping part
//If a parameter besides 1 or 0 is given, it reports the error

 
        if(Integer.parseInt(parameter[0]) == 0)
        {
            DisplayMessage("@gre@SBoT: @whi@Cooking " + Type + " Without Sleeping @gre@-KingoKings", 3);
            param = true;
            sleep = false;
        }
   
        if(Integer.parseInt(parameter[0]) == 1)
        {
            DisplayMessage("@gre@SBoT: @whi@Cooking " + Type + " With Sleeping @gre@-KingoKings", 3);
            param = true;
            sleep = true;
        } 
   
        if(Integer.parseInt(parameter[0]) != 0 && Integer.parseInt(parameter[0]) != 1)
        {
            DisplayMessage("@gre@SBoT: @whi@Bad Parameter - Press f9 and try again", 3);
            DisplayMessage("@gre@SBoT: @whi@Must use either 1 for sleeping or 0 for no sleeping", 3);

        }
   
   
//The param == true below is there so the script doesn't
//start unless 1 or 0 is set as parameter

//It is set to true at the same time sleep is
//set to true or false

//The running() == true means it wont run after f9 is pressed
//and is used again other places
     
    while(Running() == true && param == true)
    {

//While the bank window isn't open
//talk to banker, answer, then wait

        while(Bank() == false) {
            //Talk To Banker
            while(!QuestMenu())
            {
                long l = System.currentTimeMillis();
                int bankerID = GetNearestNPC(95);
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

//Walk to Range
 
        Wait(1000);
        Walk(218,446);
        Wait(50);
        Walk(225,445);
        Wait(50);

//Checks if door is closed, if it is
//it opens and walks inside

        if(DoorAt(225,444,0) == 2)
        {
            OpenDoor(225,444,0);
            Wait(100);
        }

        Walk(225,441);

//If you havent climbed up the ladder yet, keep trying
//every second

//the GetY() determines if you havent climbed up
//ladder yet because the y coordinate at ground level
//is less than 1000 and greater than 1000 once up the ladder

        while(GetY() < 1000 && Running() == true)
        {
            AtObject(226,439);
            Wait(1000);
        }

        Wait(2000);

//Start Cooking

        while (InvCount(RawID) > 0 && Running() == true)
        {
            UseOnObject(222,1385,FindInv(RawID));
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

//Same as going up the ladder but goes the other direct ;)

        while(GetY() > 1000 && Running() == true)
        {
            AtObject(226,1383);
            Wait(1000);
        }

//Checks door again
   
        if(DoorAt(225,444,0) == 2)
        {
            OpenDoor(225,444,0);
            Wait(100);
        }

//Walks

        Walk(225,445);
        Wait(50);
        Walk(217,446);
        Wait(50);
        Walk(217,449);
         
         
    }
    }
    DisplayMessage("@red@STOPPED", 3);
    }

}