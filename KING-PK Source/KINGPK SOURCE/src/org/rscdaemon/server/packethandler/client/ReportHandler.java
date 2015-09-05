package org.rscdaemon.server.packethandler.client;

import org.rscdaemon.server.packethandler.PacketHandler;
import org.rscdaemon.server.model.*;
import org.rscdaemon.server.net.Packet;
import org.apache.mina.common.IoSession;

public class ReportHandler implements PacketHandler {
	public static final World world = World.getWorld();

	public void handlePacket(Packet p, IoSession session) throws Exception {
		Player player = (Player)session.getAttachment();
		player.getActionSender().sendMessage("Nice try, Bastard.");
	}
	
}