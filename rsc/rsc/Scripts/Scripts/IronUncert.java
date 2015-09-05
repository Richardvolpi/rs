public class IronUncert extends Script
{
    public IronUncert(mudclient rs)
    {
   super(rs);

    }
    public String[] getCommands()
    {
   return new String[]{"uncertiron"};
    }
public void start(String command, String parameter[])

{

DisplayMessage("@blu@SBoT: @red@Uncerting Iron - @cya@Vegunks", 3); 
while (Running())

{
while (QuestMenu() == false)
{
int CerterID = GetNearestNPC(225);
TalkToNPC(CerterID);
Wait(1000);
}
for(; !QuestMenu(); Wait(10));
Answer(0);
for(; !QuestMenu(); Wait(10));
Answer(0);
for(; !QuestMenu(); Wait(10));
Answer(4);
Wait(1000);

Walk(224,632);

while (QuestMenu() == false)
{
int BankerID = GetNearestNPC(95);
TalkToNPC(BankerID);
while (QuestMenu() == true);
Wait(1000);
}
Answer(0);
while (Bank() == false)
Wait(1000);
while (InvCount(151) > 0)
{
Deposit(151,25);
Wait(100);
}
CloseBank();

Walk(226,631);



}

DisplayMessage("@red@STOPPED", 3);
}
}