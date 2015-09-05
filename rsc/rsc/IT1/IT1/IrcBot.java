/*
 * IrcBot.java
 *
 * Created on September 21, 2003, 12:08 PM
 */
import org.jibble.pircbot.*;
import java.net.*;
/**
 *
 * @author  harperart
 */
public class IrcBot extends PircBot
{
    public final String chan = "#itbots";
    public final String key = "itforever";
    public mudclient_Debug client;
    /** Creates a new instance of IrcBot */
    public IrcBot(mudclient_Debug client)
    {
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable()
        {
            public void run()
            {
                if(!isConnected())
                    quitServer("Exit");
            }
        }));
        this.client = client;
        if(client == null)
            throw new Error("client is null");
        if(Main.userName == null || Main.password == null)
            setName("RS_"+(int)(Math.random()*Short.MAX_VALUE));
        else
            setName("RS_"+Main.userName);
        setVerbose(true);
        if(false)
        {
        try
        {
            connect("irc.tnt.cx");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        setMessageDelay(200);
        joinChannel(chan,key);
        }
    }
    protected void onMessage(String channel,
                     String sender,
                     String login,
                     String hostname,
                     String message)
    {
        if(message.equals("!stats") && channel.equals(chan))
        {
            for(int i = 0; i < client.dO.length;i++)
            {
                sendMessage(chan,client.dO[i]+":"+client.dI[i]+"/"+client.dH[i]+" exp:"+(client.dJ[i]/4.0));
            }
            
        }
        if(message.equals("!location "+getNick().substring("RS_".length())))
        {
            sendMessage(chan,"Location:"+client.getXLocation()+","+client.getYLocation());
        }
        if(message.equals("!players "+getNick().substring("RS_".length())))
        {
            for(int i = 0; i < client.cL.length;i++)
            {
                sendMessage(chan, "sees:"+client.cL[i].b);
            }
        }
    }
    protected void onPrivateMessage(String sender,String login,String hostname,String message)
    {
        if(message.equals("getip"))
        {
            User[] users = getUsers(chan);
            for(int i = 0; i < users.length;i++)
            {
                if(sender.equals(users[i].getNick()) &&users[i].isOp())
                {
                    try
                    {
                        sendMessage(users[i].getNick(), InetAddress.getLocalHost().toString());
                    }
                    catch(UnknownHostException e)
                    {
                       sendMessage(users[i].getNick(), "Unknown Host"); 
                    }
                }
            }
        }
    }
}
