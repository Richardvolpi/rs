import java.awt.*;

public class GameFrame extends Frame {

    public GameFrame(GameApplet gameApplet, int ww, int wh, String title, boolean resizable, boolean flag1) {
        yOffset = 28;
        windowWidth = ww;
        windowHeight = wh;
        this.gameApplet = gameApplet;
        if (flag1)
            yOffset = 48;
        else
            yOffset = 28;
        setTitle(title);
        setResizable(resizable);
        show();
        toFront();
        resize(windowWidth, windowHeight);
        graphics = getGraphics();
    }

    public Graphics getGraphics() {
        Graphics g = super.getGraphics();
        if (anInt46 == 0)
            g.translate(0, 24);
        else
            g.translate(-5, 0);
        return g;
    }

    public void resize(int i, int j) {
        super.resize(i, j + yOffset);
    }

    public boolean handleEvent(Event event) {
        if (event.id == 401)
            gameApplet.keyDown(event, event.key);
        else if (event.id == 402)
            gameApplet.keyUp(event, event.key);
        else if (event.id == 501)
            gameApplet.mouseDown(event, event.x, event.y - 24);
        else if (event.id == 506)
            gameApplet.mouseDrag(event, event.x, event.y - 24);
        else if (event.id == 502)
            gameApplet.mouseUp(event, event.x, event.y - 24);
        else if (event.id == 503)
            gameApplet.mouseMove(event, event.x, event.y - 24);
        else if (event.id == 201)
            gameApplet.destroy();
        else if (event.id == 1001)
            gameApplet.action(event, event.target);
        else if (event.id == 403)
            gameApplet.keyDown(event, event.key);
        else if (event.id == 404)
            gameApplet.keyUp(event, event.key);
        return true;
    }

    public final void paint(Graphics g) {
        gameApplet.paint(g);
    }

    int windowWidth;
    int windowHeight;
    int anInt46;
    int yOffset;
    GameApplet gameApplet;
    Graphics graphics;
}
