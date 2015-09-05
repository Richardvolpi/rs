 


public class Class4
{

    public Class4(Class6 class6, int i)
    {
        anInt205 = -1;
        aBoolean219 = true;
        aClass6_180 = class6;
        anInt182 = i;
        aBooleanArray183 = new boolean[i];
        aBooleanArray184 = new boolean[i];
        aBooleanArray185 = new boolean[i];
        aBooleanArray186 = new boolean[i];
        aBooleanArray191 = new boolean[i];
        anIntArray187 = new int[i];
        anIntArray188 = new int[i];
        anIntArray189 = new int[i];
        anIntArray190 = new int[i];
        anIntArray192 = new int[i];
        anIntArray193 = new int[i];
        anIntArray194 = new int[i];
        anIntArray195 = new int[i];
        anIntArray196 = new int[i];
        anIntArray197 = new int[i];
        anIntArray198 = new int[i];
        aStringArray199 = new String[i];
        aStringArrayArray200 = new String[i][];
        anInt207 = method138(114, 114, 176);
        anInt208 = method138(14, 14, 62);
        anInt209 = method138(200, 208, 232);
        anInt210 = method138(96, 129, 184);
        anInt211 = method138(53, 95, 115);
        anInt212 = method138(117, 142, 171);
        anInt213 = method138(98, 122, 158);
        anInt214 = method138(86, 100, 136);
        anInt215 = method138(135, 146, 179);
        anInt216 = method138(97, 112, 151);
        anInt217 = method138(88, 102, 136);
        anInt218 = method138(84, 93, 120);
    }

    public int method138(int i, int j, int k)
    {
        return Class6.method223((anInt222 * i) / 114, (anInt223 * j) / 114, (anInt224 * k) / 176);
    }

    public void method139(int i, int j, int k, int l)
    {
        int k1 = Class6.anInt352;
        anInt201 = i;
        anInt202 = j;
        anInt204 = l;
        if(k != 0)
            anInt203 = k;
        if(k == 1)
        {
            for(int i1 = 0; i1 < anInt181; i1++)
            {
                if(aBooleanArray183[i1] && anIntArray194[i1] == 10 && anInt201 >= anIntArray192[i1] && anInt202 >= anIntArray193[i1] && anInt201 <= anIntArray192[i1] + anIntArray195[i1] && anInt202 <= anIntArray193[i1] + anIntArray196[i1])
                    aBooleanArray186[i1] = true;
                if(aBooleanArray183[i1] && anIntArray194[i1] == 14 && anInt201 >= anIntArray192[i1] && anInt202 >= anIntArray193[i1] && anInt201 <= anIntArray192[i1] + anIntArray195[i1] && anInt202 <= anIntArray193[i1] + anIntArray196[i1])
                    anIntArray189[i1] = 1 - anIntArray189[i1];
            }

        }
        if(l == 1)
            anInt206++;
        else
            anInt206 = 0;
        if(k == 1 || anInt206 > 20)
        {
            for(int j1 = 0; j1 < anInt181; j1++)
                if(aBooleanArray183[j1] && anIntArray194[j1] == 15 && anInt201 >= anIntArray192[j1] && anInt202 >= anIntArray193[j1] && anInt201 <= anIntArray192[j1] + anIntArray195[j1] && anInt202 <= anIntArray193[j1] + anIntArray196[j1])
                    aBooleanArray186[j1] = true;

            anInt206 -= 5;
        }
    }

    public boolean method140(int i)
    {
        if(aBooleanArray183[i] && aBooleanArray186[i])
        {
            aBooleanArray186[i] = false;
            return true;
        } else
        {
            return false;
        }
    }

