/*
 * macro_Loc.java
 *
 * Created on September 19, 2003, 11:43 AM
 */

/**
 *
 * @author  harperart
 */
public class macro_Loc extends Macro
{
    
    /** Creates a new instance of macro_Loc */
    public macro_Loc(mudclient_Debug rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"loc"};
    }
    public void start(String command)
    {
        rs.displayMessage("x:"+rs.getXLocation()+" y:"+rs.getYLocation()+
                          " (zone:"+rs.getXZone()+","+rs.getYZone()+")");
    }
}
