// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 8/21/2003 11:24:15 AM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) fieldsfirst lnc 

import a.a.a;
import a.a.b;
import a.a.c;
import a.a.d;
import a.a.e;
import a.a.f;
import a.a.g;
import a.a.j;
import a.a.k;
import a.h;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;

public class mudclient extends b
{

    public boolean bq;      //true if members server
    public BigInteger br;
    public BigInteger bs;
    boolean bt;
    boolean bu;
    boolean bv;
    public boolean bw;
    int bx; //timer?
    int by; //value is 12345678?
    int bz; //value is 0?
    int bA; //value is 8000?
    int bB[];
    int bC[];
    int bD; //click count (not reset wraps around every so often)
    int bE[];
    int bF[];
    int bG; //value = 2?
    int bH; //value = 2?
    int bI; //value = 0?
    int bJ; //value = 2?
    int bK; //timer?
    int bL; // value = 0;
    Graphics bM;
    j bN;
    d bO; //graphics handler
    int bP; //value = 128
    int bQ; //1 if logged in 0 otherwise
    int bR; //value = 512
    int bS; //value = 334
    int bT; //value = 9
    int bU; //value = 2000
    int bV; //value = 2100
    int bW; //value = 2150
    int bX; //value = 3160
    int bY; //sprites loaded??
    int bZ; //value = 3220
    int ca; //value = 3150
    int cb; //value = 40
    int cc; //value = ?(0 to 5) even and odd makes a diff
    int cd;
    int ce;
    int cf;
    int cg;
    int ch;
    int ci;
    int cj; //changes when you click to walk, then decrements (by 2 or more)?
    int ck;
    int cl;
    f cm;
    int cn;
    int co;
    int cp;
    int cq;
    int cr;
    int cs;
    int ct;
    int cu;
    int cv;
    int cw;
    int cx;
    int cy;
    boolean cz;
    int cA;
    int cB;
    int cC;
    int cD;
    int cE; //camra rotation (0 for facing South, Max value 255)
    int cF;
    int cG;
    int cH;
    int cI;
    int cJ;
    c cK[];
    c cL[]; //pcs?
    c cM[];
c cN;  //da player
    int cO;
    int cP;
    int cQ;
    int cR;
    int cS;
    int cT;//number of Npcs (use with cW)
    int cU;
    c cV[];
    c cW[]; //List of NPcs on screen
    c cX[];
    int cY[];
    int cZ;
    int da;  //number of items (use with db)
    int db[]; //items x location
    int dc[]; //items y location
    int dd[]; //items id
    int de[];
    int df;
    int dg;
    f dh[];
    int di[]; //object x location
    int dj[]; //object y location
    int dk[]; 
    int dl[];
    f dm[];
    boolean dn[];
    int dp;
    int dq;
    f dr[];
    int ds[];
    int dt[];
    int du[];
    int dv[];
    boolean dw[];
    int dx;
    int dy;
    int dz; //number of slots used in invintory
    int dA[];
    int dB[];
    int dC[];
    int dD; //command type?
    String dE; //active item
    int dF[];
    final int dG = 18;
    int dH[]; //skill level (current)
    int dI[]; //skill level (max)
    int dJ[]; //exp in skill (divide by 4)
    int dK[]; //exp required for next level (divide by 4)
    int dL; //Quest Points
    int dM; //fatigue (divide by 750 for percentage (0 to 1))
    int dN; //Money
    String dO[] = {
        "Attack", "Defense", "Strength", "Hits", "Ranged", "Prayer", "Magic", "Cooking", "Woodcut", "Fletching", 
        "Fishing", "Firemaking", "Crafting", "Smithing", "Mining", "Herblaw", "Agility", "Thieving"
    };
    String dP[] = {
        "Attack", "Defense", "Strength", "Hits", "Ranged", "Prayer", "Magic", "Cooking", "Woodcutting", "Fletching", 
        "Fishing", "Firemaking", "Crafting", "Smithing", "Mining", "Herblaw", "Agility", "Thieving"
    };
    String dQ[] = {
        "Armour", "WeaponAim", "WeaponPower", "Magic", "Prayer"
    };
    int dR;
    int dS;
    e dT;
    int dU;
    int dV;
    int dW;
    e dX;
    int dY;
    int dZ;
    long ea;
    e eb;
    int ec;
    int ed;
    int ee;
    String ef[] = {
        "Black knight's fortress", "Cook's assistant", "Demon slayer", "Doric's quest", "The restless ghost", "Goblin diplomacy", "Ernest the chicken", "Imp catcher", "Pirate's treasure", "Prince Ali rescue", 
        "Romeo & Juliet", "Sheep shearer", "Shield of Arrav", "The knight's sword", "Vampire slayer", "Witch's potion", "Dragon slayer", "Witch's house (members)", "Lost city (members)", "Hero's quest (members)", 
        "Druidic ritual (members)", "Merlin's crystal (members)", "Scorpion catcher (members)", "Family crest (members)", "Tribal totem (members)", "Fishing contest (members)", "Monk's friend (members)", "Temple of Ikov (members)", "Clock tower (members)", "The Holy Grail (members)", 
        "Fight Arena (members)", "Tree Gnome Village (members)", "The Hazeel Cult (members)", "Sheep Herder (members)", "Plague City (members)", "Sea Slug (members)", "Waterfall quest (members)", "Biohazard (members)", "Jungle potion (members)", "Grand tree (members)", 
        "Shilo village (members)", "Underground pass (members)", "Observatory quest (members)", "Tourist trap (members)", "Watchtower (members)", "Dwarf Cannon (members)", "Murder Mystery (members)", "Digsite (members)", "Gertrude's Cat (members)", "Legend's Quest (members)"
    };
    boolean eg[];
    boolean eh[];
    boolean ei;
    boolean ej;
    boolean ek;
    boolean el;
    boolean em;
    int en;
    int eo;
    int ep;
    int eq;
    int er;
    int es;
    String et[];
    String eu[];
    int ev[];
    int ew[];
    int ex[];
    int ey[];
    int ez[];
    int eA[];
    int eB[];
    int eC;
    int eD;
    int eE;
    int eF;
    e eG;
    int eH;
    int eI;
    int eJ;
    int eK;
    int eL;
    int eM;
    String eN[];
    int eO[];
    boolean eP;
    String eQ;
    int eR;
    int eS[];
    int eT[];
    int eU;
    int eV[];
    int eW[];
    boolean eX;
    boolean eY;
    boolean eZ;
    boolean fa;
    boolean fb;
    boolean fc;
    boolean fd;
    boolean fe;
    long ff;
    int fg;
    int fh[];
    int fi[];
    int fj;
    int fk[];
    int fl[];
    int fm;
    int fn;
    int fo;
    int fp;
    boolean fq;
    String fr;
    int fs;
    int ft[];
    int fu[];
    int fv;
    int fw[];
    int fx[];
    boolean fy;
    boolean fz;
    int fA;
    int fB;
    long fC;
    boolean fD;
    boolean fE;
    int fF;
    int fG[];
    int fH[];
    int fI;
    int fJ[];
    int fK[];
    boolean fL;
    int fM;
    int fN;
    int fO[]; //shop invintory
    int fP[];
    int fQ[];
    int fR; //currently selected item in the shop
    int fS;
    boolean fT;
    int fU;
    int fV[];
    int fW[];
    int fX;
    int fY[]; //Items in the bank
    int fZ[]; //count of each item
    int ga;
    int gb;
    int gc;
    int gd;
    boolean ge;
    int gf;
    String gg[];
    int gh;
    int gi;
    int gj;
    int gk;
    int gl;
    String gm;
    String gn;
    boolean go;
    boolean gp;
    int gq;
    String gr;
    int gs;
    int gt;
    int gu;
    boolean gv;
    boolean gw;
    String gx;
    int gy;
    int gz;
    int gA;
    int gB;
    boolean gC;
    int gD;
    e gE;   //New User/Existing user screen
    int gF; //Hook for New User
    int gG; //Hook for Existing user
    e gH;   //create an account screen
    int gI; //Hook for text:"To create an account please enter..." (in create an account)
    int gJ; //Hook for cancel Button (in create an account)
    int gK; //Hook for submit Button (in create an account)
    int gL; //Hook for userName Field (in create an account)
    int gM; //Hook for password Field (in create an account)
    int gN; //Hook for confirm password Field (in create an account)
    int gO; //Hook for something in create an account
    e gP;   //login screen
    int gQ; //Hook for text:"Please enter your username and password" (in login)
    int gR; //Hook for userName Field (in login)
    int gS; //Hook for password Field (in login)
    int gT; //Hook for ok Button (in login)
    int gU; //Hook for cancel Button (in login)
    int gV; //Hook for lost password button (in login)
    String gW; //"Please enter a username"
    String gX;
    String gY;
    String gZ;
    e ha;
    int hb;
    int hc;
    int hd;
    int he;
    int hf;
    int hg;
    int hh;
    int hi;
    int hj;
    int hk;
    int hl;
    int hm;
    int hn;
    boolean ho;
    e hp;
    int hq;
    int hr;
    int hs;
    int ht[];
    int hu[];
    int hv[];
    int hw[];
    int hx[] = {
        0, 1, 2, 3, 4
    };
    String hy[];
    boolean hz;
    e hA;
    int hB;
    int hC;
    int hD;
    int hE;
    int hF;
    int hG;
    int hH;
    int hI[];
    int hJ[];
    boolean hK;
    e hL;
    int hM;
    int hN;
    int hO;
    int hP;
    int hQ;
    int hR;
    int hS;
    String hT[];
    int hU[];
    int hV[];
    int hW[];
    int hX[];
    int hY;
    int hZ[];
    int ia[];
    int ib[];
    int ic[];
    int id;
    int ie[];
    int ig[];
    int ih[];
    int ii;
    int ij;
    int ik[][] = {
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
    boolean il;
    int im;
    int in;
    int io;
    int ip;
    int iq;
    int ir;
    int is;
    int it;
    public int iu[] = {
        0xff0000, 0xff8000, 0xffe000, 0xa0e000, 57344, 32768, 41088, 45311, 33023, 12528, 
        0xe000e0, 0x303030, 0x604000, 0x805000, 0xffffff
    };
    public int iv[] = {
        0xffc030, 0xffa040, 0x805030, 0x604020, 0x303030, 0xff6020, 0xff4000, 0xffffff, 65280, 65535
    };
    public int iw[] = {
        0xecded0, 0xccb366, 0xb38c40, 0x997326, 0x906020
    };
    int ix[] = {
        0, 1, 2, 1
    };
    int iy[] = {
        0, 1, 2, 1, 0, 0, 0, 0
    };
    int iz[] = {
        0, 0, 0, 0, 0, 1, 2, 1
    };
    byte iA[]; //sound array
    d iB; //sound thing?
    int iC;
    int iD[];
    int iE[];
    int iF[];
    int iG[];
    boolean iH;
    String iI;
    String iJ[] = {
        "Where were you born?", "What was your first teachers name?", "What is your fathers middle name?", "Who was your first best friend?", "What is your favourite vacation spot?", "What is your mothers middle name?", "What was your first pets name?", "What was the name of your first school?", "What is your mothers maiden name?", "Who was your first boyfriend/girlfriend?", 
        "What was the first computer game you purchased?", "Who is your favourite actor/actress?", "Who is your favourite author?", "Who is your favourite musician?", "Who is your favourite cartoon character?", "What is your favourite book?", "What is your favourite food?", "What is your favourite movie?"
    };

    public static void main(String args[])
    {
        mudclient mudclient1 = new mudclient();
        mudclient1.bw = false;
        if(args.length > 0 && args[0].equals("members"))
            mudclient1.bq = true;
        if(args.length > 1)
            mudclient1.U = args[1];
        if(args.length > 2)
            mudclient1.V = Integer.parseInt(args[2]);
        mudclient1.a(mudclient1.bR, mudclient1.bS + 11, "Runescape by Andrew Gower", false);
        mudclient1.F = 10;
    }

    public void a()
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
        if(b.bN == 0) goto _L2; else goto _L1
_L1:
        int j1 = i1 + 1;
        int l1 = (int)((double)j1 + 300D * Math.pow(2D, (double)j1 / 7D));
        i += l1;
        dF[i1] = i & 0xffffffc;
        i1++;
_L2:
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
            b.T = 1000;
            b.S = e.b;
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
            a(50);
            bO = new d(bR, bS + 12, 4000, this);
            bO.L = this;
            bO.a(0, 0, bR, bS + 12);
            e.O = false;
            e.P = bV;
            dT = new e(bO, 5);
            int k1 = ((g) (bO)).a - 199;
            byte byte0 = 36;
            dU = dT.b(k1, byte0 + 24, 196, 90, 1, 500, true);
            dX = new e(bO, 5);
            dY = dX.b(k1, byte0 + 40, 196, 126, 1, 500, true);
            eb = new e(bO, 5);
            ec = eb.b(k1, byte0 + 24, 196, 251, 1, 500, true);
            v();
            if(bv)
                return;
            w();
            if(bv)
                return;
            bN = new j(bO, 15000, 15000, 1000);
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
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void u()
    {
        byte abyte0[] = a("config" + e.c + ".jag", "Configuration", 10);
        if(abyte0 == null)
        {
            bv = true;
            return;
        }
        b.a(abyte0, bq);
        byte abyte1[] = a("filter" + e.j + ".jag", "Chat system", 15);
        if(abyte1 == null)
        {
            bv = true;
            return;
        } else
        {
            byte abyte2[] = a.f.a("fragmentsenc.txt", 0, abyte1);
            byte abyte3[] = a.f.a("badenc.txt", 0, abyte1);
            byte abyte4[] = a.f.a("hostenc.txt", 0, abyte1);
            byte abyte5[] = a.f.a("tldlist.txt", 0, abyte1);
            a.g.a(new a.d(abyte2), new a.d(abyte3), new a.d(abyte4), new a.d(abyte5));
            return;
        }
    }

    public void v()
    {
        byte abyte0[];
        byte abyte1[];
        int i;
        int i1;
        int j2;
        j2 = b.bN;
        abyte0 = a("media" + e.e + ".jag", "2d graphics", 20);
        if(abyte0 == null)
        {
            bv = true;
            return;
        }
        abyte1 = a.f.a("index.dat", 0, abyte0);
        bO.a(bU, a.f.a("inv1.dat", 0, abyte0), abyte1, 1);
        bO.a(bU + 1, a.f.a("inv2.dat", 0, abyte0), abyte1, 6);
        bO.a(bU + 9, a.f.a("bubble.dat", 0, abyte0), abyte1, 1);
        bO.a(bU + 10, a.f.a("runescape.dat", 0, abyte0), abyte1, 1);
        bO.a(bU + 11, a.f.a("splat.dat", 0, abyte0), abyte1, 3);
        bO.a(bU + 14, a.f.a("icon.dat", 0, abyte0), abyte1, 8);
        bO.a(bU + 22, a.f.a("hbar.dat", 0, abyte0), abyte1, 1);
        bO.a(bU + 23, a.f.a("hbar2.dat", 0, abyte0), abyte1, 1);
        bO.a(bU + 24, a.f.a("compass.dat", 0, abyte0), abyte1, 1);
        bO.a(bU + 25, a.f.a("buttons.dat", 0, abyte0), abyte1, 2);
        bO.a(bV, a.f.a("scrollbar.dat", 0, abyte0), abyte1, 2);
        bO.a(bV + 2, a.f.a("corners.dat", 0, abyte0), abyte1, 4);
        bO.a(bV + 6, a.f.a("arrows.dat", 0, abyte0), abyte1, 2);
        bO.a(bX, a.f.a("projectile.dat", 0, abyte0), abyte1, b.br);
        i = b.b;
        i1 = 1;
        if(j2 != 0)
            do
            {
                int j1 = i;
                i -= 30;
                if(j1 > 30)
                    j1 = 30;
                bO.a(bW + (i1 - 1) * 30, a.f.a("objects" + i1 + ".dat", 0, abyte0), abyte1, j1);
                i1++;
            }while(i>0);
        
        int k1;
        bO.b(bU);
        bO.b(bU + 9);
        k1 = 11;
        if(j2 != 0)
        {
            do
            {
                bO.b(bU + k1);
                k1++;
            }while(k1 <=26);
        }
        
        int l1 = 0;
        if(j2 != 0)
        {
            do
            {
                bO.b(bX + l1);
                l1++;
            }while(ll < b.br);
        }
        int i2 = 0;
        if(j2 != 0)
        {
            while(true)
            {
                bO.b(bW + i2);
                i2++;
                if(i2 >= b.b)
                    return;
            }
        }
    }

    public void w()
    {
        byte abyte0[];
        byte abyte1[];
        byte abyte2[];
        byte abyte3[];
        int i;
        int i1;
        int l1;
        l1 = b.bN;
        abyte0 = null;
        abyte1 = null;
        abyte0 = a("entity" + e.h + ".jag", "people and monsters", 30);
        if(abyte0 == null)
        {
            bv = true;
            return;
        }
        abyte1 = a.f.a("index.dat", 0, abyte0);
        abyte2 = null;
        abyte3 = null;
        if(bq)
        {
            abyte2 = a("entity" + e.h + ".mem", "member graphics", 45);
            if(abyte2 == null)
            {
                bv = true;
                return;
            }
            abyte3 = a.f.a("index.dat", 0, abyte2);
        }
        i = 0;
        ii = 0;
        ij = ii;
        i1 = 0;
        if(l1 != 0)
        {
_L1:
            String s1;
            int j1;
            s1 = b.K[i1];
            j1 = 0;
        }
        if(l1 == 0) goto _L4; else goto _L3
_L3:
        if(!b.K[j1].equalsIgnoreCase(s1))
            continue; /* Loop/switch isn't completed */
        b.P[i1] = b.P[j1];
        if(l1 == 0)
            continue;
        j1++;
_L4:
        if(j1 < i1) goto _L3; else goto _L5
_L5:
        byte abyte4[];
        byte abyte7[];
        abyte7 = a.f.a(s1 + ".dat", 0, abyte0);
        abyte4 = abyte1;
        if(abyte7 == null && bq)
        {
            abyte7 = a.f.a(s1 + ".dat", 0, abyte2);
            abyte4 = abyte3;
        }
        if(abyte7 == null) goto _L7; else goto _L6
_L6:
        bO.a(ij, abyte7, abyte4, 15);
        i += 15;
        if(b.N[i1] == 1)
        {
            byte abyte8[] = a.f.a(s1 + "a.dat", 0, abyte0);
            byte abyte5[] = abyte1;
            if(abyte8 == null && bq)
            {
                abyte8 = a.f.a(s1 + "a.dat", 0, abyte2);
                abyte5 = abyte3;
            }
            bO.a(ij + 15, abyte8, abyte5, 3);
            i += 3;
        }
        if(b.O[i1] == 1)
        {
            byte abyte9[] = a.f.a(s1 + "f.dat", 0, abyte0);
            byte abyte6[] = abyte1;
            if(abyte9 == null && bq)
            {
                abyte9 = a.f.a(s1 + "f.dat", 0, abyte2);
                abyte6 = abyte3;
            }
            bO.a(ij + 18, abyte9, abyte6, 9);
            i += 9;
        }
        if(b.M[i1] == 0) goto _L7; else goto _L8
_L8:
        int k1 = ij;
        if(l1 == 0) goto _L10; else goto _L9
_L9:
        bO.b(k1);
        k1++;
_L10:
        if(k1 < ij + 27) goto _L9; else goto _L7
_L7:
        b.P[i1] = ij;
        ij += 27;
        i1++;
_L2:
        if(i1 >= b.J)
        {
            System.out.println("Loaded: " + i + " frames of animation");
            return;
        }
        if(true) goto _L1; else goto _L11
_L11:
    }

    public void x()
    {
        byte abyte0[];
        byte abyte1[];
        int i;
        int l1;
        l1 = b.bN;
        abyte0 = a("textures" + e.g + ".jag", "Textures", 50);
        if(abyte0 == null)
        {
            bv = true;
            return;
        }
        abyte1 = a.f.a("index.dat", 0, abyte0);
        bN.b(b.G, 7, 11);
        i = 0;
        if(l1 == 0) goto _L2; else goto _L1
_L1:
        int i1;
        int j1;
        int k1;
        String s1 = b.H[i];
        byte abyte2[] = a.f.a(s1 + ".dat", 0, abyte0);
        bO.a(bY, abyte2, abyte1, 1);
        bO.b(0, 0, 128, 128, 0xff00ff);
        bO.c(0, 0, bY);
        i1 = ((g) (bO)).r[bY];
        String s2 = b.I[i];
        if(s2 != null && s2.length() > 0)
        {
            byte abyte3[] = a.f.a(s2 + ".dat", 0, abyte0);
            bO.a(bY, abyte3, abyte1, 1);
            bO.c(0, 0, bY);
        }
        bO.e(bZ + i, 0, 0, i1, i1);
        j1 = i1 * i1;
        k1 = 0;
        if(l1 == 0) goto _L4; else goto _L3
_L3:
        if(((g) (bO)).k[bZ + i][k1] == 65280)
            ((g) (bO)).k[bZ + i][k1] = 0xff00ff;
        k1++;
_L4:
        if(k1 < j1) goto _L3; else goto _L5
_L5:
        bO.a(bZ + i);
        bN.a(i, ((g) (bO)).l[bZ + i], ((g) (bO)).m[bZ + i], i1 / 64 - 1);
        i++;
_L2:
        if(i >= b.G)
            return;
        if(true) goto _L1; else goto _L6
_L6:
    }

    public void y()
    {
        byte abyte0[];
        int i1;
        int k1;
        k1 = b.bN;
        b.a("torcha2");
        b.a("torcha3");
        b.a("torcha4");
        b.a("skulltorcha2");
        b.a("skulltorcha3");
        b.a("skulltorcha4");
        b.a("firea2");
        b.a("firea3");
        b.a("fireplacea2");
        b.a("fireplacea3");
        b.a("firespell2");
        b.a("firespell3");
        b.a("lightning2");
        b.a("lightning3");
        b.a("clawspell2");
        b.a("clawspell3");
        b.a("clawspell4");
        b.a("clawspell5");
        b.a("spellcharge2");
        b.a("spellcharge3");
        if(!f())
            break MISSING_BLOCK_LABEL_305;
        abyte0 = a("models" + e.f + ".jag", "3d models", 60);
        if(abyte0 == null)
        {
            bv = true;
            return;
        }
        i1 = 0;
        if(k1 == 0) goto _L2; else goto _L1
_L1:
label0:
        {
            int j1 = a.f.a(b.bI[i1] + ".ob3", abyte0);
            if(j1 != 0)
            {
                dm[i1] = new f(abyte0, j1, true);
                if(k1 == 0)
                    break label0;
            }
            dm[i1] = new f(1, 1);
        }
        if(b.bI[i1].equals("giantcrystal"))
            dm[i1].E = true;
        i1++;
_L2:
        if(i1 < b.bH) goto _L1; else goto _L3
_L3:
        return;
        int i;
        b(70, "Loading 3d models");
        i = 0;
        if(k1 == 0) goto _L5; else goto _L4
_L4:
        dm[i] = new f("../gamedata/models/" + b.bI[i] + ".ob2");
        if(b.bI[i].equals("giantcrystal"))
            dm[i].E = true;
        i++;
_L5:
        if(i >= b.bH)
            return;
        if(true) goto _L4; else goto _L6
_L6:
    }

    public void z()
    {
        cm.j = a("maps" + e.d + ".jag", "map", 70);
        if(bq)
            cm.l = a("maps" + e.d + ".mem", "members map", 75);
        cm.i = a("land" + e.d + ".jag", "landscape", 80);
        if(bq)
            cm.k = a("land" + e.d + ".mem", "members landscape", 85);
    }

    public void A()
    {
        try
        {
            iA = a("sounds" + e.i + ".mem", "Sound effects", 90);
            iB = new d();
            return;
        }
        catch(Throwable throwable)
        {
            System.out.println("Unable to init sounds:" + throwable);
        }
    }

    public void B()
    {
        eG = new e(bO, 10);
        eH = eG.a(5, 269, 502, 56, 1, 20, true);
        eI = eG.a(7, 324, 498, 14, 1, 80, false, true);
        eJ = eG.a(5, 269, 502, 56, 1, 20, true);
        eK = eG.a(5, 269, 502, 56, 1, 20, true);
        eG.h(eI);
    }

    public void b() //called every update
    {
        if(bt)
            return;
        if(bu)
            return;
        if(bv)
            return;
        try
        {
            bx++;
            if(bQ == 0)
            {
                super.l = 0;
                T();
            }
            if(bQ == 1)
            {
                super.l++;
                U();
            }
            super.J = 0;
            super.L = 0;
            bK++;
            if(bK > 500)
            {
                bK = 0;
                int i = (int)(Math.random() * 4D);
                if((i & 1) == 1)
                    bG += bH;
                if((i & 2) == 2)
                    bI += bJ;
            }
            if(bG < -50)
                bH = 2;
            if(bG > 50)
                bH = -2;
            if(bI < -50)
                bJ = 2;
            if(bI > 50)
                bJ = -2;
            if(eC > 0)
                eC--;
            if(eD > 0)
                eD--;
            if(eE > 0)
                eE--;
            if(eF > 0)
            {
                eF--;
                return;
            }
        }
        catch(OutOfMemoryError _ex)
        {
            C();
            bu = true;
        }
    }

    public void d()
    {
        if(bv)
        {
            Graphics g1 = getGraphics();
            g1.setColor(Color.black);
            g1.fillRect(0, 0, 512, 356);
            g1.setFont(new Font("Helvetica", 1, 16));
            g1.setColor(Color.yellow);
            int i = 35;
            g1.drawString("Sorry, an error has occured whilst loading RuneScape", 30, i);
            i += 50;
            g1.setColor(Color.white);
            g1.drawString("To fix this try the following (in order):", 30, i);
            i += 50;
            g1.setColor(Color.white);
            g1.setFont(new Font("Helvetica", 1, 12));
            g1.drawString("1: Try closing ALL open web-browser windows, and reloading", 30, i);
            i += 30;
            g1.drawString("2: Try clearing your web-browsers cache from tools->internet options", 30, i);
            i += 30;
            g1.drawString("3: Try using a different game-world", 30, i);
            i += 30;
            g1.drawString("4: Try rebooting your computer", 30, i);
            i += 30;
            g1.drawString("5: Try selecting a different version of Java from the play-game menu", 30, i);
            a(1);
            return;
        }
        if(bt)
        {
            Graphics g2 = getGraphics();
            g2.setColor(Color.black);
            g2.fillRect(0, 0, 512, 356);
            g2.setFont(new Font("Helvetica", 1, 20));
            g2.setColor(Color.white);
            g2.drawString("Error - unable to load game!", 50, 50);
            g2.drawString("To play RuneScape make sure you play from", 50, 100);
            g2.drawString("http://www.runescape.com", 50, 150);
            a(1);
            return;
        }
        if(bu)
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
            a(1);
            return;
        }
        try
        {
            if(bQ == 0)
            {
                bO.C = false;
                R();
            }
            if(bQ == 1)
            {
                bO.C = true;
                X();
                return;
            }
        }
        catch(OutOfMemoryError _ex)
        {
            C();
            bu = true;
        }
    }

    public void c()
    {
        k();
        C();
        if(iB != null)
            iB.a();
    }

