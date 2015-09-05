// Decompiled by DJ v3.7.7.81 Copyright 2004 Atanas Neshkov  Date: 09/04/2005 1:47:34 AM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 

import java.io.InputStream;
import sun.audio.AudioPlayer;

public class d extends InputStream
{

    public d()
    {
        AudioPlayer.player.start(this);
    }

    public void bfb()
    {
        AudioPlayer.player.stop(this);
    }

    public void bfc(byte arg0[], int arg1, int arg2)
    {
        beh = arg0;
        bei = arg1;
        bej = arg1 + arg2;
    }

    public int read(byte arg0[], int arg1, int arg2)
    {
        for(int i = 0; i < arg2; i++)
            if(bei < bej)
                arg0[arg1 + i] = beh[bei++];
            else
                arg0[arg1 + i] = -1;

        return arg2;
    }

    public int read()
    {
        byte abyte0[] = new byte[1];
        read(abyte0, 0, 1);
        return abyte0[0];
    }

    byte beh[];
    int bei;
    int bej;
}