package org.rscdaemon.server.packethandler.client;

import org.rscdaemon.server.packethandler.PacketHandler;
import org.rscdaemon.server.model.World;
import org.rscdaemon.server.net.Packet;
import org.rscdaemon.server.model.Player;
import org.apache.mina.common.IoSession;

public class PlayerLogoutRequest implements PacketHandler {
	/**
	 * World instance
	 */
	public static final World world = World.getWorld();
	
	public void handlePacket(Packet p, IoSession session) throws Exception {
		Player player = (Player) session.getAttachment();
		if(System.currentTimeMillis() - player.getLastMoved() < 10000 && player.getLocation().inWilderness()) {
			player.getActionSender().sendMessage("You must be stationary for 10 seconds to logout in the wilderness.");
			player.getActionSender().sendCantLogout();
			return;
			}
		if(player.canLogout()) {
                        player.checkDm();
			player.destroy(true);
		}
		else {
			player.getActionSender().sendCantLogout();
		}
	}
}
