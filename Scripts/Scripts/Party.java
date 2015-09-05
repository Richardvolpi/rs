//By Tidus 
public class Party extends Script 
{ 
public Party(mudclient rs) 
{ 
super(rs); 
} 
public String[] getCommands() 
{ 
return new String[]{"get"}; 
} 
public void start(String command, String parameter[]) 
{ 
int item = Integer.parseInt(parameter[0]); 
while (Running()); 
{ 
while (Running() == true); 
{ 
int i[] = GetNearestItem(item); 
Say("ha! i got it"); 
} 
} 
} 
}