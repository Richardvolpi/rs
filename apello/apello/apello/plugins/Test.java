/*
 *      ChannelLock.java
 */
 
import org.apello.plugins.*;
import org.apello.util.*;
import org.apello.irc.*;

import java.util.Random;
import java.util.HashMap;

public class Test extends PluginAdapter {
    public Test(){}
    
    public String getPluginName(){
        return "Test";
    }
    
    private int rejoinDelay = 10;
    private HashMap<String, String> channels;
    
    
    public void init(String args)throws Exception{
    }
    
    public void process(){
    }
    
    public void dispose(){
        log("dispose");
    }
    
    public void onCommandMessage(String replyMethod, String nick, String ident, String host, String cmd, String msg){
        try{
            if(cmd.equalsIgnoreCase("test")){
                handler.globalMethod("commandRespond", new Object[]{replyMethod, nick, "THE BITCH FUCKING WORKS!!!"});
            }
        }catch(Exception e){
            try{
                handler.globalMethod("commandRespond", new Object[]{replyMethod, nick, "Error: " + e.getMessage()});
            }catch(Exception ee){
                log("This plugin requires the AliasHandler plugin, please besure it is loaded");
            }
        }
    }
}
