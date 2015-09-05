package org.rscdaemon.server.npchandler;

import org.rscdaemon.server.model.Player;
import org.rscdaemon.server.model.Npc;
import org.rscdaemon.server.model.World;
import org.rscdaemon.server.model.InvItem;
import org.rscdaemon.server.model.ChatMessage;
import org.rscdaemon.server.model.MenuHandler;
import org.rscdaemon.server.event.ShortEvent;
import org.rscdaemon.server.model.Inventory;

public class purepk implements NpcHandler {
	/**
	 * World instance
	 */
	public static final World world = World.getWorld();

	public void handleNpc(final Npc npc, Player player) throws Exception {
      		player.informOfNpcMessage(new ChatMessage(npc, "Hello there! Would you like to go to Pure-Pk Square?", player));
      		player.setBusy(true);
      		world.getDelayedEventHandler().add(new ShortEvent(player) {
      			public void action() {
      				owner.setBusy(false);
				String[] options = new String[]{"Yes", "No"}; //Change this to whatever you like.. rune items etc.
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
								if(option == 0) { //option 0 = 1k levels [2k gp] wich means option 1 is 15k levels [20k gp}.
									if(owner.getMaxStat(1) < 10){  //number of levels * 9
										owner.informOfNpcMessage(new ChatMessage(npc, "Be careful!", owner));
										owner.teleport(329, 308, false);
										owner.getActionSender().sendMessage("Your inv has been filled with swordies if it wasnt already."); //message to be shown
										Inventory inventory = owner.getInventory();
										while(!inventory.full()) {
										owner.getInventory().add(new InvItem(370, 1));
										owner.getActionSender().sendInventory();
										owner.getActionSender().sendInventory();
										}
										npc.unblock();
									}
									else { //here is the IF you dont have enough levels
										owner.getActionSender().sendMessage("Only 1-10 def pures are allowed in Pure-Pk Square."); //message to be shown
										owner.setBusy(true);
										world.getDelayedEventHandler().add(new ShortEvent(owner) {
											public void action() {
												owner.setBusy(false);
												npc.unblock();
											}
										});
									}
								}
								else if(option == 1) {  //just keep doing the as above on the ones below..
										owner.setBusy(true);
										world.getDelayedEventHandler().add(new ShortEvent(owner) {
										public void action()
										{
										owner.setBusy(false);
										npc.unblock();
										}
									});
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
//swag
