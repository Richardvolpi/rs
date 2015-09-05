public class IronOreCerter extends Script
{
    public IronOreCerter(mudclient rs)
    {
   super(rs);

    }
    public String[] getCommands()
    {
   return new String[]{"certironore"};
    }
public void start(String command, String parameter[])

{

DisplayMessage("@cya@Andrew: tells you You have begun Veggy's script! For Iron ore certing! ", 3); 
while (Running())

{
while (QuestMenu() == false)
{
int CerterID = GetNearestNPC(225);
TalkToNPC(CerterID);
Wait(2000);
}
for(; !QuestMenu(); Wait(25));
Answer(1);
for(; !QuestMenu(); Wait(25));
Answer(0);
for(; !QuestMenu(); Wait(25));
Answer(4);
Wait(1000);

Walk(224,632);

while (QuestMenu() == false)
{
int BankerID = GetNearestNPC(95);
TalkToNPC(BankerID);
while (QuestMenu() == true);
Wait(1500);
}
Answer(0);
while (Bank() == false)
Wait(1500);
while (InvCount(151) < 25)
{
Withdraw(151,1);
Wait(200);
}
CloseBank();

Walk(226,631);



}

DisplayMessage("@red@STOPPED", 3);
}
}