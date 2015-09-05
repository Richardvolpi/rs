/*
 * macro_zoom.java
 *
 * Created on September 29, 2003, 9:10 AM
 */
import java.awt.event.*;
/**
 *
 * @author  harperart
 */
public class macro_terainToggle extends Macro
{
    /** Creates a new instance of macro_zoom */
    public macro_terainToggle(final mudclient_Debug rs)
    {
        super(rs);
        rs.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent e)
            {
                if(e.getKeyCode() == KeyEvent.VK_F9)
                {
                    rs.terainOn = !rs.terainOn;
                }
            }
        });
    }
}
