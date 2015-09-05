/*
 *      IRCUser.java
 *
 *      Represents a user on the IRC network.
 */

package org.apello.irc;

import java.util.HashMap;

public class IRCUser{    
    public IRCUser(String name, String ident, String host){
        this(name, ident, host, "UNKNOWN", "", "");
    }
    
    public IRCUser(String name, String ident, String host, String server, String modes, String realname){
        userNick = name;
        userIdent = ident;
        userHost = host;
        userServer = server;
        userModes = modes;
        userRealName = realname;
        channels = new HashMap<String, IRCChannel>();
        channelModes = new HashMap<String, String>();
    }
    
    private String userNick;
    private String userIdent;
    private String userHost;
    private String userServer;
    private String userModes;
    private String userRealName;
    private HashMap<String, IRCChannel> channels;
    private HashMap<String, String> channelModes;
    
    // The users nick
    public String getNick(){
        return userNick;
    }
    
    // Set the users nick
    public void setNick(String nick){
        synchronized(userNick){
            userNick = nick;    
        }
    }
    
    // Get the users ident
    public String getIdent(){
        return userIdent;    
    }
    
    // Set the users ident
    public void setIdent(String ident){
        synchronized(userIdent){
            userIdent = ident;
        }
    }
    
    // The users current host
    public String getHost(){
        return userHost;    
    }    
    
    // Set the users host
    public void setHost(String host){
        synchronized(userHost){
            userHost = host;
        }
    }
    
    // returns the server user is connected to
    public String getServer(){
        return userServer;    
    }
    
    // sets the server the user is connected to
    public void setServer(String server){
        synchronized(userServer){
            userServer = server;
        }
    }
    
    //get the users "user specific" modes
    public String getModes(){
        return userModes;    
    }
    
    //set the users "user specific" modes
    public void setModes(String s){
        synchronized(userModes){
            userModes = s;
        }
    }
    
    //set the users modes for a specific channel
    public void setChannelModes(String chan, String modes){
        if(channels.containsKey(chan.toLowerCase())){
            synchronized(channelModes){
                channelModes.put(chan.toLowerCase(), modes);
            }
        }
    }
    
    //return the users modes for a specific channel
    public String getChannelModes(String chan){
        String s = channelModes.get(chan.toLowerCase());
        return s == null ? "" : s;
    }
    
    // get the users real name
    public String getRealName(){
        return userRealName;
    }    
    
    // set the users real name
    public void setRealName(String s){
        synchronized(userRealName){
            userRealName = s;
        }
    }
    
    // get an IRCChannel object that this user is in.
    public IRCChannel getChannel(String n){
        return channels.get(n.toLowerCase());
    }
    
    //number of channels this user is currently in
    public int getChannelCount(){
        return channels.size();
    }
    
    // Add's a channel that we know this user is in. (Handled by IRCConnection thread)
    public void addChannel(IRCChannel c){
        synchronized(channels){
            channels.put(c.getName().toLowerCase(), c);
        }
    }
    
    // remove this user from a channel (handled by main IRCCOnnection thread)
    public void removeChannel(String n){
        synchronized(channels){
            synchronized(channelModes){
                channels.remove(n.toLowerCase());
                channelModes.remove(n.toLowerCase());
            }
        }
    }
    
    // remove this channel from the known channel list for this user
    public void removeChannel(IRCChannel c){
        removeChannel(c.getName());
    }
    
    //is this user in channel n?
    public boolean inChannel(String n){
        return channels.containsKey(n.toLowerCase());
    }
    
    // is this user in channel ch?
    public boolean inChannel(IRCChannel ch){
        return inChannel(ch.getName().toLowerCase());
    }
    
    //does this IRCUser object = IRCUser object o
    public boolean equals(IRCUser o){
        return o.getHost().equalsIgnoreCase(getHost()) && o.getIdent().equalsIgnoreCase(getIdent()) && o.getNick().equalsIgnoreCase(getNick());
    }
}
