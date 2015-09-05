package org.rscdaemon.server.npchandler;

import org.rscdaemon.server.model.Player;
import org.rscdaemon.server.model.Npc;
import org.rscdaemon.server.model.World;
import org.rscdaemon.server.model.InvItem;
import org.rscdaemon.server.model.ChatMessage;
import org.rscdaemon.server.model.MenuHandler;
import org.rscdaemon.server.event.ShortEvent;

public class Eventnpc1 implements NpcHandler {
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
				String[] options = new String[]{"90 certs: 25Mil Cash", "70 Certs: 17Mil Cash", "50 Certs: 12Mil Cash", "30 Certs: 8Mil Cash", "20 Certs: 5Mil Cash", "10 Certs: 1Mil Cash",};
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
								if(owner.getInventory().countId(1306) < 90) {
								owner.getActionSender().sendMessage("You dont have enough event certs for this item");
								}
								else if(owner.getInventory().remove(1306, 90) > -1) {
										owner.getActionSender().sendMessage("You swap 90 Certs for a 25M Cash"); 
										owner.getInventory().add(new InvItem(10, 25000000));
										owner.getActionSender().sendInventory();
										npc.unblock();		
										}
									}
								if(option == 1) {
								if(owner.getInventory().countId(1306) < 70) {
								owner.getActionSender().sendMessage("You dont have enough event certs for this item");
								}
								else if(owner.getInventory().remove(1306, 70) > -1) {
										owner.getActionSender().sendMessage("You swap 70 certs for 17Mil Cash");
										owner.getInventory().add(new InvItem(10, 17000000));
										owner.getActionSender().sendInventory();
										npc.unblock();
										}
									}
								if(option == 2) {
								if(owner.getInventory().countId(1306) < 50) {
								owner.getActionSender().sendMessage("You dont have enough event certs for this item");
								}
								else if(owner.getInventory().remove(1306, 50) > -1) {
										owner.getActionSender().sendMessage("You swap 50 certs for 12Mil Cash");
										owner.getInventory().add(new InvItem(10, 12000000));
										owner.getActionSender().sendInventory();
										npc.unblock();

										}
									}
								if(option == 3) {
								if(owner.getInventory().countId(1306) < 30) {
								owner.getActionSender().sendMessage("You dont have enough event certs for this item");
								}
									else if(owner.getInventory().remove(1306, 30) > -1) {
										owner.getActionSender().sendMessage("You swap 30 certs for 8Mil Cash");
										owner.getInventory().add(new InvItem(10, 8000000));
										owner.getActionSender().sendInventory();
										npc.unblock();
										}
									
									}
								if(option == 4) {
								if(owner.getInventory().countId(1306) < 20) {
								owner.getActionSender().sendMessage("You dont have enough event certs for this item");
								}
									else if(owner.getInventory().remove(1306, 20) > -1) {
										owner.getActionSender().sendMessage("You swap 20 certs for 5Mil Cash");
										owner.getInventory().add(new InvItem(10, 5000000));
										owner.getActionSender().sendInventory();
										npc.unblock();
										}
									
									}
								if(option == 5) {
								if(owner.getInventory().countId(1306) < 10) {
								owner.getActionSender().sendMessage("You dont have enough event certs for this item");
								}
									else if(owner.getInventory().remove(1306, 10) > -1) {
										owner.getActionSender().sendMessage("You swap 10 certs for 1.5Mil Cash");
										owner.getInventory().add(new InvItem(10, 1500000));
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