import java.awt.Component;


public final class k extends j {

    public k(int width, int height, int i1, Component component) {
        super(width, height, i1, component);
    }

    public final void cdc(int i, int l, int i1, int j1, int k1, int l1, int i2) {
        if (k1 >= 50000) {
            rs.fam(i, l, i1, j1, k1 - 50000, l1, i2);
        } else if (k1 >= 40000) {
            rs.fcl(i, l, i1, j1, k1 - 40000, l1, i2);
        } else if (k1 >= 20000) {
            rs.fca(i, l, i1, j1, k1 - 20000, l1, i2);
        } else if (k1 >= 5000) {
            rs.fdk(i, l, i1, j1, k1 - 5000, l1, i2);
        } else {
            super.ccc(i, l, i1, j1, k1);
        }
    }

    public mudclient rs;
}
