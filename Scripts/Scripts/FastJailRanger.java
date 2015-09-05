public class FastJailRanger extends Script
{ 
    public FastJailRanger(mudclient rs)
    { 
        super(rs); 
    } 
    public String[] getCommands() 
    { 
        return new String[]{"jailranger"};
    } 
    
    public int InvCount2(int ff)
    {
	      Wait(2100);
	      return InvCount(ff);
    }
    

    
    public boolean Loop = true;
    
    public boolean IDLoop = true;
   
    public void WalkOffDetect()
    {
        if (GetX() != 285 || GetY() != 659)
        {
            DisplayMessage("@gre@SBoT:@whi@ Walking...",3);
            WalkNoWait(285,660);
            Wait(1000);
            WalkNoWait(285,658);
            Wait(700);
            WalkNoWait(285,659);
            Wait(1000);

        }
    }
    
    public void start(String command, String parameter[]) 
    { 
         int StartRangeExp = GetExperience(4);
         int StartArrows = InvCount(11);
         int FightMode = Integer.parseInt(parameter[0]);
         int RangeExp2 = 0;
         int RangeExp3 = 0;
         int Arrows2 = 0;
         int Arrows3 = 0;
         int Targets[] = new int[]{64, 192, 137, 21};   //21
         long StartTime = (System.currentTimeMillis() / 1000);
         RangeExp2 = GetExperience(4);
         Arrows2 = InvCount(11);
         long Time2 = (System.currentTimeMillis() / 1000);
                System.out.println(">>>>> JailRanger - Kingokings <<<<< ");
                System.out.println("  Starting Range Experience:  " + StartRangeExp);
                System.out.println("  Starting Arrow Count:  " + StartArrows);

         DisplayMessage("@gre@SBoT: @whi@JailRanger - Kingokings", 3);
         while (Running())
         { 
            if (GetFightMode() != FightMode) 
            { 
               SetFightMode(FightMode); 
               DisplayMessage("@gre@SBoT: @whi@FightMode Changed To " + GetFightMode(),  3); 
            }
            
            if ((System.currentTimeMillis() / 1000) - Time2 > 600)
            {
                RangeExp3 = GetExperience(4);
                Arrows3 = InvCount(11);
                System.out.println(">>>>> JailRanger - Progress Report (Every 10 Min) <<<<< ");
                System.out.println("In last 10 Minutes:");
                System.out.println("  Range Exp Gained:  " + (RangeExp3 - RangeExp2));
                System.out.println("  Arrows Used:  " + (Arrows2 - Arrows3));
                System.out.println("  Current Exp per Hour:  " + (RangeExp3 - RangeExp2) * 6);
                System.out.println("  Current Arrows Used per Hour:  " + (Arrows2 - Arrows3) * 6);
                RangeExp2 = GetExperience(4);
                Arrows2 = InvCount(11);
                Time2 = System.currentTimeMillis();

            }

            if (Fatigue() > 97 && Running())
            {
                while (!Sleeping()&& Running())
                {
                    Use(FindInv(1263));
                    Wait(2500);
                }
                while (Sleeping() && Running())
                {
                    Wait(100);
                }
            }
            
            if (Fatigue() < 98 && Running())
            {
                WalkOffDetect();
                Wait(100);

                int ID = GetNearestNPC(Targets);
                //,280,655,284,662
                IDLoop = true;
                if (ID != -1 && IDLoop)
                {
                  if(IDLoop && NPCX(ID) >= 280 && NPCX(ID) <= 284 && NPCY(ID) >= 655 && NPCY(ID) <= 662)
                  {

                    long T = System.currentTimeMillis();
                    AttackNPC(ID);

                    while(ID == GetNearestNPC(Targets) && Running() && Loop)
                    {
                        if(System.currentTimeMillis() - T > 30000 && Running())
                        {
                            if(InvCount(11) == InvCount2(11))
                            {
                                Loop = false;
                                DisplayMessage("@gre@SBoT: @whi@Been longer than 30 seconds: Terminating Loop", 3);
                            }
                        }
                             
                        WalkOffDetect();
                        Wait(100);
                    }
                    IDLoop = false;
                  }
                }
            }
      
          }
      DisplayMessage("@gre@SBoT: @whi@FastJailRanger - @red@STOPPED", 3);
                RangeExp3 = GetExperience(4);
                Arrows3 = InvCount(11);
                Time2 = System.currentTimeMillis();
                System.out.println(">>>>> JailRanger - Stopped! <<<<< ");
                System.out.println("  Total Range Exp Gained:  " + (RangeExp3 - StartRangeExp));
                System.out.println("  Total Arrows Used:  " + (StartArrows - Arrows3));

                RangeExp2 = GetExperience(4);
                Arrows2 = InvCount(11);

    } 
} 
