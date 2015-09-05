package org.rscdaemon.server.packethandler.client;

import org.rscdaemon.server.packetbuilder.loginserver.MiscPacketBuilder;
import org.rscdaemon.server.packethandler.PacketHandler;
import org.rscdaemon.server.model.Player;
import org.rscdaemon.server.model.World;
import org.rscdaemon.server.net.Packet;
import org.rscdaemon.server.net.RSCPacket;

import org.apache.mina.common.IoSession;

public class FriendHandler implements PacketHandler {
	/**
	 * World instance
	 */
	public static final World world = World.getWorld();
	private MiscPacketBuilder loginSender = world.getServer().getLoginConnector().getActionSender();

	public void handlePacket(Packet p, IoSession session) throws Exception {
		Player player = (Player)session.getAttachment();
		int pID = ((RSCPacket)p).getID();
		
		long user = player.getUsernameHash();
		long friend = p.readLong();
		switch(pID) {
			case 168: // Add friend
				if(player.friendCount() >= 200) {
					player.getActionSender().sendMessage("Your friend list is too full");
					return;
				}
				loginSender.addFriend(user, friend);
				player.addFriend(friend, 0);
				break;
			case 52: // Remove friend
				loginSender.removeFriend(user, friend);
				player.removeFriend(friend);
				break;
			case 25: // Add ignore
				if(player.ignoreCount() >= 200) {
					player.getActionSender().sendMessage("Your ignore list is too full");
					return;
				}
				loginSender.addIgnore(user, friend);
				player.addIgnore(friend);
				break;
			case 108: // Remove ignore
				loginSender.removeIgnore(user, friend);
				player.removeIgnore(friend);
				break;
			case 254: // Send PM
				loginSender.sendPM(user, friend, player.isPMod(), p.getRemainingData());
				break;
		}
	}
	
}
