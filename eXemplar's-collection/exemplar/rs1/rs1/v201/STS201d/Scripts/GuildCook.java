/* 
 * STS Guild Cooker, cooks raw lobsters in guild. Can't handle burns so make sure
 * you don't burn any.
 */

public class GuildCook extends Methods
{
    public GuildCook(mudclient mc){super(mc);}
    
    public long l;
    
    public void Body(String Args[])
    {
        AutoLogin(true);
        while(Running())
        {
            Display("You have " + IntToStr(CountInv(534) * 5) + " raw lobsters.");
            while(CountInv(373) > 4 && Running())
            {
                l = GetMillis();
                while(!QuestMenu() && GetMillis() - l < 20000)
                {
                    int[] Npc = GetNpcById(369);
                    if(Npc[0] != -1)
                        TalkToNpc(Npc[0]);
                    Wait(2000);
                }
                Wait(2000);
                Answer(1);
                l = GetMillis();
                while(!QuestMenu() && GetMillis() - l < 10000)
                    Wait(10);
                Answer(0);
                l = GetMillis();
                while(!QuestMenu() && GetMillis() - l < 10000)
                    Wait(10);
                Answer(4);
                Wait(3000);
            }
            while(CountInv(372) < 25 && Running())
            {
                l = GetMillis();
                while(!QuestMenu() && GetMillis() - l < 20000)
                {
                    int[] Npc = GetNpcById(369);
                    if(Npc[0] != -1)
                        TalkToNpc(Npc[0]);
                    Wait(2000);
                }
                Wait(2000);
                Answer(0);
                l = GetMillis();
                while(!QuestMenu() && GetMillis() - l < 10000)
                    Wait(10);
                Answer(3);
                l = GetMillis();
                while(!QuestMenu() && GetMillis() - l < 10000)
                    Wait(10);
                Answer(4);
                Wait(3000);
            }
            GoToFrom("cooking","certer");
            while(CountInv(372) > 0 && Running())
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
                UseOnObject(GetItemPos(372),583,520);
                Wait(3000);
            }
            GoToFrom("certer","cooking");
            Wait(1000);
        }
        End();
    }
    
    public void GoToFrom(String to, String from)
    {
        String BadFrom = "Error, invalid \"from\" value.";
        String BadTo = "Error, invalid \"to\" value.";
        if(from.equalsIgnoreCase("fishing"))
        {
            if(to.equalsIgnoreCase("cooking"))
            {
                WalkToWait(587,502);
                WalkToWait(587,508);
                WalkToWait(586,518);
                while(DoorAt(586,519))
                {
                    OpenDoor(586,519);
                    Wait(1000);
                }
                WalkToWait(586,520);
            }
            else if(to.equalsIgnoreCase("certer"))
            {
                WalkToWait(587,502);
                WalkToWait(595,502);
                WalkToWait(602,506);
                while(DoorAt(603,506))
                {
                    OpenDoor(603,506);
                    Wait(1000);
                }
                WalkToWait(603,503);
            }
            else Display(BadTo);
        
        }
        else if(from.equalsIgnoreCase("cooking"))
        {
            if(to.equalsIgnoreCase("fishing"))
            {
                while(DoorAt(586,519))
                {
                    OpenDoor(586,519);
                    Wait(1000);
                }
                WalkToWait(586,518);
                WalkToWait(587,508);
                WalkToWait(587,502);
            }
            else if(to.equalsIgnoreCase("certer"))
            {
                while(DoorAt(586,519))
                {
                    OpenDoor(586,519);
                    Wait(1000);
                }
                WalkToWait(586,518);
                WalkToWait(593,516);
                WalkToWait(601,510);
                WalkToWait(603,507);
                while(DoorAt(603,506))
                {
                    OpenDoor(603,506);
                    Wait(1000);
                }
                WalkToWait(603,503);
            }
            else Display(BadTo);
        }
        else if(from.equalsIgnoreCase("certer"))
        {
            if(to.equalsIgnoreCase("cooking"))
            {
                while(DoorAt(603,506))
                {
                    OpenDoor(603,506);
                    Wait(1000);
                }
                WalkToWait(603,507);
                WalkToWait(601,510);
                WalkToWait(593,516);
                WalkToWait(586,518);
                while(DoorAt(586,519))
                {
                    OpenDoor(586,519);
                    Wait(1000);
                }
                WalkToWait(586,520);
            }
            else if(to.equalsIgnoreCase("fishing"))
            {
                while(DoorAt(603,506))
                {
                    OpenDoor(603,506);
                    Wait(1000);
                }
                WalkToWait(602,506);
                WalkToWait(595,502);
                WalkToWait(587,502);
            }
            else Display(BadTo);
        }
        else Display(BadFrom);
    }
}