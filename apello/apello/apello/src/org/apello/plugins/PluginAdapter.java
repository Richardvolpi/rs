/*
 *      PluginAdapter.java
 */
package org.apello.plugins;

import org.apello.util.Config;
import org.apello.util.Logger;
import org.apello.util.Queue;
import org.apello.irc.IRCConnection;

import java.util.List;
import java.util.Arrays;
import java.lang.reflect.Method;

public abstract class PluginAdapter implements Runnable{
    public PluginAdapter(){}
    
    protected PluginHandler handler;
    protected boolean running;
    protected int threadDelay = 100;
    protected Queue<PluginMethod> events;
    protected Thread thread;
    protected IRCConnection irc = null;
    protected Config conf;
    protected long lastRan = 0;
    
    //Start this plugin's thread
    public void start(PluginHandler a, String args) throws Exception{
        handler = a;
        events = new Queue<PluginMethod>();
        conf = Config.getGlobalConfig();
        try{
            init(args);
        }catch(Exception e){
            throw new Exception("Init Error: " + e.getMessage());
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    
    // stop this plugin
    public void stop(){
        running = false;
    }
    
    //The main processing loop for the thread
    // Sleeps for threadDelay every loop
    // processes any events that are queued.
    // calls the process method once every loop if there is a valid 
    // connection
    public void run(){
        while(running){
            try{
                Thread.sleep(10);
            }catch(Exception e){}
            handleEvents();
            if(irc == null || !irc.isConnected())
                continue;
            if(threadDelay > 10 && System.currentTimeMillis() - lastRan < threadDelay)
                continue;
            lastRan = System.currentTimeMillis();
            try{
                process();
            }catch(Exception e){
                log("Unhandled Error: " + e.getMessage());
            }
        }
        try{
            dispose();
        }catch(Exception e){
            log("Dispose Error: " + e.getMessage());
        }
    }
    
    // add event to be procesed by this thread
    public void addEvent(PluginMethod e){
        events.add(e);
    }
    
    // handle all events in this threads event queue
    protected void handleEvents(){
        PluginMethod[] evts = events.getQueue().toArray(new PluginMethod[0]);
        for(int i = 0; i < evts.length; i++){
            try{
                Method m = getClass().getMethod(evts[i].getName(), evts[i].getArgClasses());
                try{
                    m.invoke(this, evts[i].getArgs());
                }catch(Exception e){
                    log("Unhandled Event Error (" + evts[i].getName() + ") " + e.getMessage());
                }
            }catch(Exception e){
                //The plugin doesnt handle the event
            }
        }
    }
    
    //Log string s to global logger
    public void log(String s){
        Logger.logD("<" + getPluginName() + "> " + s);
    }
    
    //set this plugins sleep delay
    public void setDelay(int i){
        threadDelay = i;
    }
    
    // the current delay this plugin sues
    public int getDelay(){
        return threadDelay;
    }
    
    public void setConnection(IRCConnection conn){
        if(irc == null){
            irc = conn;
            return;
        }
        
        synchronized(irc){
            irc = conn;
        }
    }
    
    public boolean addGlobalMethod(String name, Class[] args){
        Method[] mds = getClass().getMethods();
        for(int i = 0; i < mds.length; i++){
            if(Arrays.equals(mds[i].getParameterTypes(), args)){
                handler.addMethod(new MapMethod(this, mds[i]));
                return true;
            }
        }
        return false;
    }
    
    //
    // The following MUST be implemented by each plugin
    //
    
    // This should returns the exact name of this plugin
    public abstract String getPluginName();
    // Get the plugin ready, pass the arguments to it
    public abstract void init(String args)throws Exception;
    // Main process of this plugin called after thread delay
    public abstract void process();
    // called after the plugin has stopped for clean up. Dispose of all resources here
    public abstract void dispose();
    
    //
    // You can optionally process server events by implementing
    // any of the methods from org.apello.irc.IRCHandler
    //
}
