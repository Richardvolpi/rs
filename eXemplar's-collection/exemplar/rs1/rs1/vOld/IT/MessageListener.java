/*
 * MessageListener.java
 *
 * Created on September 7, 2003, 1:25 PM
 */

/**
 *
 * @author  harperart
 */
public abstract class MessageListener implements java.util.EventListener
{
    public void messageRecieved(String message,int filter)
    {
        if(filter == 5)
            questMessageRecieved(message);
        else if(filter == 6)
            privateMessageRecieved(message);
    }
    public void questMessageRecieved(String message)
    {
    }
    public void privateMessageRecieved(String message)
    {
    }
}
