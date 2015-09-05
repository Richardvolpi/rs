// Decompiled by DJ v3.7.7.81 Copyright 2004 Atanas Neshkov  Date: 09/04/2005 1:50:17 AM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 

import java.io.PrintStream;

public class u
{

    public static void akf(q arg0, q arg1, q arg2, q arg3)
    {
        akh(arg1);
        aki(arg2);
        akj(arg0);
        akg(arg3);
    }

    public static void akg(q arg0)
    {
        int i = arg0.aec();
        bah = new char[i][];
        bai = new int[i];
        for(int j = 0; j < i; j++)
        {
            bai[j] = arg0.aea();
            char ac[] = new char[arg0.aea()];
            for(int k = 0; k < ac.length; k++)
                ac[k] = (char)arg0.aea();

            bah[j] = ac;
        }

    }

    public static void akh(q arg0)
    {
        int i = arg0.aec();
        bad = new char[i][];
        bae = new byte[i][][];
        akk(arg0, bad, bae);
    }

    public static void aki(q arg0)
    {
        int i = arg0.aec();
        baf = new char[i][];
        bag = new byte[i][][];
        akk(arg0, baf, bag);
    }

    public static void akj(q arg0)
    {
        bac = new int[arg0.aec()];
        for(int i = 0; i < bac.length; i++)
            bac[i] = arg0.aeb();

    }

    public static void akk(q arg0, char arg1[][], byte arg2[][][])
    {
        for(int i = 0; i < arg1.length; i++)
        {
            char ac[] = new char[arg0.aea()];
            for(int j = 0; j < ac.length; j++)
                ac[j] = (char)arg0.aea();

            arg1[i] = ac;
            byte abyte0[][] = new byte[arg0.aec()][2];
            for(int k = 0; k < abyte0.length; k++)
            {
                abyte0[k][0] = (byte)arg0.aea();
                abyte0[k][1] = (byte)arg0.aea();
            }

            if(abyte0.length > 0)
                arg2[i] = abyte0;
        }

    }

    public static String akl(String arg0)
    {
        char ac[] = arg0.toLowerCase().toCharArray();
        alc(ac);
        ala(ac);
        alb(ac);
        all(ac);
        for(int i = 0; i < baj.length; i++)
        {
            for(int j = -1; (j = arg0.indexOf(baj[i], j + 1)) != -1;)
            {
                char ac1[] = baj[i].toCharArray();
                for(int k = 0; k < ac1.length; k++)
                    ac[k + j] = ac1[k];

            }

        }

        if(baa)
        {
            akm(arg0.toCharArray(), ac);
            akn(ac);
        }
        return new String(ac);
    }

    public static void akm(char arg0[], char arg1[])
    {
        for(int i = 0; i < arg0.length; i++)
            if(arg1[i] != '*' && amf(arg0[i]))
                arg1[i] = arg0[i];

    }

    public static void akn(char arg0[])
    {
        boolean flag = true;
        for(int i = 0; i < arg0.length; i++)
        {
            char c = arg0[i];
            if(amc(c))
            {
                if(flag)
                {
                    if(ame(c))
                        flag = false;
                } else
                if(amf(c))
                    arg0[i] = (char)((c + 97) - 65);
            } else
            {
                flag = true;
            }
        }

    }

    public static void ala(char arg0[])
    {
        for(int i = 0; i < 2; i++)
        {
            for(int j = bad.length - 1; j >= 0; j--)
                alg(arg0, bad[j], bae[j]);

        }

    }

    public static void alb(char arg0[])
    {
        for(int i = baf.length - 1; i >= 0; i--)
            alg(arg0, baf[i], bag[i]);

    }

    public static void alc(char arg0[])
    {
        char ac[] = (char[])arg0.clone();
        char ac1[] = {
            'd', 'o', 't'
        };
        alg(ac, ac1, null);
        char ac2[] = (char[])arg0.clone();
        char ac3[] = {
            's', 'l', 'a', 's', 'h'
        };
        alg(ac2, ac3, null);
        for(int i = 0; i < bah.length; i++)
            ald(arg0, ac, ac2, bah[i], bai[i]);

    }

