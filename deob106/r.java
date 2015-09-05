// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import jagex.f;
import jagex.o;
import java.io.IOException;
import java.io.PrintStream;

public class r
{

    public static void fq()
    {
        try
        {
            dq(new f("../gamedata/config/projectile.txt"));
            cq(new f("../gamedata/config/entity.txt"));
            up(new f("../gamedata/config/objects.txt"));
            eq(new f("../gamedata/config/npc.txt"));
            pp(new f("../gamedata/config/location.txt"));
            zp(new f("../gamedata/config/boundary.txt"));
            op(new f("../gamedata/config/roof.txt"));
            sp(new f("../gamedata/config/floor.txt"));
            tp(new f("../gamedata/config/spells.txt"));
            aq(new f("../gamedata/config/shop.txt"));
            bq(new f("../gamedata/config/prayers.txt"));
            qp(new f("../gamedata/config/words.txt"));
            yp(new f("../gamedata/config/badwords.txt"));
            gq();
            return;
        }
        catch(IOException ioexception)
        {
            System.out.println("Error loading config files");
            ioexception.printStackTrace();
            return;
        }
    }

    public static void xp(byte abyte0[])
    {
        try
        {
            dq(new f(abyte0, o.nn("projectile.txt", abyte0)));
            cq(new f(abyte0, o.nn("entity.txt", abyte0)));
            up(new f(abyte0, o.nn("objects.txt", abyte0)));
            eq(new f(abyte0, o.nn("npc.txt", abyte0)));
            pp(new f(abyte0, o.nn("location.txt", abyte0)));
            zp(new f(abyte0, o.nn("boundary.txt", abyte0)));
            op(new f(abyte0, o.nn("roof.txt", abyte0)));
            sp(new f(abyte0, o.nn("floor.txt", abyte0)));
            tp(new f(abyte0, o.nn("spells.txt", abyte0)));
            aq(new f(abyte0, o.nn("shop.txt", abyte0)));
            bq(new f(abyte0, o.nn("prayers.txt", abyte0)));
            qp(new f(abyte0, o.nn("words.txt", abyte0)));
            yp(new f(abyte0, o.nn("badwords.txt", abyte0)));
            gq();
            return;
        }
        catch(IOException ioexception)
        {
            System.out.println("Error loading config files");
            ioexception.printStackTrace();
            return;
        }
    }

    public static void qp(f f1)
        throws IOException
    {
        do
        {
            try
            {
                String s = f1.fc();
                if(s.equals("-EOF-") || (s == null || s.length() <= 0))
                    break;
                tmb[smb++] = s;
                continue;
            }
            catch(Exception _ex) { }
            break;
        } while(true);
        System.out.println("Loaded " + smb + " allowed words");
        o.ufb = smb;
        o.vfb = tmb;
    }

    public static void yp(f f1)
        throws IOException
    {
        do
        {
            try
            {
                String s = f1.fc();
                if(s.equals("-EOF-") || (s == null || s.length() <= 0))
                    break;
                vmb[umb++] = s;
                continue;
            }
            catch(Exception _ex) { }
            break;
        } while(true);
        System.out.println("Loaded " + umb + " banned words");
        String as[] = {
            "a", "e", "i", "o", "u"
        };
        int i = umb;
        for(int j = 0; j < i; j++)
        {
            String s1 = vmb[j];
            if(s1.length() >= 5)
            {
                for(int k = 1; k < s1.length() - 1; k++)
                {
                    char c = s1.charAt(k);
                    if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y')
                    {
                        for(int l = 0; l < 5; l++)
                        {
                            String s2 = as[l];
                            if(s2.charAt(0) != c)
                            {
                                String s5 = s1.substring(0, k) + s2 + s1.substring(k + 1);
                                vmb[umb++] = s5;
                                s5 = s1.substring(0, k) + s2 + c + s1.substring(k + 1);
                                vmb[umb++] = s5;
                            }
                        }

                        String s3 = s1.substring(0, k) + s1.substring(k + 1);
                        vmb[umb++] = s3;
                    }
                    char c1 = s1.charAt(k + 1);
                    String s4 = s1.substring(0, k) + c1 + c + s1.substring(k + 2);
                    vmb[umb++] = s4;
                }

            }
        }

        System.out.println("Generated " + umb + " banned words");
        o.sfb = umb;
        o.tfb = vmb;
    }