    public void method141(int i)
    {
        if(i == 0)
            return;
        if(anInt205 != -1 && aStringArray199[anInt205] != null && aBooleanArray183[anInt205])
        {
            int j = aStringArray199[anInt205].length();
            if(i == 8 && j > 0)
                aStringArray199[anInt205] = aStringArray199[anInt205].substring(0, j - 1);
            if((i == 10 || i == 13) && j > 0)
                aBooleanArray186[anInt205] = true;
            String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\243$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";
            if(j < anIntArray197[anInt205])
            {
                for(int k = 0; k < s.length(); k++)
                    if(i == s.charAt(k))
                        aStringArray199[anInt205] += (char)i;

            }
            if(i == 9)
            {
                do
                    anInt205 = (anInt205 + 1) % anInt181;
                while(anIntArray194[anInt205] != 5 && anIntArray194[anInt205] != 6);
                return;
            }
        }
    }

    public void method142()
    {
        int j = Class6.anInt352;
        for(int i = 0; i < anInt181; i++)
            if(aBooleanArray183[i])
                if(anIntArray194[i] == 0)
                    method144(i, anIntArray192[i], anIntArray193[i], aStringArray199[i], anIntArray198[i]);
                else
                if(anIntArray194[i] == 1)
                    method144(i, anIntArray192[i] - aClass6_180.method263(aStringArray199[i], anIntArray198[i]) / 2, anIntArray193[i], aStringArray199[i], anIntArray198[i]);
                else
                if(anIntArray194[i] == 2)
                    method147(anIntArray192[i], anIntArray193[i], anIntArray195[i], anIntArray196[i]);
                else
                if(anIntArray194[i] == 3)
                    method150(anIntArray192[i], anIntArray193[i], anIntArray195[i]);
                else
                if(anIntArray194[i] == 4)
                    method151(i, anIntArray192[i], anIntArray193[i], anIntArray195[i], anIntArray196[i], anIntArray198[i], aStringArrayArray200[i], anIntArray188[i], anIntArray187[i]);
                else
                if(anIntArray194[i] == 5 || anIntArray194[i] == 6)
                    method146(i, anIntArray192[i], anIntArray193[i], anIntArray195[i], anIntArray196[i], aStringArray199[i], anIntArray198[i]);
                else
                if(anIntArray194[i] == 7)
                    method153(i, anIntArray192[i], anIntArray193[i], anIntArray198[i], aStringArrayArray200[i]);
                else
                if(anIntArray194[i] == 8)
                    method154(i, anIntArray192[i], anIntArray193[i], anIntArray198[i], aStringArrayArray200[i]);
                else
                if(anIntArray194[i] == 9)
                    method155(i, anIntArray192[i], anIntArray193[i], anIntArray195[i], anIntArray196[i], anIntArray198[i], aStringArrayArray200[i], anIntArray188[i], anIntArray187[i]);
                else
                if(anIntArray194[i] == 11)
                    method148(anIntArray192[i], anIntArray193[i], anIntArray195[i], anIntArray196[i]);
                else
                if(anIntArray194[i] == 12)
                    method149(anIntArray192[i], anIntArray193[i], anIntArray198[i]);
                else
                if(anIntArray194[i] == 14)
                    method143(i, anIntArray192[i], anIntArray193[i], anIntArray195[i], anIntArray196[i]);

        anInt203 = 0;
    }

    protected void method143(int i, int j, int k, int l, int i1)
    {
        aClass6_180.method216(j, k, l, i1, 0xffffff);
        aClass6_180.method218(j, k, l, anInt215);
        aClass6_180.method219(j, k, i1, anInt215);
        aClass6_180.method218(j, (k + i1) - 1, l, anInt218);
        aClass6_180.method219((j + l) - 1, k, i1, anInt218);
        if(anIntArray189[i] == 1)
        {
            for(int j1 = 0; j1 < i1; j1++)
            {
                aClass6_180.method218(j + j1, k + j1, 1, 0);
                aClass6_180.method218((j + l) - 1 - j1, k + j1, 1, 0);
            }

        }
    }

    protected void method144(int i, int j, int k, String s, int l)
    {
        int i1 = k + aClass6_180.method261(l) / 3;
        method145(i, j, i1, s, l);
    }

    protected void method145(int i, int j, int k, String s, int l)
    {
        int i1;
        if(aBooleanArray191[i])
            i1 = 0xffffff;
        else
            i1 = 0;
        aClass6_180.method257(s, j, k, l, i1);
    }

