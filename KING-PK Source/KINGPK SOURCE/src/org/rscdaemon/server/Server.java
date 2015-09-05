package org.rscdaemon.server;

import org.rscdaemon.server.event.DelayedEvent;
import org.rscdaemon.server.event.SingleEvent;
import org.rscdaemon.server.util.*;
import org.rscdaemon.server.model.World;
import org.rscdaemon.server.net.RSCConnectionHandler;

import org.apache.mina.common.IoAcceptor;
import org.apache.mina.common.IoAcceptorConfig;
import org.apache.mina.transport.socket.nio.*;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * The entry point for RSC server.
 */
public class Server {
	/**
	 * World instance
	 */
	private static final World world = World.getWorld();
	/**
	 * The game engine
	 */
	private GameEngine engine;
	/**
	 * The SocketAcceptor
	 */
	private IoAcceptor acceptor;
	/**
	 * Update event - if the server is shutting down
	 */
	private DelayedEvent updateEvent;
	/**
	 * The login server connection
	 */
	private LoginConnector connector;
	/**
	 * Is the server running still?
	 */
	private boolean running;
	
	public LoginConnector getLoginConnector() {
		return connector;
	}
	
	public boolean running() {
		return running;
	}
	
	/**
	 * Shutdown the server in 60 seconds
	 */
	public boolean shutdownForUpdate() {
		if(updateEvent != null) {
			return false;
		}
		updateEvent = new SingleEvent(null, 65000) {
    			public void action() {
    				kill();
    			}
    		};
		world.getDelayedEventHandler().add(updateEvent);
		return true;
	}
	
	/**
	 * MS till the server shuts down
	 */
	public int timeTillShutdown() {
		if(updateEvent == null) {
			return -1;
		}
		return updateEvent.timeTillNextRun();
	}

	/**
	 * Creates a new server instance, which in turn creates a new
	 * engine and prepares the server socket to accept connections.
	 */
	public Server() {
		running = true;
		world.setServer(this);
		try {
			connector = new LoginConnector();
			engine = new GameEngine();
			engine.start();
			while(!connector.isRegistered()) {
				Thread.sleep(100);
			}
			acceptor = new SocketAcceptor();
			IoAcceptorConfig config = new SocketAcceptorConfig();
			config.setDisconnectOnUnbind(true);
			((SocketSessionConfig)config.getSessionConfig()).setReuseAddress(true);
			acceptor.bind(new InetSocketAddress(Config.SERVER_IP, Config.SERVER_PORT), new RSCConnectionHandler(engine), config);
		}
		catch (Exception e) {
			Logger.error(e);
		}
	}
	
	/**
	 * Returns the game engine for this server
	 */
	public GameEngine getEngine() {
		return engine;
	}
	
	public boolean isInitialized() {
		return engine != null && connector != null;
	}
	
	/**
	 * Kills the game engine and irc engine
	 */
	public void kill() {
		Logger.print("RSCD Server shutting down...");
		running = false;
		engine.emptyWorld();
		connector.kill();
	}
	
	/**
	 * Unbinds the socket acceptor
	 */
	public void unbind() {
		try {
			acceptor.unbindAll();
		}
		catch(Exception e) { }
	}

	public static void main(String[] args) throws IOException {
		String configFile = "conf/server/Conf.xml";
		if(args.length > 0) {
			File f = new File(args[0]);
			if(f.exists()) {
				configFile = f.getName();
			}
		}
		Logger.print("RSCD Server starting up...");
		Config.initConfig(configFile);
		new Server();
	}
}
