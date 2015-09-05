import java.awt.*;
import java.net.*;
import java.io.*;
import java.util.*; 

public final class mudclient extends aaa
{
public int xrotate = 912; 
int canDraw = 1;
public int serv;
public int SleepFat = 95;
public String server; 
public int npcid;
public int npcid2 = -2;
public int npcid3 = -2;
public int foodID = 373;
public int EatAtHP = 0;
boolean autoEating = false;
boolean isSleeping = false;
boolean autoFighter = false;
boolean autoSleep = false;
boolean autoFight;
public int MacroTime = 200;
boolean FightMenu = true;   
public int styleCnt = 1;
public int lockedStyleCnt;
boolean showhp = false;
public int CoordX = 0;
public int CoordY = 0;
public boolean walkBack = false;
private AutoEat AE;
private resetmacro rmacro;
boolean EApause = false;
boolean donkey;
int world;
int time;
private AutoThieve AT;
boolean autoThiever = false;

   private class AutoThieve extends Thread {
        public void run()
        {
	   	while(autoThiever)
	   	{
	   	if(!EApause)
	   	{
	   	if(dig != lockedStyleCnt) {
	   		SetFMode(lockedStyleCnt);
	   	}
		if(AutoThieve(getnpcindexbyid(npcid,npcid2,npcid3))) {
			Wait(MacroTime);
		} else {
			Wait(1);
			if(walkBack && SelfIsFighting())
                         {
                         WalkTo(CoordX,CoordY);
                         Wait(1);
                         }	
		         }
	       }
	       Wait(1);
	       }
	       Wait(1);         	         
        }
        
        AutoThieve()
        {
            start();
        }
    }

	public boolean AutoThieve(int i) 
 	{	
 		if(i != -1 && i < NPCCount()  && !SelfIsFighting() && !isSleeping) {
         		 	ThieveNPC(i);
         			return true;
        		} else {
         			return false;
         		}
	}


     public void ThieveNPC(int i)
    {
        eka[0] = 725;
        eec[0] = eai[i].had;
        eed[0] = eai[i].hae;
        dfd[0] = eai[i].hab;
        fem(0);       
    }

public int getX()
{
    return eme + egj;
}

public int getY()
{
    return emf + egk;
}

   public void WalkTo(int x, int y)
    {
        try
        {
            if((x != (eme + egj)|| y != (emf + egk)) && ehc == 1)
            {
                eec[0] = x - egj;
                eed[0] = y - egk;
                dfd[0] = 0;
                dfe[0] = 0;
                dff[0] = 0;
                eka[0] = 920;
                fem(0);
                Thread.sleep(100);
            }
        }
        catch(Exception exception){}
    } 	

    private class AutoEat extends Thread 
    {
        public void run()
        {
            while(autoEating)
            {  
               if(egd[3] <= EatAtHP && !SelfIsFighting()) 
               {
                  if(fec(foodID) > 0)
		   {
                      EApause = true;
                      useitem(foodID);
                      Wait(1500);
                      EApause = false;
                      
                   }
                   else
                   {
                      adh("OMG No more Food!");
                      autoEating = false;
                      autoFighter = false;
                      autoThiever = false;
                      Wait(50);
                   }
               }
               if(egd[3] <= EatAtHP && SelfIsFighting())
               {
               if(fec(foodID) > 0)
               {
                  	 if(walkBack)
                         {
                         WalkTo(CoordX,CoordY);
                         Wait(500);
                         EApause = true;
                         }
               }
               else
                   {
                      adh("OMG No more Food!");
                      autoEating = false;
                      autoFighter = false;
                      autoThiever = false;
                      Wait(50);
                   }     
               } 
               Wait(50);
            }
        }
        
        AutoEat()
        {
            start();
        }
    }

public boolean AttackNPC(int i)
{
    if(!SelfIsFighting() && !isSleeping)
    {
       fdl(eme, emf, (eai[i].had - 64) / ehb, (eai[i].hae - 64) / ehb, true);
       super.aah.hfj(118);
       super.aah.hen(eai[i].hab);
       super.aah.hff();
       return true;
    }
    else
       return false;
}  

public void Wait(int ms)
{
    try{Thread.sleep(ms);}
    catch(Exception exception){}
}

public boolean SelfIsFighting()
{
   return emd.hah == 8 || emd.hah == 9;
}

public int NPCCount()
{
   return emi;
}

    public int getnpcindexbyid(int id,int id2,int id3)
    {
        int minj = -1;
        int min = 9999999;
        for(int j = 0; j < emi; j++)
            if((eai[j].haf == id || eai[j].haf == id2 || eai[j].haf == id3)&& eai[j].hah != 8 && eai[j].hah != 9)
            {
                int temp = (int)Math.sqrt((eai[j].had-emd.had)*(eai[j].had-emd.had)) + (int)Math.sqrt((eai[j].hae-emd.hae)*(eai[j].hae-emd.hae));
                if(temp < min)
                {
                    minj = j;
                    min = temp;
                }
            }
        return minj;
    }

private class resetmacro extends Thread
{
public void run()
{
adh("Autofighter reset");
autoFighter = false;
try{Thread.sleep(2000);}
catch(InterruptedException _ex) { }
autoFighter = true;
lockedStyleCnt = styleCnt;
AF.run();
}
resetmacro()
{
start();
}
}

public void reset()
{
if(!SelfIsFighting() && autoFighter)
rmacro = new resetmacro();
}

public void loadreset()
{
rmacro = new resetmacro();
}

private class AutoFight extends Thread 
{
    public void run()
    {
              while(autoFighter)
              {
	      if(!EApause)
	      {
              if(dig != lockedStyleCnt) 
              {
	   	 SetFMode(lockedStyleCnt);
              }
	      while(ehc == 0)
              {
                 try
                 {
                     elh = 2;
                     Thread.sleep(100);
                     aca(djk, djl, false);
                     Thread.sleep(1000);      
}
                   catch(Exception exception){}
              }
            if(!SelfIsFighting())
            {
                int i = getnpcindexbyid(npcid,npcid2,npcid3);
                if(i != -1 && !SelfIsFighting() && ehc == 1)
                {
                    try
                    {
                    AttackNPC(i); 
                    Wait(MacroTime);
                    }
                    catch(Exception exception){reset();}
                }   
                else 
                {
                   Wait(1);
                if(walkBack)
                {
                   WalkTo(CoordX,CoordY);
                   Wait(500);
                }
                }   
            }		
            else
               Wait(1);
            }
            Wait(1);
            }
            Wait(1);
        }
    AutoFight()
    {
        start();
    }
}

public void useitem(int i)
{
   for(int j = 0; j < dka.length; j++)
   if(dka[j] == i)
   {
      super.aah.hfj(24);
      super.aah.hen(j);
      super.aah.hff();
      return;
   }
} 

public void prayeron(int i)
{
   super.aah.hfj(202);
   super.aah.hfa(i);
   super.aah.hff();
   dia[i] = true;
   faj("prayeron");
}  

public void prayeroff(int i)
{
   super.aah.hfj(162);
   super.aah.hfa(i);
   super.aah.hff();
   dia[i] = false;
   faj("prayeroff");
} 

public void changeworld(int i)
{
   if(i == 81)
   {
      world = 81;
      super.aad = "ul3.runescape.com";
      super.aae = 43594;
   }else
      if(i == 82)
      {
          world = 82;
          super.aad = "217.138.31.250";
          super.aae = 43595;
      }else
         if(i == 83)
         {
            world = 83;
            super.aad = "ul3.runescape.com";
            super.aae = 43594;
         }else
         if(i == 84)
	 {
	    world = 84;
	    super.aad = "209.237.251.20";         
	    super.aae = 43595;   
	 }else
            if(i == 85)
            {
               world = 85;
               super.aad = "69.22.158.236";
               super.aae = 43594;
            }else
            if(i == 86)
	    {
	       world = 86;
               super.aad = "69.22.158.236";
               super.aae = 43595;
                  }
          }
    public void SetFMode(int i)
    {
                dig = i;
                super.aah.hfj(74);
                super.aah.hfa(dig);
                super.aah.hff();
                styleCnt = dig;
     } 
    public void NewSession()
    {
                SetFMode(styleCnt);
     }
     public static final void main(String args[])
	  {
        mudclient mudclient1 = new mudclient();
        mudclient1.dje = false;
        if(args.length > 0 && args[0].equals("members"))
            mudclient1.emh = false;
        if(args.length > 1)
            mudclient1.aad = args[1];
        if(args.length > 2)
            mudclient1.aae = Integer.parseInt(args[2]);
        mudclient1.fme(mudclient1.dmj, mudclient1.dmk + 11, "RuinBot by Khain and antiyou - updated by Rich Lil Nigg", false);
        mudclient1.flf = 10;
    }
private final void enf()
    {
        efh.gje = fbm("maps" + cff.cfj + ".jag", "map", 70);
        if(emh)
            efh.gjn = fbm("maps" + cff.cfj + ".mem", "members map", 75);
        efh.gjd = fbm("land" + cff.cfj + ".jag", "landscape", 80);
        if(emh)
            efh.gjm = fbm("land" + cff.cfj + ".mem", "members landscape", 85);
    }

    protected final void acc()
    {
        eee = 0;
        if(ecj != 0)
        {
            ade();
            return;
        } else
        {
            super.acc();
            return;
        }
}

    private final void eng()
    {
        ebc = new gca(dki, 100);
        ebc.ggj(256, 10, "Please design Your Character", 4, true);
        int i = 140;
        int j = 34;
        i += 116;
        j -= 10;
        ebc.ggj(201, 134, "Front", 3, true);
        ebc.ggj(256, 134, "Side", 3, true);
        ebc.ggj(311, 134, "Back", 3, true);
        byte byte0 = 54;
        j += 145;
        ebc.ggl(202, 169, 53, 41);
        ebc.ggj(202, 161, "Head", 1, true);
        ebc.ggj(202, 177, "Type", 1, true);
        ebc.ggm(162, 169, gca.gfa + 7);
        eeg = ebc.ghd(162, 169, 20, 20);
        ebc.ggm(242, 169, gca.gfa + 6);
        eeh = ebc.ghd(242, 169, 20, 20);
        ebc.ggl(310, 169, 53, 41);
        ebc.ggj(310, 161, "Hair", 1, true);
        ebc.ggj(310, 177, "Color", 1, true);
        ebc.ggm(270, 169, gca.gfa + 7);
        eei = ebc.ghd(270, 169, 20, 20);
        ebc.ggm(350, 169, gca.gfa + 6);
        eej = ebc.ghd(350, 169, 20, 20);
        j += 50;
        ebc.ggl(202, 219, 53, 41);
        ebc.ggj(202, 219, "Gender", 1, true);
        ebc.ggm(162, 219, gca.gfa + 7);
        eek = ebc.ghd(162, 219, 20, 20);
        ebc.ggm(242, 219, gca.gfa + 6);
        eel = ebc.ghd(242, 219, 20, 20);
        ebc.ggl(310, 219, 53, 41);
        ebc.ggj(310, 211, "Top", 1, true);
        ebc.ggj(310, 227, "Color", 1, true);
        ebc.ggm(270, 219, gca.gfa + 7);
        eem = ebc.ghd(270, 219, 20, 20);
        ebc.ggm(350, 219, gca.gfa + 6);
        een = ebc.ghd(350, 219, 20, 20);
        j += 50;
        ebc.ggl(202, 269, 53, 41);
        ebc.ggj(202, 261, "Skin", 1, true);
        ebc.ggj(202, 277, "Color", 1, true);
        ebc.ggm(162, 269, gca.gfa + 7);
        efa = ebc.ghd(162, 269, 20, 20);
        ebc.ggm(242, 269, gca.gfa + 6);
        efb = ebc.ghd(242, 269, 20, 20);
        ebc.ggl(310, 269, 53, 41);
        ebc.ggj(310, 261, "Bottom", 1, true);
        ebc.ggj(310, 277, "Color", 1, true);
        ebc.ggm(270, 269, gca.gfa + 7);
        efc = ebc.ghd(270, 269, 20, 20);
        ebc.ggm(350, 269, gca.gfa + 6);
        efd = ebc.ghd(350, 269, 20, 20);
        j += 82;
        j -= 35;
        ebc.ggk(256, 316, 200, 30);
        ebc.ggj(256, 316, "Accept", 4, false);
        efe = ebc.ghd(256, 316, 200, 30);
    }

    private final void enh(boolean flag)
    {
        boolean flag1 = false;
        int i = ((blm) (dki)).bln - 199;
        int j = 36;
        dki.cci(i - 49, 3, eie + 3);
        char c = '\304';
        char c1 = '\u0113';
        int l;
        int k = l = 0xdfaffdf;
        if(dga == 0)
            k = 0x000000;
        else
            l = 0x000000;
        dki.cbf(i, 36, 98, 24, k, 128);
        dki.cbf(i + 98, 36, 98, 24, l, 128);
        dki.cbf(i, 60, 196, 251, 0x000000, 128);
        dki.cbj(i, 60, 196, 0);
        dki.cbk(i + 98, 36, 24, 0);
        dki.cee("Stats", i + 49, 52, 4, 0xdfaffdf);
        dki.cee("Quests", i + 49 + 98, 52, 4, 0xdfaffdf);
        if(dga == 0)
        {
            int i1 = 72;
            int k1 = -1;
            dki.ceg("Skills", i + 5, 72, 3, 0xffff00);
            i1 += 13;
            for(int l1 = 0; l1 < 9; l1++)
            {
                int i2 = 0xffffff;
                if(super.flg > i + 3 && super.flh >= i1 - 11 && super.flh < i1 + 2 && super.flg < i + 90)
                {
                    i2 = 0xff0000;
                    k1 = l1;
                }
                dki.ceg(end[l1] + ":@yel@" + egd[l1] + "/" + dmc[l1], i + 5, i1, 1, i2);
                i2 = 0xffffff;
                if(super.flg >= i + 90 && super.flh >= i1 - 13 - 11 && super.flh < (i1 - 13) + 2 && super.flg < i + 196)
                {
                    i2 = 0xff0000;
                    k1 = l1 + 9;
                }
                dki.ceg(end[l1 + 9] + ":@yel@" + egd[l1 + 9] + "/" + dmc[l1 + 9], (i + 98) - 5, i1 - 13, 1, i2);
                i1 += 13;
            }

            dki.ceg("Quest Points:@yel@" + efn, (i + 98) - 5, i1 - 13, 1, 0xffffff);
            i1 += 12;
            dki.ceg("Fatigue: @yel@" + (ejh * 100) / 750 + "%", i + 5, i1 - 13, 1, 0xffffff);
            i1 += 8;
            dki.ceg("Equipment Status", i + 5, i1, 3, 0xffff00);
            i1 += 12;
            for(int j2 = 0; j2 < 3; j2++)
            {
                dki.ceg(emm[j2] + ":@yel@" + dfa[j2], i + 5, i1, 1, 0xffffff);
                if(j2 < 2)
                    dki.ceg(emm[j2 + 3] + ":@yel@" + dfa[j2 + 3], i + 98 + 25, i1, 1, 0xffffff);
                i1 += 13;
            }

            i1 += 6;
            dki.cbj(i, i1 - 15, 196, 0);
            if(k1 != -1)
            {
                dki.ceg(ebb[k1] + " skill", i + 5, i1, 1, 0xffff00);
                i1 += 12;
                int k2 = dkj[0];
                for(int i3 = 0; i3 < 98; i3++)
                    if(emk[k1] >= dkj[i3])
                        k2 = dkj[i3 + 1];

                dki.ceg("Total xp: " + emk[k1] / 4, i + 5, i1, 1, 0xffffff);
                i1 += 12;
                dki.ceg("Next level at: " + k2 / 4, i + 5, i1, 1, 0xffffff);
            } else
            {
                dki.ceg("Overall levels", i + 5, i1, 1, 0xffff00);
                i1 += 12;
                int l2 = 0;
                for(int j3 = 0; j3 < 18; j3++)
                    l2 += dmc[j3];

                dki.ceg("Skill total: " + l2, i + 5, i1, 1, 0xffffff);
                i1 += 12;
                dki.ceg("Combat level: " + emd.hbi, i + 5, i1, 1, 0xffffff);
                i1 += 12;
            }
        }
        if(dga == 1)
        {
            dfm.ghe(dfn);
            dfm.ghg(dfn, 0, "@whi@Quest-list (yellow=completed)");
            for(int j1 = 0; j1 < 50; j1++)
                dfm.ghg(dfn, j1 + 1, (ein[j1] ? "@yel@" : "@gre@") + djj[j1]);

            dfm.gfj();
        }
        if(!flag)
            return;
        i = super.flg - (((blm) (dki)).bln - 199);
        j = super.flh - 36;
        if(i >= 0 && j >= 0 && i < 196 && j < 275)
        {
            if(dga == 1)
                dfm.gfg(i + (((blm) (dki)).bln - 199), j + 36, super.flj, super.fli);
            if(j <= 24 && elf == 1)
            {
                if(i < 98)
                {
                    dga = 0;
                    return;
                }
                if(i > 98)
                    dga = 1;
            }
        }
    }