    protected void method146(int i, int j, int k, int l, int i1, String s, int j1)
    {
        int j2 = Class6.anInt352;
        if(aBooleanArray185[i])
        {
            int k1 = s.length();
            s = "";
            for(int i2 = 0; i2 < k1; i2++)
                s = s + "X";

        }
        if(anIntArray194[i] == 5)
        {
            if(anInt203 == 1 && anInt201 >= j && anInt202 >= k - i1 / 2 && anInt201 <= j + l && anInt202 <= k + i1 / 2)
                anInt205 = i;
        } else
        if(anIntArray194[i] == 6)
        {
            if(anInt203 == 1 && anInt201 >= j - l / 2 && anInt202 >= k - i1 / 2 && anInt201 <= j + l / 2 && anInt202 <= k + i1 / 2)
                anInt205 = i;
            j -= aClass6_180.method263(s, j1) / 2;
        }
        if(anInt205 == i)
            s = s + "*";
        int l1 = k + aClass6_180.method261(j1) / 3;
        method145(i, j, l1, s, j1);
    }

    public void method147(int i, int j, int k, int l)
    {
        int k1 = Class6.anInt352;
        aClass6_180.method209(i, j, i + k, j + l);
        aClass6_180.method215(i, j, k, l, anInt218, anInt215);
        if(aBoolean220)
        {
            for(int i1 = i - (j & 0x3f); i1 < i + k; i1 += 128)
            {
                for(int j1 = j - (j & 0x1f); j1 < j + l; j1 += 128)
                    aClass6_180.method233(i1, j1, 6 + anInt221, 128);

            }

        }
        aClass6_180.method218(i, j, k, anInt215);
        aClass6_180.method218(i + 1, j + 1, k - 2, anInt215);
        aClass6_180.method218(i + 2, j + 2, k - 4, anInt216);
        aClass6_180.method219(i, j, l, anInt215);
        aClass6_180.method219(i + 1, j + 1, l - 2, anInt215);
        aClass6_180.method219(i + 2, j + 2, l - 4, anInt216);
        aClass6_180.method218(i, (j + l) - 1, k, anInt218);
        aClass6_180.method218(i + 1, (j + l) - 2, k - 2, anInt218);
        aClass6_180.method218(i + 2, (j + l) - 3, k - 4, anInt217);
        aClass6_180.method219((i + k) - 1, j, l, anInt218);
        aClass6_180.method219((i + k) - 2, j + 1, l - 2, anInt218);
        aClass6_180.method219((i + k) - 3, j + 2, l - 4, anInt217);
        aClass6_180.method210();
    }

    public void method148(int i, int j, int k, int l)
    {
        aClass6_180.method216(i, j, k, l, 0);
        aClass6_180.method217(i, j, k, l, anInt212);
        aClass6_180.method217(i + 1, j + 1, k - 2, l - 2, anInt213);
        aClass6_180.method217(i + 2, j + 2, k - 4, l - 4, anInt214);
        aClass6_180.method231(i, j, 2 + anInt221);
        aClass6_180.method231((i + k) - 7, j, 3 + anInt221);
        aClass6_180.method231(i, (j + l) - 7, 4 + anInt221);
        aClass6_180.method231((i + k) - 7, (j + l) - 7, 5 + anInt221);
    }

    protected void method149(int i, int j, int k)
    {
        aClass6_180.method231(i, j, k);
    }

    protected void method150(int i, int j, int k)
    {
        aClass6_180.method218(i, j, k, 0);
    }

