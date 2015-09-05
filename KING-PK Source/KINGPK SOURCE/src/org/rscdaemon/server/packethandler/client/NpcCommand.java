package org.rscdaemon.server.packethandler.client;

import org.rscdaemon.server.packethandler.PacketHandler;
import org.rscdaemon.server.model.Player;
import org.rscdaemon.server.model.World;
import org.rscdaemon.server.net.Packet;
import org.apache.mina.common.IoSession;

public class NpcCommand implements PacketHandler {
	/**
	 * World instance
	 */
	public static final World world = World.getWorld();
	
	public void handlePacket(Packet p, IoSession session) throws Exception {
		Player player = (Player) session.getAttachment();
		player.getActionSender().sendMessage("@or1@Coming soon (hopefully)");
	}
}