    public static void ald(char arg0[], char arg1[], char arg2[], char arg3[], int arg4)
    {
        if(arg3.length > arg0.length)
            return;
        for(int i = 0; i <= arg0.length - arg3.length; i++)
        {
            int j = i;
            int k = 0;
            while(j < arg0.length) 
            {
                int l = 0;
                char c = arg0[j];
                char c1 = '\0';
                if(j + 1 < arg0.length)
                    c1 = arg0[j + 1];
                if(k < arg3.length && (l = ali(arg3[k], c, c1)) > 0)
                {
                    j += l;
                    k++;
                    continue;
                }
                if(k == 0)
                    break;
                if((l = ali(arg3[k - 1], c, c1)) > 0)
                {
                    j += l;
                    continue;
                }
                if(k >= arg3.length || !ama(c))
                    break;
                j++;
            }
            if(k >= arg3.length)
            {
                boolean flag = false;
                int i1 = ale(arg0, arg1, i);
                int j1 = alf(arg0, arg2, j - 1);
                if(anm)
                    System.out.println("Potential tld: " + arg3 + " at char " + i + " (type=" + arg4 + ", startmatch=" + i1 + ", endmatch=" + j1 + ")");
                if(arg4 == 1 && i1 > 0 && j1 > 0)
                    flag = true;
                if(arg4 == 2 && (i1 > 2 && j1 > 0 || i1 > 0 && j1 > 2))
                    flag = true;
                if(arg4 == 3 && i1 > 0 && j1 > 2)
                    flag = true;
                boolean _tmp = arg4 == 3 && i1 > 2 && j1 > 0;
                if(flag)
                {
                    if(anm)
                        System.out.println("Filtered tld: " + arg3 + " at char " + i);
                    int k1 = i;
                    int l1 = j - 1;
                    if(i1 > 2)
                    {
                        if(i1 == 4)
                        {
                            boolean flag1 = false;
                            for(int j2 = k1 - 1; j2 >= 0; j2--)
                                if(flag1)
                                {
                                    if(arg1[j2] != '*')
                                        break;
                                    k1 = j2;
                                } else
                                if(arg1[j2] == '*')
                                {
                                    k1 = j2;
                                    flag1 = true;
                                }

                        }
                        boolean flag2 = false;
                        for(int k2 = k1 - 1; k2 >= 0; k2--)
                            if(flag2)
                            {
                                if(ama(arg0[k2]))
                                    break;
                                k1 = k2;
                            } else
                            if(!ama(arg0[k2]))
                            {
                                flag2 = true;
                                k1 = k2;
                            }

                    }
                    if(j1 > 2)
                    {
                        if(j1 == 4)
                        {
                            boolean flag3 = false;
                            for(int l2 = l1 + 1; l2 < arg0.length; l2++)
                                if(flag3)
                                {
                                    if(arg2[l2] != '*')
                                        break;
                                    l1 = l2;
                                } else
                                if(arg2[l2] == '*')
                                {
                                    l1 = l2;
                                    flag3 = true;
                                }

                        }
                        boolean flag4 = false;
                        for(int i3 = l1 + 1; i3 < arg0.length; i3++)
                            if(flag4)
                            {
                                if(ama(arg0[i3]))
                                    break;
                                l1 = i3;
                            } else
                            if(!ama(arg0[i3]))
                            {
                                flag4 = true;
                                l1 = i3;
                            }

                    }
                    for(int i2 = k1; i2 <= l1; i2++)
                        arg0[i2] = '*';

                }
            }
        }

    }

    public static int ale(char arg0[], char arg1[], int arg2)
    {
        if(arg2 == 0)
            return 2;
        for(int i = arg2 - 1; i >= 0; i--)
        {
            if(!ama(arg0[i]))
                break;
            if(arg0[i] == ',' || arg0[i] == '.')
                return 3;
        }

        int j = 0;
        for(int k = arg2 - 1; k >= 0; k--)
        {
            if(!ama(arg1[k]))
                break;
            if(arg1[k] == '*')
                j++;
        }

        if(j >= 3)
            return 4;
        return !ama(arg0[arg2 - 1]) ? 0 : 1;
    }

