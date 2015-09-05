public class FeltchShafts extends Script 
{ 

    public FeltchShafts(mudclient mudclient) 
    { 
        super(mudclient); 
        sleep = false; 
        shafts = 0; 
        logs = 0; 
        wexp = 0; 
        fexp = 0; 
        wlevels = 0; 
        flevels = 0; 
    } 

    public String[] getCommands() 
    { 
        return (new String[] { 
            "feltchshafts" 
        }); 
    } 

    public void NPCMessage(String s) 
    { 
        if(s.indexOf("You carefully cut the wood into 10 arrow shafts") > 0) 
        { 
            System.out.println("Shafts fletched... " + (shafts + 10) + " arrow shafts obtained"); 
            shafts += 10; 
            fexp += 5; 
        } 
    } 

    public void ServerMessage(String s) 
    { 
        if(s.equals("@gam@You are too tired to cut the tree")) 
            sleep = true; 
        if(s.equals("@gre@You are too tired to gain experience, get some rest!")) 
            sleep = true; 
        if(s.equals("You wake up - feeling refreshed")) 
            sleep = false; 
        if(s.equals("@gam@Welcome to RuneScape!")) 
            sleep = false; 
        if(s.equals("@gam@You get some wood")) 
        { 
            System.out.println("Wood obtained... " + (logs + 1) + " logs obtained"); 
            logs++; 
            wexp += 25; 
        } else 
        if(s.equals("@gre@You just advanced 1 woodcutting level!")) 
        { 
            Wait(2000); 
            System.out.println("Woodcut level! New Woodcut Level: " + GetCurrentStat(9)); 
            wlevels++; 
        } else 
        if(s.equals("@gre@You just advanced 1 fletching level!")) 
        { 
            Wait(2000); 
            System.out.println("Fletching level! New Fletching Level: " + GetCurrentStat(10)); 
            flevels++; 
        } 
    } 

    public void start(String s, String as[]) 
    { 
        DisplayMessage("@red@F@or3@E@or2@L@ora@T@or1@C@yel@H", 3); 
        DisplayMessage("By...", 3); 
        DisplayMessage("@ran@X@ran@-@ran@E@ran@-@ran@N@ran@-@ran@0@ran@-@ran@N", 3); 
        Wait(1000); 
        for(; Running(); Wait(200)) 
        { 
            int ai[] = { 
                0, 1 
            }; 
            int ai1[] = GetNearestObject(ai); 
            Wait(350); 
            if(ai1[0] != -1 && ai1[1] != -1) 
            { 
                for(; ObjectAt(ai1[0], ai1[1]) != 4 && Running() && !Sleeping() && !sleep; Wait(350)) 
                    AtObject(ai1[0], ai1[1]); 

                if(InvCount() != 5); 
                Wait(500); 
                UseWithInventory(4, 1); 
                Wait(750); 
                Answer(0); 
                Wait(200); 
            } 
            while(sleep) 
            { 
                Use(FindInv(1263)); 
                Wait(5000); 
                long l = System.currentTimeMillis(); 
                while(Sleeping() && System.currentTimeMillis() - l <= 30000L) 
                    Wait(500); 
            } 
        } 

        DisplayMessage("@ran@[@red@S@ran@]@ran@[@red@T@ran@]@ran@[@red@O@ran@]@ran@[@red@P@ran@]@ran@[@red@P@ran@]@ran@[@red@E@ran@]@ran@[@red@D@ran@]", 3); 
        System.out.println(" "); 
        System.out.println("xx  xx EEEEEEE NNNN    NN   000   NNNN   NN"); 
        System.out.println(" xxxx  EE      NN NN   NN 000 000 NN NN  NN"); 
        System.out.println("  xx   EEEEE   NN  NN  NN 00   00 NN  NN NN"); 
        System.out.println(" xxxx  EE      NN   NN NN 000 000 NN   NNNN"); 
        System.out.println("xx  xx EEEEEEE NN     NNN   000   NN    NNN"); 
        System.out.println("+--------------------------------+"); 
        System.out.println("Woodcut levels gained: " + wlevels); 
        System.out.println("Logs obtained:  " + logs); 
        System.out.println("Woodcut experience gained: " + wexp); 
        System.out.println("+--------------------------------+"); 
        System.out.println("Fletching levels gained  " + flevels); 
        System.out.println("Shafts obtained  " + shafts); 
        System.out.println("Fletching experience gained: " + fexp); 
        System.out.println("+--------------------------------+"); 
    } 

    public boolean sleep; 
    public int shafts; 
    public int logs; 
    public int wexp; 
    public int fexp; 
    public int wlevels; 
    public int flevels; 
}