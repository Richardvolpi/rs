public class Stop extends AccessorMethods implements CommandHandler {
    public String[] getPrefixList() {
        return new String[] { "stop" };
    }
    public void activated(String s, String as[]) {
        String name;
        if (as.length == 1)
            name = as[0].trim();
        else
            name = "";
        rs.stopScript(name);
    }
}
