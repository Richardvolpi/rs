package org.rscdaemon.server.packethandler.client;

import org.rscdaemon.server.packethandler.PacketHandler;
import org.rscdaemon.server.model.Npc;
import org.rscdaemon.server.model.World;
import org.rscdaemon.server.model.Player;
import org.rscdaemon.server.net.Packet;
import org.rscdaemon.server.event.WalkToMobEvent;
import org.rscdaemon.server.npchandler.NpcHandler;
import org.rscdaemon.server.util.Logger;
import org.rscdaemon.server.states.Action;
import org.rscdaemon.server.quest.QuestTrigger;
import org.apache.mina.common.IoSession;

public class TalkToNpcHandler implements PacketHandler {
	/**
	 * World instance
	 */
	public static final World world = World.getWorld();

	public void handlePacket(Packet p, IoSession session) throws Exception {
		Player player = (Player)session.getAttachment();
		if(player.isBusy()) {
			player.resetPath();
			return;
		}
		player.resetAll();
		final Npc affectedNpc = world.getNpc(p.readShort());
  		if(affectedNpc == null) { // This shouldn't happen
  			return;
  		}
  		player.setFollowing(affectedNpc);
  		player.setStatus(Action.TALKING_MOB);
  		world.getDelayedEventHandler().add(new WalkToMobEvent(player, affectedNpc, 1) {
			public void arrived() {
				owner.resetPath();
				if(owner.isBusy() || owner.isRanging() || !owner.nextTo(affectedNpc) || owner.getStatus() != Action.TALKING_MOB) {
					return;
				}
				owner.resetAll();
				if(affectedNpc.isBusy()) {
					owner.getActionSender().sendMessage(affectedNpc.getDef().getName() + " is currently busy.");
					return;
				}
				affectedNpc.resetPath();
				NpcHandler handler = world.getNpcHandler(affectedNpc.getID());
				boolean quest = owner.getQuestManager().associatedWithQuest(affectedNpc);
		      		if(handler != null) {
		      			try {
		      				handler.handleNpc(affectedNpc, owner);
		      			}
		      			catch(Exception e) {
						Logger.error("Exception with npc[" + affectedNpc.getIndex() + "] from " + owner.getUsername() + " [" + owner.getCurrentIP() + "]: " + e.getMessage());
						owner.getActionSender().sendLogout();
						owner.destroy(false);
		      			}
		      		} else if (quest) {
		      			owner.getQuestManager().triggerEntity(QuestTrigger.NPC_TALK, affectedNpc);
		      		}
			}
      		});
	}
}