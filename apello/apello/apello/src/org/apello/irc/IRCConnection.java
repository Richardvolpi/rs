/*
 *      IRCConnection.java
 *
 *      Maintains the connection to an IRC server.
 */
package org.apello.irc;

import org.apello.util.Config;
import org.apello.util.Logger;

import java.util.List;
import java.util.StringTokenizer;
import java.util.HashMap;

public class IRCConnection extends Connection{
    public IRCConnection(IRCHandler ih, String server, int port, String password) throws Exception{
        super(server, port);
        handler = ih;
        conf = Config.getGlobalConfig();
        users = new HashMap<String, IRCUser>();
        channels = new HashMap<String, IRCChannel>();
        if(password != null && password.length() > 0)
            sendLine("PASS " + conf.getString("server"));
        setNick(conf.getString("nick"));
        curIdent = conf.getString("ident");
        sendLine("USER " + curIdent + " 8 * :" + curIdent);
    }
    
    Config conf = null;//global bot config
    private IRCHandler handler = null;
    private String curNick = ""; //the current nick of the bot
    private String curIdent = "";
    private String curHost = "";
    private boolean loggedIn = false;//whether or not the IRCServer thinks were connected or not
    private HashMap<String, IRCUser> users = null;//all of the users this bot knows
    private HashMap<String, IRCChannel> channels = null;//all of the channels this bot is in
    
    // Get's the commands sent from the server, then process over each one.
    public void processServerResponses(){
        List<String> cmds = getIncoming();
        for(int i = 0; i < cmds.size(); i++)
            processServerResponse(cmds.get(i));
    }
    
    // Analyze the command to see what we should do with it.
    public void processServerResponse(String cmd){
        if(cmd == null){
            return;    
        }
        if(checkCode(cmd))
            return;
        if(!isConnected() || cmd.length() < 5)
            return;
            
        if(cmd.startsWith("PING")){
            sendLine("PONG " + cmd.substring(5));
            onServerPing();
            return;
        }else if(cmd.startsWith("ERROR")){
            onDisconnect(cmd);
            return;
        }
        String senderNick = null;
        String senderIdent = null;
        String senderHost = null;
        String commandTarget = null;
        String senderDetails = null;
        String newCommand = null;
        
        StringTokenizer tokenizer = new StringTokenizer(cmd);

        try {
            senderDetails = tokenizer.nextToken();
            newCommand = tokenizer.nextToken().toUpperCase();
        } catch (Exception e) {
            return;
        }
        int exSymbol = senderDetails.indexOf("!");
        int atSymbol = senderDetails.indexOf("@");

        if (senderDetails.startsWith(":")) {
            if (exSymbol > 0 && atSymbol > 0 && exSymbol < atSymbol) {
                senderNick = senderDetails.substring(1, exSymbol);
                senderIdent = senderDetails.substring(exSymbol + 1, atSymbol);
                senderHost = senderDetails.substring(atSymbol + 1);
            } else if (tokenizer.hasMoreTokens()) {
                try {
                    Integer.parseInt(newCommand);
                    return;
                } catch (Exception e) {
                    senderNick = senderDetails;
                    commandTarget = newCommand;
                }
            } else {
                return;
            }
        }else{
            return;
        }
        if (senderNick == null || newCommand == null) {
            return;
        }
        if (senderNick.startsWith(":")) {
            senderNick = senderNick.substring(1);
        }
        if (commandTarget == null) {
            commandTarget = tokenizer.nextToken();
        }
        if (commandTarget.startsWith(":")) {
            commandTarget = commandTarget.substring(1);
        }
        
        if(newCommand.equals("PRIVMSG")){
            if(cmd.indexOf(":\u0001") > 0) {
                onCTCPRequest(commandTarget, senderNick, senderIdent, senderHost, cmd.substring(cmd.indexOf(":\u0001") + 2, cmd.length() - 1));
            }else if(commandTarget.startsWith("#")){
                onChatMessage(commandTarget, senderNick, senderIdent, senderHost, cmd.substring(cmd.indexOf(" :") + 2));
            }else{
                onPrivateMessage(senderNick, senderIdent, senderHost, cmd.substring(cmd.indexOf(" :") + 2));
            }
        }else if(newCommand.equals("NOTICE")){
            String noticeMessage = cmd.substring(cmd.indexOf(" :") + 2);
            if(commandTarget.startsWith("#")) {
                onChatMessage(commandTarget, senderNick, senderIdent, senderHost, noticeMessage);
            }else{
                onNotice(senderNick, senderIdent, senderHost, noticeMessage);
            }
        }else if(newCommand.equals("KICK")){
            String recipient = tokenizer.nextToken();
            onKick(commandTarget, recipient, senderNick, senderIdent, senderHost, cmd.substring(cmd.indexOf(" :") + 2));
        }else if(newCommand.equals("PART")){
            onPart(commandTarget, senderNick, senderIdent, senderHost);
        }else if(newCommand.equals("QUIT")){
            onQuit(senderNick, senderIdent, senderHost, cmd.substring(cmd.indexOf(" :") + 2));
        }else if (newCommand.equals("JOIN")){
            String channel = cmd.substring(cmd.indexOf(" :") + 2);
            onJoin(channel, senderNick, senderIdent, senderHost);
        }else if (newCommand.equals("NICK")){
            String newNick = cmd.substring(cmd.indexOf(" :") + 2);
            onNickChange(senderNick, senderIdent, senderHost, newNick);            
        }else if(newCommand.equals("MODE")){
            String mode = cmd.substring(cmd.indexOf(cmd, 2) + cmd.length() + 1);
            if (mode.startsWith(":")) {
                mode = mode.substring(1);
            }
            onMode(commandTarget, senderNick, senderIdent, senderHost, mode);
        }else if(newCommand.equals("INVITE")){
            onInvite(commandTarget, senderNick, senderIdent, senderHost, cmd.substring(cmd.indexOf(" :") + 2));
        }else{
            onUnknown(cmd);
        }
    }
    
