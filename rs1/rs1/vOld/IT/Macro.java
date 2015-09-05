/*
 * Macro.java
 *
 * Created on September 19, 2003, 10:21 AM
 */

/**
 *
 * @author  harperart
 */
public abstract class Macro
{
    protected mudclient_Debug rs;
    /** Creates a new instance of Macro */
    public Macro(mudclient_Debug rs)
    {
        this.rs = rs;
    }
    public void start(String command)
    {
    }
    public String[] getCommands()
    {
        return new String[0];
    }
    public void init()
    {
    }
    public void stop()
    {
    }
    
}
