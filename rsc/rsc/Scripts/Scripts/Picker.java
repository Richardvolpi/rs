//COMMAND: /run pick ItemID@WaitTime@Walkback[0/1] 

public class Picker extends Script 
{ 
   public Picker(mudclient rs) 
   { 
      super(rs); 
   } 
   public String[] getCommands() 
   { 
      return new String[]{"pick"}; 
   } 

   public int ItemID = -1; 
   public int WaitTime = -1; 
   public boolean Walkback = true; 
   public int StartX = -1; 
   public int StartY = -1; 

   public void start(String command, String parameter[]) 
   { 
      ItemID = Integer.parseInt(parameter[0]); 
      WaitTime = Integer.parseInt(parameter[1]); 
      int WalkbackPar = Integer.parseInt(parameter[2]); 
      int Number = 0; 
      Walkback = true; 
      StartX = GetX(); 
      StartY = GetY(); 

      if (WalkbackPar > 0) 
         Walkback = true; 
      else 
         Walkback = false; 
    
      PrintInfo(); 
      DisplayMessage("@gr2@fAcelEss@whi@: Multi-Purpose Picker",3); 
      while (Running()) 
      { 
         int ItemCoords[] = GetNearestItem(ItemID); 
         if (ItemCoords[0] != -1 || ItemCoords[1] != -1) 
         { 
            TakeItem(ItemCoords[0], ItemCoords[1], ItemID); 
            Wait(WaitTime); 
            Number++; 
            System.out.println("Number of items picked: " +Number); 
         } 
         else if (Walkback) 
         { 
            Walk(StartX,StartY); 
            Wait(500); 
         } 
      } 
  
      DisplayMessage("@red@STOPPED", 3); 
   } 

   public void PrintInfo() 
   { 
      System.out.println("+----------------------------------------+"); 
      System.out.println("|  _                                     |"); 
      System.out.println("|_|_  __   __   ___  |    ___    __   __ |"); 
      System.out.println("| |  (__( (___ (__/_ |_, (__/_ __)  __)  |"); 
      System.out.println("|                                        |"); 
      System.out.println("|- - - -     P R E S E N T S     - - - - |"); 
      System.out.println("|                                        |"); 
      System.out.println("|----------Multi.Purpose.Picker----------|"); 
      System.out.println("|I N F O R M A T I O N :                 |"); 
      System.out.println("+----------------------------------------+"); 
      System.out.println(" Picking Item: " +ItemID); 
      System.out.println(" Wait between picks: " +WaitTime); 
      System.out.println(" Walkback?: " +Walkback); 
      if (Walkback) 
      { 
         System.out.println(" Walkback X Co-ordinate: " +StartX); 
         System.out.println(" Walkback Y Co-ordinate: " +StartY); 
      } 
      System.out.println("+----------------------------------------+"); 
   } 
} 