    protected void method151(int i, int j, int k, int l, int i1, int j1, String as[], 
            int k1, int l1)
    {
        int i4 = Class6.anInt352;
        int i2 = i1 / aClass6_180.method261(j1);
        if(l1 > k1 - i2)
            l1 = k1 - i2;
        if(l1 < 0)
            l1 = 0;
        anIntArray187[i] = l1;
        if(i2 < k1)
        {
            int j2 = (j + l) - 12;
            int l2 = ((i1 - 27) * i2) / k1;
            if(l2 < 6)
                l2 = 6;
            int j3 = ((i1 - 27 - l2) * l1) / (k1 - i2);
            if(anInt204 == 1 && anInt201 >= j2 && anInt201 <= j2 + 12)
            {
                if(anInt202 > k && anInt202 < k + 12 && l1 > 0)
                    l1--;
                if(anInt202 > (k + i1) - 12 && anInt202 < k + i1 && l1 < k1 - i2)
                    l1++;
                anIntArray187[i] = l1;
            }
            if(anInt204 == 1 && (anInt201 >= j2 && anInt201 <= j2 + 12 || anInt201 >= j2 - 12 && anInt201 <= j2 + 24 && aBooleanArray184[i]))
            {
                if(anInt202 > k + 12 && anInt202 < (k + i1) - 12)
                {
                    aBooleanArray184[i] = true;
                    int l3 = anInt202 - k - 12 - l2 / 2;
                    l1 = (l3 * k1) / (i1 - 24);
                    if(l1 > k1 - i2)
                        l1 = k1 - i2;
                    if(l1 < 0)
                        l1 = 0;
                    anIntArray187[i] = l1;
                }
            } else
            {
                aBooleanArray184[i] = false;
            }
            j3 = ((i1 - 27 - l2) * l1) / (k1 - i2);
            method152(j, k, l, i1, j3, l2);
        }
        int k2 = i1 - i2 * aClass6_180.method261(j1);
        int i3 = k + (aClass6_180.method261(j1) * 5) / 6 + k2 / 2;
        for(int k3 = l1; k3 < k1; k3++)
        {
            method145(i, j + 2, i3, as[k3], j1);
            i3 += aClass6_180.method261(j1) - anInt225;
            if(i3 >= k + i1)
                return;
        }

    }

    protected void method152(int i, int j, int k, int l, int i1, int j1)
    {
        int k1 = (i + k) - 12;
        aClass6_180.method217(k1, j, 12, l, 0);
        aClass6_180.method231(k1 + 1, j + 1, anInt221);
        aClass6_180.method231(k1 + 1, (j + l) - 12, 1 + anInt221);
        aClass6_180.method218(k1, j + 13, 12, 0);
        aClass6_180.method218(k1, (j + l) - 13, 12, 0);
        aClass6_180.method215(k1 + 1, j + 14, 11, l - 27, anInt207, anInt208);
        aClass6_180.method216(k1 + 3, i1 + j + 14, 7, j1, anInt210);
        aClass6_180.method219(k1 + 2, i1 + j + 14, j1, anInt209);
        aClass6_180.method219(k1 + 2 + 8, i1 + j + 14, j1, anInt211);
    }

    protected void method153(int i, int j, int k, int l, String as[])
    {
        int l2 = Class6.anInt352;
        int i1 = 0;
        int j1 = as.length;
        for(int k1 = 0; k1 < j1; k1++)
        {
            i1 += aClass6_180.method263(as[k1], l);
            if(k1 < j1 - 1)
                i1 += aClass6_180.method263("  ", l);
        }

        int l1 = j - i1 / 2;
        int i2 = k + aClass6_180.method261(l) / 3;
        for(int j2 = 0; j2 < j1; j2++)
        {
            int k2;
            if(aBooleanArray191[i])
                k2 = 0xffffff;
            else
                k2 = 0;
            if(anInt201 >= l1 && anInt201 <= l1 + aClass6_180.method263(as[j2], l) && anInt202 <= i2 && anInt202 > i2 - aClass6_180.method261(l))
            {
                if(aBooleanArray191[i])
                    k2 = 0x808080;
                else
                    k2 = 0xffffff;
                if(anInt203 == 1)
                {
                    anIntArray189[i] = j2;
                    aBooleanArray186[i] = true;
                }
            }
            if(anIntArray189[i] == j2)
                if(aBooleanArray191[i])
                    k2 = 0xff0000;
                else
                    k2 = 0xc00000;
            aClass6_180.method257(as[j2], l1, i2, l, k2);
            l1 += aClass6_180.method263(as[j2] + "  ", l);
        }

    }

