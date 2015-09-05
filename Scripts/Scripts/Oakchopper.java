public class Oakchopper extends Script 
{ 
    public Oakchopper(mudclient rs) 
    { 
        super(rs); 
    } 
    public String[] getCommands() 
    { 
        return new String[]{"chopoak"}; 
     } 
      
       public void start(String command, String parameter[]) 
    { 
       DisplayMessage("@dre@=@whi@=@dre@= @lre@Oak Chopper + Bank Script Started - By @ran@Fert @dre@=@whi@=@dre@=", 3); 

      
      while (Running()) 
   {

         
         
         

         
         while (InvCount() < 30)
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
         int Oak[] = GetNearestObject(306); 
      AtObject(Oak[0], Oak[1]); 
        Wait(100);
         }
     
         

         if (InvCount() == 30)
             {
               Walk(506,447);
               Wait(100);
               Walk(507,452);
               Wait(100);
               Walk(504,455);
               Wait(100);
               Walk(501,453);
             }
      
                        if (QuestMenu() == false && Running() == true && InvCount() == 30) 
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
                   while(InvCount(632) > 0) 
                               { 
                                Deposit(632,1); 
                                Wait(100); 
                               } 

                                CloseBank(); 
                               
                               } 
          if (InvCount(632) == 0)
              {
               Walk(501,455);
               Wait(100);
               Walk(506,455);
               Wait(100);
               Walk(506,451);
               Wait(100);
               Walk(508,451);
               Wait(100);
               Walk(508,446);
               Wait(100);
               Walk(509,443);
              }


   }
   
  
   
   
   
  

  
DisplayMessage("@dre@=@whi@=@dre@= @whi@Oak Chopper + Bank Script @red@STOPPED @lre@<3 Fert @dre@=@whi@=@dre@=", 3); 
    } 
}