    public static void aq(f f1)
        throws IOException
    {
        f1.zb();
        int i = f1.gc();
        dmb = i;
        System.out.println("Found " + i + " shops");
        emb = new String[i];
        fmb = new int[i];
        jmb = new int[i];
        gmb = new int[i];
        hmb = new int[i];
        imb = new int[i];
        kmb = new int[i][40];
        lmb = new int[i][40];
        mmb = new int[i][40];
        for(int j = 0; j < i; j++)
        {
            f1.zb();
            emb[j] = f1.ac();
            int k = fmb[j] = f1.gc();
            gmb[j] = f1.gc();
            hmb[j] = f1.gc();
            imb[j] = f1.gc();
            jmb[j] = f1.gc();
            for(int l = 0; l < k; l++)
            {
                f1.zb();
                kmb[j][l] = np(f1.ac());
                lmb[j][l] = f1.gc();
                mmb[j][l] = f1.gc();
            }

        }

    }

    public static void tp(f f1)
        throws IOException
    {
        f1.zb();
        int i = f1.gc();
        vlb = i;
        System.out.println("Found " + i + " spells");
        wlb = new String[i];
        xlb = new String[i];
        ylb = new int[i];
        amb = new int[i];
        zlb = new int[i];
        bmb = new int[i][];
        cmb = new int[i][];
        for(int j = 0; j < i; j++)
        {
            f1.zb();
            wlb[j] = f1.ac();
            ylb[j] = f1.gc();
            xlb[j] = f1.ac();
            amb[j] = f1.gc();
            f1.zb();
            int k = zlb[j] = f1.gc();
            bmb[j] = new int[k];
            cmb[j] = new int[k];
            for(int l = 0; l < k; l++)
            {
                bmb[j][l] = np(f1.ac());
                cmb[j][l] = f1.gc();
            }

        }

        f1.hb();
    }

    public static void bq(f f1)
        throws IOException
    {
        f1.zb();
        int i = f1.gc();
        nmb = i;
        System.out.println("Found " + i + " prayers");
        omb = new String[i];
        pmb = new String[i];
        qmb = new int[i];
        rmb = new int[i];
        for(int j = 0; j < i; j++)
        {
            f1.zb();
            omb[j] = f1.ac();
            qmb[j] = f1.gc();
            pmb[j] = f1.ac();
            rmb[j] = f1.gc();
        }

        f1.hb();
    }

    public static void dq(f f1)
        throws IOException
    {
        f1.zb();
        int i = f1.gc();
        llb = i;
        System.out.println("Found " + i + " projectiles");
        nlb = new String[i];
        olb = new String[i];
        plb = new int[i];
        qlb = new int[i];
        rlb = new int[i];
        slb = new int[i];
        tlb = new int[i];
        ulb = new int[i];
        for(int j = 0; j < i; j++)
        {
            f1.zb();
            nlb[j] = f1.ac();
            plb[j] = f1.gc();
            qlb[j] = f1.gc();
            rlb[j] = f1.gc();
            slb[j] = f1.gc();
            olb[j] = f1.ac();
            ulb[j] = f1.gc();
            if(plb[j] + 1 > mlb)
                mlb = plb[j] + 1;
        }

        f1.hb();
    }

    public static void gq()
    {
        for(int i = 0; i < llb; i++)
            tlb[i] = np(olb[i]);

    }

    public static void cq(f f1)
        throws IOException
    {
        f1.zb();
        int i = f1.gc();
        xjb = i;
        System.out.println("Found " + i + " entities");
        yjb = new String[i];
        zjb = new String[i];
        bkb = new int[i];
        akb = new int[i];
        ckb = new int[i];
        dkb = new int[i];
        ekb = new int[i];
        for(int j = 0; j < i; j++)
        {
            f1.zb();
            yjb[j] = f1.ac();
            zjb[j] = f1.ac();
            akb[j] = f1.lb();
            bkb[j] = f1.gc();
            ckb[j] = f1.gc();
            dkb[j] = f1.gc();
        }

        f1.hb();
    }

