public class ArrowBuyer1 extends Script 
{ 
public ArrowBuyer1(mudclient rs) 
{ 
super(rs); 
} 
public String[] getCommands() 
{ 
return new String[]{"buyarrowstrigun"}; 
} 

public void start(String command, String parameter[]) 
{ 
DisplayMessage("@red@Arrow Buyer", 3); 

while (Running()) 
{ 
SetWorld(5); 
Logout(); 
while (LoggedIn() == false); 
{Wait(1500);} 
BuyArrows(); 
SetWorld(54); 
Logout(); 
while (LoggedIn() == false); 
{Wait(1500);} 
BuyArrows(); 
SetWorld(56); 
Logout(); 
while (LoggedIn() == false); 
{Wait(1500);} 
BuyArrows(); 
SetWorld(52); 
Logout(); 
while (LoggedIn() == false); 
{Wait(1500);} 
BuyArrows(); 
SetWorld(54); 
Logout(); 
while (LoggedIn() == false); 
{Wait(1500);} 
BuyArrows(); 
SetWorld(56); 
Logout(); 
while (LoggedIn() == false); 
{Wait(1500);} 
BuyArrows(); 
SetWorld(52); 
Logout(); 
while (LoggedIn() == false); 
{Wait(1500);} 
BuyArrows(); 
} 


DisplayMessage("@red@Arrow Buyer STOPPED", 3); 
} 

public void BuyArrows() 
{ 
while (QuestMenu() == false) 
{ 
int lowe = GetNearestNPC(58); 
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