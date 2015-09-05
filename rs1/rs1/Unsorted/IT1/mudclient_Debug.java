/*
 * mudclient_Debug.java
 *
 * Created on August 29, 2003, 12:50 PM
 */
//import a.a.e;
import a.a.j;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.util.*;
import java.io.*;
import java.lang.reflect.*;
import java.applet.*;
import javax.swing.*;
/** The override class that allows additional functionalty in mudclient
 * @author harperart
 */
public class mudclient_Debug extends mudclient implements KeyListener,MouseListener,MouseMotionListener
{
    /*copied from java.awt.Event*/
    /* table for mapping old Event action keys to KeyEvent virtual keys. */
    private static final int actionKeyCodes[][] =
    {
        /*    virtual key              action key   */
        { KeyEvent.VK_HOME,        Event.HOME         },
        { KeyEvent.VK_END,         Event.END          },
        { KeyEvent.VK_PAGE_UP,     Event.PGUP         },
        { KeyEvent.VK_PAGE_DOWN,   Event.PGDN         },
        { KeyEvent.VK_UP,          Event.UP           },
        { KeyEvent.VK_DOWN,        Event.DOWN         },
        { KeyEvent.VK_LEFT,        Event.LEFT         },
        { KeyEvent.VK_RIGHT,       Event.RIGHT        },
        { KeyEvent.VK_F1,          Event.F1           },
        { KeyEvent.VK_F2,          Event.F2           },
        { KeyEvent.VK_F3,          Event.F3           },
        { KeyEvent.VK_F4,          Event.F4           },
        { KeyEvent.VK_F5,          Event.F5           },
        { KeyEvent.VK_F6,          Event.F6           },
        { KeyEvent.VK_F7,          Event.F7           },
        { KeyEvent.VK_F8,          Event.F8           },
        { KeyEvent.VK_F9,          Event.F9           },
        { KeyEvent.VK_F10,         Event.F10          },
        { KeyEvent.VK_F11,         Event.F11          },
        { KeyEvent.VK_F12,         Event.F12          },
        { KeyEvent.VK_PRINTSCREEN, Event.PRINT_SCREEN },
        { KeyEvent.VK_SCROLL_LOCK, Event.SCROLL_LOCK  },
        { KeyEvent.VK_CAPS_LOCK,   Event.CAPS_LOCK    },
        { KeyEvent.VK_NUM_LOCK,    Event.NUM_LOCK     },
        { KeyEvent.VK_PAUSE,       Event.PAUSE        },
        { KeyEvent.VK_INSERT,      Event.INSERT       }
    };
    public String userName = null;
    public String password = null;
    public static boolean ms = false;
    public int zoom = 5500;
    public int overhead = 912;
    public boolean terainOn = true;
    public boolean ghost = false;
    private static String w = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\243$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";
    Vector messageListeners = new Vector();
    Vector loopListeners = new Vector();
    private Object loadingLock = new Object();
    Thread autoEatThread;
    public int worldHook = 0;
    public boolean autoReloginOverride = false;
    /** True if macros should be running */    
    public volatile boolean macroOn = false;
    /** A reference of commands to the macro that handles the command */    
    public boolean sleeperBeep = true;
    public static Hashtable macros = new Hashtable();
    AttackScript attackScript = new AttackScript();
    public class AttackScript extends Commander
    {
        public AttackScript()
        {
            super(0,0,0,0,0,715);
        }
        public void setNextAttack(Object mob)
        {
            c mob1 = (c)mob;
            ew = mob1.e;
            ex = mob1.f;
            ey = mob1.c;
            addLoopListener(this);
        }
    }
    PickUpItemScript pickupItemScript = new PickUpItemScript();
    public class PickUpItemScript extends Commander
    {
        public PickUpItemScript()
        {
            super(0,0,0,0,0,220);
        }
        public void setNextPickup(int index)
        {
            ew = db[index];
            ex = dc[index];
            ey = dd[index];
            addLoopListener(this);
        }
    }
    /** Creates a new instance of mudclient_Debug */
    public mudclient_Debug()
    {
        super();
        cy = 1500; //height
        if(!ms)
        if(Main.fullscreen)
        {
            bR = Main.rsWidth;
            bS = Main.rsHeight;
        }
        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    public void a(int i1,int j1,byte[] abyte)
    {
        super.a(i1,j1,abyte);
        //System.out.println("a called"+i1+","+j1);
    }
    public void D()
    {
        bQ = 0;
        gD = 0;
        gY = "";
        gZ = "";
        gW = "Please enter a username:";
        gX = "*" + gY + "*";
        cH = 0;
        cT = 0;
    }
    public void Q()
    {
        login();
        //Thread.dumpStack();
    }
    public void login()
    {
        label0:
        {
            gE = new a.a.e(bO, 50);
            byte byte0 = 40;
            //if(!bq)
            {
                gE.b(256, 200 + byte0, "Click Something Already!", 5, true);
                gE.d(156, 240 + byte0, 120, 35); //draw a button box
                gE.d(356, 240 + byte0, 120, 35); //draw a button box
                gE.b(156, 240 + byte0, "Nuuby", 5, false);
                gE.b(356, 240 + byte0, "L3MM3 PL4Y", 5, false);
                gF = gE.f(156, 240 + byte0, 120, 35); //new user button handler
                gG = gE.f(356, 240 + byte0, 120, 35); //existing user button handler
                if(b.bN == 0)
                    break label0;
            }
            gE.b(256, 200 + byte0, "Welcome to RuneScape", 4, true);
            gE.b(256, 215 + byte0, "You need a member account to use this server", 4, true);
            gE.d(256, 250 + byte0, 200, 35);
            gE.b(256, 250 + byte0, "Click here to login", 5, false);
            gG = gE.f(256, 250 + byte0, 200, 35);
        }
        gH = new a.a.e(bO, 50);
        int i = 70;
        gI = gH.b(256, i + 8, "Gimme the name of char and etc shit details", 4, true);
        i += 25;
        gH.d(256, i + 17, 250, 34);
        gH.b(256, i + 8, "Whatsya Name", 4, false);
        //hack username length chnaged to 25 to allow bypass encoding
        gL = gH.b(256, i + 25, 200, 40, 4, /*12*/25, false, false);
        gH.h(gL);
        i += 40;
        gH.d(141, i + 17, 220, 34);
        gH.b(141, i + 8, "*Top Secret* =P", 4, false);
        gM = gH.b(141, i + 25, 220, 40, 4, 20, true, false);
        gH.d(371, i + 17, 220, 34);
        gH.b(371, i + 8, "Gimme the OK!", 4, false);
        gN = gH.b(371, i + 25, 220, 40, 4, 20, true, false);
        i += 40;
        i += 20;
        gO = gH.e(60, i, 14);
        gH.a(75, i, "Yea yea i hear ya", 4, true);
        i += 15;
        gH.b(256, i, "Click it Click it Click it", 4, true);
        i += 20;
        gH.d(156, i + 17, 150, 34);
        gH.b(156, i + 17, "Go Go Go", 5, false);
        gK = gH.f(156, i + 17, 150, 34);
        gH.d(356, i + 17, 150, 34);
        gH.b(356, i + 17, "Fuck this", 5, false);
        gJ = gH.f(356, i + 17, 150, 34);
        gP = new a.a.e(bO, 50);
        i = 190;
        //hack
        gP.d(140, i, 200, 40);
        gP.b(140, i - 10, "World:", 4, false);
        worldHook = gP.b(140, i + 10, 200, 40, 4, 12, false, false);
        i+=40;
        //end hack
        gQ = gP.b(256, i - 10, "Take Me To Youre Leader", 4, true);
        i += 28;
        gP.d(140, i, 200, 40);
        gP.b(140, i - 10, "That u? :", 4, false);
        gR = gP.b(140, i + 10, 200, 40, 4, 12, false, false);
        i += 47;
        gP.d(190, i, 200, 40);
        gP.b(190, i - 10, "Shhhhhhh", 4, false);
        gS = gP.b(190, i + 10, 200, 40, 4, 20, true, false);
        i -= 55;
        gP.d(410, i, 120, 25);
        gP.b(410, i, "GO GO GO", 4, false);
        gT = gP.f(410, i, 120, 25);
        i += 30;
        gP.d(410, i, 120, 25);
        gP.b(410, i, "<-", 4, false);
        gU = gP.f(410, i, 120, 25);
        i += 30;
        gP.d(410, i, 160, 25);
        gP.b(410, i, "Eek Im Doomed", 4, false);
        gV = gP.f(410, i, 160, 25);
        gP.h(gR);
    }
    public boolean c(int i, int j) //called From a(int, int ,byte[])
    {
        if(ghost)
        {
            return false;
        }
        //System.out.println("loc:"+i+","+j);
        //System.out.println(cu+","+cv+" "+cw+","+cx);
        boolean retvalue = super.c(i,j);
        synchronized(loadingLock)
        {
            loadingLock.notifyAll();
        }
        return retvalue;
    }
    public void b_false(boolean flag)
    {
        int i;
        char c1;
        char c3;
        int j1;
        int j5;
        int l5;
        int l7;
        int k9;
        k9 = b.bN;
        i = ((a.a.g) (bO)).a - 199; //x start of map?
        c1 = '\234';
        c3 = '\230';
        bO.c(i - 49, 3, bU + 2);
        i += 40;
        bO.b(i, 36, c1, c3, 0); //black out the map area
        bO.a(i, 36, i + c1, 36 + c3);
        j1 = 192 + dS;
        int l1 = cE + dR & 0xff;
        int j2 = ((cN.e - 6040) * 3 * j1) / 2048;
        int l3 = ((cN.f - 6040) * 3 * j1) / 2048;
        j5 = j.k[1024 - l1 * 4 & 0x3ff];
        l5 = j.k[(1024 - l1 * 4 & 0x3ff) + 1024];
        int j6 = l3 * j5 + j2 * l5 >> 18;
        l3 = l3 * l5 - j2 * j5 >> 18;
        j2 = j6;
        bO.g((i + c1 / 2) - j2, 36 + c3 / 2 + l3, bU - 1, l1 + 64 & 0xff, j1);
        l7 = 0;
        if(k9 != 0 && l7 < dg)
            do
            {
                int k2 = (((di[l7] * bP + 64) - cN.e) * 3 * j1) / 2048;
                int i4 = (((dj[l7] * bP + 64) - cN.f) * 3 * j1) / 2048;
                int k6 = i4 * j5 + k2 * l5 >> 18;
                i4 = i4 * l5 - k2 * j5 >> 18;
                k2 = k6;
                b(i + c1 / 2 + k2, (36 + c3 / 2) - i4, 0x0000FFFF); //set cyan pixle?
                l7++;
            }while(l7 < dg);
        int i8 = 0;
        if(k9 != 0 && i8 < da)
        {
            do
            {
                int l2 = (((db[i8] * bP + 64) - cN.e) * 3 * j1) / 2048;
                int j4 = (((dc[i8] * bP + 64) - cN.f) * 3 * j1) / 2048;
                int l6 = j4 * j5 + l2 * l5 >> 18;
                j4 = j4 * l5 - l2 * j5 >> 18;
                l2 = l6;
                b(i + c1 / 2 + l2, (36 + c3 / 2) - j4, 0xff0000); //set red pixle
                i8++;
            }while(i8 < da);
        }
        int j8 = 0;
        if(k9 != 0 && j8 < cT)
        {
            do
            {
                c c5 = cW[j8];
                int i3 = ((c5.e - cN.e) * 3 * j1) / 2048;
                int k4 = ((c5.f - cN.f) * 3 * j1) / 2048;
                int i7 = k4 * j5 + i3 * l5 >> 18;
                k4 = k4 * l5 - i3 * j5 >> 18;
                i3 = i7;
                b(i + c1 / 2 + i3, (36 + c3 / 2) - k4, 0xffff00); //set yellow pixle
                j8++;
            }while(j8 < cT);
        }
        int k8 = 0;
        int j3;
        int l4;
        c c6;
        int i9;
        int j9;
        c6 = cL[k8];
        j3 = ((c6.e - cN.e) * 3 * j1) / 2048;
        l4 = ((c6.f - cN.f) * 3 * j1) / 2048;
        int j7 = l4 * j5 + j3 * l5 >> 18;
        l4 = l4 * l5 - j3 * j5 >> 18;
        j3 = j7;
        i9 = 0xffffff;
        j9 = 0;
        boolean k9_0 = k9 != 0;
        //        while(true)
        //        {
        //            System.out.println(k8);
        //            if(k9_0 /*&& j9 < ((a.a.b)this).bc*/)
        //            {
        //                do
        //                {
        //                    if(c6.a != ((a.a.b)this).bd[j9] || ((a.a.b)this).be[j9] != 99)
        //                        continue; /* Loop/switch isn't completed */
        //                    i9 = 65280;
        //                    if(k9 == 0)
        //                        break; /* Loop/switch isn't completed */
        //                    j9++;
        //                }while(j9 < ((a.a.b)this).bc);
        //                b(i + c1 / 2 + j3, (36 + c3 / 2) - l4, i9);
        //                k8++;
        //            }
        //            k9_0 = true;
        //            if(k8 >= cH)
        //            {
        //                bO.a(i + c1 / 2, 36 + c3 / 2, 2, 0xffffff, 255);
        //                bO.g(i + 19, 55, bU + 24, cE + 128 & 0xff, 128);
        //                bO.a(0, 0, bR, bS + 12);
        //                if(!flag)
        //                    return;
        //                i = ((a.a.b)this).G - (((a.a.g) (bO)).a - 199);
        //                int l8 = ((a.a.b)this).H - 36;
        //                if(i >= 40 && l8 >= 0 && i < 196 && l8 < 152)
        //                {
        //                    char c2 = '\234';
        //                    char c4 = '\230';
        //                    int k1 = 192 + dS;
        //                    int i2 = cE + dR & 0xff;
        //                    int i1 = ((a.a.g) (bO)).a - 199;
        //                    i1 += 40;
        //                    int k3 = ((((a.a.b)this).G - (i1 + c2 / 2)) * 16384) / (3 * k1);
        //                    int i5 = ((((a.a.b)this).H - (36 + c4 / 2)) * 16384) / (3 * k1);
        //                    int k5 = j.k[1024 - i2 * 4 & 0x3ff];
        //                    int i6 = j.k[(1024 - i2 * 4 & 0x3ff) + 1024];
        //                    int k7 = i5 * k5 + k3 * i6 >> 15;
        //                    i5 = i5 * i6 - k3 * k5 >> 15;
        //                    k3 = k7;
        //                    k3 += cN.e;
        //                    i5 = cN.f - i5;
        //                    if(bz == 1)
        //                        a(cO, cP, k3 / 128, i5 / 128, false);
        //                    bz = 0;
        //                }
        //                return;
        //            }
        //        }
    }
    public synchronized boolean keyDown(Event event, int i1)
    {
        if(ms)
        {
            if(i1 == Event.UP)
            {
                keyPressed(new KeyEvent(this,event.id,event.when,event.modifiers,KeyEvent.VK_UP));
            }
            else if(i1 == Event.DOWN)
            {
                keyPressed(new KeyEvent(this,event.id,event.when,event.modifiers,KeyEvent.VK_DOWN));
            }
            else
                super.keyDown(event,i1);
        }
        return false;
    }
    
    public void keyPressed(KeyEvent event)
    {
        if(event.getKeyCode() == KeyEvent.VK_F10)
        {
            ((Frame)SwingUtilities.getWindowAncestor(this)).setExtendedState(Frame.ICONIFIED);
            return;
        }
        int keycode = event.getKeyCode();
        int i1 = (int)event.getKeyChar();
        if (i1 == KeyEvent.VK_SHIFT ||
        i1 == KeyEvent.VK_CONTROL ||
        i1 == KeyEvent.VK_ALT)
            return;
        boolean flag;
        int j1;
        boolean flag1;
        flag1 = a.a.g.K;
        K = i1;
        L = i1;
        l = 0;
        switch(keycode)
        {
            case 37:z = true;return;
            case 39:A = true;return;
            case 40:B = true;return;
            case 38:C = true;return;
        }
        b(getOldEventKey(event));
        if((char)i1 == ' ')
            D = true;
        if((char)i1 == 'n' || (char)i1 == 'm')
            E = true;
        if((char)i1 == 'N' || (char)i1 == 'M')
            E = true;
        if((char)i1 == '{')
            x = true;
        if((char)i1 == '}')
            y = true;
        if((char)i1 == '\u03F0')
            M = !M;
        flag = false;
        j1 = 0;
        if(flag1)
            do
            {
                //_L1:
                if(event.getKeyChar() != w.charAt(j1))
                    continue;
                flag = true;
                if(!flag1)
                {
                    System.out.println("breaking");
                    break;
                }
                j1++;
                //_L2:
            }while(j1 < w.length());
        //        if(j1 < w.length()) goto _L1; else goto _L3
        flag = true;
        if(flag && N.length() < 20)
            N += (char)i1;
        if(flag && P.length() < 80)
            P += (char)i1;
        if(N == null)
        {
            N = "";
        }
            if(i1 == 8 && N.length() > 0)
                N = N.substring(0, N.length() - 1);
            if(i1 == 8 && P.length() > 0)
                P = P.substring(0, P.length() - 1);
        if(iH &&(i1 == 10 || i1 == 13))
        {
            System.out.println("sneding");
            N = N.trim();
            O = N;
            Q = P;
        }
    }
    boolean typingCommand = false;
    int typingLength = 0;
    String command = "";
    public void b(int i) //i is character
    {
        if(bQ == 0)
        {
            if(gD == 0)
                gE.b(i);
            if(gD == 1)
                gH.b(i);
            if(gD == 2)
                gP.b(i);
            if(gD == 3)
                hA.b(i);
        }
        if(bQ == 1)
        {
            if(il)
            {
                ha.b(i);
                return;
            }
            if(ho)
            {
                if(hs == -1)
                    hp.b(i);
                return;
            }
            if(hK)
            {
                hL.b(i);
                return;
            }
            if(gl == 0 && gi == 0 && gj == 0 && !iH)
            {
                if(i == 10 || i == 13)
                {
                    String command = a.a.Accessor.access_e_t(eG);
                    int unicode = command.indexOf("/u");
                    if(unicode != -1)
                    {
                        a.a.Accessor.access_e_t(eG,command.substring(0,unicode)+((char)Integer.parseInt(command.substring(unicode+2,unicode+6),16))+command.substring(unicode+6));
                    }
                    if(command.startsWith("/"))
                    {
                        if(executeCommand(command.substring(1)));
                        i = -1;
                    }
                }
                if(i == -1)
                {
                    a.a.Accessor.access_e_t(eG,"");
                }
                else
                    eG.b(i);
            }
            if(gl == 3 || gl == 4 || gl == 5 || gl == 7)
                gl = 0;
        }
    }
    /** Executes a command. Called when something is typed in that begins with '/'
     * @param command The command to execute (not including the '/')
     * @return true if the command should be remove from the command line after it is entered
     * in.
     * false if the command should stay on the line.
     */    
    public boolean executeCommand(final String command)
    {
        int paramIndex = command.indexOf(' ');
        final Macro macro;
        if(paramIndex == -1)
        {
            macro = (Macro)macros.get(command);
        }
        else
            macro = (Macro)macros.get(command.substring(0,paramIndex));
        if(macro != null)
        {
            Thread thread = new Thread(new Runnable()
            {
                public void run()
                {
                    macroOn = true;
                    macro.start(command);
                }
            });
            thread.start();
            return true;
        }
        /*if(command.equals("min"))
        {
            ((Frame)SwingUtilities.getWindowAncestor(this)).setState(Frame.ICONIFIED);
        }*/
        if(command.trim().equals("getpcs"))
        {
            for(int i = 0; i < cL.length;i++)
            {
                if(cL[i] != null)
                {
                    System.out.println("name:"+cL[i].b+" Level"+cL[i].x);
                }
            }
        }
        if(command.equals("stop"))
        {
            macroOn = false;
        }
        if(command.startsWith("page"))
        {
            fX = 256; 
            //gd = Integer.parseInt(command.substring("page ".length()).trim());
        }
        /*if(command.startsWith("autoeat"))
        {
            if(autoEatInstance == null)
            {
                autoEatInstance = new AutoEater(this);
            }
            if(autoEatThread == null)
            {
                autoEatThread = new Thread(autoEatInstance);
            }
            if(autoEatInstance.going)
            {
                d("AutoEater stopped");
                autoEatInstance.going = false;
            }
            else
            {
                d("Starting AutoEater");
                autoEatThread.start();
            }
        }*/
        if(command.equals("lo"))
        {
            super.Y.a(6, 156);
            super.Y.g();
            gy = 1000;
        }
        if(command.startsWith("world"))
        {
            int x = Integer.parseInt(command.substring("world ".length()).trim());
            changeWorld(x);
            return true;
        }
        /*
        if(command.trim().startsWith("attacklev"))
        {
            final int lev = Integer.parseInt(command.substring("attacklev ".length()));
            final Commander attackScript = new Commander(0,0,0,0, 0,715);
            Thread thread = new Thread(new Runnable()
            {
                public void run()
                {
                    macroOn = true;
                    while(macroOn)
                    {
                        if(dM >= 743)
                            sleeper.sleep();
                        while(dM >= 743)
                        {
                            try
                            {
                                Thread.sleep(1000);
                            }
                            catch(InterruptedException e)
                            {
                            }
                        }
                        int min = Integer.MAX_VALUE;
                        int minI = -1;
                        for(int i = 0;i < cW.length;i++)
                        {
                            if(cW[i] == null)
                                continue;
                            Thread.yield();
                            int npcLevel = (b.r[cW[i].g] + b.u[cW[i].g] + b.s[cW[i].g] + b.t[cW[i].g]) / 4;
                            if(b.v[cW[i].g] > 0 && npcLevel > 0 && npcLevel <= lev && cW[i].i != 8 && cW[i].i != 9)
                            {
                                int eval = Math.abs(cN.e-cW[i].e)+Math.abs(cN.f-cW[i].f);
                                if(eval < min)
                                {
                                    minI = i;
                                    min = eval;
                                }
                            }
                        }
                        if(minI != -1)
                        {
                            //System.out.println("attacking"+Math.random());
                            final int minD = minI;
                            attackScript.ew = cW[minD].e;
                            attackScript.ex = cW[minD].f;
                            attackScript.ey = cW[minD].c;
                            addLoopListener(attackScript);
                        }
                        else
                            System.out.println("can't find them");
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
                        }while(cN.i == 8 || cN.i == 9);
                    }
                }
            });
            thread.start();
        }*/
        if(command.equals("mkshield"))
        {
            final Object lock = new Object();
            final MessageListener l = new MessageListener()
            {
                public void messageRecieved(String msg,int filter)
                {
                    if(msg.indexOf("What would you like to make?") != -1)
                    {
                        while(!ge)
                            Thread.yield();
                        makeNpcChoice(1);
                        ge = false;
                    }
                    if(msg.indexOf("Choose a type of armour to make") != -1)
                    {
                        while(!ge)
                            Thread.yield();
                        makeNpcChoice(1);
                        ge = false;
                    }
                    if(msg.indexOf("What sort of shield do you want to make?") != -1)
                    {
                        while(!ge)
                            Thread.yield();
                        makeNpcChoice(1);
                        ge = false;
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
            Thread thread = new Thread(new Runnable()
            {
                public void run()
                {
                    start:
                    while(true)
                    {
                        if(d(169) >= 3)
                            while(cO+cr != 118 || cP+cs != 502)
                            {
                                walkTo(118,502);
                                try
                                {
                                    Thread.sleep(1000);
                                }
                                catch(InterruptedException e)
                                {
                                }
                            }
                        System.out.println("starting to make stuff");
                        addMessageListener(l);
                        while(d(169) >= 3)
                        {
                            ew[0] = 118-cr;
                            ex[0] = 501-cs;
                            //System.out.println(cs);
                            //System.out.println(cr);
                            ey[0] = 0;
                            ez[0] = 50;
                            for(int i = 0; i < dz;i++)
                            {
                                if(dA[i] == 169)
                                {
                                    eA[0] = i;
                                    break;
                                }
                            }
                            ev[0] = 410; //command
                            f(0);
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
                        removeMessageListener(l);
                        while((cO+cr < 100 &&cO+cr > 105)|| (cP+cs < 510 && cP+cs > 515))
                        {
                            try
                            {
                                    Thread.sleep(1000);
                                    walkTo(102, 512);
                            }
                            catch(InterruptedException e)
                            {
                            }
                        }
                        //get all the npcs on the screen
                        for(int i = 0; i < cW.length;i++)
                        {
                            c obj = cW[i];
                            //if This npc is a banker
                            if(obj != null && obj.g == 95)
                            {
                                while(!isChoice())
                                {
                                    //go talk to to him
                                    ew[0] = obj.e;
                                    ex[0] = obj.f;
                                    ev[0] = 720;
                                    ey[0] = obj.c;
                                    f(0);
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
                                ge = false;
                                makeNpcChoice(0);
                                try
                                {
                                        synchronized(fY)
                                        {
                                            fY.wait(5000);
                                        }
                                }
                                catch(InterruptedException e)
                                {
                                }
                                for(int j = 0; j < fY.length;j++)
                                {
                                    if(fY[j] == 128)
                                    {
                                        depositItem(d(fY[j]), j);
                                    }
                                }
                                int invleft = 30 - dz + d(128);
                                for(int j = 0; j < fY.length;j++)
                                {
                                    if(fY[j] == 169)
                                    {
                                        if(fZ[j] == 0)
                                            break start;
                                        int k = d(fY[j]);
                                        for(;k < invleft;k++)
                                            withdrawItem(1, j);
                                    }
                                }
                                fT = false;
                                break;
                            }
                        }
                    }
                }
            });
            thread.start();
            return true;
        }
        if(command.equals("smeltiron"))
        {
            final Object messageLock = new Object();
            MessageListener listener = new MessageListener()
            {
                public void messageRecieved(String message,int filter)
                {
                    synchronized(messageLock)
                    {
                        if(filter == 5)
                            messageLock.notifyAll();
                    }
                }
            };
            addMessageListener(listener);
            Thread thread = new Thread(new Runnable()
            {
                
                public void run()
                {
                    start:
                    while(true)
                    {
                    walkTo(84,679);
                    try
                    {
                        while(cO+cr != 84 && cP+cs != 679)
                            Thread.sleep(1000);
                    }
                    catch(InterruptedException e)
                    {
                    }
                    while(d(151) != 0)
                    {
                        if(getFatigue() >= 1.0)
                            sleeper.sleep();
                        ew[0] = 37;
                        ex[0] = 55;
                        ey[0] = 4;
                        ez[0] = 118;
                        for(int i = 0; i < dz;i++)
                        {
                            if(dA[i] == 151)
                            {
                                eA[0] = i;
                                break;
                            }
                        }
                        ev[0] = 410; //command
                        f(0);
                        try
                        {
                            Thread.sleep(2500+(int)Math.random()*100);
                        }
                        catch(InterruptedException e)
                        {
                        }
                    }
                    walkTo(88,695);
                    try
                    {
                        while(cO+cr != 88 && cP+cs != 695)
                            Thread.sleep(1000);
                    }
                    catch(InterruptedException e)
                    {
                    }
                        //get all the npcs on the screen
                        for(int i = 0; i < cW.length;i++)
                        {
                            c obj = cW[i];
                            //if This npc is a banker
                            if(obj != null && obj.g == 268)
                            {
                                while(!isChoice())
                                {
                                    //go talk to to him
                                    ew[i] = obj.e;
                                    ex[i] = obj.f;
                                    ev[i] = 720;
                                    ey[i] = obj.c;
                                    f(i);
                                    try
                                    {
                                        synchronized(messageLock)
                                        {
                                            messageLock.wait(500);
                                        }
                                    }
                                    catch(InterruptedException e)
                                    {
                                    }
                                }
                                ge = false;
                                makeNpcChoice(0);
                                try
                                {
                                        synchronized(fY)
                                        {
                                            fY.wait(5000);
                                        }
                                }
                                catch(InterruptedException e)
                                {
                                }
                                try
                                {
                                        synchronized(fY)
                                        {
                                            fY.wait(5000);
                                        }
                                }
                                catch(InterruptedException e)
                                {
                                }
                                for(int j = 0; j < fY.length;j++)
                                {
                                    if(fY[j] == 170)
                                    {
                                        depositItem(d(fY[j]), j);
                                    }
                                }
                                int invleft = 30 - dz + d(170);
                                for(int j = 0; j < fY.length;j++)
                                {
                                    if(fY[j] == 151)
                                    {
                                        if(fZ[j] == 0)
                                            break start;
                                        int k = d(fY[j]);
                                        for(;k < invleft;k++)
                                            withdrawItem(1, j);
                                    }
                                }
                                fT = false;
                                break;
                            }
                        }
                    }
                }
            });
            thread.start();
        }
        if(command.equals("smelt"))
        {
            final Object messageLock = new Object();
            MessageListener listener = new MessageListener()
            {
                public void messageRecieved(String message,int filter)
                {
                    synchronized(messageLock)
                    {
                        if(filter == 5)
                            messageLock.notifyAll();
                    }
                }
            };
            addMessageListener(listener);
            Thread thread = new Thread(new Runnable()
            {
                
                public void run()
                {
                    start:
                    while(true)
                    {
                    walkTo(84,679);
                    try
                    {
                        while(cO+cr != 84 && cP+cs != 679)
                            Thread.sleep(1000);
                    }
                    catch(InterruptedException e)
                    {
                    }
                    while(d(150) != 0 && d(202) != 0)
                    {
                        ew[0] = 37;
                        ex[0] = 55;
                        ey[0] = 4;
                        ez[0] = 118;
                        for(int i = 0; i < dz;i++)
                        {
                            if(dA[i] == 150 || dA[i] == 202)
                            {
                                eA[0] = i;
                                break;
                            }
                        }
                        ev[0] = 410; //command
                        f(0);
                        try
                        {
                            Thread.sleep(2500+(int)Math.random()*100);
                        }
                        catch(InterruptedException e)
                        {
                        }
                    }
                    walkTo(88,695);
                    try
                    {
                        while(cO+cr != 88 && cP+cs != 695)
                            Thread.sleep(1000);
                    }
                    catch(InterruptedException e)
                    {
                    }
                        //get all the npcs on the screen
                        for(int i = 0; i < cW.length;i++)
                        {
                            c obj = cW[i];
                            //if This npc is a banker
                            if(obj != null && obj.g == 268)
                            {
                                while(!isChoice())
                                {
                                    //go talk to to him
                                    ew[i] = obj.e;
                                    ex[i] = obj.f;
                                    ev[i] = 720;
                                    ey[i] = obj.c;
                                    f(i);
                                    try
                                    {
                                        synchronized(messageLock)
                                        {
                                            messageLock.wait(500);
                                        }
                                    }
                                    catch(InterruptedException e)
                                    {
                                    }
                                }
                                ge = false;
                                makeNpcChoice(0);
                                try
                                {
                                        synchronized(fY)
                                        {
                                            fY.wait(5000);
                                        }
                                }
                                catch(InterruptedException e)
                                {
                                }
                                try
                                {
                                        synchronized(fY)
                                        {
                                            fY.wait(5000);
                                        }
                                }
                                catch(InterruptedException e)
                                {
                                }
                                for(int j = 0; j < fY.length;j++)
                                {
                                    if(fY[j] == 169)
                                    {
                                        depositItem(d(fY[j]), j);
                                    }
                                }
                                int invleft = 30 - dz + d(169);
                                for(int j = 0; j < fY.length;j++)
                                {
                                    if(fY[j] == 202 || fY[j] == 150)
                                    {
                                        if(fZ[j] == 0)
                                            break start;
                                        int k = d(fY[j]);
                                        for(;k < invleft/2;k++)
                                            withdrawItem(1, j);
                                    }
                                }
                                fT = false;
                                break;
                            }
                        }
                    }
                }
            });
            thread.start();
        }
        if(command.equals("npcchoices"))
        {
            d("menu is:"+isChoice());
            return true;
        }
        if(command.equals("debug"))
        {
            //get all the npcs on the screen
            for(int i = 0; i < cW.length;i++)
            {
                final c obj = cW[i];
                //if This npc is a banker
                if(obj.g == 95)
                {
                    final boolean[] gotResponce = new boolean[]{false};
                    addMessageListener(new MessageListener()
                    {
                        public void questMessageRecieved(String message)
                        {
                            gotResponce[0] = true;
                            try
                            {
                                Thread.sleep(2000+(int)Math.random()*100);
                                makeNpcChoice(0);
                                Thread.sleep(2000+(int)Math.random()*100);
                            }
                            catch(InterruptedException e)
                            {
                            }
                            for(int i = 0; i < fX;i++)
                            {
                                if(fY[i] == 202 || fY[i] == 150)
                                    depositItem(d(fY[i]),i);
                            }
                            fT = false;
                            ge = false;
                            removeMessageListener(this);
                        }
                    });
                    //go talk to to him
                    final int j = i;
                    Thread thread = new Thread(new Runnable()
                    {
                        public void run()
                        {
                            //System.out.println("starting:"+gotResponce[0]);
                            while(!gotResponce[0])
                            {
                                //System.out.println(gotResponce[0]);
                                ew[j] = obj.e;
                                ex[j] = obj.f;
                                ev[j] = 720;
                                ey[j] = obj.c;
                                f(j);
                                try
                                {
                                    Thread.sleep(2000*(int)Math.random()*100);
                                }
                                catch(InterruptedException e)
                                {
                                }
                            }
                        }
                    });
                    thread.start();
                    break;
                }
            }
            return true;
        }
        if(command.equals("inv"))
        {
            for(int i = 0; i < dA.length;i++)
            {
                //System.out.print(dA[i]+" ");
            }
        }
        if(command.startsWith("count"))
        {
            int x = Integer.parseInt(command.substring("count ".length()).trim());
            d("you have "+d(x));
        }
        if (command.equals("test"))
        {
            addMessageListener(new MessageListener()
            {
                public void messageRecieved(String message,int filter)
                {
                    //System.out.println(message+" "+filter);
                }
            });
        }
        if(command.equals("powermine"))
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
            addMessageListener(listener);
            Thread thread = new Thread(new Runnable()
            {
                public void run()
                {
                    macroOn = true;
                    boolean topRock = true;
                    while(macroOn)
                    {
                        if(dM >= 10)
                        {
                            for(int i = 0; i < dA.length;i++)
                            {
                                if(dA[i] == 1263)
                                {
                                    Y.a(246, 237);
                                    Y.b(i);
                                    Y.g();
                                    Toolkit.getDefaultToolkit().beep();
                                    break;
                                }
                            }
                            while(!iH)
                            {
                                try
                                {
                                    Thread.sleep(500);
                                }
                                catch(InterruptedException e)
                                {
                                }
                            }
                            while(iH)
                            {
                                try
                                {
                                    Thread.sleep(500);
                                }
                                catch(InterruptedException e)
                                {
                                }
                            }
                        }
                        int tin = 0;
                        int copper = 0;
                        if(topRock)
                            mineRock(76,543,1,0);
                        else
                            mineRock(76,544,1,0);
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
                }
            });
            thread.start();
        }
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
            addMessageListener(listener);
            Thread thread = new Thread(new Runnable()
            {
                public void run()
                {
                    boolean topRock = false;
                    while(true)
                    {
                        while(dz < 30 /*&& b.h[dA[29]] != 1*/)
                        {
                            if(dM >= 700)
                                sleeper.sleep();
                            if(topRock)
                                mineRock(76,543,1,0);
                            else
                                mineRock(76,544,1,0);
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
                        try
                        {
                            if(!walkTo(102,512))
                            {
                                walkTo(70,531);
                                while(cO+cr != 70 && cP+cs != 531)
                                    Thread.sleep(1300+(int)(Math.random()*300));
                                walkTo(75,515);
                                while(cO+cr != 75 && cP+cs != 515)
                                    Thread.sleep(1300+(int)(Math.random()*300));
                                walkTo(90,509);
                                while(cO+cr != 90 && cP+cs != 509)
                                    Thread.sleep(1300+(int)(Math.random()*300));
                                walkTo(102,512);
                            }
                                while(cO+cr != 102 && cP+cs != 512)
                                    Thread.sleep(500+(int)(Math.random()*300));

                        }
                        catch(InterruptedException e)
                        {
                        }
                        //get all the npcs on the screen
                        for(int i = 0; i < cW.length;i++)
                        {
                            c obj = cW[i];
                            //if This npc is a banker
                            if(obj != null && obj.g == 95)
                            {
                                while(!isChoice())
                                {
                                    //go talk to to him
                                    ew[i] = obj.e;
                                    ex[i] = obj.f;
                                    ev[i] = 720;
                                    ey[i] = obj.c;
                                    f(i);
                                    try
                                    {
                                        synchronized(messageLock)
                                        {
                                            messageLock.wait(500);
                                        }
                                    }
                                    catch(InterruptedException e)
                                    {
                                    }
                                }
                                ge = false;
                                makeNpcChoice(0);
                                try
                                {
                                        synchronized(fY)
                                        {
                                            fY.wait(5000);
                                        }
                                }
                                catch(InterruptedException e)
                                {
                                }
                                for(int j = 0; j < fY.length;j++)
                                {
                                       //copper ore    tin ore         iron ore        gold            mithril ore     adamantite ore  coal            blurite ore     runite ore      uncut diamond   uncut ruby      uncut emerald   uncut sapphire
                                    if(fY[j] == 150 || fY[j] == 202 || fY[j] == 151 || fY[j] == 152 || fY[j] == 153 || fY[j] == 154 || fY[j] == 155 || fY[j] == 266 || fY[j] == 409 || fY[j] == 157 || fY[j] == 158 || fY[j] == 159 || fY[j] == 160)
                                    {
                                        depositItem(d(fY[j]), j);
                                    }
                                }
                                fT = false;
                                break;
                            }
                        }
                        //dz = 0;
                    }
                }
            });
            thread.start();
            return true;
        }
        if(command.startsWith("mine"))
        {
            int x = Integer.parseInt(command.substring("mine ".length(),command.indexOf(",")));
            int y = Integer.parseInt(command.substring(command.indexOf(",")+1));
            mineRock(x,y);
            return true;
        }
        if(command.startsWith("getpersonid"))
        {
            long x = Integer.parseInt(command.substring("getpersonid ".length()).trim());
            d("person name:"+a.f.a(x));
        }
        if(command.startsWith("finger"))
        {
            String name = command.substring("finger ".length());
            long ip = a.f.b(name);
            d(name+" is at:"+ip);
        }
        if(command.startsWith("tell"))
        {
            //StringTokenizer token = new StringTokenizer(command);
            String remaining = command.substring("tell ".length());
            int index = remaining.indexOf(' ');
            //System.out.println(index);
            String name = remaining.substring(0,index);
            String message = remaining.substring(index+1);
            //System.out.println(message);
            //String s2 = super.Q;
            //super.P = "";
            //super.Q = "";
            long personid = a.f.b(name);
            gi = 0;
            int j1 = a.h.a(message);
            a(personid, a.h.a, j1);
            message = a.h.a(a.h.a, 0, j1);
            //message = a.g.a(message);
            d("@pri@You tell " + a.f.a(personid) + ": " + message);
        }
        //goto x,y (must be within range of cordinates and they must be legal)
        if(command.startsWith("goto"))
        {
            int x = Integer.parseInt(command.substring("goto ".length(),command.indexOf(",")));
            int y = Integer.parseInt(command.substring(command.indexOf(",")+1));
            if(!walkTo(x,y))
            {
                d("out of range/inaccessable");
            }
            return true;
        }
        //shows the bank window (not that helpful since you can't use it), this will not
        //propagrate the bank window you must see a banker first to see anything using this
        //command, If you try and deposit or withdraw, nothing will happen
        if(command.equals("bank"))
        {
            fT = true;
            gz = 0;
            return true;
        }
        //when talking to a banker this will cause all the entier selected stack to be withdrawn
        if(command.equals("wtha") && fT && ga >= 1)
        {
            withdrawItem(fZ[ga],ga);
            return true;
        }
        //withdraw x item that are selected in the bank window
        if(command.startsWith("wth"))
        {
            int x = Integer.parseInt(command.substring("wth ".length()).trim());
            withdrawItem(x,ga);
        }
        //deposit all items that are selected
        if(command.equals("dpa") && fT && ga >= 1)
        {
            //System.out.println(ga);
            depositItem(d(fY[ga]),ga);
            return true;
        }
        //deposit x items
        if(command.startsWith("dp"))
        {
            int x = Integer.parseInt(command.substring("dp ".length()).trim());
            depositItem(x,ga);
            return true;
        }
        //Tells you how much of an item you have, x is the id of them item, it will tell
        //you the name of the item. (Coins are 10)
        if(command.startsWith("item"))
        {
            int x = Integer.parseInt(command.substring("item ".length()).trim());
            d("You have "+d(x)+" "+b.c[x]+"(s)");
        }
        //select an option when talking with an npc 0 is the first option
        if(command.startsWith("npco"))
        {
            int x = Integer.parseInt(command.substring("npco ".length()).trim());
            makeNpcChoice(x);
        }
        //displays your x,y location this can be entered into goto. Also tells you your
        //loading zone (zones do overlap)
        /*if(command.equals("loc"))
        {
            d("x:"+(cO+cr)+" y:"+ (cP+cs) +" (zone:" + cr/48 + " "+cs/48+")");
            return true;
        }*/
        if(command.startsWith("bones"))
        {
            new Thread(new Runnable()
            {
                public void run()
                {
                    while(d(20) != 0)
                    {
                        synchronized(Y)
                        {
                            Y.a(246, 237);
                            Y.b(19);
                            Y.g();
                        }
                        try
                        {
                            Thread.sleep(1500);
                        }
                        catch(InterruptedException e)
                        {
                        }
                    }
                }
            }).start();
        }
        return true;
    }
    /*public void m()
    {
        long l1 = System.currentTimeMillis();
        //        if(Y.i())
        //            bb = l1;
        //        if(l1 - bb > 5000L)
        //        {
        //            bb = l1;
        //            Y.a(5, 348);
        //            Y.g();
        //        }
        try
        {
            Y.d(20);
        }
        catch(java.io.IOException _ex)
        {
            l();
            return;
        }
        if(!t())
            return;
        int i = Y.a(a.a.Accessor.access_b_Z(this));
        if(i > 0)
            a(a.a.Accessor.access_b_Z(this)[0] & 0xff, i);
        //System.out.println("calling a(int,int):"+(a.a.Accessor.access_b_Z(this)[0] & 0xff)+','+i);
        
    }*/
    
    
    public void keyReleased(KeyEvent e)
    {
        int i1 = e.getKeyCode();
        K = 0;
        if(i1 == 37)
            z = false;
        if(i1 == 39)
            A = false;
        if(i1 == 40)
            B = false;
        if(i1 == 38)
            C = false;
        if((char)i1 == ' ')
            D = false;
        if((char)i1 == 'n' || (char)i1 == 'm')
            E = false;
        if((char)i1 == 'N' || (char)i1 == 'M')
            E = false;
        if((char)i1 == '{')
            x = false;
        if((char)i1 == '}')
            y = false;
    }
    
    public void keyTyped(KeyEvent e)
    {
    }
    
    public void mouseClicked(MouseEvent e)
    {
    }
    
    public void mouseEntered(MouseEvent e)
    {
    }
    
    public void mouseExited(MouseEvent e)
    {
    }
    
    public void mousePressed(MouseEvent event)
    {
        int i1 = event.getX();
        int j1 = event.getY();
        label0:
        {
            G = i1;
            H = j1 + k;
            if(event.isMetaDown())
            {
                I = 2;
                if(!a.a.g.K)
                    break label0;
            }
            I = 1;
        }
        J = I;
        l = 0;
        a(I, i1, j1);
    }
    
    public void mouseReleased(MouseEvent e)
    {
        G = e.getX();
        H = e.getY() + k;
        I = 0;
    }
    
    public void mouseDragged(MouseEvent e)
    {
        label0:
        {
            G = e.getX();
            H = e.getY() + k;
            if(e.isMetaDown())
            {
                I = 2;
                if(!a.a.g.K)
                    break label0;
            }
            I = 1;
        }
    }
    
    public void mouseMoved(MouseEvent e)
    {
        G = e.getX();
        H = e.getY() + k;
        I = 0;
        l = 0;
    }
    static int getOldEventKey(KeyEvent e)
    {
        int keyCode = e.getKeyCode();
        for (int i = 0; i < actionKeyCodes.length; i++)
        {
            if (actionKeyCodes[i][0] == keyCode)
            {
                return actionKeyCodes[i][1];
            }
        }
        return (int)e.getKeyChar();
    }
    
    public void q()
    {
        super.q();
    }
    
    public void V()
    {
        super.V();
    }
    
    public void v()
    {
        super.v();
    }
    
    public boolean e(int param)
    {
        boolean retValue;
        
        retValue = super.e(param);
        return retValue;
    }
    
    public void U()
    {
        //autologout happens after 4500
        //if cannot logout (maybe in battle) then subtract 500
        if(true)
        {
            l = 500;
        }
        super.U();
    }
    public void m()
    {
        long l1 = System.currentTimeMillis();
        if(Y.i())
            a.a.Accessor.access_b_bb(this,l1);
        if(l1 - a.a.Accessor.access_b_bb(this) > 5000L)
        {
            a.a.Accessor.access_b_bb(this,l1);
            Y.a(5, 348);
            Y.g();
        }
        try
        {
            Y.d(20);
        }
        catch(IOException _ex)
        {
            l();
            return;
        }
        if(!t())
            return;
        int i = Y.a(a.a.Accessor.access_b_Z(this));
        if(i > 0)
            a(a.a.Accessor.access_b_Z(this)[0] & 0xff, i);
    }
    public void u()
    {
        super.u();
    }
    
    public int d(int param)
    {
        int retValue;
        
        retValue = super.d(param);
        return retValue;
    }
    
    public void e(String str)
    {
        System.out.println("e called:"+str);
        System.out.println(el);
        super.e(str);
    }
    
    public void b(final String str, final int param) //display a message to the user param is filter
    {
        //System.out.println("b called:" +str+":"+param);
        Thread thread = new Thread(new Runnable()
        {
            public void run()
            {
                fireMessageEvent(str,param);
            }
        });
        thread.start();
        super.b(str, param);
    }
    
    public void bs()
    {
        super.bs();
    }
    
    public void z()
    {
        super.z();
    }
    
    public void d()
    {
        super.d();
    }
    
    public void d(String str, String str1)
    {
        super.d(str, str1);
    }
    
    public void d(int i, int i1, int j1, int k1, int l1, int i2, int j2) //pc drawing?
    {
        c c1;
        int k2;
        boolean flag;
        int l2;
        int i3;
        int j3;
        int j7;
label0:
        {
            j7 = b.bN;
            c1 = cL[l1];
            if(c1.A == 255)
                return;
            k2 = c1.i + (cE + 16) / 32 & 7;
            flag = false;
            l2 = k2;
            if(l2 == 5)
            {
                l2 = 3;
                flag = true;
                if(j7 == 0)
                    break label0;
            }
            if(l2 == 6)
            {
                l2 = 2;
                flag = true;
                if(j7 == 0)
                    break label0;
            }
            if(l2 == 7)
            {
                l2 = 1;
                flag = true;
            }
        }
label1:
        {
            i3 = l2 * 3 + ix[(c1.h / 6) % 4];
            if(c1.i == 8)
            {
                l2 = 5;
                k2 = 2;
                flag = false;
                i -= (5 * j2) / 100;
                i3 = l2 * 3 + iy[(bx / 5) % 8];
                if(j7 == 0)
                    break label1;
            }
            if(c1.i == 9)
            {
                l2 = 5;
                k2 = 2;
                flag = true;
                i += (5 * j2) / 100;
                i3 = l2 * 3 + iz[(bx / 6) % 8];
            }
        }
        j3 = 0;
        boolean startLoop = true;
        while(true)
        {
            if(!startLoop || j7 != 0)
            {
                for(;j3 <12;j3++)
                {
                startLoop = false;
                int k4;
                int j5;
                int l5;
                int i6;
        label2:
                {
                    int k3 = ik[k2][j3];
                    k4 = c1.o[k3] - 1;
                    if(k4 < 0)
                        continue;
                    j5 = 0;
                    l5 = 0;
                    i6 = i3;
                    if(!flag || l2 < 1 || l2 > 3)
                        break label2;
                    if(b.O[k4] == 1)
                    {
                        i6 += 15;
                        if(j7 == 0)
                            break label2;
                    }
                    if(k3 == 4 && l2 == 1)
                    {
                        j5 = -22;
                        l5 = -3;
                        i6 = l2 * 3 + ix[(2 + c1.h / 6) % 4];
                        if(j7 == 0)
                            break label2;
                    }
                    if(k3 == 4 && l2 == 2)
                    {
                        j5 = 0;
                        l5 = -8;
                        i6 = l2 * 3 + ix[(2 + c1.h / 6) % 4];
                        if(j7 == 0)
                            break label2;
                    }
                    if(k3 == 4 && l2 == 3)
                    {
                        j5 = 26;
                        l5 = -5;
                        i6 = l2 * 3 + ix[(2 + c1.h / 6) % 4];
                        if(j7 == 0)
                            break label2;
                    }
                    if(k3 == 3 && l2 == 1)
                    {
                        j5 = 22;
                        l5 = 3;
                        i6 = l2 * 3 + ix[(2 + c1.h / 6) % 4];
                        if(j7 == 0)
                            break label2;
                    }
                    if(k3 == 3 && l2 == 2)
                    {
                        j5 = 0;
                        l5 = 8;
                        i6 = l2 * 3 + ix[(2 + c1.h / 6) % 4];
                        if(j7 == 0)
                            break label2;
                    }
                    if(k3 == 3 && l2 == 3)
                    {
                        j5 = -26;
                        l5 = 5;
                        i6 = l2 * 3 + ix[(2 + c1.h / 6) % 4];
                    }
                }
                int j6;
                int k6;
                int l6;
                int i7;
        label3:
                {
                    if(l2 == 5 && b.N[k4] != 1)
                        continue;
                    j6 = i6 + b.P[k4];
                    j5 = (j5 * j1) / ((a.a.g) (bO)).r[j6];
                    l5 = (l5 * k1) / ((a.a.g) (bO)).s[j6];
                    k6 = (j1 * ((a.a.g) (bO)).r[j6]) / ((a.a.g) (bO)).r[b.P[k4]];
                    j5 -= (k6 - j1) / 2;
                    l6 = b.L[k4];
                    i7 = iw[c1.B];
                    if(l6 == 1)
                    {
                        l6 = iv[c1.y];
                        if(j7 == 0)
                            break label3;
                    }
                    if(l6 == 2)
                    {
                        l6 = iu[c1.z];
                        if(j7 == 0)
                            break label3;
                    }
                    if(l6 == 3)
                        l6 = iu[c1.A];
                }
                bO.a(i + j5, i1 + l5, k6, k1, j6, l6, i7, i2, flag); //draws the players sprite
                //j3++;
                }
            }
            startLoop = false;
    _L2:
            if(j3 >= 12)
            {
    label4:
                {
    label5:
                    {
                        int l3;
    label6:
                        {
                            if(c1.q > 0)
                            {
                                hW[hS] = bO.a(c1.p, 1) / 2;
                                if(hW[hS] > 150)
                                    hW[hS] = 150;
                                hX[hS] = (bO.a(c1.p, 1) / 300) * bO.c(1);
                                hU[hS] = i + j1 / 2;
                                hV[hS] = i1;
                                hT[hS++] = c1.p;
                            }
                            if(c1.s > 0)
                            {
                                hZ[hY] = i + j1 / 2;
                                ia[hY] = i1;
                                ib[hY] = j2;
                                ic[hY++] = c1.r;
                            }
                            if(c1.i != 8 && c1.i != 9 && c1.w == 0)
                                break label4;
                            if(c1.w <= 0)
                                break label5;
                            l3 = i;
                            if(c1.i == 8)
                            {
                                l3 -= (20 * j2) / 100;
                                if(j7 == 0)
                                    break label6;
                            }
                            if(c1.i == 9)
                                l3 += (20 * j2) / 100;
                        }
                        int l4 = (c1.u * 30) / c1.v;
                        ie[id] = l3 + j1 / 2;
                        ig[id] = i1;
                        ih[id++] = l4;//current hp % (30 is max)
                    }
                    int i4;
    label7:
                    {
                        if(c1.w <= 150)
                            break label4;
                        i4 = i;
                        if(c1.i == 8)
                        {
                            i4 -= (10 * j2) / 100;
                            if(j7 == 0)
                                break label7;
                        }
                        if(c1.i == 9)
                            i4 += (10 * j2) / 100;
                    }
                    bO.c((i4 + j1 / 2) - 12, (i1 + k1 / 2) - 12, bU + 11); //draws the bubble around the damage
                    bO.b(String.valueOf(c1.t), (i4 + j1 / 2) - 1, i1 + k1 / 2 + 5, 3, 0xffffff); //draws damage
                }
    label8:
                {
                    int j4;
    label9:
                    {
                        if(c1.I != 1 || c1.s != 0)
                            break label8;
                        j4 = i2 + i + j1 / 2;
                        if(c1.i == 8)
                        {
                            j4 -= (20 * j2) / 100;
                            if(j7 == 0)
                                break label9;
                        }
                        if(c1.i == 9)
                            j4 += (20 * j2) / 100;
                    }
                    int i5 = (16 * j2) / 100;
                    int k5 = (16 * j2) / 100;
                    bO.f(j4 - i5 / 2, i1 - k5 / 2 - (10 * j2) / 100, i5, k5, bU + 13);
                }
                return;
            }
        }
        //if(true) goto _L1; else goto _L3
//_L3:
    }
    
    public boolean a(int i, int i1, int j1, int k1, int l1, int i2, boolean flag,
    boolean flag1) //a(currentx,currenty,destx,desty,destx,desty,false,false)
    {
        //System.out.println("a is called:"+i+" "+i1+" "+j1+" "+k1+" "+l1+" "+i2+" "+flag+" "+flag1);
        int j2;
        int k2;
        int l2;
        label0:
        {
            l2 = b.bN;
            j2 = cm.a(i, i1, j1, k1, l1, i2, bB, bC, flag);
            if(j2 == -1)
                return false;
            j2--;
            i = bB[j2];
            i1 = bC[j2];
            j2--;
            if(flag1)
            {
                super.Y.a(215, 592);
                if(l2 == 0)
                    break label0;
            }
            //System.out.println("walking");
            super.Y.a(194, 770); //walk to command
        }
        //System.out.println("i:"+i+" cr:"+cr);
        super.Y.b(i + cr);
        //System.out.println("i1:"+i1+" cs:"+cs);
        super.Y.b(i1 + cs);
        k2 = j2;
        // if(l2 == 0) goto _L2; else goto _L1
        //_L1:
        if(l2 != 0)
        {
            //System.out.println("k2:"+k2+" i:"+i);
            super.Y.a(bB[k2] - i);
            //System.out.println("k2:"+k2+" i1:"+i1);
            super.Y.a(bC[k2] - i1);
            k2--;
        }
        //_L2:
        while(true)
        {
            if(k2 < 0 || k2 <= j2 - 25)
            {
                //System.out.println("go");
                super.Y.g();
                cj = -24;
                ck = super.G;
                cl = super.H;
                return true;
            }
            //System.out.println("k2:"+k2+" i:"+i);
            super.Y.a(bB[k2] - i);
            //System.out.println("k2:"+k2+" i1:"+i1);
            super.Y.a(bC[k2] - i1);
            k2--;
        }
        //        if(true) goto _L1; else goto _L3
        //_L3:
    }
    
    public void a(int param, int param1, int param2, int param3, boolean param4)
    {
        super.a(param, param1, param2, param3, param4);
    }
    
    public void R()
    {
        super.R();
    }
    
    public void w()
    {
        super.w();
    }
    
    public void f(int i) //send a command
    {
        int i1 = ew[i];
        int j1 = ex[i];
        int k1 = ey[i];
        int l1 = ez[i];
        int i2 = eA[i];
        int j2 = ev[i]; //event id
        if(Main.DEBUG)
            System.out.println("f"+i1+" "+j1+" "+k1+" "+l1+" "+i2+" "+j2+" "+i);
        if(j2 == 200)
        {
            b(cO, cP, i1, j1, true);
            super.Y.a(224, 821);
            super.Y.b(i1 + cr);
            super.Y.b(j1 + cs);
            super.Y.b(k1);
            super.Y.b(l1);
            super.Y.g();
            dW = -1;
        }
        if(j2 == 210)
        {
            b(cO, cP, i1, j1, true);
            super.Y.a(250, 346);
            super.Y.b(i1 + cr);
            super.Y.b(j1 + cs);
            super.Y.b(k1);
            super.Y.b(l1);
            super.Y.g();
            dD = -1;
        }
        if(j2 == 220)
        {
            b(cO, cP, i1, j1, true);
            super.Y.a(252, 634);
            super.Y.b(i1 + cr);
            super.Y.b(j1 + cs);
            super.Y.b(k1);
            super.Y.g();
        }
        if(j2 == 3200)
            b(b.d[k1], 3);
        if(j2 == 300)
        {
            c(i1, j1, k1);
            super.Y.a(223, 596);
            super.Y.b(i1 + cr);
            super.Y.b(j1 + cs);
            super.Y.a(k1);
            super.Y.b(l1);
            super.Y.g();
            dW = -1;
        }
        if(j2 == 310)
        {
            c(i1, j1, k1);
            super.Y.a(239, 792);
            super.Y.b(i1 + cr);
            super.Y.b(j1 + cs);
            super.Y.a(k1);
            super.Y.b(l1);
            super.Y.g();
            dD = -1;
        }
        if(j2 == 320)
        {
            c(i1, j1, k1);
            super.Y.a(238, 212);
            super.Y.b(i1 + cr);
            super.Y.b(j1 + cs);
            super.Y.a(k1);
            super.Y.g();
        }
        if(j2 == 2300)
        {
            c(i1, j1, k1);
            super.Y.a(229, 726);
            super.Y.b(i1 + cr);
            super.Y.b(j1 + cs);
            super.Y.a(k1);
            super.Y.g();
        }
        if(j2 == 3300)
            b(b.bc[k1], 3);
        if(j2 == 400)
        {
            c(i1, j1, k1, l1);
            super.Y.a(222, 555);
            super.Y.b(i1 + cr);
            super.Y.b(j1 + cs);
            super.Y.b(i2);
            super.Y.g();
            dW = -1;
        }
        if(j2 == 410)
        {
            c(i1, j1, k1, l1);
            super.Y.a(241, 772);
            super.Y.b(i1 + cr);
            super.Y.b(j1 + cs);
            super.Y.b(i2);
            super.Y.g();
            dD = -1;
        }
        if(j2 == 420)
        {
            //System.out.println("i1:"+i1+" j1:"+j1+" k1:"+k1+" l1:"+l1);
            c(i1, j1, k1, l1);
            super.Y.a(242, 863);
            super.Y.b(i1 + cr);
            super.Y.b(j1 + cs);
            super.Y.g();
        }
        if(j2 == 2400)
        {
            c(i1, j1, k1, l1);
            super.Y.a(230, 67);
            super.Y.b(i1 + cr);
            super.Y.b(j1 + cs);
            super.Y.g();
        }
        if(j2 == 3400)
            b(b.S[k1], 3);
        if(j2 == 600)
        {
            super.Y.a(220, 567);
            super.Y.b(k1);
            super.Y.b(l1);
            super.Y.g();
            dW = -1;
        }
        if(j2 == 610)
        {
            super.Y.a(240, 377);
            super.Y.b(k1);
            super.Y.b(l1);
            super.Y.g();
            dD = -1;
        }
        if(j2 == 620)
        {
            super.Y.a(248, 466);
            super.Y.b(k1);
            super.Y.g();
        }
        if(j2 == 630)
        {
            super.Y.a(249, 267);
            super.Y.b(k1);
            super.Y.g();
        }
        if(j2 == 640)
        {
            super.Y.a(246, 237);
            super.Y.b(k1);
            super.Y.g();
        }
        if(j2 == 650)
        {
            dD = k1;
            dx = 0;
            dE = b.c[dA[dD]];
        }
        if(j2 == 660)
        {
            super.Y.a(251, 664);
            super.Y.b(k1);
            super.Y.g();
            dD = -1;
            dx = 0;
            b("Dropping " + b.c[dA[k1]], 4);
        }
        if(j2 == 3600)
            b(b.d[k1], 3);
        if(j2 == 700)
        {
            int k2 = (i1 - 64) / bP;
            int k4 = (j1 - 64) / bP;
            a(cO, cP, k2, k4, true);
            super.Y.a(225, 824);
            super.Y.b(k1);
            super.Y.b(l1);
            super.Y.g();
            dW = -1;
        }
        if(j2 == 710)
        {
            int l2 = (i1 - 64) / bP;
            int l4 = (j1 - 64) / bP;
            a(cO, cP, l2, l4, true);
            super.Y.a(243, 876);
            super.Y.b(k1);
            super.Y.b(l1);
            super.Y.g();
            dD = -1;
        }
        if(j2 == 720)
        {
            int i3 = (i1 - 64) / bP;
            int i5 = (j1 - 64) / bP;
            a(cO, cP, i3, i5, true);
            super.Y.a(245, 586);
            super.Y.b(k1);
            super.Y.g();
        }
        if(j2 == 725)
        {
            int j3 = (i1 - 64) / bP;
            int j5 = (j1 - 64) / bP;
            a(cO, cP, j3, j5, true);
            super.Y.a(195, 543);
            super.Y.b(k1);
            super.Y.g();
        }
        if(j2 == 715 || j2 == 2715)
        {
            int k3 = (i1 - 64) / bP;
            int k5 = (j1 - 64) / bP;
            a(cO, cP, k3, k5, true);
            super.Y.a(244, 754);
            super.Y.b(k1);
            super.Y.g();
        }
        if(j2 == 3700)
            b(b.p[k1], 3);
        if(j2 == 800)
        {
            int l3 = (i1 - 64) / bP;
            int l5 = (j1 - 64) / bP;
            a(cO, cP, l3, l5, true);
            super.Y.a(226, 117);
            super.Y.b(k1);
            super.Y.b(l1);
            super.Y.g();
            dW = -1;
        }
        if(j2 == 810)
        {
            int i4 = (i1 - 64) / bP;
            int i6 = (j1 - 64) / bP;
            a(cO, cP, i4, i6, true);
            super.Y.a(219, 145);
            super.Y.b(k1);
            super.Y.b(l1);
            super.Y.g();
            dD = -1;
        }
        if(j2 == 805 || j2 == 2805)
        {
            int j4 = (i1 - 64) / bP;
            int j6 = (j1 - 64) / bP;
            a(cO, cP, j4, j6, true);
            super.Y.a(228, 414);
            super.Y.b(k1);
            super.Y.g();
        }
        if(j2 == 2806)
        {
            super.Y.a(204, 273);
            super.Y.b(k1);
            super.Y.g();
        }
        if(j2 == 2810)
        {
            super.Y.a(235, 636);
            super.Y.b(k1);
            super.Y.g();
        }
        if(j2 == 2820)
        {
            super.Y.a(214, 596);
            super.Y.b(k1);
            super.Y.g();
        }
        if(j2 == 900)
        {
            a(cO, cP, i1, j1, true);
            super.Y.a(221, 545);
            super.Y.b(i1 + cr);
            super.Y.b(j1 + cs);
            super.Y.b(k1);
            super.Y.g();
            dW = -1;
        }
        if(j2 == 920)
        {
            a(cO, cP, i1, j1, false);
            if(cj == -24)
                cj = 24;
        }
        if(j2 == 1000)
        {
            super.Y.a(227, 411);
            super.Y.b(k1);
            super.Y.g();
            dW = -1;
        }
        if(j2 == 4000)
        {
            dD = -1;
            dW = -1;
        }
    }
    
    public byte[] a(String s1, String s2, int i)
    {
        if(s1.equals("sounds1.mem"))
            Thread.dumpStack();
        byte[] retValue;
         byte abyte0[];
        int i1;
        int j1;
        byte abyte1[];
        if(!bw)
            s1 = "../release/" + s1;
        abyte0 = link.getjag(s1);
        if(abyte0 == null)
            return null;
        i1 = ((abyte0[0] & 0xff) << 16) + ((abyte0[1] & 0xff) << 8) + (abyte0[2] & 0xff);
        j1 = ((abyte0[3] & 0xff) << 16) + ((abyte0[4] & 0xff) << 8) + (abyte0[5] & 0xff);
        abyte1 = new byte[abyte0.length - 6];
        for(int k1 = 0; k1 < abyte0.length-6;k1++)
            abyte1[k1] = abyte0[k1 + 6];
        b(i, "Unpacking " + s2);
        if(j1 != i1)
        {
            byte abyte2[] = new byte[i1];
            a.b.a(abyte2, i1, abyte1, j1, 0);
            retValue =  abyte2;
        } else
        {
            retValue = abyte1;
        }
        
        if(!new java.io.File("deenocde/"+s1).exists())
        {
            try
            {
                java.io.File file = new java.io.File("deencode");
                if(!file.exists())
                    file.mkdir();
                file = new java.io.File(file,s1);
                System.out.println("making file:"+file);
                FileOutputStream out = new FileOutputStream(file);
                out.write(abyte0[0]);
                out.write(abyte0[1]);
                out.write(abyte0[2]);
                out.write(abyte0[0]);
                out.write(abyte0[1]);
                out.write(abyte0[2]);                
                out.write(retValue);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return retValue;
    }
    
    public Socket a(String s1, int i)
    throws IOException
    {
        Socket socket1;
        label0:
        {
            if(link.mainapp != null)
            {
                Socket socket = link.opensocket(i);
                if(socket == null)
                    throw new IOException();
                else
                    return socket;
            }
            if(f())
            {
                socket1 = new Socket(InetAddress.getByName(getCodeBase().getHost()), i);
                if(b.bN == 0)
                    break label0;
            }
            socket1 = new Socket(InetAddress.getByName(s1), i);
        }
        socket1.setSoTimeout(30000);
        socket1.setTcpNoDelay(true);
        return socket1;
    }
    
    public void c(boolean param)
    {
        super.c(param);
    }
    
    public void b(boolean param)
    {
        super.b(param);
    }
    
    public void a(boolean param)
    {
        super.a(param);
    }
    
    public void y()
    {
        super.y();
    }
    
    public java.awt.Image createImage(int param, int param1)
    {
        java.awt.Image retValue;
        
        retValue = super.createImage(param, param1);
        return retValue;
    }
    
    public void x()
    {
        super.x();
    }
    
    public String getParameter(String str)
    {
        String retValue;
        
        retValue = super.getParameter(str);
        return retValue;
    }
    
    public void bo()
    {
        super.bo();
    }
    
    public void W()
    {
        super.W();
    }
    
    public void bp()
    {
        super.bp();
    }
    
    public String g(int param)
    {
        String retValue;
        
        retValue = super.g(param);
        return retValue;
    }
    
    public void bi()
    {
        super.bi();
    }
    
    public void A()
    {
        try
        {
            iA = a("sounds" + e.i + ".mem", "Sound effects", 90);
            iB = new a.a.d()
            {
                public void a(byte abyte0[], int i, int j)
                {
                    System.out.println("calling a");
                    super.a(abyte0,i,j);
                }
            };
            return;
        }
        catch(Throwable throwable)
        {
            System.out.println("Unable to init sounds:" + throwable);
        }
    }
    
    public void bf()
    {
        super.bf();
    }
    
    public void s()
    {
        super.s();
    }
    
    public void X()
    {
        if(cO > 100 || cO < 0)
            cO = 50;
        if(cP > 100 || cP < 0)
            cP = 50;
        super.X();
    }
    
    public void a(Runnable runnable)
    {
        super.a(runnable);
    }
    
    public void r()
    {
        super.r();
    }
    
    public void be()
    {
        displayMessage("@pri@System message:"+gx);
        System.out.println("System message:"+gx);
        gw = false;
        //super.be();
    }
    
    public void C()
    {
        super.C();
    }
    
    public void bh()
    {
        super.bh();
    }
    
    public void l()
    {
        super.l();
    }
    
    public void L()
    {
        super.L();
    }
    
    public java.net.URL getCodeBase()
    {
        java.net.URL retValue;
        
        retValue = super.getCodeBase();
        return retValue;
    }
    
    public java.net.URL getDocumentBase()
    {
        java.net.URL retValue;
        
        retValue = super.getDocumentBase();
        return retValue;
    }
    
    public void J()
    {
        super.J();
    }
    
    public void br()
    {
        super.br();
    }
    
    public void O()
    {
        super.O();
    }
    
    public void p()
    {
        super.p();
    }
    
    public void P()
    {
        super.P();
    }
    
    public boolean c(int param)
    {
        boolean retValue;
        
        retValue = super.c(param);
        return retValue;
    }
    
    public void b(int param, int param1, int param2, int param3, boolean param4)
    {
        super.b(param, param1, param2, param3, param4);
    }
    
    public void I()
    {
        super.I();
    }
    
    public void bg()
    {
        System.out.println("wilderness warning");
        gB = 0;
        //super.bg();
    }
    
    public void a(int param, int param1, int param2, int param3, int param4, int param5, int param6)
    {
        super.a(param, param1, param2, param3, param4, param5, param6);
    }
    
    public c a(int param, int param1, int param2, int param3, int param4)
    {
        c retValue;
        
        retValue = super.a(param, param1, param2, param3, param4);
        return retValue;
    }
    
    public void a(int param, int param1, int param2) //handel mouse click?
    {
        //System.out.println("a called:"+param+","+param1+","+param2);
        super.a(param, param1, param2);
    }
     public void _a()
    {
        int i;
        int i1;
        if(bw)
        {
            String s1 = getDocumentBase().getHost().toLowerCase();
            if(!s1.endsWith("jagex.com") && !s1.endsWith("jagex.co.uk") && !s1.endsWith("runescape.com") && !s1.endsWith("runescape.co.uk") && !s1.endsWith("runescape.net") && !s1.endsWith("runescape.org") && !s1.endsWith("penguin") && !s1.endsWith("puffin"))
            {
                bt = true;
                return;
            }
        }
        a(br, bs);
        i = 0;
        i1 = 0;
        boolean startLoop = true;
        while(true)
        {
            if(!startLoop || b.bN != 0)
            {
                int j1 = i1 + 1;
                int l1 = (int)((double)j1 + 300D * Math.pow(2D, (double)j1 / 7D));
                i += l1;
                dF[i1] = i & 0xffffffc;
                i1++;
            }
            startLoop = false;
            
        if(i1 >= 99)
        {
            try
            {
                String s2 = getParameter("member");
                int i2 = Integer.parseInt(s2);
                if(i2 == 1)
                    bq = true;
            }
            catch(Exception _ex) { }
            if(bw)
                super.V = 43594;
            super.k = 0;
            a.a.b.T = 1000;
            a.a.b.S = e.b;
            try
            {
                String s3 = getParameter("poff");
                int j2 = Integer.parseInt(s3);
                super.V += j2;
                System.out.println("Offset: " + j2);
            }
            catch(Exception _ex) { }
            u();
            if(bv)
                return;
            bU = 2000;
            bV = bU + 100;
            bW = bV + 50;
            ca = bW + 1000;
            bX = ca + 10;
            bY = bX + 50;
            bZ = bY + 10;
            bM = getGraphics();
            ((a.a.a)this).a(50);
            bO = new d(bR, bS + 12, 4000, this)
            {
                public void a(int i1, int j1, int k1, int l1, int i2)
                {
                    //System.out.println("a.a.g.a(int,int,int,int,int) called");
                    super.a(i1,j1,k1,l1,i2);
                }
                public void a(int i1, int j1, int k1, int l1, int i2, int j2) //draw the background of a box
                {
                    //System.out.println("a.a.g.a(int,int,int,int,int,int) called");
                    super.a(i1,j1,k1,l1,i2,j2);
                }
                public void b(int i1, int j1, int k1, int l1, int i2, int j2) //used in login screen to draw background of buttons
                {
                    //System.out.println("a.a.g.b(int,int,int,int,int,int)");
                    super.b(i1,j1,k1,l1,i2,j2);
                }
                public void b(int i1, int j1, int k1, int l1, int i2) //used to paint message background
                {
                    //System.out.println("a.a.g.b(int,int,int,int,int)");
                    super.b(i1,j1,k1,l1,i2);
                }
                public void c(int i1, int j1, int k1, int l1, int i2) //used to draw message boarder
                {
                    //System.out.println("a.a.g.c(int,int,int,int,int)");
                    super.c(i1,j1,k1,l1,i2);
                }
                public void b(int i1, int j1, int k1, int l1) //more background stuff
                {
                    //System.out.println("a.a.g.b(int,int,int,int)");
                    super.b(i1,j1,k1,l1);
                }
                public void c(int i1, int j1, int k1, int l1) //line stuff
                {
                    //System.out.println("a.a.g.c(int,int,int,int,int)");
                    super.c(i1,j1,k1,l1);
                }
                public void c(int i1, int j1, int k1, int l1, int i2, int j2)
                {
                    //System.out.println("a.a.g.c(int,int,int,int,int,int)");
                    super.c(i1,j1,k1,l1,i2,j2);
                }
                public void c(int i1,int i2,int i3)
                {
                    //System.out.println("c:"+i1+" "+i2+" "+i3);
                    super.c(i1,i2,i3);
                }
                public void e(int i1, int j1, int k1, int l1, int i2)
                {
                    //System.out.println("a.a.g.e(int,int,int,int,int)");
                    super.e(i1,j1,k1,l1,i2);
                }
                public void f(int i1, int j1, int k1, int l1, int i2)
                {
                    //System.out.println("a.a.g.f(int,int,int,int,int)");
                    super.f(i1,j1,k1,l1,i2);
                }
                public void d(int i1, int j1, int k1, int l1) //unlist option icons
                {
                    //System.out.println("a.a.g.d(int,int,int,int)");
                    super.d(i1,j1, k1,l1);
                }
                public void d(int i1, int j1, int k1, int l1, int i2, int j2)
                {
                    //System.out.println("a.a.g.d(int,int,int,int,int,int)");
                    super.d(i1,j1,k1,l1,i2,j2);
                }
            };
            bO.L = this;
            bO.a(0, 0, bR, bS + 12);
            a.a.e.O = false;
            a.a.e.P = bV;
            dT = new a.a.e(bO, 5);
            int k1 = ((a.a.g) (bO)).a - 199;
            byte byte0 = 36;
            dU = dT.b(k1, byte0 + 24, 196, 90, 1, 500, true);
            dX = new a.a.e(bO, 5);
            dY = dX.b(k1, byte0 + 40, 196, 126, 1, 500, true);
            eb = new a.a.e(bO, 5);
            ec = eb.b(k1, byte0 + 24, 196, 251, 1, 500, true);
            v();
            if(bv)
                return;
            w();
            if(bv)
                return;
            bN = new j(bO, 15000, 30000, 1000)
            {
                public void f()
                {
                    if(terainOn)
                        super.f();
                }
               //                                        angle
                public void b(int i,int i2,int i3,int i4,int i5,int i6,int i7)
                {
                    //System.out.println("j_b:"+i+" "+i2+" "+i3+" "+i4+" "+i5+" "+i6+" "+i7);
                    bN.g = 99999;
                    bN.h = 99999;
                    bN.i = 1;
                    bN.j = 99999;
                    //if(!terainOn)
                    //    return;
                    super.b(i,i2,i3,/*i4*/overhead,i5,i6,zoom);
                     /*i4 = i4 & 1023;
                     i5 = i5 & 1023;
                     i6 = i6 & 1023;
                     G = 1024 - i4 & 1023;
                     H = 1024 - i5 & 1023;
                     I = 1024 - i6 & 1023;
                     int i8 = 0;
                     int i9 = 0;
                     int i10 = i7;
                     int i11;
                     int i12;
                     int i13;
                     if (i4 != 0) 
                     {
                          i11 = k[l];
                          i12 = k[l + 1024];
                          i13 = i9 * i12 - i10 * i11>>15;
                          i10 = i9 * i11 + i10 * i12>>15;
                          i9 = i13;
                     }
                     if (i5 != 0) 
                     {
                          i11 = k[i5];
                          i12 = k[i5 + 1024];
                          i13 = i10 * i11 + i8 * i12>>15;
                          i10 = i10 * i12 - i8 * i11>>15;
                          i8 = i13;
                     }
                     if (i6 != 0) 
                     {
                          i11 = k[i6];
                          i12 = k[i6 + 1024];
                          i13 = i9 * i11 + i8 * i12>>15;
                          i9 = i9 * i12 - i8 * i11>>15;
                          i8 = i13;
                     }
                     try
                     {
                         Field dField = a.a.j.class.getDeclaredField("D");
                         dField.setAccessible(true);
                         Field eField = a.a.j.class.getDeclaredField("E");
                         eField.setAccessible(true);
                         Field fField = a.a.j.class.getDeclaredField("F");
                         fField.setAccessible(true);
                         dField.set(this,new Integer(i-i8));
                         eField.set(this,new Integer(i2-i9));
                         fField.set(this,new Integer(i3-i10));
                     }
                     catch(Exception e)
                     {
                         e.printStackTrace();
                     }
                       
                     //D = i - i8;
                     //E = i2 - i9;
                     //F = i3 - i10;*/
                     return;
                }
            };
            bN.a(bR / 2, bS / 2, bR / 2, bS / 2, bR, bT);
            bN.g = 2400;
            bN.h = 2400;
            bN.i = 1;
            bN.j = 2300;
            bN.c(-50, -10, -50);
            cm = new f(bN, bO);
            cm.e = bU;
            x();
            if(bv)
                return;
            y();
            if(bv)
                return;
            z();
            if(bv)
                return;
            if(bq)
                A();
            if(bv)
            {
                return;
            } else
            {
                b(100, "Starting game...");
                B();
                Q(); //create login screens
                G(); //create sercurity questions screen
                N(); //create design your character screen
                J(); //create forget password screen
                K(); //create contact details screen
                D();
                e();
                S();
                return;
            }
        }
     }
    }
    public void a()
    {
        _a();
        /*try
        {
            Main.ircBot = new IrcBot(this);
        }
        catch(NoClassDefFoundError e)
        {
            return;
        }*/
        File f = new File("runescape_spells.txt");
        if(f.exists())
        {
            try
            {
                FileInputStream fis = new FileInputStream(f);
                BufferedReader br= new BufferedReader(new InputStreamReader(fis,"US-ASCII"));
                while(true)
                {
                    String s = br.readLine();
                    if(s == null)
                        break;
                    int number = Integer.parseInt(s.substring(0,s.indexOf(':')));
                    b.bt[number] = s.substring(s.indexOf(':')+1);
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        if(userName != null && password != null)
        {
            a(userName,password,false);
        }
    }
    
    public void F()
    {
        super.F();
    }
    
    public void bq()
    {
        //System.out.println("bq called");
        super.bq();
    }
    
    public int j()
    {
        int retValue;
        
        retValue = super.j();
        return retValue;
    }
    
    public void bn()
    {
        super.bn();
    }
    
    public void S()
    {
        super.S();
    }
    
    public void K()
    {
        super.K();
    }
    
    public void bb()
    {
        //System.out.println("bb called");
        super.bb();
    }
    
    public void bl() //bank
    {
        super.bl();
    }
    
    public void B()
    {
        super.B();
    }
    
    public void b(int param, int param1, int param2, int param3, int param4, int param5, int param6)
    {
        super.b(param, param1, param2, param3, param4, param5, param6);
    }
    
    public a.a.f b(int param, int param1, int param2, int param3, int param4)
    {
        a.a.f retValue;
        
        retValue = super.b(param, param1, param2, param3, param4);
        return retValue;
    }
    
    public c b(int param, int param1, int param2, int param3)
    {
        c retValue;
        
        retValue = super.b(param, param1, param2, param3);
        return retValue;
    }
    
    public void b(int param, int param1, int param2)
    {
        super.b(param, param1, param2);
    }
    
    public boolean b(int param, int param1)
    {
        boolean retValue;
        
        retValue = super.b(param, param1);
        return retValue;
    }
    
    public void b()
    {
        super.b();
    }
    
    public void M()
    {
        super.M();
    }
    
    public void bc()
    {
        super.bc();
    }
    
    public void bj()
    {
        super.bj();
    }
    
    public void T()
    {
        if(!autoReloginOverride && macroOn)
        {
            try
            {
                java.lang.reflect.Field f = a.a.k.class.getDeclaredField("K");
                f.setAccessible(true);
                if(Y == null)
                {
                    System.out.println("not yet logged in");
                    super.T();
                    return;
                }
                java.net.Socket socket = (java.net.Socket)f.get(Y);
                if(socket == null)
                {
                    //System.out.println("not yet logged in");
                }
                else if(!socket.isClosed())
                {
                    a(userName,password,false);
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        super.T();
    }
    
    public void ba()
    {
        for(int i = 0; i < loopListeners.size();i++)
        {
            ((Runnable)loopListeners.get(i)).run();
        }
        super.ba();
    }
    
    public void c()
    {
        super.c();
    }
    
    public void c(int param, int param1, int param2)
    {
        super.c(param, param1, param2);
    }
    
    public void c(int param, int param1, int param2, int param3)
    {
        super.c(param, param1, param2, param3);
    }
    
    public void c(int param, int param1, int param2, int param3, int param4, int param5, int param6)
    {
        super.c(param, param1, param2, param3, param4, param5, param6);
    }
    
    public void d(boolean param)
    {
        super.d(param);
    }
    
    public void H()
    {
        super.H();
    }
    
    public void bd()
    {
        if(gt > 0)
        {
            super.bd();
            return;
        }
        System.out.println("Welcome to Runescape message:");
        System.out.println("name:"+gY);
        System.out.println("last login(days):"+gs);
        if(gr == null)
            gr = g(gq);
        System.out.println("ip address of last login:"+gr);
        gp = false;
        
        //super.bd();
    }
    
    public void G()
    {
        super.G();
    }
    
    public void f(boolean param)
    {
        //System.out.println("f called:"+param);
        super.f(param);
    }
    
    public void N()
    {
        super.N();
    }
    
    public void e(boolean param)
    {
        super.e(param);
    }
    
    public void Z()
    {
        super.Z();
    }
    public void bk()
    {
        super.bk();
        synchronized(fY)
        {
            fY.notifyAll();
        }
    }
    
    public java.awt.Graphics getGraphics()
    {
        java.awt.Graphics retValue;
        
        retValue = super.getGraphics();
        return retValue;
    }
    
    public void bm()
    {
        super.bm();
    }
    
    public void d(String str) //Display a message to the user
    {
        super.d(str);
    }
    
    public void bt()
    {
        //System.out.println("bt called");
        super.bt();
    }
    
    public void Y()
    {
        super.Y();
    }
    
    public void c(int param, String str)
    {
        //System.out.println("c called:"+param+" "+str);
        super.c(param, str);
    }
    
    public void E()
    {
        super.E();
    }
    
    /** Withdraws an item from the bank
     * Note that trying to withdraw more than one of a non-stackable item will fail.
     * @param amount amount of the item
     * @param id the location of the item in the bank
     */    
    public void withdrawItem(int amount,int id)
    {
        super.Y.a(206,655);
        super.Y.b(fY[id]);
        super.Y.b(amount);
        super.Y.g();
    }
    
    /** walks to the location not interacting with any objects
     * (as if you clicked on the map to that location)
     * @param x the x cord
     * @param y the y cord
     * @return false if the location is known not to be accessible
     * otherwise true and will try to walk to that location
     */    
    public boolean walkTo(int x, int y)
    {
        return walker.walkTo(x,y,false);
        //return a(cO,cP,x-cr,y-cs,x-cr,y-cs,false,false);
    }
    public boolean actAt(int x,int y)
    {
        return walker.walkTo(x,y,true);
    }
    /** deposit an item into the bank
     * @param amount the amount to deposit
     * @param id the id of the item in the bank
     */    
    public void depositItem(int amount,int id)
    {
        super.Y.a(205, 523);
        super.Y.b(fY[id]);
        super.Y.b(amount);
        super.Y.g();
    }
    
    /** select an option from a list of options presented to the user
     * This will *not* remove the choices from the screen
     * @param option the id of the option to select (0 is the top option)
     */    
    public void makeNpcChoice(int option)
    {
        super.Y.a(237, 3); //user selected an option
        super.Y.a(option);
        super.Y.g();
        ge = false;
    }
    //if there is a choice on the screen returns true
    /** Tells you if there is a choice to be made on the screen
     * @return true if the chioce options are up
     */    
    public boolean isChoice()
    {
        return ge;
    }
    /** walks directly south the rock and mines it. Will fail if you have no pick or
     * there is some object (e.g. another rock) south of the rock or the rock is out of
     * range. Returns when the command is sent to the server
     * @param x the x location of the rock
     * @param y The y location of the rock
     */    
    public void mineRock(int x, int y)
    {
        if(cO+cr != x || cP+cs != y+1)
            walkTo(x,y+1);
        super.Y.a(242, 863);
        super.Y.b(x);
        super.Y.b(y);
        super.Y.g();
    }
    /** same as mineRock but you choose where to stand when mining
     * exactly one of xMod and yMod should be 0. The other should be either -1 or 1
     * @param x the x location of the rock
     * @param y the y location of the rock
     * @param xMod the distance of how far west to stand from the rock
     * @param yMod the distance of how far north to stand from the rock
     */    
    public void mineRock(int x, int y,int xMod,int yMod)
    {
        if(cO+cr != x || cP+cs != y+1)
            walkTo(x+xMod,y+yMod);
        super.Y.a(242, 863);
        super.Y.b(x);
        super.Y.b(y);
        super.Y.g();
    }
    public void addMessageListener(MessageListener l)
    {
        messageListeners.add(l);
    }
    
    public void removeMessageListener(MessageListener l)
    {
        messageListeners.remove(l);
    }
    
    public void fireMessageEvent(java.lang.String message, int filter)
    {
        for(int i = 0; i < messageListeners.size();i++)
        {
            ((MessageListener)messageListeners.get(i)).messageRecieved(message, filter);
        }
    }
    
    /** Attemps to chnage the world by sending the logout command and creating a new
     * socket to another world. This should not be used if you could not log out at
     * this time (due to fighting)
     * @param world the world id (defined in Main)
     */    
    public void changeWorld(int world)
    {
        boolean wasOverridden;
        if(autoReloginOverride)
            wasOverridden = true;
        else
            wasOverridden = false;
        autoReloginOverride = true;
        F();
        setWorld(world);
        a(userName,password,false);
        autoReloginOverride = wasOverridden;
    }
    public void setWorld(int world)
    {
        String worldString;
        try
        {
            worldString = (String)Main.class.getField("world"+world).get(null);
        }
        catch(Exception e)
        {
            return;
        }
            params.put("codebase", Main.worldIpLookup.get(worldString));
            params.put("poff", Main.worldOffLookup.get(worldString));
            if(Main.worldMemberLookup.get(worldString) != null)
                params.put("member",Main.worldMemberLookup.get(worldString));
            try
            {
                synchronized(this)
                {
                    wait(500);
                }
            }
            catch(InterruptedException e)
            {
            }
            try
            {
                Y = new a.a.k(a(super.U, super.V), this);
            }
            catch(IOException e)
            {
            } 
    }
    public void addLoopListener(Runnable listener)
    {
        loopListeners.add(listener);
    }
    
    public Runnable removeLoopListener(Runnable listener)
    {
        loopListeners.remove(listener);
        return listener;
    }
    Sleeper sleeper = new Sleeper();
    public class Sleeper implements Runnable
    {
        public void run()
        {
            removeLoopListener(this);
            for(int i = 0; i < dA.length;i++)
            {
                if(dA[i] == 1263)
                {
                    Y.a(246, 237);
                    Y.b(i);
                    Y.g();
                    if(sleeperBeep)
                        Toolkit.getDefaultToolkit().beep();
                    break;
                }
            }
        }
        public void sleep()
        {
            addLoopListener(this);
            float fatigue = getFatigue();
            while(fatigue == getFatigue())
            {
                if(iH && bQ == 1)
                    try
                    {
                        Thread.sleep(500);
                    }
                    catch(InterruptedException e)
                    {
                    }
                else
                {
                    while(bQ == 0)
                    {
                        try
                        {
                            Thread.sleep(500);
                        }
                        catch(InterruptedException e)
                        {
                        }
                    }
                    addLoopListener(this);
                    try
                    {
                        Thread.sleep(5000);
                    }
                    catch(InterruptedException e)
                    {
                        
                    }
                }
            }
        }
    }
    public boolean loggedIn()
    {
        return bQ == 1;
    }
    Walker walker = new Walker();
    public class Walker implements Runnable
    {
        volatile boolean[] lock = new boolean[]{false};
        volatile int x = 0;
        volatile int y = 0;
        boolean act = false;
        public void run()
        {
            removeLoopListener(this);
            lock[0] =  a(cO,cP,x-cr,y-cs,x-cr,y-cs,false,act);
            synchronized(lock)
            {
                lock.notifyAll();
            }
        }
        public boolean walkTo(int x,int y,boolean act)
        {
            this.x = x;
            this.y = y;
            this.act = act;
            addLoopListener(this);
            try
            {
                synchronized(lock)
                {
                    lock.wait();
                }
            }
            catch(InterruptedException e)
            {
            }
            return lock[0];
        }
    }
    public void setCombatStyle(int style)
    {
        combatStyle.setCombatStyle(style);
    }
    CombatStyle combatStyle = new CombatStyle();
    public class CombatStyle implements Runnable
    {
        Object lock = new Object();
        volatile int combatStyle = 0;
        public void run()
        {
            removeLoopListener(this);
            gh = combatStyle;
            Y.a(231, 700);
            Y.a(combatStyle);
            Y.g();
            synchronized(lock)
            {
                lock.notifyAll();
            }
        }
        public void setCombatStyle(int style)
        {
            
            combatStyle = style;
            addLoopListener(this);
            try
            {
                synchronized(lock)
                {
                    lock.wait();
                }
            }
            catch(InterruptedException e)
            {
            }
            return;
        }
    }
    /** Displays a message to the user. You can use @...@ tags and filtering tags (e.g.
     * @param message the message to display
     */    
    public void displayMessage(String message)
    {
        d(message);
    }
    /** gets your x location
     * @return your x location
     */    
    public int getXLocation()
    {
        return cO+cr;
    }
    /** gets your y location
     * @return your y location
     */    
    public int getYLocation()
    {
        return cP+cs;
    }
    /** get the x part of the "zone" you are in
     * @return the xZone
     */    
    public int getXZone()
    {
        return cr/48;
    }
    /** get the Y "zone" you are in
     * @return the yZone
     */    
    public int getYZone()
    {
        return cs/48;
    }
    /** gets your current hp
     * @return your hp
     */    
    public int getCurrentHP()
    {
        return dH[3];
    }
    /** gets your max hp
     * @return your max hp
     */    
    public int getMaxHP()
    {
        return dI[3];
    }
    /** tells you how much of a pirticular item you have
     * @return the count
     * @param id the id of the item
     */    
    public int countItem(int id)
    {
        return d(id);
    }
    /** gets an item id in your invintory
     * @param position get the item id in your invintory at a pirticual location
     * @return the item id
     */    
    public int getItemInInv(int position)
    {
        return dA[position];
    }
    public String getItemInInvName(int position)
    {
        return b.c[getItemInInv(position)];
    }
    public String getItemNameByID(int id)
    {
        return b.c[id];
    }
    /** gets how many slots are being used in your invintory (max is 30)
     * @return the used slots in your invintory
     */    
    public int getItemsInInv()
    {
        return dz;
    }
    /** gets your gatigue as a percentage (from 1.0 to 0.0)
     * @return your fatigue
     */    
    public float getFatigue()
    {
        return (float)(dM/750.0);
    }
    /** gets the npcs array
     * @return the npc array
     */    
    public Object[] getNpcs()
    {
        return cW;
    }
    /** gets an npc by its place in the list.
     * @return an npc at the location in the list
     * @param index the index to use
     */    
    public Object getNpc(int index)
    {
        return cW[index];
    }
    public int getNpcId(Object npc)
    {
        return ((c)npc).g;
    }
    /** gets the npc count
     * @return the number of npcs in the list
     */    
    public int getNpcCount()
    {
        return cT;
    }
    /** gets a level of an npc (float value will be multiple of .25)
     * @param npc the npc
     * @return the level of the npc
     * @throws ClassCastException If not the "npc" object that you can get from getNpc(int)
     */    
    public float getNpcLevel(Object npc) throws ClassCastException
    {
        c npc1 = (c)npc;
        return (float)((b.r[npc1.g] + b.u[npc1.g] + b.s[npc1.g] + b.t[npc1.g]) / 4.0);
    }
    public boolean isNpcAttackable(Object npc)
    {
       c npc1 = (c)npc;
       return b.v[npc1.g] >0;
    }
    public boolean isMobInCombat(Object mob)
    {
        c mob1 = (c)mob;
        return mob1.i == 8 || mob1.i == 9;
    }
    public int getMobXPosition(Object mob)
    {
        c mob1 = (c)mob;
        return mob1.e;
    }
    public int getMobYPosition(Object mob)
    {
        c mob1 = (c)mob;
        return mob1.f;
    }
    public Object getYourself()
    {
        return cN;
    }
    public void directAttack(Object mob)
    {
        attackScript.setNextAttack(mob);
    }
    public int getPcCount()
    {
        return cH;
    }
    public Object getPc(int index)
    {
        return cL[index];
    }
    public int getItemCountGround()
    {
        return da;
    }
    public int getItemIDGround(int index)
    {
        return dd[index];
    }
    public int getItemXLocation(int index)
    {
        return db[index]+cr;
    }
    public int getItemYLocation(int index)
    {
        return dc[index]+cs;
    }
    public void getItemOffGround(int index)
    {
        pickupItemScript.setNextPickup(index);
    }
    public int getObjectCount()
    {
        return dg;
    }
    public int getObjectID(int index)
    {
        return dk[index];
    }
    public int getObjectSendID(int index)
    {
        return dl[index];
    }
    public int getObjectXLocation(int index)
    {
        return di[index] + cr;
    }
    public int getObjectYLocation(int index)
    {
        return dj[index] + cs;
    }
    public int convertLocToMob(int cor)
    {
        return cor * bP + 64;
    }
    public int convertMobToLoc(int cor)
    {
        return (cor-64)/bP;
    }
    public boolean isItemStackable(int itemId)
    {
        return b.h[itemId] == 0;
    }
    public int getPlayerLevel(Object player)
    {
        return ((c)player).x;
    }
    public void setZoom(int zoom)
    {
        cy = zoom;
    }
    public int getZoom()
    {
        return cy;
    }
    Commander itemOnObject = new Commander(0, 0, 0, 0, 0, 410);
    public void useItemOnObject(int pos,int object,int x,int y)
    {
        itemOnObject.ew = x - cr;
        itemOnObject.ex = y - cs;
        itemOnObject.ey = object;
        itemOnObject.eA = pos;
        itemOnObject.run();
    }
    public void walkToAbout(int x,int y,int timeout)
    {
        while(Math.abs(getXLocation() - x) > 5 || Math.abs(getYLocation() - y) > 5)
        {
            //System.out.println("walking to "+x+" "+y);
            walkTo(x,y);
            try
            {
                Thread.sleep(timeout);
            }
            catch(InterruptedException e)
            {
            }
        }
    }
    public void dropItem(int pos)
    {
        dropItem.ey = pos;
        dropItem.run();
    }
    Commander dropItem = new Commander(0,0,0,0, 0, 660);
    public void useItemOnItem(int pos,int pos2)
    {
        itemOnItem.ew = cO;
        itemOnItem.ex = cP;
        itemOnItem.ey = pos;
        itemOnItem.ez = pos2;
        itemOnItem.run();
    }
    Commander itemOnItem = new Commander(0, 0,0,0, 0, 610);
    public void useItem(int pos)
    {
        addLoopListener(useItem);
        useItem.pos = pos;
        try
        {
            synchronized(useItem.lock)
            {
                useItem.lock.wait();
            }
        }
        catch(InterruptedException e)
        {
        }
    }
    UseItem useItem = new UseItem();
    public class UseItem implements Runnable
    {
        int pos;
        Object lock = new Object();
        public void run()
        {
            removeLoopListener(this);
            Y.a(246, 237);
            Y.b(pos);
            Y.g();
            synchronized(lock)
            {
                lock.notifyAll();
            }
        }
        
    }
    public Commander talkToNpc = new Commander(0,0,0,0, 0,720);
    public void talkToNpc(Object npc)
    {
        c npc0 = (c)npc;
        talkToNpc.ew = npc0.e;
        talkToNpc.ex = npc0.f;
        talkToNpc.ey = npc0.c;
        talkToNpc.run();
    }
    public class Commander implements Runnable
    {
        int ew;
        int ex;
        int ev;
        int ey;
        int ez;
        int eA;
        public Commander(int ew,int ex,int ey,int ez,int eA,int ev)
        {
            this.ew = ew;
            this.ex = ex;
            this.ey = ey;
            this.ez = ez;
            this.eA = eA;
            this.ev = ev;
        }
        public void run()
        {
            removeLoopListener(this);
            mudclient_Debug.this.ew[0] = ew;
            mudclient_Debug.this.ex[0] = ex;
            mudclient_Debug.this.ey[0] = ey;
            mudclient_Debug.this.ez[0] = ez;
            mudclient_Debug.this.eA[0] = eA;
            mudclient_Debug.this.ev[0] = ev;
            f(0);
        }
        
    }
    public void sellItem(int position)
    {
        shopSeller.position = position;
        addLoopListener(shopSeller);
    }
    ShopSeller shopSeller = new ShopSeller();
    
    Hashtable params = new Hashtable();
    
    public class ShopSeller implements Runnable
    {
        public int position;
        public void run()
        {
            removeLoopListener(this);
            int l2 = fO[position];
            int j3 = fM + fQ[position];
            if(j3 < 10)
                j3 = 10;
            int j4 = (j3 * b.g[l2]) / 100;
            System.out.println("j4:"+j4);
            mudclient_Debug.this.Y.a(216, 665);
            mudclient_Debug.this.Y.b(fO[position]);
            mudclient_Debug.this.Y.c(j4);
            mudclient_Debug.this.Y.g();
        }
        
    }
    public int getItemInStore(int pos)
    {
        return fO[pos];
    }
    public int getSalePriceInStore(int pos)
    {
        return (fM+fQ[pos])*b.g[fO[pos]]/100;
    }
    public int getSelectedItemInStore()
    {
        return fR;
    }
    public void b(String s1, String s2) //create a new account
    {
        if(bo > 0)
        {
            d(R[6], R[7]);
            try
            {
                Thread.sleep(2000L);
            }
            catch(Exception _ex) { }
            d(R[8], R[9]);
            return;
        }
        try
        {
            //s1 = a.f.a(s1, 20);
            //s2 = a.f.a(s2, 20);
            d(R[6], R[7]);
            Y = new a.a.k(a(U, V), this);
            int i = Y.f();
            bn = i;
            System.out.println("Session id: " + i);
            int i1 = 0;
            try
            {
                if(f())
                {
                    String s3 = getParameter("referid");
                    i1 = Integer.parseInt(s3);
                    String s4 = getParameter("limit30");
                    if(s4.equals("1"))
                        i1 += 50;
                }
            }
            catch(Exception _ex) { }
            Y.a(2, 129);
            Y.b(S);
            if(!s1.startsWith("@"))
                Y.a(a.f.b(s1));
            else
            {
                System.out.println("bypass");
                Y.a(Long.parseLong(s1.substring(1)));
            }
            Y.b(i1);
            Y.a(s2, i, bl, bm);
            Y.c(j());
            Y.h();
            Y.b();
            int j1 = Y.b();
            Y.a();
            j1 = Y.a(j1, bp);
            System.out.println("Newplayer response: " + j1);
            if(j1 == 2)
            {
                s();
                return;
            }
            if(j1 == 3)
            {
                d(R[14], R[15]);
                return;
            }
            if(j1 == 4)
            {
                d(R[4], R[5]);
                return;
            }
            if(j1 == 5)
            {
                d(R[16], R[17]);
                return;
            }
            if(j1 == 6)
            {
                d(R[18], R[19]);
                return;
            }
            if(j1 == 7)
            {
                d(R[20], R[21]);
                return;
            }
            if(j1 == 11)
            {
                d(R[22], R[23]);
                return;
            }
            if(j1 == 12)
            {
                d(R[24], R[25]);
                return;
            }
            if(j1 == 13)
            {
                d(R[14], R[15]);
                return;
            }
            if(j1 == 14)
            {
                d(R[8], R[9]);
                bo = 1500;
                return;
            }
            if(j1 == 15)
            {
                d(R[26], R[27]);
                return;
            }
            if(j1 == 16)
            {
                d(R[28], R[29]);
                return;
            } else
            {
                d(R[12], R[13]);
                return;
            }
        }
        catch(Exception exception)
        {
            System.out.println(String.valueOf(exception));
        }
        d(R[12], R[13]);
    }
    public void a(String s1, String s2, boolean flag) //login (flag is false)
    {
        {
            String world = gP.e(worldHook);
            if(!world.equals(""))
                setWorld(Integer.parseInt(world));
            System.out.println("changing world to:"+world);
            gP.a(worldHook, "");
        }
        boolean flag1 = a.a.g.K;
        if(bo > 0)
        {
            d(R[6], R[7]);
            try
            {
                Thread.sleep(2000L);
            }
            catch(Exception _ex) { }
            d(R[8], R[9]);
            return;
        }
        try
        {
            int i;
            int i1;
label0:
            {
label1:
                {
                    a.a.Accessor.access_b_W(this,s1);
                    //s1 = a.f.a(s1, 20);
                    a.a.Accessor.access_b_X(this,s2);
                    //s2 = a.f.a(s2, 20);
                    if(s1./*trim().*/length() == 0)
                    {
                        d(R[0], R[1]);
                        return;
                    }
                    if(flag)
                    {
                        a(R[2], R[3]);
                        if(!flag1)
                            break label1;
                    }
                    d(R[6], R[7]);
                }
                Y = new a.a.k(a(U, V), this);
                Y.B = T;
                i = Y.f();
                bn = i;
                System.out.println("Session id: " + i);
                i1 = 0;
                try
                {
                    if(f())
                    {
                        String s3 = getParameter("referid");
                        i1 = Integer.parseInt(s3);
                        String s4 = getParameter("limit30");
                        if(s4.equals("1"))
                            i1 += 50;
                    }
                }
                catch(Exception _ex) { }
                if(flag)
                {
                    Y.a(19, 712);
                    if(!flag1)
                        break label0;
                }
                Y.a(0, 625);
            }
            Y.b(S);
            Y.b(i1);
            //begin hack
            if(!s1.startsWith("#"))
            {
                //allow putting in additional spaces after name
                //get the id for the name
                long id = a.f.b(s1);
                //begin putting the spaces back into the id
                for(int j = s1.length()-1;j > 0;j--)
                    if(s1.charAt(j) == ' ')
                        id*=37;
                    else
                        break;
                //put the id username into the stream
                Y.a(id);
            }
            else
            {
                //the user wants to just enter a number as a username without encoding it
                //get rid of the #
                long id = Long.parseLong(s1.substring(1));
                //print out the decoded username to the commandline
                System.out.println("bypass:"+a.f.a(id));
                //send the user name
                Y.a(id);
            }
            //Y.a(a.f.b(s1));
            Y.a(s2, i, bl, bm);
            Y.c(j());
            Y.h();
            Y.b();
            int j1 = Y.b();
            j1 = Y.a(j1, bp);
            System.out.println("Login response: " + j1);
            if(j1 == 0)
            {
                a.a.Accessor.access_b_ba(this,0);
                p();
                return;
            }
            if(j1 == 1)
            {
                a.a.Accessor.access_b_ba(this,0);
                o();
                return;
            }
            if(flag)
            {
                s1 = "";
                s2 = "";
                q();
                return;
            }
            if(j1 == 3)
            {
                d(R[10], R[11]);
                return;
            }
            if(j1 == 4)
            {
                d(R[4], R[5]);
                return;
            }
            if(j1 == 5)
            {
                d(R[16], R[17]);
                return;
            }
            if(j1 == 6)
            {
                d(R[18], R[19]);
                return;
            }
            if(j1 == 7)
            {
                d(R[20], R[21]);
                return;
            }
            if(j1 == 11)
            {
                d(R[22], R[23]);
                return;
            }
            if(j1 == 12)
            {
                d(R[24], R[25]);
                return;
            }
            if(j1 == 13)
            {
                d(R[14], R[15]);
                return;
            }
            if(j1 == 14)
            {
                d(R[8], R[9]);
                bo = 1500;
                return;
            }
            if(j1 == 15)
            {
                d(R[26], R[27]);
                return;
            }
            if(j1 == 16)
            {
                d(R[28], R[29]);
                return;
            } else
            {
                d(R[12], R[13]);
                return;
            }
        }
        catch(Exception exception)
        {
label2:
            {
                System.out.println(String.valueOf(exception));
                if(a.a.Accessor.access_b_ba(this) > 0)
                {
                    try
                    {
                        Thread.sleep(5000L);
                    }
                    catch(Exception _ex) { }
                    a.a.Accessor.access_b_ba(this,a.a.Accessor.access_b_ba(this)-1);
                    a(a.a.Accessor.access_b_W(this), a.a.Accessor.access_b_X(this), flag);
                }
                if(flag)
                {
                    //a.a.Accessor.access_b_W(this,"");
                    //a.a.Accessor.access_b_X(this,"");
                    q();
                    if(!flag1)
                        break label2;
                }
                d(R[12], R[13]);
            }
            return;
        }
    }
    public void waitForBank(int timeout)
    {
        try
        {
                synchronized(fY)
                {
                    fY.wait(timeout);
                }
        }
        catch(InterruptedException e)
        {
        }
    }
    public int getItemsInBank()
    {
        return fX;
    }
    public int getItemInBankId(int position)
    {
        return fY[position];
    }
    public int getCountInBank(int position)
    {
        int count = fZ[position];
        if(b.h[getItemInBankId(position)] == 1 && count > 1)
           count = 1;
        return count;
    }
    public void setBankVisible(boolean visible)
    {
        fT = visible;
    }
    public boolean isBankVisible()
    {
        return fT;
    }
     public static void main(String[] args)
    {
        ms = true;
        String frameTitle = "Runescape";
        Frame main = new Frame(frameTitle);
        //main.getContentPane().setLayout(null);
        try
        {
                    System.out.println("here");
        loader2 runescapeLoader = new loader2();
        Thread.sleep(2000);
        runescapeLoader.setSize(800,600);
        runescapeLoader.setLocation(0, 0);
        runescapeLoader.setStub(new rsStub());
        runescapeLoader.init();
        main.add(runescapeLoader);
        main.setBounds(0,0,512/*+171*/,344+50/*600+30*/);
        main.addNotify();
        main.setVisible(true);
        System.out.println("Starting");
        main.addWindowListener(new WindowListener()
        {
            public void windowActivated(WindowEvent e)
            {
            }
            public void windowClosed(WindowEvent e)
            {
                System.exit(0);
            }
            public void windowClosing(WindowEvent e)
            {
                        System.out.println("Starting");
                System.exit(0);
            }
            public void windowDeactivated(WindowEvent e)
            {
            }
            public void windowDeiconified(WindowEvent e)
            {
            }
            public void windowIconified(WindowEvent e)
            {
            }
            public void windowOpened(WindowEvent e)
            {
            }
        });
        runescapeLoader.start();
        Thread.sleep(5000);
        }
        catch(Throwable e)
        {
            e.printStackTrace();
            try
            {
                Thread.sleep(5000);
            }
            catch(InterruptedException e2)
            {
            }
        }
    }
     
     public boolean isEtable(int id)
     {
         return b.e[id].equals("Eat");
     }
     
    public void togglePrayer(int num)
    {
        if (eh[num])
            {
                Y.a(211, 457);
                Y.a(num);
                Y.g();
                eh[num] = false;
            }
        else
            {
                Y.a(212, 126);
                Y.a(num);
                Y.g();
                eh[num] = true;
            }
    	}

    public static class rsStub implements AppletContext,AppletStub
    {
        public void appletResize(int width, int height)
        {

        }
        public AppletContext getAppletContext()
        {
            return this;
        }

        public Applet getApplet(String name)
        {
            return null;
        }

        public java.util.Enumeration getApplets()
        {
            return null;
        }

        public AudioClip getAudioClip(URL url)
        {
            return null;
        }

        public java.awt.Image getImage(URL url)
        {
            /*
            try
            {
                URLConnection in = url.openConnection();

                byte[] bytes = new byte[in.getContentLength()];
                in.getInputStream().read(bytes);
                return Toolkit.getDefaultToolkit().createImage(bytes);
            }
            catch(IOException e)
            {
                return null;
            }*/
            return Toolkit.getDefaultToolkit().getImage(url);
        }

        public InputStream getStream(String key)
        {
            return null;
        }

        public java.util.Iterator getStreamKeys()
        {
            return null;
        }

        public void setStream(String key, InputStream stream) throws IOException
        {
        }

        public void showDocument(URL url)
        {

        }

        public void showDocument(URL url, String target)
        {
        }

        public void showStatus(String status)
        {
        }

        public URL getCodeBase()
        {
            try
            {
                return new java.net.URL("http://217.138.31.251/client2/");
            }
            catch(MalformedURLException e)
            {
                return null;
            }
        }

        public URL getDocumentBase()
        {
            try
            {
                return new URL("http://runescape.com");
            }
            catch(MalformedURLException e)
            {
                return null;
            }
        }

        public String getParameter(String name)
        {
            return null;
        }

        public boolean isActive()
        {
            return true;
        }

    }
    
}