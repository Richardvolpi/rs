/*
 * macro_windowChat.java
 *
 * Created on November 8, 2003, 2:15 PM
 */
import java.util.*;
/**
 *
 * @author  harperart
 */
public class macro_windowChat extends Macro implements MessageDispenser
{
    Hashtable chatWindows = new Hashtable();
    /** Creates a new instance of macro_windowChat */
    public macro_windowChat(slave rs)
    {
        super(rs);
        rs.addMessageListener(new macro_windowChat.PMMessageDispenser());
    }
    
    public void sendMessage(final String reciever, final String message)
    {
        rs.addLoopListener(new Runnable()
        {
            public void run()
            {
                rs.sendPM(reciever, message);
                rs.removeLoopListener(this);
            }
        });
    }
    
    public class PMMessageDispenser extends MessageListener
    {
        
        public void privateMessageRecieved(String message)
        {
            if(message.startsWith("@pri@You tell "))
                return;
            String name = message.substring(5,message.indexOf(":"));
            message = message.substring(message.indexOf(": tells you ")+": tells you ".length());
            displayMessage(name,message);
        }
    }
    
    public void displayMessage(String name,String message)
    {
        ChatWindow chatWindow = (ChatWindow)chatWindows.get(name);
        if(chatWindow == null)
        {
            chatWindow = new ChatWindow((java.awt.Frame)javax.swing.SwingUtilities.getWindowAncestor(rs),name,macro_windowChat.this);
            chatWindow.setSize(250,130);
            chatWindows.put(name,chatWindow);
        }
        if(!chatWindow.isVisible())
            chatWindow.show();
        if(message != null)
            chatWindow.addRecievedMessage(message);
    }
    public String[] getCommands()
    {
        return new String[]{"newMessage"};
    }
    public String[] getComments()
    {
    	return new String[]{"On PM will display new window for chatting/nUsage:/c newMessage name to open pm window"};
    }
    public void start(String command)
    {
        String name = command.substring("newMessage ".length()).toLowerCase();
        char[] nameCh = new char[name.length()];
        name.getChars(0, name.length(),nameCh,0);
        nameCh[0] = Character.toUpperCase(nameCh[0]);
        name = new String(nameCh);
        displayMessage(name,null);
    }
}
