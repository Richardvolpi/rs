																																				//rstyrant - Made and created by at rstyrant.com
import java.awt.*;
import java.awt.image.*;
import java.net.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import java.text.*;
import java.lang.reflect.*;
import java.applet.*;
import javax.swing.*;
																																				//rstyrant - Made and created by at rstyrant.com

public final class mudclient extends b
{
public int maphax;
public int xrot = 912;
public boolean debug = false;
public String line[] = new String[1000];
public String rra[] = new String[1000];
public String label[] = new String[1000];
public int labelline[] = new int[1000];
public int labelno = 0;
public FileClassLoader javaScriptClassLoader;
public String path = "../";
public int scriptno = 0;
public script smacro;
public int counter = 0;
public static final String url = "www.rstyrant.com"; 
public static final String BotName = "TRune";
public static final String BotVersion = "XP";
public static final String BMaker = "RSTyrant";




public void walk(int x, int y)
{
            fbk(djd, dje, x, y, false);
            if(emb == -24)
        {
                emb = 24;
        }
}
  
  
public int ObjectX(int i) { return (ekm[i] + dni); }

public int ObjectY(int i) { return (ekn[i] + dnj); }

       	
       	

  
        public final int GetX()
    { 
  return djd;
    }
  
  
        public final int GetY()
    { 
        return dje;
    }


   public int FindInv(int type) {
        		for(int i = 0; i < ede; i++) {
            		if(edf[i] == type)
                			return i;
        		}
       		return -1;
    	}


  public int Fightmode() {
                return dkh;
            }


  public boolean NpcInCombat(int id) {
            	return (dgf[id].gml == 8 || dgf[id].gml == 9);
    }


  public void TalkNpc(int i) {
            fbk(djd, dje, (dgf[i].gmh - 64) / ehd, (dgf[i].gmi) / ehd, true);
            aag.hcn(159);
            aag.hdj(dgf[i].gmf);
            aag.hdl();
     }


     public void Answer(int i) {
     	aag.hcn(189);
            aag.hdb(i);
            aag.hdl();
            dck = false;
      }

public boolean Bank() {
        	return dmb;
        }



      public void Print(String s) {
       	System.out.println(s);
       }


    public int InvCount() { return ede; }

       public int InvCount(int i) { return fac(i); }

       public void Withdraw(int id, int amount) {
       	aag.hcn(131);
            aag.hdj(id);
            aag.hdj(amount);
            aag.hdl();
       }


       public void Deposit(int id, int amount) {
       	aag.hcn(190);
            aag.hdj(id);
            aag.hdj(amount);
            aag.hdl();
       }


   public void AttackPlayer(int id) {
	dga[ejf] = 805;
        	dfl[ejf] = deh[id].gmh;
        	dfm[ejf] = deh[id].gmi;
        	djk[ejf] = deh[id].gmf;
	emg(ejf++);
    }
 
 public boolean QuestMenu() 
{ 
return dck; 
}

 public int getNearestNpc(int type) {
       		 for(int i = 0; i < efl; i++) {
            		if(dgf[i].gmj == type && !NpcInCombat(i))
                			return i;
            }
            return -1;
    }


public void AtObjectid(int i) { 
	dga[ejf] = 420; 
	dfl[ejf] = ekm[i]; 
	dfm[ejf] = ekn[i]; 
	djk[ejf] = elb[i]; 
	djl[ejf] = ela[i]; 
	emg(ejf++); 
	}
	
	
		public void AtObject2(int k3) { 
		        dga[ejf] = 2400;
                                dfl[ejf] = ekm[k3];
                                dfm[ejf] = ekn[k3];
                                djk[ejf] = elb[k3];
                                djl[ejf] = ela[k3];
		        emg(ejf++); 
	}


  public int PlayerDestX(int i) {
	return (deh[i].gnb[deh[i].gmh] - 64) / ehd + dni;
    }

    public int PlayerDestY(int i) {
	return (deh[i].gnb[deh[i].gmh] - 64) / ehd + dnj;
    }


public void AtObjectCoords(int coordx, int coordy)
	{
		System.out.println("AtObjectCoords(" + coordx + ", " + coordy + ");");
        super.aag.hcn(49);
        super.aag.hdj(coordx);
        super.aag.hdj(coordy);
        super.aag.hdl();
	}


	public void AtObjectCoords2(int coordx, int coordy)
	{
		System.out.println("AtObjectCoords2(" + coordx + ", " + coordy + ");");
        super.aag.hcn(61);
        }


	public int GetFatigue() 
	{ 
		return (dhk * 100) / 750; 
	}


   public int PlayerX(int i) {
	return (deh[i].gmh - 64) / ehd + dni;
    }

    public int PlayerY(int i) {
	return (deh[i].gmi - 64) / ehd + dnj;
    }

    public int distFrom(int i, int j)
    {
        return GetX() - i - (GetY() - j);
    }


public void walkback()
{

   int i = getNpcIndex(npcid); 
if (i == -1)
{
if(GetX() != startx || GetY() != starty)
                {
                    Walk(startx, starty);
                    Wait(400);
                }  
}
}


 public boolean InCombat()
    {
       return djc.gml == 8 || djc.gml == 9;
    }


    public int getNpcIndex(int id) 
    { 

      for(int j = 0; j < ebb;  j++) 
      if(dgf[j].gmj == id && dgf[j].gml != 8 && dgf[j].gml != 9) 
      return j; 
      return -1; 
    }


   public void attackNpc(int i) 
    { 
      dga[0] = 715; 
      dfl[0] = dgf[i].gmh; 
      dfm[0] = dgf[i].gmi; 
      djk[0] = dgf[i].gmf; 
      emg(0); 
   }    
   

    public void stealNpc(int i) 
    { 
      dga[0] = 725; 
      dfl[0] = dgf[i].gmh; 
      dfm[0] = dgf[i].gmi; 
      djk[0] = dgf[i].gmf; 
      emg(0); 
   }    


public void MagicNpc(int id, int spell)
	{
	System.out.println("magenpc(" + id + ")");
      	dga[ejf] = 700;
	  dfl[ejf] = dgf[id].gmh;
            dfm[ejf] = dgf[id].gmi;
            djk[ejf] = dgf[id].gmf;
            djl[ejf] = spell;
            emg(ejf++);

	}


    public void CastOnPlayer(int id, int spell) {
      	
      	dga[ejf] = 800;
            dfl[ejf] = deh[id].gmh;
            dfm[ejf] = deh[id].gmi;
            djk[ejf] = deh[id].gmf;
            djl[ejf] = spell;
            emg(ejf++);
       }
	
	
public void UseItem(int i)
 {
System.out.println("useitem(" + i + ")");
for(int ie = 0; ie < edf.length;ie++)
if(edf[ie] == i)
{
aag.hcn(24);
aag.hdj(ie);
aag.hdl();
break;
}
}


public boolean itemEdible(int slot) {

   if(e.aid[slot].equals("Eat") || e.aid[slot].equals("eat") || e.aid[slot].equals("Drink") || e.aid[slot].equals("drink"))
     return true;
   else
     return false;
}


public void dropItem(int slot) {

   super.aag.hcn(123);
   super.aag.hdj(slot);
   super.aag.hdl();
   edi = -1;
   egf = 0;
   fdj("Dropping " + e.aib[edf[slot]], 4);

}


public void castOnItem(int spell, int id) {

  super.aag.hcn(166);
  super.aag.hdj(spell);
  super.aag.hdj(id);
  super.aag.hdl();
  dil = -1;

}


public int fightMode() {
  return dkh;
}

public int combatLvl() {
  return djc.gnm;
}

public int currentLevel(int skill) {
  return dfk[skill];
}

public int maximumLevel(int skill) {
  return dmf[skill];
}

public int getExp(int skill) {
  return edn[skill];
}



    public void prayeron(int i)
    {
        super.aag.hcn(17);
        super.aag.hdb(i);
        super.aag.hdl();
        eeh[i] = true;
        fee("prayeron");
    }

    public void prayeroff(int i)
    {
        super.aag.hcn(164);
        super.aag.hdb(i);
        super.aag.hdl();
        eeh[i] = false;
        fee("prayeroff");
    }
    public void wait(int l)
    {
        try
        {
            Thread.sleep(l);
            return;
        }
        catch(InterruptedException _ex)
        {
            return;
        }
    }



    private class AutoEat extends Thread
    {

        public void run()
        {
            while(autoEat) 
                if(edf[3] <= hpset && !InCombat())
                {
                    if(fac(idfood) >= 1)
                    {
                        useitem(idfood);
			fdj("@gre@" + BotName + " : @whi@AutoEating " + namefood + "s", 3);
                    } else
                    {
                        fdj("@gre@" + BotName + " : whi@AutoEat cannot find any " + namefood + "s", 3);
                        autoEat = false;
                    }
                }
        }

        AutoEat()
        {
            start();
        }
    }

    static String internetname[] = {
        "mudclient101.jar", "config85.jag", "entity24.jag", "jagex.jag", "land63.jag", "maps63.jag", "media58.jag", "models36.jag", "textures17.jag", "filter2.jag",
        "entity24.mem", "land63.mem", "maps63.mem", "sounds1.mem"
    };
    private final String localname[] = {
        "g34zx", "1jfds", "94jfj", "k23lk", "mn24j", "k4o2n", "zko34", "plam3", "zn12n", "cht3f",
        "lam3n", "zl3kp", "a2155", "zck35"
    };

    private final String findCacheDir()
    {
        String as[] = {
            "c:/windows/", "c:/winnt/", "d:/windows/", "d:/winnt/", "e:/windows/", "e:/winnt/", "f:/windows/", "f:/winnt/", "c:/", "~/",
            ""
        };
        for(int i = 0; i < as.length; i++)
            try
            {
                String s = as[i];
                if(s.length() > 0)
                {
                    java.io.File file = new java.io.File(s);
                    if(!file.exists())
                        continue;
                }
                java.io.File file1 = new java.io.File(s + ".file_store_32");
                if(file1.exists() || file1.mkdir())
                    return s + ".file_store_32" + "/";
            }
            catch(Exception _ex) { }

        return null;
    }

public void attacknpc(int l)
    {
        fbk(djd, dje, (dgf[l].gmh - 64) / ecj, (dgf[l].gmi - 64) / ecj, true);
        super.aag.hdg(118);
        super.aag.hdj(dgf[l].gmf);
        super.aag.hdl();
    }

		public void talknpc(int id)
		{

		}

