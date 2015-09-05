package org.rscdaemon.server;

import org.rscdaemon.server.net.PacketQueue;
import org.rscdaemon.server.net.RSCPacket;
import org.rscdaemon.server.packethandler.PacketHandler;
import org.rscdaemon.server.packethandler.PacketHandlerDef;
import org.rscdaemon.server.util.PersistenceManager;
import org.rscdaemon.server.model.Player;
import org.rscdaemon.server.model.World;
import org.rscdaemon.server.model.Shop;
import org.rscdaemon.server.util.Logger;
import org.rscdaemon.server.event.DelayedEvent;
import org.rscdaemon.server.quest.QuestLoader;
import org.rscdaemon.server.entityhandling.EntityHandler;//anonymous
import org.rscdaemon.server.entityhandling.defs.extras.AdvertDef;
import org.rscdaemon.server.model.InvItem;

import org.apache.mina.common.IoSession;

import java.util.TreeMap;

/**
 * The central motor of the game. This class is responsible for the
 * primary operation of the entire game.
 */
public final class GameEngine extends Thread {
	/**
	 * World instance
	 */
	private static final World world = World.getWorld();
	private static String processAdvert(String advert, Player p)
	{
		advert = advert.replaceAll("%name", p.getUsername());
		//advert = advert.replaceAll("%version", String.valueOf(Conf.SERVER_VERSION));
		advert = advert.replaceAll("%online", String.valueOf(world.getPlayers().size()));

		return advert;
	}
	/**
	
	/**
	 * The packet queue to be processed
	 */
	private PacketQueue<RSCPacket> packetQueue;
	/**
	 * Whether the engine's thread is running
	 */
	private boolean running = true;
	/**
	 * The mapping of packet IDs to their handler
	 */
	private TreeMap<Integer, PacketHandler> packetHandlers = new TreeMap<Integer, PacketHandler>();
	/**
	 * Responsible for updating all connected clients
	 */
	private ClientUpdater clientUpdater = new ClientUpdater();
	/**
	 * Handles delayed events rather than events to be ran every iteration
	 */
	private DelayedEventHandler eventHandler = new DelayedEventHandler();
	/**
	 * When the update loop was last ran, required for throttle
	 */
	private long lastSentClientUpdate = 0;
	private long lastSendEventUpdate = 0, lastAdvert = 0;

	/**
	 * Constructs a new game engine with an empty packet queue.
	 */
	public GameEngine() {
		packetQueue = new PacketQueue<RSCPacket>();
		QuestLoader.initClasses();
		loadPacketHandlers();
		for(Shop shop : world.getShops()) {
			shop.initRestock();
		}
	}
		
