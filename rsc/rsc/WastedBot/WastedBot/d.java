// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   d.java

import java.io.InputStream;
import sun.audio.AudioPlayer;

public class d extends InputStream
{

    public d()
    {
        AudioPlayer.player.start(this);
    }

    public void a()
    {
        AudioPlayer.player.stop(this);
    }

    public void a(byte abyte0[], int i, int j)
    {
        a = abyte0;
        b = i;
        c = i + j;
    }

    public int read(byte abyte0[], int i, int j)
    {
        boolean flag = v.R;
        int k = v.z;
        int l = 0;
label0:
        do
        {
label1:
            {
                if(l >= j)
                    break label0;
                if(b < c)
                {
                    abyte0[i + l] = a[b++];
                    if(!flag)
                        break label1;
                }
                abyte0[i + l] = -1;
            }
            l++;
        } while(!flag);
        return j;
    }

    public int read()
    {
        byte abyte0[] = new byte[1];
        read(abyte0, 0, 1);
        return abyte0[0];
    }

    byte a[];
    int b;
    int c;
}