    public static void eq(f f1)
        throws IOException
    {
        f1.zb();
        int i = f1.gc();
        tib = i;
        System.out.println("Found " + i + " npcs");
        uib = new String[i][];
        vib = new String[i];
        wib = new int[i];
        xib = new int[i];
        yib = new int[i];
        zib = new int[i];
        ajb = new int[i];
        bjb = new int[i];
        cjb = new int[i];
        djb = new int[i];
        ejb = new int[i];
        fjb = new int[i];
        gjb = new int[i];
        hjb = new int[i];
        ijb = new int[i];
        jjb = new int[i];
        kjb = new int[i];
        ljb = new int[i][12];
        mjb = new int[i];
        njb = new int[i];
        ojb = new int[i];
        pjb = new int[i];
        qjb = new int[i];
        rjb = new int[i];
        sjb = new int[i];
        tjb = new int[i];
        ujb = new int[i];
        vjb = new int[i][];
        wjb = new int[i][];
        for(int j = 0; j < i; j++)
        {
            f1.zb();
            int k = f1.gc();
            uib[j] = new String[k];
            for(int l = 0; l < k; l++)
                uib[j][l] = f1.ac();

            vib[j] = f1.ac();
            f1.zb();
            wib[j] = f1.gc();
            xib[j] = f1.gc();
            yib[j] = f1.gc();
            zib[j] = f1.gc();
            ajb[j] = f1.gc();
            bjb[j] = f1.gc();
            cjb[j] = f1.gc();
            djb[j] = f1.gc();
            ejb[j] = f1.gc();
            fjb[j] = f1.gc();
            gjb[j] = f1.gc();
            hjb[j] = f1.gc();
            ijb[j] = f1.gc();
            jjb[j] = f1.gc();
            kjb[j] = f1.gc();
            f1.zb();
            for(int i1 = 0; i1 < 12; i1++)
                ljb[j][i1] = wp(f1.ac());

            mjb[j] = f1.lb();
            njb[j] = f1.lb();
            ojb[j] = f1.lb();
            pjb[j] = f1.lb();
            f1.zb();
            qjb[j] = f1.gc();
            rjb[j] = f1.gc();
            sjb[j] = f1.gc();
            tjb[j] = f1.gc();
            ujb[j] = f1.gc();
            f1.zb();
            int j1 = f1.gc();
            vjb[j] = new int[j1];
            wjb[j] = new int[j1];
            for(int k1 = 0; k1 < j1; k1++)
            {
                vjb[j][k1] = np(f1.ac());
                wjb[j][k1] = f1.gc();
            }

        }

        f1.hb();
    }

    public static void up(f f1)
        throws IOException
    {
        f1.zb();
        int i = f1.gc();
        yhb = i;
        System.out.println("Found " + i + " objects");
        aib = new String[i][];
        bib = new String[i];
        dib = new String[i];
        eib = new int[i];
        fib = new int[i];
        gib = new int[i];
        hib = new int[i];
        iib = new int[i];
        jib = new int[i];
        kib = new int[i];
        lib = new int[i];
        mib = new int[i];
        nib = new int[i];
        oib = new int[i];
        pib = new int[i];
        qib = new int[i];
        rib = new int[i];
        sib = new int[i];
        for(int j = 0; j < i; j++)
        {
            f1.zb();
            int k = f1.gc();
            aib[j] = new String[k];
            for(int l = 0; l < k; l++)
                aib[j][l] = f1.ac();

            bib[j] = f1.ac();
            f1.zb();
            eib[j] = f1.gc();
            if(eib[j] >= zhb)
                zhb = eib[j] + 1;
            fib[j] = f1.gc();
            gib[j] = f1.gc();
            dib[j] = f1.ac();
            f1.zb();
            hib[j] = f1.gc();
            iib[j] = f1.gc();
            jib[j] = f1.gc();
            kib[j] = f1.gc();
            lib[j] = f1.gc();
            mib[j] = f1.gc();
            nib[j] = rp(f1.ac()) + 1;
            f1.zb();
            oib[j] = f1.gc();
            pib[j] = wp(f1.ac());
            qib[j] = f1.lb();
            rib[j] = f1.gc();
            sib[j] = f1.gc();
        }

        f1.hb();
    }

