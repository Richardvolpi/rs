public class Rendering extends AccessorMethods implements CommandHandler {
    public String[] getPrefixList() {
        return new String[] { "rendering" };
    }
    public void activated(String s, String as[]) {
        rs.rendering = !rs.rendering;
    }
}
