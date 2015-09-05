// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   o.java


public class o
{

    public static String a(byte abyte0[], int i, int j)
    {
        boolean flag1;
        flag1 = v.R;
        int l = k.A;
        int i1;
        int j1;
        int k1;
        i1 = 0;
        j1 = -1;
        k1 = 0;
_L12:
        int l1;
        int j2;
        if(k1 >= j)
            break; /* Loop/switch isn't completed */
        l1 = abyte0[i++] & 0xff;
        j2 = l1 >> 4 & 0xf;
        if(j1 != -1) goto _L2; else goto _L1
_L1:
        if(j2 >= 13) goto _L4; else goto _L3
_L3:
        b[i1++] = c[j2];
        if(!flag1) goto _L5; else goto _L4
_L4:
        j1 = j2;
        if(!flag1) goto _L5; else goto _L2
_L2:
        b[i1++] = c[((j1 << 4) + j2) - 195];
        j1 = -1;
_L5:
        j2 = l1 & 0xf;
        if(j1 != -1) goto _L7; else goto _L6
_L6:
        if(j2 >= 13) goto _L9; else goto _L8
_L8:
        b[i1++] = c[j2];
        if(!flag1) goto _L10; else goto _L9
_L9:
        j1 = j2;
        if(!flag1) goto _L10; else goto _L7
_L7:
        b[i1++] = c[((j1 << 4) + j2) - 195];
        j1 = -1;
_L10:
        k1++;
        if(!flag1) goto _L12; else goto _L11
_L11:
        boolean flag = true;
        int i2 = 0;
        do
        {
            if(i2 >= i1)
                break;
            char c1 = b[i2];
            if(i2 > 4 && c1 == '@')
                b[i2] = ' ';
            if(c1 == '%')
                b[i2] = ' ';
            if(flag && c1 >= 'a' && c1 <= 'z')
            {
                b[i2] += '\uFFE0';
                flag = false;
            }
            if(c1 == '.' || c1 == '!')
                flag = true;
            i2++;
        } while(!flag1);
        return new String(b, 0, i1);
        Exception exception;
        exception;
        return ".";
    }

    public static int a(String s)
    {
        int i = k.A;
        if(s.length() > 80)
            s = s.substring(0, 80);
        s = s.toLowerCase();
        int j = 0;
        int l = -1;
        for(int i1 = 0; i1 < s.length(); i1++)
        {
            char c1 = s.charAt(i1);
            int j1 = 0;
            int k1 = 0;
            do
            {
                if(k1 >= c.length)
                    break;
                if(c1 == c[k1])
                {
                    j1 = k1;
                    break;
                }
                k1++;
            } while(true);
            if(j1 > 12)
                j1 += 195;
            if(l == -1)
            {
                if(j1 < 13)
                    l = j1;
                else
                    a[j++] = (byte)j1;
                continue;
            }
            if(j1 < 13)
            {
                a[j++] = (byte)((l << 4) + j1);
                l = -1;
            } else
            {
                a[j++] = (byte)((l << 4) + (j1 >> 4));
                l = j1 & 0xf;
            }
        }

        if(l != -1)
            a[j++] = (byte)(l << 4);
        return j;
    }

    public static byte a[] = new byte[100];
    public static char b[] = new char[100];
    private static char c[] = {
        ' ', 'e', 't', 'a', 'o', 'i', 'h', 'n', 's', 'r', 
        'd', 'l', 'u', 'm', 'w', 'c', 'y', 'f', 'g', 'p', 
        'b', 'v', 'k', 'x', 'j', 'q', 'z', '0', '1', '2', 
        '3', '4', '5', '6', '7', '8', '9', ' ', '!', '?', 
        '.', ',', ':', ';', '(', ')', '-', '&', '*', '\\', 
        '\'', '@', '#', '+', '=', '\243', '$', '%', '"', '[', 
        ']'
    };

}