    // Checks for numerical constant commands
    private boolean checkCode(String cmd){
        int firstSpace = cmd.indexOf(" ");
        int secondSpace = cmd.indexOf(" ", firstSpace + 1);
        
        if(secondSpace > -1){
            String code = cmd.substring(firstSpace + 1, secondSpace);
            
            if (code.equals("004")) {//connected
                loggedIn = true;
                onConnect();
            } else if (code.equals("433")) {//Nick already in use          // && !ircConnected
                onNickAlreadyInUse();
            } else if (code.equals("332")) {
                String channel = cmd.substring(
                        cmd.toLowerCase().indexOf(getNick().toLowerCase()) + getNick().length() + 1,
                        cmd.indexOf(" :"));
                String topic = cmd.substring(cmd.indexOf(" :") + 2);
                onTopic(channel, topic);
            } else if (code.equals("474")) {
                String channel = cmd.substring(cmd.toLowerCase().indexOf(getNick().toLowerCase()) + getNick().length() + 1, cmd.indexOf(" :"));
                onBannedFromChannel(channel, cmd.substring(cmd.indexOf(" :") + 2));
            }else if (code.equals("352")){//reply to a WHO command
                String[] m = cmd.substring((cmd.indexOf(" ", secondSpace + 1) + 1), cmd.indexOf(" :0")).trim().split(" ");
                /*
                onWhoReply(m[0], m[1], m[2], m[3], m[4], m[5], cmd.substring(cmd.indexOf(":0") + 2));
                onWhoReply(String channelName, String ident, String host, String server, String nick, String userModes, String real_name);
                <-- Left these here so we know what = what in the array later if needed.
                public void onWhoReply(String channelName, String nick, String ident, String host, String server, String userModes, String real_name){
                */ 
                onWhoReply(m[0], m[4], m[1], m[2], m[3], m[5], cmd.substring(cmd.indexOf(":0") + 2));
            }
            
            try {
                Integer.parseInt(code);
                return true;//a hack for all un supported all numeric replies specified numeric reply constants
            } catch (Exception e) {}
        }
        return false;
    }
    
    // Are we logged into the irc server?
    public boolean isLoggedIn(){
        return loggedIn;
    }
    
    // Gets the channel object by the channel name, returns null if
    // no channel object exists (We arn't in the channel)
    public IRCChannel getChannel(String n){
        return channels.get(n.toLowerCase());
    }
    
    //Creates a channel object with name n.
    public void addChannel(IRCChannel c){
        synchronized(channels){
            channels.put(c.getName().toLowerCase(), c);
        }
    }
    
    // Removes channel with the name specified, also loops through users and removes the 
    // channel from each user objects local channel list as well.
    // We possibly should leave the reference to each channel object in each user, but that would mean
    // you would need to search for each channel object in each known user every time you wanted to create a
    // new channel object (to stop duplicates of the same channel because each User maintains it's own channel 
    // list with references to the same "mother" objects).
    public void removeChannel(String n){
        IRCChannel ch = null;
        synchronized(channels){
            ch = channels.remove(n.toLowerCase());
        }
        if(ch == null)
            return;
        
        IRCUser[] u = ch.getUsers();
        for(int i = 0; i < u.length; i++)
            if(u[i].inChannel(ch.getName()))
                u[i].removeChannel(ch.getName());
    }

    //remove the channel object
    public void removeChannel(IRCChannel c){
        removeChannel(c.getName());
    }

