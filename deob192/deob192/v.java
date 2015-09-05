// Decompiled by DJ v3.7.7.81 Copyright 2004 Atanas Neshkov  Date: 09/04/2005 1:50:21 AM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 


public class v
{

    public static String aeg(byte arg0[], int arg1, int arg2)
    {
        try
        {
            int i = 0;
            int j = -1;
            for(int k = 0; k < arg2; k++)
            {
                int l = arg0[arg1++] & 0xff;
                int i1 = l >> 4 & 0xf;
                if(j == -1)
                {
                    if(i1 < 13)
                        aei[i++] = aej[i1];
                    else
                        j = i1;
                } else
                {
                    aei[i++] = aej[((j << 4) + i1) - 195];
                    j = -1;
                }
                i1 = l & 0xf;
                if(j == -1)
                {
                    if(i1 < 13)
                        aei[i++] = aej[i1];
                    else
                        j = i1;
                } else
                {
                    aei[i++] = aej[((j << 4) + i1) - 195];
                    j = -1;
                }
            }

            boolean flag = true;
            for(int j1 = 0; j1 < i; j1++)
            {
                char c = aei[j1];
                if(j1 > 4 && c == '@')
                    aei[j1] = ' ';
                if(c == '%')
                    aei[j1] = ' ';
                if(flag && c >= 'a' && c <= 'z')
                {
                    aei[j1] += '\uFFE0';
                    flag = false;
                }
                if(c == '.' || c == '!')
                    flag = true;
            }

            return new String(aei, 0, i);
        }
        catch(Exception _ex)
        {
            return ".";
        }
    }

    public static int aeh(String arg0)
    {
        if(arg0.length() > 80)
            arg0 = arg0.substring(0, 80);
        arg0 = arg0.toLowerCase();
        int i = 0;
        int j = -1;
        for(int k = 0; k < arg0.length(); k++)
        {
            char c = arg0.charAt(k);
            int l = 0;
            for(int i1 = 0; i1 < aej.length; i1++)
            {
                if(c != aej[i1])
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
                    aeh[i++] = (byte)l;
            } else
            if(l < 13)
            {
                aeh[i++] = (byte)((j << 4) + l);
                j = -1;
            } else
            {
                aeh[i++] = (byte)((j << 4) + (l >> 4));
                j = l & 0xf;
            }
        }

        if(j != -1)
            aeh[i++] = (byte)(j << 4);
        return i;
    }

    public static byte aeh[] = new byte[100];
    public static char aei[] = new char[100];
    private static char aej[] = {
        ' ', 'e', 't', 'a', 'o', 'i', 'h', 'n', 's', 'r', 
        'd', 'l', 'u', 'm', 'w', 'c', 'y', 'f', 'g', 'p', 
        'b', 'v', 'k', 'x', 'j', 'q', 'z', '0', '1', '2', 
        '3', '4', '5', '6', '7', '8', '9', ' ', '!', '?', 
        '.', ',', ':', ';', '(', ')', '-', '&', '*', '\\', 
        '\'', '@', '#', '+', '=', '\243', '$', '%', '"', '[', 
        ']'
    };

}