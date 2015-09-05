import java.awt.*;

@SuppressWarnings("serial")
public class c extends Frame {

    public c(a arg0, int arg1, int arg2, String arg3, boolean arg4, boolean arg5, boolean onTop) {
        fek = 28;
        feh = arg1;
        fei = arg2;
        fel = arg0;
        if (arg5) {
            fek = 48;
        }
        setBackground(Color.black);
        setTitle(arg3);
        setResizable(arg4);
        if (onTop) {
            setAlwaysOnTop(true);
        }
        setFocusTraversalKeysEnabled(false);
        setVisible(true);
        toFront();
        resize(feh, fei);
        fem = getGraphics();
    }
    
    public Graphics getGraphics() {
        Graphics g = super.getGraphics();
        g.translate(0, 24);
        return g;
    }

    public void resize(int i, int j) {
        super.setSize(i, j + fek);
    }

    public boolean handleEvent(Event e) {
        if (e.id == 401) {
            fel.keyDown(e, e.key);
        } else if (e.id == 402) {
            fel.keyUp(e, e.key);
        } else if (e.id == 501) {
            fel.mouseDown(e, e.x, e.y - 24);
        } else if (e.id == 506) {
            fel.mouseDrag(e, e.x, e.y - 24);
        } else if (e.id == 502) {
            fel.mouseUp(e, e.x, e.y - 24);
        } else if (e.id == 503) {
            fel.mouseMove(e, e.x, e.y - 24);
        } else if (e.id == 201) {
            fel.destroy();
        } else if (e.id == 1001) {
            fel.action(e, e.target);// Deprecated
        } else if (e.id == 403) {
            fel.keyDown(e, e.key);
        } else if (e.id == 404) {
            fel.keyUp(e, e.key);
        }
        return true;
    }

    public final void paint(Graphics g) {
        fel.paint(g);
    }

    int feh;
    int fei;
    int fek;
    a fel;
    Graphics fem;
}