/*
 *      IRCChannel.java
 *
 *      Represents an channel on an IRC Server. Holds current users etc.
 */
package org.apello.irc;

import java.util.HashMap;

public class IRCChannel{
    public IRCChannel(String n){
        name = n;
        topic = "";
        users = new HashMap<String, IRCUser>();
    }
    
    private String name = "";// name of this channel
    private HashMap<String, IRCUser> users;//the current users in this chanel.
    private String topic;//channel topic
    
    //The channel's name
    public String getName(){
        return name;
    }
    
    //The channels current topic.
    public String getTopic(){
        return topic;
    }
    
    // Set's the channel's current topic
    public void setTopic(String s){
        synchronized(topic){
            topic = s;
        }
    }
    
    //Add's the user to this channel (Handled by main IRCConnection thread)
    public void addUser(IRCUser u){
        synchronized(users){
            users.put(u.getNick().toLowerCase(), u);
        }
    }
    
    // Returns the user in this channel with nick n, null if user is not in the channel.
    public IRCUser getUser(String n){
        if(n == null || n.length() < 1)
            return null;
        return users.get(n.toLowerCase());
    }
    
    //array of all users in the channel
    public IRCUser[] getUsers(){
        return users.values().toArray(new IRCUser[0]);
    }
    
    //removes the user with nick n from this channel
    public void removeUser(String n){
        if(n == null)
            return;
        synchronized(users){
            users.remove(n.toLowerCase());
        }
    }
    
    //removes the user from this channel
    public void removeUser(IRCUser u){
        removeUser(u.getNick());
    }
    
    // Returns true if the user is in this channel.
    public boolean hasUser(IRCUser u){
        return getUser(u.getNick()) != null && getUser(u.getNick()).equals(u);
    }
}
