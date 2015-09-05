/* 
 * STS Autocooker script for cooking Shark in catherby.
 * Based on Jakes catherby shark cooker script for SBoT198.
 */

public class Cooker extends Methods
{
    public Cooker(mudclient mudclient){super(mudclient);}

    public void Body(String as[])
    {
        AutoLogin(true);
        while(Running()) 
        {
            Display("You have " + IntToStr(CountInv(631) * 5) + " raw shark.");
            for(; CountInv(545) < 25; Wait(3000))
            {
                for(long l = GetMillis(); !QuestMenu() && GetMillis() - l < 20000L; Wait(2000))
                {
                    int ai[] = GetNpcById(299);
                    if(ai[0] != -1)
                        TalkToNpc(ai[0]);
                }

                Wait(2000);
                Answer(0);
                for(long l1 = GetMillis(); !QuestMenu() && GetMillis() - l1 < 10000L; Wait(10));
                Answer(1);
                for(long l2 = GetMillis(); !QuestMenu() && GetMillis() - l2 < 10000L; Wait(10));
                Answer(4);
            }

            WalkToWait(427, 485);
            for(; DoorAt(427, 485); Wait(1500))
                OpenDoor(427, 485);

            WalkToWait(426, 485);
            WalkToWait(425, 486);
            for(; DoorAt(435, 486); Wait(1500))
                OpenDoor(435, 486);

            WalkToWait(435, 485);
            for(; CountInv(545) > 0 && Running(); Wait(3000))
            {
                if(GetFatigue() > 90 && Running())
                {
                    for(; !Sleeping() && Running(); Wait(2500))
                        UseItem(GetItemPos(1263));

                    for(; Sleeping() && Running(); Wait(100));
                }
                UseOnObject(GetItemPos(545), 432, 480);
            }

            WalkToWait(435, 485);
            for(; DoorAt(435, 486); Wait(1500))
                OpenDoor(435, 486);

            WalkToWait(425, 486);
            WalkToWait(426, 485);
            for(; DoorAt(427, 485); Wait(1500))
                OpenDoor(427, 485);

            WalkToWait(427, 485);
            while(CountInv(546) > 4) 
            {
                for(long l3 = GetMillis(); !QuestMenu() && GetMillis() - l3 < 20000L; Wait(2000))
                {
                    int ai1[] = GetNpcById(299);
                    if(ai1[0] != -1)
                        TalkToNpc(ai1[0]);
                }

                Wait(2000);
                Answer(1);
                for(long l4 = GetMillis(); !QuestMenu() && GetMillis() - l4 < 10000L; Wait(10));
                Answer(2);
                for(long l5 = GetMillis(); !QuestMenu() && GetMillis() - l5 < 10000L; Wait(10));
                Answer(4);
                Wait(3000);
            }
        }
        Display("Script finished...");
        End();
    }
}