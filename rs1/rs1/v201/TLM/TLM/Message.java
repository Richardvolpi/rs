class Message {
    public static final int PRIVATE_MESSAGE=0, SERVER_MESSAGE=1,CHAT_MESSAGE=2;
    private String message,extI;
    private int type;
    public Message(int type, String msg) {
        this(type,msg,"");
    }
    public Message(int type, String msg, String extI) {
        this.type = type;
        this.message = msg.trim();
        this.extI = extI.trim();
    }
    public boolean isPrivateMessage() { return type == Message.PRIVATE_MESSAGE; }
    public boolean isServerMessage() { return type == Message.SERVER_MESSAGE; }
    public boolean isChatMessage() { return type == Message.CHAT_MESSAGE; }
    public int getType() { return type; }
    public String getMessage() { return message; }
    public String getExtraInfo() { return extI; }
}