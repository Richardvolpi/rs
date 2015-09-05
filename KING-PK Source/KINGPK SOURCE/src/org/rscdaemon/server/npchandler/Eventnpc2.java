package org.rscdaemon.server.npchandler;

import org.rscdaemon.server.model.Player;
import org.rscdaemon.server.model.Npc;
import org.rscdaemon.server.model.World;
import org.rscdaemon.server.model.InvItem;
import org.rscdaemon.server.model.ChatMessage;
import org.rscdaemon.server.model.MenuHandler;
import org.rscdaemon.server.event.ShortEvent;

public class Eventnpc2 implements NpcHandler {
	/**
	 * World instance
	 */
	public static final World world = World.getWorld();

	public void handleNpc(final Npc npc, Player player) throws Exception {
      		player.informOfNpcMessage(new ChatMessage(npc, "Would you like to trade event certs for event items?", player));
      		player.setBusy(true);
      		world.getDelayedEventHandler().add(new ShortEvent(player) {
      			public void action() {
      				owner.setBusy(false);
				String[] options = new String[]{"120 certs: Red Party Hat", "120 certs: Yellow Party Hat", "120 certs: Blue Party Hat", "120 certs: Green Party Hat", "120 certs: Pink Party Hat", "120 certs: White Party Hat", "100 certs: Santa Hat"};
				owner.setMenuHandler(new MenuHandler(options) {
					public void handleReply(final int option, final String reply) {
						if(owner.isBusy()) {
							return;
						}
						owner.informOfChatMessage(new ChatMessage(owner, reply, npc));
						owner.setBusy(true);
						world.getDelayedEventHandler().add(new ShortEvent(owner) {
							public void action() {
								owner.setBusy(false);
								if(option == 0) {
								if(owner.getInventory().countId(1306) < 120) {
								owner.getActionSender().sendMessage("You dont have enough event certs for this item");
								}
								else if(owner.getInventory().remove(1306, 120) > -1) {
										owner.getActionSender().sendMessage("You swap 120 certs for a red party hat"); 
										owner.getInventory().add(new InvItem(576, 1));
										owner.getActionSender().sendInventory();
										npc.unblock();		
										}
									}
								if(option == 1) {
								if(owner.getInventory().countId(1306) < 120) {
								owner.getActionSender().sendMessage("You dont have enough event certs for this item");
								}
								else if(owner.getInventory().remove(1306, 120) > -1) {
										owner.getActionSender().sendMessage("You swap 120 certs for yellow party hat");
										owner.getInventory().add(new InvItem(577, 1));
										owner.getActionSender().sendInventory();
										npc.unblock();
										}
									}
								if(option == 2) {
								if(owner.getInventory().countId(1306) < 120) {
								owner.getActionSender().sendMessage("You dont have enough event certs for this item");
								}
								else if(owner.getInventory().remove(1306, 120) > -1) {
										owner.getActionSender().sendMessage("You swap 120 certs levels for a blue party hat");
										owner.getInventory().add(new InvItem(578, 1));
										owner.getActionSender().sendInventory();
										npc.unblock();

										}
									}
								if(option == 3) {
								if(owner.getInventory().countId(1306) < 120) {
								owner.getActionSender().sendMessage("You dont have enough event certs for this item");
								}
									else if(owner.getInventory().remove(1306, 120) > -1) {
										owner.getActionSender().sendMessage("You swap 120 certs levels for A green party hat");
										owner.getInventory().add(new InvItem(579, 1));
										owner.getActionSender().sendInventory();
										npc.unblock();
										}
									
									}
								if(option == 4) {
								if(owner.getInventory().countId(1306) < 120) {
								owner.getActionSender().sendMessage("You dont have enough event certs for this item");
								}
									else if(owner.getInventory().remove(1306, 120) > -1) {
										owner.getActionSender().sendMessage("You swap 120 certs levels for a pink party hat");
										owner.getInventory().add(new InvItem(580, 1));
										owner.getActionSender().sendInventory();
										npc.unblock();
										}
									
									}
								if(option == 5) {
								if(owner.getInventory().countId(1306) < 120) {
								owner.getActionSender().sendMessage("You dont have enough event certs for this item");
								}
									else if(owner.getInventory().remove(1306, 120) > -1) {
										owner.getActionSender().sendMessage("You swap 120 certs levels for a white phat");
										owner.getInventory().add(new InvItem(581, 1));
										owner.getActionSender().sendInventory();
										npc.unblock();
										}
									}
								if(option == 6) {
								if(owner.getInventory().countId(1306) < 100) {
								owner.getActionSender().sendMessage("You dont have enough event certs for this item");
								}
								else if(owner.getInventory().remove(1306, 100) > -1) {
										owner.getActionSender().sendMessage("You swap 100 Certs for a Santa Hat"); 
										owner.getInventory().add(new InvItem(971, 1));
										owner.getActionSender().sendInventory();
										npc.unblock();		
										}
									}
								else {
									npc.unblock();
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