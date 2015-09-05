public class ServerList {
    private static int currentServer=0;
   
    private static String[] urls = new String[] { "217.138.31.250", "209.237.251.20", "69.22.158.236" };
        
    public static String getServer() {
        if (currentServer == 1 || currentServer == 2)
            return urls[0];
        else if (currentServer == 3 || currentServer == 4)
            return urls[1];
        else if (currentServer == 5 || currentServer == 6)
            return urls[2];
        return urls[0];
    }
    public static boolean isMembers() {
        System.out.println("isMembers() returning " + (currentServer % 2 == 1));
        return currentServer % 2 == 1;
    }
    public static int getPortOffset() {
        return currentServer % 2;
    }
    public static void setServer(int server) {
        System.out.println("Setting server to " + server);
        currentServer = server;
    }
}
    
