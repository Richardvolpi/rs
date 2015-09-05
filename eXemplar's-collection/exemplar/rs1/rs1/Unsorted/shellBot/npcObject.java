public class npcObject {

    public String name;
    public int pID;
    public int gmg;
    public int xCoord;
    public int yCoord;
    public int ID;
    public int Dir;
    public int newDir;
    public int NewpathIndex;
    public int pathIndex;
    public int[] xCoordPath;
    public int[] yCoordPath;
    public int talkVar;
    public int curHits;
    public int maxHits;
    public int combatVar;
    public int combat;

    public npcObject() {
        xCoordPath = new int[10];
        yCoordPath = new int[10];
        combat = -1;
    }
}
