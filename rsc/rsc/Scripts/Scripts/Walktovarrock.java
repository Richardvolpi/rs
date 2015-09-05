
public class Walktovarrock extends Script 
{ 
    public Walktovarrock(mudclient rs) 
    { 
        super(rs); 
    } 
    public String[] getCommands() 
    { 
        return new String[]{"gotovarrock"}; 
     } 
      
       public void start(String command, String parameter[]) 
    { 
       DisplayMessage("@ran@D@dre@e@red@p@dre@a@red@r@dre@t@red@i@dre@n@red@g F@red@o@dre@r @red@V@dre@a@red@r@dre@r@red@o@dre@c@red@k", 3); 

      if (Running()) 
      { 
	Walk(130,641);
	Wait(100);
	Walk(134,631);
	Wait(100);
	Walk(134,624);
	Wait(100);
	Walk(127,625);
	Wait(100);
	Walk(119,624);
	Wait(100);
	Walk(112,625);
	Wait(100);
	Walk(109,616);
	Wait(100);
	Walk(113,607);
	Wait(100);
	Walk(108,598);
	Wait(100);
	Walk(107,588);
	Wait(100);
	Walk(100,579);
	Wait(100);
	Walk(91,574);
	Wait(100);
	Walk(79,573);
	Wait(100);
	Walk(69,572);
	Wait(100);
	Walk(63,564);
	Wait(100);
	Walk(64,556);
	Wait(100);
	Walk(68,547);
	Wait(100);
	Walk(69,534);
	Wait(100);
	Walk(73,526);
	Wait(100);
	Walk(82,519);
	Wait(100);
	Walk(87,509);
	Wait(100);
	Walk(99,507);
	Wait(100);
	Walk(109,507);
	Wait(100);
	Walk(121,507);
	Wait(100);
	Walk(132,511);
      } 
    
       
   DisplayMessage("@ran@W@ran@e@ran@l@ran@c@ran@o@ran@m@ran@e @ran@T@ran@o @ran@V@ran@a@ran@r@ran@r@ran@o@ran@c@ran@k @ran@S@ran@q@ran@u@ran@a@ran@r@ran@e", 3); 
    } 
}