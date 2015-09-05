/*
 * MudClient Extension Hack
 * Thanks to ep, subanark & RichyT - Faketrix
 *
 *
 */
public class mudclient_hack extends mudclient  { // begin class
	
        public void b(String msg, int l)
	{
		System.out.println(msg);
		super.b("+" + msg + "+",l);
	}

} // end class