    protected void method154(int i, int j, int k, int l, String as[])
    {
        int j2 = Class6.anInt352;
        int i1 = as.length;
        int j1 = k - (aClass6_180.method261(l) * (i1 - 1)) / 2;
        for(int k1 = 0; k1 < i1; k1++)
        {
            int l1;
            if(aBooleanArray191[i])
                l1 = 0xffffff;
            else
                l1 = 0;
            int i2 = aClass6_180.method263(as[k1], l);
            if(anInt201 >= j - i2 / 2 && anInt201 <= j + i2 / 2 && anInt202 - 2 <= j1 && anInt202 - 2 > j1 - aClass6_180.method261(l))
            {
                if(aBooleanArray191[i])
                    l1 = 0x808080;
                else
                    l1 = 0xffffff;
                if(anInt203 == 1)
                {
                    anIntArray189[i] = k1;
                    aBooleanArray186[i] = true;
                }
            }
            if(anIntArray189[i] == k1)
                if(aBooleanArray191[i])
                    l1 = 0xff0000;
                else
                    l1 = 0xc00000;
            aClass6_180.method257(as[k1], j - i2 / 2, j1, l, l1);
            j1 += aClass6_180.method261(l);
        }

    }

    protected void method155(int i, int j, int k, int l, int i1, int j1, String as[], 
            int k1, int l1)
    {
        int j4 = Class6.anInt352;
        int i2 = i1 / aClass6_180.method261(j1);
        if(i2 < k1)
        {
            int j2 = (j + l) - 12;
            int l2 = ((i1 - 27) * i2) / k1;
            if(l2 < 6)
                l2 = 6;
            int j3 = ((i1 - 27 - l2) * l1) / (k1 - i2);
            if(anInt204 == 1 && anInt201 >= j2 && anInt201 <= j2 + 12)
            {
                if(anInt202 > k && anInt202 < k + 12 && l1 > 0)
                    l1--;
                if(anInt202 > (k + i1) - 12 && anInt202 < k + i1 && l1 < k1 - i2)
                    l1++;
                anIntArray187[i] = l1;
            }
            if(anInt204 == 1 && (anInt201 >= j2 && anInt201 <= j2 + 12 || anInt201 >= j2 - 12 && anInt201 <= j2 + 24 && aBooleanArray184[i]))
            {
                if(anInt202 > k + 12 && anInt202 < (k + i1) - 12)
                {
                    aBooleanArray184[i] = true;
                    int l3 = anInt202 - k - 12 - l2 / 2;
                    l1 = (l3 * k1) / (i1 - 24);
                    if(l1 < 0)
                        l1 = 0;
                    if(l1 > k1 - i2)
                        l1 = k1 - i2;
                    anIntArray187[i] = l1;
                }
            } else
            {
                aBooleanArray184[i] = false;
            }
            j3 = ((i1 - 27 - l2) * l1) / (k1 - i2);
            method152(j, k, l, i1, j3, l2);
        } else
        {
            l1 = 0;
            anIntArray187[i] = 0;
        }
        anIntArray190[i] = -1;
        int k2 = i1 - i2 * aClass6_180.method261(j1);
        int i3 = k + (aClass6_180.method261(j1) * 5) / 6 + k2 / 2;
        for(int k3 = l1; k3 < k1; k3++)
        {
            int i4;
            if(aBooleanArray191[i])
                i4 = 0xffffff;
            else
                i4 = 0;
            if(anInt201 >= j + 2 && anInt201 <= j + 2 + aClass6_180.method263(as[k3], j1) && anInt202 - 2 <= i3 && anInt202 - 2 > i3 - aClass6_180.method261(j1))
            {
                if(aBooleanArray191[i])
                    i4 = 0x808080;
                else
                    i4 = 0xffffff;
                anIntArray190[i] = k3;
                if(anInt203 == 1)
                {
                    anIntArray189[i] = k3;
                    aBooleanArray186[i] = true;
                }
            }
            if(anIntArray189[i] == k3 && aBoolean219)
                i4 = 0xff0000;
            aClass6_180.method257(as[k3], j + 2, i3, j1, i4);
            i3 += aClass6_180.method261(j1);
            if(i3 >= k + i1)
                return;
        }

    }

