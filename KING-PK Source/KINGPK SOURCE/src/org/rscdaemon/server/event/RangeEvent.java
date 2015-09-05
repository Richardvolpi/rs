package org.rscdaemon.server.event;

import org.rscdaemon.server.model.Player;
import org.rscdaemon.server.model.Mob;
import org.rscdaemon.server.model.Item;
import org.rscdaemon.server.model.InvItem;
import org.rscdaemon.server.model.Projectile;
import org.rscdaemon.server.util.DataConversions;
import org.rscdaemon.server.util.Formulae;

import java.util.ArrayList;

public class RangeEvent extends DelayedEvent {
	private Mob affectedMob;
	private boolean firstRun = true;
	
	public RangeEvent(Player owner, Mob affectedMob) {
		super(owner, 2000);
		this.affectedMob = affectedMob;
	}
	
	private Item getArrows(int id) {
		for(Item i : world.getTile(affectedMob.getLocation()).getItems()) {
			if(i.getID() == id && i.visibleTo(owner) && !i.isRemoved()) {
				return i;
			}
		}
		return null;
	}
	
	public void run() {
		int bowID = owner.getRangeEquip();
		if(!owner.loggedIn() || (affectedMob instanceof Player && !((Player)affectedMob).loggedIn()) || affectedMob.getHits() <= 0 || !owner.checkAttack(affectedMob, true) || bowID < 0) {
			owner.resetRange();
			return;
		}
		if(owner.withinRange(affectedMob, 5)) {
			if(owner.isFollowing()) {
				owner.resetFollowing();
			}
			if(!owner.finishedPath()) {
				owner.resetPath();
			}
		}
		else {
			owner.setFollowing(affectedMob);
			return;
		}
		boolean xbow = DataConversions.inArray(Formulae.xbowIDs, bowID);
		int arrowID = -1;
		for(int aID : (xbow ? Formulae.boltIDs : Formulae.arrowIDs)) {
			int slot = owner.getInventory().getLastIndexById(aID);
			if(slot < 0) {
				continue;
			}
			InvItem arrow = owner.getInventory().get(slot);
			if(arrow == null) { // This shouldn't happen
				continue;
			}
			arrowID = aID;
			int newAmount = arrow.getAmount() - 1;
			if(newAmount <= 0) {
				owner.getInventory().remove(slot);
				owner.getActionSender().sendInventory();
			}
			else {
				arrow.setAmount(newAmount);
				owner.getActionSender().sendUpdateItem(slot);
			}
			break;
		}
		if(arrowID < 0) {
			owner.getActionSender().sendMessage("You have run out of " + (xbow ? "bolts" : "arrows"));
			owner.resetRange();
			return;
		}
		if(affectedMob.isPrayerActivated(13)) {
			owner.getActionSender().sendMessage("Your missiles are blocked");
			owner.resetRange();
			return;
		}
		
		if(!owner.getLocation().inPurePk() && affectedMob.getLocation().inPurePk())
		{
		owner.getActionSender().sendMessage("You may not shoot inside the box when your out of it.");
		owner.resetPath();
		owner.resetRange();
		return;
		}	
		if(owner.getLocation().inPurePk() && !affectedMob.getLocation().inPurePk())
		{
		owner.getActionSender().sendMessage("You may not shoot outside the box when your in it.");
		owner.resetPath();
		return;
		}
		
		int damage = Formulae.calcRangeHit(owner.getCurStat(4), owner.getRangePoints(), affectedMob.getArmourPoints(), arrowID);
		if(!Formulae.looseArrow(damage)) {
			Item arrows = getArrows(arrowID);
			if(arrows == null) {
				world.registerItem(new Item(arrowID, affectedMob.getX(), affectedMob.getY(), 1, owner));
			}
			else {
				arrows.setAmount(arrows.getAmount() + 1);
			}
		}
		if(firstRun) {
			firstRun = false;
			if(affectedMob instanceof Player) {
				((Player)affectedMob).getActionSender().sendMessage(owner.getUsername() + " is shooting at you!");
			}
		}
		Projectile projectile = new Projectile(owner, affectedMob, 2);
  		affectedMob.setLastDamage(damage);
  		int newHp = affectedMob.getHits() - damage;
  		affectedMob.setHits(newHp);
  		ArrayList<Player> playersToInform = new ArrayList<Player>();
  		playersToInform.addAll(owner.getViewArea().getPlayersInView());
  		playersToInform.addAll(affectedMob.getViewArea().getPlayersInView());
  		for(Player p : playersToInform) {
  			p.informOfProjectile(projectile);
  			p.informOfModifiedHits(affectedMob);
  		}
  		if(affectedMob instanceof Player) {
  			Player affectedPlayer = (Player)affectedMob;
  			affectedPlayer.getActionSender().sendStat(3);
		}
		owner.getActionSender().sendSound("shoot");
		owner.setArrowFired();
  		if(newHp <= 0) {
  			affectedMob.killedBy(owner, false);
  			int exp = Formulae.combatExperience(affectedMob);
  			owner.incExp(4, exp, true);
  			owner.getActionSender().sendStat(4);
  			owner.resetRange();
  		}
	}
	
	public Mob getAffectedMob() {
		return affectedMob;
	}
	
	public boolean equals(Object o) {
		if(o instanceof RangeEvent) {
			RangeEvent e = (RangeEvent)o;
			return e.belongsTo(owner);
		}
		return false;
	}
}