/*
 *      Config.java
 */
package org.apello.util;

import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.Properties;

public class Config{
    public Config(String path){
        prop = new Properties();
        processArgs(DEFAULT_VALUES);
        try{
            prop.loadFromXML(new FileInputStream(path));
        }catch(Exception e){
            Logger.logD("WARNING - Failed to load configuration file, error reported: " + e.getMessage());
        }
    }
    
    private Properties prop;
    private static Config globalConfig = null;
   
    // config which is global to this application
    public static Config getGlobalConfig(){
        return globalConfig;
    }
    
    // sets the config which is global to this application
    public static void setGlobalConfig(Config conf){
        if(globalConfig == null){
            globalConfig = conf;
            return;
        }
        synchronized(globalConfig){
            globalConfig = conf;
        }
    }
    
    // Process command arguments into the configuration
    public void processArgs(String args[]){
        for(int i = 0; i < args.length; i++){
            int idx = args[i].indexOf("=");
            if(idx == -1){
                setValue(args[i], "");
                continue;
            }
            setValue(args[i].substring(0, idx), args[i].substring(idx + 1, args[i].length()));
           // Logger.logD(args[i].substring(0, idx) + " = " + args[i].substring(idx + 1, args[i].length()));
        }
    }
    
    // all config variable names currently set
    public String[] getKeys(){
        return prop.keySet().toArray(new String[0]);
    }
    
    // returns true if variable n is set in this configuration
    public boolean containsKey(String n){
        return prop.containsKey(n.toLowerCase());
    }
    
    // get the String value for the variable key
    public String getValue(String key){
        return getString(key);
    }
    
    // get string value for the variable key
    public String getString(String key){
        return prop.getProperty(key);
    }
    
    // get int value for variable key, -1 if inavlid
    public int getInt(String key){
        try{
            return Integer.parseInt(getString(key));
        }catch(Exception e){
            return -1;
        }
    }
    
    // set value for variable key
    public void setValue(String key, String value){
        synchronized(prop){
            prop.setProperty(key, value);
        }
    }
    
    // get the default value for the variable key
    public static String getDefaultValue(String key){
        for(int i = 0; i < DEFAULT_VALUES.length; i++)
            if(DEFAULT_VALUES[i].toLowerCase().startsWith((key).toLowerCase() + "="))
                return DEFAULT_VALUES[i].substring(key.length() + 1, DEFAULT_VALUES[i].length());
        return null;
    }
    
    // the hard coded default values which are set by default
    public static String DEFAULT_VALUES[] = new String[]{"config-path=./config.xml", "log-path=./apello.log", 
    "server=irc.securitychat.org", "server-port=6667", "server-pass=", "nick=aPello", "ident=apello", "max-disconnects=0", 
    "max-reconnect-attempts=1000", "reconnect-delay=10", "plugin-path=./plugins"};
}
