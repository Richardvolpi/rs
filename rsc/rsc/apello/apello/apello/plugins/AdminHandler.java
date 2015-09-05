/*
 *      AdminHandler.java
 */
 
import org.apello.plugins.*;
import org.apello.irc.*;
import org.apello.util.*;

import java.util.HashMap;

public class AdminHandler extends PluginAdapter {
    public AdminHandler(){}
    private HashMap<String, String> admins;
    private HashMap<String, String[]> idedAdmins;
    
    public String getPluginName(){
        return "AdminHandler";
    }
    
    public void init(String args){
        admins = new HashMap<String, String>();
        String names[] = args.trim().split(" ");
       // log("Args = "+ args);
        for(int i = 0; i < names.length; i++){
            String[] tmp = names[i].split(":");
            if(tmp.length < 2 || tmp[0].length() < 1 || tmp[1].length() < 1)
                continue;
            admins.put(tmp[0], tmp[1]);
        }
        idedAdmins =  new HashMap<String, String[]>();
        
        // Let other plugins call these methods:
        addGlobalMethod("isAdmin", new Class[]{String.class, String.class, String.class});
        addGlobalMethod("adminRespond", new Class[]{String.class, String.class, String.class});
    }
    
    public void process(){
        //log("Process");
    }
    
    public void dispose(){
        log("dispose");
    }
    
    //return true if the nick is registerd
    public boolean isAdmin(String nick, String ident, String host){
        if(idedAdmins.containsKey(nick)){
            String[] n = idedAdmins.get(nick);
            return n != null && (nick.equals(n[0]) && (ident == null || ident.equals(n[1])) && (host == null || host.equals(n[2])));
        }
        return false;
    }
    
    public void onNotice(String senderNick, String senderIdent, String senderHost, String msg){
        if(msg.startsWith("--")){
            processMessage("NOTICE", senderNick, senderIdent, senderHost, msg);
        }
    }

    public void onChatMessage(String channel, String senderNick, String senderIdent, String senderHost, String msg){
        if(msg.startsWith("--")){
            processMessage(channel, senderNick, senderIdent, senderHost, msg);
        }
    }
    
    public void onPrivateMessage(String senderNick, String senderIdent, String senderHost, String msg){
        if(msg.startsWith("--")){
            processMessage("PRIVMSG", senderNick, senderIdent, senderHost, msg);
        }
    }
    