    public static int alf(char arg0[], char arg1[], int arg2)
    {
        if(arg2 + 1 == arg0.length)
            return 2;
        for(int i = arg2 + 1; i < arg0.length; i++)
        {
            if(!ama(arg0[i]))
                break;
            if(arg0[i] == '\\' || arg0[i] == '/')
                return 3;
        }

        int j = 0;
        for(int k = arg2 + 1; k < arg0.length; k++)
        {
            if(!ama(arg1[k]))
                break;
            if(arg1[k] == '*')
                j++;
        }

        if(j >= 5)
            return 4;
        return !ama(arg0[arg2 + 1]) ? 0 : 1;
    }

    public static void alg(char arg0[], char arg1[], byte arg2[][])
    {
        if(arg1.length > arg0.length)
            return;
        for(int i = 0; i <= arg0.length - arg1.length; i++)
        {
            int j = i;
            int k = 0;
            boolean flag = false;
            while(j < arg0.length) 
            {
                int l = 0;
                char c = arg0[j];
                char c2 = '\0';
                if(j + 1 < arg0.length)
                    c2 = arg0[j + 1];
                if(k < arg1.length && (l = alj(arg1[k], c, c2)) > 0)
                {
                    j += l;
                    k++;
                    continue;
                }
                if(k == 0)
                    break;
                if((l = alj(arg1[k - 1], c, c2)) > 0)
                {
                    j += l;
                    continue;
                }
                if(k >= arg1.length || !amb(c))
                    break;
                if(ama(c) && c != '\'')
                    flag = true;
                j++;
            }
            if(k >= arg1.length)
            {
                boolean flag1 = true;
                if(anm)
                    System.out.println("Potential word: " + arg1 + " at char " + i);
                if(!flag)
                {
                    char c1 = ' ';
                    if(i - 1 >= 0)
                        c1 = arg0[i - 1];
                    char c3 = ' ';
                    if(j < arg0.length)
                        c3 = arg0[j];
                    byte byte0 = alk(c1);
                    byte byte1 = alk(c3);
                    if(arg2 != null && alh(arg2, byte0, byte1))
                        flag1 = false;
                } else
                {
                    boolean flag2 = false;
                    boolean flag3 = false;
                    if(i - 1 < 0 || ama(arg0[i - 1]) && arg0[i - 1] != '\'')
                        flag2 = true;
                    if(j >= arg0.length || ama(arg0[j]) && arg0[j] != '\'')
                        flag3 = true;
                    if(!flag2 || !flag3)
                    {
                        boolean flag4 = false;
                        int j1 = i - 2;
                        if(flag2)
                            j1 = i;
                        for(; !flag4 && j1 < j; j1++)
                            if(j1 >= 0 && (!ama(arg0[j1]) || arg0[j1] == '\''))
                            {
                                char ac[] = new char[3];
                                int k1;
                                for(k1 = 0; k1 < 3; k1++)
                                {
                                    if(j1 + k1 >= arg0.length || ama(arg0[j1 + k1]) && arg0[j1 + k1] != '\'')
                                        break;
                                    ac[k1] = arg0[j1 + k1];
                                }

                                boolean flag5 = true;
                                if(k1 == 0)
                                    flag5 = false;
                                if(k1 < 3 && j1 - 1 >= 0 && (!ama(arg0[j1 - 1]) || arg0[j1 - 1] == '\''))
                                    flag5 = false;
                                if(flag5 && !amg(ac))
                                    flag4 = true;
                            }

                        if(!flag4)
                            flag1 = false;
                    }
                }
                if(flag1)
                {
                    if(ann)
                        System.out.println("Filtered word: " + arg1 + " at char " + i);
                    for(int i1 = i; i1 < j; i1++)
                        arg0[i1] = '*';

                }
            }
        }

    }

    public static boolean alh(byte arg0[][], byte arg1, byte arg2)
    {
        int i = 0;
        if(arg0[i][0] == arg1 && arg0[i][1] == arg2)
            return true;
        int j = arg0.length - 1;
        if(arg0[j][0] == arg1 && arg0[j][1] == arg2)
            return true;
        do
        {
            int k = (i + j) / 2;
            if(arg0[k][0] == arg1 && arg0[k][1] == arg2)
                return true;
            if(arg1 < arg0[k][0] || arg1 == arg0[k][0] && arg2 < arg0[k][1])
                j = k;
            else
                i = k;
        } while(i != j && i + 1 != j);
        return false;
    }

