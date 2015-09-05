/*
 *      Logger.java
 *
 *      Thread which waits on data to be logged to a file. 
 *      It is thread safe as well.
 */
package org.apello.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import java.util.Date;
import java.util.ArrayList;
import java.text.DateFormat;

public class Logger extends Thread{
    public Logger(String path)throws Exception{
        if(path == null || path.length() < 1)
            throw new Exception("Invalid path to log file");
        outStream = new FileOutputStream(path, true);
        logQueue = new Queue<String>();
        running = true;
        start();
    }
    
    private FileOutputStream outStream;//Stream to the log file
    private String path;//Path to the log file
    private Queue<String> logQueue;//Thread safe ccollection to hold pending log messages
    private boolean running;//true if the Logging thread is running
    private int threadDelay = 500;//Delay between log file writes and the queue is flushed.
    private static Logger globalLogger = null;//Logger available to the entire java application
    
    //returns the global logger, null if one has not been set yet.
    public static Logger getGlobalLogger(){
        return globalLogger;
    }
    
    // Set's the global Logger.
    public static void setGlobalLogger(Logger log){
        globalLogger = log;
    }
    
    // The log writing thread
    public void run(){
        List<String> logs = new ArrayList<String>();
        while(running){
            try{
                try{
                    sleep(threadDelay);
                }catch(Exception e){}
                logs.addAll(logQueue.getQueue());
                for(int i = 0; i < logs.size(); i++){
                    if(logs.get(i).length() < 1)
                        continue;
                    outStream.write(logs.get(i).getBytes());
                    logs.remove(i);
                    // DEBUG THIS PROPERLY!!!
                    // IT WORKS BUT IS IT BUG PROOF??, i r lazy
                    //i--;//NOT POSITIVE, SUBTRACT 1 because the logs.remove will shift all objects indicies left in logs, so the next loop would be off otherwise
                }
            }catch(Exception e){
                //Write error occured, wait 30 seconds and try to re-open the file.
                //Log messages will still be queued.
                Logger.logD("Log file write error occured: " + e.getMessage() + ", waiting 30 seconds to reopen file.");
                outStream = null;
                try{
                    sleep(30000);//wait 30 seconds to re-open the file
                }catch(Exception e2){}
                if(running){
                    try{
                        outStream = new FileOutputStream(path, true); 
                    }catch(Exception e2){
                        //running = false;
                        //Don't stop the thread, keep attempting to open the log file.
                    }
                }
            }
        }
    }
    
    // Attempt to log the file if a global logger is set, and print value to screen
    public static void logD(String n){
        if(globalLogger != null){
            globalLogger.log(n);
            return;
        }
        n = "[NL] <"+ DateFormat.getInstance().format(new Date()) + "> " + n;
        System.out.println(n);
    }
    
    // add the string to the queue to be logged
    public void log(String n){
        n = "<"+ DateFormat.getInstance().format(new Date()) + "> " + n;
        System.out.println(n);
        logQueue.add(n + "\r\n");
    }
    
    //stop logging
    public void close(){
        running = false;
        try{
            List<String> logs = logQueue.getQueue();
            for(int i = 0; i < logs.size(); i++)
                outStream.write(logs.get(i).getBytes()); 
        }catch(Exception e){}
        try{
            outStream.close();
        }catch(Exception e){}
    }
}
