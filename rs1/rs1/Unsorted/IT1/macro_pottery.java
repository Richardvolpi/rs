/*
 * macro_pottery.java
 *
 * Created on September 26, 2003, 2:07 PM
 */

/**
 *
 * @author  harperart
 */
public class macro_pottery extends Macro
{
    
    /** Creates a new instance of macro_pottery */
    public macro_pottery(mudclient_Debug rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"pottery"};
    }
    public void start(String command)
    {
        while(rs.macroOn)
        {
            while(rs.getItemsInInv() != 30)
            {
                if(rs.getFatigue()>= 1)
                    rs.sleeper.sleep();
                if(!rs.macroOn)
                    return;
                rs.mineRock(306,639);
                try
                {
                    Thread.sleep(500);
                }
                catch(InterruptedException e)
                {
                }
            }
            if(!rs.macroOn)
                    return;
            rs.walkToAbout(310,621,500);
            if(!rs.macroOn)
                    return;
            rs.walkToAbout(312,605,500);
            if(!rs.macroOn)
                    return;
            rs.walkToAbout(291,592,500);
            if(!rs.macroOn)
                    return;
            rs.walkToAbout(291,575,500);
            if(!rs.macroOn)
                    return;
            rs.walkToAbout(313,541,500);
            if(!rs.macroOn)
                    return;
            rs.walkToAbout(313,539,500);
            while(rs.countItem(149) != 0)
            {
                waterFilling:
                for(int i = 0; i < rs.getItemsInInv() && i < 30;i++)
                {
                    if(rs.getItemInInv(i) == 21)
                    {
                        //System.out.println("filling water");
                        rs.useItemOnObject(i, 0, 313,539);
                        break waterFilling;
                    }
                }
                {
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch(InterruptedException e)
                    {
                    }
                }
                waterOnClay:
                for(int i = 0; i < rs.getItemsInInv();i++)
                {
                    if(rs.getItemInInv(i) == 50)
                    {
                        for(int j = 0; j < rs.getItemsInInv();j++)
                        {
                            if(rs.getItemInInv(j) == 149)
                            {
                                //System.out.println("using clay on water");
                                rs.useItemOnItem(i, j);
                                break waterOnClay;
                            }
                        }
                    }
                }
                {
                    try
                    {
                        Thread.sleep(700);
                    }
                    catch(InterruptedException e)
                    {
                    }
                }
            }
            rs.walkToAbout(315,520,500);
            rs.walkToAbout(298,507,500);
            rs.walkToAbout(282,504,500);
            rs.walkToAbout(267,510,500);
            rs.walkToAbout(252,516,500);
            rs.walkToAbout(237,514,500);
            rs.walkToAbout(227,523,500);
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException e)
            {
            }
            int items = rs.getItemsInInv();
            int i = 0;
            if(rs.getFatigue()>= 1)
                rs.sleeper.sleep();
            while(rs.getFatigue() >= 1)
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
            while(rs.countItem(243) != 0)
            {
                //System.out.println("spinning");
                for(i = 0; i < items;i++)
                {
                    int item = rs.getItemInInv(i);
                    if(item == 243)
                        break;
                }
                if(rs.getFatigue()>= 1)
                    rs.sleeper.sleep();
                rs.useItemOnObject(i, 6, 227, 524);
                int j = 0;
                while(!rs.isChoice())
                {
                    if(j > 6)
                        break;
                    try
                    {
                        Thread.sleep(500);
                    }
                    catch(InterruptedException e)
                    {
                    }
                    j++;
                }
                rs.makeNpcChoice(2);
                try
                {
                    Thread.sleep(300);
                }
                catch(InterruptedException e)
                {
                }
            }
            while(rs.countItem(278) != 0 || rs.countItem(279) != 0 || rs.countItem(340) != 0)
            {
                if(rs.getFatigue()>= 1)
                    rs.sleeper.sleep();
                //System.out.println("oven");
                for(i = 0; i < items;i++)
                {
                    int item = rs.getItemInInv(i);
                    if(item == 278 || item == 279 || item == 340)
                        break;
                }
                rs.walkTo(230, 522);
                rs.useItemOnObject(i, 2, 229, 523);
                try
                {
                    Thread.sleep(300);
                }
                catch(InterruptedException e)
                {
                }
            }
            while(rs.countItem(135) != 0 || rs.countItem(251) != 0 || rs.countItem(341)!= 0)
            {
                for(i = 0; i < rs.getItemsInInv();i++)
                {
                    if(rs.getItemInInv(i) == 135 || rs.getItemInInv(i) == 251 || rs.getItemInInv(i) == 341)
                    {
                        rs.dropItem(i);
                        break;
                    }
                }
                try
                {
                    Thread.sleep(300);
                }
                catch(InterruptedException e)
                {
                }
            }
            //System.out.println("walking");
            rs.walkToAbout(227,523,500);
            rs.walkToAbout(237,514,500);
            rs.walkToAbout(252,516,500);
            rs.walkToAbout(267,510,500);
            rs.walkToAbout(282,504,500);
            rs.walkToAbout(298,507,500);
            rs.walkToAbout(315,520,500);
            rs.walkToAbout(313,541,500);
            rs.walkToAbout(291,575,500);
            rs.walkToAbout(291,592,500);
            rs.walkToAbout(300,593,500);
            rs.walkToAbout(312,595,500);
            rs.walkToAbout(312,600,500);
            rs.walkToAbout(310,619,500);
        }
    }
    
}
