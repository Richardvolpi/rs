package org.rscdaemon.client.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
	/**
	 * Called to load config settings from the given file
	 */
	public static void initConfig(String file) throws IOException {
		START_TIME = System.currentTimeMillis();

		Properties props = new Properties();
		props.load(new FileInputStream(file));
		
		SERVER_IP = props.getProperty("server");
		HOTKEY = props.getProperty("Hotkey_F3");
		SERVER_PORT = Integer.parseInt(props.getProperty("port"));
		CONF_DIR = props.getProperty("config_dir");
		MEDIA_DIR = props.getProperty("media_dir");
		MOVIE_FPS = Integer.parseInt(props.getProperty("movie_fps"));
GAME_VERSION = Integer.parseInt(props.getProperty("Client_Version"));
AMOUNT_OF_PLAYS = Integer.parseInt(props.getProperty("Amount_Of_Rings"));
SOUND_ON = (props.getProperty("ModProtection_Sound").equalsIgnoreCase("on") ? true : false);
CLIENT_VERSION = GAME_VERSION;
SERVER_NAME = props.getProperty("name");
CHAT_ON = (props.getProperty("Chat_Logging").equalsIgnoreCase("on") ? true : false);
TRADE = (props.getProperty("TradeOption").equalsIgnoreCase("on") ? true : false);
Mage = (props.getProperty("AutoMageOption").equalsIgnoreCase("on") ? true : false);
Duel = (props.getProperty("DuelOption").equalsIgnoreCase("on") ? true : false);
FOLLOW = (props.getProperty("FollowOption").equalsIgnoreCase("on") ? true : false);
chatDetect = (props.getProperty("Exit_OnChat").equalsIgnoreCase("on") ? true : false);
SPELLID = Integer.parseInt(props.getProperty("What_Spell"));

for(int i=1; i < 4; i++) {
	servers[i - 1] = props.getProperty("Server" + i + "Name");
	IP[i - 1] = props.getProperty("Server" + i + "IP");
	ports[i - 1] = Integer.parseInt(props.getProperty("Server" + i + "Port"));
	versions[i - 1] = Integer.parseInt(props.getProperty("Server" + i + "Version"));
}

		props.clear();
	}

	
	public static Object [] servers = {null, null, null, null};
	public static int [] ports = {-1, -1, -1, -1};
	public static int versions [] = {-1, -1, -1, -1};
	public static String IP [] = {null, null, null, null};
	
	public static String SERVER_IP, HOTKEY, CONF_DIR, MEDIA_DIR, User, Pass, SERVER_NAME, temp;
public static int SERVER_PORT, SPELLID, MOVIE_FPS, GAME_VERSION, AMOUNT_OF_PLAYS, CLIENT_VERSION;
public static boolean SOUND_ON, CHAT_ON, Mage, Duel, chatDetect, TRADE, FOLLOW;
	public static long START_TIME;
}