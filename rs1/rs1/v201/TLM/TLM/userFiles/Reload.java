public class Reload extends AccessorMethods implements CommandHandler {
    public String[] getPrefixList() {
        return new String[] { "reload" };
    }
    public void activated(String s, String as[]) {
        rs.reload();
    }
}
