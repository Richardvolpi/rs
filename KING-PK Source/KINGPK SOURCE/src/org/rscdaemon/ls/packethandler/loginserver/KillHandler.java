package org.rscdaemon.ls.packethandler.loginserver;

import org.rscdaemon.ls.packethandler.PacketHandler;
import org.rscdaemon.ls.Server;
import org.rscdaemon.ls.net.LSPacket;
import org.rscdaemon.ls.net.Packet;

import org.apache.mina.common.IoSession;

import java.sql.SQLException;

public class KillHandler implements PacketHandler {

	public void handlePacket(Packet p, IoSession session) throws Exception {
		try { Server.db.updateQuery("INSERT INTO `rscd_kills`(`user`, `killed`, `time`, `type`) VALUES('" + p.readLong() + "', '" + p.readLong() + "', " + (int)(System.currentTimeMillis() / 1000) + ", " + p.readByte() + ")"); } catch(SQLException e) { }
	}
	
}