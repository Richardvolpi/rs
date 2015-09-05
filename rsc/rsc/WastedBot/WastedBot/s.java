// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   s.java

import java.io.PrintStream;

public class s
{

    public static int a(byte abyte0[], int i, byte abyte1[], int j, int l)
    {
        h h1 = new h();
        h1.e = abyte1;
        h1.u = l;
        h1.f = abyte0;
        h1.y = 0;
        h1.v = j;
        h1.z = i;
        h1.E = 0;
        h1.D = 0;
        h1.w = 0;
        h1.x = 0;
        h1.A = 0;
        h1.B = 0;
        h1.G = 0;
        b(h1);
        i -= h1.z;
        return i;
    }

    private static void a(h h1)
    {
        int i = k.A;
        byte byte0 = h1.d;
        int j = h1.C;
        int l = h1.K;
        int i1 = h1.J;
        int ai[] = h.Q;
        int j1 = h1.I;
        byte abyte0[] = h1.f;
        int k1 = h1.y;
        int l1 = h1.z;
        int i2 = l1;
        int j2 = h1.M + 1;
label0:
        do
        {
            if(j > 0)
            {
                do
                {
                    if(l1 == 0)
                        break label0;
                    if(j == 1)
                        break;
                    abyte0[k1] = byte0;
                    j--;
                    k1++;
                    l1--;
                } while(true);
                if(l1 == 0)
                {
                    j = 1;
                    break;
                }
                abyte0[k1] = byte0;
                k1++;
                l1--;
            }
            boolean flag = true;
            do
            {
                if(!flag)
                    break;
                flag = false;
                if(l == j2)
                {
                    j = 0;
                    break label0;
                }
                byte0 = (byte)i1;
                j1 = ai[j1];
                byte byte1 = (byte)(j1 & 0xff);
                j1 >>= 8;
                l++;
                if(byte1 != i1)
                {
                    i1 = byte1;
                    if(l1 == 0)
                    {
                        j = 1;
                    } else
                    {
                        abyte0[k1] = byte0;
                        k1++;
                        l1--;
                        flag = true;
                        continue;
                    }
                    break label0;
                }
                if(l != j2)
                    continue;
                if(l1 == 0)
                {
                    j = 1;
                    break label0;
                }
                abyte0[k1] = byte0;
                k1++;
                l1--;
                flag = true;
            } while(true);
            j = 2;
            j1 = ai[j1];
            byte byte2 = (byte)(j1 & 0xff);
            j1 >>= 8;
            if(++l != j2)
                if(byte2 != i1)
                {
                    i1 = byte2;
                } else
                {
                    j = 3;
                    j1 = ai[j1];
                    byte byte3 = (byte)(j1 & 0xff);
                    j1 >>= 8;
                    if(++l != j2)
                        if(byte3 != i1)
                        {
                            i1 = byte3;
                        } else
                        {
                            j1 = ai[j1];
                            byte byte4 = (byte)(j1 & 0xff);
                            j1 >>= 8;
                            l++;
                            j = (byte4 & 0xff) + 4;
                            j1 = ai[j1];
                            i1 = (byte)(j1 & 0xff);
                            j1 >>= 8;
                            l++;
                        }
                }
        } while(true);
        int k2 = h1.A;
        h1.A += i2 - l1;
        if(h1.A < k2)
            h1.B++;
        h1.d = byte0;
        h1.C = j;
        h1.K = l;
        h1.J = i1;
        h.Q = ai;
        h1.I = j1;
        h1.f = abyte0;
        h1.y = k1;
        h1.z = l1;
    }

