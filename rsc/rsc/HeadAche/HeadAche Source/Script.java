public abstract class Script
{ 
	public e e1;
	public mudclient rs;
	public Script(mudclient rs)
	{
		this.rs = rs;
	}
	public void start(String command, String parameters[])
	{
	}
	public String[] getCommands()
	{
		return new String[0];
	}
	public int random(int i, int j) { return rs.random(i,j); }
	public boolean inCombat() { return rs.InCombat(); }
	public void MagicPlayer(int spell, int id) { rs.MagicPlayer(spell,id); }
	public void MagicNpc(int spell, int id) { rs.MagicNpc(spell,id); }
	public int GetX() { return (rs.dgc.gmh - 64) / rs.ecj + rs.dil; }
	public int GetY() { return (rs.dgc.gmi - 64) / rs.ecj + rs.dim; }
	public boolean Sleeping() { return rs.ece; }
	public int Fatigue() { return (rs.ehb * 100) / 750; }
	public int GetMaxStat(int i) { return rs.stat[i]; }
	public int GetCurStat(int i) { return rs.curstat[i]; }
	public int Fightmode() { return rs.dck; }
	public void Fightmode(int i) { rs.fightmode(i); }
	public int distFrom(int x, int y) { return ((GetX() - x) - (GetY() - y)); }
	public void WalkTo(int x, int y) { rs.dch[rs.ehk] = 920; rs.eie[rs.ehk] = x - rs.dil; rs.eif[rs.ehk] = y - rs.dim; rs.fal(rs.ehk++); }
	public void Wait(int i) { try { Thread.sleep(i); }catch(Exception e) { } }
	public int objectCount() { return rs.djd; }
	public int objectType(int i) { return rs.eca[i]; }
	public String objectName(int i) { return e1.ahh[i]; }
	public String getObjectCmd1(int i) { return e1.ahj[i]; }
	public String getObjectCmd2(int i) { return e1.ahk[i]; }
	public int objectX(int i) { return (rs.ebm[i] + rs.dil); }
	public int objectY(int i) { return (rs.ebn[i] + rs.dim); }
	public void objectCmd1(int i) { 
	rs.dch[rs.ehk] = 420; 
	rs.eie[rs.ehk] = rs.ebm[i]; 
	rs.eif[rs.ehk] = rs.ebn[i]; 
	rs.dfm[rs.ehk] = rs.ecb[i]; 
	rs.dfn[rs.ehk] = rs.eca[i]; 
	rs.fal(rs.ehk++); 
	}
	public void objectCmd2(int i) { 
	rs.dch[rs.ehk] = 2400; 
	rs.eie[rs.ehk] = rs.ebm[i]; 
	rs.eif[rs.ehk] = rs.ebn[i]; 
	rs.dfm[rs.ehk] = rs.ecb[i]; 
	rs.dfn[rs.ehk] = rs.eca[i];
	rs.fal(rs.ehk++); 
	}
	public int wallObjectCount() { return rs.egn; }
	public int wallObjectType(int i) { return rs.eik[i]; }
	public String wallObjectName(int i) { return e1.akn[i]; }
	public String getWallObjectCmd1(int i) { return e1.alb[i]; }
	public String getWallObjectCmd2(int i) { return e1.alc[i]; }
	public void wallObjectCmd1(int i) { 
	rs.dch[rs.ehk] = 320; 
	rs.eie[rs.ehk] = rs.dgk[i]; 
	rs.eif[rs.ehk] = rs.dgl[i]; 
	rs.dfm[rs.ehk] = rs.eij[i]; 
	rs.fal(rs.ehk++); 
	}
	public void wallObjectCmd2(int i) { 
	rs.dch[rs.ehk] = 2300; 
	rs.eie[rs.ehk] = rs.dgk[i]; 
	rs.eif[rs.ehk] = rs.dgl[i]; 
	rs.dfm[rs.ehk] = rs.eij[i]; 
	rs.fal(rs.ehk++); 
	}
	public int InvCount() { return rs.eja; }
	public int InvCount(int i) { return rs.fce(i); }
	public int itemAtSlot(int i) { return rs.ejb[i]; }
	public String itemName(int i) { return e1.ame[i]; }
	public String getItemCmd(int i) { return e1.amg[i]; }
	public int FindInv(int i) { for(int l = 0; l < InvCount(); l++) { if(itemAtSlot(l) == i) { return i; } } return -1; }
	public void itemCmd(int i) { rs.dch[rs.ehk] = 640; rs.dfm[rs.ehk] = i; rs.fal(rs.ehk++); }
	public void dropItem(int i) { rs.dch[rs.ehk] = 660; rs.dfm[rs.ehk] = i; rs.fal(rs.ehk++); }
	public void useitem(int i) { rs.dch[rs.ehk] = 640; rs.dfm[rs.ehk] = i; rs.fal(rs.ehk++); }
	public void useitemwithgrounditem(int item, int ground) {
		rs.dch[rs.ehk] = 210;
		rs.eie[rs.ehk] = rs.ekj[ground];
		rs.eif[rs.ehk] = rs.ekk[ground];
		rs.dfm[rs.ehk] = rs.ekl[ground];
		rs.dfn[rs.ehk] = item;
		rs.fal(rs.ehk++);
	}
	public boolean isBank() { return rs.emc; }
	public void closeBank() { rs.aag.hdg(64); rs.aag.hde(); rs.emc = false; }
	public int numBankItems() { return rs.dmj; }
	public int bankItemType(int i) { return rs.edb[i]; }
	public int numBankItem(int i) { if(bankItemType(i) < 0) { return 0; } else { return rs.edc[i]; } }
	public int FindBankItem(int i) {
		for(int l = 0; l < numBankItems(); l++) {
			if(bankItemType(l) == i)
				return l;
		}
		return -1;
	}
	public void deposit(int item, int amount) { 
		rs.aag.hdg(152);
		rs.aag.hdj(item);
		rs.aag.hdj(amount);
		rs.aag.hde();
	}
	public void withdraw(int item, int amount) { 
		rs.aag.hdg(179);
		rs.aag.hdj(item);
		rs.aag.hdj(amount);
		rs.aag.hde();
	}
	public boolean isShop() { return rs.dli; }
	public void closeShop() { rs.aag.hdg(1); rs.aag.hde(); rs.djh = false; }
	public int getShopItemType(int i) { return rs.djm[i]; }
	public int FindShopItem(int i) {
		for(int l = 0; l < 39; l++) {
			if(getShopItemType(l) == i)
				return l;
		}
		return -1;
	}
	public int numShopItem(int i) { return rs.djn[i]; }
	public int getItemSalePrice(int i) {
		int mod = rs.dni + rs.dka[i];
        		if(mod < 10)
            		mod = 10;
        		return (mod * e1.ajg[i]) / 100;
        	}
        	public int getItemBuyPrice(int i) {
        		int mod = rs.dni + rs.dka[i];
        		if(mod < 10)
        			mod = 10;
        		return (mod * e1.ajg[i]) / 100;
        	}
	public void sellitem(int i) { 
		rs.aag.hdg(139);
        		rs.aag.hdj(i);
        		rs.aag.hdn(getItemSalePrice(i));
        		rs.aag.hde();
        	}
        	public void buyitem(int i) {
        		rs.aag.hdg(76);
        		rs.aag.hdj(i);
        		rs.aag.hdn(getItemBuyPrice(i));
        		rs.aag.hde();
        	}
        	public int groundItems() { return rs.dkm; }
        	public int groundItemType(int i) { return rs.ekl[i]; }
        	public void takeGroundItem(int i) {
        		rs.dch[rs.ehk] = 220;
        		rs.eie[rs.ehk] = rs.ekj[i];
        		rs.eif[rs.ehk] = rs.ekk[i];
        		rs.dfm[rs.ehk] = rs.ekl[i];
        		rs.fal(rs.ekh++);
        	}
        	public int npcCount() { return rs.dnj; }
        	public int npcType(int i) { return rs.ddi[i].gmj; }
        	public String npcName(int i) { return e1.amb[i]; }
        	public int nearestNpc(int i) { 
        		for(int l = 0; l < npcCount(); l++) {
        			if(npcType(l) == i)
        				return l;
        		}
        	return -1;
        	}
        	public boolean npcInCombat(int i) { return rs.ddi[i].gml == 8 || rs.ddi[i].gml == 9; }
        	public void attackNpc(int i) {
        		rs.dch[rs.ehk] = 715;
            	rs.eie[rs.ehk] = rs.ddi[i].gmh;
            	rs.eif[rs.ehk] = rs.ddi[i].gmi;
            	rs.dfm[rs.ehk] = rs.ddi[i].gmf;
            	rs.fal(rs.ehk++);
	}
	public void talkNpc(int i) {
        		rs.dch[rs.ehk] = 7205;
            	rs.eie[rs.ehk] = rs.ddi[i].gmh;
            	rs.eif[rs.ehk] = rs.ddi[i].gmi;
            	rs.dfm[rs.ehk] = rs.ddi[i].gmf;
            	rs.fal(rs.ehk++);
            }
            public void answer(int i) { 
            	rs.aag.hdg(68);
               	rs.aag.heb(i);
                	rs.aag.hde();
                	rs.dli = false;
                }
                public void debugrs(String s) { rs.feb(s, 3); }
                public boolean running() { return rs.running; }
                public int PlayerByName(String s) {
                	for(int i = 0; i < playerCount(); i++)
		if(rs.ege[i].gme.equals(s))
			 return i;
		return -1; 
	    }
	    public int playerCount() { return rs.efg; }
	    public String getPlayerName(int i) { return rs.ege[i].gme; }
	    public void attackPlayer(int i) {
		rs.dch[rs.ehk] = 805;
		rs.eie[rs.ehk] = rs.ege[i].gmh;
		rs.eif[rs.ehk] = rs.ege[i].gmi;
		rs.dfm[rs.ehk] = rs.ege[i].gmf;
		rs.fal(rs.ehk++);
	   }
	   public int playerDestinationX(int i) {
		int i1 = rs.ege[i].gna;
		if(i1 + 1 % 10 == rs.ege[i].gmn)
           			return (rs.ege[i].gmh - 64) / rs.ecj + rs.dil;
		return (rs.ege[i].gnb[i1] - 64) / rs.ecj + rs.dil;
               }
               public int playerDestinationY(int i) {
		int i1 = rs.ege[i].gna;
		if(i1 + 1 % 10 == rs.ege[i].gmn)
           			return (rs.ege[i].gmi - 64) / rs.ecj + rs.dim;
		return (rs.ege[i].gnb[i1] - 64) / rs.ecj + rs.dim;
               }
	   public int playerX(int i) { return (rs.ege[i].gmh - 64) / rs.ecj + rs.dil; }
	   public int playerY(int i) { return (rs.ege[i].gmi - 64) / rs.ecj + rs.dim; }
	   public String PlayerRemembered() { 
	   		return rs.PlayerName;
	   }
	   public boolean PlayerHPBar(int i) {
	   	if(rs.ege[i].gnl > 0)
	   		return true;
	   	else
	   		return false;
	   }
}