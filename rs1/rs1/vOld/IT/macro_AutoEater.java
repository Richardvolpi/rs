/*
 * AutoEater.java
 *
 * Created on September 14, 2003, 12:33 PM
 */

/**
 *
 * @author  harperart
 */
public class macro_AutoEater extends Macro
{
    /** Creates a new instance of AutoEater */
    public macro_AutoEater(mudclient_Debug client)
    {
        super(client);
    }
    public String[] getCommands()
    {
        return new String[]{"autoeat"};
    }
    public void start(String command)
    {
        while(rs.macroOn)
        {
            if(rs.getMaxHP() - rs.getCurrentHP() >= 3)
            {
                if(rs.countItem(132) > 0)
                {
                    for(int j = 0; j < rs.getItemsInInv();j++)
                    {
                        if(rs.getItemInInv(j) == 132)
                        {
                            System.out.println("found meat at:"+j);
                            rs.useItem(j);
                            break;
                        }
                    }
                }
            }
            try
            {
                Thread.currentThread().sleep(500);
            }
            catch(InterruptedException e)
            {
            }
        }
    }
    
}