    protected final void adg(int i, int j, byte abyte0[])
    {
        boolean flag4 = false;
        try
        {
            if(i == 141)
            {
                eke = ekd;
                for(int k = 0; k < eke; k++)
                    dhn[k] = dhe[k];

                int k7 = 8;
                eme = fnf.gad(abyte0, 8, 11);
                k7 += 11;
                emf = fnf.gad(abyte0, 19, 13);
                k7 += 13;
                int l13 = fnf.gad(abyte0, 32, 4);
                k7 += 4;
                boolean flag1 = fan(eme, emf);
                eme -= egj;
                emf -= egk;
                int l22 = eme * ehb + 64;
                int l25 = emf * ehb + 64;
                if(flag1)
                {
                    emd.hak = 0;
                    emd.haj = 0;
                    emd.had = emd.hal[0] = l22;
                    emd.hae = emd.ham[0] = l25;
                }
                ekd = 0;
                emd = fce(emg, l22, l25, l13);
                int i29 = fnf.gad(abyte0, 36, 8);
                k7 += 8;
                for(int l33 = 0; l33 < i29; l33++)
                {
                    gnm gnm4 = dhn[l33 + 1];
                    int k39 = fnf.gad(abyte0, k7, 1);
                    k7++;
                    if(k39 != 0)
                    {
                        int k41 = fnf.gad(abyte0, k7, 1);
                        k7++;
                        if(k41 == 0)
                        {
                            int l42 = fnf.gad(abyte0, k7, 3);
                            k7 += 3;
                            int l43 = gnm4.hak;
                            int j44 = gnm4.hal[l43];
                            int k44 = gnm4.ham[l43];
                            if(l42 == 2 || l42 == 1 || l42 == 3)
                                j44 += ehb;
                            if(l42 == 6 || l42 == 5 || l42 == 7)
                                j44 -= ehb;
                            if(l42 == 4 || l42 == 3 || l42 == 5)
                                k44 += ehb;
                            if(l42 == 0 || l42 == 1 || l42 == 7)
                                k44 -= ehb;
                            gnm4.hai = l42;
                            gnm4.hak = l43 = (l43 + 1) % 10;
                            gnm4.hal[l43] = j44;
                            gnm4.ham[l43] = k44;
                        } else
                        {
                            int i43 = fnf.gad(abyte0, k7, 4);
                            if((i43 & 0xc) == 12)
                            {
                                k7 += 2;
                                continue;
                            }
                            gnm4.hai = fnf.gad(abyte0, k7, 4);
                            k7 += 4;
                        }
                    }
                    dhe[ekd++] = gnm4;
                }

                int i37 = 0;
                while(k7 + 24 < j * 8) 
                {
                    int l39 = fnf.gad(abyte0, k7, 11);
                    k7 += 11;
                    int l41 = fnf.gad(abyte0, k7, 5);
                    k7 += 5;
                    if(l41 > 15)
                        l41 -= 32;
                    int j43 = fnf.gad(abyte0, k7, 5);
                    k7 += 5;
                    if(j43 > 15)
                        j43 -= 32;
                    int i14 = fnf.gad(abyte0, k7, 4);
                    k7 += 4;
                    int i44 = fnf.gad(abyte0, k7, 1);
                    k7++;
                    int i23 = (eme + l41) * ehb + 64;
                    int i26 = (emf + j43) * ehb + 64;
                    fce(l39, i23, i26, i14);
                    if(i44 == 0)
                        dnj[i37++] = l39;
                }
                if(i37 > 0)
                {
                    super.aah.hfj(241);
                    super.aah.hen(i37);
                    for(int i40 = 0; i40 < i37; i40++)
                    {
                        gnm gnm5 = egm[dnj[i40]];
                        super.aah.hen(gnm5.hab);
                        super.aah.hen(gnm5.hac);
                    }

                    super.aah.hff();
                    i37 = 0;
                }
                return;
            }
            if(i == 172)
            {
                for(int l = 1; l < j;)
                    if(fnf.fnl(abyte0[l]) == 255)
                    {
                        int l7 = 0;
                        int j14 = eme + abyte0[l + 1] >> 3;
                        int i19 = emf + abyte0[l + 2] >> 3;
                        l += 3;
                        for(int j23 = 0; j23 < egh; j23++)
                        {
                            int j26 = (dgj[j23] >> 3) - j14;
                            int j29 = (dgk[j23] >> 3) - i19;
                            if(j26 != 0 || j29 != 0)
                            {
                                if(j23 != l7)
                                {
                                    dgj[l7] = dgj[j23];
                                    dgk[l7] = dgk[j23];
                                    dgl[l7] = dgl[j23];
                                    dgm[l7] = dgm[j23];
                                }
                                l7++;
                            }
                        }

                        egh = l7;
                    } else
                    {
                        int i8 = fnf.fnm(abyte0, l);
                        l += 2;
                        int k14 = eme + abyte0[l++];
                        int j19 = emf + abyte0[l++];
                        if((i8 & 0x8000) == 0)
                        {
                            dgj[egh] = k14;
                            dgk[egh] = j19;
                            dgl[egh] = i8;
                            dgm[egh] = 0;
                            for(int k23 = 0; k23 < dln; k23++)
                            {
                                if(ecb[k23] != k14 || ecc[k23] != j19)
                                    continue;
                                dgm[egh] = ahd.akn[ecd[k23]];
                                break;
                            }

                            egh++;
                        } else
                        {
                            i8 &= 0x7fff;
                            int l23 = 0;
                            for(int k26 = 0; k26 < egh; k26++)
                                if(dgj[k26] != k14 || dgk[k26] != j19 || dgl[k26] != i8)
                                {
                                    if(k26 != l23)
                                    {
                                        dgj[l23] = dgj[k26];
                                        dgk[l23] = dgk[k26];
                                        dgl[l23] = dgl[k26];
                                        dgm[l23] = dgm[k26];
                                    }
                                    l23++;
                                } else
                                {
                                    i8 = -123;
                                }

                            egh = l23;
                        }
                    }

                return;
            }
            if(i == 158)
            {
                for(int i1 = 1; i1 < j;)
                    if(fnf.fnl(abyte0[i1]) == 255)
                    {
                        int j8 = 0;
                        int l14 = eme + abyte0[i1 + 1] >> 3;
                        int k19 = emf + abyte0[i1 + 2] >> 3;
                        i1 += 3;
                        for(int i24 = 0; i24 < dln; i24++)
                        {
                            int l26 = (ecb[i24] >> 3) - l14;
                            int k29 = (ecc[i24] >> 3) - k19;
                            if(l26 != 0 || k29 != 0)
                            {
                                if(i24 != j8)
                                {
                                    egn[j8] = egn[i24];
                                    egn[j8].cig = j8;
                                    ecb[j8] = ecb[i24];
                                    ecc[j8] = ecc[i24];
                                    ecd[j8] = ecd[i24];
                                    ece[j8] = ece[i24];
                                }
                                j8++;
                            } else
                            {
                                dkm.bhe(egn[i24]);
                                efh.glc(ecb[i24], ecc[i24], ecd[i24]);
                            }
                        }

                        dln = j8;
                    } else
                    {
                        int k8 = fnf.fnm(abyte0, i1);
                        i1 += 2;
                        int i15 = eme + abyte0[i1++];
                        int l19 = emf + abyte0[i1++];
                        int j24 = 0;
                        for(int i27 = 0; i27 < dln; i27++)
                            if(ecb[i27] != i15 || ecc[i27] != l19)
                            {
                                if(i27 != j24)
                                {
                                    egn[j24] = egn[i27];
                                    egn[j24].cig = j24;
                                    ecb[j24] = ecb[i27];
                                    ecc[j24] = ecc[i27];
                                    ecd[j24] = ecd[i27];
                                    ece[j24] = ece[i27];
                                }
                                j24++;
                            } else
                            {
                                dkm.bhe(egn[i27]);
                                efh.glc(ecb[i27], ecc[i27], ecd[i27]);
                            }

                        dln = j24;
                        if(k8 != 60000)
                        {
                            int l29 = efh.glb(i15, l19);
                            int i34;
                            int j37;
                            if(l29 == 0 || l29 == 4)
                            {
                                i34 = ahd.akk[k8];
                                j37 = ahd.akl[k8];
                            } else
                            {
                                j37 = ahd.akk[k8];
                                i34 = ahd.akl[k8];
                            }
                            int j40 = ((i15 + i15 + i34) * ehb) / 2;
                            int i42 = ((l19 + l19 + j37) * ehb) / 2;
                            int k43 = ahd.akj[k8];
                            cgc cgc2 = dli[k43].daf();
                            dkm.bhd(cgc2);
                            cgc2.cig = dln;
                            cgc2.cne(0, l29 * 32, 0);
                            cgc2.cng(j40, -efh.gme(j40, i42), i42);
                            cgc2.cna(true, 48, 48, -50, -10, -50);
                            efh.gna(i15, l19, k8);
                            if(k8 == 74)
                                cgc2.cng(0, -480, 0);
                            ecb[dln] = i15;
                            ecc[dln] = l19;
                            ecd[dln] = k8;
                            ece[dln] = l29;
                            egn[dln++] = cgc2;
                        }
                    }

                return;
            }
            if(i == 37)
            {
                int j1 = 1;
                j1++;
                djn = abyte0[1] & 0xff;
                for(int l8 = 0; l8 < djn; l8++)
                {
                    int j15 = fnf.fnm(abyte0, j1);
                    j1 += 2;
                    dka[l8] = j15 & 0x7fff;
                    dkc[l8] = j15 / 32768;
                    if(ahd.ahl[j15 & 0x7fff] == 0)
                    {
                        dkb[l8] = fnf.gac(abyte0, j1);
                        if(dkb[l8] >= 128)
                            j1 += 4;
                        else
                            j1++;
                    } else
                    {
                        dkb[l8] = 1;
                    }
                }

                return;
            }
            if(i == 183)
            {
                int k1 = fnf.fnm(abyte0, 1);
                int i9 = 3;
                for(int k15 = 0; k15 < k1; k15++)
                {
                    int i20 = fnf.fnm(abyte0, i9);
                    i9 += 2;
                    gnm gnm1 = egm[i20];
                    byte byte6 = abyte0[i9];
                    i9++;
                    if(byte6 == 0)
                    {
                        int i30 = fnf.fnm(abyte0, i9);
                        i9 += 2;
                        if(gnm1 != null)
                        {
                            gnm1.hbd = 150;
                            gnm1.hbc = i30;
                        }
                    } else
                    if(byte6 == 1)
                    {
                        byte byte7 = abyte0[i9];
                        i9++;
                        if(gnm1 != null)
                        {
                            String s2 = ffn.fhe(cen.cfd(abyte0, i9, byte7));
                            boolean flag3 = false;
                            for(int k40 = 0; k40 < super.aba; k40++)
                                if(super.abb[k40] == gnm1.gnn)
                                    flag3 = true;

                            if(!flag3)
                            {
                                gnm1.hbb = 150;
                                gnm1.hba = s2;
                                fci(gnm1.haa + ": " + gnm1.hba, 2);
                            }
                        }
                        i9 += byte7;
                    } else
                    if(byte6 == 2)
                    {
                        int j30 = fnf.fnl(abyte0[i9]);
                        i9++;
                        int j34 = fnf.fnl(abyte0[i9]);
                        i9++;
                        int k37 = fnf.fnl(abyte0[i9]);
                        i9++;
                        if(gnm1 != null)
                        {
                            gnm1.hbe = j30;
                            gnm1.hbf = j34;
                            gnm1.hbg = k37;
                            gnm1.hbh = 200;
                            if(gnm1 == emd)
                            {
                                egd[3] = j34;
                                dmc[3] = k37;
                                dhi = false;
                                eef = false;
                            }
                        }
                    } else
                    if(byte6 == 3)
                    {
                        int k30 = fnf.fnm(abyte0, i9);
                        i9 += 2;
                        int k34 = fnf.fnm(abyte0, i9);
                        i9 += 2;
                        if(gnm1 != null)
                        {
                            gnm1.hbn = k30;
                            gnm1.hcb = k34;
                            gnm1.hca = -1;
                            gnm1.hcc = djm;
                        }
                    } else
                    if(byte6 == 4)
                    {
                        int l30 = fnf.fnm(abyte0, i9);
                        i9 += 2;
                        int l34 = fnf.fnm(abyte0, i9);
                        i9 += 2;
                        if(gnm1 != null)
                        {
                            gnm1.hbn = l30;
                            gnm1.hca = l34;
                            gnm1.hcb = -1;
                            gnm1.hcc = djm;
                        }
                    } else
                    if(byte6 == 5)
                    {
                        if(gnm1 != null)
                        {
                            gnm1.hac = fnf.fnm(abyte0, i9);
                            i9 += 2;
                            gnm1.gnn = fnf.gaa(abyte0, i9);
                            i9 += 8;
                            gnm1.haa = fnf.gah(gnm1.gnn);
                            int i31 = fnf.fnl(abyte0[i9]);
                            i9++;
                            for(int i35 = 0; i35 < i31; i35++)
                            {
                                gnm1.han[i35] = fnf.fnl(abyte0[i9]);
                                i9++;
                            }

                            for(int l37 = i31; l37 < 12; l37++)
                                gnm1.han[l37] = 0;

                            gnm1.hbj = abyte0[i9++] & 0xff;
                            gnm1.hbk = abyte0[i9++] & 0xff;
                            gnm1.hbl = abyte0[i9++] & 0xff;
                            gnm1.hbm = abyte0[i9++] & 0xff;
                            gnm1.hbi = abyte0[i9++] & 0xff;
                            gnm1.hcf = abyte0[i9++] & 0xff;
                        } else
                        {
                            i9 += 14;
                            int j31 = fnf.fnl(abyte0[i9]);
                            i9 += j31 + 1;
                        }
                    } else
                    if(byte6 == 6)
                    {
                        byte byte8 = abyte0[i9];
                        i9++;
                        if(gnm1 != null)
                        {
                            String s3 = cen.cfd(abyte0, i9, byte8);
                            gnm1.hbb = 150;
                            gnm1.hba = s3;
                            if(gnm1 == emd)
                                fci(gnm1.haa + ": " + gnm1.hba, 5);
                        }
                        i9 += byte8;
                    }
                }

                return;
            }
            if(i == 29)
            {
                for(int l1 = 1; l1 < j;)
                    if(fnf.fnl(abyte0[l1]) == 255)
                    {
                        int j9 = 0;
                        int l15 = eme + abyte0[l1 + 1] >> 3;
                        int j20 = emf + abyte0[l1 + 2] >> 3;
                        l1 += 3;
                        for(int k24 = 0; k24 < eca; k24++)
                        {
                            int j27 = (eal[k24] >> 3) - l15;
                            int k31 = (eam[k24] >> 3) - j20;
                            if(j27 != 0 || k31 != 0)
                            {
                                if(k24 != j9)
                                {
                                    dkd[j9] = dkd[k24];
                                    dkd[j9].cig = j9 + 10000;
                                    eal[j9] = eal[k24];
                                    eam[j9] = eam[k24];
                                    dgf[j9] = dgf[k24];
                                    dgg[j9] = dgg[k24];
                                }
                                j9++;
                            } else
                            {
                                dkm.bhe(dkd[k24]);
                                efh.glk(eal[k24], eam[k24], dgf[k24], dgg[k24]);
                            }
                        }

                        eca = j9;
                    } else
                    {
                        int k9 = fnf.fnm(abyte0, l1);
                        l1 += 2;
                        int i16 = eme + abyte0[l1++];
                        int k20 = emf + abyte0[l1++];
                        byte byte5 = abyte0[l1++];
                        int k27 = 0;
                        for(int l31 = 0; l31 < eca; l31++)
                            if(eal[l31] != i16 || eam[l31] != k20 || dgf[l31] != byte5)
                            {
                                if(l31 != k27)
                                {
                                    dkd[k27] = dkd[l31];
                                    dkd[k27].cig = k27 + 10000;
                                    eal[k27] = eal[l31];
                                    eam[k27] = eam[l31];
                                    dgf[k27] = dgf[l31];
                                    dgg[k27] = dgg[l31];
                                }
                                k27++;
                            } else
                            {
                                dkm.bhe(dkd[l31]);
                                efh.glk(eal[l31], eam[l31], dgf[l31], dgg[l31]);
                            }

                        eca = k27;
                        if(k9 != 65535)
                        {
                            efh.gkl(i16, k20, byte5, k9);
                            cgc cgc1 = feh(i16, k20, byte5, k9, eca);
                            dkd[eca] = cgc1;
                            eal[eca] = i16;
                            eam[eca] = k20;
                            dgg[eca] = k9;
                            dgf[eca++] = byte5;
                        }
                    }

                return;
            }
            if(i == 41)
            {
                emj = emi;
                emi = 0;
                for(int i2 = 0; i2 < emj; i2++)
                    ejg[i2] = eai[i2];

                int l9 = 8;
                int j16 = fnf.gad(abyte0, 8, 8);
                l9 += 8;
                for(int l20 = 0; l20 < j16; l20++)
                {
                    gnm gnm2 = ejg[l20];
                    int l27 = fnf.gad(abyte0, l9, 1);
                    l9++;
                    if(l27 != 0)
                    {
                        int i32 = fnf.gad(abyte0, l9, 1);
                        l9++;
                        if(i32 == 0)
                        {
                            int j35 = fnf.gad(abyte0, l9, 3);
                            l9 += 3;
                            int i38 = gnm2.hak;
                            int l40 = gnm2.hal[i38];
                            int j42 = gnm2.ham[i38];
                            if(j35 == 2 || j35 == 1 || j35 == 3)
                                l40 += ehb;
                            if(j35 == 6 || j35 == 5 || j35 == 7)
                                l40 -= ehb;
                            if(j35 == 4 || j35 == 3 || j35 == 5)
                                j42 += ehb;
                            if(j35 == 0 || j35 == 1 || j35 == 7)
                                j42 -= ehb;
                            gnm2.hai = j35;
                            gnm2.hak = i38 = (i38 + 1) % 10;
                            gnm2.hal[i38] = l40;
                            gnm2.ham[i38] = j42;
                        } else
                        {
                            int k35 = fnf.gad(abyte0, l9, 4);
                            if((k35 & 0xc) == 12)
                            {
                                l9 += 2;
                                continue;
                            }
                            gnm2.hai = fnf.gad(abyte0, l9, 4);
                            l9 += 4;
                        }
                    }
                    eai[emi++] = gnm2;
                }

                while(l9 + 34 < j * 8) 
                {
                    int l24 = fnf.gad(abyte0, l9, 12);
                    l9 += 12;
                    int i28 = fnf.gad(abyte0, l9, 5);
                    l9 += 5;
                    if(i28 > 15)
                        i28 -= 32;
                    int j32 = fnf.gad(abyte0, l9, 5);
                    l9 += 5;
                    if(j32 > 15)
                        j32 -= 32;
                    int l35 = fnf.gad(abyte0, l9, 4);
                    l9 += 4;
                    int j38 = (eme + i28) * ehb + 64;
                    int i41 = (emf + j32) * ehb + 64;
                    int k42 = fnf.gad(abyte0, l9, 10);
                    l9 += 10;
                    if(k42 >= ahd.ajn)
                        k42 = 24;
                    fak(l24, j38, i41, l35, k42);
                }
                return;
            }
            if(i == 47)
            {
                int j2 = fnf.fnm(abyte0, 1);
                int i10 = 3;
                for(int k16 = 0; k16 < j2; k16++)
                {
                    int i21 = fnf.fnm(abyte0, i10);
                    i10 += 2;
                    gnm gnm3 = edd[i21];
                    int j28 = fnf.fnl(abyte0[i10]);
                    i10++;
                    if(j28 == 1)
                    {
                        int k32 = fnf.fnm(abyte0, i10);
                        i10 += 2;
                        byte byte9 = abyte0[i10];
                        i10++;
                        if(gnm3 != null)
                        {
                            String s4 = cen.cfd(abyte0, i10, byte9);
                            gnm3.hbb = 150;
                            gnm3.hba = s4;
                            if(k32 == emd.hab)
                                fci("@yel@" + ahd.akg[gnm3.haf] + ": " + gnm3.hba, 5);
                        }
                        i10 += byte9;
                    } else
                    if(j28 == 2)
                    {
                        int l32 = fnf.fnl(abyte0[i10]);
                        i10++;
                        int i36 = fnf.fnl(abyte0[i10]);
                        i10++;
                        int k38 = fnf.fnl(abyte0[i10]);
                        i10++;
                        if(gnm3 != null)
                        {
                            gnm3.hbe = l32;
                            gnm3.hbf = i36;
                            gnm3.hbg = k38;
                            gnm3.hbh = 200;
                        }
                    }
                }

                return;
            }
            if(i == 117)
            {
                eba = true;
                int k2 = fnf.fnl(abyte0[1]);
                dnh = k2;
                int j10 = 2;
                for(int l16 = 0; l16 < k2; l16++)
                {
                    int j21 = fnf.fnl(abyte0[j10]);
                    j10++;
                    elg[l16] = new String(abyte0, j10, j21);
                    j10 += j21;
                }

                return;
            }
            if(i == 208)
            {
                eba = false;
                return;
            }
            if(i == 249)
            {
                dih = true;
                emg = fnf.fnm(abyte0, 1);
                dha = fnf.fnm(abyte0, 3);
                dhb = fnf.fnm(abyte0, 5);
                egl = fnf.fnm(abyte0, 7);
                dhc = fnf.fnm(abyte0, 9);
                dhb -= egl * dhc;
                return;
            }
            if(i == 16)
            {
                int l2 = 1;
                for(int k10 = 0; k10 < 18; k10++)
                    egd[k10] = fnf.fnl(abyte0[l2++]);

                for(int i17 = 0; i17 < 18; i17++)
                    dmc[i17] = fnf.fnl(abyte0[l2++]);

                for(int k21 = 0; k21 < 18; k21++)
                {
                    emk[k21] = fnf.fnn(abyte0, l2);
                    l2 += 4;
                }

                efn = fnf.fnl(abyte0[l2++]);
                return;
            }
            if(i == 33)
            {
                for(int i3 = 0; i3 < 5; i3++)
                    dfa[i3] = fnf.fnl(abyte0[1 + i3]);

                return;
            }
            if(i == 109)
            {
                enb = 250;
                return;
            }
            if(i == 76)
            {
                int j3 = (j - 1) / 4;
                for(int l10 = 0; l10 < j3; l10++)
                {
                    int j17 = eme + fnf.gab(abyte0, 1 + l10 * 4) >> 3;
                    int l21 = emf + fnf.gab(abyte0, 3 + l10 * 4) >> 3;
                    int i25 = 0;
                    for(int k28 = 0; k28 < egh; k28++)
                    {
                        int i33 = (dgj[k28] >> 3) - j17;
                        int j36 = (dgk[k28] >> 3) - l21;
                        if(i33 != 0 || j36 != 0)
                        {
                            if(k28 != i25)
                            {
                                dgj[i25] = dgj[k28];
                                dgk[i25] = dgk[k28];
                                dgl[i25] = dgl[k28];
                                dgm[i25] = dgm[k28];
                            }
                            i25++;
                        }
                    }

                    egh = i25;
                    i25 = 0;
                    for(int j33 = 0; j33 < dln; j33++)
                    {
                        int k36 = (ecb[j33] >> 3) - j17;
                        int l38 = (ecc[j33] >> 3) - l21;
                        if(k36 != 0 || l38 != 0)
                        {
                            if(j33 != i25)
                            {
                                egn[i25] = egn[j33];
                                egn[i25].cig = i25;
                                ecb[i25] = ecb[j33];
                                ecc[i25] = ecc[j33];
                                ecd[i25] = ecd[j33];
                                ece[i25] = ece[j33];
                            }
                            i25++;
                        } else
                        {
                            dkm.bhe(egn[j33]);
                            efh.glc(ecb[j33], ecc[j33], ecd[j33]);
                        }
                    }

                    dln = i25;
                    i25 = 0;
                    for(int l36 = 0; l36 < eca; l36++)
                    {
                        int i39 = (eal[l36] >> 3) - j17;
                        int j41 = (eam[l36] >> 3) - l21;
                        if(i39 != 0 || j41 != 0)
                        {
                            if(l36 != i25)
                            {
                                dkd[i25] = dkd[l36];
                                dkd[i25].cig = i25 + 10000;
                                eal[i25] = eal[l36];
                                eam[i25] = eam[l36];
                                dgf[i25] = dgf[l36];
                                dgg[i25] = dgg[l36];
                            }
                            i25++;
                        } else
                        {
                            dkm.bhe(dkd[l36]);
                            efh.glk(eal[l36], eam[l36], dgf[l36], dgg[l36]);
                        }
                    }

                    eca = i25;
                }

                return;
            }
            if(i == 7)
            {
                djc = true;
                return;
            }
            if(i == 108)
            {
                int k3 = fnf.fnm(abyte0, 1);
                if(egm[k3] != null)
                    eli = egm[k3].haa;
                dfk = true;
                eib = false;
                eic = false;
                djf = 0;
                dkn = 0;
                return;
            }
            if(i == 113)
            {
                dfk = false;
                ddf = false;
                return;
            }
            if(i == 155)
            {
                dkn = abyte0[1] & 0xff;
                int l3 = 2;
                for(int i11 = 0; i11 < dkn; i11++)
                {
                    dla[i11] = fnf.fnm(abyte0, l3);
                    l3 += 2;
                    dlb[i11] = fnf.fnn(abyte0, l3);
                    l3 += 4;
                }

                eib = false;
                eic = false;
                return;
            }
            if(i == 185)
            {
                byte byte0 = abyte0[1];
                if(byte0 == 1)
                {
                    eib = true;
                    return;
                } else
                {
                    eib = false;
                    return;
                }
            }
            if(i == 24)
            {
                eha = true;
                int i4 = 1;
                i4++;
                int j11 = abyte0[1] & 0xff;
                i4++;
                byte byte4 = abyte0[2];
                i4++;
                deh = abyte0[3] & 0xff;
                i4++;
                dei = abyte0[4] & 0xff;
                for(int i22 = 0; i22 < 40; i22++)
                    ebd[i22] = -1;

                for(int j25 = 0; j25 < j11; j25++)
                {
                    ebd[j25] = fnf.fnm(abyte0, i4);
                    i4 += 2;
                    ebe[j25] = fnf.fnm(abyte0, i4);
                    i4 += 2;
                    ebf[j25] = abyte0[i4++];
                }

                if(byte4 == 1)
                {
                    int l28 = 39;
                    for(int k33 = 0; k33 < djn; k33++)
                    {
                        if(l28 < j11)
                            break;
                        boolean flag2 = false;
                        for(int j39 = 0; j39 < 40; j39++)
                        {
                            if(ebd[j39] != dka[k33])
                                continue;
                            flag2 = true;
                            break;
                        }

                        if(dka[k33] == 10)
                            flag2 = true;
                        if(!flag2)
                        {
                            ebd[l28] = dka[k33] & 0x7fff;
                            ebe[l28] = 0;
                            ebf[l28] = 0;
                            l28--;
                        }
                    }

                }
                if(ddh >= 0 && ddh < 40 && ebd[ddh] != ddi)
                {
                    ddh = -1;
                    ddi = -2;
                }
                return;
            }
            if(i == 42)
            {
                eha = false;
                return;
            }
            if(i == 170)
            {
                byte byte1 = abyte0[1];
                if(byte1 == 1)
                {
                    eic = true;
                    return;
                } else
                {
                    eic = false;
                    return;
                }
            }
            if(i == 161)
            {
                ekc = fnf.fnl(abyte0[1]) == 1;
                eah = fnf.fnl(abyte0[2]) == 1;
                ddn = fnf.fnl(abyte0[3]) == 1;
                return;
            }
            if(i == 222)
            {
                for(int j4 = 0; j4 < j - 1; j4++)
                {
                    boolean flag = abyte0[j4 + 1] == 1;
                    if(!dia[j4] && flag)
                        faj("prayeron");
                    if(dia[j4] && !flag)
                        faj("prayeroff");
                    dia[j4] = flag;
                }

                return;
            }
            if(i == 26)
            {
                for(int k4 = 0; k4 < 50; k4++)
                    ein[k4] = abyte0[k4 + 1] == 1;

                return;
            }
            if(i == 188)
            {
                dnk = true;
                int l4 = 1;
                l4++;
                ddj = abyte0[1] & 0xff;
                l4++;
                edc = abyte0[2] & 0xff;
                for(int k11 = 0; k11 < ddj; k11++)
                {
                    emn[k11] = fnf.fnm(abyte0, l4);
                    l4 += 2;
                    ena[k11] = fnf.gac(abyte0, l4);
                    if(ena[k11] >= 128)
                        l4 += 4;
                    else
                        l4++;
                }

                fdd();
                return;
            }
            if(i == 130)
            {
                dnk = false;
                return;
            }
            if(i == 69)
            {
                int i5 = abyte0[1] & 0xff;
                emk[i5] = fnf.fnn(abyte0, 2);
                return;
            }
            if(i == 240)
            {
                int j5 = fnf.fnm(abyte0, 1);
                if(egm[j5] != null)
                    efm = egm[j5].haa;
                dji = true;
                dmd = 0;
                dnd = 0;
                eaj = false;
                eak = false;
                dgb = false;
                dgc = false;
                dgd = false;
                dge = false;
                return;
            }
            if(i == 198)
            {
                dji = false;
                dkk = false;
                return;
            }
            if(i == 128)
            {
                ddf = true;
                ddg = false;
                dfk = false;
                int k5 = 1;
                efg = fnf.gaa(abyte0, 1);
                k5 += 8;
                k5++;
                dii = abyte0[9] & 0xff;
                for(int l11 = 0; l11 < dii; l11++)
                {
                    dij[l11] = fnf.fnm(abyte0, k5);
                    k5 += 2;
                    dik[l11] = fnf.fnn(abyte0, k5);
                    k5 += 4;
                }

                ede = abyte0[k5++] & 0xff;
                for(int k17 = 0; k17 < ede; k17++)
                {
                    edf[k17] = fnf.fnm(abyte0, k5);
                    k5 += 2;
                    edg[k17] = fnf.fnn(abyte0, k5);
                    k5 += 4;
                }

                return;
            }
            if(i == 229)
            {
                dnd = abyte0[1] & 0xff;
                int l5 = 2;
                for(int i12 = 0; i12 < dnd; i12++)
                {
                    dne[i12] = fnf.fnm(abyte0, l5);
                    l5 += 2;
                    dnf[i12] = fnf.fnn(abyte0, l5);
                    l5 += 4;
                }

                eaj = false;
                eak = false;
                return;
            }
            if(i == 211)
            {
                if(abyte0[1] == 1)
                    dgb = true;
                else
                    dgb = false;
                if(abyte0[2] == 1)
                    dgc = true;
                else
                    dgc = false;
                if(abyte0[3] == 1)
                    dgd = true;
                else
                    dgd = false;
                if(abyte0[4] == 1)
                    dge = true;
                else
                    dge = false;
                eaj = false;
                eak = false;
                return;
            }
            if(i == 81)
            {
                int i6 = 1;
                i6++;
                int j12 = abyte0[1] & 0xff;
                int l17 = fnf.fnm(abyte0, 2);
                i6 += 2;
                int j22 = fnf.gac(abyte0, 4);
                if(j22 >= 128)
                    i6 += 4;
                else
                    i6++;
                if(j22 == 0)
                {
                    ddj--;
                    for(int k25 = j12; k25 < ddj; k25++)
                    {
                        emn[k25] = emn[k25 + 1];
                        ena[k25] = ena[k25 + 1];
                    }

                } else
                {
                    emn[j12] = l17;
                    ena[j12] = j22;
                    if(j12 >= ddj)
                        ddj = j12 + 1;
                }
                fdd();
                return;
            }
            if(i == 210)
            {
                int j6 = 1;
                int k12 = 1;
                j6++;
                int i18 = abyte0[1] & 0xff;
                int k22 = fnf.fnm(abyte0, 2);
                j6 += 2;
                if(ahd.ahl[k22 & 0x7fff] == 0)
                {
                    k12 = fnf.gac(abyte0, 4);
                    if(k12 >= 128)
                        j6 += 4;
                    else
                        j6++;
                }
                dka[i18] = k22 & 0x7fff;
                dkc[i18] = k22 / 32768;
                dkb[i18] = k12;
                if(i18 >= djn)
                    djn = i18 + 1;
                return;
            }
            if(i == 44)
            {
                int k6 = abyte0[1] & 0xff;
                djn--;
                for(int l12 = k6; l12 < djn; l12++)
                {
                    dka[l12] = dka[l12 + 1];
                    dkb[l12] = dkb[l12 + 1];
                    dkc[l12] = dkc[l12 + 1];
                }

                return;
            }
            if(i == 23)
            {
                int l6 = 1;
                l6++;
                int i13 = abyte0[1] & 0xff;
                l6++;
                egd[i13] = fnf.fnl(abyte0[2]);
                l6++;
                dmc[i13] = fnf.fnl(abyte0[3]);
                emk[i13] = fnf.fnn(abyte0, 4);
                l6 += 4;
                return;
            }
            if(i == 73)
            {
                byte byte2 = abyte0[1];
                if(byte2 == 1)
                {
                    eaj = true;
                    return;
                } else
                {
                    eaj = false;
                    return;
                }
            }
            if(i == 131)
            {
                byte byte3 = abyte0[1];
                if(byte3 == 1)
                {
                    eak = true;
                    return;
                } else
                {
                    eak = false;
                    return;
                }
            }
            if(i == 10)
            {
                dkk = true;
                dkl = false;
                dji = false;
                int i7 = 1;
                eci = fnf.gaa(abyte0, 1);
                i7 += 8;
                i7++;
                ege = abyte0[9] & 0xff;
                for(int j13 = 0; j13 < ege; j13++)
                {
                    egf[j13] = fnf.fnm(abyte0, i7);
                    i7 += 2;
                    egg[j13] = fnf.fnn(abyte0, i7);
                    i7 += 4;
                }

                eja = abyte0[i7++] & 0xff;
                for(int j18 = 0; j18 < eja; j18++)
                {
                    ejb[j18] = fnf.fnm(abyte0, i7);
                    i7 += 2;
                    ejc[j18] = fnf.fnn(abyte0, i7);
                    i7 += 4;
                }

                dim = abyte0[i7++] & 0xff;
                din = abyte0[i7++] & 0xff;
                dja = abyte0[i7++] & 0xff;
                djb = abyte0[i7++] & 0xff;
                return;
            }
            if(i == 238)
            {
                String s = new String(abyte0, 1, j - 1);
                faj(s);
                return;
            }
            if(i == 253)
            {
                if(ekh < 50)
                {
                    int j7 = abyte0[1] & 0xff;
                    int k13 = abyte0[2] + eme;
                    int k18 = abyte0[3] + emf;
                    eid[ekh] = j7;
                    efk[ekh] = 0;
                    deg[ekh] = k13;
                    ejl[ekh] = k18;
                    ekh++;
                }
                return;
            }
            if(i == 126)
            {
                if(!eia)
                {
                    eki = fnf.fnn(abyte0, 1);
                    dnm = fnf.fnm(abyte0, 5);
                    dgi = abyte0[7] & 0xff;
                    dib = fnf.fnm(abyte0, 8);
                    dhi = true;
                    eia = true;
                    edh = null;
                }
                return;
            }
            if(i == 112)
            {
                eag = new String(abyte0, 1, j - 1);
                eef = true;
                def = false;
                return;
            }
            if(i == 49)
            {
                eag = new String(abyte0, 1, j - 1);
                eef = true;
                def = true;
                return;
            }
            if(i == 60)
            {
                ejh = fnf.fnm(abyte0, 1);
                return;
            }
            if(i == 15)
            {
                if(!edi)
                    eji = ejh;
                edi = true;
                super.fln = "";
                super.fma = "";
                dki.ccd(eii + 1, abyte0);
                ejk = null;
                return;
            }
            if(i == 174)
            {
                eji = fnf.fnm(abyte0, 1);
                return;
            }
            if(i == 206)
            {
                edi = false;
                return;
            }
            if(i == 20)
            {
                ejk = "Incorrect - Please wait...";
                return;
            }
            if(i == 28)
            {
                eee = fnf.fnm(abyte0, 1) * 32;
                return;
            }
        }
        catch(RuntimeException runtimeexception)
        {
            if(ekb < 3)
            {
                super.aah.hfj(7);
                super.aah.hfk(runtimeexception.toString());
                super.aah.hff();
                super.aah.hfj(7);
                super.aah.hfk("p-type:" + i + " p-size:" + j);
                super.aah.hff();
                super.aah.hfj(7);
                super.aah.hfk("rx:" + eme + " ry:" + emf + " num3l:" + dln);
                super.aah.hff();
                String s1 = "";
                for(int l18 = 0; l18 < 80 && l18 < j; l18++)
                    s1 = s1 + abyte0[l18] + " ";

                super.aah.hfj(7);
                super.aah.hfk(s1);
                super.aah.hff();
                ekb++;
            }
        }
    }

    private final void eni()
    {
        char c = '\u0190';
        char c1 = 'd';
        if(def)
        {
            c1 = '\u01C2';
            c1 = '\u012C';
        }
        dki.cbh(56, 167 - c1 / 2, 400, c1, 0);
        dki.cbi(56, 167 - c1 / 2, 400, c1, 0xffffff);
        dki.cef(eag, 256, (167 - c1 / 2) + 20, 1, 0xffffff, 360);
        int i = 157 + c1 / 2;
        int j = 0xffffff;
        if(super.flh > i - 12 && super.flh <= i && super.flg > 106 && super.flg < 406)
            j = 0xff0000;
        dki.cee("Click here to close window", 256, i, 1, j);
        if(elf == 1)
        {
            if(j == 0xff0000)
                eef = false;
            if((super.flg < 56 || super.flg > 456) && (super.flh < 167 - c1 / 2 || super.flh > 167 + c1 / 2))
                eef = false;
        }
        elf = 0;
    }

    protected final int adj()
    {
        return 0;
    }

    final void enk(int i, int j, int k, int l, int i1, int j1, int k1)
    {
        int l1 = eid[i1];
        int i2 = efk[i1];
        if(l1 == 0)
        {
            int j2 = 255 + i2 * 5 * 256;
            dki.cbe(i + k / 2, j + l / 2, 20 + i2 * 2, j2, 255 - i2 * 5);
        }
        if(l1 == 1)
        {
            int k2 = 0xffff00 + i2 * 5 * 256;
            dki.cbe(i + k / 2, j + l / 2, 10 + i2, k2, 255 - i2 * 5);
        }
    }

    private final void enl()
    {
        if(elf != 0)
        {
            elf = 0;
            if(eda == 1 && (super.flg < 106 || super.flh < 145 || super.flg > 406 || super.flh > 215))
            {
                eda = 0;
                return;
            }
            if(eda == 2 && (super.flg < 6 || super.flh < 145 || super.flg > 506 || super.flh > 215))
            {
                eda = 0;
                return;
            }
            if(eda == 3 && (super.flg < 106 || super.flh < 145 || super.flg > 406 || super.flh > 215))
            {
                eda = 0;
                return;
            }
            if(super.flg > 236 && super.flg < 276 && super.flh > 193 && super.flh < 213)
            {
                eda = 0;
                return;
            }
        }
        int i = 145;
        if(eda == 1)
        {
            dki.cbh(106, 145, 300, 70, 0);
            dki.cbi(106, 145, 300, 70, 0xdfaffdf);
            i += 20;
            dki.cee("Enter name to add to friends list", 256, 165, 4, 0xffff00);
            i += 20;
            dki.cee(super.fln + "*", 256, 185, 4, 0xdfaffdf);
            if(super.fma.length() > 0)
            {
                String s = super.fma.trim();
                super.fln = "";
                super.fma = "";
                eda = 0;
                if(s.length() > 0 && fnf.gag(s) != emd.gnn)
                    ack(s);
            }
        }
        if(eda == 2)
        {
            dki.cbh(6, i, 500, 70, 0);
            dki.cbi(6, i, 500, 70, 0xdfaffdf);
            i += 20;
            dki.cee("Enter message to send to " + fnf.gah(ehm), 256, i, 4, 0xdfaffdf);
            i += 20;
            dki.cee(super.fmb + "*", 256, i, 4, 0xdfaffdf);
            if(super.fmc.length() > 0)
            {
                String s1 = super.fmc;
                super.fmb = "";
                super.fmc = "";
                eda = 0;
                int k = cen.cfe(s1);
                acm(ehm, cen.cfa, k);
                s1 = cen.cfd(cen.cfa, 0, k);
                s1 = ffn.fhe(s1);
                adh("@pri@You tell " + fnf.gah(ehm) + ": " + s1);
            }
        }
        if(eda == 3)
        {
            dki.cbh(106, i, 300, 70, 0);
            dki.cbi(106, i, 300, 70, 0xdfaffdf);
            i += 20;
            dki.cee("Enter name to add to ignore list", 256, i, 4, 0xffff00);
            i += 20;
            dki.cee(super.fln + "*", 256, i, 4, 0xdfaffdf);
            if(super.fma.length() > 0)
            {
                String s2 = super.fma.trim();
                super.fln = "";
                super.fma = "";
                eda = 0;
                if(s2.length() > 0 && fnf.gag(s2) != emd.gnn)
                    aci(s2);
            }
        }
        int j = 0xdfaffdf;
        if(super.flg > 236 && super.flg < 276 && super.flh > 193 && super.flh < 213)
            j = 0x000000;
        dki.cee("Cancel", 256, 208, 1, j);
    }

    private final void enm()
    {
        dki.cbh(126, 137, 260, 60, 0);
        dki.cbi(126, 137, 260, 60, 0x000000);
        dki.cee("Logging out...", 256, 173, 5, 0xffff00);
    }

