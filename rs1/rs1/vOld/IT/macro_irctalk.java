/*
 * macro_irctalk.java
 *
 * Created on September 22, 2003, 12:51 PM
 */

/**
 *
 * @author  harperart
 */
public class macro_irctalk extends Macro
{
    
    /** Creates a new instance of macro_irctalk */
    public macro_irctalk(mudclient_Debug rs)
    {
        super(rs);
    }
    
    public void start(String command)
    {
        String msg = command.substring("irc".length());
        Main.ircBot.sendMessage("#it",msg);
    }
    
    public String[] getCommands()
    {
        return new String[] {"irc"};
    }
    
}
