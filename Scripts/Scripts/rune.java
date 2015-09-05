public class rune extends Script 
{ 
public rune(mudclient rs) 
{ 
super(rs); 
} 
public String[] getCommands() 
{ 
return new String[]{"rune"}; 
} 

public void start(String command, String parameter[]) 
{ 
DisplayMessage("@red@Rune Buyer", 3); 
while (Running()) 
{ 
SetWorld(52); 
Logout(); 
while (LoggedIn() == false); 
{Wait(1500);} 
BuyRunes(); 
SetWorld(54); 
Logout(); 
while (LoggedIn() == false); 
{Wait(1500);} 
BuyRunes(); 
SetWorld(56); 
Logout(); 
while (LoggedIn() == false); 
{Wait(1500);} 
BuyRunes(); 
SetWorld(52); 
Logout(); 
while (LoggedIn() == false); 
{Wait(1500);} 
BuyRunes(); 
SetWorld(54); 
Logout(); 
while (LoggedIn() == false); 
{Wait(1500);} 
BuyRunes(); 
SetWorld(56); 
Logout(); 
while (LoggedIn() == false); 
{Wait(1500);} 
BuyRunes(); 
SetWorld(52); 
Logout(); 
while (LoggedIn() == false); 
{Wait(1500);} 
BuyRunes(); 
} 


DisplayMessage("@red@Rune STOPPED", 3); 
} 

public void BuyRunes() 
{ 
while (QuestMenu() == false) 
{ 
int mage = GetNearestNPC(514); 
TalkToNPC(mage); 
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
while(ShopCount(31) > 0 && Shop() == true) 
{ 
Buy(31); 
Wait(1); 
} 
while(ShopCount(33) > 0 && Shop() == true) 
{ 
Buy(33); 
Wait(1); 
} 
while(ShopCount(34) > 0 && Shop() == true) 
{ 
Buy(34); 
Wait(1); 
} 
while(ShopCount(36) > 0 && Shop() == true) 
{ 
Buy(36); 
Wait(1); 
}  
CloseShop(); 
} 

} 
}