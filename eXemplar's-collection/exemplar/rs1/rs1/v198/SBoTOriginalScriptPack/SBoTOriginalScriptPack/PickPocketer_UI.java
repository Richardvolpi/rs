//Pick Pocketer By Unknown Idiot / OhDearUrDead.
public class PickPocketer_UI extends Script
{
    public PickPocketer_UI(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"uipick"};
     }
     
       public void start(String command, String parameter[])
    {
      DisplayMessage("@ran@-@ran@=@ran@=@ran@:@ora@PickPocketer By Unknown Idiot started@ran@:@ran@=@ran@-", 3);
      int NPCID;
      int FightModeID;
      String FightMode;
      FightModeID = Integer.parseInt(parameter[0]);
      NPCID = Integer.parseInt(parameter[1]);
      switch(FightModeID)
      {
        case 0: FightMode = "Controlled";
        break;
        case 1: FightMode = "Aggressive";
        break;
        case 2: FightMode = "Accurate";
        break;
        case 3: FightMode = "Defensive";
        break;
        default: FightMode = "Incorrect";
      }
      SetFightMode(FightModeID);
      DisplayMessage("@ran@-@ran@=@ran@:@ora@UI PickPocketer: @gre@Setting fighting style to "+FightMode, 3);
      while (Running())
     {
    if (Fatigue() >= 95 && Running() == true)
   {
      while (Sleeping() == false && Running() == true)
      {
         Use(FindInv(1263));
         Wait(2666);
      }
      while (Sleeping() == true && Running() == true)
         Wait(100);
         }
   
   if(!InCombat())
   {
      int TEHNPC = GetNearestNPC(NPCID);
      ThieveNPC(TEHNPC);
      Wait(666);
   }
   
   if(InCombat())
   {   
      WalkNoWait(GetX(), GetY());
      Wait(666);
   }
   
   }
   
   DisplayMessage("@ran@-@ran@=@ran@=@ran@:@ora@PickPocketer By Unknown Idiot stopped@ran@:@ran@=@ran@-", 3);
    }
}

