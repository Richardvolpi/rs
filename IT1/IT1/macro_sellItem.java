/*
 * macro_sellItem.java
 *
 * Created on October 23, 2003, 12:32 PM
 */

/**
 *
 * @author  harperart
 */
public class macro_sellItem extends Macro
{
    
    /** Creates a new instance of macro_sellItem */
    public macro_sellItem(mudclient_Debug rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"sellitem"};
    }
    public void start(String command)
    {
        String number = command.substring("sellitem ".length());
        if(number.length() == 0)
        {
            rs.displayMessage(""+rs.getSelectedItemInStore());
        }
        else
        {    int pos = Integer.parseInt(number);
            rs.sellItem(pos);
        }
    }
}
