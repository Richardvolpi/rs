import java.util.*;
import java.net.*;
import java.io.*;
import javax.swing.*;

public class RSHal extends Script {
    JMegaHal hal;
    
    int reply_rate = 10;
    boolean replying = false;
    boolean learning = true;
    boolean on = true;
    
    public RSHal(mudclient ps) {
        super(ps);
    }
    public String[] getCommands() {
        return new String[]{"rshal"};
    }
    public void start(String command, String params[]) {
        hal = new JMegaHal();
        hal.add("obes is dongs is dongs is obes");
        hal.add("obes is dongs");
        hal.add("dongs is obes");
        Println(hal.getSentence("obes"));
        Msg("RSHal - A nonsensical auto-talker using the JMegaHal library - eXemplar");
        while (Running() && on)
            Wait(100);
    }
    private void Msg(String msg) {
        if (Running()) {
            DisplayMessage("@gre@SBoT: @whi@" + msg,3);
            Println("SBoT: " + msg.replaceAll("@...@",""));
        }
    }
    public void KeyPressed(int id) {
        switch(id) {
            case 1009: // f2
                replying ^= replying;
                Msg("RSHal Reply = " + replying);
                break;
            case 1010: // f3
                learning ^= learning;
                Msg("RSHal Learn = " + learning);
                break;
            case 1011: // f4
                if(reply_rate < 100)
                    reply_rate += 1;
                else
                    reply_rate = 100;
                Msg("RSHal Reply Rate = " + reply_rate);
                break;
            case 1012: // f5
                if(reply_rate > 1)
                    reply_rate -= 1;
                else
                    reply_rate = 1;
                Msg("RSHal Reply Rate = " + reply_rate);
                break;
            case 1013: // f6
                Println("RSHal: " + hal.getSentence());
                break;
            case 1014: // f7
                String filename = InputBox("Enter path to file for RSHal parsing:");
                try{
                    Msg("Parsing '" + filename + "' ...");
                    hal.addDocument(filename);
                    Msg("Parsed '" + filename + "'");
                }
                catch(IOException e) {
                    Msg("Exception: " + e.getMessage());
                }
                break;
            case 1015: // f8
                String learn_msg = InputBox("Enter string for RSHal to learn:");
                hal.add(learn_msg);
                Msg("Learnt: " + learn_msg);
                break;
            case 1016: // f9
                on = false;
                Msg("RSHal turned off, have a nice day!");
                break;
        }
    }
    public void NPCMessage(String msg) {
        LearnReply(msg);
    }
    public void ChatMessage(String msg) {
        LearnReply(msg);
    }
    public void LearnReply(String tolearn) {
        if(Running()) {
            if (learning)
                hal.add(tolearn);
            
            if(replying == true) {
                int rate = Rand(0,100);
                if (rate > reply_rate) {
                    String sentence = hal.getSentence();
                    Msg("Saying: " + sentence);
                    Say(sentence);
                }
            }
            
        }
    }
    public String InputBox(String question) {
        String input = JOptionPane.showInputDialog(question);
        if(input == null)
            return "";
        else
            return input;
    }
}
