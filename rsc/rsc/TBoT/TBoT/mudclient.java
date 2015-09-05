import java.applet.Applet;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.Hashtable;

public final class mudclient extends b
{
	public static final String version = "0.2";
	public boolean debug = false;
	public Script macro = null;
	public boolean running = false;
	public static Hashtable macros;
	public static mudclient mudclient1;
	public int decWorld;
	public int incWorld;
	public int checkUpdate;
	public String mainMenuMessage = null;
	public boolean graphicsEnabled = true;
	public boolean mainMenuBusy = false;
	public boolean zoomIn = false;
	public boolean zoomOut = false;
	public int zRot = 912;
	public boolean zRotUp = false;
	public boolean zRotDown = false;
	public boolean fogOfWar = true;
	public boolean autoLogin = false;
	public String lastServerMessage = "";
	public boolean loading = false;
	public boolean recordingSteps = false;
	public int recordingStepX[] = new int[500];
	public int recordingStepY[] = new int[500];
	public int recordingStepLength = 0;
	public String lastChatMessage = "";
	public String lastChatter = "";
	public String lastQuestMessage = "";
	public int lastQuestNpcId = -1;
	public String lastPM = "";
	public String lastPMer = "";


    public static final void main(String args[])
    {
		System.out.println("### TBoT201 - RichyT v" + version + "Updated by Rich Lil Nigg");
        mudclient1 = new mudclient();
        mudclient1.dhh = false;
        if(args.length > 0 && args[0].equals("members"))
            mudclient1.member = true;
        if(args.length > 1)
            mudclient1.serverHost = args[1];
        if(args.length > 2)
            mudclient1.serverPort = Integer.parseInt(args[2]);
        mudclient1.createWindow(mudclient1.width, mudclient1.height + 11, "TBoT201 - RichyT updated by Rich Lil Nigg", false);
        mudclient1.fkd = 10;
		ServerList.setWorld(81);
		try
		{
			mudclient1.serverHost = ServerList.getWorld();
			mudclient1.serverPort = ServerList.getPort();
			t.serverIP = new URL(ServerList.getWorld());
		}
		catch(Exception _ex) { }
		loadScripts(mudclient1);
    }