    public boolean inChannel(String n){
        return channels.containsKey(n.toLowerCase());
    }

    //Add's the user to this channel
    public void addUser(IRCUser u){
        synchronized(users){
            users.put(u.getNick().toLowerCase(), u);
        }
    }

    // Returns the user if we know about them
    public IRCUser getUser(String nick){
        if(nick == null)
            return null;
        return users.get(nick.toLowerCase());
    }
    
    public IRCUser[] getUsers(){
        return users.values().toArray(new IRCUser[0]);
    }
    
    // Returns true if the bot knows this user
    public boolean knowsUser(String n){
        return users.containsKey(n.toLowerCase());
    }
    
    // Remove the user from the known user list
    public void removeUser(IRCUser u){
        removeUserCompletely(u);
    }
    
    // Remove the user from the known user list
    public void removeUser(String n){
        removeUserCompletely(getUser(n));
    }
    
    //remove the user from the known user list, and remove the user from all channels he is in.
    public void removeUserCompletely(IRCUser u){
        synchronized(users){
            users.remove(u.getNick().toLowerCase());
        }
        IRCChannel[] chs = channels.values().toArray(new IRCChannel[0]);
        for(int i = 0; i < chs.length; i++)
            if(chs[i].hasUser(u))
                chs[i].removeUser(u);
    }
    
    // Our current nick on the server
    public String getNick(){
        return curNick;
    }
    
    // Change our nick
    public void setNick(String nick){
        synchronized(curNick){
            curNick = nick;
        }
        sendLine("NICK " + nick);
    }
    
    public String getIdent(){
        return curIdent;
    }
    
    public String getHost(){
        return "localhost";//FIX ME
    }
    
    public void sendMessage(String target, String msg){
        sendLine("PRIVMSG " + target + " :" + msg);
        if(target.startsWith("#")){
            onChatMessage(target, getNick(), getIdent(), getHost(), msg);    
        }else{
            onPrivateMessage(getNick(), getIdent(), getHost(), msg);
        }
    }
    
    public final void sendCTCPCommand(String target, String command) {
        sendLine("PRIVMSG " + target + " :\u0001" + command + "\u0001");
    }
    
    public final void sendNotice(String target, String msg){
        sendLine("NOTICE " + target + " :" + msg);
    }
    
    public final void sendAction(String target, String action) {
        sendCTCPCommand(target, "ACTION " + action);
    }
    
    public final void joinChannel(String chan){
        sendLine("JOIN " + chan);
    }
    
    public final void joinChannel(String chan, String pass){
        joinChannel(chan + " " + pass);
    }
    
    public final void partChannel(String chan){
        sendLine("PART " + chan);
    }
    
    public final void partChannel(String chan, String reason){
        partChannel(chan + " :" + reason);
    }
    
    public final void quitServer(){
        quitServer("");
    }
    
    public final void quitServer(String reason){
        sendLine("QUIT :" + reason);
    }
    
    public final void setMode(String target, String mode){
        sendLine("MODE " + target + " " + mode);
    }
    
    public final void sendInvite(String nick, String channel) {
        sendLine("INVITE " + nick + " :" + channel);
    }
    
    public final void kick(String channel, String nick) {
        kick(channel, nick, "");
    }
    
    public final void kick(String channel, String nick, String reason) {
        sendLine("KICK " + channel + " " + nick + " :" + reason);
    }
    
    // onConnect event
    public void onConnect(){
        handler.onConnect();
        
    }
    
    public void onDisconnect(String cmd){
        loggedIn = false;
        System.out.println("Disconnected, : " + cmd);
        close();
        handler.onDisconnect(cmd);
    }
    
    // NickAlreadyInUseEvent
    public void onNickAlreadyInUse(){
        if(!loggedIn){
            Logger.logD(curNick + " is already in use, picking random nick.");
            String newNick = getNick() + (new java.util.Random().nextInt(99 - 10 + 1) + 10);
            setNick(newNick);
            return;
        }
        handler.onNickAlreadyInUse();
    }    
    
    public void onServerPing(){
        handler.onServerPing();
    }
    
    public void onTopic(String chan, String topic){
        IRCChannel ch = getChannel(chan);
        if(ch == null)//shouldnt happen
            return;
        else
            ch.setTopic(topic);
        handler.onTopic(chan, topic);
    }
    
    public void onTopic(String chan, String nick, String ident, String host, String topic){
        IRCChannel ch = getChannel(chan);
        if(ch == null)//shouldnt happen
            return;
        else
            ch.setTopic(topic);
        handler.onTopic(chan, nick, ident, host, topic);
    }
    
    public void onBannedFromChannel(String chan, String msg){
        handler.onBannedFromChannel(chan, msg);
    }
    