    private final void enn(int i, int j, int k, int l)
    {
        int i1;
        int j1;
        if(k == 0 || k == 4)
        {
            i1 = ahd.akk[l];
            j1 = ahd.akl[l];
        } else
        {
            j1 = ahd.akk[l];
            i1 = ahd.akl[l];
        }
        if(ahd.akm[l] == 2 || ahd.akm[l] == 3)
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
            fdf(eme, emf, i, j, (i + i1) - 1, (j + j1) - 1, false, true);
            return;
        } else
        {
            fdf(eme, emf, i, j, (i + i1) - 1, (j + j1) - 1, true, true);
            return;
        }
    }

    private final void faa()
    {
        boolean flag = false;
        byte byte0 = 7;
        byte byte1 = 15;
        char c = '\257';
        if(elf != 0)
        {
            for(int i = 0; i < 5; i++)
            {
                if(i <= 0 || super.flg <= 7 || super.flg >= 90 || super.flh <= 15 + i * 20 || super.flh >= 15 + i * 20 + 20)
                    continue;
                dig = i - 1;
                elf = 0;
                super.aah.hfj(74);
                super.aah.hfa(dig);
                super.aah.hff();
	  styleCnt = dig;
	  break;
            }

      }
        for(int j = 0; j < 5; j++)
        {
            if(j == dig + 1)
                dki.cbf(7, 15 + j * 20, 85, 20, 0xdfaffdf, 128);
            else
                dki.cbf(7, 15 + j * 20, 85, 20, 0x000000, 128);
            dki.cbj(7, 15 + j * 20, 85, 0);
            dki.cbj(7, 15 + j * 20 + 20, 85, 0); 
        }

        dki.cee("Training", 50, 31, 3, 0xdfaffdf);
        dki.cee("All", 45, 51, 3, 0xdfaffdf);
        dki.cee("Strength",45, 71, 3, 0xdfaffdf);
        dki.cee("Attack", 45, 91, 3, 0xdfaffdf);
        dki.cee("Defense", 45, 111, 3, 0xdfaffdf);
    }

    private final void fab()
    {
        boolean flag1 = false;
        for(int i = 0; i < eld; i++)
        {
            int j = dki.cek(1);
            int l = dke[i];
            int k1 = dkf[i];
            int j2 = dkg[i];
            int i3 = dkh[i];
            boolean flag = true;
            while(flag) 
            {
                flag = false;
                for(int i4 = 0; i4 < i; i4++)
                    if(k1 + i3 > dkf[i4] - j && k1 - j < dkf[i4] + dkh[i4] && l - j2 < dke[i4] + dkg[i4] && l + j2 > dke[i4] - dkg[i4] && dkf[i4] - j - i3 < k1)
                    {
                        k1 = dkf[i4] - j - i3;
                        flag = true;
                    }

            }
            dkf[i] = k1;
            dki.cef(ele[i], l, k1, 1, 0xdfaffdf, 300);
        }

        for(int k = 0; k < ekg; k++)
        {
            int i1 = edk[k];
            int l1 = edl[k];
            int k2 = emb[k];
            int j3 = emc[k];
            int l3 = (39 * k2) / 100;
            int j4 = (27 * k2) / 100;
            int k4 = l1 - j4;
            dki.ccl(i1 - l3 / 2, k4, l3, j4, eie + 9, 85);
            int l4 = (36 * k2) / 100;
            int i5 = (24 * k2) / 100;
            dki.cdk(i1 - l4 / 2, (k4 + j4 / 2) - i5 / 2, l4, i5, ahd.ahj[j3] + eig, ahd.aia[j3], 0, 0, false);
        }

        for(int j1 = 0; j1 < dni; j1++)
        {
            int i2 = ecf[j1];
            int l2 = ecg[j1];
            int k3 = ech[j1];
            dki.cbf(i2 - 15, l2 - 3, k3, 5, 65280, 192);
            dki.cbf((i2 - 15) + k3, l2 - 3, 30 - k3, 5, 0xf8948da, 192);
        }

    }

    private final void fac(boolean flag)
    {
        boolean flag1 = false;
        int i = ((blm) (dki)).bln - 199;
        int j = 36;
        dki.cci(i - 49, 3, eie + 4);
        char c = '\304';
        char c1 = '\266';
        int l;
        int k = l = 0xdfaffdf;
        if(dfj == 0)
            k = 0x000000;
        else
            l = 0x000000;
        dki.cbf(i, 36, 98, 24, k, 128);
        dki.cbf(i + 98, 36, 98, 24, l, 128);
        dki.cbf(i, 60, 196, 90, 0x000000, 128);
        dki.cbf(i, 150, 196, 68, 0x000000, 128);
        dki.cbj(i, 60, 196, 0);
        dki.cbk(i + 98, 36, 24, 0);
        dki.cbj(i, 149, 196, 0);
        dki.cee("Magic", i + 49, 52, 4, 0xdfaffdf);
        dki.cee("Prayers", i + 49 + 98, 52, 4, 0xdfaffdf);
        if(dfj == 0)
        {
            dfh.ghe(dfi);
            int i1 = 0;
            for(int i2 = 0; i2 < ahd.aid; i2++)
            {
                String s = "@yel@";
                for(int l3 = 0; l3 < ahd.alb[i2]; l3++)
                {
                    int k4 = ahd.ald[i2][l3];
                    if(fca(k4, ahd.ale[i2][l3]))
                        continue;
                    s = "@whi@";
                    break;
                }

                int l4 = egd[6];
                if(ahd.ala[i2] > l4)
                    s = "@blu@";
                dfh.ghg(dfi, i1++, s + "Level " + ahd.ala[i2] + ": " + ahd.amh[i2]);
            }

            dfh.gfj();
            int i3 = dfh.ghn(dfi);
            if(i3 != -1)
            {
                dki.ceg("Level " + ahd.ala[i3] + ": " + ahd.amh[i3], i + 2, 160, 1, 0xffff00);
                dki.ceg(ahd.ami[i3], i + 2, 172, 0, 0xffffff);
                for(int i4 = 0; i4 < ahd.alb[i3]; i4++)
                {
                    int i5 = ahd.ald[i3][i4];
                    dki.cci(i + 2 + i4 * 44, 186, eig + ahd.ahj[i5]);
                    int j5 = fec(i5);
                    int k5 = ahd.ale[i3][i4];
                    String s2 = "@red@";
                    if(fca(i5, k5))
                        s2 = "@gre@";
                    dki.ceg(s2 + j5 + "/" + k5, i + 2 + i4 * 44, 186, 1, 0xffffff);
                }

            } else
            {
                dki.ceg("Point at a spell for a description", i + 2, 160, 1, 0xdfaffdf);
            }
        }
        if(dfj == 1)
        {
            dfh.ghe(dfi);
            int j1 = 0;
            for(int j2 = 0; j2 < ahd.aij; j2++)
            {
                String s1 = "@whi@";
                if(ahd.alj[j2] > dmc[5])
                    s1 = "@blu@";
                if(dia[j2])
                    s1 = "@gre@";
                dfh.ghg(dfi, j1++, s1 + "Level " + ahd.alj[j2] + ": " + ahd.alf[j2]);
            }

            dfh.gfj();
            int j3 = dfh.ghn(dfi);
            if(j3 != -1)
            {
                dki.cee("Level " + ahd.alj[j3] + ": " + ahd.alf[j3], i + 98, 166, 1, 0xffff00);
                dki.cee(ahd.alg[j3], i + 98, 181, 0, 0xffffff);
                dki.cee("Drain rate: " + ahd.alk[j3], i + 98, 196, 1, 0xdfaffdf);
            } else
            {
                dki.ceg("Point at a prayer for a description", i + 2, 160, 1, 0xdfaffdf);
            }
        }
        if(!flag)
            return;
        i = super.flg - (((blm) (dki)).bln - 199);
        j = super.flh - 36;
        if(i >= 0 && j >= 0 && i < 196 && j < 182)
        {
            dfh.gfg(i + (((blm) (dki)).bln - 199), j + 36, super.flj, super.fli);
            if(j <= 24 && elf == 1)
                if(i < 98 && dfj == 1)
                {
                    dfj = 0;
                    dfh.ghf(dfi);
                } else
                if(i > 98 && dfj == 0)
                {
                    dfj = 1;
                    dfh.ghf(dfi);
                }
            if(elf == 1 && dfj == 0)
            {
                int k1 = dfh.ghn(dfi);
                if(k1 != -1)
                {
                    int k2 = egd[6];
                    if(ahd.ala[k1] > k2)
                    {
                        fci("Your magic ability is not high enough for this spell", 3);
                    } else
                    {
                        int k3;
                        for(k3 = 0; k3 < ahd.alb[k1]; k3++)
                        {
                            int j4 = ahd.ald[k1][k3];
                            if(fca(j4, ahd.ale[k1][k3]))
                                continue;
                            fci("You don't have all the reagents you need for this spell", 3);
                            k3 = -1;
                            break;
                        }

                        if(k3 == ahd.alb[k1])
                        {
                            eaf = k1;
                            deb = -1;
                        }
                    }
                }
            }
            if(elf == 1 && dfj == 1)
            {
                int l1 = dfh.ghn(dfi);
                if(l1 != -1)
                {
                    int l2 = dmc[5];
                    if(ahd.alj[l1] > l2)
                        fci("Your prayer ability is not high enough for this prayer", 3);
                    else
                    if(egd[5] == 0)
                        fci("You have run out of prayer points. Return to a church to recharge", 3);
                    else
                    if(dia[l1])
                    {
                        super.aah.hfj(162);
                        super.aah.hfa(l1);
                        super.aah.hff();
                        dia[l1] = false;
                        faj("prayeroff");
                    } else
                    {
                        super.aah.hfj(202);
                        super.aah.hfa(l1);
                        super.aah.hff();
                        dia[l1] = true;
                        faj("prayeron");
                    }
                }
            }
            elf = 0;
        }
    }

    private final void fad()
    {
        int i = 97;
        dki.cbh(86, 77, 340, 180, 0);
        dki.cbi(86, 77, 340, 180, 0x000000);
        dki.cee("Warning! Proceed with caution", 256, 97, 4, 0xff0000);
        i += 26;
        dki.cee("If you go much further north you will enter the", 256, 123, 1, 0xffffff);
        i += 13;
        dki.cee("wilderness. This a very dangerous area where", 256, 136, 1, 0xffffff);
        i += 13;
        dki.cee("other players can attack you!", 256, 149, 1, 0xffffff);
        i += 22;
        dki.cee("The further north you go the more dangerous it", 256, 171, 1, 0xffffff);
        i += 13;
        dki.cee("becomes, but the more treasure you will find.", 256, 184, 1, 0xffffff);
        i += 22;
        dki.cee("In the wilderness an indicator at the bottom-right", 256, 206, 1, 0xffffff);
        i += 13;
        dki.cee("of the screen will show the current level of danger", 256, 219, 1, 0xffffff);
        i += 22;
        int j = 0x000000;
        if(super.flh > 229 && super.flh <= 241 && super.flg > 181 && super.flg < 331)
            j = 0xff0000;
        dki.cee("Click here to close window", 256, 241, 1, j);
        if(elf != 0)
        {
            if(super.flh > 229 && super.flh <= 241 && super.flg > 181 && super.flg < 331)
                efi = 2;
            if(super.flg < 86 || super.flg > 426 || super.flh < 77 || super.flh > 257)
                efi = 2;
            elf = 0;
        }
    }

    private final void fae()
    {
        boolean flag = false;
        byte abyte0[] = fbm("media" + cff.cfk + ".jag", "2d graphics", 20);
        if(abyte0 == null)
        {
            ejj = true;
            return;
        }
        byte abyte1[] = fnf.gak("index.dat", 0, abyte0);
        dki.ccc(eie, fnf.gak("inv1.dat", 0, abyte0), abyte1, 1);
        dki.ccc(eie + 1, fnf.gak("inv2.dat", 0, abyte0), abyte1, 6);
        dki.ccc(eie + 9, fnf.gak("bubble.dat", 0, abyte0), abyte1, 1);
        dki.ccc(eie + 10, fnf.gak("runescape.dat", 0, abyte0), abyte1, 1);
        dki.ccc(eie + 11, fnf.gak("splat.dat", 0, abyte0), abyte1, 3);
        dki.ccc(eie + 14, fnf.gak("icon.dat", 0, abyte0), abyte1, 8);
        dki.ccc(eie + 22, fnf.gak("hbar.dat", 0, abyte0), abyte1, 1);
        dki.ccc(eie + 23, fnf.gak("hbar2.dat", 0, abyte0), abyte1, 1);
        dki.ccc(eie + 24, fnf.gak("compass.dat", 0, abyte0), abyte1, 1);
        dki.ccc(eie + 25, fnf.gak("buttons.dat", 0, abyte0), abyte1, 2);
        dki.ccc(eif, fnf.gak("scrollbar.dat", 0, abyte0), abyte1, 2);
        dki.ccc(eif + 2, fnf.gak("corners.dat", 0, abyte0), abyte1, 4);
        dki.ccc(eif + 6, fnf.gak("arrows.dat", 0, abyte0), abyte1, 2);
        dki.ccc(eih, fnf.gak("projectile.dat", 0, abyte0), abyte1, ahd.amk);
        int i = ahd.akd;
        for(int j = 1; i > 0; j++)
        {
            int k = i;
            i -= 30;
            if(k > 30)
                k = 30;
            dki.ccc(eig + (j - 1) * 30, fnf.gak("objects" + j + ".dat", 0, abyte0), abyte1, k);
        }

        dki.ccf(eie);
        dki.ccf(eie + 9);
        for(int l = 11; l <= 26; l++)
            dki.ccf(eie + l);

        for(int i1 = 0; i1 < ahd.amk; i1++)
            dki.ccf(eih + i1);

        for(int j1 = 0; j1 < ahd.akd; j1++)
            dki.ccf(eig + j1);

    }

    private final void faf()
    {
        boolean flag1 = false;
        if(ecj != 0)
            enm();
        else
        if(eef)
            eni();
        else
        if(efi == 1)
            fad();
        else
        if(dnk && dfl == 0)
            fah();
        else
        if(eha && dfl == 0)
            ffa();
        else
        if(ddf)
            fcc();
        else
        if(dfk)
            fbk();
        else
        if(dkk)
            fbf();
        else
        if(dji)
            fea();
        else
        if(dej == 2)
            fcf();
        else
        if(eda != 0)
        {
            enl();
        } else
        {
            if(eba)
                fdi();
           if(emd.hah == 8 || emd.hah == 9 || FightMenu)
                faa();
            fcd();
            boolean flag = !eba && !dea;
            if(flag)
                eae = 0;
            if(eeb == 0 && flag)
                fdh();
            if(eeb == 1)
                fch(flag);
            if(eeb == 2)
                fcb(flag);
            if(eeb == 3)
                enh(flag);
            if(eeb == 4)
                fac(flag);
            if(eeb == 5)
                fam(flag);
            if(eeb == 6)
                fcn(flag);
            if(!dea && !eba)
                fbh();
            if(dea && !eba)
                fdm();
        }
        elf = 0;
    }

    private final void fag(int i, String s)
    {
        int j = ecb[i];
        int k = ecc[i];
        int l = j - emd.had / 128;
        int i1 = k - emd.hae / 128;
        byte byte0 = 7;
        if(j >= 0 && k >= 0 && j < 96 && k < 96 && l > -7 && l < 7 && i1 > -7 && i1 < 7)
        {
            dkm.bhe(egn[i]);
            int j1 = ahd.anm(s);
            cgc cgc1 = dli[j1].daf();
            dkm.bhd(cgc1);
            cgc1.cna(true, 48, 48, -50, -10, -50);
            cgc1.dah(egn[i]);
            cgc1.cig = i;
            egn[i] = cgc1;
        }
    }

    private final void fah()
    {
        boolean flag = false;
        char c = '\u0198';
        char c1 = '\u014E';
        if(efj > 0 && ecm <= 48)
            efj = 0;
        if(efj > 1 && ecm <= 96)
            efj = 1;
        if(efj > 2 && ecm <= 144)
            efj = 2;
        if(dnb >= ecm || dnb < 0)
            dnb = -1;
        if(dnb != -1 && eil[dnb] != dnc)
        {
            dnb = -1;
            dnc = -2;
        }
        if(elf != 0)
        {
            elf = 0;
            int i = super.flg - 52;
            int j = super.flh - 3;
            if(i >= 0 && j >= 12 && i < 408 && j < 280)
            {
                int k = efj * 48;
                for(int j1 = 0; j1 < 6; j1++)
                {
                    for(int l1 = 0; l1 < 8; l1++)
                    {
                        int j6 = 7 + l1 * 49;
                        int l6 = 28 + j1 * 34;
                        if(i > j6 && i < j6 + 49 && j > l6 && j < l6 + 34 && k < ecm && eil[k] != -1)
                        {
                            dnc = eil[k];
                            dnb = k;
                        }
                        k++;
                    }

                }

                i = 52;
                j = 3;
                int i2;
                if(dnb < 0)
                    i2 = -1;
                else
                    i2 = eil[dnb];
                if(i2 != -1)
                {
                    int l = eim[dnb];
                    if(ahd.ahl[i2] == 1 && l > 1)
                        l = 1;
                    if(l >= 1 && super.flg >= 272 && super.flh >= 241 && super.flg < 302 && super.flh <= 252)
                    {
                        super.aah.hfj(131);
                        super.aah.hen(i2);
                        super.aah.hen(1);
                        super.aah.hff();
                    }
                    if(l >= 5 && super.flg >= 302 && super.flh >= 241 && super.flg < 332 && super.flh <= 252)
                    {
                        super.aah.hfj(131);
                        super.aah.hen(i2);
                        super.aah.hen(5);
                        super.aah.hff();
                    }
                    if(l >= 25 && super.flg >= 332 && super.flh >= 241 && super.flg < 357 && super.flh <= 252)
                    {
                        super.aah.hfj(131);
                        super.aah.hen(i2);
                        super.aah.hen(25);
                        super.aah.hff();
                    }
                    if(l >= 100 && super.flg >= 357 && super.flh >= 241 && super.flg < 387 && super.flh <= 252)
                    {
                        super.aah.hfj(131);
                        super.aah.hen(i2);
                        super.aah.hen(100);
                        super.aah.hff();
                    }
                    if(l >= 500 && super.flg >= 387 && super.flh >= 241 && super.flg < 420 && super.flh <= 252)
                    {
                        super.aah.hfj(131);
                        super.aah.hen(i2);
                        super.aah.hen(500);
                        super.aah.hff();
                    }
                    if(l >= 2500 && super.flg >= 422 && super.flh >= 241 && super.flg < 452 && super.flh <= 252)
                    {
                        super.aah.hfj(131);
                        super.aah.hen(i2);
                        super.aah.hen(2500);
                        super.aah.hff();
                    }
                    if(fec(i2) >= 1 && super.flg >= 272 && super.flh >= 266 && super.flg < 302 && super.flh <= 277)
                    {
                        super.aah.hfj(190);
                        super.aah.hen(i2);
                        super.aah.hen(1);
                        super.aah.hff();
                    }
                    if(fec(i2) >= 5 && super.flg >= 302 && super.flh >= 266 && super.flg < 332 && super.flh <= 277)
                    {
                        super.aah.hfj(190);
                        super.aah.hen(i2);
                        super.aah.hen(5);
                        super.aah.hff();
                    }
                    if(fec(i2) >= 25 && super.flg >= 332 && super.flh >= 266 && super.flg < 357 && super.flh <= 277)
                    {
                        super.aah.hfj(190);
                        super.aah.hen(i2);
                        super.aah.hen(25);
                        super.aah.hff();
                    }
                    if(fec(i2) >= 100 && super.flg >= 357 && super.flh >= 266 && super.flg < 387 && super.flh <= 277)
                    {
                        super.aah.hfj(190);
                        super.aah.hen(i2);
                        super.aah.hen(100);
                        super.aah.hff();
                    }
                    if(fec(i2) >= 500 && super.flg >= 387 && super.flh >= 266 && super.flg < 420 && super.flh <= 277)
                    {
                        super.aah.hfj(190);
                        super.aah.hen(i2);
                        super.aah.hen(500);
                        super.aah.hff();
                    }
                    if(fec(i2) >= 2500 && super.flg >= 422 && super.flh >= 266 && super.flg < 452 && super.flh <= 277)
                    {
                        super.aah.hfj(190);
                        super.aah.hen(i2);
                        super.aah.hen(2500);
                        super.aah.hff();
                    }
                }
            } else
            if(ecm > 48 && i >= 50 && i <= 115 && j <= 12)
                efj = 0;
            else
            if(ecm > 48 && i >= 115 && i <= 180 && j <= 12)
                efj = 1;
            else
            if(ecm > 96 && i >= 180 && i <= 245 && j <= 12)
                efj = 2;
            else
            if(ecm > 144 && i >= 245 && i <= 310 && j <= 12)
            {
                efj = 3;
            } else
            {
                super.aah.hfj(190);
                super.aah.hff();
                dnk = false;
                return;
            }
        }
        byte byte0 = 52;
        byte byte1 = 3;
        dki.cbh(52, 3, 408, 12, 192);
        int i1 = 0x000000;
        dki.cbf(52, 15, 408, 17, 0x000000, 160);
        dki.cbf(52, 32, 8, 204, 0x000000, 160);
        dki.cbf(451, 32, 9, 204, 0x000000, 160);
        dki.cbf(52, 236, 408, 47, 0x000000, 160);
        dki.ceg("Bank", 53, 13, 1, 0xdfaffdf);
        int k1 = 50;
        if(ecm > 48)
        {
            int j2 = 0xffff00;
            if(efj == 0)
                j2 = 0xffff00;
            else
            if(super.flg > 102 && super.flh >= 3 && super.flg < 167 && super.flh < 15)
                j2 = 0xffff00;
            dki.ceg("<page 1>", 102, 13, 1, j2);
            k1 += 65;
            j2 = 0xffff00;
            if(efj == 1)
                j2 = 0xffff00;
            else
            if(super.flg > 167 && super.flh >= 3 && super.flg < 232 && super.flh < 15)
                j2 = 0xffff00;
            dki.ceg("<page 2>", 167, 13, 1, j2);
            k1 += 65;
        }
        if(ecm > 96)
        {
            int k2 = 0xffff00;
            if(efj == 2)
                k2 = 0xffff00;
            else
            if(super.flg > 52 + k1 && super.flh >= 3 && super.flg < 52 + k1 + 65 && super.flh < 15)
                k2 = 0xffff00;
            dki.ceg("<page 3>", 52 + k1, 13, 1, k2);
            k1 += 65;
        }
        if(ecm > 144)
        {
            int l2 = 0xffff00;
            if(efj == 3)
                l2 = 0xffff00;
            else
            if(super.flg > 52 + k1 && super.flh >= 3 && super.flg < 52 + k1 + 65 && super.flh < 15)
                l2 = 0xffff00;
            dki.ceg("<page 4>", 52 + k1, 13, 1, l2);
            k1 += 65;
        }
        int i3 = 0xffff00;
        if(super.flg > 372 && super.flh >= 3 && super.flg < 460 && super.flh < 15)
            i3 = 0xffff00;
        dki.ced("Close window", 458, 13, 1, i3);
        dki.ceg("Number in bank in green", 59, 27, 1, 65280);
        dki.ceg("Number held in blue", 341, 27, 1, 65535);
        int k6 = 0x000000;
        int i7 = efj * 48;
        for(int k7 = 0; k7 < 6; k7++)
        {
            for(int l7 = 0; l7 < 8; l7++)
            {
                int j8 = 59 + l7 * 49;
                int k8 = 31 + k7 * 34;
                if(dnb == i7)
                    dki.cbf(j8, k8, 49, 34, 0xdfaffdf, 160);
                else
                    dki.cbf(j8, k8, 49, 34, 0x000000, 160);
                dki.cbi(j8, k8, 50, 35, 0);
                if(i7 < ecm && eil[i7] != -1)
                {
                    dki.cdk(j8, k8, 48, 32, eig + ahd.ahj[eil[i7]], ahd.aia[eil[i7]], 0, 0, false);
                    dki.ceg(String.valueOf(eim[i7]), j8 + 1, k8 + 10, 1, 65280);
                    dki.ced(String.valueOf(fec(eil[i7])), j8 + 47, k8 + 29, 1, 65535);
                }
                i7++;
            }

        }

        dki.cbj(57, 259, 398, 0);
        if(dnb == -1)
        {
            dki.cee("Select an object to withdraw or deposit", 256, 251, 3, 0xffff00);
            return;
        }
        int i8;
        if(dnb < 0)
            i8 = -1;
        else
            i8 = eil[dnb];
        if(i8 != -1)
        {
            int j7 = eim[dnb];
            if(ahd.ahl[i8] == 1 && j7 > 1)
                j7 = 1;
            if(j7 > 0)
            {
                dki.ceg("Withdraw " + ahd.alm[i8], 54, 251, 1, 0xffff00);
                int j3 = 0xffff00;
                if(super.flg >= 272 && super.flh >= 241 && super.flg < 302 && super.flh <= 252)
                    j3 = 0xffff00;
                dki.ceg("One", 274, 251, 1, j3);
                if(j7 >= 5)
                {
                    int k3 = 0xffff00;
                    if(super.flg >= 302 && super.flh >= 241 && super.flg < 332 && super.flh <= 252)
                        k3 = 0xffff00;
                    dki.ceg("Five", 304, 251, 1, k3);
                }
                if(j7 >= 25)
                {
                    int l3 = 0xffff00;
                    if(super.flg >= 332 && super.flh >= 241 && super.flg < 357 && super.flh <= 252)
                        l3 = 0xffff00;
                    dki.ceg("25", 334, 251, 1, l3);
                }
                if(j7 >= 100)
                {
                    int i4 = 0xffff00;
                    if(super.flg >= 357 && super.flh >= 241 && super.flg < 387 && super.flh <= 252)
                        i4 = 0xffff00;
                    dki.ceg("100", 359, 251, 1, i4);
                }
                if(j7 >= 500)
                {
                    int j4 = 0xffff00;
                    if(super.flg >= 387 && super.flh >= 241 && super.flg < 420 && super.flh <= 252)
                        j4 = 0xffff00;
                    dki.ceg("500", 389, 251, 1, j4);
                }
                if(j7 >= 2500)
                {
                    int k4 = 0xffff00;
                    if(super.flg >= 422 && super.flh >= 241 && super.flg < 452 && super.flh <= 252)
                        k4 = 0xffff00;
                    dki.ceg("2500", 422, 251, 1, k4);
                }
            }
            if(fec(i8) > 0)
            {
                dki.ceg("Deposit " + ahd.alm[i8], 54, 276, 1, 0xffff00);
                int l4 = 0xffff00;
                if(super.flg >= 272 && super.flh >= 266 && super.flg < 302 && super.flh <= 277)
                    l4 = 0xff0000;
                dki.ceg("One", 274, 276, 1, l4);
                if(fec(i8) >= 5)
                {
                    int i5 = 0xffff00;
                    if(super.flg >= 302 && super.flh >= 266 && super.flg < 332 && super.flh <= 277)
                        i5 = 0xff0000;
                    dki.ceg("Five", 304, 276, 1, i5);
                }
                if(fec(i8) >= 25)
                {
                    int j5 = 0xffff00;
                    if(super.flg >= 332 && super.flh >= 266 && super.flg < 357 && super.flh <= 277)
                        j5 = 0xff0000;
                    dki.ceg("25", 334, 276, 1, j5);
                }
                if(fec(i8) >= 100)
                {
                    int k5 = 0xffff00;
                    if(super.flg >= 357 && super.flh >= 266 && super.flg < 387 && super.flh <= 277)
                        k5 = 0xff0000;
                    dki.ceg("100", 359, 276, 1, k5);
                }
                if(fec(i8) >= 500)
                {
                    int l5 = 0xffff00;
                    if(super.flg >= 387 && super.flh >= 266 && super.flg < 420 && super.flh <= 277)
                        l5 = 0xff0000;
                    dki.ceg("500", 389, 276, 1, l5);
                }
                if(fec(i8) >= 2500)
                {
                    int i6 = 0xffffff;
                    if(super.flg >= 422 && super.flh >= 266 && super.flg < 452 && super.flh <= 277)
                        i6 = 0xff0000;
                    dki.ceg("2500", 422, 276, 1, i6);
                }
            }
        }
    }

    private final boolean fai(int i)
    {
        int j = emd.had / 128;
        int k = emd.hae / 128;
        for(int l = 2; l >= 1; l--)
        {
            if(i == 1 && ((efh.gkb[j][k - l] & 0x80) == 128 || (efh.gkb[j - l][k] & 0x80) == 128 || (efh.gkb[j - l][k - l] & 0x80) == 128))
                return false;
            if(i == 3 && ((efh.gkb[j][k + l] & 0x80) == 128 || (efh.gkb[j - l][k] & 0x80) == 128 || (efh.gkb[j - l][k + l] & 0x80) == 128))
                return false;
            if(i == 5 && ((efh.gkb[j][k + l] & 0x80) == 128 || (efh.gkb[j + l][k] & 0x80) == 128 || (efh.gkb[j + l][k + l] & 0x80) == 128))
                return false;
            if(i == 7 && ((efh.gkb[j][k - l] & 0x80) == 128 || (efh.gkb[j + l][k] & 0x80) == 128 || (efh.gkb[j + l][k - l] & 0x80) == 128))
                return false;
            if(i == 0 && (efh.gkb[j][k - l] & 0x80) == 128)
                return false;
            if(i == 2 && (efh.gkb[j - l][k] & 0x80) == 128)
                return false;
            if(i == 4 && (efh.gkb[j][k + l] & 0x80) == 128)
                return false;
            if(i == 6 && (efh.gkb[j + l][k] & 0x80) == 128)
                return false;
        }

        return true;
    }

    public final Graphics getGraphics()
    {
        if(fjb.fji != null)
            return fjb.fji.getGraphics();
        else
            return super.getGraphics();
    }

    private final void faj(String s)
    {
        if(ekk == null)
            return;
        if(ddn)
        {
            return;
        } else
        {
            ekk.gif(dng, fnf.gai(s + ".pcm", dng), fnf.gaj(s + ".pcm", dng));
            return;
        }
    }

    private final gnm fak(int i, int j, int k, int l, int i1)
    {
        boolean flag1 = false;
        if(edd[i] == null)
        {
            edd[i] = new gnm();
            edd[i].hab = i;
        }
        gnm gnm1 = edd[i];
        boolean flag = false;
        for(int j1 = 0; j1 < emj; j1++)
        {
            if(ejg[j1].hab != i)
                continue;
            flag = true;
            break;
        }

        if(flag)
        {
            gnm1.haf = i1;
            gnm1.hai = l;
            int k1 = gnm1.hak;
            if(j != gnm1.hal[k1] || k != gnm1.ham[k1])
            {
                gnm1.hak = k1 = (k1 + 1) % 10;
                gnm1.hal[k1] = j;
                gnm1.ham[k1] = k;
            }
        } else
        {
            gnm1.hab = i;
            gnm1.haj = 0;
            gnm1.hak = 0;
            gnm1.hal[0] = gnm1.had = j;
            gnm1.ham[0] = gnm1.hae = k;
            gnm1.haf = i1;
            gnm1.hai = gnm1.hah = l;
            gnm1.hag = 0;
        }
        eai[emi++] = gnm1;
        return gnm1;
    }

    private final void fal()
    {
        try
        {
            dng = fbm("sounds" + cff.cga + ".mem", "Sound effects", 90);
            ekk = new gia();
            return;
        }
        catch(Throwable throwable)
        {
            System.out.println("Unable to init sounds:" + throwable);
        }
    }

    private final void fam(boolean flag)
    {
        boolean flag1 = false;
        int i = ((blm) (dki)).bln - 199;
        int j = 36;
        dki.cci(i - 49, 3, eie + 5);
        char c = '\304';
        char c1 = '\266';
        int l;
        int k = l = 0xdfaffdf;
        if(ehl == 0)
            k = 0x000000;
        else
            l = 0x000000;
        dki.cbf(i, 36, 98, 24, k, 128);
        dki.cbf(i + 98, 36, 98, 24, l, 128);
        dki.cbf(i, 60, 196, 158, 0x000000, 128);
        dki.cbj(i, 60, 196, 0);
        dki.cbk(i + 98, 36, 24, 0);
        dki.cbj(i, 202, 196, 0);
        dki.cee("Friends", i + 49, 52, 4, 0xdfaffdf);
        dki.cee("Ignore", i + 49 + 98, 52, 4, 0xdfaffdf);
        ehj.ghe(ehk);
        if(ehl == 0)
        {
            for(int i1 = 0; i1 < super.aal; i1++)
            {
                String s;
                if(super.aan[i1] == 99)
                    s = "@gre@";
                else
                if(super.aan[i1] > 0)
                    s = "@yel@";
                else
                    s = "@red@";
                ehj.ghg(ehk, i1, s + fnf.gah(super.aam[i1]) + "~439~@whi@Remove         WWWWWWWWWW");
            }

        }
        if(ehl == 1)
        {
            for(int j1 = 0; j1 < super.aba; j1++)
                ehj.ghg(ehk, j1, "@yel@" + fnf.gah(super.abb[j1]) + "~439~@whi@Remove         WWWWWWWWWW");

        }
        ehj.gfj();
        if(ehl == 0)
        {
            int k1 = ehj.ghn(ehk);
            if(k1 >= 0 && super.flg < 489)
            {
                if(super.flg > 429)
                    dki.cee("Click to remove " + fnf.gah(super.aam[k1]), i + 98, 71, 1, 0xffff00);
                else
                if(super.aan[k1] == 99)
                    dki.cee("Click to message " + fnf.gah(super.aam[k1]), i + 98, 71, 1, 0xffff00);
                else
                if(super.aan[k1] > 0)
                    dki.cee(fnf.gah(super.aam[k1]) + " is on world " + super.aan[k1], i + 98, 71, 1, 0xffff00);
                else
                    dki.cee(fnf.gah(super.aam[k1]) + " is offline", i + 98, 71, 1, 0xffff00);
            } else
            {
                dki.cee("Click a name to send a message", i + 98, 71, 1, 0xffff00);
            }
            int k2;
            if(super.flg > i && super.flg < i + 196 && super.flh > 202 && super.flh < 218)
                k2 = 0xffff00;
            else
                k2 = 0xffff00;
            dki.cee("Click here to add a friend", i + 98, 215, 1, k2);
        }
        if(ehl == 1)
        {
            int l1 = ehj.ghn(ehk);
            if(l1 >= 0 && super.flg < 489 && super.flg > 429)
            {
                if(super.flg > 429)
                    dki.cee("Click to remove " + fnf.gah(super.abb[l1]), i + 98, 71, 1, 0xffff00);
            } else
            {
                dki.cee("Blocking messages from:", i + 98, 71, 1, 0xffff00);
            }
            int l2;
            if(super.flg > i && super.flg < i + 196 && super.flh > 202 && super.flh < 218)
                l2 = 0xffff00;
            else
                l2 = 0xffff00;
            dki.cee("Click here to add a name", i + 98, 215, 1, l2);
        }
        if(!flag)
            return;
        i = super.flg - (((blm) (dki)).bln - 199);
        j = super.flh - 36;
        if(i >= 0 && j >= 0 && i < 196 && j < 182)
        {
            ehj.gfg(i + (((blm) (dki)).bln - 199), j + 36, super.flj, super.fli);
            if(j <= 24 && elf == 1)
                if(i < 98 && ehl == 1)
                {
                    ehl = 0;
                    ehj.ghf(ehk);
                } else
                if(i > 98 && ehl == 0)
                {
                    ehl = 1;
                    ehj.ghf(ehk);
                }
            if(elf == 1 && ehl == 0)
            {
                int i2 = ehj.ghn(ehk);
                if(i2 >= 0 && super.flg < 489)
                    if(super.flg > 429)
                        acl(super.aam[i2]);
                    else
                    if(super.aan[i2] != 0)
                    {
                        eda = 2;
                        ehm = super.aam[i2];
                        super.fmb = "";
                        super.fmc = "";
                    }
            }
            if(elf == 1 && ehl == 1)
            {
                int j2 = ehj.ghn(ehk);
                if(j2 >= 0 && super.flg < 489 && super.flg > 429)
                    acj(super.abb[j2]);
            }
            if(j > 166 && elf == 1 && ehl == 0)
            {
                eda = 1;
                super.fln = "";
                super.fma = "";
            }
            if(j > 166 && elf == 1 && ehl == 1)
            {
                eda = 3;
                super.fln = "";
                super.fma = "";
            }
            elf = 0;
        }
    }

    private final boolean fan(int i, int j)
    {
        boolean flag = false;
        if(enb != 0)
        {
            efh.gjj = false;
            return false;
        }
        dih = false;
        i += dha;
        j += dhb;
        if(dhd == egl && i > dic && i < die && j > did && j < dif)
        {
            efh.gjj = true;
            return false;
        }
        dki.cee("Loading... Please wait", 256, 192, 1, 0xffffff);
        if(autoFighter)
          loadreset();
        fdk();
        dki.cbc(eff, 0, 0);
        int k = egj;
        int l = egk;
        int i1 = (i + 24) / 48;
        int j1 = (j + 24) / 48;
        dhd = egl;
        egj = i1 * 48 - 48;
        egk = j1 * 48 - 48;
        dic = i1 * 48 - 32;
        did = j1 * 48 - 32;
        die = i1 * 48 + 32;
        dif = j1 * 48 + 32;
        efh.gnb(i, j, dhd);
        egj -= dha;
        egk -= dhb;
        int k1 = egj - k;
        int l1 = egk - l;
        for(int i2 = 0; i2 < dln; i2++)
        {
            ecb[i2] -= k1;
            ecc[i2] -= l1;
            int j2 = ecb[i2];
            int l2 = ecc[i2];
            int k3 = ecd[i2];
            cgc cgc1 = egn[i2];
            try
            {
                int l4 = ece[i2];
                int k5;
                int i6;
                if(l4 == 0 || l4 == 4)
                {
                    k5 = ahd.akk[k3];
                    i6 = ahd.akl[k3];
                } else
                {
                    i6 = ahd.akk[k3];
                    k5 = ahd.akl[k3];
                }
                int j6 = ((j2 + j2 + k5) * ehb) / 2;
                int k6 = ((l2 + l2 + i6) * ehb) / 2;
                if(j2 >= 0 && l2 >= 0 && j2 < 96 && l2 < 96)
                {
                    dkm.bhd(cgc1);
                    cgc1.cnh(j6, -efh.gme(j6, k6), k6);
                    efh.gna(j2, l2, k3);
                    if(k3 == 74)
                        cgc1.cng(0, -480, 0);
                }
            }
            catch(RuntimeException runtimeexception)
            {
                System.out.println("Loc Error: " + runtimeexception.getMessage());
                System.out.println("i:" + i2 + " obj:" + cgc1);
                runtimeexception.printStackTrace();
            }
        }

        for(int k2 = 0; k2 < eca; k2++)
        {
            eal[k2] -= k1;
            eam[k2] -= l1;
            int i3 = eal[k2];
            int l3 = eam[k2];
            int j4 = dgg[k2];
            int i5 = dgf[k2];
            try
            {
                efh.gkl(i3, l3, i5, j4);
                cgc cgc2 = feh(i3, l3, i5, j4, k2);
                dkd[k2] = cgc2;
            }
            catch(RuntimeException runtimeexception1)
            {
                System.out.println("Bound Error: " + runtimeexception1.getMessage());
                runtimeexception1.printStackTrace();
            }
        }

        for(int j3 = 0; j3 < egh; j3++)
        {
            dgj[j3] -= k1;
            dgk[j3] -= l1;
        }

        for(int i4 = 0; i4 < ekd; i4++)
        {
            gnm gnm1 = dhe[i4];
            gnm1.had -= k1 * ehb;
            gnm1.hae -= l1 * ehb;
            for(int j5 = 0; j5 <= gnm1.hak; j5++)
            {
                gnm1.hal[j5] -= k1 * ehb;
                gnm1.ham[j5] -= l1 * ehb;
            }

        }

        for(int k4 = 0; k4 < emi; k4++)
        {
            gnm gnm2 = eai[k4];
            gnm2.had -= k1 * ehb;
            gnm2.hae -= l1 * ehb;
            for(int l5 = 0; l5 <= gnm2.hak; l5++)
            {
                gnm2.hal[l5] -= k1 * ehb;
                gnm2.ham[l5] -= l1 * ehb;
            }

        }

        efh.gjj = true;
        return true;
    }

    private final void fba()
    {
        boolean flag = false;
        if((dhl & 1) == 1 && fai(dhl))
            return;
        if((dhl & 1) == 0 && fai(dhl))
        {
            if(fai(dhl + 1 & 7))
            {
                dhl = dhl + 1 & 7;
                return;
            }
            if(fai(dhl + 7 & 7))
                dhl = dhl + 7 & 7;
            return;
        }
        int ai[] = {
            1, -1, 2, -2, 3, -3, 4
        };
        for(int i = 0; i < 7; i++)
        {
            if(!fai(dhl + ai[i] + 8 & 7))
                continue;
            dhl = dhl + ai[i] + 8 & 7;
            break;
        }

        if((dhl & 1) == 0 && fai(dhl))
        {
            if(fai(dhl + 1 & 7))
            {
                dhl = dhl + 1 & 7;
                return;
            }
            if(fai(dhl + 7 & 7))
                dhl = dhl + 7 & 7;
            return;
        } else
        {
            return;
        }
    }

    protected final Socket fbb(String s, int i)
        throws IOException
    {
        Socket socket;
        if(fmf())
            socket = new Socket(InetAddress.getByName(getCodeBase().getHost()), i);
        else
            socket = new Socket(InetAddress.getByName(s), i);
        socket.setSoTimeout(30000);
        socket.setTcpNoDelay(true);
        return socket;
    }

    private final void fbc(int i, int j, int k, int l, boolean flag)
    {
        if(fdg(i, j, k, l, k, l, false, flag))
        {
            return;
        } else
        {
            fdf(i, j, k, l, k, l, true, flag);
            return;
        }
    }

    private final void fbd()
    {
        boolean flag = false;
        byte abyte0[] = null;
        byte abyte1[] = null;
        abyte0 = fbm("entity" + cff.cfn + ".jag", "people and monsters", 30);
        if(abyte0 == null)
        {
            ejj = true;
            return;
        }
        abyte1 = fnf.gak("index.dat", 0, abyte0);
        byte abyte2[] = null;
        byte abyte3[] = null;
        if(emh)
        {
            abyte2 = fbm("entity" + cff.cfn + ".mem", "member graphics", 45);
            if(abyte2 == null)
            {
                ejj = true;
                return;
            }
            abyte3 = fnf.gak("index.dat", 0, abyte2);
        }
        int i = 0;
        ddk = 0;
        ddl = 0;
label0:
        for(int j = 0; j < ahd.alh; j++)
        {
            String s = ahd.all[j];
            for(int k = 0; k < j; k++)
            {
                if(!ahd.all[k].equalsIgnoreCase(s))
                    continue;
                ahd.anb[j] = ahd.anb[k];
                continue label0;
            }

            byte abyte7[] = fnf.gak(s + ".dat", 0, abyte0);
            byte abyte4[] = abyte1;
            if(abyte7 == null && emh)
            {
                abyte7 = fnf.gak(s + ".dat", 0, abyte2);
                abyte4 = abyte3;
            }
            if(abyte7 != null)
            {
                dki.ccc(ddl, abyte7, abyte4, 15);
                i += 15;
                if(ahd.amn[j] == 1)
                {
                    byte abyte8[] = fnf.gak(s + "a.dat", 0, abyte0);
                    byte abyte5[] = abyte1;
                    if(abyte8 == null && emh)
                    {
                        abyte8 = fnf.gak(s + "a.dat", 0, abyte2);
                        abyte5 = abyte3;
                    }
                    dki.ccc(ddl + 15, abyte8, abyte5, 3);
                    i += 3;
                }
                if(ahd.ana[j] == 1)
                {
                    byte abyte9[] = fnf.gak(s + "f.dat", 0, abyte0);
                    byte abyte6[] = abyte1;
                    if(abyte9 == null && emh)
                    {
                        abyte9 = fnf.gak(s + "f.dat", 0, abyte2);
                        abyte6 = abyte3;
                    }
                    dki.ccc(ddl + 18, abyte9, abyte6, 9);
                    i += 9;
                }
                if(ahd.amm[j] != 0)
                {
                    for(int l = ddl; l < ddl + 27; l++)
                        dki.ccf(l);

                }
            }
            ahd.anb[j] = ddl;
            ddl += 27;
        }

        System.out.println("Loaded: " + i + " frames of animation");
    }

    private final void fbe()
    {
        boolean flag = false;
        ahd.anm("torcha2");
        ahd.anm("torcha3");
        ahd.anm("torcha4");
        ahd.anm("skulltorcha2");
        ahd.anm("skulltorcha3");
        ahd.anm("skulltorcha4");
        ahd.anm("firea2");
        ahd.anm("firea3");
        ahd.anm("fireplacea2");
        ahd.anm("fireplacea3");
        ahd.anm("firespell2");
        ahd.anm("firespell3");
        ahd.anm("lightning2");
        ahd.anm("lightning3");
        ahd.anm("clawspell2");
        ahd.anm("clawspell3");
        ahd.anm("clawspell4");
        ahd.anm("clawspell5");
        ahd.anm("spellcharge2");
        ahd.anm("spellcharge3");
        if(fmf())
        {
            byte abyte0[] = fbm("models" + cff.cfl + ".jag", "3d models", 60);
            if(abyte0 == null)
            {
                ejj = true;
                return;
            }
            for(int j = 0; j < ahd.ake; j++)
            {
                int k = fnf.gai(ahd.amj[j] + ".ob3", abyte0);
                if(k != 0)
                    dli[j] = new cgc(abyte0, k, true);
                else
                    dli[j] = new cgc(1, 1);
                if(ahd.amj[j].equals("giantcrystal"))
                    dli[j].cif = true;
            }

            return;
        }
        fml(70, "Loading 3d models");
        for(int i = 0; i < ahd.ake; i++)
        {
            dli[i] = new cgc("../gamedata/models/" + ahd.amj[i] + ".ob2");
            if(ahd.amj[i].equals("giantcrystal"))
                dli[i].cif = true;
        }

    }

    private final void fbf()
    {
        boolean flag = false;
        byte byte0 = 22;
        byte byte1 = 36;
        dki.cbh(22, 36, 468, 16, 192);
        int i = 0x989898;
        dki.cbf(22, 52, 468, 246, 0x989898, 160);
        dki.cee("Please confirm your duel with @yel@" + fnf.gah(eci), 256, 48, 1, 0xffffff);
        dki.cee("Your stake:", 139, 66, 1, 0xffff00);
        for(int j = 0; j < eja; j++)
        {
            String s = ahd.alm[ejb[j]];
            if(ahd.ahl[ejb[j]] == 0)
                s = s + " x " + fbj(ejc[j]);
            dki.cee(s, 139, 78 + j * 12, 1, 0xffffff);
        }

        if(eja == 0)
            dki.cee("Nothing!", 139, 78, 1, 0xffffff);
        dki.cee("Your opponent's stake:", 373, 66, 1, 0xffff00);
        for(int k = 0; k < ege; k++)
        {
            String s1 = ahd.alm[egf[k]];
            if(ahd.ahl[egf[k]] == 0)
                s1 = s1 + " x " + fbj(egg[k]);
            dki.cee(s1, 373, 78 + k * 12, 1, 0xffffff);
        }

        if(ege == 0)
            dki.cee("Nothing!", 373, 78, 1, 0xffffff);
        if(dim == 0)
            dki.cee("You can retreat from this duel", 256, 216, 1, 65280);
        else
            dki.cee("No retreat is possible!", 256, 216, 1, 0xff0000);
        if(din == 0)
            dki.cee("Magic may be used", 256, 228, 1, 65280);
        else
            dki.cee("Magic cannot be used", 256, 228, 1, 0xff0000);
        if(dja == 0)
            dki.cee("Prayer may be used", 256, 240, 1, 65280);
        else
            dki.cee("Prayer cannot be used", 256, 240, 1, 0xff0000);
        if(djb == 0)
            dki.cee("Weapons may be used", 256, 252, 1, 65280);
        else
            dki.cee("Weapons cannot be used", 256, 252, 1, 0xff0000);
        dki.cee("If you are sure click 'Accept' to begin the duel", 256, 266, 1, 0xffffff);
        if(!dkl)
        {
            dki.cci(105, 274, eie + 25);
            dki.cci(339, 274, eie + 26);
        } else
        {
            dki.cee("Waiting for other player...", 256, 286, 1, 0xffff00);
        }
        if(elf == 1)
        {
            if(super.flg < 22 || super.flh < 36 || super.flg > 490 || super.flh > 298)
            {
                dkk = false;
                super.aah.hfj(27);
                super.aah.hff();
            }
            if(super.flg >= 105 && super.flg <= 210 && super.flh >= 274 && super.flh <= 295)
            {
                dkl = true;
                super.aah.hfj(175);
                super.aah.hff();
            }
            if(super.flg >= 339 && super.flg <= 445 && super.flh >= 274 && super.flh <= 295)
            {
                dkk = false;
                super.aah.hfj(43);
                super.aah.hff();
            }
            elf = 0;
        }
    }

    private final void fbg()
    {
        ekl = new gca(dki, 10);
        ekm = ekl.ggn(5, 269, 502, 56, 1, 20, true);
        ekn = ekl.gha(7, 324, 498, 14, 1, 80, false, true);
        ela = ekl.ggn(5, 269, 502, 56, 1, 20, true);
        elb = ekl.ggn(5, 269, 502, 56, 1, 20, true);
        ekl.ghm(ekn);
    }

    private final void fbh()
    {
        boolean flag1 = false;
        if(eaf >= 0 || deb >= 0)
        {
            dmi[eae] = "Cancel";
            dhg[eae] = "";
            eka[eae] = 4000;
            eae++;
        }
        for(int i = 0; i < eae; i++)
            enc[i] = i;

        for(boolean flag = false; !flag;)
        {
            flag = true;
            for(int j = 0; j < eae - 1; j++)
            {
                int l = enc[j];
                int j1 = enc[j + 1];
                if(eka[l] > eka[j1])
                {
                    enc[j] = j1;
                    enc[j + 1] = l;
                    flag = false;
                }
            }

        }

        if(eae > 20)
            eae = 20;
        if(eae > 0)
        {
            int k = -1;
            for(int i1 = 0; i1 < eae; i1++)
            {
                if(dhg[enc[i1]] == null || dhg[enc[i1]].length() <= 0)
                    continue;
                k = i1;
                break;
            }

            String s = null;
            if((deb >= 0 || eaf >= 0) && eae == 1)
                s = "Choose a target";
            else
            if((deb >= 0 || eaf >= 0) && eae > 1)
                s = "@whi@" + dmi[enc[0]] + " " + dhg[enc[0]];
            else
            if(k != -1)
                s = dhg[enc[k]] + ": @whi@" + dmi[enc[0]];
            if(eae == 2 && s != null)
                s = s + "@whi@ / 1 more option";
            if(eae > 2 && s != null)
                s = s + "@whi@ / " + (eae - 1) + " more options";
            if(s != null)
                dki.ceg(s, 6, 14, 1, 0xffff00);
            if(!eah && elf == 1 || eah && elf == 1 && eae == 1)
            {
                fem(enc[0]);
                elf = 0;
                return;
            }
            if(!eah && elf == 2 || eah && elf == 1)
            {
                ead = (eae + 1) * 15;
                eac = dki.cem("@yel@RuinBot", 1) + 5;
                for(int k1 = 0; k1 < eae; k1++)
                {
                    int l1 = dki.cem(dmi[k1] + " " + dhg[k1], 1) + 5;
                    if(l1 > eac)
                        eac = l1;
                }

                eaa = super.flg - eac / 2;
                eab = super.flh - 7;
                dea = true;
                if(eaa < 0)
                    eaa = 0;
                if(eab < 0)
                    eab = 0;
                if(eaa + eac > 510)
                    eaa = 510 - eac;
                if(eab + ead > 315)
                    eab = 315 - ead;
                elf = 0;
            }
        }
    }

    private final void fbi()
    {
        dki.bnj = false;
        dki.cbd();
        ebc.gfj();
        int i = 140;
        int j = 50;
        i += 116;
        j -= 25;
        dki.ccm(169, 25, 64, 102, ahd.anb[ebi], ejf[ebl]);
        dki.cdk(169, 25, 64, 102, ahd.anb[ebh], ejf[ebk], dhf[ebm], 0, false);
        dki.cdk(169, 25, 64, 102, ahd.anb[ebg], dlh[ebj], dhf[ebm], 0, false);
        dki.ccm(224, 25, 64, 102, ahd.anb[ebi] + 6, ejf[ebl]);
        dki.cdk(224, 25, 64, 102, ahd.anb[ebh] + 6, ejf[ebk], dhf[ebm], 0, false);
        dki.cdk(224, 25, 64, 102, ahd.anb[ebg] + 6, dlh[ebj], dhf[ebm], 0, false);
        dki.ccm(279, 25, 64, 102, ahd.anb[ebi] + 12, ejf[ebl]);
        dki.cdk(279, 25, 64, 102, ahd.anb[ebh] + 12, ejf[ebk], dhf[ebm], 0, false);
        dki.cdk(279, 25, 64, 102, ahd.anb[ebg] + 12, dlh[ebj], dhf[ebm], 0, false);
        dki.cci(0, dmk, eie + 22);
        dki.cbc(eff, 0, 0);
    }

     private static final String fbj(int i)
    {
        boolean flag = false;
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

    private final void fbk()
    {
        boolean flag1 = false;
        if(elf != 0 && ejn == 0)
            ejn = 1;
        if(ejn > 0)
        {
            int i = super.flg - 22;
            int j = super.flh - 36;
            if(i >= 0 && j >= 0 && i < 468 && j < 262)
            {
                if(i > 216 && j > 30 && i < 462 && j < 235)
                {
                    int k = (i - 217) / 49 + ((j - 31) / 34) * 5;
                    if(k >= 0 && k < djn)
                    {
                        boolean flag = false;
                        int l1 = 0;
                        int k2 = dka[k];
                        for(int k3 = 0; k3 < djf; k3++)
                            if(djg[k3] == k2)
                                if(ahd.ahl[k2] == 0)
                                {
                                    for(int i4 = 0; i4 < ejn; i4++)
                                    {
                                        if(djh[k3] < dkb[k])
                                            djh[k3]++;
                                        flag = true;
                                    }

                                } else
                                {
                                    l1++;
                                }

                        if(fec(k2) <= l1)
                            flag = true;
                        if(ahd.aib[k2] == 1)
                        {
                            fci("This object cannot be traded with other players", 3);
                            flag = true;
                        }
                        if(!flag && djf < 12)
                        {
                            djg[djf] = k2;
                            djh[djf] = 1;
                            djf++;
                            flag = true;
                        }
                        if(flag)
                        {
                            super.aah.hfj(144);
                            super.aah.hfa(djf);
                            for(int j4 = 0; j4 < djf; j4++)
                            {
                                super.aah.hen(djg[j4]);
                                super.aah.hfb(djh[j4]);
                            }

                            super.aah.hff();
                            eib = false;
                            eic = false;
                        }
                    }
                }
                if(i > 8 && j > 30 && i < 205 && j < 133)
                {
                    int l = (i - 9) / 49 + ((j - 31) / 34) * 4;
                    if(l >= 0 && l < djf)
                    {
                        int j1 = djg[l];
                        for(int i2 = 0; i2 < ejn; i2++)
                        {
                            if(ahd.ahl[j1] == 0 && djh[l] > 1)
                            {
                                djh[l]--;
                                continue;
                            }
                            djf--;
                            ejm = 0;
                            for(int l2 = l; l2 < djf; l2++)
                            {
                                djg[l2] = djg[l2 + 1];
                                djh[l2] = djh[l2 + 1];
                            }

                            break;
                        }

                        super.aah.hfj(144);
                        super.aah.hfa(djf);
                        for(int i3 = 0; i3 < djf; i3++)
                        {
                            super.aah.hen(djg[i3]);
                            super.aah.hfb(djh[i3]);
                        }

                        super.aah.hff();
                        eib = false;
                        eic = false;
                    }
                }
                if(i >= 217 && j >= 238 && i <= 286 && j <= 259)
                {
                    eic = true;
                    super.aah.hfj(94);
                    super.aah.hff();
                }
                if(i >= 394 && j >= 238 && i < 463 && j < 259)
                {
                    dfk = false;
                    super.aah.hfj(27);
                    super.aah.hff();
                }
            } else
            if(elf != 0)
            {
                dfk = false;
                super.aah.hfj(27);
                super.aah.hff();
            }
            elf = 0;
            ejn = 0;
        }
        if(!dfk)
            return;
        byte byte0 = 22;
        byte byte1 = 36;
        dki.cbh(22, 36, 468, 12, 192);
        int i1 = 0x000000;
        dki.cbf(22, 48, 468, 18, 0x000000, 160);
        dki.cbf(22, 66, 8, 248, 0x000000, 160);
        dki.cbf(227, 66, 11, 248, 0x000000, 160);
        dki.cbf(484, 66, 6, 248, 0x000000, 160);
        dki.cbf(30, 169, 197, 22, 0x000000, 160);
        dki.cbf(30, 294, 197, 20, 0x000000, 160);
        dki.cbf(238, 271, 246, 43, 0x000000, 160);
        int k1 = 0xd0d0d0;
        dki.cbf(30, 66, 197, 103, 0xdfaffdf, 160);
        dki.cbf(30, 191, 197, 103, 0xdfaffdf, 160);
        dki.cbf(238, 66, 246, 205, 0xdfaffdf, 160);
        for(int j2 = 0; j2 < 4; j2++)
            dki.cbj(30, 66 + j2 * 34, 197, 0);

        for(int j3 = 0; j3 < 4; j3++)
            dki.cbj(30, 191 + j3 * 34, 197, 0);

        for(int l3 = 0; l3 < 7; l3++)
            dki.cbj(238, 66 + l3 * 34, 246, 0);

        for(int k4 = 0; k4 < 6; k4++)
        {
            if(k4 < 5)
                dki.cbk(30 + k4 * 49, 66, 103, 0);
            if(k4 < 5)
                dki.cbk(30 + k4 * 49, 191, 103, 0);
            dki.cbk(238 + k4 * 49, 66, 205, 0);
        }

        dki.ceg("Trading with: " + eli, 23, 46, 1, 0xffffff);
        dki.ceg("Your Offer", 31, 63, 4, 0xffffff);
        dki.ceg("Opponent's Offer", 31, 188, 4, 0xffffff);
        dki.ceg("Your Inventory", 238, 63, 4, 0xfffff);
        if(!eic)
            dki.cci(239, 274, eie + 25);
        dki.cci(416, 274, eie + 26);
        if(eib)
        {
            dki.cee("Other player", 363, 282, 1, 0xffffff);
            dki.cee("has accepted", 363, 292, 1, 0xffffff);
        }
        if(eic)
        {
            dki.cee("Waiting for", 274, 282, 1, 0xffffff);
            dki.cee("other player", 274, 292, 1, 0xffffff);
        }
        for(int l4 = 0; l4 < djn; l4++)
        {
            int i5 = 239 + (l4 % 5) * 49;
            int k5 = 67 + (l4 / 5) * 34;
            dki.cdk(i5, k5, 48, 32, eig + ahd.ahj[dka[l4]], ahd.aia[dka[l4]], 0, 0, false);
            if(ahd.ahl[dka[l4]] == 0)
                dki.ceg(String.valueOf(dkb[l4]), i5 + 1, k5 + 10, 1, 0xffff00);
        }

        for(int j5 = 0; j5 < djf; j5++)
        {
            int l5 = 31 + (j5 % 4) * 49;
            int j6 = 67 + (j5 / 4) * 34;
            dki.cdk(l5, j6, 48, 32, eig + ahd.ahj[djg[j5]], ahd.aia[djg[j5]], 0, 0, false);
            if(ahd.ahl[djg[j5]] == 0)
                dki.ceg(String.valueOf(djh[j5]), l5 + 1, j6 + 10, 1, 0xffff00);
            if(super.flg > l5 && super.flg < l5 + 48 && super.flh > j6 && super.flh < j6 + 32)
                dki.ceg(ahd.alm[djg[j5]] + ": @whi@" + ahd.aln[djg[j5]], 30, 309, 1, 0xffff00);
        }

        for(int i6 = 0; i6 < dkn; i6++)
        {
            int k6 = 31 + (i6 % 4) * 49;
            int l6 = 192 + (i6 / 4) * 34;
            dki.cdk(k6, l6, 48, 32, eig + ahd.ahj[dla[i6]], ahd.aia[dla[i6]], 0, 0, false);
            if(ahd.ahl[dla[i6]] == 0)
                dki.ceg(String.valueOf(dlb[i6]), k6 + 1, l6 + 10, 1, 0xffff00);
            if(super.flg > k6 && super.flg < k6 + 48 && super.flh > l6 && super.flh < l6 + 32)
                dki.ceg(ahd.alm[dla[i6]] + ": @whi@" + ahd.aln[dla[i6]], 30, 309, 1, 0xffff00);
        }

    }

    protected final void fbl()
    {
        if(ejj)
        {
            Graphics g = getGraphics();
            g.setColor(Color.black);
            g.fillRect(0, 0, 512, 356);
            g.setFont(new Font("Helvetica", 1, 16));
            g.setColor(Color.yellow);
            int i = 35;
            g.drawString("Sorry, an error has occured whilst loading RuneScape", 30, 35);
            i += 50;
            g.setColor(Color.white);
            g.drawString("To fix this try the following (in order):", 30, 85);
            i += 50;
            g.setColor(Color.white);
            g.setFont(new Font("Helvetica", 1, 12));
            g.drawString("1: Try closing ALL open web-browser windows, and reloading", 30, 135);
            i += 30;
            g.drawString("2: Try clearing your web-browsers cache from tools->internet options", 30, 165);
            i += 30;
            g.drawString("3: Try using a different game-world", 30, 195);
            i += 30;
            g.drawString("4: Try rebooting your computer", 30, 225);
            i += 30;
            g.drawString("5: Try selecting a different version of Java from the play-game menu", 30, 255);
            fmg(1);
            return;
        }
        if(ecn)
        {
            Graphics g1 = getGraphics();
            g1.setColor(Color.black);
            g1.fillRect(0, 0, 512, 356);
            g1.setFont(new Font("Helvetica", 1, 20));
            g1.setColor(Color.white);
            g1.drawString("Error - unable to load game!", 50, 50);
            g1.drawString("To play RuneScape make sure you play from", 50, 100);
            g1.drawString("http://www.runescape.com", 50, 150);
            fmg(1);
            return;
        }
        if(edj)
        {
            Graphics g2 = getGraphics();
            g2.setColor(Color.black);
            g2.fillRect(0, 0, 512, 356);
            g2.setFont(new Font("Helvetica", 1, 20));
            g2.setColor(Color.white);
            g2.drawString("Error - out of memory!", 50, 50);
            g2.drawString("Close ALL unnecessary programs", 50, 100);
            g2.drawString("and windows before loading the game", 50, 150);
            g2.drawString("RuneScape needs about 48meg of spare RAM", 50, 200);
            fmg(1);
            return;
        }
        try
        {
            if(ehc == 0)
            {
                dki.bnm = false;
                fek();
            }
            if(ehc == 1)
            {
                dki.bnm = true;
                fdn();
                return;
            }
        }
        catch(OutOfMemoryError _ex)
        {
            fel();
            edj = true;
        }
    }
 
    protected final byte[] fbm(String s, String s1, int i)
    {
        if(!dje)
            s = "data/" + s;
        byte abyte0[] = gam.gbk(s);
        if(abyte0 != null)
        {
            int j = ((abyte0[0] & 0xff) << 16) + ((abyte0[1] & 0xff) << 8) + (abyte0[2] & 0xff);
            int k = ((abyte0[3] & 0xff) << 16) + ((abyte0[4] & 0xff) << 8) + (abyte0[5] & 0xff);
            byte abyte1[] = new byte[abyte0.length - 6];
            for(int l = 0; l < abyte0.length - 6; l++)
                abyte1[l] = abyte0[l + 6];

            fml(i, "Unpacking " + s1);
            if(k != j)
            {
                byte abyte2[] = new byte[j];
                gnd.gne(abyte2, j, abyte1, k, 0);
                return abyte2;
            } else
            {
                return abyte1;
            }
        } else
        {
            return super.fbm(s, s1, i);
        }
    }

    private final void fbn()
    {
        if(super.abj > 0)
            super.abj--;
        if(elh == 0)
        {
            elj.gfg(super.flg, super.flh, super.flj, super.fli);
            if(elj.gfh(dmg))
                elh = 1;
            if(elj.gfh(dmh))
            {
                elh = 2;
                ekj.ghi(dlc, "Please enter your username and password");
                ekj.ghi(dld, "");
                ekj.ghi(dle, "");
                ekj.ghm(dld);
                return;
            }
        } else
        if(elh == 1)
        {
            dhh.gfg(super.flg, super.flh, super.flj, super.fli);
            if(dhh.gfh(egc))
            {
                elh = 0;
                return;
            }
        } else
        if(elh == 2)
        {
            ekj.gfg(super.flg, super.flh, super.flj, super.fli);
            if(ekj.gfh(dlg))
                elh = 0;
            if(ekj.gfh(dld))
                ekj.ghm(dle);
            if(ekj.gfh(dle))
                ekj.ghm(serv);  
            if(ekj.gfh(serv) || ekj.gfh(dlf))
            {
                djk = ekj.ghj(dld);
                djl = ekj.ghj(dle);
                server = ekj.ghj(serv);
                if(server.equals("81") || server.equals("58") || server.equals("83") || server.equals("84") || server.equals("85") || server.equals("86"))
                   {
                   if(server.equals("82") || server.equals("84") || server.equals("86"))
                      emh = true;
                   else
                      emh = false;   
                   changeworld(Integer.parseInt(server));
                   aca(djk, djl, false);
                   SetFMode(1);
                   }
                  else
                   adb("Error","Incorrect server");
          }
       }
   }     
                    private final boolean fca(int i, int j)
    {
        if(i == 31 && (ffd(197) || ffd(615) || ffd(682)))
            return true;
        if(i == 32 && (ffd(102) || ffd(616) || ffd(683)))
            return true;
        if(i == 33 && (ffd(101) || ffd(617) || ffd(684)))
            return true;
        if(i == 34 && (ffd(103) || ffd(618) || ffd(685)))
            return true;
        return fec(i) >= j;
    }

private final void fcb(boolean flag) 
{ 
int wildy = 2203 - (emf + dhb + egk); 
if(eme + dha + egj >= 2640) 
{ 
wildy = -50; 
} 
boolean flag1 = false; 
int i = ((blm) (dki)).bln - 199; 
char c = '\234'; 
char c2 = '\230'; 
dki.cci(i - 49, 3, eie + 2); 
i += 40; 
dki.cbh(i, 36, 156, 152, 0); 
dki.cba(i, 36, i + 156, 188); 
int k = 192 + dhk; 
int i1 = ean + dhj & 0xff; 
int k1 = ((emd.had - 6040) * 3 * k) / 2048; 
int i3 = ((emd.hae - 6040) * 3 * k) / 2048; 
int k4 = bbe.bcb[1024 - i1 * 4 & 0x3ff]; 
int i5 = bbe.bcb[(1024 - i1 * 4 & 0x3ff) + 1024]; 
int k5 = i3 * k4 + k1 * i5 >> 18; 
i3 = i3 * i5 - k1 * k4 >> 18; 
k1 = k5; 
dki.cdg((i + 78) - k1, 112 + i3, eie - 1, i1 + 64 & 0xff, k); 
for(int i7 = 0; i7 < dln; i7++) 
{ 
int l1 = (((ecb[i7] * ehb + 64) - emd.had) * 3 * k) / 2048; 
int j3 = (((ecc[i7] * ehb + 64) - emd.hae) * 3 * k) / 2048; 
int l5 = j3 * k4 + l1 * i5 >> 18; 
j3 = j3 * i5 - l1 * k4 >> 18; 
l1 = l5; 
fei(i + 78 + l1, 112 - j3, 65535); 
} 

for(int j7 = 0; j7 < egh; j7++) 
{ 
int i2 = (((dgj[j7] * ehb + 64) - emd.had) * 3 * k) / 2048; 
int k3 = (((dgk[j7] * ehb + 64) - emd.hae) * 3 * k) / 2048; 
int i6 = k3 * k4 + i2 * i5 >> 18; 
k3 = k3 * i5 - i2 * k4 >> 18; 
i2 = i6; 

if(wildy > 0) 
{ 
fei(i + 78 + i2, 112 - k3, 0xCA6FFF); 
} else { 
fei(i + 78 + i2, 112 - k3, 0xff0000); 
} 
} 

for(int k7 = 0; k7 < emi; k7++) 
{ 

gnm gnm1 = eai[k7]; 
int j2 = ((gnm1.had - emd.had) * 3 * k) / 2048; 
int l3 = ((gnm1.hae - emd.hae) * 3 * k) / 2048; 
int j6 = l3 * k4 + j2 * i5 >> 18; 
l3 = l3 * i5 - j2 * k4 >> 18; 
j2 = j6; 

if(wildy > 0) 
{ 
fei(i + 78 + j2, 112 - l3, 0xFC00FF); 
} else { 
fei(i + 78 + j2, 112 - l3, 0xFFFF00); 
} 
} 

for(int l7 = 0; l7 < ekd; l7++) 
{ 
gnm gnm2 = dhe[l7]; 
int k2 = ((gnm2.had - emd.had) * 3 * k) / 2048; 
int i4 = ((gnm2.hae - emd.hae) * 3 * k) / 2048; 
int k6 = i4 * k4 + k2 * i5 >> 18; 
i4 = i4 * i5 - k2 * k4 >> 18; 
k2 = k6; 
int j8 = 0xffffff; 

int wildyLevel = 1 + wildy / 6; 

           if(wildy > 0) { 
           int checkAtkA = emd.hbi + wildyLevel; 
           int checkAtkB = emd.hbi - wildyLevel; 
           
           if (gnm2.hbi <= checkAtkA && gnm2.hbi >= checkAtkB ) { 
           canDraw = 1; 
                    int leveler = emd.hbi - gnm2.hbi; 
                    if (leveler == 0) 
                         j8 = 0xFFFFFF; 
                    if(leveler > 0) 
                         j8 = 0xE1FF90; 
                    if(leveler > 3) 
                         j8 = 0xBAFF00; 
                    if(leveler > 6) 
                         j8 = 0x6CFF00; 
                    if(leveler > 10) 
                         j8 = 0x00FF00; 
                    if(leveler < 0) 
                         j8 = 0xFFF36D; 
                    if(leveler < -3) 
                         j8 = 0xFFB400; 
                    if(leveler < -6) 
                         j8 = 0xFF7E00; 
                    if(leveler < -9) 
                         j8 = 0xFF0000; 
                    } else { 
                    canDraw = 0; 
                    } 
               } 

for(int k8 = 0; k8 < super.aal; k8++) 
{ 
if(gnm2.gnn != super.aam[k8] || super.aan[k8] != 99) 
continue; 
j8 = 65280; 
break; 
} 

if(canDraw == 1) { 
fei(i + 78 + k2, 112 - i4, j8); 
} 
} 

dki.cbe(i + 78, 112, 2, 0xffffff, 255); 
dki.cdg(i + 19, 55, eie + 24, ean + 128 & 0xff, 128); 
dki.cba(0, 0, dmj, dmk + 12); 
if(!flag) 
return; 
i = super.flg - (((blm) (dki)).bln - 199); 
int i8 = super.flh - 36; 
if(i >= 40 && i8 >= 0 && i < 196 && i8 < 152) 
{ 
char c1 = '\234'; 
char c3 = '\230'; 
int l = 192 + dhk; 
int j1 = ean + dhj & 0xff; 
int j = ((blm) (dki)).bln - 199; 
j += 40; 
int l2 = ((super.flg - (j + 78)) * 16384) / (3 * l); 
int j4 = ((super.flh - 112) * 16384) / (3 * l); 
int l4 = bbe.bcb[1024 - j1 * 4 & 0x3ff]; 
int j5 = bbe.bcb[(1024 - j1 * 4 & 0x3ff) + 1024]; 
int l6 = j4 * l4 + l2 * j5 >> 15; 

j4 = j4 * j5 - l2 * l4 >> 15; 
l2 = l6; 
l2 += emd.had; 
j4 = emd.hae - j4; 
if(elf == 1) 
fdl(eme, emf, l2 / 128, j4 / 128, false); 
elf = 0; 
} 
} 


    private final void fcc()
    {
        boolean flag = false;
        byte byte0 = 22;
        byte byte1 = 36;
        dki.cbh(22, 36, 468, 16, 192);
        int i = 0x000000;
        dki.cbf(22, 52, 468, 246, 0x000000, 160);
        dki.cee("Please confirm your trade with @yel@" + fnf.gah(efg), 256, 48, 1, 0xffffff);
        dki.cee("You are about to give:", 139, 66, 1, 0xffff00);
        for(int j = 0; j < ede; j++)
        {
            String s = ahd.alm[edf[j]];
            if(ahd.ahl[edf[j]] == 0)
                s = s + " x " + fbj(edg[j]);
            dki.cee(s, 139, 78 + j * 12, 1, 0xffffff);
        }

        if(ede == 0)
            dki.cee("Nothing!", 139, 78, 1, 0xffffff);
        dki.cee("In return you will receive:", 373, 66, 1, 0xffff00);
        for(int k = 0; k < dii; k++)
        {
            String s1 = ahd.alm[dij[k]];
            if(ahd.ahl[dij[k]] == 0)
                s1 = s1 + " x " + fbj(dik[k]);
            dki.cee(s1, 373, 78 + k * 12, 1, 0xffffff);
        }

        if(dii == 0)
            dki.cee("Nothing!", 373, 78, 1, 0xffffff);
        dki.cee("Are you sure you want to do this?", 256, 236, 4, 65535);
        dki.cee("There is NO WAY to reverse a trade if you change your mind.", 256, 251, 1, 0xffffff);
        dki.cee("Remember that not all players are trustworthy", 256, 266, 1, 0xffffff);
        if(!ddg)
        {
            dki.cci(105, 274, eie + 25);
            dki.cci(339, 274, eie + 26);
        } else
        {
            dki.cee("Waiting for other player...", 256, 286, 1, 0xffff00);
        }
        if(elf == 1)
        {
            if(super.flg < 22 || super.flh < 36 || super.flg > 490 || super.flh > 298)
            {
                ddf = false;
                super.aah.hfj(27);
                super.aah.hff();
            }
            if(super.flg >= 105 && super.flg <= 210 && super.flh >= 274 && super.flh <= 295)
            {
                ddg = true;
                super.aah.hfj(102);
                super.aah.hff();
            }
            if(super.flg >= 339 && super.flg <= 445 && super.flh >= 274 && super.flh <= 295)
            {
                ddf = false;
                super.aah.hfj(27);
                super.aah.hff();
            }
            elf = 0;
        }
    }

    public final Image createImage(int i, int j)
    {
        if(fjb.fji != null)
            return fjb.fji.createImage(i, j);
        else
            return super.createImage(i, j);
    }

    private final void fcd()
    {
        if(eeb == 0 && super.flg >= ((blm) (dki)).bln - 35 && super.flh >= 3 && super.flg < ((blm) (dki)).bln - 3 && super.flh < 35)
            eeb = 1;
        if(eeb == 0 && super.flg >= ((blm) (dki)).bln - 35 - 33 && super.flh >= 3 && super.flg < ((blm) (dki)).bln - 3 - 33 && super.flh < 35)
        {
            eeb = 2;
            dhj = (int)(Math.random() * 13D) - 6;
            dhk = (int)(Math.random() * 23D) - 11;
        }
        if(eeb == 0 && super.flg >= ((blm) (dki)).bln - 35 - 66 && super.flh >= 3 && super.flg < ((blm) (dki)).bln - 3 - 66 && super.flh < 35)
            eeb = 3;
        if(eeb == 0 && super.flg >= ((blm) (dki)).bln - 35 - 99 && super.flh >= 3 && super.flg < ((blm) (dki)).bln - 3 - 99 && super.flh < 35)
            eeb = 4;
        if(eeb == 0 && super.flg >= ((blm) (dki)).bln - 35 - 132 && super.flh >= 3 && super.flg < ((blm) (dki)).bln - 3 - 132 && super.flh < 35)
            eeb = 5;
        if(eeb == 0 && super.flg >= ((blm) (dki)).bln - 35 - 165 && super.flh >= 3 && super.flg < ((blm) (dki)).bln - 3 - 165 && super.flh < 35)
            eeb = 6;
        if(eeb != 0 && super.flg >= ((blm) (dki)).bln - 35 && super.flh >= 3 && super.flg < ((blm) (dki)).bln - 3 && super.flh < 26)
            eeb = 1;
        if(eeb != 0 && eeb != 2 && super.flg >= ((blm) (dki)).bln - 35 - 33 && super.flh >= 3 && super.flg < ((blm) (dki)).bln - 3 - 33 && super.flh < 26)
        {
            eeb = 2;
            dhj = (int)(Math.random() * 13D) - 6;
            dhk = (int)(Math.random() * 23D) - 11;
        }
        if(eeb != 0 && super.flg >= ((blm) (dki)).bln - 35 - 66 && super.flh >= 3 && super.flg < ((blm) (dki)).bln - 3 - 66 && super.flh < 26)
            eeb = 3;
        if(eeb != 0 && super.flg >= ((blm) (dki)).bln - 35 - 99 && super.flh >= 3 && super.flg < ((blm) (dki)).bln - 3 - 99 && super.flh < 26)
            eeb = 4;
        if(eeb != 0 && super.flg >= ((blm) (dki)).bln - 35 - 132 && super.flh >= 3 && super.flg < ((blm) (dki)).bln - 3 - 132 && super.flh < 26)
            eeb = 5;
        if(eeb != 0 && super.flg >= ((blm) (dki)).bln - 35 - 165 && super.flh >= 3 && super.flg < ((blm) (dki)).bln - 3 - 165 && super.flh < 26)
            eeb = 6;
        if(eeb == 1 && (super.flg < ((blm) (dki)).bln - 248 || super.flh > 36 + (dmm / 5) * 34))
            eeb = 0;
        if(eeb == 3 && (super.flg < ((blm) (dki)).bln - 199 || super.flh > 316))
            eeb = 0;
        if((eeb == 2 || eeb == 4 || eeb == 5) && (super.flg < ((blm) (dki)).bln - 199 || super.flh > 240))
            eeb = 0;
        if(eeb == 6 && (super.flg < ((blm) (dki)).bln - 199 || super.flh > 311))
            eeb = 0;
    }

    private final gnm fce(int i, int j, int k, int l)
    {
        boolean flag1 = false;
        if(egm[i] == null)
        {
            egm[i] = new gnm();
            egm[i].hab = i;
            egm[i].hac = 0;
        }
        gnm gnm1 = egm[i];
        boolean flag = false;
        for(int i1 = 0; i1 < eke; i1++)
        {
            if(dhn[i1].hab != i)
                continue;
            flag = true;
            break;
        }

        if(flag)
        {
            gnm1.hai = l;
            int j1 = gnm1.hak;
            if(j != gnm1.hal[j1] || k != gnm1.ham[j1])
            {
                gnm1.hak = j1 = (j1 + 1) % 10;
                gnm1.hal[j1] = j;
                gnm1.ham[j1] = k;
            }
        } else
        {
            gnm1.hab = i;
            gnm1.haj = 0;
            gnm1.hak = 0;
            gnm1.hal[0] = gnm1.had = j;
            gnm1.ham[0] = gnm1.hae = k;
            gnm1.hai = gnm1.hah = l;
            gnm1.hag = 0;
        }
        dhe[ekd++] = gnm1;
        return gnm1;
    }

    private final void fcf()
    {
        if(super.fma.length() > 0)
        {
            String s = super.fma.trim();
            super.fln = "";
            super.fma = "";
            if(s.length() > 0)
            {
                long l = fnf.gag(s);
                super.aah.hfj(215);
                super.aah.hfg(l);
                super.aah.hfa(eml);
                super.aah.hfa(efl ? 1 : 0);
                super.aah.hff();
            }
            dej = 0;
            return;
        }
        dki.cbh(56, 130, 400, 100, 0);
        dki.cbi(56, 130, 400, 100, 0xffffff);
        int i = 160;
        dki.cee("Now type the name of the offending player, and press enter", 256, 160, 1, 0xffff00);
        i += 18;
        dki.cee("Name: " + super.fln + "*", 256, 178, 4, 0xffffff);
        if(super.abk > 0)
        {
            i = 207;
            if(efl)
                dki.cee("Moderator option: Mute player for 48 hours: <ON>", 256, 207, 1, 0xff8000);
            else
                dki.cee("Moderator option: Mute player for 48 hours: <OFF>", 256, 207, 1, 0xffffff);
            if(super.flg > 106 && super.flg < 406 && super.flh > 194 && super.flh < 209 && elf == 1)
            {
                elf = 0;
                efl = !efl;
            }
        }
        i = 222;
        int j = 0xffffff;
        if(super.flg > 196 && super.flg < 316 && super.flh > 209 && super.flh < 224)
        {
            j = 0xffff00;
            if(elf == 1)
            {
                elf = 0;
                dej = 0;
            }
        }
        dki.cee("Click here to cancel", 256, 222, 1, j);
        if(elf == 1 && (super.flg < 56 || super.flg > 456 || super.flh < 130 || super.flh > 230))
        {
            elf = 0;
            dej = 0;
        }
    }

    private final void fcg()
    {
        if(ehc == 0)
            return;
        if(dfl > 450)
        {
            fci("@cya@You can't logout during combat!", 3);
            return;
        }
        if(dfl > 0)
        {
            fci("@cya@You can't logout for 10 seconds after combat", 3);
            return;
        } else
        {
            super.aah.hfj(3);
            super.aah.hff();
            ecj = 1000;
            return;
        }
    }

    private final void fch(boolean flag)
    {
        boolean flag1 = false;
        int i = ((blm) (dki)).bln - 248; 
        dki.cci(i, 3, eie + 1);
        for(int j = 0; j < dmm; j++)
        {
            int k = i + (j % 5) * 49;
            int i1 = 36 + (j / 5) * 34;
            if(j < djn && dkc[j] == 1)
                dki.cbf(k, i1, 49, 34, 0xdfaffdf, 128);
            else
                dki.cbf(k, i1, 49, 34, 0x000000, 128);
            if(j < djn)
            {
                dki.cdk(k, i1, 48, 32, eig + ahd.ahj[dka[j]], ahd.aia[dka[j]], 0, 0, false);
                if(ahd.ahl[dka[j]] == 0)
                    dki.ceg(String.valueOf(dkb[j]), k + 1, i1 + 10, 1, 0xffffff);
            }
        }

        for(int l = 1; l <= 4; l++)
            dki.cbk(i + l * 49, 36, (dmm / 5) * 34, 0);

        for(int j1 = 1; j1 <= dmm / 5 - 1; j1++)
            dki.cbj(i, 36 + j1 * 34, 245, 0); 

        if(!flag)
            return;
        i = super.flg - (((blm) (dki)).bln - 248);
        int k1 = super.flh - 36;
        if(i >= 0 && k1 >= 0 && i < 248 && k1 < (dmm / 5) * 34)
        {
            int l1 = i / 49 + (k1 / 34) * 5;
            if(l1 < djn)
            {
                int i2 = dka[l1];
                if(eaf >= 0)
                {
                    if(ahd.alc[eaf] == 3)
                    {
                        dmi[eae] = "Cast " + ahd.amh[eaf] + " on";
                        dhg[eae] = "@lre@" + ahd.alm[i2];
                        eka[eae] = 600;
                        dfd[eae] = l1;
                        dfe[eae] = eaf;
                        eae++;
                        return;
                    }
                } else
                {
                    if(deb >= 0)
                    {
                        dmi[eae] = "Use " + dec + " with";
                        dhg[eae] = "@lre@" + ahd.alm[i2];
                        eka[eae] = 610;
                        dfd[eae] = l1;
                        dfe[eae] = deb;
                        eae++;
                        return;
                    }
                    if(dkc[l1] == 1)
                    {
                        dmi[eae] = "Remove";
                        dhg[eae] = "@lre@" + ahd.alm[i2];
                        eka[eae] = 620;
                        dfd[eae] = l1;
                        eae++;
                    } else
                    if(ahd.ahn[i2] != 0)
                    {
                        if((ahd.ahn[i2] & 0x18) != 0)
                            dmi[eae] = "Wield";
                        else
                            dmi[eae] = "Wear";
                        dhg[eae] = "@lre@" + ahd.alm[i2];
                        eka[eae] = 630;
                        dfd[eae] = l1;
                        eae++;
                    }
                    if(!ahd.ama[i2].equals(""))
                    {
                        dmi[eae] = ahd.ama[i2];
                        dhg[eae] = "@lre@" + ahd.alm[i2];
                        eka[eae] = 640;
                        dfd[eae] = l1;
                        eae++;
                    }
                    dmi[eae] = "Use";
                    dhg[eae] = "@lre@" + ahd.alm[i2];
                    eka[eae] = 650;
                    dfd[eae] = l1;
                    eae++;
                    dmi[eae] = "Drop";
                    dhg[eae] = "@lre@" + ahd.alm[i2];
                    eka[eae] = 660;
                    dfd[eae] = l1;
                    eae++;
                    dmi[eae] = "Examine";
                    dhg[eae] = "@lre@" + ahd.alm[i2];
                    eka[eae] = 3600;
                    dfd[eae] = i2;
                    eae++;
                }
            }
        }
    }

    private final void fci(String s, int i)
    {
        boolean flag = false;
        if(i == 2 || i == 4 || i == 6)
        {
            for(; s.length() > 5 && s.charAt(0) == '@' && s.charAt(4) == '@'; s = s.substring(5));
            int j = s.indexOf(":");
            if(j != -1)
            {
                String s1 = s.substring(0, j);
                long l = fnf.gag(s1);
                for(int i1 = 0; i1 < super.aba; i1++)
                    if(super.abb[i1] == l)
                        return;

            }
        }
        if(i == 2)
            s = "@yel@" + s;
        if(i == 3 || i == 4)
            s = "@whi@" + s;
        if(i == 6)
            s = "@cya@" + s;
        if(elc != 0)
        {
            if(i == 4 || i == 3)
                dlj = 200;
            if(i == 2 && elc != 1)
                dlk = 200;
            if(i == 5 && elc != 2)
                dll = 200;
            if(i == 6 && elc != 3)
                dlm = 200;
            if(i == 3 && elc != 0)
                elc = 0;
            if(i == 6 && elc != 3 && elc != 0)
                elc = 0;
        }
        for(int k = 4; k > 0; k--)
        {
            dna[k] = dna[k - 1];
            ddm[k] = ddm[k - 1];
        }

        dna[0] = s;
        ddm[0] = 300;
        if(i == 2)
            if(ekl.gci[ekm] == ekl.gcj[ekm] - 4)
                ekl.ghh(ekm, s, true);
            else
                ekl.ghh(ekm, s, false);
        if(i == 5)
            if(ekl.gci[ela] == ekl.gcj[ela] - 4)
                ekl.ghh(ela, s, true);
            else
                ekl.ghh(ela, s, false);
        if(i == 6)
        {
            if(ekl.gci[elb] == ekl.gcj[elb] - 4)
            {
                ekl.ghh(elb, s, true);
                return;
            }
            ekl.ghh(elb, s, false);
        }
    }

    private final void fcj()
    {
        boolean flag = false;
        if(eee > 1)
            eee--;
        ace();
        if(ecj > 0)
            ecj--;
        if(emd.hah == 8 || emd.hah == 9)
            dfl = 500;
        if(dfl > 0)
            dfl--;
        if(djc)
        {
            fda();
            return;
        }
        for(int i = 0; i < ekd; i++)
        {
            gnm gnm1 = dhe[i];
            int k = (gnm1.hak + 1) % 10;
            if(gnm1.haj != k)
            {
                int i1 = -1;
                int l2 = gnm1.haj;
                int j4;
                if(l2 < k)
                    j4 = k - l2;
                else
                    j4 = (10 + k) - l2;
                int j5 = 4;
                if(j4 > 2)
                    j5 = (j4 - 1) * 4;
                if(gnm1.hal[l2] - gnm1.had > ehb * 3 || gnm1.ham[l2] - gnm1.hae > ehb * 3 || gnm1.hal[l2] - gnm1.had < -ehb * 3 || gnm1.ham[l2] - gnm1.hae < -ehb * 3 || j4 > 8)
                {
                    gnm1.had = gnm1.hal[l2];
                    gnm1.hae = gnm1.ham[l2];
                } else
                {
                    if(gnm1.had < gnm1.hal[l2])
                    {
                        gnm1.had += j5;
                        gnm1.hag++;
                        i1 = 2;
                    } else
                    if(gnm1.had > gnm1.hal[l2])
                    {
                        gnm1.had -= j5;
                        gnm1.hag++;
                        i1 = 6;
                    }
                    if(gnm1.had - gnm1.hal[l2] < j5 && gnm1.had - gnm1.hal[l2] > -j5)
                        gnm1.had = gnm1.hal[l2];
                    if(gnm1.hae < gnm1.ham[l2])
                    {
                        gnm1.hae += j5;
                        gnm1.hag++;
                        if(i1 == -1)
                            i1 = 4;
                        else
                        if(i1 == 2)
                            i1 = 3;
                        else
                            i1 = 5;
                    } else
                    if(gnm1.hae > gnm1.ham[l2])
                    {
                        gnm1.hae -= j5;
                        gnm1.hag++;
                        if(i1 == -1)
                            i1 = 0;
                        else
                        if(i1 == 2)
                            i1 = 1;
                        else
                            i1 = 7;
                    }
                    if(gnm1.hae - gnm1.ham[l2] < j5 && gnm1.hae - gnm1.ham[l2] > -j5)
                        gnm1.hae = gnm1.ham[l2];
                }
                if(i1 != -1)
                    gnm1.hah = i1;
                if(gnm1.had == gnm1.hal[l2] && gnm1.hae == gnm1.ham[l2])
                    gnm1.haj = (l2 + 1) % 10;
            } else
            {
                gnm1.hah = gnm1.hai;
            }
            if(gnm1.hbb > 0)
                gnm1.hbb--;
            if(gnm1.hbd > 0)
                gnm1.hbd--;
            if(gnm1.hbh > 0)
                gnm1.hbh--;
            if(enb > 0)
            {
                enb--;
                if(enb == 0)
                    fci("Respawned!", 3);
                if(enb == 0)
                    fci("Time to regain your honour...", 3);
            }
        }

        for(int j = 0; j < emi; j++)
        {
            gnm gnm2 = eai[j];
            int j1 = (gnm2.hak + 1) % 10;
            if(gnm2.haj != j1)
            {
                int i3 = -1;
                int k4 = gnm2.haj;
                int k5;
                if(k4 < j1)
                    k5 = j1 - k4;
                else
                    k5 = (10 + j1) - k4;
                int l5 = 4;
                if(k5 > 2)
                    l5 = (k5 - 1) * 4;
                if(gnm2.hal[k4] - gnm2.had > ehb * 3 || gnm2.ham[k4] - gnm2.hae > ehb * 3 || gnm2.hal[k4] - gnm2.had < -ehb * 3 || gnm2.ham[k4] - gnm2.hae < -ehb * 3 || k5 > 8)
                {
                    gnm2.had = gnm2.hal[k4];
                    gnm2.hae = gnm2.ham[k4];
                } else
                {
                    if(gnm2.had < gnm2.hal[k4])
                    {
                        gnm2.had += l5;
                        gnm2.hag++;
                        i3 = 2;
                    } else
                    if(gnm2.had > gnm2.hal[k4])
                    {
                        gnm2.had -= l5;
                        gnm2.hag++;
                        i3 = 6;
                    }
                    if(gnm2.had - gnm2.hal[k4] < l5 && gnm2.had - gnm2.hal[k4] > -l5)
                        gnm2.had = gnm2.hal[k4];
                    if(gnm2.hae < gnm2.ham[k4])
                    {
                        gnm2.hae += l5;
                        gnm2.hag++;
                        if(i3 == -1)
                            i3 = 4;
                        else
                        if(i3 == 2)
                            i3 = 3;
                        else
                            i3 = 5;
                    } else
                    if(gnm2.hae > gnm2.ham[k4])
                    {
                        gnm2.hae -= l5;
                        gnm2.hag++;
                        if(i3 == -1)
                            i3 = 0;
                        else
                        if(i3 == 2)
                            i3 = 1;
                        else
                            i3 = 7;
                    }
                    if(gnm2.hae - gnm2.ham[k4] < l5 && gnm2.hae - gnm2.ham[k4] > -l5)
                        gnm2.hae = gnm2.ham[k4];
                }
                if(i3 != -1)
                    gnm2.hah = i3;
                if(gnm2.had == gnm2.hal[k4] && gnm2.hae == gnm2.ham[k4])
                    gnm2.haj = (k4 + 1) % 10;
            } else
            {
                gnm2.hah = gnm2.hai;
                if(gnm2.haf == 43)
                    gnm2.hag++;
            }
            if(gnm2.hbb > 0)
                gnm2.hbb--;
            if(gnm2.hbd > 0)
                gnm2.hbd--;
            if(gnm2.hbh > 0)
                gnm2.hbh--;
        }

        if(eeb != 2)
        {
            if(blm.cag > 0)
                ecl++;
            if(blm.cah > 0)
                ecl = 0;
            blm.cag = 0;
            blm.cah = 0;
        }
        for(int l = 0; l < ekd; l++)
        {
            gnm gnm3 = dhe[l];
            if(gnm3.hcc > 0)
                gnm3.hcc--;
        }

        if(eln - emd.had < -500 || eln - emd.had > 500 || ema - emd.hae < -500 || ema - emd.hae > 500)
        {
            eln = emd.had;
            ema = emd.hae;
        }
        if(eln != emd.had)
            eln += (emd.had - eln) / (16 + (edb - 500) / 15);
        if(ema != emd.hae)
            ema += (emd.hae - ema) / (16 + (edb - 500) / 15);
        if(ekc)
        {
            int k1 = dhl * 32;
            int j3 = k1 - ean;
            byte byte0 = 1;
            if(j3 != 0)
            {
                dhm++;
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
                ean += ((dhm * j3 + 255) / 256) * byte0;
                ean &= 0xff;
            } else
            {
                dhm = 0;
            }
        }
        if(ecl > 20)
        {
            dee = false;
            ecl = 0;
        }
        if(edi)
        {
            if(super.fma.length() > 0)
                if(super.fma.equalsIgnoreCase("::lostcon") && !dje)
                    super.aah.ban();
                else
                if(super.fma.equalsIgnoreCase("::closecon") && !dje)
                {
                    acb();
                } else
                {
                    super.aah.hfj(142);
                    super.aah.hfk(super.fma);
                    if(!dee)
                    {
                        super.aah.hfa(0);
                        dee = true;
                    }
                    super.aah.hff();
                    super.fln = "";
                    super.fma = "";
                    ejk = "Please wait...";
                }
            if(super.flj == 1 && super.flh > 275 && super.flh < 310 && super.flg > 56 && super.flg < 456)
            {
                super.aah.hfj(142);
                super.aah.hfk("-null-");
                if(!dee)
                {
                    super.aah.hfa(0);
                    dee = true;
                }
                super.aah.hff();
                super.fln = "";
                super.fma = "";
                ejk = "Please wait...";
            }
            super.flj = 0;
            return;
        }
        if(super.flh > dmk - 4)
        {
            if(super.flg > 15 && super.flg < 96 && super.flj == 1)
                elc = 0;
            if(super.flg > 110 && super.flg < 194 && super.flj == 1)
            {
                elc = 1;
                ekl.gci[ekm] = 0xf423f;
            }
            if(super.flg > 215 && super.flg < 295 && super.flj == 1)
            {
                elc = 2;
                ekl.gci[ela] = 0xf423f;
            }
            if(super.flg > 315 && super.flg < 395 && super.flj == 1)
            {
                elc = 3;
                ekl.gci[elb] = 0xf423f;
            }
            if(super.flg > 417 && super.flg < 497 && super.flj == 1)
            {
                dej = 1;
                eml = 0;
                super.fln = "";
                super.fma = "";
            }
            super.flj = 0;
            super.fli = 0;
        }
        ekl.gfg(super.flg, super.flh, super.flj, super.fli);
        if(elc > 0 && super.flg >= 494 && super.flh >= dmk - 66)
            super.flj = 0;
        if(ekl.gfh(ekn))
        {
            String s = ekl.ghj(ekn);
            ekl.ghi(ekn, "");
            if(s.startsWith("::"))
            {
                if(s.equalsIgnoreCase("::closecon") && !dje)
                    super.aah.ban();
                else
                if(s.equalsIgnoreCase("::logout") && !dje)
                    acb();
                else
                if(s.equalsIgnoreCase("::lostcon") && !dje)
                    acc();
                else
                    ada(s.substring(2));
            } else
            
            if(s.startsWith("/"))
            {
                if(s.startsWith("/id1"))
                {
                   int a = s.indexOf('(');
                   int b = s.indexOf(')');
                   if(a != -1 && b != -1)
                   {
                      npcid = Integer.parseInt(s.substring(a + 1, b));    
 adh("NpcID is set to "+ahd.akg[npcid]);
                      }
                }else
                if(s.startsWith("/id2"))
                {
                   int a = s.indexOf('(');
                   int b = s.indexOf(')');
                   if(a != -1 && b != -1)
                   {
                      npcid2 = Integer.parseInt(s.substring(a + 1, b));    
                      adh("NpcID 2 is set to: "+npcid2+", "+ahd.akg[npcid2]);
                      }
                }else
                if(s.startsWith("/id3"))
                {
                   int a = s.indexOf('(');
                   int b = s.indexOf(')');
                   if(a != -1 && b != -1)
                   {
                      npcid3 = Integer.parseInt(s.substring(a + 1, b));    
                      adh("NpcID 3 is set to "+ahd.akg[npcid]);
                      }
                }else
                if(s.startsWith("/food"))
                {
                   int a = s.indexOf('(');
                   int b = s.indexOf(')');
                   if(a != -1 && b != -1)
                   {
                     foodID = Integer.parseInt(s.substring(a + 1, b));    
                      adh("Set to eat: "+foodID+", "+ahd.alm[foodID]);
                      }
                }else
                if(s.startsWith("/hp"))
                {
                   int a = s.indexOf('(');
                   int b = s.indexOf(')');
                   if(a != -1 && b != -1)
                   {
                     EatAtHP = Integer.parseInt(s.substring(a + 1, b));    
                      adh("HP to eat at is set to "+EatAtHP);
                      }
                }else
                if(s.startsWith("/world"))
                {
                   int a = s.indexOf('(');
                   int b = s.indexOf(')');
                   if(a != -1 && b != -1)
                   {
                    int worldy = Integer.parseInt(s.substring(a + 1, b));
                      if(worldy == 29 || worldy == 30 || worldy == 31 || worldy == 32 || worldy == 33 || worldy == 34 || worldy == 37 || worldy == 38)
                      {
                         if(worldy == 32 || worldy == 34)
                            emh = false;
                         else
                            emh = false; 
                         if(dfl > 450)
                         {
                            fci("@cya@You can't logout during combat!", 3);
                            return;
                         }
                         if(dfl > 0)
                         {
                            fci("@cya@You can't logout for 10 seconds after combat", 3);
                            return;
                         }
                         if(dfl <= 0)
                            acb();
                         changeworld(worldy);
                         aca(djk, djl, false);
                         adh("@whi@World changed to: @yel@" + worldy);
                      }
                      else 
                         adh("World " +worldy+ " Is an incorrect world");
                      }
                   }
                   if(s.equalsIgnoreCase("/81"))
		   {
                   if(dfl > 450)
                   {
                   fci("@cya@You can't logout during combat!", 3);
                   return;
                   }
                   if(dfl > 0)
                   {
                   fci("@cya@You can't logout for 10 seconds after combat", 3);
                   return;
                   }
                   if(dfl <= 0)
                   {
                   acb();
                   changeworld(81);
                   if(world == 32 || world == 34)
                   emh = false;
                   else
                   emh = false; 
                   aca(djk, djl, false);
		   }
		   }else
		   if(s.equalsIgnoreCase("/82"))
		   {
                   if(dfl > 450)
                   {
                   fci("@cya@You can't logout during combat!", 3);
                   return;
                   }
                   if(dfl > 0)
                   {
                   fci("@cya@You can't logout for 10 seconds after combat", 3);
                   return;
                   }
                   if(dfl <= 0)
                   {
                   acb();
                   changeworld(82);
                   if(world == 32 || world == 34)
                   emh = false;
                   else
                   emh = false; 
                   aca(djk, djl, false);
		   }
		   }else
		   if(s.equalsIgnoreCase("/83"))
		   {
                   if(dfl > 450)
                   {
                   fci("@cya@You can't logout during combat!", 3);
                   return;
                   }
                   if(dfl > 0)
                   {
                   fci("@cya@You can't logout for 10 seconds after combat", 3);
                   return;
                   }
                   if(dfl <= 0)
                   {
                   acb();
                   changeworld(83);
                   if(world == 32 || world == 34)
                   emh = false;
                   else
                   emh = false; 
                   aca(djk, djl, false);
		   }
		   }else
		   if(s.equalsIgnoreCase("/84"))
		   {
                   if(dfl > 450)
                   {
                   fci("@cya@You can't logout during combat!", 3);
                   return;
                   }
                   if(dfl > 0)
                   {
                   fci("@cya@You can't logout for 10 seconds after combat", 3);
                   return;
                   }
                   if(dfl <= 0)
                   {
                   acb();
                   changeworld(84);
                   if(world == 32 || world == 34)
                   emh = false;
                   else
                   emh = false; 
                   aca(djk, djl, false);
		   }
		   }else
		   if(s.equalsIgnoreCase("/85"))
		   {
                   if(dfl > 450)
                   {
                   fci("@cya@You can't logout during combat!", 3);
                   return;
                   }
                   if(dfl > 0)
                   {
                   fci("@cya@You can't logout for 10 seconds after combat", 3);
                   return;
                   }
                   if(dfl <= 0)
                   {
                   acb();
                   changeworld(85);
                   if(world == 32 || world == 34)
                   emh = false;
                   else
                   emh = false; 
                   aca(djk, djl, false);
		   }
		   }else
		   if(s.equalsIgnoreCase("/86"))
		   {
                   if(dfl > 450)
                   {
                   fci("@cya@You can't logout during combat!", 3);
                   return;
                   }
                   if(dfl > 0)
                   {
                   fci("@cya@You can't logout for 10 seconds after combat", 3);
                   return;
                   }
                   if(dfl <= 0)
                   {
                   acb();
                   changeworld(86);
                   if(world == 32 || world == 34)
                   emh = false;
                   else
                   emh = false; 
                   aca(djk, djl, false);
		   }
		   }else
		   if(s.equalsIgnoreCase("/34"))
		   {
                   if(dfl > 450)
                   {
                   fci("@cya@You can't logout during combat!", 3);
                   return;
                   }
                   if(dfl > 0)
                   {
                   fci("@cya@You can't logout for 10 seconds after combat", 3);
                   return;
                   }
                   if(dfl <= 0)
                   {
                   acb();
                   changeworld(29);
                   if(world == 32 || world == 34)
                   emh = false;
                   else
                   emh = false; 
                   aca(djk, djl, false);
		   }
		   }else
		   if(s.equalsIgnoreCase("/37"))
		   {
                   if(dfl > 450)
                   {
                   fci("@cya@You can't logout during combat!", 3);
                   return;
                   }
                   if(dfl > 0)
                   {
                   fci("@cya@You can't logout for 10 seconds after combat", 3);
                   return;
                   }
                   if(dfl <= 0)
                   {
                   acb();
                   changeworld(37);
                   if(world == 32 || world == 34)
                   emh = false;
                   else
                   emh = false; 
                   aca(djk, djl, false);
		   }
		   }else
		   if(s.equalsIgnoreCase("/38"))
		   {
                   if(dfl > 450)
                   {
                   fci("@cya@You can't logout during combat!", 3);
                   return;
                   }
                   if(dfl > 0)
                   {
                   fci("@cya@You can't logout for 10 seconds after combat", 3);
                   return;
                   }
                   if(dfl <= 0)
                   {
                   acb();
                   changeworld(38);
                   if(world == 32 || world == 34)
                   emh = false;
                   else
                   emh = false; 
                   aca(djk, djl, false);
		   }
		   }else
                if(s.startsWith("/npcstats"))
                {
                    int a = s.indexOf('(');
                    int b = s.indexOf(')');
                    if(a != -1 && b != -1)
                    {
                        int c = Integer.parseInt(s.substring(a + 1, b)); 
                        adh("Npc - " + ahd.akg[c] + " Stat's are: " + String.valueOf(ahd.ahe[c]) + " | " + String.valueOf(ahd.ahf[c]) + " | " + String.valueOf(ahd.ahg[c]) + " | " + String.valueOf(ahd.ahh[c]));
                    }
                }else   
                if(s.equalsIgnoreCase("/hptoeatat"))
		   adh("AutoEat will eat at min: "+EatAtHP+" hp");
		else
                if(s.equalsIgnoreCase("/logout"))
		   acb();
		else
                if(s.equalsIgnoreCase("/resetrotation"))
                  xrotate = 912; 
                else 
                if(s.equalsIgnoreCase("/resetzoom"))
                  edb = 550;
                /*Other commands */
            } else  
            {
                int k3 = cen.cfe(s);
                acn(cen.cfa, k3);
                s = cen.cfd(cen.cfa, 0, k3);
                s = ffn.fhe(s);
                emd.hbb = 150;
                emd.hba = s;
                fci(emd.haa + ": " + s, 2);
            }
        }
        if(elc == 0)
        {
            for(int l1 = 0; l1 < 5; l1++)
                if(ddm[l1] > 0)
                    ddm[l1]--;

        }
        if(enb != 0)
            super.flj = 0;
        if(dfk || dji)
        {
            if(super.fli != 0)
                ejm++;
            else
                ejm = 0;
            if(ejm > 600)
                ejn += 5000;
            else
            if(ejm > 450)
                ejn += 500;
            else
            if(ejm > 300)
                ejn += 50;
            else
            if(ejm > 150)
                ejn += 5;
            else
            if(ejm > 50)
                ejn++;
            else
            if(ejm > 20 && (ejm & 5) == 0)
                ejn++;
        } else
        {
            ejm = 0;
            ejn = 0;
        }
        if(super.flj == 1)
            elf = 1;
        else
        if(super.flj == 2)
            elf = 2;
        dkm.bhl(super.flg, super.flh);
        super.flj = 0;
        if(ekc)
        {
            if(dhm == 0)
            {
                if(super.fkn)
                {
                    dhl = dhl + 1 & 7;
                    super.fkn = false;
                    if(!dmn)
                    {
                        if((dhl & 1) == 0)
                            dhl = dhl + 1 & 7;
                        for(int i2 = 0; i2 < 8; i2++)
                        {
                            if(fai(dhl))
                                break;
                            dhl = dhl + 1 & 7;
                        }

                    }
                }
                if(super.fla)
                {
                    dhl = dhl + 7 & 7;
                    super.fla = false;
                    if(!dmn)
                    {
                        if((dhl & 1) == 0)
                            dhl = dhl + 7 & 7;
                        for(int j2 = 0; j2 < 8; j2++)
                        {
                            if(fai(dhl))
                                break;
                            dhl = dhl + 7 & 7;
                        }

                    }
                }
            }
        } else
        if(super.fkn)
            ean = ean + 2 & 0xff;
        else
        if(super.fla)
            ean = ean - 2 & 0xff;
        if(ehd > 0)
            ehd--;
        else
        if(ehd < 0)
            ehd++;
        dkm.bjn(17);
        dgn++;
        if(dgn > 5)
        {
            dgn = 0;
            elk = (elk + 1) % 3;
            ell = (ell + 1) % 4;
            elm = (elm + 1) % 5;
        }
        for(int k2 = 0; k2 < dln; k2++)
        {
            int l3 = ecb[k2];
            int l4 = ecc[k2];
            if(l3 >= 0 && l4 >= 0 && l3 < 96 && l4 < 96 && ecd[k2] == 74)
                egn[k2].cne(1, 0, 0);
        }

        for(int i4 = 0; i4 < ekh; i4++)
        {
            efk[i4]++;
            if(efk[i4] > 50)
            {
                ekh--;
                for(int i5 = i4; i5 < ekh; i5++)
                {
                    deg[i5] = deg[i5 + 1];
                    ejl[i5] = ejl[i5 + 1];
                    efk[i5] = efk[i5 + 1];
                    eid[i5] = eid[i5 + 1];
                }

            }
        }

    }

    private final void fck()
    {
        byte abyte0[] = fbm("config" + cff.cfi + ".jag", "Configuration", 10);
        if(abyte0 == null)
        {
            ejj = true;
            return;
        }
        ahd.bad(abyte0, emh);
        byte abyte1[] = fbm("filter" + cff.cgb + ".jag", "Chat system", 15);
        if(abyte1 == null)
        {
            ejj = true;
            return;
        } else
        {
            byte abyte2[] = fnf.gak("fragmentsenc.txt", 0, abyte1);
            byte abyte3[] = fnf.gak("badenc.txt", 0, abyte1);
            byte abyte4[] = fnf.gak("hostenc.txt", 0, abyte1);
            byte abyte5[] = fnf.gak("tldlist.txt", 0, abyte1);
            ffn.fgm(new dbh(abyte2), new dbh(abyte3), new dbh(abyte4), new dbh(abyte5));
            return;
        }
    }

    final void fcl(int i, int j, int k, int l, int i1, int j1, int k1)
    {
        int l1 = ahd.ahj[i1] + eig;
        int i2 = ahd.aia[i1];
        dki.cdk(i, j, k, l, l1, i2, 0, 0, false);
    }

    protected final void fcm(int i, int j, int k)
    {
        boolean flag1 = false;
        ehh[ehg] = j;
        ehi[ehg] = k;
        ehg = ehg + 1 & 0x0001;
        for(int l = 10; l < 4000; l++)
        {
            int i1 = ehg - l & 0x1fff;
            if(ehh[i1] == j && ehi[i1] == k)
            {
                boolean flag = false;
                for(int j1 = 1; j1 < l; j1++)
                {
                    int k1 = ehg - j1 & 0x1fff;
                    int l1 = i1 - j1 & 0x1fff;
                    if(ehh[l1] != j || ehi[l1] != k)
                        flag = true;
                    if(ehh[k1] != ehh[l1] || ehi[k1] != ehi[l1])
                        break;
                    if(j1 == l - 1 && flag && dfl == 0 && ecj == 0)
                    {
                        fcg();
                        return;
                    }
                }

            }
        }

    }

    private final void fcn(boolean flag)
    {
        boolean flag2 = false;
        int i = ((blm) (dki)).bln - 199;
        int j = 36;
        dki.cci(i - 49, 3, eie + 6);
        char c = '\304'; 
        dki.cbf(i, 36, 196, 65, 0x000000, 160);
        dki.cbf(i, 101, 196, 65, 0x000000, 160);
        dki.cbf(i, 166, 196, 95, 0x000000, 160);
        dki.cbf(i, 261, 196, 60, 0x000000, 160);
        int k = i + 3;
        int i1 = 51;
        dki.ceg("", k, 51, 1, 0);
        i1 += 15;
        if(ekc)
            dki.ceg("Camera angle mode - @yel@Auto", k, 51, 1, 0xffffff);
        else
            dki.ceg("Camera angle mode - @whi@Manual", k, 51, 1, 0xffffff);
        i1 += 15;
        if(eah)
            dki.ceg("Mouse buttons - @yel@One", k, 66, 1, 0xffffff);
        else
            dki.ceg("Mouse buttons - @whi@Two", k, 66, 1, 0xffffff);
        i1 += 15;
        if(emh)
            if(ddn)
                dki.ceg("Sound effects - @yel@off", k, 140, 1, 0xffffff);
            else
                dki.ceg("Sound effects - @whi@on", k, 140, 1, 0xffffff);
;        if(super.abc == 0)
            dki.ceg("Block chat messages: @yel@<off>", i + 3, 81, 1, 0xffffff);
        else
            dki.ceg("Block chat messages: @whi@<on>", i + 3, 81, 1, 0xffffff);
        i1 += 15;
        if(super.abd == 0)
            dki.ceg("Block private messages: @yel@<off>", i + 3, 96, 1, 0xffffff);
        else
            dki.ceg("Block private messages: @whi@<on>", i + 3, 96, 1, 0xffffff);
        i1 += 15;
        if(super.abe == 0)
            dki.ceg("Block trade requests: @yel@<off>", i + 3, 111, 1, 0xffffff);
        else
            dki.ceg("Block trade requests: @whi@<on>", i + 3, 111, 1, 0xffffff);
        i1 += 15;
        if(emh)
            if(super.abf == 0)
                dki.ceg("Block duel requests: @yel@<off>", i + 3, 126, 1, 0xffffff);
            else
                dki.ceg("Block duel requests: @whi@<on>", i + 3, 126, 1, 0xffffff);
        i1 += 15;
        i1 += 5;
        dki.ceg("@whi@#RuinBot (irc.rscheatnet.org)", k, 320, 1, 900);
        i1 += 200;
        int k1 = 0xf0;
        if(super.flg > k && super.flg < k + 300 && super.flh > 290 && super.flh < 400)
            k1 = 0x43d;
        dki.ceg("@whi@logout",i + 70, 305, 3, k1);
        if(!flag)
            return;
        i = super.flg - (((blm) (dki)).bln - 199);
        j = super.flh - 36;
        if(i >= 0 && j >= 0 && i < 196 && j < 265)
        {
            int l1 = ((blm) (dki)).bln - 199;
            byte byte0 = 36;
            char c1 = '\305';
            int l = l1 + 3;
            int j1 = 66;
            if(super.flg > l && super.flg < l + 196 && super.flh > 40 && super.flh < 55 && elf == 1)
            {
                ekc = !ekc;
                super.aah.hfj(165);
                super.aah.hfa(0);
                super.aah.hfa(ekc ? 1 : 0);
                super.aah.hff();
            }
            j1 += 15;
            if(super.flg > l && super.flg < l + 196 && super.flh > 54 && super.flh < 68 && elf == 1)
            {
                eah = !eah;
                super.aah.hfj(165);
                super.aah.hfa(2);
                super.aah.hfa(eah ? 1 : 0);
                super.aah.hff();
            }
            j1 += 15;
            if(emh && super.flg > l && super.flg < l + 196 && super.flh > 131 && super.flh < 140 && elf == 1)
            {
                ddn = !ddn;
                super.aah.hfj(165);
                super.aah.hfa(3);
                super.aah.hfa(ddn ? 1 : 0);
                super.aah.hff();
            }
            if(super.flg > 1 && super.flg < 1 + 196 && super.flh > 122 && super.flh < 124 && elf == 1)
          rightsTolefts = !rightsTolefts; 
            j1 += 15;
            j1 += 15;
            j1 += 15;
            j1 += 15;
            j1 += 15;
              boolean flag1 = false;
            j1 += 35;
            if(super.flg > l && super.flg < l + 196 && super.flh > 74 && super.flh < 82 && elf == 1)
            {
                super.abc = 1 - super.abc;
                flag1 = true;
            }
            j1 += 15;
            if(super.flg > l && super.flg < l + 196 && super.flh > 89 && super.flh < 97 && elf == 1)
            {
                super.abd = 1 - super.abd;
                flag1 = true;
            }
            j1 += 15;
            if(super.flg > l && super.flg < l + 196 && super.flh > 105 && super.flh < 113 && elf == 1)
            {
                super.abe = 1 - super.abe;
                flag1 = true;
            }
            j1 += 15;
            if(emh && super.flg > l && super.flg < l + 196 && super.flh > 118 && super.flh < 126 && elf == 1)
            {
                super.abf = 1 - super.abf;
                flag1 = true;
            }
            j1 += 15;
            if(flag1)
                ach(super.abc, super.abd, super.abe, super.abf);
            j1 += 20;
            if(super.flg > l && super.flg < l + 196 && super.flh > 276 && super.flh < 305 && elf == 1)
                fcg();
            elf = 0;
        }
    }

    private final void fda()
    {
        boolean flag = false;
        ebc.gfg(super.flg, super.flh, super.flj, super.fli);
        if(ebc.gfh(eeg))
            do
                ebg = ((ebg - 1) + ahd.alh) % ahd.alh;
            while((ahd.amm[ebg] & 3) != 1 || (ahd.amm[ebg] & 4 * ebn) == 0);
        if(ebc.gfh(eeh))
            do
                ebg = (ebg + 1) % ahd.alh;
            while((ahd.amm[ebg] & 3) != 1 || (ahd.amm[ebg] & 4 * ebn) == 0);
        if(ebc.gfh(eei))
            ebj = ((ebj - 1) + dlh.length) % dlh.length;
        if(ebc.gfh(eej))
            ebj = (ebj + 1) % dlh.length;
        if(ebc.gfh(eek) || ebc.gfh(eel))
        {
            for(ebn = 3 - ebn; (ahd.amm[ebg] & 3) != 1 || (ahd.amm[ebg] & 4 * ebn) == 0; ebg = (ebg + 1) % ahd.alh);
            for(; (ahd.amm[ebh] & 3) != 2 || (ahd.amm[ebh] & 4 * ebn) == 0; ebh = (ebh + 1) % ahd.alh);
        }
        if(ebc.gfh(eem))
            ebk = ((ebk - 1) + ejf.length) % ejf.length;
        if(ebc.gfh(een))
            ebk = (ebk + 1) % ejf.length;
        if(ebc.gfh(efa))
            ebm = ((ebm - 1) + dhf.length) % dhf.length;
        if(ebc.gfh(efb))
            ebm = (ebm + 1) % dhf.length;
        if(ebc.gfh(efc))
            ebl = ((ebl - 1) + ejf.length) % ejf.length;
        if(ebc.gfh(efd))
            ebl = (ebl + 1) % ejf.length;
        if(ebc.gfh(efe))
        {
            super.aah.hfj(238);
            super.aah.hfa(ebn);
            super.aah.hfa(ebg);
            super.aah.hfa(ebh);
            super.aah.hfa(ebi);
            super.aah.hfa(ebj);
            super.aah.hfa(ebk);
            super.aah.hfa(ebl);
            super.aah.hfa(ebm);
            super.aah.hff();
            dki.cbd();
            djc = false;
        }
    }

    protected final void adh(String s)
    {
        if(s.startsWith("@bor@"))
        {
            fci(s, 4);
            return;
        }
        if(s.startsWith("@que@"))
        {
            fci("@whi@" + s, 5);
            return;
        }
        if(s.startsWith("@pri@"))
        {
            fci(s, 6);
            return;
        } else
        {
            fci(s, 3);
            return;
        }
    }

   public final URL getDocumentBase()
{
try
{
return new URL("http://www.runescape.com");
}
catch(Exception e) {return null;}
} 

    protected final void add()
    {
        boolean flag = false;
        eee = 0;
        dig = 0;
        ecj = 0;
        elh = 0;
        ehc = 1;
        fen();
        dki.cbd();
        dki.cbc(eff, 0, 0);
        for(int i = 0; i < dln; i++)
        {
            dkm.bhe(egn[i]);
            efh.glc(ecb[i], ecc[i], ecd[i]);
        }

        for(int j = 0; j < eca; j++)
        {
            dkm.bhe(dkd[j]);
            efh.glk(eal[j], eam[j], dgf[j], dgg[j]);
        }

        dln = 0;
        eca = 0;
        egh = 0;
        ekd = 0;
        for(int k = 0; k < 4000; k++)
            egm[k] = null;

        for(int l = 0; l < 500; l++)
            dhe[l] = null;

        emi = 0;
        for(int i1 = 0; i1 < 5000; i1++)
            edd[i1] = null;

        for(int j1 = 0; j1 < 500; j1++)
            eai[j1] = null;

        for(int k1 = 0; k1 < 50; k1++)
            dia[k1] = false;

        elf = 0;
        super.flj = 0;
        super.fli = 0;
        eha = false;
        dnk = false;
        edi = false;
    }

public final URL getCodeBase()
{
try
{
return new URL("http://" + super.aad + "/client2/");
}
catch(Exception e) {return null;}
} 

    private final String fdb(int i)
    {
        return fnf.gaf(i);
    }

    protected final void fdc()
    {
        if(ecn)
            return;
        if(edj)
            return;
        if(ejj)
            return;
        try
        {
            dek++;
            if(ehc == 0)
                fbn();
            if(ehc == 1)
                fcj();
            super.flj = 0;
            super.fll = 0;
            dfg++;
            if(dfg > 500)
            {
                dfg = 0;
                int i = (int)(Math.random() * 4D);
                if((i & 1) == 1)
                    ejd += eje;
                if((i & 2) == 2)
                    dma += dmb;
            }
            if(ejd < -50)
                eje = 2;
            if(ejd > 50)
                eje = -2;
            if(dma < -50)
                dmb = 2;
            if(dma > 50)
                dmb = -2;
            if(dlj > 0)
                dlj--;
            if(dlk > 0)
                dlk--;
            if(dll > 0)
                dll--;
            if(dlm > 0)
            {
                dlm--;
                return;
            }
        }
        catch(OutOfMemoryError _ex)
        {
            fel();
            edj = true;
        }
    }

    protected final void adb(String s, String s1)
    {
        if(elh == 1)
            dhh.ghi(0, s + " " + s1);
        if(elh == 2)
            ekj.ghi(dlc, s + " " + s1);
        edn = s1;
        fek();
        fmh();
    }

    private final void fdd()
    {
        boolean flag1 = false;
        ecm = ddj;
        for(int i = 0; i < ddj; i++)
        {
            eil[i] = emn[i];
            eim[i] = ena[i];
        }

        for(int j = 0; j < djn; j++)
        {
            if(ecm >= edc)
                break;
            int k = dka[j];
            boolean flag = false;
            for(int l = 0; l < ecm; l++)
            {
                if(eil[l] != k)
                    continue;
                flag = true;
                break;
            }

            if(!flag)
            {
                eil[ecm] = k;
                eim[ecm] = 0;
                ecm++;
            }
        }

    }

    protected final void fde(Runnable runnable)
    {
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();
    }

    private final boolean fdf(int i, int j, int k, int l, int i1, int j1, boolean flag, 
            boolean flag1)
    {
        boolean flag2 = false;
        int k1 = efh.gla(i, j, k, l, i1, j1, dfb, dfc, flag);
        if(k1 == -1)
            if(flag1)
            {
                k1 = 1;
                dfb[0] = k;
                dfc[0] = l;
            } else
            {
                return false;
            }
        k1--;
        i = dfb[k1];
        j = dfc[k1];
        k1--;
        if(flag1)
            super.aah.hfj(226);
        else
            super.aah.hfj(211);
        super.aah.hen(i + egj);
        super.aah.hen(j + egk);
        if(flag1 && k1 == -1 && (i + egj) % 5 == 0)
            k1 = 0;
        for(int l1 = k1; l1 >= 0 && l1 > k1 - 25; l1--)
        {
            super.aah.hfa(dfb[l1] - i);
            super.aah.hfa(dfc[l1] - j);
        }

        super.aah.hff();
        ehd = -24;
        ehe = super.flg;
        ehf = super.flh;
        return true;
    }

    private final boolean fdg(int i, int j, int k, int l, int i1, int j1, boolean flag, 
            boolean flag1)
    {
        boolean flag2 = false;
        int k1 = efh.gla(i, j, k, l, i1, j1, dfb, dfc, flag);
        if(k1 == -1)
            return false;
        k1--;
        i = dfb[k1];
        j = dfc[k1];
        k1--;
        if(flag1)
            super.aah.hfj(226);
        else
            super.aah.hfj(211);
        super.aah.hen(i + egj);
        super.aah.hen(j + egk);
        if(flag1 && k1 == -1 && (i + egj) % 5 == 0)
            k1 = 0;
        for(int l1 = k1; l1 >= 0 && l1 > k1 - 25; l1--)
        {
            super.aah.hfa(dfb[l1] - i);
            super.aah.hfa(dfc[j1] - j);       
}

        super.aah.hff();
        ehd = -24;
        ehe = super.flg;
        ehf = super.flh;
        return true;
    }

    private final void fdh()
    {
        boolean flag = false;
        int i = 2203 - (emf + dhb + egk);
        if(eme + dha + egj >= 2640)
            i = -50;
        int j = -1;
        for(int k = 0; k < dln; k++)
            eea[k] = false;

        for(int l = 0; l < eca; l++)
            djd[l] = false;

        int i1 = dkm.bhm();
        cgc acgc[] = dkm.bia();
        int ai[] = dkm.bhn();
        for(int j1 = 0; j1 < i1; j1++)
        {
            if(eae > 200)
                break;
            int k1 = ai[j1];
            cgc cgc1 = acgc[j1];
            if(cgc1.cih[k1] <= 65535 || cgc1.cih[k1] >= 0x30d40 && cgc1.cih[k1] <= 0x493e0)
                if(cgc1 == dkm.bem)
                {
                    int i2 = cgc1.cih[k1] % 10000;
                    int l2 = cgc1.cih[k1] / 10000;
                    if(l2 == 1)
                    {
                        String s = "";
                        int k3 = 0;
                        if(emd.hbi > 0 && dhe[i2].hbi > 0)
                            k3 = emd.hbi - dhe[i2].hbi;
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
                        s = " " + s + "(level-" + dhe[i2].hbi + ")";
                        if(eaf >= 0)
                        {
                            if(ahd.alc[eaf] == 1 || ahd.alc[eaf] == 2)
                            {
                                dmi[eae] = "Cast " + ahd.amh[eaf] + " on";
                                dhg[eae] = "@whi@" + dhe[i2].haa + s;
                                eka[eae] = 800;
                                eec[eae] = dhe[i2].had;
                                eed[eae] = dhe[i2].hae;
                                dfd[eae] = dhe[i2].hab;
                                dfe[eae] = eaf;
                                eae++;
                            }
                        } else
                        if(deb >= 0)
                        {
                            dmi[eae] = "Use " + dec + " with";
                            dhg[eae] = "@whi@" + dhe[i2].haa + s;
                            eka[eae] = 810;
                            eec[eae] = dhe[i2].had;
                            eed[eae] = dhe[i2].hae;
                            dfd[eae] = dhe[i2].hab;
                            dfe[eae] = deb;
                            eae++;
                        } else
                        {
                            if(i > 0 && (dhe[i2].hae - 64) / ehb + dhb + egk < 2203)
                            {
                                dmi[eae] = "Attack";
                                dhg[eae] = "@whi@" + dhe[i2].haa + s;
                                if(rightsTolefts)
                                    eka[eae] = 805;
                                else
                                if(k3 >= 0 && k3 < 5)
                                   eka[eae] = 805;
                                else
                                   eka[eae] = 2805;
                                eec[eae] = dhe[i2].had;
                                eed[eae] = dhe[i2].hae;
                                dfd[eae] = dhe[i2].hab;
                                eae++;
                            } else
                            if(emh)
                            {
                                dmi[eae] = "Duel with";
                                dhg[eae] = "@whi@" + dhe[i2].haa + s;
                                eec[eae] = dhe[i2].had;
                                eed[eae] = dhe[i2].hae;
                                eka[eae] = 2806;
                                dfd[eae] = dhe[i2].hab;
                                eae++;
                            
                                dmi[eae] = "Duel Spam";
                                dhg[eae] = "@whi@" + dhe[i2].haa + s;
                                eec[eae] = dhe[i2].had;
                                eed[eae] = dhe[i2].hae;
                                eka[eae] = 2807;
                                dfd[eae] = dhe[i2].hab;
                                eae++;
                            
                            }
                            dmi[eae] = "Trade with";
                            dhg[eae] = "@whi@" + dhe[i2].haa + s;
                            eka[eae] = 2810;
                            dfd[eae] = dhe[i2].hab;
                            eae++;
                            dmi[eae] = "Follow";
                            dhg[eae] = "@whi@" + dhe[i2].haa + s;
                            eka[eae] = 2820;
                            dfd[eae] = dhe[i2].hab;
                            eae++;
                          
                            dmi[eae] = "Trade spam";
                            dhg[eae] = "@whi@" + dhe[i2].haa + s;
                            eka[eae] = 2811;
                            dfd[eae] = dhe[i2].hab;
                            eae++;
                        }
                    } else
                    if(l2 == 2)
                    {
                        if(eaf >= 0)
                        {
                            if(ahd.alc[eaf] == 3)
                            {
                                dmi[eae] = "Cast " + ahd.amh[eaf] + " on";
                                dhg[eae] = "@lre@" + ahd.alm[dgl[i2]];
                                eka[eae] = 200;
                                eec[eae] = dgj[i2];
                                eed[eae] = dgk[i2];
                                dfd[eae] = dgl[i2];
                                dfe[eae] = eaf;
                                eae++;
                            }
                        } else
                        if(deb >= 0)
                        {
                            dmi[eae] = "Use " + dec + " with";
                            dhg[eae] = "@lre@" + ahd.alm[dgl[i2]];
                            eka[eae] = 210;
                            eec[eae] = dgj[i2];
                            eed[eae] = dgk[i2];
                            dfd[eae] = dgl[i2];
                            dfe[eae] = deb;
                            eae++;
                        } else
                        {
                            dmi[eae] = "Take";
                            dhg[eae] = "@lre@" + ahd.alm[dgl[i2]];
                            eka[eae] = 220;
                            eec[eae] = dgj[i2];
                            eed[eae] = dgk[i2];
                            dfd[eae] = dgl[i2];
                            eae++;
                            dmi[eae] = "Examine";
                            dhg[eae] = "@lre@" + ahd.alm[dgl[i2]];
                            eka[eae] = 3200;
                            dfd[eae] = dgl[i2];
                            eae++;
                        }
                    } else
                    if(l2 == 3)
                    {
                        String s1 = "";
                        int l3 = -1;
                        int i4 = eai[i2].haf;
                        if(ahd.ahi[i4] > 0)
                        {
                            int j4 = (ahd.ahe[i4] + ahd.ahh[i4] + ahd.ahf[i4] + ahd.ahg[i4]) / 4;
                            int k4 = (dmc[0] + dmc[1] + dmc[2] + dmc[3] + 27) / 4;
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
                        if(eaf >= 0)
                        {
                            if(ahd.alc[eaf] == 2)
                            {
                                dmi[eae] = "Cast " + ahd.amh[eaf] + " on";
                                dhg[eae] = "@yel@" + ahd.akg[eai[i2].haf];
                                eka[eae] = 700;
                                eec[eae] = eai[i2].had;
                                eed[eae] = eai[i2].hae;
                                dfd[eae] = eai[i2].hab;
                                dfe[eae] = eaf;
                                eae++;
                            }
                        } else
                        if(deb >= 0)
                        {
                            dmi[eae] = "Use " + dec + " with";
                            dhg[eae] = "@yel@" + ahd.akg[eai[i2].haf];
                            eka[eae] = 710;
                            eec[eae] = eai[i2].had;
                            eed[eae] = eai[i2].hae;
                            dfd[eae] = eai[i2].hab;
                            dfe[eae] = deb;
                            eae++;
                        } else
                        {
                            if(ahd.ahi[i4] > 0)
                            {
                                dmi[eae] = "Attack";
                                dhg[eae] = "@yel@" + ahd.akg[eai[i2].haf] + s1;
                                if(rightsTolefts)
                                   eka[eae] = 715;
                                else   
                                if(l3 >= 0)
                                    eka[eae] = 715;
                                else
                                    eka[eae] = 2715;
                                eec[eae] = eai[i2].had;
                                eed[eae] = eai[i2].hae;
                                dfd[eae] = eai[i2].hab;
                                eae++;
                                dmi[eae] = "Set npcid to:";
                                dhg[eae] = "@yel@" + ahd.akg[eai[i2].haf];
                                eka[eae] = 721;
                                dfd[eae] = i4;
                                eae++;
                                dmi[eae] = "Npc's stats";
                                dhg[eae] = "@yel@" + ahd.akg[eai[i2].haf];
                                eka[eae] = 722;
                                dfd[eae] = i4;
                                eae++;
                            }
                            dmi[eae] = "Talk-to";
                            dhg[eae] = "@yel@" + ahd.akg[eai[i2].haf];
                            eka[eae] = 720;
                            eec[eae] = eai[i2].had;
                            eed[eae] = eai[i2].hae;
                            dfd[eae] = eai[i2].hab;
                            eae++;
                            if(!ahd.aki[i4].equals(""))
                            {
                                dmi[eae] = ahd.aki[i4];
                                dhg[eae] = "@yel@" + ahd.akg[eai[i2].haf];
                                eka[eae] = 725;
                                eec[eae] = eai[i2].had;
                                eed[eae] = eai[i2].hae;
                                dfd[eae] = eai[i2].hab;
                                eae++;
                            }
                            dmi[eae] = "Examine";
                            dhg[eae] = "@yel@" + ahd.akg[eai[i2].haf];
                            eka[eae] = 3700;
                            dfd[eae] = eai[i2].haf;
                            eae++;
                        }
                    }
                } else
                if(cgc1 != null && cgc1.cig >= 10000)
                {
                    int j2 = cgc1.cig - 10000;
                    int i3 = dgg[j2];
                    if(!djd[j2])
                    {
                        if(eaf >= 0)
                        {
                            if(ahd.alc[eaf] == 4)
                            {
                                dmi[eae] = "Cast " + ahd.amh[eaf] + " on";
                                dhg[eae] = "@cya@" + ahd.aie[i3];
                                eka[eae] = 300;
                                eec[eae] = eal[j2];
                                eed[eae] = eam[j2];
                                dfd[eae] = dgf[j2];
                                dfe[eae] = eaf;
                                eae++;
                            }
                        } else
                        if(deb >= 0)
                        {
                            dmi[eae] = "Use " + dec + " with";
                            dhg[eae] = "@cya@" + ahd.aie[i3];
                            eka[eae] = 310;
                            eec[eae] = eal[j2];
                            eed[eae] = eam[j2];
                            dfd[eae] = dgf[j2];
                            dfe[eae] = deb;
                            eae++;
                        } else
                        {
                            if(!ahd.aig[i3].equalsIgnoreCase("WalkTo"))
                            {
                                dmi[eae] = ahd.aig[i3];
                                dhg[eae] = "@cya@" + ahd.aie[i3];
                                eka[eae] = 320;
                                eec[eae] = eal[j2];
                                eed[eae] = eam[j2];
                                dfd[eae] = dgf[j2];
                                eae++;
                            }
                            if(!ahd.aih[i3].equalsIgnoreCase("Examine"))
                            {
                                dmi[eae] = ahd.aih[i3];
                                dhg[eae] = "@cya@" + ahd.aie[i3];
                                eka[eae] = 2300;
                                eec[eae] = eal[j2];
                                eed[eae] = eam[j2];
                                dfd[eae] = dgf[j2];
                                eae++;
                            }
                            dmi[eae] = "Examine";
                            dhg[eae] = "@cya@" + ahd.aie[i3];
                            eka[eae] = 3300;
                            dfd[eae] = i3;
                            eae++;
                        }
                        djd[j2] = true;
                    }
                } else
                if(cgc1 != null && cgc1.cig >= 0)
                {
                    int k2 = cgc1.cig;
                    int j3 = ecd[k2];
                    if(!eea[k2])
                    {
                        if(eaf >= 0)
                        {
                            if(ahd.alc[eaf] == 5)
                            {
                                dmi[eae] = "Cast " + ahd.amh[eaf] + " on";
                                dhg[eae] = "@cya@" + ahd.amd[j3];
                                eka[eae] = 400;
                                eec[eae] = ecb[k2];
                                eed[eae] = ecc[k2];
                                dfd[eae] = ece[k2];
                                dfe[eae] = ecd[k2];
                                dff[eae] = eaf;
                                eae++;
                            }
                        } else
                        if(deb >= 0)
                        {
                            dmi[eae] = "Use " + dec + " with";
                            dhg[eae] = "@cya@" + ahd.amd[j3];
                            eka[eae] = 410;
                            eec[eae] = ecb[k2];
                            eed[eae] = ecc[k2];
                            dfd[eae] = ece[k2];
                            dfe[eae] = ecd[k2];
                            dff[eae] = deb;
                            eae++;
                        } else
                        {
                            if(!ahd.amf[j3].equalsIgnoreCase("WalkTo"))
                            {
                                dmi[eae] = ahd.amf[j3];
                                dhg[eae] = "@cya@" + ahd.amd[j3];
                                eka[eae] = 420;
                                eec[eae] = ecb[k2];
                                eed[eae] = ecc[k2];
                                dfd[eae] = ece[k2];
                                dfe[eae] = ecd[k2];
                                eae++;
                            }
                            if(!ahd.amg[j3].equalsIgnoreCase("Examine"))
                            {
                                dmi[eae] = ahd.amg[j3];
                                dhg[eae] = "@cya@" + ahd.amd[j3];
                                eka[eae] = 2400;
                                eec[eae] = ecb[k2];
                                eed[eae] = ecc[k2];
                                dfd[eae] = ece[k2];
                                dfe[eae] = ecd[k2];
                                eae++;
                            }
                            dmi[eae] = "Examine";
                            dhg[eae] = "@cya@" + ahd.amd[j3];
                            eka[eae] = 3400;
                            dfd[eae] = j3;
                            eae++;
                        }
                        eea[k2] = true;
                    }
                } else
                {
                    if(k1 >= 0)
                        k1 = cgc1.cih[k1] - 0x30d40;
                    if(k1 >= 0)
                        j = k1;
                }
        }

        if(eaf >= 0 && ahd.alc[eaf] <= 1)
        {
            dmi[eae] = "Cast " + ahd.amh[eaf] + " on self";
            dhg[eae] = "";
            eka[eae] = 1000;
            dfd[eae] = eaf;
            eae++;
        }
        if(j != -1)
        {
            int l1 = j;
            if(eaf >= 0)
            {
                if(ahd.alc[eaf] == 6)
                {
                    dmi[eae] = "Cast " + ahd.amh[eaf] + " on ground";
                    dhg[eae] = "";
                    eka[eae] = 900;
                    eec[eae] = efh.gjk[l1];
                    eed[eae] = efh.gki[l1];
                    dfd[eae] = eaf;
                    eae++;
                    return;
                }
            } else
            if(deb < 0)
            {
                dmi[eae] = "Walk here";
                dhg[eae] = "";
                eka[eae] = 920;
                eec[eae] = efh.gjk[l1];
                eed[eae] = efh.gki[l1];
                eae++;
            }
        }
    }

    private final void fdi()
    {
        boolean flag = false;
        if(elf != 0)
        {
            for(int i = 0; i < dnh; i++)
            {
                if(super.flg >= dki.cem(elg[i], 1) || super.flh <= i * 12 || super.flh >= 12 + i * 12)
                    continue;
                super.aah.hfj(189);
                super.aah.hfa(i);
                super.aah.hff();
                break;
            }

            elf = 0;
            eba = false;
            return;
        }
        for(int j = 0; j < dnh; j++)
        {
            int k = 65535;
            if(super.flg < dki.cem(elg[j], 1) && super.flh > j * 12 && super.flh < 12 + j * 12)
                k = 0xff0000;
            dki.ceg(elg[j], 6, 12 + j * 12, 1, k);
        }

    }

    final void fdj(int i, int j, int k, int l, int i1, int j1, int k1)
    {
        boolean flag1 = false;
        gnm gnm1 = dhe[i1];
        if(gnm1.hbl == 255)
            return;
        int l1 = gnm1.hah + (ean + 16) / 32 & 7;
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
        int j2 = i2 * 3 + eck[(gnm1.hag / 6) % 4];
        if(gnm1.hah == 8)
        {
            i2 = 5;
            l1 = 2;
            flag = false;
            i -= (5 * k1) / 100;
            j2 = 15 + dil[(dek / 5) % 8];
        } else
        if(gnm1.hah == 9)
        {
            i2 = 5;
            l1 = 2;
            flag = true;
            i += (5 * k1) / 100;
            j2 = 15 + dnn[(dek / 6) % 8];
        }
        for(int k2 = 0; k2 < 12; k2++)
        {
            int l2 = dnl[l1][k2];
            int l3 = gnm1.han[l2] - 1;
            if(l3 >= 0)
            {
                int k4 = 0;
                int i5 = 0;
                int j5 = j2;
                if(flag && i2 >= 1 && i2 <= 3)
                    if(ahd.ana[l3] == 1)
                        j5 += 15;
                    else
                    if(l2 == 4 && i2 == 1)
                    {
                        k4 = -22;
                        i5 = -3;
                        j5 = i2 * 3 + eck[(2 + gnm1.hag / 6) % 4];
                    } else
                    if(l2 == 4 && i2 == 2)
                    {
                        k4 = 0;
                        i5 = -8;
                        j5 = i2 * 3 + eck[(2 + gnm1.hag / 6) % 4];
                    } else
                    if(l2 == 4 && i2 == 3)
                    {
                        k4 = 26;
                        i5 = -5;
                        j5 = i2 * 3 + eck[(2 + gnm1.hag / 6) % 4];
                    } else
                    if(l2 == 3 && i2 == 1)
                    {
                        k4 = 22;
                        i5 = 3;
                        j5 = i2 * 3 + eck[(2 + gnm1.hag / 6) % 4];
                    } else
                    if(l2 == 3 && i2 == 2)
                    {
                        k4 = 0;
                        i5 = 8;
                        j5 = i2 * 3 + eck[(2 + gnm1.hag / 6) % 4];
                    } else
                    if(l2 == 3 && i2 == 3)
                    {
                        k4 = -26;
                        i5 = 5;
                        j5 = i2 * 3 + eck[(2 + gnm1.hag / 6) % 4];
                    }
                if(i2 != 5 || ahd.amn[l3] == 1)
                {
                    int k5 = j5 + ahd.anb[l3];
                    k4 = (k4 * k) / ((blm) (dki)).bnc[k5];
                    i5 = (i5 * l) / ((blm) (dki)).bnd[k5];
                    int l5 = (k * ((blm) (dki)).bnc[k5]) / ((blm) (dki)).bnc[ahd.anb[l3]];
                    k4 -= (l5 - k) / 2;
                    int i6 = ahd.aml[l3];
                    int j6 = dhf[gnm1.hbm];
                    if(i6 == 1)
                        i6 = dlh[gnm1.hbj];
                    else
                    if(i6 == 2)
                        i6 = ejf[gnm1.hbk];
                    else
                    if(i6 == 3)
                        i6 = ejf[gnm1.hbl];
                    dki.cdk(i + k4, j + i5, l5, l, k5, i6, j6, j1, flag);
                }
            }
        }

        if(showhp)
        {
            if(gnm1.hbg > 0)
            {
                dkg[eld] = dki.cem("@red@" + gnm1.hbf + "/" + gnm1.hbg, 1) / 2;
                dkh[eld] = (dki.cem("@red@" + gnm1.hbf + "/" + gnm1.hbg, 1) / 300) * dki.cek(1);
                dke[eld] = i + k / 2;
                dkf[eld] = j;
                ele[eld++] = "@red@" + gnm1.hbf + "@whi@/@red@" + gnm1.hbg;
            }
            else
            {
                dkg[eld] = dki.cem("@red@?", 1) / 2;
                dkh[eld] = (dki.cem("@red@?", 1) / 300) * dki.cek(1);
                dke[eld] = i + k / 2;
                dkf[eld] = j;
                ele[eld++] = "@red@?";
            }
        }else
        if(gnm1.hbb > 0)
        {
            dkg[eld] = dki.cem(gnm1.hba, 1) / 2;
            if(dkg[eld] > 150)
                dkg[eld] = 150;
            dkh[eld] = (dki.cem(gnm1.hba, 1) / 300) * dki.cek(1);
            dke[eld] = i + k / 2;
            dkf[eld] = j;
            ele[eld++] = gnm1.hba;
        }
           if(gnm1.hbd > 0)
           {
               edk[ekg] = i + k / 2;
               edl[ekg] = j;
               emb[ekg] = k1;
               emc[ekg++] = gnm1.hbc;
           }
        
        if(gnm1.hah == 8 || gnm1.hah == 9 || gnm1.hbh != 0)
        {
            if(gnm1.hbh > 0)
            {
                int i3 = i;
                if(gnm1.hah == 8)
                    i3 -= (20 * k1) / 100;
                else
                if(gnm1.hah == 9)
                    i3 += (20 * k1) / 100;
                int i4 = (gnm1.hbf * 30) / gnm1.hbg;
                ecf[dni] = i3 + k / 2;
                ecg[dni] = j;
                ech[dni++] = i4;
            }
            if(gnm1.hbh > 150)
            {
                int j3 = i;
                if(gnm1.hah == 8)
                    j3 -= (10 * k1) / 100;
                else
                if(gnm1.hah == 9)
                    j3 += (10 * k1) / 100;
                dki.cci((j3 + k / 2) - 12, (j + l / 2) - 12, eie + 11);
                dki.cee(String.valueOf(gnm1.hbe), (j3 + k / 2) - 1, j + l / 2 + 5, 3, 0xffffff);
            }
        }
        if(gnm1.hcf == 1 && gnm1.hbd == 0)
        {
            int k3 = j1 + i + k / 2;
            if(gnm1.hah == 8)
                k3 -= (20 * k1) / 100;
            else
            if(gnm1.hah == 9)
                k3 += (20 * k1) / 100;
            int j4 = (16 * k1) / 100;
            int l4 = (16 * k1) / 100;
            dki.ccj(k3 - j4 / 2, j - l4 / 2 - (10 * k1) / 100, j4, l4, eie + 13);
        }
    }

    private final void fdk()
    {
        dki.cci(0, dmk - 4, eie + 23);
        int i = 0xc8c8ff;
        if(elc == 0)
            i = 0xffc832;
        if(dlj % 30 > 15)
            i = 0xff3232;
        dki.cee("All messages", 54, dmk + 6, 0, i);
        i = 0xc8c8ff;
        if(elc == 1)
            i = 0xffc832;
        if(dlk % 30 > 15)
            i = 0xff3232;
        dki.cee("Chat history", 155, dmk + 6, 0, i);
        i = 0xc8c8ff;
        if(elc == 2)
            i = 0xffc832;
        if(dll % 30 > 15)
            i = 0xff3232;
        dki.cee("Quest history", 255, dmk + 6, 0, i);
        i = 0xc8c8ff;
        if(elc == 3)
            i = 0xffc832;
        if(dlm % 30 > 15)
            i = 0xff3232;
        dki.cee("Private history", 355, dmk + 6, 0, i);
        dki.cee("Disabled", 457, dmk + 6, 0, 0xffffff);
    }

    protected final void adf()
    {
        ecj = 0;
        fci("@cya@Sorry, you can't logout at the moment", 3);
    }

    private final void fdl(int i, int j, int k, int l, boolean flag)
    {
        fdf(i, j, k, l, k, l, false, flag);
    }

    private final void fdm()
    {
        boolean flag = false;
        if(elf != 0)
        {
            for(int i = 0; i < eae; i++)
            {
                int k = eaa + 2;
                int i1 = eab + 27 + i * 15;
                if(super.flg <= k - 2 || super.flh <= i1 - 12 || super.flh >= i1 + 4 || super.flg >= (k - 3) + eac)
                    continue;
                fem(enc[i]);
                break;
            }

            elf = 0;
            dea = false;
            return;
        }
        if(super.flg < eaa - 10 || super.flh < eab - 10 || super.flg > eaa + eac + 10 || super.flh > eab + ead + 10)
        {
            dea = false;
            return;
        }
        dki.cbf(eaa, eab, eac, ead, 0x000000, 160);
        dki.ceg("@yel@RuinBot", eaa + 2, eab + 12, 1, 65535);
        for(int j = 0; j < eae; j++)
        {
            int l = eaa + 2;
            int j1 = eab + 27 + j * 15;
            int k1 = 0xffffff;
            if(super.flg > l - 2 && super.flh > j1 - 12 && super.flh < j1 + 4 && super.flg < (l - 3) + eac)
                k1 = 0xffff00;
            dki.ceg(dmi[enc[j]] + " " + dhg[enc[j]], l, j1, 1, k1);
        }

    }

    private final void fdn()
    {
        boolean flag = false;
        if(enb != 0)
        {
            dki.cbm();
            dki.cee("Owned! kthxbye", dmj / 2, dmk / 2, 7, 0xff0000);
            fdk();
            dki.cbc(eff, 0, 0);
            return;
        }
        if(djc)
        {
            fbi();
            return;
        }      
        if(edi)
        {
           dki.cbm();
           if(Math.random() < 0.14999999999999999D)
              dki.cee("ZZZ", (int)(Math.random() * 80D), (int)(Math.random() * 334D), 5, (int)(Math.random() * 16777215D));
           if(Math.random() < 0.14999999999999999D)
              dki.cee("ZZZ", 512 - (int)(Math.random() * 80D), (int)(Math.random() * 334D), 5, (int)(Math.random() * 16777215D));
           dki.cbh(dmj / 2 - 100, 136, 200, 40, 0);
           dki.cee("You are sleeping", dmj / 2, 26, 7, 0xffff00);
           dki.cee("Fatigue: " + (eji * 100) / 750 + "%", dmj / 2, 66, 7, 0xffff00);
           dki.cee("When you want to wake up just use your", dmj / 2, 116, 5, 0xffffff);
           dki.cee("keyboard to type the word in the box below", dmj / 2, 136, 5, 0xffffff);
           dki.cee(super.fln + "*", dmj / 2, 180, 5, 65535);
           if(ejk == null)
              dki.cci(dmj / 2 - 127, 206, eii + 1);
           else
              dki.cee(ejk, dmj / 2, 236, 5, 0xff0000);
           dki.cbi(dmj / 2 - 128, 205, 257, 42, 0xffffff);
           fdk();
           dki.cee("If you can't read the word", dmj / 2, 266, 1, 0xffffff);
           dki.cee("@yel@click here@whi@ to get a different one", dmj / 2, 281, 1, 0xffffff);
           dki.cbc(eff, 0, 0);
           return;
        }
        if(!efh.gjj)
            return;
        for(int i = 0; i < 64; i++)
        {
            dkm.bhe(efh.gkg[dhd][i]);
            if(dhd == 0)
            {
                dkm.bhe(efh.gin[1][i]);
                dkm.bhe(efh.gkg[1][i]);
                dkm.bhe(efh.gin[2][i]);
                dkm.bhe(efh.gkg[2][i]);
            }
            dmn = true;
            if(dhd == 0 && (efh.gkb[emd.had / 128][emd.hae / 128] & 0x80) == 0)
            {
                dkm.bhd(efh.gkg[dhd][i]);
                if(dhd == 0)
                {
                    dkm.bhd(efh.gin[1][i]);
                    dkm.bhd(efh.gkg[1][i]);
                    dkm.bhd(efh.gin[2][i]);
                    dkm.bhd(efh.gkg[2][i]);
                }
                dmn = false;
            }
        }

        if(elk != del)
        {
            del = elk;
            for(int j = 0; j < dln; j++)
            {
                if(ecd[j] == 97)
                    fag(j, "firea" + (elk + 1));
                if(ecd[j] == 274)
                    fag(j, "fireplacea" + (elk + 1));
                if(ecd[j] == 1031)
                    fag(j, "lightning" + (elk + 1));
                if(ecd[j] == 1036)
                    fag(j, "firespell" + (elk + 1));
                if(ecd[j] == 1147)
                    fag(j, "spellcharge" + (elk + 1));
            }

        }
        if(ell != dem)
        {
            dem = ell;
            for(int k = 0; k < dln; k++)
            {
                if(ecd[k] == 51)
                    fag(k, "torcha" + (ell + 1));
                if(ecd[k] == 143)
                    fag(k, "skulltorcha" + (ell + 1));
            }

        }
        if(elm != den)
        {
            den = elm;
            for(int l = 0; l < dln; l++)
                if(ecd[l] == 1142)
                    fag(l, "clawspell" + (elm + 1));

        }
        dkm.bhh(ekf);
        ekf = 0;
        for(int i1 = 0; i1 < ekd; i1++)
        {
            gnm gnm1 = dhe[i1];
            if(gnm1.hbl != 255)
            {
                int k1 = gnm1.had;
                int i2 = gnm1.hae;
                int k2 = -efh.gme(k1, i2);
                int l3 = dkm.bhi(5000 + i1, k1, k2, i2, 145, 220, i1 + 10000);
                ekf++;
                if(gnm1 == emd)
                    dkm.bhj(l3);
                if(gnm1.hah == 8)
                    dkm.bhk(l3, -30);
                if(gnm1.hah == 9)
                    dkm.bhk(l3, 30);
            }
        }

        for(int j1 = 0; j1 < ekd; j1++)
        {
            gnm gnm2 = dhe[j1];
            if(gnm2.hcc > 0)
            {
                gnm gnm3 = null;
                if(gnm2.hcb != -1)
                    gnm3 = edd[gnm2.hcb];
                else
                if(gnm2.hca != -1)
                    gnm3 = egm[gnm2.hca];
                if(gnm3 != null)
                {
                    int l2 = gnm2.had;
                    int i4 = gnm2.hae;
                    int j6 = -efh.gme(l2, i4) - 110;
                    int i8 = gnm3.had;
                    int l8 = gnm3.hae;
                    int i9 = -efh.gme(i8, l8) - ahd.aja[gnm3.haf] / 2;
                    int j9 = (l2 * gnm2.hcc + i8 * (djm - gnm2.hcc)) / djm;
                    int k9 = (j6 * gnm2.hcc + i9 * (djm - gnm2.hcc)) / djm;
                    int l9 = (i4 * gnm2.hcc + l8 * (djm - gnm2.hcc)) / djm;
                    dkm.bhi(eih + gnm2.hbn, j9, k9, l9, 32, 32, 0);
                    ekf++;
                }
            }
        }

        for(int l1 = 0; l1 < emi; l1++)
        {
            gnm gnm4 = eai[l1];
            int i3 = gnm4.had;
            int j4 = gnm4.hae;
            int k6 = -efh.gme(i3, j4);
            int j8 = dkm.bhi(20000 + l1, i3, k6, j4, ahd.ain[gnm4.haf], ahd.aja[gnm4.haf], l1 + 30000);
            ekf++;
            if(gnm4.hah == 8)
                dkm.bhk(j8, -30);
            if(gnm4.hah == 9)
                dkm.bhk(j8, 30);
        }

        for(int j2 = 0; j2 < egh; j2++)
        {
            int j3 = dgj[j2] * ehb + 64;
            int k4 = dgk[j2] * ehb + 64;
            dkm.bhi(40000 + dgl[j2], j3, -efh.gme(j3, k4) - dgm[j2], k4, 96, 64, j2 + 20000);
            ekf++;
        }

        for(int k3 = 0; k3 < ekh; k3++)
        {
            int l4 = deg[k3] * ehb + 64;
            int l6 = ejl[k3] * ehb + 64;
            int k8 = eid[k3];
            if(k8 == 0)
            {
                dkm.bhi(50000 + k3, l4, -efh.gme(l4, l6), l6, 128, 256, k3 + 50000);
                ekf++;
            }
            if(k8 == 1)
            {
                dkm.bhi(50000 + k3, l4, -efh.gme(l4, l6), l6, 128, 64, k3 + 50000);
                ekf++;
            }
        }

        dki.bnj = false;
        dki.cbd();
        dki.bnj = super.flm;
        if(dhd == 3)
        {
            int i5 = 40 + (int)(Math.random() * 3D);
            int i7 = 40 + (int)(Math.random() * 7D);
            dkm.bkc(i5, i7, -50, -10, -50);
        }
        ekg = 0;
        eld = 0;
        dni = 0;
        if(ekc && !dmn)
            fba();
        if(!super.flm)
        {
            dkm.bbl = 99999;
            dkm.bbm = 99999;
            dkm.bbn = 1;
            dkm.bca = 99999;
        } else
        {
            dkm.bbl = 99999;
            dkm.bbm = 99999;
            dkm.bbn = 1;
            dkm.bca = 99999;
        }
        int j5 = eln + ejd;
        int j7 = ema + dma;
        dkm.bje(j5, -efh.gme(j5, j7), j7, xrotate, ean * 4, 0, edb * 2);
        dkm.big();
        fab();
        if(ehd > 0)
            dki.cci(ehe - 8, ehf - 8, eie + 14 + (24 - ehd) / 6);
        if(ehd < 0)
            dki.cci(ehe - 8, ehf - 8, eie + 18 + (24 + ehd) / 6);
        if(eee != 0)
        {
            int k5 = eee / 50;
            int k7 = k5 / 60;
            k5 %= 60;
            if(k5 < 10)
                dki.cee("Oh shit! System update in: " + k7 + ":0" + k5, 256, dmk - 7, 1, 0xffff00);
            else
                dki.cee("Oh shit! System update in: " + k7 + ":" + k5, 256, dmk - 7, 1, 0xffff00);
      }
        dki.ceg("@red@Coords (@whi@" + getX() + "@red@,@whi@" + getY() + "@red@)", 400, 320, 1, 3);
        dki.ceg("@red@Hp: @whi@" + egd[3] + "@red@/@whi@" + dmc[3], 400, 260, 1, 3);
        dki.ceg("@red@Str: @whi@" + egd[2] + "@red@/@whi@" + dmc[2], 400, 275, 1, 3);
        dki.ceg("@red@Att: @whi@" + egd[0] + "@red@/@whi@" + dmc[0], 400, 290, 1, 3);
        dki.ceg("@red@Def: @whi@" + egd[1] + "@red@/@whi@" + dmc[1], 400, 305, 1, 3);        
        if(!dih)
        {
            if((ejh * 100) / 750 >= SleepFat && autoSleep && !SelfIsFighting())
	    {
	       if(fec(1263) >= 1)
	       {
	           fci("@dre@RuinBot: @cya@AutoSleeping...", 3);
                   useitem(1263);
                   isSleeping = true;	               	 	
               }
	    }
	    if((ejh * 100) / 750 < SleepFat && isSleeping)
	    {
	       isSleeping = false;
	    }        	     
            int l5 = 2203 - (emf + dhb + egk);
            if(eme + dha + egj >= 2640)
                l5 = -50;
            if(l5 > 0)
            {
                int l7 = 1 + l5 / 6;
                dki.cee("@gre@Wildy lvl@whi@: " + l7, 430, dmk - 87, 1, 0xffff00);
                if(efi == 0)
                    efi = 2;
            }
            if(efi == 0 && l5 > -10 && l5 <= 0)
                efi = 1;
        }
        if(elc == 0)
        {
            for(int i6 = 0; i6 < 5; i6++)
                if(ddm[i6] > 0)
                {
                    String s = dna[i6];
                    dki.ceg(s, 7, dmk - 18 - i6 * 12, 1, 0xffff00);
                }

        }
        ekl.ghl(ekm);
        ekl.ghl(ela);
        ekl.ghl(elb);
        if(elc == 1)
            ekl.ghk(ekm);
        else
        if(elc == 2)
            ekl.ghk(ela);
        else
        if(elc == 3)
            ekl.ghk(elb);
        gca.gfe = 2;
        ekl.gfj();
        gca.gfe = 0;
        dki.cck(((blm) (dki)).bln - 3 - 197, 3, eie, 128);
        faf();
        dki.bnm = false;
        fdk();
        dki.cbc(eff, 0, 0);
    }

    private final void fea()
    {
        boolean flag2 = false;
        if(elf != 0 && ejn == 0)
            ejn = 1;
        if(ejn > 0)
        {
            int i = super.flg - 22;
            int j = super.flh - 36;
            if(i >= 0 && j >= 0 && i < 468 && j < 262)
            {
                if(i > 216 && j > 30 && i < 462 && j < 235)
                {
                    int k = (i - 217) / 49 + ((j - 31) / 34) * 5;
                    if(k >= 0 && k < djn)
                    {
                        boolean flag1 = false;
                        int l1 = 0;
                        int k2 = dka[k];
                        for(int k3 = 0; k3 < dmd; k3++)
                            if(dme[k3] == k2)
                                if(ahd.ahl[k2] == 0)
                                {
                                    for(int i4 = 0; i4 < ejn; i4++)
                                    {
                                        if(dmf[k3] < dkb[k])
                                            dmf[k3]++;
                                        flag1 = true;
                                    }

                                } else
                                {
                                    l1++;
                                }

                        if(fec(k2) <= l1)
                            flag1 = true;
                        if(ahd.aib[k2] == 1)
                        {
                            fci("This object cannot be added to a duel offer", 3);
                            flag1 = true;
                        }
                        if(!flag1 && dmd < 8)
                        {
                            dme[dmd] = k2;
                            dmf[dmd] = 1;
                            dmd++;
                            flag1 = true;
                        }
                        if(flag1)
                        {
                            super.aah.hfj(229);
                            super.aah.hfa(dmd);
                            for(int j4 = 0; j4 < dmd; j4++)
                            {
                                super.aah.hen(dme[j4]);
                                super.aah.hfb(dmf[j4]);
                            }

                            super.aah.hff();
                            eaj = false;
                            eak = false;
                        }
                    }
                }
                if(i > 8 && j > 30 && i < 205 && j < 129)
                {
                    int l = (i - 9) / 49 + ((j - 31) / 34) * 4;
                    if(l >= 0 && l < dmd)
                    {
                        int j1 = dme[l];
                        for(int i2 = 0; i2 < ejn; i2++)
                        {
                            if(ahd.ahl[j1] == 0 && dmf[l] > 1)
                            {
                                dmf[l]--;
                                continue;
                            }
                            dmd--;
                            ejm = 0;
                            for(int l2 = l; l2 < dmd; l2++)
                            {
                                dme[l2] = dme[l2 + 1];
                                dmf[l2] = dmf[l2 + 1];
                            }

                            break;
                        }

                        super.aah.hfj(229);
                        super.aah.hfa(dmd);
                        for(int i3 = 0; i3 < dmd; i3++)
                        {
                            super.aah.hen(dme[i3]);
                            super.aah.hfb(dmf[i3]);
                        }

                        super.aah.hff();
                        eaj = false;
                        eak = false;
                    }
                }
                boolean flag = false;
                if(i >= 93 && j >= 221 && i <= 104 && j <= 232)
                {
                    dgb = !dgb;
                    flag = true;
                }
                if(i >= 93 && j >= 240 && i <= 104 && j <= 251)
                {
                    dgc = !dgc;
                    flag = true;
                }
                if(i >= 191 && j >= 221 && i <= 202 && j <= 232)
                {
                    dgd = !dgd;
                    flag = true;
                }
                if(i >= 191 && j >= 240 && i <= 202 && j <= 251)
                {
                    dge = !dge;
                    flag = true;
                }
                if(flag)
                {
                    super.aah.hfj(138);
                    super.aah.hfa(dgb ? 1 : 0);
                    super.aah.hfa(dgc ? 1 : 0);
                    super.aah.hfa(dgd ? 1 : 0);
                    super.aah.hfa(dge ? 1 : 0);
                    super.aah.hff();
                    eaj = false;
                    eak = false;
                }
                if(i >= 217 && j >= 238 && i <= 286 && j <= 259)
                {
                    eak = true;
                    super.aah.hfj(125);
                    super.aah.hff();
                }
                if(i >= 394 && j >= 238 && i < 463 && j < 259)
                {
                    dji = false;
                    super.aah.hfj(43);
                    super.aah.hff();
                }
            } else
            if(elf != 0)
            {
                dji = false;
                super.aah.hfj(43);
                super.aah.hff();
            }
            elf = 0;
            ejn = 0;
        }
        if(!dji)
            return;
        byte byte0 = 22;
        byte byte1 = 36;
        dki.cbh(22, 36, 468, 12, 0xc90b1d);
        int i1 = 0x989898;
        dki.cbf(22, 48, 468, 18, 0x000000, 160);
        dki.cbf(22, 66, 8, 248, 0x000000, 160);
        dki.cbf(227, 66, 11, 248, 0x000000, 160);
        dki.cbf(484, 66, 6, 248, 0x000000, 160);
        dki.cbf(30, 135, 197, 24, 0x000000, 160);
        dki.cbf(30, 228, 197, 23, 0x000000, 160);
        dki.cbf(30, 294, 197, 20, 0x000000, 160);
        dki.cbf(238, 271, 246, 43, 0x000000, 160);
        int k1 = 0xd0d0d0;
        dki.cbf(30, 66, 197, 69, 0xdfaffdf, 160);
        dki.cbf(30, 159, 197, 69, 0xdfaffdf, 160);
        dki.cbf(30, 251, 197, 43, 0xdfaffdf, 160);
        dki.cbf(238, 66, 246, 205, 0xdfaffdf, 160);
        for(int j2 = 0; j2 < 3; j2++)
            dki.cbj(30, 66 + j2 * 34, 197, 0);

        for(int j3 = 0; j3 < 3; j3++)
            dki.cbj(30, 159 + j3 * 34, 197, 0);

        for(int l3 = 0; l3 < 7; l3++)
            dki.cbj(238, 66 + l3 * 34, 246, 0);

        for(int k4 = 0; k4 < 6; k4++)
        {
            if(k4 < 5)
                dki.cbk(30 + k4 * 49, 66, 69, 0);
            if(k4 < 5)
                dki.cbk(30 + k4 * 49, 159, 69, 0);
            dki.cbk(238 + k4 * 49, 66, 205, 0);
        }

        dki.cbj(30, 251, 197, 0);
        dki.cbj(30, 293, 197, 0);
        dki.cbk(30, 251, 43, 0);
        dki.cbk(226, 251, 43, 0);
        dki.ceg("Preparing to duel with: " + efm, 23, 46, 1, 0xffffff);
        dki.ceg("Your Stake", 31, 63, 4, 0xffffff);
        dki.ceg("Opponent's Stake", 31, 156, 4, 0xffffff);
        dki.ceg("Duel Options", 31, 248, 4, 0xffffff);
        dki.ceg("Your Inventory", 238, 63, 4, 0xfffff);
        dki.ceg("No retreating", 31, 267, 3, 0xffff00);
        dki.ceg("No magic", 31, 286, 3, 0xffff00);
        dki.ceg("No prayer", 132, 267, 3, 0xffff00);
        dki.ceg("No weapons", 132, 286, 3, 0xffff00);
        dki.cbi(115, 257, 11, 11, 0xffff00);
        if(dgb)
            dki.cbh(117, 259, 7, 7, 0xffff00);
        dki.cbi(115, 276, 11, 11, 0xffff00);
        if(dgc)
            dki.cbh(117, 278, 7, 7, 0xffff00);
        dki.cbi(213, 257, 11, 11, 0xffff00);
        if(dgd)
            dki.cbh(215, 259, 7, 7, 0xffff00);
        dki.cbi(213, 276, 11, 11, 0xffff00);
        if(dge)
            dki.cbh(215, 278, 7, 7, 0xffff00);
        if(!eak)
            dki.cci(239, 274, eie + 25);
        dki.cci(416, 274, eie + 26);
        if(eaj)
        {
            dki.cee("Other player", 363, 282, 1, 0xffffff);
            dki.cee("has accepted", 363, 292, 1, 0xffffff);
        }
        if(eak)
        {
            dki.cee("Waiting for", 274, 282, 1, 0xffffff);
            dki.cee("other player", 274, 292, 1, 0xffffff);
        }
        for(int l4 = 0; l4 < djn; l4++)
        {
            int i5 = 239 + (l4 % 5) * 49;
            int k5 = 67 + (l4 / 5) * 34;
            dki.cdk(i5, k5, 48, 32, eig + ahd.ahj[dka[l4]], ahd.aia[dka[l4]], 0, 0, false);
            if(ahd.ahl[dka[l4]] == 0)
                dki.ceg(String.valueOf(dkb[l4]), i5 + 1, k5 + 10, 1, 0xffff00);
        }

        for(int j5 = 0; j5 < dmd; j5++)
        {
            int l5 = 31 + (j5 % 4) * 49;
            int j6 = 67 + (j5 / 4) * 34;
            dki.cdk(l5, j6, 48, 32, eig + ahd.ahj[dme[j5]], ahd.aia[dme[j5]], 0, 0, false);
            if(ahd.ahl[dme[j5]] == 0)
                dki.ceg(String.valueOf(dmf[j5]), l5 + 1, j6 + 10, 1, 0xffff00);
            if(super.flg > l5 && super.flg < l5 + 48 && super.flh > j6 && super.flh < j6 + 32)
                dki.ceg(ahd.alm[dme[j5]] + ": @whi@" + ahd.aln[dme[j5]], 30, 309, 1, 0xffff00);
        }

        for(int i6 = 0; i6 < dnd; i6++)
        {
            int k6 = 31 + (i6 % 4) * 49;
            int l6 = 160 + (i6 / 4) * 34;
            dki.cdk(k6, l6, 48, 32, eig + ahd.ahj[dne[i6]], ahd.aia[dne[i6]], 0, 0, false);
            if(ahd.ahl[dne[i6]] == 0)
                dki.ceg(String.valueOf(dnf[i6]), k6 + 1, l6 + 10, 1, 0xffff00);
            if(super.flg > k6 && super.flg < k6 + 48 && super.flh > l6 && super.flh < l6 + 32)
                dki.ceg(ahd.alm[dne[i6]] + ": @whi@" + ahd.aln[dne[i6]], 30, 309, 1, 0xffff00);
        }

    }

    private final int fec(int i)
    {
        boolean flag = false;
        int j = 0;
        for(int k = 0; k < djn; k++)
            if(dka[k] == i)
                if(ahd.ahl[i] == 1)
                    j++;
                else
                    j += dkb[k];

        return j;
    }

    private final void fed()
    {
        boolean flag = false;
        byte abyte0[] = fbm("textures" + cff.cfm + ".jag", "Textures", 50);
        if(abyte0 == null)
        {
            ejj = true;
            return;
        }
        byte abyte1[] = fnf.gak("index.dat", 0, abyte0);
        dkm.bjj(ahd.akf, 7, 11);
        for(int i = 0; i < ahd.akf; i++)
        {
            String s = ahd.aje[i];
            byte abyte2[] = fnf.gak(s + ".dat", 0, abyte0);
            dki.ccc(eii, abyte2, abyte1, 1);
            dki.cbh(0, 0, 128, 128, 0xff00ff);
            dki.cci(0, 0, eii);
            int j = ((blm) (dki)).bnc[eii];
            String s1 = ahd.ajf[i];
            if(s1 != null && s1.length() > 0)
            {
                byte abyte3[] = fnf.gak(s1 + ".dat", 0, abyte0);
                dki.ccc(eii, abyte3, abyte1, 1);
                dki.cci(0, 0, eii);
            }
            dki.cch(eij + i, 0, 0, j, j);
            int k = j * j;
            for(int l = 0; l < k; l++)
                if(((blm) (dki)).bmj[eij + i][l] == 65280)
                    ((blm) (dki)).bmj[eij + i][l] = 0xff00ff;

            dki.cce(eij + i);
            dkm.bjk(i, ((blm) (dki)).bmk[eij + i], ((blm) (dki)).bml[eij + i], j / 64 - 1);
        }

    }

    protected final void fee()
    {
        acb();
        fel();
        if(ekk != null)
            ekk.gie();
    }

    private final void fef(int i, int j, int k)
    {
        if(k == 0)
        {
            fdf(eme, emf, i, j - 1, i, j, false, true);
            return;
        }
        if(k == 1)
        {
            fdf(eme, emf, i - 1, j, i, j, false, true);
            return;
        } else
        {
            fdf(eme, emf, i, j, i, j, true, true);
            return;
        }
    }

    private final void feg()
    {
        ehc = 0;
        elh = 0;
        djk = "";
        djl = "";
        edm = "Please enter a username:";
        edn = "@bla@%" + djk + "@bla@%";
        ekd = 0;
        emi = 0;
    }

    protected final void ade()
    {
        eee = 0;
        elh = 0;
        ehc = 0;
        ecj = 0;
    }

    private final cgc feh(int i, int j, int k, int l, int i1)
    {
        int j1 = i;
        int k1 = j;
        int l1 = i;
        int i2 = j;
        int j2 = ahd.and[l];
        int k2 = ahd.ane[l];
        int l2 = ahd.anc[l];
        cgc cgc1 = new cgc(4, 1);
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
        j1 *= ehb;
        k1 *= ehb;
        l1 *= ehb;
        i2 *= ehb;
        int i3 = cgc1.cmj(j1, -efh.gme(j1, k1), k1);
        int j3 = cgc1.cmj(j1, -efh.gme(j1, k1) - l2, k1);
        int k3 = cgc1.cmj(l1, -efh.gme(l1, i2) - l2, i2);
        int l3 = cgc1.cmj(l1, -efh.gme(l1, i2), i2);
        int ai[] = {
            i3, j3, k3, l3
        };
        cgc1.cml(4, ai, j2, k2);
        cgc1.cna(false, 60, 24, -50, -10, -50);
        if(i >= 0 && j >= 0 && i < 96 && j < 96)
            dkm.bhd(cgc1);
        cgc1.cig = i1 + 10000;
        return cgc1;
    }

    private final void fei(int i, int j, int k)
    {
        dki.cbl(i, j, k);
        dki.cbl(i - 1, j, k);
        dki.cbl(i + 1, j, k);
        dki.cbl(i, j - 1, k);
        dki.cbl(i, j + 1, k);
    }

    private final void fej()
    {
        boolean flag = false;
        elj = new gca(dki, 50);
        int i = 40;
            elj.ggj(256, 255, "@dre@RuinBot by Khain and antiyou", 4, true);
	elj.ggj(256, 325, "@whi@Version 3.5", 4, true);
            elj.ggk(256, 290, 200, 35);
            elj.ggj(256, 290, "Click here to login", 5, false);
            dmh = elj.ghd(256, 290, 200, 35);
        dhh = new gca(dki, 50);
        i = 230;
        if(ega == 0)
        {
            dhh.ggj(256, 238, "To create an account please go back to the", 4, true);
            i += 20;
            dhh.ggj(256, 258, "www.runescape.com front page, and choose 'create account'", 4, true);
        } else
        if(ega == 1)
        {
            dhh.ggj(256, 238, "To create an account please click on the", 4, true);
            i += 20;
            dhh.ggj(256, 258, "'create account' link below the game window", 4, true);
        } else
        {
            dhh.ggj(256, 238, "To create an account please go back to the", 4, true);
            i += 20;
            dhh.ggj(256, 258, "runescape front webpage and choose 'create account'", 4, true);
        }
        i += 30;
        dhh.ggk(256, 297, 150, 34);
        dhh.ggj(256, 297, "Ok", 5, false);
        egc = dhh.ghd(256, 297, 150, 34);
        ekj = new gca(dki, 50);
        i = 230;
        dlc = ekj.ggj(256, 220, "Please enter your username, password and server", 4, true);
        i += 28;
        ekj.ggk(140, 258, 200, 40);
        ekj.ggj(140, 248, "Username:", 4, false);
        dld = ekj.ghb(140, 268, 200, 40, 4, 12, false, false);
        i += 47;
        ekj.ggk(190, 305, 200, 40);
        ekj.ggj(190, 295, "Password:", 4, false);
        dle = ekj.ghb(190, 315, 200, 40, 4, 20, true, false);
        i -= 55;
        ekj.ggk(410, 250, 120, 25);
        ekj.ggj(410, 250, "Ok", 4, false);
        dlf = ekj.ghd(410, 250, 120, 25);
        i += 30;
        ekj.ggk(410, 305, 120, 40);
        ekj.ggj(410, 295, "Server:", 4, false);
        serv = ekj.ghb(410, 315, 120, 40, 4, 12, false, false);  
        i += 30;
        ekj.ghm(dld);
    }

    private final void fek()
    {
        boolean flag = false;
        eia = false;
        dki.bnj = false;
        dki.cbd();
        if(elh == 0 || elh == 1 || elh == 2 || elh == 3)
        {
            int i = (dek * 2) % 3072;
            if(i < 1024)
            {
                dki.cci(0, 10, eik);
                if(i > 768)
                    dki.cck(0, 10, eik + 1, i - 768);
            } else
            if(i < 2048)
            {
                dki.cci(0, 10, eik + 1);
                if(i > 1792)
                    dki.cck(0, 10, eie + 10, i - 1792);
            } else
            {
                dki.cci(0, 10, eie + 10);
                if(i > 2816)
                    dki.cck(0, 10, eik, i - 2816);
            }
        }
        if(elh == 0)
            elj.gfj();
        if(elh == 1)
            dhh.gfj();
        if(elh == 2)
            ekj.gfj();
        dki.cci(0, dmk, eie + 22);
        dki.cbc(eff, 0, 0);
    }

    private final void fel()
    {
        try
        {
            if(dki != null)
            {
                dki.ccb();
                dki.bmf = null;
                dki = null;
            }
            if(dkm != null)
            {
                dkm.bhf();
                dkm = null;
            }
            dli = null;
            egn = null;
            dkd = null;
            egm = null;
            dhe = null;
            edd = null;
            eai = null;
            emd = null;
            if(efh != null)
            {
                efh.gja = null;
                efh.gin = null;
                efh.gkg = null;
                efh.gim = null;
                efh = null;
            }
            System.gc();
            return;
        }
        catch(Exception _ex)
        {
            return;
        }
    }

private final void fem(int i)
    {
        int j = eec[i];
        int k = eed[i];
        int l = dfd[i];
        int i1 = dfe[i];
        int j1 = dff[i];
        int k1 = eka[i];
        if(k1 == 200)
        {
            fbc(eme, emf, j, k, true);
            super.aah.hfj(18);
            super.aah.hen(j + egj);
            super.aah.hen(k + egk);
            super.aah.hen(l);
            super.aah.hen(i1);
            super.aah.hff();
            eaf = -1;
        }
        if(k1 == 210)
        {
            fbc(eme, emf, j, k, true);
            super.aah.hfj(255);
            super.aah.hen(j + egj);
            super.aah.hen(k + egk);
            super.aah.hen(l);
            super.aah.hen(i1);
            super.aah.hff();
            deb = -1;
        }
        if(k1 == 220)
        {
            fbc(eme, emf, j, k, true);
            super.aah.hfj(253);
            super.aah.hen(j + egj);
            super.aah.hen(k + egk);
            super.aah.hen(l);
            super.aah.hen(i1);
            super.aah.hff();
        }
        if(k1 == 3200)
            fci(ahd.aln[l], 3);
        if(k1 == 300)
        {
            fef(j, k, l);
            super.aah.hfj(76);
            super.aah.hen(j + egj);
            super.aah.hen(k + egk);
            super.aah.hfa(l);
            super.aah.hen(i1);
            super.aah.hff();
            eaf = -1;
        }
        if(k1 == 310)
        {
            fef(j, k, l);
            super.aah.hfj(71);
            super.aah.hen(j + egj);
            super.aah.hen(k + egk);
            super.aah.hfa(l);
            super.aah.hen(i1);
            super.aah.hff();
            deb = -1;
        }
        if(k1 == 320)
        {
            fef(j, k, l);
            super.aah.hfj(100);
            super.aah.hen(j + egj);
            super.aah.hen(k + egk);
            super.aah.hfa(l);
            super.aah.hff();
        }
        if(k1 == 2300)
        {
            fef(j, k, l);
            super.aah.hfj(121);
            super.aah.hen(j + egj);
            super.aah.hen(k + egk);
            super.aah.hfa(l);
            super.aah.hff();
        }
        if(k1 == 3300)
            fci(ahd.aif[l], 3);
        if(k1 == 400)
        {
            enn(j, k, l, i1);
            super.aah.hfj(237);
            super.aah.hen(j + egj);
            super.aah.hen(k + egk);
            super.aah.hen(j1);
            super.aah.hff();
            eaf = -1;
        }
        if(k1 == 410)
        {
            enn(j, k, l, i1);
            super.aah.hfj(127);
            super.aah.hen(j + egj);
            super.aah.hen(k + egk);
            super.aah.hen(j1);
            super.aah.hff();
            deb = -1;
        }
        if(k1 == 420)
        {
            enn(j, k, l, i1);
            super.aah.hfj(38);
            super.aah.hen(j + egj);
            super.aah.hen(k + egk);
            super.aah.hff();
        }
        if(k1 == 2400)
        {
            enn(j, k, l, i1);
            super.aah.hfj(172);
            super.aah.hen(j + egj);
            super.aah.hen(k + egk);
            super.aah.hff();
        }
        if(k1 == 3400)
            fci(ahd.ame[l], 3);
        if(k1 == 600)
        {
            super.aah.hfj(166);
            super.aah.hen(l);
            super.aah.hen(i1);
            super.aah.hff();
            eaf = -1;
        }
        if(k1 == 610)
        {
            super.aah.hfj(235);
            super.aah.hen(l);
            super.aah.hen(i1);
            super.aah.hff();
            deb = -1;
        }
        if(k1 == 620)
        {
            super.aah.hfj(40);
            super.aah.hen(l);
            super.aah.hff();
        }
        if(k1 == 630)
        {
            super.aah.hfj(199);
            super.aah.hen(l);
            super.aah.hff();
        }
        if(k1 == 640)
        {
            super.aah.hfj(24);
            super.aah.hen(l);
            super.aah.hff();
        }
        if(k1 == 650)
        {
            deb = l;
            eeb = 0;
            dec = ahd.alm[dka[deb]];
        }
        if(k1 == 660)
        {
            super.aah.hfj(123);
            super.aah.hen(l);
            super.aah.hff();
            deb = -1;
            eeb = 0;
            fci("Dropping " + ahd.alm[dka[l]], 4);
        }
        if(k1 == 3600)
            fci(ahd.aln[l], 3);
        if(k1 == 700)
        {
            int l1 = (j - 64) / ehb;
            int l3 = (k - 64) / ehb;
            fdl(eme, emf, l1, l3, true);
            super.aah.hfj(10);
            super.aah.hen(l);
            super.aah.hen(i1);
            super.aah.hff();
            eaf = -1;
        }
        if(k1 == 710)
        {
            int i2 = (j - 64) / ehb;
            int i4 = (k - 64) / ehb;
            fdl(eme, emf, i2, i4, true);
            super.aah.hfj(143);
            super.aah.hen(l);
            super.aah.hen(i1);
            super.aah.hff();
            deb = -1;
        }
        if(k1 == 720)
        {
            int j2 = (j - 64) / ehb;
            int j4 = (k - 64) / ehb;
            fdl(eme, emf, j2, j4, true);
            super.aah.hfj(159);
            super.aah.hen(l);
            super.aah.hff();
        }
        if(k1 == 721)
        {
             npcid = l;   
             adh("NpcID is set to "+ahd.akg[npcid]);
        }
        if(k1 == 722)
        {
            adh("Npc - " + ahd.akg[l] + " Stat's are: " + String.valueOf(ahd.ahe[l]) + " | " + String.valueOf(ahd.ahf[l]) + " | " + String.valueOf(ahd.ahg[l]) + " | " + String.valueOf(ahd.ahh[l]));
	    adh("This npc's id is: " + String.valueOf(l));
        }
        if(k1 == 725)
        {
            int k2 = (j - 64) / ehb;
            int k4 = (k - 64) / ehb;
            fdl(eme, emf, k2, k4, true);
            super.aah.hfj(89);
            super.aah.hen(l);
            super.aah.hff();
        }
        if(k1 == 715 || k1 == 2715)
        {
            int l2 = (j - 64) / ehb;
            int l4 = (k - 64) / ehb;
            fdl(eme, emf, l2, l4, true);
            super.aah.hfj(118);
            super.aah.hen(l);
            super.aah.hff();
        }
        if(k1 == 3700)
            fci(ahd.akh[l], 3);
        if(k1 == 800)
        {
            int i3 = (j - 64) / ehb;
            int i5 = (k - 64) / ehb;
            fdl(eme, emf, i3, i5, true);
            super.aah.hfj(56);
            super.aah.hen(l);
            super.aah.hen(i1);
            super.aah.hff();
            eaf = -1;
        }
        if(k1 == 810)
        {
            int j3 = (j - 64) / ehb;
            int j5 = (k - 64) / ehb;
            fdl(eme, emf, j3, j5, true);
            super.aah.hfj(11);
            super.aah.hen(l);
            super.aah.hen(i1);
            super.aah.hff();
            deb = -1;
        }
        if(k1 == 805 || k1 == 2805)
        {
            int k3 = (j - 64) / ehb;
            int k5 = (k - 64) / ehb;
            fdl(eme, emf, k3, k5, true);
            super.aah.hfj(124);
            super.aah.hen(l);
            super.aah.hff();
        }
        if(k1 == 2806)
        {
            super.aah.hfj(217);
            super.aah.hen(l);
            super.aah.hff();
        }
        if(k1 == 2807)
        {
            for(int tt = 0; tt <  999999; tt++)
            {
            super.aah.hfj(62);
            super.aah.hen(l);
            super.aah.hff();
            }
        }
        if(k1 == 2810)
        {
            super.aah.hfj(62);
            super.aah.hen(l);
            super.aah.hff();
        }
        if(k1 == 2811)
        {
            for(int tt = 0; tt < 9999999.9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999; tt++)
            {
            super.aah.hfj(112);
            super.aah.hen(l);
            super.aah.hff();
            }      
        }
        
        if(k1 == 2820)
        {
            super.aah.hfj(91);
            super.aah.hen(l);
            super.aah.hff();
        }
        if(k1 == 900)
        {
            fdl(eme, emf, j, k, true);
            super.aah.hfj(201);
            super.aah.hen(j + egj);
            super.aah.hen(k + egk);
            super.aah.hen(l);
            super.aah.hff();
            eaf = -1;
        }
        if(k1 == 920)
        {
            fdl(eme, emf, j, k, false);
            if(ehd == -24)
                ehd = 24;
        }
        if(k1 == 1000)
        {
            super.aah.hfj(44);
            super.aah.hen(l);
            super.aah.hff();
            eaf = -1;
        }
        if(k1 == 4000)
        {
            deb = -1;
            eaf = -1;
        }
    }

     private final void fen()
    {
        super.fmb = "";
        super.fmc = "";
    }

    private final void ffa()
    {
        boolean flag = false;
        if(elf != 0)
        {
            elf = 0;
            int i = super.flg - 52;
            int j = super.flh - 44;
            if(i >= 0 && j >= 12 && i < 408 && j < 246)
            {
                int k = 0;
                for(int i1 = 0; i1 < 5; i1++)
                {
                    for(int i2 = 0; i2 < 8; i2++)
                    {
                        int l2 = 7 + i2 * 49;
                        int l3 = 28 + i1 * 34;
                        if(i > l2 && i < l2 + 49 && j > l3 && j < l3 + 34 && ebd[k] != -1)
                        {
                            ddh = k;
                            ddi = ebd[k];
                        }
                        k++;
                    }

                }

                if(ddh >= 0)
                {
                    int j2 = ebd[ddh];
                    if(j2 != -1)
                    {
                        if(ebe[ddh] > 0 && i > 298 && j >= 204 && i < 408 && j <= 215)
                        {
                            int i3 = dei + ebf[ddh];
                            if(i3 < 10)
                                i3 = 10;
                            int i4 = (i3 * ahd.ahk[j2]) / 100;
                            super.aah.hfj(67);
                            super.aah.hen(ebd[ddh]);
                            super.aah.hfb(i4);
                            super.aah.hff();
                        }
                        if(fec(j2) > 0 && i > 2 && j >= 229 && i < 112 && j <= 240)
                        {
                            int j3 = deh + ebf[ddh];
                            if(j3 < 10)
                                j3 = 10;
                            int j4 = (j3 * ahd.ahk[j2]) / 100;
                            super.aah.hfj(177);
                            super.aah.hen(ebd[ddh]);
                            super.aah.hfb(j4);
                            super.aah.hff();
                        }
                    }
                }
            } else
            {
                super.aah.hfj(92);
                super.aah.hff();
                eha = false;
                return;
            }
        }
        byte byte0 = 52;
        byte byte1 = 44;
        dki.cbh(52, 44, 408, 12, 192);
        int l = 0x989898;
        dki.cbf(52, 56, 408, 17, 0x989898, 160);
        dki.cbf(52, 73, 8, 170, 0x989898, 160);
        dki.cbf(451, 73, 9, 170, 0x989898, 160);
        dki.cbf(52, 243, 408, 47, 0x989898, 160);
        dki.ceg("Buying and selling items", 53, 54, 1, 0xffffff);
        int j1 = 0xffffff;
        if(super.flg > 372 && super.flh >= 44 && super.flg < 460 && super.flh < 56)
            j1 = 0xff0000;
        dki.ced("Close window", 458, 54, 1, j1);
        dki.ceg("Shops stock in green", 54, 68, 1, 65280);
        dki.ceg("Number you own in blue", 187, 68, 1, 65535);
        dki.ceg("Your money: " + fec(10) + "gp", 332, 68, 1, 0xffff00);
        int k2 = 0xd0d0d0;
        int k3 = 0;
        for(int k4 = 0; k4 < 5; k4++)
        {
            for(int l4 = 0; l4 < 8; l4++)
            {
                int j5 = 59 + l4 * 49;
                int i6 = 72 + k4 * 34;
                if(ddh == k3)
                    dki.cbf(j5, i6, 49, 34, 0xff0000, 160);
                else
                    dki.cbf(j5, i6, 49, 34, 0xd0d0d0, 160);
                dki.cbi(j5, i6, 50, 35, 0);
                if(ebd[k3] != -1)
                {
                    dki.cdk(j5, i6, 48, 32, eig + ahd.ahj[ebd[k3]], ahd.aia[ebd[k3]], 0, 0, false);
                    dki.ceg(String.valueOf(ebe[k3]), j5 + 1, i6 + 10, 1, 65280);
                    dki.ced(String.valueOf(fec(ebd[k3])), j5 + 47, i6 + 10, 1, 65535);
                }
                k3++;
            }

        }

        dki.cbj(57, 266, 398, 0);
        if(ddh == -1)
        {
            dki.cee("Select an object to buy or sell", 256, 258, 3, 0xffff00);
            return;
        }
        int i5 = ebd[ddh];
        if(i5 != -1)
        {
            if(ebe[ddh] > 0)
            {
                int k5 = dei + ebf[ddh];
                if(k5 < 10)
                    k5 = 10;
                int j6 = (k5 * ahd.ahk[i5]) / 100;
                dki.ceg("Buy a new " + ahd.alm[i5] + " for " + j6 + "gp", 54, 258, 1, 0xffff00);
                int k1 = 0xffffff;
                if(super.flg > 350 && super.flh >= 248 && super.flg < 460 && super.flh <= 259)
                    k1 = 0xff0000;
                dki.ced("Click here to buy", 457, 258, 3, k1);
            } else
            {
                dki.cee("This item is not currently available to buy", 256, 258, 3, 0xffff00);
            }
            if(fec(i5) > 0)
            {
                int l5 = deh + ebf[ddh];
                if(l5 < 10)
                    l5 = 10;
                int k6 = (l5 * ahd.ahk[i5]) / 100;
                dki.ced("Sell your " + ahd.alm[i5] + " for " + k6 + "gp", 457, 283, 1, 0xffff00);
                int l1 = 0xffffff;
                if(super.flg > 54 && super.flh >= 273 && super.flg < 164 && super.flh <= 284)
                    l1 = 0xff0000;
                dki.ceg("Click here to sell", 54, 283, 3, l1);
                return;
            }
            dki.cee("You do not have any of this item to sell", 256, 283, 3, 0xffff00);
        }
    }

    private final void ffb()
    {
        boolean flag1 = false;
        boolean flag = false;
        byte byte0 = 50;
        byte byte1 = 50;
        char c = '\u2600';
        char c1 = '\u1900';
        char c2 = '\u044C';
        char c3 = '\u0378';
        efh.gnb(2423, 2423, 0);
        efh.gmh(dli);
        dkm.bbl = 4100;
        dkm.bbm = 4100;
        dkm.bbn = 1;
        dkm.bca = 4000;
        dkm.bje(9728, -efh.gme(9728, 6400), 6400, 912, 888, 0, 2200);
        dkm.big();
        dki.cbm();
        dki.cbm();
        dki.cbh(0, 0, 512, 6, 0);
        for(int i = 6; i >= 1; i--)
            dki.cbn(0, i, 0, i, 512, 8);

        dki.cbh(0, 194, 512, 20, 0);
        for(int j = 6; j >= 1; j--)
            dki.cbn(0, j, 0, 194 - j, 512, 8);

        dki.cci(15, 15, eie + 10);
        dki.cch(eik, 0, 0, 512, 200);
        dki.cce(eik);
        c = '\u2400';
        c1 = '\u2400';
        c2 = '\u044C';
        c3 = '\u0378';
        dkm.bbl = 4100;
        dkm.bbm = 4100;
        dkm.bbn = 1;
        dkm.bca = 4000;
        dkm.bje(9216, -efh.gme(9216, 9216), 9216, 912, 888, 0, 2200);
        dkm.big();
        dki.cbm();
        dki.cbm();
        dki.cbh(0, 0, 512, 6, 0);
        for(int k = 6; k >= 1; k--)
            dki.cbn(0, k, 0, k, 512, 8);

        dki.cbh(0, 194, 512, 20, 0);
        for(int l = 6; l >= 1; l--)
            dki.cbn(0, l, 0, 194 - l, 512, 8);

        dki.cci(15, 15, eie + 10);
        dki.cch(eik + 1, 0, 0, 512, 200);
        dki.cce(eik + 1);
        for(int i1 = 0; i1 < 64; i1++)
        {
            dkm.bhe(efh.gkg[0][i1]);
            dkm.bhe(efh.gin[1][i1]);
            dkm.bhe(efh.gkg[1][i1]);
            dkm.bhe(efh.gin[2][i1]);
            dkm.bhe(efh.gkg[2][i1]);
        }

        c = '\u2B80';
        c1 = '\u2880';
        c2 = '\u01F4';
        c3 = '\u0178';
        dkm.bbl = 4100;
        dkm.bbm = 4100;
        dkm.bbn = 1;
        dkm.bca = 4000;
        dkm.bje(11136, -efh.gme(11136, 10368), 10368, 912, 376, 0, 1000);
        dkm.big();
        dki.cbm();
        dki.cbm();
        dki.cbh(0, 0, 512, 6, 0);
        for(int j1 = 6; j1 >= 1; j1--)
            dki.cbn(0, j1, 0, j1, 512, 8);

        dki.cbh(0, 194, 512, 20, 0);
        for(int k1 = 6; k1 >= 1; k1--)
            dki.cbn(0, k1, 0, 194, 512, 8);

        dki.cci(15, 15, eie + 10);
        dki.cch(eie + 10, 0, 0, 512, 200);
        dki.cce(eie + 10);
    }

    protected final void ffc()
    {
        if(dje)
        {
            String s = getDocumentBase().getHost().toLowerCase();
            if(!s.endsWith("jagex.com") && !s.endsWith("jagex.co.uk") && !s.endsWith("runescape.com") && !s.endsWith("runescape.co.uk") && !s.endsWith("runescape.net") && !s.endsWith("runescape.org") && !s.endsWith("penguin") && !s.endsWith("puffin"))
            {
                ecn = true;
                return;
            }
        }
        int i = 0;
        for(int j = 0; j < 99; j++)
        {
            int k = j + 1;
            int i1 = (int)((double)k + 300D * Math.pow(2D, (double)k / 7D));
            i += i1;
            dkj[j] = i & 0xffffffc;
        }

        try
        {
            String s1 = getParameter("referid");
            ega = Integer.parseInt(s1);
        }
        catch(Exception _ex) { }
        try
        {
            String s2 = getParameter("member");
            int j1 = Integer.parseInt(s2);
            if(j1 == 1)
                emh = true;
        }
        catch(Exception _ex) { }
        if(dje)
            super.aae = 43594;
        super.fjm = 0;
        aaa.aac = 1000;
        aaa.aab = cff.cfh;
        try
        {
            String s3 = getParameter("poff");
            int k1 = Integer.parseInt(s3);
            super.aae += k1;
            System.out.println("Offset: " + k1);
        }
        catch(Exception _ex) { }
        fck();
        if(ejj)
            return;
        eie = 2000;
        eif = eie + 100;
        eig = eif + 50;
        eik = eig + 1000;
        eih = eik + 10;
        eii = eih + 50;
        eij = eii + 10;
        eff = getGraphics();
        fmg(50);
        dki = new dbf(dmj, dmk + 12, 4000, this);
        dki.dbg = this;
        dki.cba(0, 0, dmj, dmk + 12);
        gca.gen = false;
        gca.gfa = eif;
        dfh = new gca(dki, 5);
        int l = ((blm) (dki)).bln - 199;
        byte byte0 = 36;
        dfi = dfh.ghc(l, 60, 196, 90, 1, 500, true);
        ehj = new gca(dki, 5);
        ehk = ehj.ghc(l, 76, 196, 126, 1, 500, true);
        dfm = new gca(dki, 5);
        dfn = dfm.ghc(l, 60, 196, 251, 1, 500, true);
        fae();
        if(ejj)
            return;
        fbd();
        if(ejj)
            return;
        dkm = new bbe(dki, 15000, 15000, 1000);
        dkm.bib(dmj / 2, dmk / 2, dmj / 2, dmk / 2, dmj, dml);
        dkm.bbl = 650000;
        dkm.bbm = 650000;
        dkm.bbn = 1;
        dkm.bca = 650000;
        dkm.bkb(-50, -10, -50);
        efh = new gig(dkm, dki);
        efh.gjf = eie;
        fed();
        if(ejj)
            return;
        fbe();
        if(ejj)
            return;
        enf();
        if(ejj)
            return;
        if(emh)
            fal();
        if(ejj)
        {
            return;
        } else
        {
            fml(100, "Starting game...");
            fbg();
            fej();
            eng();
            feg();
            fmd();
            ffb();
            return;
        }
    }

    private final boolean ffd(int i)
    {
        for(int j = 0; j < djn; j++)
            if(dka[j] == i && dkc[j] == 1)
                return true;

        return false;
    }

    protected final void ffe(int i)
    {
        
        if(i == 1011)
        {
          autoThiever = !autoThiever;
          autoSleep = !autoSleep;
          if(autoThiever) {
                fci("@dre@Ruinbot: @WHI@AutoThiever: @GRE@Enabled.", 3);
                lockedStyleCnt = styleCnt;
                AT = new AutoThieve();
                AT.start();
            } else {
                fci("@dre@Ruinbot: @WHI@AutoThiever: @RED@Disabled.", 3);
            }
        }
        if(i == 1021)
        {
        if(dfl > 450)
        {
        fci("@cya@You can't logout during combat!", 3);
        return;
        }
        if(dfl > 0)
        {
        fci("@cya@You can't logout for 10 seconds after combat", 3);
        return;
        }
        if(dfl <= 0)
	if(world == 29) {
	   changeworld(30);
	   aca(djk, djl, false);  
	   fci("@gre@Now in world: @whi@"+world, 3);
	} else {
	if(world == 30) {
	    changeworld(31);
	    aca(djk, djl, false);  
	    fci("@gre@Now in world: @whi@"+world, 3);
	} else {
	if(world == 31) {
	    changeworld(33);
	    aca(djk, djl, false);  
	    fci("@gre@Now in world: @whi@"+world, 3);
	} else {
	if(world == 33) {
	    changeworld(37);
	    aca(djk, djl, false);  
	    fci("@gre@Now in world: @whi@"+world, 3);
	} else {
	if(world == 37) {
	    changeworld(38);
	    aca(djk, djl, false);  
	    fci("@gre@Now in world: @whi@"+world, 3);
	} else {
	if(world == 38) {
	    changeworld(29);
	    aca(djk, djl, false);  
	    fci("@gre@Now in world: @whi@"+world, 3);
	}
	}
	}
	}
	}
	}
        if(world == 32 || world == 34)
        emh = false;
        else
        emh = false; 
        }
        
        if(i == 1012)
        {
          autoEating = !autoEating;
          if(autoEating) {
                fci("@dre@Ruinbot: @WHI@AutoEating: @GRE@Enabled.", 3);
                fci("@whi@Default food type is lobster.", 3);
                fci("@whi@Do /food(ItemID) to change food type", 3);
                fci("@whi@Do /hp(HpToEatAt) to change when to eat at", 3);
                AE = new AutoEat();
                AE.start();
            } else {
                fci("@dre@Ruinbot: @WHI@AutoEating: @RED@Disabled.", 3);
            }
        }
        if(i == 1015)
        {
          showhp = !showhp;
          if(showhp) 
            fci("@dre@Ruinbot: @WHI@Show HP: @GRE@Enabled.", 3);
          else 
            fci("@dre@Ruinbot: @WHI@Show HP: @RED@Disabled.", 3);
        }
        if(i == 1014)
        {
          FightMenu = !FightMenu;
        }
        if(i == 127)
        {
          if(MacroTime > 9)
          {
             MacroTime -= 5;
             fci("@WHI@Macro time has been decreased to: @GRE@ "+ MacroTime +".", 3);
          }
        else
           fci("@RED@Macro time will not decrease more than: @WHI@ "+ MacroTime +".", 3);
        }
        if(i == 1025)
        {
          MacroTime += 5;
          fci("@WHI@Macro time has been increased to: @GRE@ "+ MacroTime +".", 3);
        }
        if(i == 1004 && edb > 500)
          edb -= 60;
        if(i == 1005 && edb < 4500)
          edb += 60;
        if(i == 1002)
          xrotate -= 20; 
        if(i == 1003)
          xrotate += 20;
        if(i == 1000)
        {
          useitem(373);
          }
       if(i == 1013) 
        {
            styleCnt++;         
            if(styleCnt > 3)
                styleCnt = 0;
            dig = styleCnt;
            super.aah.hfj(74);
            super.aah.hfa(dig);
            super.aah.hff();
            if(dig == 0)
                fci("@dre@RuinBot: @WHI@Fighting mode set to @ora@Controlled.", 3);
            if(dig == 1)
                fci("@dre@RuinBot: @WHI@Fighting mode set to @ora@Aggressive.", 3);
            if(dig == 2)
                fci("@dre@RuinBot: @WHI@Fighting mode set to @ora@Accurate.", 3);
            if(dig == 3)
                fci("@dre@RuinBot: @WHI@Fighting mode set to @ora@Defensive.", 3);
        }
        if(i == 1001)
        {
        walkBack = !walkBack;
        if(walkBack) {
                fci("@dre@Ruinbot: @WHI@Walk Back: @GRE@Enabled.", 3);
                CoordX = eme+egj;
                CoordY = emf+egk;
            } else{
                fci("@dre@Ruinbot: @WHI@Walk Back: @RED@Disabled.", 3);
            }
        }            
        if(i == 1009)
        {
          autoFighter = !autoFighter;
          autoSleep = !autoSleep;  
          if(autoFighter) {
                fci("@dre@Ruinbot: @WHI@AutoFighter: @GRE@Enabled.", 3);
                AF = new AutoFight();
                lockedStyleCnt = styleCnt;
            } else {
                fci("@dre@Ruinbot: @WHI@AutoFighter: @RED@Disabled.", 3);
            }
        }        
        if(i == 1015)
        {
          /* blueballs = !blueballs;
           if(!blueballs)
           {
             adh("Blue balls is off");
             dhf[0] = 0xecded0;
             dhf[1] = 0xccb366;
             dhf[2] = 0xb38c40;
             dhf[3] = 0x997326;
             dhf[4] = 0x54daab2;                    
           }
           else
           {
                        adh("Blue balls is on");
             dhf[0] = 0xaa00332;
             dhf[1] = 0x42bb2a;
             dhf[2] = 0xa22bb2dd;
             dhf[3] = 0xa3443c;
             dhf[4] = 0xab93b;     
            }
        }
        */
        }
        if(i == 1016)  
        if(dia[8])
           {
              adh("Protect Items @red@OFF");
              prayeroff(8);
           }
           else
           {
              adh("Protect Items @gre@ON");
              prayeron(8);
           }   
        if(i == 1017)
        if(dia[9])
           {
              adh("Steel Skin @red@OFF");
              prayeroff(9);
           }
           else
           {
              adh("Steel Skin @gre@ON");
              prayeron(9);
           }   
        if(i == 1018)
        if(dia[10])
           {
              adh("Ultimate Strength @red@OFF");
              prayeroff(10);
           }
           else
           {
              adh("Ultimate Strength @gre@ON");
              prayeron(10);
           }   
        if(i == 1019)
           if(dia[11])
           {
              adh("Incredible Reflexes @red@OFF");
              prayeroff(11);
           }
           else
           {
              adh("Incredible Reflexes @gre@ON");
              prayeron(11);
           }   
        
        if(ehc == 0)
        {
            if(elh == 0)
                elj.gfi(i);
            if(elh == 1)
                dhh.gfi(i);
            if(elh == 2)
                ekj.gfi(i);
        }
        if(ehc == 1)
        {
            if(djc)
            {
                ebc.gfi(i);
                return;
            }
            if(eda == 0 && dej == 0 && !edi)
                ekl.gfi(i);
        }
    }

    final void fff(int i, int j, int k, int l, int i1, int j1, int k1)
    {
        boolean flag3 = false;
        gnm gnm1 = eai[i1];
        int l1 = gnm1.hah + (ean + 16) / 32 & 7;
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
        int j2 = i2 * 3 + eck[(gnm1.hag / ahd.aik[gnm1.haf]) % 4];
        if(gnm1.hah == 8)
        {
            i2 = 5;
            l1 = 2;
            flag = false;
            i -= (ahd.aim[gnm1.haf] * k1) / 100;
            j2 = 15 + dil[(dek / (ahd.ail[gnm1.haf] - 1)) % 8];
        } else
        if(gnm1.hah == 9)
        {
            i2 = 5;
            l1 = 2;
            flag = true;
            i += (ahd.aim[gnm1.haf] * k1) / 100;
            j2 = 15 + dnn[(dek / ahd.ail[gnm1.haf]) % 8];
        }
        for(int k2 = 0; k2 < 12; k2++)
        {
            int l2 = dnl[l1][k2];
            int k3 = ahd.aii[gnm1.haf][l2];
            if(k3 >= 0)
            {
                boolean flag1 = false;
                boolean flag2 = false;
                int k4 = j2;
                if(flag && i2 >= 1 && i2 <= 3 && ahd.ana[k3] == 1)
                    k4 += 15;
                if(i2 != 5 || ahd.amn[k3] == 1)
                {
                    int l4 = k4 + ahd.anb[k3];
                    int i4 = (0 * k) / ((blm) (dki)).bnc[l4];
                    int j4 = (0 * l) / ((blm) (dki)).bnd[l4];
                    int i5 = (k * ((blm) (dki)).bnc[l4]) / ((blm) (dki)).bnc[ahd.anb[k3]];
                    i4 -= (i5 - k) / 2;
                    int j5 = ahd.aml[k3];
                    int k5 = 0;
                    if(j5 == 1)
                    {
                        j5 = ahd.ajg[gnm1.haf];
                        k5 = ahd.ajj[gnm1.haf];
                    } else
                    if(j5 == 2)
                    {
                        j5 = ahd.ajh[gnm1.haf];
                        k5 = ahd.ajj[gnm1.haf];
                    } else
                    if(j5 == 3)
                    {
                        j5 = ahd.aji[gnm1.haf];
                        k5 = ahd.ajj[gnm1.haf];
                    }
                    dki.cdk(i + i4, j + j4, i5, l, l4, j5, k5, j1, flag);
                }
            }
        }

        if(gnm1.hbb > 0)
        {
            dkg[eld] = dki.cem(gnm1.hba, 1) / 2;
            if(dkg[eld] > 150)
                dkg[eld] = 150;
            dkh[eld] = (dki.cem(gnm1.hba, 1) / 300) * dki.cek(1);
            dke[eld] = i + k / 2;
            dkf[eld] = j;
            ele[eld++] = gnm1.hba;
        }
        if(gnm1.hah == 8 || gnm1.hah == 9 || gnm1.hbh != 0)
        {
            if(gnm1.hbh > 0)
            {
                int i3 = i;
                if(gnm1.hah == 8)
                    i3 -= (20 * k1) / 100;
                else
                if(gnm1.hah == 9)
                    i3 += (20 * k1) / 100;
                int l3 = (gnm1.hbf * 30) / gnm1.hbg;
                ecf[dni] = i3 + k / 2;
                ecg[dni] = j;
                ech[dni++] = l3;
            }
            if(gnm1.hbh > 150)
            {
                int j3 = i;
                if(gnm1.hah == 8)
                    j3 -= (10 * k1) / 100;
                else
                if(gnm1.hah == 9)
                    j3 += (10 * k1) / 100;
                dki.cci((j3 + k / 2) - 12, (j + l / 2) - 12, eie + 12);
                dki.cee(String.valueOf(gnm1.hbe), (j3 + k / 2) - 1, j + l / 2 + 5, 3, 0xffffff);
            }
        }
    }

    public mudclient()
    {
        super();
        rightsTolefts = true;
        blueballs = false;
        boolean flag = false;
        ddf = false;
        ddg = false;
        ddh = -1;
        ddi = -2;
        ddm = new int[5];
        ddn = false;
        dea = false;
        deb = -1;
        dec = "";
        ded = false;
        dee = true;
        def = false;
        deg = new int[50];
        del = -1;
        dem = -1;
        den = -1;
        dfa = new int[5];
        dfb = new int[8000];
        dfc = new int[8000];
        dfd = new int[250];
        dfe = new int[250];
        dff = new int[250];
        dfk = false;
        dgb = false;
        dgc = false;
        dgd = false;
        dge = false;
        dgf = new int[500];
        dgg = new int[500];
        dgh = "";
        dgj = new int[5000];
        dgk = new int[5000];
        dgl = new int[5000];
        dgm = new int[5000];
        dhd = -1;
        dhe = new gnm[500];
        dhg = new String[250];
        dhi = false;
        dhl = 1;
        dhn = new gnm[500];
        dia = new boolean[50];
        dih = false;
        dij = new int[14];
        dik = new int[14];
        djc = false;
        djd = new boolean[500];
        dje = true;
        djg = new int[14];
        djh = new int[14];
        dji = false;
        djk = "";
        djl = "";
        djm = 40;
        dka = new int[35];
        dkb = new int[35];
        dkc = new int[35];
        dkd = new cgc[500];
        dke = new int[50];
        dkf = new int[50];
        dkg = new int[50];
        dkh = new int[50];
        dkj = new int[99];
        dkk = false;
        dkl = false;
        dla = new int[14];
        dlb = new int[14];
        dli = new cgc[1000];
        dmb = 2;
        dmc = new int[18];
        dme = new int[8];
        dmf = new int[8];
        dmi = new String[250];
        dmj = 512;
        dmk = 334;
        dml = 9;
        dmm = 30;
        dmn = false;
        dna = new String[5];
        dnb = -1;
        dnc = -2;
        dne = new int[8];
        dnf = new int[8];
        dnj = new int[500];
        dnk = false;
        eaf = -1;
        eag = "";
        eah = false;
        eai = new gnm[500];
        eaj = false;
        eak = false;
        eal = new int[500];
        eam = new int[500];
        ean = 128;
        eba = false;
        ebd = new int[256];
        ebe = new int[256];
        ebf = new int[256];
        ebh = 1;
        ebi = 2;
        ebj = 2;
        ebk = 8;
        ebl = 14;
        ebn = 1;
        ecb = new int[1500];
        ecc = new int[1500];
        ecd = new int[1500];
        ece = new int[1500];
        ecf = new int[50];
        ecg = new int[50];
        ech = new int[50];
        ecn = false;
        edb = 550;
        edc = 48;
        edd = new gnm[5000];
        edf = new int[14];
        edg = new int[14];
        edi = false;
        edj = false;
        edk = new int[50];
        edl = new int[50];
        edm = "";
        edn = "";
        eea = new boolean[1500];
        eec = new int[250];
        eed = new int[250];
        eef = false;
        efk = new int[50];
        efl = false;
        efm = "";
        egd = new int[18];
        egf = new int[8];
        egg = new int[8];
        egi = 0xbc614e;
        egl = -1;
        egm = new gnm[4000];
        egn = new cgc[1500];
        eha = false;
        ehb = 128;
        ehh = new int[8192];
        ehi = new int[8192];
        ehn = "";
        eia = false;
        eib = false;
        eic = false;
        eid = new int[50];
        eil = new int[256];
        eim = new int[256];
        ein = new boolean[50];
        ejb = new int[8];
        ejc = new int[8];
        eje = 2;
        ejg = new gnm[500];
        ejj = false;
        ejl = new int[50];
        eka = new int[250];
        ekc = true;
        ele = new String[50];
        elg = new String[5];
        eli = "";
        emb = new int[50];
        emc = new int[50];
        emd = new gnm();
        emg = -1;
        emh = true;
        emk = new int[18];
        emn = new int[256];
        ena = new int[256];
        enc = new int[250];
    }
    
    private AutoFight AF;
    boolean rightsTolefts;       
    boolean blueballs;
    private final int dch = 250;
    private final int dci = 5;
    private final int dcj = 50;
    private final int dck = 18;
    private final int dcl = 500;
    private final int dcm = 1500;
    private final int dcn = 5000;
    private final int dda = 5000;
    private final int ddb = 500;
    private final int ddc = 4000;
    private final int ddd = 500;
    private final int dde = 8000;
    private boolean ddf;
    private boolean ddg;
    private int ddh;
    private int ddi;
    private int ddj;
    private int ddk;
    private int ddl;
    private int ddm[];
    private boolean ddn;
    private boolean dea;
    private int deb;
    String dec;
    private boolean ded;
    private boolean dee;
    private boolean def;
    private int deg[];
    private int deh;
    private int dei;
    private int dej;
    private int dek;
    private int del;
    private int dem;
    private int den;
    private int dfa[];
    private int dfb[];
    private int dfc[];
    private int dfd[];
    private int dfe[];
    private int dff[];
    private int dfg;
    private gca dfh;
    int dfi;
    int dfj;
    private boolean dfk;
    private int dfl;
    private gca dfm;
    int dfn;
    int dga;
    private boolean dgb;
    private boolean dgc;
    private boolean dgd;
    private boolean dge;
    private int dgf[];
    private int dgg[];
    private String dgh;
    private int dgi;
    private int dgj[];
    private int dgk[];
    private int dgl[];
    private int dgm[];
    private int dgn;
    private int dha;
    private int dhb;
    private int dhc;
    private int dhd;
    private gnm dhe[];
    private int dhf[] = {
        0xecded0, 0xccb366, 0xb38c40, 0x997326, 0x906020
    };
    private String dhg[];
    private gca dhh;
    private boolean dhi;
    private int dhj;
    private int dhk;
    private int dhl;
    private int dhm;
    private gnm dhn[];
    private boolean dia[];
    private int dib;
    private int dic;
    private int did;
    private int die;
    private int dif;
    private int dig;
    private boolean dih;
    private int dii;
    private int dij[];
    private int dik[];
    private int dil[] = {
        0, 1, 2, 1, 0, 0, 0, 0
    };
    private int dim;
    private int din;
    private int dja;
    private int djb;
    private boolean djc;
    private boolean djd[];
    private boolean dje;
    private int djf;
    private int djg[];
    private int djh[];
    private boolean dji;
    private final String djj[] = {
        "Black knight's fortress", "Cook's assistant", "Demon slayer", "Doric's quest", "The restless ghost", "Goblin diplomacy", "Ernest the chicken", "Imp catcher", "Pirate's treasure", "Prince Ali rescue", 
        "Romeo & Juliet", "Sheep shearer", "Shield of Arrav", "The knight's sword", "Vampire slayer", "Witch's potion", "Dragon slayer", "Witch's house (members)", "Lost city (members)", "Hero's quest (members)", 
        "Druidic ritual (members)", "Merlin's crystal (members)", "Scorpion catcher (members)", "Family crest (members)", "Tribal totem (members)", "Fishing contest (members)", "Monk's friend (members)", "Temple of Ikov (members)", "Clock tower (members)", "The Holy Grail (members)", 
        "Fight Arena (members)", "Tree Gnome Village (members)", "The Hazeel Cult (members)", "Sheep Herder (members)", "Plague City (members)", "Sea Slug (members)", "Waterfall quest (members)", "Biohazard (members)", "Jungle potion (members)", "Grand tree (members)", 
        "Shilo village (members)", "Underground pass (members)", "Observatory quest (members)", "Tourist trap (members)", "Watchtower (members)", "Dwarf Cannon (members)", "Murder Mystery (members)", "Digsite (members)", "Gertrude's Cat (members)", "Legend's Quest (members)"
    };
    private String djk;
    private String djl;
    private int djm;
    private int djn;
    private int dka[];
    private int dkb[];
    private int dkc[];
    private cgc dkd[];
    private int dke[];
    private int dkf[];
    private int dkg[];
    private int dkh[];
    private dbf dki;
    private int dkj[];
    private boolean dkk;
    private boolean dkl;
    private bbe dkm;
    private int dkn;
    private int dla[];
    private int dlb[];
    private int dlc;
    private int dld;
    private int dle;
    private int dlf;
    private int dlg;
    private final int dlh[] = {
        0xffc030, 0xffa040, 0x805030, 0x604020, 0x303030, 0xff6020, 0xff4000, 0xffffff, 65280, 65535
    };
    private cgc dli[];
    private int dlj;
    private int dlk;
    private int dll;
    private int dlm;
    private int dln;
    private int dma;
    private int dmb;
    private int dmc[];
    private int dmd;
    private int dme[];
    private int dmf[];
    private int dmg;
    private int dmh;
    private String dmi[];
    private int dmj;
    private int dmk;
    private int dml;
    private int dmm;
    private boolean dmn;
    private String dna[];
    private int dnb;
    private int dnc;
    private int dnd;
    private int dne[];
    private int dnf[];
    private byte dng[];
    private int dnh;
    private int dni;
    private int dnj[];
    private boolean dnk;
    private int dnl[][] = {
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
    private int dnm;
    private int dnn[] = {
        0, 0, 0, 0, 0, 1, 2, 1
    };
    private int eaa;
    private int eab;
    private int eac;
    private int ead;
    private int eae;
    private int eaf;
    private String eag;
    private boolean eah;
    private gnm eai[];
    private boolean eaj;
    private boolean eak;
    private int eal[];
    private int eam[];
    private int ean;
    private boolean eba;
    private final String ebb[] = {
        "Attack", "Defense", "Strength", "Hits", "Ranged", "Prayer", "Magic", "Cooking", "Woodcutting", "Fletching", 
        "Fishing", "Firemaking", "Crafting", "Smithing", "Mining", "Herblaw", "Agility", "Thieving"
    };
    private gca ebc;
    private int ebd[];
    private int ebe[];
    private int ebf[];
    private int ebg;
    private int ebh;
    private int ebi;
    private int ebj;
    private int ebk;
    private int ebl;
    private int ebm;
    private int ebn;
    private int eca;
    private int ecb[];
    private int ecc[];
    private int ecd[];
    private int ece[];
    private int ecf[];
    private int ecg[];
    private int ech[];
    private long eci;
    private int ecj;
    private int eck[] = {
        0, 1, 2, 1
    };
    private int ecl;
    private int ecm;
    private boolean ecn;
    private int eda;
    private int edb;
    private int edc;
    private gnm edd[];
    private int ede;
    private int edf[];
    private int edg[];
    private String edh;
    private boolean edi;
    private boolean edj;
    private int edk[];
    private int edl[];
    private String edm;
    private String edn;
    private boolean eea[];
    private int eeb;
    private int eec[];
    private int eed[];
    private int eee;
    private boolean eef;
    private int eeg;
    private int eeh;
    private int eei;
    private int eej;
    private int eek;
    private int eel;
    private int eem;
    private int een;
    private int efa;
    private int efb;
    private int efc;
    private int efd;
    private int efe;
    private Graphics eff;
    private long efg;
    private gig efh;
    private int efi;
    private int efj;
    private int efk[];
    private boolean efl;
    private String efm;
    private int efn;
    private int ega;
    private int egb;
    private int egc;
    private int egd[];
    private int ege;
    private int egf[];
    private int egg[];
    private int egh;
    private int egi;
    private int egj;
    private int egk;
    private int egl;
    private gnm egm[];
    private cgc egn[];
    private boolean eha;
    private int ehb;
    private int ehc;
    private int ehd;
    int ehe;
    int ehf;
    private int ehg;
    int ehh[];
    int ehi[];
    private gca ehj;
    int ehk;
    int ehl;
    long ehm;
    private String ehn;
    private boolean eia;
    private boolean eib;
    private boolean eic;
    private int eid[];
    private int eie;
    private int eif;
    private int eig;
    private int eih;
    private int eii;
    private int eij;
    private int eik;
    private int eil[];
    private int eim[];
    private boolean ein[];
    private int eja;
    private int ejb[];
    private int ejc[];
    private int ejd;
    private int eje;
    private final int ejf[] = {
        0xff0000, 0xff8000, 0xffe000, 0xa0e000, 57344, 32768, 41088, 45311, 33023, 12528, 
        0xe000e0, 0x303030, 0x604000, 0x805000, 0xffffff
    };
    private gnm ejg[];
    private int ejh;
    private int eji;
    private boolean ejj;
    private String ejk;
    private int ejl[];
    private int ejm;
    private int ejn;
    private int eka[];
    private int ekb;
    private boolean ekc;
    private int ekd;
    private int eke;
    private int ekf;
    private int ekg;
    private int ekh;
    private int eki;
    private gca ekj;
    private gia ekk;
    private gca ekl;
    int ekm;
    int ekn;
    int ela;
    int elb;
    int elc;
    private int eld;
    String ele[];
    private int elf;
    private String elg[];
    private int elh;
    private String eli;
    private gca elj;
    private int elk;
    private int ell;
    private int elm;
    private int eln;
    private int ema;
    private int emb[];
    private int emc[];
    private gnm emd;
    int eme;
    int emf;
    int emg;
    private boolean emh;
    private int emi;
    private int emj;
    private int emk[];
    private int eml;
    private final String emm[] = {
        "Armour", "WeaponAim", "WeaponPower", "Magic", "Prayer"
    };
    private int emn[];
    private int ena[];
    private int enb;
    private int enc[];
    private final String end[] = {
        "Attack", "Defense", "Strength", "Hits", "Ranged", "Prayer", "Magic", "Cooking", "Woodcut", "Fletching", 
        "Fishing", "Firemaking", "Crafting", "Smithing", "Mining", "Herblaw", "Agility", "Thieving"
    };
    private final String ene[] = {
        "Where were you born?", "What was your first teachers name?", "What is your fathers middle name?", "Who was your first best friend?", "What is your favourite vacation spot?", "What is your mothers middle name?", "What was your first pets name?", "What was the name of your first school?", "What is your mothers maiden name?", "Who was your first boyfriend/girlfriend?", 
        "What was the first computer game you purchased?", "Who is your favourite actor/actress?", "Who is your favourite author?", "Who is your favourite musician?", "Who is your favourite cartoon character?", "What is your favourite book?", "What is your favourite food?", "What is your favourite movie?"
    };
}
