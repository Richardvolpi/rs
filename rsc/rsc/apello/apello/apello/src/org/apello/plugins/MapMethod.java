/*
 *      MapMethod.java
 */
package org.apello.plugins;

import java.lang.reflect.Method;
import java.util.Arrays;

public class MapMethod{
    public MapMethod(PluginAdapter pa, Method m){
        plugin = pa;
        name = m.getName();
        method = m;
    }
    
    private PluginAdapter plugin;
    private Method method;
    private String name;
    
    public String getName(){
        return name;
    }
    
    public PluginAdapter getPlugin(){
        return plugin;
    }
    
    public Method getMethod(){
        return method;
    }
    
    public boolean equals(Object o){
        if(o instanceof MapMethod){
            MapMethod m = (MapMethod)o;
            return m.getName().equalsIgnoreCase(getName()) && Arrays.equals(m.getMethod().getParameterTypes(), method.getParameterTypes());
        }else
            return false;
    }
    
    public boolean canHandle(PluginMethod p){
        return p.getName().equalsIgnoreCase(getName()) && Arrays.equals(p.getArgClasses(), method.getParameterTypes());
    }
    
    public Object invoke(Object[] args) throws Exception{
        return method.invoke(plugin, args);
    }
    
    public Object handle(PluginMethod p) throws Exception{
        return invoke(p.getArgs());
    }
}
