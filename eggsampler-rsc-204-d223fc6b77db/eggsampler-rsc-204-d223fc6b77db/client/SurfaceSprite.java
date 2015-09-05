import java.awt.*;

public final class SurfaceSprite extends Surface {

    public SurfaceSprite(int width, int height, int k, Component component) {
        super(width, height, k, component);
        /*boolean flag = false;
        if (flag)
            new Class6(i, j, k, component);    */
    }

    public final void spriteClipping(int i, int j, int k, int l, int i1, int j1, int k1) {
        if (i1 >= 50000) {
            mudclientref.method108(i, j, k, l, i1 - 50000, j1, k1);
            return;
        }
        if (i1 >= 40000) {
            mudclientref.drawItem(i, j, k, l, i1 - 40000, j1, k1);
            return;
        }
        if (i1 >= 20000) {
            mudclientref.drawNpc(i, j, k, l, i1 - 20000, j1, k1);
            return;
        }
        if (i1 >= 5000) {
            mudclientref.drawPlayer(i, j, k, l, i1 - 5000, j1, k1);
            return;
        } else {
            super.spriteClipping(i, j, k, l, i1);
            return;
        }
    }

    public mudclient mudclientref;
}