	/**
	 * The thread execution process.
	 */
	public void run() {
		Logger.print("GameEngine now running");
		int curAdvert = -1;	
		eventHandler.add(new DelayedEvent(null, 900000) { // 15mins
			public void run() {
				for(Player p : world.getPlayers()) {
					p.save();
				} 
				world.getServer().getLoginConnector().getActionSender().saveProfiles();
			} 
		});
				eventHandler.add(new DelayedEvent(null, 1000) { // 15mins
			public void run() {
				for(Player p : world.getPlayers()) 
				{
					for(InvItem item : p.getInventory().getItems()) {
      		if(item.isWielded() && EntityHandler.getItemWieldableDef(item.getID()).p2pOnly() && !p.getLocation().inp2pWild() && !p.getLocation().inp2pWild2() && !p.getLocation().inp2pWild3()) {
			p.getActionSender().sendMessage("You're not in a p2p area!");
					item.setWield(false);
      		      	p.updateWornItems(item.getWieldableDef().getWieldPos(), p.getPlayerAppearance().getSprite(item.getWieldableDef().getWieldPos()));
      						p.getActionSender().sendInventory();
      						p.getActionSender().sendEquipmentStats();      				
		}
			}
			if(!p.getLocation().inp2pWild() && !p.getLocation().inp2pWild2() && !p.getLocation().inp2pWild3()) {
			if(p.getCurStat(0) > p.getMaxStat(0) + 12){
					p.setCurStat(0, p.getMaxStat(0));					
					p.getActionSender().sendStat(0);
					}		
			if(p.getCurStat(1) > p.getMaxStat(1) + 12){
					p.setCurStat(1, p.getMaxStat(1));
					p.getActionSender().sendStat(1);
					}
			if(p.getCurStat(2) > p.getMaxStat(2) + 12){
					p.setCurStat(2, p.getMaxStat(2));
					p.getActionSender().sendStat(2);
					}
				}
				}
				}
		});	
		while (running) {
			try { Thread.sleep(50); } catch(InterruptedException ie) {}
			processLoginServer();
			processIncomingPackets();
			processEvents();
			processClients();
			long curTime = System.currentTimeMillis();
			if(curTime - lastAdvert >= 210000) // Display an advert every 3.5 mins.
			{
				lastAdvert = curTime;
					
				curAdvert++;
					
				if(curAdvert >= EntityHandler.getAdverts().length || curAdvert < 0)
					curAdvert = 0;
						
					AdvertDef advertDef = EntityHandler.getAdverts()[curAdvert];
					String advert = advertDef.getMessage();
					
					for(Player p : world.getPlayers())
					{
						if(advertDef.isF2pOnly() && p.isSubscriber())
							continue;
							
						if(advertDef.isP2pOnly() && !p.isSubscriber())
							continue;
							
						p.getActionSender().sendMessage("@mag@[Server] @cya@" + processAdvert(advert, p));
					}
				}
		}
		
	}
	
	public void emptyWorld() {
		for(Player p : world.getPlayers()) {
			p.save();
			p.getActionSender().sendLogout();
		}
		world.getServer().getLoginConnector().getActionSender().saveProfiles();
	}
	
	public void kill() {
		Logger.print("Terminating GameEngine");
		running = false;
	}
	
	public void processLoginServer() {
		LoginConnector connector = world.getServer().getLoginConnector();
		if(connector != null) {
			connector.processIncomingPackets();
			connector.sendQueuedPackets();
		}
	}
	
	/**
	 * Processes incoming packets.
	 */
	private void processIncomingPackets() {
		for(RSCPacket p : packetQueue.getPackets()) {
			IoSession session = p.getSession();
			Player player = (Player)session.getAttachment();
			player.ping();
			PacketHandler handler = packetHandlers.get(p.getID());
			if (handler != null) {
				try {
					handler.handlePacket(p, session);
				}
				catch(Exception e) {
					Logger.error("Exception with p[" + p.getID() + "] from " + player.getUsername() + " [" + player.getCurrentIP() + "]: " + e.getMessage());
					player.getActionSender().sendLogout();
					player.destroy(false);
				}
			}
			else {
				Logger.error("Unhandled packet from " + player.getCurrentIP() + ": " + p.getID());
			}
		}
	}
	
	private void processEvents() {
		eventHandler.doEvents();
	}
	
	private void processClients() {
		clientUpdater.sendQueuedPackets();
		
		long now = System.currentTimeMillis();
		if(now - lastSentClientUpdate >= 600) {
			lastSentClientUpdate = now;
			clientUpdater.updateClients();
		}
	}

	/**
	 * Returns the current packet queue.
	 *
	 * @return A <code>PacketQueue</code>
	 */
	public PacketQueue getPacketQueue() {
		return packetQueue;
	}

	/**
	 * Loads the packet handling classes from the persistence
	 * manager.
	 */
	protected void loadPacketHandlers() {
		PacketHandlerDef[] handlerDefs = (PacketHandlerDef[])PersistenceManager.load("PacketHandlers.xml");
		for(PacketHandlerDef handlerDef : handlerDefs) {
			try {
				String className = handlerDef.getClassName();
				Class c = Class.forName(className);
				if (c != null) {
					PacketHandler handler = (PacketHandler)c.newInstance();
					for(int packetID : handlerDef.getAssociatedPackets()) {
						packetHandlers.put(packetID, handler);
					}
				}
			}
			catch (Exception e) {
				Logger.error(e);
			}
		}
	}

}
