/*
 *      PluginEvent.java
 *
 *      Represents an event that could be processed by a plugin.
 *        Basically, represents any possible method a plugin could have
 *        implemented that has this events name, and it's arguments
 *        are the same class types as the events args.
 *
 */
package org.apello.plugins;

public class PluginMethod{
    public PluginMethod(String methodName, Object[] mArgs){
        name = methodName;
        args = mArgs;
        argClass = new Class[args.length];
        for(int i = 0; i < argClass.length; i++)
            argClass[i] = args[i] == null ? null : args[i].getClass();
        created = System.currentTimeMillis();
    }
    
    private String name;
    private Object[] args;
    private Class[] argClass;
    private long created;
    
    // The name of the method this event represents.
    public String getName(){
        return name;
    }
    
    // The args that will be passed to the method this event represents
    public Object[] getArgs(){
        return args;
    }
    
    // the class types of the args of this event
    public Class[] getArgClasses(){
        return argClass;
    }
    
    // the time in milliseconds this event was created.
    public long timeCreated(){
        return created;
    }
}
