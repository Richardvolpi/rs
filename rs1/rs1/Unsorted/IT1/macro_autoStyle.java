/*
 * macro_autoStyle.java
 *
 * Created on October 3, 2003, 10:46 PM
 */

/**
 *
 * @author  harperart
 */
public class macro_autoStyle extends Macro implements java.awt.event.ActionListener
{
    
    private int style = 0;
    boolean on = false;
    javax.swing.Timer timer = new javax.swing.Timer(200,this);
    /** Creates a new instance of macro_autoStyle */
    public macro_autoStyle(mudclient_Debug rs)
    {
        super(rs);
    }
    
    public String[] getCommands()
    {
        return new String[] {"autostyle"};
    }
    
    public void start(String command)
    {
        if(command.equals("autostyle"))
        {
            on = !on;
            if(on)
                timer.start();
            else
                timer.stop();
            rs.displayMessage("autostyle is:"+(on?"on":"off"));
            return;
        }
        style = Integer.parseInt(command.substring("autostyle ".length()));
        if(!on)
            timer.start();
        rs.displayMessage("autostyle is set to:"+style);
    }
    
    public void actionPerformed(java.awt.event.ActionEvent e)
    {
        if(rs.gh != style && rs.isMobInCombat(rs.getYourself()))
        {
            rs.setCombatStyle(style);
            rs.gh = style;
        }
    }
    
}
