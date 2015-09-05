public class ArrowBuyer2 extends Script 
{ 
public ArrowBuyer2(mudclient rs) 
{ 
super(rs); 
} 
public String[] getCommands() 
{ 
return new String[]{"buyarrowscatherby"}; 
} 

public void start(String command, String parameter[]) 
{ 
DisplayMessage("@red@SiLeNt g0dJr pErSoNaL ScRiPt By BrUnClE", 3); 

while (Running()) 
{ 
SetWorld(52); 
Logout(); 
while (LoggedIn() == false); 
{Wait(1);} 
BuyArrows(); 
SetWorld(54); 
Logout(); 
while (LoggedIn() == false); 
{Wait(1);} 
BuyArrows(); 
SetWorld(56); 
Logout(); 
while (LoggedIn() == false); 
{Wait(1);} 
BuyArrows(); 
} 


DisplayMessage("@red@Arrow Buyer STOPPED", 3); 
} 

public void BuyArrows() 
{ 
while (QuestMenu() == false) 
{ 
int Gullock = GetNearestNPC(587); 
TalkToNPC(Gullock); 
Wait(1000); 
} 
long T = System.currentTimeMillis(); 
while (System.currentTimeMillis() - T <= 6000 && QuestMenu() == false) 
Wait(1); 
while (QuestMenu() == true) 
{ 
Answer(0); 
} 
T = System.currentTimeMillis(); 
while (System.currentTimeMillis() - T <= 6000 && Shop() == false) 
{Wait(1);} 
while (Shop() == true ) 
{ 
while(ShopCount(669) > 0 && Shop() == true) 
{ 
Buy(669); 
Wait(1); 
}  
while(ShopCount(11) > 0 && Shop() == true) 
{ 
Buy(11); 
Wait(1); 
} 
CloseShop();  
} 
} 
} 
