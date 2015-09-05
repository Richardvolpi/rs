package org.rscdaemon.ls.packethandler.loginserver;

import org.rscdaemon.ls.packethandler.PacketHandler;
import org.rscdaemon.ls.model.PlayerSave;
import org.rscdaemon.ls.model.World;
import org.rscdaemon.ls.Server;
import org.rscdaemon.ls.net.LSPacket;
import org.rscdaemon.ls.net.Packet;

import org.apache.mina.common.IoSession;

import java.sql.SQLException;

public class GameSettingHandler implements PacketHandler {

	public void handlePacket(Packet p, IoSession session) throws Exception {
		World world = (World)session.getAttachment();
		long user = p.readLong();
		boolean on = p.readByte() == 1;
		int idx = (int)p.readByte();
		switch(idx) {
			case 0: // Camera Auto
				try { Server.db.updateQuery("UPDATE `rscd_players` SET cameraauto=" + (on ? 1 : 0) + " WHERE user=" + user); } catch(SQLException e) { Server.error(e.getMessage()); }
				break;
			case 2: // One Mouse
				try { Server.db.updateQuery("UPDATE `rscd_players` SET onemouse=" + (on ? 1 : 0) + " WHERE user=" + user); } catch(SQLException e) { Server.error(e.getMessage()); }
				break;
			case 3: // Sound Off
				try { Server.db.updateQuery("UPDATE `rscd_players` SET soundoff=" + (on ? 1 : 0) + " WHERE user=" + user); } catch(SQLException e) { Server.error(e.getMessage()); }
				break;
			case 4: // Show Roof
				try { Server.db.updateQuery("UPDATE `rscd_players` SET showroof=" + (on ? 1 : 0) + " WHERE user=" + user); } catch(SQLException e) { Server.error(e.getMessage()); }
				break;
			case 5: // Auto Screenshot
				try { Server.db.updateQuery("UPDATE `rscd_players` SET autoscreenshot=" + (on ? 1 : 0) + " WHERE user=" + user); } catch(SQLException e) { Server.error(e.getMessage()); }
				break;
			case 6: // Combat Window
				try { Server.db.updateQuery("UPDATE `rscd_players` SET combatwindow=" + (on ? 1 : 0) + " WHERE user=" + user); } catch(SQLException e) { Server.error(e.getMessage()); }
				break;
		}
		Server.getServer().findSave(user, world).setGameSetting(idx, on);
	}
	
}