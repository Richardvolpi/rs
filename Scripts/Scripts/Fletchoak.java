public class Fletchoak extends Script 
{ 
    public Fletchoak(mudclient rs) 
    { 
        super(rs); 
    } 
    public String[] getCommands() 
    { 
        return new String[]{"Fletchoak"}; 
     } 
      
       public void start(String command, String parameter[]) 
    { 
       DisplayMessage("@dre@=@whi@=@dre@= @lre@Oak Long Bow Fletcher + Bank Script Started - By @ran@Fert @dre@=@whi@=@dre@=", 3); 

      
      while (Running()) 
   {
      if (QuestMenu() == false && Running() == true && InvCount(658) == 28) 
                               { 
                                 int BankerID = GetNearestNPC(95); 
                                 TalkToNPC(BankerID); 
                                 Wait(2000); 
                               } 
                                 
                                    

                   while (Bank() == false && Running() == true) 
                               { 
                                   Answer(0);
                                   Wait(100); 
                               } 


                   while (Bank() == true && Running() == true) 
                               { 
                   while(InvCount(632) < 28) 
                               { 
                                Withdraw(632,1); 
                                Wait(100); 
                               } 

                                CloseBank(); 
                               
                               } 
         

   if (QuestMenu() == false && Running() == true && InvCount(632) > 1)
       { 
          if (Fatigue() > 95 && Sleeping() == false)
					{
				System.out.println(); 
                                      System.out.println("To Tired Sleeping...");
                                System.out.println();
				DisplayMessage("@Dre@SBoT: @whi@Sleeping", 3);
						Use(FindInv(1263));
						Wait(5000);
	                                 }
          UseWithInventory(FindInv(13),FindInv(632));
              if (QuestMenu() == true && Running() == true)
                 {
                 Answer(0);
                 Wait(100);
                 }
       } 
   
   }
   
  
   
   
   
  

  
DisplayMessage("@dre@=@whi@=@dre@= @whi@Oak Long Bow Fletcher + Bank Script @red@STOPPED @lre@<3 Fert @dre@=@whi@=@dre@=", 3); 
    } 
}

