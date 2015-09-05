/*
 * IRCMain.java
 *
 * Created on September 20, 2003, 4:15 PM
 */
import org.jibble.pircbot.*;
import javax.swing.*;
/**
 *
 * @author  harperart
 */
public class IRCMain extends PircBot
{
    
    /** Creates a new instance of IRCMain */
    public IRCMain()
    {
    }
    public static void main2(String[] args) throws Exception
    {
        System.out.println(java.net.InetAddress.getLocalHost());
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception
    {
        IRCMain bot = new IRCMain();
        bot.setName("subs_bot");
        bot.setVerbose(true);
        try
        {
            bot.connect("irc.tnt.cx");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    protected void onConnect()
    {
        
    }
    protected void onMessage(String channel,
                         String sender,
                         String login,
                         String hostname,
                         String message)
    {
        System.out.println(sender);
        if(message.indexOf("penis") != -1)
        {
            User[] users = getUsers("#sleepwalktalk");
            for(int i = 0; i < users.length;i++)
            {
                if(users[i].getNick().equals(sender) && users[i].getPrefix().length() == 0)
                    kick("#sleepwalktalk",sender,"no sex for you");
            }
        }
        if(sender.startsWith("subanark"))
        {
            if(message.equals("!stop"))
            {
                disconnect();
                System.exit(0);
            }
        }
    }
    public void onNotice(String sourceNick, String sourceLogin,String sourceHostname,String target,String notice)
    {
        //System.out.println(sender);
        if(sourceNick.equals("NickServ") && notice.startsWith("Password accepted"))
        {
            joinChannel("#sleepwalktalk");
        }
    }
}
