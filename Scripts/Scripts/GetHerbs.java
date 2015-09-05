public class GetHerbs extends Script 
{ 
public GetHerbs(mudclient rs) 
{ 
super(rs); 
} 
public String[] getCommands() 
{ 
return new String[]{"getherbs"}; 
} 
public void start(String command, String parameter[]) 
{ 
int bought = 0; 
if (parameter.length != 1) 
{ 
DisplayMessage("@gre@Nsomnia: @whi@Invalid number of parameters. /RUN getherbs", 3); 
} else { 
DisplayMessage("@cya@Andrew tells you: Getting Herbs omfgpwntkthnxbye kekekekeke", 3); 
DisplayMessage("@cya@Andrew has logged out", 3); 
while (Running()) 
{ 
Walk(326,550);
Walk(326,544);
Walk(321,538);
Walk(314,532);
Walk(314,526);
Walk(314,520);
Walk(319,515);
Walk(323,510);
Walk(329,505);
Walk(336,500);
Walk(338,495);
Walk(348,485);
Walk(354,477);
Walk(360,471);
   {    
   
      } 
} 
DisplayMessage("@gre@SBoT: @whi@Parameters - @red@STOPPED", 3); 
} 
} 
} 
