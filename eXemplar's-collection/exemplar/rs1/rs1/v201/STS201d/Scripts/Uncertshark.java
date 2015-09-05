public class Uncertshark extends Methods
{
    public Uncertshark(mudclient mudclient){super(mudclient);}
    public long l;

    public void Body(String as[])
    {
        while(Running())
        {
            WalkToWait(439,498);
            WalkToWait(431,494);
            WalkToWait(430,487);
            WalkToWait(426,485);
            while(!QuestMenu() && Running()) 
            {
                l = GetMillis();
                int i[] = GetNpcById(299);
                if(i[0] != -1)
                    TalkToNpc(i[0]);
                while(GetMillis() - l < 5000 && !QuestMenu() && Running()) 
                    Wait(100);
            }
            Answer(0);
            l = GetMillis();
            while(!QuestMenu() && Running() && GetMillis() - l < 10000)
                Wait(100);
            Answer(0);
            l = GetMillis();
            while(!QuestMenu() && Running() && GetMillis() - l < 10000)
                Wait(100);
            Answer(4);
            Wait(3000);
            WalkToWait(426,485);
            WalkToWait(430,487);
            WalkToWait(431,494);
            WalkToWait(439,497);
            WalkToWait(439,496);
            while(!QuestMenu() && Running()) 
            {
                l = GetMillis();
                int i[] = GetNpcById(95);
                if(i[0] != -1)
                    TalkToNpc(i[0]);
                while(GetMillis() - l < 5000 && !QuestMenu() && Running()) 
                    Wait(100);
            }
            Answer(0);
            l = GetMillis();
            while(!InBank() && Running() && GetMillis() - l <= 10000)
                Wait(1000);
            while(CountInv(546) > 0 && Running() && InBank())
            {
                Deposit(546, 1);
                Wait(300);
            }
            Wait(100);
            CloseBank();
        }
    }
}