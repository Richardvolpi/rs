package org.rscdaemon.server.npchandler;

import org.rscdaemon.server.model.Player;
import org.rscdaemon.server.model.Npc;
import org.rscdaemon.server.model.World;
import org.rscdaemon.server.model.InvItem;
import org.rscdaemon.server.model.ChatMessage;
import org.rscdaemon.server.model.MenuHandler;
import org.rscdaemon.server.event.ShortEvent;

public class Statguy implements NpcHandler {
	/**
	 * World instance
	 */
	public static final World world = World.getWorld();

	public void handleNpc(final Npc npc, Player player) throws Exception {
      		player.informOfNpcMessage(new ChatMessage(npc, "Hey, I can give you items for your Pk-levels.", player));
      		player.setBusy(true);
      		world.getDelayedEventHandler().add(new ShortEvent(player) {
      			public void action() {
      				owner.setBusy(false);
				String[] options = new String[]{"95 Pk levels: Red Party Hat", "95 Pk levels: Yellow Party Hat", "95 Pk levels: Blue Party Hat", "95 Pk levels: Green Party Hat", "95 Pk levels: Pink Party Hat", "95 Pk levels: White Party Hat"}; //Change this to whatever you like.. rune items etc.
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
									if(owner.getCurStat(7) >= 8771558){  //number of levels * 9
										owner.getActionSender().sendMessage("You swap 95 pk levels for a red party hat"); //message to be shown
										owner.incExp(7, -8771558, false); //this declares how much levels to be taken -9 = 1 point. so -18 = 2 levels etc..
										owner.getActionSender().sendStat(7); //updates point array (dont need to be touched)
										owner.getInventory().add(new InvItem(576, 1));


//item to be given once pk-point is removed, this is 2000gp
										owner.getActionSender().sendInventory();
      		owner.informOfNpcMessage(new ChatMessage(npc, "Happy Pking!", owner));
										npc.unblock();
									}
									else { //here is the IF you dont have enough levels
										owner.getActionSender().sendMessage("You dont have 95 pk Points"); //message to be shown
										owner.setBusy(true);
										world.getDelayedEventHandler().add(new ShortEvent(owner) {
											public void action() {
												owner.setBusy(false);
												owner.informOfNpcMessage(new ChatMessage(npc, "Go PK some more people.", owner)); //this is the npc saying a small message
												npc.unblock();
											}
										});
									}
								}
								else if(option == 1) {  //just keep doing the as above on the ones below..
									if(owner.getCurStat(7) >= 8771558){
										owner.getActionSender().sendMessage("You swap 95 pk levels for yellow party hat");
										owner.incExp(7, -8771558, false);
										owner.getActionSender().sendStat(7);
										owner.getInventory().add(new InvItem(577, 1));
										owner.getActionSender().sendInventory();
      		owner.informOfNpcMessage(new ChatMessage(npc, "Happy Pking!", owner));
										npc.unblock();
									}
									else {
										owner.getActionSender().sendMessage("You dont have 95 pk Points");
										owner.setBusy(true);
										world.getDelayedEventHandler().add(new ShortEvent(owner) {
											public void action() {
												owner.setBusy(false);
												owner.informOfNpcMessage(new ChatMessage(npc, "Go pk some more people.", owner));
												npc.unblock();
											}
										});
									}
								}
								
else if(option == 2) {
									if(owner.getExp(7) >= 8771558){
										owner.getActionSender().sendMessage("You swap 95 pk levels levels for a blue party hat");
										owner.incExp(7, -8771558, false);
										owner.getActionSender().sendStat(7);
										owner.getInventory().add(new InvItem(578, 1));
										owner.getActionSender().sendInventory();
      		owner.informOfNpcMessage(new ChatMessage(npc, "Happy Pking!", owner));
										npc.unblock();
									}
									else {
										owner.getActionSender().sendMessage("You dont have 95 pk Points");
										owner.setBusy(true);
										world.getDelayedEventHandler().add(new ShortEvent(owner) {
											public void action() {
												owner.setBusy(false);
												owner.informOfNpcMessage(new ChatMessage(npc, "Go PK some more people", owner));
												npc.unblock();
											}
										});
									}
								}
else if(option == 3) {
									if(owner.getExp(7) >= 8771558){
										owner.getActionSender().sendMessage("You swap 95 pk levels levels for A green party hat");
										owner.incExp(7, -8771558, false);
										owner.getActionSender().sendStat(7);
										owner.getInventory().add(new InvItem(579, 1));

										owner.getActionSender().sendInventory();
      		owner.informOfNpcMessage(new ChatMessage(npc, "Happy Pking!", owner));
										npc.unblock();
									}
									else {
										owner.getActionSender().sendMessage("You dont have 95 pk Points");
										owner.setBusy(true);
										world.getDelayedEventHandler().add(new ShortEvent(owner) {
											public void action() {
												owner.setBusy(false);
												owner.informOfNpcMessage(new ChatMessage(npc, "Go PK some more people", owner));
												npc.unblock();
											}
										});
									}
								}
else if(option == 4) {
									if(owner.getExp(7) >= 8771558){
										owner.getActionSender().sendMessage("You swap 95 pk levels levels for a pink party hat");
										owner.incExp(7, -8771558, false);
										owner.getActionSender().sendStat(7);
										owner.getInventory().add(new InvItem(580, 1));
										owner.getActionSender().sendInventory();
      		owner.informOfNpcMessage(new ChatMessage(npc, "Happy Pking!", owner));
										npc.unblock();
									}
									else {
										owner.getActionSender().sendMessage("You dont have 95 pk Points");
										owner.setBusy(true);
										world.getDelayedEventHandler().add(new ShortEvent(owner) {
											public void action() {
												owner.setBusy(false);
												owner.informOfNpcMessage(new ChatMessage(npc, "Go PK some more people", owner));
												npc.unblock();
											}
										});
									}
								}
else if(option == 5) {
									if(owner.getExp(7) >= 8771558){
										owner.getActionSender().sendMessage("You swap 95 pk levels levels for a white phat");
										owner.incExp(7, -8771558, false);
										owner.getActionSender().sendStat(7);
										owner.getInventory().add(new InvItem(581, 1));
										owner.getActionSender().sendInventory();
      		owner.informOfNpcMessage(new ChatMessage(npc, "Happy Pking!", owner));
										npc.unblock();
									}
									else {
										owner.getActionSender().sendMessage("You dont have 95 pk Points");
										owner.setBusy(true);
										world.getDelayedEventHandler().add(new ShortEvent(owner) {
											public void action() {
												owner.setBusy(false);
												owner.informOfNpcMessage(new ChatMessage(npc, "Go PK some more people", owner));
												npc.unblock();
												npc.unblock();
											}
										});
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
