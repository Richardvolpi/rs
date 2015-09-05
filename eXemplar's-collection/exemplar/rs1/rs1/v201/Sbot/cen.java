// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 


public class cen
{

    public static String cfd(byte abyte0[], int i, int j)
    {
        int i2 = Class14.anInt553;
        try
        {
            int k = 0;
            int l = -1;
            for(int i1 = 0; i1 < j; i1++)
            {
                int j1 = abyte0[i++] & 0xff;
                int k1 = j1 >> 4 & 0xf;
                if(l == -1)
                {
                    if(k1 < 13)
                        aCharArray570[k++] = aCharArray571[k1];
                    else
                        l = k1;
                } else
                {
                    aCharArray570[k++] = aCharArray571[((l << 4) + k1) - 195];
                    l = -1;
                }
                k1 = j1 & 0xf;
                if(l == -1)
                {
                    if(k1 < 13)
                        aCharArray570[k++] = aCharArray571[k1];
                    else
                        l = k1;
                } else
                {
                    aCharArray570[k++] = aCharArray571[((l << 4) + k1) - 195];
                    l = -1;
                }
            }

            boolean flag = true;
            for(int l1 = 0; l1 < k; l1++)
            {
                char c = aCharArray570[l1];
                if(l1 > 4 && c == '@')
                    aCharArray570[l1] = ' ';
                if(c == '%')
                    aCharArray570[l1] = ' ';
                if(flag && c >= 'a' && c <= 'z')
                {
                    aCharArray570[l1] += '\uFFE0';
                    flag = false;
                }
                if(c == '.' || c == '!')
                    flag = true;
            }

            return new String(aCharArray570, 0, k);
        }
        catch(Exception _ex)
        {
			_ex.toString();
            return ".";
        }
    }

    public static int cfe(String s)
    {
        int j1 = Class14.anInt553;
        if(s.length() > 80)
            s = s.substring(0, 80);
        s = s.toLowerCase();
        int i = 0;
        int j = -1;
        for(int k = 0; k < s.length(); k++)
        {
            char c = s.charAt(k);
            int l = 0;
            for(int i1 = 0; i1 < aCharArray571.length; i1++)
            {
                if(c != aCharArray571[i1])
                    continue;
                l = i1;
                break;
            }

            if(l > 12)
                l += 195;
            if(j == -1)
            {
                if(l < 13)
                    j = l;
                else
                    cfa[i++] = (byte)l;
            } else
            if(l < 13)
            {
                cfa[i++] = (byte)((j << 4) + l);
                j = -1;
            } else
            {
                cfa[i++] = (byte)((j << 4) + (l >> 4));
                j = l & 0xf;
            }
        }

        if(j != -1)
            cfa[i++] = (byte)(j << 4);
        return i;
    }

    public static byte cfa[] = new byte[100];
    public static char aCharArray570[] = new char[100];
    public static char aCharArray571[] = {
        ' ', 'e', 't', 'a', 'o', 'i', 'h', 'n', 's', 'r', 
        'd', 'l', 'u', 'm', 'w', 'c', 'y', 'f', 'g', 'p', 
        'b', 'v', 'k', 'x', 'j', 'q', 'z', '0', '1', '2', 
        '3', '4', '5', '6', '7', '8', '9', ' ', '!', '?', 
        '.', ',', ':', ';', '(', ')', '-', '&', '*', '\\', 
        '\'', '@', '#', '+', '=', '\243', '$', '%', '"', '[', 
        ']'
    };

}