    public static void pp(f f1)
        throws IOException
    {
        f1.zb();
        int i = f1.gc();
        fkb = i;
        System.out.println("Found " + i + " locations");
        gkb = new String[i][];
        hkb = new String[i];
        ikb = new String[i];
        jkb = new String[i];
        kkb = new int[i];
        lkb = new int[i];
        mkb = new int[i];
        nkb = new int[i];
        okb = new int[i];
        pkb = new int[i];
        for(int j = 0; j < i; j++)
        {
            f1.zb();
            int k = f1.gc();
            gkb[j] = new String[k];
            for(int l = 0; l < k; l++)
                gkb[j][l] = f1.ac();

            hkb[j] = f1.ac();
            f1.zb();
            kkb[j] = vp(f1.ac());
            lkb[j] = f1.gc();
            mkb[j] = f1.gc();
            nkb[j] = f1.gc();
            okb[j] = f1.gc();
            ikb[j] = f1.ac();
            if(ikb[j].equals("_"))
                ikb[j] = "WalkTo";
            jkb[j] = f1.ac();
            if(jkb[j].equals("_"))
                jkb[j] = "Examine";
            pkb[j] = f1.gc();
        }

        f1.hb();
    }

    public static void zp(f f1)
        throws IOException
    {
        f1.zb();
        int i = f1.gc();
        qkb = i;
        System.out.println("Found " + i + " boundaries");
        rkb = new String[i][];
        skb = new String[i];
        tkb = new String[i];
        ukb = new String[i];
        vkb = new int[i];
        wkb = new int[i];
        xkb = new int[i];
        ykb = new int[i];
        zkb = new int[i];
        alb = new int[i];
        for(int j = 0; j < i; j++)
        {
            f1.zb();
            int k = f1.gc();
            rkb[j] = new String[k];
            for(int l = 0; l < k; l++)
                rkb[j][l] = f1.ac();

            skb[j] = f1.ac();
            f1.zb();
            vkb[j] = f1.gc();
            wkb[j] = f1.gc();
            xkb[j] = f1.gc();
            ykb[j] = f1.gc();
            zkb[j] = f1.gc();
            alb[j] = f1.gc();
            tkb[j] = f1.ac();
            if(tkb[j].equals("_"))
                tkb[j] = "WalkTo";
            ukb[j] = f1.ac();
            if(ukb[j].equals("_"))
                ukb[j] = "Examine";
        }

        f1.hb();
    }

    public static void op(f f1)
        throws IOException
    {
        f1.zb();
        int i = f1.gc();
        blb = i;
        System.out.println("Found " + i + " roofs");
        clb = new String[i];
        dlb = new int[i];
        elb = new int[i];
        flb = new int[i];
        for(int j = 0; j < i; j++)
        {
            f1.zb();
            clb[j] = f1.ac();
            dlb[j] = f1.gc();
            elb[j] = f1.gc();
            flb[j] = f1.gc();
        }

        f1.hb();
    }

    public static void sp(f f1)
        throws IOException
    {
        f1.zb();
        int i = f1.gc();
        glb = i;
        System.out.println("Found " + i + " floors");
        hlb = new String[i];
        ilb = new int[i];
        jlb = new int[i];
        klb = new int[i];
        for(int j = 0; j < i; j++)
        {
            f1.zb();
            hlb[j] = f1.ac();
            ilb[j] = f1.gc();
            jlb[j] = f1.gc();
            klb[j] = f1.gc();
        }

        f1.hb();
    }

    public static int wp(String s)
    {
        if(s.equalsIgnoreCase("na"))
            return -1;
        for(int i = 0; i < xjb; i++)
            if(s.equalsIgnoreCase(yjb[i]))
                return i;

        System.out.println("WARNING: unable to match entity " + s);
        return 0;
    }

    public static int vp(String s)
    {
        if(s.equalsIgnoreCase("na"))
            return 0;
        for(int i = 0; i < ymb; i++)
            if(zmb[i].equalsIgnoreCase(s))
                return i;

        zmb[ymb++] = s;
        return ymb - 1;
    }

