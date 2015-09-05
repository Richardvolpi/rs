/*
 * macro_lobsterCatcher.java
 *
 * Created on October 11, 2003, 3:41 PM
 */

/**
 *
 * @author  harperart
 */
public class macro_lobsterCatcher extends Macro
{
    
    /** Creates a new instance of macro_lobsterCatcher */
    public macro_lobsterCatcher(mudclient_Debug rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"lobster"};
    }
    public void start(String command)
    {
        while(rs.macroOn)
        {
            while(rs.getItemsInInv() != 30)
            {
                if(!rs.macroOn)
                    return;
                while(rs.getFatigue() >= .85)
                    rs.sleeper.sleep();
                //System.out.println("trying to catch a lobster");
                rs.mineRock(589,501,0,1);
                try
                {
                    Thread.sleep(1000);
                }
                catch(InterruptedException e)
                {
                }
            }
            rs.walkToAbout(583,521, 500);
            cookingStart:
            if(true)
                {
                    while(true)
                    {
                        if(!rs.macroOn)
                            return;
                        while(rs.getFatigue() >= .85)
                            rs.sleeper.sleep();
                        int i;
                        for(i = 0; i < 30;i++)
                        {
                            if(rs.getItemInInvName(i).startsWith("Raw") || rs.getItemInInvName(i).startsWith("raw"))
                                break;
                        }
                        if(i == 30)
                        {
                            rs.displayMessage("no raw lobsters found");
                            break cookingStart;
                        }
                        int j;
                        for(j = 0; j < rs.getObjectCount();j++)
                        {
                            int objid = rs.getObjectID(j);
                            if((objid == 11 || objid == 119 || objid == 435 || objid == 491))
                            {
                                if(rs.getFatigue() >= .85)
                                    rs.sleeper.sleep();
                                rs.useItemOnObject(i, rs.getObjectSendID(j), rs.getObjectXLocation(j),rs.getObjectYLocation(j));
                                try
                                {
                                    Thread.sleep(500);
                                }
                                catch(InterruptedException e)
                                {
                                }
                                break;
                            }
                        }
                        if(j == rs.getObjectCount())
                        {
                            rs.displayMessage("no range found");
                            return;
                        }
                    }
                }
            certing:
            if(rs.countItem(373) >= 5)
            {
                if(!rs.macroOn)
                    return;
                rs.walkTo(603, 503);
                while(rs.getXLocation() != 603 || rs.getYLocation() != 503)
                {
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch(InterruptedException e)
                    {
                    }
                    if(!rs.macroOn)
                        return;
                    rs.walkTo(603, 503);
                }
                int i;
                for(i = 0; i < rs.getNpcCount();i++)
                {
                    Object obj = rs.getNpc(i);
                    //if This npc is a banker
                    if(obj != null && rs.getNpcId(obj) == 369)
                    {
                        while(!rs.isChoice())
                        {
                            //go talk to to him
                            rs.talkToNpc(obj);
                            try
                            {
                                Thread.sleep(1000);
                            }
                            catch(InterruptedException e)
                            {
                            }
                        }
                        rs.makeNpcChoice(1);
                        while(!rs.isChoice())
                            try
                            {
                                Thread.sleep(200);
                            }
                            catch(InterruptedException e)
                            {
                            }
                        rs.makeNpcChoice(0);
                        while(!rs.isChoice())
                            try
                            {
                                Thread.sleep(200);
                            }
                            catch(InterruptedException e)
                            {
                            }
                        rs.makeNpcChoice(4);
                        try
                        {
                            Thread.sleep(1000);
                        }
                        catch(InterruptedException e)
                        {
                        }
                        break certing;
                    }
                }
                rs.displayMessage("could not find npc 369");
            }
            else
                rs.displayMessage("Not enough lobsters for certing");
        }
    }
}
