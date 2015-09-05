// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) nonlb 

import java.awt.Component;

public class Class6_Sub1 extends Class6 {

    public Class6_Sub1(int i, int j, int k, Component component) {
        super(i, j, k, component);
        boolean flag = false;
        if(flag)
            new Class6(i, j, k, component);
    }

    public void method245(int i, int j, int k, int l, int i1, int j1, int k1) {
        if(i1 >= 50000) {
            aMudclient641.method71(i, j, k, l, i1 - 50000, j1, k1);
            return;
        }
        if(i1 >= 40000) {
            aMudclient641.method68(i, j, k, l, i1 - 40000, j1, k1);
            return;
        }
        if(i1 >= 20000) {
            aMudclient641.method45(i, j, k, l, i1 - 20000, j1, k1);
            return;
        }
        if(i1 >= 5000) {
            aMudclient641.method52(i, j, k, l, i1 - 5000, j1, k1);
            return;
        } else {
            super.method231(i, j, k, l, i1);
            return;
        }
    }

    public mudclient aMudclient641;
}
