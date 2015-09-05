/*
 * macro_autoKillAndPickup.java
 *
 * Created on September 23, 2003, 3:00 PM
 */
import java.util.*;
import java.io.*;
/**
 *
 * @author  harperart
 */
public class macro_autoKillAndPickup extends Macro
{
    Vector configs = new Vector();
    /** Creates a new instance of macro_autoKillAndPickup */
    public macro_autoKillAndPickup(mudclient_Debug rs)
    {
        super(rs);
        File f = new File("kap");
        File[] files = f.listFiles();
        for(int i = 0; i < files.length;i++)
        {
            if(!files[i].getName().endsWith(".macro"))
                continue;
            Config config = new Config();
            String s;
            BufferedReader br;
            try
            {
                String macroName = files[i].getName();
                macroName = macroName.substring(0,macroName.length()-".macro".length());
                config.macroName = macroName;
                FileInputStream fis = new FileInputStream(files[i]);
                InputStreamReader isr = new InputStreamReader(fis,"US-ASCII");
                br = new BufferedReader(isr);
                s = br.readLine();
                while(s != null)
                {
                    if(s.equals("#npcsid"))
                    {
                        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
                        while(tokenizer.hasMoreTokens())
                        {
                            config.npcs.add(new Integer(tokenizer.nextToken()));
                        }
                    }
                    else if(s.equals("#items"))
                    {
                        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
                        while(tokenizer.hasMoreTokens())
                        {
                            config.items.add(new Integer(tokenizer.nextToken()));
                        }
                    }
                    else if(s.equals("#maxLevel"))
                    {
                        config.maxLevel = Integer.parseInt(br.readLine());
                    }
                    else if(s.equals("#minLevel"))
                    {
                        config.minLevel = Integer.parseInt(br.readLine());
                    }
                    else if(s.equals("#pickUpStackable"))
                    {
                        config.pickUpStackable = Boolean.valueOf(br.readLine()).booleanValue();
                    }
                    else if(s.equals("#maxFatigue"))
                    {
                        config.maxFatigue = Float.parseFloat(br.readLine());
                    }
                    else if(s.equals("#useRange"))
                    {
                        config.useRange = Boolean.valueOf(br.readLine()).booleanValue();
                    }
                    else if(s.equals("#drop"))
                    {
                        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
                        while(tokenizer.hasMoreTokens())
                        {
                            config.drop.add(new Integer(tokenizer.nextToken()));
                        }
                    }
                    else if(s.equals("#use"))
                    {
                        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
                        while(tokenizer.hasMoreTokens())
                        {
                            config.use.add(new Integer(tokenizer.nextToken()));
                        }
                    }
                    System.out.println(config.drop);
                    s = br.readLine();
                }
                configs.add(config);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    public String[] getCommands()
    {
        String[] commands = new String[configs.size()];
        for(int i = 0; i < configs.size();i++)
        {
            commands[i] = (((Config)configs.get(i)).macroName);
        }
        return commands;
    }
    public void start(String command)
    {
        final Object player = rs.getYourself();
        Config config = null;
        StringTokenizer tokens = new StringTokenizer(command);
        String mName = tokens.nextToken();
        for(int i = 0; i < configs.size();i++)
        {
            if(((Config)configs.get(i)).macroName.equals(mName))
            {
                config = (Config)configs.get(i);
            }
        }
        if(config == null)
            return;
        while(rs.macroOn)
        {
            if(rs.getFatigue()>= config.maxFatigue)
                rs.sleeper.sleep();
            while(rs.getFatigue() >= config.maxFatigue)
            {
                try
                {
                    Thread.sleep(1000);
                }
                catch(InterruptedException e)
                {
                }
                continue;
            }
            cookingStart:
            if(config.useRange && rs.getItemsInInv() == 30)
            {
                while(true)
                {
                    while(rs.getFatigue() >= config.maxFatigue)
                    {
                        try
                        {
                            Thread.sleep(1000);
                        }
                        catch(InterruptedException e)
                        {
                        }
                        continue;
                    }
                    int i;
                    for(i = 0; i < 30;i++)
                    {
                        if(rs.getItemInInvName(i).startsWith("raw"))
                            break;
                    }
                    if(i == 30)
                        break cookingStart;
                    for(int j = 0; j < rs.getObjectCount();j++)
                    {
                        int objid = rs.getObjectID(j);
                        if((objid == 11 || objid == 119 || objid == 435 || objid == 491))
                        {
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
                }
            }
            for(int i = 0; i < rs.getItemsInInv();i++)
            {
                if(config.drop.contains(new Integer(rs.getItemInInv(i))))
                {
                    rs.dropItem(i);
                    i = 0;
                    try
                    {
                        Thread.sleep(500);
                    }
                    catch(InterruptedException e)
                    {
                    }
                }
            }
            for(int i = 0; i < rs.getItemsInInv();i++)
            {
                if(config.use.contains(new Integer(rs.getItemInInv(i))))
                {
                    rs.useItem(i);
                    try
                    {
                        Thread.sleep(300);
                        
                    }
                    catch(InterruptedException e)
                    {
                    }
                }
            }
            boolean getItem = false;
            int min = Integer.MAX_VALUE;
            int minI = -1;
            for(int i = 0; i < rs.getItemCountGround();i++)
            {
                Integer item = new Integer(rs.getItemIDGround(i));
                if((config.pickUpStackable && rs.isItemStackable(item.intValue())) || config.items.contains(item))
                {
                    int eval = Math.abs(rs.getItemXLocation(i)-rs.getXLocation())+Math.abs(rs.getItemYLocation(i)-rs.getYLocation());
                    if(eval < min)
                    {
                        minI = i;
                        min = eval;
                        getItem = true;
                    }
                }
            }
            for(int i = 0;i < rs.getNpcCount();i++)
            {
                Object npc = rs.getNpc(i);
                if(npc == null)
                    continue;
                Thread.yield();
                float npcLevel = rs.getNpcLevel(npc);
                if(rs.isNpcAttackable(npc) && ((npcLevel >= config.minLevel && npcLevel < config.maxLevel+1) || config.npcs.contains(new Integer(rs.getNpcId(npc)))) && !rs.isMobInCombat(npc))
                {
                    int eval = Math.abs(rs.convertMobToLoc(rs.getMobXPosition(player)-rs.getMobXPosition(npc)))+Math.abs(rs.convertMobToLoc(rs.getMobYPosition(player)-rs.getMobYPosition(npc)));
                    if(eval < min)
                    {
                        minI = i;
                        min = eval;
                        getItem = false;
                    }
                }
            }
            if(min == Integer.MAX_VALUE)
            {
                System.out.println("no items");
                try
                {
                    Thread.sleep(1000);
                }
                catch(InterruptedException e)
                {
                }
                continue;
            }
            if(getItem)
                rs.getItemOffGround(minI);
            else
                rs.directAttack(rs.getNpc(minI));
            do
            {
                try
                {
                    Thread.sleep(1500);
                }
                catch(InterruptedException e)
                {
                    System.out.println("intrupted!");
                }
            }while(rs.isMobInCombat(player));
        }
    }
    static class Config
    {
        String macroName;
        Vector npcs = new Vector();
        Vector items = new Vector();
        Vector drop = new Vector();
        Vector use = new Vector();
        boolean pickUpStackable = false;
        int maxLevel = 0;
        int minLevel = 0;
        float maxFatigue = 1.0f;
        boolean useRange = false;
    }
}