    public static int ali(char arg0, char arg1, char arg2)
    {
        if(arg0 == arg1)
            return 1;
        if(arg0 == 'e' && arg1 == '3')
            return 1;
        if(arg0 == 't' && (arg1 == '7' || arg1 == '+'))
            return 1;
        if(arg0 == 'a' && (arg1 == '4' || arg1 == '@'))
            return 1;
        if(arg0 == 'o' && arg1 == '0')
            return 1;
        if(arg0 == 'i' && arg1 == '1')
            return 1;
        if(arg0 == 's' && arg1 == '5')
            return 1;
        if(arg0 == 'f' && arg1 == 'p' && arg2 == 'h')
            return 2;
        return arg0 != 'g' || arg1 != '9' ? 0 : 1;
    }

    public static int alj(char arg0, char arg1, char arg2)
    {
        if(arg0 == '*')
            return 0;
        if(arg0 == arg1)
            return 1;
        if(arg0 >= 'a' && arg0 <= 'z')
        {
            if(arg0 == 'e')
                return arg1 != '3' ? 0 : 1;
            if(arg0 == 't')
                return arg1 != '7' ? 0 : 1;
            if(arg0 == 'a')
                return arg1 != '4' && arg1 != '@' ? 0 : 1;
            if(arg0 == 'o')
            {
                if(arg1 == '0' || arg1 == '*')
                    return 1;
                return arg1 != '(' || arg2 != ')' ? 0 : 2;
            }
            if(arg0 == 'i')
                return arg1 != 'y' && arg1 != 'l' && arg1 != 'j' && arg1 != '1' && arg1 != '!' && arg1 != ':' && arg1 != ';' ? 0 : 1;
            if(arg0 == 'n')
                return 0;
            if(arg0 == 's')
                return arg1 != '5' && arg1 != 'z' && arg1 != '$' ? 0 : 1;
            if(arg0 == 'r')
                return 0;
            if(arg0 == 'h')
                return 0;
            if(arg0 == 'l')
                return arg1 != '1' ? 0 : 1;
            if(arg0 == 'd')
                return 0;
            if(arg0 == 'c')
                return arg1 != '(' ? 0 : 1;
            if(arg0 == 'u')
                return arg1 != 'v' ? 0 : 1;
            if(arg0 == 'm')
                return 0;
            if(arg0 == 'f')
                return arg1 != 'p' || arg2 != 'h' ? 0 : 2;
            if(arg0 == 'p')
                return 0;
            if(arg0 == 'g')
                return arg1 != '9' && arg1 != '6' ? 0 : 1;
            if(arg0 == 'w')
                return arg1 != 'v' || arg2 != 'v' ? 0 : 2;
            if(arg0 == 'y')
                return 0;
            if(arg0 == 'b')
                return arg1 != '1' || arg2 != '3' ? 0 : 2;
            if(arg0 == 'v')
                return 0;
            if(arg0 == 'k')
                return 0;
            if(arg0 == 'x')
                return arg1 != ')' || arg2 != '(' ? 0 : 2;
            if(arg0 == 'j')
                return 0;
            if(arg0 == 'q')
                return 0;
            if(arg0 == 'z')
                return 0;
        }
        if(arg0 >= '0' && arg0 <= '9')
        {
            if(arg0 == '0')
            {
                if(arg1 == 'o' || arg1 == 'O')
                    return 1;
                return arg1 != '(' || arg2 != ')' ? 0 : 2;
            }
            if(arg0 == '1')
                return arg1 != 'l' ? 0 : 1;
            if(arg0 == '2')
                return 0;
            if(arg0 == '3')
                return 0;
            if(arg0 == '4')
                return 0;
            if(arg0 == '5')
                return 0;
            if(arg0 == '6')
                return 0;
            if(arg0 == '7')
                return 0;
            if(arg0 == '8')
                return 0;
            if(arg0 == '9')
                return 0;
        }
        if(arg0 == '-')
            return 0;
        if(arg0 == ',')
            return arg1 != '.' ? 0 : 1;
        if(arg0 == '.')
            return arg1 != ',' ? 0 : 1;
        if(arg0 == '(')
            return 0;
        if(arg0 == ')')
            return 0;
        if(arg0 == '!')
            return arg1 != 'i' ? 0 : 1;
        if(arg0 == '\'')
            return 0;
        if(ann)
            System.out.println("Letter=" + arg0 + " not matched");
        return 0;
    }

