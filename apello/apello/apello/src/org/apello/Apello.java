/*
 *      Apello.java
 */
package org.apello;

import org.apello.irc.IRCConnection;
import org.apello.irc.IRCHandler;
import org.apello.util.Logger;
import org.apello.util.Config;
import org.apello.plugins.PluginHandler;
import org.apello.plugins.PluginMethod;

import java.util.Date;
import java.text.DateFormat;

public class Apello implements IRCHandler{
    public static void main (String args[]){
        Apello ap = new Apello();
        ap.init(args);
        ap.process();
    }
    
    public Apello(){
        Logger.logD("Apello v" + Apello.VERSION);
    }
    
    public static String VERSION = "2.1.0";//bot version
    private Config conf = null;//Bot configuration storage
    private Logger log = null;//Loging daemon
    private PluginHandler plugins = null;//plugin handler
    private boolean running = false;//If the bot is running or not.
    private boolean connected = false;//Are we connected to the server?
    private IRCConnection conn = null;//the connection to the server
    private int disconnectCount = 0;//Total times we have been disconnected from the server.
    private int MAIN_THREAD_SLEEP = 10;//Main thread delay
    private long lastConnected = 0L;//time when we last connected to the server.
    
    // Start the bot up, load configuration and start logging, and load Default Scripts
    public void init(String[] args){
        String path = null;
        for(int i = 0; i < args.length; i++){
            if(args[i].toLowerCase().startsWith("config-path=") && args[i].length() > 7){
                path = args[i].substring(12, args[i].length()).trim();
            }
        }
        if(path == null)
            path = Config.getDefaultValue("config-path");
        Logger.logD("Loading configuration file: " + path);
        conf = new Config(path);
        conf.processArgs(args);
        Config.setGlobalConfig(conf);
        try{
            log = new Logger(conf.getValue("log-path"));
            Logger.setGlobalLogger(log);
        }catch(Exception e){
            fatalError("Failed to open log file, \"" + conf.getValue("log-path") + "\": " + e.getMessage());
        }
        loadPlugins();
        disconnectCount = 0;
    }
    
    // The main processing loop
    public void process(){
        running = true;
        Logger.logD("Apello Started");
        while(running){
            try{
                Thread.sleep(MAIN_THREAD_SLEEP);
            }catch(Exception e){}
            if(conn == null || !conn.isConnected() || !connected){
                connect();
            }
            conn.processServerResponses();
        }
    }
    
    //Load the plugins.
    public void loadPlugins(){
        Logger.logD("Loading Plugins");
        plugins = new PluginHandler(conf.getString("plugin-path"));
        String[] tmp = conf.getKeys();
        for(int i = 0; i < tmp.length; i++){
            if(tmp[i].toLowerCase().startsWith("plugin:") && tmp[i].length() > 7){
                String pluginName = tmp[i].substring(7, tmp[i].length());
                try{
                    Logger.logD("Loading Plugin: " + pluginName);
                    plugins.loadPlugin(pluginName, conf.getString(tmp[i]));
                }catch(Exception e){
                    Logger.logD("Failed loading plugin <" + pluginName + ">: " + e.getMessage());
                    continue;
                }
            }
        }
    }
    
    //connect to the server
    public void connect(){
        if(connected){
            connected = false;
            disconnectCount++;
            //Logger.logD("connected = false");
            if(conf.getInt("max-disconnects") > 0 && disconnectCount > conf.getInt("max-disconnects")){
                close("Max disconnects reached (" + disconnectCount + ")");
            }
        }
        for(int attempts = 0; (conn == null || !conn.isConnected()); attempts++){
            if(attempts > 0 || (System.currentTimeMillis() - lastConnected) / 1000 < conf.getInt("reconnect-delay")){
                if(conf.getInt("max-reconnect-attempts") > 0 && attempts + 1 > conf.getInt("max-reconnect-attempts")){
                    close("Max reconnect attempts reached (" + conf.getInt("max-reconnect-attempts") + ")");
                }
                Logger.logD(conf.getInt("reconnect-delay") + "s reconnect delay.");
                try{
                    Thread.sleep(conf.getInt("reconnect-delay") * 1000);
                }catch(Exception e){e.printStackTrace();}
            }
            Logger.logD("Attempting to connect to " + conf.getString("server") + ":" + conf.getString("server-port") + " (" + (attempts + 1) + ")");
            try{
                conn = new IRCConnection(this, conf.getString("server"), conf.getInt("server-port"), conf.getString("server-pass"));
            }catch(Exception e){
                Logger.logD("Connection attempt failed: " + e.getMessage());
            }
        }
        lastConnected = System.currentTimeMillis();
        connected = true;
    }
    
    //close the bot
    public void close(String n){
        Logger.logD(n);
        if(conn != null && (conn.isConnected())){
            conn.close();
            conn = null;
        }
        System.exit(0);
    }
    
    public void fatalError(String n){
        Logger.logD("Fatal Error: " + n);
        close("Closing from fatal error");
    }
    
    //IRC HANDLER
    public void onConnect(){
        Logger.logD("Connected to " + conf.getString("server") + ":" + conf.getString("server-port"));
        plugins.addEvent(new PluginMethod("setConnection", new Object[]{conn}));
        plugins.addEvent(new PluginMethod("onConnect", new Object[0]));
    }
    
