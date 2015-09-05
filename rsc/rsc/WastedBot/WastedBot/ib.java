// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ib.java


public class ib extends Thread
{

    public void run()
    {
        int j;
        boolean flag;
label0:
        {
            flag = v.R;
            int i = f.J;
            if(f.lb[a.Kc] == 1)
            {
                j = 1;
                if(!flag)
                    break label0;
            }
            j = 50000;
        }
        int k;
label1:
        {
            if(a.Kc != -1)
            {
                k = a.q(a.Kc);
                if(!flag)
                    break label1;
            }
            k = -1;
        }
        if(j == 50000)
        {
            int i1 = k;
            do
            {
                if(i1 <= 0)
                    break;
                int l = a.q(a.Kc);
                int k1 = 0;
                int l1 = a.r(29);
                if(k1 > 29 && !flag)
                    break;
                if(l1 > 0)
                    i1 = 0;
                if(l >= 0 && l1 < 1)
                {
                    a.i(a.Kc, j);
                    i1 -= j;
                }
                if(l == 0 && !flag)
                    break;
                if(j == 1)
                    k1++;
                i1++;
                i1--;
            } while(!flag);
        }
        if(j == 1)
        {
            int j1 = a.pg;
            do
            {
                if(j1 >= 30)
                    break;
                a.i(a.Kc, j);
                j1++;
            } while(!flag);
        }
    }

    ib(mudclient mudclient1)
    {
        a = mudclient1;
        start();
    }

    private final mudclient a;
}
