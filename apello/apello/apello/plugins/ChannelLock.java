/*
 *      ChannelLock.java
 */
 
import org.apello.plugins.*;
import org.apello.util.*;
import org.apello.irc.*;

import java.util.Random;
import java.util.HashMap;

public class ChannelLock extends PluginAdapter {
    public ChannelLock(){}
    
    public String getPluginName(){
        return "ChannelLock";
    }
    
    private int rejoinDelay = 10;
    private HashMap<String, String> channels;
    
    
    public void init(String args)throws Exception{
        String tmp[] = args.trim().split(" ");
        if(tmp.length < 2){
            throw new Exception("Invalid Argument Syntax, correct syntax: \"rejoinChannelDelayInSeconds #channel1 #channel2 #etc\"");
        }
        rejoinDelay = Integer.parseInt(tmp[0]);//seconds to wait before attempting to re-join the channel
        channels = new HashMap<String, String>();
        for(int i = 1; i < tmp.length; i++){//the rest of the args should be channels 
            if(tmp[i].trim().length() > 2){
                String chName = tmp[i].trim();
                String chPass = "";
                int idx = chName.indexOf(":");
                if(idx > 0){
                    chPass = chName.substring(idx + 1, chName.length());
                    chName = chName.substring(0, idx);
                }
                channels.put(chName, chPass);
            }
        }
        setDelay(rejoinDelay * 1000);
    }
    
    public void process(){
        String[] chans = channels.keySet().toArray(new String[0]);
        for(int i = 0; i < chans.length; i++){
            if(!irc.inChannel(chans[i])){
                log("Attempting to join channel " + chans[i]);
                irc.joinChannel(chans[i], channels.get(chans[i]));
            }
        }
    }
    
    public void dispose(){
        log("dispose");
    }
}
