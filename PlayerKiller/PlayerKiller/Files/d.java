import java.io.InputStream;
import sun.audio.AudioPlayer;

public class d extends InputStream
{

    public d()
    {
        AudioPlayer.player.start(this);
    }

    public void ggl()
    {
        AudioPlayer.player.stop(this);
    }

    public void ggm(byte abyte0[], int i, int j)
    {
        ggi = abyte0;
        ggj = i;
        ggk = i + j;
    }

    public int read(byte arg0[], int arg1, int arg2)
    {
        for(int i = 0; i < arg2; i++)
            if(ggj < ggk)
                arg0[arg1 + i] = ggi[ggj++];
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

    byte ggi[];
    int ggj;
    int ggk;
}