    public static int np(String s)
    {
        if(s.equalsIgnoreCase("na"))
            return 0;
        for(int i = 0; i < yhb; i++)
        {
            for(int j = 0; j < aib[i].length; j++)
                if(aib[i][j].equalsIgnoreCase(s))
                    return i;

        }

        System.out.println("WARNING: unable to match object: " + s);
        return 0;
    }

    public static int rp(String s)
    {
        if(s.equals("_"))
            return -1;
        for(int i = 0; i < llb; i++)
            if(nlb[i].equalsIgnoreCase(s))
                return i;

        System.out.println("WARNING: unable to match projectile: " + s);
        return -1;
    }

    public r()
    {
    }

    public final int xhb = 0xbc614e;
    public static int yhb;
    public static int zhb;
    public static String aib[][];
    public static String bib[];
    public static String cib[];
    public static String dib[];
    public static int eib[];
    public static int fib[];
    public static int gib[];
    public static int hib[];
    public static int iib[];
    public static int jib[];
    public static int kib[];
    public static int lib[];
    public static int mib[];
    public static int nib[];
    public static int oib[];
    public static int pib[];
    public static int qib[];
    public static int rib[];
    public static int sib[];
    public static int tib;
    public static String uib[][];
    public static String vib[];
    public static int wib[];
    public static int xib[];
    public static int yib[];
    public static int zib[];
    public static int ajb[];
    public static int bjb[];
    public static int cjb[];
    public static int djb[];
    public static int ejb[];
    public static int fjb[];
    public static int gjb[];
    public static int hjb[];
    public static int ijb[];
    public static int jjb[];
    public static int kjb[];
    public static int ljb[][];
    public static int mjb[];
    public static int njb[];
    public static int ojb[];
    public static int pjb[];
    public static int qjb[];
    public static int rjb[];
    public static int sjb[];
    public static int tjb[];
    public static int ujb[];
    public static int vjb[][];
    public static int wjb[][];
    public static int xjb;
    public static String yjb[];
    public static String zjb[];
    public static int akb[];
    public static int bkb[];
    public static int ckb[];
    public static int dkb[];
    public static int ekb[];
    public static int fkb;
    public static String gkb[][];
    public static String hkb[];
    public static String ikb[];
    public static String jkb[];
    public static int kkb[];
    public static int lkb[];
    public static int mkb[];
    public static int nkb[];
    public static int okb[];
    public static int pkb[];
    public static int qkb;
    public static String rkb[][];
    public static String skb[];
    public static String tkb[];
    public static String ukb[];
    public static int vkb[];
    public static int wkb[];
    public static int xkb[];
    public static int ykb[];
    public static int zkb[];
    public static int alb[];
    public static int blb;
    public static String clb[];
    public static int dlb[];
    public static int elb[];
    public static int flb[];
    public static int glb;
    public static String hlb[];
    public static int ilb[];
    public static int jlb[];
    public static int klb[];
    public static int llb;
    public static int mlb;
    public static String nlb[];
    public static String olb[];
    public static int plb[];
    public static int qlb[];
    public static int rlb[];
    public static int slb[];
    public static int tlb[];
    public static int ulb[];
    public static int vlb;
    public static String wlb[];
    public static String xlb[];
    public static int ylb[];
    public static int zlb[];
    public static int amb[];
    public static int bmb[][];
    public static int cmb[][];
    public static int dmb;
    public static String emb[];
    public static int fmb[];
    public static int gmb[];
    public static int hmb[];
    public static int imb[];
    public static int jmb[];
    public static int kmb[][];
    public static int lmb[][];
    public static int mmb[][];
    public static int nmb;
    public static String omb[];
    public static String pmb[];
    public static int qmb[];
    public static int rmb[];
    public static int smb;
    public static String tmb[] = new String[5000];
    public static int umb;
    public static String vmb[] = new String[5000];
    static String wmb[] = {
        "attack", "defense", "strength", "hits", "ranged", "prayer", "magic", "cooking", "woodcutting", "fletching", 
        "fishing", "firemaking", "crafting", "smithing", "mining", "herblaw"
    };
    public static String xmb[] = {
        "attack", "defense", "strength", "hits", "aggression", "bravery", "regenerate", "perception"
    };
    public static int ymb;
    public static String zmb[] = new String[200];

}
