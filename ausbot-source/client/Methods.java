package org.rscdaemon.client;

import java.util.ArrayList;
import java.util.Random;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.rscdaemon.client.entityhandling.EntityHandler;
import org.rscdaemon.client.util.DataConversions;

public abstract class Methods{
    protected mudclient rs;
    private Random r = new Random();
    private Thread ModScanThread = null;
    
    public Methods(mudclient rs) {
        this.rs = rs;
    }

    public void MainBody(String Args[]) {}

    public void OnChatMessage(String sender, String message) {}

    public void OnPrivateMessage(String sender, String message) {}

    public void OnServerMessage(String message) {}

    public void run() {}

    public void KeyPressed(int key) {}

    public void OnInput(String input) {}

    public void Debug(String Command) {}

    public void OnIRCChatMessage(String channel, String senderName, String senderIdent, String senderHost, String message) {}

    public void OnIRCPrivateMessage(String senderName, String senderIdent, String senderHost, String message) {}

    public void OnIRCAction(String channel, String senderName, String senderIdent, String senderHost, String message) {}
    
    public void Finish() { // Stops all scripts and kills thread.
    	rs.displayMessage("Thread Destroyed.", 3, -1);
 //   	 IRC irc = new IRC();
    // 	irc.writeIrcMessage("8" + IRC.ingameUsername + "1 has stopped all Scripts");
    	rs.ScriptRunning = false;
    	Thread.currentThread().destroy();
    }

  public int playerStatCurrent(int i) {
return rs.playerStatCurrent[i];
}
  ArrayList<JLabel> labels = new ArrayList<JLabel>();
    public boolean ScriptRunning() {
    	return rs.ScriptRunning;
    }
        public long ExpGained() {
    	return rs.expGained;
    }
     
