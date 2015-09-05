import org.jibble.pircbot.*;

public class irc extends PircBot{
    
    public irc(mudclient mc){
        this.mc = mc;
        this.setName(mc.ircNick);
    }
    protected mudclient mc;
    
    public void onMessage(String channel, String sender, String login, String hostname, String message) {
        mc.onIrcMessage(channel, sender, login, hostname, message);
    }
    
    public void onMode(String channel, String sourceNick, String sourceLogin, String sourceHostname, String mode){
        mc.ircOnMode(channel, sourceNick, sourceLogin, sourceHostname, mode);
    }
    
    public void onNickChange(String oldNick, String login, String hostname, String newNick){
        mc.ircOnNickChange(oldNick, login, hostname, newNick);
    }
    
    public void onKick(String channel, String kickerNick, String kickerLogin, String kickerHostname, String recipientNick, String reason){
       mc.ircOnKick(channel, kickerNick, kickerLogin, kickerHostname, recipientNick, reason);
    }
    
    public void onQuit(String sourceNick, String sourceLogin, String sourceHostname, String reason){
        mc.ircOnQuit(sourceNick, sourceLogin, sourceHostname, reason);
    }
    
    public void onJoin(String channel, String sender, String login, String hostname){
        mc.ircOnJoin(channel, sender, login, hostname);
    }
    
    public void onPart(String channel, String sender, String login, String hostname){
        mc.ircOnPart(channel, sender, login, hostname);
    }
    
    public void onTopic(String channel, String topic, String setBy, long date, boolean changed){
        mc.ircOnTopic(channel, topic, setBy, date, changed);
    }

    public void	onAction(String sender, String login, String hostname, String target, String action){
        mc.ircOnAction(sender, login, hostname, target, action);
    }
    
    public void	onNotice(String sender, String login, String hostname, String target, String notice){
        mc.ircOnAction(sender, login, hostname, target, notice);
    }
    
    public void onPrivateMessage(String sender, String login, String hostname, String message){
        mc.ircOnPrivateMessage(sender,login,hostname,message);
    }
}