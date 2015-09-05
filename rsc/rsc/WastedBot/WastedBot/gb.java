// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   gb.java


class gb extends Thread
{

    public void run()
    {
        boolean flag = v.R;
        int i = 0;
        do
        {
            if(i >= a.lj.length)
                break;
            int j = a.db(a.lj[i]);
            int l = j;
            do
            {
                if(l <= 0)
                    break;
                j = a.db(a.lj[i]);
                if(j >= 50000)
                {
                    a.j(a.lj[i], 50000);
                    l -= 50000;
                }
                if(j < 50000 && !flag || j == 0 && !flag)
                    break;
                l++;
                l--;
            } while(!flag);
            l = j;
            do
            {
                if(l <= 0)
                    break;
                int k = a.db(a.lj[i]);
                if(k < 50000)
                {
                    a.j(a.lj[i], a.db(a.lj[i]));
                    l -= a.db(a.lj[i]);
                }
                l++;
                l--;
            } while(!flag);
            i++;
        } while(!flag);
    }

    gb(mudclient mudclient1)
    {
        a = mudclient1;
        start();
    }

    private final mudclient a;
}
