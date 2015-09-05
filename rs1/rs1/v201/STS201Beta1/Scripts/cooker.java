/*
 *
 *  This is a example script for STS, it cooks shark in catherby, based on Jakes catherby
 *  shark cooker that was for SBoT198.
 *
 */

public class cooker extends Methods
{
    public cooker(mudclient mc){super(mc);}
    public long l;
    
    public void Body(String Args[])
    {
        AutoLogin(true);
        while(Running())
        {
            Display("You have " + IntToStr(CountInv(631) * 5) + " raw shark.");
            while(CountInv(545) < 25)
            {
                l = GetMillis();
                while(!QuestMenu() && GetMillis() - l < 20000)
                {
                    int[] Npc = GetNpcById(299);
                    if(Npc[0] != -1)
                        TalkToNpc(Npc[0]);
                    Wait(2000);
                }
                Wait(2000);
                Answer(0);
                l = GetMillis();
                while(!QuestMenu() && GetMillis() - l < 10000)
                    Wait(10);
                Answer(1);
                l = GetMillis();
                while(!QuestMenu() && GetMillis() - l < 10000)
                    Wait(10);
                Answer(4);
                Wait(3000);
            }
            WalkToWait(427,485);
            while(DoorAt(427,485))
            {
                OpenDoor(427,485);
                Wait(1500);
            }
            WalkToWait(426,485);
            WalkToWait(425,486);
            while(DoorAt(435,486)) 
            { 
                OpenDoor(435,486); 
                Wait(1500); 
            } 
            WalkToWait(435,485); 
            while(CountInv(545) > 0 && Running()) 
            { 
                if(GetFatigue() > 90 && Running()) 
                { 
                    while(!Sleeping() && Running()) 
                    { 
                        UseItem(GetItemPos(1263)); 
                        Wait(2500); 
                    } 
                    while(Sleeping() && Running()) 
                        Wait(100); 
                }
                UseOnObject(GetItemPos(545),432,480); 
                Wait(3000); 
            }
            WalkToWait(435,485); 
            while(DoorAt(435,486)) 
            { 
                OpenDoor(435,486); 
                Wait(1500); 
            } 
            WalkToWait(425,486); 
            WalkToWait(426,485); 
            while(DoorAt(427,485)) 
            { 
                OpenDoor(427,485); 
                Wait(1500); 
            } 
            WalkToWait(427,485); 
            while(CountInv(546) > 4)
            {
                l = GetMillis();
                while(!QuestMenu() && GetMillis() - l < 20000)
                { 
                    int[] Npc = GetNpcById(299);
                    if(Npc[0] != -1)
                        TalkToNpc(Npc[0]);
                    Wait(2000);
                }
                Wait(2000);
                Answer(1);
                l = GetMillis();
                while(!QuestMenu() && GetMillis() - l < 10000)
                    Wait(10);
                Answer(2);
                l = GetMillis();
                while(!QuestMenu() && GetMillis() - l < 10000)
                    Wait(10);
                Answer(4);
                Wait(3000);
            }
        }
        End();
        Display("Script finished...");
    }
}