// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   fb.java


public class fb extends Thread
{

    public void run()
    {
        int i;
        boolean flag;
label0:
        {
            flag = v.R;
            if(a.Jc != -1)
            {
                i = a.db(a.Jc);
                if(!flag)
                    break label0;
            }
            i = -1;
        }
        int k = i;
        do
        {
            if(k <= 0)
                break;
            i = a.db(a.Jc);
            if(i >= 50000)
            {
                a.j(a.Jc, 50000);
                k -= 50000;
            }
            if(i < 50000 && !flag || i == 0 && !flag)
                break;
            k++;
            k--;
        } while(!flag);
        k = i;
        do
        {
            if(k <= 0)
                break;
            int j = a.db(a.Jc);
            if(j < 50000)
            {
                a.j(a.Jc, a.db(a.Jc));
                k -= a.db(a.Jc);
            }
            k++;
            k--;
        } while(!flag);
    }

    fb(mudclient mudclient1)
    {
        a = mudclient1;
        start();
    }

    private final mudclient a;
}