    private static void b(h h1)
    {
        int j;
        int ai[];
        int ai1[];
        int ai2[];
        boolean flag19;
        boolean flag20;
        flag20 = v.R;
        int i = k.A;
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;
        boolean flag5 = false;
        boolean flag6 = false;
        boolean flag7 = false;
        boolean flag8 = false;
        boolean flag9 = false;
        boolean flag10 = false;
        boolean flag11 = false;
        boolean flag12 = false;
        boolean flag13 = false;
        boolean flag14 = false;
        boolean flag15 = false;
        boolean flag16 = false;
        boolean flag17 = false;
        boolean flag18 = false;
        j = 0;
        ai = null;
        ai1 = null;
        ai2 = null;
        h1.F = 1;
        if(h.Q == null)
            h.Q = new int[h1.F * 0x186a0];
        flag19 = true;
_L7:
        int j2;
        int k3;
        int i4;
        int k4;
        int k5;
label0:
        {
            if(!flag19)
                break; /* Loop/switch isn't completed */
            byte byte0 = c(h1);
            if(byte0 == 23)
                return;
            byte0 = c(h1);
            byte0 = c(h1);
            byte0 = c(h1);
            byte0 = c(h1);
            byte0 = c(h1);
            h1.G++;
            byte0 = c(h1);
            byte0 = c(h1);
            byte0 = c(h1);
            byte0 = c(h1);
            byte0 = d(h1);
            if(byte0 != 0)
            {
                h1.a = true;
                if(!flag20)
                    break label0;
            }
            h1.a = false;
        }
        if(h1.a)
            System.out.println(z);
        h1.H = 0;
        byte byte1 = c(h1);
        h1.H = h1.H << 8 | byte1 & 0xff;
        byte1 = c(h1);
        h1.H = h1.H << 8 | byte1 & 0xff;
        byte1 = c(h1);
        h1.H = h1.H << 8 | byte1 & 0xff;
        int l = 0;
label1:
        do
        {
label2:
            {
                if(l >= 16)
                    break label1;
                byte byte2 = d(h1);
                if(byte2 == 1)
                {
                    h1.c[l] = true;
                    if(!flag20)
                        break label2;
                }
                h1.c[l] = false;
            }
            l++;
        } while(!flag20);
        l = 0;
        do
        {
            if(l >= 256)
                break;
            h1.b[l] = false;
            l++;
        } while(!flag20);
        l = 0;
        do
        {
            if(l >= 16)
                break;
            if(h1.c[l])
            {
                int i1 = 0;
                do
                {
                    if(i1 >= 16)
                        break;
                    byte byte3 = d(h1);
                    if(byte3 == 1)
                        h1.b[l * 16 + i1] = true;
                    i1++;
                } while(!flag20);
            }
            l++;
        } while(!flag20);
        e(h1);
        l = h1.L + 2;
        int j1 = a(3, h1);
        int k1 = a(15, h1);
        int l1 = 0;
        do
        {
            if(l1 >= k1)
                break;
            int i2 = 0;
            do
            {
                byte byte4 = d(h1);
                if(byte4 == 0 && !flag20)
                    break;
                i2++;
            } while(!flag20);
            h1.j[l1] = (byte)i2;
            l1++;
        } while(!flag20);
        byte abyte0[] = new byte[6];
        j2 = 0;
        do
        {
            if(j2 >= j1)
                break;
            abyte0[j2] = j2;
            j2++;
        } while(!flag20);
        j2 = 0;
        do
        {
            if(j2 >= k1)
                break;
            byte byte5 = h1.j[j2];
            byte byte7 = abyte0[byte5];
            do
            {
                if(byte5 <= 0)
                    break;
                abyte0[byte5] = abyte0[byte5 - 1];
                byte5--;
            } while(!flag20);
            abyte0[0] = byte7;
            h1.i[j2] = byte7;
            j2++;
        } while(!flag20);
        j2 = 0;
        do
        {
            if(j2 >= j1)
                break;
            int k2 = a(5, h1);
            int i3 = 0;
            do
            {
                if(i3 >= l)
                    break;
label3:
                do
                {
                    do
                    {
                        byte byte8 = d(h1);
                        if(byte8 == 0 && !flag20)
                            break label3;
                        byte8 = d(h1);
                        if(byte8 != 0)
                            break;
                        k2++;
                    } while(!flag20);
                    k2--;
                } while(!flag20);
                h1.k[j2][i3] = (byte)k2;
                i3++;
            } while(!flag20);
            j2++;
        } while(!flag20);
        j2 = 0;
        do
        {
            if(j2 >= j1)
                break;
            byte byte6 = 32;
            int j3 = 0;
            int l3 = 0;
            do
            {
                if(l3 >= l)
                    break;
                if(h1.k[j2][l3] > j3)
                    j3 = h1.k[j2][l3];
                if(h1.k[j2][l3] < byte6)
                    byte6 = h1.k[j2][l3];
                l3++;
            } while(!flag20);
            a(h1.T[j2], h1.U[j2], h1.V[j2], h1.k[j2], byte6, j3, l);
            h1.S[j2] = byte6;
            j2++;
        } while(!flag20);
        j2 = h1.L + 1;
        int l2 = 0x186a0 * h1.F;
        k3 = -1;
        i4 = 0;
        int j4 = 0;
        do
        {
            if(j4 > 255)
                break;
            h1.N[j4] = 0;
            j4++;
        } while(!flag20);
        j4 = 4095;
        k4 = 15;
        do
        {
            if(k4 < 0)
                break;
            int l4 = 15;
            do
            {
                if(l4 < 0)
                    break;
                h1.h[j4] = (byte)(k4 * 16 + l4);
                j4--;
                l4--;
            } while(!flag20);
            h1.R[k4] = j4 + 1;
            k4--;
        } while(!flag20);
        k4 = 0;
        if(i4 == 0)
        {
            k3++;
            i4 = 50;
            byte byte9 = h1.i[k3];
            j = h1.S[byte9];
            ai = h1.T[byte9];
            ai2 = h1.V[byte9];
            ai1 = h1.U[byte9];
        }
        i4--;
        int i5 = j;
        int j5 = a(i5, h1);
        do
        {
            if(j5 <= ai[i5])
                break;
            i5++;
            byte byte10 = d(h1);
            j5 = j5 << 1 | byte10;
        } while(!flag20);
        k5 = ai2[j5 - ai1[i5]];
_L2:
        int i6;
        byte byte14;
        if(k5 == j2)
            break; /* Loop/switch isn't completed */
        if(k5 != 0 && k5 != 1)
            break; /* Loop/switch isn't completed */
        i6 = -1;
        int k6 = 1;
        do
        {
label4:
            {
                if(k5 == 0)
                {
                    i6 += k6;
                    if(!flag20)
                        break label4;
                }
                if(k5 == 1)
                    i6 += 2 * k6;
            }
            k6 *= 2;
            if(i4 == 0)
            {
                k3++;
                i4 = 50;
                byte byte13 = h1.i[k3];
                j = h1.S[byte13];
                ai = h1.T[byte13];
                ai2 = h1.V[byte13];
                ai1 = h1.U[byte13];
            }
            i4--;
            int l6 = j;
            int l7 = a(l6, h1);
            do
            {
                if(l7 <= ai[l6])
                    break;
                l6++;
                byte byte16 = d(h1);
                l7 = l7 << 1 | byte16;
            } while(!flag20);
            k5 = ai2[l7 - ai1[l6]];
        } while(k5 == 0 || k5 == 1);
        i6++;
        byte14 = h1.g[h1.h[h1.R[0]] & 0xff];
        h1.N[byte14 & 0xff] += i6;
_L4:
        if(i6 <= 0) goto _L2; else goto _L1
_L1:
        h.Q[k4] = byte14 & 0xff;
        k4++;
        i6--;
        if(!flag20) goto _L4; else goto _L3
_L3:
        byte byte12;
label5:
        {
            int j6 = k5 - 1;
            if(j6 < 16)
            {
                int i7 = h1.R[0];
                byte12 = h1.h[i7 + j6];
                do
                {
                    if(j6 <= 3)
                        break;
                    int i8 = i7 + j6;
                    h1.h[i8] = h1.h[i8 - 1];
                    h1.h[i8 - 1] = h1.h[i8 - 2];
                    h1.h[i8 - 2] = h1.h[i8 - 3];
                    h1.h[i8 - 3] = h1.h[i8 - 4];
                    j6 -= 4;
                } while(!flag20);
                do
                {
                    if(j6 <= 0)
                        break;
                    h1.h[i7 + j6] = h1.h[(i7 + j6) - 1];
                    j6--;
                } while(!flag20);
                h1.h[i7] = byte12;
                if(!flag20)
                    break label5;
            }
            int j7 = j6 / 16;
            int j8 = j6 % 16;
            int l8 = h1.R[j7] + j8;
            byte12 = h1.h[l8];
            do
            {
                if(l8 <= h1.R[j7])
                    break;
                h1.h[l8] = h1.h[l8 - 1];
                l8--;
            } while(!flag20);
            h1.R[j7]++;
            do
            {
                if(j7 <= 0)
                    break;
                h1.R[j7]--;
                h1.h[h1.R[j7]] = h1.h[(h1.R[j7 - 1] + 16) - 1];
                j7--;
            } while(!flag20);
            h1.R[0]--;
            h1.h[h1.R[0]] = byte12;
            if(h1.R[0] == 0)
            {
                int i9 = 4095;
                int j9 = 15;
                do
                {
                    if(j9 < 0)
                        break;
                    int k9 = 15;
                    do
                    {
                        if(k9 < 0)
                            break;
                        h1.h[i9] = h1.h[h1.R[j9] + k9];
                        i9--;
                        k9--;
                    } while(!flag20);
                    h1.R[j9] = i9 + 1;
                    j9--;
                } while(!flag20);
            }
        }
        h1.N[h1.g[byte12 & 0xff] & 0xff]++;
        h.Q[k4] = h1.g[byte12 & 0xff] & 0xff;
        k4++;
        if(i4 == 0)
        {
            k3++;
            i4 = 50;
            byte byte15 = h1.i[k3];
            j = h1.S[byte15];
            ai = h1.T[byte15];
            ai2 = h1.V[byte15];
            ai1 = h1.U[byte15];
        }
        i4--;
        int k7 = j;
        int k8 = a(k7, h1);
        do
        {
            if(k8 <= ai[k7])
                break;
            k7++;
            byte byte17 = d(h1);
            k8 = k8 << 1 | byte17;
        } while(!flag20);
        k5 = ai2[k8 - ai1[k7]];
        if(!flag20) goto _L2; else goto _L5
_L5:
        h1.C = 0;
        h1.d = 0;
        h1.O[0] = 0;
        int l5 = 1;
        do
        {
            if(l5 > 256)
                break;
            h1.O[l5] = h1.N[l5 - 1];
            l5++;
        } while(!flag20);
        l5 = 1;
        do
        {
            if(l5 > 256)
                break;
            h1.O[l5] += h1.O[l5 - 1];
            l5++;
        } while(!flag20);
        l5 = 0;
        do
        {
            if(l5 >= k4)
                break;
            byte byte11 = (byte)(h.Q[l5] & 0xff);
            h.Q[h1.O[byte11 & 0xff]] |= l5 << 8;
            h1.O[byte11 & 0xff]++;
            l5++;
        } while(!flag20);
        h1.I = h.Q[h1.H] >> 8;
        h1.K = 0;
        h1.I = h.Q[h1.I];
        h1.J = (byte)(h1.I & 0xff);
        h1.I >>= 8;
        h1.K++;
        h1.M = k4;
        a(h1);
        if(h1.K != h1.M + 1 || h1.C != 0)
            break; /* Loop/switch isn't completed */
        flag19 = true;
        if(!flag20) goto _L7; else goto _L6
_L6:
        flag19 = false;
        if(!flag20) goto _L7; else goto _L8
_L8:
    }