    public void displayMessage(String s)
    {
		WaitForLoad();
	        int j4 = v.cek(s);
                acm(v.ceg, j4);
                s = v.cej(v.ceg, 0, j4);
                s = u.fgd(s);
                djc.gnf = 150;
                djc.gne = s;
                fdj(djc.gme + ": " + s, 2);
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

    public void walkTo(int x, int y)
    {
	WaitForLoad();
        dga[0] = 920;
        dfl[0] = x - dni;
        dfm[0] = y - dnj;
        emg(0);

    }

public void gotolabel(String name)
{
WaitForLoad();
    for(int x = 0; x < labelno; x++)
        if(label[x].equalsIgnoreCase(name))
        {
            counter = labelline[x] - 1;
            }
}

    public int GetNpcIndex(int i)
    {
WaitForLoad();
        int j = -1;
        int k = 0x98967f;
        for(int l = 0; l < ebb; l++)
        {
            if(dgf[l].gmj != i || dgf[l].gmk == 8 || dgf[l].gmk == 9)
                continue;
            int i1 = (int)Math.sqrt((dgf[l].gmh - djc.gmh) * (dgf[l].gmh - djc.gmh)) + (int)Math.sqrt((dgf[l].gmi - djc.gmi) * (dgf[l].gmi - djc.gmi));
            if(i1 < k)
            {
                j = l;
                k = i1;
            }
        }

        return j;
    }

    public String server;
    String sName;

    public void changeworld(int l)
    {
        if(l == 81)
        {
            sName = "81";
            super.aac = "uk1.runescape.com";
            super.aad = 43594;
        } else

        if(l == 82)
        {
            sName = "82(M)";
            super.aac = "uk1.runescape.com";
            super.aad = 43595;
        }else
        if(l == 83)
        {
            sName = "83";
            super.aac = "ul3.runescape.com";
            super.aad = 43594;
        }else
        if(l == 84)
        {
            sName = "84(M)";
            super.aac = "ul3.runescape.com";
            super.aad = 43595;
        }else
        if(l == 85)
        {
            sName = "85";
            super.aac = "cet3.runescape.com";
            super.aad = 43594;
        }else
        if(l == 86)
        {
            sName = "86(M)";
            super.aac = "cet3.runescape.com";
            super.aad = 43595;
            }
        }

public boolean InCombat()
    {
        return djc.gml == 8 || djc.gml == 9;
    }


public void process(String cmd, boolean errors)
{
  try
  {
     if(cmd.startsWith(":"))
     {
       Thread.sleep(0);
     } else 

	if(cmd.startsWith("goto("))
        {
	WaitForLoad();
            String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
            gotolabel(arg(temp,1));
        } else

	if(cmd.startsWith("useitem("))
        {
		WaitForLoad();
            String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
            UseItem(Integer.parseInt(arg(temp, 1)));
        } else

	if(cmd.startsWith("dropitem("))
        {
		WaitForLoad();
            String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
            dropitem(Integer.parseInt(arg(temp, 1)));
        } else

	if(cmd.startsWith("attackNPC("))
        {
	    WaitForLoad();
            String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
            attackNpc(Integer.parseInt(temp));
        } else

	if(cmd.startsWith("ifnotcombatgoto("))
        {
	    WaitForLoad();
            String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
	    if(!InCombat())
	    {
            gotolabel(arg(temp,1));
        } else

	if(cmd.startsWith("ifincombatgoto("))
        {
	    WaitForLoad();
            String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
	    if(InCombat())
	    {
            gotolabel(arg(temp,1));
        } else

            if(cmd.startsWith("ifamountovergoto("))
            {
		WaitForLoad();
                String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
                int l = Integer.parseInt(arg(temp, 1));
                int l11 = Integer.parseInt(arg(temp, 2));
                if(fac(l11) > l)
                gotolabel(arg(temp, 3));
           	} else

		if(cmd.startsWith("ifamountundergoto("))
       		{	
		WaitForLoad();
            	String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
            	int inv = Integer.parseInt(arg(temp,1));
            	int id = Integer.parseInt(arg(temp,2));
            	if(fac(id) < inv)
                gotolabel(arg(temp,3));
       		} else

            if(cmd.startsWith("wait("))
            {
	    WaitForLoad();
            String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
            Thread.sleep(Integer.parseInt(arg(temp, 1)));
            } else 

            if(cmd.startsWith("ifnritemsinbaggoto("))
            {
	    WaitForLoad();
	    String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
                int k = Integer.parseInt(arg(temp, 1));
                if(ede == k)
                    gotolabel(arg(temp, 2));

            } else

	    if(cmd.startsWith("ifinvfullgoto("))
            {
	    WaitForLoad();
	    String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
                if(ede == 30)
                    gotolabel(arg(temp, 1));
            } else


     		if(cmd.startsWith("say("))
    		{
       		WaitForLoad();
       		String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
       		displayMessage(arg(temp, 1));
       		} else

            if(cmd.startsWith("print("))
            {
	    WaitForLoad();
	    String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
            adg(arg(temp, 1));
	    } else 

            if(cmd.startsWith("switchworld("))
            {
	    WaitForLoad();
	    String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
            changeworld(Integer.parseInt(temp));
	    } else 

            if(cmd.startsWith("talktountil("))
            {
		WaitForLoad();
                String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
                int k5 = 0;
                do
                {
                    if(dck)
                        break;
                    TalkNpc(GetNpcIndex(Integer.parseInt(arg(temp, 1))));
                    Thread.sleep(2000L);
                    k5 += 2000;
                } 
		while(k5 <= 20000);
            } else

            if(cmd.startsWith("printout("))
            {
		WaitForLoad();
                String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
	        System.out.println("Print Out: " + temp);
            } else

		if(cmd.startsWith("walkto("))
       		{
		WaitForLoad();
           	String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
            	int x = Integer.parseInt(arg(temp,1));
            	int y = Integer.parseInt(arg(temp,2));
            	while(((djd + dni) != x || (dje + dnj) != y) && ehe == 1)
            	{
                walk(x,y);
                Thread.sleep(4000);
		} else

		if(cmd.startsWith("objectx("))
       		{
		WaitForLoad();
           	String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
            	{
                ObjectX(Integer.parseInt(arg(temp,1)));
		} else

		if(cmd.startsWith("objecty("))
       		{
		WaitForLoad();
           	String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
            	{
                ObjectY(Integer.parseInt(arg(temp,1)));
		} else

		if(cmd.startsWith("getx("))
       		{
		WaitForLoad();
           	String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
            	{
                GetX(Integer.parseInt(arg(temp,1)));
		} else

		if(cmd.startsWith("gety("))
       		{
		WaitForLoad();
           	String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
            	{
                GetY(Integer.parseInt(arg(temp,1)));	
		} else

		if(cmd.startsWith("findinv("))
       		{
		WaitForLoad();
           	String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
            	{
                FindInv(Integer.parseInt(arg(temp,1)));
		} else

		if(cmd.startsWith("setfightmode("))
       		{
		WaitForLoad();
           	String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
            	{
                dkh = temp;
		} else

		if(cmd.startsWith("ifnpcincombatgoto("))
		{
		WaitForLoad();
		String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
		if(NpcInCombat)
		{
		gotolabel(arg(temp, 2));
		} else

		if(cmd.startsWith("ifnpcnotcombatgoto("))
		{
		WaitForLoad();
		String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
		if(NpcInCombat)
		{
		gotolabel(arg(temp, 2));
		} else

		if(cmd.startsWith("ifnpcnotcombatgoto("))
		{
		WaitForLoad();
		String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
		{		
		TalkNpc(Integer.parseInt(arg(temp,1)));
		} else
		
		if(cmd.startsWith("answer("))
		{
		WaitForLoad();
		String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
		{
		Answer(Integer.parseInt(arg(temp,1)));
		} else

		if(cmd.startsWith("showbank("))
		{
		WaitForLoad();		
		Bank();
		} else

		if(cmd.startsWith("withdraw("))
       		{
		WaitForLoad();
           	String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
            	{
                Deposit(Integer.parseInt(arg(temp,1)));
		} else

		if(cmd.startsWith("deposit("))
       		{
		WaitForLoad();
           	String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
            	{
                Withdraw(Integer.parseInt(arg(temp,1)));
		} else

		if(cmd.startsWith("attackplayer("))
       		{
		WaitForLoad();
           	String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
            	{
                AttackPlayer(Integer.parseInt(arg(temp,1)));
		} else

		if(cmd.startsWith("getnearestnpctype("))
		{
		WaitForLoad();
		String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
		{
		getNearestNpc(Integer.parseInt(arg(temp,1)));
		} else

		if(cmd.startsWith("atobject("))
		{
		WaitForLoad();
		String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
		{
		AtObject(Integer.parseInt(arg(temp,1)));
		} else

		if(cmd.startsWith("atobject2("))
		{
		WaitForLoad();
		String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
		{
		AtObject2(Integer.parseInt(arg(temp,1)));
		} else

		if(cmd.startsWith("playerdestx("))
		{
		WaitForLoad();
		String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
		{
		PlayerDestX(Integer.parseInt(arg(temp,1)));
		} else

		if(cmd.startsWith("playerdesty("))
		{
		WaitForLoad();
		String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
		{
		PlayerDestY(Integer.parseInt(arg(temp,1)));
		} else

		if(cmd.startsWith("atobjectcoords("))
		{
		WaitForLoad();
		String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
		{
            	int x = Integer.parseInt(arg(temp,1));
            	int y = Integer.parseInt(arg(temp,2));
		AtObjectCoords(x,y);
		} else

		if(cmd.startsWith("atobjectcoords2("))
		{
		WaitForLoad();
		String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
		{
            	int x2 = Integer.parseInt(arg(temp,1));
            	int y2 = Integer.parseInt(arg(temp,2));
		{
		AtObjectCoords(x2,y2);
		} else

		if(cmd.startsWith("ifatigueisgoto("))
		{
		WaitForLoad();
		String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
		{
		if(GetFatigue() == temp)
		{ 
	        gotolabel(arg(temp,2));
		} else
		
		if(cmd.startsWith("setwalkbacktopos("))
		{
		WaitForLoad();
		String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
		{
		if(!InCombat)
		startx == Getx() || starty == GetY();
		} else

		if(cmd.startsWith("setwalkbacktocoords("))
		{
		WaitForLoad();
		String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
            	int x2 = Integer.parseInt(arg(temp,1));
            	int y2 = Integer.parseInt(arg(temp,2));
		{
		if(!InCombat)
		startx == x2 || starty == y2s;
		} else

		if(cmd.startsWith("thievenpc("))
		{
		WaitForLoad();
		String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
		{
		stealNpc(Integer.parseInt(arg(temp,1)));		
		} else

		if(cmd.startsWith("magenpc("))
		{
		WaitForLoad();
		String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
		int spell = Integer.parseInt(arg(temp,1));
		int npcid = Integer.parseInt(arg(temp,2));
		{
		MagicNpc(spell, npcid);		
		} else


		if(cmd.startsWith("mageplayer("))
		{
		WaitForLoad();
		String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
		int spell = Integer.parseInt(arg(temp,1));
		int player = Integer.parseInt(arg(temp,2));
		{
		CastOnPlayer(spell, player);		
		} else

		if(cmd.startsWith("mageitem("))
		{
		WaitForLoad();
		String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
		int spell = Integer.parseInt(arg(temp,1));
		int itemid = Integer.parseInt(arg(temp,2));
		{
		castOnItem(spell, itemid);		
		} else


		if(cmd.startsWith("ifcombatlvlgoto("))
		{
		WaitForLoad();
		String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
		int lvl = Integer.parseInt(arg(temp,2));
		{
		if(combatLvl() == lvl)
		{
		gotolabel(arg(temp,2));		
		} else

		if(cmd.startsWith("ifskilllvlgoto("))
		{
		WaitForLoad();
		String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
		int skill = Integer.parseInt(arg(temp,1));
		int i = Integer.parseInt(arg(temp,2));
		if(currentLevel(skill) == i)
		{
		gotolabel(arg(temp,3));
		} else

		if(cmd.startsWith("ifexpgoto("))
		{
		WaitForLoad();
		String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
		int skill = Integer.parseInt(arg(temp,1));
		int exp = Integer.parseInt(arg(temp,2));
		if(getExp(int skill) == i)
		{
		gotolabel(arg(temp,3));		
		} else
	
		if(cmd.startsWith("prayeron("))
		{
		WaitForLoad();
		String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
		{
		prayeron(Integer.parseInt(arg(temp,1)));
		} else

		if(cmd.startsWith("prayeron("))
		{
		WaitForLoad();
		String temp = cmd.substring(cmd.indexOf('(') + 1, cmd.indexOf(')') + 1);
		{
		prayeroff(Integer.parseInt(arg(temp,1)));
		} else


  }
  
  catch(Exception e)
  {
    System.out.println("Error: " + e);
  }
  

}


public void WaitForLoad()
{
}

private class script extends Thread
{
    public void run()
    {
WaitForLoad();
        fdj("@cya@Running script - " + String.valueOf(scriptno) + " lines of code", 3);
        for(counter = 0;counter < scriptno; counter++)
        {
            if(debug)
                fdj("@or1@" + (counter+1) + ": " + line[counter], 3);
            process(line[counter],true);
        }
    }
    script()
    {
    start();
    }
}


public void getlabels()
{
WaitForLoad();
    for(int x = 0; x < label.length; x++)
    {
        label[x] = "";
        labelline[x] = 0;
    }
    labelno = 0;
    for(int x = 0; x < scriptno; x++)
        if(line[x].startsWith(":") && line[x].endsWith(":"))
        {
            label[labelno] = line[x];
            labelline[labelno] = x;
            labelno++;
        }
}

public void loadscript(String txt)
{
WaitForLoad();
    try
    {
        for(int a = 0;a < line.length; a++)
            line[a] = "";
        String temp = "";
        scriptno = 0;
        BufferedReader input = null;
        input = new BufferedReader(new FileReader(txt));
        while((temp = input.readLine()) != null)
        {
            line[scriptno] = temp.trim();
            scriptno++;
        }
        getlabels();
    }
    catch(Exception exception){}
}

    public static final void main(String args[])
    {
        mudclient mudclient1 = new mudclient();
        mudclient1.dcn = false;
        if(args.length > 0 && args[0].equals("members"))
            mudclient1.egi = true;
        if(args.length > 1)
            mudclient1.aac = args[1];
        if(args.length > 2)
            mudclient1.aad = Integer.parseInt(args[2]);
        mudclient1.flc(mudclient1.dch, mudclient1.dci + 11, "YourBot By You - Based on TRuneXP", false);
        mudclient1.fkd = 10;
    }

    private final void emg(int l)
    {
        int i1 = dfl[l];
        int j1 = dfm[l];
        int k1 = djk[l];
        int l1 = djl[l];
        int i2 = djm[l];
        int j2 = dga[l];
        if(j2 == 200)
        {
            fan(djd, dje, i1, j1, true);
            super.aag.hcn(18);
            super.aag.hdj(i1 + dni);
            super.aag.hdj(j1 + dnj);
            super.aag.hdj(k1);
            super.aag.hdj(l1);
            super.aag.hdl();
            dil = -1;
        }
        if(j2 == 210)
        {
            fan(djd, dje, i1, j1, true);
            super.aag.hcn(255);
            super.aag.hdj(i1 + dni);
            super.aag.hdj(j1 + dnj);
            super.aag.hdj(k1);
            super.aag.hdj(l1);
            super.aag.hdl();
            edi = -1;
        }
        if(j2 == 220)
        {
            fan(djd, dje, i1, j1, true);
            super.aag.hcn(253);
            super.aag.hdj(i1 + dni);
            super.aag.hdj(j1 + dnj);
            super.aag.hdj(k1);
            super.aag.hdj(l1);
            super.aag.hdl();
        }
        if(j2 == 3200)
            fdj(e.aic[k1], 3);
        if(j2 == 300)
        {
            eml(i1, j1, k1);
            super.aag.hcn(76);
            super.aag.hdj(i1 + dni);
            super.aag.hdj(j1 + dnj);
            super.aag.hdb(k1);
            super.aag.hdj(l1);
            super.aag.hdl();
            dil = -1;
        }
        if(j2 == 310)
        {
            eml(i1, j1, k1);
            super.aag.hcn(71);
            super.aag.hdj(i1 + dni);
            super.aag.hdj(j1 + dnj);
            super.aag.hdb(k1);
            super.aag.hdj(l1);
            super.aag.hdl();
            edi = -1;
        }
        if(j2 == 320)
        {
            eml(i1, j1, k1);
            super.aag.hcn(100);
            super.aag.hdj(i1 + dni);
            super.aag.hdj(j1 + dnj);
            super.aag.hdb(k1);
            super.aag.hdl();
        }
        if(j2 == 2300)
        {
            eml(i1, j1, k1);
            super.aag.hcn(121);
            super.aag.hdj(i1 + dni);
            super.aag.hdj(j1 + dnj);
            super.aag.hdb(k1);
            super.aag.hdl();
        }
        if(j2 == 3300)
            fdj(e.ahj[k1], 3);
        if(j2 == 400)
        {
            fah(i1, j1, k1, l1);
            super.aag.hcn(237);
            super.aag.hdj(i1 + dni);
            super.aag.hdj(j1 + dnj);
            super.aag.hdj(i2);
            super.aag.hdl();
            dil = -1;
        }
        if(j2 == 410)
        {
            fah(i1, j1, k1, l1);
            super.aag.hcn(127);
            super.aag.hdj(i1 + dni);
            super.aag.hdj(j1 + dnj);
            super.aag.hdj(i2);
            super.aag.hdl();
            edi = -1;
        }
        if(j2 == 420)
        {
            fah(i1, j1, k1, l1);
            super.aag.hcn(38);
            super.aag.hdj(i1 + dni);
            super.aag.hdj(j1 + dnj);
            super.aag.hdl();
        }
        if(j2 == 2400)
        {
            fah(i1, j1, k1, l1);
            super.aag.hcn(172);
            super.aag.hdj(i1 + dni);
            super.aag.hdj(j1 + dnj);
            super.aag.hdl();
        }
        if(j2 == 3400)
            fdj(e.ajn[k1], 3);
        if(j2 == 600)
        {
            super.aag.hcn(166);
            super.aag.hdj(k1);
            super.aag.hdj(l1);
            super.aag.hdl();
            dil = -1;
        }
        if(j2 == 610)
        {
            super.aag.hcn(235);
            super.aag.hdj(k1);
            super.aag.hdj(l1);
            super.aag.hdl();
            edi = -1;
        }
        if(j2 == 620)
        {
            super.aag.hcn(40);
            super.aag.hdj(k1);
            super.aag.hdl();
        }
        if(j2 == 630)
        {
            super.aag.hcn(199);
            super.aag.hdj(k1);
            super.aag.hdl();
        }
        if(j2 == 640)
        {
            super.aag.hcn(24);
            super.aag.hdj(k1);
            super.aag.hdl();
        }
        if(j2 == 650)
        {
            edi = k1;
            egf = 0;
            edj = e.aib[edf[edi]];
	    System.out.println("useitem: " + k1);
        }
        if(j2 == 660)
        {
            super.aag.hcn(123);
            super.aag.hdj(k1);
            super.aag.hdl();
            edi = -1;
            egf = 0;
            fdj("Dropping " + e.aib[edf[k1]], 4);
	    System.out.println("dropitem: " + k1);
        }
        if(j2 == 3600)
            fdj(e.aic[k1], 3);
        if(j2 == 700)
        {
            int k2 = (i1 - 64) / ehd;
            int k4 = (j1 - 64) / ehd;
            fbk(djd, dje, k2, k4, true);
            super.aag.hcn(10);
            super.aag.hdj(k1);
            super.aag.hdj(l1);
            super.aag.hdl();
            dil = -1;
        }
        if(j2 == 710)
        {
            int l2 = (i1 - 64) / ehd;
            int l4 = (j1 - 64) / ehd;
            fbk(djd, dje, l2, l4, true);
            super.aag.hcn(143);
            super.aag.hdj(k1);
            super.aag.hdj(l1);
            super.aag.hdl();
            edi = -1;
        }
        if(j2 == 720)
        {
            int i3 = (i1 - 64) / ehd;
            int i5 = (j1 - 64) / ehd;
            fbk(djd, dje, i3, i5, true);
            super.aag.hcn(159);
            super.aag.hdj(k1);
            super.aag.hdl();
        }
        if(j2 == 725)
        {
            int j3 = (i1 - 64) / ehd;
            int j5 = (j1 - 64) / ehd;
            fbk(djd, dje, j3, j5, true);
            super.aag.hcn(89);
            super.aag.hdj(k1);
            super.aag.hdl();
        }
        if(j2 == 715 || j2 == 2715)
        {
            int k3 = (i1 - 64) / ehd;
            int k5 = (j1 - 64) / ehd;
            fbk(djd, dje, k3, k5, true);
            super.aag.hcn(118);
            super.aag.hdj(k1);
            super.aag.hdl();
        }
        if(j2 == 3700)
            fdj(e.ahe[k1], 3);
        if(j2 == 800)
        {
            int l3 = (i1 - 64) / ehd;
            int l5 = (j1 - 64) / ehd;
            fbk(djd, dje, l3, l5, true);
            super.aag.hcn(56);
            super.aag.hdj(k1);
            super.aag.hdj(l1);
            super.aag.hdl();
            dil = -1;
        }
        if(j2 == 810)
        {
            int i4 = (i1 - 64) / ehd;
            int i6 = (j1 - 64) / ehd;
            fbk(djd, dje, i4, i6, true);
            super.aag.hcn(11);
            super.aag.hdj(k1);
            super.aag.hdj(l1);
            super.aag.hdl();
            edi = -1;
        }
        if(j2 == 805 || j2 == 2805)
        {
            int j4 = (i1 - 64) / ehd;
            int j6 = (j1 - 64) / ehd;
            fbk(djd, dje, j4, j6, true);
            super.aag.hcn(124);
            super.aag.hdj(k1);
            super.aag.hdl();
        }
        if(j2 == 2806)
        {
            super.aag.hcn(217);
            super.aag.hdj(k1);
            super.aag.hdl();
        }
        if(j2 == 2810)
        {
            super.aag.hcn(62);
            super.aag.hdj(k1);
            super.aag.hdl();
        }
        if(j2 == 2820)
        {
            super.aag.hcn(91);
            super.aag.hdj(k1);
            super.aag.hdl();
        }
        if(j2 == 900)
        {
            fbk(djd, dje, i1, j1, true);
            super.aag.hcn(201);
            super.aag.hdj(i1 + dni);
            super.aag.hdj(j1 + dnj);
            super.aag.hdj(k1);
            super.aag.hdl();
            dil = -1;
        }
        if(j2 == 920)
        {
            fbk(djd, dje, i1, j1, false);
            if(emb == -24)
                emb = 24;
        }
        if(j2 == 1000)
        {
            super.aag.hcn(44);
            super.aag.hdj(k1);
            super.aag.hdl();
            dil = -1;
        }
        if(j2 == 4000)
        {
            edi = -1;
            dil = -1;
        }
    }

    protected final void add()
    {
        deg = 0;
        ecf = 0;
        ehe = 0;
        ehb = 0;
    }

    private final void emh()
    {
        elc = 0;
        int l = 135;
        for(int i1 = 0; i1 < 12; i1++)
        {
            if(super.fke > 66 && super.fke < 446 && super.fkf >= l - 12 && super.fkf < l + 3)
                elc = i1 + 1;
            l += 14;
        }

        if(dnl != 0 && elc != 0)
        {
            dnl = 0;
            dmh = 2;
            super.fkl = "";
            super.fkm = "";
            return;
        }
        l += 15;
        if(dnl != 0)
        {
            dnl = 0;
            if(super.fke < 56 || super.fkf < 35 || super.fke > 456 || super.fkf > 325)
            {
                dmh = 0;
                return;
            }
            if(super.fke > 66 && super.fke < 446 && super.fkf >= l - 15 && super.fkf < l + 5)
            {
                dmh = 0;
                return;
            }
        }
        dnb.cba(56, 35, 400, 290, 0);
        dnb.cbb(56, 35, 400, 290, 0xffffff);
        l = 50;
        dnb.cdl("This form is for reporting players who are breaking our rules", 256, l, 1, 0xffffff);
        l += 15;
        dnb.cdl("Using it sends a snapshot of the last 60 secs of activity to us", 256, l, 1, 0xffffff);
        l += 15;
        dnb.cdl("If you misuse this form, you will be banned.", 256, l, 1, 0xff8000);
        l += 15;
        l += 10;
        dnb.cdl("First indicate which of our 12 rules is being broken. For a detailed", 256, l, 1, 0xffff00);
        l += 15;
        dnb.cdl("explanation of each rule please read the manual on our website.", 256, l, 1, 0xffff00);
        l += 15;
        int j1;
        if(elc == 1)
        {
            dnb.cbb(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        dnb.cdl("1: Offensive language", 256, l, 1, j1);
        l += 14;
        if(elc == 2)
        {
            dnb.cbb(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        dnb.cdl("2: Item scamming", 256, l, 1, j1);
        l += 14;
        if(elc == 3)
        {
            dnb.cbb(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        dnb.cdl("3: Password scamming", 256, l, 1, j1);
        l += 14;
        if(elc == 4)
        {
            dnb.cbb(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        dnb.cdl("4: Bug abuse", 256, l, 1, j1);
        l += 14;
        if(elc == 5)
        {
            dnb.cbb(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        dnb.cdl("5: Jagex Staff impersonation", 256, l, 1, j1);
        l += 14;
        if(elc == 6)
																																				//rstyrant - Made and created by at rstyrant.com
        {
            dnb.cbb(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        dnb.cdl("6: Account sharing/trading", 256, l, 1, j1);
        l += 14;
        if(elc == 7)
        {
            dnb.cbb(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        dnb.cdl("7: Macroing", 256, l, 1, j1);
        l += 14;
        if(elc == 8)
        {
            dnb.cbb(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        dnb.cdl("8: Mutiple logging in", 256, l, 1, j1);
        l += 14;
        if(elc == 9)
        {
            dnb.cbb(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        dnb.cdl("9: Encouraging others to break rules", 256, l, 1, j1);
        l += 14;
        if(elc == 10)
        {
            dnb.cbb(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        dnb.cdl("10: Misuse of customer support", 256, l, 1, j1);
        l += 14;
        if(elc == 11)
        {
            dnb.cbb(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        dnb.cdl("11: Advertising / website", 256, l, 1, j1);
        l += 14;
        if(elc == 12)
        {
            dnb.cbb(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        dnb.cdl("12: Real world item trading", 256, l, 1, j1);
        l += 14;
        l += 15;
        j1 = 0xffffff;
        if(super.fke > 196 && super.fke < 316 && super.fkf > l - 15 && super.fkf < l + 5)
            j1 = 0xffff00;
        dnb.cdl("Click here to cancel", 256, l, 1, j1);
    }

    private final void emi()
    {
        dnh.gif = fcb("maps" + w.cfa + ".jag", "map", 70);
        if(egi)
            dnh.gil = fcb("maps" + w.cfa + ".mem", "members map", 75);
        dnh.gie = fcb("land" + w.cfa + ".jag", "landscape", 80);
        if(egi)
            dnh.gik = fcb("land" + w.cfa + ".mem", "members landscape", 85);
    }

    private final void emj(int l, String s1)
    {
        int i1 = ekm[l];
        int j1 = ekn[l];
        int k1 = i1 - djc.gmh / 128;
        int l1 = j1 - djc.gmi / 128;
        byte byte0 = 7;
        if(i1 >= 0 && j1 >= 0 && i1 < 96 && j1 < 96 && k1 > -byte0 && k1 < byte0 && l1 > -byte0 && l1 < byte0)
        {
            ejg.bgn(dik[l]);
            int i2 = e.anj(s1);
            i j2 = edb[i2].cnj();
            ejg.bgm(j2);
            j2.cme(true, 48, 48, -50, -10, -50);
            j2.cnl(dik[l]);
            j2.chk = l;
            dik[l] = j2;
        }
    }

    final void emk(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6)
    {
        f f1 = deh[arg4];
        if(f1.hab == 255)
            return;
        int l = f1.gml + (dkg + 16) / 32 & 7;
        boolean flag = false;
        int i1 = l;
        if(i1 == 5)
        {
            i1 = 3;
            flag = true;
        } else
        if(i1 == 6)
        {
            i1 = 2;
            flag = true;
        } else
        if(i1 == 7)
        {
            i1 = 1;
            flag = true;
        }
        int j1 = i1 * 3 + dhn[(f1.gmk / 6) % 4];
        if(f1.gml == 8)
        {
            i1 = 5;
            l = 2;
            flag = false;
            arg0 -= (5 * arg6) / 100;
            j1 = i1 * 3 + eme[(dng / 5) % 8];
        } else
        if(f1.gml == 9)
        {
            i1 = 5;
            l = 2;
            flag = true;
            arg0 += (5 * arg6) / 100;
            j1 = i1 * 3 + eab[(dng / 6) % 8];
        }
        for(int k1 = 0; k1 < 12; k1++)
        {
            int l1 = dgl[l][k1];
            int l2 = f1.gnd[l1] - 1;
            if(l2 >= 0)
            {
                int k3 = 0;
                int i4 = 0;
                int j4 = j1;
                if(flag && i1 >= 1 && i1 <= 3)
                    if(e.alk[l2] == 1)
                        j4 += 15;
                    else
                    if(l1 == 4 && i1 == 1)
                    {
                        k3 = -22;
                        i4 = -3;
                        j4 = i1 * 3 + dhn[(2 + f1.gmk / 6) % 4];
                    } else
                    if(l1 == 4 && i1 == 2)
                    {
                        k3 = 0;
                        i4 = -8;
                        j4 = i1 * 3 + dhn[(2 + f1.gmk / 6) % 4];
                    } else
                    if(l1 == 4 && i1 == 3)
                    {
                        k3 = 26;
                        i4 = -5;
                        j4 = i1 * 3 + dhn[(2 + f1.gmk / 6) % 4];
                    } else
                    if(l1 == 3 && i1 == 1)
                    {
                        k3 = 22;
                        i4 = 3;
                        j4 = i1 * 3 + dhn[(2 + f1.gmk / 6) % 4];
                    } else
                    if(l1 == 3 && i1 == 2)
                    {
                        k3 = 0;
                        i4 = 8;
                        j4 = i1 * 3 + dhn[(2 + f1.gmk / 6) % 4];
                    } else
                    if(l1 == 3 && i1 == 3)
                    {
                        k3 = -26;
                        i4 = 5;
                        j4 = i1 * 3 + dhn[(2 + f1.gmk / 6) % 4];
                    }
                if(i1 != 5 || e.alj[l2] == 1)
                {
                    int k4 = j4 + e.all[l2];
                    k3 = (k3 * arg2) / ((j) (dnb)).bmj[k4];
                    i4 = (i4 * arg3) / ((j) (dnb)).bmk[k4];
                    int l4 = (arg2 * ((j) (dnb)).bmj[k4]) / ((j) (dnb)).bmj[e.all[l2]];
                    k3 -= (l4 - arg2) / 2;
                    int i5 = e.alh[l2];
                    int j5 = dki[f1.hac];
                    if(i5 == 1)
                        i5 = eii[f1.gnn];
                    else
                    if(i5 == 2)
                        i5 = eid[f1.haa];
                    else
                    if(i5 == 3)
                        i5 = eid[f1.hab];
                    dnb.cdd(arg0 + k3, arg1 + i4, l4, arg3, k4, i5, j5, arg5, flag);
                }
            }
        }

        if(f1.gnf > 0)
        {
            eaf[egg] = dnb.cef(f1.gne, 1) / 2;
            if(eaf[egg] > 150)
                eaf[egg] = 150;
            eag[egg] = (dnb.cef(f1.gne, 1) / 300) * dnb.ced(1);
            ead[egg] = arg0 + arg2 / 2;
            eae[egg] = arg1;
            egh[egg++] = f1.gne;
        }
        if(f1.gnh > 0)
        {
            ebk[dib] = arg0 + arg2 / 2;
            ebl[dib] = arg1;
            dfi[dib] = arg6;
            dfj[dib++] = f1.gng;
        }
        if(f1.gml == 8 || f1.gml == 9 || f1.gnl != 0)
        {
            if(f1.gnl > 0)
            {
                int i2 = arg0;
                if(f1.gml == 8)
                    i2 -= (20 * arg6) / 100;
                else
                if(f1.gml == 9)
                    i2 += (20 * arg6) / 100;
                int i3 = (f1.gnj * 30) / f1.gnk;
                ekj[ejl] = i2 + arg2 / 2;
                ekk[ejl] = arg1;
                ekl[ejl++] = i3;
            }
            if(f1.gnl > 150)
            {
                int j2 = arg0;
                if(f1.gml == 8)
                    j2 -= (10 * arg6) / 100;
                else
                if(f1.gml == 9)
                    j2 += (10 * arg6) / 100;
                dnb.ccb((j2 + arg2 / 2) - 12, (arg1 + arg3 / 2) - 12, efh + 11);
                dnb.cdl(String.valueOf(f1.gni), (j2 + arg2 / 2) - 1, arg1 + arg3 / 2 + 5, 3, 0xffffff);
            }
        }
        if(f1.haj == 1 && f1.gnh == 0)
        {
            int k2 = arg5 + arg0 + arg2 / 2;
            if(f1.gml == 8)
                k2 -= (20 * arg6) / 100;
            else
            if(f1.gml == 9)
                k2 += (20 * arg6) / 100;
            int j3 = (16 * arg6) / 100;
            int l3 = (16 * arg6) / 100;
            dnb.ccc(k2 - j3 / 2, arg1 - l3 / 2 - (10 * arg6) / 100, j3, l3, efh + 13);
        }
    }

    private final void eml(int l, int i1, int j1)
    {
        if(j1 == 0)
        {
            fae(djd, dje, l, i1 - 1, l, i1, false, true);
            return;
        }
        if(j1 == 1)
        {
            fae(djd, dje, l - 1, i1, l, i1, false, true);
            return;
        } else
        {
            fae(djd, dje, l, i1, l, i1, true, true);
            return;
        }
    }

    private final void emm()
    {
        byte byte0 = 22;
        byte byte1 = 36;
        dnb.cba(byte0, byte1, 468, 16, 192);
        int l = 0x989898;
        dnb.cam(byte0, byte1 + 16, 468, 246, l, 160);
        dnb.cdl("Please confirm your duel with @yel@" + t.fnd(dif), byte0 + 234, byte1 + 12, 1, 0xffffff);
        dnb.cdl("Your stake:", byte0 + 117, byte1 + 30, 1, 0xffff00);
        for(int i1 = 0; i1 < eim; i1++)
        {
            String s1 = e.aib[ein[i1]];
            if(e.aig[ein[i1]] == 0)
                s1 = s1 + " x " + fdh(eja[i1]);
            dnb.cdl(s1, byte0 + 117, byte1 + 42 + i1 * 12, 1, 0xffffff);
        }

        if(eim == 0)
            dnb.cdl("Nothing!", byte0 + 117, byte1 + 42, 1, 0xffffff);
        dnb.cdl("Your opponent's stake:", byte0 + 351, byte1 + 30, 1, 0xffff00);
        for(int j1 = 0; j1 < efe; j1++)
        {
            String s2 = e.aib[eff[j1]];
            if(e.aig[eff[j1]] == 0)
                s2 = s2 + " x " + fdh(efg[j1]);
            dnb.cdl(s2, byte0 + 351, byte1 + 42 + j1 * 12, 1, 0xffffff);
        }

        if(efe == 0)
            dnb.cdl("Nothing!", byte0 + 351, byte1 + 42, 1, 0xffffff);
        if(ebm == 0)
            dnb.cdl("You can retreat from this duel", byte0 + 234, byte1 + 180, 1, 65280);
        else
            dnb.cdl("No retreat is possible!", byte0 + 234, byte1 + 180, 1, 0xff0000);
        if(ebn == 0)
            dnb.cdl("Magic may be used", byte0 + 234, byte1 + 192, 1, 65280);
        else
            dnb.cdl("Magic cannot be used", byte0 + 234, byte1 + 192, 1, 0xff0000);
        if(eca == 0)
            dnb.cdl("Prayer may be used", byte0 + 234, byte1 + 204, 1, 65280);
        else
            dnb.cdl("Prayer cannot be used", byte0 + 234, byte1 + 204, 1, 0xff0000);
        if(ecb == 0)
            dnb.cdl("Weapons may be used", byte0 + 234, byte1 + 216, 1, 65280);
        else
            dnb.cdl("Weapons cannot be used", byte0 + 234, byte1 + 216, 1, 0xff0000);
        dnb.cdl("If you are sure click 'Accept' to begin the duel", byte0 + 234, byte1 + 230, 1, 0xffffff);
        if(!ecm)
        {
            dnb.ccb((byte0 + 118) - 35, byte1 + 238, efh + 25);
            dnb.ccb((byte0 + 352) - 35, byte1 + 238, efh + 26);
        } else
        {
            dnb.cdl("Waiting for other player...", byte0 + 234, byte1 + 250, 1, 0xffff00);
        }
        if(dnl == 1)
        {
            if(super.fke < byte0 || super.fkf < byte1 || super.fke > byte0 + 468 || super.fkf > byte1 + 262)
            {
                ecl = false;
                super.aag.hcn(27);
                super.aag.hdl();
            }
            if(super.fke >= (byte0 + 118) - 35 && super.fke <= byte0 + 118 + 70 && super.fkf >= byte1 + 238 && super.fkf <= byte1 + 238 + 21)
            {
                ecm = true;
                super.aag.hcn(175);
                super.aag.hdl();
            }
            if(super.fke >= (byte0 + 352) - 35 && super.fke <= byte0 + 353 + 70 && super.fkf >= byte1 + 238 && super.fkf <= byte1 + 238 + 21)
            {
                ecl = false;
                super.aag.hcn(43);
                super.aag.hdl();
            }
            dnl = 0;
        }
    }

    private final void emn()
    {
        ehe = 0;
        ecf = 0;
        ekc = "cristalskull";
        ekd = "pacbell";
        dja = "Please enter a username:";
        djb = "*" + ekc + "*";
        dgm = 0;
        ebb = 0;
    }

    protected final void ena()
    {
        aca();
        fbe();
        if(dic != null)
            dic.ggl();
    }

    protected final Socket enb(String arg0, int arg1)
        throws IOException
    {
        if(link.fni != null)
        {
            Socket socket = link.gag(arg1);
            if(socket == null)
                throw new IOException();
            else
                return socket;
        }
        Socket socket1;
        if(fld())
            socket1 = new Socket(InetAddress.getByName(getCodeBase().getHost()), arg1);
        else
            socket1 = new Socket(InetAddress.getByName(arg0), arg1);
        socket1.setSoTimeout(30000);
        socket1.setTcpNoDelay(true);
        return socket1;
    }

    private final void enc(boolean arg0)
    {
        int l = ((j) (dnb)).blg - 248;
        dnb.ccb(l, 3, efh + 1);
        for(int i1 = 0; i1 < ebe; i1++)
        {
            int j1 = l + (i1 % 5) * 49;
            int l1 = 36 + (i1 / 5) * 34;
            if(i1 < ede && edh[i1] == 1)
                dnb.cam(j1, l1, 49, 34, 0xff0000, 128);
            else
                dnb.cam(j1, l1, 49, 34, j.cbh(181, 181, 181), 128);
            if(i1 < ede)
            {
                dnb.cdd(j1, l1, 48, 32, efj + e.aie[edf[i1]], e.aij[edf[i1]], 0, 0, false);
                if(e.aig[edf[i1]] == 0)
                    dnb.cdn(String.valueOf(edg[i1]), j1 + 1, l1 + 10, 1, 0xffff00);
            }
        }

        for(int k1 = 1; k1 <= 4; k1++)
            dnb.cbd(l + k1 * 49, 36, (ebe / 5) * 34, 0);

        for(int i2 = 1; i2 <= ebe / 5 - 1; i2++)
            dnb.cbc(l, 36 + i2 * 34, 245, 0);

        if(!arg0)
            return;
        l = super.fke - (((j) (dnb)).blg - 248);
        int j2 = super.fkf - 36;
        if(l >= 0 && j2 >= 0 && l < 248 && j2 < (ebe / 5) * 34)
        {
            int k2 = l / 49 + (j2 / 34) * 5;
            if(k2 < ede)
            {
                int l2 = edf[k2];
                if(dil >= 0)
                {
                    if(e.amd[dil] == 3)
                    {
                        dem[ejf] = "Cast " + e.akj[dil] + " on";
                        ejm[ejf] = "@lre@" + e.aib[l2];
                        dga[ejf] = 600;
                        djk[ejf] = k2;
                        djl[ejf] = dil;
                        ejf++;
                        return;
                    }
                } else
                {
                    if(edi >= 0)
                    {
                        dem[ejf] = "Use " + edj + " with";
                        ejm[ejf] = "@lre@" + e.aib[l2];
                        dga[ejf] = 610;
                        djk[ejf] = k2;
                        djl[ejf] = edi;
                        ejf++;
                        return;
                    }
                    if(edh[k2] == 1)
                    {
                        dem[ejf] = "Remove";
                        ejm[ejf] = "@lre@" + e.aib[l2];
                        dga[ejf] = 620;
                        djk[ejf] = k2;
                        ejf++;
                    } else
                    if(e.aii[l2] != 0)
                    {
                        if((e.aii[l2] & 0x18) != 0)
                            dem[ejf] = "Wield";
                        else
                            dem[ejf] = "Wear";
                        ejm[ejf] = "@lre@" + e.aib[l2];
                        dga[ejf] = 630;
                        djk[ejf] = k2;
                        ejf++;
                    }
                    if(!e.aid[l2].equals(""))
                    {
                        dem[ejf] = e.aid[l2];
                        ejm[ejf] = "@lre@" + e.aib[l2];
                        dga[ejf] = 640;
                        djk[ejf] = k2;
                        ejf++;
                    }
                    dem[ejf] = "Use";
                    ejm[ejf] = "@lre@" + e.aib[l2];
                    dga[ejf] = 650;
                    djk[ejf] = k2;
                    ejf++;
                    dem[ejf] = "Drop";
                    ejm[ejf] = "@lre@" + e.aib[l2];
                    dga[ejf] = 660;
                    djk[ejf] = k2;
                    ejf++;
                    dem[ejf] = "Examine";
                    ejm[ejf] = "@lre@" + e.aib[l2];
                    dga[ejf] = 3600;
                    djk[ejf] = l2;
                    ejf++;
                }
            }
        }
    }

    private final void end()
    {
        int l = 0;
        byte byte0 = 50;
        byte byte1 = 50;
        dnh.gjj(byte0 * 48 + 23, byte1 * 48 + 23, l);
        dnh.glg(edb);
        char c1 = '\u2600';
        char c2 = '\u1900';
        char c3 = '\u044C';
        char c4 = '\u0378';
        ejg.bbg = 4100;
        ejg.bbh = 4100;
        ejg.bbi = 1;
        ejg.bbj = 4000;
        ejg.bin(c1, -dnh.gjf(c1, c2), c2, 912, c4, 0, c3 * 2);
        ejg.bib();
        dnb.cbf();
        dnb.cbf();
        dnb.cba(0, 0, 512, 6, 0);
        for(int i1 = 6; i1 >= 1; i1--)
            dnb.cbg(0, i1, 0, i1, 512, 8);

        dnb.cba(0, 194, 512, 20, 0);
        for(int j1 = 6; j1 >= 1; j1--)
            dnb.cbg(0, j1, 0, 194 - j1, 512, 8);

        dnb.ccb(15, 15, efh + 10);
        dnb.cca(efn, 0, 0, 512, 200);
        dnb.cbl(efn);
        c1 = '\u2400';
        c2 = '\u2400';
        c3 = '\u044C';
        c4 = '\u0378';
        ejg.bbg = 4100;
        ejg.bbh = 4100;
        ejg.bbi = 1;
        ejg.bbj = 4000;
        ejg.bin(c1, -dnh.gjf(c1, c2), c2, 912, c4, 0, c3 * 2);
        ejg.bib();
        dnb.cbf();
        dnb.cbf();
        dnb.cba(0, 0, 512, 6, 0);
        for(int k1 = 6; k1 >= 1; k1--)
            dnb.cbg(0, k1, 0, k1, 512, 8);

        dnb.cba(0, 194, 512, 20, 0);
        for(int l1 = 6; l1 >= 1; l1--)
            dnb.cbg(0, l1, 0, 194 - l1, 512, 8);

        dnb.ccb(15, 15, efh + 10);
        dnb.cca(efn + 1, 0, 0, 512, 200);
        dnb.cbl(efn + 1);
        for(int i2 = 0; i2 < 64; i2++)
        {
            ejg.bgn(dnh.gih[0][i2]);
            ejg.bgn(dnh.gim[1][i2]);
            ejg.bgn(dnh.gih[1][i2]);
            ejg.bgn(dnh.gim[2][i2]);
            ejg.bgn(dnh.gih[2][i2]);
        }

        c1 = '\u2B80';
        c2 = '\u2880';
        c3 = '\u01F4';
        c4 = '\u0178';
        ejg.bbg = 4100;
        ejg.bbh = 4100;
        ejg.bbi = 1;
        ejg.bbj = 4000;
        ejg.bin(c1, -dnh.gjf(c1, c2), c2, 912, c4, 0, c3 * 2);
        ejg.bib();
        dnb.cbf();
        dnb.cbf();
        dnb.cba(0, 0, 512, 6, 0);
        for(int j2 = 6; j2 >= 1; j2--)
            dnb.cbg(0, j2, 0, j2, 512, 8);

        dnb.cba(0, 194, 512, 20, 0);
        for(int k2 = 6; k2 >= 1; k2--)
            dnb.cbg(0, k2, 0, 194, 512, 8);

        dnb.ccb(15, 15, efh + 10);
        dnb.cca(efh + 10, 0, 0, 512, 200);
        dnb.cbl(efh + 10);
    }

    protected final void adf(int arg0, int arg1, byte arg2[])
    {
        try
        {
            if(arg0 == 141)
            {
                dgn = dgm;
                for(int l = 0; l < dgn; l++)
                    edk[l] = deh[l];

                int l7 = 8;
                djd = t.fmn(arg2, l7, 11);
                l7 += 11;
                dje = t.fmn(arg2, l7, 13);
                l7 += 13;
                int i14 = t.fmn(arg2, l7, 4);
                l7 += 4;
                boolean flag1 = fdg(djd, dje);
                djd -= dni;
                dje -= dnj;
                int i23 = djd * ehd + 64;
                int i26 = dje * ehd + 64;
                if(flag1)
                {
                    djc.gna = 0;
                    djc.gmn = 0;
                    djc.gmh = djc.gnb[0] = i23;
                    djc.gmi = djc.gnc[0] = i26;
                }
                dgm = 0;
                djc = fbj(djf, i23, i26, i14);
                int j29 = t.fmn(arg2, l7, 8);
                l7 += 8;
                for(int i34 = 0; i34 < j29; i34++)
                {
                    f f4 = edk[i34 + 1];
                    int i40 = t.fmn(arg2, l7, 1);
                    l7++;
                    if(i40 != 0)
                    {
                        int i42 = t.fmn(arg2, l7, 1);
                        l7++;
                        if(i42 == 0)
                        {
                            int j43 = t.fmn(arg2, l7, 3);
                            l7 += 3;
                            int j44 = f4.gna;
                            int i45 = f4.gnb[j44];
                            int j45 = f4.gnc[j44];
                            if(j43 == 2 || j43 == 1 || j43 == 3)
                                i45 += ehd;
                            if(j43 == 6 || j43 == 5 || j43 == 7)
                                i45 -= ehd;
                            if(j43 == 4 || j43 == 3 || j43 == 5)
                                j45 += ehd;
                            if(j43 == 0 || j43 == 1 || j43 == 7)
                                j45 -= ehd;
                            f4.gmm = j43;
                            f4.gna = j44 = (j44 + 1) % 10;
                            f4.gnb[j44] = i45;
                            f4.gnc[j44] = j45;
                        } else
                        {
                            int k43 = t.fmn(arg2, l7, 4);
                            if((k43 & 0xc) == 12)
                            {
                                l7 += 2;
                                continue;
                            }
                            f4.gmm = t.fmn(arg2, l7, 4);
                            l7 += 4;
                        }
                    }
                    deh[dgm++] = f4;
                }

                int k37 = 0;
                while(l7 + 24 < arg1 * 8) 
                {
                    int j40 = t.fmn(arg2, l7, 11);
                    l7 += 11;
                    int j42 = t.fmn(arg2, l7, 5);
                    l7 += 5;
                    if(j42 > 15)
                        j42 -= 32;
                    int l43 = t.fmn(arg2, l7, 5);
                    l7 += 5;
                    if(l43 > 15)
                        l43 -= 32;
                    int j14 = t.fmn(arg2, l7, 4);
                    l7 += 4;
                    int k44 = t.fmn(arg2, l7, 1);
                    l7++;
                    int j23 = (djd + j42) * ehd + 64;
                    int j26 = (dje + l43) * ehd + 64;
                    fbj(j40, j23, j26, j14);
                    if(k44 == 0)
                        ece[k37++] = j40;
                }
                if(k37 > 0)
                {
                    super.aag.hcn(241);
                    super.aag.hdj(k37);
                    for(int k40 = 0; k40 < k37; k40++)
                    {
                        f f5 = dhb[ece[k40]];
                        super.aag.hdj(f5.gmf);
                        super.aag.hdj(f5.gmg);
                    }

                    super.aag.hdl();
                    k37 = 0;
                }
                return;
            }
            if(arg0 == 172)
            {
                for(int i1 = 1; i1 < arg1;)
                    if(t.fmh(arg2[i1]) == 255)
                    {
                        int i8 = 0;
                        int k14 = djd + arg2[i1 + 1] >> 3;
                        int j19 = dje + arg2[i1 + 2] >> 3;
                        i1 += 3;
                        for(int k23 = 0; k23 < dhd; k23++)
                        {
                            int k26 = (dml[k23] >> 3) - k14;
                            int k29 = (dmm[k23] >> 3) - j19;
                            if(k26 != 0 || k29 != 0)
                            {
                                if(k23 != i8)
                                {
                                    dml[i8] = dml[k23];
                                    dmm[i8] = dmm[k23];
                                    dmn[i8] = dmn[k23];
                                    dna[i8] = dna[k23];
                                }
                                i8++;
                            }
                        }

                        dhd = i8;
                    } else
                    {
                        int j8 = t.fmi(arg2, i1);
                        i1 += 2;
                        int l14 = djd + arg2[i1++];
                        int k19 = dje + arg2[i1++];
                        if((j8 & 0x8000) == 0)
                        {
                            dml[dhd] = l14;
                            dmm[dhd] = k19;
                            dmn[dhd] = j8;
                            dna[dhd] = 0;
                            for(int l23 = 0; l23 < efd; l23++)
                            {
                                if(ekm[l23] != l14 || ekn[l23] != k19)
                                    continue;
                                dna[dhd] = e.amk[ela[l23]];
                                break;
                            }

                            dhd++;
                        } else
                        {
                            j8 &= 0x7fff;
                            int i24 = 0;
                            for(int l26 = 0; l26 < dhd; l26++)
                                if(dml[l26] != l14 || dmm[l26] != k19 || dmn[l26] != j8)
                                {
                                    if(l26 != i24)
                                    {
                                        dml[i24] = dml[l26];
                                        dmm[i24] = dmm[l26];
                                        dmn[i24] = dmn[l26];
                                        dna[i24] = dna[l26];
                                    }
                                    i24++;
                                } else
                                {
                                    j8 = -123;
                                }

                            dhd = i24;
                        }
                    }

                return;
            }
            if(arg0 == 158)
            {
                for(int j1 = 1; j1 < arg1;)
                    if(t.fmh(arg2[j1]) == 255)
                    {
                        int k8 = 0;
                        int i15 = djd + arg2[j1 + 1] >> 3;
                        int l19 = dje + arg2[j1 + 2] >> 3;
                        j1 += 3;
                        for(int j24 = 0; j24 < efd; j24++)
                        {
                            int i27 = (ekm[j24] >> 3) - i15;
                            int l29 = (ekn[j24] >> 3) - l19;
                            if(i27 != 0 || l29 != 0)
                            {
                                if(j24 != k8)
                                {
                                    dik[k8] = dik[j24];
                                    dik[k8].chk = k8;
                                    ekm[k8] = ekm[j24];
                                    ekn[k8] = ekn[j24];
                                    ela[k8] = ela[j24];
                                    elb[k8] = elb[j24];
                                }
                                k8++;
                            } else
                            {
                                ejg.bgn(dik[j24]);
                                dnh.gkf(ekm[j24], ekn[j24], ela[j24]);
                            }
                        }

                        efd = k8;
                    } else
                    {
                        int l8 = t.fmi(arg2, j1);
                        j1 += 2;
                        int j15 = djd + arg2[j1++];
                        int i20 = dje + arg2[j1++];
                        int k24 = 0;
                        for(int j27 = 0; j27 < efd; j27++)
                            if(ekm[j27] != j15 || ekn[j27] != i20)
                            {
                                if(j27 != k24)
                                {
                                    dik[k24] = dik[j27];
                                    dik[k24].chk = k24;
                                    ekm[k24] = ekm[j27];
                                    ekn[k24] = ekn[j27];
                                    ela[k24] = ela[j27];
                                    elb[k24] = elb[j27];
                                }
                                k24++;
                            } else
                            {
                                ejg.bgn(dik[j27]);
                                dnh.gkf(ekm[j27], ekn[j27], ela[j27]);
                            }

                        efd = k24;
                        if(l8 != 60000)
                        {
                            int i30 = dnh.gke(j15, i20);
                            int j34;
                            int l37;
                            if(i30 == 0 || i30 == 4)
                            {
                                j34 = e.amh[l8];
                                l37 = e.ami[l8];
                            } else
                            {
                                l37 = e.amh[l8];
                                j34 = e.ami[l8];
                            }
                            int l40 = ((j15 + j15 + j34) * ehd) / 2;
                            int k42 = ((i20 + i20 + l37) * ehd) / 2;
                            int i44 = e.amg[l8];
                            i l44 = edb[i44].cnj();
                            ejg.bgm(l44);
                            l44.chk = efd;
                            l44.cmi(0, i30 * 32, 0);
                            l44.cmk(l40, -dnh.gjf(l40, k42), k42);
                            l44.cme(true, 48, 48, -50, -10, -50);
                            dnh.gla(j15, i20, l8);
                            if(l8 == 74)
                                l44.cmk(0, -480, 0);
                            ekm[efd] = j15;
                            ekn[efd] = i20;
                            ela[efd] = l8;
                            elb[efd] = i30;
                            dik[efd++] = l44;
                        }
                    }

                return;
            }
            if(arg0 == 37)
            {
                int k1 = 1;
                ede = arg2[k1++] & 0xff;
                for(int i9 = 0; i9 < ede; i9++)
                {
                    int k15 = t.fmi(arg2, k1);
                    k1 += 2;
                    edf[i9] = k15 & 0x7fff;
                    edh[i9] = k15 / 32768;
                    if(e.aig[k15 & 0x7fff] == 0)
                    {
                        edg[i9] = t.fmm(arg2, k1);
                        if(edg[i9] >= 128)
                            k1 += 4;
                        else
                            k1++;
                    } else
                    {
                        edg[i9] = 1;
                    }
                }

                return;
            }
            if(arg0 == 183)
            {
                int l1 = t.fmi(arg2, 1);
                int j9 = 3;
                for(int l15 = 0; l15 < l1; l15++)
                {
                    int j20 = t.fmi(arg2, j9);
                    j9 += 2;
                    f f1 = dhb[j20];
                    byte byte6 = arg2[j9];
                    j9++;
                    if(byte6 == 0)
                    {
                        int j30 = t.fmi(arg2, j9);
                        j9 += 2;
                        if(f1 != null)
                        {
                            f1.gnh = 150;
                            f1.gng = j30;
                        }
                    } else
                    if(byte6 == 1)
                    {
                        byte byte7 = arg2[j9];
                        j9++;
                        if(f1 != null)
                        {
                            String s3 = u.fgd(v.cej(arg2, j9, byte7));
                            boolean flag3 = false;
                            for(int i41 = 0; i41 < super.aan; i41++)
                                if(super.aba[i41] == f1.gmd)
                                    flag3 = true;

                            if(!flag3)
                            {
                                f1.gnf = 150;
                                f1.gne = s3;
                                fdj(f1.gme + ": " + f1.gne, 2);
                            }
                        }
                        j9 += byte7;
                    } else
                    if(byte6 == 2)
                    {
                        int k30 = t.fmh(arg2[j9]);
                        j9++;
                        int k34 = t.fmh(arg2[j9]);
                        j9++;
                        int i38 = t.fmh(arg2[j9]);
                        j9++;
                        if(f1 != null)
                        {
                            f1.gni = k30;
                            f1.gnj = k34;
                            f1.gnk = i38;
                            f1.gnl = 200;
                            if(f1 == djc)
                            {
                                dfk[3] = k34;
                                dmf[3] = i38;
                                djj = false;
                                ecc = false;
                            }
                        }
                    } else
                    if(byte6 == 3)
                    {
                        int l30 = t.fmi(arg2, j9);
                        j9 += 2;
                        int l34 = t.fmi(arg2, j9);
                        j9 += 2;
                        if(f1 != null)
                        {
                            f1.had = l30;
                            f1.haf = l34;
                            f1.hae = -1;
                            f1.hag = eic;
                        }
                    } else
                    if(byte6 == 4)
                    {
                        int i31 = t.fmi(arg2, j9);
                        j9 += 2;
                        int i35 = t.fmi(arg2, j9);
                        j9 += 2;
                        if(f1 != null)
                        {
                            f1.had = i31;
                            f1.hae = i35;
                            f1.haf = -1;
                            f1.hag = eic;
                        }
                    } else
                    if(byte6 == 5)
                    {
                        if(f1 != null)
                        {
                            f1.gmg = t.fmi(arg2, j9);
                            j9 += 2;
                            f1.gmd = t.fmk(arg2, j9);
                            j9 += 8;
                            f1.gme = t.fnd(f1.gmd);
                            int j31 = t.fmh(arg2[j9]);
                            j9++;
                            for(int j35 = 0; j35 < j31; j35++)
                            {
                                f1.gnd[j35] = t.fmh(arg2[j9]);
                                j9++;
                            }

                            for(int j38 = j31; j38 < 12; j38++)
                                f1.gnd[j38] = 0;

                            f1.gnn = arg2[j9++] & 0xff;
                            f1.haa = arg2[j9++] & 0xff;
                            f1.hab = arg2[j9++] & 0xff;
                            f1.hac = arg2[j9++] & 0xff;
                            f1.gnm = arg2[j9++] & 0xff;
                            f1.haj = arg2[j9++] & 0xff;
                        } else
                        {
                            j9 += 14;
                            int k31 = t.fmh(arg2[j9]);
                            j9 += k31 + 1;
                        }
                    } else
                    if(byte6 == 6)
                    {
                        byte byte8 = arg2[j9];
                        j9++;
                        if(f1 != null)
                        {
                            String s4 = v.cej(arg2, j9, byte8);
                            f1.gnf = 150;
                            f1.gne = s4;
                            if(f1 == djc)
                                fdj(f1.gme + ": " + f1.gne, 5);
                        }
                        j9 += byte8;
                    }
                }

                return;
            }
            if(arg0 == 29)
            {
                for(int i2 = 1; i2 < arg1;)
                    if(t.fmh(arg2[i2]) == 255)
                    {
                        int k9 = 0;
                        int i16 = djd + arg2[i2 + 1] >> 3;
                        int k20 = dje + arg2[i2 + 2] >> 3;
                        i2 += 3;
                        for(int l24 = 0; l24 < ehc; l24++)
                        {
                            int k27 = (dhg[l24] >> 3) - i16;
                            int l31 = (dhh[l24] >> 3) - k20;
                            if(k27 != 0 || l31 != 0)
                            {
                                if(l24 != k9)
                                {
                                    did[k9] = did[l24];
                                    did[k9].chk = k9 + 10000;
                                    dhg[k9] = dhg[l24];
                                    dhh[k9] = dhh[l24];
                                    ecn[k9] = ecn[l24];
                                    eda[k9] = eda[l24];
                                }
                                k9++;
                            } else
                            {
                                ejg.bgn(did[l24]);
                                dnh.gkb(dhg[l24], dhh[l24], ecn[l24], eda[l24]);
                            }
                        }

                        ehc = k9;
                    } else
                    {
                        int l9 = t.fmi(arg2, i2);
                        i2 += 2;
                        int j16 = djd + arg2[i2++];
                        int l20 = dje + arg2[i2++];
                        byte byte5 = arg2[i2++];
                        int l27 = 0;
                        for(int i32 = 0; i32 < ehc; i32++)
                            if(dhg[i32] != j16 || dhh[i32] != l20 || ecn[i32] != byte5)
                            {
                                if(i32 != l27)
                                {
                                    did[l27] = did[i32];
                                    did[l27].chk = l27 + 10000;
                                    dhg[l27] = dhg[i32];
                                    dhh[l27] = dhh[i32];
                                    ecn[l27] = ecn[i32];
                                    eda[l27] = eda[i32];
                                }
                                l27++;
                            } else
                            {
                                ejg.bgn(did[i32]);
                                dnh.gkb(dhg[i32], dhh[i32], ecn[i32], eda[i32]);
                            }

                        ehc = l27;
                        if(l9 != 65535)
                        {
                            dnh.gkc(j16, l20, byte5, l9);
                            i k35 = fdm(j16, l20, byte5, l9, ehc);
                            did[ehc] = k35;
                            dhg[ehc] = j16;
                            dhh[ehc] = l20;
                            eda[ehc] = l9;
                            ecn[ehc++] = byte5;
                        }
                    }

                return;
            }
            if(arg0 == 41)
            {
                ebc = ebb;
                ebb = 0;
                for(int j2 = 0; j2 < ebc; j2++)
                    edc[j2] = dgf[j2];

                int i10 = 8;
                int k16 = t.fmn(arg2, i10, 8);
                i10 += 8;
                for(int i21 = 0; i21 < k16; i21++)
                {
                    f f2 = edc[i21];
                    int i28 = t.fmn(arg2, i10, 1);
                    i10++;
                    if(i28 != 0)
                    {
                        int j32 = t.fmn(arg2, i10, 1);
                        i10++;
                        if(j32 == 0)
                        {
                            int l35 = t.fmn(arg2, i10, 3);
                            i10 += 3;
                            int k38 = f2.gna;
                            int j41 = f2.gnb[k38];
                            int l42 = f2.gnc[k38];
                            if(l35 == 2 || l35 == 1 || l35 == 3)
																																				//rstyrant - Made and created by at rstyrant.com
                                j41 += ehd;
                            if(l35 == 6 || l35 == 5 || l35 == 7)
                                j41 -= ehd;
                            if(l35 == 4 || l35 == 3 || l35 == 5)
                                l42 += ehd;
                            if(l35 == 0 || l35 == 1 || l35 == 7)
                                l42 -= ehd;
                            f2.gmm = l35;
                            f2.gna = k38 = (k38 + 1) % 10;
                            f2.gnb[k38] = j41;
                            f2.gnc[k38] = l42;
                        } else
                        {
                            int i36 = t.fmn(arg2, i10, 4);
                            if((i36 & 0xc) == 12)
                            {
                                i10 += 2;
                                continue;
                            }
                            f2.gmm = t.fmn(arg2, i10, 4);
                            i10 += 4;
                        }
                    }
                    dgf[ebb++] = f2;
                }

                while(i10 + 34 < arg1 * 8) 
                {
                    int i25 = t.fmn(arg2, i10, 12);
                    i10 += 12;
                    int j28 = t.fmn(arg2, i10, 5);
                    i10 += 5;
                    if(j28 > 15)
                        j28 -= 32;
                    int k32 = t.fmn(arg2, i10, 5);
                    i10 += 5;
                    if(k32 > 15)
                        k32 -= 32;
                    int j36 = t.fmn(arg2, i10, 4);
                    i10 += 4;
                    int l38 = (djd + j28) * ehd + 64;
                    int k41 = (dje + k32) * ehd + 64;
                    int i43 = t.fmn(arg2, i10, 10);
                    i10 += 10;
                    if(i43 >= e.alg)
                        i43 = 24;
                    fea(i25, l38, k41, j36, i43);
                }
                return;
            }
            if(arg0 == 47)
            {
                int k2 = t.fmi(arg2, 1);
                int j10 = 3;
                for(int l16 = 0; l16 < k2; l16++)
                {
                    int j21 = t.fmi(arg2, j10);
                    j10 += 2;
                    f f3 = ele[j21];
                    int k28 = t.fmh(arg2[j10]);
                    j10++;
                    if(k28 == 1)
                    {
                        int l32 = t.fmi(arg2, j10);
                        j10 += 2;
                        byte byte9 = arg2[j10];
                        j10++;
                        if(f3 != null)
                        {
                            String s5 = v.cej(arg2, j10, byte9);
                            f3.gnf = 150;
                            f3.gne = s5;
                            if(l32 == djc.gmf)
                                fdj("@yel@" + e.ahd[f3.gmj] + ": " + f3.gne, 5);
                        }
                        j10 += byte9;
                    } else
                    if(k28 == 2)
                    {
                        int i33 = t.fmh(arg2[j10]);
                        j10++;
                        int k36 = t.fmh(arg2[j10]);
                        j10++;
                        int i39 = t.fmh(arg2[j10]);
                        j10++;
                        if(f3 != null)
                        {
                            f3.gni = i33;
                            f3.gnj = k36;
                            f3.gnk = i39;
                            f3.gnl = 200;
                        }
                    }
                }

                return;
            }
            if(arg0 == 117)
            {
                dck = true;
                int l2 = t.fmh(arg2[1]);
                egk = l2;
                int k10 = 2;
                for(int i17 = 0; i17 < l2; i17++)
                {
                    int k21 = t.fmh(arg2[k10]);
                    k10++;
                    dda[i17] = new String(arg2, k10, k21);
                    k10 += k21;
                }

                return;
            }
            if(arg0 == 208)
            {
                dck = false;
                return;
            }
            if(arg0 == 249)
            {
                elk = true;
                djf = t.fmi(arg2, 1);
                eai = t.fmi(arg2, 3);
                eaj = t.fmi(arg2, 5);
                dnk = t.fmi(arg2, 7);
                eak = t.fmi(arg2, 9);
                eaj -= dnk * eak;
                return;
            }
            if(arg0 == 16)
            {
                int i3 = 1;
                for(int l10 = 0; l10 < 18; l10++)
                    dfk[l10] = t.fmh(arg2[i3++]);

                for(int j17 = 0; j17 < 18; j17++)
                    dmf[j17] = t.fmh(arg2[i3++]);

                for(int l21 = 0; l21 < 18; l21++)
                {
                    edn[l21] = t.fmj(arg2, i3);
                    i3 += 4;
                }

                ema = t.fmh(arg2[i3++]);
                return;
            }
            if(arg0 == 33)
            {
                for(int j3 = 0; j3 < 5; j3++)
                    ege[j3] = t.fmh(arg2[1 + j3]);

                return;
            }
            if(arg0 == 109)
            {
                dgb = 250;
                return;
            }
            if(arg0 == 76)
            {
                int k3 = (arg1 - 1) / 4;
                for(int i11 = 0; i11 < k3; i11++)
                {
                    int k17 = djd + t.fml(arg2, 1 + i11 * 4) >> 3;
                    int i22 = dje + t.fml(arg2, 3 + i11 * 4) >> 3;
                    int j25 = 0;
                    for(int l28 = 0; l28 < dhd; l28++)
                    {
                        int j33 = (dml[l28] >> 3) - k17;
                        int l36 = (dmm[l28] >> 3) - i22;
                        if(j33 != 0 || l36 != 0)
                        {
                            if(l28 != j25)
                            {
                                dml[j25] = dml[l28];
                                dmm[j25] = dmm[l28];
                                dmn[j25] = dmn[l28];
                                dna[j25] = dna[l28];
                            }
                            j25++;
                        }
                    }

                    dhd = j25;
                    j25 = 0;
                    for(int k33 = 0; k33 < efd; k33++)
                    {
                        int i37 = (ekm[k33] >> 3) - k17;
                        int j39 = (ekn[k33] >> 3) - i22;
                        if(i37 != 0 || j39 != 0)
                        {
                            if(k33 != j25)
                            {
                                dik[j25] = dik[k33];
                                dik[j25].chk = j25;
                                ekm[j25] = ekm[k33];
                                ekn[j25] = ekn[k33];
                                ela[j25] = ela[k33];
                                elb[j25] = elb[k33];
                            }
                            j25++;
                        } else
                        {
                            ejg.bgn(dik[k33]);
                            dnh.gkf(ekm[k33], ekn[k33], ela[k33]);
                        }
                    }

                    efd = j25;
                    j25 = 0;
                    for(int j37 = 0; j37 < ehc; j37++)
                    {
                        int k39 = (dhg[j37] >> 3) - k17;
                        int l41 = (dhh[j37] >> 3) - i22;
                        if(k39 != 0 || l41 != 0)
                        {
                            if(j37 != j25)
                            {
                                did[j25] = did[j37];
                                did[j25].chk = j25 + 10000;
                                dhg[j25] = dhg[j37];
                                dhh[j25] = dhh[j37];
                                ecn[j25] = ecn[j37];
                                eda[j25] = eda[j37];
                            }
                            j25++;
                        } else
                        {
                            ejg.bgn(did[j37]);
                            dnh.gkb(dhg[j37], dhh[j37], ecn[j37], eda[j37]);
                        }
                    }

                    ehc = j25;
                }

                return;
            }
            if(arg0 == 7)
            {
                eln = true;
                return;
            }
            if(arg0 == 108)
            {
                int l3 = t.fmi(arg2, 1);
                if(dhb[l3] != null)
                    dcg = dhb[l3].gme;
                dge = true;
                dfg = false;
                dfh = false;
                djg = 0;
                dfd = 0;
                return;
            }
            if(arg0 == 113)
            {
                dge = false;
                edl = false;
                return;
            }
            if(arg0 == 155)
            {
                dfd = arg2[1] & 0xff;
                int i4 = 2;
                for(int j11 = 0; j11 < dfd; j11++)
                {
                    dfe[j11] = t.fmi(arg2, i4);
                    i4 += 2;
                    dff[j11] = t.fmj(arg2, i4);
                    i4 += 4;
                }

                dfg = false;
                dfh = false;
                return;
            }
            if(arg0 == 185)
            {
                byte byte0 = arg2[1];
                if(byte0 == 1)
                {
                    dfg = true;
                    return;
                } else
                {
                    dfg = false;
                    return;
                }
            }
            if(arg0 == 24)
            {
                dmk = true;
                int j4 = 1;
                int k11 = arg2[j4++] & 0xff;
                byte byte4 = arg2[j4++];
                dmc = arg2[j4++] & 0xff;
                dmd = arg2[j4++] & 0xff;
                for(int j22 = 0; j22 < 40; j22++)
                    efa[j22] = -1;

                for(int k25 = 0; k25 < k11; k25++)
                {
                    efa[k25] = t.fmi(arg2, j4);
                    j4 += 2;
                    efb[k25] = t.fmi(arg2, j4);
                    j4 += 2;
                    efc[k25] = arg2[j4++];
                }

                if(byte4 == 1)
                {
                    int i29 = 39;
                    for(int l33 = 0; l33 < ede; l33++)
                    {
                        if(i29 < k11)
                            break;
                        boolean flag2 = false;
                        for(int l39 = 0; l39 < 40; l39++)
                        {
                            if(efa[l39] != edf[l33])
                                continue;
                            flag2 = true;
                            break;
                        }

                        if(edf[l33] == 10)
                            flag2 = true;
                        if(!flag2)
                        {
                            efa[i29] = edf[l33] & 0x7fff;
                            efb[i29] = 0;
                            efc[i29] = 0;
                            i29--;
                        }
                    }

                }
                if(dej >= 0 && dej < 40 && efa[dej] != dek)
                {
                    dej = -1;
                    dek = -2;
                }
                return;
            }
            if(arg0 == 42)
            {
                dmk = false;
                return;
            }
            if(arg0 == 170)
            {
                byte byte1 = arg2[1];
                if(byte1 == 1)
                {
                    dfh = true;
                    return;
                } else
                {
                    dfh = false;
                    return;
                }
            }
            if(arg0 == 161)
            {
                dka = t.fmh(arg2[1]) == 1;
                eef = t.fmh(arg2[2]) == 1;
                dkj = t.fmh(arg2[3]) == 1;
                return;
            }
            if(arg0 == 222)
            {
                for(int k4 = 0; k4 < arg1 - 1; k4++)
                {
                    boolean flag = arg2[k4 + 1] == 1;
                    if(!eeh[k4] && flag)
                        fee("prayeron");
                    if(eeh[k4] && !flag)
                        fee("prayeroff");
                    eeh[k4] = flag;
                }

                return;
            }
            if(arg0 == 26)
            {
                for(int l4 = 0; l4 < 50; l4++)
                    ehf[l4] = arg2[l4 + 1] == 1;

                return;
            }
            if(arg0 == 188)
            {
                dmb = true;
                int i5 = 1;
                elg = arg2[i5++] & 0xff;
                dnc = arg2[i5++] & 0xff;
                for(int l11 = 0; l11 < elg; l11++)
                {
                    dmi[l11] = t.fmi(arg2, i5);
                    i5 += 2;
                    dmj[l11] = t.fmm(arg2, i5);
                    if(dmj[l11] >= 128)
                        i5 += 4;
                    else
                        i5++;
                }

                feb();
                return;
            }
            if(arg0 == 130)
            {
                dmb = false;
                return;
            }
            if(arg0 == 69)
            {
                int j5 = arg2[1] & 0xff;
                edn[j5] = t.fmj(arg2, 2);
                return;
            }
            if(arg0 == 240)
            {
                int k5 = t.fmi(arg2, 1);
                if(dhb[k5] != null)
                    eke = dhb[k5].gme;
                eld = true;
                ded = 0;
                dkl = 0;
                dhe = false;
                dhf = false;
                dgg = false;
                dgh = false;
                dgi = false;
                dgj = false;
                return;
            }
            if(arg0 == 198)
            {
                eld = false;
                ecl = false;
                return;
            }
            if(arg0 == 128)
            {
                edl = true;
                edm = false;
                dge = false;
                int l5 = 1;
                dmg = t.fmk(arg2, l5);
                l5 += 8;
                dnd = arg2[l5++] & 0xff;
                for(int i12 = 0; i12 < dnd; i12++)
                {
                    dne[i12] = t.fmi(arg2, l5);
                    l5 += 2;
                    dnf[i12] = t.fmj(arg2, l5);
                    l5 += 4;
                }

                ecg = arg2[l5++] & 0xff;
                for(int l17 = 0; l17 < ecg; l17++)
                {
                    ech[l17] = t.fmi(arg2, l5);
                    l5 += 2;
                    eci[l17] = t.fmj(arg2, l5);
                    l5 += 4;
                }

                return;
            }
            if(arg0 == 229)
            {
                dkl = arg2[1] & 0xff;
                int i6 = 2;
                for(int j12 = 0; j12 < dkl; j12++)
                {
                    dkm[j12] = t.fmi(arg2, i6);
                    i6 += 2;
                    dkn[j12] = t.fmj(arg2, i6);
                    i6 += 4;
                }

                dhe = false;
                dhf = false;
                return;
            }
            if(arg0 == 211)
            {
                if(arg2[1] == 1)
                    dgg = true;
                else
                    dgg = false;
                if(arg2[2] == 1)
                    dgh = true;
                else
                    dgh = false;
                if(arg2[3] == 1)
                    dgi = true;
                else
                    dgi = false;
                if(arg2[4] == 1)
                    dgj = true;
                else
                    dgj = false;
                dhe = false;
                dhf = false;
                return;
            }
            if(arg0 == 81)
            {
                int j6 = 1;
                int k12 = arg2[j6++] & 0xff;
                int i18 = t.fmi(arg2, j6);
                j6 += 2;
                int k22 = t.fmm(arg2, j6);
                if(k22 >= 128)
                    j6 += 4;
                else
                    j6++;
                if(k22 == 0)
                {
                    elg--;
                    for(int l25 = k12; l25 < elg; l25++)
                    {
                        dmi[l25] = dmi[l25 + 1];
                        dmj[l25] = dmj[l25 + 1];
                    }

                } else
                {
                    dmi[k12] = i18;
                    dmj[k12] = k22;
                    if(k12 >= elg)
                        elg = k12 + 1;
                }
                feb();
                return;
            }
            if(arg0 == 210)
            {
                int k6 = 1;
                int l12 = 1;
                int j18 = arg2[k6++] & 0xff;
                int l22 = t.fmi(arg2, k6);
                k6 += 2;
                if(e.aig[l22 & 0x7fff] == 0)
                {
                    l12 = t.fmm(arg2, k6);
                    if(l12 >= 128)
                        k6 += 4;
                    else
                        k6++;
                }
                edf[j18] = l22 & 0x7fff;
                edh[j18] = l22 / 32768;
                edg[j18] = l12;
                if(j18 >= ede)
                    ede = j18 + 1;
                return;
            }
            if(arg0 == 44)
            {
                int l6 = arg2[1] & 0xff;
                ede--;
                for(int i13 = l6; i13 < ede; i13++)
                {
                    edf[i13] = edf[i13 + 1];
                    edg[i13] = edg[i13 + 1];
                    edh[i13] = edh[i13 + 1];
                }

                return;
            }
            if(arg0 == 23)
            {
                int i7 = 1;
                int j13 = arg2[i7++] & 0xff;
                dfk[j13] = t.fmh(arg2[i7++]);
                dmf[j13] = t.fmh(arg2[i7++]);
                edn[j13] = t.fmj(arg2, i7);
                i7 += 4;
                return;
            }
            if(arg0 == 73)
            {
                byte byte2 = arg2[1];
                if(byte2 == 1)
                {
                    dhe = true;
                    return;
                } else
                {
                    dhe = false;
                    return;
                }
            }
            if(arg0 == 131)
            {
                byte byte3 = arg2[1];
                if(byte3 == 1)
                {
                    dhf = true;
                    return;
                } else
                {
                    dhf = false;
                    return;
                }
            }
            if(arg0 == 10)
            {
                ecl = true;
                ecm = false;
                eld = false;
                int j7 = 1;
                dif = t.fmk(arg2, j7);
                j7 += 8;
                efe = arg2[j7++] & 0xff;
                for(int k13 = 0; k13 < efe; k13++)
                {
                    eff[k13] = t.fmi(arg2, j7);
                    j7 += 2;
                    efg[k13] = t.fmj(arg2, j7);
                    j7 += 4;
                }

                eim = arg2[j7++] & 0xff;
                for(int k18 = 0; k18 < eim; k18++)
                {
                    ein[k18] = t.fmi(arg2, j7);
                    j7 += 2;
                    eja[k18] = t.fmj(arg2, j7);
                    j7 += 4;
                }

                ebm = arg2[j7++] & 0xff;
                ebn = arg2[j7++] & 0xff;
                eca = arg2[j7++] & 0xff;
                ecb = arg2[j7++] & 0xff;
                return;
            }
            if(arg0 == 238)
            {
                String s1 = new String(arg2, 1, arg1 - 1);
                fee(s1);
                return;
            }
            if(arg0 == 253)
            {
                if(eig < 50)
                {
                    int k7 = arg2[1] & 0xff;
                    int l13 = arg2[2] + djd;
                    int l18 = arg2[3] + dje;
                    ehg[eig] = k7;
                    egn[eig] = 0;
                    ell[eig] = l13;
                    elh[eig] = l18;
                    eig++;
                }
                return;
            }
            if(arg0 == 126)
            {
                if(!dcm)
                {
                    elf = t.fmj(arg2, 1);
                    eei = t.fmi(arg2, 5);
                    ekg = arg2[7] & 0xff;
                    ecd = t.fmi(arg2, 8);
                    djj = true;
                    dcm = true;
                    din = null;
                }
                return;
            }
            if(arg0 == 112)
            {
                dhc = new String(arg2, 1, arg1 - 1);
                ecc = true;
                dhi = false;
                return;
            }
            if(arg0 == 49)
            {
                dhc = new String(arg2, 1, arg1 - 1);
                ecc = true;
                dhi = true;
                return;
            }
            if(arg0 == 60)
            {
                dhj = t.fmi(arg2, 1);
                return;
            }
            if(arg0 == 15)
            {
                if(!den)
                    dhk = dhj;
                den = true;
                super.fkl = "";
                super.fkm = "";
                dnb.cbk(efl + 1, arg2);
                del = null;
                return;
            }
            if(arg0 == 174)
            {
                dhk = t.fmi(arg2, 1);
                return;
            }
            if(arg0 == 206)
            {
                den = false;
                return;
            }
            if(arg0 == 20)
            {
                del = "Incorrect - Please wait...";
                return;
            }
            if(arg0 == 28)
            {
                deg = t.fmi(arg2, 1) * 32;
                return;
            }
        }
        catch(RuntimeException runtimeexception)
        {
            if(deb < 3)
            {
                super.aag.hcn(7);
                super.aag.hdc(runtimeexception.toString());
                super.aag.hdl();
                super.aag.hcn(7);
                super.aag.hdc("p-type:" + arg0 + " p-size:" + arg1);
                super.aag.hdl();
                super.aag.hcn(7);
                super.aag.hdc("rx:" + djd + " ry:" + dje + " num3l:" + efd);
                super.aag.hdl();
                String s2 = "";
                for(int i19 = 0; i19 < 80 && i19 < arg1; i19++)
                    s2 = s2 + arg2[i19] + " ";

                super.aag.hcn(7);
                super.aag.hdc(s2);
                super.aag.hdl();
                deb++;
            }
        }
    }

    protected final void ene(Runnable runnable)
    {
        if(link.fni != null)
        {
            link.gah(runnable);
            return;
        } else
        {
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            thread.start();
            return;
        }
    }

    protected final void adc()
    {
        deg = 0;
        dkh = 0;
        ehb = 0;
        ecf = 0;
        ehe = 1;
        fdn();
        dnb.cak();
        dnb.caj(ebf, 0, 0);
        for(int l = 0; l < efd; l++)
        {
            ejg.bgn(dik[l]);
            dnh.gkf(ekm[l], ekn[l], ela[l]);
        }

        for(int i1 = 0; i1 < ehc; i1++)
        {
            ejg.bgn(did[i1]);
            dnh.gkb(dhg[i1], dhh[i1], ecn[i1], eda[i1]);
        }

        efd = 0;
        ehc = 0;
        dhd = 0;
        dgm = 0;
        for(int j1 = 0; j1 < 4000; j1++)
            dhb[j1] = null;

        for(int k1 = 0; k1 < 500; k1++)
            deh[k1] = null;

        ebb = 0;
        for(int l1 = 0; l1 < 5000; l1++)
            ele[l1] = null;

        for(int i2 = 0; i2 < 500; i2++)
            dgf[i2] = null;

        for(int j2 = 0; j2 < 50; j2++)
            eeh[j2] = false;

        dnl = 0;
        super.fkh = 0;
        super.fkg = 0;
        dmk = false;
        dmb = false;
        den = false;
        super.aak = 0;
    }

    private final void enf(boolean arg0)
    {
        int l = ((j) (dnb)).blg - 199;
        char c1 = '\234';
        char c3 = '\230';
        dnb.ccb(l - 49, 3, efh + 2);
        l += 40;
        dnb.cba(l, 36, c1, c3, 0);
        dnb.cah(l, 36, l + c1, 36 + c3);
        int j1 = 192 + maphax;
        int l1 = dkg + dkb & 0xff;
        int j2 = ((djc.gmh - 6040) * 3 * j1) / 2048;
        int l3 = ((djc.gmi - 6040) * 3 * j1) / 2048;
        int j5 = n.bbk[1024 - l1 * 4 & 0x3ff];
        int l5 = n.bbk[(1024 - l1 * 4 & 0x3ff) + 1024];
        int j6 = l3 * j5 + j2 * l5 >> 18;
        l3 = l3 * l5 - j2 * j5 >> 18;
        j2 = j6;
        dnb.ccn((l + c1 / 2) - j2, 36 + c3 / 2 + l3, efh - 1, l1 + 64 & 0xff, j1);
        for(int l7 = 0; l7 < efd; l7++)
        {
            int k2 = (((ekm[l7] * ehd + 64) - djc.gmh) * 3 * j1) / 2048;
            int i4 = (((ekn[l7] * ehd + 64) - djc.gmi) * 3 * j1) / 2048;
            int k6 = i4 * j5 + k2 * l5 >> 18;
            i4 = i4 * l5 - k2 * j5 >> 18;
            k2 = k6;
            fdk(l + c1 / 2 + k2, (36 + c3 / 2) - i4, 65535);
        }

        for(int i8 = 0; i8 < dhd; i8++)
        {
            int l2 = (((dml[i8] * ehd + 64) - djc.gmh) * 3 * j1) / 2048;
            int j4 = (((dmm[i8] * ehd + 64) - djc.gmi) * 3 * j1) / 2048;
            int l6 = j4 * j5 + l2 * l5 >> 18;
            j4 = j4 * l5 - l2 * j5 >> 18;
            l2 = l6;
            fdk(l + c1 / 2 + l2, (36 + c3 / 2) - j4, 0xff0000);
        }

        for(int j8 = 0; j8 < ebb; j8++)
        {
            f f1 = dgf[j8];
            int i3 = ((f1.gmh - djc.gmh) * 3 * j1) / 2048;
            int k4 = ((f1.gmi - djc.gmi) * 3 * j1) / 2048;
            int i7 = k4 * j5 + i3 * l5 >> 18;
            k4 = k4 * l5 - i3 * j5 >> 18;
            i3 = i7;
            fdk(l + c1 / 2 + i3, (36 + c3 / 2) - k4, 0xffff00);
        }

        for(int k8 = 0; k8 < dgm; k8++)
        {
            f f2 = deh[k8];
            int j3 = ((f2.gmh - djc.gmh) * 3 * j1) / 2048;
            int l4 = ((f2.gmi - djc.gmi) * 3 * j1) / 2048;
            int j7 = l4 * j5 + j3 * l5 >> 18;
            l4 = l4 * l5 - j3 * j5 >> 18;
            j3 = j7;
            int i9 = 0xffffff;
            for(int j9 = 0; j9 < super.aak; j9++)
            {
                if(f2.gmd != super.aal[j9] || super.aam[j9] != 99)
                    continue;
                i9 = 65280;
                break;
            }

            fdk(l + c1 / 2 + j3, (36 + c3 / 2) - l4, i9);
        }

        dnb.cal(l + c1 / 2, 36 + c3 / 2, 2, 0xffffff, 255);
        dnb.ccn(l + 19, 55, efh + 24, dkg + 128 & 0xff, 128);
        dnb.cah(0, 0, dch, dci + 12);
        if(!arg0)
            return;
        l = super.fke - (((j) (dnb)).blg - 199);
        int l8 = super.fkf - 36;
        if(l >= 40 && l8 >= 0 && l < 196 && l8 < 152)
        {
            char c2 = '\234';
            char c4 = '\230';
            int k1 = 192 + maphax;
            int i2 = dkg + dkb & 0xff;
            int i1 = ((j) (dnb)).blg - 199;
            i1 += 40;
            int k3 = ((super.fke - (i1 + c2 / 2)) * 16384) / (3 * k1);
            int i5 = ((super.fkf - (36 + c4 / 2)) * 16384) / (3 * k1);
            int k5 = n.bbk[1024 - i2 * 4 & 0x3ff];
            int i6 = n.bbk[(1024 - i2 * 4 & 0x3ff) + 1024];
            int k7 = i5 * k5 + k3 * i6 >> 15;
            i5 = i5 * i6 - k3 * k5 >> 15;
            k3 = k7;
            k3 += djc.gmh;
            i5 = djc.gmi - i5;
            if(dnl == 1)
                fbk(djd, dje, k3 / 128, i5 / 128, false);
            dnl = 0;
        }
    }

    private final boolean eng(int arg0)
    {
        int l = djc.gmh / 128;
        int i1 = djc.gmi / 128;
        for(int j1 = 2; j1 >= 1; j1--)
        {
            if(arg0 == 1 && ((dnh.gij[l][i1 - j1] & 0x80) == 128 || (dnh.gij[l - j1][i1] & 0x80) == 128 || (dnh.gij[l - j1][i1 - j1] & 0x80) == 128))
                return false;
            if(arg0 == 3 && ((dnh.gij[l][i1 + j1] & 0x80) == 128 || (dnh.gij[l - j1][i1] & 0x80) == 128 || (dnh.gij[l - j1][i1 + j1] & 0x80) == 128))
                return false;
            if(arg0 == 5 && ((dnh.gij[l][i1 + j1] & 0x80) == 128 || (dnh.gij[l + j1][i1] & 0x80) == 128 || (dnh.gij[l + j1][i1 + j1] & 0x80) == 128))
                return false;
            if(arg0 == 7 && ((dnh.gij[l][i1 - j1] & 0x80) == 128 || (dnh.gij[l + j1][i1] & 0x80) == 128 || (dnh.gij[l + j1][i1 - j1] & 0x80) == 128))
                return false;
            if(arg0 == 0 && (dnh.gij[l][i1 - j1] & 0x80) == 128)
                return false;
            if(arg0 == 2 && (dnh.gij[l - j1][i1] & 0x80) == 128)
                return false;
            if(arg0 == 4 && (dnh.gij[l][i1 + j1] & 0x80) == 128)
                return false;
            if(arg0 == 6 && (dnh.gij[l + j1][i1] & 0x80) == 128)
                return false;
        }

        return true;
    }

    private final String enh(int l)
    {
        if(link.fni != null)
            return link.gai(t.fnb(l));
        else
            return t.fnb(l);
    }

    private final void eni()
    {
        try
        {
            dma = fcb("sounds" + w.cff + ".mem", "Sound effects", 90);
            dic = new d();
            return;
        }
        catch(Throwable throwable)
        {
            System.out.println("Unable to init sounds:" + throwable);
        }
    }

    protected final void enj()
    {
        if(dcn)
        {
            String s1 = getDocumentBase().getHost().toLowerCase();
            if(!s1.endsWith("jagex.com") && !s1.endsWith("jagex.co.uk") && !s1.endsWith("runescape.com") && !s1.endsWith("runescape.co.uk") && !s1.endsWith("runescape.net") && !s1.endsWith("runescape.org") && !s1.endsWith("penguin") && !s1.endsWith("puffin"))
            {
                ekh = true;
                return;
            }
        }
        int l = 0;
        for(int i1 = 0; i1 < 99; i1++)
        {
            int j1 = i1 + 1;
            int l1 = (int)((double)j1 + 300D * Math.pow(2D, (double)j1 / 7D));
            l += l1;
            ehh[i1] = l & 0xffffffc;
        }

        try
        {
            String s2 = getParameter("referid");
            dkd = Integer.parseInt(s2);
        }
        catch(Exception _ex) { }
        try
        {
            String s3 = getParameter("member");
            int i2 = Integer.parseInt(s3);
            if(i2 == 1)
                egi = true;
        }
        catch(Exception _ex) { }
        if(dcn)
            super.aad = 43594;
        super.fik = 0;
        b.aab = 1000;
        b.aaa = w.cem;
        try
        {
            String s4 = getParameter("poff");
            int j2 = Integer.parseInt(s4);
            super.aad += j2;
            System.out.println("Offset: " + j2);
        }
        catch(Exception _ex) { }
        fbl();
        if(ebh)
            return;
        efh = 2000;
        efi = efh + 100;
        efj = efi + 50;
        efn = efj + 1000;
        efk = efn + 10;
        efl = efk + 50;
        efm = efl + 10;
        ebf = getGraphics();
        fle(50);
        dnb = new k(dch, dci + 12, 4000, this);
        dnb.dai = this;
        dnb.cah(0, 0, dch, dci + 12);
        h.gdh = false;
        h.gdi = efi;
        eij = new h(dnb, 5);
        int k1 = ((j) (dnb)).blg - 199;
        byte byte0 = 36;
        eik = eij.gfk(k1, byte0 + 24, 196, 90, 1, 500, true);
        ejh = new h(dnb, 5);
        eji = ejh.gfk(k1, byte0 + 40, 196, 126, 1, 500, true);
        dig = new h(dnb, 5);
        dih = dig.gfk(k1, byte0 + 24, 196, 251, 1, 500, true);
        enl();
        if(ebh)
            return;
        enn();
        if(ebh)
            return;
        ejg = new n(dnb, 15000, 15000, 1000);
        ejg.bhk(dch / 2, dci / 2, dch / 2, dci / 2, dch, dcj);
        ejg.bbg = 2400;
        ejg.bbh = 2400;
        ejg.bbi = 1;
        ejg.bbj = 2300;
        ejg.bjk(-50, -10, -50);
        dnh = new x(ejg, dnb);
        dnh.gjc = efh;
        fci();
        if(ebh)
            return;
        fda();
        if(ebh)
            return;
        emi();
        if(ebh)
            return;
        if(egi)
            eni();
        if(ebh)
        {
            return;
        } else
        {
            flj(100, "Starting game...");
            fai();
            enk();
            fce();
            emn();
            flb();
            end();
            return;
        }
    }

    private final void enk()
    {
        eki = new h(dnb, 50);
        int l = 40;
        if(!egi)
        {
            eki.gfd(256, 200 + l, "Click on an option", 5, true);
            eki.gfe(156, 240 + l, 120, 35);
            eki.gfe(356, 240 + l, 120, 35);
            eki.gfd(156, 240 + l, "New User", 5, false);
            eki.gfd(356, 240 + l, "Existing User", 5, false);
            eea = eki.gfl(156, 240 + l, 120, 35);
            eeb = eki.gfl(356, 240 + l, 120, 35);
        } else
        {
            eki.gfd(256, 200 + l, "Welcome to RuneScape", 4, true);
            eki.gfd(256, 215 + l, "You need a member account to use this server", 4, true);
            eki.gfe(256, 250 + l, 200, 35);
            eki.gfd(256, 250 + l, "Click here to login", 5, false);
            eeb = eki.gfl(256, 250 + l, 200, 35);
        }
        dnm = new h(dnb, 50);
        l = 230;
        if(dkd == 0)
        {
            dnm.gfd(256, l + 8, "To create an account please go back to the", 4, true);
            l += 20;
            dnm.gfd(256, l + 8, "www.runescape.com front page, and choose 'create account'", 4, true);
        } else
        if(dkd == 1)
        {
            dnm.gfd(256, l + 8, "To create an account please click on the", 4, true);
            l += 20;
            dnm.gfd(256, l + 8, "'create account' link below the game window", 4, true);
        } else
        {
            dnm.gfd(256, l + 8, "To create an account please go back to the", 4, true);
            l += 20;
            dnm.gfd(256, l + 8, "runescape front webpage and choose 'create account'", 4, true);
        }
        l += 30;
        dnm.gfe(256, l + 17, 150, 34);
        dnm.gfd(256, l + 17, "Ok", 5, false);
        dkf = dnm.gfl(256, l + 17, 150, 34);
        dla = new h(dnb, 50);
        l = 230;
        eej = dla.gfd(256, l - 10, "Please enter your username and password", 4, true);
        l += 28;
        dla.gfe(140, l, 200, 40);
        dla.gfd(140, l - 10, "Username:", 4, false);
        eek = dla.gfj(140, l + 10, 200, 40, 4, 12, false, false);
        l += 47;
        dla.gfe(190, l, 200, 40);
        dla.gfd(190, l - 10, "Password:", 4, false);
        eel = dla.gfj(190, l + 10, 200, 40, 4, 20, true, false);
        l -= 55;
        dla.gfe(410, l, 120, 25);
        dla.gfd(410, l, "Ok", 4, false);
        eem = dla.gfl(410, l, 120, 25);
        l += 30;
        dla.gfe(410, l + 5, 120, 35);
        dla.gfd(400, l + 5, "World", 4, false);
        serv = dla.gfj(430, l + 10, 200, 40, 4, 2, false, false);
        l += 30;
        dla.ggg(eek);
    }

    protected final void acb()
    {
        deg = 0;
        if(ehb != 0)
        {
            add();
            return;
        } else
        {
            super.acb();
            return;
        }
    }

    private final void enl()
    {
        byte abyte0[] = fcb("media" + w.cfb + ".jag", "2d graphics", 20);
        if(abyte0 == null)
        {
            ebh = true;
            return;
        }
        byte abyte1[] = t.fng("index.dat", 0, abyte0);
        dnb.cbj(efh, t.fng("inv1.dat", 0, abyte0), abyte1, 1);
        dnb.cbj(efh + 1, t.fng("inv2.dat", 0, abyte0), abyte1, 6);
        dnb.cbj(efh + 9, t.fng("bubble.dat", 0, abyte0), abyte1, 1);
        dnb.cbj(efh + 10, t.fng("runescape.dat", 0, abyte0), abyte1, 1);
        dnb.cbj(efh + 11, t.fng("splat.dat", 0, abyte0), abyte1, 3);
        dnb.cbj(efh + 14, t.fng("icon.dat", 0, abyte0), abyte1, 8);
        dnb.cbj(efh + 22, t.fng("hbar.dat", 0, abyte0), abyte1, 1);
        dnb.cbj(efh + 23, t.fng("hbar2.dat", 0, abyte0), abyte1, 1);
        dnb.cbj(efh + 24, t.fng("compass.dat", 0, abyte0), abyte1, 1);
        dnb.cbj(efh + 25, t.fng("buttons.dat", 0, abyte0), abyte1, 2);
        dnb.cbj(efi, t.fng("scrollbar.dat", 0, abyte0), abyte1, 2);
        dnb.cbj(efi + 2, t.fng("corners.dat", 0, abyte0), abyte1, 4);
        dnb.cbj(efi + 6, t.fng("arrows.dat", 0, abyte0), abyte1, 2);
        dnb.cbj(efk, t.fng("projectile.dat", 0, abyte0), abyte1, e.ahg);
        int l = e.ahc;
        for(int i1 = 1; l > 0; i1++)
        {
            int j1 = l;
            l -= 30;
            if(j1 > 30)
                j1 = 30;
            dnb.cbj(efj + (i1 - 1) * 30, t.fng("objects" + i1 + ".dat", 0, abyte0), abyte1, j1);
        }

        dnb.cbm(efh);
        dnb.cbm(efh + 9);
        for(int k1 = 11; k1 <= 26; k1++)
            dnb.cbm(efh + k1);

        for(int l1 = 0; l1 < e.ahg; l1++)
            dnb.cbm(efk + l1);

        for(int i2 = 0; i2 < e.ahc; i2++)
            dnb.cbm(efj + i2);

    }

    protected final void enm()
    {
        if(ekh)
            return;
        if(eih)
            return;
        if(ebh)
            return;
        try
        {
            dng++;
            if(ehe == 0)
            {
                super.fil = 0;
                fbb();
            }
            if(ehe == 1)
            {
                super.fil++;
                fcd();
            }
            super.fkh = 0;
            super.fkj = 0;
            egj++;
            if(egj > 500)
            {
                egj = 0;
                int l = (int)(Math.random() * 4D);
                if((l & 1) == 1)
                    egl += egm;
                if((l & 2) == 2)
                    dhl += dhm;
            }
            if(egl < -50)
                egm = 2;
            if(egl > 50)
                egm = -2;
            if(dhl < -50)
                dhm = 2;
            if(dhl > 50)
                dhm = -2;
            if(ehl > 0)
                ehl--;
            if(ehm > 0)
                ehm--;
            if(ehn > 0)
                ehn--;
            if(eia > 0)
            {
                eia--;
                return;
            }
        }
        catch(OutOfMemoryError _ex)
        {
            fbe();
            eih = true;
        }
    }

    private final void enn()
    {
        byte abyte0[] = null;
        byte abyte1[] = null;
        abyte0 = fcb("entity" + w.cfe + ".jag", "people and monsters", 30);
        if(abyte0 == null)
        {
            ebh = true;
            return;
        }
        abyte1 = t.fng("index.dat", 0, abyte0);
        byte abyte2[] = null;
        byte abyte3[] = null;
        if(egi)
        {
            abyte2 = fcb("entity" + w.cfe + ".mem", "member graphics", 45);
            if(abyte2 == null)
            {
                ebh = true;
                return;
            }
            abyte3 = t.fng("index.dat", 0, abyte2);
        }
        int l = 0;
        ebi = 0;
        ebj = ebi;
label0:
        for(int i1 = 0; i1 < e.aji; i1++)
        {
            String s1 = e.aja[i1];
            for(int j1 = 0; j1 < i1; j1++)
            {
                if(!e.aja[j1].equalsIgnoreCase(s1))
                    continue;
                e.all[i1] = e.all[j1];
                continue label0;
            }

            byte abyte7[] = t.fng(s1 + ".dat", 0, abyte0);
            byte abyte4[] = abyte1;
            if(abyte7 == null && egi)
            {
                abyte7 = t.fng(s1 + ".dat", 0, abyte2);
                abyte4 = abyte3;
            }
            if(abyte7 != null)
            {
                dnb.cbj(ebj, abyte7, abyte4, 15);
                l += 15;
                if(e.alj[i1] == 1)
                {
                    byte abyte8[] = t.fng(s1 + "a.dat", 0, abyte0);
                    byte abyte5[] = abyte1;
                    if(abyte8 == null && egi)
                    {
                        abyte8 = t.fng(s1 + "a.dat", 0, abyte2);
                        abyte5 = abyte3;
                    }
                    dnb.cbj(ebj + 15, abyte8, abyte5, 3);
                    l += 3;
                }
                if(e.alk[i1] == 1)
                {
                    byte abyte9[] = t.fng(s1 + "f.dat", 0, abyte0);
                    byte abyte6[] = abyte1;
                    if(abyte9 == null && egi)
                    {
                        abyte9 = t.fng(s1 + "f.dat", 0, abyte2);
                        abyte6 = abyte3;
                    }
                    dnb.cbj(ebj + 18, abyte9, abyte6, 9);
                    l += 9;
                }
                if(e.ali[i1] != 0)
                {
                    for(int k1 = ebj; k1 < ebj + 27; k1++)
                        dnb.cbm(k1);

                }
            }
            e.all[i1] = ebj;
            ebj += 27;
        }

        System.out.println("Loaded: " + l + " frames of animation");
    }

    private final void faa()
    {
        dgk.gea(super.fke, super.fkf, super.fkh, super.fkg);
        if(dgk.geb(dlb))
            do
                ddb = ((ddb - 1) + e.aji) % e.aji;
            while((e.ali[ddb] & 3) != 1 || (e.ali[ddb] & 4 * ddi) == 0);
        if(dgk.geb(dlc))
            do
                ddb = (ddb + 1) % e.aji;
            while((e.ali[ddb] & 3) != 1 || (e.ali[ddb] & 4 * ddi) == 0);
        if(dgk.geb(dld))
            dde = ((dde - 1) + eii.length) % eii.length;
        if(dgk.geb(dle))
            dde = (dde + 1) % eii.length;
        if(dgk.geb(dlf) || dgk.geb(dlg))
        {
            for(ddi = 3 - ddi; (e.ali[ddb] & 3) != 1 || (e.ali[ddb] & 4 * ddi) == 0; ddb = (ddb + 1) % e.aji);
            for(; (e.ali[ddc] & 3) != 2 || (e.ali[ddc] & 4 * ddi) == 0; ddc = (ddc + 1) % e.aji);
        }
        if(dgk.geb(dlh))
            ddf = ((ddf - 1) + eid.length) % eid.length;
        if(dgk.geb(dli))
            ddf = (ddf + 1) % eid.length;
        if(dgk.geb(dlj))
            ddh = ((ddh - 1) + dki.length) % dki.length;
        if(dgk.geb(dlk))
            ddh = (ddh + 1) % dki.length;
        if(dgk.geb(dll))
            ddg = ((ddg - 1) + eid.length) % eid.length;
        if(dgk.geb(dlm))
            ddg = (ddg + 1) % eid.length;
        if(dgk.geb(dln))
        {
            super.aag.hcn(238);
            super.aag.hdb(ddi);
            super.aag.hdb(ddb);
            super.aag.hdb(ddc);
            super.aag.hdb(ddd);
            super.aag.hdb(dde);
            super.aag.hdb(ddf);
            super.aag.hdb(ddg);
            super.aag.hdb(ddh);
            super.aag.hdl();
            dnb.cak();
            eln = false;
        }
    }


    private final int fac(int arg0)
    {
        int l = 0;
        for(int i1 = 0; i1 < ede; i1++)
            if(edf[i1] == arg0)
                if(e.aig[arg0] == 1)
                    l++;
                else
                    l += edg[i1];

        return l;
    }

    private final void fad()
    {
        if(ehe == 0)
            return;
        if(ebd > 450)
        {
            fdj("@cya@You can't logout during combat!", 3);
            return;
        }
        if(ebd > 0)
        {
            fdj("@cya@You can't logout for 10 seconds after combat", 3);
            return;
        } else
        {
            super.aag.hcn(3);
            super.aag.hdl();
            ehb = 1000;
            return;
        }
    }

    public final URL getCodeBase()
    {
        if(link.fni != null)
            return link.fni.getCodeBase();
        else
            return super.getCodeBase();
    }

    private final boolean fae(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, boolean arg6, 
            boolean arg7)
    {
        int l = dnh.gjl(arg0, arg1, arg2, arg3, arg4, arg5, dnn, eaa, arg6);
        if(l == -1)
            if(arg7)
            {
                l = 1;
                dnn[0] = arg2;
                eaa[0] = arg3;
            } else
            {
                return false;
            }
        l--;
        arg0 = dnn[l];
        arg1 = eaa[l];
        l--;
        if(arg7)
            super.aag.hcn(226);
        else
            super.aag.hcn(211);
        super.aag.hdj(arg0 + dni);
        super.aag.hdj(arg1 + dnj);
        if(arg7 && l == -1 && (arg0 + dni) % 5 == 0)
            l = 0;
        for(int i1 = l; i1 >= 0 && i1 > l - 25; i1--)
        {
            super.aag.hdb(dnn[i1] - arg0);
            super.aag.hdb(eaa[i1] - arg1);
        }

        super.aag.hdl();
        emb = -24;
        emc = super.fke;
        emd = super.fkf;
        return true;
    }

    private final boolean faf(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, boolean arg6, 
            boolean arg7)
    {
        int l = dnh.gjl(arg0, arg1, arg2, arg3, arg4, arg5, dnn, eaa, arg6);
        if(l == -1)
            return false;
        l--;
        arg0 = dnn[l];
        arg1 = eaa[l];
        l--;
        if(arg7)
            super.aag.hcn(226);
        else
            super.aag.hcn(211);
        super.aag.hdj(arg0 + dni);
        super.aag.hdj(arg1 + dnj);
        if(arg7 && l == -1 && (arg0 + dni) % 5 == 0)
            l = 0;
        for(int i1 = l; i1 >= 0 && i1 > l - 25; i1--)
        {
            super.aag.hdb(dnn[i1] - arg0);
            super.aag.hdb(eaa[i1] - arg1);
        }

        super.aag.hdl();
        emb = -24;
        emc = super.fke;
        emd = super.fkf;
        return true;
    }

    private final void fag(boolean arg0)
    {
        int l = ((j) (dnb)).blg - 199;
        int i1 = 36;
        dnb.ccb(l - 49, 3, efh + 6);
        char c1 = '\304';
        dnb.cam(l, 36, c1, 65, j.cbh(181, 181, 181), 160);
        dnb.cam(l, 101, c1, 65, j.cbh(201, 201, 201), 160);
        dnb.cam(l, 166, c1, 95, j.cbh(181, 181, 181), 160);
        dnb.cam(l, 261, c1, 40, j.cbh(201, 201, 201), 160);
        int j1 = l + 3;
        int l1 = i1 + 15;
        dnb.cdn("Game options - click to toggle", j1, l1, 1, 0);
        l1 += 15;
        if(dka)
            dnb.cdn("Camera angle mode - @gre@Auto", j1, l1, 1, 0xffffff);
        else
            dnb.cdn("Camera angle mode - @red@Manual", j1, l1, 1, 0xffffff);
        l1 += 15;
        if(eef)
            dnb.cdn("Mouse buttons - @red@One", j1, l1, 1, 0xffffff);
        else
            dnb.cdn("Mouse buttons - @gre@Two", j1, l1, 1, 0xffffff);
        l1 += 15;
        if(egi)
            if(dkj)
                dnb.cdn("Sound effects - @red@off", j1, l1, 1, 0xffffff);
            else
                dnb.cdn("Sound effects - @gre@on", j1, l1, 1, 0xffffff);
        l1 += 15;
        dnb.cdn("To change your contact details,", j1, l1, 0, 0xffffff);
        l1 += 15;
        dnb.cdn("password, recovery questions, etc..", j1, l1, 0, 0xffffff);
        l1 += 15;
        dnb.cdn("please select 'account management'", j1, l1, 0, 0xffffff);
        l1 += 15;
        if(dkd == 0)
            dnb.cdn("from the runescape.com front page", j1, l1, 0, 0xffffff);
        else
        if(dkd == 1)
            dnb.cdn("from the link below the gamewindow", j1, l1, 0, 0xffffff);
        else
            dnb.cdn("from the runescape front webpage", j1, l1, 0, 0xffffff);
        l1 += 15;
        l1 += 5;
        dnb.cdn("Privacy settings. Will be applied to", l + 3, l1, 1, 0);
        l1 += 15;
        dnb.cdn("all people not on your friends list", l + 3, l1, 1, 0);
        l1 += 15;
        if(super.abb == 0)
            dnb.cdn("Block chat messages: @red@<off>", l + 3, l1, 1, 0xffffff);
        else
            dnb.cdn("Block chat messages: @gre@<on>", l + 3, l1, 1, 0xffffff);
        l1 += 15;
        if(super.abc == 0)
            dnb.cdn("Block private messages: @red@<off>", l + 3, l1, 1, 0xffffff);
        else
            dnb.cdn("Block private messages: @gre@<on>", l + 3, l1, 1, 0xffffff);
        l1 += 15;
        if(super.abd == 0)
            dnb.cdn("Block trade requests: @red@<off>", l + 3, l1, 1, 0xffffff);
        else
            dnb.cdn("Block trade requests: @gre@<on>", l + 3, l1, 1, 0xffffff);
        l1 += 15;
        if(egi)
            if(super.abe == 0)
                dnb.cdn("Block duel requests: @red@<off>", l + 3, l1, 1, 0xffffff);
            else
                dnb.cdn("Block duel requests: @gre@<on>", l + 3, l1, 1, 0xffffff);
        l1 += 15;
        l1 += 5;
        dnb.cdn("Always logout when you finish", j1, l1, 1, 0);
        l1 += 15;
        int j2 = 0xffffff;
        if(super.fke > j1 && super.fke < j1 + c1 && super.fkf > l1 - 12 && super.fkf < l1 + 4)
            j2 = 0xffff00;
        dnb.cdn("Click here to logout", l + 3, l1, 1, j2);
        if(!arg0)
            return;
        l = super.fke - (((j) (dnb)).blg - 199);
        i1 = super.fkf - 36;
        if(l >= 0 && i1 >= 0 && l < 196 && i1 < 265)
        {
            int k2 = ((j) (dnb)).blg - 199;
            byte byte0 = 36;
            char c2 = '\304';
            int k1 = k2 + 3;
            int i2 = byte0 + 30;
            if(super.fke > k1 && super.fke < k1 + c2 && super.fkf > i2 - 12 && super.fkf < i2 + 4 && dnl == 1)
            {
                dka = !dka;
                super.aag.hcn(165);
                super.aag.hdb(0);
                super.aag.hdb(dka ? 1 : 0);
                super.aag.hdl();
            }
            i2 += 15;
            if(super.fke > k1 && super.fke < k1 + c2 && super.fkf > i2 - 12 && super.fkf < i2 + 4 && dnl == 1)
            {
                eef = !eef;
                super.aag.hcn(165);
                super.aag.hdb(2);
                super.aag.hdb(eef ? 1 : 0);
                super.aag.hdl();
            }
            i2 += 15;
            if(egi && super.fke > k1 && super.fke < k1 + c2 && super.fkf > i2 - 12 && super.fkf < i2 + 4 && dnl == 1)
            {
                dkj = !dkj;
                super.aag.hcn(165);
                super.aag.hdb(3);
                super.aag.hdb(dkj ? 1 : 0);
                super.aag.hdl();
            }
            i2 += 15;
            i2 += 15;
            i2 += 15;
            i2 += 15;
            i2 += 15;
            boolean flag = false;
            i2 += 35;
            if(super.fke > k1 && super.fke < k1 + c2 && super.fkf > i2 - 12 && super.fkf < i2 + 4 && dnl == 1)
            {
                super.abb = 1 - super.abb;
                flag = true;
            }
            i2 += 15;
            if(super.fke > k1 && super.fke < k1 + c2 && super.fkf > i2 - 12 && super.fkf < i2 + 4 && dnl == 1)
            {
                super.abc = 1 - super.abc;
                flag = true;
            }
            i2 += 15;
            if(super.fke > k1 && super.fke < k1 + c2 && super.fkf > i2 - 12 && super.fkf < i2 + 4 && dnl == 1)
            {
                super.abd = 1 - super.abd;
                flag = true;
            }
            i2 += 15;
            if(egi && super.fke > k1 && super.fke < k1 + c2 && super.fkf > i2 - 12 && super.fkf < i2 + 4 && dnl == 1)
            {
                super.abe = 1 - super.abe;
                flag = true;
            }
            i2 += 15;
            if(flag)
                acg(super.abb, super.abc, super.abd, super.abe);
            i2 += 20;
            if(super.fke > k1 && super.fke < k1 + c2 && super.fkf > i2 - 12 && super.fkf < i2 + 4 && dnl == 1)
                fad();
            dnl = 0;
        }
    }

    private final void fah(int arg0, int arg1, int arg2, int arg3)
    {
        int l;
        int i1;
        if(arg2 == 0 || arg2 == 4)
        {
            l = e.amh[arg3];
            i1 = e.ami[arg3];
        } else
        {
            i1 = e.amh[arg3];
            l = e.ami[arg3];
        }
        if(e.amj[arg3] == 2 || e.amj[arg3] == 3)
        {
            if(arg2 == 0)
            {
                arg0--;
                l++;
            }
            if(arg2 == 2)
                i1++;
            if(arg2 == 4)
                l++;
            if(arg2 == 6)
            {
                arg1--;
                i1++;
            }
            fae(djd, dje, arg0, arg1, (arg0 + l) - 1, (arg1 + i1) - 1, false, true);
            return;
        } else
        {
            fae(djd, dje, arg0, arg1, (arg0 + l) - 1, (arg1 + i1) - 1, true, true);
            return;
        }
    }

    private final void fai()
    {
        ddj = new h(dnb, 10);
        ddk = ddj.gfh(5, 269, 502, 56, 1, 20, true);
        ddl = ddj.gfi(7, 324, 498, 14, 1, 80, false, true);
        ddm = ddj.gfh(5, 269, 502, 56, 1, 20, true);
        ddn = ddj.gfh(5, 269, 502, 56, 1, 20, true);
        ddj.ggg(ddl);
    }

    private final void faj()
    {
        byte byte0 = 7;
        byte byte1 = 15;
        char c1 = '\257';
        if(dnl != 0)
        {
            for(int l = 0; l < 5; l++)
            {
                if(l <= 0 || super.fke <= byte0 || super.fke >= byte0 + c1 || super.fkf <= byte1 + l * 20 || super.fkf >= byte1 + l * 20 + 20)
                    continue;
                dkh = l - 1;
                dnl = 0;
                super.aag.hcn(74);
                super.aag.hdb(dkh);
                super.aag.hdl();
                break;
            }

        }
        for(int i1 = 0; i1 < 5; i1++)
        {
            if(i1 == dkh + 1)
                dnb.cam(byte0, byte1 + i1 * 20, c1, 20, j.cbh(255, 0, 0), 128);
            else
                dnb.cam(byte0, byte1 + i1 * 20, c1, 20, j.cbh(190, 190, 190), 128);
            dnb.cbc(byte0, byte1 + i1 * 20, c1, 0);
            dnb.cbc(byte0, byte1 + i1 * 20 + 20, c1, 0);
        }

        dnb.cdl("Select combat style", byte0 + c1 / 2, byte1 + 16, 3, 0xffffff);
        dnb.cdl("Controlled (+1 of each)", byte0 + c1 / 2, byte1 + 36, 3, 0);
        dnb.cdl("Aggressive (+3 strength)", byte0 + c1 / 2, byte1 + 56, 3, 0);
        dnb.cdl("Accurate   (+3 attack)", byte0 + c1 / 2, byte1 + 76, 3, 0);
        dnb.cdl("Defensive  (+3 defense)", byte0 + c1 / 2, byte1 + 96, 3, 0);
    }

    private final void fak()
    {
        if(dnl != 0 && ekb == 0)
            ekb = 1;
        if(ekb > 0)
        {
            int l = super.fke - 22;
            int i1 = super.fkf - 36;
            if(l >= 0 && i1 >= 0 && l < 468 && i1 < 262)
            {
                if(l > 216 && i1 > 30 && l < 462 && i1 < 235)
                {
                    int j1 = (l - 217) / 49 + ((i1 - 31) / 34) * 5;
                    if(j1 >= 0 && j1 < ede)
                    {
                        boolean flag = false;
                        int k2 = 0;
                        int j3 = edf[j1];
                        for(int j4 = 0; j4 < djg; j4++)
                            if(djh[j4] == j3)
                                if(e.aig[j3] == 0)
                                {
                                    for(int l4 = 0; l4 < ekb; l4++)
                                    {
                                        if(dji[j4] < edg[j1])
                                            dji[j4]++;
                                        flag = true;
                                    }

                                } else
                                {
                                    k2++;
                                }

                        if(fac(j3) <= k2)
                            flag = true;
                        if(e.aik[j3] == 1)
                        {
                            fdj("This object cannot be traded with other players", 3);
                            flag = true;
                        }
                        if(!flag && djg < 12)
                        {
                            djh[djg] = j3;
                            dji[djg] = 1;
                            djg++;
                            flag = true;
                        }
                        if(flag)
                        {
                            super.aag.hcn(144);
                            super.aag.hdb(djg);
                            for(int i5 = 0; i5 < djg; i5++)
                            {
                                super.aag.hdj(djh[i5]);
                                super.aag.hdh(dji[i5]);
                            }

                            super.aag.hdl();
                            dfg = false;
                            dfh = false;
                        }
                    }
                }
                if(l > 8 && i1 > 30 && l < 205 && i1 < 133)
                {
                    int k1 = (l - 9) / 49 + ((i1 - 31) / 34) * 4;
                    if(k1 >= 0 && k1 < djg)
                    {
                        int i2 = djh[k1];
                        for(int l2 = 0; l2 < ekb; l2++)
                        {
                            if(e.aig[i2] == 0 && dji[k1] > 1)
                            {
                                dji[k1]--;
                                continue;
                            }
                            djg--;
                            eka = 0;
                            for(int k3 = k1; k3 < djg; k3++)
                            {
                                djh[k3] = djh[k3 + 1];
                                dji[k3] = dji[k3 + 1];
                            }

                            break;
                        }

                        super.aag.hcn(144);
                        super.aag.hdb(djg);
                        for(int l3 = 0; l3 < djg; l3++)
                        {
                            super.aag.hdj(djh[l3]);
                            super.aag.hdh(dji[l3]);
                        }

                        super.aag.hdl();
                        dfg = false;
                        dfh = false;
                    }
                }
                if(l >= 217 && i1 >= 238 && l <= 286 && i1 <= 259)
                {
                    dfh = true;
                    super.aag.hcn(94);
                    super.aag.hdl();
                }
                if(l >= 394 && i1 >= 238 && l < 463 && i1 < 259)
                {
                    dge = false;
                    super.aag.hcn(27);
                    super.aag.hdl();
                }
            } else
            if(dnl != 0)
            {
                dge = false;
                super.aag.hcn(27);
                super.aag.hdl();
            }
            dnl = 0;
            ekb = 0;
        }
        if(!dge)
            return;
        byte byte0 = 22;
        byte byte1 = 36;
        dnb.cba(byte0, byte1, 468, 12, 192);
        int l1 = 0x989898;
        dnb.cam(byte0, byte1 + 12, 468, 18, l1, 160);
        dnb.cam(byte0, byte1 + 30, 8, 248, l1, 160);
        dnb.cam(byte0 + 205, byte1 + 30, 11, 248, l1, 160);
        dnb.cam(byte0 + 462, byte1 + 30, 6, 248, l1, 160);
        dnb.cam(byte0 + 8, byte1 + 133, 197, 22, l1, 160);
        dnb.cam(byte0 + 8, byte1 + 258, 197, 20, l1, 160);
        dnb.cam(byte0 + 216, byte1 + 235, 246, 43, l1, 160);
        int j2 = 0xd0d0d0;
        dnb.cam(byte0 + 8, byte1 + 30, 197, 103, j2, 160);
        dnb.cam(byte0 + 8, byte1 + 155, 197, 103, j2, 160);
        dnb.cam(byte0 + 216, byte1 + 30, 246, 205, j2, 160);
        for(int i3 = 0; i3 < 4; i3++)
            dnb.cbc(byte0 + 8, byte1 + 30 + i3 * 34, 197, 0);

        for(int i4 = 0; i4 < 4; i4++)
            dnb.cbc(byte0 + 8, byte1 + 155 + i4 * 34, 197, 0);

        for(int k4 = 0; k4 < 7; k4++)
            dnb.cbc(byte0 + 216, byte1 + 30 + k4 * 34, 246, 0);

        for(int j5 = 0; j5 < 6; j5++)
        {
            if(j5 < 5)
                dnb.cbd(byte0 + 8 + j5 * 49, byte1 + 30, 103, 0);
            if(j5 < 5)
                dnb.cbd(byte0 + 8 + j5 * 49, byte1 + 155, 103, 0);
            dnb.cbd(byte0 + 216 + j5 * 49, byte1 + 30, 205, 0);
        }

        dnb.cdn("Trading with: " + dcg, byte0 + 1, byte1 + 10, 1, 0xffffff);
        dnb.cdn("Your Offer", byte0 + 9, byte1 + 27, 4, 0xffffff);
        dnb.cdn("Opponent's Offer", byte0 + 9, byte1 + 152, 4, 0xffffff);
        dnb.cdn("Your Inventory", byte0 + 216, byte1 + 27, 4, 0xffffff);
        if(!dfh)
            dnb.ccb(byte0 + 217, byte1 + 238, efh + 25);
        dnb.ccb(byte0 + 394, byte1 + 238, efh + 26);
        if(dfg)
        {
            dnb.cdl("Other player", byte0 + 341, byte1 + 246, 1, 0xffffff);
            dnb.cdl("has accepted", byte0 + 341, byte1 + 256, 1, 0xffffff);
        }
        if(dfh)
        {
            dnb.cdl("Waiting for", byte0 + 217 + 35, byte1 + 246, 1, 0xffffff);
            dnb.cdl("other player", byte0 + 217 + 35, byte1 + 256, 1, 0xffffff);
        }
        for(int k5 = 0; k5 < ede; k5++)
        {
            int l5 = 217 + byte0 + (k5 % 5) * 49;
            int j6 = 31 + byte1 + (k5 / 5) * 34;
            dnb.cdd(l5, j6, 48, 32, efj + e.aie[edf[k5]], e.aij[edf[k5]], 0, 0, false);
            if(e.aig[edf[k5]] == 0)
                dnb.cdn(String.valueOf(edg[k5]), l5 + 1, j6 + 10, 1, 0xffff00);
        }

        for(int i6 = 0; i6 < djg; i6++)
        {
            int k6 = 9 + byte0 + (i6 % 4) * 49;
            int i7 = 31 + byte1 + (i6 / 4) * 34;
            dnb.cdd(k6, i7, 48, 32, efj + e.aie[djh[i6]], e.aij[djh[i6]], 0, 0, false);
            if(e.aig[djh[i6]] == 0)
                dnb.cdn(String.valueOf(dji[i6]), k6 + 1, i7 + 10, 1, 0xffff00);
            if(super.fke > k6 && super.fke < k6 + 48 && super.fkf > i7 && super.fkf < i7 + 32)
                dnb.cdn(e.aib[djh[i6]] + ": @whi@" + e.aic[djh[i6]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }

        for(int l6 = 0; l6 < dfd; l6++)
        {
            int j7 = 9 + byte0 + (l6 % 4) * 49;
            int k7 = 156 + byte1 + (l6 / 4) * 34;
            dnb.cdd(j7, k7, 48, 32, efj + e.aie[dfe[l6]], e.aij[dfe[l6]], 0, 0, false);
            if(e.aig[dfe[l6]] == 0)
                dnb.cdn(String.valueOf(dff[l6]), j7 + 1, k7 + 10, 1, 0xffff00);
            if(super.fke > j7 && super.fke < j7 + 48 && super.fkf > k7 && super.fkf < k7 + 32)
                dnb.cdn(e.aib[dfe[l6]] + ": @whi@" + e.aic[dfe[l6]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }

    }

    private final void fal()
    {
        if((eli & 1) == 1 && eng(eli))
            return;
        if((eli & 1) == 0 && eng(eli))
        {
            if(eng(eli + 1 & 7))
            {
                eli = eli + 1 & 7;
                return;
            }
            if(eng(eli + 7 & 7))
                eli = eli + 7 & 7;
            return;
        }
        int ai[] = {
            1, -1, 2, -2, 3, -3, 4
        };
        for(int l = 0; l < 7; l++)
        {
            if(!eng(eli + ai[l] + 8 & 7))
                continue;
            eli = eli + ai[l] + 8 & 7;
            break;
        }

        if((eli & 1) == 0 && eng(eli))
        {
            if(eng(eli + 1 & 7))
            {
                eli = eli + 1 & 7;
                return;
            }
            if(eng(eli + 7 & 7))
                eli = eli + 7 & 7;
            return;
        } else
        {
            return;
        }
    }

    public final String getParameter(String s1)
    {
        if(link.fni != null)
            return link.fni.getParameter(s1);
        else
            return super.getParameter(s1);
    }

    private final void fam()
    {
        dnb.cba(126, 137, 260, 60, 0);
        dnb.cbb(126, 137, 260, 60, 0xffffff);
        dnb.cdl("Logging out...", 256, 173, 5, 0xffffff);
    }

    private final void fan(int l, int i1, int j1, int k1, boolean flag)
    {
        if(faf(l, i1, j1, k1, j1, k1, false, flag))
        {
            return;
        } else
        {
            fae(l, i1, j1, k1, j1, k1, true, flag);
            return;
        }
    }

    protected final void ada(String s1, String s2)
    {
        if(ecf == 1)
            dnm.ggc(dke, s1 + " " + s2);
        if(ecf == 2)
            dla.ggc(eej, s1 + " " + s2);
        djb = s2;
        fbh();
        flf();
    }

    final void fba(int l, int i1, int j1, int k1, int l1, int i2, int j2)
    {
        int k2 = ehg[l1];
        int l2 = egn[l1];
        if(k2 == 0)
        {
            int i3 = 255 + l2 * 5 * 256;
            dnb.cal(l + j1 / 2, i1 + k1 / 2, 20 + l2 * 2, i3, 255 - l2 * 5);
        }
        if(k2 == 1)
        {
            int j3 = 0xff0000 + l2 * 5 * 256;
            dnb.cal(l + j1 / 2, i1 + k1 / 2, 10 + l2, j3, 255 - l2 * 5);
        }
    }

    private final void fbb()
    {
        if(super.abi > 0)
            super.abi--;
        if(ecf == 0)
        {
            eki.gea(super.fke, super.fkf, super.fkh, super.fkg);
            if(eki.geb(eea))
                ecf = 1;
            if(eki.geb(eeb))
            {
                ecf = 2;
                dla.ggc(eej, "Please enter your username and password");
                dla.ggc(eek, "");
                dla.ggc(eel, "");
                dla.ggg(eek);
                return;
            }
        } else
        if(ecf == 1)
        {
            dnm.gea(super.fke, super.fkf, super.fkh, super.fkg);
            if(dnm.geb(dkf))
            {
                ecf = 0;
                return;
            }
        } else
        if(ecf == 2)
        {
            dla.gea(super.fke, super.fkf, super.fkh, super.fkg);
            if(dla.geb(een))
                ecf = 0;
            if(dla.geb(eek))
                dla.ggg(eel);
            if(dla.geb(eel) || dla.geb(eem) || Remember)
            {
            ekc = dla.ggd(eek);
            ekd = dla.ggd(eel);
                server = dla.ggd(serv);
                if(server.equals("81") || server.equals("82") || server.equals("83") || server.equals("84") || server.equals("85") || server.equals("86"))
        {
                                 changeworld(Integer.parseInt(server));
                    abn(ekc, ekd, false);
                }
            }
        }

    private final boolean fbc(int arg0)
    {
        for(int l = 0; l < ede; l++)
            if(edf[l] == arg0 && edh[l] == 1)
                return true;

        return false;
    }

    protected final void fbd()
    {
        if(ebh)
        {
            Graphics g1 = getGraphics();
            g1.setColor(Color.black);
            g1.fillRect(0, 0, 512, 356);
            g1.setFont(new Font("Helvetica", 1, 16));
            g1.setColor(Color.yellow);
            int l = 35;
            g1.drawString("Sorry, an error has occured whilst loading RuneScape", 30, l);
            l += 50;
            g1.setColor(Color.white);
            g1.drawString("To fix this try the following (in order):", 30, l);
            l += 50;
            g1.setColor(Color.white);
            g1.setFont(new Font("Helvetica", 1, 12));
            g1.drawString("1: Try closing ALL open web-browser windows, and reloading", 30, l);
            l += 30;
            g1.drawString("2: Try clearing your web-browsers cache from tools->internet options", 30, l);
            l += 30;
            g1.drawString("3: Try using a different game-world", 30, l);
            l += 30;
            g1.drawString("4: Try rebooting your computer", 30, l);
            l += 30;
            g1.drawString("5: Try selecting a different version of Java from the play-game menu", 30, l);
            fle(1);
            return;
        }
        if(ekh)
        {
            Graphics g2 = getGraphics();
            g2.setColor(Color.black);
            g2.fillRect(0, 0, 512, 356);
            g2.setFont(new Font("Helvetica", 1, 20));
            g2.setColor(Color.white);
            g2.drawString("Error - unable to load game!", 50, 50);
            g2.drawString("To play RuneScape make sure you play from", 50, 100);
            g2.drawString("http://www.runescape.com", 50, 150);
            fle(1);
            return;
        }
        if(eih)
        {
            Graphics g3 = getGraphics();
            g3.setColor(Color.black);
            g3.fillRect(0, 0, 512, 356);
            g3.setFont(new Font("Helvetica", 1, 20));
            g3.setColor(Color.white);
            g3.drawString("Error - out of memory!", 50, 50);
            g3.drawString("Close ALL unnecessary programs", 50, 100);
            g3.drawString("and windows before loading the game", 50, 150);
            g3.drawString("RuneScape needs about 48meg of spare RAM", 50, 200);
            fle(1);
            return;
        }
        try
        {
            if(ehe == 0)
            {
                dnb.bnf = false;
                fbh();
            }
            if(ehe == 1)
            {
                dnb.bnf = true;
                fcl();
                return;
            }
        }
        catch(OutOfMemoryError _ex)
        {
            fbe();
            eih = true;
        }
    }

    private final void fbe()
    {
        try
        {
            if(dnb != null)
            {
                dnb.cbi();
                dnb.blm = null;
                dnb = null;
            }
            if(ejg != null)
            {
                ejg.bha();
                ejg = null;
            }
            edb = null;
            dik = null;
            did = null;
            dhb = null;
            deh = null;
            ele = null;
            dgf = null;
            djc = null;
            if(dnh != null)
            {
                dnh.ghn = null;
                dnh.gim = null;
                dnh.gih = null;
                dnh.gia = null;
                dnh = null;
            }
            System.gc();
            return;
        }
        catch(Exception _ex)
        {
            return;
        }
    }

    private final void fbf()
    {
        if(dnl != 0)
        {
            for(int l = 0; l < egk; l++)
            {
                if(super.fke >= dnb.cef(dda[l], 1) || super.fkf <= l * 12 || super.fkf >= 12 + l * 12)
                    continue;
                super.aag.hcn(189);
                super.aag.hdb(l);
                super.aag.hdl();
                break;
            }

            dnl = 0;
            dck = false;
            return;
        }
        for(int i1 = 0; i1 < egk; i1++)
        {
            int j1 = 65535;
            if(super.fke < dnb.cef(dda[i1], 1) && super.fkf > i1 * 12 && super.fkf < 12 + i1 * 12)
                j1 = 0xff0000;
            dnb.cdn(dda[i1], 6, 12 + i1 * 12, 1, j1);
        }

    }

    private final void fbg()
    {
        byte byte0 = 22;
        byte byte1 = 36;
        dnb.cba(byte0, byte1, 468, 16, 192);
        int l = 0x989898;
        dnb.cam(byte0, byte1 + 16, 468, 246, l, 160);
        dnb.cdl("Please confirm your trade with @yel@" + t.fnd(dmg), byte0 + 234, byte1 + 12, 1, 0xffffff);
        dnb.cdl("You are about to give:", byte0 + 117, byte1 + 30, 1, 0xffff00);
        for(int i1 = 0; i1 < ecg; i1++)
        {
            String s1 = e.aib[ech[i1]];
            if(e.aig[ech[i1]] == 0)
                s1 = s1 + " x " + fdh(eci[i1]);
            dnb.cdl(s1, byte0 + 117, byte1 + 42 + i1 * 12, 1, 0xffffff);
        }

        if(ecg == 0)
            dnb.cdl("Nothing!", byte0 + 117, byte1 + 42, 1, 0xffffff);
        dnb.cdl("In return you will receive:", byte0 + 351, byte1 + 30, 1, 0xffff00);
        for(int j1 = 0; j1 < dnd; j1++)
        {
            String s2 = e.aib[dne[j1]];
            if(e.aig[dne[j1]] == 0)
                s2 = s2 + " x " + fdh(dnf[j1]);
            dnb.cdl(s2, byte0 + 351, byte1 + 42 + j1 * 12, 1, 0xffffff);
        }

        if(dnd == 0)
            dnb.cdl("Nothing!", byte0 + 351, byte1 + 42, 1, 0xffffff);
        dnb.cdl("Are you sure you want to do this?", byte0 + 234, byte1 + 200, 4, 65535);
        dnb.cdl("There is NO WAY to reverse a trade if you change your mind.", byte0 + 234, byte1 + 215, 1, 0xffffff);
        dnb.cdl("Remember that not all players are trustworthy", byte0 + 234, byte1 + 230, 1, 0xffffff);
        if(!edm)
        {
            dnb.ccb((byte0 + 118) - 35, byte1 + 238, efh + 25);
            dnb.ccb((byte0 + 352) - 35, byte1 + 238, efh + 26);
        } else
        {
            dnb.cdl("Waiting for other player...", byte0 + 234, byte1 + 250, 1, 0xffff00);
        }
        if(dnl == 1)
        {
            if(super.fke < byte0 || super.fkf < byte1 || super.fke > byte0 + 468 || super.fkf > byte1 + 262)
            {
                edl = false;
                super.aag.hcn(27);
                super.aag.hdl();
            }
            if(super.fke >= (byte0 + 118) - 35 && super.fke <= byte0 + 118 + 70 && super.fkf >= byte1 + 238 && super.fkf <= byte1 + 238 + 21)
            {
                edm = true;
                super.aag.hcn(102);
                super.aag.hdl();
            }
            if(super.fke >= (byte0 + 352) - 35 && super.fke <= byte0 + 353 + 70 && super.fkf >= byte1 + 238 && super.fkf <= byte1 + 238 + 21)
            {
                edl = false;
                super.aag.hcn(27);
                super.aag.hdl();
            }
            dnl = 0;
        }
    }

    private final void fbh()
    {
        dcm = false;
        dnb.bnc = false;
        dnb.cak();
        if(ecf == 0 || ecf == 1 || ecf == 2 || ecf == 3)
        {
            int l = (dng * 2) % 3072;
            if(l < 1024)
            {
                dnb.ccb(0, 10, efn);
                if(l > 768)
                    dnb.ccd(0, 10, efn + 1, l - 768);
            } else
            if(l < 2048)
            {
                dnb.ccb(0, 10, efn + 1);
                if(l > 1792)
                    dnb.ccd(0, 10, efh + 10, l - 1792);
            } else
            {
                dnb.ccb(0, 10, efh + 10);
                if(l > 2816)
                    dnb.ccd(0, 10, efn, l - 2816);
            }
        }
        if(ecf == 0)
            eki.ged();
        if(ecf == 1)
            dnm.ged();
        if(ecf == 2)
            dla.ged();
        dnb.ccb(0, dci, efh + 22);
        dnb.caj(ebf, 0, 0);
    }

    final void fbi(int l, int i1, int j1, int k1, int l1, int i2, int j2)
    {
        int k2 = e.aie[l1] + efj;
        int l2 = e.aij[l1];
        dnb.cdd(l, i1, j1, k1, k2, l2, 0, 0, false);
    }

    private final f fbj(int arg0, int arg1, int arg2, int arg3)
    {
        if(dhb[arg0] == null)
        {
            dhb[arg0] = new f();
            dhb[arg0].gmf = arg0;
            dhb[arg0].gmg = 0;
        }
        f f1 = dhb[arg0];
        boolean flag = false;
        for(int l = 0; l < dgn; l++)
        {
            if(edk[l].gmf != arg0)
                continue;
            flag = true;
            break;
        }

        if(flag)
        {
            f1.gmm = arg3;
            int i1 = f1.gna;
            if(arg1 != f1.gnb[i1] || arg2 != f1.gnc[i1])
            {
                f1.gna = i1 = (i1 + 1) % 10;
                f1.gnb[i1] = arg1;
                f1.gnc[i1] = arg2;
            }
        } else
        {
            f1.gmf = arg0;
            f1.gmn = 0;
            f1.gna = 0;
            f1.gnb[0] = f1.gmh = arg1;
            f1.gnc[0] = f1.gmi = arg2;
            f1.gmm = f1.gml = arg3;
            f1.gmk = 0;
        }
        deh[dgm++] = f1;
        return f1;
    }

    private final void fbk(int l, int i1, int j1, int k1, boolean flag)
    {
        fae(l, i1, j1, k1, j1, k1, false, flag);
    }

    private final void fbl()
    {
        byte abyte0[] = fcb("config" + w.cen + ".jag", "Configuration", 10);
        if(abyte0 == null)
        {
            ebh = true;
            return;
        }
        e.baa(abyte0, egi);
        byte abyte1[] = fcb("filter" + w.cfg + ".jag", "Chat system", 15);
        if(abyte1 == null)
        {
            ebh = true;
            return;
        } else
        {
            byte abyte2[] = t.fng("fragmentsenc.txt", 0, abyte1);
            byte abyte3[] = t.fng("badenc.txt", 0, abyte1);
            byte abyte4[] = t.fng("hostenc.txt", 0, abyte1);
            byte abyte5[] = t.fng("tldlist.txt", 0, abyte1);
            u.ffl(new q(abyte2), new q(abyte3), new q(abyte4), new q(abyte5));
            return;
        }
    }

    protected final void fbm(int arg0, int arg1, int arg2)
    {
        eed[eec] = arg1;
        eee[eec] = arg2;
        eec = eec + 1 & 0x1fff;
        for(int l = 10; l < 4000; l++)
        {
            int i1 = eec - l & 0x1fff;
            if(eed[i1] == arg1 && eee[i1] == arg2)
            {
                boolean flag = false;
                for(int j1 = 1; j1 < l; j1++)
                {
                    int k1 = eec - j1 & 0x1fff;
                    int l1 = i1 - j1 & 0x1fff;
                    if(eed[l1] != arg1 || eee[l1] != arg2)
                        flag = true;
                    if(eed[k1] != eed[l1] || eee[k1] != eee[l1])
                        break;
                    if(j1 == l - 1 && flag && ebd == 0 && ehb == 0)
                    {
                        fad();
                        return;
                    }
                }

            }
        }

    }

    private final void fbn(boolean arg0)
    {
        int l = ((j) (dnb)).blg - 199;
        int i1 = 36;
        dnb.ccb(l - 49, 3, efh + 5);
        char c1 = '\304';
        char c2 = '\266';
        int k1;
        int j1 = k1 = j.cbh(160, 160, 160);
        if(ejj == 0)
            j1 = j.cbh(220, 220, 220);
        else
            k1 = j.cbh(220, 220, 220);
        dnb.cam(l, i1, c1 / 2, 24, j1, 128);
        dnb.cam(l + c1 / 2, i1, c1 / 2, 24, k1, 128);
        dnb.cam(l, i1 + 24, c1, c2 - 24, j.cbh(220, 220, 220), 128);
        dnb.cbc(l, i1 + 24, c1, 0);
        dnb.cbd(l + c1 / 2, i1, 24, 0);
        dnb.cbc(l, (i1 + c2) - 16, c1, 0);
        dnb.cdl("Friends", l + c1 / 4, i1 + 16, 4, 0);
        dnb.cdl("Ignore", l + c1 / 4 + c1 / 2, i1 + 16, 4, 0);
        ejh.gfm(eji);
        if(ejj == 0)
        {
            for(int l1 = 0; l1 < super.aak; l1++)
            {
                String s1;
                if(super.aam[l1] == 99)
                    s1 = "@gre@";
                else
                if(super.aam[l1] > 0)
                    s1 = "@yel@";
                else
                    s1 = "@red@";
                ejh.gga(eji, l1, s1 + t.fnd(super.aal[l1]) + "~439~@whi@Remove         WWWWWWWWWW");
            }

        }
        if(ejj == 1)
        {
            for(int i2 = 0; i2 < super.aan; i2++)
                ejh.gga(eji, i2, "@yel@" + t.fnd(super.aba[i2]) + "~439~@whi@Remove         WWWWWWWWWW");

        }
        ejh.ged();
        if(ejj == 0)
        {
            int j2 = ejh.ggh(eji);
            if(j2 >= 0 && super.fke < 489)
            {
                if(super.fke > 429)
                    dnb.cdl("Click to remove " + t.fnd(super.aal[j2]), l + c1 / 2, i1 + 35, 1, 0xffffff);
                else
                if(super.aam[j2] == 99)
                    dnb.cdl("Click to message " + t.fnd(super.aal[j2]), l + c1 / 2, i1 + 35, 1, 0xffffff);
                else
                if(super.aam[j2] > 0)
                    dnb.cdl(t.fnd(super.aal[j2]) + " is on world " + super.aam[j2], l + c1 / 2, i1 + 35, 1, 0xffffff);
                else
                    dnb.cdl(t.fnd(super.aal[j2]) + " is offline", l + c1 / 2, i1 + 35, 1, 0xffffff);
            } else
            {
                dnb.cdl("Click a name to send a message", l + c1 / 2, i1 + 35, 1, 0xffffff);
            }
            int j3;
            if(super.fke > l && super.fke < l + c1 && super.fkf > (i1 + c2) - 16 && super.fkf < i1 + c2)
                j3 = 0xffff00;
            else
                j3 = 0xffffff;
            dnb.cdl("Click here to add a friend", l + c1 / 2, (i1 + c2) - 3, 1, j3);
        }
        if(ejj == 1)
        {
            int k2 = ejh.ggh(eji);
            if(k2 >= 0 && super.fke < 489 && super.fke > 429)
            {
                if(super.fke > 429)
                    dnb.cdl("Click to remove " + t.fnd(super.aba[k2]), l + c1 / 2, i1 + 35, 1, 0xffffff);
            } else
            {
                dnb.cdl("Blocking messages from:", l + c1 / 2, i1 + 35, 1, 0xffffff);
            }
            int k3;
            if(super.fke > l && super.fke < l + c1 && super.fkf > (i1 + c2) - 16 && super.fkf < i1 + c2)
                k3 = 0xffff00;
            else
                k3 = 0xffffff;
            dnb.cdl("Click here to add a name", l + c1 / 2, (i1 + c2) - 3, 1, k3);
        }
        if(!arg0)
            return;
        l = super.fke - (((j) (dnb)).blg - 199);
        i1 = super.fkf - 36;
        if(l >= 0 && i1 >= 0 && l < 196 && i1 < 182)
        {
            ejh.gea(l + (((j) (dnb)).blg - 199), i1 + 36, super.fkh, super.fkg);
            if(i1 <= 24 && dnl == 1)
                if(l < 98 && ejj == 1)
                {
                    ejj = 0;
                    ejh.gfn(eji);
                } else
                if(l > 98 && ejj == 0)
                {
                    ejj = 1;
                    ejh.gfn(eji);
                }
            if(dnl == 1 && ejj == 0)
            {
                int l2 = ejh.ggh(eji);
                if(l2 >= 0 && super.fke < 489)
                    if(super.fke > 429)
                        ack(super.aal[l2]);
                    else
                    if(super.aam[l2] != 0)
                    {
                        eie = 2;
                        ejk = super.aal[l2];
                        super.fkn = "";
                        super.fla = "";
                    }
            }
            if(dnl == 1 && ejj == 1)
            {
                int i3 = ejh.ggh(eji);
                if(i3 >= 0 && super.fke < 489 && super.fke > 429)
                    aci(super.aba[i3]);
            }
            if(i1 > 166 && dnl == 1 && ejj == 0)
            {
                eie = 1;
                super.fkl = "";
                super.fkm = "";
            }
            if(i1 > 166 && dnl == 1 && ejj == 1)
            {
                eie = 3;
                super.fkl = "";
                super.fkm = "";
            }
            dnl = 0;
        }
    }

    private final void fca(boolean arg0)
    {
        int l = ((j) (dnb)).blg - 199;
        int i1 = 36;
        dnb.ccb(l - 49, 3, efh + 4);
        char c1 = '\304';
        char c2 = '\266';
        int k1;
        int j1 = k1 = j.cbh(160, 160, 160);
        if(eil == 0)
            j1 = j.cbh(220, 220, 220);
        else
            k1 = j.cbh(220, 220, 220);
        dnb.cam(l, i1, c1 / 2, 24, j1, 128);
        dnb.cam(l + c1 / 2, i1, c1 / 2, 24, k1, 128);
        dnb.cam(l, i1 + 24, c1, 90, j.cbh(220, 220, 220), 128);
        dnb.cam(l, i1 + 24 + 90, c1, c2 - 90 - 24, j.cbh(160, 160, 160), 128);
        dnb.cbc(l, i1 + 24, c1, 0);
        dnb.cbd(l + c1 / 2, i1, 24, 0);
        dnb.cbc(l, i1 + 113, c1, 0);
        dnb.cdl("Magic", l + c1 / 4, i1 + 16, 4, 0);
        dnb.cdl("Prayers", l + c1 / 4 + c1 / 2, i1 + 16, 4, 0);
        if(eil == 0)
        {
            eij.gfm(eik);
            int l1 = 0;
            for(int l2 = 0; l2 < e.ahm; l2++)
            {
                String s1 = "@yel@";
                for(int k4 = 0; k4 < e.amc[l2]; k4++)
                {
                    int j5 = e.ame[l2][k4];
                    if(fdi(j5, e.amf[l2][k4]))
                        continue;
                    s1 = "@whi@";
                    break;
                }

                int k5 = dfk[6];
                if(e.amb[l2] > k5)
                    s1 = "@bla@";
                eij.gga(eik, l1++, s1 + "Level " + e.amb[l2] + ": " + e.akj[l2]);
            }

            eij.ged();
            int l3 = eij.ggh(eik);
            if(l3 != -1)
            {
                dnb.cdn("Level " + e.amb[l3] + ": " + e.akj[l3], l + 2, i1 + 124, 1, 0xffff00);
                dnb.cdn(e.akk[l3], l + 2, i1 + 136, 0, 0xffffff);
                for(int l4 = 0; l4 < e.amc[l3]; l4++)
                {
                    int l5 = e.ame[l3][l4];
                    dnb.ccb(l + 2 + l4 * 44, i1 + 150, efj + e.aie[l5]);
                    int i6 = fac(l5);
                    int j6 = e.amf[l3][l4];
                    String s3 = "@red@";
                    if(fdi(l5, j6))
                        s3 = "@gre@";
                    dnb.cdn(s3 + i6 + "/" + j6, l + 2 + l4 * 44, i1 + 150, 1, 0xffffff);
                }

            } else
            {
                dnb.cdn("Point at a spell for a description", l + 2, i1 + 124, 1, 0);
            }
        }
        if(eil == 1)
        {
            eij.gfm(eik);
            int i2 = 0;
            for(int i3 = 0; i3 < e.ajb; i3++)
            {
                String s2 = "@whi@";
                if(e.ake[i3] > dmf[5])
                    s2 = "@bla@";
                if(eeh[i3])
                    s2 = "@gre@";
                eij.gga(eik, i2++, s2 + "Level " + e.ake[i3] + ": " + e.aim[i3]);
            }

            eij.ged();
            int i4 = eij.ggh(eik);
            if(i4 != -1)
            {
                dnb.cdl("Level " + e.ake[i4] + ": " + e.aim[i4], l + c1 / 2, i1 + 130, 1, 0xffff00);
                dnb.cdl(e.ain[i4], l + c1 / 2, i1 + 145, 0, 0xffffff);
                dnb.cdl("Drain rate: " + e.akf[i4], l + c1 / 2, i1 + 160, 1, 0);
            } else
            {
                dnb.cdn("Point at a prayer for a description", l + 2, i1 + 124, 1, 0);
            }
        }
        if(!arg0)
            return;
        l = super.fke - (((j) (dnb)).blg - 199);
        i1 = super.fkf - 36;
        if(l >= 0 && i1 >= 0 && l < 196 && i1 < 182)
        {
            eij.gea(l + (((j) (dnb)).blg - 199), i1 + 36, super.fkh, super.fkg);
            if(i1 <= 24 && dnl == 1)
                if(l < 98 && eil == 1)
                {
                    eil = 0;
                    eij.gfn(eik);
                } else
                if(l > 98 && eil == 0)
                {
                    eil = 1;
                    eij.gfn(eik);
                }
            if(dnl == 1 && eil == 0)
            {
                int j2 = eij.ggh(eik);
                if(j2 != -1)
                {
                    int j3 = dfk[6];
                    if(e.amb[j2] > j3)
                    {
                        fdj("Your magic ability is not high enough for this spell", 3);
                    } else
                    {
                        int j4;
                        for(j4 = 0; j4 < e.amc[j2]; j4++)
                        {
                            int i5 = e.ame[j2][j4];
                            if(fdi(i5, e.amf[j2][j4]))
                                continue;
                            fdj("You don't have all the reagents you need for this spell", 3);
                            j4 = -1;
                            break;
                        }

                        if(j4 == e.amc[j2])
                        {
                            dil = j2;
                            edi = -1;
                        }
                    }
                }
            }
            if(dnl == 1 && eil == 1)
            {
                int k2 = eij.ggh(eik);
                if(k2 != -1)
                {
                    int k3 = dmf[5];
                    if(e.ake[k2] > k3)
                        fdj("Your prayer ability is not high enough for this prayer", 3);
                    else
                    if(dfk[5] == 0)
                        fdj("You have run out of prayer points. Return to a church to recharge", 3);
                    else
                    if(eeh[k2])
                    {
                        super.aag.hcn(162);
                        super.aag.hdb(k2);
                        super.aag.hdl();
                        eeh[k2] = false;
                        fee("prayeroff");
                    } else
                    {
                        super.aag.hcn(202);
                        super.aag.hdb(k2);
                        super.aag.hdl();
                        eeh[k2] = true;
                        fee("prayeron");
                    }
                }
            }
            dnl = 0;
        }
    }

    protected final byte[] fcb(String arg0, String arg1, int arg2)
    {
        if(!dcn)
            arg0 = "Data/" + arg0;
        byte abyte0[] = link.gaf(arg0);
        if(abyte0 != null)
        {
            int l = ((abyte0[0] & 0xff) << 16) + ((abyte0[1] & 0xff) << 8) + (abyte0[2] & 0xff);
            int i1 = ((abyte0[3] & 0xff) << 16) + ((abyte0[4] & 0xff) << 8) + (abyte0[5] & 0xff);
            byte abyte1[] = new byte[abyte0.length - 6];
            for(int j1 = 0; j1 < abyte0.length - 6; j1++)
                abyte1[j1] = abyte0[j1 + 6];

            flj(arg2, "Unpacking " + arg1);
            if(i1 != l)
            {
                byte abyte2[] = new byte[l];
                g.glj(abyte2, l, abyte1, i1, 0);
                return abyte2;
            } else
            {
                return abyte1;
            }
        } else
        {
            return super.fcb(arg0, arg1, arg2);
        }
    }

    private final void fcc()
    {
        dnb.ccb(0, dci - 4, efh + 23);
        int l = j.cbh(200, 200, 255);
        if(dea == 0)
            l = j.cbh(255, 200, 50);
        if(ehl % 30 > 15)
            l = j.cbh(255, 50, 50);
        dnb.cdl("All messages", 54, dci + 6, 0, l);
        l = j.cbh(200, 200, 255);
        if(dea == 1)
            l = j.cbh(255, 200, 50);
        if(ehm % 30 > 15)
            l = j.cbh(255, 50, 50);
        dnb.cdl("Chat history", 155, dci + 6, 0, l);
        l = j.cbh(200, 200, 255);
        if(dea == 2)
            l = j.cbh(255, 200, 50);
        if(ehn % 30 > 15)
            l = j.cbh(255, 50, 50);
        dnb.cdl("Quest history", 255, dci + 6, 0, l);
        l = j.cbh(200, 200, 255);
        if(dea == 3)
            l = j.cbh(255, 200, 50);
        if(eia % 30 > 15)
            l = j.cbh(255, 50, 50);
        dnb.cdl("Private history", 355, dci + 6, 0, l);
        dnb.cdl("Report abuse", 457, dci + 6, 0, 0xffffff);
    }

    public final URL getDocumentBase()
    {
        if(link.fni != null)
            return link.fni.getDocumentBase();
        else
            return super.getDocumentBase();
    }

    private final void fcd()
    {
        if(deg > 1)
            deg--;
        acd();
        if(ehb > 0)
            ehb--;
        if(super.fil > 4500 && ebd == 0 && ehb == 0)
        {
            super.fil -= 500;
            fad();
            return;
        }
        if(djc.gml == 8 || djc.gml == 9)
            ebd = 500;
        if(ebd > 0)
            ebd--;
        if(eln)
        {
            faa();
            return;
        }
        for(int l = 0; l < dgm; l++)
        {
            f f1 = deh[l];
            int j1 = (f1.gna + 1) % 10;
            if(f1.gmn != j1)
            {
                int l1 = -1;
                int k3 = f1.gmn;
                int i5;
                if(k3 < j1)
                    i5 = j1 - k3;
                else
                    i5 = (10 + j1) - k3;
                int i6 = 4;
                if(i5 > 2)
                    i6 = (i5 - 1) * 4;
                if(f1.gnb[k3] - f1.gmh > ehd * 3 || f1.gnc[k3] - f1.gmi > ehd * 3 || f1.gnb[k3] - f1.gmh < -ehd * 3 || f1.gnc[k3] - f1.gmi < -ehd * 3 || i5 > 8)
                {
                    f1.gmh = f1.gnb[k3];
                    f1.gmi = f1.gnc[k3];
                } else
                {
                    if(f1.gmh < f1.gnb[k3])
                    {
                        f1.gmh += i6;
                        f1.gmk++;
                        l1 = 2;
                    } else
                    if(f1.gmh > f1.gnb[k3])
                    {
                        f1.gmh -= i6;
                        f1.gmk++;
                        l1 = 6;
                    }
                    if(f1.gmh - f1.gnb[k3] < i6 && f1.gmh - f1.gnb[k3] > -i6)
                        f1.gmh = f1.gnb[k3];
                    if(f1.gmi < f1.gnc[k3])
                    {
                        f1.gmi += i6;
                        f1.gmk++;
                        if(l1 == -1)
                            l1 = 4;
                        else
                        if(l1 == 2)
                            l1 = 3;
                        else
                            l1 = 5;
                    } else
                    if(f1.gmi > f1.gnc[k3])
                    {
                        f1.gmi -= i6;
                        f1.gmk++;
                        if(l1 == -1)
                            l1 = 0;
                        else
                        if(l1 == 2)
                            l1 = 1;
                        else
                            l1 = 7;
                    }
                    if(f1.gmi - f1.gnc[k3] < i6 && f1.gmi - f1.gnc[k3] > -i6)
                        f1.gmi = f1.gnc[k3];
                }
                if(l1 != -1)
                    f1.gml = l1;
                if(f1.gmh == f1.gnb[k3] && f1.gmi == f1.gnc[k3])
                    f1.gmn = (k3 + 1) % 10;
            } else
            {
                f1.gml = f1.gmm;
            }
            if(f1.gnf > 0)
                f1.gnf--;
            if(f1.gnh > 0)
                f1.gnh--;
            if(f1.gnl > 0)
                f1.gnl--;
            if(dgb > 0)
            {
                dgb--;
                if(dgb == 0)
                    fdj("You have been granted another life. Be more careful this time!", 3);
                if(dgb == 0)
                    fdj("You retain your skills. Your objects land where you died", 3);
            }
        }

        for(int i1 = 0; i1 < ebb; i1++)
        {
            f f2 = dgf[i1];
            int i2 = (f2.gna + 1) % 10;
            if(f2.gmn != i2)
            {
                int l3 = -1;
                int j5 = f2.gmn;
                int j6;
                if(j5 < i2)
                    j6 = i2 - j5;
                else
                    j6 = (10 + i2) - j5;
                int k6 = 4;
                if(j6 > 2)
                    k6 = (j6 - 1) * 4;
                if(f2.gnb[j5] - f2.gmh > ehd * 3 || f2.gnc[j5] - f2.gmi > ehd * 3 || f2.gnb[j5] - f2.gmh < -ehd * 3 || f2.gnc[j5] - f2.gmi < -ehd * 3 || j6 > 8)
                {
                    f2.gmh = f2.gnb[j5];
                    f2.gmi = f2.gnc[j5];
                } else
                {
                    if(f2.gmh < f2.gnb[j5])
                    {
                        f2.gmh += k6;
                        f2.gmk++;
                        l3 = 2;
                    } else
                    if(f2.gmh > f2.gnb[j5])
                    {
                        f2.gmh -= k6;
                        f2.gmk++;
                        l3 = 6;
                    }
                    if(f2.gmh - f2.gnb[j5] < k6 && f2.gmh - f2.gnb[j5] > -k6)
                        f2.gmh = f2.gnb[j5];
                    if(f2.gmi < f2.gnc[j5])
                    {
                        f2.gmi += k6;
                        f2.gmk++;
                        if(l3 == -1)
                            l3 = 4;
                        else
                        if(l3 == 2)
                            l3 = 3;
                        else
                            l3 = 5;
                    } else
                    if(f2.gmi > f2.gnc[j5])
                    {
                        f2.gmi -= k6;
                        f2.gmk++;
                        if(l3 == -1)
                            l3 = 0;
                        else
                        if(l3 == 2)
                            l3 = 1;
                        else
                            l3 = 7;
                    }
                    if(f2.gmi - f2.gnc[j5] < k6 && f2.gmi - f2.gnc[j5] > -k6)
                        f2.gmi = f2.gnc[j5];
                }
                if(l3 != -1)
                    f2.gml = l3;
                if(f2.gmh == f2.gnb[j5] && f2.gmi == f2.gnc[j5])
                    f2.gmn = (j5 + 1) % 10;
            } else
            {
                f2.gml = f2.gmm;
                if(f2.gmj == 43)
                    f2.gmk++;
            }
            if(f2.gnf > 0)
                f2.gnf--;
            if(f2.gnh > 0)
                f2.gnh--;
            if(f2.gnl > 0)
                f2.gnl--;
        }

        if(egf != 2)
        {
            if(j.bnn > 0)
                ejn++;
            if(j.caa > 0)
                ejn = 0;
            j.bnn = 0;
            j.caa = 0;
        }
        for(int k1 = 0; k1 < dgm; k1++)
        {
            f f3 = deh[k1];
            if(f3.hag > 0)
                f3.hag--;
        }

        if(dim)
        {
            if(dgc - djc.gmh < -500 || dgc - djc.gmh > 500 || dgd - djc.gmi < -500 || dgd - djc.gmi > 500)
            {
                dgc = djc.gmh;
                dgd = djc.gmi;
            }
        } else
        {
            if(dgc - djc.gmh < -500 || dgc - djc.gmh > 500 || dgd - djc.gmi < -500 || dgd - djc.gmi > 500)
            {
                dgc = djc.gmh;
                dgd = djc.gmi;
            }
            if(dgc != djc.gmh)
                dgc += (djc.gmh - dgc) / (16 + (eac - 500) / 15);
            if(dgd != djc.gmi)
                dgd += (djc.gmi - dgd) / (16 + (eac - 500) / 15);
            if(dka)
            {
                int j2 = eli * 32;
                int i4 = j2 - dkg;
                byte byte0 = 1;
                if(i4 != 0)
                {
                    elj++;
                    if(i4 > 128)
                    {
                        byte0 = -1;
                        i4 = 256 - i4;
                    } else
                    if(i4 > 0)
                        byte0 = 1;
                    else
                    if(i4 < -128)
                    {
                        byte0 = 1;
                        i4 = 256 + i4;
                    } else
                    if(i4 < 0)
                    {
                        byte0 = -1;
                        i4 = -i4;
                    }
                    dkg += ((elj * i4 + 255) / 256) * byte0;
                    dkg &= 0xff;
                } else
                {
                    elj = 0;
                }
            }
        }
        if(ejn > 20)
        {
            djn = false;
            ejn = 0;
        }
        if(den)
        {
            if(super.fkm.length() > 0)
                if(super.fkm.equalsIgnoreCase("::lostcon") && !dcn)
                    super.aag.baj();
                else
                if(super.fkm.equalsIgnoreCase("::closecon") && !dcn)
                {
                    aca();
                } else
                {
                    super.aag.hcn(142);
                    super.aag.hdc(super.fkm);
                    if(!djn)
                    {
                        super.aag.hdb(0);
                        djn = true;
                    }
                    super.aag.hdl();
                    super.fkl = "";
                    super.fkm = "";
                    del = "Please wait...";
                }
            if(super.fkh == 1 && super.fkf > 275 && super.fkf < 310 && super.fke > 56 && super.fke < 456)
            {
                super.aag.hcn(142);
                super.aag.hdc("-null-");
                if(!djn)
                {
                    super.aag.hdb(0);
                    djn = true;
                }
                super.aag.hdl();
                super.fkl = "";
                super.fkm = "";
                del = "Please wait...";
            }
            super.fkh = 0;
            return;
        }
        if(super.fkf > dci - 4)
        {
            if(super.fke > 15 && super.fke < 96 && super.fkh == 1)
                dea = 0;
            if(super.fke > 110 && super.fke < 194 && super.fkh == 1)
            {
                dea = 1;
                ddj.gbc[ddk] = 0xf423f;
            }
            if(super.fke > 215 && super.fke < 295 && super.fkh == 1)
            {
                dea = 2;
                ddj.gbc[ddm] = 0xf423f;
            }
            if(super.fke > 315 && super.fke < 395 && super.fkh == 1)
            {
                dea = 3;
                ddj.gbc[ddn] = 0xf423f;
            }
            if(super.fke > 417 && super.fke < 497 && super.fkh == 1)
            {
                dmh = 1;
                elc = 0;
                super.fkl = "";
                super.fkm = "";
            }
            super.fkh = 0;
            super.fkg = 0;
        }
        ddj.gea(super.fke, super.fkf, super.fkh, super.fkg);
        if(dea > 0 && super.fke >= 494 && super.fkf >= dci - 66)
            super.fkh = 0;
        if(ddj.geb(ddl))
        {
            String s = ddj.ggd(ddl);
            ddj.ggc(ddl, "");
            if(s.startsWith("/"))
            {
                s = s.trim().toLowerCase().substring(1);
                if(s.startsWith("run("))
                {
                    String s1 = s.substring(s.indexOf('(') + 1, s.indexOf(')') + 1);
                    loadscript(path + "Scripts/" + arg(s1, 1) + ".txt");
                    if(scriptno > 0)
                        smacro = new script();
                    else
                        fdj("No script loaded", 3);
                } else
                if(s.startsWith("stop()"))
                {
                    fdj("Script stopped on line " + counter, 3);
                    counter = 9999;
                } else
            {
                int j4 = v.cek(s);
                acm(v.ceg, j4);
                s = v.cej(v.ceg, 0, j4);
                s = u.fgd(s);
                djc.gnf = 150;
                djc.gne = s;
                fdj(djc.gme + ": " + s, 2);
            }
		}
        }
        if(dea == 0)
        {
            for(int k2 = 0; k2 < 5; k2++)
                if(eib[k2] > 0)
                    eib[k2]--;

        }
        if(dgb != 0)
            super.fkh = 0;
        if(dge || eld)
        {
            if(super.fkg != 0)
                eka++;
            else
                eka = 0;
            if(eka > 600)
                ekb += 5000;
            else
            if(eka > 450)
                ekb += 500;
            else
            if(eka > 300)
                ekb += 50;
            else
            if(eka > 150)
                ekb += 5;
            else
            if(eka > 50)
                ekb++;
            else
            if(eka > 20 && (eka & 5) == 0)
                ekb++;
        } else
        {
            eka = 0;
            ekb = 0;
        }
        if(super.fkh == 1)
            dnl = 1;
        else
        if(super.fkh == 2)
            dnl = 2;
        ejg.bhg(super.fke, super.fkf);
        super.fkh = 0;
        if(dka)
        {
            if(elj == 0 || dim)
            {
                if(super.fjl)
                {
                    eli = eli + 1 & 7;
                    super.fjl = false;
                    if(!ebg)
                    {
                        if((eli & 1) == 0)
                            eli = eli + 1 & 7;
                        for(int l2 = 0; l2 < 8; l2++)
                        {
                            if(eng(eli))
                                break;
                            eli = eli + 1 & 7;
                        }

                    }
                }
                if(super.fjm)
                {
                    eli = eli + 7 & 7;
                    super.fjm = false;
                    if(!ebg)
                    {
                        if((eli & 1) == 0)
                            eli = eli + 7 & 7;
                        for(int i3 = 0; i3 < 8; i3++)
                        {
                            if(eng(eli))
                                break;
                            eli = eli + 7 & 7;
                        }

                    }
                }
            }
        } else
        if(super.fjl)
            dkg = dkg + 2 & 0xff;
        else
        if(super.fjm)
            dkg = dkg - 2 & 0xff;
        if(ebg && eac > 550)
            eac -= 4;
        else
        if(!ebg && eac < 750)
            eac += 4;
        if(emb > 0)
            emb--;
        else
        if(emb < 0)
            emb++;
        ejg.bji(17);
        edd++;
        if(edd > 5)
        {
            edd = 0;
            dfa = (dfa + 1) % 3;
            dfb = (dfb + 1) % 4;
            dfc = (dfc + 1) % 5;
        }
        for(int j3 = 0; j3 < efd; j3++)
        {
            int k4 = ekm[j3];
            int k5 = ekn[j3];
            if(k4 >= 0 && k5 >= 0 && k4 < 96 && k5 < 96 && ela[j3] == 74)
                dik[j3].cmi(1, 0, 0);
        }

        for(int l4 = 0; l4 < eig; l4++)
        {
            egn[l4]++;
            if(egn[l4] > 50)
            {
                eig--;
                for(int l5 = l4; l5 < eig; l5++)
                {
                    ell[l5] = ell[l5 + 1];
                    elh[l5] = elh[l5 + 1];
                    egn[l5] = egn[l5 + 1];
                    ehg[l5] = ehg[l5 + 1];
                }

            }
        }

    }

    private final void fce()
    {
        dgk = new h(dnb, 100);
        dgk.gfd(256, 10, "Please design Your Character", 4, true);
        int l = 140;
        int i1 = 34;
        l += 116;
        i1 -= 10;
        dgk.gfd(l - 55, i1 + 110, "Front", 3, true);
        dgk.gfd(l, i1 + 110, "Side", 3, true);
        dgk.gfd(l + 55, i1 + 110, "Back", 3, true);
        byte byte0 = 54;
        i1 += 145;
        dgk.gff(l - byte0, i1, 53, 41);
        dgk.gfd(l - byte0, i1 - 8, "Head", 1, true);
        dgk.gfd(l - byte0, i1 + 8, "Type", 1, true);
        dgk.gfg(l - byte0 - 40, i1, h.gdi + 7);
        dlb = dgk.gfl(l - byte0 - 40, i1, 20, 20);
        dgk.gfg((l - byte0) + 40, i1, h.gdi + 6);
        dlc = dgk.gfl((l - byte0) + 40, i1, 20, 20);
        dgk.gff(l + byte0, i1, 53, 41);
        dgk.gfd(l + byte0, i1 - 8, "Hair", 1, true);
        dgk.gfd(l + byte0, i1 + 8, "Color", 1, true);
        dgk.gfg((l + byte0) - 40, i1, h.gdi + 7);
        dld = dgk.gfl((l + byte0) - 40, i1, 20, 20);
        dgk.gfg(l + byte0 + 40, i1, h.gdi + 6);
        dle = dgk.gfl(l + byte0 + 40, i1, 20, 20);
        i1 += 50;
        dgk.gff(l - byte0, i1, 53, 41);
        dgk.gfd(l - byte0, i1, "Gender", 1, true);
        dgk.gfg(l - byte0 - 40, i1, h.gdi + 7);
        dlf = dgk.gfl(l - byte0 - 40, i1, 20, 20);
        dgk.gfg((l - byte0) + 40, i1, h.gdi + 6);
        dlg = dgk.gfl((l - byte0) + 40, i1, 20, 20);
        dgk.gff(l + byte0, i1, 53, 41);
        dgk.gfd(l + byte0, i1 - 8, "Top", 1, true);
        dgk.gfd(l + byte0, i1 + 8, "Color", 1, true);
        dgk.gfg((l + byte0) - 40, i1, h.gdi + 7);
        dlh = dgk.gfl((l + byte0) - 40, i1, 20, 20);
        dgk.gfg(l + byte0 + 40, i1, h.gdi + 6);
        dli = dgk.gfl(l + byte0 + 40, i1, 20, 20);
        i1 += 50;
        dgk.gff(l - byte0, i1, 53, 41);
        dgk.gfd(l - byte0, i1 - 8, "Skin", 1, true);
        dgk.gfd(l - byte0, i1 + 8, "Color", 1, true);
        dgk.gfg(l - byte0 - 40, i1, h.gdi + 7);
        dlj = dgk.gfl(l - byte0 - 40, i1, 20, 20);
        dgk.gfg((l - byte0) + 40, i1, h.gdi + 6);
        dlk = dgk.gfl((l - byte0) + 40, i1, 20, 20);
        dgk.gff(l + byte0, i1, 53, 41);
        dgk.gfd(l + byte0, i1 - 8, "Bottom", 1, true);
        dgk.gfd(l + byte0, i1 + 8, "Color", 1, true);
        dgk.gfg((l + byte0) - 40, i1, h.gdi + 7);
        dll = dgk.gfl((l + byte0) - 40, i1, 20, 20);
        dgk.gfg(l + byte0 + 40, i1, h.gdi + 6);
        dlm = dgk.gfl(l + byte0 + 40, i1, 20, 20);
        i1 += 82;
        i1 -= 35;
        dgk.gfe(l, i1, 200, 30);
        dgk.gfd(l, i1, "Accept", 4, false);
        dln = dgk.gfl(l, i1, 200, 30);
    }

    protected final void fcf(int l)
    {

	if(l == 1019)
	{
		autologin = !autologin; 
		if(autologin)
		fdj(BotName + " : " + "Autologin enabled for " + ekc + "", 3); 
		else 
		fdj(BotName + " : " + "Autologin disabled", 3); 
	}

	if(l == 1018)
	{
		statmenu = !statmenu; 
		if(statmenu) 
		fdj(BotName + " : " + "Statmenu enabled for " + ekc + "", 3); 
		else 
		fdj(BotName + " : " + "Statmenu disabled", 3); 
	}



        	if(l == 27)//Escape
        	{ 
        	System.out.println("Goodbye " + ekc);
		aca();
		wait(10);
        	System.exit(0);
        	}

        if(ehe == 0)
        {
            if(ecf == 0)
                eki.gec(l);
            if(ecf == 1)
                dnm.gec(l);
            if(ecf == 2)
                dla.gec(l);
        }
        if(ehe == 1)
        {
            if(eln)
            {
                dgk.gec(l);
                return;
            }
            if(eie == 0 && dmh == 0 && !den)
                ddj.gec(l);
        }
    }

    private final void fcg()
    {
        int l = 2203 - (dje + eaj + dnj);
        if(djd + eai + dni >= 2640)
            l = -50;
        int i1 = -1;
        for(int j1 = 0; j1 < efd; j1++)
            dij[j1] = false;

        for(int k1 = 0; k1 < ehc; k1++)
            eah[k1] = false;

        int l1 = ejg.bhh();
        i ai[] = ejg.bhj();
        int ai1[] = ejg.bhi();
        for(int i2 = 0; i2 < l1; i2++)
        {
            if(ejf > 200)
                break;
            int j2 = ai1[i2];
            i l2 = ai[i2];
            if(l2.chl[j2] <= 65535 || l2.chl[j2] >= 0x30d40 && l2.chl[j2] <= 0x493e0)
                if(l2 == ejg.beh)
                {
                    int i3 = l2.chl[j2] % 10000;
                    int l3 = l2.chl[j2] / 10000;
                    if(l3 == 1)
                    {
                        String s1 = "";
                        int k4 = 0;
                        if(djc.gnm > 0 && deh[i3].gnm > 0)
                            k4 = djc.gnm - deh[i3].gnm;
                        if(k4 < 0)
                            s1 = "@or1@";
                        if(k4 < -3)
                            s1 = "@or2@";
                        if(k4 < -6)
                            s1 = "@or3@";
                        if(k4 < -9)
                            s1 = "@red@";
                        if(k4 > 0)
                            s1 = "@gr1@";
                        if(k4 > 3)
                            s1 = "@gr2@";
                        if(k4 > 6)
                            s1 = "@gr3@";
                        if(k4 > 9)
                            s1 = "@gre@";
                        s1 = " " + s1 + "(level-" + deh[i3].gnm + ")";
                        if(dil >= 0)
                        {
                            if(e.amd[dil] == 1 || e.amd[dil] == 2)
                            {
                                dem[ejf] = "Cast " + e.akj[dil] + " on";
                                ejm[ejf] = "@whi@" + deh[i3].gme + s1;
                                dga[ejf] = 800;
                                dfl[ejf] = deh[i3].gmh;
                                dfm[ejf] = deh[i3].gmi;
                                djk[ejf] = deh[i3].gmf;
                                djl[ejf] = dil;
                                ejf++;
                            }
                        } else
                        if(edi >= 0)
                        {
                            dem[ejf] = "Use " + edj + " with";
                            ejm[ejf] = "@whi@" + deh[i3].gme + s1;
                            dga[ejf] = 810;
                            dfl[ejf] = deh[i3].gmh;
                            dfm[ejf] = deh[i3].gmi;
                            djk[ejf] = deh[i3].gmf;
                            djl[ejf] = edi;
                            ejf++;
                        } else
                        {
                            if(l > 0 && (deh[i3].gmi - 64) / ehd + eaj + dnj < 2203)
                            {
                                dem[ejf] = "Attack";
                                ejm[ejf] = "@whi@" + deh[i3].gme + s1;
                                if(k4 >= 0 && k4 < 5)
                                    dga[ejf] = 805;
                                else
                                    dga[ejf] = 2805;
                                dfl[ejf] = deh[i3].gmh;
                                dfm[ejf] = deh[i3].gmi;
                                djk[ejf] = deh[i3].gmf;
                                ejf++;
                            } else
                            if(egi)
                            {
                                dem[ejf] = "Duel with";
                                ejm[ejf] = "@whi@" + deh[i3].gme + s1;
                                dfl[ejf] = deh[i3].gmh;
                                dfm[ejf] = deh[i3].gmi;
                                dga[ejf] = 2806;
                                djk[ejf] = deh[i3].gmf;
                                ejf++;
                            }
                            dem[ejf] = "Trade with";
                            ejm[ejf] = "@whi@" + deh[i3].gme + s1;
                            dga[ejf] = 2810;
                            djk[ejf] = deh[i3].gmf;
                            ejf++;
                            dem[ejf] = "Follow";
                            ejm[ejf] = "@whi@" + deh[i3].gme + s1;
                            dga[ejf] = 2820;
                            djk[ejf] = deh[i3].gmf;
                            ejf++;
                        }
                    } else
                    if(l3 == 2)
                    {
                        if(dil >= 0)
                        {
                            if(e.amd[dil] == 3)
                            {
                                dem[ejf] = "Cast " + e.akj[dil] + " on";
                                ejm[ejf] = "@lre@" + e.aib[dmn[i3]];
                                dga[ejf] = 200;
                                dfl[ejf] = dml[i3];
                                dfm[ejf] = dmm[i3];
                                djk[ejf] = dmn[i3];
                                djl[ejf] = dil;
                                ejf++;
                            }
                        } else
                        if(edi >= 0)
                        {
                            dem[ejf] = "Use " + edj + " with";
                            ejm[ejf] = "@lre@" + e.aib[dmn[i3]];
                            dga[ejf] = 210;
                            dfl[ejf] = dml[i3];
                            dfm[ejf] = dmm[i3];
                            djk[ejf] = dmn[i3];
                            djl[ejf] = edi;
                            ejf++;
                        } else
                        {
                            dem[ejf] = "Take";
                            ejm[ejf] = "@lre@" + e.aib[dmn[i3]];
                            dga[ejf] = 220;
                            dfl[ejf] = dml[i3];
                            dfm[ejf] = dmm[i3];
                            djk[ejf] = dmn[i3];
                            ejf++;
                            dem[ejf] = "Examine";
                            ejm[ejf] = "@lre@" + e.aib[dmn[i3]];
                            dga[ejf] = 3200;
                            djk[ejf] = dmn[i3];
                            ejf++;
                        }
                    } else
                    if(l3 == 3)
                    {
                        String s2 = "";
                        int l4 = -1;
                        int i5 = dgf[i3].gmj;
                        if(e.alf[i5] > 0)
                        {
                            int j5 = (e.alb[i5] + e.ale[i5] + e.alc[i5] + e.ald[i5]) / 4;
                            int k5 = (dmf[0] + dmf[1] + dmf[2] + dmf[3] + 27) / 4;
                            l4 = k5 - j5;
                            s2 = "@yel@";
                            if(l4 < 0)
                                s2 = "@or1@";
                            if(l4 < -3)
                                s2 = "@or2@";
                            if(l4 < -6)
                                s2 = "@or3@";
                            if(l4 < -9)
                                s2 = "@red@";
                            if(l4 > 0)
                                s2 = "@gr1@";
                            if(l4 > 3)
                                s2 = "@gr2@";
                            if(l4 > 6)
                                s2 = "@gr3@";
                            if(l4 > 9)
                                s2 = "@gre@";
                            s2 = " " + s2 + "(level-" + j5 + ")";
                        }
                        if(dil >= 0)
                        {
                            if(e.amd[dil] == 2)
                            {
                                dem[ejf] = "Cast " + e.akj[dil] + " on";
                                ejm[ejf] = "@yel@" + e.ahd[dgf[i3].gmj];
                                dga[ejf] = 700;
                                dfl[ejf] = dgf[i3].gmh;
                                dfm[ejf] = dgf[i3].gmi;
                                djk[ejf] = dgf[i3].gmf;
                                djl[ejf] = dil;
                                ejf++;
                            }
                        } else
                        if(edi >= 0)
                        {
                            dem[ejf] = "Use " + edj + " with";
                            ejm[ejf] = "@yel@" + e.ahd[dgf[i3].gmj];
                            dga[ejf] = 710;
                            dfl[ejf] = dgf[i3].gmh;
                            dfm[ejf] = dgf[i3].gmi;
                            djk[ejf] = dgf[i3].gmf;
                            djl[ejf] = edi;
                            ejf++;
                        } else
                        {
                            if(e.alf[i5] > 0)
                            {
                                dem[ejf] = "Attack";
                                ejm[ejf] = "@yel@" + e.ahd[dgf[i3].gmj] + s2;
                                if(l4 >= 0)
                                    dga[ejf] = 715;
                                else
                                    dga[ejf] = 2715;
                                dfl[ejf] = dgf[i3].gmh;
                                dfm[ejf] = dgf[i3].gmi;
                                djk[ejf] = dgf[i3].gmf;
                                ejf++;
                            }
                            dem[ejf] = "Talk-to";
                            ejm[ejf] = "@yel@" + e.ahd[dgf[i3].gmj];
                            dga[ejf] = 720;
                            dfl[ejf] = dgf[i3].gmh;
                            dfm[ejf] = dgf[i3].gmi;
                            djk[ejf] = dgf[i3].gmf;
                            ejf++;
                            if(!e.ahf[i5].equals(""))
                            {
                                dem[ejf] = e.ahf[i5];
                                ejm[ejf] = "@yel@" + e.ahd[dgf[i3].gmj];
                                dga[ejf] = 725;
                                dfl[ejf] = dgf[i3].gmh;
                                dfm[ejf] = dgf[i3].gmi;
                                djk[ejf] = dgf[i3].gmf;
                                ejf++;
                            }
                            dem[ejf] = "Examine";
                            ejm[ejf] = "@yel@" + e.ahd[dgf[i3].gmj];
                            dga[ejf] = 3700;
                            djk[ejf] = dgf[i3].gmj;
                            ejf++;
                        }
                    }
                } else
                if(l2 != null && l2.chk >= 10000)
                {
                    int j3 = l2.chk - 10000;
                    int i4 = eda[j3];
                    if(!eah[j3])
                    {
                        if(dil >= 0)
                        {
                            if(e.amd[dil] == 4)
                            {
                                dem[ejf] = "Cast " + e.akj[dil] + " on";
                                ejm[ejf] = "@cya@" + e.ahi[i4];
                                dga[ejf] = 300;
                                dfl[ejf] = dhg[j3];
                                dfm[ejf] = dhh[j3];
                                djk[ejf] = ecn[j3];
                                djl[ejf] = dil;
                                ejf++;
                            }
                        } else
                        if(edi >= 0)
                        {
                            dem[ejf] = "Use " + edj + " with";
                            ejm[ejf] = "@cya@" + e.ahi[i4];
                            dga[ejf] = 310;
                            dfl[ejf] = dhg[j3];
                            dfm[ejf] = dhh[j3];
                            djk[ejf] = ecn[j3];
                            djl[ejf] = edi;
                            ejf++;
                        } else
                        {
                            if(!e.ahk[i4].equalsIgnoreCase("WalkTo"))
                            {
                                dem[ejf] = e.ahk[i4];
                                ejm[ejf] = "@cya@" + e.ahi[i4];
                                dga[ejf] = 320;
                                dfl[ejf] = dhg[j3];
                                dfm[ejf] = dhh[j3];
                                djk[ejf] = ecn[j3];
                                ejf++;
                            }
                            if(!e.ahl[i4].equalsIgnoreCase("Examine"))
                            {
                                dem[ejf] = e.ahl[i4];
                                ejm[ejf] = "@cya@" + e.ahi[i4];
                                dga[ejf] = 2300;
                                dfl[ejf] = dhg[j3];
                                dfm[ejf] = dhh[j3];
                                djk[ejf] = ecn[j3];
                                ejf++;
                            }
                            dem[ejf] = "Examine";
                            ejm[ejf] = "@cya@" + e.ahi[i4];
                            dga[ejf] = 3300;
                            djk[ejf] = i4;
                            ejf++;
                        }
                        eah[j3] = true;
                    }
                } else
                if(l2 != null && l2.chk >= 0)
                {
                    int k3 = l2.chk;
                    int j4 = ela[k3];
                    if(!dij[k3])
                    {
                        if(dil >= 0)
                        {
                            if(e.amd[dil] == 5)
                            {
                                dem[ejf] = "Cast " + e.akj[dil] + " on";
                                ejm[ejf] = "@cya@" + e.ajm[j4];
                                dga[ejf] = 400;
                                dfl[ejf] = ekm[k3];
                                dfm[ejf] = ekn[k3];
                                djk[ejf] = elb[k3];
                                djl[ejf] = ela[k3];
                                djm[ejf] = dil;
                                ejf++;
                            }
                        } else
                        if(edi >= 0)
                        {
                            dem[ejf] = "Use " + edj + " with";
                            ejm[ejf] = "@cya@" + e.ajm[j4];
                            dga[ejf] = 410;
                            dfl[ejf] = ekm[k3];
                            dfm[ejf] = ekn[k3];
                            djk[ejf] = elb[k3];
                            djl[ejf] = ela[k3];
                            djm[ejf] = edi;
                            ejf++;
                        } else
                        {
                            if(!e.aka[j4].equalsIgnoreCase("WalkTo"))
                            {
                                dem[ejf] = e.aka[j4];
                                ejm[ejf] = "@cya@" + e.ajm[j4];
                                dga[ejf] = 420;
                                dfl[ejf] = ekm[k3];
                                dfm[ejf] = ekn[k3];
                                djk[ejf] = elb[k3];
                                djl[ejf] = ela[k3];
                                ejf++;
                            }
                            if(!e.akb[j4].equalsIgnoreCase("Examine"))
                            {
                                dem[ejf] = e.akb[j4];
                                ejm[ejf] = "@cya@" + e.ajm[j4];
                                dga[ejf] = 2400;
                                dfl[ejf] = ekm[k3];
                                dfm[ejf] = ekn[k3];
                                djk[ejf] = elb[k3];
                                djl[ejf] = ela[k3];
                                ejf++;
                            }
                            dem[ejf] = "Examine";
                            ejm[ejf] = "@cya@" + e.ajm[j4];
                            dga[ejf] = 3400;
                            djk[ejf] = j4;
                            ejf++;
                        }
                        dij[k3] = true;
                    }
                } else
                {
                    if(j2 >= 0)
                        j2 = l2.chl[j2] - 0x30d40;
                    if(j2 >= 0)
                        i1 = j2;
                }
        }

        if(dil >= 0 && e.amd[dil] <= 1)
        {
            dem[ejf] = "Cast " + e.akj[dil] + " on self";
            ejm[ejf] = "";
            dga[ejf] = 1000;
            djk[ejf] = dil;
            ejf++;
        }
        if(i1 != -1)
        {
            int k2 = i1;
            if(dil >= 0)
            {
                if(e.amd[dil] == 6)
                {
                    dem[ejf] = "Cast " + e.akj[dil] + " on ground";
                    ejm[ejf] = "";
                    dga[ejf] = 900;
                    dfl[ejf] = dnh.gin[k2];
                    dfm[ejf] = dnh.ghk[k2];
                    djk[ejf] = dil;
                    ejf++;
                    return;
                }
            } else
            if(edi < 0)
            {
                dem[ejf] = "Walk here";
                ejm[ejf] = "";
                dga[ejf] = 920;
                dfl[ejf] = dnh.gin[k2];
                dfm[ejf] = dnh.ghk[k2];
                ejf++;
            }
        }
    }

    private final void fch()
    {
        if(dnl != 0)
        {
            dnl = 0;
            int l = super.fke - 52;
            int i1 = super.fkf - 44;
            if(l >= 0 && i1 >= 12 && l < 408 && i1 < 246)
            {
                int j1 = 0;
                for(int l1 = 0; l1 < 5; l1++)
                {
                    for(int l2 = 0; l2 < 8; l2++)
                    {
                        int k3 = 7 + l2 * 49;
                        int k4 = 28 + l1 * 34;
                        if(l > k3 && l < k3 + 49 && i1 > k4 && i1 < k4 + 34 && efa[j1] != -1)
                        {
                            dej = j1;
                            dek = efa[j1];
                        }
                        j1++;
                    }

                }

                if(dej >= 0)
                {
                    int i3 = efa[dej];
                    if(i3 != -1)
                    {
                        if(efb[dej] > 0 && l > 298 && i1 >= 204 && l < 408 && i1 <= 215)
                        {
                            int l3 = dmd + efc[dej];
                            if(l3 < 10)
                                l3 = 10;
                            int l4 = (l3 * e.aif[i3]) / 100;
                            super.aag.hcn(67);
                            super.aag.hdj(efa[dej]);
                            super.aag.hdh(l4);
                            super.aag.hdl();
                        }
                        if(fac(i3) > 0 && l > 2 && i1 >= 229 && l < 112 && i1 <= 240)
                        {
                            int i4 = dmc + efc[dej];
                            if(i4 < 10)
                                i4 = 10;
                            int i5 = (i4 * e.aif[i3]) / 100;
                            super.aag.hcn(177);
                            super.aag.hdj(efa[dej]);
                            super.aag.hdh(i5);
                            super.aag.hdl();
                        }
                    }
                }
            } else
            {
                super.aag.hcn(92);
                super.aag.hdl();
                dmk = false;
                return;
            }
        }
        byte byte0 = 52;
        byte byte1 = 44;
        dnb.cba(byte0, byte1, 408, 12, 192);
        int k1 = 0x989898;
        dnb.cam(byte0, byte1 + 12, 408, 17, k1, 160);
        dnb.cam(byte0, byte1 + 29, 8, 170, k1, 160);
        dnb.cam(byte0 + 399, byte1 + 29, 9, 170, k1, 160);
        dnb.cam(byte0, byte1 + 199, 408, 47, k1, 160);
        dnb.cdn("Buying and selling items", byte0 + 1, byte1 + 10, 1, 0xffffff);
        int i2 = 0xffffff;
        if(super.fke > byte0 + 320 && super.fkf >= byte1 && super.fke < byte0 + 408 && super.fkf < byte1 + 12)
            i2 = 0xff0000;
        dnb.cdk("Close window", byte0 + 406, byte1 + 10, 1, i2);
        dnb.cdn("Shops stock in green", byte0 + 2, byte1 + 24, 1, 65280);
        dnb.cdn("Number you own in blue", byte0 + 135, byte1 + 24, 1, 65535);
        dnb.cdn("Your money: " + fac(10) + "gp", byte0 + 280, byte1 + 24, 1, 0xffff00);
        int j3 = 0xd0d0d0;
        int j4 = 0;
        for(int j5 = 0; j5 < 5; j5++)
        {
            for(int k5 = 0; k5 < 8; k5++)
            {
                int i6 = byte0 + 7 + k5 * 49;
                int l6 = byte1 + 28 + j5 * 34;
                if(dej == j4)
                    dnb.cam(i6, l6, 49, 34, 0xff0000, 160);
                else
                    dnb.cam(i6, l6, 49, 34, j3, 160);
                dnb.cbb(i6, l6, 50, 35, 0);
                if(efa[j4] != -1)
                {
                    dnb.cdd(i6, l6, 48, 32, efj + e.aie[efa[j4]], e.aij[efa[j4]], 0, 0, false);
                    dnb.cdn(String.valueOf(efb[j4]), i6 + 1, l6 + 10, 1, 65280);
                    dnb.cdk(String.valueOf(fac(efa[j4])), i6 + 47, l6 + 10, 1, 65535);
                }
                j4++;
            }

        }

        dnb.cbc(byte0 + 5, byte1 + 222, 398, 0);
        if(dej == -1)
        {
            dnb.cdl("Select an object to buy or sell", byte0 + 204, byte1 + 214, 3, 0xffff00);
            return;
        }
        int l5 = efa[dej];
        if(l5 != -1)
        {
            if(efb[dej] > 0)
            {
                int j6 = dmd + efc[dej];
                if(j6 < 10)
                    j6 = 10;
                int i7 = (j6 * e.aif[l5]) / 100;
                dnb.cdn("Buy a new " + e.aib[l5] + " for " + i7 + "gp", byte0 + 2, byte1 + 214, 1, 0xffff00);
                int j2 = 0xffffff;
                if(super.fke > byte0 + 298 && super.fkf >= byte1 + 204 && super.fke < byte0 + 408 && super.fkf <= byte1 + 215)
                    j2 = 0xff0000;
                dnb.cdk("Click here to buy", byte0 + 405, byte1 + 214, 3, j2);
            } else
            {
                dnb.cdl("This item is not currently available to buy", byte0 + 204, byte1 + 214, 3, 0xffff00);
            }
            if(fac(l5) > 0)
            {
                int k6 = dmc + efc[dej];
                if(k6 < 10)
                    k6 = 10;
                int j7 = (k6 * e.aif[l5]) / 100;
                dnb.cdk("Sell your " + e.aib[l5] + " for " + j7 + "gp", byte0 + 405, byte1 + 239, 1, 0xffff00);
                int k2 = 0xffffff;
                if(super.fke > byte0 + 2 && super.fkf >= byte1 + 229 && super.fke < byte0 + 112 && super.fkf <= byte1 + 240)
                    k2 = 0xff0000;
                dnb.cdn("Click here to sell", byte0 + 2, byte1 + 239, 3, k2);
                return;
            }
            dnb.cdl("You do not have any of this item to sell", byte0 + 204, byte1 + 239, 3, 0xffff00);
        }
    }

    private final void fci()
    {
        byte abyte0[] = fcb("textures" + w.cfd + ".jag", "Textures", 50);
        if(abyte0 == null)
        {
            ebh = true;
            return;
        }
        byte abyte1[] = t.fng("index.dat", 0, abyte0);
        ejg.bje(e.akc, 7, 11);
        for(int l = 0; l < e.akc; l++)
        {
            String s1 = e.ajk[l];
            byte abyte2[] = t.fng(s1 + ".dat", 0, abyte0);
            dnb.cbj(efl, abyte2, abyte1, 1);
            dnb.cba(0, 0, 128, 128, 0xff00ff);
            dnb.ccb(0, 0, efl);
            int i1 = ((j) (dnb)).bmj[efl];
            String s2 = e.ajl[l];
            if(s2 != null && s2.length() > 0)
            {
                byte abyte3[] = t.fng(s2 + ".dat", 0, abyte0);
                dnb.cbj(efl, abyte3, abyte1, 1);
                dnb.ccb(0, 0, efl);
            }
            dnb.cca(efm + l, 0, 0, i1, i1);
            int j1 = i1 * i1;
            for(int k1 = 0; k1 < j1; k1++)
                if(((j) (dnb)).bmc[efm + l][k1] == 65280)
                    ((j) (dnb)).bmc[efm + l][k1] = 0xff00ff;

            dnb.cbl(efm + l);
            ejg.bjf(l, ((j) (dnb)).bmd[efm + l], ((j) (dnb)).bme[efm + l], i1 / 64 - 1);
        }

    }

    private final void fcj()
    {
        dnb.bnc = false;
        dnb.cak();
        dgk.ged();
        int l = 140;
        int i1 = 50;
        l += 116;
        i1 -= 25;
        dnb.ccf(l - 32 - 55, i1, 64, 102, e.all[ddd], eid[ddg]);
        dnb.cdd(l - 32 - 55, i1, 64, 102, e.all[ddc], eid[ddf], dki[ddh], 0, false);
        dnb.cdd(l - 32 - 55, i1, 64, 102, e.all[ddb], eii[dde], dki[ddh], 0, false);
        dnb.ccf(l - 32, i1, 64, 102, e.all[ddd] + 6, eid[ddg]);
        dnb.cdd(l - 32, i1, 64, 102, e.all[ddc] + 6, eid[ddf], dki[ddh], 0, false);
        dnb.cdd(l - 32, i1, 64, 102, e.all[ddb] + 6, eii[dde], dki[ddh], 0, false);
        dnb.ccf((l - 32) + 55, i1, 64, 102, e.all[ddd] + 12, eid[ddg]);
        dnb.cdd((l - 32) + 55, i1, 64, 102, e.all[ddc] + 12, eid[ddf], dki[ddh], 0, false);
        dnb.cdd((l - 32) + 55, i1, 64, 102, e.all[ddb] + 12, eii[dde], dki[ddh], 0, false);
        dnb.ccb(0, dci, efh + 22);
        dnb.caj(ebf, 0, 0);
    }

    private final void fck()
    {
        if(dil >= 0 || edi >= 0)
        {
            dem[ejf] = "Cancel";
            ejm[ejf] = "";
            dga[ejf] = 4000;
            ejf++;
        }
        for(int l = 0; l < ejf; l++)
            dec[l] = l;

        for(boolean flag = false; !flag;)
        {
            flag = true;
            for(int i1 = 0; i1 < ejf - 1; i1++)
            {
                int k1 = dec[i1];
                int i2 = dec[i1 + 1];
                if(dga[k1] > dga[i2])
                {
                    dec[i1] = i2;
                    dec[i1 + 1] = k1;
                    flag = false;
                }
            }

        }

        if(ejf > 20)
            ejf = 20;
        if(ejf > 0)
        {
            int j1 = -1;
            for(int l1 = 0; l1 < ejf; l1++)
            {
                if(ejm[dec[l1]] == null || ejm[dec[l1]].length() <= 0)
                    continue;
                j1 = l1;
                break;
            }

            String s1 = null;
            if((edi >= 0 || dil >= 0) && ejf == 1)
                s1 = "Choose a target";
            else
            if((edi >= 0 || dil >= 0) && ejf > 1)
                s1 = "@whi@" + dem[dec[0]] + " " + ejm[dec[0]];
            else
            if(j1 != -1)
                s1 = ejm[dec[j1]] + ": @whi@" + dem[dec[0]];
            if(ejf == 2 && s1 != null)
                s1 = s1 + "@whi@ / 1 more option";
            if(ejf > 2 && s1 != null)
                s1 = s1 + "@whi@ / " + (ejf - 1) + " more options";
            if(s1 != null)
                dnb.cdn(s1, 6, 14, 1, 0xffff00);
            if(!eef && dnl == 1 || eef && dnl == 1 && ejf == 1)
            {
                emg(dec[0]);
                dnl = 0;
                return;
            }
            if(!eef && dnl == 2 || eef && dnl == 1)
            {
                eje = (ejf + 1) * 15;
                ejd = dnb.cef("Choose option", 1) + 5;
                for(int j2 = 0; j2 < ejf; j2++)
                {
                    int k2 = dnb.cef(dem[j2] + " " + ejm[j2], 1) + 5;
                    if(k2 > ejd)
                        ejd = k2;
                }

                ejb = super.fke - ejd / 2;
                ejc = super.fkf - 7;
                dkk = true;
                if(ejb < 0)
                    ejb = 0;
                if(ejc < 0)
                    ejc = 0;
                if(ejb + ejd > 510)
                    ejb = 510 - ejd;
                if(ejc + eje > 315)
                    ejc = 315 - eje;
                dnl = 0;
            }
        }
    }

    private final void fcl()
    {
        if(dgb != 0)
        {
            dnb.cbf();
            dnb.cdl("Oh dear! You are dead...", dch / 2, dci / 2, 7, 0xff0000);
            fcc();
            dnb.caj(ebf, 0, 0);
            return;
        }
        if(eln)
        {
            fcj();
            return;
        }
        if(den)
        {
            dnb.cbf();
            if(Math.random() < 0.14999999999999999D)
                dnb.cdl("ZZZ", (int)(Math.random() * 80D), (int)(Math.random() * 334D), 5, (int)(Math.random() * 16777215D));
            if(Math.random() < 0.14999999999999999D)
                dnb.cdl("ZZZ", 512 - (int)(Math.random() * 80D), (int)(Math.random() * 334D), 5, (int)(Math.random() * 16777215D));
            dnb.cba(dch / 2 - 100, 160, 200, 40, 0);
            dnb.cdl("You are sleeping", dch / 2, 50, 7, 0xffff00);
            dnb.cdl("Fatigue: " + (dhk * 100) / 750 + "%", dch / 2, 90, 7, 0xffff00);
            dnb.cdl("When you want to wake up just use your", dch / 2, 140, 5, 0xffffff);
            dnb.cdl("keyboard to type the word in the box below", dch / 2, 160, 5, 0xffffff);
            dnb.cdl(super.fkl + "*", dch / 2, 180, 5, 65535);
            if(del == null)
                dnb.ccb(dch / 2 - 127, 230, efl + 1);
            else
                dnb.cdl(del, dch / 2, 260, 5, 0xff0000);
            dnb.cbb(dch / 2 - 128, 229, 257, 42, 0xffffff);
            fcc();
            dnb.cdl("If you can't read the word", dch / 2, 290, 1, 0xffffff);
            dnb.cdl("@yel@click here@whi@ to get a different one", dch / 2, 305, 1, 0xffffff);
            dnb.caj(ebf, 0, 0);
            return;
        }
        if(!dnh.gii)
            return;
        for(int l = 0; l < 64; l++)
        {
            ejg.bgn(dnh.gih[eal][l]);
            if(eal == 0)
            {
                ejg.bgn(dnh.gim[1][l]);
                ejg.bgn(dnh.gih[1][l]);
                ejg.bgn(dnh.gim[2][l]);
                ejg.bgn(dnh.gih[2][l]);
            }
            ebg = true;
            if(eal == 0 && (dnh.gij[djc.gmh / 128][djc.gmi / 128] & 0x80) == 0)
            {
                ejg.bgm(dnh.gih[eal][l]);
                if(eal == 0)
                {
                    ejg.bgm(dnh.gim[1][l]);
                    ejg.bgm(dnh.gih[1][l]);
                    ejg.bgm(dnh.gim[2][l]);
                    ejg.bgm(dnh.gih[2][l]);
                }
                ebg = false;
            }
        }

        if(dfa != ehi)
        {
            ehi = dfa;
            for(int i1 = 0; i1 < efd; i1++)
            {
                if(ela[i1] == 97)
                    emj(i1, "firea" + (dfa + 1));
                if(ela[i1] == 274)
                    emj(i1, "fireplacea" + (dfa + 1));
                if(ela[i1] == 1031)
                    emj(i1, "lightning" + (dfa + 1));
                if(ela[i1] == 1036)
                    emj(i1, "firespell" + (dfa + 1));
                if(ela[i1] == 1147)
                    emj(i1, "spellcharge" + (dfa + 1));
            }

        }
        if(dfb != ehj)
        {
            ehj = dfb;
            for(int j1 = 0; j1 < efd; j1++)
            {
                if(ela[j1] == 51)
                    emj(j1, "torcha" + (dfb + 1));
                if(ela[j1] == 143)
                    emj(j1, "skulltorcha" + (dfb + 1));
            }

        }
        if(dfc != ehk)
        {
            ehk = dfc;
            for(int k1 = 0; k1 < efd; k1++)
                if(ela[k1] == 1142)
                    emj(k1, "clawspell" + (dfc + 1));

        }
        ejg.bhc(dha);
        dha = 0;
        for(int l1 = 0; l1 < dgm; l1++)
        {
            f f1 = deh[l1];
            if(f1.hab != 255)
            {
                int j2 = f1.gmh;
                int l2 = f1.gmi;
                int j3 = -dnh.gjf(j2, l2);
                int k4 = ejg.bhd(5000 + l1, j2, j3, l2, 145, 220, l1 + 10000);
                dha++;
                if(f1 == djc)
                    ejg.bhe(k4);
                if(f1.gml == 8)
                    ejg.bhf(k4, -30);
                if(f1.gml == 9)
                    ejg.bhf(k4, 30);
            }
        }

        for(int i2 = 0; i2 < dgm; i2++)
        {
            f f2 = deh[i2];
            if(f2.hag > 0)
            {
                f f3 = null;
                if(f2.haf != -1)
                    f3 = ele[f2.haf];
                else
                if(f2.hae != -1)
                    f3 = dhb[f2.hae];
                if(f3 != null)
                {
                    int k3 = f2.gmh;
                    int l4 = f2.gmi;
                    int k7 = -dnh.gjf(k3, l4) - 110;
                    int k9 = f3.gmh;
                    int j10 = f3.gmi;
                    int k10 = -dnh.gjf(k9, j10) - e.aia[f3.gmj] / 2;
                    int l10 = (k3 * f2.hag + k9 * (eic - f2.hag)) / eic;
                    int i11 = (k7 * f2.hag + k10 * (eic - f2.hag)) / eic;
                    int j11 = (l4 * f2.hag + j10 * (eic - f2.hag)) / eic;
                    ejg.bhd(efk + f2.had, l10, i11, j11, 32, 32, 0);
                    dha++;
                }
            }
        }

        for(int k2 = 0; k2 < ebb; k2++)
        {
            f f4 = dgf[k2];
            int l3 = f4.gmh;
            int i5 = f4.gmi;
            int l7 = -dnh.gjf(l3, i5);
            int l9 = ejg.bhd(20000 + k2, l3, l7, i5, e.ahn[f4.gmj], e.aia[f4.gmj], k2 + 30000);
            dha++;
            if(f4.gml == 8)
                ejg.bhf(l9, -30);
            if(f4.gml == 9)
                ejg.bhf(l9, 30);
        }

        for(int i3 = 0; i3 < dhd; i3++)
        {
            int i4 = dml[i3] * ehd + 64;
            int j5 = dmm[i3] * ehd + 64;
            ejg.bhd(40000 + dmn[i3], i4, -dnh.gjf(i4, j5) - dna[i3], j5, 96, 64, i3 + 20000);
            dha++;
        }

        for(int j4 = 0; j4 < eig; j4++)
        {
            int k5 = ell[j4] * ehd + 64;
            int i8 = elh[j4] * ehd + 64;
            int i10 = ehg[j4];
            if(i10 == 0)
            {
                ejg.bhd(50000 + j4, k5, -dnh.gjf(k5, i8), i8, 128, 256, j4 + 50000);
                dha++;
            }
            if(i10 == 1)
            {
                ejg.bhd(50000 + j4, k5, -dnh.gjf(k5, i8), i8, 128, 64, j4 + 50000);
                dha++;
            }
        }

        dnb.bnc = false;
        dnb.cak();
        dnb.bnc = super.fkk;
        if(eal == 3)
        {
            int l5 = 40 + (int)(Math.random() * 3D);
            int j8 = 40 + (int)(Math.random() * 7D);
            ejg.bjl(l5, j8, -50, -10, -50);
        }
        dib = 0;
        egg = 0;
        ejl = 0;
        if(dim)
        {
            if(dka && !ebg)
            {
                int i6 = eli;
                fal();
                if(eli != i6)
                {
                    dgc = djc.gmh;
                    dgd = djc.gmi;
                }
            }
            ejg.bbg = 3000;
            ejg.bbh = 3000;
            ejg.bbi = 1;
            ejg.bbj = 2800;
            dkg = eli * 32;
            int j6 = dgc + egl;
            int k8 = dgd + dhl;
            ejg.bin(j6, -dnh.gjf(j6, k8), k8, 912, dkg * 4, 0, 2000);
        } else
        {
            if(dka && !ebg)
                fal();
            if(!super.fkk)
            {
                ejg.bbg = 2400;
                ejg.bbh = 2400;
                ejg.bbi = 1;
                ejg.bbj = 2300;
            } else
            {
                ejg.bbg = 2200;
                ejg.bbh = 2200;
                ejg.bbi = 1;
                ejg.bbj = 2100;
            }
            int k6 = dgc + egl;
            int l8 = dgd + dhl;
            ejg.bin(k6, -dnh.gjf(k6, l8), l8, xrot, dkg * 4, 0, eac * 2);
        }
        ejg.bib();
        fde();
        if(emb > 0)
            dnb.ccb(emc - 8, emd - 8, efh + 14 + (24 - emb) / 6);
        if(emb < 0)
            dnb.ccb(emc - 8, emd - 8, efh + 18 + (24 + emb) / 6);
        if(deg != 0)
        {
            int l6 = deg / 50;
            int i9 = l6 / 60;
            l6 %= 60;
            if(l6 < 10)
                dnb.cdl("System update in: " + i9 + ":0" + l6, 256, dci - 7, 1, 0xffff00);
            else
                dnb.cdl("System update in: " + i9 + ":" + l6, 256, dci - 7, 1, 0xffff00);
        }

        if(statmenu) 
        {
        dnb.cdl("@whi@" + BotName, 45, 100, 1, 0);
        dnb.cdl("@whi@User: @whi@" + ekc, 55, 115, 1, 0);
        dnb.cdl("@whi@World: @whi@" + sName, 50, 130, 1, 0);
        dnb.cdl("@whi@Atk: @whi@" + dfk[0], 45, 145, 1, 0);
        dnb.cdl("@whi@Def: @whi@" + dfk[1], 45, 160, 1, 0);
        dnb.cdl("@whi@Str: @whi@" + dfk[2], 45, 175, 1, 0);
        dnb.cdl("@whi@HP: @whi@" + dfk[3], 45, 190, 1, 0);
        dnb.cdl("@whi@Pray: @whi@" + dfk[5], 45, 205, 1, 0);
        dnb.cdl("@whi@Lobs: @gre@" + fac(373), 45, 220, 1, 0);
        dnb.cdl("@whi@PK Food: " + foodName , 60, 235, 1, 0);
        dnb.cdl("@whi@Pk Pray: " + prayername, 60, 250, 1, 0);
        dnb.cdl("@whi@AutoEat: " + hpnum, 60, 265, 1, 0);
        dnb.cdl("@whi@Coords: (" + (getX()) + ", " + (getY()) + ")", 60, 280, 1, 0);
        dnb.cdl("@whi@Mouse: (" + super.mousex + ", " + super.mousey + ")", 60, 295, 1, 0);
	}
        {
            int i7 = 2203 - (dje + eaj + dnj);
            if(djd + eai + dni >= 2640)
                i7 = -50;
            if(i7 > 0)
            {
                int j9 = 1 + i7 / 6;
                dnb.ccb(453, dci - 56, efh + 13);
                dnb.cdl("Wilderness", 465, dci - 20, 1, 0xffff00);
                dnb.cdl("Level: " + j9, 465, dci - 7, 1, 0xffff00);
                if(dme == 0)
                    dme = 2;
            }
            if(dme == 0 && i7 > -10 && i7 <= 0)
                dme = 1;
        }
        if(dea == 0)
        {
            for(int j7 = 0; j7 < 5; j7++)
                if(eib[j7] > 0)
                {
                    String s1 = die[j7];
                    dnb.cdn(s1, 7, dci - 18 - j7 * 12, 1, 0xffff00);
                }

        }
        ddj.ggf(ddk);
        ddj.ggf(ddm);
        ddj.ggf(ddn);
        if(dea == 1)
            ddj.gge(ddk);
        else
        if(dea == 2)
            ddj.gge(ddm);
        else
        if(dea == 3)
            ddj.gge(ddn);
        h.gdm = 2;
        ddj.ged();
        h.gdm = 0;
        dnb.ccd(((j) (dnb)).blg - 3 - 197, 3, efh, 128);
        fcn();
        dnb.bnf = false;
        fcc();
        dnb.caj(ebf, 0, 0);
    }
																																				//rstyrant - Made and created by at rstyrant.com

    private final void fcm()
    {
        if(super.fkm.length() > 0)
        {
            String s1 = super.fkm.trim();
            super.fkl = "";
            super.fkm = "";
            if(s1.length() > 0)
            {
                long l1 = t.fnc(s1);
                super.aag.hcn(215);
                super.aag.hdd(l1);
                super.aag.hdb(elc);
                super.aag.hdb(dia ? 1 : 0);
                super.aag.hdl();
            }
            dmh = 0;
            return;
        }
        dnb.cba(56, 130, 400, 100, 0);
        dnb.cbb(56, 130, 400, 100, 0xffffff);
        int l = 160;
        dnb.cdl("Now type the name of the offending player, and press enter", 256, l, 1, 0xffff00);
        l += 18;
        dnb.cdl("Name: " + super.fkl + "*", 256, l, 4, 0xffffff);
        if(super.abj > 0)
        {
            l = 207;
            if(dia)
                dnb.cdl("Moderator option: Mute player for 48 hours: <ON>", 256, l, 1, 0xff8000);
            else
                dnb.cdl("Moderator option: Mute player for 48 hours: <OFF>", 256, l, 1, 0xffffff);
            if(super.fke > 106 && super.fke < 406 && super.fkf > l - 13 && super.fkf < l + 2 && dnl == 1)
            {
                dnl = 0;
                dia = !dia;
            }
        }
        l = 222;
        int i1 = 0xffffff;
        if(super.fke > 196 && super.fke < 316 && super.fkf > l - 13 && super.fkf < l + 2)
        {
            i1 = 0xffff00;
            if(dnl == 1)
            {
                dnl = 0;
                dmh = 0;
            }
        }
        dnb.cdl("Click here to cancel", 256, l, 1, i1);
        if(dnl == 1 && (super.fke < 56 || super.fke > 456 || super.fkf < 130 || super.fkf > 230))
        {
            dnl = 0;
            dmh = 0;
        }
    }

    private final void fcn()
    {
        if(ehb != 0)
            fam();
        else
        if(ecc)
            fdl();
        else
        if(dmb && ebd == 0)
            fdf();
        else
        if(dmk && ebd == 0)
            fch();
        else
        if(edl)
            fbg();
        else
        if(dge)
            fak();
        else
        if(ecl)
            emm();
        else
        if(eld)
            fdb();
        else
        if(dmh == 1)
            emh();
        else
        if(dmh == 2)
            fcm();
        else
        if(eie != 0)
        {
            fed();
        } else
        {
            if(dck)
                fbf();
            if(djc.gml == 8 || djc.gml == 9)
                faj();
            feg();
            boolean flag = !dck && !dkk;
            if(flag)
                ejf = 0;
            if(egf == 0 && flag)
                fcg();
            if(egf == 1)
                enc(flag);
            if(egf == 2)
                enf(flag);
            if(egf == 3)
                fec(flag);
            if(egf == 4)
                fca(flag);
            if(egf == 5)
                fbn(flag);
            if(egf == 6)
                fag(flag);
            if(!dkk && !dck)
                fck();
            if(dkk && !dck)
                fef();
        }
        dnl = 0;
    }

    private final void fda()
    {
        e.anj("torcha2");
        e.anj("torcha3");
        e.anj("torcha4");
        e.anj("skulltorcha2");
        e.anj("skulltorcha3");
        e.anj("skulltorcha4");
        e.anj("firea2");
        e.anj("firea3");
        e.anj("fireplacea2");
        e.anj("fireplacea3");
        e.anj("firespell2");
        e.anj("firespell3");
        e.anj("lightning2");
        e.anj("lightning3");
        e.anj("clawspell2");
        e.anj("clawspell3");
        e.anj("clawspell4");
        e.anj("clawspell5");
        e.anj("spellcharge2");
        e.anj("spellcharge3");
        if(fld())
        {
            byte abyte0[] = fcb("models" + w.cfc + ".jag", "3d models", 60);
            if(abyte0 == null)
            {
                ebh = true;
                return;
            }
            for(int i1 = 0; i1 < e.ama; i1++)
            {
                int j1 = t.fne(e.ajj[i1] + ".ob3", abyte0);
                if(j1 != 0)
                    edb[i1] = new i(abyte0, j1, true);
                else
                    edb[i1] = new i(1, 1);
                if(e.ajj[i1].equals("giantcrystal"))
                    edb[i1].chj = true;
            }

            return;
        }
        flj(70, "Loading 3d models");
        for(int l = 0; l < e.ama; l++)
        {
            edb[l] = new i("../gamedata/models/" + e.ajj[l] + ".ob2");
            if(e.ajj[l].equals("giantcrystal"))
                edb[l].chj = true;
        }

    }

    private final void fdb()
    {
        if(dnl != 0 && ekb == 0)
            ekb = 1;
        if(ekb > 0)
        {
            int l = super.fke - 22;
            int i1 = super.fkf - 36;
            if(l >= 0 && i1 >= 0 && l < 468 && i1 < 262)
            {
                if(l > 216 && i1 > 30 && l < 462 && i1 < 235)
                {
                    int j1 = (l - 217) / 49 + ((i1 - 31) / 34) * 5;
                    if(j1 >= 0 && j1 < ede)
                    {
                        boolean flag1 = false;
                        int k2 = 0;
                        int j3 = edf[j1];
                        for(int j4 = 0; j4 < ded; j4++)
                            if(dee[j4] == j3)
                                if(e.aig[j3] == 0)
                                {
                                    for(int l4 = 0; l4 < ekb; l4++)
                                    {
                                        if(def[j4] < edg[j1])
                                            def[j4]++;
                                        flag1 = true;
                                    }

                                } else
                                {
                                    k2++;
                                }

                        if(fac(j3) <= k2)
                            flag1 = true;
                        if(e.aik[j3] == 1)
                        {
                            fdj("This object cannot be added to a duel offer", 3);
                            flag1 = true;
                        }
                        if(!flag1 && ded < 8)
                        {
                            dee[ded] = j3;
                            def[ded] = 1;
                            ded++;
                            flag1 = true;
                        }
                        if(flag1)
                        {
                            super.aag.hcn(229);
                            super.aag.hdb(ded);
                            for(int i5 = 0; i5 < ded; i5++)
                            {
                                super.aag.hdj(dee[i5]);
                                super.aag.hdh(def[i5]);
                            }

                            super.aag.hdl();
                            dhe = false;
                            dhf = false;
                        }
                    }
                }
                if(l > 8 && i1 > 30 && l < 205 && i1 < 129)
                {
                    int k1 = (l - 9) / 49 + ((i1 - 31) / 34) * 4;
                    if(k1 >= 0 && k1 < ded)
                    {
                        int i2 = dee[k1];
                        for(int l2 = 0; l2 < ekb; l2++)
                        {
                            if(e.aig[i2] == 0 && def[k1] > 1)
                            {
                                def[k1]--;
                                continue;
                            }
                            ded--;
                            eka = 0;
                            for(int k3 = k1; k3 < ded; k3++)
                            {
                                dee[k3] = dee[k3 + 1];
                                def[k3] = def[k3 + 1];
                            }

                            break;
                        }

                        super.aag.hcn(229);
                        super.aag.hdb(ded);
                        for(int l3 = 0; l3 < ded; l3++)
                        {
                            super.aag.hdj(dee[l3]);
                            super.aag.hdh(def[l3]);
                        }

                        super.aag.hdl();
                        dhe = false;
                        dhf = false;
                    }
                }
                boolean flag = false;
                if(l >= 93 && i1 >= 221 && l <= 104 && i1 <= 232)
                {
                    dgg = !dgg;
                    flag = true;
                }
                if(l >= 93 && i1 >= 240 && l <= 104 && i1 <= 251)
                {
                    dgh = !dgh;
                    flag = true;
                }
                if(l >= 191 && i1 >= 221 && l <= 202 && i1 <= 232)
                {
                    dgi = !dgi;
                    flag = true;
                }
                if(l >= 191 && i1 >= 240 && l <= 202 && i1 <= 251)
                {
                    dgj = !dgj;
                    flag = true;
                }
                if(flag)
                {
                    super.aag.hcn(138);
                    super.aag.hdb(dgg ? 1 : 0);
                    super.aag.hdb(dgh ? 1 : 0);
                    super.aag.hdb(dgi ? 1 : 0);
                    super.aag.hdb(dgj ? 1 : 0);
                    super.aag.hdl();
                    dhe = false;
                    dhf = false;
                }
                if(l >= 217 && i1 >= 238 && l <= 286 && i1 <= 259)
                {
                    dhf = true;
                    super.aag.hcn(125);
                    super.aag.hdl();
                }
                if(l >= 394 && i1 >= 238 && l < 463 && i1 < 259)
                {
                    eld = false;
                    super.aag.hcn(43);
                    super.aag.hdl();
                }
            } else
            if(dnl != 0)
            {
                eld = false;
                super.aag.hcn(43);
                super.aag.hdl();
            }
            dnl = 0;
            ekb = 0;
        }
        if(!eld)
            return;
        byte byte0 = 22;
        byte byte1 = 36;
        dnb.cba(byte0, byte1, 468, 12, 0xc90b1d);
        int l1 = 0x989898;
        dnb.cam(byte0, byte1 + 12, 468, 18, l1, 160);
        dnb.cam(byte0, byte1 + 30, 8, 248, l1, 160);
        dnb.cam(byte0 + 205, byte1 + 30, 11, 248, l1, 160);
        dnb.cam(byte0 + 462, byte1 + 30, 6, 248, l1, 160);
        dnb.cam(byte0 + 8, byte1 + 99, 197, 24, l1, 160);
        dnb.cam(byte0 + 8, byte1 + 192, 197, 23, l1, 160);
        dnb.cam(byte0 + 8, byte1 + 258, 197, 20, l1, 160);
        dnb.cam(byte0 + 216, byte1 + 235, 246, 43, l1, 160);
        int j2 = 0xd0d0d0;
        dnb.cam(byte0 + 8, byte1 + 30, 197, 69, j2, 160);
        dnb.cam(byte0 + 8, byte1 + 123, 197, 69, j2, 160);
        dnb.cam(byte0 + 8, byte1 + 215, 197, 43, j2, 160);
        dnb.cam(byte0 + 216, byte1 + 30, 246, 205, j2, 160);
        for(int i3 = 0; i3 < 3; i3++)
            dnb.cbc(byte0 + 8, byte1 + 30 + i3 * 34, 197, 0);

        for(int i4 = 0; i4 < 3; i4++)
            dnb.cbc(byte0 + 8, byte1 + 123 + i4 * 34, 197, 0);

        for(int k4 = 0; k4 < 7; k4++)
            dnb.cbc(byte0 + 216, byte1 + 30 + k4 * 34, 246, 0);

        for(int j5 = 0; j5 < 6; j5++)
        {
            if(j5 < 5)
                dnb.cbd(byte0 + 8 + j5 * 49, byte1 + 30, 69, 0);
            if(j5 < 5)
                dnb.cbd(byte0 + 8 + j5 * 49, byte1 + 123, 69, 0);
            dnb.cbd(byte0 + 216 + j5 * 49, byte1 + 30, 205, 0);
        }

        dnb.cbc(byte0 + 8, byte1 + 215, 197, 0);
        dnb.cbc(byte0 + 8, byte1 + 257, 197, 0);
        dnb.cbd(byte0 + 8, byte1 + 215, 43, 0);
        dnb.cbd(byte0 + 204, byte1 + 215, 43, 0);
        dnb.cdn("Preparing to duel with: " + eke, byte0 + 1, byte1 + 10, 1, 0xffffff);
        dnb.cdn("Your Stake", byte0 + 9, byte1 + 27, 4, 0xffffff);
        dnb.cdn("Opponent's Stake", byte0 + 9, byte1 + 120, 4, 0xffffff);
        dnb.cdn("Duel Options", byte0 + 9, byte1 + 212, 4, 0xffffff);
        dnb.cdn("Your Inventory", byte0 + 216, byte1 + 27, 4, 0xffffff);
        dnb.cdn("No retreating", byte0 + 8 + 1, byte1 + 215 + 16, 3, 0xffff00);
        dnb.cdn("No magic", byte0 + 8 + 1, byte1 + 215 + 35, 3, 0xffff00);
        dnb.cdn("No prayer", byte0 + 8 + 102, byte1 + 215 + 16, 3, 0xffff00);
        dnb.cdn("No weapons", byte0 + 8 + 102, byte1 + 215 + 35, 3, 0xffff00);
        dnb.cbb(byte0 + 93, byte1 + 215 + 6, 11, 11, 0xffff00);
        if(dgg)
            dnb.cba(byte0 + 95, byte1 + 215 + 8, 7, 7, 0xffff00);
        dnb.cbb(byte0 + 93, byte1 + 215 + 25, 11, 11, 0xffff00);
        if(dgh)
            dnb.cba(byte0 + 95, byte1 + 215 + 27, 7, 7, 0xffff00);
        dnb.cbb(byte0 + 191, byte1 + 215 + 6, 11, 11, 0xffff00);
        if(dgi)
            dnb.cba(byte0 + 193, byte1 + 215 + 8, 7, 7, 0xffff00);
        dnb.cbb(byte0 + 191, byte1 + 215 + 25, 11, 11, 0xffff00);
        if(dgj)
            dnb.cba(byte0 + 193, byte1 + 215 + 27, 7, 7, 0xffff00);
        if(!dhf)
            dnb.ccb(byte0 + 217, byte1 + 238, efh + 25);
        dnb.ccb(byte0 + 394, byte1 + 238, efh + 26);
        if(dhe)
        {
            dnb.cdl("Other player", byte0 + 341, byte1 + 246, 1, 0xffffff);
            dnb.cdl("has accepted", byte0 + 341, byte1 + 256, 1, 0xffffff);
        }
        if(dhf)
        {
            dnb.cdl("Waiting for", byte0 + 217 + 35, byte1 + 246, 1, 0xffffff);
            dnb.cdl("other player", byte0 + 217 + 35, byte1 + 256, 1, 0xffffff);
        }
        for(int k5 = 0; k5 < ede; k5++)
        {
            int l5 = 217 + byte0 + (k5 % 5) * 49;
            int j6 = 31 + byte1 + (k5 / 5) * 34;
            dnb.cdd(l5, j6, 48, 32, efj + e.aie[edf[k5]], e.aij[edf[k5]], 0, 0, false);
            if(e.aig[edf[k5]] == 0)
                dnb.cdn(String.valueOf(edg[k5]), l5 + 1, j6 + 10, 1, 0xffff00);
        }

        for(int i6 = 0; i6 < ded; i6++)
        {
            int k6 = 9 + byte0 + (i6 % 4) * 49;
            int i7 = 31 + byte1 + (i6 / 4) * 34;
            dnb.cdd(k6, i7, 48, 32, efj + e.aie[dee[i6]], e.aij[dee[i6]], 0, 0, false);
            if(e.aig[dee[i6]] == 0)
                dnb.cdn(String.valueOf(def[i6]), k6 + 1, i7 + 10, 1, 0xffff00);
            if(super.fke > k6 && super.fke < k6 + 48 && super.fkf > i7 && super.fkf < i7 + 32)
                dnb.cdn(e.aib[dee[i6]] + ": @whi@" + e.aic[dee[i6]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }

        for(int l6 = 0; l6 < dkl; l6++)
        {
            int j7 = 9 + byte0 + (l6 % 4) * 49;
            int k7 = 124 + byte1 + (l6 / 4) * 34;
            dnb.cdd(j7, k7, 48, 32, efj + e.aie[dkm[l6]], e.aij[dkm[l6]], 0, 0, false);
            if(e.aig[dkm[l6]] == 0)
                dnb.cdn(String.valueOf(dkn[l6]), j7 + 1, k7 + 10, 1, 0xffff00);
            if(super.fke > j7 && super.fke < j7 + 48 && super.fkf > k7 && super.fkf < k7 + 32)
                dnb.cdn(e.aib[dkm[l6]] + ": @whi@" + e.aic[dkm[l6]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }

    }



    final void fdd(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6)
    {
        f f1 = dgf[arg4];
        int l = f1.gml + (dkg + 16) / 32 & 7;
        boolean flag = false;
        int i1 = l;
        if(i1 == 5)
        {
            i1 = 3;
            flag = true;
        } else
        if(i1 == 6)
        {
            i1 = 2;
            flag = true;
        } else
        if(i1 == 7)
        {
            i1 = 1;
            flag = true;
        }
        int j1 = i1 * 3 + dhn[(f1.gmk / e.akl[f1.gmj]) % 4];
        if(f1.gml == 8)
        {
            i1 = 5;
            l = 2;
            flag = false;
            arg0 -= (e.akn[f1.gmj] * arg6) / 100;
            j1 = i1 * 3 + eme[(dng / (e.akm[f1.gmj] - 1)) % 8];
        } else
        if(f1.gml == 9)
        {
            i1 = 5;
            l = 2;
            flag = true;
            arg0 += (e.akn[f1.gmj] * arg6) / 100;
            j1 = i1 * 3 + eab[(dng / e.akm[f1.gmj]) % 8];
        }
        for(int k1 = 0; k1 < 12; k1++)
        {
            int l1 = dgl[l][k1];
            int k2 = e.ala[f1.gmj][l1];
            if(k2 >= 0)
            {
                int i3 = 0;
                int j3 = 0;
                int k3 = j1;
                if(flag && i1 >= 1 && i1 <= 3 && e.alk[k2] == 1)
                    k3 += 15;
                if(i1 != 5 || e.alj[k2] == 1)
                {
                    int l3 = k3 + e.all[k2];
                    i3 = (i3 * arg2) / ((j) (dnb)).bmj[l3];
                    j3 = (j3 * arg3) / ((j) (dnb)).bmk[l3];
                    int i4 = (arg2 * ((j) (dnb)).bmj[l3]) / ((j) (dnb)).bmj[e.all[k2]];
                    i3 -= (i4 - arg2) / 2;
                    int j4 = e.alh[k2];
                    int k4 = 0;
                    if(j4 == 1)
                    {
                        j4 = e.ajc[f1.gmj];
                        k4 = e.ajf[f1.gmj];
                    } else
                    if(j4 == 2)
                    {
                        j4 = e.ajd[f1.gmj];
                        k4 = e.ajf[f1.gmj];
                    } else
                    if(j4 == 3)
                    {
                        j4 = e.aje[f1.gmj];
                        k4 = e.ajf[f1.gmj];
                    }
                    dnb.cdd(arg0 + i3, arg1 + j3, i4, arg3, l3, j4, k4, arg5, flag);
                }
            }
        }

        if(f1.gnf > 0)
        {
            eaf[egg] = dnb.cef(f1.gne, 1) / 2;
            if(eaf[egg] > 150)
                eaf[egg] = 150;
            eag[egg] = (dnb.cef(f1.gne, 1) / 300) * dnb.ced(1);
            ead[egg] = arg0 + arg2 / 2;
            eae[egg] = arg1;
            egh[egg++] = f1.gne;
        }
        if(f1.gml == 8 || f1.gml == 9 || f1.gnl != 0)
        {
            if(f1.gnl > 0)
            {
                int i2 = arg0;
                if(f1.gml == 8)
                    i2 -= (20 * arg6) / 100;
                else
                if(f1.gml == 9)
                    i2 += (20 * arg6) / 100;
                int l2 = (f1.gnj * 30) / f1.gnk;
                ekj[ejl] = i2 + arg2 / 2;
                ekk[ejl] = arg1;
                ekl[ejl++] = l2;
            }
            if(f1.gnl > 150)
            {
                int j2 = arg0;
                if(f1.gml == 8)
                    j2 -= (10 * arg6) / 100;
                else
                if(f1.gml == 9)
                    j2 += (10 * arg6) / 100;
                dnb.ccb((j2 + arg2 / 2) - 12, (arg1 + arg3 / 2) - 12, efh + 12);
                dnb.cdl(String.valueOf(f1.gni), (j2 + arg2 / 2) - 1, arg1 + arg3 / 2 + 5, 3, 0xffffff);
            }
        }
    }

    protected final void adg(String s1)
    {
        if(s1.startsWith("@bor@"))
        {
            fdj(s1, 4);
            return;
        }
        if(s1.startsWith("@que@"))
        {
            fdj("@whi@" + s1, 5);
            return;
        }
        if(s1.startsWith("@pri@"))
        {
            fdj(s1, 6);
            return;
        } else
        {
            fdj(s1, 3);
            return;
        }
    }

    private final void fde()
    {
        for(int l = 0; l < egg; l++)
        {
            int i1 = dnb.ced(1);
            int k1 = ead[l];
            int j2 = eae[l];
            int i3 = eaf[l];
            int l3 = eag[l];
            boolean flag = true;
            while(flag) 
            {
                flag = false;
                for(int l4 = 0; l4 < l; l4++)
                    if(j2 + l3 > eae[l4] - i1 && j2 - i1 < eae[l4] + eag[l4] && k1 - i3 < ead[l4] + eaf[l4] && k1 + i3 > ead[l4] - eaf[l4] && eae[l4] - i1 - l3 < j2)
                    {
                        j2 = eae[l4] - i1 - l3;
                        flag = true;
                    }

            }
            eae[l] = j2;
            dnb.cdm(egh[l], k1, j2, 1, 0xffff00, 300);
        }

        for(int j1 = 0; j1 < dib; j1++)
        {
            int l1 = ebk[j1];
            int k2 = ebl[j1];
            int j3 = dfi[j1];
            int i4 = dfj[j1];
            int k4 = (39 * j3) / 100;
            int i5 = (27 * j3) / 100;
            int j5 = k2 - i5;
            dnb.cce(l1 - k4 / 2, j5, k4, i5, efh + 9, 85);
            int k5 = (36 * j3) / 100;
            int l5 = (24 * j3) / 100;
            dnb.cdd(l1 - k5 / 2, (j5 + i5 / 2) - l5 / 2, k5, l5, e.aie[i4] + efj, e.aij[i4], 0, 0, false);
        }

        for(int i2 = 0; i2 < ejl; i2++)
        {
            int l2 = ekj[i2];
            int k3 = ekk[i2];
            int j4 = ekl[i2];
            dnb.cam(l2 - 15, k3 - 3, j4, 5, 65280, 192);
            dnb.cam((l2 - 15) + j4, k3 - 3, 30 - j4, 5, 0xff0000, 192);
        }

    }

    protected final void ade()
    {
        ehb = 0;
        fdj("@cya@Sorry, you can't logout at the moment", 3);
    }

    private final void fdf()
    {
        char c1 = '\u0198';
        char c2 = '\u014E';
        if(ekf > 0 && elm <= 48)
            ekf = 0;
        if(ekf > 1 && elm <= 96)
            ekf = 1;
        if(ekf > 2 && elm <= 144)
            ekf = 2;
        if(ecj >= elm || ecj < 0)
            ecj = -1;
        if(ecj != -1 && eam[ecj] != eck)
        {
            ecj = -1;
            eck = -2;
        }
        if(dnl != 0)
        {
            dnl = 0;
            int l = super.fke - (256 - c1 / 2);
            int j1 = super.fkf - (170 - c2 / 2);
            if(l >= 0 && j1 >= 12 && l < 408 && j1 < 280)
            {
                int l1 = ekf * 48;
                for(int k2 = 0; k2 < 6; k2++)
                {
                    for(int i3 = 0; i3 < 8; i3++)
                    {
                        int k7 = 7 + i3 * 49;
                        int i8 = 28 + k2 * 34;
                        if(l > k7 && l < k7 + 49 && j1 > i8 && j1 < i8 + 34 && l1 < elm && eam[l1] != -1)
                        {
                            eck = eam[l1];
                            ecj = l1;
                        }
                        l1++;
                    }

                }

                l = 256 - c1 / 2;
                j1 = 170 - c2 / 2;
                int j3;
                if(ecj < 0)
                    j3 = -1;
                else
                    j3 = eam[ecj];
                if(j3 != -1)
                {
                    int i2 = ean[ecj];
                    if(e.aig[j3] == 1 && i2 > 1)
                        i2 = 1;
                    if(i2 >= 1 && super.fke >= l + 220 && super.fkf >= j1 + 238 && super.fke < l + 250 && super.fkf <= j1 + 249)
                    {
                        super.aag.hcn(131);
                        super.aag.hdj(j3);
                        super.aag.hdj(1);
                        super.aag.hdl();
                    }
                    if(i2 >= 5 && super.fke >= l + 250 && super.fkf >= j1 + 238 && super.fke < l + 280 && super.fkf <= j1 + 249)
                    {
                        super.aag.hcn(131);
                        super.aag.hdj(j3);
                        super.aag.hdj(5);
                        super.aag.hdl();
                    }
                    if(i2 >= 25 && super.fke >= l + 280 && super.fkf >= j1 + 238 && super.fke < l + 305 && super.fkf <= j1 + 249)
                    {
                        super.aag.hcn(131);
                        super.aag.hdj(j3);
                        super.aag.hdj(25);
                        super.aag.hdl();
                    }
                    if(i2 >= 100 && super.fke >= l + 305 && super.fkf >= j1 + 238 && super.fke < l + 335 && super.fkf <= j1 + 249)
                    {
                        super.aag.hcn(131);
                        super.aag.hdj(j3);
                        super.aag.hdj(100);
                        super.aag.hdl();
                    }
                    if(i2 >= 500 && super.fke >= l + 335 && super.fkf >= j1 + 238 && super.fke < l + 368 && super.fkf <= j1 + 249)
                    {
                        super.aag.hcn(131);
                        super.aag.hdj(j3);
                        super.aag.hdj(500);
                        super.aag.hdl();
                    }
                    if(i2 >= 2500 && super.fke >= l + 370 && super.fkf >= j1 + 238 && super.fke < l + 400 && super.fkf <= j1 + 249)
                    {
                        super.aag.hcn(131);
                        super.aag.hdj(j3);
                        super.aag.hdj(2500);
                        super.aag.hdl();
                    }
                    if(fac(j3) >= 1 && super.fke >= l + 220 && super.fkf >= j1 + 263 && super.fke < l + 250 && super.fkf <= j1 + 274)
                    {
                        super.aag.hcn(190);
                        super.aag.hdj(j3);
                        super.aag.hdj(1);
                        super.aag.hdl();
                    }
                    if(fac(j3) >= 5 && super.fke >= l + 250 && super.fkf >= j1 + 263 && super.fke < l + 280 && super.fkf <= j1 + 274)
                    {
                        super.aag.hcn(190);
                        super.aag.hdj(j3);
                        super.aag.hdj(5);
                        super.aag.hdl();
                    }
                    if(fac(j3) >= 25 && super.fke >= l + 280 && super.fkf >= j1 + 263 && super.fke < l + 305 && super.fkf <= j1 + 274)
                    {
                        super.aag.hcn(190);
                        super.aag.hdj(j3);
                        super.aag.hdj(25);
                        super.aag.hdl();
                    }
                    if(fac(j3) >= 100 && super.fke >= l + 305 && super.fkf >= j1 + 263 && super.fke < l + 335 && super.fkf <= j1 + 274)
                    {
                        super.aag.hcn(190);
                        super.aag.hdj(j3);
                        super.aag.hdj(100);
                        super.aag.hdl();
                    }
                    if(fac(j3) >= 500 && super.fke >= l + 335 && super.fkf >= j1 + 263 && super.fke < l + 368 && super.fkf <= j1 + 274)
                    {
                        super.aag.hcn(190);
                        super.aag.hdj(j3);
                        super.aag.hdj(500);
                        super.aag.hdl();
                    }
                    if(fac(j3) >= 2500 && super.fke >= l + 370 && super.fkf >= j1 + 263 && super.fke < l + 400 && super.fkf <= j1 + 274)
                    {
                        super.aag.hcn(190);
                        super.aag.hdj(j3);
                        super.aag.hdj(2500);
                        super.aag.hdl();
                    }
                }
            } else
            if(elm > 48 && l >= 50 && l <= 115 && j1 <= 12)
                ekf = 0;
            else
            if(elm > 48 && l >= 115 && l <= 180 && j1 <= 12)
                ekf = 1;
            else
            if(elm > 96 && l >= 180 && l <= 245 && j1 <= 12)
                ekf = 2;
            else
            if(elm > 144 && l >= 245 && l <= 310 && j1 <= 12)
            {
                ekf = 3;
            } else
            {
                super.aag.hcn(78);
                super.aag.hdl();
                dmb = false;
                return;
            }
        }
        int i1 = 256 - c1 / 2;
        int k1 = 170 - c2 / 2;
        dnb.cba(i1, k1, 408, 12, 192);
        int j2 = 0x989898;
        dnb.cam(i1, k1 + 12, 408, 17, j2, 160);
        dnb.cam(i1, k1 + 29, 8, 204, j2, 160);
        dnb.cam(i1 + 399, k1 + 29, 9, 204, j2, 160);
        dnb.cam(i1, k1 + 233, 408, 47, j2, 160);
        dnb.cdn("Bank", i1 + 1, k1 + 10, 1, 0xffffff);
        int l2 = 50;
        if(elm > 48)
        {
            int k3 = 0xffffff;
            if(ekf == 0)
                k3 = 0xff0000;
            else
            if(super.fke > i1 + l2 && super.fkf >= k1 && super.fke < i1 + l2 + 65 && super.fkf < k1 + 12)
                k3 = 0xffff00;
            dnb.cdn("<page 1>", i1 + l2, k1 + 10, 1, k3);
            l2 += 65;
            k3 = 0xffffff;
            if(ekf == 1)
                k3 = 0xff0000;
            else
            if(super.fke > i1 + l2 && super.fkf >= k1 && super.fke < i1 + l2 + 65 && super.fkf < k1 + 12)
                k3 = 0xffff00;
            dnb.cdn("<page 2>", i1 + l2, k1 + 10, 1, k3);
            l2 += 65;
        }
        if(elm > 96)
        {
            int l3 = 0xffffff;
            if(ekf == 2)
                l3 = 0xff0000;
            else
            if(super.fke > i1 + l2 && super.fkf >= k1 && super.fke < i1 + l2 + 65 && super.fkf < k1 + 12)
                l3 = 0xffff00;
            dnb.cdn("<page 3>", i1 + l2, k1 + 10, 1, l3);
            l2 += 65;
        }
        if(elm > 144)
        {
            int i4 = 0xffffff;
            if(ekf == 3)
                i4 = 0xff0000;
            else
            if(super.fke > i1 + l2 && super.fkf >= k1 && super.fke < i1 + l2 + 65 && super.fkf < k1 + 12)
                i4 = 0xffff00;
            dnb.cdn("<page 4>", i1 + l2, k1 + 10, 1, i4);
            l2 += 65;
        }
        int j4 = 0xffffff;
        if(super.fke > i1 + 320 && super.fkf >= k1 && super.fke < i1 + 408 && super.fkf < k1 + 12)
            j4 = 0xff0000;
        dnb.cdk("Close window", i1 + 406, k1 + 10, 1, j4);
        dnb.cdn("Number in bank in green", i1 + 7, k1 + 24, 1, 65280);
        dnb.cdn("Number held in blue", i1 + 289, k1 + 24, 1, 65535);
        int l7 = 0xd0d0d0;
        int j8 = ekf * 48;
        for(int l8 = 0; l8 < 6; l8++)
        {
            for(int i9 = 0; i9 < 8; i9++)
            {
                int k9 = i1 + 7 + i9 * 49;
                int l9 = k1 + 28 + l8 * 34;
                if(ecj == j8)
                    dnb.cam(k9, l9, 49, 34, 0xff0000, 160);
                else
                    dnb.cam(k9, l9, 49, 34, l7, 160);
                dnb.cbb(k9, l9, 50, 35, 0);
                if(j8 < elm && eam[j8] != -1)
                {
                    dnb.cdd(k9, l9, 48, 32, efj + e.aie[eam[j8]], e.aij[eam[j8]], 0, 0, false);
                    dnb.cdn(String.valueOf(ean[j8]), k9 + 1, l9 + 10, 1, 65280);
                    dnb.cdk(String.valueOf(fac(eam[j8])), k9 + 47, l9 + 29, 1, 65535);
                }
                j8++;
            }

        }

        dnb.cbc(i1 + 5, k1 + 256, 398, 0);
        if(ecj == -1)
        {
            dnb.cdl("Select an object to withdraw or deposit", i1 + 204, k1 + 248, 3, 0xffff00);
            return;
        }
        int j9;
        if(ecj < 0)
            j9 = -1;
        else
            j9 = eam[ecj];
        if(j9 != -1)
        {
            int k8 = ean[ecj];
            if(e.aig[j9] == 1 && k8 > 1)
                k8 = 1;
            if(k8 > 0)
            {
                dnb.cdn("Withdraw " + e.aib[j9], i1 + 2, k1 + 248, 1, 0xffffff);
                int k4 = 0xffffff;
                if(super.fke >= i1 + 220 && super.fkf >= k1 + 238 && super.fke < i1 + 250 && super.fkf <= k1 + 249)
                    k4 = 0xff0000;
                dnb.cdn("One", i1 + 222, k1 + 248, 1, k4);
                if(k8 >= 5)
                {
                    int l4 = 0xffffff;
                    if(super.fke >= i1 + 250 && super.fkf >= k1 + 238 && super.fke < i1 + 280 && super.fkf <= k1 + 249)
                        l4 = 0xff0000;
                    dnb.cdn("Five", i1 + 252, k1 + 248, 1, l4);
                }
                if(k8 >= 25)
                {
                    int i5 = 0xffffff;
                    if(super.fke >= i1 + 280 && super.fkf >= k1 + 238 && super.fke < i1 + 305 && super.fkf <= k1 + 249)
                        i5 = 0xff0000;
                    dnb.cdn("25", i1 + 282, k1 + 248, 1, i5);
                }
                if(k8 >= 100)
                {
                    int j5 = 0xffffff;
                    if(super.fke >= i1 + 305 && super.fkf >= k1 + 238 && super.fke < i1 + 335 && super.fkf <= k1 + 249)
                        j5 = 0xff0000;
                    dnb.cdn("100", i1 + 307, k1 + 248, 1, j5);
                }
                if(k8 >= 500)
                {
                    int k5 = 0xffffff;
                    if(super.fke >= i1 + 335 && super.fkf >= k1 + 238 && super.fke < i1 + 368 && super.fkf <= k1 + 249)
                        k5 = 0xff0000;
                    dnb.cdn("500", i1 + 337, k1 + 248, 1, k5);
                }
                if(k8 >= 2500)
                {
                    int l5 = 0xffffff;
                    if(super.fke >= i1 + 370 && super.fkf >= k1 + 238 && super.fke < i1 + 400 && super.fkf <= k1 + 249)
                        l5 = 0xff0000;
                    dnb.cdn("2500", i1 + 370, k1 + 248, 1, l5);
                }
            }
            if(fac(j9) > 0)
            {
                dnb.cdn("Deposit " + e.aib[j9], i1 + 2, k1 + 273, 1, 0xffffff);
                int i6 = 0xffffff;
                if(super.fke >= i1 + 220 && super.fkf >= k1 + 263 && super.fke < i1 + 250 && super.fkf <= k1 + 274)
                    i6 = 0xff0000;
                dnb.cdn("One", i1 + 222, k1 + 273, 1, i6);
                if(fac(j9) >= 5)
                {
                    int j6 = 0xffffff;
                    if(super.fke >= i1 + 250 && super.fkf >= k1 + 263 && super.fke < i1 + 280 && super.fkf <= k1 + 274)
                        j6 = 0xff0000;
                    dnb.cdn("Five", i1 + 252, k1 + 273, 1, j6);
                }
                if(fac(j9) >= 25)
                {
                    int k6 = 0xffffff;
                    if(super.fke >= i1 + 280 && super.fkf >= k1 + 263 && super.fke < i1 + 305 && super.fkf <= k1 + 274)
                        k6 = 0xff0000;
                    dnb.cdn("25", i1 + 282, k1 + 273, 1, k6);
                }
                if(fac(j9) >= 100)
                {
                    int l6 = 0xffffff;
                    if(super.fke >= i1 + 305 && super.fkf >= k1 + 263 && super.fke < i1 + 335 && super.fkf <= k1 + 274)
                        l6 = 0xff0000;
                    dnb.cdn("100", i1 + 307, k1 + 273, 1, l6);
                }
                if(fac(j9) >= 500)
                {
                    int i7 = 0xffffff;
                    if(super.fke >= i1 + 335 && super.fkf >= k1 + 263 && super.fke < i1 + 368 && super.fkf <= k1 + 274)
                        i7 = 0xff0000;
                    dnb.cdn("500", i1 + 337, k1 + 273, 1, i7);
                }
                if(fac(j9) >= 2500)
                {
                    int j7 = 0xffffff;
                    if(super.fke >= i1 + 370 && super.fkf >= k1 + 263 && super.fke < i1 + 400 && super.fkf <= k1 + 274)
                        j7 = 0xff0000;
                    dnb.cdn("2500", i1 + 370, k1 + 273, 1, j7);
                }
            }
        }
    }

    public final Graphics getGraphics()
    {
        if(a.fig != null)
            return a.fig.getGraphics();
        if(link.fni != null)
            return link.fni.getGraphics();
        else
            return super.getGraphics();
    }

    private final boolean fdg(int arg0, int arg1)
    {
        if(dgb != 0)
        {
            dnh.gii = false;
            return false;
        }
        elk = false;
        arg0 += eai;
        arg1 += eaj;
        if(eal == dnk && arg0 > ega && arg0 < egc && arg1 > egb && arg1 < egd)
        {
            dnh.gii = true;
            return false;
        }
        dnb.cdl("Loading... Please wait", 256, 192, 1, 0xffffff);
        fcc();
        dnb.caj(ebf, 0, 0);
        int l = dni;
        int i1 = dnj;
        int j1 = (arg0 + 24) / 48;
        int k1 = (arg1 + 24) / 48;
        eal = dnk;
        dni = j1 * 48 - 48;
        dnj = k1 * 48 - 48;
        ega = j1 * 48 - 32;
        egb = k1 * 48 - 32;
        egc = j1 * 48 + 32;
        egd = k1 * 48 + 32;
        dnh.gjj(arg0, arg1, eal);
        dni -= eai;
        dnj -= eaj;
        int l1 = dni - l;
        int i2 = dnj - i1;
        for(int j2 = 0; j2 < efd; j2++)
        {
            ekm[j2] -= l1;
            ekn[j2] -= i2;
            int k2 = ekm[j2];
            int i3 = ekn[j2];
            int l3 = ela[j2];
            i k4 = dik[j2];
            try
            {
                int j5 = elb[j2];
                int i6;
                int l6;
                if(j5 == 0 || j5 == 4)
                {
                    i6 = e.amh[l3];
                    l6 = e.ami[l3];
                } else
                {
                    l6 = e.amh[l3];
                    i6 = e.ami[l3];
                }
                int i7 = ((k2 + k2 + i6) * ehd) / 2;
                int j7 = ((i3 + i3 + l6) * ehd) / 2;
                if(k2 >= 0 && i3 >= 0 && k2 < 96 && i3 < 96)
                {
                    ejg.bgm(k4);
                    k4.cml(i7, -dnh.gjf(i7, j7), j7);
                    dnh.gla(k2, i3, l3);
                    if(l3 == 74)
                        k4.cmk(0, -480, 0);
                }
            }
            catch(RuntimeException runtimeexception)
            {
                System.out.println("Loc Error: " + runtimeexception.getMessage());
                System.out.println("i:" + j2 + " obj:" + k4);
                runtimeexception.printStackTrace();
            }
        }

        for(int l2 = 0; l2 < ehc; l2++)
        {
            dhg[l2] -= l1;
            dhh[l2] -= i2;
            int j3 = dhg[l2];
            int i4 = dhh[l2];
            int l4 = eda[l2];
            int k5 = ecn[l2];
            try
            {
                dnh.gkc(j3, i4, k5, l4);
                i j6 = fdm(j3, i4, k5, l4, l2);
                did[l2] = j6;
            }
            catch(RuntimeException runtimeexception1)
            {
                System.out.println("Bound Error: " + runtimeexception1.getMessage());
                runtimeexception1.printStackTrace();
            }
        }

        for(int k3 = 0; k3 < dhd; k3++)
        {
            dml[k3] -= l1;
            dmm[k3] -= i2;
        }

        for(int j4 = 0; j4 < dgm; j4++)
        {
            f f1 = deh[j4];
            f1.gmh -= l1 * ehd;
            f1.gmi -= i2 * ehd;
            for(int l5 = 0; l5 <= f1.gna; l5++)
            {
                f1.gnb[l5] -= l1 * ehd;
                f1.gnc[l5] -= i2 * ehd;
            }

        }

        for(int i5 = 0; i5 < ebb; i5++)
        {
            f f2 = dgf[i5];
            f2.gmh -= l1 * ehd;
            f2.gmi -= i2 * ehd;
            for(int k6 = 0; k6 <= f2.gna; k6++)
            {
                f2.gnb[k6] -= l1 * ehd;
                f2.gnc[k6] -= i2 * ehd;
            }

        }

        dnh.gii = true;
        return true;
    }

    private static final String fdh(int arg0)
    {
        String s1 = String.valueOf(arg0);
        for(int l = s1.length() - 3; l > 0; l -= 3)
            s1 = s1.substring(0, l) + "," + s1.substring(l);

        if(s1.length() > 8)
            s1 = "@gre@" + s1.substring(0, s1.length() - 8) + " million @whi@(" + s1 + ")";
        else
        if(s1.length() > 4)
            s1 = "@cya@" + s1.substring(0, s1.length() - 4) + "K @whi@(" + s1 + ")";
        return s1;
    }

    private final boolean fdi(int l, int i1)
    {
        if(l == 31 && (fbc(197) || fbc(615) || fbc(682)))
            return true;
        if(l == 32 && (fbc(102) || fbc(616) || fbc(683)))
            return true;
        if(l == 33 && (fbc(101) || fbc(617) || fbc(684)))
            return true;
        if(l == 34 && (fbc(103) || fbc(618) || fbc(685)))
            return true;
        return fac(l) >= i1;
    }

    private final void fdj(String arg0, int arg1)
    {
        if(arg1 == 2 || arg1 == 4 || arg1 == 6)
        {
            for(; arg0.length() > 5 && arg0.charAt(0) == '@' && arg0.charAt(4) == '@'; arg0 = arg0.substring(5));
            int l = arg0.indexOf(":");
            if(l != -1)
            {
                String s1 = arg0.substring(0, l);
                long l1 = t.fnc(s1);
                for(int j1 = 0; j1 < super.aan; j1++)
                    if(super.aba[j1] == l1)
                        return;

            }
        }
        if(arg1 == 2)
            arg0 = "@yel@" + arg0;
        if(arg1 == 3 || arg1 == 4)
            arg0 = "@whi@" + arg0;
        if(arg1 == 6)
            arg0 = "@cya@" + arg0;
        if(dea != 0)
        {
            if(arg1 == 4 || arg1 == 3)
                ehl = 200;
            if(arg1 == 2 && dea != 1)
                ehm = 200;
            if(arg1 == 5 && dea != 2)
                ehn = 200;
            if(arg1 == 6 && dea != 3)
                eia = 200;
            if(arg1 == 3 && dea != 0)
                dea = 0;
            if(arg1 == 6 && dea != 3 && dea != 0)
                dea = 0;
        }
        for(int i1 = 4; i1 > 0; i1--)
        {
            die[i1] = die[i1 - 1];
            eib[i1] = eib[i1 - 1];
        }

        die[0] = arg0;
        eib[0] = 300;
        if(arg1 == 2)
            if(ddj.gbc[ddk] == ddj.gbd[ddk] - 4)
                ddj.ggb(ddk, arg0, true);
            else
                ddj.ggb(ddk, arg0, false);
        if(arg1 == 5)
            if(ddj.gbc[ddm] == ddj.gbd[ddm] - 4)
                ddj.ggb(ddm, arg0, true);
            else
                ddj.ggb(ddm, arg0, false);
        if(arg1 == 6)
        {
            if(ddj.gbc[ddn] == ddj.gbd[ddn] - 4)
            {
                ddj.ggb(ddn, arg0, true);
                return;
            }
            ddj.ggb(ddn, arg0, false);
        }
    }

    private final void fdk(int l, int i1, int j1)
    {
        dnb.cbe(l, i1, j1);
        dnb.cbe(l - 1, i1, j1);
        dnb.cbe(l + 1, i1, j1);
        dnb.cbe(l, i1 - 1, j1);
        dnb.cbe(l, i1 + 1, j1);
    }

    private final void fdl()
    {
        char c1 = '\u0190';
        char c2 = 'd';
        if(dhi)
        {
            c2 = '\u01C2';
            c2 = '\u012C';
        }
        dnb.cba(256 - c1 / 2, 167 - c2 / 2, c1, c2, 0);
        dnb.cbb(256 - c1 / 2, 167 - c2 / 2, c1, c2, 0xffffff);
        dnb.cdm(dhc, 256, (167 - c2 / 2) + 20, 1, 0xffffff, c1 - 40);
        int l = 157 + c2 / 2;
        int i1 = 0xffffff;
        if(super.fkf > l - 12 && super.fkf <= l && super.fke > 106 && super.fke < 406)
            i1 = 0xff0000;
        dnb.cdl("Click here to close window", 256, l, 1, i1);
        if(dnl == 1)
        {
            if(i1 == 0xff0000)
                ecc = false;
            if((super.fke < 256 - c1 / 2 || super.fke > 256 + c1 / 2) && (super.fkf < 167 - c2 / 2 || super.fkf > 167 + c2 / 2))
                ecc = false;
        }
        dnl = 0;
    }

    public final Image createImage(int l, int i1)
    {
        if(a.fig != null)
            return a.fig.createImage(l, i1);
        if(link.fni != null)
            return link.fni.createImage(l, i1);
        else
            return super.createImage(l, i1);
    }

    private final i fdm(int l, int i1, int j1, int k1, int l1)
    {
        int i2 = l;
        int j2 = i1;
        int k2 = l;
        int l2 = i1;
        int i3 = e.amn[k1];
        int j3 = e.ana[k1];
        int k3 = e.amm[k1];
        i l3 = new i(4, 1);
        if(j1 == 0)
            k2 = l + 1;
        if(j1 == 1)
            l2 = i1 + 1;
        if(j1 == 2)
        {
            i2 = l + 1;
            l2 = i1 + 1;
        }
        if(j1 == 3)
        {
            k2 = l + 1;
            l2 = i1 + 1;
        }
        i2 *= ehd;
        j2 *= ehd;
        k2 *= ehd;
        l2 *= ehd;
        int i4 = l3.cln(i2, -dnh.gjf(i2, j2), j2);
        int j4 = l3.cln(i2, -dnh.gjf(i2, j2) - k3, j2);
        int k4 = l3.cln(k2, -dnh.gjf(k2, l2) - k3, l2);
        int l4 = l3.cln(k2, -dnh.gjf(k2, l2), l2);
        int ai[] = {
            i4, j4, k4, l4
        };
        l3.cmb(4, ai, i3, j3);
        l3.cme(false, 60, 24, -50, -10, -50);
        if(l >= 0 && i1 >= 0 && l < 96 && i1 < 96)
            ejg.bgm(l3);
        l3.chk = l1 + 10000;
        return l3;
    }

    private final void fdn()
    {
        super.fkn = "";
        super.fla = "";
    }

    private final f fea(int arg0, int arg1, int arg2, int arg3, int arg4)
    {
        if(ele[arg0] == null)
        {
            ele[arg0] = new f();
            ele[arg0].gmf = arg0;
        }
        f f1 = ele[arg0];
        boolean flag = false;
        for(int l = 0; l < ebc; l++)
        {
            if(edc[l].gmf != arg0)
                continue;
            flag = true;
            break;
        }

        if(flag)
        {
            f1.gmj = arg4;
            f1.gmm = arg3;
            int i1 = f1.gna;
            if(arg1 != f1.gnb[i1] || arg2 != f1.gnc[i1])
            {
                f1.gna = i1 = (i1 + 1) % 10;
                f1.gnb[i1] = arg1;
                f1.gnc[i1] = arg2;
            }
        } else
        {
            f1.gmf = arg0;
            f1.gmn = 0;
            f1.gna = 0;
            f1.gnb[0] = f1.gmh = arg1;
            f1.gnc[0] = f1.gmi = arg2;
            f1.gmj = arg4;
            f1.gmm = f1.gml = arg3;
            f1.gmk = 0;
        }
        dgf[ebb++] = f1;
        return f1;
    }

    private final void feb()
    {
        elm = elg;
        for(int l = 0; l < elg; l++)
        {
            eam[l] = dmi[l];
            ean[l] = dmj[l];
        }

        for(int i1 = 0; i1 < ede; i1++)
        {
            if(elm >= dnc)
                break;
            int j1 = edf[i1];
            boolean flag = false;
            for(int k1 = 0; k1 < elm; k1++)
            {
                if(eam[k1] != j1)
                    continue;
                flag = true;
                break;
            }

            if(!flag)
            {
                eam[elm] = j1;
                ean[elm] = 0;
                elm++;
            }
        }

    }

    private final void fec(boolean arg0)
    {
        int l = ((j) (dnb)).blg - 199;
        int i1 = 36;
        dnb.ccb(l - 49, 3, efh + 3);
        char c1 = '\304';
        char c2 = '\u0113';
        int k1;
        int j1 = k1 = j.cbh(160, 160, 160);
        if(dii == 0)
            j1 = j.cbh(220, 220, 220);
        else
            k1 = j.cbh(220, 220, 220);
        dnb.cam(l, i1, c1 / 2, 24, j1, 128);
        dnb.cam(l + c1 / 2, i1, c1 / 2, 24, k1, 128);
        dnb.cam(l, i1 + 24, c1, c2 - 24, j.cbh(220, 220, 220), 128);
        dnb.cbc(l, i1 + 24, c1, 0);
        dnb.cbd(l + c1 / 2, i1, 24, 0);
        dnb.cdl("Stats", l + c1 / 4, i1 + 16, 4, 0);
        dnb.cdl("Quests", l + c1 / 4 + c1 / 2, i1 + 16, 4, 0);
        if(dii == 0)
        {
            int l1 = 72;
            int j2 = -1;
            dnb.cdn("Skills", l + 5, l1, 3, 0xffff00);
            l1 += 13;
            for(int k2 = 0; k2 < 9; k2++)
            {
                int l2 = 0xffffff;
                if(super.fke > l + 3 && super.fkf >= l1 - 11 && super.fkf < l1 + 2 && super.fke < l + 90)
                {
                    l2 = 0xff0000;
                    j2 = k2;
                }
                dnb.cdn(eba[k2] + ":@yel@" + dfk[k2] + "/" + dmf[k2], l + 5, l1, 1, l2);
                l2 = 0xffffff;
                if(super.fke >= l + 90 && super.fkf >= l1 - 13 - 11 && super.fkf < (l1 - 13) + 2 && super.fke < l + 196)
                {
                    l2 = 0xff0000;
                    j2 = k2 + 9;
                }
                dnb.cdn(eba[k2 + 9] + ":@yel@" + dfk[k2 + 9] + "/" + dmf[k2 + 9], (l + c1 / 2) - 5, l1 - 13, 1, l2);
                l1 += 13;
            }

            dnb.cdn("Quest Points:@yel@" + ema, (l + c1 / 2) - 5, l1 - 13, 1, 0xffffff);
            l1 += 12;
            dnb.cdn("Fatigue: @yel@" + (dhj * 100) / 750 + "%", l + 5, l1 - 13, 1, 0xffffff);
            l1 += 8;
            dnb.cdn("Equipment Status", l + 5, l1, 3, 0xffff00);
            l1 += 12;
            for(int i3 = 0; i3 < 3; i3++)
            {
                dnb.cdn(eha[i3] + ":@yel@" + ege[i3], l + 5, l1, 1, 0xffffff);
                if(i3 < 2)
                    dnb.cdn(eha[i3 + 3] + ":@yel@" + ege[i3 + 3], l + c1 / 2 + 25, l1, 1, 0xffffff);
                l1 += 13;
            }

            l1 += 6;
            dnb.cbc(l, l1 - 15, c1, 0);
            if(j2 != -1)
            {
                dnb.cdn(dfn[j2] + " skill", l + 5, l1, 1, 0xffff00);
                l1 += 12;
                int j3 = ehh[0];
                for(int l3 = 0; l3 < 98; l3++)
                    if(edn[j2] >= ehh[l3])
                        j3 = ehh[l3 + 1];

                dnb.cdn("Total xp: " + edn[j2] / 4, l + 5, l1, 1, 0xffffff);
                l1 += 12;
                dnb.cdn("Next level at: " + j3 / 4, l + 5, l1, 1, 0xffffff);
            } else
            {
                dnb.cdn("Overall levels", l + 5, l1, 1, 0xffff00);
                l1 += 12;
                int k3 = 0;
                for(int i4 = 0; i4 < 18; i4++)
                    k3 += dmf[i4];

                dnb.cdn("Skill total: " + k3, l + 5, l1, 1, 0xffffff);
                l1 += 12;
                dnb.cdn("Combat level: " + djc.gnm, l + 5, l1, 1, 0xffffff);
                l1 += 12;
            }
        }
        if(dii == 1)
        {
            dig.gfm(dih);
            dig.gga(dih, 0, "@whi@Quest-list (green=completed)");
            for(int i2 = 0; i2 < 50; i2++)
                dig.gga(dih, i2 + 1, (ehf[i2] ? "@gre@" : "@red@") + dei[i2]);

            dig.ged();
        }
        if(!arg0)
            return;
        l = super.fke - (((j) (dnb)).blg - 199);
        i1 = super.fkf - 36;
        if(l >= 0 && i1 >= 0 && l < c1 && i1 < c2)
        {
            if(dii == 1)
                dig.gea(l + (((j) (dnb)).blg - 199), i1 + 36, super.fkh, super.fkg);
            if(i1 <= 24 && dnl == 1)
            {
                if(l < 98)
                {
                    dii = 0;
                    return;
                }
                if(l > 98)
                    dii = 1;
            }
        }
    }

    private final void fed()
    {
        if(dnl != 0)
        {
            dnl = 0;
            if(eie == 1 && (super.fke < 106 || super.fkf < 145 || super.fke > 406 || super.fkf > 215))
            {
                eie = 0;
                return;
            }
            if(eie == 2 && (super.fke < 6 || super.fkf < 145 || super.fke > 506 || super.fkf > 215))
            {
                eie = 0;
                return;
            }
            if(eie == 3 && (super.fke < 106 || super.fkf < 145 || super.fke > 406 || super.fkf > 215))
            {
                eie = 0;
                return;
            }
            if(super.fke > 236 && super.fke < 276 && super.fkf > 193 && super.fkf < 213)
            {
                eie = 0;
                return;
            }
        }
        int l = 145;
        if(eie == 1)
        {
            dnb.cba(106, l, 300, 70, 0);
            dnb.cbb(106, l, 300, 70, 0xffffff);
            l += 20;
            dnb.cdl("Enter name to add to friends list", 256, l, 4, 0xffffff);
            l += 20;
            dnb.cdl(super.fkl + "*", 256, l, 4, 0xffffff);
            if(super.fkm.length() > 0)
            {
                String s1 = super.fkm.trim();
                super.fkl = "";
                super.fkm = "";
                eie = 0;
                if(s1.length() > 0 && t.fnc(s1) != djc.gmd)
                    acj(s1);
            }
        }
        if(eie == 2)
        {
            dnb.cba(6, l, 500, 70, 0);
            dnb.cbb(6, l, 500, 70, 0xffffff);
            l += 20;
            dnb.cdl("Enter message to send to " + t.fnd(ejk), 256, l, 4, 0xffffff);
            l += 20;
            dnb.cdl(super.fkn + "*", 256, l, 4, 0xffffff);
            if(super.fla.length() > 0)
            {
                String s2 = super.fla;
                super.fkn = "";
                super.fla = "";
                eie = 0;
                int j1 = v.cek(s2);
                acl(ejk, v.ceg, j1);
                s2 = v.cej(v.ceg, 0, j1);
                s2 = u.fgd(s2);
                adg("@pri@You tell " + t.fnd(ejk) + ": " + s2);
            }
        }
        if(eie == 3)
        {
            dnb.cba(106, l, 300, 70, 0);
            dnb.cbb(106, l, 300, 70, 0xffffff);
            l += 20;
            dnb.cdl("Enter name to add to ignore list", 256, l, 4, 0xffffff);
            l += 20;
            dnb.cdl(super.fkl + "*", 256, l, 4, 0xffffff);
            if(super.fkm.length() > 0)
            {
                String s3 = super.fkm.trim();
                super.fkl = "";
                super.fkm = "";
                eie = 0;
                if(s3.length() > 0 && t.fnc(s3) != djc.gmd)
                    ach(s3);
            }
        }
        int i1 = 0xffffff;
        if(super.fke > 236 && super.fke < 276 && super.fkf > 193 && super.fkf < 213)
            i1 = 0xffff00;
        dnb.cdl("Cancel", 256, 208, 1, i1);
    }

    private final void fee(String s1)
    {
        if(dic == null)
            return;
        if(dkj)
        {
            return;
        } else
        {
            dic.ggm(dma, t.fne(s1 + ".pcm", dma), t.fnf(s1 + ".pcm", dma));
            return;
        }
    }

    private final void fef()
    {
        if(dnl != 0)
        {
            for(int l = 0; l < ejf; l++)
            {
                int j1 = ejb + 2;
                int l1 = ejc + 27 + l * 15;
                if(super.fke <= j1 - 2 || super.fkf <= l1 - 12 || super.fkf >= l1 + 4 || super.fke >= (j1 - 3) + ejd)
                    continue;
                emg(dec[l]);
                break;
            }

            dnl = 0;
            dkk = false;
            return;
        }
        if(super.fke < ejb - 10 || super.fkf < ejc - 10 || super.fke > ejb + ejd + 10 || super.fkf > ejc + eje + 10)
        {
            dkk = false;
            return;
        }
        dnb.cam(ejb, ejc, ejd, eje, 0xd0d0d0, 160);
        dnb.cdn("Choose option", ejb + 2, ejc + 12, 1, 65535);
        for(int i1 = 0; i1 < ejf; i1++)
        {
            int k1 = ejb + 2;
            int i2 = ejc + 27 + i1 * 15;
            int j2 = 0xffffff;
            if(super.fke > k1 - 2 && super.fkf > i2 - 12 && super.fkf < i2 + 4 && super.fke < (k1 - 3) + ejd)
                j2 = 0xffff00;
            dnb.cdn(dem[dec[i1]] + " " + ejm[dec[i1]], k1, i2, 1, j2);
        }

    }

    private final void feg()
    {
        if(egf == 0 && super.fke >= ((j) (dnb)).blg - 35 && super.fkf >= 3 && super.fke < ((j) (dnb)).blg - 3 && super.fkf < 35)
            egf = 1;
        if(egf == 0 && super.fke >= ((j) (dnb)).blg - 35 - 33 && super.fkf >= 3 && super.fke < ((j) (dnb)).blg - 3 - 33 && super.fkf < 35)
        {
            egf = 2;
            dkb = (int)(Math.random() * 13D) - 6;
            dkc = (int)(Math.random() * 23D) - 11;
        }
        if(egf == 0 && super.fke >= ((j) (dnb)).blg - 35 - 66 && super.fkf >= 3 && super.fke < ((j) (dnb)).blg - 3 - 66 && super.fkf < 35)
            egf = 3;
        if(egf == 0 && super.fke >= ((j) (dnb)).blg - 35 - 99 && super.fkf >= 3 && super.fke < ((j) (dnb)).blg - 3 - 99 && super.fkf < 35)
            egf = 4;
        if(egf == 0 && super.fke >= ((j) (dnb)).blg - 35 - 132 && super.fkf >= 3 && super.fke < ((j) (dnb)).blg - 3 - 132 && super.fkf < 35)
            egf = 5;
        if(egf == 0 && super.fke >= ((j) (dnb)).blg - 35 - 165 && super.fkf >= 3 && super.fke < ((j) (dnb)).blg - 3 - 165 && super.fkf < 35)
            egf = 6;
        if(egf != 0 && super.fke >= ((j) (dnb)).blg - 35 && super.fkf >= 3 && super.fke < ((j) (dnb)).blg - 3 && super.fkf < 26)
            egf = 1;
        if(egf != 0 && egf != 2 && super.fke >= ((j) (dnb)).blg - 35 - 33 && super.fkf >= 3 && super.fke < ((j) (dnb)).blg - 3 - 33 && super.fkf < 26)
        {
            egf = 2;
            dkb = (int)(Math.random() * 13D) - 6;
            dkc = (int)(Math.random() * 23D) - 11;
        }
        if(egf != 0 && super.fke >= ((j) (dnb)).blg - 35 - 66 && super.fkf >= 3 && super.fke < ((j) (dnb)).blg - 3 - 66 && super.fkf < 26)
            egf = 3;
        if(egf != 0 && super.fke >= ((j) (dnb)).blg - 35 - 99 && super.fkf >= 3 && super.fke < ((j) (dnb)).blg - 3 - 99 && super.fkf < 26)
            egf = 4;
        if(egf != 0 && super.fke >= ((j) (dnb)).blg - 35 - 132 && super.fkf >= 3 && super.fke < ((j) (dnb)).blg - 3 - 132 && super.fkf < 26)
            egf = 5;
        if(egf != 0 && super.fke >= ((j) (dnb)).blg - 35 - 165 && super.fkf >= 3 && super.fke < ((j) (dnb)).blg - 3 - 165 && super.fkf < 26)
            egf = 6;
        if(egf == 1 && (super.fke < ((j) (dnb)).blg - 248 || super.fkf > 36 + (ebe / 5) * 34))
            egf = 0;
        if(egf == 3 && (super.fke < ((j) (dnb)).blg - 199 || super.fkf > 316))
            egf = 0;
        if((egf == 2 || egf == 4 || egf == 5) && (super.fke < ((j) (dnb)).blg - 199 || super.fkf > 240))
            egf = 0;
        if(egf == 6 && (super.fke < ((j) (dnb)).blg - 199 || super.fkf > 311))
            egf = 0;
    }

    protected final int adi()
    {
        return link.fnj;
    }

    public mudclient()
    {
	logged = 0;
        idfood = 373;
        prayerid = 1;
        prayerdot = 1;
        GFX = true;
        lefty = false;
        HelpMenu = false;
        fightmenu = false;
        lefty = false;
        hpset = 20;
        namefood = "Lobster";
	AutoMenu = 0;
	AutoMenuis = 0;
        dcg = "";
        dch = 512;
        dci = 334;
        dcj = 9;
        dck = false;
        dcl = "";
        dcm = false;
        dcn = true;
        dda = new String[5];
        ddc = 1;
        ddd = 2;
        dde = 2;
        ddf = 8;
        ddg = 14;
        ddi = 1;
        dec = new int[250];
        dee = new int[8];
        def = new int[8];
        deh = new f[500];
        dej = -1;
        dek = -2;
        dem = new String[250];
        den = false;
        dfe = new int[14];
        dff = new int[14];
        dfg = false;
        dfh = false;
        dfi = new int[50];
        dfj = new int[50];
        dfk = new int[18];
        dfl = new int[250];
        dfm = new int[250];
        dga = new int[250];
        dge = false;
        dgf = new f[500];
        dgg = false;
        dgh = false;
        dgi = false;
        dgj = false;
        dhb = new f[4000];
        dhc = "";
        dhe = false;
        dhf = false;
        dhg = new int[500];
        dhh = new int[500];
        dhi = false;
        dhm = 2;
        dia = false;
        did = new i[500];
        die = new String[5];
        dij = new boolean[1500];
        dik = new i[1500];
        dil = -1;
        dim = false;
        dja = "";
        djb = "";
        djc = new f();
        djf = -1;
        djh = new int[14];
        dji = new int[14];
        djj = false;
        djk = new int[250];
        djl = new int[250];
        djm = new int[250];
        djn = true;
        dka = true;
        dkg = 128;
        dkj = false;
        dkk = false;
        dkm = new int[8];
        dkn = new int[8];
        dmb = false;
        dmf = new int[18];
        dmi = new int[256];
        dmj = new int[256];
        dmk = false;
        dml = new int[5000];
        dmm = new int[5000];
        dmn = new int[5000];
        dna = new int[5000];
        dnc = 48;
        dne = new int[14];
        dnf = new int[14];
        dnk = -1;
        dnn = new int[8000];
        eaa = new int[8000];
        eac = 550;
        ead = new int[50];
        eae = new int[50];
        eaf = new int[50];
        eag = new int[50];
        eah = new boolean[500];
        eal = -1;
        eam = new int[256];
        ean = new int[256];
        ebe = 30;
        ebg = false;
        ebh = false;
        ebk = new int[50];
        ebl = new int[50];
        ecc = false;
        ece = new int[500];
        ech = new int[14];
        eci = new int[14];
        ecj = -1;
        eck = -2;
        ecl = false;
        ecm = false;
        ecn = new int[500];
        eda = new int[500];
        edb = new i[1000];
        edc = new f[500];
        edf = new int[35];
        edg = new int[35];
        edh = new int[35];
        edi = -1;
        edj = "";
        edk = new f[500];
        edl = false;
        edm = false;
        edn = new int[18];
        eed = new int[8192];
        eee = new int[8192];
        eef = false;
        eeg = 0xbc614e;
        eeh = new boolean[50];
        efa = new int[256];
        efb = new int[256];
        efc = new int[256];
        eff = new int[8];
        efg = new int[8];
        ege = new int[5];
        egh = new String[50];
        egi = false;
        egm = 2;
        egn = new int[50];
        ehd = 128;
        ehf = new boolean[50];
        ehg = new int[50];
        ehh = new int[99];
        ehi = -1;
        ehj = -1;
        ehk = -1;
        eib = new int[5];
        eic = 40;
        eif = "";
        eih = false;
        ein = new int[8];
        eja = new int[8];
        ejm = new String[250];
        ekc = "";
        ekd = "";
        eke = "";
        ekh = false;
        ekj = new int[50];
        ekk = new int[50];
        ekl = new int[50];
        ekm = new int[1500];
        ekn = new int[1500];
        ela = new int[1500];
        elb = new int[1500];
        eld = false;
        ele = new f[5000];
        elh = new int[50];
        eli = 1;
        elk = false;
        ell = new int[50];
        eln = false;
    }

    boolean HelpMenu;
    public boolean fightmenu;
    public int logged;
    public boolean autologin = false;
    public boolean statmenu = false;
    public int hpnum;
    String foodName;
    String prayername;
    int prayerid;
    int prayerdot;
    boolean GFX;
    boolean lefty;
    int hpset;
    int idfood;
    int foodType;
    String namefood;
    boolean autoEat;
	public int AutoMenu;
	public int AutoMenuis;
    private AutoEat AE;
    public int serv;
    public String server;
    String sName;
    private final int dbi = 250;
    private final int dbj = 5;
    private final int dbk = 50;
    private final int dbl = 18;
    private final int dbm = 500;
    private final int dbn = 1500;
    private final int dca = 5000;
    private final int dcb = 5000;
    private final int dcc = 500;
    private final int dcd = 4000;
    private final int dce = 500;
    private final int dcf = 8000;
    private String dcg;
    private int dch;
    private int dci;
    private int dcj;
    private boolean dck;
    private String dcl;
    private boolean dcm;
    private boolean dcn;
    private String dda[];
    private int ddb;
    private int ddc;
    private int ddd;
    private int dde;
    private int ddf;
    private int ddg;
    private int ddh;
    private int ddi;
    private h ddj;
    int ddk;
    int ddl;
    int ddm;
    int ddn;
    int dea;
    private int deb;
    private int dec[];
    private int ded;
    private int dee[];
    private int def[];
    private int deg;
    private f deh[];
    private final String dei[] = {
        "Black knight's fortress", "Cook's assistant", "Demon slayer", "Doric's quest", "The restless ghost", "Goblin diplomacy", "Ernest the chicken", "Imp catcher", "Pirate's treasure", "Prince Ali rescue", 
        "Romeo & Juliet", "Sheep shearer", "Shield of Arrav", "The knight's sword", "Vampire slayer", "Witch's potion", "Dragon slayer", "Witch's house (members)", "Lost city (members)", "Hero's quest (members)", 
        "Druidic ritual (members)", "Merlin's crystal (members)", "Scorpion catcher (members)", "Family crest (members)", "Tribal totem (members)", "Fishing contest (members)", "Monk's friend (members)", "Temple of Ikov (members)", "Clock tower (members)", "The Holy Grail (members)", 
        "Fight Arena (members)", "Tree Gnome Village (members)", "The Hazeel Cult (members)", "Sheep Herder (members)", "Plague City (members)", "Sea Slug (members)", "Waterfall quest (members)", "Biohazard (members)", "Jungle potion (members)", "Grand tree (members)", 
        "Shilo village (members)", "Underground pass (members)", "Observatory quest (members)", "Tourist trap (members)", "Watchtower (members)", "Dwarf Cannon (members)", "Murder Mystery (members)", "Digsite (members)", "Gertrude's Cat (members)", "Legend's Quest (members)"
    };
    private int dej;
    private int dek;
    private String del;
    private String dem[];
    private boolean den;
    private int dfa;
    private int dfb;
    private int dfc;
    private int dfd;
    private int dfe[];
    private int dff[];
    private boolean dfg;
    private boolean dfh;
    private int dfi[];
    private int dfj[];
    private int dfk[];
    private int dfl[];
    private int dfm[];
    private final String dfn[] = {
        "Attack", "Defense", "Strength", "Hits", "Ranged", "Prayer", "Magic", "Cooking", "Woodcutting", "Fletching", 
        "Fishing", "Firemaking", "Crafting", "Smithing", "Mining", "Herblaw", "Agility", "Thieving"
    };
    private int dga[];
    private int dgb;
    private int dgc;
    private int dgd;
    private boolean dge;
    private f dgf[];
    private boolean dgg;
    private boolean dgh;
    private boolean dgi;
    private boolean dgj;
    private h dgk;
    private int dgl[][] = {
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
    private int dgm;
    private int dgn;
    private int dha;
    private f dhb[];
    private String dhc;
    private int dhd;
    private boolean dhe;
    private boolean dhf;
    private int dhg[];
    private int dhh[];
    private boolean dhi;
    private int dhj;
    private int dhk;
    private int dhl;
    private int dhm;
    private int dhn[] = {
        0, 1, 2, 1
    };
    private boolean dia;
    private int dib;
    private d dic;
    private i did[];
    private String die[];
    private long dif;
    private h dig;
    int dih;
    int dii;
    private boolean dij[];
    private i dik[];
    private int dil;
    private boolean dim;
    private String din;
    private String dja;
    private String djb;
    private f djc;
    int djd;
    int dje;
    int djf;
    private int djg;
    private int djh[];
    private int dji[];
    private boolean djj;
    private int djk[];
    private int djl[];
    private int djm[];
    private boolean djn;
    private boolean dka;
    private int dkb;
    private int dkc;
    private int dkd;
    private int dke;
    private int dkf;
    private int dkg;
    private int dkh;
    private final int dki[] = {
        0xecded0, 0xccb366, 0xb38c40, 0x997326, 0x906020
    };
    private boolean dkj;
    private boolean dkk;
    private int dkl;
    private int dkm[];
    private int dkn[];
    private h dla;
    private int dlb;
    private int dlc;
    private int dld;
    private int dle;
    private int dlf;
    private int dlg;
    private int dlh;
    private int dli;
    private int dlj;
    private int dlk;
    private int dll;
    private int dlm;
    private int dln;
    private byte dma[];
    private boolean dmb;
    private int dmc;
    private int dmd;
    private int dme;
    private int dmf[];
    private long dmg;
    private int dmh;
    private int dmi[];
    private int dmj[];
    private boolean dmk;
    private int dml[];
    private int dmm[];
    private int dmn[];
    private int dna[];
    private k dnb;
    private int dnc;
    private int dnd;
    private int dne[];
    private int dnf[];
    private int dng;
    private x dnh;
    private int dni;
    private int dnj;
    private int dnk;
    private int dnl;
    private h dnm;
    private int dnn[];
    private int eaa[];
    private int eab[] = {
        0, 0, 0, 0, 0, 1, 2, 1
    };
    private int eac;
    private int ead[];
    private int eae[];
    private int eaf[];
    private int eag[];
    private boolean eah[];
    private int eai;
    private int eaj;
    private int eak;
    private int eal;
    private int eam[];
    private int ean[];
    private final String eba[] = {
        "Attack", "Defense", "Strength", "Hits", "Ranged", "Prayer", "Magic", "Cooking", "Woodcut", "Fletching", 
        "Fishing", "Firemaking", "Crafting", "Smithing", "Mining", "Herblaw", "Agility", "Thieving"
    };
    private int ebb;
    private int ebc;
    private int ebd;
    private int ebe;
    private Graphics ebf;
    private boolean ebg;
    private boolean ebh;
    private int ebi;
    private int ebj;
    private int ebk[];
    private int ebl[];
    private int ebm;
    private int ebn;
    private int eca;
    private int ecb;
    private boolean ecc;
    private int ecd;
    private int ece[];
    private int ecf;
    private int ecg;
    private int ech[];
    private int eci[];
    private int ecj;
    private int eck;
    private boolean ecl;
    private boolean ecm;
    private int ecn[];
    private int eda[];
    private i edb[];
    private f edc[];
    private int edd;
    private int ede;
    private int edf[];
    private int edg[];
    private int edh[];
    private int edi;
    String edj;
    private f edk[];
    private boolean edl;
    private boolean edm;
    private int edn[];
    private int eea;
    private int eeb;
    private int eec;
    int eed[];
    int eee[];
    private boolean eef;
    private int eeg;
    private boolean eeh[];
    private int eei;
    private int eej;
    private int eek;
    private int eel;
    private int eem;
    private int een;
    private int efa[];
    private int efb[];
    private int efc[];
    private int efd;
    private int efe;
    private int eff[];
    private int efg[];
    private int efh;
    private int efi;
    private int efj;
    private int efk;
    private int efl;
    private int efm;
    private int efn;
    private int ega;
    private int egb;
    private int egc;
    private int egd;
    private int ege[];
    private int egf;
    private int egg;
    String egh[];
    private boolean egi;
    private int egj;
    private int egk;
    private int egl;
    private int egm;
    private int egn[];
    private final String eha[] = {
        "Armour", "WeaponAim", "WeaponPower", "Magic", "Prayer"
    };
    private int ehb;
    private int ehc;
    private int ehd;
    private int ehe;
    private boolean ehf[];
    private int ehg[];
    private int ehh[];
    private int ehi;
    private int ehj;
    private int ehk;
    private int ehl;
    private int ehm;
    private int ehn;
    private int eia;
    private int eib[];
    private int eic;
    private final int eid[] = {
        0xff0000, 0xff8000, 0xffe000, 0xa0e000, 57344, 32768, 41088, 45311, 33023, 12528, 
        0xe000e0, 0x303030, 0x604000, 0x805000, 0xffffff
    };
    private int eie;
    private String eif;
    private int eig;
    private boolean eih;
    private final int eii[] = {
        0xffc030, 0xffa040, 0x805030, 0x604020, 0x303030, 0xff6020, 0xff4000, 0xffffff, 65280, 65535
    };
    private h eij;
    int eik;
    int eil;
    private int eim;
    private int ein[];
    private int eja[];
    private int ejb;
    private int ejc;
    private int ejd;
    private int eje;
    private int ejf;
    private n ejg;
    private h ejh;
    int eji;
    int ejj;
    long ejk;
    private int ejl;
    private String ejm[];
    private int ejn;
    private int eka;
    private int ekb;
    private String ekc;
    private String ekd;
    private String eke;
    private int ekf;
    private int ekg;
    private boolean ekh;
    private h eki;
    private int ekj[];
    private int ekk[];
    private int ekl[];
    private int ekm[];
    private int ekn[];
    private int ela[];
    private int elb[];
    private int elc;
    private boolean eld;
    private f ele[];
    private int elf;
    private int elg;
    private int elh[];
    private int eli;
    private int elj;
    private boolean elk;
    private int ell[];
    private int elm;
    private boolean eln;
    private int ema;
    private int emb;
    int emc;
    int emd;
    private int eme[] = {
        0, 1, 2, 1, 0, 0, 0, 0
    };
    private final String emf[] = {
        "Where were you born?", "What was your first teachers name?", "What is your fathers middle name?", "Who was your first best friend?", "What is your favourite vacation spot?", "What is your mothers middle name?", "What was your first pets name?", "What was the name of your first school?", "What is your mothers maiden name?", "Who was your first boyfriend/girlfriend?", 
        "What was the first computer game you purchased?", "Who is your favourite actor/actress?", "Who is your favourite author?", "Who is your favourite musician?", "Who is your favourite cartoon character?", "What is your favourite book?", "What is your favourite food?", "What is your favourite movie?"
    };
}
																																				//rstyrant - Made and created by at rstyrant.com