    public int method156(int i, int j, String s, int k, boolean flag)
    {
        anIntArray194[anInt181] = 1;
        aBooleanArray183[anInt181] = true;
        aBooleanArray186[anInt181] = false;
        anIntArray198[anInt181] = k;
        aBooleanArray191[anInt181] = flag;
        anIntArray192[anInt181] = i;
        anIntArray193[anInt181] = j;
        aStringArray199[anInt181] = s;
        return anInt181++;
    }

    public int method157(int i, int j, int k, int l)
    {
        anIntArray194[anInt181] = 2;
        aBooleanArray183[anInt181] = true;
        aBooleanArray186[anInt181] = false;
        anIntArray192[anInt181] = i - k / 2;
        anIntArray193[anInt181] = j - l / 2;
        anIntArray195[anInt181] = k;
        anIntArray196[anInt181] = l;
        return anInt181++;
    }

    public int method158(int i, int j, int k, int l)
    {
        anIntArray194[anInt181] = 11;
        aBooleanArray183[anInt181] = true;
        aBooleanArray186[anInt181] = false;
        anIntArray192[anInt181] = i - k / 2;
        anIntArray193[anInt181] = j - l / 2;
        anIntArray195[anInt181] = k;
        anIntArray196[anInt181] = l;
        return anInt181++;
    }

    public int method159(int i, int j, int k)
    {
        int l = aClass6_180.anIntArray324[k];
        int i1 = aClass6_180.anIntArray325[k];
        anIntArray194[anInt181] = 12;
        aBooleanArray183[anInt181] = true;
        aBooleanArray186[anInt181] = false;
        anIntArray192[anInt181] = i - l / 2;
        anIntArray193[anInt181] = j - i1 / 2;
        anIntArray195[anInt181] = l;
        anIntArray196[anInt181] = i1;
        anIntArray198[anInt181] = k;
        return anInt181++;
    }

    public int method160(int i, int j, int k, int l, int i1, int j1, boolean flag)
    {
        anIntArray194[anInt181] = 4;
        aBooleanArray183[anInt181] = true;
        aBooleanArray186[anInt181] = false;
        anIntArray192[anInt181] = i;
        anIntArray193[anInt181] = j;
        anIntArray195[anInt181] = k;
        anIntArray196[anInt181] = l;
        aBooleanArray191[anInt181] = flag;
        anIntArray198[anInt181] = i1;
        anIntArray197[anInt181] = j1;
        anIntArray188[anInt181] = 0;
        anIntArray187[anInt181] = 0;
        aStringArrayArray200[anInt181] = new String[j1];
        return anInt181++;
    }

    public int method161(int i, int j, int k, int l, int i1, int j1, boolean flag, 
            boolean flag1)
    {
        anIntArray194[anInt181] = 5;
        aBooleanArray183[anInt181] = true;
        aBooleanArray185[anInt181] = flag;
        aBooleanArray186[anInt181] = false;
        anIntArray198[anInt181] = i1;
        aBooleanArray191[anInt181] = flag1;
        anIntArray192[anInt181] = i;
        anIntArray193[anInt181] = j;
        anIntArray195[anInt181] = k;
        anIntArray196[anInt181] = l;
        anIntArray197[anInt181] = j1;
        aStringArray199[anInt181] = "";
        return anInt181++;
    }

    public int method162(int i, int j, int k, int l, int i1, int j1, boolean flag, 
            boolean flag1)
    {
        anIntArray194[anInt181] = 6;
        aBooleanArray183[anInt181] = true;
        aBooleanArray185[anInt181] = flag;
        aBooleanArray186[anInt181] = false;
        anIntArray198[anInt181] = i1;
        aBooleanArray191[anInt181] = flag1;
        anIntArray192[anInt181] = i;
        anIntArray193[anInt181] = j;
        anIntArray195[anInt181] = k;
        anIntArray196[anInt181] = l;
        anIntArray197[anInt181] = j1;
        aStringArray199[anInt181] = "";
        return anInt181++;
    }

