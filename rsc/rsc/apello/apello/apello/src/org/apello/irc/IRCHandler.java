/*
 *      IRCHandler.java
 *
 *      A bridge between main bot class and the IRCConnection
 */
package org.apello.irc;

public interface IRCHandler{
    public void onConnect();
    public void onDisconnect(String cmd);
    public void onNickAlreadyInUse();
    public void onServerPing();
    public void onTopic(String chan, String topic);
    public void onTopic(String chan, String nick, String ident, String host, String topic);    
    public void onBannedFromChannel(String chan, String msg);
    public void onWhoReply(String channelName, String nick, String ident, String host, String server, String userModes, String real_name);
    public void onCTCPRequest(String commandTarget, String senderNick, String senderIdent, String senderHost, String reqCTCP);
    public void onAction(String channel, String senderNick, String senderIdent, String senderHost, String msg);
    public void onChatMessage(String channel, String senderNick, String senderIdent, String senderHost, String msg);
    public void onPrivateMessage(String senderNick, String senderIdent, String senderHost, String msg);
    public void onNotice(String senderNick, String senderIdent, String senderHost, String msg);
    public void onKick(String channel, String recipient, String senderNick, String senderIdent, String senderHost, String msg);    
    public void onPart(String channel, String senderNick, String senderIdent, String senderHost);
    public void onQuit(String senderNick, String senderIdent, String senderHost, String msg);
    public void onJoin(String channel, String senderNick, String senderIdent, String senderHost);
    public void onNickChange(String senderNick, String senderIdent, String senderHost, String newNick);
    public void onMode(String channel, String senderNick, String senderIdent, String senderHost, String mode);
    public void onInvite(String commandTarget, String senderNick, String senderIdent, String senderHost, String channel);
    public void onUnknown(String s);
}
