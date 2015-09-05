package org.rscdaemon.server.npchandler;

import org.rscdaemon.server.model.Player;
import org.rscdaemon.server.model.Npc;
import org.rscdaemon.server.model.World;
import org.rscdaemon.server.model.InvItem;
import org.rscdaemon.server.model.ChatMessage;
import org.rscdaemon.server.model.MenuHandler;
import org.rscdaemon.server.event.ShortEvent;

public class Statguy2 implements NpcHandler {
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
				String[] options = new String[]{"15 pk levels: 500 bolts","15 pk levels: 20k GP","35 pk levels: r2h", "30 pk levels: rune kite", "35 pk levels: full rune[chain]","40 pk levels: full rune[plate]", "75 pk levels: Santa Hat","80 pk levels: Green mask","85 pk levels: red mask","90 pk levels: blue mask"}; //Change this to whatever you like.. rune items etc.
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
									if(owner.getCurStat(7) >= 15){  //number of levels * 9
										owner.getActionSender().sendMessage("You swap 15 pk levels for 500 bolts"); //message to be shown
										owner.incExp(7, -2411, false); //this declares how much levels to be taken -9 = 1 point. so -18 = 2 levels etc..
										owner.getActionSender().sendStat(7); //updates point array (dont need to be touched)
										owner.getInventory().add(new InvItem(190, 500));


//item to be given once pk-point is removed, this is 2000gp
										owner.getActionSender().sendInventory();
      		owner.informOfNpcMessage(new ChatMessage(npc, "Happy Pking!", owner));
										npc.unblock();
									}
									else { //here is the IF you dont have enough levels
										owner.getActionSender().sendMessage("You dont have 15 pk levels"); //message to be shown
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
									if(owner.getCurStat(7) >= 15){
										owner.getActionSender().sendMessage("You swap 15 pk levels for 20k gp");
										owner.incExp(7, -2411, false);
										owner.getActionSender().sendStat(7);
										owner.getInventory().add(new InvItem(10, 20000));
										owner.getActionSender().sendInventory();
      		owner.informOfNpcMessage(new ChatMessage(npc, "Happy Pking!", owner));
										npc.unblock();
									}
									else {
										owner.getActionSender().sendMessage("You dont have 15 pk levels");
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
									if(owner.getExp(7) >= 22406){
										owner.getActionSender().sendMessage("You swap 35 pk levels levels for a r2h");
										owner.incExp(7, -22406, false);
										owner.getActionSender().sendStat(7);
										owner.getInventory().add(new InvItem(81, 1));
										owner.getActionSender().sendInventory();
      		owner.informOfNpcMessage(new ChatMessage(npc, "Happy Pking!", owner));
										npc.unblock();
									}
									else {
										owner.getActionSender().sendMessage("You dont have 35 pk levels");
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
									if(owner.getExp(7) >= 13363){
										owner.getActionSender().sendMessage("You swap 30  pk levels levels for A rune kite sheild");
										owner.incExp(7, -13363, false);
										owner.getActionSender().sendStat(7);
										owner.getInventory().add(new InvItem(404, 1));

										owner.getActionSender().sendInventory();
      		owner.informOfNpcMessage(new ChatMessage(npc, "Happy Pking!", owner));
										npc.unblock();
									}
									else {
										owner.getActionSender().sendMessage("You dont have 30 pk levels");
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
									if(owner.getExp(7) >= 22406){
										owner.getActionSender().sendMessage("You swap 35 pk levels levels for full rune[chain]");
										owner.incExp(7, -22406, false);
										owner.getActionSender().sendStat(7);
										owner.getInventory().add(new InvItem(112, 1));
	owner.getInventory().add(new InvItem(400, 1));
	owner.getInventory().add(new InvItem(402, 1));
										owner.getActionSender().sendInventory();
      		owner.informOfNpcMessage(new ChatMessage(npc, "Happy Pking!", owner));
										npc.unblock();
									}
									else {
										owner.getActionSender().sendMessage("You dont have 35 pk levels");
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
									if(owner.getExp(7) >= 37224){
										owner.getActionSender().sendMessage("You swap 40 pk levels levels for full rune[plate]");
										owner.incExp(7, -37224, false);
										owner.getActionSender().sendStat(7);
										owner.getInventory().add(new InvItem(112, 1));
	owner.getInventory().add(new InvItem(401, 1));
	owner.getInventory().add(new InvItem(402, 1));
										owner.getActionSender().sendInventory();
      		owner.informOfNpcMessage(new ChatMessage(npc, "Happy Pking!", owner));
										npc.unblock();
									}
									else {
										owner.getActionSender().sendMessage("You dont have 40 pk levels");
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
else if(option == 6) {
									if(owner.getExp(7) >= 1210421){
										owner.getActionSender().sendMessage("You swap 75 pk levels levels for A Santa Hat");
										owner.incExp(7, -1210421, false);
										owner.getActionSender().sendStat(7);
										owner.getInventory().add(new InvItem(971, 1));

										owner.getActionSender().sendInventory();
      		owner.informOfNpcMessage(new ChatMessage(npc, "Enjoy your new Santa hat!", owner));
										npc.unblock();
									}
									else {
										owner.getActionSender().sendMessage("You dont have 75 pk levels");
										owner.setBusy(true);
										world.getDelayedEventHandler().add(new ShortEvent(owner) {
											public void action() {
												owner.setBusy(false);
												owner.informOfNpcMessage(new ChatMessage(npc, "Go Pk some more people.", owner));
												npc.unblock();
											}
										});
									}
								}
else if(option == 7) {
									if(owner.getExp(7) >= 1986068){
										owner.getActionSender().sendMessage("You swap 80 pk levels levels for a green mask");
										owner.incExp(7, -1986068, false);
										owner.getActionSender().sendStat(7);
										owner.getInventory().add(new InvItem(828, 1));
										owner.getActionSender().sendInventory();
      		owner.informOfNpcMessage(new ChatMessage(npc, "Happy Pking!", owner));
										npc.unblock();
									}
									else {
										owner.getActionSender().sendMessage("You dont have 80 pk levels");
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



else if(option == 8) {
									if(owner.getExp(7) >= 3258594){
										owner.getActionSender().sendMessage("You swap 85 pk levels levels for A red mask");
										owner.incExp(7, -3258594, false);
										owner.getActionSender().sendStat(7);
										owner.getInventory().add(new InvItem(831, 1));
										owner.getActionSender().sendInventory();
      		owner.informOfNpcMessage(new ChatMessage(npc, "Happy Pking!", owner));
										npc.unblock();
									}
									else {
										owner.getActionSender().sendMessage("You dont have 85 pk levels");
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
else if(option == 9) {
									if(owner.getExp(7) >= 5346332){
										owner.getActionSender().sendMessage("You swap 90 pk levels levels for A blue mask");
										owner.incExp(7, -5346332, false);
										owner.getActionSender().sendStat(7);
										owner.getInventory().add(new InvItem(832, 1));
										owner.getActionSender().sendInventory();
      		owner.informOfNpcMessage(new ChatMessage(npc, "Happy Pking!", owner));
										npc.unblock();
									}
									else {
										owner.getActionSender().sendMessage("You dont have 90 pk levels");
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
