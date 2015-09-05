public class UberGuild extends Script 
{ 
    public UberGuild(mudclient rs) 
    { 
        super(rs); 
    } 
    public String[] getCommands() 
    { 
        return new String[]{"uberguild"}; 
    } 

public void Walk2Dock() 
{ 
Walk(587,502); 
} 

public void Walk2Cook() 
{ 
Walk(586,518); 
Wait(100); 
for (OpenDoor(586,519,0); DoorAt(586,519,0) == 2; Wait(500)); 
Walk(586,520); 
Wait(100); 
Walk(584,521); 
Wait(300); 
} 

public void Cook(int C) 
{ 
if (Fatigue() >= 75) { Use(FindInv(1263)); Wait(500); while (Sleeping() && Running()) { Wait(100); }} 
if (InvCount(C) != 0) { UseOnObject(583,520,FindInv(C)); } 
} 

public void Talk2Guy(int fi) 
{ 
int NPCid = 0; 
if (fi == 0 || fi == 1) { NPCid = GetNearestNPC(369); } else { NPCid = GetNearestNPC(370); } 
Wait(5000); if (!QuestMenu()) { TalkToNPC(NPCid); } 
} 

public void Walk2Certs() 
{ 
Walk(587,517); 
Wait(100); 
Walk(595,515); 
Wait(100); 

Walk(601,507); 
Wait(100); 
while (DoorAt(603,506,3) == 2) { OpenDoor(603,506,3); Wait(500); } 
Walk(604,505); 
Wait(100); 
} 

public void Cert(int F, int M, int I) 
{ 
int NPCid = 0; 
if (I == 0 || I == 1) { NPCid = GetNearestNPC(369); } else { NPCid = GetNearestNPC(370); } 
for (; !QuestMenu(); Talk2Guy(I)); 
Answer(1); 
for (; !QuestMenu(); Wait(1000)); 
int Fishy = 0; 
if (F == 0 && M == 1) { Answer(1); Fishy=372; } 
if (F == 0 && M == 2) { Answer(0); Fishy=373; } 
if (F == 1 && M == 1) { Answer(3); Fishy=369; } 
if (F == 1 && M == 2) { Answer(2); Fishy=370; } 
if (F == 2 && M == 1) { Answer(3); Fishy=545; } 
if (F == 2 && M == 2) { Answer(2); Fishy=546; } 
for (; !QuestMenu(); Wait(1000)); 
if (InvCount(Fishy) ==5 ) { Answer(0); } else if (InvCount(Fishy) >5 && InvCount(Fishy) <=10) { Answer(1); } else if (InvCount(Fishy) >=25) { Answer(4); } 
} 

    public void start(String command, String parameter[]) 
    { 
int Mode = Integer.parseInt(parameter[0]); 
int iFish = Integer.parseInt(parameter[1]); 
String Fish[] = {"lobster","swordfish","shark"}; 
String Modes[] = {"powerfishing","certing","cooking and certing"}; 
int Fid[] = {372,369,545}; 
int Burnts[] = {374,371,547}; 
int Cooked[] = {373,370,546}; 
int Currently = 0; 

if (parameter.length != 2) { DisplayMessage("@ora@><>@whi@ Invalid parameters, press F9 and try again.",3); DisplayMessage("@ora@<><@whi@ /run uberguild [mode],[fish]",3); return;} 

DisplayMessage("@ora@><>@whi@ UberGuild by rnyth",3); 
DisplayMessage("@ora@<><@whi@ Started " + Modes[Mode] + " " + Fish[iFish],3); 
   while (Running()) 
{ 
Wait(250); 
if (Fatigue() >= 75) { while (!Sleeping()) { Wait(100); Use(FindInv(1263)); } while (Sleeping()) { Wait(100); } } 
if (InLastServerMessage("5 mins")) { Walk(588,502); Wait(500); Walk(589,502); } 
if (iFish == 0) { AtObject(589,501); } else { AtObject2(589,501); } 
if (iFish == 2) { AtObject2(588,498); } 
if (iFish == 1 && InvCount(366) != 0) { Drop(FindInv(366)); } 
if (Mode == 1 && InvCount() == 30) 
{ 
Walk2Certs(); 
Wait(500); 
while (InvCount(Fid[iFish]) != 0) { Cert(iFish, Mode,iFish); Wait(1000); } 
Wait(500); 
Walk2Dock(); 
} 

if (Mode == 2 && InvCount() == 30 && InvCount(Fid[iFish]) != 0) 
{ 
Walk2Cook(); 
Wait(500); 
while (InvCount(Fid[iFish]) != 0) { if (Fatigue() >= 75) { while(!Sleeping() && Running()) { Use(FindInv(1263)); Wait(250); } while (Sleeping() && Running()) { Wait(100); }} Cook(Fid[iFish]); Wait(250); } 
while (InvCount(Burnts[iFish]) != 0) { Drop(FindInv(Burnts[iFish])); Wait(500); } 
if (InvCount(Fid[iFish]) == 0 && InvCount() == 30) { 
Walk2Certs(); 
Wait(500); 
while (InvCount(Fid[iFish]) > 5) { Cert(iFish, Mode,iFish); Wait(1000); } 
while (InvCount(Cooked[iFish]) > 5) { Cert(iFish, Mode,iFish); Wait(1000); } 
Wait(500); 
Walk2Dock(); 
} else { 
Wait(500); 
Walk2Dock(); 
} 
} 
      } 

DisplayMessage("@ora@><>@whi@   Finished " + Modes[Mode] + " " + Fish[iFish],3); 
    } 
} 