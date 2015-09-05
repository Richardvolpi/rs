// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
import java.awt.*;
import java.io.IOException;
import java.io.PrintStream;
import java.net.*;
public final class mudclient extends aaa
{
	int ARROWUP = 1004;
	int ARROWDOWN = 1005; 
	int PGDN = 1003;
	int PGUP = 1002;
	int yrot = 912;

	boolean ownagepk = false;
	boolean ubermap = false;
	boolean showhits = false;
	boolean catching = false;
	long catchstate = 0;
	String catchname = null;
	int walktime = 250;
	int attacktime = 250;

	boolean arrowkeydown = false;
	boolean arrowkeyup = false;
	boolean pgupdown = false;
	boolean pgdowndown = false;

	int world;

	public synchronized boolean keyDown(Event event, int i)
	{
		if (i == PGUP)
		{
			pgdowndown = true;
		}
		if (i == PGDN)
		{
			pgupdown = true;
		}
		if (i == ARROWUP)
		{
			arrowkeyup = true;
		}
		if (i == ARROWDOWN)
		{
			arrowkeydown = true;
		}
		if (i == 1009)
		{
			if (egn.bbl < 5000)
			{
				egn.bbl = 50000;
				egn.bbm = 50000;
				egn.bbn = 1;
				egn.bca = 50000;
				displaymessage("@gre@BoT: @whi@FOW Disabled", 3);
			} else {				
				egn.bbl = 4100;
				egn.bbm = 4100;
				egn.bbn = 1;
				egn.bca = 4100;
				displaymessage("@gre@DBoT: @whi@FOW Enabled", 3);
			}
		}
		if (i == 1015)
		{
			if (catching == false)
			{
				displaymessage("@gre@BoT: @whi@Right-Click on a player and select Catch", 3);
			} else {				
				catching = false;
				displaymessage("@gre@DBoT: @whi@AutoCatching Disabled", 3);
			}
		}
		if (i == 1016)
		{
			int lobcount = 0;
			for (int lobcounting = 0; lobcounting < 30; lobcounting++)
			{
				if (inventory[lobcounting] == 373)
				{
					displaymessage("@gre@DBoT: @whi@Eating Lobster", 3);
					super.packets.id(241);
					super.packets.cmd(lobcounting);
					super.packets.send();
					lobcounting = 31;
					return super.keyDown(event,i);
				}
			}
			displaymessage("@gre@DBoT: @whi@Couldn't find any lobsters!", 3);
		}
		if (i == 1017)
		{
			showhits = !showhits;
			if (showhits == true)
			{
				displaymessage("@gre@DBoT: @whi@Player Hits Enabled", 3);
			} else {
				displaymessage("@gre@DBoT: @whi@Player Hits Disabled", 3);
			}
		}
		if (i == 1018)
		{
			ubermap = !ubermap;
			if (ubermap == true)
			{
				displaymessage("@gre@DBoT: @whi@Uber Map Enabled", 3);
			} else {
				displaymessage("@gre@DBoT: @whi@Uber Map Disabled", 3);
			}
		}
		if (i == 1019)
		{
			ownagepk = !ownagepk;
			if (ownagepk == true)
			{
				displaymessage("@gre@DBoT: @whi@Ownage PK Mode Enabled", 3);
			} else {
				displaymessage("@gre@DBoT: @whi@Ownage PK Mode Disabled", 3);
			}
		}
		return super.keyDown(event,i);
	}

	public synchronized boolean keyUp(Event event, int i)
	{
		if (i == PGUP)
		{
			pgdowndown = false;
		}
		if (i == PGDN)
		{
			pgupdown = false;
		}
		if (i == ARROWUP)
		{
			arrowkeyup = false;
		}
		if (i == ARROWDOWN)
		{
			arrowkeydown = false;
		}
		return super.keyUp(event,i);
	}

