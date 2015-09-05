/*
 * automine.java
 *
 * Created on October 10, 2003, 8:17 AM
 */

/**
 *
 * @author  harperart
 */
public class macro_automine extends Macro
{
    
    /** Creates a new instance of automine */
    public macro_automine(mudclient_Debug rs)
    {
        super(rs);
    }
    
    public String[] getCommands()
    {
        return new String[]{"automine"};
    }
    
    public void start(String command)
    {
        if(command.equals("automine"))
        {
            final Object messageLock = new Object();
            MessageListener listener = new MessageListener()
            {
                public void messageRecieved(String message,int filter)
                {
                    synchronized(messageLock)
                    {
                        if(message.indexOf("You manage to obtain")!= -1)
                            messageLock.notifyAll();
                        if(message.indexOf("You only") != -1)
                            messageLock.notifyAll();
                        if(filter == 5)
                            messageLock.notifyAll();
                    }
                }
            };
            rs.addMessageListener(listener);
            boolean topRock = false;
            while(true)
            {
                while(rs.getItemsInInv() < 30 /*&& b.h[dA[29]] != 1*/)
                {
                    if(rs.getFatigue() >= 1.0)
                        rs.sleeper.sleep();
                    if(!rs.macroOn)
                        return;
                    if(topRock)
                        rs.mineRock(76,543,1,0);
                    else
                        rs.mineRock(76,544,1,0);
                    topRock = !topRock;
                    try
                    {
                        synchronized(messageLock)
                        {
                            messageLock.wait(3000);
                        }
                        //Thread.sleep(1300+(int)(Math.random()*300));
                    }
                    catch(InterruptedException e)
                    {
                        break;
                    }
                }
                if(!rs.macroOn)
                    return;
                if(!rs.walkTo(102,512))
                {
                    if(!rs.macroOn)
                        return;
                    rs.walkToAbout(70,531,500);
                    if(!rs.macroOn)
                        return;
                    rs.walkToAbout(75,515,500);
                    if(!rs.macroOn)
                        return;
                    rs.walkToAbout(90,509,500);
                    if(!rs.macroOn)
                        return;
                    rs.walkToAbout(102,512,500);
                }
                //get all the npcs on the screen
                bankingStart:
                for(int i = 0; i < rs.getNpcCount();i++)
                {
                    Object obj = rs.getNpc(i);
                    //if This npc is a banker
                    if(obj != null && rs.getNpcId(obj) == 95)
                    {
                        while(!rs.isChoice())
                        {
                            //go talk to to him
                            if(!rs.macroOn)
                                return;
                            rs.talkToNpc(obj);
                            try
                            {
                                synchronized(messageLock)
                                {
                                    messageLock.wait(1000);
                                }
                            }
                            catch(InterruptedException e)
                            {
                            }
                        }
                        rs.makeNpcChoice(0);
                        rs.waitForBank(5000);
                        for(int j = 0; j < rs.getItemsInBank();j++)
                        {
                            int id = rs.getItemInBankId(j);
                             //copper ore   tin ore      iron ore     gold         mithril ore  addy ore     coal         blurite ore  runite ore   uncut diamond uncut ruby  uncut emerald uncut sapphire
                            if(id == 150 || id == 202 || id == 151 || id == 152 || id == 153 || id == 154 || id == 155 || id == 266 || id == 409 || id == 157 || id == 158 || id == 159 || id == 160)
                            {
                                rs.depositItem(rs.countItem(id), j);
                            }
                        }
                        rs.setBankVisible(false);
                        break bankingStart;
                    }
                }
            }
        }
    }
}