    public int method163(int i, int j, int k, int l, int i1, int j1, boolean flag)
    {
        anIntArray194[anInt181] = 9;
        aBooleanArray183[anInt181] = true;
        aBooleanArray186[anInt181] = false;
        anIntArray198[anInt181] = i1;
        aBooleanArray191[anInt181] = flag;
        anIntArray192[anInt181] = i;
        anIntArray193[anInt181] = j;
        anIntArray195[anInt181] = k;
        anIntArray196[anInt181] = l;
        anIntArray197[anInt181] = j1;
        aStringArrayArray200[anInt181] = new String[j1];
        anIntArray188[anInt181] = 0;
        anIntArray187[anInt181] = 0;
        anIntArray189[anInt181] = -1;
        anIntArray190[anInt181] = -1;
        return anInt181++;
    }

    public int method164(int i, int j, int k, int l)
    {
        anIntArray194[anInt181] = 10;
        aBooleanArray183[anInt181] = true;
        aBooleanArray186[anInt181] = false;
        anIntArray192[anInt181] = i - k / 2;
        anIntArray193[anInt181] = j - l / 2;
        anIntArray195[anInt181] = k;
        anIntArray196[anInt181] = l;
        return anInt181++;
    }

    public void method165(int i)
    {
        anIntArray188[i] = 0;
    }

    public void method166(int i)
    {
        anIntArray187[i] = 0;
        anIntArray190[i] = -1;
    }

    public void method167(int i, int j, String s)
    {
        aStringArrayArray200[i][j] = s;
        if(j + 1 > anIntArray188[i])
            anIntArray188[i] = j + 1;
    }

    public void method168(int i, String s, boolean flag)
    {
        int j = anIntArray188[i]++;
        if(j >= anIntArray197[i])
        {
            j--;
            anIntArray188[i]--;
            for(int k = 0; k < j; k++)
                aStringArrayArray200[i][k] = aStringArrayArray200[i][k + 1];

        }
        aStringArrayArray200[i][j] = s;
        if(flag)
            anIntArray187[i] = 0xf423f;
    }

    public void method169(int i, String s)
    {
        aStringArray199[i] = s;
    }

    public String method170(int i)
    {
        if(aStringArray199[i] == null)
            return "null";
        else
            return aStringArray199[i];
    }

    public void method171(int i)
    {
        aBooleanArray183[i] = true;
    }

    public void method172(int i)
    {
        aBooleanArray183[i] = false;
    }

    public void method173(int i)
    {
        anInt205 = i;
    }

    public int method174(int i)
    {
        int j = anIntArray190[i];
        return j;
    }

    public boolean aBoolean219;
    public static boolean aBoolean220 = true;
    public boolean aBooleanArray183[];
    public boolean aBooleanArray184[];
    public boolean aBooleanArray185[];
    public boolean aBooleanArray186[];
    boolean aBooleanArray191[];
    protected Class6 aClass6_180;
    String aStringArray199[];
    String aStringArrayArray200[][];
    int anInt181;
    int anInt182;
    int anInt201;
    int anInt202;
    int anInt203;
    int anInt204;
    int anInt205;
    int anInt206;
    int anInt207;
    int anInt208;
    int anInt209;
    int anInt210;
    int anInt211;
    int anInt212;
    int anInt213;
    int anInt214;
    int anInt215;
    int anInt216;
    int anInt217;
    int anInt218;
    public static int anInt221;
    public static int anInt222 = 114;
    public static int anInt223 = 114;
    public static int anInt224 = 176;
    public static int anInt225;
    public int anIntArray187[];
    public int anIntArray188[];
    public int anIntArray189[];
    public int anIntArray190[];
    int anIntArray192[];
    int anIntArray193[];
    int anIntArray194[];
    int anIntArray195[];
    int anIntArray196[];
    int anIntArray197[];
    int anIntArray198[];

}
