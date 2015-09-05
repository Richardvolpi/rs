package org.rscdaemon.server.npchandler;

import org.rscdaemon.server.model.Player;
import org.rscdaemon.server.model.Npc;
import org.rscdaemon.server.model.World;
import org.rscdaemon.server.model.InvItem;
import org.rscdaemon.server.model.ChatMessage;
import org.rscdaemon.server.model.MenuHandler;
import org.rscdaemon.server.event.DelayedEvent;
import org.rscdaemon.server.event.ShortEvent;

//Fisherman.java remake by zraffz

public class Fisherman implements NpcHandler {

	public static final World world = World.getWorld();

	public void handleNpc(final Npc npc, Player player) throws Exception {
      		player.informOfNpcMessage(new ChatMessage(npc, "How many free lobsters can I interest you in?", player));
      		player.setBusy(true);
		world.getDelayedEventHandler().add(new ShortEvent(player) {
			public void action() {
				owner.setBusy(false);
				String[] options = new String[]{"Five", "Ten", "Fifteen", "Twenty", "Twenty-Five", "None"};
				owner.setMenuHandler(new MenuHandler(options) {
					public void handleReply(final int option, final String reply) {
						if(owner.isBusy()) {
							return;
						}
						owner.informOfChatMessage(new ChatMessage(owner, reply, npc));
						owner.setBusy(true);
						world.getDelayedEventHandler().add(new ShortEvent(owner) {
							public void action() {
								switch(option) {
									case 0: //5
										world.getDelayedEventHandler().add(new ShortEvent(owner) {
											public void action() {
												owner.setBusy(false);
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getActionSender().sendInventory();
												npc.unblock();
											}
										});
										break;
									case 1: //10
										world.getDelayedEventHandler().add(new ShortEvent(owner) {
											public void action() {
												owner.setBusy(false);
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getActionSender().sendInventory();
												npc.unblock();
											}
										});
										npc.unblock();
										break;
									case 2: //15
										world.getDelayedEventHandler().add(new ShortEvent(owner) {
											public void action() {
												owner.setBusy(false);
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getActionSender().sendInventory();
												npc.unblock();
											}
										});
										npc.unblock();
										break;
									case 3: //20
										world.getDelayedEventHandler().add(new ShortEvent(owner) {
											public void action() {
												owner.setBusy(false);
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getActionSender().sendInventory();
												npc.unblock();
											}
										});
										npc.unblock();
										break;
									case 4: //25
										world.getDelayedEventHandler().add(new ShortEvent(owner) {
											public void action() {
												owner.setBusy(false);
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getInventory().add(new InvItem(370, 1));
												owner.getActionSender().sendInventory();
												npc.unblock();
											}
										});
										npc.unblock();
										break;
									case 5:
										owner.setBusy(false);
										owner.informOfNpcMessage(new ChatMessage(npc, "Alright... suit yourself faggot.", owner));
										npc.unblock();
										break;
									default:
										owner.setBusy(false);
										npc.unblock();
										break;
								}
								
							}
						});
					}
				});
				owner.getActionSender().sendMenu(options);
			}
		});
		npc.blockedBy(player);
	}
	
}