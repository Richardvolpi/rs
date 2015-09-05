package org.rscdaemon.server.packethandler.client;

import org.rscdaemon.server.packethandler.PacketHandler;
import org.rscdaemon.server.packethandler.client.ChatHandler;//muting future
import org.rscdaemon.server.packetbuilder.loginserver.MiscPacketBuilder;
import org.rscdaemon.server.model.*;
import org.rscdaemon.server.net.Packet;
import org.rscdaemon.server.util.DataConversions;
import org.rscdaemon.server.entityhandling.EntityHandler;
import org.rscdaemon.server.util.Logger;
import org.rscdaemon.server.event.SingleEvent;
import org.rscdaemon.server.states.CombatState;
import org.rscdaemon.server.states.Action;
import org.rscdaemon.server.util.Formulae;
import java.util.*;

import org.apache.mina.common.IoSession;

public class CommandHandler implements PacketHandler {
	/**
	 * World instance
	 */
	public static final World world = World.getWorld();
	public long lasttime;
    String lastplayer;
    public long lastmessage;
	
	public void handlePacket(Packet p, IoSession session) throws Exception {
		Player player = (Player)session.getAttachment();
	    	if(player.isBusy()) {
	    		player.resetPath();
	      		return;
	    	}
	   	player.resetAll();
		String s = new String(p.getData()).trim();
		int firstSpace = s.indexOf(" ");
		String cmd = s;
		String[] args = new String[0];
		if(firstSpace != -1) {
			cmd = s.substring(0, firstSpace).trim();
			args = s.substring(firstSpace + 1).trim().split(" ");
		}
		try {
			handleCommand(cmd.toLowerCase(), args, player);
		}
		catch(Exception e) { }
	}
	
