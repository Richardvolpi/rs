/*
 *      PluginHandler.java
 *
 *      Handles loading, unloading, passing events to plugins.
 */
package org.apello.plugins;

import org.apello.Apello;
import org.apello.util.AClassLoader;
import org.apello.util.Logger;

import java.util.HashMap;
import java.util.ArrayList;
import java.lang.reflect.Method;

public class PluginHandler{
    //new Handler with d as the path to the plugin directory.
    public PluginHandler(String d){
        pluginDir = d;
        plugins = new HashMap<String, PluginAdapter>();
        methods = new ArrayList<MapMethod>();
    }
    
    private String pluginDir;
    private HashMap<String, PluginAdapter> plugins;
    private ArrayList<MapMethod> methods;
    
    // try to load and start plugin pName with pArgs as it's args
    public void loadPlugin(String pName, String pArgs) throws Exception{
        if(plugins.containsKey(pName.toLowerCase())){
            throw new Exception("Plugin " + pName + " is already loaded.");
        }
        if(pArgs == null || pArgs.length() < 1)
            pArgs = "";
        AClassLoader loader = new AClassLoader(pluginDir);
        Class cl = loader.findClass(pName);
        PluginAdapter pl = (PluginAdapter)cl.newInstance();
        pl.start(this, pArgs == null ? "" : pArgs);
        synchronized(plugins){
            plugins.put(cl.getName().toLowerCase(), pl);
        }
        Logger.logD("Plugin <" + pName + "> has been loaded.");
    }
    
    //unload plugin
    public void unloadPlugin(String name) throws Exception{
        PluginAdapter pl = getPlugin(name);
        if(pl == null)
            throw new Exception("Plugin " + name + " is not currently loaded.");
        synchronized(plugins){
            plugins.remove(name.toLowerCase());
        }
        pl.stop();
        Logger.logD("Plugin <" + name + "> has been unloaded.");
    }
    
    // return the basic plugin object of plugin by name n
    public PluginAdapter getPlugin(String n){
        return plugins.get(n.toLowerCase());
    }
    
    // returns all plugin names of the plugins currently loaded.
    public String[] getPluginNames(){
        return plugins.keySet().toArray(new String[0]);
    }
    
    // returns all currently loaded plugin object
    public PluginAdapter[] getPlugins(){
        return plugins.values().toArray(new PluginAdapter[0]);
    }
    
    //returns true if the plugin is loaded
    public boolean isLoaded(String n){
        return plugins.containsKey(n.toLowerCase());
    }
    
    // Add global object with name key
    public void addMethod(MapMethod m){
        if(methods.contains(m))
            return;
        synchronized(methods){
            methods.add(m);
        }
    }
    
    // remove global object with name key
    public void removeMethod(MapMethod m){
        if(!methods.contains(m))
            return;
        synchronized(methods){
            methods.remove(m);
        }
    }
    
    // returns global method with the name n
    public Object globalMethod(String name, Object[] args)throws Exception{
        PluginMethod p = new PluginMethod(name, args);
        MapMethod[] m = getMethods();
        for(int i = 0; i < m.length; i++){
            if(m[i].canHandle(p))
                return m[i].handle(p);
        }
        return null;
    }
    
    // returns all global objects
    public MapMethod[] getMethods(){
        return methods.toArray(new MapMethod[0]);
    }
    
    //pass a plugin event to all plugins that can handle the event
    public void addEvent(PluginMethod pe){
        PluginAdapter[] pls = getPlugins();
        if(pls == null)//no plugins
            return;
        for(int i = 0; i < pls.length; i++){
            if(pls[i] == null)//shouldnt happen
                continue;

            try{//test to see if the plugin can handle this event
                pls[i].getClass().getMethod(pe.getName(), pe.getArgClasses());
            }catch(Exception e){
                continue;//The plugin doesn't handle this event
            }
            pls[i].addEvent(pe);
        }
    }
}
