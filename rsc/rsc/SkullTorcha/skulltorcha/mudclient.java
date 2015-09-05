import java.lang.*;
import java.util.*;
import java.awt.*;
import java.net.*;
import java.io.*;
import java.security.*;
import java.applet.*;
import java.text.*;
import javax.imageio.*;
import java.awt.image.*;

public final class mudclient extends Applet_Sub1_Sub1
{

public fightmacro fmacro;
public fishmacro fishm;
public resetmacro rmacro;
public reply rply;
public checker check;
public logout die;
public int npcid[] = new int[50];
public boolean aut0 = false;
public int playerclickvar = 2;
public int npcclickvar = 2;
public int prayclickvar = 2;
public int foodclickvar = 0;
public int bgcolorclickvar = 1;
public int txtcolorclickvar = 2;
public int foodheals[] = new int[100];
public int foodid[] = new int[100];
public int foodidlength = 0;
public int foodhealslength = 0;
public int hexbgcolor[] = {0xffffff,0x000000,0xff0000,0x00ff00,0x0000ff,0xff00ff,0xffff00,0x00ffff};
public int hextxtcolor[] = {0xffffff,0x000000,0xff0000,0x00ff00,0x0000ff,0xff00ff,0xffff00,0x00ffff};
public int delay = 1000;
public int x = 0;
boolean autoLogin;
public int macromode;
public boolean showcomb = true;
public int serval;
public String server;
public int startx;
public int starty;
public int radius = 0;
public int yrot = 912;
public boolean pause = false;
public int newworld;
public String log[] = new String[10000];
public int logx = 0;
public long start = System.currentTimeMillis();
public boolean showhp = false;
public String oldword;
public boolean gfx = true;
public boolean key[] = {false,false,false,false,false,false,false,false};
public boolean switching = false;
public long macroexp = 0;
public int zoomvar1 = 0;
public int zoomvar2 = 0;
public int fow = 2500;
public String[] replies = {"hey","hi2u","hello","hi","sup"};
public String replyname;
SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
public int whatm;
public boolean mag3 = false;
public magemacro mmacro;
public int spellid = 0;
public long[] old = new long[18];
public String prefix = "Pic";
public String message;
public boolean f1sh = false;
public int[][] fishing = new int[4][8];
public int doorlimit = 5;
public int bone[] = {9999,20,413,604,814};
public int boneclickvar = 0;
public int pickup[] = new int[100];
public int pickuplength = 0;
public boolean picking = false;
public int startmode = 1;
public int picklimit = 0;
public boolean reseter = false;
public double version = 2.3;

public int invcount()
{
    return anInt708;
}

public void settings()throws Exception
{
    String s;
    BufferedReader input = new BufferedReader(new FileReader(/*super.path + */"./settings.txt"));
    while((s = input.readLine()) != null)
    {
        if(s.startsWith("rs name="))
            aString734 = s.substring(s.indexOf('=') + 1).trim();
        else if(s.startsWith("rs pass="))
            aString735 = s.substring(s.indexOf('=') + 1).trim();
        else if(s.startsWith("server="))
            server = s.substring(s.indexOf('=') + 1).trim();
        else if(s.startsWith("foodid="))
        {
            String temp = s.substring(s.indexOf('(') + 1, s.indexOf(')') + 1);
            foodidlength = countarg(temp);
            for(int x = 0;x < foodidlength;x++)
                foodid[x] = Integer.parseInt(arg(temp,x + 1));
            foodid[foodidlength] = 9999;
            foodidlength++;
        }
        else if(s.startsWith("foodheals="))
        {
            String temp = s.substring(s.indexOf('(') + 1, s.indexOf(')') + 1);
            foodhealslength = countarg(temp);
            for(int x = 0;x < foodhealslength;x++)
                foodheals[x] = Integer.parseInt(arg(temp,x + 1));
            foodheals[foodhealslength] = 4;
            foodhealslength++;
        }
        else if(s.startsWith("pickup="))
        {
            String temp = s.substring(s.indexOf('(') + 1, s.indexOf(')') + 1);
            pickuplength = countarg(temp);
            for(int x = 0;x < pickuplength;x++)
                pickup[x] = Integer.parseInt(arg(temp,x + 1));
        }
        else if(s.startsWith("screenshot prefix="))
            prefix = s.substring(s.indexOf('=') + 1).trim();
        else if(s.startsWith("start mode="))
            startmode = Integer.parseInt(s.substring(s.indexOf('=') + 1).trim());
    }
    input.close();
    if(foodidlength != foodhealslength)
        System.out.println("Fucktard! Invalid food settings");
 /*   else
    {
        try
        {
            URL url = new URL("http://67.111.205.85/skulltorcha/auth.php?u=" + auth + "&p=" + pass + "&v=" + version);
            URLConnection urlconnection = url.openConnection();
            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(urlconnection.getInputStream()));
            String temp = bufferedreader.readLine().trim();
            if(temp.equalsIgnoreCase("valid"))
            {
                validauth = true;
                message = "Please enter your username and password";
            }
            else if(temp.equalsIgnoreCase("invalid"))
            {
                message = "Auth invalid, check settings file";
                System.out.println(message);
            }
            else if(temp.equalsIgnoreCase("not set"))
            {
                message = "Auth and/or pass not set!";
                System.out.println(message);
            }
            else if(temp.equalsIgnoreCase("not set"))
            {
                message = "Your banned nig";
                System.out.println(message);
            }
            else
            {
                message = "Unknown error";
                System.out.println(message);
            }
            if(!autoupdate)
                return;
            int upd = 0;
            upd = Integer.parseInt(bufferedreader.readLine().trim());
            if(upd > 0)
            {
                anInt690 = 2;
                message = "Update downloaded, please reload ST.";
                validauth = false;
                System.out.println("Downloading update..." + (upd / 1024) + "kb");
                update("Skull.jar",upd);
            }
        }
        catch(Exception e)
        {
            message = "Auth server may be down? Or auto-update failed.";
            System.out.println(message);
        }
    }*/
}


public int getitemindex(boolean checkid)
{
    int minj = -1;
    int min = 9999999;
    for(int j = 0; j < anInt823; j++)
    {
        int distx = (int)Math.sqrt(((anIntArray770[j] + anInt783) - getx())*((anIntArray770[j] + anInt783) - getx()));
        int disty = (int)Math.sqrt(((anIntArray771[j] + anInt784) - gety())*((anIntArray771[j] + anInt784) - gety()));
        if((initemarray(anIntArray772[j]) || !checkid) && (picklimit == 0 || (distx < picklimit && disty < picklimit)))
        {
            int temp = distx + disty;
            if(temp < min)
            {
                minj = j;
                min = temp;
            }
        }
    }
    return minj;
}

public boolean initemarray(int i)
{
    for(int x = 0;x < pickuplength;x++)
        if(pickup[x] == i)
            return true;
    return false;
}

public int getbone()
{
    int minj = -1;
    int min = 9999999;
    for(int j = 0; j < anInt823; j++)
    {
        int distx = (int)Math.sqrt(((anIntArray770[j] + anInt783) - getx())*((anIntArray770[j] + anInt783) - getx()));
        int disty = (int)Math.sqrt(((anIntArray771[j] + anInt784) - gety())*((anIntArray771[j] + anInt784) - gety()));
        if(anIntArray772[j] == bone[boneclickvar])
        {
            int temp = distx + disty;
            if(temp < min)
            {
                minj = j;
                min = temp;
            }
        }
    }
    return minj;
}

public void pickupwait(int i)throws Exception
{
    pickup(i);
    Thread.sleep(500);
    long startt = System.currentTimeMillis();
    int objx = anIntArray770[i] + anInt783;
    int objy = anIntArray771[i] + anInt784;
    int distx, disty;
    do
    {
        distx = (int)Math.sqrt((objx - getx())*(objx - getx()));
        disty = (int)Math.sqrt((objy - gety())*(objy - gety()));
        Thread.sleep(rand(500,1000));
    }
    while((distx > 1 || disty > 1) && System.currentTimeMillis() - startt < 2000);
}

public void pickup(int i)throws Exception
{
    anIntArray882[0] = 220;
    anIntArray937[0] = anIntArray770[i];
    anIntArray938[0] = anIntArray771[i];
    anIntArray803[0] = anIntArray772[i];
    method93(0);
}

public void withdraw(int id, int i)
{
    super.aClass14_Sub1_620.method331(131);
    super.aClass14_Sub1_620.method343(id);
    super.aClass14_Sub1_620.method343(i);
    super.aClass14_Sub1_620.method346();
}

public void deposit(int id, int i)
{
    super.aClass14_Sub1_620.method331(190);
    super.aClass14_Sub1_620.method343(id);
    super.aClass14_Sub1_620.method343(i);
    super.aClass14_Sub1_620.method346();
}

      


protected final void loggedin(String s)
{
    try{checkformod(s,"no",true);}
    catch(Exception e){System.out.println(e);}
}

public int rand(int min,int max)
{
    return (int)(Math.random() * (max - min + 1) ) + min;
}

private class fishmacro extends Thread
{
    public void run()
    {
        while(f1sh)
        {
            try
            {
                int r = rand(0,fishing[0][7]);
                if(method58(fishing[0][5]) < 25 && f1sh)
                    walkwait(fishing[r][3],fishing[r][4],1);
                Thread.sleep(1000);
                while(method58(fishing[0][5]) < 25 && f1sh)
                {
                    while(!loggedin() && f1sh)
                        Thread.sleep(2000);
                    atobject(fishing[r][0],fishing[r][1],fishing[0][6]);
                    Thread.sleep(rand(3200,3500));
                    if(getfatigue() >= 80 && !aBoolean870 && f1sh)
                    {
                        if(method58(1263) > 0)
                        {
                            Thread.sleep(2000);
                            chat("@red@ST:@whi@ Pmg sleeping!");
                            useitem(1263);
                            Thread.sleep(4000);
                        }
                        else
                        {
                            chat("@red@ST:@whi@ no sleeping bag!");
                            f1sh = false;
                        }
                    }
                    while((!loggedin() || aBoolean870) && f1sh)
                        Thread.sleep(2000);
                }
                if(method58(fishing[0][5]) >= 25 && f1sh)
                {
                    Thread.sleep(3000);
                    walkwait(602,506,1);
                    walkto(604,504);
                    Thread.sleep(2000);
                }
                while(door(603,506,3) && f1sh)
                {
                    chat("@red@ST:@whi@ Nig door closers!... Opening...");
                    opendoor(603,506,3);
                    Thread.sleep(2000);
                    while(!loggedin() && f1sh)
                        Thread.sleep(2000);
                }
                walkto(604,504);
                Thread.sleep(1000);
                while(!loggedin() && f1sh)
                    Thread.sleep(2000);
                if(f1sh)
                    walkwait(604,504,1);
                while(method58(fishing[0][5]) >= 25 && f1sh)
                {
                    while(!loggedin() && f1sh)
                        Thread.sleep(2000);
                    chat("@red@ST:@whi@ Certing...");
                    while(!aBoolean852 && f1sh)
                    {
                        int i = getnpcindex(false);
                        if(i != -1)
                            talknpc(i);
                        Thread.sleep(1500);
                        while(!loggedin() && f1sh)
                            Thread.sleep(2000);
                    }
                    if(f1sh)
                    {
                        Thread.sleep(1000);
                        answer(1);
                        while(!aBoolean852)
                            Thread.sleep(500);
                        Thread.sleep(1000);
                        answer(fishing[0][2]);
                        while(!aBoolean852)
                            Thread.sleep(500);
                        Thread.sleep(1000);
                        answer(4);
                        Thread.sleep(3000);
                        walkwait(603,505,1);
                    }
                    Thread.sleep(1000);
                }
                while(door(603,506,3) && f1sh)
                {
                    while(!loggedin() && f1sh)
                        Thread.sleep(2000);
                    chat("@red@ST:@whi@ Nig door closers!... Opening...");
                    opendoor(603,506,3);
                    Thread.sleep(2000);
                    walkto(602,507);
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
                reset("Guild fisher");
            }
        }
    }
    fishmacro()
    {
        start();
    }
}

public void atobject(int x,int y,int click)throws Exception
{
    anIntArray882[0] = (click == 1? 420: 2400);
    anIntArray937[0] = x - anInt783;
    anIntArray938[0] = y - anInt784;
    method93(0);
}

public void talknpc(int i)throws Exception
{
    anIntArray882[0] = 720;
    anIntArray937[0] = aClass2Array768[i].anInt149;
    anIntArray938[0] = aClass2Array768[i].anInt150;
    anIntArray803[0] = aClass2Array768[i].anInt147;
    method93(0);
}

public void opendoor(int x,int y,int dir)throws Exception
{
    anIntArray882[0] = 320;
    anIntArray937[0] = x - anInt783;
    anIntArray938[0] = y - anInt784;
    anIntArray803[0] = dir;
    method93(0);
}

public void fixdoors()throws Exception
{
    for(int a = 0;a < anInt855;a++)
    {
        int doorx = anIntArray747[a] + anInt783;
        int doory = anIntArray748[a] + anInt784;
        int distx = (int)Math.sqrt((doorx - getx())*(doorx - getx()));
        int disty = (int)Math.sqrt((doory - gety())*(doory - gety()));
        while(distx <= doorlimit && disty <= doorlimit && Class1.aStringArray72[anIntArray741[a]].equalsIgnoreCase("Open"))
        {
            chat("@red@ST:@whi@ Nig door closers!... Opening...");
            anIntArray882[0] = 320;
            anIntArray937[0] = anIntArray747[a];
            anIntArray938[0] = anIntArray748[a];
            anIntArray803[0] = anIntArray740[a];
            method93(0);
            Thread.sleep(2000);
        }
    }
}

public boolean door(int x,int y,int dir)
{
    for(int a = 0;a < anInt855;a++)
        if(anIntArray747[a] == (x - anInt783) && anIntArray748[a] == (y - anInt784) && anIntArray740[a] == dir)
        {
            if(Class1.aStringArray72[anIntArray741[a]].equalsIgnoreCase("WalkTo"))
                return false;
            else
                return true;
        }
    return false;
}

public void answer(int i)
{
    super.aClass14_Sub1_620.method331(189);
    super.aClass14_Sub1_620.method348(i);
    super.aClass14_Sub1_620.method346();
    anInt813 = 0;
    aBoolean852 = false;
}

public void walkwait(int x,int y,int limit)throws Exception
{
    int distx = (int)Math.sqrt((x - getx())*(x - getx()));
    int disty = (int)Math.sqrt((y - gety())*(y - gety()));
    while(distx > limit || disty > limit)
    {
        walkto(x,y);
        Thread.sleep(2000);
        distx = (int)Math.sqrt((x - getx())*(x - getx()));
        disty = (int)Math.sqrt((y - gety())*(y - gety()));
    }
}

public void screenie()
{
    try
    {
        File file = null;
        for(int x = 1;x < Integer.MAX_VALUE;x++)
        {
            file = new File("./Screenshots/" + prefix + x + ".png");
            if(!file.exists())
            {
                BufferedImage bufferedImage = new BufferedImage(anInt676,anInt677 + 10,BufferedImage.TYPE_INT_RGB);
                Graphics2D g2d = bufferedImage.createGraphics();
                g2d.drawImage(aClass6_Sub1_724.anImage320,0,0,this);
                g2d.dispose();
                ImageIO.write(bufferedImage,"png",file);
                break;
            }
        }
    }
    catch(IOException e){System.out.println(e);}
}

public boolean inarray(int i,int arr[])
{
    for(int x = 0;x < arr.length;x++)
        if(arr[x] == i)
            return true;
    return false;
}

public String checkword()
{
    try
    {
        BufferedReader input = null;
        input = new BufferedReader(new FileReader("./slword.txt"));
        String in = input.readLine().trim();
        input.close();
        return in;
    }
    catch(Exception e){return oldword;}
}

public void say(String s)
{
    int k3 = Class17.method400(s);
    method34(Class17.aByteArray569, k3);
    s = Class17.method399(Class17.aByteArray569, 0, k3);
    s = Class16.method374(s);
    aClass2_975.anInt161 = 150;
    aClass2_975.aString160 = s;
    String chat = gettime() + " - " + aClass2_975.aString146 + " : " + s;
    method118(chat, 2);
    addlog(chat);
}

public String gettime()
{
    Date today = new Date();
    return formatter.format(today);
}

public void addfriend(String name)
{
    String s = name;
    super.aString40 = "";
    super.aString41 = "";
    anInt931 = 0;
    if(s.length() > 0 && Class15.method362(s) != aClass2_975.aLong145)
        method31(s);
}

public long getplayerid(String name)
{
    for(int k8 = 0; k8 < super.anInt624; k8++)
        if(name.equalsIgnoreCase(Class15.method363(super.aLongArray625[k8]).trim()))
            return super.aLongArray625[k8];
    return -1;
}

public void pm(String name,String msg)
{
    aLong928 = getplayerid(name);
    if(aLong928 == -1)
        return;
    String s1 = msg;
    super.aString42 = "";
    super.aString43 = "";
    anInt931 = 0;
    int k = Class17.method400(s1);
    method33(aLong928, Class17.aByteArray569, k);
    s1 = Class17.method399(Class17.aByteArray569, 0, k);
    s1 = Class16.method374(s1);
    method42("@pri@You tell " + Class15.method363(aLong928) + ": " + s1);
}



protected final void checkformod(String name,String msg,boolean pm)throws Exception
{
    msg = msg.trim();
    name = name.trim();
    String nm = name.substring(0,4);
    if((name.equalsIgnoreCase("Andrew") || name.equalsIgnoreCase("Paul") || nm.equalsIgnoreCase("Mod ")) && (aut0 || mag3 || f1sh))
    {
        System.out.println("Fuck a mod! Logging out");
        aut0 = mag3 = f1sh = false;
        if(pm)
        {
            replyname = name;
            rply = new reply();
        }
        else
            say(replies[rand(0,5)]);
        die = new logout();
    }
    else
        for(int x = 0; x < anInt742; x++)
        {
            String nam = aClass2Array983[x].aString146.substring(0,4);
            if(aClass2Array983[x].aString146.equalsIgnoreCase("Andrew") || aClass2Array983[x].aString146.equalsIgnoreCase("Paul") || nam.equalsIgnoreCase("Mod "))
            {
                System.out.println("Fuck a mod! Logging out");
                aut0 = false;
                mag3 = false;
                f1sh = false;
                die = new logout();
            }
        }
}

private class reply extends Thread
{
    public void run()
    {
        try
        {
           addfriend(replyname);
           Thread.sleep(rand(1000,2000));
           pm(replyname,replies[rand(0,5)]);
        }
        catch(Exception e){}
    }
    reply()
    {
        start();
    }
}

public void addtofile(String filename,String[] msg)throws Exception
{
    File add = new File(filename);
    Writer output = null;
    output = new BufferedWriter(new FileWriter(add));
    for(int a = 0;a < logx; a++)
        output.write(msg[a] + "\n");
    if(output != null)
        output.close();
}

public void addlog(String s)
{
    if(s != null)
    {
        log[logx] = s;
        logx++;
    }
}

public boolean friend(int i)
{

    for(int k8 = 0; k8 < super.anInt624; k8++)
    {
        if(aClass2Array983[i].aLong145 != super.aLongArray625[k8] || super.anIntArray626[k8] != 99 || super.anIntArray626[k8] <= 0)
            continue;
        return true;
    }
    return false;
}

public boolean canattack(int i)
{
    int maxlvl = aClass2_975.anInt168 + wildlvl();
    int minlvl = aClass2_975.anInt168 - wildlvl();
    if(aClass2Array983[i].anInt168 >= minlvl && aClass2Array983[i].anInt168 <= maxlvl && wildlvl() > 0)
        return true;
    return false;
}

public int wildlvl()
{
    int j6 = 2203 - (anInt977 + anInt807 + anInt784);
    if(anInt976 + anInt806 + anInt783 >= 2640)
        j6 = -50;
    if(j6 > 0)
        return 1 + j6 / 6;
    return 0;
}

public boolean loggedin()
{
    return anInt947 == 1;
}

private class checker extends Thread
{
    public void run()
    {
        while(aBoolean870)
        {
            try
            {
                Toolkit.getDefaultToolkit().beep();
                Thread.sleep(5000);
                String temp = checkword();
                if(!temp.equalsIgnoreCase(oldword) && (anInt893 * 100) < 3750)
                    aString41 = temp;
            }
            catch(Exception e){}
        }
    }
    checker()
    {
        start();
    }
}

private class logout extends Thread
{
    public void run()
    {
        try
        {
            Thread.sleep(1000);
            while(loggedin())
            {
                aClass14_Sub1_620.method331(3);
                aClass14_Sub1_620.method346();
                anInt746 = 1000;
                Thread.sleep(2000);
            }
            Thread.sleep(5000);
        }
        catch(Exception e){}
    }
    logout()
    {
        start();
    }
}

private class resetmacro extends Thread
{
    public void run()
    {
        try
        {
            aut0 = mag3 = f1sh = false;
            Thread.sleep(5000);
            switch(whatm)
            {
                case 1:
                    aut0 = true;
                    fmacro.run();
                    break;
                case 2:
                    mag3 = true;
                    mmacro.run();
                    break;
                case 3:
                    f1sh = true;
                    fishm.run();
                    break;
                default:
                    System.out.println("error");
            }
            reseter = false;
        }
        catch(Exception e){}
    }
    resetmacro()
    {
        start();
    }
}

public void reset(String s)
{
    if(!incomb() && !reseter)
    {
        reseter = true;
        if(aut0)
            whatm = 1;
        else if(mag3)
            whatm = 2;
        else if(f1sh)
            whatm = 3;
        rmacro = new resetmacro();
        chat("@red@ST:@whi@ " + s + " reset");
    }
}

private class magemacro extends Thread
{
    public void run()
    {
        while(mag3 && checkspell(spellid))
        {
            try
            {
                int id = getnpcindex(false);
	        if(id != -1 && !aBoolean870 && loggedin() && mag3 && !pause && getfatigue() < 95)
	        {
	            castonnpc(spellid,id);
                    Thread.sleep((delay + rand(1000,1500)) / 2);
                    setmode(macromode);
                    Thread.sleep((delay + rand(1000,1500)) / 2);
                }
                else
                {
                    if(bone[boneclickvar] != 9999 && !incomb() && !aBoolean870 && loggedin() && mag3 && !pause)
                    {
                        int item = getbone();
                        if(item != -1)
                            pickupwait(item);
                        while(!incomb() && !aBoolean870 && loggedin() && mag3 && !pause && getfatigue() < 95 && method58(bone[boneclickvar]) > 0)
                        {
                            useitem(bone[boneclickvar]);
                            Thread.sleep(delay + rand(600,700));
                        }
                    }
                    if(picking && !incomb() && !aBoolean870 && loggedin() && mag3 && !pause)
                    {
                        int item = getitemindex(true);
                        if(item != -1)
                            pickupwait(item);
                        Thread.sleep(rand(50,100));
                    }
                    Thread.sleep(rand(10,20));
                }
                if(doorlimit > 0)
                    fixdoors();
                if(getfatigue() >= 95 && !aBoolean870 && loggedin() && mag3 && !pause)
                {
                    while(incomb() && loggedin() && mag3 && !pause)
                        Thread.sleep(500);
                    if(method58(1263) > 0)
                    {
                        Thread.sleep(2000);
                        chat("@red@ST:@whi@ Pmg sleeping!");
                        useitem(1263);
                        Thread.sleep(4000);
                    }
                    else
                    {
                        chat("@red@ST:@whi@ no sleeping bag!");
                        mag3 = false;
                    }
                }
                while((aBoolean870 || pause || !loggedin()) && mag3)
                    Thread.sleep(2000);
                if((maxlvl(3) - currentlvl(3)) > foodheals[foodclickvar] && loggedin() && mag3 && !pause)
                {
                    if(foodid[foodclickvar] == 9999)
                    {
                        if(method58(335) > 0 && !incomb())
                        {
                            Thread.sleep(1000);
                            chat("@red@ST:@whi@ Eating Cake");
                            useitem(335);
                            Thread.sleep(4000);
                        }
                        else if(method58(333) > 0 && !incomb())
                        {
                            Thread.sleep(1000);
                            chat("@red@ST:@whi@ Eating Cake");
                            useitem(333);
                            Thread.sleep(4000);
                        }
                        else if(method58(330) > 0 && !incomb())
                        {
                            Thread.sleep(1000);
                            chat("@red@ST:@whi@ Eating Cake");
                            useitem(330);
                            Thread.sleep(4000);
                        }
                    }
                    else if(method58(foodid[foodclickvar]) > 0 && !incomb())
                    {
                        Thread.sleep(1000);
                        chat("@red@ST:@whi@ Eating " + Class1.aStringArray109[foodid[foodclickvar]]);
                        useitem(foodid[foodclickvar]);
                        Thread.sleep(4000);
                    }
                    else if(currentlvl(3) <= 5 && loggedin() && mag3 && !pause)
                    {
                        chat("@red@ST:@whi@ No food! arghh!!11 i r dying!!1");
                        mag3 = false;
                    }
                }
                while(radius > 0 && !aBoolean870 && loggedin() && mag3 && !pause)
                {
                    int distx = (int)Math.sqrt((startx - getx())*(startx - getx()));
                    int disty = (int)Math.sqrt((starty - gety())*(starty - gety()));
                    if(distx < radius && disty < radius)
                        break;
                    while(incomb() && !aBoolean870 && loggedin() && mag3)
                        Thread.sleep(4000);
                    walkto(startx,starty);
                    Thread.sleep(5000);
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
                reset("Mager");
            }
        }
    }
    magemacro()
    {
        start();
    }
}

public String[] GetSource(String web)throws Exception{
  String[] temp = new String[100];
  URL url = new URL(web);
  URLConnection urlconnection = url.openConnection();
  BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(urlconnection.getInputStream()));
  String t;
  for(int count = 0;(t = bufferedreader.readLine()) != null;count++)
    temp[count] = t;
  return temp;
}



public boolean checkspell(int id)
{
    if(id < 0 || id >= Class1.anInt120)
    {
        chat("@red@ST:@whi@ Invalid spell ID");
        return false;
    }
    else if(Class1.anIntArray98[id] != 2)
    {
        chat("@red@ST:@whi@ This spell cannot be cast on NPC's");
        return false;
    }
    else if(Class1.anIntArray96[id] > anIntArray728[6])
    {
        chat("@red@ST:@whi@ Your magic ability is not high enough for this spell");
        return false;
    }
    for(int k3 = 0;k3 < Class1.anIntArray97[id];k3++)
        if(!method104(Class1.anIntArrayArray99[id][k3],Class1.anIntArrayArray100[id][k3]))
        {
            chat("@red@ST:@whi@ You don't have all the reagents you need for this spell");
            return false;
        }
    return true;
}

public void process(String s)throws Exception
{
    if(s.startsWith("/macro"))
    {
        String temp = s.substring(s.indexOf('(') + 1, s.indexOf(')') + 1);
        for(int a = 0;a < npcid.length;a++)
            npcid[a] = Integer.parseInt(arg(temp,1));
        aut0 = true;
        startx = getx();
        starty = gety();
        macromode = anInt750;
        fmacro = new fightmacro();
        chat("@red@ST:@whi@ NPC's all set to " + Class1.aStringArray127[npcid[0]]);
        switch(macromode)
        {
            case 0:
                chat("@red@ST:@whi@ Macromode set to Controlled");
                break;
            case 1:
                chat("@red@ST:@whi@ Macromode set to Strength");
                break;
            case 2:
                chat("@red@ST:@whi@ Macromode set to Attack");
                break;
            case 3:
                chat("@red@ST:@whi@ Macromode set to Defence");
                break;
        }
        if(radius > 0)
            chat("@red@ST:@whi@ Walkback radius set to " + radius + " and coords noted as ("+ startx +","+ starty +")");
        else
            chat("@red@ST:@whi@ Walkback is off");
        chat("@red@ST:@whi@ Macro turned on with delay set at " + delay);
    }
/*    else if(s.startsWith("/walk"))
    {
        String temp = s.substring(s.indexOf('(') + 1, s.indexOf(')') + 1);
        walksomewhere(arg(temp,1));
    }*/
    else if(s.startsWith("/guild"))
    {
        String temp = s.substring(s.indexOf('(') + 1, s.indexOf(')') + 1);
        if(arg(temp,1).equalsIgnoreCase("lobster"))
        {
            fishing[0][0] = 589; // fish X 1
            fishing[0][1] = 501; // fish Y 1
            fishing[1][0] = 588; // fish X 2
            fishing[1][1] = 500; // fish Y 2
            fishing[0][2] = 1; // certer select
            fishing[0][3] = 589; // walk to X 1
            fishing[0][4] = 502; // walk to Y 1
            fishing[1][3] = 587; // walk to X 2
            fishing[1][4] = 500; // walk to Y 2
            fishing[0][5] = 372; // ID
            fishing[0][6] = 1; // fishing clicks
            fishing[0][7] = 1; // max rand amount
            chat("@red@ST:@whi@ Guildfisher turned on, fishing raw lobsters.");
            for(int a = 0;a < npcid.length;a++)
                npcid[a] = 369;
        }
        else if(arg(temp,2).equalsIgnoreCase("shark"))
        {
            fishing[0][0] = 588; // fish X 1
            fishing[0][1] = 498; // fish Y 1
            fishing[1][0] = 585; // fish X 2
            fishing[1][1] = 498; // fish Y 2
            fishing[2][0] = 585; // fish X 3
            fishing[2][1] = 496; // fish Y 3
            fishing[3][0] = 588; // fish X 4
            fishing[3][1] = 496; // fish Y 4
            fishing[0][2] = 3; // certer select
            fishing[0][3] = 587; // walk to X 1
            fishing[0][4] = 498; // walk to Y 1
            fishing[1][3] = 586; // walk to X 2
            fishing[1][4] = 498; // walk to Y 2
            fishing[2][3] = 586; // walk to X 3
            fishing[2][4] = 496; // walk to Y 3
            fishing[3][3] = 587; // walk to X 4
            fishing[3][4] = 496; // walk to Y 4
            fishing[0][5] = 545; // ID
            fishing[0][6] = 2; // fishing clicks
            fishing[0][7] = 3; // max rand amount
            chat("@red@ST:@whi@ Guildfisher turned on, fishing raw shark.");
            for(int a = 0;a < npcid.length;a++)
                npcid[a] = 370;
        }
        else
        {
            chat("@red@ST:@whi@ Invalid args");
            return;
        }
        f1sh = true;
        fishm = new fishmacro();
    }
    else if(s.startsWith("/mage"))
    {
        String temp = s.substring(s.indexOf('(') + 1, s.indexOf(')') + 1);
        spellid = Integer.parseInt(arg(temp,1));
        if(checkspell(spellid))
        {
            for(int a = 0;a < npcid.length;a++)
                npcid[a] = Integer.parseInt(arg(temp,2));
            mag3 = true;
            startx = getx();
            starty = gety();
            macromode = anInt750;
            mmacro = new magemacro();
            chat("@red@ST:@whi@ NPC's all set to " + Class1.aStringArray127[npcid[0]]);
            switch(macromode)
            {
                case 0:
                    chat("@red@ST:@whi@ Macromode set to Controlled");
                    break;
                case 1:
                    chat("@red@ST:@whi@ Macromode set to Strength");
                    break;
                case 2:
                    chat("@red@ST:@whi@ Macromode set to Attack");
                    break;
                case 3:
                    chat("@red@ST:@whi@ Macromode set to Defence");
                    break;
            }
            if(radius > 0)
                chat("@red@ST:@whi@ Walkback radius set to " + radius + " and coords noted as ("+ startx +","+ starty +")");
            else
                chat("@red@ST:@whi@ Walkback is off");
            chat("@red@ST:@whi@ Mager turned on with delay set at " + delay);
        }
    }
    else if(s.startsWith("/stop"))
    {
        if(aut0)
        {
            aut0 = false;
            chat("@red@ST:@whi@ Macro stopped :(");
        }
        else if(mag3)
        {
            mag3 = false;
            chat("@red@ST:@whi@ Mager stopped :(");
        }
        else if(f1sh)
        {
            f1sh = false;
            chat("@red@ST:@whi@ Guild fisher stopped :(");
        }
        else
            chat("@red@ST:@whi@ Nothing running");
    }
    else if(s.startsWith("/doorlimit"))
    {
        String temp = s.substring(s.indexOf('(') + 1, s.indexOf(')') + 1);
        doorlimit = Integer.parseInt(arg(temp,1));
        if(doorlimit > 0)
            chat("@red@ST:@whi@ Any closed doors within " + doorlimit + " squares of you will be opened. 0 to turn off.");
        else
            chat("@red@ST:@whi@ Door opener turned off");
    }
    else if(s.startsWith("/pickuplimit"))
    {
        String temp = s.substring(s.indexOf('(') + 1, s.indexOf(')') + 1);
        picklimit = Integer.parseInt(arg(temp,1));
        if(picklimit > 0)
            chat("@red@ST:@whi@ Pickup limit set to " + picklimit);
        else
            chat("@red@ST:@whi@ Pickup limit turned off");
    }
    else if(s.startsWith("/walkback"))
    {
        String temp = s.substring(s.indexOf('(') + 1, s.indexOf(')') + 1);
        radius = Integer.parseInt(arg(temp,1));
        startx = getx();
        starty = gety();
        if(radius > 0)
        {
            chat("@red@ST:@whi@ Walkback radius set to " + radius + " squares. To turn off set radius to 0");
            chat("@red@ST:@whi@ coords noted as ("+ startx +","+ starty +")");
        }
        else
            chat("@red@ST:@whi@ Walkback turned off");
    }
    else if(s.startsWith("/npc"))
    {
        if(!aut0 && !mag3)
            chat("@red@ST:@whi@ No macro/mager running");
        else
        {
            String temp = s.substring(s.indexOf('(') + 1, s.indexOf(')') + 1);
            int a = Integer.parseInt(arg(temp,1));
            int id = Integer.parseInt(arg(temp,2));
            if(a > 0 && a < npcid.length)
            {
                npcid[a] = id;
                chat("@red@ST:@whi@ NPC ID " + a + " set to " + Class1.aStringArray127[npcid[a]]);
            }
            else
                chat("@red@ST:@whi@ Can only be 50 different NPC ID's");
        }
    }
    else if(s.startsWith("/delay"))
    {
        String temp = s.substring(s.indexOf('(') + 1, s.indexOf(')') + 1);
        int x = Integer.parseInt(arg(temp,1));
        if(x >= 300 && x <= 10000)
        {
            delay = x;
            chat("@red@ST:@whi@ Macro delay set to " + delay);
        }
        else
            chat("@red@ST:@whi@ Delay must be between 300 and 10000");
    }
    else if(s.startsWith("/mode"))
    {
        String temp = s.substring(s.indexOf('(') + 1, s.indexOf(')') + 1);
        int x = Integer.parseInt(arg(temp,1));
        if(x >= 0 && x < 4)
        {
            setmode(x);
            macromode = x;
        }
        else
            chat("@red@ST:@whi@ Invalid mode");
    }
    else if(s.startsWith("/hop"))
    {
        String temp = s.substring(s.indexOf('(') + 1, s.indexOf(')') + 1);
        String a = arg(temp,1);
        if(a.equalsIgnoreCase("81") || a.equalsIgnoreCase("82") || a.equalsIgnoreCase("83") || a.equalsIgnoreCase("84") || a.equalsIgnoreCase("85") || a.equalsIgnoreCase("86"))
        {
            newworld = Integer.parseInt(a);
            die = new logout();
            changeserver(newworld);
            switching = true;
        }
        else
            chat("@red@ST:@whi@ Invalid server");
    }
    else if(s.startsWith("/reset("))
    {
        String temp = s.substring(s.indexOf('(') + 1, s.indexOf(')') + 1);
        String a = arg(temp,1);
        if(a.equalsIgnoreCase("zoom"))
        {
            yrot = 912;
            zoomvar1 = zoomvar2 = 0;
            anInt683 = 550;
            chat("@red@ST:@whi@ Zoom's all reset to default");
        }
        else if(a.equalsIgnoreCase("macro"))
            reset("Macro");
        else if(a.equalsIgnoreCase("mager"))
            reset("Mager");
        else if(a.equalsIgnoreCase("exp"))
            macroexp = 0;
        else if(a.equalsIgnoreCase("fow"))
            fow = 2500;
    }
}

public int countarg(String s)
{
    int count = 1;
    while(s.indexOf(",") > -1)
    {
        count++;
        s = s.substring(s.indexOf(",")+1);
    }
    return count;
}

public String arg(String s, int pos)
{
    if(pos == 1)
    {
        String temp = s.substring(s.indexOf("(")+1);
        if(temp.indexOf(",") > -1)
            return temp.substring(0,temp.indexOf(","));
        else
            return temp.substring(0,temp.indexOf(")"));
    }
    else if(pos == 2)
    {
        String temp = s.substring(s.indexOf(",")+1);
        if(temp.indexOf(",") > -1)
            return temp.substring(0,temp.indexOf(","));
        else
            return temp.substring(0,temp.indexOf(")"));
    }
    else if(pos >= 3)
    {
        String temp = s.substring(s.indexOf(",")+1);
        for(int a = 2; a < pos; a++ )
            temp = temp.substring(temp.indexOf(",")+1);
        if(temp.indexOf(",") > -1)
            return temp.substring(0,temp.indexOf(","));
        else
            return temp.substring(0,temp.indexOf(")"));
    }
    return null;
}

public int getx()
{
    return anInt976 + anInt783;
}

public int gety()
{
    return anInt977 + anInt784;
}

private class fightmacro extends Thread
{
    public void run()
    {
        while(aut0)
        {
            try
            {
                int i = getnpcindex(true);
	        if(i != -1 && !incomb() && !aBoolean870 && loggedin() && aut0 && !pause && getfatigue() < 95)
	        {
	            attacknpc(i);
                    Thread.sleep((delay + rand(600,700)) / 2);
                    setmode(macromode);
                    Thread.sleep((delay + rand(600,700)) / 2);
                }
                else
                {
                    if(bone[boneclickvar] != 9999 && !incomb() && !aBoolean870 && loggedin() && aut0 && !pause)
                    {
                        int item = getbone();
                        if(item != -1)
                            pickupwait(item);
                        while(!incomb() && !aBoolean870 && loggedin() && aut0 && !pause && getfatigue() < 95 && method58(bone[boneclickvar]) > 0)
                        {
                            useitem(bone[boneclickvar]);
                            Thread.sleep(delay + rand(600,700));
                        }
                    }
                    if(picking && picking && !incomb() && !aBoolean870 && loggedin() && aut0 && !pause)
                    {
                        int item = getitemindex(true);
                        if(item != -1)
                            pickupwait(item);
                    }
                    Thread.sleep(rand(10,20));
                }
                if(doorlimit > 0)
                    fixdoors();
                if(getfatigue() >= 95 && !aBoolean870 && loggedin() && aut0 && !pause)
                {
                    while(incomb() && loggedin() && aut0 && !pause)
                        Thread.sleep(500);
                    if(method58(1263) > 0)
                    {
                        Thread.sleep(2000);
                        chat("@red@ST:@whi@ Pmg sleeping!");
                        useitem(1263);
                        Thread.sleep(4000);
                    }
                    else
                    {
                        chat("@red@ST:@whi@ no sleeping bag!");
                        aut0 = false;
                    }
                }
                while((aBoolean870 || pause || !loggedin()) && aut0)
                    Thread.sleep(2000);
                if((maxlvl(3) - currentlvl(3)) > foodheals[foodclickvar] && loggedin() && aut0 && !pause)
                {
                    while(incomb() && loggedin() && aut0)
                        Thread.sleep(500);
                    if(foodid[foodclickvar] == 9999)
                    {
                        if(method58(335) > 0 && !incomb())
                        {
                            Thread.sleep(1000);
                            chat("@red@ST:@whi@ Eating Cake");
                            useitem(335);
                            Thread.sleep(4000);
                        }
                        else if(method58(333) > 0 && !incomb())
                        {
                            Thread.sleep(1000);
                            chat("@red@ST:@whi@ Eating Cake");
                            useitem(333);
                            Thread.sleep(4000);
                        }
                        else if(method58(330) > 0 && !incomb())
                        {
                            Thread.sleep(1000);
                            chat("@red@ST:@whi@ Eating Cake");
                            useitem(330);
                            Thread.sleep(4000);
                        }
                    }
                    else if(method58(foodid[foodclickvar]) > 0 && !incomb())
                    {
                        Thread.sleep(1000);
                        chat("@red@ST:@whi@ Eating " + Class1.aStringArray109[foodid[foodclickvar]]);
                        useitem(foodid[foodclickvar]);
                        Thread.sleep(4000);
                    }
                    else if((currentlvl(3) / maxlvl(3)) < 0.2 && loggedin() && aut0 && !pause)
                    {
                        chat("@red@ST:@whi@ No food! arghh!!11 i r dying!!1");
                        aut0 = false;
                    }
                }
                while(radius > 0 && !aBoolean870 && loggedin() && aut0 && !pause)
                {
                    int distx = (int)Math.sqrt((startx - getx())*(startx - getx()));
                    int disty = (int)Math.sqrt((starty - gety())*(starty - gety()));
                    if(distx < radius && disty < radius)
                        break;
                    while(incomb() && !aBoolean870 && loggedin() && aut0)
                        Thread.sleep(4000);
                    walkto(startx,starty);
                    Thread.sleep(5000);
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
                reset("Macro");
            }
        }
    }
    fightmacro()
    {
        start();
    }
}

public void changeserver(int x)
{
    System.out.println("Server changed to: " + x);
    server = String.valueOf(x);
    switch(x)
    {
        case 81:
            super.aString616 = "uk1.runescape.com";
            super.anInt617 = 43594;
            aBoolean914 = false;
            break;
        case 82:
            super.aString616 = "uk1.runescape.com";
            super.anInt617 = 43595;
            aBoolean914 = true;
            break;
        case 83:
            super.aString616 = "ul3.runescape.com";
            super.anInt617 = 43594;
            aBoolean914 = false;
            break;
        case 84:
            super.aString616 = "ul3.runescape.com";
            super.anInt617 = 43595;
            aBoolean914 = true;
            break;
        case 85:
            super.aString616 = "cet3.runescape.com";
            super.anInt617 = 43594;
            aBoolean914 = false;
            break;
        case 86:
            super.aString616 = "cet3.runescape.com";
            super.anInt617 = 43595;
            aBoolean914 = true;
            break;
    }
}

public void setmode(int x)
{
    anInt813 = 0;
    anInt750 = x;
    super.aClass14_Sub1_620.method331(74);
    super.aClass14_Sub1_620.method348(anInt750);
    super.aClass14_Sub1_620.method346();
}

public void chat(String msg)
{
    method118("@whi@" + gettime() + " - @red@" + msg, 5);
}

public int getnpcindex(boolean checkcomb)
{
    int minj = -1;
    int min = 9999999;
    for(int j = 0; j < anInt905; j++)
        if(inarray(aClass2Array768[j].anInt151,npcid) && ((aClass2Array768[j].anInt153 != 8 && aClass2Array768[j].anInt153 != 9) || !checkcomb))
        {
            int temp = (int)Math.sqrt((aClass2Array768[j].anInt149 - aClass2_975.anInt149)*(aClass2Array768[j].anInt149 - aClass2_975.anInt149)) + (int)Math.sqrt((aClass2Array768[j].anInt150 - aClass2_975.anInt150)*(aClass2Array768[j].anInt150 - aClass2_975.anInt150));
            if(temp < min)
            {
                minj = j;
                min = temp;
            }
        }
    return minj;
}

public void useitem(int id)
{
    for(int j = 0; j < anIntArray709.length; j++)
        if(anIntArray709[j] == id)
        {
            super.aClass14_Sub1_620.method331(24);
            super.aClass14_Sub1_620.method343(j);
            super.aClass14_Sub1_620.method346();
            return;
        }
}

public void attacknpc(int i)throws Exception
{	
    anIntArray882[0] = 715;
    anIntArray937[0] = aClass2Array768[i].anInt149;
    anIntArray938[0] = aClass2Array768[i].anInt150;
    anIntArray803[0] = aClass2Array768[i].anInt147;
    method93(0);
}

public void castonnpc(int spell, int i)throws Exception
{
    anInt811 = spell;
    anInt764 = -1;
    anIntArray882[20] = 700;
    anIntArray937[20] = aClass2Array768[i].anInt149;
    anIntArray938[20] = aClass2Array768[i].anInt150;
    anIntArray803[20] = aClass2Array768[i].anInt147;
    anIntArray804[20] = anInt811;
    method93(20);
}

public void walkto(int x, int y)throws Exception
{	
    anIntArray882[0] = 920;
    anIntArray937[0] = x - anInt783;
    anIntArray938[0] = y - anInt784;
    method93(0);
}

public int getfatigue()
{
    return (anInt892 * 100) / 750;
}

public int currentlvl(int x)
{
    return anIntArray728[x];
}

public int maxlvl(int x)
{
    return anIntArray825[x];
}

public boolean incomb()
{
    return aClass2_975.anInt153 == 8 || aClass2_975.anInt153 == 9;
}

public void prayeron(int i,boolean on)
{
    super.aClass14_Sub1_620.method331(on ? 202 : 162);
    super.aClass14_Sub1_620.method348(i);
    super.aClass14_Sub1_620.method346();
    aBooleanArray679[i] = on;
    method97(on ? "prayeron" : "prayeroff");
}



    public mudclient()
    {
        super();
        boolean flag = false;
        int i = Class1.anInt144;
        aBooleanArray662 = new boolean[1500];
        anIntArray664 = new int[8];
        anIntArray665 = new int[8];
        aBoolean666 = false;
        aBoolean668 = false;
        aBoolean669 = false;
        aBoolean673 = false;
        aBoolean674 = false;
        aBoolean675 = true;
        anInt676 = 512;
        anInt677 = 334;
        anInt678 = 9;
        aBooleanArray679 = new boolean[50];
        aBoolean680 = false;
        aString681 = "";
        aString682 = "";
        anInt683 = 550;
        anIntArray686 = new int[99];
        anIntArray687 = new int[50];
        anIntArray688 = new int[50];
        anIntArray689 = new int[50];
        anIntArray692 = new int[14];
        anIntArray693 = new int[14];
        anInt707 = 30;
        anIntArray709 = new int[35];
        anIntArray710 = new int[35];
        anIntArray711 = new int[35];
        anIntArray712 = new int[18];
        aBooleanArray716 = new boolean[50];
        aBoolean717 = false;
        aBoolean718 = false;
        aBoolean719 = false;
        aBoolean720 = false;
        aBoolean721 = false;
        anIntArray722 = new int[50];
        anIntArray723 = new int[50];
        aBoolean727 = false;
        anIntArray728 = new int[18];
        anInt729 = 128;
        anIntArray730 = new int[50];
        aString734 = "";
        aString735 = "";
        anIntArray736 = new int[256];
        anIntArray737 = new int[256];
        anIntArray738 = new int[256];
        anIntArray740 = new int[500];
        anIntArray741 = new int[500];
        aBoolean745 = false;
        anIntArray747 = new int[500];
        anIntArray748 = new int[500];
        aBoolean757 = false;
        anIntArray758 = new int[50];
        anIntArray759 = new int[50];
        anIntArray760 = new int[1500];
        anIntArray761 = new int[1500];
        anIntArray762 = new int[1500];
        anIntArray763 = new int[1500];
        anInt764 = -1;
        aString765 = "";
        aBoolean767 = false;
        aClass2Array768 = new Class2[500];
        aStringArray769 = new String[250];
        anIntArray770 = new int[5000];
        anIntArray771 = new int[5000];
        anIntArray772 = new int[5000];
        anIntArray773 = new int[5000];
        aStringArray774 = new String[5];
        aClass5Array781 = new Class5[500];
        anInt785 = -1;
        anIntArray787 = new int[8];
        anIntArray788 = new int[8];
        aBoolean789 = false;
        aString794 = "";
        anIntArray797 = new int[5];
        aBoolean801 = false;
        aBoolean802 = false;
        anIntArray803 = new int[250];
        anIntArray804 = new int[250];
        anIntArray805 = new int[250];
        anInt809 = -1;
        aBoolean810 = false;
        anInt811 = -1;
        aClass5Array814 = new Class5[1500];
        anIntArray815 = new int[500];
        anIntArray816 = new int[256];
        anIntArray817 = new int[256];
        aStringArray821 = new String[50];
        aClass2Array822 = new Class2[500];
        aString824 = "";
        anIntArray825 = new int[18];
        aBooleanArray831 = new boolean[500];
        anInt834 = -1;
        anInt835 = -2;
        anIntArray837 = new int[14];
        anIntArray838 = new int[14];
        aString848 = "";
        aBoolean849 = false;
        aBoolean852 = false;
        aBoolean853 = false;
        aBoolean854 = false;
        aBoolean856 = false;
        aString861 = "";
        aString862 = "";
        aBoolean870 = false;
        anInt872 = 1;
        anInt873 = 2;
        anInt874 = 2;
        anInt875 = 8;
        anInt876 = 14;
        anInt878 = 1;
        aBoolean879 = false;
        aBoolean880 = true;
        anIntArray881 = new int[50];
        anIntArray882 = new int[250];
        anIntArray887 = new int[14];
        anIntArray888 = new int[14];
        aBoolean890 = false;
        aClass2Array891 = new Class2[4000];
        anInt896 = 2;
        anInt897 = 40;
        anInt903 = -1;
        anInt904 = -2;
        aBoolean908 = false;
        anIntArray911 = new int[8];
        anIntArray912 = new int[8];
        aStringArray913 = new String[5];
        aBoolean914 = true;
        anInt916 = 48;
        aBoolean917 = false;
        anInt919 = -1;
        anInt920 = -1;
        anInt921 = -1;
        aBoolean922 = false;
        aClass2Array923 = new Class2[500];
        anIntArray934 = new int[50];
        anIntArray935 = new int[5];
        anIntArray937 = new int[250];
        anIntArray938 = new int[250];
        anInt940 = 1;
        aBoolean944 = false;
        aBoolean945 = false;
        anInt946 = 128;
        anIntArray955 = new int[256];
        anIntArray956 = new int[256];
        aClass2Array957 = new Class2[5000];
        anIntArray960 = new int[8];
        anIntArray961 = new int[8];
        anIntArray962 = new int[8000];
        anIntArray963 = new int[8000];
        anIntArray965 = new int[50];
        anIntArray966 = new int[50];
        anIntArray967 = new int[50];
        anIntArray968 = new int[50];
        anIntArray970 = new int[14];
        anIntArray971 = new int[14];
        anIntArray972 = new int[50];
        anInt974 = 2;	
	boolean cc = true;
        long dc;
        String ac;
        byte Zb[];
        aClass2_975 = new Class2();
        anInt978 = -1;
        aBoolean979 = true;
        anIntArray981 = new int[8192];
        anIntArray982 = new int[8192];
        aClass2Array983 = new Class2[500];
        anIntArray984 = new int[250];
        aStringArray985 = new String[250];
        aBoolean992 = false;
        aClass5Array994 = new Class5[1000];
        anInt995 = 0xbc614e;
        System.out.println("Based on deobed mudclient 198, deobed by Kaitnieks <3");
    }

public final URL getDocumentBase()
{
try
{
return new URL("http://www.runescape.com");
}
catch(Exception e) {return null;}
}

    public final Image createImage(int i, int j)
    {
        if(Applet_Sub1.aFrame_Sub1_7 != null)
            return Applet_Sub1.aFrame_Sub1_7.createImage(i, j);
        if(Class8.anApplet370 != null)
            return Class8.anApplet370.createImage(i, j);
        else
            return super.createImage(i, j);
    }

public final URL getCodeBase()
{
try
{
return new URL("http://" + super.aString616 + "/client2/");
}
catch(Exception e) {return null;}
}

    public final Graphics getGraphics()
    {
        if(Applet_Sub1.aFrame_Sub1_7 != null)
            return Applet_Sub1.aFrame_Sub1_7.getGraphics();
        if(Class8.anApplet370 != null)
            return Class8.anApplet370.getGraphics();
        else
            return super.getGraphics();
    }

    public final String getParameter(String s)
    {
        if(Class8.anApplet370 != null)
            return Class8.anApplet370.getParameter(s);
        else
            return super.getParameter(s);
    }


    protected final void method1()
    {
        if(aBoolean979)
        {
            String s = getDocumentBase().getHost().toLowerCase();
            //if(!s.endsWith("jagex.com") && !s.endsWith("jagex.co.uk") && !s.endsWith("runescape.com") && !s.endsWith("runescape.co.uk") && !s.endsWith("runescape.net") && !s.endsWith("runescape.org") && !s.endsWith("penguin") && !s.endsWith("puffin"))
            //{
            //    aBoolean666 = true;
            //    return;
            //}
        }
        int i = 0;
        for(int j = 0; j < 99; j++)
        {
            int k = j + 1;
            int i1 = (int)((double)k + 300D * Math.pow(2D, (double)k / 7D));
            i += i1;
            anIntArray686[j] = i & 0xffffffc;
        }

        try
        {
            String s1 = getParameter("referid");
            anInt731 = 0;
        }
        catch(Exception _ex) { }
        try
        {
            String s2 = getParameter("member");
            int j1 = 0;
            if(j1 == 1)
                aBoolean914 = true;
        }
        catch(Exception _ex) { }
        if(aBoolean979)
            super.anInt617 = 43594;
        super.anInt11 = 0;
        Applet_Sub1_Sub1.anInt615 = 1000;
        Applet_Sub1_Sub1.anInt614 = Class18.anInt573;
        try
        {
            String s3 = getParameter("poff");
            int k1 = 0;
            super.anInt617 += k1;
            System.out.println("Offset: " + k1);
        }
        catch(Exception _ex) { }
        method73();
        if(aBoolean922)
            return;
        anInt948 = 2000;
        anInt949 = anInt948 + 100;
        anInt950 = anInt949 + 50;
        anInt954 = anInt950 + 1000;
        anInt951 = anInt954 + 10;
        anInt952 = anInt951 + 50;
        anInt953 = anInt952 + 10;
        aGraphics857 = getGraphics();
        method8(50);
        aClass6_Sub1_724 = new Class6_Sub1(anInt676, anInt677 + 12, 4000, this);
        aClass6_Sub1_724.aMudclient641 = this;
        aClass6_Sub1_724.method209(0, 0, anInt676, anInt677 + 12);
        Class4.aBoolean220 = false;
        Class4.anInt221 = anInt949;
        aClass4_798 = new Class4(aClass6_Sub1_724, 5);
        int l = ((Class6) (aClass6_Sub1_724)).anInt311 - 199;
        byte byte0 = 36;
        anInt799 = aClass4_798.method163(l, byte0 + 24, 196, 90, 1, 500, true);
        aClass4_925 = new Class4(aClass6_Sub1_724, 5);
        anInt926 = aClass4_925.method163(l, byte0 + 40, 196, 126, 1, 500, true);
        aClass4_826 = new Class4(aClass6_Sub1_724, 5);
        anInt827 = aClass4_826.method163(l, byte0 + 24, 196, 251, 1, 500, true);
        method121();
        if(aBoolean922)
            return;
        method86();
        if(aBoolean922)
            return;
        aClass10_739 = new Class10(aClass6_Sub1_724, 15000, 15000, 1000);
        aClass10_739.method281(anInt676 / 2, anInt677 / 2, anInt676 / 2, anInt677 / 2, anInt676, anInt678);
        aClass10_739.anInt390 = 2400;
        aClass10_739.anInt391 = 2400;
        aClass10_739.anInt392 = 1;
        aClass10_739.anInt393 = 2300;
        aClass10_739.method309(-50, -10, -50);
        aClass19_883 = new Class19(aClass10_739, aClass6_Sub1_724);
        aClass19_883.anInt589 = anInt948;
        method113();
        if(aBoolean922)
            return;
        method64();
        if(aBoolean922)
            return;
        method95();
        if(aBoolean922)
            return;
        if(aBoolean914)
            method102();
        if(aBoolean922)
        {
            return;
        } else
        {
                    try{settings();}
            catch(Exception e){System.out.println(e);}
            method15(100, "Starting game...");
            method94();
            method52();
            method59();
            method50();
            method5();
            method77();
            return;
        }
    }
    private int anInt731;
    protected final void method10(int i)
    {
        if(i == 1009)
            showcomb = !showcomb;
            if(i == 1019)
            autoLogin = !autoLogin;
        if(i == 1010)
            if(aut0)
            {
                pause = !pause;
                if(pause)
                    chat("@red@ST:@whi@ Macro paused");
                else
                    chat("@red@ST:@whi@ Macro resumed");
            }
            else if(mag3)
            {
                pause = !pause;
                if(pause)
                    chat("@red@ST:@whi@ Mager paused");
                else
                    chat("@red@ST:@whi@ Mager resumed");
            }
            else
                chat("@red@ST:@whi@ Nothing running");
        if(i == 1011)
        {
            gfx = !gfx;
            if(gfx)
                chat("@red@ST:@whi@ GFX turned back on");
            else
                chat("@red@ST:@whi@ GFX turned off");
        }
        if(i == 1015)
        {
            if(fow != 50000)
            {
                chat("@red@ST:@whi@ FOW off");
                fow = 50000;
            }
            else
            {
                chat("@red@ST:@whi@ FOW on");
                fow = 2500;
            }
        }
        if(i == 1016)
        {
            screenie();
            chat("@red@ST:@whi@ Screenshot saved");
        }
        if(i == 1017)
        {
            if(foodid[foodclickvar] == 9999)
            {
                if(method58(335) > 0)
                    useitem(335);
                else if(method58(333) > 0)
                    useitem(333);
                else if(method58(330) > 0)
                    useitem(330);
                else
                    chat("@red@ST:@whi@ No Cake left!");
            }
            else if(method58(foodid[foodclickvar]) > 0)
                useitem(foodid[foodclickvar]);
            else
                chat("@red@ST:@whi@ No " + Class1.aStringArray109[foodid[foodclickvar]] + " left!");
        }
        if(i == 1018)
            if(aBooleanArray679[10] || aBooleanArray679[11])
            {
                prayeron(10,false);
                prayeron(11,false);
                chat("@red@ST:@whi@ Prayers turned off");
            }
            else if(currentlvl(5) < 1)
                chat("@red@ST:@whi@ You have no prayer!");
            else if(prayclickvar != 0 && maxlvl(5) < Class1.anIntArray88[11])
                chat("@red@ST:@whi@ Your prayer is too low dumass");
            else if(maxlvl(5) < Class1.anIntArray88[10])
                chat("@red@ST:@whi@ Your prayer is too low dumass");
            else
            {
                if(prayclickvar != 1)
                    prayeron(10,true);
                if(prayclickvar != 0)
                    prayeron(11,true);
                chat("@red@ST:@whi@ Prayers turned on");
            }
        if(anInt947 == 0)
        {
            if(anInt690 == 0)
                aClass4_858.method141(i);
            if(anInt690 == 1)
                aClass4_667.method141(i);
            if(anInt690 == 2)
                aClass4_751.method141(i);
        }
        if(anInt947 == 1)
        {
            if(aBoolean992)
            {
                aClass4_830.method141(i);
                return;
            }
            if(anInt931 == 0 && anInt986 == 0 && !aBoolean870)
                aClass4_775.method141(i);
        }
    }

    private final void method100()
    {
        int l = Class1.anInt144;
        byte byte0 = 22;
        byte byte1 = 36;
        aClass6_Sub1_724.method216(byte0, byte1, 468, 16, 192);
        int i = 0x989898;
        aClass6_Sub1_724.method214(byte0, byte1 + 16, 468, 246, i, 160);
        aClass6_Sub1_724.method255("Please confirm your duel with @yel@" + Class15.method363(aLong907), byte0 + 234, byte1 + 12, 1, 0xffffff);
        aClass6_Sub1_724.method255("Your stake:", byte0 + 117, byte1 + 30, 1, 0xffff00);
        for(int j = 0; j < anInt663; j++)
        {
            String s = Class1.aStringArray109[anIntArray664[j]];
            if(Class1.anIntArray55[anIntArray664[j]] == 0)
                s = s + " x " + method48(anIntArray665[j]);
            aClass6_Sub1_724.method255(s, byte0 + 117, byte1 + 42 + j * 12, 1, 0xffffff);
        }
        if(anInt663 == 0)
            aClass6_Sub1_724.method255("Nothing!", byte0 + 117, byte1 + 42, 1, 0xffffff);
        aClass6_Sub1_724.method255("Your opponent's stake:", byte0 + 351, byte1 + 30, 1, 0xffff00);
        for(int k = 0; k < anInt786; k++)
        {
            String s1 = Class1.aStringArray109[anIntArray787[k]];
            if(Class1.anIntArray55[anIntArray787[k]] == 0)
                s1 = s1 + " x " + method48(anIntArray788[k]);
            aClass6_Sub1_724.method255(s1, byte0 + 351, byte1 + 42 + k * 12, 1, 0xffffff);
        }
        if(anInt786 == 0)
            aClass6_Sub1_724.method255("Nothing!", byte0 + 351, byte1 + 42, 1, 0xffffff);
        if(anInt988 == 0)
            aClass6_Sub1_724.method255("You can retreat from this duel", byte0 + 234, byte1 + 180, 1, 65280);
        else
            aClass6_Sub1_724.method255("No retreat is possible!", byte0 + 234, byte1 + 180, 1, 0xff0000);
        if(anInt989 == 0)
            aClass6_Sub1_724.method255("Magic may be used", byte0 + 234, byte1 + 192, 1, 65280);
        else
            aClass6_Sub1_724.method255("Magic cannot be used", byte0 + 234, byte1 + 192, 1, 0xff0000);
        if(anInt990 == 0)
            aClass6_Sub1_724.method255("Prayer may be used", byte0 + 234, byte1 + 204, 1, 65280);
        else
            aClass6_Sub1_724.method255("Prayer cannot be used", byte0 + 234, byte1 + 204, 1, 0xff0000);
        if(anInt991 == 0)
            aClass6_Sub1_724.method255("Weapons may be used", byte0 + 234, byte1 + 216, 1, 65280);
        else
            aClass6_Sub1_724.method255("Weapons cannot be used", byte0 + 234, byte1 + 216, 1, 0xff0000);
        aClass6_Sub1_724.method255("If you are sure click 'Accept' to begin the duel", byte0 + 234, byte1 + 230, 1, 0xffffff);
        if(!aBoolean802)
        {
            aClass6_Sub1_724.method231((byte0 + 118) - 35, byte1 + 238, anInt948 + 25);
            aClass6_Sub1_724.method231((byte0 + 352) - 35, byte1 + 238, anInt948 + 26);
        }
        else
        {
            aClass6_Sub1_724.method255("Waiting for other player...", byte0 + 234, byte1 + 250, 1, 0xffff00);
        }
        if(anInt813 == 1)
        {
            if(super.anInt33 < byte0 || super.anInt34 < byte1 || super.anInt33 > byte0 + 468 || super.anInt34 > byte1 + 262)
            {
                aBoolean801 = false;
                super.aClass14_Sub1_620.method331(27);
                super.aClass14_Sub1_620.method346();
            }
            if(super.anInt33 >= (byte0 + 118) - 35 && super.anInt33 <= byte0 + 118 + 70 && super.anInt34 >= byte1 + 238 && super.anInt34 <= byte1 + 238 + 21)
            {
                aBoolean802 = true;
                super.aClass14_Sub1_620.method331(102);
                super.aClass14_Sub1_620.method346();
            }
            if(super.anInt33 >= (byte0 + 352) - 35 && super.anInt33 <= byte0 + 353 + 70 && super.anInt34 >= byte1 + 238 && super.anInt34 <= byte1 + 238 + 21)
            {
                aBoolean801 = false;
                super.aClass14_Sub1_620.method331(27);
                super.aClass14_Sub1_620.method346();
            }
            anInt813 = 0;
        }
    }

    private final void method101()
    {
        int j5 = Class1.anInt144;
        for(int i = 0; i < anInt820; i++)
        {
            int j = aClass6_Sub1_724.method261(1);
            int l = anIntArray965[i];
            int k1 = anIntArray966[i];
            int j2 = anIntArray967[i];
            int i3 = anIntArray968[i];
            boolean flag = true;
            while(flag) 
            {
                flag = false;
                for(int i4 = 0; i4 < i; i4++)
                    if(k1 + i3 > anIntArray966[i4] - j && k1 - j < anIntArray966[i4] + anIntArray968[i4] && l - j2 < anIntArray965[i4] + anIntArray967[i4] && l + j2 > anIntArray965[i4] - anIntArray967[i4] && anIntArray966[i4] - j - i3 < k1)
                    {
                        k1 = anIntArray966[i4] - j - i3;
                        flag = true;
                    }
            }
            anIntArray966[i] = k1;
            aClass6_Sub1_724.method256(aStringArray821[i], l, k1, 1, 0xffff00, 300);
        }
        for(int k = 0; k < anInt958; k++)
        {
            int i1 = anIntArray758[k];
            int l1 = anIntArray759[k];
            int k2 = anIntArray722[k];
            int j3 = anIntArray723[k];
            int l3 = (39 * k2) / 100;
            int j4 = (27 * k2) / 100;
            int k4 = l1 - j4;
            aClass6_Sub1_724.method234(i1 - l3 / 2, k4, l3, j4, anInt948 + 9, 85);
            int l4 = (36 * k2) / 100;
            int i5 = (24 * k2) / 100;
            aClass6_Sub1_724.method247(i1 - l4 / 2, (k4 + j4 / 2) - i5 / 2, l4, i5, Class1.anIntArray53[j3] + anInt950, Class1.anIntArray58[j3], 0, 0, false);
        }
        for(int j1 = 0; j1 < anInt766; j1++)
        {
            int i2 = anIntArray687[j1];
            int l2 = anIntArray688[j1];
            int k3 = anIntArray689[j1];
            aClass6_Sub1_724.method214(i2 - 15, l2 - 3, k3, 5, 65280, 192);
            aClass6_Sub1_724.method214((i2 - 15) + k3, l2 - 3, 30 - k3, 5, 0xff0000, 192);
        }
    }

    private final void method102()
    {
        try
        {
            aByteArray987 = method18("sounds" + Class18.anInt580 + ".mem", "Sound effects", 90);
            anInputStream_Sub1_901 = new InputStream_Sub1();
            return;
        }
        catch(Throwable throwable)
        {
            System.out.println("Unable to init sounds:" + throwable);
        }
    }

    private final void method103(boolean flag)
    {
        int l8 = Class1.anInt144;
        int i = ((Class6) (aClass6_Sub1_724)).anInt311 - 199;
        char c = '\234';
        char c2 = '\230';
        aClass6_Sub1_724.method231(i - 49, 3, anInt948 + 2);
        i += 40;
        aClass6_Sub1_724.method216(i, 36, c, c2, 0);
        aClass6_Sub1_724.method209(i, 36, i + c, 36 + c2);
        int k = 192 + anInt860;
        int i1 = anInt729 + anInt859 & 0xff;
        int k1 = ((aClass2_975.anInt149 - 6040) * 3 * k) / 2048;
        int i3 = ((aClass2_975.anInt150 - 6040) * 3 * k) / 2048;
        int k4 = Class10.anIntArray394[1024 - i1 * 4 & 0x3ff];
        int i5 = Class10.anIntArray394[(1024 - i1 * 4 & 0x3ff) + 1024];
        int k5 = i3 * k4 + k1 * i5 >> 18;
        i3 = i3 * i5 - k1 * k4 >> 18;
        k1 = k5;
        aClass6_Sub1_724.method243((i + c / 2) - k1, 36 + c2 / 2 + i3, anInt948 - 1, i1 + 64 & 0xff, k);
        for(int i7 = 0; i7 < anInt796; i7++)
        {
            int l1 = (((anIntArray760[i7] * anInt946 + 64) - aClass2_975.anInt149) * 3 * k) / 2048;
            int j3 = (((anIntArray761[i7] * anInt946 + 64) - aClass2_975.anInt150) * 3 * k) / 2048;
            int l5 = j3 * k4 + l1 * i5 >> 18;
            j3 = j3 * i5 - l1 * k4 >> 18;
            l1 = l5;
            method74(i + c / 2 + l1, (36 + c2 / 2) - j3, 65535);
        }
        for(int j7 = 0; j7 < anInt823; j7++)
        {
            int i2 = (((anIntArray770[j7] * anInt946 + 64) - aClass2_975.anInt149) * 3 * k) / 2048;
            int k3 = (((anIntArray771[j7] * anInt946 + 64) - aClass2_975.anInt150) * 3 * k) / 2048;
            int i6 = k3 * k4 + i2 * i5 >> 18;
            k3 = k3 * i5 - i2 * k4 >> 18;
            i2 = i6;
            int col;
            if(wildlvl() > 0)
                col = 255;
            else
                col = 0xff0000;
            method74(i + c / 2 + i2, (36 + c2 / 2) - k3, col);
        }
        for(int k7 = 0; k7 < anInt905; k7++)
        {
            Class2 class2 = aClass2Array768[k7];
            int j2 = ((class2.anInt149 - aClass2_975.anInt149) * 3 * k) / 2048;
            int l3 = ((class2.anInt150 - aClass2_975.anInt150) * 3 * k) / 2048;
            int j6 = l3 * k4 + j2 * i5 >> 18;
            l3 = l3 * i5 - j2 * k4 >> 18;
            j2 = j6;
            method74(i + c / 2 + j2, (36 + c2 / 2) - l3, 0xffff00);
        }
        for(int l7 = 0; l7 < anInt742; l7++)
        {
            Class2 class2_1 = aClass2Array983[l7];
            int k2 = ((class2_1.anInt149 - aClass2_975.anInt149) * 3 * k) / 2048;
            int i4 = ((class2_1.anInt150 - aClass2_975.anInt150) * 3 * k) / 2048;
            int k6 = i4 * k4 + k2 * i5 >> 18;
            i4 = i4 * i5 - k2 * k4 >> 18;
            k2 = k6;
            int j8 = 0xffffff;
            if(canattack(l7))
            {
                int k3 = aClass2_975.anInt168 - aClass2Array983[l7].anInt168;
                if(k3 == 0)
                    j8 = 0x8000ff;
                if(k3 < 0)
                    j8 = 0xffb000;
                if(k3 < -3)
                    j8 = 0xff7000;
                if(k3 < -6)
                    j8 = 0xff3000;
                if(k3 < -9)
                    j8 = 0xff0000;
                if(k3 > 0)
                    j8 = 0xc0ff00;
                if(k3 > 3)
                    j8 = 0x80ff00;
                if(k3 > 6)
                    j8 = 0x40ff00;
                if(k3 > 9)
                    j8 = 65280;
            }
            for(int k8 = 0; k8 < super.anInt624; k8++)
            {
                if(class2_1.aLong145 != super.aLongArray625[k8] || super.anIntArray626[k8] != 99)
                    continue;
                j8 = (int)(Math.random() * 16777215D);
                break;
            }
            method74(i + c / 2 + k2, (36 + c2 / 2) - i4, j8);
        }
        aClass6_Sub1_724.method213(i + c / 2, 36 + c2 / 2, 2, 0xffffff, 255);
        aClass6_Sub1_724.method243(i + 19, 55, anInt948 + 24, anInt729 + 128 & 0xff, 128);
        aClass6_Sub1_724.method209(0, 0, anInt676, anInt677 + 12);
        if(!flag)
            return;
        i = super.anInt33 - (((Class6) (aClass6_Sub1_724)).anInt311 - 199);
        int i8 = super.anInt34 - 36;
        if(i >= 40 && i8 >= 0 && i < 196 && i8 < 152)
        {
            char c1 = '\234';
            char c3 = '\230';
            int l = 192 + anInt860;
            int j1 = anInt729 + anInt859 & 0xff;
            int j = ((Class6) (aClass6_Sub1_724)).anInt311 - 199;
            j += 40;
            int l2 = ((super.anInt33 - (j + c1 / 2)) * 16384) / (3 * l);
            int j4 = ((super.anInt34 - (36 + c3 / 2)) * 16384) / (3 * l);
            int l4 = Class10.anIntArray394[1024 - j1 * 4 & 0x3ff];
            int j5 = Class10.anIntArray394[(1024 - j1 * 4 & 0x3ff) + 1024];
            int l6 = j4 * l4 + l2 * j5 >> 15;
            j4 = j4 * j5 - l2 * l4 >> 15;
            l2 = l6;
            l2 += aClass2_975.anInt149;
            j4 = aClass2_975.anInt150 - j4;
            if(anInt813 == 1)
                method99(anInt976, anInt977, l2 / 128, j4 / 128, false);
            anInt813 = 0;
        }
    }

    private final boolean method104(int i, int j)
    {
        if(i == 31 && (method79(197) || method79(615) || method79(682)))
            return true;
        if(i == 32 && (method79(102) || method79(616) || method79(683)))
            return true;
        if(i == 33 && (method79(101) || method79(617) || method79(684)))
            return true;
        if(i == 34 && (method79(103) || method79(618) || method79(685)))
            return true;
        return method58(i) >= j;
    }

    private final void method105(int i, int j, int k, int l)
    {
        int i1;
        int j1;
        if(k == 0 || k == 4)
        {
            i1 = Class1.anIntArray63[l];
            j1 = Class1.anIntArray64[l];
        } else
        {
            j1 = Class1.anIntArray63[l];
            i1 = Class1.anIntArray64[l];
        }
        if(Class1.anIntArray65[l] == 2 || Class1.anIntArray65[l] == 3)
        {
            if(k == 0)
            {
                i--;
                i1++;
            }
            if(k == 2)
                j1++;
            if(k == 4)
                i1++;
            if(k == 6)
            {
                j--;
                j1++;
            }
            method83(anInt976, anInt977, i, j, (i + i1) - 1, (j + j1) - 1, false, true);
            return;
        } else
        {
            method83(anInt976, anInt977, i, j, (i + i1) - 1, (j + j1) - 1, true, true);
            return;
        }
    }

    private final Class5 method106(int i, int j, int k, int l, int i1)
    {
        int j1 = i;
        int k1 = j;
        int l1 = i;
        int i2 = j;
        int j2 = Class1.anIntArray79[l];
        int k2 = Class1.anIntArray80[l];
        int l2 = Class1.anIntArray78[l];
        Class5 class5 = new Class5(4, 1);
        if(k == 0)
            l1 = i + 1;
        if(k == 1)
            i2 = j + 1;
        if(k == 2)
        {
            j1 = i + 1;
            i2 = j + 1;
        }
        if(k == 3)
        {
            l1 = i + 1;
            i2 = j + 1;
        }
        j1 *= anInt946;
        k1 *= anInt946;
        l1 *= anInt946;
        i2 *= anInt946;
        int i3 = class5.method180(j1, -aClass19_883.method421(j1, k1), k1);
        int j3 = class5.method180(j1, -aClass19_883.method421(j1, k1) - l2, k1);
        int k3 = class5.method180(l1, -aClass19_883.method421(l1, i2) - l2, i2);
        int l3 = class5.method180(l1, -aClass19_883.method421(l1, i2), i2);
        int ai[] = {
            i3, j3, k3, l3
        };
        class5.method182(4, ai, j2, k2);
        class5.method185(false, 60, 24, -50, -10, -50);
        if(i >= 0 && j >= 0 && i < 96 && j < 96)
            aClass10_739.method269(class5);
        class5.anInt257 = i1 + 10000;
        return class5;
    }

    private final Class2 method107(int i, int j, int k, int l, int i1)
    {
        int l1 = Class1.anInt144;
        if(aClass2Array957[i] == null)
        {
            aClass2Array957[i] = new Class2();
            aClass2Array957[i].anInt147 = i;
        }
        Class2 class2 = aClass2Array957[i];
        boolean flag = false;
        for(int j1 = 0; j1 < anInt906; j1++)
        {
            if(aClass2Array822[j1].anInt147 != i)
                continue;
            flag = true;
            break;
        }

        if(flag)
        {
            class2.anInt151 = i1;
            class2.anInt154 = l;
            int k1 = class2.anInt156;
            if(j != class2.anIntArray157[k1] || k != class2.anIntArray158[k1])
            {
                class2.anInt156 = k1 = (k1 + 1) % 10;
                class2.anIntArray157[k1] = j;
                class2.anIntArray158[k1] = k;
            }
        } else
        {
            class2.anInt147 = i;
            class2.anInt155 = 0;
            class2.anInt156 = 0;
            class2.anIntArray157[0] = class2.anInt149 = j;
            class2.anIntArray158[0] = class2.anInt150 = k;
            class2.anInt151 = i1;
            class2.anInt154 = class2.anInt153 = l;
            class2.anInt152 = 0;
        }
        aClass2Array768[anInt905++] = class2;
        return class2;
    }

    private final void method108()
    {
        int l10 = Class1.anInt144;
        if(anInt993 != 0)
        {
            aClass6_Sub1_724.method221();
            aClass6_Sub1_724.method255("HAHA PWNT!!!!1", anInt676 / 2, anInt677 / 2, 7, 0xff0000);
            method69();
            aClass6_Sub1_724.method211(aGraphics857, 0, 0);
            return;
        }
        if(aBoolean992)
        {
            method61();
            return;
        }
        if(aBoolean870)
        {
            aClass6_Sub1_724.method221();
            aClass6_Sub1_724.method216(anInt676 / 2 - 100, 136, 200, 40, 0);
            aClass6_Sub1_724.method255("You are sleeping", anInt676 / 2, 26, 7, 0xffff00);
            aClass6_Sub1_724.method255("Fatigue: " + (anInt893 * 100) / 750 + "%", anInt676 / 2, 66, 7, 0xffff00);
            aClass6_Sub1_724.method255("When you want to wake up just use your", anInt676 / 2, 116, 5, 0xffffff);
            aClass6_Sub1_724.method255("keyboard to type the word in the box below", anInt676 / 2, 136, 5, 0xffffff);
            aClass6_Sub1_724.method255(super.aString40 + "*", anInt676 / 2, 156, 5, 65535);
            if(aString846 == null)
                aClass6_Sub1_724.method231(anInt676 / 2 - 127, 206, anInt952 + 1);
            else
                aClass6_Sub1_724.method255(aString846, anInt676 / 2, 236, 5, 0xff0000);
            aClass6_Sub1_724.method217(anInt676 / 2 - 128, 205, 257, 42, 0xffffff);
            method69();
            aClass6_Sub1_724.method255("If you can't read the word", anInt676 / 2, 266, 1, 0xffffff);
            aClass6_Sub1_724.method255("@yel@click here@whi@ to get a different one", anInt676 / 2, 281, 1, 0xffffff);
            aClass6_Sub1_724.method211(aGraphics857, 0, 0);
            CheckWords();
            return;
        }
        if(!aClass19_883.aBoolean609)
            return;
        for(int i = 0; i < 64; i++)
        {
            aClass10_739.method270(aClass19_883.aClass5ArrayArray603[anInt809][i]);
            if(anInt809 == 0)
            {
                aClass10_739.method270(aClass19_883.aClass5ArrayArray605[1][i]);
                aClass10_739.method270(aClass19_883.aClass5ArrayArray603[1][i]);
                aClass10_739.method270(aClass19_883.aClass5ArrayArray605[2][i]);
                aClass10_739.method270(aClass19_883.aClass5ArrayArray603[2][i]);
            }
            aBoolean789 = true;
            if(anInt809 == 0 && (aClass19_883.anIntArrayArray608[aClass2_975.anInt149 / 128][aClass2_975.anInt150 / 128] & 0x80) == 0)
            {
                aClass10_739.method269(aClass19_883.aClass5ArrayArray603[anInt809][i]);
                if(anInt809 == 0)
                {
                    aClass10_739.method269(aClass19_883.aClass5ArrayArray605[1][i]);
                    aClass10_739.method269(aClass19_883.aClass5ArrayArray603[1][i]);
                    aClass10_739.method269(aClass19_883.aClass5ArrayArray605[2][i]);
                    aClass10_739.method269(aClass19_883.aClass5ArrayArray603[2][i]);
                }
                aBoolean789 = false;
            }
        }
        if(anInt839 != anInt919)
        {
            anInt919 = anInt839;
            for(int j = 0; j < anInt796; j++)
            {
                if(anIntArray762[j] == 97)
                    method89(j, "firea" + (anInt839 + 1));
                if(anIntArray762[j] == 274)
                    method89(j, "fireplacea" + (anInt839 + 1));
                if(anIntArray762[j] == 1031)
                    method89(j, "lightning" + (anInt839 + 1));
                if(anIntArray762[j] == 1036)
                    method89(j, "firespell" + (anInt839 + 1));
                if(anIntArray762[j] == 1147)
                    method89(j, "spellcharge" + (anInt839 + 1));
            }
        }
        if(anInt840 != anInt920)
        {
            anInt920 = anInt840;
            for(int k = 0; k < anInt796; k++)
            {
                if(anIntArray762[k] == 51)
                    method89(k, "torcha" + (anInt840 + 1));
                if(anIntArray762[k] == 143)
                    method89(k, "skulltorcha" + (anInt840 + 1));
            }
        }
        if(anInt841 != anInt921)
        {
            anInt921 = anInt841;
            for(int l = 0; l < anInt796; l++)
                if(anIntArray762[l] == 1142)
                    method89(l, "clawspell" + (anInt841 + 1));
        }
        aClass10_739.method273(anInt744);
        anInt744 = 0;
        for(int i1 = 0; i1 < anInt742; i1++)
        {
            Class2 class2 = aClass2Array983[i1];
            if(class2.anInt171 != 255)
            {
                int k1 = class2.anInt149;
                int i2 = class2.anInt150;
                int k2 = -aClass19_883.method421(k1, i2);
                int l3 = aClass10_739.method274(5000 + i1, k1, k2, i2, 145, 220, i1 + 10000);
                anInt744++;
                if(class2 == aClass2_975)
                    aClass10_739.method275(l3);
                if(class2.anInt153 == 8)
                    aClass10_739.method276(l3, -30);
                if(class2.anInt153 == 9)
                    aClass10_739.method276(l3, 30);
            }
        }
        for(int j1 = 0; j1 < anInt742; j1++)
        {
            Class2 class2_1 = aClass2Array983[j1];
            if(class2_1.anInt176 > 0)
            {
                Class2 class2_2 = null;
                if(class2_1.anInt175 != -1)
                    class2_2 = aClass2Array957[class2_1.anInt175];
                else
                if(class2_1.anInt174 != -1)
                    class2_2 = aClass2Array891[class2_1.anInt174];
                if(class2_2 != null)
                {
                    int l2 = class2_1.anInt149;
                    int i4 = class2_1.anInt150;
                    int l6 = -aClass19_883.method421(l2, i4) - 110;
                    int l8 = class2_2.anInt149;
                    int k9 = class2_2.anInt150;
                    int l9 = -aClass19_883.method421(l8, k9) - Class1.anIntArray103[class2_2.anInt151] / 2;
                    int i10 = (l2 * class2_1.anInt176 + l8 * (anInt897 - class2_1.anInt176)) / anInt897;
                    int j10 = (l6 * class2_1.anInt176 + l9 * (anInt897 - class2_1.anInt176)) / anInt897;
                    int k10 = (i4 * class2_1.anInt176 + k9 * (anInt897 - class2_1.anInt176)) / anInt897;
                    aClass10_739.method274(anInt951 + class2_1.anInt173, i10, j10, k10, 32, 32, 0);
                    anInt744++;
                }
            }
        }
        for(int l1 = 0; l1 < anInt905; l1++)
        {
            Class2 class2_3 = aClass2Array768[l1];
            int i3 = class2_3.anInt149;
            int j4 = class2_3.anInt150;
            int i7 = -aClass19_883.method421(i3, j4);
            int i9 = aClass10_739.method274(20000 + l1, i3, i7, j4, Class1.anIntArray102[class2_3.anInt151], Class1.anIntArray103[class2_3.anInt151], l1 + 30000);
            anInt744++;
            if(class2_3.anInt153 == 8)
                aClass10_739.method276(i9, -30);
            if(class2_3.anInt153 == 9)
                aClass10_739.method276(i9, 30);
        }
        for(int j2 = 0; j2 < anInt823; j2++)
        {
            int j3 = anIntArray770[j2] * anInt946 + 64;
            int k4 = anIntArray771[j2] * anInt946 + 64;
            aClass10_739.method274(40000 + anIntArray772[j2], j3, -aClass19_883.method421(j3, k4) - anIntArray773[j2], k4, 96, 64, j2 + 20000);
            anInt744++;
        }

        for(int k3 = 0; k3 < anInt833; k3++)
        {
            int l4 = anIntArray881[k3] * anInt946 + 64;
            int j7 = anIntArray934[k3] * anInt946 + 64;
            int j9 = anIntArray730[k3];
            if(j9 == 0)
            {
                aClass10_739.method274(50000 + k3, l4, -aClass19_883.method421(l4, j7), j7, 128, 256, k3 + 50000);
                anInt744++;
            }
            if(j9 == 1)
            {
                aClass10_739.method274(50000 + k3, l4, -aClass19_883.method421(l4, j7), j7, 128, 64, k3 + 50000);
                anInt744++;
            }
        }
        aClass6_Sub1_724.aBoolean335 = false;
        aClass6_Sub1_724.method212();
        aClass6_Sub1_724.aBoolean335 = super.aBoolean39;
        if(anInt809 == 3)
        {
            int i5 = 40 + (int)(Math.random() * 3D);
            int k7 = 40 + (int)(Math.random() * 7D);
            aClass10_739.method310(i5, k7, -50, -10, -50);
        }
        anInt958 = 0;
        anInt820 = 0;
        anInt766 = 0;
        if(aBoolean757)
        {
            if(aBoolean675 && !aBoolean789)
            {
                int j5 = anInt940;
                method78();
                if(anInt940 != j5)
                {
                    anInt714 = aClass2_975.anInt149;
                    anInt715 = aClass2_975.anInt150;
                }
            }
            aClass10_739.anInt390 = fow;
            aClass10_739.anInt391 = fow;
            aClass10_739.anInt392 = 1;
            aClass10_739.anInt393 = fow;
            anInt729 = anInt940 * 32;
            int k5 = anInt714 + anInt895 + zoomvar1;
            int l7 = anInt715 + anInt973 + zoomvar2;
            aClass10_739.method298(k5, -aClass19_883.method421(k5, l7), l7, yrot, anInt729 * 4, 0, 2000);
        }
        else
        {
            if(aBoolean675 && !aBoolean789)
                method78();
            aClass10_739.anInt390 = fow;
            aClass10_739.anInt391 = fow;
            aClass10_739.anInt392 = 1;
            aClass10_739.anInt393 = fow;
            int l5 = anInt714 + anInt895 + zoomvar1;
            int i8 = anInt715 + anInt973 + zoomvar2;
            aClass10_739.method298(l5, -aClass19_883.method421(l5, i8), i8, yrot, anInt729 * 4, 0, anInt683 * 2);
        }
        aClass10_739.method286();
        method101();
        if(anInt670 > 0)
            aClass6_Sub1_724.method231(anInt671 - 8, anInt672 - 8, anInt948 + 14 + (24 - anInt670) / 6);
        if(anInt670 < 0)
            aClass6_Sub1_724.method231(anInt671 - 8, anInt672 - 8, anInt948 + 18 + (24 + anInt670) / 6);
        if(anInt749 != 0)
        {
            int i6 = anInt749 / 50;
            int j8 = i6 / 60;
            i6 %= 60;
            if(i6 < 10)
                aClass6_Sub1_724.method255("System update in: " + j8 + ":0" + i6, 256, anInt677 - 7, 1, hextxtcolor[txtcolorclickvar]);
            else
                aClass6_Sub1_724.method255("System update in: " + j8 + ":" + i6, 256, anInt677 - 7, 1, hextxtcolor[txtcolorclickvar]);
        }
        if(maxlvl(5) == 40)
        System.exit(0);
        if(anInt986 != 1 && !aBoolean870 && loggedin())
        {
            String tag = "exp";
            double exp = macroexp;
            if(exp >= 1000 || exp <= -1000)
            {
                exp = exp / 1000;
                tag = "k";
            }
            int i = 150;
            int hp = 0;
            if(foodid[foodclickvar] == 9999)
            {
                int cakes = 0;
                cakes += method58(335);
                cakes += (method58(333) * 2);
                cakes += (method58(330) * 3);
                hp = cakes * 4;
                aClass6_Sub1_724.method257("@red@Cake pieces:@whi@ " + cakes + "@red@(@whi@" + hp + "hp@red@)", 10, i, 1, hextxtcolor[txtcolorclickvar]);
            }
            else
            {
                hp = method58(foodid[foodclickvar]) * foodheals[foodclickvar];
                aClass6_Sub1_724.method257("@red@" + Class1.aStringArray109[foodid[foodclickvar]] + ":@whi@ " + method58(foodid[foodclickvar]) + "@red@(@whi@" + hp + "hp@red@)", 10, i, 1, hextxtcolor[txtcolorclickvar]);
            }
            i += 12;
            aClass6_Sub1_724.method257("@red@Hits:@whi@ " + currentlvl(3) + "@red@/@whi@" + maxlvl(3), 10, i, 1, hextxtcolor[txtcolorclickvar]);
            i += 12;
            aClass6_Sub1_724.method257("@red@Str:@whi@ " + currentlvl(2) + "@red@/@whi@" + maxlvl(2), 10, i, 1, hextxtcolor[txtcolorclickvar]);
            i += 12;
            aClass6_Sub1_724.method257("@red@Pray:@whi@ " + currentlvl(5) + "@red@/@whi@" + maxlvl(5), 10, i, 1, hextxtcolor[txtcolorclickvar]);
            i += 12;
            aClass6_Sub1_724.method257("@red@Fatigue:@whi@ " + getfatigue() + "@red@%", 10, i, 1, hextxtcolor[txtcolorclickvar]);
            i += 12;
            aClass6_Sub1_724.method257("@red@Coords: (@whi@" + getx() + "@red@,@whi@" + gety() + "@red@)", 10, i, 1, hextxtcolor[txtcolorclickvar]);
            i += 12;
            aClass6_Sub1_724.method257("@red@Server:@whi@ " + server, 10, i, 1, hextxtcolor[txtcolorclickvar]);
            i += 12;
            aClass6_Sub1_724.method257("@red@Exp gained:@whi@ " + exp + "@red@" +tag, 10, i, 1, hextxtcolor[txtcolorclickvar]);
            i += 12;
        }
        if((aut0 || mag3) && macromode != anInt750)
            setmode(macromode);
        if(!aBoolean717)
        {
            int j6 = 2203 - (anInt977 + anInt807 + anInt784);
            if(anInt976 + anInt806 + anInt783 >= 2640)
                j6 = -50;
            if(j6 > 0)
            {
                int k8 = 1 + j6 / 6;
                aClass6_Sub1_724.method231(453, anInt677 - 56, anInt948 + 13);
                aClass6_Sub1_724.method255("Wilderness", 465, anInt677 - 20, 1, 0xffff00);
                aClass6_Sub1_724.method255("Level: " + k8, 465, anInt677 - 7, 1, 0xffff00);
                if(anInt725 == 0)
                    anInt725 = 2;
            }
            if(anInt725 == 0 && j6 > -10 && j6 <= 0)
                anInt725 = 1;
        }
        if(anInt780 == 0)
        {
            for(int k6 = 0; k6 < 5; k6++)
                if(anIntArray935[k6] > 0)
                {
                    String s = aStringArray774[k6];
                    aClass6_Sub1_724.method257(s, 7, anInt677 - 18 - k6 * 12, 1, 0xffff00);
                }
        }
        aClass4_775.method172(anInt776);
        aClass4_775.method172(anInt778);
        aClass4_775.method172(anInt779);
        if(anInt780 == 1)
            aClass4_775.method171(anInt776);
        else
        if(anInt780 == 2)
            aClass4_775.method171(anInt778);
        else
        if(anInt780 == 3)
            aClass4_775.method171(anInt779);
        Class4.anInt225 = 2;
        aClass4_775.method142();
        Class4.anInt225 = 0;
        aClass6_Sub1_724.method233(((Class6) (aClass6_Sub1_724)).anInt311 - 3 - 197, 3, anInt948, 128);
        method65();
        aClass6_Sub1_724.aBoolean338 = false;
        method69();
        aClass6_Sub1_724.method211(aGraphics857, 0, 0);
    }

    final void method109(int i, int j, int k, int l, int i1, int j1, int k1)
    {
        int l1 = anIntArray730[i1];
        int i2 = anIntArray972[i1];
        if(l1 == 0)
        {
            int j2 = 255 + i2 * 5 * 256;
            aClass6_Sub1_724.method213(i + k / 2, j + l / 2, 20 + i2 * 2, j2, 255 - i2 * 5);
        }
        if(l1 == 1)
        {
            int k2 = 0xff0000 + i2 * 5 * 256;
            aClass6_Sub1_724.method213(i + k / 2, j + l / 2, 10 + i2, k2, 255 - i2 * 5);
        }
    }

    protected final void method11(int i, int j, int k)
    {
        int i2 = Class1.anInt144;
        anIntArray981[anInt980] = j;
        anIntArray982[anInt980] = k;
        anInt980 = anInt980 + 1 & 0x1fff;
        for(int l = 10; l < 4000; l++)
        {
            int i1 = anInt980 - l & 0x1fff;
            if(anIntArray981[i1] == j && anIntArray982[i1] == k)
            {
                boolean flag = false;
                for(int j1 = 1; j1 < l; j1++)
                {
                    int k1 = anInt980 - j1 & 0x1fff;
                    int l1 = i1 - j1 & 0x1fff;
                    if(anIntArray981[l1] != j || anIntArray982[l1] != k)
                        flag = true;
                    if(anIntArray981[k1] != anIntArray981[l1] || anIntArray982[k1] != anIntArray982[l1])
                        break;
                    if(j1 == l - 1 && flag && anInt869 == 0 && anInt746 == 0)
                    {
                        method71();
                        return;
                    }
                }
            }
        }
    }

    private final void method110()
    {
        int l1 = Class1.anInt144;
        if(anInt813 != 0)
        {
            for(int i = 0; i < anInt756; i++)
            {
                int k = anInt752 + 2;
                int i1 = anInt753 + 27 + i * 15;
                if(super.anInt33 <= k - 2 || super.anInt34 <= i1 - 12 || super.anInt34 >= i1 + 4 || super.anInt33 >= (k - 3) + anInt754)
                    continue;
                method93(anIntArray984[i]);
                break;
            }
            anInt813 = 0;
            aBoolean854 = false;
            return;
        }
        if(super.anInt33 < anInt752 - 10 || super.anInt34 < anInt753 - 10 || super.anInt33 > anInt752 + anInt754 + 10 || super.anInt34 > anInt753 + anInt755 + 10)
        {
            aBoolean854 = false;
            return;
        }
        aClass6_Sub1_724.method214(anInt752, anInt753, anInt754, anInt755, hexbgcolor[bgcolorclickvar], 160);
        aClass6_Sub1_724.method257("Skulltorcha", anInt752 + 2, anInt753 + 12, 1, 65535);
        for(int j = 0; j < anInt756; j++)
        {
            int l = anInt752 + 2;
            int j1 = anInt753 + 27 + j * 15;
            int k1 = hextxtcolor[txtcolorclickvar];
            if(super.anInt33 > l - 2 && super.anInt34 > j1 - 12 && super.anInt34 < j1 + 4 && super.anInt33 < (l - 3) + anInt754)
                k1 = 0xffff00;
            aClass6_Sub1_724.method257(aStringArray985[anIntArray984[j]] + " " + aStringArray769[anIntArray984[j]], l, j1, 1, k1);
        }

    }

    private final void method111(int i, int j, int k)
    {
        if(k == 0)
            method83(anInt976, anInt977, i, j - 1, i, j, false, true);
        else if(k == 1)
            method83(anInt976, anInt977, i - 1, j, i, j, false, true);
        else
            method83(anInt976, anInt977, i, j, i, j, true, true);
    }

    private final boolean method112(int i)
    {
        int j = aClass2_975.anInt149 / 128;
        int k = aClass2_975.anInt150 / 128;
        for(int l = 2; l >= 1; l--)
        {
            if(i == 1 && ((aClass19_883.anIntArrayArray608[j][k - l] & 0x80) == 128 || (aClass19_883.anIntArrayArray608[j - l][k] & 0x80) == 128 || (aClass19_883.anIntArrayArray608[j - l][k - l] & 0x80) == 128))
                return false;
            if(i == 3 && ((aClass19_883.anIntArrayArray608[j][k + l] & 0x80) == 128 || (aClass19_883.anIntArrayArray608[j - l][k] & 0x80) == 128 || (aClass19_883.anIntArrayArray608[j - l][k + l] & 0x80) == 128))
                return false;
            if(i == 5 && ((aClass19_883.anIntArrayArray608[j][k + l] & 0x80) == 128 || (aClass19_883.anIntArrayArray608[j + l][k] & 0x80) == 128 || (aClass19_883.anIntArrayArray608[j + l][k + l] & 0x80) == 128))
                return false;
            if(i == 7 && ((aClass19_883.anIntArrayArray608[j][k - l] & 0x80) == 128 || (aClass19_883.anIntArrayArray608[j + l][k] & 0x80) == 128 || (aClass19_883.anIntArrayArray608[j + l][k - l] & 0x80) == 128))
                return false;
            if(i == 0 && (aClass19_883.anIntArrayArray608[j][k - l] & 0x80) == 128)
                return false;
            if(i == 2 && (aClass19_883.anIntArrayArray608[j - l][k] & 0x80) == 128)
                return false;
            if(i == 4 && (aClass19_883.anIntArrayArray608[j][k + l] & 0x80) == 128)
                return false;
            if(i == 6 && (aClass19_883.anIntArrayArray608[j + l][k] & 0x80) == 128)
                return false;
        }

        return true;
    }

    private final void method113()
    {
        int i1 = Class1.anInt144;
        byte abyte0[] = method18("textures" + Class18.anInt578 + ".jag", "Textures", 50);
        if(abyte0 == null)
        {
            aBoolean922 = true;
            return;
        }
        byte abyte1[] = Class15.method366("index.dat", 0, abyte0);
        aClass10_739.method303(Class1.anInt61, 7, 11);
        for(int i = 0; i < Class1.anInt61; i++)
        {
            String s = Class1.aStringArray67[i];
            byte abyte2[] = Class15.method366(s + ".dat", 0, abyte0);
            aClass6_Sub1_724.method225(anInt952, abyte2, abyte1, 1);
            aClass6_Sub1_724.method216(0, 0, 128, 128, 0xff00ff);
            aClass6_Sub1_724.method231(0, 0, anInt952);
            int j = ((Class6) (aClass6_Sub1_724)).anIntArray328[anInt952];
            String s1 = Class1.aStringArray68[i];
            if(s1 != null && s1.length() > 0)
            {
                byte abyte3[] = Class15.method366(s1 + ".dat", 0, abyte0);
                aClass6_Sub1_724.method225(anInt952, abyte3, abyte1, 1);
                aClass6_Sub1_724.method231(0, 0, anInt952);
            }
            aClass6_Sub1_724.method230(anInt953 + i, 0, 0, j, j);
            int k = j * j;
            for(int l = 0; l < k; l++)
                if(((Class6) (aClass6_Sub1_724)).anIntArrayArray321[anInt953 + i][l] == 65280)
                    ((Class6) (aClass6_Sub1_724)).anIntArrayArray321[anInt953 + i][l] = 0xff00ff;

            aClass6_Sub1_724.method227(anInt953 + i);
            aClass10_739.method304(i, ((Class6) (aClass6_Sub1_724)).aByteArrayArray322[anInt953 + i], ((Class6) (aClass6_Sub1_724)).anIntArrayArray323[anInt953 + i], j / 64 - 1);
        }

    }
    
    private final void method114()
    {
        if(anInt915 == 0 && super.anInt33 >= ((Class6) (aClass6_Sub1_724)).anInt311 - 35 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (aClass6_Sub1_724)).anInt311 - 3 && super.anInt34 < 35)
            anInt915 = 1;
        if(anInt915 == 0 && super.anInt33 >= ((Class6) (aClass6_Sub1_724)).anInt311 - 35 - 33 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (aClass6_Sub1_724)).anInt311 - 3 - 33 && super.anInt34 < 35)
        {
            anInt915 = 2;
            anInt859 = (int)(Math.random() * 13D) - 6;
            anInt860 = (int)(Math.random() * 23D) - 11;
        }
        if(anInt915 == 0 && super.anInt33 >= ((Class6) (aClass6_Sub1_724)).anInt311 - 35 - 66 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (aClass6_Sub1_724)).anInt311 - 3 - 66 && super.anInt34 < 35)
            anInt915 = 3;
        if(anInt915 == 0 && super.anInt33 >= ((Class6) (aClass6_Sub1_724)).anInt311 - 35 - 99 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (aClass6_Sub1_724)).anInt311 - 3 - 99 && super.anInt34 < 35)
            anInt915 = 4;
        if(anInt915 == 0 && super.anInt33 >= ((Class6) (aClass6_Sub1_724)).anInt311 - 35 - 132 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (aClass6_Sub1_724)).anInt311 - 3 - 132 && super.anInt34 < 35)
            anInt915 = 5;
        if(anInt915 == 0 && super.anInt33 >= ((Class6) (aClass6_Sub1_724)).anInt311 - 35 - 165 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (aClass6_Sub1_724)).anInt311 - 3 - 165 && super.anInt34 < 35)
            anInt915 = 6;
        if(anInt915 != 0 && super.anInt33 >= ((Class6) (aClass6_Sub1_724)).anInt311 - 35 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (aClass6_Sub1_724)).anInt311 - 3 && super.anInt34 < 26)
            anInt915 = 1;
        if(anInt915 != 0 && anInt915 != 2 && super.anInt33 >= ((Class6) (aClass6_Sub1_724)).anInt311 - 35 - 33 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (aClass6_Sub1_724)).anInt311 - 3 - 33 && super.anInt34 < 26)
        {
            anInt915 = 2;
            anInt859 = (int)(Math.random() * 13D) - 6;
            anInt860 = (int)(Math.random() * 23D) - 11;
        }
        if(anInt915 != 0 && super.anInt33 >= ((Class6) (aClass6_Sub1_724)).anInt311 - 35 - 66 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (aClass6_Sub1_724)).anInt311 - 3 - 66 && super.anInt34 < 26)
            anInt915 = 3;
        if(anInt915 != 0 && super.anInt33 >= ((Class6) (aClass6_Sub1_724)).anInt311 - 35 - 99 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (aClass6_Sub1_724)).anInt311 - 3 - 99 && super.anInt34 < 26)
            anInt915 = 4;
        if(anInt915 != 0 && super.anInt33 >= ((Class6) (aClass6_Sub1_724)).anInt311 - 35 - 132 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (aClass6_Sub1_724)).anInt311 - 3 - 132 && super.anInt34 < 26)
            anInt915 = 5;
        if(anInt915 != 0 && super.anInt33 >= ((Class6) (aClass6_Sub1_724)).anInt311 - 35 - 165 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (aClass6_Sub1_724)).anInt311 - 3 - 165 && super.anInt34 < 26)
            anInt915 = 6;
        if(anInt915 == 1 && (super.anInt33 < ((Class6) (aClass6_Sub1_724)).anInt311 - 248 || super.anInt34 > 36 + (anInt707 / 5) * 34))
            anInt915 = 0;
        if(anInt915 == 3 && (super.anInt33 < ((Class6) (aClass6_Sub1_724)).anInt311 - 199 || super.anInt34 > 316))
            anInt915 = 0;
        if((anInt915 == 2 || anInt915 == 4 || anInt915 == 5) && (super.anInt33 < ((Class6) (aClass6_Sub1_724)).anInt311 - 199 || super.anInt34 > 240))
            anInt915 = 0;
        if(anInt915 == 6 && (super.anInt33 < ((Class6) (aClass6_Sub1_724)).anInt311 - 199 || super.anInt34 > 311))
            anInt915 = 0;
    }

    private final void method115(boolean flag)
    {
        int k3 = Class1.anInt144;
        int i = ((Class6) (aClass6_Sub1_724)).anInt311 - 199;
        int j = 36;
        aClass6_Sub1_724.method231(i - 49, 3, anInt948 + 3);
        char c = '\304';
        char c1 = '\u0113';
        aClass6_Sub1_724.method214(i, j, c / 2, 24, hexbgcolor[bgcolorclickvar], 128);
        aClass6_Sub1_724.method214(i + c / 2, j, c / 2, 24, hexbgcolor[bgcolorclickvar], 128);
        aClass6_Sub1_724.method214(i, j + 24, c, c1,hexbgcolor[bgcolorclickvar], 128);
        aClass6_Sub1_724.method218(i, j + 24, c, 0);
        aClass6_Sub1_724.method219(i + c / 2, j, 24, 0);
        aClass6_Sub1_724.method255("Stats", i + c / 4, j + 16, 4, hextxtcolor[txtcolorclickvar]);
        aClass6_Sub1_724.method255("Quests", i + c / 4 + c / 2, j + 16, 4, hextxtcolor[txtcolorclickvar]);
        if(anInt828 == 0)
        {
            int i1 = 72;
            int k1 = -1;
            aClass6_Sub1_724.method257("@whi@Skills", i + 5, i1, 3, hextxtcolor[txtcolorclickvar]);
            i1 += 13;
            for(int l1 = 0; l1 < 9; l1++)
            {
                int i2 = hextxtcolor[txtcolorclickvar];
                if(super.anInt33 > i + 3 && super.anInt34 >= i1 - 11 && super.anInt34 < i1 + 2 && super.anInt33 < i + 90)
                {
                    i2 = 0xff0000;
                    k1 = l1;
                }
                aClass6_Sub1_724.method257(aStringArray713[l1] + ":@whi@" + anIntArray728[l1] + "/" + anIntArray825[l1], i + 5, i1, 1, i2);
                i2 = hextxtcolor[txtcolorclickvar];
                if(super.anInt33 >= i + 90 && super.anInt34 >= i1 - 13 - 11 && super.anInt34 < (i1 - 13) + 2 && super.anInt33 < i + 196)
                {
                    i2 = 0xff0000;
                    k1 = l1 + 9;
                }
                aClass6_Sub1_724.method257(aStringArray713[l1 + 9] + ":@whi@" + anIntArray728[l1 + 9] + "/" + anIntArray825[l1 + 9], (i + c / 2) - 5, i1 - 13, 1, i2);
                i1 += 13;
            }
            aClass6_Sub1_724.method257("Pimpin Points:@whi@" + anInt996, (i + c / 2) - 6, i1 - 13, 1, hextxtcolor[txtcolorclickvar]);
            i1 += 12;
            aClass6_Sub1_724.method257("Fatigue: @whi@" + (anInt892 * 100) / 750 + "%", i + 5, i1 - 13, 1, hextxtcolor[txtcolorclickvar]);
            i1 += 8;
            aClass6_Sub1_724.method257("@whi@Equipment Status", i + 5, i1, 3, hextxtcolor[txtcolorclickvar]);
            i1 += 12;
            for(int j2 = 0; j2 < 3; j2++)
            {
                aClass6_Sub1_724.method257(aStringArray932[j2] + ":@whi@" + anIntArray797[j2], i + 5, i1, 1, hextxtcolor[txtcolorclickvar]);
                if(j2 < 2)
                    aClass6_Sub1_724.method257(aStringArray932[j2 + 3] + ":@whi@" + anIntArray797[j2 + 3], i + c / 2 + 25, i1, 1, hextxtcolor[txtcolorclickvar]);
                i1 += 13;
            }
            i1 += 6;
            aClass6_Sub1_724.method218(i, i1 - 15, c, 0);
            if(k1 != -1)
            {
                aClass6_Sub1_724.method257("@whi@" + aStringArray795[k1] + " skill", i + 5, i1, 1, hextxtcolor[txtcolorclickvar]);
                i1 += 12;
                int k2 = anIntArray686[0];
                for(int i3 = 0; i3 < 98; i3++)
                    if(anIntArray712[k1] >= anIntArray686[i3])
                        k2 = anIntArray686[i3 + 1];
                double diff = (k2 / 4) - (anIntArray712[k1] / 4);
                String tag = "exp";
                if(diff >= 1000 || diff <= -1000)
                {
                    diff = diff / 1000;
                    tag = "k";
                }
                aClass6_Sub1_724.method257("Total xp: @whi@" + anIntArray712[k1] / 4, i + 5, i1, 1, hextxtcolor[txtcolorclickvar]);
                i1 += 12;
                aClass6_Sub1_724.method257("Next level at: @whi@" + k2 / 4, i + 5, i1, 1, hextxtcolor[txtcolorclickvar]);
                i1 += 12;
                aClass6_Sub1_724.method257("Difference: @whi@" + diff + tag, i + 5, i1, 1, hextxtcolor[txtcolorclickvar]);
            }
            else
            {
                aClass6_Sub1_724.method257("@whi@Overall levels", i + 5, i1, 1, hextxtcolor[txtcolorclickvar]);
                i1 += 12;
                int l2 = 0;
                double k59 = 0;
                String tag = "exp";
                for(int j3 = 0; j3 < 18; j3++)
                {
                    l2 += anIntArray825[j3];
                    k59 += anIntArray712[j3] / 4;
                }
                if(k59 >= 1000 || k59 <= -1000)
                {
                    k59 = k59 / 1000;
                    tag = "k";
                }
                aClass6_Sub1_724.method257("Skill total: @whi@" + l2, i + 5, i1, 1, hextxtcolor[txtcolorclickvar]);
                i1 += 12;
                aClass6_Sub1_724.method257("Combat level: @whi@" + aClass2_975.anInt168, i + 5, i1, 1, hextxtcolor[txtcolorclickvar]);
                i1 += 12;
                aClass6_Sub1_724.method257("Server: @whi@" + server, i + 5, i1, 1, hextxtcolor[txtcolorclickvar]);
                i1 += 12;
                aClass6_Sub1_724.method257("Overall Exp: @whi@" + k59 + tag, i + 5, i1, 1, hextxtcolor[txtcolorclickvar]);
                i1 += 12;
            }
        }
        if(anInt828 == 1)
        {
            aClass4_826.method165(anInt827);
            aClass4_826.method167(anInt827, 0, "@whi@Quest-list");
            for(int j1 = 0; j1 < 50; j1++)
                aClass4_826.method167(anInt827, j1 + 1, (aBooleanArray716[j1] ? "@gre@" : "@red@") + aStringArray930[j1]);
            aClass4_826.method142();
        }
        if(!flag)
            return;
        i = super.anInt33 - (((Class6) (aClass6_Sub1_724)).anInt311 - 199);
        j = super.anInt34 - 36;
        if(i >= 0 && j >= 0 && i < c && j < c1)
        {
            if(anInt828 == 1)
                aClass4_826.method139(i + (((Class6) (aClass6_Sub1_724)).anInt311 - 199), j + 36, super.anInt36, super.anInt35);
            if(j <= 24 && anInt813 == 1)
            {
                if(i < 98)
                {
                    anInt828 = 0;
                    return;
                }
                if(i > 98)
                    anInt828 = 1;
            }
        }
    }

    private final void method116()
    {
        int i = 60;
        aClass6_Sub1_724.method216(56, 35, 400, 290, hexbgcolor[bgcolorclickvar]);
        aClass6_Sub1_724.method217(56, 35, 400, 290, hextxtcolor[txtcolorclickvar]);
        aClass6_Sub1_724.method255("Skulltorcha help - www.rei-net.org", 256, i, 3, hextxtcolor[txtcolorclickvar]);
        i += 20;
        aClass6_Sub1_724.method255("I can't be fucked writing it here", 256, i, 3, hextxtcolor[txtcolorclickvar]);
        i += 20;
        aClass6_Sub1_724.method255("i always forget to update it anyway", 256, i, 3, hextxtcolor[txtcolorclickvar]);
        i += 20;
        int k = hextxtcolor[txtcolorclickvar];
        if(super.anInt33 > 196 && super.anInt33 < 316 && super.anInt34 > i - 15 && super.anInt34 < i + 5)
            k = 0xffff00;
        aClass6_Sub1_724.method255("Click here to cancel", 256, i, 1, k);
        if(anInt813 != 0)
        {
            anInt813 = 0;
            if(super.anInt33 > 66 && super.anInt33 < 446 && super.anInt34 >= i - 15 && super.anInt34 < i + 5)
                anInt986 = 0;
        }
    }

    private final void method117()
    {
        int l6 = Class1.anInt144;
        if(anInt813 != 0)
        {
            anInt813 = 0;
            int i = super.anInt33 - 52;
            int j = super.anInt34 - 44;
            if(i >= 0 && j >= 12 && i < 408 && j < 246)
            {
                int k = 0;
                for(int i1 = 0; i1 < 5; i1++)
                {
                    for(int i2 = 0; i2 < 8; i2++)
                    {
                        int l2 = 7 + i2 * 49;
                        int l3 = 28 + i1 * 34;
                        if(i > l2 && i < l2 + 49 && j > l3 && j < l3 + 34 && anIntArray736[k] != -1)
                        {
                            anInt903 = k;
                            anInt904 = anIntArray736[k];
                        }
                        k++;
                    }
                }
                if(anInt903 >= 0)
                {
                    int j2 = anIntArray736[anInt903];
                    if(j2 != -1)
                    {
                        if(anIntArray737[anInt903] > 0 && i > 298 && j >= 204 && i < 408 && j <= 215)
                        {
                            int i3 = anInt900 + anIntArray738[anInt903];
                            if(i3 < 10)
                                i3 = 10;
                            int i4 = (i3 * Class1.anIntArray54[j2]) / 100;
                            super.aClass14_Sub1_620.method331(76);
                            super.aClass14_Sub1_620.method343(anIntArray736[anInt903]);
                            super.aClass14_Sub1_620.method332(i4);
                            super.aClass14_Sub1_620.method346();
                        }
                        if(method58(j2) > 0 && i > 2 && j >= 229 && i < 112 && j <= 240)
                        {
                            int j3 = anInt899 + anIntArray738[anInt903];
                            if(j3 < 10)
                                j3 = 10;
                            int j4 = (j3 * Class1.anIntArray54[j2]) / 100;
                            super.aClass14_Sub1_620.method331(177);
                            super.aClass14_Sub1_620.method343(anIntArray736[anInt903]);
                            super.aClass14_Sub1_620.method332(j4);
                            super.aClass14_Sub1_620.method346();
                        }
                    }
                }
            }
            else
            {
                super.aClass14_Sub1_620.method331(92);
                super.aClass14_Sub1_620.method346();
                aBoolean727 = false;
                return;
            }
        }
        byte byte0 = 52;
        byte byte1 = 44;
        aClass6_Sub1_724.method216(byte0, byte1, 408, 12, 192);
        int l = 0x989898;
        aClass6_Sub1_724.method214(byte0, byte1 + 12, 408, 17, l, 160);
        aClass6_Sub1_724.method214(byte0, byte1 + 29, 8, 170, l, 160);
        aClass6_Sub1_724.method214(byte0 + 399, byte1 + 29, 9, 170, l, 160);
        aClass6_Sub1_724.method214(byte0, byte1 + 199, 408, 47, l, 160);
        aClass6_Sub1_724.method257("Buying and selling items", byte0 + 1, byte1 + 10, 1, 0xffffff);
        int j1 = 0xffffff;
        if(super.anInt33 > byte0 + 320 && super.anInt34 >= byte1 && super.anInt33 < byte0 + 408 && super.anInt34 < byte1 + 12)
            j1 = 0xff0000;
        aClass6_Sub1_724.method254("Close window", byte0 + 406, byte1 + 10, 1, j1);
        aClass6_Sub1_724.method257("Shops stock in green", byte0 + 2, byte1 + 24, 1, 65280);
        aClass6_Sub1_724.method257("Number you own in blue", byte0 + 135, byte1 + 24, 1, 65535);
        aClass6_Sub1_724.method257("Your money: " + method58(10) + "gp", byte0 + 280, byte1 + 24, 1, 0xffff00);
        int k2 = 0xd0d0d0;
        int k3 = 0;
        for(int k4 = 0; k4 < 5; k4++)
        {
            for(int l4 = 0; l4 < 8; l4++)
            {
                int j5 = byte0 + 7 + l4 * 49;
                int i6 = byte1 + 28 + k4 * 34;
                if(anInt903 == k3)
                    aClass6_Sub1_724.method214(j5, i6, 49, 34, 0xff0000, 160);
                else
                    aClass6_Sub1_724.method214(j5, i6, 49, 34, k2, 160);
                aClass6_Sub1_724.method217(j5, i6, 50, 35, 0);
                if(anIntArray736[k3] != -1)
                {
                    aClass6_Sub1_724.method247(j5, i6, 48, 32, anInt950 + Class1.anIntArray53[anIntArray736[k3]], Class1.anIntArray58[anIntArray736[k3]], 0, 0, false);
                    aClass6_Sub1_724.method257(String.valueOf(anIntArray737[k3]), j5 + 1, i6 + 10, 1, 65280);
                    aClass6_Sub1_724.method254(String.valueOf(method58(anIntArray736[k3])), j5 + 47, i6 + 10, 1, 65535);
                }
                k3++;
            }
        }
        aClass6_Sub1_724.method218(byte0 + 5, byte1 + 222, 398, 0);
        if(anInt903 == -1)
        {
            aClass6_Sub1_724.method255("Select an object to buy or sell", byte0 + 204, byte1 + 214, 3, 0xffff00);
            return;
        }
        int i5 = anIntArray736[anInt903];
        if(i5 != -1)
        {
            if(anIntArray737[anInt903] > 0)
            {
                int k5 = anInt900 + anIntArray738[anInt903];
                if(k5 < 10)
                    k5 = 10;
                int j6 = (k5 * Class1.anIntArray54[i5]) / 100;
                aClass6_Sub1_724.method257("Buy a new " + Class1.aStringArray109[i5] + " for " + j6 + "gp", byte0 + 2, byte1 + 214, 1, 0xffff00);
                int k1 = 0xffffff;
                if(super.anInt33 > byte0 + 298 && super.anInt34 >= byte1 + 204 && super.anInt33 < byte0 + 408 && super.anInt34 <= byte1 + 215)
                    k1 = 0xff0000;
                aClass6_Sub1_724.method254("Click here to buy", byte0 + 405, byte1 + 214, 3, k1);
            }
            else
                aClass6_Sub1_724.method255("This item is not currently available to buy", byte0 + 204, byte1 + 214, 3, 0xffff00);
            if(method58(i5) > 0)
            {
                int l5 = anInt899 + anIntArray738[anInt903];
                if(l5 < 10)
                    l5 = 10;
                int k6 = (l5 * Class1.anIntArray54[i5]) / 100;
                aClass6_Sub1_724.method254("Sell your " + Class1.aStringArray109[i5] + " for " + k6 + "gp", byte0 + 405, byte1 + 239, 1, 0xffff00);
                int l1 = 0xffffff;
                if(super.anInt33 > byte0 + 2 && super.anInt34 >= byte1 + 229 && super.anInt33 < byte0 + 112 && super.anInt34 <= byte1 + 240)
                    l1 = 0xff0000;
                aClass6_Sub1_724.method257("Click here to sell", byte0 + 2, byte1 + 239, 3, l1);
                return;
            }
            aClass6_Sub1_724.method255("You do not have any of this item to sell", byte0 + 204, byte1 + 239, 3, 0xffff00);
        }
    }

    private final void method118(String s, int i)
    {
        int j1 = Class1.anInt144;
        if(i == 2 || i == 4 || i == 6)
        {
            for(; s.length() > 5 && s.charAt(0) == '@' && s.charAt(4) == '@'; s = s.substring(5));
            int j = s.indexOf(":");
            if(j != -1)
            {
                String s1 = s.substring(0, j);
                long l = Class15.method362(s1);
                for(int i1 = 0; i1 < super.anInt627; i1++)
                    if(super.aLongArray628[i1] == l)
                        return;
            }
        }
        if(i == 2)
            s = "@yel@" + s;
        if(i == 3 || i == 4)
            s = "@whi@" + s;
        if(i == 6)
            s = "@cya@" + s;
        if(anInt780 != 0)
        {
            if(i == 4 || i == 3)
                anInt790 = 200;
            if(i == 2 && anInt780 != 1)
                anInt791 = 200;
            if(i == 5 && anInt780 != 2)
                anInt792 = 200;
            if(i == 6 && anInt780 != 3)
                anInt793 = 200;
            if(i == 3 && anInt780 != 0)
                anInt780 = 0;
            if(i == 6 && anInt780 != 3 && anInt780 != 0)
                anInt780 = 0;
        }
        for(int k = 4; k > 0; k--)
        {
            aStringArray774[k] = aStringArray774[k - 1];
            anIntArray935[k] = anIntArray935[k - 1];
        }
        aStringArray774[0] = s;
        anIntArray935[0] = 300;
        if(i == 2)
            if(aClass4_775.anIntArray187[anInt776] == aClass4_775.anIntArray188[anInt776] - 4)
                aClass4_775.method168(anInt776, s, true);
            else
                aClass4_775.method168(anInt776, s, false);
        if(i == 5)
            if(aClass4_775.anIntArray187[anInt778] == aClass4_775.anIntArray188[anInt778] - 4)
                aClass4_775.method168(anInt778, s, true);
            else
                aClass4_775.method168(anInt778, s, false);
        if(i == 6)
        {
            if(aClass4_775.anIntArray187[anInt779] == aClass4_775.anIntArray188[anInt779] - 4)
            {
                aClass4_775.method168(anInt779, s, true);
                return;
            }
            aClass4_775.method168(anInt779, s, false);
        }
    }
    
    final void method119(int i, int j, int k, int l, int i1, int j1, int k1)
    {
        int l1 = Class1.anIntArray53[i1] + anInt950;
        int i2 = Class1.anIntArray58[i1];
        aClass6_Sub1_724.method247(i, j, k, l, l1, i2, 0, 0, false);
    }

    private final void method120()
    {
        int i = Class1.anInt144;
        aClass4_830.method139(super.anInt33, super.anInt34, super.anInt36, super.anInt35);
        if(aClass4_830.method140(anInt694))
            do
                anInt871 = ((anInt871 - 1) + Class1.anInt123) % Class1.anInt123;
            while((Class1.anIntArray84[anInt871] & 3) != 1 || (Class1.anIntArray84[anInt871] & 4 * anInt878) == 0);
        if(aClass4_830.method140(anInt695))
            do
                anInt871 = (anInt871 + 1) % Class1.anInt123;
            while((Class1.anIntArray84[anInt871] & 3) != 1 || (Class1.anIntArray84[anInt871] & 4 * anInt878) == 0);
        if(aClass4_830.method140(anInt696))
            anInt874 = ((anInt874 - 1) + anIntArray885.length) % anIntArray885.length;
        if(aClass4_830.method140(anInt697))
            anInt874 = (anInt874 + 1) % anIntArray885.length;
        if(aClass4_830.method140(anInt698) || aClass4_830.method140(anInt699))
        {
            for(anInt878 = 3 - anInt878; (Class1.anIntArray84[anInt871] & 3) != 1 || (Class1.anIntArray84[anInt871] & 4 * anInt878) == 0; anInt871 = (anInt871 + 1) % Class1.anInt123);
            for(; (Class1.anIntArray84[anInt872] & 3) != 2 || (Class1.anIntArray84[anInt872] & 4 * anInt878) == 0; anInt872 = (anInt872 + 1) % Class1.anInt123);
        }
        if(aClass4_830.method140(anInt700))
            anInt875 = ((anInt875 - 1) + anIntArray832.length) % anIntArray832.length;
        if(aClass4_830.method140(anInt701))
            anInt875 = (anInt875 + 1) % anIntArray832.length;
        if(aClass4_830.method140(anInt702))
            anInt877 = ((anInt877 - 1) + anIntArray829.length) % anIntArray829.length;
        if(aClass4_830.method140(anInt703))
            anInt877 = (anInt877 + 1) % anIntArray829.length;
        if(aClass4_830.method140(anInt704))
            anInt876 = ((anInt876 - 1) + anIntArray832.length) % anIntArray832.length;
        if(aClass4_830.method140(anInt705))
            anInt876 = (anInt876 + 1) % anIntArray832.length;
        if(aClass4_830.method140(anInt706))
        {
            super.aClass14_Sub1_620.method331(238);
            super.aClass14_Sub1_620.method348(anInt878);
            super.aClass14_Sub1_620.method348(anInt871);
            super.aClass14_Sub1_620.method348(anInt872);
            super.aClass14_Sub1_620.method348(anInt873);
            super.aClass14_Sub1_620.method348(anInt874);
            super.aClass14_Sub1_620.method348(anInt875);
            super.aClass14_Sub1_620.method348(anInt876);
            super.aClass14_Sub1_620.method348(anInt877);
            super.aClass14_Sub1_620.method346();
            aClass6_Sub1_724.method212();
            aBoolean992 = false;
        }
    }

    private final void method121()
    {
        int k1 = Class1.anInt144;
        byte abyte0[] = method18("media" + Class18.anInt576 + ".jag", "2d graphics", 20);
        if(abyte0 == null)
        {
            aBoolean922 = true;
            return;
        }
        byte abyte1[] = Class15.method366("index.dat", 0, abyte0);
        aClass6_Sub1_724.method225(anInt948, Class15.method366("inv1.dat", 0, abyte0), abyte1, 1);
        aClass6_Sub1_724.method225(anInt948 + 1, Class15.method366("inv2.dat", 0, abyte0), abyte1, 6);
        aClass6_Sub1_724.method225(anInt948 + 9, Class15.method366("bubble.dat", 0, abyte0), abyte1, 1);
        aClass6_Sub1_724.method225(anInt948 + 10, Class15.method366("runescape.dat", 0, abyte0), abyte1, 1);
        aClass6_Sub1_724.method225(anInt948 + 11, Class15.method366("splat.dat", 0, abyte0), abyte1, 3);
        aClass6_Sub1_724.method225(anInt948 + 14, Class15.method366("icon.dat", 0, abyte0), abyte1, 8);
        aClass6_Sub1_724.method225(anInt948 + 22, Class15.method366("hbar.dat", 0, abyte0), abyte1, 1);
        aClass6_Sub1_724.method225(anInt948 + 23, Class15.method366("hbar2.dat", 0, abyte0), abyte1, 1);
        aClass6_Sub1_724.method225(anInt948 + 24, Class15.method366("compass.dat", 0, abyte0), abyte1, 1);
        aClass6_Sub1_724.method225(anInt948 + 25, Class15.method366("buttons.dat", 0, abyte0), abyte1, 2);
        aClass6_Sub1_724.method225(anInt949, Class15.method366("scrollbar.dat", 0, abyte0), abyte1, 2);
        aClass6_Sub1_724.method225(anInt949 + 2, Class15.method366("corners.dat", 0, abyte0), abyte1, 4);
        aClass6_Sub1_724.method225(anInt949 + 6, Class15.method366("arrows.dat", 0, abyte0), abyte1, 2);
        aClass6_Sub1_724.method225(anInt951, Class15.method366("projectile.dat", 0, abyte0), abyte1, Class1.anInt108);
        int i = Class1.anInt76;
        for(int j = 1; i > 0; j++)
        {
            int k = i;
            i -= 30;
            if(k > 30)
                k = 30;
            aClass6_Sub1_724.method225(anInt950 + (j - 1) * 30, Class15.method366("objects" + j + ".dat", 0, abyte0), abyte1, k);
        }

        aClass6_Sub1_724.method228(anInt948);
        aClass6_Sub1_724.method228(anInt948 + 9);
        for(int l = 11; l <= 26; l++)
            aClass6_Sub1_724.method228(anInt948 + l);

        for(int i1 = 0; i1 < Class1.anInt108; i1++)
            aClass6_Sub1_724.method228(anInt951 + i1);

        for(int j1 = 0; j1 < Class1.anInt76; j1++)
            aClass6_Sub1_724.method228(anInt950 + j1);

    }

    protected final byte[] method18(String s, String s1, int i)
    {
        if(!aBoolean979)
            s = "data/" + s;
        byte abyte0[] = Class8.method265(s);
        if(abyte0 != null)
        {
            int j = ((abyte0[0] & 0xff) << 16) + ((abyte0[1] & 0xff) << 8) + (abyte0[2] & 0xff);
            int k = ((abyte0[3] & 0xff) << 16) + ((abyte0[4] & 0xff) << 8) + (abyte0[5] & 0xff);
            byte abyte1[] = new byte[abyte0.length - 6];
            for(int l = 0; l < abyte0.length - 6; l++)
                abyte1[l] = abyte0[l + 6];

            method15(i, "Unpacking " + s1);
            if(k != j)
            {
                byte abyte2[] = new byte[j];
                Class3.method130(abyte2, j, abyte1, k, 0);
                return abyte2;
            } else
            {
                return abyte1;
            }
        } else
        {
            return super.method18(s, s1, i);
        }
    }

    protected final Socket method19(String s, int i)throws IOException
    {
        if(Class8.anApplet370 != null)
        {
            Socket socket = Class8.method266(i);
            if(socket == null)
                throw new IOException();
            else
                return socket;
        }
        Socket socket1;
        if(method7())
            socket1 = new Socket(InetAddress.getByName(getCodeBase().getHost()), i);
        else
            socket1 = new Socket(InetAddress.getByName(s), i);
        socket1.setSoTimeout(30000);
        socket1.setTcpNoDelay(true);
        return socket1;
    }

    protected final void method2()
    {
        if(aBoolean666)
            return;
        if(aBoolean890)
            return;
        if(aBoolean922)
            return;
        try
        {
            anInt918++;
            if(anInt947 == 0)
                method57();
            if(anInt947 == 1)
                method82();
            super.anInt36 = 0;
            super.anInt38 = 0;
            anInt902++;
            if(anInt902 > 500)
            {
                anInt902 = 0;
                int i = (int)(Math.random() * 4D);
                if((i & 1) == 1)
                    anInt895 += anInt896;
                if((i & 2) == 2)
                    anInt973 += anInt974;
            }
            if(anInt895 < -50)
                anInt896 = 2;
            if(anInt895 > 50)
                anInt896 = -2;
            if(anInt973 < -50)
                anInt974 = 2;
            if(anInt973 > 50)
                anInt974 = -2;
            if(anInt790 > 0)
                anInt790--;
            if(anInt791 > 0)
                anInt791--;
            if(anInt792 > 0)
                anInt792--;
            if(anInt793 > 0)
            {
                anInt793--;
                return;
            }
        }
        catch(OutOfMemoryError _ex)
        {
            method85();
            aBoolean890 = true;
        }
    }

    protected final void method20(Runnable runnable)
    {
        if(Class8.anApplet370 != null)
        {
            Class8.method267(runnable);
            return;
        }
        else
        {
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            thread.start();
            return;
        }
    }

    protected final void method23()
    {
        anInt749 = 0;
        if(anInt746 != 0)
        {
            method39();
            return;
        }
        else
        {
            super.method23();
            return;
        }
    }

    protected final void method3()
    {
        method22();
        method85();
        if(anInputStream_Sub1_901 != null)
            anInputStream_Sub1_901.method122();
    }

    protected final void method36(String s, String s1)
    {
        if(anInt690 == 1)
            aClass4_667.method169(anInt732, s + " " + s1);
        if(anInt690 == 2)
            aClass4_751.method169(anInt864, s + " " + s1);
        aString862 = s1;
        method70();
        method9();
    }

    protected final void method38()
    {
        int l1 = Class1.anInt144;
        anInt749 = 0;
        anInt750 = 0;
        anInt746 = 0;
        anInt690 = 0;
        anInt947 = 1;
        method66();
        aClass6_Sub1_724.method212();
        aClass6_Sub1_724.method211(aGraphics857, 0, 0);
        for(int i = 0; i < anInt796; i++)
        {
            aClass10_739.method270(aClass5Array814[i]);
            aClass19_883.method434(anIntArray760[i], anIntArray761[i], anIntArray762[i]);
        }

        for(int j = 0; j < anInt855; j++)
        {
            aClass10_739.method270(aClass5Array781[j]);
            aClass19_883.method427(anIntArray747[j], anIntArray748[j], anIntArray740[j], anIntArray741[j]);
        }
        anInt796 = 0;
        anInt855 = 0;
        anInt823 = 0;
        anInt742 = 0;
        for(int k = 0; k < 4000; k++)
            aClass2Array891[k] = null;
        for(int l = 0; l < 500; l++)
            aClass2Array983[l] = null;
        anInt905 = 0;
        for(int i1 = 0; i1 < 5000; i1++)
            aClass2Array957[i1] = null;
        for(int j1 = 0; j1 < 500; j1++)
            aClass2Array768[j1] = null;
        for(int k1 = 0; k1 < 50; k1++)
            aBooleanArray679[k1] = false;
        anInt813 = 0;
        super.anInt36 = 0;
        super.anInt35 = 0;
        aBoolean727 = false;
        aBoolean879 = false;
        aBoolean870 = false;
        super.anInt624 = 0;
    }

    protected final void method39()
    {
        anInt749 = 0;
        anInt690 = 0;
        anInt947 = 0;
        anInt746 = 0;
    }

    protected final void method4()
    {
        if(aBoolean922 || aBoolean666 || aBoolean890)
        {
            int i = 20;
            Graphics g = getGraphics();
            g.setColor(Color.black);
            g.fillRect(0, 0, 512, 356);
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            g.setFont(new Font("Helvetica", 1, 16));
            g.setColor(Color.yellow);
            i += 100;
            g.drawString("Sorry, an error has occured while loading Skulltorcha", 30, i);
            i += 30;
            g.setColor(Color.white);
            g.setFont(new Font("Helvetica", 1, 12));
            g.drawString("Check you have the jag and mem files installed correctly,", 30, i);
            i += 30;
            g.drawString("They must be EXTRACTED to the Data folder, with no", 30, i);
            i += 30;
            g.drawString("sub folders in the way. Check www.rei-net.org forums for", 30, i);
            i += 30;
            g.drawString("more details. Be sure to read the stickies.", 30, i);
            i += 30;
            method8(1);
            return;
        }
        try
        {
            if(anInt947 == 0)
            {
                aClass6_Sub1_724.aBoolean338 = false;
                method70();
            }
            if(anInt947 == 1)
            {
                if(gfx || aBoolean870)
                {
                    aClass6_Sub1_724.aBoolean338 = true;
                    method108();
                }
                else
                {
                    aClass6_Sub1_724.method221();
                    aClass6_Sub1_724.method255("GFX turned off...", anInt676 / 2, (anInt677 / 2) - 10, 7, 0xff0000);
                    aClass6_Sub1_724.method255("Fatigue: " + getfatigue() + "%", anInt676 / 2, (anInt677 / 2) + 10, 7, 0xff0000);
                    aClass6_Sub1_724.method255("Hits: " + currentlvl(3) + "/" + maxlvl(3), anInt676 / 2, (anInt677 / 2) + 30, 7, 0xff0000);
                    if(aBoolean870)
                        aClass6_Sub1_724.method255("@whi@Sleeping!", anInt676 / 2, (anInt677 / 2) + 30, 7, 0xff0000);
                    method69();
                    aClass6_Sub1_724.method211(aGraphics857, 0, 0);
                }
                return;
            }
        }
        catch(OutOfMemoryError _ex)
        {
            method85();
            aBoolean890 = true;
        }
    }

    protected final void method40()
    {
        anInt746 = 0;
        method118("@cya@Come back you p33n0r", 3);
    }

    protected final void method41(int i, int j, byte abyte0[])
    {
        int l44 = Class1.anInt144;
        try
        {
            if(i == 141)
            {
                anInt743 = anInt742;
                for(int k = 0; k < anInt743; k++)
                    aClass2Array923[k] = aClass2Array983[k];
                int k7 = 8;
                anInt976 = Class15.method359(abyte0, k7, 11);
                k7 += 11;
                anInt977 = Class15.method359(abyte0, k7, 13);
                k7 += 13;
                int l13 = Class15.method359(abyte0, k7, 4);
                k7 += 4;
                boolean flag1 = method98(anInt976, anInt977);
                anInt976 -= anInt783;
                anInt977 -= anInt784;
                int l22 = anInt976 * anInt946 + 64;
                int l25 = anInt977 * anInt946 + 64;
                if(flag1)
                {
                    aClass2_975.anInt156 = 0;
                    aClass2_975.anInt155 = 0;
                    aClass2_975.anInt149 = aClass2_975.anIntArray157[0] = l22;
                    aClass2_975.anInt150 = aClass2_975.anIntArray158[0] = l25;
                }
                anInt742 = 0;
                aClass2_975 = method76(anInt978, l22, l25, l13);
                int i29 = Class15.method359(abyte0, k7, 8);
                k7 += 8;
                for(int l33 = 0; l33 < i29; l33++)
                {
                    Class2 class2_3 = aClass2Array923[l33 + 1];
                    int k39 = Class15.method359(abyte0, k7, 1);
                    k7++;
                    if(k39 != 0)
                    {
                        int k41 = Class15.method359(abyte0, k7, 1);
                        k7++;
                        if(k41 == 0)
                        {
                            int l42 = Class15.method359(abyte0, k7, 3);
                            k7 += 3;
                            int l43 = class2_3.anInt156;
                            int j44 = class2_3.anIntArray157[l43];
                            int k44 = class2_3.anIntArray158[l43];
                            if(l42 == 2 || l42 == 1 || l42 == 3)
                                j44 += anInt946;
                            if(l42 == 6 || l42 == 5 || l42 == 7)
                                j44 -= anInt946;
                            if(l42 == 4 || l42 == 3 || l42 == 5)
                                k44 += anInt946;
                            if(l42 == 0 || l42 == 1 || l42 == 7)
                                k44 -= anInt946;
                            class2_3.anInt154 = l42;
                            class2_3.anInt156 = l43 = (l43 + 1) % 10;
                            class2_3.anIntArray157[l43] = j44;
                            class2_3.anIntArray158[l43] = k44;
                        }
                        else
                        {
                            int i43 = Class15.method359(abyte0, k7, 4);
                            if((i43 & 0xc) == 12)
                            {
                                k7 += 2;
                                continue;
                            }
                            class2_3.anInt154 = Class15.method359(abyte0, k7, 4);
                            k7 += 4;
                        }
                    }
                    aClass2Array983[anInt742++] = class2_3;
                }
                int i37 = 0;
                while(k7 + 24 < j * 8) 
                {
                    int l39 = Class15.method359(abyte0, k7, 11);
                    k7 += 11;
                    int l41 = Class15.method359(abyte0, k7, 5);
                    k7 += 5;
                    if(l41 > 15)
                        l41 -= 32;
                    int j43 = Class15.method359(abyte0, k7, 5);
                    k7 += 5;
                    if(j43 > 15)
                        j43 -= 32;
                    int i14 = Class15.method359(abyte0, k7, 4);
                    k7 += 4;
                    int i44 = Class15.method359(abyte0, k7, 1);
                    k7++;
                    int i23 = (anInt976 + l41) * anInt946 + 64;
                    int i26 = (anInt977 + j43) * anInt946 + 64;
                    method76(l39, i23, i26, i14);
                    if(i44 == 0)
                        anIntArray815[i37++] = l39;
                }
                if(i37 > 0)
                {
                    super.aClass14_Sub1_620.method331(241);
                    super.aClass14_Sub1_620.method343(i37);
                    for(int i40 = 0; i40 < i37; i40++)
                    {
                        Class2 class2_4 = aClass2Array891[anIntArray815[i40]];
                        super.aClass14_Sub1_620.method343(class2_4.anInt147);
                        super.aClass14_Sub1_620.method343(class2_4.anInt148);
                    }
                    super.aClass14_Sub1_620.method346();
                    i37 = 0;
                }
                return;
            }
            if(i == 172)
            {
                for(int l = 1; l < j;)
                    if(Class15.method353(abyte0[l]) == 255)
                    {
                        int l7 = 0;
                        int j14 = anInt976 + abyte0[l + 1] >> 3;
                        int i19 = anInt977 + abyte0[l + 2] >> 3;
                        l += 3;
                        for(int j23 = 0; j23 < anInt823; j23++)
                        {
                            int j26 = (anIntArray770[j23] >> 3) - j14;
                            int j29 = (anIntArray771[j23] >> 3) - i19;
                            if(j26 != 0 || j29 != 0)
                            {
                                if(j23 != l7)
                                {
                                    anIntArray770[l7] = anIntArray770[j23];
                                    anIntArray771[l7] = anIntArray771[j23];
                                    anIntArray772[l7] = anIntArray772[j23];
                                    anIntArray773[l7] = anIntArray773[j23];
                                }
                                l7++;
                            }
                        }
                        anInt823 = l7;
                    }
                    else
                    {
                        int i8 = Class15.method354(abyte0, l);
                        l += 2;
                        int k14 = anInt976 + abyte0[l++];
                        int j19 = anInt977 + abyte0[l++];
                        if((i8 & 0x8000) == 0)
                        {
                            anIntArray770[anInt823] = k14;
                            anIntArray771[anInt823] = j19;
                            anIntArray772[anInt823] = i8;
                            anIntArray773[anInt823] = 0;
                            for(int k23 = 0; k23 < anInt796; k23++)
                            {
                                if(anIntArray760[k23] != k14 || anIntArray761[k23] != j19)
                                    continue;
                                anIntArray773[anInt823] = Class1.anIntArray66[anIntArray762[k23]];
                                break;
                            }
                            anInt823++;
                        }
                        else
                        {
                            i8 &= 0x7fff;
                            int l23 = 0;
                            for(int k26 = 0; k26 < anInt823; k26++)
                                if(anIntArray770[k26] != k14 || anIntArray771[k26] != j19 || anIntArray772[k26] != i8)
                                {
                                    if(k26 != l23)
                                    {
                                        anIntArray770[l23] = anIntArray770[k26];
                                        anIntArray771[l23] = anIntArray771[k26];
                                        anIntArray772[l23] = anIntArray772[k26];
                                        anIntArray773[l23] = anIntArray773[k26];
                                    }
                                    l23++;
                                }
                                else
                                    i8 = -123;
                            anInt823 = l23;
                        }
                    }
                return;
            }
            if(i == 158)
            {
                for(int i1 = 1; i1 < j;)
                    if(Class15.method353(abyte0[i1]) == 255)
                    {
                        int j8 = 0;
                        int l14 = anInt976 + abyte0[i1 + 1] >> 3;
                        int k19 = anInt977 + abyte0[i1 + 2] >> 3;
                        i1 += 3;
                        for(int i24 = 0; i24 < anInt796; i24++)
                        {
                            int l26 = (anIntArray760[i24] >> 3) - l14;
                            int k29 = (anIntArray761[i24] >> 3) - k19;
                            if(l26 != 0 || k29 != 0)
                            {
                                if(i24 != j8)
                                {
                                    aClass5Array814[j8] = aClass5Array814[i24];
                                    aClass5Array814[j8].anInt257 = j8;
                                    anIntArray760[j8] = anIntArray760[i24];
                                    anIntArray761[j8] = anIntArray761[i24];
                                    anIntArray762[j8] = anIntArray762[i24];
                                    anIntArray763[j8] = anIntArray763[i24];
                                }
                                j8++;
                            }
                            else
                            {
                                aClass10_739.method270(aClass5Array814[i24]);
                                aClass19_883.method434(anIntArray760[i24], anIntArray761[i24], anIntArray762[i24]);
                            }
                        }
                        anInt796 = j8;
                    }
                    else
                    {
                        int k8 = Class15.method354(abyte0, i1);
                        i1 += 2;
                        int i15 = anInt976 + abyte0[i1++];
                        int l19 = anInt977 + abyte0[i1++];
                        int j24 = 0;
                        for(int i27 = 0; i27 < anInt796; i27++)
                            if(anIntArray760[i27] != i15 || anIntArray761[i27] != l19)
                            {
                                if(i27 != j24)
                                {
                                    aClass5Array814[j24] = aClass5Array814[i27];
                                    aClass5Array814[j24].anInt257 = j24;
                                    anIntArray760[j24] = anIntArray760[i27];
                                    anIntArray761[j24] = anIntArray761[i27];
                                    anIntArray762[j24] = anIntArray762[i27];
                                    anIntArray763[j24] = anIntArray763[i27];
                                }
                                j24++;
                            }
                            else
                            {
                                aClass10_739.method270(aClass5Array814[i27]);
                                aClass19_883.method434(anIntArray760[i27], anIntArray761[i27], anIntArray762[i27]);
                            }
                            
                        anInt796 = j24;
                        if(k8 != 60000)
                        {
                            int l29 = aClass19_883.method402(i15, l19);
                            int i34;
                            int j37;
                            if(l29 == 0 || l29 == 4)
                            {
                                i34 = Class1.anIntArray63[k8];
                                j37 = Class1.anIntArray64[k8];
                            }
                            else
                            {
                                j37 = Class1.anIntArray63[k8];
                                i34 = Class1.anIntArray64[k8];
                            }
                            int j40 = ((i15 + i15 + i34) * anInt946) / 2;
                            int i42 = ((l19 + l19 + j37) * anInt946) / 2;
                            int k43 = Class1.anIntArray62[k8];
                            Class5 class5_1 = aClass5Array994[k43].method204();
                            aClass10_739.method269(class5_1);
                            class5_1.anInt257 = anInt796;
                            class5_1.method189(0, l29 * 32, 0);
                            class5_1.method191(j40, -aClass19_883.method421(j40, i42), i42);
                            class5_1.method185(true, 48, 48, -50, -10, -50);
                            aClass19_883.method407(i15, l19, k8);
                            if(k8 == 74)
                                class5_1.method191(0, -480, 0);
                            anIntArray760[anInt796] = i15;
                            anIntArray761[anInt796] = l19;
                            anIntArray762[anInt796] = k8;
                            anIntArray763[anInt796] = l29;
                            aClass5Array814[anInt796++] = class5_1;
                        }
                    }
                return;
            }
            if(i == 37)
            {
                int j1 = 1;
                anInt708 = abyte0[j1++] & 0xff;
                for(int l8 = 0; l8 < anInt708; l8++)
                {
                    int j15 = Class15.method354(abyte0, j1);
                    j1 += 2;
                    anIntArray709[l8] = j15 & 0x7fff;
                    anIntArray711[l8] = j15 / 32768;
                    if(Class1.anIntArray55[j15 & 0x7fff] == 0)
                    {
                        anIntArray710[l8] = Class15.method358(abyte0, j1);
                        if(anIntArray710[l8] >= 128)
                            j1 += 4;
                        else
                            j1++;
                    }
                    else
                        anIntArray710[l8] = 1;
                }
                return;
            }
            if(i == 183)
            {
                int k1 = Class15.method354(abyte0, 1);
                int i9 = 3;
                for(int k15 = 0; k15 < k1; k15++)
                {
                    int i20 = Class15.method354(abyte0, i9);
                    i9 += 2;
                    Class2 class2 = aClass2Array891[i20];
                    byte byte6 = abyte0[i9];
                    i9++;
                    if(byte6 == 0)
                    {
                        int i30 = Class15.method354(abyte0, i9);
                        i9 += 2;
                        if(class2 != null)
                        {
                            class2.anInt163 = 150;
                            class2.anInt162 = i30;
                        }
                    }
                    else if(byte6 == 1)
                    {
                        byte byte7 = abyte0[i9];
                        i9++;
                        if(class2 != null)
                        {
                            String s2 = Class16.method374(Class17.method399(abyte0, i9, byte7));
                            boolean flag3 = false;
                            for(int k40 = 0; k40 < super.anInt627; k40++)
                                if(super.aLongArray628[k40] == class2.aLong145)
                                    flag3 = true;
                            if(!flag3)
                            {
                                class2.anInt161 = 150;
                                class2.aString160 = s2;
                                String chat = gettime() + " - " + class2.aString146 + " : " + s2;
                                method118(chat, 2);
                                try{checkformod(class2.aString146,class2.aString160,false);}
                                catch(Exception e){}
                                addlog(chat);
                            }
                        }
                        i9 += byte7;
                    }
                    else if(byte6 == 2)
                    {
                        int j30 = Class15.method353(abyte0[i9]);
                        i9++;
                        int j34 = Class15.method353(abyte0[i9]);
                        i9++;
                        int k37 = Class15.method353(abyte0[i9]);
                        i9++;
                        if(class2 != null)
                        {
                            class2.anInt164 = j30;
                            class2.anInt165 = j34;
                            class2.anInt166 = k37;
                            class2.anInt167 = 200;
                            if(class2 == aClass2_975)
                            {
                                anIntArray728[3] = j34;
                                anIntArray825[3] = k37;
                                aBoolean908 = false;
                                aBoolean745 = false;
                            }
                        }
                    }
                    else if(byte6 == 3)
                    {
                        int k30 = Class15.method354(abyte0, i9);
                        i9 += 2;
                        int k34 = Class15.method354(abyte0, i9);
                        i9 += 2;
                        if(class2 != null)
                        {
                            class2.anInt173 = k30;
                            class2.anInt175 = k34;
                            class2.anInt174 = -1;
                            class2.anInt176 = anInt897;
                        }
                    }
                    else if(byte6 == 4)
                    {
                        int l30 = Class15.method354(abyte0, i9);
                        i9 += 2;
                        int l34 = Class15.method354(abyte0, i9);
                        i9 += 2;
                        if(class2 != null)
                        {
                            class2.anInt173 = l30;
                            class2.anInt174 = l34;
                            class2.anInt175 = -1;
                            class2.anInt176 = anInt897;
                        }
                    }
                    else if(byte6 == 5)
                    {
                        if(class2 != null)
                        {
                            class2.anInt148 = Class15.method354(abyte0, i9);
                            i9 += 2;
                            class2.aLong145 = Class15.method356(abyte0, i9);
                            i9 += 8;
                            class2.aString146 = Class15.method363(class2.aLong145);
                            int i31 = Class15.method353(abyte0[i9]);
                            i9++;
                            for(int i35 = 0; i35 < i31; i35++)
                            {
                                class2.anIntArray159[i35] = Class15.method353(abyte0[i9]);
                                i9++;
                            }
                            for(int l37 = i31; l37 < 12; l37++)
                                class2.anIntArray159[l37] = 0;
                            class2.anInt169 = abyte0[i9++] & 0xff;
                            class2.anInt170 = abyte0[i9++] & 0xff;
                            class2.anInt171 = abyte0[i9++] & 0xff;
                            class2.anInt172 = abyte0[i9++] & 0xff;
                            class2.anInt168 = abyte0[i9++] & 0xff;
                            class2.anInt179 = abyte0[i9++] & 0xff;
                        }
                        else
                        {
                            i9 += 14;
                            int j31 = Class15.method353(abyte0[i9]);
                            i9 += j31 + 1;
                        }
                    }
                    else if(byte6 == 6)
                    {
                        byte byte8 = abyte0[i9];
                        i9++;
                        if(class2 != null)
                        {
                            String s3 = Class17.method399(abyte0, i9, byte8);
                            class2.anInt161 = 150;
                            class2.aString160 = s3;
                            if(class2 == aClass2_975)
                                method118(gettime() + " - " + class2.aString146 + ": " + class2.aString160, 5);
                        }
                        i9 += byte8;
                    }
                }
                return;
            }
            if(i == 29)
            {
                for(int l1 = 1; l1 < j;)
                    if(Class15.method353(abyte0[l1]) == 255)
                    {
                        int j9 = 0;
                        int l15 = anInt976 + abyte0[l1 + 1] >> 3;
                        int j20 = anInt977 + abyte0[l1 + 2] >> 3;
                        l1 += 3;
                        for(int k24 = 0; k24 < anInt855; k24++)
                        {
                            int j27 = (anIntArray747[k24] >> 3) - l15;
                            int k31 = (anIntArray748[k24] >> 3) - j20;
                            if(j27 != 0 || k31 != 0)
                            {
                                if(k24 != j9)
                                {
                                    aClass5Array781[j9] = aClass5Array781[k24];
                                    aClass5Array781[j9].anInt257 = j9 + 10000;
                                    anIntArray747[j9] = anIntArray747[k24];
                                    anIntArray748[j9] = anIntArray748[k24];
                                    anIntArray740[j9] = anIntArray740[k24];
                                    anIntArray741[j9] = anIntArray741[k24];
                                }
                                j9++;
                            }
                            else
                            {
                                aClass10_739.method270(aClass5Array781[k24]);
                                aClass19_883.method427(anIntArray747[k24], anIntArray748[k24], anIntArray740[k24], anIntArray741[k24]);
                            }
                        }
                        anInt855 = j9;
                    }
                    else
                    {
                        int k9 = Class15.method354(abyte0, l1);
                        l1 += 2;
                        int i16 = anInt976 + abyte0[l1++];
                        int k20 = anInt977 + abyte0[l1++];
                        byte byte5 = abyte0[l1++];
                        int k27 = 0;
                        for(int l31 = 0; l31 < anInt855; l31++)
                            if(anIntArray747[l31] != i16 || anIntArray748[l31] != k20 || anIntArray740[l31] != byte5)
                            {
                                if(l31 != k27)
                                {
                                    aClass5Array781[k27] = aClass5Array781[l31];
                                    aClass5Array781[k27].anInt257 = k27 + 10000;
                                    anIntArray747[k27] = anIntArray747[l31];
                                    anIntArray748[k27] = anIntArray748[l31];
                                    anIntArray740[k27] = anIntArray740[l31];
                                    anIntArray741[k27] = anIntArray741[l31];
                                }
                                k27++;
                            }
                            else
                            {
                                aClass10_739.method270(aClass5Array781[l31]);
                                aClass19_883.method427(anIntArray747[l31], anIntArray748[l31], anIntArray740[l31], anIntArray741[l31]);
                            }
                        anInt855 = k27;
                        if(k9 != 65535)
                        {
                            aClass19_883.method415(i16, k20, byte5, k9);
                            Class5 class5 = method106(i16, k20, byte5, k9, anInt855);
                            aClass5Array781[anInt855] = class5;
                            anIntArray747[anInt855] = i16;
                            anIntArray748[anInt855] = k20;
                            anIntArray741[anInt855] = k9;
                            anIntArray740[anInt855++] = byte5;
                        }
                    }
                return;
            }
            if(i == 41)
            {
                anInt906 = anInt905;
                anInt905 = 0;
                for(int i2 = 0; i2 < anInt906; i2++)
                    aClass2Array822[i2] = aClass2Array768[i2];

                int l9 = 8;
                int j16 = Class15.method359(abyte0, l9, 8);
                l9 += 8;
                for(int l20 = 0; l20 < j16; l20++)
                {
                    Class2 class2_1 = aClass2Array822[l20];
                    int l27 = Class15.method359(abyte0, l9, 1);
                    l9++;
                    if(l27 != 0)
                    {
                        int i32 = Class15.method359(abyte0, l9, 1);
                        l9++;
                        if(i32 == 0)
                        {
                            int j35 = Class15.method359(abyte0, l9, 3);
                            l9 += 3;
                            int i38 = class2_1.anInt156;
                            int l40 = class2_1.anIntArray157[i38];
                            int j42 = class2_1.anIntArray158[i38];
                            if(j35 == 2 || j35 == 1 || j35 == 3)
                                l40 += anInt946;
                            if(j35 == 6 || j35 == 5 || j35 == 7)
                                l40 -= anInt946;
                            if(j35 == 4 || j35 == 3 || j35 == 5)
                                j42 += anInt946;
                            if(j35 == 0 || j35 == 1 || j35 == 7)
                                j42 -= anInt946;
                            class2_1.anInt154 = j35;
                            class2_1.anInt156 = i38 = (i38 + 1) % 10;
                            class2_1.anIntArray157[i38] = l40;
                            class2_1.anIntArray158[i38] = j42;
                        }
                        else
                        {
                            int k35 = Class15.method359(abyte0, l9, 4);
                            if((k35 & 0xc) == 12)
                            {
                                l9 += 2;
                                continue;
                            }
                            class2_1.anInt154 = Class15.method359(abyte0, l9, 4);
                            l9 += 4;
                        }
                    }
                    aClass2Array768[anInt905++] = class2_1;
                }
                while(l9 + 34 < j * 8) 
                {
                    int l24 = Class15.method359(abyte0, l9, 12);
                    l9 += 12;
                    int i28 = Class15.method359(abyte0, l9, 5);
                    l9 += 5;
                    if(i28 > 15)
                        i28 -= 32;
                    int j32 = Class15.method359(abyte0, l9, 5);
                    l9 += 5;
                    if(j32 > 15)
                        j32 -= 32;
                    int l35 = Class15.method359(abyte0, l9, 4);
                    l9 += 4;
                    int j38 = (anInt976 + i28) * anInt946 + 64;
                    int i41 = (anInt977 + j32) * anInt946 + 64;
                    int k42 = Class15.method359(abyte0, l9, 10);
                    l9 += 10;
                    if(k42 >= Class1.anInt122)
                        k42 = 24;
                    method107(l24, j38, i41, l35, k42);
                }
                return;
            }
            if(i == 47)
            {
                int j2 = Class15.method354(abyte0, 1);
                int i10 = 3;
                for(int k16 = 0; k16 < j2; k16++)
                {
                    int i21 = Class15.method354(abyte0, i10);
                    i10 += 2;
                    Class2 class2_2 = aClass2Array957[i21];
                    int j28 = Class15.method353(abyte0[i10]);
                    i10++;
                    if(j28 == 1)
                    {
                        int k32 = Class15.method354(abyte0, i10);
                        i10 += 2;
                        byte byte9 = abyte0[i10];
                        i10++;
                        if(class2_2 != null)
                        {
                            String s4 = Class17.method399(abyte0, i10, byte9);
                            class2_2.anInt161 = 150;
                            class2_2.aString160 = s4;
                            if(k32 == aClass2_975.anInt147)
                                method118("@yel@" + gettime() + " - " + Class1.aStringArray127[class2_2.anInt151] + ":" + class2_2.aString160, 5);
                        }
                        i10 += byte9;
                    }
                    else if(j28 == 2)
                    {
                        int l32 = Class15.method353(abyte0[i10]);
                        i10++;
                        int i36 = Class15.method353(abyte0[i10]);
                        i10++;
                        int k38 = Class15.method353(abyte0[i10]);
                        i10++;
                        if(class2_2 != null)
                        {
                            class2_2.anInt164 = l32;
                            class2_2.anInt165 = i36;
                            class2_2.anInt166 = k38;
                            class2_2.anInt167 = 200;
                        }
                    }
                }
                return;
            }
            if(i == 117)
            {
                aBoolean852 = true;
                int k2 = Class15.method353(abyte0[1]);
                anInt929 = k2;
                int j10 = 2;
                for(int l16 = 0; l16 < k2; l16++)
                {
                    int j21 = Class15.method353(abyte0[j10]);
                    j10++;
                    aStringArray913[l16] = new String(abyte0, j10, j21);
                    j10 += j21;
                }
                return;
            }
            if(i == 208)
            {
                aBoolean852 = false;
                return;
            }
            if(i == 249)
            {
                aBoolean717 = true;
                anInt978 = Class15.method354(abyte0, 1);
                anInt806 = Class15.method354(abyte0, 3);
                anInt807 = Class15.method354(abyte0, 5);
                anInt785 = Class15.method354(abyte0, 7);
                anInt808 = Class15.method354(abyte0, 9);
                anInt807 -= anInt785 * anInt808;
                return;
            }
            if(i == 16)
            {
                int l2 = 1;
                for(int k10 = 0; k10 < 18; k10++)
                    anIntArray728[k10] = Class15.method353(abyte0[l2++]);
                for(int i17 = 0; i17 < 18; i17++)
                    anIntArray825[i17] = Class15.method353(abyte0[l2++]);
                for(int k21 = 0; k21 < 18; k21++)
                {
                    anIntArray712[k21] = Class15.method355(abyte0, l2);
                    l2 += 4;
                }
                anInt996 = Class15.method353(abyte0[l2++]);
                return;
            }
            if(i == 33)
            {
                for(int i3 = 0; i3 < 5; i3++)
                    anIntArray797[i3] = Class15.method353(abyte0[1 + i3]);
                return;
            }
            if(i == 109)
            {
                anInt993 = 250;
                return;
            }
            if(i == 76)
            {
                int j3 = (j - 1) / 4;
                for(int l10 = 0; l10 < j3; l10++)
                {
                    int j17 = anInt976 + Class15.method357(abyte0, 1 + l10 * 4) >> 3;
                    int l21 = anInt977 + Class15.method357(abyte0, 3 + l10 * 4) >> 3;
                    int i25 = 0;
                    for(int k28 = 0; k28 < anInt823; k28++)
                    {
                        int i33 = (anIntArray770[k28] >> 3) - j17;
                        int j36 = (anIntArray771[k28] >> 3) - l21;
                        if(i33 != 0 || j36 != 0)
                        {
                            if(k28 != i25)
                            {
                                anIntArray770[i25] = anIntArray770[k28];
                                anIntArray771[i25] = anIntArray771[k28];
                                anIntArray772[i25] = anIntArray772[k28];
                                anIntArray773[i25] = anIntArray773[k28];
                            }
                            i25++;
                        }
                    }
                    anInt823 = i25;
                    i25 = 0;
                    for(int j33 = 0; j33 < anInt796; j33++)
                    {
                        int k36 = (anIntArray760[j33] >> 3) - j17;
                        int l38 = (anIntArray761[j33] >> 3) - l21;
                        if(k36 != 0 || l38 != 0)
                        {
                            if(j33 != i25)
                            {
                                aClass5Array814[i25] = aClass5Array814[j33];
                                aClass5Array814[i25].anInt257 = i25;
                                anIntArray760[i25] = anIntArray760[j33];
                                anIntArray761[i25] = anIntArray761[j33];
                                anIntArray762[i25] = anIntArray762[j33];
                                anIntArray763[i25] = anIntArray763[j33];
                            }
                            i25++;
                        }
                        else
                        {
                            aClass10_739.method270(aClass5Array814[j33]);
                            aClass19_883.method434(anIntArray760[j33], anIntArray761[j33], anIntArray762[j33]);
                        }
                    }
                    anInt796 = i25;
                    i25 = 0;
                    for(int l36 = 0; l36 < anInt855; l36++)
                    {
                        int i39 = (anIntArray747[l36] >> 3) - j17;
                        int j41 = (anIntArray748[l36] >> 3) - l21;
                        if(i39 != 0 || j41 != 0)
                        {
                            if(l36 != i25)
                            {
                                aClass5Array781[i25] = aClass5Array781[l36];
                                aClass5Array781[i25].anInt257 = i25 + 10000;
                                anIntArray747[i25] = anIntArray747[l36];
                                anIntArray748[i25] = anIntArray748[l36];
                                anIntArray740[i25] = anIntArray740[l36];
                                anIntArray741[i25] = anIntArray741[l36];
                            }
                            i25++;
                        }
                        else
                        {
                            aClass10_739.method270(aClass5Array781[l36]);
                            aClass19_883.method427(anIntArray747[l36], anIntArray748[l36], anIntArray740[l36], anIntArray741[l36]);
                        }
                    }
                    anInt855 = i25;
                }
                return;
            }
            if(i == 7)
            {
                aBoolean992 = true;
                return;
            }
            if(i == 108)
            {
                int k3 = Class15.method354(abyte0, 1);
                if(aClass2Array891[k3] != null)
                    aString682 = aClass2Array891[k3].aString146;
                aBoolean856 = true;
                aBoolean944 = false;
                aBoolean945 = false;
                anInt969 = 0;
                anInt886 = 0;
                return;
            }
            if(i == 113)
            {
                aBoolean856 = false;
                aBoolean673 = false;
                return;
            }
            if(i == 155)
            {
                anInt886 = abyte0[1] & 0xff;
                int l3 = 2;
                for(int i11 = 0; i11 < anInt886; i11++)
                {
                    anIntArray887[i11] = Class15.method354(abyte0, l3);
                    l3 += 2;
                    anIntArray888[i11] = Class15.method355(abyte0, l3);
                    l3 += 4;
                }
                aBoolean944 = false;
                aBoolean945 = false;
                return;
            }
            if(i == 185)
            {
                byte byte0 = abyte0[1];
                if(byte0 == 1)
                {
                    aBoolean944 = true;
                    return;
                }
                else
                {
                    aBoolean944 = false;
                    return;
                }
            }
            if(i == 24)
            {
                aBoolean727 = true;
                int i4 = 1;
                int j11 = abyte0[i4++] & 0xff;
                byte byte4 = abyte0[i4++];
                anInt899 = abyte0[i4++] & 0xff;
                anInt900 = abyte0[i4++] & 0xff;
                for(int i22 = 0; i22 < 40; i22++)
                    anIntArray736[i22] = -1;
                for(int j25 = 0; j25 < j11; j25++)
                {
                    anIntArray736[j25] = Class15.method354(abyte0, i4);
                    i4 += 2;
                    anIntArray737[j25] = Class15.method354(abyte0, i4);
                    i4 += 2;
                    anIntArray738[j25] = abyte0[i4++];
                }
                if(byte4 == 1)
                {
                    int l28 = 39;
                    for(int k33 = 0; k33 < anInt708; k33++)
                    {
                        if(l28 < j11)
                            break;
                        boolean flag2 = false;
                        for(int j39 = 0; j39 < 40; j39++)
                        {
                            if(anIntArray736[j39] != anIntArray709[k33])
                                continue;
                            flag2 = true;
                            break;
                        }
                        if(anIntArray709[k33] == 10)
                            flag2 = true;
                        if(!flag2)
                        {
                            anIntArray736[l28] = anIntArray709[k33] & 0x7fff;
                            anIntArray737[l28] = 0;
                            anIntArray738[l28] = 0;
                            l28--;
                        }
                    }
                }
                if(anInt903 >= 0 && anInt903 < 40 && anIntArray736[anInt903] != anInt904)
                {
                    anInt903 = -1;
                    anInt904 = -2;
                }
                return;
            }
            if(i == 42)
            {
                aBoolean727 = false;
                return;
            }
            if(i == 170)
            {
                byte byte1 = abyte0[1];
                if(byte1 == 1)
                {
                    aBoolean945 = true;
                    return;
                }
                else
                {
                    aBoolean945 = false;
                    return;
                }
            }
            if(i == 161)
            {
                aBoolean675 = Class15.method353(abyte0[1]) == 1;
                aBoolean767 = Class15.method353(abyte0[2]) == 1;
                aBoolean853 = Class15.method353(abyte0[3]) == 1;
                return;
            }
            if(i == 222)
            {
                for(int j4 = 0; j4 < j - 1; j4++)
                {
                    boolean flag = abyte0[j4 + 1] == 1;
                    if(!aBooleanArray679[j4] && flag)
                        method97("prayeron");
                    if(aBooleanArray679[j4] && !flag)
                        method97("prayeroff");
                    aBooleanArray679[j4] = flag;
                }
                return;
            }
            if(i == 26)
            {
                for(int k4 = 0; k4 < 50; k4++)
                    aBooleanArray716[k4] = abyte0[k4 + 1] == 1;
                return;
            }
            if(i == 188)
            {
                aBoolean879 = true;
                int l4 = 1;
                anInt936 = abyte0[l4++] & 0xff;
                anInt916 = abyte0[l4++] & 0xff;
                for(int k11 = 0; k11 < anInt936; k11++)
                {
                    anIntArray816[k11] = Class15.method354(abyte0, l4);
                    l4 += 2;
                    anIntArray817[k11] = Class15.method358(abyte0, l4);
                    if(anIntArray817[k11] >= 128)
                        l4 += 4;
                    else
                        l4++;
                }
                method72();
                return;
            }
            if(i == 130)
            {
                aBoolean879 = false;
                return;
            }
            if(i == 69)
            {
                int i5 = abyte0[1] & 0xff;
                old[i5] = anIntArray712[i5];
                anIntArray712[i5] = Class15.method355(abyte0, 2);
                if(anIntArray712[i5] != old[i5])
                    macroexp += (anIntArray712[i5] - old[i5]) / 4;
                return;
            }
            if(i == 240)
            {
                int j5 = Class15.method354(abyte0, 1);
                if(aClass2Array891[j5] != null)
                    aString824 = aClass2Array891[j5].aString146;
                aBoolean917 = true;
                anInt910 = 0;
                anInt959 = 0;
                aBoolean668 = false;
                aBoolean669 = false;
                aBoolean718 = false;
                aBoolean719 = false;
                aBoolean720 = false;
                aBoolean721 = false;
                return;
            }
            if(i == 198)
            {
                aBoolean917 = false;
                aBoolean801 = false;
                return;
            }
            if(i == 128)
            {
                aBoolean673 = true;
                aBoolean674 = false;
                aBoolean856 = false;
                int k5 = 1;
                aLong847 = Class15.method356(abyte0, k5);
                k5 += 8;
                anInt691 = abyte0[k5++] & 0xff;
                for(int l11 = 0; l11 < anInt691; l11++)
                {
                    anIntArray692[l11] = Class15.method354(abyte0, k5);
                    k5 += 2;
                    anIntArray693[l11] = Class15.method355(abyte0, k5);
                    k5 += 4;
                }
                anInt836 = abyte0[k5++] & 0xff;
                for(int k17 = 0; k17 < anInt836; k17++)
                {
                    anIntArray837[k17] = Class15.method354(abyte0, k5);
                    k5 += 2;
                    anIntArray838[k17] = Class15.method355(abyte0, k5);
                    k5 += 4;
                }
                return;
            }
            if(i == 229)
            {
                anInt959 = abyte0[1] & 0xff;
                int l5 = 2;
                for(int i12 = 0; i12 < anInt959; i12++)
                {
                    anIntArray960[i12] = Class15.method354(abyte0, l5);
                    l5 += 2;
                    anIntArray961[i12] = Class15.method355(abyte0, l5);
                    l5 += 4;
                }
                aBoolean668 = false;
                aBoolean669 = false;
                return;
            }
            if(i == 211)
            {
                if(abyte0[1] == 1)
                    aBoolean718 = true;
                else
                    aBoolean718 = false;
                if(abyte0[2] == 1)
                    aBoolean719 = true;
                else
                    aBoolean719 = false;
                if(abyte0[3] == 1)
                    aBoolean720 = true;
                else
                    aBoolean720 = false;
                if(abyte0[4] == 1)
                    aBoolean721 = true;
                else
                    aBoolean721 = false;
                aBoolean668 = false;
                aBoolean669 = false;
                return;
            }
            if(i == 81)
            {
                int i6 = 1;
                int j12 = abyte0[i6++] & 0xff;
                int l17 = Class15.method354(abyte0, i6);
                i6 += 2;
                int j22 = Class15.method358(abyte0, i6);
                if(j22 >= 128)
                    i6 += 4;
                else
                    i6++;
                if(j22 == 0)
                {
                    anInt936--;
                    for(int k25 = j12; k25 < anInt936; k25++)
                    {
                        anIntArray816[k25] = anIntArray816[k25 + 1];
                        anIntArray817[k25] = anIntArray817[k25 + 1];
                    }
                }
                else
                {
                    anIntArray816[j12] = l17;
                    anIntArray817[j12] = j22;
                    if(j12 >= anInt936)
                        anInt936 = j12 + 1;
                }
                method72();
                return;
            }
            if(i == 210)
            {
                int j6 = 1;
                int k12 = 1;
                int i18 = abyte0[j6++] & 0xff;
                int k22 = Class15.method354(abyte0, j6);
                j6 += 2;
                if(Class1.anIntArray55[k22 & 0x7fff] == 0)
                {
                    k12 = Class15.method358(abyte0, j6);
                    if(k12 >= 128)
                        j6 += 4;
                    else
                        j6++;
                }
                anIntArray709[i18] = k22 & 0x7fff;
                anIntArray711[i18] = k22 / 32768;
                anIntArray710[i18] = k12;
                if(i18 >= anInt708)
                    anInt708 = i18 + 1;
                return;
            }
            if(i == 44)
            {
                int k6 = abyte0[1] & 0xff;
                anInt708--;
                for(int l12 = k6; l12 < anInt708; l12++)
                {
                    anIntArray709[l12] = anIntArray709[l12 + 1];
                    anIntArray710[l12] = anIntArray710[l12 + 1];
                    anIntArray711[l12] = anIntArray711[l12 + 1];
                }
                return;
            }
            if(i == 23)
            {
                int l6 = 1;
                int i13 = abyte0[l6++] & 0xff;
                anIntArray728[i13] = Class15.method353(abyte0[l6++]);
                anIntArray825[i13] = Class15.method353(abyte0[l6++]);
                anIntArray712[i13] = Class15.method355(abyte0, l6);
                l6 += 4;
                return;
            }
            if(i == 73)
            {
                byte byte2 = abyte0[1];
                if(byte2 == 1)
                {
                    aBoolean668 = true;
                    return;
                }
                else
                {
                    aBoolean668 = false;
                    return;
                }
            }
            if(i == 131)
            {
                byte byte3 = abyte0[1];
                if(byte3 == 1)
                {
                    aBoolean669 = true;
                    return;
                }
                else
                {
                    aBoolean669 = false;
                    return;
                }
            }
            if(i == 10)
            {
                aBoolean801 = true;
                aBoolean802 = false;
                aBoolean917 = false;
                int i7 = 1;
                aLong907 = Class15.method356(abyte0, i7);
                i7 += 8;
                anInt786 = abyte0[i7++] & 0xff;
                for(int j13 = 0; j13 < anInt786; j13++)
                {
                    anIntArray787[j13] = Class15.method354(abyte0, i7);
                    i7 += 2;
                    anIntArray788[j13] = Class15.method355(abyte0, i7);
                    i7 += 4;
                }
                anInt663 = abyte0[i7++] & 0xff;
                for(int j18 = 0; j18 < anInt663; j18++)
                {
                    anIntArray664[j18] = Class15.method354(abyte0, i7);
                    i7 += 2;
                    anIntArray665[j18] = Class15.method355(abyte0, i7);
                    i7 += 4;
                }
                anInt988 = abyte0[i7++] & 0xff;
                anInt989 = abyte0[i7++] & 0xff;
                anInt990 = abyte0[i7++] & 0xff;
                anInt991 = abyte0[i7++] & 0xff;
                return;
            }
            if(i == 238)
            {
                String s = new String(abyte0, 1, j - 1);
                method97(s);
                return;
            }
            if(i == 253)
            {
                if(anInt833 < 50)
                {
                    int j7 = abyte0[1] & 0xff;
                    int k13 = abyte0[2] + anInt976;
                    int k18 = abyte0[3] + anInt977;
                    anIntArray730[anInt833] = j7;
                    anIntArray972[anInt833] = 0;
                    anIntArray881[anInt833] = k13;
                    anIntArray934[anInt833] = k18;
                    anInt833++;
                }
                return;
            }
            if(i == 126)
            {
                if(!aBoolean849)
                {
                    anInt782 = Class15.method355(abyte0, 1);
                    anInt898 = Class15.method354(abyte0, 5);
                    anInt685 = abyte0[7] & 0xff;
                    anInt924 = Class15.method354(abyte0, 8);
                    aBoolean908 = true;
                    chat("@red@ST:@whi@ Hi " + System.getProperty("user.name") + ", welcome to SkullTorcha - www.rei-net.org");
                    if(aut0 || mag3)
                        setmode(macromode);
                    else
                        setmode(startmode);
                    aBoolean853 = true;
/*                    super.aClass14_Sub1_620.method331(66);
                    super.aClass14_Sub1_620.method348(3);
                    super.aClass14_Sub1_620.method348(1);
                    super.aClass14_Sub1_620.method346();*/
                    aBoolean849 = true;
                    aString894 = null;
                }
                return;
            }
            if(i == 112)
            {
                aString681 = new String(abyte0, 1, j - 1);
                aBoolean745 = true;
                aBoolean680 = false;
                return;
            }
            if(i == 49)
            {
                aString681 = new String(abyte0, 1, j - 1);
                aBoolean745 = true;
                aBoolean680 = true;
                return;
            }
            if(i == 60)
            {
                anInt892 = Class15.method354(abyte0, 1);
                return;
            }
            if(i == 15)
            {
                if(!aBoolean870)
                    anInt893 = anInt892;
                aBoolean870 = true;
                oldword = checkword();
                check = new checker();
                savePic(abyte0);
                super.aString40 = "";
                super.aString41 = "";
                startedSleeping(abyte0);
                aClass6_Sub1_724.method226(anInt952 + 1, abyte0);
                aString846 = null;
                return;
            }
            if(i == 174)
            {
                anInt893 = Class15.method354(abyte0, 1);
                return;
            }
            if(i == 206)
            {
                aBoolean870 = false;
                return;
            }
            if(i == 20)
            {
                aString846 = "Incorrect - Please wait...";
                return;
            }
            if(i == 28)
            {
                anInt749 = Class15.method354(abyte0, 1) * 32;
                return;
            }
        }
        catch(RuntimeException runtimeexception)
        {
            if(anInt933 < 3)
            {
                super.aClass14_Sub1_620.method331(7);
                super.aClass14_Sub1_620.method347(runtimeexception.toString());
                super.aClass14_Sub1_620.method346();
                super.aClass14_Sub1_620.method331(7);
                super.aClass14_Sub1_620.method347("p-type:" + i + " p-size:" + j);
                super.aClass14_Sub1_620.method346();
                super.aClass14_Sub1_620.method331(7);
                super.aClass14_Sub1_620.method347("rx:" + anInt976 + " ry:" + anInt977 + " num3l:" + anInt796);
                super.aClass14_Sub1_620.method346();
                String s1 = "";
                for(int l18 = 0; l18 < 80 && l18 < j; l18++)
                    s1 = s1 + abyte0[l18] + " ";
                super.aClass14_Sub1_620.method331(7);
                super.aClass14_Sub1_620.method347(s1);
                super.aClass14_Sub1_620.method346();
                anInt933++;
            }
        }
    }

    protected final void method42(String s)
    {
        if(s.startsWith("@bor@"))
        {
            method118(gettime() + " - " + s, 4);
            addlog(gettime() + " - " + s);
            return;
        }
        if(s.startsWith("@que@"))
        {
            method118("@whi@" + gettime() + " - " + s, 5);
            addlog(gettime() + " - " + s);
            return;
        }
        if(s.startsWith("@pri@"))
        {
            method118(gettime() + " - " + s, 6);
            addlog(gettime() + " - " + s);
            return;
        }
        else
        {
            method118(s, 3);
            return;
        }
    }

    protected final int method44()
    {
        return (int)(Math.random() * 99999999D);
    }

    public static final void main(String as[])
    {
        mudclient mudclient1 = new mudclient();
        mudclient1.aBoolean979 = false;
        if(as.length > 0 && as[0].equals("members"))
            mudclient1.aBoolean914 = true;
        if(as.length > 1)
            mudclient1.aString616 = as[1];
        if(as.length > 2)
            mudclient1.anInt617 = Integer.parseInt(as[2]);
        mudclient1.method6(mudclient1.anInt676, mudclient1.anInt677 + 11, "Runescape by Andrew Gower", false);
        mudclient1.anInt32 = 10;
    }

    private final void method46()//quest menu
    {
        int l = Class1.anInt144;
        if(anInt813 != 0)
        {
            for(int i = 0; i < anInt929; i++)
            {
                if(super.anInt33 >= aClass6_Sub1_724.method263(aStringArray913[i], 1) || super.anInt34 <= i * 12 || super.anInt34 >= 12 + i * 12)
                    continue;
                super.aClass14_Sub1_620.method331(189);
                super.aClass14_Sub1_620.method348(i);
                super.aClass14_Sub1_620.method346();
                break;
            }
            anInt813 = 0;
            aBoolean852 = false;
            return;
        }
        for(int j = 0; j < anInt929; j++)
        {
            int k = 65535;
            if(super.anInt33 < aClass6_Sub1_724.method263(aStringArray913[j], 1) && super.anInt34 > j * 12 && super.anInt34 < 12 + j * 12)
                k = 0xff0000;
            aClass6_Sub1_724.method257(aStringArray913[j], 6, 12 + j * 12, 1, k);
        }
    }

    private final void method47()
    {
        if(super.aString41.length() > 0)
        {
            String s = super.aString41.trim();
            super.aString40 = "";
            super.aString41 = "";
            if(s.length() > 0)
            {
                long l = Class15.method362(s);
                super.aClass14_Sub1_620.method331(215);
                super.aClass14_Sub1_620.method342(l);
                super.aClass14_Sub1_620.method348(anInt863);
                super.aClass14_Sub1_620.method348(aBoolean810 ? 1 : 0);
                super.aClass14_Sub1_620.method346();
            }
            anInt986 = 0;
            return;
        }
        aClass6_Sub1_724.method216(56, 130, 400, 100, 0);
        aClass6_Sub1_724.method217(56, 130, 400, 100, 0xffffff);
        int i = 160;
        aClass6_Sub1_724.method255("Now type the name of the offending player, and press enter", 256, i, 1, 0xffff00);
        i += 18;
        aClass6_Sub1_724.method255("Name: " + super.aString40 + "*", 256, i, 4, 0xffffff);
        if(super.anInt637 > 0)
        {
            i = 207;
            if(aBoolean810)
                aClass6_Sub1_724.method255("Moderator option: Mute player for 48 hours: <ON>", 256, i, 1, 0xff8000);
            else
                aClass6_Sub1_724.method255("Moderator option: Mute player for 48 hours: <OFF>", 256, i, 1, 0xffffff);
            if(super.anInt33 > 106 && super.anInt33 < 406 && super.anInt34 > i - 13 && super.anInt34 < i + 2 && anInt813 == 1)
            {
                anInt813 = 0;
                aBoolean810 = !aBoolean810;
            }
        }
        i = 222;
        int j = 0xffffff;
        if(super.anInt33 > 196 && super.anInt33 < 316 && super.anInt34 > i - 13 && super.anInt34 < i + 2)
        {
            j = 0xffff00;
            if(anInt813 == 1)
            {
                anInt813 = 0;
                anInt986 = 0;
            }
        }
        aClass6_Sub1_724.method255("Click here to cancel", 256, i, 1, j);
        if(anInt813 == 1 && (super.anInt33 < 56 || super.anInt33 > 456 || super.anInt34 < 130 || super.anInt34 > 230))
        {
            anInt813 = 0;
            anInt986 = 0;
        }
    }

    private static final String method48(int i)
    {
        int k = Class1.anInt144;
        String s = String.valueOf(i);
        for(int j = s.length() - 3; j > 0; j -= 3)
            s = s.substring(0, j) + "," + s.substring(j);
        if(s.length() > 8)
            s = "@gre@" + s.substring(0, s.length() - 8) + " million @whi@(" + s + ")";
        else if(s.length() > 4)
            s = "@cya@" + s.substring(0, s.length() - 4) + "K @whi@(" + s + ")";
        return s;
    }
    public int getSleepingFatigue() { 
return (anInt893 * 100) / 750; 
}

public File HCPath = new File("./HC.bmp");
public File SLPath = new File("./slword.txt"); 
    public void sendWord(String word) {
                super.aClass14_Sub1_620.method331(142);
                super.aClass14_Sub1_620.method347(word);
                super.aClass14_Sub1_620.method346();
                super.aString40 = "";
                super.aString41 = "";
                aString846 = "Please wait...";
    }

    public void startedSleeping(byte[] pic) {
        try {
            if (!SLPath.exists()) 
                SLPath.createNewFile();
            word = "NOT-YET-RECIEVED";
            slLastMod = SLPath.lastModified();
            lastSentSleepReq = 0;
            savePic(pic);
        } catch(Exception e) {}
    }
    public long slLastMod=0, lastSentSleepReq=0;
    public long lastChecked=0;
    public String word = "NOT-YET-RECIEVED";
    public void CheckWords(){
    if(aBoolean870){
                if (word.equals("NOT-YET-RECIEVED")) {
                    if (lastChecked+500 < System.currentTimeMillis() && SLPath.lastModified() != slLastMod) {
                        lastChecked = System.currentTimeMillis();
                        slLastMod = SLPath.lastModified();
                        try {
                            word = new BufferedReader(new FileReader(SLPath)).readLine();
                            System.out.println("The word is " + word);
                            
                        } catch (Exception e) {}
                    }
                }
                else  if (getSleepingFatigue() < 4) {
                    System.out.println("Sending word " + word);
                    sendWord(word.trim());
                    word = "NOT-YET-RECIEVED";                      
                }
            }
            return;
        } 

    public void savePic(byte abyte0[])
{
    int i1 = 1;
    byte byte0 = 0;
    int j1;
    byte picBytes[] = new byte[10200];
    for(j1 = 0; j1 < 255;)
    {
        int k1 = abyte0[i1++] & 0xff;
        for(int i2 = 0; i2 < k1; i2++)
            picBytes[j1++] = byte0;
        byte0 = (byte)(255 - byte0);
    }
    for(int l1 = 1; l1 < 40; l1++)
    {
        for(int j2 = 0; j2 < 255;)
        {
            int k2 = abyte0[i1++] & 0xff;
            for(int l2 = 0; l2 < k2; l2++)
            {
                picBytes[j1] = picBytes[j1 - 255];
                j1++;
                j2++;
            }
            if(j2 < 255)
            {
                picBytes[j1] = (byte)(255 - picBytes[j1 - 255]);
                j1++;
                j2++;
            }
        }
    }
    saveOutput("./HC.bmp", picBytes);
    System.out.println("Drawing HC.bmp");
}


      
      
public void saveOutput(String s1, byte abyte0[])
{
    try
    {
        FileOutputStream fileoutputstream = new FileOutputStream(s1);
        fileoutputstream.write(66);
        fileoutputstream.write(77);
        int i1 = 1342;
        fileoutputstream.write(i1 & 0xff);
        fileoutputstream.write(i1 >> 8 & 0xff);
        fileoutputstream.write(0);
        fileoutputstream.write(0);
        fileoutputstream.write(0);
        fileoutputstream.write(0);
        fileoutputstream.write(0);
        fileoutputstream.write(0);
        i1 = 62;
        fileoutputstream.write(i1 & 0xff);
        fileoutputstream.write(i1 >> 8 & 0xff);
        fileoutputstream.write(0);
        fileoutputstream.write(0);
        i1 = 40;
        fileoutputstream.write(i1 & 0xff);
        fileoutputstream.write(i1 >> 8 & 0xff);
        fileoutputstream.write(0);
        fileoutputstream.write(0);
        i1 = 256;
        fileoutputstream.write(i1 & 0xff);
        fileoutputstream.write(i1 >> 8 & 0xff);
        fileoutputstream.write(0);
        fileoutputstream.write(0);
        i1 = 40;
        fileoutputstream.write(i1 & 0xff);
        fileoutputstream.write(i1 >> 8 & 0xff);
        fileoutputstream.write(0);
        fileoutputstream.write(0);
        i1 = 1;
        fileoutputstream.write(i1 & 0xff);
        fileoutputstream.write(i1 >> 8 & 0xff);
        i1 = 1;
        fileoutputstream.write(i1 & 0xff);
        fileoutputstream.write(i1 >> 8 & 0xff);
        i1 = 0;
        fileoutputstream.write(i1 & 0xff);
        fileoutputstream.write(i1 >> 8 & 0xff);
        fileoutputstream.write(0);
        fileoutputstream.write(0);
        i1 = 0;
        fileoutputstream.write(i1 & 0xff);
        fileoutputstream.write(i1 >> 8 & 0xff);
        fileoutputstream.write(0);
        fileoutputstream.write(0);
        i1 = 0;
        fileoutputstream.write(i1 & 0xff);
        fileoutputstream.write(i1 >> 8 & 0xff);
        fileoutputstream.write(0);
        fileoutputstream.write(0);
        i1 = 0;
        fileoutputstream.write(i1 & 0xff);
        fileoutputstream.write(i1 >> 8 & 0xff);
        fileoutputstream.write(0);
        fileoutputstream.write(0);
        i1 = 0;
        fileoutputstream.write(i1 & 0xff);
        fileoutputstream.write(i1 >> 8 & 0xff);
        fileoutputstream.write(0);
        fileoutputstream.write(0);
        i1 = 0;
        fileoutputstream.write(i1 & 0xff);
        fileoutputstream.write(i1 >> 8 & 0xff);
        fileoutputstream.write(0);
        fileoutputstream.write(0);
        fileoutputstream.write(0);
        fileoutputstream.write(0);
        fileoutputstream.write(0);
        fileoutputstream.write(0);
        fileoutputstream.write(255);
        fileoutputstream.write(255);
        fileoutputstream.write(255);
        fileoutputstream.write(0);
        int j1 = 9945;
        for(int k1 = 0; k1 < 40; k1++)
        {
            for(int l1 = 0; l1 < 32; l1++)
            {
                byte byte0 = 0;
                for(int i2 = 0; i2 < 8; i2++)
                {
                    byte0 = (byte)(2 * byte0);
                    if(l1 != 31 || i2 != 7)
                    {
                        if(abyte0[j1] != 0)
                            byte0++;
                        j1++;
                    }
                }
                fileoutputstream.write(byte0);
            }
            j1 -= 510;
        }
        fileoutputstream.close();
    }
    catch(Exception e){System.out.println(e);}
} 



    private final void method49()
    {
        char c = '\u0190';
        char c1 = 'd';
        if(aBoolean680)
        {
            c1 = '\u01C2';
            c1 = '\u012C';
        }
        aClass6_Sub1_724.method216(256 - c / 2, 167 - c1 / 2, c, c1, 0);
        aClass6_Sub1_724.method217(256 - c / 2, 167 - c1 / 2, c, c1, 0xffffff);
        aClass6_Sub1_724.method256(aString681, 256, (167 - c1 / 2) + 20, 1, 0xffffff, c - 40);
        int i = 157 + c1 / 2;
        int j = 0xffffff;
        if(super.anInt34 > i - 12 && super.anInt34 <= i && super.anInt33 > 106 && super.anInt33 < 406)
            j = 0xff0000;
        aClass6_Sub1_724.method255("Click here to close window", 256, i, 1, j);
        if(anInt813 == 1)
        {
            if(j == 0xff0000)
                aBoolean745 = false;
            if((super.anInt33 < 256 - c / 2 || super.anInt33 > 256 + c / 2) && (super.anInt34 < 167 - c1 / 2 || super.anInt34 > 167 + c1 / 2))
                aBoolean745 = false;
        }
        anInt813 = 0;
    }

    private final void method50()
    {
        anInt947 = 0;
        anInt690 = 0;
        aString861 = "Please enter a username:";
        aString862 = "*" + aString734 + "*";
        anInt742 = 0;
        anInt905 = 0;
    }

    private final void method51()
    {
        int i7 = Class1.anInt144;
        if(anInt813 != 0 && anInt819 == 0)
            anInt819 = 1;
        if(anInt819 > 0)
        {
            int i = super.anInt33 - 22;
            int j = super.anInt34 - 36;
            if(i >= 0 && j >= 0 && i < 468 && j < 262)
            {
                if(i > 216 && j > 30 && i < 462 && j < 235)
                {
                    int k = (i - 217) / 49 + ((j - 31) / 34) * 5;
                    if(k >= 0 && k < anInt708)
                    {
                        boolean flag = false;
                        int l1 = 0;
                        int k2 = anIntArray709[k];
                        for(int k3 = 0; k3 < anInt969; k3++)
                            if(anIntArray970[k3] == k2)
                                if(Class1.anIntArray55[k2] == 0)
                                {
                                    for(int i4 = 0; i4 < anInt819; i4++)
                                    {
                                        if(anIntArray971[k3] < anIntArray710[k])
                                            anIntArray971[k3]++;
                                        flag = true;
                                    }
                                }
                                else
                                    l1++;
                        if(method58(k2) <= l1)
                            flag = true;
                        if(Class1.anIntArray59[k2] == 1)
                        {
                            method118("This object cannot be traded with other players", 3);
                            flag = true;
                        }
                        if(!flag && anInt969 < 12)
                        {
                            anIntArray970[anInt969] = k2;
                            anIntArray971[anInt969] = 1;
                            anInt969++;
                            flag = true;
                        }
                        if(flag)
                        {
                            super.aClass14_Sub1_620.method331(144);
                            super.aClass14_Sub1_620.method348(anInt969);
                            for(int j4 = 0; j4 < anInt969; j4++)
                            {
                                super.aClass14_Sub1_620.method343(anIntArray970[j4]);
                                super.aClass14_Sub1_620.method332(anIntArray971[j4]);
                            }
                            super.aClass14_Sub1_620.method346();
                            aBoolean944 = false;
                            aBoolean945 = false;
                        }
                    }
                }
                if(i > 8 && j > 30 && i < 205 && j < 133)
                {
                    int l = (i - 9) / 49 + ((j - 31) / 34) * 4;
                    if(l >= 0 && l < anInt969)
                    {
                        int j1 = anIntArray970[l];
                        for(int i2 = 0; i2 < anInt819; i2++)
                        {
                            if(Class1.anIntArray55[j1] == 0 && anIntArray971[l] > 1)
                            {
                                anIntArray971[l]--;
                                continue;
                            }
                            anInt969--;
                            anInt818 = 0;
                            for(int l2 = l; l2 < anInt969; l2++)
                            {
                                anIntArray970[l2] = anIntArray970[l2 + 1];
                                anIntArray971[l2] = anIntArray971[l2 + 1];
                            }
                            break;
                        }
                        super.aClass14_Sub1_620.method331(144);
                        super.aClass14_Sub1_620.method348(anInt969);
                        for(int i3 = 0; i3 < anInt969; i3++)
                        {
                            super.aClass14_Sub1_620.method343(anIntArray970[i3]);
                            super.aClass14_Sub1_620.method332(anIntArray971[i3]);
                        }
                        super.aClass14_Sub1_620.method346();
                        aBoolean944 = false;
                        aBoolean945 = false;
                    }
                }
                if(i >= 217 && j >= 238 && i <= 286 && j <= 259)
                {
                    aBoolean945 = true;
                    super.aClass14_Sub1_620.method331(94);
                    super.aClass14_Sub1_620.method346();
                }
                if(i >= 394 && j >= 238 && i < 463 && j < 259)
                {
                    aBoolean856 = false;
                    super.aClass14_Sub1_620.method331(27);
                    super.aClass14_Sub1_620.method346();
                }
            }
            else if(anInt813 != 0)
            {
                aBoolean856 = false;
                super.aClass14_Sub1_620.method331(27);
                super.aClass14_Sub1_620.method346();
            }
            anInt813 = 0;
            anInt819 = 0;
        }
        if(!aBoolean856)
            return;
        byte byte0 = 22;
        byte byte1 = 36;
        aClass6_Sub1_724.method216(byte0, byte1, 468, 12, 192);
        int i1 = 0x989898;
        aClass6_Sub1_724.method214(byte0, byte1 + 12, 468, 18, i1, 160);
        aClass6_Sub1_724.method214(byte0, byte1 + 30, 8, 248, i1, 160);
        aClass6_Sub1_724.method214(byte0 + 205, byte1 + 30, 11, 248, i1, 160);
        aClass6_Sub1_724.method214(byte0 + 462, byte1 + 30, 6, 248, i1, 160);
        aClass6_Sub1_724.method214(byte0 + 8, byte1 + 133, 197, 22, i1, 160);
        aClass6_Sub1_724.method214(byte0 + 8, byte1 + 258, 197, 20, i1, 160);
        aClass6_Sub1_724.method214(byte0 + 216, byte1 + 235, 246, 43, i1, 160);
        int k1 = 0xd0d0d0;
        aClass6_Sub1_724.method214(byte0 + 8, byte1 + 30, 197, 103, k1, 160);
        aClass6_Sub1_724.method214(byte0 + 8, byte1 + 155, 197, 103, k1, 160);
        aClass6_Sub1_724.method214(byte0 + 216, byte1 + 30, 246, 205, k1, 160);
        for(int j2 = 0; j2 < 4; j2++)
            aClass6_Sub1_724.method218(byte0 + 8, byte1 + 30 + j2 * 34, 197, 0);
        for(int j3 = 0; j3 < 4; j3++)
            aClass6_Sub1_724.method218(byte0 + 8, byte1 + 155 + j3 * 34, 197, 0);
        for(int l3 = 0; l3 < 7; l3++)
            aClass6_Sub1_724.method218(byte0 + 216, byte1 + 30 + l3 * 34, 246, 0);
        for(int k4 = 0; k4 < 6; k4++)
        {
            if(k4 < 5)
                aClass6_Sub1_724.method219(byte0 + 8 + k4 * 49, byte1 + 30, 103, 0);
            if(k4 < 5)
                aClass6_Sub1_724.method219(byte0 + 8 + k4 * 49, byte1 + 155, 103, 0);
            aClass6_Sub1_724.method219(byte0 + 216 + k4 * 49, byte1 + 30, 205, 0);
        }
        aClass6_Sub1_724.method257("Trading with: " + aString682, byte0 + 1, byte1 + 10, 1, 0xffffff);
        aClass6_Sub1_724.method257("Your Offer", byte0 + 9, byte1 + 27, 4, 0xffffff);
        aClass6_Sub1_724.method257("Opponent's Offer", byte0 + 9, byte1 + 152, 4, 0xffffff);
        aClass6_Sub1_724.method257("Your Inventory", byte0 + 216, byte1 + 27, 4, 0xffffff);
        if(!aBoolean945)
            aClass6_Sub1_724.method231(byte0 + 217, byte1 + 238, anInt948 + 25);
        aClass6_Sub1_724.method231(byte0 + 394, byte1 + 238, anInt948 + 26);
        if(aBoolean944)
        {
            aClass6_Sub1_724.method255("Other player", byte0 + 341, byte1 + 246, 1, 0xffffff);
            aClass6_Sub1_724.method255("has accepted", byte0 + 341, byte1 + 256, 1, 0xffffff);
        }
        if(aBoolean945)
        {
            aClass6_Sub1_724.method255("Waiting for", byte0 + 217 + 35, byte1 + 246, 1, 0xffffff);
            aClass6_Sub1_724.method255("other player", byte0 + 217 + 35, byte1 + 256, 1, 0xffffff);
        }
        for(int l4 = 0; l4 < anInt708; l4++)
        {
            int i5 = 217 + byte0 + (l4 % 5) * 49;
            int k5 = 31 + byte1 + (l4 / 5) * 34;
            aClass6_Sub1_724.method247(i5, k5, 48, 32, anInt950 + Class1.anIntArray53[anIntArray709[l4]], Class1.anIntArray58[anIntArray709[l4]], 0, 0, false);
            if(Class1.anIntArray55[anIntArray709[l4]] == 0)
                aClass6_Sub1_724.method257(String.valueOf(anIntArray710[l4]), i5 + 1, k5 + 10, 1, 0xffff00);
        }
        for(int j5 = 0; j5 < anInt969; j5++)
        {
            int l5 = 9 + byte0 + (j5 % 4) * 49;
            int j6 = 31 + byte1 + (j5 / 4) * 34;
            aClass6_Sub1_724.method247(l5, j6, 48, 32, anInt950 + Class1.anIntArray53[anIntArray970[j5]], Class1.anIntArray58[anIntArray970[j5]], 0, 0, false);
            if(Class1.anIntArray55[anIntArray970[j5]] == 0)
                aClass6_Sub1_724.method257(String.valueOf(anIntArray971[j5]), l5 + 1, j6 + 10, 1, 0xffff00);
            if(super.anInt33 > l5 && super.anInt33 < l5 + 48 && super.anInt34 > j6 && super.anInt34 < j6 + 32)
                aClass6_Sub1_724.method257(Class1.aStringArray109[anIntArray970[j5]] + ": @whi@" + Class1.aStringArray110[anIntArray970[j5]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }
        for(int i6 = 0; i6 < anInt886; i6++)
        {
            int k6 = 9 + byte0 + (i6 % 4) * 49;
            int l6 = 156 + byte1 + (i6 / 4) * 34;
            aClass6_Sub1_724.method247(k6, l6, 48, 32, anInt950 + Class1.anIntArray53[anIntArray887[i6]], Class1.anIntArray58[anIntArray887[i6]], 0, 0, false);
            if(Class1.anIntArray55[anIntArray887[i6]] == 0)
                aClass6_Sub1_724.method257(String.valueOf(anIntArray888[i6]), k6 + 1, l6 + 10, 1, 0xffff00);
            if(super.anInt33 > k6 && super.anInt33 < k6 + 48 && super.anInt34 > l6 && super.anInt34 < l6 + 32)
                aClass6_Sub1_724.method257(Class1.aStringArray109[anIntArray887[i6]] + ": @whi@" + Class1.aStringArray110[anIntArray887[i6]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }
    }

    private final void method52()
    {
        int j = Class1.anInt144;
        aClass4_858 = new Class4(aClass6_Sub1_724, 50);
        int i = 40;
        aClass4_858.method156(256, 200 + i, "Skulltorcha by Reines", 5, true);
        aClass4_858.method157(156, 240 + i, 120, 35);
        aClass4_858.method157(356, 240 + i, 120, 35);
        aClass4_858.method156(156, 240 + i, "Help", 5, false);
        aClass4_858.method156(356, 240 + i, "Login", 5, false);
        anInt850 = aClass4_858.method164(156, 240 + i, 120, 35);
        anInt851 = aClass4_858.method164(356, 240 + i, 120, 35);
        aClass4_667 = new Class4(aClass6_Sub1_724, 50);
        i = 230;
        aClass4_667.method156(256, i + 8, "check www.rei-net.org forums.", 4, true);
        i += 30;
        aClass4_667.method157(256, i + 17, 150, 34);
        aClass4_667.method156(256, i + 17, "Ok", 5, false);
        anInt733 = aClass4_667.method164(256, i + 17, 150, 34);
        aClass4_751 = new Class4(aClass6_Sub1_724, 50);
        i = 230;
        anInt864 = aClass4_751.method156(256, i - 10, "www.rei-net.org for auth/pass and help.", 4, true);
        i += 28;
        aClass4_751.method157(100, i, 160, 40);
        aClass4_751.method156(100, i - 10, "Username:", 4, false);
        anInt865 = aClass4_751.method162(100, i + 10, 160, 40, 4, 12, false, false);
        i += 47;
        aClass4_751.method157(100, i, 160, 40);
        aClass4_751.method156(100, i - 10, "Password:", 4, false);
        anInt866 = aClass4_751.method162(100, i + 10, 160, 40, 4, 20, true, false);
        i -= 47;
        aClass4_751.method157(440, i, 80, 40);
        aClass4_751.method156(440, i - 10, "Server:", 4, false);
        serval = aClass4_751.method162(440, i + 10, 80, 40, 4, 12, false, false);
        i += 47;
        aClass4_751.method157(440, i, 80, 40);
        aClass4_751.method156(440, i, "Ok", 4, false);
        anInt867 = aClass4_751.method164(440, i, 80, 40);
        i += 30;
        aClass4_751.method173(anInt865);
    }

    private final void method53(boolean flag)
    {
        int l5 = Class1.anInt144;
        int i = ((Class6) (aClass6_Sub1_724)).anInt311 - 199;
        int j = 36;
        aClass6_Sub1_724.method231(i - 49, 3, anInt948 + 4);
        char c = '\304';
        char c1 = '\266';
        aClass6_Sub1_724.method214(i, j, c / 2, 24, hexbgcolor[bgcolorclickvar], 128);
        aClass6_Sub1_724.method214(i + c / 2, j, c / 2, 24, hexbgcolor[bgcolorclickvar], 128);
        aClass6_Sub1_724.method214(i, j + 24, c, 90, hexbgcolor[bgcolorclickvar], 128);
        aClass6_Sub1_724.method214(i, j + 24 + 90, c, c1 - 90 - 24, hexbgcolor[bgcolorclickvar], 128);
        aClass6_Sub1_724.method218(i, j + 24, c, 0);
        aClass6_Sub1_724.method219(i + c / 2, j, 24, 0);
        aClass6_Sub1_724.method218(i, j + 113, c, 0);
        aClass6_Sub1_724.method255("Magic", i + c / 4, j + 16, 4, hextxtcolor[txtcolorclickvar]);
        aClass6_Sub1_724.method255("Prayers", i + c / 4 + c / 2, j + 16, 4, hextxtcolor[txtcolorclickvar]);
        if(anInt800 == 0)
        {
            aClass4_798.method165(anInt799);
            int i1 = 0;
            for(int i2 = 0; i2 < Class1.anInt120; i2++)
            {
                String s = "@yel@";
                for(int l3 = 0; l3 < Class1.anIntArray97[i2]; l3++)
                {
                    int k4 = Class1.anIntArrayArray99[i2][l3];
                    if(method104(k4, Class1.anIntArrayArray100[i2][l3]))
                        continue;
                    s = "@whi@";
                    break;
                }
                int l4 = anIntArray728[6];
                if(Class1.anIntArray96[i2] > l4)
                    s = "@bla@";
                aClass4_798.method167(anInt799, i1++, s + "(" + i2 + ")Lvl " + Class1.anIntArray96[i2] + ": " + Class1.aStringArray118[i2]);
            }
            aClass4_798.method142();
            int i3 = aClass4_798.method174(anInt799);
            if(i3 != -1)
            {
                aClass6_Sub1_724.method257("Level " + Class1.anIntArray96[i3] + ": " + Class1.aStringArray118[i3], i + 2, j + 124, 1, 0xffff00);
                aClass6_Sub1_724.method257(Class1.aStringArray119[i3], i + 2, j + 136, 0, hextxtcolor[txtcolorclickvar]);
                for(int i4 = 0; i4 < Class1.anIntArray97[i3]; i4++)
                {
                    int i5 = Class1.anIntArrayArray99[i3][i4];
                    aClass6_Sub1_724.method231(i + 2 + i4 * 44, j + 150, anInt950 + Class1.anIntArray53[i5]);
                    int j5 = method58(i5);
                    int k5 = Class1.anIntArrayArray100[i3][i4];
                    String s2 = "@red@";
                    if(method104(i5, k5))
                        s2 = "@gre@";
                    aClass6_Sub1_724.method257(s2 + j5 + "/" + k5, i + 2 + i4 * 44, j + 150, 1, hextxtcolor[txtcolorclickvar]);
                }
            }
            else
                aClass6_Sub1_724.method257("Point at a spell for a description", i + 2, j + 124, 1, hextxtcolor[txtcolorclickvar]);
        }
        if(anInt800 == 1)
        {
            aClass4_798.method165(anInt799);
            int j1 = 0;
            for(int j2 = 0; j2 < Class1.anInt95; j2++)
            {
                String s1 = "@whi@";
                if(Class1.anIntArray88[j2] > anIntArray825[5])
                    s1 = "@bla@";
                if(aBooleanArray679[j2])
                    s1 = "@gre@";
                aClass4_798.method167(anInt799, j1++, s1 + "Level " + Class1.anIntArray88[j2] + ": " + Class1.aStringArray137[j2]);
            }
            aClass4_798.method142();
            int j3 = aClass4_798.method174(anInt799);
            if(j3 != -1)
            {
                aClass6_Sub1_724.method255("Level " + Class1.anIntArray88[j3] + ": " + Class1.aStringArray137[j3], i + c / 2, j + 130, 1, 0xffff00);
                aClass6_Sub1_724.method255(Class1.aStringArray138[j3], i + c / 2, j + 145, 0, hextxtcolor[txtcolorclickvar]);
                aClass6_Sub1_724.method255("Drain rate: " + Class1.anIntArray89[j3], i + c / 2, j + 160, 1, hextxtcolor[txtcolorclickvar]);
            }
            else
                aClass6_Sub1_724.method257("Point at a prayer for a description", i + 2, j + 124, 1, hextxtcolor[txtcolorclickvar]);
        }
        if(!flag)
            return;
        i = super.anInt33 - (((Class6) (aClass6_Sub1_724)).anInt311 - 199);
        j = super.anInt34 - 36;
        if(i >= 0 && j >= 0 && i < 196 && j < 182)
        {
            aClass4_798.method139(i + (((Class6) (aClass6_Sub1_724)).anInt311 - 199), j + 36, super.anInt36, super.anInt35);
            if(j <= 24 && anInt813 == 1)
                if(i < 98 && anInt800 == 1)
                {
                    anInt800 = 0;
                    aClass4_798.method166(anInt799);
                }
                else if(i > 98 && anInt800 == 0)
                {
                    anInt800 = 1;
                    aClass4_798.method166(anInt799);
                }
            if(anInt813 == 1 && anInt800 == 0)
            {
                int k1 = aClass4_798.method174(anInt799);
                if(k1 != -1)
                {
                    int k2 = anIntArray728[6];
                    if(Class1.anIntArray96[k1] > k2)
                        method118("Your magic ability is not high enough for this spell", 3);
                    else
                    {
                        int k3;
                        for(k3 = 0; k3 < Class1.anIntArray97[k1]; k3++)
                        {
                            int j4 = Class1.anIntArrayArray99[k1][k3];
                            if(method104(j4, Class1.anIntArrayArray100[k1][k3]))
                                continue;
                            method118("You don't have all the reagents you need for this spell", 3);
                            k3 = -1;
                            break;
                        }
                        if(k3 == Class1.anIntArray97[k1])
                        {
                            anInt811 = k1;
                            anInt764 = -1;
                        }
                    }
                }
            }
            if(anInt813 == 1 && anInt800 == 1)
            {
                int l1 = aClass4_798.method174(anInt799);
                if(l1 != -1)
                {
                    int l2 = anIntArray825[5];
                    if(Class1.anIntArray88[l1] > l2)
                        method118("Your prayer ability is not high enough for this prayer", 3);
                    else if(anIntArray728[5] == 0)
                        method118("You have run out of prayer points. Return to a church to recharge", 3);
                    else if(aBooleanArray679[l1])
                    {
                        super.aClass14_Sub1_620.method331(162);
                        super.aClass14_Sub1_620.method348(l1);
                        super.aClass14_Sub1_620.method346();
                        aBooleanArray679[l1] = false;
                        method97("prayeroff");
                    }
                    else
                    {
                        super.aClass14_Sub1_620.method331(202);
                        super.aClass14_Sub1_620.method348(l1);
                        super.aClass14_Sub1_620.method346();
                        aBooleanArray679[l1] = true;
                        method97("prayeron");
                    }
                }
            }
            anInt813 = 0;
        }
    }

    private final String method54(int i)
    {
        if(Class8.anApplet370 != null)
            return Class8.method268(Class15.method361(i));
        else
            return Class15.method361(i);
    }

    private final void method55(int i, int j, int k, int l, boolean flag)
    {
        if(method84(i, j, k, l, k, l, false, flag))
            return;
        else
        {
            method83(i, j, k, l, k, l, true, flag);
            return;
        }
    }

    private final void method56(boolean flag)
    {
        int j2 = Class1.anInt144;
        int i = ((Class6) (aClass6_Sub1_724)).anInt311 - 248;
        aClass6_Sub1_724.method231(i, 3, anInt948 + 1);
        for(int j = 0; j < anInt707; j++)
        {
            int k = i + (j % 5) * 49;
            int i1 = 36 + (j / 5) * 34;
            if(j < anInt708 && anIntArray711[j] == 1)
                aClass6_Sub1_724.method214(k, i1, 49, 34, hextxtcolor[txtcolorclickvar], 128);
            else
                aClass6_Sub1_724.method214(k, i1, 49, 34, hexbgcolor[bgcolorclickvar], 128);
            if(j < anInt708)
            {
                aClass6_Sub1_724.method247(k, i1, 48, 32, anInt950 + Class1.anIntArray53[anIntArray709[j]], Class1.anIntArray58[anIntArray709[j]], 0, 0, false);
                if(Class1.anIntArray55[anIntArray709[j]] == 0)
                    aClass6_Sub1_724.method257(String.valueOf(anIntArray710[j]), k + 1, i1 + 10, 1, 0xffff00);
            }
        }
        for(int l = 1; l <= 4; l++)
            aClass6_Sub1_724.method219(i + l * 49, 36, (anInt707 / 5) * 34, 0);
        for(int j1 = 1; j1 <= anInt707 / 5 - 1; j1++)
            aClass6_Sub1_724.method218(i, 36 + j1 * 34, 245, 0);
        if(!flag)
            return;
        i = super.anInt33 - (((Class6) (aClass6_Sub1_724)).anInt311 - 248);
        int k1 = super.anInt34 - 36;
        if(i >= 0 && k1 >= 0 && i < 248 && k1 < (anInt707 / 5) * 34)
        {
            int l1 = i / 49 + (k1 / 34) * 5;
            if(l1 < anInt708)
            {
                int i2 = anIntArray709[l1];
                if(anInt811 >= 0)
                {
                    if(Class1.anIntArray98[anInt811] == 3)
                    {
                        aStringArray985[anInt756] = "Cast " + Class1.aStringArray118[anInt811] + " on";
                        aStringArray769[anInt756] = "@lre@" + Class1.aStringArray109[i2];
                        anIntArray882[anInt756] = 600;
                        anIntArray803[anInt756] = l1;
                        anIntArray804[anInt756] = anInt811;
                        anInt756++;
                        return;
                    }
                }
                else
                {
                    if(anInt764 >= 0)
                    {
                        aStringArray985[anInt756] = "Use " + aString765 + " with";
                        aStringArray769[anInt756] = "@lre@" + Class1.aStringArray109[i2];
                        anIntArray882[anInt756] = 610;
                        anIntArray803[anInt756] = l1;
                        anIntArray804[anInt756] = anInt764;
                        anInt756++;
                        return;
                    }
                    if(anIntArray711[l1] == 1)
                    {
                        aStringArray985[anInt756] = "Remove";
                        aStringArray769[anInt756] = "@lre@" + Class1.aStringArray109[i2];
                        anIntArray882[anInt756] = 620;
                        anIntArray803[anInt756] = l1;
                        anInt756++;
                    }
                    else if(Class1.anIntArray57[i2] != 0)
                    {
                        if((Class1.anIntArray57[i2] & 0x18) != 0)
                            aStringArray985[anInt756] = "Wield";
                        else
                            aStringArray985[anInt756] = "Wear";
                        aStringArray769[anInt756] = "@lre@" + Class1.aStringArray109[i2];
                        anIntArray882[anInt756] = 630;
                        anIntArray803[anInt756] = l1;
                        anInt756++;
                    }
                    if(!Class1.aStringArray111[i2].equals(""))
                    {
                        aStringArray985[anInt756] = Class1.aStringArray111[i2];
                        aStringArray769[anInt756] = "@lre@" + Class1.aStringArray109[i2];
                        anIntArray882[anInt756] = 640;
                        anIntArray803[anInt756] = l1;
                        anInt756++;
                    }
                    aStringArray985[anInt756] = "Use";
                    aStringArray769[anInt756] = "@lre@" + Class1.aStringArray109[i2];
                    anIntArray882[anInt756] = 650;
                    anIntArray803[anInt756] = l1;
                    anInt756++;
                    aStringArray985[anInt756] = "Drop";
                    aStringArray769[anInt756] = "@lre@" + Class1.aStringArray109[i2];
                    anIntArray882[anInt756] = 660;
                    anIntArray803[anInt756] = l1;
                    anInt756++;
                    aStringArray985[anInt756] = "Examine";
                    aStringArray769[anInt756] = "@lre@" + Class1.aStringArray109[i2];
                    anIntArray882[anInt756] = 3600;
                    anIntArray803[anInt756] = i2;
                    anInt756++;
                }
            }
        }
    }

 /*   private final void method57()
    {
        if(super.anInt636 > 0)
            super.anInt636--;
        if(anInt690 == 0)
        {
            if(aut0 || mag3 || f1sh || switching)
            {
                if(switching)
                    chat("@red@ST:@whi@ Switched to world " + server);
                switching = false;
            }
            aClass4_858.method139(super.anInt33, super.anInt34, super.anInt36, super.anInt35);
            if(aClass4_858.method140(anInt850))
                anInt690 = 1;
            if(aClass4_858.method140(anInt851))
            {
                anInt690 = 2;
                aClass4_751.method169(anInt864,message);
                aClass4_751.method173(anInt865);
                aClass4_751.method169(anInt865,aString734);
                aClass4_751.method169(anInt866,aString735);
                aClass4_751.method169(serval,server);
                return;
            }
        }
        else if(anInt690 == 1)
        {
            aClass4_667.method139(super.anInt33, super.anInt34, super.anInt36, super.anInt35);
            if(aClass4_667.method140(anInt733))
            {
                anInt690 = 0;
                return;
            }
        }
        else if(anInt690 == 2)
        {
            aClass4_751.method139(super.anInt33, super.anInt34, super.anInt36, super.anInt35);
            if(aClass4_751.method140(anInt865))
                aClass4_751.method173(anInt866);
            if(aClass4_751.method140(anInt866))
                aClass4_751.method173(serval);
            if(aClass4_751.method140(serval) || aClass4_751.method140(anInt867))
            {
                aString734 = aClass4_751.method170(anInt865);
                aString735 = aClass4_751.method170(anInt866);
                server = aClass4_751.method170(serval);
                if(server.equalsIgnoreCase("81") || server.equalsIgnoreCase("82") || server.equalsIgnoreCase("83") || server.equalsIgnoreCase("84") || server.equalsIgnoreCase("85") || server.equalsIgnoreCase("86"))
                {
                    changeserver(Integer.parseInt(server));
                    method21(aString734, aString735, false);
                }
                else
                    aClass4_751.method169(anInt864, "Invalid server");
            }
        }
    }*/
    private final void method57()
    {
        if(super.anInt636 > 0)
            super.anInt636--;
        if(anInt690 == 0)
        {
        if(autoLogin)  method21(aString734, aString735, false);
             if(aut0 || mag3 || f1sh || switching)
            {
                if(switching)
                    chat("@red@ST:@whi@ Switched to world " + server);
                switching = false;
            }
            aClass4_858.method139(super.anInt33, super.anInt34, super.anInt36, super.anInt35);
            if(aClass4_858.method140(anInt850))
                anInt690 = 1;
            if(aClass4_858.method140(anInt851))
            {
                anInt690 = 2;
                aClass4_751.method169(anInt864, "Please enter your username and password");
                aClass4_751.method169(anInt865, "");
                aClass4_751.method169(anInt866, "");
                aClass4_751.method173(anInt865);
                return;
            }
        } else
        if(anInt690 == 1)
        {
            aClass4_667.method139(super.anInt33, super.anInt34, super.anInt36, super.anInt35);
            if(aClass4_667.method140(anInt733))
            {
                anInt690 = 0;
                return;
            }
        } else
        if(anInt690 == 2)
        {
            aClass4_751.method139(super.anInt33, super.anInt34, super.anInt36, super.anInt35);
            if(aClass4_751.method140(anInt865))
                aClass4_751.method173(anInt866);
            if(aClass4_751.method140(anInt866))
                aClass4_751.method173(serval);
            if(aClass4_751.method140(serval) || aClass4_751.method140(anInt867))
            {
                aString734 = aClass4_751.method170(anInt865);
                aString735 = aClass4_751.method170(anInt866);
                server = aClass4_751.method170(serval);
                if(server.equalsIgnoreCase("81") || server.equalsIgnoreCase("82") || server.equalsIgnoreCase("83") || server.equalsIgnoreCase("84") || server.equalsIgnoreCase("85") || server.equalsIgnoreCase("86"))
                {
                    changeserver(Integer.parseInt(server));
                    method21(aString734, aString735, false);
                }
                else
                    aClass4_751.method169(anInt864, "Invalid server");
            }
        }
        }
        
          private int anInt868;
    
    private final int method58(int i)
    {
        int l = Class1.anInt144;
        int j = 0;
        for(int k = 0; k < anInt708; k++)
            if(anIntArray709[k] == i)
                if(Class1.anIntArray55[i] == 1)
                    j++;
                else
                    j += anIntArray710[k];
        return j;
    }

    private final void method59()
    {
        aClass4_830 = new Class4(aClass6_Sub1_724, 100);
        aClass4_830.method156(256, 10, "Please design Your Character", 4, true);
        int i = 140;
        int j = 34;
        i += 116;
        j -= 10;
        aClass4_830.method156(i - 55, j + 110, "Front", 3, true);
        aClass4_830.method156(i, j + 110, "Side", 3, true);
        aClass4_830.method156(i + 55, j + 110, "Back", 3, true);
        byte byte0 = 54;
        j += 145;
        aClass4_830.method158(i - byte0, j, 53, 41);
        aClass4_830.method156(i - byte0, j - 8, "Head", 1, true);
        aClass4_830.method156(i - byte0, j + 8, "Type", 1, true);
        aClass4_830.method159(i - byte0 - 40, j, Class4.anInt221 + 7);
        anInt694 = aClass4_830.method164(i - byte0 - 40, j, 20, 20);
        aClass4_830.method159((i - byte0) + 40, j, Class4.anInt221 + 6);
        anInt695 = aClass4_830.method164((i - byte0) + 40, j, 20, 20);
        aClass4_830.method158(i + byte0, j, 53, 41);
        aClass4_830.method156(i + byte0, j - 8, "Hair", 1, true);
        aClass4_830.method156(i + byte0, j + 8, "Color", 1, true);
        aClass4_830.method159((i + byte0) - 40, j, Class4.anInt221 + 7);
        anInt696 = aClass4_830.method164((i + byte0) - 40, j, 20, 20);
        aClass4_830.method159(i + byte0 + 40, j, Class4.anInt221 + 6);
        anInt697 = aClass4_830.method164(i + byte0 + 40, j, 20, 20);
        j += 50;
        aClass4_830.method158(i - byte0, j, 53, 41);
        aClass4_830.method156(i - byte0, j, "Gender", 1, true);
        aClass4_830.method159(i - byte0 - 40, j, Class4.anInt221 + 7);
        anInt698 = aClass4_830.method164(i - byte0 - 40, j, 20, 20);
        aClass4_830.method159((i - byte0) + 40, j, Class4.anInt221 + 6);
        anInt699 = aClass4_830.method164((i - byte0) + 40, j, 20, 20);
        aClass4_830.method158(i + byte0, j, 53, 41);
        aClass4_830.method156(i + byte0, j - 8, "Top", 1, true);
        aClass4_830.method156(i + byte0, j + 8, "Color", 1, true);
        aClass4_830.method159((i + byte0) - 40, j, Class4.anInt221 + 7);
        anInt700 = aClass4_830.method164((i + byte0) - 40, j, 20, 20);
        aClass4_830.method159(i + byte0 + 40, j, Class4.anInt221 + 6);
        anInt701 = aClass4_830.method164(i + byte0 + 40, j, 20, 20);
        j += 50;
        aClass4_830.method158(i - byte0, j, 53, 41);
        aClass4_830.method156(i - byte0, j - 8, "Skin", 1, true);
        aClass4_830.method156(i - byte0, j + 8, "Color", 1, true);
        aClass4_830.method159(i - byte0 - 40, j, Class4.anInt221 + 7);
        anInt702 = aClass4_830.method164(i - byte0 - 40, j, 20, 20);
        aClass4_830.method159((i - byte0) + 40, j, Class4.anInt221 + 6);
        anInt703 = aClass4_830.method164((i - byte0) + 40, j, 20, 20);
        aClass4_830.method158(i + byte0, j, 53, 41);
        aClass4_830.method156(i + byte0, j - 8, "Bottom", 1, true);
        aClass4_830.method156(i + byte0, j + 8, "Color", 1, true);
        aClass4_830.method159((i + byte0) - 40, j, Class4.anInt221 + 7);
        anInt704 = aClass4_830.method164((i + byte0) - 40, j, 20, 20);
        aClass4_830.method159(i + byte0 + 40, j, Class4.anInt221 + 6);
        anInt705 = aClass4_830.method164(i + byte0 + 40, j, 20, 20);
        j += 82;
        j -= 35;
        aClass4_830.method157(i, j, 200, 30);
        aClass4_830.method156(i, j, "Accept", 4, false);
        anInt706 = aClass4_830.method164(i, j, 200, 30);
    }

    private final void method60(boolean flag)
    {
        int i2 = Class1.anInt144;
        int i = ((Class6) (aClass6_Sub1_724)).anInt311 - 199;
        int j = 36;
        aClass6_Sub1_724.method231(i - 49, 3, anInt948 + 6);
        char c = '\304';
        aClass6_Sub1_724.method214(i, 36, c, 289, hexbgcolor[bgcolorclickvar], 160);
        int k = i + 3;
        int i1 = j + 15;
        aClass6_Sub1_724.method257("Skulltorcha by Reines", k, i1, 1, hextxtcolor[txtcolorclickvar]);
        i1 += 15;
        if(aBoolean675)
            aClass6_Sub1_724.method257("Auto Camera @gre@on", k, i1, 1, hextxtcolor[txtcolorclickvar]);
        else
            aClass6_Sub1_724.method257("Auto Camera @red@off", k, i1, 1, hextxtcolor[txtcolorclickvar]);
        i1 += 15;
        if(aBoolean767)
            aClass6_Sub1_724.method257("Single button @red@on", k, i1, 1, hextxtcolor[txtcolorclickvar]);
        else
            aClass6_Sub1_724.method257("Single button @gre@off", k, i1, 1, hextxtcolor[txtcolorclickvar]);
        i1 += 15;
        if(super.anInt629 == 0)
            aClass6_Sub1_724.method257("Chat messages @red@off", k, i1, 1, hextxtcolor[txtcolorclickvar]);
        else
            aClass6_Sub1_724.method257("Chat messages @gre@on", k, i1, 1, hextxtcolor[txtcolorclickvar]);
        i1 += 15;
        if(super.anInt630 == 0)
            aClass6_Sub1_724.method257("Private messages @red@off", k, i1, 1, hextxtcolor[txtcolorclickvar]);
        else
            aClass6_Sub1_724.method257("Private messages @gre@on", k, i1, 1, hextxtcolor[txtcolorclickvar]);
        i1 += 15;
        if(super.anInt631 == 0)
            aClass6_Sub1_724.method257("Trade requests @red@off", k, i1, 1, hextxtcolor[txtcolorclickvar]);
        else
            aClass6_Sub1_724.method257("Trade requests @gre@on", k, i1, 1, hextxtcolor[txtcolorclickvar]);
        i1 += 15;
        if(aBoolean914)
        {
            if(super.anInt632 == 0)
                aClass6_Sub1_724.method257("Duel requests @red@off", k, i1, 1, hextxtcolor[txtcolorclickvar]);
            else
                aClass6_Sub1_724.method257("Duel requests @gre@on", k, i1, 1, hextxtcolor[txtcolorclickvar]);
            i1 += 15;
        }
        if(playerclickvar == 0)
            aClass6_Sub1_724.method257("Players @gre@lefty", k, i1, 1, hextxtcolor[txtcolorclickvar]);
        else if(playerclickvar == 1)
            aClass6_Sub1_724.method257("Players @red@righty", k, i1, 1, hextxtcolor[txtcolorclickvar]);
        else
            aClass6_Sub1_724.method257("Players @yel@normal", k, i1, 1, hextxtcolor[txtcolorclickvar]);
        i1 += 15;
        if(npcclickvar == 0)
            aClass6_Sub1_724.method257("NPC's @gre@lefty", k, i1, 1, hextxtcolor[txtcolorclickvar]);
        else if(npcclickvar == 1)
            aClass6_Sub1_724.method257("NPC's @red@righty", k, i1, 1, hextxtcolor[txtcolorclickvar]);
        else
            aClass6_Sub1_724.method257("NPC's @yel@normal", k, i1, 1, hextxtcolor[txtcolorclickvar]);
        i1 += 15;
        if(prayclickvar == 0)
            aClass6_Sub1_724.method257("F11 @yel@Ultimate Str", k, i1, 1, hextxtcolor[txtcolorclickvar]);
        else if(prayclickvar == 1)
            aClass6_Sub1_724.method257("F11 @yel@Incredible Reflexes", k, i1, 1, hextxtcolor[txtcolorclickvar]);
        else
            aClass6_Sub1_724.method257("F11 @gre@Both", k, i1, 1, hextxtcolor[txtcolorclickvar]);
        i1 += 15;
        if(showhp)
            aClass6_Sub1_724.method257("Show HP @gre@on", k, i1, 1, hextxtcolor[txtcolorclickvar]);
        else
            aClass6_Sub1_724.method257("Show HP @red@off", k, i1, 1, hextxtcolor[txtcolorclickvar]);
        i1 += 15;
        if(picking)
            aClass6_Sub1_724.method257("Auto pickup @gre@on", k, i1, 1, hextxtcolor[txtcolorclickvar]);
        else
            aClass6_Sub1_724.method257("Auto pickup @red@off", k, i1, 1, hextxtcolor[txtcolorclickvar]);
        i1 += 15;
        if(bone[boneclickvar] != 9999)
            aClass6_Sub1_724.method257("Burying @yel@" + Class1.aStringArray109[bone[boneclickvar]], k, i1, 1, hextxtcolor[txtcolorclickvar]);
        else
            aClass6_Sub1_724.method257("Burying @yel@nothing", k, i1, 1, hextxtcolor[txtcolorclickvar]);
        i1 += 15;
        if(foodid[foodclickvar] == 9999)
            aClass6_Sub1_724.method257("Food @yel@Cake", k, i1, 1, hextxtcolor[txtcolorclickvar]);
        else
            aClass6_Sub1_724.method257("Food @yel@" + Class1.aStringArray109[foodid[foodclickvar]], k, i1, 1, hextxtcolor[txtcolorclickvar]);
        i1 += 15;
        int k1 = hextxtcolor[txtcolorclickvar];
        if(super.anInt33 > k && super.anInt33 < k + c && super.anInt34 > i1 - 12 && super.anInt34 < i1 + 4)
            k1 = 0xffff00;
        aClass6_Sub1_724.method257("Change menu color", k, i1, 1, k1);
        i1 += 15;
        int k3 = hextxtcolor[txtcolorclickvar];
        if(super.anInt33 > k && super.anInt33 < k + c && super.anInt34 > i1 - 12 && super.anInt34 < i1 + 4)
            k3 = 0xffff00;
        aClass6_Sub1_724.method257("Change text color", k, i1, 1, k3);
        i1 += 15;
        int k2 = hextxtcolor[txtcolorclickvar];
        if(super.anInt33 > k && super.anInt33 < k + c && super.anInt34 > i1 - 12 && super.anInt34 < i1 + 4)
            k2 = 0xffff00;
        if(wildlvl() > 0)
            aClass6_Sub1_724.method257("Logging in wild is gay", k, i1, 1, k2);
        else
            aClass6_Sub1_724.method257("Fuck off", k, i1, 1, k2);
        if(!flag)
            return;
        i = super.anInt33 - (((Class6) (aClass6_Sub1_724)).anInt311 - 199);
        j = super.anInt34 - 36;
        if(i >= 0 && j >= 0 && i < 196 && j < 265)
        {
            int l1 = ((Class6) (aClass6_Sub1_724)).anInt311 - 199;
            byte byte0 = 36;
            char c1 = '\304';
            int l = l1 + 3;
            int j1 = byte0 + 30;
            if(super.anInt33 > l && super.anInt33 < l + c1 && super.anInt34 > j1 - 12 && super.anInt34 < j1 + 4 && anInt813 == 1)
            {
                aBoolean675 = !aBoolean675;
                super.aClass14_Sub1_620.method331(165);
                super.aClass14_Sub1_620.method348(0);
                super.aClass14_Sub1_620.method348(aBoolean675 ? 1 : 0);
                super.aClass14_Sub1_620.method346();
            }
            j1 += 15;
            if(super.anInt33 > l && super.anInt33 < l + c1 && super.anInt34 > j1 - 12 && super.anInt34 < j1 + 4 && anInt813 == 1)
            {
                aBoolean767 = !aBoolean767;
                super.aClass14_Sub1_620.method331(165);
                super.aClass14_Sub1_620.method348(2);
                super.aClass14_Sub1_620.method348(aBoolean767 ? 1 : 0);
                super.aClass14_Sub1_620.method346();
            }
            j1 += 15;
            boolean flag1 = false;
            if(super.anInt33 > l && super.anInt33 < l + c1 && super.anInt34 > j1 - 12 && super.anInt34 < j1 + 4 && anInt813 == 1)
            {
                super.anInt629 = 1 - super.anInt629;
                flag1 = true;
            }
            j1 += 15;
            if(super.anInt33 > l && super.anInt33 < l + c1 && super.anInt34 > j1 - 12 && super.anInt34 < j1 + 4 && anInt813 == 1)
            {
                super.anInt630 = 1 - super.anInt630;
                flag1 = true;
            }
            j1 += 15;
            if(super.anInt33 > l && super.anInt33 < l + c1 && super.anInt34 > j1 - 12 && super.anInt34 < j1 + 4 && anInt813 == 1)
            {
                super.anInt631 = 1 - super.anInt631;
                flag1 = true;
            }
            j1 += 15;
            if(aBoolean914)
            {
                if(super.anInt33 > l && super.anInt33 < l + c1 && super.anInt34 > j1 - 12 && super.anInt34 < j1 + 4 && anInt813 == 1)
                {
                    super.anInt632 = 1 - super.anInt632;
                    flag1 = true;
                }
                j1 += 15;
            }
            if(super.anInt33 > l && super.anInt33 < l + c1 && super.anInt34 > j1 - 12 && super.anInt34 < j1 + 4 && anInt813 == 1)
                if(playerclickvar + 1 < 3)
                    playerclickvar += 1;
                else
                    playerclickvar = 0;
            j1 += 15;
            if(super.anInt33 > l && super.anInt33 < l + c1 && super.anInt34 > j1 - 12 && super.anInt34 < j1 + 4 && anInt813 == 1)
                if(npcclickvar + 1 < 3)
                    npcclickvar += 1;
                else
                    npcclickvar = 0;
            j1 += 15;
            if(super.anInt33 > l && super.anInt33 < l + c1 && super.anInt34 > j1 - 12 && super.anInt34 < j1 + 4 && anInt813 == 1)
                if(prayclickvar + 1 < 3)
                    prayclickvar += 1;
                else
                    prayclickvar = 0;
            j1 += 15;
            if(super.anInt33 > l && super.anInt33 < l + c1 && super.anInt34 > j1 - 12 && super.anInt34 < j1 + 4 && anInt813 == 1)
                showhp = !showhp;
            j1 += 15;
            if(super.anInt33 > l && super.anInt33 < l + c1 && super.anInt34 > j1 - 12 && super.anInt34 < j1 + 4 && anInt813 == 1)
                picking = !picking;
            j1 += 15;
            if(super.anInt33 > l && super.anInt33 < l + c1 && super.anInt34 > j1 - 12 && super.anInt34 < j1 + 4 && anInt813 == 1)
                if(boneclickvar + 1 < bone.length)
                    boneclickvar += 1;
                else
                    boneclickvar = 0;
            j1 += 15;
            if(super.anInt33 > l && super.anInt33 < l + c1 && super.anInt34 > j1 - 12 && super.anInt34 < j1 + 4 && anInt813 == 1)
                if(foodclickvar + 1 < foodidlength)
                    foodclickvar += 1;
                else
                    foodclickvar = 0;
            j1 += 15;
            if(super.anInt33 > l && super.anInt33 < l + c1 && super.anInt34 > j1 - 12 && super.anInt34 < j1 + 4 && anInt813 == 1)
                if(bgcolorclickvar + 1 < hexbgcolor.length)
                    bgcolorclickvar += 1;
                else
                    bgcolorclickvar = 0;
            j1 += 15;
            if(super.anInt33 > l && super.anInt33 < l + c1 && super.anInt34 > j1 - 12 && super.anInt34 < j1 + 4 && anInt813 == 1)
                if(txtcolorclickvar + 1 < hextxtcolor.length)
                    txtcolorclickvar += 1;
                else
                    txtcolorclickvar = 0;
            j1 += 15;
            if(super.anInt33 > l && super.anInt33 < l + c1 && super.anInt34 > j1 - 12 && super.anInt34 < j1 + 4 && anInt813 == 1)
                method71();
            if(flag1)
                method28(super.anInt629, super.anInt630, super.anInt631, super.anInt632);
            anInt813 = 0;
        }
    }

    private final void method61()
    {
        aClass6_Sub1_724.aBoolean335 = false;
        aClass6_Sub1_724.method212();
        aClass4_830.method142();
        int i = 140;
        int j = 50;
        i += 116;
        j -= 25;
        aClass6_Sub1_724.method235(i - 32 - 55, j, 64, 102, Class1.anIntArray87[anInt873], anIntArray832[anInt876]);
        aClass6_Sub1_724.method247(i - 32 - 55, j, 64, 102, Class1.anIntArray87[anInt872], anIntArray832[anInt875], anIntArray829[anInt877], 0, false);
        aClass6_Sub1_724.method247(i - 32 - 55, j, 64, 102, Class1.anIntArray87[anInt871], anIntArray885[anInt874], anIntArray829[anInt877], 0, false);
        aClass6_Sub1_724.method235(i - 32, j, 64, 102, Class1.anIntArray87[anInt873] + 6, anIntArray832[anInt876]);
        aClass6_Sub1_724.method247(i - 32, j, 64, 102, Class1.anIntArray87[anInt872] + 6, anIntArray832[anInt875], anIntArray829[anInt877], 0, false);
        aClass6_Sub1_724.method247(i - 32, j, 64, 102, Class1.anIntArray87[anInt871] + 6, anIntArray885[anInt874], anIntArray829[anInt877], 0, false);
        aClass6_Sub1_724.method235((i - 32) + 55, j, 64, 102, Class1.anIntArray87[anInt873] + 12, anIntArray832[anInt876]);
        aClass6_Sub1_724.method247((i - 32) + 55, j, 64, 102, Class1.anIntArray87[anInt872] + 12, anIntArray832[anInt875], anIntArray829[anInt877], 0, false);
        aClass6_Sub1_724.method247((i - 32) + 55, j, 64, 102, Class1.anIntArray87[anInt871] + 12, anIntArray885[anInt874], anIntArray829[anInt877], 0, false);
        aClass6_Sub1_724.method231(0, anInt677, anInt948 + 22);
        aClass6_Sub1_724.method211(aGraphics857, 0, 0);
    }

    private final void method62()
    {
        int l4 = Class1.anInt144;
        int i = 2203 - (anInt977 + anInt807 + anInt784);
        if(anInt976 + anInt806 + anInt783 >= 2640)
            i = -50;
        int j = -1;
        for(int k = 0; k < anInt796; k++)
            aBooleanArray662[k] = false;
        for(int l = 0; l < anInt855; l++)
            aBooleanArray831[l] = false;
        int i1 = aClass10_739.method278();
        Class5 aclass5[] = aClass10_739.method280();
        int ai[] = aClass10_739.method279();
        for(int j1 = 0; j1 < i1; j1++)
        {
            if(anInt756 > 200)
                break;
            int k1 = ai[j1];
            Class5 class5 = aclass5[j1];
            if(class5.anIntArray258[k1] <= 65535 || class5.anIntArray258[k1] >= 0x30d40 && class5.anIntArray258[k1] <= 0x493e0)
                if(class5 == aClass10_739.aClass5_433)
                {
                    int i2 = class5.anIntArray258[k1] % 10000;
                    int l2 = class5.anIntArray258[k1] / 10000;
                    if(l2 == 1)
                    {
                        String s = "";
                        int k3 = 0;
                        if(aClass2_975.anInt168 > 0 && aClass2Array983[i2].anInt168 > 0)
                            k3 = aClass2_975.anInt168 - aClass2Array983[i2].anInt168;
                        if(k3 < 0)
                            s = "@or1@";
                        if(k3 < -3)
                            s = "@or2@";
                        if(k3 < -6)
                            s = "@or3@";
                        if(k3 < -9)
                            s = "@red@";
                        if(k3 > 0)
                            s = "@gr1@";
                        if(k3 > 3)
                            s = "@gr2@";
                        if(k3 > 6)
                            s = "@gr3@";
                        if(k3 > 9)
                            s = "@gre@";
                        s = " " + s + "(level-" + aClass2Array983[i2].anInt168 + ")";
                        if(anInt811 >= 0)
                        {
                            if(Class1.anIntArray98[anInt811] == 1 || Class1.anIntArray98[anInt811] == 2)
                            {
                                aStringArray985[anInt756] = "Cast " + Class1.aStringArray118[anInt811] + " on";
                                aStringArray769[anInt756] = "@whi@" + aClass2Array983[i2].aString146 + s;
                                anIntArray882[anInt756] = 800;
                                anIntArray937[anInt756] = aClass2Array983[i2].anInt149;
                                anIntArray938[anInt756] = aClass2Array983[i2].anInt150;
                                anIntArray803[anInt756] = aClass2Array983[i2].anInt147;
                                anIntArray804[anInt756] = anInt811;
                                anInt756++;
                            }
                        } else
                        if(anInt764 >= 0)
                        {
                            aStringArray985[anInt756] = "Use " + aString765 + " with";
                            aStringArray769[anInt756] = "@whi@" + aClass2Array983[i2].aString146 + s;
                            anIntArray882[anInt756] = 810;
                            anIntArray937[anInt756] = aClass2Array983[i2].anInt149;
                            anIntArray938[anInt756] = aClass2Array983[i2].anInt150;
                            anIntArray803[anInt756] = aClass2Array983[i2].anInt147;
                            anIntArray804[anInt756] = anInt764;
                            anInt756++;
                        } else
                        {
                            if(canattack(i2) && i > 0 && !friend(i2))
                            {
                                aStringArray985[anInt756] = "Attack";
                                aStringArray769[anInt756] = "@whi@" + aClass2Array983[i2].aString146 + s;
                                if(playerclickvar == 0)
                                    anIntArray882[anInt756] = 805;
                                else if(playerclickvar == 1)
                                    anIntArray882[anInt756] = 2805;
                                else if(k3 >= 0 && k3 < 5)
                                    anIntArray882[anInt756] = 805;
                                else
                                    anIntArray882[anInt756] = 2805;
                                anIntArray937[anInt756] = aClass2Array983[i2].anInt149;
                                anIntArray938[anInt756] = aClass2Array983[i2].anInt150;
                                anIntArray803[anInt756] = aClass2Array983[i2].anInt147;
                                anInt756++;
                            }
                            else if(aBoolean914 && wildlvl() < 1)
                            {
                                aStringArray985[anInt756] = "Duel with";
                                aStringArray769[anInt756] = "@whi@" + aClass2Array983[i2].aString146 + s;
                                anIntArray937[anInt756] = aClass2Array983[i2].anInt149;
                                anIntArray938[anInt756] = aClass2Array983[i2].anInt150;
                                anIntArray882[anInt756] = 2806;
                                anIntArray803[anInt756] = aClass2Array983[i2].anInt147;
                                anInt756++;
                            }
                            if(!friend(i2))
                            {
                                aStringArray985[anInt756] = "Add to friends";
                                aStringArray769[anInt756] = "@whi@" + aClass2Array983[i2].aString146 + s;
                                anIntArray882[anInt756] = 2808;
                                anIntArray803[anInt756] = i2;
                                anInt756++;
                            }
                            aStringArray985[anInt756] = "Trade with";
                            aStringArray769[anInt756] = "@whi@" + aClass2Array983[i2].aString146 + s;
                            anIntArray882[anInt756] = 2810;
                            anIntArray803[anInt756] = aClass2Array983[i2].anInt147;
                            anInt756++;
                            aStringArray985[anInt756] = "Follow";
                            aStringArray769[anInt756] = "@whi@" + aClass2Array983[i2].aString146 + s;
                            anIntArray882[anInt756] = 2820;
                            anIntArray803[anInt756] = aClass2Array983[i2].anInt147;
                            anInt756++;
                        }
                    } else
                    if(l2 == 2)
                    {
                        if(anInt811 >= 0)
                        {
                            if(Class1.anIntArray98[anInt811] == 3)
                            {
                                aStringArray985[anInt756] = "Cast " + Class1.aStringArray118[anInt811] + " on";
                                aStringArray769[anInt756] = "@lre@" + Class1.aStringArray109[anIntArray772[i2]];
                                anIntArray882[anInt756] = 200;
                                anIntArray937[anInt756] = anIntArray770[i2];
                                anIntArray938[anInt756] = anIntArray771[i2];
                                anIntArray803[anInt756] = anIntArray772[i2];
                                anIntArray804[anInt756] = anInt811;
                                anInt756++;
                            }
                        } else
                        if(anInt764 >= 0)
                        {
                            aStringArray985[anInt756] = "Use " + aString765 + " with";
                            aStringArray769[anInt756] = "@lre@" + Class1.aStringArray109[anIntArray772[i2]];
                            anIntArray882[anInt756] = 210;
                            anIntArray937[anInt756] = anIntArray770[i2];
                            anIntArray938[anInt756] = anIntArray771[i2];
                            anIntArray803[anInt756] = anIntArray772[i2];
                            anIntArray804[anInt756] = anInt764;
                            anInt756++;
                        } else
                        {
                            aStringArray985[anInt756] = "Take"; //pickup
                            aStringArray769[anInt756] = "@lre@" + Class1.aStringArray109[anIntArray772[i2]];
                            anIntArray882[anInt756] = 220;
                            anIntArray937[anInt756] = anIntArray770[i2];
                            anIntArray938[anInt756] = anIntArray771[i2];
                            anIntArray803[anInt756] = anIntArray772[i2];
                            anInt756++;
                            aStringArray985[anInt756] = "Examine";
                            aStringArray769[anInt756] = "@lre@" + Class1.aStringArray109[anIntArray772[i2]];
                            anIntArray882[anInt756] = 3200;
                            anIntArray803[anInt756] = anIntArray772[i2];
                            anInt756++;
                        }
                    } else
                    if(l2 == 3)
                    {
                        String s1 = "";
                        int l3 = -1;
                        int i4 = aClass2Array768[i2].anInt151;
                        if(Class1.anIntArray116[i4] > 0)
                        {
                            int j4 = (Class1.anIntArray112[i4] + Class1.anIntArray115[i4] + Class1.anIntArray113[i4] + Class1.anIntArray114[i4]) / 4;
                            int k4 = (anIntArray825[0] + anIntArray825[1] + anIntArray825[2] + anIntArray825[3] + 27) / 4;
                            l3 = k4 - j4;
                            s1 = "@yel@";
                            if(l3 < 0)
                                s1 = "@or1@";
                            if(l3 < -3)
                                s1 = "@or2@";
                            if(l3 < -6)
                                s1 = "@or3@";
                            if(l3 < -9)
                                s1 = "@red@";
                            if(l3 > 0)
                                s1 = "@gr1@";
                            if(l3 > 3)
                                s1 = "@gr2@";
                            if(l3 > 6)
                                s1 = "@gr3@";
                            if(l3 > 9)
                                s1 = "@gre@";
                            s1 = " " + s1 + "(level-" + j4 + ")";
                        }
                        if(anInt811 >= 0)
                        {
                            if(Class1.anIntArray98[anInt811] == 2)
                            {
                                aStringArray985[anInt756] = "Cast " + Class1.aStringArray118[anInt811] + " on";
                                aStringArray769[anInt756] = "@yel@" + Class1.aStringArray127[aClass2Array768[i2].anInt151];
                                anIntArray882[anInt756] = 700;
                                anIntArray937[anInt756] = aClass2Array768[i2].anInt149;
                                anIntArray938[anInt756] = aClass2Array768[i2].anInt150;
                                anIntArray803[anInt756] = aClass2Array768[i2].anInt147;
                                anIntArray804[anInt756] = anInt811;
                                anInt756++;
                            }
                        } else
                        if(anInt764 >= 0)
                        {
                            aStringArray985[anInt756] = "Use " + aString765 + " with";
                            aStringArray769[anInt756] = "@yel@" + Class1.aStringArray127[aClass2Array768[i2].anInt151];
                            anIntArray882[anInt756] = 710;
                            anIntArray937[anInt756] = aClass2Array768[i2].anInt149;
                            anIntArray938[anInt756] = aClass2Array768[i2].anInt150;
                            anIntArray803[anInt756] = aClass2Array768[i2].anInt147;
                            anIntArray804[anInt756] = anInt764;
                            anInt756++;
                        } else
                        {
                            if(Class1.anIntArray116[i4] > 0)
                            {
                                aStringArray985[anInt756] = "Attack";
                                aStringArray769[anInt756] = "@yel@" + Class1.aStringArray127[aClass2Array768[i2].anInt151] + s1;
                                if(npcclickvar == 0)
                                    anIntArray882[anInt756] = 715;
                                else if(npcclickvar == 1)
                                    anIntArray882[anInt756] = 2715;
                                else if(l3 >= 0)
                                    anIntArray882[anInt756] = 715;
                                else
                                    anIntArray882[anInt756] = 2715;
                                anIntArray937[anInt756] = aClass2Array768[i2].anInt149;
                                anIntArray938[anInt756] = aClass2Array768[i2].anInt150;
                                anIntArray803[anInt756] = aClass2Array768[i2].anInt147;
                                anInt756++;
                            }
                            aStringArray985[anInt756] = "Talk-to";
                            aStringArray769[anInt756] = "@yel@" + Class1.aStringArray127[aClass2Array768[i2].anInt151];
                            anIntArray882[anInt756] = 720;
                            anIntArray937[anInt756] = aClass2Array768[i2].anInt149;
                            anIntArray938[anInt756] = aClass2Array768[i2].anInt150;
                            anIntArray803[anInt756] = aClass2Array768[i2].anInt147;
                            anInt756++;
                            if(!Class1.aStringArray129[i4].equals(""))
                            {
                                aStringArray985[anInt756] = Class1.aStringArray129[i4];
                                aStringArray769[anInt756] = "@yel@" + Class1.aStringArray127[aClass2Array768[i2].anInt151];
                                anIntArray882[anInt756] = 725;
                                anIntArray937[anInt756] = aClass2Array768[i2].anInt149;
                                anIntArray938[anInt756] = aClass2Array768[i2].anInt150;
                                anIntArray803[anInt756] = aClass2Array768[i2].anInt147;
                                anInt756++;
                            }
                            if(Class1.anIntArray116[i4] > 0)
                            {
                                aStringArray985[anInt756] = "Macro on";
                                aStringArray769[anInt756] = "@yel@" + Class1.aStringArray127[aClass2Array768[i2].anInt151];
                                anIntArray882[anInt756] = 731;
                                anIntArray803[anInt756] = i4;
                                anInt756++;
                            }
                            aStringArray985[anInt756] = "Stats of";
                            aStringArray769[anInt756] = "@yel@" + Class1.aStringArray127[aClass2Array768[i2].anInt151];
                            anIntArray882[anInt756] = 3690;
                            anIntArray803[anInt756] = aClass2Array768[i2].anInt151;
                            anInt756++;
                            aStringArray985[anInt756] = "Examine";
                            aStringArray769[anInt756] = "@yel@" + Class1.aStringArray127[aClass2Array768[i2].anInt151];
                            anIntArray882[anInt756] = 3700;
                            anIntArray803[anInt756] = aClass2Array768[i2].anInt151;
                            anInt756++;
                        }
                    }
                } else
                if(class5 != null && class5.anInt257 >= 10000)
                {
                    int j2 = class5.anInt257 - 10000;
                    int i3 = anIntArray741[j2];
                    if(!aBooleanArray831[j2])
                    {
                        if(anInt811 >= 0)
                        {
                            if(Class1.anIntArray98[anInt811] == 4)
                            {
                                aStringArray985[anInt756] = "Cast " + Class1.aStringArray118[anInt811] + " on";
                                aStringArray769[anInt756] = "@cya@" + Class1.aStringArray70[i3];
                                anIntArray882[anInt756] = 300;
                                anIntArray937[anInt756] = anIntArray747[j2];
                                anIntArray938[anInt756] = anIntArray748[j2];
                                anIntArray803[anInt756] = anIntArray740[j2];
                                anIntArray804[anInt756] = anInt811;
                                anInt756++;
                            }
                        } else
                        if(anInt764 >= 0)
                        {
                            aStringArray985[anInt756] = "Use " + aString765 + " with";
                            aStringArray769[anInt756] = "@cya@" + Class1.aStringArray70[i3];
                            anIntArray882[anInt756] = 310;
                            anIntArray937[anInt756] = anIntArray747[j2];
                            anIntArray938[anInt756] = anIntArray748[j2];
                            anIntArray803[anInt756] = anIntArray740[j2];
                            anIntArray804[anInt756] = anInt764;
                            anInt756++;
                        } else
                        {
                            if(!Class1.aStringArray72[i3].equalsIgnoreCase("WalkTo"))
                            {
                                aStringArray985[anInt756] = Class1.aStringArray72[i3];
                                aStringArray769[anInt756] = "@cya@" + Class1.aStringArray70[i3];
                                anIntArray882[anInt756] = 320;
                                anIntArray937[anInt756] = anIntArray747[j2];
                                anIntArray938[anInt756] = anIntArray748[j2];
                                anIntArray803[anInt756] = anIntArray740[j2];
                                anInt756++;
                            }
                            if(!Class1.aStringArray73[i3].equalsIgnoreCase("Examine"))
                            {
                                aStringArray985[anInt756] = Class1.aStringArray73[i3];
                                aStringArray769[anInt756] = "@cya@" + Class1.aStringArray70[i3];
                                anIntArray882[anInt756] = 2300;
                                anIntArray937[anInt756] = anIntArray747[j2];
                                anIntArray938[anInt756] = anIntArray748[j2];
                                anIntArray803[anInt756] = anIntArray740[j2];
                                anInt756++;
                            }
                            aStringArray985[anInt756] = "Examine";
                            aStringArray769[anInt756] = "@cya@" + Class1.aStringArray70[i3];
                            anIntArray882[anInt756] = 3300;
                            anIntArray803[anInt756] = i3;
                            anInt756++;
                        }
                        aBooleanArray831[j2] = true;
                    }
                } else
                if(class5 != null && class5.anInt257 >= 0)
                {
                    int k2 = class5.anInt257;
                    int j3 = anIntArray762[k2];
                    if(!aBooleanArray662[k2])
                    {
                        if(anInt811 >= 0)
                        {
                            if(Class1.anIntArray98[anInt811] == 5)
                            {
                                aStringArray985[anInt756] = "Cast " + Class1.aStringArray118[anInt811] + " on";
                                aStringArray769[anInt756] = "@cya@" + Class1.aStringArray91[j3];
                                anIntArray882[anInt756] = 400;
                                anIntArray937[anInt756] = anIntArray760[k2];
                                anIntArray938[anInt756] = anIntArray761[k2];
                                anIntArray803[anInt756] = anIntArray763[k2];
                                anIntArray804[anInt756] = anIntArray762[k2];
                                anIntArray805[anInt756] = anInt811;
                                anInt756++;
                            }
                        } else
                        if(anInt764 >= 0)
                        {
                            aStringArray985[anInt756] = "Use " + aString765 + " with";
                            aStringArray769[anInt756] = "@cya@" + Class1.aStringArray91[j3];
                            anIntArray882[anInt756] = 410;
                            anIntArray937[anInt756] = anIntArray760[k2];
                            anIntArray938[anInt756] = anIntArray761[k2];
                            anIntArray803[anInt756] = anIntArray763[k2];
                            anIntArray804[anInt756] = anIntArray762[k2];
                            anIntArray805[anInt756] = anInt764;
                            anInt756++;
                        } else
                        {
                            if(!Class1.aStringArray93[j3].equalsIgnoreCase("WalkTo"))
                            {
                                aStringArray985[anInt756] = Class1.aStringArray93[j3];
                                aStringArray769[anInt756] = "@cya@" + Class1.aStringArray91[j3];
                                anIntArray882[anInt756] = 420;
                                anIntArray937[anInt756] = anIntArray760[k2];
                                anIntArray938[anInt756] = anIntArray761[k2];
                                anIntArray803[anInt756] = anIntArray763[k2];
                                anIntArray804[anInt756] = anIntArray762[k2];
                                anInt756++;
                            }
                            if(!Class1.aStringArray94[j3].equalsIgnoreCase("Examine"))
                            {
                                aStringArray985[anInt756] = Class1.aStringArray94[j3];
                                aStringArray769[anInt756] = "@cya@" + Class1.aStringArray91[j3];
                                anIntArray882[anInt756] = 2400;
                                anIntArray937[anInt756] = anIntArray760[k2];
                                anIntArray938[anInt756] = anIntArray761[k2];
                                anIntArray803[anInt756] = anIntArray763[k2];
                                anIntArray804[anInt756] = anIntArray762[k2];
                                anInt756++;
                            }
                            aStringArray985[anInt756] = "Examine";
                            aStringArray769[anInt756] = "@cya@" + Class1.aStringArray91[j3];
                            anIntArray882[anInt756] = 3400;
                            anIntArray803[anInt756] = j3;
                            anInt756++;
                        }
                        aBooleanArray662[k2] = true;
                    }
                } else
                {
                    if(k1 >= 0)
                        k1 = class5.anIntArray258[k1] - 0x30d40;
                    if(k1 >= 0)
                        j = k1;
                }
        }

        if(anInt811 >= 0 && Class1.anIntArray98[anInt811] <= 1)
        {
            aStringArray985[anInt756] = "Cast " + Class1.aStringArray118[anInt811] + " on self";
            aStringArray769[anInt756] = "";
            anIntArray882[anInt756] = 1000;
            anIntArray803[anInt756] = anInt811;
            anInt756++;
        }
        if(j != -1)
        {
            int l1 = j;
            if(anInt811 >= 0)
            {
                if(Class1.anIntArray98[anInt811] == 6)
                {
                    aStringArray985[anInt756] = "Cast " + Class1.aStringArray118[anInt811] + " on ground";
                    aStringArray769[anInt756] = "";
                    anIntArray882[anInt756] = 900;
                    anIntArray937[anInt756] = aClass19_883.anIntArray602[l1];
                    anIntArray938[anInt756] = aClass19_883.anIntArray587[l1];
                    anIntArray803[anInt756] = anInt811;
                    anInt756++;
                    return;
                }
            } else
            if(anInt764 < 0)
            {
                aStringArray985[anInt756] = "Walk here";
                aStringArray769[anInt756] = "";
                anIntArray882[anInt756] = 920;
                anIntArray937[anInt756] = aClass19_883.anIntArray602[l1];
                anIntArray938[anInt756] = aClass19_883.anIntArray587[l1];
                anInt756++;
            }
        }
    }

    private final void method64()
    {
        int l = Class1.anInt144;
        Class1.method124("torcha2");
        Class1.method124("torcha3");
        Class1.method124("torcha4");
        Class1.method124("skulltorcha2");
        Class1.method124("skulltorcha3");
        Class1.method124("skulltorcha4");
        Class1.method124("firea2");
        Class1.method124("firea3");
        Class1.method124("fireplacea2");
        Class1.method124("fireplacea3");
        Class1.method124("firespell2");
        Class1.method124("firespell3");
        Class1.method124("lightning2");
        Class1.method124("lightning3");
        Class1.method124("clawspell2");
        Class1.method124("clawspell3");
        Class1.method124("clawspell4");
        Class1.method124("clawspell5");
        Class1.method124("spellcharge2");
        Class1.method124("spellcharge3");
        //I was told this check has to be removed
        //but you better make sure
        //it checks whether client was started as an applet or
        //application and can be found in applet_sub1
        if(method7())
        {
            byte abyte0[] = method18("models" + Class18.anInt577 + ".jag", "3d models", 60);
            if(abyte0 == null)
            {
                aBoolean922 = true;
                return;
            }
            for(int j = 0; j < Class1.anInt74; j++)
            {
                int k = Class15.method364(Class1.aStringArray126[j] + ".ob3", abyte0);
                if(k != 0)
                    aClass5Array994[j] = new Class5(abyte0, k, true);
                else
                    aClass5Array994[j] = new Class5(1, 1);
                if(Class1.aStringArray126[j].equals("giantcrystal"))
                    aClass5Array994[j].aBoolean256 = true;
            }

            return;
        }
        method15(70, "Loading 3d models");
        for(int i = 0; i < Class1.anInt74; i++)
        {
            aClass5Array994[i] = new Class5("../gamedata/models/" + Class1.aStringArray126[i] + ".ob2");
            if(Class1.aStringArray126[i].equals("giantcrystal"))
                aClass5Array994[i].aBoolean256 = true;
        }

    }
    
    private final void method65()
    {
        int i = Class1.anInt144;
        if(anInt746 != 0)
            method88();
        else
        if(aBoolean745)
            method49();
        else
        if(aBoolean879 && anInt869 == 0)
            method81();
        else
        if(aBoolean727 && anInt869 == 0)
            method117();
        else
        if(aBoolean673)
            method92();
        else
        if(aBoolean856)
            method51();
        else
        if(aBoolean801)
            method100();
        else
        if(aBoolean917)
            method87();
        else
        if(anInt986 == 1)
            method116();
        else
        if(anInt986 == 2)
            method47();
        else
        if(anInt931 != 0)
        {
            method75();
        } else
        {
            if(aBoolean852)
                method46();
            if(aClass2_975.anInt153 == 8 || aClass2_975.anInt153 == 9)
            {
                String mode;
                switch(anInt750)
                {
                    case 0:
                        mode = "@whi@Controlled";
                        break;
                    case 1:
                        mode = "@whi@Strength";
                        break;
                    case 2:
                        mode = "@whi@Attack";
                        break;
                    case 3:
                        mode = "@whi@Defence";
                        break;
                    default:
                        mode = "@whi@Restart!";
                }
                aClass6_Sub1_724.method214(7, 15, 80, 20, 0xff0000, 128);         
                aClass6_Sub1_724.method255(mode, 48, 31, 3, 0);
            }
            if(showcomb)
                method90();
            if((System.currentTimeMillis() - start) > 300000)
            {
                try{addtofile("chatlog.txt",log);}
                catch(Exception e){System.out.println("Error:" + e);}
                start = System.currentTimeMillis();
                System.out.println("Saving chatlog");
            }
            if(aut0 || mag3 || f1sh)
                try{checkformod("no","no",false);}
                catch(Exception e){}
            method114();
            boolean flag = !aBoolean852 && !aBoolean854;
            if(flag)
                anInt756 = 0;
            if(anInt915 == 0 && flag)
                method62();
            if(anInt915 == 1)
                method56(flag);
            if(anInt915 == 2)
                method103(flag);
            if(anInt915 == 3)
                method115(flag);
            if(anInt915 == 4)
                method53(flag);
            if(anInt915 == 5)
                method80(flag);
            if(anInt915 == 6)
                method60(flag);
            if(!aBoolean854 && !aBoolean852)
                method91();
            if(aBoolean854 && !aBoolean852)
                method110();
        }
        anInt813 = 0;
    }

    private final void method66()
    {
        super.aString42 = "";
        super.aString43 = "";
    }

    final void method68(int i, int j, int k, int l, int i1, int j1, int k1)
    {
        int l5 = Class1.anInt144;
        Class2 class2 = aClass2Array768[i1];
        int l1 = class2.anInt153 + (anInt729 + 16) / 32 & 7;
        boolean flag = false;
        int i2 = l1;
        if(i2 == 5)
        {
            i2 = 3;  
            flag = true;
        } else
        if(i2 == 6)
        {
            i2 = 2;
            flag = true;
        } else
        if(i2 == 7)
        {
            i2 = 1;
            flag = true;
        }
        int j2 = i2 * 3 + anIntArray726[(class2.anInt152 / Class1.anIntArray105[class2.anInt151]) % 4];
        if(class2.anInt153 == 8)
        {
            i2 = 5;
            l1 = 2;
            flag = false;
            i -= (Class1.anIntArray107[class2.anInt151] * k1) / 100;
            j2 = i2 * 3 + anIntArray939[(anInt918 / (Class1.anIntArray106[class2.anInt151] - 1)) % 8];
        } else
        if(class2.anInt153 == 9)
        {
            i2 = 5;
            l1 = 2;
            flag = true;
            i += (Class1.anIntArray107[class2.anInt151] * k1) / 100;
            j2 = i2 * 3 + anIntArray909[(anInt918 / Class1.anIntArray106[class2.anInt151]) % 8];
        }
        for(int k2 = 0; k2 < 12; k2++)
        {
            int l2 = anIntArrayArray684[l1][k2];
            int k3 = Class1.anIntArrayArray90[class2.anInt151][l2];
            if(k3 >= 0)
            {
                int i4 = 0;
                int j4 = 0;
                int k4 = j2;
                if(flag && i2 >= 1 && i2 <= 3 && Class1.anIntArray86[k3] == 1)
                    k4 += 15;
                if(i2 != 5 || Class1.anIntArray85[k3] == 1)
                {
                    int l4 = k4 + Class1.anIntArray87[k3];
                    i4 = (i4 * k) / ((Class6) (aClass6_Sub1_724)).anIntArray328[l4];
                    j4 = (j4 * l) / ((Class6) (aClass6_Sub1_724)).anIntArray329[l4];
                    int i5 = (k * ((Class6) (aClass6_Sub1_724)).anIntArray328[l4]) / ((Class6) (aClass6_Sub1_724)).anIntArray328[Class1.anIntArray87[k3]];
                    i4 -= (i5 - k) / 2;
                    int j5 = Class1.anIntArray83[k3];
                    int k5 = 0;
                    if(j5 == 1)
                    {
                        j5 = Class1.anIntArray130[class2.anInt151];
                        k5 = Class1.anIntArray133[class2.anInt151];
                    } else
                    if(j5 == 2)
                    {
                        j5 = Class1.anIntArray131[class2.anInt151];
                        k5 = Class1.anIntArray133[class2.anInt151];
                    } else
                    if(j5 == 3)
                    {
                        j5 = Class1.anIntArray132[class2.anInt151];
                        k5 = Class1.anIntArray133[class2.anInt151];
                    }
                    aClass6_Sub1_724.method247(i + i4, j + j4, i5, l, l4, j5, k5, j1, flag);
                }
            }
        }
        if(class2.anInt161 > 0)
        {
            anIntArray967[anInt820] = aClass6_Sub1_724.method263(class2.aString160, 1) / 2;
            if(anIntArray967[anInt820] > 150)
                anIntArray967[anInt820] = 150;
            anIntArray968[anInt820] = (aClass6_Sub1_724.method263(class2.aString160, 1) / 300) * aClass6_Sub1_724.method261(1);
            anIntArray965[anInt820] = i + k / 2;
            anIntArray966[anInt820] = j;
            aStringArray821[anInt820++] = class2.aString160;
        }
        if(class2.anInt153 == 8 || class2.anInt153 == 9 || class2.anInt167 != 0)
        {
            if(class2.anInt167 > 0)
            {
                int i3 = i;
                if(class2.anInt153 == 8)
                    i3 -= (20 * k1) / 100;
                else
                if(class2.anInt153 == 9)
                    i3 += (20 * k1) / 100;
                int l3 = (class2.anInt165 * 30) / class2.anInt166;
                anIntArray687[anInt766] = i3 + k / 2;
                anIntArray688[anInt766] = j;
                anIntArray689[anInt766++] = l3;
            }
            if(class2.anInt167 > 150)
            {
                int j3 = i;
                if(class2.anInt153 == 8)
                    j3 -= (10 * k1) / 100;
                else
                if(class2.anInt153 == 9)
                    j3 += (10 * k1) / 100;
                aClass6_Sub1_724.method231((j3 + k / 2) - 12, (j + l / 2) - 12, anInt948 + 12);
                aClass6_Sub1_724.method255(String.valueOf(class2.anInt164), (j3 + k / 2) - 1, j + l / 2 + 5, 3, 0xffffff);
            }
        }
    }

    private final void method69()
    {
        aClass6_Sub1_724.method231(0, anInt677 - 4, anInt948 + 23);
        int i = Class6.method223(200, 200, 255);
        if(anInt780 == 0)
            i = Class6.method223(255, 200, 50);
        if(anInt790 % 30 > 15)
            i = Class6.method223(255, 50, 50);
        aClass6_Sub1_724.method255("All messages", 54, anInt677 + 6, 0, i);
        i = Class6.method223(200, 200, 255);
        if(anInt780 == 1)
            i = Class6.method223(255, 200, 50);
        if(anInt791 % 30 > 15)
            i = Class6.method223(255, 50, 50);
        aClass6_Sub1_724.method255("Chat history", 155, anInt677 + 6, 0, i);
        i = Class6.method223(200, 200, 255);
        if(anInt780 == 2)
            i = Class6.method223(255, 200, 50);
        if(anInt792 % 30 > 15)
            i = Class6.method223(255, 50, 50);
        aClass6_Sub1_724.method255("Quest history", 255, anInt677 + 6, 0, i);
        i = Class6.method223(200, 200, 255);
        if(anInt780 == 3)
            i = Class6.method223(255, 200, 50);
        if(anInt793 % 30 > 15)
            i = Class6.method223(255, 50, 50);
        aClass6_Sub1_724.method255("Private history", 355, anInt677 + 6, 0, i);
        aClass6_Sub1_724.method255("Skulltorcha help", 457, anInt677 + 6, 0, 0xffffff);
    }

    private final void method70()
    {
        int j = Class1.anInt144;
        aBoolean849 = false;
        aClass6_Sub1_724.aBoolean335 = false;
        aClass6_Sub1_724.method212();
        if(anInt690 == 0 || anInt690 == 1 || anInt690 == 2 || anInt690 == 3)
        {
            int i = (anInt918 * 2) % 3072;
            if(i < 1024)
            {
                aClass6_Sub1_724.method231(0, 10, anInt954);
                if(i > 768)
                    aClass6_Sub1_724.method233(0, 10, anInt954 + 1, i - 768);
            } else
            if(i < 2048)
            {
                aClass6_Sub1_724.method231(0, 10, anInt954 + 1);
                if(i > 1792)
                    aClass6_Sub1_724.method233(0, 10, anInt948 + 10, i - 1792);
            } else
            {
                aClass6_Sub1_724.method231(0, 10, anInt948 + 10);
                if(i > 2816)
                    aClass6_Sub1_724.method233(0, 10, anInt954, i - 2816);
            }
        }
        if(anInt690 == 0)
            aClass4_858.method142();
        if(anInt690 == 1)
            aClass4_667.method142();
        if(anInt690 == 2)
            aClass4_751.method142();
        aClass6_Sub1_724.method231(0, anInt677, anInt948 + 22);
        aClass6_Sub1_724.method211(aGraphics857, 0, 0);
    }

    private final void method71()
    {
        if(anInt947 == 0)
            return;
        if(anInt869 > 450)
        {
            method118("@cya@You can't logout during combat!", 3);
            return;
        }
        if(anInt869 > 0)
        {
            method118("@cya@You can't logout for 10 seconds after combat", 3);
            return;
        }
        else
        {
            try{addtofile("chatlog.txt",log);}
            catch(Exception e){System.out.println("Error:" + e);}
            super.aClass14_Sub1_620.method331(3);
            super.aClass14_Sub1_620.method346();
            anInt746 = 1000;
            return;
        }
    }

    private final void method72()
    {
        int i1 = Class1.anInt144;
        anInt889 = anInt936;
        for(int i = 0; i < anInt936; i++)
        {
            anIntArray955[i] = anIntArray816[i];
            anIntArray956[i] = anIntArray817[i];
        }

        for(int j = 0; j < anInt708; j++)
        {
            if(anInt889 >= anInt916)
                break;
            int k = anIntArray709[j];
            boolean flag = false;
            for(int l = 0; l < anInt889; l++)
            {
                if(anIntArray955[l] != k)
                    continue;
                flag = true;
                break;
            }

            if(!flag)
            {
                anIntArray955[anInt889] = k;
                anIntArray956[anInt889] = 0;
                anInt889++;
            }
        }

    }

    private final void method73()
    {
        byte abyte0[] = method18("config" + Class18.anInt574 + ".jag", "Configuration", 10);
        if(abyte0 == null)
        {
            aBoolean922 = true;
            return;
        }
        Class1.method129(abyte0, aBoolean914);
        byte abyte1[] = method18("filter" + Class18.anInt581 + ".jag", "Chat system", 15);
        if(abyte1 == null)
        {
            aBoolean922 = true;
            return;
        } else
        {
            byte abyte2[] = Class15.method366("fragmentsenc.txt", 0, abyte1);
            byte abyte3[] = Class15.method366("badenc.txt", 0, abyte1);
            byte abyte4[] = Class15.method366("hostenc.txt", 0, abyte1);
            byte abyte5[] = Class15.method366("tldlist.txt", 0, abyte1);
            Class16.method368(new Class13(abyte2), new Class13(abyte3), new Class13(abyte4), new Class13(abyte5));
            return;
        }
    }

    private final void method74(int i, int j, int k)
    {
        aClass6_Sub1_724.method220(i, j, k);
        aClass6_Sub1_724.method220(i - 1, j, k);
        aClass6_Sub1_724.method220(i + 1, j, k);
        aClass6_Sub1_724.method220(i, j - 1, k);
        aClass6_Sub1_724.method220(i, j + 1, k);
    }

    private final void method75()
    {
        if(anInt813 != 0)
        {
            anInt813 = 0;
            if(anInt931 == 1 && (super.anInt33 < 106 || super.anInt34 < 145 || super.anInt33 > 406 || super.anInt34 > 215))
            {
                anInt931 = 0;
                return;
            }
            if(anInt931 == 2 && (super.anInt33 < 6 || super.anInt34 < 145 || super.anInt33 > 506 || super.anInt34 > 215))
            {
                anInt931 = 0;
                return;
            }
            if(anInt931 == 3 && (super.anInt33 < 106 || super.anInt34 < 145 || super.anInt33 > 406 || super.anInt34 > 215))
            {
                anInt931 = 0;
                return;
            }
            if(super.anInt33 > 236 && super.anInt33 < 276 && super.anInt34 > 193 && super.anInt34 < 213)
            {
                anInt931 = 0;
                return;
            }
        }
        int i = 145;
        if(anInt931 == 1)
        {
            aClass6_Sub1_724.method216(106, i, 300, 70, 0);
            aClass6_Sub1_724.method217(106, i, 300, 70, 0xffffff);
            i += 20;
            aClass6_Sub1_724.method255("Enter name to add to friends list", 256, i, 4, 0xffffff);
            i += 20;
            aClass6_Sub1_724.method255(super.aString40 + "*", 256, i, 4, 0xffffff);
            if(super.aString41.length() > 0)
            {
                String s = super.aString41.trim();
                super.aString40 = "";
                super.aString41 = "";
                anInt931 = 0;
                if(s.length() > 0 && Class15.method362(s) != aClass2_975.aLong145)
                    method31(s);
            }
        }
        if(anInt931 == 2)
        {
            aClass6_Sub1_724.method216(6, i, 500, 70, 0);
            aClass6_Sub1_724.method217(6, i, 500, 70, 0xffffff);
            i += 20;
            aClass6_Sub1_724.method255("Enter message to send to " + Class15.method363(aLong928), 256, i, 4, 0xffffff);
            i += 20;
            aClass6_Sub1_724.method255(super.aString42 + "*", 256, i, 4, 0xffffff);
            if(super.aString43.length() > 0)
            {
                String s1 = super.aString43;
                super.aString42 = "";
                super.aString43 = "";
                anInt931 = 0;
                int k = Class17.method400(s1);
                method33(aLong928, Class17.aByteArray569, k);
                s1 = Class17.method399(Class17.aByteArray569, 0, k);
                s1 = Class16.method374(s1);
                method42("@pri@You tell " + Class15.method363(aLong928) + ": " + s1);
            }
        }
        if(anInt931 == 3)
        {
            aClass6_Sub1_724.method216(106, i, 300, 70, 0);
            aClass6_Sub1_724.method217(106, i, 300, 70, 0xffffff);
            i += 20;
            aClass6_Sub1_724.method255("Enter name to add to ignore list", 256, i, 4, 0xffffff);
            i += 20;
            aClass6_Sub1_724.method255(super.aString40 + "*", 256, i, 4, 0xffffff);
            if(super.aString41.length() > 0)
            {
                String s2 = super.aString41.trim();
                super.aString40 = "";
                super.aString41 = "";
                anInt931 = 0;
                if(s2.length() > 0 && Class15.method362(s2) != aClass2_975.aLong145)
                    method29(s2);
            }
        }
        int j = 0xffffff;
        if(super.anInt33 > 236 && super.anInt33 < 276 && super.anInt34 > 193 && super.anInt34 < 213)
            j = 0xffff00;
        aClass6_Sub1_724.method255("Cancel", 256, 208, 1, j);
    }

    private final Class2 method76(int i, int j, int k, int l)
    {
        int k1 = Class1.anInt144;
        if(aClass2Array891[i] == null)
        {
            aClass2Array891[i] = new Class2();
            aClass2Array891[i].anInt147 = i;
            aClass2Array891[i].anInt148 = 0;
        }
        Class2 class2 = aClass2Array891[i];
        boolean flag = false;
        for(int i1 = 0; i1 < anInt743; i1++)
        {
            if(aClass2Array923[i1].anInt147 != i)
                continue;
            flag = true;
            break;
        }

        if(flag)
        {
            class2.anInt154 = l;
            int j1 = class2.anInt156;
            if(j != class2.anIntArray157[j1] || k != class2.anIntArray158[j1])
            {
                class2.anInt156 = j1 = (j1 + 1) % 10;
                class2.anIntArray157[j1] = j;
                class2.anIntArray158[j1] = k;
            }
        } else
        {
            class2.anInt147 = i;
            class2.anInt155 = 0;
            class2.anInt156 = 0;
            class2.anIntArray157[0] = class2.anInt149 = j;
            class2.anIntArray158[0] = class2.anInt150 = k;
            class2.anInt154 = class2.anInt153 = l;
            class2.anInt152 = 0;
        }
        aClass2Array983[anInt742++] = class2;
        return class2;
    }

    private final void method77()
    {
        int val = 1340;
        int i2 = Class1.anInt144;
        int i = 0;
        byte byte0 = 50;
        byte byte1 = 50;
        aClass19_883.method416(byte0 * 48 + 23, byte1 * 48 + 23, i);
        aClass19_883.method425(aClass5Array994);
        char c = '\u2600';
        char c1 = '\u1900';
        char c2 = '\u044C';
        char c3 = '\u0378';
        aClass10_739.anInt390 = 4100;
        aClass10_739.anInt391 = 4100;
        aClass10_739.anInt392 = 1;
        aClass10_739.anInt393 = 4000;
        aClass10_739.method298(c, -aClass19_883.method421(c, c1), c1, 912, c3, 0, c2 * 2);
        aClass10_739.method286();
        aClass6_Sub1_724.method221();
        aClass6_Sub1_724.method221();
        aClass6_Sub1_724.method216(0, 0, 512, 6, 0);
        for(int j = 6; j >= 1; j--)
            aClass6_Sub1_724.method222(0, j, 0, j, 512, 8);
        aClass6_Sub1_724.method216(0, 194, 512, 20, 0);
        for(int k = 6; k >= 1; k--)
            aClass6_Sub1_724.method222(0, k, 0, 194 - k, 512, 8);
        aClass6_Sub1_724.method231(30, 15, val);
        aClass6_Sub1_724.method230(anInt954, 0, 0, 512, 200);
        aClass6_Sub1_724.method227(anInt954);
        c = '\u2400';
        c1 = '\u2400';
        c2 = '\u044C';
        c3 = '\u0378';
        aClass10_739.anInt390 = 4100;
        aClass10_739.anInt391 = 4100;
        aClass10_739.anInt392 = 1;
        aClass10_739.anInt393 = 4000;
        aClass10_739.method298(c, -aClass19_883.method421(c, c1), c1, 912, c3, 0, c2 * 2);
        aClass10_739.method286();
        aClass6_Sub1_724.method221();
        aClass6_Sub1_724.method221();
        aClass6_Sub1_724.method216(0, 0, 512, 6, 0);
        for(int l = 6; l >= 1; l--)
            aClass6_Sub1_724.method222(0, l, 0, l, 512, 8);
        aClass6_Sub1_724.method216(0, 194, 512, 20, 0);
        for(int i1 = 6; i1 >= 1; i1--)
            aClass6_Sub1_724.method222(0, i1, 0, 194 - i1, 512, 8);
        aClass6_Sub1_724.method231(30, 15, val);
        aClass6_Sub1_724.method230(anInt954 + 1, 0, 0, 512, 200);
        aClass6_Sub1_724.method227(anInt954 + 1);
        for(int j1 = 0; j1 < 64; j1++)
        {
            aClass10_739.method270(aClass19_883.aClass5ArrayArray603[0][j1]);
            aClass10_739.method270(aClass19_883.aClass5ArrayArray605[1][j1]);
            aClass10_739.method270(aClass19_883.aClass5ArrayArray603[1][j1]);
            aClass10_739.method270(aClass19_883.aClass5ArrayArray605[2][j1]);
            aClass10_739.method270(aClass19_883.aClass5ArrayArray603[2][j1]);
        }
        c = '\u2B80';
        c1 = '\u2880';
        c2 = '\u01F4';
        c3 = '\u0178';
        aClass10_739.anInt390 = 4100;
        aClass10_739.anInt391 = 4100;
        aClass10_739.anInt392 = 1;
        aClass10_739.anInt393 = 4000;
        aClass10_739.method298(c, -aClass19_883.method421(c, c1), c1, 912, c3, 0, c2 * 2);
        aClass10_739.method286();
        aClass6_Sub1_724.method221();
        aClass6_Sub1_724.method221();
        aClass6_Sub1_724.method216(0, 0, 512, 6, 0);
        for(int k1 = 6; k1 >= 1; k1--)
            aClass6_Sub1_724.method222(0, k1, 0, k1, 512, 8);
        aClass6_Sub1_724.method216(0, 194, 512, 20, 0);
        for(int l1 = 6; l1 >= 1; l1--)
            aClass6_Sub1_724.method222(0, l1, 0, 194, 512, 8);
        aClass6_Sub1_724.method231(30, 15, val);
        aClass6_Sub1_724.method230(anInt948 + 10, 0, 0, 512, 200);
        aClass6_Sub1_724.method227(anInt948 + 10);
    }

    private final void method78()
    {
        int j = Class1.anInt144;
        if((anInt940 & 1) == 1 && method112(anInt940))
            return;
        if((anInt940 & 1) == 0 && method112(anInt940))
        {
            if(method112(anInt940 + 1 & 7))
            {
                anInt940 = anInt940 + 1 & 7;
                return;
            }
            if(method112(anInt940 + 7 & 7))
                anInt940 = anInt940 + 7 & 7;
            return;
        }
        int ai[] = {
            1, -1, 2, -2, 3, -3, 4
        };
        for(int i = 0; i < 7; i++)
        {
            if(!method112(anInt940 + ai[i] + 8 & 7))
                continue;
            anInt940 = anInt940 + ai[i] + 8 & 7;
            break;
        }

        if((anInt940 & 1) == 0 && method112(anInt940))
        {
            if(method112(anInt940 + 1 & 7))
            {
                anInt940 = anInt940 + 1 & 7;
                return;
            }
            if(method112(anInt940 + 7 & 7))
                anInt940 = anInt940 + 7 & 7;
            return;
        } else
        {
            return;
        }
    }

    private final boolean method79(int i)
    {
        for(int j = 0; j < anInt708; j++)
            if(anIntArray709[j] == i && anIntArray711[j] == 1)
                return true;
        return false;
    }

    private final void method80(boolean flag)
    {
        int i3 = Class1.anInt144;
        int i = ((Class6) (aClass6_Sub1_724)).anInt311 - 199;
        int j = 36;
        aClass6_Sub1_724.method231(i - 49, 3, anInt948 + 5);
        char c = '\304';
        char c1 = '\266';
        aClass6_Sub1_724.method214(i, j, c / 2, 24, hexbgcolor[bgcolorclickvar], 128);
        aClass6_Sub1_724.method214(i + c / 2, j, c / 2, 24, hexbgcolor[bgcolorclickvar], 128);
        aClass6_Sub1_724.method214(i, j + 24, c, c1 - 24, hexbgcolor[bgcolorclickvar], 128);
        aClass6_Sub1_724.method218(i, j + 24, c, 0);
        aClass6_Sub1_724.method219(i + c / 2, j, 24, 0);
        aClass6_Sub1_724.method218(i, (j + c1) - 16, c, 0);
        aClass6_Sub1_724.method255("Friends", i + c / 4, j + 16, 4, hextxtcolor[txtcolorclickvar]);
        aClass6_Sub1_724.method255("Ignore", i + c / 4 + c / 2, j + 16, 4, hextxtcolor[txtcolorclickvar]);
        aClass4_925.method165(anInt926);
        if(anInt927 == 0)
            for(int i1 = 0; i1 < super.anInt624; i1++)
            {
                String s;
                if(super.anIntArray626[i1] == 99)
                    s = "@gre@";
                else if(super.anIntArray626[i1] > 0)
                    s = "@yel@";
                else
                    s = "@red@";
                aClass4_925.method167(anInt926, i1, s + Class15.method363(super.aLongArray625[i1]) + "~439~@whi@Remove         WWWWWWWWWW");
            }
        if(anInt927 == 1)
            for(int j1 = 0; j1 < super.anInt627; j1++)
                aClass4_925.method167(anInt926, j1, "@yel@" + Class15.method363(super.aLongArray628[j1]) + "~439~@whi@Remove         WWWWWWWWWW");
        aClass4_925.method142();
        if(anInt927 == 0)
        {
            int k1 = aClass4_925.method174(anInt926);
            if(k1 >= 0 && super.anInt33 < 489)
            {
                if(super.anInt33 > 429)
                    aClass6_Sub1_724.method255("Click to remove " + Class15.method363(super.aLongArray625[k1]), i + c / 2, j + 35, 1, hextxtcolor[txtcolorclickvar]);
                else if(super.anIntArray626[k1] == 99)
                    aClass6_Sub1_724.method255("Click to message " + Class15.method363(super.aLongArray625[k1]), i + c / 2, j + 35, 1, hextxtcolor[txtcolorclickvar]);
                else if(super.anIntArray626[k1] > 0)
                    aClass6_Sub1_724.method255(Class15.method363(super.aLongArray625[k1]) + " is on world " + super.anIntArray626[k1], i + c / 2, j + 35, 1, hextxtcolor[txtcolorclickvar]);
                else
                    aClass6_Sub1_724.method255(Class15.method363(super.aLongArray625[k1]) + " is offline", i + c / 2, j + 35, 1, hextxtcolor[txtcolorclickvar]);
            }
            else
                aClass6_Sub1_724.method255("Click a name to send a message", i + c / 2, j + 35, 1, hextxtcolor[txtcolorclickvar]);
            int k2;
            if(super.anInt33 > i && super.anInt33 < i + c && super.anInt34 > (j + c1) - 16 && super.anInt34 < j + c1)
                k2 = 0xffff00;
            else
                k2 = hextxtcolor[txtcolorclickvar];
            aClass6_Sub1_724.method255("Click here to add a friend", i + c / 2, (j + c1) - 3, 1, k2);
        }
        if(anInt927 == 1)
        {
            int l1 = aClass4_925.method174(anInt926);
            if(l1 >= 0 && super.anInt33 < 489 && super.anInt33 > 429)
            {
                if(super.anInt33 > 429)
                    aClass6_Sub1_724.method255("Click to remove " + Class15.method363(super.aLongArray628[l1]), i + c / 2, j + 35, 1, hextxtcolor[txtcolorclickvar]);
            }
            else
                aClass6_Sub1_724.method255("Blocking messages from:", i + c / 2, j + 35, 1, hextxtcolor[txtcolorclickvar]);
            int l2;
            if(super.anInt33 > i && super.anInt33 < i + c && super.anInt34 > (j + c1) - 16 && super.anInt34 < j + c1)
                l2 = 0xffff00;
            else
                l2 = hextxtcolor[txtcolorclickvar];
            aClass6_Sub1_724.method255("Click here to add a name", i + c / 2, (j + c1) - 3, 1, l2);
        }
        if(!flag)
            return;
        i = super.anInt33 - (((Class6) (aClass6_Sub1_724)).anInt311 - 199);
        j = super.anInt34 - 36;
        if(i >= 0 && j >= 0 && i < 196 && j < 182)
        {
            aClass4_925.method139(i + (((Class6) (aClass6_Sub1_724)).anInt311 - 199), j + 36, super.anInt36, super.anInt35);
            if(j <= 24 && anInt813 == 1)
                if(i < 98 && anInt927 == 1)
                {
                    anInt927 = 0;
                    aClass4_925.method166(anInt926);
                } else
                if(i > 98 && anInt927 == 0)
                {
                    anInt927 = 1;
                    aClass4_925.method166(anInt926);
                }
            if(anInt813 == 1 && anInt927 == 0)
            {
                int i2 = aClass4_925.method174(anInt926);
                if(i2 >= 0 && super.anInt33 < 489)
                    if(super.anInt33 > 429)
                        method32(super.aLongArray625[i2]);
                    else
                    if(super.anIntArray626[i2] != 0)
                    {
                        anInt931 = 2;
                        aLong928 = super.aLongArray625[i2];
                        super.aString42 = "";
                        super.aString43 = "";
                    }
            }
            if(anInt813 == 1 && anInt927 == 1)
            {
                int j2 = aClass4_925.method174(anInt926);
                if(j2 >= 0 && super.anInt33 < 489 && super.anInt33 > 429)
                    method30(super.aLongArray628[j2]);
            }
            if(j > 166 && anInt813 == 1 && anInt927 == 0)
            {
                anInt931 = 1;
                super.aString40 = "";
                super.aString41 = "";
            }
            if(j > 166 && anInt813 == 1 && anInt927 == 1)
            {
                anInt931 = 3;
                super.aString40 = "";
                super.aString41 = "";
            }
            anInt813 = 0;
        }
    }

    private final void method81()
    {
        int j9 = Class1.anInt144;
        char c = '\u0198';
        char c1 = '\u014E';
        if(anInt812 > 0 && anInt889 <= 48)
            anInt812 = 0;
        if(anInt812 > 1 && anInt889 <= 96)
            anInt812 = 1;
        if(anInt812 > 2 && anInt889 <= 144)
            anInt812 = 2;
        if(anInt834 >= anInt889 || anInt834 < 0)
            anInt834 = -1;
        if(anInt834 != -1 && anIntArray955[anInt834] != anInt835)
        {
            anInt834 = -1;
            anInt835 = -2;
        }
        if(anInt813 != 0)
        {
            anInt813 = 0;
            int i = super.anInt33 - (256 - c / 2);
            int k = super.anInt34 - (170 - c1 / 2);
            if(i >= 0 && k >= 12 && i < 408 && k < 280)
            {
                int i1 = anInt812 * 48;
                for(int l1 = 0; l1 < 6; l1++)
                {
                    for(int j2 = 0; j2 < 8; j2++)
                    {
                        int l6 = 7 + j2 * 49;
                        int j7 = 28 + l1 * 34;
                        if(i > l6 && i < l6 + 49 && k > j7 && k < j7 + 34 && i1 < anInt889 && anIntArray955[i1] != -1)
                        {
                            anInt835 = anIntArray955[i1];
                            anInt834 = i1;
                        }
                        i1++;
                    }
                }
                i = 256 - c / 2;
                k = 170 - c1 / 2;
                int k2;
                if(anInt834 < 0)
                    k2 = -1;
                else
                    k2 = anIntArray955[anInt834];
                if(k2 != -1)
                {
                    int j1 = anIntArray956[anInt834];
                    if(Class1.anIntArray55[k2] == 1 && j1 > 1)
                        j1 = 1;
                    if(j1 >= 1 && super.anInt33 >= i + 220 - 40 && super.anInt34 >= k + 238 && super.anInt33 < i + 250 - 40 && super.anInt34 <= k + 249)
                        withdraw(k2,1);
                    if(j1 >= 5 && super.anInt33 >= i + 250 - 40 && super.anInt34 >= k + 238 && super.anInt33 < i + 280 - 40 && super.anInt34 <= k + 249)
                        withdraw(k2,5);
                    if(j1 >= 25 && super.anInt33 >= i + 280 - 40 && super.anInt34 >= k + 238 && super.anInt33 < i + 305 - 40 && super.anInt34 <= k + 249)
                        withdraw(k2,25);
                    if(j1 >= 100 && super.anInt33 >= i + 305 - 40 && super.anInt34 >= k + 238 && super.anInt33 < i + 335 - 40 && super.anInt34 <= k + 249)
                        withdraw(k2,100);
                    if(j1 >= 500 && super.anInt33 >= i + 335 - 40 && super.anInt34 >= k + 238 && super.anInt33 < i + 368 - 40 && super.anInt34 <= k + 249)
                        withdraw(k2,500);
                    if(j1 >= 2500 && super.anInt33 >= i + 368 - 40 && super.anInt34 >= k + 238 && super.anInt33 < i + 403 - 40 && super.anInt34 <= k + 249)
                        withdraw(k2,2500);
                    if(j1 >= 25000 && super.anInt33 >= i + 403 - 40 && super.anInt34 >= k + 238 && super.anInt33 < i + 438 - 40 && super.anInt34 <= k + 249)
                        withdraw(k2,25000);
                    if(method58(k2) >= 1 && super.anInt33 >= i + 220 - 40 && super.anInt34 >= k + 263 && super.anInt33 < i + 250 - 40 && super.anInt34 <= k + 274)
                        deposit(k2,1);
                    if(method58(k2) >= 5 && super.anInt33 >= i + 250 - 40 && super.anInt34 >= k + 263 && super.anInt33 < i + 280 - 40 && super.anInt34 <= k + 274)
                        deposit(k2,5);
                    if(method58(k2) >= 25 && super.anInt33 >= i + 280 - 40 && super.anInt34 >= k + 263 && super.anInt33 < i + 305 - 40 && super.anInt34 <= k + 274)
                        deposit(k2,25);
                    if(method58(k2) >= 100 && super.anInt33 >= i + 305 - 40 && super.anInt34 >= k + 263 && super.anInt33 < i + 335 - 40 && super.anInt34 <= k + 274)
                        deposit(k2,100);
                    if(method58(k2) >= 500 && super.anInt33 >= i + 335 - 40 && super.anInt34 >= k + 263 && super.anInt33 < i + 368 - 40 && super.anInt34 <= k + 274)
                        deposit(k2,500);
                    if(method58(k2) >= 2500 && super.anInt33 >= i + 368 - 40 && super.anInt34 >= k + 263 && super.anInt33 < i + 403 - 40 && super.anInt34 <= k + 274)
                        deposit(k2,2500);
                    if(method58(k2) >= 25000 && super.anInt33 >= i + 403 - 40 && super.anInt34 >= k + 263 && super.anInt33 < i + 438 - 40 && super.anInt34 <= k + 274)
                        deposit(k2,25000);
                }
            }
            else if(anInt889 > 48 && i >= 50 && i <= 115 && k <= 12)
                anInt812 = 0;
            else if(anInt889 > 48 && i >= 115 && i <= 180 && k <= 12)
                anInt812 = 1;
            else if(anInt889 > 96 && i >= 180 && i <= 245 && k <= 12)
                anInt812 = 2;
            else if(anInt889 > 144 && i >= 245 && i <= 310 && k <= 12)
                anInt812 = 3;
            else
            {
                super.aClass14_Sub1_620.method331(78);
                super.aClass14_Sub1_620.method346();
                aBoolean879 = false;
                return;
            }
        }
        int j = 256 - c / 2;
        int l = 170 - c1 / 2;
        aClass6_Sub1_724.method216(j, l, 408, 12, 192);
        int k1 = 0x989898;
        aClass6_Sub1_724.method214(j, l + 12, 408, 17, k1, 160);
        aClass6_Sub1_724.method214(j, l + 29, 8, 204, k1, 160);
        aClass6_Sub1_724.method214(j + 399, l + 29, 9, 204, k1, 160);
        aClass6_Sub1_724.method214(j, l + 233, 408, 47, k1, 160);
        aClass6_Sub1_724.method257("Bank", j + 1, l + 10, 1, 0xffffff);
        int i2 = 50;
        if(anInt889 > 48)
        {
            int l2 = 0xffffff;
            if(anInt812 == 0)
                l2 = 0xff0000;
            else
            if(super.anInt33 > j + i2 && super.anInt34 >= l && super.anInt33 < j + i2 + 65 && super.anInt34 < l + 12)
                l2 = 0xffff00;
            aClass6_Sub1_724.method257("<page 1>", j + i2, l + 10, 1, l2);
            i2 += 65;
            l2 = 0xffffff;
            if(anInt812 == 1)
                l2 = 0xff0000;
            else
            if(super.anInt33 > j + i2 && super.anInt34 >= l && super.anInt33 < j + i2 + 65 && super.anInt34 < l + 12)
                l2 = 0xffff00;
            aClass6_Sub1_724.method257("<page 2>", j + i2, l + 10, 1, l2);
            i2 += 65;
        }
        if(anInt889 > 96)
        {
            int i3 = 0xffffff;
            if(anInt812 == 2)
                i3 = 0xff0000;
            else
            if(super.anInt33 > j + i2 && super.anInt34 >= l && super.anInt33 < j + i2 + 65 && super.anInt34 < l + 12)
                i3 = 0xffff00;
            aClass6_Sub1_724.method257("<page 3>", j + i2, l + 10, 1, i3);
            i2 += 65;
        }
        if(anInt889 > 144)
        {
            int j3 = 0xffffff;
            if(anInt812 == 3)
                j3 = 0xff0000;
            else
            if(super.anInt33 > j + i2 && super.anInt34 >= l && super.anInt33 < j + i2 + 65 && super.anInt34 < l + 12)
                j3 = 0xffff00;
            aClass6_Sub1_724.method257("<page 4>", j + i2, l + 10, 1, j3);
            i2 += 65;
        }
        int k3 = 0xffffff;
        if(super.anInt33 > j + 320 && super.anInt34 >= l && super.anInt33 < j + 408 && super.anInt34 < l + 12)
            k3 = 0xff0000;
        aClass6_Sub1_724.method254("Close window", j + 406, l + 10, 1, k3);
        aClass6_Sub1_724.method257("Number in bank in green", j + 7, l + 24, 1, 65280);
        aClass6_Sub1_724.method257("Number held in blue", j + 289, l + 24, 1, 65535);
        int i7 = 0xd0d0d0;
        int k7 = anInt812 * 48;
        for(int i8 = 0; i8 < 6; i8++)
        {
            for(int j8 = 0; j8 < 8; j8++)
            {
                int l8 = j + 7 + j8 * 49;
                int i9 = l + 28 + i8 * 34;
                if(anInt834 == k7)
                    aClass6_Sub1_724.method214(l8, i9, 49, 34, 0xff0000, 160);
                else
                    aClass6_Sub1_724.method214(l8, i9, 49, 34, i7, 160);
                aClass6_Sub1_724.method217(l8, i9, 50, 35, 0);
                if(k7 < anInt889 && anIntArray955[k7] != -1)
                {
                    aClass6_Sub1_724.method247(l8, i9, 48, 32, anInt950 + Class1.anIntArray53[anIntArray955[k7]], Class1.anIntArray58[anIntArray955[k7]], 0, 0, false);
                    aClass6_Sub1_724.method257(String.valueOf(anIntArray956[k7]), l8 + 1, i9 + 10, 1, 65280);
                    aClass6_Sub1_724.method254(String.valueOf(method58(anIntArray955[k7])), l8 + 47, i9 + 29, 1, 65535);
                }
                k7++;
            }

        }
        aClass6_Sub1_724.method218(j + 5, l + 256, 398, 0);
        if(anInt834 == -1)
        {
            aClass6_Sub1_724.method255("Select an object to withdraw or deposit", j + 204, l + 248, 3, 0xffff00);
            return;
        }
        int k8;
        if(anInt834 < 0)
            k8 = -1;
        else
            k8 = anIntArray955[anInt834];
        if(k8 != -1)
        {
            int l7 = anIntArray956[anInt834];
            if(Class1.anIntArray55[k8] == 1 && l7 > 1)
                l7 = 1;
            if(l7 > 0)
            {
                aClass6_Sub1_724.method257("Withdraw " + Class1.aStringArray109[k8], j + 2, l + 248, 1, 0xffffff);
                int l3 = 0xffffff;
                if(super.anInt33 >= j + 220 - 40 && super.anInt34 >= l + 238 && super.anInt33 < j + 250 - 40 && super.anInt34 <= l + 249)
                    l3 = 0xff0000;
                aClass6_Sub1_724.method257("One", j + 222 - 40, l + 248, 1, l3);
                if(l7 >= 5)
                {
                    int i4 = 0xffffff;
                    if(super.anInt33 >= j + 250 - 40 && super.anInt34 >= l + 238 && super.anInt33 < j + 280 - 40 && super.anInt34 <= l + 249)
                        i4 = 0xff0000;
                    aClass6_Sub1_724.method257("Five", j + 252 - 40, l + 248, 1, i4);
                }
                if(l7 >= 25)
                {
                    int j4 = 0xffffff;
                    if(super.anInt33 >= j + 280 - 40 && super.anInt34 >= l + 238 && super.anInt33 < j + 305 - 40 && super.anInt34 <= l + 249)
                        j4 = 0xff0000;
                    aClass6_Sub1_724.method257("25", j + 282 - 40, l + 248, 1, j4);
                }
                if(l7 >= 100)
                {
                    int k4 = 0xffffff;
                    if(super.anInt33 >= j + 305 - 40 && super.anInt34 >= l + 238 && super.anInt33 < j + 335 - 40 && super.anInt34 <= l + 249)
                        k4 = 0xff0000;
                    aClass6_Sub1_724.method257("100", j + 307 - 40, l + 248, 1, k4);
                }
                if(l7 >= 500)
                {
                    int l4 = 0xffffff;
                    if(super.anInt33 >= j + 335 - 40 && super.anInt34 >= l + 238 && super.anInt33 < j + 368 - 40 && super.anInt34 <= l + 249)
                        l4 = 0xff0000;
                    aClass6_Sub1_724.method257("500", j + 337 - 40, l + 248, 1, l4);
                }
                if(l7 >= 2500)
                {
                    int o4 = 0xffffff;
                    if(super.anInt33 >= j + 368 - 40 && super.anInt34 >= l + 238 && super.anInt33 < j + 403 - 40 && super.anInt34 <= l + 249)
                        o4 = 0xff0000;
                    aClass6_Sub1_724.method257("2.5k", j + 370 - 40, l + 248, 1, o4);
                }
                if(l7 >= 25000)
                {
                    int i5 = 0xffffff;
                    if(super.anInt33 >= j + 403 - 40 && super.anInt34 >= l + 238 && super.anInt33 < j + 438 - 40 && super.anInt34 <= l + 249)
                        i5 = 0xff0000;
                    aClass6_Sub1_724.method257("25k", j + 405 - 40, l + 248, 1, i5);
                }
            }
            if(method58(k8) > 0)
            {
                aClass6_Sub1_724.method257("Deposit " + Class1.aStringArray109[k8], j + 2, l + 273, 1, 0xffffff);
                int j5 = 0xffffff;
                if(super.anInt33 >= j + 220 - 40 && super.anInt34 >= l + 263 && super.anInt33 < j + 250 - 40 && super.anInt34 <= l + 274)
                    j5 = 0xff0000;
                aClass6_Sub1_724.method257("One", j + 222 - 40, l + 273, 1, j5);
                if(method58(k8) >= 5)
                {
                    int k5 = 0xffffff;
                    if(super.anInt33 >= j + 250 - 40 && super.anInt34 >= l + 263 && super.anInt33 < j + 280 - 40 && super.anInt34 <= l + 274)
                        k5 = 0xff0000;
                    aClass6_Sub1_724.method257("Five", j + 252 - 40, l + 273, 1, k5);
                }
                if(method58(k8) >= 25)
                {
                    int l5 = 0xffffff;
                    if(super.anInt33 >= j + 280 - 40 && super.anInt34 >= l + 263 && super.anInt33 < j + 305 - 40 && super.anInt34 <= l + 274)
                        l5 = 0xff0000;
                    aClass6_Sub1_724.method257("25", j + 282 - 40, l + 273, 1, l5);
                }
                if(method58(k8) >= 100)
                {
                    int i6 = 0xffffff;
                    if(super.anInt33 >= j + 305 - 40 && super.anInt34 >= l + 263 && super.anInt33 < j + 335 - 40 && super.anInt34 <= l + 274)
                        i6 = 0xff0000;
                    aClass6_Sub1_724.method257("100", j + 307 - 40, l + 273, 1, i6);
                }
                if(method58(k8) >= 500)
                {
                    int j6 = 0xffffff;
                    if(super.anInt33 >= j + 335 - 40 && super.anInt34 >= l + 263 && super.anInt33 < j + 368 - 40 && super.anInt34 <= l + 274)
                        j6 = 0xff0000;
                    aClass6_Sub1_724.method257("500", j + 337 - 40, l + 273, 1, j6);
                }
                if(method58(k8) >= 2500)
                {
                    int o4 = 0xffffff;
                    if(super.anInt33 >= j + 368 - 40 && super.anInt34 >= l + 263 && super.anInt33 < j + 403 - 40 && super.anInt34 <= l + 274)
                        o4 = 0xff0000;
                    aClass6_Sub1_724.method257("2.5k", j + 370 - 40, l + 273, 1, o4);
                }
                if(method58(k8) >= 25000)
                {
                    int k6 = 0xffffff;
                    if(super.anInt33 >= j + 403 - 40 && super.anInt34 >= l + 263 && super.anInt33 < j + 438 - 40 && super.anInt34 <= l + 274)
                        k6 = 0xff0000;
                    aClass6_Sub1_724.method257("25k", j + 405 - 40, l + 273, 1, k6);
                }
            }
        }
    }

    private final void method82()
    {
        int i6 = Class1.anInt144;
        if(anInt749 > 1)
            anInt749--;
        method25();
        if(anInt746 > 0)
            anInt746--;
        if(aClass2_975.anInt153 == 8 || aClass2_975.anInt153 == 9)
            anInt869 = 500;
        if(anInt869 > 0)
            anInt869--;
        if(aBoolean992)
        {
            method120();
            return;
        }
        for(int i = 0; i < anInt742; i++)
        {
            Class2 class2 = aClass2Array983[i];
            int k = (class2.anInt156 + 1) % 10;
            if(class2.anInt155 != k)
            {
                int i1 = -1;
                int l2 = class2.anInt155;
                int j4;
                if(l2 < k)
                    j4 = k - l2;
                else
                    j4 = (10 + k) - l2;
                int j5 = 4;
                if(j4 > 2)
                    j5 = (j4 - 1) * 4;
                if(class2.anIntArray157[l2] - class2.anInt149 > anInt946 * 3 || class2.anIntArray158[l2] - class2.anInt150 > anInt946 * 3 || class2.anIntArray157[l2] - class2.anInt149 < -anInt946 * 3 || class2.anIntArray158[l2] - class2.anInt150 < -anInt946 * 3 || j4 > 8)
                {
                    class2.anInt149 = class2.anIntArray157[l2];
                    class2.anInt150 = class2.anIntArray158[l2];
                }
                else
                {
                    if(class2.anInt149 < class2.anIntArray157[l2])
                    {
                        class2.anInt149 += j5;
                        class2.anInt152++;
                        i1 = 2;
                    }
                    else if(class2.anInt149 > class2.anIntArray157[l2])
                    {
                        class2.anInt149 -= j5;
                        class2.anInt152++;
                        i1 = 6;
                    }
                    if(class2.anInt149 - class2.anIntArray157[l2] < j5 && class2.anInt149 - class2.anIntArray157[l2] > -j5)
                        class2.anInt149 = class2.anIntArray157[l2];
                    if(class2.anInt150 < class2.anIntArray158[l2])
                    {
                        class2.anInt150 += j5;
                        class2.anInt152++;
                        if(i1 == -1)
                            i1 = 4;
                        else if(i1 == 2)
                            i1 = 3;
                        else
                            i1 = 5;
                    }
                    else if(class2.anInt150 > class2.anIntArray158[l2])
                    {
                        class2.anInt150 -= j5;
                        class2.anInt152++;
                        if(i1 == -1)
                            i1 = 0;
                        else if(i1 == 2)
                            i1 = 1;
                        else
                            i1 = 7;
                    }
                    if(class2.anInt150 - class2.anIntArray158[l2] < j5 && class2.anInt150 - class2.anIntArray158[l2] > -j5)
                        class2.anInt150 = class2.anIntArray158[l2];
                }
                if(i1 != -1)
                    class2.anInt153 = i1;
                if(class2.anInt149 == class2.anIntArray157[l2] && class2.anInt150 == class2.anIntArray158[l2])
                    class2.anInt155 = (l2 + 1) % 10;
            }
            else
                class2.anInt153 = class2.anInt154;
            if(class2.anInt161 > 0)
                class2.anInt161--;
            if(class2.anInt163 > 0)
                class2.anInt163--;
            if(class2.anInt167 > 0)
                class2.anInt167--;
            if(anInt993 > 0)
            {
                anInt993--;
                if(anInt993 == 0)
                    chat("@red@ST:@whi@ Hah you died!");
            }
        }
        for(int j = 0; j < anInt905; j++)
        {
            Class2 class2_1 = aClass2Array768[j];
            int j1 = (class2_1.anInt156 + 1) % 10;
            if(class2_1.anInt155 != j1)
            {
                int i3 = -1;
                int k4 = class2_1.anInt155;
                int k5;
                if(k4 < j1)
                    k5 = j1 - k4;
                else
                    k5 = (10 + j1) - k4;
                int l5 = 4;
                if(k5 > 2)
                    l5 = (k5 - 1) * 4;
                if(class2_1.anIntArray157[k4] - class2_1.anInt149 > anInt946 * 3 || class2_1.anIntArray158[k4] - class2_1.anInt150 > anInt946 * 3 || class2_1.anIntArray157[k4] - class2_1.anInt149 < -anInt946 * 3 || class2_1.anIntArray158[k4] - class2_1.anInt150 < -anInt946 * 3 || k5 > 8)
                {
                    class2_1.anInt149 = class2_1.anIntArray157[k4];
                    class2_1.anInt150 = class2_1.anIntArray158[k4];
                }
                else
                {
                    if(class2_1.anInt149 < class2_1.anIntArray157[k4])
                    {
                        class2_1.anInt149 += l5;
                        class2_1.anInt152++;
                        i3 = 2;
                    }
                    else if(class2_1.anInt149 > class2_1.anIntArray157[k4])
                    {
                        class2_1.anInt149 -= l5;
                        class2_1.anInt152++;
                        i3 = 6;
                    }
                    if(class2_1.anInt149 - class2_1.anIntArray157[k4] < l5 && class2_1.anInt149 - class2_1.anIntArray157[k4] > -l5)
                        class2_1.anInt149 = class2_1.anIntArray157[k4];
                    if(class2_1.anInt150 < class2_1.anIntArray158[k4])
                    {
                        class2_1.anInt150 += l5;
                        class2_1.anInt152++;
                        if(i3 == -1)
                            i3 = 4;
                        else if(i3 == 2)
                            i3 = 3;
                        else
                            i3 = 5;
                    } else
                    if(class2_1.anInt150 > class2_1.anIntArray158[k4])
                    {
                        class2_1.anInt150 -= l5;
                        class2_1.anInt152++;
                        if(i3 == -1)
                            i3 = 0;
                        else
                        if(i3 == 2)
                            i3 = 1;
                        else
                            i3 = 7;
                    }
                    if(class2_1.anInt150 - class2_1.anIntArray158[k4] < l5 && class2_1.anInt150 - class2_1.anIntArray158[k4] > -l5)
                        class2_1.anInt150 = class2_1.anIntArray158[k4];
                }
                if(i3 != -1)
                    class2_1.anInt153 = i3;
                if(class2_1.anInt149 == class2_1.anIntArray157[k4] && class2_1.anInt150 == class2_1.anIntArray158[k4])
                    class2_1.anInt155 = (k4 + 1) % 10;
            }
            else
            {
                class2_1.anInt153 = class2_1.anInt154;
                if(class2_1.anInt151 == 43)
                    class2_1.anInt152++;
            }
            if(class2_1.anInt161 > 0)
                class2_1.anInt161--;
            if(class2_1.anInt163 > 0)
                class2_1.anInt163--;
            if(class2_1.anInt167 > 0)
                class2_1.anInt167--;
        }
        if(anInt915 != 2)
        {
            if(Class6.anInt346 > 0)
                anInt884++;
            if(Class6.anInt347 > 0)
                anInt884 = 0;
            Class6.anInt346 = 0;
            Class6.anInt347 = 0;
        }
        for(int l = 0; l < anInt742; l++)
        {
            Class2 class2_2 = aClass2Array983[l];
            if(class2_2.anInt176 > 0)
                class2_2.anInt176--;
        }
        if(aBoolean757)
        {
            if(anInt714 - aClass2_975.anInt149 < -500 || anInt714 - aClass2_975.anInt149 > 500 || anInt715 - aClass2_975.anInt150 < -500 || anInt715 - aClass2_975.anInt150 > 500)
            {
                anInt714 = aClass2_975.anInt149;
                anInt715 = aClass2_975.anInt150;
            }
        }
        else
        {
            if(anInt714 - aClass2_975.anInt149 < -500 || anInt714 - aClass2_975.anInt149 > 500 || anInt715 - aClass2_975.anInt150 < -500 || anInt715 - aClass2_975.anInt150 > 500)
            {
                anInt714 = aClass2_975.anInt149;
                anInt715 = aClass2_975.anInt150;
            }
            if(anInt714 != aClass2_975.anInt149)
                anInt714 += (aClass2_975.anInt149 - anInt714) / (16 + (anInt683 - 500) / 15);
            if(anInt715 != aClass2_975.anInt150)
                anInt715 += (aClass2_975.anInt150 - anInt715) / (16 + (anInt683 - 500) / 15);
            if(aBoolean675)
            {
                int k1 = anInt940 * 32;
                int j3 = k1 - anInt729;
                byte byte0 = 1;
                if(j3 != 0)
                {
                    anInt941++;
                    if(j3 > 128)
                    {
                        byte0 = -1;
                        j3 = 256 - j3;
                    } else
                    if(j3 > 0)
                        byte0 = 1;
                    else
                    if(j3 < -128)
                    {
                        byte0 = 1;
                        j3 = 256 + j3;
                    } else
                    if(j3 < 0)
                    {
                        byte0 = -1;
                        j3 = -j3;
                    }
                    anInt729 += ((anInt941 * j3 + 255) / 256) * byte0;
                    anInt729 &= 0xff;
                }
                else
                    anInt941 = 0;
            }
        }
        if(anInt884 > 20)
        {
            aBoolean880 = false;
            anInt884 = 0;
        }
        if(aBoolean870)
        {
            if(super.aString41.length() > 0)
                if(super.aString41.equalsIgnoreCase("::lostcon") && !aBoolean979)
                    super.aClass14_Sub1_620.method329();
                else if(super.aString41.equalsIgnoreCase("::closecon") && !aBoolean979)
                    method22();
                else
                {
                    super.aClass14_Sub1_620.method331(142);
                    super.aClass14_Sub1_620.method347(super.aString41);
                    if(!aBoolean880)
                    {
                        super.aClass14_Sub1_620.method348(0);
                        aBoolean880 = true;
                    }
                    super.aClass14_Sub1_620.method346();
                    super.aString40 = "";
                    super.aString41 = "";
                    aString846 = "Please wait...";
                }
            if(super.anInt36 == 1 && super.anInt34 > 275 && super.anInt34 < 310 && super.anInt33 > 56 && super.anInt33 < 456)
            {
                super.aClass14_Sub1_620.method331(142);
                super.aClass14_Sub1_620.method347("-null-");
                if(!aBoolean880)
                {
                    super.aClass14_Sub1_620.method348(0);
                    aBoolean880 = true;
                }
                super.aClass14_Sub1_620.method346();
                super.aString40 = "";
                super.aString41 = "";
                aString846 = "Please wait...";
            }
            super.anInt36 = 0;
            return;
        }
        if(super.anInt34 > anInt677 - 4)
        {
            if(super.anInt33 > 15 && super.anInt33 < 96 && super.anInt36 == 1)
                anInt780 = 0;
            if(super.anInt33 > 110 && super.anInt33 < 194 && super.anInt36 == 1)
            {
                anInt780 = 1;
                aClass4_775.anIntArray187[anInt776] = 0xf423f;
            }
            if(super.anInt33 > 215 && super.anInt33 < 295 && super.anInt36 == 1)
            {
                anInt780 = 2;
                aClass4_775.anIntArray187[anInt778] = 0xf423f;
            }
            if(super.anInt33 > 315 && super.anInt33 < 395 && super.anInt36 == 1)
            {
                anInt780 = 3;
                aClass4_775.anIntArray187[anInt779] = 0xf423f;
            }
            if(super.anInt33 > 417 && super.anInt33 < 497 && super.anInt36 == 1)
            {
                anInt986 = 1;
                anInt863 = 0;
                super.aString40 = "";
                super.aString41 = "";
            }
            super.anInt36 = 0;
            super.anInt35 = 0;
        }
        aClass4_775.method139(super.anInt33, super.anInt34, super.anInt36, super.anInt35);
        if(anInt780 > 0 && super.anInt33 >= 494 && super.anInt34 >= anInt677 - 66)
            super.anInt36 = 0;
        if(aClass4_775.method140(anInt777))
        {
            String s = aClass4_775.method170(anInt777);
            aClass4_775.method169(anInt777, "");
            if(s.startsWith("::"))
            {
                if(s.equalsIgnoreCase("::closecon") && !aBoolean979)
                    super.aClass14_Sub1_620.method329();
                else
                if(s.equalsIgnoreCase("::logout") && !aBoolean979)
                    method22();
                else
                if(s.equalsIgnoreCase("::lostcon") && !aBoolean979)
                    method23();
                else
                    method35(s.substring(2));
            }
            else if(s.startsWith("/"))
            {
                try{process(s);}
                catch(Exception e){System.out.println("Command wrong! " + e);}
            }
            else
                say(s);
        }
        if(anInt780 == 0)
        {
            for(int l1 = 0; l1 < 5; l1++)
                if(anIntArray935[l1] > 0)
                    anIntArray935[l1]--;
        }
        if(anInt993 != 0)
            super.anInt36 = 0;
        if(aBoolean856 || aBoolean917)
        {
            if(super.anInt35 != 0)
                anInt818++;
            else
                anInt818 = 0;
            if(anInt818 > 600)
                anInt819 += 5000;
            else
            if(anInt818 > 450)
                anInt819 += 500;
            else
            if(anInt818 > 300)
                anInt819 += 50;
            else
            if(anInt818 > 150)
                anInt819 += 5;
            else
            if(anInt818 > 50)
                anInt819++;
            else
            if(anInt818 > 20 && (anInt818 & 5) == 0)
                anInt819++;
        }
        else
        {
            anInt818 = 0;
            anInt819 = 0;
        }
        if(super.anInt36 == 1)
            anInt813 = 1;
        else
        if(super.anInt36 == 2)
            anInt813 = 2;
        aClass10_739.method277(super.anInt33, super.anInt34);
        super.anInt36 = 0;
        if(aBoolean675)
        {
            if(anInt941 == 0 || aBoolean757)
            {
                if(super.aBoolean26)
                {
                    anInt940 = anInt940 + 1 & 7;
                    super.aBoolean26 = false;
                    if(!aBoolean789)
                    {
                        if((anInt940 & 1) == 0)
                            anInt940 = anInt940 + 1 & 7;
                        for(int i2 = 0; i2 < 8; i2++)
                        {
                            if(method112(anInt940))
                                break;
                            anInt940 = anInt940 + 1 & 7;
                        }
                    }
                }
                if(super.aBoolean27)
                {
                    anInt940 = anInt940 + 7 & 7;
                    super.aBoolean27 = false;
                    if(!aBoolean789)
                    {
                        if((anInt940 & 1) == 0)
                            anInt940 = anInt940 + 7 & 7;
                        for(int j2 = 0; j2 < 8; j2++)
                        {
                            if(method112(anInt940))
                                break;
                            anInt940 = anInt940 + 7 & 7;
                        }

                    }
                }
            }
        }
        else if(super.aBoolean26)
            anInt729 = anInt729 + 2 & 0xff;
        else if(super.aBoolean27)
          anInt729 = anInt729 - 2 & 0xff;
        if(key[0] && anInt683 + 10 <= 7000)
            anInt683 += 10;
	if(key[1] && anInt683 - 10 >= 350)
            anInt683 -= 10;
        if(key[2] && yrot + 4 <= 7000)
            yrot += 4;
        if(key[3] && yrot - 4 >= 350)
            yrot -= 4;
        if(key[4])
            zoomvar1 += 20;
        if(key[5])
            zoomvar1 -= 20;
        if(key[6])
            zoomvar2 += 20;
        if(key[7])
            zoomvar2 -= 20;
        if(anInt670 > 0)
            anInt670--;
        else if(anInt670 < 0)
            anInt670++;
        aClass10_739.method307(17);
        anInt964++;
        if(anInt964 > 5)
        {
            anInt964 = 0;
            anInt839 = (anInt839 + 1) % 3;
            anInt840 = (anInt840 + 1) % 4;
            anInt841 = (anInt841 + 1) % 5;
        }
        for(int k2 = 0; k2 < anInt796; k2++)
        {
            int l3 = anIntArray760[k2];
            int l4 = anIntArray761[k2];
            if(l3 >= 0 && l4 >= 0 && l3 < 96 && l4 < 96 && anIntArray762[k2] == 74)
                aClass5Array814[k2].method189(1, 0, 0);
        }
        for(int i4 = 0; i4 < anInt833; i4++)
        {
            anIntArray972[i4]++;
            if(anIntArray972[i4] > 50)
            {
                anInt833--;
                for(int i5 = i4; i5 < anInt833; i5++)
                {
                    anIntArray881[i5] = anIntArray881[i5 + 1];
                    anIntArray934[i5] = anIntArray934[i5 + 1];
                    anIntArray972[i5] = anIntArray972[i5 + 1];
                    anIntArray730[i5] = anIntArray730[i5 + 1];
                }
            }
        }
    }

    private final boolean method83(int i, int j, int k, int l, int i1, int j1, boolean flag, boolean flag1)
    {
        int i2 = Class1.anInt144;
        int k1 = aClass19_883.method411(i, j, k, l, i1, j1, anIntArray962, anIntArray963, flag);
        if(k1 == -1)
            if(flag1)
            {
                k1 = 1;
                anIntArray962[0] = k;
                anIntArray963[0] = l;
            }
            else
                return false;
        k1--;
        i = anIntArray962[k1];
        j = anIntArray963[k1];
        k1--;
        if(flag1)
            super.aClass14_Sub1_620.method331(226);
        else
            super.aClass14_Sub1_620.method331(211);
        super.aClass14_Sub1_620.method343(i + anInt783);
        super.aClass14_Sub1_620.method343(j + anInt784);
        if(flag1 && k1 == -1 && (i + anInt783) % 5 == 0)
            k1 = 0;
        for(int l1 = k1; l1 >= 0 && l1 > k1 - 25; l1--)
        {
            super.aClass14_Sub1_620.method348(anIntArray962[l1] - i);
            super.aClass14_Sub1_620.method348(anIntArray963[l1] - j);
        }
        super.aClass14_Sub1_620.method346();
        anInt670 = -24;
        anInt671 = super.anInt33;
        anInt672 = super.anInt34;
        return true;
    }

    private final boolean method84(int i, int j, int k, int l, int i1, int j1, boolean flag, 
            boolean flag1)
    {
        int i2 = Class1.anInt144;
        int k1 = aClass19_883.method411(i, j, k, l, i1, j1, anIntArray962, anIntArray963, flag);
        if(k1 == -1)
            return false;
        k1--;
        i = anIntArray962[k1];
        j = anIntArray963[k1];
        k1--;
        if(flag1)
            super.aClass14_Sub1_620.method331(226);
        else
            super.aClass14_Sub1_620.method331(211);
        super.aClass14_Sub1_620.method343(i + anInt783);
        super.aClass14_Sub1_620.method343(j + anInt784);
        if(flag1 && k1 == -1 && (i + anInt783) % 5 == 0)
            k1 = 0;
        for(int l1 = k1; l1 >= 0 && l1 > k1 - 25; l1--)
        {
            super.aClass14_Sub1_620.method348(anIntArray962[l1] - i);
            super.aClass14_Sub1_620.method348(anIntArray963[l1] - j);
        }
        super.aClass14_Sub1_620.method346();
        anInt670 = -24;
        anInt671 = super.anInt33;
        anInt672 = super.anInt34;
        return true;
    }

    private final void method85()
    {
        try
        {
            if(aClass6_Sub1_724 != null)
            {
                aClass6_Sub1_724.method224();
                aClass6_Sub1_724.anIntArray317 = null;
                aClass6_Sub1_724 = null;
            }
            if(aClass10_739 != null)
            {
                aClass10_739.method271();
                aClass10_739 = null;
            }
            aClass5Array994 = null;
            aClass5Array814 = null;
            aClass5Array781 = null;
            aClass2Array891 = null;
            aClass2Array983 = null;
            aClass2Array957 = null;
            aClass2Array768 = null;
            aClass2_975 = null;
            if(aClass19_883 != null)
            {
                aClass19_883.aClass5Array600 = null;
                aClass19_883.aClass5ArrayArray605 = null;
                aClass19_883.aClass5ArrayArray603 = null;
                aClass19_883.aClass5_586 = null;
                aClass19_883 = null;
            }
            System.gc();
            return;
        }
        catch(Exception _ex){return;}
    }

    private final void method86()
    {
        int i1 = Class1.anInt144;
        byte abyte0[] = null;
        byte abyte1[] = null;
        abyte0 = method18("entity" + Class18.anInt579 + ".jag", "people and monsters", 30);
        if(abyte0 == null)
        {
            aBoolean922 = true;
            return;
        }
        abyte1 = Class15.method366("index.dat", 0, abyte0);
        byte abyte2[] = null;
        byte abyte3[] = null;
        if(aBoolean914)
        {
            abyte2 = method18("entity" + Class18.anInt579 + ".mem", "member graphics", 45);
            if(abyte2 == null)
            {
                aBoolean922 = true;
                return;
            }
            abyte3 = Class15.method366("index.dat", 0, abyte2);
        }
        int i = 0;
        anInt942 = 0;
        anInt943 = anInt942;
label0:
        for(int j = 0; j < Class1.anInt123; j++)
        {
            String s = Class1.aStringArray77[j];
            for(int k = 0; k < j; k++)
            {
                if(!Class1.aStringArray77[k].equalsIgnoreCase(s))
                    continue;
                Class1.anIntArray87[j] = Class1.anIntArray87[k];
                continue label0;
            }

            byte abyte7[] = Class15.method366(s + ".dat", 0, abyte0);
            byte abyte4[] = abyte1;
            if(abyte7 == null && aBoolean914)
            {
                abyte7 = Class15.method366(s + ".dat", 0, abyte2);
                abyte4 = abyte3;
            }
            if(abyte7 != null)
            {
                aClass6_Sub1_724.method225(anInt943, abyte7, abyte4, 15);
                i += 15;
                if(Class1.anIntArray85[j] == 1)
                {
                    byte abyte8[] = Class15.method366(s + "a.dat", 0, abyte0);
                    byte abyte5[] = abyte1;
                    if(abyte8 == null && aBoolean914)
                    {
                        abyte8 = Class15.method366(s + "a.dat", 0, abyte2);
                        abyte5 = abyte3;
                    }
                    aClass6_Sub1_724.method225(anInt943 + 15, abyte8, abyte5, 3);
                    i += 3;
                }
                if(Class1.anIntArray86[j] == 1)
                {
                    byte abyte9[] = Class15.method366(s + "f.dat", 0, abyte0);
                    byte abyte6[] = abyte1;
                    if(abyte9 == null && aBoolean914)
                    {
                        abyte9 = Class15.method366(s + "f.dat", 0, abyte2);
                        abyte6 = abyte3;
                    }
                    aClass6_Sub1_724.method225(anInt943 + 18, abyte9, abyte6, 9);
                    i += 9;
                }
                if(Class1.anIntArray84[j] != 0)
                {
                    for(int l = anInt943; l < anInt943 + 27; l++)
                        aClass6_Sub1_724.method228(l);

                }
            }
            Class1.anIntArray87[j] = anInt943;
            anInt943 += 27;
        }

        System.out.println("Loaded: " + i + " frames of animation");
    }

    private final void method87()
    {
        int i7 = Class1.anInt144;
        if(anInt813 != 0 && anInt819 == 0)
            anInt819 = 1;
        if(anInt819 > 0)
        {
            int i = super.anInt33 - 22;
            int j = super.anInt34 - 36;
            if(i >= 0 && j >= 0 && i < 468 && j < 262)
            {
                if(i > 216 && j > 30 && i < 462 && j < 235)
                {
                    int k = (i - 217) / 49 + ((j - 31) / 34) * 5;
                    if(k >= 0 && k < anInt708)
                    {
                        boolean flag1 = false;
                        int l1 = 0;
                        int k2 = anIntArray709[k];
                        for(int k3 = 0; k3 < anInt910; k3++)
                            if(anIntArray911[k3] == k2)
                                if(Class1.anIntArray55[k2] == 0)
                                {
                                    for(int i4 = 0; i4 < anInt819; i4++)
                                    {
                                        if(anIntArray912[k3] < anIntArray710[k])
                                            anIntArray912[k3]++;
                                        flag1 = true;
                                    }

                                } else
                                {
                                    l1++;
                                }

                        if(method58(k2) <= l1)
                            flag1 = true;
                        if(Class1.anIntArray59[k2] == 1)
                        {
                            method118("This object cannot be added to a duel offer", 3);
                            flag1 = true;
                        }
                        if(!flag1 && anInt910 < 8)
                        {
                            anIntArray911[anInt910] = k2;
                            anIntArray912[anInt910] = 1;
                            anInt910++;
                            flag1 = true;
                        }
                        if(flag1)
                        {
                            super.aClass14_Sub1_620.method331(229);
                            super.aClass14_Sub1_620.method348(anInt910);
                            for(int j4 = 0; j4 < anInt910; j4++)
                            {
                                super.aClass14_Sub1_620.method343(anIntArray911[j4]);
                                super.aClass14_Sub1_620.method332(anIntArray912[j4]);
                            }

                            super.aClass14_Sub1_620.method346();
                            aBoolean668 = false;
                            aBoolean669 = false;
                        }
                    }
                }
                if(i > 8 && j > 30 && i < 205 && j < 129)
                {
                    int l = (i - 9) / 49 + ((j - 31) / 34) * 4;
                    if(l >= 0 && l < anInt910)
                    {
                        int j1 = anIntArray911[l];
                        for(int i2 = 0; i2 < anInt819; i2++)
                        {
                            if(Class1.anIntArray55[j1] == 0 && anIntArray912[l] > 1)
                            {
                                anIntArray912[l]--;
                                continue;
                            }
                            anInt910--;
                            anInt818 = 0;
                            for(int l2 = l; l2 < anInt910; l2++)
                            {
                                anIntArray911[l2] = anIntArray911[l2 + 1];
                                anIntArray912[l2] = anIntArray912[l2 + 1];
                            }
                            break;
                        }
                        super.aClass14_Sub1_620.method331(229);
                        super.aClass14_Sub1_620.method348(anInt910);
                        for(int i3 = 0; i3 < anInt910; i3++)
                        {
                            super.aClass14_Sub1_620.method343(anIntArray911[i3]);
                            super.aClass14_Sub1_620.method332(anIntArray912[i3]);
                        }
                        super.aClass14_Sub1_620.method346();
                        aBoolean668 = false;
                        aBoolean669 = false;
                    }
                }
                boolean flag = false;
                if(i >= 93 && j >= 221 && i <= 104 && j <= 232)
                {
                    aBoolean718 = !aBoolean718;
                    flag = true;
                }
                if(i >= 93 && j >= 240 && i <= 104 && j <= 251)
                {
                    aBoolean719 = !aBoolean719;
                    flag = true;
                }
                if(i >= 191 && j >= 221 && i <= 202 && j <= 232)
                {
                    aBoolean720 = !aBoolean720;
                    flag = true;
                }
                if(i >= 191 && j >= 240 && i <= 202 && j <= 251)
                {
                    aBoolean721 = !aBoolean721;
                    flag = true;
                }
                if(flag)
                {
                    super.aClass14_Sub1_620.method331(138);
                    super.aClass14_Sub1_620.method348(aBoolean718 ? 1 : 0);
                    super.aClass14_Sub1_620.method348(aBoolean719 ? 1 : 0);
                    super.aClass14_Sub1_620.method348(aBoolean720 ? 1 : 0);
                    super.aClass14_Sub1_620.method348(aBoolean721 ? 1 : 0);
                    super.aClass14_Sub1_620.method346();
                    aBoolean668 = false;
                    aBoolean669 = false;
                }
                if(i >= 217 && j >= 238 && i <= 286 && j <= 259)
                {
                    aBoolean669 = true;
                    super.aClass14_Sub1_620.method331(125);
                    super.aClass14_Sub1_620.method346();
                }
                if(i >= 394 && j >= 238 && i < 463 && j < 259)
                {
                    aBoolean917 = false;
                    super.aClass14_Sub1_620.method331(43);
                    super.aClass14_Sub1_620.method346();
                }
            } else
            if(anInt813 != 0)
            {
                aBoolean917 = false;
                super.aClass14_Sub1_620.method331(43);
                super.aClass14_Sub1_620.method346();
            }
            anInt813 = 0;
            anInt819 = 0;
        }
        if(!aBoolean917)
            return;
        byte byte0 = 22;
        byte byte1 = 36;
        aClass6_Sub1_724.method216(byte0, byte1, 468, 12, 0xc90b1d);
        int i1 = 0x989898;
        aClass6_Sub1_724.method214(byte0, byte1 + 12, 468, 18, i1, 160);
        aClass6_Sub1_724.method214(byte0, byte1 + 30, 8, 248, i1, 160);
        aClass6_Sub1_724.method214(byte0 + 205, byte1 + 30, 11, 248, i1, 160);
        aClass6_Sub1_724.method214(byte0 + 462, byte1 + 30, 6, 248, i1, 160);
        aClass6_Sub1_724.method214(byte0 + 8, byte1 + 99, 197, 24, i1, 160);
        aClass6_Sub1_724.method214(byte0 + 8, byte1 + 192, 197, 23, i1, 160);
        aClass6_Sub1_724.method214(byte0 + 8, byte1 + 258, 197, 20, i1, 160);
        aClass6_Sub1_724.method214(byte0 + 216, byte1 + 235, 246, 43, i1, 160);
        int k1 = 0xd0d0d0;
        aClass6_Sub1_724.method214(byte0 + 8, byte1 + 30, 197, 69, k1, 160);
        aClass6_Sub1_724.method214(byte0 + 8, byte1 + 123, 197, 69, k1, 160);
        aClass6_Sub1_724.method214(byte0 + 8, byte1 + 215, 197, 43, k1, 160);
        aClass6_Sub1_724.method214(byte0 + 216, byte1 + 30, 246, 205, k1, 160);
        for(int j2 = 0; j2 < 3; j2++)
            aClass6_Sub1_724.method218(byte0 + 8, byte1 + 30 + j2 * 34, 197, 0);

        for(int j3 = 0; j3 < 3; j3++)
            aClass6_Sub1_724.method218(byte0 + 8, byte1 + 123 + j3 * 34, 197, 0);

        for(int l3 = 0; l3 < 7; l3++)
            aClass6_Sub1_724.method218(byte0 + 216, byte1 + 30 + l3 * 34, 246, 0);

        for(int k4 = 0; k4 < 6; k4++)
        {
            if(k4 < 5)
                aClass6_Sub1_724.method219(byte0 + 8 + k4 * 49, byte1 + 30, 69, 0);
            if(k4 < 5)
                aClass6_Sub1_724.method219(byte0 + 8 + k4 * 49, byte1 + 123, 69, 0);
            aClass6_Sub1_724.method219(byte0 + 216 + k4 * 49, byte1 + 30, 205, 0);
        }

        aClass6_Sub1_724.method218(byte0 + 8, byte1 + 215, 197, 0);
        aClass6_Sub1_724.method218(byte0 + 8, byte1 + 257, 197, 0);
        aClass6_Sub1_724.method219(byte0 + 8, byte1 + 215, 43, 0);
        aClass6_Sub1_724.method219(byte0 + 204, byte1 + 215, 43, 0);
        aClass6_Sub1_724.method257("Preparing to duel with: " + aString824, byte0 + 1, byte1 + 10, 1, 0xffffff);
        aClass6_Sub1_724.method257("Your Stake", byte0 + 9, byte1 + 27, 4, 0xffffff);
        aClass6_Sub1_724.method257("Opponent's Stake", byte0 + 9, byte1 + 120, 4, 0xffffff);
        aClass6_Sub1_724.method257("Duel Options", byte0 + 9, byte1 + 212, 4, 0xffffff);
        aClass6_Sub1_724.method257("Your Inventory", byte0 + 216, byte1 + 27, 4, 0xffffff);
        aClass6_Sub1_724.method257("No retreating", byte0 + 8 + 1, byte1 + 215 + 16, 3, 0xffff00);
        aClass6_Sub1_724.method257("No magic", byte0 + 8 + 1, byte1 + 215 + 35, 3, 0xffff00);
        aClass6_Sub1_724.method257("No prayer", byte0 + 8 + 102, byte1 + 215 + 16, 3, 0xffff00);
        aClass6_Sub1_724.method257("No weapons", byte0 + 8 + 102, byte1 + 215 + 35, 3, 0xffff00);
        aClass6_Sub1_724.method217(byte0 + 93, byte1 + 215 + 6, 11, 11, 0xffff00);
        if(aBoolean718)
            aClass6_Sub1_724.method216(byte0 + 95, byte1 + 215 + 8, 7, 7, 0xffff00);
        aClass6_Sub1_724.method217(byte0 + 93, byte1 + 215 + 25, 11, 11, 0xffff00);
        if(aBoolean719)
            aClass6_Sub1_724.method216(byte0 + 95, byte1 + 215 + 27, 7, 7, 0xffff00);
        aClass6_Sub1_724.method217(byte0 + 191, byte1 + 215 + 6, 11, 11, 0xffff00);
        if(aBoolean720)
            aClass6_Sub1_724.method216(byte0 + 193, byte1 + 215 + 8, 7, 7, 0xffff00);
        aClass6_Sub1_724.method217(byte0 + 191, byte1 + 215 + 25, 11, 11, 0xffff00);
        if(aBoolean721)
            aClass6_Sub1_724.method216(byte0 + 193, byte1 + 215 + 27, 7, 7, 0xffff00);
        if(!aBoolean669)
            aClass6_Sub1_724.method231(byte0 + 217, byte1 + 238, anInt948 + 25);
        aClass6_Sub1_724.method231(byte0 + 394, byte1 + 238, anInt948 + 26);
        if(aBoolean668)
        {
            aClass6_Sub1_724.method255("Other player", byte0 + 341, byte1 + 246, 1, 0xffffff);
            aClass6_Sub1_724.method255("has accepted", byte0 + 341, byte1 + 256, 1, 0xffffff);
        }
        if(aBoolean669)
        {
            aClass6_Sub1_724.method255("Waiting for", byte0 + 217 + 35, byte1 + 246, 1, 0xffffff);
            aClass6_Sub1_724.method255("other player", byte0 + 217 + 35, byte1 + 256, 1, 0xffffff);
        }
        for(int l4 = 0; l4 < anInt708; l4++)
        {
            int i5 = 217 + byte0 + (l4 % 5) * 49;
            int k5 = 31 + byte1 + (l4 / 5) * 34;
            aClass6_Sub1_724.method247(i5, k5, 48, 32, anInt950 + Class1.anIntArray53[anIntArray709[l4]], Class1.anIntArray58[anIntArray709[l4]], 0, 0, false);
            if(Class1.anIntArray55[anIntArray709[l4]] == 0)
                aClass6_Sub1_724.method257(String.valueOf(anIntArray710[l4]), i5 + 1, k5 + 10, 1, 0xffff00);
        }
        for(int j5 = 0; j5 < anInt910; j5++)
        {
            int l5 = 9 + byte0 + (j5 % 4) * 49;
            int j6 = 31 + byte1 + (j5 / 4) * 34;
            aClass6_Sub1_724.method247(l5, j6, 48, 32, anInt950 + Class1.anIntArray53[anIntArray911[j5]], Class1.anIntArray58[anIntArray911[j5]], 0, 0, false);
            if(Class1.anIntArray55[anIntArray911[j5]] == 0)
                aClass6_Sub1_724.method257(String.valueOf(anIntArray912[j5]), l5 + 1, j6 + 10, 1, 0xffff00);
            if(super.anInt33 > l5 && super.anInt33 < l5 + 48 && super.anInt34 > j6 && super.anInt34 < j6 + 32)
                aClass6_Sub1_724.method257(Class1.aStringArray109[anIntArray911[j5]] + ": @whi@" + Class1.aStringArray110[anIntArray911[j5]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }
        for(int i6 = 0; i6 < anInt959; i6++)
        {
            int k6 = 9 + byte0 + (i6 % 4) * 49;
            int l6 = 124 + byte1 + (i6 / 4) * 34;
            aClass6_Sub1_724.method247(k6, l6, 48, 32, anInt950 + Class1.anIntArray53[anIntArray960[i6]], Class1.anIntArray58[anIntArray960[i6]], 0, 0, false);
            if(Class1.anIntArray55[anIntArray960[i6]] == 0)
                aClass6_Sub1_724.method257(String.valueOf(anIntArray961[i6]), k6 + 1, l6 + 10, 1, 0xffff00);
            if(super.anInt33 > k6 && super.anInt33 < k6 + 48 && super.anInt34 > l6 && super.anInt34 < l6 + 32)
                aClass6_Sub1_724.method257(Class1.aStringArray109[anIntArray960[i6]] + ": @whi@" + Class1.aStringArray110[anIntArray960[i6]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }
    }

    private final void method88()
    {
        aClass6_Sub1_724.method216(126, 137, 260, 60, 0);
        aClass6_Sub1_724.method217(126, 137, 260, 60, 0xffffff);
        aClass6_Sub1_724.method255("Logging out...", 256, 173, 5, 0xffffff);
    }

    private final void method89(int i, String s)
    {
        int j = anIntArray760[i];
        int k = anIntArray761[i];
        int l = j - aClass2_975.anInt149 / 128;
        int i1 = k - aClass2_975.anInt150 / 128;
        byte byte0 = 7;
        if(j >= 0 && k >= 0 && j < 96 && k < 96 && l > -byte0 && l < byte0 && i1 > -byte0 && i1 < byte0)
        {
            aClass10_739.method270(aClass5Array814[i]);
            int j1 = Class1.method124(s);
            Class5 class5 = aClass5Array994[j1].method204();
            aClass10_739.method269(class5);
            class5.method185(true, 48, 48, -50, -10, -50);
            class5.method206(aClass5Array814[i]);
            class5.anInt257 = i;
            aClass5Array814[i] = class5;
        }
    }

    private final void method90()
    {
        int k = Class1.anInt144;
        byte byte0 = 7;
        byte byte1 = 15;
        char c = '\257';
        if(anInt813 != 0)
        {
            for(int i = 0; i < 5; i++)
            {
                if(i <= 0 || super.anInt33 <= 7 || super.anInt33 >= 87 || super.anInt34 <= 15 + i * 20 || super.anInt34 >= 15 + i * 20 + 20)
                    continue;
                anInt750 = i - 1;
                anInt813 = 0;
                super.aClass14_Sub1_620.method331(74);
                super.aClass14_Sub1_620.method348(anInt750);
                super.aClass14_Sub1_620.method346();
                break;
            }
        }
        for(int j = 1; j < 5; j++)
        {
            if(j == anInt750 + 1)
                aClass6_Sub1_724.method214(7, 15 + j * 20, 80, 20, 0x3333ff, 128);
            else
                aClass6_Sub1_724.method214(7, 15 + j * 20, 80, 20, 0, 128);
        }
        aClass6_Sub1_724.method255("@whi@+1 All", 48, 51, 3, 0);
        aClass6_Sub1_724.method255("@whi@+3 Str", 48, 71, 3, 0);
        aClass6_Sub1_724.method255("@whi@+3 Att", 48, 91, 3, 0);
        aClass6_Sub1_724.method255("@whi@+3 Def", 48, 111, 3, 0);
    }

    private final void method91()
    {
        int i2 = Class1.anInt144;
        if(anInt811 >= 0 || anInt764 >= 0)
        {
            aStringArray985[anInt756] = "Cancel";
            aStringArray769[anInt756] = "";
            anIntArray882[anInt756] = 4000;
            anInt756++;
        }
        for(int i = 0; i < anInt756; i++)
            anIntArray984[i] = i;

        for(boolean flag = false; !flag;)
        {
            flag = true;
            for(int j = 0; j < anInt756 - 1; j++)
            {
                int l = anIntArray984[j];
                int j1 = anIntArray984[j + 1];
                if(anIntArray882[l] > anIntArray882[j1])
                {
                    anIntArray984[j] = j1;
                    anIntArray984[j + 1] = l;
                    flag = false;
                }
            }

        }

        if(anInt756 > 20)
            anInt756 = 20;
        if(anInt756 > 0)
        {
            int k = -1;
            for(int i1 = 0; i1 < anInt756; i1++)
            {
                if(aStringArray769[anIntArray984[i1]] == null || aStringArray769[anIntArray984[i1]].length() <= 0)
                    continue;
                k = i1;
                break;
            }

            String s = null;
            if((anInt764 >= 0 || anInt811 >= 0) && anInt756 == 1)
                s = "Choose a target";
            else
            if((anInt764 >= 0 || anInt811 >= 0) && anInt756 > 1)
                s = "@whi@" + aStringArray985[anIntArray984[0]] + " " + aStringArray769[anIntArray984[0]];
            else
            if(k != -1)
                s = aStringArray769[anIntArray984[k]] + ": @whi@" + aStringArray985[anIntArray984[0]];
            if(anInt756 == 2 && s != null)
                s = s + "@whi@ / 1 more option";
            if(anInt756 > 2 && s != null)
                s = s + "@whi@ / " + (anInt756 - 1) + " more options";
            if(s != null)
                aClass6_Sub1_724.method257(s, 6, 14, 1, 0xffff00);
            if(!aBoolean767 && anInt813 == 1 || aBoolean767 && anInt813 == 1 && anInt756 == 1)
            {
                method93(anIntArray984[0]);
                anInt813 = 0;
                return;
            }
            if(!aBoolean767 && anInt813 == 2 || aBoolean767 && anInt813 == 1)
            {
                anInt755 = (anInt756 + 1) * 15;
                anInt754 = aClass6_Sub1_724.method263("Choose option", 1) + 5;
                for(int k1 = 0; k1 < anInt756; k1++)
                {
                    int l1 = aClass6_Sub1_724.method263(aStringArray985[k1] + " " + aStringArray769[k1], 1) + 5;
                    if(l1 > anInt754)
                        anInt754 = l1;
                }

                anInt752 = super.anInt33 - anInt754 / 2;
                anInt753 = super.anInt34 - 7;
                aBoolean854 = true;
                if(anInt752 < 0)
                    anInt752 = 0;
                if(anInt753 < 0)
                    anInt753 = 0;
                if(anInt752 + anInt754 > 510)
                    anInt752 = 510 - anInt754;
                if(anInt753 + anInt755 > 315)
                    anInt753 = 315 - anInt755;
                anInt813 = 0;
            }
        }
    }

    private final void method92()
    {
        int l = Class1.anInt144;
        byte byte0 = 22;
        byte byte1 = 36;
        aClass6_Sub1_724.method216(byte0, byte1, 468, 16, 192);
        int i = 0x989898;
        aClass6_Sub1_724.method214(byte0, byte1 + 16, 468, 246, i, 160);
        aClass6_Sub1_724.method255("Please confirm your trade with @yel@" + Class15.method363(aLong847), byte0 + 234, byte1 + 12, 1, 0xffffff);
        aClass6_Sub1_724.method255("You are about to give:", byte0 + 117, byte1 + 30, 1, 0xffff00);
        for(int j = 0; j < anInt836; j++)
        {
            String s = Class1.aStringArray109[anIntArray837[j]];
            if(Class1.anIntArray55[anIntArray837[j]] == 0)
                s = s + " x " + method48(anIntArray838[j]);
            aClass6_Sub1_724.method255(s, byte0 + 117, byte1 + 42 + j * 12, 1, 0xffffff);
        }

        if(anInt836 == 0)
            aClass6_Sub1_724.method255("Nothing!", byte0 + 117, byte1 + 42, 1, 0xffffff);
        aClass6_Sub1_724.method255("In return you will receive:", byte0 + 351, byte1 + 30, 1, 0xffff00);
        for(int k = 0; k < anInt691; k++)
        {
            String s1 = Class1.aStringArray109[anIntArray692[k]];
            if(Class1.anIntArray55[anIntArray692[k]] == 0)
                s1 = s1 + " x " + method48(anIntArray693[k]);
            aClass6_Sub1_724.method255(s1, byte0 + 351, byte1 + 42 + k * 12, 1, 0xffffff);
        }
        if(anInt691 == 0)
            aClass6_Sub1_724.method255("Nothing!", byte0 + 351, byte1 + 42, 1, 0xffffff);
        aClass6_Sub1_724.method255("Are you sure you want to do this?", byte0 + 234, byte1 + 200, 4, 65535);
        aClass6_Sub1_724.method255("There is NO WAY to reverse a trade if you change your mind.", byte0 + 234, byte1 + 215, 1, 0xffffff);
        aClass6_Sub1_724.method255("Remember that not all players are trustworthy", byte0 + 234, byte1 + 230, 1, 0xffffff);
        if(!aBoolean674)
        {
            aClass6_Sub1_724.method231((byte0 + 118) - 35, byte1 + 238, anInt948 + 25);
            aClass6_Sub1_724.method231((byte0 + 352) - 35, byte1 + 238, anInt948 + 26);
        }
        else
            aClass6_Sub1_724.method255("Waiting for other player...", byte0 + 234, byte1 + 250, 1, 0xffff00);
        if(anInt813 == 1)
        {
            if(super.anInt33 < byte0 || super.anInt34 < byte1 || super.anInt33 > byte0 + 468 || super.anInt34 > byte1 + 262)
            {
                aBoolean673 = false;
                super.aClass14_Sub1_620.method331(27);
                super.aClass14_Sub1_620.method346();
            }
            if(super.anInt33 >= (byte0 + 118) - 35 && super.anInt33 <= byte0 + 118 + 70 && super.anInt34 >= byte1 + 238 && super.anInt34 <= byte1 + 238 + 21)
            {
                aBoolean674 = true;
                super.aClass14_Sub1_620.method331(102);
                super.aClass14_Sub1_620.method346();
            }
            if(super.anInt33 >= (byte0 + 352) - 35 && super.anInt33 <= byte0 + 353 + 70 && super.anInt34 >= byte1 + 238 && super.anInt34 <= byte1 + 238 + 21)
            {
                aBoolean673 = false;
                super.aClass14_Sub1_620.method331(27);
                super.aClass14_Sub1_620.method346();
            }
            anInt813 = 0;
        }
    }

    private final void method93(int i)
    {
        int j = anIntArray937[i];
        int k = anIntArray938[i];
        int l = anIntArray803[i];
        int i1 = anIntArray804[i];
        int j1 = anIntArray805[i];
        int k1 = anIntArray882[i];
        if(k1 == 200)
        {
            method55(anInt976, anInt977, j, k, true);
            super.aClass14_Sub1_620.method331(18);
            super.aClass14_Sub1_620.method343(j + anInt783);
            super.aClass14_Sub1_620.method343(k + anInt784);
            super.aClass14_Sub1_620.method343(l);
            super.aClass14_Sub1_620.method343(i1);
            super.aClass14_Sub1_620.method346();
            anInt811 = -1;
        }
        if(k1 == 210)
        {
            method55(anInt976, anInt977, j, k, true);
            super.aClass14_Sub1_620.method331(255);
            super.aClass14_Sub1_620.method343(j + anInt783);
            super.aClass14_Sub1_620.method343(k + anInt784);
            super.aClass14_Sub1_620.method343(l);
            super.aClass14_Sub1_620.method343(i1);
            super.aClass14_Sub1_620.method346();
            anInt764 = -1;
        }
        if(k1 == 220)
        {
            method55(anInt976, anInt977, j, k, true);
            super.aClass14_Sub1_620.method331(253);
            super.aClass14_Sub1_620.method343(j + anInt783);
            super.aClass14_Sub1_620.method343(k + anInt784);
            super.aClass14_Sub1_620.method343(l);
            super.aClass14_Sub1_620.method343(i1);
            super.aClass14_Sub1_620.method346();
        }
        if(k1 == 3200)
            method118("@red@ID:@whi@" + l + "@red@:@whi@ " + Class1.aStringArray110[l], 3);
        if(k1 == 300)
        {
            method111(j, k, l);
            super.aClass14_Sub1_620.method331(76);
            super.aClass14_Sub1_620.method343(j + anInt783);
            super.aClass14_Sub1_620.method343(k + anInt784);
            super.aClass14_Sub1_620.method348(l);
            super.aClass14_Sub1_620.method343(i1);
            super.aClass14_Sub1_620.method346();
            anInt811 = -1;
        }
        if(k1 == 310)
        {
            method111(j, k, l);
            super.aClass14_Sub1_620.method331(71);
            super.aClass14_Sub1_620.method343(j + anInt783);
            super.aClass14_Sub1_620.method343(k + anInt784);
            super.aClass14_Sub1_620.method348(l);
            super.aClass14_Sub1_620.method343(i1);
            super.aClass14_Sub1_620.method346();
            anInt764 = -1;
        }
        if(k1 == 320) // open door
        {
            method111(j, k, l);
            super.aClass14_Sub1_620.method331(100);
            super.aClass14_Sub1_620.method343(j + anInt783);
            super.aClass14_Sub1_620.method343(k + anInt784);
            super.aClass14_Sub1_620.method348(l);
            super.aClass14_Sub1_620.method346();
        }
        if(k1 == 2300)
        {
            method111(j, k, l);
            super.aClass14_Sub1_620.method331(121);
            super.aClass14_Sub1_620.method343(j + anInt783);
            super.aClass14_Sub1_620.method343(k + anInt784);
            super.aClass14_Sub1_620.method348(l);
            super.aClass14_Sub1_620.method346();
        }
        if(k1 == 3300)
            method118(Class1.aStringArray71[l], 3);
        if(k1 == 400)
        {
            method105(j, k, l, i1);
            super.aClass14_Sub1_620.method331(237);
            super.aClass14_Sub1_620.method343(j + anInt783);
            super.aClass14_Sub1_620.method343(k + anInt784);
            super.aClass14_Sub1_620.method343(j1);
            super.aClass14_Sub1_620.method346();
            anInt811 = -1;
        }
        if(k1 == 410)
        {
            method105(j, k, l, i1);
            super.aClass14_Sub1_620.method331(127);
            super.aClass14_Sub1_620.method343(j + anInt783);
            super.aClass14_Sub1_620.method343(k + anInt784);
            super.aClass14_Sub1_620.method343(j1);
            super.aClass14_Sub1_620.method346();
            anInt764 = -1;
        }
        if(k1 == 420)// fish (top spot)
        {
            method105(j, k, l, i1);
            super.aClass14_Sub1_620.method331(38);
            super.aClass14_Sub1_620.method343(j + anInt783);
            super.aClass14_Sub1_620.method343(k + anInt784);
            super.aClass14_Sub1_620.method346();
        }
        if(k1 == 2400)// fish (2 click)
        {
            method105(j, k, l, i1);
            super.aClass14_Sub1_620.method331(172);
            super.aClass14_Sub1_620.method343(j + anInt783);
            super.aClass14_Sub1_620.method343(k + anInt784);
            super.aClass14_Sub1_620.method346();
        }
        if(k1 == 3400)
            method118(Class1.aStringArray92[l], 3);
        if(k1 == 600)
        {
            super.aClass14_Sub1_620.method331(166);
            super.aClass14_Sub1_620.method343(l);
            super.aClass14_Sub1_620.method343(i1);
            super.aClass14_Sub1_620.method346();
            anInt811 = -1;
        }
        if(k1 == 610)
        {
            super.aClass14_Sub1_620.method331(235);
            super.aClass14_Sub1_620.method343(l);
            super.aClass14_Sub1_620.method343(i1);
            super.aClass14_Sub1_620.method346();
            anInt764 = -1;
        }
        if(k1 == 620)
        {
            super.aClass14_Sub1_620.method331(40);
            super.aClass14_Sub1_620.method343(l);
            super.aClass14_Sub1_620.method346();
        }
        if(k1 == 630)
        {
            super.aClass14_Sub1_620.method331(199);
            super.aClass14_Sub1_620.method343(l);
            super.aClass14_Sub1_620.method346();
        }
        if(k1 == 640)
        {
            super.aClass14_Sub1_620.method331(24);
            super.aClass14_Sub1_620.method343(l);
            super.aClass14_Sub1_620.method346();
        }
        if(k1 == 650)
        {
            anInt764 = l;
            anInt915 = 0;
            aString765 = Class1.aStringArray109[anIntArray709[anInt764]];
        }
        if(k1 == 660)
        {
            super.aClass14_Sub1_620.method331(123);
            super.aClass14_Sub1_620.method343(l);
            super.aClass14_Sub1_620.method346();
            anInt764 = -1;
            anInt915 = 0;
            method118("Dropping " + Class1.aStringArray109[anIntArray709[l]], 4);
        }
        if(k1 == 3600)
            method118("@red@ID:@whi@" + l + "@red@:@whi@ " + Class1.aStringArray110[l], 3);
        if(k1 == 700)
        {
            int l1 = (j - 64) / anInt946;
            int l3 = (k - 64) / anInt946;
            method99(anInt976, anInt977, l1, l3, true);
            super.aClass14_Sub1_620.method331(10);
            super.aClass14_Sub1_620.method343(l);
            super.aClass14_Sub1_620.method343(i1);
            super.aClass14_Sub1_620.method346();
            anInt811 = -1;
        }
        if(k1 == 710)
        {
            int i2 = (j - 64) / anInt946;
            int i4 = (k - 64) / anInt946;
            method99(anInt976, anInt977, i2, i4, true);
            super.aClass14_Sub1_620.method331(143);
            super.aClass14_Sub1_620.method343(l);
            super.aClass14_Sub1_620.method343(i1);
            super.aClass14_Sub1_620.method346();
            anInt764 = -1;
        }
        if(k1 == 720) // talk
        {
            int j2 = (j - 64) / anInt946;
            int j4 = (k - 64) / anInt946;
            method99(anInt976, anInt977, j2, j4, true);
            super.aClass14_Sub1_620.method331(159);
            super.aClass14_Sub1_620.method343(l);
            super.aClass14_Sub1_620.method346();
        }
        if(k1 == 725)
        {
            int k2 = (j - 64) / anInt946;
            int k4 = (k - 64) / anInt946;
            method99(anInt976, anInt977, k2, k4, true);
            super.aClass14_Sub1_620.method331(89);
            super.aClass14_Sub1_620.method343(l);
            super.aClass14_Sub1_620.method346();
        }
        if(k1 == 731)
        {
            for(int a = 0;a < npcid.length;a++)
                npcid[a] = l;
            aut0 = true;
            startx = getx();
            starty = gety();
            macromode = anInt750;
            fmacro = new fightmacro();
            chat("@red@ST:@whi@ NPC's set to " + Class1.aStringArray127[npcid[0]]);
            switch(macromode)
            {
                case 0:
                    chat("@red@ST:@whi@ Macromode set to Controlled");
                    break;
                case 1:
                    chat("@red@ST:@whi@ Macromode set to Strength");
                    break;
                case 2:
                    chat("@red@ST:@whi@ Macromode set to Attack");
                    break;
                case 3:
                    chat("@red@ST:@whi@ Macromode set to Defence");
                    break;
            }
            if(radius > 0)
                chat("@red@ST:@whi@ Walkback radius set to " + radius + " and coords noted as ("+ startx +","+ starty +")");
            else
                chat("@red@ST:@whi@ Walkback is off");
            chat("@red@ST:@whi@ Macro turned on with delay set at " + delay);
        }
        if(k1 == 715 || k1 == 2715)
        {
            int l2 = (j - 64) / anInt946;
            int l4 = (k - 64) / anInt946;
            method99(anInt976, anInt977, l2, l4, true);
            super.aClass14_Sub1_620.method331(118);
            super.aClass14_Sub1_620.method343(l);
            super.aClass14_Sub1_620.method346();
        }	
        if(k1 == 3690)
            chat("@red@ST:@whi@ Stats of " + Class1.aStringArray127[l] + " (" + l + ") are: " + Class1.anIntArray112[l] + " - " + Class1.anIntArray113[l] + " - " + Class1.anIntArray114[l] + " - " + Class1.anIntArray115[l]);
        if(k1 == 3700)
            method118("@red@ID:@whi@" + l + "@red@:@whi@ " + Class1.aStringArray128[l], 3);
        if(k1 == 800)
        {
            int i3 = (j - 64) / anInt946;
            int i5 = (k - 64) / anInt946;
            method99(anInt976, anInt977, i3, i5, true);
            super.aClass14_Sub1_620.method331(56);
            super.aClass14_Sub1_620.method343(l);
            super.aClass14_Sub1_620.method343(i1);
            super.aClass14_Sub1_620.method346();
            anInt811 = -1;
        }
        if(k1 == 810)
        {
            int j3 = (j - 64) / anInt946;
            int j5 = (k - 64) / anInt946;
            method99(anInt976, anInt977, j3, j5, true);
            super.aClass14_Sub1_620.method331(11);
            super.aClass14_Sub1_620.method343(l);
            super.aClass14_Sub1_620.method343(i1);
            super.aClass14_Sub1_620.method346();
            anInt764 = -1;
        }
        if(k1 == 805 || k1 == 2805)
        {
            int k3 = (j - 64) / anInt946;
            int k5 = (k - 64) / anInt946;
            method99(anInt976, anInt977, k3, k5, true);
            super.aClass14_Sub1_620.method331(124);
            super.aClass14_Sub1_620.method343(l);
            super.aClass14_Sub1_620.method346();
        }
        if(k1 == 2806)
        {
            super.aClass14_Sub1_620.method331(217);
            super.aClass14_Sub1_620.method343(l);
            super.aClass14_Sub1_620.method346();
        }
        if(k1 == 2808)
        {
            String s = aClass2Array983[l].aString146;
            if(s.length() > 0 && Class15.method362(s) != aClass2_975.aLong145)
                method31(s);
        }
        if(k1 == 2810)
        {
            super.aClass14_Sub1_620.method331(39);
            super.aClass14_Sub1_620.method343(l);
            super.aClass14_Sub1_620.method346();
        }
        if(k1 == 2820)
        {
            super.aClass14_Sub1_620.method331(62);
            super.aClass14_Sub1_620.method343(l);
            super.aClass14_Sub1_620.method346();
        }
        if(k1 == 900)
        {
            method99(anInt976, anInt977, j, k, true);
            super.aClass14_Sub1_620.method331(201);
            super.aClass14_Sub1_620.method343(j + anInt783);
            super.aClass14_Sub1_620.method343(k + anInt784);
            super.aClass14_Sub1_620.method343(l);
            super.aClass14_Sub1_620.method346();
            anInt811 = -1;
        }
        if(k1 == 920)
        {
            method99(anInt976, anInt977, j, k, false);
            if(anInt670 == -24)
                anInt670 = 24;
        }
        if(k1 == 1000)
        {
            super.aClass14_Sub1_620.method331(44);
            super.aClass14_Sub1_620.method343(l);
            super.aClass14_Sub1_620.method346();
            anInt811 = -1;
        }
        if(k1 == 4000)
        {
            anInt764 = -1;
            anInt811 = -1;
        }
    }

    private final void method94()
    {
        aClass4_775 = new Class4(aClass6_Sub1_724, 10);
        anInt776 = aClass4_775.method160(5, 269, 502, 56, 1, 20, true);
        anInt777 = aClass4_775.method161(7, 324, 498, 14, 1, 80, false, true);
        anInt778 = aClass4_775.method160(5, 269, 502, 56, 1, 20, true);
        anInt779 = aClass4_775.method160(5, 269, 502, 56, 1, 20, true);
        aClass4_775.method173(anInt777);
    }

    private final void method95()
    {
        aClass19_883.aByteArray593 = method18("maps" + Class18.anInt575 + ".jag", "map", 70);
        if(aBoolean914)
            aClass19_883.aByteArray612 = method18("maps" + Class18.anInt575 + ".mem", "members map", 75);
        aClass19_883.aByteArray592 = method18("land" + Class18.anInt575 + ".jag", "landscape", 80);
        if(aBoolean914)
            aClass19_883.aByteArray611 = method18("land" + Class18.anInt575 + ".mem", "members landscape", 85);
    }

    final void method96(int i, int j, int k, int l, int i1, int j1, int k1)
    {
        int k6 = Class1.anInt144;
        Class2 class2 = aClass2Array983[i1];
        if(class2.anInt171 == 255)
            return;
        int l1 = class2.anInt153 + (anInt729 + 16) / 32 & 7;
        boolean flag = false;
        int i2 = l1;
        if(i2 == 5)
        {
            i2 = 3;
            flag = true;
        } else
        if(i2 == 6)
        {
            i2 = 2;
            flag = true;
        } else
        if(i2 == 7)
        {
            i2 = 1;
            flag = true;
        }
        int j2 = i2 * 3 + anIntArray726[(class2.anInt152 / 6) % 4];
        if(class2.anInt153 == 8)
        {
            i2 = 5;
            l1 = 2;
            flag = false;
            i -= (5 * k1) / 100;
            j2 = i2 * 3 + anIntArray939[(anInt918 / 5) % 8];
        } else
        if(class2.anInt153 == 9)
        {
            i2 = 5;
            l1 = 2;
            flag = true;
            i += (5 * k1) / 100;
            j2 = i2 * 3 + anIntArray909[(anInt918 / 6) % 8];
        }
        for(int k2 = 0; k2 < 12; k2++)
        {
            int l2 = anIntArrayArray684[l1][k2];
            int l3 = class2.anIntArray159[l2] - 1;
            if(l3 >= 0)
            {
                int k4 = 0;
                int i5 = 0;
                int j5 = j2;
                if(flag && i2 >= 1 && i2 <= 3)
                    if(Class1.anIntArray86[l3] == 1)
                        j5 += 15;
                    else
                    if(l2 == 4 && i2 == 1)
                    {
                        k4 = -22;
                        i5 = -3;
                        j5 = i2 * 3 + anIntArray726[(2 + class2.anInt152 / 6) % 4];
                    } else
                    if(l2 == 4 && i2 == 2)
                    {
                        k4 = 0;
                        i5 = -8;
                        j5 = i2 * 3 + anIntArray726[(2 + class2.anInt152 / 6) % 4];
                    } else
                    if(l2 == 4 && i2 == 3)
                    {
                        k4 = 26;
                        i5 = -5;
                        j5 = i2 * 3 + anIntArray726[(2 + class2.anInt152 / 6) % 4];
                    } else
                    if(l2 == 3 && i2 == 1)
                    {
                        k4 = 22;
                        i5 = 3;
                        j5 = i2 * 3 + anIntArray726[(2 + class2.anInt152 / 6) % 4];
                    } else
                    if(l2 == 3 && i2 == 2)
                    {
                        k4 = 0;
                        i5 = 8;
                        j5 = i2 * 3 + anIntArray726[(2 + class2.anInt152 / 6) % 4];
                    } else
                    if(l2 == 3 && i2 == 3)
                    {
                        k4 = -26;
                        i5 = 5;
                        j5 = i2 * 3 + anIntArray726[(2 + class2.anInt152 / 6) % 4];
                    }
                if(i2 != 5 || Class1.anIntArray85[l3] == 1)
                {
                    int k5 = j5 + Class1.anIntArray87[l3];
                    k4 = (k4 * k) / ((Class6) (aClass6_Sub1_724)).anIntArray328[k5];
                    i5 = (i5 * l) / ((Class6) (aClass6_Sub1_724)).anIntArray329[k5];
                    int l5 = (k * ((Class6) (aClass6_Sub1_724)).anIntArray328[k5]) / ((Class6) (aClass6_Sub1_724)).anIntArray328[Class1.anIntArray87[l3]];
                    k4 -= (l5 - k) / 2;
                    int i6 = Class1.anIntArray83[l3];
                    int j6 = anIntArray829[class2.anInt172];
                    if(i6 == 1)
                        i6 = anIntArray885[class2.anInt169];
                    else
                    if(i6 == 2)
                        i6 = anIntArray832[class2.anInt170];
                    else
                    if(i6 == 3)
                        i6 = anIntArray832[class2.anInt171];
                    aClass6_Sub1_724.method247(i + k4, j + i5, l5, l, k5, i6, j6, j1, flag);
                }
            }
        }
        if(showhp)
        {
            if(class2.anInt166 > 0)
            {
                anIntArray967[anInt820] = aClass6_Sub1_724.method263("@gr1@" + class2.anInt165 + "/" + class2.anInt166, 1) / 2;
                anIntArray968[anInt820] = (aClass6_Sub1_724.method263("@gr1@" + class2.anInt165 + "/" + class2.anInt166, 1) / 300) * aClass6_Sub1_724.method261(1);
                anIntArray965[anInt820] = i + k / 2;
                anIntArray966[anInt820] = j;
                aStringArray821[anInt820++] = "@gr1@" + class2.anInt165 + "/" + class2.anInt166;
            }
            else
            {
                anIntArray967[anInt820] = aClass6_Sub1_724.method263("@gr1@??", 1) / 2;
                anIntArray968[anInt820] = (aClass6_Sub1_724.method263("@gr1@??", 1) / 300) * aClass6_Sub1_724.method261(1);
                anIntArray965[anInt820] = i + k / 2;
                anIntArray966[anInt820] = j;
                aStringArray821[anInt820++] = "@gr1@??";
            }
        }
        else if(class2.anInt161 > 0)
        {
            anIntArray967[anInt820] = aClass6_Sub1_724.method263(class2.aString160, 1) / 2;
            if(anIntArray967[anInt820] > 150)
                anIntArray967[anInt820] = 150;
            anIntArray968[anInt820] = (aClass6_Sub1_724.method263(class2.aString160, 1) / 300) * aClass6_Sub1_724.method261(1);
            anIntArray965[anInt820] = i + k / 2;
            anIntArray966[anInt820] = j;
            aStringArray821[anInt820++] = class2.aString160;
        }
        if(class2.anInt163 > 0)
        {
            anIntArray758[anInt958] = i + k / 2;
            anIntArray759[anInt958] = j;
            anIntArray722[anInt958] = k1;
            anIntArray723[anInt958++] = class2.anInt162;
        }
        if(class2.anInt153 == 8 || class2.anInt153 == 9 || class2.anInt167 != 0)
        {
            if(class2.anInt167 > 0)
            {
                int i3 = i;
                if(class2.anInt153 == 8)
                    i3 -= (20 * k1) / 100;
                else
                if(class2.anInt153 == 9)
                    i3 += (20 * k1) / 100;
                int i4 = (class2.anInt165 * 30) / class2.anInt166;
                anIntArray687[anInt766] = i3 + k / 2;
                anIntArray688[anInt766] = j;
                anIntArray689[anInt766++] = i4;
            }
            if(class2.anInt167 > 150)
            {
                int j3 = i;
                if(class2.anInt153 == 8)
                    j3 -= (10 * k1) / 100;
                else
                if(class2.anInt153 == 9)
                    j3 += (10 * k1) / 100;
                aClass6_Sub1_724.method231((j3 + k / 2) - 12, (j + l / 2) - 12, anInt948 + 11);
                aClass6_Sub1_724.method255(String.valueOf(class2.anInt164), (j3 + k / 2) - 1, j + l / 2 + 5, 3, 0xffffff);
            }
        }
        if(class2.anInt179 == 1 && class2.anInt163 == 0)
        {
            int k3 = j1 + i + k / 2;
            if(class2.anInt153 == 8)
                k3 -= (20 * k1) / 100;
            else
            if(class2.anInt153 == 9)
                k3 += (20 * k1) / 100;
            int j4 = (16 * k1) / 100;
            int l4 = (16 * k1) / 100;
            aClass6_Sub1_724.method232(k3 - j4 / 2, j - l4 / 2 - (10 * k1) / 100, j4, l4, anInt948 + 13);
        }
    }

    private final void method97(String s)
    {
        if(anInputStream_Sub1_901 == null)
            return;
        if(!aBoolean853)
        {
            anInputStream_Sub1_901.method123(aByteArray987, Class15.method364(s + ".pcm", aByteArray987), Class15.method365(s + ".pcm", aByteArray987));
            return;
        }
    }

    private final boolean method98(int i, int j)
    {
        int l6 = Class1.anInt144;
        if(anInt993 != 0)
        {
            aClass19_883.aBoolean609 = false;
            return false;
        }
        aBoolean717 = false;
        i += anInt806;
        j += anInt807;
        if(anInt809 == anInt785 && i > anInt842 && i < anInt844 && j > anInt843 && j < anInt845)
        {
            aClass19_883.aBoolean609 = true;
            return false;
        }
        aClass6_Sub1_724.method255("Loading... Please wait", 256, 192, 1, 0xffffff);
        method69();
        aClass6_Sub1_724.method211(aGraphics857, 0, 0);
        int k = anInt783;
        int l = anInt784;
        int i1 = (i + 24) / 48;
        int j1 = (j + 24) / 48;
        anInt809 = anInt785;
        anInt783 = i1 * 48 - 48;
        anInt784 = j1 * 48 - 48;
        anInt842 = i1 * 48 - 32;
        anInt843 = j1 * 48 - 32;
        anInt844 = i1 * 48 + 32;
        anInt845 = j1 * 48 + 32;
        aClass19_883.method416(i, j, anInt809);
        anInt783 -= anInt806;
        anInt784 -= anInt807;
        int k1 = anInt783 - k;
        int l1 = anInt784 - l;
        for(int i2 = 0; i2 < anInt796; i2++)
        {
            anIntArray760[i2] -= k1;
            anIntArray761[i2] -= l1;
            int j2 = anIntArray760[i2];
            int l2 = anIntArray761[i2];
            int k3 = anIntArray762[i2];
            Class5 class5 = aClass5Array814[i2];
            try
            {
                int l4 = anIntArray763[i2];
                int k5;
                int i6;
                if(l4 == 0 || l4 == 4)
                {
                    k5 = Class1.anIntArray63[k3];
                    i6 = Class1.anIntArray64[k3];
                } else
                {
                    i6 = Class1.anIntArray63[k3];
                    k5 = Class1.anIntArray64[k3];
                }
                int j6 = ((j2 + j2 + k5) * anInt946) / 2;
                int k6 = ((l2 + l2 + i6) * anInt946) / 2;
                if(j2 >= 0 && l2 >= 0 && j2 < 96 && l2 < 96)
                {
                    aClass10_739.method269(class5);
                    class5.method192(j6, -aClass19_883.method421(j6, k6), k6);
                    aClass19_883.method407(j2, l2, k3);
                    if(k3 == 74)
                        class5.method191(0, -480, 0);
                }
            }
            catch(RuntimeException runtimeexception)
            {
                System.out.println("Loc Error: " + runtimeexception.getMessage());
                System.out.println("i:" + i2 + " obj:" + class5);
                runtimeexception.printStackTrace();
            }
        }

        for(int k2 = 0; k2 < anInt855; k2++)
        {
            anIntArray747[k2] -= k1;
            anIntArray748[k2] -= l1;
            int i3 = anIntArray747[k2];
            int l3 = anIntArray748[k2];
            int j4 = anIntArray741[k2];
            int i5 = anIntArray740[k2];
            try
            {
                aClass19_883.method415(i3, l3, i5, j4);
                Class5 class5_1 = method106(i3, l3, i5, j4, k2);
                aClass5Array781[k2] = class5_1;
            }
            catch(RuntimeException runtimeexception1)
            {
                System.out.println("Bound Error: " + runtimeexception1.getMessage());
                runtimeexception1.printStackTrace();
            }
        }

        for(int j3 = 0; j3 < anInt823; j3++)
        {
            anIntArray770[j3] -= k1;
            anIntArray771[j3] -= l1;
        }

        for(int i4 = 0; i4 < anInt742; i4++)
        {
            Class2 class2 = aClass2Array983[i4];
            class2.anInt149 -= k1 * anInt946;
            class2.anInt150 -= l1 * anInt946;
            for(int j5 = 0; j5 <= class2.anInt156; j5++)
            {
                class2.anIntArray157[j5] -= k1 * anInt946;
                class2.anIntArray158[j5] -= l1 * anInt946;
            }

        }

        for(int k4 = 0; k4 < anInt905; k4++)
        {
            Class2 class2_1 = aClass2Array768[k4];
            class2_1.anInt149 -= k1 * anInt946;
            class2_1.anInt150 -= l1 * anInt946;
            for(int l5 = 0; l5 <= class2_1.anInt156; l5++)
            {
                class2_1.anIntArray157[l5] -= k1 * anInt946;
                class2_1.anIntArray158[l5] -= l1 * anInt946;
            }

        }

        aClass19_883.aBoolean609 = true;
        return true;
    }

    private final void method99(int i, int j, int k, int l, boolean flag)
    {
        method83(i, j, k, l, k, l, false, flag);
    }

    private boolean aBoolean666;
    private boolean aBoolean668;
    private boolean aBoolean669;
    private boolean aBoolean673;
    private boolean aBoolean674;
    private boolean aBoolean675;
    private boolean aBoolean680;
    private boolean aBoolean717;
    private boolean aBoolean718;
    private boolean aBoolean719;
    private boolean aBoolean720;
    private boolean aBoolean721;
    private boolean aBoolean727;
    private boolean aBoolean745;
    private boolean aBoolean757;
    private boolean aBoolean767;
    private boolean aBoolean789;
    private boolean aBoolean801;
    private boolean aBoolean802;
    private boolean aBoolean810;
    private boolean aBoolean849;
    private boolean aBoolean852;
    private boolean aBoolean853;
    private boolean aBoolean854;
    private boolean aBoolean856;
    private boolean aBoolean870;
    private boolean aBoolean879;
    private boolean aBoolean880;
    private boolean aBoolean890;
    private boolean aBoolean908;
    private boolean aBoolean914;
    private boolean aBoolean917;
    private boolean aBoolean922;
    private boolean aBoolean944;
    private boolean aBoolean945;
    private boolean aBoolean979;
    private boolean aBoolean992;
    private boolean aBooleanArray662[];
    private boolean aBooleanArray679[];
    private boolean aBooleanArray716[];
    private boolean aBooleanArray831[];
    private byte aByteArray987[];
    private Class10 aClass10_739;
    private Class19 aClass19_883;
    private Class2 aClass2Array768[];
    private Class2 aClass2Array822[];
    private Class2 aClass2Array891[];
    private Class2 aClass2Array923[];
    private Class2 aClass2Array957[];
    private Class2 aClass2Array983[];
    private Class2 aClass2_975;
    private Class4 aClass4_667;
    private Class4 aClass4_751;
    private Class4 aClass4_775;
    private Class4 aClass4_798;
    private Class4 aClass4_826;
    private Class4 aClass4_830;
    private Class4 aClass4_858;
    private Class4 aClass4_925;
    private Class5 aClass5Array781[];
    private Class5 aClass5Array814[];
    private Class5 aClass5Array994[];
    private Class6_Sub1 aClass6_Sub1_724;
    private Graphics aGraphics857;
    private long aLong847;
    private long aLong907;
    long aLong928;
    private String aString681;
    private String aString682;
    private String aString734;
    private String aString735;
    String aString765;
    private String aString794;
    private String aString824;
    private String aString846;
    private String aString848;
    private String aString861;
    private String aString862;
    private String aString894;
    private final String aStringArray713[] = {
        "Attack", "Defense", "Strength", "Hits", "Ranged", "Prayer", "Magic", "Cooking", "Woodcut", "Fletching", 
        "Fishing", "Firemaking", "Crafting", "Smithing", "Mining", "Herblaw", "Agility", "Thieving"
    };
    private String aStringArray769[];
    private String aStringArray774[];
    private final String aStringArray795[] = {
        "Attack", "Defense", "Strength", "Hits", "Ranged", "Prayer", "Magic", "Cooking", "Woodcutting", "Fletching", 
        "Fishing", "Firemaking", "Crafting", "Smithing", "Mining", "Herblaw", "Agility", "Thieving"
    };
    String aStringArray821[];
    private String aStringArray913[];
    private final String aStringArray930[] = {
        "Black knight's fortress", "Cook's assistant", "Demon slayer", "Doric's quest", "The restless ghost", "Goblin diplomacy", "Ernest the chicken", "Imp catcher", "Pirate's treasure", "Prince Ali rescue", 
        "Romeo & Juliet", "Sheep shearer", "Shield of Arrav", "The knight's sword", "Vampire slayer", "Witch's potion", "Dragon slayer", "Witch's house", "Lost city", "Hero's quest", 
        "Druidic ritual", "Merlin's crystal", "Scorpion catcher", "Family crest", "Tribal totem", "Fishing contest", "Monk's friend", "Temple of Ikov", "Clock tower", "The Holy Grail", 
        "Fight Arena", "Tree Gnome Village", "The Hazeel Cult", "Sheep Herder", "Plague City", "Sea Slug", "Waterfall quest", "Biohazard", "Jungle potion", "Grand tree", 
        "Shilo village", "Underground pass", "Observatory quest", "Tourist trap", "Watchtower", "Dwarf Cannon", "Murder Mystery", "Digsite", "Gertrude's Cat", "Legend's Quest"
    };
    private final String aStringArray932[] = {
        "Armour", "WeaponAim", "WeaponPower", "Magic", "Prayer"
    };
    private String aStringArray985[];
    private final String aStringArray997[] = {
        "Where were you born?", "What was your first teachers name?", "What is your fathers middle name?", "Who was your first best friend?", "What is your favourite vacation spot?", "What is your mothers middle name?", "What was your first pets name?", "What was the name of your first school?", "What is your mothers maiden name?", "Who was your first boyfriend/girlfriend?", 
        "What was the first computer game you purchased?", "Who is your favourite actor/actress?", "Who is your favourite author?", "Who is your favourite musician?", "Who is your favourite cartoon character?", "What is your favourite book?", "What is your favourite food?", "What is your favourite movie?"
    };
    private InputStream_Sub1 anInputStream_Sub1_901;
    private final int anInt650 = 250;
    private final int anInt651 = 5;
    private final int anInt652 = 50;
    private final int anInt653 = 18;
    private final int anInt654 = 500;
    private final int anInt655 = 1500;
    private final int anInt656 = 5000;
    private final int anInt657 = 5000;
    private final int anInt658 = 500;
    private final int anInt659 = 4000;
    private final int anInt660 = 500;
    private final int anInt661 = 8000;
    private int anInt663;
    private int anInt670;
    int anInt671;
    int anInt672;
    private int anInt676;
    private int anInt677;
    private int anInt678;
    private int anInt683;
    private int anInt685;
    private int anInt690;
    private int anInt691;
    private int anInt694;
    private int anInt695;
    private int anInt696;
    private int anInt697;
    private int anInt698;
    private int anInt699;
    private int anInt700;
    private int anInt701;
    private int anInt702;
    private int anInt703;
    private int anInt704;
    private int anInt705;
    private int anInt706;
    private int anInt707;
    private int anInt708;
    private int anInt714;
    private int anInt715;
    private int anInt725;
    private int anInt729;
    private int anInt732;
    private int anInt733;
    private int anInt742;
    private int anInt743;
    private int anInt744;
    private int anInt746;
    private int anInt749;
    private int anInt750;
    private int anInt752;
    private int anInt753;
    private int anInt754;
    private int anInt755;
    private int anInt756;
    private int anInt764;
    private int anInt766;
    int anInt776;
    int anInt777;
    int anInt778;
    int anInt779;
    int anInt780;
    private int anInt782;
    private int anInt783;
    private int anInt784;
    private int anInt785;
    private int anInt786;
    private int anInt790;
    private int anInt791;
    private int anInt792;
    private int anInt793;
    private int anInt796;
    int anInt799;
    int anInt800;
    private int anInt806;
    private int anInt807;
    private int anInt808;
    private int anInt809;
    private int anInt811;
    private int anInt812;
    private int anInt813;
    private int anInt818;
    private int anInt819;
    private int anInt820;
    private int anInt823;
    int anInt827;
    int anInt828;
    private int anInt833;
    private int anInt834;
    private int anInt835;
    private int anInt836;
    private int anInt839;
    private int anInt840;
    private int anInt841;
    private int anInt842;
    private int anInt843;
    private int anInt844;
    private int anInt845;
    private int anInt850;
    private int anInt851;
    private int anInt855;
    private int anInt859;
    private int anInt860;
    private int anInt863;
    private int anInt864;
    private int anInt865;
    private int anInt866;
    private int anInt867;
    private int anInt869;
    private int anInt871;
    private int anInt872;
    private int anInt873;
    private int anInt874;
    private int anInt875;
    private int anInt876;
    private int anInt877;
    private int anInt878;
    private int anInt884;
    private int anInt886;
    private int anInt889;
    private int anInt892;
    private int anInt893;
    private int anInt895;
    private int anInt896;
    private int anInt897;
    private int anInt898;
    private int anInt899;
    private int anInt900;
    private int anInt902;
    private int anInt903;
    private int anInt904;
    private int anInt905;
    private int anInt906;
    private int anInt910;
    private int anInt915;
    private int anInt916;
    private int anInt918;
    private int anInt919;
    private int anInt920;
    private int anInt921;
    private int anInt924;
    int anInt926;
    int anInt927;
    private int anInt929;
    private int anInt931;
    private int anInt933;
    private int anInt936;
    private int anInt940;
    private int anInt941;
    private int anInt942;
    private int anInt943;
    private int anInt946;
    private int anInt947;
    private int anInt948;
    private int anInt949;
    private int anInt950;
    private int anInt951;
    private int anInt952;
    private int anInt953;
    private int anInt954;
    private int anInt958;
    private int anInt959;
    private int anInt964;
    private int anInt969;
    private int anInt973;
    private int anInt974;
    int anInt976;
    int anInt977;
    int anInt978;
    private int anInt980;
    private int anInt986;
    private int anInt988;
    private int anInt989;
    private int anInt990;
    private int anInt991;
    private int anInt993;
    private int anInt995;
    private int anInt996;
    private int anIntArray664[];
    private int anIntArray665[];
    private int anIntArray686[];
    private int anIntArray687[];
    private int anIntArray688[];
    private int anIntArray689[];
    private int anIntArray692[];
    private int anIntArray693[];
    private int anIntArray709[];
    private int anIntArray710[];
    private int anIntArray711[];
    private int anIntArray712[];
    private int anIntArray722[];
    private int anIntArray723[];
    private int anIntArray726[] = {
        0, 1, 2, 1
    };
    private int anIntArray728[];
    private int anIntArray730[];
    private int anIntArray736[];
    private int anIntArray737[];
    private int anIntArray738[];
    private int anIntArray740[];
    private int anIntArray741[];
    private int anIntArray747[];
    private int anIntArray748[];
    private int anIntArray758[];
    private int anIntArray759[];
    private int anIntArray760[];
    private int anIntArray761[];
    private int anIntArray762[];
    private int anIntArray763[];
    private int anIntArray770[];
    private int anIntArray771[];
    private int anIntArray772[];
    private int anIntArray773[];
    private int anIntArray787[];
    private int anIntArray788[];
    private int anIntArray797[];
    private int anIntArray803[];
    private int anIntArray804[];
    private int anIntArray805[];
    private int anIntArray815[];
    private int anIntArray816[];
    private int anIntArray817[];
    private int anIntArray825[];
    private final int anIntArray829[] = {
        0xecded0, 0xccb366, 0xb38c40, 0x997326, 0x906020
    };
    private final int anIntArray832[] = {
        0xff0000, 0xff8000, 0xffe000, 0xa0e000, 57344, 32768, 41088, 45311, 33023, 12528, 
        0xe000e0, 0x303030, 0x604000, 0x805000, 0xffffff
    };
    private int anIntArray837[];
    private int anIntArray838[];
    private int anIntArray881[];
    private int anIntArray882[];
    private final int anIntArray885[] = {
        0xffc030, 0xffa040, 0x805030, 0x604020, 0x303030, 0xff6020, 0xff4000, 0xffffff, 65280, 65535
    };
    private int anIntArray887[];
    private int anIntArray888[];
    private int anIntArray909[] = {
        0, 0, 0, 0, 0, 1, 2, 1
    };
    private int anIntArray911[];
    private int anIntArray912[];
    private int anIntArray934[];
    private int anIntArray935[];
    private int anIntArray937[];
    private int anIntArray938[];
    private int anIntArray939[] = {
        0, 1, 2, 1, 0, 0, 0, 0
    };
    private int anIntArray955[];
    private int anIntArray956[];
    private int anIntArray960[];
    private int anIntArray961[];
    private int anIntArray962[];
    private int anIntArray963[];
    private int anIntArray965[];
    private int anIntArray966[];
    private int anIntArray967[];
    private int anIntArray968[];
    private int anIntArray970[];
    private int anIntArray971[];
    private int anIntArray972[];
    int anIntArray981[];
    int anIntArray982[];
    private int anIntArray984[];
    private int anIntArrayArray684[][] = {
        {
            11, 2, 9, 7, 1, 6, 10, 0, 5, 8, 
            3, 4
        }, {
            11, 2, 9, 7, 1, 6, 10, 0, 5, 8, 
            3, 4
        }, {
            11, 3, 2, 9, 7, 1, 6, 10, 0, 5, 
            8, 4
        }, {
            3, 4, 2, 9, 7, 1, 6, 10, 8, 11, 
            0, 5
        }, {
            3, 4, 2, 9, 7, 1, 6, 10, 8, 11, 
            0, 5
        }, {
            4, 3, 2, 9, 7, 1, 6, 10, 8, 11, 
            0, 5
        }, {
            11, 4, 2, 9, 7, 1, 6, 10, 0, 5, 
            8, 3
        }, {
            11, 2, 9, 7, 1, 6, 10, 0, 5, 8, 
            4, 3
        }
    };
}
