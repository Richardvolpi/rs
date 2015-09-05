/*
 * macro_pickup.java
 *
 * Created on September 23, 2003, 1:32 PM
 */
import java.util.*;
/**
 *
 * @author  harperart
 */
public class macro_pickup extends Macro
{
    
    /** Creates a new instance of macro_pickup */
    public macro_pickup(mudclient_Debug rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"pickup"};
    }
    public void start(String command)
    {
        StringTokenizer tokenizer = new StringTokenizer(command);
        tokenizer.nextToken();
        Vector itemsToPickup = new Vector();
        while(tokenizer.hasMoreTokens())
        {
            itemsToPickup.add(new Integer(tokenizer.nextToken()));
        }
        while(rs.macroOn)
        {
            int min = Integer.MAX_VALUE;
            int minI = -1;
            for(int i = 0; i < rs.getItemCountGround();i++)
            {
                Integer item = new Integer(rs.getItemIDGround(i));
                if(itemsToPickup.contains(item))
                {
                    int eval = Math.abs(rs.getItemXLocation(i)-rs.getXLocation())+Math.abs(rs.getItemYLocation(i)-rs.getYLocation());
                    if(eval < min)
                    {
                        minI = i;
                        min = eval;
                    }
                }
            }
            if(min == Integer.MAX_VALUE)
            {
                System.out.println("no bones");
                try
                {
                    Thread.sleep(5000);
                }
                catch(InterruptedException e)
                {
                }
                continue;
            }
            rs.getItemOffGround(minI);
            try
            {
                Thread.sleep(5000);
            }
            catch(InterruptedException e)
            {
            }
            continue;
        }
    }
}
