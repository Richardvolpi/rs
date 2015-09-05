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
public class macro_zoom extends Macro implements ActionListener
{
    javax.swing.Timer timer = new javax.swing.Timer(20,null);
    float amountToChange = 1;
    /** Creates a new instance of macro_zoom */
    public macro_zoom(mudclient_Debug rs)
    {
        super(rs);
        timer.addActionListener(this);
        rs.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent e)
            {
                if(e.getKeyCode() == KeyEvent.VK_UP)
                {
                    amountToChange = 1/.95f;
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN)
                {
                    amountToChange = .95f;
                }
            }
            public void keyReleased(KeyEvent e)
            {
                if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN);
                    amountToChange = 1;
            }
        });
        timer.start();
    }
    
    public void actionPerformed(ActionEvent e)
    {
        rs.zoom *= amountToChange;
        if(rs.zoom > 15000)
            rs.zoom = 15000;
    }
    
}
