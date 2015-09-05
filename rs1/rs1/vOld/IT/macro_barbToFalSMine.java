/*
 * macro_barbToFalSMine.java
 *
 * Created on September 28, 2003, 1:00 PM
 */

/**
 *
 * @author  harperart
 */
public class macro_barbToFalSMine extends Macro
{
    
    /** Creates a new instance of macro_barbToFalSMine */
    public macro_barbToFalSMine(mudclient_Debug rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"barbtofalsmine"};
    }
    public void start(String command)
    {
        rs.displayMessage("going to fal s mine");
        rs.walkToAbout(227,523,500);
        rs.walkToAbout(237,514,500);
        rs.walkToAbout(252,516,500);
        rs.walkToAbout(267,510,500);
        rs.walkToAbout(282,504,500);
        rs.walkToAbout(298,507,500);
        rs.walkToAbout(315,520,500);
        rs.walkToAbout(313,541,500);
        rs.walkToAbout(291,575,500);
        rs.walkToAbout(291,592,500);
        rs.walkToAbout(300,593,500);
        rs.walkToAbout(312,595,500);
        rs.walkToAbout(312,600,500);
        rs.walkToAbout(310,619,500);
    }
}