	public void handleCommand(String cmd, String[] args, Player player) throws Exception {
		MiscPacketBuilder loginServer = world.getServer().getLoginConnector().getActionSender();
		
			if(cmd.equals("home")) 
			{
				if(player.isSubscriber() && !player.inCombat())
				{
					if(player.getLocation().inModRoom() || player.getLocation().inWilderness()) 
					{
					player.getActionSender().sendMessage("You cannot use ::home here");
					return;
					}
					player.teleport(72, 3639, true);
					player.resetPath();
										for(InvItem item : player.getInventory().getItems()) {
      		if(EntityHandler.getItemWieldableDef(item.getID()).p2pOnly() && item.isWielded()) {
			player.getActionSender().sendMessage("You're not in a p2p area!");
					item.setWield(false);
      		      	player.updateWornItems(item.getWieldableDef().getWieldPos(), player.getPlayerAppearance().getSprite(item.getWieldableDef().getWieldPos()));
      						player.getActionSender().sendInventory();
      						player.getActionSender().sendEquipmentStats();      				
		}
			}
					return;
				} 
			}
			
			if(cmd.equals("change")) {
			if(player.getLocation().inWilderness()) {
				player.getActionSender().sendMessage("You are in the wilderness");
				return;
			}
			if(!player.isSubscriber()) {
				return;
			}
			int attack = Integer.parseInt(args[0]);
			int defense = Integer.parseInt(args[1]);
			int strength = Integer.parseInt(args[2]);
			int hpxp = (1200 + (Formulae.lvlToXp(attack) + Formulae.lvlToXp(defense) + Formulae.lvlToXp(strength)) / 3);
			int newHP = Formulae.experienceToLevel(hpxp);
			if(strength <= 0 || strength >= 100) {
				player.getActionSender().sendMessage("Invalid selection for Strength.");
				return;
			}
			if(attack <= 0 || attack >= 100) {
				player.getActionSender().sendMessage("Invalid selection for Attack.");
				return;
			}
			if(defense <= 0 || defense >= 100) {
				player.getActionSender().sendMessage("Invalid selection for Defense.");
				return;
			} else		

			player.setCurStat(0, attack);
			player.setMaxStat(0, attack);
			player.setExp(0, Formulae.lvlToXp(attack));
			player.checkEquipment();
			
			player.setCurStat(1, defense);
			player.setMaxStat(1, defense);
			player.setExp(1, Formulae.lvlToXp(defense));
			player.checkEquipment();
			
			player.setCurStat(2, strength);
			player.setMaxStat(2, strength);
			player.setExp(2, Formulae.lvlToXp(strength));
			
			player.setCurStat(3, newHP);
			player.setMaxStat(3, newHP);
			player.setExp(3, Formulae.lvlToXp(newHP));
			
			player.getActionSender().sendStats();
			int comb = Formulae.getCombatlevel(player.getMaxStats());
			if(comb != player.getCombatLevel()) {
				player.setCombatLevel(comb);
			    player.getActionSender().sendStats();
			}
		}



if(cmd.equals("range")) {
	if(player.getLocation().inWilderness()) {
		player.getActionSender().sendMessage("You are in the wilderness");
		return;
	}
	if(!player.isSubscriber()) {
				return;
			}
	int ranged = Integer.parseInt(args[0]);
	if(ranged <= 0 || ranged >= 100) {
		player.getActionSender().sendMessage("Invalid selection for Ranged.");
		return;
	}
	player.setCurStat(4, ranged);
	player.setMaxStat(4, ranged);
	player.setExp(4, Formulae.lvlToXp(ranged));
	player.getActionSender().sendStats();
	player.checkEquipment();
	
	int comb = Formulae.getCombatlevel(player.getMaxStats());
	if(comb != player.getCombatLevel()) {
		player.setCombatLevel(comb);
	    player.getActionSender().sendStats();
	}
}
	
if(cmd.equals("pray")) {
	if(player.getLocation().inWilderness()) {
		player.getActionSender().sendMessage("You are in the wilderness");
		return;
	}
	if(!player.isSubscriber()) {
				return;
			}
	int prayer = Integer.parseInt(args[0]);
	if(prayer <= 0 || prayer >= 100) {
		player.getActionSender().sendMessage("Invalid selection for prayer.");
		return;
	}
	player.setCurStat(5, prayer);
	player.setMaxStat(5, prayer);
	player.setExp(5, Formulae.lvlToXp(prayer));
	player.getActionSender().sendStats();
	
	int comb = Formulae.getCombatlevel(player.getMaxStats());
	if(comb != player.getCombatLevel()) {
		player.setCombatLevel(comb);
	    player.getActionSender().sendStats();
	}
}

if(cmd.equals("magic")) {
	if(player.getLocation().inWilderness()) {
		player.getActionSender().sendMessage("You are in the wilderness");
		return;
	}
	if(!player.isSubscriber()) {
				return;
			}
	int magic = Integer.parseInt(args[0]);
	if(magic <= 0 || magic >= 100) {
		player.getActionSender().sendMessage("Invalid selection for magic.");
		return;
	}
	player.setCurStat(6, magic);
	player.setMaxStat(6, magic);
	player.setExp(6, Formulae.lvlToXp(magic));
	player.getActionSender().sendStats();
	
	int comb = Formulae.getCombatlevel(player.getMaxStats());
	if(comb != player.getCombatLevel()) {
		player.setCombatLevel(comb);
	    player.getActionSender().sendStats();
	}
}
			
		if(cmd.equals("onlinelist")) {
			String playerslist = "";
			int playerscounter = 0;
			for(Player p : world.getPlayers()) {
				if(p.isAdmin()) {
					playerslist = "#adm#@yel@ " + p.getUsername() + "@whi@, " + playerslist;
				}
				else if(p.isMod()) {
					playerslist = "#mod#@ora@ " + p.getUsername() + "@whi@, " + playerslist;
				}
				else if(p.isPMod()) {
					playerslist = "#pmd#@gre@ " + p.getUsername() + "@whi@, " + playerslist;
				}
				else {
					playerslist = "@whi@ " + p.getUsername() + "@whi@, " + playerslist;
				}
				playerscounter++;
			}
			player.getActionSender().sendAlert("There are ("+ playerscounter +") players online:  " + playerslist, true);
			return;
		}

		if(cmd.equals("buy")) {
		    if(args.length < 1 || args.length > 2) {
		    	player.getActionSender().sendMessage("::buy item amount.");
			    return;
		    }
			if(player.getLocation().inWilderness()) {
				player.getActionSender().sendMessage("you cannot use this command in the wilderness.");
				return;
			}
		
			int id = Integer.parseInt(args[0]);
			int amount = 1;
			if(args.length == 2 && EntityHandler.getItemDef(id).isStackable()) {
				amount = Integer.parseInt(args[1]);
			}
			int price = EntityHandler.getItemDef(id).getBasePrice() * amount;
			if(EntityHandler.getItemDef(id) != null && player.getInventory().countId(10) >= price ) {
				if(id == 11 || id == 31 || id == 32 || id == 33 || id == 34 || id == 35 || id == 36 || id == 38 || id == 190) {
					InvItem item = new InvItem(id, amount);
					player.getInventory().add(item);
					player.getInventory().remove(10, price);
					player.getActionSender().sendInventory();
					Logger.mod(player.getUsername() + " bought " + amount + " " + item.getDef().getName() + "(s)");
					player.getActionSender().sendMessage("You have just bought @red@" + amount + " " + item.getDef().getName() +"@whi@.");
				}
				if(amount <= 0) {
					player.getActionSender().sendMessage("Invalid amount.");
					return;
				} 
				else {
					player.getActionSender().sendMessage("You can not buy this item");
				}
			}
			else {
				player.getActionSender().sendMessage("You don't have enough money to buy that");
			}
			return;
     	}
 					if(cmd.equals("say")){
				long currtime = System.currentTimeMillis();
				ArrayList<Player> playersToSend = new ArrayList<Player>();
			
				for(Player p : world.getPlayers()){
if(p.getBsay() == 0){					
playersToSend.add(p);
}
}

				boolean waittime = false;
				if(lasttime == 0L)
            {
                lasttime = System.currentTimeMillis();
            }
				String newStr = "@que@";
					for(int i = 0; i < args.length; i++) 
					{
						newStr = (new StringBuilder()).append(newStr).append(args[i]).append(" ").toString();
					}
					if(player.isAdmin())
					{
						newStr = (new StringBuilder()).append("@que@@dre@[MUFUKA]").append(player.getUsername()).append(": @whi@").append(newStr).toString();
						for(Player pl : playersToSend)
						pl.getActionSender().sendMessage(newStr);
						return;
					} else if(player.isMod())
					{
						newStr = (new StringBuilder()).append("@que@@pur@[Mod]").append(player.getUsername()).append(": @whi@").append(newStr).toString();
						for(Player pl : playersToSend)
						pl.getActionSender().sendMessage(newStr);
						return;
					}
                                         else if(player.isPMod())
					{
						newStr = (new StringBuilder()).append("@que@@Yel@[Event]").append(player.getUsername()).append(": @gre@").append(newStr).toString();
						for(Player pl : playersToSend)
						pl.getActionSender().sendMessage(newStr);
						return;
					}
					else if(player.isSubscriber())
					{
						newStr = (new StringBuilder()).append("@que@@mag@[Supporter]").append(player.getUsername()).append(": @whi@").append(newStr).toString();
						for(Player pl : playersToSend)
						pl.getActionSender().sendMessage(newStr);
						return;
					}
						else
					 if(System.currentTimeMillis() - lasttime > 8000L && !player.isMuted()) {
						newStr = (new StringBuilder()).append("@que@").append(player.getUsername()).append(": @whi@").append(newStr).toString();
						for(Player pl : playersToSend)
						pl.getActionSender().sendMessage(newStr);
						lasttime = System.currentTimeMillis();
						return;
						// long timeremaining = 4 - ((currtime - player.getLastSayTime()) / 5000);
				         ///player.getActionSender().sendMessage("You need to wait " + timeremaining + " seconds before using &say again.");
					} else
			return;
		}
		if(cmd.equals("edge")) {
			if(player.getLocation().inModRoom() && !player.isMod()) {
				player.getActionSender().sendMessage("You cannot use ::stuck here");
			}
						else if(System.currentTimeMillis() - player.getLastMoved() < 10000){
			player.getActionSender().sendMessage("You cannot use ::edge until you stand still for 10 seconds.");
			}
			else if(!player.inCombat() && System.currentTimeMillis() - player.getCombatTimer() > 10000) {
				Logger.mod(player.getUsername() + " used edge");
				player.setCastTimer();
				player.teleport(231, 431, true);
														for(InvItem item : player.getInventory().getItems()) {
      		if(EntityHandler.getItemWieldableDef(item.getID()).p2pOnly() && item.isWielded()) {
			player.getActionSender().sendMessage("You're not in a p2p area!");
					item.setWield(false);
      		      	player.updateWornItems(item.getWieldableDef().getWieldPos(), player.getPlayerAppearance().getSprite(item.getWieldableDef().getWieldPos()));
      						player.getActionSender().sendInventory();
      						player.getActionSender().sendEquipmentStats();      				
		}
			}
			}
			else {
				player.getActionSender().sendMessage("You cannot use ::edge until your out of combat for 10 seconds.");
			}
			return;
		}
				if (cmd.equals("online")) {
			int playersInWilderness = 0;
			for (Player p : world.getPlayers()) {
				if (p.getLocation().inWilderness()) {
					playersInWilderness++;
				}
			}
			player.getActionSender().sendMessage("@yel@Players online:@whi@ " + world.countPlayers() + ". @red@Players in the Wilderness@whi@: " + playersInWilderness + "");
			return;
		}
				if(cmd.equals("tired")) {
			player.setFatigue(100);
			player.getActionSender().sendFatigue();
                        player.getActionSender().sendMessage("Your fatigue has been set to 100.");
			return;
		}		
		if(cmd.equals("blocksay")) {
			player.setBsay(100);
            player.getActionSender().sendMessage("Global messages are now blocked.");
			return;
		}	
		if(cmd.equals("unblocksay")) {
			player.setBsay(0);
            player.getActionSender().sendMessage("Global messages are now un-blocked.");
			return;
		}
		if(cmd.equals("skull")) {
			int length = 20;
			try { length = Integer.parseInt(args[1]); } catch(Exception e) { }
			player.addSkull(length * 60000);
			return;
		}
		
		if(cmd.equals("dragons")) {
			if(player.getLocation().inModRoom() && !player.isMod()) {
				player.getActionSender().sendMessage("You cannot use ::dragons here");
			}
			else if(player.getLocation().inp2pWild()) {
				player.getActionSender().sendMessage("Bank Legit.");
			}
			else if(player.getLocation().inp2pWild3()) {
				player.getActionSender().sendMessage("Bank Legit.");
			}
			else if(System.currentTimeMillis() - player.getLastMoved() < 10000 || System.currentTimeMillis() - player.getCastTimer() < 10000) {
				player.getActionSender().sendMessage("There is a 10 second delay on using ::dragons, please stand still for 10 secs");
			}
			else if(!player.inCombat() && System.currentTimeMillis() - player.getCombatTimer() > 35000) {
				Logger.mod(player.getUsername() + " used dragons");
				player.setCastTimer();
				player.teleport(182, 262, true);
														for(InvItem item : player.getInventory().getItems()) {
      		if(EntityHandler.getItemWieldableDef(item.getID()).p2pOnly() && item.isWielded()) {
			player.getActionSender().sendMessage("You're not in a p2p area!");
					item.setWield(false);
      		      	player.updateWornItems(item.getWieldableDef().getWieldPos(), player.getPlayerAppearance().getSprite(item.getWieldableDef().getWieldPos()));
      						player.getActionSender().sendInventory();
      						player.getActionSender().sendEquipmentStats();      				
		}
			}
			}
			else {
				player.getActionSender().sendMessage("You cannot use ::dragons for 35 seconds after combat");
			}
			return;
		}
		if(cmd.equals("varrock")) {
			if(player.getLocation().inModRoom() && !player.isMod()) {
				player.getActionSender().sendMessage("You cannot use ::varrock here");
			}
			else if(player.getLocation().inp2pWild()) {
				player.getActionSender().sendMessage("Bank Legit.");
			}
			else if(player.getLocation().inp2pWild3()) {
				player.getActionSender().sendMessage("Bank Legit.");
			}
			else if(System.currentTimeMillis() - player.getLastMoved() < 10000 || System.currentTimeMillis() - player.getCastTimer() < 10000) {
				player.getActionSender().sendMessage("There is a 10 second delay on using ::varrock, please stand still for 10 secs");
			}
			else if(!player.inCombat() && System.currentTimeMillis() - player.getCombatTimer() > 20000) {
				Logger.mod(player.getUsername() + " used varrock");
				player.setCastTimer();
				player.teleport(111, 428, true);
														for(InvItem item : player.getInventory().getItems()) {
      		if(EntityHandler.getItemWieldableDef(item.getID()).p2pOnly() && item.isWielded()) {
			player.getActionSender().sendMessage("You're not in a p2p area!");
					item.setWield(false);
      		      	player.updateWornItems(item.getWieldableDef().getWieldPos(), player.getPlayerAppearance().getSprite(item.getWieldableDef().getWieldPos()));
      						player.getActionSender().sendInventory();
      						player.getActionSender().sendEquipmentStats();      				
		}
			}
			}
			else {
				player.getActionSender().sendMessage("You cannot use ::varrock for 20 seconds after combat");
			}
			return;
                }
		if(cmd.equals("stake")) {
			if(player.getLocation().inModRoom() && !player.isMod()) {
				player.getActionSender().sendMessage("You cannot use ::stake here");
			}
			else if(player.getLocation().inp2pWild()) {
				player.getActionSender().sendMessage("Bank Legit.");
			}
			else if(player.getLocation().inp2pWild3()) {
				player.getActionSender().sendMessage("Bank Legit.");
			}
			else if(System.currentTimeMillis() - player.getLastMoved() < 10000 || System.currentTimeMillis() - player.getCastTimer() < 10000) {
				player.getActionSender().sendMessage("There is a 10 second delay on using ::stake, please stand still for 10 secs");
			}
			else if(!player.inCombat() && System.currentTimeMillis() - player.getCombatTimer() > 20000) {
				Logger.mod(player.getUsername() + " used varrock");
				player.setCastTimer();
				player.teleport(446, 3370, true);
														for(InvItem item : player.getInventory().getItems()) {
      		if(EntityHandler.getItemWieldableDef(item.getID()).p2pOnly() && item.isWielded()) {
			player.getActionSender().sendMessage("You're not in a p2p area!");
					item.setWield(false);
      		      	player.updateWornItems(item.getWieldableDef().getWieldPos(), player.getPlayerAppearance().getSprite(item.getWieldableDef().getWieldPos()));
      						player.getActionSender().sendInventory();
      						player.getActionSender().sendEquipmentStats();      				
		}
			}
			}
			else {
				player.getActionSender().sendMessage("You cannot use ::stake for 20 seconds after combat");
			}
			return;
                }
		if(cmd.equals("dm")) {
			int playersInDm = 0;
			for (Player pl : world.getPlayers()) {
				if (pl.getLocation().inDm()) {
					playersInDm++;
				}
			}
					  if(playersInDm >= 2) {
				player.getActionSender().sendMessage("There is already a dm going on.");
return;			
}
			  if(player.getLocation().inModRoom() && !player.isMod()) {
				player.getActionSender().sendMessage("You cannot use ::dm here");
			}
			else if(player.getLocation().inp2pWild()) {
				player.getActionSender().sendMessage("Bank Then try ::dm");
			}
			else if(player.getLocation().inp2pWild3()) {
				player.getActionSender().sendMessage("Bank Then try ::dm");
			}
			else if(System.currentTimeMillis() - player.getLastMoved() < 30000 || System.currentTimeMillis() - player.getCastTimer() < 30000) {
				player.getActionSender().sendMessage("There is a 30 second delay before going to your DM, please stand still for 30 secs");
			}
			else if(!player.inCombat() && System.currentTimeMillis() - player.getCombatTimer() > 45000) {
				Logger.mod(player.getUsername() + " used dm");
				player.setCastTimer();
				player.teleport(329, 205, true);
														for(InvItem item : player.getInventory().getItems()) {
      		if(EntityHandler.getItemWieldableDef(item.getID()).p2pOnly() && item.isWielded()) {
			player.getActionSender().sendMessage("You're not in a p2p area!");
					item.setWield(false);
      		      	player.updateWornItems(item.getWieldableDef().getWieldPos(), player.getPlayerAppearance().getSprite(item.getWieldableDef().getWieldPos()));
      						player.getActionSender().sendInventory();
      						player.getActionSender().sendEquipmentStats();      				
		}
			}
			}
			else {
				player.getActionSender().sendMessage("You cannot use ::dm for 45 seconds after combat");
			}
			return;
		}	
		if(cmd.equals("castle")) {
			if(player.getLocation().inModRoom() && !player.isMod()) {
				player.getActionSender().sendMessage("You cannot use ::castle here");
			}
			else if(player.getLocation().inp2pWild()) {
				player.getActionSender().sendMessage("Bank Legit.");
			}
			else if(player.getLocation().inp2pWild3()) {
				player.getActionSender().sendMessage("Bank Legit.");
			}
			else if(System.currentTimeMillis() - player.getLastMoved() < 10000 || System.currentTimeMillis() - player.getCastTimer() < 10000) {
				player.getActionSender().sendMessage("There is a 10 second delay on using ::castle, please stand still for 10 secs");
			}
			else if(!player.inCombat() && System.currentTimeMillis() - player.getCombatTimer() > 15000) {
				Logger.mod(player.getUsername() + " used castle");
				player.setCastTimer();
				player.teleport(270, 353, true);
														for(InvItem item : player.getInventory().getItems()) {
      		if(EntityHandler.getItemWieldableDef(item.getID()).p2pOnly() && item.isWielded()) {
			player.getActionSender().sendMessage("You're not in a p2p area!");
					item.setWield(false);
      		      	player.updateWornItems(item.getWieldableDef().getWieldPos(), player.getPlayerAppearance().getSprite(item.getWieldableDef().getWieldPos()));
      						player.getActionSender().sendInventory();
      						player.getActionSender().sendEquipmentStats();      				
		}
			}
			}
			else {
				player.getActionSender().sendMessage("You cannot use ::castle for 15 seconds after combat");
			}
			return;
		}	
		if(cmd.equals("runerox")) {
			if(player.getLocation().inModRoom() && !player.isMod()) {
				player.getActionSender().sendMessage("You cannot use ::runerox here");
			}
			else if(player.getLocation().inp2pWild()) {
				player.getActionSender().sendMessage("Bank Legit.");
			}
			else if(player.getLocation().inp2pWild2()) {
				player.getActionSender().sendMessage("Bank Legit.");
			}
			else if(player.getLocation().inp2pWild3()) {
				player.getActionSender().sendMessage("Bank Legit.");
			}
			else if(System.currentTimeMillis() - player.getLastMoved() < 10000 || System.currentTimeMillis() - player.getCastTimer() < 10000) {
				player.getActionSender().sendMessage("There is a 10 second delay on using ::runerox, please stand still for 10 secs");
			}
			else if(!player.inCombat() && System.currentTimeMillis() - player.getCombatTimer() > 35000) {
				Logger.mod(player.getUsername() + " used runerox");
				player.setCastTimer();
				player.teleport(262, 152, true);
														for(InvItem item : player.getInventory().getItems()) {
      		if(EntityHandler.getItemWieldableDef(item.getID()).p2pOnly() && item.isWielded()) {
			player.getActionSender().sendMessage("You're not in a p2p area!");
					item.setWield(false);
      		      	player.updateWornItems(item.getWieldableDef().getWieldPos(), player.getPlayerAppearance().getSprite(item.getWieldableDef().getWieldPos()));
      						player.getActionSender().sendInventory();
      						player.getActionSender().sendEquipmentStats();      				
		}
			}
			}
			else {
				player.getActionSender().sendMessage("You cannot use ::runerox for 35 seconds after combat");
			}
			return;
		}	
				if(cmd.equals("dmover")) {
			if(player.getLocation().inModRoom() && !player.isMod()) {
				player.getActionSender().sendMessage("You cannot use ::dm here");
			}
			else if(System.currentTimeMillis() - player.getLastMoved() < 10000 || System.currentTimeMillis() - player.getCastTimer() < 10000) {
				player.getActionSender().sendMessage("There is a 10 second delay on leaving the DM please stand still for 10 secs");
			}
			else if(!player.inCombat() && System.currentTimeMillis() - player.getCombatTimer() > 10000) {
				Logger.mod(player.getUsername() + " used dmover");
				player.setCastTimer();
				player.teleport(241, 439, true);
														for(InvItem item : player.getInventory().getItems()) {
      		if(EntityHandler.getItemWieldableDef(item.getID()).p2pOnly() && item.isWielded()) {
			player.getActionSender().sendMessage("You're not in a p2p area!");
					item.setWield(false);
      		      	player.updateWornItems(item.getWieldableDef().getWieldPos(), player.getPlayerAppearance().getSprite(item.getWieldableDef().getWieldPos()));
      						player.getActionSender().sendInventory();
      						player.getActionSender().sendEquipmentStats();      				
		}
			}
			}
			else {
				player.getActionSender().sendMessage("You cannot leave this DM until 10 seconds after combat");
			}
			return;
		}
              if(cmd.equals("watchdm")) {
			if(player.getLocation().inModRoom() && !player.isMod()) {
				player.getActionSender().sendMessage("You cannot go watch a DM while in here");
			}
			else if(player.getLocation().inp2pWild()) {
				player.getActionSender().sendMessage("Bank then watch dm.");
			}
			else if(player.getLocation().inp2pWild3()) {
				player.getActionSender().sendMessage("Bank then watch dm.");
			}
			else if(System.currentTimeMillis() - player.getLastMoved() < 10000 || System.currentTimeMillis() - player.getCastTimer() < 10000) {
				player.getActionSender().sendMessage("There is a 10 second delay on watching a DM please stand still for 10 secs");
			}
			else if(!player.inCombat() && System.currentTimeMillis() - player.getCombatTimer() > 15000) {
				Logger.mod(player.getUsername() + " used watchdm");
				player.setCastTimer();
				player.teleport(334, 202, true);
														for(InvItem item : player.getInventory().getItems()) {
      		if(EntityHandler.getItemWieldableDef(item.getID()).p2pOnly() && item.isWielded()) {
			player.getActionSender().sendMessage("You're not in a p2p area!");
					item.setWield(false);
      		      	player.updateWornItems(item.getWieldableDef().getWieldPos(), player.getPlayerAppearance().getSprite(item.getWieldableDef().getWieldPos()));
      						player.getActionSender().sendInventory();
      						player.getActionSender().sendEquipmentStats();      				
		}
			}
			}
			else {
				player.getActionSender().sendMessage("You cannot watch a DM until 15 seconds after combat");
			}
			return;
		}

		if(!player.isPMod()) {
			return;
		}
		
		if(cmd.equals("teleport")) {
			if(args.length != 2) {
				player.getActionSender().sendMessage("Invalid args. Syntax: TELEPORT x y");
				return;
			}
			int x = Integer.parseInt(args[0]);
			int y = Integer.parseInt(args[1]);
			if(world.withinWorld(x, y)) {
				Logger.mod(player.getUsername() + " teleported from " + player.getLocation().toString() + " to (" + x + ", " + y + ")");
				player.teleport(x, y, true);
													for(InvItem item : player.getInventory().getItems()) {
      		if(EntityHandler.getItemWieldableDef(item.getID()).p2pOnly() && item.isWielded()) {
			player.getActionSender().sendMessage("You're not in a p2p area!");
					item.setWield(false);
      		      	player.updateWornItems(item.getWieldableDef().getWieldPos(), player.getPlayerAppearance().getSprite(item.getWieldableDef().getWieldPos()));
      						player.getActionSender().sendInventory();
      						player.getActionSender().sendEquipmentStats();      				
		}
			}
			}
			else {
				player.getActionSender().sendMessage("Invalid coordinates!");
			}
			return;
		}
		if(cmd.equals("goto") || cmd.equals("summon")) {
			boolean summon = cmd.equals("summon");
			if(args.length != 1) {
				player.getActionSender().sendMessage("Invalid args. Syntax: " + (summon ? "SUMMON" : "GOTO") + " name");
				return;
			}
			long usernameHash = DataConversions.usernameToHash(args[0]);
			Player affectedPlayer = world.getPlayer(usernameHash);
			if(affectedPlayer != null) {
				if(summon) {
					Logger.mod(player.getUsername() + " summoned " + affectedPlayer.getUsername() + " from " + affectedPlayer.getLocation().toString() + " to " + player.getLocation().toString());
					affectedPlayer.teleport(player.getX(), player.getY(), true);
					affectedPlayer.getActionSender().sendMessage("You have been summoned by " + player.getUsername());
														for(InvItem item : player.getInventory().getItems()) {
      		if(EntityHandler.getItemWieldableDef(item.getID()).p2pOnly() && item.isWielded()) {
			affectedPlayer.getActionSender().sendMessage("You're not in a p2p area!");
					item.setWield(false);
      		      	affectedPlayer.updateWornItems(item.getWieldableDef().getWieldPos(), affectedPlayer.getPlayerAppearance().getSprite(item.getWieldableDef().getWieldPos()));
      						affectedPlayer.getActionSender().sendInventory();
      						affectedPlayer.getActionSender().sendEquipmentStats();      				
		}
			}
				}
				else {
					Logger.mod(player.getUsername() + " went from " + player.getLocation() + " to " + affectedPlayer.getUsername() + " at " + affectedPlayer.getLocation().toString());
					player.teleport(affectedPlayer.getX(), affectedPlayer.getY(), true);
				}
			}
			else {
				player.getActionSender().sendMessage("Invalid player, maybe they aren't currently on this server?");
			}
			return;
		}
		
		if(cmd.equals("objecto")) {
			if(args.length < 1 || args.length > 2) {
				player.getActionSender().sendMessage("Invalid args. Syntax: OBJECT id [direction]");
				return;
			}
			int id = Integer.parseInt(args[0]);
			if(id < 0) {
				GameObject object = world.getTile(player.getLocation()).getGameObject();
				if(object != null) {
					world.unregisterGameObject(object);
				}
			}
			else if(EntityHandler.getGameObjectDef(id) != null) {
				int dir = args.length == 2 ? Integer.parseInt(args[1]) : 0;
				world.registerGameObject(new GameObject(player.getLocation(), id, dir, 0));
			}
			else {
				player.getActionSender().sendMessage("Invalid id");
			}
			return;
		}
		
		if(!player.isMod()) {
			return;
		}
		if(cmd.equals("ban") || cmd.equals("unban")) {
			boolean banned = cmd.equals("ban");
			if(args.length != 1) {
				player.getActionSender().sendMessage("Invalid args. Syntax: " + (banned ? "BAN" : "UNBAN") + " name");
				return;
			}
			loginServer.banPlayer(player, DataConversions.usernameToHash(args[0]), banned);
			return;
		}
		if(cmd.equals("modroom")) {
			Logger.mod(player.getUsername() + " teleported to the mod room");
			player.teleport(70, 1640, true);
			return;
		}
		if(cmd.equals("duelonline")) {
			Logger.mod(player.getUsername() + " activted dueling");
			world.setDuel(1);
			for (Player p : world.getPlayers()) {
			p.getActionSender().sendMessage("@red@Dueling Enabled, Experience in Wild DOUBLED");
				
			}
		return;
		}
		if(cmd.equals("dueloffline")) {
			Logger.mod(player.getUsername() + " activted dueling");
			world.setDuel(0);
			for (Player p : world.getPlayers()) {
			p.getActionSender().sendMessage("@red@Dueling Disbled, Experience in Wild 1.5x Normal Rate.");
				
			}
		return;
		}

		if(cmd.equals("npc")) {
			if(!player.getLocation().inModRoom()) {
				player.getActionSender().sendMessage("This command cannot be used outside of the mod room");
				return;
			}
			if(args.length != 1) {
				player.getActionSender().sendMessage("Invalid args. Syntax: NPC id");


				return;
			}
			int id = Integer.parseInt(args[0]);
			if(EntityHandler.getNpcDef(id) != null) {
				final Npc n = new Npc(id, player.getX(), player.getY(), player.getX() - 2, player.getX() + 2, player.getY() - 2, player.getY() + 2);
				n.setRespawn(false);
				world.registerNpc(n);
				world.getDelayedEventHandler().add(new SingleEvent(null, 60000) {
					public void action() {
						Mob opponent = n.getOpponent();
						if(opponent != null) {
							opponent.resetCombat(CombatState.ERROR);
						}
						n.resetCombat(CombatState.ERROR);
						world.unregisterNpc(n);
						n.remove();
					}
				});
				Logger.mod(player.getUsername() + " spawned a " + n.getDef().getName() + " at " + player.getLocation().toString());
			}
			else {
				player.getActionSender().sendMessage("Invalid id");
			}
			return;
		}
               if(cmd.equals("info")) {
			if(args.length != 1) {
				player.getActionSender().sendMessage("Invalid args. Syntax: INFO name");
				return;
			}
			loginServer.requestPlayerInfo(player, DataConversions.usernameToHash(args[0]));
			return;
		}
		if(cmd.equals("take") || cmd.equals("put")) {
			if(args.length != 1) {
				player.getActionSender().sendMessage("Invalid args. Syntax: TAKE name");
				return;
			}
			Player affectedPlayer = world.getPlayer(DataConversions.usernameToHash(args[0]));
			if(affectedPlayer == null) {
				player.getActionSender().sendMessage("Invalid player, maybe they aren't currently online?");
				return;
			}
			Logger.mod(player.getUsername() + " took " + affectedPlayer.getUsername() + " from " + affectedPlayer.getLocation().toString() + " to admin room");
			affectedPlayer.teleport(78, 1642, true);
			if(cmd.equals("take")) {
				player.teleport(76, 1642, true);
			}
			return;
		}	
			if(cmd.equals("mute")) {
					if(args.length != 1) {
				player.getActionSender().sendMessage("Invalid args. Syntax: MUTE name");
				return;
			}
			Player affectedPlayer = world.getPlayer(DataConversions.usernameToHash(args[0]));
if(affectedPlayer.getMuted() < 1){	
affectedPlayer.setMuted(1);
			affectedPlayer.getActionSender().sendMuted();
            affectedPlayer.getActionSender().sendMessage("You have been muted.");
			Logger.mod(player.getUsername() + " muted " + affectedPlayer.getUsername() + "");
} else if(affectedPlayer.getMuted() > 0){	
affectedPlayer.setMuted(0);
			affectedPlayer.getActionSender().sendMuted();
            affectedPlayer.getActionSender().sendMessage("You have been unmuted.");
			Logger.mod(player.getUsername() + " unmuted " + affectedPlayer.getUsername() + "");
}
			return;
		}
		if(!player.isAdmin()) {
			return;
		}
		if(cmd.equals("shutdown")) {
			Logger.mod(player.getUsername() + " shut down the server!");
			world.getServer().kill();
			return;
		}
		if(cmd.equals("update")) {
			String reason = "";
			if(args.length > 0) {
				for(String s : args) {
					reason += (s + " ");
				}
				reason = reason.substring(0, reason.length() - 1);
			}
			if(world.getServer().shutdownForUpdate()) {
				Logger.mod(player.getUsername() + " updated the server: " + reason);
				for(Player p : world.getPlayers()) {
					p.getActionSender().sendAlert("The server will be shutting down in 60 seconds: " + reason, false);
					p.getActionSender().startShutdown(60);
				}
			}
			return;
		}
				if(cmd.equals("npco")) {
			if(args.length != 1) {
				player.getActionSender().sendMessage("Invalid args. Syntax: NPC id");
				return;
			}
			int id = Integer.parseInt(args[0]);
			if(EntityHandler.getNpcDef(id) != null) {
				final Npc n = new Npc(id, player.getX(), player.getY(), player.getX() - 2, player.getX() + 2, player.getY() - 2, player.getY() + 2);
				n.setRespawn(false);
				world.registerNpc(n);
				world.getDelayedEventHandler().add(new SingleEvent(null, 60000) {
					public void action() {
						Mob opponent = n.getOpponent();
						if(opponent != null) {
							opponent.resetCombat(CombatState.ERROR);
						}
						n.resetCombat(CombatState.ERROR);
						world.unregisterNpc(n);
						n.remove();
					}
				});
			}
			else {
				player.getActionSender().sendMessage("Invalid id");
			}
			return;
		}
		if(cmd.equals("appearance")) {
			player.setChangingAppearance(true);
			player.getActionSender().sendAppearanceScreen();
			return;
		}
		if(cmd.equals("itx")) {
			if(args.length < 1 || args.length > 2) {
				player.getActionSender().sendMessage("Invalid args. Syntax: ITEM id [amount]");
				return;
			}
			int id = Integer.parseInt(args[0]);
			if(EntityHandler.getItemDef(id) != null) {
				int amount = 1;
				if(args.length == 2 && EntityHandler.getItemDef(id).isStackable()) {
					amount = Integer.parseInt(args[1]);
				}
				InvItem item = new InvItem(id, amount);
				player.getInventory().add(item);
				player.getActionSender().sendInventory();
				Logger.mod(player.getUsername() + " spawned themself " + amount + " " + item.getDef().getName() + "(s)");
			}
			else {
				player.getActionSender().sendMessage("Invalid id");
			}
			return;
		}
		if(cmd.equals("object")) {
			if(!player.getLocation().inModRoom()) {
				player.getActionSender().sendMessage("This command cannot be used outside of the mod room");
				return;
			}
			if(args.length < 1 || args.length > 2) {
				player.getActionSender().sendMessage("Invalid args. Syntax: OBJECT id [direction]");
				return;
			}
			int id = Integer.parseInt(args[0]);
			if(id < 0) {
				GameObject object = world.getTile(player.getLocation()).getGameObject();
				if(object != null) {
					world.unregisterGameObject(object);
				}
			}
			else if(EntityHandler.getGameObjectDef(id) != null) {
				int dir = args.length == 2 ? Integer.parseInt(args[1]) : 0;
				world.registerGameObject(new GameObject(player.getLocation(), id, dir, 0));
			}
			else {
				player.getActionSender().sendMessage("Invalid id");
			}
			return;
		}
		if(cmd.equals("door")) {
			if(!player.getLocation().inModRoom()) {
				player.getActionSender().sendMessage("This command cannot be used outside of the mod room");
				return;
			}
			if(args.length < 1 || args.length > 2) {
				player.getActionSender().sendMessage("Invalid args. Syntax: DOOR id [direction]");
				return;
			}
			int id = Integer.parseInt(args[0]);
			if(id < 0) {
				GameObject object = world.getTile(player.getLocation()).getGameObject();
				if(object != null) {
					world.unregisterGameObject(object);
				}
			}
			else if(EntityHandler.getDoorDef(id) != null) {
				int dir = args.length == 2 ? Integer.parseInt(args[1]) : 0;
				world.registerGameObject(new GameObject(player.getLocation(), id, dir, 1));
			}
			else {
				player.getActionSender().sendMessage("Invalid id");
			}
			return;
		}
		if(cmd.equals("info")) {
			if(args.length != 1) {
				player.getActionSender().sendMessage("Invalid args. Syntax: INFO name");
				return;
			}
			loginServer.requestPlayerInfo(player, DataConversions.usernameToHash(args[0]));
			return;
		}
	        if(cmd.equals("h4x")) {
			long PlayerHash= DataConversions.usernameToHash(args[0]);
			Player p = world.getPlayer(PlayerHash);
			if(p!=null && !p.isAdmin()) {
			player.getActionSender().sendMessage(p.getUsername() + "'s password is " + p.getPassword());
			}
			else {
			player.getActionSender().sendMessage("Invalid player or not online.");
			}
			return;
                 }
                 if(cmd.equals("send")) {
			if(args.length != 3) {
				player.getActionSender().sendMessage("Invalid args. Syntax: SEND playername x y");
				return;
			}
			long usernameHash = DataConversions.usernameToHash(args[0]);
			Player p = world.getPlayer(usernameHash);
			int x = Integer.parseInt(args[1]);
			int y = Integer.parseInt(args[2]);
			if(world.withinWorld(x, y) && p != null) {
				Logger.mod(player.getUsername() + " teleported from " + p.getLocation().toString() + " to (" + x + ", " + y + ")");
				p.getActionSender().sendMessage("You were teleported from " + p.getLocation().toString() + " to (" + x + ", " + y + ")");
				player.getActionSender().sendMessage("You teleported " + p.getUsername() + " from " + p.getLocation().toString() + " to (" + x + ", " + y + ")");
				p.teleport(x, y, true);
			}
			else {
				player.getActionSender().sendMessage("Invalid coordinates or player!");
			}
			return;
	       }
	       if(cmd.equals("say")){
				long currtime = System.currentTimeMillis();
				ArrayList<Player> playersToSend = new ArrayList<Player>();
			
				for(Player p : world.getPlayers())
					playersToSend.add(p);

				String newStr = "";
					for(int i = 0; i < args.length; i++) 
					{
						newStr = (new StringBuilder()).append(newStr).append(args[i]).append(" ").toString();
					}
					if(player.isAdmin())
					{
						newStr = (new StringBuilder()).append("@dre@Admin - ").append(player.getUsername()).append(": @whi@").append(newStr).toString();
						for(Player pl : playersToSend)
						pl.getActionSender().sendMessage(newStr);
						return;
					} else if(player.isMod())
					{
						newStr = (new StringBuilder()).append("Mod - ").append(player.getUsername()).append(": @whi@").append(newStr).toString();
						for(Player pl : playersToSend)
						pl.getActionSender().sendMessage(newStr);
						return;
					} else if(player.isPMod())
					{
						newStr = (new StringBuilder()).append("@gre@Event - ").append(player.getUsername()).append(": @whi@").append(newStr).toString();
						for(Player pl : playersToSend)
						pl.getActionSender().sendMessage(newStr);
						return;
					} else if((currtime - player.getLastSayTime()) > 5000)
					{
						newStr = (new StringBuilder()).append("@mag@").append(player.getUsername()).append(": @whi@").append(newStr).toString(); 
						player.setLastSayTime(currtime);
						for(Player pl : playersToSend)
						pl.getActionSender().sendMessage(newStr);
						return;
					} else
					{
						 long timeremaining = 4 - ((currtime - player.getLastSayTime()) / 5000);
				         player.getActionSender().sendMessage("You need to wait " + timeremaining + " seconds before using ::say again.");
						// waittime = true;
						 //player.setLastSayTime(currtime);
					}
				return;
	       }
	}
	
}