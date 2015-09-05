package org.rscdaemon.server.npchandler;

import org.rscdaemon.server.model.Player;
import org.rscdaemon.server.model.Npc;
import org.rscdaemon.server.model.World;
import org.rscdaemon.server.model.InvItem;
import org.rscdaemon.server.model.ChatMessage;
import org.rscdaemon.server.model.MenuHandler;
import org.rscdaemon.server.event.ShortEvent;

public class StatRemover implements NpcHandler {
	/**
	 * World instance
	 */
	public static final World world = World.getWorld();

	public void handleNpc(final Npc npc, Player player) throws Exception {
      		player.informOfNpcMessage(new ChatMessage(npc, "Which stats would you like reduced to level 1?", player));
      		player.setBusy(true);
      		world.getDelayedEventHandler().add(new ShortEvent(player) {
      			public void action() {
      				owner.setBusy(false);
				String[] options = new String[]{"Attack", "Defense", "Strength", "Prayer", "Magic"};
				owner.setMenuHandler(new MenuHandler(options) {
					public void handleReply(final int option, final String reply) {
						if(owner.isBusy()) {
							return;
						}
						owner.informOfChatMessage(new ChatMessage(owner, reply, npc));
						owner.setBusy(true);
						world.getDelayedEventHandler().add(new ShortEvent(owner) {
							public void action() {
								if(option == 0) {
      									owner.informOfNpcMessage(new ChatMessage(npc, "I will reduce your Attack to level 1.", owner));
      									
      									world.getDelayedEventHandler().add(new ShortEvent(owner) {
      										public void action() {
      											owner.setBusy(false);
      											owner.getActionSender().sendMessage("Your attack level has been reset.");
											if (owner.getMaxStat(0) <= 39) {
												owner.setMaxStat(0, 1);
												owner.setCurStat(0, 1);
												owner.setExp(0, 1);
										      	owner.getActionSender().sendStats();
										      	npc.unblock();
											} else {
      											owner.getActionSender().sendMessage("Sorry, you can only remove stats if they are lower than 40.");
      										}
      										}
      										
      									});
								} else 								if(option == 1) {
  									owner.informOfNpcMessage(new ChatMessage(npc, "I will reduce your Defense to level 1.", owner));
  									
  									world.getDelayedEventHandler().add(new ShortEvent(owner) {
  										public void action() {
  											owner.setBusy(false);
  											owner.getActionSender().sendMessage("Your defense level has been reset.");
										if (owner.getMaxStat(1) <= 39) {
											owner.setMaxStat(1, 1);
											owner.setCurStat(1, 1);
											owner.setExp(1, 1);
									      	owner.getActionSender().sendStats();
									      	npc.unblock();
										} else {
  											owner.getActionSender().sendMessage("Sorry, you can only remove stats if they are lower than 40.");
  										}
  										}
  										
  									});
							} else if(option == 2) {
  									owner.informOfNpcMessage(new ChatMessage(npc, "I will reduce your strength to level 1.", owner));
  									
  									world.getDelayedEventHandler().add(new ShortEvent(owner) {
  										public void action() {
  											owner.setBusy(false);
  											owner.getActionSender().sendMessage("Your strength level has been reset.");
										if (owner.getMaxStat(2) <= 39) {
											owner.setMaxStat(2, 1);
											owner.setCurStat(2, 1);
											owner.setExp(2, 1);
									      	owner.getActionSender().sendStats();
									      	npc.unblock();
										} else {
  											owner.getActionSender().sendMessage("Sorry, you can only remove stats if they are lower than 40.");
  										}
  										}
  										
  									});
							} else if(option == 3) {
  									owner.informOfNpcMessage(new ChatMessage(npc, "I will reduce your Prayer to level 1.", owner));
  									
  									world.getDelayedEventHandler().add(new ShortEvent(owner) {
  										public void action() {
  											owner.setBusy(false);
  											owner.getActionSender().sendMessage("Your prayer level has been reset.");
										if (owner.getMaxStat(5) <= 39) {
											owner.setMaxStat(5, 1);
											owner.setCurStat(5, 1);
											owner.setExp(5, 1);
									      	owner.getActionSender().sendStats();
									      	npc.unblock();
										} else {
  											owner.getActionSender().sendMessage("Sorry, you can only remove stats if they are lower than 40.");
  										}
  										}
  										
  									});
							} else if(option == 4) {
  									owner.informOfNpcMessage(new ChatMessage(npc, "I will reduce your magic to level 1.", owner));
  									
  									world.getDelayedEventHandler().add(new ShortEvent(owner) {
  										public void action() {
  											owner.setBusy(false);
  											owner.getActionSender().sendMessage("Your magic level has been reset.");
										if (owner.getMaxStat(6) <= 39) {
											owner.setMaxStat(6, 1);
											owner.setCurStat(6, 1);
											owner.setExp(6, 1);
									      	owner.getActionSender().sendStats();
									      	npc.unblock();
										} else {
  											owner.getActionSender().sendMessage("Sorry, you can only remove stats if they are lower than 40.");
  										}
  										}
  										
  									});
							}
								else {
									owner.setBusy(false);
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