/*
 * macro_logChat.java
 *
 * Created on October 24, 2003, 2:06 PM
 */
import java.io.*;
/**
 *
 * @author  harperart
 */
public class macro_logChat extends Macro
{
    BufferedWriter out = null;
    MessageListener listener = new Logger();
    /** Creates a new instance of macro_logChat */
    public macro_logChat(mudclient_Debug rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[] {"log"};
    }
    boolean running = false;
    public void start(String command)
    {
        if(out == null)
            try
            {
                File file = new File(System.currentTimeMillis()+".log");
                final FileOutputStream fos = new FileOutputStream(file,true);
                out = new BufferedWriter(new OutputStreamWriter(fos,"US-ASCII"));
                System.out.println(out);
                Runtime.getRuntime().addShutdownHook(new Thread(new Runnable()
                {
                    public void run()
                    {
                        try
                        {
                            fos.close();
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                }));
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        running = !running;
        rs.displayMessage("logging "+(running?"started":"stopped"));
        if(running)
        {
            rs.addMessageListener(listener);
        }
        else
            rs.removeMessageListener(listener);
    }
    public class Logger extends MessageListener
    {
        public void messageRecieved(String message, int filter)
        {
            try
            {
                java.util.Calendar current = java.util.Calendar.getInstance();
                out.write("<"+current.get(java.util.Calendar.HOUR_OF_DAY)+":"+current.get(java.util.Calendar.MINUTE)+">"+filter+":"+message+"\n");
                out.flush();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
