/*
 * HelloMacro.java
 *
 * Created on September 19, 2003, 11:07 AM
 */

/**
 *
 * @author  harperart
 */
public class macro_HelloMacro extends Macro
{
    /** Creates a new instance of HelloMacro */
    public macro_HelloMacro(mudclient_Debug rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"hellomacro"};
    }
    public void start(String command)
    {
        rs.displayMessage("HelloMacro");
    }
}
