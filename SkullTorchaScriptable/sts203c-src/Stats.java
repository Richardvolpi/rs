public class Stats {
    public String[] Messages;
    public int[] XCoords;
    public int[] YCoords;
    
    Stats(String[] s, int[] x, int[] y) {
        if (x.length != y.length) {
            return;
        }
        if (s.length != x.length) {
            return;
        }
        Messages = s;
        XCoords = x;
        YCoords = y;
    }
}
