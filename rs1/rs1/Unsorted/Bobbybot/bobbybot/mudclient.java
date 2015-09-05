// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) nonlb 

import java.applet.Applet;
import java.awt.*;
import java.io.IOException;
import java.io.PrintStream;
import java.net.*;

public class mudclient extends Applet_Sub1_Sub1 {

    public static void main(String args[]) {
        mudclient mudclient1 = new mudclient();
        mudclient1.aBoolean774 = false;
        if(args.length > 0 && args[0].equals("members"))
            mudclient1.aBoolean867 = true;
        if(args.length > 1)
            mudclient1.aString616 = args[1];
        if(args.length > 2)
            mudclient1.anInt617 = Integer.parseInt(args[2]);
        mudclient1.method6(mudclient1.anInt985, mudclient1.anInt986 + 11, "Runescape by Andrew Gower", false);
        mudclient1.anInt32 = 10;
    }

    public void method45(int i, int j, int k, int l, int i1, int j1, int k1) {
        Class2 class2 = aClass2Array705[i1];
        int l1 = class2.anInt153 + (anInt809 + 16) / 32 & 7;
        boolean flag = false;
        int i2 = l1;
        if(i2 == 5) {
            i2 = 3;
            flag = true;
        } else
        if(i2 == 6) {
            i2 = 2;
            flag = true;
        } else
        if(i2 == 7) {
            i2 = 1;
            flag = true;
        }
        int j2 = i2 * 3 + anIntArray726[(class2.anInt152 / Class1.anIntArray106[class2.anInt151]) % 4];
        if(class2.anInt153 == 8) {
            i2 = 5;
            l1 = 2;
            flag = false;
            i -= (Class1.anIntArray108[class2.anInt151] * k1) / 100;
            j2 = i2 * 3 + anIntArray714[(anInt747 / (Class1.anIntArray107[class2.anInt151] - 1)) % 8];
        } else
        if(class2.anInt153 == 9) {
            i2 = 5;
            l1 = 2;
            flag = true;
            i += (Class1.anIntArray108[class2.anInt151] * k1) / 100;
            j2 = i2 * 3 + anIntArray771[(anInt747 / Class1.anIntArray107[class2.anInt151]) % 8];
        }
        for(int k2 = 0; k2 < 12; k2++) {
            int l2 = anIntArrayArray852[l1][k2];
            int k3 = Class1.anIntArrayArray136[class2.anInt151][l2];
            if(k3 >= 0) {
                int i4 = 0;
                int j4 = 0;
                int k4 = j2;
                if(flag && i2 >= 1 && i2 <= 3 && Class1.anIntArray92[k3] == 1)
                    k4 += 15;
                if(i2 != 5 || Class1.anIntArray91[k3] == 1) {
                    int l4 = k4 + Class1.anIntArray93[k3];
                    i4 = (i4 * k) / ((Class6) (aClass6_Sub1_935)).anIntArray328[l4];
                    j4 = (j4 * l) / ((Class6) (aClass6_Sub1_935)).anIntArray329[l4];
                    int i5 = (k * ((Class6) (aClass6_Sub1_935)).anIntArray328[l4]) / ((Class6) (aClass6_Sub1_935)).anIntArray328[Class1.anIntArray93[k3]];
                    i4 -= (i5 - k) / 2;
                    int j5 = Class1.anIntArray89[k3];
                    int k5 = 0;
                    if(j5 == 1) {
                        j5 = Class1.anIntArray132[class2.anInt151];
                        k5 = Class1.anIntArray135[class2.anInt151];
                    } else
                    if(j5 == 2) {
                        j5 = Class1.anIntArray133[class2.anInt151];
                        k5 = Class1.anIntArray135[class2.anInt151];
                    } else
                    if(j5 == 3) {
                        j5 = Class1.anIntArray134[class2.anInt151];
                        k5 = Class1.anIntArray135[class2.anInt151];
                    }
                    aClass6_Sub1_935.method246(i + i4, j + j4, i5, l, l4, j5, k5, j1, flag);
                }
            }
        }

        if(class2.anInt161 > 0) {
            anIntArray703[anInt697] = aClass6_Sub1_935.method262(class2.aString160, 1) / 2;
            if(anIntArray703[anInt697] > 150)
                anIntArray703[anInt697] = 150;
            anIntArray704[anInt697] = (aClass6_Sub1_935.method262(class2.aString160, 1) / 300) * aClass6_Sub1_935.method260(1);
            anIntArray701[anInt697] = i + k / 2;
            anIntArray702[anInt697] = j;
            aStringArray698[anInt697++] = class2.aString160;
        }
        if(class2.anInt153 == 8 || class2.anInt153 == 9 || class2.anInt167 != 0) {
            if(class2.anInt167 > 0) {
                int i3 = i;
                if(class2.anInt153 == 8)
                    i3 -= (20 * k1) / 100;
                else
                if(class2.anInt153 == 9)
                    i3 += (20 * k1) / 100;
                int l3 = (class2.anInt165 * 30) / class2.anInt166;
                anIntArray796[anInt728] = i3 + k / 2;
                anIntArray797[anInt728] = j;
                anIntArray798[anInt728++] = l3;
            }
            if(class2.anInt167 > 150) {
                int j3 = i;
                if(class2.anInt153 == 8)
                    j3 -= (10 * k1) / 100;
                else
                if(class2.anInt153 == 9)
                    j3 += (10 * k1) / 100;
                aClass6_Sub1_935.method230((j3 + k / 2) - 12, (j + l / 2) - 12, anInt778 + 12);
                aClass6_Sub1_935.method254(String.valueOf(class2.anInt164), (j3 + k / 2) - 1, j + l / 2 + 5, 3, 0xffffff);
            }
        }
    }

    public void method46() {
        aClass4_955.method138(super.anInt33, super.anInt34, super.anInt36, super.anInt35);
        if(aClass4_955.method139(anInt854))
            do
                anInt818 = ((anInt818 - 1) + Class1.anInt103) % Class1.anInt103;
            while((Class1.anIntArray90[anInt818] & 3) != 1 || (Class1.anIntArray90[anInt818] & 4 * anInt825) == 0);
        if(aClass4_955.method139(anInt855))
            do
                anInt818 = (anInt818 + 1) % Class1.anInt103;
            while((Class1.anIntArray90[anInt818] & 3) != 1 || (Class1.anIntArray90[anInt818] & 4 * anInt825) == 0);
        if(aClass4_955.method139(anInt856))
            anInt821 = ((anInt821 - 1) + anIntArray804.length) % anIntArray804.length;
        if(aClass4_955.method139(anInt857))
            anInt821 = (anInt821 + 1) % anIntArray804.length;
        if(aClass4_955.method139(anInt858) || aClass4_955.method139(anInt859)) {
            for(anInt825 = 3 - anInt825; (Class1.anIntArray90[anInt818] & 3) != 1 || (Class1.anIntArray90[anInt818] & 4 * anInt825) == 0; anInt818 = (anInt818 + 1) % Class1.anInt103);
            for(; (Class1.anIntArray90[anInt819] & 3) != 2 || (Class1.anIntArray90[anInt819] & 4 * anInt825) == 0; anInt819 = (anInt819 + 1) % Class1.anInt103);
        }
        if(aClass4_955.method139(anInt860))
            anInt822 = ((anInt822 - 1) + anIntArray707.length) % anIntArray707.length;
        if(aClass4_955.method139(anInt861))
            anInt822 = (anInt822 + 1) % anIntArray707.length;
        if(aClass4_955.method139(anInt862))
            anInt824 = ((anInt824 - 1) + anIntArray976.length) % anIntArray976.length;
        if(aClass4_955.method139(anInt863))
            anInt824 = (anInt824 + 1) % anIntArray976.length;
        if(aClass4_955.method139(anInt864))
            anInt823 = ((anInt823 - 1) + anIntArray707.length) % anIntArray707.length;
        if(aClass4_955.method139(anInt865))
            anInt823 = (anInt823 + 1) % anIntArray707.length;
        if(aClass4_955.method139(anInt866)) {
            super.aClass14_Sub1_620.method348(218);
            super.aClass14_Sub1_620.method331(anInt825);
            super.aClass14_Sub1_620.method331(anInt818);
            super.aClass14_Sub1_620.method331(anInt819);
            super.aClass14_Sub1_620.method331(anInt820);
            super.aClass14_Sub1_620.method331(anInt821);
            super.aClass14_Sub1_620.method331(anInt822);
            super.aClass14_Sub1_620.method331(anInt823);
            super.aClass14_Sub1_620.method331(anInt824);
            super.aClass14_Sub1_620.method330();
            aClass6_Sub1_935.method211();
            aBoolean769 = false;
        }
    }

    public int method47(int i) {
        int j = 0;
        for(int k = 0; k < anInt692; k++)
            if(anIntArray693[k] == i)
                if(Class1.anIntArray73[i] == 1)
                    j++;
                else
                    j += anIntArray694[k];

        return j;
    }

    public void method48() {
        if(super.anInt636 > 0)
            super.anInt636--;
        if(anInt708 == 0) {
            aClass4_806.method138(super.anInt33, super.anInt34, super.anInt36, super.anInt35);
            if(aClass4_806.method139(anInt671))
                anInt708 = 1;
            if(aClass4_806.method139(anInt672)) {
                anInt708 = 2;
                aClass4_803.method168(anInt826, "Please enter your username and password");
                aClass4_803.method168(anInt827, "");
                aClass4_803.method168(anInt828, "");
                aClass4_803.method172(anInt827);
                return;
            }
        } else
        if(anInt708 == 1) {
            aClass4_877.method138(super.anInt33, super.anInt34, super.anInt36, super.anInt35);
            if(aClass4_877.method139(anInt911)) {
                anInt708 = 0;
                return;
            }
        } else
        if(anInt708 == 2) {
            aClass4_803.method138(super.anInt33, super.anInt34, super.anInt36, super.anInt35);
            if(aClass4_803.method139(anInt830))
                anInt708 = 0;
            if(aClass4_803.method139(anInt827))
                aClass4_803.method172(anInt828);
            if(aClass4_803.method139(anInt828) || aClass4_803.method139(anInt829)) {
                aString673 = aClass4_803.method169(anInt827);
                aString674 = aClass4_803.method169(anInt828);
                method21(aString673, aString674, false);
            }
        }
    }

    public void method20(Runnable runnable) {
        if(Class8.anApplet370 != null) {
            Class8.method266(runnable);
            return;
        } else {
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            thread.start();
            return;
        }
    }

    public void method49() {
        aBoolean745 = false;
        aClass6_Sub1_935.aBoolean335 = false;
        aClass6_Sub1_935.method211();
        if(anInt708 == 0 || anInt708 == 1 || anInt708 == 2 || anInt708 == 3) {
            int i = (anInt747 * 2) % 3072;
            if(i < 1024) {
                aClass6_Sub1_935.method230(0, 10, anInt784);
                if(i > 768)
                    aClass6_Sub1_935.method232(0, 10, anInt784 + 1, i - 768);
            } else
            if(i < 2048) {
                aClass6_Sub1_935.method230(0, 10, anInt784 + 1);
                if(i > 1792)
                    aClass6_Sub1_935.method232(0, 10, anInt778 + 10, i - 1792);
            } else {
                aClass6_Sub1_935.method230(0, 10, anInt778 + 10);
                if(i > 2816)
                    aClass6_Sub1_935.method232(0, 10, anInt784, i - 2816);
            }
        }
        if(anInt708 == 0)
            aClass4_806.method141();
        if(anInt708 == 1)
            aClass4_877.method141();
        if(anInt708 == 2)
            aClass4_803.method141();
        aClass6_Sub1_935.method230(0, anInt986, anInt778 + 22);
        aClass6_Sub1_935.method210(aGraphics946, 0, 0);
    }

    public void method50() {
        anInt839 = 0;
        int i = 135;
        for(int j = 0; j < 12; j++) {
            if(super.anInt33 > 66 && super.anInt33 < 446 && super.anInt34 >= i - 12 && super.anInt34 < i + 3)
                anInt839 = j + 1;
            i += 14;
        }

        if(anInt912 != 0 && anInt839 != 0) {
            anInt912 = 0;
            anInt738 = 2;
            super.aString40 = "";
            super.aString41 = "";
            return;
        }
        i += 15;
        if(anInt912 != 0) {
            anInt912 = 0;
            if(super.anInt33 < 56 || super.anInt34 < 35 || super.anInt33 > 456 || super.anInt34 > 325) {
                anInt738 = 0;
                return;
            }
            if(super.anInt33 > 66 && super.anInt33 < 446 && super.anInt34 >= i - 15 && super.anInt34 < i + 5) {
                anInt738 = 0;
                return;
            }
        }
        aClass6_Sub1_935.method215(56, 35, 400, 290, 0);
        aClass6_Sub1_935.method216(56, 35, 400, 290, 0xffffff);
        i = 50;
        aClass6_Sub1_935.method254("This form is for reporting players who are breaking our rules", 256, i, 1, 0xffffff);
        i += 15;
        aClass6_Sub1_935.method254("Using it sends a snapshot of the last 60 secs of activity to us", 256, i, 1, 0xffffff);
        i += 15;
        aClass6_Sub1_935.method254("If you misuse this form, you will be banned.", 256, i, 1, 0xff8000);
        i += 15;
        i += 10;
        aClass6_Sub1_935.method254("First indicate which of our 12 rules is being broken. For a detailed", 256, i, 1, 0xffff00);
        i += 15;
        aClass6_Sub1_935.method254("explanation of each rule please read the manual on our website.", 256, i, 1, 0xffff00);
        i += 15;
        int k;
        if(anInt839 == 1) {
            aClass6_Sub1_935.method216(66, i - 12, 380, 15, 0xffffff);
            k = 0xff8000;
        } else {
            k = 0xffffff;
        }
        aClass6_Sub1_935.method254("1: Offensive language", 256, i, 1, k);
        i += 14;
        if(anInt839 == 2) {
            aClass6_Sub1_935.method216(66, i - 12, 380, 15, 0xffffff);
            k = 0xff8000;
        } else {
            k = 0xffffff;
        }
        aClass6_Sub1_935.method254("2: Item scamming", 256, i, 1, k);
        i += 14;
        if(anInt839 == 3) {
            aClass6_Sub1_935.method216(66, i - 12, 380, 15, 0xffffff);
            k = 0xff8000;
        } else {
            k = 0xffffff;
        }
        aClass6_Sub1_935.method254("3: Password scamming", 256, i, 1, k);
        i += 14;
        if(anInt839 == 4) {
            aClass6_Sub1_935.method216(66, i - 12, 380, 15, 0xffffff);
            k = 0xff8000;
        } else {
            k = 0xffffff;
        }
        aClass6_Sub1_935.method254("4: Bug abuse", 256, i, 1, k);
        i += 14;
        if(anInt839 == 5) {
            aClass6_Sub1_935.method216(66, i - 12, 380, 15, 0xffffff);
            k = 0xff8000;
        } else {
            k = 0xffffff;
        }
        aClass6_Sub1_935.method254("5: Jagex Staff impersonation", 256, i, 1, k);
        i += 14;
        if(anInt839 == 6) {
            aClass6_Sub1_935.method216(66, i - 12, 380, 15, 0xffffff);
            k = 0xff8000;
        } else {
            k = 0xffffff;
        }
        aClass6_Sub1_935.method254("6: Account sharing/trading", 256, i, 1, k);
        i += 14;
        if(anInt839 == 7) {
            aClass6_Sub1_935.method216(66, i - 12, 380, 15, 0xffffff);
            k = 0xff8000;
        } else {
            k = 0xffffff;
        }
        aClass6_Sub1_935.method254("7: Macroing", 256, i, 1, k);
        i += 14;
        if(anInt839 == 8) {
            aClass6_Sub1_935.method216(66, i - 12, 380, 15, 0xffffff);
            k = 0xff8000;
        } else {
            k = 0xffffff;
        }
        aClass6_Sub1_935.method254("8: Mutiple logging in", 256, i, 1, k);
        i += 14;
        if(anInt839 == 9) {
            aClass6_Sub1_935.method216(66, i - 12, 380, 15, 0xffffff);
            k = 0xff8000;
        } else {
            k = 0xffffff;
        }
        aClass6_Sub1_935.method254("9: Encouraging others to break rules", 256, i, 1, k);
        i += 14;
        if(anInt839 == 10) {
            aClass6_Sub1_935.method216(66, i - 12, 380, 15, 0xffffff);
            k = 0xff8000;
        } else {
            k = 0xffffff;
        }
        aClass6_Sub1_935.method254("10: Misuse of customer support", 256, i, 1, k);
        i += 14;
        if(anInt839 == 11) {
            aClass6_Sub1_935.method216(66, i - 12, 380, 15, 0xffffff);
            k = 0xff8000;
        } else {
            k = 0xffffff;
        }
        aClass6_Sub1_935.method254("11: Advertising / website", 256, i, 1, k);
        i += 14;
        if(anInt839 == 12) {
            aClass6_Sub1_935.method216(66, i - 12, 380, 15, 0xffffff);
            k = 0xff8000;
        } else {
            k = 0xffffff;
        }
        aClass6_Sub1_935.method254("12: Real world item trading", 256, i, 1, k);
        i += 14;
        i += 15;
        k = 0xffffff;
        if(super.anInt33 > 196 && super.anInt33 < 316 && super.anInt34 > i - 15 && super.anInt34 < i + 5)
            k = 0xffff00;
        aClass6_Sub1_935.method254("Click here to cancel", 256, i, 1, k);
    }

    public void method51() {
        if((anInt731 & 1) == 1 && method100(anInt731))
            return;
        if((anInt731 & 1) == 0 && method100(anInt731)) {
            if(method100(anInt731 + 1 & 7)) {
                anInt731 = anInt731 + 1 & 7;
                return;
            }
            if(method100(anInt731 + 7 & 7))
                anInt731 = anInt731 + 7 & 7;
            return;
        }
        int ai[] = {
            1, -1, 2, -2, 3, -3, 4
        };
        for(int i = 0; i < 7; i++) {
            if(!method100(anInt731 + ai[i] + 8 & 7))
                continue;
            anInt731 = anInt731 + ai[i] + 8 & 7;
            break;
        }

        if((anInt731 & 1) == 0 && method100(anInt731)) {
            if(method100(anInt731 + 1 & 7)) {
                anInt731 = anInt731 + 1 & 7;
                return;
            }
            if(method100(anInt731 + 7 & 7))
                anInt731 = anInt731 + 7 & 7;
        }
    }

    public Graphics getGraphics() {
        if(Applet_Sub1.aFrame_Sub1_7 != null)
            return Applet_Sub1.aFrame_Sub1_7.getGraphics();
        if(Class8.anApplet370 != null)
            return Class8.anApplet370.getGraphics();
        else
            return super.getGraphics();
    }

    public void method52(int i, int j, int k, int l, int i1, int j1, int k1) {
        Class2 class2 = aClass2Array904[i1];
        if(class2.anInt171 == 255)
            return;
        int l1 = class2.anInt153 + (anInt809 + 16) / 32 & 7;
        boolean flag = false;
        int i2 = l1;
        if(i2 == 5) {
            i2 = 3;
            flag = true;
        } else
        if(i2 == 6) {
            i2 = 2;
            flag = true;
        } else
        if(i2 == 7) {
            i2 = 1;
            flag = true;
        }
        int j2 = i2 * 3 + anIntArray726[(class2.anInt152 / 6) % 4];
        if(class2.anInt153 == 8) {
            i2 = 5;
            l1 = 2;
            flag = false;
            i -= (5 * k1) / 100;
            j2 = i2 * 3 + anIntArray714[(anInt747 / 5) % 8];
        } else
        if(class2.anInt153 == 9) {
            i2 = 5;
            l1 = 2;
            flag = true;
            i += (5 * k1) / 100;
            j2 = i2 * 3 + anIntArray771[(anInt747 / 6) % 8];
        }
        for(int k2 = 0; k2 < 12; k2++) {
            int l2 = anIntArrayArray852[l1][k2];
            int l3 = class2.anIntArray159[l2] - 1;
            if(l3 >= 0) {
                int k4 = 0;
                int i5 = 0;
                int j5 = j2;
                if(flag && i2 >= 1 && i2 <= 3)
                    if(Class1.anIntArray92[l3] == 1)
                        j5 += 15;
                    else
                    if(l2 == 4 && i2 == 1) {
                        k4 = -22;
                        i5 = -3;
                        j5 = i2 * 3 + anIntArray726[(2 + class2.anInt152 / 6) % 4];
                    } else
                    if(l2 == 4 && i2 == 2) {
                        k4 = 0;
                        i5 = -8;
                        j5 = i2 * 3 + anIntArray726[(2 + class2.anInt152 / 6) % 4];
                    } else
                    if(l2 == 4 && i2 == 3) {
                        k4 = 26;
                        i5 = -5;
                        j5 = i2 * 3 + anIntArray726[(2 + class2.anInt152 / 6) % 4];
                    } else
                    if(l2 == 3 && i2 == 1) {
                        k4 = 22;
                        i5 = 3;
                        j5 = i2 * 3 + anIntArray726[(2 + class2.anInt152 / 6) % 4];
                    } else
                    if(l2 == 3 && i2 == 2) {
                        k4 = 0;
                        i5 = 8;
                        j5 = i2 * 3 + anIntArray726[(2 + class2.anInt152 / 6) % 4];
                    } else
                    if(l2 == 3 && i2 == 3) {
                        k4 = -26;
                        i5 = 5;
                        j5 = i2 * 3 + anIntArray726[(2 + class2.anInt152 / 6) % 4];
                    }
                if(i2 != 5 || Class1.anIntArray91[l3] == 1) {
                    int k5 = j5 + Class1.anIntArray93[l3];
                    k4 = (k4 * k) / ((Class6) (aClass6_Sub1_935)).anIntArray328[k5];
                    i5 = (i5 * l) / ((Class6) (aClass6_Sub1_935)).anIntArray329[k5];
                    int l5 = (k * ((Class6) (aClass6_Sub1_935)).anIntArray328[k5]) / ((Class6) (aClass6_Sub1_935)).anIntArray328[Class1.anIntArray93[l3]];
                    k4 -= (l5 - k) / 2;
                    int i6 = Class1.anIntArray89[l3];
                    int j6 = anIntArray976[class2.anInt172];
                    if(i6 == 1)
                        i6 = anIntArray804[class2.anInt169];
                    else
                    if(i6 == 2)
                        i6 = anIntArray707[class2.anInt170];
                    else
                    if(i6 == 3)
                        i6 = anIntArray707[class2.anInt171];
                    aClass6_Sub1_935.method246(i + k4, j + i5, l5, l, k5, i6, j6, j1, flag);
                }
            }
        }

        if(class2.anInt161 > 0) {
            anIntArray703[anInt697] = aClass6_Sub1_935.method262(class2.aString160, 1) / 2;
            if(anIntArray703[anInt697] > 150)
                anIntArray703[anInt697] = 150;
            anIntArray704[anInt697] = (aClass6_Sub1_935.method262(class2.aString160, 1) / 300) * aClass6_Sub1_935.method260(1);
            anIntArray701[anInt697] = i + k / 2;
            anIntArray702[anInt697] = j;
            aStringArray698[anInt697++] = class2.aString160;
        }
        if(class2.anInt163 > 0) {
            anIntArray868[anInt709] = i + k / 2;
            anIntArray869[anInt709] = j;
            anIntArray715[anInt709] = k1;
            anIntArray716[anInt709++] = class2.anInt162;
        }
        if(class2.anInt153 == 8 || class2.anInt153 == 9 || class2.anInt167 != 0) {
            if(class2.anInt167 > 0) {
                int i3 = i;
                if(class2.anInt153 == 8)
                    i3 -= (20 * k1) / 100;
                else
                if(class2.anInt153 == 9)
                    i3 += (20 * k1) / 100;
                int i4 = (class2.anInt165 * 30) / class2.anInt166;
                anIntArray796[anInt728] = i3 + k / 2;
                anIntArray797[anInt728] = j;
                anIntArray798[anInt728++] = i4;
            }
            if(class2.anInt167 > 150) {
                int j3 = i;
                if(class2.anInt153 == 8)
                    j3 -= (10 * k1) / 100;
                else
                if(class2.anInt153 == 9)
                    j3 += (10 * k1) / 100;
                aClass6_Sub1_935.method230((j3 + k / 2) - 12, (j + l / 2) - 12, anInt778 + 11);
                aClass6_Sub1_935.method254(String.valueOf(class2.anInt164), (j3 + k / 2) - 1, j + l / 2 + 5, 3, 0xffffff);
            }
        }
        if(class2.anInt179 == 1 && class2.anInt163 == 0) {
            int k3 = j1 + i + k / 2;
            if(class2.anInt153 == 8)
                k3 -= (20 * k1) / 100;
            else
            if(class2.anInt153 == 9)
                k3 += (20 * k1) / 100;
            int j4 = (16 * k1) / 100;
            int l4 = (16 * k1) / 100;
            aClass6_Sub1_935.method231(k3 - j4 / 2, j - l4 / 2 - (10 * k1) / 100, j4, l4, anInt778 + 13);
        }
    }

    public void method53() {
        byte abyte0[] = method18("config" + Class18.anInt574 + ".jag", "Configuration", 10);
        if(abyte0 == null) {
            aBoolean937 = true;
            return;
        }
        Class1.method128(abyte0, aBoolean867);
        byte abyte1[] = method18("filter" + Class18.anInt581 + ".jag", "Chat system", 15);
        if(abyte1 == null) {
            aBoolean937 = true;
            return;
        } else {
            byte abyte2[] = Class15.method365("fragmentsenc.txt", 0, abyte1);
            byte abyte3[] = Class15.method365("badenc.txt", 0, abyte1);
            byte abyte4[] = Class15.method365("hostenc.txt", 0, abyte1);
            byte abyte5[] = Class15.method365("tldlist.txt", 0, abyte1);
            Class16.method367(new Class13(abyte2), new Class13(abyte3), new Class13(abyte4), new Class13(abyte5));
            return;
        }
    }

    public void method54() {
        Class1.method123("torcha2");
        Class1.method123("torcha3");
        Class1.method123("torcha4");
        Class1.method123("skulltorcha2");
        Class1.method123("skulltorcha3");
        Class1.method123("skulltorcha4");
        Class1.method123("firea2");
        Class1.method123("firea3");
        Class1.method123("fireplacea2");
        Class1.method123("fireplacea3");
        Class1.method123("firespell2");
        Class1.method123("firespell3");
        Class1.method123("lightning2");
        Class1.method123("lightning3");
        Class1.method123("clawspell2");
        Class1.method123("clawspell3");
        Class1.method123("clawspell4");
        Class1.method123("clawspell5");
        Class1.method123("spellcharge2");
        Class1.method123("spellcharge3");
        if(method7()) {
            byte abyte0[] = method18("models" + Class18.anInt577 + ".jag", "3d models", 60);
            if(abyte0 == null) {
                aBoolean937 = true;
                return;
            }
            for(int j = 0; j < Class1.anInt109; j++) {
                int k = Class15.method363(Class1.aStringArray98[j] + ".ob3", abyte0);
                if(k != 0)
                    aClass5Array777[j] = new Class5(abyte0, k, true);
                else
                    aClass5Array777[j] = new Class5(1, 1);
                if(Class1.aStringArray98[j].equals("giantcrystal"))
                    aClass5Array777[j].aBoolean256 = true;
            }

            return;
        }
        method15(70, "Loading 3d models");
        for(int i = 0; i < Class1.anInt109; i++) {
            aClass5Array777[i] = new Class5("../gamedata/models/" + Class1.aStringArray98[i] + ".ob2");
            if(Class1.aStringArray98[i].equals("giantcrystal"))
                aClass5Array777[i].aBoolean256 = true;
        }

    }

    public void method11(int i, int j, int k) {
        anIntArray942[anInt941] = j;
        anIntArray943[anInt941] = k;
        anInt941 = anInt941 + 1 & 0x1fff;
        for(int l = 10; l < 4000; l++) {
            int i1 = anInt941 - l & 0x1fff;
            if(anIntArray942[i1] == j && anIntArray943[i1] == k) {
                boolean flag = false;
                for(int j1 = 1; j1 < l; j1++) {
                    int k1 = anInt941 - j1 & 0x1fff;
                    int l1 = i1 - j1 & 0x1fff;
                    if(anIntArray942[l1] != j || anIntArray943[l1] != k)
                        flag = true;
                    if(anIntArray942[k1] != anIntArray942[l1] || anIntArray943[k1] != anIntArray943[l1])
                        break;
                    if(j1 == l - 1 && flag && anInt675 == 0 && anInt810 == 0) {
                        method65();
                        return;
                    }
                }

            }
        }

    }

    public Socket method19(String s, int i) throws IOException {
        if(Class8.anApplet370 != null) {
            Socket socket = Class8.method265(i);
            if(socket == null)
                throw new IOException();
            else
                return socket;
        }
        Socket socket1;
        if(method7())
            socket1 = new Socket(InetAddress.getByName(getCodeBase().getHost()), i);
        else
            socket1 = new Socket(InetAddress.getByName(s), i);
        socket1.setSoTimeout(30000);
        socket1.setTcpNoDelay(true);
        return socket1;
    }

    public void method4() {
        if(aBoolean937) {
            Graphics g = getGraphics();
            g.setColor(Color.black);
            g.fillRect(0, 0, 512, 356);
            g.setFont(new Font("Helvetica", 1, 16));
            g.setColor(Color.yellow);
            int i = 35;
            g.drawString("Sorry, an error has occured whilst loading RuneScape", 30, i);
            i += 50;
            g.setColor(Color.white);
            g.drawString("To fix this try the following (in order):", 30, i);
            i += 50;
            g.setColor(Color.white);
            g.setFont(new Font("Helvetica", 1, 12));
            g.drawString("1: Try closing ALL open web-browser windows, and reloading", 30, i);
            i += 30;
            g.drawString("2: Try clearing your web-browsers cache from tools->internet options", 30, i);
            i += 30;
            g.drawString("3: Try using a different game-world", 30, i);
            i += 30;
            g.drawString("4: Try rebooting your computer", 30, i);
            i += 30;
            g.drawString("5: Try selecting a different version of Java from the play-game menu", 30, i);
            method8(1);
            return;
        }
        if(aBoolean988) {
            Graphics g1 = getGraphics();
            g1.setColor(Color.black);
            g1.fillRect(0, 0, 512, 356);
            g1.setFont(new Font("Helvetica", 1, 20));
            g1.setColor(Color.white);
            g1.drawString("Error - unable to load game!", 50, 50);
            g1.drawString("To play RuneScape make sure you play from", 50, 100);
            g1.drawString("http://www.runescape.com", 50, 150);
            method8(1);
            return;
        }
        if(aBoolean723) {
            Graphics g2 = getGraphics();
            g2.setColor(Color.black);
            g2.fillRect(0, 0, 512, 356);
            g2.setFont(new Font("Helvetica", 1, 20));
            g2.setColor(Color.white);
            g2.drawString("Error - out of memory!", 50, 50);
            g2.drawString("Close ALL unnecessary programs", 50, 100);
            g2.drawString("and windows before loading the game", 50, 150);
            g2.drawString("RuneScape needs about 48meg of spare RAM", 50, 200);
            method8(1);
            return;
        }
        try {
            if(anInt730 == 0) {
                aClass6_Sub1_935.aBoolean338 = false;
                method49();
            }
            if(anInt730 == 1) {
                aClass6_Sub1_935.aBoolean338 = true;
                method75();
                return;
            }
        }
        catch(OutOfMemoryError _ex) {
            method79();
            aBoolean723 = true;
        }
    }

    public void method55(int i, int j, int k, int l) {
        int i1;
        int j1;
        if(k == 0 || k == 4) {
            i1 = Class1.anIntArray67[l];
            j1 = Class1.anIntArray68[l];
        } else {
            j1 = Class1.anIntArray67[l];
            i1 = Class1.anIntArray68[l];
        }
        if(Class1.anIntArray69[l] == 2 || Class1.anIntArray69[l] == 3) {
            if(k == 0) {
                i--;
                i1++;
            }
            if(k == 2)
                j1++;
            if(k == 4)
                i1++;
            if(k == 6) {
                j--;
                j1++;
            }
            method103(anInt889, anInt890, i, j, (i + i1) - 1, (j + j1) - 1, false, true);
            return;
        } else {
            method103(anInt889, anInt890, i, j, (i + i1) - 1, (j + j1) - 1, true, true);
            return;
        }
    }

    public void method56() {
        char c = '\u0198';
        char c1 = '\u014E';
        if(anInt688 > 0 && anInt853 <= 48)
            anInt688 = 0;
        if(anInt688 > 1 && anInt853 <= 96)
            anInt688 = 1;
        if(anInt688 > 2 && anInt853 <= 144)
            anInt688 = 2;
        if(anInt831 >= anInt853 || anInt831 < 0)
            anInt831 = -1;
        if(anInt831 != -1 && anIntArray915[anInt831] != anInt832) {
            anInt831 = -1;
            anInt832 = -2;
        }
        if(anInt912 != 0) {
            anInt912 = 0;
            int i = super.anInt33 - (256 - c / 2);
            int k = super.anInt34 - (170 - c1 / 2);
            if(i >= 0 && k >= 12 && i < 408 && k < 280) {
                int i1 = anInt688 * 48;
                for(int l1 = 0; l1 < 6; l1++) {
                    for(int j2 = 0; j2 < 8; j2++) {
                        int l6 = 7 + j2 * 49;
                        int j7 = 28 + l1 * 34;
                        if(i > l6 && i < l6 + 49 && k > j7 && k < j7 + 34 && i1 < anInt853 && anIntArray915[i1] != -1) {
                            anInt832 = anIntArray915[i1];
                            anInt831 = i1;
                        }
                        i1++;
                    }

                }

                i = 256 - c / 2;
                k = 170 - c1 / 2;
                int k2;
                if(anInt831 < 0)
                    k2 = -1;
                else
                    k2 = anIntArray915[anInt831];
                if(k2 != -1) {
                    int j1 = anIntArray916[anInt831];
                    if(Class1.anIntArray73[k2] == 1 && j1 > 1)
                        j1 = 1;
                    if(j1 >= 1 && super.anInt33 >= i + 220 && super.anInt34 >= k + 238 && super.anInt33 < i + 250 && super.anInt34 <= k + 249) {
                        super.aClass14_Sub1_620.method348(183);
                        super.aClass14_Sub1_620.method336(k2);
                        super.aClass14_Sub1_620.method336(1);
                        super.aClass14_Sub1_620.method334(0x12345678);
                        super.aClass14_Sub1_620.method330();
                    }
                    if(j1 >= 5 && super.anInt33 >= i + 250 && super.anInt34 >= k + 238 && super.anInt33 < i + 280 && super.anInt34 <= k + 249) {
                        super.aClass14_Sub1_620.method348(183);
                        super.aClass14_Sub1_620.method336(k2);
                        super.aClass14_Sub1_620.method336(5);
                        super.aClass14_Sub1_620.method334(0x12345678);
                        super.aClass14_Sub1_620.method330();
                    }
                    if(j1 >= 25 && super.anInt33 >= i + 280 && super.anInt34 >= k + 238 && super.anInt33 < i + 305 && super.anInt34 <= k + 249) {
                        super.aClass14_Sub1_620.method348(183);
                        super.aClass14_Sub1_620.method336(k2);
                        super.aClass14_Sub1_620.method336(25);
                        super.aClass14_Sub1_620.method334(0x12345678);
                        super.aClass14_Sub1_620.method330();
                    }
                    if(j1 >= 100 && super.anInt33 >= i + 305 && super.anInt34 >= k + 238 && super.anInt33 < i + 335 && super.anInt34 <= k + 249) {
                        super.aClass14_Sub1_620.method348(183);
                        super.aClass14_Sub1_620.method336(k2);
                        super.aClass14_Sub1_620.method336(100);
                        super.aClass14_Sub1_620.method334(0x12345678);
                        super.aClass14_Sub1_620.method330();
                    }
                    if(j1 >= 500 && super.anInt33 >= i + 335 && super.anInt34 >= k + 238 && super.anInt33 < i + 368 && super.anInt34 <= k + 249) {
                        super.aClass14_Sub1_620.method348(183);
                        super.aClass14_Sub1_620.method336(k2);
                        super.aClass14_Sub1_620.method336(500);
                        super.aClass14_Sub1_620.method334(0x12345678);
                        super.aClass14_Sub1_620.method330();
                    }
                    if(j1 >= 2500 && super.anInt33 >= i + 370 && super.anInt34 >= k + 238 && super.anInt33 < i + 400 && super.anInt34 <= k + 249) {
                        super.aClass14_Sub1_620.method348(183);
                        super.aClass14_Sub1_620.method336(k2);
                        super.aClass14_Sub1_620.method336(2500);
                        super.aClass14_Sub1_620.method334(0x12345678);
                        super.aClass14_Sub1_620.method330();
                    }
                    if(method47(k2) >= 1 && super.anInt33 >= i + 220 && super.anInt34 >= k + 263 && super.anInt33 < i + 250 && super.anInt34 <= k + 274) {
                        super.aClass14_Sub1_620.method348(198);
                        super.aClass14_Sub1_620.method336(k2);
                        super.aClass14_Sub1_620.method336(1);
                        super.aClass14_Sub1_620.method334(0x87654321);
                        super.aClass14_Sub1_620.method330();
                    }
                    if(method47(k2) >= 5 && super.anInt33 >= i + 250 && super.anInt34 >= k + 263 && super.anInt33 < i + 280 && super.anInt34 <= k + 274) {
                        super.aClass14_Sub1_620.method348(198);
                        super.aClass14_Sub1_620.method336(k2);
                        super.aClass14_Sub1_620.method336(5);
                        super.aClass14_Sub1_620.method334(0x87654321);
                        super.aClass14_Sub1_620.method330();
                    }
                    if(method47(k2) >= 25 && super.anInt33 >= i + 280 && super.anInt34 >= k + 263 && super.anInt33 < i + 305 && super.anInt34 <= k + 274) {
                        super.aClass14_Sub1_620.method348(198);
                        super.aClass14_Sub1_620.method336(k2);
                        super.aClass14_Sub1_620.method336(25);
                        super.aClass14_Sub1_620.method334(0x87654321);
                        super.aClass14_Sub1_620.method330();
                    }
                    if(method47(k2) >= 100 && super.anInt33 >= i + 305 && super.anInt34 >= k + 263 && super.anInt33 < i + 335 && super.anInt34 <= k + 274) {
                        super.aClass14_Sub1_620.method348(198);
                        super.aClass14_Sub1_620.method336(k2);
                        super.aClass14_Sub1_620.method336(100);
                        super.aClass14_Sub1_620.method334(0x87654321);
                        super.aClass14_Sub1_620.method330();
                    }
                    if(method47(k2) >= 500 && super.anInt33 >= i + 335 && super.anInt34 >= k + 263 && super.anInt33 < i + 368 && super.anInt34 <= k + 274) {
                        super.aClass14_Sub1_620.method348(198);
                        super.aClass14_Sub1_620.method336(k2);
                        super.aClass14_Sub1_620.method336(500);
                        super.aClass14_Sub1_620.method334(0x87654321);
                        super.aClass14_Sub1_620.method330();
                    }
                    if(method47(k2) >= 2500 && super.anInt33 >= i + 370 && super.anInt34 >= k + 263 && super.anInt33 < i + 400 && super.anInt34 <= k + 274) {
                        super.aClass14_Sub1_620.method348(198);
                        super.aClass14_Sub1_620.method336(k2);
                        super.aClass14_Sub1_620.method336(2500);
                        super.aClass14_Sub1_620.method334(0x87654321);
                        super.aClass14_Sub1_620.method330();
                    }
                }
            } else
            if(anInt853 > 48 && i >= 50 && i <= 115 && k <= 12)
                anInt688 = 0;
            else
            if(anInt853 > 48 && i >= 115 && i <= 180 && k <= 12)
                anInt688 = 1;
            else
            if(anInt853 > 96 && i >= 180 && i <= 245 && k <= 12)
                anInt688 = 2;
            else
            if(anInt853 > 144 && i >= 245 && i <= 310 && k <= 12) {
                anInt688 = 3;
            } else {
                super.aClass14_Sub1_620.method348(48);
                super.aClass14_Sub1_620.method330();
                aBoolean699 = false;
                return;
            }
        }
        int j = 256 - c / 2;
        int l = 170 - c1 / 2;
        aClass6_Sub1_935.method215(j, l, 408, 12, 192);
        int k1 = 0x989898;
        aClass6_Sub1_935.method213(j, l + 12, 408, 17, k1, 160);
        aClass6_Sub1_935.method213(j, l + 29, 8, 204, k1, 160);
        aClass6_Sub1_935.method213(j + 399, l + 29, 9, 204, k1, 160);
        aClass6_Sub1_935.method213(j, l + 233, 408, 47, k1, 160);
        aClass6_Sub1_935.method256("Bank", j + 1, l + 10, 1, 0xffffff);
        int i2 = 50;
        if(anInt853 > 48) {
            int l2 = 0xffffff;
            if(anInt688 == 0)
                l2 = 0xff0000;
            else
            if(super.anInt33 > j + i2 && super.anInt34 >= l && super.anInt33 < j + i2 + 65 && super.anInt34 < l + 12)
                l2 = 0xffff00;
            aClass6_Sub1_935.method256("<page 1>", j + i2, l + 10, 1, l2);
            i2 += 65;
            l2 = 0xffffff;
            if(anInt688 == 1)
                l2 = 0xff0000;
            else
            if(super.anInt33 > j + i2 && super.anInt34 >= l && super.anInt33 < j + i2 + 65 && super.anInt34 < l + 12)
                l2 = 0xffff00;
            aClass6_Sub1_935.method256("<page 2>", j + i2, l + 10, 1, l2);
            i2 += 65;
        }
        if(anInt853 > 96) {
            int i3 = 0xffffff;
            if(anInt688 == 2)
                i3 = 0xff0000;
            else
            if(super.anInt33 > j + i2 && super.anInt34 >= l && super.anInt33 < j + i2 + 65 && super.anInt34 < l + 12)
                i3 = 0xffff00;
            aClass6_Sub1_935.method256("<page 3>", j + i2, l + 10, 1, i3);
            i2 += 65;
        }
        if(anInt853 > 144) {
            int j3 = 0xffffff;
            if(anInt688 == 3)
                j3 = 0xff0000;
            else
            if(super.anInt33 > j + i2 && super.anInt34 >= l && super.anInt33 < j + i2 + 65 && super.anInt34 < l + 12)
                j3 = 0xffff00;
            aClass6_Sub1_935.method256("<page 4>", j + i2, l + 10, 1, j3);
            i2 += 65;
        }
        int k3 = 0xffffff;
        if(super.anInt33 > j + 320 && super.anInt34 >= l && super.anInt33 < j + 408 && super.anInt34 < l + 12)
            k3 = 0xff0000;
        aClass6_Sub1_935.method253("Close window", j + 406, l + 10, 1, k3);
        aClass6_Sub1_935.method256("Number in bank in green", j + 7, l + 24, 1, 65280);
        aClass6_Sub1_935.method256("Number held in blue", j + 289, l + 24, 1, 65535);
        int i7 = 0xd0d0d0;
        int k7 = anInt688 * 48;
        for(int i8 = 0; i8 < 6; i8++) {
            for(int j8 = 0; j8 < 8; j8++) {
                int l8 = j + 7 + j8 * 49;
                int i9 = l + 28 + i8 * 34;
                if(anInt831 == k7)
                    aClass6_Sub1_935.method213(l8, i9, 49, 34, 0xff0000, 160);
                else
                    aClass6_Sub1_935.method213(l8, i9, 49, 34, i7, 160);
                aClass6_Sub1_935.method216(l8, i9, 50, 35, 0);
                if(k7 < anInt853 && anIntArray915[k7] != -1) {
                    aClass6_Sub1_935.method246(l8, i9, 48, 32, anInt780 + Class1.anIntArray71[anIntArray915[k7]], Class1.anIntArray76[anIntArray915[k7]], 0, 0, false);
                    aClass6_Sub1_935.method256(String.valueOf(anIntArray916[k7]), l8 + 1, i9 + 10, 1, 65280);
                    aClass6_Sub1_935.method253(String.valueOf(method47(anIntArray915[k7])), l8 + 47, i9 + 29, 1, 65535);
                }
                k7++;
            }

        }

        aClass6_Sub1_935.method217(j + 5, l + 256, 398, 0);
        if(anInt831 == -1) {
            aClass6_Sub1_935.method254("Select an object to withdraw or deposit", j + 204, l + 248, 3, 0xffff00);
            return;
        }
        int k8;
        if(anInt831 < 0)
            k8 = -1;
        else
            k8 = anIntArray915[anInt831];
        if(k8 != -1) {
            int l7 = anIntArray916[anInt831];
            if(Class1.anIntArray73[k8] == 1 && l7 > 1)
                l7 = 1;
            if(l7 > 0) {
                aClass6_Sub1_935.method256("Withdraw " + Class1.aStringArray112[k8], j + 2, l + 248, 1, 0xffffff);
                int l3 = 0xffffff;
                if(super.anInt33 >= j + 220 && super.anInt34 >= l + 238 && super.anInt33 < j + 250 && super.anInt34 <= l + 249)
                    l3 = 0xff0000;
                aClass6_Sub1_935.method256("One", j + 222, l + 248, 1, l3);
                if(l7 >= 5) {
                    int i4 = 0xffffff;
                    if(super.anInt33 >= j + 250 && super.anInt34 >= l + 238 && super.anInt33 < j + 280 && super.anInt34 <= l + 249)
                        i4 = 0xff0000;
                    aClass6_Sub1_935.method256("Five", j + 252, l + 248, 1, i4);
                }
                if(l7 >= 25) {
                    int j4 = 0xffffff;
                    if(super.anInt33 >= j + 280 && super.anInt34 >= l + 238 && super.anInt33 < j + 305 && super.anInt34 <= l + 249)
                        j4 = 0xff0000;
                    aClass6_Sub1_935.method256("25", j + 282, l + 248, 1, j4);
                }
                if(l7 >= 100) {
                    int k4 = 0xffffff;
                    if(super.anInt33 >= j + 305 && super.anInt34 >= l + 238 && super.anInt33 < j + 335 && super.anInt34 <= l + 249)
                        k4 = 0xff0000;
                    aClass6_Sub1_935.method256("100", j + 307, l + 248, 1, k4);
                }
                if(l7 >= 500) {
                    int l4 = 0xffffff;
                    if(super.anInt33 >= j + 335 && super.anInt34 >= l + 238 && super.anInt33 < j + 368 && super.anInt34 <= l + 249)
                        l4 = 0xff0000;
                    aClass6_Sub1_935.method256("500", j + 337, l + 248, 1, l4);
                }
                if(l7 >= 2500) {
                    int i5 = 0xffffff;
                    if(super.anInt33 >= j + 370 && super.anInt34 >= l + 238 && super.anInt33 < j + 400 && super.anInt34 <= l + 249)
                        i5 = 0xff0000;
                    aClass6_Sub1_935.method256("2500", j + 370, l + 248, 1, i5);
                }
            }
            if(method47(k8) > 0) {
                aClass6_Sub1_935.method256("Deposit " + Class1.aStringArray112[k8], j + 2, l + 273, 1, 0xffffff);
                int j5 = 0xffffff;
                if(super.anInt33 >= j + 220 && super.anInt34 >= l + 263 && super.anInt33 < j + 250 && super.anInt34 <= l + 274)
                    j5 = 0xff0000;
                aClass6_Sub1_935.method256("One", j + 222, l + 273, 1, j5);
                if(method47(k8) >= 5) {
                    int k5 = 0xffffff;
                    if(super.anInt33 >= j + 250 && super.anInt34 >= l + 263 && super.anInt33 < j + 280 && super.anInt34 <= l + 274)
                        k5 = 0xff0000;
                    aClass6_Sub1_935.method256("Five", j + 252, l + 273, 1, k5);
                }
                if(method47(k8) >= 25) {
                    int l5 = 0xffffff;
                    if(super.anInt33 >= j + 280 && super.anInt34 >= l + 263 && super.anInt33 < j + 305 && super.anInt34 <= l + 274)
                        l5 = 0xff0000;
                    aClass6_Sub1_935.method256("25", j + 282, l + 273, 1, l5);
                }
                if(method47(k8) >= 100) {
                    int i6 = 0xffffff;
                    if(super.anInt33 >= j + 305 && super.anInt34 >= l + 263 && super.anInt33 < j + 335 && super.anInt34 <= l + 274)
                        i6 = 0xff0000;
                    aClass6_Sub1_935.method256("100", j + 307, l + 273, 1, i6);
                }
                if(method47(k8) >= 500) {
                    int j6 = 0xffffff;
                    if(super.anInt33 >= j + 335 && super.anInt34 >= l + 263 && super.anInt33 < j + 368 && super.anInt34 <= l + 274)
                        j6 = 0xff0000;
                    aClass6_Sub1_935.method256("500", j + 337, l + 273, 1, j6);
                }
                if(method47(k8) >= 2500) {
                    int k6 = 0xffffff;
                    if(super.anInt33 >= j + 370 && super.anInt34 >= l + 263 && super.anInt33 < j + 400 && super.anInt34 <= l + 274)
                        k6 = 0xff0000;
                    aClass6_Sub1_935.method256("2500", j + 370, l + 273, 1, k6);
                }
            }
        }
    }

    public void method57() {
        aClass6_Sub1_935.method215(126, 137, 260, 60, 0);
        aClass6_Sub1_935.method216(126, 137, 260, 60, 0xffffff);
        aClass6_Sub1_935.method254("Logging out...", 256, 173, 5, 0xffffff);
    }

    public void method58(boolean flag) {
        int i = ((Class6) (aClass6_Sub1_935)).anInt311 - 248;
        aClass6_Sub1_935.method230(i, 3, anInt778 + 1);
        for(int j = 0; j < anInt892; j++) {
            int k = i + (j % 5) * 49;
            int i1 = 36 + (j / 5) * 34;
            if(j < anInt692 && anIntArray695[j] == 1)
                aClass6_Sub1_935.method213(k, i1, 49, 34, 0xff0000, 128);
            else
                aClass6_Sub1_935.method213(k, i1, 49, 34, Class6.method222(181, 181, 181), 128);
            if(j < anInt692) {
                aClass6_Sub1_935.method246(k, i1, 48, 32, anInt780 + Class1.anIntArray71[anIntArray693[j]], Class1.anIntArray76[anIntArray693[j]], 0, 0, false);
                if(Class1.anIntArray73[anIntArray693[j]] == 0)
                    aClass6_Sub1_935.method256(String.valueOf(anIntArray694[j]), k + 1, i1 + 10, 1, 0xffff00);
            }
        }

        for(int l = 1; l <= 4; l++)
            aClass6_Sub1_935.method218(i + l * 49, 36, (anInt892 / 5) * 34, 0);

        for(int j1 = 1; j1 <= anInt892 / 5 - 1; j1++)
            aClass6_Sub1_935.method217(i, 36 + j1 * 34, 245, 0);

        if(!flag)
            return;
        i = super.anInt33 - (((Class6) (aClass6_Sub1_935)).anInt311 - 248);
        int k1 = super.anInt34 - 36;
        if(i >= 0 && k1 >= 0 && i < 248 && k1 < (anInt892 / 5) * 34) {
            int l1 = i / 49 + (k1 / 34) * 5;
            if(l1 < anInt692) {
                int i2 = anIntArray693[l1];
                if(anInt919 >= 0) {
                    if(Class1.anIntArray63[anInt919] == 3) {
                        aStringArray676[anInt763] = "Cast " + Class1.aStringArray110[anInt919] + " on";
                        aStringArray833[anInt763] = "@lre@" + Class1.aStringArray112[i2];
                        anIntArray768[anInt763] = 600;
                        anIntArray844[anInt763] = l1;
                        anIntArray845[anInt763] = anInt919;
                        anInt763++;
                        return;
                    }
                } else {
                    if(anInt757 >= 0) {
                        aStringArray676[anInt763] = "Use " + aString758 + " with";
                        aStringArray833[anInt763] = "@lre@" + Class1.aStringArray112[i2];
                        anIntArray768[anInt763] = 610;
                        anIntArray844[anInt763] = l1;
                        anIntArray845[anInt763] = anInt757;
                        anInt763++;
                        return;
                    }
                    if(anIntArray695[l1] == 1) {
                        aStringArray676[anInt763] = "Remove";
                        aStringArray833[anInt763] = "@lre@" + Class1.aStringArray112[i2];
                        anIntArray768[anInt763] = 620;
                        anIntArray844[anInt763] = l1;
                        anInt763++;
                    } else
                    if(Class1.anIntArray75[i2] != 0) {
                        if((Class1.anIntArray75[i2] & 0x18) != 0)
                            aStringArray676[anInt763] = "Wield";
                        else
                            aStringArray676[anInt763] = "Wear";
                        aStringArray833[anInt763] = "@lre@" + Class1.aStringArray112[i2];
                        anIntArray768[anInt763] = 630;
                        anIntArray844[anInt763] = l1;
                        anInt763++;
                    }
                    if(!Class1.aStringArray114[i2].equals("")) {
                        aStringArray676[anInt763] = Class1.aStringArray114[i2];
                        aStringArray833[anInt763] = "@lre@" + Class1.aStringArray112[i2];
                        anIntArray768[anInt763] = 640;
                        anIntArray844[anInt763] = l1;
                        anInt763++;
                    }
                    aStringArray676[anInt763] = "Use";
                    aStringArray833[anInt763] = "@lre@" + Class1.aStringArray112[i2];
                    anIntArray768[anInt763] = 650;
                    anIntArray844[anInt763] = l1;
                    anInt763++;
                    aStringArray676[anInt763] = "Drop";
                    aStringArray833[anInt763] = "@lre@" + Class1.aStringArray112[i2];
                    anIntArray768[anInt763] = 660;
                    anIntArray844[anInt763] = l1;
                    anInt763++;
                    aStringArray676[anInt763] = "Examine";
                    aStringArray833[anInt763] = "@lre@" + Class1.aStringArray112[i2];
                    anIntArray768[anInt763] = 3600;
                    anIntArray844[anInt763] = i2;
                    anInt763++;
                }
            }
        }
    }

    public void method59() {
        byte abyte0[] = method18("textures" + Class18.anInt578 + ".jag", "Textures", 50);
        if(abyte0 == null) {
            aBoolean937 = true;
            return;
        }
        byte abyte1[] = Class15.method365("index.dat", 0, abyte0);
        aClass10_939.method302(Class1.anInt53, 7, 11);
        for(int i = 0; i < Class1.anInt53; i++) {
            String s = Class1.aStringArray55[i];
            byte abyte2[] = Class15.method365(s + ".dat", 0, abyte0);
            aClass6_Sub1_935.method224(anInt782, abyte2, abyte1, 1);
            aClass6_Sub1_935.method215(0, 0, 128, 128, 0xff00ff);
            aClass6_Sub1_935.method230(0, 0, anInt782);
            int j = ((Class6) (aClass6_Sub1_935)).anIntArray328[anInt782];
            String s1 = Class1.aStringArray56[i];
            if(s1 != null && s1.length() > 0) {
                byte abyte3[] = Class15.method365(s1 + ".dat", 0, abyte0);
                aClass6_Sub1_935.method224(anInt782, abyte3, abyte1, 1);
                aClass6_Sub1_935.method230(0, 0, anInt782);
            }
            aClass6_Sub1_935.method229(anInt783 + i, 0, 0, j, j);
            int k = j * j;
            for(int l = 0; l < k; l++)
                if(((Class6) (aClass6_Sub1_935)).anIntArrayArray321[anInt783 + i][l] == 65280)
                    ((Class6) (aClass6_Sub1_935)).anIntArrayArray321[anInt783 + i][l] = 0xff00ff;

            aClass6_Sub1_935.method226(anInt783 + i);
            aClass10_939.method303(i, ((Class6) (aClass6_Sub1_935)).aByteArrayArray322[anInt783 + i], ((Class6) (aClass6_Sub1_935)).anIntArrayArray323[anInt783 + i], j / 64 - 1);
        }

    }

    public String method60(int i) {
        if(Class8.anApplet370 != null)
            return Class8.method267(Class15.method360(i));
        else
            return Class15.method360(i);
    }

    public void method61() {
        aClass6_Sub1_935.method230(0, anInt986 - 4, anInt778 + 23);
        int i = Class6.method222(200, 200, 255);
        if(anInt816 == 0)
            i = Class6.method222(255, 200, 50);
        if(anInt962 % 30 > 15)
            i = Class6.method222(255, 50, 50);
        aClass6_Sub1_935.method254("All messages", 54, anInt986 + 6, 0, i);
        i = Class6.method222(200, 200, 255);
        if(anInt816 == 1)
            i = Class6.method222(255, 200, 50);
        if(anInt963 % 30 > 15)
            i = Class6.method222(255, 50, 50);
        aClass6_Sub1_935.method254("Chat history", 155, anInt986 + 6, 0, i);
        i = Class6.method222(200, 200, 255);
        if(anInt816 == 2)
            i = Class6.method222(255, 200, 50);
        if(anInt964 % 30 > 15)
            i = Class6.method222(255, 50, 50);
        aClass6_Sub1_935.method254("Quest history", 255, anInt986 + 6, 0, i);
        i = Class6.method222(200, 200, 255);
        if(anInt816 == 3)
            i = Class6.method222(255, 200, 50);
        if(anInt965 % 30 > 15)
            i = Class6.method222(255, 50, 50);
        aClass6_Sub1_935.method254("Private history", 355, anInt986 + 6, 0, i);
        aClass6_Sub1_935.method254("Report abuse", 457, anInt986 + 6, 0, 0xffffff);
    }

    public void method62() {
        aClass6_Sub1_935.aBoolean335 = false;
        aClass6_Sub1_935.method211();
        aClass4_955.method141();
        int i = 140;
        int j = 50;
        i += 116;
        j -= 25;
        aClass6_Sub1_935.method234(i - 32 - 55, j, 64, 102, Class1.anIntArray93[anInt820], anIntArray707[anInt823]);
        aClass6_Sub1_935.method246(i - 32 - 55, j, 64, 102, Class1.anIntArray93[anInt819], anIntArray707[anInt822], anIntArray976[anInt824], 0, false);
        aClass6_Sub1_935.method246(i - 32 - 55, j, 64, 102, Class1.anIntArray93[anInt818], anIntArray804[anInt821], anIntArray976[anInt824], 0, false);
        aClass6_Sub1_935.method234(i - 32, j, 64, 102, Class1.anIntArray93[anInt820] + 6, anIntArray707[anInt823]);
        aClass6_Sub1_935.method246(i - 32, j, 64, 102, Class1.anIntArray93[anInt819] + 6, anIntArray707[anInt822], anIntArray976[anInt824], 0, false);
        aClass6_Sub1_935.method246(i - 32, j, 64, 102, Class1.anIntArray93[anInt818] + 6, anIntArray804[anInt821], anIntArray976[anInt824], 0, false);
        aClass6_Sub1_935.method234((i - 32) + 55, j, 64, 102, Class1.anIntArray93[anInt820] + 12, anIntArray707[anInt823]);
        aClass6_Sub1_935.method246((i - 32) + 55, j, 64, 102, Class1.anIntArray93[anInt819] + 12, anIntArray707[anInt822], anIntArray976[anInt824], 0, false);
        aClass6_Sub1_935.method246((i - 32) + 55, j, 64, 102, Class1.anIntArray93[anInt818] + 12, anIntArray804[anInt821], anIntArray976[anInt824], 0, false);
        aClass6_Sub1_935.method230(0, anInt986, anInt778 + 22);
        aClass6_Sub1_935.method210(aGraphics946, 0, 0);
    }

    public Class2 method63(int i, int j, int k, int l) {
        if(aClass2Array713[i] == null) {
            aClass2Array713[i] = new Class2();
            aClass2Array713[i].anInt147 = i;
            aClass2Array713[i].anInt148 = 0;
        }
        Class2 class2 = aClass2Array713[i];
        boolean flag = false;
        for(int i1 = 0; i1 < anInt690; i1++) {
            if(aClass2Array772[i1].anInt147 != i)
                continue;
            flag = true;
            break;
        }

        if(flag) {
            class2.anInt154 = l;
            int j1 = class2.anInt156;
            if(j != class2.anIntArray157[j1] || k != class2.anIntArray158[j1]) {
                class2.anInt156 = j1 = (j1 + 1) % 10;
                class2.anIntArray157[j1] = j;
                class2.anIntArray158[j1] = k;
            }
        } else {
            class2.anInt147 = i;
            class2.anInt155 = 0;
            class2.anInt156 = 0;
            class2.anIntArray157[0] = class2.anInt149 = j;
            class2.anIntArray158[0] = class2.anInt150 = k;
            class2.anInt154 = class2.anInt153 = l;
            class2.anInt152 = 0;
        }
        aClass2Array904[anInt689++] = class2;
        return class2;
    }

    public void method64() {
        int i = 65;
        if(anInt791 != 201)
            i += 60;
        if(anInt875 > 0)
            i += 60;
        if(anInt687 != 0)
            i += 45;
        int j = 167 - i / 2;
        aClass6_Sub1_935.method215(56, 167 - i / 2, 400, i, 0);
        aClass6_Sub1_935.method216(56, 167 - i / 2, 400, i, 0xffffff);
        j += 20;
        aClass6_Sub1_935.method254("Welcome to RuneScape " + aString673, 256, j, 4, 0xffff00);
        j += 30;
        String s;
        if(anInt662 == 0)
            s = "earlier today";
        else
        if(anInt662 == 1)
            s = "yesterday";
        else
            s = anInt662 + " days ago";
        if(anInt687 != 0) {
            aClass6_Sub1_935.method254("You last logged in " + s, 256, j, 1, 0xffffff);
            j += 15;
            if(aString746 == null)
                aString746 = method60(anInt687);
            aClass6_Sub1_935.method254("from: " + aString746, 256, j, 1, 0xffffff);
            j += 15;
            j += 15;
        }
        if(anInt875 > 0) {
            int k = 0xffffff;
            aClass6_Sub1_935.method254("Jagex staff will NEVER email you. We use the", 256, j, 1, k);
            j += 15;
            aClass6_Sub1_935.method254("message-centre on this website instead.", 256, j, 1, k);
            j += 15;
            if(anInt875 == 1)
                aClass6_Sub1_935.method254("You have @yel@0@whi@ unread messages in your message-centre", 256, j, 1, 0xffffff);
            else
                aClass6_Sub1_935.method254("You have @gre@" + (anInt875 - 1) + " unread messages @whi@in your message-centre", 256, j, 1, 0xffffff);
            j += 15;
            j += 15;
        }
        if(anInt791 != 201) {
            if(anInt791 == 200) {
                aClass6_Sub1_935.method254("You have not yet set any password recovery questions.", 256, j, 1, 0xff8000);
                j += 15;
                aClass6_Sub1_935.method254("We strongly recommend you do so now to secure your account.", 256, j, 1, 0xff8000);
                j += 15;
                aClass6_Sub1_935.method254("Do this from the 'account management' area on our front webpage", 256, j, 1, 0xff8000);
                j += 15;
            } else {
                String s1;
                if(anInt791 == 0)
                    s1 = "Earlier today";
                else
                if(anInt791 == 1)
                    s1 = "Yesterday";
                else
                    s1 = anInt791 + " days ago";
                aClass6_Sub1_935.method254(s1 + " you changed your recovery questions", 256, j, 1, 0xff8000);
                j += 15;
                aClass6_Sub1_935.method254("If you do not remember making this change then cancel it immediately", 256, j, 1, 0xff8000);
                j += 15;
                aClass6_Sub1_935.method254("Do this from the 'account management' area on our front webpage", 256, j, 1, 0xff8000);
                j += 15;
            }
            j += 15;
        }
        int l = 0xffffff;
        if(super.anInt34 > j - 12 && super.anInt34 <= j && super.anInt33 > 106 && super.anInt33 < 406)
            l = 0xff0000;
        aClass6_Sub1_935.method254("Click here to close window", 256, j, 1, l);
        if(anInt912 == 1) {
            if(l == 0xff0000)
                aBoolean817 = false;
            if((super.anInt33 < 86 || super.anInt33 > 426) && (super.anInt34 < 167 - i / 2 || super.anInt34 > 167 + i / 2))
                aBoolean817 = false;
        }
        anInt912 = 0;
    }

    public void method65() {
        if(anInt730 == 0)
            return;
        if(anInt675 > 450) {
            method97("@cya@You can't logout during combat!", 3);
            return;
        }
        if(anInt675 > 0) {
            method97("@cya@You can't logout for 10 seconds after combat", 3);
            return;
        } else {
            super.aClass14_Sub1_620.method348(129);
            super.aClass14_Sub1_620.method330();
            anInt810 = 1000;
            return;
        }
    }

    public void method66(boolean flag) {
        int i = ((Class6) (aClass6_Sub1_935)).anInt311 - 199;
        int j = 36;
        aClass6_Sub1_935.method230(i - 49, 3, anInt778 + 3);
        char c = '\304';
        char c1 = '\u0113';
        int l;
        int k = l = Class6.method222(160, 160, 160);
        if(anInt836 == 0)
            k = Class6.method222(220, 220, 220);
        else
            l = Class6.method222(220, 220, 220);
        aClass6_Sub1_935.method213(i, j, c / 2, 24, k, 128);
        aClass6_Sub1_935.method213(i + c / 2, j, c / 2, 24, l, 128);
        aClass6_Sub1_935.method213(i, j + 24, c, c1 - 24, Class6.method222(220, 220, 220), 128);
        aClass6_Sub1_935.method217(i, j + 24, c, 0);
        aClass6_Sub1_935.method218(i + c / 2, j, 24, 0);
        aClass6_Sub1_935.method254("Stats", i + c / 4, j + 16, 4, 0);
        aClass6_Sub1_935.method254("Quests", i + c / 4 + c / 2, j + 16, 4, 0);
        if(anInt836 == 0) {
            int i1 = 72;
            int k1 = -1;
            aClass6_Sub1_935.method256("Skills", i + 5, i1, 3, 0xffff00);
            i1 += 13;
            for(int l1 = 0; l1 < 9; l1++) {
                int i2 = 0xffffff;
                if(super.anInt33 > i + 3 && super.anInt34 >= i1 - 11 && super.anInt34 < i1 + 2 && super.anInt33 < i + 90) {
                    i2 = 0xff0000;
                    k1 = l1;
                }
                aClass6_Sub1_935.method256(aStringArray931[l1] + ":@yel@" + anIntArray748[l1] + "/" + anIntArray838[l1], i + 5, i1, 1, i2);
                i2 = 0xffffff;
                if(super.anInt33 >= i + 90 && super.anInt34 >= i1 - 13 - 11 && super.anInt34 < (i1 - 13) + 2 && super.anInt33 < i + 196) {
                    i2 = 0xff0000;
                    k1 = l1 + 9;
                }
                aClass6_Sub1_935.method256(aStringArray931[l1 + 9] + ":@yel@" + anIntArray748[l1 + 9] + "/" + anIntArray838[l1 + 9], (i + c / 2) - 5, i1 - 13, 1, i2);
                i1 += 13;
            }

            aClass6_Sub1_935.method256("Quest Points:@yel@" + anInt934, (i + c / 2) - 5, i1 - 13, 1, 0xffffff);
            i1 += 12;
            aClass6_Sub1_935.method256("Fatigue: @yel@" + (anInt978 * 100) / 750 + "%", i + 5, i1 - 13, 1, 0xffffff);
            i1 += 8;
            aClass6_Sub1_935.method256("Equipment Status", i + 5, i1, 3, 0xffff00);
            i1 += 12;
            for(int j2 = 0; j2 < 3; j2++) {
                aClass6_Sub1_935.method256(aStringArray908[j2] + ":@yel@" + anIntArray706[j2], i + 5, i1, 1, 0xffffff);
                if(j2 < 2)
                    aClass6_Sub1_935.method256(aStringArray908[j2 + 3] + ":@yel@" + anIntArray706[j2 + 3], i + c / 2 + 25, i1, 1, 0xffffff);
                i1 += 13;
            }

            i1 += 6;
            aClass6_Sub1_935.method217(i, i1 - 15, c, 0);
            if(k1 != -1) {
                aClass6_Sub1_935.method256(aStringArray936[k1] + " skill", i + 5, i1, 1, 0xffff00);
                i1 += 12;
                int k2 = anIntArray938[0];
                for(int i3 = 0; i3 < 98; i3++)
                    if(anIntArray928[k1] >= anIntArray938[i3])
                        k2 = anIntArray938[i3 + 1];

                aClass6_Sub1_935.method256("Total xp: " + anIntArray928[k1] / 4, i + 5, i1, 1, 0xffffff);
                i1 += 12;
                aClass6_Sub1_935.method256("Next level at: " + k2 / 4, i + 5, i1, 1, 0xffffff);
            } else {
                aClass6_Sub1_935.method256("Overall levels", i + 5, i1, 1, 0xffff00);
                i1 += 12;
                int l2 = 0;
                for(int j3 = 0; j3 < 18; j3++)
                    l2 += anIntArray838[j3];

                aClass6_Sub1_935.method256("Skill total: " + l2, i + 5, i1, 1, 0xffffff);
                i1 += 12;
                aClass6_Sub1_935.method256("Combat level: " + aClass2_888.anInt168, i + 5, i1, 1, 0xffffff);
                i1 += 12;
            }
        }
        if(anInt836 == 1) {
            aClass4_834.method164(anInt835);
            aClass4_834.method166(anInt835, 0, "@whi@Quest-list (green=completed)");
            for(int j1 = 0; j1 < 50; j1++)
                aClass4_834.method166(anInt835, j1 + 1, (aBooleanArray808[j1] ? "@gre@" : "@red@") + aStringArray918[j1]);

            aClass4_834.method141();
        }
        if(!flag)
            return;
        i = super.anInt33 - (((Class6) (aClass6_Sub1_935)).anInt311 - 199);
        j = super.anInt34 - 36;
        if(i >= 0 && j >= 0 && i < c && j < c1) {
            if(anInt836 == 1)
                aClass4_834.method138(i + (((Class6) (aClass6_Sub1_935)).anInt311 - 199), j + 36, super.anInt36, super.anInt35);
            if(j <= 24 && anInt912 == 1) {
                if(i < 98) {
                    anInt836 = 0;
                    return;
                }
                if(i > 98)
                    anInt836 = 1;
            }
        }
    }

    public void method67() {
        int i = 97;
        aClass6_Sub1_935.method215(86, 77, 340, 180, 0);
        aClass6_Sub1_935.method216(86, 77, 340, 180, 0xffffff);
        aClass6_Sub1_935.method254("Warning! Proceed with caution", 256, i, 4, 0xff0000);
        i += 26;
        aClass6_Sub1_935.method254("If you go much further north you will enter the", 256, i, 1, 0xffffff);
        i += 13;
        aClass6_Sub1_935.method254("wilderness. This a very dangerous area where", 256, i, 1, 0xffffff);
        i += 13;
        aClass6_Sub1_935.method254("other players can attack you!", 256, i, 1, 0xffffff);
        i += 22;
        aClass6_Sub1_935.method254("The further north you go the more dangerous it", 256, i, 1, 0xffffff);
        i += 13;
        aClass6_Sub1_935.method254("becomes, but the more treasure you will find.", 256, i, 1, 0xffffff);
        i += 22;
        aClass6_Sub1_935.method254("In the wilderness an indicator at the bottom-right", 256, i, 1, 0xffffff);
        i += 13;
        aClass6_Sub1_935.method254("of the screen will show the current level of danger", 256, i, 1, 0xffffff);
        i += 22;
        int j = 0xffffff;
        if(super.anInt34 > i - 12 && super.anInt34 <= i && super.anInt33 > 181 && super.anInt33 < 331)
            j = 0xff0000;
        aClass6_Sub1_935.method254("Click here to close window", 256, i, 1, j);
        if(anInt912 != 0) {
            if(super.anInt34 > i - 12 && super.anInt34 <= i && super.anInt33 > 181 && super.anInt33 < 331)
                anInt949 = 2;
            if(super.anInt33 < 86 || super.anInt33 > 426 || super.anInt34 < 77 || super.anInt34 > 257)
                anInt949 = 2;
            anInt912 = 0;
        }
    }

    public void method68(int i, int j, int k, int l, int i1, int j1, int k1) {
        int l1 = Class1.anIntArray71[i1] + anInt780;
        int i2 = Class1.anIntArray76[i1];
        aClass6_Sub1_935.method246(i, j, k, l, l1, i2, 0, 0, false);
    }

    public void method42(String s) {
        if(s.startsWith("@bor@")) {
            method97(s, 4);
            return;
        }
        if(s.startsWith("@que@")) {
            method97("@whi@" + s, 5);
            return;
        }
        if(s.startsWith("@pri@")) {
            method97(s, 6);
            return;
        } else {
            method97(s, 3);
            return;
        }
    }

    public void method69() {
        if(anInt725 == 0 && super.anInt33 >= ((Class6) (aClass6_Sub1_935)).anInt311 - 35 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (aClass6_Sub1_935)).anInt311 - 3 && super.anInt34 < 35)
            anInt725 = 1;
        if(anInt725 == 0 && super.anInt33 >= ((Class6) (aClass6_Sub1_935)).anInt311 - 35 - 33 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (aClass6_Sub1_935)).anInt311 - 3 - 33 && super.anInt34 < 35) {
            anInt725 = 2;
            anInt995 = (int)(Math.random() * 13D) - 6;
            anInt996 = (int)(Math.random() * 23D) - 11;
        }
        if(anInt725 == 0 && super.anInt33 >= ((Class6) (aClass6_Sub1_935)).anInt311 - 35 - 66 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (aClass6_Sub1_935)).anInt311 - 3 - 66 && super.anInt34 < 35)
            anInt725 = 3;
        if(anInt725 == 0 && super.anInt33 >= ((Class6) (aClass6_Sub1_935)).anInt311 - 35 - 99 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (aClass6_Sub1_935)).anInt311 - 3 - 99 && super.anInt34 < 35)
            anInt725 = 4;
        if(anInt725 == 0 && super.anInt33 >= ((Class6) (aClass6_Sub1_935)).anInt311 - 35 - 132 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (aClass6_Sub1_935)).anInt311 - 3 - 132 && super.anInt34 < 35)
            anInt725 = 5;
        if(anInt725 == 0 && super.anInt33 >= ((Class6) (aClass6_Sub1_935)).anInt311 - 35 - 165 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (aClass6_Sub1_935)).anInt311 - 3 - 165 && super.anInt34 < 35)
            anInt725 = 6;
        if(anInt725 != 0 && super.anInt33 >= ((Class6) (aClass6_Sub1_935)).anInt311 - 35 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (aClass6_Sub1_935)).anInt311 - 3 && super.anInt34 < 26)
            anInt725 = 1;
        if(anInt725 != 0 && anInt725 != 2 && super.anInt33 >= ((Class6) (aClass6_Sub1_935)).anInt311 - 35 - 33 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (aClass6_Sub1_935)).anInt311 - 3 - 33 && super.anInt34 < 26) {
            anInt725 = 2;
            anInt995 = (int)(Math.random() * 13D) - 6;
            anInt996 = (int)(Math.random() * 23D) - 11;
        }
        if(anInt725 != 0 && super.anInt33 >= ((Class6) (aClass6_Sub1_935)).anInt311 - 35 - 66 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (aClass6_Sub1_935)).anInt311 - 3 - 66 && super.anInt34 < 26)
            anInt725 = 3;
        if(anInt725 != 0 && super.anInt33 >= ((Class6) (aClass6_Sub1_935)).anInt311 - 35 - 99 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (aClass6_Sub1_935)).anInt311 - 3 - 99 && super.anInt34 < 26)
            anInt725 = 4;
        if(anInt725 != 0 && super.anInt33 >= ((Class6) (aClass6_Sub1_935)).anInt311 - 35 - 132 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (aClass6_Sub1_935)).anInt311 - 3 - 132 && super.anInt34 < 26)
            anInt725 = 5;
        if(anInt725 != 0 && super.anInt33 >= ((Class6) (aClass6_Sub1_935)).anInt311 - 35 - 165 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (aClass6_Sub1_935)).anInt311 - 3 - 165 && super.anInt34 < 26)
            anInt725 = 6;
        if(anInt725 == 1 && (super.anInt33 < ((Class6) (aClass6_Sub1_935)).anInt311 - 248 || super.anInt34 > 36 + (anInt892 / 5) * 34))
            anInt725 = 0;
        if(anInt725 == 3 && (super.anInt33 < ((Class6) (aClass6_Sub1_935)).anInt311 - 199 || super.anInt34 > 316))
            anInt725 = 0;
        if((anInt725 == 2 || anInt725 == 4 || anInt725 == 5) && (super.anInt33 < ((Class6) (aClass6_Sub1_935)).anInt311 - 199 || super.anInt34 > 240))
            anInt725 = 0;
        if(anInt725 == 6 && (super.anInt33 < ((Class6) (aClass6_Sub1_935)).anInt311 - 199 || super.anInt34 > 311))
            anInt725 = 0;
    }

    public void method70(int i) {
        int j = anIntArray886[i];
        int k = anIntArray887[i];
        int l = anIntArray844[i];
        int i1 = anIntArray845[i];
        int j1 = anIntArray846[i];
        int k1 = anIntArray768[i];
        if(k1 == 200) {
            method106(anInt889, anInt890, j, k, true);
            super.aClass14_Sub1_620.method348(104);
            super.aClass14_Sub1_620.method336(j + anInt749);
            super.aClass14_Sub1_620.method336(k + anInt750);
            super.aClass14_Sub1_620.method336(l);
            super.aClass14_Sub1_620.method336(i1);
            super.aClass14_Sub1_620.method330();
            anInt919 = -1;
        }
        if(k1 == 210) {
            method106(anInt889, anInt890, j, k, true);
            super.aClass14_Sub1_620.method348(34);
            super.aClass14_Sub1_620.method336(j + anInt749);
            super.aClass14_Sub1_620.method336(k + anInt750);
            super.aClass14_Sub1_620.method336(l);
            super.aClass14_Sub1_620.method336(i1);
            super.aClass14_Sub1_620.method330();
            anInt757 = -1;
        }
        if(k1 == 220) {
            method106(anInt889, anInt890, j, k, true);
            super.aClass14_Sub1_620.method348(245);
            super.aClass14_Sub1_620.method336(j + anInt749);
            super.aClass14_Sub1_620.method336(k + anInt750);
            super.aClass14_Sub1_620.method336(l);
            super.aClass14_Sub1_620.method336(i1);
            super.aClass14_Sub1_620.method330();
        }
        if(k1 == 3200)
            method97(Class1.aStringArray113[l], 3);
        if(k1 == 300) {
            method78(j, k, l);
            super.aClass14_Sub1_620.method348(67);
            super.aClass14_Sub1_620.method336(j + anInt749);
            super.aClass14_Sub1_620.method336(k + anInt750);
            super.aClass14_Sub1_620.method331(l);
            super.aClass14_Sub1_620.method336(i1);
            super.aClass14_Sub1_620.method330();
            anInt919 = -1;
        }
        if(k1 == 310) {
            method78(j, k, l);
            super.aClass14_Sub1_620.method348(36);
            super.aClass14_Sub1_620.method336(j + anInt749);
            super.aClass14_Sub1_620.method336(k + anInt750);
            super.aClass14_Sub1_620.method331(l);
            super.aClass14_Sub1_620.method336(i1);
            super.aClass14_Sub1_620.method330();
            anInt757 = -1;
        }
        if(k1 == 320) {
            method78(j, k, l);
            super.aClass14_Sub1_620.method348(126);
            super.aClass14_Sub1_620.method336(j + anInt749);
            super.aClass14_Sub1_620.method336(k + anInt750);
            super.aClass14_Sub1_620.method331(l);
            super.aClass14_Sub1_620.method330();
        }
        if(k1 == 2300) {
            method78(j, k, l);
            super.aClass14_Sub1_620.method348(235);
            super.aClass14_Sub1_620.method336(j + anInt749);
            super.aClass14_Sub1_620.method336(k + anInt750);
            super.aClass14_Sub1_620.method331(l);
            super.aClass14_Sub1_620.method330();
        }
        if(k1 == 3300)
            method97(Class1.aStringArray100[l], 3);
        if(k1 == 400) {
            method55(j, k, l, i1);
            super.aClass14_Sub1_620.method348(17);
            super.aClass14_Sub1_620.method336(j + anInt749);
            super.aClass14_Sub1_620.method336(k + anInt750);
            super.aClass14_Sub1_620.method336(j1);
            super.aClass14_Sub1_620.method330();
            anInt919 = -1;
        }
        if(k1 == 410) {
            method55(j, k, l, i1);
            super.aClass14_Sub1_620.method348(94);
            super.aClass14_Sub1_620.method336(j + anInt749);
            super.aClass14_Sub1_620.method336(k + anInt750);
            super.aClass14_Sub1_620.method336(j1);
            super.aClass14_Sub1_620.method330();
            anInt757 = -1;
        }
        if(k1 == 420) {
            method55(j, k, l, i1);
            super.aClass14_Sub1_620.method348(51);
            super.aClass14_Sub1_620.method336(j + anInt749);
            super.aClass14_Sub1_620.method336(k + anInt750);
            super.aClass14_Sub1_620.method330();
        }
        if(k1 == 2400) {
            method55(j, k, l, i1);
            super.aClass14_Sub1_620.method348(40);
            super.aClass14_Sub1_620.method336(j + anInt749);
            super.aClass14_Sub1_620.method336(k + anInt750);
            super.aClass14_Sub1_620.method330();
        }
        if(k1 == 3400)
            method97(Class1.aStringArray80[l], 3);
        if(k1 == 600) {
            super.aClass14_Sub1_620.method348(49);
            super.aClass14_Sub1_620.method336(l);
            super.aClass14_Sub1_620.method336(i1);
            super.aClass14_Sub1_620.method330();
            anInt919 = -1;
        }
        if(k1 == 610) {
            super.aClass14_Sub1_620.method348(27);
            super.aClass14_Sub1_620.method336(l);
            super.aClass14_Sub1_620.method336(i1);
            super.aClass14_Sub1_620.method330();
            anInt757 = -1;
        }
        if(k1 == 620) {
            super.aClass14_Sub1_620.method348(92);
            super.aClass14_Sub1_620.method336(l);
            super.aClass14_Sub1_620.method330();
        }
        if(k1 == 630) {
            super.aClass14_Sub1_620.method348(181);
            super.aClass14_Sub1_620.method336(l);
            super.aClass14_Sub1_620.method330();
        }
        if(k1 == 640) {
            super.aClass14_Sub1_620.method348(89);
            super.aClass14_Sub1_620.method336(l);
            super.aClass14_Sub1_620.method330();
        }
        if(k1 == 650) {
            anInt757 = l;
            anInt725 = 0;
            aString758 = Class1.aStringArray112[anIntArray693[anInt757]];
        }
        if(k1 == 660) {
            super.aClass14_Sub1_620.method348(147);
            super.aClass14_Sub1_620.method336(l);
            super.aClass14_Sub1_620.method330();
            anInt757 = -1;
            anInt725 = 0;
            method97("Dropping " + Class1.aStringArray112[anIntArray693[l]], 4);
        }
        if(k1 == 3600)
            method97(Class1.aStringArray113[l], 3);
        if(k1 == 700) {
            int l1 = (j - 64) / anInt729;
            int l3 = (k - 64) / anInt729;
            method112(anInt889, anInt890, l1, l3, true);
            super.aClass14_Sub1_620.method348(71);
            super.aClass14_Sub1_620.method336(l);
            super.aClass14_Sub1_620.method336(i1);
            super.aClass14_Sub1_620.method330();
            anInt919 = -1;
        }
        if(k1 == 710) {
            int i2 = (j - 64) / anInt729;
            int i4 = (k - 64) / anInt729;
            method112(anInt889, anInt890, i2, i4, true);
            super.aClass14_Sub1_620.method348(142);
            super.aClass14_Sub1_620.method336(l);
            super.aClass14_Sub1_620.method336(i1);
            super.aClass14_Sub1_620.method330();
            anInt757 = -1;
        }
        if(k1 == 720) {
            int j2 = (j - 64) / anInt729;
            int j4 = (k - 64) / anInt729;
            method112(anInt889, anInt890, j2, j4, true);
            super.aClass14_Sub1_620.method348(177);
            super.aClass14_Sub1_620.method336(l);
            super.aClass14_Sub1_620.method330();
        }
        if(k1 == 725) {
            int k2 = (j - 64) / anInt729;
            int k4 = (k - 64) / anInt729;
            method112(anInt889, anInt890, k2, k4, true);
            super.aClass14_Sub1_620.method348(74);
            super.aClass14_Sub1_620.method336(l);
            super.aClass14_Sub1_620.method330();
        }
        if(k1 == 715 || k1 == 2715) {
            int l2 = (j - 64) / anInt729;
            int l4 = (k - 64) / anInt729;
            method112(anInt889, anInt890, l2, l4, true);
            super.aClass14_Sub1_620.method348(73);
            super.aClass14_Sub1_620.method336(l);
            super.aClass14_Sub1_620.method330();
        }
        if(k1 == 3700)
            method97(Class1.aStringArray124[l], 3);
        if(k1 == 800) {
            int i3 = (j - 64) / anInt729;
            int i5 = (k - 64) / anInt729;
            method112(anInt889, anInt890, i3, i5, true);
            super.aClass14_Sub1_620.method348(55);
            super.aClass14_Sub1_620.method336(l);
            super.aClass14_Sub1_620.method336(i1);
            super.aClass14_Sub1_620.method330();
            anInt919 = -1;
        }
        if(k1 == 810) {
            int j3 = (j - 64) / anInt729;
            int j5 = (k - 64) / anInt729;
            method112(anInt889, anInt890, j3, j5, true);
            super.aClass14_Sub1_620.method348(16);
            super.aClass14_Sub1_620.method336(l);
            super.aClass14_Sub1_620.method336(i1);
            super.aClass14_Sub1_620.method330();
            anInt757 = -1;
        }
        if(k1 == 805 || k1 == 2805) {
            int k3 = (j - 64) / anInt729;
            int k5 = (k - 64) / anInt729;
            method112(anInt889, anInt890, k3, k5, true);
            super.aClass14_Sub1_620.method348(57);
            super.aClass14_Sub1_620.method336(l);
            super.aClass14_Sub1_620.method330();
        }
        if(k1 == 2806) {
            super.aClass14_Sub1_620.method348(222);
            super.aClass14_Sub1_620.method336(l);
            super.aClass14_Sub1_620.method330();
        }
        if(k1 == 2810) {
            super.aClass14_Sub1_620.method348(166);
            super.aClass14_Sub1_620.method336(l);
            super.aClass14_Sub1_620.method330();
        }
        if(k1 == 2820) {
            super.aClass14_Sub1_620.method348(68);
            super.aClass14_Sub1_620.method336(l);
            super.aClass14_Sub1_620.method330();
        }
        if(k1 == 900) {
            method112(anInt889, anInt890, j, k, true);
            super.aClass14_Sub1_620.method348(232);
            super.aClass14_Sub1_620.method336(j + anInt749);
            super.aClass14_Sub1_620.method336(k + anInt750);
            super.aClass14_Sub1_620.method336(l);
            super.aClass14_Sub1_620.method330();
            anInt919 = -1;
        }
        if(k1 == 920) {
            method112(anInt889, anInt890, j, k, false);
            if(anInt841 == -24)
                anInt841 = 24;
        }
        if(k1 == 1000) {
            super.aClass14_Sub1_620.method348(206);
            super.aClass14_Sub1_620.method336(l);
            super.aClass14_Sub1_620.method330();
            anInt919 = -1;
        }
        if(k1 == 4000) {
            anInt757 = -1;
            anInt919 = -1;
        }
    }

    public void method71(int i, int j, int k, int l, int i1, int j1, int k1) {
        int l1 = anIntArray792[i1];
        int i2 = anIntArray933[i1];
        if(l1 == 0) {
            int j2 = 255 + i2 * 5 * 256;
            aClass6_Sub1_935.method212(i + k / 2, j + l / 2, 20 + i2 * 2, j2, 255 - i2 * 5);
        }
        if(l1 == 1) {
            int k2 = 0xff0000 + i2 * 5 * 256;
            aClass6_Sub1_935.method212(i + k / 2, j + l / 2, 10 + i2, k2, 255 - i2 * 5);
        }
    }

    public void method2() {
        if(aBoolean988)
            return;
        if(aBoolean723)
            return;
        if(aBoolean937)
            return;
        try {
            anInt747++;
            if(anInt730 == 0) {
                super.anInt12 = 0;
                method48();
            }
            if(anInt730 == 1) {
                super.anInt12++;
                method89();
            }
            super.anInt36 = 0;
            super.anInt38 = 0;
            anInt952++;
            if(anInt952 > 500) {
                anInt952 = 0;
                int i = (int)(Math.random() * 4D);
                if((i & 1) == 1)
                    anInt736 += anInt737;
                if((i & 2) == 2)
                    anInt920 += anInt921;
            }
            if(anInt736 < -50)
                anInt737 = 2;
            if(anInt736 > 50)
                anInt737 = -2;
            if(anInt920 < -50)
                anInt921 = 2;
            if(anInt920 > 50)
                anInt921 = -2;
            if(anInt962 > 0)
                anInt962--;
            if(anInt963 > 0)
                anInt963--;
            if(anInt964 > 0)
                anInt964--;
            if(anInt965 > 0) {
                anInt965--;
                return;
            }
        }
        catch(OutOfMemoryError _ex) {
            method79();
            aBoolean723 = true;
        }
    }

    public Class5 method72(int i, int j, int k, int l, int i1) {
        int j1 = i;
        int k1 = j;
        int l1 = i;
        int i2 = j;
        int j2 = Class1.anIntArray119[l];
        int k2 = Class1.anIntArray120[l];
        int l2 = Class1.anIntArray118[l];
        Class5 class5 = new Class5(4, 1);
        if(k == 0)
            l1 = i + 1;
        if(k == 1)
            i2 = j + 1;
        if(k == 2) {
            j1 = i + 1;
            i2 = j + 1;
        }
        if(k == 3) {
            l1 = i + 1;
            i2 = j + 1;
        }
        j1 *= anInt729;
        k1 *= anInt729;
        l1 *= anInt729;
        i2 *= anInt729;
        int i3 = class5.method179(j1, -aClass19_903.method404(j1, k1), k1);
        int j3 = class5.method179(j1, -aClass19_903.method404(j1, k1) - l2, k1);
        int k3 = class5.method179(l1, -aClass19_903.method404(l1, i2) - l2, i2);
        int l3 = class5.method179(l1, -aClass19_903.method404(l1, i2), i2);
        int ai[] = {
            i3, j3, k3, l3
        };
        class5.method181(4, ai, j2, k2);
        class5.method184(false, 60, 24, -50, -10, -50);
        if(i >= 0 && j >= 0 && i < 96 && j < 96)
            aClass10_939.method268(class5);
        class5.anInt257 = i1 + 10000;
        return class5;
    }

    public void method73() {
        anInt730 = 0;
        anInt708 = 0;
        aString673 = "";
        aString674 = "";
        aString906 = "Please enter a username:";
        aString907 = "*" + aString673 + "*";
        anInt689 = 0;
        anInt717 = 0;
    }

    public String getParameter(String s) {
        if(Class8.anApplet370 != null)
            return Class8.anApplet370.getParameter(s);
        else
            return super.getParameter(s);
    }

    public static String method74(int i) {
        String s = String.valueOf(i);
        for(int j = s.length() - 3; j > 0; j -= 3)
            s = s.substring(0, j) + "," + s.substring(j);

        if(s.length() > 8)
            s = "@gre@" + s.substring(0, s.length() - 8) + " million @whi@(" + s + ")";
        else
        if(s.length() > 4)
            s = "@cya@" + s.substring(0, s.length() - 4) + "K @whi@(" + s + ")";
        return s;
    }

    public void method75() {
        if(anInt975 != 0) {
            aClass6_Sub1_935.method220();
            aClass6_Sub1_935.method254("Oh dear! You are dead...", anInt985 / 2, anInt986 / 2, 7, 0xff0000);
            method61();
            aClass6_Sub1_935.method210(aGraphics946, 0, 0);
            return;
        }
        if(aBoolean769) {
            method62();
            return;
        }
        if(aBoolean776) {
            aClass6_Sub1_935.method220();
            if(Math.random() < 0.14999999999999999D)
                aClass6_Sub1_935.method254("ZZZ", (int)(Math.random() * 80D), (int)(Math.random() * 334D), 5, (int)(Math.random() * 16777215D));
            if(Math.random() < 0.14999999999999999D)
                aClass6_Sub1_935.method254("ZZZ", 512 - (int)(Math.random() * 80D), (int)(Math.random() * 334D), 5, (int)(Math.random() * 16777215D));
            aClass6_Sub1_935.method215(anInt985 / 2 - 100, 160, 200, 40, 0);
            aClass6_Sub1_935.method254("You are sleeping", anInt985 / 2, 50, 7, 0xffff00);
            aClass6_Sub1_935.method254("Fatigue: " + (anInt979 * 100) / 750 + "%", anInt985 / 2, 90, 7, 0xffff00);
            aClass6_Sub1_935.method254("When you want to wake up just use your", anInt985 / 2, 140, 5, 0xffffff);
            aClass6_Sub1_935.method254("keyboard to type the word in the box below", anInt985 / 2, 160, 5, 0xffffff);
            aClass6_Sub1_935.method254(super.aString40 + "*", anInt985 / 2, 180, 5, 65535);
            if(aString899 == null)
                aClass6_Sub1_935.method230(anInt985 / 2 - 127, 230, anInt782 + 1);
            else
                aClass6_Sub1_935.method254(aString899, anInt985 / 2, 260, 5, 0xff0000);
            aClass6_Sub1_935.method216(anInt985 / 2 - 128, 229, 257, 42, 0xffffff);
            method61();
            aClass6_Sub1_935.method254("If you can't read the word", anInt985 / 2, 290, 1, 0xffffff);
            aClass6_Sub1_935.method254("@yel@click here@whi@ to get a different one", anInt985 / 2, 305, 1, 0xffffff);
            aClass6_Sub1_935.method210(aGraphics946, 0, 0);
            return;
        }
        if(!aClass19_903.aBoolean613)
            return;
        for(int i = 0; i < 64; i++) {
            aClass10_939.method269(aClass19_903.aClass5ArrayArray608[anInt722][i]);
            if(anInt722 == 0) {
                aClass10_939.method269(aClass19_903.aClass5ArrayArray590[1][i]);
                aClass10_939.method269(aClass19_903.aClass5ArrayArray608[1][i]);
                aClass10_939.method269(aClass19_903.aClass5ArrayArray590[2][i]);
                aClass10_939.method269(aClass19_903.aClass5ArrayArray608[2][i]);
            }
            aBoolean926 = true;
            if(anInt722 == 0 && (aClass19_903.anIntArrayArray611[aClass2_888.anInt149 / 128][aClass2_888.anInt150 / 128] & 0x80) == 0) {
                aClass10_939.method268(aClass19_903.aClass5ArrayArray608[anInt722][i]);
                if(anInt722 == 0) {
                    aClass10_939.method268(aClass19_903.aClass5ArrayArray590[1][i]);
                    aClass10_939.method268(aClass19_903.aClass5ArrayArray608[1][i]);
                    aClass10_939.method268(aClass19_903.aClass5ArrayArray590[2][i]);
                    aClass10_939.method268(aClass19_903.aClass5ArrayArray608[2][i]);
                }
                aBoolean926 = false;
            }
        }

        if(anInt896 != anInt752) {
            anInt752 = anInt896;
            for(int j = 0; j < anInt981; j++) {
                if(anIntArray884[j] == 97)
                    method98(j, "firea" + (anInt896 + 1));
                if(anIntArray884[j] == 274)
                    method98(j, "fireplacea" + (anInt896 + 1));
                if(anIntArray884[j] == 1031)
                    method98(j, "lightning" + (anInt896 + 1));
                if(anIntArray884[j] == 1036)
                    method98(j, "firespell" + (anInt896 + 1));
                if(anIntArray884[j] == 1147)
                    method98(j, "spellcharge" + (anInt896 + 1));
            }

        }
        if(anInt897 != anInt753) {
            anInt753 = anInt897;
            for(int k = 0; k < anInt981; k++) {
                if(anIntArray884[k] == 51)
                    method98(k, "torcha" + (anInt897 + 1));
                if(anIntArray884[k] == 143)
                    method98(k, "skulltorcha" + (anInt897 + 1));
            }

        }
        if(anInt898 != anInt754) {
            anInt754 = anInt898;
            for(int l = 0; l < anInt981; l++)
                if(anIntArray884[l] == 1142)
                    method98(l, "clawspell" + (anInt898 + 1));

        }
        aClass10_939.method272(anInt691);
        anInt691 = 0;
        for(int i1 = 0; i1 < anInt689; i1++) {
            Class2 class2 = aClass2Array904[i1];
            if(class2.anInt171 != 255) {
                int k1 = class2.anInt149;
                int i2 = class2.anInt150;
                int k2 = -aClass19_903.method404(k1, i2);
                int l3 = aClass10_939.method273(5000 + i1, k1, k2, i2, 145, 220, i1 + 10000);
                anInt691++;
                if(class2 == aClass2_888)
                    aClass10_939.method274(l3);
                if(class2.anInt153 == 8)
                    aClass10_939.method275(l3, -30);
                if(class2.anInt153 == 9)
                    aClass10_939.method275(l3, 30);
            }
        }

        for(int j1 = 0; j1 < anInt689; j1++) {
            Class2 class2_1 = aClass2Array904[j1];
            if(class2_1.anInt176 > 0) {
                Class2 class2_2 = null;
                if(class2_1.anInt175 != -1)
                    class2_2 = aClass2Array930[class2_1.anInt175];
                else
                if(class2_1.anInt174 != -1)
                    class2_2 = aClass2Array713[class2_1.anInt174];
                if(class2_2 != null) {
                    int l2 = class2_1.anInt149;
                    int i4 = class2_1.anInt150;
                    int l6 = -aClass19_903.method404(l2, i4) - 110;
                    int l8 = class2_2.anInt149;
                    int k9 = class2_2.anInt150;
                    int l9 = -aClass19_903.method404(l8, k9) - Class1.anIntArray60[class2_2.anInt151] / 2;
                    int i10 = (l2 * class2_1.anInt176 + l8 * (anInt953 - class2_1.anInt176)) / anInt953;
                    int j10 = (l6 * class2_1.anInt176 + l9 * (anInt953 - class2_1.anInt176)) / anInt953;
                    int k10 = (i4 * class2_1.anInt176 + k9 * (anInt953 - class2_1.anInt176)) / anInt953;
                    aClass10_939.method273(anInt781 + class2_1.anInt173, i10, j10, k10, 32, 32, 0);
                    anInt691++;
                }
            }
        }

        for(int l1 = 0; l1 < anInt717; l1++) {
            Class2 class2_3 = aClass2Array705[l1];
            int i3 = class2_3.anInt149;
            int j4 = class2_3.anInt150;
            int i7 = -aClass19_903.method404(i3, j4);
            int i9 = aClass10_939.method273(20000 + l1, i3, i7, j4, Class1.anIntArray59[class2_3.anInt151], Class1.anIntArray60[class2_3.anInt151], l1 + 30000);
            anInt691++;
            if(class2_3.anInt153 == 8)
                aClass10_939.method275(i9, -30);
            if(class2_3.anInt153 == 9)
                aClass10_939.method275(i9, 30);
        }

        for(int j2 = 0; j2 < anInt895; j2++) {
            int j3 = anIntArray966[j2] * anInt729 + 64;
            int k4 = anIntArray967[j2] * anInt729 + 64;
            aClass10_939.method273(40000 + anIntArray968[j2], j3, -aClass19_903.method404(j3, k4) - anIntArray969[j2], k4, 96, 64, j2 + 20000);
            anInt691++;
        }

        for(int k3 = 0; k3 < anInt902; k3++) {
            int l4 = anIntArray954[k3] * anInt729 + 64;
            int j7 = anIntArray767[k3] * anInt729 + 64;
            int j9 = anIntArray792[k3];
            if(j9 == 0) {
                aClass10_939.method273(50000 + k3, l4, -aClass19_903.method404(l4, j7), j7, 128, 256, k3 + 50000);
                anInt691++;
            }
            if(j9 == 1) {
                aClass10_939.method273(50000 + k3, l4, -aClass19_903.method404(l4, j7), j7, 128, 64, k3 + 50000);
                anInt691++;
            }
        }

        aClass6_Sub1_935.aBoolean335 = false;
        aClass6_Sub1_935.method211();
        aClass6_Sub1_935.aBoolean335 = super.aBoolean39;
        if(anInt722 == 3) {
            int i5 = 40 + (int)(Math.random() * 3D);
            int k7 = 40 + (int)(Math.random() * 7D);
            aClass10_939.method309(i5, k7, -50, -10, -50);
        }
        anInt709 = 0;
        anInt697 = 0;
        anInt728 = 0;
        if(aBoolean929) {
            if(aBoolean666 && !aBoolean926) {
                int j5 = anInt731;
                method51();
                if(anInt731 != j5) {
                    anInt879 = aClass2_888.anInt149;
                    anInt880 = aClass2_888.anInt150;
                }
            }
            aClass10_939.anInt390 = 3000;
            aClass10_939.anInt391 = 3000;
            aClass10_939.anInt392 = 1;
            aClass10_939.anInt393 = 2800;
            anInt809 = anInt731 * 32;
            int k5 = anInt879 + anInt736;
            int l7 = anInt880 + anInt920;
            aClass10_939.method297(k5, -aClass19_903.method404(k5, l7), l7, 912, anInt809 * 4, 0, 2000);
        } else {
            if(aBoolean666 && !aBoolean926)
                method51();
            if(!super.aBoolean39) {
                aClass10_939.anInt390 = 2400;
                aClass10_939.anInt391 = 2400;
                aClass10_939.anInt392 = 1;
                aClass10_939.anInt393 = 2300;
            } else {
                aClass10_939.anInt390 = 2200;
                aClass10_939.anInt391 = 2200;
                aClass10_939.anInt392 = 1;
                aClass10_939.anInt393 = 2100;
            }
            int l5 = anInt879 + anInt736;
            int i8 = anInt880 + anInt920;
            aClass10_939.method297(l5, -aClass19_903.method404(l5, i8), i8, 912, anInt809 * 4, 0, anInt913 * 2);
        }
        aClass10_939.method285();
        method119();
        if(anInt841 > 0)
            aClass6_Sub1_935.method230(anInt842 - 8, anInt843 - 8, anInt778 + 14 + (24 - anInt841) / 6);
        if(anInt841 < 0)
            aClass6_Sub1_935.method230(anInt842 - 8, anInt843 - 8, anInt778 + 18 + (24 + anInt841) / 6);
        if(anInt807 != 0) {
            int i6 = anInt807 / 50;
            int j8 = i6 / 60;
            i6 %= 60;
            if(i6 < 10)
                aClass6_Sub1_935.method254("System update in: " + j8 + ":0" + i6, 256, anInt986 - 7, 1, 0xffff00);
            else
                aClass6_Sub1_935.method254("System update in: " + j8 + ":" + i6, 256, anInt986 - 7, 1, 0xffff00);
        }
        if(!aBoolean917) {
            int j6 = 2203 - (anInt890 + anInt720 + anInt750);
            if(anInt889 + anInt719 + anInt749 >= 2640)
                j6 = -50;
            if(j6 > 0) {
                int k8 = 1 + j6 / 6;
                aClass6_Sub1_935.method230(453, anInt986 - 56, anInt778 + 13);
                aClass6_Sub1_935.method254("Wilderness", 465, anInt986 - 20, 1, 0xffff00);
                aClass6_Sub1_935.method254("Level: " + k8, 465, anInt986 - 7, 1, 0xffff00);
                if(anInt949 == 0)
                    anInt949 = 2;
            }
            if(anInt949 == 0 && j6 > -10 && j6 <= 0)
                anInt949 = 1;
        }
        if(anInt816 == 0) {
            for(int k6 = 0; k6 < 5; k6++)
                if(anIntArray878[k6] > 0) {
                    String s = aStringArray972[k6];
                    aClass6_Sub1_935.method256(s, 7, anInt986 - 18 - k6 * 12, 1, 0xffff00);
                }

        }
        aClass4_811.method171(anInt812);
        aClass4_811.method171(anInt814);
        aClass4_811.method171(anInt815);
        if(anInt816 == 1)
            aClass4_811.method170(anInt812);
        else
        if(anInt816 == 2)
            aClass4_811.method170(anInt814);
        else
        if(anInt816 == 3)
            aClass4_811.method170(anInt815);
        Class4.anInt225 = 2;
        aClass4_811.method141();
        Class4.anInt225 = 0;
        aClass6_Sub1_935.method232(((Class6) (aClass6_Sub1_935)).anInt311 - 3 - 197, 3, anInt778, 128);
        method111();
        aClass6_Sub1_935.aBoolean338 = false;
        method61();
        aClass6_Sub1_935.method210(aGraphics946, 0, 0);
    }

    public void method76() {
        if(anInt912 != 0) {
            for(int i = 0; i < anInt763; i++) {
                int k = anInt759 + 2;
                int i1 = anInt760 + 27 + i * 15;
                if(super.anInt33 <= k - 2 || super.anInt34 <= i1 - 12 || super.anInt34 >= i1 + 4 || super.anInt33 >= (k - 3) + anInt761)
                    continue;
                method70(anIntArray925[i]);
                break;
            }

            anInt912 = 0;
            aBoolean951 = false;
            return;
        }
        if(super.anInt33 < anInt759 - 10 || super.anInt34 < anInt760 - 10 || super.anInt33 > anInt759 + anInt761 + 10 || super.anInt34 > anInt760 + anInt762 + 10) {
            aBoolean951 = false;
            return;
        }
        aClass6_Sub1_935.method213(anInt759, anInt760, anInt761, anInt762, 0xd0d0d0, 160);
        aClass6_Sub1_935.method256("Choose option", anInt759 + 2, anInt760 + 12, 1, 65535);
        for(int j = 0; j < anInt763; j++) {
            int l = anInt759 + 2;
            int j1 = anInt760 + 27 + j * 15;
            int k1 = 0xffffff;
            if(super.anInt33 > l - 2 && super.anInt34 > j1 - 12 && super.anInt34 < j1 + 4 && super.anInt33 < (l - 3) + anInt761)
                k1 = 0xffff00;
            aClass6_Sub1_935.method256(aStringArray676[anIntArray925[j]] + " " + aStringArray833[anIntArray925[j]], l, j1, 1, k1);
        }

    }

    public void method39() {
        anInt807 = 0;
        anInt708 = 0;
        anInt730 = 0;
        anInt810 = 0;
    }

    public void method77() {
        if(anInt912 != 0) {
            for(int i = 0; i < anInt881; i++) {
                if(super.anInt33 >= aClass6_Sub1_935.method262(aStringArray667[i], 1) || super.anInt34 <= i * 12 || super.anInt34 >= 12 + i * 12)
                    continue;
                super.aClass14_Sub1_620.method348(154);
                super.aClass14_Sub1_620.method331(i);
                super.aClass14_Sub1_620.method330();
                break;
            }

            anInt912 = 0;
            aBoolean727 = false;
            return;
        }
        for(int j = 0; j < anInt881; j++) {
            int k = 65535;
            if(super.anInt33 < aClass6_Sub1_935.method262(aStringArray667[j], 1) && super.anInt34 > j * 12 && super.anInt34 < 12 + j * 12)
                k = 0xff0000;
            aClass6_Sub1_935.method256(aStringArray667[j], 6, 12 + j * 12, 1, k);
        }

    }

    public void method78(int i, int j, int k) {
        if(k == 0) {
            method103(anInt889, anInt890, i, j - 1, i, j, false, true);
            return;
        }
        if(k == 1) {
            method103(anInt889, anInt890, i - 1, j, i, j, false, true);
            return;
        } else {
            method103(anInt889, anInt890, i, j, i, j, true, true);
            return;
        }
    }

    public void method79() {
        try {
            if(aClass6_Sub1_935 != null) {
                aClass6_Sub1_935.method223();
                aClass6_Sub1_935.anIntArray317 = null;
                aClass6_Sub1_935 = null;
            }
            if(aClass10_939 != null) {
                aClass10_939.method270();
                aClass10_939 = null;
            }
            aClass5Array777 = null;
            aClass5Array805 = null;
            aClass5Array700 = null;
            aClass2Array713 = null;
            aClass2Array904 = null;
            aClass2Array930 = null;
            aClass2Array705 = null;
            aClass2_888 = null;
            if(aClass19_903 != null) {
                aClass19_903.aClass5Array606 = null;
                aClass19_903.aClass5ArrayArray590 = null;
                aClass19_903.aClass5ArrayArray608 = null;
                aClass19_903.aClass5_597 = null;
                aClass19_903 = null;
            }
            System.gc();
            return;
        }
        catch(Exception _ex) {
            return;
        }
    }

    public void method80() {
        byte abyte0[] = method18("media" + Class18.anInt576 + ".jag", "2d graphics", 20);
        if(abyte0 == null) {
            aBoolean937 = true;
            return;
        }
        byte abyte1[] = Class15.method365("index.dat", 0, abyte0);
        aClass6_Sub1_935.method224(anInt778, Class15.method365("inv1.dat", 0, abyte0), abyte1, 1);
        aClass6_Sub1_935.method224(anInt778 + 1, Class15.method365("inv2.dat", 0, abyte0), abyte1, 6);
        aClass6_Sub1_935.method224(anInt778 + 9, Class15.method365("bubble.dat", 0, abyte0), abyte1, 1);
        aClass6_Sub1_935.method224(anInt778 + 10, Class15.method365("runescape.dat", 0, abyte0), abyte1, 1);
        aClass6_Sub1_935.method224(anInt778 + 11, Class15.method365("splat.dat", 0, abyte0), abyte1, 3);
        aClass6_Sub1_935.method224(anInt778 + 14, Class15.method365("icon.dat", 0, abyte0), abyte1, 8);
        aClass6_Sub1_935.method224(anInt778 + 22, Class15.method365("hbar.dat", 0, abyte0), abyte1, 1);
        aClass6_Sub1_935.method224(anInt778 + 23, Class15.method365("hbar2.dat", 0, abyte0), abyte1, 1);
        aClass6_Sub1_935.method224(anInt778 + 24, Class15.method365("compass.dat", 0, abyte0), abyte1, 1);
        aClass6_Sub1_935.method224(anInt778 + 25, Class15.method365("buttons.dat", 0, abyte0), abyte1, 2);
        aClass6_Sub1_935.method224(anInt779, Class15.method365("scrollbar.dat", 0, abyte0), abyte1, 2);
        aClass6_Sub1_935.method224(anInt779 + 2, Class15.method365("corners.dat", 0, abyte0), abyte1, 4);
        aClass6_Sub1_935.method224(anInt779 + 6, Class15.method365("arrows.dat", 0, abyte0), abyte1, 2);
        aClass6_Sub1_935.method224(anInt781, Class15.method365("projectile.dat", 0, abyte0), abyte1, Class1.anInt84);
        int i = Class1.anInt105;
        for(int j = 1; i > 0; j++) {
            int k = i;
            i -= 30;
            if(k > 30)
                k = 30;
            aClass6_Sub1_935.method224(anInt780 + (j - 1) * 30, Class15.method365("objects" + j + ".dat", 0, abyte0), abyte1, k);
        }

        aClass6_Sub1_935.method227(anInt778);
        aClass6_Sub1_935.method227(anInt778 + 9);
        for(int l = 11; l <= 26; l++)
            aClass6_Sub1_935.method227(anInt778 + l);

        for(int i1 = 0; i1 < Class1.anInt84; i1++)
            aClass6_Sub1_935.method227(anInt781 + i1);

        for(int j1 = 0; j1 < Class1.anInt105; j1++)
            aClass6_Sub1_935.method227(anInt780 + j1);

    }

    public void method36(String s, String s1) {
        if(anInt708 == 1)
            aClass4_877.method168(anInt910, s + " " + s1);
        if(anInt708 == 2)
            aClass4_803.method168(anInt826, s + " " + s1);
        aString907 = s1;
        method49();
        method9();
    }

    public void method81() {
        int i = 2203 - (anInt890 + anInt720 + anInt750);
        if(anInt889 + anInt719 + anInt749 >= 2640)
            i = -50;
        int j = -1;
        for(int k = 0; k < anInt981; k++)
            aBooleanArray837[k] = false;

        for(int l = 0; l < anInt959; l++)
            aBooleanArray980[l] = false;

        int i1 = aClass10_939.method277();
        Class5 aclass5[] = aClass10_939.method279();
        int ai[] = aClass10_939.method278();
        for(int j1 = 0; j1 < i1; j1++) {
            if(anInt763 > 200)
                break;
            int k1 = ai[j1];
            Class5 class5 = aclass5[j1];
            if(class5.anIntArray258[k1] <= 65535 || class5.anIntArray258[k1] >= 0x30d40 && class5.anIntArray258[k1] <= 0x493e0)
                if(class5 == aClass10_939.aClass5_433) {
                    int i2 = class5.anIntArray258[k1] % 10000;
                    int l2 = class5.anIntArray258[k1] / 10000;
                    if(l2 == 1) {
                        String s = "";
                        int k3 = 0;
                        if(aClass2_888.anInt168 > 0 && aClass2Array904[i2].anInt168 > 0)
                            k3 = aClass2_888.anInt168 - aClass2Array904[i2].anInt168;
                        if(k3 < 0)
                            s = "@or1@";
                        if(k3 < -3)
                            s = "@or2@";
                        if(k3 < -6)
                            s = "@or3@";
                        if(k3 < -9)
                            s = "@red@";
                        if(k3 > 0)
                            s = "@gr1@";
                        if(k3 > 3)
                            s = "@gr2@";
                        if(k3 > 6)
                            s = "@gr3@";
                        if(k3 > 9)
                            s = "@gre@";
                        s = " " + s + "(level-" + aClass2Array904[i2].anInt168 + ")";
                        if(anInt919 >= 0) {
                            if(Class1.anIntArray63[anInt919] == 1 || Class1.anIntArray63[anInt919] == 2) {
                                aStringArray676[anInt763] = "Cast " + Class1.aStringArray110[anInt919] + " on";
                                aStringArray833[anInt763] = "@whi@" + aClass2Array904[i2].aString146 + s;
                                anIntArray768[anInt763] = 800;
                                anIntArray886[anInt763] = aClass2Array904[i2].anInt149;
                                anIntArray887[anInt763] = aClass2Array904[i2].anInt150;
                                anIntArray844[anInt763] = aClass2Array904[i2].anInt147;
                                anIntArray845[anInt763] = anInt919;
                                anInt763++;
                            }
                        } else
                        if(anInt757 >= 0) {
                            aStringArray676[anInt763] = "Use " + aString758 + " with";
                            aStringArray833[anInt763] = "@whi@" + aClass2Array904[i2].aString146 + s;
                            anIntArray768[anInt763] = 810;
                            anIntArray886[anInt763] = aClass2Array904[i2].anInt149;
                            anIntArray887[anInt763] = aClass2Array904[i2].anInt150;
                            anIntArray844[anInt763] = aClass2Array904[i2].anInt147;
                            anIntArray845[anInt763] = anInt757;
                            anInt763++;
                        } else {
                            if(i > 0 && (aClass2Array904[i2].anInt150 - 64) / anInt729 + anInt720 + anInt750 < 2203) {
                                aStringArray676[anInt763] = "Attack";
                                aStringArray833[anInt763] = "@whi@" + aClass2Array904[i2].aString146 + s;
                                if(k3 >= 0 && k3 < 5)
                                    anIntArray768[anInt763] = 805;
                                else
                                    anIntArray768[anInt763] = 2805;
                                anIntArray886[anInt763] = aClass2Array904[i2].anInt149;
                                anIntArray887[anInt763] = aClass2Array904[i2].anInt150;
                                anIntArray844[anInt763] = aClass2Array904[i2].anInt147;
                                anInt763++;
                            } else
                            if(aBoolean867) {
                                aStringArray676[anInt763] = "Duel with";
                                aStringArray833[anInt763] = "@whi@" + aClass2Array904[i2].aString146 + s;
                                anIntArray886[anInt763] = aClass2Array904[i2].anInt149;
                                anIntArray887[anInt763] = aClass2Array904[i2].anInt150;
                                anIntArray768[anInt763] = 2806;
                                anIntArray844[anInt763] = aClass2Array904[i2].anInt147;
                                anInt763++;
                            }
                            aStringArray676[anInt763] = "Trade with";
                            aStringArray833[anInt763] = "@whi@" + aClass2Array904[i2].aString146 + s;
                            anIntArray768[anInt763] = 2810;
                            anIntArray844[anInt763] = aClass2Array904[i2].anInt147;
                            anInt763++;
                            aStringArray676[anInt763] = "Follow";
                            aStringArray833[anInt763] = "@whi@" + aClass2Array904[i2].aString146 + s;
                            anIntArray768[anInt763] = 2820;
                            anIntArray844[anInt763] = aClass2Array904[i2].anInt147;
                            anInt763++;
                        }
                    } else
                    if(l2 == 2) {
                        if(anInt919 >= 0) {
                            if(Class1.anIntArray63[anInt919] == 3) {
                                aStringArray676[anInt763] = "Cast " + Class1.aStringArray110[anInt919] + " on";
                                aStringArray833[anInt763] = "@lre@" + Class1.aStringArray112[anIntArray968[i2]];
                                anIntArray768[anInt763] = 200;
                                anIntArray886[anInt763] = anIntArray966[i2];
                                anIntArray887[anInt763] = anIntArray967[i2];
                                anIntArray844[anInt763] = anIntArray968[i2];
                                anIntArray845[anInt763] = anInt919;
                                anInt763++;
                            }
                        } else
                        if(anInt757 >= 0) {
                            aStringArray676[anInt763] = "Use " + aString758 + " with";
                            aStringArray833[anInt763] = "@lre@" + Class1.aStringArray112[anIntArray968[i2]];
                            anIntArray768[anInt763] = 210;
                            anIntArray886[anInt763] = anIntArray966[i2];
                            anIntArray887[anInt763] = anIntArray967[i2];
                            anIntArray844[anInt763] = anIntArray968[i2];
                            anIntArray845[anInt763] = anInt757;
                            anInt763++;
                        } else {
                            aStringArray676[anInt763] = "Take";
                            aStringArray833[anInt763] = "@lre@" + Class1.aStringArray112[anIntArray968[i2]];
                            anIntArray768[anInt763] = 220;
                            anIntArray886[anInt763] = anIntArray966[i2];
                            anIntArray887[anInt763] = anIntArray967[i2];
                            anIntArray844[anInt763] = anIntArray968[i2];
                            anInt763++;
                            aStringArray676[anInt763] = "Examine";
                            aStringArray833[anInt763] = "@lre@" + Class1.aStringArray112[anIntArray968[i2]];
                            anIntArray768[anInt763] = 3200;
                            anIntArray844[anInt763] = anIntArray968[i2];
                            anInt763++;
                        }
                    } else
                    if(l2 == 3) {
                        String s1 = "";
                        int l3 = -1;
                        int i4 = aClass2Array705[i2].anInt151;
                        if(Class1.anIntArray130[i4] > 0) {
                            int j4 = (Class1.anIntArray126[i4] + Class1.anIntArray129[i4] + Class1.anIntArray127[i4] + Class1.anIntArray128[i4]) / 4;
                            int k4 = (anIntArray838[0] + anIntArray838[1] + anIntArray838[2] + anIntArray838[3] + 27) / 4;
                            l3 = k4 - j4;
                            s1 = "@yel@";
                            if(l3 < 0)
                                s1 = "@or1@";
                            if(l3 < -3)
                                s1 = "@or2@";
                            if(l3 < -6)
                                s1 = "@or3@";
                            if(l3 < -9)
                                s1 = "@red@";
                            if(l3 > 0)
                                s1 = "@gr1@";
                            if(l3 > 3)
                                s1 = "@gr2@";
                            if(l3 > 6)
                                s1 = "@gr3@";
                            if(l3 > 9)
                                s1 = "@gre@";
                            s1 = " " + s1 + "(level-" + j4 + ")";
                        }
                        if(anInt919 >= 0) {
                            if(Class1.anIntArray63[anInt919] == 2) {
                                aStringArray676[anInt763] = "Cast " + Class1.aStringArray110[anInt919] + " on";
                                aStringArray833[anInt763] = "@yel@" + Class1.aStringArray123[aClass2Array705[i2].anInt151];
                                anIntArray768[anInt763] = 700;
                                anIntArray886[anInt763] = aClass2Array705[i2].anInt149;
                                anIntArray887[anInt763] = aClass2Array705[i2].anInt150;
                                anIntArray844[anInt763] = aClass2Array705[i2].anInt147;
                                anIntArray845[anInt763] = anInt919;
                                anInt763++;
                            }
                        } else
                        if(anInt757 >= 0) {
                            aStringArray676[anInt763] = "Use " + aString758 + " with";
                            aStringArray833[anInt763] = "@yel@" + Class1.aStringArray123[aClass2Array705[i2].anInt151];
                            anIntArray768[anInt763] = 710;
                            anIntArray886[anInt763] = aClass2Array705[i2].anInt149;
                            anIntArray887[anInt763] = aClass2Array705[i2].anInt150;
                            anIntArray844[anInt763] = aClass2Array705[i2].anInt147;
                            anIntArray845[anInt763] = anInt757;
                            anInt763++;
                        } else {
                            if(Class1.anIntArray130[i4] > 0) {
                                aStringArray676[anInt763] = "Attack";
                                aStringArray833[anInt763] = "@yel@" + Class1.aStringArray123[aClass2Array705[i2].anInt151] + s1;
                                if(l3 >= 0)
                                    anIntArray768[anInt763] = 715;
                                else
                                    anIntArray768[anInt763] = 2715;
                                anIntArray886[anInt763] = aClass2Array705[i2].anInt149;
                                anIntArray887[anInt763] = aClass2Array705[i2].anInt150;
                                anIntArray844[anInt763] = aClass2Array705[i2].anInt147;
                                anInt763++;
                            }
                            aStringArray676[anInt763] = "Talk-to";
                            aStringArray833[anInt763] = "@yel@" + Class1.aStringArray123[aClass2Array705[i2].anInt151];
                            anIntArray768[anInt763] = 720;
                            anIntArray886[anInt763] = aClass2Array705[i2].anInt149;
                            anIntArray887[anInt763] = aClass2Array705[i2].anInt150;
                            anIntArray844[anInt763] = aClass2Array705[i2].anInt147;
                            anInt763++;
                            if(!Class1.aStringArray125[i4].equals("")) {
                                aStringArray676[anInt763] = Class1.aStringArray125[i4];
                                aStringArray833[anInt763] = "@yel@" + Class1.aStringArray123[aClass2Array705[i2].anInt151];
                                anIntArray768[anInt763] = 725;
                                anIntArray886[anInt763] = aClass2Array705[i2].anInt149;
                                anIntArray887[anInt763] = aClass2Array705[i2].anInt150;
                                anIntArray844[anInt763] = aClass2Array705[i2].anInt147;
                                anInt763++;
                            }
                            aStringArray676[anInt763] = "Examine";
                            aStringArray833[anInt763] = "@yel@" + Class1.aStringArray123[aClass2Array705[i2].anInt151];
                            anIntArray768[anInt763] = 3700;
                            anIntArray844[anInt763] = aClass2Array705[i2].anInt151;
                            anInt763++;
                        }
                    }
                } else
                if(class5 != null && class5.anInt257 >= 10000) {
                    int j2 = class5.anInt257 - 10000;
                    int i3 = anIntArray961[j2];
                    if(!aBooleanArray980[j2]) {
                        if(anInt919 >= 0) {
                            if(Class1.anIntArray63[anInt919] == 4) {
                                aStringArray676[anInt763] = "Cast " + Class1.aStringArray110[anInt919] + " on";
                                aStringArray833[anInt763] = "@cya@" + Class1.aStringArray99[i3];
                                anIntArray768[anInt763] = 300;
                                anIntArray886[anInt763] = anIntArray947[j2];
                                anIntArray887[anInt763] = anIntArray948[j2];
                                anIntArray844[anInt763] = anIntArray960[j2];
                                anIntArray845[anInt763] = anInt919;
                                anInt763++;
                            }
                        } else
                        if(anInt757 >= 0) {
                            aStringArray676[anInt763] = "Use " + aString758 + " with";
                            aStringArray833[anInt763] = "@cya@" + Class1.aStringArray99[i3];
                            anIntArray768[anInt763] = 310;
                            anIntArray886[anInt763] = anIntArray947[j2];
                            anIntArray887[anInt763] = anIntArray948[j2];
                            anIntArray844[anInt763] = anIntArray960[j2];
                            anIntArray845[anInt763] = anInt757;
                            anInt763++;
                        } else {
                            if(!Class1.aStringArray101[i3].equalsIgnoreCase("WalkTo")) {
                                aStringArray676[anInt763] = Class1.aStringArray101[i3];
                                aStringArray833[anInt763] = "@cya@" + Class1.aStringArray99[i3];
                                anIntArray768[anInt763] = 320;
                                anIntArray886[anInt763] = anIntArray947[j2];
                                anIntArray887[anInt763] = anIntArray948[j2];
                                anIntArray844[anInt763] = anIntArray960[j2];
                                anInt763++;
                            }
                            if(!Class1.aStringArray102[i3].equalsIgnoreCase("Examine")) {
                                aStringArray676[anInt763] = Class1.aStringArray102[i3];
                                aStringArray833[anInt763] = "@cya@" + Class1.aStringArray99[i3];
                                anIntArray768[anInt763] = 2300;
                                anIntArray886[anInt763] = anIntArray947[j2];
                                anIntArray887[anInt763] = anIntArray948[j2];
                                anIntArray844[anInt763] = anIntArray960[j2];
                                anInt763++;
                            }
                            aStringArray676[anInt763] = "Examine";
                            aStringArray833[anInt763] = "@cya@" + Class1.aStringArray99[i3];
                            anIntArray768[anInt763] = 3300;
                            anIntArray844[anInt763] = i3;
                            anInt763++;
                        }
                        aBooleanArray980[j2] = true;
                    }
                } else
                if(class5 != null && class5.anInt257 >= 0) {
                    int k2 = class5.anInt257;
                    int j3 = anIntArray884[k2];
                    if(!aBooleanArray837[k2]) {
                        if(anInt919 >= 0) {
                            if(Class1.anIntArray63[anInt919] == 5) {
                                aStringArray676[anInt763] = "Cast " + Class1.aStringArray110[anInt919] + " on";
                                aStringArray833[anInt763] = "@cya@" + Class1.aStringArray79[j3];
                                anIntArray768[anInt763] = 400;
                                anIntArray886[anInt763] = anIntArray882[k2];
                                anIntArray887[anInt763] = anIntArray883[k2];
                                anIntArray844[anInt763] = anIntArray885[k2];
                                anIntArray845[anInt763] = anIntArray884[k2];
                                anIntArray846[anInt763] = anInt919;
                                anInt763++;
                            }
                        } else
                        if(anInt757 >= 0) {
                            aStringArray676[anInt763] = "Use " + aString758 + " with";
                            aStringArray833[anInt763] = "@cya@" + Class1.aStringArray79[j3];
                            anIntArray768[anInt763] = 410;
                            anIntArray886[anInt763] = anIntArray882[k2];
                            anIntArray887[anInt763] = anIntArray883[k2];
                            anIntArray844[anInt763] = anIntArray885[k2];
                            anIntArray845[anInt763] = anIntArray884[k2];
                            anIntArray846[anInt763] = anInt757;
                            anInt763++;
                        } else {
                            if(!Class1.aStringArray81[j3].equalsIgnoreCase("WalkTo")) {
                                aStringArray676[anInt763] = Class1.aStringArray81[j3];
                                aStringArray833[anInt763] = "@cya@" + Class1.aStringArray79[j3];
                                anIntArray768[anInt763] = 420;
                                anIntArray886[anInt763] = anIntArray882[k2];
                                anIntArray887[anInt763] = anIntArray883[k2];
                                anIntArray844[anInt763] = anIntArray885[k2];
                                anIntArray845[anInt763] = anIntArray884[k2];
                                anInt763++;
                            }
                            if(!Class1.aStringArray82[j3].equalsIgnoreCase("Examine")) {
                                aStringArray676[anInt763] = Class1.aStringArray82[j3];
                                aStringArray833[anInt763] = "@cya@" + Class1.aStringArray79[j3];
                                anIntArray768[anInt763] = 2400;
                                anIntArray886[anInt763] = anIntArray882[k2];
                                anIntArray887[anInt763] = anIntArray883[k2];
                                anIntArray844[anInt763] = anIntArray885[k2];
                                anIntArray845[anInt763] = anIntArray884[k2];
                                anInt763++;
                            }
                            aStringArray676[anInt763] = "Examine";
                            aStringArray833[anInt763] = "@cya@" + Class1.aStringArray79[j3];
                            anIntArray768[anInt763] = 3400;
                            anIntArray844[anInt763] = j3;
                            anInt763++;
                        }
                        aBooleanArray837[k2] = true;
                    }
                } else {
                    if(k1 >= 0)
                        k1 = class5.anIntArray258[k1] - 0x30d40;
                    if(k1 >= 0)
                        j = k1;
                }
        }

        if(anInt919 >= 0 && Class1.anIntArray63[anInt919] <= 1) {
            aStringArray676[anInt763] = "Cast " + Class1.aStringArray110[anInt919] + " on self";
            aStringArray833[anInt763] = "";
            anIntArray768[anInt763] = 1000;
            anIntArray844[anInt763] = anInt919;
            anInt763++;
        }
        if(j != -1) {
            int l1 = j;
            if(anInt919 >= 0) {
                if(Class1.anIntArray63[anInt919] == 6) {
                    aStringArray676[anInt763] = "Cast " + Class1.aStringArray110[anInt919] + " on ground";
                    aStringArray833[anInt763] = "";
                    anIntArray768[anInt763] = 900;
                    anIntArray886[anInt763] = aClass19_903.anIntArray586[l1];
                    anIntArray887[anInt763] = aClass19_903.anIntArray605[l1];
                    anIntArray844[anInt763] = anInt919;
                    anInt763++;
                    return;
                }
            } else
            if(anInt757 < 0) {
                aStringArray676[anInt763] = "Walk here ("+ (aClass19_903.anIntArray586[l1] + anInt749) +", "+ (aClass19_903.anIntArray605[l1] + anInt750) +")";
                aStringArray833[anInt763] = "";
                anIntArray768[anInt763] = 920;
                anIntArray886[anInt763] = aClass19_903.anIntArray586[l1];
                anIntArray887[anInt763] = aClass19_903.anIntArray605[l1];
                anInt763++;
            }
        }
    }

    public void method1() {
        if(aBoolean774) {
            String s = getDocumentBase().getHost().toLowerCase();
            if(!s.endsWith("jagex.com") && !s.endsWith("jagex.co.uk") && !s.endsWith("runescape.com") && !s.endsWith("runescape.co.uk") && !s.endsWith("runescape.net") && !s.endsWith("runescape.org") && !s.endsWith("penguin") && !s.endsWith("puffin")) {
                aBoolean988 = true;
                return;
            }
        }
        int i = 0;
        for(int j = 0; j < 99; j++) {
            int k = j + 1;
            int i1 = (int)((double)k + 300D * Math.pow(2D, (double)k / 7D));
            i += i1;
            anIntArray938[j] = i & 0xffffffc;
        }

        try {
            String s1 = getParameter("referid");
            anInt909 = Integer.parseInt(s1);
        }
        catch(Exception _ex) { }
        try {
            String s2 = getParameter("member");
            int j1 = Integer.parseInt(s2);
            if(j1 == 1)
                aBoolean867 = true;
        }
        catch(Exception _ex) { }
        if(aBoolean774)
            super.anInt617 = 43594;
        super.anInt11 = 0;
        Applet_Sub1_Sub1.anInt615 = 1000;
        Applet_Sub1_Sub1.anInt614 = Class18.anInt573;
        try {
            String s3 = getParameter("poff");
            int k1 = Integer.parseInt(s3);
            super.anInt617 += k1;
            System.out.println("Offset: " + k1);
        }
        catch(Exception _ex) { }
        method53();
        if(aBoolean937)
            return;
        anInt778 = 2000;
        anInt779 = anInt778 + 100;
        anInt780 = anInt779 + 50;
        anInt784 = anInt780 + 1000;
        anInt781 = anInt784 + 10;
        anInt782 = anInt781 + 50;
        anInt783 = anInt782 + 10;
        aGraphics946 = getGraphics();
        method8(50);
        aClass6_Sub1_935 = new Class6_Sub1(anInt985, anInt986 + 12, 4000, this);
        aClass6_Sub1_935.aMudclient641 = this;
        aClass6_Sub1_935.method208(0, 0, anInt985, anInt986 + 12);
        Class4.aBoolean220 = false;
        Class4.anInt221 = anInt779;
        aClass4_733 = new Class4(aClass6_Sub1_935, 5);
        int l = ((Class6) (aClass6_Sub1_935)).anInt311 - 199;
        byte byte0 = 36;
        anInt734 = aClass4_733.method162(l, byte0 + 24, 196, 90, 1, 500, true);
        aClass4_989 = new Class4(aClass6_Sub1_935, 5);
        anInt990 = aClass4_989.method162(l, byte0 + 40, 196, 126, 1, 500, true);
        aClass4_834 = new Class4(aClass6_Sub1_935, 5);
        anInt835 = aClass4_834.method162(l, byte0 + 24, 196, 251, 1, 500, true);
        method80();
        if(aBoolean937)
            return;
        method101();
        if(aBoolean937)
            return;
        aClass10_939 = new Class10(aClass6_Sub1_935, 15000, 15000, 1000);
        aClass10_939.method280(anInt985 / 2, anInt986 / 2, anInt985 / 2, anInt986 / 2, anInt985, anInt987);
        aClass10_939.anInt390 = 2400;
        aClass10_939.anInt391 = 2400;
        aClass10_939.anInt392 = 1;
        aClass10_939.anInt393 = 2300;
        aClass10_939.method308(-50, -10, -50);
        aClass19_903 = new Class19(aClass10_939, aClass6_Sub1_935);
        aClass19_903.anInt598 = anInt778;
        method59();
        if(aBoolean937)
            return;
        method54();
        if(aBoolean937)
            return;
        method92();
        if(aBoolean937)
            return;
        if(aBoolean867)
            method90();
        if(aBoolean937) {
            return;
        } else {
            method15(100, "Starting game...");
            method87();
            method110();
            method95();
            method73();
            method5();
            method115();
            return;
        }
    }

    public void method82() {
        if(anInt919 >= 0 || anInt757 >= 0) {
            aStringArray676[anInt763] = "Cancel";
            aStringArray833[anInt763] = "";
            anIntArray768[anInt763] = 4000;
            anInt763++;
        }
        for(int i = 0; i < anInt763; i++)
            anIntArray925[i] = i;

        for(boolean flag = false; !flag;) {
            flag = true;
            for(int j = 0; j < anInt763 - 1; j++) {
                int l = anIntArray925[j];
                int j1 = anIntArray925[j + 1];
                if(anIntArray768[l] > anIntArray768[j1]) {
                    anIntArray925[j] = j1;
                    anIntArray925[j + 1] = l;
                    flag = false;
                }
            }

        }

        if(anInt763 > 20)
            anInt763 = 20;
        if(anInt763 > 0) {
            int k = -1;
            for(int i1 = 0; i1 < anInt763; i1++) {
                if(aStringArray833[anIntArray925[i1]] == null || aStringArray833[anIntArray925[i1]].length() <= 0)
                    continue;
                k = i1;
                break;
            }

            String s = null;
            if((anInt757 >= 0 || anInt919 >= 0) && anInt763 == 1)
                s = "Choose a target";
            else
            if((anInt757 >= 0 || anInt919 >= 0) && anInt763 > 1)
                s = "@whi@" + aStringArray676[anIntArray925[0]] + " " + aStringArray833[anIntArray925[0]];
            else
            if(k != -1)
                s = aStringArray833[anIntArray925[k]] + ": @whi@" + aStringArray676[anIntArray925[0]];
            if(anInt763 == 2 && s != null)
                s = s + "@whi@ / 1 more option";
            if(anInt763 > 2 && s != null)
                s = s + "@whi@ / " + (anInt763 - 1) + " more options";
            if(s != null)
                aClass6_Sub1_935.method256(s, 6, 14, 1, 0xffff00);
            if(!aBoolean785 && anInt912 == 1 || aBoolean785 && anInt912 == 1 && anInt763 == 1) {
                method70(anIntArray925[0]);
                anInt912 = 0;
                return;
            }
            if(!aBoolean785 && anInt912 == 2 || aBoolean785 && anInt912 == 1) {
                anInt762 = (anInt763 + 1) * 15;
                anInt761 = aClass6_Sub1_935.method262("Choose option", 1) + 5;
                for(int k1 = 0; k1 < anInt763; k1++) {
                    int l1 = aClass6_Sub1_935.method262(aStringArray676[k1] + " " + aStringArray833[k1], 1) + 5;
                    if(l1 > anInt761)
                        anInt761 = l1;
                }

                anInt759 = super.anInt33 - anInt761 / 2;
                anInt760 = super.anInt34 - 7;
                aBoolean951 = true;
                if(anInt759 < 0)
                    anInt759 = 0;
                if(anInt760 < 0)
                    anInt760 = 0;
                if(anInt759 + anInt761 > 510)
                    anInt759 = 510 - anInt761;
                if(anInt760 + anInt762 > 315)
                    anInt760 = 315 - anInt762;
                anInt912 = 0;
            }
        }
    }

    public void method40() {
        anInt810 = 0;
        method97("@cya@Sorry, you can't logout at the moment", 3);
    }

    public void method83(boolean flag) {
        int i = ((Class6) (aClass6_Sub1_935)).anInt311 - 199;
        int j = 36;
        aClass6_Sub1_935.method230(i - 49, 3, anInt778 + 5);
        char c = '\304';
        char c1 = '\266';
        int l;
        int k = l = Class6.method222(160, 160, 160);
        if(anInt991 == 0)
            k = Class6.method222(220, 220, 220);
        else
            l = Class6.method222(220, 220, 220);
        aClass6_Sub1_935.method213(i, j, c / 2, 24, k, 128);
        aClass6_Sub1_935.method213(i + c / 2, j, c / 2, 24, l, 128);
        aClass6_Sub1_935.method213(i, j + 24, c, c1 - 24, Class6.method222(220, 220, 220), 128);
        aClass6_Sub1_935.method217(i, j + 24, c, 0);
        aClass6_Sub1_935.method218(i + c / 2, j, 24, 0);
        aClass6_Sub1_935.method217(i, (j + c1) - 16, c, 0);
        aClass6_Sub1_935.method254("Friends", i + c / 4, j + 16, 4, 0);
        aClass6_Sub1_935.method254("Ignore", i + c / 4 + c / 2, j + 16, 4, 0);
        aClass4_989.method164(anInt990);
        if(anInt991 == 0) {
            for(int i1 = 0; i1 < super.anInt624; i1++) {
                String s;
                if(super.anIntArray626[i1] == 99)
                    s = "@gre@";
                else
                if(super.anIntArray626[i1] > 0)
                    s = "@yel@";
                else
                    s = "@red@";
                aClass4_989.method166(anInt990, i1, s + Class15.method362(super.aLongArray625[i1]) + "~439~@whi@Remove         WWWWWWWWWW");
            }

        }
        if(anInt991 == 1) {
            for(int j1 = 0; j1 < super.anInt627; j1++)
                aClass4_989.method166(anInt990, j1, "@yel@" + Class15.method362(super.aLongArray628[j1]) + "~439~@whi@Remove         WWWWWWWWWW");

        }
        aClass4_989.method141();
        if(anInt991 == 0) {
            int k1 = aClass4_989.method173(anInt990);
            if(k1 >= 0 && super.anInt33 < 489) {
                if(super.anInt33 > 429)
                    aClass6_Sub1_935.method254("Click to remove " + Class15.method362(super.aLongArray625[k1]), i + c / 2, j + 35, 1, 0xffffff);
                else
                if(super.anIntArray626[k1] == 99)
                    aClass6_Sub1_935.method254("Click to message " + Class15.method362(super.aLongArray625[k1]), i + c / 2, j + 35, 1, 0xffffff);
                else
                if(super.anIntArray626[k1] > 0)
                    aClass6_Sub1_935.method254(Class15.method362(super.aLongArray625[k1]) + " is on world " + super.anIntArray626[k1], i + c / 2, j + 35, 1, 0xffffff);
                else
                    aClass6_Sub1_935.method254(Class15.method362(super.aLongArray625[k1]) + " is offline", i + c / 2, j + 35, 1, 0xffffff);
            } else {
                aClass6_Sub1_935.method254("Click a name to send a message", i + c / 2, j + 35, 1, 0xffffff);
            }
            int k2;
            if(super.anInt33 > i && super.anInt33 < i + c && super.anInt34 > (j + c1) - 16 && super.anInt34 < j + c1)
                k2 = 0xffff00;
            else
                k2 = 0xffffff;
            aClass6_Sub1_935.method254("Click here to add a friend", i + c / 2, (j + c1) - 3, 1, k2);
        }
        if(anInt991 == 1) {
            int l1 = aClass4_989.method173(anInt990);
            if(l1 >= 0 && super.anInt33 < 489 && super.anInt33 > 429) {
                if(super.anInt33 > 429)
                    aClass6_Sub1_935.method254("Click to remove " + Class15.method362(super.aLongArray628[l1]), i + c / 2, j + 35, 1, 0xffffff);
            } else {
                aClass6_Sub1_935.method254("Blocking messages from:", i + c / 2, j + 35, 1, 0xffffff);
            }
            int l2;
            if(super.anInt33 > i && super.anInt33 < i + c && super.anInt34 > (j + c1) - 16 && super.anInt34 < j + c1)
                l2 = 0xffff00;
            else
                l2 = 0xffffff;
            aClass6_Sub1_935.method254("Click here to add a name", i + c / 2, (j + c1) - 3, 1, l2);
        }
        if(!flag)
            return;
        i = super.anInt33 - (((Class6) (aClass6_Sub1_935)).anInt311 - 199);
        j = super.anInt34 - 36;
        if(i >= 0 && j >= 0 && i < 196 && j < 182) {
            aClass4_989.method138(i + (((Class6) (aClass6_Sub1_935)).anInt311 - 199), j + 36, super.anInt36, super.anInt35);
            if(j <= 24 && anInt912 == 1)
                if(i < 98 && anInt991 == 1) {
                    anInt991 = 0;
                    aClass4_989.method165(anInt990);
                } else
                if(i > 98 && anInt991 == 0) {
                    anInt991 = 1;
                    aClass4_989.method165(anInt990);
                }
            if(anInt912 == 1 && anInt991 == 0) {
                int i2 = aClass4_989.method173(anInt990);
                if(i2 >= 0 && super.anInt33 < 489)
                    if(super.anInt33 > 429)
                        method32(super.aLongArray625[i2]);
                    else
                    if(super.anIntArray626[i2] != 0) {
                        anInt773 = 2;
                        aLong992 = super.aLongArray625[i2];
                        super.aString42 = "";
                        super.aString43 = "";
                    }
            }
            if(anInt912 == 1 && anInt991 == 1) {
                int j2 = aClass4_989.method173(anInt990);
                if(j2 >= 0 && super.anInt33 < 489 && super.anInt33 > 429)
                    method30(super.aLongArray628[j2]);
            }
            if(j > 166 && anInt912 == 1 && anInt991 == 0) {
                anInt773 = 1;
                super.aString40 = "";
                super.aString41 = "";
            }
            if(j > 166 && anInt912 == 1 && anInt991 == 1) {
                anInt773 = 3;
                super.aString40 = "";
                super.aString41 = "";
            }
            anInt912 = 0;
        }
    }

    public boolean method84(int i, int j) {
        if(anInt975 != 0) {
            aClass19_903.aBoolean613 = false;
            return false;
        }
        aBoolean917 = false;
        i += anInt719;
        j += anInt720;
        if(anInt722 == anInt751 && i > anInt799 && i < anInt801 && j > anInt800 && j < anInt802) {
            aClass19_903.aBoolean613 = true;
            return false;
        }
        aClass6_Sub1_935.method254("Loading... Please wait", 256, 192, 1, 0xffffff);
        method61();
        aClass6_Sub1_935.method210(aGraphics946, 0, 0);
        int k = anInt749;
        int l = anInt750;
        int i1 = (i + 24) / 48;
        int j1 = (j + 24) / 48;
        anInt722 = anInt751;
        anInt749 = i1 * 48 - 48;
        anInt750 = j1 * 48 - 48;
        anInt799 = i1 * 48 - 32;
        anInt800 = j1 * 48 - 32;
        anInt801 = i1 * 48 + 32;
        anInt802 = j1 * 48 + 32;
        aClass19_903.method406(i, j, anInt722);
        anInt749 -= anInt719;
        anInt750 -= anInt720;
        int k1 = anInt749 - k;
        int l1 = anInt750 - l;
        for(int i2 = 0; i2 < anInt981; i2++) {
            anIntArray882[i2] -= k1;
            anIntArray883[i2] -= l1;
            int j2 = anIntArray882[i2];
            int l2 = anIntArray883[i2];
            int k3 = anIntArray884[i2];
            Class5 class5 = aClass5Array805[i2];
            try {
                int l4 = anIntArray885[i2];
                int k5;
                int i6;
                if(l4 == 0 || l4 == 4) {
                    k5 = Class1.anIntArray67[k3];
                    i6 = Class1.anIntArray68[k3];
                } else {
                    i6 = Class1.anIntArray67[k3];
                    k5 = Class1.anIntArray68[k3];
                }
                int j6 = ((j2 + j2 + k5) * anInt729) / 2;
                int k6 = ((l2 + l2 + i6) * anInt729) / 2;
                if(j2 >= 0 && l2 >= 0 && j2 < 96 && l2 < 96) {
                    aClass10_939.method268(class5);
                    class5.method191(j6, -aClass19_903.method404(j6, k6), k6);
                    aClass19_903.method417(j2, l2, k3);
                    if(k3 == 74)
                        class5.method190(0, -480, 0);
                }
            }
            catch(RuntimeException runtimeexception) {
                System.out.println("Loc Error: " + runtimeexception.getMessage());
                System.out.println("i:" + i2 + " obj:" + class5);
                runtimeexception.printStackTrace();
            }
        }

        for(int k2 = 0; k2 < anInt959; k2++) {
            anIntArray947[k2] -= k1;
            anIntArray948[k2] -= l1;
            int i3 = anIntArray947[k2];
            int l3 = anIntArray948[k2];
            int j4 = anIntArray961[k2];
            int i5 = anIntArray960[k2];
            try {
                aClass19_903.method413(i3, l3, i5, j4);
                Class5 class5_1 = method72(i3, l3, i5, j4, k2);
                aClass5Array700[k2] = class5_1;
            }
            catch(RuntimeException runtimeexception1) {
                System.out.println("Bound Error: " + runtimeexception1.getMessage());
                runtimeexception1.printStackTrace();
            }
        }

        for(int j3 = 0; j3 < anInt895; j3++) {
            anIntArray966[j3] -= k1;
            anIntArray967[j3] -= l1;
        }

        for(int i4 = 0; i4 < anInt689; i4++) {
            Class2 class2 = aClass2Array904[i4];
            class2.anInt149 -= k1 * anInt729;
            class2.anInt150 -= l1 * anInt729;
            for(int j5 = 0; j5 <= class2.anInt156; j5++) {
                class2.anIntArray157[j5] -= k1 * anInt729;
                class2.anIntArray158[j5] -= l1 * anInt729;
            }

        }

        for(int k4 = 0; k4 < anInt717; k4++) {
            Class2 class2_1 = aClass2Array705[k4];
            class2_1.anInt149 -= k1 * anInt729;
            class2_1.anInt150 -= l1 * anInt729;
            for(int l5 = 0; l5 <= class2_1.anInt156; l5++) {
                class2_1.anIntArray157[l5] -= k1 * anInt729;
                class2_1.anIntArray158[l5] -= l1 * anInt729;
            }

        }

        aClass19_903.aBoolean613 = true;
        return true;
    }

    public void method85(boolean flag) {
        int i = ((Class6) (aClass6_Sub1_935)).anInt311 - 199;
        int j = 36;
        aClass6_Sub1_935.method230(i - 49, 3, anInt778 + 4);
        char c = '\304';
        char c1 = '\266';
        int l;
        int k = l = Class6.method222(160, 160, 160);
        if(anInt735 == 0)
            k = Class6.method222(220, 220, 220);
        else
            l = Class6.method222(220, 220, 220);
        aClass6_Sub1_935.method213(i, j, c / 2, 24, k, 128);
        aClass6_Sub1_935.method213(i + c / 2, j, c / 2, 24, l, 128);
        aClass6_Sub1_935.method213(i, j + 24, c, 90, Class6.method222(220, 220, 220), 128);
        aClass6_Sub1_935.method213(i, j + 24 + 90, c, c1 - 90 - 24, Class6.method222(160, 160, 160), 128);
        aClass6_Sub1_935.method217(i, j + 24, c, 0);
        aClass6_Sub1_935.method218(i + c / 2, j, 24, 0);
        aClass6_Sub1_935.method217(i, j + 113, c, 0);
        aClass6_Sub1_935.method254("Magic", i + c / 4, j + 16, 4, 0);
        aClass6_Sub1_935.method254("Prayers", i + c / 4 + c / 2, j + 16, 4, 0);
        if(anInt735 == 0) {
            aClass4_733.method164(anInt734);
            int i1 = 0;
            for(int i2 = 0; i2 < Class1.anInt85; i2++) {
                String s = "@yel@";
                for(int l3 = 0; l3 < Class1.anIntArray62[i2]; l3++) {
                    int k4 = Class1.anIntArrayArray64[i2][l3];
                    if(method114(k4, Class1.anIntArrayArray65[i2][l3]))
                        continue;
                    s = "@whi@";
                    break;
                }

                int l4 = anIntArray748[6];
                if(Class1.anIntArray61[i2] > l4)
                    s = "@bla@";
                aClass4_733.method166(anInt734, i1++, s + "Level " + Class1.anIntArray61[i2] + ": " + Class1.aStringArray110[i2]);
            }

            aClass4_733.method141();
            int i3 = aClass4_733.method173(anInt734);
            if(i3 != -1) {
                aClass6_Sub1_935.method256("Level " + Class1.anIntArray61[i3] + ": " + Class1.aStringArray110[i3], i + 2, j + 124, 1, 0xffff00);
                aClass6_Sub1_935.method256(Class1.aStringArray111[i3], i + 2, j + 136, 0, 0xffffff);
                for(int i4 = 0; i4 < Class1.anIntArray62[i3]; i4++) {
                    int i5 = Class1.anIntArrayArray64[i3][i4];
                    aClass6_Sub1_935.method230(i + 2 + i4 * 44, j + 150, anInt780 + Class1.anIntArray71[i5]);
                    int j5 = method47(i5);
                    int k5 = Class1.anIntArrayArray65[i3][i4];
                    String s2 = "@red@";
                    if(method114(i5, k5))
                        s2 = "@gre@";
                    aClass6_Sub1_935.method256(s2 + j5 + "/" + k5, i + 2 + i4 * 44, j + 150, 1, 0xffffff);
                }

            } else {
                aClass6_Sub1_935.method256("Point at a spell for a description", i + 2, j + 124, 1, 0);
            }
        }
        if(anInt735 == 1) {
            aClass4_733.method164(anInt734);
            int j1 = 0;
            for(int j2 = 0; j2 < Class1.anInt94; j2++) {
                String s1 = "@whi@";
                if(Class1.anIntArray137[j2] > anIntArray838[5])
                    s1 = "@bla@";
                if(aBooleanArray710[j2])
                    s1 = "@gre@";
                aClass4_733.method166(anInt734, j1++, s1 + "Level " + Class1.anIntArray137[j2] + ": " + Class1.aStringArray96[j2]);
            }

            aClass4_733.method141();
            int j3 = aClass4_733.method173(anInt734);
            if(j3 != -1) {
                aClass6_Sub1_935.method254("Level " + Class1.anIntArray137[j3] + ": " + Class1.aStringArray96[j3], i + c / 2, j + 130, 1, 0xffff00);
                aClass6_Sub1_935.method254(Class1.aStringArray97[j3], i + c / 2, j + 145, 0, 0xffffff);
                aClass6_Sub1_935.method254("Drain rate: " + Class1.anIntArray138[j3], i + c / 2, j + 160, 1, 0);
            } else {
                aClass6_Sub1_935.method256("Point at a prayer for a description", i + 2, j + 124, 1, 0);
            }
        }
        if(!flag)
            return;
        i = super.anInt33 - (((Class6) (aClass6_Sub1_935)).anInt311 - 199);
        j = super.anInt34 - 36;
        if(i >= 0 && j >= 0 && i < 196 && j < 182) {
            aClass4_733.method138(i + (((Class6) (aClass6_Sub1_935)).anInt311 - 199), j + 36, super.anInt36, super.anInt35);
            if(j <= 24 && anInt912 == 1)
                if(i < 98 && anInt735 == 1) {
                    anInt735 = 0;
                    aClass4_733.method165(anInt734);
                } else
                if(i > 98 && anInt735 == 0) {
                    anInt735 = 1;
                    aClass4_733.method165(anInt734);
                }
            if(anInt912 == 1 && anInt735 == 0) {
                int k1 = aClass4_733.method173(anInt734);
                if(k1 != -1) {
                    int k2 = anIntArray748[6];
                    if(Class1.anIntArray61[k1] > k2) {
                        method97("Your magic ability is not high enough for this spell", 3);
                    } else {
                        int k3;
                        for(k3 = 0; k3 < Class1.anIntArray62[k1]; k3++) {
                            int j4 = Class1.anIntArrayArray64[k1][k3];
                            if(method114(j4, Class1.anIntArrayArray65[k1][k3]))
                                continue;
                            method97("You don't have all the reagents you need for this spell", 3);
                            k3 = -1;
                            break;
                        }

                        if(k3 == Class1.anIntArray62[k1]) {
                            anInt919 = k1;
                            anInt757 = -1;
                        }
                    }
                }
            }
            if(anInt912 == 1 && anInt735 == 1) {
                int l1 = aClass4_733.method173(anInt734);
                if(l1 != -1) {
                    int l2 = anIntArray838[5];
                    if(Class1.anIntArray137[l1] > l2)
                        method97("Your prayer ability is not high enough for this prayer", 3);
                    else
                    if(anIntArray748[5] == 0)
                        method97("You have run out of prayer points. Return to a church to recharge", 3);
                    else
                    if(aBooleanArray710[l1]) {
                        super.aClass14_Sub1_620.method348(248);
                        super.aClass14_Sub1_620.method331(l1);
                        super.aClass14_Sub1_620.method330();
                        aBooleanArray710[l1] = false;
                        method102("prayeroff");
                    } else {
                        super.aClass14_Sub1_620.method348(56);
                        super.aClass14_Sub1_620.method331(l1);
                        super.aClass14_Sub1_620.method330();
                        aBooleanArray710[l1] = true;
                        method102("prayeron");
                    }
                }
            }
            anInt912 = 0;
        }
    }

    public void method10(int i) {
        if(anInt730 == 0) {
            if(anInt708 == 0)
                aClass4_806.method140(i);
            if(anInt708 == 1)
                aClass4_877.method140(i);
            if(anInt708 == 2)
                aClass4_803.method140(i);
        }
        if(anInt730 == 1) {
            if(aBoolean769) {
                aClass4_955.method140(i);
                return;
            }
            if(anInt773 == 0 && anInt738 == 0 && !aBoolean776)
                aClass4_811.method140(i);
        }
    }

    public void method86() {
        if(anInt912 != 0) {
            anInt912 = 0;
            int i = super.anInt33 - 52;
            int j = super.anInt34 - 44;
            if(i >= 0 && j >= 12 && i < 408 && j < 246) {
                int k = 0;
                for(int i1 = 0; i1 < 5; i1++) {
                    for(int i2 = 0; i2 < 8; i2++) {
                        int l2 = 7 + i2 * 49;
                        int l3 = 28 + i1 * 34;
                        if(i > l2 && i < l2 + 49 && j > l3 && j < l3 + 34 && anIntArray849[k] != -1) {
                            anInt970 = k;
                            anInt971 = anIntArray849[k];
                        }
                        k++;
                    }

                }

                if(anInt970 >= 0) {
                    int j2 = anIntArray849[anInt970];
                    if(j2 != -1) {
                        if(anIntArray850[anInt970] > 0 && i > 298 && j >= 204 && i < 408 && j <= 215) {
                            int i3 = anInt957 + anIntArray851[anInt970];
                            if(i3 < 10)
                                i3 = 10;
                            int i4 = (i3 * Class1.anIntArray72[j2]) / 100;
                            super.aClass14_Sub1_620.method348(128);
                            super.aClass14_Sub1_620.method336(anIntArray849[anInt970]);
                            super.aClass14_Sub1_620.method334(i4);
                            super.aClass14_Sub1_620.method330();
                        }
                        if(method47(j2) > 0 && i > 2 && j >= 229 && i < 112 && j <= 240) {
                            int j3 = anInt956 + anIntArray851[anInt970];
                            if(j3 < 10)
                                j3 = 10;
                            int j4 = (j3 * Class1.anIntArray72[j2]) / 100;
                            super.aClass14_Sub1_620.method348(255);
                            super.aClass14_Sub1_620.method336(anIntArray849[anInt970]);
                            super.aClass14_Sub1_620.method334(j4);
                            super.aClass14_Sub1_620.method330();
                        }
                    }
                }
            } else {
                super.aClass14_Sub1_620.method348(253);
                super.aClass14_Sub1_620.method330();
                aBoolean940 = false;
                return;
            }
        }
        byte byte0 = 52;
        byte byte1 = 44;
        aClass6_Sub1_935.method215(byte0, byte1, 408, 12, 192);
        int l = 0x989898;
        aClass6_Sub1_935.method213(byte0, byte1 + 12, 408, 17, l, 160);
        aClass6_Sub1_935.method213(byte0, byte1 + 29, 8, 170, l, 160);
        aClass6_Sub1_935.method213(byte0 + 399, byte1 + 29, 9, 170, l, 160);
        aClass6_Sub1_935.method213(byte0, byte1 + 199, 408, 47, l, 160);
        aClass6_Sub1_935.method256("Buying and selling items", byte0 + 1, byte1 + 10, 1, 0xffffff);
        int j1 = 0xffffff;
        if(super.anInt33 > byte0 + 320 && super.anInt34 >= byte1 && super.anInt33 < byte0 + 408 && super.anInt34 < byte1 + 12)
            j1 = 0xff0000;
        aClass6_Sub1_935.method253("Close window", byte0 + 406, byte1 + 10, 1, j1);
        aClass6_Sub1_935.method256("Shops stock in green", byte0 + 2, byte1 + 24, 1, 65280);
        aClass6_Sub1_935.method256("Number you own in blue", byte0 + 135, byte1 + 24, 1, 65535);
        aClass6_Sub1_935.method256("Your money: " + method47(10) + "gp", byte0 + 280, byte1 + 24, 1, 0xffff00);
        int k2 = 0xd0d0d0;
        int k3 = 0;
        for(int k4 = 0; k4 < 5; k4++) {
            for(int l4 = 0; l4 < 8; l4++) {
                int j5 = byte0 + 7 + l4 * 49;
                int i6 = byte1 + 28 + k4 * 34;
                if(anInt970 == k3)
                    aClass6_Sub1_935.method213(j5, i6, 49, 34, 0xff0000, 160);
                else
                    aClass6_Sub1_935.method213(j5, i6, 49, 34, k2, 160);
                aClass6_Sub1_935.method216(j5, i6, 50, 35, 0);
                if(anIntArray849[k3] != -1) {
                    aClass6_Sub1_935.method246(j5, i6, 48, 32, anInt780 + Class1.anIntArray71[anIntArray849[k3]], Class1.anIntArray76[anIntArray849[k3]], 0, 0, false);
                    aClass6_Sub1_935.method256(String.valueOf(anIntArray850[k3]), j5 + 1, i6 + 10, 1, 65280);
                    aClass6_Sub1_935.method253(String.valueOf(method47(anIntArray849[k3])), j5 + 47, i6 + 10, 1, 65535);
                }
                k3++;
            }

        }

        aClass6_Sub1_935.method217(byte0 + 5, byte1 + 222, 398, 0);
        if(anInt970 == -1) {
            aClass6_Sub1_935.method254("Select an object to buy or sell", byte0 + 204, byte1 + 214, 3, 0xffff00);
            return;
        }
        int i5 = anIntArray849[anInt970];
        if(i5 != -1) {
            if(anIntArray850[anInt970] > 0) {
                int k5 = anInt957 + anIntArray851[anInt970];
                if(k5 < 10)
                    k5 = 10;
                int j6 = (k5 * Class1.anIntArray72[i5]) / 100;
                aClass6_Sub1_935.method256("Buy a new " + Class1.aStringArray112[i5] + " for " + j6 + "gp", byte0 + 2, byte1 + 214, 1, 0xffff00);
                int k1 = 0xffffff;
                if(super.anInt33 > byte0 + 298 && super.anInt34 >= byte1 + 204 && super.anInt33 < byte0 + 408 && super.anInt34 <= byte1 + 215)
                    k1 = 0xff0000;
                aClass6_Sub1_935.method253("Click here to buy", byte0 + 405, byte1 + 214, 3, k1);
            } else {
                aClass6_Sub1_935.method254("This item is not currently available to buy", byte0 + 204, byte1 + 214, 3, 0xffff00);
            }
            if(method47(i5) > 0) {
                int l5 = anInt956 + anIntArray851[anInt970];
                if(l5 < 10)
                    l5 = 10;
                int k6 = (l5 * Class1.anIntArray72[i5]) / 100;
                aClass6_Sub1_935.method253("Sell your " + Class1.aStringArray112[i5] + " for " + k6 + "gp", byte0 + 405, byte1 + 239, 1, 0xffff00);
                int l1 = 0xffffff;
                if(super.anInt33 > byte0 + 2 && super.anInt34 >= byte1 + 229 && super.anInt33 < byte0 + 112 && super.anInt34 <= byte1 + 240)
                    l1 = 0xff0000;
                aClass6_Sub1_935.method256("Click here to sell", byte0 + 2, byte1 + 239, 3, l1);
                return;
            }
            aClass6_Sub1_935.method254("You do not have any of this item to sell", byte0 + 204, byte1 + 239, 3, 0xffff00);
        }
    }

    public URL getCodeBase() {
        if(Class8.anApplet370 != null)
            return Class8.anApplet370.getCodeBase();
        else
            return super.getCodeBase();
    }

    public void method87() {
        aClass4_811 = new Class4(aClass6_Sub1_935, 10);
        anInt812 = aClass4_811.method159(5, 269, 502, 56, 1, 20, true);
        anInt813 = aClass4_811.method160(7, 324, 498, 14, 1, 80, false, true);
        anInt814 = aClass4_811.method159(5, 269, 502, 56, 1, 20, true);
        anInt815 = aClass4_811.method159(5, 269, 502, 56, 1, 20, true);
        aClass4_811.method172(anInt813);
    }

    public byte[] method18(String s, String s1, int i) {
        if(!aBoolean774)
            s = "./Data/" + s;
        byte abyte0[] = Class8.method264(s);
        if(abyte0 != null) {
            int j = ((abyte0[0] & 0xff) << 16) + ((abyte0[1] & 0xff) << 8) + (abyte0[2] & 0xff);
            int k = ((abyte0[3] & 0xff) << 16) + ((abyte0[4] & 0xff) << 8) + (abyte0[5] & 0xff);
            byte abyte1[] = new byte[abyte0.length - 6];
            for(int l = 0; l < abyte0.length - 6; l++)
                abyte1[l] = abyte0[l + 6];

            method15(i, "Unpacking " + s1);
            if(k != j) {
                byte abyte2[] = new byte[j];
                Class3.method129(abyte2, j, abyte1, k, 0);
                return abyte2;
            } else {
                return abyte1;
            }
        } else {
            return super.method18(s, s1, i);
        }
    }

    public void method88(boolean flag) {
        int i = ((Class6) (aClass6_Sub1_935)).anInt311 - 199;
        int j = 36;
        aClass6_Sub1_935.method230(i - 49, 3, anInt778 + 6);
        char c = '\304';
        aClass6_Sub1_935.method213(i, 36, c, 65, Class6.method222(181, 181, 181), 160);
        aClass6_Sub1_935.method213(i, 101, c, 65, Class6.method222(201, 201, 201), 160);
        aClass6_Sub1_935.method213(i, 166, c, 95, Class6.method222(181, 181, 181), 160);
        aClass6_Sub1_935.method213(i, 261, c, 40, Class6.method222(201, 201, 201), 160);
        int k = i + 3;
        int i1 = j + 15;
        aClass6_Sub1_935.method256("Game options - click to toggle", k, i1, 1, 0);
        i1 += 15;
        if(aBoolean666)
            aClass6_Sub1_935.method256("Camera angle mode - @gre@Auto", k, i1, 1, 0xffffff);
        else
            aClass6_Sub1_935.method256("Camera angle mode - @red@Manual", k, i1, 1, 0xffffff);
        i1 += 15;
        if(aBoolean785)
            aClass6_Sub1_935.method256("Mouse buttons - @red@One", k, i1, 1, 0xffffff);
        else
            aClass6_Sub1_935.method256("Mouse buttons - @gre@Two", k, i1, 1, 0xffffff);
        i1 += 15;
        if(aBoolean867)
            if(aBoolean950)
                aClass6_Sub1_935.method256("Sound effects - @red@off", k, i1, 1, 0xffffff);
            else
                aClass6_Sub1_935.method256("Sound effects - @gre@on", k, i1, 1, 0xffffff);
        i1 += 15;
        aClass6_Sub1_935.method256("To change your contact details,", k, i1, 0, 0xffffff);
        i1 += 15;
        aClass6_Sub1_935.method256("password, recovery questions, etc..", k, i1, 0, 0xffffff);
        i1 += 15;
        aClass6_Sub1_935.method256("please select 'account management'", k, i1, 0, 0xffffff);
        i1 += 15;
        if(anInt909 == 0)
            aClass6_Sub1_935.method256("from the runescape.com front page", k, i1, 0, 0xffffff);
        else
        if(anInt909 == 1)
            aClass6_Sub1_935.method256("from the link below the gamewindow", k, i1, 0, 0xffffff);
        else
            aClass6_Sub1_935.method256("from the runescape front webpage", k, i1, 0, 0xffffff);
        i1 += 15;
        i1 += 5;
        aClass6_Sub1_935.method256("Privacy settings. Will be applied to", i + 3, i1, 1, 0);
        i1 += 15;
        aClass6_Sub1_935.method256("all people not on your friends list", i + 3, i1, 1, 0);
        i1 += 15;
        if(super.anInt629 == 0)
            aClass6_Sub1_935.method256("Block chat messages: @red@<off>", i + 3, i1, 1, 0xffffff);
        else
            aClass6_Sub1_935.method256("Block chat messages: @gre@<on>", i + 3, i1, 1, 0xffffff);
        i1 += 15;
        if(super.anInt630 == 0)
            aClass6_Sub1_935.method256("Block private messages: @red@<off>", i + 3, i1, 1, 0xffffff);
        else
            aClass6_Sub1_935.method256("Block private messages: @gre@<on>", i + 3, i1, 1, 0xffffff);
        i1 += 15;
        if(super.anInt631 == 0)
            aClass6_Sub1_935.method256("Block trade requests: @red@<off>", i + 3, i1, 1, 0xffffff);
        else
            aClass6_Sub1_935.method256("Block trade requests: @gre@<on>", i + 3, i1, 1, 0xffffff);
        i1 += 15;
        if(aBoolean867)
            if(super.anInt632 == 0)
                aClass6_Sub1_935.method256("Block duel requests: @red@<off>", i + 3, i1, 1, 0xffffff);
            else
                aClass6_Sub1_935.method256("Block duel requests: @gre@<on>", i + 3, i1, 1, 0xffffff);
        i1 += 15;
        i1 += 5;
        aClass6_Sub1_935.method256("Always logout when you finish", k, i1, 1, 0);
        i1 += 15;
        int k1 = 0xffffff;
        if(super.anInt33 > k && super.anInt33 < k + c && super.anInt34 > i1 - 12 && super.anInt34 < i1 + 4)
            k1 = 0xffff00;
        aClass6_Sub1_935.method256("Click here to logout", i + 3, i1, 1, k1);
        if(!flag)
            return;
        i = super.anInt33 - (((Class6) (aClass6_Sub1_935)).anInt311 - 199);
        j = super.anInt34 - 36;
        if(i >= 0 && j >= 0 && i < 196 && j < 265) {
            int l1 = ((Class6) (aClass6_Sub1_935)).anInt311 - 199;
            byte byte0 = 36;
            char c1 = '\304';
            int l = l1 + 3;
            int j1 = byte0 + 30;
            if(super.anInt33 > l && super.anInt33 < l + c1 && super.anInt34 > j1 - 12 && super.anInt34 < j1 + 4 && anInt912 == 1) {
                aBoolean666 = !aBoolean666;
                super.aClass14_Sub1_620.method348(157);
                super.aClass14_Sub1_620.method331(0);
                super.aClass14_Sub1_620.method331(aBoolean666 ? 1 : 0);
                super.aClass14_Sub1_620.method330();
            }
            j1 += 15;
            if(super.anInt33 > l && super.anInt33 < l + c1 && super.anInt34 > j1 - 12 && super.anInt34 < j1 + 4 && anInt912 == 1) {
                aBoolean785 = !aBoolean785;
                super.aClass14_Sub1_620.method348(157);
                super.aClass14_Sub1_620.method331(2);
                super.aClass14_Sub1_620.method331(aBoolean785 ? 1 : 0);
                super.aClass14_Sub1_620.method330();
            }
            j1 += 15;
            if(aBoolean867 && super.anInt33 > l && super.anInt33 < l + c1 && super.anInt34 > j1 - 12 && super.anInt34 < j1 + 4 && anInt912 == 1) {
                aBoolean950 = !aBoolean950;
                super.aClass14_Sub1_620.method348(157);
                super.aClass14_Sub1_620.method331(3);
                super.aClass14_Sub1_620.method331(aBoolean950 ? 1 : 0);
                super.aClass14_Sub1_620.method330();
            }
            j1 += 15;
            j1 += 15;
            j1 += 15;
            j1 += 15;
            j1 += 15;
            boolean flag1 = false;
            j1 += 35;
            if(super.anInt33 > l && super.anInt33 < l + c1 && super.anInt34 > j1 - 12 && super.anInt34 < j1 + 4 && anInt912 == 1) {
                super.anInt629 = 1 - super.anInt629;
                flag1 = true;
            }
            j1 += 15;
            if(super.anInt33 > l && super.anInt33 < l + c1 && super.anInt34 > j1 - 12 && super.anInt34 < j1 + 4 && anInt912 == 1) {
                super.anInt630 = 1 - super.anInt630;
                flag1 = true;
            }
            j1 += 15;
            if(super.anInt33 > l && super.anInt33 < l + c1 && super.anInt34 > j1 - 12 && super.anInt34 < j1 + 4 && anInt912 == 1) {
                super.anInt631 = 1 - super.anInt631;
                flag1 = true;
            }
            j1 += 15;
            if(aBoolean867 && super.anInt33 > l && super.anInt33 < l + c1 && super.anInt34 > j1 - 12 && super.anInt34 < j1 + 4 && anInt912 == 1) {
                super.anInt632 = 1 - super.anInt632;
                flag1 = true;
            }
            j1 += 15;
            if(flag1)
                method28(super.anInt629, super.anInt630, super.anInt631, super.anInt632);
            j1 += 20;
            if(super.anInt33 > l && super.anInt33 < l + c1 && super.anInt34 > j1 - 12 && super.anInt34 < j1 + 4 && anInt912 == 1)
                method65();
            anInt912 = 0;
        }
    }

    public void method89() {
        if(anInt807 > 1)
            anInt807--;
        method25();
        if(anInt810 > 0)
            anInt810--;
        if(super.anInt12 > 4500 && anInt675 == 0 && anInt810 == 0) {
            super.anInt12 -= 500;
            method65();
            return;
        }
        if(aClass2_888.anInt153 == 8 || aClass2_888.anInt153 == 9)
            anInt675 = 500;
        if(anInt675 > 0)
            anInt675--;
        if(aBoolean769) {
            method46();
            return;
        }
        for(int i = 0; i < anInt689; i++) {
            Class2 class2 = aClass2Array904[i];
            int k = (class2.anInt156 + 1) % 10;
            if(class2.anInt155 != k) {
                int i1 = -1;
                int l2 = class2.anInt155;
                int j4;
                if(l2 < k)
                    j4 = k - l2;
                else
                    j4 = (10 + k) - l2;
                int j5 = 4;
                if(j4 > 2)
                    j5 = (j4 - 1) * 4;
                if(class2.anIntArray157[l2] - class2.anInt149 > anInt729 * 3 || class2.anIntArray158[l2] - class2.anInt150 > anInt729 * 3 || class2.anIntArray157[l2] - class2.anInt149 < -anInt729 * 3 || class2.anIntArray158[l2] - class2.anInt150 < -anInt729 * 3 || j4 > 8) {
                    class2.anInt149 = class2.anIntArray157[l2];
                    class2.anInt150 = class2.anIntArray158[l2];
                } else {
                    if(class2.anInt149 < class2.anIntArray157[l2]) {
                        class2.anInt149 += j5;
                        class2.anInt152++;
                        i1 = 2;
                    } else
                    if(class2.anInt149 > class2.anIntArray157[l2]) {
                        class2.anInt149 -= j5;
                        class2.anInt152++;
                        i1 = 6;
                    }
                    if(class2.anInt149 - class2.anIntArray157[l2] < j5 && class2.anInt149 - class2.anIntArray157[l2] > -j5)
                        class2.anInt149 = class2.anIntArray157[l2];
                    if(class2.anInt150 < class2.anIntArray158[l2]) {
                        class2.anInt150 += j5;
                        class2.anInt152++;
                        if(i1 == -1)
                            i1 = 4;
                        else
                        if(i1 == 2)
                            i1 = 3;
                        else
                            i1 = 5;
                    } else
                    if(class2.anInt150 > class2.anIntArray158[l2]) {
                        class2.anInt150 -= j5;
                        class2.anInt152++;
                        if(i1 == -1)
                            i1 = 0;
                        else
                        if(i1 == 2)
                            i1 = 1;
                        else
                            i1 = 7;
                    }
                    if(class2.anInt150 - class2.anIntArray158[l2] < j5 && class2.anInt150 - class2.anIntArray158[l2] > -j5)
                        class2.anInt150 = class2.anIntArray158[l2];
                }
                if(i1 != -1)
                    class2.anInt153 = i1;
                if(class2.anInt149 == class2.anIntArray157[l2] && class2.anInt150 == class2.anIntArray158[l2])
                    class2.anInt155 = (l2 + 1) % 10;
            } else {
                class2.anInt153 = class2.anInt154;
            }
            if(class2.anInt161 > 0)
                class2.anInt161--;
            if(class2.anInt163 > 0)
                class2.anInt163--;
            if(class2.anInt167 > 0)
                class2.anInt167--;
            if(anInt975 > 0) {
                anInt975--;
                if(anInt975 == 0)
                    method97("You have been granted another life. Be more careful this time!", 3);
                if(anInt975 == 0)
                    method97("You retain your skills. Your objects land where you died", 3);
            }
        }

        for(int j = 0; j < anInt717; j++) {
            Class2 class2_1 = aClass2Array705[j];
            int j1 = (class2_1.anInt156 + 1) % 10;
            if(class2_1.anInt155 != j1) {
                int i3 = -1;
                int k4 = class2_1.anInt155;
                int k5;
                if(k4 < j1)
                    k5 = j1 - k4;
                else
                    k5 = (10 + j1) - k4;
                int l5 = 4;
                if(k5 > 2)
                    l5 = (k5 - 1) * 4;
                if(class2_1.anIntArray157[k4] - class2_1.anInt149 > anInt729 * 3 || class2_1.anIntArray158[k4] - class2_1.anInt150 > anInt729 * 3 || class2_1.anIntArray157[k4] - class2_1.anInt149 < -anInt729 * 3 || class2_1.anIntArray158[k4] - class2_1.anInt150 < -anInt729 * 3 || k5 > 8) {
                    class2_1.anInt149 = class2_1.anIntArray157[k4];
                    class2_1.anInt150 = class2_1.anIntArray158[k4];
                } else {
                    if(class2_1.anInt149 < class2_1.anIntArray157[k4]) {
                        class2_1.anInt149 += l5;
                        class2_1.anInt152++;
                        i3 = 2;
                    } else
                    if(class2_1.anInt149 > class2_1.anIntArray157[k4]) {
                        class2_1.anInt149 -= l5;
                        class2_1.anInt152++;
                        i3 = 6;
                    }
                    if(class2_1.anInt149 - class2_1.anIntArray157[k4] < l5 && class2_1.anInt149 - class2_1.anIntArray157[k4] > -l5)
                        class2_1.anInt149 = class2_1.anIntArray157[k4];
                    if(class2_1.anInt150 < class2_1.anIntArray158[k4]) {
                        class2_1.anInt150 += l5;
                        class2_1.anInt152++;
                        if(i3 == -1)
                            i3 = 4;
                        else
                        if(i3 == 2)
                            i3 = 3;
                        else
                            i3 = 5;
                    } else
                    if(class2_1.anInt150 > class2_1.anIntArray158[k4]) {
                        class2_1.anInt150 -= l5;
                        class2_1.anInt152++;
                        if(i3 == -1)
                            i3 = 0;
                        else
                        if(i3 == 2)
                            i3 = 1;
                        else
                            i3 = 7;
                    }
                    if(class2_1.anInt150 - class2_1.anIntArray158[k4] < l5 && class2_1.anInt150 - class2_1.anIntArray158[k4] > -l5)
                        class2_1.anInt150 = class2_1.anIntArray158[k4];
                }
                if(i3 != -1)
                    class2_1.anInt153 = i3;
                if(class2_1.anInt149 == class2_1.anIntArray157[k4] && class2_1.anInt150 == class2_1.anIntArray158[k4])
                    class2_1.anInt155 = (k4 + 1) % 10;
            } else {
                class2_1.anInt153 = class2_1.anInt154;
                if(class2_1.anInt151 == 43)
                    class2_1.anInt152++;
            }
            if(class2_1.anInt161 > 0)
                class2_1.anInt161--;
            if(class2_1.anInt163 > 0)
                class2_1.anInt163--;
            if(class2_1.anInt167 > 0)
                class2_1.anInt167--;
        }

        if(anInt725 != 2) {
            if(Class6.anInt346 > 0)
                anInt668++;
            if(Class6.anInt347 > 0)
                anInt668 = 0;
            Class6.anInt346 = 0;
            Class6.anInt347 = 0;
        }
        for(int l = 0; l < anInt689; l++) {
            Class2 class2_2 = aClass2Array904[l];
            if(class2_2.anInt176 > 0)
                class2_2.anInt176--;
        }

        if(aBoolean929) {
            if(anInt879 - aClass2_888.anInt149 < -500 || anInt879 - aClass2_888.anInt149 > 500 || anInt880 - aClass2_888.anInt150 < -500 || anInt880 - aClass2_888.anInt150 > 500) {
                anInt879 = aClass2_888.anInt149;
                anInt880 = aClass2_888.anInt150;
            }
        } else {
            if(anInt879 - aClass2_888.anInt149 < -500 || anInt879 - aClass2_888.anInt149 > 500 || anInt880 - aClass2_888.anInt150 < -500 || anInt880 - aClass2_888.anInt150 > 500) {
                anInt879 = aClass2_888.anInt149;
                anInt880 = aClass2_888.anInt150;
            }
            if(anInt879 != aClass2_888.anInt149)
                anInt879 += (aClass2_888.anInt149 - anInt879) / (16 + (anInt913 - 500) / 15);
            if(anInt880 != aClass2_888.anInt150)
                anInt880 += (aClass2_888.anInt150 - anInt880) / (16 + (anInt913 - 500) / 15);
            if(aBoolean666) {
                int k1 = anInt731 * 32;
                int j3 = k1 - anInt809;
                byte byte0 = 1;
                if(j3 != 0) {
                    anInt732++;
                    if(j3 > 128) {
                        byte0 = -1;
                        j3 = 256 - j3;
                    } else
                    if(j3 > 0)
                        byte0 = 1;
                    else
                    if(j3 < -128) {
                        byte0 = 1;
                        j3 = 256 + j3;
                    } else
                    if(j3 < 0) {
                        byte0 = -1;
                        j3 = -j3;
                    }
                    anInt809 += ((anInt732 * j3 + 255) / 256) * byte0;
                    anInt809 &= 0xff;
                } else {
                    anInt732 = 0;
                }
            }
        }
        if(anInt668 > 20) {
            aBoolean914 = false;
            anInt668 = 0;
        }
        if(aBoolean776) {
            if(super.aString41.length() > 0)
                if(super.aString41.equalsIgnoreCase("::lostcon") && !aBoolean774)
                    super.aClass14_Sub1_620.method328();
                else
                if(super.aString41.equalsIgnoreCase("::closecon") && !aBoolean774) {
                    method22();
                } else {
                    super.aClass14_Sub1_620.method348(72);
                    super.aClass14_Sub1_620.method346(super.aString41);
                    if(!aBoolean914) {
                        super.aClass14_Sub1_620.method331(0);
                        aBoolean914 = true;
                    }
                    super.aClass14_Sub1_620.method330();
                    super.aString40 = "";
                    super.aString41 = "";
                    aString899 = "Please wait...";
                }
            if(super.anInt36 == 1 && super.anInt34 > 275 && super.anInt34 < 310 && super.anInt33 > 56 && super.anInt33 < 456) {
                super.aClass14_Sub1_620.method348(72);
                super.aClass14_Sub1_620.method346("-null-");
                if(!aBoolean914) {
                    super.aClass14_Sub1_620.method331(0);
                    aBoolean914 = true;
                }
                super.aClass14_Sub1_620.method330();
                super.aString40 = "";
                super.aString41 = "";
                aString899 = "Please wait...";
            }
            super.anInt36 = 0;
            return;
        }
        if(super.anInt34 > anInt986 - 4) {
            if(super.anInt33 > 15 && super.anInt33 < 96 && super.anInt36 == 1)
                anInt816 = 0;
            if(super.anInt33 > 110 && super.anInt33 < 194 && super.anInt36 == 1) {
                anInt816 = 1;
                aClass4_811.anIntArray187[anInt812] = 0xf423f;
            }
            if(super.anInt33 > 215 && super.anInt33 < 295 && super.anInt36 == 1) {
                anInt816 = 2;
                aClass4_811.anIntArray187[anInt814] = 0xf423f;
            }
            if(super.anInt33 > 315 && super.anInt33 < 395 && super.anInt36 == 1) {
                anInt816 = 3;
                aClass4_811.anIntArray187[anInt815] = 0xf423f;
            }
            if(super.anInt33 > 417 && super.anInt33 < 497 && super.anInt36 == 1) {
                anInt738 = 1;
                anInt839 = 0;
                super.aString40 = "";
                super.aString41 = "";
            }
            super.anInt36 = 0;
            super.anInt35 = 0;
        }
        aClass4_811.method138(super.anInt33, super.anInt34, super.anInt36, super.anInt35);
        if(anInt816 > 0 && super.anInt33 >= 494 && super.anInt34 >= anInt986 - 66)
            super.anInt36 = 0;
        if(aClass4_811.method139(anInt813)) {
            String s = aClass4_811.method169(anInt813);
            aClass4_811.method168(anInt813, "");
            if(s.startsWith("::")) {
                if(s.equalsIgnoreCase("::closecon") && !aBoolean774)
                    super.aClass14_Sub1_620.method328();
                else
                if(s.equalsIgnoreCase("::logout") && !aBoolean774)
                    method22();
                else
                if(s.equalsIgnoreCase("::lostcon") && !aBoolean774)
                    method23();
                else
                    method35(s.substring(2));
            } else {
                int k3 = Class17.method399(s);
                method34(Class17.aByteArray569, k3);
                s = Class17.method398(Class17.aByteArray569, 0, k3);
                s = Class16.method373(s);
                aClass2_888.anInt161 = 150;
                aClass2_888.aString160 = s;
                method97(aClass2_888.aString146 + ": " + s, 2);
            }
        }
        if(anInt816 == 0) {
            for(int l1 = 0; l1 < 5; l1++)
                if(anIntArray878[l1] > 0)
                    anIntArray878[l1]--;

        }
        if(anInt975 != 0)
            super.anInt36 = 0;
        if(aBoolean974 || aBoolean932) {
            if(super.anInt35 != 0)
                anInt893++;
            else
                anInt893 = 0;
            if(anInt893 > 600)
                anInt894 += 5000;
            else
            if(anInt893 > 450)
                anInt894 += 500;
            else
            if(anInt893 > 300)
                anInt894 += 50;
            else
            if(anInt893 > 150)
                anInt894 += 5;
            else
            if(anInt893 > 50)
                anInt894++;
            else
            if(anInt893 > 20 && (anInt893 & 5) == 0)
                anInt894++;
        } else {
            anInt893 = 0;
            anInt894 = 0;
        }
        if(super.anInt36 == 1)
            anInt912 = 1;
        else
        if(super.anInt36 == 2)
            anInt912 = 2;
        aClass10_939.method276(super.anInt33, super.anInt34);
        super.anInt36 = 0;
        if(aBoolean666) {
            if(anInt732 == 0 || aBoolean929) {
                if(super.aBoolean26) {
                    anInt731 = anInt731 + 1 & 7;
                    super.aBoolean26 = false;
                    if(!aBoolean926) {
                        if((anInt731 & 1) == 0)
                            anInt731 = anInt731 + 1 & 7;
                        for(int i2 = 0; i2 < 8; i2++) {
                            if(method100(anInt731))
                                break;
                            anInt731 = anInt731 + 1 & 7;
                        }

                    }
                }
                if(super.aBoolean27) {
                    anInt731 = anInt731 + 7 & 7;
                    super.aBoolean27 = false;
                    if(!aBoolean926) {
                        if((anInt731 & 1) == 0)
                            anInt731 = anInt731 + 7 & 7;
                        for(int j2 = 0; j2 < 8; j2++) {
                            if(method100(anInt731))
                                break;
                            anInt731 = anInt731 + 7 & 7;
                        }

                    }
                }
            }
        } else
        if(super.aBoolean26)
            anInt809 = anInt809 + 2 & 0xff;
        else
        if(super.aBoolean27)
            anInt809 = anInt809 - 2 & 0xff;
        if(aBoolean926 && anInt913 > 550)
            anInt913 -= 4;
        else
        if(!aBoolean926 && anInt913 < 750)
            anInt913 += 4;
        if(anInt841 > 0)
            anInt841--;
        else
        if(anInt841 < 0)
            anInt841++;
        aClass10_939.method306(17);
        anInt958++;
        if(anInt958 > 5) {
            anInt958 = 0;
            anInt896 = (anInt896 + 1) % 3;
            anInt897 = (anInt897 + 1) % 4;
            anInt898 = (anInt898 + 1) % 5;
        }
        for(int k2 = 0; k2 < anInt981; k2++) {
            int l3 = anIntArray882[k2];
            int l4 = anIntArray883[k2];
            if(l3 >= 0 && l4 >= 0 && l3 < 96 && l4 < 96 && anIntArray884[k2] == 74)
                aClass5Array805[k2].method188(1, 0, 0);
        }

        for(int i4 = 0; i4 < anInt902; i4++) {
            anIntArray933[i4]++;
            if(anIntArray933[i4] > 50) {
                anInt902--;
                for(int i5 = i4; i5 < anInt902; i5++) {
                    anIntArray954[i5] = anIntArray954[i5 + 1];
                    anIntArray767[i5] = anIntArray767[i5 + 1];
                    anIntArray933[i5] = anIntArray933[i5 + 1];
                    anIntArray792[i5] = anIntArray792[i5 + 1];
                }

            }
        }

    }

    public void method90() {
        try {
            aByteArray977 = method18("sounds" + Class18.anInt580 + ".mem", "Sound effects", 90);
            anInputStream_Sub1_927 = new InputStream_Sub1();
            return;
        }
        catch(Throwable throwable) {
            System.out.println("Unable to init sounds:" + throwable);
        }
    }

    public void method91() {
        byte byte0 = 7;
        byte byte1 = 15;
        char c = '\257';
        if(anInt912 != 0) {
            for(int i = 0; i < 5; i++) {
                if(i <= 0 || super.anInt33 <= byte0 || super.anInt33 >= byte0 + c || super.anInt34 <= byte1 + i * 20 || super.anInt34 >= byte1 + i * 20 + 20)
                    continue;
                anInt775 = i - 1;
                anInt912 = 0;
                super.aClass14_Sub1_620.method348(41);
                super.aClass14_Sub1_620.method331(anInt775);
                super.aClass14_Sub1_620.method330();
                break;
            }

        }
        for(int j = 0; j < 5; j++) {
            if(j == anInt775 + 1)
                aClass6_Sub1_935.method213(byte0, byte1 + j * 20, c, 20, Class6.method222(255, 0, 0), 128);
            else
                aClass6_Sub1_935.method213(byte0, byte1 + j * 20, c, 20, Class6.method222(190, 190, 190), 128);
            aClass6_Sub1_935.method217(byte0, byte1 + j * 20, c, 0);
            aClass6_Sub1_935.method217(byte0, byte1 + j * 20 + 20, c, 0);
        }

        aClass6_Sub1_935.method254("Select combat style", byte0 + c / 2, byte1 + 16, 3, 0xffffff);
        aClass6_Sub1_935.method254("Controlled (+1 of each)", byte0 + c / 2, byte1 + 36, 3, 0);
        aClass6_Sub1_935.method254("Aggressive (+3 strength)", byte0 + c / 2, byte1 + 56, 3, 0);
        aClass6_Sub1_935.method254("Accurate   (+3 attack)", byte0 + c / 2, byte1 + 76, 3, 0);
        aClass6_Sub1_935.method254("Defensive  (+3 defense)", byte0 + c / 2, byte1 + 96, 3, 0);
    }

    public void method92() {
        aClass19_903.aByteArray593 = method18("maps" + Class18.anInt575 + ".jag", "map", 70);
        if(aBoolean867)
            aClass19_903.aByteArray610 = method18("maps" + Class18.anInt575 + ".mem", "members map", 75);
        aClass19_903.aByteArray592 = method18("land" + Class18.anInt575 + ".jag", "landscape", 80);
        if(aBoolean867)
            aClass19_903.aByteArray609 = method18("land" + Class18.anInt575 + ".mem", "members landscape", 85);
    }

    public void method93() {
        byte byte0 = 22;
        byte byte1 = 36;
        aClass6_Sub1_935.method215(byte0, byte1, 468, 16, 192);
        int i = 0x989898;
        aClass6_Sub1_935.method213(byte0, byte1 + 16, 468, 246, i, 160);
        aClass6_Sub1_935.method254("Please confirm your duel with @yel@" + Class15.method362(aLong993), byte0 + 234, byte1 + 12, 1, 0xffffff);
        aClass6_Sub1_935.method254("Your stake:", byte0 + 117, byte1 + 30, 1, 0xffff00);
        for(int j = 0; j < anInt872; j++) {
            String s = Class1.aStringArray112[anIntArray873[j]];
            if(Class1.anIntArray73[anIntArray873[j]] == 0)
                s = s + " x " + method74(anIntArray874[j]);
            aClass6_Sub1_935.method254(s, byte0 + 117, byte1 + 42 + j * 12, 1, 0xffffff);
        }

        if(anInt872 == 0)
            aClass6_Sub1_935.method254("Nothing!", byte0 + 117, byte1 + 42, 1, 0xffffff);
        aClass6_Sub1_935.method254("Your opponent's stake:", byte0 + 351, byte1 + 30, 1, 0xffff00);
        for(int k = 0; k < anInt793; k++) {
            String s1 = Class1.aStringArray112[anIntArray794[k]];
            if(Class1.anIntArray73[anIntArray794[k]] == 0)
                s1 = s1 + " x " + method74(anIntArray795[k]);
            aClass6_Sub1_935.method254(s1, byte0 + 351, byte1 + 42 + k * 12, 1, 0xffffff);
        }

        if(anInt793 == 0)
            aClass6_Sub1_935.method254("Nothing!", byte0 + 351, byte1 + 42, 1, 0xffffff);
        if(anInt739 == 0)
            aClass6_Sub1_935.method254("You can retreat from this duel", byte0 + 234, byte1 + 180, 1, 65280);
        else
            aClass6_Sub1_935.method254("No retreat is possible!", byte0 + 234, byte1 + 180, 1, 0xff0000);
        if(anInt740 == 0)
            aClass6_Sub1_935.method254("Magic may be used", byte0 + 234, byte1 + 192, 1, 65280);
        else
            aClass6_Sub1_935.method254("Magic cannot be used", byte0 + 234, byte1 + 192, 1, 0xff0000);
        if(anInt741 == 0)
            aClass6_Sub1_935.method254("Prayer may be used", byte0 + 234, byte1 + 204, 1, 65280);
        else
            aClass6_Sub1_935.method254("Prayer cannot be used", byte0 + 234, byte1 + 204, 1, 0xff0000);
        if(anInt742 == 0)
            aClass6_Sub1_935.method254("Weapons may be used", byte0 + 234, byte1 + 216, 1, 65280);
        else
            aClass6_Sub1_935.method254("Weapons cannot be used", byte0 + 234, byte1 + 216, 1, 0xff0000);
        aClass6_Sub1_935.method254("If you are sure click 'Accept' to begin the duel", byte0 + 234, byte1 + 230, 1, 0xffffff);
        if(!aBoolean945) {
            aClass6_Sub1_935.method230((byte0 + 118) - 35, byte1 + 238, anInt778 + 25);
            aClass6_Sub1_935.method230((byte0 + 352) - 35, byte1 + 238, anInt778 + 26);
        } else {
            aClass6_Sub1_935.method254("Waiting for other player...", byte0 + 234, byte1 + 250, 1, 0xffff00);
        }
        if(anInt912 == 1) {
            if(super.anInt33 < byte0 || super.anInt34 < byte1 || super.anInt33 > byte0 + 468 || super.anInt34 > byte1 + 262) {
                aBoolean944 = false;
                super.aClass14_Sub1_620.method348(216);
                super.aClass14_Sub1_620.method330();
            }
            if(super.anInt33 >= (byte0 + 118) - 35 && super.anInt33 <= byte0 + 118 + 70 && super.anInt34 >= byte1 + 238 && super.anInt34 <= byte1 + 238 + 21) {
                aBoolean945 = true;
                super.aClass14_Sub1_620.method348(87);
                super.aClass14_Sub1_620.method330();
            }
            if(super.anInt33 >= (byte0 + 352) - 35 && super.anInt33 <= byte0 + 353 + 70 && super.anInt34 >= byte1 + 238 && super.anInt34 <= byte1 + 238 + 21) {
                aBoolean944 = false;
                super.aClass14_Sub1_620.method348(35);
                super.aClass14_Sub1_620.method330();
            }
            anInt912 = 0;
        }
    }

    public void method94() {
        anInt853 = anInt770;
        for(int i = 0; i < anInt770; i++) {
            anIntArray915[i] = anIntArray870[i];
            anIntArray916[i] = anIntArray871[i];
        }

        for(int j = 0; j < anInt692; j++) {
            if(anInt853 >= anInt724)
                break;
            int k = anIntArray693[j];
            boolean flag = false;
            for(int l = 0; l < anInt853; l++) {
                if(anIntArray915[l] != k)
                    continue;
                flag = true;
                break;
            }

            if(!flag) {
                anIntArray915[anInt853] = k;
                anIntArray916[anInt853] = 0;
                anInt853++;
            }
        }

    }

    public void method95() {
        aClass4_955 = new Class4(aClass6_Sub1_935, 100);
        aClass4_955.method155(256, 10, "Please design Your Character", 4, true);
        int i = 140;
        int j = 34;
        i += 116;
        j -= 10;
        aClass4_955.method155(i - 55, j + 110, "Front", 3, true);
        aClass4_955.method155(i, j + 110, "Side", 3, true);
        aClass4_955.method155(i + 55, j + 110, "Back", 3, true);
        byte byte0 = 54;
        j += 145;
        aClass4_955.method157(i - byte0, j, 53, 41);
        aClass4_955.method155(i - byte0, j - 8, "Head", 1, true);
        aClass4_955.method155(i - byte0, j + 8, "Type", 1, true);
        aClass4_955.method158(i - byte0 - 40, j, Class4.anInt221 + 7);
        anInt854 = aClass4_955.method163(i - byte0 - 40, j, 20, 20);
        aClass4_955.method158((i - byte0) + 40, j, Class4.anInt221 + 6);
        anInt855 = aClass4_955.method163((i - byte0) + 40, j, 20, 20);
        aClass4_955.method157(i + byte0, j, 53, 41);
        aClass4_955.method155(i + byte0, j - 8, "Hair", 1, true);
        aClass4_955.method155(i + byte0, j + 8, "Color", 1, true);
        aClass4_955.method158((i + byte0) - 40, j, Class4.anInt221 + 7);
        anInt856 = aClass4_955.method163((i + byte0) - 40, j, 20, 20);
        aClass4_955.method158(i + byte0 + 40, j, Class4.anInt221 + 6);
        anInt857 = aClass4_955.method163(i + byte0 + 40, j, 20, 20);
        j += 50;
        aClass4_955.method157(i - byte0, j, 53, 41);
        aClass4_955.method155(i - byte0, j, "Gender", 1, true);
        aClass4_955.method158(i - byte0 - 40, j, Class4.anInt221 + 7);
        anInt858 = aClass4_955.method163(i - byte0 - 40, j, 20, 20);
        aClass4_955.method158((i - byte0) + 40, j, Class4.anInt221 + 6);
        anInt859 = aClass4_955.method163((i - byte0) + 40, j, 20, 20);
        aClass4_955.method157(i + byte0, j, 53, 41);
        aClass4_955.method155(i + byte0, j - 8, "Top", 1, true);
        aClass4_955.method155(i + byte0, j + 8, "Color", 1, true);
        aClass4_955.method158((i + byte0) - 40, j, Class4.anInt221 + 7);
        anInt860 = aClass4_955.method163((i + byte0) - 40, j, 20, 20);
        aClass4_955.method158(i + byte0 + 40, j, Class4.anInt221 + 6);
        anInt861 = aClass4_955.method163(i + byte0 + 40, j, 20, 20);
        j += 50;
        aClass4_955.method157(i - byte0, j, 53, 41);
        aClass4_955.method155(i - byte0, j - 8, "Skin", 1, true);
        aClass4_955.method155(i - byte0, j + 8, "Color", 1, true);
        aClass4_955.method158(i - byte0 - 40, j, Class4.anInt221 + 7);
        anInt862 = aClass4_955.method163(i - byte0 - 40, j, 20, 20);
        aClass4_955.method158((i - byte0) + 40, j, Class4.anInt221 + 6);
        anInt863 = aClass4_955.method163((i - byte0) + 40, j, 20, 20);
        aClass4_955.method157(i + byte0, j, 53, 41);
        aClass4_955.method155(i + byte0, j - 8, "Bottom", 1, true);
        aClass4_955.method155(i + byte0, j + 8, "Color", 1, true);
        aClass4_955.method158((i + byte0) - 40, j, Class4.anInt221 + 7);
        anInt864 = aClass4_955.method163((i + byte0) - 40, j, 20, 20);
        aClass4_955.method158(i + byte0 + 40, j, Class4.anInt221 + 6);
        anInt865 = aClass4_955.method163(i + byte0 + 40, j, 20, 20);
        j += 82;
        j -= 35;
        aClass4_955.method156(i, j, 200, 30);
        aClass4_955.method155(i, j, "Accept", 4, false);
        anInt866 = aClass4_955.method163(i, j, 200, 30);
    }

    public void method96() {
        if(super.aString41.length() > 0) {
            String s = super.aString41.trim();
            super.aString40 = "";
            super.aString41 = "";
            if(s.length() > 0) {
                long l = Class15.method361(s);
                super.aClass14_Sub1_620.method348(7);
                super.aClass14_Sub1_620.method333(l);
                super.aClass14_Sub1_620.method331(anInt839);
                super.aClass14_Sub1_620.method331(aBoolean840 ? 1 : 0);
                super.aClass14_Sub1_620.method330();
            }
            anInt738 = 0;
            return;
        }
        aClass6_Sub1_935.method215(56, 130, 400, 100, 0);
        aClass6_Sub1_935.method216(56, 130, 400, 100, 0xffffff);
        int i = 160;
        aClass6_Sub1_935.method254("Now type the name of the offending player, and press enter", 256, i, 1, 0xffff00);
        i += 18;
        aClass6_Sub1_935.method254("Name: " + super.aString40 + "*", 256, i, 4, 0xffffff);
        if(super.anInt637 > 0) {
            i = 207;
            if(aBoolean840)
                aClass6_Sub1_935.method254("Moderator option: Mute player for 48 hours: <ON>", 256, i, 1, 0xff8000);
            else
                aClass6_Sub1_935.method254("Moderator option: Mute player for 48 hours: <OFF>", 256, i, 1, 0xffffff);
            if(super.anInt33 > 106 && super.anInt33 < 406 && super.anInt34 > i - 13 && super.anInt34 < i + 2 && anInt912 == 1) {
                anInt912 = 0;
                aBoolean840 = !aBoolean840;
            }
        }
        i = 222;
        int j = 0xffffff;
        if(super.anInt33 > 196 && super.anInt33 < 316 && super.anInt34 > i - 13 && super.anInt34 < i + 2) {
            j = 0xffff00;
            if(anInt912 == 1) {
                anInt912 = 0;
                anInt738 = 0;
            }
        }
        aClass6_Sub1_935.method254("Click here to cancel", 256, i, 1, j);
        if(anInt912 == 1 && (super.anInt33 < 56 || super.anInt33 > 456 || super.anInt34 < 130 || super.anInt34 > 230)) {
            anInt912 = 0;
            anInt738 = 0;
        }
    }

    public void method97(String s, int i) {
        if(i == 2 || i == 4 || i == 6) {
            for(; s.length() > 5 && s.charAt(0) == '@' && s.charAt(4) == '@'; s = s.substring(5));
            int j = s.indexOf(":");
            if(j != -1) {
                String s1 = s.substring(0, j);
                long l = Class15.method361(s1);
                for(int i1 = 0; i1 < super.anInt627; i1++)
                    if(super.aLongArray628[i1] == l)
                        return;

            }
        }
        if(i == 2)
            s = "@yel@" + s;
        if(i == 3 || i == 4)
            s = "@whi@" + s;
        if(i == 6)
            s = "@cya@" + s;
        if(anInt816 != 0) {
            if(i == 4 || i == 3)
                anInt962 = 200;
            if(i == 2 && anInt816 != 1)
                anInt963 = 200;
            if(i == 5 && anInt816 != 2)
                anInt964 = 200;
            if(i == 6 && anInt816 != 3)
                anInt965 = 200;
            if(i == 3 && anInt816 != 0)
                anInt816 = 0;
            if(i == 6 && anInt816 != 3 && anInt816 != 0)
                anInt816 = 0;
        }
        for(int k = 4; k > 0; k--) {
            aStringArray972[k] = aStringArray972[k - 1];
            anIntArray878[k] = anIntArray878[k - 1];
        }

        aStringArray972[0] = s;
        anIntArray878[0] = 300;
        if(i == 2)
            if(aClass4_811.anIntArray187[anInt812] == aClass4_811.anIntArray188[anInt812] - 4)
                aClass4_811.method167(anInt812, s, true);
            else
                aClass4_811.method167(anInt812, s, false);
        if(i == 5)
            if(aClass4_811.anIntArray187[anInt814] == aClass4_811.anIntArray188[anInt814] - 4)
                aClass4_811.method167(anInt814, s, true);
            else
                aClass4_811.method167(anInt814, s, false);
        if(i == 6) {
            if(aClass4_811.anIntArray187[anInt815] == aClass4_811.anIntArray188[anInt815] - 4) {
                aClass4_811.method167(anInt815, s, true);
                return;
            }
            aClass4_811.method167(anInt815, s, false);
        }
    }

    public void method3() {
        method22();
        method79();
        if(anInputStream_Sub1_927 != null)
            anInputStream_Sub1_927.method121();
    }

    public void method98(int i, String s) {
        int j = anIntArray882[i];
        int k = anIntArray883[i];
        int l = j - aClass2_888.anInt149 / 128;
        int i1 = k - aClass2_888.anInt150 / 128;
        byte byte0 = 7;
        if(j >= 0 && k >= 0 && j < 96 && k < 96 && l > -byte0 && l < byte0 && i1 > -byte0 && i1 < byte0) {
            aClass10_939.method269(aClass5Array805[i]);
            int j1 = Class1.method123(s);
            Class5 class5 = aClass5Array777[j1].method203();
            aClass10_939.method268(class5);
            class5.method184(true, 48, 48, -50, -10, -50);
            class5.method205(aClass5Array805[i]);
            class5.anInt257 = i;
            aClass5Array805[i] = class5;
        }
    }

    public void method38() {
        anInt807 = 0;
        anInt775 = 0;
        anInt810 = 0;
        anInt708 = 0;
        anInt730 = 1;
        method116();
        aClass6_Sub1_935.method211();
        aClass6_Sub1_935.method210(aGraphics946, 0, 0);
        for(int i = 0; i < anInt981; i++) {
            aClass10_939.method269(aClass5Array805[i]);
            aClass19_903.method403(anIntArray882[i], anIntArray883[i], anIntArray884[i]);
        }

        for(int j = 0; j < anInt959; j++) {
            aClass10_939.method269(aClass5Array700[j]);
            aClass19_903.method419(anIntArray947[j], anIntArray948[j], anIntArray960[j], anIntArray961[j]);
        }

        anInt981 = 0;
        anInt959 = 0;
        anInt895 = 0;
        anInt689 = 0;
        for(int k = 0; k < 4000; k++)
            aClass2Array713[k] = null;

        for(int l = 0; l < 500; l++)
            aClass2Array904[l] = null;

        anInt717 = 0;
        for(int i1 = 0; i1 < 5000; i1++)
            aClass2Array930[i1] = null;

        for(int j1 = 0; j1 < 500; j1++)
            aClass2Array705[j1] = null;

        for(int k1 = 0; k1 < 50; k1++)
            aBooleanArray710[k1] = false;

        anInt912 = 0;
        super.anInt36 = 0;
        super.anInt35 = 0;
        aBoolean940 = false;
        aBoolean699 = false;
        aBoolean776 = false;
        super.anInt624 = 0;
    }

    public int method44() {
        return Class8.anInt371;
    }

    public void method99() {
        if(anInt912 != 0 && anInt894 == 0)
            anInt894 = 1;
        if(anInt894 > 0) {
            int i = super.anInt33 - 22;
            int j = super.anInt34 - 36;
            if(i >= 0 && j >= 0 && i < 468 && j < 262) {
                if(i > 216 && j > 30 && i < 462 && j < 235) {
                    int k = (i - 217) / 49 + ((j - 31) / 34) * 5;
                    if(k >= 0 && k < anInt692) {
                        boolean flag = false;
                        int l1 = 0;
                        int k2 = anIntArray693[k];
                        for(int k3 = 0; k3 < anInt982; k3++)
                            if(anIntArray983[k3] == k2)
                                if(Class1.anIntArray73[k2] == 0) {
                                    for(int i4 = 0; i4 < anInt894; i4++) {
                                        if(anIntArray984[k3] < anIntArray694[k])
                                            anIntArray984[k3]++;
                                        flag = true;
                                    }

                                } else {
                                    l1++;
                                }

                        if(method47(k2) <= l1)
                            flag = true;
                        if(Class1.anIntArray77[k2] == 1) {
                            method97("This object cannot be traded with other players", 3);
                            flag = true;
                        }
                        if(!flag && anInt982 < 12) {
                            anIntArray983[anInt982] = k2;
                            anIntArray984[anInt982] = 1;
                            anInt982++;
                            flag = true;
                        }
                        if(flag) {
                            super.aClass14_Sub1_620.method348(70);
                            super.aClass14_Sub1_620.method331(anInt982);
                            for(int j4 = 0; j4 < anInt982; j4++) {
                                super.aClass14_Sub1_620.method336(anIntArray983[j4]);
                                super.aClass14_Sub1_620.method334(anIntArray984[j4]);
                            }

                            super.aClass14_Sub1_620.method330();
                            aBoolean711 = false;
                            aBoolean712 = false;
                        }
                    }
                }
                if(i > 8 && j > 30 && i < 205 && j < 133) {
                    int l = (i - 9) / 49 + ((j - 31) / 34) * 4;
                    if(l >= 0 && l < anInt982) {
                        int j1 = anIntArray983[l];
                        for(int i2 = 0; i2 < anInt894; i2++) {
                            if(Class1.anIntArray73[j1] == 0 && anIntArray984[l] > 1) {
                                anIntArray984[l]--;
                                continue;
                            }
                            anInt982--;
                            anInt893 = 0;
                            for(int l2 = l; l2 < anInt982; l2++) {
                                anIntArray983[l2] = anIntArray983[l2 + 1];
                                anIntArray984[l2] = anIntArray984[l2 + 1];
                            }

                            break;
                        }

                        super.aClass14_Sub1_620.method348(70);
                        super.aClass14_Sub1_620.method331(anInt982);
                        for(int i3 = 0; i3 < anInt982; i3++) {
                            super.aClass14_Sub1_620.method336(anIntArray983[i3]);
                            super.aClass14_Sub1_620.method334(anIntArray984[i3]);
                        }

                        super.aClass14_Sub1_620.method330();
                        aBoolean711 = false;
                        aBoolean712 = false;
                    }
                }
                if(i >= 217 && j >= 238 && i <= 286 && j <= 259) {
                    aBoolean712 = true;
                    super.aClass14_Sub1_620.method348(211);
                    super.aClass14_Sub1_620.method330();
                }
                if(i >= 394 && j >= 238 && i < 463 && j < 259) {
                    aBoolean974 = false;
                    super.aClass14_Sub1_620.method348(216);
                    super.aClass14_Sub1_620.method330();
                }
            } else
            if(anInt912 != 0) {
                aBoolean974 = false;
                super.aClass14_Sub1_620.method348(216);
                super.aClass14_Sub1_620.method330();
            }
            anInt912 = 0;
            anInt894 = 0;
        }
        if(!aBoolean974)
            return;
        byte byte0 = 22;
        byte byte1 = 36;
        aClass6_Sub1_935.method215(byte0, byte1, 468, 12, 192);
        int i1 = 0x989898;
        aClass6_Sub1_935.method213(byte0, byte1 + 12, 468, 18, i1, 160);
        aClass6_Sub1_935.method213(byte0, byte1 + 30, 8, 248, i1, 160);
        aClass6_Sub1_935.method213(byte0 + 205, byte1 + 30, 11, 248, i1, 160);
        aClass6_Sub1_935.method213(byte0 + 462, byte1 + 30, 6, 248, i1, 160);
        aClass6_Sub1_935.method213(byte0 + 8, byte1 + 133, 197, 22, i1, 160);
        aClass6_Sub1_935.method213(byte0 + 8, byte1 + 258, 197, 20, i1, 160);
        aClass6_Sub1_935.method213(byte0 + 216, byte1 + 235, 246, 43, i1, 160);
        int k1 = 0xd0d0d0;
        aClass6_Sub1_935.method213(byte0 + 8, byte1 + 30, 197, 103, k1, 160);
        aClass6_Sub1_935.method213(byte0 + 8, byte1 + 155, 197, 103, k1, 160);
        aClass6_Sub1_935.method213(byte0 + 216, byte1 + 30, 246, 205, k1, 160);
        for(int j2 = 0; j2 < 4; j2++)
            aClass6_Sub1_935.method217(byte0 + 8, byte1 + 30 + j2 * 34, 197, 0);

        for(int j3 = 0; j3 < 4; j3++)
            aClass6_Sub1_935.method217(byte0 + 8, byte1 + 155 + j3 * 34, 197, 0);

        for(int l3 = 0; l3 < 7; l3++)
            aClass6_Sub1_935.method217(byte0 + 216, byte1 + 30 + l3 * 34, 246, 0);

        for(int k4 = 0; k4 < 6; k4++) {
            if(k4 < 5)
                aClass6_Sub1_935.method218(byte0 + 8 + k4 * 49, byte1 + 30, 103, 0);
            if(k4 < 5)
                aClass6_Sub1_935.method218(byte0 + 8 + k4 * 49, byte1 + 155, 103, 0);
            aClass6_Sub1_935.method218(byte0 + 216 + k4 * 49, byte1 + 30, 205, 0);
        }

        aClass6_Sub1_935.method256("Trading with: " + aString994, byte0 + 1, byte1 + 10, 1, 0xffffff);
        aClass6_Sub1_935.method256("Your Offer", byte0 + 9, byte1 + 27, 4, 0xffffff);
        aClass6_Sub1_935.method256("Opponent's Offer", byte0 + 9, byte1 + 152, 4, 0xffffff);
        aClass6_Sub1_935.method256("Your Inventory", byte0 + 216, byte1 + 27, 4, 0xffffff);
        if(!aBoolean712)
            aClass6_Sub1_935.method230(byte0 + 217, byte1 + 238, anInt778 + 25);
        aClass6_Sub1_935.method230(byte0 + 394, byte1 + 238, anInt778 + 26);
        if(aBoolean711) {
            aClass6_Sub1_935.method254("Other player", byte0 + 341, byte1 + 246, 1, 0xffffff);
            aClass6_Sub1_935.method254("has accepted", byte0 + 341, byte1 + 256, 1, 0xffffff);
        }
        if(aBoolean712) {
            aClass6_Sub1_935.method254("Waiting for", byte0 + 217 + 35, byte1 + 246, 1, 0xffffff);
            aClass6_Sub1_935.method254("other player", byte0 + 217 + 35, byte1 + 256, 1, 0xffffff);
        }
        for(int l4 = 0; l4 < anInt692; l4++) {
            int i5 = 217 + byte0 + (l4 % 5) * 49;
            int k5 = 31 + byte1 + (l4 / 5) * 34;
            aClass6_Sub1_935.method246(i5, k5, 48, 32, anInt780 + Class1.anIntArray71[anIntArray693[l4]], Class1.anIntArray76[anIntArray693[l4]], 0, 0, false);
            if(Class1.anIntArray73[anIntArray693[l4]] == 0)
                aClass6_Sub1_935.method256(String.valueOf(anIntArray694[l4]), i5 + 1, k5 + 10, 1, 0xffff00);
        }

        for(int j5 = 0; j5 < anInt982; j5++) {
            int l5 = 9 + byte0 + (j5 % 4) * 49;
            int j6 = 31 + byte1 + (j5 / 4) * 34;
            aClass6_Sub1_935.method246(l5, j6, 48, 32, anInt780 + Class1.anIntArray71[anIntArray983[j5]], Class1.anIntArray76[anIntArray983[j5]], 0, 0, false);
            if(Class1.anIntArray73[anIntArray983[j5]] == 0)
                aClass6_Sub1_935.method256(String.valueOf(anIntArray984[j5]), l5 + 1, j6 + 10, 1, 0xffff00);
            if(super.anInt33 > l5 && super.anInt33 < l5 + 48 && super.anInt34 > j6 && super.anInt34 < j6 + 32)
                aClass6_Sub1_935.method256(Class1.aStringArray112[anIntArray983[j5]] + ": @whi@" + Class1.aStringArray113[anIntArray983[j5]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }

        for(int i6 = 0; i6 < anInt922; i6++) {
            int k6 = 9 + byte0 + (i6 % 4) * 49;
            int l6 = 156 + byte1 + (i6 / 4) * 34;
            aClass6_Sub1_935.method246(k6, l6, 48, 32, anInt780 + Class1.anIntArray71[anIntArray923[i6]], Class1.anIntArray76[anIntArray923[i6]], 0, 0, false);
            if(Class1.anIntArray73[anIntArray923[i6]] == 0)
                aClass6_Sub1_935.method256(String.valueOf(anIntArray924[i6]), k6 + 1, l6 + 10, 1, 0xffff00);
            if(super.anInt33 > k6 && super.anInt33 < k6 + 48 && super.anInt34 > l6 && super.anInt34 < l6 + 32)
                aClass6_Sub1_935.method256(Class1.aStringArray112[anIntArray923[i6]] + ": @whi@" + Class1.aStringArray113[anIntArray923[i6]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }

    }

    public boolean method100(int i) {
        int j = aClass2_888.anInt149 / 128;
        int k = aClass2_888.anInt150 / 128;
        for(int l = 2; l >= 1; l--) {
            if(i == 1 && ((aClass19_903.anIntArrayArray611[j][k - l] & 0x80) == 128 || (aClass19_903.anIntArrayArray611[j - l][k] & 0x80) == 128 || (aClass19_903.anIntArrayArray611[j - l][k - l] & 0x80) == 128))
                return false;
            if(i == 3 && ((aClass19_903.anIntArrayArray611[j][k + l] & 0x80) == 128 || (aClass19_903.anIntArrayArray611[j - l][k] & 0x80) == 128 || (aClass19_903.anIntArrayArray611[j - l][k + l] & 0x80) == 128))
                return false;
            if(i == 5 && ((aClass19_903.anIntArrayArray611[j][k + l] & 0x80) == 128 || (aClass19_903.anIntArrayArray611[j + l][k] & 0x80) == 128 || (aClass19_903.anIntArrayArray611[j + l][k + l] & 0x80) == 128))
                return false;
            if(i == 7 && ((aClass19_903.anIntArrayArray611[j][k - l] & 0x80) == 128 || (aClass19_903.anIntArrayArray611[j + l][k] & 0x80) == 128 || (aClass19_903.anIntArrayArray611[j + l][k - l] & 0x80) == 128))
                return false;
            if(i == 0 && (aClass19_903.anIntArrayArray611[j][k - l] & 0x80) == 128)
                return false;
            if(i == 2 && (aClass19_903.anIntArrayArray611[j - l][k] & 0x80) == 128)
                return false;
            if(i == 4 && (aClass19_903.anIntArrayArray611[j][k + l] & 0x80) == 128)
                return false;
            if(i == 6 && (aClass19_903.anIntArrayArray611[j + l][k] & 0x80) == 128)
                return false;
        }

        return true;
    }

    public URL getDocumentBase() {
        if(Class8.anApplet370 != null)
            return Class8.anApplet370.getDocumentBase();
        else
            return super.getDocumentBase();
    }

    public void method41(int i, int j, byte abyte0[]) {
        try {
            if(i == 145) {
                anInt690 = anInt689;
                for(int k = 0; k < anInt690; k++)
                    aClass2Array772[k] = aClass2Array904[k];

                int k7 = 8;
                anInt889 = Class15.method358(abyte0, k7, 11);
                k7 += 11;
                anInt890 = Class15.method358(abyte0, k7, 13);
                k7 += 13;
                int l13 = Class15.method358(abyte0, k7, 4);
                k7 += 4;
                boolean flag1 = method84(anInt889, anInt890);
                anInt889 -= anInt749;
                anInt890 -= anInt750;
                int l22 = anInt889 * anInt729 + 64;
                int l25 = anInt890 * anInt729 + 64;
                if(flag1) {
                    aClass2_888.anInt156 = 0;
                    aClass2_888.anInt155 = 0;
                    aClass2_888.anInt149 = aClass2_888.anIntArray157[0] = l22;
                    aClass2_888.anInt150 = aClass2_888.anIntArray158[0] = l25;
                }
                anInt689 = 0;
                aClass2_888 = method63(anInt891, l22, l25, l13);
                int i29 = Class15.method358(abyte0, k7, 8);
                k7 += 8;
                for(int l33 = 0; l33 < i29; l33++) {
                    Class2 class2_3 = aClass2Array772[l33 + 1];
                    int k39 = Class15.method358(abyte0, k7, 1);
                    k7++;
                    if(k39 != 0) {
                        int k41 = Class15.method358(abyte0, k7, 1);
                        k7++;
                        if(k41 == 0) {
                            int l42 = Class15.method358(abyte0, k7, 3);
                            k7 += 3;
                            int l43 = class2_3.anInt156;
                            int j44 = class2_3.anIntArray157[l43];
                            int k44 = class2_3.anIntArray158[l43];
                            if(l42 == 2 || l42 == 1 || l42 == 3)
                                j44 += anInt729;
                            if(l42 == 6 || l42 == 5 || l42 == 7)
                                j44 -= anInt729;
                            if(l42 == 4 || l42 == 3 || l42 == 5)
                                k44 += anInt729;
                            if(l42 == 0 || l42 == 1 || l42 == 7)
                                k44 -= anInt729;
                            class2_3.anInt154 = l42;
                            class2_3.anInt156 = l43 = (l43 + 1) % 10;
                            class2_3.anIntArray157[l43] = j44;
                            class2_3.anIntArray158[l43] = k44;
                        } else {
                            int i43 = Class15.method358(abyte0, k7, 4);
                            if((i43 & 0xc) == 12) {
                                k7 += 2;
                                continue;
                            }
                            class2_3.anInt154 = Class15.method358(abyte0, k7, 4);
                            k7 += 4;
                        }
                    }
                    aClass2Array904[anInt689++] = class2_3;
                }

                int i37 = 0;
                while(k7 + 24 < j * 8)  {
                    int l39 = Class15.method358(abyte0, k7, 11);
                    k7 += 11;
                    int l41 = Class15.method358(abyte0, k7, 5);
                    k7 += 5;
                    if(l41 > 15)
                        l41 -= 32;
                    int j43 = Class15.method358(abyte0, k7, 5);
                    k7 += 5;
                    if(j43 > 15)
                        j43 -= 32;
                    int i14 = Class15.method358(abyte0, k7, 4);
                    k7 += 4;
                    int i44 = Class15.method358(abyte0, k7, 1);
                    k7++;
                    int i23 = (anInt889 + l41) * anInt729 + 64;
                    int i26 = (anInt890 + j43) * anInt729 + 64;
                    method63(l39, i23, i26, i14);
                    if(i44 == 0)
                        anIntArray876[i37++] = l39;
                }
                if(i37 > 0) {
                    super.aClass14_Sub1_620.method348(83);
                    super.aClass14_Sub1_620.method336(i37);
                    for(int i40 = 0; i40 < i37; i40++) {
                        Class2 class2_4 = aClass2Array713[anIntArray876[i40]];
                        super.aClass14_Sub1_620.method336(class2_4.anInt147);
                        super.aClass14_Sub1_620.method336(class2_4.anInt148);
                    }

                    super.aClass14_Sub1_620.method330();
                    i37 = 0;
                }
                return;
            }
            if(i == 109) {
                for(int l = 1; l < j;)
                    if(Class15.method352(abyte0[l]) == 255) {
                        int l7 = 0;
                        int j14 = anInt889 + abyte0[l + 1] >> 3;
                        int i19 = anInt890 + abyte0[l + 2] >> 3;
                        l += 3;
                        for(int j23 = 0; j23 < anInt895; j23++) {
                            int j26 = (anIntArray966[j23] >> 3) - j14;
                            int j29 = (anIntArray967[j23] >> 3) - i19;
                            if(j26 != 0 || j29 != 0) {
                                if(j23 != l7) {
                                    anIntArray966[l7] = anIntArray966[j23];
                                    anIntArray967[l7] = anIntArray967[j23];
                                    anIntArray968[l7] = anIntArray968[j23];
                                    anIntArray969[l7] = anIntArray969[j23];
                                }
                                l7++;
                            }
                        }

                        anInt895 = l7;
                    } else {
                        int i8 = Class15.method353(abyte0, l);
                        l += 2;
                        int k14 = anInt889 + abyte0[l++];
                        int j19 = anInt890 + abyte0[l++];
                        if((i8 & 0x8000) == 0) {
                            anIntArray966[anInt895] = k14;
                            anIntArray967[anInt895] = j19;
                            anIntArray968[anInt895] = i8;
                            anIntArray969[anInt895] = 0;
                            for(int k23 = 0; k23 < anInt981; k23++) {
                                if(anIntArray882[k23] != k14 || anIntArray883[k23] != j19)
                                    continue;
                                anIntArray969[anInt895] = Class1.anIntArray70[anIntArray884[k23]];
                                break;
                            }

                            anInt895++;
                        } else {
                            i8 &= 0x7fff;
                            int l23 = 0;
                            for(int k26 = 0; k26 < anInt895; k26++)
                                if(anIntArray966[k26] != k14 || anIntArray967[k26] != j19 || anIntArray968[k26] != i8) {
                                    if(k26 != l23) {
                                        anIntArray966[l23] = anIntArray966[k26];
                                        anIntArray967[l23] = anIntArray967[k26];
                                        anIntArray968[l23] = anIntArray968[k26];
                                        anIntArray969[l23] = anIntArray969[k26];
                                    }
                                    l23++;
                                } else {
                                    i8 = -123;
                                }

                            anInt895 = l23;
                        }
                    }

                return;
            }
            if(i == 27) {
                for(int i1 = 1; i1 < j;)
                    if(Class15.method352(abyte0[i1]) == 255) {
                        int j8 = 0;
                        int l14 = anInt889 + abyte0[i1 + 1] >> 3;
                        int k19 = anInt890 + abyte0[i1 + 2] >> 3;
                        i1 += 3;
                        for(int i24 = 0; i24 < anInt981; i24++) {
                            int l26 = (anIntArray882[i24] >> 3) - l14;
                            int k29 = (anIntArray883[i24] >> 3) - k19;
                            if(l26 != 0 || k29 != 0) {
                                if(i24 != j8) {
                                    aClass5Array805[j8] = aClass5Array805[i24];
                                    aClass5Array805[j8].anInt257 = j8;
                                    anIntArray882[j8] = anIntArray882[i24];
                                    anIntArray883[j8] = anIntArray883[i24];
                                    anIntArray884[j8] = anIntArray884[i24];
                                    anIntArray885[j8] = anIntArray885[i24];
                                }
                                j8++;
                            } else {
                                aClass10_939.method269(aClass5Array805[i24]);
                                aClass19_903.method403(anIntArray882[i24], anIntArray883[i24], anIntArray884[i24]);
                            }
                        }

                        anInt981 = j8;
                    } else {
                        int k8 = Class15.method353(abyte0, i1);
                        i1 += 2;
                        int i15 = anInt889 + abyte0[i1++];
                        int l19 = anInt890 + abyte0[i1++];
                        int j24 = 0;
                        for(int i27 = 0; i27 < anInt981; i27++)
                            if(anIntArray882[i27] != i15 || anIntArray883[i27] != l19) {
                                if(i27 != j24) {
                                    aClass5Array805[j24] = aClass5Array805[i27];
                                    aClass5Array805[j24].anInt257 = j24;
                                    anIntArray882[j24] = anIntArray882[i27];
                                    anIntArray883[j24] = anIntArray883[i27];
                                    anIntArray884[j24] = anIntArray884[i27];
                                    anIntArray885[j24] = anIntArray885[i27];
                                }
                                j24++;
                            } else {
                                aClass10_939.method269(aClass5Array805[i27]);
                                aClass19_903.method403(anIntArray882[i27], anIntArray883[i27], anIntArray884[i27]);
                            }

                        anInt981 = j24;
                        if(k8 != 60000) {
                            int l29 = aClass19_903.method422(i15, l19);
                            int i34;
                            int j37;
                            if(l29 == 0 || l29 == 4) {
                                i34 = Class1.anIntArray67[k8];
                                j37 = Class1.anIntArray68[k8];
                            } else {
                                j37 = Class1.anIntArray67[k8];
                                i34 = Class1.anIntArray68[k8];
                            }
                            int j40 = ((i15 + i15 + i34) * anInt729) / 2;
                            int i42 = ((l19 + l19 + j37) * anInt729) / 2;
                            int k43 = Class1.anIntArray66[k8];
                            Class5 class5_1 = aClass5Array777[k43].method203();
                            aClass10_939.method268(class5_1);
                            class5_1.anInt257 = anInt981;
                            class5_1.method188(0, l29 * 32, 0);
                            class5_1.method190(j40, -aClass19_903.method404(j40, i42), i42);
                            class5_1.method184(true, 48, 48, -50, -10, -50);
                            aClass19_903.method417(i15, l19, k8);
                            if(k8 == 74)
                                class5_1.method190(0, -480, 0);
                            anIntArray882[anInt981] = i15;
                            anIntArray883[anInt981] = l19;
                            anIntArray884[anInt981] = k8;
                            anIntArray885[anInt981] = l29;
                            aClass5Array805[anInt981++] = class5_1;
                        }
                    }

                return;
            }
            if(i == 114) {
                int j1 = 1;
                anInt692 = abyte0[j1++] & 0xff;
                for(int l8 = 0; l8 < anInt692; l8++) {
                    int j15 = Class15.method353(abyte0, j1);
                    j1 += 2;
                    anIntArray693[l8] = j15 & 0x7fff;
                    anIntArray695[l8] = j15 / 32768;
                    if(Class1.anIntArray73[j15 & 0x7fff] == 0) {
                        anIntArray694[l8] = Class15.method357(abyte0, j1);
                        if(anIntArray694[l8] >= 128)
                            j1 += 4;
                        else
                            j1++;
                    } else {
                        anIntArray694[l8] = 1;
                    }
                }

                return;
            }
            if(i == 53) {
                int k1 = Class15.method353(abyte0, 1);
                int i9 = 3;
                for(int k15 = 0; k15 < k1; k15++) {
                    int i20 = Class15.method353(abyte0, i9);
                    i9 += 2;
                    Class2 class2 = aClass2Array713[i20];
                    byte byte6 = abyte0[i9];
                    i9++;
                    if(byte6 == 0) {
                        int i30 = Class15.method353(abyte0, i9);
                        i9 += 2;
                        if(class2 != null) {
                            class2.anInt163 = 150;
                            class2.anInt162 = i30;
                        }
                    } else
                    if(byte6 == 1) {
                        byte byte7 = abyte0[i9];
                        i9++;
                        if(class2 != null) {
                            String s2 = Class16.method373(Class17.method398(abyte0, i9, byte7));
                            boolean flag3 = false;
                            for(int k40 = 0; k40 < super.anInt627; k40++)
                                if(super.aLongArray628[k40] == class2.aLong145)
                                    flag3 = true;

                            if(!flag3) {
                                class2.anInt161 = 150;
                                class2.aString160 = s2;
                                method97(class2.aString146 + ": " + class2.aString160, 2);
                            }
                        }
                        i9 += byte7;
                    } else
                    if(byte6 == 2) {
                        int j30 = Class15.method352(abyte0[i9]);
                        i9++;
                        int j34 = Class15.method352(abyte0[i9]);
                        i9++;
                        int k37 = Class15.method352(abyte0[i9]);
                        i9++;
                        if(class2 != null) {
                            class2.anInt164 = j30;
                            class2.anInt165 = j34;
                            class2.anInt166 = k37;
                            class2.anInt167 = 200;
                            if(class2 == aClass2_888) {
                                anIntArray748[3] = j34;
                                anIntArray838[3] = k37;
                                aBoolean817 = false;
                                aBoolean743 = false;
                            }
                        }
                    } else
                    if(byte6 == 3) {
                        int k30 = Class15.method353(abyte0, i9);
                        i9 += 2;
                        int k34 = Class15.method353(abyte0, i9);
                        i9 += 2;
                        if(class2 != null) {
                            class2.anInt173 = k30;
                            class2.anInt175 = k34;
                            class2.anInt174 = -1;
                            class2.anInt176 = anInt953;
                        }
                    } else
                    if(byte6 == 4) {
                        int l30 = Class15.method353(abyte0, i9);
                        i9 += 2;
                        int l34 = Class15.method353(abyte0, i9);
                        i9 += 2;
                        if(class2 != null) {
                            class2.anInt173 = l30;
                            class2.anInt174 = l34;
                            class2.anInt175 = -1;
                            class2.anInt176 = anInt953;
                        }
                    } else
                    if(byte6 == 5) {
                        if(class2 != null) {
                            class2.anInt148 = Class15.method353(abyte0, i9);
                            i9 += 2;
                            class2.aLong145 = Class15.method355(abyte0, i9);
                            i9 += 8;
                            class2.aString146 = Class15.method362(class2.aLong145);
                            int i31 = Class15.method352(abyte0[i9]);
                            i9++;
                            for(int i35 = 0; i35 < i31; i35++) {
                                class2.anIntArray159[i35] = Class15.method352(abyte0[i9]);
                                i9++;
                            }

                            for(int l37 = i31; l37 < 12; l37++)
                                class2.anIntArray159[l37] = 0;

                            class2.anInt169 = abyte0[i9++] & 0xff;
                            class2.anInt170 = abyte0[i9++] & 0xff;
                            class2.anInt171 = abyte0[i9++] & 0xff;
                            class2.anInt172 = abyte0[i9++] & 0xff;
                            class2.anInt168 = abyte0[i9++] & 0xff;
                            class2.anInt179 = abyte0[i9++] & 0xff;
                        } else {
                            i9 += 14;
                            int j31 = Class15.method352(abyte0[i9]);
                            i9 += j31 + 1;
                        }
                    } else
                    if(byte6 == 6) {
                        byte byte8 = abyte0[i9];
                        i9++;
                        if(class2 != null) {
                            String s3 = Class17.method398(abyte0, i9, byte8);
                            class2.anInt161 = 150;
                            class2.aString160 = s3;
                            if(class2 == aClass2_888)
                                method97(class2.aString146 + ": " + class2.aString160, 5);
                        }
                        i9 += byte8;
                    }
                }

                return;
            }
            if(i == 95) {
                for(int l1 = 1; l1 < j;)
                    if(Class15.method352(abyte0[l1]) == 255) {
                        int j9 = 0;
                        int l15 = anInt889 + abyte0[l1 + 1] >> 3;
                        int j20 = anInt890 + abyte0[l1 + 2] >> 3;
                        l1 += 3;
                        for(int k24 = 0; k24 < anInt959; k24++) {
                            int j27 = (anIntArray947[k24] >> 3) - l15;
                            int k31 = (anIntArray948[k24] >> 3) - j20;
                            if(j27 != 0 || k31 != 0) {
                                if(k24 != j9) {
                                    aClass5Array700[j9] = aClass5Array700[k24];
                                    aClass5Array700[j9].anInt257 = j9 + 10000;
                                    anIntArray947[j9] = anIntArray947[k24];
                                    anIntArray948[j9] = anIntArray948[k24];
                                    anIntArray960[j9] = anIntArray960[k24];
                                    anIntArray961[j9] = anIntArray961[k24];
                                }
                                j9++;
                            } else {
                                aClass10_939.method269(aClass5Array700[k24]);
                                aClass19_903.method419(anIntArray947[k24], anIntArray948[k24], anIntArray960[k24], anIntArray961[k24]);
                            }
                        }

                        anInt959 = j9;
                    } else {
                        int k9 = Class15.method353(abyte0, l1);
                        l1 += 2;
                        int i16 = anInt889 + abyte0[l1++];
                        int k20 = anInt890 + abyte0[l1++];
                        byte byte5 = abyte0[l1++];
                        int k27 = 0;
                        for(int l31 = 0; l31 < anInt959; l31++)
                            if(anIntArray947[l31] != i16 || anIntArray948[l31] != k20 || anIntArray960[l31] != byte5) {
                                if(l31 != k27) {
                                    aClass5Array700[k27] = aClass5Array700[l31];
                                    aClass5Array700[k27].anInt257 = k27 + 10000;
                                    anIntArray947[k27] = anIntArray947[l31];
                                    anIntArray948[k27] = anIntArray948[l31];
                                    anIntArray960[k27] = anIntArray960[l31];
                                    anIntArray961[k27] = anIntArray961[l31];
                                }
                                k27++;
                            } else {
                                aClass10_939.method269(aClass5Array700[l31]);
                                aClass19_903.method419(anIntArray947[l31], anIntArray948[l31], anIntArray960[l31], anIntArray961[l31]);
                            }

                        anInt959 = k27;
                        if(k9 != 65535) {
                            aClass19_903.method413(i16, k20, byte5, k9);
                            Class5 class5 = method72(i16, k20, byte5, k9, anInt959);
                            aClass5Array700[anInt959] = class5;
                            anIntArray947[anInt959] = i16;
                            anIntArray948[anInt959] = k20;
                            anIntArray961[anInt959] = k9;
                            anIntArray960[anInt959++] = byte5;
                        }
                    }

                return;
            }
            if(i == 77) {
                anInt718 = anInt717;
                anInt717 = 0;
                for(int i2 = 0; i2 < anInt718; i2++)
                    aClass2Array670[i2] = aClass2Array705[i2];

                int l9 = 8;
                int j16 = Class15.method358(abyte0, l9, 8);
                l9 += 8;
                for(int l20 = 0; l20 < j16; l20++) {
                    Class2 class2_1 = aClass2Array670[l20];
                    int l27 = Class15.method358(abyte0, l9, 1);
                    l9++;
                    if(l27 != 0) {
                        int i32 = Class15.method358(abyte0, l9, 1);
                        l9++;
                        if(i32 == 0) {
                            int j35 = Class15.method358(abyte0, l9, 3);
                            l9 += 3;
                            int i38 = class2_1.anInt156;
                            int l40 = class2_1.anIntArray157[i38];
                            int j42 = class2_1.anIntArray158[i38];
                            if(j35 == 2 || j35 == 1 || j35 == 3)
                                l40 += anInt729;
                            if(j35 == 6 || j35 == 5 || j35 == 7)
                                l40 -= anInt729;
                            if(j35 == 4 || j35 == 3 || j35 == 5)
                                j42 += anInt729;
                            if(j35 == 0 || j35 == 1 || j35 == 7)
                                j42 -= anInt729;
                            class2_1.anInt154 = j35;
                            class2_1.anInt156 = i38 = (i38 + 1) % 10;
                            class2_1.anIntArray157[i38] = l40;
                            class2_1.anIntArray158[i38] = j42;
                        } else {
                            int k35 = Class15.method358(abyte0, l9, 4);
                            if((k35 & 0xc) == 12) {
                                l9 += 2;
                                continue;
                            }
                            class2_1.anInt154 = Class15.method358(abyte0, l9, 4);
                            l9 += 4;
                        }
                    }
                    aClass2Array705[anInt717++] = class2_1;
                }

                while(l9 + 34 < j * 8)  {
                    int l24 = Class15.method358(abyte0, l9, 12);
                    l9 += 12;
                    int i28 = Class15.method358(abyte0, l9, 5);
                    l9 += 5;
                    if(i28 > 15)
                        i28 -= 32;
                    int j32 = Class15.method358(abyte0, l9, 5);
                    l9 += 5;
                    if(j32 > 15)
                        j32 -= 32;
                    int l35 = Class15.method358(abyte0, l9, 4);
                    l9 += 4;
                    int j38 = (anInt889 + i28) * anInt729 + 64;
                    int i41 = (anInt890 + j32) * anInt729 + 64;
                    int k42 = Class15.method358(abyte0, l9, 10);
                    l9 += 10;
                    if(k42 >= Class1.anInt57)
                        k42 = 24;
                    method107(l24, j38, i41, l35, k42);
                }
                return;
            }
            if(i == 190) {
                int j2 = Class15.method353(abyte0, 1);
                int i10 = 3;
                for(int k16 = 0; k16 < j2; k16++) {
                    int i21 = Class15.method353(abyte0, i10);
                    i10 += 2;
                    Class2 class2_2 = aClass2Array930[i21];
                    int j28 = Class15.method352(abyte0[i10]);
                    i10++;
                    if(j28 == 1) {
                        int k32 = Class15.method353(abyte0, i10);
                        i10 += 2;
                        byte byte9 = abyte0[i10];
                        i10++;
                        if(class2_2 != null) {
                            String s4 = Class17.method398(abyte0, i10, byte9);
                            class2_2.anInt161 = 150;
                            class2_2.aString160 = s4;
                            if(k32 == aClass2_888.anInt147)
                                method97("@yel@" + Class1.aStringArray123[class2_2.anInt151] + ": " + class2_2.aString160, 5);
                        }
                        i10 += byte9;
                    } else
                    if(j28 == 2) {
                        int l32 = Class15.method352(abyte0[i10]);
                        i10++;
                        int i36 = Class15.method352(abyte0[i10]);
                        i10++;
                        int k38 = Class15.method352(abyte0[i10]);
                        i10++;
                        if(class2_2 != null) {
                            class2_2.anInt164 = l32;
                            class2_2.anInt165 = i36;
                            class2_2.anInt166 = k38;
                            class2_2.anInt167 = 200;
                        }
                    }
                }

                return;
            }
            if(i == 223) {
                aBoolean727 = true;
                int k2 = Class15.method352(abyte0[1]);
                anInt881 = k2;
                int j10 = 2;
                for(int l16 = 0; l16 < k2; l16++) {
                    int j21 = Class15.method352(abyte0[j10]);
                    j10++;
                    aStringArray667[l16] = new String(abyte0, j10, j21);
                    j10 += j21;
                }

                return;
            }
            if(i == 127) {
                aBoolean727 = false;
                return;
            }
            if(i == 131) {
                aBoolean917 = true;
                anInt891 = Class15.method353(abyte0, 1);
                anInt719 = Class15.method353(abyte0, 3);
                anInt720 = Class15.method353(abyte0, 5);
                anInt751 = Class15.method353(abyte0, 7);
                anInt721 = Class15.method353(abyte0, 9);
                anInt720 -= anInt751 * anInt721;
                return;
            }
            if(i == 180) {
                int l2 = 1;
                for(int k10 = 0; k10 < 18; k10++)
                    anIntArray748[k10] = Class15.method352(abyte0[l2++]);

                for(int i17 = 0; i17 < 18; i17++)
                    anIntArray838[i17] = Class15.method352(abyte0[l2++]);

                for(int k21 = 0; k21 < 18; k21++) {
                    anIntArray928[k21] = Class15.method354(abyte0, l2);
                    l2 += 4;
                }

                anInt934 = Class15.method352(abyte0[l2++]);
                return;
            }
            if(i == 177) {
                for(int i3 = 0; i3 < 5; i3++)
                    anIntArray706[i3] = Class15.method352(abyte0[1 + i3]);

                return;
            }
            if(i == 165) {
                anInt975 = 250;
                return;
            }
            if(i == 115) {
                int j3 = (j - 1) / 4;
                for(int l10 = 0; l10 < j3; l10++) {
                    int j17 = anInt889 + Class15.method356(abyte0, 1 + l10 * 4) >> 3;
                    int l21 = anInt890 + Class15.method356(abyte0, 3 + l10 * 4) >> 3;
                    int i25 = 0;
                    for(int k28 = 0; k28 < anInt895; k28++) {
                        int i33 = (anIntArray966[k28] >> 3) - j17;
                        int j36 = (anIntArray967[k28] >> 3) - l21;
                        if(i33 != 0 || j36 != 0) {
                            if(k28 != i25) {
                                anIntArray966[i25] = anIntArray966[k28];
                                anIntArray967[i25] = anIntArray967[k28];
                                anIntArray968[i25] = anIntArray968[k28];
                                anIntArray969[i25] = anIntArray969[k28];
                            }
                            i25++;
                        }
                    }

                    anInt895 = i25;
                    i25 = 0;
                    for(int j33 = 0; j33 < anInt981; j33++) {
                        int k36 = (anIntArray882[j33] >> 3) - j17;
                        int l38 = (anIntArray883[j33] >> 3) - l21;
                        if(k36 != 0 || l38 != 0) {
                            if(j33 != i25) {
                                aClass5Array805[i25] = aClass5Array805[j33];
                                aClass5Array805[i25].anInt257 = i25;
                                anIntArray882[i25] = anIntArray882[j33];
                                anIntArray883[i25] = anIntArray883[j33];
                                anIntArray884[i25] = anIntArray884[j33];
                                anIntArray885[i25] = anIntArray885[j33];
                            }
                            i25++;
                        } else {
                            aClass10_939.method269(aClass5Array805[j33]);
                            aClass19_903.method403(anIntArray882[j33], anIntArray883[j33], anIntArray884[j33]);
                        }
                    }

                    anInt981 = i25;
                    i25 = 0;
                    for(int l36 = 0; l36 < anInt959; l36++) {
                        int i39 = (anIntArray947[l36] >> 3) - j17;
                        int j41 = (anIntArray948[l36] >> 3) - l21;
                        if(i39 != 0 || j41 != 0) {
                            if(l36 != i25) {
                                aClass5Array700[i25] = aClass5Array700[l36];
                                aClass5Array700[i25].anInt257 = i25 + 10000;
                                anIntArray947[i25] = anIntArray947[l36];
                                anIntArray948[i25] = anIntArray948[l36];
                                anIntArray960[i25] = anIntArray960[l36];
                                anIntArray961[i25] = anIntArray961[l36];
                            }
                            i25++;
                        } else {
                            aClass10_939.method269(aClass5Array700[l36]);
                            aClass19_903.method419(anIntArray947[l36], anIntArray948[l36], anIntArray960[l36], anIntArray961[l36]);
                        }
                    }

                    anInt959 = i25;
                }

                return;
            }
            if(i == 207) {
                aBoolean769 = true;
                return;
            }
            if(i == 4) {
                int k3 = Class15.method353(abyte0, 1);
                if(aClass2Array713[k3] != null)
                    aString994 = aClass2Array713[k3].aString146;
                aBoolean974 = true;
                aBoolean711 = false;
                aBoolean712 = false;
                anInt982 = 0;
                anInt922 = 0;
                return;
            }
            if(i == 187) {
                aBoolean974 = false;
                aBoolean900 = false;
                return;
            }
            if(i == 250) {
                anInt922 = abyte0[1] & 0xff;
                int l3 = 2;
                for(int i11 = 0; i11 < anInt922; i11++) {
                    anIntArray923[i11] = Class15.method353(abyte0, l3);
                    l3 += 2;
                    anIntArray924[i11] = Class15.method354(abyte0, l3);
                    l3 += 4;
                }

                aBoolean711 = false;
                aBoolean712 = false;
                return;
            }
            if(i == 92) {
                byte byte0 = abyte0[1];
                if(byte0 == 1) {
                    aBoolean711 = true;
                    return;
                } else {
                    aBoolean711 = false;
                    return;
                }
            }
            if(i == 253) {
                aBoolean940 = true;
                int i4 = 1;
                int j11 = abyte0[i4++] & 0xff;
                byte byte4 = abyte0[i4++];
                anInt956 = abyte0[i4++] & 0xff;
                anInt957 = abyte0[i4++] & 0xff;
                for(int i22 = 0; i22 < 40; i22++)
                    anIntArray849[i22] = -1;

                for(int j25 = 0; j25 < j11; j25++) {
                    anIntArray849[j25] = Class15.method353(abyte0, i4);
                    i4 += 2;
                    anIntArray850[j25] = Class15.method353(abyte0, i4);
                    i4 += 2;
                    anIntArray851[j25] = abyte0[i4++];
                }

                if(byte4 == 1) {
                    int l28 = 39;
                    for(int k33 = 0; k33 < anInt692; k33++) {
                        if(l28 < j11)
                            break;
                        boolean flag2 = false;
                        for(int j39 = 0; j39 < 40; j39++) {
                            if(anIntArray849[j39] != anIntArray693[k33])
                                continue;
                            flag2 = true;
                            break;
                        }

                        if(anIntArray693[k33] == 10)
                            flag2 = true;
                        if(!flag2) {
                            anIntArray849[l28] = anIntArray693[k33] & 0x7fff;
                            anIntArray850[l28] = 0;
                            anIntArray851[l28] = 0;
                            l28--;
                        }
                    }

                }
                if(anInt970 >= 0 && anInt970 < 40 && anIntArray849[anInt970] != anInt971) {
                    anInt970 = -1;
                    anInt971 = -2;
                }
                return;
            }
            if(i == 220) {
                aBoolean940 = false;
                return;
            }
            if(i == 18) {
                byte byte1 = abyte0[1];
                if(byte1 == 1) {
                    aBoolean712 = true;
                    return;
                } else {
                    aBoolean712 = false;
                    return;
                }
            }
            if(i == 152) {
                aBoolean666 = Class15.method352(abyte0[1]) == 1;
                aBoolean785 = Class15.method352(abyte0[2]) == 1;
                aBoolean950 = Class15.method352(abyte0[3]) == 1;
                return;
            }
            if(i == 209) {
                for(int j4 = 0; j4 < j - 1; j4++) {
                    boolean flag = abyte0[j4 + 1] == 1;
                    if(!aBooleanArray710[j4] && flag)
                        method102("prayeron");
                    if(aBooleanArray710[j4] && !flag)
                        method102("prayeroff");
                    aBooleanArray710[j4] = flag;
                }

                return;
            }
            if(i == 224) {
                for(int k4 = 0; k4 < 50; k4++)
                    aBooleanArray808[k4] = abyte0[k4 + 1] == 1;

                return;
            }
            if(i == 93) {
                aBoolean699 = true;
                int l4 = 1;
                anInt770 = abyte0[l4++] & 0xff;
                anInt724 = abyte0[l4++] & 0xff;
                for(int k11 = 0; k11 < anInt770; k11++) {
                    anIntArray870[k11] = Class15.method353(abyte0, l4);
                    l4 += 2;
                    anIntArray871[k11] = Class15.method357(abyte0, l4);
                    if(anIntArray871[k11] >= 128)
                        l4 += 4;
                    else
                        l4++;
                }

                method94();
                return;
            }
            if(i == 171) {
                aBoolean699 = false;
                return;
            }
            if(i == 211) {
                int i5 = abyte0[1] & 0xff;
                anIntArray928[i5] = Class15.method354(abyte0, 2);
                return;
            }
            if(i == 229) {
                int j5 = Class15.method353(abyte0, 1);
                if(aClass2Array713[j5] != null)
                    aString686 = aClass2Array713[j5].aString146;
                aBoolean932 = true;
                anInt663 = 0;
                anInt764 = 0;
                aBoolean677 = false;
                aBoolean678 = false;
                aBoolean786 = false;
                aBoolean787 = false;
                aBoolean788 = false;
                aBoolean789 = false;
                return;
            }
            if(i == 160) {
                aBoolean932 = false;
                aBoolean944 = false;
                return;
            }
            if(i == 251) {
                aBoolean900 = true;
                aBoolean901 = false;
                aBoolean974 = false;
                int k5 = 1;
                aLong973 = Class15.method355(abyte0, k5);
                k5 += 8;
                anInt682 = abyte0[k5++] & 0xff;
                for(int l11 = 0; l11 < anInt682; l11++) {
                    anIntArray683[l11] = Class15.method353(abyte0, k5);
                    k5 += 2;
                    anIntArray684[l11] = Class15.method354(abyte0, k5);
                    k5 += 4;
                }

                anInt679 = abyte0[k5++] & 0xff;
                for(int k17 = 0; k17 < anInt679; k17++) {
                    anIntArray680[k17] = Class15.method353(abyte0, k5);
                    k5 += 2;
                    anIntArray681[k17] = Class15.method354(abyte0, k5);
                    k5 += 4;
                }

                return;
            }
            if(i == 63) {
                anInt764 = abyte0[1] & 0xff;
                int l5 = 2;
                for(int i12 = 0; i12 < anInt764; i12++) {
                    anIntArray765[i12] = Class15.method353(abyte0, l5);
                    l5 += 2;
                    anIntArray766[i12] = Class15.method354(abyte0, l5);
                    l5 += 4;
                }

                aBoolean677 = false;
                aBoolean678 = false;
                return;
            }
            if(i == 198) {
                if(abyte0[1] == 1)
                    aBoolean786 = true;
                else
                    aBoolean786 = false;
                if(abyte0[2] == 1)
                    aBoolean787 = true;
                else
                    aBoolean787 = false;
                if(abyte0[3] == 1)
                    aBoolean788 = true;
                else
                    aBoolean788 = false;
                if(abyte0[4] == 1)
                    aBoolean789 = true;
                else
                    aBoolean789 = false;
                aBoolean677 = false;
                aBoolean678 = false;
                return;
            }
            if(i == 139) {
                int i6 = 1;
                int j12 = abyte0[i6++] & 0xff;
                int l17 = Class15.method353(abyte0, i6);
                i6 += 2;
                int j22 = Class15.method357(abyte0, i6);
                if(j22 >= 128)
                    i6 += 4;
                else
                    i6++;
                if(j22 == 0) {
                    anInt770--;
                    for(int k25 = j12; k25 < anInt770; k25++) {
                        anIntArray870[k25] = anIntArray870[k25 + 1];
                        anIntArray871[k25] = anIntArray871[k25 + 1];
                    }

                } else {
                    anIntArray870[j12] = l17;
                    anIntArray871[j12] = j22;
                    if(j12 >= anInt770)
                        anInt770 = j12 + 1;
                }
                method94();
                return;
            }
            if(i == 228) {
                int j6 = 1;
                int k12 = 1;
                int i18 = abyte0[j6++] & 0xff;
                int k22 = Class15.method353(abyte0, j6);
                j6 += 2;
                if(Class1.anIntArray73[k22 & 0x7fff] == 0) {
                    k12 = Class15.method357(abyte0, j6);
                    if(k12 >= 128)
                        j6 += 4;
                    else
                        j6++;
                }
                anIntArray693[i18] = k22 & 0x7fff;
                anIntArray695[i18] = k22 / 32768;
                anIntArray694[i18] = k12;
                if(i18 >= anInt692)
                    anInt692 = i18 + 1;
                return;
            }
            if(i == 191) {
                int k6 = abyte0[1] & 0xff;
                anInt692--;
                for(int l12 = k6; l12 < anInt692; l12++) {
                    anIntArray693[l12] = anIntArray693[l12 + 1];
                    anIntArray694[l12] = anIntArray694[l12 + 1];
                    anIntArray695[l12] = anIntArray695[l12 + 1];
                }

                return;
            }
            if(i == 208) {
                int l6 = 1;
                int i13 = abyte0[l6++] & 0xff;
                anIntArray748[i13] = Class15.method352(abyte0[l6++]);
                anIntArray838[i13] = Class15.method352(abyte0[l6++]);
                anIntArray928[i13] = Class15.method354(abyte0, l6);
                l6 += 4;
                return;
            }
            if(i == 65) {
                byte byte2 = abyte0[1];
                if(byte2 == 1) {
                    aBoolean677 = true;
                    return;
                } else {
                    aBoolean677 = false;
                    return;
                }
            }
            if(i == 197) {
                byte byte3 = abyte0[1];
                if(byte3 == 1) {
                    aBoolean678 = true;
                    return;
                } else {
                    aBoolean678 = false;
                    return;
                }
            }
            if(i == 147) {
                aBoolean944 = true;
                aBoolean945 = false;
                aBoolean932 = false;
                int i7 = 1;
                aLong993 = Class15.method355(abyte0, i7);
                i7 += 8;
                anInt793 = abyte0[i7++] & 0xff;
                for(int j13 = 0; j13 < anInt793; j13++) {
                    anIntArray794[j13] = Class15.method353(abyte0, i7);
                    i7 += 2;
                    anIntArray795[j13] = Class15.method354(abyte0, i7);
                    i7 += 4;
                }

                anInt872 = abyte0[i7++] & 0xff;
                for(int j18 = 0; j18 < anInt872; j18++) {
                    anIntArray873[j18] = Class15.method353(abyte0, i7);
                    i7 += 2;
                    anIntArray874[j18] = Class15.method354(abyte0, i7);
                    i7 += 4;
                }

                anInt739 = abyte0[i7++] & 0xff;
                anInt740 = abyte0[i7++] & 0xff;
                anInt741 = abyte0[i7++] & 0xff;
                anInt742 = abyte0[i7++] & 0xff;
                return;
            }
            if(i == 11) {
                String s = new String(abyte0, 1, j - 1);
                method102(s);
                return;
            }
            if(i == 23) {
                if(anInt902 < 50) {
                    int j7 = abyte0[1] & 0xff;
                    int k13 = abyte0[2] + anInt889;
                    int k18 = abyte0[3] + anInt890;
                    anIntArray792[anInt902] = j7;
                    anIntArray933[anInt902] = 0;
                    anIntArray954[anInt902] = k13;
                    anIntArray767[anInt902] = k18;
                    anInt902++;
                }
                return;
            }
            if(i == 248) {
                if(!aBoolean745) {
                    anInt687 = Class15.method354(abyte0, 1);
                    anInt662 = Class15.method353(abyte0, 5);
                    anInt791 = abyte0[7] & 0xff;
                    anInt875 = Class15.method353(abyte0, 8);
                    aBoolean817 = true;
                    aBoolean745 = true;
                    aString746 = null;
                }
                return;
            }
            if(i == 148) {
                aString685 = new String(abyte0, 1, j - 1);
                aBoolean743 = true;
                aBoolean905 = false;
                return;
            }
            if(i == 64) {
                aString685 = new String(abyte0, 1, j - 1);
                aBoolean743 = true;
                aBoolean905 = true;
                return;
            }
            if(i == 126) {
                anInt978 = Class15.method353(abyte0, 1);
                return;
            }
            if(i == 219) {
                if(!aBoolean776)
                    anInt979 = anInt978;
                aBoolean776 = true;
                super.aString40 = "";
                super.aString41 = "";
                aClass6_Sub1_935.method225(anInt782 + 1, abyte0);
                aString899 = null;
                return;
            }
            if(i == 168) {
                anInt979 = Class15.method353(abyte0, 1);
                return;
            }
            if(i == 103) {
                aBoolean776 = false;
                return;
            }
            if(i == 15) {
                aString899 = "Incorrect - Please wait...";
                return;
            }
            if(i == 172) {
                anInt807 = Class15.method353(abyte0, 1) * 32;
                return;
            }
        }
        catch(RuntimeException runtimeexception) {
            if(anInt669 < 3) {
                super.aClass14_Sub1_620.method348(156);
                super.aClass14_Sub1_620.method346(runtimeexception.toString());
                super.aClass14_Sub1_620.method330();
                super.aClass14_Sub1_620.method348(156);
                super.aClass14_Sub1_620.method346("p-type:" + i + " p-size:" + j);
                super.aClass14_Sub1_620.method330();
                super.aClass14_Sub1_620.method348(156);
                super.aClass14_Sub1_620.method346("rx:" + anInt889 + " ry:" + anInt890 + " num3l:" + anInt981);
                super.aClass14_Sub1_620.method330();
                String s1 = "";
                for(int l18 = 0; l18 < 80 && l18 < j; l18++)
                    s1 = s1 + abyte0[l18] + " ";

                super.aClass14_Sub1_620.method348(156);
                super.aClass14_Sub1_620.method346(s1);
                super.aClass14_Sub1_620.method330();
                anInt669++;
            }
        }
    }

    public void method101() {
        byte abyte0[] = null;
        byte abyte1[] = null;
        abyte0 = method18("entity" + Class18.anInt579 + ".jag", "people and monsters", 30);
        if(abyte0 == null) {
            aBoolean937 = true;
            return;
        }
        abyte1 = Class15.method365("index.dat", 0, abyte0);
        byte abyte2[] = null;
        byte abyte3[] = null;
        if(aBoolean867) {
            abyte2 = method18("entity" + Class18.anInt579 + ".mem", "member graphics", 45);
            if(abyte2 == null) {
                aBoolean937 = true;
                return;
            }
            abyte3 = Class15.method365("index.dat", 0, abyte2);
        }
        int i = 0;
        anInt847 = 0;
        anInt848 = anInt847;
label0:
        for(int j = 0; j < Class1.anInt103; j++) {
            String s = Class1.aStringArray54[j];
            for(int k = 0; k < j; k++) {
                if(!Class1.aStringArray54[k].equalsIgnoreCase(s))
                    continue;
                Class1.anIntArray93[j] = Class1.anIntArray93[k];
                continue label0;
            }

            byte abyte7[] = Class15.method365(s + ".dat", 0, abyte0);
            byte abyte4[] = abyte1;
            if(abyte7 == null && aBoolean867) {
                abyte7 = Class15.method365(s + ".dat", 0, abyte2);
                abyte4 = abyte3;
            }
            if(abyte7 != null) {
                aClass6_Sub1_935.method224(anInt848, abyte7, abyte4, 15);
                i += 15;
                if(Class1.anIntArray91[j] == 1) {
                    byte abyte8[] = Class15.method365(s + "a.dat", 0, abyte0);
                    byte abyte5[] = abyte1;
                    if(abyte8 == null && aBoolean867) {
                        abyte8 = Class15.method365(s + "a.dat", 0, abyte2);
                        abyte5 = abyte3;
                    }
                    aClass6_Sub1_935.method224(anInt848 + 15, abyte8, abyte5, 3);
                    i += 3;
                }
                if(Class1.anIntArray92[j] == 1) {
                    byte abyte9[] = Class15.method365(s + "f.dat", 0, abyte0);
                    byte abyte6[] = abyte1;
                    if(abyte9 == null && aBoolean867) {
                        abyte9 = Class15.method365(s + "f.dat", 0, abyte2);
                        abyte6 = abyte3;
                    }
                    aClass6_Sub1_935.method224(anInt848 + 18, abyte9, abyte6, 9);
                    i += 9;
                }
                if(Class1.anIntArray90[j] != 0) {
                    for(int l = anInt848; l < anInt848 + 27; l++)
                        aClass6_Sub1_935.method227(l);

                }
            }
            Class1.anIntArray93[j] = anInt848;
            anInt848 += 27;
        }

        System.out.println("Loaded: " + i + " frames of animation");
    }

    public void method23() {
        anInt807 = 0;
        if(anInt810 != 0) {
            method39();
            return;
        } else {
            super.method23();
            return;
        }
    }

    public void method102(String s) {
        if(anInputStream_Sub1_927 == null)
            return;
        if(aBoolean950) {
            return;
        } else {
            anInputStream_Sub1_927.method122(aByteArray977, Class15.method363(s + ".pcm", aByteArray977), Class15.method364(s + ".pcm", aByteArray977));
            return;
        }
    }

    public boolean method103(int i, int j, int k, int l, int i1, int j1, boolean flag, 
            boolean flag1) {
        int k1 = aClass19_903.method400(i, j, k, l, i1, j1, anIntArray755, anIntArray756, flag);
        if(k1 == -1)
            if(flag1) {
                k1 = 1;
                anIntArray755[0] = k;
                anIntArray756[0] = l;
            } else {
                return false;
            }
        k1--;
        i = anIntArray755[k1];
        j = anIntArray756[k1];
        k1--;
        if(flag1)
            super.aClass14_Sub1_620.method348(246);
        else
            super.aClass14_Sub1_620.method348(132);
        super.aClass14_Sub1_620.method336(i + anInt749);
        super.aClass14_Sub1_620.method336(j + anInt750);
        if(flag1 && k1 == -1 && (i + anInt749) % 5 == 0)
            k1 = 0;
        for(int l1 = k1; l1 >= 0 && l1 > k1 - 25; l1--) {
            super.aClass14_Sub1_620.method331(anIntArray755[l1] - i);
            super.aClass14_Sub1_620.method331(anIntArray756[l1] - j);
        }

        super.aClass14_Sub1_620.method330();
        anInt841 = -24;
        anInt842 = super.anInt33;
        anInt843 = super.anInt34;
        return true;
    }

    public boolean method104(int i, int j, int k, int l, int i1, int j1, boolean flag, 
            boolean flag1) {
        int k1 = aClass19_903.method400(i, j, k, l, i1, j1, anIntArray755, anIntArray756, flag);
        if(k1 == -1)
            return false;
        k1--;
        i = anIntArray755[k1];
        j = anIntArray756[k1];
        k1--;
        if(flag1)
            super.aClass14_Sub1_620.method348(246);
        else
            super.aClass14_Sub1_620.method348(132);
        super.aClass14_Sub1_620.method336(i + anInt749);
        super.aClass14_Sub1_620.method336(j + anInt750);
        if(flag1 && k1 == -1 && (i + anInt749) % 5 == 0)
            k1 = 0;
        for(int l1 = k1; l1 >= 0 && l1 > k1 - 25; l1--) {
            super.aClass14_Sub1_620.method331(anIntArray755[l1] - i);
            super.aClass14_Sub1_620.method331(anIntArray756[l1] - j);
        }

        super.aClass14_Sub1_620.method330();
        anInt841 = -24;
        anInt842 = super.anInt33;
        anInt843 = super.anInt34;
        return true;
    }

    public Image createImage(int i, int j) {
        if(Applet_Sub1.aFrame_Sub1_7 != null)
            return Applet_Sub1.aFrame_Sub1_7.createImage(i, j);
        if(Class8.anApplet370 != null)
            return Class8.anApplet370.createImage(i, j);
        else
            return super.createImage(i, j);
    }

    public void method105() {
        byte byte0 = 22;
        byte byte1 = 36;
        aClass6_Sub1_935.method215(byte0, byte1, 468, 16, 192);
        int i = 0x989898;
        aClass6_Sub1_935.method213(byte0, byte1 + 16, 468, 246, i, 160);
        aClass6_Sub1_935.method254("Please confirm your trade with @yel@" + Class15.method362(aLong973), byte0 + 234, byte1 + 12, 1, 0xffffff);
        aClass6_Sub1_935.method254("You are about to give:", byte0 + 117, byte1 + 30, 1, 0xffff00);
        for(int j = 0; j < anInt679; j++) {
            String s = Class1.aStringArray112[anIntArray680[j]];
            if(Class1.anIntArray73[anIntArray680[j]] == 0)
                s = s + " x " + method74(anIntArray681[j]);
            aClass6_Sub1_935.method254(s, byte0 + 117, byte1 + 42 + j * 12, 1, 0xffffff);
        }

        if(anInt679 == 0)
            aClass6_Sub1_935.method254("Nothing!", byte0 + 117, byte1 + 42, 1, 0xffffff);
        aClass6_Sub1_935.method254("In return you will receive:", byte0 + 351, byte1 + 30, 1, 0xffff00);
        for(int k = 0; k < anInt682; k++) {
            String s1 = Class1.aStringArray112[anIntArray683[k]];
            if(Class1.anIntArray73[anIntArray683[k]] == 0)
                s1 = s1 + " x " + method74(anIntArray684[k]);
            aClass6_Sub1_935.method254(s1, byte0 + 351, byte1 + 42 + k * 12, 1, 0xffffff);
        }

        if(anInt682 == 0)
            aClass6_Sub1_935.method254("Nothing!", byte0 + 351, byte1 + 42, 1, 0xffffff);
        aClass6_Sub1_935.method254("Are you sure you want to do this?", byte0 + 234, byte1 + 200, 4, 65535);
        aClass6_Sub1_935.method254("There is NO WAY to reverse a trade if you change your mind.", byte0 + 234, byte1 + 215, 1, 0xffffff);
        aClass6_Sub1_935.method254("Remember that not all players are trustworthy", byte0 + 234, byte1 + 230, 1, 0xffffff);
        if(!aBoolean901) {
            aClass6_Sub1_935.method230((byte0 + 118) - 35, byte1 + 238, anInt778 + 25);
            aClass6_Sub1_935.method230((byte0 + 352) - 35, byte1 + 238, anInt778 + 26);
        } else {
            aClass6_Sub1_935.method254("Waiting for other player...", byte0 + 234, byte1 + 250, 1, 0xffff00);
        }
        if(anInt912 == 1) {
            if(super.anInt33 < byte0 || super.anInt34 < byte1 || super.anInt33 > byte0 + 468 || super.anInt34 > byte1 + 262) {
                aBoolean900 = false;
                super.aClass14_Sub1_620.method348(216);
                super.aClass14_Sub1_620.method330();
            }
            if(super.anInt33 >= (byte0 + 118) - 35 && super.anInt33 <= byte0 + 118 + 70 && super.anInt34 >= byte1 + 238 && super.anInt34 <= byte1 + 238 + 21) {
                aBoolean901 = true;
                super.aClass14_Sub1_620.method348(53);
                super.aClass14_Sub1_620.method330();
            }
            if(super.anInt33 >= (byte0 + 352) - 35 && super.anInt33 <= byte0 + 353 + 70 && super.anInt34 >= byte1 + 238 && super.anInt34 <= byte1 + 238 + 21) {
                aBoolean900 = false;
                super.aClass14_Sub1_620.method348(216);
                super.aClass14_Sub1_620.method330();
            }
            anInt912 = 0;
        }
    }

    public void method106(int i, int j, int k, int l, boolean flag) {
        if(method104(i, j, k, l, k, l, false, flag)) {
            return;
        } else {
            method103(i, j, k, l, k, l, true, flag);
            return;
        }
    }

    public Class2 method107(int i, int j, int k, int l, int i1) {
        if(aClass2Array930[i] == null) {
            aClass2Array930[i] = new Class2();
            aClass2Array930[i].anInt147 = i;
        }
        Class2 class2 = aClass2Array930[i];
        boolean flag = false;
        for(int j1 = 0; j1 < anInt718; j1++) {
            if(aClass2Array670[j1].anInt147 != i)
                continue;
            flag = true;
            break;
        }

        if(flag) {
            class2.anInt151 = i1;
            class2.anInt154 = l;
            int k1 = class2.anInt156;
            if(j != class2.anIntArray157[k1] || k != class2.anIntArray158[k1]) {
                class2.anInt156 = k1 = (k1 + 1) % 10;
                class2.anIntArray157[k1] = j;
                class2.anIntArray158[k1] = k;
            }
        } else {
            class2.anInt147 = i;
            class2.anInt155 = 0;
            class2.anInt156 = 0;
            class2.anIntArray157[0] = class2.anInt149 = j;
            class2.anIntArray158[0] = class2.anInt150 = k;
            class2.anInt151 = i1;
            class2.anInt154 = class2.anInt153 = l;
            class2.anInt152 = 0;
        }
        aClass2Array705[anInt717++] = class2;
        return class2;
    }

    public void method108() {
        if(anInt912 != 0 && anInt894 == 0)
            anInt894 = 1;
        if(anInt894 > 0) {
            int i = super.anInt33 - 22;
            int j = super.anInt34 - 36;
            if(i >= 0 && j >= 0 && i < 468 && j < 262) {
                if(i > 216 && j > 30 && i < 462 && j < 235) {
                    int k = (i - 217) / 49 + ((j - 31) / 34) * 5;
                    if(k >= 0 && k < anInt692) {
                        boolean flag1 = false;
                        int l1 = 0;
                        int k2 = anIntArray693[k];
                        for(int k3 = 0; k3 < anInt663; k3++)
                            if(anIntArray664[k3] == k2)
                                if(Class1.anIntArray73[k2] == 0) {
                                    for(int i4 = 0; i4 < anInt894; i4++) {
                                        if(anIntArray665[k3] < anIntArray694[k])
                                            anIntArray665[k3]++;
                                        flag1 = true;
                                    }

                                } else {
                                    l1++;
                                }

                        if(method47(k2) <= l1)
                            flag1 = true;
                        if(Class1.anIntArray77[k2] == 1) {
                            method97("This object cannot be added to a duel offer", 3);
                            flag1 = true;
                        }
                        if(!flag1 && anInt663 < 8) {
                            anIntArray664[anInt663] = k2;
                            anIntArray665[anInt663] = 1;
                            anInt663++;
                            flag1 = true;
                        }
                        if(flag1) {
                            super.aClass14_Sub1_620.method348(123);
                            super.aClass14_Sub1_620.method331(anInt663);
                            for(int j4 = 0; j4 < anInt663; j4++) {
                                super.aClass14_Sub1_620.method336(anIntArray664[j4]);
                                super.aClass14_Sub1_620.method334(anIntArray665[j4]);
                            }

                            super.aClass14_Sub1_620.method330();
                            aBoolean677 = false;
                            aBoolean678 = false;
                        }
                    }
                }
                if(i > 8 && j > 30 && i < 205 && j < 129) {
                    int l = (i - 9) / 49 + ((j - 31) / 34) * 4;
                    if(l >= 0 && l < anInt663) {
                        int j1 = anIntArray664[l];
                        for(int i2 = 0; i2 < anInt894; i2++) {
                            if(Class1.anIntArray73[j1] == 0 && anIntArray665[l] > 1) {
                                anIntArray665[l]--;
                                continue;
                            }
                            anInt663--;
                            anInt893 = 0;
                            for(int l2 = l; l2 < anInt663; l2++) {
                                anIntArray664[l2] = anIntArray664[l2 + 1];
                                anIntArray665[l2] = anIntArray665[l2 + 1];
                            }

                            break;
                        }

                        super.aClass14_Sub1_620.method348(123);
                        super.aClass14_Sub1_620.method331(anInt663);
                        for(int i3 = 0; i3 < anInt663; i3++) {
                            super.aClass14_Sub1_620.method336(anIntArray664[i3]);
                            super.aClass14_Sub1_620.method334(anIntArray665[i3]);
                        }

                        super.aClass14_Sub1_620.method330();
                        aBoolean677 = false;
                        aBoolean678 = false;
                    }
                }
                boolean flag = false;
                if(i >= 93 && j >= 221 && i <= 104 && j <= 232) {
                    aBoolean786 = !aBoolean786;
                    flag = true;
                }
                if(i >= 93 && j >= 240 && i <= 104 && j <= 251) {
                    aBoolean787 = !aBoolean787;
                    flag = true;
                }
                if(i >= 191 && j >= 221 && i <= 202 && j <= 232) {
                    aBoolean788 = !aBoolean788;
                    flag = true;
                }
                if(i >= 191 && j >= 240 && i <= 202 && j <= 251) {
                    aBoolean789 = !aBoolean789;
                    flag = true;
                }
                if(flag) {
                    super.aClass14_Sub1_620.method348(225);
                    super.aClass14_Sub1_620.method331(aBoolean786 ? 1 : 0);
                    super.aClass14_Sub1_620.method331(aBoolean787 ? 1 : 0);
                    super.aClass14_Sub1_620.method331(aBoolean788 ? 1 : 0);
                    super.aClass14_Sub1_620.method331(aBoolean789 ? 1 : 0);
                    super.aClass14_Sub1_620.method330();
                    aBoolean677 = false;
                    aBoolean678 = false;
                }
                if(i >= 217 && j >= 238 && i <= 286 && j <= 259) {
                    aBoolean678 = true;
                    super.aClass14_Sub1_620.method348(252);
                    super.aClass14_Sub1_620.method330();
                }
                if(i >= 394 && j >= 238 && i < 463 && j < 259) {
                    aBoolean932 = false;
                    super.aClass14_Sub1_620.method348(35);
                    super.aClass14_Sub1_620.method330();
                }
            } else
            if(anInt912 != 0) {
                aBoolean932 = false;
                super.aClass14_Sub1_620.method348(35);
                super.aClass14_Sub1_620.method330();
            }
            anInt912 = 0;
            anInt894 = 0;
        }
        if(!aBoolean932)
            return;
        byte byte0 = 22;
        byte byte1 = 36;
        aClass6_Sub1_935.method215(byte0, byte1, 468, 12, 0xc90b1d);
        int i1 = 0x989898;
        aClass6_Sub1_935.method213(byte0, byte1 + 12, 468, 18, i1, 160);
        aClass6_Sub1_935.method213(byte0, byte1 + 30, 8, 248, i1, 160);
        aClass6_Sub1_935.method213(byte0 + 205, byte1 + 30, 11, 248, i1, 160);
        aClass6_Sub1_935.method213(byte0 + 462, byte1 + 30, 6, 248, i1, 160);
        aClass6_Sub1_935.method213(byte0 + 8, byte1 + 99, 197, 24, i1, 160);
        aClass6_Sub1_935.method213(byte0 + 8, byte1 + 192, 197, 23, i1, 160);
        aClass6_Sub1_935.method213(byte0 + 8, byte1 + 258, 197, 20, i1, 160);
        aClass6_Sub1_935.method213(byte0 + 216, byte1 + 235, 246, 43, i1, 160);
        int k1 = 0xd0d0d0;
        aClass6_Sub1_935.method213(byte0 + 8, byte1 + 30, 197, 69, k1, 160);
        aClass6_Sub1_935.method213(byte0 + 8, byte1 + 123, 197, 69, k1, 160);
        aClass6_Sub1_935.method213(byte0 + 8, byte1 + 215, 197, 43, k1, 160);
        aClass6_Sub1_935.method213(byte0 + 216, byte1 + 30, 246, 205, k1, 160);
        for(int j2 = 0; j2 < 3; j2++)
            aClass6_Sub1_935.method217(byte0 + 8, byte1 + 30 + j2 * 34, 197, 0);

        for(int j3 = 0; j3 < 3; j3++)
            aClass6_Sub1_935.method217(byte0 + 8, byte1 + 123 + j3 * 34, 197, 0);

        for(int l3 = 0; l3 < 7; l3++)
            aClass6_Sub1_935.method217(byte0 + 216, byte1 + 30 + l3 * 34, 246, 0);

        for(int k4 = 0; k4 < 6; k4++) {
            if(k4 < 5)
                aClass6_Sub1_935.method218(byte0 + 8 + k4 * 49, byte1 + 30, 69, 0);
            if(k4 < 5)
                aClass6_Sub1_935.method218(byte0 + 8 + k4 * 49, byte1 + 123, 69, 0);
            aClass6_Sub1_935.method218(byte0 + 216 + k4 * 49, byte1 + 30, 205, 0);
        }

        aClass6_Sub1_935.method217(byte0 + 8, byte1 + 215, 197, 0);
        aClass6_Sub1_935.method217(byte0 + 8, byte1 + 257, 197, 0);
        aClass6_Sub1_935.method218(byte0 + 8, byte1 + 215, 43, 0);
        aClass6_Sub1_935.method218(byte0 + 204, byte1 + 215, 43, 0);
        aClass6_Sub1_935.method256("Preparing to duel with: " + aString686, byte0 + 1, byte1 + 10, 1, 0xffffff);
        aClass6_Sub1_935.method256("Your Stake", byte0 + 9, byte1 + 27, 4, 0xffffff);
        aClass6_Sub1_935.method256("Opponent's Stake", byte0 + 9, byte1 + 120, 4, 0xffffff);
        aClass6_Sub1_935.method256("Duel Options", byte0 + 9, byte1 + 212, 4, 0xffffff);
        aClass6_Sub1_935.method256("Your Inventory", byte0 + 216, byte1 + 27, 4, 0xffffff);
        aClass6_Sub1_935.method256("No retreating", byte0 + 8 + 1, byte1 + 215 + 16, 3, 0xffff00);
        aClass6_Sub1_935.method256("No magic", byte0 + 8 + 1, byte1 + 215 + 35, 3, 0xffff00);
        aClass6_Sub1_935.method256("No prayer", byte0 + 8 + 102, byte1 + 215 + 16, 3, 0xffff00);
        aClass6_Sub1_935.method256("No weapons", byte0 + 8 + 102, byte1 + 215 + 35, 3, 0xffff00);
        aClass6_Sub1_935.method216(byte0 + 93, byte1 + 215 + 6, 11, 11, 0xffff00);
        if(aBoolean786)
            aClass6_Sub1_935.method215(byte0 + 95, byte1 + 215 + 8, 7, 7, 0xffff00);
        aClass6_Sub1_935.method216(byte0 + 93, byte1 + 215 + 25, 11, 11, 0xffff00);
        if(aBoolean787)
            aClass6_Sub1_935.method215(byte0 + 95, byte1 + 215 + 27, 7, 7, 0xffff00);
        aClass6_Sub1_935.method216(byte0 + 191, byte1 + 215 + 6, 11, 11, 0xffff00);
        if(aBoolean788)
            aClass6_Sub1_935.method215(byte0 + 193, byte1 + 215 + 8, 7, 7, 0xffff00);
        aClass6_Sub1_935.method216(byte0 + 191, byte1 + 215 + 25, 11, 11, 0xffff00);
        if(aBoolean789)
            aClass6_Sub1_935.method215(byte0 + 193, byte1 + 215 + 27, 7, 7, 0xffff00);
        if(!aBoolean678)
            aClass6_Sub1_935.method230(byte0 + 217, byte1 + 238, anInt778 + 25);
        aClass6_Sub1_935.method230(byte0 + 394, byte1 + 238, anInt778 + 26);
        if(aBoolean677) {
            aClass6_Sub1_935.method254("Other player", byte0 + 341, byte1 + 246, 1, 0xffffff);
            aClass6_Sub1_935.method254("has accepted", byte0 + 341, byte1 + 256, 1, 0xffffff);
        }
        if(aBoolean678) {
            aClass6_Sub1_935.method254("Waiting for", byte0 + 217 + 35, byte1 + 246, 1, 0xffffff);
            aClass6_Sub1_935.method254("other player", byte0 + 217 + 35, byte1 + 256, 1, 0xffffff);
        }
        for(int l4 = 0; l4 < anInt692; l4++) {
            int i5 = 217 + byte0 + (l4 % 5) * 49;
            int k5 = 31 + byte1 + (l4 / 5) * 34;
            aClass6_Sub1_935.method246(i5, k5, 48, 32, anInt780 + Class1.anIntArray71[anIntArray693[l4]], Class1.anIntArray76[anIntArray693[l4]], 0, 0, false);
            if(Class1.anIntArray73[anIntArray693[l4]] == 0)
                aClass6_Sub1_935.method256(String.valueOf(anIntArray694[l4]), i5 + 1, k5 + 10, 1, 0xffff00);
        }

        for(int j5 = 0; j5 < anInt663; j5++) {
            int l5 = 9 + byte0 + (j5 % 4) * 49;
            int j6 = 31 + byte1 + (j5 / 4) * 34;
            aClass6_Sub1_935.method246(l5, j6, 48, 32, anInt780 + Class1.anIntArray71[anIntArray664[j5]], Class1.anIntArray76[anIntArray664[j5]], 0, 0, false);
            if(Class1.anIntArray73[anIntArray664[j5]] == 0)
                aClass6_Sub1_935.method256(String.valueOf(anIntArray665[j5]), l5 + 1, j6 + 10, 1, 0xffff00);
            if(super.anInt33 > l5 && super.anInt33 < l5 + 48 && super.anInt34 > j6 && super.anInt34 < j6 + 32)
                aClass6_Sub1_935.method256(Class1.aStringArray112[anIntArray664[j5]] + ": @whi@" + Class1.aStringArray113[anIntArray664[j5]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }

        for(int i6 = 0; i6 < anInt764; i6++) {
            int k6 = 9 + byte0 + (i6 % 4) * 49;
            int l6 = 124 + byte1 + (i6 / 4) * 34;
            aClass6_Sub1_935.method246(k6, l6, 48, 32, anInt780 + Class1.anIntArray71[anIntArray765[i6]], Class1.anIntArray76[anIntArray765[i6]], 0, 0, false);
            if(Class1.anIntArray73[anIntArray765[i6]] == 0)
                aClass6_Sub1_935.method256(String.valueOf(anIntArray766[i6]), k6 + 1, l6 + 10, 1, 0xffff00);
            if(super.anInt33 > k6 && super.anInt33 < k6 + 48 && super.anInt34 > l6 && super.anInt34 < l6 + 32)
                aClass6_Sub1_935.method256(Class1.aStringArray112[anIntArray765[i6]] + ": @whi@" + Class1.aStringArray113[anIntArray765[i6]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }

    }

    public void method109() {
        char c = '\u0190';
        char c1 = 'd';
        if(aBoolean905) {
            c1 = '\u01C2';
            c1 = '\u012C';
        }
        aClass6_Sub1_935.method215(256 - c / 2, 167 - c1 / 2, c, c1, 0);
        aClass6_Sub1_935.method216(256 - c / 2, 167 - c1 / 2, c, c1, 0xffffff);
        aClass6_Sub1_935.method255(aString685, 256, (167 - c1 / 2) + 20, 1, 0xffffff, c - 40);
        int i = 157 + c1 / 2;
        int j = 0xffffff;
        if(super.anInt34 > i - 12 && super.anInt34 <= i && super.anInt33 > 106 && super.anInt33 < 406)
            j = 0xff0000;
        aClass6_Sub1_935.method254("Click here to close window", 256, i, 1, j);
        if(anInt912 == 1) {
            if(j == 0xff0000)
                aBoolean743 = false;
            if((super.anInt33 < 256 - c / 2 || super.anInt33 > 256 + c / 2) && (super.anInt34 < 167 - c1 / 2 || super.anInt34 > 167 + c1 / 2))
                aBoolean743 = false;
        }
        anInt912 = 0;
    }

    public void method110() {
        aClass4_806 = new Class4(aClass6_Sub1_935, 50);
        int i = 40;
        if(!aBoolean867) {
            aClass4_806.method155(256, 200 + i, "Click on an option", 5, true);
            aClass4_806.method156(156, 240 + i, 120, 35);
            aClass4_806.method156(356, 240 + i, 120, 35);
            aClass4_806.method155(156, 240 + i, "New User", 5, false);
            aClass4_806.method155(356, 240 + i, "Existing User", 5, false);
            anInt671 = aClass4_806.method163(156, 240 + i, 120, 35);
            anInt672 = aClass4_806.method163(356, 240 + i, 120, 35);
        } else {
            aClass4_806.method155(256, 200 + i, "Welcome to RuneScape", 4, true);
            aClass4_806.method155(256, 215 + i, "You need a member account to use this server", 4, true);
            aClass4_806.method156(256, 250 + i, 200, 35);
            aClass4_806.method155(256, 250 + i, "Click here to login", 5, false);
            anInt672 = aClass4_806.method163(256, 250 + i, 200, 35);
        }
        aClass4_877 = new Class4(aClass6_Sub1_935, 50);
        i = 230;
        if(anInt909 == 0) {
            aClass4_877.method155(256, i + 8, "To create an account please go back to the", 4, true);
            i += 20;
            aClass4_877.method155(256, i + 8, "www.runescape.com front page, and choose 'create account'", 4, true);
        } else
        if(anInt909 == 1) {
            aClass4_877.method155(256, i + 8, "To create an account please click on the", 4, true);
            i += 20;
            aClass4_877.method155(256, i + 8, "'create account' link below the game window", 4, true);
        } else {
            aClass4_877.method155(256, i + 8, "To create an account please go back to the", 4, true);
            i += 20;
            aClass4_877.method155(256, i + 8, "runescape front webpage and choose 'create account'", 4, true);
        }
        i += 30;
        aClass4_877.method156(256, i + 17, 150, 34);
        aClass4_877.method155(256, i + 17, "Ok", 5, false);
        anInt911 = aClass4_877.method163(256, i + 17, 150, 34);
        aClass4_803 = new Class4(aClass6_Sub1_935, 50);
        i = 230;
        anInt826 = aClass4_803.method155(256, i - 10, "Please enter your username and password", 4, true);
        i += 28;
        aClass4_803.method156(140, i, 200, 40);
        aClass4_803.method155(140, i - 10, "Username:", 4, false);
        anInt827 = aClass4_803.method161(140, i + 10, 200, 40, 4, 13, false, false);
        i += 47;
        aClass4_803.method156(190, i, 200, 40);
        aClass4_803.method155(190, i - 10, "Password:", 4, false);
        anInt828 = aClass4_803.method161(190, i + 10, 200, 40, 4, 20, true, false);
        i -= 55;
        aClass4_803.method156(410, i, 120, 25);
        aClass4_803.method155(410, i, "Ok", 4, false);
        anInt829 = aClass4_803.method163(410, i, 120, 25);
        i += 30;
        aClass4_803.method156(410, i, 120, 25);
        aClass4_803.method155(410, i, "Cancel", 4, false);
        anInt830 = aClass4_803.method163(410, i, 120, 25);
        i += 30;
        aClass4_803.method172(anInt827);
    }

    public void method111() {
        if(anInt810 != 0)
            method57();
        else
        if(aBoolean817)
            method64();
        else
        if(aBoolean743)
            method109();
        else
        if(anInt949 == 1)
            method67();
        else
        if(aBoolean699 && anInt675 == 0)
            method56();
        else
        if(aBoolean940 && anInt675 == 0)
            method86();
        else
        if(aBoolean900)
            method105();
        else
        if(aBoolean974)
            method99();
        else
        if(aBoolean944)
            method93();
        else
        if(aBoolean932)
            method108();
        else
        if(anInt738 == 1)
            method50();
        else
        if(anInt738 == 2)
            method96();
        else
        if(anInt773 != 0) {
            method113();
        } else {
            if(aBoolean727)
                method77();
            if(aClass2_888.anInt153 == 8 || aClass2_888.anInt153 == 9)
                method91();
            method69();
            boolean flag = !aBoolean727 && !aBoolean951;
            if(flag)
                anInt763 = 0;
            if(anInt725 == 0 && flag)
                method81();
            if(anInt725 == 1)
                method58(flag);
            if(anInt725 == 2)
                method120(flag);
            if(anInt725 == 3)
                method66(flag);
            if(anInt725 == 4)
                method85(flag);
            if(anInt725 == 5)
                method83(flag);
            if(anInt725 == 6)
                method88(flag);
            if(!aBoolean951 && !aBoolean727)
                method82();
            if(aBoolean951 && !aBoolean727)
                method76();
        }
        anInt912 = 0;
    }

    public void method112(int i, int j, int k, int l, boolean flag) {
        method103(i, j, k, l, k, l, false, flag);
    }

    public void method113() {
        if(anInt912 != 0) {
            anInt912 = 0;
            if(anInt773 == 1 && (super.anInt33 < 106 || super.anInt34 < 145 || super.anInt33 > 406 || super.anInt34 > 215)) {
                anInt773 = 0;
                return;
            }
            if(anInt773 == 2 && (super.anInt33 < 6 || super.anInt34 < 145 || super.anInt33 > 506 || super.anInt34 > 215)) {
                anInt773 = 0;
                return;
            }
            if(anInt773 == 3 && (super.anInt33 < 106 || super.anInt34 < 145 || super.anInt33 > 406 || super.anInt34 > 215)) {
                anInt773 = 0;
                return;
            }
            if(super.anInt33 > 236 && super.anInt33 < 276 && super.anInt34 > 193 && super.anInt34 < 213) {
                anInt773 = 0;
                return;
            }
        }
        int i = 145;
        if(anInt773 == 1) {
            aClass6_Sub1_935.method215(106, i, 300, 70, 0);
            aClass6_Sub1_935.method216(106, i, 300, 70, 0xffffff);
            i += 20;
            aClass6_Sub1_935.method254("Enter name to add to friends list", 256, i, 4, 0xffffff);
            i += 20;
            aClass6_Sub1_935.method254(super.aString40 + "*", 256, i, 4, 0xffffff);
            if(super.aString41.length() > 0) {
                String s = super.aString41.trim();
                super.aString40 = "";
                super.aString41 = "";
                anInt773 = 0;
                if(s.length() > 0 && Class15.method361(s) != aClass2_888.aLong145)
                    method31(s);
            }
        }
        if(anInt773 == 2) {
            aClass6_Sub1_935.method215(6, i, 500, 70, 0);
            aClass6_Sub1_935.method216(6, i, 500, 70, 0xffffff);
            i += 20;
            aClass6_Sub1_935.method254("Enter message to send to " + Class15.method362(aLong992), 256, i, 4, 0xffffff);
            i += 20;
            aClass6_Sub1_935.method254(super.aString42 + "*", 256, i, 4, 0xffffff);
            if(super.aString43.length() > 0) {
                String s1 = super.aString43;
                super.aString42 = "";
                super.aString43 = "";
                anInt773 = 0;
                int k = Class17.method399(s1);
                method33(aLong992, Class17.aByteArray569, k);
                s1 = Class17.method398(Class17.aByteArray569, 0, k);
                s1 = Class16.method373(s1);
                method42("@pri@You tell " + Class15.method362(aLong992) + ": " + s1);
            }
        }
        if(anInt773 == 3) {
            aClass6_Sub1_935.method215(106, i, 300, 70, 0);
            aClass6_Sub1_935.method216(106, i, 300, 70, 0xffffff);
            i += 20;
            aClass6_Sub1_935.method254("Enter name to add to ignore list", 256, i, 4, 0xffffff);
            i += 20;
            aClass6_Sub1_935.method254(super.aString40 + "*", 256, i, 4, 0xffffff);
            if(super.aString41.length() > 0) {
                String s2 = super.aString41.trim();
                super.aString40 = "";
                super.aString41 = "";
                anInt773 = 0;
                if(s2.length() > 0 && Class15.method361(s2) != aClass2_888.aLong145)
                    method29(s2);
            }
        }
        int j = 0xffffff;
        if(super.anInt33 > 236 && super.anInt33 < 276 && super.anInt34 > 193 && super.anInt34 < 213)
            j = 0xffff00;
        aClass6_Sub1_935.method254("Cancel", 256, 208, 1, j);
    }

    public boolean method114(int i, int j) {
        if(i == 31 && (method117(197) || method117(615) || method117(682)))
            return true;
        if(i == 32 && (method117(102) || method117(616) || method117(683)))
            return true;
        if(i == 33 && (method117(101) || method117(617) || method117(684)))
            return true;
        if(i == 34 && (method117(103) || method117(618) || method117(685)))
            return true;
        return method47(i) >= j;
    }

    public void method115() {
        int i = 0;
        byte byte0 = 50;
        byte byte1 = 50;
        aClass19_903.method406(byte0 * 48 + 23, byte1 * 48 + 23, i);
        aClass19_903.method433(aClass5Array777);
        char c = '\u2600';
        char c1 = '\u1900';
        char c2 = '\u044C';
        char c3 = '\u0378';
        aClass10_939.anInt390 = 4100;
        aClass10_939.anInt391 = 4100;
        aClass10_939.anInt392 = 1;
        aClass10_939.anInt393 = 4000;
        aClass10_939.method297(c, -aClass19_903.method404(c, c1), c1, 912, c3, 0, c2 * 2);
        aClass10_939.method285();
        aClass6_Sub1_935.method220();
        aClass6_Sub1_935.method220();
        aClass6_Sub1_935.method215(0, 0, 512, 6, 0);
        for(int j = 6; j >= 1; j--)
            aClass6_Sub1_935.method221(0, j, 0, j, 512, 8);

        aClass6_Sub1_935.method215(0, 194, 512, 20, 0);
        for(int k = 6; k >= 1; k--)
            aClass6_Sub1_935.method221(0, k, 0, 194 - k, 512, 8);

        aClass6_Sub1_935.method230(15, 15, anInt778 + 10);
        aClass6_Sub1_935.method229(anInt784, 0, 0, 512, 200);
        aClass6_Sub1_935.method226(anInt784);
        c = '\u2400';
        c1 = '\u2400';
        c2 = '\u044C';
        c3 = '\u0378';
        aClass10_939.anInt390 = 4100;
        aClass10_939.anInt391 = 4100;
        aClass10_939.anInt392 = 1;
        aClass10_939.anInt393 = 4000;
        aClass10_939.method297(c, -aClass19_903.method404(c, c1), c1, 912, c3, 0, c2 * 2);
        aClass10_939.method285();
        aClass6_Sub1_935.method220();
        aClass6_Sub1_935.method220();
        aClass6_Sub1_935.method215(0, 0, 512, 6, 0);
        for(int l = 6; l >= 1; l--)
            aClass6_Sub1_935.method221(0, l, 0, l, 512, 8);

        aClass6_Sub1_935.method215(0, 194, 512, 20, 0);
        for(int i1 = 6; i1 >= 1; i1--)
            aClass6_Sub1_935.method221(0, i1, 0, 194 - i1, 512, 8);

        aClass6_Sub1_935.method230(15, 15, anInt778 + 10);
        aClass6_Sub1_935.method229(anInt784 + 1, 0, 0, 512, 200);
        aClass6_Sub1_935.method226(anInt784 + 1);
        for(int j1 = 0; j1 < 64; j1++) {
            aClass10_939.method269(aClass19_903.aClass5ArrayArray608[0][j1]);
            aClass10_939.method269(aClass19_903.aClass5ArrayArray590[1][j1]);
            aClass10_939.method269(aClass19_903.aClass5ArrayArray608[1][j1]);
            aClass10_939.method269(aClass19_903.aClass5ArrayArray590[2][j1]);
            aClass10_939.method269(aClass19_903.aClass5ArrayArray608[2][j1]);
        }

        c = '\u2B80';
        c1 = '\u2880';
        c2 = '\u01F4';
        c3 = '\u0178';
        aClass10_939.anInt390 = 4100;
        aClass10_939.anInt391 = 4100;
        aClass10_939.anInt392 = 1;
        aClass10_939.anInt393 = 4000;
        aClass10_939.method297(c, -aClass19_903.method404(c, c1), c1, 912, c3, 0, c2 * 2);
        aClass10_939.method285();
        aClass6_Sub1_935.method220();
        aClass6_Sub1_935.method220();
        aClass6_Sub1_935.method215(0, 0, 512, 6, 0);
        for(int k1 = 6; k1 >= 1; k1--)
            aClass6_Sub1_935.method221(0, k1, 0, k1, 512, 8);

        aClass6_Sub1_935.method215(0, 194, 512, 20, 0);
        for(int l1 = 6; l1 >= 1; l1--)
            aClass6_Sub1_935.method221(0, l1, 0, 194, 512, 8);

        aClass6_Sub1_935.method230(15, 15, anInt778 + 10);
        aClass6_Sub1_935.method229(anInt778 + 10, 0, 0, 512, 200);
        aClass6_Sub1_935.method226(anInt778 + 10);
    }

    public void method116() {
        super.aString42 = "";
        super.aString43 = "";
    }

    public boolean method117(int i) {
        for(int j = 0; j < anInt692; j++)
            if(anIntArray693[j] == i && anIntArray695[j] == 1)
                return true;

        return false;
    }

    public void method118(int i, int j, int k) {
        aClass6_Sub1_935.method219(i, j, k);
        aClass6_Sub1_935.method219(i - 1, j, k);
        aClass6_Sub1_935.method219(i + 1, j, k);
        aClass6_Sub1_935.method219(i, j - 1, k);
        aClass6_Sub1_935.method219(i, j + 1, k);
    }

    public void method119() {
        for(int i = 0; i < anInt697; i++) {
            int j = aClass6_Sub1_935.method260(1);
            int l = anIntArray701[i];
            int k1 = anIntArray702[i];
            int j2 = anIntArray703[i];
            int i3 = anIntArray704[i];
            boolean flag = true;
            while(flag)  {
                flag = false;
                for(int i4 = 0; i4 < i; i4++)
                    if(k1 + i3 > anIntArray702[i4] - j && k1 - j < anIntArray702[i4] + anIntArray704[i4] && l - j2 < anIntArray701[i4] + anIntArray703[i4] && l + j2 > anIntArray701[i4] - anIntArray703[i4] && anIntArray702[i4] - j - i3 < k1) {
                        k1 = anIntArray702[i4] - j - i3;
                        flag = true;
                    }

            }
            anIntArray702[i] = k1;
            aClass6_Sub1_935.method255(aStringArray698[i], l, k1, 1, 0xffff00, 300);
        }

        for(int k = 0; k < anInt709; k++) {
            int i1 = anIntArray868[k];
            int l1 = anIntArray869[k];
            int k2 = anIntArray715[k];
            int j3 = anIntArray716[k];
            int l3 = (39 * k2) / 100;
            int j4 = (27 * k2) / 100;
            int k4 = l1 - j4;
            aClass6_Sub1_935.method233(i1 - l3 / 2, k4, l3, j4, anInt778 + 9, 85);
            int l4 = (36 * k2) / 100;
            int i5 = (24 * k2) / 100;
            aClass6_Sub1_935.method246(i1 - l4 / 2, (k4 + j4 / 2) - i5 / 2, l4, i5, Class1.anIntArray71[j3] + anInt780, Class1.anIntArray76[j3], 0, 0, false);
        }

        for(int j1 = 0; j1 < anInt728; j1++) {
            int i2 = anIntArray796[j1];
            int l2 = anIntArray797[j1];
            int k3 = anIntArray798[j1];
            aClass6_Sub1_935.method213(i2 - 15, l2 - 3, k3, 5, 65280, 192);
            aClass6_Sub1_935.method213((i2 - 15) + k3, l2 - 3, 30 - k3, 5, 0xff0000, 192);
        }

    }

    public void method120(boolean flag) {
        int i = ((Class6) (aClass6_Sub1_935)).anInt311 - 199;
        char c = '\234';
        char c2 = '\230';
        aClass6_Sub1_935.method230(i - 49, 3, anInt778 + 2);
        i += 40;
        aClass6_Sub1_935.method215(i, 36, c, c2, 0);
        aClass6_Sub1_935.method208(i, 36, i + c, 36 + c2);
        int k = 192 + anInt996;
        int i1 = anInt809 + anInt995 & 0xff;
        int k1 = ((aClass2_888.anInt149 - 6040) * 3 * k) / 2048;
        int i3 = ((aClass2_888.anInt150 - 6040) * 3 * k) / 2048;
        int k4 = Class10.anIntArray394[1024 - i1 * 4 & 0x3ff];
        int i5 = Class10.anIntArray394[(1024 - i1 * 4 & 0x3ff) + 1024];
        int k5 = i3 * k4 + k1 * i5 >> 18;
        i3 = i3 * i5 - k1 * k4 >> 18;
        k1 = k5;
        aClass6_Sub1_935.method242((i + c / 2) - k1, 36 + c2 / 2 + i3, anInt778 - 1, i1 + 64 & 0xff, k);
        for(int i7 = 0; i7 < anInt981; i7++) {
            int l1 = (((anIntArray882[i7] * anInt729 + 64) - aClass2_888.anInt149) * 3 * k) / 2048;
            int j3 = (((anIntArray883[i7] * anInt729 + 64) - aClass2_888.anInt150) * 3 * k) / 2048;
            int l5 = j3 * k4 + l1 * i5 >> 18;
            j3 = j3 * i5 - l1 * k4 >> 18;
            l1 = l5;
            method118(i + c / 2 + l1, (36 + c2 / 2) - j3, 65535);
        }

        for(int j7 = 0; j7 < anInt895; j7++) {
            int i2 = (((anIntArray966[j7] * anInt729 + 64) - aClass2_888.anInt149) * 3 * k) / 2048;
            int k3 = (((anIntArray967[j7] * anInt729 + 64) - aClass2_888.anInt150) * 3 * k) / 2048;
            int i6 = k3 * k4 + i2 * i5 >> 18;
            k3 = k3 * i5 - i2 * k4 >> 18;
            i2 = i6;
            method118(i + c / 2 + i2, (36 + c2 / 2) - k3, 0xff0000);
        }

        for(int k7 = 0; k7 < anInt717; k7++) {
            Class2 class2 = aClass2Array705[k7];
            int j2 = ((class2.anInt149 - aClass2_888.anInt149) * 3 * k) / 2048;
            int l3 = ((class2.anInt150 - aClass2_888.anInt150) * 3 * k) / 2048;
            int j6 = l3 * k4 + j2 * i5 >> 18;
            l3 = l3 * i5 - j2 * k4 >> 18;
            j2 = j6;
            method118(i + c / 2 + j2, (36 + c2 / 2) - l3, 0xffff00);
        }

        for(int l7 = 0; l7 < anInt689; l7++) {
            Class2 class2_1 = aClass2Array904[l7];
            int k2 = ((class2_1.anInt149 - aClass2_888.anInt149) * 3 * k) / 2048;
            int i4 = ((class2_1.anInt150 - aClass2_888.anInt150) * 3 * k) / 2048;
            int k6 = i4 * k4 + k2 * i5 >> 18;
            i4 = i4 * i5 - k2 * k4 >> 18;
            k2 = k6;
            int j8 = 0xffffff;
            for(int k8 = 0; k8 < super.anInt624; k8++) {
                if(class2_1.aLong145 != super.aLongArray625[k8] || super.anIntArray626[k8] != 99)
                    continue;
                j8 = 65280;
                break;
            }

            method118(i + c / 2 + k2, (36 + c2 / 2) - i4, j8);
        }

        aClass6_Sub1_935.method212(i + c / 2, 36 + c2 / 2, 2, 0xffffff, 255);
        aClass6_Sub1_935.method242(i + 19, 55, anInt778 + 24, anInt809 + 128 & 0xff, 128);
        aClass6_Sub1_935.method208(0, 0, anInt985, anInt986 + 12);
        if(!flag)
            return;
        i = super.anInt33 - (((Class6) (aClass6_Sub1_935)).anInt311 - 199);
        int i8 = super.anInt34 - 36;
        if(i >= 40 && i8 >= 0 && i < 196 && i8 < 152) {
            char c1 = '\234';
            char c3 = '\230';
            int l = 192 + anInt996;
            int j1 = anInt809 + anInt995 & 0xff;
            int j = ((Class6) (aClass6_Sub1_935)).anInt311 - 199;
            j += 40;
            int l2 = ((super.anInt33 - (j + c1 / 2)) * 16384) / (3 * l);
            int j4 = ((super.anInt34 - (36 + c3 / 2)) * 16384) / (3 * l);
            int l4 = Class10.anIntArray394[1024 - j1 * 4 & 0x3ff];
            int j5 = Class10.anIntArray394[(1024 - j1 * 4 & 0x3ff) + 1024];
            int l6 = j4 * l4 + l2 * j5 >> 15;
            j4 = j4 * j5 - l2 * l4 >> 15;
            l2 = l6;
            l2 += aClass2_888.anInt149;
            j4 = aClass2_888.anInt150 - j4;
            if(anInt912 == 1)
                method112(anInt889, anInt890, l2 / 128, j4 / 128, false);
            anInt912 = 0;
        }
    }

    public mudclient() {
        anInt650 = 250;
        anInt651 = 5;
        anInt652 = 50;
        anInt653 = 18;
        anInt654 = 500;
        anInt655 = 1500;
        anInt656 = 5000;
        anInt657 = 5000;
        anInt658 = 500;
        anInt659 = 4000;
        anInt660 = 500;
        anInt661 = 8000;
        anIntArray664 = new int[8];
        anIntArray665 = new int[8];
        aBoolean666 = true;
        aStringArray667 = new String[5];
        aClass2Array670 = new Class2[500];
        aString673 = "";
        aString674 = "";
        aStringArray676 = new String[250];
        aBoolean677 = false;
        aBoolean678 = false;
        anIntArray680 = new int[14];
        anIntArray681 = new int[14];
        anIntArray683 = new int[14];
        anIntArray684 = new int[14];
        aString685 = "";
        aString686 = "";
        anIntArray693 = new int[35];
        anIntArray694 = new int[35];
        anIntArray695 = new int[35];
        anInt696 = 0xbc614e;
        aStringArray698 = new String[50];
        aBoolean699 = false;
        aClass5Array700 = new Class5[500];
        anIntArray701 = new int[50];
        anIntArray702 = new int[50];
        anIntArray703 = new int[50];
        anIntArray704 = new int[50];
        aClass2Array705 = new Class2[500];
        anIntArray706 = new int[5];
        aBooleanArray710 = new boolean[50];
        aBoolean711 = false;
        aBoolean712 = false;
        aClass2Array713 = new Class2[4000];
        anIntArray715 = new int[50];
        anIntArray716 = new int[50];
        anInt722 = -1;
        aBoolean723 = false;
        anInt724 = 48;
        aBoolean727 = false;
        anInt729 = 128;
        anInt731 = 1;
        anInt737 = 2;
        aBoolean743 = false;
        aString744 = "";
        aBoolean745 = false;
        anIntArray748 = new int[18];
        anInt751 = -1;
        anInt752 = -1;
        anInt753 = -1;
        anInt754 = -1;
        anIntArray755 = new int[8000];
        anIntArray756 = new int[8000];
        anInt757 = -1;
        aString758 = "";
        anIntArray765 = new int[8];
        anIntArray766 = new int[8];
        anIntArray767 = new int[50];
        anIntArray768 = new int[250];
        aBoolean769 = false;
        aClass2Array772 = new Class2[500];
        aBoolean774 = true;
        aBoolean776 = false;
        aClass5Array777 = new Class5[1000];
        aBoolean785 = false;
        aBoolean786 = false;
        aBoolean787 = false;
        aBoolean788 = false;
        aBoolean789 = false;
        aString790 = "";
        anIntArray792 = new int[50];
        anIntArray794 = new int[8];
        anIntArray795 = new int[8];
        anIntArray796 = new int[50];
        anIntArray797 = new int[50];
        anIntArray798 = new int[50];
        aClass5Array805 = new Class5[1500];
        aBooleanArray808 = new boolean[50];
        anInt809 = 128;
        aBoolean817 = false;
        anInt819 = 1;
        anInt820 = 2;
        anInt821 = 2;
        anInt822 = 8;
        anInt823 = 14;
        anInt825 = 1;
        anInt831 = -1;
        anInt832 = -2;
        aStringArray833 = new String[250];
        aBooleanArray837 = new boolean[1500];
        anIntArray838 = new int[18];
        aBoolean840 = false;
        anIntArray844 = new int[250];
        anIntArray845 = new int[250];
        anIntArray846 = new int[250];
        anIntArray849 = new int[256];
        anIntArray850 = new int[256];
        anIntArray851 = new int[256];
        aBoolean867 = false;
        anIntArray868 = new int[50];
        anIntArray869 = new int[50];
        anIntArray870 = new int[256];
        anIntArray871 = new int[256];
        anIntArray873 = new int[8];
        anIntArray874 = new int[8];
        anIntArray876 = new int[500];
        anIntArray878 = new int[5];
        anIntArray882 = new int[1500];
        anIntArray883 = new int[1500];
        anIntArray884 = new int[1500];
        anIntArray885 = new int[1500];
        anIntArray886 = new int[250];
        anIntArray887 = new int[250];
        aClass2_888 = new Class2();
        anInt891 = -1;
        anInt892 = 30;
        aBoolean900 = false;
        aBoolean901 = false;
        aClass2Array904 = new Class2[500];
        aBoolean905 = false;
        aString906 = "";
        aString907 = "";
        anInt913 = 550;
        aBoolean914 = true;
        anIntArray915 = new int[256];
        anIntArray916 = new int[256];
        aBoolean917 = false;
        anInt919 = -1;
        anInt921 = 2;
        anIntArray923 = new int[14];
        anIntArray924 = new int[14];
        anIntArray925 = new int[250];
        aBoolean926 = false;
        anIntArray928 = new int[18];
        aBoolean929 = false;
        aClass2Array930 = new Class2[5000];
        aBoolean932 = false;
        anIntArray933 = new int[50];
        aBoolean937 = false;
        anIntArray938 = new int[99];
        aBoolean940 = false;
        anIntArray942 = new int[8192];
        anIntArray943 = new int[8192];
        aBoolean944 = false;
        aBoolean945 = false;
        anIntArray947 = new int[500];
        anIntArray948 = new int[500];
        aBoolean950 = false;
        aBoolean951 = false;
        anInt953 = 40;
        anIntArray954 = new int[50];
        anIntArray960 = new int[500];
        anIntArray961 = new int[500];
        anIntArray966 = new int[5000];
        anIntArray967 = new int[5000];
        anIntArray968 = new int[5000];
        anIntArray969 = new int[5000];
        anInt970 = -1;
        anInt971 = -2;
        aStringArray972 = new String[5];
        aBoolean974 = false;
        aBooleanArray980 = new boolean[500];
        anIntArray983 = new int[14];
        anIntArray984 = new int[14];
        anInt985 = 512;
        anInt986 = 334;
        anInt987 = 9;
        aBoolean988 = false;
        aString994 = "";
    }

    public int anInt650 = 250;
    public int anInt651 = 5;
    public int anInt652 = 50;
    public int anInt653 = 18;
    public int anInt654 = 500;
    public int anInt655 = 1500;
    public int anInt656 = 5000;
    public int anInt657 = 5000;
    public int anInt658 = 500;
    public int anInt659 = 4000;
    public int anInt660 = 500;
    public int anInt661 = 8000;
    public int anInt662;
    public int anInt663;
    public int anIntArray664[];
    public int anIntArray665[];
    public boolean aBoolean666;
    public String aStringArray667[];
    public int anInt668;
    public int anInt669;
    public Class2 aClass2Array670[];
    public int anInt671;
    public int anInt672;
    public String aString673;
    public String aString674;
    public int anInt675;
    public String aStringArray676[];
    public boolean aBoolean677;
    public boolean aBoolean678;
    public int anInt679;
    public int anIntArray680[];
    public int anIntArray681[];
    public int anInt682;
    public int anIntArray683[];
    public int anIntArray684[];
    public String aString685;
    public String aString686;
    public int anInt687;
    public int anInt688;
    public int anInt689;
    public int anInt690;
    public int anInt691;
    public int anInt692;
    public int anIntArray693[];
    public int anIntArray694[];
    public int anIntArray695[];
    public int anInt696;
    public int anInt697;
    public String aStringArray698[];
    public boolean aBoolean699;
    public Class5 aClass5Array700[];
    public int anIntArray701[];
    public int anIntArray702[];
    public int anIntArray703[];
    public int anIntArray704[];
    public Class2 aClass2Array705[];
    public int anIntArray706[];
    public int anIntArray707[] = {
        0xff0000, 0xff8000, 0xffe000, 0xa0e000, 57344, 32768, 41088, 45311, 33023, 12528, 
        0xe000e0, 0x303030, 0x604000, 0x805000, 0xffffff
    };
    public int anInt708;
    public int anInt709;
    public boolean aBooleanArray710[];
    public boolean aBoolean711;
    public boolean aBoolean712;
    public Class2 aClass2Array713[];
    public int anIntArray714[] = {
        0, 1, 2, 1, 0, 0, 0, 0
    };
    public int anIntArray715[];
    public int anIntArray716[];
    public int anInt717;
    public int anInt718;
    public int anInt719;
    public int anInt720;
    public int anInt721;
    public int anInt722;
    public boolean aBoolean723;
    public int anInt724;
    public int anInt725;
    public int anIntArray726[] = {
        0, 1, 2, 1
    };
    public boolean aBoolean727;
    public int anInt728;
    public int anInt729;
    public int anInt730;
    public int anInt731;
    public int anInt732;
    public Class4 aClass4_733;
    public int anInt734;
    public int anInt735;
    public int anInt736;
    public int anInt737;
    public int anInt738;
    public int anInt739;
    public int anInt740;
    public int anInt741;
    public int anInt742;
    public boolean aBoolean743;
    public String aString744;
    public boolean aBoolean745;
    public String aString746;
    public int anInt747;
    public int anIntArray748[];
    public int anInt749;
    public int anInt750;
    public int anInt751;
    public int anInt752;
    public int anInt753;
    public int anInt754;
    public int anIntArray755[];
    public int anIntArray756[];
    public int anInt757;
    public String aString758;
    public int anInt759;
    public int anInt760;
    public int anInt761;
    public int anInt762;
    public int anInt763;
    public int anInt764;
    public int anIntArray765[];
    public int anIntArray766[];
    public int anIntArray767[];
    public int anIntArray768[];
    public boolean aBoolean769;
    public int anInt770;
    public int anIntArray771[] = {
        0, 0, 0, 0, 0, 1, 2, 1
    };
    public Class2 aClass2Array772[];
    public int anInt773;
    public boolean aBoolean774;
    public int anInt775;
    public boolean aBoolean776;
    public Class5 aClass5Array777[];
    public int anInt778;
    public int anInt779;
    public int anInt780;
    public int anInt781;
    public int anInt782;
    public int anInt783;
    public int anInt784;
    public boolean aBoolean785;
    public boolean aBoolean786;
    public boolean aBoolean787;
    public boolean aBoolean788;
    public boolean aBoolean789;
    public String aString790;
    public int anInt791;
    public int anIntArray792[];
    public int anInt793;
    public int anIntArray794[];
    public int anIntArray795[];
    public int anIntArray796[];
    public int anIntArray797[];
    public int anIntArray798[];
    public int anInt799;
    public int anInt800;
    public int anInt801;
    public int anInt802;
    public Class4 aClass4_803;
    public int anIntArray804[] = {
        0xffc030, 0xffa040, 0x805030, 0x604020, 0x303030, 0xff6020, 0xff4000, 0xffffff, 65280, 65535
    };
    public Class5 aClass5Array805[];
    public Class4 aClass4_806;
    public int anInt807;
    public boolean aBooleanArray808[];
    public int anInt809;
    public int anInt810;
    public Class4 aClass4_811;
    public int anInt812;
    public int anInt813;
    public int anInt814;
    public int anInt815;
    public int anInt816;
    public boolean aBoolean817;
    public int anInt818;
    public int anInt819;
    public int anInt820;
    public int anInt821;
    public int anInt822;
    public int anInt823;
    public int anInt824;
    public int anInt825;
    public int anInt826;
    public int anInt827;
    public int anInt828;
    public int anInt829;
    public int anInt830;
    public int anInt831;
    public int anInt832;
    public String aStringArray833[];
    public Class4 aClass4_834;
    public int anInt835;
    public int anInt836;
    public boolean aBooleanArray837[];
    public int anIntArray838[];
    public int anInt839;
    public boolean aBoolean840;
    public int anInt841;
    public int anInt842;
    public int anInt843;
    public int anIntArray844[];
    public int anIntArray845[];
    public int anIntArray846[];
    public int anInt847;
    public int anInt848;
    public int anIntArray849[];
    public int anIntArray850[];
    public int anIntArray851[];
    public int anIntArrayArray852[][] = {
        {
            11, 2, 9, 7, 1, 6, 10, 0, 5, 8, 
            3, 4
        }, {
            11, 2, 9, 7, 1, 6, 10, 0, 5, 8, 
            3, 4
        }, {
            11, 3, 2, 9, 7, 1, 6, 10, 0, 5, 
            8, 4
        }, {
            3, 4, 2, 9, 7, 1, 6, 10, 8, 11, 
            0, 5
        }, {
            3, 4, 2, 9, 7, 1, 6, 10, 8, 11, 
            0, 5
        }, {
            4, 3, 2, 9, 7, 1, 6, 10, 8, 11, 
            0, 5
        }, {
            11, 4, 2, 9, 7, 1, 6, 10, 0, 5, 
            8, 3
        }, {
            11, 2, 9, 7, 1, 6, 10, 0, 5, 8, 
            4, 3
        }
    };
    public int anInt853;
    public int anInt854;
    public int anInt855;
    public int anInt856;
    public int anInt857;
    public int anInt858;
    public int anInt859;
    public int anInt860;
    public int anInt861;
    public int anInt862;
    public int anInt863;
    public int anInt864;
    public int anInt865;
    public int anInt866;
    public boolean aBoolean867;
    public int anIntArray868[];
    public int anIntArray869[];
    public int anIntArray870[];
    public int anIntArray871[];
    public int anInt872;
    public int anIntArray873[];
    public int anIntArray874[];
    public int anInt875;
    public int anIntArray876[];
    public Class4 aClass4_877;
    public int anIntArray878[];
    public int anInt879;
    public int anInt880;
    public int anInt881;
    public int anIntArray882[];
    public int anIntArray883[];
    public int anIntArray884[];
    public int anIntArray885[];
    public int anIntArray886[];
    public int anIntArray887[];
    public Class2 aClass2_888;
    public int anInt889;
    public int anInt890;
    public int anInt891;
    public int anInt892;
    public int anInt893;
    public int anInt894;
    public int anInt895;
    public int anInt896;
    public int anInt897;
    public int anInt898;
    public String aString899;
    public boolean aBoolean900;
    public boolean aBoolean901;
    public int anInt902;
    public Class19 aClass19_903;
    public Class2 aClass2Array904[];
    public boolean aBoolean905;
    public String aString906;
    public String aString907;
    public String aStringArray908[] = {
        "Armour", "WeaponAim", "WeaponPower", "Magic", "Prayer"
    };
    public int anInt909;
    public int anInt910;
    public int anInt911;
    public int anInt912;
    public int anInt913;
    public boolean aBoolean914;
    public int anIntArray915[];
    public int anIntArray916[];
    public boolean aBoolean917;
    public String aStringArray918[] = {
        "Black knight's fortress", "Cook's assistant", "Demon slayer", "Doric's quest", "The restless ghost", "Goblin diplomacy", "Ernest the chicken", "Imp catcher", "Pirate's treasure", "Prince Ali rescue", 
        "Romeo & Juliet", "Sheep shearer", "Shield of Arrav", "The knight's sword", "Vampire slayer", "Witch's potion", "Dragon slayer", "Witch's house (members)", "Lost city (members)", "Hero's quest (members)", 
        "Druidic ritual (members)", "Merlin's crystal (members)", "Scorpion catcher (members)", "Family crest (members)", "Tribal totem (members)", "Fishing contest (members)", "Monk's friend (members)", "Temple of Ikov (members)", "Clock tower (members)", "The Holy Grail (members)", 
        "Fight Arena (members)", "Tree Gnome Village (members)", "The Hazeel Cult (members)", "Sheep Herder (members)", "Plague City (members)", "Sea Slug (members)", "Waterfall quest (members)", "Biohazard (members)", "Jungle potion (members)", "Grand tree (members)", 
        "Shilo village (members)", "Underground pass (members)", "Observatory quest (members)", "Tourist trap (members)", "Watchtower (members)", "Dwarf Cannon (members)", "Murder Mystery (members)", "Digsite (members)", "Gertrude's Cat (members)", "Legend's Quest (members)"
    };
    public int anInt919;
    public int anInt920;
    public int anInt921;
    public int anInt922;
    public int anIntArray923[];
    public int anIntArray924[];
    public int anIntArray925[];
    public boolean aBoolean926;
    public InputStream_Sub1 anInputStream_Sub1_927;
    public int anIntArray928[];
    public boolean aBoolean929;
    public Class2 aClass2Array930[];
    public String aStringArray931[] = {
        "Attack", "Defense", "Strength", "Hits", "Ranged", "Prayer", "Magic", "Cooking", "Woodcut", "Fletching", 
        "Fishing", "Firemaking", "Crafting", "Smithing", "Mining", "Herblaw", "Agility", "Thieving"
    };
    public boolean aBoolean932;
    public int anIntArray933[];
    public int anInt934;
    public Class6_Sub1 aClass6_Sub1_935;
    public String aStringArray936[] = {
        "Attack", "Defense", "Strength", "Hits", "Ranged", "Prayer", "Magic", "Cooking", "Woodcutting", "Fletching", 
        "Fishing", "Firemaking", "Crafting", "Smithing", "Mining", "Herblaw", "Agility", "Thieving"
    };
    public boolean aBoolean937;
    public int anIntArray938[];
    public Class10 aClass10_939;
    public boolean aBoolean940;
    public int anInt941;
    public int anIntArray942[];
    public int anIntArray943[];
    public boolean aBoolean944;
    public boolean aBoolean945;
    public Graphics aGraphics946;
    public int anIntArray947[];
    public int anIntArray948[];
    public int anInt949;
    public boolean aBoolean950;
    public boolean aBoolean951;
    public int anInt952;
    public int anInt953;
    public int anIntArray954[];
    public Class4 aClass4_955;
    public int anInt956;
    public int anInt957;
    public int anInt958;
    public int anInt959;
    public int anIntArray960[];
    public int anIntArray961[];
    public int anInt962;
    public int anInt963;
    public int anInt964;
    public int anInt965;
    public int anIntArray966[];
    public int anIntArray967[];
    public int anIntArray968[];
    public int anIntArray969[];
    public int anInt970;
    public int anInt971;
    public String aStringArray972[];
    public long aLong973;
    public boolean aBoolean974;
    public int anInt975;
    public int anIntArray976[] = {
        0xecded0, 0xccb366, 0xb38c40, 0x997326, 0x906020
    };
    public byte aByteArray977[];
    public int anInt978;
    public int anInt979;
    public boolean aBooleanArray980[];
    public int anInt981;
    public int anInt982;
    public int anIntArray983[];
    public int anIntArray984[];
    public int anInt985;
    public int anInt986;
    public int anInt987;
    public boolean aBoolean988;
    public Class4 aClass4_989;
    public int anInt990;
    public int anInt991;
    public long aLong992;
    public long aLong993;
    public String aString994;
    public int anInt995;
    public int anInt996;
    public String aStringArray997[] = {
        "Where were you born?", "What was your first teachers name?", "What is your fathers middle name?", "Who was your first best friend?", "What is your favourite vacation spot?", "What is your mothers middle name?", "What was your first pets name?", "What was the name of your first school?", "What is your mothers maiden name?", "Who was your first boyfriend/girlfriend?", 
        "What was the first computer game you purchased?", "Who is your favourite actor/actress?", "Who is your favourite author?", "Who is your favourite musician?", "Who is your favourite cartoon character?", "What is your favourite book?", "What is your favourite food?", "What is your favourite movie?"
    };
}
