//run *pickflax* and then the picking starts :) 
public class FlaxPicker56k extends Script 
{ 
int flaxcount =0; 
    public FlaxPicker56k(mudclient rs) 
    { 
        super(rs); 
    } 
    public String[] getCommands() 
    { 
        return new String[]{"pickflax56k"}; 
    } 
    public void start(String command, String parameter[]) 
    { 
         DisplayMessage("@cya@Flax Picker + Banker by [-BigH140-] @whi@ edited by Eb Gamer!", 3); 
                  
         while (Running()) 
         { 
            while (InvCount() < 30 && Running() == true) 
            { 
               Walk(714,501); 
               Wait(300); 
               AtObject2(714,502); 
               Wait(700); 
            } 
            { 
               AtObject(714,500); 
               Wait(100); 
      while (GetY() <= 600) 
               { 
                  AtObject(714,500); 
                  Wait(100); 
      } 
   } 
            Walk(714,1451); 
            Wait(3000); 
            flaxcount += InvCount(675); 
            SexyPrint("This script has banked " + flaxcount + " flax..."); 
            int BankerID = GetNearestNPC(540); 
            while (QuestMenu() == false) 
            { 
               TalkToNPC(BankerID); 
                  Wait(3000); 
            } 
            Answer(0); 
            while (Bank() == false) 
            Wait(100); 
            while (InvCount() > 0 && Running() == true) 
            { 
               Deposit(675,1); 
               Wait(50); 
            } 
            CloseBank(); 
          
            AtObject(714,1444); 
   Wait(3000); 
            while (GetY() >= 1000) 
            { 
               AtObject(714,1444); 
               Wait(300); 
               Walk(714,501); 
               Wait(300); 
           } 
         } 
   DisplayMessage("@gre@STOPPED @ran@Flax Picker by [-BigH140-]", 3); 
    } 
}