import java.awt.*;
class KeyState {
    private boolean ctrl,meta,shift;
    private int id;
    private boolean down;
    public KeyState(int id,Event e, boolean down) {
        this.id = id;
        this.down = down;
        ctrl = e.controlDown();
        meta = e.metaDown();
        shift = e.shiftDown();
    }
    public int getID() { return id; }
    public boolean isCtrlDown() { return ctrl; }
    public boolean isMetaDown() { return meta; }
    public boolean isShiftDown() { return shift; }
    public boolean keyUp() { return !down; }
    public boolean keyDown() { return down; }
}
        
