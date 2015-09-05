public class MessageListener {
    private boolean server,pm,chat;
    public MessageListener(Object o) {
        Class iClass = o.getClass();
        if (PrivateMessageListener.class.isAssignableFrom(iClass))
            pm = true;
        if (ServerMessageListener.class.isAssignableFrom(iClass))
            server = true;
        if (ChatMessageListener.class.isAssignableFrom(iClass))
            chat = true;
    }
    public boolean isPrivateMessageListener() { return pm; }
    public boolean isServerMessageListener() { return server; }
    public boolean isChatMessageListener() { return chat; }
}

