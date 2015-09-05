// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) nonlb 

import java.io.InputStream;
import sun.audio.AudioPlayer;

public class InputStream_Sub1 extends InputStream {

    public InputStream_Sub1() {
        AudioPlayer.player.start(this);
    }

    public void method121() {
        AudioPlayer.player.stop(this);
    }

    public void method122(byte abyte0[], int i, int j) {
        aByteArray50 = abyte0;
        anInt51 = i;
        anInt52 = i + j;
    }

    public int read(byte abyte0[], int i, int j) {
        for(int k = 0; k < j; k++)
            if(anInt51 < anInt52)
                abyte0[i + k] = aByteArray50[anInt51++];
            else
                abyte0[i + k] = -1;

        return j;
    }

    public int read() {
        byte abyte0[] = new byte[1];
        read(abyte0, 0, 1);
        return abyte0[0];
    }

    public byte aByteArray50[];
    public int anInt51;
    public int anInt52;
}