	public void updateReport(String [] stringz) {
		try {
			for(int i=0; i < stringz.length; i++) {
				labels.get(i).setText(stringz[i]);				
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
			
		} 	
	
	public void drawReport(String [] stringz) {
	    
		 try {
			
			JFrame frame = new JFrame("(" + rs.currentUser + ")");
			frame.setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			JLabel label;
		
			c.anchor = GridBagConstraints.ABOVE_BASELINE_LEADING;
			
			for(int i=0; i < stringz.length; i++) {
				c.gridx = 0;
				c.gridy = i; //
				label = new JLabel(stringz[i]);
				labels.add(label);
				frame.add(label, c);
			}
			
			frame.validate();
			frame.pack();
			frame.setSize(frame.getWidth() + 80, frame.getHeight() + 10);
			frame.setResizable(false);
			frame.setVisible(true);
			 
		 } catch (Exception e) {
			 System.out.println(e.getMessage() + "1");
		 }
		}
    
    
    
    public boolean sleeping() {
    	return rs.sleeping;
    }
        public int Rand(int min,int max)
    {
        return rs.rand(min, max);
    }
    public boolean showQuestionMenu() {
    	return rs.showQuestionMenu;
    }
    public void Wait(int i) {
    	rs.Wait(i);
    }
   	//Start of Methods
 public final boolean QuestMenu() {
   return rs.QuestMenu();
}
    public final boolean InBank() {
    return rs.InBank();
}
        public final boolean LoggedIn() {
        return rs.LoggedIn();
}
         public final void Deposit(int id, int amount) {
    
        	 rs.Deposit(id, amount);
}//Display
    public final int CountNpcs() {
    return rs.CountNpcs();
}
   
        public int NpcX(int id) {
    return rs.NpcX(id);
}
        public int NpcY(int id) {
    return rs.NpcY(id);
}
         
         	public int NpcId(int id)
{
	return rs.NpcId(id);
}

             public final void Login(String user, String pass) {
    rs.Login(user, pass);
    }



                     public int PlayerDestX(int index)
{
            return playerDestX(index);
    }
	                     public int PlayerDestY(int index)
{
            return playerDestY(index);
    }

                     public int PlayerY(int index)
{
            return playerY(index);
}
                     public int PlayerX(int index)
{
             return playerX(index);
    } 
	public int LastAttackedPlayer()
{
	return rs.lastPlayerAttacked;
}

	public long GetMillis()
{
	return System.currentTimeMillis();
}
	public void Die(String s)
{
	System.out.println(s);
	System.exit(0);
}
	public void Die()
{
	System.exit(0);
}
	public int CountObjects()
{
	return rs.CountObjects();
}
	/*public String getRsName()
{
	return rs.currentUser;
}*/ // I wanted to hide this, just incase people make scripts to send usernames to peoples emails or somethin. - xEnt
public void OpenDoor(int x, int y, int id)
{
rs.OpenDoor(x, y, id);

}
    public int CountWallObjects()
{
	return rs.CountWallObjects();
}

public int WallObjectType(int i)
{
	return rs.WallObjectType(i);
}

public int WallObjectX(int i)
{
	return rs.WallObjectX(i);
}

public int WallObjectY(int i)
{
	return rs.WallObjectY(i);
}


                public void PrayerOn(int i) {
    rs.PrayerOn(i);
}

                 public void PrayerOff(int i) {
    rs.PrayerOff(i);
}
                 public final void UseItem(int Id) {
   rs.UseItem(Id);
}
                     public final void DropItem(int Id) {
   rs.DropItem(Id);
}
             public final void Withdraw(int id, int amount) {
    rs.Withdraw(id, amount);
}

                 public final void AtWallObject(int x,int y) {
                 if(!rs.loading){
    rs.AtWallObject(x, y);
    }
}

                     public final void AtWallObject2(int x,int y) {
                       if(!rs.loading){
   rs.AtWallObject2(x, y);}
}
                 public void UseOnWallObject(int slot, int x, int y) {
      if(!rs.loading){
                	 rs.UseOnWallObject(slot, x, y);}
}
   public void WithdrawItems(int id, int amount) {
	rs.WithdrawItems(id, amount);
}
   public void drawText(String s) {
   	
	   rs.drawText(s);
   }
   
        public final int CountQuestMenu() {
    return rs.CountQuestMenu();
}
    public void CloseBank() {
          rs.CloseBank();
}
	

	public boolean Sleeping()
{
	return rs.sleeping;
}
	public void SetMode(int i)
{
	rs.SetMode(i);
}

	public int GetMode()
{
	return rs.GetMode();
}

	public long GetExp(int i)
{
	return rs.GetExp(i);
}
	public boolean IsPrayerOn(int i)
{
	return rs.IsPrayerOn(i);
}
	public String GetLvlName(int i)
{
	return rs.GetLvlName(i);
}

public int GetCurLvl(int i)
{
	return rs.getCurLvl(i);
}

public int GetMaxLvl(int i)
{
	return rs.getMaxLvl(i);
}
public int[] GetAllNpcById(int id)
{
    return rs.GetAllNpcById(id);
}

public int[] GetAllNpcById(int ids[])
{
	return rs.GetAllNpcById(ids);
}

public boolean NpcInCombat(int i)
{
	return rs.NpcInCombat(i);
}



public void UseOnNpc(int pos, int index)
{
  if(!rs.loading){
	rs.UseOnNpc(pos, index);}
}

public void UseOnObject(int slot, int x, int y){
  if(!rs.loading){
  rs.UseOnObject(slot, x, y);}
} 

  public final int CountInv(int id) {
           return rs.inventoryCount(id);
}

   public int invCount (int id){	
	return rs.inventoryCount(id);
  	}
  	
public int invCount(){
	return rs.invCount();
}   
public void Talk(String s) {
          rs.Talk(s);
}

public void CastOnNpc(int selectedSpell, int i2) {
  if(!rs.loading){
      rs.CastOnNpc(selectedSpell, i2);}

}


public void CastOnPlayer(int spell, int id)
	{
	  if(!rs.loading){
			rs.CastOnPlayer(spell, id);
			}
	}


	public void Cast()
		{
		  if(!rs.loading){
		rs.Cast();}
	}


public void AttackPlayer(int id)
{  if(!rs.loading){
	rs.AttackPlayer(id);
	}
	}

public void AttackPlayerByName(String id)
{
  if(!rs.loading){
rs.AttackPlayerByName(id);
}
	}
public void Display(String s)
{
	rs.display(s);
}

public void display(String s)
{
	rs.display(s);
}

public int getCurLvl(int i)
{
	return rs.getCurLvl(i);
}
public int[] GetPlayerByName(String n) {
   return rs.GetPlayerByName(n);
}
public int getMaxLvl(int i)
{
	return rs.getMaxLvl(i);
}
public boolean PlayerHpBarShowing(int index)
{
	return rs.playerHpBarShowing(index);
}
public boolean playerHpBarShowing(int index)
{
	return rs.playerHpBarShowing(index);
}

public boolean healthBarShowing()
{
	return rs.ourPlayer.combatTimer > 0;
}

public int HitsPercent()
{

	return (getCurLvl(3) * 100) / getMaxLvl(3);
}

	public boolean playerInCombat(int index)
{
	return rs.playerInCombat(index);
}
public boolean isPlayerWalking(int idx)
{
	return rs.isPlayerWalking(idx);
}
public int[] GetPlayerById(int id)
{
	return rs.GetPlayerById(id);
}
public int playerDestX(int index)
{
	return rs.playerDestX(index);
}

public int playerDestY(int index)
{
return rs.playerDestY(index);
}
public int playerX(int index)
{
	return rs.playerX(index);
}

public int playerY(int index)
{
	return rs.playerY(index);
}
    public void ThieveNpc(int i) {
    rs.ThieveNpc(i);
}

    public void AttackNpc(int i) {
      if(!rs.loading){
    rs.AttackNpc(i);
    }
}
    public int GetItemPos(int id) {
    return rs.GetItemPos(id);
}
    public void UseItemWithItem(int i, int l) {
   rs.UseItemWithItem(i, l);
}
      public boolean IsWearing(int slot)
    {
                   if(rs.wearing[GetItemPos(slot)] == 1)
                    {
  return true;
          }else return false;
}
  public boolean BagFull() {
  if(rs.inventoryCount == 30){
  return true;
          }else return false;
}

public int slotsLeft() {
return 30 - rs.inventoryCount;
}
public void ForceWalkTo(int x, int y){
     if(!rs.loading){
   rs.ForceWalkTo(x, y);
   }
}
public void ForceWalkTo1(int x, int y)
{
  if(!rs.loading){
rs.ForceWalkTo1(x, y);
}

}

public void Drop(int i) 
{
rs.Drop(i);
}

public void AttackNpc2(int i2) {
  if(!rs.loading){
   rs.AttackNpc2(i2);
   }
}
public void CastOnSelf(int selectedSpell) {
    rs.CastOnSelf(selectedSpell);
}

public final void AddToFriends(String player) {
   rs.AddToFriends(player);
}

public final boolean IsOnFriendList(String player) {
     return rs.IsOnFriendList(player);
}
 public boolean inModRoom() {
  return rs.inModRoom();
    
}
 public boolean inCoords(int x1, int y1, int x2, int y2) {
  return rs.inCoords(x1, y1, x2, y2);
    
}
public void BuyShopItem(int id){
    rs.BuyShopItem(id);
}

public void SellShopItem(int id){
    rs.SellShopItem(id);
}
public int FindShopItem(int item) {
   return rs.FindShopItem(item);
}

 

public int ShopCount(int id) {
   return rs.ShopCount(id);
}

 public int ShopSellPrice(int id) {
  return rs.ShopSellPrice(id);
    
}
public int ShopBuyPrice(int id) {
   return rs.ShopBuyPrice(id);
    
}
public void TalkNpc(int i)  {
  if(!rs.loading){
    rs.TalkNpc(i);
    }
}
public void Answer(int i){
   rs.Answer(i);
}
public void DepositItems(int id, int amount) {
	rs.DepositItems(id, amount);
}

   public void HyperCast(int spell, int id) {
rs.HyperCast(spell, id);
}

public void AtObject(int x, int y, boolean left)throws Exception {
   rs.AtObject(x, y, left);
}


public final void AtObject(int x, int y) {
    try {
      if(!rs.loading){
        AtObject(x, y, true);
        }
    } catch (Exception error) {
    }
}

public final void AtObject2(int x, int y) {
  if(!rs.loading){
  rs.AtObject2(x, y);
  }
}
    
   public void prayeron(int l1)
{
rs.prayeron(l1);
}

public void prayeroff(int l1)
{
rs.prayeroff(l1);
} 

    public final void TalkToNpc(int index) {
      if(!rs.loading){
    rs.TalkToNpc(index);
    }
}
public boolean InCombat()
{
return rs.InCombat();
}
public final boolean SleepIfAt(int Fatigue) 
{
   return rs.SleepIfAt(Fatigue);
   
}

public final int GetFatigue() {
      return rs.GetFatigue();
}

public final void PickupItemById(int id) {
  if(!rs.loading){
   rs.PickupItemById(id);
   }
}
public void PickUpById(int id)throws Exception {
  if(!rs.loading){
  rs.PickUpById(id);
  }
}

  public void PickUp(int x, int y, int id)throws Exception {
    if(!rs.loading){
    rs.PickUp(x, y, id);
}}

public void PickUp(int x, int y)throws Exception {
  if(!rs.loading){
    rs.PickUp(x, y);}
}

public long getLastMoved() {
	return rs.lastMovement;
}




    public int[] GetItemById(int id) {
   return rs.GetItemById(id);
}

    public int[] GetItemById(int[] id) {
    return rs.GetItemById(id);
}
public final int CountPlayers() {
            return rs.playerCount;
}
public final String PlayerName(int index) {

    return rs.PlayerName(index);
}
public void use(int i) 
{
rs.use(i);
}
public void WearItem(int i) 
{
rs.WearItem(i);
}


public void RemoveItem(int i) 
{
rs.RemoveItem(i);
}

	public final int inventoryCount(int reqID) {
	return rs.inventoryCount(reqID);
}
public int[] GetNpcById(int[] id) {
  return rs.GetNpcById(id);
}

public int getnpcindexbyid(int id)
{
    return rs.getnpcindexbyid(id);
}

public int[] GetNpcById(int id) {
   return rs.GetNpcById(id);
}    

    public boolean InArray(String sarray[], String s) {
  return rs.InArray(sarray, s);
}

public boolean InArray(int iarray[], int i) {
    return rs.InArray(iarray, i);
}
public int[] GetObjectById(int[] id) {
   return rs.GetObjectById(id);
}


public int[] GetObjectById(int id) {
 
    return rs.GetObjectById(id);
}



public void WalkToWait(int x, int y){
  if(!rs.loading){
    rs.WalkToWait(x, y);
    }
}

public void WalkTo(int x, int y){
  if(!rs.loading){
    rs.WalkTo(x, y);
    }
}
public int GetX() {
		return rs.GetX();
}

public int GetY() {
		return rs.GetY();
}
     public final void CastOnItem(int spell, int pos) {
        try {
            rs.CastOnItem(spell, pos);
        } catch (Exception error) {
        }
    }
  
}