    public void onWhoReply(String channelName, String nick, String ident, String host, String server, String userModes, String real_name){
        IRCChannel chan = getChannel(channelName);
        if(chan == null){//we dont currently know about this channel, but we probably should
            chan = new IRCChannel(channelName);
            addChannel(chan);
        }
        
        //check to see if we already know this user, or if he's new.
        IRCUser user = getUser(nick);
        if(user == null){//unknown user, so create it.
            user = new IRCUser(nick, ident, host);
            addUser(user);
        }
        if(!user.getServer().equals(server))
            user.setServer(server);
        if(!user.getRealName().equals(real_name))
            user.setRealName(real_name);
            
        if(!user.inChannel(chan))
            user.addChannel(chan);
        if(!chan.hasUser(user))
            chan.addUser(user);
                        
        if(!user.getChannelModes(channelName).equals(userModes))
            user.setChannelModes(channelName, userModes);
        
        handler.onWhoReply(channelName, nick, ident, host, server, userModes, real_name);
    }
    
    public void onCTCPRequest(String commandTarget, String senderNick, String senderIdent, String senderHost, String reqCTCP){
        handler.onCTCPRequest(commandTarget, senderNick, senderIdent, senderHost, reqCTCP);   
    }
    
    public void onAction(String channel, String senderNick, String senderIdent, String senderHost, String msg){
        handler.onAction(channel, senderNick, senderIdent, senderHost, msg);
    }
    
    public void onChatMessage(String channel, String senderNick, String senderIdent, String senderHost, String msg){
        handler.onChatMessage(channel, senderNick, senderIdent, senderHost, msg);
    }
    
    public void onPrivateMessage(String senderNick, String senderIdent, String senderHost, String msg){
        handler.onPrivateMessage(senderNick, senderIdent, senderHost, msg);
    }
    
    public void onNotice(String senderNick, String senderIdent, String senderHost, String msg){
        handler.onNotice(senderNick, senderIdent, senderHost, msg);
    }
    
    public void onKick(String channel, String recipient, String senderNick, String senderIdent, String senderHost, String msg){
        IRCChannel ch = getChannel(channel);
        if(ch == null){
            Logger.logD("ERROR: onKick channel not found: " + channel);
        }
        if(recipient.equalsIgnoreCase(getNick())){
            removeChannel(channel);
        }else{
            ch.removeUser(senderNick);
        }
        
        handler.onKick(channel, recipient, senderNick, senderIdent, senderHost, msg);
    }
    
    public void onPart(String channel, String senderNick, String senderIdent, String senderHost){
        IRCChannel ch = getChannel(channel);
        if(ch == null){
            Logger.logD("ERROR: onPart channel not found: " + channel);
        }else{
            if(senderNick.equalsIgnoreCase(getNick())){
                removeChannel(channel);
            }else{
                ch.removeUser(senderNick);
            }
        }
        handler.onPart(channel, senderNick, senderIdent, senderHost);
    }
    
    public void onQuit(String senderNick, String senderIdent, String senderHost, String msg){
        if(senderNick.equalsIgnoreCase(getNick())){
            Logger.logD("Bot Quit");
            close();
            loggedIn = false;
        }else{
            IRCUser u = getUser(senderNick);
            if(u != null)
                removeUserCompletely(u);
        }
        
        handler.onQuit(senderNick, senderIdent, senderHost, msg);
    }
    
    public void onJoin(String channel, String senderNick, String senderIdent, String senderHost){
        if(senderNick.equalsIgnoreCase(getNick())){
            addChannel(new IRCChannel(channel));
            sendLine("WHO +c " + channel);//update the user list for this channel
        }else{
            addUser(new IRCUser(senderNick, senderIdent, senderHost));
            sendLine("WHO +n " + senderNick + " " + channel);
        }
        handler.onJoin(channel, senderNick, senderIdent, senderHost);
    }
    
    public final void onNickChange(String senderNick, String senderIdent, String senderHost, String newNick){
        if(senderNick.equalsIgnoreCase(getNick())){
            curNick = newNick;
        }else{
            IRCUser u = getUser(senderNick);
            if(u != null)
                u.setNick(newNick);
        }
        handler.onNickChange(senderNick, senderIdent, senderHost, newNick);
    }
    
    public final void onMode(String channel, String senderNick, String senderIdent, String senderHost, String mode){
        handler.onMode(channel, senderNick, senderIdent, senderHost, mode);
    }
    
    public final void onInvite(String commandTarget, String senderNick, String senderIdent, String senderHost, String channel){
        handler.onInvite(commandTarget, senderNick, senderIdent, senderHost, channel);
    }
    
    public final void onUnknown(String s){
        handler.onUnknown(s);
    }
}