    public void processMessage(String replyMethod, String senderNick, String senderIdent, String senderHost, String msg){
        try{
            msg = msg.substring(2, msg.length());
            
            int firstSpace = msg.indexOf(" ");
            
            String[] args = new String[0];
            //log(msg);
            if(firstSpace > 0)
                args = msg.trim().substring(firstSpace + 1, msg.length()).split(" ");
            
            if(msg.toLowerCase().startsWith("login")){
                if(args.length < 2){
                    adminRespond(replyMethod, senderNick, "Invalid syntax, correct usage: \"--login userName passWord\"");
                    return;
                }
                
                if(args[0].length() < 1 || args[1].length() < 1){
                    adminRespond(replyMethod, senderNick, "Invalid syntax, correct usage: \"--login userName passWord\"");
                    return;
                }
                String p = admins.get(args[0]);
                if(p != null && p.length() > 0){
                    if(p.equals(args[1])){
                        idedAdmins.put(senderNick, new String[]{senderNick, senderIdent, senderHost});
                        log(senderNick + "!" + senderIdent + "@" + senderHost + " is now known as an administrator.");
                        adminRespond(replyMethod, senderNick, "You are now recognized as admin.");
                        return;
                    }
                }
                adminRespond(replyMethod, senderNick, "Invalid username or password.");
                return;
            }else if(!isAdmin(senderNick, senderIdent, senderHost)){
                return;
            }else if(msg.toLowerCase().startsWith("shutdown")){
                adminRespond(replyMethod, senderNick, "NOt implemented yet because im a lazy bastard");
                return;
            }else if(msg.toLowerCase().startsWith("msg")){
                if(args.length < 2){
                    adminRespond(replyMethod, senderNick, "Invalid Syntax, correct usage: \"--msg channelOrUserName message to send\"");
                    return;
                }
                
                irc.sendMessage(args[0], msg.substring(msg.indexOf(" ", firstSpace + 1) + 1, msg.length()));
                return;
            }else if(msg.toLowerCase().startsWith("raw")){
                
                irc.sendLine(msg.substring(firstSpace, msg.length()));
                return;
            }else if(msg.toLowerCase().startsWith("load")){
                if(args.length < 1){
                    adminRespond(replyMethod, senderNick, "Invalid Syntax, correct usage: \"--load PluginName plugin arguments go here\"");
                    return;
                }
                
                String pname = args[0].trim();
                if(pname.length() < 1){
                    adminRespond(replyMethod, senderNick, "Invalid Syntax, correct usage: \"--load PluginName plugin arguments go here\"");
                    return;
                }
                
                if(handler.isLoaded(pname)){
                    adminRespond(replyMethod, senderNick, "Plugin <" + pname + "> is loaded already. You must unload it before you may load it again. (--unload)");
                    return;
                }
                String pargs = "";
                if(msg.indexOf(" ", firstSpace + 1) > 0 && msg.indexOf(" ", firstSpace + 1) + 1 < msg.length()){
                    pargs = msg.substring(msg.indexOf(" ", firstSpace + 1) + 1, msg.length());
                }
                try{
                    handler.loadPlugin(pname, pargs);
                }catch(Exception e){
                    adminRespond(replyMethod, senderNick, "Error Loading Plugin <" + pname + ">: " + e.getMessage());
                    return;
                }
                PluginAdapter pa = handler.getPlugin(pname);
                if(pa != null && irc != null)
                    pa.addEvent(new PluginMethod("setConnection", new Object[]{irc}));
                adminRespond(replyMethod, senderNick, "Plugin <" + pname + "> loaded successfully.");
                return;
            }else if(msg.toLowerCase().startsWith("unload")){
                if(args.length < 1){
                    adminRespond(replyMethod, senderNick, "Invalid Syntax, correct usage: \"--unload PluginName");
                    return;
                }
                
                String pname = args[0].trim();
                if(pname.length() < 1){
                    adminRespond(replyMethod, senderNick, "Invalid Syntax, correct usage: \"--unload PluginName");
                    return;
                }
                
                if(!handler.isLoaded(pname)){
                    adminRespond(replyMethod, senderNick, "Plugin <" + pname + "> is not loaded. You must load it before you may unload it. (--load)");
                    return;
                }
                
                try{
                    handler.unloadPlugin(pname);
                }catch(Exception e){
                    adminRespond(replyMethod, senderNick, "Error Unloading Plugin <" + pname + ">: " + e.getMessage());
                    return;
                }
                adminRespond(replyMethod, senderNick, "Plugin <" + pname + "> Unloaded successfully.");
                return;
            }else if(msg.toLowerCase().startsWith("reload")){
                if(args.length < 1){
                    adminRespond(replyMethod, senderNick, "Invalid Syntax, correct usage: \"--reload PluginName plugin Args");
                    return;
                }
                
                String pname = args[0].trim();
                if(pname.length() < 1){
                    adminRespond(replyMethod, senderNick, "Invalid Syntax, correct usage: \"--unload PluginName\"");
                    return;
                }
                
                if(handler.isLoaded(pname)){
                    try{
                        handler.unloadPlugin(pname);
                    }catch(Exception e){
                        adminRespond(replyMethod, senderNick, "Error Unloading Plugin <" + pname + ">: " + e.getMessage());
                        return;
                    }
                    adminRespond(replyMethod, senderNick, "Plugin <" + pname + "> unloaded successfully.");
                }
                
                try{
                   handler.loadPlugin(pname, msg.substring(msg.indexOf(" ", firstSpace + 1) + 1, msg.length()));
                }catch(Exception e){
                    adminRespond(replyMethod, senderNick, "Error Loading Plugin <" + pname + ">: " + e.getMessage());
                    return;
                }
                PluginAdapter pa = handler.getPlugin(pname);
                if(pa != null && irc != null)
                    pa.addEvent(new PluginMethod("setConnection", new Object[]{irc}));
                adminRespond(replyMethod, senderNick, "Plugin <" + pname + "> loaded successfully.");
                return;
            }else if(msg.toLowerCase().startsWith("join")){
                if(args.length < 1 || args[0].length() < 0){
                    adminRespond(replyMethod, senderNick, "Invalid Syntax, correct usage: \"--join channelName [optionallyChannelPass]");
                    return;
                }
                String p = "";
                if(args.length > 1 && args[1].length() > 0)
                    irc.joinChannel(args[0], args[1]);
                else
                    irc.joinChannel(args[0]);
            }else if(msg.toLowerCase().startsWith("part")){
                if(args.length < 1 || args[0].length() < 0){
                    adminRespond(replyMethod, senderNick, "Invalid Syntax, correct usage: \"--join channelName [optionallyChannelPass]");
                    return;
                }
                irc.partChannel(args[0], msg.substring(msg.indexOf(" ", firstSpace + 1) + 1, msg.length()));
            }else{
                //unhandled admin command...
                handler.addEvent(new PluginMethod("onAdminCommand", new Object[]{replyMethod, senderNick, senderIdent, senderHost, msg}));
                return;
            }
        }catch(Exception e){
            adminRespond(replyMethod, senderNick, "Error: " + e.getMessage());
            return;
        }
    }
    
    public void adminRespond(String replyMethod, String nick, String msg){
        if(replyMethod.equalsIgnoreCase("NOTICE")){
            irc.sendNotice(nick, msg);
        }else if(replyMethod.equalsIgnoreCase("PRIVMSG")){
            irc.sendMessage(nick, msg);
        }else{
            irc.sendMessage(replyMethod, msg);
        }
    }
}
