/*
 * macro_ghost.java
 *
 * Created on October 3, 2003, 8:49 PM
 */

/**
 *
 * @author  harperart
 */
public class macro_ghost extends Macro
{
    
    /** Creates a new instance of macro_ghost */
    public macro_ghost(mudclient_Debug rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"ghost"};
    }
    public void start(String command)
    {
        if(command.equals("ghost"))
        {
            rs.ghost = !rs.ghost;
            rs.displayMessage("Ghost is:"+String.valueOf(rs.ghost));
            return;
        }
        int x = Integer.parseInt(command.substring("ghost ".length(),command.indexOf(',')));
        int y = Integer.parseInt(command.substring(command.indexOf(',')+1));
        rs.ghost = false;
        rs.cO = 20;
        rs.cP = 20;
        rs.c(x,y);
        rs.ghost = true;
    }
}
