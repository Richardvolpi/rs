/*
 * macro_smith.java
 *
 * Created on October 21, 2003, 12:28 PM
 */

/**
 *
 * @author  harperart
 */
public class macro_smith extends Macro
{
    
    /** Creates a new instance of macro_smith */
    public macro_smith(mudclient_Debug rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]
        {"smith"};
    }
    public void start(String command)
    {
        final Object lock = new Object();
        final MessageListener l = new MessageListener()
        {
            public void messageRecieved(String msg,int filter)
            {
                if(msg.indexOf("What would you like to make?") != -1)
                {
                    while(!rs.isChoice())
                        Thread.yield();
                    rs.makeNpcChoice(1);
                }
                if(msg.indexOf("Choose a type of armour to make") != -1)
                {
                    while(!rs.isChoice())
                        Thread.yield();
                    rs.makeNpcChoice(1);
                }
                if(msg.indexOf("What sort of shield do you want to make?") != -1)
                {
                    while(!rs.isChoice())
                        Thread.yield();
                    rs.makeNpcChoice(1);
                }
                if(msg.indexOf("You hammer the metal and make") != -1)
                {
                    synchronized(lock)
                    {
                        lock.notifyAll();
                    }
                }
                if(filter == 5)
                    synchronized(lock)
                    {
                        lock.notifyAll();
                    }
                    if(msg.indexOf("Banker is") != -1)
                    {
                        synchronized(lock)
                        {
                            lock.notifyAll();
                        }
                    }
            }
        };
        start:
            while(true)
            {
                if(rs.countItem(169) >= 3)
                    while(rs.getXLocation() != 118 || rs.getYLocation() != 502)
                    {
                        rs.walkTo(118,502);
                        try
                        {
                            Thread.sleep(1000);
                        }
                        catch(InterruptedException e)
                        {
                        }
                    }
                System.out.println("starting to make stuff");
                rs.addMessageListener(l);
                while(rs.countItem(169) >= 3)
                {
                    /*ew[0] = 118-cr;
                    ex[0] = 501-cs;
                    //System.out.println(cs);
                    //System.out.println(cr);
                    ey[0] = 0;
                    ez[0] = 50;*/
                    int pos = -1;
                    for(int i = 0; i < rs.getItemsInInv();i++)
                    {
                        if(rs.getItemInInv(i) == 169)
                        {
                            pos = i;
                            break;
                        }
                    }
                    rs.useItemOnObject(pos, 50, 118, 501);
                    //ev[0] = 410; //command
                    //f(0);
                    try
                    {
                        synchronized(lock)
                        {
                            lock.wait(3000);
                        }
                    }
                    catch(InterruptedException e)
                    {
                    }
                }
                //System.out.println("going to the bank");
                rs.removeMessageListener(l);
                rs.walkToAbout(102, 512,500);
                //get all the npcs on the screen
                for(int i = 0; i < rs.getNpcCount();i++)
                {
                    Object obj = rs.getNpc(i);
                    //if This npc is a banker
                    if(obj != null && rs.getNpcId(obj) == 95)
                    {
                        while(!rs.isChoice())
                        {
                            //go talk to to him
                            rs.talkToNpc(obj);
                            //ew[0] = obj.e;
                            //ex[0] = obj.f;
                            //ev[0] = 720;
                            //ey[0] = obj.c;
                            //f(0);
                            try
                            {
                                synchronized(lock)
                                {
                                    lock.wait(1000);
                                    //System.out.println("not waiting");
                                }
                                Thread.sleep(500);
                            }
                            catch(InterruptedException e)
                            {
                            }
                        }
                        //ge = false;
                        rs.makeNpcChoice(0);
                        try
                        {
                            synchronized(rs.fY)
                            {
                                rs.fY.wait(5000);
                            }
                        }
                        catch(InterruptedException e)
                        {
                        }
                        for(int j = 0; j < rs.getItemsInBank();j++)
                        {
                            if(rs.getItemInBankId(j) == 128)
                            {
                                rs.depositItem(rs.countItem(rs.getItemInBankId(j)), j);
                            }
                        }
                        int invleft = 30 - rs.getItemsInInv() + rs.countItem(128);
                        for(int j = 0; j < rs.getItemsInBank();j++)
                        {
                            if(rs.getItemInBankId(j) == 169)
                            {
                                if(rs.fZ[j] == 0)
                                    break start;
                                int k = rs.d(rs.fY[j]);
                                for(;k < invleft;k++)
                                    rs.withdrawItem(1, j);
                            }
                        }
                        rs.fT = false;
                        break;
                    }
                }
            }
    }
}
