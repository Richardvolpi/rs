import java.applet.Applet;
import java.awt.*;
import java.io.IOException;
import java.io.PrintStream;
import java.net.*;
import com.sun.image.codec.jpeg.*;
import java.awt.image.*;
import java.util.*; 
import java.io.*;
import javax.imageio.ImageIO.*;

public class mudclient extends Applet_Sub1_Sub1
{
    public Random generator = new Random(1337);
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    public File slword = new File("slword.txt");
    public int ARROWUP = 1004;
    public int ARROWDOWN = 1005; 
    public int PGDN = 1002;
    public int PGUP = 1003;
    public int serv;
    public int objid;
    public String server;
    public String currenttime;
    public String Xusername = "";
    public String Xpassword = "";
    public String word = "";
    public boolean arrowkeydown = false;
    public boolean arrowkeyup = false;
    public boolean pgupdown = false;
    public boolean pgdowndown = false;
    public boolean adown = false;
    public boolean ddown = false;
    public boolean sdown = false;
    public boolean wdown = false;
    public boolean homedown = false;
    public boolean enddown = false;
    public boolean pkermap;
    public boolean lefty;
    public boolean loggedout = true;
    public boolean show = true;
    public Calendar cal = new GregorianCalendar();
    public long modifiedTime;
    public int lastFightMode = -1;
    public int sleepthresh = 101;
    public String myChat = "";
    public String playerChat = "";
    public String NPCChat = "";
    public boolean asleep = false;
    public int focusx = 1;
    public int focusy = 1;
    public int maphax = 1;
    public int lastitempos;
    public int selectedplayer;
    public int chosenx;
    public int choseny;
    public autofight fightthread;
    public boolean macroOn = false;
    public int selectedNPC = -1;
    public int attackAttempts = 0;
    public boolean isSleeping = false;
    public int startXP = 0;
    public int currentXP = 0;
    public int lockedFightMode = -1;
    
    
    private class autofight extends Thread
    {
    	public void run()
    	{
    		while(macroOn)
    		{
    			if(fightMode != lockedFightMode)
    			{
    				setmode(lockedFightMode);
    				chatText2("@bot@Fixing Fightmode to LockedMode");
    			}
    			if(incombat())
    			{
    				Wait(100);
    			}
    			if(!incombat())
    			{
    				if(fatigue() > 95)
    				{
    					if(!isSleeping && inventoryCount(1263) > 0)
    						useitem(1263);
    					else
    						Wait(100);
    				}
    				int nearestNPC = getnearestnpcbyid(selectedNPC);
    				if(nearestNPC != -1)
    				{
    					attacknpc(nearestNPC);
    					attackAttempts++;
    					Wait(500);
    				} else 
    					Wait(100);
    			} else 
    				Wait(100);
    		}
    	}
    	autofight()
    	{
    		start();
    	}
    }
    
    public void puttrade(int id, int count)
    {
    	super.packets.packetID(116);
        super.packets.variables348(id);
        super.packets.variables343(id);
        super.packets.method332(count);
        super.packets.sendpacket();
        tradeItemID[tradePosCount] = id;
        tradeItemCount[tradePosCount] = count;
        tradePosCount++;
        hasAccepted = false;
        tradeWindow2 = false;
    }
    
    public void poptrade(int id, int count)
    {
    	int storedcount = 0;
    	for(int x = 0; x < tradeItemID.length; x++)
    	{
    		if(tradeItemID[x] == id)
    		{
    			tradePosCount = x;
    			storedcount = tradeItemCount[x];
    			super.packets.packetID(116);
        		super.packets.variables348(id);
        		super.packets.variables343(id);
        		super.packets.method332(storedcount - count);
        		super.packets.sendpacket();
        		tradeItemID[x] = id;
        		tradeItemCount[x] = storedcount - count;
        		hasAccepted = false;
        		tradeWindow2 = false;
    		}
    	}
    }
    
    public void castonnpcbyname(int spell, String name)
    {
    	selectspell(spell);
    	int a = nearestnpcbyname(name);
    	if(a != -1)
    	{
        	optionIDArray[0] = 700;
        	optionObjXArray[0] = NPCArray[a].posX;
        	optionObjYArray[0] = NPCArray[a].posY;
        	optionObjIDArray[0] = NPCArray[a].ID;
        	optionObjNameArray[0] = selectedSpell;
        	optionPacketSender(0);
        }
    }
    
    public int nearestnpcbyname(String name)
    {
        int ai[] = new int[npccount()];
        int ai1[] = new int[npccount()];
        int ai2[] = new int[npccount()];
        int j = 0;
        boolean flag = false;
        boolean flag1 = false;
        double d = 9999999D;
        int i1 = -1;
        for(int j1 = 0; j1 < npccount(); j1++)
            if(NPCArray[j1].name == name && NPCArray[j1].status == 0)
            {
                ai[j] = (NPCArray[j1].posX - 64) / anInt946;
                ai1[j] = (NPCArray[j1].posY - 64) / anInt946;
                ai2[j] = j1;
                j++;
            }

        try
        {
            for(int k1 = 0; k1 <= j; k1++)
                if(NPCArray[ai2[k1]].name == name)
                {
                    int k = Math.abs(Math.abs(myPlayerX2) - Math.abs(ai[k1]));
                    int l = Math.abs(Math.abs(myPlayerY2) - Math.abs(ai1[k1]));
                    if(k == 0 || l == 0)
                    {
                        if((double)(k + l) < d)
                        {
                            d = k + l;
                            i1 = ai2[k1];
                        }
                    } else
                    if((double)(k + l) * 0.5D < d)
                    {
                        d = (double)(k + l) * 0.5D;
                        i1 = ai2[k1];
                    }
                }

        }
        catch(Exception _ex) { }
        if(i1 > -1 && i1 < npccount())
            return i1;
        else
            return -1;
    } 
    
    public void castonnpcbyid(int spell, int id)
    {
    	selectspell(spell);
    	int a = getnearestnpcbyid(id);
    	if(a != -1)
    	{
        	optionIDArray[0] = 700;
        	optionObjXArray[0] = NPCArray[a].posX;
        	optionObjYArray[0] = NPCArray[a].posY;
        	optionObjIDArray[0] = NPCArray[a].ID;
        	optionObjNameArray[0] = selectedSpell;
        	optionPacketSender(0);
        }
    }
    
    public void castonitemcoords(int spell, int id, int x, int y)
    {
    	int a = findnearestitem(id);
    	selectspell(spell);
        optionIDArray[0] = 200;
        optionObjXArray[0] = x - myPlayerX1;
        optionObjYArray[0] = y - myPlayerY1;
        optionObjIDArray[0] = itemIDArray[a];
        optionObjNameArray[0] = selectedSpell;
        optionPacketSender(0);
    }
    
    public void castongrounditem(int spell, int id)
    {
    	int a = findnearestitem(id);
    	selectspell(spell);
        optionIDArray[0] = 200;
        optionObjXArray[0] = itemXArray[a];
        optionObjYArray[0] = itemYArray[a];
        optionObjIDArray[0] = itemIDArray[a];
        optionObjNameArray[0] = selectedSpell;
        optionPacketSender(0);
    }
    
    public void castonitemid(int spell, int id)
    {
    	selectspell(spell);
    	int a = finditempos(id);
        optionIDArray[0] = 600;
        optionObjIDArray[0] = a;
        optionObjNameArray[0] = selectedSpell;
        optionPacketSender(0);
    }
    
    public void castonitem(int spell, int pos)
    {
    	selectspell(spell);
        optionIDArray[0] = 600;
        optionObjIDArray[0] = pos;
        optionObjNameArray[0] = selectedSpell;
        optionPacketSender(0);
    }
    
    public void depositeverything()
    {
 	for(int x = 0; x < inventoryItemID.length; x++)
 	{
 		int a = inventoryCount(x);
 		for(int z = a; z > 0; z--)
 		{
 			a = inventoryCount(x);
 			if(a >= 50000)
 				deposit(inventoryItemID[x],50000);
 			if(a < 50000)
 				deposit(inventoryItemID[x],a);
 		}
 	}
    }
    
    public int finditempos(int id)
    {
    	for(int x = 0; x < inventoryItemID.length; x++)
    	{
    		if(inventoryItemID[x] == id && x != lastitempos)
    		{
    			lastitempos = x;
    			return x;
        	}
        }
        return -1;
    }
    
    public void selectitemid(int id)
    {
    	for(int x = 0; x < inventoryItemID.length; x++)
    	{
    		if(inventoryItemID[x] == id)
    		{
    			selectedItem = x;
        		toolbar = 0;
        		selectedItemName = Class1.itemNameArray[inventoryItemID[x]];
        	}
        }
    }
    
    public void useitemposwithitempos(int pos1, int pos2)
    {
        selectitem(pos1);
        optionIDArray[0] = 610;
        optionObjIDArray[0] = pos2;
        optionObjNameArray[0] = pos1;
 	optionPacketSender(0);
    }
    
    public void useitemwithitem(int id1, int id2)
    {
        int a = finditempos(id1);
        int b = finditempos(id2);
        selectitemid(a);
        optionIDArray[0] = 610;
        optionObjIDArray[0] = b;
        optionObjNameArray[0] = a;
 	optionPacketSender(0);
        
    }
    
    public void buyitem(int pos)
    {    
    	int l6 = Class1.anInt144;
    	int i3 = anInt900 + anIntArray738[pos];
        if(i3 < 10)
            i3 = 10;
        int i4 = (i3 * Class1.shopBaseWorth[shopItemID[pos]]) / 100;
        super.packets.packetID(157);
        super.packets.variables343(shopItemID[pos]);
        super.packets.method332(i4);
        super.packets.sendpacket();
    }
    
    public void buyitemid(int id)
    {    
    	int a = selectShopItem(id);
    	int l6 = Class1.anInt144;
    	int i3 = anInt900 + anIntArray738[a];
        if(i3 < 10)
            i3 = 10;
        int i4 = (i3 * Class1.shopBaseWorth[id]) / 100;
        super.packets.packetID(157);
        super.packets.variables343(shopItemID[a]);
        super.packets.method332(i4);
        super.packets.sendpacket();
    }
    
    public void sellitem(int pos)
    {
    	int l6 = Class1.anInt144;
    	int j3 = anInt899 + anIntArray738[pos];
    	if(j3 < 10)
            j3 = 10;
        int j4 = (j3 * Class1.shopBaseWorth[shopItemID[pos]]) / 100;
    	super.packets.packetID(211);
        super.packets.variables343(shopItemID[pos]);
        super.packets.method332(j4);
        super.packets.sendpacket();
    }
    
    public void sellitemid(int id)
    {    
    	int a = selectShopItem(id);
    	int l6 = Class1.anInt144;
    	int j3 = anInt899 + anIntArray738[a];
    	if(j3 < 10)
            j3 = 10;
        int j4 = (j3 * Class1.shopBaseWorth[id]) / 100;
    	super.packets.packetID(211);
        super.packets.variables343(shopItemID[a]);
        super.packets.method332(j4);
        super.packets.sendpacket();
    }
    
    public int selectShopItem(int id)
    {
    	for(int x = 0; x <= anIntArray738.length; x++)
    	{
    		if(shopItemID[x] == id)
    		{
    			return x;
    		}
    	}
    	return -1;
    }
    
    public int shopItemCountID(int id)
    {
    	for(int x = 0; x <= anIntArray738.length; x++)
    	{
    		if(shopItemID[x] == id)
    		{
    			return shopItemCount[x];
    		}
    	}
    	return 0;
    }
    
    public int shopItemCount(int pos)
    {
    	return shopItemCount[pos];
    }
    
    public void closeshop()
    {
        super.packets.packetID(56);
        super.packets.sendpacket();
        aBoolean727 = false;
        System.out.println("CloseShop()");
        XClient.sendPacket("SHOPWINDOW 0");
    }
    
    public int getrandom(int lower, int higher)
    {
 	return generator.nextInt((higher+1)-lower) + lower;
    }
    
    public int itemx(int id)
    {
   	for(int x = 0; x < itemIDArray.length; x++)
 	{
		int a = itemIDArray[x];
		if(a == id)
		{
   			return (itemXArray[x] + myPlayerX1);
   		}
   	}
 	return -1;
    }

    public int itemy(int id)
    {
    	for(int x = 0; x < itemIDArray.length; x++)
 	{
		int a = itemIDArray[x];
		if(a == id)
		{
 			return (itemYArray[x] + myPlayerY1);
 		}
 	}
 	return -1;
    }
    
    public boolean itemat(int id, int x, int y)
    {
 	for (int i = 0; i < itemCount; i++)
 	{
 		if (itemIDArray[i] == id)
  		{
   			if (itemx(i) == x)
   			{
    				if (itemy(i) == y)
    				{
    					return true;
    				}
   			}
  		}
 	}
 	return false;
    }
   
    public int findnearestitem(int id)
    {
 	for (int x = 0; x < itemCount; x++ )
 	{
  		if (itemIDArray[x] == id)
  		{
   			if (findnearestitemx(id) == (itemx(x)))
   			{
    				if (findnearestitemy(id) == (itemy(x)))
    				{
     					return x;
    				}
   			}
  		}
 	}
 	return -1;
    }
    
    public int findnearestitemx(int id)
    {
 	int dir = 1;
 	int len = 50;
 	int x = posX();
 	int y = posY();

	if (itemat(id,x,y) == true)
	{
		return x;
	}
	for (int i = 1; i <= len; i++)
	{
	 	for (int j = 1; j <= i; j++ )
	 	{
	 		x = x + dir;
	  		if (itemat(id,x,y) == true)
	  		{
	   			return x;
	  		}
	 	}
	 	for (int j = 1; j <= i; j++ )
	 	{
	  		y = y + dir;
	   		if (itemat(id,x,y) == true)
	  		{
	   			return x;
	  		}
	 	}
	 	dir = 0 - dir;
	}
	return -1;
    }
    
    public int findnearestitemy(int id)
    {
	 int dir = 1;
	 int len = 50;
	 int x = posX();
	 int y = posY();
	   
	 if (itemat(id,x,y) == true)
	 {
	  return y;
	 }
	
	 for (int i = 1; i <= len; i++)
	 {
	  for (int j = 1; j <= i; j++ )
	  {
	   x = x + dir;
	   if (itemat(id,x,y) == true)
	   {
	    return y;
	   }
	  }
	  for (int j = 1; j <= i; j++ )
	  {
	   y = y + dir;
	   if (itemat(id,x,y) == true)
	   {
	    return y;
	   }
	  }
	  dir = 0 - dir;
	 }
	 return -1;
    }
    
    public int bankCount(int pos)
    {
        return bankItemCount[pos];
    }
    
    public int bankCountID(int i)
    {
        int l = Class1.anInt144;
        int j = 0;
        for(int k = 0; k < bankItemID.length; k++)
        {
            if(bankItemID[k] == i)
            	j = bankItemCount[k];
    	}
	return j;
	
    }
    public int inventoryPositionCount(int pos)
    {
        return inventoryCount(inventoryItemID[pos]);
    }
    
    public void mageplayerid(int spell, int player)
    {
        selectspell(spell);
        optionIDArray[0] = 800;
        optionObjIDArray[0] = PlayerArray[player].ID;
        optionObjNameArray[0] = selectedSpell;
 	optionPacketSender(0);
    }
    
    public void selectspell(int spell)
    {
    	selectedSpell = spell;
    	toolbar = 0;
    }
    
    public void magicplayer(int spell, int player)
    {
        selectspell(spell);
        optionIDArray[0] = 800;
        optionObjIDArray[0] = player;
        optionObjNameArray[0] = selectedSpell;
        macroaction();
    }
    
    public void selectitem(int pos)
    {
    	selectedItem = pos;
        toolbar = 0;
        selectedItemName = Class1.itemNameArray[inventoryItemID[pos]];
    }
    
    public void atobjectwith(int item, int obj)
    {
        selectitem(item);
        for(int x = 0; x < objID.length; x++)
 	{
		int a = objID[x];
		if(a == obj)
		{
        		optionIDArray[0] = 410;
        		optionObjXArray[0] = objXArray[x];
        		optionObjYArray[0] = objYArray[x];
        		optionObjIDArray[0] = anIntArray763[x];
        		optionObjNameArray[0] = objID[x];
        		anIntArray805[0] = item;
 			optionPacketSender(0);
 			macroaction();
 		}
         }
    }
    
    public void accepttrade1()
    {
    	tradeWindow2 = true;
        super.packets.packetID(38);
        super.packets.sendpacket();
    }
    
    public void accepttrade2()
    {
	  tradeFinished = true;
	  super.packets.packetID(65);
	  super.packets.sendpacket();
    }
    
    public void declinetrade()
    {
	tradeWindow = false;
	super.packets.packetID(178);
	super.packets.sendpacket();
    }
    public void acceptduel1()
    {
    	duelWindow2 = true;
        super.packets.packetID(245);
        super.packets.sendpacket();
    }
    
    public void acceptduel2()
    {
	duelFinished = true;
	super.packets.packetID(24);
	super.packets.sendpacket();
    }
    
    public void declineduel()
    {
	duelWindow = false;
	super.packets.packetID(82);
	super.packets.sendpacket();
    }
    
    public void chat(String s)
    {
        int k3 = Class17.method400(s);
        method34(Class17.aByteArray569, k3);
        s = Class17.method399(Class17.aByteArray569, 0, k3);
        s = Class16.ChatFilter(s);
        myPlayer.anInt161 = 150;
        myPlayer.lastChatMessage = s;
        chatText("@yel@[" + myPlayer.name + "] " + s, 2);
    }
    
    public void readword()
    {
    	if(slword.exists())
    	modifiedTime = slword.lastModified();
    	try 
    	{
        	BufferedReader in = new BufferedReader(new FileReader(slword));
        	String str;
        	while ((str = in.readLine()) != null) 
        	{
        		word = str;
        		System.out.println("Sleep Word Read Successfully: " + word);
        	}
        in.close();
    	} catch (IOException e) { }
    }

    
    public void removebyid(int id)
    {
    	for (int j = 0; j < inventoryItemID.length; j++)
    	if(inventoryItemID[j] == id)
    	{
    		super.packets.packetID(170);
        	super.packets.variables343(j);
        	super.packets.sendpacket();
		break;
	}    
    }
    
    public void remove(int pos)
    {
    	super.packets.packetID(170);
    	super.packets.variables343(pos);
    	super.packets.sendpacket();
    }
    
    public void wieldbyid(int id)
    {
    	for (int j = 0; j < inventoryItemID.length; j++)
    	if(inventoryItemID[j] == id)
    	{
    		super.packets.packetID(12);
        	super.packets.variables343(j);
        	super.packets.sendpacket();
		break;
	}    
    }
    
    public void wield(int pos)
    {
    	super.packets.packetID(12);
    	super.packets.variables343(pos);
    	super.packets.sendpacket();
    }
    
    public void dropitembyid(int id)
    {
        for (int j = 0; j < inventoryItemID.length; j++)
    		if(inventoryItemID[j] == id)
    		{
        		super.packets.packetID(196);
        		super.packets.variables343(j);
        		super.packets.sendpacket();
        		selectedItem = -1;
        		toolbar = 0;
        	}
    }
    
    public void dropitem(int pos)
    {
        super.packets.packetID(196);
        super.packets.variables343(pos);
        super.packets.sendpacket();
        selectedItem = -1;
        toolbar = 0;
    }
    
    public void followplayer(int i)
    {
        super.packets.packetID(36);
        super.packets.variables343(i);
        super.packets.sendpacket();
    }
    
    public void duelplayer(int i)
    {
        super.packets.packetID(89);
        super.packets.variables343(i);
        super.packets.sendpacket();
    }
    
    public void tradeplayer(int i)
    {
        super.packets.packetID(250);
        super.packets.variables343(i);
        super.packets.sendpacket();
    }
    
    public void attackplayer(int i)
    {
        super.packets.packetID(210);
        super.packets.variables343(i);
        super.packets.sendpacket();
    }
    
    public int playerfromname(String name)
    {
	for (int i = 0; i < PlayerCount; i++)
	{
		if (PlayerArray[i].name != null)
		{
			if (PlayerArray[i].name.equalsIgnoreCase(name))
			{
				return PlayerArray[i].ID;
			}
		}
	}
	return -1;
    }
    
    public void talktonpc2(int i)
    {
    	optionIDArray[0] = 720;
        optionObjXArray[0] = NPCArray[i].posX;
        optionObjYArray[0] = NPCArray[i].posY;
        optionObjIDArray[0] = NPCArray[i].ID;
        toolbar = 0;
        optionPacketSender(0);
        macroaction();
    }
    
    public int getnpcbyname(String name)
    {
    	for(int i = 0; i < npccount(); i++)
    	{
    		 String npc = Class1.NPCNameArray[NPCArray[i].combatlvl];
    		 if(npc.equalsIgnoreCase(name))
    		 {
    		 	return i;
    		 }
    	}
    	return -1;
    }
    
    public void npcbyname(String name)
    {
    	for(int i = 0; i < npccount(); i++)
    	{
    		 String npc = Class1.NPCNameArray[NPCArray[i].combatlvl];
    		 if(npc.equalsIgnoreCase(name))
    		 {
    		 	talktonpc2(i);
    		 	break;
    		 }
    	}
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

      System.out.println("Writing HC.BMP"); 
      saveOutput("HC.BMP", picBytes); 
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
      catch(IOException ioexception) 
      { 
         System.out.println("EXCEPTION"); 
      } 
   } 

    
    public int pos(char c, String s)
    {
        return s.indexOf(c) + 1;
    }
    
    public String copy(int i, int j, String s)
    {
        String s1 = "";
        for(int k = i - 1; k < j; k++)
            s1 = s1 + s.charAt(k);

        return s1;
    }
    
    public void gettime()
    {
    	int hour12 = cal.get(Calendar.HOUR);            // 0..11
    	int min = cal.get(Calendar.MINUTE);             // 0..59
    	int sec = cal.get(Calendar.SECOND);             // 0..59
    	if(hour12 < 10 && min > 10 && sec > 10)
    		currenttime = ("@gre@(@whi@0" + hour12 + "@gre@:@whi@" + min + "@gre@:@whi@" + sec + "@gre@)@whi@");
    	if(hour12 < 10 && min < 10)
    		currenttime = ("@gre@(@whi@0" + hour12 + "@gre@:@whi@0" + min + "@gre@:@whi@" + sec + "@gre@)@whi@");
    	if(hour12 < 10 && min < 10 && sec < 10)
    		currenttime = ("@gre@(@whi@0" + hour12 + "@gre@:@whi@0" + min + "@gre@:@whi@0" + sec + "@gre@)@whi@");
    	if(hour12 < 10 && sec < 10)
    		currenttime = ("@gre@(@whi@0" + hour12 + "@gre@:@whi@" + min + "@gre@:@whi@0" + sec + "@gre@)@whi@");
    	if(hour12 >= 10 && min < 10)
    		currenttime = ("@gre@(@whi@" + hour12 + "@gre@:@whi@0" + min + "@gre@:@whi@" + sec + "@gre@)@whi@");
    	if(hour12 < 10 && min > 10)
    		currenttime = ("@gre@(@whi@0" + hour12 + "@gre@:@whi@" + min + "@gre@:@whi@" + sec + "@gre@)@whi@");
    	if(hour12 < 10 && min > 10 && sec > 10)
    		currenttime = ("@gre@(@whi@0" + hour12 + "@gre@:@whi@" + min + "@gre@:@whi@" + sec + "@gre@)@whi@");
    	if(hour12 < 10 && sec > 10)
    		currenttime = ("@gre@(@whi@0" + hour12 + "@gre@:@whi@" + min + "@gre@:@whi@" + sec + "@gre@)@whi@");
    	if(hour12 >= 10 && min > 10)
    		currenttime = ("@gre@(@whi@" + hour12 + "@gre@:@whi@" + min + "@gre@:@whi@" + sec + "@gre@)@whi@");
    	if(sec < 10 && min < 10)
    		currenttime = ("@gre@(@whi@" + hour12 + "@gre@:@whi@0" + min + "@gre@:@whi@0" + sec + "@gre@)@whi@");
    	if(min > 9)
    		currenttime = ("@gre@(@whi@" + hour12 + "@gre@:@whi@" + min + "@gre@:@whi@" + sec + "@gre@)@whi@");
    	if(sec < 10)
    		currenttime = ("@gre@(@whi@" + hour12 + "@gre@:@whi@" + min + "@gre@:@whi@0" + sec + "@gre@)@whi@");
    }
    
    public void forcelogout()
    {
    	method22();
    	loggedout = true;
    }
    
    public void login()
    {
    	method21(username, password, false);
        System.out.println("[><] UID " + super.abc);
    	if(lastFightMode != -1)
    	{
    		setmode(lastFightMode);
    		chatText2("@bot@Setting Fightmode to " + lastFightMode);
    	}
    	else
    		setmode(1);
    }
    
    public void changeworld(int i)
    {	
	if(i == 51)
	{
		super.Server = "217.138.31.250"; // World 51
		super.ServerPort = 43594;
		members = false;
		System.out.println("[><] Server 51");
	}else
	if(i == 52)
	{
		super.Server = "217.138.31.250"; // World 52
		super.ServerPort = 43595;
		members = true;
		System.out.println("[><] Server 52");
	}else
	if(i == 53)
	{
		super.Server = "209.237.251.20"; // World 53
		super.ServerPort = 43594;
		members = false;
		System.out.println("[><] Server 53");
	}else
	if(i == 54)
	{
		super.Server = "209.237.251.20"; // World 54
		super.ServerPort = 43595;
		members = true;
		System.out.println("[><] Server 54");
	}else
	if(i == 55)
	{
		super.Server = "69.22.158.236"; // World 55
		super.ServerPort = 43594;
		members = false;
		System.out.println("[><] Server 55");
	}else
	if(i == 56)
	{
		super.Server = "69.22.158.236"; // World 56
		super.ServerPort = 43595;
		members = true;
		System.out.println("[><] Server 56");
	}else
	{
		super.Server = "217.138.31.250"; // Default (51)
		super.ServerPort = 43594;
		members = false;
		System.out.println("[><] Server 51");
	}
    }
    
    public void answer(int number)
    {
        super.packets.packetID(203);
        super.packets.variables348(number);
        super.packets.sendpacket();
        answerMenu = false;
        System.out.println("Answer(" + number + ")");
        XClient.sendPacket("ANSWERMENU 0");
    }
    
    public void closebank()
    {
    	super.packets.packetID(50);
    	super.packets.sendpacket();
    	aBoolean879 = false;
    	XClient.sendPacket("BANKWINDOW 0");
    }
    
    public void withdraw(int i, int j)
    {
    	super.packets.packetID(83);
        super.packets.variables343(i);
        super.packets.variables343(j);
        super.packets.sendpacket();
    }
    
    public void deposit(int i, int j)
    {
    	super.packets.packetID(145);
        super.packets.variables343(i);
        super.packets.variables343(j);
        super.packets.sendpacket();
    }
    
    public void macroaction()
    {
    	super.anInt12 = 0;
    }
    
    public void atobject(int i, int j)
    {
        super.packets.packetID(90);
        super.packets.variables343(i);
        super.packets.variables343(j);
        super.packets.sendpacket();
    }
    
    public void takeat(int x, int y, int id)
    {
        optionIDArray[0] = 220;
        optionObjXArray[0] = x - myPlayerX1;
        optionObjYArray[0] = y - myPlayerY1;
        optionObjIDArray[0] = id;
 	optionPacketSender(0);
 	macroaction();
    }
    
    public void takebyname(String name)
    {
        int l4 = Class1.anInt144;
	String a = "";
    	for(int x = 0; x < itemIDArray.length; x++)
 	{
		a = Class1.itemNameArray[itemIDArray[x]];
		if(a.equalsIgnoreCase(name))
		{
        		optionIDArray[0] = 220;
        		optionObjXArray[0] = itemXArray[x];
        		optionObjYArray[0] = itemYArray[x];
        		optionObjIDArray[0] = itemIDArray[x];
 			optionPacketSender(0);
 			macroaction();
 			return;
        	}
        	
        }
        if(a == null)
        	System.out.println("No Item By That Name Found");
    }
    
    public void takebyid(int i)
    {
    	for(int x = 0; x < itemIDArray.length; x++)
 	{
		int a = itemIDArray[x];
		if(a == i)
		{
        		optionIDArray[0] = 220;
        		optionObjXArray[0] = itemXArray[x];
        		optionObjYArray[0] = itemYArray[x];
        		optionObjIDArray[0] = itemIDArray[x];
 			optionPacketSender(0);
 			macroaction();
        	}
        }
    }
    
    public void take123(int i)
    {
        optionIDArray[0] = 220;
        optionObjXArray[0] = itemXArray[i];
        optionObjYArray[0] = itemYArray[i];
        optionObjIDArray[0] = itemIDArray[i];
 	optionPacketSender(0);
 	macroaction();
    }
    
    public int objx(int id)
    {
   	for(int x = 0; x < objXArray.length; x++)
 	{
		int a = objID[x];
		if(a == id)
		{
   			return (objXArray[x] + myPlayerX1);
   		}
   	}
 	return -1;
    }

    public int objy(int id)
    {
    	for(int x = 0; x < objXArray.length; x++)
 	{
		int a = objID[x];
		if(a == id)
		{
 			return (objYArray[x] + myPlayerY1);
 		}
 	}
 	return -1;
    }
    
    public boolean objat(int id, int x, int y)
    {
 	for (int i = 0; i < objCount; i++)
 	{
 		if (objID[i] == id)
  		{
   			if (objx(i) == x)
   			{
    				if (objy(i) == y)
    				{
    					return true;
    				}
   			}
  		}
 	}
 	return false;
    }
   
    public int findnearestobj(int id)
    {
 	for (int x = 0; x < objCount; x++ )
 	{
  		if (objID[x] == id)
  		{
   			if (findnearestobjx(id) == (objx(x)))
   			{
    				if (findnearestobjy(id) == (objy(x)))
    				{
     					return x;
    				}
   			}
  		}
 	}
 	return -1;
    }
    
    public int findnearestobjx(int id)
    {
 	int dir = 1;
 	int len = 50;
 	int x = posX();
 	int y = posY();

	if (objat(id,x,y) == true)
	{
		return x;
	}
	for (int i = 1; i <= len; i++)
	{
	 	for (int j = 1; j <= i; j++ )
	 	{
	 		x = x + dir;
	  		if (objat(id,x,y) == true)
	  		{
	   			return x;
	  		}
	 	}
	 	for (int j = 1; j <= i; j++ )
	 	{
	  		y = y + dir;
	   		if (objat(id,x,y) == true)
	  		{
	   			return x;
	  		}
	 	}
	 	dir = 0 - dir;
	}
	return -1;
    }
    
    public int findnearestobjy(int id)
    {
	 int dir = 1;
	 int len = 50;
	 int x = posX();
	 int y = posY();
	   
	 if (objat(id,x,y) == true)
	 {
	  return y;
	 }
	
	 for (int i = 1; i <= len; i++)
	 {
	  for (int j = 1; j <= i; j++ )
	  {
	   x = x + dir;
	   if (objat(id,x,y) == true)
	   {
	    return y;
	   }
	  }
	  for (int j = 1; j <= i; j++ )
	  {
	   y = y + dir;
	   if (objat(id,x,y) == true)
	   {
	    return y;
	   }
	  }
	  dir = 0 - dir;
	 }
	 return -1;
    }
    
    public void action(int i)
    {
 	for(int x = 0; x < objID.length; x++)
 	{
		int a = objID[x];
		if(a == i)
		{
 			optionIDArray[0] = 420;
			optionObjXArray[0] = objXArray[x];
			optionObjYArray[0] = objYArray[x];
			optionObjIDArray[0] = anIntArray763[x];
 			optionObjNameArray[0] = objID[x]; //objectname
 			optionPacketSender(0);
 			macroaction();
 			break;
 		}
 	}
    }
    
    public void action123b(int i)
    {
 	optionIDArray[0] = 2400;
	optionObjXArray[0] = objXArray[i];
	optionObjYArray[0] = objYArray[i];
	optionObjIDArray[0] = anIntArray763[i];
 	optionObjNameArray[0] = objID[i]; //objectname
 	optionPacketSender(0);
 	macroaction();
    }
    
    public void action123(int i)
    {
 	optionIDArray[0] = 420;
	optionObjXArray[0] = objXArray[i];
	optionObjYArray[0] = objYArray[i];
	optionObjIDArray[0] = anIntArray763[i];
 	optionObjNameArray[0] = objID[i]; //objectname
 	optionPacketSender(0);
 	macroaction();
    }
    
    public void atobjat(int i, int j)
    {
 	optionIDArray[0] = 420;
        optionObjXArray[0] = i - myPlayerX1;
        optionObjYArray[0] = j - myPlayerY1;
        optionPacketSender(0);
 	macroaction();
    }
    
    public void actionnearest(int i)
    {
 	optionIDArray[0] = 420;
	optionObjXArray[0] = objXArray[i];
	optionObjYArray[0] = objYArray[i];
	optionObjIDArray[0] = anIntArray763[i];
 	optionObjNameArray[0] = objID[i]; //objectname
 	optionPacketSender(0);
 	macroaction();
 	System.out.println("ActionNearest(" + (objXArray[i] + myPlayerX1) + "," + (objYArray[i] + myPlayerY1) + "," + anIntArray763[i] + "," + objID[i] + ")");
    }
    
    public void action2(int i)
    {
 	for(int x = 0; x < objID.length; x++)
 	{
		int a = objID[x];
		if(a == i)
		{
 			optionIDArray[0] = 2400;
			optionObjXArray[0] = objXArray[x];
			optionObjYArray[0] = objYArray[x];
			optionObjIDArray[0] = anIntArray763[x];
 			optionObjNameArray[0] = objID[x]; //objectname
 			optionPacketSender(0);
 			macroaction();
 			System.out.println("Action(" + (objXArray[x] + myPlayerX1) + "," + (objYArray[x] + myPlayerY1) + "," + anIntArray763[x] + "," + objID[x] + ")");
 		}
 	}
    }
    
    public void actionnearest2(int i)
    {
 	optionIDArray[0] = 2400;
	optionObjXArray[0] = objXArray[i];
	optionObjYArray[0] = objYArray[i];
	optionObjIDArray[0] = anIntArray763[i];
 	optionObjNameArray[0] = objID[i]; //objectname
 	optionPacketSender(0);
 	macroaction();
 	System.out.println("ActionNear2(" + objXArray[i] + "," + objYArray[i] + "," + anIntArray763[i] + "," + objID[i] + ")");
    }
    
    public void actionincoords(int id, int x1, int y1, int x2, int y2)
    {
 	for(int x = 0; x < objID.length; x++)
 	{
		int a = objID[x];
		if(a == id && objXArray[x] >= x1 && objXArray[x] <= x2 && objYArray[x] >= y1 && objYArray[x] <= y2)
		{
 			optionIDArray[0] = 420;
			optionObjXArray[0] = objXArray[x]; // object X
			optionObjYArray[0] = objYArray[x]; // Object Y
			optionObjIDArray[0] = anIntArray763[x]; // object ID?
 			optionObjNameArray[0] = objID[x];
 			optionPacketSender(0);
 			macroaction();
 		}
 	}
    }
    
    public int nearestobjbyid(int i)
    {
        int ai[] = new int[objCount];
        int ai1[] = new int[objCount];
        int ai2[] = new int[objCount];
        int j = 0;
        boolean flag = false;
        boolean flag1 = false;
        double d = 9999999D;
        int i1 = -1;
        for(int j1 = 0; j1 < objCount; j1++)
            if(objID[j1] == i)
            {
                ai[j] = objXArray[j1] + myPlayerX1;
                ai1[j] = objYArray[j1] + myPlayerY1;
                ai2[j] = j1;
                j++;
            }

        try
        {
            for(int k1 = 0; k1 <= j; k1++)
                if(objID[ai2[k1]] == i)
                {
                    int k = Math.abs(Math.abs(myPlayerX1) - Math.abs(ai[k1]));
                    int l = Math.abs(Math.abs(myPlayerY1) - Math.abs(ai1[k1]));
                    if(k == 0 || l == 0)
                    {
                        if((double)(k + l) < d)
                        {
                            d = k + l;
                            i1 = ai2[k1];
                        }
                    } else
                    if((double)(k + l) * 0.5D < d)
                    {
                        d = (double)(k + l) * 0.5D;
                        i1 = ai2[k1];
                    }
                }

        }
        catch(Exception _ex) { }
        if(i1 > -1 && i1 < objCount)
            return i1;
        else
            return -1;
    } 
 
    public void atobject2(int i, int j)
    {
        super.packets.packetID(227);
        super.packets.variables343(i);
        super.packets.variables343(j);
        super.packets.sendpacket();
        macroaction();
    }
    
    public void prayeroff(int i)
    {
    	super.packets.packetID(164);
        super.packets.variables343(i);
        super.packets.sendpacket();
        aBooleanArray679[i] = false;
        method97("prayeroff");
    } 
    public void prayeron(int i)                
    {
        super.packets.packetID(17);
        super.packets.variables343(i);
        super.packets.sendpacket();
        aBooleanArray679[i] = true;
        method97("prayeron");
    }
    
    public int posX()
    {
    	return myPlayerX2 + myPlayerX1;
    }
    
    public int posY()
    {
    	return myPlayerY2 + myPlayerY1;
    }
    
    public void useitemid(int i)
    {
        for(int j = 0; j < inventoryItemID.length; j++)
            if(inventoryItemID[j] == i)
            {
                super.packets.packetID(219);
            	super.packets.variables343(j);
            	super.packets.sendpacket();
                return;
            }

    }
    
    public void useitem(int i)
    {
        super.packets.packetID(219);
        super.packets.variables343(i);
        super.packets.sendpacket();
    }
    
    public void thievenpc(int i)
    {
    	if(i > 0)
    	{
    		optionIDArray[0] = 725;
        	optionObjXArray[0] = NPCArray[i].posX;
        	optionObjYArray[0] = NPCArray[i].posY;
        	optionObjIDArray[0] = NPCArray[i].ID;
        	optionPacketSender(0);
        	macroaction();
        }
    }
    public void talktonpc(int i)
    {
    	int a = getnearestnpcbyid(i);
    	optionIDArray[0] = 720;
        optionObjXArray[0] = NPCArray[a].posX;
        optionObjYArray[0] = NPCArray[a].posY;
        optionObjIDArray[0] = NPCArray[a].ID;
        toolbar = 0;
        optionPacketSender(0);
        macroaction();
    }
    
    public void walkto(int i, int j)
    {
        optionObjXArray[0] = i - myPlayerX1;
        optionObjYArray[0] = j - myPlayerY1;
        optionObjIDArray[0] = 0;
        optionObjNameArray[0] = 0;
        anIntArray805[0] = 0;
        optionIDArray[0] = 920;
        optionPacketSender(0);
    }
        
    public void attacknpc(int i)
    {
    	if(i > 0)
    	{
    		optionIDArray[0] = 715;
        	optionObjXArray[0] = NPCArray[i].posX;
        	optionObjYArray[0] = NPCArray[i].posY;
        	optionObjIDArray[0] = NPCArray[i].ID;
        	optionPacketSender(0);
        }
    }
    
    public int getnearestnpcbyid(int i)
    {
        int ai[] = new int[npccount()];
        int ai1[] = new int[npccount()];
        int ai2[] = new int[npccount()];
        int j = 0;
        boolean flag = false;
        boolean flag1 = false;
        double d = 9999999D;
        int i1 = -1;
        for(int j1 = 0; j1 < npccount(); j1++)
            if(NPCArray[j1].combatlvl == i && NPCArray[j1].status != 8 && NPCArray[j1].status != 9)
            {
                ai[j] = (NPCArray[j1].posX - 64) / anInt946;
                ai1[j] = (NPCArray[j1].posY - 64) / anInt946;
                ai2[j] = j1;
                j++;
            }

        try
        {
            for(int k1 = 0; k1 <= j; k1++)
                if(NPCArray[ai2[k1]].combatlvl == i)
                {
                    int k = Math.abs(Math.abs(myPlayerX2) - Math.abs(ai[k1]));
                    int l = Math.abs(Math.abs(myPlayerY2) - Math.abs(ai1[k1]));
                    if(k == 0 || l == 0)
                    {
                        if((double)(k + l) < d)
                        {
                            d = k + l;
                            i1 = ai2[k1];
                        }
                    } else
                    if((double)(k + l) * 0.5D < d)
                    {
                        d = (double)(k + l) * 0.5D;
                        i1 = ai2[k1];
                    }
                }

        }
        catch(Exception _ex) { }
        if(i1 > -1 && i1 < npccount())
            return i1;
        else
            return -1;
    } 
    
    public boolean isnpcattackable(int i)
    {
        return Class1.anIntArray116[i] > 0;
    }
    
    public int npccount()
    {
        return npccount;
    }
    
    public boolean incombat()
    {
	return myPlayer.status == 8 || myPlayer.status == 9;
    }
    
    public int fatigue()
    {
    	return ((fatigue * 100) / 750);
    }
    
    public void setmode(int i)
    {
    	mouseClick = 0;
    	fightMode = i;
        super.packets.packetID(119);
        super.packets.variables348(fightMode);
        super.packets.sendpacket();
    }
    
    public void Wait(int i)
    {
        try
        {
            Thread.sleep(i);
            return;
        }
        catch(InterruptedException _ex)
        {
            return;
        }
    }
    
    public mudclient()
    {
        super();
        int i = Class1.anInt144;
        BTNtype = 1;
        WBoTint1 = 512;
        WBoTint2 = 384;
        ShowCombat = true;
        aBooleanArray662 = new boolean[1500];
        anIntArray664 = new int[8];
        anIntArray665 = new int[8];
        aBoolean666 = false;
        aBoolean668 = false;
        duelWindow2 = false;
        tradeWindow = false;
        tradeFinished = false;
        aBoolean675 = false;
        FogOfWar = true;
        anInt676 = 512;
        anInt677 = 334;
        anInt678 = 9;
        aBooleanArray679 = new boolean[50];
        aBoolean680 = false;
        aString681 = "";
        aString682 = "";
        CameraZoom = 550;
        anIntArray686 = new int[99];
        anIntArray687 = new int[50];
        anIntArray688 = new int[50];
        anIntArray689 = new int[50];
        anIntArray692 = new int[20];
        anIntArray693 = new int[20];
        anInt707 = 30;
        inventoryItemID = new int[35];
        anIntArray710 = new int[35];
        anIntArray711 = new int[35];
        CurrentXPArray = new int[18];
        aBooleanArray716 = new boolean[50];
        aBoolean717 = false;
        aBoolean718 = false;
        aBoolean719 = false;
        aBoolean720 = false;
        aBoolean721 = false;
        anIntArray722 = new int[50];
        anIntArray723 = new int[50];
        aBoolean727 = false;
        CurrentStatLevelArray = new int[18];
        mapangle = 128;
        anIntArray730 = new int[50];
        username = "";
        password = "";
        shopItemID = new int[256];
        shopItemCount = new int[256];
        anIntArray738 = new int[256];
        anIntArray740 = new int[500];
        anIntArray741 = new int[500];
        aBoolean745 = false;
        anIntArray747 = new int[500];
        anIntArray748 = new int[500];
        aBoolean757 = false;
        anIntArray758 = new int[50];
        anIntArray759 = new int[50];
        objXArray = new int[1500];
        objYArray = new int[1500];
        objID = new int[1500];
        anIntArray763 = new int[1500];
        selectedItem = -1;
        selectedItemName = "";
        aBoolean767 = false;
        NPCArray = new Class2[500];
        optionObjectArray = new String[250];
        itemXArray = new int[5000];
        itemYArray = new int[5000];
        itemIDArray = new int[5000];
        anIntArray773 = new int[5000];
        aStringArray774 = new String[5];
        aClass5Array781 = new Class5[500];
        anInt785 = -1;
        anIntArray787 = new int[8];
        anIntArray788 = new int[8];
        aBoolean789 = false;
        aString794 = "";
        anIntArray797 = new int[5];
        duelWindow = false;
        duelFinished = false;
        optionObjIDArray = new int[250];
        optionObjNameArray = new int[250];
        anIntArray805 = new int[250];
        anInt809 = -1;
        aBoolean810 = false;
        selectedSpell = -1;
        aClass5Array814 = new Class5[1500];
        anIntArray815 = new int[500];
        anIntArray816 = new int[256];
        anIntArray817 = new int[256];
        aStringArray821 = new String[50];
        aClass2Array822 = new Class2[500];
        aString824 = "";
        RealStatLevelArray = new int[18];
        aBooleanArray831 = new boolean[500];
        bankSlots = -1;
        anInt835 = -2;
        anIntArray837 = new int[20];
        anIntArray838 = new int[20];
        aString848 = "";
        aBoolean849 = false;
        answerMenu = false;
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
        optionIDArray = new int[250];
        anIntArray887 = new int[20];
        anIntArray888 = new int[20];
        aBoolean890 = false;
        aClass2Array891 = new Class2[4000];
        anInt896 = 2;
        anInt897 = 40;
        selectedShopItem = -1;
        anInt904 = -2;
        aBoolean908 = false;
        anIntArray911 = new int[8];
        anIntArray912 = new int[8];
        aStringArray913 = new String[5];
        members = true;
        anInt916 = 48;
        aBoolean917 = false;
        anInt919 = -1;
        anInt920 = -1;
        anInt921 = -1;
        aBoolean922 = false;
        aClass2Array923 = new Class2[500];
        anIntArray934 = new int[50];
        anIntArray935 = new int[5];
        optionObjXArray = new int[250];
        optionObjYArray = new int[250];
        anInt940 = 1;
        hasAccepted = false;
        tradeWindow2 = false;
        anInt946 = 128;
        bankItemID = new int[256];
        bankItemCount = new int[256];
        aClass2Array957 = new Class2[5000];
        anIntArray960 = new int[8];
        anIntArray961 = new int[8];
        anIntArray962 = new int[8000];
        anIntArray963 = new int[8000];
        anIntArray965 = new int[50];
        anIntArray966 = new int[50];
        anIntArray967 = new int[50];
        anIntArray968 = new int[50];
        tradeItemID = new int[20];
        tradeItemCount = new int[20];
        anIntArray972 = new int[50];
        anInt974 = 2;
        myPlayer = new Class2();
        anInt978 = -1;
        aBoolean979 = true;
        anIntArray981 = new int[8192];
        anIntArray982 = new int[8192];
        PlayerArray = new Class2[500];
        anIntArray984 = new int[250];
        optionNameArray = new String[250];
        aBoolean992 = false;
        aClass5Array994 = new Class5[1000];
        anInt995 = 0xbc614e;
        System.out.println("$--------------------------------$");
        System.out.println("|WasteDBoT 1.0 - Phate & Lormsby |");
        System.out.println("$--------------------------------$");
        lefty = true;
        Applet_Sub1.mainwbot();
    }

    public Image createImage(int i, int j)
    {
        if(Applet_Sub1.aFrame_Sub1_7 != null)
            return Applet_Sub1.aFrame_Sub1_7.createImage(i, j);
        if(Class8.anApplet370 != null)
            return Class8.anApplet370.createImage(i, j);
        else
            return super.createImage(i, j);
    }

    public URL getCodeBase()
    {
        if(Class8.anApplet370 != null)
            return Class8.anApplet370.getCodeBase();
        else
            return super.getCodeBase();
    }

    public URL getDocumentBase()
    {
        if(Class8.anApplet370 != null)
            return Class8.anApplet370.getDocumentBase();
        else
            return super.getDocumentBase();
    }

    public Graphics getGraphics()
    {
        if(Applet_Sub1.aFrame_Sub1_7 != null)
            return Applet_Sub1.aFrame_Sub1_7.getGraphics();
        if(Class8.anApplet370 != null)
            return Class8.anApplet370.getGraphics();
        else
            return super.getGraphics();
    }

    public String getParameter(String s)
    {
        if(Class8.anApplet370 != null)
            return Class8.anApplet370.getParameter(s);
        else
            return super.getParameter(s);
    }

    public void appletvars()
    {
        if(aBoolean979)
        {
            String s = getDocumentBase().getHost().toLowerCase();
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
            anInt731 = Integer.parseInt(s1);
        }
        catch(Exception _ex) { }
        try
        {
            String s2 = getParameter("member");
            int j1 = Integer.parseInt(s2);
            if(j1 == 1)
                members = true;
        }
        catch(Exception _ex) { }
        if(aBoolean979)
            super.ServerPort = 43594;
        super.anInt11 = 0;
        Applet_Sub1_Sub1.anInt615 = 1000;
        Applet_Sub1_Sub1.anInt614 = Class18.anInt573;
        try
        {
            String s3 = getParameter("poff");
            int k1 = Integer.parseInt(s3);
            super.ServerPort += k1;
            System.out.println("Offset: " + k1);
        }
        catch(Exception _ex) { }
        ConfigPile();
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
        BigLoad();
        if(aBoolean922)
            return;
        UnpackFiles();
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
        LoadStuff();
        if(aBoolean922)
            return;
        AnimModels();
        if(aBoolean922)
            return;
        DownloadJunk();
        if(aBoolean922)
            return;
        if(members)
            LoadSounds();
        if(aBoolean922)
        {
            return;
        } else
        {
            method15(100, "Starting game...");
            method94();
            MenuOptions();
            CharDesign();
            MisUser();
            method5();
            method77();
            return;
        }
    }

 public static void parseData(String data)
 { 
   PacketStore = data;
   PacketStore = data;
   PacketStore = data;
   PacketStored = true;
   PacketStored = true;
   PacketStored = true;
 }
    
  public void parseData2(String data)
 { 
    if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("GETS"))
    {
          int a = pos(' ', data);
          int b = pos(',', data);
      	  int x = Integer.parseInt(data.substring(a,b - 1));
   	  String name = StatNameArray[x];
   	  int cstat = CurrentStatLevelArray[x];
   	  int rstat = RealStatLevelArray[x];
   	   if(data.substring(b, data.length()).equalsIgnoreCase("C"))
   	  {
   	    XClient.sendPacket("CSTAT " + name + " " + cstat);
   	  } else
   	  {
   	  	XClient.sendPacket("TSTAT " + name + " " + rstat);
   	  }
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("attacknpcbyname"))
    {
    	int a = pos(' ', data);
    	String b = data.substring(a,data.length());
    	int c = nearestnpcbyname(b);
    	if(c != -1)
    		attacknpc(c);
    	System.out.println("AttackName(" + b + ")");
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("selectshopitem"))
    {
    	int a = pos(' ', data);
    	int b = Integer.parseInt(data.substring(a,data.length()));
    	selectShopItem(b);
    	System.out.println("SelectShopItem(" + b + ")");
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("buyitem"))
    {
    	int a = pos(' ', data);
    	int b = Integer.parseInt(data.substring(a,data.length()));
    	buyitem(b);
    	System.out.println("BuyItem(" + b + ")");
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("buyitemid"))
    {
    	int a = pos(' ', data);
    	int b = Integer.parseInt(data.substring(a,data.length()));
    	buyitemid(b);
    	System.out.println("BuyItemID(" + b + ")");
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("sellitem"))
    {
    	int a = pos(' ', data);
    	int b = Integer.parseInt(data.substring(a,data.length()));
    	sellitem(b);
    	System.out.println("SellItem(" + b + ")");
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("sellitemid"))
    {
    	int a = pos(' ', data);
    	int b = Integer.parseInt(data.substring(a,data.length()));
    	sellitemid(b);
    	System.out.println("SellItemID(" + b + ")");
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("showshop"))
    {
        aBoolean727 = true;
        System.out.println("ShowShop()");
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("depositeverything"))
    {
	depositeverything();
        System.out.println("DepositEverything()");
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("closeshop"))
    {
        aBoolean727 = false;
        System.out.println("CloseShop()");
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("sleepthresh"))
    {
    	int a = pos(' ', data);
    	int b = Integer.parseInt(data.substring(a,data.length()));
    	if(b < 0 || b > 100)
    		sleepthresh = 101;
    	else
    		sleepthresh = b;
    	chatText2("@BOT@Sleepthresh set to - " + sleepthresh + ".");
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("takenearestitem"))
    {
    	int a = pos(' ', data);
    	int b = Integer.parseInt(data.substring(a,data.length()));
    	int c = findnearestitem(b);
    	if(c > -1)
    	{
    		take123(c);
    	}
    		System.out.println("TakeNearestItem(" + b + ")");
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("actionnearestobjid"))
    {
    	int a = pos(' ', data);
    	int b = Integer.parseInt(data.substring(a,data.length()));
    	int c = findnearestobj(b);
    	if(c > -1)
    	{
    		action123(c);
    		System.out.println("ActionNearestObj(" + c + ")");
    	}
    		System.out.println("ActionNearestObj(" + b + ")");
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("actionnearestobjid2"))
    {
    	int a = pos(' ', data);
    	int b = Integer.parseInt(data.substring(a,data.length()));
    	int c = findnearestobj(b);
    	if(c > -1)
    	{
    		action123b(c);
    	}
    		System.out.println("ActionNearestObj2(" + b + ")");
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("BANKCOUNTID"))
    {
    	int a = pos(' ', data);
    	int b = Integer.parseInt(data.substring(a,data.length()));
    	int c = bankCountID(b);
    	if(c < 1)
    		XClient.sendPacket("BANKCOUNTID 0");
    	else
    		XClient.sendPacket("BANKCOUNTID " + c);
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("BANKCOUNT"))
    {
    	int a = pos(' ', data);
    	int b = Integer.parseInt(data.substring(a,data.length()));
    	int c = bankCount(b);
    	if(c < 1)
    		XClient.sendPacket("BANKCOUNT 0");
    	else
    		XClient.sendPacket("BANKCOUNT " + c);
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("setfmode"))
    {
    	int b = Integer.parseInt(data.substring(pos(' ', data), data.length()));
    	if(b != -1)
    	{
    		setmode(b);
    		System.out.println("SetFightMode(" + b + ")");
    	}
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("INVCOUNT"))
    {
    	int a = pos(' ', data);
    	int b = Integer.parseInt(data.substring(a,data.length()));
    	int c = inventoryPositionCount(b);
    	if(c < 1)
    		XClient.sendPacket("INVCOUNT 0");
    	else
    		XClient.sendPacket("INVCOUNT " + c);
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("INVCOUNTID"))
    {
    	int a = pos(' ', data);
    	int b = Integer.parseInt(data.substring(a,data.length()));
    	int c = inventoryCount(b);
    	if(c < 1)
    		XClient.sendPacket("INVCOUNTID 0");
    	else
    		XClient.sendPacket("INVCOUNTID " + c);
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("isobjNear"))
    {
    	int a = pos(' ', data);
    	int b = Integer.parseInt(data.substring(a,data.length()));
    	int c = findnearestobj(b);
    	if(c == -1)
    		XClient.sendPacket("ISOBJNEAR 0");
    	else
    		XClient.sendPacket("ISOBJNEAR 1");
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("isNPCNear"))
    {
    	int a = pos(' ', data);
    	int b = Integer.parseInt(data.substring(a,data.length()));
    	int c = getnearestnpcbyid(b);
    	if(c == -1)
    		XClient.sendPacket("ISNPCNEAR 0");
    	else
    		XClient.sendPacket("ISNPCNEAR 1");
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("incombat"))
    {
    	if(incombat())
    		XClient.sendPacket("INCOMBAT 1");
    	else
    		XClient.sendPacket("INCOMBAT 0");
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("getfmode"))
    {
    	XClient.sendPacket("FMODE " + fightMode);
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("declineduel"))
    {
    	System.out.println("DeclineDuel()");
    	declineduel();
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("acceptduel2"))
    {
    	System.out.println("AcceptDuel2()");
    	acceptduel2();
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("acceptduel1"))
    {
    	System.out.println("AcceptDuel1()");
    	acceptduel1();
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("declinetrade"))
    {
    	System.out.println("DeclineTrade()");
    	declinetrade();
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("accepttrade2"))
    {
    	System.out.println("AcceptTrade2()");
    	accepttrade2();
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("accepttrade1"))
    {
    	System.out.println("AcceptTrade1()");
    	accepttrade1();
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("slword"))
    {
    	System.out.println("Sleep Word " + data.substring(pos(' ', data),data.length()) + " Successfully Read");
    	super.aString40 = data.substring(pos(' ', data),data.length());
    	super.aString41 = data.substring(pos(' ', data),data.length());
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("DEBUGRS"))
    {
    	String msg = data.substring(pos(' ', data), data.length());
    	chatText2(msg);
    	System.out.println("DebugRS(" + msg + ")");
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("CHAT"))
    {
    	String msg = data.substring(pos(' ', data), data.length());
    	chat(msg);
    	System.out.println("Chat(" + msg + ")");
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("talkname"))
    {
    	String name1 = data.substring(pos(' ', data), data.length());
    	npcbyname(name1);
    	System.out.println("TalkToNPCByName(" + name1 + ")");
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("poptrade"))
    {
    int a = pos(' ', data);
    int b = pos(',', data);
    int x = Integer.parseInt(data.substring(a,b-1));
    int y = Integer.parseInt(data.substring(b,data.length()));
    if(x != -1 && y != -1)
    {
    	poptrade(x,y);
    	System.out.println("PopTrade(" + x + "," + y + ")");
    }
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("puttrade"))
    {
    int a = pos(' ', data);
    int b = pos(',', data);
    int x = Integer.parseInt(data.substring(a,b-1));
    int y = Integer.parseInt(data.substring(b,data.length()));
    if(x != -1 && y != -1)
    {
    	puttrade(x,y);
    	System.out.println("PutTrade(" + x + "," + y + ")");
    }
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("deposit"))
    {
    int a = pos(' ', data);
    int b = pos(',', data);
    int x = Integer.parseInt(data.substring(a,b-1));
    int y = Integer.parseInt(data.substring(b,data.length()));
    if(x != -1 && y != -1)
    {
    	deposit(x,y);
    	System.out.println("Deposit(" + x + "," + y + ")");
    }
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("withdraw"))
    {
    int a = pos(' ', data);
    int b = pos(',', data);
    int x = Integer.parseInt(data.substring(a,b-1));
    int y = Integer.parseInt(data.substring(b,data.length()));
    if(x != -1 && y != -1)
    {
    	withdraw(x,y);
    	System.out.println("Withdraw(" + x + "," + y + ")");
    }
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("attname"))
    {
    	String name1 = data.substring(pos(' ', data), data.length());
    	int a = playerfromname(name1);
    	if(a != -1)
    	{
    		attackplayer(a);
    		System.out.println("AttackPlayer(" + name1 + ")");
    	}
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("mage"))
    {
    	int b = pos(' ', data);
    	int c = pos(',', data);
    	int d = Integer.parseInt(data.substring(pos(' ', data),pos(',', data) - 1));
    	int e = Integer.parseInt(data.substring(pos(',', data), data.length()));
    	if(e != -1 && d != -1)
    	{
    		mageplayerid(d,e);
    		System.out.println("MagePlayer(" + d + "," + e + ")");
    	}
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("magename"))
    {
    	int b = pos(' ', data);
    	int c = pos(',', data);
    	int d = Integer.parseInt(data.substring(pos(' ', data),pos(',', data) - 1));
    	String name1 = data.substring(pos(',', data), data.length());
    	int a = playerfromname(name1);
    	if(a != -1)
    	{
    		mageplayerid(d,a);
    		System.out.println("MagePlayer(" + d + "," + name1 + ")");
    	}
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("followname"))
    {
    	String name1 = data.substring(pos(' ', data), data.length());
    	int a = playerfromname(name1);
    	if(a != -1)
    	{
    		followplayer(a);
    		System.out.println("FollowPlayer(" + name1 + ")");
    	}
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("duelname"))
    {
    	String name1 = data.substring(pos(' ', data), data.length());
    	int a = playerfromname(name1);
    	if(a != -1)
    	{
    		duelplayer(a);
    		System.out.println("DuelPlayer(" + name1 + ")");
    	}
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("tradename"))
    {
    	String name1 = data.substring(pos(' ', data), data.length());
    	int a = playerfromname(name1);
    	if(a != -1)
    	{
    		tradeplayer(a);
    		System.out.println("TradePlayer(" + name1 + ")");
    	}
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("removeID"))
    {
    	int b = Integer.parseInt(data.substring(pos(' ', data), data.length()));
    	if(b != -1)
    	{
    		removebyid(b);
    		System.out.println("removeID(" + b + ")");
    	}
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("remove"))
    {
    	int b = Integer.parseInt(data.substring(pos(' ', data), data.length()));
    	if(b != -1)
    	{
    		remove(b);
    		System.out.println("Remove(" + b + ")");
    	}
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("WieldID"))
    {
    	int b = Integer.parseInt(data.substring(pos(' ', data), data.length()));
    	if(b != -1)
    	{
    		wieldbyid(b);
    		System.out.println("WieldID(" + b + ")");
    	}
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("Wield"))
    {
    	int b = Integer.parseInt(data.substring(pos(' ', data), data.length()));
    	if(b != -1)
    	{
    		wield(b);
    		System.out.println("Drop(" + b + ")");
    	}
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("dropid"))
    {
    	int b = Integer.parseInt(data.substring(pos(' ', data), data.length()));
    	if(b != -1)
    	{
    		dropitembyid(b);
    		System.out.println("DropID(" + b + ")");
    	}
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("drop"))
    {
    	int b = Integer.parseInt(data.substring(pos(' ', data), data.length()));
    	if(b != -1)
    	{
    		dropitem(b);
    		System.out.println("Drop(" + b + ")");
    	}
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("takename"))
    {
    	String b = data.substring(pos(' ', data), data.length());
    	takebyname(b);
    	System.out.println("TakeName(" + b + ")");
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("take"))
    {
    	int b = Integer.parseInt(data.substring(pos(' ', data), data.length()));
    	if(b != -1)
    	{
    		takebyid(b);
    		System.out.println("Take(" + b + ")");
    	}
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("actnear"))
    {
    	int b = Integer.parseInt(data.substring(pos(' ', data), data.length()));
    	if(b != -1)
    	{
    		int c = nearestobjbyid(b);
    		if(c != -1)
    		{
    			actionnearest(c);
    			System.out.println("ActionNearest(" + b + ")");
    		}
    	}
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("act"))
    {
    	int b = Integer.parseInt(data.substring(pos(' ', data), data.length()));
    	if(b != -1)
    	{
    		action(b);
    		System.out.println("Action(" + b + ")");
    	}
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("actnear2"))
    {
    	int b = Integer.parseInt(data.substring(pos(' ', data), data.length()));
    	if(b != -1)
    	{
    		int c = nearestobjbyid(b);
    		actionnearest2(c);
    		System.out.println("ActionNearest2(" + b + ")");
    	}
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("act2"))
    {
    	int b = Integer.parseInt(data.substring(pos(' ', data), data.length()));
    	if(b != -1)
    	{
    		action2(b);
    		System.out.println("Action2(" + b + ")");
    	}
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("takeat"))
    {
    int a = pos(' ', data);
    int b = pos(',', data);
    int c = data.lastIndexOf(',');
    int x = Integer.parseInt(data.substring(a,b-1));
    int y = Integer.parseInt(data.substring(b,c-1));
    int z = Integer.parseInt(data.substring(c + 1,data.length()));
    if(x != -1 && y != -1 && z != -1)
    {
    	takeat(x,y,z);
    	System.out.println("TakeItemAt(" + x + "," + y + ")");
    }
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("atobjat"))
    {
    int a = pos(' ', data);
    int b = pos(',', data);
    int x = Integer.parseInt(data.substring(a,b-1));
    int y = Integer.parseInt(data.substring(b,data.length()));
    if(x != -1 && y != -1)
    {
    	atobjat(x,y);
    	System.out.println("AtObjectAt(" + x + "," + y + ")");
    }
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("atobjwith"))
    {
    int a = pos(' ', data);
    int b = pos(',', data);
    int x = Integer.parseInt(data.substring(a,b-1));
    int y = Integer.parseInt(data.substring(b,data.length()));
    if(x != -1 && y != -1)
    {
    	atobjectwith(x,y);
    	System.out.println("atObjectWith(" + x + "," + y + ")");
    }
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("mine"))
    {
    int a = pos(' ', data);
    int b = pos(',', data);
    int x = Integer.parseInt(data.substring(a,b-1));
    int y = Integer.parseInt(data.substring(b,data.length()));
    if(x != -1 && y != -1)
    {
    	atobjat(x,y);
    	System.out.println("Mine(" + x + "," + y + ")");
    }
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("GETXP"))
    {
    int a = pos(' ', data);
    int b = pos(',', data);
   	int x = Integer.parseInt(data.substring(a,b - 1));
   	int k2 = anIntArray686[0];
        for(int i3 = 0; i3 < 98; i3++)
           if(CurrentXPArray[x] >= anIntArray686[i3])
                 k2 = anIntArray686[i3 + 1];
   	String name = StatNameArray[x];
   	int cxp = (CurrentXPArray[x] / 4);
   	int rxp = (k2 / 4);
   	 if(data.substring(b, data.length()).equalsIgnoreCase("C"))
   	  {
   	  XClient.sendPacket("CXP " + cxp);
   	  System.out.println("Current " + name + " XP " + cxp);
   	  } else
   	  {
   	  XClient.sendPacket("TXP " + rxp);
   	  System.out.println("XP for " + name + " lvl " + rxp);
   	  }
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("BOTC"))
    {
    	chatText2("@bot@" + data.substring(5,data.length()));
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("FIX"))
    {
    	mapangle = 128;
    	CameraZoom = 700;
    	xrotate = 912;
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("LOGOUT"))
    {
    	method22();
    	loggedout = true;
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("SETSERV"))
    {
    	int a = Integer.parseInt(data.substring(pos(' ', data), data.length()));
    	if(a == 51 || a == 52 || a == 53 || a == 54 || a == 55 || a ==56)
		changeworld(a);
	else
		System.out.println("Invalid Server (51 - 56 only retard)");
    } else if(data.substring(0,(data.indexOf(' '))).equalsIgnoreCase("LOGIN"))
    {
    	int a = data.indexOf(' ');
        int b = pos(',', data);
        if(a != 0 && b != 0)
        {
               username = data.substring(a + 1, b - 1);
               password = (copy(b + 1, data.length(), data));
               login();
        }
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("randomwalk"))
    {
    	int a = pos(' ', data);
        int b = data.indexOf(',');
        String c1 = data.substring(b+1,data.length());
        int c = c1.indexOf(',') + b + 1;
        int d = data.lastIndexOf(',');
        if(a != -1 && b != -1 && c != -1 && d != -1)
        {
               int x = Integer.parseInt(data.substring(a,b));
               int y = Integer.parseInt(data.substring(b+1,c));
               int x2 = Integer.parseInt(data.substring(c+1,d));
               int y2 = Integer.parseInt(data.substring(d+1,data.length()));
               int xran = getrandom(x,x2);
     	       int yran = getrandom(y,y2);
     	       System.out.println("WalkToRandomly(" + xran + "," + yran + ")");
               walkto(xran,yran);
        }
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("USEITEMIDID"))
    {
    	int a = pos(' ', data);
        int b = pos(',', data);
        int c = pos(',', data);
        if(a != 0 && b != 0 && c != 0)
        {
               int x = Integer.parseInt(copy(a + 1, b - 1, data));
               int y = Integer.parseInt(copy(c + 1, data.length(), data));
               useitemwithitem(x,y);
        }
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("USEITEMPOSPOS"))
    {
    	int a = pos(' ', data);
        int b = pos(',', data);
        int c = pos(',', data);
        if(a != 0 && b != 0 && c != 0)
        {
               int x = Integer.parseInt(copy(a + 1, b - 1, data));
               int y = Integer.parseInt(copy(c + 1, data.length(), data));
               useitemposwithitempos(x,y);
        }
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("WALK"))
    {
    	int a = pos(' ', data);
        int b = pos(',', data);
        int c = pos(',', data);
        if(a != 0 && b != 0 && c != 0)
        {
               int x = Integer.parseInt(copy(a + 1, b - 1, data));
               int y = Integer.parseInt(copy(c + 1, data.length(), data));
               walkto(x,y);
        }
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("USEITEMID"))
    {
    	int a = pos(' ', data);
        if(a != 0)
        {
               int p = Integer.parseInt(copy(a + 1, data.length(), data));
               useitemid(p);
        }
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("PRAYON"))
    {
    	int a = pos(' ', data);
        if(a != 0)
        {
               int p = Integer.parseInt(copy(a + 1, data.length(), data));
               prayeron(p);
        }
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("PRAYOFF"))
    {
    	int a = pos(' ', data);
        if(a != 0)
        {
               int p = Integer.parseInt(copy(a + 1, data.length(), data));
               prayeroff(p);
        }
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("ATT"))
    {
    	int a = pos(' ', data);
        if(a != 0)
        {
               int x = Integer.parseInt(copy(a + 1, data.length(), data));
               int n = getnearestnpcbyid(x);
               attacknpc(n);
        }
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("atob"))
    {
    	int a = pos(' ', data);
        if(a != 0)
        {
               int id = Integer.parseInt(copy(a + 1, data.length(), data));
               if(id != -1)
               {
               	action(id);
               	}
        }
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("thieve"))
    {
    	int a = pos(' ', data);
        if(a != 0)
        {
               int n = Integer.parseInt(copy(a + 1, data.length(), data));
               int x = getnearestnpcbyid(n);
               if(x != -1)
               {
               	thievenpc(x);
               }
        }
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("showbank"))
    {
    	aBoolean879 = true;
    	System.out.println("ShowBank()");
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("closebank"))
    {
    	aBoolean879 = false;
    	System.out.println("CloseBank()");
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("talk"))
    {
    	int a = pos(' ', data);
        if(a != 0)
        {
               int n = Integer.parseInt(copy(a + 1, data.length(), data));
               if(n != -1)
               {
               	talktonpc(n);
               } else {
               }
        }
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("ans"))
    {
    	int a = pos(' ', data);
        if(a != 0)
        {
               int x = Integer.parseInt(copy(a + 1, data.length(), data));
               	answer(x);
        }
    } else if(data.substring(0,pos(' ', data) - 2).equalsIgnoreCase("CTXT"))	  
    {
    	int a = pos(' ', data);
        if(a != 0)
        {
         int b = pos(',', data);
         int c = pos(':', data);
         if(b != 0 && c != 0);
         {
         int x = Integer.parseInt(data.substring(a, b - 1));	
         int y = Integer.parseInt(data.substring(b, c - 1));
         String z = data.substring(c, data.length());
         int w = Integer.parseInt(data.substring(4, a - 1));
    	if(w == 1)
    	 {
    	 	WText1 = true;
    	 	WText1X = x;
    	 	WText1Y = y;
    	 	WText1Text = z;
    	 }
    	if(w == 2)
    	 {
    	 	WText2 = true;
    	 	WText2X = x;
    	 	WText2Y = y;
    	 	WText2Text = z;
    	 }
    	if(w == 3)
    	 {
    	 	WText3 = true;
    	 	WText3X = x;
    	 	WText3Y = y;
    	 	WText3Text = z;
    	 }
    	if(w == 4)
    	 {
    	 	WText4 = true;
    	 	WText4X = x;
    	 	WText4Y = y;
    	 	WText4Text = z;
    	 }
    	if(w == 5)
    	 {
    	 	WText5 = true;
    	 	WText5X = x;
    	 	WText5Y = y;
    	 	WText5Text = z;
    	 }
    	if(w == 6)
    	 {
    	 	WText6 = true;
    	 	WText6X = x;
    	 	WText6Y = y;
    	 	WText6Text = z;
    	 }
    	if(w == 7)
    	 {
    	 	WText7 = true;
    	 	WText7X = x;
    	 	WText7Y = y;
    	 	WText7Text = z;
    	 }
    	if(w == 8)
    	 {
    	 	WText8 = true;
    	 	WText8X = x;
    	 	WText8Y = y;
    	 	WText8Text = z;
    	 }
    	if(w == 9)
    	 {
    	 	WText9 = true;
    	 	WText9X = x;
    	 	WText9Y = y;
    	 	WText9Text = z;
    	 }
    	 }
      }
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("DTXT"))
    {
    	int a = pos(' ', data);
    	if (a != 0) {
    	if(data.substring(a,data.length()).equalsIgnoreCase("1"))
    	{
    		WText1 = false;
    	}
    	if(data.substring(a,data.length()).equalsIgnoreCase("2"))
    	{
    		WText2 = false;
    	}
    	if(data.substring(a,data.length()).equalsIgnoreCase("3"))
    	{
    		WText3 = false;
    	}
    	if(data.substring(a,data.length()).equalsIgnoreCase("4"))
    	{
    		WText4 = false;
    	}
    	if(data.substring(a,data.length()).equalsIgnoreCase("5"))
    	{
    		WText5 = false;
    	}
    	if(data.substring(a,data.length()).equalsIgnoreCase("6"))
    	{
    		WText6 = false;
    	}
    	if(data.substring(a,data.length()).equalsIgnoreCase("7"))
    	{
    		WText7 = false;
    	}
    	if(data.substring(a,data.length()).equalsIgnoreCase("8"))
    	{
    		WText8 = false;
    	}
    	if(data.substring(a,data.length()).equalsIgnoreCase("9"))
    	{
    		WText9 = false;
    	}
    	}
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("GETNPC"))
    {
    GETNPC = true;
    } else if(data.substring(0,pos(' ', data) - 1).equalsIgnoreCase("SCRIPT"))
    {
      if(data.substring(6,9).equalsIgnoreCase("RUN"))
      {
      	chatText2("@bot@Script Running");
      } else
      {
      	chatText2("@bot@Script Stopped");
      	WText1 = false;
      	WText2 = false;
      	WText3 = false;
      	WText4 = false;
      	WText5 = false;
      	WText6 = false;
      	WText7 = false;
      	WText8 = false;
      	WText9 = false;
      	GETNPC = false;
      }
    } else
    {
 	System.out.println("[><] Unrecognized [" + data + "]");
    }
  } 
  
  public synchronized boolean keyUp(Event event, int i)
    {
    	{
    		if(i == 1001)
    			homedown = false;
    		if(i == 1000)
    			enddown = false;
    		if(i == 1)
    			adown = false;
    		if(i == 4)
    			ddown = false;
    		if(i == 19)
    			sdown = false;
    		if(i == 23)
    			wdown = false;
       		if (i == PGUP)
			pgdowndown = false;
		if (i == PGDN)
			pgupdown = false;
		if (i == ARROWUP)
			arrowkeyup = false;
		if (i == ARROWDOWN)
			arrowkeydown = false;
    	}
    	return super.keyUp(event,i);
    }
    
    public synchronized boolean keyDown(Event event, int i)
    {
    	{
    		if(i == 1022)
    			if(super.caps)
    			{
    				super.caps = false;
    				chatText2("Caps Off");
    			} else {
    				super.caps = true;
    				chatText2("Caps On");
    			}
    		if(i == 1001)
    			homedown = true;
    		if(i == 1000)
    			enddown = true;
    		if(i == 1)
    			adown = true;
    		if(i == 4)
    			ddown = true;
    		if(i == 19)
    			sdown = true;
    		if(i == 23) // CTRL+W
    			wdown = true;
    		if(i == 033) // ESC
    			method22();
    		if (i == PGUP)
			pgdowndown = true;
    		if (i == PGDN)
    			pgupdown = true;
    		if (i == ARROWUP)
    			arrowkeyup = true;
    		if (i == ARROWDOWN)
    			arrowkeydown = true;
    	}
    	return super.keyDown(event,i);
    }
    public void keypress(int i)
    {
        if(i == 1017)
    		if(macroOn)
    		{
    			macroOn = false;
    			lockedFightMode = -1;
    			chatText2("@bot@Autofighter Off");
    		} else {
    			if(selectedNPC != -1)
    			{
    				if(fightMode == 0)
    					startXP = CurrentXPArray[0] + CurrentXPArray[1] + CurrentXPArray[2];
    				if(fightMode == 1)
    					startXP = CurrentXPArray[2];
    				if(fightMode == 2)
    					startXP = CurrentXPArray[0];
    				if(fightMode == 3)
    					startXP = CurrentXPArray[1];
    				lockedFightMode = fightMode;
    				macroOn = true;
    				chatText2("@bot@Autofighter On");
    				fightthread = new autofight();
    			} else {
    				chatText2("@bot@No NPC selected, right click and choose an npc.");
    			}
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

    public void duel()
    {
        int l = Class1.anInt144;
        byte byte0 = 22;
        byte byte1 = 36;
        aClass6_Sub1_724.method216(byte0, byte1, 468, 16, 192);
        int i = 0x989898;
        aClass6_Sub1_724.method214(byte0, byte1 + 16, 468, 246, i, 160);
        aClass6_Sub1_724.FloatText("Please confirm your duel with @yel@" + Class15.method363(aLong907), byte0 + 234, byte1 + 12, 1, 0xffffff);
        aClass6_Sub1_724.FloatText("Your stake:", byte0 + 117, byte1 + 30, 1, 0xffff00);
        for(int j = 0; j < anInt663; j++)
        {
            String s = Class1.itemNameArray[anIntArray664[j]];
            if(Class1.anIntArray55[anIntArray664[j]] == 0)
                s = s + " x " + Currency(anIntArray665[j]);
            aClass6_Sub1_724.FloatText(s, byte0 + 117, byte1 + 42 + j * 12, 1, 0xffffff);
        }

        if(anInt663 == 0)
            aClass6_Sub1_724.FloatText("Nothing!", byte0 + 117, byte1 + 42, 1, 0xffffff);
        aClass6_Sub1_724.FloatText("Your opponent's stake:", byte0 + 351, byte1 + 30, 1, 0xffff00);
        for(int k = 0; k < anInt786; k++)
        {
            String s1 = Class1.itemNameArray[anIntArray787[k]];
            if(Class1.anIntArray55[anIntArray787[k]] == 0)
                s1 = s1 + " x " + Currency(anIntArray788[k]);
            aClass6_Sub1_724.FloatText(s1, byte0 + 351, byte1 + 42 + k * 12, 1, 0xffffff);
        }

        if(anInt786 == 0)
            aClass6_Sub1_724.FloatText("Nothing!", byte0 + 351, byte1 + 42, 1, 0xffffff);
        if(anInt988 == 0)
            aClass6_Sub1_724.FloatText("You can retreat from this duel", byte0 + 234, byte1 + 180, 1, 65280);
        else
            aClass6_Sub1_724.FloatText("No retreat is possible!", byte0 + 234, byte1 + 180, 1, 0xff0000);
        if(anInt989 == 0)
            aClass6_Sub1_724.FloatText("Magic may be used", byte0 + 234, byte1 + 192, 1, 65280);
        else
            aClass6_Sub1_724.FloatText("Magic cannot be used", byte0 + 234, byte1 + 192, 1, 0xff0000);
        if(anInt990 == 0)
            aClass6_Sub1_724.FloatText("Prayer may be used", byte0 + 234, byte1 + 204, 1, 65280);
        else
            aClass6_Sub1_724.FloatText("Prayer cannot be used", byte0 + 234, byte1 + 204, 1, 0xff0000);
        if(anInt991 == 0)
            aClass6_Sub1_724.FloatText("Weapons may be used", byte0 + 234, byte1 + 216, 1, 65280);
        else
            aClass6_Sub1_724.FloatText("Weapons cannot be used", byte0 + 234, byte1 + 216, 1, 0xff0000);
        aClass6_Sub1_724.FloatText("If you are sure click 'Accept' to begin the duel", byte0 + 234, byte1 + 230, 1, 0xffffff);
        if(!duelFinished)
        {
            aClass6_Sub1_724.method231((byte0 + 118) - 35, byte1 + 238, anInt948 + 25);
            aClass6_Sub1_724.method231((byte0 + 352) - 35, byte1 + 238, anInt948 + 26);
        } else
        {
            aClass6_Sub1_724.FloatText("Waiting for other player...", byte0 + 234, byte1 + 250, 1, 0xffff00);
        }
        if(mouseClick == 1)
        {
            if(super.mouseX < byte0 || super.mouseY < byte1 || super.mouseX > byte0 + 468 || super.mouseY > byte1 + 262)
            {
                duelWindow = false;
                super.packets.packetID(178);
                super.packets.sendpacket();
            }
            if(super.mouseX >= (byte0 + 118) - 35 && super.mouseX <= byte0 + 118 + 70 && super.mouseY >= byte1 + 238 && super.mouseY <= byte1 + 238 + 21)
            {
                duelFinished = true;
                super.packets.packetID(24);
                super.packets.sendpacket();
            }
            if(super.mouseX >= (byte0 + 352) - 35 && super.mouseX <= byte0 + 353 + 70 && super.mouseY >= byte1 + 238 && super.mouseY <= byte1 + 238 + 21)
            {
                duelWindow = false;
                super.packets.packetID(82);
                super.packets.sendpacket();
            }
            mouseClick = 0;
        }
    }

    public void method101()
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

    public void LoadSounds()
    {
        try
        {
            aByteArray987 = UnPack("sounds" + Class18.anInt580 + ".mem", "Sound effects", 90);
            anInputStream_Sub1_901 = new InputStream_Sub1();
            return;
        }
        catch(Throwable throwable)
        {
            System.out.println("Unable to init sounds:" + throwable);
        }
    }

    public void method103(boolean flag)
    {
        if(myPlayerY2 + myPlayerY1 <= 427)
		 pkermap = true;    		 
    	if(myPlayerY2 + myPlayerY1 > 427)
		 pkermap = false;
        int l8 = Class1.anInt144;
        int i = ((Class6) (aClass6_Sub1_724)).anInt311 - 199;
        char c = '\234';
        char c2 = '\230';
        aClass6_Sub1_724.method231(i - 49, 3, anInt948 + 2);
        i += 40;
        aClass6_Sub1_724.method216(i, 36, c, c2, 0);
        aClass6_Sub1_724.method209(i, 36, i + c, 36 + c2);
        int k = 192 + maphax;
        int i1 = mapangle + anInt859 & 0xff;
        int k1 = ((myPlayer.posX - 6040) * 3 * k) / 2048;
        int i3 = ((myPlayer.posY - 6040) * 3 * k) / 2048;
        int k4 = Class10.anIntArray394[1024 - i1 * 4 & 0x3ff];
        int i5 = Class10.anIntArray394[(1024 - i1 * 4 & 0x3ff) + 1024];
        int k5 = i3 * k4 + k1 * i5 >> 18;
        i3 = i3 * i5 - k1 * k4 >> 18;
        k1 = k5;
        aClass6_Sub1_724.method243((i + c / 2) - k1, 36 + c2 / 2 + i3, anInt948 - 1, i1 + 64 & 0xff, k);
        for(int i7 = 0; i7 < objCount; i7++)
        {
            int l1 = (((objXArray[i7] * anInt946 + 64) - myPlayer.posX) * 3 * k) / 2048;
            int j3 = (((objYArray[i7] * anInt946 + 64) - myPlayer.posY) * 3 * k) / 2048;
            int l5 = j3 * k4 + l1 * i5 >> 18;
            j3 = j3 * i5 - l1 * k4 >> 18;
            l1 = l5;
            if(pkermap)
            {
            	method74(i + c / 2 + l1, (36 + c2 / 2) - j3, 0x8B7355);
            } else {
            	method74(i + c / 2 + l1, (36 + c2 / 2) - j3, 65535);
            }
        }

        for(int j7 = 0; j7 < itemCount; j7++)
        {
            int i2 = (((itemXArray[j7] * anInt946 + 64) - myPlayer.posX) * 3 * k) / 2048;
            int k3 = (((itemYArray[j7] * anInt946 + 64) - myPlayer.posY) * 3 * k) / 2048;
            int i6 = k3 * k4 + i2 * i5 >> 18;
            k3 = k3 * i5 - i2 * k4 >> 18;
            i2 = i6;
            if(pkermap)
            {
            	method74(i + c / 2 + i2, (36 + c2 / 2) - k3, 0x0000ff);
            } else {
            	method74(i + c / 2 + i2, (36 + c2 / 2) - k3, 0xff0000);
            }
        }

        for(int k7 = 0; k7 < npccount; k7++)
        {
            Class2 class2 = NPCArray[k7];
            int j2 = ((class2.posX - myPlayer.posX) * 3 * k) / 2048;
            int l3 = ((class2.posY - myPlayer.posY) * 3 * k) / 2048;
            int j6 = l3 * k4 + j2 * i5 >> 18;
            l3 = l3 * i5 - j2 * k4 >> 18;
            j2 = j6;
            if(pkermap)
            {
            	method74(i + c / 2 + j2, (36 + c2 / 2) - l3, 0xD15FEE);
            } else {
            	method74(i + c / 2 + j2, (36 + c2 / 2) - l3, 0xffff00);
            }
        }

        for(int l7 = 0; l7 < PlayerCount; l7++)
        {
            Class2 class2_1 = PlayerArray[l7];
            int k2 = ((class2_1.posX - myPlayer.posX) * 3 * k) / 2048;
            int i4 = ((class2_1.posY - myPlayer.posY) * 3 * k) / 2048;
            int k6 = i4 * k4 + k2 * i5 >> 18;
            i4 = i4 * i5 - k2 * k4 >> 18;
            k2 = k6;
            int j8 = 0xffffff;
             if(pkermap)
            {
            	int oplayer = myPlayer.combatLevel - class2_1.combatLevel;
		if (oplayer == 0)
			j8 = 0xffff00;
		if(oplayer > 0)
			j8 = 0xc0ff00;
		if(oplayer > 3)
			j8 = 0x80ff00;
		if(oplayer > 6)
			j8 = 0x40ff00;
		if(oplayer > 10)
			j8 = 0x00FF00;
		if(oplayer < 0)
			j8 = 0xffb000;
		if(oplayer < -3)
			j8 = 0xff7000;
		if(oplayer < -6)
			j8 = 0xff3000;
		if(oplayer < -9)
			j8 = 0xFF0000;
		if(oplayer > (1 + (2203 - (myPlayerY2 + anInt807 + myPlayerY1)) / 6))
			j8 = (0x555555);				
		if(class2_1.combatLevel - myPlayer.combatLevel > (1 + (2203 - (myPlayerY2 + anInt807 + myPlayerY1)) / 6))
			j8 = (0x555555);
	    }
            for(int k8 = 0; k8 < super.anInt624; k8++)
            {
                if(class2_1.aLong145 != super.aLongArray625[k8] || super.anIntArray626[k8] != 99)
                    continue;
                if(pkermap)
                {
                	j8 = 0xffffff;
                	break;
                }else{
                	j8 = 0x00ff00;
                	break;
                }
            }

            if((myPlayer.combatLevel - class2_1.combatLevel <= (1 + (2203 - (myPlayerY2 + anInt807 + myPlayerY1)) / 6)) && (class2_1.combatLevel - myPlayer.combatLevel <= (1 + (2203 - (myPlayerY2 + anInt807 + myPlayerY1)) / 6)))
            method74(i + c / 2 + k2, (36 + c2 / 2) - i4, j8);
        }

        aClass6_Sub1_724.method213(i + c / 2, 36 + c2 / 2, 2, 0xffffff, 255);
        aClass6_Sub1_724.method243(i + 19, 55, anInt948 + 24, mapangle + 128 & 0xff, 128);
        aClass6_Sub1_724.method209(0, 0, anInt676, anInt677 + 12);
        if(!flag)
            return;
        i = super.mouseX - (((Class6) (aClass6_Sub1_724)).anInt311 - 199);
        int i8 = super.mouseY - 36;
        if(i >= 40 && i8 >= 0 && i < 196 && i8 < 152)
        {
            char c1 = '\234';
            char c3 = '\230';
            int l = 192 + maphax;
            int j1 = mapangle + anInt859 & 0xff;
            int j = ((Class6) (aClass6_Sub1_724)).anInt311 - 199;
            j += 40;
            int l2 = ((super.mouseX - (j + c1 / 2)) * 16384) / (3 * l);
            int j4 = ((super.mouseY - (36 + c3 / 2)) * 16384) / (3 * l);
            int l4 = Class10.anIntArray394[1024 - j1 * 4 & 0x3ff];
            int j5 = Class10.anIntArray394[(1024 - j1 * 4 & 0x3ff) + 1024];
            int l6 = j4 * l4 + l2 * j5 >> 15;
            j4 = j4 * j5 - l2 * l4 >> 15;
            l2 = l6;
            l2 += myPlayer.posX;
            j4 = myPlayer.posY - j4;
            if(mouseClick == 1)
                method99(myPlayerX2, myPlayerY2, l2 / 128, j4 / 128, false);
            mouseClick = 0;
        }
    }

    public boolean method104(int i, int j)
    {
        if(i == 31 && (method79(197) || method79(615) || method79(682)))
            return true;
        if(i == 32 && (method79(102) || method79(616) || method79(683)))
            return true;
        if(i == 33 && (method79(101) || method79(617) || method79(684)))
            return true;
        if(i == 34 && (method79(103) || method79(618) || method79(685)))
            return true;
        return inventoryCount(i) >= j;
    }

    public void method105(int i, int j, int k, int l)
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
            method83(myPlayerX2, myPlayerY2, i, j, (i + i1) - 1, (j + j1) - 1, false, true);
            return;
        } else
        {
            method83(myPlayerX2, myPlayerY2, i, j, (i + i1) - 1, (j + j1) - 1, true, true);
            return;
        }
    }

    public Class5 method106(int i, int j, int k, int l, int i1)
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

    public Class2 method107(int i, int j, int k, int l, int i1)
    {
        int l1 = Class1.anInt144;
        if(aClass2Array957[i] == null)
        {
            aClass2Array957[i] = new Class2();
            aClass2Array957[i].ID = i;
        }
        Class2 class2 = aClass2Array957[i];
        boolean flag = false;
        for(int j1 = 0; j1 < anInt906; j1++)
        {
            if(aClass2Array822[j1].ID != i)
                continue;
            flag = true;
            break;
        }

        if(flag)
        {
            class2.combatlvl = i1;
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
            class2.ID = i;
            class2.anInt155 = 0;
            class2.anInt156 = 0;
            class2.anIntArray157[0] = class2.posX = j;
            class2.anIntArray158[0] = class2.posY = k;
            class2.combatlvl = i1;
            class2.anInt154 = class2.status = l;
            class2.anInt152 = 0;
        }
        NPCArray[npccount++] = class2;
        return class2;
    }

    public void GameHandle()
    {
        int l10 = Class1.anInt144;
        if(anInt993 != 0)
        {
            aClass6_Sub1_724.method221();
            aClass6_Sub1_724.FloatText("Oh dear! You are dead...", anInt676 / 2, anInt677 / 2, 7, 0xff0000);
            ChatTypes();
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
      if(PacketStored)
      {
      	parseData2(PacketStore);
      	PacketStored = false;
      }
            aClass6_Sub1_724.method221();
            //if(Math.random() < 0.14999999999999999D)
            //    aClass6_Sub1_724.FloatText("ZZZ", (int)(Math.random() * 80D), (int)(Math.random() * 334D), 5, (int)(Math.random() * 16777215D));
            //if(Math.random() < 0.14999999999999999D)
            //    aClass6_Sub1_724.FloatText("ZZZ", 512 - (int)(Math.random() * 80D), (int)(Math.random() * 334D), 5, (int)(Math.random() * 16777215D));
            aClass6_Sub1_724.method216(anInt676 / 2 - 100, 160, 200, 40, 0);
            aClass6_Sub1_724.FloatText("Alseep", anInt676 / 2, 50, 7, 0xffff00);
            aClass6_Sub1_724.FloatText("Fatigue: " + (anInt893 * 100) / 750 + "%", anInt676 / 2, 90, 7, 0xffff00);
            aClass6_Sub1_724.FloatText("To automatically wake up use one of the following", anInt676 / 2, 140, 5, 0xffffff);
            aClass6_Sub1_724.FloatText("@yel@1.@whi@ OCR @yel@2.@whi@ SleepWalker - ReadMe for Info!", anInt676 / 2, 160, 5, 0xffffff);
            aClass6_Sub1_724.FloatText(super.aString40 + "*", anInt676 / 2, 180, 5, 65535);
            if(aString846 == null)
                aClass6_Sub1_724.method231(anInt676 / 2 - 127, 230, anInt952 + 1);
            else
                aClass6_Sub1_724.FloatText(aString846, anInt676 / 2, 260, 5, 0xff0000);
            aClass6_Sub1_724.method217(anInt676 / 2 - 128, 229, 257, 42, 0xffffff);
            ChatTypes();
            aClass6_Sub1_724.FloatText("The bot will write HC.bmp", anInt676 / 2, 290, 1, 0xffffff);
            aClass6_Sub1_724.FloatText("@yel@Click Here@whi@ to change words", anInt676 / 2, 305, 1, 0xffffff);
            aClass6_Sub1_724.method211(aGraphics857, 0, 0);
            return;
        }  		
        if(HideGFX)
        {
      if(PacketStored)
      {
      	parseData2(PacketStore);
      	PacketStored = false;
      }
        int l1 = (anInt676 / 2) - 40;
        byte byte0 = 36;
        char c1 = '\304';
        int j = 36;
        char c = '\304';
        int k = (anInt676 / 2) - 40;
        int i1 = 290;
        int k9 = 0xffffff;
        int j1 = byte0 + 260;
            int l = l1 + 3;
            aClass6_Sub1_724.method221();
            /*aClass6_Sub1_724.FloatText("WasteD BoT", (int)(Math.random() * 80D), (int)(Math.random() * 334D), 5, (int)(Math.random() * 16777215D));
            aClass6_Sub1_724.FloatText("WasteD BoT", 512 - (int)(Math.random() * 80D), (int)(Math.random() * 334D), 5, (int)(Math.random() * 16777215D));*/
            aClass6_Sub1_724.method216(anInt676 / 2 - 100, 160, 200, 40, 0);
            aClass6_Sub1_724.FloatText("@blu@WasteD BoT - Phate + Lormsby", anInt676 / 2, 50, 7, 0xffff00);
            if(super.mouseX > k && super.mouseX < k + c && super.mouseY > i1 - 12 && super.mouseY < i1 + 4)
            k9 = 0xff0000;
            aClass6_Sub1_724.FloatText("Graphics @yel@[On]", anInt676 / 2, 290, 5, k9);
            aClass6_Sub1_724.method211(aGraphics857, 0, 0);
            if(super.mouseX > l && super.mouseX < l + c1 && super.mouseY > j1 - 12 && super.mouseY < j1 + 4 && mouseClick == 1)
            {
                HideGFX = !HideGFX;
                if(HideGFX)
                {
                	chatText2("@bot@Hide Graphics - Enabled");
                } else
                {
                	chatText2("@bot@Hide Graphics - Disabled");
                }
                mouseClick = 0;
            } else {
            	if(mouseClick > 0)
            	{
            		mouseClick = 0;
            	}
            }
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
            if(anInt809 == 0 && (aClass19_883.anIntArrayArray608[myPlayer.posX / 128][myPlayer.posY / 128] & 0x80) == 0)
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
            for(int j = 0; j < objCount; j++)
            {
                if(objID[j] == 97)
                    method89(j, "firea" + (anInt839 + 1));
                if(objID[j] == 274)
                    method89(j, "fireplacea" + (anInt839 + 1));
                if(objID[j] == 1031)
                    method89(j, "lightning" + (anInt839 + 1));
                if(objID[j] == 1036)
                    method89(j, "firespell" + (anInt839 + 1));
                if(objID[j] == 1147)
                    method89(j, "spellcharge" + (anInt839 + 1));
            }

        }
        if(anInt840 != anInt920)
        {
            anInt920 = anInt840;
            for(int k = 0; k < objCount; k++)
            {
                if(objID[k] == 51)
                    method89(k, "torcha" + (anInt840 + 1));
                if(objID[k] == 143)
                    method89(k, "skulltorcha" + (anInt840 + 1));
            }

        }
        if(anInt841 != anInt921)
        {
            anInt921 = anInt841;
            for(int l = 0; l < objCount; l++)
                if(objID[l] == 1142)
                    method89(l, "clawspell" + (anInt841 + 1));

        }
        aClass10_739.method273(anInt744);
        anInt744 = 0;
        for(int i1 = 0; i1 < PlayerCount; i1++)
        {
            Class2 class2 = PlayerArray[i1];
            if(class2.anInt171 != 255)
            {
                int k1 = class2.posX;
                int i2 = class2.posY;
                int k2 = -aClass19_883.method421(k1, i2);
                int l3 = aClass10_739.method274(5000 + i1, k1, k2, i2, 145, 220, i1 + 10000);
                anInt744++;
                if(class2 == myPlayer)
                    aClass10_739.method275(l3);
                if(class2.status == 8)
                    aClass10_739.method276(l3, -30);
                if(class2.status == 9)
                    aClass10_739.method276(l3, 30);
            }
        }

        for(int j1 = 0; j1 < PlayerCount; j1++)
        {
            Class2 class2_1 = PlayerArray[j1];
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
                    int l2 = class2_1.posX;
                    int i4 = class2_1.posY;
                    int l6 = -aClass19_883.method421(l2, i4) - 110;
                    int l8 = class2_2.posX;
                    int k9 = class2_2.posY;
                    int l9 = -aClass19_883.method421(l8, k9) - Class1.anIntArray103[class2_2.combatlvl] / 2;
                    int i10 = (l2 * class2_1.anInt176 + l8 * (anInt897 - class2_1.anInt176)) / anInt897;
                    int j10 = (l6 * class2_1.anInt176 + l9 * (anInt897 - class2_1.anInt176)) / anInt897;
                    int k10 = (i4 * class2_1.anInt176 + k9 * (anInt897 - class2_1.anInt176)) / anInt897;
                    aClass10_739.method274(anInt951 + class2_1.anInt173, i10, j10, k10, 32, 32, 0);
                    anInt744++;
                }
            }
        }

        for(int l1 = 0; l1 < npccount; l1++)
        {
            Class2 class2_3 = NPCArray[l1];
            int i3 = class2_3.posX;
            int j4 = class2_3.posY;
            int i7 = -aClass19_883.method421(i3, j4);
            int i9 = aClass10_739.method274(20000 + l1, i3, i7, j4, Class1.anIntArray102[class2_3.combatlvl], Class1.anIntArray103[class2_3.combatlvl], l1 + 30000);
            anInt744++;
            if(class2_3.status == 8)
                aClass10_739.method276(i9, -30);
            if(class2_3.status == 9)
                aClass10_739.method276(i9, 30);
        }

        for(int j2 = 0; j2 < itemCount; j2++)
        {
            int j3 = itemXArray[j2] * anInt946 + 64;
            int k4 = itemYArray[j2] * anInt946 + 64;
            aClass10_739.method274(40000 + itemIDArray[j2], j3, -aClass19_883.method421(j3, k4) - anIntArray773[j2], k4, 96, 64, j2 + 20000);
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
                    anInt714 = myPlayer.posX;
                    anInt715 = myPlayer.posY;
                }
            }
            aClass10_739.anInt390 = 3000;
            aClass10_739.anInt391 = 3000;
            aClass10_739.anInt392 = 1;
            aClass10_739.anInt393 = 2800;
            mapangle = anInt940 * 32;
            int k5 = anInt714 + anInt895;
            int l7 = anInt715 + anInt973;
            aClass10_739.method298(k5, -aClass19_883.method421(k5, l7), l7, xrotate, mapangle * 4, 0, 2000);
        } else
        {
            if(aBoolean675 && !aBoolean789)
                method78();
                
              if(FogOfWar)
              {
            if(!super.aBoolean39)
            {
                aClass10_739.anInt390 = 2400;
                aClass10_739.anInt391 = 2400;
                aClass10_739.anInt392 = 1;
                aClass10_739.anInt393 = 2300;
            } else
            {
                aClass10_739.anInt390 = 2200;
                aClass10_739.anInt391 = 2200;
                aClass10_739.anInt392 = 1;
                aClass10_739.anInt393 = 2100;
            }
              } else
              {
              if(!super.aBoolean39)
				{
				aClass10_739.anInt390 = 50000;
				aClass10_739.anInt391 = 50000;
				aClass10_739.anInt392 = 1;
				aClass10_739.anInt393 = 50000;
				} else
				{
				aClass10_739.anInt390 = 50000;
				aClass10_739.anInt391 = 50000;
				aClass10_739.anInt392 = 1;
				aClass10_739.anInt393 = 50000;
                }
               }
            int l5 = anInt714 + focusx;
            int i8 = anInt715 + focusy;
            aClass10_739.method298(l5, -aClass19_883.method421(l5, i8), i8, xrotate, mapangle * 4, 0, CameraZoom * 2);
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
                aClass6_Sub1_724.FloatText("System update in: " + j8 + ":0" + i6, 256, anInt677 - 7, 1, 0xffff00);
            else
                aClass6_Sub1_724.FloatText("System update in: " + j8 + ":" + i6, 256, anInt677 - 7, 1, 0xffff00);
        }
        //if(show)
        //        aClass6_Sub1_724.FloatText("(" + super.mouseX + ":" + super.mouseY + ")", 256, anInt677 - 7, 1, 0x00ff00);
        if(macroOn)
        {
        	int x = CurrentXPArray[2] - startXP;
        	if(fightMode == 0)
        		x = CurrentXPArray[0] + CurrentXPArray[1] + CurrentXPArray[2] - startXP / 3;
        	if(fightMode == 1)
        		x = CurrentXPArray[2] - startXP;
        	if(fightMode == 2)
        		x = CurrentXPArray[0] - startXP;
        	if(fightMode == 3)
        		x = CurrentXPArray[1] - startXP;
        	if(fightMode == 0)
        	{
        		aClass6_Sub1_724.FloatText("@whi@Fightmode: @gre@" + lockedFightMode + "  @whi@-  " + "XP Gained: @gre@" + x + " @whi@on @gre@Attack, Defense & Strength", 256, anInt677 - 7, 1, 0x00ff00);
        	}
        	if(fightMode == 1)
        	{
        		aClass6_Sub1_724.FloatText("@whi@Fightmode: @gre@" + lockedFightMode + "  @whi@-  " + "XP Gained: @gre@" + x + " @whi@on @gre@Strength", 256, anInt677 - 7, 1, 0x00ff00);
        	}
        	if(fightMode == 2)
        	{
        		aClass6_Sub1_724.FloatText("@whi@Fightmode: @gre@" + lockedFightMode + "  @whi@-  " + "XP Gained: @gre@" + x + " @whi@on @gre@Attack", 256, anInt677 - 7, 1, 0x00ff00);
        	}
        	if(fightMode == 3)
        	{
        		aClass6_Sub1_724.FloatText("@whi@Fightmode: @gre@" + lockedFightMode + "  @whi@-  " + "XP Gained: @gre@" + x + " @whi@on @gre@Defense", 256, anInt677 - 7, 1, 0x00ff00);
        	}
        }
    //Loop Start
    
    if(fatigue() >= sleepthresh && inventoryCount(1263) > 0 && !asleep)
    {
    	useitemid(1263);
    	chatText2("@BOT@Fatigue crossed sleepThresh - sleeping...");
    	asleep = true;
    }
     gettime();
     int mousecoordX = optionObjXArray[0] + myPlayerX1;
     int mousecoordY = optionObjYArray[0] + myPlayerY1;
      if(mousecoordX != MYLastMousePosX) {
      MYLastMousePosX = mousecoordX;
       if(mousecoordY != MYLastMousePosY) {
        MYLastMousePosY = mousecoordY;
        XClient.sendPacketIG("@MOUSEPOS " + mousecoordX + " " + mousecoordY);
       }
     }
     int myX = posX();
     int myY = posY();
     if(myX != MYLastMousePosX) {
      MYLastMousePosX = myX;
       if(myY != MYLastMousePosY) {
        MYLastMousePosY = myY;
        XClient.sendPacketIG("@MYPOS " + myX + " " + myY);
       }
     }
     if(PacketStored)
      {
      	parseData2(PacketStore);
      	PacketStored = false;
      }
      
     if(WText1)
      {
      	aClass6_Sub1_724.FloatText(WText1Text, WText1X, WText1Y, 1, 0xffff00);
      }
      if(WText2)
      {
      	aClass6_Sub1_724.FloatText(WText2Text, WText2X, WText2Y, 1, 0xffff00);
      }
      if(WText3)
      {
      	aClass6_Sub1_724.FloatText(WText3Text, WText3X, WText3Y, 1, 0xffff00);
      }
      if(WText4)
      {
      	aClass6_Sub1_724.FloatText(WText4Text, WText4X, WText4Y, 1, 0xffff00);
      }
      if(WText5)
      {
      	aClass6_Sub1_724.FloatText(WText5Text, WText5X, WText5Y, 1, 0xffff00);
      }
      if(WText6)
      {
      	aClass6_Sub1_724.FloatText(WText6Text, WText6X, WText6Y, 1, 0xffff00);
      }
      if(WText7)
      {
      	aClass6_Sub1_724.FloatText(WText7Text, WText7X, WText7Y, 1, 0xffff00);
      }
      if(WText8)
      {
      	aClass6_Sub1_724.FloatText(WText8Text, WText8X, WText8Y, 1, 0xffff00);
      }
      if(WText9)
      {
      	aClass6_Sub1_724.FloatText(WText9Text, WText9X, WText9Y, 1, 0xffff00);
      }
    //Loop End
        if(!aBoolean717)
        {
            int j6 = 2203 - (myPlayerY2 + anInt807 + myPlayerY1);
            if(myPlayerX2 + anInt806 + myPlayerX1 >= 2640)
                j6 = -50;
            if(j6 > 0)
            {
                int k8 = 1 + j6 / 6;
                aClass6_Sub1_724.method231(453, anInt677 - 56, anInt948 + 13);
                aClass6_Sub1_724.FloatText("@dre@[@whi@Wilderness@dre@]", 465, anInt677 - 20, 1, 0xffff00);
                aClass6_Sub1_724.FloatText("@dre@[@whi@Level " + k8 + "@dre@]", 465, anInt677 - 7, 1, 0xffff00);
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
        CentralControls();
        aClass6_Sub1_724.aBoolean338 = false;
        ChatTypes();
        aClass6_Sub1_724.method211(aGraphics857, 0, 0);
    }

    void method109(int i, int j, int k, int l, int i1, int j1, int k1)
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

    public void method11(int i, int j, int k)
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
                        LogOutControls();
                        return;
                    }
                }

            }
        }

    }

    public void Options()
    {
        int l1 = Class1.anInt144;
        if(mouseClick != 0)
        {
            for(int i = 0; i < optionCount; i++)
            {
                int k = anInt752 + 2;
                int i1 = anInt753 + 27 + i * 15;
                if(super.mouseX <= k - 2 || super.mouseY <= i1 - 12 || super.mouseY >= i1 + 4 || super.mouseX >= (k - 3) + anInt754)
                    continue;
                optionPacketSender(anIntArray984[i]);
                break;
            }

            mouseClick = 0;
            aBoolean854 = false;
            return;
        }
        if(super.mouseX < anInt752 - 10 || super.mouseY < anInt753 - 10 || super.mouseX > anInt752 + anInt754 + 10 || super.mouseY > anInt753 + anInt755 + 10)
        {
            aBoolean854 = false;
            return;
        }
        aClass6_Sub1_724.method214(anInt752, anInt753, anInt754, anInt755, 0xd0d0d0, 160);
        aClass6_Sub1_724.method257("WasteDBoT", anInt752 + 2, anInt753 + 12, 1, 65535);
        for(int j = 0; j < optionCount; j++)
        {
            int l = anInt752 + 2;
            int j1 = anInt753 + 27 + j * 15;
            int k1 = 0xffffff;
            if(super.mouseX > l - 2 && super.mouseY > j1 - 12 && super.mouseY < j1 + 4 && super.mouseX < (l - 3) + anInt754)
                k1 = 0xffff00;
            aClass6_Sub1_724.method257(optionNameArray[anIntArray984[j]] + " " + optionObjectArray[anIntArray984[j]], l, j1, 1, k1);
        }

    }

    public void method111(int i, int j, int k)
    {
        if(k == 0)
        {
            method83(myPlayerX2, myPlayerY2, i, j - 1, i, j, false, true);
            return;
        }
        if(k == 1)
        {
            method83(myPlayerX2, myPlayerY2, i - 1, j, i, j, false, true);
            return;
        } else
        {
            method83(myPlayerX2, myPlayerY2, i, j, i, j, true, true);
            return;
        }
    }

    public boolean FileLoad2(int i)
    {
        int j = myPlayer.posX / 128;
        int k = myPlayer.posY / 128;
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

    public void LoadStuff()
    {
        int i1 = Class1.anInt144;
        byte abyte0[] = UnPack("textures" + Class18.anInt578 + ".jag", "Textures", 50);
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

    public void method114()
    {
        if(toolbar == 0 && super.mouseX >= ((Class6) (aClass6_Sub1_724)).anInt311 - 35 && super.mouseY >= 3 && super.mouseX < ((Class6) (aClass6_Sub1_724)).anInt311 - 3 && super.mouseY < 35)
            toolbar = 1;
        if(toolbar == 0 && super.mouseX >= ((Class6) (aClass6_Sub1_724)).anInt311 - 35 - 33 && super.mouseY >= 3 && super.mouseX < ((Class6) (aClass6_Sub1_724)).anInt311 - 3 - 33 && super.mouseY < 35)
        {
            toolbar = 2;
            anInt859 = (int)(Math.random() * 0D) - 0;
            anInt860 = (int)(Math.random() * 0D) - 0;
        }
        if(toolbar == 0 && super.mouseX >= ((Class6) (aClass6_Sub1_724)).anInt311 - 35 - 66 && super.mouseY >= 3 && super.mouseX < ((Class6) (aClass6_Sub1_724)).anInt311 - 3 - 66 && super.mouseY < 35)
            toolbar = 3;
        if(toolbar == 0 && super.mouseX >= ((Class6) (aClass6_Sub1_724)).anInt311 - 35 - 99 && super.mouseY >= 3 && super.mouseX < ((Class6) (aClass6_Sub1_724)).anInt311 - 3 - 99 && super.mouseY < 35)
            toolbar = 4;
        if(toolbar == 0 && super.mouseX >= ((Class6) (aClass6_Sub1_724)).anInt311 - 35 - 132 && super.mouseY >= 3 && super.mouseX < ((Class6) (aClass6_Sub1_724)).anInt311 - 3 - 132 && super.mouseY < 35)
            toolbar = 5;
        if(toolbar == 0 && super.mouseX >= ((Class6) (aClass6_Sub1_724)).anInt311 - 35 - 165 && super.mouseY >= 3 && super.mouseX < ((Class6) (aClass6_Sub1_724)).anInt311 - 3 - 165 && super.mouseY < 35)
            toolbar = 6;
        if(toolbar != 0 && super.mouseX >= ((Class6) (aClass6_Sub1_724)).anInt311 - 35 && super.mouseY >= 3 && super.mouseX < ((Class6) (aClass6_Sub1_724)).anInt311 - 3 && super.mouseY < 26)
            toolbar = 1;
        if(toolbar != 0 && toolbar != 2 && super.mouseX >= ((Class6) (aClass6_Sub1_724)).anInt311 - 35 - 33 && super.mouseY >= 3 && super.mouseX < ((Class6) (aClass6_Sub1_724)).anInt311 - 3 - 33 && super.mouseY < 26)
        {
            toolbar = 2;
            anInt859 = (int)(Math.random() * 0D) - 0;
            anInt860 = (int)(Math.random() * 0D) - 0;
        }
        if(toolbar != 0 && super.mouseX >= ((Class6) (aClass6_Sub1_724)).anInt311 - 35 - 66 && super.mouseY >= 3 && super.mouseX < ((Class6) (aClass6_Sub1_724)).anInt311 - 3 - 66 && super.mouseY < 26)
            toolbar = 3;
        if(toolbar != 0 && super.mouseX >= ((Class6) (aClass6_Sub1_724)).anInt311 - 35 - 99 && super.mouseY >= 3 && super.mouseX < ((Class6) (aClass6_Sub1_724)).anInt311 - 3 - 99 && super.mouseY < 26)
            toolbar = 4;
        if(toolbar != 0 && super.mouseX >= ((Class6) (aClass6_Sub1_724)).anInt311 - 35 - 132 && super.mouseY >= 3 && super.mouseX < ((Class6) (aClass6_Sub1_724)).anInt311 - 3 - 132 && super.mouseY < 26)
            toolbar = 5;
        if(toolbar != 0 && super.mouseX >= ((Class6) (aClass6_Sub1_724)).anInt311 - 35 - 165 && super.mouseY >= 3 && super.mouseX < ((Class6) (aClass6_Sub1_724)).anInt311 - 3 - 165 && super.mouseY < 26)
            toolbar = 6;
        if(toolbar == 1 && (super.mouseX < ((Class6) (aClass6_Sub1_724)).anInt311 - 248 || super.mouseY > 36 + (anInt707 / 5) * 34))
            toolbar = 0;
        if(toolbar == 3 && (super.mouseX < ((Class6) (aClass6_Sub1_724)).anInt311 - 199 || super.mouseY > 316))
            toolbar = 0;
        if((toolbar == 2 || toolbar == 4 || toolbar == 5) && (super.mouseX < ((Class6) (aClass6_Sub1_724)).anInt311 - 199 || super.mouseY > 240))
            toolbar = 0;
        if(toolbar == 6 && (super.mouseX < ((Class6) (aClass6_Sub1_724)).anInt311 - 199 || super.mouseY > 311))
            toolbar = 0;
    }

    public void StatQuest(boolean flag)
    {
        int k3 = Class1.anInt144;
        int i = ((Class6) (aClass6_Sub1_724)).anInt311 - 199;
        int j = 36;
        aClass6_Sub1_724.method231(i - 49, 3, anInt948 + 3);
        char c = '\304';
        char c1 = '\u0113';
        int l;
        int k = l = Class6.method223(100, 100, 100);
        if(anInt828 == 0)
            k = Class6.method223(190, 190, 190);
        else
            l = Class6.method223(190, 190, 190);
        aClass6_Sub1_724.method214(i, j, c / 2, 24, k, 128);
        aClass6_Sub1_724.method214(i + c / 2, j, c / 2, 24, l, 128);
        aClass6_Sub1_724.method214(i, j + 24, c, c1 - 24, Class6.method223(100, 100, 100), 128);
        aClass6_Sub1_724.method218(i, j + 24, c, 0);
        aClass6_Sub1_724.method219(i + c / 2, j, 24, 0);
        aClass6_Sub1_724.FloatText("Stats", i + c / 4, j + 16, 4, 0);
        aClass6_Sub1_724.FloatText("Quests", i + c / 4 + c / 2, j + 16, 4, 0);
        if(anInt828 == 0)
        {
            int i1 = 72;
            int k1 = -1;
            aClass6_Sub1_724.method257("Skills", i + 5, i1, 3, 0xffff00);
            i1 += 13;
            for(int l1 = 0; l1 < 9; l1++)
            {
                int i2 = 0xffffff;
                if(super.mouseX > i + 3 && super.mouseY >= i1 - 11 && super.mouseY < i1 + 2 && super.mouseX < i + 90)
                {
                    i2 = 0xff0000;
                    k1 = l1;
                }
                aClass6_Sub1_724.method257(StatNameArray[l1] + " @yel@" + CurrentStatLevelArray[l1] + "@red@/@yel@" + RealStatLevelArray[l1], i + 5, i1, 1, i2);
                i2 = 0xffffff;
                if(super.mouseX >= i + 90 && super.mouseY >= i1 - 13 - 11 && super.mouseY < (i1 - 13) + 2 && super.mouseX < i + 196)
                {
                    i2 = 0xff0000;
                    k1 = l1 + 9;
                }
                aClass6_Sub1_724.method257(StatNameArray[l1 + 9] + " @yel@" + CurrentStatLevelArray[l1 + 9] + "@red@/@yel@" + RealStatLevelArray[l1 + 9], (i + c / 2) - 5, i1 - 13, 1, i2);
                i1 += 13;
            }

            aClass6_Sub1_724.method257("Quest Points [@yel@" + anInt996 + "@whi@]", (i + c / 2) - 5, i1 - 13, 1, 0xffffff);
            i1 += 12;
            aClass6_Sub1_724.method257("Fatigue [@yel@" + (fatigue * 100) / 750 + "." + fatigue % 750 + "%@whi@]", i + 5, i1 - 13, 1, 0xffffff);
            i1 += 8;
            aClass6_Sub1_724.method257("Equipment Status", i + 5, i1, 3, 0xffff00);
            i1 += 12;
            for(int j2 = 0; j2 < 3; j2++)
            {
                aClass6_Sub1_724.method257(aStringArray932[j2] + " [@yel@" + anIntArray797[j2] + "@whi@]", i + 5, i1, 1, 0xffffff);
                if(j2 < 2)
                    aClass6_Sub1_724.method257(aStringArray932[j2 + 3] + " [@yel@" + anIntArray797[j2 + 3] + "@whi@]", i + c / 2 + 25, i1, 1, 0xffffff);
                i1 += 13;
            }

            i1 += 6;
            aClass6_Sub1_724.method218(i, i1 - 15, c, 0);
            if(k1 != -1)
            {
                aClass6_Sub1_724.method257("@yel@" + aStringArray795[k1] + "@whi@ skill", i + 5, i1, 1, 0xffff00);
                i1 += 12;
                int k2 = anIntArray686[0];
                for(int i3 = 0; i3 < 98; i3++)
                    if(CurrentXPArray[k1] >= anIntArray686[i3])
                        k2 = anIntArray686[i3 + 1];

                aClass6_Sub1_724.method257("Total xp [@yel@" + CurrentXPArray[k1] / 4 + "@whi@]", i + 5, i1, 1, 0xffffff);
                i1 += 12;
                aClass6_Sub1_724.method257("Next level at [@yel@" + k2 / 4 + "@whi@]", i + 5, i1, 1, 0xffffff);
            } else
            {
                aClass6_Sub1_724.method257("Overall levels", i + 5, i1, 1, 0xffff00);
                i1 += 12;
                int l2 = 0;
                for(int j3 = 0; j3 < 18; j3++)
                    l2 += RealStatLevelArray[j3];

                aClass6_Sub1_724.method257("Skill total [@yel@" + l2 + "@whi@]", i + 5, i1, 1, 0xffffff);
                i1 += 12;
                aClass6_Sub1_724.method257("Combat level [@yel@" + myPlayer.combatLevel + "@whi@]", i + 5, i1, 1, 0xffffff);
                i1 += 12;
            }
        }
        if(anInt828 == 1)
        {
            aClass4_826.method165(anInt827);
            aClass4_826.method167(anInt827, 0, "@whi@Quest-list (green=completed)");
            for(int j1 = 0; j1 < 50; j1++)
                aClass4_826.method167(anInt827, j1 + 1, (aBooleanArray716[j1] ? "@gre@" : "@red@") + aStringArray930[j1]);

            aClass4_826.method142();
        }
        if(!flag)
            return;
        i = super.mouseX - (((Class6) (aClass6_Sub1_724)).anInt311 - 199);
        j = super.mouseY - 36;
        if(i >= 0 && j >= 0 && i < c && j < c1)
        {
            if(anInt828 == 1)
                aClass4_826.method139(i + (((Class6) (aClass6_Sub1_724)).anInt311 - 199), j + 36, super.anInt36, super.anInt35);
            if(j <= 24 && mouseClick == 1)
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

    public void ReportAbuse()
    {
        int l = Class1.anInt144;
        anInt863 = 0;
        int i = 135;
        for(int j = 0; j < 12; j++)
        {
            if(super.mouseX > 66 && super.mouseX < 446 && super.mouseY >= i - 12 && super.mouseY < i + 3)
                anInt863 = j + 1;
            i += 14;
        }

        if(mouseClick != 0 && anInt863 != 0)
        {
            mouseClick = 0;
            anInt986 = 2;
            super.aString40 = "";
            super.aString41 = "";
            return;
        }
        i += 15;
        if(mouseClick != 0)
        {
            mouseClick = 0;
            if(super.mouseX < 56 || super.mouseY < 35 || super.mouseX > 456 || super.mouseY > 325)
            {
                anInt986 = 0;
                return;
            }
            if(super.mouseX > 66 && super.mouseX < 446 && super.mouseY >= i - 15 && super.mouseY < i + 5)
            {
                anInt986 = 0;
                return;
            }
        }
        aClass6_Sub1_724.method216(56, 35, 400, 290, 0);
        aClass6_Sub1_724.method217(56, 35, 400, 290, 0xffffff);
        i = 50;
        aClass6_Sub1_724.FloatText("This form is for reporting players who are breaking our rules", 256, i, 1, 0xffffff);
        i += 15;
        aClass6_Sub1_724.FloatText("Using it sends a snapshot of the last 60 secs of activity to us", 256, i, 1, 0xffffff);
        i += 15;
        aClass6_Sub1_724.FloatText("If you misuse this form, you will be banned.", 256, i, 1, 0xff8000);
        i += 15;
        i += 10;
        aClass6_Sub1_724.FloatText("First indicate which of our 12 rules is being broken. For a detailed", 256, i, 1, 0xffff00);
        i += 15;
        aClass6_Sub1_724.FloatText("explanation of each rule please read the manual on our website.", 256, i, 1, 0xffff00);
        i += 15;
        int k;
        if(anInt863 == 1)
        {
            aClass6_Sub1_724.method217(66, i - 12, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        aClass6_Sub1_724.FloatText("1: Offensive language", 256, i, 1, k);
        i += 14;
        if(anInt863 == 2)
        {
            aClass6_Sub1_724.method217(66, i - 12, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        aClass6_Sub1_724.FloatText("2: Item scamming", 256, i, 1, k);
        i += 14;
        if(anInt863 == 3)
        {
            aClass6_Sub1_724.method217(66, i - 12, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        aClass6_Sub1_724.FloatText("3: Password scamming", 256, i, 1, k);
        i += 14;
        if(anInt863 == 4)
        {
            aClass6_Sub1_724.method217(66, i - 12, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        aClass6_Sub1_724.FloatText("4: Bug abuse", 256, i, 1, k);
        i += 14;
        if(anInt863 == 5)
        {
            aClass6_Sub1_724.method217(66, i - 12, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        aClass6_Sub1_724.FloatText("5: Jagex Staff impersonation", 256, i, 1, k);
        i += 14;
        if(anInt863 == 6)
        {
            aClass6_Sub1_724.method217(66, i - 12, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        aClass6_Sub1_724.FloatText("6: Account sharing/trading", 256, i, 1, k);
        i += 14;
        if(anInt863 == 7)
        {
            aClass6_Sub1_724.method217(66, i - 12, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        aClass6_Sub1_724.FloatText("7: Macroing", 256, i, 1, k);
        i += 14;
        if(anInt863 == 8)
        {
            aClass6_Sub1_724.method217(66, i - 12, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        aClass6_Sub1_724.FloatText("8: Mutiple logging in", 256, i, 1, k);
        i += 14;
        if(anInt863 == 9)
        {
            aClass6_Sub1_724.method217(66, i - 12, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        aClass6_Sub1_724.FloatText("9: Encouraging others to break rules", 256, i, 1, k);
        i += 14;
        if(anInt863 == 10)
        {
            aClass6_Sub1_724.method217(66, i - 12, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        aClass6_Sub1_724.FloatText("10: Misuse of customer support", 256, i, 1, k);
        i += 14;
        if(anInt863 == 11)
        {
            aClass6_Sub1_724.method217(66, i - 12, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        aClass6_Sub1_724.FloatText("11: Advertising / website", 256, i, 1, k);
        i += 14;
        if(anInt863 == 12)
        {
            aClass6_Sub1_724.method217(66, i - 12, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        aClass6_Sub1_724.FloatText("12: Real world item trading", 256, i, 1, k);
        i += 14;
        i += 15;
        k = 0xffffff;
        if(super.mouseX > 196 && super.mouseX < 316 && super.mouseY > i - 15 && super.mouseY < i + 5)
            k = 0xffff00;
        aClass6_Sub1_724.FloatText("Click here to cancel", 256, i, 1, k);
    }

    public void Shop()
    {
        int l6 = Class1.anInt144;
        if(mouseClick != 0)
        {
            mouseClick = 0;
            int i = super.mouseX - 52;
            int j = super.mouseY - 44;
            if(i >= 0 && j >= 12 && i < 408 && j < 246)
            {
                int k = 0;
                for(int i1 = 0; i1 < 5; i1++)
                {
                    for(int i2 = 0; i2 < 8; i2++)
                    {
                        int l2 = 7 + i2 * 49;
                        int l3 = 28 + i1 * 34;
                        if(i > l2 && i < l2 + 49 && j > l3 && j < l3 + 34 && shopItemID[k] != -1)
                        {
                            selectedShopItem = k;
                            anInt904 = shopItemID[k];
                        }
                        k++;
                    }

                }

                if(selectedShopItem >= 0)
                {
                    int j2 = shopItemID[selectedShopItem];
                    if(j2 != -1)
                    {
                        if(shopItemCount[selectedShopItem] > 0 && i > 298 && j >= 204 && i < 408 && j <= 215)
                        {
                            int i3 = anInt900 + anIntArray738[selectedShopItem];
                            if(i3 < 10)
                                i3 = 10;
                            int i4 = (i3 * Class1.shopBaseWorth[j2]) / 100;
                            super.packets.packetID(157);
                            super.packets.variables343(shopItemID[selectedShopItem]);
                            super.packets.method332(i4);
                            super.packets.sendpacket();
                            System.out.println("BuyItem(" + shopItemID[selectedShopItem] + "," + i4 + ")");
                        }
                        if(inventoryCount(j2) > 0 && i > 2 && j >= 229 && i < 112 && j <= 240)
                        {
                            int j3 = anInt899 + anIntArray738[selectedShopItem];
                            if(j3 < 10)
                                j3 = 10;
                            int j4 = (j3 * Class1.shopBaseWorth[j2]) / 100;
                            super.packets.packetID(211);
                            super.packets.variables343(shopItemID[selectedShopItem]);
                            super.packets.method332(j4);
                            super.packets.sendpacket();
                            System.out.println("SellItem(" + shopItemID[selectedShopItem] + "," + j4 + ")");
                        }
                    }
                }
            } else
            {
                super.packets.packetID(56);
                super.packets.sendpacket();
                aBoolean727 = false;
                System.out.println("CloseShop()");
                XClient.sendPacket("SHOPWINDOW 0");
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
        if(super.mouseX > byte0 + 320 && super.mouseY >= byte1 && super.mouseX < byte0 + 408 && super.mouseY < byte1 + 12)
            j1 = 0xff0000;
        aClass6_Sub1_724.method254("Close window", byte0 + 406, byte1 + 10, 1, j1);
        aClass6_Sub1_724.method257("Shops stock in green", byte0 + 2, byte1 + 24, 1, 65280);
        aClass6_Sub1_724.method257("Number you own in blue", byte0 + 135, byte1 + 24, 1, 65535);
        aClass6_Sub1_724.method257("Your money: " + inventoryCount(10) + "gp", byte0 + 280, byte1 + 24, 1, 0xffff00);
        int k2 = 0xd0d0d0;
        int k3 = 0;
        for(int k4 = 0; k4 < 5; k4++)
        {
            for(int l4 = 0; l4 < 8; l4++)
            {
                int j5 = byte0 + 7 + l4 * 49;
                int i6 = byte1 + 28 + k4 * 34;
                if(selectedShopItem == k3)
                    aClass6_Sub1_724.method214(j5, i6, 49, 34, 0xff0000, 160);
                else
                    aClass6_Sub1_724.method214(j5, i6, 49, 34, k2, 160);
                aClass6_Sub1_724.method217(j5, i6, 50, 35, 0);
                if(shopItemID[k3] != -1)
                {
                    aClass6_Sub1_724.method247(j5, i6, 48, 32, anInt950 + Class1.anIntArray53[shopItemID[k3]], Class1.anIntArray58[shopItemID[k3]], 0, 0, false);
                    aClass6_Sub1_724.method257(String.valueOf(shopItemCount[k3]), j5 + 1, i6 + 10, 1, 65280);
                    aClass6_Sub1_724.method254(String.valueOf(inventoryCount(shopItemID[k3])), j5 + 47, i6 + 10, 1, 65535);
                }
                k3++;
            }

        }

        aClass6_Sub1_724.method218(byte0 + 5, byte1 + 222, 398, 0);
        if(selectedShopItem == -1)
        {
            aClass6_Sub1_724.FloatText("Select an object to buy or sell", byte0 + 204, byte1 + 214, 3, 0xffff00);
            return;
        }
        int i5 = shopItemID[selectedShopItem];
        if(i5 != -1)
        {
            if(shopItemCount[selectedShopItem] > 0)
            {
                int k5 = anInt900 + anIntArray738[selectedShopItem];
                if(k5 < 10)
                    k5 = 10;
                int j6 = (k5 * Class1.shopBaseWorth[i5]) / 100;
                aClass6_Sub1_724.method257("Buy a new " + Class1.itemNameArray[i5] + " for " + j6 + "gp", byte0 + 2, byte1 + 214, 1, 0xffff00);
                int k1 = 0xffffff;
                if(super.mouseX > byte0 + 298 && super.mouseY >= byte1 + 204 && super.mouseX < byte0 + 408 && super.mouseY <= byte1 + 215)
                    k1 = 0xff0000;
                aClass6_Sub1_724.method254("Click here to buy", byte0 + 405, byte1 + 214, 3, k1);
            } else
            {
                aClass6_Sub1_724.FloatText("This item is not currently available to buy", byte0 + 204, byte1 + 214, 3, 0xffff00);
            }
            if(inventoryCount(i5) > 0)
            {
                int l5 = anInt899 + anIntArray738[selectedShopItem];
                if(l5 < 10)
                    l5 = 10;
                int k6 = (l5 * Class1.shopBaseWorth[i5]) / 100;
                aClass6_Sub1_724.method254("Sell your " + Class1.itemNameArray[i5] + " for " + k6 + "gp", byte0 + 405, byte1 + 239, 1, 0xffff00);
                int l1 = 0xffffff;
                if(super.mouseX > byte0 + 2 && super.mouseY >= byte1 + 229 && super.mouseX < byte0 + 112 && super.mouseY <= byte1 + 240)
                    l1 = 0xff0000;
                aClass6_Sub1_724.method257("Click here to sell", byte0 + 2, byte1 + 239, 3, l1);
                return;
            }
            aClass6_Sub1_724.FloatText("You do not have any of this item to sell", byte0 + 204, byte1 + 239, 3, 0xffff00);
        }
    }
    
    public void chatText(String s, int i)
    {
        gettime();
        cal = new GregorianCalendar();
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
            s = currenttime + " " + "@yel@" + s;
        if(i == 3 || i == 4)
            s = currenttime + " " + "@whi@" + s;
        if(i == 5)
            s = currenttime + " " + " " + s;
        if(i == 6)
            s = currenttime + " " + "@cya@" + s;
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

    void method119(int i, int j, int k, int l, int i1, int j1, int k1)
    {
        int l1 = Class1.anIntArray53[i1] + anInt950;
        int i2 = Class1.anIntArray58[i1];
        aClass6_Sub1_724.method247(i, j, k, l, l1, i2, 0, 0, false);
    }

    public void method120()
    {
        int i = Class1.anInt144;
        aClass4_830.method139(super.mouseX, super.mouseY, super.anInt36, super.anInt35);
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
            super.packets.packetID(16);
            super.packets.variables348(anInt878);
            super.packets.variables348(anInt871);
            super.packets.variables348(anInt872);
            super.packets.variables348(anInt873);
            super.packets.variables348(anInt874);
            super.packets.variables348(anInt875);
            super.packets.variables348(anInt876);
            super.packets.variables348(anInt877);
            super.packets.sendpacket();
            aClass6_Sub1_724.method212();
            aBoolean992 = false;
        }
    }

    public void BigLoad()
    {
        int k1 = Class1.anInt144;
        byte abyte0[] = UnPack("media" + Class18.anInt576 + ".jag", "2d graphics", 20);
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

    public byte[] UnPack(String s, String s1, int i)
    {
        if(!aBoolean979)
            s = "./Data/" + s;
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
            return super.UnPack(s, s1, i);
        }
    }

    public Socket SocketJunk(String s, int i)
        throws IOException
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
        //if(method7())
        //    socket1 = new Socket(InetAddress.getByName(getCodeBase().getHost()), i);
        //else
            socket1 = new Socket(InetAddress.getByName(s), i);
        //socket1.setSoTimeout(30000);
        socket1.setTcpNoDelay(true);
        return socket1;
    }

    public void MemJunk()
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
            {
                super.anInt12 = 0;
                EnterInfo();
            }
            if(anInt947 == 1)
            {
                super.anInt12++;
                ConnectionStuff();
            }
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

    public void RunMoveable(Runnable runnable)
    {
        if(Class8.anApplet370 != null)
        {
            Class8.method267(runnable);
            return;
        } else
        {
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            thread.start();
            return;
        }
    }

    public void method23()
    {
        anInt749 = 0;
        if(anInt746 != 0)
        {
            method39();
            return;
        } else
        {
            super.method23();
            return;
        }
    }

    public void method3()
    {
        method22();
        loggedout = true;
        method85();
        if(anInputStream_Sub1_901 != null)
            anInputStream_Sub1_901.method122();
    }

    public void method36(String s, String s1)
    {
        if(anInt690 == 1)
            aClass4_667.method169(anInt732, s + " " + s1);
        if(anInt690 == 2)
            aClass4_751.method169(anInt864, s + " " + s1);
        aString862 = s1;
        method70();
        method9();
    }

    public void method38()
    {
        int l1 = Class1.anInt144;
        anInt749 = 0;
        setmode(1);
        anInt746 = 0;
        anInt690 = 0;
        anInt947 = 1;
        SuperReset();
        aClass6_Sub1_724.method212();
        aClass6_Sub1_724.method211(aGraphics857, 0, 0);
        for(int i = 0; i < objCount; i++)
        {
            aClass10_739.method270(aClass5Array814[i]);
            aClass19_883.method434(objXArray[i], objYArray[i], objID[i]);
        }

        for(int j = 0; j < anInt855; j++)
        {
            aClass10_739.method270(aClass5Array781[j]);
            aClass19_883.method427(anIntArray747[j], anIntArray748[j], anIntArray740[j], anIntArray741[j]);
        }

        objCount = 0;
        anInt855 = 0;
        itemCount = 0;
        PlayerCount = 0;
        for(int k = 0; k < 4000; k++)
            aClass2Array891[k] = null;

        for(int l = 0; l < 500; l++)
            PlayerArray[l] = null;

        npccount = 0;
        for(int i1 = 0; i1 < 5000; i1++)
            aClass2Array957[i1] = null;

        for(int j1 = 0; j1 < 500; j1++)
            NPCArray[j1] = null;

        for(int k1 = 0; k1 < 50; k1++)
            aBooleanArray679[k1] = false;

        mouseClick = 0;
        super.anInt36 = 0;
        super.anInt35 = 0;
        aBoolean727 = false;
        aBoolean879 = false;
        aBoolean870 = false;
        super.anInt624 = 0;
    }

    public void method39()
    {
        anInt749 = 0;
        anInt690 = 0;
        anInt947 = 0;
        anInt746 = 0;
    }
    
    public void BigLoadError()
    {
        if(aBoolean922)
        {
            Graphics g = getGraphics();
            g.setColor(Color.black);
            g.fillRect(0, 0, 512, 356);
            g.setFont(new Font("Helvetica", 1, 16));
            g.setColor(Color.yellow);
            int i = 35;
            g.drawString("Sorry, an error has occured whilst loading WasteDBoT", 30, i);
            i += 50;
            g.setColor(Color.white);
            g.drawString("Try the following:", 30, i);
            i += 50;
            g.setColor(Color.white);
            g.setFont(new Font("Helvetica", 1, 12));
            g.drawString("1: Make sure you have unpacked data.zip to the right dir", 30, i);
            i += 30;
            g.drawString("2: Make sure you have data.zip...", 30, i);
            i += 30;
            g.drawString("3: Try using a different game-world", 30, i);
            i += 30;
            g.drawString("4: Try rebooting your computer", 30, i);
            i += 30;
            g.drawString("5: Try using another java", 30, i);
            method8(1);
            return;
        }
        if(aBoolean666)
        {
            Graphics g1 = getGraphics();
            g1.setColor(Color.black);
            g1.fillRect(0, 0, 512, 356);
            g1.setFont(new Font("Helvetica", 1, 20));
            g1.setColor(Color.white);
            g1.drawString("Error - unable to load game!", 50, 50);
            g1.drawString("To play RuneScape make sure you play from", 50, 100);
            g1.drawString("http://www.runescape.com", 50, 150);
            method8(1);
            return;
        }
        if(aBoolean890)
        {
            Graphics g2 = getGraphics();
            g2.setColor(Color.black);
            g2.fillRect(0, 0, 512, 356);
            g2.setFont(new Font("Helvetica", 1, 20));
            g2.setColor(Color.white);
            g2.drawString("Error - out of memory!", 50, 50);
            g2.drawString("I suggest getting a new computer", 50, 100);
            g2.drawString("much more powerful....", 50, 150);
            g2.drawString("RuneScape needs about 48meg of spare RAM", 50, 200);
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
                aClass6_Sub1_724.aBoolean338 = true;
                GameHandle();
                return;
            }
        }
        catch(OutOfMemoryError _ex)
        {
            method85();
            aBoolean890 = true;
        }
    }

    public void LogBlock()
    {
        anInt746 = 0;
        chatText("@cya@Sorry, you can't logout at the moment", 3);
        XClient.sendPacket("LOGOUT BLOCK");
    }

    public void MainChatSYS(int i, int j, byte abyte0[])
    {
        int l44 = Class1.anInt144;
        try
        {
            if(i == 18)
            {
                anInt743 = PlayerCount;
                for(int k = 0; k < anInt743; k++)
                    aClass2Array923[k] = PlayerArray[k];

                int k7 = 8;
                myPlayerX2 = Class15.method359(abyte0, k7, 11);
                k7 += 11;
                myPlayerY2 = Class15.method359(abyte0, k7, 13);
                k7 += 13;
                int l13 = Class15.method359(abyte0, k7, 4);
                k7 += 4;
                boolean flag1 = Loading(myPlayerX2, myPlayerY2);
                myPlayerX2 -= myPlayerX1;
                myPlayerY2 -= myPlayerY1;
                int l22 = myPlayerX2 * anInt946 + 64;
                int l25 = myPlayerY2 * anInt946 + 64;
                if(flag1)
                {
                    myPlayer.anInt156 = 0;
                    myPlayer.anInt155 = 0;
                    myPlayer.posX = myPlayer.anIntArray157[0] = l22;
                    myPlayer.posY = myPlayer.anIntArray158[0] = l25;
                }
                PlayerCount = 0;
                myPlayer = method76(anInt978, l22, l25, l13);
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
                        } else
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
                    PlayerArray[PlayerCount++] = class2_3;
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
                    int i23 = (myPlayerX2 + l41) * anInt946 + 64;
                    int i26 = (myPlayerY2 + j43) * anInt946 + 64;
                    method76(l39, i23, i26, i14);
                    if(i44 == 0)
                        anIntArray815[i37++] = l39;
                }
                if(i37 > 0)
                {
                    super.packets.packetID(118);
                    super.packets.variables343(i37);
                    for(int i40 = 0; i40 < i37; i40++)
                    {
                        Class2 class2_4 = aClass2Array891[anIntArray815[i40]];
                        super.packets.variables343(class2_4.ID);
                        super.packets.variables343(class2_4.anInt148);
                    }

                    super.packets.sendpacket();
                    i37 = 0;
                }
                return;
            }
            if(i == 181)
            {
                for(int l = 1; l < j;)
                    if(Class15.method353(abyte0[l]) == 255)
                    {
                        int l7 = 0;
                        int j14 = myPlayerX2 + abyte0[l + 1] >> 3;
                        int i19 = myPlayerY2 + abyte0[l + 2] >> 3;
                        l += 3;
                        for(int j23 = 0; j23 < itemCount; j23++)
                        {
                            int j26 = (itemXArray[j23] >> 3) - j14;
                            int j29 = (itemYArray[j23] >> 3) - i19;
                            if(j26 != 0 || j29 != 0)
                            {
                                if(j23 != l7)
                                {
                                    itemXArray[l7] = itemXArray[j23];
                                    itemYArray[l7] = itemYArray[j23];
                                    itemIDArray[l7] = itemIDArray[j23];
                                    anIntArray773[l7] = anIntArray773[j23];
                                }
                                l7++;
                            }
                        }

                        itemCount = l7;
                    } else
                    {
                        int i8 = Class15.method354(abyte0, l);
                        l += 2;
                        int k14 = myPlayerX2 + abyte0[l++];
                        int j19 = myPlayerY2 + abyte0[l++];
                        if((i8 & 0x8000) == 0)
                        {
                            itemXArray[itemCount] = k14;
                            itemYArray[itemCount] = j19;
                            itemIDArray[itemCount] = i8;
                            anIntArray773[itemCount] = 0;
                            for(int k23 = 0; k23 < objCount; k23++)
                            {
                                if(objXArray[k23] != k14 || objYArray[k23] != j19)
                                    continue;
                                anIntArray773[itemCount] = Class1.anIntArray66[objID[k23]];
                                break;
                            }

                            itemCount++;
                        } else
                        {
                            i8 &= 0x7fff;
                            int l23 = 0;
                            for(int k26 = 0; k26 < itemCount; k26++)
                                if(itemXArray[k26] != k14 || itemYArray[k26] != j19 || itemIDArray[k26] != i8)
                                {
                                    if(k26 != l23)
                                    {
                                        itemXArray[l23] = itemXArray[k26];
                                        itemYArray[l23] = itemYArray[k26];
                                        itemIDArray[l23] = itemIDArray[k26];
                                        anIntArray773[l23] = anIntArray773[k26];
                                    }
                                    l23++;
                                } else
                                {
                                    i8 = -123;
                                }

                            itemCount = l23;
                        }
                    }

                return;
            }
            if(i == 238)
            {
                for(int i1 = 1; i1 < j;)
                    if(Class15.method353(abyte0[i1]) == 255)
                    {
                        int j8 = 0;
                        int l14 = myPlayerX2 + abyte0[i1 + 1] >> 3;
                        int k19 = myPlayerY2 + abyte0[i1 + 2] >> 3;
                        i1 += 3;
                        for(int i24 = 0; i24 < objCount; i24++)
                        {
                            int l26 = (objXArray[i24] >> 3) - l14;
                            int k29 = (objYArray[i24] >> 3) - k19;
                            if(l26 != 0 || k29 != 0)
                            {
                                if(i24 != j8)
                                {
                                    aClass5Array814[j8] = aClass5Array814[i24];
                                    aClass5Array814[j8].anInt257 = j8;
                                    objXArray[j8] = objXArray[i24];
                                    objYArray[j8] = objYArray[i24];
                                    objID[j8] = objID[i24];
                                    anIntArray763[j8] = anIntArray763[i24];
                                }
                                j8++;
                            } else
                            {
                                aClass10_739.method270(aClass5Array814[i24]);
                                aClass19_883.method434(objXArray[i24], objYArray[i24], objID[i24]);
                            }
                        }

                        objCount = j8;
                    } else
                    {
                        int k8 = Class15.method354(abyte0, i1);
                        i1 += 2;
                        int i15 = myPlayerX2 + abyte0[i1++];
                        int l19 = myPlayerY2 + abyte0[i1++];
                        int j24 = 0;
                        for(int i27 = 0; i27 < objCount; i27++)
                            if(objXArray[i27] != i15 || objYArray[i27] != l19)
                            {
                                if(i27 != j24)
                                {
                                    aClass5Array814[j24] = aClass5Array814[i27];
                                    aClass5Array814[j24].anInt257 = j24;
                                    objXArray[j24] = objXArray[i27];
                                    objYArray[j24] = objYArray[i27];
                                    objID[j24] = objID[i27];
                                    anIntArray763[j24] = anIntArray763[i27];
                                }
                                j24++;
                            } else
                            {
                                aClass10_739.method270(aClass5Array814[i27]);
                                aClass19_883.method434(objXArray[i27], objYArray[i27], objID[i27]);
                            }

                        objCount = j24;
                        if(k8 != 60000)
                        {
                            int l29 = aClass19_883.method402(i15, l19);
                            int i34;
                            int j37;
                            if(l29 == 0 || l29 == 4)
                            {
                                i34 = Class1.anIntArray63[k8];
                                j37 = Class1.anIntArray64[k8];
                            } else
                            {
                                j37 = Class1.anIntArray63[k8];
                                i34 = Class1.anIntArray64[k8];
                            }
                            int j40 = ((i15 + i15 + i34) * anInt946) / 2;
                            int i42 = ((l19 + l19 + j37) * anInt946) / 2;
                            int k43 = Class1.anIntArray62[k8];
                            Class5 class5_1 = aClass5Array994[k43].method204();
                            aClass10_739.method269(class5_1);
                            class5_1.anInt257 = objCount;
                            class5_1.method189(0, l29 * 32, 0);
                            class5_1.method191(j40, -aClass19_883.method421(j40, i42), i42);
                            class5_1.method185(true, 48, 48, -50, -10, -50);
                            aClass19_883.method407(i15, l19, k8);
                            if(k8 == 74)
                                class5_1.method191(0, -480, 0);
                            objXArray[objCount] = i15;
                            objYArray[objCount] = l19;
                            objID[objCount] = k8;
                            anIntArray763[objCount] = l29;
                            aClass5Array814[objCount++] = class5_1;
                        }
                    }

                return;
            }
            if(i == 171)
            {
                int j1 = 1;
                anInt708 = abyte0[j1++] & 0xff;
                for(int l8 = 0; l8 < anInt708; l8++)
                {
                    int j15 = Class15.method354(abyte0, j1);
                    j1 += 2;
                    inventoryItemID[l8] = j15 & 0x7fff;
                    anIntArray711[l8] = j15 / 32768;
                    if(Class1.anIntArray55[j15 & 0x7fff] == 0)
                    {
                        anIntArray710[l8] = Class15.method358(abyte0, j1);
                        if(anIntArray710[l8] >= 128)
                            j1 += 4;
                        else
                            j1++;
                    } else
                    {
                        anIntArray710[l8] = 1;
                    }
                }

                return;
            }
            if(i == 139)
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
                    } else
                    if(byte6 == 1)
                    {
                        byte byte7 = abyte0[i9];
                        i9++;
                        if(class2 != null)
                        {
                            String s2 = Class16.ChatFilter(Class17.method399(abyte0, i9, byte7));
                            boolean flag3 = false;
                            for(int k40 = 0; k40 < super.anInt627; k40++)
                                if(super.aLongArray628[k40] == class2.aLong145)
                                    flag3 = true;

                            if(!flag3)
                            {
                                class2.anInt161 = 150;
                                class2.lastChatMessage = s2; // Other PLayers saying things
                                chatText("@yel@[" + class2.name + "] " + class2.lastChatMessage, 2);
                                playerChat = "PLAYERCHAT " + class2.name + ":" + s2;
                                XClient.sendPacketIG(playerChat);
                            }
                        }
                        i9 += byte7;
                    } else
                    if(byte6 == 2)
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
                            if(class2 == myPlayer)
                            {
                                CurrentStatLevelArray[3] = j34;
                                RealStatLevelArray[3] = k37;
                                aBoolean908 = false;
                                aBoolean745 = false;
                            }
                        }
                    } else
                    if(byte6 == 3)
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
                    } else
                    if(byte6 == 4)
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
                    } else
                    if(byte6 == 5)
                    {
                        if(class2 != null)
                        {
                            class2.anInt148 = Class15.method354(abyte0, i9);
                            i9 += 2;
                            class2.aLong145 = Class15.method356(abyte0, i9);
                            i9 += 8;
                            class2.name = Class15.method363(class2.aLong145);
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
                            class2.combatLevel = abyte0[i9++] & 0xff;
                            class2.anInt179 = abyte0[i9++] & 0xff;
                        } else
                        {
                            i9 += 14;
                            int j31 = Class15.method353(abyte0[i9]);
                            i9 += j31 + 1;
                        }
                    } else
                    if(byte6 == 6)
                    {
                        byte byte8 = abyte0[i9];
                        i9++;
                        if(class2 != null)
                        {
                            String s3 = Class17.method399(abyte0, i9, byte8);
                            class2.anInt161 = 150;
                            class2.lastChatMessage = s3;
                            if(class2 == myPlayer) //Stuff that People Say To NPC's
                            {
                                chatText("@yel@[" + class2.name + "] " + class2.lastChatMessage, 5);
                            	myChat = "MYCHAT " + class2.name + ":" + s3;
                            	XClient.sendPacketIG(myChat);
                            }
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
                        int l15 = myPlayerX2 + abyte0[l1 + 1] >> 3;
                        int j20 = myPlayerY2 + abyte0[l1 + 2] >> 3;
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
                            } else
                            {
                                aClass10_739.method270(aClass5Array781[k24]);
                                aClass19_883.method427(anIntArray747[k24], anIntArray748[k24], anIntArray740[k24], anIntArray741[k24]);
                            }
                        }

                        anInt855 = j9;
                    } else
                    {
                        int k9 = Class15.method354(abyte0, l1);
                        l1 += 2;
                        int i16 = myPlayerX2 + abyte0[l1++];
                        int k20 = myPlayerY2 + abyte0[l1++];
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
                            } else
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
            if(i == 152)
            {
                anInt906 = npccount;
                npccount = 0;
                for(int i2 = 0; i2 < anInt906; i2++)
                    aClass2Array822[i2] = NPCArray[i2];

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
                        } else
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
                    NPCArray[npccount++] = class2_1;
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
                    int j38 = (myPlayerX2 + i28) * anInt946 + 64;
                    int i41 = (myPlayerY2 + j32) * anInt946 + 64;
                    int k42 = Class15.method359(abyte0, l9, 10);
                    l9 += 10;
                    if(k42 >= Class1.anInt122)
                        k42 = 24;
                    method107(l24, j38, i41, l35, k42);
                }
                return;
            }
            if(i == 159)
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
                            class2_2.lastChatMessage = s4;
                            if(k32 == myPlayer.ID) //STuff that NPC's say to me
                            {
                                chatText("@yel@[" + Class1.NPCNameArray[class2_2.combatlvl] + "] " + class2_2.lastChatMessage, 5);
                            	NPCChat = "NPCCHAT " + Class1.NPCNameArray[class2_2.combatlvl] + ":" + s4;
                            	XClient.sendPacketIG(NPCChat);
                            }
                        }
                        i10 += byte9;
                    } else
                    if(j28 == 2)
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
            if(i == 55)
            {
                answerMenu = true;
                XClient.sendPacket("ANSWERMENU 1");
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
            if(i == 93)
            {
                answerMenu = false;
                XClient.sendPacket("ANSWERMENU 0");
                return;
            }
            if(i == 167)
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
            if(i == 205)
            {
                int l2 = 1;
                for(int k10 = 0; k10 < 18; k10++)
                    CurrentStatLevelArray[k10] = Class15.method353(abyte0[l2++]);

                for(int i17 = 0; i17 < 18; i17++)
                    RealStatLevelArray[i17] = Class15.method353(abyte0[l2++]);

                for(int k21 = 0; k21 < 18; k21++)
                {
                    CurrentXPArray[k21] = Class15.method355(abyte0, l2);
                    l2 += 4;
                }

                anInt996 = Class15.method353(abyte0[l2++]);
                return;
            }
            if(i == 79)
            {
                for(int i3 = 0; i3 < 5; i3++)
                    anIntArray797[i3] = Class15.method353(abyte0[1 + i3]);

                return;
            }
            if(i == 72)
            {
                anInt993 = 250;
                return;
            }
            if(i == 246)
            {
                int j3 = (j - 1) / 4;
                for(int l10 = 0; l10 < j3; l10++)
                {
                    int j17 = myPlayerX2 + Class15.method357(abyte0, 1 + l10 * 4) >> 3;
                    int l21 = myPlayerY2 + Class15.method357(abyte0, 3 + l10 * 4) >> 3;
                    int i25 = 0;
                    for(int k28 = 0; k28 < itemCount; k28++)
                    {
                        int i33 = (itemXArray[k28] >> 3) - j17;
                        int j36 = (itemYArray[k28] >> 3) - l21;
                        if(i33 != 0 || j36 != 0)
                        {
                            if(k28 != i25)
                            {
                                itemXArray[i25] = itemXArray[k28];
                                itemYArray[i25] = itemYArray[k28];
                                itemIDArray[i25] = itemIDArray[k28];
                                anIntArray773[i25] = anIntArray773[k28];
                            }
                            i25++;
                        }
                    }

                    itemCount = i25;
                    i25 = 0;
                    for(int j33 = 0; j33 < objCount; j33++)
                    {
                        int k36 = (objXArray[j33] >> 3) - j17;
                        int l38 = (objYArray[j33] >> 3) - l21;
                        if(k36 != 0 || l38 != 0)
                        {
                            if(j33 != i25)
                            {
                                aClass5Array814[i25] = aClass5Array814[j33];
                                aClass5Array814[i25].anInt257 = i25;
                                objXArray[i25] = objXArray[j33];
                                objYArray[i25] = objYArray[j33];
                                objID[i25] = objID[j33];
                                anIntArray763[i25] = anIntArray763[j33];
                            }
                            i25++;
                        } else
                        {
                            aClass10_739.method270(aClass5Array814[j33]);
                            aClass19_883.method434(objXArray[j33], objYArray[j33], objID[j33]);
                        }
                    }

                    objCount = i25;
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
                        } else
                        {
                            aClass10_739.method270(aClass5Array781[l36]);
                            aClass19_883.method427(anIntArray747[l36], anIntArray748[l36], anIntArray740[l36], anIntArray741[l36]);
                        }
                    }

                    anInt855 = i25;
                }

                return;
            }
            if(i == 237)
            {
                aBoolean992 = true;
                return;
            }
            if(i == 240)
            {
                int k3 = Class15.method354(abyte0, 1);
                if(aClass2Array891[k3] != null)
                    aString682 = aClass2Array891[k3].name;
                aBoolean856 = true;
                hasAccepted = false;
                tradeWindow2 = false;
                tradePosCount = 0;
                anInt886 = 0;
                return;
            }
            if(i == 3)
            {
                aBoolean856 = false;
                tradeWindow = false;
                return;
            }
            if(i == 245)
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

                hasAccepted = false;
                tradeWindow2 = false;
                return;
            }
            if(i == 207)
            {
                byte byte0 = abyte0[1];
                if(byte0 == 1)
                {
                    hasAccepted = true;
                    return;
                } else
                {
                    hasAccepted = false;
                    return;
                }
            }
            if(i == 153)
            {
                aBoolean727 = true;
            	XClient.sendPacket("SHOPWINDOW 1");
                int i4 = 1;
                int j11 = abyte0[i4++] & 0xff;
                byte byte4 = abyte0[i4++];
                anInt899 = abyte0[i4++] & 0xff;
                anInt900 = abyte0[i4++] & 0xff;
                for(int i22 = 0; i22 < 40; i22++)
                    shopItemID[i22] = -1;

                for(int j25 = 0; j25 < j11; j25++)
                {
                    shopItemID[j25] = Class15.method354(abyte0, i4);
                    i4 += 2;
                    shopItemCount[j25] = Class15.method354(abyte0, i4);
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
                            if(shopItemID[j39] != inventoryItemID[k33])
                                continue;
                            flag2 = true;
                            break;
                        }

                        if(inventoryItemID[k33] == 10)
                            flag2 = true;
                        if(!flag2)
                        {
                            shopItemID[l28] = inventoryItemID[k33] & 0x7fff;
                            shopItemCount[l28] = 0;
                            anIntArray738[l28] = 0;
                            l28--;
                        }
                    }

                }
                if(selectedShopItem >= 0 && selectedShopItem < 40 && shopItemID[selectedShopItem] != anInt904)
                {
                    selectedShopItem = -1;
                    anInt904 = -2;
                }
                return;
            }
            if(i == 243)
            {
                aBoolean727 = false;
                System.out.println("CloseShop()");
            	XClient.sendPacket("SHOPWINDOW 0");
                return;
            }
            if(i == 118)
            {
                byte byte1 = abyte0[1];
                if(byte1 == 1)
                {
                    tradeWindow2 = true;
                    return;
                } else
                {
                    tradeWindow2 = false;
                    return;
                }
            }
            if(i == 105)
            {
                aBoolean675 = Class15.method353(abyte0[1]) == 1;
                aBoolean767 = Class15.method353(abyte0[2]) == 1;
                aBoolean853 = Class15.method353(abyte0[3]) == 1;
                return;
            }
            if(i == 140)
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
            if(i == 164)
            {
                for(int k4 = 0; k4 < 50; k4++)
                    aBooleanArray716[k4] = abyte0[k4 + 1] == 1;

                return;
            }
            if(i == 120)
            {
                aBoolean879 = true;
            	XClient.sendPacket("BANKWINDOW 1");
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
            if(i == 226)
            {
                aBoolean879 = false;
                System.out.println("CloseBank()");
            	XClient.sendPacket("BANKWINDOW 0");
                return;
            }
            if(i == 108)
            {
                int i5 = abyte0[1] & 0xff;
                CurrentXPArray[i5] = Class15.method355(abyte0, 2);
                return;
            }
            if(i == 23)
            {
                int j5 = Class15.method354(abyte0, 1);
                if(aClass2Array891[j5] != null)
                    aString824 = aClass2Array891[j5].name;
                aBoolean917 = true;
                anInt910 = 0;
                anInt959 = 0;
                aBoolean668 = false;
                duelWindow2 = false;
                aBoolean718 = false;
                aBoolean719 = false;
                aBoolean720 = false;
                aBoolean721 = false;
                return;
            }
            if(i == 10)
            {
                aBoolean917 = false;
                duelWindow = false;
                return;
            }
            if(i == 13)
            {
                tradeWindow = true;
                tradeFinished = false;
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
            if(i == 75)
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
                duelWindow2 = false;
                return;
            }
            if(i == 119)
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
                duelWindow2 = false;
                return;
            }
            if(i == 172)
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

                } else
                {
                    anIntArray816[j12] = l17;
                    anIntArray817[j12] = j22;
                    if(j12 >= anInt936)
                        anInt936 = j12 + 1;
                }
                method72();
                return;
            }
            if(i == 242)
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
                inventoryItemID[i18] = k22 & 0x7fff;
                anIntArray711[i18] = k22 / 32768;
                anIntArray710[i18] = k12;
                if(i18 >= anInt708)
                    anInt708 = i18 + 1;
                return;
            }
            if(i == 104)
            {
                int k6 = abyte0[1] & 0xff;
                anInt708--;
                for(int l12 = k6; l12 < anInt708; l12++)
                {
                    inventoryItemID[l12] = inventoryItemID[l12 + 1];
                    anIntArray710[l12] = anIntArray710[l12 + 1];
                    anIntArray711[l12] = anIntArray711[l12 + 1];
                }

                return;
            }
            if(i == 99)
            {
                int l6 = 1;
                int i13 = abyte0[l6++] & 0xff;
                CurrentStatLevelArray[i13] = Class15.method353(abyte0[l6++]);
                RealStatLevelArray[i13] = Class15.method353(abyte0[l6++]);
                CurrentXPArray[i13] = Class15.method355(abyte0, l6);
                l6 += 4;
                return;
            }
            if(i == 210)
            {
                byte byte2 = abyte0[1];
                if(byte2 == 1)
                {
                    aBoolean668 = true;
                    return;
                } else
                {
                    aBoolean668 = false;
                    return;
                }
            }
            if(i == 235)
            {
                byte byte3 = abyte0[1];
                if(byte3 == 1)
                {
                    duelWindow2 = true;
                    return;
                } else
                {
                    duelWindow2 = false;
                    return;
                }
            }
            if(i == 255)
            {
                duelWindow = true;
                duelFinished = false;
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
            if(i == 250)
            {
                String s = new String(abyte0, 1, j - 1);
                method97(s);
                return;
            }
            if(i == 252)
            {
                if(anInt833 < 50)
                {
                    int j7 = abyte0[1] & 0xff;
                    int k13 = abyte0[2] + myPlayerX2;
                    int k18 = abyte0[3] + myPlayerY2;
                    anIntArray730[anInt833] = j7;
                    anIntArray972[anInt833] = 0;
                    anIntArray881[anInt833] = k13;
                    anIntArray934[anInt833] = k18;
                    anInt833++;
                }
                return;
            }
            if(i == 176)
            {
                if(!aBoolean849)
                {
                    anInt782 = Class15.method355(abyte0, 1);
                    anInt898 = Class15.method354(abyte0, 5);
                    anInt685 = abyte0[7] & 0xff;
                    anInt924 = Class15.method354(abyte0, 8);
                    aBoolean908 = true;
                    XClient.sendPacket("USER " + username);
                    aBoolean849 = true;
                    aString894 = null;
                }
                return;
            }
            if(i == 146)
            {
                aString681 = new String(abyte0, 1, j - 1);
                aBoolean745 = true;
                aBoolean680 = false;
                return;
            }
            if(i == 138)
            {
                aString681 = new String(abyte0, 1, j - 1);
                aBoolean745 = true;
                aBoolean680 = true;
                return;
            }
            if(i == 84)
            {
                fatigue = Class15.method354(abyte0, 1);
                return;
            }
            if(i == 51)
            {
                if(!aBoolean870)
                    anInt893 = fatigue;
                aBoolean870 = true;
                super.aString40 = "";
                super.aString41 = "";
                aClass6_Sub1_724.method226(anInt952 + 1, abyte0);
                aString846 = null;
                savePic(abyte0);
                XClient.sendPacket("SLEEPING 1");
                isSleeping = true;
                return;
            }
            if(i == 21)
            {
                anInt893 = Class15.method354(abyte0, 1);
                return;
            }
            if(i == 125)
            {
                aBoolean870 = false;
        	XClient.sendPacket("SLEEPING 0");
        	isSleeping = false;
        	asleep = false;
                return;
            }
            if(i == 127)
            {
                aString846 = "Incorrect... retry";
                return;
            }
            if(i == 113)
            {
                anInt749 = Class15.method354(abyte0, 1) * 32;
                return;
            }
        }
        catch(RuntimeException runtimeexception)
        {
            if(anInt933 < 3)
            {
                super.packets.packetID(46);
                super.packets.method347(runtimeexception.toString());
                super.packets.sendpacket();
                super.packets.packetID(46);
                super.packets.method347("p-type:" + i + " p-size:" + j);
                super.packets.sendpacket();
                super.packets.packetID(46);
                super.packets.method347("rx:" + myPlayerX2 + " ry:" + myPlayerY2 + " num3l:" + objCount);
                super.packets.sendpacket();
                String s1 = "";
                for(int l18 = 0; l18 < 80 && l18 < j; l18++)
                    s1 = s1 + abyte0[l18] + " ";

                super.packets.packetID(46);
                super.packets.method347(s1);
                super.packets.sendpacket();
                anInt933++;
            }
        }
    }

    public void chatText2(String s)
    {
        if(s.startsWith("@bor@"))
        {
            chatText(s, 4);
            return;
        }
        if(s.startsWith("@bot@"))
        {
            chatText("@dre@[@red@WasteDBoT@dre@] @whi@" + s, 5);
            return;
        }
        if(s.startsWith("@que@"))
        {
            chatText("@whi@" + s, 6);
            return;
        }
        if(s.startsWith("@pri@"))
        {
            chatText(s, 6);
            return;
        } else
        {
            chatText(s, 3);
            return;
        }
    }

    public int method44()
    {
        return Class8.anInt371;
    }

    public static void main(String as[])
    {
        mudclient mudclient1 = new mudclient();
        mudclient1.aBoolean979 = false;
        if(as.length > 0 && as[0].equals("members"))
            mudclient1.members = true;
        if(as.length > 1)
            mudclient1.Server = as[1];
        if(as.length > 2)
            mudclient1.ServerPort = Integer.parseInt(as[2]);
        mudclient1.method6(mudclient1.anInt676, mudclient1.anInt677 + 11, "WasteDBoT by Phate & Lormsby", false);
        mudclient1.anInt32 = 10;
    }

    public void method46()
    {
        int l = Class1.anInt144;
        if(mouseClick != 0)
        {
            for(int i = 0; i < anInt929; i++)
            {
                if(super.mouseX >= aClass6_Sub1_724.method263(aStringArray913[i], 1) || super.mouseY <= i * 12 || super.mouseY >= 12 + i * 12)
                    continue;
                super.packets.packetID(203);
                super.packets.variables348(i);
                super.packets.sendpacket();
                System.out.println("Answer(" + i + ")");
                break;
            }

            mouseClick = 0;
            answerMenu = false;
            XClient.sendPacket("ANSWERMENU 0");
            return;
        }
        for(int j = 0; j < anInt929; j++)
        {
            int k = 65535;
            if(super.mouseX < aClass6_Sub1_724.method263(aStringArray913[j], 1) && super.mouseY > j * 12 && super.mouseY < 12 + j * 12)
                k = 0xff0000;
            aClass6_Sub1_724.method257(aStringArray913[j], 6, 12 + j * 12, 1, k);
        }

    }

    public void AbuseMenu()
    {
        if(super.aString41.length() > 0)
        {
            String s = super.aString41.trim();
            super.aString40 = "";
            super.aString41 = "";
            if(s.length() > 0)
            {
                long l = Class15.method362(s);
                super.packets.packetID(180);
                super.packets.method342(l);
                super.packets.variables348(anInt863);
                super.packets.variables348(aBoolean810 ? 1 : 0);
                super.packets.sendpacket();
            }
            anInt986 = 0;
            return;
        }
        aClass6_Sub1_724.method216(56, 130, 400, 100, 0);
        aClass6_Sub1_724.method217(56, 130, 400, 100, 0xffffff);
        int i = 160;
        aClass6_Sub1_724.FloatText("Now type the name of the offending player, and press enter", 256, i, 1, 0xffff00);
        i += 18;
        aClass6_Sub1_724.FloatText("Name: " + super.aString40 + "*", 256, i, 4, 0xffffff);
        if(super.anInt637 > 0)
        {
            i = 207;
            if(aBoolean810)
                aClass6_Sub1_724.FloatText("Moderator option: Mute player for 48 hours: <ON>", 256, i, 1, 0xff8000);
            else
                aClass6_Sub1_724.FloatText("Moderator option: Mute player for 48 hours: <OFF>", 256, i, 1, 0xffffff);
            if(super.mouseX > 106 && super.mouseX < 406 && super.mouseY > i - 13 && super.mouseY < i + 2 && mouseClick == 1)
            {
                mouseClick = 0;
                aBoolean810 = !aBoolean810;
            }
        }
        i = 222;
        int j = 0xffffff;
        if(super.mouseX > 196 && super.mouseX < 316 && super.mouseY > i - 13 && super.mouseY < i + 2)
        {
            j = 0xffff00;
            if(mouseClick == 1)
            {
                mouseClick = 0;
                anInt986 = 0;
            }
        }
        aClass6_Sub1_724.FloatText("Click here to cancel", 256, i, 1, j);
        if(mouseClick == 1 && (super.mouseX < 56 || super.mouseX > 456 || super.mouseY < 130 || super.mouseY > 230))
        {
            mouseClick = 0;
            anInt986 = 0;
        }
    }

    public static String Currency(int i)
    {
        int k = Class1.anInt144;
        String s = String.valueOf(i);
        for(int j = s.length() - 3; j > 0; j -= 3)
            s = s.substring(0, j) + "," + s.substring(j);

        if(s.length() > 8)
            s = "@gre@" + s.substring(0, s.length() - 8) + " million @whi@(" + s + ")";
        else
        if(s.length() > 4)
            s = "@cya@" + s.substring(0, s.length() - 4) + "K @whi@(" + s + ")";
        return s;
    }

    public void CloseWindow()
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
        if(super.mouseY > i - 12 && super.mouseY <= i && super.mouseX > 106 && super.mouseX < 406)
            j = 0xff0000;
        aClass6_Sub1_724.FloatText("Click here to close window", 256, i, 1, j);
        if(mouseClick == 1)
        {
            if(j == 0xff0000)
                aBoolean745 = false;
            if((super.mouseX < 256 - c / 2 || super.mouseX > 256 + c / 2) && (super.mouseY < 167 - c1 / 2 || super.mouseY > 167 + c1 / 2))
                aBoolean745 = false;
        }
        mouseClick = 0;
    }

    public void MisUser()
    {
        anInt947 = 0;
        anInt690 = 0;
        username = "";
        password = "";
        aString861 = "Please enter a username:";
        aString862 = "*" + username + "*";
        PlayerCount = 0;
        npccount = 0;
    }

    public void DuelTradeJunk()
    {
        int i7 = Class1.anInt144;
        if(mouseClick != 0 && anInt819 == 0)
            anInt819 = 1;
        if(anInt819 > 0)
        {
            int i = super.mouseX - 22;
            int j = super.mouseY - 36;
            if(i >= 0 && j >= 0 && i < 468 && j < 262)
            {
                if(i > 216 && j > 30 && i < 462 && j < 235)
                {
                    int k = (i - 217) / 49 + ((j - 31) / 34) * 5;
                    if(k >= 0 && k < anInt708)
                    {
                        boolean flag = false;
                        int l1 = 0;
                        int k2 = inventoryItemID[k];
                        for(int k3 = 0; k3 < tradePosCount; k3++)
                            if(tradeItemID[k3] == k2)
                                if(Class1.anIntArray55[k2] == 0)
                                {
                                    for(int i4 = 0; i4 < anInt819; i4++)
                                    {
                                        if(tradeItemCount[k3] < anIntArray710[k])
                                            tradeItemCount[k3]++;
                                        flag = true;
                                    }

                                } else
                                {
                                    l1++;
                                }

                        if(inventoryCount(k2) <= l1)
                            flag = true;
                        if(Class1.anIntArray59[k2] == 1)
                        {
                            chatText("This object cannot be traded with other players", 3);
                            flag = true;
                        }
                        if(!flag && tradePosCount < 12)
                        {
                            tradeItemID[tradePosCount] = k2;
                            tradeItemCount[tradePosCount] = 1;
                            tradePosCount++;
                            flag = true;
                        }
                        if(flag)
                        {
                            super.packets.packetID(116);
                            super.packets.variables348(tradePosCount);
                            for(int j4 = 0; j4 < tradePosCount; j4++)
                            {
                                super.packets.variables343(tradeItemID[j4]);
                                super.packets.method332(tradeItemCount[j4]);
                            }

                            super.packets.sendpacket();
                            hasAccepted = false;
                            tradeWindow2 = false;
                        }
                    }
                }
                if(i > 8 && j > 30 && i < 205 && j < 133)
                {
                    int l = (i - 9) / 49 + ((j - 31) / 34) * 4;
                    if(l >= 0 && l < tradePosCount)
                    {
                        int j1 = tradeItemID[l];
                        for(int i2 = 0; i2 < anInt819; i2++)
                        {
                            if(Class1.anIntArray55[j1] == 0 && tradeItemCount[l] > 1)
                            {
                                tradeItemCount[l]--;
                                continue;
                            }
                            tradePosCount--;
                            anInt818 = 0;
                            for(int l2 = l; l2 < tradePosCount; l2++)
                            {
                                tradeItemID[l2] = tradeItemID[l2 + 1];
                                tradeItemCount[l2] = tradeItemCount[l2 + 1];
                            }

                            break;
                        }

                        super.packets.packetID(116);
                        super.packets.variables348(tradePosCount);
                        for(int i3 = 0; i3 < tradePosCount; i3++)
                        {
                            super.packets.variables343(tradeItemID[i3]);
                            super.packets.method332(tradeItemCount[i3]);
                        }

                        super.packets.sendpacket();
                        hasAccepted = false;
                        tradeWindow2 = false;
                    }
                }
                if(i >= 217 && j >= 238 && i <= 286 && j <= 259)
                {
                    tradeWindow2 = true;
                    super.packets.packetID(38);
                    System.out.println("AcceptTrade1()");
                    super.packets.sendpacket();
                }
                if(i >= 394 && j >= 238 && i < 463 && j < 259)
                {
                    aBoolean856 = false;
                    super.packets.packetID(178);
                    System.out.println("DeclineTrade()");
                    super.packets.sendpacket();
                }
            } else
            if(mouseClick != 0)
            {
                aBoolean856 = false;
                super.packets.packetID(178);
                System.out.println("DeclineTrade()");
                super.packets.sendpacket();
            }
            mouseClick = 0;
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
        if(!tradeWindow2)
            aClass6_Sub1_724.method231(byte0 + 217, byte1 + 238, anInt948 + 25);
        aClass6_Sub1_724.method231(byte0 + 394, byte1 + 238, anInt948 + 26);
        if(hasAccepted)
        {
            aClass6_Sub1_724.FloatText("Other player", byte0 + 341, byte1 + 246, 1, 0xffffff);
            aClass6_Sub1_724.FloatText("has accepted", byte0 + 341, byte1 + 256, 1, 0xffffff);
        }
        if(tradeWindow2)
        {
            aClass6_Sub1_724.FloatText("Waiting for", byte0 + 217 + 35, byte1 + 246, 1, 0xffffff);
            aClass6_Sub1_724.FloatText("other player", byte0 + 217 + 35, byte1 + 256, 1, 0xffffff);
        }
        for(int l4 = 0; l4 < anInt708; l4++)
        {
            int i5 = 217 + byte0 + (l4 % 5) * 49;
            int k5 = 31 + byte1 + (l4 / 5) * 34;
            aClass6_Sub1_724.method247(i5, k5, 48, 32, anInt950 + Class1.anIntArray53[inventoryItemID[l4]], Class1.anIntArray58[inventoryItemID[l4]], 0, 0, false);
            if(Class1.anIntArray55[inventoryItemID[l4]] == 0)
                aClass6_Sub1_724.method257(String.valueOf(anIntArray710[l4]), i5 + 1, k5 + 10, 1, 0xffff00);
        }

        for(int j5 = 0; j5 < tradePosCount; j5++)
        {
            int l5 = 9 + byte0 + (j5 % 4) * 49;
            int j6 = 31 + byte1 + (j5 / 4) * 34;
            aClass6_Sub1_724.method247(l5, j6, 48, 32, anInt950 + Class1.anIntArray53[tradeItemID[j5]], Class1.anIntArray58[tradeItemID[j5]], 0, 0, false);
            if(Class1.anIntArray55[tradeItemID[j5]] == 0)
                aClass6_Sub1_724.method257(String.valueOf(tradeItemCount[j5]), l5 + 1, j6 + 10, 1, 0xffff00);
            if(super.mouseX > l5 && super.mouseX < l5 + 48 && super.mouseY > j6 && super.mouseY < j6 + 32)
                aClass6_Sub1_724.method257(Class1.itemNameArray[tradeItemID[j5]] + ": @whi@" + Class1.aStringArray110[tradeItemID[j5]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }

        for(int i6 = 0; i6 < anInt886; i6++)
        {
            int k6 = 9 + byte0 + (i6 % 4) * 49;
            int l6 = 156 + byte1 + (i6 / 4) * 34;
            aClass6_Sub1_724.method247(k6, l6, 48, 32, anInt950 + Class1.anIntArray53[anIntArray887[i6]], Class1.anIntArray58[anIntArray887[i6]], 0, 0, false);
            if(Class1.anIntArray55[anIntArray887[i6]] == 0)
                aClass6_Sub1_724.method257(String.valueOf(anIntArray888[i6]), k6 + 1, l6 + 10, 1, 0xffff00);
            if(super.mouseX > k6 && super.mouseX < k6 + 48 && super.mouseY > l6 && super.mouseY < l6 + 32)
                aClass6_Sub1_724.method257(Class1.itemNameArray[anIntArray887[i6]] + ": @whi@" + Class1.aStringArray110[anIntArray887[i6]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }

    }

    public void MenuOptions()
    {
        int j = Class1.anInt144;
        aClass4_858 = new Class4(aClass6_Sub1_724, 50);
        int i = 40;
        if(!members)
        {
            aClass4_858.method156(256, 190 + i, "WasteDBoT 1.0 :: Java Client", 5, true);
            aClass4_858.method156(256, 207 + i, "Phate of Wasted Coders Inc", 4, true);
            aClass4_858.method156(256, 280 + i, "Choose your server from the Client", 4, true);
            aClass4_858.method157(156, 240 + i, 120, 35);
            aClass4_858.method157(356, 240 + i, 120, 35);
            aClass4_858.method156(156, 240 + i, "Information", 5, false);
            aClass4_858.method156(356, 240 + i, "Log in", 5, false);
            anInt850 = aClass4_858.method164(156, 240 + i, 120, 35);
            anInt851 = aClass4_858.method164(356, 240 + i, 120, 35);
        } else
        {
            aClass4_858.method156(256, 200 + i, "WasteDBoT", 4, true);
            aClass4_858.method156(256, 215 + i, "Lormsby & Phate", 4, true);
            aClass4_858.method157(256, 290, 180, 35);
            aClass4_858.method156(256, 290, "Login", 4, false);
            anInt851 = aClass4_858.method164(256, 250 + i, 200, 35);
        }
        aClass4_667 = new Class4(aClass6_Sub1_724, 50);
        i = 230;
        if(anInt731 == 0)
        {
            aClass4_667.method156(256, i + 8, "WasteDBoT 1.0 - Phate", 4, true);
            i += 20;
            aClass4_667.method156(256, i + 8, "This is the java client for 'WasteDBoT'", 4, true);
        }
            i += 20;
            aClass4_667.method156(256, i + 8, "You must have WasteDBoT.exe running", 4, true);
        i += 30;
        aClass4_667.method157(256, i + 17, 150, 34);
        aClass4_667.method156(256, i + 17, "Ok", 5, false);
        anInt733 = aClass4_667.method164(256, i + 17, 150, 34);
        aClass4_751 = new Class4(aClass6_Sub1_724, 50);
        i = 230;
        anInt864 = aClass4_751.method156(256, i - 10, "Please enter your username and password", 4, true);
        i += 28;
        aClass4_751.method157(140, i, 200, 40);
        aClass4_751.method156(140, i - 10, "Username:", 4, false);
        intUsername = aClass4_751.method162(140, i + 10, 200, 40, 4, 12, false, false);
        i += 47;
        aClass4_751.method157(190, i, 200, 40);
        aClass4_751.method156(190, i - 10, "Password:", 4, false);
        intPassword = aClass4_751.method162(190, i + 10, 200, 40, 4, 20, true, false);
        i -= 55;
        aClass4_751.method157(410, i, 120, 25);
        aClass4_751.method156(410, i, "Ok", 4, false);
        anInt867 = aClass4_751.method164(410, i, 120, 25);
        i += 30;
        aClass4_751.method157(410, i, 120, 25);
        aClass4_751.method156(410, i, "Cancel", 4, false);
        intCancel = aClass4_751.method164(410, i, 120, 25);
        i += 30;
        aClass4_751.method157(410, 310, 120, 25);
        aClass4_751.method156(390, 310, "World:", 4, false);
        serv = aClass4_751.method162(430, 310, 120, 25, 4, 2, false, false);
        aClass4_751.method173(intUsername);
    }

    public void SpellPray(boolean flag)
    {
        int l5 = Class1.anInt144;
        int i = ((Class6) (aClass6_Sub1_724)).anInt311 - 199;
        int j = 36;
        aClass6_Sub1_724.method231(i - 49, 3, anInt948 + 4);
        char c = '\304';
        char c1 = '\266';
        int l;
        int k = l = Class6.method223(160, 160, 160);
        if(anInt800 == 0)
            k = Class6.method223(220, 220, 220);
        else
            l = Class6.method223(220, 220, 220);
        aClass6_Sub1_724.method214(i, j, c / 2, 24, k, 128);
        aClass6_Sub1_724.method214(i + c / 2, j, c / 2, 24, l, 128);
        aClass6_Sub1_724.method214(i, j + 24, c, 90, Class6.method223(190, 190, 190), 128);
        aClass6_Sub1_724.method214(i, j + 24 + 90, c, c1 - 90 - 24, Class6.method223(100, 100, 100), 128);
        aClass6_Sub1_724.method218(i, j + 24, c, 0);
        aClass6_Sub1_724.method219(i + c / 2, j, 24, 0);
        aClass6_Sub1_724.method218(i, j + 113, c, 0);
        aClass6_Sub1_724.FloatText("Magic", i + c / 4, j + 16, 4, 0);
        aClass6_Sub1_724.FloatText("Prayers", i + c / 4 + c / 2, j + 16, 4, 0);
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

                int l4 = CurrentStatLevelArray[6];
                if(Class1.anIntArray96[i2] > l4)
                    s = "@bla@";
                aClass4_798.method167(anInt799, i1++, s + "Level " + Class1.anIntArray96[i2] + ": " + Class1.spellNameArray[i2]);
            }

            aClass4_798.method142();
            int i3 = aClass4_798.method174(anInt799);
            if(i3 != -1)
            {
                aClass6_Sub1_724.method257("Level " + Class1.anIntArray96[i3] + ": " + Class1.spellNameArray[i3], i + 2, j + 124, 1, 0xffff00);
                aClass6_Sub1_724.method257(Class1.aStringArray119[i3], i + 2, j + 136, 0, 0xffffff);
                for(int i4 = 0; i4 < Class1.anIntArray97[i3]; i4++)
                {
                    int i5 = Class1.anIntArrayArray99[i3][i4];
                    aClass6_Sub1_724.method231(i + 2 + i4 * 44, j + 150, anInt950 + Class1.anIntArray53[i5]);
                    int j5 = inventoryCount(i5);
                    int k5 = Class1.anIntArrayArray100[i3][i4];
                    String s2 = "@red@";
                    if(method104(i5, k5))
                        s2 = "@gre@";
                    aClass6_Sub1_724.method257(s2 + j5 + "/" + k5, i + 2 + i4 * 44, j + 150, 1, 0xffffff);
                }

            } else
            {
                aClass6_Sub1_724.method257("Point at a spell for a description", i + 2, j + 124, 1, 0);
            }
        }
        if(anInt800 == 1)
        {
            aClass4_798.method165(anInt799);
            int j1 = 0;
            for(int j2 = 0; j2 < Class1.anInt95; j2++)
            {
                String s1 = "@whi@";
                if(Class1.anIntArray88[j2] > RealStatLevelArray[5])
                    s1 = "@bla@";
                if(aBooleanArray679[j2])
                    s1 = "@gre@";
                aClass4_798.method167(anInt799, j1++, s1 + "Level " + Class1.anIntArray88[j2] + ": " + Class1.aStringArray137[j2]);
            }

            aClass4_798.method142();
            int j3 = aClass4_798.method174(anInt799);
            if(j3 != -1)
            {
                aClass6_Sub1_724.FloatText("Level " + Class1.anIntArray88[j3] + ": " + Class1.aStringArray137[j3], i + c / 2, j + 130, 1, 0xffff00);
                aClass6_Sub1_724.FloatText(Class1.aStringArray138[j3], i + c / 2, j + 145, 0, 0xffffff);
                aClass6_Sub1_724.FloatText("Drain rate: " + Class1.anIntArray89[j3], i + c / 2, j + 160, 1, 0);
            } else
            {
                aClass6_Sub1_724.method257("Point at a prayer for a description", i + 2, j + 124, 1, 0);
            }
        }
        if(!flag)
            return;
        i = super.mouseX - (((Class6) (aClass6_Sub1_724)).anInt311 - 199);
        j = super.mouseY - 36;
        if(i >= 0 && j >= 0 && i < 196 && j < 182)
        {
            aClass4_798.method139(i + (((Class6) (aClass6_Sub1_724)).anInt311 - 199), j + 36, super.anInt36, super.anInt35);
            if(j <= 24 && mouseClick == 1)
                if(i < 98 && anInt800 == 1)
                {
                    anInt800 = 0;
                    aClass4_798.method166(anInt799);
                } else
                if(i > 98 && anInt800 == 0)
                {
                    anInt800 = 1;
                    aClass4_798.method166(anInt799);
                }
            if(mouseClick == 1 && anInt800 == 0)
            {
                int k1 = aClass4_798.method174(anInt799);
                if(k1 != -1)
                {
                    int k2 = CurrentStatLevelArray[6];
                    if(Class1.anIntArray96[k1] > k2)
                    {
                        chatText("Your magic ability is not high enough for this spell", 3);
                    } else
                    {
                        int k3;
                        for(k3 = 0; k3 < Class1.anIntArray97[k1]; k3++)
                        {
                            int j4 = Class1.anIntArrayArray99[k1][k3];
                            if(method104(j4, Class1.anIntArrayArray100[k1][k3]))
                                continue;
                            chatText("You don't have all the reagents you need for this spell", 3);
                            k3 = -1;
                            break;
                        }

                        if(k3 == Class1.anIntArray97[k1])
                        {
                            selectedSpell = k1;
                            selectedItem = -1;
                        }
                    }
                }
            }
            if(mouseClick == 1 && anInt800 == 1)
            {
                int l1 = aClass4_798.method174(anInt799);
                if(l1 != -1)
                {
                    int l2 = RealStatLevelArray[5];
                    if(Class1.anIntArray88[l1] > l2)
                        chatText("Your prayer ability is not high enough for this prayer", 3);
                    else
                    if(CurrentStatLevelArray[5] == 0)
                        chatText("You have run out of prayer points. Return to a church to recharge", 3);
                    else
                    if(aBooleanArray679[l1])
                    {
                        super.packets.packetID(164);
                        super.packets.variables348(l1);
                        super.packets.sendpacket();
                        aBooleanArray679[l1] = false;
                        method97("prayeroff");
                    } else
                    {
                        super.packets.packetID(17);
                        super.packets.variables348(l1);
                        super.packets.sendpacket();
                        aBooleanArray679[l1] = true;
                        method97("prayeron");
                    }
                }
            }
            mouseClick = 0;
        }
    }

    public String method54(int i)
    {
        if(Class8.anApplet370 != null)
            return Class8.method268(Class15.method361(i));
        else
            return Class15.method361(i);
    }

    public void method55(int i, int j, int k, int l, boolean flag)
    {
        if(method84(i, j, k, l, k, l, false, flag))
        {
            return;
        } else
        {
            method83(i, j, k, l, k, l, true, flag);
            return;
        }
    }

    public void ItemOptions(boolean flag)
    {
        int j2 = Class1.anInt144;
        int i = ((Class6) (aClass6_Sub1_724)).anInt311 - 248;
        aClass6_Sub1_724.method231(i, 3, anInt948 + 1);
        for(int j = 0; j < anInt707; j++)
        {
            int k = i + (j % 5) * 49;
            int i1 = 36 + (j / 5) * 34;
            if(j < anInt708 && anIntArray711[j] == 1)
                aClass6_Sub1_724.method214(k, i1, 49, 34, 0xff0000, 128);
            else
                aClass6_Sub1_724.method214(k, i1, 49, 34, Class6.method223(181, 181, 181), 128);
            if(j < anInt708)
            {
                aClass6_Sub1_724.method247(k, i1, 48, 32, anInt950 + Class1.anIntArray53[inventoryItemID[j]], Class1.anIntArray58[inventoryItemID[j]], 0, 0, false);
                if(Class1.anIntArray55[inventoryItemID[j]] == 0)
                    aClass6_Sub1_724.method257(String.valueOf(anIntArray710[j]), k + 1, i1 + 10, 1, 0xffff00);
            }
        }

        for(int l = 1; l <= 4; l++)
            aClass6_Sub1_724.method219(i + l * 49, 36, (anInt707 / 5) * 34, 0);

        for(int j1 = 1; j1 <= anInt707 / 5 - 1; j1++)
            aClass6_Sub1_724.method218(i, 36 + j1 * 34, 245, 0);

        if(!flag)
            return;
        i = super.mouseX - (((Class6) (aClass6_Sub1_724)).anInt311 - 248);
        int k1 = super.mouseY - 36;
        if(i >= 0 && k1 >= 0 && i < 248 && k1 < (anInt707 / 5) * 34)
        {
            int l1 = i / 49 + (k1 / 34) * 5;
            if(l1 < anInt708)
            {
                int i2 = inventoryItemID[l1];
                if(selectedSpell >= 0)
                {
                    if(Class1.spellType[selectedSpell] == 3)
                    {
                        optionNameArray[optionCount] = "Cast " + Class1.spellNameArray[selectedSpell] + " on";
                        optionObjectArray[optionCount] = "@lre@" + Class1.itemNameArray[i2];
                        optionIDArray[optionCount] = 600;
                        optionObjIDArray[optionCount] = l1;
                        optionObjNameArray[optionCount] = selectedSpell;
                        optionCount++;
                        return;
                    }
                } else
                {
                    if(selectedItem >= 0)
                    {
                        optionNameArray[optionCount] = "Use " + selectedItem + " with";
                        optionObjectArray[optionCount] = "@lre@" + Class1.itemNameArray[i2];
                        optionIDArray[optionCount] = 610;
                        optionObjIDArray[optionCount] = l1;
                        optionObjNameArray[optionCount] = selectedItem;
                        optionCount++;
                        return;
                    }
                    if(anIntArray711[l1] == 1)
                    {
                        optionNameArray[optionCount] = "Remove";
                        optionObjectArray[optionCount] = "@lre@" + Class1.itemNameArray[i2];
                        optionIDArray[optionCount] = 620;
                        optionObjIDArray[optionCount] = l1;
                        optionCount++;
                    } else
                    if(Class1.anIntArray57[i2] != 0)
                    {
                        if((Class1.anIntArray57[i2] & 0x18) != 0)
                            optionNameArray[optionCount] = "Wield";
                        else
                            optionNameArray[optionCount] = "Wear";
                        optionObjectArray[optionCount] = "@lre@" + Class1.itemNameArray[i2];
                        optionIDArray[optionCount] = 630;
                        optionObjIDArray[optionCount] = l1;
                        optionCount++;
                    }
                    if(!Class1.itemCommand[i2].equals(""))
                    {
                        optionNameArray[optionCount] = Class1.itemCommand[i2];
                        optionObjectArray[optionCount] = "@lre@" + Class1.itemNameArray[i2];
                        optionIDArray[optionCount] = 640;
                        optionObjIDArray[optionCount] = l1;
                        optionCount++;
                    }
                    optionNameArray[optionCount] = "Use";
                    optionObjectArray[optionCount] = "@lre@" + Class1.itemNameArray[i2];
                    optionIDArray[optionCount] = 650;
                    optionObjIDArray[optionCount] = l1;
                    optionCount++;
                    optionNameArray[optionCount] = "Drop";
                    optionObjectArray[optionCount] = "@lre@" + Class1.itemNameArray[i2];
                    optionIDArray[optionCount] = 660;
                    optionObjIDArray[optionCount] = l1;
                    optionCount++;
                    optionNameArray[optionCount] = "Examine";
                    optionObjectArray[optionCount] = "@lre@" + Class1.itemNameArray[i2];
                    optionIDArray[optionCount] = 3600;
                    optionObjIDArray[optionCount] = i2;
                    optionCount++;
                }
            }
        }
    }

    public void EnterInfo()
    {
        //Loop Start
     if(PacketStored)
      {
      	parseData2(PacketStore);
      	PacketStored = false;
      }
         //Loop End
        if(super.anInt636 > 0)
            super.anInt636--;
        if(anInt690 == 0)
        {
            aClass4_858.method139(super.mouseX, super.mouseY, super.anInt36, super.anInt35);
            if(aClass4_858.method140(anInt850))
                anInt690 = 1;
            if(aClass4_858.method140(anInt851))
            {
                anInt690 = 2;
                aClass4_751.method169(anInt864, "Please enter your username and password");
                aClass4_751.method169(intUsername, "");
                aClass4_751.method169(serv, "");
                aClass4_751.method169(intPassword, "");
                aClass4_751.method173(intUsername);
                return;
            }
        } else
        if(anInt690 == 1)
        {
            aClass4_667.method139(super.mouseX, super.mouseY, super.anInt36, super.anInt35);
            if(aClass4_667.method140(anInt733))
            {
                anInt690 = 0;
                return;
            }
        } else
        if(anInt690 == 2)
        {
            aClass4_751.method139(super.mouseX, super.mouseY, super.anInt36, super.anInt35);
            if(aClass4_751.method140(intCancel))
                anInt690 = 0;
            if(aClass4_751.method140(intUsername))
                aClass4_751.method173(intPassword);
            if(aClass4_751.method140(intPassword))
                aClass4_751.method173(serv);
            if(aClass4_751.method140(serv) || aClass4_751.method140(anInt867))
            {
                username = aClass4_751.method170(intUsername);
                password = aClass4_751.method170(intPassword);
                server = aClass4_751.method170(serv);
			if(server.equals("51") || server.equals("52") || server.equals("53") || server.equals("54") || server.equals("55") || server.equals("56"))
			{
				changeworld(Integer.parseInt(server));
				login();
			} else {
				method36("Invalid Server", "");
			}					
            }
        }
    }

    public int inventoryCount(int i)
    {
        int l = Class1.anInt144;
        int j = 0;
        for(int k = 0; k < anInt708; k++)
            if(inventoryItemID[k] == i)
                if(Class1.anIntArray55[i] == 1)
                    j++;
                else
                    j += anIntArray710[k];

        return j;
    }

    public void CharDesign()
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

    public void OptsMenu(boolean flag)
    {
        int i2 = Class1.anInt144;
        int i = ((Class6) (aClass6_Sub1_724)).anInt311 - 199;
        int j = 36;
        aClass6_Sub1_724.method231(i - 49, 3, anInt948 + 6);
        char c = '\304';
        aClass6_Sub1_724.method214(i, 36, c, 65, Class6.method223(100, 100, 100), 160);
        aClass6_Sub1_724.method214(i, 101, c, 65, Class6.method223(100, 100, 100), 160);
        aClass6_Sub1_724.method214(i, 166, c, 95, Class6.method223(100, 100, 100), 160);
        aClass6_Sub1_724.method214(i, 261, c, 40, Class6.method223(100, 100, 100), 160);
        int k = i + 3;
        int i1 = j + 15;
        aClass6_Sub1_724.method257("@yel@WasteDBoT Settings", k, i1, 1, 0);
        i1 += 15;
        int k3 = 0xffffff;
        if(super.mouseX > k && super.mouseX < k + c && super.mouseY > i1 - 12 && super.mouseY < i1 + 4)
            k3 = 0xff0000;
        if(lefty)
            aClass6_Sub1_724.method257("Left Click Attack [@gre@On@whi@]", k, i1, 1, k3);
        else
            aClass6_Sub1_724.method257("Left Click Attack [@red@Off@whi@]", k, i1, 1, k3);
        i1 += 15;
        int k4 = 0xffffff;
        if(super.mouseX > k && super.mouseX < k + c && super.mouseY > i1 - 12 && super.mouseY < i1 + 4)
            k4 = 0xff0000;
        if(FogOfWar)
            aClass6_Sub1_724.method257("Fog Of War [@gre@On@whi@]", k, i1, 1, k4);
        else
            aClass6_Sub1_724.method257("Fog Of War [@red@Off@whi@]", k, i1, 1, k4);
        i1 += 15;
        int k5 = 0xffffff;
        if(super.mouseX > k && super.mouseX < k + c && super.mouseY > i1 - 12 && super.mouseY < i1 + 4)
            k5 = 0xff0000;
        if(ShowCombat)
            aClass6_Sub1_724.method257("Fight Mode Visible [@gre@On@whi@]", k, i1, 1, k5);
        else
            aClass6_Sub1_724.method257("Fight Mode Visible [@red@Off@whi@]", k, i1, 1, k5);
        i1 += 15;
        int k6 = 0xffffff;
        if(super.mouseX > k && super.mouseX < k + c && super.mouseY > i1 - 12 && super.mouseY < i1 + 4)
            k6 = 0xff0000;
        if(HideGFX)
            aClass6_Sub1_724.method257("Hide Graphics [@gre@On@whi@]", k, i1, 1, k6);
        else
            aClass6_Sub1_724.method257("Hide Graphics [@red@Off@whi@]", k, i1, 1, k6);
        i1 += 5;
            aClass6_Sub1_724.method257("", k, i1, 0, 0xffffff);
        i1 += 15;
            aClass6_Sub1_724.method257("@yel@Commands", k, i1, 1, 0xffffff);
        i1 += 15;
        int k7 = 0xffffff;
        if(super.mouseX > k && super.mouseX < k + c && super.mouseY > i1 - 12 && super.mouseY < i1 + 4)
            k7 = 0xff0000;
            aClass6_Sub1_724.method257("Fix Map Perfect North", k, i1, 1, k7);
        i1 += 15;
        int k8 = 0xffffff;
        if(super.mouseX > k && super.mouseX < k + c && super.mouseY > i1 - 12 && super.mouseY < i1 + 4)
            k8 = 0xff0000;
            aClass6_Sub1_724.method257("Fix Privacy Settings", k, i1, 1, k8);
        i1 += 15;
        int k9 = 0xffffff;
        if(super.mouseX > k && super.mouseX < k + c && super.mouseY > i1 - 12 && super.mouseY < i1 + 4)
            k9 = 0xff0000;
            aClass6_Sub1_724.method257("Stop Current Script", k, i1, 1, k9);
        aClass6_Sub1_724.method257("", i + 3, i1, 1, 0);
        i1 += 15;
        aClass6_Sub1_724.method257("@yel@Privacy Settings", i + 3, i1, 1, 0);
        i1 += 15;
        int k10 = 0xffffff;
        if(super.mouseX > k && super.mouseX < k + c && super.mouseY > i1 - 12 && super.mouseY < i1 + 4)
            k10 = 0xff0000;
        if(super.anInt629 == 0)
            aClass6_Sub1_724.method257("Block chat messages [@red@Off@whi@]", i + 3, i1, 1, k10);
        else
            aClass6_Sub1_724.method257("Block chat messages [@gre@On@whi@]", i + 3, i1, 1, k10);
        i1 += 15;
        int k11 = 0xffffff;
        if(super.mouseX > k && super.mouseX < k + c && super.mouseY > i1 - 12 && super.mouseY < i1 + 4)
            k11 = 0xff0000;
        if(super.anInt630 == 0)
            aClass6_Sub1_724.method257("Block private messages [@red@Off@whi@]", i + 3, i1, 1, k11);
        else
            aClass6_Sub1_724.method257("Block private messages [@gre@On@whi@]", i + 3, i1, 1, k11);
        i1 += 15;
        int k12 = 0xffffff;
        if(super.mouseX > k && super.mouseX < k + c && super.mouseY > i1 - 12 && super.mouseY < i1 + 4)
            k12 = 0xff0000;
        if(super.anInt631 == 0)
            aClass6_Sub1_724.method257("Block trade requests [@red@Off@whi@]", i + 3, i1, 1, k12);
        else
            aClass6_Sub1_724.method257("Block trade requests [@gre@On@whi@]", i + 3, i1, 1, k12);
        i1 += 15;
        int k13 = 0xffffff;
        if(super.mouseX > k && super.mouseX < k + c && super.mouseY > i1 - 12 && super.mouseY < i1 + 4)
            k13 = 0xff0000;
            if(super.anInt632 == 0)
                aClass6_Sub1_724.method257("Block duel requests [@red@Off@whi@]", i + 3, i1, 1, k13);
            else
                aClass6_Sub1_724.method257("Block duel requests [@gre@On@whi@]", i + 3, i1, 1, k13);
        i1 += 15;
        i1 += 15;
        aClass6_Sub1_724.method257("Logout if not autoing", k, i1, 1, 0);
        i1 += 15;
        int k2 = 0xffffff;
        if(super.mouseX > k && super.mouseX < k + c && super.mouseY > i1 - 12 && super.mouseY < i1 + 4)
            k2 = 0xff0000;
        aClass6_Sub1_724.method257("Click here to logout", i + 3, i1, 1, k2);
        if(!flag)
            return;
        i = super.mouseX - (((Class6) (aClass6_Sub1_724)).anInt311 - 199);
        j = super.mouseY - 36;
        if(i >= 0 && j >= 0 && i < 196 && j < 265)
        {
            int l1 = ((Class6) (aClass6_Sub1_724)).anInt311 - 199;
            byte byte0 = 36;
            char c1 = '\304';
            int l = l1 + 3;
            int j1 = byte0 + 30;
            if(super.mouseX > l && super.mouseX < l + c1 && super.mouseY > j1 - 12 && super.mouseY < j1 + 4 && mouseClick == 1)
            {
                lefty = !lefty;
                if(lefty)
                {
                	chatText2("@bot@Left click attack - Enabled");
                } else
                {
                	chatText2("@bot@Left click attack - Disabled");
                }
                super.packets.packetID(66);
                super.packets.variables348(0);
                super.packets.variables348(aBoolean675 ? 1 : 0);
                super.packets.sendpacket();
            }
            j1 += 15;
            if(super.mouseX > l && super.mouseX < l + c1 && super.mouseY > j1 - 12 && super.mouseY < j1 + 4 && mouseClick == 1)
            {
                FogOfWar = !FogOfWar;
                if(FogOfWar)
                {
                	chatText2("@bot@Fog Of War - Enabled");
                } else
                {
                	chatText2("@bot@Fog Of War - Disabled");
                }
                super.packets.packetID(66);
                super.packets.variables348(2);
                super.packets.variables348(aBoolean767 ? 1 : 0);
                super.packets.sendpacket();
            }
            j1 += 15;
            if(super.mouseX > l && super.mouseX < l + c1 && super.mouseY > j1 - 12 && super.mouseY < j1 + 4 && mouseClick == 1)
            {
                ShowCombat = !ShowCombat;
                if(ShowCombat)
                {
                	chatText2("@bot@Fight Mode Visible - Enabled");
                } else
                {
                	chatText2("@bot@Fight Mode Visible - Disabled");
                }
                super.packets.packetID(66);
                super.packets.variables348(3);
                super.packets.variables348(aBoolean853 ? 1 : 0);
                super.packets.sendpacket();
            }
            j1 += 15;
            if(super.mouseX > l && super.mouseX < l + c1 && super.mouseY > j1 - 12 && super.mouseY < j1 + 4 && mouseClick == 1)
            {
                HideGFX = !HideGFX;
                if(HideGFX)
                {
                	chatText2("@bot@Hide Graphics - Enabled");
                } else
                {
                	chatText2("@bot@Hide Graphics - Disabled");
                }
            }
            j1 += 15;
            j1 += 15;
            j1 += 5;
            if(super.mouseX > l && super.mouseX < l + c1 && super.mouseY > j1 - 12 && super.mouseY < j1 + 4 && mouseClick == 1)
            {
                mapangle = 128; 
    			CameraZoom = 700;
    			xrotate = 912;
    			chatText2("@bot@Map Fixed");
    			XClient.sendPacket("CMD FIXMAP");
            }
            j1 += 15;
            if(super.mouseX > l && super.mouseX < l + c1 && super.mouseY > j1 - 12 && super.mouseY < j1 + 4 && mouseClick == 1)
            {
             chatText2("@bot@Privacy settings fixed");
             super.anInt629 = 0;
             super.anInt630 = 0;
             super.anInt631 = 0;
             super.anInt632 = 0;//FIX PRIVACY SETTINGS
            }
            j1 += 15;
            if(super.mouseX > l && super.mouseX < l + c1 && super.mouseY > j1 - 12 && super.mouseY < j1 + 4 && mouseClick == 1)
            {
    			chatText2("@bot@Stopping WasteD BoT Script");
    			XClient.sendPacket("CMD STOPSCRIPT");
            }
            boolean flag1 = false;
            j1 += 25;
            if(super.mouseX > l && super.mouseX < l + c1 && super.mouseY > j1 - 12 && super.mouseY < j1 + 4 && mouseClick == 1)
            {
                super.anInt629 = 1 - super.anInt629;
                flag1 = true;
            }
            j1 += 15;
            if(super.mouseX > l && super.mouseX < l + c1 && super.mouseY > j1 - 12 && super.mouseY < j1 + 4 && mouseClick == 1)
            {
                super.anInt630 = 1 - super.anInt630;
                flag1 = true;
            }
            j1 += 15;
            if(super.mouseX > l && super.mouseX < l + c1 && super.mouseY > j1 - 12 && super.mouseY < j1 + 4 && mouseClick == 1)
            {
                super.anInt631 = 1 - super.anInt631;
                flag1 = true;
            }
            j1 += 15;
            if(super.mouseX > l && super.mouseX < l + c1 && super.mouseY > j1 - 12 && super.mouseY < j1 + 4 && mouseClick == 1)
            {
                super.anInt632 = 1 - super.anInt632;
                flag1 = true;
            }
            j1 += 15;
            if(flag1)
                method28(super.anInt629, super.anInt630, super.anInt631, super.anInt632);
            j1 += 15;
            j1 += 15;
            if(super.mouseX > l && super.mouseX < l + c1 && super.mouseY > j1 - 12 && super.mouseY < j1 + 4 && mouseClick == 1)
            LogOutControls();
            mouseClick = 0;
        }
    }

    public void method61()
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

    public void Actions()
    {
        int l4 = Class1.anInt144;
        int i = 2203 - (myPlayerY2 + anInt807 + myPlayerY1);
        if(myPlayerX2 + anInt806 + myPlayerX1 >= 2640)
            i = -50;
        int j = -1;
        for(int k = 0; k < objCount; k++)
            aBooleanArray662[k] = false;

        for(int l = 0; l < anInt855; l++)
            aBooleanArray831[l] = false;

        int i1 = aClass10_739.method278();
        Class5 aclass5[] = aClass10_739.method280();
        int ai[] = aClass10_739.method279();
        for(int j1 = 0; j1 < i1; j1++)
        {
            if(optionCount > 200)
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
                        if(myPlayer.combatLevel > 0 && PlayerArray[i2].combatLevel > 0)
                            k3 = myPlayer.combatLevel - PlayerArray[i2].combatLevel;
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
                        s = " " + s + "(level-" + PlayerArray[i2].combatLevel + ")";
                        if(selectedSpell >= 0)
                        {
                            if(Class1.spellType[selectedSpell] == 1 || Class1.spellType[selectedSpell] == 2)
                            {
                                optionNameArray[optionCount] = "Cast " + Class1.spellNameArray[selectedSpell] + " on";
                                optionObjectArray[optionCount] = "@whi@" + PlayerArray[i2].name + "[" + i2 + "]" + s;
                                optionIDArray[optionCount] = 800;
                                optionObjXArray[optionCount] = PlayerArray[i2].posX;
                                optionObjYArray[optionCount] = PlayerArray[i2].posY;
                                optionObjIDArray[optionCount] = PlayerArray[i2].ID;
                                optionObjNameArray[optionCount] = selectedSpell;
                                optionCount++;
                            }
                        } else
                        if(selectedItem >= 0)
                        {
                            optionNameArray[optionCount] = "Use " + selectedItem + " with";
                            optionObjectArray[optionCount] = "@whi@" + PlayerArray[i2].name + "[" + i2 + "]" + s;
                            optionIDArray[optionCount] = 810;
                            optionObjXArray[optionCount] = PlayerArray[i2].posX;
                            optionObjYArray[optionCount] = PlayerArray[i2].posY;
                            optionObjIDArray[optionCount] = PlayerArray[i2].ID;
                            optionObjNameArray[optionCount] = selectedItem;
                            optionCount++;
                        } else
                        {
                            if(i > 0 && (PlayerArray[i2].posY - 64) / anInt946 + anInt807 + myPlayerY1 < 2203)
                            {
                                optionNameArray[optionCount] = "Attack";
                                optionObjectArray[optionCount] = "@whi@" + PlayerArray[i2].name + "[" + i2 + "]" + s;
                                if(!lefty)
                                {	
                                 	if(k3 >= 0 && k3 < 5)
                                 	    optionIDArray[optionCount] = 805;
                                	else
                                	    optionIDArray[optionCount] = 2805;
                                } else 
                                if(lefty)
                                {
                                	if(k3 >= 0 && k3 < 5)
                                 	    optionIDArray[optionCount] = 805;
                                	else
                                	    optionIDArray[optionCount] = 805;
                                }
                                optionObjXArray[optionCount] = PlayerArray[i2].posX;
                                optionObjYArray[optionCount] = PlayerArray[i2].posY;
                                optionObjIDArray[optionCount] = PlayerArray[i2].ID;
                                optionCount++;
                            } else
                            if(members)
                            {
                                optionNameArray[optionCount] = "Duel with";
                                optionObjectArray[optionCount] = "@whi@" + PlayerArray[i2].name + "[" + i2 + "]" + s;
                                optionObjXArray[optionCount] = PlayerArray[i2].posX;
                                optionObjYArray[optionCount] = PlayerArray[i2].posY;
                                optionIDArray[optionCount] = 2806;
                                optionObjIDArray[optionCount] = PlayerArray[i2].ID;
                                optionCount++;
                            }
                            optionNameArray[optionCount] = "Trade with";
                            optionObjectArray[optionCount] = "@whi@" + PlayerArray[i2].name + "[" + i2 + "]" + s;
                            optionIDArray[optionCount] = 2810;
                            optionObjIDArray[optionCount] = PlayerArray[i2].ID;
                            optionCount++;
                            optionNameArray[optionCount] = "Follow";
                            optionObjectArray[optionCount] = "@whi@" + PlayerArray[i2].name + "[" + i2 + "]" + s;
                            optionIDArray[optionCount] = 2820;
                            optionObjIDArray[optionCount] = PlayerArray[i2].ID;
                            optionCount++;
                            optionNameArray[optionCount] = "Select";
                            optionObjectArray[optionCount] = "@whi@" + PlayerArray[i2].name + s;
                            optionIDArray[optionCount] = 9999;
                            optionObjIDArray[optionCount] = PlayerArray[i2].ID;
                            optionCount++;
                        }
                    } else
                    if(l2 == 2)
                    {
                        if(selectedSpell >= 0)
                        {
                            if(Class1.spellType[selectedSpell] == 3)
                            {
                                optionNameArray[optionCount] = "Cast " + Class1.spellNameArray[selectedSpell] + " on";
                                optionObjectArray[optionCount] = "@lre@" + Class1.itemNameArray[itemIDArray[i2]];
                                optionIDArray[optionCount] = 200;
                                optionObjXArray[optionCount] = itemXArray[i2];
                                optionObjYArray[optionCount] = itemYArray[i2];
                                optionObjIDArray[optionCount] = itemIDArray[i2];
                                optionObjNameArray[optionCount] = selectedSpell;
                                optionCount++;
                            }
                        } else
                        if(selectedItem >= 0)
                        {
                            optionNameArray[optionCount] = "Use " + selectedItem + " with";
                            optionObjectArray[optionCount] = "@lre@" + Class1.itemNameArray[itemIDArray[i2]] + "[" + i2 + "]";
                            optionIDArray[optionCount] = 210;
                            optionObjXArray[optionCount] = itemXArray[i2];
                            optionObjYArray[optionCount] = itemYArray[i2];
                            optionObjIDArray[optionCount] = itemIDArray[i2];
                            optionObjNameArray[optionCount] = selectedItem;
                            optionCount++;
                        } else
                        {
                            optionNameArray[optionCount] = "Take";
                            optionObjectArray[optionCount] = "@lre@" + Class1.itemNameArray[itemIDArray[i2]] + "[" + i2 + "]";
                            optionIDArray[optionCount] = 220;
                            optionObjXArray[optionCount] = itemXArray[i2];
                            optionObjYArray[optionCount] = itemYArray[i2];
                            optionObjIDArray[optionCount] = itemIDArray[i2];
                            //System.out.println("Take(" + itemIDArray[i2] + "," + itemXArray[i2] + "," + itemYArray[i2] + "," + itemIDArray[i2] + ")");
                            optionCount++;
                            optionNameArray[optionCount] = "Examine";
                            optionObjectArray[optionCount] = "@lre@" + Class1.itemNameArray[itemIDArray[i2]] + "[" + i2 + "]";
                            optionIDArray[optionCount] = 3200;
                            optionObjIDArray[optionCount] = itemIDArray[i2];
                            optionCount++;
                        }
                    } else
                    if(l2 == 3)
                    {
                        String s1 = "";
                        int l3 = -1;
                        int i4 = NPCArray[i2].combatlvl;
                        if(Class1.anIntArray116[i4] > 0)
                        {
                            int j4 = (Class1.NPCAttack[i4] + Class1.NPCDefense[i4] + Class1.NPCStrength[i4] + Class1.NPCHitpoints[i4]) / 4;
                            int k4 = (RealStatLevelArray[0] + RealStatLevelArray[1] + RealStatLevelArray[2] + RealStatLevelArray[3] + 27) / 4;
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
                        if(selectedSpell >= 0)
                        {
                            if(Class1.spellType[selectedSpell] == 2)
                            {
                                optionNameArray[optionCount] = "Cast " + Class1.spellNameArray[selectedSpell] + " on";
                                optionObjectArray[optionCount] = "@yel@" + Class1.NPCNameArray[NPCArray[i2].combatlvl];
                                optionIDArray[optionCount] = 700;
                                optionObjXArray[optionCount] = NPCArray[i2].posX;
                                optionObjYArray[optionCount] = NPCArray[i2].posY;
                                optionObjIDArray[optionCount] = NPCArray[i2].ID;
                                optionObjNameArray[optionCount] = selectedSpell;
                                optionCount++;
                            }
                        } else
                        if(selectedItem >= 0)
                        {
                            optionNameArray[optionCount] = "Use " + selectedItem + " with";
                            optionObjectArray[optionCount] = "@yel@" + Class1.NPCNameArray[NPCArray[i2].combatlvl];
                            optionIDArray[optionCount] = 710;
                            optionObjXArray[optionCount] = NPCArray[i2].posX;
                            optionObjYArray[optionCount] = NPCArray[i2].posY;
                            optionObjIDArray[optionCount] = NPCArray[i2].ID;
                            optionObjNameArray[optionCount] = selectedItem;
                            optionCount++;
                        } else
                        {
                            if(Class1.anIntArray116[i4] > 0)
                            {
                                optionNameArray[optionCount] = "Attack";
                                optionObjectArray[optionCount] = "@yel@" + Class1.NPCNameArray[NPCArray[i2].combatlvl] + s1 + " [" + NPCArray[i2].combatlvl + "]";
                                if(!lefty)
                                {
                                	if(l3 >= 0)
                                	    optionIDArray[optionCount] = 715;
                                	else
                                	    optionIDArray[optionCount] = 2715;
                                } else
                                if(lefty)
                                {
                                	if(l3 >= 0)
                                	    optionIDArray[optionCount] = 715;
                                	else
                                	    optionIDArray[optionCount] = 715;
                                }
                                optionObjXArray[optionCount] = NPCArray[i2].posX;
                                optionObjYArray[optionCount] = NPCArray[i2].posY;
                                optionObjIDArray[optionCount] = NPCArray[i2].ID;
                                optionCount++;
                            }
                            optionNameArray[optionCount] = "Talk-to";
                            optionObjectArray[optionCount] = "@yel@" + Class1.NPCNameArray[NPCArray[i2].combatlvl] + " [" + NPCArray[i2].combatlvl + "]";
                            optionIDArray[optionCount] = 720;
                            optionObjXArray[optionCount] = NPCArray[i2].posX;
                            optionObjYArray[optionCount] = NPCArray[i2].posY;
                            optionObjIDArray[optionCount] = NPCArray[i2].ID;
                            optionCount++;
                            if(!Class1.aStringArray129[i4].equals(""))
                            {
                                optionNameArray[optionCount] = Class1.aStringArray129[i4];
                                optionObjectArray[optionCount] = "@yel@" + Class1.NPCNameArray[NPCArray[i2].combatlvl];
                                optionIDArray[optionCount] = 725;
                                optionObjXArray[optionCount] = NPCArray[i2].posX;
                                optionObjYArray[optionCount] = NPCArray[i2].posY;
                                optionObjIDArray[optionCount] = NPCArray[i2].ID;
                                optionCount++;
                            }
                            optionNameArray[optionCount] = "Examine";
                            optionObjectArray[optionCount] = "@yel@" + Class1.NPCNameArray[NPCArray[i2].combatlvl] + " [" + NPCArray[i2].combatlvl + "]";
                            optionIDArray[optionCount] = 3700;
                            optionObjIDArray[optionCount] = NPCArray[i2].combatlvl;
                            optionCount++;
                            if(GETNPC = true)
                             {
                            optionNameArray[optionCount] = "Select";
                            optionObjectArray[optionCount] = "@yel@" + Class1.NPCNameArray[NPCArray[i2].combatlvl] + " [" + NPCArray[i2].combatlvl + "]";
                            optionIDArray[optionCount] = 4300;
                            optionObjIDArray[optionCount] = NPCArray[i2].combatlvl;
                            selectedNPC = NPCArray[i2].ID;
                            optionCount++;
                             }
                        }
                    }
                } else
                if(class5 != null && class5.anInt257 >= 10000)
                {
                    int j2 = class5.anInt257 - 10000;
                    int i3 = anIntArray741[j2];
                    if(!aBooleanArray831[j2])
                    {
                        if(selectedSpell >= 0)
                        {
                            if(Class1.spellType[selectedSpell] == 4)
                            {
                                optionNameArray[optionCount] = "Cast " + Class1.spellNameArray[selectedSpell] + " on";
                                optionObjectArray[optionCount] = "@cya@" + Class1.objNameArray[i3];
                                optionIDArray[optionCount] = 300;
                                optionObjXArray[optionCount] = anIntArray747[j2];
                                optionObjYArray[optionCount] = anIntArray748[j2];
                                optionObjIDArray[optionCount] = anIntArray740[j2];
                                optionObjNameArray[optionCount] = selectedSpell;
                                optionCount++;
                            }
                        } else
                        if(selectedItem >= 0)
                        {
                            optionNameArray[optionCount] = "Use " + selectedItem + " with";
                            optionObjectArray[optionCount] = "@cya@" + Class1.objNameArray[i3];
                            optionIDArray[optionCount] = 310;
                            optionObjXArray[optionCount] = anIntArray747[j2];
                            optionObjYArray[optionCount] = anIntArray748[j2];
                            optionObjIDArray[optionCount] = anIntArray740[j2];
                            optionObjNameArray[optionCount] = selectedItem;
                            optionCount++;
                        } else
                        {
                            if(!Class1.aStringArray72[i3].equalsIgnoreCase("WalkTo"))
                            {
                                optionNameArray[optionCount] = Class1.aStringArray72[i3];
                                optionObjectArray[optionCount] = "@cya@" + Class1.objNameArray[i3] + "[" + i3 + "]" + "[" + j2 + "]";
                                optionIDArray[optionCount] = 320;
                                optionObjXArray[optionCount] = anIntArray747[j2];
                                optionObjYArray[optionCount] = anIntArray748[j2];
                                optionObjIDArray[optionCount] = anIntArray740[j2];
                                optionCount++;
                            }
                            if(!Class1.objCommandName[i3].equalsIgnoreCase("Examine"))
                            {
                                optionNameArray[optionCount] = Class1.objCommandName[i3];
                                optionObjectArray[optionCount] = "@cya@" + Class1.objNameArray[i3] + "[" + i3 + "]" + "[" + j2 + "]";
                                optionIDArray[optionCount] = 2300;
                                optionObjXArray[optionCount] = anIntArray747[j2];
                                optionObjYArray[optionCount] = anIntArray748[j2];
                                optionObjIDArray[optionCount] = anIntArray740[j2];
                                optionCount++;
                            }
                            optionNameArray[optionCount] = "Examine";
                            optionObjectArray[optionCount] = "@cya@" + Class1.objNameArray[i3] + "[" + i3 + "]";
                            optionIDArray[optionCount] = 3300;
                            optionObjIDArray[optionCount] = i3;
                            optionCount++;
                        }
                        aBooleanArray831[j2] = true;
                    }
                } else
                if(class5 != null && class5.anInt257 >= 0)
                {
                    int k2 = class5.anInt257;
                    int j3 = objID[k2];
                    objid = objID[class5.anInt257];
                    if(!aBooleanArray662[k2])
                    {
                        if(selectedSpell >= 0)
                        {
                            if(Class1.spellType[selectedSpell] == 5)
                            {
                                optionNameArray[optionCount] = "Cast " + Class1.spellNameArray[selectedSpell] + " on";
                                optionObjectArray[optionCount] = "@cya@" + Class1.aStringArray91[j3] + "[" + j3 + "]" + "[" + k2 + "]";
                                optionIDArray[optionCount] = 400;
                                optionObjXArray[optionCount] = objXArray[k2];
                                optionObjYArray[optionCount] = objYArray[k2];
                                optionObjIDArray[optionCount] = anIntArray763[k2];
                                optionObjNameArray[optionCount] = objID[k2];
                                anIntArray805[optionCount] = selectedSpell;
                                optionCount++;
                            }
                        } else
                        if(selectedItem >= 0)
                        {
                            optionNameArray[optionCount] = "Use " + selectedItem + " with";
                            optionObjectArray[optionCount] = "@cya@" + Class1.aStringArray91[j3] + "[" + j3 + "]" + "[" + k2 + "]";
                            optionIDArray[optionCount] = 410;
                            optionObjXArray[optionCount] = objXArray[k2];
                            optionObjYArray[optionCount] = objYArray[k2];
                            optionObjIDArray[optionCount] = anIntArray763[k2];
                            optionObjNameArray[optionCount] = objID[k2];
                            anIntArray805[optionCount] = selectedItem;
                            optionCount++;
                        } else
                        {
                            if(!Class1.aStringArray93[j3].equalsIgnoreCase("WalkTo"))
                            {
                                optionNameArray[optionCount] = Class1.aStringArray93[j3];
                                optionObjectArray[optionCount] = "@cya@" + Class1.aStringArray91[j3] + "[" + j3 + "]" + "[" + k2 + "]";
                                optionIDArray[optionCount] = 420;
                                optionObjXArray[optionCount] = objXArray[k2];
                                optionObjYArray[optionCount] = objYArray[k2];
                                optionObjIDArray[optionCount] = anIntArray763[k2];
                                optionObjNameArray[optionCount] = objID[k2];
                                optionCount++;
                            }
                            if(!Class1.aStringArray94[j3].equalsIgnoreCase("Examine"))
                            {
                                optionNameArray[optionCount] = Class1.aStringArray94[j3];
                                optionObjectArray[optionCount] = "@cya@" + Class1.aStringArray91[j3] + "[" + j3 + "]" + "[" + k2 + "]";
                                optionIDArray[optionCount] = 2400;
                                optionObjXArray[optionCount] = objXArray[k2];
                                optionObjYArray[optionCount] = objYArray[k2];
                                optionObjIDArray[optionCount] = anIntArray763[k2];
                                optionObjNameArray[optionCount] = objID[k2];
                                optionCount++;
                            }
                            optionNameArray[optionCount] = "Examine";
                            optionObjectArray[optionCount] = "@cya@" + Class1.aStringArray91[j3] + "[" + j3 + "]" + "[" + k2 + "]";
                            optionIDArray[optionCount] = 3400;
                            optionObjIDArray[optionCount] = j3;
                            optionCount++;
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

        if(selectedSpell >= 0 && Class1.spellType[selectedSpell] <= 1)
        {
            optionNameArray[optionCount] = "Cast " + Class1.spellNameArray[selectedSpell] + " on self";
            optionObjectArray[optionCount] = "";
            optionIDArray[optionCount] = 1000;
            optionObjIDArray[optionCount] = selectedSpell;
            optionCount++;
        }
        if(j != -1)
        {
            int l1 = j;
            if(selectedSpell >= 0)
            {
                if(Class1.spellType[selectedSpell] == 6)
                {
                    optionNameArray[optionCount] = "Cast " + Class1.spellNameArray[selectedSpell] + " on ground";
                    optionObjectArray[optionCount] = "";
                    optionIDArray[optionCount] = 900;
                    optionObjXArray[optionCount] = aClass19_883.tileXArray[l1];
                    optionObjYArray[optionCount] = aClass19_883.tileYArray[l1];
                    optionObjIDArray[optionCount] = selectedSpell;
                    optionCount++;
                    return;
                }
            } else
            if(selectedItem < 0)
            {
                optionNameArray[optionCount] = "Walk here";
                optionObjectArray[optionCount] = "";
                optionIDArray[optionCount] = 920;
                optionObjXArray[optionCount] = aClass19_883.tileXArray[l1];
                optionObjYArray[optionCount] = aClass19_883.tileYArray[l1];
                chosenx = aClass19_883.tileXArray[l1];
                choseny = aClass19_883.tileYArray[l1];
                optionCount++;
            }
        }
    }

    public void WildEnter()
    {
        int i = 97;
        aClass6_Sub1_724.method216(86, 77, 340, 180, 0);
        aClass6_Sub1_724.method217(86, 77, 340, 180, 0xffffff);
        aClass6_Sub1_724.FloatText("Warning! Proceed with caution", 256, i, 4, 0xff0000);
        i += 26;
        aClass6_Sub1_724.FloatText("If you go much further north you will enter the", 256, i, 1, 0xffffff);
        i += 13;
        aClass6_Sub1_724.FloatText("wilderness. This a very dangerous area where", 256, i, 1, 0xffffff);
        i += 13;
        aClass6_Sub1_724.FloatText("other players can attack you!", 256, i, 1, 0xffffff);
        i += 22;
        aClass6_Sub1_724.FloatText("The further north you go the more dangerous it", 256, i, 1, 0xffffff);
        i += 13;
        aClass6_Sub1_724.FloatText("becomes, but the more treasure you will find.", 256, i, 1, 0xffffff);
        i += 22;
        aClass6_Sub1_724.FloatText("In the wilderness an indicator at the bottom-right", 256, i, 1, 0xffffff);
        i += 13;
        aClass6_Sub1_724.FloatText("of the screen will show the current level of danger", 256, i, 1, 0xffffff);
        i += 22;
        int j = 0xffffff;
        if(super.mouseY > i - 12 && super.mouseY <= i && super.mouseX > 181 && super.mouseX < 331)
            j = 0xff0000;
        aClass6_Sub1_724.FloatText("Click here to close window", 256, i, 1, j);
        if(mouseClick != 0)
        {
            if(super.mouseY > i - 12 && super.mouseY <= i && super.mouseX > 181 && super.mouseX < 331)
                anInt725 = 2;
            if(super.mouseX < 86 || super.mouseX > 426 || super.mouseY < 77 || super.mouseY > 257)
                anInt725 = 2;
            mouseClick = 0;
        }
    }

    public void AnimModels()
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
        if(method7())
        {
            byte abyte0[] = UnPack("models" + Class18.anInt577 + ".jag", "3d models", 60);
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

    public void CentralControls()
    {
        int i = Class1.anInt144;
        if(anInt746 != 0)
         {
            LogOutSucceess();
            XClient.sendPacket("LOGOUT MENU");
         }
        else
        //if(aBoolean908)
            //WelcomeWindow();
        //else
        if(aBoolean745)
            CloseWindow();
        else
        //if(anInt725 == 1)
        //    WildEnter();
        //else
        if(aBoolean879 && anInt869 == 0)
            method81();
        else
        if(aBoolean727 && anInt869 == 0)
            Shop();
        else
        if(tradeWindow)
            TradeFinish();
        else
        if(aBoolean856)
            DuelTradeJunk();
        else
        if(duelWindow)
            duel();
        else
        if(aBoolean917)
            DuelOpts();
        else
        if(anInt986 == 1)
            ReportAbuse();
        else
        if(anInt986 == 2)
            AbuseMenu();
        else
        if(anInt931 != 0)
        {
            ListIgnFrie();
        } else
        {
            if(answerMenu)
                method46();
            if(ShowCombat)
              CombatStyle();
            if(myPlayer.status == 8 || myPlayer.status == 9)
                CombatStyle();
            method114();
            boolean flag = !answerMenu && !aBoolean854;
            if(flag)
                optionCount = 0;
            if(toolbar == 0 && flag)
                Actions();
            if(toolbar == 1)
                ItemOptions(flag);
            if(toolbar == 2)
                method103(flag);
            if(toolbar == 3)
                StatQuest(flag);
            if(toolbar == 4)
                SpellPray(flag);
            if(toolbar == 5)
                FriendsActions(flag);
            if(toolbar == 6)
                OptsMenu(flag);
            if(!aBoolean854 && !answerMenu)
                TargetStuff();
            if(aBoolean854 && !answerMenu)
                Options();
        }
        mouseClick = 0;
    }

    public void SuperReset()
    {
        super.aString42 = "";
        super.aString43 = "";
    }

    public void WelcomeWindow()
    {
        int i1 = Class1.anInt144;
        int i = 65;
        if(anInt685 != 201)
            i += 60;
        if(anInt924 > 0)
            i += 60;
        if(anInt782 != 0)
            i += 45;
        int j = 167 - i / 2;
        aClass6_Sub1_724.method216(56, 167 - i / 2, 400, i, 0);
        aClass6_Sub1_724.method217(56, 167 - i / 2, 400, i, 0xffffff);
        j += 20;
        aClass6_Sub1_724.FloatText("Welcome to @gre@WasteDBoT @whi@" + username, 256, j, 4, 0xffff00);
        j += 30;
        String s;
        if(anInt898 == 0)
            s = "earlier today";
        else
        if(anInt898 == 1)
            s = "yesterday";
        else
            s = anInt898 + " days ago";
        if(anInt782 != 0)
        {
            aClass6_Sub1_724.FloatText("You last logged in " + s, 256, j, 1, 0xffffff);
            j += 15;
            if(aString894 == null)
                aString894 = method54(anInt782);
            aClass6_Sub1_724.FloatText("from: " + aString894, 256, j, 1, 0xffffff);
            j += 15;
            j += 15;
        }
        if(anInt924 > 0)
        {
            int k = 0xffffff;
            aClass6_Sub1_724.FloatText("Jagex staff will NEVER email you. We use the", 256, j, 1, k);
            j += 15;
            aClass6_Sub1_724.FloatText("message-centre on this website instead.", 256, j, 1, k);
            j += 15;
            if(anInt924 == 1)
                aClass6_Sub1_724.FloatText("You have @yel@0@whi@ unread messages in your message-centre", 256, j, 1, 0xffffff);
            else
                aClass6_Sub1_724.FloatText("You have @gre@" + (anInt924 - 1) + " unread messages @whi@in your message-centre", 256, j, 1, 0xffffff);
            j += 15;
            j += 15;
        }
        if(anInt685 != 201)
        {
            if(anInt685 == 200)
            {
                aClass6_Sub1_724.FloatText("You have not yet set any password recovery questions.", 256, j, 1, 0xff8000);
                j += 15;
                aClass6_Sub1_724.FloatText("We strongly recommend you do so now to secure your account.", 256, j, 1, 0xff8000);
                j += 15;
                aClass6_Sub1_724.FloatText("Do this from the 'account management' area on our front webpage", 256, j, 1, 0xff8000);
                j += 15;
            } else
            {
                String s1;
                if(anInt685 == 0)
                    s1 = "Earlier today";
                else
                if(anInt685 == 1)
                    s1 = "Yesterday";
                else
                    s1 = anInt685 + " days ago";
                aClass6_Sub1_724.FloatText(s1 + " you changed your recovery questions", 256, j, 1, 0xff8000);
                j += 15;
                aClass6_Sub1_724.FloatText("If you do not remember making this change then cancel it immediately", 256, j, 1, 0xff8000);
                j += 15;
                aClass6_Sub1_724.FloatText("Do this from the 'account management' area on our front webpage", 256, j, 1, 0xff8000);
                j += 15;
            }
            j += 15;
        }
        int l = 0xffffff;
        if(super.mouseY > j - 12 && super.mouseY <= j && super.mouseX > 106 && super.mouseX < 406)
            l = 0xff0000;
        aClass6_Sub1_724.FloatText("Click here to close window", 256, j, 1, l);
        if(mouseClick == 1)
        {
            if(l == 0xff0000)
                aBoolean908 = false;
            if((super.mouseX < 86 || super.mouseX > 426) && (super.mouseY < 167 - i / 2 || super.mouseY > 167 + i / 2))
                aBoolean908 = false;
        }
        mouseClick = 0;
    }

    void method68(int i, int j, int k, int l, int i1, int j1, int k1)
    {
        int l5 = Class1.anInt144;
        Class2 class2 = NPCArray[i1];
        int l1 = class2.status + (mapangle + 16) / 32 & 7;
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
        int j2 = i2 * 3 + anIntArray726[(class2.anInt152 / Class1.anIntArray105[class2.combatlvl]) % 4];
        if(class2.status == 8)
        {
            i2 = 5;
            l1 = 2;
            flag = false;
            i -= (Class1.anIntArray107[class2.combatlvl] * k1) / 100;
            j2 = i2 * 3 + anIntArray939[(anInt918 / (Class1.anIntArray106[class2.combatlvl] - 1)) % 8];
        } else
        if(class2.status == 9)
        {
            i2 = 5;
            l1 = 2;
            flag = true;
            i += (Class1.anIntArray107[class2.combatlvl] * k1) / 100;
            j2 = i2 * 3 + anIntArray909[(anInt918 / Class1.anIntArray106[class2.combatlvl]) % 8];
        }
        for(int k2 = 0; k2 < 12; k2++)
        {
            int l2 = anIntArrayArray684[l1][k2];
            int k3 = Class1.anIntArrayArray90[class2.combatlvl][l2];
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
                        j5 = Class1.anIntArray130[class2.combatlvl];
                        k5 = Class1.anIntArray133[class2.combatlvl];
                    } else
                    if(j5 == 2)
                    {
                        j5 = Class1.anIntArray131[class2.combatlvl];
                        k5 = Class1.anIntArray133[class2.combatlvl];
                    } else
                    if(j5 == 3)
                    {
                        j5 = Class1.anIntArray132[class2.combatlvl];
                        k5 = Class1.anIntArray133[class2.combatlvl];
                    }
                    aClass6_Sub1_724.method247(i + i4, j + j4, i5, l, l4, j5, k5, j1, flag);
                }
            }
        }

        if(class2.anInt161 > 0)
        {
            anIntArray967[anInt820] = aClass6_Sub1_724.method263(class2.lastChatMessage, 1) / 2;
            if(anIntArray967[anInt820] > 150)
                anIntArray967[anInt820] = 150;
            anIntArray968[anInt820] = (aClass6_Sub1_724.method263(class2.lastChatMessage, 1) / 300) * aClass6_Sub1_724.method261(1);
            anIntArray965[anInt820] = i + k / 2;
            anIntArray966[anInt820] = j;
            aStringArray821[anInt820++] = class2.lastChatMessage;
        }
        if(class2.status == 8 || class2.status == 9 || class2.anInt167 != 0)
        {
            if(class2.anInt167 > 0)
            {
                int i3 = i;
                if(class2.status == 8)
                    i3 -= (20 * k1) / 100;
                else
                if(class2.status == 9)
                    i3 += (20 * k1) / 100;
                int l3 = (class2.anInt165 * 30) / class2.anInt166;
                anIntArray687[anInt766] = i3 + k / 2;
                anIntArray688[anInt766] = j;
                anIntArray689[anInt766++] = l3;
            }
            if(class2.anInt167 > 150)
            {
                int j3 = i;
                if(class2.status == 8)
                    j3 -= (10 * k1) / 100;
                else
                if(class2.status == 9)
                    j3 += (10 * k1) / 100;
                aClass6_Sub1_724.method231((j3 + k / 2) - 12, (j + l / 2) - 12, anInt948 + 12);
                aClass6_Sub1_724.FloatText(String.valueOf(class2.anInt164), (j3 + k / 2) - 1, j + l / 2 + 5, 3, 0xffffff);
            }
        }
    }

    public void ChatTypes()
    {
        aClass6_Sub1_724.method231(0, anInt677 - 4, anInt948 + 23);
        int i = Class6.method223(200, 200, 255);
        if(anInt780 == 0)
            i = Class6.method223(255, 200, 50);
        if(anInt790 % 30 > 15)
            i = Class6.method223(255, 50, 50);
        aClass6_Sub1_724.FloatText("All messages", 54, anInt677 + 6, 0, i);
        i = Class6.method223(200, 200, 255);
        if(anInt780 == 1)
            i = Class6.method223(255, 200, 50);
        if(anInt791 % 30 > 15)
            i = Class6.method223(255, 50, 50);
        aClass6_Sub1_724.FloatText("Chat history", 155, anInt677 + 6, 0, i);
        i = Class6.method223(200, 200, 255);
        if(anInt780 == 2)
            i = Class6.method223(255, 200, 50);
        if(anInt792 % 30 > 15)
            i = Class6.method223(255, 50, 50);
        aClass6_Sub1_724.FloatText("Quest History", 255, anInt677 + 6, 0, i);
        i = Class6.method223(200, 200, 255);
        if(anInt780 == 3)
            i = Class6.method223(255, 200, 50);
        if(anInt793 % 30 > 15)
            i = Class6.method223(255, 50, 50);
        aClass6_Sub1_724.FloatText("Private History", 355, anInt677 + 6, 0, i);
        aClass6_Sub1_724.FloatText("WasteD BoT", 457, anInt677 + 6, 0, 0xffffff);
    }

    public void method70()
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

    public void LogOutControls()
    {
        if(anInt947 == 0)
            return;
        if(anInt869 > 450)
        {
            chatText("@cya@You can't logout during combat!", 3);
            XClient.sendPacket("LOGOUT BLOCK");
            return;
        }
        if(anInt869 > 0)
        {
            chatText("@cya@You can't logout for 10 seconds after combat", 3);
            XClient.sendPacket("LOGOUT BLOCK");
            return;
        } else
        {
            super.packets.packetID(168);
            super.packets.sendpacket();
            anInt746 = 1000;
            return;
        }
    }
    
    public void NoBotCon()
    {
        aClass6_Sub1_724.method216(126, 137, 260, 60, 0);
        aClass6_Sub1_724.method217(126, 137, 260, 60, 0xffffff);
        aClass6_Sub1_724.FloatText("No WasteDBoT Con", 256, 173, 5, 0xffffff);
    }
    
    public void method72()
    {
        int i1 = Class1.anInt144;
        anInt889 = anInt936;
        for(int i = 0; i < anInt936; i++)
        {
            bankItemID[i] = anIntArray816[i];
            bankItemCount[i] = anIntArray817[i];
        }

        for(int j = 0; j < anInt708; j++)
        {
            if(anInt889 >= anInt916)
                break;
            int k = inventoryItemID[j];
            boolean flag = false;
            for(int l = 0; l < anInt889; l++)
            {
                if(bankItemID[l] != k)
                    continue;
                flag = true;
                break;
            }

            if(!flag)
            {
                bankItemID[anInt889] = k;
                bankItemCount[anInt889] = 0;
                anInt889++;
            }
        }

    }

    public void ConfigPile()
    {
        byte abyte0[] = UnPack("config" + Class18.anInt574 + ".jag", "Configuration", 10);
        if(abyte0 == null)
        {
            aBoolean922 = true;
            return;
        }
        Class1.method129(abyte0, members);
        byte abyte1[] = UnPack("filter" + Class18.anInt581 + ".jag", "Chat system", 15);
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

    public void method74(int i, int j, int k)
    {
        aClass6_Sub1_724.method220(i, j, k);
        aClass6_Sub1_724.method220(i - 1, j, k);
        aClass6_Sub1_724.method220(i + 1, j, k);
        aClass6_Sub1_724.method220(i, j - 1, k);
        aClass6_Sub1_724.method220(i, j + 1, k);
    }

    public void ListIgnFrie()
    {
        if(mouseClick != 0)
        {
            mouseClick = 0;
            if(anInt931 == 1 && (super.mouseX < 106 || super.mouseY < 145 || super.mouseX > 406 || super.mouseY > 215))
            {
                anInt931 = 0;
                return;
            }
            if(anInt931 == 2 && (super.mouseX < 6 || super.mouseY < 145 || super.mouseX > 506 || super.mouseY > 215))
            {
                anInt931 = 0;
                return;
            }
            if(anInt931 == 3 && (super.mouseX < 106 || super.mouseY < 145 || super.mouseX > 406 || super.mouseY > 215))
            {
                anInt931 = 0;
                return;
            }
            if(super.mouseX > 236 && super.mouseX < 276 && super.mouseY > 193 && super.mouseY < 213)
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
            aClass6_Sub1_724.FloatText("Enter name to add to friends list", 256, i, 4, 0xffffff);
            i += 20;
            aClass6_Sub1_724.FloatText(super.aString40 + "*", 256, i, 4, 0xffffff);
            if(super.aString41.length() > 0)
            {
                String s = super.aString41.trim();
                super.aString40 = "";
                super.aString41 = "";
                anInt931 = 0;
                if(s.length() > 0 && Class15.method362(s) != myPlayer.aLong145)
                    method31(s);
            }
        }
        if(anInt931 == 2)
        {
            aClass6_Sub1_724.method216(6, i, 500, 70, 0);
            aClass6_Sub1_724.method217(6, i, 500, 70, 0xffffff);
            i += 20;
            aClass6_Sub1_724.FloatText("Enter message to send to " + Class15.method363(aLong928), 256, i, 4, 0xffffff);
            i += 20;
            aClass6_Sub1_724.FloatText(super.aString42 + "*", 256, i, 4, 0xffffff);
            if(super.aString43.length() > 0)
            {
                String s1 = super.aString43;
                super.aString42 = "";
                super.aString43 = "";
                anInt931 = 0;
                int k = Class17.method400(s1);
                method33(aLong928, Class17.aByteArray569, k);
                s1 = Class17.method399(Class17.aByteArray569, 0, k);
                s1 = Class16.ChatFilter(s1);
                chatText2("@pri@@cya@You tell [@yel@ " + Class15.method363(aLong928) + "@cya@] " + s1);
                super.lastPM = "LASTPM TO " + Class15.method363(aLong928) + ":" + s1;
                XClient.sendPacketIG(super.lastPM);
            }
        }
        if(anInt931 == 3)
        {
            aClass6_Sub1_724.method216(106, i, 300, 70, 0);
            aClass6_Sub1_724.method217(106, i, 300, 70, 0xffffff);
            i += 20;
            aClass6_Sub1_724.FloatText("Enter name to add to ignore list", 256, i, 4, 0xffffff);
            i += 20;
            aClass6_Sub1_724.FloatText(super.aString40 + "*", 256, i, 4, 0xffffff);
            if(super.aString41.length() > 0)
            {
                String s2 = super.aString41.trim();
                super.aString40 = "";
                super.aString41 = "";
                anInt931 = 0;
                if(s2.length() > 0 && Class15.method362(s2) != myPlayer.aLong145)
                    method29(s2);
            }
        }
        int j = 0xffffff;
        if(super.mouseX > 236 && super.mouseX < 276 && super.mouseY > 193 && super.mouseY < 213)
            j = 0xffff00;
        aClass6_Sub1_724.FloatText("Cancel", 256, 208, 1, j);
    }

    public Class2 method76(int i, int j, int k, int l)
    {
        int k1 = Class1.anInt144;
        if(aClass2Array891[i] == null)
        {
            aClass2Array891[i] = new Class2();
            aClass2Array891[i].ID = i;
            aClass2Array891[i].anInt148 = 0;
        }
        Class2 class2 = aClass2Array891[i];
        boolean flag = false;
        for(int i1 = 0; i1 < anInt743; i1++)
        {
            if(aClass2Array923[i1].ID != i)
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
            class2.ID = i;
            class2.anInt155 = 0;
            class2.anInt156 = 0;
            class2.anIntArray157[0] = class2.posX = j;
            class2.anIntArray158[0] = class2.posY = k;
            class2.anInt154 = class2.status = l;
            class2.anInt152 = 0;
        }
        PlayerArray[PlayerCount++] = class2;
        return class2;
    }

    public void method77()
    {
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

        aClass6_Sub1_724.method231(15, 15, anInt948 + 10);
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

        aClass6_Sub1_724.method231(15, 15, anInt948 + 10);
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

        aClass6_Sub1_724.method231(15, 15, anInt948 + 10);
        aClass6_Sub1_724.method230(anInt948 + 10, 0, 0, 512, 200);
        aClass6_Sub1_724.method227(anInt948 + 10);
    }

    public void method78()
    {
        int j = Class1.anInt144;
        if((anInt940 & 1) == 1 &&FileLoad2(anInt940))
            return;
        if((anInt940 & 1) == 0 &&FileLoad2(anInt940))
        {
            if(FileLoad2(anInt940 + 1 & 7))
            {
                anInt940 = anInt940 + 1 & 7;
                return;
            }
            if(FileLoad2(anInt940 + 7 & 7))
                anInt940 = anInt940 + 7 & 7;
            return;
        }
        int ai[] = {
            1, -1, 2, -2, 3, -3, 4
        };
        for(int i = 0; i < 7; i++)
        {
            if(!FileLoad2(anInt940 + ai[i] + 8 & 7))
                continue;
            anInt940 = anInt940 + ai[i] + 8 & 7;
            break;
        }

        if((anInt940 & 1) == 0 &&FileLoad2(anInt940))
        {
            if(FileLoad2(anInt940 + 1 & 7))
            {
                anInt940 = anInt940 + 1 & 7;
                return;
            }
            if(FileLoad2(anInt940 + 7 & 7))
                anInt940 = anInt940 + 7 & 7;
            return;
        } else
        {
            return;
        }
    }

    public boolean method79(int i)
    {
        for(int j = 0; j < anInt708; j++)
            if(inventoryItemID[j] == i && anIntArray711[j] == 1)
                return true;

        return false;
    }

    public void FriendsActions(boolean flag)
    {
        int i3 = Class1.anInt144;
        int i = ((Class6) (aClass6_Sub1_724)).anInt311 - 199;
        int j = 36;
        aClass6_Sub1_724.method231(i - 49, 3, anInt948 + 5);
        char c = '\304';
        char c1 = '\266';
        int l;
        int k = l = Class6.method223(160, 160, 160);
        if(anInt927 == 0)
            k = Class6.method223(220, 220, 220);
        else
            l = Class6.method223(220, 220, 220);
        aClass6_Sub1_724.method214(i, j, c / 2, 24, k, 128);
        aClass6_Sub1_724.method214(i + c / 2, j, c / 2, 24, l, 128);
        aClass6_Sub1_724.method214(i, j + 24, c, c1 - 24, Class6.method223(220, 220, 220), 128);
        aClass6_Sub1_724.method218(i, j + 24, c, 0);
        aClass6_Sub1_724.method219(i + c / 2, j, 24, 0);
        aClass6_Sub1_724.method218(i, (j + c1) - 16, c, 0);
        aClass6_Sub1_724.FloatText("Friends", i + c / 4, j + 16, 4, 0);
        aClass6_Sub1_724.FloatText("Ignore", i + c / 4 + c / 2, j + 16, 4, 0);
        aClass4_925.method165(anInt926);
        if(anInt927 == 0)
        {
            for(int i1 = 0; i1 < super.anInt624; i1++)
            {
                String s;
                if(super.anIntArray626[i1] == 99)
                    s = "@gre@";
                else
                if(super.anIntArray626[i1] > 0)
                    s = "@yel@";
                else
                    s = "@red@";
                aClass4_925.method167(anInt926, i1, s + Class15.method363(super.aLongArray625[i1]) + "~439~@whi@Remove         WWWWWWWWWW");
            }

        }
        if(anInt927 == 1)
        {
            for(int j1 = 0; j1 < super.anInt627; j1++)
                aClass4_925.method167(anInt926, j1, "@yel@" + Class15.method363(super.aLongArray628[j1]) + "~439~@whi@Remove         WWWWWWWWWW");

        }
        aClass4_925.method142();
        if(anInt927 == 0)
        {
            int k1 = aClass4_925.method174(anInt926);
            if(k1 >= 0 && super.mouseX < 489)
            {
                if(super.mouseX > 429)
                    aClass6_Sub1_724.FloatText("Click to remove " + Class15.method363(super.aLongArray625[k1]), i + c / 2, j + 35, 1, 0xffffff);
                else
                if(super.anIntArray626[k1] == 99)
                    aClass6_Sub1_724.FloatText("Click to message " + Class15.method363(super.aLongArray625[k1]), i + c / 2, j + 35, 1, 0xffffff);
                else
                if(super.anIntArray626[k1] > 0)
                    aClass6_Sub1_724.FloatText(Class15.method363(super.aLongArray625[k1]) + " is on world " + super.anIntArray626[k1], i + c / 2, j + 35, 1, 0xffffff);
                else
                    aClass6_Sub1_724.FloatText(Class15.method363(super.aLongArray625[k1]) + " is offline", i + c / 2, j + 35, 1, 0xffffff);
            } else
            {
                aClass6_Sub1_724.FloatText("Click a name to send a message", i + c / 2, j + 35, 1, 0xffffff);
            }
            int k2;
            if(super.mouseX > i && super.mouseX < i + c && super.mouseY > (j + c1) - 16 && super.mouseY < j + c1)
                k2 = 0xffff00;
            else
                k2 = 0xffffff;
            aClass6_Sub1_724.FloatText("Click here to add a friend", i + c / 2, (j + c1) - 3, 1, k2);
        }
        if(anInt927 == 1)
        {
            int l1 = aClass4_925.method174(anInt926);
            if(l1 >= 0 && super.mouseX < 489 && super.mouseX > 429)
            {
                if(super.mouseX > 429)
                    aClass6_Sub1_724.FloatText("Click to remove " + Class15.method363(super.aLongArray628[l1]), i + c / 2, j + 35, 1, 0xffffff);
            } else
            {
                aClass6_Sub1_724.FloatText("Blocking messages from:", i + c / 2, j + 35, 1, 0xffffff);
            }
            int l2;
            if(super.mouseX > i && super.mouseX < i + c && super.mouseY > (j + c1) - 16 && super.mouseY < j + c1)
                l2 = 0xffff00;
            else
                l2 = 0xffffff;
            aClass6_Sub1_724.FloatText("Click here to add a name", i + c / 2, (j + c1) - 3, 1, l2);
        }
        if(!flag)
            return;
        i = super.mouseX - (((Class6) (aClass6_Sub1_724)).anInt311 - 199);
        j = super.mouseY - 36;
        if(i >= 0 && j >= 0 && i < 196 && j < 182)
        {
            aClass4_925.method139(i + (((Class6) (aClass6_Sub1_724)).anInt311 - 199), j + 36, super.anInt36, super.anInt35);
            if(j <= 24 && mouseClick == 1)
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
            if(mouseClick == 1 && anInt927 == 0)
            {
                int i2 = aClass4_925.method174(anInt926);
                if(i2 >= 0 && super.mouseX < 489)
                    if(super.mouseX > 429)
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
            if(mouseClick == 1 && anInt927 == 1)
            {
                int j2 = aClass4_925.method174(anInt926);
                if(j2 >= 0 && super.mouseX < 489 && super.mouseX > 429)
                    method30(super.aLongArray628[j2]);
            }
            if(j > 166 && mouseClick == 1 && anInt927 == 0)
            {
                anInt931 = 1;
                super.aString40 = "";
                super.aString41 = "";
            }
            if(j > 166 && mouseClick == 1 && anInt927 == 1)
            {
                anInt931 = 3;
                super.aString40 = "";
                super.aString41 = "";
            }
            mouseClick = 0;
        }
    }

    public void method81()
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
        if(bankSlots >= anInt889 || bankSlots < 0)
            bankSlots = -1;
        if(bankSlots != -1 && bankItemID[bankSlots] != anInt835)
        {
            bankSlots = -1;
            anInt835 = -2;
        }
        if(mouseClick != 0)
        {
            mouseClick = 0;
            int i = super.mouseX - (256 - c / 2);
            int k = super.mouseY - (170 - c1 / 2);
            if(i >= 0 && k >= 12 && i < 408 && k < 280)
            {
                int i1 = anInt812 * 48;
                for(int l1 = 0; l1 < 6; l1++)
                {
                    for(int j2 = 0; j2 < 8; j2++)
                    {
                        int l6 = 7 + j2 * 49;
                        int j7 = 28 + l1 * 34;
                        if(i > l6 && i < l6 + 49 && k > j7 && k < j7 + 34 && i1 < anInt889 && bankItemID[i1] != -1)
                        {
                            anInt835 = bankItemID[i1];
                            bankSlots = i1;
                        }
                        i1++;
                    }

                }

                i = 256 - c / 2;
                k = 170 - c1 / 2;
                int k2;
                if(bankSlots < 0)
                    k2 = -1;
                else
                    k2 = bankItemID[bankSlots];
                if(k2 != -1)
                {
                    int j1 = bankItemCount[bankSlots];
                    if(Class1.anIntArray55[k2] == 1 && j1 > 1)
                        j1 = 1;
                    if(j1 >= 1 && super.mouseX >= i + 220 && super.mouseY >= k + 238 && super.mouseX < i + 250 && super.mouseY <= k + 249)
                    {
                        super.packets.packetID(83);
                        super.packets.variables343(k2);
                        super.packets.variables343(1);
                        super.packets.sendpacket();
                        System.out.println("Withdraw(" + k2 + "," + "1)");
                    }
                    if(j1 >= 5 && super.mouseX >= i + 250 && super.mouseY >= k + 238 && super.mouseX < i + 280 && super.mouseY <= k + 249)
                    {
                        super.packets.packetID(83);
                        super.packets.variables343(k2);
                        super.packets.variables343(5);
                        super.packets.sendpacket();
                        System.out.println("Withdraw(" + k2 + "," + "5)");
                    }
                    if(j1 >= 25 && super.mouseX >= i + 280 && super.mouseY >= k + 238 && super.mouseX < i + 305 && super.mouseY <= k + 249)
                    {
                        super.packets.packetID(83);
                        super.packets.variables343(k2);
                        super.packets.variables343(25);
                        super.packets.sendpacket();
                        System.out.println("Withdraw(" + k2 + "," + "25)");
                    }
                    if(j1 >= 100 && super.mouseX >= i + 305 && super.mouseY >= k + 238 && super.mouseX < i + 335 && super.mouseY <= k + 249)
                    {
                        super.packets.packetID(83);
                        super.packets.variables343(k2);
                        super.packets.variables343(100);
                        super.packets.sendpacket();
                        System.out.println("Withdraw(" + k2 + "," + "100)");
                    }
                    if(j1 >= 500 && super.mouseX >= i + 335 && super.mouseY >= k + 238 && super.mouseX < i + 368 && super.mouseY <= k + 249)
                    {
                        super.packets.packetID(83);
                        super.packets.variables343(k2);
                        super.packets.variables343(500);
                        super.packets.sendpacket();
                        System.out.println("Withdraw(" + k2 + "," + "500)");
                    }
                    if(j1 >= 2500 && super.mouseX >= i + 370 && super.mouseY >= k + 238 && super.mouseX < i + 400 && super.mouseY <= k + 249)
                    {
                        super.packets.packetID(83);
                        super.packets.variables343(k2);
                        super.packets.variables343(2500);
                        super.packets.sendpacket();
                        System.out.println("Withdraw(" + k2 + "," + "2500)");
                    }
                    if(inventoryCount(k2) >= 1 && super.mouseX >= i + 220 && super.mouseY >= k + 263 && super.mouseX < i + 250 && super.mouseY <= k + 274)
                    {
                        super.packets.packetID(145);
                        super.packets.variables343(k2);
                        super.packets.variables343(1);
                        super.packets.sendpacket();
                        System.out.println("Deposit(" + k2 + "," + "1)");
                    }
                    if(inventoryCount(k2) >= 5 && super.mouseX >= i + 250 && super.mouseY >= k + 263 && super.mouseX < i + 280 && super.mouseY <= k + 274)
                    {
                        super.packets.packetID(145);
                        super.packets.variables343(k2);
                        super.packets.variables343(5);
                        super.packets.sendpacket();
                        System.out.println("Deposit(" + k2 + "," + "5)");
                    }
                    if(inventoryCount(k2) >= 25 && super.mouseX >= i + 280 && super.mouseY >= k + 263 && super.mouseX < i + 305 && super.mouseY <= k + 274)
                    {
                        super.packets.packetID(145);
                        super.packets.variables343(k2);
                        super.packets.variables343(25);
                        super.packets.sendpacket();
                        System.out.println("Deposit(" + k2 + "," + "25)");
                    }
                    if(inventoryCount(k2) >= 100 && super.mouseX >= i + 305 && super.mouseY >= k + 263 && super.mouseX < i + 335 && super.mouseY <= k + 274)
                    {
                        super.packets.packetID(145);
                        super.packets.variables343(k2);
                        super.packets.variables343(100);
                        super.packets.sendpacket();
                        System.out.println("Deposit(" + k2 + "," + "100)");
                    }
                    if(inventoryCount(k2) >= 500 && super.mouseX >= i + 335 && super.mouseY >= k + 263 && super.mouseX < i + 368 && super.mouseY <= k + 274)
                    {
                        super.packets.packetID(145);
                        super.packets.variables343(k2);
                        super.packets.variables343(500);
                        super.packets.sendpacket();
                        System.out.println("Deposit(" + k2 + "," + "500)");
                    }
                    if(inventoryCount(k2) >= 2500 && super.mouseX >= i + 370 && super.mouseY >= k + 263 && super.mouseX < i + 400 && super.mouseY <= k + 274)
                    {
                        super.packets.packetID(145);
                        super.packets.variables343(k2);
                        super.packets.variables343(2500);
                        super.packets.sendpacket();
                        System.out.println("Deposit(" + k2 + "," + "2500)");
                    }
                }
            } else
            if(anInt889 > 48 && i >= 50 && i <= 115 && k <= 12)
                anInt812 = 0;
            else
            if(anInt889 > 48 && i >= 115 && i <= 180 && k <= 12)
                anInt812 = 1;
            else
            if(anInt889 > 96 && i >= 180 && i <= 245 && k <= 12)
                anInt812 = 2;
            else
            if(anInt889 > 144 && i >= 245 && i <= 310 && k <= 12)
            {
                anInt812 = 3;
            } else
            {
                super.packets.packetID(50);
                super.packets.sendpacket();
                aBoolean879 = false;
                System.out.println("CloseBank()");
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
            if(super.mouseX > j + i2 && super.mouseY >= l && super.mouseX < j + i2 + 65 && super.mouseY < l + 12)
                l2 = 0xffff00;
            aClass6_Sub1_724.method257("<page 1>", j + i2, l + 10, 1, l2);
            i2 += 65;
            l2 = 0xffffff;
            if(anInt812 == 1)
                l2 = 0xff0000;
            else
            if(super.mouseX > j + i2 && super.mouseY >= l && super.mouseX < j + i2 + 65 && super.mouseY < l + 12)
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
            if(super.mouseX > j + i2 && super.mouseY >= l && super.mouseX < j + i2 + 65 && super.mouseY < l + 12)
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
            if(super.mouseX > j + i2 && super.mouseY >= l && super.mouseX < j + i2 + 65 && super.mouseY < l + 12)
                j3 = 0xffff00;
            aClass6_Sub1_724.method257("<page 4>", j + i2, l + 10, 1, j3);
            i2 += 65;
        }
        int k3 = 0xffffff;
        if(super.mouseX > j + 320 && super.mouseY >= l && super.mouseX < j + 408 && super.mouseY < l + 12)
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
                if(bankSlots == k7)
                    aClass6_Sub1_724.method214(l8, i9, 49, 34, 0xff0000, 160);
                else
                    aClass6_Sub1_724.method214(l8, i9, 49, 34, i7, 160);
                aClass6_Sub1_724.method217(l8, i9, 50, 35, 0);
                if(k7 < anInt889 && bankItemID[k7] != -1)
                {
                    aClass6_Sub1_724.method247(l8, i9, 48, 32, anInt950 + Class1.anIntArray53[bankItemID[k7]], Class1.anIntArray58[bankItemID[k7]], 0, 0, false);
                    aClass6_Sub1_724.method257(String.valueOf(bankItemCount[k7]), l8 + 1, i9 + 10, 1, 65280);
                    aClass6_Sub1_724.method254(String.valueOf(inventoryCount(bankItemID[k7])), l8 + 47, i9 + 29, 1, 65535);
                }
                k7++;
            }

        }

        aClass6_Sub1_724.method218(j + 5, l + 256, 398, 0);
        if(bankSlots == -1)
        {
            aClass6_Sub1_724.FloatText("Select an object to withdraw or deposit", j + 204, l + 248, 3, 0xffff00);
            return;
        }
        int k8;
        if(bankSlots < 0)
            k8 = -1;
        else
            k8 = bankItemID[bankSlots];
        if(k8 != -1)
        {
            int l7 = bankItemCount[bankSlots];
            if(Class1.anIntArray55[k8] == 1 && l7 > 1)
                l7 = 1;
            if(l7 > 0)
            {
                aClass6_Sub1_724.method257("Withdraw " + Class1.itemNameArray[k8], j + 2, l + 248, 1, 0xffffff);
                int l3 = 0xffffff;
                if(super.mouseX >= j + 220 && super.mouseY >= l + 238 && super.mouseX < j + 250 && super.mouseY <= l + 249)
                    l3 = 0xff0000;
                aClass6_Sub1_724.method257("One", j + 222, l + 248, 1, l3);
                if(l7 >= 5)
                {
                    int i4 = 0xffffff;
                    if(super.mouseX >= j + 250 && super.mouseY >= l + 238 && super.mouseX < j + 280 && super.mouseY <= l + 249)
                        i4 = 0xff0000;
                    aClass6_Sub1_724.method257("Five", j + 252, l + 248, 1, i4);
                }
                if(l7 >= 25)
                {
                    int j4 = 0xffffff;
                    if(super.mouseX >= j + 280 && super.mouseY >= l + 238 && super.mouseX < j + 305 && super.mouseY <= l + 249)
                        j4 = 0xff0000;
                    aClass6_Sub1_724.method257("25", j + 282, l + 248, 1, j4);
                }
                if(l7 >= 100)
                {
                    int k4 = 0xffffff;
                    if(super.mouseX >= j + 305 && super.mouseY >= l + 238 && super.mouseX < j + 335 && super.mouseY <= l + 249)
                        k4 = 0xff0000;
                    aClass6_Sub1_724.method257("100", j + 307, l + 248, 1, k4);
                }
                if(l7 >= 500)
                {
                    int l4 = 0xffffff;
                    if(super.mouseX >= j + 335 && super.mouseY >= l + 238 && super.mouseX < j + 368 && super.mouseY <= l + 249)
                        l4 = 0xff0000;
                    aClass6_Sub1_724.method257("500", j + 337, l + 248, 1, l4);
                }
                if(l7 >= 2500)
                {
                    int i5 = 0xffffff;
                    if(super.mouseX >= j + 370 && super.mouseY >= l + 238 && super.mouseX < j + 400 && super.mouseY <= l + 249)
                        i5 = 0xff0000;
                    aClass6_Sub1_724.method257("2500", j + 370, l + 248, 1, i5);
                }
            }
            if(inventoryCount(k8) > 0)
            {
                aClass6_Sub1_724.method257("Deposit " + Class1.itemNameArray[k8], j + 2, l + 273, 1, 0xffffff);
                int j5 = 0xffffff;
                if(super.mouseX >= j + 220 && super.mouseY >= l + 263 && super.mouseX < j + 250 && super.mouseY <= l + 274)
                    j5 = 0xff0000;
                aClass6_Sub1_724.method257("One", j + 222, l + 273, 1, j5);
                if(inventoryCount(k8) >= 5)
                {
                    int k5 = 0xffffff;
                    if(super.mouseX >= j + 250 && super.mouseY >= l + 263 && super.mouseX < j + 280 && super.mouseY <= l + 274)
                        k5 = 0xff0000;
                    aClass6_Sub1_724.method257("Five", j + 252, l + 273, 1, k5);
                }
                if(inventoryCount(k8) >= 25)
                {
                    int l5 = 0xffffff;
                    if(super.mouseX >= j + 280 && super.mouseY >= l + 263 && super.mouseX < j + 305 && super.mouseY <= l + 274)
                        l5 = 0xff0000;
                    aClass6_Sub1_724.method257("25", j + 282, l + 273, 1, l5);
                }
                if(inventoryCount(k8) >= 100)
                {
                    int i6 = 0xffffff;
                    if(super.mouseX >= j + 305 && super.mouseY >= l + 263 && super.mouseX < j + 335 && super.mouseY <= l + 274)
                        i6 = 0xff0000;
                    aClass6_Sub1_724.method257("100", j + 307, l + 273, 1, i6);
                }
                if(inventoryCount(k8) >= 500)
                {
                    int j6 = 0xffffff;
                    if(super.mouseX >= j + 335 && super.mouseY >= l + 263 && super.mouseX < j + 368 && super.mouseY <= l + 274)
                        j6 = 0xff0000;
                    aClass6_Sub1_724.method257("500", j + 337, l + 273, 1, j6);
                }
                if(inventoryCount(k8) >= 2500)
                {
                    int k6 = 0xffffff;
                    if(super.mouseX >= j + 370 && super.mouseY >= l + 263 && super.mouseX < j + 400 && super.mouseY <= l + 274)
                        k6 = 0xff0000;
                    aClass6_Sub1_724.method257("2500", j + 370, l + 273, 1, k6);
                }
            }
        }
    }

    public void ConnectionStuff()
    {
        int i6 = Class1.anInt144;
        if(anInt749 > 1)
            anInt749--;
        method25();
        if(anInt746 > 0)
            anInt746--;
        if(super.anInt12 > 4500 && anInt869 == 0 && anInt746 == 0)
        {
        	if(min5 == 0)
        	{
        		takeat(posX(),posY() - 1,0);
        		min5 = 1;
        		return;
        	}
        	if(min5 == 1)
        	{
        		takeat(posX(),posY() + 1,0);
        		min5 = 0;
        		return;
        	}
        }
        // The 1 minute idle was here.
        if(myPlayer.status == 8 || myPlayer.status == 9)
            anInt869 = 500;
        if(anInt869 > 0)
            anInt869--;
        if(aBoolean992)
        {
            method120();
            return;
        }
        for(int i = 0; i < PlayerCount; i++)
        {
            Class2 class2 = PlayerArray[i];
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
                if(class2.anIntArray157[l2] - class2.posX > anInt946 * 3 || class2.anIntArray158[l2] - class2.posY > anInt946 * 3 || class2.anIntArray157[l2] - class2.posX < -anInt946 * 3 || class2.anIntArray158[l2] - class2.posY < -anInt946 * 3 || j4 > 8)
                {
                    class2.posX = class2.anIntArray157[l2];
                    class2.posY = class2.anIntArray158[l2];
                } else
                {
                    if(class2.posX < class2.anIntArray157[l2])
                    {
                        class2.posX += j5;
                        class2.anInt152++;
                        i1 = 2;
                    } else
                    if(class2.posX > class2.anIntArray157[l2])
                    {
                        class2.posX -= j5;
                        class2.anInt152++;
                        i1 = 6;
                    }
                    if(class2.posX - class2.anIntArray157[l2] < j5 && class2.posX - class2.anIntArray157[l2] > -j5)
                        class2.posX = class2.anIntArray157[l2];
                    if(class2.posY < class2.anIntArray158[l2])
                    {
                        class2.posY += j5;
                        class2.anInt152++;
                        if(i1 == -1)
                            i1 = 4;
                        else
                        if(i1 == 2)
                            i1 = 3;
                        else
                            i1 = 5;
                    } else
                    if(class2.posY > class2.anIntArray158[l2])
                    {
                        class2.posY -= j5;
                        class2.anInt152++;
                        if(i1 == -1)
                            i1 = 0;
                        else
                        if(i1 == 2)
                            i1 = 1;
                        else
                            i1 = 7;
                    }
                    if(class2.posY - class2.anIntArray158[l2] < j5 && class2.posY - class2.anIntArray158[l2] > -j5)
                        class2.posY = class2.anIntArray158[l2];
                }
                if(i1 != -1)
                    class2.status = i1;
                if(class2.posX == class2.anIntArray157[l2] && class2.posY == class2.anIntArray158[l2])
                    class2.anInt155 = (l2 + 1) % 10;
            } else
            {
                class2.status = class2.anInt154;
            }
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
                    chatText("@red@You have died, don't blame me... its your own fault", 3);
                if(anInt993 == 0)
                    chatText("@red@You retain your skills, although you lose your objects", 3);
            }
        }

        for(int j = 0; j < npccount; j++)
        {
            Class2 class2_1 = NPCArray[j];
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
                if(class2_1.anIntArray157[k4] - class2_1.posX > anInt946 * 3 || class2_1.anIntArray158[k4] - class2_1.posY > anInt946 * 3 || class2_1.anIntArray157[k4] - class2_1.posX < -anInt946 * 3 || class2_1.anIntArray158[k4] - class2_1.posY < -anInt946 * 3 || k5 > 8)
                {
                    class2_1.posX = class2_1.anIntArray157[k4];
                    class2_1.posY = class2_1.anIntArray158[k4];
                } else
                {
                    if(class2_1.posX < class2_1.anIntArray157[k4])
                    {
                        class2_1.posX += l5;
                        class2_1.anInt152++;
                        i3 = 2;
                    } else
                    if(class2_1.posX > class2_1.anIntArray157[k4])
                    {
                        class2_1.posX -= l5;
                        class2_1.anInt152++;
                        i3 = 6;
                    }
                    if(class2_1.posX - class2_1.anIntArray157[k4] < l5 && class2_1.posX - class2_1.anIntArray157[k4] > -l5)
                        class2_1.posX = class2_1.anIntArray157[k4];
                    if(class2_1.posY < class2_1.anIntArray158[k4])
                    {
                        class2_1.posY += l5;
                        class2_1.anInt152++;
                        if(i3 == -1)
                            i3 = 4;
                        else
                        if(i3 == 2)
                            i3 = 3;
                        else
                            i3 = 5;
                    } else
                    if(class2_1.posY > class2_1.anIntArray158[k4])
                    {
                        class2_1.posY -= l5;
                        class2_1.anInt152++;
                        if(i3 == -1)
                            i3 = 0;
                        else
                        if(i3 == 2)
                            i3 = 1;
                        else
                            i3 = 7;
                    }
                    if(class2_1.posY - class2_1.anIntArray158[k4] < l5 && class2_1.posY - class2_1.anIntArray158[k4] > -l5)
                        class2_1.posY = class2_1.anIntArray158[k4];
                }
                if(i3 != -1)
                    class2_1.status = i3;
                if(class2_1.posX == class2_1.anIntArray157[k4] && class2_1.posY == class2_1.anIntArray158[k4])
                    class2_1.anInt155 = (k4 + 1) % 10;
            } else
            {
                class2_1.status = class2_1.anInt154;
                if(class2_1.combatlvl == 43)
                    class2_1.anInt152++;
            }
            if(class2_1.anInt161 > 0)
                class2_1.anInt161--;
            if(class2_1.anInt163 > 0)
                class2_1.anInt163--;
            if(class2_1.anInt167 > 0)
                class2_1.anInt167--;
        }

        if(toolbar != 2)
        {
            if(Class6.anInt346 > 0)
                anInt884++;
            if(Class6.anInt347 > 0)
                anInt884 = 0;
            Class6.anInt346 = 0;
            Class6.anInt347 = 0;
        }
        for(int l = 0; l < PlayerCount; l++)
        {
            Class2 class2_2 = PlayerArray[l];
            if(class2_2.anInt176 > 0)
                class2_2.anInt176--;
        }

        if(aBoolean757)
        {
            if(anInt714 - myPlayer.posX < -500 || anInt714 - myPlayer.posX > 500 || anInt715 - myPlayer.posY < -500 || anInt715 - myPlayer.posY > 500)
            {
                anInt714 = myPlayer.posX;
                anInt715 = myPlayer.posY;
            }
        } else
        {
            if(anInt714 - myPlayer.posX < -500 || anInt714 - myPlayer.posX > 500 || anInt715 - myPlayer.posY < -500 || anInt715 - myPlayer.posY > 500)
            {
                anInt714 = myPlayer.posX;
                anInt715 = myPlayer.posY;
            }
            if(anInt714 != myPlayer.posX)
                anInt714 += (myPlayer.posX - anInt714) / (16 + (CameraZoom - 500) / 15);
            if(anInt715 != myPlayer.posY)
                anInt715 += (myPlayer.posY - anInt715) / (16 + (CameraZoom - 500) / 15);
            if(aBoolean675)
            {
                int k1 = anInt940 * 32;
                int j3 = k1 - mapangle;
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
                    mapangle += ((anInt941 * j3 + 255) / 256) * byte0;
                    mapangle &= 0xff;
                } else
                {
                    anInt941 = 0;
                }
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
                    super.packets.method329();
                else
                if(super.aString41.equalsIgnoreCase("::closecon") && !aBoolean979)
                {
                    method22();
                    loggedout = true;
                } else
                {
                    super.packets.packetID(60);
                    super.packets.method347(super.aString41);
                    if(!aBoolean880)
                    {
                        super.packets.variables348(0);
                        aBoolean880 = true;
                    }
                    super.packets.sendpacket();
                    super.aString40 = "";
                    super.aString41 = "";
                    aString846 = "Please wait...";
                }
            if(super.anInt36 == 1 && super.mouseY > 275 && super.mouseY < 310 && super.mouseX > 56 && super.mouseX < 456)
            {
                super.packets.packetID(60);
                super.packets.method347("-null-");
                if(!aBoolean880)
                {
                    super.packets.variables348(0);
                    aBoolean880 = true;
                }
                super.packets.sendpacket();
                super.aString40 = "";
                super.aString41 = "";
                aString846 = "Please wait...";
            }
            super.anInt36 = 0;
            return;
        }
        if(super.mouseY > anInt677 - 4)
        {
            if(super.mouseX > 15 && super.mouseX < 96 && super.anInt36 == 1)
                anInt780 = 0;
            if(super.mouseX > 110 && super.mouseX < 194 && super.anInt36 == 1)
            {
                anInt780 = 1;
                aClass4_775.anIntArray187[anInt776] = 0xf423f;
            }
            if(super.mouseX > 215 && super.mouseX < 295 && super.anInt36 == 1)
            {
                anInt780 = 2;
                aClass4_775.anIntArray187[anInt778] = 0xf423f;
            }
            if(super.mouseX > 315 && super.mouseX < 395 && super.anInt36 == 1)
            {
                anInt780 = 3;
                aClass4_775.anIntArray187[anInt779] = 0xf423f;
            }
            if(super.mouseX > 417 && super.mouseX < 497 && super.anInt36 == 1)
            {
             chatText2("@bot@WasteDBoT Chat Clicked - Not finished (-.-)");
            }
            super.anInt36 = 0;
            super.anInt35 = 0;
        }
        aClass4_775.method139(super.mouseX, super.mouseY, super.anInt36, super.anInt35);
        if(anInt780 > 0 && super.mouseX >= 494 && super.mouseY >= anInt677 - 66)
            super.anInt36 = 0;
        if(aClass4_775.method140(anInt777))
        {
            String s = aClass4_775.method170(anInt777);
            aClass4_775.method169(anInt777, "");
            if(s.startsWith("::"))
            {
                if(s.equalsIgnoreCase("::closecon") && !aBoolean979)
                    super.packets.method329();
                else
                if(s.equalsIgnoreCase("::logout") && !aBoolean979)
                {
                    method22();
                    loggedout = true;
                }
                else
                if(s.equalsIgnoreCase("::lostcon") && !aBoolean979)
                    method23();
                else
                    method35(s.substring(2));
            } else
            {
                int k3 = Class17.method400(s);
                method34(Class17.aByteArray569, k3);
                s = Class17.method399(Class17.aByteArray569, 0, k3);
                s = Class16.ChatFilter(s);
                myPlayer.anInt161 = 150;
                myPlayer.lastChatMessage = s;
                chatText("@yel@[" + myPlayer.name + "] " + s, 2);
                myChat = "MYCHAT " + myPlayer.name + ":" + s;
                XClient.sendPacketIG(myChat);
            }
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
        } else
        {
            anInt818 = 0;
            anInt819 = 0;
        }
        if(super.anInt36 == 1)
            mouseClick = 1;
        else
        if(super.anInt36 == 2)
            mouseClick = 2;
        aClass10_739.method277(super.mouseX, super.mouseY);
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
                            if(FileLoad2(anInt940))
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
                            if(FileLoad2(anInt940))
                                break;
                            anInt940 = anInt940 + 7 & 7;
                        }

                    }
                }
            }
        } else
        if(super.aBoolean26)
            mapangle = mapangle + 2 & 0xff;
        else
        if(super.aBoolean27)
            mapangle = mapangle - 2 & 0xff;
        if((pgdowndown == true) && (pgupdown == true))
		xrotate += 3;
        if(pgdowndown == true)
		xrotate += 3;
	if(pgupdown == true)
		xrotate -= 3;
	if((arrowkeydown == true) && (arrowkeyup == true) && !super.caps)
		if(CameraZoom < 4500)
			CameraZoom += 10;
	if(arrowkeydown == true && !super.caps)
		if(CameraZoom < 4500)
			CameraZoom += 10;
	if(arrowkeyup == true && !super.caps)
		if (CameraZoom > 150)
			CameraZoom -= 10;
	if(peenor == true)
		focusx += 20;
	if(phateshouldlookherecoshehasnopeenorandwillneverseethisunlessitellhimto == true)
		focusx -= 20;
	if(arrowkeydown == true && super.caps)
		focusy += 20;
	if(arrowkeyup == true && super.caps)
		focusy -= 20;
	if(arrowkeyup == true && arrowkeydown == true && super.caps)
		focusy -= 10;
	if(peenor == true && phateshouldlookherecoshehasnopeenorandwillneverseethisunlessitellhimto == true)
		focusx -= 10;
	if(homedown == true)
		maphax += 10;
	if(enddown == true)
		maphax -= 10;
	if(homedown == true && enddown == true)
		maphax -= 5;
        if(anInt670 > 0)
            anInt670--;
        else
        if(anInt670 < 0)
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
        for(int k2 = 0; k2 < objCount; k2++)
        {
            int l3 = objXArray[k2];
            int l4 = objYArray[k2];
            if(l3 >= 0 && l4 >= 0 && l3 < 96 && l4 < 96 && objID[k2] == 74)
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

    public boolean method83(int i, int j, int k, int l, int i1, int j1, boolean flag, 
            boolean flag1)
    {
        int i2 = Class1.anInt144;
        int k1 = aClass19_883.method411(i, j, k, l, i1, j1, anIntArray962, anIntArray963, flag);
        if(k1 == -1)
            if(flag1)
            {
                k1 = 1;
                anIntArray962[0] = k;
                anIntArray963[0] = l;
            } else
            {
                return false;
            }
        k1--;
        i = anIntArray962[k1];
        j = anIntArray963[k1];
        k1--;
        if(flag1)
            super.packets.packetID(230);
        else
            super.packets.packetID(21);
        super.packets.variables343(i + myPlayerX1);
        super.packets.variables343(j + myPlayerY1);
        if(flag1 && k1 == -1 && (i + myPlayerX1) % 5 == 0)
            k1 = 0;
        for(int l1 = k1; l1 >= 0 && l1 > k1 - 25; l1--)
        {
            super.packets.variables348(anIntArray962[l1] - i);
            super.packets.variables348(anIntArray963[l1] - j);
        }

        super.packets.sendpacket();
        anInt670 = -24;
        anInt671 = super.mouseX;
        anInt672 = super.mouseY;
        return true;
    }

    public boolean method84(int i, int j, int k, int l, int i1, int j1, boolean flag, 
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
            super.packets.packetID(230);
        else
            super.packets.packetID(21);
        super.packets.variables343(i + myPlayerX1);
        super.packets.variables343(j + myPlayerY1);
        if(flag1 && k1 == -1 && (i + myPlayerX1) % 5 == 0)
            k1 = 0;
        for(int l1 = k1; l1 >= 0 && l1 > k1 - 25; l1--)
        {
            super.packets.variables348(anIntArray962[l1] - i);
            super.packets.variables348(anIntArray963[l1] - j);
        }

        super.packets.sendpacket();
        anInt670 = -24;
        anInt671 = super.mouseX;
        anInt672 = super.mouseY;
        return true;
    }

    public void method85()
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
	            PlayerArray = null;
	            aClass2Array957 = null;
	            NPCArray = null;
	            myPlayer = null;
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
	        catch(Exception _ex)
	        {
	            return;
	        }
    }

    public void UnpackFiles()
    {
        int i1 = Class1.anInt144;
        byte abyte0[] = null;
        byte abyte1[] = null;
        abyte0 = UnPack("entity" + Class18.anInt579 + ".jag", "people and monsters", 30);
        if(abyte0 == null)
        {
            aBoolean922 = true;
            return;
        }
        abyte1 = Class15.method366("index.dat", 0, abyte0);
        byte abyte2[] = null;
        byte abyte3[] = null;
        if(members)
        {
            abyte2 = UnPack("entity" + Class18.anInt579 + ".mem", "member graphics", 45);
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
            if(abyte7 == null && members)
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
                    if(abyte8 == null && members)
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
                    if(abyte9 == null && members)
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
    }

    public void DuelOpts()
    {
        int i7 = Class1.anInt144;
        if(mouseClick != 0 && anInt819 == 0)
            anInt819 = 1;
        if(anInt819 > 0)
        {
            int i = super.mouseX - 22;
            int j = super.mouseY - 36;
            if(i >= 0 && j >= 0 && i < 468 && j < 262)
            {
                if(i > 216 && j > 30 && i < 462 && j < 235)
                {
                    int k = (i - 217) / 49 + ((j - 31) / 34) * 5;
                    if(k >= 0 && k < anInt708)
                    {
                        boolean flag1 = false;
                        int l1 = 0;
                        int k2 = inventoryItemID[k];
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

                        if(inventoryCount(k2) <= l1)
                            flag1 = true;
                        if(Class1.anIntArray59[k2] == 1)
                        {
                            chatText("This object cannot be added to a duel offer", 3);
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
                            super.packets.packetID(154);
                            super.packets.variables348(anInt910);
                            for(int j4 = 0; j4 < anInt910; j4++)
                            {
                                super.packets.variables343(anIntArray911[j4]);
                                super.packets.method332(anIntArray912[j4]);
                            }

                            super.packets.sendpacket();
                            aBoolean668 = false;
                            duelWindow2 = false;
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

                        super.packets.packetID(154);
                        super.packets.variables348(anInt910);
                        for(int i3 = 0; i3 < anInt910; i3++)
                        {
                            super.packets.variables343(anIntArray911[i3]);
                            super.packets.method332(anIntArray912[i3]);
                        }

                        super.packets.sendpacket();
                        aBoolean668 = false;
                        duelWindow2 = false;
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
                    super.packets.packetID(10);
                    super.packets.variables348(aBoolean718 ? 1 : 0);
                    super.packets.variables348(aBoolean719 ? 1 : 0);
                    super.packets.variables348(aBoolean720 ? 1 : 0);
                    super.packets.variables348(aBoolean721 ? 1 : 0);
                    super.packets.sendpacket();
                    aBoolean668 = false;
                    duelWindow2 = false;
                }
                if(i >= 217 && j >= 238 && i <= 286 && j <= 259)
                {
                    duelWindow2 = true;
                    super.packets.packetID(245);
                    super.packets.sendpacket();
                }
                if(i >= 394 && j >= 238 && i < 463 && j < 259)
                {
                    aBoolean917 = false;
                    super.packets.packetID(82);
                    super.packets.sendpacket();
                }
            } else
            if(mouseClick != 0)
            {
                aBoolean917 = false;
                super.packets.packetID(82);
                super.packets.sendpacket();
            }
            mouseClick = 0;
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
        if(!duelWindow2)
            aClass6_Sub1_724.method231(byte0 + 217, byte1 + 238, anInt948 + 25);
        aClass6_Sub1_724.method231(byte0 + 394, byte1 + 238, anInt948 + 26);
        if(aBoolean668)
        {
            aClass6_Sub1_724.FloatText("Other player", byte0 + 341, byte1 + 246, 1, 0xffffff);
            aClass6_Sub1_724.FloatText("has accepted", byte0 + 341, byte1 + 256, 1, 0xffffff);
        }
        if(duelWindow2)
        {
            aClass6_Sub1_724.FloatText("Waiting for", byte0 + 217 + 35, byte1 + 246, 1, 0xffffff);
            aClass6_Sub1_724.FloatText("other player", byte0 + 217 + 35, byte1 + 256, 1, 0xffffff);
        }
        for(int l4 = 0; l4 < anInt708; l4++)
        {
            int i5 = 217 + byte0 + (l4 % 5) * 49;
            int k5 = 31 + byte1 + (l4 / 5) * 34;
            aClass6_Sub1_724.method247(i5, k5, 48, 32, anInt950 + Class1.anIntArray53[inventoryItemID[l4]], Class1.anIntArray58[inventoryItemID[l4]], 0, 0, false);
            if(Class1.anIntArray55[inventoryItemID[l4]] == 0)
                aClass6_Sub1_724.method257(String.valueOf(anIntArray710[l4]), i5 + 1, k5 + 10, 1, 0xffff00);
        }

        for(int j5 = 0; j5 < anInt910; j5++)
        {
            int l5 = 9 + byte0 + (j5 % 4) * 49;
            int j6 = 31 + byte1 + (j5 / 4) * 34;
            aClass6_Sub1_724.method247(l5, j6, 48, 32, anInt950 + Class1.anIntArray53[anIntArray911[j5]], Class1.anIntArray58[anIntArray911[j5]], 0, 0, false);
            if(Class1.anIntArray55[anIntArray911[j5]] == 0)
                aClass6_Sub1_724.method257(String.valueOf(anIntArray912[j5]), l5 + 1, j6 + 10, 1, 0xffff00);
            if(super.mouseX > l5 && super.mouseX < l5 + 48 && super.mouseY > j6 && super.mouseY < j6 + 32)
                aClass6_Sub1_724.method257("@yel@[" + Class1.itemNameArray[anIntArray911[j5]] + "] " + Class1.aStringArray110[anIntArray911[j5]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }

        for(int i6 = 0; i6 < anInt959; i6++)
        {
            int k6 = 9 + byte0 + (i6 % 4) * 49;
            int l6 = 124 + byte1 + (i6 / 4) * 34;
            aClass6_Sub1_724.method247(k6, l6, 48, 32, anInt950 + Class1.anIntArray53[anIntArray960[i6]], Class1.anIntArray58[anIntArray960[i6]], 0, 0, false);
            if(Class1.anIntArray55[anIntArray960[i6]] == 0)
                aClass6_Sub1_724.method257(String.valueOf(anIntArray961[i6]), k6 + 1, l6 + 10, 1, 0xffff00);
            if(super.mouseX > k6 && super.mouseX < k6 + 48 && super.mouseY > l6 && super.mouseY < l6 + 32)
                aClass6_Sub1_724.method257("@yel@[" + Class1.itemNameArray[anIntArray960[i6]] + "] " + Class1.aStringArray110[anIntArray960[i6]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }

    }

    public void LogOutSucceess()
    {
        aClass6_Sub1_724.method216(126, 137, 260, 60, 0);
        aClass6_Sub1_724.method217(126, 137, 260, 60, 0xffffff);
        aClass6_Sub1_724.FloatText("Logging out...", 256, 173, 5, 0xffffff);
    }

    public void method89(int i, String s)
    {
        int j = objXArray[i];
        int k = objYArray[i];
        int l = j - myPlayer.posX / 128;
        int i1 = k - myPlayer.posY / 128;
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

    public void CombatStyle()
    {
        int k = Class1.anInt144;
        byte byte0 = 7;
        byte byte1 = 15;
        char c = '\257';
        if(mouseClick != 0)
        {
            for(int i = 0; i < 5; i++)
            {
                if(i <= 0 || super.mouseX <= 7 || super.mouseX >= 100 || super.mouseY <= byte1 + i * 20 || super.mouseY >= byte1 + i * 20 + 20)
                    continue;
                fightMode = i - 1;
                lastFightMode = i-1;
                mouseClick = 0;
                super.packets.packetID(119);
                super.packets.variables348(fightMode);
                super.packets.sendpacket();
                break;
            }

        }
        for(int j = 1; j < 5; j++)
        {
            if(j == fightMode + 1)
                aClass6_Sub1_724.method214(byte0, byte1 + j * 20, 90, 20, Class6.method223(190, 190, 190), 88);
            else
                aClass6_Sub1_724.method214(byte0, byte1 + j * 20, 90, 20, Class6.method223(100, 100, 100), 88);
            aClass6_Sub1_724.method218(byte0, byte1 + j * 20, 90, 0);
            aClass6_Sub1_724.method218(byte0, byte1 + j * 20 + 20, 90, 0);
        }
        aClass6_Sub1_724.FloatText("All (+1)", 50, byte1 + 36, 3, 0);
        aClass6_Sub1_724.FloatText("Str (+3)", 50, byte1 + 56, 3, 0);
        aClass6_Sub1_724.FloatText("Atk (+3)", 50, byte1 + 76, 3, 0);
        aClass6_Sub1_724.FloatText("Def (+3)", 50, byte1 + 96, 3, 0);
    }

    public void TargetStuff()
    {
        int i2 = Class1.anInt144;
        if(selectedSpell >= 0 || selectedItem >= 0)
        {
            optionNameArray[optionCount] = "Cancel";
            optionObjectArray[optionCount] = "";
            optionIDArray[optionCount] = 4000;
            optionCount++;
        }
        for(int i = 0; i < optionCount; i++)
            anIntArray984[i] = i;

        for(boolean flag = false; !flag;)
        {
            flag = true;
            for(int j = 0; j < optionCount - 1; j++)
            {
                int l = anIntArray984[j];
                int j1 = anIntArray984[j + 1];
                if(optionIDArray[l] > optionIDArray[j1])
                {
                    anIntArray984[j] = j1;
                    anIntArray984[j + 1] = l;
                    flag = false;
                }
            }

        }

        if(optionCount > 20)
            optionCount = 20;
        if(optionCount > 0)
        {
            int k = -1;
            for(int i1 = 0; i1 < optionCount; i1++)
            {
                if(optionObjectArray[anIntArray984[i1]] == null || optionObjectArray[anIntArray984[i1]].length() <= 0)
                    continue;
                k = i1;
                break;
            }

            String s = null;
            if((selectedItem >= 0 || selectedSpell >= 0) && optionCount == 1)
                s = "Choose a target";
            else
            if((selectedItem >= 0 || selectedSpell >= 0) && optionCount > 1)
                s = "@whi@" + optionNameArray[anIntArray984[0]] + " " + optionObjectArray[anIntArray984[0]];
            else
            if(k != -1)
                s = optionObjectArray[anIntArray984[k]] + ": @whi@" + optionNameArray[anIntArray984[0]];
            if(optionCount == 2 && s != null)
                s = s + "@whi@ / 1 more option";
            if(optionCount > 2 && s != null)
                s = s + "@whi@ / " + (optionCount - 1) + " more options";
            if(s != null)
                aClass6_Sub1_724.method257(s, 6, 14, 1, 0xffff00);
            if(!aBoolean767 && mouseClick == 1 || aBoolean767 && mouseClick == 1 && optionCount == 1)
            {
                optionPacketSender(anIntArray984[0]);
                mouseClick = 0;
                return;
            }
            if(!aBoolean767 && mouseClick == 2 || aBoolean767 && mouseClick == 1)
            {
                anInt755 = (optionCount + 1) * 15;
                anInt754 = aClass6_Sub1_724.method263("Choose option", 1) + 5;
                for(int k1 = 0; k1 < optionCount; k1++)
                {
                    int l1 = aClass6_Sub1_724.method263(optionNameArray[k1] + " " + optionObjectArray[k1], 1) + 5;
                    if(l1 > anInt754)
                        anInt754 = l1;
                }

                anInt752 = super.mouseX - anInt754 / 2;
                anInt753 = super.mouseY - 7;
                aBoolean854 = true;
                if(anInt752 < 0)
                    anInt752 = 0;
                if(anInt753 < 0)
                    anInt753 = 0;
                if(anInt752 + anInt754 > 510)
                    anInt752 = 510 - anInt754;
                if(anInt753 + anInt755 > 315)
                    anInt753 = 315 - anInt755;
                mouseClick = 0;
            }
        }
    }

    public void TradeFinish()
    {
        int l = Class1.anInt144;
        byte byte0 = 22;
        byte byte1 = 36;
        aClass6_Sub1_724.method216(byte0, byte1, 468, 16, 192);
        int i = 0x989898;
        aClass6_Sub1_724.method214(byte0, byte1 + 16, 468, 246, i, 160);
        aClass6_Sub1_724.FloatText("Please confirm your trade with @yel@" + Class15.method363(aLong847), byte0 + 234, byte1 + 12, 1, 0xffffff);
        aClass6_Sub1_724.FloatText("You are about to give:", byte0 + 117, byte1 + 30, 1, 0xffff00);
        for(int j = 0; j < anInt836; j++)
        {
            String s = Class1.itemNameArray[anIntArray837[j]];
            if(Class1.anIntArray55[anIntArray837[j]] == 0)
                s = s + " x " + Currency(anIntArray838[j]);
            aClass6_Sub1_724.FloatText(s, byte0 + 117, byte1 + 42 + j * 12, 1, 0xffffff);
        }

        if(anInt836 == 0)
            aClass6_Sub1_724.FloatText("Nothing!", byte0 + 117, byte1 + 42, 1, 0xffffff);
        aClass6_Sub1_724.FloatText("In return you will receive:", byte0 + 351, byte1 + 30, 1, 0xffff00);
        for(int k = 0; k < anInt691; k++)
        {
            String s1 = Class1.itemNameArray[anIntArray692[k]];
            if(Class1.anIntArray55[anIntArray692[k]] == 0)
                s1 = s1 + " x " + Currency(anIntArray693[k]);
            aClass6_Sub1_724.FloatText(s1, byte0 + 351, byte1 + 42 + k * 12, 1, 0xffffff);
        }

        if(anInt691 == 0)
            aClass6_Sub1_724.FloatText("Nothing!", byte0 + 351, byte1 + 42, 1, 0xffffff);
        aClass6_Sub1_724.FloatText("Are you sure you want to do this?", byte0 + 234, byte1 + 200, 4, 65535);
        aClass6_Sub1_724.FloatText("There is NO WAY to reverse a trade if you change your mind.", byte0 + 234, byte1 + 215, 1, 0xffffff);
        aClass6_Sub1_724.FloatText("Remember that not all players are trustworthy", byte0 + 234, byte1 + 230, 1, 0xffffff);
        if(!tradeFinished)
        {
            aClass6_Sub1_724.method231((byte0 + 118) - 35, byte1 + 238, anInt948 + 25);
            aClass6_Sub1_724.method231((byte0 + 352) - 35, byte1 + 238, anInt948 + 26);
        } else
        {
            aClass6_Sub1_724.FloatText("Waiting for other player...", byte0 + 234, byte1 + 250, 1, 0xffff00);
        }
        if(mouseClick == 1)
        {
            if(super.mouseX < byte0 || super.mouseY < byte1 || super.mouseX > byte0 + 468 || super.mouseY > byte1 + 262)
            {
                tradeWindow = false;
                super.packets.packetID(178);
                super.packets.sendpacket();
            }
            if(super.mouseX >= (byte0 + 118) - 35 && super.mouseX <= byte0 + 118 + 70 && super.mouseY >= byte1 + 238 && super.mouseY <= byte1 + 238 + 21)
            {
                tradeFinished = true;
                super.packets.packetID(65);
                super.packets.sendpacket();
            }
            if(super.mouseX >= (byte0 + 352) - 35 && super.mouseX <= byte0 + 353 + 70 && super.mouseY >= byte1 + 238 && super.mouseY <= byte1 + 238 + 21)
            {
                tradeWindow = false;
                super.packets.packetID(178);
                super.packets.sendpacket();
            }
            mouseClick = 0;
        }
    }

    public void optionPacketSender(int i)
    {
        int j = optionObjXArray[i];
        int k = optionObjYArray[i];
        int l = optionObjIDArray[i];
        int i1 = optionObjNameArray[i];
        int j1 = anIntArray805[i];
        int k1 = optionIDArray[i];
        if(k1 == 200)
        {
            method55(myPlayerX2, myPlayerY2, j, k, true);
            super.packets.packetID(31);
            super.packets.variables343(j + myPlayerX1);
            super.packets.variables343(k + myPlayerY1);
            super.packets.variables343(l);
            super.packets.variables343(i1);
            super.packets.sendpacket();
            selectedSpell = -1;
            System.out.println("CastOnGroundItem(" + l + "," + (j + myPlayerX1) + "," + (k + myPlayerY1) + ")");
        }
        if(k1 == 210)
        {
            method55(myPlayerX2, myPlayerY2, j, k, true);
            super.packets.packetID(70);
            super.packets.variables343(j + myPlayerX1);
            super.packets.variables343(k + myPlayerY1);
            super.packets.variables343(l);
            super.packets.variables343(i1);
            super.packets.sendpacket();
            selectedItem = -1;
            System.out.println("UseItemOnGroundItem(" + l + "," + (j + myPlayerX1) + "," + (k + myPlayerY1) + ")");
        }
        if(k1 == 220)
        {
            method55(myPlayerX2, myPlayerY2, j, k, true);
            super.packets.packetID(104);
            super.packets.variables343(j + myPlayerX1);
            super.packets.variables343(k + myPlayerY1);
            super.packets.variables343(l);
            super.packets.variables343(i1);
            super.packets.sendpacket();
            System.out.println("Take(" + l + "," + (j + myPlayerX1) + "," + (k + myPlayerY1) + ")");
        }
        if(k1 == 3200)
        {
            chatText(Class1.aStringArray110[l], 3);
            System.out.println("Examine(" + l + ")");
        }
        if(k1 == 300)
        {
            method111(j, k, l);
            super.packets.packetID(48);
            super.packets.variables343(j + myPlayerX1);
            super.packets.variables343(k + myPlayerY1);
            super.packets.variables348(l);
            super.packets.variables343(i1);
            super.packets.sendpacket();
            selectedSpell = -1;
            System.out.println("CastOnObject1(" + i1 + "," + l + "," + (j + myPlayerX1) + "," + (k + myPlayerY1) + ")");
        }
        if(k1 == 310)
        {
            method111(j, k, l);
            super.packets.packetID(167);
            super.packets.variables343(j + myPlayerX1);
            super.packets.variables343(k + myPlayerY1);
            super.packets.variables348(l);
            super.packets.variables343(i1);
            super.packets.sendpacket();
            selectedItem = -1;
            System.out.println("UseItemOnObject(" + i1 + "," + l + "," + (j + myPlayerX1) + "," + (k + myPlayerY1) + ")");
        }
        if(k1 == 320)
        {
            method111(j, k, l);
            super.packets.packetID(114);
            super.packets.variables343(j + myPlayerX1);
            super.packets.variables343(k + myPlayerY1);
            super.packets.variables348(l);
            super.packets.sendpacket();
            System.out.println("ObjectCommandA(" + l + "," + (j + myPlayerX1) + "," + (k + myPlayerY1) + ")");
        }
        if(k1 == 2300)
        {
            method111(j, k, l);
            super.packets.packetID(163);
            super.packets.variables343(j + myPlayerX1);
            super.packets.variables343(k + myPlayerY1);
            super.packets.variables348(l);
            super.packets.sendpacket();
            System.out.println("ObjectCommandA2(" + l + "," + (j + myPlayerX1) + "," + (k + myPlayerY1) + ")");
        }
        if(k1 == 3300)
        {
            chatText(Class1.aStringArray71[l], 3);
            System.out.println("Examine(" + l + ")");
        }
        if(k1 == 400)
        {
            method105(j, k, l, i1);
            super.packets.packetID(14);
            super.packets.variables343(j + myPlayerX1);
            super.packets.variables343(k + myPlayerY1);
            super.packets.variables343(j1);
            super.packets.sendpacket();
            selectedSpell = -1;
            System.out.println("CastOnObject(" + j1 + "," + (j + myPlayerX1) + "," + (k + myPlayerY1) + ")");
        }
        if(k1 == 410)
        {
            method105(j, k, l, i1);
            super.packets.packetID(153);
            super.packets.variables343(j + myPlayerX1);
            super.packets.variables343(k + myPlayerY1);
            super.packets.variables343(j1);
            super.packets.sendpacket();
            System.out.println("UseItemOnObject(" + j1 + "," + (j + myPlayerX1) + "," + (k + myPlayerY1) + ")");
            selectedItem = -1;
        }
        if(k1 == 420)
        {
            method105(j, k, l, i1);
            super.packets.packetID(90);
            super.packets.variables343(j + myPlayerX1);
            super.packets.variables343(k + myPlayerY1);
            super.packets.sendpacket();
            System.out.println("ObjectCommandB(" + (j + myPlayerX1) + "," + (k + myPlayerY1) + ")");
        }
        if(k1 == 2400)
        {
            method105(j, k, l, i1);
            super.packets.packetID(227);
            super.packets.variables343(j + myPlayerX1);
            super.packets.variables343(k + myPlayerY1);
            super.packets.sendpacket();
            System.out.println("ObjectCommandB2(" + (j + myPlayerX1) + "," + (k + myPlayerY1) + ")");
        }
        if(k1 == 3400)
        {
            chatText(Class1.aStringArray92[l], 3);
            System.out.println("Examine(" + l + ")");
        }
        if(k1 == 600)
        {
            super.packets.packetID(159);
            super.packets.variables343(l);
            super.packets.variables343(i1);
            super.packets.sendpacket();
            System.out.println("CastOnItem(" + i1 + "," + l + ")");
            selectedSpell = -1;
        }
        if(k1 == 610)
        {
            super.packets.packetID(172);
            super.packets.variables343(l);
            super.packets.variables343(i1);
            super.packets.sendpacket();
            System.out.println("UseItemWithItem(" + i1 + "," + l + ")");
            selectedItem = -1;
        }
        if(k1 == 620)
        {
            super.packets.packetID(170);
            super.packets.variables343(l);
            super.packets.sendpacket();
            System.out.println("Remove(" + l + ")");
        }
        if(k1 == 630)
        {
            super.packets.packetID(12);
            super.packets.variables343(l);
            super.packets.sendpacket();
            System.out.println("Wield(" + l + ")");
        }
        if(k1 == 640)
        {
            super.packets.packetID(219);
            super.packets.variables343(l);
            super.packets.sendpacket();
            System.out.println("ItemCommand(" + l + ")");
        }
        if(k1 == 650)
        {
            selectedItem = l;
            toolbar = 0;
            selectedItemName = Class1.itemNameArray[inventoryItemID[selectedItem]];
            System.out.println("Use(" + l + ")");
        }
        if(k1 == 660)
        {
            super.packets.packetID(196);
            super.packets.variables343(l);
            super.packets.sendpacket();
            selectedItem = -1;
            toolbar = 0;
            System.out.println("Drop(" + l + ")");
        }
        if(k1 == 3600)
        {
            chatText(Class1.aStringArray110[l], 3);
            System.out.println("Examine(" + l + ")");
        }
        if(k1 == 700)
        {
            int l1 = (j - 64) / anInt946;
            int l3 = (k - 64) / anInt946;
            method99(myPlayerX2, myPlayerY2, l1, l3, true);
            super.packets.packetID(49);
            super.packets.variables343(l);
            super.packets.variables343(i1);
            super.packets.sendpacket();
            selectedSpell = -1;
            System.out.println("CastOnNPC(" + i1 + "," + l + ")");
        }
        if(k1 == 710)
        {
            int i2 = (j - 64) / anInt946;
            int i4 = (k - 64) / anInt946;
            method99(myPlayerX2, myPlayerY2, i2, i4, true);
            super.packets.packetID(160);
            super.packets.variables343(l);
            super.packets.variables343(i1);
            super.packets.sendpacket();
            selectedItem = -1;
            System.out.println("UseItemOnNPC(" + i1 + "," + l + ")");
        }
        if(k1 == 720)
        {
            int j2 = (j - 64) / anInt946;
            int j4 = (k - 64) / anInt946;
            method99(myPlayerX2, myPlayerY2, j2, j4, true);
            super.packets.packetID(7);
            super.packets.variables343(l);
            super.packets.sendpacket();
            System.out.println("TalkToNPC(" + l + ")");
        }
        if(k1 == 725)
        {
            int k2 = (j - 64) / anInt946;
            int k4 = (k - 64) / anInt946;
            method99(myPlayerX2, myPlayerY2, k2, k4, true);
            super.packets.packetID(151);
            super.packets.variables343(l);
            super.packets.sendpacket();
            System.out.println("TheiveNPC(" + l + ")");
        }
        if(k1 == 715 || k1 == 2715)
        {
            int l2 = (j - 64) / anInt946;
            int l4 = (k - 64) / anInt946;
            method99(myPlayerX2, myPlayerY2, l2, l4, true);
            super.packets.packetID(47);
            super.packets.variables343(l);
            super.packets.sendpacket();
            if(!macroOn)
	            System.out.println("AttackNPC(" + l + ")");
        }
        if(k1 == 3700)
        {
            chatText(Class1.aStringArray128[l], 3);
            System.out.println("ExamineNPC(" + l + ")");
        }
        if(k1 == 4300)
        {
            System.out.println("SelectNPC(" + l + ")");
            XClient.sendPacket("SELNPC " + l);
            GETNPC = false;
        }
        if(k1 == 800)
        {
            int i3 = (j - 64) / anInt946;
            int i5 = (k - 64) / anInt946;
            method99(myPlayerX2, myPlayerY2, i3, i5, true);
            super.packets.packetID(169);
            super.packets.variables343(l);
            super.packets.variables343(i1);
            super.packets.sendpacket();
            selectedSpell = -1;
            System.out.println("CastOnPlayer(" + i1 + "," + l + ")");
        }
        if(k1 == 810)
        {
            int j3 = (j - 64) / anInt946;
            int j5 = (k - 64) / anInt946;
            method99(myPlayerX2, myPlayerY2, j3, j5, true);
            super.packets.packetID(177);
            super.packets.variables343(l);
            super.packets.variables343(i1);
            super.packets.sendpacket();
            selectedItem = -1;
            System.out.println("UseItemWithPlayer(" + i1 + "," + l + ")");
            
        }
        if(k1 == 805 || k1 == 2805)
        {
            int k3 = (j - 64) / anInt946;
            int k5 = (k - 64) / anInt946;
            method99(myPlayerX2, myPlayerY2, k3, k5, true);
            super.packets.packetID(210);
            super.packets.variables343(l);
            super.packets.sendpacket();
            System.out.println("AttackPlayer(" + l + ")");
        }
        if(k1 == 2806)
        {
            super.packets.packetID(89);
            super.packets.variables343(l);
            super.packets.sendpacket();
            System.out.println("DuelPlayer(" + l + ")");
        }
        if(k1 == 2810)
        {
            super.packets.packetID(250);
            super.packets.variables343(l);
            super.packets.sendpacket();
            System.out.println("TradePlayer(" + l + ")");
        }
        if(k1 == 2820)
        {
            super.packets.packetID(36);
            super.packets.variables343(l);
            super.packets.sendpacket();
            System.out.println("FollowPlayer(" + l + ")");
        }
        if(k1 == 9999)
        {
            System.out.println("SelectPlayer(" + l + ")");
            XClient.sendPacket("SELPLAYER " + l);
        }
        if(k1 == 900)
        {
            method99(myPlayerX2, myPlayerY2, j, k, true);
            super.packets.packetID(220);
            super.packets.variables343(j + myPlayerX1);
            super.packets.variables343(k + myPlayerY1);
            super.packets.variables343(l);
            super.packets.sendpacket();
            selectedSpell = -1;
            System.out.println("CastOnGround(" + l + "," + (j + myPlayerX1) + "," + (k + myPlayerY1) + ")");
        }
        if(k1 == 920)
        {
            method99(myPlayerX2, myPlayerY2, j, k, false);
            if(anInt670 == -24)
                anInt670 = 24;
            System.out.println("WalkTo(" + (chosenx + myPlayerX1) + "," + (choseny + myPlayerY1) + ")");
        }
        if(k1 == 1000)
        {
            super.packets.packetID(156);
            super.packets.variables343(l);
            super.packets.sendpacket();
            selectedSpell = -1;
            System.out.println("CastOnSelf(" + l + ")");
        }
        if(k1 == 4000)
        {
            selectedItem = -1;
            selectedSpell = -1;
            System.out.println("Cancel()");
        }
    }

    public void method94()
    {
        aClass4_775 = new Class4(aClass6_Sub1_724, 10);
        anInt776 = aClass4_775.method160(5, 269, 502, 56, 1, 20, true);
        anInt777 = aClass4_775.method161(7, 324, 498, 14, 1, 80, false, true);
        anInt778 = aClass4_775.method160(5, 269, 502, 56, 1, 20, true);
        anInt779 = aClass4_775.method160(5, 269, 502, 56, 1, 20, true);
        aClass4_775.method173(anInt777);
    }

    public void DownloadJunk()
    {
        aClass19_883.aByteArray593 = UnPack("maps" + Class18.anInt575 + ".jag", "map", 70);
        if(members)
            aClass19_883.aByteArray612 = UnPack("maps" + Class18.anInt575 + ".mem", "members map", 75);
        aClass19_883.aByteArray592 = UnPack("land" + Class18.anInt575 + ".jag", "landscape", 80);
        if(members)
            aClass19_883.aByteArray611 = UnPack("land" + Class18.anInt575 + ".mem", "members landscape", 85);
    }

    void method96(int i, int j, int k, int l, int i1, int j1, int k1)
    {
        int k6 = Class1.anInt144;
        Class2 class2 = PlayerArray[i1];
        if(class2.anInt171 == 255)
            return;
        int l1 = class2.status + (mapangle + 16) / 32 & 7;
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
        if(class2.status == 8)
        {
            i2 = 5;
            l1 = 2;
            flag = false;
            i -= (5 * k1) / 100;
            j2 = i2 * 3 + anIntArray939[(anInt918 / 5) % 8];
        } else
        if(class2.status == 9)
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

        if(class2.anInt161 > 0)
        {
            anIntArray967[anInt820] = aClass6_Sub1_724.method263(class2.lastChatMessage, 1) / 2;
            if(anIntArray967[anInt820] > 150)
                anIntArray967[anInt820] = 150;
            anIntArray968[anInt820] = (aClass6_Sub1_724.method263(class2.lastChatMessage, 1) / 300) * aClass6_Sub1_724.method261(1);
            anIntArray965[anInt820] = i + k / 2;
            anIntArray966[anInt820] = j;
            aStringArray821[anInt820++] = class2.lastChatMessage;
        }
        if(class2.anInt163 > 0)
        {
            anIntArray758[anInt958] = i + k / 2;
            anIntArray759[anInt958] = j;
            anIntArray722[anInt958] = k1;
            anIntArray723[anInt958++] = class2.anInt162;
        }
        if(class2.status == 8 || class2.status == 9 || class2.anInt167 != 0)
        {
            if(class2.anInt167 > 0)
            {
                int i3 = i;
                if(class2.status == 8)
                    i3 -= (20 * k1) / 100;
                else
                if(class2.status == 9)
                    i3 += (20 * k1) / 100;
                int i4 = (class2.anInt165 * 30) / class2.anInt166;
                anIntArray687[anInt766] = i3 + k / 2;
                anIntArray688[anInt766] = j;
                anIntArray689[anInt766++] = i4;
            }
            if(class2.anInt167 > 150)
            {
                int j3 = i;
                if(class2.status == 8)
                    j3 -= (10 * k1) / 100;
                else
                if(class2.status == 9)
                    j3 += (10 * k1) / 100;
                aClass6_Sub1_724.method231((j3 + k / 2) - 12, (j + l / 2) - 12, anInt948 + 11);
                aClass6_Sub1_724.FloatText(String.valueOf(class2.anInt164), (j3 + k / 2) - 1, j + l / 2 + 5, 3, 0xffffff);
            }
        }
        if(class2.anInt179 == 1 && class2.anInt163 == 0)
        {
            int k3 = j1 + i + k / 2;
            if(class2.status == 8)
                k3 -= (20 * k1) / 100;
            else
            if(class2.status == 9)
                k3 += (20 * k1) / 100;
            int j4 = (16 * k1) / 100;
            int l4 = (16 * k1) / 100;
            aClass6_Sub1_724.method232(k3 - j4 / 2, j - l4 / 2 - (10 * k1) / 100, j4, l4, anInt948 + 13);
        }
    }

    public void method97(String s)
    {
        if(anInputStream_Sub1_901 == null)
            return;
        if(aBoolean853)
        {
            return;
        } else
        {
            anInputStream_Sub1_901.method123(aByteArray987, Class15.method364(s + ".pcm", aByteArray987), Class15.method365(s + ".pcm", aByteArray987));
            return;
        }
    }

    public boolean Loading(int i, int j)
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
        aClass6_Sub1_724.FloatText("Loading... Please wait", 256, 192, 1, 0xffffff);
        ChatTypes();
        aClass6_Sub1_724.method211(aGraphics857, 0, 0);
        int k = myPlayerX1;
        int l = myPlayerY1;
        int i1 = (i + 24) / 48;
        int j1 = (j + 24) / 48;
        anInt809 = anInt785;
        myPlayerX1 = i1 * 48 - 48;
        myPlayerY1 = j1 * 48 - 48;
        anInt842 = i1 * 48 - 32;
        anInt843 = j1 * 48 - 32;
        anInt844 = i1 * 48 + 32;
        anInt845 = j1 * 48 + 32;
        aClass19_883.method416(i, j, anInt809);
        myPlayerX1 -= anInt806;
        myPlayerY1 -= anInt807;
        int k1 = myPlayerX1 - k;
        int l1 = myPlayerY1 - l;
        for(int i2 = 0; i2 < objCount; i2++)
        {
            objXArray[i2] -= k1;
            objYArray[i2] -= l1;
            int j2 = objXArray[i2];
            int l2 = objYArray[i2];
            int k3 = objID[i2];
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

        for(int j3 = 0; j3 < itemCount; j3++)
        {
            itemXArray[j3] -= k1;
            itemYArray[j3] -= l1;
        }

        for(int i4 = 0; i4 < PlayerCount; i4++)
        {
            Class2 class2 = PlayerArray[i4];
            class2.posX -= k1 * anInt946;
            class2.posY -= l1 * anInt946;
            for(int j5 = 0; j5 <= class2.anInt156; j5++)
            {
                class2.anIntArray157[j5] -= k1 * anInt946;
                class2.anIntArray158[j5] -= l1 * anInt946;
            }

        }

        for(int k4 = 0; k4 < npccount; k4++)
        {
            Class2 class2_1 = NPCArray[k4];
            class2_1.posX -= k1 * anInt946;
            class2_1.posY -= l1 * anInt946;
            for(int l5 = 0; l5 <= class2_1.anInt156; l5++)
            {
                class2_1.anIntArray157[l5] -= k1 * anInt946;
                class2_1.anIntArray158[l5] -= l1 * anInt946;
            }

        }

        aClass19_883.aBoolean609 = true;
        return true;
    }

    public void method99(int i, int j, int k, int l, boolean flag)
    {
        method83(i, j, k, l, k, l, false, flag);
    }
    
    public boolean ShowCombat;
    public boolean HideGFX;
    public boolean WText1;
    public boolean WText2;
    public boolean WText3;
    public boolean WText4;
    public boolean WText5;
    public boolean WText6;
    public boolean WText7;
    public boolean WText8;
    public boolean WText9;
    public String WText1Text;
    public String WText2Text;
    public String WText3Text;
    public String WText4Text;
    public String WText5Text;
    public String WText6Text;
    public String WText7Text;
    public String WText8Text;
    public String WText9Text;
    public int WText1X;
    public int WText1Y;
    public int WText2X;
    public int WText2Y;
    public int WText3X;
    public int WText3Y;
    public int WText4X;
    public int WText4Y;
    public int WText5X;
    public int WText5Y;
    public int WText6X;
    public int WText6Y;
    public int WText7X;
    public int WText7Y;
    public int WText8X;
    public int WText8Y;
    public int WText9X;
    public int WText9Y;
    public int WBoTint1;
    public int WBoTint2;
    public int MYLastMousePosX;
    public int MYLastMousePosY;
    public int MYLastPosX;
    public int MYLastPosY;
    public boolean FogOfWar;
    public boolean GETNPC;
    public boolean aBoolean666;
    public boolean aBoolean668;
    public boolean duelWindow2;
    public boolean tradeWindow;
    public boolean tradeFinished;
    public boolean aBoolean675;
    public boolean aBoolean680;
    public boolean aBoolean717;
    public boolean aBoolean718;
    public boolean aBoolean719;
    public boolean aBoolean720;
    public boolean aBoolean721;
    public boolean aBoolean727;
    public boolean aBoolean745;
    public boolean aBoolean757;
    public boolean aBoolean767;
    public boolean aBoolean789;
    public boolean duelWindow;
    public boolean duelFinished;
    public boolean aBoolean810;
    public boolean aBoolean849;
    public boolean answerMenu;
    public boolean aBoolean853;
    public boolean aBoolean854;
    public boolean aBoolean856;
    public boolean aBoolean870;
    public boolean aBoolean879;
    public boolean aBoolean880;
    public boolean aBoolean890;
    public boolean aBoolean908;
    public boolean members;
    public boolean aBoolean917;
    public boolean aBoolean922;
    public boolean hasAccepted;
    public boolean tradeWindow2;
    public boolean aBoolean979;
    public boolean aBoolean992;
    public boolean aBooleanArray662[];
    public boolean aBooleanArray679[];
    public boolean aBooleanArray716[];
    public boolean aBooleanArray831[];
    public byte aByteArray987[];
    public Class10 aClass10_739;
    public Class19 aClass19_883;
    public Class2 NPCArray[];
    public Class2 aClass2Array822[];
    public Class2 aClass2Array891[];
    public Class2 aClass2Array923[];
    public Class2 aClass2Array957[];
    public Class2 PlayerArray[];
    public Class2 myPlayer;
    public Class4 aClass4_667;
    public Class4 aClass4_751;
    public Class4 aClass4_775;
    public Class4 aClass4_798;
    public Class4 aClass4_826;
    public Class4 aClass4_830;
    public Class4 aClass4_858;
    public Class4 aClass4_925;
    public Class5 aClass5Array781[];
    public Class5 aClass5Array814[];
    public Class5 aClass5Array994[];
    public Class6_Sub1 aClass6_Sub1_724;
    public Graphics aGraphics857;
    public long aLong847;
    public long aLong907;
    long aLong928;
    public String aString681;
    public String aString682;
    public String username;
    public String password;
    String selectedItemName;
    public String aString794;
    public String aString824;
    public String aString846;
    public String aString848;
    public String aString861;
    public String aString862;
    public String aString894;
    public static String PacketStore;
    public static boolean PacketStored;
    public String StatNameArray[] = {
        "Attack", "Defense", "Strength", "Hits", "Ranged", "Prayer", "Magic", "Cooking", "Woodcut", "Fletching", 
        "Fishing", "Firemaking", "Crafting", "Smithing", "Mining", "Herblaw", "Agility", "Thieving"
    };
    public String optionObjectArray[];
    public String aStringArray774[];
    public String aStringArray795[] = {
        "Attack", "Defense", "Strength", "Hits", "Ranged", "Prayer", "Magic", "Cooking", "Woodcutting", "Fletching", 
        "Fishing", "Firemaking", "Crafting", "Smithing", "Mining", "Herblaw", "Agility", "Thieving"
    };
    String aStringArray821[];
    public String aStringArray913[];
    public String aStringArray930[] = {
        "Black knight's fortress", "Cook's assistant", "Demon slayer", "Doric's quest", "The restless ghost", "Goblin diplomacy", "Ernest the chicken", "Imp catcher", "Pirate's treasure", "Prince Ali rescue", 
        "Romeo & Juliet", "Sheep shearer", "Shield of Arrav", "The knight's sword", "Vampire slayer", "Witch's potion", "Dragon slayer", "Witch's house (members)", "Lost city (members)", "Hero's quest (members)", 
        "Druidic ritual (members)", "Merlin's crystal (members)", "Scorpion catcher (members)", "Family crest (members)", "Tribal totem (members)", "Fishing contest (members)", "Monk's friend (members)", "Temple of Ikov (members)", "Clock tower (members)", "The Holy Grail (members)", 
        "Fight Arena (members)", "Tree Gnome Village (members)", "The Hazeel Cult (members)", "Sheep Herder (members)", "Plague City (members)", "Sea Slug (members)", "Waterfall quest (members)", "Biohazard (members)", "Jungle potion (members)", "Grand tree (members)", 
        "Shilo village (members)", "Underground pass (members)", "Observatory quest (members)", "Tourist trap (members)", "Watchtower (members)", "Dwarf Cannon (members)", "Murder Mystery (members)", "Digsite (members)", "Gertrude's Cat (members)", "Legend's Quest (members)"
    };
    public String aStringArray932[] = {
        "Armour", "WeaponAim", "WeaponPower", "Magic", "Prayer"
    };
    public String optionNameArray[];
    public String aStringArray997[] = {
        "Where were you born?", "What was your first teachers name?", "What is your fathers middle name?", "Who was your first best friend?", "What is your favourite vacation spot?", "What is your mothers middle name?", "What was your first pets name?", "What was the name of your first school?", "What is your mothers maiden name?", "Who was your first boyfriend/girlfriend?", 
        "What was the first computer game you purchased?", "Who is your favourite actor/actress?", "Who is your favourite author?", "Who is your favourite musician?", "Who is your favourite cartoon character?", "What is your favourite book?", "What is your favourite food?", "What is your favourite movie?"
    };
    public int xrotate = 912;
    public InputStream_Sub1 anInputStream_Sub1_901;
    public int anInt650 = 250;
    public int anInt651 = 5;
    public int anInt652 = 50;
    public int anInt653 = 18;
    public int anInt654 = 500;
    public int anInt655 = 1500;
    public int anInt656 = 5000;
    public int anInt657 = 5000;
    public int anInt658 = 500;
    public int anInt659 = 4000;
    public int anInt660 = 500;
    public int anInt661 = 8000;
    public int anInt663;
    public int anInt670;
    int anInt671;
    int anInt672;
    public int anInt676;
    public int anInt677;
    public int anInt678;
    public int CameraZoom;
    public int anInt685;
    public int anInt690;
    public int anInt691;
    public int anInt694;
    public int anInt695;
    public int anInt696;
    public int anInt697;
    public int anInt698;
    public int anInt699;
    public int anInt700;
    public int anInt701;
    public int anInt702;
    public int anInt703;
    public int anInt704;
    public int anInt705;
    public int anInt706;
    public int anInt707;
    public int anInt708;
    public int anInt714;
    public int anInt715;
    public int anInt725;
    public int mapangle;
    public int anInt731;
    public int anInt732;
    public int anInt733;
    public int PlayerCount;
    public int anInt743;
    public int anInt744;
    public int anInt746;
    public int anInt749;
    public int fightMode;
    public int anInt752;
    public int anInt753;
    public int anInt754;
    public int anInt755;
    public int optionCount;
    public int selectedItem;
    public int anInt766;
    int anInt776;
    int anInt777;
    int anInt778;
    int anInt779;
    int anInt780;
    public int anInt782;
    public int myPlayerX1;
    public int myPlayerY1;
    public int anInt785;
    public int anInt786;
    public int anInt790;
    public int anInt791;
    public int anInt792;
    public int anInt793;
    public int objCount;
    int anInt799;
    int anInt800;
    public int anInt806;
    public int anInt807;
    public int anInt808;
    public int anInt809;
    public int selectedSpell;
    public int anInt812;
    public int mouseClick;
    public int anInt818;
    public int anInt819;
    public int anInt820;
    public int itemCount;
    int anInt827;
    int anInt828;
    public int anInt833;
    public int bankSlots;
    public int anInt835;
    public int anInt836;
    public int anInt839;
    public int anInt840;
    public int anInt841;
    public int anInt842;
    public int anInt843;
    public int anInt844;
    public int anInt845;
    public int anInt850;
    public int anInt851;
    public int anInt855;
    public int anInt859;
    public int anInt860;
    public int anInt863;
    public int anInt864;
    public int intUsername;
    public int intPassword;
    public int anInt867;
    public int intCancel;
    public int anInt869;
    public int anInt871;
    public int anInt872;
    public int anInt873;
    public int anInt874;
    public int anInt875;
    public int anInt876;
    public int anInt877;
    public int anInt878;
    public int anInt884;
    public int anInt886;
    public int anInt889;
    public int fatigue;
    public int anInt893;
    public int anInt895;
    public int anInt896;
    public int anInt897;
    public int anInt898;
    public int anInt899;
    public int anInt900;
    public int anInt902;
    public int selectedShopItem;
    public int anInt904;
    public int npccount;
    public int anInt906;
    public int anInt910;
    public int toolbar;
    public int anInt916;
    public int anInt918;
    public int anInt919;
    public int anInt920;
    public int anInt921;
    public int anInt924;
    public int BTNtype;
    int anInt926;
    int anInt927;
    public int anInt929;
    public int anInt931;
    public int anInt933;
    public int anInt936;
    public int anInt940;
    public int anInt941;
    public int anInt942;
    public int anInt943;
    public int anInt946;
    public int anInt947;
    public int anInt948;
    public int anInt949;
    public int anInt950;
    public int anInt951;
    public int anInt952;
    public int anInt953;
    public int anInt954;
    public int anInt958;
    public int anInt959;
    public int anInt964;
    public int tradePosCount;
    public int anInt973;
    public int anInt974;
    int myPlayerX2;
    int myPlayerY2;
    int anInt978;
    public int anInt980;
    public int anInt986;
    public int anInt988;
    public int anInt989;
    public int anInt990;
    public int anInt991;
    public int anInt993;
    public int anInt995;
    public int anInt996;
    public int anIntArray664[];
    public int anIntArray665[];
    public int anIntArray686[];
    public int anIntArray687[];
    public int anIntArray688[];
    public int anIntArray689[];
    public int anIntArray692[];
    public int anIntArray693[];
    public int inventoryItemID[];
    public int anIntArray710[];
    public int anIntArray711[];
    public int CurrentXPArray[];
    public int anIntArray722[];
    public int anIntArray723[];
    public int anIntArray726[] = {
        0, 1, 2, 1
    };
    public int CurrentStatLevelArray[];
    public int anIntArray730[];
    public int shopItemID[];
    public int shopItemCount[];
    public int anIntArray738[];
    public int anIntArray740[];
    public int anIntArray741[];
    public int anIntArray747[];
    public int anIntArray748[];
    public int anIntArray758[];
    public int anIntArray759[];
    public int objXArray[];
    public int objYArray[];
    public int objID[];
    public int anIntArray763[];
    public int itemXArray[];
    public int itemYArray[];
    public int itemIDArray[];
    public int anIntArray773[];
    public int anIntArray787[];
    public int anIntArray788[];
    public int anIntArray797[];
    public int optionObjIDArray[];
    public int optionObjNameArray[];
    public int anIntArray805[];
    public int anIntArray815[];
    public int anIntArray816[];
    public int anIntArray817[];
    public int RealStatLevelArray[];
    public int anIntArray829[] = {
        0xecded0, 0xccb366, 0xb38c40, 0x997326, 0x906020
    };
    public int anIntArray832[] = {
        0xff0000, 0xff8000, 0xffe000, 0xa0e000, 57344, 32768, 41088, 45311, 33023, 12528, 
        0xe000e0, 0x303030, 0x604000, 0x805000, 0xffffff
    };
    public int anIntArray837[];
    public int anIntArray838[];
    public int anIntArray881[];
    public int optionIDArray[];
    public int anIntArray885[] = {
        0xffc030, 0xffa040, 0x805030, 0x604020, 0x303030, 0xff6020, 0xff4000, 0xffffff, 65280, 65535
    };
    public int anIntArray887[];
    public int anIntArray888[];
    public int anIntArray909[] = {
        0, 0, 0, 0, 0, 1, 2, 1
    };
    public int anIntArray911[];
    public int anIntArray912[];
    public int anIntArray934[];
    public int anIntArray935[];
    public int optionObjXArray[];
    public int optionObjYArray[];
    public int anIntArray939[] = {
        0, 1, 2, 1, 0, 0, 0, 0
    };
    public int bankItemID[];
    public int bankItemCount[];
    public int anIntArray960[];
    public int anIntArray961[];
    public int anIntArray962[];
    public int anIntArray963[];
    public int anIntArray965[];
    public int anIntArray966[];
    public int anIntArray967[];
    public int anIntArray968[];
    public int tradeItemID[];
    public int tradeItemCount[];
    public int anIntArray972[];
    int anIntArray981[];
    int anIntArray982[];
    int head;
    public int anIntArray984[];
    public int anIntArrayArray684[][] = {
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