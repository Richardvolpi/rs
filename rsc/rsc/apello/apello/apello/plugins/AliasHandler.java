/*
 *      AliasHandler.java
 */
 
import org.apello.plugins.*;
import org.apello.util.*;
import org.apello.irc.*;

import java.io.*;
import java.net.*;

public class AliasHandler extends PluginAdapter {
    public AliasHandler(){}
    
    public String getPluginName(){
        return "AliasHandler";
    }
    
    private long command_LastSent; //spam filter for processCommand
    private String command_LastNick;//spam filter for processCommand
    private boolean recievedCommandFlag;//spam filter for processCommand
    
    public void init(String args){
        addGlobalMethod("commandRespond", new Class[]{String.class, String.class, String.class});
        command_LastSent = System.currentTimeMillis();
        command_LastNick = "";
        recievedCommandFlag = false;
    }
    public void process(){}
    public void dispose(){}
    
    public void onNotice(String senderNick, String senderIdent, String senderHost, String msg){
        if(msg.startsWith("!")){
            processMessage("NOTICE", senderNick, senderIdent, senderHost, msg);
        }
    }

    public void onChatMessage(String channel, String senderNick, String senderIdent, String senderHost, String msg){
        if(msg.startsWith("!")){
            processMessage(channel, senderNick, senderIdent, senderHost, msg);
        }
    }
    
    public void onPrivateMessage(String senderNick, String senderIdent, String senderHost, String msg){
        if(msg.startsWith("!")){
            processMessage("PRIVMSG", senderNick, senderIdent, senderHost, msg);
        }
    }
    
    public void commandRespond(String replyMethod, String nick, String msg){
        if(replyMethod.equalsIgnoreCase("NOTICE")){
            irc.sendNotice(nick, msg);
        }else if(replyMethod.equalsIgnoreCase("PRIVMSG")){
            irc.sendMessage(nick, msg);
        }else{
            irc.sendMessage(replyMethod, msg);
        }
        if(recievedCommandFlag){
            recievedCommandFlag = false;
            command_LastSent = System.currentTimeMillis();
            if(replyMethod.startsWith("#"))
                command_LastNick = nick;
        }
    }
    
    public void processMessage(String replyMethod, String senderNick, String senderIdent, String senderHost, String msg){
        try{
            Boolean b = (Boolean)handler.globalMethod("isAdmin", new Object[]{senderNick, senderIdent, senderHost});
            if((b == null || !b.booleanValue()) && (System.currentTimeMillis() - command_LastSent < 5000 || (replyMethod.startsWith("#") && senderNick.equalsIgnoreCase(command_LastNick) && System.currentTimeMillis() - command_LastSent < 120000))){//spam filter
                commandRespond("NOTICE", senderNick, "Command not processed due to spam throttling");
                return;
            }
            int firstSpace = msg.indexOf(" ");
            
            String cmd = msg.substring(1, firstSpace > -1 ? firstSpace : msg.length());
            msg = firstSpace > 0 && firstSpace < msg.length() ? msg.substring(firstSpace + 1, msg.length()) : "";
            
            String[] args = new String[0];
            if(msg.length() > 0)
                args = msg.trim().split(" ");
                
            recievedCommandFlag = true;
            
            handler.addEvent(new PluginMethod("onCommandMessage", new Object[]{replyMethod, senderNick, senderIdent, senderHost, cmd, msg}));
        }catch(Exception e){
            commandRespond(replyMethod, senderNick, "Error: " + e.getMessage());
            return;
        }
    }
}
