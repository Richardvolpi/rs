public class ArrowBuyer5 extends Script 
{ 
public ArrowBuyer5(mudclient rs) 
{ 
super(rs); 
} 
public String[] getCommands() 
{ 
return new String[]{"buyarrows5"}; 
} 

public void start(String command, String parameter[]) 
{ 
DisplayMessage("@red@Arrow Buyer5", 3); 

while (Running()) 
{ 
SetWorld(81); 
Logout(); 
while (LoggedIn() == false); 
{Wait(1500);} 
BuyArrows(); 
SetWorld(82); 
Logout(); 
while (LoggedIn() == false); 
{Wait(1500);} 
BuyArrows(); 
SetWorld(83); 
Logout(); 
while (LoggedIn() == false); 
{Wait(1500);} 
BuyArrows(); 
SetWorld(84); 
Logout(); 
while (LoggedIn() == false); 
{Wait(1500);} 
BuyArrows(); 
SetWorld(85); 
Logout(); 
while (LoggedIn() == false); 
{Wait(1500);} 
BuyArrows(); 
SetWorld(86); 
Logout(); 
} 


DisplayMessage("@red@Arrow Buyer STOPPED", 3); 
} 

public void BuyArrows() 
{ 
while (QuestMenu() == false) 
{ 
int lowe = GetNearestNPC(289); 
TalkToNPC(lowe); 
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
if (Shop() == true ) 
{ 
while(ShopCount(190) > 0 && Shop() == true) 
{ 
Buy(190); 
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