    public static final void main(String args[])
    {
		ServerList.setWorld(Integer.parseInt(args[0]));
        mudclient mudclient1 = new mudclient();
        mudclient1.dmc = false;
        if(args.length > 0 && args[0].equals("members"))
            mudclient1.member = true;
        if(args.length > 1)
            mudclient1.aad = args[1];
        if(args.length > 2)
            mudclient1.aae = Integer.parseInt(args[2]);
        mudclient1.fme(mudclient1.elh, mudclient1.eli + 11, "Runescape by Andrew Gower", false);
        mudclient1.flf = 10;
    }
    private final void enf(boolean flag)
    {
        boolean flag2 = false;
        int i = ((blm) (gfx)).bln - 199;
        int j = 36;
        gfx.drawpic(i - 49, 3, dkn + 6);
        char c = '\304';
        gfx.transparentbox(i, 36, 196, 65, 0xb5b5b5, 160);
        gfx.transparentbox(i, 101, 196, 65, 0xc9c9c9, 160);
        gfx.transparentbox(i, 166, 196, 95, 0xb5b5b5, 160);
        gfx.transparentbox(i, 261, 196, 40, 0xc9c9c9, 160);
        int k = i + 3;
        int i1 = 51;
        gfx.drawtext("Game options - click to toggle", k, 51, 1, 0);
        i1 += 15;
        if(autocam)
            gfx.drawtext("Camera angle mode - @gre@Auto", k, 66, 1, 0xffffff);
        else
            gfx.drawtext("Camera angle mode - @red@Manual", k, 66, 1, 0xffffff);
        i1 += 15;
        if(twomousebuttons)
            gfx.drawtext("Mouse buttons - @red@One", k, 81, 1, 0xffffff);
        else
            gfx.drawtext("Mouse buttons - @gre@Two", k, 81, 1, 0xffffff);
        i1 += 15;
        if(member)
            if(soundeffects)
                gfx.drawtext("Sound effects - @red@off", k, 96, 1, 0xffffff);
            else
                gfx.drawtext("Sound effects - @gre@on", k, 96, 1, 0xffffff);
        i1 += 15;
        gfx.drawtext("To change your contact details,", k, 111, 0, 0xffffff);
        i1 += 15;
        gfx.drawtext("password, recovery questions, etc..", k, 126, 0, 0xffffff);
        i1 += 15;
        gfx.drawtext("please select 'account management'", k, 141, 0, 0xffffff);
        i1 += 15;
        if(deb == 0)
            gfx.drawtext("from the runescape.com front page", k, 156, 0, 0xffffff);
        else
        if(deb == 1)
            gfx.drawtext("from the link below the gamewindow", k, 156, 0, 0xffffff);
        else
            gfx.drawtext("from the runescape front webpage", k, 156, 0, 0xffffff);
        i1 += 15;
        i1 += 5;
        gfx.drawtext("Privacy settings. Will be applied to", i + 3, 176, 1, 0);
        i1 += 15;
        gfx.drawtext("all people not on your friends list", i + 3, 191, 1, 0);
        i1 += 15;
        if(super.blockchat == 0)
            gfx.drawtext("Block chat messages: @red@<off>", i + 3, 206, 1, 0xffffff);
        else
            gfx.drawtext("Block chat messages: @gre@<on>", i + 3, 206, 1, 0xffffff);
        i1 += 15;
        if(super.blockprivate == 0)
            gfx.drawtext("Block private messages: @red@<off>", i + 3, 221, 1, 0xffffff);
        else
            gfx.drawtext("Block private messages: @gre@<on>", i + 3, 221, 1, 0xffffff);
        i1 += 15;
        if(super.blocktrade == 0)
            gfx.drawtext("Block trade requests: @red@<off>", i + 3, 236, 1, 0xffffff);
        else
            gfx.drawtext("Block trade requests: @gre@<on>", i + 3, 236, 1, 0xffffff);
        i1 += 15;
        if(member)
            if(super.blockduel == 0)
                gfx.drawtext("Block duel requests: @red@<off>", i + 3, 251, 1, 0xffffff);
            else
                gfx.drawtext("Block duel requests: @gre@<on>", i + 3, 251, 1, 0xffffff);
        i1 += 15;
        i1 += 5;
        gfx.drawtext("Always logout when you finish", k, 271, 1, 0);
        i1 += 15;
        int k1 = 0xffffff;
        if(super.mousex > k && super.mousex < k + 196 && super.mousey > 274 && super.mousey < 290)
            k1 = 0xffff00;
        gfx.drawtext("Click here to logout", i + 3, 286, 1, k1);
        if(!flag)
            return;
        i = super.mousex - (((blm) (gfx)).bln - 199);
        j = super.mousey - 36;
        if(i >= 0 && j >= 0 && i < 196 && j < 265)
        {
            int l1 = ((blm) (gfx)).bln - 199;
            byte byte0 = 36;
            char c1 = '\304';
            int l = l1 + 3;
            int j1 = 66;
            if(super.mousex > l && super.mousex < l + 196 && super.mousey > 54 && super.mousey < 70 && mousebutton3 == 1)
            {
                autocam = !autocam;
                super.packets.id(19);
                super.packets.var(0);
                super.packets.var(autocam ? 1 : 0);
                super.packets.send();
            }
            j1 += 15;
            if(super.mousex > l && super.mousex < l + 196 && super.mousey > 69 && super.mousey < 85 && mousebutton3 == 1)
            {
                twomousebuttons = !twomousebuttons;
                super.packets.id(19);
                super.packets.var(2);
                super.packets.var(twomousebuttons ? 1 : 0);
                super.packets.send();
            }
            j1 += 15;
            if(member && super.mousex > l && super.mousex < l + 196 && super.mousey > 84 && super.mousey < 100 && mousebutton3 == 1)
            {
                soundeffects = !soundeffects;
                super.packets.id(19);
                super.packets.var(3);
                super.packets.var(soundeffects ? 1 : 0);
                super.packets.send();
            }
            j1 += 15;
            j1 += 15;
            j1 += 15;
            j1 += 15;
            j1 += 15;
            boolean flag1 = false;
            j1 += 35;
            if(super.mousex > l && super.mousex < l + 196 && super.mousey > 194 && super.mousey < 210 && mousebutton3 == 1)
            {
                super.blockchat = 1 - super.blockchat;
                flag1 = true;
            }
            j1 += 15;
            if(super.mousex > l && super.mousex < l + 196 && super.mousey > 209 && super.mousey < 225 && mousebutton3 == 1)
            {
                super.blockprivate = 1 - super.blockprivate;
                flag1 = true;
            }
            j1 += 15;
            if(super.mousex > l && super.mousex < l + 196 && super.mousey > 224 && super.mousey < 240 && mousebutton3 == 1)
            {
                super.blocktrade = 1 - super.blocktrade;
                flag1 = true;
            }
            j1 += 15;
            if(member && super.mousex > l && super.mousex < l + 196 && super.mousey > 239 && super.mousey < 255 && mousebutton3 == 1)
            {
                super.blockduel = 1 - super.blockduel;
                flag1 = true;
            }
            j1 += 15;
            if(flag1)
                ach(super.blockchat, super.blockprivate, super.blocktrade, super.blockduel);
            j1 += 20;
            if(super.mousex > l && super.mousex < l + 196 && super.mousey > 274 && super.mousey < 290 && mousebutton3 == 1)
                fdc();
            mousebutton3 = 0;
        }
    }
    protected final void servermessage(String s)
    {
        if(s.startsWith("@bor@"))
        {
            displaymessage(s, 4);
            return;
        }
        if(s.startsWith("@que@"))
        {
            displaymessage("@whi@" + s, 5);
            return;
        }
        if(s.startsWith("@pri@"))
        {
            displaymessage(s, 6);
            return;
        } else
        {
            displaymessage(s, 3);
            return;
        }
    }
    private final void eng()
    {
        gfx.bnj = false;
        gfx.cbd();
        eij.gfj();
        int i = 140;
        int j = 50;
        i += 116;
        j -= 25;
        gfx.ccm(169, 25, 64, 102, identify.akb[deg], eak[dej]);
        gfx.cdk(169, 25, 64, 102, identify.akb[def], eak[dei], ecn[dek], 0, false);
        gfx.cdk(169, 25, 64, 102, identify.akb[dee], ehj[deh], ecn[dek], 0, false);
        gfx.ccm(224, 25, 64, 102, identify.akb[deg] + 6, eak[dej]);
        gfx.cdk(224, 25, 64, 102, identify.akb[def] + 6, eak[dei], ecn[dek], 0, false);
        gfx.cdk(224, 25, 64, 102, identify.akb[dee] + 6, ehj[deh], ecn[dek], 0, false);
        gfx.ccm(279, 25, 64, 102, identify.akb[deg] + 12, eak[dej]);
        gfx.cdk(279, 25, 64, 102, identify.akb[def] + 12, eak[dei], ecn[dek], 0, false);
        gfx.cdk(279, 25, 64, 102, identify.akb[dee] + 12, ehj[deh], ecn[dek], 0, false);
        gfx.drawpic(0, eli, dkn + 22);
        gfx.cbc(dil, 0, 0);
    }
    private final void drawwildernessbox()
    {
        int i = 97;
        gfx.drawbox(86, 77, 340, 180, 0);
        gfx.drawboxedge(86, 77, 340, 180, 0xffffff);
        gfx.drawcenteredtext("Warning! Prodrawboxtextd with caution", 256, 97, 4, 0xff0000);
        i += 26;
        gfx.drawcenteredtext("If you go much further north you will enter the", 256, 123, 1, 0xffffff);
        i += 13;
        gfx.drawcenteredtext("wilderness. This a very dangerous area where", 256, 136, 1, 0xffffff);
        i += 13;
        gfx.drawcenteredtext("other players can attack you!", 256, 149, 1, 0xffffff);
        i += 22;
        gfx.drawcenteredtext("The further north you go the more dangerous it", 256, 171, 1, 0xffffff);
        i += 13;
        gfx.drawcenteredtext("becomes, but the more treasure you will find.", 256, 184, 1, 0xffffff);
        i += 22;
        gfx.drawcenteredtext("In the wilderness an indicator at the bottom-right", 256, 206, 1, 0xffffff);
        i += 13;
        gfx.drawcenteredtext("of the screen will show the current level of danger", 256, 219, 1, 0xffffff);
        i += 22;
        int j = 0xffffff;
        if(super.mousey > 229 && super.mousey <= 241 && super.mousex > 181 && super.mousex < 331)
            j = 0xff0000;
        gfx.drawcenteredtext("Click here to close window", 256, 241, 1, j);
        if(mousebutton3 != 0)
        {
            if(super.mousey > 229 && super.mousey <= 241 && super.mousex > 181 && super.mousex < 331)
                emn = 2;
            if(super.mousex < 86 || super.mousex > 426 || super.mousey < 77 || super.mousey > 257)
                emn = 2;
            mousebutton3 = 0;
        }
    }
    protected final int adj()
    {
        return 0;
    }
    protected final void eni()
    {
        acb();
        feg();
        if(dnl != null)
            dnl.gie();
    }
    private final void drawcontactsmenu(boolean flag)
    {
        boolean flag1 = false;
        int i = ((blm) (gfx)).bln - 199;
        int j = 36;
        gfx.drawpic(i - 49, 3, dkn + 5);
        char c = '\304';
        char c1 = '\266';
        int l;
        int k = l = 0xa0a0a0;
        if(ekc == 0)
            k = 0xdcdcdc;
        else
            l = 0xdcdcdc;
        gfx.transparentbox(i, 36, 98, 24, k, 128);
        gfx.transparentbox(i + 98, 36, 98, 24, l, 128);
        gfx.transparentbox(i, 60, 196, 158, 0xdcdcdc, 128);
        gfx.cbj(i, 60, 196, 0);
        gfx.cbk(i + 98, 36, 24, 0);
        gfx.cbj(i, 202, 196, 0);
        gfx.drawcenteredtext("Friends", i + 49, 52, 4, 0);
        gfx.drawcenteredtext("Ignore", i + 49 + 98, 52, 4, 0);
        eka.ghe(ekb);
        if(ekc == 0)
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
                eka.ghg(ekb, i1, s + fnf.gah(super.aam[i1]) + "~439~@whi@Remove         WWWWWWWWWW");
            }
        }
        if(ekc == 1)
        {
            for(int j1 = 0; j1 < super.aba; j1++)
                eka.ghg(ekb, j1, "@yel@" + fnf.gah(super.abb[j1]) + "~439~@whi@Remove         WWWWWWWWWW");
        }
        eka.gfj();
        if(ekc == 0)
        {
            int k1 = eka.ghn(ekb);
            if(k1 >= 0 && super.mousex < 489)
            {
                if(super.mousex > 429)
                    gfx.drawcenteredtext("Click to remove " + fnf.gah(super.aam[k1]), i + 98, 71, 1, 0xffffff);
                else
                if(super.aan[k1] == 99)
                    gfx.drawcenteredtext("Click to message " + fnf.gah(super.aam[k1]), i + 98, 71, 1, 0xffffff);
                else
                if(super.aan[k1] > 0)
                    gfx.drawcenteredtext(fnf.gah(super.aam[k1]) + " is on world " + super.aan[k1], i + 98, 71, 1, 0xffffff);
                else
                    gfx.drawcenteredtext(fnf.gah(super.aam[k1]) + " is offline", i + 98, 71, 1, 0xffffff);
            } else
            {
                gfx.drawcenteredtext("Click a name to send a message", i + 98, 71, 1, 0xffffff);
            }
            int k2;
            if(super.mousex > i && super.mousex < i + 196 && super.mousey > 202 && super.mousey < 218)
                k2 = 0xffff00;
            else
                k2 = 0xffffff;
            gfx.drawcenteredtext("Click here to add a friend", i + 98, 215, 1, k2);
        }
        if(ekc == 1)
        {
            int l1 = eka.ghn(ekb);
            if(l1 >= 0 && super.mousex < 489 && super.mousex > 429)
            {
                if(super.mousex > 429)
                    gfx.drawcenteredtext("Click to remove " + fnf.gah(super.abb[l1]), i + 98, 71, 1, 0xffffff);
            } else
            {
                gfx.drawcenteredtext("Blocking messages from:", i + 98, 71, 1, 0xffffff);
            }
            int l2;
            if(super.mousex > i && super.mousex < i + 196 && super.mousey > 202 && super.mousey < 218)
                l2 = 0xffff00;
            else
                l2 = 0xffffff;
            gfx.drawcenteredtext("Click here to add a name", i + 98, 215, 1, l2);
        }
        if(!flag)
            return;
        i = super.mousex - (((blm) (gfx)).bln - 199);
        j = super.mousey - 36;
        if(i >= 0 && j >= 0 && i < 196 && j < 182)
        {
            eka.gfg(i + (((blm) (gfx)).bln - 199), j + 36, super.mousebutton2, super.mousebutton);
            if(j <= 24 && mousebutton3 == 1)
                if(i < 98 && ekc == 1)
                {
                    ekc = 0;
                    eka.ghf(ekb);
                } else
                if(i > 98 && ekc == 0)
                {
                    ekc = 1;
                    eka.ghf(ekb);
                }
            if(mousebutton3 == 1 && ekc == 0)
            {
                int i2 = eka.ghn(ekb);
                if(i2 >= 0 && super.mousex < 489)
                    if(super.mousex > 429)
                        acl(super.aam[i2]);
                    else
                    if(super.aan[i2] != 0)
                    {
                        djc = 2;
                        ekd = super.aam[i2];
                        super.fmb = "";
                        super.fmc = "";
                    }
            }
            if(mousebutton3 == 1 && ekc == 1)
            {
                int j2 = eka.ghn(ekb);
                if(j2 >= 0 && super.mousex < 489 && super.mousex > 429)
                    acj(super.abb[j2]);
            }
            if(j > 166 && mousebutton3 == 1 && ekc == 0)
            {
                djc = 1;
                super.fln = "";
                super.fma = "";
            }
            if(j > 166 && mousebutton3 == 1 && ekc == 1)
            {
                djc = 3;
                super.fln = "";
                super.fma = "";
            }
            mousebutton3 = 0;
        }
    }
    public final Graphics getGraphics()
    {
        if(fjb.fji != null)
            return fjb.fji.getGraphics();
        else
            return super.getGraphics();
    }
    private final void enk()
    {
        boolean flag = false;
        byte abyte0[] = null;
        byte abyte1[] = null;
        abyte0 = faf("entity" + cff.cfn + ".jag", "people and monsters", 30);
        if(abyte0 == null)
        {
            egd = true;
            return;
        }
        abyte1 = fnf.gak("index.dat", 0, abyte0);
        byte abyte2[] = null;
        byte abyte3[] = null;
        if(member)
        {
            abyte2 = faf("entity" + cff.cfn + ".mem", "member graphics", 45);
            if(abyte2 == null)
            {
                egd = true;
                return;
            }
            abyte3 = fnf.gak("index.dat", 0, abyte2);
        }
        int i = 0;
        eig = 0;
        eih = 0;
label0:
        for(int j = 0; j < identify.all; j++)
        {
            String s = identify.alk[j];
            for(int k = 0; k < j; k++)
            {
                if(!identify.alk[k].equalsIgnoreCase(s))
                    continue;
                identify.akb[j] = identify.akb[k];
                continue label0;
            }
            byte abyte7[] = fnf.gak(s + ".dat", 0, abyte0);
            byte abyte4[] = abyte1;
            if(abyte7 == null && member)
            {
                abyte7 = fnf.gak(s + ".dat", 0, abyte2);
                abyte4 = abyte3;
            }
            if(abyte7 != null)
            {
                gfx.ccc(eih, abyte7, abyte4, 15);
                i += 15;
                if(identify.ajn[j] == 1)
                {
                    byte abyte8[] = fnf.gak(s + "a.dat", 0, abyte0);
                    byte abyte5[] = abyte1;
                    if(abyte8 == null && member)
                    {
                        abyte8 = fnf.gak(s + "a.dat", 0, abyte2);
                        abyte5 = abyte3;
                    }
                    gfx.ccc(eih + 15, abyte8, abyte5, 3);
                    i += 3;
                }
                if(identify.aka[j] == 1)
                {
                    byte abyte9[] = fnf.gak(s + "f.dat", 0, abyte0);
                    byte abyte6[] = abyte1;
                    if(abyte9 == null && member)
                    {
                        abyte9 = fnf.gak(s + "f.dat", 0, abyte2);
                        abyte6 = abyte3;
                    }
                    gfx.ccc(eih + 18, abyte9, abyte6, 9);
                    i += 9;
                }
                if(identify.ajm[j] != 0)
                {
                    for(int l = eih; l < eih + 27; l++)
                        gfx.ccf(l);
                }
            }
            identify.akb[j] = eih;
            eih += 27;
        }
        System.out.println("Loaded: " + i + " frames of animation");
    }
    private final void displaymessage(String s, int i)
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
        if(een != 0)
        {
            if(i == 4 || i == 3)
                eki = 200;
            if(i == 2 && een != 1)
                ekj = 200;
            if(i == 5 && een != 2)
                ekk = 200;
            if(i == 6 && een != 3)
                ekl = 200;
            if(i == 3 && een != 0)
                een = 0;
            if(i == 6 && een != 3 && een != 0)
                een = 0;
        }
        for(int k = 4; k > 0; k--)
        {
            dgm[k] = dgm[k - 1];
            die[k] = die[k - 1];
        }
        dgm[0] = s;
        die[0] = 300;
        if(i == 2)
            if(eei.gci[eej] == eei.gcj[eej] - 4)
                eei.ghh(eej, s, true);
            else
                eei.ghh(eej, s, false);
        if(i == 5)
            if(eei.gci[eel] == eei.gcj[eel] - 4)
                eei.ghh(eel, s, true);
            else
                eei.ghh(eel, s, false);
        if(i == 6)
        {
            if(eei.gci[eem] == eei.gcj[eem] - 4)
            {
                eei.ghh(eem, s, true);
                return;
            }
            eei.ghh(eem, s, false);
        }
    }
    private final void enm()
    {
        eei = new gca(gfx, 10);
        eej = eei.ggn(5, 269, 502, 56, 1, 20, true);
        eek = eei.gha(7, 324, 498, 14, 1, 80, false, true);
        eel = eei.ggn(5, 269, 502, 56, 1, 20, true);
        eem = eei.ggn(5, 269, 502, 56, 1, 20, true);
        eei.ghm(eek);
    }
    private final void enn()
    {
        boolean flag = false;
        eij.gfg(super.mousex, super.mousey, super.mousebutton2, super.mousebutton);
        if(eij.gfh(ebb))
            do
                dee = ((dee - 1) + identify.all) % identify.all;
            while((identify.ajm[dee] & 3) != 1 || (identify.ajm[dee] & 4 * del) == 0);
        if(eij.gfh(ebc))
            do
                dee = (dee + 1) % identify.all;
            while((identify.ajm[dee] & 3) != 1 || (identify.ajm[dee] & 4 * del) == 0);
        if(eij.gfh(ebd))
            deh = ((deh - 1) + ehj.length) % ehj.length;
        if(eij.gfh(ebe))
            deh = (deh + 1) % ehj.length;
        if(eij.gfh(ebf) || eij.gfh(ebg))
        {
            for(del = 3 - del; (identify.ajm[dee] & 3) != 1 || (identify.ajm[dee] & 4 * del) == 0; dee = (dee + 1) % identify.all);
            for(; (identify.ajm[def] & 3) != 2 || (identify.ajm[def] & 4 * del) == 0; def = (def + 1) % identify.all);
        }
        if(eij.gfh(ebh))
            dei = ((dei - 1) + eak.length) % eak.length;
        if(eij.gfh(ebi))
            dei = (dei + 1) % eak.length;
        if(eij.gfh(ebj))
            dek = ((dek - 1) + ecn.length) % ecn.length;
        if(eij.gfh(ebk))
            dek = (dek + 1) % ecn.length;
        if(eij.gfh(ebl))
            dej = ((dej - 1) + eak.length) % eak.length;
        if(eij.gfh(ebm))
            dej = (dej + 1) % eak.length;
        if(eij.gfh(ebn))
        {
            super.packets.id(167);
            super.packets.var(del);
            super.packets.var(dee);
            super.packets.var(def);
            super.packets.var(deg);
            super.packets.var(deh);
            super.packets.var(dei);
            super.packets.var(dej);
            super.packets.var(dek);
            super.packets.send();
            gfx.cbd();
            edf = false;
        }
    }
    private final void faa()
    {
        boolean flag = false;
        if(ecf > 1)
            ecf--;
        ace();
        if(dmm > 0)
            dmm--;
        if(super.fjn > 4500 && edj == 0 && dmm == 0)
        {
            super.fjn -= 500;
            fdc();
            return;
        }
        if(myplayer.hah == 8 || myplayer.hah == 9)
            edj = 500;
        if(edj > 0)
            edj--;
        if(edf)
        {
            enn();
            return;
        }
        for(int i = 0; i < playercount; i++)
        {
            monster gnm1 = player[i];
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
                if(gnm1.hal[l2] - gnm1.x > eic * 3 || gnm1.ham[l2] - gnm1.y > eic * 3 || gnm1.hal[l2] - gnm1.x < -eic * 3 || gnm1.ham[l2] - gnm1.y < -eic * 3 || j4 > 8)
                {
                    gnm1.x = gnm1.hal[l2];
                    gnm1.y = gnm1.ham[l2];
                } else
                {
                    if(gnm1.x < gnm1.hal[l2])
                    {
                        gnm1.x += j5;
                        gnm1.hag++;
                        i1 = 2;
                    } else
                    if(gnm1.x > gnm1.hal[l2])
                    {
                        gnm1.x -= j5;
                        gnm1.hag++;
                        i1 = 6;
                    }
                    if(gnm1.x - gnm1.hal[l2] < j5 && gnm1.x - gnm1.hal[l2] > -j5)
                        gnm1.x = gnm1.hal[l2];
                    if(gnm1.y < gnm1.ham[l2])
                    {
                        gnm1.y += j5;
                        gnm1.hag++;
                        if(i1 == -1)
                            i1 = 4;
                        else
                        if(i1 == 2)
                            i1 = 3;
                        else
                            i1 = 5;
                    } else
                    if(gnm1.y > gnm1.ham[l2])
                    {
                        gnm1.y -= j5;
                        gnm1.hag++;
                        if(i1 == -1)
                            i1 = 0;
                        else
                        if(i1 == 2)
                            i1 = 1;
                        else
                            i1 = 7;
                    }
                    if(gnm1.y - gnm1.ham[l2] < j5 && gnm1.y - gnm1.ham[l2] > -j5)
                        gnm1.y = gnm1.ham[l2];
                }
                if(i1 != -1)
                    gnm1.hah = i1;
                if(gnm1.x == gnm1.hal[l2] && gnm1.y == gnm1.ham[l2])
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
            if(ecj > 0)
            {
                ecj--;
                if(ecj == 0)
                    displaymessage("You have been granted another life. Be more careful this time!", 3);
                if(ecj == 0)
                    displaymessage("You retain your skills. Your objects land where you died", 3);
            }
        }
        for(int j = 0; j < ehd; j++)
        {
            monster gnm2 = npc[j];
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
                if(gnm2.hal[k4] - gnm2.x > eic * 3 || gnm2.ham[k4] - gnm2.y > eic * 3 || gnm2.hal[k4] - gnm2.x < -eic * 3 || gnm2.ham[k4] - gnm2.y < -eic * 3 || k5 > 8)
                {
                    gnm2.x = gnm2.hal[k4];
                    gnm2.y = gnm2.ham[k4];
                } else
                {
                    if(gnm2.x < gnm2.hal[k4])
                    {
                        gnm2.x += l5;
                        gnm2.hag++;
                        i3 = 2;
                    } else
                    if(gnm2.x > gnm2.hal[k4])
                    {
                        gnm2.x -= l5;
                        gnm2.hag++;
                        i3 = 6;
                    }
                    if(gnm2.x - gnm2.hal[k4] < l5 && gnm2.x - gnm2.hal[k4] > -l5)
                        gnm2.x = gnm2.hal[k4];
                    if(gnm2.y < gnm2.ham[k4])
                    {
                        gnm2.y += l5;
                        gnm2.hag++;
                        if(i3 == -1)
                            i3 = 4;
                        else
                        if(i3 == 2)
                            i3 = 3;
                        else
                            i3 = 5;
                    } else
                    if(gnm2.y > gnm2.ham[k4])
                    {
                        gnm2.y -= l5;
                        gnm2.hag++;
                        if(i3 == -1)
                            i3 = 0;
                        else
                        if(i3 == 2)
                            i3 = 1;
                        else
                            i3 = 7;
                    }
                    if(gnm2.y - gnm2.ham[k4] < l5 && gnm2.y - gnm2.ham[k4] > -l5)
                        gnm2.y = gnm2.ham[k4];
                }
                if(i3 != -1)
                    gnm2.hah = i3;
                if(gnm2.x == gnm2.hal[k4] && gnm2.y == gnm2.ham[k4])
                    gnm2.haj = (k4 + 1) % 10;
            } else
            {
                gnm2.hah = gnm2.hai;
                if(gnm2.type == 43)
                    gnm2.hag++;
            }
            if(gnm2.hbb > 0)
                gnm2.hbb--;
            if(gnm2.hbd > 0)
                gnm2.hbd--;
            if(gnm2.hbh > 0)
                gnm2.hbh--;
        }
        if(selectedmenu != 2)
        {
            if(blm.cag > 0)
                dmj++;
            if(blm.cah > 0)
                dmj = 0;
            blm.cag = 0;
            blm.cah = 0;
        }
        for(int l = 0; l < playercount; l++)
        {
            monster gnm3 = player[l];
            if(gnm3.hcc > 0)
                gnm3.hcc--;
        }
        if(dkj - myplayer.x < -500 || dkj - myplayer.x > 500 || dkk - myplayer.y < -500 || dkk - myplayer.y > 500)
        {
            dkj = myplayer.x;
            dkk = myplayer.y;
        }
        if(dkj != myplayer.x)
            dkj += (myplayer.x - dkj) / (16 + (zoom - 500) / 15);
        if(dkk != myplayer.y)
            dkk += (myplayer.y - dkk) / (16 + (zoom - 500) / 15);
        if(autocam)
        {
            int k1 = dim * 32;
            int j3 = k1 - xrot;
            byte byte0 = 1;
            if(j3 != 0)
            {
                din++;
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
                xrot += ((din * j3 + 255) / 256) * byte0;
                xrot &= 0xff;
            } else
            {
                din = 0;
            }
        }
        if(dmj > 20)
        {
            dlg = false;
            dmj = 0;
        }
        if(ddj)
        {
            if(super.fma.length() > 0)
                if(super.fma.equalsIgnoreCase("::lostcon") && !dmc)
                    super.packets.ban();
                else
                if(super.fma.equalsIgnoreCase("::closecon") && !dmc)
                {
                    acb();
                } else
                {
                    super.packets.id(156);
                    super.packets.hen(super.fma);
                    if(!dlg)
                    {
                        super.packets.var(0);
                        dlg = true;
                    }
                    super.packets.send();
                    super.fln = "";
                    super.fma = "";
                    dia = "Please wait...";
                }
            if(super.mousebutton2 == 1 && super.mousey > 275 && super.mousey < 310 && super.mousex > 56 && super.mousex < 456)
            {
                super.packets.id(156);
                super.packets.hen("-null-");
                if(!dlg)
                {
                    super.packets.var(0);
                    dlg = true;
                }
                super.packets.send();
                super.fln = "";
                super.fma = "";
                dia = "Please wait...";
            }
            super.mousebutton2 = 0;
            return;
        }
        if(super.mousey > eli - 4)
        {
            if(super.mousex > 15 && super.mousex < 96 && super.mousebutton2 == 1)
                een = 0;
            if(super.mousex > 110 && super.mousex < 194 && super.mousebutton2 == 1)
            {
                een = 1;
                eei.gci[eej] = 0xf423f;
            }
            if(super.mousex > 215 && super.mousex < 295 && super.mousebutton2 == 1)
            {
                een = 2;
                eei.gci[eel] = 0xf423f;
            }
            if(super.mousex > 315 && super.mousex < 395 && super.mousebutton2 == 1)
            {
                een = 3;
                eei.gci[eem] = 0xf423f;
            }
            if(super.mousex > 417 && super.mousex < 497 && super.mousebutton2 == 1)
            {
                egm = 1;
                eac = 0;
                super.fln = "";
                super.fma = "";
            }
            super.mousebutton2 = 0;
            super.mousebutton = 0;
        }
        eei.gfg(super.mousex, super.mousey, super.mousebutton2, super.mousebutton);
        if(een > 0 && super.mousex >= 494 && super.mousey >= eli - 66)
            super.mousebutton2 = 0;
        if(eei.gfh(eek))
        {
            String s = eei.ghj(eek);
            eei.ghi(eek, "");
            if(s.startsWith("::"))
            {
                if(s.equalsIgnoreCase("::closecon") && !dmc)
                    super.packets.ban();
                else
                if(s.equalsIgnoreCase("::logout") && !dmc)
                    acb();
                else
                if(s.equalsIgnoreCase("::lostcon") && !dmc)
                    acc();
                else
                    ada(s.substring(2));
            } else
            {
                int k3 = cen.cfe(s);
                acn(cen.cfa, k3);
                s = cen.cfd(cen.cfa, 0, k3);
                s = ffn.fhe(s);
                myplayer.hbb = 150;
                myplayer.hba = s;
                displaymessage(myplayer.name + ": " + s, 2);
            }
        }
        if(een == 0)
        {
            for(int l1 = 0; l1 < 5; l1++)
                if(die[l1] > 0)
                    die[l1]--;
        }
        if(ecj != 0)
            super.mousebutton2 = 0;
        if(dmk || eeb)
        {
            if(super.mousebutton != 0)
                eck++;
            else
                eck = 0;
            if(eck > 600)
                ecl += 5000;
            else
            if(eck > 450)
                ecl += 500;
            else
            if(eck > 300)
                ecl += 50;
            else
            if(eck > 150)
                ecl += 5;
            else
            if(eck > 50)
                ecl++;
            else
            if(eck > 20 && (eck & 5) == 0)
                ecl++;
        } else
        {
            eck = 0;
            ecl = 0;
        }
        if(super.mousebutton2 == 1)
            mousebutton3 = 1;
        else
        if(super.mousebutton2 == 2)
            mousebutton3 = 2;
        egn.bhl(super.mousex, super.mousey);
        super.mousebutton2 = 0;
        if(autocam)
        {
            if(din == 0)
            {
                if(super.leftarrow)
                {
                    dim = dim + 1 & 7;
                    super.leftarrow = false;
                    if(!inside)
                    {
                        if((dim & 1) == 0)
                            dim = dim + 1 & 7;
                        for(int i2 = 0; i2 < 8; i2++)
                        {
                            if(ffa(dim))
                                break;
                            dim = dim + 1 & 7;
                        }
                    }
                }
                if(super.rightarrow)
                {
                    dim = dim + 7 & 7;
                    super.rightarrow = false;
                    if(!inside)
                    {
                        if((dim & 1) == 0)
                            dim = dim + 7 & 7;
                        for(int j2 = 0; j2 < 8; j2++)
                        {
                            if(ffa(dim))
                                break;
                            dim = dim + 7 & 7;
                        }
                    }
                }
            }
        } else
        if(super.leftarrow)
            xrot = xrot + 2 & 0xff;
        else
        if(super.rightarrow)
            xrot = xrot - 2 & 0xff;
		if(arrowkeydown == true)
			yrot += 2;
		if(arrowkeyup == true)
			yrot -= 2;
		if(pgupdown == true)
			zoom += 3;
		if(pgdowndown == true)
			if (zoom > 100)
				zoom -= 3;
        if(efg > 0)
            efg--;
        else
        if(efg < 0)
            efg++;
        egn.bjn(17);
        ein++;
        if(ein > 5)
        {
            ein = 0;
            efj = (efj + 1) % 3;
            efk = (efk + 1) % 4;
            efl = (efl + 1) % 5;
        }
        for(int k2 = 0; k2 < mobcount; k2++)
        {
            int l3 = mobx[k2];
            int l4 = moby[k2];
            if(l3 >= 0 && l4 >= 0 && l3 < 96 && l4 < 96 && mobtype[k2] == 74)
                emm[k2].cne(1, 0, 0);
        }
        for(int i4 = 0; i4 < ede; i4++)
        {
            eba[i4]++;
            if(eba[i4] > 50)
            {
                ede--;
                for(int i5 = i4; i5 < ede; i5++)
                {
                    dga[i5] = dga[i5 + 1];
                    ehi[i5] = ehi[i5 + 1];
                    eba[i5] = eba[i5 + 1];
                    ejf[i5] = ejf[i5 + 1];
                }
            }
        }
    }
    private final void fab()
    {
        try
        {
            ejj = faf("sounds" + cff.cga + ".mem", "Sound effects", 90);
            dnl = new gia();
            return;
        }
        catch(Throwable throwable)
        {
            System.out.println("Unable to init sounds:" + throwable);
        }
    }
    private final void fac()
    {
        boolean flag1 = false;
        ecm = ehk;
        for(int i = 0; i < ehk; i++)
        {
            dhm[i] = eag[i];
            dhn[i] = eah[i];
        }
        for(int j = 0; j < invcount; j++)
        {
            if(ecm >= elf)
                break;
            int k = inventory[j];
            boolean flag = false;
            for(int l = 0; l < ecm; l++)
            {
                if(dhm[l] != k)
                    continue;
                flag = true;
                break;
            }
            if(!flag)
            {
                dhm[ecm] = k;
                dhn[ecm] = 0;
                ecm++;
            }
        }
    }
    private final void fad()
    {
        boolean flag = false;
        byte abyte0[] = faf("media" + cff.cfk + ".jag", "2d graphics", 20);
        if(abyte0 == null)
        {
            egd = true;
            return;
        }
        byte abyte1[] = fnf.gak("index.dat", 0, abyte0);
        gfx.ccc(dkn, fnf.gak("inv1.dat", 0, abyte0), abyte1, 1);
        gfx.ccc(dkn + 1, fnf.gak("inv2.dat", 0, abyte0), abyte1, 6);
        gfx.ccc(dkn + 9, fnf.gak("bubble.dat", 0, abyte0), abyte1, 1);
        gfx.ccc(dkn + 10, fnf.gak("runescape.dat", 0, abyte0), abyte1, 1);
        gfx.ccc(dkn + 11, fnf.gak("splat.dat", 0, abyte0), abyte1, 3);
        gfx.ccc(dkn + 14, fnf.gak("icon.dat", 0, abyte0), abyte1, 8);
        gfx.ccc(dkn + 22, fnf.gak("hbar.dat", 0, abyte0), abyte1, 1);
        gfx.ccc(dkn + 23, fnf.gak("hbar2.dat", 0, abyte0), abyte1, 1);
        gfx.ccc(dkn + 24, fnf.gak("compass.dat", 0, abyte0), abyte1, 1);
        gfx.ccc(dkn + 25, fnf.gak("buttons.dat", 0, abyte0), abyte1, 2);
        gfx.ccc(dla, fnf.gak("scrollbar.dat", 0, abyte0), abyte1, 2);
        gfx.ccc(dla + 2, fnf.gak("corners.dat", 0, abyte0), abyte1, 4);
        gfx.ccc(dla + 6, fnf.gak("arrows.dat", 0, abyte0), abyte1, 2);
        gfx.ccc(dlc, fnf.gak("projectile.dat", 0, abyte0), abyte1, identify.alf);
        int i = identify.alj;
        for(int j = 1; i > 0; j++)
        {
            int k = i;
            i -= 30;
            if(k > 30)
                k = 30;
            gfx.ccc(dlb + (j - 1) * 30, fnf.gak("objects" + j + ".dat", 0, abyte0), abyte1, k);
        }
        gfx.ccf(dkn);
        gfx.ccf(dkn + 9);
        for(int l = 11; l <= 26; l++)
            gfx.ccf(dkn + l);
        for(int i1 = 0; i1 < identify.alf; i1++)
            gfx.ccf(dlc + i1);
        for(int j1 = 0; j1 < identify.alj; j1++)
            gfx.ccf(dlb + j1);
    }
    private final void fae()
    {
        boolean flag = false;
        if(mousebutton3 != 0)
        {
            mousebutton3 = 0;
            int i = super.mousex - 52;
            int j = super.mousey - 44;
            if(i >= 0 && j >= 12 && i < 408 && j < 246)
            {
                int k = 0;
                for(int i1 = 0; i1 < 5; i1++)
                {
                    for(int i2 = 0; i2 < 8; i2++)
                    {
                        int l2 = 7 + i2 * 49;
                        int l3 = 28 + i1 * 34;
                        if(i > l2 && i < l2 + 49 && j > l3 && j < l3 + 34 && efm[k] != -1)
                        {
                            dhc = k;
                            dhd = efm[k];
                        }
                        k++;
                    }
                }
                if(dhc >= 0)
                {
                    int j2 = efm[dhc];
                    if(j2 != -1)
                    {
                        if(efn[dhc] > 0 && i > 298 && j >= 204 && i < 408 && j <= 215)
                        {
                            int i3 = efc + ega[dhc];
                            if(i3 < 10)
                                i3 = 10;
                            int i4 = (i3 * identify.aje[j2]) / 100;
                            super.packets.id(37);
                            super.packets.cmd(efm[dhc]);
                            super.packets.hfi(i4);
                            super.packets.send();
                        }
                        if(fdm(j2) > 0 && i > 2 && j >= 229 && i < 112 && j <= 240)
                        {
                            int j3 = efb + ega[dhc];
                            if(j3 < 10)
                                j3 = 10;
                            int j4 = (j3 * identify.aje[j2]) / 100;
                            super.packets.id(21);
                            super.packets.cmd(efm[dhc]);
                            super.packets.hfi(j4);
                            super.packets.send();
                        }
                    }
                }
            } else
            {
                super.packets.id(210);
                super.packets.send();
                eec = false;
                return;
            }
        }
        byte byte0 = 52;
        byte byte1 = 44;
        gfx.drawbox(52, 44, 408, 12, 192);
        int l = 0x989898;
        gfx.transparentbox(52, 56, 408, 17, 0x989898, 160);
        gfx.transparentbox(52, 73, 8, 170, 0x989898, 160);
        gfx.transparentbox(451, 73, 9, 170, 0x989898, 160);
        gfx.transparentbox(52, 243, 408, 47, 0x989898, 160);
        gfx.drawtext("Buying and selling items", 53, 54, 1, 0xffffff);
        int j1 = 0xffffff;
        if(super.mousex > 372 && super.mousey >= 44 && super.mousex < 460 && super.mousey < 56)
            j1 = 0xff0000;
        gfx.ced("Close window", 458, 54, 1, j1);
        gfx.drawtext("Shops stock in green", 54, 68, 1, 65280);
        gfx.drawtext("Number you own in blue", 187, 68, 1, 65535);
        gfx.drawtext("Your money: " + fdm(10) + "gp", 332, 68, 1, 0xffff00);
        int k2 = 0xd0d0d0;
        int k3 = 0;
        for(int k4 = 0; k4 < 5; k4++)
        {
            for(int l4 = 0; l4 < 8; l4++)
            {
                int j5 = 59 + l4 * 49;
                int i6 = 72 + k4 * 34;
                if(dhc == k3)
                    gfx.transparentbox(j5, i6, 49, 34, 0xff0000, 160);
                else
                    gfx.transparentbox(j5, i6, 49, 34, 0xd0d0d0, 160);
                gfx.drawboxedge(j5, i6, 50, 35, 0);
                if(efm[k3] != -1)
                {
                    gfx.cdk(j5, i6, 48, 32, dlb + identify.ajd[efm[k3]], identify.aji[efm[k3]], 0, 0, false);
                    gfx.drawtext(String.valueOf(efn[k3]), j5 + 1, i6 + 10, 1, 65280);
                    gfx.ced(String.valueOf(fdm(efm[k3])), j5 + 47, i6 + 10, 1, 65535);
                }
                k3++;
            }
        }
        gfx.cbj(57, 266, 398, 0);
        if(dhc == -1)
        {
            gfx.drawcenteredtext("Select an object to buy or sell", 256, 258, 3, 0xffff00);
            return;
        }
        int i5 = efm[dhc];
        if(i5 != -1)
        {
            if(efn[dhc] > 0)
            {
                int k5 = efc + ega[dhc];
                if(k5 < 10)
                    k5 = 10;
                int j6 = (k5 * identify.aje[i5]) / 100;
                gfx.drawtext("Buy a new " + identify.itemname[i5] + " for " + j6 + "gp", 54, 258, 1, 0xffff00);
                int k1 = 0xffffff;
                if(super.mousex > 350 && super.mousey >= 248 && super.mousex < 460 && super.mousey <= 259)
                    k1 = 0xff0000;
                gfx.ced("Click here to buy", 457, 258, 3, k1);
            } else
            {
                gfx.drawcenteredtext("This item is not currently available to buy", 256, 258, 3, 0xffff00);
            }
            if(fdm(i5) > 0)
            {
                int l5 = efb + ega[dhc];
                if(l5 < 10)
                    l5 = 10;
                int k6 = (l5 * identify.aje[i5]) / 100;
                gfx.ced("Sell your " + identify.itemname[i5] + " for " + k6 + "gp", 457, 283, 1, 0xffff00);
                int l1 = 0xffffff;
                if(super.mousex > 54 && super.mousey >= 273 && super.mousex < 164 && super.mousey <= 284)
                    l1 = 0xff0000;
                gfx.drawtext("Click here to sell", 54, 283, 3, l1);
                return;
            }
            gfx.drawcenteredtext("You do not have any of this item to sell", 256, 283, 3, 0xffff00);
        }
    }
    protected final byte[] faf(String s, String s1, int i)
    {     
		if(!dmc)
            s = "Data/" + s;
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
            return super.faf(s, s1, i);
        }
    }
    private final void fag()
    {
        boolean flag = false;
        eac = 0;
        int i = 135;
        for(int j = 0; j < 12; j++)
        {
            if(super.mousex > 66 && super.mousex < 446 && super.mousey >= i - 12 && super.mousey < i + 3)
                eac = j + 1;
            i += 14;
        }
        if(mousebutton3 != 0 && eac != 0)
        {
            mousebutton3 = 0;
            egm = 2;
            super.fln = "";
            super.fma = "";
            return;
        }
        i += 15;
        if(mousebutton3 != 0)
        {
            mousebutton3 = 0;
            if(super.mousex < 56 || super.mousey < 35 || super.mousex > 456 || super.mousey > 325)
            {
                egm = 0;
                return;
            }
            if(super.mousex > 66 && super.mousex < 446 && super.mousey >= i - 15 && super.mousey < i + 5)
            {
                egm = 0;
                return;
            }
        }
        gfx.drawbox(56, 35, 400, 290, 0);
        gfx.drawboxedge(56, 35, 400, 290, 0xffffff);
        i = 50;
        gfx.drawcenteredtext("This form is for reporting players who are breaking our rules", 256, 50, 1, 0xffffff);
        i += 15;
        gfx.drawcenteredtext("Using it sends a snapshot of the last 60 secs of activity to us", 256, 65, 1, 0xffffff);
        i += 15;
        gfx.drawcenteredtext("If you misuse this form, you will be banned.", 256, 80, 1, 0xff8000);
        i += 15;
        i += 10;
        gfx.drawcenteredtext("First indicate which of our 12 rules is being broken. For a detailed", 256, 105, 1, 0xffff00);
        i += 15;
        gfx.drawcenteredtext("explanation of each rule please read the manual on our website.", 256, 120, 1, 0xffff00);
        i += 15;
        int k;
        if(eac == 1)
        {
            gfx.drawboxedge(66, 123, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        gfx.drawcenteredtext("1: Offensive language", 256, 135, 1, k);
        i += 14;
        if(eac == 2)
        {
            gfx.drawboxedge(66, 137, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        gfx.drawcenteredtext("2: Item scamming", 256, 149, 1, k);
        i += 14;
        if(eac == 3)
        {
            gfx.drawboxedge(66, 151, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        gfx.drawcenteredtext("3: Password scamming", 256, 163, 1, k);
        i += 14;
        if(eac == 4)
        {
            gfx.drawboxedge(66, 165, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        gfx.drawcenteredtext("4: Bug abuse", 256, 177, 1, k);
        i += 14;
        if(eac == 5)
        {
            gfx.drawboxedge(66, 179, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        gfx.drawcenteredtext("5: Jagex Staff impersonation", 256, 191, 1, k);
        i += 14;
        if(eac == 6)
        {
            gfx.drawboxedge(66, 193, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        gfx.drawcenteredtext("6: Account sharing/trading", 256, 205, 1, k);
        i += 14;
        if(eac == 7)
        {
            gfx.drawboxedge(66, 207, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        gfx.drawcenteredtext("7: Macroing", 256, 219, 1, k);
        i += 14;
        if(eac == 8)
        {
            gfx.drawboxedge(66, 221, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        gfx.drawcenteredtext("8: Mutiple logging in", 256, 233, 1, k);
        i += 14;
        if(eac == 9)
        {
            gfx.drawboxedge(66, 235, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        gfx.drawcenteredtext("9: Encouraging others to break rules", 256, 247, 1, k);
        i += 14;
        if(eac == 10)
        {
            gfx.drawboxedge(66, 249, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        gfx.drawcenteredtext("10: Misuse of customer support", 256, 261, 1, k);
        i += 14;
        if(eac == 11)
        {
            gfx.drawboxedge(66, 263, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        gfx.drawcenteredtext("11: Advertising / website", 256, 275, 1, k);
        i += 14;
        if(eac == 12)
        {
            gfx.drawboxedge(66, 277, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        gfx.drawcenteredtext("12: Real world item trading", 256, 289, 1, k);
        i += 14;
        i += 15;
        k = 0xffffff;
        if(super.mousex > 196 && super.mousex < 316 && super.mousey > 303 && super.mousey < 323)
            k = 0xffff00;
        gfx.drawcenteredtext("Click here to cancel", 256, 318, 1, k);
    }
    private final cgc fah(int i, int j, int k, int l, int i1)
    {
        int j1 = i;
        int k1 = j;
        int l1 = i;
        int i2 = j;
        int j2 = identify.akd[l];
        int k2 = identify.ake[l];
        int l2 = identify.akc[l];
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
        j1 *= eic;
        k1 *= eic;
        l1 *= eic;
        i2 *= eic;
        int i3 = cgc1.cmj(j1, -myplayerworld.gnb(j1, k1), k1);
        int j3 = cgc1.cmj(j1, -myplayerworld.gnb(j1, k1) - l2, k1);
        int k3 = cgc1.cmj(l1, -myplayerworld.gnb(l1, i2) - l2, i2);
        int l3 = cgc1.cmj(l1, -myplayerworld.gnb(l1, i2), i2);
        int ai[] = {
            i3, j3, k3, l3
        };
        cgc1.cml(4, ai, j2, k2);
        cgc1.cna(false, 60, 24, -50, -10, -50);
        if(i >= 0 && j >= 0 && i < 96 && j < 96)
            egn.bhd(cgc1);
        cgc1.cig = i1 + 10000;
        return cgc1;
    }
    private final void fai()
    {
        boolean flag = false;
        byte byte0 = 22;
        byte byte1 = 36;
        gfx.drawbox(22, 36, 468, 16, 192);
        int i = 0x989898;
        gfx.transparentbox(22, 52, 468, 246, 0x989898, 160);
        gfx.drawcenteredtext("Please confirm your duel with @yel@" + fnf.gah(ekh), 256, 48, 1, 0xffffff);
        gfx.drawcenteredtext("Your stake:", 139, 66, 1, 0xffff00);
        for(int j = 0; j < dkd; j++)
        {
            String s = identify.itemname[dke[j]];
            if(identify.ajf[dke[j]] == 0)
                s = s + " x " + fal(dkf[j]);
            gfx.drawcenteredtext(s, 139, 78 + j * 12, 1, 0xffffff);
        }
        if(dkd == 0)
            gfx.drawcenteredtext("Nothing!", 139, 78, 1, 0xffffff);
        gfx.drawcenteredtext("Your opponent's stake:", 373, 66, 1, 0xffff00);
        for(int k = 0; k < ead; k++)
        {
            String s1 = identify.itemname[eae[k]];
            if(identify.ajf[eae[k]] == 0)
                s1 = s1 + " x " + fal(eaf[k]);
            gfx.drawcenteredtext(s1, 373, 78 + k * 12, 1, 0xffffff);
        }
        if(ead == 0)
            gfx.drawcenteredtext("Nothing!", 373, 78, 1, 0xffffff);
        if(dhg == 0)
            gfx.drawcenteredtext("You can retreat from this duel", 256, 216, 1, 65280);
        else
            gfx.drawcenteredtext("No retreat is possible!", 256, 216, 1, 0xff0000);
        if(dhh == 0)
            gfx.drawcenteredtext("Magic may be used", 256, 228, 1, 65280);
        else
            gfx.drawcenteredtext("Magic cannot be used", 256, 228, 1, 0xff0000);
        if(dhi == 0)
            gfx.drawcenteredtext("Prayer may be used", 256, 240, 1, 65280);
        else
            gfx.drawcenteredtext("Prayer cannot be used", 256, 240, 1, 0xff0000);
        if(dhj == 0)
            gfx.drawcenteredtext("Weapons may be used", 256, 252, 1, 65280);
        else
            gfx.drawcenteredtext("Weapons cannot be used", 256, 252, 1, 0xff0000);
        gfx.drawcenteredtext("If you are sure click 'Accept' to begin the duel", 256, 266, 1, 0xffffff);
        if(!dkm)
        {
            gfx.drawpic(105, 274, dkn + 25);
            gfx.drawpic(339, 274, dkn + 26);
        } else
        {
            gfx.drawcenteredtext("Waiting for other player...", 256, 286, 1, 0xffff00);
        }
        if(mousebutton3 == 1)
        {
            if(super.mousex < 22 || super.mousey < 36 || super.mousex > 490 || super.mousey > 298)
            {
                dkl = false;
                super.packets.id(255);
                super.packets.send();
            }
            if(super.mousex >= 105 && super.mousex <= 210 && super.mousey >= 274 && super.mousey <= 295)
            {
                dkm = true;
                super.packets.id(87);
                super.packets.send();
            }
            if(super.mousex >= 339 && super.mousex <= 445 && super.mousey >= 274 && super.mousey <= 295)
            {
                dkl = false;
                super.packets.id(191);
                super.packets.send();
            }
            mousebutton3 = 0;
        }
    }
    private final void faj(int i, int j, int k, int l, boolean flag)
    {
        fce(i, j, k, l, k, l, false, flag);
    }
    private final void fak()
    {
        boolean flag = false;
        byte abyte0[] = faf("textures" + cff.cfm + ".jag", "Textures", 50);
        if(abyte0 == null)
        {
            egd = true;
            return;
        }
        byte abyte1[] = fnf.gak("index.dat", 0, abyte0);
        egn.bjj(identify.amm, 7, 11);
        for(int i = 0; i < identify.amm; i++)
        {
            String s = identify.amf[i];
            byte abyte2[] = fnf.gak(s + ".dat", 0, abyte0);
            gfx.ccc(dld, abyte2, abyte1, 1);
            gfx.drawbox(0, 0, 128, 128, 0xff00ff);
            gfx.drawpic(0, 0, dld);
            int j = ((blm) (gfx)).bnc[dld];
            String s1 = identify.amg[i];
            if(s1 != null && s1.length() > 0)
            {
                byte abyte3[] = fnf.gak(s1 + ".dat", 0, abyte0);
                gfx.ccc(dld, abyte3, abyte1, 1);
                gfx.drawpic(0, 0, dld);
            }
            gfx.cch(dle + i, 0, 0, j, j);
            int k = j * j;
            for(int l = 0; l < k; l++)
                if(((blm) (gfx)).bmj[dle + i][l] == 65280)
                    ((blm) (gfx)).bmj[dle + i][l] = 0xff00ff;
            gfx.cce(dle + i);
            egn.bjk(i, ((blm) (gfx)).bmk[dle + i], ((blm) (gfx)).bml[dle + i], j / 64 - 1);
        }
    }
    private static final String fal(int i)
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
    final void fam(int i, int j, int k, int l, int i1, int j1, int k1)
    {
        boolean flag3 = false;
        monster gnm1 = npc[i1];
        int l1 = gnm1.hah + (xrot + 16) / 32 & 7;
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
        int j2 = i2 * 3 + dhf[(gnm1.hag / identify.aif[gnm1.type]) % 4];
        if(gnm1.hah == 8)
        {
            i2 = 5;
            l1 = 2;
            flag = false;
            i -= (identify.aih[gnm1.type] * k1) / 100;
            j2 = 15 + eai[(ean / (identify.aig[gnm1.type] - 1)) % 8];
        } else
        if(gnm1.hah == 9)
        {
            i2 = 5;
            l1 = 2;
            flag = true;
            i += (identify.aih[gnm1.type] * k1) / 100;
            j2 = 15 + emi[(ean / identify.aig[gnm1.type]) % 8];
        }
        for(int k2 = 0; k2 < 12; k2++)
        {
            int l2 = eha[l1][k2];
            int k3 = identify.aja[gnm1.type][l2];
            if(k3 >= 0)
            {
                boolean flag1 = false;
                boolean flag2 = false;
                int k4 = j2;
                if(flag && i2 >= 1 && i2 <= 3 && identify.aka[k3] == 1)
                    k4 += 15;
                if(i2 != 5 || identify.ajn[k3] == 1)
                {
                    int l4 = k4 + identify.akb[k3];
                    int i4 = (0 * k) / ((blm) (gfx)).bnc[l4];
                    int j4 = (0 * l) / ((blm) (gfx)).bnd[l4];
                    int i5 = (k * ((blm) (gfx)).bnc[l4]) / ((blm) (gfx)).bnc[identify.akb[k3]];
                    i4 -= (i5 - k) / 2;
                    int j5 = identify.ajl[k3];
                    int k5 = 0;
                    if(j5 == 1)
                    {
                        j5 = identify.anc[gnm1.type];
                        k5 = identify.anf[gnm1.type];
                    } else
                    if(j5 == 2)
                    {
                        j5 = identify.and[gnm1.type];
                        k5 = identify.anf[gnm1.type];
                    } else
                    if(j5 == 3)
                    {
                        j5 = identify.ane[gnm1.type];
                        k5 = identify.anf[gnm1.type];
                    }
                    gfx.cdk(i + i4, j + j4, i5, l, l4, j5, k5, j1, flag);
                }
            }
        }
        if(gnm1.hbb > 0)
        {
            dii[ejd] = gfx.cem(gnm1.hba, 1) / 2;
            if(dii[ejd] > 150)
                dii[ejd] = 150;
            dij[ejd] = (gfx.cem(gnm1.hba, 1) / 300) * gfx.cek(1);
            dig[ejd] = i + k / 2;
            dih[ejd] = j;
            eje[ejd++] = gnm1.hba;
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
                eke[dhl] = i3 + k / 2;
                ekf[dhl] = j;
                ekg[dhl++] = l3;
            }
            if(gnm1.hbh > 150)
            {
                int j3 = i;
                if(gnm1.hah == 8)
                    j3 -= (10 * k1) / 100;
                else
                if(gnm1.hah == 9)
                    j3 += (10 * k1) / 100;
                gfx.drawpic((j3 + k / 2) - 12, (j + l / 2) - 12, dkn + 12);
                gfx.drawcenteredtext(String.valueOf(gnm1.hbe), (j3 + k / 2) - 1, j + l / 2 + 5, 3, 0xffffff);
            }
        }
    }
    private final void fan()
    {
        boolean flag1 = false;
        for(int i = 0; i < ejd; i++)
        {
            int j = gfx.cek(1);
            int l = dig[i];
            int k1 = dih[i];
            int j2 = dii[i];
            int i3 = dij[i];
            boolean flag = true;
            while(flag) 
            {
                flag = false;
                for(int i4 = 0; i4 < i; i4++)
                    if(k1 + i3 > dih[i4] - j && k1 - j < dih[i4] + dij[i4] && l - j2 < dig[i4] + dii[i4] && l + j2 > dig[i4] - dii[i4] && dih[i4] - j - i3 < k1)
                    {
                        k1 = dih[i4] - j - i3;
                        flag = true;
                    }
            }
            dih[i] = k1;
            gfx.cef(eje[i], l, k1, 1, 0xffff00, 300);
        }
        for(int k = 0; k < ehc; k++)
        {
            int i1 = edk[k];
            int l1 = edl[k];
            int k2 = djd[k];
            int j3 = dje[k];
            int l3 = (39 * k2) / 100;
            int j4 = (27 * k2) / 100;
            int k4 = l1 - j4;
            gfx.ccl(i1 - l3 / 2, k4, l3, j4, dkn + 9, 85);
            int l4 = (36 * k2) / 100;
            int i5 = (24 * k2) / 100;
            gfx.cdk(i1 - l4 / 2, (k4 + j4 / 2) - i5 / 2, l4, i5, identify.ajd[j3] + dlb, identify.aji[j3], 0, 0, false);
        }
        for(int j1 = 0; j1 < dhl; j1++)
        {
            int i2 = eke[j1];
            int l2 = ekf[j1];
            int k3 = ekg[j1];
            gfx.transparentbox(i2 - 15, l2 - 3, k3, 5, 65280, 192);
            gfx.transparentbox((i2 - 15) + k3, l2 - 3, 30 - k3, 5, 0xff0000, 192);
        }
    }
    final void fba(int i, int j, int k, int l, int i1, int j1, int k1)
    {
        int l1 = ejf[i1];
        int i2 = eba[i1];
        if(l1 == 0)
        {
            int j2 = 255 + i2 * 5 * 256;
            gfx.drawcircle(i + k / 2, j + l / 2, 20 + i2 * 2, j2, 255 - i2 * 5);
        }
        if(l1 == 1)
        {
            int k2 = 0xff0000 + i2 * 5 * 256;
            gfx.drawcircle(i + k / 2, j + l / 2, 10 + i2, k2, 255 - i2 * 5);
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
    private final void fbc()
    {
        boolean flag = false;
        if(mousebutton3 != 0)
        {
            for(int i = 0; i < actioncount; i++)
            {
                int k = elm + 2;
                int i1 = eln + 27 + i * 15;
                if(super.mousex <= k - 2 || super.mousey <= i1 - 12 || super.mousey >= i1 + 4 || super.mousex >= (k - 3) + ema)
                    continue;
                action(dmd[i]);
                break;
            }
            mousebutton3 = 0;
            dgi = false;
            return;
        }
        if(super.mousex < elm - 10 || super.mousey < eln - 10 || super.mousex > elm + ema + 10 || super.mousey > eln + emb + 10)
        {
            dgi = false;
            return;
        }
        gfx.transparentbox(elm, eln, ema, emb, 0xd0d0d0, 160);
        gfx.drawtext("Choose option", elm + 2, eln + 12, 1, 65535);
        for(int j = 0; j < actioncount; j++)
        {
            int l = elm + 2;
            int j1 = eln + 27 + j * 15;
            int k1 = 0xffffff;
            if(super.mousex > l - 2 && super.mousey > j1 - 12 && super.mousey < j1 + 4 && super.mousex < (l - 3) + ema)
                k1 = 0xffff00;
            gfx.drawtext(topmsg1[dmd[j]] + " " + topmsg2[dmd[j]], l, j1, 1, k1);
        }
    }
    private final void drawmapdot(int i, int j, int k)
    {
        gfx.cbl(i, j, k);
        gfx.cbl(i - 1, j, k);
        gfx.cbl(i + 1, j, k);
        gfx.cbl(i, j - 1, k);
        gfx.cbl(i, j + 1, k);
    }
    private final void fbe()
    {
        gfx.drawbox(126, 137, 260, 60, 0);
        gfx.drawboxedge(126, 137, 260, 60, 0xffffff);
        gfx.drawcenteredtext("Logging out...", 256, 173, 5, 0xffffff);
    }
    private final void fbf()
    {
        boolean flag = false;
        dln = new gca(gfx, 50);
        int i = 40;
        dln.ggj(256, 240, "@gre@Welcome to DBoT", 4, true);
        dln.ggj(256, 255, "@ora@Current World Set To: " + ServerList.world, 4, true);
        dln.ggk(256, 290, 200, 35);
        dln.ggj(256, 290, "Click here to login", 5, false);
        djk = dln.ghd(256, 290, 200, 35);
        dni = new gca(gfx, 50);
        i = 230;
        i += 30;
        dni.ggk(256, 297, 150, 34);
        dni.ggj(256, 297, "Ok", 5, false);
        ded = dni.ghd(256, 297, 150, 34);
        djl = new gca(gfx, 50);
        i = 230;
        dfg = djl.ggj(256, 220, "What be your name", 4, true);
        i += 28;
        djl.ggk(140, 258, 200, 40);
        djl.ggj(140, 248, "Username:", 4, false);
        dfh = djl.ghb(140, 268, 200, 40, 4, 12, false, false);
        i += 47;
        djl.ggk(190, 305, 200, 40);
        djl.ggj(190, 295, "Password:", 4, false);
        dfi = djl.ghb(190, 315, 200, 40, 4, 20, true, false);
        i -= 55;
        djl.ggk(410, 250, 120, 25);
        djl.ggj(410, 250, "Ok", 4, false);
        dfj = djl.ghd(410, 250, 120, 25);
        i += 30;
        djl.ggk(410, 280, 120, 25);
        djl.ggj(410, 280, "Cancel", 4, false);
        dfk = djl.ghd(410, 280, 120, 25);
        i += 30;
        djl.ghm(dfh);
    }
    private final void fbg(boolean flag)
    {
        boolean flag1 = false;
        int i = ((blm) (gfx)).bln - 199;
        int j = 36;
        gfx.drawpic(i - 49, 3, dkn + 4);
        char c = '\304';
        char c1 = '\266';
        int l;
        int k = l = 0xa0a0a0;
        if(eib == 0)
            k = 0xdcdcdc;
        else
            l = 0xdcdcdc;
        gfx.transparentbox(i, 36, 98, 24, k, 128);
        gfx.transparentbox(i + 98, 36, 98, 24, l, 128);
        gfx.transparentbox(i, 60, 196, 90, 0xdcdcdc, 128);
        gfx.transparentbox(i, 150, 196, 68, 0xa0a0a0, 128);
        gfx.cbj(i, 60, 196, 0);
        gfx.cbk(i + 98, 36, 24, 0);
        gfx.cbj(i, 149, 196, 0);
        gfx.drawcenteredtext("Magic", i + 49, 52, 4, 0);
        gfx.drawcenteredtext("Prayers", i + 49 + 98, 52, 4, 0);
        if(eib == 0)
        {
            ehn.ghe(eia);
            int i1 = 0;
            for(int i2 = 0; i2 < identify.aii; i2++)
            {
                String s = "@yel@";
                for(int l3 = 0; l3 < identify.ahf[i2]; l3++)
                {
                    int k4 = identify.ahh[i2][l3];
                    if(ffd(k4, identify.ahi[i2][l3]))
                        continue;
                    s = "@whi@";
                    break;
                }
                int l4 = curstat[6];
                if(identify.ahe[i2] > l4)
                    s = "@bla@";
                ehn.ghg(eia, i1++, s + "Level " + identify.ahe[i2] + ": " + identify.spellname[i2]);
            }
            ehn.gfj();
            int i3 = ehn.ghn(eia);
            if(i3 != -1)
            {
                gfx.drawtext("Level " + identify.ahe[i3] + ": " + identify.spellname[i3], i + 2, 160, 1, 0xffff00);
                gfx.drawtext(identify.aik[i3], i + 2, 172, 0, 0xffffff);
                for(int i4 = 0; i4 < identify.ahf[i3]; i4++)
                {
                    int i5 = identify.ahh[i3][i4];
                    gfx.drawpic(i + 2 + i4 * 44, 186, dlb + identify.ajd[i5]);
                    int j5 = fdm(i5);
                    int k5 = identify.ahi[i3][i4];
                    String s2 = "@red@";
                    if(ffd(i5, k5))
                        s2 = "@gre@";
                    gfx.drawtext(s2 + j5 + "/" + k5, i + 2 + i4 * 44, 186, 1, 0xffffff);
                }
            } else
            {
                gfx.drawtext("Point at a spell for a description", i + 2, 160, 1, 0);
            }
        }
        if(eib == 1)
        {
            ehn.ghe(eia);
            int j1 = 0;
            for(int j2 = 0; j2 < identify.ajb; j2++)
            {
                String s1 = "@whi@";
                if(identify.aim[j2] > stat[5])
                    s1 = "@bla@";
                if(djb[j2])
                    s1 = "@gre@";
                ehn.ghg(eia, j1++, s1 + "Level " + identify.aim[j2] + ": " + identify.aia[j2]);
            }
            ehn.gfj();
            int j3 = ehn.ghn(eia);
            if(j3 != -1)
            {
                gfx.drawcenteredtext("Level " + identify.aim[j3] + ": " + identify.aia[j3], i + 98, 166, 1, 0xffff00);
                gfx.drawcenteredtext(identify.aib[j3], i + 98, 181, 0, 0xffffff);
                gfx.drawcenteredtext("Drain rate: " + identify.ain[j3], i + 98, 196, 1, 0);
            } else
            {
                gfx.drawtext("Point at a prayer for a description", i + 2, 160, 1, 0);
            }
        }
        if(!flag)
            return;
        i = super.mousex - (((blm) (gfx)).bln - 199);
        j = super.mousey - 36;
        if(i >= 0 && j >= 0 && i < 196 && j < 182)
        {
            ehn.gfg(i + (((blm) (gfx)).bln - 199), j + 36, super.mousebutton2, super.mousebutton);
            if(j <= 24 && mousebutton3 == 1)
                if(i < 98 && eib == 1)
                {
                    eib = 0;
                    ehn.ghf(eia);
                } else
                if(i > 98 && eib == 0)
                {
                    eib = 1;
                    ehn.ghf(eia);
                }
            if(mousebutton3 == 1 && eib == 0)
            {
                int k1 = ehn.ghn(eia);
                if(k1 != -1)
                {
                    int k2 = curstat[6];
                    if(identify.ahe[k1] > k2)
                    {
                        displaymessage("Your magic ability is not high enough for this spell", 3);
                    } else
                    {
                        int k3;
                        for(k3 = 0; k3 < identify.ahf[k1]; k3++)
                        {
                            int j4 = identify.ahh[k1][k3];
                            if(ffd(j4, identify.ahi[k1][k3]))
                                continue;
                            displaymessage("You don't have all the reagents you need for this spell", 3);
                            k3 = -1;
                            break;
                        }
                        if(k3 == identify.ahf[k1])
                        {
                            selectedspell = k1;
                            selecteditem = -1;
                        }
                    }
                }
            }
            if(mousebutton3 == 1 && eib == 1)
            {
                int l1 = ehn.ghn(eia);
                if(l1 != -1)
                {
                    int l2 = stat[5];
                    if(identify.aim[l1] > l2)
                        displaymessage("Your prayer ability is not high enough for this prayer", 3);
                    else
                    if(curstat[5] == 0)
                        displaymessage("You have run out of prayer points. Return to a church to recharge", 3);
                    else
                    if(djb[l1])
                    {
                        super.packets.id(122);
                        super.packets.var(l1);
                        super.packets.send();
                        djb[l1] = false;
                        fbm("prayeroff");
                    } else
                    {
                        super.packets.id(187);
                        super.packets.var(l1);
                        super.packets.send();
                        djb[l1] = true;
                        fbm("prayeron");
                    }
                }
            }
            mousebutton3 = 0;
        }
    }
    public URL getCodeBase()
    {
		try
		{
			return new URL(ServerList.getWorld());
		}
		catch (MalformedURLException e) {}
        //return super.getCodeBase();
		return null;
    }
    private final void fbh()
    {
        if(mousebutton3 != 0)
        {
            mousebutton3 = 0;
            if(djc == 1 && (super.mousex < 106 || super.mousey < 145 || super.mousex > 406 || super.mousey > 215))
            {
                djc = 0;
                return;
            }
            if(djc == 2 && (super.mousex < 6 || super.mousey < 145 || super.mousex > 506 || super.mousey > 215))
            {
                djc = 0;
                return;
            }
            if(djc == 3 && (super.mousex < 106 || super.mousey < 145 || super.mousex > 406 || super.mousey > 215))
            {
                djc = 0;
                return;
            }
            if(super.mousex > 236 && super.mousex < 276 && super.mousey > 193 && super.mousey < 213)
            {
                djc = 0;
                return;
            }
        }
        int i = 145;
        if(djc == 1)
        {
            gfx.drawbox(106, 145, 300, 70, 0);
            gfx.drawboxedge(106, 145, 300, 70, 0xffffff);
            i += 20;
            gfx.drawcenteredtext("Enter name to add to friends list", 256, 165, 4, 0xffffff);
            i += 20;
            gfx.drawcenteredtext(super.fln + "*", 256, 185, 4, 0xffffff);
            if(super.fma.length() > 0)
            {
                String s = super.fma.trim();
                super.fln = "";
                super.fma = "";
                djc = 0;
                if(s.length() > 0 && fnf.gag(s) != myplayer.gnn)
                    ack(s);
            }
        }
        if(djc == 2)
        {
            gfx.drawbox(6, i, 500, 70, 0);
            gfx.drawboxedge(6, i, 500, 70, 0xffffff);
            i += 20;
            gfx.drawcenteredtext("Enter message to send to " + fnf.gah(ekd), 256, i, 4, 0xffffff);
            i += 20;
            gfx.drawcenteredtext(super.fmb + "*", 256, i, 4, 0xffffff);
            if(super.fmc.length() > 0)
            {
                String s1 = super.fmc;
                super.fmb = "";
                super.fmc = "";
                djc = 0;
                int k = cen.cfe(s1);
                acm(ekd, cen.cfa, k);
                s1 = cen.cfd(cen.cfa, 0, k);
                s1 = ffn.fhe(s1);
                servermessage("@pri@You tell " + fnf.gah(ekd) + ": " + s1);
            }
        }
        if(djc == 3)
        {
            gfx.drawbox(106, i, 300, 70, 0);
            gfx.drawboxedge(106, i, 300, 70, 0xffffff);
            i += 20;
            gfx.drawcenteredtext("Enter name to add to ignore list", 256, i, 4, 0xffffff);
            i += 20;
            gfx.drawcenteredtext(super.fln + "*", 256, i, 4, 0xffffff);
            if(super.fma.length() > 0)
            {
                String s2 = super.fma.trim();
                super.fln = "";
                super.fma = "";
                djc = 0;
                if(s2.length() > 0 && fnf.gag(s2) != myplayer.gnn)
                    aci(s2);
            }
        }
        int j = 0xffffff;
        if(super.mousex > 236 && super.mousex < 276 && super.mousey > 193 && super.mousey < 213)
            j = 0xffff00;
        gfx.drawcenteredtext("Cancel", 256, 208, 1, j);
    }
    private final void fbi()
    {
        boolean flag = false;
        if(mousebutton3 != 0)
        {
            for(int i = 0; i < ddl; i++)
            {
                if(super.mousex >= gfx.cem(ece[i], 1) || super.mousey <= i * 12 || super.mousey >= 12 + i * 12)
                    continue;
                super.packets.id(163);
                super.packets.var(i);
                super.packets.send();
                break;
            }
            mousebutton3 = 0;
            dhk = false;
            return;
        }
        for(int j = 0; j < ddl; j++)
        {
            int k = 65535;
            if(super.mousex < gfx.cem(ece[j], 1) && super.mousey > j * 12 && super.mousey < 12 + j * 12)
                k = 0xff0000;
            gfx.drawtext(ece[j], 6, 12 + j * 12, 1, k);
        }
    }
    private final void fbj()
    {
        boolean flag = false;
        int i = 65;
        if(efd != 201)
            i += 60;
        if(dnc > 0)
            i += 60;
        if(elk != 0)
            i += 45;
        int j = 167 - i / 2;
        gfx.drawbox(56, 167 - i / 2, 400, i, 0);
        gfx.drawboxedge(56, 167 - i / 2, 400, i, 0xffffff);
        j += 20;
        gfx.drawcenteredtext("Welcome to RuneScape " + eld, 256, j, 4, 0xffff00);
        j += 30;
        String s;
        if(dik == 0)
            s = "earlier today";
        else
        if(dik == 1)
            s = "yesterday";
        else
            s = dik + " days ago";
        if(elk != 0)
        {
            gfx.drawcenteredtext("You last logged in " + s, 256, j, 1, 0xffffff);
            j += 15;
            if(edn == null)
                edn = fde(elk);
            gfx.drawcenteredtext("from: " + edn, 256, j, 1, 0xffffff);
            j += 15;
            j += 15;
        }
        if(dnc > 0)
        {
            int k = 0xffffff;
            gfx.drawcenteredtext("Jagex staff will NEVER email you. We use the", 256, j, 1, 0xffffff);
            j += 15;
            gfx.drawcenteredtext("message-centre on this website instead.", 256, j, 1, 0xffffff);
            j += 15;
            if(dnc == 1)
                gfx.drawcenteredtext("You have @yel@0@whi@ unread messages in your message-centre", 256, j, 1, 0xffffff);
            else
                gfx.drawcenteredtext("You have @gre@" + (dnc - 1) + " unread messages @whi@in your message-centre", 256, j, 1, 0xffffff);
            j += 15;
            j += 15;
        }
        if(efd != 201)
        {
            if(efd == 200)
            {
                gfx.drawcenteredtext("You have not yet set any password recovery questions.", 256, j, 1, 0xff8000);
                j += 15;
                gfx.drawcenteredtext("We strongly recommend you do so now to secure your account.", 256, j, 1, 0xff8000);
                j += 15;
                gfx.drawcenteredtext("Do this from the 'account management' area on our front webpage", 256, j, 1, 0xff8000);
                j += 15;
            } else
            {
                String s1;
                if(efd == 0)
                    s1 = "Earlier today";
                else
                if(efd == 1)
                    s1 = "Yesterday";
                else
                    s1 = efd + " days ago";
                gfx.drawcenteredtext(s1 + " you changed your recovery questions", 256, j, 1, 0xff8000);
                j += 15;
                gfx.drawcenteredtext("If you do not remember making this change then cancel it immediately", 256, j, 1, 0xff8000);
                j += 15;
                gfx.drawcenteredtext("Do this from the 'account management' area on our front webpage", 256, j, 1, 0xff8000);
                j += 15;
            }
            j += 15;
        }
        int l = 0xffffff;
        if(super.mousey > j - 12 && super.mousey <= j && super.mousex > 106 && super.mousex < 406)
            l = 0xff0000;
        gfx.drawcenteredtext("Click here to close window", 256, j, 1, l);
        if(mousebutton3 == 1)
        {
            if(l == 0xff0000)
                dha = false;
            if((super.mousex < 86 || super.mousex > 426) && (super.mousey < 167 - i / 2 || super.mousey > 167 + i / 2))
                dha = false;
        }
        mousebutton3 = 0;
    }
    private final void fbk()
    {
        boolean flag2 = false;
        if(mousebutton3 != 0 && ecl == 0)
            ecl = 1;
        if(ecl > 0)
        {
            int i = super.mousex - 22;
            int j = super.mousey - 36;
            if(i >= 0 && j >= 0 && i < 468 && j < 262)
            {
                if(i > 216 && j > 30 && i < 462 && j < 235)
                {
                    int k = (i - 217) / 49 + ((j - 31) / 34) * 5;
                    if(k >= 0 && k < invcount)
                    {
                        boolean flag1 = false;
                        int l1 = 0;
                        int k2 = inventory[k];
                        for(int k3 = 0; k3 < dme; k3++)
                            if(dmf[k3] == k2)
                                if(identify.ajf[k2] == 0)
                                {
                                    for(int i4 = 0; i4 < ecl; i4++)
                                    {
                                        if(dmg[k3] < enc[k])
                                            dmg[k3]++;
                                        flag1 = true;
                                    }
                                } else
                                {
                                    l1++;
                                }
                        if(fdm(k2) <= l1)
                            flag1 = true;
                        if(identify.ajj[k2] == 1)
                        {
                            displaymessage("This object cannot be added to a duel offer", 3);
                            flag1 = true;
                        }
                        if(!flag1 && dme < 8)
                        {
                            dmf[dme] = k2;
                            dmg[dme] = 1;
                            dme++;
                            flag1 = true;
                        }
                        if(flag1)
                        {
                            super.packets.id(253);
                            super.packets.var(dme);
                            for(int j4 = 0; j4 < dme; j4++)
                            {
                                super.packets.cmd(dmf[j4]);
                                super.packets.hfi(dmg[j4]);
                            }
                            super.packets.send();
                            dma = false;
                            dmb = false;
                        }
                    }
                }
                if(i > 8 && j > 30 && i < 205 && j < 129)
                {
                    int l = (i - 9) / 49 + ((j - 31) / 34) * 4;
                    if(l >= 0 && l < dme)
                    {
                        int j1 = dmf[l];
                        for(int i2 = 0; i2 < ecl; i2++)
                        {
                            if(identify.ajf[j1] == 0 && dmg[l] > 1)
                            {
                                dmg[l]--;
                                continue;
                            }
                            dme--;
                            eck = 0;
                            for(int l2 = l; l2 < dme; l2++)
                            {
                                dmf[l2] = dmf[l2 + 1];
                                dmg[l2] = dmg[l2 + 1];
                            }
                            break;
                        }
                        super.packets.id(253);
                        super.packets.var(dme);
                        for(int i3 = 0; i3 < dme; i3++)
                        {
                            super.packets.cmd(dmf[i3]);
                            super.packets.hfi(dmg[i3]);
                        }
                        super.packets.send();
                        dma = false;
                        dmb = false;
                    }
                }
                boolean flag = false;
                if(i >= 93 && j >= 221 && i <= 104 && j <= 232)
                {
                    dem = !dem;
                    flag = true;
                }
                if(i >= 93 && j >= 240 && i <= 104 && j <= 251)
                {
                    den = !den;
                    flag = true;
                }
                if(i >= 191 && j >= 221 && i <= 202 && j <= 232)
                {
                    dfa = !dfa;
                    flag = true;
                }
                if(i >= 191 && j >= 240 && i <= 202 && j <= 251)
                {
                    dfb = !dfb;
                    flag = true;
                }
                if(flag)
                {
                    super.packets.id(234);
                    super.packets.var(dem ? 1 : 0);
                    super.packets.var(den ? 1 : 0);
                    super.packets.var(dfa ? 1 : 0);
                    super.packets.var(dfb ? 1 : 0);
                    super.packets.send();
                    dma = false;
                    dmb = false;
                }
                if(i >= 217 && j >= 238 && i <= 286 && j <= 259)
                {
                    dmb = true;
                    super.packets.id(50);
                    super.packets.send();
                }
                if(i >= 394 && j >= 238 && i < 463 && j < 259)
                {
                    eeb = false;
                    super.packets.id(191);
                    super.packets.send();
                }
            } else
            if(mousebutton3 != 0)
            {
                eeb = false;
                super.packets.id(191);
                super.packets.send();
            }
            mousebutton3 = 0;
            ecl = 0;
        }
        if(!eeb)
            return;
        byte byte0 = 22;
        byte byte1 = 36;
        gfx.drawbox(22, 36, 468, 12, 0xc90b1d);
        int i1 = 0x989898;
        gfx.transparentbox(22, 48, 468, 18, 0x989898, 160);
        gfx.transparentbox(22, 66, 8, 248, 0x989898, 160);
        gfx.transparentbox(227, 66, 11, 248, 0x989898, 160);
        gfx.transparentbox(484, 66, 6, 248, 0x989898, 160);
        gfx.transparentbox(30, 135, 197, 24, 0x989898, 160);
        gfx.transparentbox(30, 228, 197, 23, 0x989898, 160);
        gfx.transparentbox(30, 294, 197, 20, 0x989898, 160);
        gfx.transparentbox(238, 271, 246, 43, 0x989898, 160);
        int k1 = 0xd0d0d0;
        gfx.transparentbox(30, 66, 197, 69, 0xd0d0d0, 160);
        gfx.transparentbox(30, 159, 197, 69, 0xd0d0d0, 160);
        gfx.transparentbox(30, 251, 197, 43, 0xd0d0d0, 160);
        gfx.transparentbox(238, 66, 246, 205, 0xd0d0d0, 160);
        for(int j2 = 0; j2 < 3; j2++)
            gfx.cbj(30, 66 + j2 * 34, 197, 0);
        for(int j3 = 0; j3 < 3; j3++)
            gfx.cbj(30, 159 + j3 * 34, 197, 0);
        for(int l3 = 0; l3 < 7; l3++)
            gfx.cbj(238, 66 + l3 * 34, 246, 0);
        for(int k4 = 0; k4 < 6; k4++)
        {
            if(k4 < 5)
                gfx.cbk(30 + k4 * 49, 66, 69, 0);
            if(k4 < 5)
                gfx.cbk(30 + k4 * 49, 159, 69, 0);
            gfx.cbk(238 + k4 * 49, 66, 205, 0);
        }
        gfx.cbj(30, 251, 197, 0);
        gfx.cbj(30, 293, 197, 0);
        gfx.cbk(30, 251, 43, 0);
        gfx.cbk(226, 251, 43, 0);
        gfx.drawtext("Preparing to duel with: " + dfn, 23, 46, 1, 0xffffff);
        gfx.drawtext("Your Stake", 31, 63, 4, 0xffffff);
        gfx.drawtext("Opponent's Stake", 31, 156, 4, 0xffffff);
        gfx.drawtext("Duel Options", 31, 248, 4, 0xffffff);
        gfx.drawtext("Your Inventory", 238, 63, 4, 0xffffff);
        gfx.drawtext("No retreating", 31, 267, 3, 0xffff00);
        gfx.drawtext("No magic", 31, 286, 3, 0xffff00);
        gfx.drawtext("No prayer", 132, 267, 3, 0xffff00);
        gfx.drawtext("No weapons", 132, 286, 3, 0xffff00);
        gfx.drawboxedge(115, 257, 11, 11, 0xffff00);
        if(dem)
            gfx.drawbox(117, 259, 7, 7, 0xffff00);
        gfx.drawboxedge(115, 276, 11, 11, 0xffff00);
        if(den)
            gfx.drawbox(117, 278, 7, 7, 0xffff00);
        gfx.drawboxedge(213, 257, 11, 11, 0xffff00);
        if(dfa)
            gfx.drawbox(215, 259, 7, 7, 0xffff00);
        gfx.drawboxedge(213, 276, 11, 11, 0xffff00);
        if(dfb)
            gfx.drawbox(215, 278, 7, 7, 0xffff00);
        if(!dmb)
            gfx.drawpic(239, 274, dkn + 25);
        gfx.drawpic(416, 274, dkn + 26);
        if(dma)
        {
            gfx.drawcenteredtext("Other player", 363, 282, 1, 0xffffff);
            gfx.drawcenteredtext("has accepted", 363, 292, 1, 0xffffff);
        }
        if(dmb)
        {
            gfx.drawcenteredtext("Waiting for", 274, 282, 1, 0xffffff);
            gfx.drawcenteredtext("other player", 274, 292, 1, 0xffffff);
        }
        for(int l4 = 0; l4 < invcount; l4++)
        {
            int i5 = 239 + (l4 % 5) * 49;
            int k5 = 67 + (l4 / 5) * 34;
            gfx.cdk(i5, k5, 48, 32, dlb + identify.ajd[inventory[l4]], identify.aji[inventory[l4]], 0, 0, false);
            if(identify.ajf[inventory[l4]] == 0)
                gfx.drawtext(String.valueOf(enc[l4]), i5 + 1, k5 + 10, 1, 0xffff00);
        }
        for(int j5 = 0; j5 < dme; j5++)
        {
            int l5 = 31 + (j5 % 4) * 49;
            int j6 = 67 + (j5 / 4) * 34;
            gfx.cdk(l5, j6, 48, 32, dlb + identify.ajd[dmf[j5]], identify.aji[dmf[j5]], 0, 0, false);
            if(identify.ajf[dmf[j5]] == 0)
                gfx.drawtext(String.valueOf(dmg[j5]), l5 + 1, j6 + 10, 1, 0xffff00);
            if(super.mousex > l5 && super.mousex < l5 + 48 && super.mousey > j6 && super.mousey < j6 + 32)
                gfx.drawtext(identify.itemname[dmf[j5]] + ": @whi@" + identify.amc[dmf[j5]], 30, 309, 1, 0xffff00);
        }
        for(int i6 = 0; i6 < ecb; i6++)
        {
            int k6 = 31 + (i6 % 4) * 49;
            int l6 = 160 + (i6 / 4) * 34;
            gfx.cdk(k6, l6, 48, 32, dlb + identify.ajd[ecc[i6]], identify.aji[ecc[i6]], 0, 0, false);
            if(identify.ajf[ecc[i6]] == 0)
                gfx.drawtext(String.valueOf(ecd[i6]), k6 + 1, l6 + 10, 1, 0xffff00);
            if(super.mousex > k6 && super.mousex < k6 + 48 && super.mousey > l6 && super.mousey < l6 + 32)
                gfx.drawtext(identify.itemname[ecc[i6]] + ": @whi@" + identify.amc[ecc[i6]], 30, 309, 1, 0xffff00);
        }
    }
    final void fbl(int i, int j, int k, int l, int i1, int j1, int k1)
    {
        boolean flag1 = false;
        monster gnm1 = player[i1];
        if(gnm1.hbl == 255)
            return;
        int l1 = gnm1.hah + (xrot + 16) / 32 & 7;
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
        int j2 = i2 * 3 + dhf[(gnm1.hag / 6) % 4];
        if(gnm1.hah == 8)
        {
            i2 = 5;
            l1 = 2;
            flag = false;
            i -= (5 * k1) / 100;
            j2 = 15 + eai[(ean / 5) % 8];
        } else
        if(gnm1.hah == 9)
        {
            i2 = 5;
            l1 = 2;
            flag = true;
            i += (5 * k1) / 100;
            j2 = 15 + emi[(ean / 6) % 8];
        }
        for(int k2 = 0; k2 < 12; k2++)
        {
            int l2 = eha[l1][k2];
            int l3 = gnm1.han[l2] - 1;
            if(l3 >= 0)
            {
                int k4 = 0;
                int i5 = 0;
                int j5 = j2;
                if(flag && i2 >= 1 && i2 <= 3)
                    if(identify.aka[l3] == 1)
                        j5 += 15;
                    else
                    if(l2 == 4 && i2 == 1)
                    {
                        k4 = -22;
                        i5 = -3;
                        j5 = i2 * 3 + dhf[(2 + gnm1.hag / 6) % 4];
                    } else
                    if(l2 == 4 && i2 == 2)
                    {
                        k4 = 0;
                        i5 = -8;
                        j5 = i2 * 3 + dhf[(2 + gnm1.hag / 6) % 4];
                    } else
                    if(l2 == 4 && i2 == 3)
                    {
                        k4 = 26;
                        i5 = -5;
                        j5 = i2 * 3 + dhf[(2 + gnm1.hag / 6) % 4];
                    } else
                    if(l2 == 3 && i2 == 1)
                    {
                        k4 = 22;
                        i5 = 3;
                        j5 = i2 * 3 + dhf[(2 + gnm1.hag / 6) % 4];
                    } else
                    if(l2 == 3 && i2 == 2)
                    {
                        k4 = 0;
                        i5 = 8;
                        j5 = i2 * 3 + dhf[(2 + gnm1.hag / 6) % 4];
                    } else
                    if(l2 == 3 && i2 == 3)
                    {
                        k4 = -26;
                        i5 = 5;
                        j5 = i2 * 3 + dhf[(2 + gnm1.hag / 6) % 4];
                    }
                if(i2 != 5 || identify.ajn[l3] == 1)
                {
                    int k5 = j5 + identify.akb[l3];
                    k4 = (k4 * k) / ((blm) (gfx)).bnc[k5];
                    i5 = (i5 * l) / ((blm) (gfx)).bnd[k5];
                    int l5 = (k * ((blm) (gfx)).bnc[k5]) / ((blm) (gfx)).bnc[identify.akb[l3]];
                    k4 -= (l5 - k) / 2;
                    int i6 = identify.ajl[l3];
                    int j6 = ecn[gnm1.hbm];
                    if(i6 == 1)
                        i6 = ehj[gnm1.hbj];
                    else
                    if(i6 == 2)
                        i6 = eak[gnm1.hbk];
                    else
                    if(i6 == 3)
                        i6 = eak[gnm1.hbl];
                    gfx.cdk(i + k4, j + i5, l5, l, k5, i6, j6, j1, flag);
                }
            }
        }
		
		if (gnm1 != myplayer)
		{
			if (showhits == true && gnm1.hbg > 0)
			{
				dii[ejd] = gfx.cem("@gre@" + gnm1.hbf + "/" + gnm1.hbg, 1) / 2;
				dij[ejd] = (gfx.cem("@gre@" + gnm1.hbf + "/" + gnm1.hbg, 1) / 300) * gfx.cek(1);
				dig[ejd] = i + k / 2;
				dih[ejd] = j;
				eje[ejd++] = "@gre@" + gnm1.hbf + "@whi@/@gre@" + gnm1.hbg;
			} else {
				if (showhits == true)
				{
					dii[ejd] = gfx.cem("@gre@?", 1) / 2;
					dij[ejd] = (gfx.cem("@gre@?", 1) / 300) * gfx.cek(1);
					dig[ejd] = i + k / 2;
					dih[ejd] = j;
					eje[ejd++] = "@gre@?";
				}
			}
		}

        if(gnm1.hbb > 0)
        {
            dii[ejd] = gfx.cem(gnm1.hba, 1) / 2;
            if(dii[ejd] > 150)
                dii[ejd] = 150;
            dij[ejd] = (gfx.cem(gnm1.hba, 1) / 300) * gfx.cek(1);
            dig[ejd] = i + k / 2;
            dih[ejd] = j;
            eje[ejd++] = gnm1.hba;
        }
        if(gnm1.hbd > 0)
        {
            edk[ehc] = i + k / 2;
            edl[ehc] = j;
            djd[ehc] = k1;
            dje[ehc++] = gnm1.hbc;
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
                eke[dhl] = i3 + k / 2;
                ekf[dhl] = j;
                ekg[dhl++] = i4;
            }
            if(gnm1.hbh > 150)
            {
                int j3 = i;
                if(gnm1.hah == 8)
                    j3 -= (10 * k1) / 100;
                else
                if(gnm1.hah == 9)
                    j3 += (10 * k1) / 100;
                gfx.drawpic((j3 + k / 2) - 12, (j + l / 2) - 12, dkn + 11);
                gfx.drawcenteredtext(String.valueOf(gnm1.hbe), (j3 + k / 2) - 1, j + l / 2 + 5, 3, 0xffffff);
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
            gfx.ccj(k3 - j4 / 2, j - l4 / 2 - (10 * k1) / 100, j4, l4, dkn + 13);
        }
    }
    private final void fbm(String s)
    {
        if(dnl == null)
            return;
        if(soundeffects)
        {
            return;
        } else
        {
            dnl.gif(ejj, fnf.gai(s + ".pcm", ejj), fnf.gaj(s + ".pcm", ejj));
            return;
        }
    }
    private final void fbn()
    {
        myplayerworld.gje = faf("maps" + cff.cfj + ".jag", "map", 70);
        if(member)
            myplayerworld.gjj = faf("maps" + cff.cfj + ".mem", "members map", 75);
        myplayerworld.gjd = faf("land" + cff.cfj + ".jag", "landscape", 80);
        if(member)
            myplayerworld.gji = faf("land" + cff.cfj + ".mem", "members landscape", 85);
    }
    private final void fca()
    {
        boolean flag = false;
        int i = 2203 - (smally + edb + dna);
        if(smallx + eda + dmn >= 2640)
            i = -50;
        int j = -1;
        for(int k = 0; k < mobcount; k++)
            ddi[k] = false;
        for(int l = 0; l < eim; l++)
            dja[l] = false;
        int i1 = egn.bhm();
        cgc acgc[] = egn.bia();
        int ai[] = egn.bhn();
        for(int j1 = 0; j1 < i1; j1++)
        {
            if(actioncount > 200)
                break;
            int k1 = ai[j1];
            cgc cgc1 = acgc[j1];
            if(cgc1.cih[k1] <= 65535 || cgc1.cih[k1] >= 0x30d40 && cgc1.cih[k1] <= 0x493e0)
                if(cgc1 == egn.bem)
                {
                    int i2 = cgc1.cih[k1] % 10000;
                    int l2 = cgc1.cih[k1] / 10000;
                    if(l2 == 1)
                    {
                        String s = "";
                        int k3 = 0;
                        if(myplayer.level > 0 && player[i2].level > 0)
                            k3 = myplayer.level - player[i2].level;
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
                        s = " " + s + "(level-" + player[i2].level + ")";
                        if(selectedspell >= 0)
                        {
                            if(identify.spellid[selectedspell] == 1 || identify.spellid[selectedspell] == 2)
                            {
                                topmsg1[actioncount] = "Cast " + identify.spellname[selectedspell] + " on";
                                topmsg2[actioncount] = "@whi@" + player[i2].name + s;
                                actionid[actioncount] = 800;
                                actionx[actioncount] = player[i2].x;
                                actiony[actioncount] = player[i2].y;
                                actionvar[actioncount] = player[i2].id;
                                actionvar2[actioncount] = selectedspell;
                                actioncount++;
                            }
                        } else
                        if(selecteditem >= 0)
                        {
                            topmsg1[actioncount] = "Use " + selecteditemname + " with";
                            topmsg2[actioncount] = "@whi@" + player[i2].name + s;
                            actionid[actioncount] = 810;
                            actionx[actioncount] = player[i2].x;
                            actiony[actioncount] = player[i2].y;
                            actionvar[actioncount] = player[i2].id;
                            actionvar2[actioncount] = selecteditem;
                            actioncount++;
                        } else
                        {
                            if(i > 0 && (player[i2].y - 64) / eic + edb + dna < 2203)
                            {
                                topmsg1[actioncount] = "Attack";
                                topmsg2[actioncount] = "@whi@" + player[i2].name + s;
                                if(k3 >= 0 && k3 < 5)
                                    actionid[actioncount] = 805;
                                else
                                    actionid[actioncount] = 2805;
                                actionx[actioncount] = player[i2].x;
                                actiony[actioncount] = player[i2].y;
                                actionvar[actioncount] = player[i2].id;
                                actioncount++;
								           							
                            } else
                            if(ServerList.world == 32 || ServerList.world == 34)
                            {
                                topmsg1[actioncount] = "Duel with";
                                topmsg2[actioncount] = "@whi@" + player[i2].name + s;
                                actionx[actioncount] = player[i2].x;
                                actiony[actioncount] = player[i2].y;
                                actionid[actioncount] = 2806;
                                actionvar[actioncount] = player[i2].id;
                                actioncount++;
                            }       
								topmsg1[actioncount] = "Catch";
								topmsg2[actioncount] = "@whi@" + player[i2].name + s;
								actionid[actioncount] = 1337;
								actionx[actioncount] = player[i2].x;
								actiony[actioncount] = player[i2].y;
								actionvar[actioncount] = player[i2].id;
								catchname = null;
								actioncount++;	

                            topmsg1[actioncount] = "Trade with";
                            topmsg2[actioncount] = "@whi@" + player[i2].name + s;
                            actionid[actioncount] = 2810;
                            actionvar[actioncount] = player[i2].id;
                            actioncount++;

                            topmsg1[actioncount] = "Follow";
                            topmsg2[actioncount] = "@whi@" + player[i2].name + s;
                            actionid[actioncount] = 2820;
                            actionvar[actioncount] = player[i2].id;
                            actioncount++;
                        }
                    } else
                    if(l2 == 2)
                    {
                        if(selectedspell >= 0)
                        {
                            if(identify.spellid[selectedspell] == 3)
                            {
                                topmsg1[actioncount] = "Cast " + identify.spellname[selectedspell] + " on";
                                topmsg2[actioncount] = "@lre@" + identify.itemname[djh[i2]];
                                actionid[actioncount] = 200;
                                actionx[actioncount] = djf[i2];
                                actiony[actioncount] = djg[i2];
                                actionvar[actioncount] = djh[i2];
                                actionvar2[actioncount] = selectedspell;
                                actioncount++;
                            }
                        } else
                        if(selecteditem >= 0)
                        {
                            topmsg1[actioncount] = "Use " + selecteditemname + " with";
                            topmsg2[actioncount] = "@lre@" + identify.itemname[djh[i2]];
                            actionid[actioncount] = 210;
                            actionx[actioncount] = djf[i2];
                            actiony[actioncount] = djg[i2];
                            actionvar[actioncount] = djh[i2];
                            actionvar2[actioncount] = selecteditem;
                            actioncount++;
                        } else
                        {
                            topmsg1[actioncount] = "Take";
                            topmsg2[actioncount] = "@lre@" + identify.itemname[djh[i2]];
                            actionid[actioncount] = 220;
                            actionx[actioncount] = djf[i2];
                            actiony[actioncount] = djg[i2];
                            actionvar[actioncount] = djh[i2];
                            actioncount++;
                            topmsg1[actioncount] = "Examine";
                            topmsg2[actioncount] = "@lre@" + identify.itemname[djh[i2]];
                            actionid[actioncount] = 3200;
                            actionvar[actioncount] = djh[i2];
                            actioncount++;
                        }
                    } else
                    if(l2 == 3)
                    {
                        String s1 = "";
                        int l3 = -1;
                        int i4 = npc[i2].type;
                        if(identify.ahn[i4] > 0)
                        {
                            int j4 = (identify.npcattack[i4] + identify.npcdefence[i4] + identify.npcstrength[i4] + identify.npchits[i4]) / 4;
                            int k4 = (stat[0] + stat[1] + stat[2] + stat[3] + 27) / 4;
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
                        if(selectedspell >= 0)
                        {
                            if(identify.spellid[selectedspell] == 2)
                            {
                                topmsg1[actioncount] = "Cast " + identify.spellname[selectedspell] + " on";
                                topmsg2[actioncount] = "@yel@" + identify.npcname[npc[i2].type];
                                actionid[actioncount] = 700;
                                actionx[actioncount] = npc[i2].x;
                                actiony[actioncount] = npc[i2].y;
                                actionvar[actioncount] = npc[i2].id;
                                actionvar2[actioncount] = selectedspell;
                                actioncount++;
                            }
                        } else
                        if(selecteditem >= 0)
                        {
                            topmsg1[actioncount] = "Use " + selecteditemname + " with";
                            topmsg2[actioncount] = "@yel@" + identify.npcname[npc[i2].type];
                            actionid[actioncount] = 710;
                            actionx[actioncount] = npc[i2].x;
                            actiony[actioncount] = npc[i2].y;
                            actionvar[actioncount] = npc[i2].id;
                            actionvar2[actioncount] = selecteditem;
                            actioncount++;
                        } else
                        {
                            if(identify.ahn[i4] > 0)
                            {
                                topmsg1[actioncount] = "Attack";
                                topmsg2[actioncount] = "@yel@" + identify.npcname[npc[i2].type] + s1;
                                if(l3 >= 0)
                                    actionid[actioncount] = 715;
                                else
                                    actionid[actioncount] = 2715;
                                actionx[actioncount] = npc[i2].x;
                                actiony[actioncount] = npc[i2].y;
                                actionvar[actioncount] = npc[i2].id;
                                actioncount++;
                            }
                            topmsg1[actioncount] = "Talk-to";
                            topmsg2[actioncount] = "@yel@" + identify.npcname[npc[i2].type];
                            actionid[actioncount] = 720;
                            actionx[actioncount] = npc[i2].x;
                            actiony[actioncount] = npc[i2].y;
                            actionvar[actioncount] = npc[i2].id;
                            actioncount++;
                            if(!identify.anb[i4].equals(""))
                            {
                                topmsg1[actioncount] = identify.anb[i4];
                                topmsg2[actioncount] = "@yel@" + identify.npcname[npc[i2].type];
                                actionid[actioncount] = 725;
                                actionx[actioncount] = npc[i2].x;
                                actiony[actioncount] = npc[i2].y;
                                actionvar[actioncount] = npc[i2].id;
                                actioncount++;
                            }
                            topmsg1[actioncount] = "Examine";
                            topmsg2[actioncount] = "@yel@" + identify.npcname[npc[i2].type];
                            actionid[actioncount] = 3700;
                            actionvar[actioncount] = npc[i2].type;
                            actioncount++;
                        }
                    }
                } else
                if(cgc1 != null && cgc1.cig >= 10000)
                {
                    int j2 = cgc1.cig - 10000;
                    int i3 = emh[j2];
                    if(!dja[j2])
                    {
                        if(selectedspell >= 0)
                        {
                            if(identify.spellid[selectedspell] == 4)
                            {
                                topmsg1[actioncount] = "Cast " + identify.spellname[selectedspell] + " on";
                                topmsg2[actioncount] = "@cya@" + identify.doorname[i3];
                                actionid[actioncount] = 300;
                                actionx[actioncount] = doorx[j2];
                                actiony[actioncount] = doory[j2];
                                actionvar[actioncount] = doordir[j2];
                                actionvar2[actioncount] = selectedspell;
                                actioncount++;
                            }
                        } else
                        if(selecteditem >= 0)
                        {
                            topmsg1[actioncount] = "Use " + selecteditemname + " with";
                            topmsg2[actioncount] = "@cya@" + identify.doorname[i3];
                            actionid[actioncount] = 310;
                            actionx[actioncount] = doorx[j2];
                            actiony[actioncount] = doory[j2];
                            actionvar[actioncount] = doordir[j2];
                            actionvar2[actioncount] = selecteditem;
                            actioncount++;
                        } else
                        {
                            if(!identify.akn[i3].equalsIgnoreCase("WalkTo"))
                            {
                                topmsg1[actioncount] = identify.akn[i3];
                                topmsg2[actioncount] = "@cya@" + identify.doorname[i3];
                                actionid[actioncount] = 320;
                                actionx[actioncount] = doorx[j2];
                                actiony[actioncount] = doory[j2];
                                actionvar[actioncount] = doordir[j2];
                                actioncount++;
                            }
                            if(!identify.ala[i3].equalsIgnoreCase("Examine"))
                            {
                                topmsg1[actioncount] = identify.ala[i3];
                                topmsg2[actioncount] = "@cya@" + identify.doorname[i3];
                                actionid[actioncount] = 2300;
                                actionx[actioncount] = doorx[j2];
                                actiony[actioncount] = doory[j2];
                                actionvar[actioncount] = doordir[j2];
                                actioncount++;
                            }
                            topmsg1[actioncount] = "Examine";
                            topmsg2[actioncount] = "@cya@" + identify.doorname[i3];
                            actionid[actioncount] = 3300;
                            actionvar[actioncount] = i3;
                            actioncount++;
                        }
                        dja[j2] = true;
                    }
                } else
                if(cgc1 != null && cgc1.cig >= 0)
                {
                    int k2 = cgc1.cig;
                    int j3 = mobtype[k2];
                    if(!ddi[k2])
                    {
                        if(selectedspell >= 0)
                        {
                            if(identify.spellid[selectedspell] == 5)
                            {
                                topmsg1[actioncount] = "Cast " + identify.spellname[selectedspell] + " on";
                                topmsg2[actioncount] = "@cya@" + identify.mobname[j3];
                                actionid[actioncount] = 400;
                                actionx[actioncount] = mobx[k2];
                                actiony[actioncount] = moby[k2];
                                actionvar[actioncount] = mobid[k2];
                                actionvar2[actioncount] = mobtype[k2];
                                actionvar3[actioncount] = selectedspell;
                                actioncount++;
                            }
                        } else
                        if(selecteditem >= 0)
                        {
                            topmsg1[actioncount] = "Use " + selecteditemname + " with";
                            topmsg2[actioncount] = "@cya@" + identify.mobname[j3];
                            actionid[actioncount] = 410;
                            actionx[actioncount] = mobx[k2];
                            actiony[actioncount] = moby[k2];
                            actionvar[actioncount] = mobid[k2];
                            actionvar2[actioncount] = mobtype[k2];
                            actionvar3[actioncount] = selecteditem;
                            actioncount++;
                        } else
                        {
                            if(!identify.akj[j3].equalsIgnoreCase("WalkTo"))
                            {
                                topmsg1[actioncount] = identify.akj[j3];
                                topmsg2[actioncount] = "@cya@" + identify.mobname[j3];
                                actionid[actioncount] = 420;
                                actionx[actioncount] = mobx[k2];
                                actiony[actioncount] = moby[k2];
                                actionvar[actioncount] = mobid[k2];
                                actionvar2[actioncount] = mobtype[k2];
                                actioncount++;
                            }
                            if(!identify.akk[j3].equalsIgnoreCase("Examine"))
                            {
                                topmsg1[actioncount] = identify.akk[j3];
                                topmsg2[actioncount] = "@cya@" + identify.mobname[j3];
                                actionid[actioncount] = 2400;
                                actionx[actioncount] = mobx[k2];
                                actiony[actioncount] = moby[k2];
                                actionvar[actioncount] = mobid[k2];
                                actionvar2[actioncount] = mobtype[k2];
                                actioncount++;
                            }
                            topmsg1[actioncount] = "Examine";
                            topmsg2[actioncount] = "@cya@" + identify.mobname[j3];
                            actionid[actioncount] = 3400;
                            actionvar[actioncount] = j3;
                            actioncount++;
                        }
                        ddi[k2] = true;
                    }
                } else
                {
                    if(k1 >= 0)
                        k1 = cgc1.cih[k1] - 0x30d40;
                    if(k1 >= 0)
                        j = k1;
                }
        }
        if(selectedspell >= 0 && identify.spellid[selectedspell] <= 1)
        {
            topmsg1[actioncount] = "Cast " + identify.spellname[selectedspell] + " on self";
            topmsg2[actioncount] = "";
            actionid[actioncount] = 1000;
            actionvar[actioncount] = selectedspell;
            actioncount++;
        }
        if(j != -1)
        {
            int l1 = j;
            if(selectedspell >= 0)
            {
                if(identify.spellid[selectedspell] == 6)
                {
                    topmsg1[actioncount] = "Cast " + identify.spellname[selectedspell] + " on ground";
                    topmsg2[actioncount] = "";
                    actionid[actioncount] = 900;
                    actionx[actioncount] = myplayerworld.x[l1];
                    actiony[actioncount] = myplayerworld.y[l1];
                    actionvar[actioncount] = selectedspell;
                    actioncount++;
                    return;
                }
            } else
            if(selecteditem < 0)
            {
                topmsg1[actioncount] = "Walk here";
                topmsg2[actioncount] = "";
                actionid[actioncount] = 920;
                actionx[actioncount] = myplayerworld.x[l1];
                actiony[actioncount] = myplayerworld.y[l1];
                actioncount++;
            }
        }
    }
    protected final void adf()
    {
        dmm = 0;
        displaymessage("@cya@Sorry, you can't logout at the moment", 3);
    }
    private final void fcb()
    {
        boolean flag = false;
		if((dim & 1) == 1 && ffa(dim))
			return;
		if((dim & 1) == 0 && ffa(dim))
		{
			if(ffa(dim + 1 & 7))
			{
				dim = dim + 1 & 7;
				return;
			}
			if(ffa(dim + 7 & 7))
				dim = dim + 7 & 7;
			return;
		}
		int ai[] = {
			1, -1, 2, -2, 3, -3, 4
		};
		for(int i = 0; i < 7; i++)
		{
			if(!ffa(dim + ai[i] + 8 & 7))
				continue;
			dim = dim + ai[i] + 8 & 7;
			break;
		}
		if((dim & 1) == 0 && ffa(dim))
		{
			if(ffa(dim + 1 & 7))
			{
				dim = dim + 1 & 7;
				return;
			}
			if(ffa(dim + 7 & 7))
				dim = dim + 7 & 7;
			return;
		} else
		{
			return;
		}
    }
    private final void fcc(int i, int j, int k, int l)
    {
        int i1;
        int j1;
        if(k == 0 || k == 4)
        {
            i1 = identify.ami[l];
            j1 = identify.amj[l];
        } else
        {
            j1 = identify.ami[l];
            i1 = identify.amj[l];
        }
        if(identify.amk[l] == 2 || identify.amk[l] == 3)
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
            fce(smallx, smally, i, j, (i + i1) - 1, (j + j1) - 1, false, true);
            return;
        } else
        {
            fce(smallx, smally, i, j, (i + i1) - 1, (j + j1) - 1, true, true);
            return;
        }
    }
    private final void fcd()
    {
        eij = new gca(gfx, 100);
        eij.ggj(256, 10, "Please design Your Character", 4, true);
        int i = 140;
        int j = 34;
        i += 116;
        j -= 10;
        eij.ggj(201, 134, "Front", 3, true);
        eij.ggj(256, 134, "Side", 3, true);
        eij.ggj(311, 134, "Back", 3, true);
        byte byte0 = 54;
        j += 145;
        eij.ggl(202, 169, 53, 41);
        eij.ggj(202, 161, "Head", 1, true);
        eij.ggj(202, 177, "Type", 1, true);
        eij.ggm(162, 169, gca.gfa + 7);
        ebb = eij.ghd(162, 169, 20, 20);
        eij.ggm(242, 169, gca.gfa + 6);
        ebc = eij.ghd(242, 169, 20, 20);
        eij.ggl(310, 169, 53, 41);
        eij.ggj(310, 161, "Hair", 1, true);
        eij.ggj(310, 177, "Color", 1, true);
        eij.ggm(270, 169, gca.gfa + 7);
        ebd = eij.ghd(270, 169, 20, 20);
        eij.ggm(350, 169, gca.gfa + 6);
        ebe = eij.ghd(350, 169, 20, 20);
        j += 50;
        eij.ggl(202, 219, 53, 41);
        eij.ggj(202, 219, "Gender", 1, true);
        eij.ggm(162, 219, gca.gfa + 7);
        ebf = eij.ghd(162, 219, 20, 20);
        eij.ggm(242, 219, gca.gfa + 6);
        ebg = eij.ghd(242, 219, 20, 20);
        eij.ggl(310, 219, 53, 41);
        eij.ggj(310, 211, "Top", 1, true);
        eij.ggj(310, 227, "Color", 1, true);
        eij.ggm(270, 219, gca.gfa + 7);
        ebh = eij.ghd(270, 219, 20, 20);
        eij.ggm(350, 219, gca.gfa + 6);
        ebi = eij.ghd(350, 219, 20, 20);
        j += 50;
        eij.ggl(202, 269, 53, 41);
        eij.ggj(202, 261, "Skin", 1, true);
        eij.ggj(202, 277, "Color", 1, true);
        eij.ggm(162, 269, gca.gfa + 7);
        ebj = eij.ghd(162, 269, 20, 20);
        eij.ggm(242, 269, gca.gfa + 6);
        ebk = eij.ghd(242, 269, 20, 20);
        eij.ggl(310, 269, 53, 41);
        eij.ggj(310, 261, "Bottom", 1, true);
        eij.ggj(310, 277, "Color", 1, true);
        eij.ggm(270, 269, gca.gfa + 7);
        ebl = eij.ghd(270, 269, 20, 20);
        eij.ggm(350, 269, gca.gfa + 6);
        ebm = eij.ghd(350, 269, 20, 20);
        j += 82;
        j -= 35;
        eij.ggk(256, 316, 200, 30);
        eij.ggj(256, 316, "Accept", 4, false);
        ebn = eij.ghd(256, 316, 200, 30);
    }
    private final boolean fce(int i, int j, int k, int l, int i1, int j1, boolean flag, 
            boolean flag1)
    {
        boolean flag2 = false;
        int k1 = myplayerworld.gln(i, j, k, l, i1, j1, dmh, dmi, flag);
        if(k1 == -1)
            if(flag1)
            {
                k1 = 1;
                dmh[0] = k;
                dmi[0] = l;
            } else
            {
                return false;
            }
        k1--;
        i = dmh[k1];
        j = dmi[k1];
        k1--;
        if(flag1)
            super.packets.id(135);
        else
            super.packets.id(209);
        super.packets.cmd(i + dmn);
        super.packets.cmd(j + dna);
        if(flag1 && k1 == -1 && (i + dmn) % 5 == 0)
            k1 = 0;
        for(int l1 = k1; l1 >= 0 && l1 > k1 - 25; l1--)
        {
            super.packets.var(dmh[l1] - i);
            super.packets.var(dmi[l1] - j);
        }
        super.packets.send();
        efg = -24;
        efh = super.mousex;
        efi = super.mousey;
        return true;
    }
    private final boolean fcf(int i, int j, int k, int l, int i1, int j1, boolean flag, 
            boolean flag1)
    {
        boolean flag2 = false;
        int k1 = myplayerworld.gln(i, j, k, l, i1, j1, dmh, dmi, flag);
        if(k1 == -1)
            return false;
        k1--;
        i = dmh[k1];
        j = dmi[k1];
        k1--;
        if(flag1)
            super.packets.id(135);
        else
            super.packets.id(209);
        super.packets.cmd(i + dmn);
        super.packets.cmd(j + dna);
        if(flag1 && k1 == -1 && (i + dmn) % 5 == 0)
            k1 = 0;
        for(int l1 = k1; l1 >= 0 && l1 > k1 - 25; l1--)
        {
            super.packets.var(dmh[l1] - i);
            super.packets.var(dmi[l1] - j);
        }
        super.packets.send();
        efg = -24;
        efh = super.mousex;
        efi = super.mousey;
        return true;
    }

	private int playerfromname(String name)
	{
		for (int cx = 0; cx < playercount; cx++)
		{
			if (player[cx].name != null)
			{
				if (player[cx].name.equalsIgnoreCase(name))
				{
					return player[cx].id;
				}
			}
		}
		return 0;
	}

	private int playerarrayfromid(int id)
	{
		for (int cx = 0; cx < playercount; cx++)
		{
			if (player[cx].id == id)
			{
				return cx;
			}
		}
		return 0;
	}

	private boolean onefrom(int x1, int y1, int x2, int y2)
	{
		if (between(x1, x2-1, x2+1) && between(y1, y2-1, y2+1))
		{
			return true;
		}
		return false;
	}

	private boolean between(int x, int x1, int x2)
	{
		if (x >= x1 && x <= x2)
		{
			return true;
		}
		return false;
	}
	private int absx(int x)
	{
		return (x - 64) / eic;
	}
	
	private int absy(int y)
	{
		return (y - 64) / eic;
	}

	private void autocatch()
	{
		//try
		//{
			if (playerfromname(catchname) > 0)
			{
				if (System.currentTimeMillis() - catchstate >= walktime)
				{
					int catcharray = playerarrayfromid(playerfromname(catchname));
					if (onefrom(smallx, smally, absx(player[catcharray].x), absy(player[catcharray].y)) == true)
					{
						catchstate = System.currentTimeMillis();
						faj(smallx, smally, absx(player[catcharray].x), absy(player[catcharray].y), true);
						super.packets.id(77);
						super.packets.cmd(player[catcharray].id);
						super.packets.send();
						displaymessage("Attack", 3);
					} else {
						faj(smallx, smally, absx(player[catcharray].x), absy(player[catcharray].y), false);
						catchstate = System.currentTimeMillis();            
						if(efg == -24)
							efg = 24;
					}
						
				}
			}
		//}
		//catch (Exception e) {}
	}

    private final void fcg()
    {
        boolean flag1 = false;
		//Autocatch
		if (catching == true)
		{
			autocatch();
		}

        if(dmm != 0)
            fbe();
        else
        if(dha)
            fbj();
        else
        if(dgn)
            fed();
        else
        if(emn == 1)
            drawwildernessbox();
        else
        if(dnf && edj == 0)
            fdg();
        else
        if(eec && edj == 0)
            fae();
        else
        if(dfd)
            fcj();
        else
        if(dmk)
            fck();
        else
        if(dkl)
            fai();
        else
        if(eeb)
            fbk();
        else
        if(egm == 1)
            fag();
        else
        if(egm == 2)
            fdd();
        else
        if(djc != 0)
        {
            fbh();
        } else
        {
            if(dhk)
                fbi();
            if(myplayer.hah == 8 || myplayer.hah == 9)
                fee();
            fec();
            boolean flag = !dhk && !dgi;
            if(flag)
                actioncount = 0;
            if(selectedmenu == 0 && flag)
                fca();
            if(selectedmenu == 1)
                fdf(flag);
            if(selectedmenu == 2)
                drawmap(flag);
            if(selectedmenu == 3)
                drawquestmenu(flag);
            if(selectedmenu == 4)
                fbg(flag);
            if(selectedmenu == 5)
                drawcontactsmenu(flag);
            if(selectedmenu == 6)
                enf(flag);
            if(!dgi && !dhk)
                fen();
            if(dgi && !dhk)
                fbc();
        }
        mousebutton3 = 0;
    }
    private final void fch()
    {
        boolean flag = false;
        egc = false;
        gfx.bnj = false;
        gfx.cbd();
        if(eed == 0 || eed == 1 || eed == 2 || eed == 3)
        {
            int i = (ean * 2) % 3072;
            if(i < 1024)
            {
                gfx.drawpic(0, 10, dlf);
                if(i > 768)
                    gfx.cck(0, 10, dlf + 1, i - 768);
            } else
            if(i < 2048)
            {
                gfx.drawpic(0, 10, dlf + 1);
                if(i > 1792)
                    gfx.cck(0, 10, dkn + 10, i - 1792);
            } else
            {
                gfx.drawpic(0, 10, dkn + 10);
                if(i > 2816)
                    gfx.cck(0, 10, dlf, i - 2816);
            }
        }
        if(eed == 0)
            dln.gfj();
        if(eed == 1)
            dni.gfj();
        if(eed == 2)
            djl.gfj();
        gfx.drawpic(0, eli, dkn + 22);
        gfx.cbc(dil, 0, 0);
    }
    protected final void process(int i, int j, byte abyte0[])
    {
        boolean flag4 = false;
        try
        {
            if(i == 255)
            {
                dkb = playercount;
                for(int k = 0; k < dkb; k++)
                    did[k] = player[k];
                int k7 = 8;
                smallx = fnf.gad(abyte0, 8, 11);
                k7 += 11;
                smally = fnf.gad(abyte0, 19, 13);
                k7 += 13;
                int l13 = fnf.gad(abyte0, 32, 4);
                k7 += 4;
                boolean flag1 = fej(smallx, smally);
                smallx -= dmn;
                smally -= dna;
                int l22 = smallx * eic + 64;
                int l25 = smally * eic + 64;
                if(flag1)
                {
                    myplayer.hak = 0;
                    myplayer.haj = 0;
                    myplayer.x = myplayer.hal[0] = l22;
                    myplayer.y = myplayer.ham[0] = l25;
                }
                playercount = 0;
                myplayer = fdn(ejn, l22, l25, l13);
                int i29 = fnf.gad(abyte0, 36, 8);
                k7 += 8;
                for(int l33 = 0; l33 < i29; l33++)
                {
                    monster gnm4 = did[l33 + 1];
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
                                j44 += eic;
                            if(l42 == 6 || l42 == 5 || l42 == 7)
                                j44 -= eic;
                            if(l42 == 4 || l42 == 3 || l42 == 5)
                                k44 += eic;
                            if(l42 == 0 || l42 == 1 || l42 == 7)
                                k44 -= eic;
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
                    player[playercount++] = gnm4;
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
                    int i23 = (smallx + l41) * eic + 64;
                    int i26 = (smally + j43) * eic + 64;
                    fdn(l39, i23, i26, i14);
                    if(i44 == 0)
                        dff[i37++] = l39;
                }
                if(i37 > 0)
                {
                    super.packets.id(148);
                    super.packets.cmd(i37);
                    for(int i40 = 0; i40 < i37; i40++)
                    {
                        monster gnm5 = ekm[dff[i40]];
                        super.packets.cmd(gnm5.id);
                        super.packets.cmd(gnm5.hac);
                    }
                    super.packets.send();
                    i37 = 0;
                }
                return;
            }
            if(i == 16)
            {
                for(int l = 1; l < j;)
                    if(fnf.fnl(abyte0[l]) == 255)
                    {
                        int l7 = 0;
                        int j14 = smallx + abyte0[l + 1] >> 3;
                        int i19 = smally + abyte0[l + 2] >> 3;
                        l += 3;
                        for(int j23 = 0; j23 < dfc; j23++)
                        {
                            int j26 = (djf[j23] >> 3) - j14;
                            int j29 = (djg[j23] >> 3) - i19;
                            if(j26 != 0 || j29 != 0)
                            {
                                if(j23 != l7)
                                {
                                    djf[l7] = djf[j23];
                                    djg[l7] = djg[j23];
                                    djh[l7] = djh[j23];
                                    dji[l7] = dji[j23];
                                }
                                l7++;
                            }
                        }
                        dfc = l7;
                    } else
                    {
                        int i8 = fnf.fnm(abyte0, l);
                        l += 2;
                        int k14 = smallx + abyte0[l++];
                        int j19 = smally + abyte0[l++];
                        if((i8 & 0x8000) == 0)
                        {
                            djf[dfc] = k14;
                            djg[dfc] = j19;
                            djh[dfc] = i8;
                            dji[dfc] = 0;
                            for(int k23 = 0; k23 < mobcount; k23++)
                            {
                                if(mobx[k23] != k14 || moby[k23] != j19)
                                    continue;
                                dji[dfc] = identify.aml[mobtype[k23]];
                                break;
                            }
                            dfc++;
                        } else
                        {
                            i8 &= 0x7fff;
                            int l23 = 0;
                            for(int k26 = 0; k26 < dfc; k26++)
                                if(djf[k26] != k14 || djg[k26] != j19 || djh[k26] != i8)
                                {
                                    if(k26 != l23)
                                    {
                                        djf[l23] = djf[k26];
                                        djg[l23] = djg[k26];
                                        djh[l23] = djh[k26];
                                        dji[l23] = dji[k26];
                                    }
                                    l23++;
                                } else
                                {
                                    i8 = -123;
                                }
                            dfc = l23;
                        }
                    }
                return;
            }
            if(i == 122)
            {
                for(int i1 = 1; i1 < j;)
                    if(fnf.fnl(abyte0[i1]) == 255)
                    {
                        int j8 = 0;
                        int l14 = smallx + abyte0[i1 + 1] >> 3;
                        int k19 = smally + abyte0[i1 + 2] >> 3;
                        i1 += 3;
                        for(int i24 = 0; i24 < mobcount; i24++)
                        {
                            int l26 = (mobx[i24] >> 3) - l14;
                            int k29 = (moby[i24] >> 3) - k19;
                            if(l26 != 0 || k29 != 0)
                            {
                                if(i24 != j8)
                                {
                                    emm[j8] = emm[i24];
                                    emm[j8].cig = j8;
                                    mobx[j8] = mobx[i24];
                                    moby[j8] = moby[i24];
                                    mobtype[j8] = mobtype[i24];
                                    mobid[j8] = mobid[i24];
                                }
                                j8++;
                            } else
                            {
                                egn.bhe(emm[i24]);
                                myplayerworld.gmm(mobx[i24], moby[i24], mobtype[i24]);
                            }
                        }
                        mobcount = j8;
                    } else
                    {
                        int k8 = fnf.fnm(abyte0, i1);
                        i1 += 2;
                        int i15 = smallx + abyte0[i1++];
                        int l19 = smally + abyte0[i1++];
                        int j24 = 0;
                        for(int i27 = 0; i27 < mobcount; i27++)
                            if(mobx[i27] != i15 || moby[i27] != l19)
                            {
                                if(i27 != j24)
                                {
                                    emm[j24] = emm[i27];
                                    emm[j24].cig = j24;
                                    mobx[j24] = mobx[i27];
                                    moby[j24] = moby[i27];
                                    mobtype[j24] = mobtype[i27];
                                    mobid[j24] = mobid[i27];
                                }
                                j24++;
                            } else
                            {
                                egn.bhe(emm[i27]);
                                myplayerworld.gmm(mobx[i27], moby[i27], mobtype[i27]);
                            }
                        mobcount = j24;
                        if(k8 != 60000)
                        {
                            int l29 = myplayerworld.glg(i15, l19);
                            int i34;
                            int j37;
                            if(l29 == 0 || l29 == 4)
                            {
                                i34 = identify.ami[k8];
                                j37 = identify.amj[k8];
                            } else
                            {
                                j37 = identify.ami[k8];
                                i34 = identify.amj[k8];
                            }
                            int j40 = ((i15 + i15 + i34) * eic) / 2;
                            int i42 = ((l19 + l19 + j37) * eic) / 2;
                            int k43 = identify.amh[k8];
                            cgc cgc2 = eaj[k43].daf();
                            egn.bhd(cgc2);
                            cgc2.cig = mobcount;
                            cgc2.cne(0, l29 * 32, 0);
                            cgc2.cng(j40, -myplayerworld.gnb(j40, i42),i42); //2), i42);
                            cgc2.cna(true, 48, 48, -50, -10, -50);
                            myplayerworld.glc(i15, l19, k8);
                            if(k8 == 74)
                                cgc2.cng(0, -480, 0);
                            mobx[mobcount] = i15;
                            moby[mobcount] = l19;
                            mobtype[mobcount] = k8;
                            mobid[mobcount] = l29;
                            emm[mobcount++] = cgc2;
                        }
                    }
                return;
            }
            if(i == 99)
            {
                int j1 = 1;
                j1++;
                invcount = abyte0[1] & 0xff;
                for(int l8 = 0; l8 < invcount; l8++)
                {
                    int j15 = fnf.fnm(abyte0, j1);
                    j1 += 2;
                    inventory[l8] = j15 & 0x7fff;
                    end[l8] = j15 / 32768;
                    if(identify.ajf[j15 & 0x7fff] == 0)
                    {
                        enc[l8] = fnf.gac(abyte0, j1);
                        if(enc[l8] >= 128)
                            j1 += 4;
                        else
                            j1++;
                    } else
                    {
                        enc[l8] = 1;
                    }
                }
                return;
            }
            if(i == 106)
            {
                int k1 = fnf.fnm(abyte0, 1);
                int i9 = 3;
                for(int k15 = 0; k15 < k1; k15++)
                {
                    int i20 = fnf.fnm(abyte0, i9);
                    i9 += 2;
                    monster gnm1 = ekm[i20];
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
                                displaymessage(gnm1.name + ": " + gnm1.hba, 2);
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
                            if(gnm1 == myplayer)
                            {
                                curstat[3] = j34;
                                stat[3] = k37;
                                dha = false;
                                dgn = false;
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
                            gnm1.hcc = ehm;
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
                            gnm1.hcc = ehm;
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
                            gnm1.name = fnf.gah(gnm1.gnn);
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
                            gnm1.level = abyte0[i9++] & 0xff;
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
                            if(gnm1 == myplayer)
                                displaymessage(gnm1.name + ": " + gnm1.hba, 5);
                        }
                        i9 += byte8;
                    }
                }
                return;
            }
            if(i == 118)
            {
                for(int l1 = 1; l1 < j;)
                    if(fnf.fnl(abyte0[l1]) == 255)
                    {
                        int j9 = 0;
                        int l15 = smallx + abyte0[l1 + 1] >> 3;
                        int j20 = smally + abyte0[l1 + 2] >> 3;
                        l1 += 3;
                        for(int k24 = 0; k24 < eim; k24++)
                        {
                            int j27 = (doorx[k24] >> 3) - l15;
                            int k31 = (doory[k24] >> 3) - j20;
                            if(j27 != 0 || k31 != 0)
                            {
                                if(k24 != j9)
                                {
                                    emf[j9] = emf[k24];
                                    emf[j9].cig = j9 + 10000;
                                    doorx[j9] = doorx[k24];
                                    doory[j9] = doory[k24];
                                    doordir[j9] = doordir[k24];
                                    emh[j9] = emh[k24];
                                }
                                j9++;
                            } else
                            {
                                egn.bhe(emf[k24]);
                                myplayerworld.gle(doorx[k24], doory[k24], doordir[k24], emh[k24]);
                            }
                        }
                        eim = j9;
                    } else
                    {
                        int k9 = fnf.fnm(abyte0, l1);
                        l1 += 2;
                        int i16 = smallx + abyte0[l1++];
                        int k20 = smally + abyte0[l1++];
                        byte byte5 = abyte0[l1++];
                        int k27 = 0;
                        for(int l31 = 0; l31 < eim; l31++)
                            if(doorx[l31] != i16 || doory[l31] != k20 || doordir[l31] != byte5)
                            {
                                if(l31 != k27)
                                {
                                    emf[k27] = emf[l31];
                                    emf[k27].cig = k27 + 10000;
                                    doorx[k27] = doorx[l31];
                                    doory[k27] = doory[l31];
                                    doordir[k27] = doordir[l31];
                                    emh[k27] = emh[l31];
                                }
                                k27++;
                            } else
                            {
                                egn.bhe(emf[l31]);
                                myplayerworld.gle(doorx[l31], doory[l31], doordir[l31], emh[l31]);
                            }
                        eim = k27;
                        if(k9 != 65535)
                        {
                            myplayerworld.gli(i16, k20, byte5, k9);
                            cgc cgc1 = fah(i16, k20, byte5, k9, eim);
                            emf[eim] = cgc1;
                            doorx[eim] = i16;
                            doory[eim] = k20;
                            emh[eim] = k9;
                            doordir[eim++] = byte5;
                        }
                    }
                return;
            }
            if(i == 234)
            {
                ehe = ehd;
                ehd = 0;
                for(int i2 = 0; i2 < ehe; i2++)
                    dnj[i2] = npc[i2];
                int l9 = 8;
                int j16 = fnf.gad(abyte0, 8, 8);
                l9 += 8;
                for(int l20 = 0; l20 < j16; l20++)
                {
                    monster gnm2 = dnj[l20];
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
                                l40 += eic;
                            if(j35 == 6 || j35 == 5 || j35 == 7)
                                l40 -= eic;
                            if(j35 == 4 || j35 == 3 || j35 == 5)
                                j42 += eic;
                            if(j35 == 0 || j35 == 1 || j35 == 7)
                                j42 -= eic;
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
                    npc[ehd++] = gnm2;
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
                    int j38 = (smallx + i28) * eic + 64;
                    int i41 = (smally + j32) * eic + 64;
                    int k42 = fnf.gad(abyte0, l9, 10);
                    l9 += 10;
                    if(k42 >= identify.ang)
                        k42 = 24;
                    feh(l24, j38, i41, l35, k42);
                }
                return;
            }
            if(i == 65)
            {
                int j2 = fnf.fnm(abyte0, 1);
                int i10 = 3;
                for(int k16 = 0; k16 < j2; k16++)
                {
                    int i21 = fnf.fnm(abyte0, i10);
                    i10 += 2;
                    monster gnm3 = eab[i21];
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
                            if(k32 == myplayer.id)
                                displaymessage("@yel@" + identify.npcname[gnm3.type] + ": " + gnm3.hba, 5);
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
            if(i == 108)
            {
                dhk = true;
                int k2 = fnf.fnl(abyte0[1]);
                ddl = k2;
                int j10 = 2;
                for(int l16 = 0; l16 < k2; l16++)
                {
                    int j21 = fnf.fnl(abyte0[j10]);
                    j10++;
                    ece[l16] = new String(abyte0, j10, j21);
                    j10 += j21;
                }
                return;
            }
            if(i == 150)
            {
                dhk = false;
                return;
            }
            if(i == 102)
            {
                dea = true;
                ejn = fnf.fnm(abyte0, 1);
                eda = fnf.fnm(abyte0, 3);
                edb = fnf.fnm(abyte0, 5);
                dnb = fnf.fnm(abyte0, 7);
                edc = fnf.fnm(abyte0, 9);
                edb -= dnb * edc;
                return;
            }
            if(i == 178)
            {
                int l2 = 1;
                for(int k10 = 0; k10 < 18; k10++)
                    curstat[k10] = fnf.fnl(abyte0[l2++]);
                for(int i17 = 0; i17 < 18; i17++)
                    stat[i17] = fnf.fnl(abyte0[l2++]);
                for(int k21 = 0; k21 < 18; k21++)
                {
                    dnh[k21] = fnf.fnn(abyte0, l2);
                    l2 += 4;
                }
                dic = fnf.fnl(abyte0[l2++]);
                return;
            }
            if(i == 193)
            {
                for(int i3 = 0; i3 < 5; i3++)
                    efe[i3] = fnf.fnl(abyte0[1 + i3]);
                return;
            }
            if(i == 92)
            {
                ecj = 250;
                return;
            }
            if(i == 75)
            {
                int j3 = (j - 1) / 4;
                for(int l10 = 0; l10 < j3; l10++)
                {
                    int j17 = smallx + fnf.gab(abyte0, 1 + l10 * 4) >> 3;
                    int l21 = smally + fnf.gab(abyte0, 3 + l10 * 4) >> 3;
                    int i25 = 0;
                    for(int k28 = 0; k28 < dfc; k28++)
                    {
                        int i33 = (djf[k28] >> 3) - j17;
                        int j36 = (djg[k28] >> 3) - l21;
                        if(i33 != 0 || j36 != 0)
                        {
                            if(k28 != i25)
                            {
                                djf[i25] = djf[k28];
                                djg[i25] = djg[k28];
                                djh[i25] = djh[k28];
                                dji[i25] = dji[k28];
                            }
                            i25++;
                        }
                    }
                    dfc = i25;
                    i25 = 0;
                    for(int j33 = 0; j33 < mobcount; j33++)
                    {
                        int k36 = (mobx[j33] >> 3) - j17;
                        int l38 = (moby[j33] >> 3) - l21;
                        if(k36 != 0 || l38 != 0)
                        {
                            if(j33 != i25)
                            {
                                emm[i25] = emm[j33];
                                emm[i25].cig = i25;
                                mobx[i25] = mobx[j33];
                                moby[i25] = moby[j33];
                                mobtype[i25] = mobtype[j33];
                                mobid[i25] = mobid[j33];
                            }
                            i25++;
                        } else
                        {
                            egn.bhe(emm[j33]);
                            myplayerworld.gmm(mobx[j33], moby[j33], mobtype[j33]);
                        }
                    }
                    mobcount = i25;
                    i25 = 0;
                    for(int l36 = 0; l36 < eim; l36++)
                    {
                        int i39 = (doorx[l36] >> 3) - j17;
                        int j41 = (doory[l36] >> 3) - l21;
                        if(i39 != 0 || j41 != 0)
                        {
                            if(l36 != i25)
                            {
                                emf[i25] = emf[l36];
                                emf[i25].cig = i25 + 10000;
                                doorx[i25] = doorx[l36];
                                doory[i25] = doory[l36];
                                doordir[i25] = doordir[l36];
                                emh[i25] = emh[l36];
                            }
                            i25++;
                        } else
                        {
                            egn.bhe(emf[l36]);
                            myplayerworld.gle(doorx[l36], doory[l36], doordir[l36], emh[l36]);
                        }
                    }
                    eim = i25;
                }
                return;
            }
            if(i == 11)
            {
                edf = true;
                return;
            }
            if(i == 223)
            {
                int k3 = fnf.fnm(abyte0, 1);
                if(ekm[k3] != null)
                    dnm = ekm[k3].name;
                dmk = true;
                eal = false;
                eam = false;
                dkg = 0;
                dlh = 0;
                return;
            }
            if(i == 27)
            {
                dmk = false;
                dfd = false;
                return;
            }
            if(i == 232)
            {
                dlh = abyte0[1] & 0xff;
                int l3 = 2;
                for(int i11 = 0; i11 < dlh; i11++)
                {
                    dli[i11] = fnf.fnm(abyte0, l3);
                    l3 += 2;
                    dlj[i11] = fnf.fnn(abyte0, l3);
                    l3 += 4;
                }
                eal = false;
                eam = false;
                return;
            }
            if(i == 59)
            {
                byte byte0 = abyte0[1];
                if(byte0 == 1)
                {
                    eal = true;
                    return;
                } else
                {
                    eal = false;
                    return;
                }
            }
            if(i == 83)
            {
                eec = true;
                int i4 = 1;
                i4++;
                int j11 = abyte0[1] & 0xff;
                i4++;
                byte byte4 = abyte0[2];
                i4++;
                efb = abyte0[3] & 0xff;
                i4++;
                efc = abyte0[4] & 0xff;
                for(int i22 = 0; i22 < 40; i22++)
                    efm[i22] = -1;
                for(int j25 = 0; j25 < j11; j25++)
                {
                    efm[j25] = fnf.fnm(abyte0, i4);
                    i4 += 2;
                    efn[j25] = fnf.fnm(abyte0, i4);
                    i4 += 2;
                    ega[j25] = abyte0[i4++];
                }
                if(byte4 == 1)
                {
                    int l28 = 39;
                    for(int k33 = 0; k33 < invcount; k33++)
                    {
                        if(l28 < j11)
                            break;
                        boolean flag2 = false;
                        for(int j39 = 0; j39 < 40; j39++)
                        {
                            if(efm[j39] != inventory[k33])
                                continue;
                            flag2 = true;
                            break;
                        }
                        if(inventory[k33] == 10)
                            flag2 = true;
                        if(!flag2)
                        {
                            efm[l28] = inventory[k33] & 0x7fff;
                            efn[l28] = 0;
                            ega[l28] = 0;
                            l28--;
                        }
                    }
                }
                if(dhc >= 0 && dhc < 40 && efm[dhc] != dhd)
                {
                    dhc = -1;
                    dhd = -2;
                }
                return;
            }
            if(i == 90)
            {
                eec = false;
                return;
            }
            if(i == 125)
            {
                byte byte1 = abyte0[1];
                if(byte1 == 1)
                {
                    eam = true;
                    return;
                } else
                {
                    eam = false;
                    return;
                }
            }
            if(i == 151)
            {
                autocam = fnf.fnl(abyte0[1]) == 1;
                twomousebuttons = fnf.fnl(abyte0[2]) == 1;
                soundeffects = fnf.fnl(abyte0[3]) == 1;
                return;
            }
            if(i == 84)
            {
                for(int j4 = 0; j4 < j - 1; j4++)
                {
                    boolean flag = abyte0[j4 + 1] == 1;
                    if(!djb[j4] && flag)
                        fbm("prayeron");
                    if(djb[j4] && !flag)
                        fbm("prayeroff");
                    djb[j4] = flag;
                }
                return;
            }
            if(i == 71)
            {
                for(int k4 = 0; k4 < 50; k4++)
                    dfm[k4] = abyte0[k4 + 1] == 1;
                return;
            }
            if(i == 39)
            {
                dnf = true;
                int l4 = 1;
                l4++;
                ehk = abyte0[1] & 0xff;
                l4++;
                elf = abyte0[2] & 0xff;
                for(int k11 = 0; k11 < ehk; k11++)
                {
                    eag[k11] = fnf.fnm(abyte0, l4);
                    l4 += 2;
                    eah[k11] = fnf.gac(abyte0, l4);
                    if(eah[k11] >= 128)
                        l4 += 4;
                    else
                        l4++;
                }
                fac();
                return;
            }
            if(i == 196)
            {
                dnf = false;
                return;
            }
            if(i == 174)
            {
                int i5 = abyte0[1] & 0xff;
                dnh[i5] = fnf.fnn(abyte0, 2);
                return;
            }
            if(i == 233)
            {
                int j5 = fnf.fnm(abyte0, 1);
                if(ekm[j5] != null)
                    dfn = ekm[j5].name;
                eeb = true;
                dme = 0;
                ecb = 0;
                dma = false;
                dmb = false;
                dem = false;
                den = false;
                dfa = false;
                dfb = false;
                return;
            }
            if(i == 111)
            {
                eeb = false;
                dkl = false;
                return;
            }
            if(i == 67)
            {
                dfd = true;
                dfe = false;
                dmk = false;
                int k5 = 1;
                dhb = fnf.gaa(abyte0, 1);
                k5 += 8;
                k5++;
                ege = abyte0[9] & 0xff;
                for(int l11 = 0; l11 < ege; l11++)
                {
                    egf[l11] = fnf.fnm(abyte0, k5);
                    k5 += 2;
                    egg[l11] = fnf.fnn(abyte0, k5);
                    k5 += 4;
                }
                egi = abyte0[k5++] & 0xff;
                for(int k17 = 0; k17 < egi; k17++)
                {
                    egj[k17] = fnf.fnm(abyte0, k5);
                    k5 += 2;
                    egk[k17] = fnf.fnn(abyte0, k5);
                    k5 += 4;
                }
                return;
            }
            if(i == 198)
            {
                ecb = abyte0[1] & 0xff;
                int l5 = 2;
                for(int i12 = 0; i12 < ecb; i12++)
                {
                    ecc[i12] = fnf.fnm(abyte0, l5);
                    l5 += 2;
                    ecd[i12] = fnf.fnn(abyte0, l5);
                    l5 += 4;
                }
                dma = false;
                dmb = false;
                return;
            }
            if(i == 180)
            {
                if(abyte0[1] == 1)
                    dem = true;
                else
                    dem = false;
                if(abyte0[2] == 1)
                    den = true;
                else
                    den = false;
                if(abyte0[3] == 1)
                    dfa = true;
                else
                    dfa = false;
                if(abyte0[4] == 1)
                    dfb = true;
                else
                    dfb = false;
                dma = false;
                dmb = false;
                return;
            }
            if(i == 17)
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
                    ehk--;
                    for(int k25 = j12; k25 < ehk; k25++)
                    {
                        eag[k25] = eag[k25 + 1];
                        eah[k25] = eah[k25 + 1];
                    }
                } else
                {
                    eag[j12] = l17;
                    eah[j12] = j22;
                    if(j12 >= ehk)
                        ehk = j12 + 1;
                }
                fac();
                return;
            }
            if(i == 173)
            {
                int j6 = 1;
                int k12 = 1;
                j6++;
                int i18 = abyte0[1] & 0xff;
                int k22 = fnf.fnm(abyte0, 2);
                j6 += 2;
                if(identify.ajf[k22 & 0x7fff] == 0)
                {
                    k12 = fnf.gac(abyte0, 4);
                    if(k12 >= 128)
                        j6 += 4;
                    else
                        j6++;
                }
                inventory[i18] = k22 & 0x7fff;
                end[i18] = k22 / 32768;
                enc[i18] = k12;
                if(i18 >= invcount)
                    invcount = i18 + 1;
                return;
            }
            if(i == 145)
            {
                int k6 = abyte0[1] & 0xff;
                invcount--;
                for(int l12 = k6; l12 < invcount; l12++)
                {
                    inventory[l12] = inventory[l12 + 1];
                    enc[l12] = enc[l12 + 1];
                    end[l12] = end[l12 + 1];
                }
                return;
            }
            if(i == 129)
            {
                int l6 = 1;
                l6++;
                int i13 = abyte0[1] & 0xff;
                l6++;
                curstat[i13] = fnf.fnl(abyte0[2]);
                l6++;
                stat[i13] = fnf.fnl(abyte0[3]);
                dnh[i13] = fnf.fnn(abyte0, 4);
                l6 += 4;
                return;
            }
            if(i == 78)
            {
                byte byte2 = abyte0[1];
                if(byte2 == 1)
                {
                    dma = true;
                    return;
                } else
                {
                    dma = false;
                    return;
                }
            }
            if(i == 130)
            {
                byte byte3 = abyte0[1];
                if(byte3 == 1)
                {
                    dmb = true;
                    return;
                } else
                {
                    dmb = false;
                    return;
                }
            }
            if(i == 47)
            {
                dkl = true;
                dkm = false;
                eeb = false;
                int i7 = 1;
                ekh = fnf.gaa(abyte0, 1);
                i7 += 8;
                i7++;
                ead = abyte0[9] & 0xff;
                for(int j13 = 0; j13 < ead; j13++)
                {
                    eae[j13] = fnf.fnm(abyte0, i7);
                    i7 += 2;
                    eaf[j13] = fnf.fnn(abyte0, i7);
                    i7 += 4;
                }
                dkd = abyte0[i7++] & 0xff;
                for(int j18 = 0; j18 < dkd; j18++)
                {
                    dke[j18] = fnf.fnm(abyte0, i7);
                    i7 += 2;
                    dkf[j18] = fnf.fnn(abyte0, i7);
                    i7 += 4;
                }
                dhg = abyte0[i7++] & 0xff;
                dhh = abyte0[i7++] & 0xff;
                dhi = abyte0[i7++] & 0xff;
                dhj = abyte0[i7++] & 0xff;
                return;
            }
            if(i == 8)
            {
                String s = new String(abyte0, 1, j - 1);
                fbm(s);
                return;
            }
            if(i == 219)
            {
                if(ede < 50)
                {
                    int j7 = abyte0[1] & 0xff;
                    int k13 = abyte0[2] + smallx;
                    int k18 = abyte0[3] + smally;
                    ejf[ede] = j7;
                    eba[ede] = 0;
                    dga[ede] = k13;
                    ehi[ede] = k18;
                    ede++;
                }
                return;
            }
            if(i == 152)
            {
                if(!egc)
                {
                    elk = fnf.fnn(abyte0, 1);
                    dik = fnf.fnm(abyte0, 5);
                    efd = abyte0[7] & 0xff;
                    dnc = fnf.fnm(abyte0, 8);
                    dha = true;
                    egc = true;
                    edn = null;
                }
                return;
            }
            if(i == 128)
            {
                ddf = new String(abyte0, 1, j - 1);
                dgn = true;
                eeh = false;
                return;
            }
            if(i == 77)
            {
                ddf = new String(abyte0, 1, j - 1);
                dgn = true;
                eeh = true;
                return;
            }
            if(i == 149)
            {
                eja = fnf.fnm(abyte0, 1);
                return;
            }
            if(i == 253)
            {
                if(!ddj)
                    ejb = eja;
                ddj = true;
                super.fln = "";
                super.fma = "";
                gfx.ccd(dld + 1, abyte0);
                dia = null;
                return;
            }
            if(i == 138)
            {
                ejb = fnf.fnm(abyte0, 1);
                return;
            }
            if(i == 109)
            {
                ddj = false;
                return;
            }
            if(i == 61)
            {
                dia = "Incorrect - Please wait...";
                return;
            }
            if(i == 190)
            {
                ecf = fnf.fnm(abyte0, 1) * 32;
                return;
            }
        }
        catch(RuntimeException runtimeexception)
        {
            if(dnd < 3)
            {
                super.packets.id(206);
                super.packets.hen(runtimeexception.toString());
                super.packets.send();
                super.packets.id(206);
                super.packets.hen("p-type:" + i + " p-size:" + j);
                super.packets.send();
                super.packets.id(206);
                super.packets.hen("rx:" + smallx + " ry:" + smally + " num3l:" + mobcount);
                super.packets.send();
                String s1 = "";
                for(int l18 = 0; l18 < 80 && l18 < j; l18++)
                    s1 = s1 + abyte0[l18] + " ";
                super.packets.id(206);
                super.packets.hen(s1);
                super.packets.send();
                dnd++;
            }
        }
    }
    protected final void fci(Runnable runnable)
    {
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();
    }
    private final void fcj()
    {
        boolean flag = false;
        byte byte0 = 22;
        byte byte1 = 36;
        gfx.drawbox(22, 36, 468, 16, 192);
        int i = 0x989898;
        gfx.transparentbox(22, 52, 468, 246, 0x989898, 160);
        gfx.drawcenteredtext("Please confirm your trade with @yel@" + fnf.gah(dhb), 256, 48, 1, 0xffffff);
        gfx.drawcenteredtext("You are about to give:", 139, 66, 1, 0xffff00);
        for(int j = 0; j < egi; j++)
        {
            String s = identify.itemname[egj[j]];
            if(identify.ajf[egj[j]] == 0)
                s = s + " x " + fal(egk[j]);
            gfx.drawcenteredtext(s, 139, 78 + j * 12, 1, 0xffffff);
        }
        if(egi == 0)
            gfx.drawcenteredtext("Nothing!", 139, 78, 1, 0xffffff);
        gfx.drawcenteredtext("In return you will receive:", 373, 66, 1, 0xffff00);
        for(int k = 0; k < ege; k++)
        {
            String s1 = identify.itemname[egf[k]];
            if(identify.ajf[egf[k]] == 0)
                s1 = s1 + " x " + fal(egg[k]);
            gfx.drawcenteredtext(s1, 373, 78 + k * 12, 1, 0xffffff);
        }
        if(ege == 0)
            gfx.drawcenteredtext("Nothing!", 373, 78, 1, 0xffffff);
        gfx.drawcenteredtext("Are you sure you want to do this?", 256, 236, 4, 65535);
        gfx.drawcenteredtext("There is NO WAY to reverse a trade if you change your mind.", 256, 251, 1, 0xffffff);
        gfx.drawcenteredtext("Remember that not all players are trustworthy", 256, 266, 1, 0xffffff);
        if(!dfe)
        {
            gfx.drawpic(105, 274, dkn + 25);
            gfx.drawpic(339, 274, dkn + 26);
        } else
        {
            gfx.drawcenteredtext("Waiting for other player...", 256, 286, 1, 0xffff00);
        }
        if(mousebutton3 == 1)
        {
            if(super.mousex < 22 || super.mousey < 36 || super.mousex > 490 || super.mousey > 298)
            {
                dfd = false;
                super.packets.id(255);
                super.packets.send();
            }
            if(super.mousex >= 105 && super.mousex <= 210 && super.mousey >= 274 && super.mousey <= 295)
            {
                dfe = true;
                super.packets.id(47);
                super.packets.send();
            }
            if(super.mousex >= 339 && super.mousex <= 445 && super.mousey >= 274 && super.mousey <= 295)
            {
                dfd = false;
                super.packets.id(255);
                super.packets.send();
            }
            mousebutton3 = 0;
        }
    }
    private final void fck()
    {
        boolean flag1 = false;
        if(mousebutton3 != 0 && ecl == 0)
            ecl = 1;
        if(ecl > 0)
        {
            int i = super.mousex - 22;
            int j = super.mousey - 36;
            if(i >= 0 && j >= 0 && i < 468 && j < 262)
            {
                if(i > 216 && j > 30 && i < 462 && j < 235)
                {
                    int k = (i - 217) / 49 + ((j - 31) / 34) * 5;
                    if(k >= 0 && k < invcount)
                    {
                        boolean flag = false;
                        int l1 = 0;
                        int k2 = inventory[k];
                        for(int k3 = 0; k3 < dkg; k3++)
                            if(dkh[k3] == k2)
                                if(identify.ajf[k2] == 0)
                                {
                                    for(int i4 = 0; i4 < ecl; i4++)
                                    {
                                        if(dki[k3] < enc[k])
                                            dki[k3]++;
                                        flag = true;
                                    }
                                } else
                                {
                                    l1++;
                                }
                        if(fdm(k2) <= l1)
                            flag = true;
                        if(identify.ajj[k2] == 1)
                        {
                            displaymessage("This object cannot be traded with other players", 3);
                            flag = true;
                        }
                        if(!flag && dkg < 12)
                        {
                            dkh[dkg] = k2;
                            dki[dkg] = 1;
                            dkg++;
                            flag = true;
                        }
                        if(flag)
                        {
                            super.packets.id(124);
                            super.packets.var(dkg);
                            for(int j4 = 0; j4 < dkg; j4++)
                            {
                                super.packets.cmd(dkh[j4]);
                                super.packets.hfi(dki[j4]);
                            }
                            super.packets.send();
                            eal = false;
                            eam = false;
                        }
                    }
                }
                if(i > 8 && j > 30 && i < 205 && j < 133)
                {
                    int l = (i - 9) / 49 + ((j - 31) / 34) * 4;
                    if(l >= 0 && l < dkg)
                    {
                        int j1 = dkh[l];
                        for(int i2 = 0; i2 < ecl; i2++)
                        {
                            if(identify.ajf[j1] == 0 && dki[l] > 1)
                            {
                                dki[l]--;
                                continue;
                            }
                            dkg--;
                            eck = 0;
                            for(int l2 = l; l2 < dkg; l2++)
                            {
                                dkh[l2] = dkh[l2 + 1];
                                dki[l2] = dki[l2 + 1];
                            }
                            break;
                        }
                        super.packets.id(124);
                        super.packets.var(dkg);
                        for(int i3 = 0; i3 < dkg; i3++)
                        {
                            super.packets.cmd(dkh[i3]);
                            super.packets.hfi(dki[i3]);
                        }
                        super.packets.send();
                        eal = false;
                        eam = false;
                    }
                }
                if(i >= 217 && j >= 238 && i <= 286 && j <= 259)
                {
                    eam = true;
                    super.packets.id(239);
                    super.packets.send();
                }
                if(i >= 394 && j >= 238 && i < 463 && j < 259)
                {
                    dmk = false;
                    super.packets.id(255);
                    super.packets.send();
                }
            } else
            if(mousebutton3 != 0)
            {
                dmk = false;
                super.packets.id(255);
                super.packets.send();
            }
            mousebutton3 = 0;
            ecl = 0;
        }
        if(!dmk)
            return;
        byte byte0 = 22;
        byte byte1 = 36;
        gfx.drawbox(22, 36, 468, 12, 192);
        int i1 = 0x989898;
        gfx.transparentbox(22, 48, 468, 18, 0x989898, 160);
        gfx.transparentbox(22, 66, 8, 248, 0x989898, 160);
        gfx.transparentbox(227, 66, 11, 248, 0x989898, 160);
        gfx.transparentbox(484, 66, 6, 248, 0x989898, 160);
        gfx.transparentbox(30, 169, 197, 22, 0x989898, 160);
        gfx.transparentbox(30, 294, 197, 20, 0x989898, 160);
        gfx.transparentbox(238, 271, 246, 43, 0x989898, 160);
        int k1 = 0xd0d0d0;
        gfx.transparentbox(30, 66, 197, 103, 0xd0d0d0, 160);
        gfx.transparentbox(30, 191, 197, 103, 0xd0d0d0, 160);
        gfx.transparentbox(238, 66, 246, 205, 0xd0d0d0, 160);
        for(int j2 = 0; j2 < 4; j2++)
            gfx.cbj(30, 66 + j2 * 34, 197, 0);
        for(int j3 = 0; j3 < 4; j3++)
            gfx.cbj(30, 191 + j3 * 34, 197, 0);
        for(int l3 = 0; l3 < 7; l3++)
            gfx.cbj(238, 66 + l3 * 34, 246, 0);
        for(int k4 = 0; k4 < 6; k4++)
        {
            if(k4 < 5)
                gfx.cbk(30 + k4 * 49, 66, 103, 0);
            if(k4 < 5)
                gfx.cbk(30 + k4 * 49, 191, 103, 0);
            gfx.cbk(238 + k4 * 49, 66, 205, 0);
        }
        gfx.drawtext("Trading with: " + dnm, 23, 46, 1, 0xffffff);
        gfx.drawtext("Your Offer", 31, 63, 4, 0xffffff);
        gfx.drawtext("Opponent's Offer", 31, 188, 4, 0xffffff);
        gfx.drawtext("Your Inventory", 238, 63, 4, 0xffffff);
        if(!eam)
            gfx.drawpic(239, 274, dkn + 25);
        gfx.drawpic(416, 274, dkn + 26);
        if(eal)
        {
            gfx.drawcenteredtext("Other player", 363, 282, 1, 0xffffff);
            gfx.drawcenteredtext("has accepted", 363, 292, 1, 0xffffff);
        }
        if(eam)
        {
            gfx.drawcenteredtext("Waiting for", 274, 282, 1, 0xffffff);
            gfx.drawcenteredtext("other player", 274, 292, 1, 0xffffff);
        }
        for(int l4 = 0; l4 < invcount; l4++)
        {
            int i5 = 239 + (l4 % 5) * 49;
            int k5 = 67 + (l4 / 5) * 34;
            gfx.cdk(i5, k5, 48, 32, dlb + identify.ajd[inventory[l4]], identify.aji[inventory[l4]], 0, 0, false);
            if(identify.ajf[inventory[l4]] == 0)
                gfx.drawtext(String.valueOf(enc[l4]), i5 + 1, k5 + 10, 1, 0xffff00);
        }
        for(int j5 = 0; j5 < dkg; j5++)
        {
            int l5 = 31 + (j5 % 4) * 49;
            int j6 = 67 + (j5 / 4) * 34;
            gfx.cdk(l5, j6, 48, 32, dlb + identify.ajd[dkh[j5]], identify.aji[dkh[j5]], 0, 0, false);
            if(identify.ajf[dkh[j5]] == 0)
                gfx.drawtext(String.valueOf(dki[j5]), l5 + 1, j6 + 10, 1, 0xffff00);
            if(super.mousex > l5 && super.mousex < l5 + 48 && super.mousey > j6 && super.mousey < j6 + 32)
                gfx.drawtext(identify.itemname[dkh[j5]] + ": @whi@" + identify.amc[dkh[j5]], 30, 309, 1, 0xffff00);
        }
        for(int i6 = 0; i6 < dlh; i6++)
        {
            int k6 = 31 + (i6 % 4) * 49;
            int l6 = 192 + (i6 / 4) * 34;
            gfx.cdk(k6, l6, 48, 32, dlb + identify.ajd[dli[i6]], identify.aji[dli[i6]], 0, 0, false);
            if(identify.ajf[dli[i6]] == 0)
                gfx.drawtext(String.valueOf(dlj[i6]), k6 + 1, l6 + 10, 1, 0xffff00);
            if(super.mousex > k6 && super.mousex < k6 + 48 && super.mousey > l6 && super.mousey < l6 + 32)
                gfx.drawtext(identify.itemname[dli[i6]] + ": @whi@" + identify.amc[dli[i6]], 30, 309, 1, 0xffff00);
        }
    }
    private final void fcl()
    {
        gfx.drawpic(0, eli - 4, dkn + 23);
        int i = 0xc8c8ff;
        if(een == 0)
            i = 0xffc832;
        if(eki % 30 > 15)
            i = 0xff3232;
        gfx.drawcenteredtext("All messages", 54, eli + 6, 0, i);
        i = 0xc8c8ff;
        if(een == 1)
            i = 0xffc832;
        if(ekj % 30 > 15)
            i = 0xff3232;
        gfx.drawcenteredtext("Chat history", 155, eli + 6, 0, i);
        i = 0xc8c8ff;
        if(een == 2)
            i = 0xffc832;
        if(ekk % 30 > 15)
            i = 0xff3232;
        gfx.drawcenteredtext("Quest history", 255, eli + 6, 0, i);
        i = 0xc8c8ff;
        if(een == 3)
            i = 0xffc832;
        if(ekl % 30 > 15)
            i = 0xff3232;
        gfx.drawcenteredtext("Private history", 355, eli + 6, 0, i);
        gfx.drawcenteredtext("Report abuse", 457, eli + 6, 0, 0xffffff);
    }
    private final void fcm()
    {
        super.fmb = "";
        super.fmc = "";
    }
    protected final void fcn()
    {
        if(egd)
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
        if(dib)
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
        if(ell)
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
            if(eid == 0)
            {
                gfx.bnm = false;
                fch();
            }
            if(eid == 1)
            {
                gfx.bnm = true;
                fdh();
                return;
            }
        }
        catch(OutOfMemoryError _ex)
        {
            feg();
            ell = true;
        }
    }
    protected final void fda(int i)
    {
        if(eid == 0)
        {
            if(eed == 0)
                dln.gfi(i);
            if(eed == 1)
                dni.gfi(i);
            if(eed == 2)
                djl.gfi(i);
        }
        if(eid == 1)
        {
            if(edf)
            {
                eij.gfi(i);
                return;
            }
            if(djc == 0 && egm == 0 && !ddj)
                eei.gfi(i);
        }
    }
    protected final void fdb()
    {
        int i = 0;
        for(int j = 0; j < 99; j++)
        {
            int k = j + 1;
            int i1 = (int)((double)k + 300D * Math.pow(2D, (double)k / 7D));
            i += i1;
            djm[j] = i & 0xffffffc;
        }
        try
        {
            String s1 = getParameter("referid");
            deb = Integer.parseInt(s1);
        }
        catch(Exception _ex) { }

        member = true;

        if(dmc)
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
        fea();
        if(egd)
            return;
        dkn = 2000;
        dla = dkn + 100;
        dlb = dla + 50;
        dlf = dlb + 1000;
        dlc = dlf + 10;
        dld = dlc + 50;
        dle = dld + 10;
        dil = getGraphics();
        fmg(50);
        gfx = new dbf(elh, eli + 12, 4000, this);
        gfx.dbg = this;
        gfx.cba(0, 0, elh, eli + 12);
        gca.gen = false;
        gca.gfa = dla;
        ehn = new gca(gfx, 5);
        int l = ((blm) (gfx)).bln - 199;
        byte byte0 = 36;
        eia = ehn.ghc(l, 60, 196, 90, 1, 500, true);
        eka = new gca(gfx, 5);
        ekb = eka.ghc(l, 76, 196, 126, 1, 500, true);
        ejg = new gca(gfx, 5);
        ejh = ejg.ghc(l, 60, 196, 251, 1, 500, true);
        fad();
        if(egd)
            return;
        enk();
        if(egd)
            return;
        egn = new bbe(gfx, 15000, 15000, 1000);
        egn.bib(elh / 2, eli / 2, elh / 2, eli / 2, elh, elj);
        egn.bbl = 2400;
        egn.bbm = 2400;
        egn.bbn = 1;
        egn.bca = 2300;
        egn.bkb(-50, -10, -50);
        myplayerworld = new gig(egn, gfx);
        myplayerworld.gij = dkn;
        fak();
        if(egd)
            return;
        fek();
        if(egd)
            return;
        fbn();
        if(egd)
            return;
        if(member)
            fab();
        if(egd)
        {
            return;
        } else
        {
            fml(100, "Starting game...");
            enm();
            fbf();
            fcd();
            ffc();
            fmd();
            fem();
            return;
        }
    }
    private final void fdc()
    {
        if(eid == 0)
            return;
        if(edj > 450)
        {
            displaymessage("@cya@You can't logout during combat!", 3);
            return;
        }
        if(edj > 0)
        {
            displaymessage("@cya@You can't logout for 10 seconds after combat", 3);
            return;
        } else
        {
            super.packets.id(39);
            super.packets.send();
            dmm = 1000;
            return;
        }
    }
    private final void fdd()
    {
        if(super.fma.length() > 0)
        {
            String s = super.fma.trim();
            super.fln = "";
            super.fma = "";
            if(s.length() > 0)
            {
                long l = fnf.gag(s);
                super.packets.id(76);
                super.packets.hff(l);
                super.packets.var(eac);
                super.packets.var(ejc ? 1 : 0);
                super.packets.send();
            }
            egm = 0;
            return;
        }
        gfx.drawbox(56, 130, 400, 100, 0);
        gfx.drawboxedge(56, 130, 400, 100, 0xffffff);
        int i = 160;
        gfx.drawcenteredtext("Now type the name of the offending player, and press enter", 256, 160, 1, 0xffff00);
        i += 18;
        gfx.drawcenteredtext("Name: " + super.fln + "*", 256, 178, 4, 0xffffff);
        if(super.abk > 0)
        {
            i = 207;
            if(ejc)
                gfx.drawcenteredtext("Moderator option: Mute player for 48 hours: <ON>", 256, 207, 1, 0xff8000);
            else
                gfx.drawcenteredtext("Moderator option: Mute player for 48 hours: <OFF>", 256, 207, 1, 0xffffff);
            if(super.mousex > 106 && super.mousex < 406 && super.mousey > 194 && super.mousey < 209 && mousebutton3 == 1)
            {
                mousebutton3 = 0;
                ejc = !ejc;
            }
        }
        i = 222;
        int j = 0xffffff;
        if(super.mousex > 196 && super.mousex < 316 && super.mousey > 209 && super.mousey < 224)
        {
            j = 0xffff00;
            if(mousebutton3 == 1)
            {
                mousebutton3 = 0;
                egm = 0;
            }
        }
        gfx.drawcenteredtext("Click here to cancel", 256, 222, 1, j);
        if(mousebutton3 == 1 && (super.mousex < 56 || super.mousex > 456 || super.mousey < 130 || super.mousey > 230))
        {
            mousebutton3 = 0;
            egm = 0;
        }
    }
    private final String fde(int i)
    {
        return fnf.gaf(i);
    }
    private final void fdf(boolean flag)
    {
        boolean flag1 = false;
        int i = ((blm) (gfx)).bln - 248;
        gfx.drawpic(i, 3, dkn + 1);
        for(int j = 0; j < egl; j++)
        {
            int k = i + (j % 5) * 49;
            int i1 = 36 + (j / 5) * 34;
            if(j < invcount && end[j] == 1)
                gfx.transparentbox(k, i1, 49, 34, 0xff0000, 128);
            else
                gfx.transparentbox(k, i1, 49, 34, 0xb5b5b5, 128);
            if(j < invcount)
            {
                gfx.cdk(k, i1, 48, 32, dlb + identify.ajd[inventory[j]], identify.aji[inventory[j]], 0, 0, false);
                if(identify.ajf[inventory[j]] == 0)
                    gfx.drawtext(String.valueOf(enc[j]), k + 1, i1 + 10, 1, 0xffff00);
            }
        }
        for(int l = 1; l <= 4; l++)
            gfx.cbk(i + l * 49, 36, (egl / 5) * 34, 0);
        for(int j1 = 1; j1 <= egl / 5 - 1; j1++)
            gfx.cbj(i, 36 + j1 * 34, 245, 0);
        if(!flag)
            return;
        i = super.mousex - (((blm) (gfx)).bln - 248);
        int k1 = super.mousey - 36;
        if(i >= 0 && k1 >= 0 && i < 248 && k1 < (egl / 5) * 34)
        {
            int l1 = i / 49 + (k1 / 34) * 5;
            if(l1 < invcount)
            {
                int i2 = inventory[l1];
                if(selectedspell >= 0)
                {
                    if(identify.spellid[selectedspell] == 3)
                    {
                        topmsg1[actioncount] = "Cast " + identify.spellname[selectedspell] + " on";
                        topmsg2[actioncount] = "@lre@" + identify.itemname[i2];
                        actionid[actioncount] = 600;
                        actionvar[actioncount] = l1;
                        actionvar2[actioncount] = selectedspell;
                        actioncount++;
                        return;
                    }
                } else
                {
                    if(selecteditem >= 0)
                    {
                        topmsg1[actioncount] = "Use " + selecteditemname + " with";
                        topmsg2[actioncount] = "@lre@" + identify.itemname[i2];
                        actionid[actioncount] = 610;
                        actionvar[actioncount] = l1;
                        actionvar2[actioncount] = selecteditem;
                        actioncount++;
                        return;
                    }
                    if(end[l1] == 1)
                    {
                        topmsg1[actioncount] = "Remove";
                        topmsg2[actioncount] = "@lre@" + identify.itemname[i2];
                        actionid[actioncount] = 620;
                        actionvar[actioncount] = l1;
                        actioncount++;
                    } else
                    if(identify.ajh[i2] != 0)
                    {
                        if((identify.ajh[i2] & 0x18) != 0)
                            topmsg1[actioncount] = "Wield";
                        else
                            topmsg1[actioncount] = "Wear";
                        topmsg2[actioncount] = "@lre@" + identify.itemname[i2];
                        actionid[actioncount] = 630;
                        actionvar[actioncount] = l1;
                        actioncount++;
                    }
                    if(!identify.amd[i2].equals(""))
                    {
                        topmsg1[actioncount] = identify.amd[i2];
                        topmsg2[actioncount] = "@lre@" + identify.itemname[i2];
                        actionid[actioncount] = 640;
                        actionvar[actioncount] = l1;
                        actioncount++;
                    }
                    topmsg1[actioncount] = "Use";
                    topmsg2[actioncount] = "@lre@" + identify.itemname[i2];
                    actionid[actioncount] = 650;
                    actionvar[actioncount] = l1;
                    actioncount++;
                    topmsg1[actioncount] = "Drop";
                    topmsg2[actioncount] = "@lre@" + identify.itemname[i2];
                    actionid[actioncount] = 660;
                    actionvar[actioncount] = l1;
                    actioncount++;
                    topmsg1[actioncount] = "Examine";
                    topmsg2[actioncount] = "@lre@" + identify.itemname[i2];
                    actionid[actioncount] = 3600;
                    actionvar[actioncount] = i2;
                    actioncount++;
                }
            }
        }
    }
    private final void fdg()
    {
        boolean flag = false;
        char c = '\u0198';
        char c1 = '\u014E';
        if(eea > 0 && ecm <= 48)
            eea = 0;
        if(eea > 1 && ecm <= 96)
            eea = 1;
        if(eea > 2 && ecm <= 144)
            eea = 2;
        if(eik >= ecm || eik < 0)
            eik = -1;
        if(eik != -1 && dhm[eik] != eil)
        {
            eik = -1;
            eil = -2;
        }
        if(mousebutton3 != 0)
        {
            mousebutton3 = 0;
            int i = super.mousex - 52;
            int j = super.mousey - 3;
            if(i >= 0 && j >= 12 && i < 408 && j < 280)
            {
                int k = eea * 48;
                for(int j1 = 0; j1 < 6; j1++)
                {
                    for(int l1 = 0; l1 < 8; l1++)
                    {
                        int j6 = 7 + l1 * 49;
                        int l6 = 28 + j1 * 34;
                        if(i > j6 && i < j6 + 49 && j > l6 && j < l6 + 34 && k < ecm && dhm[k] != -1)
                        {
                            eil = dhm[k];
                            eik = k;
                        }
                        k++;
                    }
                }
                i = 52;
                j = 3;
                int i2;
                if(eik < 0)
                    i2 = -1;
                else
                    i2 = dhm[eik];
                if(i2 != -1)
                {
                    int l = dhn[eik];
                    if(identify.ajf[i2] == 1 && l > 1)
                        l = 1;
                    if(l >= 1 && super.mousex >= 272 && super.mousey >= 241 && super.mousex < 302 && super.mousey <= 252)
                    {
                        super.packets.id(32);
                        super.packets.cmd(i2);
                        super.packets.cmd(1);
                        super.packets.send();
                    }
                    if(l >= 5 && super.mousex >= 302 && super.mousey >= 241 && super.mousex < 332 && super.mousey <= 252)
                    {
                        super.packets.id(32);
                        super.packets.cmd(i2);
                        super.packets.cmd(5);
                        super.packets.send();
                    }
                    if(l >= 25 && super.mousex >= 332 && super.mousey >= 241 && super.mousex < 357 && super.mousey <= 252)
                    {
                        super.packets.id(32);
                        super.packets.cmd(i2);
                        super.packets.cmd(25);
                        super.packets.send();
                    }
                    if(l >= 100 && super.mousex >= 357 && super.mousey >= 241 && super.mousex < 387 && super.mousey <= 252)
                    {
                        super.packets.id(32);
                        super.packets.cmd(i2);
                        super.packets.cmd(100);
                        super.packets.send();
                    }
                    if(l >= 500 && super.mousex >= 387 && super.mousey >= 241 && super.mousex < 420 && super.mousey <= 252)
                    {
                        super.packets.id(32);
                        super.packets.cmd(i2);
                        super.packets.cmd(500);
                        super.packets.send();
                    }
                    if(l >= 2500 && super.mousex >= 422 && super.mousey >= 241 && super.mousex < 452 && super.mousey <= 252)
                    {
                        super.packets.id(32);
                        super.packets.cmd(i2);
                        super.packets.cmd(2500);
                        super.packets.send();
                    }
                    if(fdm(i2) >= 1 && super.mousex >= 272 && super.mousey >= 266 && super.mousex < 302 && super.mousey <= 277)
                    {
                        super.packets.id(177);
                        super.packets.cmd(i2);
                        super.packets.cmd(1);
                        super.packets.send();
                    }
                    if(fdm(i2) >= 5 && super.mousex >= 302 && super.mousey >= 266 && super.mousex < 332 && super.mousey <= 277)
                    {
                        super.packets.id(177);
                        super.packets.cmd(i2);
                        super.packets.cmd(5);
                        super.packets.send();
                    }
                    if(fdm(i2) >= 25 && super.mousex >= 332 && super.mousey >= 266 && super.mousex < 357 && super.mousey <= 277)
                    {
                        super.packets.id(177);
                        super.packets.cmd(i2);
                        super.packets.cmd(25);
                        super.packets.send();
                    }
                    if(fdm(i2) >= 100 && super.mousex >= 357 && super.mousey >= 266 && super.mousex < 387 && super.mousey <= 277)
                    {
                        super.packets.id(177);
                        super.packets.cmd(i2);
                        super.packets.cmd(100);
                        super.packets.send();
                    }
                    if(fdm(i2) >= 500 && super.mousex >= 387 && super.mousey >= 266 && super.mousex < 420 && super.mousey <= 277)
                    {
                        super.packets.id(177);
                        super.packets.cmd(i2);
                        super.packets.cmd(500);
                        super.packets.send();
                    }
                    if(fdm(i2) >= 2500 && super.mousex >= 422 && super.mousey >= 266 && super.mousex < 452 && super.mousey <= 277)
                    {
                        super.packets.id(177);
                        super.packets.cmd(i2);
                        super.packets.cmd(2500);
                        super.packets.send();
                    }
                }
            } else
            if(ecm > 48 && i >= 50 && i <= 115 && j <= 12)
                eea = 0;
            else
            if(ecm > 48 && i >= 115 && i <= 180 && j <= 12)
                eea = 1;
            else
            if(ecm > 96 && i >= 180 && i <= 245 && j <= 12)
                eea = 2;
            else
            if(ecm > 144 && i >= 245 && i <= 310 && j <= 12)
            {
                eea = 3;
            } else
            {
                super.packets.id(251);
                super.packets.send();
                dnf = false;
                return;
            }
        }
        byte byte0 = 52;
        byte byte1 = 3;
        gfx.drawbox(52, 3, 408, 12, 192);
        int i1 = 0x989898;
        gfx.transparentbox(52, 15, 408, 17, 0x989898, 160);
        gfx.transparentbox(52, 32, 8, 204, 0x989898, 160);
        gfx.transparentbox(451, 32, 9, 204, 0x989898, 160);
        gfx.transparentbox(52, 236, 408, 47, 0x989898, 160);
        gfx.drawtext("Bank", 53, 13, 1, 0xffffff);
        int k1 = 50;
        if(ecm > 48)
        {
            int j2 = 0xffffff;
            if(eea == 0)
                j2 = 0xff0000;
            else
            if(super.mousex > 102 && super.mousey >= 3 && super.mousex < 167 && super.mousey < 15)
                j2 = 0xffff00;
            gfx.drawtext("<page 1>", 102, 13, 1, j2);
            k1 += 65;
            j2 = 0xffffff;
            if(eea == 1)
                j2 = 0xff0000;
            else
            if(super.mousex > 167 && super.mousey >= 3 && super.mousex < 232 && super.mousey < 15)
                j2 = 0xffff00;
            gfx.drawtext("<page 2>", 167, 13, 1, j2);
            k1 += 65;
        }
        if(ecm > 96)
        {
            int k2 = 0xffffff;
            if(eea == 2)
                k2 = 0xff0000;
            else
            if(super.mousex > 52 + k1 && super.mousey >= 3 && super.mousex < 52 + k1 + 65 && super.mousey < 15)
                k2 = 0xffff00;
            gfx.drawtext("<page 3>", 52 + k1, 13, 1, k2);
            k1 += 65;
        }
        if(ecm > 144)
        {
            int l2 = 0xffffff;
            if(eea == 3)
                l2 = 0xff0000;
            else
            if(super.mousex > 52 + k1 && super.mousey >= 3 && super.mousex < 52 + k1 + 65 && super.mousey < 15)
                l2 = 0xffff00;
            gfx.drawtext("<page 4>", 52 + k1, 13, 1, l2);
            k1 += 65;
        }
        int i3 = 0xffffff;
        if(super.mousex > 372 && super.mousey >= 3 && super.mousex < 460 && super.mousey < 15)
            i3 = 0xff0000;
        gfx.ced("Close window", 458, 13, 1, i3);
        gfx.drawtext("Number in bank in green", 59, 27, 1, 65280);
        gfx.drawtext("Number held in blue", 341, 27, 1, 65535);
        int k6 = 0xd0d0d0;
        int i7 = eea * 48;
        for(int k7 = 0; k7 < 6; k7++)
        {
            for(int l7 = 0; l7 < 8; l7++)
            {
                int j8 = 59 + l7 * 49;
                int k8 = 31 + k7 * 34;
                if(eik == i7)
                    gfx.transparentbox(j8, k8, 49, 34, 0xff0000, 160);
                else
                    gfx.transparentbox(j8, k8, 49, 34, 0xd0d0d0, 160);
                gfx.drawboxedge(j8, k8, 50, 35, 0);
                if(i7 < ecm && dhm[i7] != -1)
                {
                    gfx.cdk(j8, k8, 48, 32, dlb + identify.ajd[dhm[i7]], identify.aji[dhm[i7]], 0, 0, false);
                    gfx.drawtext(String.valueOf(dhn[i7]), j8 + 1, k8 + 10, 1, 65280);
                    gfx.ced(String.valueOf(fdm(dhm[i7])), j8 + 47, k8 + 29, 1, 65535);
                }
                i7++;
            }
        }
        gfx.cbj(57, 259, 398, 0);
        if(eik == -1)
        {
            gfx.drawcenteredtext("Select an object to withdraw or deposit", 256, 251, 3, 0xffff00);
            return;
        }
        int i8;
        if(eik < 0)
            i8 = -1;
        else
            i8 = dhm[eik];
        if(i8 != -1)
        {
            int j7 = dhn[eik];
            if(identify.ajf[i8] == 1 && j7 > 1)
                j7 = 1;
            if(j7 > 0)
            {
                gfx.drawtext("Withdraw " + identify.itemname[i8], 54, 251, 1, 0xffffff);
                int j3 = 0xffffff;
                if(super.mousex >= 272 && super.mousey >= 241 && super.mousex < 302 && super.mousey <= 252)
                    j3 = 0xff0000;
                gfx.drawtext("One", 274, 251, 1, j3);
                if(j7 >= 5)
                {
                    int k3 = 0xffffff;
                    if(super.mousex >= 302 && super.mousey >= 241 && super.mousex < 332 && super.mousey <= 252)
                        k3 = 0xff0000;
                    gfx.drawtext("Five", 304, 251, 1, k3);
                }
                if(j7 >= 25)
                {
                    int l3 = 0xffffff;
                    if(super.mousex >= 332 && super.mousey >= 241 && super.mousex < 357 && super.mousey <= 252)
                        l3 = 0xff0000;
                    gfx.drawtext("25", 334, 251, 1, l3);
                }
                if(j7 >= 100)
                {
                    int i4 = 0xffffff;
                    if(super.mousex >= 357 && super.mousey >= 241 && super.mousex < 387 && super.mousey <= 252)
                        i4 = 0xff0000;
                    gfx.drawtext("100", 359, 251, 1, i4);
                }
                if(j7 >= 500)
                {
                    int j4 = 0xffffff;
                    if(super.mousex >= 387 && super.mousey >= 241 && super.mousex < 420 && super.mousey <= 252)
                        j4 = 0xff0000;
                    gfx.drawtext("500", 389, 251, 1, j4);
                }
                if(j7 >= 2500)
                {
                    int k4 = 0xffffff;
                    if(super.mousex >= 422 && super.mousey >= 241 && super.mousex < 452 && super.mousey <= 252)
                        k4 = 0xff0000;
                    gfx.drawtext("2500", 422, 251, 1, k4);
                }
            }
            if(fdm(i8) > 0)
            {
                gfx.drawtext("Deposit " + identify.itemname[i8], 54, 276, 1, 0xffffff);
                int l4 = 0xffffff;
                if(super.mousex >= 272 && super.mousey >= 266 && super.mousex < 302 && super.mousey <= 277)
                    l4 = 0xff0000;
                gfx.drawtext("One", 274, 276, 1, l4);
                if(fdm(i8) >= 5)
                {
                    int i5 = 0xffffff;
                    if(super.mousex >= 302 && super.mousey >= 266 && super.mousex < 332 && super.mousey <= 277)
                        i5 = 0xff0000;
                    gfx.drawtext("Five", 304, 276, 1, i5);
                }
                if(fdm(i8) >= 25)
                {
                    int j5 = 0xffffff;
                    if(super.mousex >= 332 && super.mousey >= 266 && super.mousex < 357 && super.mousey <= 277)
                        j5 = 0xff0000;
                    gfx.drawtext("25", 334, 276, 1, j5);
                }
                if(fdm(i8) >= 100)
                {
                    int k5 = 0xffffff;
                    if(super.mousex >= 357 && super.mousey >= 266 && super.mousex < 387 && super.mousey <= 277)
                        k5 = 0xff0000;
                    gfx.drawtext("100", 359, 276, 1, k5);
                }
                if(fdm(i8) >= 500)
                {
                    int l5 = 0xffffff;
                    if(super.mousex >= 387 && super.mousey >= 266 && super.mousex < 420 && super.mousey <= 277)
                        l5 = 0xff0000;
                    gfx.drawtext("500", 389, 276, 1, l5);
                }
                if(fdm(i8) >= 2500)
                {
                    int i6 = 0xffffff;
                    if(super.mousex >= 422 && super.mousey >= 266 && super.mousex < 452 && super.mousey <= 277)
                        i6 = 0xff0000;
                    gfx.drawtext("2500", 422, 276, 1, i6);
                }
            }
        }
    }
    private final void fdh()
    {
        boolean flag = false;
        if(ecj != 0)
        {
            gfx.cbm();
            gfx.drawcenteredtext("Oh dear! You are dead...", elh / 2, eli / 2, 7, 0xff0000);
            fcl();
            gfx.cbc(dil, 0, 0);
            return;
        }
        if(edf)
        {
            eng();
            return;
        }
        if(ddj)
        {
            gfx.cbm();
            if(Math.random() < 0.14999999999999999D)
                gfx.drawcenteredtext("ZZZ", (int)(Math.random() * 80D), (int)(Math.random() * 334D), 5, (int)(Math.random() * 16777215D));
            if(Math.random() < 0.14999999999999999D)
                gfx.drawcenteredtext("ZZZ", 512 - (int)(Math.random() * 80D), (int)(Math.random() * 334D), 5, (int)(Math.random() * 16777215D));
            gfx.drawbox(elh / 2 - 100, 160, 200, 40, 0);
            gfx.drawcenteredtext("You are sleeping", elh / 2, 50, 7, 0xffff00);
            gfx.drawcenteredtext("Fatigue: " + (ejb * 100) / 750 + "%", elh / 2, 90, 7, 0xffff00);
            gfx.drawcenteredtext("When you want to wake up just use your", elh / 2, 140, 5, 0xffffff);
            gfx.drawcenteredtext("keyboard to type the word in the box below", elh / 2, 160, 5, 0xffffff);
            gfx.drawcenteredtext(super.fln + "*", elh / 2, 180, 5, 65535);
            if(dia == null)
                gfx.drawpic(elh / 2 - 127, 230, dld + 1);
            else
                gfx.drawcenteredtext(dia, elh / 2, 260, 5, 0xff0000);
            gfx.drawboxedge(elh / 2 - 128, 229, 257, 42, 0xffffff);
            fcl();
            gfx.drawcenteredtext("If you can't read the word", elh / 2, 290, 1, 0xffffff);
            gfx.drawcenteredtext("@yel@click here@whi@ to get a different one", elh / 2, 305, 1, 0xffffff);
            gfx.cbc(dil, 0, 0);
            return;
        }
        if(!myplayerworld.gkg)
            return;
        for(int i = 0; i < 64; i++)
        {
            egn.bhe(myplayerworld.gkd[edd][i]);
            if(edd == 0)
            {
                egn.bhe(myplayerworld.gjb[1][i]);
                egn.bhe(myplayerworld.gkd[1][i]);
                egn.bhe(myplayerworld.gjb[2][i]);
                egn.bhe(myplayerworld.gkd[2][i]);
            }
            inside = true;
            if(edd == 0 && (myplayerworld.gka[myplayer.x / 128][myplayer.y / 128] & 0x80) == 0)
            {
                egn.bhd(myplayerworld.gkd[edd][i]);
                if(edd == 0)
                {
                    egn.bhd(myplayerworld.gjb[1][i]);
                    egn.bhd(myplayerworld.gkd[1][i]);
                    egn.bhd(myplayerworld.gjb[2][i]);
                    egn.bhd(myplayerworld.gkd[2][i]);
                }
                inside = false;
            }
        }
        if(efj != dgj)
        {
            dgj = efj;
            for(int j = 0; j < mobcount; j++)
            {
                if(mobtype[j] == 97)
                    ffb(j, "firea" + (efj + 1));
                if(mobtype[j] == 274)
                    ffb(j, "fireplacea" + (efj + 1));
                if(mobtype[j] == 1031)
                    ffb(j, "lightning" + (efj + 1));
                if(mobtype[j] == 1036)
                    ffb(j, "firespell" + (efj + 1));
                if(mobtype[j] == 1147)
                    ffb(j, "spellcharge" + (efj + 1));
            }
        }
        if(efk != dgk)
        {
            dgk = efk;
            for(int k = 0; k < mobcount; k++)
            {
                if(mobtype[k] == 51)
                    ffb(k, "torcha" + (efk + 1));
                if(mobtype[k] == 143)
                    ffb(k, "skulltorcha" + (efk + 1));
            }
        }
        if(efl != dgl)
        {
            dgl = efl;
            for(int l = 0; l < mobcount; l++)
                if(mobtype[l] == 1142)
                    ffb(l, "clawspell" + (efl + 1));
        }
        egn.bhh(dkc);
        dkc = 0;
        for(int i1 = 0; i1 < playercount; i1++)
        {
            monster gnm1 = player[i1];
            if(gnm1.hbl != 255)
            {
                int k1 = gnm1.x;
                int i2 = gnm1.y;
                int k2 = -myplayerworld.gnb(k1, i2);
                int l3 = egn.bhi(5000 + i1, k1, k2, i2, 145, 220, i1 + 10000);
                dkc++;
                if(gnm1 == myplayer)
                    egn.bhj(l3);
                if(gnm1.hah == 8)
                    egn.bhk(l3, -30);
                if(gnm1.hah == 9)
                    egn.bhk(l3, 30);
            }
        }
        for(int j1 = 0; j1 < playercount; j1++)
        {
            monster gnm2 = player[j1];
            if(gnm2.hcc > 0)
            {
                monster gnm3 = null;
                if(gnm2.hcb != -1)
                    gnm3 = eab[gnm2.hcb];
                else
                if(gnm2.hca != -1)
                    gnm3 = ekm[gnm2.hca];
                if(gnm3 != null)
                {
                    int l2 = gnm2.x;
                    int i4 = gnm2.y;
                    int j6 = -myplayerworld.gnb(l2, i4) - 110;
                    int i8 = gnm3.x;
                    int l8 = gnm3.y;
                    int i9 = -myplayerworld.gnb(i8, l8) - identify.aie[gnm3.type] / 2;
                    int j9 = (l2 * gnm2.hcc + i8 * (ehm - gnm2.hcc)) / ehm;
                    int k9 = (j6 * gnm2.hcc + i9 * (ehm - gnm2.hcc)) / ehm;
                    int l9 = (i4 * gnm2.hcc + l8 * (ehm - gnm2.hcc)) / ehm;
                    egn.bhi(dlc + gnm2.hbn, j9, k9, l9, 32, 32, 0);
                    dkc++;
                }
            }
        }
        for(int l1 = 0; l1 < ehd; l1++)
        {
            monster gnm4 = npc[l1];
            int i3 = gnm4.x;
            int j4 = gnm4.y;
            int k6 = -myplayerworld.gnb(i3, j4);
            int j8 = egn.bhi(20000 + l1, i3, k6, j4, identify.aid[gnm4.type], identify.aie[gnm4.type], l1 + 30000);
            dkc++;
            if(gnm4.hah == 8)
                egn.bhk(j8, -30);
            if(gnm4.hah == 9)
                egn.bhk(j8, 30);
        }
        for(int j2 = 0; j2 < dfc; j2++)
        {
            int j3 = djf[j2] * eic + 64;
            int k4 = djg[j2] * eic + 64;
            egn.bhi(40000 + djh[j2], j3, -myplayerworld.gnb(j3, k4) - dji[j2], k4, 96, 64, j2 + 20000);
            dkc++;
        }
        for(int k3 = 0; k3 < ede; k3++)
        {
            int l4 = dga[k3] * eic + 64;
            int l6 = ehi[k3] * eic + 64;
            int k8 = ejf[k3];
            if(k8 == 0)
            {
                egn.bhi(50000 + k3, l4, -myplayerworld.gnb(l4, l6), l6, 128, 256, k3 + 50000);
                dkc++;
            }
            if(k8 == 1)
            {
                egn.bhi(50000 + k3, l4, -myplayerworld.gnb(l4, l6), l6, 128, 64, k3 + 50000);
                dkc++;
            }
        }
        gfx.bnj = false;
        gfx.cbd();
        gfx.bnj = super.fogofwar;
        if(edd == 3)
        {
            int i5 = 40 + (int)(Math.random() * 3D);
            int i7 = 40 + (int)(Math.random() * 7D);
            egn.bkc(i5, i7, -50, -10, -50);
        }
        ehc = 0;
        ejd = 0;
        dhl = 0;
        if(autocam && !inside)
            fcb();
        int j5 = dkj + emd;
        int j7 = dkk + dlk;
        egn.bje(j5, -myplayerworld.gnb(j5, j7), j7, yrot, xrot * 4, 0, zoom * 2);
        egn.big();
        fan();
        if(efg > 0)
            gfx.drawpic(efh - 8, efi - 8, dkn + 14 + (24 - efg) / 6);
        if(efg < 0)
            gfx.drawpic(efh - 8, efi - 8, dkn + 18 + (24 + efg) / 6);
        if(ecf != 0)
        {
            int k5 = ecf / 50;
            int k7 = k5 / 60;
            k5 %= 60;
            if(k5 < 10)
                gfx.drawcenteredtext("System update in: " + k7 + ":0" + k5, 256, eli - 7, 1, 0xffff00);
            else
                gfx.drawcenteredtext("System update in: " + k7 + ":" + k5, 256, eli - 7, 1, 0xffff00);
        }
        if(!dea)
        {
            int l5 = 2203 - (smally + edb + dna);
            if(smallx + eda + dmn >= 2640)
                l5 = -50;
            if(l5 > 0)
            {
                int l7 = 1 + l5 / 6;
                gfx.drawpic(453, eli - 56, dkn + 13);
                gfx.drawcenteredtext("Wilderness", 465, eli - 20, 1, 0xffff00);
                gfx.drawcenteredtext("Level: " + l7, 465, eli - 7, 1, 0xffff00);
                if(emn == 0)
                    emn = 2;
            }
            if(emn == 0 && l5 > -10 && l5 <= 0)
                emn = 1;
        }
		if (ownagepk == true)
		{
			int lobcount = 0;
			for (int lobcounting = 0; lobcounting < invcount; lobcounting++)
			{
				if (inventory[lobcounting] == 373)
				{
					lobcount++;
				}
			}
			gfx.drawcenteredtext("@gre@Lobsters: @whi@" + lobcount, 465, eli - 64, 1, 0xffffff);
			gfx.drawcenteredtext("@gre@Hits: @whi@" + curstat[3] + "/" + stat[3], 465, eli - 77, 1, 0xffffff);
		}
        if(een == 0)
        {
            for(int i6 = 0; i6 < 5; i6++)
                if(die[i6] > 0)
                {
                    String s = dgm[i6];
                    gfx.drawtext(s, 7, eli - 18 - i6 * 12, 1, 0xffff00);
                }
        }
        eei.ghl(eej);
        eei.ghl(eel);
        eei.ghl(eem);
        if(een == 1)
            eei.ghk(eej);
        else
        if(een == 2)
            eei.ghk(eel);
        else
        if(een == 3)
            eei.ghk(eem);
        gca.gfe = 2;
        eei.gfj();
        gca.gfe = 0;
        gfx.cck(((blm) (gfx)).bln - 3 - 197, 3, dkn, 128);
        fcg();
        gfx.bnm = false;
        fcl();
        gfx.cbc(dil, 0, 0);
    }
    protected final void fdi()
    {
        if(dib)
            return;
        if(ell)
            return;
        if(egd)
            return;
        try
        {
            ean++;
            if(eid == 0)
            {
                super.fjn = 0;
                fef();
            }
            if(eid == 1)
            {
                super.fjn++;
                faa();
            }
            super.mousebutton2 = 0;
            super.fll = 0;
            efa++;
            if(efa > 500)
            {
                efa = 0;
                int i = (int)(Math.random() * 4D);
                if((i & 1) == 1)
                    emd += eme;
                if((i & 2) == 2)
                    dlk += dll;
            }
            if(emd < -50)
                eme = 2;
            if(emd > 50)
                eme = -2;
            if(dlk < -50)
                dll = 2;
            if(dlk > 50)
                dll = -2;
            if(eki > 0)
                eki--;
            if(ekj > 0)
                ekj--;
            if(ekk > 0)
                ekk--;
            if(ekl > 0)
            {
                ekl--;
                return;
            }
        }
        catch(OutOfMemoryError _ex)
        {
            feg();
            ell = true;
        }
    }
    protected final void ade()
    {
        ecf = 0;
        eed = 0;
        eid = 0;
        dmm = 0;
    }
    private final boolean fdj(int i)
    {
        for(int j = 0; j < invcount; j++)
            if(inventory[j] == i && end[j] == 1)
                return true;
        return false;
    }
    final void fdk(int i, int j, int k, int l, int i1, int j1, int k1)
    {
        int l1 = identify.ajd[i1] + dlb;
        int i2 = identify.aji[i1];
        gfx.cdk(i, j, k, l, l1, i2, 0, 0, false);
    }
    private final void drawquestmenu(boolean flag)
    {
        boolean flag1 = false;
        int i = ((blm) (gfx)).bln - 199;
        int j = 36;
        gfx.drawpic(i - 49, 3, dkn + 3);
        char c = '\304';
        char c1 = '\u0113';
        int l;
        int k = l = 0xa0a0a0;
        if(eji == 0)
            k = 0xdcdcdc;
        else
            l = 0xdcdcdc;
        gfx.transparentbox(i, 36, 98, 24, k, 128);
        gfx.transparentbox(i + 98, 36, 98, 24, l, 128);
        gfx.transparentbox(i, 60, 196, 251, 0xdcdcdc, 128);
        gfx.cbj(i, 60, 196, 0);
        gfx.cbk(i + 98, 36, 24, 0);
        gfx.drawcenteredtext("Stats", i + 49, 52, 4, 0);
        gfx.drawcenteredtext("Quests", i + 49 + 98, 52, 4, 0);
        if(eji == 0)
        {
            int i1 = 72;
            int k1 = -1;
            gfx.drawtext("Skills", i + 5, 72, 3, 0xffff00);
            i1 += 13;
            for(int l1 = 0; l1 < 9; l1++)
            {
                int i2 = 0xffffff;
                if(super.mousex > i + 3 && super.mousey >= i1 - 11 && super.mousey < i1 + 2 && super.mousex < i + 90)
                {
                    i2 = 0xff0000;
                    k1 = l1;
                }
                gfx.drawtext(statname2[l1] + ":@yel@" + curstat[l1] + "/" + stat[l1], i + 5, i1, 1, i2);
                i2 = 0xffffff;
                if(super.mousex >= i + 90 && super.mousey >= i1 - 13 - 11 && super.mousey < (i1 - 13) + 2 && super.mousex < i + 196)
                {
                    i2 = 0xff0000;
                    k1 = l1 + 9;
                }
                gfx.drawtext(statname2[l1 + 9] + ":@yel@" + curstat[l1 + 9] + "/" + stat[l1 + 9], (i + 98) - 5, i1 - 13, 1, i2);
                i1 += 13;
            }
            gfx.drawtext("Quest Points:@yel@" + dic, (i + 98) - 5, i1 - 13, 1, 0xffffff);
            i1 += 12;
            gfx.drawtext("Fatigue: @yel@" + (eja * 100) / 750 + "%", i + 5, i1 - 13, 1, 0xffffff);
            i1 += 8;
            gfx.drawtext("Equipment Status", i + 5, i1, 3, 0xffff00);
            i1 += 12;
            for(int j2 = 0; j2 < 3; j2++)
            {
                gfx.drawtext(djn[j2] + ":@yel@" + efe[j2], i + 5, i1, 1, 0xffffff);
                if(j2 < 2)
                    gfx.drawtext(djn[j2 + 3] + ":@yel@" + efe[j2 + 3], i + 98 + 25, i1, 1, 0xffffff);
                i1 += 13;
            }
            i1 += 6;
            gfx.cbj(i, i1 - 15, 196, 0);
            if(k1 != -1)
            {
                gfx.drawtext(statname[k1] + " skill", i + 5, i1, 1, 0xffff00);
                i1 += 12;
                int k2 = djm[0];
                for(int i3 = 0; i3 < 98; i3++)
                    if(dnh[k1] >= djm[i3])
                        k2 = djm[i3 + 1];
                gfx.drawtext("Total xp: " + dnh[k1] / 4, i + 5, i1, 1, 0xffffff);
                i1 += 12;
                gfx.drawtext("Next level at: " + k2 / 4, i + 5, i1, 1, 0xffffff);
            } else
            {
                gfx.drawtext("Overall levels", i + 5, i1, 1, 0xffff00);
                i1 += 12;
                int l2 = 0;
                for(int j3 = 0; j3 < 18; j3++)
                    l2 += stat[j3];
                gfx.drawtext("Skill total: " + l2, i + 5, i1, 1, 0xffffff);
                i1 += 12;
                gfx.drawtext("Combat level: " + myplayer.level, i + 5, i1, 1, 0xffffff);
                i1 += 12;
            }
        }
        if(eji == 1)
        {
            ejg.ghe(ejh);
            ejg.ghg(ejh, 0, "@whi@Quest-list (green=completed)");
            for(int j1 = 0; j1 < 50; j1++)
                ejg.ghg(ejh, j1 + 1, (dfm[j1] ? "@gre@" : "@red@") + questname[j1]);
            ejg.gfj();
        }
        if(!flag)
            return;
        i = super.mousex - (((blm) (gfx)).bln - 199);
        j = super.mousey - 36;
        if(i >= 0 && j >= 0 && i < 196 && j < 275)
        {
            if(eji == 1)
                ejg.gfg(i + (((blm) (gfx)).bln - 199), j + 36, super.mousebutton2, super.mousebutton);
            if(j <= 24 && mousebutton3 == 1)
            {
                if(i < 98)
                {
                    eji = 0;
                    return;
                }
                if(i > 98)
                    eji = 1;
            }
        }
    }
    private final int fdm(int i)
    {
        boolean flag = false;
        int j = 0;
        for(int k = 0; k < invcount; k++)
            if(inventory[k] == i)
                if(identify.ajf[i] == 1)
                    j++;
                else
                    j += enc[k];
        return j;
    }
    protected final void acc()
    {
        ecf = 0;
        if(dmm != 0)
        {
            ade();
            return;
        } else
        {
            super.acc();
            return;
        }
    }
    private final monster fdn(int i, int j, int k, int l)
    {
        boolean flag1 = false;
        if(ekm[i] == null)
        {
            ekm[i] = new monster();
            ekm[i].id = i;
            ekm[i].hac = 0;
        }
        monster gnm1 = ekm[i];
        boolean flag = false;
        for(int i1 = 0; i1 < dkb; i1++)
        {
            if(did[i1].id != i)
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
            gnm1.id = i;
            gnm1.haj = 0;
            gnm1.hak = 0;
            gnm1.hal[0] = gnm1.x = j;
            gnm1.ham[0] = gnm1.y = k;
            gnm1.hai = gnm1.hah = l;
            gnm1.hag = 0;
        }
        player[playercount++] = gnm1;
        return gnm1;
    }
    private final void fea()
    {
        byte abyte0[] = faf("config" + cff.cfi + ".jag", "Configuration", 10);
        if(abyte0 == null)
        {
            egd = true;
            return;
        }
        identify.bad(abyte0, member);
        byte abyte1[] = faf("filter" + cff.cgb + ".jag", "Chat system", 15);
        if(abyte1 == null)
        {
            egd = true;
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
    private final void action(int i)
    {
        int x = actionx[i];
        int y = actiony[i];
        int var = actionvar[i];
        int var2 = actionvar2[i];
        int var3 = actionvar3[i];
        int id = actionid[i];
        if(id == 200)
        {
            fel(smallx, smally, x, y, true);
            super.packets.id(204);
            super.packets.cmd(x + dmn);
            super.packets.cmd(y + dna);
            super.packets.cmd(var);
            super.packets.cmd(var2);
            super.packets.send();
            selectedspell = -1;
        }
        if(id == 210)
        {
            fel(smallx, smally, x, y, true);
            super.packets.id(83);
            super.packets.cmd(x + dmn);
            super.packets.cmd(y + dna);
            super.packets.cmd(var);
            super.packets.cmd(var2);
            super.packets.send();
            selecteditem = -1;
        }
        if(id == 220)
        {
            fel(smallx, smally, x, y, true);
            super.packets.id(80);
            super.packets.cmd(x + dmn);
            super.packets.cmd(y + dna);
            super.packets.cmd(var);
            super.packets.cmd(var2);
            super.packets.send();
        }
        if(id == 3200)
            displaymessage(identify.amc[var], 3);
        if(id == 300)
        {
            fff(x, y, var);
            super.packets.id(121);
            super.packets.cmd(x + dmn);
            super.packets.cmd(y + dna);
            super.packets.var(var);
            super.packets.cmd(var2);
            super.packets.send();
            selectedspell = -1;
        }
        if(id == 310)
        {
            fff(x, y, var);
            super.packets.id(97);
            super.packets.cmd(x + dmn);
            super.packets.cmd(y + dna);
            super.packets.var(var);
            super.packets.cmd(var2);
            super.packets.send();
            selecteditem = -1;
        }
        if(id == 320)
        {
            fff(x, y, var);
            super.packets.id(46);
            super.packets.cmd(x + dmn);
            super.packets.cmd(y + dna);
            super.packets.var(var);
            super.packets.send();
        }
        if(id == 2300)
        {
            fff(x, y, var);
            super.packets.id(112);
            super.packets.cmd(x + dmn);
            super.packets.cmd(y + dna);
            super.packets.var(var);
            super.packets.send();
        }
        if(id == 3300)
            displaymessage(identify.akm[var], 3);
        if(id == 400)
        {
            fcc(x, y, var, var2);
            super.packets.id(136);
            super.packets.cmd(x + dmn);
            super.packets.cmd(y + dna);
            super.packets.cmd(var3);
            super.packets.send();
            selectedspell = -1;
        }
        if(id == 410)
        {
            fcc(x, y, var, var2);
            super.packets.id(34);
            super.packets.cmd(x + dmn);
            super.packets.cmd(y + dna);
            super.packets.cmd(var3);
            super.packets.send();
            selecteditem = -1;
        }
        if(id == 420)
        {
			fcc(x, y, var, var2);
            super.packets.id(48);
            super.packets.cmd(x + dmn);
            super.packets.cmd(y + dna);
            super.packets.send();
        }
        if(id == 2400)
        {
            fcc(x, y, var, var2);
            super.packets.id(199);
            super.packets.cmd(x + dmn);
            super.packets.cmd(y + dna);
            super.packets.send();
        }
        if(id == 3400)
            displaymessage(identify.aki[var], 3);
        if(id == 600)
        {
            super.packets.id(155);
            super.packets.cmd(var);
            super.packets.cmd(var2);
            super.packets.send();
            selectedspell = -1;
        }
        if(id == 610)
        {
            super.packets.id(150);
            super.packets.cmd(var);
            super.packets.cmd(var2);
            super.packets.send();
            selecteditem = -1;
        }
        if(id == 620)
        {
            super.packets.id(154);
            super.packets.cmd(var);
            super.packets.send();
        }
        if(id == 630)
        {
            super.packets.id(14);
            super.packets.cmd(var);
            super.packets.send();
        }
        if(id == 640)
        {
            super.packets.id(241);
            super.packets.cmd(var);
            super.packets.send();
        }
        if(id == 650)
        {
            selecteditem = var;
            selectedmenu = 0;
            selecteditemname = identify.itemname[inventory[selecteditem]];
        }
        if(id == 660)
        {
            super.packets.id(236);
            super.packets.cmd(var);
            super.packets.send();
            selecteditem = -1;
            selectedmenu = 0;
            displaymessage("Dropping " + identify.itemname[inventory[var]], 4);
        }
        if(id == 3600)
            displaymessage(identify.amc[var], 3);
        if(id == 700)
        {
            int l1 = (x - 64) / eic;
            int l3 = (y - 64) / eic;
            faj(smallx, smally, l1, l3, true);
            super.packets.id(129);
            super.packets.cmd(var);
            super.packets.cmd(var2);
            super.packets.send();
            selectedspell = -1;
        }
        if(id == 710)
        {
            int i2 = (x - 64) / eic;
            int i4 = (y - 64) / eic;
            faj(smallx, smally, i2, i4, true);
            super.packets.id(115);
            super.packets.cmd(var);
            super.packets.cmd(var2);
            super.packets.send();
            selecteditem = -1;
        }
        if(id == 720)
        {
            int j2 = (x - 64) / eic;
            int j4 = (y - 64) / eic;
            faj(smallx, smally, j2, j4, true);
            super.packets.id(62);
            super.packets.cmd(var);
            super.packets.send();
        }
        if(id == 725)
        {
            int k2 = (x - 64) / eic;
            int k4 = (y - 64) / eic;
            faj(smallx, smally, k2, k4, true);
            super.packets.id(225);
            super.packets.cmd(var);
            super.packets.send();
        }
        if(id == 715 || id == 2715)
        {
            int l2 = (x - 64) / eic;
            int l4 = (y - 64) / eic;
            faj(smallx, smally, l2, l4, true);
            super.packets.id(220);
            super.packets.cmd(var);
            super.packets.send();
        }
        if(id == 3700)
            displaymessage(identify.ana[var], 3);
        if(id == 800)
        {
            int i3 = (x - 64) / eic;
            int i5 = (y - 64) / eic;
            faj(smallx, smally, i3, i5, true);
            super.packets.id(5);
            super.packets.cmd(var);
            super.packets.cmd(var2);
            super.packets.send();
            selectedspell = -1;
        }
        if(id == 810)
        {
            int j3 = (x - 64) / eic;
            int j5 = (y - 64) / eic;
            faj(smallx, smally, j3, j5, true);
            super.packets.id(54);
            super.packets.cmd(var);
            super.packets.cmd(var2);
            super.packets.send();
            selecteditem = -1;
        }
        if(id == 805 || id == 2805)
        {
            int k3 = (x - 64) / eic;
            int k5 = (y - 64) / eic;
            faj(smallx, smally, k3, k5, true);
            super.packets.id(77);
            super.packets.cmd(var);
            super.packets.send();
        }
		if (id == 1337)
		{
			for (int cx = 0; cx < playercount; cx++)
			{
				if (var == player[cx].id)
				{
					catchname = player[cx].name;
					catchstate = System.currentTimeMillis();
					cx = playercount;
					catching = true;
				}
			}
			if (catchname != null)
			{
				displaymessage("@gre@DBoT: @whi@AutoCatch: " + catchname, 3);
			}
		}
        if(id == 2806)
        {
            super.packets.id(250);
            super.packets.cmd(var);
            super.packets.send();
        }
        if(id == 2810)
        {
            super.packets.id(73);
            super.packets.cmd(var);
            super.packets.send();
        }
        if(id == 2820)
        {
            super.packets.id(72);
            super.packets.cmd(var);
            super.packets.send();
        }
        if(id == 900)
        {
            faj(smallx, smally, x, y, true);
            super.packets.id(22);
            super.packets.cmd(x + dmn);
            super.packets.cmd(y + dna);
            super.packets.cmd(var);
            super.packets.send();
            selectedspell = -1;
        }
        if(id == 920)
        {
            faj(smallx, smally, x, y, false);
            if(efg == -24)
                efg = 24;
        }
        if(id == 1000)
        {
            super.packets.id(196);
            super.packets.cmd(var);
            super.packets.send();
            selectedspell = -1;
        }
        if(id == 4000)
        {
            selecteditem = -1;
            selectedspell = -1;
        }
    }
    private final void fec()
    {
        if(selectedmenu == 0 && super.mousex >= ((blm) (gfx)).bln - 35 && super.mousey >= 3 && super.mousex < ((blm) (gfx)).bln - 3 && super.mousey < 35)
            selectedmenu = 1;
        if(selectedmenu == 0 && super.mousex >= ((blm) (gfx)).bln - 35 - 33 && super.mousey >= 3 && super.mousex < ((blm) (gfx)).bln - 3 - 33 && super.mousey < 35)
        {
            selectedmenu = 2;
            ddg = (int)(Math.random() * 13D) - 6;
            ddh = (int)(Math.random() * 23D) - 11;
        }
        if(selectedmenu == 0 && super.mousex >= ((blm) (gfx)).bln - 35 - 66 && super.mousey >= 3 && super.mousex < ((blm) (gfx)).bln - 3 - 66 && super.mousey < 35)
            selectedmenu = 3;
        if(selectedmenu == 0 && super.mousex >= ((blm) (gfx)).bln - 35 - 99 && super.mousey >= 3 && super.mousex < ((blm) (gfx)).bln - 3 - 99 && super.mousey < 35)
            selectedmenu = 4;
        if(selectedmenu == 0 && super.mousex >= ((blm) (gfx)).bln - 35 - 132 && super.mousey >= 3 && super.mousex < ((blm) (gfx)).bln - 3 - 132 && super.mousey < 35)
            selectedmenu = 5;
        if(selectedmenu == 0 && super.mousex >= ((blm) (gfx)).bln - 35 - 165 && super.mousey >= 3 && super.mousex < ((blm) (gfx)).bln - 3 - 165 && super.mousey < 35)
            selectedmenu = 6;
        if(selectedmenu != 0 && super.mousex >= ((blm) (gfx)).bln - 35 && super.mousey >= 3 && super.mousex < ((blm) (gfx)).bln - 3 && super.mousey < 26)
            selectedmenu = 1;
        if(selectedmenu != 0 && selectedmenu != 2 && super.mousex >= ((blm) (gfx)).bln - 35 - 33 && super.mousey >= 3 && super.mousex < ((blm) (gfx)).bln - 3 - 33 && super.mousey < 26)
        {
            selectedmenu = 2;
            ddg = (int)(Math.random() * 13D) - 6;
            ddh = (int)(Math.random() * 23D) - 11;
        }
        if(selectedmenu != 0 && super.mousex >= ((blm) (gfx)).bln - 35 - 66 && super.mousey >= 3 && super.mousex < ((blm) (gfx)).bln - 3 - 66 && super.mousey < 26)
            selectedmenu = 3;
        if(selectedmenu != 0 && super.mousex >= ((blm) (gfx)).bln - 35 - 99 && super.mousey >= 3 && super.mousex < ((blm) (gfx)).bln - 3 - 99 && super.mousey < 26)
            selectedmenu = 4;
        if(selectedmenu != 0 && super.mousex >= ((blm) (gfx)).bln - 35 - 132 && super.mousey >= 3 && super.mousex < ((blm) (gfx)).bln - 3 - 132 && super.mousey < 26)
            selectedmenu = 5;
        if(selectedmenu != 0 && super.mousex >= ((blm) (gfx)).bln - 35 - 165 && super.mousey >= 3 && super.mousex < ((blm) (gfx)).bln - 3 - 165 && super.mousey < 26)
            selectedmenu = 6;
        if(selectedmenu == 1 && (super.mousex < ((blm) (gfx)).bln - 248 || super.mousey > 36 + (egl / 5) * 34))
            selectedmenu = 0;
        if(selectedmenu == 3 && (super.mousex < ((blm) (gfx)).bln - 199 || super.mousey > 316))
            selectedmenu = 0;
        if((selectedmenu == 2 || selectedmenu == 4 || selectedmenu == 5) && (super.mousex < ((blm) (gfx)).bln - 199 || super.mousey > 240))
            selectedmenu = 0;
        if(selectedmenu == 6 && (super.mousex < ((blm) (gfx)).bln - 199 || super.mousey > 311))
            selectedmenu = 0;
    }
    private final void fed()
    {
        char c = '\u0190';
        char c1 = 'd';
        if(eeh)
        {
            c1 = '\u01C2';
            c1 = '\u012C';
        }
        gfx.drawbox(56, 167 - c1 / 2, 400, c1, 0);
        gfx.drawboxedge(56, 167 - c1 / 2, 400, c1, 0xffffff);
        gfx.cef(ddf, 256, (167 - c1 / 2) + 20, 1, 0xffffff, 360);
        int i = 157 + c1 / 2;
        int j = 0xffffff;
        if(super.mousey > i - 12 && super.mousey <= i && super.mousex > 106 && super.mousex < 406)
            j = 0xff0000;
        gfx.drawcenteredtext("Click here to close window", 256, i, 1, j);
        if(mousebutton3 == 1)
        {
            if(j == 0xff0000)
                dgn = false;
            if((super.mousex < 56 || super.mousex > 456) && (super.mousey < 167 - c1 / 2 || super.mousey > 167 + c1 / 2))
                dgn = false;
        }
        mousebutton3 = 0;
    }
    private final void fee()
    {
        boolean flag = false;
        byte byte0 = 7;
        byte byte1 = 15;
        char c = '\257';
        if(mousebutton3 != 0)
        {
            for(int i = 0; i < 5; i++)
            {
                if(i <= 0 || super.mousex <= 7 || super.mousex >= 182 || super.mousey <= 15 + i * 20 || super.mousey >= 15 + i * 20 + 20)
                    continue;
                eff = i - 1;
                mousebutton3 = 0;
                super.packets.id(134);
                super.packets.var(eff);
                super.packets.send();
                break;
            }
        }
        for(int j = 0; j < 5; j++)
        {
            if(j == eff + 1)
                gfx.transparentbox(7, 15 + j * 20, 175, 20, 0xff0000, 128);
            else
                gfx.transparentbox(7, 15 + j * 20, 175, 20, 0xbebebe, 128);
            gfx.cbj(7, 15 + j * 20, 175, 0);
            gfx.cbj(7, 15 + j * 20 + 20, 175, 0);
        }
        gfx.drawcenteredtext("Select combat style", 94, 31, 3, 0xffffff);
        gfx.drawcenteredtext("Controlled (+1 of each)", 94, 51, 3, 0);
        gfx.drawcenteredtext("Aggressive (+3 strength)", 94, 71, 3, 0);
        gfx.drawcenteredtext("Accurate   (+3 attack)", 94, 91, 3, 0);
        gfx.drawcenteredtext("Defensive  (+3 defense)", 94, 111, 3, 0);
    }
    private final void fef()
    {
        if(super.abj > 0)
            super.abj--;
        if(eed == 0)
        {
            dln.gfg(super.mousex, super.mousey, super.mousebutton2, super.mousebutton);
            if(dln.gfh(djj))
                eed = 1;
            if(dln.gfh(djk))
            {
                eed = 2;
                djl.ghi(dfg, "Please enter your username and password");
                djl.ghi(dfh, "");
                djl.ghi(dfi, "");
                djl.ghm(dfh);
                return;
            }
        } else
        if(eed == 1)
        {
            dni.gfg(super.mousex, super.mousey, super.mousebutton2, super.mousebutton);
            if(dni.gfh(ded))
            {
                eed = 0;
                return;
            }
        } else
        if(eed == 2)
        {
            djl.gfg(super.mousex, super.mousey, super.mousebutton2, super.mousebutton);
            if(djl.gfh(dfk))
                eed = 0;
            if(djl.gfh(dfh))
                djl.ghm(dfi);
            if(djl.gfh(dfi) || djl.gfh(dfj))
            {
				fnf.fng = getCodeBase();
                eld = djl.ghj(dfh);
                ele = djl.ghj(dfi);
                aca(eld, ele, false);
            }
        }
    }
    private final void feg()
    {
        try
        {
            if(gfx != null)
            {
                gfx.ccb();
                gfx.bmf = null;
                gfx = null;
            }
            if(egn != null)
            {
                egn.bhf();
                egn = null;
            }
            eaj = null;
            emm = null;
            emf = null;
            ekm = null;
            player = null;
            eab = null;
            npc = null;
            myplayer = null;
            if(myplayerworld != null)
            {
                myplayerworld.gja = null;
                myplayerworld.gjb = null;
                myplayerworld.gkd = null;
                myplayerworld.gke = null;
                myplayerworld = null;
            }
            System.gc();
            return;
        }
        catch(Exception _ex)
        {
            return;
        }
    }
    protected final void add()
    {
        boolean flag = false;
        ecf = 0;
        eff = 0;
        dmm = 0;
        eed = 0;
        eid = 1;
        fcm();
        gfx.cbd();
        gfx.cbc(dil, 0, 0);
        for(int i = 0; i < mobcount; i++)
        {
            egn.bhe(emm[i]);
            myplayerworld.gmm(mobx[i], moby[i], mobtype[i]);
        }
        for(int j = 0; j < eim; j++)
        {
            egn.bhe(emf[j]);
            myplayerworld.gle(doorx[j], doory[j], doordir[j], emh[j]);
        }
        mobcount = 0;
        eim = 0;
        dfc = 0;
        playercount = 0;
        for(int k = 0; k < 4000; k++)
            ekm[k] = null;
        for(int l = 0; l < 500; l++)
            player[l] = null;
        ehd = 0;
        for(int i1 = 0; i1 < 5000; i1++)
            eab[i1] = null;
        for(int j1 = 0; j1 < 500; j1++)
            npc[j1] = null;
        for(int k1 = 0; k1 < 50; k1++)
            djb[k1] = false;
        mousebutton3 = 0;
        super.mousebutton2 = 0;
        super.mousebutton = 0;
        eec = false;
        dnf = false;
        ddj = false;
    }
    private final monster feh(int i, int j, int k, int l, int i1)
    {
        boolean flag1 = false;
        if(eab[i] == null)
        {
            eab[i] = new monster();
            eab[i].id = i;
        }
        monster gnm1 = eab[i];
        boolean flag = false;
        for(int j1 = 0; j1 < ehe; j1++)
        {
            if(dnj[j1].id != i)
                continue;
            flag = true;
            break;
        }
        if(flag)
        {
            gnm1.type = i1;
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
            gnm1.id = i;
            gnm1.haj = 0;
            gnm1.hak = 0;
            gnm1.hal[0] = gnm1.x = j;
            gnm1.ham[0] = gnm1.y = k;
            gnm1.type = i1;
            gnm1.hai = gnm1.hah = l;
            gnm1.hag = 0;
        }
        npc[ehd++] = gnm1;
        return gnm1;
    }
    protected final void adb(String s, String s1)
    {
        if(eed == 1)
            dni.ghi(0, s + " " + s1);
        if(eed == 2)
            djl.ghi(dfg, s + " " + s1);
        eaa = s1;
        fch();
        fmh();
    }
    protected final void fei(int i, int j, int k)
    {
        boolean flag1 = false;
        ehg[ehf] = j;
        ehh[ehf] = k;
        ehf = ehf + 1 & 0x1fff;
        for(int l = 10; l < 4000; l++)
        {
            int i1 = ehf - l & 0x1fff;
            if(ehg[i1] == j && ehh[i1] == k)
            {
                boolean flag = false;
                for(int j1 = 1; j1 < l; j1++)
                {
                    int k1 = ehf - j1 & 0x1fff;
                    int l1 = i1 - j1 & 0x1fff;
                    if(ehg[l1] != j || ehh[l1] != k)
                        flag = true;
                    if(ehg[k1] != ehg[l1] || ehh[k1] != ehh[l1])
                        break;
                    if(j1 == l - 1 && flag && edj == 0 && dmm == 0)
                    {
                        fdc();
                        return;
                    }
                }
            }
        }
    }
    private final boolean fej(int i, int j)
    {
        boolean flag = false;
        if(ecj != 0)
        {
            myplayerworld.gkg = false;
            return false;
        }
        dea = false;
        i += eda;
        j += edb;
        if(edd == dnb && i > dgd && i < dgf && j > dge && j < dgg)
        {
            myplayerworld.gkg = true;
            return false;
        }
        gfx.drawcenteredtext("Loading... Please wait", 256, 192, 1, 0xffffff);
        fcl();
        gfx.cbc(dil, 0, 0);
        int k = dmn;
        int l = dna;
        int i1 = (i + 24) / 48;
        int j1 = (j + 24) / 48;
        edd = dnb;
        dmn = i1 * 48 - 48;
        dna = j1 * 48 - 48;
        dgd = i1 * 48 - 32;
        dge = j1 * 48 - 32;
        dgf = i1 * 48 + 32;
        dgg = j1 * 48 + 32;
        myplayerworld.gmc(i, j, edd);
        dmn -= eda;
        dna -= edb;
        int k1 = dmn - k;
        int l1 = dna - l;
        for(int i2 = 0; i2 < mobcount; i2++)
        {
            mobx[i2] -= k1;
            moby[i2] -= l1;
            int j2 = mobx[i2];
            int l2 = moby[i2];
            int k3 = mobtype[i2];
            cgc cgc1 = emm[i2];
            try
            {
                int l4 = mobid[i2];
                int k5;
                int i6;
                if(l4 == 0 || l4 == 4)
                {
                    k5 = identify.ami[k3];
                    i6 = identify.amj[k3];
                } else
                {
                    i6 = identify.ami[k3];
                    k5 = identify.amj[k3];
                }
                int j6 = ((j2 + j2 + k5) * eic) / 2;
                int k6 = ((l2 + l2 + i6) * eic) / 2;
                if(j2 >= 0 && l2 >= 0 && j2 < 96 && l2 < 96)
                {
                    egn.bhd(cgc1);
                    cgc1.cnh(j6, -myplayerworld.gnb(j6, k6), k6);
                    myplayerworld.glc(j2, l2, k3);
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
        for(int k2 = 0; k2 < eim; k2++)
        {
            doorx[k2] -= k1;
            doory[k2] -= l1;
            int i3 = doorx[k2];
            int l3 = doory[k2];
            int j4 = emh[k2];
            int i5 = doordir[k2];
            try
            {
                myplayerworld.gli(i3, l3, i5, j4);
                cgc cgc2 = fah(i3, l3, i5, j4, k2);
                emf[k2] = cgc2;
            }
            catch(RuntimeException runtimeexception1)
            {
                System.out.println("Bound Error: " + runtimeexception1.getMessage());
                runtimeexception1.printStackTrace();
            }
        }
        for(int j3 = 0; j3 < dfc; j3++)
        {
            djf[j3] -= k1;
            djg[j3] -= l1;
        }
        for(int i4 = 0; i4 < playercount; i4++)
        {
            monster gnm1 = player[i4];
            gnm1.x -= k1 * eic;
            gnm1.y -= l1 * eic;
            for(int j5 = 0; j5 <= gnm1.hak; j5++)
            {
                gnm1.hal[j5] -= k1 * eic;
                gnm1.ham[j5] -= l1 * eic;
            }
        }
        for(int k4 = 0; k4 < ehd; k4++)
        {
            monster gnm2 = npc[k4];
            gnm2.x -= k1 * eic;
            gnm2.y -= l1 * eic;
            for(int l5 = 0; l5 <= gnm2.hak; l5++)
            {
                gnm2.hal[l5] -= k1 * eic;
                gnm2.ham[l5] -= l1 * eic;
            }
        }
        myplayerworld.gkg = true;
        return true;
    }
    private final void fek()
    {
        boolean flag = false;
        identify.anm("torcha2");
        identify.anm("torcha3");
        identify.anm("torcha4");
        identify.anm("skulltorcha2");
        identify.anm("skulltorcha3");
        identify.anm("skulltorcha4");
        identify.anm("firea2");
        identify.anm("firea3");
        identify.anm("fireplacea2");
        identify.anm("fireplacea3");
        identify.anm("firespell2");
        identify.anm("firespell3");
        identify.anm("lightning2");
        identify.anm("lightning3");
        identify.anm("clawspell2");
        identify.anm("clawspell3");
        identify.anm("clawspell4");
        identify.anm("clawspell5");
        identify.anm("spellcharge2");
        identify.anm("spellcharge3");
        if(fmf())
        {
            byte abyte0[] = faf("models" + cff.cfl + ".jag", "3d models", 60);
            if(abyte0 == null)
            {
                egd = true;
                return;
            }
            for(int j = 0; j < identify.ail; j++)
            {
                int k = fnf.gai(identify.alm[j] + ".ob3", abyte0);
                if(k != 0)
                    eaj[j] = new cgc(abyte0, k, true);
                else
                    eaj[j] = new cgc(1, 1);
                if(identify.alm[j].equals("giantcrystal"))
                    eaj[j].cif = true;
            }
            return;
        }
        fml(70, "Loading 3d models");
        for(int i = 0; i < identify.ail; i++)
        {
            eaj[i] = new cgc("../gamedata/models/" + identify.alm[i] + ".ob2");
            if(identify.alm[i].equals("giantcrystal"))
                eaj[i].cif = true;
        }
    }
    private final void fel(int i, int j, int k, int l, boolean flag)
    {
        if(fcf(i, j, k, l, k, l, false, flag))
        {
            return;
        } else
        {
            fce(i, j, k, l, k, l, true, flag);
            return;
        }
    }
    private final void fem()
    {
        boolean flag1 = false;
        boolean flag = false;
        byte byte0 = 50;
        byte byte1 = 50;
        myplayerworld.gmc(2423, 2423, 0);
        myplayerworld.gmh(eaj);
        char c = '\u2600';
        char c1 = '\u1900';
        char c2 = '\u044C';
        char c3 = '\u0378';
        egn.bbl = 4100;
        egn.bbm = 4100;
        egn.bbn = 1;
        egn.bca = 4000;
        egn.bje(9728, -myplayerworld.gnb(9728, 6400), 6400, 912, 888, 0, 2200);
        egn.big();
        gfx.cbm();
        gfx.cbm();
        gfx.drawbox(0, 0, 512, 6, 0);
        for(int i = 6; i >= 1; i--)
            gfx.cbn(0, i, 0, i, 512, 8);
        gfx.drawbox(0, 194, 512, 20, 0);
        for(int j = 6; j >= 1; j--)
            gfx.cbn(0, j, 0, 194 - j, 512, 8);
        gfx.drawpic(15, 15, dkn + 10);
        gfx.cch(dlf, 0, 0, 512, 200);
        gfx.cce(dlf);
        c = '\u2400';
        c1 = '\u2400';
        c2 = '\u044C';
        c3 = '\u0378';
        egn.bbl = 4100;
        egn.bbm = 4100;
        egn.bbn = 1;
        egn.bca = 4000;
        egn.bje(9216, -myplayerworld.gnb(9216, 9216), 9216, 912, 888, 0, 2200);
        egn.big();
        gfx.cbm();
        gfx.cbm();
        gfx.drawbox(0, 0, 512, 6, 0);
        for(int k = 6; k >= 1; k--)
            gfx.cbn(0, k, 0, k, 512, 8);
        gfx.drawbox(0, 194, 512, 20, 0);
        for(int l = 6; l >= 1; l--)
            gfx.cbn(0, l, 0, 194 - l, 512, 8);
        gfx.drawpic(15, 15, dkn + 10);
        gfx.cch(dlf + 1, 0, 0, 512, 200);
        gfx.cce(dlf + 1);
        for(int i1 = 0; i1 < 64; i1++)
        {
            egn.bhe(myplayerworld.gkd[0][i1]);
            egn.bhe(myplayerworld.gjb[1][i1]);
            egn.bhe(myplayerworld.gkd[1][i1]);
            egn.bhe(myplayerworld.gjb[2][i1]);
            egn.bhe(myplayerworld.gkd[2][i1]);
        }
        c = '\u2B80';
        c1 = '\u2880';
        c2 = '\u01F4';
        c3 = '\u0178';
        egn.bbl = 4100;
        egn.bbm = 4100;
        egn.bbn = 1;
        egn.bca = 4000;
        egn.bje(11136, -myplayerworld.gnb(11136, 10368), 10368, 912, 376, 0, 1000);
        egn.big();
        gfx.cbm();
        gfx.cbm();
        gfx.drawbox(0, 0, 512, 6, 0);
        for(int j1 = 6; j1 >= 1; j1--)
            gfx.cbn(0, j1, 0, j1, 512, 8);
        gfx.drawbox(0, 194, 512, 20, 0);
        for(int k1 = 6; k1 >= 1; k1--)
            gfx.cbn(0, k1, 0, 194, 512, 8);
        gfx.drawpic(15, 15, dkn + 10);
        gfx.cch(dkn + 10, 0, 0, 512, 200);
        gfx.cce(dkn + 10);
    }
    private final void fen()
    {
        boolean flag1 = false;
        if(selectedspell >= 0 || selecteditem >= 0)
        {
            topmsg1[actioncount] = "Cancel";
            topmsg2[actioncount] = "";
            actionid[actioncount] = 4000;
            actioncount++;
        }
        for(int i = 0; i < actioncount; i++)
            dmd[i] = i;
        for(boolean flag = false; !flag;)
        {
            flag = true;
            for(int j = 0; j < actioncount - 1; j++)
            {
                int l = dmd[j];
                int j1 = dmd[j + 1];
                if(actionid[l] > actionid[j1])
                {
                    dmd[j] = j1;
                    dmd[j + 1] = l;
                    flag = false;
                }
            }
        }
        if(actioncount > 20)
            actioncount = 20;
        if(actioncount > 0)
        {
            int k = -1;
            for(int i1 = 0; i1 < actioncount; i1++)
            {
                if(topmsg2[dmd[i1]] == null || topmsg2[dmd[i1]].length() <= 0)
                    continue;
                k = i1;
                break;
            }
            String s = null;
            if((selecteditem >= 0 || selectedspell >= 0) && actioncount == 1)
                s = "Choose a target";
            else
            if((selecteditem >= 0 || selectedspell >= 0) && actioncount > 1)
                s = "@whi@" + topmsg1[dmd[0]] + " " + topmsg2[dmd[0]];
            else
            if(k != -1)
                s = topmsg2[dmd[k]] + ": @whi@" + topmsg1[dmd[0]];
            if(actioncount == 2 && s != null)
                s = s + "@whi@ / 1 more option";
            if(actioncount > 2 && s != null)
                s = s + "@whi@ / " + (actioncount - 1) + " more options";
            if(s != null)
                gfx.drawtext(s, 6, 14, 1, 0xffff00);
            if(!twomousebuttons && mousebutton3 == 1 || twomousebuttons && mousebutton3 == 1 && actioncount == 1)
            {
                action(dmd[0]);
                mousebutton3 = 0;
                return;
            }
            if(!twomousebuttons && mousebutton3 == 2 || twomousebuttons && mousebutton3 == 1)
            {
                emb = (actioncount + 1) * 15;
                ema = gfx.cem("Choose option", 1) + 5;
                for(int k1 = 0; k1 < actioncount; k1++)
                {
                    int l1 = gfx.cem(topmsg1[k1] + " " + topmsg2[k1], 1) + 5;
                    if(l1 > ema)
                        ema = l1;
                }
                elm = super.mousex - ema / 2;
                eln = super.mousey - 7;
                dgi = true;
                if(elm < 0)
                    elm = 0;
                if(eln < 0)
                    eln = 0;
                if(elm + ema > 510)
                    elm = 510 - ema;
                if(eln + emb > 315)
                    eln = 315 - emb;
                mousebutton3 = 0;
            }
        }
    }
    private final boolean ffa(int i)
    {
        int j = myplayer.x / 128;
        int k = myplayer.y / 128;
        for(int l = 2; l >= 1; l--)
        {
            if(i == 1 && ((myplayerworld.gka[j][k - l] & 0x80) == 128 || (myplayerworld.gka[j - l][k] & 0x80) == 128 || (myplayerworld.gka[j - l][k - l] & 0x80) == 128))
                return false;
            if(i == 3 && ((myplayerworld.gka[j][k + l] & 0x80) == 128 || (myplayerworld.gka[j - l][k] & 0x80) == 128 || (myplayerworld.gka[j - l][k + l] & 0x80) == 128))
                return false;
            if(i == 5 && ((myplayerworld.gka[j][k + l] & 0x80) == 128 || (myplayerworld.gka[j + l][k] & 0x80) == 128 || (myplayerworld.gka[j + l][k + l] & 0x80) == 128))
                return false;
            if(i == 7 && ((myplayerworld.gka[j][k - l] & 0x80) == 128 || (myplayerworld.gka[j + l][k] & 0x80) == 128 || (myplayerworld.gka[j + l][k - l] & 0x80) == 128))
                return false;
            if(i == 0 && (myplayerworld.gka[j][k - l] & 0x80) == 128)
                return false;
            if(i == 2 && (myplayerworld.gka[j - l][k] & 0x80) == 128)
                return false;
            if(i == 4 && (myplayerworld.gka[j][k + l] & 0x80) == 128)
                return false;
            if(i == 6 && (myplayerworld.gka[j + l][k] & 0x80) == 128)
                return false;
        }
        return true;
    }
    private final void ffb(int i, String s)
    {
        int j = mobx[i];
        int k = moby[i];
        int l = j - myplayer.x / 128;
        int i1 = k - myplayer.y / 128;
        byte byte0 = 7;
        if(j >= 0 && k >= 0 && j < 96 && k < 96 && l > -7 && l < 7 && i1 > -7 && i1 < 7)
        {
            egn.bhe(emm[i]);
            int j1 = identify.anm(s);
            cgc cgc1 = eaj[j1].daf();
            egn.bhd(cgc1);
            cgc1.cna(true, 48, 48, -50, -10, -50);
            cgc1.dah(emm[i]);
            cgc1.cig = i;
            emm[i] = cgc1;
        }
    }
    public final Image createImage(int i, int j)
    {
        if(fjb.fji != null)
            return fjb.fji.createImage(i, j);
        else
            return super.createImage(i, j);
    }
    private final void ffc()
    {
        eid = 0;
        eed = 0;
        eld = "";
        ele = "";
        dnn = "Please enter a username:";
        eaa = "*" + eld + "*";
        playercount = 0;
        ehd = 0;
    }
    private final boolean ffd(int i, int j)
    {
        if(i == 31 && (fdj(197) || fdj(615) || fdj(682)))
            return true;
        if(i == 32 && (fdj(102) || fdj(616) || fdj(683)))
            return true;
        if(i == 33 && (fdj(101) || fdj(617) || fdj(684)))
            return true;
        if(i == 34 && (fdj(103) || fdj(618) || fdj(685)))
            return true;
        return fdm(i) >= j;
    }
    public final URL getDocumentBase()
    {
        return super.getDocumentBase();
    }
    public final String getParameter(String s)
    {
        return super.getParameter(s);
    }
    private final void drawmap(boolean flag)
    {
        boolean flag1 = false;
        int i = ((blm) (gfx)).bln - 199;
        char c = '\234';
        char c2 = '\230';
        gfx.drawpic(i - 49, 3, dkn + 2);
        i += 40;
        gfx.drawbox(i, 36, 156, 152, 0);
        gfx.cba(i, 36, i + 156, 188);
        int k = 192 + ddh;
        int i1 = xrot + ddg & 0xff;
        int k1 = ((myplayer.x - 6040) * 3 * k) / 2048;
        int i3 = ((myplayer.y - 6040) * 3 * k) / 2048;
        int k4 = bbe.bcb[1024 - i1 * 4 & 0x3ff];
        int i5 = bbe.bcb[(1024 - i1 * 4 & 0x3ff) + 1024];
        int k5 = i3 * k4 + k1 * i5 >> 18;
        i3 = i3 * i5 - k1 * k4 >> 18;
        k1 = k5;
		if (ubermap == false)
		{
			gfx.drawrotatedpicture((i + 78) - k1, 112 + i3, dkn - 1, i1 + 64 & 0xff, k);
		}
        for(int i7 = 0; i7 < mobcount; i7++)
        {
            int l1 = (((mobx[i7] * eic + 64) - myplayer.x) * 3 * k) / 2048;
            int j3 = (((moby[i7] * eic + 64) - myplayer.y) * 3 * k) / 2048;
            int l5 = j3 * k4 + l1 * i5 >> 18;
            j3 = j3 * i5 - l1 * k4 >> 18;
            l1 = l5;
            drawmapdot(i + 78 + l1, 112 - j3, 65535);
        }
        for(int j7 = 0; j7 < dfc; j7++)
        {
            int i2 = (((djf[j7] * eic + 64) - myplayer.x) * 3 * k) / 2048;
            int k3 = (((djg[j7] * eic + 64) - myplayer.y) * 3 * k) / 2048;
            int i6 = k3 * k4 + i2 * i5 >> 18;
            k3 = k3 * i5 - i2 * k4 >> 18;
            i2 = i6;
			if (ownagepk == true)
			{
				drawmapdot(i + 78 + i2, 112 - k3, 0xCA6FFF);
			} else {
				drawmapdot(i + 78 + i2, 112 - k3, 0xFF0000);
			}
        }
        for(int k7 = 0; k7 < ehd; k7++)
        {
            monster gnm1 = npc[k7];
            int j2 = ((gnm1.x - myplayer.x) * 3 * k) / 2048;
            int l3 = ((gnm1.y - myplayer.y) * 3 * k) / 2048;
            int j6 = l3 * k4 + j2 * i5 >> 18;
            l3 = l3 * i5 - j2 * k4 >> 18;
            j2 = j6;
			if (ownagepk == true)
			{
				drawmapdot(i + 78 + j2, 112 - l3, 0xFC00FF);
			} else {
				drawmapdot(i + 78 + j2, 112 - l3, 0xFFFF00);
			}
        }
		if (ownagepk == true)
		{
			for (int l7 = 0; l7 < playercount; l7++)
			{
				monster gnm2 = player[l7];
				int k2 = ((gnm2.x - myplayer.x) * 3 * k) / 2048;
				int i4 = ((gnm2.y - myplayer.y) * 3 * k) / 2048;
				int k6 = i4 * k4 + k2 * i5 >> 18;
				i4 = i4 * i5 - k2 * k4 >> 18;
				k2 = k6;
				int j8 = 0xffffff;

				if(gnm2.hcf == 1 && gnm2.hbd == 0)
				{
					gfx.drawcircle(i + 78 + k2, 112 - i4, 2, j8, 255);
				}
			}
		}
        for(int l7 = 0; l7 < playercount; l7++)
        {
            monster gnm2 = player[l7];
            int k2 = ((gnm2.x - myplayer.x) * 3 * k) / 2048;
            int i4 = ((gnm2.y - myplayer.y) * 3 * k) / 2048;
            int k6 = i4 * k4 + k2 * i5 >> 18;
            i4 = i4 * i5 - k2 * k4 >> 18;
            k2 = k6;
            int j8 = 0xffffff;

			if (ownagepk == true)
			{
				int leveler = myplayer.level - gnm2.level;
				if (leveler == 0)
					j8 = 0xffffff;
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
			}
			
			for(int k8 = 0; k8 < super.aal; k8++)
            {
                if(gnm2.gnn != super.aam[k8] || super.aan[k8] != 99)
                    continue;
                j8 = 65280;
                break;
            }
            drawmapdot(i + 78 + k2, 112 - i4, j8);

        }
        gfx.drawcircle(i + 78, 112, 2, 0xffffff, 255);
        gfx.drawrotatedpicture(i + 19, 55, dkn + 24, xrot + 128 & 0xff, 128);
        gfx.cba(0, 0, elh, eli + 12);
        if(!flag)
            return;
        i = super.mousex - (((blm) (gfx)).bln - 199);
        int i8 = super.mousey - 36;
        if(i >= 40 && i8 >= 0 && i < 196 && i8 < 152)
        {
            char c1 = '\234';
            char c3 = '\230';
            int l = 192 + ddh;
            int j1 = xrot + ddg & 0xff;
            int j = ((blm) (gfx)).bln - 199;
            j += 40;
            int l2 = ((super.mousex - (j + 78)) * 16384) / (3 * l);
            int j4 = ((super.mousey - 112) * 16384) / (3 * l);
            int l4 = bbe.bcb[1024 - j1 * 4 & 0x3ff];
            int j5 = bbe.bcb[(1024 - j1 * 4 & 0x3ff) + 1024];
            int l6 = j4 * l4 + l2 * j5 >> 15;
            j4 = j4 * j5 - l2 * l4 >> 15;
            l2 = l6;
            l2 += myplayer.x;
            j4 = myplayer.y - j4;
            if(mousebutton3 == 1)
                faj(smallx, smally, l2 / 128, j4 / 128, false);
            mousebutton3 = 0;
        }
    }
    private final void fff(int i, int j, int k)
    {
        if(k == 0)
        {
            fce(smallx, smally, i, j - 1, i, j, false, true);
            return;
        }
        if(k == 1)
        {
            fce(smallx, smally, i - 1, j, i, j, false, true);
            return;
        } else
        {
            fce(smallx, smally, i, j, i, j, true, true);
            return;
        }
    }
    public mudclient()
    {
        super();
        boolean flag = false;
        ddf = "";
        ddi = new boolean[1500];
        ddj = false;
        doorx = new int[500];
        doory = new int[500];
        dea = false;
        def = 1;
        deg = 2;
        deh = 2;
        dei = 8;
        dej = 14;
        del = 1;
        dem = false;
        den = false;
        dfa = false;
        dfb = false;
        dfd = false;
        dfe = false;
        dff = new int[500];
        twomousebuttons = false;
        dfm = new boolean[50];
        dfn = "";
        dga = new int[50];
        selecteditem = -1;
        selecteditemname = "";
        soundeffects = false;
        dgi = false;
        dgj = -1;
        dgk = -1;
        dgl = -1;
        dgm = new String[5];
        dgn = false;
        dha = false;
        dhc = -1;
        dhd = -2;
        zoom = 550;
        dhk = false;
        dhm = new int[256];
        dhn = new int[256];
        dib = false;
        did = new monster[500];
        die = new int[5];
        npc = new monster[500];
        dig = new int[50];
        dih = new int[50];
        dii = new int[50];
        dij = new int[50];
        dim = 1;
        dja = new boolean[500];
        djb = new boolean[50];
        djd = new int[50];
        dje = new int[50];
        djf = new int[5000];
        djg = new int[5000];
        djh = new int[5000];
        dji = new int[5000];
        djm = new int[99];
        dke = new int[8];
        dkf = new int[8];
        dkh = new int[14];
        dki = new int[14];
        dkl = false;
        dkm = false;
        dlg = true;
        dli = new int[14];
        dlj = new int[14];
        dll = 2;
        dma = false;
        dmb = false;
        dmc = true;
        dmd = new int[250];
        dmf = new int[8];
        dmg = new int[8];
        dmh = new int[8000];
        dmi = new int[8000];
        dmk = false;
        xrot = 128;
        dnb = -1;
        actionid = new int[250];
        dnf = false;
        dnh = new int[18];
        dnj = new monster[500];
        stat = new int[18];
        dnm = "";
        dnn = "";
        eaa = "";
        eab = new monster[5000];
        eae = new int[8];
        eaf = new int[8];
        eag = new int[256];
        eah = new int[256];
        eaj = new cgc[1000];
        eal = false;
        eam = false;
        eba = new int[50];
        selectedspell = -1;
        ecc = new int[8];
        ecd = new int[8];
        ece = new String[5];
        autocam = true;
        member = false;
        eci = "";
        edd = -1;
        edf = false;
        actionvar = new int[250];
        actionvar2 = new int[250];
        actionvar3 = new int[250];
        edk = new int[50];
        edl = new int[50];
        inside = false;
        eeb = false;
        eec = false;
        eee = false;
        actionx = new int[250];
        actiony = new int[250];
        eeh = false;
        efe = new int[5];
        efm = new int[256];
        efn = new int[256];
        ega = new int[256];
        egb = "";
        egc = false;
        egd = false;
        egf = new int[14];
        egg = new int[14];
        egj = new int[14];
        egk = new int[14];
        egl = 30;
        topmsg1 = new String[250];
        ehg = new int[8192];
        ehh = new int[8192];
        ehi = new int[50];
        ehm = 40;
        eic = 128;
        curstat = new int[18];
        topmsg2 = new String[250];
        eik = -1;
        eil = -2;
        ejc = false;
        eje = new String[50];
        ejf = new int[50];
        myplayer = new monster();
        ejn = -1;
        eke = new int[50];
        ekf = new int[50];
        ekg = new int[50];
        ekm = new monster[4000];
        mobx = new int[1500];
        moby = new int[1500];
        mobtype = new int[1500];
        mobid = new int[1500];
        eld = "";
        ele = "";
        elf = 48;
        elh = 512;
        eli = 334;
        elj = 9;
        ell = false;
        eme = 2;
        emf = new cgc[500];
        doordir = new int[500];
        emh = new int[500];
        emj = 0xbc614e;
        player = new monster[500];
        emm = new cgc[1500];
        inventory = new int[35];
        enc = new int[35];
        end = new int[35];
    }
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
    private String ddf;
    private int ddg;
    private int ddh;
    private boolean ddi[];
    private boolean ddj;
    private int mousebutton3;
    private int ddl;
    private int doorx[];
    private int doory[];
    private boolean dea;
    private int deb;
    private int dec;
    private int ded;
    private int dee;
    private int def;
    private int deg;
    private int deh;
    private int dei;
    private int dej;
    private int dek;
    private int del;
    private boolean dem;
    private boolean den;
    private boolean dfa;
    private boolean dfb;
    private int dfc;
    private boolean dfd;
    private boolean dfe;
    private int dff[];
    private int dfg;
    private int dfh;
    private int dfi;
    private int dfj;
    private int dfk;
    private boolean twomousebuttons;
    private boolean dfm[];
    private String dfn;
    private int dga[];
    private int selecteditem;
    String selecteditemname;
    private int dgd;
    private int dge;
    private int dgf;
    private int dgg;
    private boolean soundeffects;
    private boolean dgi;
    private int dgj;
    private int dgk;
    private int dgl;
    private String dgm[];
    private boolean dgn;
    private boolean dha;
    private long dhb;
    private int dhc;
    private int dhd;
    private int zoom;
    private int dhf[] = {
        0, 1, 2, 1
    };
    private int dhg;
    private int dhh;
    private int dhi;
    private int dhj;
    private boolean dhk;
    private int dhl;
    private int dhm[];
    private int dhn[];
    private String dia;
    private boolean dib;
    private int dic;
    private monster did[];
    private int die[];
    private monster npc[];
    private int dig[];
    private int dih[];
    private int dii[];
    private int dij[];
    private int dik;
    private Graphics dil;
    private int dim;
    private int din;
    private boolean dja[];
    private boolean djb[];
    private int djc;
    private int djd[];
    private int dje[];
    private int djf[];
    private int djg[];
    private int djh[];
    private int dji[];
    private int djj;
    private int djk;
    private gca djl;
    private int djm[];
    private final String djn[] = {
        "Armour", "WeaponAim", "WeaponPower", "Magic", "Prayer"
    };
    private int playercount;
    private int dkb;
    private int dkc;
    private int dkd;
    private int dke[];
    private int dkf[];
    private int dkg;
    private int dkh[];
    private int dki[];
    private int dkj;
    private int dkk;
    private boolean dkl;
    private boolean dkm;
    private int dkn;
    private int dla;
    private int dlb;
    private int dlc;
    private int dld;
    private int dle;
    private int dlf;
    private boolean dlg;
    private int dlh;
    private int dli[];
    private int dlj[];
    private int dlk;
    private int dll;
    private gig myplayerworld;
    private gca dln;
    private boolean dma;
    private boolean dmb;
    private boolean dmc;
    private int dmd[];
    private int dme;
    private int dmf[];
    private int dmg[];
    private int dmh[];
    private int dmi[];
    private int dmj;
    private boolean dmk;
    private int xrot;
    private int dmm;
    private int dmn;
    private int dna;
    private int dnb;
    private int dnc;
    private int dnd;
    private int actionid[];
    private boolean dnf;
    private dbf gfx;
    private int dnh[];
    private gca dni;
    private monster dnj[];
    private int stat[];
    private gia dnl;
    private String dnm;
    private String dnn;
    private String eaa;
    private monster eab[];
    private int eac;
    private int ead;
    private int eae[];
    private int eaf[];
    private int eag[];
    private int eah[];
    private int eai[] = {
        0, 1, 2, 1, 0, 0, 0, 0
    };
    private cgc eaj[];
    private final int eak[] = {
        0xff0000, 0xff8000, 0xffe000, 0xa0e000, 57344, 32768, 41088, 45311, 33023, 12528, 
        0xe000e0, 0x303030, 0x604000, 0x805000, 0xffffff
    };
    private boolean eal;
    private boolean eam;
    private int ean;
    private int eba[];
    private int ebb;
    private int ebc;
    private int ebd;
    private int ebe;
    private int ebf;
    private int ebg;
    private int ebh;
    private int ebi;
    private int ebj;
    private int ebk;
    private int ebl;
    private int ebm;
    private int ebn;
    private int selectedspell;
    private int ecb;
    private int ecc[];
    private int ecd[];
    private String ece[];
    private int ecf;
    private boolean autocam;
    private boolean member;
    private String eci;
    private int ecj;
    private int eck;
    private int ecl;
    private int ecm;
    private final int ecn[] = {
        0xecded0, 0xccb366, 0xb38c40, 0x997326, 0x906020
    };
    private int eda;
    private int edb;
    private int edc;
    private int edd;
    private int ede;
    private boolean edf;
    private int actionvar[];
    private int actionvar2[];
    private int actionvar3[];
    private int edj;
    private int edk[];
    private int edl[];
    private boolean inside;
    private String edn;
    private int eea;
    private boolean eeb;
    private boolean eec;
    private int eed;
    private boolean eee;
    private int actionx[];
    private int actiony[];
    private boolean eeh;
    private gca eei;
    int eej;
    int eek;
    int eel;
    int eem;
    int een;
    private int efa;
    private int efb;
    private int efc;
    private int efd;
    private int efe[];
    private int eff;
    private int efg;
    int efh;
    int efi;
    private int efj;
    private int efk;
    private int efl;
    private int efm[];
    private int efn[];
    private int ega[];
    private String egb;
    private boolean egc;
    private boolean egd;
    private int ege;
    private int egf[];
    private int egg[];
    private int selectedmenu;
    private int egi;
    private int egj[];
    private int egk[];
    private int egl;
    private int egm;
    private bbe egn;
    private int eha[][] = {
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
    private String topmsg1[];
    private int ehc;
    private int ehd;
    private int ehe;
    private int ehf;
    int ehg[];
    int ehh[];
    private int ehi[];
    private final int ehj[] = {
        0xffc030, 0xffa040, 0x805030, 0x604020, 0x303030, 0xff6020, 0xff4000, 0xffffff, 65280, 65535
    };
    private int ehk;
    private final String statname[] = {
        "Attack", "Defense", "Strength", "Hits", "Ranged", "Prayer", "Magic", "Cooking", "Woodcutting", "Fletching", 
        "Fishing", "Firemaking", "Crafting", "Smithing", "Mining", "Herblaw", "Agility", "Thieving"
    };
    private int ehm;
    private gca ehn;
    int eia;
    int eib;
    private int eic;
    private int eid;
    private int curstat[];
    private int mobcount;
    private int eig;
    private int eih;
    private String topmsg2[];
    private gca eij;
    private int eik;
    private int eil;
    private int eim;
    private int ein;
    private int eja;
    private int ejb;
    private boolean ejc;
    private int ejd;
    String eje[];
    private int ejf[];
    private gca ejg;
    int ejh;
    int eji;
    private byte ejj[];
    private monster myplayer;
    int smallx;
    int smally;
    int ejn;
    private gca eka;
    int ekb;
    int ekc;
    long ekd;
    private int eke[];
    private int ekf[];
    private int ekg[];
    private long ekh;
    private int eki;
    private int ekj;
    private int ekk;
    private int ekl;
    private monster ekm[];
    private int mobx[];
    private int moby[];
    private int mobtype[];
    private int mobid[];
    private String eld;
    private String ele;
    private int elf;
    private final String questname[] = {
        "Black knight's fortress", "Cook's assistant", "Demon slayer", "Doric's quest", "The restless ghost", "Goblin diplomacy", "Ernest the chicken", "Imp catcher", "Pirate's treasure", "Prince Ali rescue", 
        "Romeo & Juliet", "Sheep shearer", "Shield of Arrav", "The knight's sword", "Vampire slayer", "Witch's potion", "Dragon slayer", "Witch's house (members)", "Lost city (members)", "Hero's quest (members)", 
        "Druidic ritual (members)", "Merlin's crystal (members)", "Scorpion catcher (members)", "Family crest (members)", "Tribal totem (members)", "Fishing contest (members)", "Monk's friend (members)", "Temple of Ikov (members)", "Clock tower (members)", "The Holy Grail (members)", 
        "Fight Arena (members)", "Tree Gnome Village (members)", "The Hazeel Cult (members)", "Sheep Herder (members)", "Plague City (members)", "Sea Slug (members)", "Waterfall quest (members)", "Biohazard (members)", "Jungle potion (members)", "Grand tree (members)", 
        "Shilo village (members)", "Underground pass (members)", "Observatory quest (members)", "Tourist trap (members)", "Watchtower (members)", "Dwarf Cannon (members)", "Murder Mystery (members)", "Digsite (members)", "Gertrude's Cat (members)", "Legend's Quest (members)"
    };
    private int elh;
    private int eli;
    private int elj;
    private int elk;
    private boolean ell;
    private int elm;
    private int eln;
    private int ema;
    private int emb;
    private int actioncount;
    private int emd;
    private int eme;
    private cgc emf[];
    private int doordir[];
    private int emh[];
    private int emi[] = {
        0, 0, 0, 0, 0, 1, 2, 1
    };
    private int emj;
    private final String statname2[] = {
        "Attack", "Defense", "Strength", "Hits", "Ranged", "Prayer", "Magic", "Cooking", "Woodcut", "Fletching", 
        "Fishing", "Firemaking", "Crafting", "Smithing", "Mining", "Herblaw", "Agility", "Thieving"
    };
    private monster player[];
    private cgc emm[];
    private int emn;
    private int invcount;
    private int inventory[];
    private int enc[];
    private int end[];
    private final String ene[] = {
        "Where were you born?", "What was your first teachers name?", "What is your fathers middle name?", "Who was your first best friend?", "What is your favourite vacation spot?", "What is your mothers middle name?", "What was your first pets name?", "What was the name of your first school?", "What is your mothers maiden name?", "Who was your first boyfriend/girlfriend?", 
        "What was the first computer game you purchased?", "Who is your favourite actor/actress?", "Who is your favourite author?", "Who is your favourite musician?", "Who is your favourite cartoon character?", "What is your favourite book?", "What is your favourite food?", "What is your favourite movie?"
    };
}