    private static byte c(h h1)
    {
        return (byte)a(8, h1);
    }

    private static byte d(h h1)
    {
        return (byte)a(1, h1);
    }

    private static int a(int i, h h1)
    {
        int j;
        do
        {
            if(h1.E >= i)
            {
                int l = h1.D >> h1.E - i & (1 << i) - 1;
                h1.E -= i;
                j = l;
                break;
            }
            h1.D = h1.D << 8 | h1.e[h1.u] & 0xff;
            h1.E += 8;
            h1.u++;
            h1.v--;
            h1.w++;
            if(h1.w == 0)
                h1.x++;
        } while(true);
        return j;
    }

    private static void e(h h1)
    {
        h1.L = 0;
        for(int i = 0; i < 256; i++)
            if(h1.b[i])
            {
                h1.g[h1.L] = (byte)i;
                h1.L++;
            }

    }

    private static void a(int ai[], int ai1[], int ai2[], byte abyte0[], int i, int j, int l)
    {
        int i1 = k.A;
        int j1 = 0;
        for(int k1 = i; k1 <= j; k1++)
        {
            for(int i3 = 0; i3 < l; i3++)
                if(abyte0[i3] == k1)
                {
                    ai2[j1] = i3;
                    j1++;
                }

        }

        for(int l1 = 0; l1 < 23; l1++)
            ai1[l1] = 0;

        for(int i2 = 0; i2 < l; i2++)
            ai1[abyte0[i2] + 1]++;

        for(int j2 = 1; j2 < 23; j2++)
            ai1[j2] += ai1[j2 - 1];

        for(int k2 = 0; k2 < 23; k2++)
            ai[k2] = 0;

        int l2 = 0;
        for(int j3 = i; j3 <= j; j3++)
        {
            l2 += ai1[j3 + 1] - ai1[j3];
            ai[j3] = l2 - 1;
            l2 <<= 1;
        }

        for(int k3 = i + 1; k3 <= j; k3++)
            ai1[k3] = (ai[k3 - 1] + 1 << 1) - ai1[k3];

    }

