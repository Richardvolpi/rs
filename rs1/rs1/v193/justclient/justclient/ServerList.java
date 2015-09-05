public class ServerList {
    private int curServ = 1;
    private String[] codeBase = { "http://ul2.runescape.com/" };
    private String[] portoff = { "0" };
    private String[] nodeid = { "39" };
    public String getCodeBase() { return codeBase[0]; }
    public String getPortOff() { return portoff[0]; }
    public String getNodeId() { return nodeid[0]; }
    public void setServer(int curServ) { this.curServ = curServ; }
}