    public void onDisconnect(String cmd){
        Logger.logD("Disconnected from " + conf.getString("server") + ":" + conf.getString("server-port") + " :" + cmd);
        plugins.addEvent(new PluginMethod("onDisconnect", new Object[]{cmd}));
    }
    
    public void onNickAlreadyInUse(){
        plugins.addEvent(new PluginMethod("onNickAlreadyInUse", new Object[0]));
    }
    
    public void onServerPing(){
        plugins.addEvent(new PluginMethod("onServerPing", new Object[0]));
    }
    
    public void onTopic(String chan, String topic){
        plugins.addEvent(new PluginMethod("onTopic", new Object[]{chan, topic}));
    }
    
    public void onTopic(String chan, String nick, String ident, String host, String topic){
        plugins.addEvent(new PluginMethod("onTopic", new Object[]{chan, nick, ident, host, topic}));
    }
    
    public void onBannedFromChannel(String chan, String msg){
        plugins.addEvent(new PluginMethod("onBannedFromChannel", new Object[]{chan, msg}));
    }
    
    public void onWhoReply(String channelName, String nick, String ident, String host, String server, String userModes, String real_name){
        plugins.addEvent(new PluginMethod("onWhoReply", new Object[]{channelName, nick, ident, host, server, userModes, real_name}));
    }
    
    public void onCTCPRequest(String commandTarget, String senderNick, String senderIdent, String senderHost, String reqCTCP){
        if(reqCTCP.equalsIgnoreCase("VERSION")){
            conn.sendLine("NOTICE " + senderNick + " :\u0001VERSION " + Apello.VERSION + "\u0001");
        }else if(reqCTCP.toUpperCase().startsWith("ACTION ")){
            conn.onAction(commandTarget, senderNick, senderIdent, senderHost, reqCTCP.substring(7));
        }else if(reqCTCP.toUpperCase().startsWith("PING ")){
            conn.sendLine("NOTICE " + senderNick + " :\u0001PING " + reqCTCP.substring(5) + "\u0001");
        }else if(reqCTCP.equalsIgnoreCase("TIME")){
            conn.sendLine("NOTICE " + senderNick + " :\u0001TIME " + new java.util.Date().toString() + "\u0001");
        }else if(reqCTCP.equalsIgnoreCase("FINGER")){
            conn.sendLine("NOTICE " + senderNick + " :\u0001FINGER You are a dirty whore.\u0001");
        }
        plugins.addEvent(new PluginMethod("onCTCPRequest", new Object[]{commandTarget, senderNick, senderIdent, senderHost, reqCTCP}));
    }
    
    public void onAction(String channel, String senderNick, String senderIdent, String senderHost, String msg){
        plugins.addEvent(new PluginMethod("onAction", new Object[]{channel, senderNick, senderIdent, senderHost, msg}));
    }
    
    public void onChatMessage(String channel, String senderNick, String senderIdent, String senderHost, String msg){
        plugins.addEvent(new PluginMethod("onChatMessage", new Object[]{channel, senderNick, senderIdent, senderHost, msg}));
    }
    
    public void onPrivateMessage(String senderNick, String senderIdent, String senderHost, String msg){
        plugins.addEvent(new PluginMethod("onPrivateMessage", new Object[]{senderNick, senderIdent, senderHost, msg}));
    }
    
    public void onNotice(String senderNick, String senderIdent, String senderHost, String msg){
        plugins.addEvent(new PluginMethod("onNotice", new Object[]{senderNick, senderIdent, senderHost, msg}));        
    }
    
    public void onKick(String channel, String recipient, String senderNick, String senderIdent, String senderHost, String msg){
        plugins.addEvent(new PluginMethod("onKick", new Object[]{channel, recipient, senderNick, senderIdent, senderHost, msg}));
    }
    
    public void onPart(String channel, String senderNick, String senderIdent, String senderHost){
        plugins.addEvent(new PluginMethod("onPart", new Object[]{channel, senderNick, senderIdent, senderHost}));
    }
    
    public void onQuit(String senderNick, String senderIdent, String senderHost, String msg){
        plugins.addEvent(new PluginMethod("onQuit", new Object[]{senderNick, senderIdent, senderHost, msg}));
    }
    
    public void onJoin(String channel, String senderNick, String senderIdent, String senderHost){
        plugins.addEvent(new PluginMethod("onJoin", new Object[]{channel, senderNick, senderIdent, senderHost}));        
    }
    
    public void onNickChange(String senderNick, String senderIdent, String senderHost, String newNick){
        plugins.addEvent(new PluginMethod("onNickChange", new Object[]{senderNick, senderIdent, senderHost, newNick}));
    }
    
    public void onMode(String channel, String senderNick, String senderIdent, String senderHost, String mode){
        plugins.addEvent(new PluginMethod("onMode", new Object[]{channel, senderNick, senderIdent, senderHost, mode}));
    }
    
    public void onInvite(String commandTarget, String senderNick, String senderIdent, String senderHost, String channel){
        plugins.addEvent(new PluginMethod("onInvite", new Object[]{commandTarget, senderNick, senderIdent, senderHost, channel}));
    }
    
    public void onUnknown(String s){
        plugins.addEvent(new PluginMethod("onUnknown", new Object[]{s}));
    }
}