    private static String z;

    static 
    {
        z = "h^z\027e\031?f\037h|Py\027u}[\024\034jw\\\177\177";
        break MISSING_BLOCK_LABEL_123;
        local;
        toCharArray();
        JVM INSTR dup ;
        JVM INSTR arraylength .length;
        JVM INSTR swap ;
        int i = 0;
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        1;
        JVM INSTR icmpgt 102;
           goto _L1 _L2
_L1:
        JVM INSTR dup ;
        i;
_L4:
        JVM INSTR dup2 ;
        JVM INSTR caload ;
        byte byte0;
        switch(i % 5)
        {
        case 0: // '\0'
            byte0 = 0x38;
            break;

        case 1: // '\001'
            byte0 = 31;
            break;

        case 2: // '\002'
            byte0 = 52;
            break;

        case 3: // '\003'
            byte0 = 94;
            break;

        default:
            byte0 = 38;
            break;
        }
        byte0;
        JVM INSTR ixor ;
        (char);
        JVM INSTR castore ;
        i++;
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        JVM INSTR ifne 102;
           goto _L3 _L2
_L3:
        JVM INSTR dup2 ;
        JVM INSTR swap ;
          goto _L4
_L2:
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        i;
        JVM INSTR icmpgt 26;
           goto _L5 _L1
_L5:
        JVM INSTR new #175 <Class String>;
        JVM INSTR dup_x1 ;
        JVM INSTR swap ;
        String();
        intern();
        JVM INSTR swap ;
        JVM INSTR pop ;
        JVM INSTR ret 0;
    }
}
