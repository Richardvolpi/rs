// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

import java.io.InputStream;
import sun.audio.AudioPlayer;

public class gia extends InputStream
{

    public gia()
    {
        AudioPlayer.player.start(this);
    }

    public void gie()
    {
        AudioPlayer.player.stop(this);
    }

    public void gif(byte abyte0[], int i, int j)
    {
        gib = abyte0;
        gic = i;
        gid = i + j;
    }

    public int read(byte abyte0[], int i, int j)
    {
        boolean flag = false;
        for(int k = 0; k < j; k++)
            if(gic < gid)
                abyte0[i + k] = gib[gic++];
            else
                abyte0[i + k] = -1;

        return j;
    }

    public int read()
    {
        byte abyte0[] = new byte[1];
        read(abyte0, 0, 1);
        return abyte0[0];
    }

    byte gib[];
    int gic;
    int gid;
}
