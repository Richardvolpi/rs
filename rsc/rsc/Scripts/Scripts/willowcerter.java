class willowcerter extends Script
{
    public willowcerter(mudclient rs)
    {
   super(rs);

    }
    public String[] getCommands()
    {
   return new String[]{"certwillow"};
    }
public void start(String command, String parameter[])

{

DisplayMessage("@blu@SBoT: @red@Certing willow logs by - Vegunks, Edited by Jaggs to certwillow", 3); 
while (Running())

{
while (QuestMenu() == false)
{
int CerterID = GetNearestNPC(341);
TalkToNPC(CerterID);
Wait(2000);
}
for(; !QuestMenu(); Wait(25));
Answer(1);
for(; !QuestMenu(); Wait(25));
Answer(2);
for(; !QuestMenu(); Wait(25));
Answer(4);
Wait(1000);

Walk(587,564);
Walk(587,569);
Walk(581,570);
Walk(579,575);
 

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
while (InvCount(633) < 25)
{
Withdraw(633,1);
Wait(200);
}
CloseBank();

Walk(581,570);
Walk(587,569);
Walk(587,564);


}

DisplayMessage("@red@STOPPED", 3);
}
}