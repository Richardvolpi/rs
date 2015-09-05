/*
 *      AutoIdentify.java
 */
 
import org.apello.plugins.*;
import org.apello.util.*;
import org.apello.irc.*;

import java.util.Random;

public class AutoIdentify extends PluginAdapter {
    public AutoIdentify(){}
    
    public String getPluginName(){
        return "AutoIdentify";
    }
    
    private String nick;
    private String password;
    
    public void init(String args)throws Exception{
        String[] tmp = args.split(":");
        if(tmp.length < 2){
            throw new Exception("The syntax for the args passed to this plugin is \"username:password\"");
        }
            
        nick = tmp[0];
        password = tmp[1];
        setDelay(10000);
    }
    
    public void process(){
        if(irc.getNick() != nick){
            log("Setting nick to: " + nick);
            irc.setNick(nick);
        }
    }
    
    public void dispose(){
        log("dispose");
    }
    
    public void onNickAlreadyInUse(){
        irc.setNick(nick + "" + (new java.util.Random().nextInt(99 - 10 + 1) + 10));
        log("Ghosting Impersonator...");
        if(irc.getNick() != nick)
            irc.sendMessage("nickserv", "ghost " + nick + " " + password);
    }
    
    public void onNotice(String senderNick, String senderIdent, String senderHost, String msg){
        if(senderNick.equalsIgnoreCase("nickserv") && (msg.contains("This nickname is registered and protected.") || msg.contains("This nickname is owned by someone else"))){
            irc.sendMessage("nickserv", "identify " + password);
        }
    }
}
