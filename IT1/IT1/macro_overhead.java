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
public class macro_overhead extends Macro implements ActionListener
{
    javax.swing.Timer timer = new javax.swing.Timer(20,null);
    int amountToChange = 0;
    /** Creates a new instance of macro_zoom */
    public macro_overhead(mudclient_Debug rs)
    {
        super(rs);
        timer.addActionListener(this);
        rs.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent e)
            {
                if(e.getKeyCode() == KeyEvent.VK_PAGE_UP)
                {
                    amountToChange = 1;
                }
                if(e.getKeyCode() == KeyEvent.VK_PAGE_DOWN)
                {
                    amountToChange = -1;
                }
            }
            public void keyReleased(KeyEvent e)
            {
                if(e.getKeyCode() == KeyEvent.VK_PAGE_UP || e.getKeyCode() == KeyEvent.VK_PAGE_DOWN);
                    amountToChange = 0;
            }
        });
        timer.start();
    }
    
    public void actionPerformed(ActionEvent e)
    {
        rs.overhead += amountToChange;
    }
    
}