    public void C()
    {
        try
        {
            if(bO != null)
            {
                bO.e();
                bO.g = null;
                bO = null;
            }
            if(bN != null)
            {
                bN.a();
                bN = null;
            }
            dm = null;
            dh = null;
            dr = null;
            cK = null;
            cL = null;
            cV = null;
            cW = null;
            cN = null;
            if(cm != null)
            {
                cm.C = null;
                cm.D = null;
                cm.E = null;
                cm.F = null;
                cm = null;
            }
            System.gc();
            return;
        }
        catch(Exception _ex)
        {
            return;
        }
    }

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
                eG.b(i);
            if(gl == 3 || gl == 4 || gl == 5 || gl == 7)
                gl = 0;
        }
    }

    public void a(int i, int i1, int j1) //MouseDown(int button,int x,int y), J is also button down
    {
        int k1;
        int l2;
        l2 = b.bN;
        bE[bD] = i1;
        bF[bD] = j1;
        bD = bD + 1 & 0x1fff;
        k1 = 10;
        if(l2 == 0) goto _L2; else goto _L1
_L1:
        int l1;
        boolean flag;
        int i2;
        l1 = bD - k1 & 0x1fff;
        if(bE[l1] != i1 || bF[l1] != j1)
            continue;
        flag = false;
        i2 = 1;
        if(l2 == 0) goto _L4; else goto _L3
_L3:
        int j2 = bD - i2 & 0x1fff;
        int k2 = l1 - i2 & 0x1fff;
        if(bE[k2] != i1 || bF[k2] != j1)
            flag = true;
        if(bE[j2] != bE[k2] || bF[j2] != bF[k2])
            break; /* Loop/switch isn't completed */
        if(i2 == k1 - 1 && flag && gz == 0 && gy == 0)
        {
            F();
            return;
        }
        i2++;
_L4:
        if(i2 < k1) goto _L3; else goto _L5
_L5:
        k1++;
_L2:
        if(k1 >= 4000)
            return;
        if(true) goto _L1; else goto _L6
_L6:
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

    public void E()
    {
        super.P = "";
        super.Q = "";
    }

    public void F()
    {
        if(bQ == 0)
            return;
        if(gz > 450)
        {
            b("@cya@You can't logout during combat!", 3);
            return;
        }
        if(gz > 0)
        {
            b("@cya@You can't logout for 10 seconds after combat", 3);
            return;
        } else
        {
            super.Y.a(6, 156);
            super.Y.g();
            gy = 1000;
            return;
        }
    }

    public void e(String s1) //play a sound
    {
        if(iB == null)
            return;
        if(el)
        {
            return;
        } else
        {
            iB.a(iA, a.f.a(s1 + ".pcm", iA), a.f.b(s1 + ".pcm", iA));
            return;
        }
    }

    public void G()
    {
        int i;
        int i1;
        hp = new e(bO, 100);
        i = 8;
        hq = hp.b(256, i, "@yel@Please provide 5 security questions in case you lose your password", 1, true);
        i += 22;
        hp.b(256, i, "If you ever lose your password, you will need these to prove you own your account.", 1, true);
        i += 13;
        hp.b(256, i, "Your answers are encrypted and are ONLY used for password recovery purposes.", 1, true);
        i += 22;
        hp.b(256, i, "@ora@IMPORTANT:@whi@ To recover your password you must give the EXACT same answers you", 1, true);
        i += 13;
        hp.b(256, i, "give here. If you think you might forget an answer, or someone else could guess the", 1, true);
        i += 13;
        hp.b(256, i, "answer, then press the 'different question' button to get a better question.", 1, true);
        i += 35;
        i1 = 0;
        if(b.bN == 0) goto _L2; else goto _L1
_L1:
        hp.d(170, i, 310, 30);
        hy[i1] = iJ[hx[i1]];
        ht[i1] = hp.b(170, i - 7, (i1 + 1) + ": " + iJ[hx[i1]], 1, true);
        hu[i1] = hp.b(170, i + 7, 310, 30, 1, 80, false, true);
        hp.d(370, i, 80, 30);
        hp.b(370, i - 7, "Different", 1, true);
        hp.b(370, i + 7, "Question", 1, true);
        hv[i1] = hp.f(370, i, 80, 30);
        hp.d(455, i, 80, 30);
        hp.b(455, i - 7, "Enter own", 1, true);
        hp.b(455, i + 7, "Question", 1, true);
        hw[i1] = hp.f(455, i, 80, 30);
        i += 35;
        i1++;
_L2:
        if(i1 >= 5)
        {
            hp.h(hu[0]);
            i += 10;
            hp.d(256, i, 250, 30);
            hp.b(256, i, "Click here when finished", 4, true);
            hr = hp.f(256, i, 250, 30);
            return;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void H()
    {
        int i;
        int j2;
        j2 = b.bN;
        if(hs != -1)
        {
            if(super.Q.length() > 0)
            {
                hy[hs] = super.Q;
                hp.a(ht[hs], (hs + 1) + ": " + hy[hs]);
                hp.a(hu[hs], "");
                hs = -1;
            }
            return;
        }
        hp.a(super.G, super.H, super.J, super.I);
        i = 0;
        if(j2 == 0) goto _L2; else goto _L1
_L1:
        int i1;
        if(!hp.a(hv[i]))
            continue; /* Loop/switch isn't completed */
        i1 = 0;
        if(j2 == 0) goto _L4; else goto _L3
_L3:
        int j1;
        hx[i] = (hx[i] + 1) % iJ.length;
        i1 = 1;
        j1 = 0;
        if(j2 == 0) goto _L6; else goto _L5
_L5:
        if(j1 != i && hx[j1] == hx[i])
            i1 = 0;
        j1++;
_L6:
        if(j1 < 5) goto _L5; else goto _L4
_L4:
        if(!i1) goto _L3; else goto _L7
_L7:
        hy[i] = iJ[hx[i]];
        hp.a(ht[i], (i + 1) + ": " + iJ[hx[i]]);
        hp.a(hu[i], "");
        i++;
_L2:
        if(i < 5) goto _L1; else goto _L8
_L8:
        i1 = 0;
        if(j2 == 0) goto _L10; else goto _L9
_L9:
        if(hp.a(hw[i1]))
        {
            hs = i1;
            super.P = "";
            super.Q = "";
        }
        i1++;
_L10:
        if(i1 < 5) goto _L9; else goto _L11
_L11:
        if(!hp.a(hr))
            break MISSING_BLOCK_LABEL_829;
        j1 = 0;
        if(j2 == 0) goto _L13; else goto _L12
_L12:
        String s1 = hp.e(hu[j1]);
        if(s1 == null || s1.length() < 3)
        {
            hp.a(hq, "@yel@Please provide a longer answer to question: " + (j1 + 1));
            return;
        }
        j1++;
_L13:
        if(j1 < 5) goto _L12; else goto _L14
_L14:
        int k1 = 0;
        if(j2 == 0) goto _L16; else goto _L15
_L15:
        String s2;
        int i2;
        s2 = hp.e(hu[k1]);
        i2 = 0;
        if(j2 == 0) goto _L18; else goto _L17
_L17:
        String s4 = hp.e(hu[i2]);
        if(s2.equalsIgnoreCase(s4))
        {
            hp.a(hq, "@yel@Each question must have a different answer");
            return;
        }
        i2++;
_L18:
        if(i2 < k1) goto _L17; else goto _L19
_L19:
        k1++;
_L16:
        if(k1 < 5) goto _L15; else goto _L20
_L20:
        int l1;
        super.Y.a(208, 457);
        l1 = 0;
        if(j2 == 0) goto _L22; else goto _L21
_L21:
        String s3 = hy[l1];
        if(s3 == null || s3.length() == 0)
            s3 = String.valueOf(l1 + 1);
        if(s3.length() > 50)
            s3 = s3.substring(0, 50);
        String s5 = hp.e(hu[l1]);
        s5 = a.f.b(s5, 50);
        super.Y.a(s3.length());
        super.Y.a(s3);
        super.Y.a(s5.length());
        super.Y.a(s5, super.bn, br, bs);
        l1++;
_L22:
        if(l1 < 5) goto _L21; else goto _L23
_L23:
        super.Y.g();
        s3 = 0;
        if(j2 == 0) goto _L25; else goto _L24
_L24:
        hx[s3] = s3;
        hy[s3] = iJ[hx[s3]];
        hp.a(hu[s3], "");
        hp.a(ht[s3], (s3 + 1) + ": " + hy[s3]);
        s3++;
_L25:
        if(s3 < 5) goto _L24; else goto _L26
_L26:
        bO.c();
        ho = false;
    }

    public void I()
    {
        bO.y = false;
        bO.c();
        hp.a();
        if(hs != -1)
        {
            int i = 150;
            bO.b(26, i, 460, 60, 0);
            bO.c(26, i, 460, 60, 0xffffff);
            i += 22;
            bO.b("Please enter your question", 256, i, 4, 0xffffff);
            i += 25;
            bO.b(super.P + "*", 256, i, 4, 0xffffff);
        }
        bO.c(0, bS, bU + 22);
        bO.a(bM, 0, 0);
    }

    public void J()
    {
        int i;
        int i1;
        hA = new e(bO, 100);
        i = 10;
        hB = hA.b(256, i, "@yel@To prove this is your account please provide the answers to", 1, true);
        i += 15;
        hC = hA.b(256, i, "@yel@your security questions. You will then be able to reset your password", 1, true);
        i += 35;
        i1 = 0;
        if(b.bN == 0) goto _L2; else goto _L1
_L1:
        hA.d(256, i, 410, 30);
        hI[i1] = hA.b(256, i - 7, (i1 + 1) + ": question?", 1, true);
        hJ[i1] = hA.b(256, i + 7, 310, 30, 1, 80, true, true);
        i += 35;
        i1++;
_L2:
        if(i1 >= 5)
        {
            hA.h(hJ[0]);
            hA.d(256, i, 410, 30);
            hA.b(256, i - 7, "If you know it, enter a previous password used on this account", 1, true);
            hD = hA.b(256, i + 7, 310, 30, 1, 80, true, true);
            i += 35;
            hA.d(151, i, 200, 30);
            hA.b(151, i - 7, "Choose a NEW password", 1, true);
            hE = hA.b(146, i + 7, 200, 30, 1, 80, true, true);
            hA.d(361, i, 200, 30);
            hA.b(361, i - 7, "Confirm new password", 1, true);
            hF = hA.b(366, i + 7, 200, 30, 1, 80, true, true);
            i += 35;
            hA.d(201, i, 100, 30);
            hA.b(201, i, "Submit", 4, true);
            hG = hA.f(201, i, 100, 30);
            hA.d(311, i, 100, 30);
            hA.b(311, i, "Cancel", 4, true);
            hH = hA.f(311, i, 100, 30);
            return;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void K()
    {
        hL = new e(bO, 100);
        char c1 = '\u0100';
        char c2 = '\u0190';
        int i = 25;
        hM = hL.b(256, i, "@yel@Please supply your contact details", 5, true);
        i += 30;
        hL.b(256, i, "We need this information to provide an efficient customer support service ", 1, true);
        i += 15;
        hL.b(256, i, "and also to work out where to locate future RuneScape servers.", 1, true);
        i += 25;
        hL.b(256, i, "We know some people are concerned about entering their email address on", 1, true);
        i += 15;
        hL.b(255, i, "websites, and for this reason we take our users privacy very seriously.", 1, true);
        i += 15;
        hL.b(256, i, "For our full policy please click the relevant link below this game window", 1, true);
        i += 40;
        hL.d(c1, i, c2, 30);
        hL.b(c1, i - 7, "Full name", 1, true);
        hN = hL.b(c1, i + 7, c2, 30, 1, 80, false, true);
        i += 35;
        hL.d(c1, i, c2, 30);
        hL.b(c1, i - 7, "Postcode/Zipcode", 1, true);
        hO = hL.b(c1, i + 7, c2, 30, 1, 80, false, true);
        i += 35;
        hL.d(c1, i, c2, 30);
        hL.b(c1, i - 7, "Country", 1, true);
        hP = hL.b(c1, i + 7, c2, 30, 1, 80, false, true);
        i += 35;
        hL.d(c1, i, c2, 30);
        hL.b(c1, i - 7, "Email address", 1, true);
        hQ = hL.b(c1, i + 7, c2, 30, 1, 80, false, true);
        i += 35;
        hL.d(c1, i, 100, 30);
        hL.b(c1, i, "Submit", 4, true);
        hR = hL.f(c1, i, 100, 30);
        hL.h(hN);
    }

    public void L()
    {
        bO.y = false;
        bO.c();
        hL.a();
        bO.c(0, bS, bU + 22);
        bO.a(bM, 0, 0);
    }

    public void M()
    {
        hL.a(super.G, super.H, super.J, super.I);
        if(hL.a(hN))
            hL.h(hO);
        if(hL.a(hO))
            hL.h(hP);
        if(hL.a(hP))
            hL.h(hQ);
        if(hL.a(hQ))
            hL.h(hN);
        if(hL.a(hR))
        {
            String s1 = hL.e(hN);
            String s2 = hL.e(hO);
            String s3 = hL.e(hP);
            String s4 = hL.e(hQ);
            if(s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0 || s3 == null || s3.length() == 0 || s4 == null || s4.length() == 0)
            {
                hL.a(hM, "@yel@Please fill in all the requested details");
                return;
            }
            super.Y.a(253, 155);
            super.Y.a(s1.length());
            super.Y.a(s1);
            super.Y.a(s2.length());
            super.Y.a(s2);
            super.Y.a(s3.length());
            super.Y.a(s3);
            super.Y.a(s4.length());
            super.Y.a(s4);
            super.Y.g();
            bO.c();
            hK = false;
        }
    }

    public void N()
    {
        ha = new e(bO, 100);
        ha.b(256, 10, "Please design Your Character", 4, true);
        int i = 140;
        int i1 = 34;
        i += 116;
        i1 -= 10;
        ha.b(i - 55, i1 + 110, "Front", 3, true);
        ha.b(i, i1 + 110, "Side", 3, true);
        ha.b(i + 55, i1 + 110, "Back", 3, true);
        byte byte0 = 54;
        i1 += 145;
        ha.e(i - byte0, i1, 53, 41);
        ha.b(i - byte0, i1 - 8, "Head", 1, true);
        ha.b(i - byte0, i1 + 8, "Type", 1, true);
        ha.d(i - byte0 - 40, i1, e.P + 7);
        hb = ha.f(i - byte0 - 40, i1, 20, 20);
        ha.d((i - byte0) + 40, i1, e.P + 6);
        hc = ha.f((i - byte0) + 40, i1, 20, 20);
        ha.e(i + byte0, i1, 53, 41);
        ha.b(i + byte0, i1 - 8, "Hair", 1, true);
        ha.b(i + byte0, i1 + 8, "Color", 1, true);
        ha.d((i + byte0) - 40, i1, e.P + 7);
        hd = ha.f((i + byte0) - 40, i1, 20, 20);
        ha.d(i + byte0 + 40, i1, e.P + 6);
        he = ha.f(i + byte0 + 40, i1, 20, 20);
        i1 += 50;
        ha.e(i - byte0, i1, 53, 41);
        ha.b(i - byte0, i1, "Gender", 1, true);
        ha.d(i - byte0 - 40, i1, e.P + 7);
        hf = ha.f(i - byte0 - 40, i1, 20, 20);
        ha.d((i - byte0) + 40, i1, e.P + 6);
        hg = ha.f((i - byte0) + 40, i1, 20, 20);
        ha.e(i + byte0, i1, 53, 41);
        ha.b(i + byte0, i1 - 8, "Top", 1, true);
        ha.b(i + byte0, i1 + 8, "Color", 1, true);
        ha.d((i + byte0) - 40, i1, e.P + 7);
        hh = ha.f((i + byte0) - 40, i1, 20, 20);
        ha.d(i + byte0 + 40, i1, e.P + 6);
        hi = ha.f(i + byte0 + 40, i1, 20, 20);
        i1 += 50;
        ha.e(i - byte0, i1, 53, 41);
        ha.b(i - byte0, i1 - 8, "Skin", 1, true);
        ha.b(i - byte0, i1 + 8, "Color", 1, true);
        ha.d(i - byte0 - 40, i1, e.P + 7);
        hj = ha.f(i - byte0 - 40, i1, 20, 20);
        ha.d((i - byte0) + 40, i1, e.P + 6);
        hk = ha.f((i - byte0) + 40, i1, 20, 20);
        ha.e(i + byte0, i1, 53, 41);
        ha.b(i + byte0, i1 - 8, "Bottom", 1, true);
        ha.b(i + byte0, i1 + 8, "Color", 1, true);
        ha.d((i + byte0) - 40, i1, e.P + 7);
        hl = ha.f((i + byte0) - 40, i1, 20, 20);
        ha.d(i + byte0 + 40, i1, e.P + 6);
        hm = ha.f(i + byte0 + 40, i1, 20, 20);
        i1 += 82;
        i1 -= 35;
        ha.d(i, i1, 200, 30);
        ha.b(i, i1, "Accept", 4, false);
        hn = ha.f(i, i1, 200, 30);
    }

    public void O()
    {
        bO.y = false;
        bO.c();
        ha.a();
        int i = 140;
        int i1 = 50;
        i += 116;
        i1 -= 25;
        bO.e(i - 32 - 55, i1, 64, 102, b.P[io], iu[ir]);
        bO.a(i - 32 - 55, i1, 64, 102, b.P[in], iu[iq], iw[is], 0, false);
        bO.a(i - 32 - 55, i1, 64, 102, b.P[im], iv[ip], iw[is], 0, false);
        bO.e(i - 32, i1, 64, 102, b.P[io] + 6, iu[ir]);
        bO.a(i - 32, i1, 64, 102, b.P[in] + 6, iu[iq], iw[is], 0, false);
        bO.a(i - 32, i1, 64, 102, b.P[im] + 6, iv[ip], iw[is], 0, false);
        bO.e((i - 32) + 55, i1, 64, 102, b.P[io] + 12, iu[ir]);
        bO.a((i - 32) + 55, i1, 64, 102, b.P[in] + 12, iu[iq], iw[is], 0, false);
        bO.a((i - 32) + 55, i1, 64, 102, b.P[im] + 12, iv[ip], iw[is], 0, false);
        bO.c(0, bS, bU + 22);
        bO.a(bM, 0, 0);
    }

    public void P()
    {
        int i;
        i = b.bN;
        ha.a(super.G, super.H, super.J, super.I);
        if(ha.a(hb))
            do
                im = ((im - 1) + b.J) % b.J;
            while((b.M[im] & 3) != 1 || (b.M[im] & 4 * it) == 0);
        if(ha.a(hc))
            do
                im = (im + 1) % b.J;
            while((b.M[im] & 3) != 1 || (b.M[im] & 4 * it) == 0);
        if(ha.a(hd))
            ip = ((ip - 1) + iv.length) % iv.length;
        if(ha.a(he))
            ip = (ip + 1) % iv.length;
        if(!ha.a(hf) && !ha.a(hg)) goto _L2; else goto _L1
_L1:
        it = 3 - it;
        if(i == 0) goto _L4; else goto _L3
_L3:
        im = (im + 1) % b.J;
_L4:
        if((b.M[im] & 3) != 1 || (b.M[im] & 4 * it) == 0) goto _L3; else goto _L5
_L5:
        if(i == 0) goto _L7; else goto _L6
_L6:
        in = (in + 1) % b.J;
_L7:
        if((b.M[in] & 3) != 2 || (b.M[in] & 4 * it) == 0) goto _L6; else goto _L2
_L2:
        if(ha.a(hh))
            iq = ((iq - 1) + iu.length) % iu.length;
        if(ha.a(hi))
            iq = (iq + 1) % iu.length;
        if(ha.a(hj))
            is = ((is - 1) + iw.length) % iw.length;
        if(ha.a(hk))
            is = (is + 1) % iw.length;
        if(ha.a(hl))
            ir = ((ir - 1) + iu.length) % iu.length;
        if(ha.a(hm))
            ir = (ir + 1) % iu.length;
        if(ha.a(hn))
        {
            super.Y.a(236, 65);
            super.Y.a(it);
            super.Y.a(im);
            super.Y.a(in);
            super.Y.a(io);
            super.Y.a(ip);
            super.Y.a(iq);
            super.Y.a(ir);
            super.Y.a(is);
            super.Y.g();
            bO.c();
            il = false;
        }
        return;
    }

    public void Q()
    {
label0:
        {
            gE = new e(bO, 50);
            byte byte0 = 40;
            if(!bq)
            {
                gE.b(256, 200 + byte0, "Click on an option", 5, true);
                gE.d(156, 240 + byte0, 120, 35);
                gE.d(356, 240 + byte0, 120, 35);
                gE.b(156, 240 + byte0, "New User", 5, false);
                gE.b(356, 240 + byte0, "Existing User", 5, false);
                gF = gE.f(156, 240 + byte0, 120, 35);
                gG = gE.f(356, 240 + byte0, 120, 35);
                if(b.bN == 0)
                    break label0;
            }
            gE.b(256, 200 + byte0, "Welcome to RuneScape", 4, true);
            gE.b(256, 215 + byte0, "You need a member account to use this server", 4, true);
            gE.d(256, 250 + byte0, 200, 35);
            gE.b(256, 250 + byte0, "Click here to login", 5, false);
            gG = gE.f(256, 250 + byte0, 200, 35);
        }
        gH = new e(bO, 50);
        int i = 70;
        gI = gH.b(256, i + 8, "To create an account please enter all the requested details", 4, true);
        i += 25;
        gH.d(256, i + 17, 250, 34);
        gH.b(256, i + 8, "Choose a Username", 4, false);
        gL = gH.b(256, i + 25, 200, 40, 4, 12, false, false);
        gH.h(gL);
        i += 40;
        gH.d(141, i + 17, 220, 34);
        gH.b(141, i + 8, "Choose a Password", 4, false);
        gM = gH.b(141, i + 25, 220, 40, 4, 20, true, false);
        gH.d(371, i + 17, 220, 34);
        gH.b(371, i + 8, "Confirm Password", 4, false);
        gN = gH.b(371, i + 25, 220, 40, 4, 20, true, false);
        i += 40;
        i += 20;
        gO = gH.e(60, i, 14);
        gH.a(75, i, "I have read and agree to your terms and conditions", 4, true);
        i += 15;
        gH.b(256, i, "(to view these click the relevant link below this game window)", 4, true);
        i += 20;
        gH.d(156, i + 17, 150, 34);
        gH.b(156, i + 17, "Submit", 5, false);
        gK = gH.f(156, i + 17, 150, 34);
        gH.d(356, i + 17, 150, 34);
        gH.b(356, i + 17, "Cancel", 5, false);
        gJ = gH.f(356, i + 17, 150, 34);
        gP = new e(bO, 50);
        i = 230;
        gQ = gP.b(256, i - 10, "Please enter your username and password", 4, true);
        i += 28;
        gP.d(140, i, 200, 40);
        gP.b(140, i - 10, "Username:", 4, false);
        gR = gP.b(140, i + 10, 200, 40, 4, 12, false, false);
        i += 47;
        gP.d(190, i, 200, 40);
        gP.b(190, i - 10, "Password:", 4, false);
        gS = gP.b(190, i + 10, 200, 40, 4, 20, true, false);
        i -= 55;
        gP.d(410, i, 120, 25);
        gP.b(410, i, "Ok", 4, false);
        gT = gP.f(410, i, 120, 25);
        i += 30;
        gP.d(410, i, 120, 25);
        gP.b(410, i, "Cancel", 4, false);
        gU = gP.f(410, i, 120, 25);
        i += 30;
        gP.d(410, i, 160, 25);
        gP.b(410, i, "I've lost my password", 4, false);
        gV = gP.f(410, i, 160, 25);
        gP.h(gR);
    }

    public void R() //painting
    {
label0:
        {
            int i1 = b.bN;
            go = false;
            bO.y = false;
            bO.c();
            if(gD != 0 && gD != 2)
                break label0;
            int i = (bx * 2) % 3072;
            if(i < 1024)
            {
                bO.c(0, 10, ca);
                if(i <= 768)
                    break label0;
                bO.d(0, 10, ca + 1, i - 768);
                if(i1 == 0)
                    break label0;
            }
            if(i < 2048)
            {
                bO.c(0, 10, ca + 1);
                if(i <= 1792)
                    break label0;
                bO.d(0, 10, bU + 10, i - 1792);
                if(i1 == 0)
                    break label0;
            }
            bO.c(0, 10, bU + 10);
            if(i > 2816)
                bO.d(0, 10, ca, i - 2816);
        }
        if(gD == 0)
            gE.a();
        if(gD == 1)
            gH.a();
        if(gD == 2)
            gP.a();
        if(gD == 3)
            hA.a();
        bO.c(0, bS, bU + 22);
        bO.a(bM, 0, 0); //calls a.a.g.a(Graphics,int x,int y)
    }

    public void S()
    {
        int i1;
        int l2;
        l2 = b.bN;
        int i = 0;
        byte byte0 = 50;
        byte byte1 = 50;
        cm.i(byte0 * 48 + 23, byte1 * 48 + 23, i);
        cm.a(dm);
        char c1 = '\u2600';
        char c4 = '\u1900';
        char c7 = '\u044C';
        char c10 = '\u0378';
        bN.g = 4100;
        bN.h = 4100;
        bN.i = 1;
        bN.j = 4000;
        bN.b(c1, -cm.b(c1, c4), c4, 912, c10, 0, c7 * 2);
        bN.f();
        bO.d();
        bO.d();
        bO.b(0, 0, 512, 6, 0);
        i1 = 6;
        if(l2 == 0) goto _L2; else goto _L1
_L1:
        bO.c(0, i1, 0, i1, 512, 8);
        i1--;
_L2:
        if(i1 >= 1) goto _L1; else goto _L3
_L3:
        int j1;
        bO.b(0, 194, 512, 20, 0);
        j1 = 6;
        if(l2 == 0) goto _L5; else goto _L4
_L4:
        bO.c(0, j1, 0, 194 - j1, 512, 8);
        j1--;
_L5:
        if(j1 >= 1) goto _L4; else goto _L6
_L6:
        int k1;
        bO.c(15, 15, bU + 10);
        bO.e(ca, 0, 0, 512, 200);
        bO.a(ca);
        char c2 = '\u2400';
        char c5 = '\u2400';
        char c8 = '\u044C';
        char c11 = '\u0378';
        bN.g = 4100;
        bN.h = 4100;
        bN.i = 1;
        bN.j = 4000;
        bN.b(c2, -cm.b(c2, c5), c5, 912, c11, 0, c8 * 2);
        bN.f();
        bO.d();
        bO.d();
        bO.b(0, 0, 512, 6, 0);
        k1 = 6;
        if(l2 == 0) goto _L8; else goto _L7
_L7:
        bO.c(0, k1, 0, k1, 512, 8);
        k1--;
_L8:
        if(k1 >= 1) goto _L7; else goto _L9
_L9:
        int l1;
        bO.b(0, 194, 512, 20, 0);
        l1 = 6;
        if(l2 == 0) goto _L11; else goto _L10
_L10:
        bO.c(0, l1, 0, 194 - l1, 512, 8);
        l1--;
_L11:
        if(l1 >= 1) goto _L10; else goto _L12
_L12:
        int i2;
        bO.c(15, 15, bU + 10);
        bO.e(ca + 1, 0, 0, 512, 200);
        bO.a(ca + 1);
        i2 = 0;
        if(l2 == 0) goto _L14; else goto _L13
_L13:
        bN.b(cm.E[0][i2]);
        bN.b(cm.D[1][i2]);
        bN.b(cm.E[1][i2]);
        bN.b(cm.D[2][i2]);
        bN.b(cm.E[2][i2]);
        i2++;
_L14:
        if(i2 < 64) goto _L13; else goto _L15
_L15:
        int j2;
        char c3 = '\u2B80';
        char c6 = '\u2880';
        char c9 = '\u01F4';
        char c12 = '\u0178';
        bN.g = 4100;
        bN.h = 4100;
        bN.i = 1;
        bN.j = 4000;
        bN.b(c3, -cm.b(c3, c6), c6, 912, c12, 0, c9 * 2);
        bN.f();
        bO.d();
        bO.d();
        bO.b(0, 0, 512, 6, 0);
        j2 = 6;
        if(l2 == 0) goto _L17; else goto _L16
_L16:
        bO.c(0, j2, 0, j2, 512, 8);
        j2--;
_L17:
        if(j2 >= 1) goto _L16; else goto _L18
_L18:
        int k2;
        bO.b(0, 194, 512, 20, 0);
        k2 = 6;
        if(l2 == 0) goto _L20; else goto _L19
_L19:
        bO.c(0, k2, 0, 194, 512, 8);
        k2--;
_L20:
        if(k2 < 1)
        {
            bO.c(15, 15, bU + 10);
            bO.e(bU + 10, 0, 0, 512, 200);
            bO.a(bU + 10);
            return;
        }
        if(true) goto _L19; else goto _L21
_L21:
    }

    public void T() //called from b() when not logged in
    {
        int j2;
        j2 = b.bN;
        if(super.bo > 0)
            super.bo--;
        if(gD == 0)
        {
            gE.a(super.G, super.H, super.J, super.I);
            if(gE.a(gF))
            {
                gD = 1;
                gH.a(gL, "");
                gH.a(gM, "");
                gH.a(gN, "");
                gH.h(gL);
                gH.a(gO, 0);
                gH.a(gI, "To create an account please enter all the requested details");
            }
            if(gE.a(gG))
            {
                gD = 2;
                gP.a(gQ, "Please enter your username and password");
                gP.a(gR, "");
                gP.a(gS, "");
                gP.h(gR);
                return;
            }
            break MISSING_BLOCK_LABEL_1717;
        }
        if(gD == 1)
        {
            gH.a(super.G, super.H, super.J, super.I);
            if(gH.a(gL))
                gH.h(gM);
            if(gH.a(gM))
                gH.h(gN);
            if(gH.a(gN))
                gH.h(gL);
            if(gH.a(gJ))
                gD = 0;
            if(gH.a(gK))
            {
                if(gH.e(gL) == null || gH.e(gL).length() == 0 || gH.e(gM) == null || gH.e(gM).length() == 0)
                {
                    gH.a(gI, "@yel@Please fill in ALL requested information to continue!");
                    return;
                }
                if(!gH.e(gM).equalsIgnoreCase(gH.e(gN)))
                {
                    gH.a(gI, "@yel@The two passwords entered are not the same as each other!");
                    return;
                }
                if(gH.e(gM).length() < 5)
                {
                    gH.a(gI, "@yel@Your password must be at least 5 letters long");
                    return;
                }
                if(gH.e(gM).trim().equalsIgnoreCase(gH.e(gL).trim()))
                {
                    gH.a(gI, "@yel@Your password must not be the same as your username!");
                    return;
                }
                if(gH.i(gO) == 0)
                {
                    gH.a(gI, "@yel@You must agree to the terms+conditions to continue");
                    return;
                } else
                {
                    gH.a(gI, "Please wait... Creating new account");
                    R();
                    g();
                    String s1 = gH.e(gL);
                    String s3 = gH.e(gM);
                    b(s1, s3);
                    return;
                }
            }
            break MISSING_BLOCK_LABEL_1717;
        }
        if(gD != 2)
            break MISSING_BLOCK_LABEL_1214;
        gP.a(super.G, super.H, super.J, super.I);
        if(gP.a(gU))
            gD = 0;
        if(gP.a(gR))
            gP.h(gS);
        if(gP.a(gS) || gP.a(gT)) //login button pressed
        {
            gY = gP.e(gR);
            gZ = gP.e(gS);
            a(gY, gZ, false);
        }
        if(!gP.a(gV))
            break MISSING_BLOCK_LABEL_1717;
        gY = gP.e(gR);
        gY = a.f.a(gY, 20);
        if(gY.trim().length() == 0)
        {
            d("You must enter your username to recover your password", "");
            return;
        }
        d(b.R[6], b.R[7]);
        int i1;
        super.Y = new k(a(super.U, super.V), this);
        super.Y.B = b.T;
        super.Y.f();
        super.Y.a(4, 848);
        super.Y.a(a.f.b(gY));
        super.Y.h();
        super.Y.b();
        super.Y.b();
        int i = super.Y.b();
        i = super.Y.a(i, b.bp);
        System.out.println("Getpq response: " + i);
        if(i == 0)
        {
            d("Sorry, the recovery questions for this user have not been set", "");
            return;
        }
        i1 = 0;
        if(j2 == 0) goto _L2; else goto _L1
_L1:
        int j1 = super.Y.b();
        byte abyte0[] = new byte[5000];
        super.Y.a(j1, abyte0);
        String s6 = new String(abyte0, 0, j1);
        hA.a(hI[i1], s6);
        i1++;
_L2:
        if(i1 < 5) goto _L1; else goto _L3
_L3:
        int k1;
        if(hz)
        {
            d("Sorry, you have already attempted 1 recovery, try again later", "");
            return;
        }
        gD = 3;
        hA.a(hB, "@yel@To prove this is your account please provide the answers to");
        hA.a(hC, "@yel@your security questions. You will then be able to reset your password");
        k1 = 0;
        if(j2 == 0) goto _L5; else goto _L4
_L4:
        hA.a(hJ[k1], "");
        k1++;
_L5:
        if(k1 >= 5)
        {
            hA.a(hD, "");
            hA.a(hE, "");
            hA.a(hF, "");
            return;
        }
        if(true) goto _L4; else goto _L6
_L6:
        JVM INSTR pop ;
        d(b.R[12], b.R[13]);
        return;
        if(gD != 3)
            break MISSING_BLOCK_LABEL_1717;
        hA.a(super.G, super.H, super.J, super.I);
        if(!hA.a(hG))
            break MISSING_BLOCK_LABEL_1698;
        String s2 = hA.e(hE);
        String s4 = hA.e(hF);
        if(!s2.equalsIgnoreCase(s4))
        {
            d("@yel@The two new passwords entered are not the same as each other!", "");
            return;
        }
        if(s2.length() < 5)
        {
            d("@yel@Your new password must be at least 5 letters long", "");
            return;
        }
        d(b.R[6], b.R[7]);
        int l1;
        super.Y = new k(a(super.U, super.V), this);
        super.Y.B = b.T;
        k1 = super.Y.f();
        String s5 = a.f.a(hA.e(hD), 20);
        String s7 = a.f.a(hA.e(hE), 20);
        super.Y.a(8, 121);
        super.Y.a(a.f.b(gY));
        super.Y.c(j());
        super.Y.a(s5 + s7, k1, br, bs);
        l1 = 0;
        if(j2 == 0) goto _L8; else goto _L7
_L7:
        String s8 = hA.e(hJ[l1]);
        s8 = a.f.b(s8, 50);
        super.Y.a(s8.length());
        super.Y.a(s8, k1, br, bs);
        l1++;
_L8:
        if(l1 < 5) goto _L7; else goto _L9
_L9:
        super.Y.h();
        super.Y.b();
        int i2 = super.Y.b();
        i2 = super.Y.a(i2, b.bp);
        System.out.println("Recover response: " + i2);
        if(i2 == 0)
        {
            gD = 2;
            d("Sorry, recovery failed. You may try again in 1 hour", "");
            hz = true;
            return;
        }
        if(i2 == 1)
        {
            gD = 2;
            d("Your pass has been reset. You may now use the new pass to login", "");
            return;
        } else
        {
            gD = 2;
            d("Recovery failed! Attempts exceeded?", "");
            return;
        }
        JVM INSTR pop ;
        d(b.R[12], b.R[13]);
        if(hA.a(hH))
            gD = 0;
    }

    public void d(String s1, String s2)
    {
        if(gD == 1)
            gH.a(gI, s1 + " " + s2);
        if(gD == 2)
            gP.a(gQ, s1 + " " + s2);
        if(gD == 3)
        {
            hA.a(hB, s1);
            hA.a(hC, s2);
        }
        gX = s2;
        R();
        g();
    }

    public void r()
    {
        gy = 0;
        b("@cya@Sorry, you can't logout at the moment", 3);
    }

    public void l()
    {
        if(gy != 0)
        {
            q();
            return;
        } else
        {
            super.l();
            return;
        }
    }

    public void q()
    {
        gD = 0;
        bQ = 0;
        gy = 0;
    }

    public void p()
    {
        int i;
        int k2;
        k2 = b.bN;
        gh = 0;
        gy = 0;
        gD = 0;
        bQ = 1;
        E();
        bO.c();
        bO.a(bM, 0, 0);
        i = 0;
        if(k2 == 0) goto _L2; else goto _L1
_L1:
        bN.b(dh[i]);
        cm.d(di[i], dj[i], dk[i]);
        i++;
_L2:
        if(i < dg) goto _L1; else goto _L3
_L3:
        int i1 = 0;
        if(k2 == 0) goto _L5; else goto _L4
_L4:
        bN.b(dr[i1]);
        cm.b(ds[i1], dt[i1], du[i1], dv[i1]);
        i1++;
_L5:
        if(i1 < dq) goto _L4; else goto _L6
_L6:
        int j1;
        dg = 0;
        dq = 0;
        da = 0;
        cH = 0;
        j1 = 0;
        if(k2 == 0) goto _L8; else goto _L7
_L7:
        cK[j1] = null;
        j1++;
_L8:
        if(j1 < cF) goto _L7; else goto _L9
_L9:
        int k1 = 0;
        if(k2 == 0) goto _L11; else goto _L10
_L10:
        cL[k1] = null;
        k1++;
_L11:
        if(k1 < cG) goto _L10; else goto _L12
_L12:
        int l1;
        cT = 0;
        l1 = 0;
        if(k2 == 0) goto _L14; else goto _L13
_L13:
        cV[l1] = null;
        l1++;
_L14:
        if(l1 < cR) goto _L13; else goto _L15
_L15:
        int i2 = 0;
        if(k2 == 0) goto _L17; else goto _L16
_L16:
        cW[i2] = null;
        i2++;
_L17:
        if(i2 < cS) goto _L16; else goto _L18
_L18:
        int j2 = 0;
        if(k2 == 0) goto _L20; else goto _L19
_L19:
        eh[j2] = false;
        j2++;
_L20:
        if(j2 >= 50)
        {
            bz = 0;
            super.J = 0;
            super.I = 0;
            fL = false;
            fT = false;
            iH = false;
            return;
        }
        if(true) goto _L19; else goto _L21
_L21:
    }

    public void s()
    {
        String s1 = gH.e(gL);
        String s2 = gH.e(gM);
        gD = 2;
        gP.a(gQ, "Please enter your username and password");
        gP.a(gR, s1);
        gP.a(gS, s2);
        R();
        g();
        a(s1, s2, false);
    }

    public void U() //called every update when logged in
    {
        int i;
        int i6;
        i6 = b.bN;
        m();
        if(gy > 0)
            gy--;
        if(super.l > 4500 && gz == 0 && gy == 0)
        {
            super.l -= 500;
            F();
            return;
        }
        if(cN.i == 8 || cN.i == 9)
            gz = 500;
        if(gz > 0)
            gz--;
        if(il)
        {
            P();
            return;
        }
        if(ho)
        {
            H();
            return;
        }
        if(hK)
        {
            M();
            return;
        }
        i = 0;
        if(i6 == 0) goto _L2; else goto _L1
_L1:
        c c1;
label0:
        {
label1:
            {
                int l1;
                int l2;
                int j4;
label2:
                {
                    c1 = cL[i];
                    int j1 = (c1.l + 1) % 10;
                    if(c1.k == j1)
                        break label1;
                    l1 = -1;
                    l2 = c1.k;
                    if(l2 < j1)
                    {
                        j4 = j1 - l2;
                        if(i6 == 0)
                            break label2;
                    }
                    j4 = (10 + j1) - l2;
                }
label3:
                {
                    int j5;
label4:
                    {
                        j5 = 4;
                        if(j4 > 2)
                            j5 = (j4 - 1) * 4;
                        if(c1.m[l2] - c1.e > bP * 3 || c1.n[l2] - c1.f > bP * 3 || c1.m[l2] - c1.e < -bP * 3 || c1.n[l2] - c1.f < -bP * 3 || j4 > 8)
                        {
                            c1.e = c1.m[l2];
                            c1.f = c1.n[l2];
                            if(i6 == 0)
                                break label3;
                        }
                        if(c1.e < c1.m[l2])
                        {
                            c1.e += j5;
                            c1.h++;
                            l1 = 2;
                            if(i6 == 0)
                                break label4;
                        }
                        if(c1.e > c1.m[l2])
                        {
                            c1.e -= j5;
                            c1.h++;
                            l1 = 6;
                        }
                    }
label5:
                    {
                        if(c1.e - c1.m[l2] < j5 && c1.e - c1.m[l2] > -j5)
                            c1.e = c1.m[l2];
                        if(c1.f < c1.n[l2])
                        {
                            c1.f += j5;
                            c1.h++;
                            if(l1 == -1)
                            {
                                l1 = 4;
                                if(i6 == 0)
                                    break label5;
                            }
                            if(l1 == 2)
                            {
                                l1 = 3;
                                if(i6 == 0)
                                    break label5;
                            }
                            l1 = 5;
                            if(i6 == 0)
                                break label5;
                        }
                        if(c1.f <= c1.n[l2])
                            break label5;
                        c1.f -= j5;
                        c1.h++;
                        if(l1 == -1)
                        {
                            l1 = 0;
                            if(i6 == 0)
                                break label5;
                        }
                        if(l1 == 2)
                        {
                            l1 = 1;
                            if(i6 == 0)
                                break label5;
                        }
                        l1 = 7;
                    }
                    if(c1.f - c1.n[l2] < j5 && c1.f - c1.n[l2] > -j5)
                        c1.f = c1.n[l2];
                }
                if(l1 != -1)
                    c1.i = l1;
                if(c1.e != c1.m[l2] || c1.f != c1.n[l2])
                    break label0;
                c1.k = (l2 + 1) % 10;
                if(i6 == 0)
                    break label0;
            }
            c1.i = c1.j;
        }
        if(c1.q > 0)
            c1.q--;
        if(c1.s > 0)
            c1.s--;
        if(c1.w > 0)
            c1.w--;
        if(gA > 0)
        {
            gA--;
            if(gA == 0)
                b("You have been granted another life. Be more careful this time!", 3);
            if(gA == 0)
                b("You retain your skills. Your objects land where you died", 3);
        }
        i++;
_L2:
        if(i < cH) goto _L1; else goto _L3
_L3:
        int i1 = 0;
        if(i6 == 0) goto _L5; else goto _L4
_L4:
        c c2;
label6:
        {
label7:
            {
                int i3;
                int k4;
                int k5;
label8:
                {
                    c2 = cW[i1];
                    int i2 = (c2.l + 1) % 10;
                    if(c2.k == i2)
                        break label7;
                    i3 = -1;
                    k4 = c2.k;
                    if(k4 < i2)
                    {
                        k5 = i2 - k4;
                        if(i6 == 0)
                            break label8;
                    }
                    k5 = (10 + i2) - k4;
                }
label9:
                {
                    int l5;
label10:
                    {
                        l5 = 4;
                        if(k5 > 2)
                            l5 = (k5 - 1) * 4;
                        if(c2.m[k4] - c2.e > bP * 3 || c2.n[k4] - c2.f > bP * 3 || c2.m[k4] - c2.e < -bP * 3 || c2.n[k4] - c2.f < -bP * 3 || k5 > 8)
                        {
                            c2.e = c2.m[k4];
                            c2.f = c2.n[k4];
                            if(i6 == 0)
                                break label9;
                        }
                        if(c2.e < c2.m[k4])
                        {
                            c2.e += l5;
                            c2.h++;
                            i3 = 2;
                            if(i6 == 0)
                                break label10;
                        }
                        if(c2.e > c2.m[k4])
                        {
                            c2.e -= l5;
                            c2.h++;
                            i3 = 6;
                        }
                    }
label11:
                    {
                        if(c2.e - c2.m[k4] < l5 && c2.e - c2.m[k4] > -l5)
                            c2.e = c2.m[k4];
                        if(c2.f < c2.n[k4])
                        {
                            c2.f += l5;
                            c2.h++;
                            if(i3 == -1)
                            {
                                i3 = 4;
                                if(i6 == 0)
                                    break label11;
                            }
                            if(i3 == 2)
                            {
                                i3 = 3;
                                if(i6 == 0)
                                    break label11;
                            }
                            i3 = 5;
                            if(i6 == 0)
                                break label11;
                        }
                        if(c2.f <= c2.n[k4])
                            break label11;
                        c2.f -= l5;
                        c2.h++;
                        if(i3 == -1)
                        {
                            i3 = 0;
                            if(i6 == 0)
                                break label11;
                        }
                        if(i3 == 2)
                        {
                            i3 = 1;
                            if(i6 == 0)
                                break label11;
                        }
                        i3 = 7;
                    }
                    if(c2.f - c2.n[k4] < l5 && c2.f - c2.n[k4] > -l5)
                        c2.f = c2.n[k4];
                }
                if(i3 != -1)
                    c2.i = i3;
                if(c2.e != c2.m[k4] || c2.f != c2.n[k4])
                    break label6;
                c2.k = (k4 + 1) % 10;
                if(i6 == 0)
                    break label6;
            }
            c2.i = c2.j;
            if(c2.g == 43)
                c2.h++;
        }
        if(c2.q > 0)
            c2.q--;
        if(c2.s > 0)
            c2.s--;
        if(c2.w > 0)
            c2.w--;
        i1++;
_L5:
        if(i1 < cT) goto _L4; else goto _L6
_L6:
        int k1 = 0;
        if(i6 == 0) goto _L8; else goto _L7
_L7:
        c c3 = cL[k1];
        if(c3.F > 0)
            c3.F--;
        k1++;
_L8:
        if(k1 < cH) goto _L7; else goto _L9
_L9:
label12:
        {
label13:
            {
                int j3;
                byte byte0;
label14:
                {
                    if(ei)
                    {
                        if(cA - cN.e >= -500 && cA - cN.e <= 500 && cB - cN.f >= -500 && cB - cN.f <= 500)
                            break label12;
                        cA = cN.e;
                        cB = cN.f;
                        if(i6 == 0)
                            break label12;
                    }
                    if(cA - cN.e < -500 || cA - cN.e > 500 || cB - cN.f < -500 || cB - cN.f > 500)
                    {
                        cA = cN.e;
                        cB = cN.f;
                    }
                    if(cA != cN.e)
                        cA += (cN.e - cA) / (16 + (cy - 500) / 15);
                    if(cB != cN.f)
                        cB += (cN.f - cB) / (16 + (cy - 500) / 15);
                    if(!ej)
                        break label12;
                    int j2 = cC * 32;
                    j3 = j2 - cE;
                    byte0 = 1;
                    if(j3 == 0)
                        break label13;
                    cD++;
                    if(j3 > 128)
                    {
                        byte0 = -1;
                        j3 = 256 - j3;
                        if(i6 == 0)
                            break label14;
                    }
                    if(j3 > 0)
                    {
                        byte0 = 1;
                        if(i6 == 0)
                            break label14;
                    }
                    if(j3 < -128)
                    {
                        byte0 = 1;
                        j3 = 256 + j3;
                        if(i6 == 0)
                            break label14;
                    }
                    if(j3 < 0)
                    {
                        byte0 = -1;
                        j3 = -j3;
                    }
                }
                cE += ((cD * j3 + 255) / 256) * byte0;
                cE &= 0xff;
                if(i6 == 0)
                    break label12;
            }
            cD = 0;
        }
label15:
        {
label16:
            {
                if(!iH)
                    break label15;
                if(super.O.length() <= 0)
                    break label16;
                if(super.O.equalsIgnoreCase("::lostcon") && !bw)
                {
                    super.Y.a();
                    if(i6 == 0)
                        break label16;
                }
                if(super.O.equalsIgnoreCase("::closecon") && !bw)
                {
                    k();
                    if(i6 == 0)
                        break label16;
                }
                super.Y.a(193, 127);
                super.Y.a(super.O);
                super.Y.g();
                super.N = "";
                super.O = "";
                iI = "Please wait...";
            }
            if(super.J == 1 && super.H > 275 && super.H < 310 && super.G > 56 && super.G < 456)
            {
                super.Y.a(193, 127);
                super.Y.a("-null-");
                super.Y.g();
                super.N = "";
                super.O = "";
                iI = "Please wait...";
            }
            super.J = 0;
            return;
        }
label17:
        {
            if(super.H > bS - 4)
            {
                if(super.G > 15 && super.G < 96 && super.J == 1)
                    eL = 0;
                if(super.G > 110 && super.G < 194 && super.J == 1)
                {
                    eL = 1;
                    eG.h[eH] = 0xf423f;
                }
                if(super.G > 215 && super.G < 295 && super.J == 1)
                {
                    eL = 2;
                    eG.h[eJ] = 0xf423f;
                }
                if(super.G > 315 && super.G < 395 && super.J == 1)
                {
                    eL = 3;
                    eG.h[eK] = 0xf423f;
                }
                if(super.G > 417 && super.G < 497 && super.J == 1)
                {
                    gj = 1;
                    gk = 0;
                    super.N = "";
                    super.O = "";
                }
                super.J = 0;
                super.I = 0;
            }
            eG.a(super.G, super.H, super.J, super.I);
            if(eL > 0 && super.G >= 494 && super.H >= bS - 66)
                super.J = 0;
            if(!eG.a(eI))
                break label17;
            String s1 = eG.e(eI);
            eG.a(eI, "");
            if(s1.startsWith("::"))
            {
                if(s1.equalsIgnoreCase("::lostcon") && !bw)
                {
                    super.Y.a();
                    if(i6 == 0)
                        break label17;
                }
                if(s1.equalsIgnoreCase("::closecon") && !bw)
                {
                    k();
                    if(i6 == 0)
                        break label17;
                }
                c(s1.substring(2));
                if(i6 == 0)
                    break label17;
            }
            int k3 = h.a(s1);
            a(h.a, k3);
            s1 = h.a(h.a, 0, k3);
            s1 = a.g.a(s1);
            cN.q = 150;
            cN.p = s1;
            b(cN.b + ": " + s1, 2);
        }
        if(eL != 0) goto _L11; else goto _L10
_L10:
        int k2 = 0;
        if(i6 == 0) goto _L13; else goto _L12
_L12:
        if(eO[k2] > 0)
            eO[k2]--;
        k2++;
_L13:
        if(k2 < eM) goto _L12; else goto _L11
_L11:
label18:
        {
label19:
            {
label20:
                {
                    if(gA != 0)
                        super.J = 0;
                    if(!fq && !eP)
                        break label19;
                    if(super.I != 0)
                    {
                        fA++;
                        if(i6 == 0)
                            break label20;
                    }
                    fA = 0;
                }
                if(fA > 600)
                {
                    fB += 5000;
                    if(i6 == 0)
                        break label18;
                }
                if(fA > 450)
                {
                    fB += 500;
                    if(i6 == 0)
                        break label18;
                }
                if(fA > 300)
                {
                    fB += 50;
                    if(i6 == 0)
                        break label18;
                }
                if(fA > 150)
                {
                    fB += 5;
                    if(i6 == 0)
                        break label18;
                }
                if(fA > 50)
                {
                    fB++;
                    if(i6 == 0)
                        break label18;
                }
                if(fA <= 20 || (fA & 5) != 0)
                    break label18;
                fB++;
                if(i6 == 0)
                    break label18;
            }
            fA = 0;
            fB = 0;
        }
label21:
        {
            if(super.J == 1)
            {
                bz = 1;
                if(i6 == 0)
                    break label21;
            }
            if(super.J == 2)
                bz = 2;
        }
        bN.b(super.G, super.H);
        super.J = 0;
        if(!ej)
            break MISSING_BLOCK_LABEL_3304;
        if(cD != 0 && !ei)
            break MISSING_BLOCK_LABEL_3351;
        if(!super.z) goto _L15; else goto _L14
_L14:
        cC = cC + 1 & 7; //the left button is being pressed
        super.z = false;
        if(cz) goto _L15; else goto _L16
_L16:
        if((cC & 1) == 0)
            cC = cC + 1 & 7;
        k2 = 0;
        if(i6 == 0) goto _L18; else goto _L17
_L17:
        if(c(cC))
            break; /* Loop/switch isn't completed */
        cC = cC + 1 & 7;
        k2++;
_L18:
        if(k2 < 8) goto _L17; else goto _L15
_L15:
        if(!super.A)
            break MISSING_BLOCK_LABEL_3351;
        cC = cC + 7 & 7;
        super.A = false;
        if(cz)
            break MISSING_BLOCK_LABEL_3351;
        if((cC & 1) == 0)
            cC = cC + 7 & 7;
        k2 = 0;
        if(i6 == 0) goto _L20; else goto _L19
_L19:
        if(c(cC))
            break MISSING_BLOCK_LABEL_3351;
        cC = cC + 7 & 7;
        k2++;
_L20:
        if(k2 < 8) goto _L19; else goto _L21
_L21:
        if(i6 == 0)
            break MISSING_BLOCK_LABEL_3351;
        if(super.z)
        {
            cE = cE + 2 & 0xff;
            if(i6 == 0)
                break MISSING_BLOCK_LABEL_3351;
        }
        if(super.A)
            cE = cE - 2 & 0xff;
label22:
        {
            if(cz && cy > 550)
            {
                cy -= 4;
                if(i6 == 0)
                    break label22;
            }
            if(!cz && cy < 750)
                cy += 4;
        }
label23:
        {
            if(cj > 0)
            {
                cj--;
                if(i6 == 0)
                    break label23;
            }
            if(cj < 0)
                cj++;
        }
        bN.g(17);
        cc++;
        if(cc > 5)
        {
            cc = 0;
            cd = (cd + 1) % 3;
            ce = (ce + 1) % 4;
            cf = (cf + 1) % 5;
        }
        k2 = 0;
        if(i6 == 0) goto _L23; else goto _L22
_L22:
        int l3 = di[k2];
        int l4 = dj[k2];
        if(l3 >= 0 && l4 >= 0 && l3 < 96 && l4 < 96 && dk[k2] == 74)
            dh[k2].d(1, 0, 0);
        k2++;
_L23:
        if(k2 < dg) goto _L22; else goto _L24
_L24:
        int i4 = 0;
        if(i6 == 0) goto _L26; else goto _L25
_L25:
        int i5;
        iF[i4]++;
        if(iF[i4] <= 50)
            continue;
        iC--;
        i5 = i4;
        if(i6 == 0) goto _L28; else goto _L27
_L27:
        iD[i5] = iD[i5 + 1];
        iE[i5] = iE[i5 + 1];
        iF[i5] = iF[i5 + 1];
        iG[i5] = iG[i5 + 1];
        i5++;
_L28:
        if(i5 < iC) goto _L27; else goto _L29
_L29:
        i4++;
_L26:
        if(i4 >= iC)
            return;
        if(true) goto _L25; else goto _L30
_L30:
    }

    public void b(String s1, int i) //outputs a message (3 is white)
    {
        int k1 = b.bN;
        if(i == 2 || i == 4) goto _L2; else goto _L1
_L1:
        if(i != 6) goto _L4; else goto _L3
_L3:
        if(k1 == 0) goto _L2; else goto _L5
_L5:
        s1 = s1.substring(5);
_L2:
        if(s1.length() > 5 && s1.charAt(0) == '@' && s1.charAt(4) == '@') goto _L5; else goto _L6
_L6:
        int i1 = s1.indexOf(":");
        if(i1 == -1) goto _L4; else goto _L7
_L7:
        long l1;
        int j1;
        String s2 = s1.substring(0, i1);
        l1 = a.f.b(s2);
        j1 = 0;
        if(k1 == 0) goto _L9; else goto _L8
_L8:
        if(super.bg[j1] == l1)
            return;
        j1++;
_L9:
        if(j1 < super.bf) goto _L8; else goto _L4
_L4:
        if(i == 2)
            s1 = "@yel@" + s1;
        if(i == 3 || i == 4)
            s1 = "@whi@" + s1;
        if(i == 6)
            s1 = "@cya@" + s1;
        if(eL != 0)
        {
            if(i == 4 || i == 3)
                eC = 200;
            if(i == 2 && eL != 1)
                eD = 200;
            if(i == 5 && eL != 2)
                eE = 200;
            if(i == 6 && eL != 3)
                eF = 200;
            if(i == 3 && eL != 0)
                eL = 0;
            if(i == 6 && eL != 3 && eL != 0)
                eL = 0;
        }
        i1 = eM - 1;
        if(k1 == 0) goto _L11; else goto _L10
_L10:
        eN[i1] = eN[i1 - 1];
        eO[i1] = eO[i1 - 1];
        i1--;
_L11:
        if(i1 <= 0)
        {
label0:
            {
                eN[0] = s1;
                eO[0] = 300;
                if(i != 2)
                    break label0;
                if(eG.h[eH] == eG.i[eH] - 4)
                {
                    eG.a(eH, s1, true);
                    if(k1 == 0)
                        break label0;
                }
                eG.a(eH, s1, false);
            }
label1:
            {
                if(i != 5)
                    break label1;
                if(eG.h[eJ] == eG.i[eJ] - 4)
                {
                    eG.a(eJ, s1, true);
                    if(k1 == 0)
                        break label1;
                }
                eG.a(eJ, s1, false);
            }
            if(i == 6)
            {
                if(eG.h[eK] == eG.i[eK] - 4)
                {
                    eG.a(eK, s1, true);
                    return;
                }
                eG.a(eK, s1, false);
            }
            return;
        }
        if(true) goto _L10; else goto _L12
_L12:
    }

    public void d(String s1) //output a message to the user
    {
        if(s1.startsWith("@bor@"))
        {
            b(s1, 4);
            return;
        }
        if(s1.startsWith("@que@"))
        {
            b("@whi@" + s1, 5);
            return;
        }
        if(s1.startsWith("@pri@"))
        {
            b(s1, 6);
            return;
        } else
        {
            b(s1, 3);
            return;
        }
    }

    public c b(int i, int i1, int j1, int k1)
    {
        c c1;
        boolean flag;
        int l1;
        int j2;
        j2 = b.bN;
        if(cK[i] == null)
        {
            cK[i] = new c();
            cK[i].c = i;
            cK[i].d = 0;
        }
        c1 = cK[i];
        flag = false;
        l1 = 0;
        if(j2 == 0) goto _L2; else goto _L1
_L1:
        if(cM[l1].c != i)
            continue; /* Loop/switch isn't completed */
        flag = true;
        if(j2 == 0)
            break; /* Loop/switch isn't completed */
        l1++;
_L2:
        if(l1 < cI) goto _L1; else goto _L3
_L3:
label0:
        {
            if(flag)
            {
                c1.j = k1;
                int i2 = c1.l;
                if(i1 == c1.m[i2] && j1 == c1.n[i2])
                    break label0;
                c1.l = i2 = (i2 + 1) % 10;
                c1.m[i2] = i1;
                c1.n[i2] = j1;
                if(j2 == 0)
                    break label0;
            }
            c1.c = i;
            c1.k = 0;
            c1.l = 0;
            c1.m[0] = c1.e = i1;
            c1.n[0] = c1.f = j1;
            c1.j = c1.i = k1;
            c1.h = 0;
        }
        cL[cH++] = c1;
        return c1;
    }

    public c a(int i, int i1, int j1, int k1, int l1)
    {
        c c1;
        boolean flag;
        int i2;
        int k2;
        k2 = b.bN;
        if(cV[i] == null)
        {
            cV[i] = new c();
            cV[i].c = i;
        }
        c1 = cV[i];
        flag = false;
        i2 = 0;
        if(k2 == 0) goto _L2; else goto _L1
_L1:
        if(cX[i2].c != i)
            continue; /* Loop/switch isn't completed */
        flag = true;
        if(k2 == 0)
            break; /* Loop/switch isn't completed */
        i2++;
_L2:
        if(i2 < cU) goto _L1; else goto _L3
_L3:
label0:
        {
            if(flag)
            {
                c1.g = l1;
                c1.j = k1;
                int j2 = c1.l;
                if(i1 == c1.m[j2] && j1 == c1.n[j2])
                    break label0;
                c1.l = j2 = (j2 + 1) % 10;
                c1.m[j2] = i1;
                c1.n[j2] = j1;
                if(k2 == 0)
                    break label0;
            }
            c1.c = i;
            c1.k = 0;
            c1.l = 0;
            c1.m[0] = c1.e = i1;
            c1.n[0] = c1.f = j1;
            c1.g = l1;
            c1.j = c1.i = k1;
            c1.h = 0;
        }
        cW[cT++] = c1;
        return c1;
    }

    public void a(int i, int i1, byte abyte0[]) //called from a(int,int) in a.a.b
    {
        int i10 = b.bN;
        int j1;
        if(i != 255)
            break MISSING_BLOCK_LABEL_840;
        cI = cH;
        j1 = 0;
        if(i10 == 0) goto _L2; else goto _L1
_L1:
        cM[j1] = cL[j1];
        j1++;
_L2:
        if(j1 < cI) goto _L1; else goto _L3
_L3:
        int l1;
        int i5;
        int j5;
        l1 = 8;
        cO = a.f.b(abyte0, l1, 11);
        l1 += 11;
        cP = a.f.b(abyte0, l1, 13);
        l1 += 13;
        int j2 = a.f.b(abyte0, l1, 4);
        l1 += 4;
        boolean flag1 = c(cO, cP);
        cO -= cr;
        cP -= cs;
        int j3 = cO * bP + 64;
        int i4 = cP * bP + 64;
        if(flag1)
        {
            cN.l = 0;
            cN.k = 0;
            cN.e = cN.m[0] = j3;
            cN.f = cN.n[0] = i4;
        }
        cH = 0;
        cN = b(cQ, j3, i4, j2);
        i5 = a.f.b(abyte0, l1, 8);
        l1 += 8;
        j5 = 0;
        if(i10 == 0) goto _L5; else goto _L4
_L4:
        c c3;
        int l5;
        c3 = cM[j5 + 1];
        l5 = a.f.b(abyte0, l1, 1);
        l1++;
        if(l5 == 0) goto _L7; else goto _L6
_L6:
        int l6;
        l6 = a.f.b(abyte0, l1, 1);
        l1++;
        if(l6 != 0) goto _L9; else goto _L8
_L8:
        int i8 = a.f.b(abyte0, l1, 3);
        l1 += 3;
        int i9 = c3.l;
        int k9 = c3.m[i9];
        int l9 = c3.n[i9];
        if(i8 == 2 || i8 == 1 || i8 == 3)
            k9 += bP;
        if(i8 == 6 || i8 == 5 || i8 == 7)
            k9 -= bP;
        if(i8 == 4 || i8 == 3 || i8 == 5)
            l9 += bP;
        if(i8 == 0 || i8 == 1 || i8 == 7)
            l9 -= bP;
        c3.j = i8;
        c3.l = i9 = (i9 + 1) % 10;
        c3.m[i9] = k9;
        c3.n[i9] = l9;
        if(i10 == 0) goto _L7; else goto _L9
_L9:
        int j8 = a.f.b(abyte0, l1, 4);
        if((j8 & 0xc) == 12)
        {
            l1 += 2;
            if(i10 == 0)
                continue; /* Loop/switch isn't completed */
        }
        c3.j = a.f.b(abyte0, l1, 4);
        l1 += 4;
_L7:
        cL[cH++] = c3;
        j5++;
_L5:
        if(j5 < i5) goto _L4; else goto _L10
_L10:
        int k5 = 0;
        if(i10 == 0) goto _L12; else goto _L11
_L11:
        l5 = a.f.b(abyte0, l1, 11);
        l1 += 11;
        int i7 = a.f.b(abyte0, l1, 5);
        l1 += 5;
        if(i7 > 15)
            i7 -= 32;
        int k8 = a.f.b(abyte0, l1, 5);
        l1 += 5;
        if(k8 > 15)
            k8 -= 32;
        int k2 = a.f.b(abyte0, l1, 4);
        l1 += 4;
        int j9 = a.f.b(abyte0, l1, 1);
        l1++;
        int k3 = (cO + i7) * bP + 64;
        int j4 = (cP + k8) * bP + 64;
        b(l5, k3, j4, k2);
        if(j9 == 0)
            cY[k5++] = l5;
_L12:
        if(l1 + 24 < i1 * 8) goto _L11; else goto _L13
_L13:
        if(k5 <= 0)
            break MISSING_BLOCK_LABEL_8386;
        super.Y.a(254, 120);
        super.Y.b(k5);
        l5 = 0;
        if(i10 == 0) goto _L15; else goto _L14
_L14:
        c c4 = cK[cY[l5]];
        super.Y.b(c4.c);
        super.Y.b(c4.d);
        l5++;
_L15:
        if(l5 < k5) goto _L14; else goto _L16
_L16:
        super.Y.g();
        k5 = 0;
        return;
        if(i != 254)
            break MISSING_BLOCK_LABEL_1368;
        j1 = 1;
        if(i10 == 0) goto _L18; else goto _L17
_L17:
        if(a.f.a(abyte0[j1]) != 255) goto _L20; else goto _L19
_L19:
        int l2;
        int i3;
        int l3;
        l1 = 0;
        l2 = cO + abyte0[j1 + 1] >> 3;
        i3 = cP + abyte0[j1 + 2] >> 3;
        j1 += 3;
        l3 = 0;
        if(i10 == 0) goto _L22; else goto _L21
_L21:
        int k4 = (db[l3] >> 3) - l2;
        i5 = (dc[l3] >> 3) - i3;
        if(k4 != 0 || i5 != 0)
        {
            if(l3 != l1)
            {
                db[l1] = db[l3];
                dc[l1] = dc[l3];
                dd[l1] = dd[l3];
                de[l1] = de[l3];
            }
            l1++;
        }
        l3++;
_L22:
        if(l3 < da) goto _L21; else goto _L23
_L23:
        da = l1;
        if(i10 == 0)
            continue; /* Loop/switch isn't completed */
_L20:
        l1 = a.f.a(abyte0, j1);
        j1 += 2;
        l2 = cO + abyte0[j1++];
        i3 = cP + abyte0[j1++];
        if((l1 & 0x8000) != 0) goto _L25; else goto _L24
_L24:
        db[da] = l2;
        dc[da] = i3;
        dd[da] = l1;
        de[da] = 0;
        l3 = 0;
        if(i10 == 0) goto _L27; else goto _L26
_L26:
        if(di[l3] != l2 || dj[l3] != i3)
            continue; /* Loop/switch isn't completed */
        de[da] = b.Z[dk[l3]];
        if(i10 == 0)
            break; /* Loop/switch isn't completed */
        l3++;
_L27:
        if(l3 < dg) goto _L26; else goto _L28
_L28:
        da++;
        if(i10 == 0)
            continue; /* Loop/switch isn't completed */
_L25:
        int l4;
        l1 &= 0x7fff;
        l3 = 0;
        l4 = 0;
        if(i10 == 0) goto _L30; else goto _L29
_L29:
        if(db[l4] != l2 || dc[l4] != i3 || dd[l4] != l1)
        {
            if(l4 != l3)
            {
                db[l3] = db[l4];
                dc[l3] = dc[l4];
                dd[l3] = dd[l4];
                de[l3] = de[l4];
            }
            l3++;
            if(i10 == 0)
                continue; /* Loop/switch isn't completed */
        }
        l1 = -123;
        l4++;
_L30:
        if(l4 < da) goto _L29; else goto _L31
_L31:
        da = l3;
_L18:
        if(j1 < i1) goto _L17; else goto _L32
_L32:
        return;
        if(i != 253)
            break MISSING_BLOCK_LABEL_2159;
        j1 = 1;
        if(i10 == 0) goto _L34; else goto _L33
_L33:
        if(a.f.a(abyte0[j1]) != 255) goto _L36; else goto _L35
_L35:
        l1 = 0;
        l2 = cO + abyte0[j1 + 1] >> 3;
        i3 = cP + abyte0[j1 + 2] >> 3;
        j1 += 3;
        l3 = 0;
        if(i10 == 0) goto _L38; else goto _L37
_L37:
        l4 = (di[l3] >> 3) - l2;
        i5 = (dj[l3] >> 3) - i3;
        if(l4 != 0 || i5 != 0)
        {
            if(l3 != l1)
            {
                dh[l1] = dh[l3];
                dh[l1].F = l1;
                di[l1] = di[l3];
                dj[l1] = dj[l3];
                dk[l1] = dk[l3];
                dl[l1] = dl[l3];
            }
            l1++;
            if(i10 == 0)
                continue; /* Loop/switch isn't completed */
        }
        bN.b(dh[l3]);
        cm.d(di[l3], dj[l3], dk[l3]);
        l3++;
_L38:
        if(l3 < dg) goto _L37; else goto _L39
_L39:
        dg = l1;
        if(i10 == 0)
            continue; /* Loop/switch isn't completed */
_L36:
        l1 = a.f.a(abyte0, j1);
        j1 += 2;
        l2 = cO + abyte0[j1++];
        i3 = cP + abyte0[j1++];
        l3 = 0;
        l4 = 0;
        if(i10 == 0) goto _L41; else goto _L40
_L40:
        if(di[l4] != l2 || dj[l4] != i3)
        {
            if(l4 != l3)
            {
                dh[l3] = dh[l4];
                dh[l3].F = l3;
                di[l3] = di[l4];
                dj[l3] = dj[l4];
                dk[l3] = dk[l4];
                dl[l3] = dl[l4];
            }
            l3++;
            if(i10 == 0)
                continue; /* Loop/switch isn't completed */
        }
        bN.b(dh[l4]);
        cm.d(di[l4], dj[l4], dk[l4]);
        l4++;
_L41:
        if(l4 < dg) goto _L40; else goto _L42
_L42:
        dg = l3;
        if(l1 == 60000)
            continue; /* Loop/switch isn't completed */
        i5 = cm.g(l2, i3);
        if(i5 != 0 && i5 != 4) goto _L44; else goto _L43
_L43:
        j5 = b.W[l1];
        k5 = b.X[l1];
        if(i10 == 0) goto _L45; else goto _L44
_L44:
        k5 = b.W[l1];
        j5 = b.X[l1];
_L45:
        l5 = ((l2 + l2 + j5) * bP) / 2;
        int j7 = ((i3 + i3 + k5) * bP) / 2;
        int l8 = b.V[l1];
        f f2 = dm[l8].i();
        bN.a(f2);
        f2.F = dg;
        f2.d(0, i5 * 32, 0);
        f2.f(l5, -cm.b(l5, j7), j7);
        f2.a(true, 48, 48, -50, -10, -50);
        cm.c(l2, i3, l1);
        if(l1 == 74)
            f2.f(0, -480, 0);
        di[dg] = l2;
        dj[dg] = i3;
        dk[dg] = l1;
        dl[dg] = i5;
        dh[dg++] = f2;
_L34:
        if(j1 < i1) goto _L33; else goto _L46
_L46:
        return;
        if(i != 252)
            break MISSING_BLOCK_LABEL_2304;
        j1 = 1;
        dz = abyte0[j1++] & 0xff;
        l1 = 0;
        if(i10 == 0) goto _L48; else goto _L47
_L47:
        l2 = a.f.a(abyte0, j1);
        j1 += 2;
        dA[l1] = l2 & 0x7fff;
        dC[l1] = l2 / 32768;
        if(b.h[l2 & 0x7fff] == 0)
        {
            dB[l1] = a.f.e(abyte0, j1);
            if(dB[l1] >= 128)
            {
                j1 += 4;
                if(i10 == 0)
                    continue; /* Loop/switch isn't completed */
            }
            j1++;
            if(i10 == 0)
                continue; /* Loop/switch isn't completed */
        }
        dB[l1] = 1;
        l1++;
_L48:
        if(l1 < dz) goto _L47; else goto _L49
_L49:
        return;
        if(i != 250)
            break MISSING_BLOCK_LABEL_3156;
        j1 = a.f.a(abyte0, 1);
        l1 = 3;
        l2 = 0;
        if(i10 == 0) goto _L51; else goto _L50
_L50:
        c c1;
        i3 = a.f.a(abyte0, l1);
        l1 += 2;
        c1 = cK[i3];
        l4 = abyte0[l1];
        l1++;
        if(l4 == 0)
        {
            i5 = a.f.a(abyte0, l1);
            l1 += 2;
            if(c1 == null)
                continue; /* Loop/switch isn't completed */
            c1.s = 150;
            c1.r = i5;
            if(i10 == 0)
                continue; /* Loop/switch isn't completed */
        }
        if(l4 != 1) goto _L53; else goto _L52
_L52:
        i5 = abyte0[l1];
        l1++;
        if(c1 == null) goto _L55; else goto _L54
_L54:
        String s3;
        boolean flag3;
        s3 = a.g.a(h.a(abyte0, l1, i5));
        flag3 = false;
        l5 = 0;
        if(i10 == 0) goto _L57; else goto _L56
_L56:
        if(super.bg[l5] == c1.a)
            flag3 = true;
        l5++;
_L57:
        if(l5 < super.bf) goto _L56; else goto _L58
_L58:
        if(!flag3)
        {
            c1.q = 150;
            c1.p = s3;
            b(c1.b + ": " + c1.p, 2);
        }
_L55:
        l1 += i5;
        if(i10 == 0)
            continue; /* Loop/switch isn't completed */
_L53:
        if(l4 == 2)
        {
            i5 = a.f.a(abyte0[l1]);
            l1++;
            s3 = a.f.a(abyte0[l1]);
            l1++;
            flag3 = a.f.a(abyte0[l1]);
            l1++;
            if(c1 == null)
                continue; /* Loop/switch isn't completed */
            c1.t = i5;
            c1.u = s3;
            c1.v = ((flag3) ? 1 : 0);
            c1.w = 200;
            if(c1 != cN)
                continue; /* Loop/switch isn't completed */
            dH[3] = s3;
            dI[3] = ((flag3) ? 1 : 0);
            gp = false;
            gw = false;
            if(i10 == 0)
                continue; /* Loop/switch isn't completed */
        }
        if(l4 == 3)
        {
            i5 = a.f.a(abyte0, l1);
            l1 += 2;
            s3 = a.f.a(abyte0, l1);
            l1 += 2;
            if(c1 == null)
                continue; /* Loop/switch isn't completed */
            c1.C = i5;
            c1.E = s3;
            c1.D = -1;
            c1.F = cb;
            if(i10 == 0)
                continue; /* Loop/switch isn't completed */
        }
        if(l4 == 4)
        {
            i5 = a.f.a(abyte0, l1);
            l1 += 2;
            s3 = a.f.a(abyte0, l1);
            l1 += 2;
            if(c1 == null)
                continue; /* Loop/switch isn't completed */
            c1.C = i5;
            c1.D = s3;
            c1.E = -1;
            c1.F = cb;
            if(i10 == 0)
                continue; /* Loop/switch isn't completed */
        }
        if(l4 != 5) goto _L60; else goto _L59
_L59:
        if(c1 == null) goto _L62; else goto _L61
_L61:
        c1.d = a.f.a(abyte0, l1);
        l1 += 2;
        c1.a = a.f.c(abyte0, l1);
        l1 += 8;
        c1.b = a.f.a(c1.a);
        i5 = a.f.a(abyte0[l1]);
        l1++;
        s3 = 0;
        if(i10 == 0) goto _L64; else goto _L63
_L63:
        c1.o[s3] = a.f.a(abyte0[l1]);
        l1++;
        s3++;
_L64:
        if(s3 < i5) goto _L63; else goto _L65
_L65:
        flag3 = i5;
        if(i10 == 0) goto _L67; else goto _L66
_L66:
        c1.o[flag3] = 0;
        flag3++;
_L67:
        if(flag3 < 12) goto _L66; else goto _L68
_L68:
        c1.y = abyte0[l1++] & 0xff;
        c1.z = abyte0[l1++] & 0xff;
        c1.A = abyte0[l1++] & 0xff;
        c1.B = abyte0[l1++] & 0xff;
        c1.x = abyte0[l1++] & 0xff;
        c1.I = abyte0[l1++] & 0xff;
        if(i10 == 0)
            continue; /* Loop/switch isn't completed */
_L62:
        l1 += 14;
        i5 = a.f.a(abyte0[l1]);
        l1 += i5 + 1;
        if(i10 == 0)
            continue; /* Loop/switch isn't completed */
_L60:
        if(l4 == 6)
        {
            i5 = abyte0[l1];
            l1++;
            if(c1 != null)
            {
                String s4 = h.a(abyte0, l1, i5);
                c1.q = 150;
                c1.p = s4;
                if(c1 == cN)
                    b(c1.b + ": " + c1.p, 5);
            }
            l1 += i5;
        }
        l2++;
_L51:
        if(l2 < j1) goto _L50; else goto _L69
_L69:
        return;
        if(i != 249)
            break MISSING_BLOCK_LABEL_3811;
        j1 = 1;
        if(i10 == 0) goto _L71; else goto _L70
_L70:
        if(a.f.a(abyte0[j1]) != 255) goto _L73; else goto _L72
_L72:
        l1 = 0;
        l2 = cO + abyte0[j1 + 1] >> 3;
        i3 = cP + abyte0[j1 + 2] >> 3;
        j1 += 3;
        c1 = 0;
        if(i10 == 0) goto _L75; else goto _L74
_L74:
        l4 = (ds[c1] >> 3) - l2;
        i5 = (dt[c1] >> 3) - i3;
        if(l4 != 0 || i5 != 0)
        {
            if(c1 != l1)
            {
                dr[l1] = dr[c1];
                dr[l1].F = l1 + 10000;
                ds[l1] = ds[c1];
                dt[l1] = dt[c1];
                du[l1] = du[c1];
                dv[l1] = dv[c1];
            }
            l1++;
            if(i10 == 0)
                continue; /* Loop/switch isn't completed */
        }
        bN.b(dr[c1]);
        cm.b(ds[c1], dt[c1], du[c1], dv[c1]);
        c1++;
_L75:
        if(c1 < dq) goto _L74; else goto _L76
_L76:
        dq = l1;
        if(i10 == 0)
            continue; /* Loop/switch isn't completed */
_L73:
        l1 = a.f.a(abyte0, j1);
        j1 += 2;
        l2 = cO + abyte0[j1++];
        i3 = cP + abyte0[j1++];
        c1 = abyte0[j1++];
        l4 = 0;
        i5 = 0;
        if(i10 == 0) goto _L78; else goto _L77
_L77:
        if(ds[i5] != l2 || dt[i5] != i3 || du[i5] != c1)
        {
            if(i5 != l4)
            {
                dr[l4] = dr[i5];
                dr[l4].F = l4 + 10000;
                ds[l4] = ds[i5];
                dt[l4] = dt[i5];
                du[l4] = du[i5];
                dv[l4] = dv[i5];
            }
            l4++;
            if(i10 == 0)
                continue; /* Loop/switch isn't completed */
        }
        bN.b(dr[i5]);
        cm.b(ds[i5], dt[i5], du[i5], dv[i5]);
        i5++;
_L78:
        if(i5 < dq) goto _L77; else goto _L79
_L79:
        dq = l4;
        if(l1 != 65535)
        {
            cm.a(l2, i3, c1, l1);
            f f1 = b(l2, i3, c1, l1, dq);
            dr[dq] = f1;
            ds[dq] = l2;
            dt[dq] = i3;
            dv[dq] = l1;
            du[dq++] = c1;
        }
_L71:
        if(j1 < i1) goto _L70; else goto _L80
_L80:
        return;
        if(i != 248)
            break MISSING_BLOCK_LABEL_4360;
        cU = cT;
        cT = 0;
        j1 = 0;
        if(i10 == 0) goto _L82; else goto _L81
_L81:
        cX[j1] = cW[j1];
        j1++;
_L82:
        if(j1 < cU) goto _L81; else goto _L83
_L83:
        l1 = 8;
        l2 = a.f.b(abyte0, l1, 8);
        l1 += 8;
        i3 = 0;
        if(i10 == 0) goto _L85; else goto _L84
_L84:
        c1 = cX[i3];
        l4 = a.f.b(abyte0, l1, 1);
        l1++;
        if(l4 == 0) goto _L87; else goto _L86
_L86:
        i5 = a.f.b(abyte0, l1, 1);
        l1++;
        if(i5 != 0) goto _L89; else goto _L88
_L88:
        f1 = a.f.b(abyte0, l1, 3);
        l1 += 3;
        flag3 = c1.l;
        int i6 = c1.m[flag3];
        int k7 = c1.n[flag3];
        if(f1 == 2 || f1 == 1 || f1 == 3)
            i6 += bP;
        if(f1 == 6 || f1 == 5 || f1 == 7)
            i6 -= bP;
        if(f1 == 4 || f1 == 3 || f1 == 5)
            k7 += bP;
        if(f1 == 0 || f1 == 1 || f1 == 7)
            k7 -= bP;
        c1.j = f1;
        c1.l = flag3 = (flag3 + 1) % 10;
        c1.m[flag3] = i6;
        c1.n[flag3] = k7;
        if(i10 == 0) goto _L87; else goto _L89
_L89:
        f1 = a.f.b(abyte0, l1, 4);
        if((f1 & 0xc) == 12)
        {
            l1 += 2;
            if(i10 == 0)
                continue; /* Loop/switch isn't completed */
        }
        c1.j = a.f.b(abyte0, l1, 4);
        l1 += 4;
_L87:
        cW[cT++] = c1;
        i3++;
_L85:
        if(i3 < l2) goto _L84; else goto _L90
_L90:
        if(i10 == 0) goto _L92; else goto _L91
_L91:
        c1 = a.f.b(abyte0, l1, 12);
        l1 += 12;
        l4 = a.f.b(abyte0, l1, 5);
        l1 += 5;
        if(l4 > 15)
            l4 -= 32;
        i5 = a.f.b(abyte0, l1, 5);
        l1 += 5;
        if(i5 > 15)
            i5 -= 32;
        f1 = a.f.b(abyte0, l1, 4);
        l1 += 4;
        flag3 = (cO + l4) * bP + 64;
        int j6 = (cP + i5) * bP + 64;
        int l7 = a.f.b(abyte0, l1, 10);
        l1 += 10;
        if(l7 >= b.n)
            l7 = 24;
        a(c1, flag3, j6, f1, l7);
_L92:
        if(l1 + 34 < i1 * 8) goto _L91; else goto _L93
_L93:
        return;
        if(i != 247)
            break MISSING_BLOCK_LABEL_4626;
        j1 = a.f.a(abyte0, 1);
        l1 = 3;
        l2 = 0;
        if(i10 == 0) goto _L95; else goto _L94
_L94:
        i3 = a.f.a(abyte0, l1);
        l1 += 2;
        c c2 = cV[i3];
        l4 = a.f.a(abyte0[l1]);
        l1++;
        if(l4 == 1)
        {
            i5 = a.f.a(abyte0, l1);
            l1 += 2;
            f1 = abyte0[l1];
            l1++;
            if(c2 != null)
            {
                String s5 = h.a(abyte0, l1, f1);
                c2.q = 150;
                c2.p = s5;
                if(i5 == cN.c)
                    b("@yel@" + b.o[c2.g] + ": " + c2.p, 5);
            }
            l1 += f1;
            if(i10 == 0)
                continue; /* Loop/switch isn't completed */
        }
        if(l4 == 2)
        {
            i5 = a.f.a(abyte0[l1]);
            l1++;
            f1 = a.f.a(abyte0[l1]);
            l1++;
            s5 = a.f.a(abyte0[l1]);
            l1++;
            if(c2 != null)
            {
                c2.t = i5;
                c2.u = f1;
                c2.v = s5;
                c2.w = 200;
            }
        }
        l2++;
_L95:
        if(l2 < j1) goto _L94; else goto _L96
_L96:
        return;
        if(i != 246)
            break MISSING_BLOCK_LABEL_4712;
        ge = true;
        j1 = a.f.a(abyte0[1]);
        gf = j1;
        l1 = 2;
        l2 = 0;
        if(i10 == 0) goto _L98; else goto _L97
_L97:
        i3 = a.f.a(abyte0[l1]);
        l1++;
        gg[l2] = new String(abyte0, l1, i3);
        l1 += i3;
        l2++;
_L98:
        if(l2 < j1) goto _L97; else goto _L99
_L99:
        return;
        if(i == 245)
        {
            ge = false;
            return;
        }
        if(i == 244)
        {
            gC = true;
            cQ = a.f.a(abyte0, 1);
            cn = a.f.a(abyte0, 3);
            co = a.f.a(abyte0, 5);
            ct = a.f.a(abyte0, 7);
            cp = a.f.a(abyte0, 9);
            co -= ct * cp;
            return;
        }
        if(i != 243)
            break MISSING_BLOCK_LABEL_4932;
        j1 = 1;
        l1 = 0;
        if(i10 == 0) goto _L101; else goto _L100
_L100:
        dH[l1] = a.f.a(abyte0[j1++]);
        l1++;
_L101:
        if(l1 < 18) goto _L100; else goto _L102
_L102:
        l2 = 0;
        if(i10 == 0) goto _L104; else goto _L103
_L103:
        dI[l2] = a.f.a(abyte0[j1++]);
        l2++;
_L104:
        if(l2 < 18) goto _L103; else goto _L105
_L105:
        i3 = 0;
        if(i10 == 0) goto _L107; else goto _L106
_L106:
        dJ[i3] = a.f.b(abyte0, j1);
        j1 += 4;
        i3++;
_L107:
        if(i3 < 18) goto _L106; else goto _L108
_L108:
        dL = a.f.a(abyte0[j1++]);
        return;
        if(i != 242)
            break MISSING_BLOCK_LABEL_4973;
        j1 = 0;
        if(i10 == 0) goto _L110; else goto _L109
_L109:
        dK[j1] = a.f.a(abyte0[1 + j1]);
        j1++;
_L110:
        if(j1 < 5) goto _L109; else goto _L111
_L111:
        return;
        if(i == 241)
        {
            gA = 250;
            return;
        }
        if(i != 240)
            break MISSING_BLOCK_LABEL_5615;
        j1 = (i1 - 1) / 4;
        l1 = 0;
        if(i10 == 0) goto _L113; else goto _L112
_L112:
        l2 = cO + a.f.d(abyte0, 1 + l1 * 4) >> 3;
        i3 = cP + a.f.d(abyte0, 3 + l1 * 4) >> 3;
        c2 = 0;
        l4 = 0;
        if(i10 == 0) goto _L115; else goto _L114
_L114:
        i5 = (db[l4] >> 3) - l2;
        f1 = (dc[l4] >> 3) - i3;
        if(i5 != 0 || f1 != 0)
        {
            if(l4 != c2)
            {
                db[c2] = db[l4];
                dc[c2] = dc[l4];
                dd[c2] = dd[l4];
                de[c2] = de[l4];
            }
            c2++;
        }
        l4++;
_L115:
        if(l4 < da) goto _L114; else goto _L116
_L116:
        da = c2;
        c2 = 0;
        i5 = 0;
        if(i10 == 0) goto _L118; else goto _L117
_L117:
        f1 = (di[i5] >> 3) - l2;
        s5 = (dj[i5] >> 3) - i3;
        if(f1 != 0 || s5 != 0)
        {
            if(i5 != c2)
            {
                dh[c2] = dh[i5];
                dh[c2].F = c2;
                di[c2] = di[i5];
                dj[c2] = dj[i5];
                dk[c2] = dk[i5];
                dl[c2] = dl[i5];
            }
            c2++;
            if(i10 == 0)
                continue; /* Loop/switch isn't completed */
        }
        bN.b(dh[i5]);
        cm.d(di[i5], dj[i5], dk[i5]);
        i5++;
_L118:
        if(i5 < dg) goto _L117; else goto _L119
_L119:
        dg = c2;
        c2 = 0;
        f1 = 0;
        if(i10 == 0) goto _L121; else goto _L120
_L120:
        s5 = (ds[f1] >> 3) - l2;
        int k6 = (dt[f1] >> 3) - i3;
        if(s5 != 0 || k6 != 0)
        {
            if(f1 != c2)
            {
                dr[c2] = dr[f1];
                dr[c2].F = c2 + 10000;
                ds[c2] = ds[f1];
                dt[c2] = dt[f1];
                du[c2] = du[f1];
                dv[c2] = dv[f1];
            }
            c2++;
            if(i10 == 0)
                continue; /* Loop/switch isn't completed */
        }
        bN.b(dr[f1]);
        cm.b(ds[f1], dt[f1], du[f1], dv[f1]);
        f1++;
_L121:
        if(f1 < dq) goto _L120; else goto _L122
_L122:
        dq = c2;
        l1++;
_L113:
        if(l1 < j1) goto _L112; else goto _L123
_L123:
        return;
        if(i == 239)
        {
            il = true;
            return;
        }
        if(i == 238)
        {
            j1 = a.f.a(abyte0, 1);
            if(cK[j1] != null)
                fr = cK[j1].b;
            fq = true;
            fy = false;
            fz = false;
            fs = 0;
            fv = 0;
            return;
        }
        if(i == 237)
        {
            fq = false;
            fD = false;
            return;
        }
        if(i != 236)
            break MISSING_BLOCK_LABEL_5794;
        fv = abyte0[1] & 0xff;
        j1 = 2;
        l1 = 0;
        if(i10 == 0) goto _L125; else goto _L124
_L124:
        fw[l1] = a.f.a(abyte0, j1);
        j1 += 2;
        fx[l1] = a.f.b(abyte0, j1);
        j1 += 4;
        l1++;
_L125:
        if(l1 < fv) goto _L124; else goto _L126
_L126:
        fy = false;
        fz = false;
        return;
        if(i == 235)
        {
            j1 = abyte0[1];
            if(j1 == 1)
            {
                fy = true;
                return;
            } else
            {
                fy = false;
                return;
            }
        }
        if(i != 234)
            break MISSING_BLOCK_LABEL_6165;
        fL = true;
        j1 = 1;
        l1 = abyte0[j1++] & 0xff;
        l2 = abyte0[j1++];
        fM = abyte0[j1++] & 0xff;
        fN = abyte0[j1++] & 0xff;
        i3 = 0;
        if(i10 == 0) goto _L128; else goto _L127
_L127:
        fO[i3] = -1;
        i3++;
_L128:
        if(i3 < 40) goto _L127; else goto _L129
_L129:
        c2 = 0;
        if(i10 == 0) goto _L131; else goto _L130
_L130:
        fO[c2] = a.f.a(abyte0, j1);
        j1 += 2;
        fP[c2] = a.f.a(abyte0, j1);
        j1 += 2;
        fQ[c2] = abyte0[j1++];
        c2++;
_L131:
        if(c2 < l1) goto _L130; else goto _L132
_L132:
        if(l2 != 1) goto _L134; else goto _L133
_L133:
        l4 = 39;
        i5 = 0;
        if(i10 == 0) goto _L136; else goto _L135
_L135:
        boolean flag2;
        if(l4 < l1)
            break; /* Loop/switch isn't completed */
        flag2 = false;
        s5 = 0;
        if(i10 == 0) goto _L138; else goto _L137
_L137:
        if(fO[s5] != dA[i5])
            continue; /* Loop/switch isn't completed */
        flag2 = true;
        if(i10 == 0)
            break; /* Loop/switch isn't completed */
        s5++;
_L138:
        if(s5 < 40) goto _L137; else goto _L139
_L139:
        if(dA[i5] == 10)
            flag2 = true;
        if(!flag2)
        {
            fO[l4] = dA[i5] & 0x7fff;
            fP[l4] = 0;
            fQ[l4] = 0;
            l4--;
        }
        i5++;
_L136:
        if(i5 < dz) goto _L135; else goto _L134
_L134:
        if(fR >= 0 && fR < 40 && fO[fR] != fS)
        {
            fR = -1;
            fS = -2;
            return;
        }
        break MISSING_BLOCK_LABEL_8386;
        if(i == 233)
        {
            fL = false;
            return;
        }
        if(i == 232)
        {
            hK = true;
            hL.a(hN, "");
            hL.a(hO, "");
            hL.a(hP, "");
            hL.a(hQ, "");
            return;
        }
        if(i == 229)
        {
            j1 = abyte0[1];
            if(j1 == 1)
            {
                fz = true;
                return;
            } else
            {
                fz = false;
                return;
            }
        }
        if(i == 228)
        {
            ej = a.f.a(abyte0[1]) == 1;
            ek = a.f.a(abyte0[2]) == 1;
            el = a.f.a(abyte0[3]) == 1;
            return;
        }
        if(i != 227)
            break MISSING_BLOCK_LABEL_6435;
        j1 = 0;
        if(i10 == 0) goto _L141; else goto _L140
_L140:
        boolean flag = abyte0[j1 + 1] == 1;
        if(!eh[j1] && flag)
            e("prayeron");
        if(eh[j1] && !flag)
            e("prayeroff");
        eh[j1] = flag;
        j1++;
_L141:
        if(j1 < i1 - 1) goto _L140; else goto _L142
_L142:
        return;
        if(i != 226)
            break MISSING_BLOCK_LABEL_6485;
        j1 = 0;
        if(i10 == 0) goto _L144; else goto _L143
_L143:
        eg[j1] = abyte0[j1 + 1] == 1;
        j1++;
_L144:
        if(j1 < ee) goto _L143; else goto _L145
_L145:
        return;
        if(i != 224)
            break MISSING_BLOCK_LABEL_6605;
        ho = true;
        j1 = 0;
        if(i10 == 0) goto _L147; else goto _L146
_L146:
        hx[j1] = j1;
        hy[j1] = iJ[hx[j1]];
        hp.a(hu[j1], "");
        hp.a(ht[j1], (j1 + 1) + ": " + hy[j1]);
        j1++;
_L147:
        if(j1 < 5) goto _L146; else goto _L148
_L148:
        return;
        if(i != 222)
            break MISSING_BLOCK_LABEL_6728;
        fT = true;
        j1 = 1;
        fU = abyte0[j1++] & 0xff;
        gc = abyte0[j1++] & 0xff;
        flag = false;
        if(i10 == 0) goto _L150; else goto _L149
_L149:
        fV[flag] = a.f.a(abyte0, j1);
        j1 += 2;
        fW[flag] = a.f.e(abyte0, j1);
        if(fW[flag] >= 128)
        {
            j1 += 4;
            if(i10 == 0)
                continue; /* Loop/switch isn't completed */
        }
        j1++;
        flag++;
_L150:
        if(flag < fU) goto _L149; else goto _L151
_L151:
        V();
        return;
        if(i == 221)
        {
            fT = false;
            return;
        }
        if(i == 220)
        {
            j1 = abyte0[1] & 0xff;
            dJ[j1] = a.f.b(abyte0, 2);
            return;
        }
        if(i == 219)
        {
            j1 = a.f.a(abyte0, 1);
            if(cK[j1] != null)
                eQ = cK[j1].b;
            eP = true;
            eR = 0;
            eU = 0;
            eX = false;
            eY = false;
            eZ = false;
            fa = false;
            fb = false;
            fc = false;
            return;
        }
        if(i == 218)
        {
            eP = false;
            fd = false;
            return;
        }
        if(i != 217)
            break MISSING_BLOCK_LABEL_7045;
        fD = true;
        fE = false;
        fq = false;
        j1 = 1;
        fC = a.f.c(abyte0, j1);
        j1 += 8;
        fI = abyte0[j1++] & 0xff;
        flag = false;
        if(i10 == 0) goto _L153; else goto _L152
_L152:
        fJ[flag] = a.f.a(abyte0, j1);
        j1 += 2;
        fK[flag] = a.f.b(abyte0, j1);
        j1 += 4;
        flag++;
_L153:
        if(flag < fI) goto _L152; else goto _L154
_L154:
        fF = abyte0[j1++] & 0xff;
        l2 = 0;
        if(i10 == 0) goto _L156; else goto _L155
_L155:
        fG[l2] = a.f.a(abyte0, j1);
        j1 += 2;
        fH[l2] = a.f.b(abyte0, j1);
        j1 += 4;
        l2++;
_L156:
        if(l2 < fF) goto _L155; else goto _L157
_L157:
        return;
        if(i != 216)
            break MISSING_BLOCK_LABEL_7129;
        eU = abyte0[1] & 0xff;
        j1 = 2;
        flag = false;
        if(i10 == 0) goto _L159; else goto _L158
_L158:
        eV[flag] = a.f.a(abyte0, j1);
        j1 += 2;
        eW[flag] = a.f.b(abyte0, j1);
        j1 += 4;
        flag++;
_L159:
        if(flag < eU) goto _L158; else goto _L160
_L160:
        eX = false;
        eY = false;
        return;
        if(i != 215)
            break MISSING_BLOCK_LABEL_7235;
        if(abyte0[1] == 1)
        {
            eZ = true;
            if(i10 == 0)
                break MISSING_BLOCK_LABEL_7158;
        }
        eZ = false;
        if(abyte0[2] == 1)
        {
            fa = true;
            if(i10 == 0)
                break MISSING_BLOCK_LABEL_7180;
        }
        fa = false;
        if(abyte0[3] == 1)
        {
            fb = true;
            if(i10 == 0)
                break MISSING_BLOCK_LABEL_7202;
        }
        fb = false;
        if(abyte0[4] == 1)
        {
            fc = true;
            if(i10 == 0)
                break MISSING_BLOCK_LABEL_7224;
        }
        fc = false;
        eX = false;
        eY = false;
        return;
        if(i != 214)
            break MISSING_BLOCK_LABEL_7409;
        j1 = 1;
        flag = abyte0[j1++] & 0xff;
        l2 = a.f.a(abyte0, j1);
        j1 += 2;
        i3 = a.f.e(abyte0, j1);
        if(i3 >= 128)
        {
            j1 += 4;
            if(i10 == 0)
                break MISSING_BLOCK_LABEL_7296;
        }
        j1++;
        if(i3 != 0)
            break MISSING_BLOCK_LABEL_7369;
        fU--;
        c2 = flag;
        if(i10 == 0) goto _L162; else goto _L161
_L161:
        fV[c2] = fV[c2 + 1];
        fW[c2] = fW[c2 + 1];
        c2++;
_L162:
        if(c2 < fU) goto _L161; else goto _L163
_L163:
        if(i10 == 0)
            break MISSING_BLOCK_LABEL_7404;
        fV[flag] = l2;
        fW[flag] = i3;
        if(flag >= fU)
            fU = flag + 1;
        V();
        return;
        if(i != 213)
            break MISSING_BLOCK_LABEL_7538;
        j1 = 1;
        flag = true;
        l2 = abyte0[j1++] & 0xff;
        i3 = a.f.a(abyte0, j1);
        j1 += 2;
        if(b.h[i3 & 0x7fff] != 0)
            break MISSING_BLOCK_LABEL_7486;
        flag = a.f.e(abyte0, j1);
        if(flag >= 128)
        {
            j1 += 4;
            if(i10 == 0)
                break MISSING_BLOCK_LABEL_7486;
        }
        j1++;
        dA[l2] = i3 & 0x7fff;
        dC[l2] = i3 / 32768;
        dB[l2] = ((flag) ? 1 : 0);
        if(l2 >= dz)
        {
            dz = l2 + 1;
            return;
        }
        break MISSING_BLOCK_LABEL_8386;
        if(i != 212)
            break MISSING_BLOCK_LABEL_7634;
        j1 = abyte0[1] & 0xff;
        dz--;
        flag = j1;
        if(i10 == 0) goto _L165; else goto _L164
_L164:
        dA[flag] = dA[flag + 1];
        dB[flag] = dB[flag + 1];
        dC[flag] = dC[flag + 1];
        flag++;
_L165:
        if(flag < dz) goto _L164; else goto _L166
_L166:
        return;
        if(i == 211)
        {
            j1 = 1;
            flag = abyte0[j1++] & 0xff;
            dH[flag] = a.f.a(abyte0[j1++]);
            dI[flag] = a.f.a(abyte0[j1++]);
            dJ[flag] = a.f.b(abyte0, j1);
            j1 += 4;
            return;
        }
        if(i == 210)
        {
            j1 = abyte0[1];
            if(j1 == 1)
            {
                eX = true;
                return;
            } else
            {
                eX = false;
                return;
            }
        }
        if(i == 209)
        {
            j1 = abyte0[1];
            if(j1 == 1)
            {
                eY = true;
                return;
            } else
            {
                eY = false;
                return;
            }
        }
        if(i != 208)
            break MISSING_BLOCK_LABEL_8001;
        fd = true;
        fe = false;
        eP = false;
        j1 = 1;
        ff = a.f.c(abyte0, j1);
        j1 += 8;
        fj = abyte0[j1++] & 0xff;
        flag = false;
        if(i10 == 0) goto _L168; else goto _L167
_L167:
        fk[flag] = a.f.a(abyte0, j1);
        j1 += 2;
        fl[flag] = a.f.b(abyte0, j1);
        j1 += 4;
        flag++;
_L168:
        if(flag < fj) goto _L167; else goto _L169
_L169:
        fg = abyte0[j1++] & 0xff;
        l2 = 0;
        if(i10 == 0) goto _L171; else goto _L170
_L170:
        fh[l2] = a.f.a(abyte0, j1);
        j1 += 2;
        fi[l2] = a.f.b(abyte0, j1);
        j1 += 4;
        l2++;
_L171:
        if(l2 < fg) goto _L170; else goto _L172
_L172:
        fm = abyte0[j1++] & 0xff;
        fn = abyte0[j1++] & 0xff;
        fo = abyte0[j1++] & 0xff;
        fp = abyte0[j1++] & 0xff;
        return;
        if(i == 207)
        {
            String s1 = new String(abyte0, 1, i1 - 1);
            e(s1);
            return;
        }
        if(i == 206)
        {
            if(iC < 50)
            {
                int k1 = abyte0[1] & 0xff;
                int i2 = abyte0[2] + cO;
                l2 = abyte0[3] + cP;
                iG[iC] = k1;
                iF[iC] = 0;
                iD[iC] = i2;
                iE[iC] = l2;
                iC++;
                return;
            }
        } else
        if(i == 205)
        {
            if(!go)
            {
                gs = a.f.b(abyte0, 1);
                gt = a.f.b(abyte0, 5);
                gq = a.f.b(abyte0, 9);
                gu = (int)(Math.random() * 6D);
                gp = true;
                go = true;
                gr = null;
                return;
            }
        } else
        {
            if(i == 204)
            {
                gx = new String(abyte0, 1, i1 - 1);
                gw = true;
                gv = false;
                return;
            }
            if(i == 203)
            {
                gx = new String(abyte0, 1, i1 - 1);
                gw = true;
                gv = true;
                return;
            }
            if(i == 202)
            {
                dM = a.f.a(abyte0, 1);
                return;
            }
            if(i == 201)
            {
                if(!iH)
                    dN = dM;
                iH = true;
                super.N = "";
                super.O = "";
                bO.a(bY + 1, abyte0);
                iI = null;
                return;
            }
            if(i == 200)
            {
                dN = a.f.a(abyte0, 1);
                return;
            }
            if(i == 199)
            {
                iH = false;
                return;
            }
            if(i == 198)
                iI = "Incorrect - Please wait...";
        }
        return;
        RuntimeException runtimeexception;
        runtimeexception;
        String s2;
        if(bL >= 3)
            break MISSING_BLOCK_LABEL_8645;
        super.Y.a(17, 743);
        super.Y.a(runtimeexception.toString());
        super.Y.g();
        super.Y.a(17, 743);
        super.Y.a("p-type:" + i + " p-size:" + i1);
        super.Y.g();
        super.Y.a(17, 743);
        super.Y.a("rx:" + cO + " ry:" + cP + " num3l:" + dg);
        super.Y.g();
        s2 = "";
        l2 = 0;
        if(i10 == 0) goto _L174; else goto _L173
_L173:
        s2 = s2 + abyte0[l2] + " ";
        l2++;
_L174:
        if(l2 < 80 && l2 < i1) goto _L173; else goto _L175
_L175:
        super.Y.a(17, 743);
        super.Y.a(s2);
        super.Y.g();
        bL++;
    }

    public void V()
    {
        int i;
        int l1;
        l1 = b.bN;
        fX = fU;
        i = 0;
        if(l1 == 0) goto _L2; else goto _L1
_L1:
        fY[i] = fV[i];
        fZ[i] = fW[i];
        i++;
_L2:
        if(i < fU) goto _L1; else goto _L3
_L3:
        int i1 = 0;
        if(l1 == 0) goto _L5; else goto _L4
_L4:
        int j1;
        boolean flag;
        int k1;
        if(fX >= gc)
            break; /* Loop/switch isn't completed */
        j1 = dA[i1];
        flag = false;
        k1 = 0;
        if(l1 == 0) goto _L7; else goto _L6
_L6:
        if(fY[k1] != j1)
            continue; /* Loop/switch isn't completed */
        flag = true;
        if(l1 == 0)
            break; /* Loop/switch isn't completed */
        k1++;
_L7:
        if(k1 < fX) goto _L6; else goto _L8
_L8:
        if(!flag)
        {
            fY[fX] = j1;
            fZ[fX] = 0;
            fX++;
        }
        i1++;
_L5:
        if(i1 < dz) goto _L4; else goto _L9
_L9:
    }

    public boolean c(int i)
    {
        int i1;
        int j1;
        int k1;
        i1 = cN.e / 128;
        j1 = cN.f / 128;
        k1 = 2;
        if(b.bN == 0) goto _L2; else goto _L1
_L1:
        if(i == 1 && ((cm.z[i1][j1 - k1] & 0x80) == 128 || (cm.z[i1 - k1][j1] & 0x80) == 128 || (cm.z[i1 - k1][j1 - k1] & 0x80) == 128))
            return false;
        if(i == 3 && ((cm.z[i1][j1 + k1] & 0x80) == 128 || (cm.z[i1 - k1][j1] & 0x80) == 128 || (cm.z[i1 - k1][j1 + k1] & 0x80) == 128))
            return false;
        if(i == 5 && ((cm.z[i1][j1 + k1] & 0x80) == 128 || (cm.z[i1 + k1][j1] & 0x80) == 128 || (cm.z[i1 + k1][j1 + k1] & 0x80) == 128))
            return false;
        if(i == 7 && ((cm.z[i1][j1 - k1] & 0x80) == 128 || (cm.z[i1 + k1][j1] & 0x80) == 128 || (cm.z[i1 + k1][j1 - k1] & 0x80) == 128))
            return false;
        if(i == 0 && (cm.z[i1][j1 - k1] & 0x80) == 128)
            return false;
        if(i == 2 && (cm.z[i1 - k1][j1] & 0x80) == 128)
            return false;
        if(i == 4 && (cm.z[i1][j1 + k1] & 0x80) == 128)
            return false;
        if(i == 6 && (cm.z[i1 + k1][j1] & 0x80) == 128)
            return false;
        k1--;
_L2:
        if(k1 < 1)
            return true;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void W()
    {
        int ai[];
        int i;
        int i1;
        i1 = b.bN;
        if((cC & 1) == 1 && c(cC))
            return;
        if((cC & 1) == 0 && c(cC))
        {
            if(c(cC + 1 & 7))
            {
                cC = cC + 1 & 7;
                return;
            }
            if(c(cC + 7 & 7))
                cC = cC + 7 & 7;
            return;
        }
        ai = (new int[] {
            1, -1, 2, -2, 3, -3, 4
        });
        i = 0;
        if(i1 == 0) goto _L2; else goto _L1
_L1:
        if(!c(cC + ai[i] + 8 & 7))
            continue; /* Loop/switch isn't completed */
        cC = cC + ai[i] + 8 & 7;
        if(i1 == 0)
            break; /* Loop/switch isn't completed */
        i++;
_L2:
        if(i < 7) goto _L1; else goto _L3
_L3:
        if((cC & 1) == 0 && c(cC))
        {
            if(c(cC + 1 & 7))
            {
                cC = cC + 1 & 7;
                return;
            }
            if(c(cC + 7 & 7))
                cC = cC + 7 & 7;
            return;
        } else
        {
            return;
        }
    }

    public void X()
    {
        int i;
        int j10;
label0:
        {
label1:
            {
                j10 = b.bN;
                if(gA != 0)
                {
                    bO.d();
                    bO.b("Oh dear! You are dead...", bR / 2, bS / 2, 7, 0xff0000);
                    Y();
                    bO.a(bM, 0, 0);
                    return;
                }
                if(il)
                {
                    O();
                    return;
                }
                if(ho)
                {
                    I();
                    return;
                }
                if(hK)
                {
                    L();
                    return;
                }
                if(!iH)
                    break label0;
                bO.d();
                if(Math.random() < 0.14999999999999999D)
                    bO.b("ZZZ", (int)(Math.random() * 80D), (int)(Math.random() * 334D), 5, (int)(Math.random() * 16777215D));
                if(Math.random() < 0.14999999999999999D)
                    bO.b("ZZZ", 512 - (int)(Math.random() * 80D), (int)(Math.random() * 334D), 5, (int)(Math.random() * 16777215D));
                bO.b(bR / 2 - 100, 160, 200, 40, 0);
                bO.b("You are sleeping", bR / 2, 50, 7, 0xffff00);
                bO.b("Fatigue: " + (dN * 100) / 750 + "%", bR / 2, 90, 7, 0xffff00);
                bO.b("When you want to wake up just use your", bR / 2, 140, 5, 0xffffff);
                bO.b("keyboard to type the word in the box below", bR / 2, 160, 5, 0xffffff);
                bO.b(super.N + "*", bR / 2, 180, 5, 65535);
                if(iI == null)
                {
                    bO.c(bR / 2 - 127, 230, bY + 1); //draws the word
                    if(j10 == 0)
                        break label1;
                }
                bO.b(iI, bR / 2, 260, 5, 0xff0000); //draws some string in the box (e.g. "Incorrect - Please wait...")
            }
            bO.c(bR / 2 - 128, 229, 257, 42, 0xffffff);
            Y();
            bO.b("If you can't read the word", bR / 2, 290, 1, 0xffffff);
            bO.b("@yel@click here@whi@ to get a different one", bR / 2, 305, 1, 0xffffff);
            bO.a(bM, 0, 0);
            return;
        }
        if(!cm.B)
            return;
        i = 0;
        if(j10 == 0) goto _L2; else goto _L1
_L1:
        bN.b(cm.E[cq][i]);
        if(cq == 0)
        {
            bN.b(cm.D[1][i]);
            bN.b(cm.E[1][i]);
            bN.b(cm.D[2][i]);
            bN.b(cm.E[2][i]);
        }
        cz = true;
        if(cq == 0 && (cm.z[cN.e / 128][cN.f / 128] & 0x80) == 0)
        {
            bN.a(cm.E[cq][i]);
            if(cq == 0)
            {
                bN.a(cm.D[1][i]);
                bN.a(cm.E[1][i]);
                bN.a(cm.D[2][i]);
                bN.a(cm.E[2][i]);
            }
            cz = false;
        }
        i++;
_L2:
        if(i < 64) goto _L1; else goto _L3
_L3:
        if(cd == cg) goto _L5; else goto _L4
_L4:
        int i1;
        cg = cd;
        i1 = 0;
        if(j10 == 0) goto _L7; else goto _L6
_L6:
        if(dk[i1] == 97)
            c(i1, "firea" + (cd + 1));
        if(dk[i1] == 274)
            c(i1, "fireplacea" + (cd + 1));
        if(dk[i1] == 1031)
            c(i1, "lightning" + (cd + 1));
        if(dk[i1] == 1036)
            c(i1, "firespell" + (cd + 1));
        if(dk[i1] == 1147)
            c(i1, "spellcharge" + (cd + 1));
        i1++;
_L7:
        if(i1 < dg) goto _L6; else goto _L5
_L5:
        if(ce == ch) goto _L9; else goto _L8
_L8:
        ch = ce;
        i1 = 0;
        if(j10 == 0) goto _L11; else goto _L10
_L10:
        if(dk[i1] == 51)
            c(i1, "torcha" + (ce + 1));
        if(dk[i1] == 143)
            c(i1, "skulltorcha" + (ce + 1));
        i1++;
_L11:
        if(i1 < dg) goto _L10; else goto _L9
_L9:
        if(cf == ci) goto _L13; else goto _L12
_L12:
        ci = cf;
        i1 = 0;
        if(j10 == 0) goto _L15; else goto _L14
_L14:
        if(dk[i1] == 1142)
            c(i1, "clawspell" + (cf + 1));
        i1++;
_L15:
        if(i1 < dg) goto _L14; else goto _L13
_L13:
        bN.a(cJ);
        cJ = 0;
        i1 = 0;
        if(j10 == 0) goto _L17; else goto _L16
_L16:
        c c1 = cL[i1];
        if(c1.A != 255)
        {
            int k1 = c1.e;
            int i2 = c1.f;
            int k2 = -cm.b(k1, i2);
            int l3 = bN.a(5000 + i1, k1, k2, i2, 145, 220, i1 + 10000);
            cJ++;
            if(c1 == cN)
                bN.b(l3);
            if(c1.i == 8)
                bN.a(l3, -30);
            if(c1.i == 9)
                bN.a(l3, 30);
        }
        i1++;
_L17:
        if(i1 < cH) goto _L16; else goto _L18
_L18:
        int j1 = 0;
        if(j10 == 0) goto _L20; else goto _L19
_L19:
        c c2 = cL[j1];
        if(c2.F > 0)
        {
            c c3 = null;
            if(c2.E != -1)
                c3 = cV[c2.E];
            else
            if(c2.D != -1)
                c3 = cK[c2.D];
            if(c3 != null)
            {
                int l2 = c2.e;
                int i4 = c2.f;
                int k6 = -cm.b(l2, i4) - 110;
                int j8 = c3.e;
                int i9 = c3.f;
                int j9 = -cm.b(j8, i9) - b.C[c3.g] / 2;
                int k9 = (l2 * c2.F + j8 * (cb - c2.F)) / cb;
                int l9 = (k6 * c2.F + j9 * (cb - c2.F)) / cb;
                int i10 = (i4 * c2.F + i9 * (cb - c2.F)) / cb;
                bN.a(bX + c2.C, k9, l9, i10, 32, 32, 0);
                cJ++;
            }
        }
        j1++;
_L20:
        if(j1 < cH) goto _L19; else goto _L21
_L21:
        int l1 = 0;
        if(j10 == 0) goto _L23; else goto _L22
_L22:
        c c4 = cW[l1];
        int i3 = c4.e;
        int j4 = c4.f;
        int l6 = -cm.b(i3, j4);
        int k8 = bN.a(20000 + l1, i3, l6, j4, b.B[c4.g], b.C[c4.g], l1 + 30000);
        cJ++;
        if(c4.i == 8)
            bN.a(k8, -30);
        if(c4.i == 9)
            bN.a(k8, 30);
        l1++;
_L23:
        if(l1 < cT) goto _L22; else goto _L24
_L24:
        int j2 = 0;
        if(j10 == 0) goto _L26; else goto _L25
_L25:
        int j3 = db[j2] * bP + 64;
        int k4 = dc[j2] * bP + 64;
        bN.a(40000 + dd[j2], j3, -cm.b(j3, k4) - de[j2], k4, 96, 64, j2 + 20000);
        cJ++;
        j2++;
_L26:
        if(j2 < da) goto _L25; else goto _L27
_L27:
        int k3 = 0;
        if(j10 == 0) goto _L29; else goto _L28
_L28:
        int l4 = iD[k3] * bP + 64;
        int i7 = iE[k3] * bP + 64;
        int l8 = iG[k3];
        if(l8 == 0)
        {
            bN.a(50000 + k3, l4, -cm.b(l4, i7), i7, 128, 256, k3 + 50000);
            cJ++;
        }
        if(l8 == 1)
        {
            bN.a(50000 + k3, l4, -cm.b(l4, i7), i7, 128, 64, k3 + 50000);
            cJ++;
        }
        k3++;
_L29:
        if(k3 < iC) goto _L28; else goto _L30
_L30:
label2:
        {
label3:
            {
                bO.y = false;
                bO.c();
                bO.y = super.M;
                if(cq == 3)
                {
                    int i5 = 40 + (int)(Math.random() * 3D);
                    int j7 = 40 + (int)(Math.random() * 7D);
                    bN.a(i5, j7, -50, -10, -50);
                }
                hY = 0;
                hS = 0;
                id = 0;
                if(ei)
                {
                    if(ej && !cz)
                    {
                        int j5 = cC;
                        W();
                        if(cC != j5)
                        {
                            cA = cN.e;
                            cB = cN.f;
                        }
                    }
                    bN.g = 3000;
                    bN.h = 3000;
                    bN.i = 1;
                    bN.j = 2800;
                    cE = cC * 32;
                    int k5 = cA + bG;
                    int k7 = cB + bI;
                    bN.b(k5, -cm.b(k5, k7), k7, 912, cE * 4, 0, 2000);
                    if(j10 == 0)
                        break label2;
                }
                if(ej && !cz)
                    W();
                if(!super.M)
                {
                    bN.g = 2400;
                    bN.h = 2400;
                    bN.i = 1;
                    bN.j = 2300;
                    if(j10 == 0)
                        break label3;
                }
                bN.g = 2200;
                bN.h = 2200;
                bN.i = 1;
                bN.j = 2100;
            }
            int l5 = cA + bG;
            int l7 = cB + bI;
            bN.b(l5, -cm.b(l5, l7), l7, 912, cE * 4, 0, cy * 2);
        }
        bN.f();
        Z();
        if(cj > 0)
            bO.c(ck - 8, cl - 8, bU + 14 + (24 - cj) / 6);
        if(cj < 0)
            bO.c(ck - 8, cl - 8, bU + 18 + (24 + cj) / 6);
        if(!gC)
        {
            int i6 = 2203 - (cP + co + cs);
            if(cO + cn + cr >= 2640)
                i6 = -50;
            if(i6 > 0)
            {
                int i8 = 1 + i6 / 6;
                bO.c(453, bS - 56, bU + 13);
                bO.b("Wilderness", 465, bS - 20, 1, 0xffff00);
                bO.b("Level: " + i8, 465, bS - 7, 1, 0xffff00);
                if(gB == 0)
                    gB = 2;
            }
            if(gB == 0 && i6 > -10 && i6 <= 0)
                gB = 1;
        }
        if(eL != 0) goto _L32; else goto _L31
_L31:
        int j6 = 0;
        if(j10 == 0) goto _L34; else goto _L33
_L33:
        if(eO[j6] > 0)
        {
            String s1 = eN[j6];
            bO.c(s1, 7, bS - 18 - j6 * 12, 1, 0xffff00);
        }
        j6++;
_L34:
        if(j6 < eM) goto _L33; else goto _L32
_L32:
label4:
        {
            eG.g(eH);
            eG.g(eJ);
            eG.g(eK);
            if(eL == 1)
            {
                eG.f(eH);
                if(j10 == 0)
                    break label4;
            }
            if(eL == 2)
            {
                eG.f(eJ);
                if(j10 == 0)
                    break label4;
            }
            if(eL == 3)
                eG.f(eK);
        }
        e.T = 2;
        eG.a();
        e.T = 0;
        bO.d(((g) (bO)).a - 3 - 197, 3, bU, 128);
        ba();
        bO.C = false;
        Y();
        bO.a(bM, 0, 0);
        return;
    }

    public void c(int i, String s1)
    {
        int i1 = di[i];
        int j1 = dj[i];
        int k1 = i1 - cN.e / 128;
        int l1 = j1 - cN.f / 128;
        byte byte0 = 7;
        if(i1 >= 0 && j1 >= 0 && i1 < 96 && j1 < 96 && k1 > -byte0 && k1 < byte0 && l1 > -byte0 && l1 < byte0)
        {
            bN.b(dh[i]);
            int i2 = b.a(s1);
            f f1 = dm[i2].i();
            bN.a(f1);
            f1.a(true, 48, 48, -50, -10, -50);
            f1.a(dh[i]);
            f1.F = i;
            dh[i] = f1;
        }
    }

    public void Y()
    {
        bO.c(0, bS - 4, bU + 23);
        int i = a.a.g.b(200, 200, 255);
        if(eL == 0)
            i = a.a.g.b(255, 200, 50);
        if(eC % 30 > 15)
            i = a.a.g.b(255, 50, 50);
        bO.b("All messages", 54, bS + 6, 0, i);
        i = a.a.g.b(200, 200, 255);
        if(eL == 1)
            i = a.a.g.b(255, 200, 50);
        if(eD % 30 > 15)
            i = a.a.g.b(255, 50, 50);
        bO.b("Chat history", 155, bS + 6, 0, i);
        i = a.a.g.b(200, 200, 255);
        if(eL == 2)
            i = a.a.g.b(255, 200, 50);
        if(eE % 30 > 15)
            i = a.a.g.b(255, 50, 50);
        bO.b("Quest history", 255, bS + 6, 0, i);
        i = a.a.g.b(200, 200, 255);
        if(eL == 3)
            i = a.a.g.b(255, 200, 50);
        if(eF % 30 > 15)
            i = a.a.g.b(255, 50, 50);
        bO.b("Private history", 355, bS + 6, 0, i);
        bO.b("Report abuse", 457, bS + 6, 0, 0xffffff);
    }

    public void a(int i, int i1, int j1, int k1, int l1, int i2, int j2)
    {
        int k2 = iG[l1];
        int l2 = iF[l1];
        if(k2 == 0)
        {
            int i3 = 255 + l2 * 5 * 256;
            bO.a(i + j1 / 2, i1 + k1 / 2, 20 + l2 * 2, i3, 255 - l2 * 5);
        }
        if(k2 == 1)
        {
            int j3 = 0xff0000 + l2 * 5 * 256;
            bO.a(i + j1 / 2, i1 + k1 / 2, 10 + l2, j3, 255 - l2 * 5);
        }
    }

    public void b(int i, int i1, int j1, int k1, int l1, int i2, int j2)
    {
        int k2 = b.f[l1] + bW;
        int l2 = b.k[l1];
        bO.a(i, i1, j1, k1, k2, l2, 0, 0, false);
    }

    public void c(int i, int i1, int j1, int k1, int l1, int i2, int j2)
    {
        c c1;
        int k2;
        boolean flag;
        int l2;
        int i3;
        int j3;
        int k6;
label0:
        {
            k6 = b.bN;
            c1 = cW[l1];
            k2 = c1.i + (cE + 16) / 32 & 7;
            flag = false;
            l2 = k2;
            if(l2 == 5)
            {
                l2 = 3;
                flag = true;
                if(k6 == 0)
                    break label0;
            }
            if(l2 == 6)
            {
                l2 = 2;
                flag = true;
                if(k6 == 0)
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
            i3 = l2 * 3 + ix[(c1.h / b.D[c1.g]) % 4];
            if(c1.i == 8)
            {
                l2 = 5;
                k2 = 2;
                flag = false;
                i -= (b.F[c1.g] * j2) / 100;
                i3 = l2 * 3 + iy[(bx / (b.E[c1.g] - 1)) % 8];
                if(k6 == 0)
                    break label1;
            }
            if(c1.i == 9)
            {
                l2 = 5;
                k2 = 2;
                flag = true;
                i += (b.F[c1.g] * j2) / 100;
                i3 = l2 * 3 + iz[(bx / b.E[c1.g]) % 8];
            }
        }
        j3 = 0;
        if(k6 == 0) goto _L2; else goto _L1
_L1:
        int l4;
        int i5;
        int k5;
        int l5;
        int i6;
        int j6;
label2:
        {
            int k3 = ik[k2][j3];
            int j4 = b.w[c1.g][k3];
            if(j4 < 0)
                continue;
            l4 = 0;
            i5 = 0;
            int j5 = i3;
            if(flag && l2 >= 1 && l2 <= 3 && b.O[j4] == 1)
                j5 += 15;
            if(l2 == 5 && b.N[j4] != 1)
                continue;
            k5 = j5 + b.P[j4];
            l4 = (l4 * j1) / ((g) (bO)).r[k5];
            i5 = (i5 * k1) / ((g) (bO)).s[k5];
            l5 = (j1 * ((g) (bO)).r[k5]) / ((g) (bO)).r[b.P[j4]];
            l4 -= (l5 - j1) / 2;
            i6 = b.L[j4];
            j6 = 0;
            if(i6 == 1)
            {
                i6 = b.x[c1.g];
                j6 = b.A[c1.g];
                if(k6 == 0)
                    break label2;
            }
            if(i6 == 2)
            {
                i6 = b.y[c1.g];
                j6 = b.A[c1.g];
                if(k6 == 0)
                    break label2;
            }
            if(i6 == 3)
            {
                i6 = b.z[c1.g];
                j6 = b.A[c1.g];
            }
        }
        bO.a(i + l4, i1 + i5, l5, k1, k5, i6, j6, i2, flag);
        j3++;
_L2:
        if(j3 >= 12)
        {
label3:
            {
label4:
                {
                    int l3;
label5:
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
                        if(c1.i != 8 && c1.i != 9 && c1.w == 0)
                            break label3;
                        if(c1.w <= 0)
                            break label4;
                        l3 = i;
                        if(c1.i == 8)
                        {
                            l3 -= (20 * j2) / 100;
                            if(k6 == 0)
                                break label5;
                        }
                        if(c1.i == 9)
                            l3 += (20 * j2) / 100;
                    }
                    int k4 = (c1.u * 30) / c1.v;
                    ie[id] = l3 + j1 / 2;
                    ig[id] = i1;
                    ih[id++] = k4;
                }
                int i4;
label6:
                {
                    if(c1.w <= 150)
                        break label3;
                    i4 = i;
                    if(c1.i == 8)
                    {
                        i4 -= (10 * j2) / 100;
                        if(k6 == 0)
                            break label6;
                    }
                    if(c1.i == 9)
                        i4 += (10 * j2) / 100;
                }
                bO.c((i4 + j1 / 2) - 12, (i1 + k1 / 2) - 12, bU + 12);
                bO.b(String.valueOf(c1.t), (i4 + j1 / 2) - 1, i1 + k1 / 2 + 5, 3, 0xffffff);
            }
            return;
        }
        if(true) goto _L1; else goto _L3
_L3:
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
        if(j7 == 0) goto _L2; else goto _L1
_L1:
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
            j5 = (j5 * j1) / ((g) (bO)).r[j6];
            l5 = (l5 * k1) / ((g) (bO)).s[j6];
            k6 = (j1 * ((g) (bO)).r[j6]) / ((g) (bO)).r[b.P[k4]];
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
        bO.a(i + j5, i1 + l5, k6, k1, j6, l6, i7, i2, flag);
        j3++;
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
                    ih[id++] = l4;
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
                bO.c((i4 + j1 / 2) - 12, (i1 + k1 / 2) - 12, bU + 11);
                bO.b(String.valueOf(c1.t), (i4 + j1 / 2) - 1, i1 + k1 / 2 + 5, 3, 0xffffff);
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
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void Z()
    {
        int i;
        int j5;
        j5 = b.bN;
        i = 0;
        if(j5 == 0) goto _L2; else goto _L1
_L1:
        int i1;
        int j1;
        int k1;
        int j2;
        int i3;
        boolean flag;
        i1 = bO.c(1);
        j1 = hU[i];
        k1 = hV[i];
        j2 = hW[i];
        i3 = hX[i];
        flag = true;
        if(j5 == 0) goto _L4; else goto _L3
_L3:
        int i4;
        flag = false;
        i4 = 0;
        if(j5 == 0) goto _L6; else goto _L5
_L5:
        if(k1 + i3 > hV[i4] - i1 && k1 - i1 < hV[i4] + hX[i4] && j1 - j2 < hU[i4] + hW[i4] && j1 + j2 > hU[i4] - hW[i4] && hV[i4] - i1 - i3 < k1)
        {
            k1 = hV[i4] - i1 - i3;
            flag = true;
        }
        i4++;
_L6:
        if(i4 < i) goto _L5; else goto _L4
_L4:
        if(flag) goto _L3; else goto _L7
_L7:
        hV[i] = k1;
        bO.a(hT[i], j1, k1, 1, 0xffff00, 300);
        i++;
_L2:
        if(i < hS) goto _L1; else goto _L8
_L8:
        i1 = 0;
        if(j5 == 0) goto _L10; else goto _L9
_L9:
        j1 = hZ[i1];
        int l1 = ia[i1];
        int k2 = ib[i1];
        int j3 = ic[i1];
        int l3 = (39 * k2) / 100;
        int j4 = (27 * k2) / 100;
        int k4 = l1 - j4;
        bO.d(j1 - l3 / 2, k4, l3, j4, bU + 9, 85);
        int l4 = (36 * k2) / 100;
        int i5 = (24 * k2) / 100;
        bO.a(j1 - l4 / 2, (k4 + j4 / 2) - i5 / 2, l4, i5, b.f[j3] + bW, b.k[j3], 0, 0, false);
        i1++;
_L10:
        if(i1 < hY) goto _L9; else goto _L11
_L11:
        j1 = 0;
        if(j5 == 0) goto _L13; else goto _L12
_L12:
        int i2 = ie[j1];
        int l2 = ig[j1];
        int k3 = ih[j1];
        bO.a(i2 - 15, l2 - 3, k3, 5, 65280, 192);
        bO.a((i2 - 15) + k3, l2 - 3, 30 - k3, 5, 0xff0000, 192);
        j1++;
_L13:
        if(j1 >= id)
            return;
        if(true) goto _L12; else goto _L14
_L14:
    }

    public int d(int i) //put 10 in to get how much money you have
    {
        int i1;
        int j1;
        int k1;
        k1 = b.bN;
        i1 = 0;
        j1 = 0;
        if(k1 == 0) goto _L2; else goto _L1
_L1:
        if(dA[j1] != i)
            continue;
        if(b.h[i] == 1)
        {
            i1++;
            if(k1 == 0)
                continue;
        }
        i1 += dB[j1];
        j1++;
_L2:
        if(j1 >= dz)
            return i1;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public boolean b(int i, int i1)
    {
        if(i == 31 && (e(197) || e(615) || e(682)))
            return true;
        if(i == 32 && (e(102) || e(616) || e(683)))
            return true;
        if(i == 33 && (e(101) || e(617) || e(684)))
            return true;
        if(i == 34 && (e(103) || e(618) || e(685)))
            return true;
        return d(i) >= i1;
    }

    public boolean e(int i)
    {
        int i1 = 0;
        if(b.bN == 0) goto _L2; else goto _L1
_L1:
        if(dA[i1] == i && dC[i1] == 1)
            return true;
        i1++;
_L2:
        if(i1 >= dz)
            return false;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void b(int i, int i1, int j1)
    {
        bO.a(i, i1, j1);
        bO.a(i - 1, i1, j1);
        bO.a(i + 1, i1, j1);
        bO.a(i, i1 - 1, j1);
        bO.a(i, i1 + 1, j1);
    }

    public void a(int i, int i1, int j1, int k1, boolean flag)
    {
        a(i, i1, j1, k1, j1, k1, false, flag);
    }

    public void b(int i, int i1, int j1, int k1, boolean flag)
    {
        if(a(i, i1, j1, k1, j1, k1, false, flag))
        {
            return;
        } else
        {
            a(i, i1, j1, k1, j1, k1, true, flag);
            return;
        }
    }

    public void c(int i, int i1, int j1, int k1)
    {
        int l1;
        int i2;
label0:
        {
            if(j1 == 0 || j1 == 4)
            {
                l1 = b.W[k1];
                i2 = b.X[k1];
                if(b.bN == 0)
                    break label0;
            }
            i2 = b.W[k1];
            l1 = b.X[k1];
        }
        if(b.Y[k1] == 2 || b.Y[k1] == 3)
        {
            if(j1 == 0)
            {
                i--;
                l1++;
            }
            if(j1 == 2)
                i2++;
            if(j1 == 4)
                l1++;
            if(j1 == 6)
            {
                i1--;
                i2++;
            }
            a(cO, cP, i, i1, (i + l1) - 1, (i1 + i2) - 1, false, true);
            return;
        } else
        {
            a(cO, cP, i, i1, (i + l1) - 1, (i1 + i2) - 1, true, true);
            return;
        }
    }

    public void c(int i, int i1, int j1)
    {
        if(j1 == 0)
        {
            a(cO, cP, i, i1 - 1, i, i1, false, true);
            return;
        }
        if(j1 == 1)
        {
            a(cO, cP, i - 1, i1, i, i1, false, true);
            return;
        } else
        {
            a(cO, cP, i, i1, i, i1, true, true);
            return;
        }
    }

    public boolean a(int i, int i1, int j1, int k1, int l1, int i2, boolean flag, 
            boolean flag1)
    {
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
            super.Y.a(194, 770); //walk to command
        }
        super.Y.b(i + cr);
        super.Y.b(i1 + cs);
        k2 = j2;
        if(l2 == 0) goto _L2; else goto _L1
_L1:
        super.Y.a(bB[k2] - i);
        super.Y.a(bC[k2] - i1);
        k2--;
_L2:
        if(k2 < 0 || k2 <= j2 - 25)
        {
            super.Y.g();
            cj = -24;
            ck = super.G;
            cl = super.H;
            return true;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public boolean c(int i, int i1)
    {
        int j2;
        int k2;
        int l2;
        int k7;
        k7 = b.bN;
        if(gA != 0)
        {
            cm.B = false;
            return false;
        }
        gC = false;
        i += cn;
        i1 += co;
        if(cq == ct && i > cu && i < cw && i1 > cv && i1 < cx)
        {
            cm.B = true;
            return false;
        }
        bO.b("Loading... Please wait", 256, 192, 1, 0xffffff);
        Y();
        bO.a(bM, 0, 0);
        int j1 = cr;
        int k1 = cs;
        int l1 = (i + 24) / 48;
        int i2 = (i1 + 24) / 48;
        cq = ct;
        cr = l1 * 48 - 48;
        cs = i2 * 48 - 48;
        cu = l1 * 48 - 32;
        cv = i2 * 48 - 32;
        cw = l1 * 48 + 32;
        cx = i2 * 48 + 32;
        cm.i(i, i1, cq);
        cr -= cn;
        cs -= co;
        j2 = cr - j1;
        k2 = cs - k1;
        l2 = 0;
        if(k7 == 0) goto _L2; else goto _L1
_L1:
        di[l2] -= j2;
        dj[l2] -= k2;
        int i3 = di[l2];
        int k3 = dj[l2];
        int j4 = dk[l2];
        f f1 = dh[l2];
        try
        {
            int j6;
            int l6;
label0:
            {
                int k5 = dl[l2];
                if(k5 == 0 || k5 == 4)
                {
                    j6 = b.W[j4];
                    l6 = b.X[j4];
                    if(k7 == 0)
                        break label0;
                }
                l6 = b.W[j4];
                j6 = b.X[j4];
            }
            int i7 = ((i3 + i3 + j6) * bP) / 2;
            int j7 = ((k3 + k3 + l6) * bP) / 2;
            if(i3 >= 0 && k3 >= 0 && i3 < 96 && k3 < 96)
            {
                bN.a(f1);
                f1.g(i7, -cm.b(i7, j7), j7);
                cm.c(i3, k3, j4);
                if(j4 == 74)
                    f1.f(0, -480, 0);
            }
            continue; /* Loop/switch isn't completed */
        }
        catch(RuntimeException runtimeexception)
        {
            System.out.println("Loc Error: " + runtimeexception.getMessage());
            System.out.println("i:" + l2 + " obj:" + f1);
            runtimeexception.printStackTrace();
            l2++;
        }
_L2:
        if(l2 < dg) goto _L1; else goto _L3
_L3:
        int j3 = 0;
        if(k7 == 0) goto _L5; else goto _L4
_L4:
        ds[j3] -= j2;
        dt[j3] -= k2;
        int l3 = ds[j3];
        int k4 = dt[j3];
        int i5 = dv[j3];
        int l5 = du[j3];
        try
        {
            cm.a(l3, k4, l5, i5);
            f f2 = b(l3, k4, l5, i5, j3);
            dr[j3] = f2;
        }
        catch(RuntimeException runtimeexception1)
        {
            System.out.println("Bound Error: " + runtimeexception1.getMessage());
            runtimeexception1.printStackTrace();
        }
        j3++;
_L5:
        if(j3 < dq) goto _L4; else goto _L6
_L6:
        int i4 = 0;
        if(k7 == 0) goto _L8; else goto _L7
_L7:
        db[i4] -= j2;
        dc[i4] -= k2;
        i4++;
_L8:
        if(i4 < da) goto _L7; else goto _L9
_L9:
        int l4 = 0;
        if(k7 == 0) goto _L11; else goto _L10
_L10:
        c c1;
        int i6;
        c1 = cL[l4];
        c1.e -= j2 * bP;
        c1.f -= k2 * bP;
        i6 = 0;
        if(k7 == 0) goto _L13; else goto _L12
_L12:
        c1.m[i6] -= j2 * bP;
        c1.n[i6] -= k2 * bP;
        i6++;
_L13:
        if(i6 <= c1.l) goto _L12; else goto _L14
_L14:
        l4++;
_L11:
        if(l4 < cH) goto _L10; else goto _L15
_L15:
        int j5 = 0;
        if(k7 == 0) goto _L17; else goto _L16
_L16:
        c c2;
        int k6;
        c2 = cW[j5];
        c2.e -= j2 * bP;
        c2.f -= k2 * bP;
        k6 = 0;
        if(k7 == 0) goto _L19; else goto _L18
_L18:
        c2.m[k6] -= j2 * bP;
        c2.n[k6] -= k2 * bP;
        k6++;
_L19:
        if(k6 <= c2.l) goto _L18; else goto _L20
_L20:
        j5++;
_L17:
        if(j5 >= cT)
        {
            cm.B = true;
            return true;
        }
        if(true) goto _L16; else goto _L21
_L21:
    }

    public f b(int i, int i1, int j1, int k1, int l1)
    {
        int i2 = i;
        int j2 = i1;
        int k2 = i;
        int l2 = i1;
        int i3 = b.bg[k1];
        int j3 = b.bh[k1];
        int k3 = b.bf[k1];
        f f1 = new f(4, 1);
        if(j1 == 0)
            k2 = i + 1;
        if(j1 == 1)
            l2 = i1 + 1;
        if(j1 == 2)
        {
            i2 = i + 1;
            l2 = i1 + 1;
        }
        if(j1 == 3)
        {
            k2 = i + 1;
            l2 = i1 + 1;
        }
        i2 *= bP;
        j2 *= bP;
        k2 *= bP;
        l2 *= bP;
        int l3 = f1.a(i2, -cm.b(i2, j2), j2);
        int i4 = f1.a(i2, -cm.b(i2, j2) - k3, j2);
        int j4 = f1.a(k2, -cm.b(k2, l2) - k3, l2);
        int k4 = f1.a(k2, -cm.b(k2, l2), l2);
        int ai[] = {
            l3, i4, j4, k4
        };
        f1.a(4, ai, i3, j3);
        f1.a(false, 60, 24, -50, -10, -50);
        if(i >= 0 && i1 >= 0 && i < 96 && i1 < 96)
            bN.a(f1);
        f1.F = l1 + 10000;
        return f1;
    }

    public void ba() //show a dialog box to the user
    {
label0:
        {
            int i = b.bN;
            if(gy != 0)
            {
                bf(); //logging out
                if(i == 0)
                    break label0;
            }
            if(gp)
            {
                bd(); //Welcome/just logged in
                if(i == 0)
                    break label0;
            }
            if(gw)
            {
                be(); //Custom message??
                if(i == 0)
                    break label0;
            }
            if(gB == 1)
            {
                bg(); //wildnessWarning
                if(i == 0)
                    break label0;
            }
            if(fT && gz == 0)
            {
                bk(); //bank screen
                if(i == 0)
                    break label0;
            }
            if(fL && gz == 0)
            {
                bl(); //shop screen
                if(i == 0)
                    break label0;
            }
            if(fD)
            {
                bm(); //trade window
                if(i == 0)
                    break label0;
            }
            if(fq)
            {
                bn(); //summary of trade
                if(i == 0)
                    break label0;
            }
            if(fd)
            {
                bo(); //confirm trade
                if(i == 0)
                    break label0;
            }
            if(eP)
            {
                bp();  //duel with another pc
                if(i == 0)
                    break label0;
            }
            if(gl != 0)
            {
                bi(); //change password
                if(i == 0)
                    break label0;
            }
            if(gj != 0)
            {
                bh(); //report abuse
                if(i == 0)
                    break label0;
            }
            if(gi != 0)
            {
                bj(); //send message to friend or add/ignore person to list
                if(i == 0)
                    break label0;
            }
            if(ge)
                bb();
            if(cN.i == 8 || cN.i == 9)
                bc(); //choose combat style (agressive,defensive,ect..)
            bq();  //Determins what what menu the mouse is on
            boolean flag = !ge && !em;
            if(flag)
                er = 0;
            if(dx == 0 && flag)
                br(); //action submenu
            if(dx == 1)
                a(flag); //inventory
            if(dx == 2)
                b(flag); //map
            if(dx == 3)
                c(flag); //status
            if(dx == 4)
                d(flag); //Magic/Prayers
            if(dx == 5)
                e(flag); //chat box (the :-) one)
            if(dx == 6)
                f(flag); //game options
            if(!em && !ge)
                bt(); //info on item when mouse is hovered over it
            if(em && !ge)
                bs(); //right click
        }
        bz = 0;
    }

    public void bb() //displace an npc converstaion option (called every loop when option is on)
    {
        int i;
        int j1;
        j1 = b.bN;
        if(bz == 0)
            break MISSING_BLOCK_LABEL_115;
        i = 0;
        if(j1 == 0) goto _L2; else goto _L1
_L1:
        if(super.G >= bO.a(gg[i], 1) || super.H <= i * 12 || super.H >= 12 + i * 12)
            continue; /* Loop/switch isn't completed */
        super.Y.a(237, 3); //user selected an option
        super.Y.a(i);
        super.Y.g();
        if(j1 == 0)
            break; /* Loop/switch isn't completed */
        i++;
_L2:
        if(i < gf) goto _L1; else goto _L3
_L3:
        bz = 0;
        ge = false;
        return;
        i = 0;
        if(j1 == 0) goto _L5; else goto _L4
_L4:
        int i1 = 65535;
        if(super.G < bO.a(gg[i], 1) && super.H > i * 12 && super.H < 12 + i * 12)
            i1 = 0xff0000;
        bO.c(gg[i], 6, 12 + i * 12, 1, i1);
        i++;
_L5:
        if(i >= gf)
            return;
        if(true) goto _L4; else goto _L6
_L6:
    }

    public void bc()
    {
        byte byte0;
        byte byte1;
        char c1;
        int i1;
        i1 = b.bN;
        byte0 = 7;
        byte1 = 15;
        c1 = '\257';
        if(bz == 0) goto _L2; else goto _L1
_L1:
        int i = 0;
        if(i1 == 0) goto _L4; else goto _L3
_L3:
        if(i <= 0 || super.G <= byte0 || super.G >= byte0 + c1 || super.H <= byte1 + i * 20 || super.H >= byte1 + i * 20 + 20)
            continue; /* Loop/switch isn't completed */
        gh = i - 1;
        bz = 0;
        super.Y.a(231, 700);
        super.Y.a(gh);
        super.Y.g();
        if(i1 == 0)
            break; /* Loop/switch isn't completed */
        i++;
_L4:
        if(i < 5) goto _L3; else goto _L2
_L2:
        i = 0;
        if(i1 == 0) goto _L6; else goto _L5
_L5:
label0:
        {
            if(i == gh + 1)
            {
                bO.a(byte0, byte1 + i * 20, c1, 20, a.a.g.b(255, 0, 0), 128);
                if(i1 == 0)
                    break label0;
            }
            bO.a(byte0, byte1 + i * 20, c1, 20, a.a.g.b(190, 190, 190), 128);
        }
        bO.b(byte0, byte1 + i * 20, c1, 0);
        bO.b(byte0, byte1 + i * 20 + 20, c1, 0);
        i++;
_L6:
        if(i >= 5)
        {
            bO.b("Select combat style", byte0 + c1 / 2, byte1 + 16, 3, 0xffffff);
            bO.b("Controlled (+1 of each)", byte0 + c1 / 2, byte1 + 36, 3, 0);
            bO.b("Aggressive (+3 strength)", byte0 + c1 / 2, byte1 + 56, 3, 0);
            bO.b("Accurate   (+3 attack)", byte0 + c1 / 2, byte1 + 76, 3, 0);
            bO.b("Defensive  (+3 defense)", byte0 + c1 / 2, byte1 + 96, 3, 0);
            return;
        }
        if(true) goto _L5; else goto _L7
_L7:
    }

    public void bd() //Welcome login message
    {
        char c1;
        int k1;
label0:
        {
            k1 = b.bN;
            if(gt > 0)
            {
                c1 = '\264';
                if(k1 == 0)
                    break label0;
            }
            c1 = 'd';
        }
        int i;
        String s1;
label1:
        {
            i = 167 - c1 / 2;
            bO.b(56, 167 - c1 / 2, 400, c1, 0);
            bO.c(56, 167 - c1 / 2, 400, c1, 0xffffff);
            i += 20;
            bO.b("Welcome to RuneScape " + gY, 256, i, 4, 0xffff00);
            i += 30;
            if(gs <= 0)
            {
                s1 = "earlier today";
                if(k1 == 0)
                    break label1;
            }
            if(gs == 1)
            {
                s1 = "yesterday";
                if(k1 == 0)
                    break label1;
            }
            s1 = gs + " days ago";
        }
label2:
        {
label3:
            {
label4:
                {
                    bO.b("You last logged in " + s1, 256, i, 1, 0xffffff);
                    i += 15;
                    if(gr == null)
                        gr = g(gq);
                    bO.b("from: " + gr, 256, i, 1, 0xffffff);
                    i += 15;
                    i += 15;
                    if(gt <= 0)
                        break label3;
                    if(gt == 14)
                    {
                        s1 = "Earlier today";
                        if(k1 == 0)
                            break label4;
                    }
                    if(gt == 13)
                    {
                        s1 = "Yesterday";
                        if(k1 == 0)
                            break label4;
                    }
                    s1 = (14 - gt) + " days ago";
                }
                bO.b(s1 + " you changed your recovery questions", 256, i, 1, 0xff8000);
                i += 15;
                bO.b("If you do not remember making this change then", 256, i, 1, 0xff8000);
                i += 15;
                bO.b("cancel it and change your password immediately!", 256, i, 1, 0xff8000);
                i += 15;
                i += 15;
                int i1 = 0xffffff;
                if(super.H > i - 12 && super.H <= i && super.G > 106 && super.G < 406)
                    i1 = 0xff0000;
                bO.b("No that wasn't me - Cancel the request!", 256, i, 1, i1);
                if(i1 == 0xff0000 && bz == 1)
                {
                    super.Y.a(196, 651);
                    super.Y.g();
                    gp = false;
                }
                i += 15;
                i1 = 0xffffff;
                if(super.H > i - 12 && super.H <= i && super.G > 106 && super.G < 406)
                    i1 = 0xff0000;
                bO.b("That's ok, activate the new questions in " + gt + " days time.", 256, i, 1, i1);
                if(i1 != 0xff0000 || bz != 1)
                    break label2;
                gp = false;
                if(k1 == 0)
                    break label2;
            }
            int j1 = 0xffffff;
            if(super.H > i - 12 && super.H <= i && super.G > 106 && super.G < 406)
                j1 = 0xff0000;
            bO.b("Click here to close window", 256, i, 1, j1);
            if(bz == 1)
            {
                if(j1 == 0xff0000)
                    gp = false;
                if((super.G < 86 || super.G > 426) && (super.H < 167 - c1 / 2 || super.H > 167 + c1 / 2))
                    gp = false;
            }
        }
        bz = 0;
    }

    public void be()
    {
        char c1 = '\u0190';
        char c2 = 'd';
        if(gv)
        {
            c2 = '\u01C2';
            c2 = '\u012C';
        }
        bO.b(256 - c1 / 2, 167 - c2 / 2, c1, c2, 0);
        bO.c(256 - c1 / 2, 167 - c2 / 2, c1, c2, 0xffffff);
        bO.a(gx, 256, (167 - c2 / 2) + 20, 1, 0xffffff, c1 - 40);
        int i = 157 + c2 / 2;
        int i1 = 0xffffff;
        if(super.H > i - 12 && super.H <= i && super.G > 106 && super.G < 406)
            i1 = 0xff0000;
        bO.b("Click here to close window", 256, i, 1, i1);
        if(bz == 1)
        {
            if(i1 == 0xff0000)
                gw = false;
            if((super.G < 256 - c1 / 2 || super.G > 256 + c1 / 2) && (super.H < 167 - c2 / 2 || super.H > 167 + c2 / 2))
                gw = false;
        }
        bz = 0;
    }

    public void bf() //logging out
    {
        bO.b(126, 137, 260, 60, 0);
        bO.c(126, 137, 260, 60, 0xffffff);
        bO.b("Logging out...", 256, 173, 5, 0xffffff);
    }

    public void bg() //wildness warning
    {
        int i = 97;
        bO.b(86, 77, 340, 180, 0);
        bO.c(86, 77, 340, 180, 0xffffff);
        bO.b("Warning! Proceed with caution", 256, i, 4, 0xff0000);
        i += 26;
        bO.b("If you go much further north you will enter the", 256, i, 1, 0xffffff);
        i += 13;
        bO.b("wilderness. This a very dangerous area where", 256, i, 1, 0xffffff);
        i += 13;
        bO.b("other players can attack you!", 256, i, 1, 0xffffff);
        i += 22;
        bO.b("The further north you go the more dangerous it", 256, i, 1, 0xffffff);
        i += 13;
        bO.b("becomes, but the more treasure you will find.", 256, i, 1, 0xffffff);
        i += 22;
        bO.b("In the wilderness an indicator at the bottom-right", 256, i, 1, 0xffffff);
        i += 13;
        bO.b("of the screen will show the current level of danger", 256, i, 1, 0xffffff);
        i += 22;
        int i1 = 0xffffff;
        if(super.H > i - 12 && super.H <= i && super.G > 181 && super.G < 331)
            i1 = 0xff0000;
        bO.b("Click here to close window", 256, i, 1, i1);
        if(bz != 0)
        {
            if(super.H > i - 12 && super.H <= i && super.G > 181 && super.G < 331)
                gB = 2;
            if(super.G < 86 || super.G > 426 || super.H < 77 || super.H > 257)
                gB = 2;
            bz = 0;
        }
    }

    public void bh()
    {
        int i;
        int j1;
        int i2;
        i2 = b.bN;
        if(bz == 0)
            break MISSING_BLOCK_LABEL_179;
        bz = 0;
        if(super.G < 56 || super.H < 35 || super.G > 456 || super.H > 325)
        {
            gj = 0;
            return;
        }
        i = 140;
        j1 = 0;
        if(i2 == 0) goto _L2; else goto _L1
_L1:
        if(super.G > 66 && super.G < 446 && super.H >= i - 12 && super.H < i + 3)
            gk = j1;
        i += 15;
        j1++;
_L2:
        if(j1 < 9) goto _L1; else goto _L3
_L3:
        i += 45;
        if(super.G > 196 && super.G < 316 && super.H > i - 15 && super.H < i + 5)
        {
            gj = 0;
            return;
        }
        int i1;
        int k1;
label0:
        {
            if(super.O.length() > 0)
            {
                String s1 = super.O.trim();
                super.N = "";
                super.O = "";
                if(s1.length() > 0)
                {
                    long l1 = a.f.b(s1);
                    super.Y.a(51, 277);
                    super.Y.a(l1);
                    super.Y.a(gk);
                    super.Y.g();
                }
                gj = 0;
                return;
            }
            bO.b(56, 35, 400, 290, 0);
            bO.c(56, 35, 400, 290, 0xffffff);
            i1 = 50;
            bO.b("This form sends a snapshot of the last 60 secs of trade/chat", 256, i1, 1, 0xffffff);
            i1 += 15;
            bO.b("to customer support. Please only use this for serious abuse", 256, i1, 1, 0xffffff);
            i1 += 15;
            bO.b("If you misuse this form, you will be banned.", 256, i1, 1, 0xff8000);
            i1 += 15;
            bO.b("Do not report abuse unless you were genuinely offended", 256, i1, 1, 0xff8000);
            i1 += 15;
            i1 += 15;
            bO.b("First indicate the type of abuse", 256, i1, 1, 0xffff00);
            i1 += 15;
            if(gk == 0)
            {
                bO.c(66, i1 - 12, 380, 15, 0xffffff);
                k1 = 0xff8000;
                if(i2 == 0)
                    break label0;
            }
            k1 = 0xffffff;
        }
label1:
        {
            bO.b("Non-vulgar insult such as 'idiot', 'noob', 'loser', etc...", 256, i1, 1, k1);
            i1 += 15;
            if(gk == 1)
            {
                bO.c(66, i1 - 12, 380, 15, 0xffffff);
                k1 = 0xff8000;
                if(i2 == 0)
                    break label1;
            }
            k1 = 0xffffff;
        }
label2:
        {
            bO.b("Swearing, profanity, or racial abuse directed at me personally", 256, i1, 1, k1);
            i1 += 15;
            if(gk == 2)
            {
                bO.c(66, i1 - 12, 380, 15, 0xffffff);
                k1 = 0xff8000;
                if(i2 == 0)
                    break label2;
            }
            k1 = 0xffffff;
        }
label3:
        {
            bO.b("I overheard the player being abusive to someone else", 256, i1, 1, k1);
            i1 += 15;
            if(gk == 3)
            {
                bO.c(66, i1 - 12, 380, 15, 0xffffff);
                k1 = 0xff8000;
                if(i2 == 0)
                    break label3;
            }
            k1 = 0xffffff;
        }
label4:
        {
            bO.b("Trade scam - lied about trade to steal items from me", 256, i1, 1, k1);
            i1 += 15;
            if(gk == 4)
            {
                bO.c(66, i1 - 12, 380, 15, 0xffffff);
                k1 = 0xff8000;
                if(i2 == 0)
                    break label4;
            }
            k1 = 0xffffff;
        }
label5:
        {
            bO.b("Asking players for their password / trying to steal accounts", 256, i1, 1, k1);
            i1 += 15;
            if(gk == 5)
            {
                bO.c(66, i1 - 12, 380, 15, 0xffffff);
                k1 = 0xff8000;
                if(i2 == 0)
                    break label5;
            }
            k1 = 0xffffff;
        }
label6:
        {
            bO.b("Attempting to buy/sell a RuneScape account", 256, i1, 1, k1);
            i1 += 15;
            if(gk == 6)
            {
                bO.c(66, i1 - 12, 380, 15, 0xffffff);
                k1 = 0xff8000;
                if(i2 == 0)
                    break label6;
            }
            k1 = 0xffffff;
        }
label7:
        {
            bO.b("Impersonating Jagex staff", 256, i1, 1, k1);
            i1 += 15;
            if(gk == 7)
            {
                bO.c(66, i1 - 12, 380, 15, 0xffffff);
                k1 = 0xff8000;
                if(i2 == 0)
                    break label7;
            }
            k1 = 0xffffff;
        }
label8:
        {
            bO.b("Advertising scam website", 256, i1, 1, k1);
            i1 += 15;
            if(gk == 8)
            {
                bO.c(66, i1 - 12, 380, 15, 0xffffff);
                k1 = 0xff8000;
                if(i2 == 0)
                    break label8;
            }
            k1 = 0xffffff;
        }
        bO.b("Other", 256, i1, 1, k1);
        i1 += 15;
        i1 += 11;
        bO.b("Then type the name of the offending player, and press enter", 256, i1, 1, 0xffff00);
        i1 += 15;
        bO.b("Name: " + super.N + "*", 256, i1, 4, 0xffffff);
        i1 += 19;
        k1 = 0xffffff;
        if(super.G > 196 && super.G < 316 && super.H > i1 - 15 && super.H < i1 + 5)
            k1 = 0xffff00;
        bO.b("Click here to cancel", 256, i1, 1, k1);
        return;
    }

    public void bi()
    {
        int i;
        String s1;
        int i1;
        int j1;
        j1 = b.bN;
        if(bz != 0)
        {
            bz = 0;
            if(super.G < 106 || super.H < 150 || super.G > 406 || super.H > 210)
            {
                gl = 0;
                return;
            }
        }
        i = 150;
        bO.b(106, i, 300, 60, 0);
        bO.c(106, i, 300, 60, 0xffffff);
        i += 22;
        if(gl != 6)
            break MISSING_BLOCK_LABEL_224;
        bO.b("Please enter your current password", 256, i, 4, 0xffffff);
        i += 25;
        s1 = "*";
        i1 = 0;
        if(j1 == 0) goto _L2; else goto _L1
_L1:
        s1 = "X" + s1;
        i1++;
_L2:
        if(i1 < super.N.length()) goto _L1; else goto _L3
_L3:
        bO.b(s1, 256, i, 4, 0xffffff);
        if(super.O.length() > 0)
        {
            gm = super.O;
            super.N = "";
            super.O = "";
            gl = 1;
            return;
        }
        break MISSING_BLOCK_LABEL_703;
        if(gl != 1)
            break MISSING_BLOCK_LABEL_387;
        bO.b("Please enter your new password", 256, i, 4, 0xffffff);
        i += 25;
        s1 = "*";
        i1 = 0;
        if(j1 == 0) goto _L5; else goto _L4
_L4:
        s1 = "X" + s1;
        i1++;
_L5:
        if(i1 < super.N.length()) goto _L4; else goto _L6
_L6:
        bO.b(s1, 256, i, 4, 0xffffff);
        if(super.O.length() > 0)
        {
            gn = super.O;
            super.N = "";
            super.O = "";
            gl = 2;
            if(gn.length() < 5)
                gl = 5;
            if(gn.trim().equalsIgnoreCase(gY.trim()))
            {
                gl = 7;
                return;
            }
        }
        break MISSING_BLOCK_LABEL_703;
        if(gl != 2)
            break MISSING_BLOCK_LABEL_519;
        bO.b("Enter password again to confirm", 256, i, 4, 0xffffff);
        i += 25;
        s1 = "*";
        i1 = 0;
        if(j1 == 0) goto _L8; else goto _L7
_L7:
        s1 = "X" + s1;
        i1++;
_L8:
        if(i1 < super.N.length()) goto _L7; else goto _L9
_L9:
        bO.b(s1, 256, i, 4, 0xffffff);
        if(super.O.length() > 0)
            if(super.O.equalsIgnoreCase(gn))
            {
                gl = 4;
                c(gm, gn);
                return;
            } else
            {
                gl = 3;
                return;
            }
        break MISSING_BLOCK_LABEL_703;
        if(gl == 3)
        {
            bO.b("Passwords do not match!", 256, i, 4, 0xffffff);
            i += 25;
            bO.b("Press any key to close", 256, i, 4, 0xffffff);
            return;
        }
        if(gl == 4)
        {
            bO.b("Ok, your request has been sent", 256, i, 4, 0xffffff);
            i += 25;
            bO.b("Press any key to close", 256, i, 4, 0xffffff);
            return;
        }
        if(gl == 5)
        {
            bO.b("Password must be at", 256, i, 4, 0xffffff);
            i += 25;
            bO.b("least 5 letters long", 256, i, 4, 0xffffff);
            return;
        }
        if(gl == 7)
        {
            bO.b("Your password must not be", 256, i, 4, 0xffffff);
            i += 25;
            bO.b("the same as your username", 256, i, 4, 0xffffff);
        }
    }

    public void bj()
    {
        if(bz != 0)
        {
            bz = 0;
            if(gi == 1 && (super.G < 106 || super.H < 145 || super.G > 406 || super.H > 215))
            {
                gi = 0;
                return;
            }
            if(gi == 2 && (super.G < 6 || super.H < 145 || super.G > 506 || super.H > 215))
            {
                gi = 0;
                return;
            }
            if(gi == 3 && (super.G < 106 || super.H < 145 || super.G > 406 || super.H > 215))
            {
                gi = 0;
                return;
            }
            if(super.G > 236 && super.G < 276 && super.H > 193 && super.H < 213)
            {
                gi = 0;
                return;
            }
        }
        int i = 145;
        if(gi == 1)
        {
            bO.b(106, i, 300, 70, 0);
            bO.c(106, i, 300, 70, 0xffffff);
            i += 20;
            bO.b("Enter name to add to friends list", 256, i, 4, 0xffffff);
            i += 20;
            bO.b(super.N + "*", 256, i, 4, 0xffffff);
            if(super.O.length() > 0)
            {
                String s1 = super.O.trim();
                super.N = "";
                super.O = "";
                gi = 0;
                if(s1.length() > 0 && a.f.b(s1) != cN.a)
                    b(s1);
            }
        }
        if(gi == 2)
        {
            bO.b(6, i, 500, 70, 0);
            bO.c(6, i, 500, 70, 0xffffff);
            i += 20;
            bO.b("Enter message to send to " + a.f.a(ea), 256, i, 4, 0xffffff);
            i += 20;
            bO.b(super.P + "*", 256, i, 4, 0xffffff);
            if(super.Q.length() > 0)
            {
                String s2 = super.Q;
                super.P = "";
                super.Q = "";
                gi = 0;
                int j1 = h.a(s2);
                a(ea, h.a, j1);
                s2 = h.a(h.a, 0, j1);
                s2 = a.g.a(s2);
                d("@pri@You tell " + a.f.a(ea) + ": " + s2);
            }
        }
        if(gi == 3)
        {
            bO.b(106, i, 300, 70, 0);
            bO.c(106, i, 300, 70, 0xffffff);
            i += 20;
            bO.b("Enter name to add to ignore list", 256, i, 4, 0xffffff);
            i += 20;
            bO.b(super.N + "*", 256, i, 4, 0xffffff);
            if(super.O.length() > 0)
            {
                String s3 = super.O.trim();
                super.N = "";
                super.O = "";
                gi = 0;
                if(s3.length() > 0 && a.f.b(s3) != cN.a)
                    a(s3);
            }
        }
        int i1 = 0xffffff;
        if(super.G > 236 && super.G < 276 && super.H > 193 && super.H < 213)
            i1 = 0xffff00;
        bO.b("Cancel", 256, 208, 1, i1);
    }

    public void bk()
    {
        char c1;
        char c2;
        int i;
        int i1;
        int j1;
        int i2;
        int k9;
        k9 = b.bN;
        c1 = '\u0198';
        c2 = '\u014E';
        if(gd > 0 && fX <= 48)
            gd = 0;
        if(gd > 1 && fX <= 96)
            gd = 1;
        if(gd > 2 && fX <= 144)
            gd = 2;
        if(ga >= fX || ga < 0)
            ga = -1;
        if(ga != -1 && fY[ga] != gb)
        {
            ga = -1;
            gb = -2;
        }
        if(bz == 0)
            break MISSING_BLOCK_LABEL_1771;
        bz = 0;
        i = super.G - (256 - c1 / 2);
        i1 = super.H - (170 - c2 / 2);
        if(i < 0 || i1 < 12 || i >= 408 || i1 >= 280)
            break MISSING_BLOCK_LABEL_1587;
        j1 = gd * 48;
        i2 = 0;
        if(k9 == 0) goto _L2; else goto _L1
_L1:
        int k2 = 0;
        if(k9 == 0) goto _L4; else goto _L3
_L3:
        int i7 = 7 + k2 * 49;
        int k7 = 28 + i2 * 34;
        if(i > i7 && i < i7 + 49 && i1 > k7 && i1 < k7 + 34 && j1 < fX && fY[j1] != -1)
        {
            gb = fY[j1];
            ga = j1;
        }
        j1++;
        k2++;
_L4:
        if(k2 < 8) goto _L3; else goto _L5
_L5:
        i2++;
_L2:
        if(i2 < 6) goto _L1; else goto _L6
_L6:
        int l2;
label0:
        {
            i = 256 - c1 / 2;
            i1 = 170 - c2 / 2;
            if(ga < 0)
            {
                l2 = -1;
                if(k9 == 0)
                    break label0;
            }
            l2 = fY[ga];
        }
        if(l2 == -1)
            break MISSING_BLOCK_LABEL_1771;
        int k1 = fZ[ga];
        if(b.h[l2] == 1 && k1 > 1)
            k1 = 1;
        if(k1 >= 1 && super.G >= i + 220 && super.H >= i1 + 238 && super.G < i + 250 && super.H <= i1 + 249) //deposit one of the selected item
        {
            super.Y.a(206, 655);
            super.Y.b(l2);
            super.Y.b(1); 
            super.Y.g();
        }
        if(k1 >= 5 && super.G >= i + 250 && super.H >= i1 + 238 && super.G < i + 280 && super.H <= i1 + 249)
        {
            super.Y.a(206, 655);
            super.Y.b(l2);
            super.Y.b(5);
            super.Y.g();
        }
        if(k1 >= 25 && super.G >= i + 280 && super.H >= i1 + 238 && super.G < i + 305 && super.H <= i1 + 249)
        {
            super.Y.a(206, 655);
            super.Y.b(l2);
            super.Y.b(25);
            super.Y.g();
        }
        if(k1 >= 100 && super.G >= i + 305 && super.H >= i1 + 238 && super.G < i + 335 && super.H <= i1 + 249)
        {
            super.Y.a(206, 655);
            super.Y.b(l2);
            super.Y.b(100);
            super.Y.g();
        }
        if(k1 >= 500 && super.G >= i + 335 && super.H >= i1 + 238 && super.G < i + 368 && super.H <= i1 + 249)
        {
            super.Y.a(206, 655);
            super.Y.b(l2);
            super.Y.b(500);
            super.Y.g();
        }
        if(k1 >= 2500 && super.G >= i + 370 && super.H >= i1 + 238 && super.G < i + 400 && super.H <= i1 + 249)
        {
            super.Y.a(206, 655);
            super.Y.b(l2);
            super.Y.b(2500);
            super.Y.g();
        }
        if(d(l2) >= 1 && super.G >= i + 220 && super.H >= i1 + 263 && super.G < i + 250 && super.H <= i1 + 274)
        {
            super.Y.a(205, 523);
            super.Y.b(l2);
            super.Y.b(1);
            super.Y.g();
        }
        if(d(l2) >= 5 && super.G >= i + 250 && super.H >= i1 + 263 && super.G < i + 280 && super.H <= i1 + 274)
        {
            super.Y.a(205, 523);
            super.Y.b(l2);
            super.Y.b(5);
            super.Y.g();
        }
        if(d(l2) >= 25 && super.G >= i + 280 && super.H >= i1 + 263 && super.G < i + 305 && super.H <= i1 + 274)
        {
            super.Y.a(205, 523);
            super.Y.b(l2);
            super.Y.b(25);
            super.Y.g();
        }
        if(d(l2) >= 100 && super.G >= i + 305 && super.H >= i1 + 263 && super.G < i + 335 && super.H <= i1 + 274)
        {
            super.Y.a(205, 523);
            super.Y.b(l2);
            super.Y.b(100);
            super.Y.g();
        }
        if(d(l2) >= 500 && super.G >= i + 335 && super.H >= i1 + 263 && super.G < i + 368 && super.H <= i1 + 274)
        {
            super.Y.a(205, 523);
            super.Y.b(l2);
            super.Y.b(500);
            super.Y.g();
        }
        if(d(l2) < 2500 || super.G < i + 370 || super.H < i1 + 263 || super.G >= i + 400 || super.H > i1 + 274)
            break MISSING_BLOCK_LABEL_1771;
        super.Y.a(205, 523);
        super.Y.b(l2);
        super.Y.b(2500);
        super.Y.g();
        if(k9 == 0)
            break MISSING_BLOCK_LABEL_1771;
        if(fX > 48 && i >= 50 && i <= 115 && i1 <= 12)
        {
            gd = 0;
            if(k9 == 0)
                break MISSING_BLOCK_LABEL_1771;
        }
        if(fX > 48 && i >= 115 && i <= 180 && i1 <= 12)
        {
            gd = 1;
            if(k9 == 0)
                break MISSING_BLOCK_LABEL_1771;
        }
        if(fX > 96 && i >= 180 && i <= 245 && i1 <= 12)
        {
            gd = 2;
            if(k9 == 0)
                break MISSING_BLOCK_LABEL_1771;
        }
        if(fX > 144 && i >= 245 && i <= 310 && i1 <= 12)
        {
            gd = 3;
            if(k9 == 0)
                break MISSING_BLOCK_LABEL_1771;
        }
        super.Y.a(207, 886);
        super.Y.g();
        fT = false;
        return;
        int j7;
        int l7;
        int j8;
        int j2;
label1:
        {
            int i3;
label2:
            {
                i = 256 - c1 / 2;
                i1 = 170 - c2 / 2;
                bO.b(i, i1, 408, 12, 192);
                int l1 = 0x989898;
                bO.a(i, i1 + 12, 408, 17, l1, 160);
                bO.a(i, i1 + 29, 8, 204, l1, 160);
                bO.a(i + 399, i1 + 29, 9, 204, l1, 160);
                bO.a(i, i1 + 233, 408, 47, l1, 160);
                bO.c("Bank", i + 1, i1 + 10, 1, 0xffffff);
                j2 = 50;
                if(fX <= 48)
                    break label1;
                i3 = 0xffffff;
                if(gd == 0)
                {
                    i3 = 0xff0000;
                    if(k9 == 0)
                        break label2;
                }
                if(super.G > i + j2 && super.H >= i1 && super.G < i + j2 + 65 && super.H < i1 + 12)
                    i3 = 0xffff00;
            }
label3:
            {
                bO.c("<page 1>", i + j2, i1 + 10, 1, i3);
                j2 += 65;
                i3 = 0xffffff;
                if(gd == 1)
                {
                    i3 = 0xff0000;
                    if(k9 == 0)
                        break label3;
                }
                if(super.G > i + j2 && super.H >= i1 && super.G < i + j2 + 65 && super.H < i1 + 12)
                    i3 = 0xffff00;
            }
            bO.c("<page 2>", i + j2, i1 + 10, 1, i3);
            j2 += 65;
        }
label4:
        {
            int j3;
label5:
            {
                if(fX <= 96)
                    break label4;
                j3 = 0xffffff;
                if(gd == 2)
                {
                    j3 = 0xff0000;
                    if(k9 == 0)
                        break label5;
                }
                if(super.G > i + j2 && super.H >= i1 && super.G < i + j2 + 65 && super.H < i1 + 12)
                    j3 = 0xffff00;
            }
            bO.c("<page 3>", i + j2, i1 + 10, 1, j3);
            j2 += 65;
        }
label6:
        {
            int k3;
label7:
            {
                if(fX <= 144)
                    break label6;
                k3 = 0xffffff;
                if(gd == 3)
                {
                    k3 = 0xff0000;
                    if(k9 == 0)
                        break label7;
                }
                if(super.G > i + j2 && super.H >= i1 && super.G < i + j2 + 65 && super.H < i1 + 12)
                    k3 = 0xffff00;
            }
            bO.c("<page 4>", i + j2, i1 + 10, 1, k3);
            j2 += 65;
        }
        int l3 = 0xffffff;
        if(super.G > i + 320 && super.H >= i1 && super.G < i + 408 && super.H < i1 + 12)
            l3 = 0xff0000;
        bO.a("Close window", i + 406, i1 + 10, 1, l3);
        bO.c("Number in bank in green", i + 7, i1 + 24, 1, 65280);
        bO.c("Number held in blue", i + 289, i1 + 24, 1, 65535);
        j7 = 0xd0d0d0;
        l7 = gd * 48;
        j8 = 0;
        if(k9 == 0) goto _L8; else goto _L7
_L7:
        int k8 = 0;
        if(k9 == 0) goto _L10; else goto _L9
_L9:
        int i9;
        int j9;
label8:
        {
            i9 = i + 7 + k8 * 49;
            j9 = i1 + 28 + j8 * 34;
            if(ga == l7)
            {
                bO.a(i9, j9, 49, 34, 0xff0000, 160);
                if(k9 == 0)
                    break label8;
            }
            bO.a(i9, j9, 49, 34, j7, 160);
        }
        bO.c(i9, j9, 50, 35, 0);
        if(l7 < fX && fY[l7] != -1)
        {
            bO.a(i9, j9, 48, 32, bW + b.f[fY[l7]], b.k[fY[l7]], 0, 0, false);
            bO.c(String.valueOf(fZ[l7]), i9 + 1, j9 + 10, 1, 65280);
            bO.a(String.valueOf(d(fY[l7])), i9 + 47, j9 + 29, 1, 65535);
        }
        l7++;
        k8++;
_L10:
        if(k8 < 8) goto _L9; else goto _L11
_L11:
        j8++;
_L8:
        if(j8 >= 6)
        {
            int l8;
label9:
            {
                bO.b(i + 5, i1 + 256, 398, 0);
                if(ga == -1)
                {
                    bO.b("Select an object to withdraw or deposit", i + 204, i1 + 248, 3, 0xffff00);
                    return;
                }
                if(ga < 0)
                {
                    l8 = -1;
                    if(k9 == 0)
                        break label9;
                }
                l8 = fY[ga];
            }
            if(l8 != -1)
            {
                int i8 = fZ[ga];
                if(b.h[l8] == 1 && i8 > 1)
                    i8 = 1;
                if(i8 > 0)
                {
                    bO.c("Withdraw " + b.c[l8], i + 2, i1 + 248, 1, 0xffffff);
                    //set the color to black
                    int i4 = 0xffffff;
                    //if the mouse is over the word set the color to red
                    if(super.G >= i + 220 && super.H >= i1 + 238 && super.G < i + 250 && super.H <= i1 + 249)
                        i4 = 0xff0000;
                    bO.c("One", i + 222, i1 + 248, 1, i4);
                    if(i8 >= 5)
                    {
                        int j4 = 0xffffff;
                        if(super.G >= i + 250 && super.H >= i1 + 238 && super.G < i + 280 && super.H <= i1 + 249)
                            j4 = 0xff0000;
                        bO.c("Five", i + 252, i1 + 248, 1, j4);
                    }
                    if(i8 >= 25)
                    {
                        int k4 = 0xffffff;
                        if(super.G >= i + 280 && super.H >= i1 + 238 && super.G < i + 305 && super.H <= i1 + 249)
                            k4 = 0xff0000;
                        bO.c("25", i + 282, i1 + 248, 1, k4);
                    }
                    if(i8 >= 100)
                    {
                        int l4 = 0xffffff;
                        if(super.G >= i + 305 && super.H >= i1 + 238 && super.G < i + 335 && super.H <= i1 + 249)
                            l4 = 0xff0000;
                        bO.c("100", i + 307, i1 + 248, 1, l4);
                    }
                    if(i8 >= 500)
                    {
                        int i5 = 0xffffff;
                        if(super.G >= i + 335 && super.H >= i1 + 238 && super.G < i + 368 && super.H <= i1 + 249)
                            i5 = 0xff0000;
                        bO.c("500", i + 337, i1 + 248, 1, i5);
                    }
                    if(i8 >= 2500)
                    {
                        int j5 = 0xffffff;
                        if(super.G >= i + 370 && super.H >= i1 + 238 && super.G < i + 400 && super.H <= i1 + 249)
                            j5 = 0xff0000;
                        bO.c("2500", i + 370, i1 + 248, 1, j5);
                    }
                }
                if(d(l8) > 0)
                {
                    bO.c("Deposit " + b.c[l8], i + 2, i1 + 273, 1, 0xffffff);
                    int k5 = 0xffffff;
                    if(super.G >= i + 220 && super.H >= i1 + 263 && super.G < i + 250 && super.H <= i1 + 274)
                        k5 = 0xff0000;
                    bO.c("One", i + 222, i1 + 273, 1, k5);
                    if(d(l8) >= 5)
                    {
                        int l5 = 0xffffff;
                        if(super.G >= i + 250 && super.H >= i1 + 263 && super.G < i + 280 && super.H <= i1 + 274)
                            l5 = 0xff0000;
                        bO.c("Five", i + 252, i1 + 273, 1, l5);
                    }
                    if(d(l8) >= 25)
                    {
                        int i6 = 0xffffff;
                        if(super.G >= i + 280 && super.H >= i1 + 263 && super.G < i + 305 && super.H <= i1 + 274)
                            i6 = 0xff0000;
                        bO.c("25", i + 282, i1 + 273, 1, i6);
                    }
                    if(d(l8) >= 100)
                    {
                        int j6 = 0xffffff;
                        if(super.G >= i + 305 && super.H >= i1 + 263 && super.G < i + 335 && super.H <= i1 + 274)
                            j6 = 0xff0000;
                        bO.c("100", i + 307, i1 + 273, 1, j6);
                    }
                    if(d(l8) >= 500)
                    {
                        int k6 = 0xffffff;
                        if(super.G >= i + 335 && super.H >= i1 + 263 && super.G < i + 368 && super.H <= i1 + 274)
                            k6 = 0xff0000;
                        bO.c("500", i + 337, i1 + 273, 1, k6);
                    }
                    if(d(l8) >= 2500)
                    {
                        int l6 = 0xffffff;
                        if(super.G >= i + 370 && super.H >= i1 + 263 && super.G < i + 400 && super.H <= i1 + 274)
                            l6 = 0xff0000;
                        bO.c("2500", i + 370, i1 + 273, 1, l6);
                    }
                }
            }
            return;
        }
        if(true) goto _L7; else goto _L12
_L12:
    }

    public void bl()
    {
        int i;
        int i1;
        int j1;
        int l1;
        int i7;
        i7 = b.bN;
        if(bz == 0)
            break MISSING_BLOCK_LABEL_473;
        bz = 0;
        i = super.G - 52;
        i1 = super.H - 44;
        if(i < 0 || i1 < 12 || i >= 408 || i1 >= 246)
            break MISSING_BLOCK_LABEL_447;
        j1 = 0;
        l1 = 0;
        if(i7 == 0) goto _L2; else goto _L1
_L1:
        int l2 = 0;
        if(i7 == 0) goto _L4; else goto _L3
_L3:
        int i3 = 7 + l2 * 49;
        int i4 = 28 + l1 * 34;
        if(i > i3 && i < i3 + 49 && i1 > i4 && i1 < i4 + 34 && fO[j1] != -1)
        {
            fR = j1;
            fS = fO[j1];
        }
        j1++;
        l2++;
_L4:
        if(l2 < 8) goto _L3; else goto _L5
_L5:
        l1++;
_L2:
        if(l1 < 5) goto _L1; else goto _L6
_L6:
        if(fR < 0)
            break MISSING_BLOCK_LABEL_473;
        l2 = fO[fR];
        if(l2 == -1)
            break MISSING_BLOCK_LABEL_473;
        if(fP[fR] > 0 && i > 298 && i1 >= 204 && i < 408 && i1 <= 215)
        {
            int j3 = fN + fQ[fR];
            if(j3 < 10)
                j3 = 10;
            int j4 = (j3 * b.g[l2]) / 100;
            super.Y.a(217, 666);
            super.Y.b(fO[fR]);
            super.Y.c(j4);
            super.Y.g();
        }
        if(d(l2) <= 0 || i <= 2 || i1 < 229 || i >= 112 || i1 > 240)
            break MISSING_BLOCK_LABEL_473;
        int k3 = fM + fQ[fR];
        if(k3 < 10)
            k3 = 10;
        int k4 = (k3 * b.g[l2]) / 100;
        super.Y.a(216, 665);
        super.Y.b(fO[fR]);
        super.Y.c(k4);
        super.Y.g();
        if(i7 == 0)
            break MISSING_BLOCK_LABEL_473;
        super.Y.a(218, 312);
        super.Y.g();
        fL = false;
        return;
        int l3;
        int l4;
        i = 52;
        i1 = 44;
        bO.b(i, i1, 408, 12, 192);
        int k1 = 0x989898;
        bO.a(i, i1 + 12, 408, 17, k1, 160);
        bO.a(i, i1 + 29, 8, 170, k1, 160);
        bO.a(i + 399, i1 + 29, 9, 170, k1, 160);
        bO.a(i, i1 + 199, 408, 47, k1, 160);
        bO.c("Buying and selling items", i + 1, i1 + 10, 1, 0xffffff);
        int i2 = 0xffffff;
        if(super.G > i + 320 && super.H >= i1 && super.G < i + 408 && super.H < i1 + 12)
            i2 = 0xff0000;
        bO.a("Close window", i + 406, i1 + 10, 1, i2);
        bO.c("Shops stock in green", i + 2, i1 + 24, 1, 65280);
        bO.c("Number you own in blue", i + 135, i1 + 24, 1, 65535);
        bO.c("Your money: " + d(10) + "gp", i + 280, i1 + 24, 1, 0xffff00);
        l2 = 0xd0d0d0;
        l3 = 0;
        l4 = 0;
        if(i7 == 0) goto _L8; else goto _L7
_L7:
        int i5 = 0;
        if(i7 == 0) goto _L10; else goto _L9
_L9:
        int k5;
        int j6;
label0:
        {
            k5 = i + 7 + i5 * 49;
            j6 = i1 + 28 + l4 * 34;
            if(fR == l3)
            {
                bO.a(k5, j6, 49, 34, 0xff0000, 160);
                if(i7 == 0)
                    break label0;
            }
            bO.a(k5, j6, 49, 34, l2, 160);
        }
        bO.c(k5, j6, 50, 35, 0);
        if(fO[l3] != -1)
        {
            bO.a(k5, j6, 48, 32, bW + b.f[fO[l3]], b.k[fO[l3]], 0, 0, false);
            bO.c(String.valueOf(fP[l3]), k5 + 1, j6 + 10, 1, 65280);
            bO.a(String.valueOf(d(fO[l3])), k5 + 47, j6 + 10, 1, 65535);
        }
        l3++;
        i5++;
_L10:
        if(i5 < 8) goto _L9; else goto _L11
_L11:
        l4++;
_L8:
        if(l4 >= 5)
        {
label1:
            {
                int j5;
label2:
                {
                    bO.b(i + 5, i1 + 222, 398, 0);
                    if(fR == -1)
                    {
                        bO.b("Select an object to buy or sell", i + 204, i1 + 214, 3, 0xffff00);
                        return;
                    }
                    j5 = fO[fR];
                    if(j5 == -1)
                        break label1;
                    if(fP[fR] > 0)
                    {
                        int l5 = fN + fQ[fR];
                        if(l5 < 10)
                            l5 = 10;
                        int k6 = (l5 * b.g[j5]) / 100;
                        bO.c("Buy a new " + b.c[j5] + " for " + k6 + "gp", i + 2, i1 + 214, 1, 0xffff00);
                        int j2 = 0xffffff;
                        if(super.G > i + 298 && super.H >= i1 + 204 && super.G < i + 408 && super.H <= i1 + 215)
                            j2 = 0xff0000;
                        bO.a("Click here to buy", i + 405, i1 + 214, 3, j2);
                        if(i7 == 0)
                            break label2;
                    }
                    bO.b("This item is not currently available to buy", i + 204, i1 + 214, 3, 0xffff00);
                }
                if(d(j5) > 0)
                {
                    int i6 = fM + fQ[fR];
                    if(i6 < 10)
                        i6 = 10;
                    int l6 = (i6 * b.g[j5]) / 100;
                    bO.a("Sell your " + b.c[j5] + " for " + l6 + "gp", i + 405, i1 + 239, 1, 0xffff00);
                    int k2 = 0xffffff;
                    if(super.G > i + 2 && super.H >= i1 + 229 && super.G < i + 112 && super.H <= i1 + 240)
                        k2 = 0xff0000;
                    bO.c("Click here to sell", i + 2, i1 + 239, 3, k2);
                    return;
                }
                bO.b("You do not have any of this item to sell", i + 204, i1 + 239, 3, 0xffff00);
            }
            return;
        }
        if(true) goto _L7; else goto _L12
_L12:
    }

    public void bm() //trade
    {
        byte byte0;
        byte byte1;
        int i1;
        int k1;
        k1 = b.bN;
        byte0 = 22;
        byte1 = 36;
        bO.b(byte0, byte1, 468, 16, 192);
        int i = 0x989898;
        bO.a(byte0, byte1 + 16, 468, 246, i, 160);
        bO.b("Please confirm your trade with @yel@" + a.f.a(fC), byte0 + 234, byte1 + 12, 1, 0xffffff);
        bO.b("You are about to give:", byte0 + 117, byte1 + 30, 1, 0xffff00);
        i1 = 0;
        if(k1 == 0) goto _L2; else goto _L1
_L1:
        String s1 = b.c[fG[i1]];
        if(b.h[fG[i1]] == 0)
            s1 = s1 + " (" + fH[i1] + ")";
        bO.b(s1, byte0 + 117, byte1 + 42 + i1 * 12, 1, 0xffffff);
        i1++;
_L2:
        if(i1 < fF) goto _L1; else goto _L3
_L3:
        int j1;
        if(fF == 0)
            bO.b("Nothing!", byte0 + 117, byte1 + 42, 1, 0xffffff);
        bO.b("In return you will receive:", byte0 + 351, byte1 + 30, 1, 0xffff00);
        j1 = 0;
        if(k1 == 0) goto _L5; else goto _L4
_L4:
        String s2 = b.c[fJ[j1]];
        if(b.h[fJ[j1]] == 0)
            s2 = s2 + " (" + fK[j1] + ")";
        bO.b(s2, byte0 + 351, byte1 + 42 + j1 * 12, 1, 0xffffff);
        j1++;
_L5:
        if(j1 >= fI)
        {
label0:
            {
                if(fI == 0)
                    bO.b("Nothing!", byte0 + 351, byte1 + 42, 1, 0xffffff);
                bO.b("Are you sure you want to do this?", byte0 + 234, byte1 + 200, 4, 65535);
                bO.b("There is NO WAY to reverse a trade if you change your mind.", byte0 + 234, byte1 + 215, 1, 0xffffff);
                bO.b("Remember that not all players are trustworthy", byte0 + 234, byte1 + 230, 1, 0xffffff);
                if(!fE)
                {
                    bO.c((byte0 + 118) - 35, byte1 + 238, bU + 25);
                    bO.c((byte0 + 352) - 35, byte1 + 238, bU + 26);
                    if(k1 == 0)
                        break label0;
                }
                bO.b("Waiting for other player...", byte0 + 234, byte1 + 250, 1, 0xffff00);
            }
            if(bz == 1)
            {
                if(super.G < byte0 || super.H < byte1 || super.G > byte0 + 468 || super.H > byte1 + 262)
                {
                    fD = false;
                    super.Y.a(233, 235);
                    super.Y.g();
                }
                if(super.G >= (byte0 + 118) - 35 && super.G <= byte0 + 118 + 70 && super.H >= byte1 + 238 && super.H <= byte1 + 238 + 21)
                {
                    fE = true;
                    super.Y.a(202, 96);
                    super.Y.g();
                }
                if(super.G >= (byte0 + 352) - 35 && super.G <= byte0 + 353 + 70 && super.H >= byte1 + 238 && super.H <= byte1 + 238 + 21)
                {
                    fD = false;
                    super.Y.a(233, 235);
                    super.Y.g();
                }
                bz = 0;
            }
            return;
        }
        if(true) goto _L4; else goto _L6
_L6:
    }

    public void bn()
    {
        int i;
        int i1;
        int j1;
        boolean flag;
        int j2;
        int k2;
        int l2;
        int k5;
        k5 = b.bN;
        if(bz != 0 && fB == 0)
            fB = 1;
        if(fB <= 0)
            break MISSING_BLOCK_LABEL_849;
        i = super.G - 22;
        i1 = super.H - 36;
        if(i < 0 || i1 < 0 || i >= 468 || i1 >= 262)
            break MISSING_BLOCK_LABEL_807;
        if(i <= 216 || i1 <= 30 || i >= 462 || i1 >= 235)
            break MISSING_BLOCK_LABEL_417;
        j1 = (i - 217) / 49 + ((i1 - 31) / 34) * 5;
        if(j1 < 0 || j1 >= dz)
            break MISSING_BLOCK_LABEL_417;
        flag = false;
        j2 = 0;
        k2 = dA[j1];
        l2 = 0;
        if(k5 == 0) goto _L2; else goto _L1
_L1:
        int i3;
        if(ft[l2] != k2)
            continue; /* Loop/switch isn't completed */
        if(b.h[k2] != 0)
            break MISSING_BLOCK_LABEL_225;
        i3 = 0;
        if(k5 == 0) goto _L4; else goto _L3
_L3:
        if(fu[l2] < dB[j1])
            fu[l2]++;
        flag = true;
        i3++;
_L4:
        if(i3 < fB) goto _L3; else goto _L5
_L5:
        if(k5 == 0)
            continue; /* Loop/switch isn't completed */
        j2++;
        l2++;
_L2:
        if(l2 < fs) goto _L1; else goto _L6
_L6:
        if(d(k2) <= j2)
            flag = true;
        if(b.l[k2] == 1)
        {
            b("This object cannot be traded with other players", 3);
            flag = true;
        }
        if(!flag && fs < 12)
        {
            ft[fs] = k2;
            fu[fs] = 1;
            fs++;
            flag = true;
        }
        if(!flag)
            break MISSING_BLOCK_LABEL_417;
        super.Y.a(234, 500);
        super.Y.a(fs);
        i3 = 0;
        if(k5 == 0) goto _L8; else goto _L7
_L7:
        super.Y.b(ft[i3]);
        super.Y.c(fu[i3]);
        i3++;
_L8:
        if(i3 < fs) goto _L7; else goto _L9
_L9:
        super.Y.g();
        fy = false;
        fz = false;
        int l1;
        if(i <= 8 || i1 <= 30 || i >= 205 || i1 >= 133)
            break MISSING_BLOCK_LABEL_696;
        j1 = (i - 9) / 49 + ((i1 - 31) / 34) * 4;
        if(j1 < 0 || j1 >= fs)
            break MISSING_BLOCK_LABEL_696;
        l1 = ft[j1];
        j2 = 0;
        if(k5 == 0) goto _L11; else goto _L10
_L10:
        if(b.h[l1] == 0 && fu[j1] > 1)
        {
            fu[j1]--;
            if(k5 == 0)
                continue; /* Loop/switch isn't completed */
        }
        fs--;
        fA = 0;
        k2 = j1;
        if(k5 == 0) goto _L13; else goto _L12
_L12:
        ft[k2] = ft[k2 + 1];
        fu[k2] = fu[k2 + 1];
        k2++;
_L13:
        if(k2 < fs) goto _L12; else goto _L14
_L14:
        if(k5 == 0)
            break; /* Loop/switch isn't completed */
        j2++;
_L11:
        if(j2 < fB) goto _L10; else goto _L15
_L15:
        super.Y.a(234, 500);
        super.Y.a(fs);
        k2 = 0;
        if(k5 == 0) goto _L17; else goto _L16
_L16:
        super.Y.b(ft[k2]);
        super.Y.c(fu[k2]);
        k2++;
_L17:
        if(k2 < fs) goto _L16; else goto _L18
_L18:
        super.Y.g();
        fy = false;
        fz = false;
        if(i >= 217 && i1 >= 238 && i <= 286 && i1 <= 259)
        {
            fz = true;
            super.Y.a(232, 277);
            super.Y.g();
        }
        if(i < 394 || i1 < 238 || i >= 463 || i1 >= 259)
            break MISSING_BLOCK_LABEL_839;
        fq = false;
        super.Y.a(233, 235);
        super.Y.g();
        if(k5 == 0)
            break MISSING_BLOCK_LABEL_839;
        if(bz != 0)
        {
            fq = false;
            super.Y.a(233, 235);
            super.Y.g();
        }
        bz = 0;
        fB = 0;
        if(!fq)
            return;
        i = 22;
        i1 = 36;
        bO.b(i, i1, 468, 12, 192);
        int k1 = 0x989898;
        bO.a(i, i1 + 12, 468, 18, k1, 160);
        bO.a(i, i1 + 30, 8, 248, k1, 160);
        bO.a(i + 205, i1 + 30, 11, 248, k1, 160);
        bO.a(i + 462, i1 + 30, 6, 248, k1, 160);
        bO.a(i + 8, i1 + 133, 197, 22, k1, 160);
        bO.a(i + 8, i1 + 258, 197, 20, k1, 160);
        bO.a(i + 216, i1 + 235, 246, 43, k1, 160);
        int i2 = 0xd0d0d0;
        bO.a(i + 8, i1 + 30, 197, 103, i2, 160);
        bO.a(i + 8, i1 + 155, 197, 103, i2, 160);
        bO.a(i + 216, i1 + 30, 246, 205, i2, 160);
        j2 = 0;
        if(k5 == 0) goto _L20; else goto _L19
_L19:
        bO.b(i + 8, i1 + 30 + j2 * 34, 197, 0);
        j2++;
_L20:
        if(j2 < 4) goto _L19; else goto _L21
_L21:
        k2 = 0;
        if(k5 == 0) goto _L23; else goto _L22
_L22:
        bO.b(i + 8, i1 + 155 + k2 * 34, 197, 0);
        k2++;
_L23:
        if(k2 < 4) goto _L22; else goto _L24
_L24:
        l2 = 0;
        if(k5 == 0) goto _L26; else goto _L25
_L25:
        bO.b(i + 216, i1 + 30 + l2 * 34, 246, 0);
        l2++;
_L26:
        if(l2 < 7) goto _L25; else goto _L27
_L27:
        i3 = 0;
        if(k5 == 0) goto _L29; else goto _L28
_L28:
        if(i3 < 5)
            bO.c(i + 8 + i3 * 49, i1 + 30, 103, 0);
        if(i3 < 5)
            bO.c(i + 8 + i3 * 49, i1 + 155, 103, 0);
        bO.c(i + 216 + i3 * 49, i1 + 30, 205, 0);
        i3++;
_L29:
        if(i3 < 6) goto _L28; else goto _L30
_L30:
        int j3;
        bO.c("Trading with: " + fr, i + 1, i1 + 10, 1, 0xffffff);
        bO.c("Your Offer", i + 9, i1 + 27, 4, 0xffffff);
        bO.c("Opponent's Offer", i + 9, i1 + 152, 4, 0xffffff);
        bO.c("Your Inventory", i + 216, i1 + 27, 4, 0xffffff);
        if(!fz)
            bO.c(i + 217, i1 + 238, bU + 25);
        bO.c(i + 394, i1 + 238, bU + 26);
        if(fy)
        {
            bO.b("Other player", i + 341, i1 + 246, 1, 0xffffff);
            bO.b("has accepted", i + 341, i1 + 256, 1, 0xffffff);
        }
        if(fz)
        {
            bO.b("Waiting for", i + 217 + 35, i1 + 246, 1, 0xffffff);
            bO.b("other player", i + 217 + 35, i1 + 256, 1, 0xffffff);
        }
        j3 = 0;
        if(k5 == 0) goto _L32; else goto _L31
_L31:
        int k3 = 217 + i + (j3 % 5) * 49;
        int i4 = 31 + i1 + (j3 / 5) * 34;
        bO.a(k3, i4, 48, 32, bW + b.f[dA[j3]], b.k[dA[j3]], 0, 0, false);
        if(b.h[dA[j3]] == 0)
            bO.c(String.valueOf(dB[j3]), k3 + 1, i4 + 10, 1, 0xffff00);
        j3++;
_L32:
        if(j3 < dz) goto _L31; else goto _L33
_L33:
        int l3 = 0;
        if(k5 == 0) goto _L35; else goto _L34
_L34:
        int j4 = 9 + i + (l3 % 4) * 49;
        int l4 = 31 + i1 + (l3 / 4) * 34;
        bO.a(j4, l4, 48, 32, bW + b.f[ft[l3]], b.k[ft[l3]], 0, 0, false);
        if(b.h[ft[l3]] == 0)
            bO.c(String.valueOf(fu[l3]), j4 + 1, l4 + 10, 1, 0xffff00);
        if(super.G > j4 && super.G < j4 + 48 && super.H > l4 && super.H < l4 + 32)
            bO.c(b.c[ft[l3]] + ": @whi@" + b.d[ft[l3]], i + 8, i1 + 273, 1, 0xffff00);
        l3++;
_L35:
        if(l3 < fs) goto _L34; else goto _L36
_L36:
        int k4 = 0;
        if(k5 == 0) goto _L38; else goto _L37
_L37:
        int i5 = 9 + i + (k4 % 4) * 49;
        int j5 = 156 + i1 + (k4 / 4) * 34;
        bO.a(i5, j5, 48, 32, bW + b.f[fw[k4]], b.k[fw[k4]], 0, 0, false);
        if(b.h[fw[k4]] == 0)
            bO.c(String.valueOf(fx[k4]), i5 + 1, j5 + 10, 1, 0xffff00);
        if(super.G > i5 && super.G < i5 + 48 && super.H > j5 && super.H < j5 + 32)
            bO.c(b.c[fw[k4]] + ": @whi@" + b.d[fw[k4]], i + 8, i1 + 273, 1, 0xffff00);
        k4++;
_L38:
        if(k4 >= fv)
            return;
        if(true) goto _L37; else goto _L39
_L39:
    }

    public void bo()
    {
        byte byte0;
        byte byte1;
        int i1;
        int k1;
        k1 = b.bN;
        byte0 = 22;
        byte1 = 36;
        bO.b(byte0, byte1, 468, 16, 192);
        int i = 0x989898;
        bO.a(byte0, byte1 + 16, 468, 246, i, 160);
        bO.b("Please confirm your duel with @yel@" + a.f.a(ff), byte0 + 234, byte1 + 12, 1, 0xffffff);
        bO.b("Your stake:", byte0 + 117, byte1 + 30, 1, 0xffff00);
        i1 = 0;
        if(k1 == 0) goto _L2; else goto _L1
_L1:
        String s1 = b.c[fh[i1]];
        if(b.h[fh[i1]] == 0)
            s1 = s1 + " (" + fi[i1] + ")";
        bO.b(s1, byte0 + 117, byte1 + 42 + i1 * 12, 1, 0xffffff);
        i1++;
_L2:
        if(i1 < fg) goto _L1; else goto _L3
_L3:
        int j1;
        if(fg == 0)
            bO.b("Nothing!", byte0 + 117, byte1 + 42, 1, 0xffffff);
        bO.b("Your opponent's stake:", byte0 + 351, byte1 + 30, 1, 0xffff00);
        j1 = 0;
        if(k1 == 0) goto _L5; else goto _L4
_L4:
        String s2 = b.c[fk[j1]];
        if(b.h[fk[j1]] == 0)
            s2 = s2 + " (" + fl[j1] + ")";
        bO.b(s2, byte0 + 351, byte1 + 42 + j1 * 12, 1, 0xffffff);
        j1++;
_L5:
        if(j1 >= fj)
        {
label0:
            {
                if(fj == 0)
                    bO.b("Nothing!", byte0 + 351, byte1 + 42, 1, 0xffffff);
                if(fm == 0)
                {
                    bO.b("You can retreat from this duel", byte0 + 234, byte1 + 180, 1, 65280);
                    if(k1 == 0)
                        break label0;
                }
                bO.b("No retreat is possible!", byte0 + 234, byte1 + 180, 1, 0xff0000);
            }
label1:
            {
                if(fn == 0)
                {
                    bO.b("Magic may be used", byte0 + 234, byte1 + 192, 1, 65280);
                    if(k1 == 0)
                        break label1;
                }
                bO.b("Magic cannot be used", byte0 + 234, byte1 + 192, 1, 0xff0000);
            }
label2:
            {
                if(fo == 0)
                {
                    bO.b("Prayer may be used", byte0 + 234, byte1 + 204, 1, 65280);
                    if(k1 == 0)
                        break label2;
                }
                bO.b("Prayer cannot be used", byte0 + 234, byte1 + 204, 1, 0xff0000);
            }
label3:
            {
                if(fp == 0)
                {
                    bO.b("Weapons may be used", byte0 + 234, byte1 + 216, 1, 65280);
                    if(k1 == 0)
                        break label3;
                }
                bO.b("Weapons cannot be used", byte0 + 234, byte1 + 216, 1, 0xff0000);
            }
label4:
            {
                bO.b("If you are sure click 'Accept' to begin the duel", byte0 + 234, byte1 + 230, 1, 0xffffff);
                if(!fe)
                {
                    bO.c((byte0 + 118) - 35, byte1 + 238, bU + 25);
                    bO.c((byte0 + 352) - 35, byte1 + 238, bU + 26);
                    if(k1 == 0)
                        break label4;
                }
                bO.b("Waiting for other player...", byte0 + 234, byte1 + 250, 1, 0xffff00);
            }
            if(bz == 1)
            {
                if(super.G < byte0 || super.H < byte1 || super.G > byte0 + 468 || super.H > byte1 + 262)
                {
                    fd = false;
                    super.Y.a(233, 235);
                    super.Y.g();
                }
                if(super.G >= (byte0 + 118) - 35 && super.G <= byte0 + 118 + 70 && super.H >= byte1 + 238 && super.H <= byte1 + 238 + 21)
                {
                    fe = true;
                    super.Y.a(198, 412);
                    super.Y.g();
                }
                if(super.G >= (byte0 + 352) - 35 && super.G <= byte0 + 353 + 70 && super.H >= byte1 + 238 && super.H <= byte1 + 238 + 21)
                {
                    fd = false;
                    super.Y.a(203, 266);
                    super.Y.g();
                }
                bz = 0;
            }
            return;
        }
        if(true) goto _L4; else goto _L6
_L6:
    }

    public void bp()
    {
        int i;
        int i1;
        int j1;
        boolean flag1;
        int j2;
        int k2;
        int l2;
        int k5;
        k5 = b.bN;
        if(bz != 0 && fB == 0)
            fB = 1;
        if(fB <= 0)
            break MISSING_BLOCK_LABEL_1139;
        i = super.G - 22;
        i1 = super.H - 36;
        if(i < 0 || i1 < 0 || i >= 468 || i1 >= 262)
            break MISSING_BLOCK_LABEL_1097;
        if(i <= 216 || i1 <= 30 || i >= 462 || i1 >= 235)
            break MISSING_BLOCK_LABEL_416;
        j1 = (i - 217) / 49 + ((i1 - 31) / 34) * 5;
        if(j1 < 0 || j1 >= dz)
            break MISSING_BLOCK_LABEL_416;
        flag1 = false;
        j2 = 0;
        k2 = dA[j1];
        l2 = 0;
        if(k5 == 0) goto _L2; else goto _L1
_L1:
        int i3;
        if(eS[l2] != k2)
            continue; /* Loop/switch isn't completed */
        if(b.h[k2] != 0)
            break MISSING_BLOCK_LABEL_225;
        i3 = 0;
        if(k5 == 0) goto _L4; else goto _L3
_L3:
        if(eT[l2] < dB[j1])
            eT[l2]++;
        flag1 = true;
        i3++;
_L4:
        if(i3 < fB) goto _L3; else goto _L5
_L5:
        if(k5 == 0)
            continue; /* Loop/switch isn't completed */
        j2++;
        l2++;
_L2:
        if(l2 < eR) goto _L1; else goto _L6
_L6:
        if(d(k2) <= j2)
            flag1 = true;
        if(b.l[k2] == 1)
        {
            b("This object cannot be added to a duel offer", 3);
            flag1 = true;
        }
        if(!flag1 && eR < 8)
        {
            eS[eR] = k2;
            eT[eR] = 1;
            eR++;
            flag1 = true;
        }
        if(!flag1)
            break MISSING_BLOCK_LABEL_416;
        super.Y.a(201, 53);
        super.Y.a(eR);
        i3 = 0;
        if(k5 == 0) goto _L8; else goto _L7
_L7:
        super.Y.b(eS[i3]);
        super.Y.c(eT[i3]);
        i3++;
_L8:
        if(i3 < eR) goto _L7; else goto _L9
_L9:
        super.Y.g();
        eX = false;
        eY = false;
        int l1;
        if(i <= 8 || i1 <= 30 || i >= 205 || i1 >= 129)
            break MISSING_BLOCK_LABEL_694;
        j1 = (i - 9) / 49 + ((i1 - 31) / 34) * 4;
        if(j1 < 0 || j1 >= eR)
            break MISSING_BLOCK_LABEL_694;
        l1 = eS[j1];
        j2 = 0;
        if(k5 == 0) goto _L11; else goto _L10
_L10:
        if(b.h[l1] == 0 && eT[j1] > 1)
        {
            eT[j1]--;
            if(k5 == 0)
                continue; /* Loop/switch isn't completed */
        }
        eR--;
        fA = 0;
        k2 = j1;
        if(k5 == 0) goto _L13; else goto _L12
_L12:
        eS[k2] = eS[k2 + 1];
        eT[k2] = eT[k2 + 1];
        k2++;
_L13:
        if(k2 < eR) goto _L12; else goto _L14
_L14:
        if(k5 == 0)
            break; /* Loop/switch isn't completed */
        j2++;
_L11:
        if(j2 < fB) goto _L10; else goto _L15
_L15:
        super.Y.a(201, 53);
        super.Y.a(eR);
        k2 = 0;
        if(k5 == 0) goto _L17; else goto _L16
_L16:
        super.Y.b(eS[k2]);
        super.Y.c(eT[k2]);
        k2++;
_L17:
        if(k2 < eR) goto _L16; else goto _L18
_L18:
        super.Y.g();
        eX = false;
        eY = false;
        boolean flag = false;
        if(i >= 93 && i1 >= 221 && i <= 104 && i1 <= 232)
        {
            eZ = !eZ;
            flag = true;
        }
        if(i >= 93 && i1 >= 240 && i <= 104 && i1 <= 251)
        {
            fa = !fa;
            flag = true;
        }
        if(i >= 191 && i1 >= 221 && i <= 202 && i1 <= 232)
        {
            fb = !fb;
            flag = true;
        }
        if(i >= 191 && i1 >= 240 && i <= 202 && i1 <= 251)
        {
            fc = !fc;
            flag = true;
        }
        if(flag)
        {
            super.Y.a(200, 285);
            super.Y.a(eZ ? 1 : 0);
            super.Y.a(fa ? 1 : 0);
            super.Y.a(fb ? 1 : 0);
            super.Y.a(fc ? 1 : 0);
            super.Y.g();
            eX = false;
            eY = false;
        }
        if(i >= 217 && i1 >= 238 && i <= 286 && i1 <= 259)
        {
            eY = true;
            super.Y.a(199, 564);
            super.Y.g();
        }
        if(i < 394 || i1 < 238 || i >= 463 || i1 >= 259)
            break MISSING_BLOCK_LABEL_1129;
        eP = false;
        super.Y.a(203, 266);
        super.Y.g();
        if(k5 == 0)
            break MISSING_BLOCK_LABEL_1129;
        if(bz != 0)
        {
            eP = false;
            super.Y.a(203, 266);
            super.Y.g();
        }
        bz = 0;
        fB = 0;
        if(!eP)
            return;
        i = 22;
        i1 = 36;
        bO.b(i, i1, 468, 12, 0xc90b1d);
        int k1 = 0x989898;
        bO.a(i, i1 + 12, 468, 18, k1, 160);
        bO.a(i, i1 + 30, 8, 248, k1, 160);
        bO.a(i + 205, i1 + 30, 11, 248, k1, 160);
        bO.a(i + 462, i1 + 30, 6, 248, k1, 160);
        bO.a(i + 8, i1 + 99, 197, 24, k1, 160);
        bO.a(i + 8, i1 + 192, 197, 23, k1, 160);
        bO.a(i + 8, i1 + 258, 197, 20, k1, 160);
        bO.a(i + 216, i1 + 235, 246, 43, k1, 160);
        int i2 = 0xd0d0d0;
        bO.a(i + 8, i1 + 30, 197, 69, i2, 160);
        bO.a(i + 8, i1 + 123, 197, 69, i2, 160);
        bO.a(i + 8, i1 + 215, 197, 43, i2, 160);
        bO.a(i + 216, i1 + 30, 246, 205, i2, 160);
        j2 = 0;
        if(k5 == 0) goto _L20; else goto _L19
_L19:
        bO.b(i + 8, i1 + 30 + j2 * 34, 197, 0);
        j2++;
_L20:
        if(j2 < 3) goto _L19; else goto _L21
_L21:
        k2 = 0;
        if(k5 == 0) goto _L23; else goto _L22
_L22:
        bO.b(i + 8, i1 + 123 + k2 * 34, 197, 0);
        k2++;
_L23:
        if(k2 < 3) goto _L22; else goto _L24
_L24:
        l2 = 0;
        if(k5 == 0) goto _L26; else goto _L25
_L25:
        bO.b(i + 216, i1 + 30 + l2 * 34, 246, 0);
        l2++;
_L26:
        if(l2 < 7) goto _L25; else goto _L27
_L27:
        i3 = 0;
        if(k5 == 0) goto _L29; else goto _L28
_L28:
        if(i3 < 5)
            bO.c(i + 8 + i3 * 49, i1 + 30, 69, 0);
        if(i3 < 5)
            bO.c(i + 8 + i3 * 49, i1 + 123, 69, 0);
        bO.c(i + 216 + i3 * 49, i1 + 30, 205, 0);
        i3++;
_L29:
        if(i3 < 6) goto _L28; else goto _L30
_L30:
        int j3;
        bO.b(i + 8, i1 + 215, 197, 0);
        bO.b(i + 8, i1 + 257, 197, 0);
        bO.c(i + 8, i1 + 215, 43, 0);
        bO.c(i + 204, i1 + 215, 43, 0);
        bO.c("Preparing to duel with: " + eQ, i + 1, i1 + 10, 1, 0xffffff);
        bO.c("Your Stake", i + 9, i1 + 27, 4, 0xffffff);
        bO.c("Opponent's Stake", i + 9, i1 + 120, 4, 0xffffff);
        bO.c("Duel Options", i + 9, i1 + 212, 4, 0xffffff);
        bO.c("Your Inventory", i + 216, i1 + 27, 4, 0xffffff);
        bO.c("No retreating", i + 8 + 1, i1 + 215 + 16, 3, 0xffff00);
        bO.c("No magic", i + 8 + 1, i1 + 215 + 35, 3, 0xffff00);
        bO.c("No prayer", i + 8 + 102, i1 + 215 + 16, 3, 0xffff00);
        bO.c("No weapons", i + 8 + 102, i1 + 215 + 35, 3, 0xffff00);
        bO.c(i + 93, i1 + 215 + 6, 11, 11, 0xffff00);
        if(eZ)
            bO.b(i + 95, i1 + 215 + 8, 7, 7, 0xffff00);
        bO.c(i + 93, i1 + 215 + 25, 11, 11, 0xffff00);
        if(fa)
            bO.b(i + 95, i1 + 215 + 27, 7, 7, 0xffff00);
        bO.c(i + 191, i1 + 215 + 6, 11, 11, 0xffff00);
        if(fb)
            bO.b(i + 193, i1 + 215 + 8, 7, 7, 0xffff00);
        bO.c(i + 191, i1 + 215 + 25, 11, 11, 0xffff00);
        if(fc)
            bO.b(i + 193, i1 + 215 + 27, 7, 7, 0xffff00);
        if(!eY)
            bO.c(i + 217, i1 + 238, bU + 25);
        bO.c(i + 394, i1 + 238, bU + 26);
        if(eX)
        {
            bO.b("Other player", i + 341, i1 + 246, 1, 0xffffff);
            bO.b("has accepted", i + 341, i1 + 256, 1, 0xffffff);
        }
        if(eY)
        {
            bO.b("Waiting for", i + 217 + 35, i1 + 246, 1, 0xffffff);
            bO.b("other player", i + 217 + 35, i1 + 256, 1, 0xffffff);
        }
        j3 = 0;
        if(k5 == 0) goto _L32; else goto _L31
_L31:
        int k3 = 217 + i + (j3 % 5) * 49;
        int i4 = 31 + i1 + (j3 / 5) * 34;
        bO.a(k3, i4, 48, 32, bW + b.f[dA[j3]], b.k[dA[j3]], 0, 0, false);
        if(b.h[dA[j3]] == 0)
            bO.c(String.valueOf(dB[j3]), k3 + 1, i4 + 10, 1, 0xffff00);
        j3++;
_L32:
        if(j3 < dz) goto _L31; else goto _L33
_L33:
        int l3 = 0;
        if(k5 == 0) goto _L35; else goto _L34
_L34:
        int j4 = 9 + i + (l3 % 4) * 49;
        int l4 = 31 + i1 + (l3 / 4) * 34;
        bO.a(j4, l4, 48, 32, bW + b.f[eS[l3]], b.k[eS[l3]], 0, 0, false);
        if(b.h[eS[l3]] == 0)
            bO.c(String.valueOf(eT[l3]), j4 + 1, l4 + 10, 1, 0xffff00);
        if(super.G > j4 && super.G < j4 + 48 && super.H > l4 && super.H < l4 + 32)
            bO.c(b.c[eS[l3]] + ": @whi@" + b.d[eS[l3]], i + 8, i1 + 273, 1, 0xffff00);
        l3++;
_L35:
        if(l3 < eR) goto _L34; else goto _L36
_L36:
        int k4 = 0;
        if(k5 == 0) goto _L38; else goto _L37
_L37:
        int i5 = 9 + i + (k4 % 4) * 49;
        int j5 = 124 + i1 + (k4 / 4) * 34;
        bO.a(i5, j5, 48, 32, bW + b.f[eV[k4]], b.k[eV[k4]], 0, 0, false);
        if(b.h[eV[k4]] == 0)
            bO.c(String.valueOf(eW[k4]), i5 + 1, j5 + 10, 1, 0xffff00);
        if(super.G > i5 && super.G < i5 + 48 && super.H > j5 && super.H < j5 + 32)
            bO.c(b.c[eV[k4]] + ": @whi@" + b.d[eV[k4]], i + 8, i1 + 273, 1, 0xffff00);
        k4++;
_L38:
        if(k4 >= eU)
            return;
        if(true) goto _L37; else goto _L39
_L39:
    }

    public void bq()  //Determins what menu the mouse is on
    {
        if(dx == 0 && super.G >= ((g) (bO)).a - 35 && super.H >= 3 && super.G < ((g) (bO)).a - 3 && super.H < 35)
            dx = 1;
        if(dx == 0 && super.G >= ((g) (bO)).a - 35 - 33 && super.H >= 3 && super.G < ((g) (bO)).a - 3 - 33 && super.H < 35)
        {
            dx = 2;
            dR = (int)(Math.random() * 13D) - 6;
            dS = (int)(Math.random() * 23D) - 11;
        }
        if(dx == 0 && super.G >= ((g) (bO)).a - 35 - 66 && super.H >= 3 && super.G < ((g) (bO)).a - 3 - 66 && super.H < 35)
            dx = 3;
        if(dx == 0 && super.G >= ((g) (bO)).a - 35 - 99 && super.H >= 3 && super.G < ((g) (bO)).a - 3 - 99 && super.H < 35)
            dx = 4;
        if(dx == 0 && super.G >= ((g) (bO)).a - 35 - 132 && super.H >= 3 && super.G < ((g) (bO)).a - 3 - 132 && super.H < 35)
            dx = 5;
        if(dx == 0 && super.G >= ((g) (bO)).a - 35 - 165 && super.H >= 3 && super.G < ((g) (bO)).a - 3 - 165 && super.H < 35)
            dx = 6;
        if(dx != 0 && super.G >= ((g) (bO)).a - 35 && super.H >= 3 && super.G < ((g) (bO)).a - 3 && super.H < 26)
            dx = 1;
        if(dx != 0 && dx != 2 && super.G >= ((g) (bO)).a - 35 - 33 && super.H >= 3 && super.G < ((g) (bO)).a - 3 - 33 && super.H < 26)
        {
            dx = 2;
            dR = (int)(Math.random() * 13D) - 6;
            dS = (int)(Math.random() * 23D) - 11;
        }
        if(dx != 0 && super.G >= ((g) (bO)).a - 35 - 66 && super.H >= 3 && super.G < ((g) (bO)).a - 3 - 66 && super.H < 26)
            dx = 3;
        if(dx != 0 && super.G >= ((g) (bO)).a - 35 - 99 && super.H >= 3 && super.G < ((g) (bO)).a - 3 - 99 && super.H < 26)
            dx = 4;
        if(dx != 0 && super.G >= ((g) (bO)).a - 35 - 132 && super.H >= 3 && super.G < ((g) (bO)).a - 3 - 132 && super.H < 26)
            dx = 5;
        if(dx != 0 && super.G >= ((g) (bO)).a - 35 - 165 && super.H >= 3 && super.G < ((g) (bO)).a - 3 - 165 && super.H < 26)
            dx = 6;
        if(dx == 1 && (super.G < ((g) (bO)).a - 248 || super.H > 36 + (dy / 5) * 34))
            dx = 0;
        if(dx == 3 && (super.G < ((g) (bO)).a - 199 || super.H > 316))
            dx = 0;
        if((dx == 2 || dx == 4 || dx == 5) && (super.G < ((g) (bO)).a - 199 || super.H > 240))
            dx = 0;
        if(dx == 6 && (super.G < ((g) (bO)).a - 199 || super.H > 311))
            dx = 0;
    }

    public void a(boolean flag)
    {
        int i;
        int j1;
        int j3;
        j3 = b.bN;
        i = ((g) (bO)).a - 248;
        bO.c(i, 3, bU + 1);
        j1 = 0;
        if(j3 == 0) goto _L2; else goto _L1
_L1:
        int k1;
        int i2;
label0:
        {
            k1 = i + (j1 % 5) * 49;
            i2 = 36 + (j1 / 5) * 34;
            if(j1 < dz && dC[j1] == 1)
            {
                bO.a(k1, i2, 49, 34, 0xff0000, 128);
                if(j3 == 0)
                    break label0;
            }
            bO.a(k1, i2, 49, 34, a.a.g.b(181, 181, 181), 128);
        }
        if(j1 < dz)
        {
            bO.a(k1, i2, 48, 32, bW + b.f[dA[j1]], b.k[dA[j1]], 0, 0, false);
            if(b.h[dA[j1]] == 0)
                bO.c(String.valueOf(dB[j1]), k1 + 1, i2 + 10, 1, 0xffff00);
        }
        j1++;
_L2:
        if(j1 < dy) goto _L1; else goto _L3
_L3:
        int l1 = 1;
        if(j3 == 0) goto _L5; else goto _L4
_L4:
        bO.c(i + l1 * 49, 36, (dy / 5) * 34, 0);
        l1++;
_L5:
        if(l1 <= 4) goto _L4; else goto _L6
_L6:
        int j2 = 1;
        if(j3 == 0) goto _L8; else goto _L7
_L7:
        bO.b(i, 36 + j2 * 34, 245, 0);
        j2++;
_L8:
        if(j2 > dy / 5 - 1)
        {
label1:
            {
                int l2;
                int i3;
label2:
                {
label3:
                    {
                        if(!flag)
                            return;
                        int i1 = super.G - (((g) (bO)).a - 248);
                        int k2 = super.H - 36;
                        if(i1 < 0 || k2 < 0 || i1 >= 248 || k2 >= (dy / 5) * 34)
                            break label1;
                        l2 = i1 / 49 + (k2 / 34) * 5;
                        if(l2 >= dz)
                            break label1;
                        i3 = dA[l2];
                        if(dW >= 0)
                        {
                            if(b.bx[dW] == 3)
                            {
                                eu[er] = "Cast " + b.bt[dW] + " on";
                                et[er] = "@lre@" + b.c[i3];
                                ev[er] = 600;
                                ey[er] = l2;
                                ez[er] = dW;
                                er++;
                                return;
                            }
                            break label1;
                        }
                        if(dD >= 0)
                        {
                            eu[er] = "Use " + dE + " with";
                            et[er] = "@lre@" + b.c[i3];
                            ev[er] = 610;
                            ey[er] = l2;
                            ez[er] = dD;
                            er++;
                            return;
                        }
                        if(dC[l2] == 1)
                        {
                            eu[er] = "Remove";
                            et[er] = "@lre@" + b.c[i3];
                            ev[er] = 620;
                            ey[er] = l2;
                            er++;
                            if(j3 == 0)
                                break label2;
                        }
                        if(b.j[i3] == 0)
                            break label2;
                        if((b.j[i3] & 0x18) != 0)
                        {
                            eu[er] = "Wield";
                            if(j3 == 0)
                                break label3;
                        }
                        eu[er] = "Wear";
                    }
                    et[er] = "@lre@" + b.c[i3];
                    ev[er] = 630;
                    ey[er] = l2;
                    er++;
                }
                if(!b.e[i3].equals(""))
                {
                    eu[er] = b.e[i3];
                    et[er] = "@lre@" + b.c[i3];
                    ev[er] = 640;
                    ey[er] = l2;
                    er++;
                }
                eu[er] = "Use";
                et[er] = "@lre@" + b.c[i3];
                ev[er] = 650;
                ey[er] = l2;
                er++;
                eu[er] = "Drop";
                et[er] = "@lre@" + b.c[i3];
                ev[er] = 660;
                ey[er] = l2;
                er++;
                eu[er] = "Examine";
                et[er] = "@lre@" + b.c[i3];
                ev[er] = 3600;
                ey[er] = i3;
                er++;
            }
            return;
        }
        if(true) goto _L7; else goto _L9
_L9:
    }

    public void b(boolean flag) //map
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
        i = ((g) (bO)).a - 199; //x start of map?
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
        bO.g((i + c1 / 2) - j2, 36 + c3 / 2 + l3, bU - 1, l1 + 64 & 0xff, j1); //draws the terain
        l7 = 0;
        if(k9 == 0) goto _L2; else goto _L1
_L1:
        int k2 = (((di[l7] * bP + 64) - cN.e) * 3 * j1) / 2048;
        int i4 = (((dj[l7] * bP + 64) - cN.f) * 3 * j1) / 2048;
        int k6 = i4 * j5 + k2 * l5 >> 18;
        i4 = i4 * l5 - k2 * j5 >> 18;
        k2 = k6;
        b(i + c1 / 2 + k2, (36 + c3 / 2) - i4, 0x0000FFFF); //set cyan pixle?
        l7++;
_L2:
        if(l7 < dg) goto _L1; else goto _L3
_L3:
        int i8 = 0;
        if(k9 == 0) goto _L5; else goto _L4
_L4:
        int l2 = (((db[i8] * bP + 64) - cN.e) * 3 * j1) / 2048;
        int j4 = (((dc[i8] * bP + 64) - cN.f) * 3 * j1) / 2048;
        int l6 = j4 * j5 + l2 * l5 >> 18;
        j4 = j4 * l5 - l2 * j5 >> 18;
        l2 = l6;
        b(i + c1 / 2 + l2, (36 + c3 / 2) - j4, 0xff0000); //set red pixle
        i8++;
_L5:
        if(i8 < da) goto _L4; else goto _L6
_L6:
        int j8 = 0;
        if(k9 == 0) goto _L8; else goto _L7
_L7:
        c c5 = cW[j8];
        int i3 = ((c5.e - cN.e) * 3 * j1) / 2048;
        int k4 = ((c5.f - cN.f) * 3 * j1) / 2048;
        int i7 = k4 * j5 + i3 * l5 >> 18;
        k4 = k4 * l5 - i3 * j5 >> 18;
        i3 = i7;
        b(i + c1 / 2 + i3, (36 + c3 / 2) - k4, 0xffff00); //set yellow pixle
        j8++;
_L8:
        if(j8 < cT) goto _L7; else goto _L9
_L9:
        int k8 = 0;
        if(k9 == 0) goto _L11; else goto _L10
_L10:
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
        if(k9 == 0) goto _L13; else goto _L12
_L12:
        if(c6.a != super.bd[j9] || super.be[j9] != 99)
            continue; /* Loop/switch isn't completed */
        i9 = 65280;
        if(k9 == 0)
            break; /* Loop/switch isn't completed */
        j9++;
_L13:
        if(j9 < super.bc) goto _L12; else goto _L14
_L14:
        b(i + c1 / 2 + j3, (36 + c3 / 2) - l4, i9);
        k8++;
_L11:
        if(k8 >= cH)
        {
            bO.a(i + c1 / 2, 36 + c3 / 2, 2, 0xffffff, 255);
            bO.g(i + 19, 55, bU + 24, cE + 128 & 0xff, 128);
            bO.a(0, 0, bR, bS + 12);
            if(!flag)
                return;
            i = super.G - (((g) (bO)).a - 199);
            int l8 = super.H - 36;
            if(i >= 40 && l8 >= 0 && i < 196 && l8 < 152)
            {
                char c2 = '\234';
                char c4 = '\230';
                int k1 = 192 + dS;
                int i2 = cE + dR & 0xff;
                int i1 = ((g) (bO)).a - 199;
                i1 += 40;
                int k3 = ((super.G - (i1 + c2 / 2)) * 16384) / (3 * k1);
                int i5 = ((super.H - (36 + c4 / 2)) * 16384) / (3 * k1);
                int k5 = j.k[1024 - i2 * 4 & 0x3ff];
                int i6 = j.k[(1024 - i2 * 4 & 0x3ff) + 1024];
                int k7 = i5 * k5 + k3 * i6 >> 15;
                i5 = i5 * i6 - k3 * k5 >> 15;
                k3 = k7;
                k3 += cN.e;
                i5 = cN.f - i5;
                if(bz == 1)
                    a(cO, cP, k3 / 128, i5 / 128, false);
                bz = 0;
            }
            return;
        }
        if(true) goto _L10; else goto _L15
_L15:
    }

    public void c(boolean flag)
    {
        int i;
        char c1;
        char c2;
        int i2;
        int j2;
        int k2;
        int l3;
        byte byte0;
        int k1;
        int l1;
label0:
        {
            l3 = b.bN;
            i = ((g) (bO)).a - 199;
            byte0 = 36;
            bO.c(i - 49, 3, bU + 3);
            c1 = '\304';
            c2 = '\u0113';
            k1 = l1 = a.a.g.b(160, 160, 160);
            if(ed == 0)
            {
                k1 = a.a.g.b(220, 220, 220);
                if(l3 == 0)
                    break label0;
            }
            l1 = a.a.g.b(220, 220, 220);
        }
        bO.a(i, byte0, c1 / 2, 24, k1, 128);
        bO.a(i + c1 / 2, byte0, c1 / 2, 24, l1, 128);
        bO.a(i, byte0 + 24, c1, c2 - 24, a.a.g.b(220, 220, 220), 128);
        bO.b(i, byte0 + 24, c1, 0);
        bO.c(i + c1 / 2, byte0, 24, 0);
        bO.b("Stats", i + c1 / 4, byte0 + 16, 4, 0);
        bO.b("Quests", i + c1 / 4 + c1 / 2, byte0 + 16, 4, 0);
        if(ed != 0)
            break MISSING_BLOCK_LABEL_1180;
        i2 = 72;
        j2 = -1;
        bO.c("Skills", i + 5, i2, 3, 0xffff00);
        i2 += 13;
        k2 = 0;
        if(l3 == 0) goto _L2; else goto _L1
_L1:
        int l2 = 0xffffff;
        if(super.G > i + 3 && super.H >= i2 - 11 && super.H < i2 + 2 && super.G < i + 90)
        {
            l2 = 0xff0000;
            j2 = k2;
        }
        bO.c(dO[k2] + ":@yel@" + dH[k2] + "/" + dI[k2], i + 5, i2, 1, l2);
        l2 = 0xffffff;
        if(super.G >= i + 90 && super.H >= i2 - 13 - 11 && super.H < (i2 - 13) + 2 && super.G < i + 196)
        {
            l2 = 0xff0000;
            j2 = k2 + 9;
        }
        bO.c(dO[k2 + 9] + ":@yel@" + dH[k2 + 9] + "/" + dI[k2 + 9], (i + c1 / 2) - 5, i2 - 13, 1, l2);
        i2 += 13;
        k2++;
_L2:
        if(k2 < 9) goto _L1; else goto _L3
_L3:
        int i3;
        bO.c("Quest Points:@yel@" + dL, (i + c1 / 2) - 5, i2 - 13, 1, 0xffffff);
        i2 += 12;
        bO.c("Fatigue: @yel@" + (dM * 100) / 750 + "%", i + 5, i2 - 13, 1, 0xffffff);
        i2 += 8;
        bO.c("Equipment Status", i + 5, i2, 3, 0xffff00);
        i2 += 12;
        i3 = 0;
        if(l3 == 0) goto _L5; else goto _L4
_L4:
        bO.c(dQ[i3] + ":@yel@" + dK[i3], i + 5, i2, 1, 0xffffff);
        if(i3 < 2)
            bO.c(dQ[i3 + 3] + ":@yel@" + dK[i3 + 3], i + c1 / 2 + 25, i2, 1, 0xffffff);
        i2 += 13;
        i3++;
_L5:
        if(i3 < 3) goto _L4; else goto _L6
_L6:
        int j3;
        int k3;
        i2 += 6;
        bO.b(i, i2 - 15, c1, 0);
        if(j2 == -1)
            break MISSING_BLOCK_LABEL_1050;
        bO.c(dP[j2] + " skill", i + 5, i2, 1, 0xffff00);
        i2 += 12;
        j3 = dF[0];
        k3 = 0;
        if(l3 == 0) goto _L8; else goto _L7
_L7:
        if(dJ[j2] >= dF[k3])
            j3 = dF[k3 + 1];
        k3++;
_L8:
        if(k3 < 98) goto _L7; else goto _L9
_L9:
        bO.c("Total xp: " + dJ[j2] / 4, i + 5, i2, 1, 0xffffff);
        i2 += 12;
        bO.c("Next level at: " + j3 / 4, i + 5, i2, 1, 0xffffff);
        if(l3 == 0)
            break MISSING_BLOCK_LABEL_1180;
        bO.c("Overall levels", i + 5, i2, 1, 0xffff00);
        i2 += 12;
        j3 = 0;
        k3 = 0;
        if(l3 == 0) goto _L11; else goto _L10
_L10:
        j3 += dI[k3];
        k3++;
_L11:
        if(k3 < 18) goto _L10; else goto _L12
_L12:
        bO.c("Skill total: " + j3, i + 5, i2, 1, 0xffffff);
        i2 += 12;
        bO.c("Combat level: " + cN.x, i + 5, i2, 1, 0xffffff);
        i2 += 12;
        if(ed != 1)
            break MISSING_BLOCK_LABEL_1295;
        eb.c(ec);
        eb.a(ec, 0, "@whi@Quest-list (green=completed)");
        i2 = 0;
        if(l3 == 0) goto _L14; else goto _L13
_L13:
        eb.a(ec, i2 + 1, (eg[i2] ? "@gre@" : "@red@") + ef[i2]);
        i2++;
_L14:
        if(i2 < ee) goto _L13; else goto _L15
_L15:
        eb.a();
        if(!flag)
            return;
        int i1 = super.G - (((g) (bO)).a - 199);
        int j1 = super.H - 36;
        if(i1 >= 0 && j1 >= 0 && i1 < c1 && j1 < c2)
        {
            if(ed == 1)
                eb.a(i1 + (((g) (bO)).a - 199), j1 + 36, super.J, super.I);
            if(j1 <= 24 && bz == 1)
            {
                if(i1 < 98)
                {
                    ed = 0;
                    return;
                }
                if(i1 > 98)
                    ed = 1;
            }
        }
        return;
    }

    public void d(boolean flag)
    {
        int i;
        byte byte0;
        char c1;
        int i2;
        int k2;
        int j5;
        char c2;
        int k1;
        int l1;
label0:
        {
            j5 = b.bN;
            i = ((g) (bO)).a - 199;
            byte0 = 36;
            bO.c(i - 49, 3, bU + 4);
            c1 = '\304';
            c2 = '\266';
            k1 = l1 = a.a.g.b(160, 160, 160);
            if(dV == 0)
            {
                k1 = a.a.g.b(220, 220, 220);
                if(j5 == 0)
                    break label0;
            }
            l1 = a.a.g.b(220, 220, 220);
        }
        bO.a(i, byte0, c1 / 2, 24, k1, 128);
        bO.a(i + c1 / 2, byte0, c1 / 2, 24, l1, 128);
        bO.a(i, byte0 + 24, c1, 90, a.a.g.b(220, 220, 220), 128);
        bO.a(i, byte0 + 24 + 90, c1, c2 - 90 - 24, a.a.g.b(160, 160, 160), 128);
        bO.b(i, byte0 + 24, c1, 0);
        bO.c(i + c1 / 2, byte0, 24, 0);
        bO.b(i, byte0 + 113, c1, 0);
        bO.b("Magic", i + c1 / 4, byte0 + 16, 4, 0);
        bO.b("Prayers", i + c1 / 4 + c1 / 2, byte0 + 16, 4, 0);
        if(dV != 0)
            break MISSING_BLOCK_LABEL_789;
        dT.c(dU);
        i2 = 0;
        k2 = 0;
        if(j5 == 0) goto _L2; else goto _L1
_L1:
        String s1;
        int k3;
        s1 = "@yel@";
        k3 = 0;
        if(j5 == 0) goto _L4; else goto _L3
_L3:
        int i4 = b.by[k2][k3];
        if(b(i4, b.bz[k2][k3]))
            continue; /* Loop/switch isn't completed */
        s1 = "@whi@";
        if(j5 == 0)
            break; /* Loop/switch isn't completed */
        k3++;
_L4:
        if(k3 < b.bw[k2]) goto _L3; else goto _L5
_L5:
        int j4 = dH[6];
        if(b.bv[k2] > j4)
            s1 = "@bla@";
        dT.a(dU, i2++, s1 + "Level " + b.bv[k2] + ": " + b.bt[k2]);
        k2++;
_L2:
        if(k2 < b.bs) goto _L1; else goto _L6
_L6:
        int j3;
        dT.a();
        j3 = dT.j(dU);
        if(j3 == -1)
            break MISSING_BLOCK_LABEL_770;
        bO.c("Level " + b.bv[j3] + ": " + b.bt[j3], i + 2, byte0 + 124, 1, 0xffff00);
        bO.c(b.bu[j3], i + 2, byte0 + 136, 0, 0xffffff);
        k3 = 0;
        if(j5 == 0) goto _L8; else goto _L7
_L7:
        int k4 = b.by[j3][k3];
        bO.c(i + 2 + k3 * 44, byte0 + 150, bW + b.f[k4]);
        int l4 = d(k4);
        int i5 = b.bz[j3][k3];
        String s3 = "@red@";
        if(b(k4, i5))
            s3 = "@gre@";
        bO.c(s3 + l4 + "/" + i5, i + 2 + k3 * 44, byte0 + 150, 1, 0xffffff);
        k3++;
_L8:
        if(k3 < b.bw[j3]) goto _L7; else goto _L9
_L9:
        if(j5 == 0)
            break MISSING_BLOCK_LABEL_789;
        bO.c("Point at a spell for a description", i + 2, byte0 + 124, 1, 0);
        if(dV != 1)
            break MISSING_BLOCK_LABEL_1102;
        dT.c(dU);
        i2 = 0;
        k2 = 0;
        if(j5 == 0) goto _L11; else goto _L10
_L10:
        String s2 = "@whi@";
        if(b.bD[k2] > dI[5])
            s2 = "@bla@";
        if(eh[k2])
            s2 = "@gre@";
        dT.a(dU, i2++, s2 + "Level " + b.bD[k2] + ": " + b.bB[k2]);
        k2++;
_L11:
        if(k2 < b.bA) goto _L10; else goto _L12
_L12:
        dT.a();
        s2 = dT.j(dU);
        if(s2 != -1)
        {
            bO.b("Level " + b.bD[s2] + ": " + b.bB[s2], i + c1 / 2, byte0 + 130, 1, 0xffff00);
            bO.b(b.bC[s2], i + c1 / 2, byte0 + 145, 0, 0xffffff);
            bO.b("Drain rate: " + b.bE[s2], i + c1 / 2, byte0 + 160, 1, 0);
            if(j5 == 0)
                break MISSING_BLOCK_LABEL_1102;
        }
        bO.c("Point at a prayer for a description", i + 2, byte0 + 124, 1, 0);
label1:
        {
            if(!flag)
                return;
            int i1 = super.G - (((g) (bO)).a - 199);
            int j1 = super.H - 36;
            if(i1 < 0 || j1 < 0 || i1 >= 196 || j1 >= 182)
                break MISSING_BLOCK_LABEL_1616;
            dT.a(i1 + (((g) (bO)).a - 199), j1 + 36, super.J, super.I);
            if(j1 > 24 || bz != 1)
                break label1;
            if(i1 < 98 && dV == 1)
            {
                dV = 0;
                dT.d(dU);
                if(j5 == 0)
                    break label1;
            }
            if(i1 > 98 && dV == 0)
            {
                dV = 1;
                dT.d(dU);
            }
        }
        if(bz != 1 || dV != 0)
            break MISSING_BLOCK_LABEL_1420;
        i2 = dT.j(dU);
        if(i2 == -1)
            break MISSING_BLOCK_LABEL_1420;
        int l2 = dH[6];
        if(b.bv[i2] > l2)
        {
            b("Your magic ability is not high enough for this spell", 3);
            if(j5 == 0)
                break MISSING_BLOCK_LABEL_1420;
        }
        s2 = 0;
        if(j5 == 0) goto _L14; else goto _L13
_L13:
        int l3 = b.by[i2][s2];
        if(b(l3, b.bz[i2][s2]))
            continue; /* Loop/switch isn't completed */
        b("You don't have all the reagents you need for this spell", 3);
        s2 = -1;
        if(j5 == 0)
            break; /* Loop/switch isn't completed */
        s2++;
_L14:
        if(s2 < b.bw[i2]) goto _L13; else goto _L15
_L15:
        if(s2 == b.bw[i2])
        {
            dW = i2;
            dD = -1;
        }
label2:
        {
            if(bz != 1 || dV != 1)
                break label2;
            int j2 = dT.j(dU);
            if(j2 == -1)
                break label2;
            int i3 = dI[5];
            if(b.bD[j2] > i3)
            {
                b("Your prayer ability is not high enough for this prayer", 3);
                if(j5 == 0)
                    break label2;
            }
            if(dH[5] == 0)
            {
                b("You have run out of prayer points. Return to a church to recharge", 3);
                if(j5 == 0)
                    break label2;
            }
            if(eh[j2])
            {
                super.Y.a(211, 457);
                super.Y.a(j2);
                super.Y.g();
                eh[j2] = false;
                e("prayeroff");
                if(j5 == 0)
                    break label2;
            }
            super.Y.a(212, 126);
            super.Y.a(j2);
            super.Y.g();
            eh[j2] = true;
            e("prayeron");
        }
        bz = 0;
    }

    public void e(boolean flag)
    {
        int i;
        byte byte0;
        char c1;
        char c2;
        int l3;
        int k1;
        int l1;
label0:
        {
            l3 = b.bN;
            i = ((g) (bO)).a - 199;
            byte0 = 36;
            bO.c(i - 49, 3, bU + 5);
            c1 = '\304';
            c2 = '\266';
            k1 = l1 = a.a.g.b(160, 160, 160);
            if(dZ == 0)
            {
                k1 = a.a.g.b(220, 220, 220);
                if(l3 == 0)
                    break label0;
            }
            l1 = a.a.g.b(220, 220, 220);
        }
        bO.a(i, byte0, c1 / 2, 24, k1, 128);
        bO.a(i + c1 / 2, byte0, c1 / 2, 24, l1, 128);
        bO.a(i, byte0 + 24, c1, c2 - 24, a.a.g.b(220, 220, 220), 128);
        bO.b(i, byte0 + 24, c1, 0);
        bO.c(i + c1 / 2, byte0, 24, 0);
        bO.b(i, (byte0 + c2) - 16, c1, 0);
        bO.b("Friends", i + c1 / 4, byte0 + 16, 4, 0);
        bO.b("Ignore", i + c1 / 4 + c1 / 2, byte0 + 16, 4, 0);
        dX.c(dY);
        if(dZ != 0) goto _L2; else goto _L1
_L1:
        int i2 = 0;
        if(l3 == 0) goto _L4; else goto _L3
_L3:
        String s1;
label1:
        {
            if(super.be[i2] == 99)
            {
                s1 = "@gre@";
                if(l3 == 0)
                    break label1;
            }
            if(super.be[i2] > 0)
            {
                s1 = "@yel@";
                if(l3 == 0)
                    break label1;
            }
            s1 = "@red@";
        }
        dX.a(dY, i2, s1 + a.f.a(super.bd[i2]) + "~439~@whi@Remove         WWWWWWWWWW");
        i2++;
_L4:
        if(i2 < super.bc) goto _L3; else goto _L2
_L2:
        if(dZ != 1) goto _L6; else goto _L5
_L5:
        i2 = 0;
        if(l3 == 0) goto _L8; else goto _L7
_L7:
        dX.a(dY, i2, "@yel@" + a.f.a(super.bg[i2]) + "~439~@whi@Remove         WWWWWWWWWW");
        i2++;
_L8:
        if(i2 < super.bf) goto _L7; else goto _L6
_L6:
label2:
        {
label3:
            {
                dX.a();
                if(dZ != 0)
                    break label2;
                int j2 = dX.j(dY);
                if(j2 >= 0 && super.G < 489)
                {
                    if(super.G > 429)
                    {
                        bO.b("Click to remove " + a.f.a(super.bd[j2]), i + c1 / 2, byte0 + 35, 1, 0xffffff);
                        if(l3 == 0)
                            break label3;
                    }
                    if(super.be[j2] == 99)
                    {
                        bO.b("Click to message " + a.f.a(super.bd[j2]), i + c1 / 2, byte0 + 35, 1, 0xffffff);
                        if(l3 == 0)
                            break label3;
                    }
                    if(super.be[j2] > 0)
                    {
                        bO.b(a.f.a(super.bd[j2]) + " is on world " + super.be[j2], i + c1 / 2, byte0 + 35, 1, 0xffffff);
                        if(l3 == 0)
                            break label3;
                    }
                    bO.b(a.f.a(super.bd[j2]) + " is offline", i + c1 / 2, byte0 + 35, 1, 0xffffff);
                    if(l3 == 0)
                        break label3;
                }
                bO.b("Click a name to send a message", i + c1 / 2, byte0 + 35, 1, 0xffffff);
            }
            int j3;
label4:
            {
                if(super.G > i && super.G < i + c1 && super.H > (byte0 + c2) - 16 && super.H < byte0 + c2)
                {
                    j3 = 0xffff00;
                    if(l3 == 0)
                        break label4;
                }
                j3 = 0xffffff;
            }
            bO.b("Click here to add a friend", i + c1 / 2, (byte0 + c2) - 3, 1, j3);
        }
label5:
        {
label6:
            {
                if(dZ != 1)
                    break label5;
                int k2 = dX.j(dY);
                if(k2 >= 0 && super.G < 489 && super.G > 429)
                {
                    if(super.G <= 429)
                        break label6;
                    bO.b("Click to remove " + a.f.a(super.bg[k2]), i + c1 / 2, byte0 + 35, 1, 0xffffff);
                    if(l3 == 0)
                        break label6;
                }
                bO.b("Blocking messages from:", i + c1 / 2, byte0 + 35, 1, 0xffffff);
            }
            int k3;
label7:
            {
                if(super.G > i && super.G < i + c1 && super.H > (byte0 + c2) - 16 && super.H < byte0 + c2)
                {
                    k3 = 0xffff00;
                    if(l3 == 0)
                        break label7;
                }
                k3 = 0xffffff;
            }
            bO.b("Click here to add a name", i + c1 / 2, (byte0 + c2) - 3, 1, k3);
        }
label8:
        {
            int j1;
label9:
            {
                if(!flag)
                    return;
                int i1 = super.G - (((g) (bO)).a - 199);
                j1 = super.H - 36;
                if(i1 < 0 || j1 < 0 || i1 >= 196 || j1 >= 182)
                    break label8;
                dX.a(i1 + (((g) (bO)).a - 199), j1 + 36, super.J, super.I);
                if(j1 > 24 || bz != 1)
                    break label9;
                if(i1 < 98 && dZ == 1)
                {
                    dZ = 0;
                    dX.d(dY);
                    if(l3 == 0)
                        break label9;
                }
                if(i1 > 98 && dZ == 0)
                {
                    dZ = 1;
                    dX.d(dY);
                }
            }
label10:
            {
                if(bz != 1 || dZ != 0)
                    break label10;
                int l2 = dX.j(dY);
                if(l2 < 0 || super.G >= 489)
                    break label10;
                if(super.G > 429)
                {
                    b(super.bd[l2]);
                    if(l3 == 0)
                        break label10;
                }
                if(super.be[l2] != 0)
                {
                    gi = 2;
                    ea = super.bd[l2];
                    super.P = "";
                    super.Q = "";
                }
            }
            if(bz == 1 && dZ == 1)
            {
                int i3 = dX.j(dY);
                if(i3 >= 0 && super.G < 489 && super.G > 429)
                    a(super.bg[i3]);
            }
            if(j1 > 166 && bz == 1 && dZ == 0)
            {
                gi = 1;
                super.N = "";
                super.O = "";
            }
            if(j1 > 166 && bz == 1 && dZ == 1)
            {
                gi = 3;
                super.N = "";
                super.O = "";
            }
            bz = 0;
        }
        return;
    }

    public void f(boolean flag)
    {
        int i;
        char c1;
        int j1;
        int l1;
        int i3;
label0:
        {
            i3 = b.bN;
            i = ((g) (bO)).a - 199;
            byte byte0 = 36;
            bO.c(i - 49, 3, bU + 6);
            c1 = '\304';
            bO.a(i, 36, c1, 65, a.a.g.b(181, 181, 181), 160);
            bO.a(i, 101, c1, 65, a.a.g.b(201, 201, 201), 160);
            bO.a(i, 166, c1, 95, a.a.g.b(181, 181, 181), 160);
            bO.a(i, 261, c1, 40, a.a.g.b(201, 201, 201), 160);
            j1 = i + 3;
            l1 = byte0 + 15;
            bO.c("Game options - click to toggle", j1, l1, 1, 0);
            l1 += 15;
            if(ej)
            {
                bO.c("Camera angle mode - @gre@Auto", j1, l1, 1, 0xffffff);
                if(i3 == 0)
                    break label0;
            }
            bO.c("Camera angle mode - @red@Manual", j1, l1, 1, 0xffffff);
        }
label1:
        {
            l1 += 15;
            if(ek)
            {
                bO.c("Mouse buttons - @red@One", j1, l1, 1, 0xffffff);
                if(i3 == 0)
                    break label1;
            }
            bO.c("Mouse buttons - @gre@Two", j1, l1, 1, 0xffffff);
        }
label2:
        {
            l1 += 15;
            if(!bq)
                break label2;
            if(el)
            {
                bO.c("Sound effects - @red@off", j1, l1, 1, 0xffffff);
                if(i3 == 0)
                    break label2;
            }
            bO.c("Sound effects - @gre@on", j1, l1, 1, 0xffffff);
        }
label3:
        {
            l1 += 15;
            l1 += 5;
            bO.c("Security settings", j1, l1, 1, 0);
            l1 += 15;
            int j2 = 0xffffff;
            if(super.G > j1 && super.G < j1 + c1 && super.H > l1 - 12 && super.H < l1 + 4)
                j2 = 0xffff00;
            bO.c("Change password", j1, l1, 1, j2);
            l1 += 15;
            j2 = 0xffffff;
            if(super.G > j1 && super.G < j1 + c1 && super.H > l1 - 12 && super.H < l1 + 4)
                j2 = 0xffff00;
            bO.c("Change recovery questions", j1, l1, 1, j2);
            l1 += 15;
            j2 = 0xffffff;
            if(super.G > j1 && super.G < j1 + c1 && super.H > l1 - 12 && super.H < l1 + 4)
                j2 = 0xffff00;
            bO.c("Change contact details", j1, l1, 1, j2);
            l1 += 15;
            l1 += 5;
            bO.c("Privacy settings. Will be applied to", i + 3, l1, 1, 0);
            l1 += 15;
            bO.c("all people not on your friends list", i + 3, l1, 1, 0);
            l1 += 15;
            if(super.bh == 0)
            {
                bO.c("Block chat messages: @red@<off>", i + 3, l1, 1, 0xffffff);
                if(i3 == 0)
                    break label3;
            }
            bO.c("Block chat messages: @gre@<on>", i + 3, l1, 1, 0xffffff);
        }
label4:
        {
            l1 += 15;
            if(super.bi == 0)
            {
                bO.c("Block private messages: @red@<off>", i + 3, l1, 1, 0xffffff);
                if(i3 == 0)
                    break label4;
            }
            bO.c("Block private messages: @gre@<on>", i + 3, l1, 1, 0xffffff);
        }
label5:
        {
            l1 += 15;
            if(super.bj == 0)
            {
                bO.c("Block trade requests: @red@<off>", i + 3, l1, 1, 0xffffff);
                if(i3 == 0)
                    break label5;
            }
            bO.c("Block trade requests: @gre@<on>", i + 3, l1, 1, 0xffffff);
        }
label6:
        {
            l1 += 15;
            if(!bq)
                break label6;
            if(super.bk == 0)
            {
                bO.c("Block duel requests: @red@<off>", i + 3, l1, 1, 0xffffff);
                if(i3 == 0)
                    break label6;
            }
            bO.c("Block duel requests: @gre@<on>", i + 3, l1, 1, 0xffffff);
        }
        l1 += 15;
        l1 += 5;
        bO.c("Always logout when you finish", j1, l1, 1, 0);
        l1 += 15;
        int k2 = 0xffffff;
        if(super.G > j1 && super.G < j1 + c1 && super.H > l1 - 12 && super.H < l1 + 4)
            k2 = 0xffff00;
        bO.c("Click here to logout", i + 3, l1, 1, k2);
        if(!flag)
            return;
        i = super.G - (((g) (bO)).a - 199);
        int i1 = super.H - 36;
        if(i >= 0 && i1 >= 0 && i < 196 && i1 < 265)
        {
            int l2 = ((g) (bO)).a - 199;
            byte byte1 = 36;
            char c2 = '\304';
            int k1 = l2 + 3;
            int i2 = byte1 + 30;
            if(super.G > k1 && super.G < k1 + c2 && super.H > i2 - 12 && super.H < i2 + 4 && bz == 1)
            {
                ej = !ej;
                super.Y.a(213, 892);
                super.Y.a(0);
                super.Y.a(ej ? 1 : 0);
                super.Y.g();
            }
            i2 += 15;
            if(super.G > k1 && super.G < k1 + c2 && super.H > i2 - 12 && super.H < i2 + 4 && bz == 1)
            {
                ek = !ek;
                super.Y.a(213, 892);
                super.Y.a(2);
                super.Y.a(ek ? 1 : 0);
                super.Y.g();
            }
            i2 += 15;
            if(bq && super.G > k1 && super.G < k1 + c2 && super.H > i2 - 12 && super.H < i2 + 4 && bz == 1)
            {
                el = !el;
                super.Y.a(213, 892);
                super.Y.a(3);
                super.Y.a(el ? 1 : 0);
                super.Y.g();
            }
            i2 += 15;
            i2 += 20;
            if(super.G > k1 && super.G < k1 + c2 && super.H > i2 - 12 && super.H < i2 + 4 && bz == 1)
            {
                gl = 6;
                super.N = "";
                super.O = "";
            }
            i2 += 15;
            if(super.G > k1 && super.G < k1 + c2 && super.H > i2 - 12 && super.H < i2 + 4 && bz == 1)
            {
                super.Y.a(197, 882);
                super.Y.g();
            }
            i2 += 15;
            if(super.G > k1 && super.G < k1 + c2 && super.H > i2 - 12 && super.H < i2 + 4 && bz == 1)
            {
                super.Y.a(247, 888);
                super.Y.g();
            }
            i2 += 15;
            boolean flag1 = false;
            i2 += 35;
            if(super.G > k1 && super.G < k1 + c2 && super.H > i2 - 12 && super.H < i2 + 4 && bz == 1)
            {
                super.bh = 1 - super.bh;
                flag1 = true;
            }
            i2 += 15;
            if(super.G > k1 && super.G < k1 + c2 && super.H > i2 - 12 && super.H < i2 + 4 && bz == 1)
            {
                super.bi = 1 - super.bi;
                flag1 = true;
            }
            i2 += 15;
            if(super.G > k1 && super.G < k1 + c2 && super.H > i2 - 12 && super.H < i2 + 4 && bz == 1)
            {
                super.bj = 1 - super.bj;
                flag1 = true;
            }
            i2 += 15;
            if(bq && super.G > k1 && super.G < k1 + c2 && super.H > i2 - 12 && super.H < i2 + 4 && bz == 1)
            {
                super.bk = 1 - super.bk;
                flag1 = true;
            }
            i2 += 15;
            if(flag1)
                a(super.bh, super.bi, super.bj, super.bk);
            i2 += 20;
            if(super.G > k1 && super.G < k1 + c2 && super.H > i2 - 12 && super.H < i2 + 4 && bz == 1)
                F();
            bz = 0;
        }
    }

    public void br()
    {
        int i;
        int i1;
        int j1;
        int k5;
        k5 = b.bN;
        i = 2203 - (cP + co + cs);
        if(cO + cn + cr >= 2640)
            i = -50;
        i1 = -1;
        j1 = 0;
        if(k5 == 0) goto _L2; else goto _L1
_L1:
        dn[j1] = false;
        j1++;
_L2:
        if(j1 < dg) goto _L1; else goto _L3
_L3:
        int k1 = 0;
        if(k5 == 0) goto _L5; else goto _L4
_L4:
        dw[k1] = false;
        k1++;
_L5:
        if(k1 < dq) goto _L4; else goto _L6
_L6:
        int l1;
        f af[];
        int ai[];
        int i2;
        l1 = bN.c();
        af = bN.e();
        ai = bN.d();
        i2 = 0;
        if(k5 == 0) goto _L8; else goto _L7
_L7:
        int j2;
        f f1;
label0:
        {
            int l2;
            int k3;
label1:
            {
                String s1;
label2:
                {
label3:
                    {
label4:
                        {
                            if(er > 200)
                                break; /* Loop/switch isn't completed */
                            j2 = ai[i2];
                            f1 = af[i2];
                            if(f1.G[j2] > 65535 && (f1.G[j2] < 0x30d40 || f1.G[j2] > 0x493e0))
                                continue; /* Loop/switch isn't completed */
                            if(f1 != bN.X)
                                break label0;
                            l2 = f1.G[j2] % 10000;
                            k3 = f1.G[j2] / 10000;
                            if(k3 != 1)
                                break label1;
                            s1 = "";
                            int j4 = 0;
                            if(cN.x > 0 && cL[l2].x > 0)
                                j4 = cN.x - cL[l2].x;
                            if(j4 < 0)
                                s1 = "@or1@";
                            if(j4 < -3)
                                s1 = "@or2@";
                            if(j4 < -6)
                                s1 = "@or3@";
                            if(j4 < -9)
                                s1 = "@red@";
                            if(j4 > 0)
                                s1 = "@gr1@";
                            if(j4 > 3)
                                s1 = "@gr2@";
                            if(j4 > 6)
                                s1 = "@gr3@";
                            if(j4 > 9)
                                s1 = "@gre@";
                            s1 = " " + s1 + "(level-" + cL[l2].x + ")";
                            if(dW >= 0)
                            {
                                if(b.bx[dW] != 1 && b.bx[dW] != 2)
                                    continue; /* Loop/switch isn't completed */
                                eu[er] = "Cast " + b.bt[dW] + " on";
                                et[er] = "@whi@" + cL[l2].b + s1;
                                ev[er] = 800;
                                ew[er] = cL[l2].e;
                                ex[er] = cL[l2].f;
                                ey[er] = cL[l2].c;
                                ez[er] = dW;
                                er++;
                                if(k5 == 0)
                                    continue; /* Loop/switch isn't completed */
                            }
                            if(dD >= 0)
                            {
                                eu[er] = "Use " + dE + " with";
                                et[er] = "@whi@" + cL[l2].b + s1;
                                ev[er] = 810;
                                ew[er] = cL[l2].e;
                                ex[er] = cL[l2].f;
                                ey[er] = cL[l2].c;
                                ez[er] = dD;
                                er++;
                                if(k5 == 0)
                                    continue; /* Loop/switch isn't completed */
                            }
                            if(i <= 0 || (cL[l2].f - 64) / bP + co + cs >= 2203)
                                break label3;
                            eu[er] = "Attack";
                            et[er] = "@whi@" + cL[l2].b + s1;
                            if(j4 >= 0 && j4 < 5)
                            {
                                ev[er] = 805;
                                if(k5 == 0)
                                    break label4;
                            }
                            ev[er] = 2805;
                        }
                        ew[er] = cL[l2].e;
                        ex[er] = cL[l2].f;
                        ey[er] = cL[l2].c;
                        er++;
                        if(k5 == 0)
                            break label2;
                    }
                    if(bq)
                    {
                        eu[er] = "Duel with";
                        et[er] = "@whi@" + cL[l2].b + s1;
                        ew[er] = cL[l2].e;
                        ex[er] = cL[l2].f;
                        ev[er] = 2806;
                        ey[er] = cL[l2].c;
                        er++;
                    }
                }
                eu[er] = "Trade with";
                et[er] = "@whi@" + cL[l2].b + s1;
                ev[er] = 2810;
                ey[er] = cL[l2].c;
                er++;
                eu[er] = "Follow";
                5[er] = "@whi@" + cL[l2].b + s1;
                ev[er] = 2820;
                ey[er] = cL[l2].c;
                er++;
                if(k5 == 0)
                    continue; /* Loop/switch isn't completed */
            }
            int l4;
label5:
            {
label6:
                {
                    if(k3 == 2)
                    {
                        if(dW >= 0)
                        {
                            if(b.bx[dW] != 3)
                                continue; /* Loop/switch isn't completed */
                            eu[er] = "Cast " + b.bt[dW] + " on";
                            et[er] = "@lre@" + b.c[dd[l2]];
                            ev[er] = 200;
                            ew[er] = db[l2];
                            ex[er] = dc[l2];
                            ey[er] = dd[l2];
                            ez[er] = dW;
                            er++;
                            if(k5 == 0)
                                continue; /* Loop/switch isn't completed */
                        }
                        if(dD >= 0)
                        {
                            eu[er] = "Use " + dE + " with";
                            et[er] = "@lre@" + b.c[dd[l2]];
                            ev[er] = 210;
                            ew[er] = db[l2];
                            ex[er] = dc[l2];
                            ey[er] = dd[l2];
                            ez[er] = dD;
                            er++;
                            if(k5 == 0)
                                continue; /* Loop/switch isn't completed */
                        }
                        eu[er] = "Take";
                        et[er] = "@lre@" + b.c[dd[l2]];
                        ev[er] = 220;
                        ew[er] = db[l2];
                        ex[er] = dc[l2];
                        ey[er] = dd[l2];
                        er++;
                        eu[er] = "Examine";
                        et[er] = "@lre@" + b.c[dd[l2]];
                        ev[er] = 3200;
                        ey[er] = dd[l2];
                        er++;
                        if(k5 == 0)
                            continue; /* Loop/switch isn't completed */
                    }
                    if(k3 != 3)
                        continue; /* Loop/switch isn't completed */
                    String s2 = "";
                    int k4 = -1;
                    l4 = cW[l2].g;
                    if(b.v[l4] > 0)
                    {
                        int i5 = (b.r[l4] + b.u[l4] + b.s[l4] + b.t[l4]) / 4;
                        int j5 = (dI[0] + dI[1] + dI[2] + dI[3] + 27) / 4;
                        k4 = j5 - i5;
                        s2 = "@yel@";
                        if(k4 < 0)
                            s2 = "@or1@";
                        if(k4 < -3)
                            s2 = "@or2@";
                        if(k4 < -6)
                            s2 = "@or3@";
                        if(k4 < -9)
                            s2 = "@red@";
                        if(k4 > 0)
                            s2 = "@gr1@";
                        if(k4 > 3)
                            s2 = "@gr2@";
                        if(k4 > 6)
                            s2 = "@gr3@";
                        if(k4 > 9)
                            s2 = "@gre@";
                        s2 = " " + s2 + "(level-" + i5 + ")";
                    }
                    if(dW >= 0)
                    {
                        if(b.bx[dW] != 2)
                            continue; /* Loop/switch isn't completed */
                        eu[er] = "Cast " + b.bt[dW] + " on";
                        et[er] = "@yel@" + b.o[cW[l2].g];
                        ev[er] = 700;
                        ew[er] = cW[l2].e;
                        ex[er] = cW[l2].f;
                        ey[er] = cW[l2].c;
                        ez[er] = dW;
                        er++;
                        if(k5 == 0)
                            continue; /* Loop/switch isn't completed */
                    }
                    if(dD >= 0)
                    {
                        eu[er] = "Use " + dE + " with";
                        et[er] = "@yel@" + b.o[cW[l2].g];
                        ev[er] = 710;
                        ew[er] = cW[l2].e;
                        ex[er] = cW[l2].f;
                        ey[er] = cW[l2].c;
                        ez[er] = dD;
                        er++;
                        if(k5 == 0)
                            continue; /* Loop/switch isn't completed */
                    }
                    if(b.v[l4] <= 0)
                        break label5;
                    eu[er] = "Attack";
                    et[er] = "@yel@" + b.o[cW[l2].g] + s2;
                    if(k4 >= 0)
                    {
                        ev[er] = 715;
                        if(k5 == 0)
                            break label6;
                    }
                    ev[er] = 2715;
                }
                ew[er] = cW[l2].e;
                ex[er] = cW[l2].f;
                ey[er] = cW[l2].c;
                er++;
            }
            eu[er] = "Talk-to";
            et[er] = "@yel@" + b.o[cW[l2].g];
            ev[er] = 720;
            ew[er] = cW[l2].e;
            ex[er] = cW[l2].f;
            ey[er] = cW[l2].c;
            er++;
            if(!b.q[l4].equals(""))
            {
                eu[er] = b.q[l4];
                et[er] = "@yel@" + b.o[cW[l2].g];
                ev[er] = 725;
                ew[er] = cW[l2].e;
                ex[er] = cW[l2].f;
                ey[er] = cW[l2].c;
                er++;
            }
            eu[er] = "Examine";
            et[er] = "@yel@" + b.o[cW[l2].g];
            ev[er] = 3700;
            ey[er] = cW[l2].g;
            er++;
            if(k5 == 0)
                continue; /* Loop/switch isn't completed */
        }
label7:
        {
            int i3;
label8:
            {
                if(f1 == null || f1.F < 10000)
                    break label7;
                i3 = f1.F - 10000;
                int l3 = dv[i3];
                if(dw[i3])
                    continue; /* Loop/switch isn't completed */
                if(dW >= 0)
                {
                    if(b.bx[dW] != 4)
                        break label8;
                    eu[er] = "Cast " + b.bt[dW] + " on";
                    et[er] = "@cya@" + b.bb[l3];
                    ev[er] = 300;
                    ew[er] = ds[i3];
                    ex[er] = dt[i3];
                    ey[er] = du[i3];
                    ez[er] = dW;
                    er++;
                    if(k5 == 0)
                        break label8;
                }
                if(dD >= 0)
                {
                    eu[er] = "Use " + dE + " with";
                    et[er] = "@cya@" + b.bb[l3];
                    ev[er] = 310;
                    ew[er] = ds[i3];
                    ex[er] = dt[i3];
                    ey[er] = du[i3];
                    ez[er] = dD;
                    er++;
                    if(k5 == 0)
                        break label8;
                }
                if(!b.bd[l3].equalsIgnoreCase("WalkTo"))
                {
                    eu[er] = b.bd[l3];
                    et[er] = "@cya@" + b.bb[l3];
                    ev[er] = 320;
                    ew[er] = ds[i3];
                    ex[er] = dt[i3];
                    ey[er] = du[i3];
                    er++;
                }
                if(!b.be[l3].equalsIgnoreCase("Examine"))
                {
                    eu[er] = b.be[l3];
                    et[er] = "@cya@" + b.bb[l3];
                    ev[er] = 2300;
                    ew[er] = ds[i3];
                    ex[er] = dt[i3];
                    ey[er] = du[i3];
                    er++;
                }
                eu[er] = "Examine";
                et[er] = "@cya@" + b.bb[l3];
                ev[er] = 3300;
                ey[er] = l3;
                er++;
            }
            dw[i3] = true;
            if(k5 == 0)
                continue; /* Loop/switch isn't completed */
        }
label9:
        {
            int j3;
label10:
            {
                if(f1 == null || f1.F < 0)
                    break label9;
                j3 = f1.F;
                int i4 = dk[j3];
                if(dn[j3])
                    continue; /* Loop/switch isn't completed */
                if(dW >= 0)
                {
                    if(b.bx[dW] != 5)
                        break label10;
                    eu[er] = "Cast " + b.bt[dW] + " on";
                    et[er] = "@cya@" + b.R[i4];
                    ev[er] = 400;
                    ew[er] = di[j3];
                    ex[er] = dj[j3];
                    ey[er] = dl[j3];
                    ez[er] = dk[j3];
                    eA[er] = dW;
                    er++;
                    if(k5 == 0)
                        break label10;
                }
                if(dD >= 0)
                {
                    eu[er] = "Use " + dE + " with";
                    et[er] = "@cya@" + b.R[i4];
                    ev[er] = 410;
                    ew[er] = di[j3];
                    ex[er] = dj[j3];
                    ey[er] = dl[j3];
                    ez[er] = dk[j3];
                    eA[er] = dD;
                    er++;
                    if(k5 == 0)
                        break label10;
                }
                if(!b.T[i4].equalsIgnoreCase("WalkTo"))
                {
                    eu[er] = b.T[i4];
                    et[er] = "@cya@" + b.R[i4];
                    ev[er] = 420;
                    ew[er] = di[j3];
                    ex[er] = dj[j3];
                    ey[er] = dl[j3];
                    ez[er] = dk[j3];
                    er++;
                }
                if(!b.U[i4].equalsIgnoreCase("Examine"))
                {
                    eu[er] = b.U[i4];
                    et[er] = "@cya@" + b.R[i4];
                    ev[er] = 2400;
                    ew[er] = di[j3];
                    ex[er] = dj[j3];
                    ey[er] = dl[j3];
                    ez[er] = dk[j3];
                    er++;
                }
                eu[er] = "Examine";
                et[er] = "@cya@" + b.R[i4];
                ev[er] = 3400;
                ey[er] = i4;
                er++;
            }
            dn[j3] = true;
            if(k5 == 0)
                continue; /* Loop/switch isn't completed */
        }
        if(j2 >= 0)
            j2 = f1.G[j2] - 0x30d40;
        if(j2 >= 0)
            i1 = j2;
        i2++;
_L8:
        if(i2 < l1) goto _L7; else goto _L9
_L9:
        if(dW >= 0 && b.bx[dW] <= 1)
        {
            eu[er] = "Cast " + b.bt[dW] + " on self";
            et[er] = "";
            ev[er] = 1000;
            ey[er] = dW;
            er++;
        }
        if(i1 != -1)
        {
            int k2 = i1;
            if(dW >= 0)
            {
                if(b.bx[dW] == 6)
                {
                    eu[er] = "Cast " + b.bt[dW] + " on ground";
                    et[er] = "";
                    ev[er] = 900;
                    ew[er] = cm.w[k2];
                    ex[er] = cm.x[k2];
                    ey[er] = dW;
                    er++;
                    return;
                }
            } else
            if(dD < 0)
            {
                eu[er] = "Walk here";
                et[er] = "";
                ev[er] = 920;
                ew[er] = cm.w[k2];
                ex[er] = cm.x[k2];
                er++;
            }
        }
        return;
    }

    public void bs()
    {
        int i;
        int j2;
        j2 = b.bN;
        if(bz == 0)
            break MISSING_BLOCK_LABEL_122;
        i = 0;
        if(j2 == 0) goto _L2; else goto _L1
_L1:
        int i1 = en + 2;
        int k1 = eo + 27 + i * 15;
        if(super.G <= i1 - 2 || super.H <= k1 - 12 || super.H >= k1 + 4 || super.G >= (i1 - 3) + ep)
            continue; /* Loop/switch isn't completed */
        f(eB[i]);
        if(j2 == 0)
            break; /* Loop/switch isn't completed */
        i++;
_L2:
        if(i < er) goto _L1; else goto _L3
_L3:
        bz = 0;
        em = false;
        return;
        if(super.G < en - 10 || super.H < eo - 10 || super.G > en + ep + 10 || super.H > eo + eq + 10)
        {
            em = false;
            return;
        }
        bO.a(en, eo, ep, eq, 0xd0d0d0, 160);
        bO.c("Choose option", en + 2, eo + 12, 1, 65535);
        i = 0;
        if(j2 == 0) goto _L5; else goto _L4
_L4:
        int j1 = en + 2;
        int l1 = eo + 27 + i * 15;
        int i2 = 0xffffff;
        if(super.G > j1 - 2 && super.H > l1 - 12 && super.H < l1 + 4 && super.G < (j1 - 3) + ep)
            i2 = 0xffff00;
        bO.c(eu[eB[i]] + " " + et[eB[i]], j1, l1, 1, i2);
        i++;
_L5:
        if(i >= er)
            return;
        if(true) goto _L4; else goto _L6
_L6:
    }

    public void bt() //called by ba()
    {
        int i;
        int k2;
        k2 = b.bN;
        if(dW >= 0 || dD >= 0)
        {
            eu[er] = "Cancel";
            et[er] = "";
            ev[er] = 4000;
            er++;
        }
        i = 0;
        if(k2 == 0) goto _L2; else goto _L1
_L1:
        eB[i] = i;
        i++;
_L2:
        if(i < er) goto _L1; else goto _L3
_L3:
        boolean flag = false;
        if(k2 == 0) goto _L5; else goto _L4
_L4:
        int i1;
        flag = true;
        i1 = 0;
        if(k2 == 0) goto _L7; else goto _L6
_L6:
        int j1 = eB[i1];
        int l1 = eB[i1 + 1];
        if(ev[j1] > ev[l1])
        {
            eB[i1] = l1;
            eB[i1 + 1] = j1;
            flag = false;
        }
        i1++;
_L7:
        if(i1 < er - 1) goto _L6; else goto _L5
_L5:
        if(!flag) goto _L4; else goto _L8
_L8:
        int k1;
        if(er > 20)
            er = 20;
        if(er <= 0)
            break MISSING_BLOCK_LABEL_829;
        i1 = -1;
        k1 = 0;
        if(k2 == 0) goto _L10; else goto _L9
_L9:
        if(et[eB[k1]] == null || et[eB[k1]].length() <= 0)
            continue; /* Loop/switch isn't completed */
        i1 = k1;
        if(k2 == 0)
            break; /* Loop/switch isn't completed */
        k1++;
_L10:
        if(k1 < er) goto _L9; else goto _L11
_L11:
        int i2;
        String s1 = null;
        if((dD >= 0 || dW >= 0) && er == 1)
            s1 = "Choose a target";
        else
        if((dD >= 0 || dW >= 0) && er > 1)
            s1 = "@whi@" + eu[eB[0]] + " " + et[eB[0]];
        else
        if(i1 != -1)
            s1 = et[eB[i1]] + ": @whi@" + eu[eB[0]];
        if(er == 2 && s1 != null)
            s1 = s1 + "@whi@ / 1 more option";
        if(er > 2 && s1 != null)
            s1 = s1 + "@whi@ / " + (er - 1) + " more options";
        if(s1 != null)
            bO.c(s1, 6, 14, 1, 0xffff00);
        if(!ek && bz == 1 || ek && bz == 1 && er == 1)
        {
            f(eB[0]);
            bz = 0;
            return;
        }
        if((ek || bz != 2) && (!ek || bz != 1))
            break MISSING_BLOCK_LABEL_829;
        eq = (er + 1) * 15;
        ep = bO.a("Choose option", 1) + 5;
        i2 = 0;
        if(k2 == 0) goto _L13; else goto _L12
_L12:
        int j2 = bO.a(eu[i2] + " " + et[i2], 1) + 5;
        if(j2 > ep)
            ep = j2;
        i2++;
_L13:
        if(i2 < er) goto _L12; else goto _L14
_L14:
        en = super.G - ep / 2;
        eo = super.H - 7;
        em = true;
        if(en < 0)
            en = 0;
        if(eo < 0)
            eo = 0;
        if(en + ep > 510)
            en = 510 - ep;
        if(eo + eq > 315)
            eo = 315 - eq;
        bz = 0;
    }

    public void f(int i)
    {
        int i1 = ew[i];
        int j1 = ex[i];
        int k1 = ey[i];
        int l1 = ez[i];
        int i2 = eA[i];
        int j2 = ev[i];
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
        byte abyte0[];
        int i1;
        int j1;
        byte abyte1[];
        int k1;
        if(!bw)
            s1 = "../release/" + s1;
        abyte0 = link.getjag(s1);
        if(abyte0 == null)
            break MISSING_BLOCK_LABEL_204;
        i1 = ((abyte0[0] & 0xff) << 16) + ((abyte0[1] & 0xff) << 8) + (abyte0[2] & 0xff);
        j1 = ((abyte0[3] & 0xff) << 16) + ((abyte0[4] & 0xff) << 8) + (abyte0[5] & 0xff);
        abyte1 = new byte[abyte0.length - 6];
        k1 = 0;
        if(b.bN == 0) goto _L2; else goto _L1
_L1:
        abyte1[k1] = abyte0[k1 + 6];
        k1++;
_L2:
        if(k1 < abyte0.length - 6) goto _L1; else goto _L3
_L3:
        b(i, "Unpacking " + s2);
        if(j1 != i1)
        {
            byte abyte2[] = new byte[i1];
            a.b.a(abyte2, i1, abyte1, j1, 0);
            return abyte2;
        } else
        {
            return abyte1;
        }
        return super.a(s1, s2, i);
    }

    public int j()
    {
        return link.uid;
    }

    public Graphics getGraphics()
    {
        if(a.g != null)
            return a.g.getGraphics();
        if(link.mainapp != null)
            return link.mainapp.getGraphics();
        else
            return super.getGraphics();
    }

    public Image createImage(int i, int i1)
    {
        if(a.g != null)
            return a.g.createImage(i, i1);
        if(link.mainapp != null)
            return link.mainapp.createImage(i, i1);
        else
            return super.createImage(i, i1);
    }

    public URL getCodeBase()
    {
        if(link.mainapp != null)
            return link.mainapp.getCodeBase();
        else
            return super.getCodeBase();
    }

    public URL getDocumentBase()
    {
        if(link.mainapp != null)
            return link.mainapp.getDocumentBase();
        else
            return super.getDocumentBase();
    }

    public String getParameter(String s1)
    {
        if(link.mainapp != null)
            return link.mainapp.getParameter(s1);
        else
            return super.getParameter(s1);
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

    public void a(Runnable runnable) //called from init()
    {
        if(link.mainapp != null)
        {
            link.startthread(runnable);
            return;
        } else
        {
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            thread.start();
            return;
        }
    }

    public String g(int i)
    {
        if(link.mainapp != null)
            return link.gethostname(a.f.a(i));
        else
            return a.f.a(i);
    }

    public mudclient()
    {
        int i = b.bN;
        super();
        bq = false;
        br = new BigInteger("18439792161837834709");
        bs = new BigInteger("192956484481579778191558061814292671521");
        bt = false;
        bu = false;
        bv = false;
        bw = true;
        by = 0xbc614e;
        bA = 8000;
        bB = new int[bA];
        bC = new int[bA];
        bE = new int[8192];
        bF = new int[8192];
        bH = 2;
        bJ = 2;
        bP = 128;
        bR = 512;
        bS = 334;
        bT = 9;
        cb = 40;
        cg = -1;
        ch = -1;
        ci = -1;
        cq = -1;
        ct = -1;
        cy = 550;
        cz = false;
        cC = 1;
        cE = 128;
        cF = 4000;
        cG = 500;
        cK = new c[cF];
        cL = new c[cG];
        cM = new c[cG];
        cN = new c();
        cQ = -1;
        cR = 5000;
        cS = 500;
        cV = new c[cR];
        cW = new c[cS];
        cX = new c[cS];
        cY = new int[500];
        cZ = 5000;
        db = new int[cZ];
        dc = new int[cZ];
        dd = new int[cZ];
        de = new int[cZ];
        df = 1500;
        dh = new f[df];
        di = new int[df];
        dj = new int[df];
        dk = new int[df];
        dl = new int[df];
        dm = new f[1000];
        dn = new boolean[df];
        dp = 500;
        dr = new f[dp];
        ds = new int[dp];
        dt = new int[dp];
        du = new int[dp];
        dv = new int[dp];
        dw = new boolean[dp];
        dy = 30;
        dA = new int[35];
        dB = new int[35];
        dC = new int[35];
        dD = -1;
        dE = "";
        dF = new int[99];
        dH = new int[18];
        dI = new int[18];
        dJ = new int[18];
        dK = new int[5];
        dW = -1;
        ee = 50;
        eg = new boolean[ee];
        eh = new boolean[50];
        ei = false;
        ej = true;
        ek = false;
        el = false;
        em = false;
        es = 250;
        et = new String[es];
        eu = new String[es];
        ev = new int[es];
        ew = new int[es];
        ex = new int[es];
        ey = new int[es];
        ez = new int[es];
        eA = new int[es];
        eB = new int[es];
        eM = 5;
        eN = new String[eM];
        eO = new int[eM];
        eP = false;
        eQ = "";
        eS = new int[8];
        eT = new int[8];
        eV = new int[8];
        eW = new int[8];
        eX = false;
        eY = false;
        eZ = false;
        fa = false;
        fb = false;
        fc = false;
        fd = false;
        fe = false;
        fh = new int[8];
        fi = new int[8];
        fk = new int[8];
        fl = new int[8];
        fq = false;
        fr = "";
        ft = new int[14];
        fu = new int[14];
        fw = new int[14];
        fx = new int[14];
        fy = false;
        fz = false;
        fD = false;
        fE = false;
        fG = new int[14];
        fH = new int[14];
        fJ = new int[14];
        fK = new int[14];
        fL = false;
        fO = new int[256];
        fP = new int[256];
        fQ = new int[256];
        fR = -1;
        fS = -2;
        fT = false;
        fV = new int[256];
        fW = new int[256];
        fY = new int[256];
        fZ = new int[256];
        ga = -1;
        gb = -2;
        gc = 48;
        ge = false;
        gg = new String[5];
        gm = "";
        gn = "";
        go = false;
        gp = false;
        gv = false;
        gw = false;
        gx = "";
        gC = false;
        gW = "";
        gX = "";
        gY = "";
        gZ = "";
        ho = false;
        hs = -1;
        ht = new int[5];
        hu = new int[5];
        hv = new int[5];
        hw = new int[5];
        hy = new String[5];
        hz = false;
        hI = new int[5];
        hJ = new int[5];
        hK = false;
        hT = new String[50];
        hU = new int[50];
        hV = new int[50];
        hW = new int[50];
        hX = new int[50];
        hZ = new int[50];
        ia = new int[50];
        ib = new int[50];
        ic = new int[50];
        ie = new int[50];
        ig = new int[50];
        ih = new int[50];
        il = false;
        in = 1;
        io = 2;
        ip = 2;
        iq = 8;
        ir = 14;
        it = 1;
        iD = new int[50];
        iE = new int[50];
        iF = new int[50];
        iG = new int[50];
        iH = false;
        if(i != 0)
        {
            int i1 = a.f.c;
            a.f.c = ++i1;
        }
    }
}