    public static byte alk(char arg0)
    {
        if(arg0 >= 'a' && arg0 <= 'z')
            return (byte)((arg0 - 97) + 1);
        if(arg0 == '\'')
            return 28;
        if(arg0 >= '0' && arg0 <= '9')
            return (byte)((arg0 - 48) + 29);
        else
            return 27;
    }

    public static void all(char arg0[])
    {
        int i = 0;
        int j = 0;
        int k = 0;
        int l = 0;
        while((i = alm(arg0, j)) != -1) 
        {
            boolean flag = false;
            for(int i1 = j; i1 >= 0 && i1 < i && !flag; i1++)
                if(!ama(arg0[i1]) && !amb(arg0[i1]))
                    flag = true;

            if(flag)
                k = 0;
            if(k == 0)
                l = i;
            j = aln(arg0, i);
            int j1 = 0;
            for(int k1 = i; k1 < j; k1++)
                j1 = (j1 * 10 + arg0[k1]) - 48;

            if(j1 > 255 || j - i > 8)
                k = 0;
            else
                k++;
            if(k == 4)
            {
                for(int l1 = l; l1 < j; l1++)
                    arg0[l1] = '*';

                k = 0;
            }
        }
    }

    public static int alm(char arg0[], int arg1)
    {
        for(int i = arg1; i < arg0.length && i >= 0; i++)
            if(arg0[i] >= '0' && arg0[i] <= '9')
                return i;

        return -1;
    }

    public static int aln(char arg0[], int arg1)
    {
        for(int i = arg1; i < arg0.length && i >= 0; i++)
            if(arg0[i] < '0' || arg0[i] > '9')
                return i;

        return arg0.length;
    }

    public static boolean ama(char arg0)
    {
        return !amc(arg0) && !amd(arg0);
    }

    public static boolean amb(char arg0)
    {
        if(arg0 < 'a' || arg0 > 'z')
            return true;
        return arg0 == 'v' || arg0 == 'x' || arg0 == 'j' || arg0 == 'q' || arg0 == 'z';
    }

    public static boolean amc(char arg0)
    {
        return arg0 >= 'a' && arg0 <= 'z' || arg0 >= 'A' && arg0 <= 'Z';
    }

    public static boolean amd(char arg0)
    {
        return arg0 >= '0' && arg0 <= '9';
    }

    public static boolean ame(char arg0)
    {
        return arg0 >= 'a' && arg0 <= 'z';
    }

    public static boolean amf(char arg0)
    {
        return arg0 >= 'A' && arg0 <= 'Z';
    }

    public static boolean amg(char arg0[])
    {
        boolean flag = true;
        for(int i = 0; i < arg0.length; i++)
            if(!amd(arg0[i]) && arg0[i] != 0)
                flag = false;

        if(flag)
            return true;
        int j = amh(arg0);
        int k = 0;
        int l = bac.length - 1;
        if(j == bac[k] || j == bac[l])
            return true;
        do
        {
            int i1 = (k + l) / 2;
            if(j == bac[i1])
                return true;
            if(j < bac[i1])
                l = i1;
            else
                k = i1;
        } while(k != l && k + 1 != l);
        return false;
    }

    public static int amh(char arg0[])
    {
        if(arg0.length > 6)
            return 0;
        int i = 0;
        for(int j = 0; j < arg0.length; j++)
        {
            char c = arg0[arg0.length - j - 1];
            if(c >= 'a' && c <= 'z')
                i = i * 38 + ((c - 97) + 1);
            else
            if(c == '\'')
                i = i * 38 + 27;
            else
            if(c >= '0' && c <= '9')
                i = i * 38 + ((c - 48) + 28);
            else
            if(c != 0)
            {
                if(ann)
                    System.out.println("word2hash failed on " + new String(arg0));
                return 0;
            }
        }

        return i;
    }

    static boolean anm;
    static boolean ann;
    static boolean baa = true;
    static int bab = 3;
    static int bac[];
    static char bad[][];
    static byte bae[][][];
    static char baf[][];
    static byte bag[][][];
    static char bah[][];
    static int bai[];
    static String baj[] = {
        "cook", "cook's", "cooks", "seeks", "sheet"
    };

}