	public static void loadScripts(mudclient mudclient1)
	{
		macros = new Hashtable();
		System.out.println("## Loading scripts from " + System.getProperty("user.dir") + "\\Scripts\\");
		File f = new File(System.getProperty("user.dir") + "/Scripts");
		String[] files = f.list();
		int scriptCount = 0;
		int commandCount = 0;
		for(int i = 0; i < files.length;i++)
		{
			try
			{
				if(files[i].endsWith(".class") && files[i].indexOf('$') == -1)
				{
					Class clazz = Class.forName(files[i].substring(0,files[i].length()-".class".length()));
					Script macro = (Script)clazz.getConstructor(new Class[]{mudclient.class}).newInstance(new Object[]{mudclient1});
					String[] commands = macro.getCommands();
					System.out.println(files[i] + " -");
					scriptCount++;
					for(int j = 0; j < commands.length;j++)
					{
						System.out.println(" - " + commands[j]);
						macros.put(commands[j], macro);
						commandCount++;
					}
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				e.toString();
			}
		}
		System.out.println("## " + scriptCount + " scripts found, with " + commandCount + " commands");
	}

    public final void drawFightMode()
    {
        byte byte0 = 7;
        byte byte1 = 15;
        char c1 = '\257';
        if(ebd != 0)
        {
            for(int l = 0; l < 5; l++)
            {
                if(l <= 0 || super.mouseX <= byte0 || super.mouseX >= byte0 + c1 || super.mouseY <= byte1 + l * 20 || super.mouseY >= byte1 + l * 20 + 20)
                    continue;
                fightMode = l - 1;
                ebd = 0;
                super.connection.newID(74);
                super.connection.addVar(fightMode);
                super.connection.complete();
                break;
            }

        }
        for(int i1 = 0; i1 < 5; i1++)
        {
            if(i1 == fightMode + 1)
                gfx.drawBoxAlpha(byte0, byte1 + i1 * 20, c1, 20, j.createRGB(255, 0, 0), 128);
            else
                gfx.drawBoxAlpha(byte0, byte1 + i1 * 20, c1, 20, j.createRGB(190, 190, 190), 128);
            gfx.drawLine(byte0, byte1 + i1 * 20, c1, 0);
            gfx.drawLine(byte0, byte1 + i1 * 20 + 20, c1, 0);
        }

        gfx.drawText("Select combat style", byte0 + c1 / 2, byte1 + 16, 3, 0xffffff);
        gfx.drawText("Controlled (+1 of each)", byte0 + c1 / 2, byte1 + 36, 3, 0);
        gfx.drawText("Aggressive (+3 strength)", byte0 + c1 / 2, byte1 + 56, 3, 0);
        gfx.drawText("Accurate   (+3 attack)", byte0 + c1 / 2, byte1 + 76, 3, 0);
        gfx.drawText("Defensive  (+3 defense)", byte0 + c1 / 2, byte1 + 96, 3, 0);
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

    public final void emh(int l, String s1)
    {
        int i1 = objectX[l];
        int j1 = objectY[l];
        int k1 = i1 - myPlayer.x / 128;
        int l1 = j1 - myPlayer.y / 128;
        byte byte0 = 7;
        if(i1 >= 0 && j1 >= 0 && i1 < 96 && j1 < 96 && k1 > -byte0 && k1 < byte0 && l1 > -byte0 && l1 < byte0)
        {
            efn.bgn(ddf[l]);
            int i2 = identify.anj(s1);
            i j2 = dkj[i2].cnj();
            efn.bgm(j2);
            j2.cme(true, 48, 48, -50, -10, -50);
            j2.cnl(ddf[l]);
            j2.chk = l;
            ddf[l] = j2;
        }
    }

    public final void drawLogoutBox()
    {
        gfx.drawBox(126, 137, 260, 60, 0);
        gfx.drawBoxEdge(126, 137, 260, 60, 0xffffff);
        gfx.drawText("Logging out...", 256, 173, 5, 0xffffff);
    }

    public final void drawMenus()
    {
        dea = false;
        gfx.bnc = false;
        gfx.cak();
        if(ehl == 0 || ehl == 1 || ehl == 2 || ehl == 3)
        {
            int l = (dji * 2) % 3072;
            if(l < 1024)
            {
                gfx.drawPicture(0, 10, dfd);
                if(l > 768)
                    gfx.ccd(0, 10, dfd + 1, l - 768);
            } else
            if(l < 2048)
            {
                gfx.drawPicture(0, 10, dfd + 1);
                if(l > 1792)
                    gfx.ccd(0, 10, del + 10, l - 1792);
            } else
            {
                gfx.drawPicture(0, 10, del + 10);
                if(l > 2816)
                    gfx.ccd(0, 10, dfd, l - 2816);
            }
        }
        if(ehl == 0)
            menuMain.ged();
        if(ehl == 1)
            menuNewAccount.ged();
        if(ehl == 2)
            menuLogin.ged();
        gfx.drawPicture(0, height, del + 22);
        gfx.drawGame(dci, 0, 0);
    }

    protected final void adf(int arg0, int arg1, byte arg2[])
    {
        try
        {
            if(arg0 == 141)
            {
                efh = playerCount;
                for(int l = 0; l < efh; l++)
                    dmn[l] = player[l];

                int l7 = 8;
                smallX = t.fmn(arg2, l7, 11);
                l7 += 11;
                smallY = t.fmn(arg2, l7, 13);
                l7 += 13;
                int i14 = t.fmn(arg2, l7, 4);
                l7 += 4;
                boolean flag1 = fdg(smallX, smallY);
                smallX -= bigX;
                smallY -= bigY;
                int i23 = smallX * magicLoc + 64;
                int i26 = smallY * magicLoc + 64;
                if(flag1)
                {
                    myPlayer.miniWalk = 0;
                    myPlayer.gmn = 0;
                    myPlayer.x = myPlayer.gnb[0] = i23;
                    myPlayer.y = myPlayer.gnc[0] = i26;
                }
                playerCount = 0;
                myPlayer = eml(dgf, i23, i26, i14);
                int j29 = t.fmn(arg2, l7, 8);
                l7 += 8;
                for(int i34 = 0; i34 < j29; i34++)
                {
                    f f4 = dmn[i34 + 1];
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
                            int j44 = f4.miniWalk;
                            int i45 = f4.gnb[j44];
                            int j45 = f4.gnc[j44];
                            if(j43 == 2 || j43 == 1 || j43 == 3)
                                i45 += magicLoc;
                            if(j43 == 6 || j43 == 5 || j43 == 7)
                                i45 -= magicLoc;
                            if(j43 == 4 || j43 == 3 || j43 == 5)
                                j45 += magicLoc;
                            if(j43 == 0 || j43 == 1 || j43 == 7)
                                j45 -= magicLoc;
                            f4.gmm = j43;
                            f4.miniWalk = j44 = (j44 + 1) % 10;
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
                    player[playerCount++] = f4;
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
                    int j23 = (smallX + j42) * magicLoc + 64;
                    int j26 = (smallY + l43) * magicLoc + 64;
                    eml(j40, j23, j26, j14);
                    if(k44 == 0)
                        dde[k37++] = j40;
                }
                if(k37 > 0)
                {
                    super.connection.newID(241);
                    super.connection.addInt(k37);
                    for(int k40 = 0; k40 < k37; k40++)
                    {
                        f f5 = eba[dde[k40]];
                        super.connection.addInt(f5.id);
                        super.connection.addInt(f5.gmg);
                    }

                    super.connection.complete();
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
                        int k14 = smallX + arg2[i1 + 1] >> 3;
                        int j19 = smallY + arg2[i1 + 2] >> 3;
                        i1 += 3;
                        for(int k23 = 0; k23 < itemCount; k23++)
                        {
                            int k26 = (itemX[k23] >> 3) - k14;
                            int k29 = (itemY[k23] >> 3) - j19;
                            if(k26 != 0 || k29 != 0)
                            {
                                if(k23 != i8)
                                {
                                    itemX[i8] = itemX[k23];
                                    itemY[i8] = itemY[k23];
                                    itemType[i8] = itemType[k23];
                                    ekm[i8] = ekm[k23];
                                }
                                i8++;
                            }
                        }

                        itemCount = i8;
                    } else
                    {
                        int j8 = t.fmi(arg2, i1);
                        i1 += 2;
                        int l14 = smallX + arg2[i1++];
                        int k19 = smallY + arg2[i1++];
                        if((j8 & 0x8000) == 0)
                        {
                            itemX[itemCount] = l14;
                            itemY[itemCount] = k19;
                            itemType[itemCount] = j8;
                            ekm[itemCount] = 0;
                            for(int l23 = 0; l23 < objectCount; l23++)
                            {
                                if(objectX[l23] != l14 || objectY[l23] != k19)
                                    continue;
                                ekm[itemCount] = identify.ama[objectType[l23]];
                                break;
                            }

                            itemCount++;
                        } else
                        {
                            j8 &= 0x7fff;
                            int i24 = 0;
                            for(int l26 = 0; l26 < itemCount; l26++)
                                if(itemX[l26] != l14 || itemY[l26] != k19 || itemType[l26] != j8)
                                {
                                    if(l26 != i24)
                                    {
                                        itemX[i24] = itemX[l26];
                                        itemY[i24] = itemY[l26];
                                        itemType[i24] = itemType[l26];
                                        ekm[i24] = ekm[l26];
                                    }
                                    i24++;
                                } else
                                {
                                    j8 = -123;
                                }

                            itemCount = i24;
                        }
                    }

                return;
            }
            if(arg0 == 158)
            {
                for(int j1 = 1; j1 < arg1;)
                    if(t.fmh(arg2[j1]) == 255) // unsign byte (possibly a trigger?)
                    {
                        int k8 = 0; // counter, eventually object count. Don't understand
                        int i15 = smallX + arg2[j1 + 1] >> 3; // arguement = largeX ?
                        int l19 = smallY + arg2[j1 + 2] >> 3; // arguement = largeY ?
                        j1 += 3; // skip 3 bytes because of other calls to buffer
                        for(int j24 = 0; j24 < objectCount; j24++) // run loop through objects
                        {
                            int i27 = (objectX[j24] >> 3) - i15; // store object's X minus current X  ?
                            int l29 = (objectY[j24] >> 3) - l19; // store object's Y minus current Y ?
                            if(i27 != 0 || l29 != 0) // make sure different is not 0
                            {
                                if(j24 != k8) // make sure looping integer is not same as (soon to be) object count
                                {
                                    ddf[k8] = ddf[j24]; // 
                                    ddf[k8].chk = k8;
                                    objectX[k8] = objectX[j24];
                                    objectY[k8] = objectY[j24];
                                    objectType[k8] = objectType[j24];
                                    objectID[k8] = objectID[j24];
                                }
                                k8++;
                            } else
                            {
                                efn.bgn(ddf[j24]);
                                gameHandle.gkg(objectX[j24], objectY[j24], objectType[j24]);
                            }
                        }

                        objectCount = k8;
                    } else
                    {
                        int l8 = t.fmi(arg2, j1);
                        j1 += 2;
                        int j15 = smallX + arg2[j1++];
                        int i20 = smallY + arg2[j1++];
                        int k24 = 0;
                        for(int j27 = 0; j27 < objectCount; j27++)
                            if(objectX[j27] != j15 || objectY[j27] != i20)
                            {
                                if(j27 != k24)
                                {
                                    ddf[k24] = ddf[j27];
                                    ddf[k24].chk = k24;
                                    objectX[k24] = objectX[j27];
                                    objectY[k24] = objectY[j27];
                                    objectType[k24] = objectType[j27];
                                    objectID[k24] = objectID[j27];
                                }
                                k24++;
                            } else
                            {
                                efn.bgn(ddf[j27]);
                                gameHandle.gkg(objectX[j27], objectY[j27], objectType[j27]);
                            }

                        objectCount = k24;
                        if(l8 != 60000)
                        {
                            int i30 = gameHandle.gjh(j15, i20);
                            int j34;
                            int l37;
                            if(i30 == 0 || i30 == 4)
                            {
                                j34 = identify.all[l8];
                                l37 = identify.alm[l8];
                            } else
                            {
                                l37 = identify.all[l8];
                                j34 = identify.alm[l8];
                            }
                            int l40 = ((j15 + j15 + j34) * magicLoc) / 2;
                            int k42 = ((i20 + i20 + l37) * magicLoc) / 2;
                            int i44 = identify.alk[l8];
                            i l44 = dkj[i44].cnj();
                            efn.bgm(l44);
                            l44.chk = objectCount;
                            l44.cmi(0, i30 * 32, 0);
                            l44.cmk(l40, -gameHandle.gla(l40, k42), k42);
                            l44.cme(true, 48, 48, -50, -10, -50);
                            gameHandle.gjj(j15, i20, l8);
                            if(l8 == 74)
                                l44.cmk(0, -480, 0);
                            objectX[objectCount] = j15;
                            objectY[objectCount] = i20;
                            objectType[objectCount] = l8;
                            objectID[objectCount] = i30;
                            ddf[objectCount++] = l44;
                        }
                    }

                return;
            }
            if(arg0 == 37)
            {
                int k1 = 1;
                invCount = arg2[k1++] & 0xff;
                for(int i9 = 0; i9 < invCount; i9++)
                {
                    int k15 = t.fmi(arg2, k1);
                    k1 += 2;
                    inv[i9] = k15 & 0x7fff;
                    wearing[i9] = k15 / 32768;
                    if(identify.stackable[k15 & 0x7fff] == 0)
                    {
                        invValue[i9] = t.fmm(arg2, k1);
                        if(invValue[i9] >= 128)
                            k1 += 4;
                        else
                            k1++;
                    } else
                    {
                        invValue[i9] = 1;
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
                    f f1 = eba[j20];
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
                                f1.lastSaidTimeout = 150;
                                f1.lastSaid = s3;
								lastChatMessage = s3;
								lastChatter = f1.name;
                                displayMessage(f1.name + ": " + f1.lastSaid, 2);
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
                            if(f1 == myPlayer)
                            {
                                currentStat[3] = k34;
                                playerStat[3] = i38;
                                eab = false;
                                ega = false;
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
                            f1.hag = ebc;
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
                            f1.hag = ebc;
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
                            f1.name = t.grabFriendName(f1.gmd);
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
                            f1.level = arg2[j9++] & 0xff;
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
                            f1.lastSaidTimeout = 150;
                            f1.lastSaid = s4;
                            if(f1 == myPlayer)
                                displayMessage(f1.name + ": " + f1.lastSaid, 5);
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
                        int i16 = smallX + arg2[i2 + 1] >> 3;
                        int k20 = smallY + arg2[i2 + 2] >> 3;
                        i2 += 3;
                        for(int l24 = 0; l24 < doorCount; l24++)
                        {
                            int k27 = (doorX[l24] >> 3) - i16;
                            int l31 = (doorY[l24] >> 3) - k20;
                            if(k27 != 0 || l31 != 0)
                            {
                                if(l24 != k9)
                                {
                                    dkl[k9] = dkl[l24];
                                    dkl[k9].chk = k9 + 10000;
                                    doorX[k9] = doorX[l24];
                                    doorY[k9] = doorY[l24];
                                    doorDir[k9] = doorDir[l24];
                                    doorType[k9] = doorType[l24];
                                }
                                k9++;
                            } else
                            {
                                efn.bgn(dkl[l24]);
                                gameHandle.gke(doorX[l24], doorY[l24], doorDir[l24], doorType[l24]);
                            }
                        }

                        doorCount = k9;
                    } else
                    {
                        int l9 = t.fmi(arg2, i2);
                        i2 += 2;
                        int j16 = smallX + arg2[i2++];
                        int l20 = smallY + arg2[i2++];
                        byte byte5 = arg2[i2++];
                        int l27 = 0;
                        for(int i32 = 0; i32 < doorCount; i32++)
                            if(doorX[i32] != j16 || doorY[i32] != l20 || doorDir[i32] != byte5)
                            {
                                if(i32 != l27)
                                {
                                    dkl[l27] = dkl[i32];
                                    dkl[l27].chk = l27 + 10000;
                                    doorX[l27] = doorX[i32];
                                    doorY[l27] = doorY[i32];
                                    doorDir[l27] = doorDir[i32];
                                    doorType[l27] = doorType[i32];
                                }
                                l27++;
                            } else
                            {
                                efn.bgn(dkl[i32]);
                                gameHandle.gke(doorX[i32], doorY[i32], doorDir[i32], doorType[i32]);
                            }

                        doorCount = l27;
                        if(l9 != 65535)
                        {
                            gameHandle.gkj(j16, l20, byte5, l9);
                            i k35 = feg(j16, l20, byte5, l9, doorCount);
                            dkl[doorCount] = k35;
                            doorX[doorCount] = j16;
                            doorY[doorCount] = l20;
                            doorType[doorCount] = l9;
                            doorDir[doorCount++] = byte5;
                        }
                    }

                return;
            }
            if(arg0 == 41)
            {
                dnk = npcCount;
                npcCount = 0;
                for(int j2 = 0; j2 < dnk; j2++)
                    eii[j2] = npc[j2];

                int i10 = 8;
                int k16 = t.fmn(arg2, i10, 8);
                i10 += 8;
                for(int i21 = 0; i21 < k16; i21++)
                {
                    f f2 = eii[i21];
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
                            int k38 = f2.miniWalk;
                            int j41 = f2.gnb[k38];
                            int l42 = f2.gnc[k38];
                            if(l35 == 2 || l35 == 1 || l35 == 3)
                                j41 += magicLoc;
                            if(l35 == 6 || l35 == 5 || l35 == 7)
                                j41 -= magicLoc;
                            if(l35 == 4 || l35 == 3 || l35 == 5)
                                l42 += magicLoc;
                            if(l35 == 0 || l35 == 1 || l35 == 7)
                                l42 -= magicLoc;
                            f2.gmm = l35;
                            f2.miniWalk = k38 = (k38 + 1) % 10;
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
                    npc[npcCount++] = f2;
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
                    int l38 = (smallX + j28) * magicLoc + 64;
                    int k41 = (smallY + k32) * magicLoc + 64;
                    int i43 = t.fmn(arg2, i10, 10);
                    i10 += 10;
                    if(i43 >= identify.ald)
                        i43 = 24;
                    faj(i25, l38, k41, j36, i43);
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
                    f f3 = dgj[j21];
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
                            f3.lastSaidTimeout = 150;
                            f3.lastSaid = s5;
							lastQuestMessage = s5;
							lastQuestNpcId = f3.id;
							if (macro != null && running)
								macro.questMessage(s5,f3.id);
                            if(l32 == myPlayer.id)
                                displayMessage("@yel@" + identify.npcName[f3.type] + ": " + f3.lastSaid, 5);
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
                questMenu = true;
                int l2 = t.fmh(arg2[1]);
                questMenuCount = l2;
                int k10 = 2;
                for(int i17 = 0; i17 < l2; i17++)
                {
                    int k21 = t.fmh(arg2[k10]);
                    k10++;
                    questMenuAnswer[i17] = new String(arg2, k10, k21);
                    k10 += k21;
                }

                return;
            }
            if(arg0 == 208)
            {
                questMenu = false;
                return;
            }
            if(arg0 == 249)
            {
                dcj = true;
                dgf = t.fmi(arg2, 1);
                dnd = t.fmi(arg2, 3);
                dne = t.fmi(arg2, 5);
                din = t.fmi(arg2, 7);
                dnf = t.fmi(arg2, 9);
                dne -= din * dnf;
                return;
            }
            if(arg0 == 16)
            {
                int i3 = 1;
                for(int l10 = 0; l10 < 18; l10++)
                    currentStat[l10] = t.fmh(arg2[i3++]);

                for(int j17 = 0; j17 < 18; j17++)
                    playerStat[j17] = t.fmh(arg2[i3++]);

                for(int l21 = 0; l21 < 18; l21++)
                {
                    statExperience[l21] = t.fmj(arg2, i3);
                    i3 += 4;
                }

                questPoints = t.fmh(arg2[i3++]);
                return;
            }
            if(arg0 == 33)
            {
                for(int j3 = 0; j3 < 5; j3++)
                    ebb[j3] = t.fmh(arg2[1 + j3]);

                return;
            }
            if(arg0 == 109)
            {
                dfl = 250;
                return;
            }
            if(arg0 == 76)
            {
                int k3 = (arg1 - 1) / 4;
                for(int i11 = 0; i11 < k3; i11++)
                {
                    int k17 = smallX + t.fml(arg2, 1 + i11 * 4) >> 3;
                    int i22 = smallY + t.fml(arg2, 3 + i11 * 4) >> 3;
                    int j25 = 0;
                    for(int l28 = 0; l28 < itemCount; l28++)
                    {
                        int j33 = (itemX[l28] >> 3) - k17;
                        int l36 = (itemY[l28] >> 3) - i22;
                        if(j33 != 0 || l36 != 0)
                        {
                            if(l28 != j25)
                            {
                                itemX[j25] = itemX[l28];
                                itemY[j25] = itemY[l28];
                                itemType[j25] = itemType[l28];
                                ekm[j25] = ekm[l28];
                            }
                            j25++;
                        }
                    }

                    itemCount = j25;
                    j25 = 0;
                    for(int k33 = 0; k33 < objectCount; k33++)
                    {
                        int i37 = (objectX[k33] >> 3) - k17;
                        int j39 = (objectY[k33] >> 3) - i22;
                        if(i37 != 0 || j39 != 0)
                        {
                            if(k33 != j25)
                            {
                                ddf[j25] = ddf[k33];
                                ddf[j25].chk = j25;
                                objectX[j25] = objectX[k33];
                                objectY[j25] = objectY[k33];
                                objectType[j25] = objectType[k33];
                                objectID[j25] = objectID[k33];
                            }
                            j25++;
                        } else
                        {
                            efn.bgn(ddf[k33]);
                            gameHandle.gkg(objectX[k33], objectY[k33], objectType[k33]);
                        }
                    }

                    objectCount = j25;
                    j25 = 0;
                    for(int j37 = 0; j37 < doorCount; j37++)
                    {
                        int k39 = (doorX[j37] >> 3) - k17;
                        int l41 = (doorY[j37] >> 3) - i22;
                        if(k39 != 0 || l41 != 0)
                        {
                            if(j37 != j25)
                            {
                                dkl[j25] = dkl[j37];
                                dkl[j25].chk = j25 + 10000;
                                doorX[j25] = doorX[j37];
                                doorY[j25] = doorY[j37];
                                doorDir[j25] = doorDir[j37];
                                doorType[j25] = doorType[j37];
                            }
                            j25++;
                        } else
                        {
                            efn.bgn(dkl[j37]);
                            gameHandle.gke(doorX[j37], doorY[j37], doorDir[j37], doorType[j37]);
                        }
                    }

                    doorCount = j25;
                }

                return;
            }
            if(arg0 == 7)
            {
                efc = true;
                return;
            }
            if(arg0 == 108)
            {
                int l3 = t.fmi(arg2, 1);
                if(eba[l3] != null)
                    ddg = eba[l3].name;
                trade = true;
                tradeAccepted = false;
                myPlayerAcceptedTrade = false;
                myTradeItemCount = 0;
                ecl = 0;
                return;
            }
            if(arg0 == 113)
            {
                trade = false;
                tradeSecondScreen = false;
                return;
            }
            if(arg0 == 115)
            {
                ecl = arg2[1] & 0xff;
                int i4 = 2;
                for(int j11 = 0; j11 < ecl; j11++)
                {
                    ecm[j11] = t.fmi(arg2, i4);
                    i4 += 2;
                    ecn[j11] = t.fmj(arg2, i4);
                    i4 += 4;
                }

                tradeAccepted = false;
                myPlayerAcceptedTrade = false;
                return;
            }
            if(arg0 == 185)
            {
                byte byte0 = arg2[1];
                if(byte0 == 1)
                {
                    tradeAccepted = true;
                    return;
                } else
                {
                    tradeAccepted = false;
                    return;
                }
            }
            if(arg0 == 24)
            {
                shop = true;
                int j4 = 1;
                int k11 = arg2[j4++] & 0xff;
                byte byte4 = arg2[j4++];
                dnh = arg2[j4++] & 0xff;
                dni = arg2[j4++] & 0xff;
                for(int j22 = 0; j22 < 40; j22++)
                    shopItem[j22] = -1;

                for(int k25 = 0; k25 < k11; k25++)
                {
                    shopItem[k25] = t.fmi(arg2, j4);
                    j4 += 2;
                    shopItemCount[k25] = t.fmi(arg2, j4);
                    j4 += 2;
                    dka[k25] = arg2[j4++];
                }

                if(byte4 == 1)
                {
                    int i29 = 39;
                    for(int l33 = 0; l33 < invCount; l33++)
                    {
                        if(i29 < k11)
                            break;
                        boolean flag2 = false;
                        for(int l39 = 0; l39 < 40; l39++)
                        {
                            if(shopItem[l39] != inv[l33])
                                continue;
                            flag2 = true;
                            break;
                        }

                        if(inv[l33] == 10)
                            flag2 = true;
                        if(!flag2)
                        {
                            shopItem[i29] = inv[l33] & 0x7fff;
                            shopItemCount[i29] = 0;
                            dka[i29] = 0;
                            i29--;
                        }
                    }

                }
                if(selectedShop >= 0 && selectedShop < 40 && shopItem[selectedShop] != dmm)
                {
                    selectedShop = -1;
                    dmm = -2;
                }
                return;
            }
            if(arg0 == 42)
            {
                shop = false;
                return;
            }
            if(arg0 == 170)
            {
                byte byte1 = arg2[1];
                if(byte1 == 1)
                {
                    myPlayerAcceptedTrade = true;
                    return;
                } else
                {
                    myPlayerAcceptedTrade = false;
                    return;
                }
            }
            if(arg0 == 161)
            {
                efb = t.fmh(arg2[1]) == 1;
                dek = t.fmh(arg2[2]) == 1;
                ejl = t.fmh(arg2[3]) == 1;
                return;
            }
            if(arg0 == 222)
            {
                for(int k4 = 0; k4 < arg1 - 1; k4++)
                {
                    boolean flag = arg2[k4 + 1] == 1;
                    if(!dhe[k4] && flag)
                        fdb("prayeron");
                    if(dhe[k4] && !flag)
                        fdb("prayeroff");
                    dhe[k4] = flag;
                }

                return;
            }
            if(arg0 == 26)
            {
                for(int l4 = 0; l4 < 50; l4++)
                    dkk[l4] = arg2[l4 + 1] == 1;

                return;
            }
            if(arg0 == 188)
            {
                bank = true;
                int i5 = 1;
                dec = arg2[i5++] & 0xff;
                dnb = arg2[i5++] & 0xff;
                for(int l11 = 0; l11 < dec; l11++)
                {
                    ecf[l11] = t.fmi(arg2, i5);
                    i5 += 2;
                    ecg[l11] = t.fmm(arg2, i5);
                    if(ecg[l11] >= 128)
                        i5 += 4;
                    else
                        i5++;
                }

                ene();
                return;
            }
            if(arg0 == 130)
            {
                bank = false;
                return;
            }
            if(arg0 == 69)
            {
                int j5 = arg2[1] & 0xff;
                statExperience[j5] = t.fmj(arg2, 2);
                return;
            }
            if(arg0 == 240)
            {
                int k5 = t.fmi(arg2, 1);
                if(eba[k5] != null)
                    duelingWithName = eba[k5].name;
                duel = true;
                myDuelItemCount = 0;
                duelItemCount = 0;
                duelAccepted = false;
                myPlayerAcceptedDuel = false;
                noRetreat = false;
                noMagic = false;
                noPrayer = false;
                noWeapons = false;
                return;
            }
            if(arg0 == 198)
            {
                duel = false;
                duelSecondScreen = false;
                return;
            }
            if(arg0 == 128)
            {
                tradeSecondScreen = true;
                myPlayerAcceptedTradeSecondScreen = false;
                trade = false;
                int l5 = 1;
                ekf = t.fmk(arg2, l5);
                l5 += 8;
                eje = arg2[l5++] & 0xff;
                for(int i12 = 0; i12 < eje; i12++)
                {
                    ejf[i12] = t.fmi(arg2, l5);
                    l5 += 2;
                    ejg[i12] = t.fmj(arg2, l5);
                    l5 += 4;
                }

                egh = arg2[l5++] & 0xff;
                for(int l17 = 0; l17 < egh; l17++)
                {
                    egi[l17] = t.fmi(arg2, l5);
                    l5 += 2;
                    egj[l17] = t.fmj(arg2, l5);
                    l5 += 4;
                }

                return;
            }
            if(arg0 == 229)
            {
                duelItemCount = arg2[1] & 0xff;
                int i6 = 2;
                for(int j12 = 0; j12 < duelItemCount; j12++)
                {
                    duelItem[j12] = t.fmi(arg2, i6);
                    i6 += 2;
                    duelItemValue[j12] = t.fmj(arg2, i6);
                    i6 += 4;
                }

                duelAccepted = false;
                myPlayerAcceptedDuel = false;
                return;
            }
            if(arg0 == 211)
            {
                if(arg2[1] == 1)
                    noRetreat = true;
                else
                    noRetreat = false;
                if(arg2[2] == 1)
                    noMagic = true;
                else
                    noMagic = false;
                if(arg2[3] == 1)
                    noPrayer = true;
                else
                    noPrayer = false;
                if(arg2[4] == 1)
                    noWeapons = true;
                else
                    noWeapons = false;
                duelAccepted = false;
                myPlayerAcceptedDuel = false;
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
                    dec--;
                    for(int l25 = k12; l25 < dec; l25++)
                    {
                        ecf[l25] = ecf[l25 + 1];
                        ecg[l25] = ecg[l25 + 1];
                    }

                } else
                {
                    ecf[k12] = i18;
                    ecg[k12] = k22;
                    if(k12 >= dec)
                        dec = k12 + 1;
                }
                ene();
                return;
            }
            if(arg0 == 210)
            {
                int k6 = 1;
                int l12 = 1;
                int j18 = arg2[k6++] & 0xff;
                int l22 = t.fmi(arg2, k6);
                k6 += 2;
                if(identify.stackable[l22 & 0x7fff] == 0)
                {
                    l12 = t.fmm(arg2, k6);
                    if(l12 >= 128)
                        k6 += 4;
                    else
                        k6++;
                }
                inv[j18] = l22 & 0x7fff;
                wearing[j18] = l22 / 32768;
                invValue[j18] = l12;
                if(j18 >= invCount)
                    invCount = j18 + 1;
                return;
            }
            if(arg0 == 44)
            {
                int l6 = arg2[1] & 0xff;
                invCount--;
                for(int i13 = l6; i13 < invCount; i13++)
                {
                    inv[i13] = inv[i13 + 1];
                    invValue[i13] = invValue[i13 + 1];
                    wearing[i13] = wearing[i13 + 1];
                }

                return;
            }
            if(arg0 == 23)
            {
                int i7 = 1;
                int j13 = arg2[i7++] & 0xff;
                currentStat[j13] = t.fmh(arg2[i7++]);
                playerStat[j13] = t.fmh(arg2[i7++]);
                statExperience[j13] = t.fmj(arg2, i7);
                i7 += 4;
                return;
            }
            if(arg0 == 73)
            {
                byte byte2 = arg2[1];
                if(byte2 == 1)
                {
                    duelAccepted = true;
                    return;
                } else
                {
                    duelAccepted = false;
                    return;
                }
            }
            if(arg0 == 131)
            {
                byte byte3 = arg2[1];
                if(byte3 == 1)
                {
                    myPlayerAcceptedDuel = true;
                    return;
                } else
                {
                    myPlayerAcceptedDuel = false;
                    return;
                }
            }
            if(arg0 == 10)
            {
                duelSecondScreen = true;
                myPlayerAcceptedDuelSecondScreen = false;
                duel = false;
                int j7 = 1;
                eme = t.fmk(arg2, j7);
                j7 += 8;
                dhb = arg2[j7++] & 0xff;
                for(int k13 = 0; k13 < dhb; k13++)
                {
                    dhc[k13] = t.fmi(arg2, j7);
                    j7 += 2;
                    dhd[k13] = t.fmj(arg2, j7);
                    j7 += 4;
                }

                dgg = arg2[j7++] & 0xff;
                for(int k18 = 0; k18 < dgg; k18++)
                {
                    dgh[k18] = t.fmi(arg2, j7);
                    j7 += 2;
                    dgi[k18] = t.fmj(arg2, j7);
                    j7 += 4;
                }

                eac = arg2[j7++] & 0xff;
                ead = arg2[j7++] & 0xff;
                eae = arg2[j7++] & 0xff;
                eaf = arg2[j7++] & 0xff;
                return;
            }
            if(arg0 == 238)
            {
                String s1 = new String(arg2, 1, arg1 - 1);
                fdb(s1);
                return;
            }
            if(arg0 == 253)
            {
                if(ean < 50)
                {
                    int k7 = arg2[1] & 0xff;
                    int l13 = arg2[2] + smallX;
                    int l18 = arg2[3] + smallY;
                    ekn[ean] = k7;
                    dna[ean] = 0;
                    dnc[ean] = l13;
                    dgb[ean] = l18;
                    ean++;
                }
                return;
            }
            if(arg0 == 126)
            {
                if(!dea)
                {
                    dif = t.fmj(arg2, 1);
                    ela = t.fmi(arg2, 5);
                    ddb = arg2[7] & 0xff;
                    dij = t.fmi(arg2, 8);
                    eab = true;
                    dea = true;
                    edd = null;
                }
                return;
            }
            if(arg0 == 112)
            {
                eln = new String(arg2, 1, arg1 - 1);
                ega = true;
                djj = false;
                return;
            }
            if(arg0 == 49)
            {
                eln = new String(arg2, 1, arg1 - 1);
                ega = true;
                djj = true;
                return;
            }
            if(arg0 == 60)
            {
                fatigue = t.fmi(arg2, 1);
                return;
            }
            if(arg0 == 50)
            {
                if(!sleeping)
                    tfatigue = fatigue;
                sleeping = true;
                super.fkl = "";
                super.fkm = "";
                gfx.cbk(dfb + 1, arg2);
				savepic(arg2);
                eke = null;
                return;
            }
            if(arg0 == 174)
            {
                tfatigue = t.fmi(arg2, 1);
                return;
            }
            if(arg0 == 206)
            {
                sleeping = false;
                return;
            }
            if(arg0 == 20)
            {
                eke = "Incorrect - Please wait...";
                return;
            }
            if(arg0 == 28)
            {
                edh = t.fmi(arg2, 1) * 32;
                return;
            }
        }
        catch(RuntimeException runtimeexception)
        {
            if(dkn < 3)
            {
                super.connection.newID(7);
                super.connection.hdk(runtimeexception.toString());
                super.connection.complete();
                super.connection.newID(7);
                super.connection.hdk("p-type:" + arg0 + " p-size:" + arg1);
                super.connection.complete();
                super.connection.newID(7);
                super.connection.hdk("rx:" + smallX + " ry:" + smallY + " num3l:" + objectCount);
                super.connection.complete();
                String s2 = "";
                for(int i19 = 0; i19 < 80 && i19 < arg1; i19++)
                    s2 = s2 + arg2[i19] + " ";

                super.connection.newID(7);
                super.connection.hdk(s2);
                super.connection.complete();
                dkn++;
            }
        }
    }

    public final void emk()
    {
        if(ebd != 0)
        {
            for(int l = 0; l < questMenuCount; l++)
            {
                if(super.mouseX >= gfx.textWidth(questMenuAnswer[l], 1) || super.mouseY <= l * 12 || super.mouseY >= 12 + l * 12)
                    continue;
                super.connection.newID(68);
                super.connection.addVar(l);
                super.connection.complete();
                break;
            }

            ebd = 0;
            questMenu = false;
            return;
        }
        for(int i1 = 0; i1 < questMenuCount; i1++)
        {
            int j1 = 65535;
            if(super.mouseX < gfx.textWidth(questMenuAnswer[i1], 1) && super.mouseY > i1 * 12 && super.mouseY < 12 + i1 * 12)
                j1 = 0xff0000;
            gfx.drawBoxText(questMenuAnswer[i1], 6, 12 + i1 * 12, 1, j1);
        }

    }

    public final f eml(int arg0, int arg1, int arg2, int arg3)
    {
        if(eba[arg0] == null)
        {
            eba[arg0] = new f();
            eba[arg0].id = arg0;
            eba[arg0].gmg = 0;
        }
        f f1 = eba[arg0];
        boolean flag = false;
        for(int l = 0; l < efh; l++)
        {
            if(dmn[l].id != arg0)
                continue;
            flag = true;
            break;
        }

        if(flag)
        {
            f1.gmm = arg3;
            int i1 = f1.miniWalk;
            if(arg1 != f1.gnb[i1] || arg2 != f1.gnc[i1])
            {
                f1.miniWalk = i1 = (i1 + 1) % 10;
                f1.gnb[i1] = arg1;
                f1.gnc[i1] = arg2;
            }
        } else
        {
            f1.id = arg0;
            f1.gmn = 0;
            f1.miniWalk = 0;
            f1.gnb[0] = f1.x = arg1;
            f1.gnc[0] = f1.y = arg2;
            f1.gmm = f1.sprite = arg3;
            f1.gmk = 0;
        }
        player[playerCount++] = f1;
        return f1;
    }

    public final void drawBank()
    {
        char c1 = '\u0198';
        char c2 = '\u014E';
        if(dha > 0 && bankTotal <= 48)
            dha = 0;
        if(dha > 1 && bankTotal <= 96)
            dha = 1;
        if(dha > 2 && bankTotal <= 144)
            dha = 2;
        if(selectedBank >= bankTotal || selectedBank < 0)
            selectedBank = -1;
        if(selectedBank != -1 && bankType[selectedBank] != dmb)
        {
            selectedBank = -1;
            dmb = -2;
        }
        if(ebd != 0)
        {
            ebd = 0;
            int l = super.mouseX - (256 - c1 / 2);
            int j1 = super.mouseY - (170 - c2 / 2);
            if(l >= 0 && j1 >= 12 && l < 408 && j1 < 280)
            {
                int l1 = dha * 48;
                for(int k2 = 0; k2 < 6; k2++)
                {
                    for(int i3 = 0; i3 < 8; i3++)
                    {
                        int k7 = 7 + i3 * 49;
                        int i8 = 28 + k2 * 34;
                        if(l > k7 && l < k7 + 49 && j1 > i8 && j1 < i8 + 34 && l1 < bankTotal && bankType[l1] != -1)
                        {
                            dmb = bankType[l1];
                            selectedBank = l1;
                        }
                        l1++;
                    }

                }

                l = 256 - c1 / 2;
                j1 = 170 - c2 / 2;
                int j3;
                if(selectedBank < 0)
                    j3 = -1;
                else
                    j3 = bankType[selectedBank];
                if(j3 != -1)
                {
                    int i2 = bankCount[selectedBank];
                    if(identify.stackable[j3] == 1 && i2 > 1)
                        i2 = 1;
                    if(i2 >= 1 && super.mouseX >= l + 220 && super.mouseY >= j1 + 238 && super.mouseX < l + 250 && super.mouseY <= j1 + 249)
                    {
                        super.connection.newID(131);
                        super.connection.addInt(j3);
                        super.connection.addInt(1);
                        super.connection.complete();
                    }
                    if(i2 >= 5 && super.mouseX >= l + 250 && super.mouseY >= j1 + 238 && super.mouseX < l + 280 && super.mouseY <= j1 + 249)
                    {
                        super.connection.newID(131);
                        super.connection.addInt(j3);
                        super.connection.addInt(5);
                        super.connection.complete();
                    }
                    if(i2 >= 25 && super.mouseX >= l + 280 && super.mouseY >= j1 + 238 && super.mouseX < l + 305 && super.mouseY <= j1 + 249)
                    {
                        super.connection.newID(131);
                        super.connection.addInt(j3);
                        super.connection.addInt(25);
                        super.connection.complete();
                    }
                    if(i2 >= 100 && super.mouseX >= l + 305 && super.mouseY >= j1 + 238 && super.mouseX < l + 335 && super.mouseY <= j1 + 249)
                    {
                        super.connection.newID(131);
                        super.connection.addInt(j3);
                        super.connection.addInt(100);
                        super.connection.complete();
                    }
                    if(i2 >= 500 && super.mouseX >= l + 335 && super.mouseY >= j1 + 238 && super.mouseX < l + 368 && super.mouseY <= j1 + 249)
                    {
                        super.connection.newID(131);
                        super.connection.addInt(j3);
                        super.connection.addInt(500);
                        super.connection.complete();
                    }
                    if(i2 >= 2500 && super.mouseX >= l + 370 && super.mouseY >= j1 + 238 && super.mouseX < l + 400 && super.mouseY <= j1 + 249)
                    {
                        super.connection.newID(131);
                        super.connection.addInt(j3);
                        super.connection.addInt(2500);
                        super.connection.complete();
                    }
                    if(invCount(j3) >= 1 && super.mouseX >= l + 220 && super.mouseY >= j1 + 263 && super.mouseX < l + 250 && super.mouseY <= j1 + 274)
                    {
                        super.connection.newID(190);
                        super.connection.addInt(j3);
                        super.connection.addInt(1);
                        super.connection.complete();
                    }
                    if(invCount(j3) >= 5 && super.mouseX >= l + 250 && super.mouseY >= j1 + 263 && super.mouseX < l + 280 && super.mouseY <= j1 + 274)
                    {
                        super.connection.newID(190);
                        super.connection.addInt(j3);
                        super.connection.addInt(5);
                        super.connection.complete();
                    }
                    if(invCount(j3) >= 25 && super.mouseX >= l + 280 && super.mouseY >= j1 + 263 && super.mouseX < l + 305 && super.mouseY <= j1 + 274)
                    {
                        super.connection.newID(190);
                        super.connection.addInt(j3);
                        super.connection.addInt(25);
                        super.connection.complete();
                    }
                    if(invCount(j3) >= 100 && super.mouseX >= l + 305 && super.mouseY >= j1 + 263 && super.mouseX < l + 335 && super.mouseY <= j1 + 274)
                    {
                        super.connection.newID(190);
                        super.connection.addInt(j3);
                        super.connection.addInt(100);
                        super.connection.complete();
                    }
                    if(invCount(j3) >= 500 && super.mouseX >= l + 335 && super.mouseY >= j1 + 263 && super.mouseX < l + 368 && super.mouseY <= j1 + 274)
                    {
                        super.connection.newID(190);
                        super.connection.addInt(j3);
                        super.connection.addInt(500);
                        super.connection.complete();
                    }
                    if(invCount(j3) >= 2500 && super.mouseX >= l + 370 && super.mouseY >= j1 + 263 && super.mouseX < l + 400 && super.mouseY <= j1 + 274)
                    {
                        super.connection.newID(190);
                        super.connection.addInt(j3);
                        super.connection.addInt(2500);
                        super.connection.complete();
                    }
                }
            } else
            if(bankTotal > 48 && l >= 50 && l <= 115 && j1 <= 12)
                dha = 0;
            else
            if(bankTotal > 48 && l >= 115 && l <= 180 && j1 <= 12)
                dha = 1;
            else
            if(bankTotal > 96 && l >= 180 && l <= 245 && j1 <= 12)
                dha = 2;
            else
            if(bankTotal > 144 && l >= 245 && l <= 310 && j1 <= 12)
            {
                dha = 3;
            } else
            {
                super.connection.newID(78);
                super.connection.complete();
                bank = false;
                return;
            }
        }
        int i1 = 256 - c1 / 2;
        int k1 = 170 - c2 / 2;
        gfx.drawBox(i1, k1, 408, 12, 192);
        int j2 = 0x989898;
        gfx.drawBoxAlpha(i1, k1 + 12, 408, 17, j2, 160);
        gfx.drawBoxAlpha(i1, k1 + 29, 8, 204, j2, 160);
        gfx.drawBoxAlpha(i1 + 399, k1 + 29, 9, 204, j2, 160);
        gfx.drawBoxAlpha(i1, k1 + 233, 408, 47, j2, 160);
        gfx.drawBoxText("Bank", i1 + 1, k1 + 10, 1, 0xffffff);
        int l2 = 50;
        if(bankTotal > 48)
        {
            int k3 = 0xffffff;
            if(dha == 0)
                k3 = 0xff0000;
            else
            if(super.mouseX > i1 + l2 && super.mouseY >= k1 && super.mouseX < i1 + l2 + 65 && super.mouseY < k1 + 12)
                k3 = 0xffff00;
            gfx.drawBoxText("<page 1>", i1 + l2, k1 + 10, 1, k3);
            l2 += 65;
            k3 = 0xffffff;
            if(dha == 1)
                k3 = 0xff0000;
            else
            if(super.mouseX > i1 + l2 && super.mouseY >= k1 && super.mouseX < i1 + l2 + 65 && super.mouseY < k1 + 12)
                k3 = 0xffff00;
            gfx.drawBoxText("<page 2>", i1 + l2, k1 + 10, 1, k3);
            l2 += 65;
        }
        if(bankTotal > 96)
        {
            int l3 = 0xffffff;
            if(dha == 2)
                l3 = 0xff0000;
            else
            if(super.mouseX > i1 + l2 && super.mouseY >= k1 && super.mouseX < i1 + l2 + 65 && super.mouseY < k1 + 12)
                l3 = 0xffff00;
            gfx.drawBoxText("<page 3>", i1 + l2, k1 + 10, 1, l3);
            l2 += 65;
        }
        if(bankTotal > 144)
        {
            int i4 = 0xffffff;
            if(dha == 3)
                i4 = 0xff0000;
            else
            if(super.mouseX > i1 + l2 && super.mouseY >= k1 && super.mouseX < i1 + l2 + 65 && super.mouseY < k1 + 12)
                i4 = 0xffff00;
            gfx.drawBoxText("<page 4>", i1 + l2, k1 + 10, 1, i4);
            l2 += 65;
        }
        int j4 = 0xffffff;
        if(super.mouseX > i1 + 320 && super.mouseY >= k1 && super.mouseX < i1 + 408 && super.mouseY < k1 + 12)
            j4 = 0xff0000;
        gfx.drawBoxTextRight("Close window", i1 + 406, k1 + 10, 1, j4);
        gfx.drawBoxText("Number in bank in green", i1 + 7, k1 + 24, 1, 65280);
        gfx.drawBoxText("Number held in blue", i1 + 289, k1 + 24, 1, 65535);
        int l7 = 0xd0d0d0;
        int j8 = dha * 48;
        for(int l8 = 0; l8 < 6; l8++)
        {
            for(int i9 = 0; i9 < 8; i9++)
            {
                int k9 = i1 + 7 + i9 * 49;
                int l9 = k1 + 28 + l8 * 34;
                if(selectedBank == j8)
                    gfx.drawBoxAlpha(k9, l9, 49, 34, 0xff0000, 160);
                else
                    gfx.drawBoxAlpha(k9, l9, 49, 34, l7, 160);
                gfx.drawBoxEdge(k9, l9, 50, 35, 0);
                if(j8 < bankTotal && bankType[j8] != -1)
                {
                    gfx.cdd(k9, l9, 48, 32, den + identify.ajf[bankType[j8]], identify.ajk[bankType[j8]], 0, 0, false);
                    gfx.drawBoxText(String.valueOf(bankCount[j8]), k9 + 1, l9 + 10, 1, 65280);
                    gfx.drawBoxTextRight(String.valueOf(invCount(bankType[j8])), k9 + 47, l9 + 29, 1, 65535);
                }
                j8++;
            }

        }

        gfx.drawLine(i1 + 5, k1 + 256, 398, 0);
        if(selectedBank == -1)
        {
            gfx.drawText("Select an object to withdraw or deposit", i1 + 204, k1 + 248, 3, 0xffff00);
            return;
        }
        int j9;
        if(selectedBank < 0)
            j9 = -1;
        else
            j9 = bankType[selectedBank];
        if(j9 != -1)
        {
            int k8 = bankCount[selectedBank];
            if(identify.stackable[j9] == 1 && k8 > 1)
                k8 = 1;
            if(k8 > 0)
            {
                gfx.drawBoxText("Withdraw " + identify.itemName[j9], i1 + 2, k1 + 248, 1, 0xffffff);
                int k4 = 0xffffff;
                if(super.mouseX >= i1 + 220 && super.mouseY >= k1 + 238 && super.mouseX < i1 + 250 && super.mouseY <= k1 + 249)
                    k4 = 0xff0000;
                gfx.drawBoxText("One", i1 + 222, k1 + 248, 1, k4);
                if(k8 >= 5)
                {
                    int l4 = 0xffffff;
                    if(super.mouseX >= i1 + 250 && super.mouseY >= k1 + 238 && super.mouseX < i1 + 280 && super.mouseY <= k1 + 249)
                        l4 = 0xff0000;
                    gfx.drawBoxText("Five", i1 + 252, k1 + 248, 1, l4);
                }
                if(k8 >= 25)
                {
                    int i5 = 0xffffff;
                    if(super.mouseX >= i1 + 280 && super.mouseY >= k1 + 238 && super.mouseX < i1 + 305 && super.mouseY <= k1 + 249)
                        i5 = 0xff0000;
                    gfx.drawBoxText("25", i1 + 282, k1 + 248, 1, i5);
                }
                if(k8 >= 100)
                {
                    int j5 = 0xffffff;
                    if(super.mouseX >= i1 + 305 && super.mouseY >= k1 + 238 && super.mouseX < i1 + 335 && super.mouseY <= k1 + 249)
                        j5 = 0xff0000;
                    gfx.drawBoxText("100", i1 + 307, k1 + 248, 1, j5);
                }
                if(k8 >= 500)
                {
                    int k5 = 0xffffff;
                    if(super.mouseX >= i1 + 335 && super.mouseY >= k1 + 238 && super.mouseX < i1 + 368 && super.mouseY <= k1 + 249)
                        k5 = 0xff0000;
                    gfx.drawBoxText("500", i1 + 337, k1 + 248, 1, k5);
                }
                if(k8 >= 2500)
                {
                    int l5 = 0xffffff;
                    if(super.mouseX >= i1 + 370 && super.mouseY >= k1 + 238 && super.mouseX < i1 + 400 && super.mouseY <= k1 + 249)
                        l5 = 0xff0000;
                    gfx.drawBoxText("2500", i1 + 370, k1 + 248, 1, l5);
                }
            }
            if(invCount(j9) > 0)
            {
                gfx.drawBoxText("Deposit " + identify.itemName[j9], i1 + 2, k1 + 273, 1, 0xffffff);
                int i6 = 0xffffff;
                if(super.mouseX >= i1 + 220 && super.mouseY >= k1 + 263 && super.mouseX < i1 + 250 && super.mouseY <= k1 + 274)
                    i6 = 0xff0000;
                gfx.drawBoxText("One", i1 + 222, k1 + 273, 1, i6);
                if(invCount(j9) >= 5)
                {
                    int j6 = 0xffffff;
                    if(super.mouseX >= i1 + 250 && super.mouseY >= k1 + 263 && super.mouseX < i1 + 280 && super.mouseY <= k1 + 274)
                        j6 = 0xff0000;
                    gfx.drawBoxText("Five", i1 + 252, k1 + 273, 1, j6);
                }
                if(invCount(j9) >= 25)
                {
                    int k6 = 0xffffff;
                    if(super.mouseX >= i1 + 280 && super.mouseY >= k1 + 263 && super.mouseX < i1 + 305 && super.mouseY <= k1 + 274)
                        k6 = 0xff0000;
                    gfx.drawBoxText("25", i1 + 282, k1 + 273, 1, k6);
                }
                if(invCount(j9) >= 100)
                {
                    int l6 = 0xffffff;
                    if(super.mouseX >= i1 + 305 && super.mouseY >= k1 + 263 && super.mouseX < i1 + 335 && super.mouseY <= k1 + 274)
                        l6 = 0xff0000;
                    gfx.drawBoxText("100", i1 + 307, k1 + 273, 1, l6);
                }
                if(invCount(j9) >= 500)
                {
                    int i7 = 0xffffff;
                    if(super.mouseX >= i1 + 335 && super.mouseY >= k1 + 263 && super.mouseX < i1 + 368 && super.mouseY <= k1 + 274)
                        i7 = 0xff0000;
                    gfx.drawBoxText("500", i1 + 337, k1 + 273, 1, i7);
                }
                if(invCount(j9) >= 2500)
                {
                    int j7 = 0xffffff;
                    if(super.mouseX >= i1 + 370 && super.mouseY >= k1 + 263 && super.mouseX < i1 + 400 && super.mouseY <= k1 + 274)
                        j7 = 0xff0000;
                    gfx.drawBoxText("2500", i1 + 370, k1 + 273, 1, j7);
                }
            }
        }
    }

    protected final void emn()
    {
        if(eki)
            return;
        if(elm)
            return;
        if(ein)
            return;
        try
        {
            dji++;
            if(loggedIn == 0)
            {
                super.fil = 0;
                fcc();
            }
            if(loggedIn == 1)
            {
                super.fil++;
                fan();
            }
            super.fkh = 0;
            super.fkj = 0;
            dcg++;
            if(dcg > 500)
            {
                dcg = 0;
                int l = (int)(Math.random() * 4D);
                if((l & 1) == 1)
                    egf += egg;
                if((l & 2) == 2)
                    eea += eeb;
            }
            if(egf < -50)
                egg = 2;
            if(egf > 50)
                egg = -2;
            if(eea < -50)
                eeb = 2;
            if(eea > 50)
                eeb = -2;
            if(ehc > 0)
                ehc--;
            if(ehd > 0)
                ehd--;
            if(ehe > 0)
                ehe--;
            if(ehf > 0)
            {
                ehf--;
                return;
            }
        }
        catch(OutOfMemoryError _ex)
        {
            fdd();
            elm = true;
        }
    }

    public final void ena(int l, int i1, int j1, int k1, boolean flag)
    {
        fde(l, i1, j1, k1, j1, k1, false, flag);
    }

    public final URL getCodeBase()
    {
        if(link.fni != null)
            return link.fni.getCodeBase();
        else
            return super.getCodeBase();
    }

    protected final byte[] enb(String arg0, String arg1, int arg2)
    {
        if(!dhh)
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
            return super.enb(arg0, arg1, arg2);
        }
    }

    public final void enc()
    {
        char c1 = '\u0190';
        char c2 = 'd';
        if(djj)
        {
            c2 = '\u01C2';
            c2 = '\u012C';
        }
        gfx.drawBox(256 - c1 / 2, 167 - c2 / 2, c1, c2, 0);
        gfx.drawBoxEdge(256 - c1 / 2, 167 - c2 / 2, c1, c2, 0xffffff);
        gfx.cdm(eln, 256, (167 - c2 / 2) + 20, 1, 0xffffff, c1 - 40);
        int l = 157 + c2 / 2;
        int i1 = 0xffffff;
        if(super.mouseY > l - 12 && super.mouseY <= l && super.mouseX > 106 && super.mouseX < 406)
            i1 = 0xff0000;
        gfx.drawText("Click here to close window", 256, l, 1, i1);
        if(ebd == 1)
        {
            if(i1 == 0xff0000)
                ega = false;
            if((super.mouseX < 256 - c1 / 2 || super.mouseX > 256 + c1 / 2) && (super.mouseY < 167 - c2 / 2 || super.mouseY > 167 + c2 / 2))
                ega = false;
        }
        ebd = 0;
    }

    public final void end()
    {
        elg = new h(gfx, 10);
        elh = elg.gfh(5, 269, 502, 56, 1, 20, true);
        eli = elg.gfi(7, 324, 498, 14, 1, 80, false, true);
        elj = elg.gfh(5, 269, 502, 56, 1, 20, true);
        elk = elg.gfh(5, 269, 502, 56, 1, 20, true);
        elg.ggg(eli);
    }

    public final void ene()
    {
        bankTotal = dec;
        for(int l = 0; l < dec; l++)
        {
            bankType[l] = ecf[l];
            bankCount[l] = ecg[l];
        }

        for(int i1 = 0; i1 < invCount; i1++)
        {
            if(bankTotal >= dnb)
                break;
            int j1 = inv[i1];
            boolean flag = false;
            for(int k1 = 0; k1 < bankTotal; k1++)
            {
                if(bankType[k1] != j1)
                    continue;
                flag = true;
                break;
            }

            if(!flag)
            {
                bankType[bankTotal] = j1;
                bankCount[bankTotal] = 0;
                bankTotal++;
            }
        }

    }

    public final void enf()
    {
        if(selectedMenu == 0 && super.mouseX >= ((j) (gfx)).blg - 35 && super.mouseY >= 3 && super.mouseX < ((j) (gfx)).blg - 3 && super.mouseY < 35)
            selectedMenu = 1;
        if(selectedMenu == 0 && super.mouseX >= ((j) (gfx)).blg - 35 - 33 && super.mouseY >= 3 && super.mouseX < ((j) (gfx)).blg - 3 - 33 && super.mouseY < 35)
        {
            selectedMenu = 2;
            dfe = 0;
            dff = 0;
        }
        if(selectedMenu == 0 && super.mouseX >= ((j) (gfx)).blg - 35 - 66 && super.mouseY >= 3 && super.mouseX < ((j) (gfx)).blg - 3 - 66 && super.mouseY < 35)
            selectedMenu = 3;
        if(selectedMenu == 0 && super.mouseX >= ((j) (gfx)).blg - 35 - 99 && super.mouseY >= 3 && super.mouseX < ((j) (gfx)).blg - 3 - 99 && super.mouseY < 35)
            selectedMenu = 4;
        if(selectedMenu == 0 && super.mouseX >= ((j) (gfx)).blg - 35 - 132 && super.mouseY >= 3 && super.mouseX < ((j) (gfx)).blg - 3 - 132 && super.mouseY < 35)
            selectedMenu = 5;
        if(selectedMenu == 0 && super.mouseX >= ((j) (gfx)).blg - 35 - 165 && super.mouseY >= 3 && super.mouseX < ((j) (gfx)).blg - 3 - 165 && super.mouseY < 35)
            selectedMenu = 6;
        if(selectedMenu != 0 && super.mouseX >= ((j) (gfx)).blg - 35 && super.mouseY >= 3 && super.mouseX < ((j) (gfx)).blg - 3 && super.mouseY < 26)
            selectedMenu = 1;
        if(selectedMenu != 0 && selectedMenu != 2 && super.mouseX >= ((j) (gfx)).blg - 35 - 33 && super.mouseY >= 3 && super.mouseX < ((j) (gfx)).blg - 3 - 33 && super.mouseY < 26)
        {
            selectedMenu = 2;
            dfe = 0;
            dff = 0;
        }
        if(selectedMenu != 0 && super.mouseX >= ((j) (gfx)).blg - 35 - 66 && super.mouseY >= 3 && super.mouseX < ((j) (gfx)).blg - 3 - 66 && super.mouseY < 26)
            selectedMenu = 3;
        if(selectedMenu != 0 && super.mouseX >= ((j) (gfx)).blg - 35 - 99 && super.mouseY >= 3 && super.mouseX < ((j) (gfx)).blg - 3 - 99 && super.mouseY < 26)
            selectedMenu = 4;
        if(selectedMenu != 0 && super.mouseX >= ((j) (gfx)).blg - 35 - 132 && super.mouseY >= 3 && super.mouseX < ((j) (gfx)).blg - 3 - 132 && super.mouseY < 26)
            selectedMenu = 5;
        if(selectedMenu != 0 && super.mouseX >= ((j) (gfx)).blg - 35 - 165 && super.mouseY >= 3 && super.mouseX < ((j) (gfx)).blg - 3 - 165 && super.mouseY < 26)
            selectedMenu = 6;
        if(selectedMenu == 1 && (super.mouseX < ((j) (gfx)).blg - 248 || super.mouseY > 36 + (dlk / 5) * 34))
            selectedMenu = 0;
        if(selectedMenu == 3 && (super.mouseX < ((j) (gfx)).blg - 199 || super.mouseY > 316))
            selectedMenu = 0;
        if((selectedMenu == 2 || selectedMenu == 4 || selectedMenu == 5) && (super.mouseX < ((j) (gfx)).blg - 199 || super.mouseY > 240))
            selectedMenu = 0;
        if(selectedMenu == 6 && (super.mouseX < ((j) (gfx)).blg - 199 || super.mouseY > 311))
            selectedMenu = 0;
    }

    public final void eng()
    {
        if(ebd != 0)
        {
            ebd = 0;
            if(efm == 1 && (super.mouseX < 106 || super.mouseY < 145 || super.mouseX > 406 || super.mouseY > 215))
            {
                efm = 0;
                return;
            }
            if(efm == 2 && (super.mouseX < 6 || super.mouseY < 145 || super.mouseX > 506 || super.mouseY > 215))
            {
                efm = 0;
                return;
            }
            if(efm == 3 && (super.mouseX < 106 || super.mouseY < 145 || super.mouseX > 406 || super.mouseY > 215))
            {
                efm = 0;
                return;
            }
            if(super.mouseX > 236 && super.mouseX < 276 && super.mouseY > 193 && super.mouseY < 213)
            {
                efm = 0;
                return;
            }
        }
        int l = 145;
        if(efm == 1)
        {
            gfx.drawBox(106, l, 300, 70, 0);
            gfx.drawBoxEdge(106, l, 300, 70, 0xffffff);
            l += 20;
            gfx.drawText("Enter name to add to friends list", 256, l, 4, 0xffffff);
            l += 20;
            gfx.drawText(super.fkl + "*", 256, l, 4, 0xffffff);
            if(super.fkm.length() > 0)
            {
                String s1 = super.fkm.trim();
                super.fkl = "";
                super.fkm = "";
                efm = 0;
                if(s1.length() > 0 && t.fnc(s1) != myPlayer.gmd)
                    addFriend(s1);
            }
        }
        if(efm == 2)
        {
            gfx.drawBox(6, l, 500, 70, 0);
            gfx.drawBoxEdge(6, l, 500, 70, 0xffffff);
            l += 20;
            gfx.drawText("Enter message to send to " + t.grabFriendName(ekc), 256, l, 4, 0xffffff);
            l += 20;
            gfx.drawText(super.fkn + "*", 256, l, 4, 0xffffff);
            if(super.fla.length() > 0)
            {
                String s2 = super.fla;
                super.fkn = "";
                super.fla = "";
                efm = 0;
                int j1 = v.cek(s2);
                acl(ekc, v.ceg, j1);
                s2 = v.cej(v.ceg, 0, j1);
                s2 = u.fgd(s2);
                adg("@pri@You tell " + t.grabFriendName(ekc) + ": " + s2);
            }
        }
        if(efm == 3)
        {
            gfx.drawBox(106, l, 300, 70, 0);
            gfx.drawBoxEdge(106, l, 300, 70, 0xffffff);
            l += 20;
            gfx.drawText("Enter name to add to ignore list", 256, l, 4, 0xffffff);
            l += 20;
            gfx.drawText(super.fkl + "*", 256, l, 4, 0xffffff);
            if(super.fkm.length() > 0)
            {
                String s3 = super.fkm.trim();
                super.fkl = "";
                super.fkm = "";
                efm = 0;
                if(s3.length() > 0 && t.fnc(s3) != myPlayer.gmd)
                    ach(s3);
            }
        }
        int i1 = 0xffffff;
        if(super.mouseX > 236 && super.mouseX < 276 && super.mouseY > 193 && super.mouseY < 213)
            i1 = 0xffff00;
        gfx.drawText("Cancel", 256, 208, 1, i1);
    }

    public final void enh()
    {
        for(int l = 0; l < efd; l++)
        {
            int i1 = gfx.ced(1);
            int k1 = ebe[l];
            int j2 = ebf[l];
            int i3 = ebg[l];
            int l3 = ebh[l];
            boolean flag = true;
            while(flag) 
            {
                flag = false;
                for(int l4 = 0; l4 < l; l4++)
                    if(j2 + l3 > ebf[l4] - i1 && j2 - i1 < ebf[l4] + ebh[l4] && k1 - i3 < ebe[l4] + ebg[l4] && k1 + i3 > ebe[l4] - ebg[l4] && ebf[l4] - i1 - l3 < j2)
                    {
                        j2 = ebf[l4] - i1 - l3;
                        flag = true;
                    }

            }
            ebf[l] = j2;
            gfx.cdm(efe[l], k1, j2, 1, 0xffff00, 300);
        }

        for(int j1 = 0; j1 < dln; j1++)
        {
            int l1 = eai[j1];
            int k2 = eaj[j1];
            int j3 = eag[j1];
            int i4 = eah[j1];
            int k4 = (39 * j3) / 100;
            int i5 = (27 * j3) / 100;
            int j5 = k2 - i5;
            gfx.cce(l1 - k4 / 2, j5, k4, i5, del + 9, 85);
            int k5 = (36 * j3) / 100;
            int l5 = (24 * j3) / 100;
            gfx.cdd(l1 - k5 / 2, (j5 + i5 / 2) - l5 / 2, k5, l5, identify.ajf[i4] + den, identify.ajk[i4], 0, 0, false);
        }

        for(int i2 = 0; i2 < egl; i2++)
        {
            int l2 = dfg[i2];
            int k3 = dfh[i2];
            int j4 = dfi[i2];
            gfx.drawBoxAlpha(l2 - 15, k3 - 3, j4, 5, 65280, 192);
            gfx.drawBoxAlpha((l2 - 15) + j4, k3 - 3, 30 - j4, 5, 0xff0000, 192);
        }

    }

    public final void eni()
    {
        if(selectedSpell >= 0 || selectedItem >= 0)
        {
            menuText[menuCount] = "Cancel";
            menuDescription[menuCount] = "";
            menuType[menuCount] = 4000;
            menuCount++;
        }
        for(int l = 0; l < menuCount; l++)
            dda[l] = l;

        for(boolean flag = false; !flag;)
        {
            flag = true;
            for(int i1 = 0; i1 < menuCount - 1; i1++)
            {
                int k1 = dda[i1];
                int i2 = dda[i1 + 1];
                if(menuType[k1] > menuType[i2])
                {
                    dda[i1] = i2;
                    dda[i1 + 1] = k1;
                    flag = false;
                }
            }

        }

        if(menuCount > 20)
            menuCount = 20;
        if(menuCount > 0)
        {
            int j1 = -1;
            for(int l1 = 0; l1 < menuCount; l1++)
            {
                if(menuDescription[dda[l1]] == null || menuDescription[dda[l1]].length() <= 0)
                    continue;
                j1 = l1;
                break;
            }

            String s1 = null;
            if((selectedItem >= 0 || selectedSpell >= 0) && menuCount == 1)
                s1 = "Choose a target";
            else
            if((selectedItem >= 0 || selectedSpell >= 0) && menuCount > 1)
                s1 = "@whi@" + menuText[dda[0]] + " " + menuDescription[dda[0]];
            else
            if(j1 != -1)
                s1 = menuDescription[dda[j1]] + ": @whi@" + menuText[dda[0]];
            if(menuCount == 2 && s1 != null)
                s1 = s1 + "@whi@ / 1 more option";
            if(menuCount > 2 && s1 != null)
                s1 = s1 + "@whi@ / " + (menuCount - 1) + " more options";
            if(s1 != null)
                gfx.drawBoxText(s1, 6, 14, 1, 0xffff00);
            if(!dek && ebd == 1 || dek && ebd == 1 && menuCount == 1)
            {
                handleMenu(dda[0]);
                ebd = 0;
                return;
            }
            if(!dek && ebd == 2 || dek && ebd == 1)
            {
                ehj = (menuCount + 1) * 15;
                ehi = gfx.textWidth("Choose option", 1) + 5;
                for(int j2 = 0; j2 < menuCount; j2++)
                {
                    int k2 = gfx.textWidth(menuText[j2] + " " + menuDescription[j2], 1) + 5;
                    if(k2 > ehi)
                        ehi = k2;
                }

                ehg = super.mouseX - ehi / 2;
                ehh = super.mouseY - 7;
                ejm = true;
                if(ehg < 0)
                    ehg = 0;
                if(ehh < 0)
                    ehh = 0;
                if(ehg + ehi > 510)
                    ehg = 510 - ehi;
                if(ehh + ehj > 315)
                    ehh = 315 - ehj;
                ebd = 0;
            }
        }
    }

    protected final void adg(String s1)
    {
		lastServerMessage = s1;
		if (macro != null && running)
			macro.serverMessage(s1);
        if(s1.startsWith("@bor@"))
        {
            displayMessage(s1, 4);
            return;
        }
        if(s1.startsWith("@que@"))
        {
            displayMessage("@whi@" + s1, 5);
            return;
        }
        if(s1.startsWith("@pri@"))
        {
            displayMessage(s1, 6);
            return;
        } else
        {
            displayMessage(s1, 3);
            return;
        }
    }

    public final void enj()
    {
        gameHandle.gij = enb("maps" + w.cfa + ".jag", "map", 70);
        if(member)
            gameHandle.gic = enb("maps" + w.cfa + ".mem", "members map", 75);
        gameHandle.gii = enb("land" + w.cfa + ".jag", "landscape", 80);
        if(member)
            gameHandle.gib = enb("land" + w.cfa + ".mem", "members landscape", 85);
    }

    public static final String enk(int arg0)
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

    public final URL getDocumentBase()
    {
        if(link.fni != null)
            return link.fni.getDocumentBase();
        else
            return super.getDocumentBase();
    }

    public final void logout()
    {
        if(loggedIn == 0)
            return;
        if(eda > 450)
        {
            displayMessage("@cya@You can't logout during combat!", 3);
            return;
        }
        if(eda > 0)
        {
            displayMessage("@cya@You can't logout for 10 seconds after combat", 3);
            return;
        } else
        {
            super.connection.newID(3);
            super.connection.complete();
            dhf = 1000;
            return;
        }
    }

    public final void enm()
    {
        int l = 2203 - (smallY + dne + bigY);
        if(smallX + dnd + bigX >= 2640)
            l = -50;
        int i1 = -1;
        for(int j1 = 0; j1 < objectCount; j1++)
            egm[j1] = false;

        for(int k1 = 0; k1 < doorCount; k1++)
            dnl[k1] = false;

        int l1 = efn.bhh();
        i ai[] = efn.bhj();
        int ai1[] = efn.bhi();
        for(int i2 = 0; i2 < l1; i2++)
        {
            if(menuCount > 200)
                break;
            int j2 = ai1[i2];
            i l2 = ai[i2];
            if(l2.chl[j2] <= 65535 || l2.chl[j2] >= 0x30d40 && l2.chl[j2] <= 0x493e0)
                if(l2 == efn.beh)
                {
                    int i3 = l2.chl[j2] % 10000;
                    int l3 = l2.chl[j2] / 10000;
                    if(l3 == 1)
                    {
                        String s1 = "";
                        int k4 = 0;
                        if(myPlayer.level > 0 && player[i3].level > 0)
                            k4 = myPlayer.level - player[i3].level;
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
                        s1 = " " + s1 + "(level-" + player[i3].level + ")";
                        if(selectedSpell >= 0)
                        {
                            if(identify.spellType[selectedSpell] == 1 || identify.spellType[selectedSpell] == 2)
                            {
                                menuText[menuCount] = "Cast " + identify.spellName[selectedSpell] + " on";
                                menuDescription[menuCount] = "@whi@" + player[i3].name + s1;
                                menuType[menuCount] = 800;
                                menuX[menuCount] = player[i3].x;
                                menuY[menuCount] = player[i3].y;
                                menuID[menuCount] = player[i3].id;
                                menuVar[menuCount] = selectedSpell;
                                menuCount++;
                            }
                        } else
                        if(selectedItem >= 0)
                        {
                            menuText[menuCount] = "Use " + selectedItemName + " with";
                            menuDescription[menuCount] = "@whi@" + player[i3].name + s1;
                            menuType[menuCount] = 810;
                            menuX[menuCount] = player[i3].x;
                            menuY[menuCount] = player[i3].y;
                            menuID[menuCount] = player[i3].id;
                            menuVar[menuCount] = selectedItem;
                            menuCount++;
                        } else
                        {
                            if(l > 0 && (player[i3].y - 64) / magicLoc + dne + bigY < 2203)
                            {
                                menuText[menuCount] = "Attack";
                                menuDescription[menuCount] = "@whi@" + player[i3].name + s1;
                                menuType[menuCount] = 805;
                                menuX[menuCount] = player[i3].x;
                                menuY[menuCount] = player[i3].y;
                                menuID[menuCount] = player[i3].id;
                                menuCount++;
                            } else
								if(ServerList.world == 82 || ServerList.world == 84 || ServerList.world == 86)
								{
									menuText[menuCount] = "Duel with";
									menuDescription[menuCount] = "@whi@" + player[i3].name + s1;
									menuX[menuCount] = player[i3].x;
									menuY[menuCount] = player[i3].y;
									menuType[menuCount] = 2806;
									menuID[menuCount] = player[i3].id;
									menuCount++;
								}
                            menuText[menuCount] = "Trade with";
                            menuDescription[menuCount] = "@whi@" + player[i3].name + s1;
                            menuType[menuCount] = 2810;
                            menuID[menuCount] = player[i3].id;
                            menuCount++;
                            menuText[menuCount] = "Follow";
                            menuDescription[menuCount] = "@whi@" + player[i3].name + s1;
                            menuType[menuCount] = 2820;
                            menuID[menuCount] = player[i3].id;
                            menuCount++;
                        }
                    } else
                    if(l3 == 2)
                    {
                        if(selectedSpell >= 0)
                        {
                            if(identify.spellType[selectedSpell] == 3)
                            {
                                menuText[menuCount] = "Cast " + identify.spellName[selectedSpell] + " on";
                                menuDescription[menuCount] = "@lre@" + identify.itemName[itemType[i3]];
                                menuType[menuCount] = 200;
                                menuX[menuCount] = itemX[i3];
                                menuY[menuCount] = itemY[i3];
                                menuID[menuCount] = itemType[i3];
                                menuVar[menuCount] = selectedSpell;
                                menuCount++;
                            }
                        } else
                        if(selectedItem >= 0)
                        {
                            menuText[menuCount] = "Use " + selectedItemName + " with";
                            menuDescription[menuCount] = "@lre@" + identify.itemName[itemType[i3]];
                            menuType[menuCount] = 210;
                            menuX[menuCount] = itemX[i3];
                            menuY[menuCount] = itemY[i3];
                            menuID[menuCount] = itemType[i3];
                            menuVar[menuCount] = selectedItem;
                            menuCount++;
                        } else
                        {
                            menuText[menuCount] = "Take";
                            menuDescription[menuCount] = "@lre@" + identify.itemName[itemType[i3]];
                            menuType[menuCount] = 220;
                            menuX[menuCount] = itemX[i3];
                            menuY[menuCount] = itemY[i3];
                            menuID[menuCount] = itemType[i3];
                            menuCount++;
                            menuText[menuCount] = "Examine";
                            menuDescription[menuCount] = "@lre@" + identify.itemName[itemType[i3]];
                            menuType[menuCount] = 3200;
                            menuID[menuCount] = itemType[i3];
                            menuCount++;
                        }
                    } else
                    if(l3 == 3)
                    {
                        String s2 = "";
                        int l4 = -1;
                        int i5 = npc[i3].type;
                        if(identify.npcAttackable[i5] > 0)
                        {
                            int j5 = (identify.npcAttack[i5] + identify.npcDefence[i5] + identify.npcStrength[i5] + identify.npcHits[i5]) / 4;
                            int k5 = (playerStat[0] + playerStat[1] + playerStat[2] + playerStat[3] + 27) / 4;
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
                        if(selectedSpell >= 0)
                        {
                            if(identify.spellType[selectedSpell] == 2)
                            {
                                menuText[menuCount] = "Cast " + identify.spellName[selectedSpell] + " on";
                                menuDescription[menuCount] = "@yel@" + identify.npcName[npc[i3].type];
                                menuType[menuCount] = 700;
                                menuX[menuCount] = npc[i3].x;
                                menuY[menuCount] = npc[i3].y;
                                menuID[menuCount] = npc[i3].id;
                                menuVar[menuCount] = selectedSpell;
                                menuCount++;
                            }
                        } else
                        if(selectedItem >= 0)
                        {
                            menuText[menuCount] = "Use " + selectedItemName + " with";
                            menuDescription[menuCount] = "@yel@" + identify.npcName[npc[i3].type];
                            menuType[menuCount] = 710;
                            menuX[menuCount] = npc[i3].x;
                            menuY[menuCount] = npc[i3].y;
                            menuID[menuCount] = npc[i3].id;
                            menuVar[menuCount] = selectedItem;
                            menuCount++;
                        } else
                        {
                            if(identify.npcAttackable[i5] > 0)
                            {
                                menuText[menuCount] = "Attack";
                                menuDescription[menuCount] = "@yel@" + identify.npcName[npc[i3].type] + s2;
                                menuType[menuCount] = 715;
                                menuX[menuCount] = npc[i3].x;
                                menuY[menuCount] = npc[i3].y;
                                menuID[menuCount] = npc[i3].id;
                                menuCount++;
                            }
                            menuText[menuCount] = "Talk-to";
                            menuDescription[menuCount] = "@yel@" + identify.npcName[npc[i3].type];
                            menuType[menuCount] = 720;
                            menuX[menuCount] = npc[i3].x;
                            menuY[menuCount] = npc[i3].y;
                            menuID[menuCount] = npc[i3].id;
                            menuCount++;
                            if(!identify.npcCommand[i5].equals(""))
                            {
                                menuText[menuCount] = identify.npcCommand[i5];
                                menuDescription[menuCount] = "@yel@" + identify.npcName[npc[i3].type];
                                menuType[menuCount] = 725;
                                menuX[menuCount] = npc[i3].x;
                                menuY[menuCount] = npc[i3].y;
                                menuID[menuCount] = npc[i3].id;
                                menuCount++;
                            }
                            menuText[menuCount] = "Examine";
                            menuDescription[menuCount] = "@yel@" + identify.npcName[npc[i3].type];
                            menuType[menuCount] = 3700;
                            menuID[menuCount] = npc[i3].type;
                            menuCount++;
                        }
                    }
                } else
                if(l2 != null && l2.chk >= 10000)
                {
                    int j3 = l2.chk - 10000;
                    int i4 = doorType[j3];
                    if(!dnl[j3])
                    {
                        if(selectedSpell >= 0)
                        {
                            if(identify.spellType[selectedSpell] == 4)
                            {
                                menuText[menuCount] = "Cast " + identify.spellName[selectedSpell] + " on";
                                menuDescription[menuCount] = "@cya@" + identify.doorName[i4];
                                menuType[menuCount] = 300;
                                menuX[menuCount] = doorX[j3];
                                menuY[menuCount] = doorY[j3];
                                menuID[menuCount] = doorDir[j3];
                                menuVar[menuCount] = selectedSpell;
                                menuCount++;
                            }
                        } else
                        if(selectedItem >= 0)
                        {
                            menuText[menuCount] = "Use " + selectedItemName + " with";
                            menuDescription[menuCount] = "@cya@" + identify.doorName[i4];
                            menuType[menuCount] = 310;
                            menuX[menuCount] = doorX[j3];
                            menuY[menuCount] = doorY[j3];
                            menuID[menuCount] = doorDir[j3];
                            menuVar[menuCount] = selectedItem;
                            menuCount++;
                        } else
                        {
                            if(!identify.doorCommand[i4].equalsIgnoreCase("WalkTo"))
                            {
                                menuText[menuCount] = identify.doorCommand[i4];
                                menuDescription[menuCount] = "@cya@" + identify.doorName[i4];
                                menuType[menuCount] = 320;
                                menuX[menuCount] = doorX[j3];
                                menuY[menuCount] = doorY[j3];
                                menuID[menuCount] = doorDir[j3];
                                menuCount++;
                            }
                            if(!identify.doorCommand2[i4].equalsIgnoreCase("Examine"))
                            {
                                menuText[menuCount] = identify.doorCommand2[i4];
                                menuDescription[menuCount] = "@cya@" + identify.doorName[i4];
                                menuType[menuCount] = 2300;
                                menuX[menuCount] = doorX[j3];
                                menuY[menuCount] = doorY[j3];
                                menuID[menuCount] = doorDir[j3];
                                menuCount++;
                            }
                            menuText[menuCount] = "Examine";
                            menuDescription[menuCount] = "@cya@" + identify.doorName[i4];
                            menuType[menuCount] = 3300;
                            menuID[menuCount] = i4;
                            menuCount++;
                        }
                        dnl[j3] = true;
                    }
                } else
                if(l2 != null && l2.chk >= 0)
                {
                    int k3 = l2.chk;
                    int j4 = objectType[k3];
                    if(!egm[k3])
                    {
                        if(selectedSpell >= 0)
                        {
                            if(identify.spellType[selectedSpell] == 5)
                            {
                                menuText[menuCount] = "Cast " + identify.spellName[selectedSpell] + " on";
                                menuDescription[menuCount] = "@cya@" + identify.objectName[j4];
                                menuType[menuCount] = 400;
                                menuX[menuCount] = objectX[k3];
                                menuY[menuCount] = objectY[k3];
                                menuID[menuCount] = objectID[k3];
                                menuVar[menuCount] = objectType[k3];
                                menuVar2[menuCount] = selectedSpell;
                                menuCount++;
                            }
                        } else
                        if(selectedItem >= 0)
                        {
                            menuText[menuCount] = "Use " + selectedItemName + " with";
                            menuDescription[menuCount] = "@cya@" + identify.objectName[j4];
                            menuType[menuCount] = 410;
                            menuX[menuCount] = objectX[k3];
                            menuY[menuCount] = objectY[k3];
                            menuID[menuCount] = objectID[k3];
                            menuVar[menuCount] = objectType[k3];
                            menuVar2[menuCount] = selectedItem;
                            menuCount++;
                        } else
                        {
                            if(!identify.objectCommand[j4].equalsIgnoreCase("WalkTo"))
                            {
                                menuText[menuCount] = identify.objectCommand[j4];
                                menuDescription[menuCount] = "@cya@" + identify.objectName[j4];
                                menuType[menuCount] = 420;
                                menuX[menuCount] = objectX[k3];
                                menuY[menuCount] = objectY[k3];
                                menuID[menuCount] = objectID[k3];
                                menuVar[menuCount] = objectType[k3];
                                menuCount++;
                            }
                            if(!identify.objectCommand2[j4].equalsIgnoreCase("Examine"))
                            {
                                menuText[menuCount] = identify.objectCommand2[j4];
                                menuDescription[menuCount] = "@cya@" + identify.objectName[j4];
                                menuType[menuCount] = 2400;
                                menuX[menuCount] = objectX[k3];
                                menuY[menuCount] = objectY[k3];
                                menuID[menuCount] = objectID[k3];
                                menuVar[menuCount] = objectType[k3];
                                menuCount++;
                            }
                            menuText[menuCount] = "Examine";
                            menuDescription[menuCount] = "@cya@" + identify.objectName[j4];
                            menuType[menuCount] = 3400;
                            menuID[menuCount] = j4;
                            menuCount++;
                        }
                        egm[k3] = true;
                    }
                } else
                {
                    if(j2 >= 0)
                        j2 = l2.chl[j2] - 0x30d40;
                    if(j2 >= 0)
                        i1 = j2;
                }
        }

        if(selectedSpell >= 0 && identify.spellType[selectedSpell] <= 1)
        {
            menuText[menuCount] = "Cast " + identify.spellName[selectedSpell] + " on self";
            menuDescription[menuCount] = "";
            menuType[menuCount] = 1000;
            menuID[menuCount] = selectedSpell;
            menuCount++;
        }
        if(i1 != -1)
        {
            int k2 = i1;
            if(selectedSpell >= 0)
            {
                if(identify.spellType[selectedSpell] == 6)
                {
                    menuText[menuCount] = "Cast " + identify.spellName[selectedSpell] + " on ground";
                    menuDescription[menuCount] = "";
                    menuType[menuCount] = 900;
                    menuX[menuCount] = gameHandle.selectedX[k2];
                    menuY[menuCount] = gameHandle.selectedY[k2];
                    menuID[menuCount] = selectedSpell;
                    menuCount++;
                    return;
                }
            } else
            if(selectedItem < 0)
            {
                menuText[menuCount] = "Walk here";
                menuDescription[menuCount] = "";
                menuType[menuCount] = 920;
                menuX[menuCount] = gameHandle.selectedX[k2];
                menuY[menuCount] = gameHandle.selectedY[k2];
                menuCount++;
            }
        }
    }

    protected final void enn()
    {
        /*if(dhh)
        {
            String s1 = getDocumentBase().getHost().toLowerCase();
            if(!s1.endsWith("jagex.com") && !s1.endsWith("jagex.co.uk") && !s1.endsWith("runescape.com") && !s1.endsWith("runescape.co.uk") && !s1.endsWith("runescape.net") && !s1.endsWith("runescape.org") && !s1.endsWith("penguin") && !s1.endsWith("puffin"))
            {
                eki = true;
                return;
            }
        }*/
        int l = 0;
        for(int i1 = 0; i1 < 99; i1++)
        {
            int j1 = i1 + 1;
            int l1 = (int)((double)j1 + 300D * Math.pow(2D, (double)j1 / 7D));
            l += l1;
            dik[i1] = l & 0xffffffc;
        }

        try
        {
            String s2 = getParameter("referid");
            ejh = Integer.parseInt(s2);
        }
        catch(Exception _ex) { }
        try
        {
            String s3 = getParameter("member");
            int i2 = Integer.parseInt(s3);
            if(i2 == 1)
                member = true;
        }
        catch(Exception _ex) { }
        if(dhh)
            super.serverPort = 43594;
        super.fik = 0;
        b.aab = 1000;
        b.aaa = w.cem;
        try
        {
            String s4 = getParameter("poff");
            int j2 = Integer.parseInt(s4);
            super.serverPort += j2;
            System.out.println("Offset: " + j2);
        }
        catch(Exception _ex) { }
        fck();
        if(ein)
            return;
        del = 2000;
        dem = del + 100;
        den = dem + 50;
        dfd = den + 1000;
        dfa = dfd + 10;
        dfb = dfa + 50;
        dfc = dfb + 10;
        dci = getGraphics();
        fle(50);
        gfx = new k(width, height + 12, 4000, this);
        gfx.dai = this;
        gfx.cah(0, 0, width, height + 12);
        h.gdh = false;
        h.gdi = dem;
        ebj = new h(gfx, 5);
        int k1 = ((j) (gfx)).blg - 199;
        byte byte0 = 36;
        ebk = ebj.gfk(k1, byte0 + 24, 196, 90, 1, 500, true);
        ejn = new h(gfx, 5);
        eka = ejn.gfk(k1, byte0 + 40, 196, 126, 1, 500, true);
        dig = new h(gfx, 5);
        dih = dig.gfk(k1, byte0 + 24, 196, 251, 1, 500, true);
        fdm();
        if(ein)
            return;
        fec();
        if(ein)
            return;
        efn = new n(gfx, 15000, 15000, 1000);
        efn.bhk(width / 2, height / 2, width / 2, height / 2, width, dcn);
		if (fogOfWar)
		{
			efn.bbg = 2100;
			efn.bbh = 2100;
			efn.bbi = 1;
			efn.bbj = 2000;
		} else {
			efn.bbg = 40000;
			efn.bbh = 40000;
			efn.bbi = 40000;
			efn.bbj = 40000;
		}
        efn.bjk(-50, -10, -50);
        gameHandle = new x(efn, gfx);
        gameHandle.gil = del;
        fee();
        if(ein)
            return;
        fbb();
        if(ein)
            return;
        enj();
        if(ein)
            return;
        if(member)
            fbg();
        if(ein)
        {
            return;
        } else
        {
            flj(100, "Starting game...");
            end();
            redrawMenu();
            fbd();
            fbn();
            flb();
            fdh();
            return;
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

    public final void drawGame()
    {
        if(dfl != 0)
        {
            gfx.clear();
            gfx.drawText("Oh dear! You are dead...", width / 2, height / 2, 7, 0xff0000);
            fcm();
            gfx.drawGame(dci, 0, 0);
            return;
        }
        if(efc)
        {
            fdl();
            return;
        }
        if(sleeping)
        {
            gfx.clear();
            if(Math.random() < 0.14999999999999999D)
                gfx.drawText("ZZZ", (int)(Math.random() * 80D), (int)(Math.random() * 334D), 5, (int)(Math.random() * 16777215D));
            if(Math.random() < 0.14999999999999999D)
                gfx.drawText("ZZZ", 512 - (int)(Math.random() * 80D), (int)(Math.random() * 334D), 5, (int)(Math.random() * 16777215D));
            gfx.drawBox(width / 2 - 100, 160, 200, 40, 0);
            gfx.drawText("You are sleeping", width / 2, 50, 7, 0xffff00);
            gfx.drawText("Fatigue: " + (tfatigue * 100) / 750 + "%", width / 2, 90, 7, 0xffff00);
            gfx.drawText("When you want to wake up just use your", width / 2, 140, 5, 0xffffff);
            gfx.drawText("keyboard to type the word in the box below", width / 2, 160, 5, 0xffffff);
            gfx.drawText(super.fkl + "*", width / 2, 180, 5, 65535);
            if(eke == null)
                gfx.drawPicture(width / 2 - 127, 230, dfb + 1);
            else
                gfx.drawText(eke, width / 2, 260, 5, 0xff0000);
            gfx.drawBoxEdge(width / 2 - 128, 229, 257, 42, 0xffffff);
            fcm();
            gfx.drawText("If you can't read the word", width / 2, 290, 1, 0xffffff);
            gfx.drawText("@yel@click here@whi@ to get a different one", width / 2, 305, 1, 0xffffff);
            gfx.drawGame(dci, 0, 0);
            return;
        }
        if(!gameHandle.gie)
            return;
        for(int l = 0; l < 64; l++)
        {
            efn.bgn(gameHandle.gih[dng][l]);
            if(dng == 0)
            {
                efn.bgn(gameHandle.ghm[1][l]);
                efn.bgn(gameHandle.gih[1][l]);
                efn.bgn(gameHandle.ghm[2][l]);
                efn.bgn(gameHandle.gih[2][l]);
            }
            djc = true;
            if(dng == 0 && (gameHandle.ghb[myPlayer.x / 128][myPlayer.y / 128] & 0x80) == 0)
            {
                efn.bgm(gameHandle.gih[dng][l]);
                if(dng == 0)
                {
                    efn.bgm(gameHandle.ghm[1][l]);
                    efn.bgm(gameHandle.gih[1][l]);
                    efn.bgm(gameHandle.ghm[2][l]);
                    efn.bgm(gameHandle.gih[2][l]);
                }
                djc = false;
            }
        }

        if(edi != dmg)
        {
            dmg = edi;
            for(int i1 = 0; i1 < objectCount; i1++)
            {
                if(objectType[i1] == 97)
                    emh(i1, "firea" + (edi + 1));
                if(objectType[i1] == 274)
                    emh(i1, "fireplacea" + (edi + 1));
                if(objectType[i1] == 1031)
                    emh(i1, "lightning" + (edi + 1));
                if(objectType[i1] == 1036)
                    emh(i1, "firespell" + (edi + 1));
                if(objectType[i1] == 1147)
                    emh(i1, "spellcharge" + (edi + 1));
            }

        }
        if(edj != dmh)
        {
            dmh = edj;
            for(int j1 = 0; j1 < objectCount; j1++)
            {
                if(objectType[j1] == 51)
                    emh(j1, "torcha" + (edj + 1));
                if(objectType[j1] == 143)
                    emh(j1, "skulltorcha" + (edj + 1));
            }

        }
        if(edk != dmi)
        {
            dmi = edk;
            for(int k1 = 0; k1 < objectCount; k1++)
                if(objectType[k1] == 1142)
                    emh(k1, "clawspell" + (edk + 1));

        }
        efn.bhc(efi);
        efi = 0;
        for(int l1 = 0; l1 < playerCount; l1++)
        {
            f f1 = player[l1];
            if(f1.hab != 255)
            {
                int j2 = f1.x;
                int l2 = f1.y;
                int j3 = -gameHandle.gla(j2, l2);
                int k4 = efn.bhd(5000 + l1, j2, j3, l2, 145, 220, l1 + 10000);
                efi++;
                if(f1 == myPlayer)
                    efn.bhe(k4);
                if(f1.sprite == 8)
                    efn.bhf(k4, -30);
                if(f1.sprite == 9)
                    efn.bhf(k4, 30);
            }
        }

        for(int i2 = 0; i2 < playerCount; i2++)
        {
            f f2 = player[i2];
            if(f2.hag > 0)
            {
                f f3 = null;
                if(f2.haf != -1)
                    f3 = dgj[f2.haf];
                else
                if(f2.hae != -1)
                    f3 = eba[f2.hae];
                if(f3 != null)
                {
                    int k3 = f2.x;
                    int l4 = f2.y;
                    int k7 = -gameHandle.gla(k3, l4) - 110;
                    int k9 = f3.x;
                    int j10 = f3.y;
                    int k10 = -gameHandle.gla(k9, j10) - identify.alf[f3.type] / 2;
                    int l10 = (k3 * f2.hag + k9 * (ebc - f2.hag)) / ebc;
                    int i11 = (k7 * f2.hag + k10 * (ebc - f2.hag)) / ebc;
                    int j11 = (l4 * f2.hag + j10 * (ebc - f2.hag)) / ebc;
                    efn.bhd(dfa + f2.had, l10, i11, j11, 32, 32, 0);
                    efi++;
                }
            }
        }

        for(int k2 = 0; k2 < npcCount; k2++)
        {
            f f4 = npc[k2];
            int l3 = f4.x;
            int i5 = f4.y;
            int l7 = -gameHandle.gla(l3, i5);
            int l9 = efn.bhd(20000 + k2, l3, l7, i5, identify.ale[f4.type], identify.alf[f4.type], k2 + 30000);
            efi++;
            if(f4.sprite == 8)
                efn.bhf(l9, -30);
            if(f4.sprite == 9)
                efn.bhf(l9, 30);
        }

        for(int i3 = 0; i3 < itemCount; i3++)
        {
            int i4 = itemX[i3] * magicLoc + 64;
            int j5 = itemY[i3] * magicLoc + 64;
            efn.bhd(40000 + itemType[i3], i4, -gameHandle.gla(i4, j5) - ekm[i3], j5, 96, 64, i3 + 20000);
            efi++;
        }

        for(int j4 = 0; j4 < ean; j4++)
        {
            int k5 = dnc[j4] * magicLoc + 64;
            int i8 = dgb[j4] * magicLoc + 64;
            int i10 = ekn[j4];
            if(i10 == 0)
            {
                efn.bhd(50000 + j4, k5, -gameHandle.gla(k5, i8), i8, 128, 256, j4 + 50000);
                efi++;
            }
            if(i10 == 1)
            {
                efn.bhd(50000 + j4, k5, -gameHandle.gla(k5, i8), i8, 128, 64, j4 + 50000);
                efi++;
            }
        }

        gfx.bnc = false;
        gfx.cak();
        gfx.bnc = super.fkk;
        if(dng == 3)
        {
            int l5 = 40 + (int)(Math.random() * 3D);
            int j8 = 40 + (int)(Math.random() * 7D);
            efn.bjl(l5, j8, -50, -10, -50);
        }
        dln = 0;
        efd = 0;
        egl = 0;
        if(dhg)
        {
            if(efb && !djc)
            {
                int i6 = ema;
                fbm();
                if(ema != i6)
                {
                    dlg = myPlayer.x;
                    dlh = myPlayer.y;
                }
            }
			if (fogOfWar)
			{
				efn.bbg = 4100;
				efn.bbh = 4100;
				efn.bbi = 1;
				efn.bbj = 4000;
			} else {
				efn.bbg = 40000;
				efn.bbh = 40000;
				efn.bbi = 40000;
				efn.bbj = 40000;
			}
            dke = ema * 32;
            int j6 = dlg + egf;
            int k8 = dlh + eea;
            efn.bin(j6, -gameHandle.gla(j6, k8), k8, zRot, dke * 4, 0, 2000);
        } else
        {
            if(efb && !djc)
                fbm();
            if(!super.fkk)
            {
				if (fogOfWar)
				{
					efn.bbg = 2400;
					efn.bbh = 2400;
					efn.bbi = 1;
					efn.bbj = 2200;
				} else {
					efn.bbg = 40000;
					efn.bbh = 40000;
					efn.bbi = 40000;
					efn.bbj = 40000;
				}
            } else
            {
				if (fogOfWar)
				{
					efn.bbg = 2200;
					efn.bbh = 2100;
					efn.bbi = 1;
					efn.bbj = 2100;
				} else {
					efn.bbg = 40000;
					efn.bbh = 40000;
					efn.bbi = 40000;
					efn.bbj = 40000;
				}
            }
            int k6 = dlg + egf;
            int l8 = dlh + eea;
            efn.bin(k6, -gameHandle.gla(k6, l8), l8, zRot, dke * 4, 0, zoom * 2);
        }
        efn.bib();
        enh();
        if(eak > 0)
            gfx.drawPicture(eal - 8, eam - 8, del + 14 + (24 - eak) / 6);
        if(eak < 0)
            gfx.drawPicture(eal - 8, eam - 8, del + 18 + (24 + eak) / 6);
        if(edh != 0)
        {
            int l6 = edh / 50;
            int i9 = l6 / 60;
            l6 %= 60;
            if(l6 < 10)
                gfx.drawText("System update in: " + i9 + ":0" + l6, 256, height - 7, 1, 0xffff00);
            else
                gfx.drawText("System update in: " + i9 + ":" + l6, 256, height - 7, 1, 0xffff00);
        }
		if(recordingSteps)
			gfx.drawText("@red@Recording steps - F4 to stop", 256, height - 7, 1, 0xffff00);
        if(!dcj)
        {
            int i7 = 2203 - (smallY + dne + bigY);
            if(smallX + dnd + bigX >= 2640)
                i7 = -50;
            if(i7 > 0)
            {
                int j9 = 1 + i7 / 6;
                gfx.drawPicture(453, height - 56, del + 13);
                gfx.drawText("Wilderness", 465, height - 20, 1, 0xffff00);
                gfx.drawText("Level: " + j9, 465, height - 7, 1, 0xffff00);
                if(dfj == 0)
                    dfj = 2;
            }
            if(dfj == 0 && i7 > -10 && i7 <= 0)
                dfj = 1;
        }
        if(ell == 0)
        {
            for(int j7 = 0; j7 < 5; j7++)
                if(def[j7] > 0)
                {
                    String s1 = egb[j7];
                    gfx.drawBoxText(s1, 7, height - 18 - j7 * 12, 1, 0xffff00);
                }

        }
        elg.ggf(elh);
        elg.ggf(elj);
        elg.ggf(elk);
        if(ell == 1)
            elg.gge(elh);
        else
        if(ell == 2)
            elg.gge(elj);
        else
        if(ell == 3)
            elg.gge(elk);
        h.gdm = 2;
        elg.ged();
        h.gdm = 0;
        gfx.ccd(((j) (gfx)).blg - 3 - 197, 3, del, 128);
        fad();
        gfx.bnf = false;
        fcm();
        gfx.drawGame(dci, 0, 0);
    }

    public final boolean fab(int arg0)
    {
        int l = myPlayer.x / 128;
        int i1 = myPlayer.y / 128;
        for(int j1 = 2; j1 >= 1; j1--)
        {
            if(arg0 == 1 && ((gameHandle.ghb[l][i1 - j1] & 0x80) == 128 || (gameHandle.ghb[l - j1][i1] & 0x80) == 128 || (gameHandle.ghb[l - j1][i1 - j1] & 0x80) == 128))
                return false;
            if(arg0 == 3 && ((gameHandle.ghb[l][i1 + j1] & 0x80) == 128 || (gameHandle.ghb[l - j1][i1] & 0x80) == 128 || (gameHandle.ghb[l - j1][i1 + j1] & 0x80) == 128))
                return false;
            if(arg0 == 5 && ((gameHandle.ghb[l][i1 + j1] & 0x80) == 128 || (gameHandle.ghb[l + j1][i1] & 0x80) == 128 || (gameHandle.ghb[l + j1][i1 + j1] & 0x80) == 128))
                return false;
            if(arg0 == 7 && ((gameHandle.ghb[l][i1 - j1] & 0x80) == 128 || (gameHandle.ghb[l + j1][i1] & 0x80) == 128 || (gameHandle.ghb[l + j1][i1 - j1] & 0x80) == 128))
                return false;
            if(arg0 == 0 && (gameHandle.ghb[l][i1 - j1] & 0x80) == 128)
                return false;
            if(arg0 == 2 && (gameHandle.ghb[l - j1][i1] & 0x80) == 128)
                return false;
            if(arg0 == 4 && (gameHandle.ghb[l][i1 + j1] & 0x80) == 128)
                return false;
            if(arg0 == 6 && (gameHandle.ghb[l + j1][i1] & 0x80) == 128)
                return false;
        }

        return true;
    }

    public final void fac(boolean arg0)
    {
        int l = ((j) (gfx)).blg - 248;
        gfx.drawPicture(l, 3, del + 1);
        for(int i1 = 0; i1 < dlk; i1++)
        {
            int j1 = l + (i1 % 5) * 49;
            int l1 = 36 + (i1 / 5) * 34;
            if(i1 < invCount && wearing[i1] == 1)
                gfx.drawBoxAlpha(j1, l1, 49, 34, 0xff0000, 128);
            else
                gfx.drawBoxAlpha(j1, l1, 49, 34, j.createRGB(181, 181, 181), 128);
            if(i1 < invCount)
            {
                gfx.cdd(j1, l1, 48, 32, den + identify.ajf[inv[i1]], identify.ajk[inv[i1]], 0, 0, false);
                if(identify.stackable[inv[i1]] == 0)
                    gfx.drawBoxText(String.valueOf(invValue[i1]), j1 + 1, l1 + 10, 1, 0xffff00);
            }
        }

        for(int k1 = 1; k1 <= 4; k1++)
            gfx.cbd(l + k1 * 49, 36, (dlk / 5) * 34, 0);

        for(int i2 = 1; i2 <= dlk / 5 - 1; i2++)
            gfx.drawLine(l, 36 + i2 * 34, 245, 0);

        if(!arg0)
            return;
        l = super.mouseX - (((j) (gfx)).blg - 248);
        int j2 = super.mouseY - 36;
        if(l >= 0 && j2 >= 0 && l < 248 && j2 < (dlk / 5) * 34)
        {
            int k2 = l / 49 + (j2 / 34) * 5;
            if(k2 < invCount)
            {
                int l2 = inv[k2];
                if(selectedSpell >= 0)
                {
                    if(identify.spellType[selectedSpell] == 3)
                    {
                        menuText[menuCount] = "Cast " + identify.spellName[selectedSpell] + " on";
                        menuDescription[menuCount] = "@lre@" + identify.itemName[l2];
                        menuType[menuCount] = 600;
                        menuID[menuCount] = k2;
                        menuVar[menuCount] = selectedSpell;
                        menuCount++;
                        return;
                    }
                } else
                {
                    if(selectedItem >= 0)
                    {
                        menuText[menuCount] = "Use " + selectedItemName + " with";
                        menuDescription[menuCount] = "@lre@" + identify.itemName[l2];
                        menuType[menuCount] = 610;
                        menuID[menuCount] = k2;
                        menuVar[menuCount] = selectedItem;
                        menuCount++;
                        return;
                    }
                    if(wearing[k2] == 1)
                    {
                        menuText[menuCount] = "Remove";
                        menuDescription[menuCount] = "@lre@" + identify.itemName[l2];
                        menuType[menuCount] = 620;
                        menuID[menuCount] = k2;
                        menuCount++;
                    } else
                    if(identify.wieldable[l2] != 0)
                    {
                        if((identify.wieldable[l2] & 0x18) != 0)
                            menuText[menuCount] = "Wield";
                        else
                            menuText[menuCount] = "Wear";
                        menuDescription[menuCount] = "@lre@" + identify.itemName[l2];
                        menuType[menuCount] = 630;
                        menuID[menuCount] = k2;
                        menuCount++;
                    }
                    if(!identify.itemCommand[l2].equals(""))
                    {
                        menuText[menuCount] = identify.itemCommand[l2];
                        menuDescription[menuCount] = "@lre@" + identify.itemName[l2];
                        menuType[menuCount] = 640;
                        menuID[menuCount] = k2;
                        menuCount++;
                    }
                    menuText[menuCount] = "Use";
                    menuDescription[menuCount] = "@lre@" + identify.itemName[l2];
                    menuType[menuCount] = 650;
                    menuID[menuCount] = k2;
                    menuCount++;
                    menuText[menuCount] = "Drop";
                    menuDescription[menuCount] = "@lre@" + identify.itemName[l2];
                    menuType[menuCount] = 660;
                    menuID[menuCount] = k2;
                    menuCount++;
                    menuText[menuCount] = "Examine";
                    menuDescription[menuCount] = "@lre@" + identify.itemName[l2];
                    menuType[menuCount] = 3600;
                    menuID[menuCount] = l2;
                    menuCount++;
                }
            }
        }
    }

    public final void fad()
    {
        if(dhf != 0)
            drawLogoutBox();
        else
        /*if(eab)
            fag();
        else
        if(ega)
            enc();
        else*/
        if(dfj == 1)
            fdj();
        else
        if(bank && eda == 0)
            drawBank();
        else
        if(shop && eda == 0)
            fai();
        else
        if(tradeSecondScreen)
            fbh();
        else
        if(trade)
            fak();
        else
        if(duelSecondScreen)
            fda();
        else
        if(duel)
            fbk();
        else
        if(egc == 1)
            fbi();
        else
        if(egc == 2)
            fbe();
        else
        if(efm != 0)
        {
            eng();
        } else
        {
            if(questMenu)
                emk();
            if(myPlayer.sprite == 8 || myPlayer.sprite == 9)
                drawFightMode();
            enf();
            boolean flag = !questMenu && !ejm;
            if(flag)
                menuCount = 0;
            if(selectedMenu == 0 && flag)
                enm();
            if(selectedMenu == 1)
                fac(flag);
            if(selectedMenu == 2)
                fbj(flag);
            if(selectedMenu == 3)
                fbc(flag);
            if(selectedMenu == 4)
                fdc(flag);
            if(selectedMenu == 5)
                fcb(flag);
            if(selectedMenu == 6)
                fbf(flag);
            if(!ejm && !questMenu)
                eni();
            if(ejm && !questMenu)
                fah();
        }
        ebd = 0;
    }

    public final void redrawMenu()
    {
        menuMain = new h(gfx, 50);
        int l = 25;
		String strWorld;
		if (ServerList.world == 52 || ServerList.world == 84 || ServerList.world == 86)
			strWorld = "@red@";
		else
			strWorld = "@ora@";
		strWorld = strWorld + ServerList.world;

		menuMain.drawMenuButton(200, 215 + l, 20, 20);
		menuMain.drawMenuText(200, 215 + l, "<", 5, false);
		decWorld = menuMain.createButtonHandle(200, 215 + l, 20, 20);

		menuMain.drawMenuButton(312, 215 + l, 20, 20);
		menuMain.drawMenuText(312, 215 + l, ">", 5, false);
		incWorld = menuMain.createButtonHandle(312, 215 + l, 20, 20);

		menuMain.drawMenuText(256, 215 + l, strWorld, 4, true);

		if (mainMenuMessage != null)
			menuMain.drawMenuText(256, 220, mainMenuMessage, 4, true);

		l += 15;

		menuMain.drawMenuButton(450, 230, 40, 20);
		menuMain.drawMenuText(450, 230, "@bla@v" + version, 1, true);
		checkUpdate = menuMain.createButtonHandle(450, 230, 40, 20);

		menuMain.drawMenuText(256, 215 + l, "@whi@TBoT199", 4, true);
		menuMain.drawMenuButton(256, 250 + l, 200, 35);
		menuMain.drawMenuText(256, 250 + l, "Begin", 5, false);
		beginButtonHandle = menuMain.createButtonHandle(256, 250 + l, 200, 35);

        menuNewAccount = new h(gfx, 50);
        l = 230;
		menuNewAccount.drawMenuText(256, l + 8, "To create an account please go back to the", 4, true);
		l += 20;
		menuNewAccount.drawMenuText(256, l + 8, "www.runescape.com front page, and choose 'create account'", 4, true);
        l += 30;
        menuNewAccount.drawMenuButton(256, l + 17, 150, 34);
        menuNewAccount.drawMenuText(256, l + 17, "Ok", 5, false);
        ejj = menuNewAccount.createButtonHandle(256, l + 17, 150, 34);

        menuLogin = new h(gfx, 50);
        l = 230;
        elb = menuLogin.drawMenuText(256, l - 10, "Please enter your username and password", 4, true);
        l += 28;
        menuLogin.drawMenuButton(140, l, 200, 40);
        menuLogin.drawMenuText(140, l - 10, "Username:", 4, false);
        elc = menuLogin.createTextHandle(140, l + 10, 200, 40, 4, 12, false, false);
        l += 47;
        menuLogin.drawMenuButton(190, l, 200, 40);
        menuLogin.drawMenuText(190, l - 10, "Password:", 4, false);
        eld = menuLogin.createTextHandle(190, l + 10, 200, 40, 4, 20, true, false);
        l -= 55;
        menuLogin.drawMenuButton(410, l, 120, 25);
        menuLogin.drawMenuText(410, l, "Ok", 4, false);
        ele = menuLogin.createButtonHandle(410, l, 120, 25);
        l += 30;
        menuLogin.drawMenuButton(410, l, 120, 25);
        menuLogin.drawMenuText(410, l, "Cancel", 4, false);
        elf = menuLogin.createButtonHandle(410, l, 120, 25);
        l += 30;
        menuLogin.ggg(elc);
    }

    public final boolean faf(int l, int i1)
    {
        if(l == 31 && (fcj(197) || fcj(615) || fcj(682)))
            return true;
        if(l == 32 && (fcj(102) || fcj(616) || fcj(683)))
            return true;
        if(l == 33 && (fcj(101) || fcj(617) || fcj(684)))
            return true;
        if(l == 34 && (fcj(103) || fcj(618) || fcj(685)))
            return true;
        return invCount(l) >= i1;
    }

    public final void fag()
    {
        int l = 65;
        if(ddb != 201)
            l += 60;
        if(dij > 0)
            l += 60;
        if(dif != 0)
            l += 45;
        int i1 = 167 - l / 2;
        gfx.drawBox(56, 167 - l / 2, 400, l, 0);
        gfx.drawBoxEdge(56, 167 - l / 2, 400, l, 0xffffff);
        i1 += 20;
        gfx.drawText("Welcome to RuneScape " + username, 256, i1, 4, 0xffff00);
        i1 += 30;
        String s1;
        if(ela == 0)
            s1 = "earlier today";
        else
        if(ela == 1)
            s1 = "yesterday";
        else
            s1 = ela + " days ago";
        if(dif != 0)
        {
            gfx.drawText("You last logged in " + s1, 256, i1, 1, 0xffffff);
            i1 += 15;
            if(edd == null)
                edd = fdi(dif);
            gfx.drawText("from: " + edd, 256, i1, 1, 0xffffff);
            i1 += 15;
            i1 += 15;
        }
        if(dij > 0)
        {
            int j1 = 0xffffff;
            gfx.drawText("Jagex staff will NEVER email you. We use the", 256, i1, 1, j1);
            i1 += 15;
            gfx.drawText("message-centre on this website instead.", 256, i1, 1, j1);
            i1 += 15;
            if(dij == 1)
                gfx.drawText("You have @yel@0@whi@ unread messages in your message-centre", 256, i1, 1, 0xffffff);
            else
                gfx.drawText("You have @gre@" + (dij - 1) + " unread messages @whi@in your message-centre", 256, i1, 1, 0xffffff);
            i1 += 15;
            i1 += 15;
        }
        if(ddb != 201)
        {
            if(ddb == 200)
            {
                gfx.drawText("You have not yet set any password recovery questions.", 256, i1, 1, 0xff8000);
                i1 += 15;
                gfx.drawText("We strongly recommend you do so now to secure your account.", 256, i1, 1, 0xff8000);
                i1 += 15;
                gfx.drawText("Do this from the 'account management' area on our front webpage", 256, i1, 1, 0xff8000);
                i1 += 15;
            } else
            {
                String s2;
                if(ddb == 0)
                    s2 = "Earlier today";
                else
                if(ddb == 1)
                    s2 = "Yesterday";
                else
                    s2 = ddb + " days ago";
                gfx.drawText(s2 + " you changed your recovery questions", 256, i1, 1, 0xff8000);
                i1 += 15;
                gfx.drawText("If you do not remember making this change then cancel it immediately", 256, i1, 1, 0xff8000);
                i1 += 15;
                gfx.drawText("Do this from the 'account management' area on our front webpage", 256, i1, 1, 0xff8000);
                i1 += 15;
            }
            i1 += 15;
        }
        int k1 = 0xffffff;
        if(super.mouseY > i1 - 12 && super.mouseY <= i1 && super.mouseX > 106 && super.mouseX < 406)
            k1 = 0xff0000;
        gfx.drawText("Click here to close window", 256, i1, 1, k1);
        if(ebd == 1)
        {
            if(k1 == 0xff0000)
                eab = false;
            if((super.mouseX < 86 || super.mouseX > 426) && (super.mouseY < 167 - l / 2 || super.mouseY > 167 + l / 2))
                eab = false;
        }
        ebd = 0;
    }

    public final void fah()
    {
        if(ebd != 0)
        {
            for(int l = 0; l < menuCount; l++)
            {
                int j1 = ehg + 2;
                int l1 = ehh + 27 + l * 15;
                if(super.mouseX <= j1 - 2 || super.mouseY <= l1 - 12 || super.mouseY >= l1 + 4 || super.mouseX >= (j1 - 3) + ehi)
                    continue;
                handleMenu(dda[l]);
                break;
            }

            ebd = 0;
            ejm = false;
            return;
        }
        if(super.mouseX < ehg - 10 || super.mouseY < ehh - 10 || super.mouseX > ehg + ehi + 10 || super.mouseY > ehh + ehj + 10)
        {
            ejm = false;
            return;
        }
        gfx.drawBoxAlpha(ehg, ehh, ehi, ehj, 0xd0d0d0, 160);
        gfx.drawBoxText("Choose option", ehg + 2, ehh + 12, 1, 65535);
        for(int i1 = 0; i1 < menuCount; i1++)
        {
            int k1 = ehg + 2;
            int i2 = ehh + 27 + i1 * 15;
            int j2 = 0xffffff;
            if(super.mouseX > k1 - 2 && super.mouseY > i2 - 12 && super.mouseY < i2 + 4 && super.mouseX < (k1 - 3) + ehi)
                j2 = 0xffff00;
            gfx.drawBoxText(menuText[dda[i1]] + " " + menuDescription[dda[i1]], k1, i2, 1, j2);
        }

    }

    public final void fai()
    {
        if(ebd != 0)
        {
            ebd = 0;
            int l = super.mouseX - 52;
            int i1 = super.mouseY - 44;
            if(l >= 0 && i1 >= 12 && l < 408 && i1 < 246)
            {
                int j1 = 0;
                for(int l1 = 0; l1 < 5; l1++)
                {
                    for(int l2 = 0; l2 < 8; l2++)
                    {
                        int k3 = 7 + l2 * 49;
                        int k4 = 28 + l1 * 34;
                        if(l > k3 && l < k3 + 49 && i1 > k4 && i1 < k4 + 34 && shopItem[j1] != -1)
                        {
                            selectedShop = j1;
                            dmm = shopItem[j1];
                        }
                        j1++;
                    }

                }

                if(selectedShop >= 0)
                {
                    int i3 = shopItem[selectedShop];
                    if(i3 != -1)
                    {
                        if(shopItemCount[selectedShop] > 0 && l > 298 && i1 >= 204 && l < 408 && i1 <= 215)
                        {
                            int l3 = dni + dka[selectedShop];
                            if(l3 < 10)
                                l3 = 10;
                            int l4 = (l3 * identify.itemPrice[i3]) / 100;
                            super.connection.newID(67);
                            super.connection.addInt(shopItem[selectedShop]);
                            super.connection.addLongInt(l4);
                            super.connection.complete();
                        }
                        if(invCount(i3) > 0 && l > 2 && i1 >= 229 && l < 112 && i1 <= 240)
                        {
                            int i4 = dnh + dka[selectedShop];
                            if(i4 < 10)
                                i4 = 10;
                            int i5 = (i4 * identify.itemPrice[i3]) / 100;
                            super.connection.newID(177);
                            super.connection.addInt(shopItem[selectedShop]);
                            super.connection.addLongInt(i5);
                            super.connection.complete();
                        }
                    }
                }
            } else
            {
                super.connection.newID(92);
                super.connection.complete();
                shop = false;
                return;
            }
        }
        byte byte0 = 52;
        byte byte1 = 44;
        gfx.drawBox(byte0, byte1, 408, 12, 192);
        int k1 = 0x989898;
        gfx.drawBoxAlpha(byte0, byte1 + 12, 408, 17, k1, 160);
        gfx.drawBoxAlpha(byte0, byte1 + 29, 8, 170, k1, 160);
        gfx.drawBoxAlpha(byte0 + 399, byte1 + 29, 9, 170, k1, 160);
        gfx.drawBoxAlpha(byte0, byte1 + 199, 408, 47, k1, 160);
        gfx.drawBoxText("Buying and selling items", byte0 + 1, byte1 + 10, 1, 0xffffff);
        int i2 = 0xffffff;
        if(super.mouseX > byte0 + 320 && super.mouseY >= byte1 && super.mouseX < byte0 + 408 && super.mouseY < byte1 + 12)
            i2 = 0xff0000;
        gfx.drawBoxTextRight("Close window", byte0 + 406, byte1 + 10, 1, i2);
        gfx.drawBoxText("Shops stock in green", byte0 + 2, byte1 + 24, 1, 65280);
        gfx.drawBoxText("Number you own in blue", byte0 + 135, byte1 + 24, 1, 65535);
        gfx.drawBoxText("Your money: " + invCount(10) + "gp", byte0 + 280, byte1 + 24, 1, 0xffff00);
        int j3 = 0xd0d0d0;
        int j4 = 0;
        for(int j5 = 0; j5 < 5; j5++)
        {
            for(int k5 = 0; k5 < 8; k5++)
            {
                int i6 = byte0 + 7 + k5 * 49;
                int l6 = byte1 + 28 + j5 * 34;
                if(selectedShop == j4)
                    gfx.drawBoxAlpha(i6, l6, 49, 34, 0xff0000, 160);
                else
                    gfx.drawBoxAlpha(i6, l6, 49, 34, j3, 160);
                gfx.drawBoxEdge(i6, l6, 50, 35, 0);
                if(shopItem[j4] != -1)
                {
                    gfx.cdd(i6, l6, 48, 32, den + identify.ajf[shopItem[j4]], identify.ajk[shopItem[j4]], 0, 0, false);
                    gfx.drawBoxText(String.valueOf(shopItemCount[j4]), i6 + 1, l6 + 10, 1, 65280);
                    gfx.drawBoxTextRight(String.valueOf(invCount(shopItem[j4])), i6 + 47, l6 + 10, 1, 65535);
                }
                j4++;
            }

        }

        gfx.drawLine(byte0 + 5, byte1 + 222, 398, 0);
        if(selectedShop == -1)
        {
            gfx.drawText("Select an object to buy or sell", byte0 + 204, byte1 + 214, 3, 0xffff00);
            return;
        }
        int l5 = shopItem[selectedShop];
        if(l5 != -1)
        {
            if(shopItemCount[selectedShop] > 0)
            {
                int j6 = dni + dka[selectedShop];
                if(j6 < 10)
                    j6 = 10;
                int i7 = (j6 * identify.itemPrice[l5]) / 100;
                gfx.drawBoxText("Buy a new " + identify.itemName[l5] + " for " + i7 + "gp", byte0 + 2, byte1 + 214, 1, 0xffff00);
                int j2 = 0xffffff;
                if(super.mouseX > byte0 + 298 && super.mouseY >= byte1 + 204 && super.mouseX < byte0 + 408 && super.mouseY <= byte1 + 215)
                    j2 = 0xff0000;
                gfx.drawBoxTextRight("Click here to buy", byte0 + 405, byte1 + 214, 3, j2);
            } else
            {
                gfx.drawText("This item is not currently available to buy", byte0 + 204, byte1 + 214, 3, 0xffff00);
            }
            if(invCount(l5) > 0)
            {
                int k6 = dnh + dka[selectedShop];
                if(k6 < 10)
                    k6 = 10;
                int j7 = (k6 * identify.itemPrice[l5]) / 100;
                gfx.drawBoxTextRight("Sell your " + identify.itemName[l5] + " for " + j7 + "gp", byte0 + 405, byte1 + 239, 1, 0xffff00);
                int k2 = 0xffffff;
                if(super.mouseX > byte0 + 2 && super.mouseY >= byte1 + 229 && super.mouseX < byte0 + 112 && super.mouseY <= byte1 + 240)
                    k2 = 0xff0000;
                gfx.drawBoxText("Click here to sell", byte0 + 2, byte1 + 239, 3, k2);
                return;
            }
            gfx.drawText("You do not have any of this item to sell", byte0 + 204, byte1 + 239, 3, 0xffff00);
        }
    }

    public final f faj(int arg0, int arg1, int arg2, int arg3, int arg4)
    {
        if(dgj[arg0] == null)
        {
            dgj[arg0] = new f();
            dgj[arg0].id = arg0;
        }
        f f1 = dgj[arg0];
        boolean flag = false;
        for(int l = 0; l < dnk; l++)
        {
            if(eii[l].id != arg0)
                continue;
            flag = true;
            break;
        }

        if(flag)
        {
            f1.type = arg4;
            f1.gmm = arg3;
            int i1 = f1.miniWalk;
            if(arg1 != f1.gnb[i1] || arg2 != f1.gnc[i1])
            {
                f1.miniWalk = i1 = (i1 + 1) % 10;
                f1.gnb[i1] = arg1;
                f1.gnc[i1] = arg2;
            }
        } else
        {
            f1.id = arg0;
            f1.gmn = 0;
            f1.miniWalk = 0;
            f1.gnb[0] = f1.x = arg1;
            f1.gnc[0] = f1.y = arg2;
            f1.type = arg4;
            f1.gmm = f1.sprite = arg3;
            f1.gmk = 0;
        }
        npc[npcCount++] = f1;
        return f1;
    }

    public final void fak()
    {
        if(ebd != 0 && ddd == 0)
            ddd = 1;
        if(ddd > 0)
        {
            int l = super.mouseX - 22;
            int i1 = super.mouseY - 36;
            if(l >= 0 && i1 >= 0 && l < 468 && i1 < 262)
            {
                if(l > 216 && i1 > 30 && l < 462 && i1 < 235)
                {
                    int j1 = (l - 217) / 49 + ((i1 - 31) / 34) * 5;
                    if(j1 >= 0 && j1 < invCount)
                    {
                        boolean flag = false;
                        int k2 = 0;
                        int j3 = inv[j1];
                        for(int j4 = 0; j4 < myTradeItemCount; j4++)
                            if(myTradeItem[j4] == j3)
                                if(identify.stackable[j3] == 0)
                                {
                                    for(int l4 = 0; l4 < ddd; l4++)
                                    {
                                        if(myTradeItemValue[j4] < invValue[j1])
                                            myTradeItemValue[j4]++;
                                        flag = true;
                                    }

                                } else
                                {
                                    k2++;
                                }

                        if(invCount(j3) <= k2)
                            flag = true;
                        if(identify.ajl[j3] == 1)
                        {
                            displayMessage("This object cannot be traded with other players", 3);
                            flag = true;
                        }
                        if(!flag && myTradeItemCount < 12)
                        {
                            myTradeItem[myTradeItemCount] = j3;
                            myTradeItemValue[myTradeItemCount] = 1;
                            myTradeItemCount++;
                            flag = true;
                        }
                        if(flag)
                        {
                            super.connection.newID(144);
                            super.connection.addVar(myTradeItemCount);
                            for(int i5 = 0; i5 < myTradeItemCount; i5++)
                            {
                                super.connection.addInt(myTradeItem[i5]);
                                super.connection.addLongInt(myTradeItemValue[i5]);
                            }

                            super.connection.complete();
                            tradeAccepted = false;
                            myPlayerAcceptedTrade = false;
                        }
                    }
                }
                if(l > 8 && i1 > 30 && l < 205 && i1 < 133)
                {
                    int k1 = (l - 9) / 49 + ((i1 - 31) / 34) * 4;
                    if(k1 >= 0 && k1 < myTradeItemCount)
                    {
                        int i2 = myTradeItem[k1];
                        for(int l2 = 0; l2 < ddd; l2++)
                        {
                            if(identify.stackable[i2] == 0 && myTradeItemValue[k1] > 1)
                            {
                                myTradeItemValue[k1]--;
                                continue;
                            }
                            myTradeItemCount--;
                            ddc = 0;
                            for(int k3 = k1; k3 < myTradeItemCount; k3++)
                            {
                                myTradeItem[k3] = myTradeItem[k3 + 1];
                                myTradeItemValue[k3] = myTradeItemValue[k3 + 1];
                            }

                            break;
                        }

                        super.connection.newID(144);
                        super.connection.addVar(myTradeItemCount);
                        for(int l3 = 0; l3 < myTradeItemCount; l3++)
                        {
                            super.connection.addInt(myTradeItem[l3]);
                            super.connection.addLongInt(myTradeItemValue[l3]);
                        }

                        super.connection.complete();
                        tradeAccepted = false;
                        myPlayerAcceptedTrade = false;
                    }
                }
                if(l >= 217 && i1 >= 238 && l <= 286 && i1 <= 259)
                {
                    myPlayerAcceptedTrade = true;
                    super.connection.newID(94);
                    super.connection.complete();
                }
                if(l >= 394 && i1 >= 238 && l < 463 && i1 < 259)
                {
                    trade = false;
                    super.connection.newID(27);
                    super.connection.complete();
                }
            } else
            if(ebd != 0)
            {
                trade = false;
                super.connection.newID(27);
                super.connection.complete();
            }
            ebd = 0;
            ddd = 0;
        }
        if(!trade)
            return;
        byte byte0 = 22;
        byte byte1 = 36;
        gfx.drawBox(byte0, byte1, 468, 12, 192);
        int l1 = 0x989898;
        gfx.drawBoxAlpha(byte0, byte1 + 12, 468, 18, l1, 160);
        gfx.drawBoxAlpha(byte0, byte1 + 30, 8, 248, l1, 160);
        gfx.drawBoxAlpha(byte0 + 205, byte1 + 30, 11, 248, l1, 160);
        gfx.drawBoxAlpha(byte0 + 462, byte1 + 30, 6, 248, l1, 160);
        gfx.drawBoxAlpha(byte0 + 8, byte1 + 133, 197, 22, l1, 160);
        gfx.drawBoxAlpha(byte0 + 8, byte1 + 258, 197, 20, l1, 160);
        gfx.drawBoxAlpha(byte0 + 216, byte1 + 235, 246, 43, l1, 160);
        int j2 = 0xd0d0d0;
        gfx.drawBoxAlpha(byte0 + 8, byte1 + 30, 197, 103, j2, 160);
        gfx.drawBoxAlpha(byte0 + 8, byte1 + 155, 197, 103, j2, 160);
        gfx.drawBoxAlpha(byte0 + 216, byte1 + 30, 246, 205, j2, 160);
        for(int i3 = 0; i3 < 4; i3++)
            gfx.drawLine(byte0 + 8, byte1 + 30 + i3 * 34, 197, 0);

        for(int i4 = 0; i4 < 4; i4++)
            gfx.drawLine(byte0 + 8, byte1 + 155 + i4 * 34, 197, 0);

        for(int k4 = 0; k4 < 7; k4++)
            gfx.drawLine(byte0 + 216, byte1 + 30 + k4 * 34, 246, 0);

        for(int j5 = 0; j5 < 6; j5++)
        {
            if(j5 < 5)
                gfx.cbd(byte0 + 8 + j5 * 49, byte1 + 30, 103, 0);
            if(j5 < 5)
                gfx.cbd(byte0 + 8 + j5 * 49, byte1 + 155, 103, 0);
            gfx.cbd(byte0 + 216 + j5 * 49, byte1 + 30, 205, 0);
        }

        gfx.drawBoxText("Trading with: " + ddg, byte0 + 1, byte1 + 10, 1, 0xffffff);
        gfx.drawBoxText("Your Offer", byte0 + 9, byte1 + 27, 4, 0xffffff);
        gfx.drawBoxText("Opponent's Offer", byte0 + 9, byte1 + 152, 4, 0xffffff);
        gfx.drawBoxText("Your Inventory", byte0 + 216, byte1 + 27, 4, 0xffffff);
        if(!myPlayerAcceptedTrade)
            gfx.drawPicture(byte0 + 217, byte1 + 238, del + 25);
        gfx.drawPicture(byte0 + 394, byte1 + 238, del + 26);
        if(tradeAccepted)
        {
            gfx.drawText("Other player", byte0 + 341, byte1 + 246, 1, 0xffffff);
            gfx.drawText("has accepted", byte0 + 341, byte1 + 256, 1, 0xffffff);
        }
        if(myPlayerAcceptedTrade)
        {
            gfx.drawText("Waiting for", byte0 + 217 + 35, byte1 + 246, 1, 0xffffff);
            gfx.drawText("other player", byte0 + 217 + 35, byte1 + 256, 1, 0xffffff);
        }
        for(int k5 = 0; k5 < invCount; k5++)
        {
            int l5 = 217 + byte0 + (k5 % 5) * 49;
            int j6 = 31 + byte1 + (k5 / 5) * 34;
            gfx.cdd(l5, j6, 48, 32, den + identify.ajf[inv[k5]], identify.ajk[inv[k5]], 0, 0, false);
            if(identify.stackable[inv[k5]] == 0)
                gfx.drawBoxText(String.valueOf(invValue[k5]), l5 + 1, j6 + 10, 1, 0xffff00);
        }

        for(int i6 = 0; i6 < myTradeItemCount; i6++)
        {
            int k6 = 9 + byte0 + (i6 % 4) * 49;
            int i7 = 31 + byte1 + (i6 / 4) * 34;
            gfx.cdd(k6, i7, 48, 32, den + identify.ajf[myTradeItem[i6]], identify.ajk[myTradeItem[i6]], 0, 0, false);
            if(identify.stackable[myTradeItem[i6]] == 0)
                gfx.drawBoxText(String.valueOf(myTradeItemValue[i6]), k6 + 1, i7 + 10, 1, 0xffff00);
            if(super.mouseX > k6 && super.mouseX < k6 + 48 && super.mouseY > i7 && super.mouseY < i7 + 32)
                gfx.drawBoxText(identify.itemName[myTradeItem[i6]] + ": @whi@" + identify.itemDesc[myTradeItem[i6]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }

        for(int l6 = 0; l6 < ecl; l6++)
        {
            int j7 = 9 + byte0 + (l6 % 4) * 49;
            int k7 = 156 + byte1 + (l6 / 4) * 34;
            gfx.cdd(j7, k7, 48, 32, den + identify.ajf[ecm[l6]], identify.ajk[ecm[l6]], 0, 0, false);
            if(identify.stackable[ecm[l6]] == 0)
                gfx.drawBoxText(String.valueOf(ecn[l6]), j7 + 1, k7 + 10, 1, 0xffff00);
            if(super.mouseX > j7 && super.mouseX < j7 + 48 && super.mouseY > k7 && super.mouseY < k7 + 32)
                gfx.drawBoxText(identify.itemName[ecm[l6]] + ": @whi@" + identify.itemDesc[ecm[l6]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }

    }

	public void doMenu(int x, int y, int id, int type)
	{
		menuX[menuCount++] = x;
		menuY[menuCount] = y;
		menuID[menuCount] = id;
		menuType[menuCount] = type;
		handleMenu(menuCount);
	}

	public void doMenu(int x, int y, int id, int var, int type)
	{
		menuX[menuCount++] = x;
		menuY[menuCount] = y;
		menuID[menuCount] = id;
		menuVar[menuCount] = var;
		menuType[menuCount] = type;
		handleMenu(menuCount);
	}

	public void doMenu(int x, int y, int id, int var, int var2, int type)
	{
		menuX[menuCount++] = x;
		menuY[menuCount] = y;
		menuID[menuCount] = id;
		menuVar[menuCount] = var;
		menuVar2[menuCount] = var2;
		menuType[menuCount] = type;
		handleMenu(menuCount);
	}

    public final void handleMenu(int l)
    {
        int i1 = menuX[l];
        int j1 = menuY[l];
        int k1 = menuID[l];
        int l1 = menuVar[l];
        int i2 = menuVar2[l];
        int j2 = menuType[l];
        if(j2 == 200)
        {
            fdn(smallX, smallY, i1, j1, true);
            super.connection.newID(18);
            super.connection.addInt(i1 + bigX);
            super.connection.addInt(j1 + bigY);
            super.connection.addInt(k1);
            super.connection.addInt(l1);
            super.connection.complete();
            selectedSpell = -1;
        }
        if(j2 == 210)
        {
            fdn(smallX, smallY, i1, j1, true);
            super.connection.newID(255);
            super.connection.addInt(i1 + bigX);
            super.connection.addInt(j1 + bigY);
            super.connection.addInt(k1);
            super.connection.addInt(l1);
            super.connection.complete();
            selectedItem = -1;
        }
        if(j2 == 220)
        {
            fdn(smallX, smallY, i1, j1, true);
            super.connection.newID(253);
            super.connection.addInt(i1 + bigX);
            super.connection.addInt(j1 + bigY);
            super.connection.addInt(k1);
            super.connection.addInt(l1);
            super.connection.complete();
        }
        if(j2 == 3200)
		{
			System.out.println("Item: " + k1);
            displayMessage(identify.itemDesc[k1], 3);
		}
        if(j2 == 300)
        {
            fcd(i1, j1, k1);
            super.connection.newID(76);
            super.connection.addInt(i1 + bigX);
            super.connection.addInt(j1 + bigY);
            super.connection.addVar(k1);
            super.connection.addInt(l1);
            super.connection.complete();
            selectedSpell = -1;
        }
        if(j2 == 310)
        {
            fcd(i1, j1, k1);
            super.connection.newID(71);
            super.connection.addInt(i1 + bigX);
            super.connection.addInt(j1 + bigY);
            super.connection.addVar(k1);
            super.connection.addInt(l1);
            super.connection.complete();
            selectedItem = -1;
        }
        if(j2 == 320)
        {
            fcd(i1, j1, k1);
            super.connection.newID(100);
            super.connection.addInt(i1 + bigX);
            super.connection.addInt(j1 + bigY);
            super.connection.addVar(k1);
            super.connection.complete();
        }
        if(j2 == 2300)
        {
            fcd(i1, j1, k1);
            super.connection.newID(121);
            super.connection.addInt(i1 + bigX);
            super.connection.addInt(j1 + bigY);
            super.connection.addVar(k1);
            super.connection.complete();
        }
        if(j2 == 3300)
		{
			System.out.println("Door: " + k1);
            displayMessage(identify.doorDesc[k1], 3);
		}
        if(j2 == 400)
        {
            fba(i1, j1, k1, l1);
            super.connection.newID(237);
            super.connection.addInt(i1 + bigX);
            super.connection.addInt(j1 + bigY);
            super.connection.addInt(i2);
            super.connection.complete();
            selectedSpell = -1;
        }
        if(j2 == 410)
        {
            fba(i1, j1, k1, l1);
            super.connection.newID(127);
            super.connection.addInt(i1 + bigX);
            super.connection.addInt(j1 + bigY);
            super.connection.addInt(i2);
            super.connection.complete();
            selectedItem = -1;
        }
        if(j2 == 420)
        {
            fba(i1, j1, k1, l1);
            super.connection.newID(38);
            super.connection.addInt(i1 + bigX);
            super.connection.addInt(j1 + bigY);
            super.connection.complete();
        }
        if(j2 == 2400)
        {
            fba(i1, j1, k1, l1);
            super.connection.newID(172);
            super.connection.addInt(i1 + bigX);
            super.connection.addInt(j1 + bigY);
            super.connection.complete();
        }
        if(j2 == 3400)
		{
			System.out.println("Object: " + k1);
            displayMessage(identify.objectDesc[k1], 3);
		}
        if(j2 == 600)
        {
            super.connection.newID(166);
            super.connection.addInt(k1);
            super.connection.addInt(l1);
            super.connection.complete();
            selectedSpell = -1;
        }
        if(j2 == 610)
        {
            super.connection.newID(235);
            super.connection.addInt(k1);
            super.connection.addInt(l1);
            super.connection.complete();
            selectedItem = -1;
        }
        if(j2 == 620)
        {
            super.connection.newID(40);
            super.connection.addInt(k1);
            super.connection.complete();
        }
        if(j2 == 630)
        {
            super.connection.newID(199);
            super.connection.addInt(k1);
            super.connection.complete();
        }
        if(j2 == 640)
        {
            super.connection.newID(24);
            super.connection.addInt(k1);
            super.connection.complete();
        }
        if(j2 == 650)
        {
            selectedItem = k1;
            selectedMenu = 0;
            selectedItemName = identify.itemName[inv[selectedItem]];
        }
        if(j2 == 660)
        {
            super.connection.newID(123);
            super.connection.addInt(k1);
            super.connection.complete();
            selectedItem = -1;
            selectedMenu = 0;
            displayMessage("Dropping " + identify.itemName[inv[k1]], 4);
        }
        if(j2 == 3600)
		{
			System.out.println("Item: " + k1);
            displayMessage(identify.itemDesc[k1], 3);
		}
        if(j2 == 700)
        {
            int k2 = (i1 - 64) / magicLoc;
            int k4 = (j1 - 64) / magicLoc;
            ena(smallX, smallY, k2, k4, true);
            super.connection.newID(10);
            super.connection.addInt(k1);
            super.connection.addInt(l1);
            super.connection.complete();
            selectedSpell = -1;
        }
        if(j2 == 710)
        {
            int l2 = (i1 - 64) / magicLoc;
            int l4 = (j1 - 64) / magicLoc;
            ena(smallX, smallY, l2, l4, true);
            super.connection.newID(143);
            super.connection.addInt(k1);
            super.connection.addInt(l1);
            super.connection.complete();
            selectedItem = -1;
        }
        if(j2 == 720)
        {
            int i3 = (i1 - 64) / magicLoc;
            int i5 = (j1 - 64) / magicLoc;
            ena(smallX, smallY, i3, i5, true);
            super.connection.newID(159);
            super.connection.addInt(k1);
            super.connection.complete();
        }
        if(j2 == 725)
        {
            int j3 = (i1 - 64) / magicLoc;
            int j5 = (j1 - 64) / magicLoc;
            ena(smallX, smallY, j3, j5, true);
            super.connection.newID(89);
            super.connection.addInt(k1);
            super.connection.complete();
        }
        if(j2 == 715 || j2 == 2715)
        {
            int k3 = (i1 - 64) / magicLoc;
            int k5 = (j1 - 64) / magicLoc;
            ena(smallX, smallY, k3, k5, true);
            super.connection.newID(118);
            super.connection.addInt(k1);
            super.connection.complete();
        }
        if(j2 == 3700)
		{
			System.out.println("NPC: " + k1);
            displayMessage(identify.npcDesc[k1], 3);
		}
        if(j2 == 800)
        {
            int l3 = (i1 - 64) / magicLoc;
            int l5 = (j1 - 64) / magicLoc;
            ena(smallX, smallY, l3, l5, true);
            super.connection.newID(56);
            super.connection.addInt(k1);
            super.connection.addInt(l1);
            super.connection.complete();
            selectedSpell = -1;
        }
        if(j2 == 810)
        {
            int i4 = (i1 - 64) / magicLoc;
            int i6 = (j1 - 64) / magicLoc;
            ena(smallX, smallY, i4, i6, true);
            super.connection.newID(11);
            super.connection.addInt(k1);
            super.connection.addInt(l1);
            super.connection.complete();
            selectedItem = -1;
        }
        if(j2 == 805 || j2 == 2805)
        {
            int j4 = (i1 - 64) / magicLoc;
            int j6 = (j1 - 64) / magicLoc;
            ena(smallX, smallY, j4, j6, true);
            super.connection.newID(124);
            super.connection.addInt(k1);
            super.connection.complete();
        }
        if(j2 == 2806)
        {
            super.connection.newID(217);
            super.connection.addInt(k1);
            super.connection.complete();
        }
        if(j2 == 2810)
        {
            super.connection.newID(62);
            super.connection.addInt(k1);
            super.connection.complete();
        }
        if(j2 == 2820)
        {
            super.connection.newID(91);
            super.connection.addInt(k1);
            super.connection.complete();
        }
        if(j2 == 900)
        {
            ena(smallX, smallY, i1, j1, true);
            super.connection.newID(201);
            super.connection.addInt(i1 + bigX);
            super.connection.addInt(j1 + bigY);
            super.connection.addInt(k1);
            super.connection.complete();
            selectedSpell = -1;
        }
        if(j2 == 920)
        {
			if(debug)
				System.out.println("walk(" + (i1 + bigX) + "," + (j1 + bigY) + ");");
			if(recordingSteps)
			{
				recordingStepX[recordingStepLength] = i1 + bigX;
				recordingStepY[recordingStepLength] = j1 + bigY;
				recordingStepLength++;
			}
			ena(smallX, smallY, i1, j1, false);
            if(eak == -24)
                eak = 24;
        }
        if(j2 == 1000)
        {
            super.connection.newID(44);
            super.connection.addInt(k1);
            super.connection.complete();
            selectedSpell = -1;
        }
        if(j2 == 4000)
        {
            selectedItem = -1;
            selectedSpell = -1;
        }
    }

    final void fam(int l, int i1, int j1, int k1, int l1, int i2, int j2)
    {
        int k2 = ekn[l1];
        int l2 = dna[l1];
        if(k2 == 0)
        {
            int i3 = 255 + l2 * 5 * 256;
            gfx.cal(l + j1 / 2, i1 + k1 / 2, 20 + l2 * 2, i3, 255 - l2 * 5);
        }
        if(k2 == 1)
        {
            int j3 = 0xff0000 + l2 * 5 * 256;
            gfx.cal(l + j1 / 2, i1 + k1 / 2, 10 + l2, j3, 255 - l2 * 5);
        }
    }

    public final void fan()
    {
        if(edh > 1)
            edh--;
        acd();
        if(dhf > 0)
            dhf--;
        if(myPlayer.sprite == 8 || myPlayer.sprite == 9)
            eda = 500;
        if(eda > 0)
            eda--;
        if(efc)
        {
            fcn();
            return;
        }
        for(int l = 0; l < playerCount; l++)
        {
            f f1 = player[l];
            int j1 = (f1.miniWalk + 1) % 10;
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
                if(f1.gnb[k3] - f1.x > magicLoc * 3 || f1.gnc[k3] - f1.y > magicLoc * 3 || f1.gnb[k3] - f1.x < -magicLoc * 3 || f1.gnc[k3] - f1.y < -magicLoc * 3 || i5 > 8)
                {
                    f1.x = f1.gnb[k3];
                    f1.y = f1.gnc[k3];
                } else
                {
                    if(f1.x < f1.gnb[k3])
                    {
                        f1.x += i6;
                        f1.gmk++;
                        l1 = 2;
                    } else
                    if(f1.x > f1.gnb[k3])
                    {
                        f1.x -= i6;
                        f1.gmk++;
                        l1 = 6;
                    }
                    if(f1.x - f1.gnb[k3] < i6 && f1.x - f1.gnb[k3] > -i6)
                        f1.x = f1.gnb[k3];
                    if(f1.y < f1.gnc[k3])
                    {
                        f1.y += i6;
                        f1.gmk++;
                        if(l1 == -1)
                            l1 = 4;
                        else
                        if(l1 == 2)
                            l1 = 3;
                        else
                            l1 = 5;
                    } else
                    if(f1.y > f1.gnc[k3])
                    {
                        f1.y -= i6;
                        f1.gmk++;
                        if(l1 == -1)
                            l1 = 0;
                        else
                        if(l1 == 2)
                            l1 = 1;
                        else
                            l1 = 7;
                    }
                    if(f1.y - f1.gnc[k3] < i6 && f1.y - f1.gnc[k3] > -i6)
                        f1.y = f1.gnc[k3];
                }
                if(l1 != -1)
                    f1.sprite = l1;
                if(f1.x == f1.gnb[k3] && f1.y == f1.gnc[k3])
                    f1.gmn = (k3 + 1) % 10;
            } else
            {
                f1.sprite = f1.gmm;
            }
            if(f1.lastSaidTimeout > 0)
                f1.lastSaidTimeout--;
            if(f1.gnh > 0)
                f1.gnh--;
            if(f1.gnl > 0)
                f1.gnl--;
            if(dfl > 0)
            {
                dfl--;
                if(dfl == 0)
                    displayMessage("You have been granted another life. Be more careful this time!", 3);
                if(dfl == 0)
                    displayMessage("You retain your skills. Your objects land where you died", 3);
            }
        }

        for(int i1 = 0; i1 < npcCount; i1++)
        {
            f f2 = npc[i1];
            int i2 = (f2.miniWalk + 1) % 10;
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
                if(f2.gnb[j5] - f2.x > magicLoc * 3 || f2.gnc[j5] - f2.y > magicLoc * 3 || f2.gnb[j5] - f2.x < -magicLoc * 3 || f2.gnc[j5] - f2.y < -magicLoc * 3 || j6 > 8)
                {
                    f2.x = f2.gnb[j5];
                    f2.y = f2.gnc[j5];
                } else
                {
                    if(f2.x < f2.gnb[j5])
                    {
                        f2.x += k6;
                        f2.gmk++;
                        l3 = 2;
                    } else
                    if(f2.x > f2.gnb[j5])
                    {
                        f2.x -= k6;
                        f2.gmk++;
                        l3 = 6;
                    }
                    if(f2.x - f2.gnb[j5] < k6 && f2.x - f2.gnb[j5] > -k6)
                        f2.x = f2.gnb[j5];
                    if(f2.y < f2.gnc[j5])
                    {
                        f2.y += k6;
                        f2.gmk++;
                        if(l3 == -1)
                            l3 = 4;
                        else
                        if(l3 == 2)
                            l3 = 3;
                        else
                            l3 = 5;
                    } else
                    if(f2.y > f2.gnc[j5])
                    {
                        f2.y -= k6;
                        f2.gmk++;
                        if(l3 == -1)
                            l3 = 0;
                        else
                        if(l3 == 2)
                            l3 = 1;
                        else
                            l3 = 7;
                    }
                    if(f2.y - f2.gnc[j5] < k6 && f2.y - f2.gnc[j5] > -k6)
                        f2.y = f2.gnc[j5];
                }
                if(l3 != -1)
                    f2.sprite = l3;
                if(f2.x == f2.gnb[j5] && f2.y == f2.gnc[j5])
                    f2.gmn = (j5 + 1) % 10;
            } else
            {
                f2.sprite = f2.gmm;
                if(f2.type == 43)
                    f2.gmk++;
            }
            if(f2.lastSaidTimeout > 0)
                f2.lastSaidTimeout--;
            if(f2.gnh > 0)
                f2.gnh--;
            if(f2.gnl > 0)
                f2.gnl--;
        }

        if(selectedMenu != 2)
        {
            if(j.bnn > 0)
                ekh++;
            if(j.caa > 0)
                ekh = 0;
            j.bnn = 0;
            j.caa = 0;
        }
        for(int k1 = 0; k1 < playerCount; k1++)
        {
            f f3 = player[k1];
            if(f3.hag > 0)
                f3.hag--;
        }

        if(dhg)
        {
            if(dlg - myPlayer.x < -500 || dlg - myPlayer.x > 500 || dlh - myPlayer.y < -500 || dlh - myPlayer.y > 500)
            {
                dlg = myPlayer.x;
                dlh = myPlayer.y;
            }
        } else
        {
            if(dlg - myPlayer.x < -500 || dlg - myPlayer.x > 500 || dlh - myPlayer.y < -500 || dlh - myPlayer.y > 500)
            {
                dlg = myPlayer.x;
                dlh = myPlayer.y;
            }
            if(dlg != myPlayer.x)
                dlg += (myPlayer.x - dlg) / (16 + (zoom - 500) / 15);
            if(dlh != myPlayer.y)
                dlh += (myPlayer.y - dlh) / (16 + (zoom - 500) / 15);
            if(efb)
            {
                int j2 = ema * 32;
                int i4 = j2 - dke;
                byte byte0 = 1;
                if(i4 != 0)
                {
                    emb++;
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
                    dke += ((emb * i4 + 255) / 256) * byte0;
                    dke &= 0xff;
                } else
                {
                    emb = 0;
                }
            }
        }
        if(ekh > 20)
        {
            dle = false;
            ekh = 0;
        }
        if(sleeping)
        {
            if(super.fkm.length() > 0)
                if(super.fkm.equalsIgnoreCase("::lostcon") && !dhh)
                    super.connection.baj();
                else
                if(super.fkm.equalsIgnoreCase("::closecon") && !dhh)
                {
                    aca();
                } else
                {
                    super.connection.newID(142);
                    super.connection.hdk(super.fkm);
                    if(!dle)
                    {
                        super.connection.addVar(0);
                        dle = true;
                    }
                    super.connection.complete();
                    super.fkl = "";
                    super.fkm = "";
                    eke = "Please wait...";
                }
            if(super.fkh == 1 && super.mouseY > 275 && super.mouseY < 310 && super.mouseX > 56 && super.mouseX < 456)
            {
                super.connection.newID(142);
                super.connection.hdk("-null-");
                if(!dle)
                {
                    super.connection.addVar(0);
                    dle = true;
                }
                super.connection.complete();
                super.fkl = "";
                super.fkm = "";
                eke = "Please wait...";
            }
            super.fkh = 0;
            return;
        }
        if(super.mouseY > height - 4)
        {
            if(super.mouseX > 15 && super.mouseX < 96 && super.fkh == 1)
                ell = 0;
            if(super.mouseX > 110 && super.mouseX < 194 && super.fkh == 1)
            {
                ell = 1;
                elg.gbc[elh] = 0xf423f;
            }
            if(super.mouseX > 215 && super.mouseX < 295 && super.fkh == 1)
            {
                ell = 2;
                elg.gbc[elj] = 0xf423f;
            }
            if(super.mouseX > 315 && super.mouseX < 395 && super.fkh == 1)
            {
                ell = 3;
                elg.gbc[elk] = 0xf423f;
            }
            if(super.mouseX > 417 && super.mouseX < 497 && super.fkh == 1)
            {
                egc = 1;
                egd = 0;
                super.fkl = "";
                super.fkm = "";
            }
            super.fkh = 0;
            super.fkg = 0;
        }
        elg.gea(super.mouseX, super.mouseY, super.fkh, super.fkg);
        if(ell > 0 && super.mouseX >= 494 && super.mouseY >= height - 66)
            super.fkh = 0;
        if(elg.buttonHandleDown(eli))
        {
            String s1 = elg.ggd(eli);
            elg.ggc(eli, "");
            if(s1.startsWith("::"))
            {
                if(s1.equalsIgnoreCase("::closecon") && !dhh)
                    super.connection.baj();
                else
                if(s1.equalsIgnoreCase("::logout") && !dhh)
                    aca();
                else
                if(s1.equalsIgnoreCase("::lostcon") && !dhh)
                    acb();
                else
                    acn(s1.substring(2));
            } else
            {
				if (!s1.startsWith("##"))
				{
					int j4 = v.cek(s1);
					acm(v.ceg, j4);
					s1 = v.cej(v.ceg, 0, j4);
					s1 = u.fgd(s1);
					myPlayer.lastSaidTimeout = 150;
					myPlayer.lastSaid = s1;
					displayMessage(myPlayer.name + ": " + s1, 2);
				} else {
					runCommand(s1);
				}
            }
        }
        if(ell == 0)
        {
            for(int k2 = 0; k2 < 5; k2++)
                if(def[k2] > 0)
                    def[k2]--;

        }
        if(dfl != 0)
            super.fkh = 0;
        if(trade || duel)
        {
            if(super.fkg != 0)
                ddc++;
            else
                ddc = 0;
            if(ddc > 600)
                ddd += 5000;
            else
            if(ddc > 450)
                ddd += 500;
            else
            if(ddc > 300)
                ddd += 50;
            else
            if(ddc > 150)
                ddd += 5;
            else
            if(ddc > 50)
                ddd++;
            else
            if(ddc > 20 && (ddc & 5) == 0)
                ddd++;
        } else
        {
            ddc = 0;
            ddd = 0;
        }
        if(super.fkh == 1)
            ebd = 1;
        else
        if(super.fkh == 2)
            ebd = 2;
        efn.bhg(super.mouseX, super.mouseY);
        super.fkh = 0;
        if(efb)
        {
            if(emb == 0 || dhg)
            {
                if(super.fjl)
                {
                    ema = ema + 1 & 7;
                    super.fjl = false;
                    if(!djc)
                    {
                        if((ema & 1) == 0)
                            ema = ema + 1 & 7;
                        for(int l2 = 0; l2 < 8; l2++)
                        {
                            if(fab(ema))
                                break;
                            ema = ema + 1 & 7;
                        }

                    }
                }
                if(super.fjm)
                {
                    ema = ema + 7 & 7;
                    super.fjm = false;
                    if(!djc)
                    {
                        if((ema & 1) == 0)
                            ema = ema + 7 & 7;
                        for(int i3 = 0; i3 < 8; i3++)
                        {
                            if(fab(ema))
                                break;
                            ema = ema + 7 & 7;
                        }

                    }
                }
            }
        } else
        if(super.fjl)
            dke = dke + 2 & 0xff;
        else
        if(super.fjm)
            dke = dke - 2 & 0xff;
        if(zoomOut)
            zoom += 5;
        if(zoomIn)
            zoom -= 5;
		if(zRotUp)
			zRot -= 4;
		if(zRotDown)
			zRot += 4;
        if(eak > 0)
            eak--;
        else
        if(eak < 0)
            eak++;
        efn.bji(17);
        eib++;
        if(eib > 5)
        {
            eib = 0;
            edi = (edi + 1) % 3;
            edj = (edj + 1) % 4;
            edk = (edk + 1) % 5;
        }
        for(int j3 = 0; j3 < objectCount; j3++)
        {
            int k4 = objectX[j3];
            int k5 = objectY[j3];
            if(k4 >= 0 && k5 >= 0 && k4 < 96 && k5 < 96 && objectType[j3] == 74)
                ddf[j3].cmi(1, 0, 0);
        }

        for(int l4 = 0; l4 < ean; l4++)
        {
            dna[l4]++;
            if(dna[l4] > 50)
            {
                ean--;
                for(int l5 = l4; l5 < ean; l5++)
                {
                    dnc[l5] = dnc[l5 + 1];
                    dgb[l5] = dgb[l5 + 1];
                    dna[l5] = dna[l5 + 1];
                    ekn[l5] = ekn[l5 + 1];
                }

            }
        }

    }

    public final void fba(int arg0, int arg1, int arg2, int arg3)
    {
        int l;
        int i1;
        if(arg2 == 0 || arg2 == 4)
        {
            l = identify.all[arg3];
            i1 = identify.alm[arg3];
        } else
        {
            i1 = identify.all[arg3];
            l = identify.alm[arg3];
        }
        if(identify.aln[arg3] == 2 || identify.aln[arg3] == 3)
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
            fde(smallX, smallY, arg0, arg1, (arg0 + l) - 1, (arg1 + i1) - 1, false, true);
            return;
        } else
        {
            fde(smallX, smallY, arg0, arg1, (arg0 + l) - 1, (arg1 + i1) - 1, true, true);
            return;
        }
    }

    public final void fbb()
    {
        identify.anj("torcha2");
        identify.anj("torcha3");
        identify.anj("torcha4");
        identify.anj("skulltorcha2");
        identify.anj("skulltorcha3");
        identify.anj("skulltorcha4");
        identify.anj("firea2");
        identify.anj("firea3");
        identify.anj("fireplacea2");
        identify.anj("fireplacea3");
        identify.anj("firespell2");
        identify.anj("firespell3");
        identify.anj("lightning2");
        identify.anj("lightning3");
        identify.anj("clawspell2");
        identify.anj("clawspell3");
        identify.anj("clawspell4");
        identify.anj("clawspell5");
        identify.anj("spellcharge2");
        identify.anj("spellcharge3");
        if(!application())
        {
            byte abyte0[] = enb("models" + w.cfc + ".jag", "3d models", 60);
            if(abyte0 == null)
            {
                ein = true;
                return;
            }
            for(int i1 = 0; i1 < identify.aim; i1++)
            {
                int j1 = t.fne(identify.ahl[i1] + ".ob3", abyte0);
                if(j1 != 0)
                    dkj[i1] = new i(abyte0, j1, true);
                else
                    dkj[i1] = new i(1, 1);
                if(identify.ahl[i1].equals("giantcrystal"))
                    dkj[i1].chj = true;
            }

            return;
        }
        flj(70, "Loading 3d models");
        for(int l = 0; l < identify.aim; l++)
        {
            dkj[l] = new i("../gamedata/models/" + identify.ahl[l] + ".ob2");
            if(identify.ahl[l].equals("giantcrystal"))
                dkj[l].chj = true;
        }

    }

    public final void fbc(boolean arg0)
    {
        int l = ((j) (gfx)).blg - 199;
        int i1 = 36;
        gfx.drawPicture(l - 49, 3, del + 3);
        char c1 = '\304';
        char c2 = '\u0113';
        int k1;
        int j1 = k1 = j.createRGB(160, 160, 160);
        if(dii == 0)
            j1 = j.createRGB(220, 220, 220);
        else
            k1 = j.createRGB(220, 220, 220);
        gfx.drawBoxAlpha(l, i1, c1 / 2, 24, j1, 128);
        gfx.drawBoxAlpha(l + c1 / 2, i1, c1 / 2, 24, k1, 128);
        gfx.drawBoxAlpha(l, i1 + 24, c1, c2 - 24, j.createRGB(220, 220, 220), 128);
        gfx.drawLine(l, i1 + 24, c1, 0);
        gfx.cbd(l + c1 / 2, i1, 24, 0);
        gfx.drawText("Stats", l + c1 / 4, i1 + 16, 4, 0);
        gfx.drawText("Quests", l + c1 / 4 + c1 / 2, i1 + 16, 4, 0);
        if(dii == 0)
        {
            int l1 = 72;
            int j2 = -1;
            gfx.drawBoxText("Skills", l + 5, l1, 3, 0xffff00);
            l1 += 13;
            for(int k2 = 0; k2 < 9; k2++)
            {
                int l2 = 0xffffff;
                if(super.mouseX > l + 3 && super.mouseY >= l1 - 11 && super.mouseY < l1 + 2 && super.mouseX < l + 90)
                {
                    l2 = 0xff0000;
                    j2 = k2;
                }
                gfx.drawBoxText(ech[k2] + ":@yel@" + currentStat[k2] + "/" + playerStat[k2], l + 5, l1, 1, l2);
                l2 = 0xffffff;
                if(super.mouseX >= l + 90 && super.mouseY >= l1 - 13 - 11 && super.mouseY < (l1 - 13) + 2 && super.mouseX < l + 196)
                {
                    l2 = 0xff0000;
                    j2 = k2 + 9;
                }
                gfx.drawBoxText(ech[k2 + 9] + ":@yel@" + currentStat[k2 + 9] + "/" + playerStat[k2 + 9], (l + c1 / 2) - 5, l1 - 13, 1, l2);
                l1 += 13;
            }

            gfx.drawBoxText("Quest Points:@yel@" + questPoints, (l + c1 / 2) - 5, l1 - 13, 1, 0xffffff);
            l1 += 12;
            gfx.drawBoxText("Fatigue: @yel@" + (fatigue * 100) / 750 + "%", l + 5, l1 - 13, 1, 0xffffff);
            l1 += 8;
            gfx.drawBoxText("Equipment Status", l + 5, l1, 3, 0xffff00);
            l1 += 12;
            for(int i3 = 0; i3 < 3; i3++)
            {
                gfx.drawBoxText(emd[i3] + ":@yel@" + ebb[i3], l + 5, l1, 1, 0xffffff);
                if(i3 < 2)
                    gfx.drawBoxText(emd[i3 + 3] + ":@yel@" + ebb[i3 + 3], l + c1 / 2 + 25, l1, 1, 0xffffff);
                l1 += 13;
            }

            l1 += 6;
            gfx.drawLine(l, l1 - 15, c1, 0);
            if(j2 != -1)
            {
                gfx.drawBoxText(ebi[j2] + " skill", l + 5, l1, 1, 0xffff00);
                l1 += 12;
                int j3 = dik[0];
                for(int l3 = 0; l3 < 98; l3++)
                    if(statExperience[j2] >= dik[l3])
                        j3 = dik[l3 + 1];

                gfx.drawBoxText("Total xp: " + statExperience[j2] / 4, l + 5, l1, 1, 0xffffff);
                l1 += 12;
                gfx.drawBoxText("Next level at: " + j3 / 4, l + 5, l1, 1, 0xffffff);
            } else
            {
                gfx.drawBoxText("Overall levels", l + 5, l1, 1, 0xffff00);
                l1 += 12;
                int k3 = 0;
                for(int i4 = 0; i4 < 18; i4++)
                    k3 += playerStat[i4];

                gfx.drawBoxText("Skill total: " + k3, l + 5, l1, 1, 0xffffff);
                l1 += 12;
                gfx.drawBoxText("Combat level: " + myPlayer.level, l + 5, l1, 1, 0xffffff);
                l1 += 12;
            }
        }
        if(dii == 1)
        {
            dig.gfm(dih);
            dig.gga(dih, 0, "@whi@Quest-list (green=completed)");
            for(int i2 = 0; i2 < 50; i2++)
                dig.gga(dih, i2 + 1, (dkk[i2] ? "@gre@" : "@red@") + ecd[i2]);

            dig.ged();
        }
        if(!arg0)
            return;
        l = super.mouseX - (((j) (gfx)).blg - 199);
        i1 = super.mouseY - 36;
        if(l >= 0 && i1 >= 0 && l < c1 && i1 < c2)
        {
            if(dii == 1)
                dig.gea(l + (((j) (gfx)).blg - 199), i1 + 36, super.fkh, super.fkg);
            if(i1 <= 24 && ebd == 1)
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

    public final void fbd()
    {
        dhi = new h(gfx, 100);
        dhi.drawMenuText(256, 10, "Please design Your Character", 4, true);
        int l = 140;
        int i1 = 34;
        l += 116;
        i1 -= 10;
        dhi.drawMenuText(l - 55, i1 + 110, "Front", 3, true);
        dhi.drawMenuText(l, i1 + 110, "Side", 3, true);
        dhi.drawMenuText(l + 55, i1 + 110, "Back", 3, true);
        byte byte0 = 54;
        i1 += 145;
        dhi.gff(l - byte0, i1, 53, 41);
        dhi.drawMenuText(l - byte0, i1 - 8, "Head", 1, true);
        dhi.drawMenuText(l - byte0, i1 + 8, "Type", 1, true);
        dhi.gfg(l - byte0 - 40, i1, h.gdi + 7);
        eec = dhi.createButtonHandle(l - byte0 - 40, i1, 20, 20);
        dhi.gfg((l - byte0) + 40, i1, h.gdi + 6);
        eed = dhi.createButtonHandle((l - byte0) + 40, i1, 20, 20);
        dhi.gff(l + byte0, i1, 53, 41);
        dhi.drawMenuText(l + byte0, i1 - 8, "Hair", 1, true);
        dhi.drawMenuText(l + byte0, i1 + 8, "Color", 1, true);
        dhi.gfg((l + byte0) - 40, i1, h.gdi + 7);
        eee = dhi.createButtonHandle((l + byte0) - 40, i1, 20, 20);
        dhi.gfg(l + byte0 + 40, i1, h.gdi + 6);
        eef = dhi.createButtonHandle(l + byte0 + 40, i1, 20, 20);
        i1 += 50;
        dhi.gff(l - byte0, i1, 53, 41);
        dhi.drawMenuText(l - byte0, i1, "Gender", 1, true);
        dhi.gfg(l - byte0 - 40, i1, h.gdi + 7);
        eeg = dhi.createButtonHandle(l - byte0 - 40, i1, 20, 20);
        dhi.gfg((l - byte0) + 40, i1, h.gdi + 6);
        eeh = dhi.createButtonHandle((l - byte0) + 40, i1, 20, 20);
        dhi.gff(l + byte0, i1, 53, 41);
        dhi.drawMenuText(l + byte0, i1 - 8, "Top", 1, true);
        dhi.drawMenuText(l + byte0, i1 + 8, "Color", 1, true);
        dhi.gfg((l + byte0) - 40, i1, h.gdi + 7);
        eei = dhi.createButtonHandle((l + byte0) - 40, i1, 20, 20);
        dhi.gfg(l + byte0 + 40, i1, h.gdi + 6);
        eej = dhi.createButtonHandle(l + byte0 + 40, i1, 20, 20);
        i1 += 50;
        dhi.gff(l - byte0, i1, 53, 41);
        dhi.drawMenuText(l - byte0, i1 - 8, "Skin", 1, true);
        dhi.drawMenuText(l - byte0, i1 + 8, "Color", 1, true);
        dhi.gfg(l - byte0 - 40, i1, h.gdi + 7);
        eek = dhi.createButtonHandle(l - byte0 - 40, i1, 20, 20);
        dhi.gfg((l - byte0) + 40, i1, h.gdi + 6);
        eel = dhi.createButtonHandle((l - byte0) + 40, i1, 20, 20);
        dhi.gff(l + byte0, i1, 53, 41);
        dhi.drawMenuText(l + byte0, i1 - 8, "Bottom", 1, true);
        dhi.drawMenuText(l + byte0, i1 + 8, "Color", 1, true);
        dhi.gfg((l + byte0) - 40, i1, h.gdi + 7);
        eem = dhi.createButtonHandle((l + byte0) - 40, i1, 20, 20);
        dhi.gfg(l + byte0 + 40, i1, h.gdi + 6);
        een = dhi.createButtonHandle(l + byte0 + 40, i1, 20, 20);
        i1 += 82;
        i1 -= 35;
        dhi.drawMenuButton(l, i1, 200, 30);
        dhi.drawMenuText(l, i1, "Accept", 4, false);
        efa = dhi.createButtonHandle(l, i1, 200, 30);
    }

    public final void fbe()
    {
        if(super.fkm.length() > 0)
        {
            String s1 = super.fkm.trim();
            super.fkl = "";
            super.fkm = "";
            if(s1.length() > 0)
            {
                long l1 = t.fnc(s1);
                super.connection.newID(215);
                super.connection.hdl(l1);
                super.connection.addVar(egd);
                super.connection.addVar(djb ? 1 : 0);
                super.connection.complete();
            }
            egc = 0;
            return;
        }
        gfx.drawBox(56, 130, 400, 100, 0);
        gfx.drawBoxEdge(56, 130, 400, 100, 0xffffff);
        int l = 160;
        gfx.drawText("Now type the name of the offending player, and press enter", 256, l, 1, 0xffff00);
        l += 18;
        gfx.drawText("Name: " + super.fkl + "*", 256, l, 4, 0xffffff);
        if(super.abj > 0)
        {
            l = 207;
            if(djb)
                gfx.drawText("Moderator option: Mute player for 48 hours: <ON>", 256, l, 1, 0xff8000);
            else
                gfx.drawText("Moderator option: Mute player for 48 hours: <OFF>", 256, l, 1, 0xffffff);
            if(super.mouseX > 106 && super.mouseX < 406 && super.mouseY > l - 13 && super.mouseY < l + 2 && ebd == 1)
            {
                ebd = 0;
                djb = !djb;
            }
        }
        l = 222;
        int i1 = 0xffffff;
        if(super.mouseX > 196 && super.mouseX < 316 && super.mouseY > l - 13 && super.mouseY < l + 2)
        {
            i1 = 0xffff00;
            if(ebd == 1)
            {
                ebd = 0;
                egc = 0;
            }
        }
        gfx.drawText("Click here to cancel", 256, l, 1, i1);
        if(ebd == 1 && (super.mouseX < 56 || super.mouseX > 456 || super.mouseY < 130 || super.mouseY > 230))
        {
            ebd = 0;
            egc = 0;
        }
    }

    public final void fbf(boolean arg0)
    {
        int l = ((j) (gfx)).blg - 199;
        int i1 = 36;
        gfx.drawPicture(l - 49, 3, del + 6);
        char c1 = '\304';
        gfx.drawBoxAlpha(l, 36, c1, 65, j.createRGB(181, 181, 181), 160);
        gfx.drawBoxAlpha(l, 101, c1, 65, j.createRGB(201, 201, 201), 160);
        gfx.drawBoxAlpha(l, 166, c1, 95, j.createRGB(181, 181, 181), 160);
        gfx.drawBoxAlpha(l, 261, c1, 40, j.createRGB(201, 201, 201), 160);
        int j1 = l + 3;
        int l1 = i1 + 15;
        gfx.drawBoxText("Game options - click to toggle", j1, l1, 1, 0);
        l1 += 15;
        if(efb)
            gfx.drawBoxText("Camera angle mode - @gre@Auto", j1, l1, 1, 0xffffff);
        else
            gfx.drawBoxText("Camera angle mode - @red@Manual", j1, l1, 1, 0xffffff);
        l1 += 15;
        if(dek)
            gfx.drawBoxText("Mouse buttons - @red@One", j1, l1, 1, 0xffffff);
        else
            gfx.drawBoxText("Mouse buttons - @gre@Two", j1, l1, 1, 0xffffff);
        l1 += 15;
        if(member)
            if(ejl)
                gfx.drawBoxText("Sound effects - @red@off", j1, l1, 1, 0xffffff);
            else
                gfx.drawBoxText("Sound effects - @gre@on", j1, l1, 1, 0xffffff);
        l1 += 15;
        gfx.drawBoxText("To change your contact details,", j1, l1, 0, 0xffffff);
        l1 += 15;
        gfx.drawBoxText("password, recovery questions, etc..", j1, l1, 0, 0xffffff);
        l1 += 15;
        gfx.drawBoxText("please select 'account management'", j1, l1, 0, 0xffffff);
        l1 += 15;
        if(ejh == 0)
            gfx.drawBoxText("from the runescape.com front page", j1, l1, 0, 0xffffff);
        else
        if(ejh == 1)
            gfx.drawBoxText("from the link below the gamewindow", j1, l1, 0, 0xffffff);
        else
            gfx.drawBoxText("from the runescape front webpage", j1, l1, 0, 0xffffff);
        l1 += 15;
        l1 += 5;
        gfx.drawBoxText("Privacy settings. Will be applied to", l + 3, l1, 1, 0);
        l1 += 15;
        gfx.drawBoxText("all people not on your friends list", l + 3, l1, 1, 0);
        l1 += 15;
        if(super.blockChat == 0)
            gfx.drawBoxText("Block chat messages: @red@<off>", l + 3, l1, 1, 0xffffff);
        else
            gfx.drawBoxText("Block chat messages: @gre@<on>", l + 3, l1, 1, 0xffffff);
        l1 += 15;
        if(super.blockPM == 0)
            gfx.drawBoxText("Block private messages: @red@<off>", l + 3, l1, 1, 0xffffff);
        else
            gfx.drawBoxText("Block private messages: @gre@<on>", l + 3, l1, 1, 0xffffff);
        l1 += 15;
        if(super.blockTrade == 0)
            gfx.drawBoxText("Block trade requests: @red@<off>", l + 3, l1, 1, 0xffffff);
        else
            gfx.drawBoxText("Block trade requests: @gre@<on>", l + 3, l1, 1, 0xffffff);
        l1 += 15;
        if(member)
            if(super.blockDuel == 0)
                gfx.drawBoxText("Block duel requests: @red@<off>", l + 3, l1, 1, 0xffffff);
            else
                gfx.drawBoxText("Block duel requests: @gre@<on>", l + 3, l1, 1, 0xffffff);
        l1 += 15;
        l1 += 5;
        gfx.drawBoxText("Always logout when you finish", j1, l1, 1, 0);
        l1 += 15;
        int j2 = 0xffffff;
        if(super.mouseX > j1 && super.mouseX < j1 + c1 && super.mouseY > l1 - 12 && super.mouseY < l1 + 4)
            j2 = 0xffff00;
        gfx.drawBoxText("Click here to logout", l + 3, l1, 1, j2);
        if(!arg0)
            return;
        l = super.mouseX - (((j) (gfx)).blg - 199);
        i1 = super.mouseY - 36;
        if(l >= 0 && i1 >= 0 && l < 196 && i1 < 265)
        {
            int k2 = ((j) (gfx)).blg - 199;
            byte byte0 = 36;
            char c2 = '\304';
            int k1 = k2 + 3;
            int i2 = byte0 + 30;
            if(super.mouseX > k1 && super.mouseX < k1 + c2 && super.mouseY > i2 - 12 && super.mouseY < i2 + 4 && ebd == 1)
            {
                efb = !efb;
                super.connection.newID(165);
                super.connection.addVar(0);
                super.connection.addVar(efb ? 1 : 0);
                super.connection.complete();
            }
            i2 += 15;
            if(super.mouseX > k1 && super.mouseX < k1 + c2 && super.mouseY > i2 - 12 && super.mouseY < i2 + 4 && ebd == 1)
            {
                dek = !dek;
                super.connection.newID(165);
                super.connection.addVar(2);
                super.connection.addVar(dek ? 1 : 0);
                super.connection.complete();
            }
            i2 += 15;
            if(member && super.mouseX > k1 && super.mouseX < k1 + c2 && super.mouseY > i2 - 12 && super.mouseY < i2 + 4 && ebd == 1)
            {
                ejl = !ejl;
                super.connection.newID(165);
                super.connection.addVar(3);
                super.connection.addVar(ejl ? 1 : 0);
                super.connection.complete();
            }
            i2 += 15;
            i2 += 15;
            i2 += 15;
            i2 += 15;
            i2 += 15;
            boolean flag = false;
            i2 += 35;
            if(super.mouseX > k1 && super.mouseX < k1 + c2 && super.mouseY > i2 - 12 && super.mouseY < i2 + 4 && ebd == 1)
            {
                super.blockChat = 1 - super.blockChat;
                flag = true;
            }
            i2 += 15;
            if(super.mouseX > k1 && super.mouseX < k1 + c2 && super.mouseY > i2 - 12 && super.mouseY < i2 + 4 && ebd == 1)
            {
                super.blockPM = 1 - super.blockPM;
                flag = true;
            }
            i2 += 15;
            if(super.mouseX > k1 && super.mouseX < k1 + c2 && super.mouseY > i2 - 12 && super.mouseY < i2 + 4 && ebd == 1)
            {
                super.blockTrade = 1 - super.blockTrade;
                flag = true;
            }
            i2 += 15;
            if(member && super.mouseX > k1 && super.mouseX < k1 + c2 && super.mouseY > i2 - 12 && super.mouseY < i2 + 4 && ebd == 1)
            {
                super.blockDuel = 1 - super.blockDuel;
                flag = true;
            }
            i2 += 15;
            if(flag)
                acg(super.blockChat, super.blockPM, super.blockTrade, super.blockDuel);
            i2 += 20;
            if(super.mouseX > k1 && super.mouseX < k1 + c2 && super.mouseY > i2 - 12 && super.mouseY < i2 + 4 && ebd == 1)
                logout();
            ebd = 0;
        }
    }

    public final void fbg()
    {
        try
        {
            dnm = enb("sounds" + w.cff + ".mem", "Sound effects", 90);
            deb = new d();
            return;
        }
        catch(Throwable throwable)
        {
            System.out.println("Unable to init sounds:" + throwable);
        }
    }

    protected final void ade()
    {
        dhf = 0;
        displayMessage("@cya@Sorry, you can't logout at the moment", 3);
    }

    public final void fbh()
    {
        byte byte0 = 22;
        byte byte1 = 36;
        gfx.drawBox(byte0, byte1, 468, 16, 192);
        int l = 0x989898;
        gfx.drawBoxAlpha(byte0, byte1 + 16, 468, 246, l, 160);
        gfx.drawText("Please confirm your trade with @yel@" + t.grabFriendName(ekf), byte0 + 234, byte1 + 12, 1, 0xffffff);
        gfx.drawText("You are about to give:", byte0 + 117, byte1 + 30, 1, 0xffff00);
        for(int i1 = 0; i1 < egh; i1++)
        {
            String s1 = identify.itemName[egi[i1]];
            if(identify.stackable[egi[i1]] == 0)
                s1 = s1 + " x " + enk(egj[i1]);
            gfx.drawText(s1, byte0 + 117, byte1 + 42 + i1 * 12, 1, 0xffffff);
        }

        if(egh == 0)
            gfx.drawText("Nothing!", byte0 + 117, byte1 + 42, 1, 0xffffff);
        gfx.drawText("In return you will receive:", byte0 + 351, byte1 + 30, 1, 0xffff00);
        for(int j1 = 0; j1 < eje; j1++)
        {
            String s2 = identify.itemName[ejf[j1]];
            if(identify.stackable[ejf[j1]] == 0)
                s2 = s2 + " x " + enk(ejg[j1]);
            gfx.drawText(s2, byte0 + 351, byte1 + 42 + j1 * 12, 1, 0xffffff);
        }

        if(eje == 0)
            gfx.drawText("Nothing!", byte0 + 351, byte1 + 42, 1, 0xffffff);
        gfx.drawText("Are you sure you want to do this?", byte0 + 234, byte1 + 200, 4, 65535);
        gfx.drawText("There is NO WAY to reverse a trade if you change your mind.", byte0 + 234, byte1 + 215, 1, 0xffffff);
        gfx.drawText("Remember that not all players are trustworthy", byte0 + 234, byte1 + 230, 1, 0xffffff);
        if(!myPlayerAcceptedTradeSecondScreen)
        {
            gfx.drawPicture((byte0 + 118) - 35, byte1 + 238, del + 25);
            gfx.drawPicture((byte0 + 352) - 35, byte1 + 238, del + 26);
        } else
        {
            gfx.drawText("Waiting for other player...", byte0 + 234, byte1 + 250, 1, 0xffff00);
        }
        if(ebd == 1)
        {
            if(super.mouseX < byte0 || super.mouseY < byte1 || super.mouseX > byte0 + 468 || super.mouseY > byte1 + 262)
            {
                tradeSecondScreen = false;
                super.connection.newID(27);
                super.connection.complete();
            }
            if(super.mouseX >= (byte0 + 118) - 35 && super.mouseX <= byte0 + 118 + 70 && super.mouseY >= byte1 + 238 && super.mouseY <= byte1 + 238 + 21)
            {
                myPlayerAcceptedTradeSecondScreen = true;
                super.connection.newID(102);
                super.connection.complete();
            }
            if(super.mouseX >= (byte0 + 352) - 35 && super.mouseX <= byte0 + 353 + 70 && super.mouseY >= byte1 + 238 && super.mouseY <= byte1 + 238 + 21)
            {
                tradeSecondScreen = false;
                super.connection.newID(27);
                super.connection.complete();
            }
            ebd = 0;
        }
    }

    public final void fbi()
    {
        egd = 0;
        int l = 135;
        for(int i1 = 0; i1 < 12; i1++)
        {
            if(super.mouseX > 66 && super.mouseX < 446 && super.mouseY >= l - 12 && super.mouseY < l + 3)
                egd = i1 + 1;
            l += 14;
        }

        if(ebd != 0 && egd != 0)
        {
            ebd = 0;
            egc = 2;
            super.fkl = "";
            super.fkm = "";
            return;
        }
        l += 15;
        if(ebd != 0)
        {
            ebd = 0;
            if(super.mouseX < 56 || super.mouseY < 35 || super.mouseX > 456 || super.mouseY > 325)
            {
                egc = 0;
                return;
            }
            if(super.mouseX > 66 && super.mouseX < 446 && super.mouseY >= l - 15 && super.mouseY < l + 5)
            {
                egc = 0;
                return;
            }
        }
        gfx.drawBox(56, 35, 400, 290, 0);
        gfx.drawBoxEdge(56, 35, 400, 290, 0xffffff);
        l = 50;
        gfx.drawText("This form is for reporting players who are breaking our rules", 256, l, 1, 0xffffff);
        l += 15;
        gfx.drawText("Using it sends a snapshot of the last 60 secs of activity to us", 256, l, 1, 0xffffff);
        l += 15;
        gfx.drawText("If you misuse this form, you will be banned.", 256, l, 1, 0xff8000);
        l += 15;
        l += 10;
        gfx.drawText("First indicate which of our 12 rules is being broken. For a detailed", 256, l, 1, 0xffff00);
        l += 15;
        gfx.drawText("explanation of each rule please read the manual on our website.", 256, l, 1, 0xffff00);
        l += 15;
        int j1;
        if(egd == 1)
        {
            gfx.drawBoxEdge(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        gfx.drawText("1: Offensive language", 256, l, 1, j1);
        l += 14;
        if(egd == 2)
        {
            gfx.drawBoxEdge(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        gfx.drawText("2: Item scamming", 256, l, 1, j1);
        l += 14;
        if(egd == 3)
        {
            gfx.drawBoxEdge(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        gfx.drawText("3: Password scamming", 256, l, 1, j1);
        l += 14;
        if(egd == 4)
        {
            gfx.drawBoxEdge(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        gfx.drawText("4: Bug abuse", 256, l, 1, j1);
        l += 14;
        if(egd == 5)
        {
            gfx.drawBoxEdge(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        gfx.drawText("5: Jagex Staff impersonation", 256, l, 1, j1);
        l += 14;
        if(egd == 6)
        {
            gfx.drawBoxEdge(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        gfx.drawText("6: Account sharing/trading", 256, l, 1, j1);
        l += 14;
        if(egd == 7)
        {
            gfx.drawBoxEdge(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        gfx.drawText("7: Macroing", 256, l, 1, j1);
        l += 14;
        if(egd == 8)
        {
            gfx.drawBoxEdge(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        gfx.drawText("8: Mutiple logging in", 256, l, 1, j1);
        l += 14;
        if(egd == 9)
        {
            gfx.drawBoxEdge(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        gfx.drawText("9: Encouraging others to break rules", 256, l, 1, j1);
        l += 14;
        if(egd == 10)
        {
            gfx.drawBoxEdge(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        gfx.drawText("10: Misuse of customer support", 256, l, 1, j1);
        l += 14;
        if(egd == 11)
        {
            gfx.drawBoxEdge(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        gfx.drawText("11: Advertising / website", 256, l, 1, j1);
        l += 14;
        if(egd == 12)
        {
            gfx.drawBoxEdge(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        gfx.drawText("12: Real world item trading", 256, l, 1, j1);
        l += 14;
        l += 15;
        j1 = 0xffffff;
        if(super.mouseX > 196 && super.mouseX < 316 && super.mouseY > l - 15 && super.mouseY < l + 5)
            j1 = 0xffff00;
        gfx.drawText("Click here to cancel", 256, l, 1, j1);
    }

    public final String getParameter(String s1)
    {
        if(link.fni != null)
            return link.fni.getParameter(s1);
        else
            return super.getParameter(s1);
    }

    public final void fbj(boolean arg0)
    {
        int l = ((j) (gfx)).blg - 199;
        char c1 = '\234';
        char c3 = '\230';
        gfx.drawPicture(l - 49, 3, del + 2);
        l += 40;
        gfx.drawBox(l, 36, c1, c3, 0);
        gfx.cah(l, 36, l + c1, 36 + c3);
        int j1 = 192 + dff;
        int l1 = dke + dfe & 0xff;
        int j2 = ((myPlayer.x - 6040) * 3 * j1) / 2048;
        int l3 = ((myPlayer.y - 6040) * 3 * j1) / 2048;
        int j5 = n.bbk[1024 - l1 * 4 & 0x3ff];
        int l5 = n.bbk[(1024 - l1 * 4 & 0x3ff) + 1024];
        int j6 = l3 * j5 + j2 * l5 >> 18;
        l3 = l3 * l5 - j2 * j5 >> 18;
        j2 = j6;
        gfx.ccn((l + c1 / 2) - j2, 36 + c3 / 2 + l3, del - 1, l1 + 64 & 0xff, j1);
        for(int l7 = 0; l7 < objectCount; l7++)
        {
            int k2 = (((objectX[l7] * magicLoc + 64) - myPlayer.x) * 3 * j1) / 2048;
            int i4 = (((objectY[l7] * magicLoc + 64) - myPlayer.y) * 3 * j1) / 2048;
            int k6 = i4 * j5 + k2 * l5 >> 18;
            i4 = i4 * l5 - k2 * j5 >> 18;
            k2 = k6;
            fch(l + c1 / 2 + k2, (36 + c3 / 2) - i4, 65535);
        }

        for(int i8 = 0; i8 < itemCount; i8++)
        {
            int l2 = (((itemX[i8] * magicLoc + 64) - myPlayer.x) * 3 * j1) / 2048;
            int j4 = (((itemY[i8] * magicLoc + 64) - myPlayer.y) * 3 * j1) / 2048;
            int l6 = j4 * j5 + l2 * l5 >> 18;
            j4 = j4 * l5 - l2 * j5 >> 18;
            l2 = l6;
            fch(l + c1 / 2 + l2, (36 + c3 / 2) - j4, 0xff0000);
        }

        for(int j8 = 0; j8 < npcCount; j8++)
        {
            f f1 = npc[j8];
            int i3 = ((f1.x - myPlayer.x) * 3 * j1) / 2048;
            int k4 = ((f1.y - myPlayer.y) * 3 * j1) / 2048;
            int i7 = k4 * j5 + i3 * l5 >> 18;
            k4 = k4 * l5 - i3 * j5 >> 18;
            i3 = i7;
            fch(l + c1 / 2 + i3, (36 + c3 / 2) - k4, 0xffff00);
        }

        for(int k8 = 0; k8 < playerCount; k8++)
        {
            f f2 = player[k8];
            int j3 = ((f2.x - myPlayer.x) * 3 * j1) / 2048;
            int l4 = ((f2.y - myPlayer.y) * 3 * j1) / 2048;
            int j7 = l4 * j5 + j3 * l5 >> 18;
            l4 = l4 * l5 - j3 * j5 >> 18;
            j3 = j7;
            int i9 = 0xffffff;
            for(int j9 = 0; j9 < super.friendCount; j9++)
            {
                if(f2.gmd != super.friendID[j9] || super.friendOnlineStatus[j9] != 99)
                    continue;
                i9 = 65280;
                break;
            }

            fch(l + c1 / 2 + j3, (36 + c3 / 2) - l4, i9);
        }

        gfx.cal(l + c1 / 2, 36 + c3 / 2, 2, 0xffffff, 255);
        gfx.ccn(l + 19, 55, del + 24, dke + 128 & 0xff, 128);
        gfx.cah(0, 0, width, height + 12);
        if(!arg0)
            return;
        l = super.mouseX - (((j) (gfx)).blg - 199);
        int l8 = super.mouseY - 36;
        if(l >= 40 && l8 >= 0 && l < 196 && l8 < 152)
        {
            char c2 = '\234';
            char c4 = '\230';
            int k1 = 192 + dff;
            int i2 = dke + dfe & 0xff;
            int i1 = ((j) (gfx)).blg - 199;
            i1 += 40;
            int k3 = ((super.mouseX - (i1 + c2 / 2)) * 16384) / (3 * k1);
            int i5 = ((super.mouseY - (36 + c4 / 2)) * 16384) / (3 * k1);
            int k5 = n.bbk[1024 - i2 * 4 & 0x3ff];
            int i6 = n.bbk[(1024 - i2 * 4 & 0x3ff) + 1024];
            int k7 = i5 * k5 + k3 * i6 >> 15;
            i5 = i5 * i6 - k3 * k5 >> 15;
            k3 = k7;
            k3 += myPlayer.x;
            i5 = myPlayer.y - i5;
            if(ebd == 1)
                ena(smallX, smallY, k3 / 128, i5 / 128, false);
            ebd = 0;
        }
    }

    public final void fbk()
    {
        if(ebd != 0 && ddd == 0)
            ddd = 1;
        if(ddd > 0)
        {
            int l = super.mouseX - 22;
            int i1 = super.mouseY - 36;
            if(l >= 0 && i1 >= 0 && l < 468 && i1 < 262)
            {
                if(l > 216 && i1 > 30 && l < 462 && i1 < 235)
                {
                    int j1 = (l - 217) / 49 + ((i1 - 31) / 34) * 5;
                    if(j1 >= 0 && j1 < invCount)
                    {
                        boolean flag1 = false;
                        int k2 = 0;
                        int j3 = inv[j1];
                        for(int j4 = 0; j4 < myDuelItemCount; j4++)
                            if(myDuelItem[j4] == j3)
                                if(identify.stackable[j3] == 0)
                                {
                                    for(int l4 = 0; l4 < ddd; l4++)
                                    {
                                        if(myDuelItemValue[j4] < invValue[j1])
                                            myDuelItemValue[j4]++;
                                        flag1 = true;
                                    }

                                } else
                                {
                                    k2++;
                                }

                        if(invCount(j3) <= k2)
                            flag1 = true;
                        if(identify.ajl[j3] == 1)
                        {
                            displayMessage("This object cannot be added to a duel offer", 3);
                            flag1 = true;
                        }
                        if(!flag1 && myDuelItemCount < 8)
                        {
                            myDuelItem[myDuelItemCount] = j3;
                            myDuelItemValue[myDuelItemCount] = 1;
                            myDuelItemCount++;
                            flag1 = true;
                        }
                        if(flag1)
                        {
                            super.connection.newID(144);
                            super.connection.addVar(myDuelItemCount);
                            for(int i5 = 0; i5 < myDuelItemCount; i5++)
                            {
                                super.connection.addInt(myDuelItem[i5]);
                                super.connection.addLongInt(myDuelItemValue[i5]);
                            }

                            super.connection.complete();
                            duelAccepted = false;
                            myPlayerAcceptedDuel = false;
                        }
                    }
                }
                if(l > 8 && i1 > 30 && l < 205 && i1 < 129)
                {
                    int k1 = (l - 9) / 49 + ((i1 - 31) / 34) * 4;
                    if(k1 >= 0 && k1 < myDuelItemCount)
                    {
                        int i2 = myDuelItem[k1];
                        for(int l2 = 0; l2 < ddd; l2++)
                        {
                            if(identify.stackable[i2] == 0 && myDuelItemValue[k1] > 1)
                            {
                                myDuelItemValue[k1]--;
                                continue;
                            }
                            myDuelItemCount--;
                            ddc = 0;
                            for(int k3 = k1; k3 < myDuelItemCount; k3++)
                            {
                                myDuelItem[k3] = myDuelItem[k3 + 1];
                                myDuelItemValue[k3] = myDuelItemValue[k3 + 1];
                            }

                            break;
                        }

                        super.connection.newID(144);
                        super.connection.addVar(myDuelItemCount);
                        for(int l3 = 0; l3 < myDuelItemCount; l3++)
                        {
                            super.connection.addInt(myDuelItem[l3]);
                            super.connection.addLongInt(myDuelItemValue[l3]);
                        }

                        super.connection.complete();
                        duelAccepted = false;
                        myPlayerAcceptedDuel = false;
                    }
                }
                boolean flag = false;
                if(l >= 93 && i1 >= 221 && l <= 104 && i1 <= 232)
                {
                    noRetreat = !noRetreat;
                    flag = true;
                }
                if(l >= 93 && i1 >= 240 && l <= 104 && i1 <= 251)
                {
                    noMagic = !noMagic;
                    flag = true;
                }
                if(l >= 191 && i1 >= 221 && l <= 202 && i1 <= 232)
                {
                    noPrayer = !noPrayer;
                    flag = true;
                }
                if(l >= 191 && i1 >= 240 && l <= 202 && i1 <= 251)
                {
                    noWeapons = !noWeapons;
                    flag = true;
                }
                if(flag)
                {
                    super.connection.newID(217);
                    super.connection.addVar(noRetreat ? 1 : 0);
                    super.connection.addVar(noMagic ? 1 : 0);
                    super.connection.addVar(noPrayer ? 1 : 0);
                    super.connection.addVar(noWeapons ? 1 : 0);
                    super.connection.complete();
                    duelAccepted = false;
                    myPlayerAcceptedDuel = false;
                }
                if(l >= 217 && i1 >= 238 && l <= 286 && i1 <= 259)
                {
                    myPlayerAcceptedDuel = true;
                    super.connection.newID(94);
                    super.connection.complete();
                }
                if(l >= 394 && i1 >= 238 && l < 463 && i1 < 259)
                {
                    duel = false;
                    super.connection.newID(27);
                    super.connection.complete();
                }
            } else
            if(ebd != 0)
            {
                duel = false;
                super.connection.newID(27);
                super.connection.complete();
            }
            ebd = 0;
            ddd = 0;
        }
        if(!duel)
            return;
        byte byte0 = 22;
        byte byte1 = 36;
        gfx.drawBox(byte0, byte1, 468, 12, 0xc90b1d);
        int l1 = 0x989898;
        gfx.drawBoxAlpha(byte0, byte1 + 12, 468, 18, l1, 160);
        gfx.drawBoxAlpha(byte0, byte1 + 30, 8, 248, l1, 160);
        gfx.drawBoxAlpha(byte0 + 205, byte1 + 30, 11, 248, l1, 160);
        gfx.drawBoxAlpha(byte0 + 462, byte1 + 30, 6, 248, l1, 160);
        gfx.drawBoxAlpha(byte0 + 8, byte1 + 99, 197, 24, l1, 160);
        gfx.drawBoxAlpha(byte0 + 8, byte1 + 192, 197, 23, l1, 160);
        gfx.drawBoxAlpha(byte0 + 8, byte1 + 258, 197, 20, l1, 160);
        gfx.drawBoxAlpha(byte0 + 216, byte1 + 235, 246, 43, l1, 160);
        int j2 = 0xd0d0d0;
        gfx.drawBoxAlpha(byte0 + 8, byte1 + 30, 197, 69, j2, 160);
        gfx.drawBoxAlpha(byte0 + 8, byte1 + 123, 197, 69, j2, 160);
        gfx.drawBoxAlpha(byte0 + 8, byte1 + 215, 197, 43, j2, 160);
        gfx.drawBoxAlpha(byte0 + 216, byte1 + 30, 246, 205, j2, 160);
        for(int i3 = 0; i3 < 3; i3++)
            gfx.drawLine(byte0 + 8, byte1 + 30 + i3 * 34, 197, 0);

        for(int i4 = 0; i4 < 3; i4++)
            gfx.drawLine(byte0 + 8, byte1 + 123 + i4 * 34, 197, 0);

        for(int k4 = 0; k4 < 7; k4++)
            gfx.drawLine(byte0 + 216, byte1 + 30 + k4 * 34, 246, 0);

        for(int j5 = 0; j5 < 6; j5++)
        {
            if(j5 < 5)
                gfx.cbd(byte0 + 8 + j5 * 49, byte1 + 30, 69, 0);
            if(j5 < 5)
                gfx.cbd(byte0 + 8 + j5 * 49, byte1 + 123, 69, 0);
            gfx.cbd(byte0 + 216 + j5 * 49, byte1 + 30, 205, 0);
        }

        gfx.drawLine(byte0 + 8, byte1 + 215, 197, 0);
        gfx.drawLine(byte0 + 8, byte1 + 257, 197, 0);
        gfx.cbd(byte0 + 8, byte1 + 215, 43, 0);
        gfx.cbd(byte0 + 204, byte1 + 215, 43, 0);
        gfx.drawBoxText("Preparing to duel with: " + duelingWithName, byte0 + 1, byte1 + 10, 1, 0xffffff);
        gfx.drawBoxText("Your Stake", byte0 + 9, byte1 + 27, 4, 0xffffff);
        gfx.drawBoxText("Opponent's Stake", byte0 + 9, byte1 + 120, 4, 0xffffff);
        gfx.drawBoxText("Duel Options", byte0 + 9, byte1 + 212, 4, 0xffffff);
        gfx.drawBoxText("Your Inventory", byte0 + 216, byte1 + 27, 4, 0xffffff);
        gfx.drawBoxText("No retreating", byte0 + 8 + 1, byte1 + 215 + 16, 3, 0xffff00);
        gfx.drawBoxText("No magic", byte0 + 8 + 1, byte1 + 215 + 35, 3, 0xffff00);
        gfx.drawBoxText("No prayer", byte0 + 8 + 102, byte1 + 215 + 16, 3, 0xffff00);
        gfx.drawBoxText("No weapons", byte0 + 8 + 102, byte1 + 215 + 35, 3, 0xffff00);
        gfx.drawBoxEdge(byte0 + 93, byte1 + 215 + 6, 11, 11, 0xffff00);
        if(noRetreat)
            gfx.drawBox(byte0 + 95, byte1 + 215 + 8, 7, 7, 0xffff00);
        gfx.drawBoxEdge(byte0 + 93, byte1 + 215 + 25, 11, 11, 0xffff00);
        if(noMagic)
            gfx.drawBox(byte0 + 95, byte1 + 215 + 27, 7, 7, 0xffff00);
        gfx.drawBoxEdge(byte0 + 191, byte1 + 215 + 6, 11, 11, 0xffff00);
        if(noPrayer)
            gfx.drawBox(byte0 + 193, byte1 + 215 + 8, 7, 7, 0xffff00);
        gfx.drawBoxEdge(byte0 + 191, byte1 + 215 + 25, 11, 11, 0xffff00);
        if(noWeapons)
            gfx.drawBox(byte0 + 193, byte1 + 215 + 27, 7, 7, 0xffff00);
        if(!myPlayerAcceptedDuel)
            gfx.drawPicture(byte0 + 217, byte1 + 238, del + 25);
        gfx.drawPicture(byte0 + 394, byte1 + 238, del + 26);
        if(duelAccepted)
        {
            gfx.drawText("Other player", byte0 + 341, byte1 + 246, 1, 0xffffff);
            gfx.drawText("has accepted", byte0 + 341, byte1 + 256, 1, 0xffffff);
        }
        if(myPlayerAcceptedDuel)
        {
            gfx.drawText("Waiting for", byte0 + 217 + 35, byte1 + 246, 1, 0xffffff);
            gfx.drawText("other player", byte0 + 217 + 35, byte1 + 256, 1, 0xffffff);
        }
        for(int k5 = 0; k5 < invCount; k5++)
        {
            int l5 = 217 + byte0 + (k5 % 5) * 49;
            int j6 = 31 + byte1 + (k5 / 5) * 34;
            gfx.cdd(l5, j6, 48, 32, den + identify.ajf[inv[k5]], identify.ajk[inv[k5]], 0, 0, false);
            if(identify.stackable[inv[k5]] == 0)
                gfx.drawBoxText(String.valueOf(invValue[k5]), l5 + 1, j6 + 10, 1, 0xffff00);
        }

        for(int i6 = 0; i6 < myDuelItemCount; i6++)
        {
            int k6 = 9 + byte0 + (i6 % 4) * 49;
            int i7 = 31 + byte1 + (i6 / 4) * 34;
            gfx.cdd(k6, i7, 48, 32, den + identify.ajf[myDuelItem[i6]], identify.ajk[myDuelItem[i6]], 0, 0, false);
            if(identify.stackable[myDuelItem[i6]] == 0)
                gfx.drawBoxText(String.valueOf(myDuelItemValue[i6]), k6 + 1, i7 + 10, 1, 0xffff00);
            if(super.mouseX > k6 && super.mouseX < k6 + 48 && super.mouseY > i7 && super.mouseY < i7 + 32)
                gfx.drawBoxText(identify.itemName[myDuelItem[i6]] + ": @whi@" + identify.itemDesc[myDuelItem[i6]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }

        for(int l6 = 0; l6 < duelItemCount; l6++)
        {
            int j7 = 9 + byte0 + (l6 % 4) * 49;
            int k7 = 124 + byte1 + (l6 / 4) * 34;
            gfx.cdd(j7, k7, 48, 32, den + identify.ajf[duelItem[l6]], identify.ajk[duelItem[l6]], 0, 0, false);
            if(identify.stackable[duelItem[l6]] == 0)
                gfx.drawBoxText(String.valueOf(duelItemValue[l6]), j7 + 1, k7 + 10, 1, 0xffff00);
            if(super.mouseX > j7 && super.mouseX < j7 + 48 && super.mouseY > k7 && super.mouseY < k7 + 32)
                gfx.drawBoxText(identify.itemName[duelItem[l6]] + ": @whi@" + identify.itemDesc[duelItem[l6]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }

    }

    public final void fbl()
    {
        super.fkn = "";
        super.fla = "";
    }

    public final void fbm()
    {
        if((ema & 1) == 1 && fab(ema))
            return;
        if((ema & 1) == 0 && fab(ema))
        {
            if(fab(ema + 1 & 7))
            {
                ema = ema + 1 & 7;
                return;
            }
            if(fab(ema + 7 & 7))
                ema = ema + 7 & 7;
            return;
        }
        int ai[] = {
            1, -1, 2, -2, 3, -3, 4
        };
        for(int l = 0; l < 7; l++)
        {
            if(!fab(ema + ai[l] + 8 & 7))
                continue;
            ema = ema + ai[l] + 8 & 7;
            break;
        }

        if((ema & 1) == 0 && fab(ema))
        {
            if(fab(ema + 1 & 7))
            {
                ema = ema + 1 & 7;
                return;
            }
            if(fab(ema + 7 & 7))
                ema = ema + 7 & 7;
            return;
        } else
        {
            return;
        }
    }

    public final void fbn()
    {
        loggedIn = 0;
        ehl = 0;
        username = "";
        password = "";
        eil = "Please enter a username:";
        eim = "*" + username + "*";
        playerCount = 0;
        npcCount = 0;
    }

    protected final void add()
    {
        edh = 0;
        ehl = 0;
        loggedIn = 0;
        dhf = 0;
    }

    final void fca(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6)
    {
        f f1 = npc[arg4];
        int l = f1.sprite + (dke + 16) / 32 & 7;
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
        int j1 = i1 * 3 + efl[(f1.gmk / identify.akk[f1.type]) % 4];
        if(f1.sprite == 8)
        {
            i1 = 5;
            l = 2;
            flag = false;
            arg0 -= (identify.akm[f1.type] * arg6) / 100;
            j1 = i1 * 3 + dei[(dji / (identify.akl[f1.type] - 1)) % 8];
        } else
        if(f1.sprite == 9)
        {
            i1 = 5;
            l = 2;
            flag = true;
            arg0 += (identify.akm[f1.type] * arg6) / 100;
            j1 = i1 * 3 + ded[(dji / identify.akl[f1.type]) % 8];
        }
        for(int k1 = 0; k1 < 12; k1++)
        {
            int l1 = ddh[l][k1];
            int k2 = identify.aig[f1.type][l1];
            if(k2 >= 0)
            {
                int i3 = 0;
                int j3 = 0;
                int k3 = j1;
                if(flag && i1 >= 1 && i1 <= 3 && identify.anc[k2] == 1)
                    k3 += 15;
                if(i1 != 5 || identify.anb[k2] == 1)
                {
                    int l3 = k3 + identify.and[k2];
                    i3 = (i3 * arg2) / ((j) (gfx)).bmj[l3];
                    j3 = (j3 * arg3) / ((j) (gfx)).bmk[l3];
                    int i4 = (arg2 * ((j) (gfx)).bmj[l3]) / ((j) (gfx)).bmj[identify.and[k2]];
                    i3 -= (i4 - arg2) / 2;
                    int j4 = identify.amn[k2];
                    int k4 = 0;
                    if(j4 == 1)
                    {
                        j4 = identify.ain[f1.type];
                        k4 = identify.ajc[f1.type];
                    } else
                    if(j4 == 2)
                    {
                        j4 = identify.aja[f1.type];
                        k4 = identify.ajc[f1.type];
                    } else
                    if(j4 == 3)
                    {
                        j4 = identify.ajb[f1.type];
                        k4 = identify.ajc[f1.type];
                    }
                    gfx.cdd(arg0 + i3, arg1 + j3, i4, arg3, l3, j4, k4, arg5, flag);
                }
            }
        }

        if(f1.lastSaidTimeout > 0)
        {
            ebg[efd] = gfx.textWidth(f1.lastSaid, 1) / 2;
            if(ebg[efd] > 150)
                ebg[efd] = 150;
            ebh[efd] = (gfx.textWidth(f1.lastSaid, 1) / 300) * gfx.ced(1);
            ebe[efd] = arg0 + arg2 / 2;
            ebf[efd] = arg1;
            efe[efd++] = f1.lastSaid;
        }
        if(f1.sprite == 8 || f1.sprite == 9 || f1.gnl != 0)
        {
            if(f1.gnl > 0)
            {
                int i2 = arg0;
                if(f1.sprite == 8)
                    i2 -= (20 * arg6) / 100;
                else
                if(f1.sprite == 9)
                    i2 += (20 * arg6) / 100;
                int l2 = (f1.gnj * 30) / f1.gnk;
                dfg[egl] = i2 + arg2 / 2;
                dfh[egl] = arg1;
                dfi[egl++] = l2;
            }
            if(f1.gnl > 150)
            {
                int j2 = arg0;
                if(f1.sprite == 8)
                    j2 -= (10 * arg6) / 100;
                else
                if(f1.sprite == 9)
                    j2 += (10 * arg6) / 100;
                gfx.drawPicture((j2 + arg2 / 2) - 12, (arg1 + arg3 / 2) - 12, del + 12);
                gfx.drawText(String.valueOf(f1.gni), (j2 + arg2 / 2) - 1, arg1 + arg3 / 2 + 5, 3, 0xffffff);
            }
        }
    }

    public final void fcb(boolean arg0)
    {
        int l = ((j) (gfx)).blg - 199;
        int i1 = 36;
        gfx.drawPicture(l - 49, 3, del + 5);
        char c1 = '\304';
        char c2 = '\266';
        int k1;
        int j1 = k1 = j.createRGB(160, 160, 160);
        if(ekb == 0)
            j1 = j.createRGB(220, 220, 220);
        else
            k1 = j.createRGB(220, 220, 220);
        gfx.drawBoxAlpha(l, i1, c1 / 2, 24, j1, 128);
        gfx.drawBoxAlpha(l + c1 / 2, i1, c1 / 2, 24, k1, 128);
        gfx.drawBoxAlpha(l, i1 + 24, c1, c2 - 24, j.createRGB(220, 220, 220), 128);
        gfx.drawLine(l, i1 + 24, c1, 0);
        gfx.cbd(l + c1 / 2, i1, 24, 0);
        gfx.drawLine(l, (i1 + c2) - 16, c1, 0);
        gfx.drawText("Friends", l + c1 / 4, i1 + 16, 4, 0);
        gfx.drawText("Ignore", l + c1 / 4 + c1 / 2, i1 + 16, 4, 0);
        ejn.gfm(eka);
        if(ekb == 0)
        {
            for(int l1 = 0; l1 < super.friendCount; l1++)
            {
                String s1;
                if(super.friendOnlineStatus[l1] == 99)
                    s1 = "@gre@";
                else
                if(super.friendOnlineStatus[l1] > 0)
                    s1 = "@yel@";
                else
                    s1 = "@red@";
                ejn.gga(eka, l1, s1 + t.grabFriendName(super.friendID[l1]) + "~439~@whi@Remove         WWWWWWWWWW");
            }

        }
        if(ekb == 1)
        {
            for(int i2 = 0; i2 < super.aan; i2++)
                ejn.gga(eka, i2, "@yel@" + t.grabFriendName(super.aba[i2]) + "~439~@whi@Remove         WWWWWWWWWW");

        }
        ejn.ged();
        if(ekb == 0)
        {
            int j2 = ejn.ggh(eka);
            if(j2 >= 0 && super.mouseX < 489)
            {
                if(super.mouseX > 429)
                    gfx.drawText("Click to remove " + t.grabFriendName(super.friendID[j2]), l + c1 / 2, i1 + 35, 1, 0xffffff);
                else
                if(super.friendOnlineStatus[j2] == 99)
                    gfx.drawText("Click to message " + t.grabFriendName(super.friendID[j2]), l + c1 / 2, i1 + 35, 1, 0xffffff);
                else
                if(super.friendOnlineStatus[j2] > 0)
                    gfx.drawText(t.grabFriendName(super.friendID[j2]) + " is on world " + super.friendOnlineStatus[j2], l + c1 / 2, i1 + 35, 1, 0xffffff);
                else
                    gfx.drawText(t.grabFriendName(super.friendID[j2]) + " is offline", l + c1 / 2, i1 + 35, 1, 0xffffff);
            } else
            {
                gfx.drawText("Click a name to send a message", l + c1 / 2, i1 + 35, 1, 0xffffff);
            }
            int j3;
            if(super.mouseX > l && super.mouseX < l + c1 && super.mouseY > (i1 + c2) - 16 && super.mouseY < i1 + c2)
                j3 = 0xffff00;
            else
                j3 = 0xffffff;
            gfx.drawText("Click here to add a friend", l + c1 / 2, (i1 + c2) - 3, 1, j3);
        }
        if(ekb == 1)
        {
            int k2 = ejn.ggh(eka);
            if(k2 >= 0 && super.mouseX < 489 && super.mouseX > 429)
            {
                if(super.mouseX > 429)
                    gfx.drawText("Click to remove " + t.grabFriendName(super.aba[k2]), l + c1 / 2, i1 + 35, 1, 0xffffff);
            } else
            {
                gfx.drawText("Blocking messages from:", l + c1 / 2, i1 + 35, 1, 0xffffff);
            }
            int k3;
            if(super.mouseX > l && super.mouseX < l + c1 && super.mouseY > (i1 + c2) - 16 && super.mouseY < i1 + c2)
                k3 = 0xffff00;
            else
                k3 = 0xffffff;
            gfx.drawText("Click here to add a name", l + c1 / 2, (i1 + c2) - 3, 1, k3);
        }
        if(!arg0)
            return;
        l = super.mouseX - (((j) (gfx)).blg - 199);
        i1 = super.mouseY - 36;
        if(l >= 0 && i1 >= 0 && l < 196 && i1 < 182)
        {
            ejn.gea(l + (((j) (gfx)).blg - 199), i1 + 36, super.fkh, super.fkg);
            if(i1 <= 24 && ebd == 1)
                if(l < 98 && ekb == 1)
                {
                    ekb = 0;
                    ejn.gfn(eka);
                } else
                if(l > 98 && ekb == 0)
                {
                    ekb = 1;
                    ejn.gfn(eka);
                }
            if(ebd == 1 && ekb == 0)
            {
                int l2 = ejn.ggh(eka);
                if(l2 >= 0 && super.mouseX < 489)
                    if(super.mouseX > 429)
                        ack(super.friendID[l2]);
                    else
                    if(super.friendOnlineStatus[l2] != 0)
                    {
                        efm = 2;
                        ekc = super.friendID[l2];
                        super.fkn = "";
                        super.fla = "";
                    }
            }
            if(ebd == 1 && ekb == 1)
            {
                int i3 = ejn.ggh(eka);
                if(i3 >= 0 && super.mouseX < 489 && super.mouseX > 429)
                    aci(super.aba[i3]);
            }
            if(i1 > 166 && ebd == 1 && ekb == 0)
            {
                efm = 1;
                super.fkl = "";
                super.fkm = "";
            }
            if(i1 > 166 && ebd == 1 && ekb == 1)
            {
                efm = 3;
                super.fkl = "";
                super.fkm = "";
            }
            ebd = 0;
        }
    }

    public final void fcc()
    {
        if(super.abi > 0)
            super.abi--;
        if(ehl == 0)
        {
            menuMain.gea(super.mouseX, super.mouseY, super.fkh, super.fkg);
			if (menuMain.buttonHandleDown(checkUpdate) && !mainMenuBusy)
			{
				mainMenuMessage = "@whi@Connecting to Server...";
				redrawMenu();
			}
			if (menuMain.buttonHandleDown(decWorld) && !mainMenuBusy)
			{
				ServerList.setWorld(ServerList.world - 1);
				try
				{
					serverHost = ServerList.getWorld();
					serverPort = ServerList.getPort();
					t.serverIP = new URL(ServerList.getWorld());
				}
				catch(Exception _ex) { }
				redrawMenu();
			}
			if (menuMain.buttonHandleDown(incWorld) && !mainMenuBusy)
			{
				ServerList.setWorld(ServerList.world + 1);
				try
				{
					serverHost = ServerList.getWorld();
					serverPort = ServerList.getPort();
					t.serverIP = new URL(ServerList.getWorld());
				}
				catch(Exception _ex) { }
				redrawMenu();
			}
            if(menuMain.buttonHandleDown(dnn) && !mainMenuBusy)
                ehl = 1;
            if(menuMain.buttonHandleDown(beginButtonHandle) && !mainMenuBusy)
            {
                ehl = 2;
                menuLogin.ggc(elb, "Please enter your username and password");
                menuLogin.ggc(elc, "");
                menuLogin.ggc(eld, "");
                menuLogin.ggg(elc);
                return;
            }
        } else
        if(ehl == 1)
        {
            menuNewAccount.gea(super.mouseX, super.mouseY, super.fkh, super.fkg);
            if(menuNewAccount.buttonHandleDown(ejj))
            {
                ehl = 0;
                return;
            }
        } else
        if(ehl == 2)
        {
            menuLogin.gea(super.mouseX, super.mouseY, super.fkh, super.fkg);
            if(menuLogin.buttonHandleDown(elf))
                ehl = 0;
            if(menuLogin.buttonHandleDown(elc))
                menuLogin.ggg(eld);
            if(menuLogin.buttonHandleDown(eld) || menuLogin.buttonHandleDown(ele))
            {
                username = menuLogin.ggd(elc);
                password = menuLogin.ggd(eld);
                login(username, password, false);
            }
        }
    }

    public final void fcd(int l, int i1, int j1)
    {
        if(j1 == 0)
        {
            fde(smallX, smallY, l, i1 - 1, l, i1, false, true);
            return;
        }
        if(j1 == 1)
        {
            fde(smallX, smallY, l - 1, i1, l, i1, false, true);
            return;
        } else
        {
            fde(smallX, smallY, l, i1, l, i1, true, true);
            return;
        }
    }

    public final int invCount(int arg0)
    {
        int l = 0;
        for(int i1 = 0; i1 < invCount; i1++)
            if(inv[i1] == arg0)
                if(identify.stackable[arg0] == 1)
                    l++;
                else
                    l += invValue[i1];

        return l;
    }

    protected final void fcf(int arg0, int arg1, int arg2)
    {
        dme[dmd] = arg1;
        dmf[dmd] = arg2;
        dmd = dmd + 1 & 0x1fff;
        for(int l = 10; l < 4000; l++)
        {
            int i1 = dmd - l & 0x1fff;
            if(dme[i1] == arg1 && dmf[i1] == arg2)
            {
                boolean flag = false;
                for(int j1 = 1; j1 < l; j1++)
                {
                    int k1 = dmd - j1 & 0x1fff;
                    int l1 = i1 - j1 & 0x1fff;
                    if(dme[l1] != arg1 || dmf[l1] != arg2)
                        flag = true;
                    if(dme[k1] != dme[l1] || dmf[k1] != dmf[l1])
                        break;
                    if(j1 == l - 1 && flag && eda == 0 && dhf == 0)
                    {
                        logout();
                        return;
                    }
                }

            }
        }

    }

    protected final void fcg(Runnable runnable)
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

    public final void fch(int l, int i1, int j1)
    {
        gfx.cbe(l, i1, j1);
        gfx.cbe(l - 1, i1, j1);
        gfx.cbe(l + 1, i1, j1);
        gfx.cbe(l, i1 - 1, j1);
        gfx.cbe(l, i1 + 1, j1);
    }

    protected final int adi()
    {
        return link.fnj;
    }

    protected final void fci()
    {
        if(ein)
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
        if(eki)
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
        if(elm)
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
			if(loggedIn == 0 && autoLogin)
				login(username, password, false);
			if (sleeping)
				sleepword();
			if (graphicsEnabled)
			{
				if(loggedIn == 0)
				{
					gfx.bnf = false;
					drawMenus();
				}
				if(loggedIn == 1)
				{
					gfx.bnf = true;
					drawGame();
					return;
				}
			} else {
				try
				{
					Thread.sleep(1);
				}
				catch (Exception e) {}
			}
        }
        catch(OutOfMemoryError _ex)
        {
            fdd();
            elm = true;
        }
    }

    public final boolean fcj(int arg0)
    {
        for(int l = 0; l < invCount; l++)
            if(inv[l] == arg0 && wearing[l] == 1)
                return true;

        return false;
    }

    protected final void acb()
    {
        edh = 0;
        if(dhf != 0)
        {
            add();
            return;
        } else
        {
            super.acb();
            return;
        }
    }

    public final void fck()
    {
        byte abyte0[] = enb("config" + w.cen + ".jag", "Configuration", 10);
        if(abyte0 == null)
        {
            ein = true;
            return;
        }
        identify.baa(abyte0, member);
        byte abyte1[] = enb("filter" + w.cfg + ".jag", "Chat system", 15);
        if(abyte1 == null)
        {
            ein = true;
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

    final void fcl(int l, int i1, int j1, int k1, int l1, int i2, int j2)
    {
        int k2 = identify.ajf[l1] + den;
        int l2 = identify.ajk[l1];
        gfx.cdd(l, i1, j1, k1, k2, l2, 0, 0, false);
    }

    public final void fcm()
    {
        gfx.drawPicture(0, height - 4, del + 23);
        int l = j.createRGB(200, 200, 255);
        if(ell == 0)
            l = j.createRGB(255, 200, 50);
        if(ehc % 30 > 15)
            l = j.createRGB(255, 50, 50);
        gfx.drawText("All messages", 54, height + 6, 0, l);
        l = j.createRGB(200, 200, 255);
        if(ell == 1)
            l = j.createRGB(255, 200, 50);
        if(ehd % 30 > 15)
            l = j.createRGB(255, 50, 50);
        gfx.drawText("Chat history", 155, height + 6, 0, l);
        l = j.createRGB(200, 200, 255);
        if(ell == 2)
            l = j.createRGB(255, 200, 50);
        if(ehe % 30 > 15)
            l = j.createRGB(255, 50, 50);
        gfx.drawText("Quest history", 255, height + 6, 0, l);
        l = j.createRGB(200, 200, 255);
        if(ell == 3)
            l = j.createRGB(255, 200, 50);
        if(ehf % 30 > 15)
            l = j.createRGB(255, 50, 50);
        gfx.drawText("Private history", 355, height + 6, 0, l);
        gfx.drawText("Report abuse", 457, height + 6, 0, 0xffffff);
    }

    public final void fcn()
    {
        dhi.gea(super.mouseX, super.mouseY, super.fkh, super.fkg);
        if(dhi.buttonHandleDown(eec))
            do
                dhl = ((dhl - 1) + identify.ake) % identify.ake;
            while((identify.ana[dhl] & 3) != 1 || (identify.ana[dhl] & 4 * die) == 0);
        if(dhi.buttonHandleDown(eed))
            do
                dhl = (dhl + 1) % identify.ake;
            while((identify.ana[dhl] & 3) != 1 || (identify.ana[dhl] & 4 * die) == 0);
        if(dhi.buttonHandleDown(eee))
            dia = ((dia - 1) + dlj.length) % dlj.length;
        if(dhi.buttonHandleDown(eef))
            dia = (dia + 1) % dlj.length;
        if(dhi.buttonHandleDown(eeg) || dhi.buttonHandleDown(eeh))
        {
            for(die = 3 - die; (identify.ana[dhl] & 3) != 1 || (identify.ana[dhl] & 4 * die) == 0; dhl = (dhl + 1) % identify.ake);
            for(; (identify.ana[dhm] & 3) != 2 || (identify.ana[dhm] & 4 * die) == 0; dhm = (dhm + 1) % identify.ake);
        }
        if(dhi.buttonHandleDown(eei))
            dib = ((dib - 1) + deg.length) % deg.length;
        if(dhi.buttonHandleDown(eej))
            dib = (dib + 1) % deg.length;
        if(dhi.buttonHandleDown(eek))
            did = ((did - 1) + ekd.length) % ekd.length;
        if(dhi.buttonHandleDown(eel))
            did = (did + 1) % ekd.length;
        if(dhi.buttonHandleDown(eem))
            dic = ((dic - 1) + deg.length) % deg.length;
        if(dhi.buttonHandleDown(een))
            dic = (dic + 1) % deg.length;
        if(dhi.buttonHandleDown(efa))
        {
            super.connection.newID(238);
            super.connection.addVar(die);
            super.connection.addVar(dhl);
            super.connection.addVar(dhm);
            super.connection.addVar(dhn);
            super.connection.addVar(dia);
            super.connection.addVar(dib);
            super.connection.addVar(dic);
            super.connection.addVar(did);
            super.connection.complete();
            gfx.cak();
            efc = false;
        }
    }

    public final void fda()
    {
        byte byte0 = 22;
        byte byte1 = 36;
        gfx.drawBox(byte0, byte1, 468, 16, 192);
        int l = 0x989898;
        gfx.drawBoxAlpha(byte0, byte1 + 16, 468, 246, l, 160);
        gfx.drawText("Please confirm your duel with @yel@" + t.grabFriendName(eme), byte0 + 234, byte1 + 12, 1, 0xffffff);
        gfx.drawText("Your stake:", byte0 + 117, byte1 + 30, 1, 0xffff00);
        for(int i1 = 0; i1 < dgg; i1++)
        {
            String s1 = identify.itemName[dgh[i1]];
            if(identify.stackable[dgh[i1]] == 0)
                s1 = s1 + " x " + enk(dgi[i1]);
            gfx.drawText(s1, byte0 + 117, byte1 + 42 + i1 * 12, 1, 0xffffff);
        }

        if(dgg == 0)
            gfx.drawText("Nothing!", byte0 + 117, byte1 + 42, 1, 0xffffff);
        gfx.drawText("Your opponent's stake:", byte0 + 351, byte1 + 30, 1, 0xffff00);
        for(int j1 = 0; j1 < dhb; j1++)
        {
            String s2 = identify.itemName[dhc[j1]];
            if(identify.stackable[dhc[j1]] == 0)
                s2 = s2 + " x " + enk(dhd[j1]);
            gfx.drawText(s2, byte0 + 351, byte1 + 42 + j1 * 12, 1, 0xffffff);
        }

        if(dhb == 0)
            gfx.drawText("Nothing!", byte0 + 351, byte1 + 42, 1, 0xffffff);
        if(eac == 0)
            gfx.drawText("You can retreat from this duel", byte0 + 234, byte1 + 180, 1, 65280);
        else
            gfx.drawText("No retreat is possible!", byte0 + 234, byte1 + 180, 1, 0xff0000);
        if(ead == 0)
            gfx.drawText("Magic may be used", byte0 + 234, byte1 + 192, 1, 65280);
        else
            gfx.drawText("Magic cannot be used", byte0 + 234, byte1 + 192, 1, 0xff0000);
        if(eae == 0)
            gfx.drawText("Prayer may be used", byte0 + 234, byte1 + 204, 1, 65280);
        else
            gfx.drawText("Prayer cannot be used", byte0 + 234, byte1 + 204, 1, 0xff0000);
        if(eaf == 0)
            gfx.drawText("Weapons may be used", byte0 + 234, byte1 + 216, 1, 65280);
        else
            gfx.drawText("Weapons cannot be used", byte0 + 234, byte1 + 216, 1, 0xff0000);
        gfx.drawText("If you are sure click 'Accept' to begin the duel", byte0 + 234, byte1 + 230, 1, 0xffffff);
        if(!myPlayerAcceptedDuelSecondScreen)
        {
            gfx.drawPicture((byte0 + 118) - 35, byte1 + 238, del + 25);
            gfx.drawPicture((byte0 + 352) - 35, byte1 + 238, del + 26);
        } else
        {
            gfx.drawText("Waiting for other player...", byte0 + 234, byte1 + 250, 1, 0xffff00);
        }
        if(ebd == 1)
        {
            if(super.mouseX < byte0 || super.mouseY < byte1 || super.mouseX > byte0 + 468 || super.mouseY > byte1 + 262)
            {
                duelSecondScreen = false;
                super.connection.newID(27);
                super.connection.complete();
            }
            if(super.mouseX >= (byte0 + 118) - 35 && super.mouseX <= byte0 + 118 + 70 && super.mouseY >= byte1 + 238 && super.mouseY <= byte1 + 238 + 21)
            {
                myPlayerAcceptedDuelSecondScreen = true;
                super.connection.newID(175);
                super.connection.complete();
            }
            if(super.mouseX >= (byte0 + 352) - 35 && super.mouseX <= byte0 + 353 + 70 && super.mouseY >= byte1 + 238 && super.mouseY <= byte1 + 238 + 21)
            {
                duelSecondScreen = false;
                super.connection.newID(43);
                super.connection.complete();
            }
            ebd = 0;
        }
    }

    public final void fdb(String s1)
    {
        if(deb == null)
            return;
        if(ejl)
        {
            return;
        } else
        {
            deb.ggm(dnm, t.fne(s1 + ".pcm", dnm), t.fnf(s1 + ".pcm", dnm));
            return;
        }
    }

    public final void fdc(boolean arg0)
    {
        int l = ((j) (gfx)).blg - 199;
        int i1 = 36;
        gfx.drawPicture(l - 49, 3, del + 4);
        char c1 = '\304';
        char c2 = '\266';
        int k1;
        int j1 = k1 = j.createRGB(160, 160, 160);
        if(ebl == 0)
            j1 = j.createRGB(220, 220, 220);
        else
            k1 = j.createRGB(220, 220, 220);
        gfx.drawBoxAlpha(l, i1, c1 / 2, 24, j1, 128);
        gfx.drawBoxAlpha(l + c1 / 2, i1, c1 / 2, 24, k1, 128);
        gfx.drawBoxAlpha(l, i1 + 24, c1, 90, j.createRGB(220, 220, 220), 128);
        gfx.drawBoxAlpha(l, i1 + 24 + 90, c1, c2 - 90 - 24, j.createRGB(160, 160, 160), 128);
        gfx.drawLine(l, i1 + 24, c1, 0);
        gfx.cbd(l + c1 / 2, i1, 24, 0);
        gfx.drawLine(l, i1 + 113, c1, 0);
        gfx.drawText("Magic", l + c1 / 4, i1 + 16, 4, 0);
        gfx.drawText("Prayers", l + c1 / 4 + c1 / 2, i1 + 16, 4, 0);
        if(ebl == 0)
        {
            ebj.gfm(ebk);
            int l1 = 0;
            for(int l2 = 0; l2 < identify.spellCount; l2++)
            {
                String s1 = "@yel@";
                for(int k4 = 0; k4 < identify.aii[l2]; k4++)
                {
                    int j5 = identify.aik[l2][k4];
                    if(faf(j5, identify.ail[l2][k4]))
                        continue;
                    s1 = "@whi@";
                    break;
                }

                int k5 = currentStat[6];
                if(identify.spellLevel[l2] > k5)
                    s1 = "@bla@";
                ebj.gga(ebk, l1++, s1 + "Level " + identify.spellLevel[l2] + ": " + identify.spellName[l2]);
            }

            ebj.ged();
            int l3 = ebj.ggh(ebk);
            if(l3 != -1)
            {
                gfx.drawBoxText("Level " + identify.spellLevel[l3] + ": " + identify.spellName[l3], l + 2, i1 + 124, 1, 0xffff00);
                gfx.drawBoxText(identify.aml[l3], l + 2, i1 + 136, 0, 0xffffff);
                for(int l4 = 0; l4 < identify.aii[l3]; l4++)
                {
                    int l5 = identify.aik[l3][l4];
                    gfx.drawPicture(l + 2 + l4 * 44, i1 + 150, den + identify.ajf[l5]);
                    int i6 = invCount(l5);
                    int j6 = identify.ail[l3][l4];
                    String s3 = "@red@";
                    if(faf(l5, j6))
                        s3 = "@gre@";
                    gfx.drawBoxText(s3 + i6 + "/" + j6, l + 2 + l4 * 44, i1 + 150, 1, 0xffffff);
                }

            } else
            {
                gfx.drawBoxText("Point at a spell for a description", l + 2, i1 + 124, 1, 0);
            }
        }
        if(ebl == 1)
        {
            ebj.gfm(ebk);
            int i2 = 0;
            for(int i3 = 0; i3 < identify.ahc; i3++)
            {
                String s2 = "@whi@";
                if(identify.amh[i3] > playerStat[5])
                    s2 = "@bla@";
                if(dhe[i3])
                    s2 = "@gre@";
                ebj.gga(ebk, i2++, s2 + "Level " + identify.amh[i3] + ": " + identify.ahn[i3]);
            }

            ebj.ged();
            int i4 = ebj.ggh(ebk);
            if(i4 != -1)
            {
                gfx.drawText("Level " + identify.amh[i4] + ": " + identify.ahn[i4], l + c1 / 2, i1 + 130, 1, 0xffff00);
                gfx.drawText(identify.aia[i4], l + c1 / 2, i1 + 145, 0, 0xffffff);
                gfx.drawText("Drain rate: " + identify.ami[i4], l + c1 / 2, i1 + 160, 1, 0);
            } else
            {
                gfx.drawBoxText("Point at a prayer for a description", l + 2, i1 + 124, 1, 0);
            }
        }
        if(!arg0)
            return;
        l = super.mouseX - (((j) (gfx)).blg - 199);
        i1 = super.mouseY - 36;
        if(l >= 0 && i1 >= 0 && l < 196 && i1 < 182)
        {
            ebj.gea(l + (((j) (gfx)).blg - 199), i1 + 36, super.fkh, super.fkg);
            if(i1 <= 24 && ebd == 1)
                if(l < 98 && ebl == 1)
                {
                    ebl = 0;
                    ebj.gfn(ebk);
                } else
                if(l > 98 && ebl == 0)
                {
                    ebl = 1;
                    ebj.gfn(ebk);
                }
            if(ebd == 1 && ebl == 0)
            {
                int j2 = ebj.ggh(ebk);
                if(j2 != -1)
                {
                    int j3 = currentStat[6];
                    if(identify.spellLevel[j2] > j3)
                    {
                        displayMessage("Your magic ability is not high enough for this spell", 3);
                    } else
                    {
                        int j4;
                        for(j4 = 0; j4 < identify.aii[j2]; j4++)
                        {
                            int i5 = identify.aik[j2][j4];
                            if(faf(i5, identify.ail[j2][j4]))
                                continue;
                            displayMessage("You don't have all the reagents you need for this spell", 3);
                            j4 = -1;
                            break;
                        }

                        if(j4 == identify.aii[j2])
                        {
                            selectedSpell = j2;
                            selectedItem = -1;
                        }
                    }
                }
            }
            if(ebd == 1 && ebl == 1)
            {
                int k2 = ebj.ggh(ebk);
                if(k2 != -1)
                {
                    int k3 = playerStat[5];
                    if(identify.amh[k2] > k3)
                        displayMessage("Your prayer ability is not high enough for this prayer", 3);
                    else
                    if(currentStat[5] == 0)
                        displayMessage("You have run out of prayer points. Return to a church to recharge", 3);
                    else
                    if(dhe[k2])
                    {
                        super.connection.newID(162);
                        super.connection.addVar(k2);
                        super.connection.complete();
                        dhe[k2] = false;
                        fdb("prayeroff");
                    } else
                    {
                        super.connection.newID(202);
                        super.connection.addVar(k2);
                        super.connection.complete();
                        dhe[k2] = true;
                        fdb("prayeron");
                    }
                }
            }
            ebd = 0;
        }
    }

    public final void fdd()
    {
        try
        {
            if(gfx != null)
            {
                gfx.cbi();
                gfx.blm = null;
                gfx = null;
            }
            if(efn != null)
            {
                efn.bha();
                efn = null;
            }
            dkj = null;
            ddf = null;
            dkl = null;
            eba = null;
            player = null;
            dgj = null;
            npc = null;
            myPlayer = null;
            if(gameHandle != null)
            {
                gameHandle.gim = null;
                gameHandle.ghm = null;
                gameHandle.gih = null;
                gameHandle.gin = null;
                gameHandle = null;
            }
            System.gc();
            return;
        }
        catch(Exception _ex)
        {
            return;
        }
    }

    public final boolean fde(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, boolean arg6, 
            boolean arg7)
    {
        int l = gameHandle.gkb(arg0, arg1, arg2, arg3, arg4, arg5, djk, djl, arg6);
        if(l == -1)
            if(arg7)
            {
                l = 1;
                djk[0] = arg2;
                djl[0] = arg3;
            } else
            {
                return false;
            }
        l--;
        arg0 = djk[l];
        arg1 = djl[l];
        l--;
        if(arg7)
            super.connection.newID(226);
        else
            super.connection.newID(211);
        super.connection.addInt(arg0 + bigX);
        super.connection.addInt(arg1 + bigY);
        if(arg7 && l == -1 && (arg0 + bigX) % 5 == 0)
            l = 0;
        for(int i1 = l; i1 >= 0 && i1 > l - 25; i1--)
        {
            super.connection.addVar(djk[i1] - arg0);
            super.connection.addVar(djl[i1] - arg1);
        }
        super.connection.complete();
        eak = -24;
        eal = super.mouseX;
        eam = super.mouseY;
        return true;
    }

    public final boolean fdf(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, boolean arg6, 
            boolean arg7)
    {
        int l = gameHandle.gkb(arg0, arg1, arg2, arg3, arg4, arg5, djk, djl, arg6);
        if(l == -1)
            return false;
        l--;
        arg0 = djk[l];
        arg1 = djl[l];
        l--;
        if(arg7)
            super.connection.newID(226);
        else
            super.connection.newID(211);
        super.connection.addInt(arg0 + bigX);
        super.connection.addInt(arg1 + bigY);
        if(arg7 && l == -1 && (arg0 + bigX) % 5 == 0)
            l = 0;
        for(int i1 = l; i1 >= 0 && i1 > l - 25; i1--)
        {
            super.connection.addVar(djk[i1] - arg0);
            super.connection.addVar(djl[i1] - arg1);
        }

        super.connection.complete();
        eak = -24;
        eal = super.mouseX;
        eam = super.mouseY;
        return true;
    }

    public final boolean fdg(int arg0, int arg1)
    {
		loading = false;
        if(dfl != 0)
        {
            gameHandle.gie = false;
            return false;
        }
        dcj = false;
        arg0 += dnd;
        arg1 += dne;
        if(dng == din && arg0 > ddj && arg0 < ddl && arg1 > ddk && arg1 < ddm)
        {
            gameHandle.gie = true;
            return false;
        }
		loading = true;
        gfx.drawText("Loading... Please wait", 256, 192, 1, 0xffffff);
        fcm();
        gfx.drawGame(dci, 0, 0);
        int l = bigX;
        int i1 = bigY;
        int j1 = (arg0 + 24) / 48;
        int k1 = (arg1 + 24) / 48;
        dng = din;
        bigX = j1 * 48 - 48;
        bigY = k1 * 48 - 48;
        ddj = j1 * 48 - 32;
        ddk = k1 * 48 - 32;
        ddl = j1 * 48 + 32;
        ddm = k1 * 48 + 32;
        gameHandle.gkf(arg0, arg1, dng);
        bigX -= dnd;
        bigY -= dne;
        int l1 = bigX - l;
        int i2 = bigY - i1;
        for(int j2 = 0; j2 < objectCount; j2++)
        {
            objectX[j2] -= l1;
            objectY[j2] -= i2;
            int k2 = objectX[j2];
            int i3 = objectY[j2];
            int l3 = objectType[j2];
            i k4 = ddf[j2];
            try
            {
                int j5 = objectID[j2];
                int i6;
                int l6;
                if(j5 == 0 || j5 == 4)
                {
                    i6 = identify.all[l3];
                    l6 = identify.alm[l3];
                } else
                {
                    l6 = identify.all[l3];
                    i6 = identify.alm[l3];
                }
                int i7 = ((k2 + k2 + i6) * magicLoc) / 2;
                int j7 = ((i3 + i3 + l6) * magicLoc) / 2;
                if(k2 >= 0 && i3 >= 0 && k2 < 96 && i3 < 96)
                {
                    efn.bgm(k4);
                    k4.cml(i7, -gameHandle.gla(i7, j7), j7);
                    gameHandle.gjj(k2, i3, l3);
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

        for(int l2 = 0; l2 < doorCount; l2++)
        {
            doorX[l2] -= l1;
            doorY[l2] -= i2;
            int j3 = doorX[l2];
            int i4 = doorY[l2];
            int l4 = doorType[l2];
            int k5 = doorDir[l2];
            try
            {
                gameHandle.gkj(j3, i4, k5, l4);
                i j6 = feg(j3, i4, k5, l4, l2);
                dkl[l2] = j6;
            }
            catch(RuntimeException runtimeexception1)
            {
                System.out.println("Bound Error: " + runtimeexception1.getMessage());
                runtimeexception1.printStackTrace();
            }
        }

        for(int k3 = 0; k3 < itemCount; k3++)
        {
            itemX[k3] -= l1;
            itemY[k3] -= i2;
        }

        for(int j4 = 0; j4 < playerCount; j4++)
        {
            f f1 = player[j4];
            f1.x -= l1 * magicLoc;
            f1.y -= i2 * magicLoc;
            for(int l5 = 0; l5 <= f1.miniWalk; l5++)
            {
                f1.gnb[l5] -= l1 * magicLoc;
                f1.gnc[l5] -= i2 * magicLoc;
            }

        }

        for(int i5 = 0; i5 < npcCount; i5++)
        {
            f f2 = npc[i5];
            f2.x -= l1 * magicLoc;
            f2.y -= i2 * magicLoc;
            for(int k6 = 0; k6 <= f2.miniWalk; k6++)
            {
                f2.gnb[k6] -= l1 * magicLoc;
                f2.gnc[k6] -= i2 * magicLoc;
            }

        }

        gameHandle.gie = true;
        return true;
    }

    public final void fdh()
    {
        int l = 0;
        byte byte0 = 50;
        byte byte1 = 50;
        gameHandle.gkf(byte0 * 48 + 23, byte1 * 48 + 23, l);
        gameHandle.gle(dkj);
        char c1 = '\u2600';
        char c2 = '\u1900';
        char c3 = '\u044C';
        char c4 = '\u0378';
		if (fogOfWar)
		{
			efn.bbg = 4100;
			efn.bbh = 4100;
			efn.bbi = 1;
			efn.bbj = 4000;
		} else {
			efn.bbg = 40000;
			efn.bbh = 40000;
			efn.bbi = 40000;
			efn.bbj = 40000;
		}
        efn.bin(c1, -gameHandle.gla(c1, c2), c2, zRot, c4, 0, c3 * 2);
        efn.bib();
        gfx.clear();
        gfx.clear();
        gfx.drawBox(0, 0, 512, 6, 0);
        for(int i1 = 6; i1 >= 1; i1--)
            gfx.cbg(0, i1, 0, i1, 512, 8);

        gfx.drawBox(0, 194, 512, 20, 0);
        for(int j1 = 6; j1 >= 1; j1--)
            gfx.cbg(0, j1, 0, 194 - j1, 512, 8);

        gfx.drawPicture(15, 15, del + 10);
        gfx.cca(dfd, 0, 0, 512, 200);
        gfx.cbl(dfd);
        c1 = '\u2400';
        c2 = '\u2400';
        c3 = '\u044C';
        c4 = '\u0378';
		if (fogOfWar)
		{
			efn.bbg = 2100;
			efn.bbh = 2100;
			efn.bbi = 1;
			efn.bbj = 2000;
		} else {
			efn.bbg = 40000;
			efn.bbh = 40000;
			efn.bbi = 40000;
			efn.bbj = 40000;
		}
        efn.bin(c1, -gameHandle.gla(c1, c2), c2, zRot, c4, 0, c3 * 2);
        efn.bib();
        gfx.clear();
        gfx.clear();
        gfx.drawBox(0, 0, 512, 6, 0);
        for(int k1 = 6; k1 >= 1; k1--)
            gfx.cbg(0, k1, 0, k1, 512, 8);

        gfx.drawBox(0, 194, 512, 20, 0);
        for(int l1 = 6; l1 >= 1; l1--)
            gfx.cbg(0, l1, 0, 194 - l1, 512, 8);

        gfx.drawPicture(15, 15, del + 10);
        gfx.cca(dfd + 1, 0, 0, 512, 200);
        gfx.cbl(dfd + 1);
        for(int i2 = 0; i2 < 64; i2++)
        {
            efn.bgn(gameHandle.gih[0][i2]);
            efn.bgn(gameHandle.ghm[1][i2]);
            efn.bgn(gameHandle.gih[1][i2]);
            efn.bgn(gameHandle.ghm[2][i2]);
            efn.bgn(gameHandle.gih[2][i2]);
        }

        c1 = '\u2B80';
        c2 = '\u2880';
        c3 = '\u01F4';
        c4 = '\u0178';
		if (fogOfWar)
		{
			efn.bbg = 2100;
			efn.bbh = 2100;
			efn.bbi = 1;
			efn.bbj = 2000;
		} else {
			efn.bbg = 40000;
			efn.bbh = 40000;
			efn.bbi = 40000;
			efn.bbj = 40000;
		}
        efn.bin(c1, -gameHandle.gla(c1, c2), c2, zRot, c4, 0, c3 * 2);
        efn.bib();
        gfx.clear();
        gfx.clear();
        gfx.drawBox(0, 0, 512, 6, 0);
        for(int j2 = 6; j2 >= 1; j2--)
            gfx.cbg(0, j2, 0, j2, 512, 8);

        gfx.drawBox(0, 194, 512, 20, 0);
        for(int k2 = 6; k2 >= 1; k2--)
            gfx.cbg(0, k2, 0, 194, 512, 8);

        gfx.drawPicture(15, 15, del + 10);
        gfx.cca(del + 10, 0, 0, 512, 200);
        gfx.cbl(del + 10);
    }

    public final String fdi(int l)
    {
        if(link.fni != null)
            return link.gai(t.fnb(l));
        else
            return t.fnb(l);
    }

    protected final void adc()
    {
        edh = 0;
        fightMode = 0;
        dhf = 0;
        ehl = 0;
        loggedIn = 1;
        fbl();
        gfx.cak();
        gfx.drawGame(dci, 0, 0);
        for(int l = 0; l < objectCount; l++)
        {
            efn.bgn(ddf[l]);
            gameHandle.gkg(objectX[l], objectY[l], objectType[l]);
        }

        for(int i1 = 0; i1 < doorCount; i1++)
        {
            efn.bgn(dkl[i1]);
            gameHandle.gke(doorX[i1], doorY[i1], doorDir[i1], doorType[i1]);
        }

        objectCount = 0;
        doorCount = 0;
        itemCount = 0;
        playerCount = 0;
        for(int j1 = 0; j1 < 4000; j1++)
            eba[j1] = null;

        for(int k1 = 0; k1 < 500; k1++)
            player[k1] = null;

        npcCount = 0;
        for(int l1 = 0; l1 < 5000; l1++)
            dgj[l1] = null;

        for(int i2 = 0; i2 < 500; i2++)
            npc[i2] = null;

        for(int j2 = 0; j2 < 50; j2++)
            dhe[j2] = false;

        ebd = 0;
        super.fkh = 0;
        super.fkg = 0;
        shop = false;
        bank = false;
        sleeping = false;
        super.friendCount = 0;
    }

    public final void fdj()
    {
        int l = 97;
        gfx.drawBox(86, 77, 340, 180, 0);
        gfx.drawBoxEdge(86, 77, 340, 180, 0xffffff);
        gfx.drawText("Warning! Proceed with caution", 256, l, 4, 0xff0000);
        l += 26;
        gfx.drawText("If you go much further north you will enter the", 256, l, 1, 0xffffff);
        l += 13;
        gfx.drawText("wilderness. This a very dangerous area where", 256, l, 1, 0xffffff);
        l += 13;
        gfx.drawText("other players can attack you!", 256, l, 1, 0xffffff);
        l += 22;
        gfx.drawText("The further north you go the more dangerous it", 256, l, 1, 0xffffff);
        l += 13;
        gfx.drawText("becomes, but the more treasure you will find.", 256, l, 1, 0xffffff);
        l += 22;
        gfx.drawText("In the wilderness an indicator at the bottom-right", 256, l, 1, 0xffffff);
        l += 13;
        gfx.drawText("of the screen will show the current level of danger", 256, l, 1, 0xffffff);
        l += 22;
        int i1 = 0xffffff;
        if(super.mouseY > l - 12 && super.mouseY <= l && super.mouseX > 181 && super.mouseX < 331)
            i1 = 0xff0000;
        gfx.drawText("Click here to close window", 256, l, 1, i1);
        if(ebd != 0)
        {
            if(super.mouseY > l - 12 && super.mouseY <= l && super.mouseX > 181 && super.mouseX < 331)
                dfj = 2;
            if(super.mouseX < 86 || super.mouseX > 426 || super.mouseY < 77 || super.mouseY > 257)
                dfj = 2;
            ebd = 0;
        }
    }

    final void fdk(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6)
    {
        f f1 = player[arg4];
        if(f1.hab == 255)
            return;
        int l = f1.sprite + (dke + 16) / 32 & 7;
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
        int j1 = i1 * 3 + efl[(f1.gmk / 6) % 4];
        if(f1.sprite == 8)
        {
            i1 = 5;
            l = 2;
            flag = false;
            arg0 -= (5 * arg6) / 100;
            j1 = i1 * 3 + dei[(dji / 5) % 8];
        } else
        if(f1.sprite == 9)
        {
            i1 = 5;
            l = 2;
            flag = true;
            arg0 += (5 * arg6) / 100;
            j1 = i1 * 3 + ded[(dji / 6) % 8];
        }
        for(int k1 = 0; k1 < 12; k1++)
        {
            int l1 = ddh[l][k1];
            int l2 = f1.gnd[l1] - 1;
            if(l2 >= 0)
            {
                int k3 = 0;
                int i4 = 0;
                int j4 = j1;
                if(flag && i1 >= 1 && i1 <= 3)
                    if(identify.anc[l2] == 1)
                        j4 += 15;
                    else
                    if(l1 == 4 && i1 == 1)
                    {
                        k3 = -22;
                        i4 = -3;
                        j4 = i1 * 3 + efl[(2 + f1.gmk / 6) % 4];
                    } else
                    if(l1 == 4 && i1 == 2)
                    {
                        k3 = 0;
                        i4 = -8;
                        j4 = i1 * 3 + efl[(2 + f1.gmk / 6) % 4];
                    } else
                    if(l1 == 4 && i1 == 3)
                    {
                        k3 = 26;
                        i4 = -5;
                        j4 = i1 * 3 + efl[(2 + f1.gmk / 6) % 4];
                    } else
                    if(l1 == 3 && i1 == 1)
                    {
                        k3 = 22;
                        i4 = 3;
                        j4 = i1 * 3 + efl[(2 + f1.gmk / 6) % 4];
                    } else
                    if(l1 == 3 && i1 == 2)
                    {
                        k3 = 0;
                        i4 = 8;
                        j4 = i1 * 3 + efl[(2 + f1.gmk / 6) % 4];
                    } else
                    if(l1 == 3 && i1 == 3)
                    {
                        k3 = -26;
                        i4 = 5;
                        j4 = i1 * 3 + efl[(2 + f1.gmk / 6) % 4];
                    }
                if(i1 != 5 || identify.anb[l2] == 1)
                {
                    int k4 = j4 + identify.and[l2];
                    k3 = (k3 * arg2) / ((j) (gfx)).bmj[k4];
                    i4 = (i4 * arg3) / ((j) (gfx)).bmk[k4];
                    int l4 = (arg2 * ((j) (gfx)).bmj[k4]) / ((j) (gfx)).bmj[identify.and[l2]];
                    k3 -= (l4 - arg2) / 2;
                    int i5 = identify.amn[l2];
                    int j5 = ekd[f1.hac];
                    if(i5 == 1)
                        i5 = dlj[f1.gnn];
                    else
                    if(i5 == 2)
                        i5 = deg[f1.haa];
                    else
                    if(i5 == 3)
                        i5 = deg[f1.hab];
                    gfx.cdd(arg0 + k3, arg1 + i4, l4, arg3, k4, i5, j5, arg5, flag);
                }
            }
        }

        if(f1.lastSaidTimeout > 0)
        {
            ebg[efd] = gfx.textWidth(f1.lastSaid, 1) / 2;
            if(ebg[efd] > 150)
                ebg[efd] = 150;
            ebh[efd] = (gfx.textWidth(f1.lastSaid, 1) / 300) * gfx.ced(1);
            ebe[efd] = arg0 + arg2 / 2;
            ebf[efd] = arg1;
            efe[efd++] = f1.lastSaid;
        }
        if(f1.gnh > 0)
        {
            eai[dln] = arg0 + arg2 / 2;
            eaj[dln] = arg1;
            eag[dln] = arg6;
            eah[dln++] = f1.gng;
        }
        if(f1.sprite == 8 || f1.sprite == 9 || f1.gnl != 0)
        {
            if(f1.gnl > 0)
            {
                int i2 = arg0;
                if(f1.sprite == 8)
                    i2 -= (20 * arg6) / 100;
                else
                if(f1.sprite == 9)
                    i2 += (20 * arg6) / 100;
                int i3 = (f1.gnj * 30) / f1.gnk;
                dfg[egl] = i2 + arg2 / 2;
                dfh[egl] = arg1;
                dfi[egl++] = i3;
            }
            if(f1.gnl > 150)
            {
                int j2 = arg0;
                if(f1.sprite == 8)
                    j2 -= (10 * arg6) / 100;
                else
                if(f1.sprite == 9)
                    j2 += (10 * arg6) / 100;
                gfx.drawPicture((j2 + arg2 / 2) - 12, (arg1 + arg3 / 2) - 12, del + 11);
                gfx.drawText(String.valueOf(f1.gni), (j2 + arg2 / 2) - 1, arg1 + arg3 / 2 + 5, 3, 0xffffff);
            }
        }
        if(f1.haj == 1 && f1.gnh == 0)
        {
            int k2 = arg5 + arg0 + arg2 / 2;
            if(f1.sprite == 8)
                k2 -= (20 * arg6) / 100;
            else
            if(f1.sprite == 9)
                k2 += (20 * arg6) / 100;
            int j3 = (16 * arg6) / 100;
            int l3 = (16 * arg6) / 100;
            gfx.ccc(k2 - j3 / 2, arg1 - l3 / 2 - (10 * arg6) / 100, j3, l3, del + 13);
        }
    }

    public final void fdl()
    {
        gfx.bnc = false;
        gfx.cak();
        dhi.ged();
        int l = 140;
        int i1 = 50;
        l += 116;
        i1 -= 25;
        gfx.ccf(l - 32 - 55, i1, 64, 102, identify.and[dhn], deg[dic]);
        gfx.cdd(l - 32 - 55, i1, 64, 102, identify.and[dhm], deg[dib], ekd[did], 0, false);
        gfx.cdd(l - 32 - 55, i1, 64, 102, identify.and[dhl], dlj[dia], ekd[did], 0, false);
        gfx.ccf(l - 32, i1, 64, 102, identify.and[dhn] + 6, deg[dic]);
        gfx.cdd(l - 32, i1, 64, 102, identify.and[dhm] + 6, deg[dib], ekd[did], 0, false);
        gfx.cdd(l - 32, i1, 64, 102, identify.and[dhl] + 6, dlj[dia], ekd[did], 0, false);
        gfx.ccf((l - 32) + 55, i1, 64, 102, identify.and[dhn] + 12, deg[dic]);
        gfx.cdd((l - 32) + 55, i1, 64, 102, identify.and[dhm] + 12, deg[dib], ekd[did], 0, false);
        gfx.cdd((l - 32) + 55, i1, 64, 102, identify.and[dhl] + 12, dlj[dia], ekd[did], 0, false);
        gfx.drawPicture(0, height, del + 22);
        gfx.drawGame(dci, 0, 0);
    }

    public final void fdm()
    {
        byte abyte0[] = enb("media" + w.cfb + ".jag", "2d graphics", 20);
        if(abyte0 == null)
        {
            ein = true;
            return;
        }
        byte abyte1[] = t.fng("index.dat", 0, abyte0);
        gfx.cbj(del, t.fng("inv1.dat", 0, abyte0), abyte1, 1);
        gfx.cbj(del + 1, t.fng("inv2.dat", 0, abyte0), abyte1, 6);
        gfx.cbj(del + 9, t.fng("bubble.dat", 0, abyte0), abyte1, 1);
        gfx.cbj(del + 10, t.fng("runescape.dat", 0, abyte0), abyte1, 1);
        gfx.cbj(del + 11, t.fng("splat.dat", 0, abyte0), abyte1, 3);
        gfx.cbj(del + 14, t.fng("icon.dat", 0, abyte0), abyte1, 8);
        gfx.cbj(del + 22, t.fng("hbar.dat", 0, abyte0), abyte1, 1);
        gfx.cbj(del + 23, t.fng("hbar2.dat", 0, abyte0), abyte1, 1);
        gfx.cbj(del + 24, t.fng("compass.dat", 0, abyte0), abyte1, 1);
        gfx.cbj(del + 25, t.fng("buttons.dat", 0, abyte0), abyte1, 2);
        gfx.cbj(dem, t.fng("scrollbar.dat", 0, abyte0), abyte1, 2);
        gfx.cbj(dem + 2, t.fng("corners.dat", 0, abyte0), abyte1, 4);
        gfx.cbj(dem + 6, t.fng("arrows.dat", 0, abyte0), abyte1, 2);
        gfx.cbj(dfa, t.fng("projectile.dat", 0, abyte0), abyte1, identify.ahg);
        int l = identify.aje;
        for(int i1 = 1; l > 0; i1++)
        {
            int j1 = l;
            l -= 30;
            if(j1 > 30)
                j1 = 30;
            gfx.cbj(den + (i1 - 1) * 30, t.fng("objects" + i1 + ".dat", 0, abyte0), abyte1, j1);
        }

        gfx.cbm(del);
        gfx.cbm(del + 9);
        for(int k1 = 11; k1 <= 26; k1++)
            gfx.cbm(del + k1);

        for(int l1 = 0; l1 < identify.ahg; l1++)
            gfx.cbm(dfa + l1);

        for(int i2 = 0; i2 < identify.aje; i2++)
            gfx.cbm(den + i2);

    }

    public final void fdn(int l, int i1, int j1, int k1, boolean flag)
    {
        if(fdf(l, i1, j1, k1, j1, k1, false, flag))
        {
            return;
        } else
        {
            fde(l, i1, j1, k1, j1, k1, true, flag);
            return;
        }
    }

    protected final void fea(int l)
    {
        if(loggedIn == 0)
        {
            if(ehl == 0)
                menuMain.gec(l);
            if(ehl == 1)
                menuNewAccount.gec(l);
            if(ehl == 2)
                menuLogin.gec(l);
        }
        if(loggedIn == 1)
        {
            if(efc)
            {
                dhi.gec(l);
                return;
            }
            if(efm == 0 && egc == 0 && !sleeping)
                elg.gec(l);
        }
    }

    public final void displayMessage(String arg0, int arg1)
    {
		if (arg1 == 4 && arg0.indexOf(": wishes to trade with you") >= 0 && macro != null && running)
			macro.tradeRequest(arg0.substring(5,arg0.indexOf(": wishes")-1).trim());
		if (arg1 == 4 && arg0.indexOf(")@whi@ wishes to duel with you") >= 0 && macro != null && running)
			if(arg0.substring(5,arg0.indexOf("(level-")-1).trim().indexOf("@") >= 0)
				macro.duelRequest(arg0.substring(5,arg0.indexOf("(level-")-6).trim());
			else
				macro.duelRequest(arg0.substring(5,arg0.indexOf("(level-")-1).trim());
		if (arg1 == 6)
		{
			if(arg0.indexOf("tells you") >= 0)
			{
				lastPMer = arg0.substring(0,arg0.indexOf(": tells you"));
				while(lastPMer.indexOf("@") >= 0)
					lastPMer = lastPMer.substring(lastPMer.indexOf("@")+1);
				lastPM = arg0.substring(arg0.indexOf(": tells you ")+": tells you ".length()).trim();
			}
		}
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
        if(ell != 0)
        {
            if(arg1 == 4 || arg1 == 3)
                ehc = 200;
            if(arg1 == 2 && ell != 1)
                ehd = 200;
            if(arg1 == 5 && ell != 2)
                ehe = 200;
            if(arg1 == 6 && ell != 3)
                ehf = 200;
            if(arg1 == 3 && ell != 0)
                ell = 0;
            if(arg1 == 6 && ell != 3 && ell != 0)
                ell = 0;
        }
        for(int i1 = 4; i1 > 0; i1--)
        {
            egb[i1] = egb[i1 - 1];
            def[i1] = def[i1 - 1];
        }

        egb[0] = arg0;
        def[0] = 300;
        if(arg1 == 2)
            if(elg.gbc[elh] == elg.gbd[elh] - 4)
                elg.ggb(elh, arg0, true);
            else
                elg.ggb(elh, arg0, false);
        if(arg1 == 5)
            if(elg.gbc[elj] == elg.gbd[elj] - 4)
                elg.ggb(elj, arg0, true);
            else
                elg.ggb(elj, arg0, false);
        if(arg1 == 6)
        {
            if(elg.gbc[elk] == elg.gbd[elk] - 4)
            {
                elg.ggb(elk, arg0, true);
                return;
            }
            elg.ggb(elk, arg0, false);
        }
    }

    public final void fec()
    {
        byte abyte0[] = null;
        byte abyte1[] = null;
        abyte0 = enb("entity" + w.cfe + ".jag", "people and monsters", 30);
        if(abyte0 == null)
        {
            ein = true;
            return;
        }
        abyte1 = t.fng("index.dat", 0, abyte0);
        byte abyte2[] = null;
        byte abyte3[] = null;
        if(member)
        {
            abyte2 = enb("entity" + w.cfe + ".mem", "member graphics", 45);
            if(abyte2 == null)
            {
                ein = true;
                return;
            }
            abyte3 = t.fng("index.dat", 0, abyte2);
        }
        int l = 0;
        eic = 0;
        eid = eic;
label0:
        for(int i1 = 0; i1 < identify.ake; i1++)
        {
            String s1 = identify.akb[i1];
            for(int j1 = 0; j1 < i1; j1++)
            {
                if(!identify.akb[j1].equalsIgnoreCase(s1))
                    continue;
                identify.and[i1] = identify.and[j1];
                continue label0;
            }

            byte abyte7[] = t.fng(s1 + ".dat", 0, abyte0);
            byte abyte4[] = abyte1;
            if(abyte7 == null && member)
            {
                abyte7 = t.fng(s1 + ".dat", 0, abyte2);
                abyte4 = abyte3;
            }
            if(abyte7 != null)
            {
                gfx.cbj(eid, abyte7, abyte4, 15);
                l += 15;
                if(identify.anb[i1] == 1)
                {
                    byte abyte8[] = t.fng(s1 + "a.dat", 0, abyte0);
                    byte abyte5[] = abyte1;
                    if(abyte8 == null && member)
                    {
                        abyte8 = t.fng(s1 + "a.dat", 0, abyte2);
                        abyte5 = abyte3;
                    }
                    gfx.cbj(eid + 15, abyte8, abyte5, 3);
                    l += 3;
                }
                if(identify.anc[i1] == 1)
                {
                    byte abyte9[] = t.fng(s1 + "f.dat", 0, abyte0);
                    byte abyte6[] = abyte1;
                    if(abyte9 == null && member)
                    {
                        abyte9 = t.fng(s1 + "f.dat", 0, abyte2);
                        abyte6 = abyte3;
                    }
                    gfx.cbj(eid + 18, abyte9, abyte6, 9);
                    l += 9;
                }
                if(identify.ana[i1] != 0)
                {
                    for(int k1 = eid; k1 < eid + 27; k1++)
                        gfx.cbm(k1);

                }
            }
            identify.and[i1] = eid;
            eid += 27;
        }
    }

    protected final void fed()
    {
        aca();
        fdd();
        if(deb != null)
            deb.ggl();
    }

    protected final void ada(String s1, String s2)
    {
        if(ehl == 1)
            menuNewAccount.ggc(eji, s1 + " " + s2);
        if(ehl == 2)
            menuLogin.ggc(elb, s1 + " " + s2);
        eim = s2;
        drawMenus();
        flf();
    }

    public final void fee()
    {
        byte abyte0[] = enb("textures" + w.cfd + ".jag", "Textures", 50);
        if(abyte0 == null)
        {
            ein = true;
            return;
        }
        byte abyte1[] = t.fng("index.dat", 0, abyte0);
        efn.bje(identify.amj, 7, 11);
        for(int l = 0; l < identify.amj; l++)
        {
            String s1 = identify.alg[l];
            byte abyte2[] = t.fng(s1 + ".dat", 0, abyte0);
            gfx.cbj(dfb, abyte2, abyte1, 1);
            gfx.drawBox(0, 0, 128, 128, 0xff00ff);
            gfx.drawPicture(0, 0, dfb);
            int i1 = ((j) (gfx)).bmj[dfb];
            String s2 = identify.alh[l];
            if(s2 != null && s2.length() > 0)
            {
                byte abyte3[] = t.fng(s2 + ".dat", 0, abyte0);
                gfx.cbj(dfb, abyte3, abyte1, 1);
                gfx.drawPicture(0, 0, dfb);
            }
            gfx.cca(dfc + l, 0, 0, i1, i1);
            int j1 = i1 * i1;
            for(int k1 = 0; k1 < j1; k1++)
                if(((j) (gfx)).bmc[dfc + l][k1] == 65280)
                    ((j) (gfx)).bmc[dfc + l][k1] = 0xff00ff;

            gfx.cbl(dfc + l);
            efn.bjf(l, ((j) (gfx)).bmd[dfc + l], ((j) (gfx)).bme[dfc + l], i1 / 64 - 1);
        }

    }

    protected final Socket fef(String arg0, int arg1)
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
        if(application())
            socket1 = new Socket(InetAddress.getByName(getCodeBase().getHost()), arg1);
        else
            socket1 = new Socket(InetAddress.getByName(arg0), arg1);
        socket1.setSoTimeout(30000);
        socket1.setTcpNoDelay(true);
        return socket1;
    }

    public final i feg(int l, int i1, int j1, int k1, int l1)
    {
        int i2 = l;
        int j2 = i1;
        int k2 = l;
        int l2 = i1;
        int i3 = identify.akg[k1];
        int j3 = identify.akh[k1];
        int k3 = identify.akf[k1];
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
        i2 *= magicLoc;
        j2 *= magicLoc;
        k2 *= magicLoc;
        l2 *= magicLoc;
        int i4 = l3.cln(i2, -gameHandle.gla(i2, j2), j2);
        int j4 = l3.cln(i2, -gameHandle.gla(i2, j2) - k3, j2);
        int k4 = l3.cln(k2, -gameHandle.gla(k2, l2) - k3, l2);
        int l4 = l3.cln(k2, -gameHandle.gla(k2, l2), l2);
        int ai[] = {
            i4, j4, k4, l4
        };
        l3.cmb(4, ai, i3, j3);
        l3.cme(false, 60, 24, -50, -10, -50);
        if(l >= 0 && i1 >= 0 && l < 96 && i1 < 96)
            efn.bgm(l3);
        l3.chk = l1 + 10000;
        return l3;
    }

    public mudclient()
    {
		Zb = new byte[10200];
        menuType = new int[250];
        dcj = false;
        width = 512;
        height = 334;
        dcn = 9;
        dda = new int[250];
        dde = new int[500];
        ddf = new i[1500];
        ddg = "";
        npc = new f[500];
        ddn = "";
        dea = false;
        def = new int[5];
        duel = false;
        member = false;
        dek = false;
        dfg = new int[50];
        dfh = new int[50];
        dfi = new int[50];
        questMenuAnswer = new String[5];
        menuID = new int[250];
        menuVar = new int[250];
        menuVar2 = new int[250];
        dgb = new int[50];
        myPlayer = new f();
        dgf = -1;
        dgh = new int[8];
        dgi = new int[8];
        dgj = new f[5000];
        doorX = new int[500];
        doorY = new int[500];
        duelAccepted = false;
        myPlayerAcceptedDuel = false;
        dhc = new int[8];
        dhd = new int[8];
        dhe = new boolean[50];
        dhg = false;
        dhh = true;
        zoom = 550;
        dhm = 1;
        dhn = 2;
        dia = 2;
        dib = 8;
        dic = 14;
        die = 1;
        dik = new int[99];
        din = -1;
        menuDescription = new String[250];
        djb = false;
        djc = false;
        username = "";
        password = "";
        shop = false;
        djj = false;
        djk = new int[8000];
        djl = new int[8000];
        shopItem = new int[256];
        shopItemCount = new int[256];
        dka = new int[256];
        myTradeItem = new int[14];
        myTradeItemValue = new int[14];
        dke = 128;
        myDuelItem = new int[8];
        myDuelItemValue = new int[8];
        dkj = new i[1000];
        dkk = new boolean[50];
        dkl = new i[500];
        noRetreat = false;
        noMagic = false;
        noPrayer = false;
        noWeapons = false;
        dle = true;
        statExperience = new int[18];
        questMenu = false;
        dlk = 30;
        duelSecondScreen = false;
        myPlayerAcceptedDuelSecondScreen = false;
        selectedBank = -1;
        dmb = -2;
        dme = new int[8192];
        dmf = new int[8192];
        dmg = -1;
        dmh = -1;
        dmi = -1;
        dmk = 0xbc614e;
        selectedShop = -1;
        dmm = -2;
        dmn = new f[500];
        dna = new int[50];
        dnb = 48;
        dnc = new int[50];
        dng = -1;
        dnl = new boolean[500];
        eab = false;
        eag = new int[50];
        eah = new int[50];
        eai = new int[50];
        eaj = new int[50];
        eba = new f[4000];
        ebb = new int[5];
        ebc = 40;
        ebe = new int[50];
        ebf = new int[50];
        ebg = new int[50];
        ebh = new int[50];
        objectX = new int[1500];
        objectY = new int[1500];
        objectType = new int[1500];
        objectID = new int[1500];
        menuText = new String[250];
        sleeping = false;
        ecf = new int[256];
        ecg = new int[256];
        eci = "";
        magicLoc = 128;
        ecm = new int[14];
        ecn = new int[14];
        bankType = new int[256];
        bankCount = new int[256];
        tradeAccepted = false;
        myPlayerAcceptedTrade = false;
        selectedSpell = -1;
        duelItem = new int[8];
        duelItemValue = new int[8];
        eeb = 2;
        efb = true;
        efc = false;
        efe = new String[50];
        trade = false;
        playerStat = new int[18];
        ega = false;
        egb = new String[5];
        player = new f[500];
        egg = 2;
        egi = new int[14];
        egj = new int[14];
        currentStat = new int[18];
        egm = new boolean[1500];
        tradeSecondScreen = false;
        myPlayerAcceptedTradeSecondScreen = false;
        menuX = new int[250];
        menuY = new int[250];
        selectedItem = -1;
        selectedItemName = "";
        eii = new f[500];
        doorDir = new int[500];
        doorType = new int[500];
        eil = "";
        eim = "";
        ein = false;
        inv = new int[35];
        invValue = new int[35];
        wearing = new int[35];
        ejf = new int[14];
        ejg = new int[14];
        ejl = false;
        ejm = false;
        duelingWithName = "";
        eki = false;
        itemX = new int[5000];
        itemY = new int[5000];
        itemType = new int[5000];
        ekm = new int[5000];
        ekn = new int[50];
        elm = false;
        eln = "";
        ema = 1;
        bank = false;
    }

    public final int dbi = 250;
    public final int dbj = 5;
    public final int dbk = 50;
    public final int dbl = 18;
    public final int dbm = 500;
    public final int dbn = 1500;
    public final int dca = 5000;
    public final int dcb = 5000;
    public final int dcc = 500;
    public final int dcd = 4000;
    public final int dce = 500;
    public final int dcf = 8000;
    public int dcg;
    public int menuType[];
    public Graphics dci;
    public boolean dcj;
    public int fightMode;
    public int width;
    public int height;
    public int dcn;
    public int dda[];
    public int ddb;
    public int ddc;
    public int ddd;
    public int dde[];
    public i ddf[];
    public String ddg;
    public int ddh[][] = {
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
    public f npc[];
    public int ddj;
    public int ddk;
    public int ddl;
    public int ddm;
    public String ddn;
    public boolean dea;
    public d deb;
    public int dec;
    public int ded[] = {
        0, 0, 0, 0, 0, 1, 2, 1
    };
    public int questMenuCount;
    public int def[];
    public final int deg[] = {
        0xff0000, 0xff8000, 0xffe000, 0xa0e000, 57344, 32768, 41088, 45311, 33023, 12528, 
        0xe000e0, 0x303030, 0x604000, 0x805000, 0xffffff
    };
    public boolean duel;
    public int dei[] = {
        0, 1, 2, 1, 0, 0, 0, 0
    };
    public boolean member;
    public boolean dek;
    public int del;
    public int dem;
    public int den;
    public int dfa;
    public int dfb;
    public int dfc;
    public int dfd;
    public int dfe;
    public int dff;
    public int dfg[];
    public int dfh[];
    public int dfi[];
    public int dfj;
    public String questMenuAnswer[];
    public int dfl;
    public int menuID[];
    public int menuVar[];
    public int menuVar2[];
    public int dgb[];
    public f myPlayer;
    int smallX;
    int smallY;
    int dgf;
    public int dgg;
    public int dgh[];
    public int dgi[];
    public f dgj[];
    public int doorX[];
    public int doorY[];
    public boolean duelAccepted;
    public boolean myPlayerAcceptedDuel;
    public int dha;
    public int dhb;
    public int dhc[];
    public int dhd[];
    public boolean dhe[];
    public int dhf;
    public boolean dhg;
    public boolean dhh;
    public h dhi;
    public int zoom;
    public int questPoints;
    public int dhl;
    public int dhm;
    public int dhn;
    public int dia;
    public int dib;
    public int dic;
    public int did;
    public int die;
    public int dif;
    public h dig;
    int dih;
    int dii;
    public int dij;
    public int dik[];
    public int bigX;
    public int bigY;
    public int din;
    public String menuDescription[];
    public boolean djb;
    public boolean djc;
    public int objectCount;
    public int selectedMenu;
    public String username;
    public String password;
    public boolean shop;
    public int dji;
    public boolean djj;
    public int djk[];
    public int djl[];
    public int shopItem[];
    public int shopItemCount[];
    public int dka[];
    public int myTradeItemCount;
    public int myTradeItem[];
    public int myTradeItemValue[];
    public int dke;
    public h menuLogin;
    public int myDuelItemCount;
    public int myDuelItem[];
    public int myDuelItemValue[];
    public i dkj[];
    public boolean dkk[];
    public i dkl[];
    public int itemCount;
    public int dkn;
    public boolean noRetreat;
    public boolean noMagic;
    public boolean noPrayer;
    public boolean noWeapons;
    public boolean dle;
    public int statExperience[];
    public int dlg;
    public int dlh;
    public boolean questMenu;
    public final int dlj[] = {
        0xffc030, 0xffa040, 0x805030, 0x604020, 0x303030, 0xff6020, 0xff4000, 0xffffff, 65280, 65535
    };
    public int dlk;
    public boolean duelSecondScreen;
    public boolean myPlayerAcceptedDuelSecondScreen;
    public int dln;
    public int selectedBank;
    public int dmb;
    public h menuNewAccount;
    public int dmd;
    int dme[];
    int dmf[];
    public int dmg;
    public int dmh;
    public int dmi;
    public int bankTotal;
    public int dmk;
    public int selectedShop;
    public int dmm;
    public f dmn[];
    public int dna[];
    public int dnb;
    public int dnc[];
    public int dnd;
    public int dne;
    public int dnf;
    public int dng;
    public int dnh;
    public int dni;
    public int npcCount;
    public int dnk;
    public boolean dnl[];
    public byte dnm[];
    public int dnn;
    public int beginButtonHandle;
    public boolean eab;
    public int eac;
    public int ead;
    public int eae;
    public int eaf;
    public int eag[];
    public int eah[];
    public int eai[];
    public int eaj[];
    public int eak;
    int eal;
    int eam;
    public int ean;
    public f eba[];
    public int ebb[];
    public int ebc;
    public int ebd;
    public int ebe[];
    public int ebf[];
    public int ebg[];
    public int ebh[];
    public final String ebi[] = {
        "Attack", "Defense", "Strength", "Hits", "Ranged", "Prayer", "Magic", "Cooking", "Woodcutting", "Fletching", 
        "Fishing", "Firemaking", "Crafting", "Smithing", "Mining", "Herblaw", "Agility", "Thieving"
    };
    public h ebj;
    int ebk;
    int ebl;
    public int objectX[];
    public int objectY[];
    public int objectType[];
    public int objectID[];
    public String menuText[];
    public final String ecd[] = {
        "Black knight's fortress", "Cook's assistant", "Demon slayer", "Doric's quest", "The restless ghost", "Goblin diplomacy", "Ernest the chicken", "Imp catcher", "Pirate's treasure", "Prince Ali rescue", 
        "Romeo & Juliet", "Sheep shearer", "Shield of Arrav", "The knight's sword", "Vampire slayer", "Witch's potion", "Dragon slayer", "Witch's house (members)", "Lost city (members)", "Hero's quest (members)", 
        "Druidic ritual (members)", "Merlin's crystal (members)", "Scorpion catcher (members)", "Family crest (members)", "Tribal totem (members)", "Fishing contest (members)", "Monk's friend (members)", "Temple of Ikov (members)", "Clock tower (members)", "The Holy Grail (members)", 
        "Fight Arena (members)", "Tree Gnome Village (members)", "The Hazeel Cult (members)", "Sheep Herder (members)", "Plague City (members)", "Sea Slug (members)", "Waterfall quest (members)", "Biohazard (members)", "Jungle potion (members)", "Grand tree (members)", 
        "Shilo village (members)", "Underground pass (members)", "Observatory quest (members)", "Tourist trap (members)", "Watchtower (members)", "Dwarf Cannon (members)", "Murder Mystery (members)", "Digsite (members)", "Gertrude's Cat (members)", "Legend's Quest (members)"
    };
    public boolean sleeping;
    public int ecf[];
    public int ecg[];
    public final String ech[] = {
        "Attack", "Defense", "Strength", "Hits", "Ranged", "Prayer", "Magic", "Cooking", "Woodcut", "Fletching", 
        "Fishing", "Firemaking", "Crafting", "Smithing", "Mining", "Herblaw", "Agility", "Thieving"
    };
    public String eci;
    public int magicLoc;
    public int loggedIn;
    public int ecl;
    public int ecm[];
    public int ecn[];
    public int eda;
    public int bankType[];
    public int bankCount[];
    public String edd;
    public boolean tradeAccepted;
    public boolean myPlayerAcceptedTrade;
    public int selectedSpell;
    public int edh;
    public int edi;
    public int edj;
    public int edk;
    public int duelItemCount;
    public int duelItem[];
    public int duelItemValue[];
    public int eea;
    public int eeb;
    public int eec;
    public int eed;
    public int eee;
    public int eef;
    public int eeg;
    public int eeh;
    public int eei;
    public int eej;
    public int eek;
    public int eel;
    public int eem;
    public int een;
    public int efa;
    public boolean efb;
    public boolean efc;
    public int efd;
    String efe[];
    public boolean trade;
    public int playerCount;
    public int efh;
    public int efi;
    public k gfx;
    public int playerStat[];
    public int efl[] = {
        0, 1, 2, 1
    };
    public int efm;
    public n efn;
    public boolean ega;
    public String egb[];
    public int egc;
    public int egd;
    public f player[];
    public int egf;
    public int egg;
    public int egh;
    public int egi[];
    public int egj[];
    public int currentStat[];
    public int egl;
    public boolean egm[];
    public int doorCount;
    public int fatigue;
    public int tfatigue;
    public int ehc;
    public int ehd;
    public int ehe;
    public int ehf;
    public int ehg;
    public int ehh;
    public int ehi;
    public int ehj;
    public int menuCount;
    public int ehl;
    public h menuMain;
    public boolean tradeSecondScreen;
    public boolean myPlayerAcceptedTradeSecondScreen;
    public int eib;
    public int eic;
    public int eid;
    public int menuX[];
    public int menuY[];
    public int selectedItem;
    String selectedItemName;
    public f eii[];
    public int doorDir[];
    public int doorType[];
    public String eil;
    public String eim;
    public boolean ein;
    public int invCount;
    public int inv[];
    public int invValue[];
    public int wearing[];
    public int eje;
    public int ejf[];
    public int ejg[];
    public int ejh;
    public int eji;
    public int ejj;
    public x gameHandle;
    public boolean ejl;
    public boolean ejm;
    public h ejn;
    int eka;
    int ekb;
    long ekc;
    public final int ekd[] = {
        0xecded0, 0xccb366, 0xb38c40, 0x997326, 0x906020
    };
    public String eke;
    public long ekf;
    public String duelingWithName;
    public int ekh;
    public boolean eki;
    public int itemX[];
    public int itemY[];
    public int itemType[];
    public int ekm[];
    public int ekn[];
    public int ela;
    public int elb;
    public int elc;
    public int eld;
    public int ele;
    public int elf;
    public h elg;
    int elh;
    int eli;
    int elj;
    int elk;
    int ell;
    public boolean elm;
    public String eln;
    public int ema;
    public int emb;
    public boolean bank;
    public final String emd[] = {
        "Armour", "WeaponAim", "WeaponPower", "Magic", "Prayer"
    };
    public long eme;
    public final String emf[] = {
        "Where were you born?", "What was your first teachers name?", "What is your fathers middle name?", "Who was your first best friend?", "What is your favourite vacation spot?", "What is your mothers middle name?", "What was your first pets name?", "What was the name of your first school?", "What is your mothers maiden name?", "Who was your first boyfriend/girlfriend?", 
        "What was the first computer game you purchased?", "Who is your favourite actor/actress?", "Who is your favourite author?", "Who is your favourite musician?", "Who is your favourite cartoon character?", "What is your favourite book?", "What is your favourite food?", "What is your favourite movie?"
    };

	public void runCommand(String st)
	{
		st = st.substring(2).trim();
		String command;
		if (st.indexOf(" ") >= 0)
			command = st.substring(0,st.indexOf(" "));
		else
			command = st;
		if (!testCommands(st))
		{
			if (!running)
			{
				String parameters[] = st.substring(st.indexOf(" ")+1).split("#");
				for (int i = 0; i < parameters.length; i++)
					parameters[i] = parameters[i].trim();
				final String scriptCommand = command;
				final String scriptParameters[] = parameters;
				macro = (Script)macros.get(scriptCommand);
				if (macro == null)
					System.out.println("## Unable to find command \"" + scriptCommand + "\"");
				else {
					Thread thread = new Thread(new Runnable()
					{
						public void run()
						{
							System.out.println("## New script started, \"" + scriptCommand + "\"");
							if (scriptParameters != null)
								macro.start(scriptCommand,scriptParameters);
							else {
								final String blankScriptParameters[] = new String[0];
								macro.start(scriptCommand,blankScriptParameters);
							}
						}
					});
					running = true;
					thread.start();
					return;
				}
			} else
				System.out.println("## Script already running!");
		}
	}

	public boolean testCommands(String st)
	{
		if (st.equals("debug"))
		{
			debug = !debug;
			if (debug)
				System.out.println("## Debugging is now on");
			else
				System.out.println("## Debugging is now off");
			return true;
		}
		if (st.equals("stop"))
		{
			if (running)
			{
				running = false;
				System.out.println("## Script stopped");
			}
			return true;
		}
		if (st.equals("autologin"))
		{
			autoLogin = !autoLogin;
			if (autoLogin)
				System.out.println("## AutoLogin is now on");
			else
				System.out.println("## AutoLogin is now on");
			return true;
		}
		return false;
	}

	public synchronized boolean keyDown(Event e, int id)
	{
		if(debug)
			System.out.println("keypressed: " + id);
		if (id == 1002)
			zoomIn = true;
		if (id == 1003)
			zoomOut = true;
		if (id == 1004)
			zRotUp = true;
		if (id == 1005)
			zRotDown = true;
		if (id == 1009)
		{
			fogOfWar = !fogOfWar;
			if (fogOfWar)
				System.out.println("## Fog of war enabled");
			else
				System.out.println("## Fog of war disabled");
		}
		if (id == 1010)
		{
			graphicsEnabled = !graphicsEnabled;
			if (graphicsEnabled)
				System.out.println("## Graphics are now enabled!");
			else
				System.out.println("## Graphics are now disabled!");
		}
		if (id == 1011)
		{
			recordingSteps = !recordingSteps;
			if (recordingSteps)
			{
				System.out.println("## Recording your steps!");
				recordingStepLength = 0;
			}
			else
			{
				System.out.println("## Stopped recording steps -");
				if (recordingStepLength > 0)
				{
					String stepX = "int walkPathX[] = new int[] { ";
					for(int i = 0; i < recordingStepLength - 1; i++)
						stepX = stepX + recordingStepX[i] + ", ";
					stepX = stepX + recordingStepX[recordingStepLength-1] + " };";
					String stepY = "int walkPathY[] = new int[] { ";
					for(int i = 0; i < recordingStepLength - 1; i++)
						stepY = stepY + recordingStepY[i] + ", ";
					stepY = stepY + recordingStepY[recordingStepLength-1] + " };";
					System.out.println(stepX);
					System.out.println(stepY);
				}
			}
		}
		if (id == 1019)
		{
			autoLogin = !autoLogin;
			if (autoLogin)
				System.out.println("## AutoLogin is now on");
			else
				System.out.println("## AutoLogin is now off");
			return true;
		}
		return super.keyDown(e,id);
	}

	public synchronized boolean keyUp(Event e, int id)
	{
		if (id == 1002)
			zoomIn = false;
		if (id == 1003)
			zoomOut = false;
		if (id == 1004)
			zRotUp = false;
		if (id == 1005)
			zRotDown = false;
		return super.keyUp(e,id);
	}

	public void savepic(byte abyte0[])
    {
        int i1 = 1;
        byte byte0 = 0;
        int j1;
        for(j1 = 0; j1 < 255;)
        {
            int k1 = abyte0[i1++] & 0xff;
            for(int i2 = 0; i2 < k1; i2++)
                Zb[j1++] = byte0;

            byte0 = (byte)(255 - byte0);
        }

        for(int l1 = 1; l1 < 40; l1++)
        {
            for(int j2 = 0; j2 < 255;)
            {
                int k2 = abyte0[i1++] & 0xff;
                for(int l2 = 0; l2 < k2; l2++)
                {
                    Zb[j1] = Zb[j1 - 255];
                    j1++;
                    j2++;
                }

                if(j2 < 255)
                {
                    Zb[j1] = (byte)(255 - Zb[j1 - 255]);
                    j1++;
                    j2++;
                }
            }

        }
        File file = new File("slword.txt");
        if(file.exists())
            ec = file.lastModified();
        else
            ec = -1L;
        cc = false;
        dc = System.currentTimeMillis();

        System.out.println("Writing HC.BMP");
        a("HC.BMP", Zb);
	}

	byte Zb[];

	public void a(String s1, byte abyte0[])
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
            fileoutputstream.write(255); //255
            fileoutputstream.write(255); //255
            fileoutputstream.write(255); //255
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
			ioexception.toString();
            System.out.println("EXCEPTION");
        }
    }


	public void sleepword()
	{
		if ((tfatigue * 100) / 750 == 0)
		{
			try
			{
				File file = new File("slword.txt");
				if(file.exists() && ec != file.lastModified())
				{
					FileInputStream fileinputstream = new FileInputStream("slword.txt");
					int i1 = fileinputstream.available();
					if(i1 > 9)
						i1 = 9;
					ac = "";
					for(int j1 = 0; j1 < i1; j1++)
					{
						char c1 = (char)fileinputstream.read();
						if(c1 == '\n' || c1 == '\r')
						break;
						ac += c1;
					}

					fileinputstream.close();
					cc = true;
					System.out.println("Sleepword: " + ac);
				
					ec = file.lastModified();

                    super.connection.newID(18);
                    super.connection.hdk(ac);
                    super.connection.complete();
                    super.fkl = "";
                    super.fkm = "";
					eke = "Please wait...";
					dc = System.currentTimeMillis();
				}
			}
			catch (IOException e)
			{
				e.toString();
				System.out.println("IOException");	
			}
		}
	}

	long ec = -1L;
	boolean cc = true;
	long dc;
	String ac;

}
