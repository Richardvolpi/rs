// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 

import java.io.InputStream;
import sun.audio.AudioPlayer;

public class InputStream_Sub1 extends InputStream
{

    public InputStream_Sub1()
    {
        AudioPlayer.player.start(this);
    }

    public void method122()
    {
        AudioPlayer.player.stop(this);
    }

    public void method123(byte abyte0[], int i, int j)
    {
        aByteArray50 = abyte0;
        anInt51 = i;
        anInt52 = i + j;
    }

    public int read(byte abyte0[], int i, int j)
    {
        int l = Class6.anInt352;
        for(int k = 0; k < j; k++)
            if(anInt51 < anInt52)
                abyte0[i + k] = aByteArray50[anInt51++];
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

    byte aByteArray50[];
    int anInt51;
    int anInt52;
}
