import java.lang.*; 
import java.util.*; 
import java.io.*; 
public class TriControlCraft extends Script 
{ 
   String Metal; 
   String ItemToMake; 
   String Bank; 
   public TriControlCraft(mudclient rs) 
   { 
      super(rs); 
   } 
   public String[] getCommands() 
   { 
      return new String[]{"TriControlCraft"}; 
   } 
//-----------------------------------------------------------------------------------------------// 
   SmeltClass SmeltObject = new SmeltClass(); 
   public int MyX; 
   public int MyY; 
   public int GoldID = 152; 
   public int SilverID = 383; 
   public int GoldBarID = 172; 
   public int SilverBarID = 384; 
   public int GoldRockX = 75; 
   public int GoldRockY = 597; 
   public int GoldRockID = 112; 
   public int SilverRockX = 75; 
   public int SilverRockY = 589; 
   public int SilverRockID = 195; 
   public int FurnaceX = 85; 
   public int FurnaceY = 679; 
   public int MetalForFurnace; 
   public int BarForFurnace; 
   public int AnswerChoice; 
   public int AnswerChoice2 = 1; 
   public int SymbolMold = 386; 
   public int AmmyMold = 294; 
   public int NecklaceMold = 295; 
   public int RingMold = 293; 
   public int AmmyID = 296; 
   public int NecklaceID = 288; 
   public int RingID = 283; 
   public int SymbolID = 45; 
   public int ItemID; 
   public int WalkPathToFurnaceX[] = { 71, 69, 67, 76, 81, 83 }; 
   public int WalkPathToFurnaceY[] = { 605, 618, 639, 658, 678, 679 }; 
   public int WalkPathToBank[]; 
   public boolean SmeltingBars = false; 
   public boolean CraftingItems = false; 
    
    
//-----------------------------------------------------------------------------------------------// 
   public void start(String command, String parameter[]) 
   { 
       Metal = parameter[0]; 
       ItemToMake = parameter[1]; 
       Bank = "No"; 
       if(Metal.equalsIgnoreCase("Silver")) 
       { 
           MetalForFurnace = SilverID; 
           BarForFurnace = SilverBarID; 
           Metal = "Silver"; 
       } else 
       if(Metal.equalsIgnoreCase("Gold")) 
       { 
           MetalForFurnace = GoldID; 
           BarForFurnace = GoldBarID; 
           Metal = "Gold"; 
       } else 
       { 
           DisplayMessage("Wrong INI settings...",3); 
       } 
       if(ItemToMake.equalsIgnoreCase("Symbol")) 
       { 
           AnswerChoice = 0; 
           ItemID = SymbolID; 
       } else 
       if(ItemToMake.equalsIgnoreCase("Ring")) { 
           AnswerChoice = 0; 
           ItemID = RingID; 
       } 
       else 
       if(ItemToMake.equalsIgnoreCase("Ammy")) { 
           AnswerChoice = 2; 
           ItemID = AmmyID; 
       } 
       else 
       if(ItemToMake.equalsIgnoreCase("Necklace")) { 
           AnswerChoice = 1; 
           ItemID = NecklaceID; 
       } 
       else 
       DisplayMessage("Wrong params..." ,3); 
       MyX = GetX(); 
       MyY = GetY(); 
       while(Running()) 
       { 
           while(InvCount() < 30 && Metal.equalsIgnoreCase("Gold") && Running()) 
           { 
               while(ObjectAt(GoldRockX, GoldRockY) == GoldRockID && Running()) 
               { 
                   AtObject(GoldRockX, GoldRockY); 
                   Wait(Rand(2000, 2500)); 
                   CheckSleep(85); 
               } 
               while(ObjectAt(GoldRockX, GoldRockY) != GoldRockID && InvCount() < 30 && Running()) 
                   Wait(Rand(1000, 1500)); 
           } 
           while(InvCount() < 30 && Metal.equals("Silver") && Running()) 
           { 
               while(ObjectAt(SilverRockX, SilverRockY) == SilverRockID && Running()) 
               { 
                   AtObject(SilverRockX, SilverRockY); 
                   Wait(Rand(2000, 2500)); 
                   CheckSleep(85); 
               } 
               while(ObjectAt(SilverRockX, SilverRockY) != SilverRockID && InvCount() < 30 && Running()) 
                   Wait(Rand(1000, 1500)); 
           } 
           if(Running()) 
               WalkPath(WalkPathToFurnaceX, WalkPathToFurnaceY); 
           SmeltingBars = true; 
           Thread SmeltThread = new Thread(SmeltObject); 
           SmeltThread.start(); 
           while(InvCount(MetalForFurnace) > 0) 
               Wait(Rand(1000, 1500)); 
           SmeltingBars = false; 
           CraftingItems = true; 
           while(InvCount(BarForFurnace) > 0) 
               Wait(Rand(1000, 1500)); 
           CraftingItems = false; 
//           if(Running() && Bank.equalsIngoreCase("Yes")) 
//           { 
//               //WalkPath 
//           } 
             while(InvCount(ItemID) > 0) 
             { 
                 Drop(FindInv(ItemID)); 
                 Wait(100); 
             } 
           if(Running()) 
               WalkPathReverse(WalkPathToFurnaceX, WalkPathToFurnaceY); 
       } 
   } 
//-----------------------------------------------------------------------------------------------// 
   public class SmeltClass implements Runnable 
   { 
       public void run() 
       { 
           while(SmeltingBars) 
           { 
               UseOnObject(FurnaceX, FurnaceY, FindInv(MetalForFurnace)); 
               Wait(Rand(2000, 2500)); 
               CheckSleep(99); 
           } 
           while(CraftingItems) 
           { 
               while(!QuestMenu()) 
               { 
                   UseOnObject(FurnaceX, FurnaceY, FindInv(BarForFurnace)); 
                   Wait(Rand(1000, 1500)); 
               } 
               Answer(AnswerChoice); 
               Wait(Rand(2000, 2500)); 
               if(Metal.equalsIgnoreCase("Gold")) 
               { 
                   while(!QuestMenu()) 
                       Wait(Rand(500, 100)); 
                   Answer(AnswerChoice2); 
                   Wait(Rand(2000,2500)); 
               } 
               CheckSleep(99); 
           } 
       } 
   } 
//-----------------------------------------------------------------------------------------------//        
    public void CheckSleep(int Fati) 
    { 
        if(Fatigue() > Fati) 
        { 
            Use(FindInv(1263)); 
            Wait(2000); 
            while(Sleeping()) 
                Wait(1000); 
        } else Wait(20); 
    } 
}